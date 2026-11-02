import { fileIo } from '@kit.CoreFileKit'
import { AppSettings, CustomEngineRec } from './Settings'
import { SiteSetting, UserScriptRec, RuleSubEntry } from './Types'
import { CustomUaEntry } from './UaTable'
import { engineIdFromKey, builtinKeyById } from './SearchEngines'
import { BackupCrypto } from './BackupCrypto'

// 导出时搜索引擎/UA 状态（m9/l.c 与 l9/f 共用 w9.l.L2 数据源）
export interface SettingsExportState {
  search2: number
  selectedEngine: CustomEngineRec | null
  uastring: string
  uachoice: number
  skipUaRecordIdx: number
}

// 原版 m9/l.a：settings.txt 导出（1:1）
// 行序：meta → settings → settingsData → siteConf → script → filters
// 每行格式 {"<type>":{...}}\n（m9/l.q）
//
// 已亲自核实的原版依据：
// - m9/l.java a/e/c/g/h/f/d/q（行序与各生成器）
// - w9/k.java L2(405)/j1(1056)（settings 白名单导出/导入）
// - w9/i.java（白名单：boolean[nightcss]；String 15 键；int 41 键；long 2 键）
// - ja/c.java w()/n()（settingsData 序列化：id/title/content/note/flag/type/
//   lastUpdatedAt/createdAt，putOpt 跳过 null）
// - m9/l.g：type1 且 uachoice==id 的当前 UA 记录跳过；type2 且 search2==id 的
//   当前引擎记录加 "selected":true
// - ba/c.java l()（siteConf 序列化：uastring?/uachoice?/enabled?/textsize?/flags）
// - ba/b.java（S(1) 启用、Z(2) JS、X(4) 图像、M(16) 广告拦截、U/H 位集写法）
// - z8/b4.java b()（预设 UA id：0 默认 / -1..-8）
// - z8/c0.java f() 恒 true → searchtoolbardisabled 默认 "-1,-10"、appflag 默认含 1024
// - w9/p.java（webflag 位布局，默认 96495261）、w9/a.java（appflag 默认 1250）、
//   w9/o.java（webflag2 仅 bit1 = 自定义 UA 兼容规整，k.java:393 → b4.c 第 7 参）
// - m9/l.d（:249-286）：filters 行遍历全部订阅（url 恒写、title?/enabled? 仅非空/true，
//   规则文件存在时 path/size/lastUpdated 并打包文件；path = "filters-" + m9/l.i(title)
//   + z8/v0.g(url) 小写 md5hex + ".txt"）；custom 仅打包 filters-custom.txt 文件不写行
// - l9/*（data-for-older-versions 七键）与 w4/c.o()（:172-190 订阅行：
//   title/url/homepage/license/filePath/enabled?/size?）
export class BackupSettings {
  // 原版 z8/b4.b：预设 UA id 表（键为本工程 uaKey）
  private static readonly UA_PRESET_CHOICE: Record<string, number> = {
    'default': 0,
    'android_phone': -1,
    'android_tablet': -2,
    'win_chrome': -3,
    'win_ie11': -4,
    'mac': -5,
    'iphone': -6,
    'ipad': -7,
    'symbian': -8
  }

  // 原版 w9/k.l0 默认 uachoice=0；桌面 UA：z8/b4.c duachoice 0=默认（Win Chrome）
  private static readonly DESKTOP_UA_CHOICE: Record<string, number> = {
    'win_chrome': 0,
    'win_ie11': -4,
    'mac': -5
  }

  private static bit(value: number, mask: number, on: boolean): number {
    return on ? (value | mask) : (value & ~mask)
  }

  // m9/l.q：单行序列化（obj 为空跳过）
  private static line(type: string, obj: Record<string, Object>): string {
    if (obj === null) {
      return ''
    }
    const wrapper: Record<string, Object> = {}
    wrapper[type] = obj
    return JSON.stringify(wrapper) + '\n'
  }

  // m9/l.i：文件名清洗（trim → 非法字符与空白替换为 '-' → 连续 '-' 合并 →
  // 小写 → 截断 128 → 追加 '-'；空返回 ''）
  private static namePrefix(name: string | null): string {
    if (name === null || name === '') {
      return ''
    }
    let cleaned = name.trim().replace(/[\\/:*?"<>|\s]/g, '-').replace(/-{2,}/g, '-').toLowerCase()
    if (cleaned.length > 128) {
      cleaned = cleaned.substring(0, 128)
    }
    if (cleaned === '') {
      return ''
    }
    return cleaned + '-'
  }

  // 搜索引擎 + UA 导出状态（m9/l.c 前置计算，l9 复用）
  static collectExportState(s: AppSettings): SettingsExportState {
    let search2 = engineIdFromKey(s.engineKey)
    let selectedEngine: CustomEngineRec | null = null
    if (search2 === null) {
      const rec = s.resolveCustomEngineKey(s.engineKey)
      selectedEngine = rec
      search2 = rec !== null ? rec.id : -2
    } else if (search2 >= 1) {
      selectedEngine = s.resolveCustomEngineKey(s.engineKey)
    }
    let uachoice = 0
    const preset = BackupSettings.UA_PRESET_CHOICE[s.uaKey]
    if (preset !== undefined) {
      uachoice = preset
    }
    let uastring = ''
    let skipUaRecordIdx = -1
    if (s.uaKey === 'custom') {
      uastring = s.customUa.replace(/[\t\r\n]/g, ' ')
      for (let i = 0; i < s.customUaList.length; i++) {
        if (s.customUaList[i].ua === s.customUa) {
          skipUaRecordIdx = i
          uachoice = i + 1
          break
        }
      }
      if (skipUaRecordIdx < 0) {
        uachoice = 1
      }
    }
    const state: SettingsExportState = {
      search2: search2,
      selectedEngine: selectedEngine,
      uastring: uastring,
      uachoice: uachoice,
      skipUaRecordIdx: skipUaRecordIdx
    }
    return state
  }

  // w9/k.L2(false)：settings 行对象（m9/l.c 与 l9/f 同源复用）
  static buildSettingsRecord(s: AppSettings, state: SettingsExportState): Record<string, Object> {
    // webflag（w9/p 默认 96495261）：
    // bit0 菜单快捷开关 / bit8 JavaScript / bit16 显示图像 / bit128 不跟踪 /
    // bit256 流量节省 / bit2048 电脑模式 / bit4096 允许调试网页 / bit65536 不出售 /
    // bit268435456 广告拦截总开关（置反，w9/p.i0/k） / bit536870912 禁用 WebRTC
    let webflag = 96495261
    webflag = BackupSettings.bit(webflag, 1, s.adBlockOn)
    webflag = BackupSettings.bit(webflag, 268435456, !s.adBlockOn)
    webflag = BackupSettings.bit(webflag, 8, s.jsEnabled)
    webflag = BackupSettings.bit(webflag, 16, !s.noImage)
    webflag = BackupSettings.bit(webflag, 32, false)
    webflag = BackupSettings.bit(webflag, 128, s.doNotTrack)
    webflag = BackupSettings.bit(webflag, 256, s.dataSaver)
    webflag = BackupSettings.bit(webflag, 2048, s.desktopAllSites !== 0)
    webflag = BackupSettings.bit(webflag, 4096, s.allowDebugWeb)
    webflag = BackupSettings.bit(webflag, 65536, s.doNotSell)
    webflag = BackupSettings.bit(webflag, 536870912, s.disableWebRtc)

    // appflag（w9/a 默认 1250，z8/c0.f() 恒 true）：
    // bit5(32) 滑动前进后退 / bit3(8) 音量键翻页（w9/a.v/M0）
    let appflag = 1250
    appflag = BackupSettings.bit(appflag, 32, s.swipeSwitchTab)
    appflag = BackupSettings.bit(appflag, 8, s.volumePageFlip)

    const st: Record<string, Object> = {}
    // boolean 白名单（w9/i.a = [nightcss]）
    st['nightcss'] = s.nightCss
    // String 白名单（w9/i.d，仅导出有对应值的键）
    if (s.homepageMode === 1 && s.homeUrl !== '') {
      st['home'] = s.homeUrl
    } else if (s.homepageMode === 2) {
      st['home'] = 'about:blank'
    } else if (s.homepageMode === 3) {
      st['home'] = 'about:bookmarks'
    }
    if (state.selectedEngine !== null) {
      // 原版 searchurl：自定义搜索引擎模板（w9/k.N 默认 google，自定义时被
      // z8/v2.c 用作记录缺失的回退模板）
      st['searchurl'] = state.selectedEngine.template
    }
    if (state.uastring !== '') {
      st['uastring'] = state.uastring
    }
    if (s.desktopUaKey === 'custom' && s.desktopCustomUa !== '') {
      st['duastring'] = s.desktopCustomUa.replace(/[\t\r\n]/g, ' ')
    }
    if (s.appLanguage === 1) {
      st['language'] = 'zh-CN'
    } else if (s.appLanguage === 2) {
      st['language'] = 'en-US'
    }
    if (s.searchToolbarOrder !== '') {
      st['searchtoolbarorder'] = s.searchToolbarOrder
    }
    if (s.searchToolbarDisabled !== '') {
      st['searchtoolbardisabled'] = s.searchToolbarDisabled
    }
    // int 白名单（w9/i.b，仅导出有对应值的键）
    st['search2'] = state.search2
    st['textsize'] = s.textZoom
    st['uachoice'] = state.uachoice
    st['duachoice'] = BackupSettings.DESKTOP_UA_CHOICE[s.desktopUaKey] !== undefined
      ? BackupSettings.DESKTOP_UA_CHOICE[s.desktopUaKey] : (s.desktopUaKey === 'custom' ? 1 : 0)
    st['keyback'] = s.keyback
    st['keyforward'] = s.keyforward
    st['keyhome'] = s.keyhome
    st['keytab'] = s.keytab
    st['keymenu'] = s.keymenu
    st['gesturetoolbarleft'] = s.gesturetoolbarleft
    st['gesturetoolbarright'] = s.gesturetoolbarright
    st['searchsuggestion'] = s.searchSuggestion
    st['restoreclosedtabs'] = s.restoreTabsMode
    st['cleardataonexit2'] = s.clearOnExit
    st['nightfilter'] = s.nightFilter
    st['readertextsize'] = s.readerFontSize
    st['readerthemecolor'] = s.readerTheme
    st['webflag'] = webflag
    st['webflag2'] = s.simplifyUa ? 1 : 0
    st['appflag'] = appflag
    return st
  }

  // settingsData 记录（ja/c.w：putOpt 跳过 null；时间戳 = Date.now()）
  // mode 0 = settings.txt（m9/l.g：跳过当前 UA 记录、当前引擎 selected）
  // mode 1 = data-for-older-versions kvdata（l9/i:41-47：type1 id==uachoice 跳过、
  // type2 id==uachoice 加 selected，基准同为 w9/k.l0()=uachoice）
  static settingsDataRecords(s: AppSettings, state: SettingsExportState, mode: number): Record<string, Object>[] {
    const records: Record<string, Object>[] = []
    const now = Date.now()
    for (let i = 0; i < s.customUaList.length; i++) {
      const skip = mode === 0 ? i === state.skipUaRecordIdx : (i + 1) === state.uachoice
      if (skip) {
        continue
      }
      const entry: CustomUaEntry = s.customUaList[i]
      const rec: Record<string, Object> = {}
      rec['id'] = i + 1
      rec['title'] = entry.title
      rec['content'] = entry.ua
      rec['flag'] = 0
      rec['type'] = 1
      rec['lastUpdatedAt'] = now
      rec['createdAt'] = now
      records.push(rec)
    }
    for (let i = 0; i < s.customEngines.length; i++) {
      const rec = s.customEngines[i]
      const item: Record<string, Object> = {}
      item['id'] = rec.id
      item['title'] = rec.name
      item['content'] = rec.template
      item['flag'] = 0
      item['type'] = 2
      item['lastUpdatedAt'] = now
      item['createdAt'] = now
      if (mode === 0) {
        if (rec.id === state.search2) {
          item['selected'] = true
        }
      } else if (rec.id === state.uachoice) {
        item['selected'] = true
      }
      records.push(item)
    }
    return records
  }

  // 单个 siteConf 序列化（ba/c.l：enabled 非零才写、flags 恒写）
  static siteConfRecord(site: SiteSetting): Record<string, Object> {
    // ba/b 位集：f2102c=enabled、f2103d=flags；U(bit,on,val) 同步写两个位集
    let enabled = 0
    let flags = 0
    // S(1)：启用总开关
    enabled = BackupSettings.bit(enabled, 1, true)
    flags = BackupSettings.bit(flags, 1, true)
    // Z(2)：JavaScript（ba/b.Z；禁用走 H(2) 清两个位集）
    enabled = BackupSettings.bit(enabled, 2, site.javaScript)
    flags = BackupSettings.bit(flags, 2, site.javaScript)
    // X(4)：图像（本工程 noImage 取反；禁用走 H(4)）
    enabled = BackupSettings.bit(enabled, 4, !site.noImage)
    flags = BackupSettings.bit(flags, 4, !site.noImage)
    // M(16)：广告拦截（allowAds=true 表示站点放行 → H(16) 清位）
    const blockAds = !site.allowAds
    enabled = BackupSettings.bit(enabled, 16, blockAds)
    flags = BackupSettings.bit(flags, 16, blockAds)
    const conf: Record<string, Object> = {}
    if (enabled !== 0) {
      conf['enabled'] = enabled
    }
    conf['flags'] = flags
    return conf
  }

  // l9/j：全站 siteConf map（host → ba/c.l）
  static siteConfMap(s: AppSettings): Record<string, Object> {
    const map: Record<string, Object> = {}
    for (let i = 0; i < s.siteSettings.length; i++) {
      const site: SiteSetting = s.siteSettings[i]
      if (site.host === '') {
        continue
      }
      map[site.host] = BackupSettings.siteConfRecord(site)
    }
    return map
  }

  // 订阅规则文件内容（rulesubs/<key>.block + .allow 合并行）
  private static readRuleFile(context: Context, key: string): string {
    const lines: string[] = []
    const paths = [`${context.filesDir}/rulesubs/${key}.block`, `${context.filesDir}/rulesubs/${key}.allow`]
    for (let i = 0; i < paths.length; i++) {
      try {
        if (fileIo.accessSync(paths[i])) {
          const content = fileIo.readTextSync(paths[i])
          if (content !== '') {
            const parts = content.split('\n')
            for (let j = 0; j < parts.length; j++) {
              if (parts[j] !== '') {
                lines.push(parts[j])
              }
            }
          }
        }
      } catch (error) {
      }
    }
    return lines.join('\n')
  }

  // 导入侧写订阅规则文件
  private static writeRuleFile(context: Context, key: string, content: string): void {
    try {
      const dir = `${context.filesDir}/rulesubs`
      try {
        fileIo.accessSync(dir)
      } catch (error) {
        fileIo.mkdirSync(dir)
      }
      const path = `${dir}/${key}.block`
      const file = fileIo.openSync(path, fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE | fileIo.OpenMode.TRUNC)
      try {
        fileIo.writeSync(file.fd, content)
      } finally {
        fileIo.closeSync(file)
      }
    } catch (error) {
      console.error(`write rule file failed: ${(error as Error).message}`)
    }
  }

  // 导出 settings.txt 全部内容；writeText 用于落盘附带文件
  // （script-*.txt 脚本代码、filters-*.txt 订阅规则、filters-custom.txt 自定义规则，
  // 与 settings.txt 平铺同目录）
  static async buildSettingsTxt(s: AppSettings, context: Context,
    writeText: (name: string, content: string) => void): Promise<string> {
    let out = ''

    // ---- meta（m9/l.e）----
    const meta: Record<string, Object> = {}
    meta['dataVersion'] = 1
    meta['appVersion'] = 20260920
    out += BackupSettings.line('meta', meta)

    // ---- settings（m9/l.c → w9/k.L2(false)）----
    const state = BackupSettings.collectExportState(s)
    const st = BackupSettings.buildSettingsRecord(s, state)
    out += BackupSettings.line('settings', st)

    // ---- settingsData（m9/l.g）----
    const records = BackupSettings.settingsDataRecords(s, state, 0)
    for (let i = 0; i < records.length; i++) {
      out += BackupSettings.line('settingsData', records[i])
    }

    // ---- siteConf（m9/l.h）----
    for (let i = 0; i < s.siteSettings.length; i++) {
      const site: SiteSetting = s.siteSettings[i]
      if (site.host === '') {
        continue
      }
      // m9/l.h：{"siteConf": {"<host>": {...}}}，host 为内层键
      const hostMap: Record<string, Object> = {}
      hostMap[site.host] = BackupSettings.siteConfRecord(site)
      out += BackupSettings.line('siteConf', hostMap)
    }

    // ---- script（m9/l.f：Collections.reverse 后倒序输出）----
    for (let i = s.userScripts.length - 1; i >= 0; i--) {
      const script: UserScriptRec = s.userScripts[i]
      const fileName = `script-${BackupSettings.namePrefix(script.name)}${script.id}.txt`
      writeText(fileName, script.code)
      const rec: Record<string, Object> = {}
      rec['scriptId'] = String(script.id)
      if (script.downloadUrl !== '') {
        rec['url'] = script.downloadUrl
      }
      if (script.name !== '') {
        rec['name'] = script.name
      }
      if (script.enabled) {
        rec['enabled'] = true
      }
      rec['path'] = fileName
      rec['lastUpdated'] = Date.now()
      out += BackupSettings.line('script', rec)
    }

    // ---- filters（m9/l.d:249-286）----
    for (let i = 0; i < s.ruleSubscriptions.length; i++) {
      const sub = s.ruleSubscriptions[i]
      if (sub.url === '') {
        continue
      }
      // 原版 f() 为已添加订阅列表：启用中或已有规则文件的订阅视为已添加
      const ruleContent = BackupSettings.readRuleFile(context, sub.key)
      if (!sub.enabled && ruleContent === '') {
        continue
      }
      const rec: Record<string, Object> = {}
      rec['url'] = sub.url
      if (sub.name !== '') {
        rec['title'] = sub.name
      }
      if (sub.enabled) {
        rec['enabled'] = true
      }
      if (ruleContent !== '') {
        const path = `filters-${BackupSettings.namePrefix(sub.name)}` +
          `${await BackupCrypto.md5Hex(sub.url)}.txt`
        rec['path'] = path
        writeText(path, ruleContent)
        rec['size'] = BackupCrypto.utf8Encode(ruleContent).length
        rec['lastUpdated'] = sub.lastUpdate
      }
      out += BackupSettings.line('filters', rec)
    }
    if (s.customRulesText !== '') {
      writeText('filters-custom.txt', s.customRulesText)
    }
    return out
  }

  // ---------------------------------------------------------------------
  // 导入（m9/l.b 1:1）：settings 行即时语义；EOF 后按
  // settingsData → siteConf → script → filters 顺序恢复
  // ---------------------------------------------------------------------

  private static getBool(obj: Record<string, Object> | null, key: string, def: boolean): boolean {
    if (obj === null) {
      return def
    }
    const v = obj[key]
    return typeof v === 'boolean' ? v : def
  }

  private static getNumber(obj: Record<string, Object> | null, key: string, def: number): number {
    if (obj === null) {
      return def
    }
    const v = obj[key]
    return typeof v === 'number' ? v : def
  }

  private static getString(obj: Record<string, Object> | null, key: string, def: string): string {
    if (obj === null) {
      return def
    }
    const v = obj[key]
    return typeof v === 'string' ? v : def
  }

  // m9/j.b：逗号串逐 token 重映射（负 id 原样；正 id 查 map 未命中丢弃；去重保序）
  private static remapIdList(raw: string, map: Record<string, number>): string {
    if (raw === '') {
      return raw
    }
    const tokens = raw.split(',')
    const seen: string[] = []
    let result = ''
    for (let i = 0; i < tokens.length; i++) {
      const token = tokens[i].trim()
      if (token === '') {
        continue
      }
      const n = Number(token)
      let mapped = token
      if (!Number.isNaN(n) && n > 0) {
        const target = map[token]
        if (target === undefined) {
          continue
        }
        mapped = String(target)
      }
      if (seen.indexOf(mapped) < 0) {
        seen.push(mapped)
        result += (result === '' ? '' : ',') + mapped
      }
    }
    return result
  }

  // ba/b.u：enabledFlags(bit) 置位时读 flags(bit)，否则取默认
  private static siteBit(enabled: number, flags: number, bit: number, def: boolean): boolean {
    return (enabled & bit) !== 0 ? (flags & bit) !== 0 : def
  }

  // 导入 settings.txt；readFile 读取 ZIP 内附属文件（script-*.txt / filters-*.txt /
  // filters-custom.txt）
  static async applySettingsTxt(txt: string, readFile: (name: string) => string | null,
    s: AppSettings, context: Context): Promise<void> {
    const settingsLines: Record<string, Object>[] = []
    const settingsData: Record<string, Object>[] = []
    const siteConfLines: Record<string, Object>[] = []
    const scriptLines: Record<string, Object>[] = []
    const filterLines: Record<string, Object>[] = []
    const lines = txt.split('\n')
    for (let i = 0; i < lines.length; i++) {
      const lineText = lines[i].trim()
      if (lineText === '') {
        continue
      }
      try {
        const parsed = JSON.parse(lineText) as Record<string, Object>
        const keys = Object.keys(parsed)
        if (keys.length === 0) {
          continue
        }
        const type = keys[0]
        const inner = parsed[type]
        if (typeof inner !== 'object' || inner === null) {
          continue
        }
        const obj = inner as Record<string, Object>
        if (type === 'settings') {
          settingsLines.push(obj)
        } else if (type === 'settingsData') {
          settingsData.push(obj)
        } else if (type === 'siteConf') {
          siteConfLines.push(obj)
        } else if (type === 'script') {
          scriptLines.push(obj)
        } else if (type === 'filters') {
          filterLines.push(obj)
        }
      } catch (error) {
        console.error(`settings.txt line parse failed: ${(error as Error).message}`)
      }
    }
    if (settingsLines.length === 0 && settingsData.length === 0 && siteConfLines.length === 0
      && scriptLines.length === 0 && filterLines.length === 0) {
      return
    }

    // 最终写入通道：内部键名 kv → applyBackupKv（等价 w9/k.j1 四组白名单回写）
    const kv: Record<string, Object> = {}
    const st = settingsLines.length > 0 ? settingsLines[0] : null

    // ---- settings 行（m9/l.l → w9/k.j1）----
    if (st !== null) {
      if (typeof st['nightcss'] === 'boolean') {
        kv['nightCss'] = st['nightcss']
      }
      const home = BackupSettings.getString(st, 'home', '')
      if (home !== '') {
        if (home === 'about:blank') {
          kv['homepageMode'] = 2
        } else if (home === 'about:bookmarks') {
          kv['homepageMode'] = 3
        } else if (home !== 'about:home') {
          kv['homepageMode'] = 1
          kv['homeUrl'] = home
        }
      }
      const language = BackupSettings.getString(st, 'language', '')
      if (language === 'zh-CN') {
        kv['appLanguage'] = 1
      } else if (language === 'en-US') {
        kv['appLanguage'] = 2
      }
      if (typeof st['textsize'] === 'number') {
        kv['textZoom'] = st['textsize'] as number
      }
      if (typeof st['searchsuggestion'] === 'number') {
        kv['searchsuggestion'] = st['searchsuggestion'] as number
      }
      const intKeys: Record<string, string> = {
        'keyback': 'keyback',
        'keyforward': 'keyforward',
        'keyhome': 'keyhome',
        'keytab': 'keytab',
        'keymenu': 'keymenu',
        'gesturetoolbarleft': 'gesturetoolbarleft',
        'gesturetoolbarright': 'gesturetoolbarright',
        'restoreclosedtabs': 'restoreclosedtabs',
        'cleardataonexit2': 'clearOnExit',
        'nightfilter': 'nightFilter',
        'readertextsize': 'readerFontSize',
        'readerthemecolor': 'readerTheme'
      }
      const intKeyNames = Object.keys(intKeys)
      for (let i = 0; i < intKeyNames.length; i++) {
        const androidKey = intKeyNames[i]
        const v = st[androidKey]
        if (typeof v === 'number') {
          kv[intKeys[androidKey]] = v
        }
      }
      // webflag（w9/p）位分解
      if (typeof st['webflag'] === 'number') {
        const webflag = st['webflag'] as number
        kv['adBlockOn'] = (webflag & 268435456) === 0
        kv['jsEnabled'] = (webflag & 8) !== 0
        kv['noImage'] = (webflag & 16) === 0
        kv['doNotTrack'] = (webflag & 128) !== 0
        kv['dataSaver'] = (webflag & 256) !== 0
        kv['desktopAllSites'] = (webflag & 2048) !== 0 ? 1 : 0
        kv['allowDebugWeb'] = (webflag & 4096) !== 0
        kv['doNotSell'] = (webflag & 65536) !== 0
        kv['disableWebRtc'] = (webflag & 536870912) !== 0
      }
      // webflag2（w9/o）：bit1 = 自定义 UA 兼容规整
      if (typeof st['webflag2'] === 'number') {
        const webflag2 = st['webflag2'] as number
        kv['simplifyUa'] = (webflag2 & 1) !== 0
      }
      // appflag（w9/a）：bit5 滑动前进后退 / bit3 音量键翻页
      if (typeof st['appflag'] === 'number') {
        const appflag = st['appflag'] as number
        kv['swipeSwitchTab'] = (appflag & 32) !== 0
        kv['volumePageFlip'] = (appflag & 8) !== 0
      }
      // 桌面 UA（duachoice/duastring，z8/b4.c）
      const duachoice = BackupSettings.getNumber(st, 'duachoice', 0)
      if (duachoice === 0) {
        kv['desktopUaKey'] = 'win_chrome'
      } else if (duachoice === -4) {
        kv['desktopUaKey'] = 'win_ie11'
      } else if (duachoice === -5) {
        kv['desktopUaKey'] = 'mac'
      } else if (duachoice >= 1) {
        kv['desktopUaKey'] = 'custom'
        kv['desktopCustomUa'] = BackupSettings.getString(st, 'duastring', '')
      }
      const searchtoolbarorder = BackupSettings.getString(st, 'searchtoolbarorder', '')
      if (searchtoolbarorder !== '') {
        kv['searchToolbarOrder'] = searchtoolbarorder
      }
      const searchtoolbardisabled = BackupSettings.getString(st, 'searchtoolbardisabled', '')
      if (searchtoolbardisabled !== '') {
        kv['searchToolbarDisabled'] = searchtoolbardisabled
      }
    }

    // ---- settingsData（m9/l.o → ja/c.n 恢复）----
    // type2 自定义引擎：按 title 合并现有记录，id 沿用现有或自增；建 旧id→新id 映射
    let engines: CustomEngineRec[] = []
    for (let i = 0; i < s.customEngines.length; i++) {
      engines.push(s.customEngines[i])
    }
    let maxEngineId = 0
    for (let i = 0; i < engines.length; i++) {
      if (engines[i].id > maxEngineId) {
        maxEngineId = engines[i].id
      }
    }
    const engineIdMap: Record<string, number> = {}
    let selectedEngineId = -1
    // type1 自定义 UA：按 title 合并现有列表；记录 id→条目（uachoice 指向）
    let uaList: CustomUaEntry[] = []
    for (let i = 0; i < s.customUaList.length; i++) {
      uaList.push(s.customUaList[i])
    }
    const uaById: Record<string, CustomUaEntry> = {}
    let uachoice = BackupSettings.getNumber(st, 'uachoice', 0)
    const uastring = BackupSettings.getString(st, 'uastring', '')
    for (let i = 0; i < settingsData.length; i++) {
      const rec = settingsData[i]
      const type = BackupSettings.getNumber(rec, 'type', 0)
      const id = BackupSettings.getNumber(rec, 'id', 0)
      const title = BackupSettings.getString(rec, 'title', '')
      const content = BackupSettings.getString(rec, 'content', '')
      if (type === 2 && title !== '' && content !== '') {
        let newId = -1
        for (let j = 0; j < engines.length; j++) {
          if (engines[j].name === title) {
            newId = engines[j].id
            break
          }
        }
        if (newId < 0) {
          maxEngineId++
          newId = maxEngineId
          engines.push(new CustomEngineRec(title, content, newId))
        }
        engineIdMap[String(id)] = newId
        if (BackupSettings.getBool(rec, 'selected', false)) {
          selectedEngineId = newId
        }
      } else if (type === 1 && title !== '' && content !== '') {
        let exists = false
        for (let j = 0; j < uaList.length; j++) {
          if (uaList[j].title === title) {
            uaById[String(id)] = uaList[j]
            exists = true
            break
          }
        }
        if (!exists) {
          const entry = new CustomUaEntry(title, content)
          uaList.push(entry)
          uaById[String(id)] = entry
        }
      }
    }
    if (engines.length > 0) {
      const payload: Record<string, Object>[] = []
      for (let i = 0; i < engines.length; i++) {
        const entry: Record<string, Object> = {}
        entry['name'] = engines[i].name
        entry['template'] = engines[i].template
        entry['id'] = engines[i].id
        payload.push(entry)
      }
      kv['customEngines'] = JSON.stringify(payload)
    }
    if (uaList.length > 0) {
      const payload: Record<string, Object>[] = []
      for (let i = 0; i < uaList.length; i++) {
        const entry: Record<string, Object> = {}
        entry['title'] = uaList[i].title
        entry['ua'] = uaList[i].ua
        payload.push(entry)
      }
      kv['customUaList'] = JSON.stringify(payload)
    }
    // 搜索引擎（m9/l.o selected → w9/l.q；k() id 重映射 order/disabled）
    // search2 缺省时不动 engineKey（原版 j1 仅在键存在时回写）
    const search2Present = st !== null && typeof st['search2'] === 'number'
    const search2 = search2Present ? st['search2'] as number : 0
    if (selectedEngineId >= 1) {
      kv['engineKey'] = `custom:${selectedEngineId}`
    } else if (search2Present && search2 < 0) {
      const builtin = builtinKeyById(search2)
      if (builtin !== null) {
        kv['engineKey'] = builtin
      }
    } else if (search2Present && search2 >= 1) {
      const mapped = engineIdMap[String(search2)]
      if (mapped !== undefined) {
        kv['engineKey'] = `custom:${mapped}`
      } else {
        // 记录缺失：回退 searchurl 模板（z8/v2.c 自定义分支）
        const searchurl = BackupSettings.getString(st, 'searchurl', '')
        if (searchurl !== '') {
          kv['engineKey'] = `custom:${search2}`
          kv['customEngineTemplate'] = searchurl
        }
      }
    }
    const orderRaw = typeof kv['searchToolbarOrder'] === 'string' ? kv['searchToolbarOrder'] as string : ''
    if (orderRaw !== '') {
      kv['searchToolbarOrder'] = BackupSettings.remapIdList(orderRaw, engineIdMap)
    }
    const disabledRaw = typeof kv['searchToolbarDisabled'] === 'string'
      ? kv['searchToolbarDisabled'] as string : ''
    if (disabledRaw !== '') {
      kv['searchToolbarDisabled'] = BackupSettings.remapIdList(disabledRaw, engineIdMap)
    }
    // 浏览器标识：uachoice>0 → type1 记录 content / uastring（z8/b4.c 默认分支）
    if (uachoice >= 1) {
      const entry = uaById[String(uachoice)]
      kv['uaKey'] = 'custom'
      kv['customUa'] = entry !== undefined ? entry.ua : uastring
    } else if (uachoice <= 0) {
      if (uachoice === 0) {
        kv['uaKey'] = 'default'
      } else {
        const presetKeys = ['default', 'android_phone', 'android_tablet', 'win_chrome', 'win_ie11',
          'mac', 'iphone', 'ipad', 'symbian']
        const idx = -uachoice
        if (idx >= 1 && idx < presetKeys.length) {
          kv['uaKey'] = presetKeys[idx]
        } else {
          kv['uaKey'] = 'default'
        }
      }
    }

    // ---- siteConf（m9/l.p → ba/c.j → ba/b.u 位分解）----
    if (siteConfLines.length > 0) {
      const sites: SiteSetting[] = []
      for (let i = 0; i < s.siteSettings.length; i++) {
        sites.push(s.siteSettings[i])
      }
      for (let i = 0; i < siteConfLines.length; i++) {
        const lineObj = siteConfLines[i]
        const hosts = Object.keys(lineObj)
        for (let j = 0; j < hosts.length; j++) {
          const host = hosts[j]
          if (host === '') {
            continue
          }
          const conf = lineObj[host]
          if (typeof conf !== 'object' || conf === null) {
            continue
          }
          const confObj = conf as Record<string, Object>
          const enabled = BackupSettings.getNumber(confObj, 'enabled', 0)
          const flags = BackupSettings.getNumber(confObj, 'flags', 0)
          const site = new SiteSetting(host)
          site.javaScript = BackupSettings.siteBit(enabled, flags, 2, true)
          site.noImage = !BackupSettings.siteBit(enabled, flags, 4, true)
          site.allowAds = !BackupSettings.siteBit(enabled, flags, 16, true)
          // uastring/uachoice/textsize：本工程 SiteSetting 无对应字段，跳过
          let replaced = false
          for (let k = 0; k < sites.length; k++) {
            if (sites[k].host === host) {
              sites[k] = site
              replaced = true
              break
            }
          }
          if (!replaced) {
            sites.push(site)
          }
        }
      }
      const payload: Record<string, Object>[] = []
      for (let i = 0; i < sites.length; i++) {
        const entry: Record<string, Object> = {}
        entry['host'] = sites[i].host
        entry['pcMode'] = sites[i].pcMode
        entry['noImage'] = sites[i].noImage
        entry['allowAds'] = sites[i].allowAds
        entry['forceDark'] = sites[i].forceDark
        entry['javaScript'] = sites[i].javaScript
        payload.push(entry)
      }
      kv['siteSettings'] = JSON.stringify(payload)
    }

    // ---- script（m9/l.n）----
    if (scriptLines.length > 0) {
      const scripts: UserScriptRec[] = []
      for (let i = 0; i < s.userScripts.length; i++) {
        scripts.push(s.userScripts[i])
      }
      let nextId = s.scriptNextId
      for (let i = 0; i < scriptLines.length; i++) {
        const lineObj = scriptLines[i]
        const name = BackupSettings.getString(lineObj, 'name', '')
        const path = BackupSettings.getString(lineObj, 'path', '')
        let code = ''
        if (path !== '') {
          const fileContent = readFile(path)
          if (fileContent !== null) {
            code = fileContent
          }
        }
        // inline "code" 为 d1.a GZIP+Base64 编码（非 ZIP 场景），ZIP 备份不出现，跳过
        if (code === '') {
          continue
        }
        const enabled = BackupSettings.getBool(lineObj, 'enabled', false)
        const url = BackupSettings.getString(lineObj, 'url', '')
        let target = -1
        for (let j = 0; j < scripts.length; j++) {
          if (scripts[j].name === name && (name !== '' || scripts[j].downloadUrl === url)) {
            target = j
            break
          }
        }
        if (target >= 0) {
          scripts[target].code = code
          scripts[target].enabled = enabled
          if (url !== '') {
            scripts[target].downloadUrl = url
          }
        } else {
          const rec = new UserScriptRec()
          rec.id = nextId
          nextId++
          rec.name = name
          rec.code = code
          rec.enabled = enabled
          rec.downloadUrl = url
          scripts.push(rec)
        }
      }
      const payload: Record<string, Object>[] = []
      for (let i = 0; i < scripts.length; i++) {
        const entry: Record<string, Object> = {}
        entry['id'] = scripts[i].id
        entry['name'] = scripts[i].name
        entry['code'] = scripts[i].code
        entry['enabled'] = scripts[i].enabled
        entry['includes'] = scripts[i].includes
        entry['excludes'] = scripts[i].excludes
        entry['runAt'] = scripts[i].runAt
        entry['grantBits'] = scripts[i].grantBits
        entry['unwrap'] = scripts[i].unwrap
        entry['downloadUrl'] = scripts[i].downloadUrl
        entry['homepageUrl'] = scripts[i].homepageUrl
        entry['version'] = scripts[i].version
        entry['requires'] = scripts[i].requires
        payload.push(entry)
      }
      kv['userScripts'] = JSON.stringify(payload)
      kv['scriptNextId'] = nextId
    }

    // ---- filters（m9/l.m → u4/a.h：订阅按 url 合并 + 规则文件落盘）----
    let subsChanged = false
    let firstUrl = ''
    let newKeySeq = 0
    for (let i = 0; i < filterLines.length; i++) {
      const lineObj = filterLines[i]
      const url = BackupSettings.getString(lineObj, 'url', '')
      if (url === '') {
        continue
      }
      if (firstUrl === '') {
        firstUrl = url
      }
      const title = BackupSettings.getString(lineObj, 'title', '')
      const enabled = BackupSettings.getBool(lineObj, 'enabled', false)
      const lastUpdated = BackupSettings.getNumber(lineObj, 'lastUpdated', 0)
      const path = BackupSettings.getString(lineObj, 'path', '')
      let ruleContent = ''
      if (path !== '') {
        const fileContent = readFile(path)
        if (fileContent !== null) {
          ruleContent = fileContent
        }
      }
      let targetIdx = -1
      for (let j = 0; j < s.ruleSubscriptions.length; j++) {
        if (s.ruleSubscriptions[j].url === url) {
          targetIdx = j
          break
        }
      }
      if (targetIdx >= 0) {
        const sub = s.ruleSubscriptions[targetIdx]
        if (ruleContent !== '') {
          BackupSettings.writeRuleFile(context, sub.key, ruleContent)
          sub.lastUpdate = lastUpdated
          subsChanged = true
        }
      } else {
        // 新订阅（u4/a.h b() → c.g(url) 添加）
        const key = `c${Date.now()}${newKeySeq}`
        newKeySeq++
        const entry = new RuleSubEntry(key, title !== '' ? title : url, url, enabled, 0, lastUpdated, false)
        s.ruleSubscriptions.push(entry)
        if (ruleContent !== '') {
          BackupSettings.writeRuleFile(context, key, ruleContent)
        }
        subsChanged = true
      }
    }
    if (subsChanged) {
      s.saveRuleSubs()
    }
    if (firstUrl !== '') {
      kv['ruleSubUrl'] = firstUrl
    }
    const customFilters = readFile('filters-custom.txt')
    if (customFilters !== null && customFilters !== '') {
      // 原版 m()：本地与备份自定义规则逐行并集去重
      const merged: string[] = []
      const sources: string[] = [s.customRulesText, customFilters]
      for (let sIdx = 0; sIdx < sources.length; sIdx++) {
        const parts = sources[sIdx].split('\n')
        for (let i = 0; i < parts.length; i++) {
          const ruleLine = parts[i].trim()
          if (ruleLine !== '' && merged.indexOf(ruleLine) < 0) {
            merged.push(ruleLine)
          }
        }
      }
      kv['customRulesText'] = merged.join('\n')
    }

    await s.applyBackupKv(kv)
  }
}
