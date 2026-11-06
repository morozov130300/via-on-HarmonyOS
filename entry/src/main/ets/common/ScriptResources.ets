// 原版 @resource 资源缓存 + 脚本元数据旁路存储
// （p5/b.java W/h0/i0/t/x + s5/b.java g/h/j + p5/a.java M/O/R/S/D/E）
// - 资源目录 filesDir/gm_resources，缓存文件名 = MD5(resourceUrl)（p5/b.i0 → s5.c.a）
// - 新鲜度 15 天（p5/b.W:91，1296000000ms）：文件存在且非空且未过期 → 直接使用，否则下载
//   （s5/b.c：GET + Mozilla UA + connectTimeout 10000/readTimeout 30000，写 .tmp 成功后重命名）
// - GM_getResourceText（p5/a.E）：字节 → UTF-8 文本；GM_getResourceURL（p5/a.D）：
//   URL 扩展名 → MIME → data:<mime>;base64,<base64>；data: 资源直接解码（s5/b.g/h）
// - SRI 校验（p5/a.O/R/S）：URL 片段 #md5=/#sha256=（hex 32/64 位或 base64），不匹配按空内容处理
// - 脚本元数据旁路：p5 scripts 表的 icon_url/support_url/resources/script_id/last_updated_at 列
//   在鸿蒙侧 Settings.persistScripts 不序列化，故按脚本 id 存 preferences 'script_meta'，
//   安装/保存/更新时由 metaStoreSaveScript 同步刷新 last_updated_at（r5/a.f:231-232）
import { http } from '@kit.NetworkKit'
import { preferences } from '@kit.ArkData'
import { fileIo } from '@kit.CoreFileKit'
import { util } from '@kit.ArkTS'
import { BusinessError } from '@kit.BasicServicesKit'
import { common } from '@kit.AbilityKit'
import { hilog } from '@kit.PerformanceAnalysisKit'
import { cryptoFramework } from '@kit.CryptoArchitectureKit'
import { UserScriptRec, md5Hex } from './Types'
import { hostOf } from './SearchEngines'

const TAG = 'ScriptResources'
const DOMAIN = 0x0000
// p5/b.W:91：资源缓存新鲜期 15 天（1296000000ms）
const RESOURCE_FRESH_MS: number = 1296000000
const RESOURCE_DIR_NAME: string = 'gm_resources'
const RESOURCE_TMP_SUFFIX: string = '.tmp'
// s5/b.b:101：资源下载 UA
const DOWNLOAD_UA: string = 'Mozilla/5.0 (Linux; Android 10; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) ' +
  'Chrome/120.0.0.0 Mobile Safari/537.36'
// 脚本元数据旁路存储
export const META_STORE_NAME: string = 'script_meta'
const KEY_META_MAP: string = 'meta'

// p5 scripts 表扩展列（icon_url/support_url/resources/script_id/last_updated_at）
export class ScriptMetaExtra {
  scriptId: string
  iconUrl: string
  supportUrl: string
  resources: string
  lastUpdatedAt: number

  constructor() {
    this.scriptId = ''
    this.iconUrl = ''
    this.supportUrl = ''
    this.resources = ''
    this.lastUpdatedAt = 0
  }
}

function metaMapOf(store: preferences.Preferences): Record<string, Object> {
  try {
    const raw = store.getSync(KEY_META_MAP, '{}') as string
    const parsed = JSON.parse(raw) as Object
    if (parsed instanceof Object && !(parsed instanceof Array)) {
      return parsed as Record<string, Object>
    }
  } catch (error) {
  }
  return {} as Record<string, Object>
}

function metaEntryOf(obj: Record<string, Object>): ScriptMetaExtra | null {
  if (!(obj instanceof Object) || obj instanceof Array) {
    return null
  }
  const extra = new ScriptMetaExtra()
  const scriptId = obj['scriptId']
  const iconUrl = obj['iconUrl']
  const supportUrl = obj['supportUrl']
  const resources = obj['resources']
  const lastUpdatedAt = obj['lastUpdatedAt']
  if (typeof scriptId === 'string') {
    extra.scriptId = scriptId
  }
  if (typeof iconUrl === 'string') {
    extra.iconUrl = iconUrl
  }
  if (typeof supportUrl === 'string') {
    extra.supportUrl = supportUrl
  }
  if (typeof resources === 'string') {
    extra.resources = resources
  }
  if (typeof lastUpdatedAt === 'number') {
    extra.lastUpdatedAt = lastUpdatedAt
  }
  return extra
}

// 读取脚本元数据旁路（直接操作给定 store，供 await getPreferences 后的调用方使用）
export function metaStoreLoadScript(store: preferences.Preferences, id: number): ScriptMetaExtra | null {
  const map = metaMapOf(store)
  const raw = map[String(id)]
  if (!(raw instanceof Object) || raw instanceof Array) {
    return null
  }
  return metaEntryOf(raw as Record<string, Object>)
}

// 写入脚本元数据旁路并刷新 last_updated_at（r5/a.f:231-232：安装/保存/更新即刷新，
// 避免下个自动更新周期立即重拉）
export function metaStoreSaveScript(store: preferences.Preferences, rec: UserScriptRec): void {
  const map = metaMapOf(store)
  const entry: Record<string, Object> = {} as Record<string, Object>
  entry['scriptId'] = rec.scriptId
  entry['iconUrl'] = rec.iconUrl
  entry['supportUrl'] = rec.supportUrl
  entry['resources'] = rec.resources
  entry['lastUpdatedAt'] = Date.now()
  map[String(rec.id)] = entry as Object
  store.putSync(KEY_META_MAP, JSON.stringify(map))
  store.flush()
}

// 脚本 script_id：解析期已写入 rec（r5/a.f:289 MD5(host+name)）；存量记录依次回退
// 元数据旁路 → 按下载地址 host 现算（@downloadURL 覆盖等极端场景存在偏差）
export function scriptIdOf(script: UserScriptRec): string {
  if (script.scriptId !== '') {
    return script.scriptId
  }
  const meta = loadScriptMeta(script.id)
  if (meta !== null && meta.scriptId !== '') {
    return meta.scriptId
  }
  return md5Hex(hostOf(script.downloadUrl) + script.name)
}

// @resource JSON 对象串 → 资源地址列表
function resourceUrlValues(resourcesJson: string): string[] {
  if (resourcesJson === '') {
    return []
  }
  try {
    const parsed = JSON.parse(resourcesJson) as Object
    if (parsed instanceof Object && !(parsed instanceof Array)) {
      const obj = parsed as Record<string, Object>
      const keys = Object.keys(obj)
      const result: string[] = []
      for (let i = 0; i < keys.length; i++) {
        const value = obj[keys[i]]
        if (typeof value === 'string' && (value as string) !== '') {
          result.push(value as string)
        }
      }
      return result
    }
  } catch (error) {
  }
  return []
}

// p5/a.P：资源名 → 资源地址（resources 为空或名称不存在返回 null）
export function resourceUrlOf(resourcesJson: string, name: string): string | null {
  if (resourcesJson === '' || name === '') {
    return null
  }
  try {
    const parsed = JSON.parse(resourcesJson) as Object
    if (parsed instanceof Object && !(parsed instanceof Array)) {
      const value = (parsed as Record<string, Object>)[name]
      if (typeof value === 'string' && (value as string) !== '') {
        return value as string
      }
    }
  } catch (error) {
  }
  return null
}

// s5/b.g：data: URL → 字节（base64 或 URL 编码文本；解析失败返回空字节，与原版一致）
function dataUrlBytes(url: string): Uint8Array {
  const empty = new Uint8Array(0)
  if (url.length <= 5 || url.substring(0, 4).toLowerCase() !== 'data') {
    return empty
  }
  const commaIdx = url.indexOf(',')
  if (commaIdx < 0) {
    return empty
  }
  const isBase64 = url.lastIndexOf(';base64', commaIdx) > 0
  // java URLDecoder.decode：'+' 视为空格
  let payload = url.substring(commaIdx + 1).replace(/\+/g, ' ')
  try {
    payload = decodeURIComponent(payload)
  } catch (error) {
    return empty
  }
  if (!isBase64) {
    return new util.TextEncoder().encodeInto(payload)
  }
  try {
    return new Uint8Array(new util.Base64Helper().decodeSync(payload))
  } catch (error) {
    return empty
  }
}

// bytesToHex（p5/a.c）
function bytesToHex(bytes: Uint8Array): string {
  let hex = ''
  for (let i = 0; i < bytes.length; i++) {
    hex += (bytes[i] < 16 ? '0' : '') + bytes[i].toString(16)
  }
  return hex
}

// p5/a.O：解析 URL 片段 SRI（#md5=.../#sha256=...，值支持 hex 或 base64）
function sriOf(url: string): string[] | null {
  const hashIdx = url.lastIndexOf('#')
  if (hashIdx <= 0 || !url.includes('://')) {
    return null
  }
  const after = hashIdx + 1
  const algos: string[] = ['md5', 'sha256']
  const lengths: number[] = [32, 64]
  let valueIdx = -1
  let algoIdx = -1
  for (let i = 0; i < algos.length; i++) {
    const found = url.indexOf(algos[i], after)
    if (found >= 0) {
      const end = found + algos[i].length
      if (url.length > end && (url.charAt(end) === '=' || url.charAt(end) === '-')) {
        valueIdx = end + 1
        algoIdx = i
        break
      }
    }
  }
  if (valueIdx < 0 || algoIdx < 0) {
    return null
  }
  let end = url.indexOf(',', valueIdx)
  if (end < 0) {
    end = url.indexOf(';', valueIdx)
  }
  if (end < 0) {
    end = url.length
  }
  if (end <= valueIdx + 1) {
    return null
  }
  let value = url.substring(valueIdx, end)
  if (lengths[algoIdx] !== value.length) {
    // p5/a.O：非 hex 长度按 base64 解码后转 hex
    try {
      value = bytesToHex(new Uint8Array(new util.Base64Helper().decodeSync(value)))
    } catch (error) {
    }
  }
  return [algos[algoIdx], value]
}

// p5/a.R/S：md5/sha256 摘要比对（算法未知或摘要异常时不校验 = 通过）
function verifySri(url: string, bytes: Uint8Array): boolean {
  const sri = sriOf(url)
  if (sri === null) {
    return true
  }
  let algName = ''
  if (sri[0] === 'md5') {
    algName = 'MD5'
  } else if (sri[0] === 'sha256') {
    algName = 'SHA256'
  } else {
    return true
  }
  try {
    const md = cryptoFramework.createMd(algName)
    const blob: cryptoFramework.DataBlob = { data: bytes }
    md.updateSync(blob)
    return bytesToHex(md.digestSync().data).toLowerCase() === sri[1].toLowerCase()
  } catch (error) {
    return true
  }
}

// Android MimeTypeMap.getFileExtensionFromUrl + getMimeTypeFromExtension 的常用子集
function mimeFromUrl(url: string): string {
  let path = url
  const queryIdx = path.indexOf('?')
  if (queryIdx >= 0) {
    path = path.substring(0, queryIdx)
  }
  const hashIdx = path.indexOf('#')
  if (hashIdx >= 0) {
    path = path.substring(0, hashIdx)
  }
  const slashIdx = path.lastIndexOf('/')
  const name = slashIdx >= 0 ? path.substring(slashIdx + 1) : path
  const dotIdx = name.lastIndexOf('.')
  if (dotIdx < 0) {
    return 'application/octet-stream'
  }
  switch (name.substring(dotIdx + 1).toLowerCase()) {
    case 'png':
      return 'image/png'
    case 'jpg':
    case 'jpeg':
      return 'image/jpeg'
    case 'gif':
      return 'image/gif'
    case 'svg':
      return 'image/svg+xml'
    case 'webp':
      return 'image/webp'
    case 'ico':
      return 'image/x-icon'
    case 'bmp':
      return 'image/bmp'
    case 'css':
      return 'text/css'
    case 'js':
      return 'application/javascript'
    case 'json':
      return 'application/json'
    case 'html':
    case 'htm':
      return 'text/html'
    case 'txt':
      return 'text/plain'
    case 'xml':
      return 'text/xml'
    case 'mp3':
      return 'audio/mpeg'
    case 'ogg':
      return 'audio/ogg'
    case 'wav':
      return 'audio/wav'
    case 'mp4':
      return 'video/mp4'
    case 'webm':
      return 'video/webm'
    case 'woff':
      return 'font/woff'
    case 'woff2':
      return 'font/woff2'
    case 'ttf':
      return 'font/ttf'
    case 'otf':
      return 'font/otf'
    case 'wasm':
      return 'application/wasm'
    default:
      return 'application/octet-stream'
  }
}

class ScriptResourceCache {
  private static instance: ScriptResourceCache | null = null
  private dir: string = ''
  private metaPrefs: preferences.Preferences | null = null
  private pendingUrls: Set<string> = new Set()

  static getInstance(): ScriptResourceCache {
    if (ScriptResourceCache.instance === null) {
      ScriptResourceCache.instance = new ScriptResourceCache()
    }
    return ScriptResourceCache.instance
  }

  init(context: common.Context): void {
    if (this.dir === '') {
      this.dir = context.filesDir + '/' + RESOURCE_DIR_NAME
      try {
        if (!fileIo.accessSync(this.dir)) {
          fileIo.mkdirSync(this.dir)
        }
      } catch (error) {
        hilog.error(DOMAIN, TAG, 'init gm resource dir failed')
      }
    }
    if (this.metaPrefs === null) {
      preferences.getPreferences(context, META_STORE_NAME)
        .then((store: preferences.Preferences): void => {
          ScriptResourceCache.getInstance().metaPrefs = store
        })
        .catch((error: BusinessError): void => {
          hilog.error(DOMAIN, TAG, 'init script meta store failed: %{public}s', error.message)
        })
    }
  }

  // p5/b.h0/i0：资源缓存文件路径（文件名 = MD5(url)）
  private pathOf(url: string): string {
    return this.dir + '/' + md5Hex(url)
  }

  // p5/b.W：资源未缓存/已过期（15 天新鲜度）时后台补拉
  ensureCached(url: string): Promise<boolean> {
    if (this.dir === '' || url === '' || !url.startsWith('http')) {
      return Promise.resolve(false)
    }
    if (this.pendingUrls.has(url)) {
      return Promise.resolve(false)
    }
    if (this.isFresh(url)) {
      return Promise.resolve(true)
    }
    this.pendingUrls.add(url)
    return this.download(url)
      .catch((error: BusinessError): boolean => {
        hilog.error(DOMAIN, TAG, 'download resource failed: %{public}s %{public}s', url, error.message)
        return false
      })
      .finally(() => {
        this.pendingUrls.delete(url)
      })
  }

  // p5/b.W:91：文件存在且非空且在新鲜期内 → 有效（反编译原文比较方向相反且
  // 会导致新文件被反复重下，按审计口径实现 15 天新鲜度语义）
  private isFresh(url: string): boolean {
    try {
      const stat = fileIo.statSync(this.pathOf(url))
      return stat.size > 0 && stat.mtime >= Date.now() - RESOURCE_FRESH_MS
    } catch (error) {
      return false
    }
  }

  // s5/b.c：先下载到 .tmp（GET + UA + 10s/30s 超时），成功后替换目标文件
  private download(url: string): Promise<boolean> {
    const target = this.pathOf(url)
    const tmp = target + RESOURCE_TMP_SUFFIX
    const session = http.createHttp()
    const header: Record<string, string> = {} as Record<string, string>
    header['User-Agent'] = DOWNLOAD_UA
    return session.request(url, {
      method: http.RequestMethod.GET,
      header: header,
      connectTimeout: 10000,
      readTimeout: 30000,
      usingCache: false
    }).then((response: http.HttpResponse): boolean => {
      if (response.responseCode !== 200) {
        return false
      }
      const body = response.result
      let bytes: Uint8Array
      if (typeof body === 'string') {
        bytes = new util.TextEncoder().encodeInto(body)
      } else if (body instanceof ArrayBuffer) {
        bytes = new Uint8Array(body)
      } else {
        return false
      }
      if (bytes.length === 0) {
        return false
      }
      try {
        const file = fileIo.openSync(tmp, fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE |
          fileIo.OpenMode.TRUNC)
        fileIo.writeSync(file.fd, bytes.buffer as ArrayBuffer)
        fileIo.closeSync(file)
        try {
          fileIo.unlinkSync(target)
        } catch (error) {
        }
        fileIo.renameSync(tmp, target)
        return true
      } catch (error) {
        return false
      }
    }).finally(() => {
      try {
        fileIo.unlinkSync(tmp)
      } catch (error) {
      }
      session.destroy()
    })
  }

  // p5/b.t：资源字节（data: 直接解码；否则读缓存文件；SRI 不匹配 → 空字节）
  private readBytes(url: string): Uint8Array | null {
    let bytes: Uint8Array | null = null
    if (url.length > 5 && url.substring(0, 4).toLowerCase() === 'data') {
      bytes = dataUrlBytes(url)
      if (bytes.length === 0) {
        bytes = null
      }
    } else if (this.dir !== '') {
      try {
        const file = fileIo.openSync(this.pathOf(url), fileIo.OpenMode.READ_ONLY)
        const stat = fileIo.statSync(file.fd)
        if (stat.size > 0) {
          const buffer = new ArrayBuffer(stat.size)
          fileIo.readSync(file.fd, buffer)
          bytes = new Uint8Array(buffer)
        }
        fileIo.closeSync(file)
      } catch (error) {
        bytes = null
      }
    }
    if (bytes === null) {
      return null
    }
    if (!verifySri(url, bytes)) {
      return new Uint8Array(0)
    }
    return bytes
  }

  // p5/a.E：资源文本（缺失 null；SRI 不匹配或解码失败空串）
  readText(url: string): string | null {
    const bytes = this.readBytes(url)
    if (bytes === null) {
      return null
    }
    if (bytes.length === 0) {
      return ''
    }
    try {
      return util.TextDecoder.create('utf-8').decodeToString(bytes)
    } catch (error) {
      return ''
    }
  }

  // p5/a.D：资源 data:URL（data:<mime>;base64,...</>；缺失 null；SRI 不匹配空串）
  readDataUrl(url: string): string | null {
    const bytes = this.readBytes(url)
    if (bytes === null) {
      return null
    }
    if (bytes.length === 0) {
      return ''
    }
    try {
      return 'data:' + mimeFromUrl(url) + ';base64,' + new util.Base64Helper().encodeToStringSync(bytes)
    } catch (error) {
      return ''
    }
  }

  loadMeta(id: number): ScriptMetaExtra | null {
    if (this.metaPrefs === null) {
      return null
    }
    return metaStoreLoadScript(this.metaPrefs, id)
  }
}

// EntryAbility.onCreate（GmRuntime.initGmRuntime）初始化入口
export function initScriptResources(context: common.Context): void {
  ScriptResourceCache.getInstance().init(context)
}

// 读取脚本元数据旁路（store 未就绪时返回 null，调用方自行回退）
export function loadScriptMeta(id: number): ScriptMetaExtra | null {
  return ScriptResourceCache.getInstance().loadMeta(id)
}

// p5/a.J/K/W：脚本缺失/过期的 http 资源后台补拉（安装后预取）
export function ensureScriptResourceCached(url: string): void {
  ScriptResourceCache.getInstance().ensureCached(url).catch((error: BusinessError): void => {
  })
}

// p5/a.J：安装/更新后确保脚本全部 @resource 已缓存
export function prefetchScriptResources(rec: UserScriptRec): void {
  const urls = resourceUrlValues(rec.resources)
  for (let i = 0; i < urls.length; i++) {
    ensureScriptResourceCached(urls[i])
  }
}

// p5/a.E（GM_getResourceText 底层）：缺失 null / 空内容 ''
export function readScriptResourceText(url: string): string | null {
  return ScriptResourceCache.getInstance().readText(url)
}

// p5/a.D（GM_getResourceURL 底层）：data:<mime>;base64
export function readScriptResourceDataUrl(url: string): string | null {
  return ScriptResourceCache.getInstance().readDataUrl(url)
}
