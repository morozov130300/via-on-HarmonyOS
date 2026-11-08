// 原版 via://(v://) 深链内部命令协议解析 —— 1:1 移植 z8/w2.java + z8/b0.Q() + k6.u() 分发顺序。
// 入口链路：原版 Trampoline/Search → Shell → k6.c0 → na.l("intentTab") → b0.A/b0.Q → k6.u()；
// 鸿蒙侧：EntryAbility.extractEntryUrl（via scheme want）→ AppStorage/emitter → Index.handleInternalCmd。

export const VIA_CMD_EVENT_ID = 10004

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
// 其余 v://xxx → b0.Q()：home→V0()、log→s1(6)、offline→s1(7)、about→s1(4)、未知→s1(5 catalog)
export enum ViaCmdKind {
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
  CATALOG = 18
}

export class ViaDeepLink {
  kind: ViaCmdKind = ViaCmdKind.NONE
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

// via:// → v://（k6.u 8564：前 6 位忽略大小写匹配即替换）
export function parseViaDeepLink(raw: string): ViaDeepLink | null {
  let text: string = raw
  if (text.length >= 6 && 'via://'.toLowerCase() === text.substring(0, 6).toLowerCase()) {
    text = 'v://' + text.substring(6)
  }
  const result: ViaDeepLink = new ViaDeepLink()
  // k6.u() 分发顺序 1:1
  if (hasPrefix(text, 'folder://')) {
    result.kind = ViaCmdKind.FOLDER
    result.url = text.substring(9)
    return result
  }
  if (hasPrefix(text, 'history://')) {
    result.kind = ViaCmdKind.HISTORY_URI
    return result
  }
  if (!hasPrefix(text, 'v://')) {
    return null
  }
  // 原版 k6.u()（8581-8630）两条跳转分支的守卫条件不同，必须分别对齐：
  //  · blocker/jump（w2.o）：取 url 后 if (i6.i0.s(url)) 才打开；
  //    i0.s()（i6/i0.java:481-486）要求严格 http:// 或 https:// 前缀，否则不打开。
  //  · error/jump（w2.r）：取 url 后 if (!empty && !i6.i0.p(url)) 才打开；
  //    i0.p()（i6/i0.java:347-356）判定前 11 字符是否 equalsIgnoreCase("javascript:")，
  //    即明确阻止 error/jump 打开 javascript: URL（安全约束）。
  if (hasPrefix(text, 'v://blocker/jump?url=')) {
    result.kind = ViaCmdKind.BLOCKER_JUMP
    result.url = urlDecode(text.substring(21))
    return result
  }
  if (hasPrefix(text, 'v://error/jump?url=')) {
    result.kind = ViaCmdKind.ERROR_JUMP
    let end: number = text.indexOf('&', 19)
    if (end < 0) {
      end = text.length
    }
    result.url = urlDecode(text.substring(19, end))
    return result
  }
  if (hasPrefixSep(text, 'v://scanner')) {
    result.kind = ViaCmdKind.SCANNER
    return result
  }
  if (hasPrefixSep(text, 'v://skins')) {
    result.kind = ViaCmdKind.SKINS
    return result
  }
  if (hasPrefixSep(text, 'v://search')) {
    result.kind = ViaCmdKind.SEARCH
    result.query = extractQuery(text)
    return result
  }
  if (hasPrefixSep(text, 'v://history')) {
    result.kind = ViaCmdKind.HISTORY
    return result
  }
  if (hasPrefixSep(text, 'v://downloader')) {
    result.kind = ViaCmdKind.DOWNLOADER
    return result
  }
  if (hasPrefixSep(text, 'v://readaloud')) {
    result.kind = ViaCmdKind.READ_ALOUD
    return result
  }
  if (hasPrefixSep(text, 'v://bookmarks')) {
    result.kind = ViaCmdKind.BOOKMARKS
    result.folder = extractFolder(text)
    result.folderName = extractFolderName(text)
    return result
  }
  if (hasPrefix(text, 'v://translator/translate?text=')) {
    result.kind = ViaCmdKind.TRANSLATE_TEXT
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
    result.kind = ViaCmdKind.TABS_RESTORE
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
    result.kind = ViaCmdKind.HOME
  } else if (segment === 'log') {
    result.kind = ViaCmdKind.LOG
  } else if (segment === 'offline') {
    result.kind = ViaCmdKind.OFFLINE
  } else if (segment === 'about') {
    result.kind = ViaCmdKind.ABOUT
  } else {
    // 原版默认 id 5 → catalog.html（站点目录页）
    result.kind = ViaCmdKind.CATALOG
  }
  return result
}
