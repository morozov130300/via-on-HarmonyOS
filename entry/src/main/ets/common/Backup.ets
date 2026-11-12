import { fileIo } from '@kit.CoreFileKit'
import zlib from '@ohos.zlib'
import { BusinessError } from '@kit.BasicServicesKit'
import { BrowserDb } from './Database'
import { AppSettings, SavedTab } from './Settings'
import { BackupSettings } from './BackupSettings'
import { TabStore } from './TabStore'
import { ClosedTabsStore, ClosedTabEntry } from './ClosedTabsStore'
import { ZipStoreWriter } from './ZipWriter'
import { BackupCrypto } from './BackupCrypto'
import { BookmarkRec, BookmarkFolderRec } from './Types'
import { parseBookmarksHtml, buildBookmarksHtml, remapForMerge, flattenForLegacyExport,
  ParsedBookmarkTree } from './BookmarkHtml'

// settings.txt 附带文件（script-*.txt / filters-*.txt / filters-custom.txt）
class SettingsAttachment {
  name: string
  content: string

  constructor(name: string, content: string) {
    this.name = name
    this.content = content
  }
}

// Java String.hashCode（int32 溢出语义）
function javaStringHash(s: string): number {
  let h = 0
  for (let i = 0; i < s.length; i++) {
    h = (Math.imul(h, 31) + s.charCodeAt(i)) | 0
  }
  return h
}

// data-for-older-versions.txt 的键序复刻：l9/d.a 用 HashMap 装载七键，
// org.json.JSONObject(HashMap) 按 HashMap 迭代序输出（容量 16，桶序 + 链序）
function javaHashMapOrderedRecord(source: Record<string, Object>): Record<string, Object> {
  const keys = Object.keys(source)
  const buckets: string[][] = []
  for (let i = 0; i < 16; i++) {
    buckets.push([])
  }
  for (let i = 0; i < keys.length; i++) {
    const h = javaStringHash(keys[i])
    buckets[(h ^ (h >>> 16)) & 15].push(keys[i])
  }
  const ordered: Record<string, Object> = {}
  for (let i = 0; i < 16; i++) {
    for (let j = 0; j < buckets[i].length; j++) {
      const key = buckets[i][j]
      ordered[key] = source[key]
    }
  }
  return ordered
}

// 整数字符串判定（文件夹/父目录 id 解析）
function isIntegerString(s: string): boolean {
  return /^[+-]?\d+$/.test(s)
}

// 原版 mark.uia.data.backup2.ZipBackupManager 全量导出/还原 1:1 移植
// （全部原版方法已亲自核实）：
// - ZipBackupManager.b（:116-204）：条目顺序 info.enc → bookmarks.html →
//   favorites.txt → icons.zip → history.txt → tabs.txt → settings.txt(+附件)
//   → pass.enc → data-for-older-versions.txt
// - ZipBackupManager.e（:254-312）：还原 handler 序 d,f,g,m,l（mode 0），
//   pass.enc 仅在提供密码时解密，data-for-older 不恢复（m9/e.b 为空）
// - m9/d（bookmarks.html 导出条件：文件夹+书签非全空；导入 mode0 =
//   p.p 重映射 + o9/g.x 合并，无 clear）
// - m9/f（favorites.txt + icons.zip；导入：空行中止、坏 JSON 中止收集但
//   仍合并已收集项、url 为空跳过、icons 解压后按文件存在回写）
// - m9/g（history.txt；导入：空行/坏 JSON 跳过、url 为空跳过、mode0 无 clear）
// - m9/m（tabs.txt；导入：空行/坏 JSON 跳过、url 为空跳过、追加去重）
// - m9/i（pass.csv 表头 name,url,username,password,note → AES → pass.enc）
// - m9/e（(flags&31)==31 时写 data-for-older-versions.txt =
//   JSONObject(l9/d.a(...,false)).toString()）
// - l9/a..j（七键值；z10=false 时值原样，均为 base64(trim(...))）
// - z8/w3.r/l（图标文件名 r(url)：空=untitled、http(s) 取 host 小写、
//   其余 md5hex(小写)）
// 时间制：原版秒、本工程毫秒（导出 /1000、导入 *1000；history 例外——
// 本工程 history.visited 即秒，导出原样、导入原样）
export class BackupManager {
  private static instance: BackupManager | null = null

  static getInstance(): BackupManager {
    if (BackupManager.instance === null) {
      BackupManager.instance = new BackupManager()
    }
    return BackupManager.instance
  }

  async buildBackupJson(): Promise<string> {
    const db = BrowserDb.getInstance()
    const bookmarks = await db.listAllBookmarks()
    const history = await db.listHistory()
    const bookmarkPayload: Record<string, Object>[] = []
    for (let i = 0; i < bookmarks.length; i++) {
      const item = bookmarks[i]
      const entry: Record<string, Object> = {}
      entry['title'] = item.title
      entry['url'] = item.url
      entry['created'] = item.created
      entry['folder'] = item.folder
      entry['folderId'] = item.folderId
      entry['ordering'] = item.ordering
      entry['updatedAt'] = item.updatedAt
      bookmarkPayload.push(entry)
    }
    const historyPayload: Record<string, Object>[] = []
    for (let i = 0; i < history.length; i++) {
      const item = history[i]
      const entry: Record<string, Object> = {}
      entry['title'] = item.title
      entry['url'] = item.url
      entry['visited'] = item.visited
      historyPayload.push(entry)
    }
    const settings = AppSettings.getInstance()
    const kv: Record<string, Object> = await settings.buildSyncKv()
    const backup: Record<string, Object> = {}
    backup['version'] = 1
    backup['ts'] = Date.now()
    backup['bookmarks'] = bookmarkPayload
    backup['history'] = historyPayload
    backup['settings'] = kv
    return JSON.stringify(backup)
  }

  // 豁免项12：云备份(JSON)恢复必须是合并语义——书签按 url replaceBookmarkByUrl
  //（云端覆盖同 url、本地独有保留），历史按 url 去重追加（addHistoryWithTime 同款
  // delete+insert 语义），文件夹结构保留；禁止清空重插完全按云端推翻本地数据。
  async applyBackupJson(raw: string): Promise<void> {
    const parsed = JSON.parse(raw) as Record<string, Object>
    const db = BrowserDb.getInstance()
    const bookmarkRaw = parsed['bookmarks']
    if (Array.isArray(bookmarkRaw)) {
      const items = bookmarkRaw as Object[]
      for (let i = 0; i < items.length; i++) {
        const element = items[i] as Record<string, Object>
        const title = element['title']
        const url = element['url']
        if (typeof title === 'string' && typeof url === 'string' && url !== '') {
          const rec = new BookmarkRec()
          rec.title = title
          rec.url = url
          const folder = element['folder']
          rec.folder = typeof folder === 'string' ? folder : ''
          const folderId = element['folderId']
          rec.folderId = typeof folderId === 'number' ? folderId : 0
          const ordering = element['ordering']
          rec.ordering = typeof ordering === 'number' ? ordering : 0
          const created = element['created']
          rec.created = typeof created === 'number' ? created : Math.floor(Date.now() / 1000)
          const updatedAt = element['updatedAt']
          rec.updatedAt = typeof updatedAt === 'number' ? updatedAt : rec.created
          rec.id = -1
          await db.replaceBookmarkByUrl(rec)
        }
      }
    }
    const historyRaw = parsed['history']
    if (Array.isArray(historyRaw)) {
      const items = historyRaw as Object[]
      for (let i = 0; i < items.length; i++) {
        const element = items[i] as Record<string, Object>
        const title = element['title']
        const url = element['url']
        if (typeof title === 'string' && typeof url === 'string' && url !== '') {
          const visited = element['visited']
          await db.addHistoryWithTime(title, url, typeof visited === 'number' ? visited : Math.floor(Date.now() / 1000))
        }
      }
    }
    const kv = parsed['settings']
    if (typeof kv === 'object' && kv !== null) {
      await AppSettings.getInstance().applyBackupKv(kv as Record<string, Object>)
    }
  }

  // 原版 hb/c4.k3 位表：0→2书签 1→4主页收藏 2→8历史 3→16关闭的标签页 4→1设置 5→32保存的密码
  static readonly EXPORT_BIT_SETTINGS: number = 1
  static readonly EXPORT_BIT_BOOKMARKS: number = 2
  static readonly EXPORT_BIT_FAVORITES: number = 4
  static readonly EXPORT_BIT_HISTORY: number = 8
  static readonly EXPORT_BIT_TABS: number = 16
  static readonly EXPORT_BIT_PASSWORDS: number = 32

  // ZipBackupManager.b（:150）：uuid = UUID.randomUUID().toString().replace("-","")
  private randomUuid32(): string {
    let s = ''
    for (let i = 0; i < 32; i++) {
      s += Math.floor(Math.random() * 16).toString(16)
    }
    return s
  }

  // z8/w3.r（:292-310）：图标文件基名
  // 空→"untitled"；http(s)（i6/i0.m/n，长度>6/>7 前缀忽略大小写）→ host 小写
  // （截到首个 '/'，无则 '?'，再无则串尾，且 end>start 才取 host）；其余→md5hex(小写)
  private async iconBaseName(url: string): Promise<string> {
    if (url === '') {
      return 'untitled'
    }
    let httpLike = false
    if (url.length > 6 && url.substring(0, 7).toLowerCase() === 'http://') {
      httpLike = true
    } else if (url.length > 7 && url.substring(0, 8).toLowerCase() === 'https://') {
      httpLike = true
    }
    if (httpLike) {
      const start = url.indexOf('://') + 3
      let end = url.indexOf('/', start)
      if (end < 0) {
        end = url.indexOf('?', start)
      }
      if (end < 0) {
        end = url.length
      }
      if (end > start) {
        return url.substring(start, end).toLowerCase()
      }
    }
    return await BackupCrypto.md5Hex(url.toLowerCase())
  }

  // ZipBackupManager.b：按位打包 ZIP；bit32 时 password 非 null（经密码弹窗）
  async buildZipBackup(flags: number, context: Context, password: string | null): Promise<string> {
    if (flags === 0) {
      throw new Error('no export scope selected')
    }
    const db = BrowserDb.getInstance()
    const writer = new ZipStoreWriter()
    const stamp = Date.now()

    // ---- info.enc（bit32 最先；uuid 同时作 PBKDF2 盐）----
    let uuid: string | null = null
    if (password !== null && (flags & BackupManager.EXPORT_BIT_PASSWORDS) !== 0) {
      uuid = this.randomUuid32()
      writer.addBytes('info.enc', BackupCrypto.xorInfo(uuid))
    }

    // ---- bookmarks.html（m9/d.a：文件夹+书签非全空才产出）----
    let folders: BookmarkFolderRec[] = []
    let bookmarks: BookmarkRec[] = []
    if ((flags & BackupManager.EXPORT_BIT_BOOKMARKS) !== 0) {
      folders = await db.listAllBookmarkFolders()
      bookmarks = await db.listAllBookmarks()
      if (folders.length > 0 || bookmarks.length > 0) {
        writer.addText('bookmarks.html', buildBookmarksHtml(folders, bookmarks))
      }
    }

    // ---- favorites.txt + icons.zip（m9/f.a）----
    if ((flags & BackupManager.EXPORT_BIT_FAVORITES) !== 0) {
      const favs = await db.listHomeFavs()
      if (favs.length > 0) {
        let favText = ''
        for (let i = 0; i < favs.length; i++) {
          const item = favs[i]
          const obj: Record<string, Object> = {}
          obj['title'] = item.title
          obj['url'] = item.url
          obj['order'] = item.position
          favText += JSON.stringify(obj) + '\n'
        }
        writer.addText('favorites.txt', favText)
        // icons.zip：w3.l 派生路径的图标文件存在才打包，条目数>0 才产出
        const iconWriter = new ZipStoreWriter()
        let iconCount = 0
        for (let i = 0; i < favs.length; i++) {
          const item = favs[i]
          if (item.icon === '') {
            continue
          }
          const iconPath = item.icon.startsWith('file://') ? item.icon.substring(7) : item.icon
          try {
            if (!fileIo.statSync(iconPath).isFile()) {
              continue
            }
          } catch (error) {
            continue
          }
          const name = `${await this.iconBaseName(item.url)}.png`
          iconWriter.addBytes(name, this.readFileBytes(iconPath))
          iconCount++
        }
        if (iconCount > 0) {
          writer.addBytes('icons.zip', iconWriter.toBytes())
        }
      }
    }

    // ---- history.txt（m9/g.a：非空才产出）----
    if ((flags & BackupManager.EXPORT_BIT_HISTORY) !== 0) {
      const history = await db.listHistory()
      if (history.length > 0) {
        let historyText = ''
        for (let i = 0; i < history.length; i++) {
          const item = history[i]
          const obj: Record<string, Object> = {}
          obj['title'] = item.title
          obj['url'] = item.url
          obj['updated_at'] = item.visited
          historyText += JSON.stringify(obj) + '\n'
        }
        writer.addText('history.txt', historyText)
      }
    }

    // ---- tabs.txt（m9/m.a：数据源 = 最近关闭标签库 na.h.g()，非当前打开标签）----
    if ((flags & BackupManager.EXPORT_BIT_TABS) !== 0) {
      await ClosedTabsStore.getInstance().ensureInit()
      const closed = ClosedTabsStore.getInstance().entries
      let tabsText = ''
      for (let i = 0; i < closed.length; i++) {
        const entry = closed[i]
        if (entry.url === '' || entry.url === 'about:blank') {
          continue
        }
        const obj: Record<string, Object> = {}
        obj['title'] = entry.title
        obj['url'] = entry.url
        obj['updated_at'] = entry.time
        tabsText += JSON.stringify(obj) + '\n'
      }
      if (tabsText !== '') {
        writer.addText('tabs.txt', tabsText)
      }
    }

    // ---- settings.txt + 附件（m9/l.a：settings.txt 条目最先，附件随后）----
    if ((flags & BackupManager.EXPORT_BIT_SETTINGS) !== 0) {
      const attachments: SettingsAttachment[] = []
      const settingsTxt = await BackupSettings.buildSettingsTxt(AppSettings.getInstance(), context,
        (name: string, content: string): void => {
          attachments.push(new SettingsAttachment(name, content))
        })
      writer.addText('settings.txt', settingsTxt)
      for (let i = 0; i < attachments.length; i++) {
        writer.addText(attachments[i].name, attachments[i].content)
      }
    }

    // ---- pass.enc（m9/i.a：pass.csv 表头 + AES/CBC → pass.enc）----
    if (password !== null && uuid !== null && (flags & BackupManager.EXPORT_BIT_PASSWORDS) !== 0) {
      // z8/w0.j：PBKDF2WithHmacSHA1(password, salt=UTF-8(uuid), 10000, 256bit)
      const key = BackupCrypto.pbkdf2Sha1(password, BackupCrypto.utf8Encode(uuid), 10000, 32)
      // 用户拍板豁免：本工程无密码数据，勾选 bit32 时导出不含密码条目，
      // 仅写 CSV 表头以维持安卓端 pass.enc 格式可解析（真互通）
      const csv = 'name,url,username,password,note\n'
      const enc = await BackupCrypto.aesCbcEncrypt(key, BackupCrypto.utf8Encode(csv))
      writer.addBytes('pass.enc', enc)
    }

    // ---- data-for-older-versions.txt（m9/e.a：(flags&31)==31 才产出）----
    if ((flags & 31) === 31) {
      const values: Record<string, Object> = {}
      const s = AppSettings.getInstance()
      const state = BackupSettings.collectExportState(s)
      // l9/a（adrules）：u4/a.c(-1) → {custom?, subscribed?}，空对象→""
      const adrulesObj: Record<string, Object> = {}
      if (s.customRulesText !== '') {
        adrulesObj['custom'] = s.customRulesText
      }
      if (s.ruleSubscriptions.length > 0) {
        let subbed = ''
        for (let i = 0; i < s.ruleSubscriptions.length; i++) {
          const sub = s.ruleSubscriptions[i]
          if (sub.url === '') {
            continue
          }
          subbed += JSON.stringify({ 'url': sub.url } as Record<string, Object>) + '\n'
        }
        adrulesObj['subscribed'] = subbed
      }
      values['adrules'] = Object.keys(adrulesObj).length === 0 ? ''
        : BackupCrypto.base64Wrap76(BackupCrypto.utf8Encode(JSON.stringify(adrulesObj)))
      // l9/b（bookmark）：p.d 展平行 → trim → Base64
      const flat = flattenForLegacyExport(folders, bookmarks)
      values['bookmark'] = flat === '' ? ''
        : BackupCrypto.base64Wrap76(BackupCrypto.utf8Encode(flat))
      // l9/f（settings）：L2(false).toString().trim() → Base64
      values['settings'] = BackupCrypto.base64Wrap76(BackupCrypto.utf8Encode(
        JSON.stringify(BackupSettings.buildSettingsRecord(s, state))))
      // l9/h（other）：脚本倒序，行 {scriptId,enabled,url,codeV2} → trim → Base64
      let scriptText = ''
      for (let i = s.userScripts.length - 1; i >= 0; i--) {
        const script = s.userScripts[i]
        const obj: Record<string, Object> = {}
        obj['scriptId'] = String(script.id)
        obj['enabled'] = script.enabled
        obj['url'] = script.downloadUrl
        obj['codeV2'] = script.code
        scriptText += JSON.stringify(obj) + '\n'
      }
      values['other'] = BackupCrypto.base64Wrap76(BackupCrypto.utf8Encode(scriptText.trim()))
      // l9/e（favorite）：行 {title,url,order} → trim → Base64
      const favs = await db.listHomeFavs()
      let favOlderText = ''
      for (let i = 0; i < favs.length; i++) {
        const obj: Record<string, Object> = {}
        obj['title'] = favs[i].title
        obj['url'] = favs[i].url
        obj['order'] = favs[i].position
        favOlderText += JSON.stringify(obj) + '\n'
      }
      values['favorite'] = BackupCrypto.base64Wrap76(BackupCrypto.utf8Encode(favOlderText.trim()))
      // l9/i（kvdata）：settingsData 记录数组（比较基准均为 uachoice，原版如此）
      values['kvdata'] = BackupCrypto.base64Wrap76(BackupCrypto.utf8Encode(
        JSON.stringify(BackupSettings.settingsDataRecords(s, state, 1))))
      // l9/j（conf）：host → siteConf 序列化
      values['conf'] = BackupCrypto.base64Wrap76(BackupCrypto.utf8Encode(
        JSON.stringify(BackupSettings.siteConfMap(s))))
      writer.addText('data-for-older-versions.txt',
        JSON.stringify(javaHashMapOrderedRecord(values)))
    }

    const zipPath = `${context.cacheDir}/Uia_导出数据_${stamp}.zip`
    await writer.writeTo(zipPath)
    return zipPath
  }

  private readFileBytes(path: string): Uint8Array {
    const file = fileIo.openSync(path, fileIo.OpenMode.READ_ONLY)
    try {
      const stat = fileIo.statSync(file.fd)
      const buf = new ArrayBuffer(stat.size)
      fileIo.readSync(file.fd, buf)
      return new Uint8Array(buf)
    } finally {
      fileIo.closeSync(file)
    }
  }

  // ZipBackupManager.e：安卓端导出的 .zip 备份还原（mode 0）
  async restoreFromZipBackup(uri: string, context: Context): Promise<void> {
    const stamp = Date.now().toString()
    const zipPath = `${context.cacheDir}/backup_import_${stamp}.zip`
    const outDir = `${context.cacheDir}/backup_import_${stamp}`
    try {
      const srcFile = fileIo.openSync(uri, fileIo.OpenMode.READ_ONLY)
      try {
        fileIo.copyFileSync(srcFile.fd, zipPath)
      } finally {
        fileIo.closeSync(srcFile)
      }
      await zlib.decompressFile(zipPath, outDir)
      const entryPath = (name: string): string | null => {
        // compressFile 打包目录时条目可能带一层目录前缀，根目录找不到时向下找一级
        const candidates: string[] = [`${outDir}/${name}`]
        try {
          const entries = fileIo.listFileSync(outDir)
          for (let i = 0; i < entries.length; i++) {
            const entry = entries[i]
            try {
              if (fileIo.statSync(`${outDir}/${entry}`).isDirectory()) {
                candidates.push(`${outDir}/${entry}/${name}`)
              }
            } catch (error) {
            }
          }
        } catch (error) {
        }
        for (let i = 0; i < candidates.length; i++) {
          try {
            if (fileIo.statSync(candidates[i]).isFile()) {
              return candidates[i]
            }
          } catch (error) {
          }
        }
        return null
      }
      const readEntryText = (name: string): string | null => {
        const path = entryPath(name)
        return path !== null ? fileIo.readTextSync(path) : null
      }
      const db = BrowserDb.getInstance()

      // ---- m9/d.b（mode 0）：bookmarks.html 解析 + p.p 重映射 + o9/g.x 合并 ----
      const bookmarksHtml = readEntryText('bookmarks.html')
      if (bookmarksHtml !== null) {
        const tree = parseBookmarksHtml(bookmarksHtml)
        if (tree.folders.length > 0 || tree.bookmarks.length > 0) {
          await this.mergeParsedBookmarkTree(tree)
        }
      }

      // ---- m9/f.b（mode 0）：favorites.txt 合并，随后 icons.zip 解压 ----
      const favText = readEntryText('favorites.txt')
      if (favText !== null) {
        const favs: Record<string, Object>[] = []
        let aborted = false
        const lines = favText.split('\n')
        for (let i = 0; i < lines.length; i++) {
          const line = lines[i]
          if (line === '') {
            // 原版空行 return：中止合并与 icons（行尾空行即 readLine 的 null/EOF）
            aborted = true
            break
          }
          try {
            const obj = JSON.parse(line) as Record<string, Object>
            const title = obj['title']
            const url = obj['url']
            const order = obj['order']
            if (typeof title === 'string' && typeof url === 'string' && url !== '') {
              const rec: Record<string, Object> = {}
              rec['title'] = title
              rec['url'] = url
              rec['order'] = typeof order === 'number' ? order : 0
              favs.push(rec)
            }
          } catch (error) {
            // 原版 JSONException 逃逸出循环：中止收集，仍合并已收集项
            break
          }
        }
        if (!aborted) {
          for (let i = 0; i < favs.length; i++) {
            await db.replaceHomeFavByUrl(favs[i]['title'] as string, favs[i]['url'] as string,
              favs[i]['order'] as number)
          }
          // icons.zip：解压后按 w3.r 派生文件名回写收藏 icon
          const iconsEntry = entryPath('icons.zip')
          if (iconsEntry !== null) {
            await this.restoreIconsZip(iconsEntry, context)
          }
        }
      }

      // ---- m9/g.b（mode 0）：history.txt 逐行合并，空行/坏行跳过 ----
      const historyText = readEntryText('history.txt')
      if (historyText !== null) {
        const lines = historyText.split('\n')
        for (let i = 0; i < lines.length; i++) {
          const line = lines[i]
          if (line === '') {
            continue
          }
          try {
            const obj = JSON.parse(line) as Record<string, Object>
            const title = obj['title']
            const url = obj['url']
            const updatedAt = obj['updated_at']
            if (typeof title === 'string' && typeof url === 'string' && url !== '') {
              await db.addHistoryWithTime(title, url, typeof updatedAt === 'number' ? updatedAt : 0)
            }
          } catch (error) {
            console.error(`restore history line failed: ${(error as BusinessError).message}`)
          }
        }
      }

      // ---- m9/m.b：tabs.txt 逐行收集，追加去重 ----
      const tabsText = readEntryText('tabs.txt')
      if (tabsText !== null) {
        const saved: SavedTab[] = []
        const lines = tabsText.split('\n')
        for (let i = 0; i < lines.length; i++) {
          const line = lines[i]
          if (line === '') {
            continue
          }
          try {
            const obj = JSON.parse(line) as Record<string, Object>
            const title = obj['title']
            const url = obj['url']
            if (typeof url === 'string' && url !== '') {
              saved.push(new SavedTab(url, false, typeof title === 'string' ? title : ''))
            }
          } catch (error) {
            console.error(`restore tab line failed: ${(error as BusinessError).message}`)
          }
        }
        if (saved.length > 0) {
          // m9/m.b：解析后 na.h.e(list) 入最近关闭标签库（按 URL 去重），非当前标签
          const closedItems: ClosedTabEntry[] = []
          for (let i = 0; i < saved.length; i++) {
            closedItems.push(new ClosedTabEntry('', saved[i].url, saved[i].title, Date.now()))
          }
          await ClosedTabsStore.getInstance().ensureInit()
          ClosedTabsStore.getInstance().addAllDedup(closedItems)
        }
      }

      // ---- m9/l.b：settings.txt 恢复（含附件 script-*/filters-* 读取）----
      const settingsText = readEntryText('settings.txt')
      if (settingsText !== null) {
        await BackupSettings.applySettingsTxt(settingsText, readEntryText,
          AppSettings.getInstance(), context)
      }
      // pass.enc / data-for-older-versions.txt：原版导入不恢复（m9/e.b 为空、
      // pass.enc 仅在提供密码时解密），跳过
    } finally {
      try {
        fileIo.unlinkSync(zipPath)
      } catch (error) {
      }
      try {
        fileIo.rmdirSync(outDir)
      } catch (error) {
      }
    }
  }

  // icons.zip 还原：解压到临时目录，把文件复制到 filesDir/icon/，
  // 并对命中 w3.r 派生名的收藏回写 icon 路径
  private async restoreIconsZip(iconsZipPath: string, context: Context): Promise<void> {
    const stamp = Date.now().toString()
    const tempZip = `${context.cacheDir}/icons_import_${stamp}.zip`
    const extractDir = `${context.cacheDir}/icons_import_${stamp}`
    const destDir = `${context.filesDir}/icon`
    try {
      fileIo.copyFileSync(iconsZipPath, tempZip)
      await zlib.decompressFile(tempZip, extractDir)
      try {
        fileIo.accessSync(destDir)
      } catch (error) {
        fileIo.mkdirSync(destDir)
      }
      const db = BrowserDb.getInstance()
      const favs = await db.listHomeFavs()
      const entries = fileIo.listFileSync(extractDir)
      for (let i = 0; i < entries.length; i++) {
        const name = entries[i]
        const srcPath = `${extractDir}/${name}`
        try {
          if (!fileIo.statSync(srcPath).isFile()) {
            continue
          }
        } catch (error) {
          continue
        }
        for (let j = 0; j < favs.length; j++) {
          const fav = favs[j]
          const base = await this.iconBaseName(fav.url)
          if (name === `${base}.png`) {
            const destPath = `${destDir}/${name}`
            fileIo.copyFileSync(srcPath, destPath)
            await db.setHomeFavIconByUrl(fav.url, `file://${destPath}`)
            break
          }
        }
      }
    } finally {
      try {
        fileIo.unlinkSync(tempZip)
      } catch (error) {
      }
      try {
        fileIo.rmdirSync(extractDir)
      } catch (error) {
      }
    }
  }

  // 导入书签 HTML（设置页「导入书签」入口）：与 zip 还原同款合并语义
  async importBookmarksHtml(html: string): Promise<void> {
    const tree = parseBookmarksHtml(html)
    if (tree.folders.length === 0 && tree.bookmarks.length === 0) {
      return
    }
    await this.mergeParsedBookmarkTree(tree)
  }

  // o9/e.z + o9/g.x（mode 0 合并）：先 p.p 重映射（按 标题+父目录 匹配既有目录），
  // 文件夹按 _id 删+插、书签按 url 删+插；新目录建 id 映射；时间秒→毫秒
  private async mergeParsedBookmarkTree(tree: ParsedBookmarkTree): Promise<void> {
    const db = BrowserDb.getInstance()
    const existing = await db.listAllBookmarkFolders()
    remapForMerge(tree, existing)
    // 解析 id → 实际落库 id（'f'+序号 新建后登记；数字 id 原样）
    const idMap: Record<string, number> = {}
    // tree.folders 父先于子（</H3> 不弹栈、</DL> 仅 break），顺序处理即可
    for (let i = 0; i < tree.folders.length; i++) {
      const pf = tree.folders[i]
      const parentId = this.resolveParsedParentId(pf.parent, idMap)
      const rec = new BookmarkFolderRec()
      if (isIntegerString(pf.id)) {
        rec.id = Number(pf.id)
      } else {
        // 新目录：addBookmarkFolder 返回 rowId（INTEGER PRIMARY KEY 即 id）
        rec.id = await db.addBookmarkFolder(pf.title, parentId)
      }
      rec.title = pf.title
      rec.parentId = parentId
      rec.ordering = pf.ordering
      rec.created = pf.created * 1000
      await db.replaceBookmarkFolderById(rec)
      idMap[pf.id] = rec.id
    }
    for (let i = 0; i < tree.bookmarks.length; i++) {
      const pb = tree.bookmarks[i]
      const rec = new BookmarkRec()
      rec.id = -1
      rec.title = pb.title
      rec.url = pb.url
      rec.folder = ''
      rec.folderId = this.resolveParsedParentId(pb.parent, idMap)
      rec.ordering = pb.ordering
      rec.created = pb.created * 1000
      rec.updatedAt = pb.updatedAt * 1000
      await db.replaceBookmarkByUrl(rec)
    }
  }

  // 父目录 id 解析：''→0；数字→原值；'f'+序号→映射（缺省 0）
  private resolveParsedParentId(parent: string, idMap: Record<string, number>): number {
    if (parent === '') {
      return 0
    }
    if (isIntegerString(parent)) {
      return Number(parent)
    }
    const mapped = idMap[parent]
    return mapped !== undefined ? mapped : 0
  }

  async listBookmarksForExport(): Promise<string> {
    const db = BrowserDb.getInstance()
    const folders = await db.listAllBookmarkFolders()
    const bookmarks = await db.listAllBookmarks()
    return buildBookmarksHtml(folders, bookmarks)
  }
}
