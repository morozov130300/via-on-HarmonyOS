import { webview } from '@kit.ArkWeb'
import { image } from '@kit.ImageKit'
import { i18n } from '@kit.LocalizationKit'

export enum DownloadStatus {
  Running = 0,
  Completed = 1,
  Failed = 2,
  Canceled = 3,
  Paused = 4
}

@ObservedV2
export class TabItem {
  readonly id: number
  @Trace incognito: boolean
  @Trace title: string
  @Trace url: string
  @Trace progress: number
  @Trace adCount: number
  @Trace canBack: boolean
  @Trace canForward: boolean
  @Trace loading: boolean
  @Trace isError: boolean
  @Trace errorDesc: string
  @Trace initialUrl: string
  @Trace matchOrdinal: number
  @Trace matchCount: number
  @Trace sniffedMedia: string[]
  // 原版 k6.g 拖动实时预览：onProgressChanged 直接对当前 WebView setTextZoom，
  // 不落库；页面跳转后由 e8/i.M() 重新应用正式缩放（此处 onPageBegin 清零）
  @Trace liveZoom: number = 0
  // 原版 p4/c.java:110 onReceivedIcon：标签捕获的站点图标
  @Trace icon: image.PixelMap | null
  controller: webview.WebviewController

  constructor(id: number, incognito: boolean) {
    this.id = id
    this.incognito = incognito
    this.title = ''
    this.url = ''
    this.progress = 0
    this.adCount = 0
    this.canBack = false
    this.canForward = false
    this.loading = false
    this.isError = false
    this.errorDesc = ''
    this.initialUrl = ''
    this.matchOrdinal = 0
    this.matchCount = 0
    this.sniffedMedia = []
    this.icon = null
    this.controller = new webview.WebviewController()
  }

  isHomePage(): boolean {
    return this.url === '' || this.url === 'about:blank'
  }

  displayTitle(fallback: string): string {
    if (this.isHomePage()) {
      return fallback
    }
    if (this.title !== '') {
      return this.title
    }
    return this.url
  }
}

export class BookmarkRec {
  id: number
  title: string
  url: string
  folder: string
  // 原版 bookmark_items.folder_id（o9/g.java:28）：0=根目录
  folderId: number
  // 原版 bookmark_items.ordering（o9/g.java:28）：文件夹内排序，独立于 created
  ordering: number
  created: number
  updatedAt: number

  constructor() {
    this.id = -1
    this.title = ''
    this.url = ''
    this.folder = ''
    this.folderId = 0
    this.ordering = 0
    this.created = 0
    this.updatedAt = 0
  }

  static fromJson(obj: Record<string, Object>): BookmarkRec | null {
    const rec = new BookmarkRec()
    const id = obj['id']
    const title = obj['title']
    const url = obj['url']
    const folder = obj['folder']
    const folderId = obj['folderId']
    const ordering = obj['ordering']
    const created = obj['created']
    const updatedAt = obj['updatedAt']
    if (typeof id === 'number' && typeof title === 'string' && typeof url === 'string') {
      rec.id = id
      rec.title = title
      rec.url = url
      if (typeof folder === 'string') {
        rec.folder = folder
      }
      if (typeof folderId === 'number') {
        rec.folderId = folderId
      }
      if (typeof ordering === 'number') {
        rec.ordering = ordering
      }
      if (typeof created === 'number') {
        rec.created = created
      }
      if (typeof updatedAt === 'number') {
        rec.updatedAt = updatedAt
      }
      return rec
    }
    return null
  }
}

// 原版 bookmark_folders 表（o9/g.java:29-30）
export class BookmarkFolderRec {
  id: number
  title: string
  parentId: number
  ordering: number
  created: number

  constructor() {
    this.id = -1
    this.title = ''
    this.parentId = 0
    this.ordering = 0
    this.created = 0
  }

  static fromJson(obj: Record<string, Object>): BookmarkFolderRec | null {
    const rec = new BookmarkFolderRec()
    const id = obj['id']
    const title = obj['title']
    const parentId = obj['parentId']
    const ordering = obj['ordering']
    const created = obj['created']
    if (typeof id === 'number' && typeof title === 'string') {
      rec.id = id
      rec.title = title
      if (typeof parentId === 'number') {
        rec.parentId = parentId
      }
      if (typeof ordering === 'number') {
        rec.ordering = ordering
      }
      if (typeof created === 'number') {
        rec.created = created
      }
      return rec
    }
    return null
  }
}

export class HistoryRec {
  id: number
  title: string
  url: string
  visited: number

  constructor() {
    this.id = -1
    this.title = ''
    this.url = ''
    this.visited = 0
  }

  static fromJson(obj: Record<string, Object>): HistoryRec | null {
    const rec = new HistoryRec()
    const id = obj['id']
    const title = obj['title']
    const url = obj['url']
    const visited = obj['visited']
    if (typeof id === 'number' && typeof title === 'string' && typeof url === 'string') {
      rec.id = id
      rec.title = title
      rec.url = url
      if (typeof visited === 'number') {
        rec.visited = visited
      }
      return rec
    }
    return null
  }
}

export class DownloadRec {
  id: number
  url: string
  path: string
  mime: string
  size: number
  received: number
  status: DownloadStatus
  created: number
  errorMessage: string
  // 原版 downloader tasks 表列（g5.c/f5.d.java）：引擎状态码（90/91/92/95/80/100/200+），0=非引擎托管
  state: number
  speed: number
  chunks: number
  flags: number
  priority: number
  header: string
  updatedAt: number

  constructor() {
    this.id = -1
    this.url = ''
    this.path = ''
    this.mime = ''
    this.size = 0
    this.received = 0
    this.status = DownloadStatus.Running
    this.created = 0
    this.errorMessage = ''
    this.state = 0
    this.speed = 0
    this.chunks = 1
    this.flags = 0
    this.priority = 0
    this.header = ''
    this.updatedAt = 0
  }

  static fromJson(obj: Record<string, Object>): DownloadRec | null {
    const rec = new DownloadRec()
    const id = obj['id']
    const url = obj['url']
    const path = obj['path']
    const mime = obj['mime']
    const size = obj['size']
    const received = obj['received']
    const status = obj['status']
    const created = obj['created']
    if (typeof id === 'number' && typeof url === 'string' && typeof path === 'string') {
      rec.id = id
      rec.url = url
      rec.path = path
      if (typeof mime === 'string') {
        rec.mime = mime
      }
      if (typeof size === 'number') {
        rec.size = size
      }
      if (typeof received === 'number') {
        rec.received = received
      }
      if (typeof status === 'number') {
        rec.status = status
      }
      if (typeof created === 'number') {
        rec.created = created
      }
      const errorMessage = obj['errorMessage']
      if (typeof errorMessage === 'string') {
        rec.errorMessage = errorMessage
      }
      const state = obj['state']
      if (typeof state === 'number') {
        rec.state = state
      }
      const speed = obj['speed']
      if (typeof speed === 'number') {
        rec.speed = speed
      }
      const chunks = obj['chunks']
      if (typeof chunks === 'number') {
        rec.chunks = chunks
      }
      const flags = obj['flags']
      if (typeof flags === 'number') {
        rec.flags = flags
      }
      const priority = obj['priority']
      if (typeof priority === 'number') {
        rec.priority = priority
      }
      const header = obj['header']
      if (typeof header === 'string') {
        rec.header = header
      }
      const updatedAt = obj['updatedAt']
      if (typeof updatedAt === 'number') {
        rec.updatedAt = updatedAt
      }
      return rec
    }
    return null
  }
}

export class SiteSetting {
  host: string
  pcMode: boolean
  noImage: boolean
  allowAds: boolean
  forceDark: boolean
  // 原版网站设定 JavaScript（jb/y4）：默认允许（true）
  javaScript: boolean

  constructor(host: string) {
    this.host = host
    this.pcMode = false
    this.noImage = false
    this.allowAds = false
    this.forceDark = false
    this.javaScript = true
  }

  static fromJson(obj: Record<string, Object>): SiteSetting | null {
    const host = obj['host']
    if (typeof host !== 'string' || host === '') {
      return null
    }
    const setting = new SiteSetting(host)
    const pcMode = obj['pcMode']
    const noImage = obj['noImage']
    const allowAds = obj['allowAds']
    const forceDark = obj['forceDark']
    const javaScript = obj['javaScript']
    if (typeof pcMode === 'boolean') {
      setting.pcMode = pcMode
    }
    if (typeof noImage === 'boolean') {
      setting.noImage = noImage
    }
    if (typeof allowAds === 'boolean') {
      setting.allowAds = allowAds
    }
    if (typeof forceDark === 'boolean') {
      setting.forceDark = forceDark
    }
    if (typeof javaScript === 'boolean') {
      setting.javaScript = javaScript
    }
    return setting
  }
}

export class UserScriptRec {
  id: number
  name: string
  code: string
  enabled: boolean
  // r5/d.j()：合并后的模式列表（JSON 数组串，includes=@include+@match，excludes=@exclude+@exclude-match）
  includes: string
  excludes: string
  // r5/b：runAt（1=document-start/2=document-end/4=默认，打包位）与 grant 位（1=GM_setValue 已授予）
  runAt: number
  grantBits: number
  unwrap: boolean
  downloadUrl: string
  homepageUrl: string
  version: string
  // r5/a.f：@require 解析结果（JSON 数组串，s5.e.d）
  requires: string

  constructor() {
    this.id = -1
    this.name = ''
    this.code = ''
    this.enabled = true
    this.includes = '[]'
    this.excludes = '[]'
    this.runAt = 4
    this.grantBits = 0
    this.unwrap = false
    this.downloadUrl = ''
    this.homepageUrl = ''
    this.version = ''
    this.requires = '[]'
  }

  static fromJson(obj: Record<string, Object>): UserScriptRec | null {
    const rec = new UserScriptRec()
    const id = obj['id']
    const name = obj['name']
    const code = obj['code']
    const enabled = obj['enabled']
    const includes = obj['includes']
    const excludes = obj['excludes']
    const runAt = obj['runAt']
    const grantBits = obj['grantBits']
    const unwrap = obj['unwrap']
    const downloadUrl = obj['downloadUrl']
    const homepageUrl = obj['homepageUrl']
    const version = obj['version']
    if (typeof id === 'number' && typeof name === 'string' && typeof code === 'string') {
      rec.id = id
      rec.name = name
      rec.code = code
      if (typeof enabled === 'boolean') {
        rec.enabled = enabled
      }
      if (typeof includes === 'string') {
        rec.includes = includes
      }
      if (typeof excludes === 'string') {
        rec.excludes = excludes
      }
      if (typeof runAt === 'number') {
        rec.runAt = runAt
      }
      if (typeof grantBits === 'number') {
        rec.grantBits = grantBits
      }
      if (typeof unwrap === 'boolean') {
        rec.unwrap = unwrap
      }
      if (typeof downloadUrl === 'string') {
        rec.downloadUrl = downloadUrl
      }
      if (typeof homepageUrl === 'string') {
        rec.homepageUrl = homepageUrl
      }
      if (typeof version === 'string') {
        rec.version = version
      }
      const requires = obj['requires']
      if (typeof requires === 'string') {
        rec.requires = requires
      }
      return rec
    }
    return null
  }
}

// s5/a.java：glob/regex 匹配（小写化；/regex/ 去斜杠补 .*；仅 '*' 通配；scheme://*.host 双匹配）
export function globMatches(pattern: string, url: string): boolean {
  const lowerPattern = pattern.toLowerCase()
  const lowerUrl = url.toLowerCase()
  if (lowerPattern.length >= 2 && lowerPattern.startsWith('/') && lowerPattern.endsWith('/')) {
    return wildcardOnlyMatch(lowerPattern.substring(1, lowerPattern.length - 1), lowerUrl)
  }
  if (wildcardOnlyMatch(lowerPattern, lowerUrl)) {
    return true
  }
  const schemeIndex = lowerPattern.indexOf('://')
  if (schemeIndex > 0) {
    const rest = lowerPattern.substring(schemeIndex + 3)
    if (rest.startsWith('*.')) {
      const hostPattern = lowerPattern.substring(0, schemeIndex + 3) + rest.substring(2)
      return wildcardOnlyMatch(hostPattern, lowerUrl) ||
        wildcardOnlyMatch(lowerPattern.substring(0, schemeIndex + 3) + rest.substring(1), lowerUrl)
    }
  }
  return false
}

// s5/a.d()：仅 '*' 通配（无 '^'/'|'），逐段前缀匹配
export function wildcardOnlyMatch(pattern: string, text: string): boolean {
  if (pattern === text) {
    return true
  }
  const stars = pattern.split('*')
  let index = 0
  for (let i = 0; i < stars.length; i++) {
    const part = stars[i]
    if (part === '') {
      continue
    }
    if (i === 0) {
      if (!text.startsWith(part)) {
        return false
      }
      index = part.length
    } else {
      const found = text.indexOf(part, index)
      if (found < 0) {
        return false
      }
      index = found + part.length
    }
  }
  const lastPart = stars[stars.length - 1]
  if (lastPart !== '' && !text.endsWith(lastPart)) {
    return false
  }
  return true
}

export function parseJsonArray(text: string): string[] {
  try {
    const parsed: object = JSON.parse(text)
    if (parsed instanceof Array) {
      const result: string[] = []
      for (let i = 0; i < parsed.length; i++) {
        if (typeof parsed[i] === 'string') {
          result.push(parsed[i])
        }
      }
      return result
    }
  } catch (error) {
  }
  return []
}

// r5/a.b()：@grant 位映射（1:1）
export function grantBitOf(name: string): number {
  switch (name) {
    case 'GM_deleteValue':
      return 8
    case 'GM_getResourceText':
      return 32
    case 'GM_getResourceURL':
      return 16
    case 'GM_addStyle':
      return 64
    case 'GM_addElement':
      return 128
    case 'GM_xmlhttpRequest':
      return 256
    case 'GM_log':
      return 512
    case 'GM_setClipboard':
      return 1024
    case 'GM_info':
      return 524288
    case 'GM_getValue':
      return 2
    case 'GM_setValue':
      return 1
    case 'GM_listValues':
      return 4
    case 'GM_addValueChangeListener':
      return 8192
    case 'GM_removeValueChangeListener':
      return 16384
    case 'GM_registerMenuCommand':
      return 65536
    case 'GM_unregisterMenuCommand':
      return 131072
    case 'GM_notification':
      return 262144
    case 'GM_openInTab':
      return 32768
    case 'GM_download':
      return 2048
    case 'GM.getValue':
      return 2097152
    case 'GM.setValue':
      return 8388608
    case 'GM.listValues':
      return 4194304
    case 'GM.deleteValue':
      return 1048576
    case 'GM.addStyle':
      return 16777216
    case 'GM.addElement':
      return 33554432
    case 'GM.getResourceUrl':
      return 67108864
    case 'GM.openInTab':
      return 268435456
    case 'GM.registerMenuCommand':
      return 536870912
    case 'GM.setClipboard':
      return 1073741824
    case 'GM.notification':
      return 134217728
    case 'GM.xmlHttpRequest':
      return -2147483648
    case 'GM_info':
      return 4096
    case 'unsafeWindow':
    case 'none':
      return 0
    default:
      return 0
  }
}

// s5/b.k()：@require 相对地址解析
function resolveRequireUrl(url: string, baseUrl: string): string {
  if (url.startsWith('http://') || url.startsWith('https://')) {
    return url
  }
  if (baseUrl === '') {
    return url
  }
  const schemeIdx = baseUrl.indexOf('://')
  if (schemeIdx < 0) {
    return url
  }
  if (url.startsWith('//')) {
    return baseUrl.substring(0, schemeIdx) + url
  }
  const hostStart = schemeIdx + 3
  const pathIdx = baseUrl.indexOf('/', hostStart)
  const origin = pathIdx < 0 ? baseUrl : baseUrl.substring(0, pathIdx)
  if (url.startsWith('/')) {
    return origin + url
  }
  const dirIdx = baseUrl.lastIndexOf('/')
  return baseUrl.substring(0, dirIdx + 1) + url
}

// r5/a.f()：解析用户脚本元数据块，未找到 ==/UserScript== 结束标记返回 null
export function parseUserScriptMeta(code: string, sourceUrl: string): UserScriptRec | null {
  if (code === null || code === '') {
    return null
  }
  const rec = new UserScriptRec()
  rec.code = code
  let fileName: string | null = null
  let sourceHost: string | null = null
  if (sourceUrl !== null && sourceUrl !== '') {
    const lastSlash = sourceUrl.lastIndexOf('/') + 1
    if (lastSlash !== 0 && lastSlash !== sourceUrl.length) {
      let baseName = sourceUrl.substring(lastSlash).replace('.user.js', '')
      try {
        baseName = decodeURIComponent(baseName)
      } catch (error) {
      }
      fileName = baseName
    }
    const schemeIdx = sourceUrl.indexOf('://')
    if (schemeIdx !== -1) {
      const hostStart = schemeIdx + 3
      let pathIdx = sourceUrl.indexOf('/', hostStart)
      if (pathIdx === -1) {
        pathIdx = sourceUrl.length
      }
      sourceHost = sourceUrl.substring(hostStart, pathIdx)
    }
    rec.downloadUrl = sourceUrl
  }
  const includes: string[] = []
  const matches: string[] = []
  const excludes: string[] = []
  const excludeMatches: string[] = []
  const requires: string[] = []
  let localizedMetaName: string | null = null
  const lines = code.split('\n')
  const langTag = `name:${i18n.System.getSystemLanguage().split('-')[0].toLowerCase()}`
  let inMeta = false
  for (let i = 0; i < lines.length; i++) {
    const line = lines[i].trim()
    if (!inMeta) {
      if (line.startsWith('// ==UserScript==')) {
        inMeta = true
      }
      continue
    }
    if (line.startsWith('// ==/UserScript==')) {
      if (fileName === null || sourceHost === null) {
        return null
      }
      let name = localizedMetaName
      if (name === null) {
        name = fileName
      }
      rec.name = name
      rec.includes = JSON.stringify(includes.concat(matches))
      rec.excludes = JSON.stringify(excludes.concat(excludeMatches))
      rec.requires = JSON.stringify(requires)
      return rec
    }
    const metaMatch = /^\/\/[\s\u200B]*@(\S+)(?:[\s\u200B]+(.*))?$/.exec(line)
    if (metaMatch === null) {
      continue
    }
    const key = metaMatch[1]
    const value = metaMatch[2] ?? ''
    const trimmed = value.trim()
    if (key === 'unwrap') {
      rec.unwrap = true
    } else if (trimmed !== '') {
      switch (key) {
        case 'exclude':
          excludes.push(trimmed)
          break
        case 'downloadURL':
          rec.downloadUrl = trimmed
          break
        case 'run-at':
          if (trimmed === 'document-start') {
            rec.runAt = 1
          } else if (trimmed === 'document-end' || trimmed === 'document-body') {
            rec.runAt = 2
          } else if (trimmed === 'context-menu') {
            rec.runAt = 8
          } else {
            rec.runAt = 4
          }
          break
        case 'exclude-match':
          excludeMatches.push(trimmed)
          break
        case 'icon':
          break
        case 'name':
          fileName = trimmed
          break
        case 'grant':
          rec.grantBits |= grantBitOf(trimmed)
          break
        case 'match':
          matches.push(trimmed)
          break
        case 'version':
          rec.version = trimmed
          break
        case 'require':
          requires.push(resolveRequireUrl(trimmed, sourceUrl))
          break
        case 'namespace':
          break
        case 'homepageURL':
          rec.homepageUrl = trimmed
          break
        case 'include':
          includes.push(trimmed)
          break
        default:
          if (key.startsWith('name:')) {
            if (localizedMetaName === null || key === langTag) {
              localizedMetaName = trimmed
            }
          }
          break
      }
    }
  }
  return null
}

export class RuleEntry {
  domain: string
  isAllow: boolean

  constructor(domain: string, isAllow: boolean) {
    this.domain = domain
    this.isAllow = isAllow
  }

  static fromJson(obj: Record<string, Object>): RuleEntry | null {
    const domain = obj['domain']
    const isAllow = obj['isAllow']
    if (typeof domain === 'string' && typeof isAllow === 'boolean') {
      return new RuleEntry(domain, isAllow)
    }
    return null
  }
}

export class RuleSubEntry {
  key: string
  name: string
  url: string
  enabled: boolean
  ruleCount: number
  lastUpdate: number
  isPreset: boolean

  constructor(key: string, name: string, url: string, enabled: boolean, ruleCount: number, lastUpdate: number, isPreset: boolean) {
    this.key = key
    this.name = name
    this.url = url
    this.enabled = enabled
    this.ruleCount = ruleCount
    this.lastUpdate = lastUpdate
    this.isPreset = isPreset
  }
}

// 原版 b5/d.java（ZH 区域）：预设订阅 URL 与顺序 1:1
export const RULE_SUB_PRESETS: RuleSubEntry[] = [
  new RuleSubEntry('easylist', 'Easylist', 'https://easylist-downloads.adblockplus.org/easylist.txt', false, 0, 0, true),
  new RuleSubEntry('easylistchina', 'Easylist China', 'https://easylist-downloads.adblockplus.org/easylistchina.txt', false, 0, 0, true),
  new RuleSubEntry('cjx-annoyance', "CJX's Annoyance List", 'https://fastly.jsdelivr.net/gh/cjx82630/cjxlist/cjx-annoyance.txt', false, 0, 0, true),
  new RuleSubEntry('easyprivacy', 'Easylist Privacy', 'https://easylist-downloads.adblockplus.org/easyprivacy.txt', false, 0, 0, true),
  new RuleSubEntry('antiadblock', 'Easylist Warning Removal', 'https://easylist-downloads.adblockplus.org/antiadblockfilters.txt', false, 0, 0, true)
]

// 原版主页收藏独立存储（y9.a/n9.b），与书签是两个列表；icon 为本地图标文件路径
export class HomeFavRec {
  id: number
  title: string
  url: string
  icon: string
  position: number

  constructor() {
    this.id = -1
    this.title = ''
    this.url = ''
    this.icon = ''
    this.position = 0
  }
}
