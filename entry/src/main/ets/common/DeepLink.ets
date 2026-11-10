import { util } from '@kit.ArkTS'

// 原版 uia://(v://) 深链内部命令协议解析 —— 1:1 移植 z8/w2.java + z8/b0.Q() + k6.u() 分发顺序。
// 入口链路：原版 Trampoline/Search → Shell → k6.c0 → na.l("intentTab") → b0.A/b0.Q → k6.u()；
// 鸿蒙侧：EntryAbility.extractEntryUrl（uia scheme want）→ AppStorage/emitter → Index.handleInternalCmd。

export const UIA_CMD_EVENT_ID = 10004

// 原版命令 → 动作对照（k6.u() 各分支）：
// folder://X → k6.u 8567：书签文件夹（主页型 2/11 时 s1，否则 Z9）
// history:// → k6.u 8577：s1(3) 历史页
// v://blocker/jump?url= → k6.u 8598：打开解码后 url
// v://error/jump?url= → k6.u 8612：打开解码后 url
// v://scanner → k6.u 8624：ga() 扫码
// v://skins → k6.u 8628：lb.k 皮肤页
// v://search[?q=] → k6.u 8632：k() 取 q；空→na() 搜索界面，否则 Ta(q,true) 搜索
// v://history → k6.u 8641：主页型 5 时 s1(3)，否则 fa() 历史页
// v://downloader → k6.u 8649：ca() 下载页
// v://readaloud → k6.u 8653：ha() 朗读
// v://bookmarks[/?folder=&folderName=] → k6.u 8657：aa/X9/s1 书签页
// v://translator/translate?text= → k6.u 8669：Eb(text) 翻译文本弹窗
// v://tabs/restore?ids=&selected= → k6.u 8682：F1(ids, selected) 恢复标签
// 非 v:// 的特殊 scheme（k6.u 8581-8597，注意顺序在 w2.z(v://) 判定之后）：
//   thunder:// / qqdl:// / flashget:// → z8.b0.D(str) 解出直链后 mb(...) 下载
//   baidubox:// / baiduboxapp:// / baiduboxlite:// → 直接 return true（忽略）
//   file:// 且扩展名 pdf → g6.i.h(za.g.class, pdfPath) 内置 PDF 查看器
//   其余 → V9(str)（外部 Intent / 应用内跳转）
// 其余 v://xxx → b0.Q()：home→V0()、log→s1(6)、offline→s1(7)、about→s1(4)、未知→s1(5 catalog)
export enum UiaCmdKind {
  NONE = 0,
  FOLDER = 1,
  HISTORY_URI = 2,
  BLOCKER_JUMP = 3,
  ERROR_JUMP = 4,
  SCANNER = 5,
  SKINS = 6,
  SEARCH = 7,
  HISTORY = 8,
  DOWNLOADER = 9,
  READ_ALOUD = 10,
  BOOKMARKS = 11,
  TRANSLATE_TEXT = 12,
  TABS_RESTORE = 13,
  HOME = 14,
  LOG = 15,
  OFFLINE = 16,
  ABOUT = 17,
  CATALOG = 18,
  // —— 非 v:// 特殊 scheme（k6.u 8581-8597）——
  // 三种下载描述 scheme → z8.b0.D() 解直链后走下载管线
  SCHEME_DOWNLOAD = 19,
  // baidubox:// / baiduboxapp:// / baiduboxlite:// → 原版直接 return true（忽略，不打开）
  SCHEME_IGNORED = 20,
  // file:// 且扩展名 pdf → g6.i.h(za.g.class, pdfPath) 内置 PDF 查看器
  SCHEME_PDF = 21
}

export class UiaDeepLink {
  kind: UiaCmdKind = UiaCmdKind.NONE
  url: string = ''
  query: string = ''
  text: string = ''
  folder: string = ''
  folderName: string = ''
  ids: string[] = []
  selected: string = ''
}

// z8.w2.C：忽略大小写前缀匹配
function hasPrefix(text: string, prefix: string): boolean {
  return text.length >= prefix.length &&
    prefix.toLowerCase() === text.substring(0, prefix.length).toLowerCase()
}

// z8.w2.a：前缀匹配 + 紧随字符为 '?' 或 '/'
function hasPrefixSep(text: string, prefix: string): boolean {
  if (!hasPrefix(text, prefix)) {
    return false
  }
  if (text.length <= prefix.length) {
    return true
  }
  const next: string = text.charAt(prefix.length)
  return next === '?' || next === '/'
}

// 原版 i6/i0.s()（481-486）= m() || n()：严格 http:// 或 https://（忽略大小写），
// 且要求长度足够（m 要 >6、n 要 >7）。
export function isStrictHttp(url: string): boolean {
  if (url.length > 6 && url.substring(0, 7).toLowerCase() === 'http://') {
    return true
  }
  return url.length > 7 && url.substring(0, 8).toLowerCase() === 'https://'
}

// 原版 i6/i0.p()（347-356）：长度 > 10 且前 11 字符 equalsIgnoreCase("javascript:")
export function isJavaScriptUrl(url: string): boolean {
  if (url.length <= 10) {
    return false
  }
  return url.substring(0, 11).toLowerCase() === 'javascript:'
}

// v0.i：URL 解码（失败回退原文）
function urlDecode(text: string): string {
  try {
    return decodeURIComponent(text)
  } catch (error) {
    return text
  }
}

// z8.w2.k → i6.i0.g(str, "q=", true)：取 q 参数值并解码
function extractQuery(text: string): string {
  const marker: string = 'q='
  const from: number = text.indexOf('?')
  if (from < 0) {
    return ''
  }
  let idx: number = text.indexOf(marker, from)
  while (idx >= 0) {
    const head: string = text.charAt(idx - 1)
    if (head === '?' || head === '&') {
      const start: number = idx + marker.length
      let end: number = text.indexOf('&', start)
      if (end < 0) {
        end = text.length
      }
      if (start >= end) {
        return ''
      }
      return urlDecode(text.substring(start, end))
    }
    idx = text.indexOf(marker, idx + 1)
  }
  return ''
}

// z8.w2.i：v://bookmarks 的 ?folder= 值（不解码，原样保留）
function extractFolder(text: string): string {
  const marker: string = '?folder='
  const idx: number = text.indexOf(marker)
  if (idx < 0) {
    return ''
  }
  const start: number = idx + marker.length
  let end: number = text.indexOf('&', start)
  if (end < 0) {
    end = text.length
  }
  return text.substring(start, end)
}

// z8.w2.h 的 folderName 部分：&folderName= 值（解码）
function extractFolderName(text: string): string {
  const marker: string = '&folderName='
  const idx: number = text.indexOf(marker)
  if (idx < 0) {
    return ''
  }
  const start: number = idx + marker.length
  let end: number = text.indexOf('&', start)
  if (end < 0) {
    end = text.length
  }
  return urlDecode(text.substring(start, end))
}

// 原版 i6/i0.c(str)：取 URL 扩展名（忽略大小写）。
// i0.d()（105-130）从串尾反向扫：'#'/'?' 收缩右界、'.' 记录起点、'/' 截断。
function urlExtension(url: string): string {
  let right: number = url.length
  let dotIndex: number = -1
  let i: number = url.length - 1
  while (i >= 0) {
    const ch: string = url.charAt(i)
    if (ch === '#' || ch === '?') {
      right = i
    } else if (ch === '.') {
      if (dotIndex === -1 || dotIndex > right) {
        dotIndex = i + 1
      }
    } else if (ch === '/') {
      if (dotIndex === -1 || dotIndex > right ||
        (i >= 2 && url.charAt(i - 1) === '/' && url.charAt(i - 2) === ':')) {
        return ''
      }
      break
    }
    i--
  }
  if (dotIndex === -1 || dotIndex >= right) {
    return ''
  }
  return url.substring(dotIndex, right).toLowerCase()
}

// 原版 z8.v0.a(str)：Base64 解码（失败回退空串）
function base64Decode(text: string): string {
  try {
    const helper: util.Base64Helper = new util.Base64Helper()
    const bytes: Uint8Array = helper.decodeSync(text)
    return util.TextDecoder.create('utf-8').decodeToString(bytes)
  } catch (error) {
    return ''
  }
}

// 原版 z8.b0.D(str)（96-113）：迅雷/快车/QQ 旋风三种下载描述 scheme 解出真实直链。
//   thunder://  解码后去掉首尾各 2 字符（AA...ZZ）
//   qqdl://     直接解码
//   flashget:// 解码后去掉 "[FLASHGET]"
export function decodeDownloadScheme(raw: string): string {
  const text: string = raw.trim()
  let decoded: string = ''
  if (text.startsWith('thunder://')) {
    const body: string = base64Decode(text.replace('thunder://', ''))
    if (body.length > 4) {
      decoded = body.substring(2, body.length - 2)
    }
  } else if (text.startsWith('qqdl://')) {
    decoded = base64Decode(text.replace('qqdl://', ''))
  } else if (text.startsWith('flashget://')) {
    decoded = base64Decode(text.replace('flashget://', '')).replace('[FLASHGET]', '')
  }
  return decoded.trim()
}

// 原版 k6.u() 8581-8597：非 v:// 的 scheme 分流（顺序即代码顺序，不可调换）。
//  8522 thunder:// / qqdl:// / flashget:// → z8.b0.D 解直链后 mb() 下载（空直链则忽略）
//  8589 baidubox:// / baiduboxapp:// / baiduboxlite:// → return true（什么都不做）
//  8592 file:// 且 i0.c() == "pdf" → g6.i.h(za.g.class, pdfPath)
//  8594 其余 → V9(str)（外部 Intent，鸿蒙侧由系统 want 打开，本命令表不处理）
function parseSpecialScheme(text: string): UiaDeepLink | null {
  const result: UiaDeepLink = new UiaDeepLink()
  if (text.startsWith('thunder://') || text.startsWith('qqdl://') || text.startsWith('flashget://')) {
    const link: string = decodeDownloadScheme(text)
    if (link === '') {
      // 原版：直链为空时仍 return true（已消费），只是不发起下载
      result.kind = UiaCmdKind.SCHEME_IGNORED
      return result
    }
    result.kind = UiaCmdKind.SCHEME_DOWNLOAD
    result.url = link
    return result
  }
  if (text.startsWith('baidubox://') || text.startsWith('baiduboxapp://') ||
    text.startsWith('baiduboxlite://')) {
    result.kind = UiaCmdKind.SCHEME_IGNORED
    return result
  }
  if (text.startsWith('file://') && urlExtension(text) === 'pdf') {
    result.kind = UiaCmdKind.SCHEME_PDF
    result.url = text
    return result
  }
  return null
}

// uia:// → v://（k6.u 8564：前 6 位忽略大小写匹配即替换）
export function parseUiaDeepLink(raw: string): UiaDeepLink | null {
  let text: string = raw
  if (text.length >= 6 && 'uia://'.toLowerCase() === text.substring(0, 6).toLowerCase()) {
    text = 'v://' + text.substring(6)
  }
  const result: UiaDeepLink = new UiaDeepLink()
  // k6.u() 分发顺序 1:1
  if (hasPrefix(text, 'folder://')) {
    result.kind = UiaCmdKind.FOLDER
    result.url = text.substring(9)
    return result
  }
  if (hasPrefix(text, 'history://')) {
    result.kind = UiaCmdKind.HISTORY_URI
    return result
  }
  // 原版 k6.u() 8581：先问 w2.z(str)（是否 v://）。非 v:// 才进入下面的
  // 「特殊 scheme → V9」分支；v:// 继续走后面的内部命令表。
  if (!hasPrefix(text, 'v://')) {
    return parseSpecialScheme(text)
  }
  // 原版 k6.u()（8581-8630）两条跳转分支的守卫条件不同，必须分别对齐：
  //  · blocker/jump（w2.o）：取 url 后 if (i6.i0.s(url)) 才打开；
  //    i0.s()（i6/i0.java:481-486）要求严格 http:// 或 https:// 前缀，否则不打开。
  //  · error/jump（w2.r）：取 url 后 if (!empty && !i6.i0.p(url)) 才打开；
  //    i0.p()（i6/i0.java:347-356）判定前 11 字符是否 equalsIgnoreCase("javascript:")，
  //    即明确阻止 error/jump 打开 javascript: URL（安全约束）。
  // blocker/jump（w2.o）：原版取参后 if (i6.i0.s(url)) 才打开 —— i0.s()（i6/i0.java:481-486）
  // 要求严格 http:// 或 https:// 前缀；不满足则分支消费但不打开。
  if (hasPrefix(text, 'v://blocker/jump?url=')) {
    const jump: string = urlDecode(text.substring(21))
    if (isStrictHttp(jump)) {
      result.kind = UiaCmdKind.BLOCKER_JUMP
      result.url = jump
    }
    return result
  }
  // error/jump（w2.r）：原版取参后 if (!empty && !i6.i0.p(url)) 才打开 ——
  // i0.p()（i6/i0.java:347-356）判前 11 字符是否 equalsIgnoreCase("javascript:")。
  // 即在解析层就拒绝把 javascript: URL 变成可执行跳转（安全约束）。
  if (hasPrefix(text, 'v://error/jump?url=')) {
    let end: number = text.indexOf('&', 19)
    if (end < 0) {
      end = text.length
    }
    const jump: string = urlDecode(text.substring(19, end))
    if (jump !== '' && !isJavaScriptUrl(jump)) {
      result.kind = UiaCmdKind.ERROR_JUMP
      result.url = jump
    }
    return result
  }
  if (hasPrefixSep(text, 'v://scanner')) {
    result.kind = UiaCmdKind.SCANNER
    return result
  }
  if (hasPrefixSep(text, 'v://skins')) {
    result.kind = UiaCmdKind.SKINS
    return result
  }
  if (hasPrefixSep(text, 'v://search')) {
    result.kind = UiaCmdKind.SEARCH
    result.query = extractQuery(text)
    return result
  }
  if (hasPrefixSep(text, 'v://history')) {
    result.kind = UiaCmdKind.HISTORY
    return result
  }
  if (hasPrefixSep(text, 'v://downloader')) {
    result.kind = UiaCmdKind.DOWNLOADER
    return result
  }
  if (hasPrefixSep(text, 'v://readaloud')) {
    result.kind = UiaCmdKind.READ_ALOUD
    return result
  }
  if (hasPrefixSep(text, 'v://bookmarks')) {
    result.kind = UiaCmdKind.BOOKMARKS
    result.folder = extractFolder(text)
    result.folderName = extractFolderName(text)
    return result
  }
  if (hasPrefix(text, 'v://translator/translate?text=')) {
    result.kind = UiaCmdKind.TRANSLATE_TEXT
    let end: number = text.indexOf('&', 30)
    if (end < 0) {
      end = text.length
    }
    result.text = urlDecode(text.substring(30, end))
    return result
  }
  if (hasPrefix(text, 'v://tabs')) {
    // z8.w2.j：仅 /restore?ids= 变体有动作；纯 v://tabs 原版为 no-op
    const restoreIdx: number = text.indexOf('/restore?ids=')
    if (restoreIdx < 0) {
      return result
    }
    const idsStart: number = restoreIdx + '/restore?ids='.length
    const selectedIdx: number = text.indexOf('&selected=')
    let idsText: string
    if (selectedIdx < 0) {
      idsText = text.substring(idsStart)
      result.selected = ''
    } else {
      idsText = text.substring(idsStart, selectedIdx)
      result.selected = text.substring(selectedIdx + '&selected='.length)
    }
    result.kind = UiaCmdKind.TABS_RESTORE
    result.ids = idsText.split(',')
    return result
  }
  // z8.b0.Q()：通用 v://xxx → host 段分发
  let segEnd: number = text.indexOf('/', 4)
  if (segEnd < 0) {
    segEnd = text.indexOf('?', 4)
  }
  if (segEnd < 0) {
    segEnd = text.length
  }
  const segment: string = text.substring(4, segEnd)
  if (segment === 'home') {
    result.kind = UiaCmdKind.HOME
  } else if (segment === 'log') {
    result.kind = UiaCmdKind.LOG
  } else if (segment === 'offline') {
    result.kind = UiaCmdKind.OFFLINE
  } else if (segment === 'about') {
    result.kind = UiaCmdKind.ABOUT
  } else {
    // 原版默认 id 5 → catalog.html（站点目录页）
    result.kind = UiaCmdKind.CATALOG
  }
  return result
}
