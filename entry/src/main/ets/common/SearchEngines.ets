export class SearchEngineDef {
  key: string
  name: string
  template: string
  // 原版引擎 int id（z8/v2.b/c）：内置为负数，自定义引擎为记录主键（≥1）
  id: number

  constructor(key: string, name: string, template: string, id: number = 0) {
    this.key = key
    this.name = name
    this.template = template
    this.id = id
  }
}

// 原版 z8/v2.b/c：内置引擎 key ↔ int id 映射
// -2 百度、-3 必应、-1 谷歌、-5 360、-12 秘塔、-6 搜狗、-4 神马、-11 头条、
// -8 Yahoo、-9 StartPage、-7 Yandex、-10 DuckDuckGo；≥1 为自定义引擎记录主键
class EngineIdPair {
  key: string
  id: number

  constructor(key: string, id: number) {
    this.key = key
    this.id = id
  }
}

const ENGINE_ID_PAIRS: EngineIdPair[] = [
  new EngineIdPair('baidu', -2),
  new EngineIdPair('bing', -3),
  new EngineIdPair('google', -1),
  new EngineIdPair('so360', -5),
  new EngineIdPair('metaso', -12),
  new EngineIdPair('sogou', -6),
  new EngineIdPair('shenma', -4),
  new EngineIdPair('toutiao', -11),
  new EngineIdPair('yahoo', -8),
  new EngineIdPair('startpage', -9),
  new EngineIdPair('yandex', -7),
  new EngineIdPair('duckduckgo', -10)
]

export function builtinEngineId(key: string): number | null {
  for (const pair of ENGINE_ID_PAIRS) {
    if (pair.key === key) {
      return pair.id
    }
  }
  return null
}

export function builtinKeyById(id: number): string | null {
  for (const pair of ENGINE_ID_PAIRS) {
    if (pair.id === id) {
      return pair.key
    }
  }
  return null
}

// 引擎 key → int id：内置返回负 id；'custom:<id>'（id≥1）返回 id；其余 null
export function engineIdFromKey(key: string): number | null {
  const builtin = builtinEngineId(key)
  if (builtin !== null) {
    return builtin
  }
  if (key.startsWith('custom:')) {
    const id = Number(key.substring('custom:'.length))
    if (!Number.isNaN(id) && id >= 1) {
      return id
    }
  }
  return null
}

// int id → 引擎 key：内置返回内置 key；id≥1 返回 'custom:<id>'；其余 null
export function engineKeyFromId(id: number): string | null {
  const builtin = builtinKeyById(id)
  if (builtin !== null) {
    return builtin
  }
  if (id >= 1) {
    return `custom:${id}`
  }
  return null
}

// 原版 z8/v2.b(Context)：内置引擎表（中文名取 values-zh-rCN/strings.xml，品牌名保留英文）
// CN 环境顺序：百度、谷歌、必应、秘塔、搜狗、头条、神马、360、DuckDuckGo
// 非 CN 环境顺序：谷歌、百度、必应、Yahoo、StartPage、DuckDuckGo（RU 环境在谷歌后加 Yandex）
// URL 为原版 z9 各引擎 getUrl（触屏版）：
//   baidu  = https://m.baidu.com/s?from=1022282z&word=（z9/a，bd 远程配置默认 1022282z）
//   bing   = https://www.bing.com/search?q=（z9/b）
//   sogou  = https://wap.sogou.com/web/sl?keyword=（z9/j）
//   360    = https://m.so.com/s?q=（z9/f，触屏版为 m.so.com，非桌面 www.so.com）
//   shenma = https://yz.m.sm.cn/s?q=（z9/i）
//   duckduckgo = https://duckduckgo.com/?q=（z9/d）
//   toutiao = https://so.toutiao.com/search?keyword=（z9/l）
//   metaso = https://metaso.cn/?q=（z9/g）
//   yahoo  = https://search.yahoo.com/search?p=（z9/m）
//   google = https://www.google.com/search?q=（z9/e）
//   yandex = https://yandex.com/search/touch/?text=（z9/n 触屏版）
//   startpage = https://startpage.com/do/search?query=（z9/k）
export const SEARCH_ENGINES: SearchEngineDef[] = [
  new SearchEngineDef('baidu', '百度', 'https://m.baidu.com/s?from=1022282z&word=%s', -2),
  new SearchEngineDef('google', '谷歌', 'https://www.google.com/search?q=%s', -1),
  new SearchEngineDef('bing', '必应', 'https://www.bing.com/search?q=%s', -3),
  new SearchEngineDef('metaso', '秘塔 AI', 'https://metaso.cn/?q=%s', -12),
  new SearchEngineDef('sogou', '搜狗', 'https://wap.sogou.com/web/sl?keyword=%s', -6),
  new SearchEngineDef('toutiao', '头条', 'https://so.toutiao.com/search?keyword=%s', -11),
  new SearchEngineDef('shenma', '神马', 'https://yz.m.sm.cn/s?q=%s', -4),
  new SearchEngineDef('so360', '360 搜索', 'https://m.so.com/s?q=%s', -5),
  new SearchEngineDef('duckduckgo', 'DuckDuckGo', 'https://duckduckgo.com/?q=%s', -10),
  new SearchEngineDef('yahoo', 'Yahoo', 'https://search.yahoo.com/search?p=%s', -8),
  new SearchEngineDef('startpage', 'StartPage', 'https://startpage.com/do/search?query=%s', -9),
  new SearchEngineDef('yandex', 'Yandex', 'https://yandex.com/search/touch/?text=%s', -7)
]

// 原版 z8/v2.b：按 locale 返回引擎列表（中英文环境顺序不同）
export function getBuiltinEngines(isZh: boolean, isRu: boolean): SearchEngineDef[] {
  const byKey = (key: string): SearchEngineDef => {
    const found = SEARCH_ENGINES.find((engine: SearchEngineDef): boolean => engine.key === key)
    return found !== undefined ? found : SEARCH_ENGINES[0]
  }
  const list: SearchEngineDef[] = []
  if (isZh) {
    list.push(byKey('baidu'))
  }
  list.push(byKey('google'))
  if (isRu) {
    list.push(byKey('yandex'))
  }
  if (!isZh) {
    list.push(byKey('baidu'))
  }
  list.push(byKey('bing'))
  if (isZh) {
    list.push(byKey('metaso'))
    list.push(byKey('sogou'))
    list.push(byKey('toutiao'))
    list.push(byKey('shenma'))
    list.push(byKey('so360'))
  } else {
    list.push(byKey('yahoo'))
    list.push(byKey('startpage'))
  }
  list.push(byKey('duckduckgo'))
  return list
}

// 原版 z8/v2.a()：默认搜索引擎 = CN 环境百度(-2)，否则谷歌(-1)
export function defaultEngineKey(isZh: boolean): string {
  return isZh ? 'baidu' : 'google'
}

// 原版 ma/e.b(int)：按建议源 id 返回接口（1=ma/c Google、2=ma/a 百度、3=ma/b 必应、4=ma/d 360）
export class SuggestSource {
  engineKey: string
  url: string
  // 百度接口返回 GB2312 编码的 JSONP：suggestion({"q":"","p":false,"s":["..."]})
  gb2312: boolean

  constructor(engineKey: string, url: string, gb2312: boolean = false) {
    this.engineKey = engineKey
    this.url = url
    this.gb2312 = gb2312
  }
}

export const SUGGEST_SOURCES: SuggestSource[] = [
  new SuggestSource('google', 'https://clients1.google.com/complete/search?hl={lang}&output=toolbar&q='),
  new SuggestSource('baidu', 'https://suggestion.baidu.com/su?wd={q}&cb=suggestion', true),
  new SuggestSource('bing', 'https://api.bing.com/qsonhs.aspx?type=cb&cb=s&q={q}'),
  new SuggestSource('so360', 'https://sug.so.360.cn/suggest?encodein=utf-8&encodeout=utf-8&format=json&word={q}')
]

// 原版 z8/v2.f(int, int)：引擎 → 建议源映射
// -1 谷歌→1(Google)、-2 百度→2(百度)、-3 必应→3(必应)、-5 360→4(360)，其余返回持久化的建议源设置
export function findSuggestSource(engineKey: string): SuggestSource | null {
  for (const source of SUGGEST_SOURCES) {
    if (source.engineKey === engineKey) {
      return source
    }
  }
  return null
}

// 原版 i6/u.b + z8/v0.j：URLEncoder.encode(UTF-8) 后把 '+' 换成 '%20'
// Java URLEncoder 与 encodeURIComponent 差异：'!'"'"'('')' 需补编码，'~' 需补为 %7E，'*' 两者均不编码
export function encodeQueryValue(text: string): string {
  let encoded = encodeURIComponent(text)
  encoded = encoded.replace(/!/g, '%21')
    .replace(/'/g, '%27')
    .replace(/\(/g, '%28')
    .replace(/\)/g, '%29')
    .replace(/~/g, '%7E')
  return encoded
}

// 原版 ma/c.b：Google 建议 hl 参数
// zh 且 TW/HK → zh-hant；zh → zh；其他语言 → 语言码
export function googleSuggestHl(language: string, region: string): string {
  if (language === 'zh') {
    return region === 'TW' || region === 'HK' ? 'zh-hant' : 'zh'
  }
  return language
}

export function buildSuggestUrl(engineKey: string, query: string, language: string, region: string): string | null {
  const source = findSuggestSource(engineKey)
  if (source === null) {
    return null
  }
  return source.url.replace('{lang}', googleSuggestHl(language, region))
    .replace('{q}', encodeQueryValue(query))
}

export function findEngine(key: string): SearchEngineDef {
  const found = SEARCH_ENGINES.find((engine: SearchEngineDef): boolean => engine.key === key)
  if (found !== undefined) {
    return found
  }
  return SEARCH_ENGINES[0]
}

// 原版 i6/g0.h：模板套词。%@→%s→%S 依次查找；trim(query) 后编码；
// 模板空或 query 空返回原 query；模板恰为 marker（len==2）返回未编码的原 query；
// 无 marker 时编码后的 query 追加到模板末尾
export function applyTemplate(template: string, query: string): string {
  if (template === '' || query === '') {
    return query
  }
  const encoded = encodeQueryValue(query.trim())
  let marker = template.indexOf('%@')
  if (marker < 0) {
    marker = template.indexOf('%s')
  }
  if (marker < 0) {
    marker = template.indexOf('%S')
  }
  if (marker === 0 && template.length === 2) {
    return query
  }
  if (marker >= 0) {
    return template.substring(0, marker) + encoded + template.substring(marker + 2)
  }
  return template + encoded
}

export function buildSearchUrl(engineKey: string, customTemplate: string, query: string): string {
  // engineKey 'custom' / 'custom:<id>' 时使用调用方传入的当前自定义引擎模板
  if (engineKey.startsWith('custom') && customTemplate !== '') {
    return applyTemplate(customTemplate, query)
  }
  const engine = findEngine(engineKey)
  return applyTemplate(engine.template, query)
}

// 原版特殊 scheme（i6/i0.java）：about:/data:/file://javascript:/view-source: 均按 URL 处理
const SPECIAL_SCHEMES: string[] = ['about:', 'data:', 'file://', 'javascript:', 'view-source:']

function isIpAddress(host: string): boolean {
  // 原版 i0.o()：IPv4 四段数字 或 IPv6 含 ':'
  if (/^(\d{1,3}\.){3}\d{1,3}$/.test(host)) {
    return true
  }
  return host.indexOf(':') >= 0 && /^[0-9a-fA-F:.]+$/.test(host)
}

// 原版 h0/a.a(host)：全角句点归一为 '.'（。＝U+3002、．＝U+FF0E、｡＝U+FF61）
export function normalizeHostDots(text: string): string {
  let result = ''
  for (let i = 0; i < text.length; i++) {
    const ch = text.charAt(i)
    if (ch === '\u3002' || ch === '\uFF0E' || ch === '\uFF61') {
      result += '.'
    } else {
      result += ch
    }
  }
  return result
}

export function isUrlLike(input: string): boolean {
  const text = normalizeHostDots(input.trim())
  if (text === '') {
    return false
  }
  if (text.indexOf(' ') >= 0) {
    return false
  }
  if (text.startsWith('http://') || text.startsWith('https://')) {
    return true
  }
  for (const scheme of SPECIAL_SCHEMES) {
    if (text.startsWith(scheme)) {
      return true
    }
  }
  const dotIndex = text.indexOf('.')
  if (dotIndex <= 0 || dotIndex === text.length - 1) {
    return false
  }
  if (!/^[\w.-]+(\:[0-9]+)?([\/?#].*)?$/.test(text)) {
    return false
  }
  const slashIndex = text.search(/[\/?#]/)
  const host = slashIndex >= 0 ? text.substring(0, slashIndex) : text
  if (isIpAddress(host)) {
    return true
  }
  return true
}

// RFC 3492 Punycode 编码（仅 encode，用于 i6/v.e 的 IDN 域名标签）
const PUNYCODE_BASE: number = 36
const PUNYCODE_TMIN: number = 1
const PUNYCODE_TMAX: number = 26
const PUNYCODE_SKEW: number = 38
const PUNYCODE_DAMP: number = 700
const PUNYCODE_INITIAL_BIAS: number = 72
const PUNYCODE_INITIAL_N: number = 128

function punycodeAdapt(delta: number, numPoints: number, firstTime: boolean): number {
  delta = firstTime ? Math.floor(delta / PUNYCODE_DAMP) : delta >> 1
  delta += Math.floor(delta / numPoints)
  let k = 0
  while (delta > ((PUNYCODE_BASE - PUNYCODE_TMIN) * PUNYCODE_TMAX) >> 1) {
    delta = Math.floor(delta / (PUNYCODE_BASE - PUNYCODE_TMIN))
    k += PUNYCODE_BASE
  }
  return k + Math.floor((PUNYCODE_BASE - PUNYCODE_TMIN + 1) * delta / (delta + PUNYCODE_SKEW))
}

function punycodeDigitToChar(digit: number): string {
  // 0..25 → a..z，26..35 → 0..9
  return String.fromCharCode(digit < 26 ? 97 + digit : 22 + digit)
}

function punycodeEncodeLabel(label: string): string {
  const output: string[] = []
  const lowered = label.toLowerCase()
  const codePoints: number[] = []
  for (let i = 0; i < lowered.length; i++) {
    codePoints.push(lowered.charCodeAt(i))
  }
  let n = PUNYCODE_INITIAL_N
  let delta = 0
  let bias = PUNYCODE_INITIAL_BIAS
  let h = 0
  let b = 0
  const basicCount = codePoints.length
  for (let i = 0; i < codePoints.length; i++) {
    if (codePoints[i] < 0x80) {
      output.push(String.fromCharCode(codePoints[i]))
      b++
      h++
    }
  }
  if (b === basicCount) {
    return output.join('')
  }
  if (b > 0) {
    output.push('-')
  }
  while (h < basicCount) {
    let m = 0x10FFFF
    for (let i = 0; i < codePoints.length; i++) {
      if (codePoints[i] >= n && codePoints[i] < m) {
        m = codePoints[i]
      }
    }
    delta += (m - n) * (h + 1)
    n = m
    for (let i = 0; i < codePoints.length; i++) {
      const c = codePoints[i]
      if (c < n) {
        delta++
      }
      if (c === n) {
        let q = delta
        let k = PUNYCODE_BASE
        while (true) {
          const t = k <= bias ? PUNYCODE_TMIN : (k >= bias + PUNYCODE_TMAX ? PUNYCODE_TMAX : k - bias)
          if (q < t) {
            break
          }
          const digit = t + (q - t) % (PUNYCODE_BASE - t)
          output.push(punycodeDigitToChar(digit))
          q = Math.floor((q - t) / (PUNYCODE_BASE - t))
          k += PUNYCODE_BASE
        }
        output.push(punycodeDigitToChar(q))
        bias = punycodeAdapt(delta, h + 1, h === b)
        delta = 0
        h++
      }
    }
    delta++
    n++
  }
  return 'xn--' + output.join('')
}

// 原版 i6/v.e(url)：http/https URL 的 host 逐 label 做 Punycode（"xn--" 前缀）
export function punycodeUrl(input: string): string {
  const schemeMatch = /^(https?:\/\/)([^\/?#]*)([\/?#].*)?$/.exec(input)
  if (schemeMatch === null) {
    return input
  }
  const scheme = schemeMatch[1]
  let authority = schemeMatch[2]
  const rest = schemeMatch[3] !== undefined ? schemeMatch[3] : ''
  const atIndex = authority.lastIndexOf('@')
  const userInfo = atIndex >= 0 ? authority.substring(0, atIndex + 1) : ''
  let hostPort = atIndex >= 0 ? authority.substring(atIndex + 1) : authority
  const colonIndex = hostPort.indexOf(':')
  let host = colonIndex >= 0 ? hostPort.substring(0, colonIndex) : hostPort
  const port = colonIndex >= 0 ? hostPort.substring(colonIndex) : ''
  let hasNonAscii = false
  for (let i = 0; i < host.length; i++) {
    if (host.charCodeAt(i) > 0x7F) {
      hasNonAscii = true
      break
    }
  }
  if (hasNonAscii) {
    const labels = host.split('.')
    const encoded: string[] = []
    for (const label of labels) {
      encoded.push(punycodeEncodeLabel(label))
    }
    host = encoded.join('.')
  }
  authority = userInfo + host + port
  return scheme + authority + rest
}

// 原版 i0.v()：无 scheme 的合法地址一律补 http://（i0.java:600，q() 恒 true 无 TLD 白名单）
export function normalizeUrl(input: string): string {
  let text = normalizeHostDots(input.trim())
  if (text.startsWith('http://') || text.startsWith('https://')) {
    return punycodeUrl(text)
  }
  for (const scheme of SPECIAL_SCHEMES) {
    if (text.startsWith(scheme)) {
      return text
    }
  }
  return punycodeUrl('http://' + text)
}

export function hostOf(url: string): string {
  let rest = url
  const schemeIndex = rest.indexOf('://')
  if (schemeIndex >= 0) {
    rest = rest.substring(schemeIndex + 3)
  }
  const slashIndex = rest.indexOf('/')
  if (slashIndex >= 0) {
    rest = rest.substring(0, slashIndex)
  }
  const atIndex = rest.lastIndexOf('@')
  if (atIndex >= 0) {
    rest = rest.substring(atIndex + 1)
  }
  const colonIndex = rest.indexOf(':')
  if (colonIndex >= 0) {
    rest = rest.substring(0, colonIndex)
  }
  return rest.toLowerCase()
}

// 原版 i6/u.a：URLDecoder.decode(UTF-8)；解码失败或结果含 U+FFFD 时回退原文
export function urlDecode(text: string): string {
  if (text !== '') {
    try {
      const decoded = decodeURIComponent(text)
      if (decoded.indexOf('\uFFFD') < 0) {
        return decoded
      }
    } catch (error) {
      return text
    }
  }
  return text
}

// 原版 v7.m.z（Kotlin lastIndexOf(string, startIndex)）：从 from 位置向前搜索，
// 返回起始位置 ≤ from 的最后一次出现；无则 -1
function lastIndexOfFrom(text: string, target: string, from: number): number {
  let pos = Math.min(from, text.length - target.length)
  while (pos >= 0) {
    if (text.startsWith(target, pos)) {
      return pos
    }
    pos--
  }
  return -1
}

// 原版 v7.m.y（Kotlin lastIndexOf(char, startIndex)）：从 from 位置向前搜索字符
function lastIndexOfCharFrom(text: string, ch: string, from: number): number {
  let pos = Math.min(from, text.length - 1)
  while (pos >= 0) {
    if (text.charAt(pos) === ch) {
      return pos
    }
    pos--
  }
  return -1
}

// 原版 i6/i0.h(url, key, from, false)：从 from 起找 key（要求前一字符为 '?' 或 '&'），
// 返回 key 之后到下一个 '&'/'#'/末尾的原始参数值；找不到返回 null
export function rawParamValue(url: string, key: string, from: number): string | null {
  if (url === '' || key === '' || key.length + from >= url.length) {
    return null
  }
  let searchFrom = from
  let valueStart = -1
  while (true) {
    const idx = url.indexOf(key, searchFrom)
    if (idx < 0) {
      return null
    }
    if (idx > 0 && (url.charAt(idx - 1) === '&' || url.charAt(idx - 1) === '?')) {
      valueStart = idx + key.length
      break
    }
    searchFrom = idx + key.length
    if (searchFrom < 0) {
      return null
    }
  }
  let amp = url.indexOf('&', valueStart)
  const hash = url.indexOf('#', valueStart)
  if (hash > 0 && (hash < amp || amp < 0)) {
    amp = hash
  }
  if (amp < 0) {
    amp = url.length
  }
  return url.substring(valueStart, amp)
}

// 原版 i6/g0.g(url, template)：当前 URL 是否命中搜索引擎模板，命中则返回搜索词（已解码），否则 null。
// 移植要点：
// - 模板含 '/'(≥8) 时要求 URL 同位也有 '/'；同位时校验前缀，前缀不符走 4 个域族回退
//   （.baidu.com/.bing.com//www.google.com/.sogou.com），百度系且模板为 /s? 型时交叉校验 URL 也须含 /s?
// - marker 查找顺序 %s→%S→%@；marker==0 且模板长 2 → 返回整个 URL
// - 模板无 '/' 时校验 url.startsWith(模板[0, marker 或 '?' 位])
// - query 之前型（模板无 '?' 或 marker 在 '?' 前）：前缀校验 + 后缀定位 / 截到 '?'/'#'/末尾
// - 参数型：取 marker 前最近的 '&'/'?' 之后的参数名，i0.h 提取 URL 中对应原始值；
//   提取失败且模板为百度域时回退 'wd='；marker 在模板末尾（含倒数第 2 位）直接解码返回；
//   否则取模板中该参数的值模式（含 %s 后缀），按后缀在 URL 值中定位截取
export function matchSearchWord(url: string, template: string): string | null {
  if (url === '' || template === '') {
    return null
  }
  const tplSlash = template.indexOf('/', 8)
  if (tplSlash > 0) {
    const urlSlash = url.indexOf('/', 8)
    if (urlSlash < 0) {
      return null
    }
    if (urlSlash === tplSlash) {
      if (!url.startsWith(template.substring(0, tplSlash - 1))) {
        const families: string[] = ['.baidu.com', '.bing.com', '/www.google.com', '.sogou.com']
        let familyOk = false
        for (let fi = 0; fi < families.length; fi++) {
          if (lastIndexOfFrom(template, families[fi], tplSlash) > 0 &&
            lastIndexOfFrom(url, families[fi], urlSlash) > 0) {
            familyOk = true
            break
          }
        }
        if (!familyOk) {
          return null
        }
      }
      if (lastIndexOfFrom(url, '.baidu.com', urlSlash) > 0 && template.indexOf('/s?', tplSlash) > 0) {
        if (url.indexOf('/s?', urlSlash) < 0) {
          return null
        }
      }
    }
  }
  let marker = template.indexOf('%s')
  if (marker < 0) {
    marker = template.indexOf('%S')
  }
  if (marker < 0) {
    marker = template.indexOf('%@')
  }
  if (marker < 0) {
    marker = template.length
  }
  if (marker === 0 && template.length === 2) {
    return url
  }
  const qIndex = template.indexOf('?')
  if (tplSlash < 0) {
    const end = (qIndex <= 0 || marker <= qIndex) ? marker : qIndex
    if (!url.startsWith(template.substring(0, end))) {
      return null
    }
  }
  if (qIndex < 0 || marker < qIndex) {
    if (!url.startsWith(template.substring(0, marker))) {
      return null
    }
    if (marker !== template.length && marker !== template.length - 2) {
      const suffix = template.substring(marker + 2)
      const suffixAt = url.indexOf(suffix, marker)
      if (suffixAt < 0) {
        return null
      }
      return urlDecode(url.substring(marker, suffixAt))
    }
    let cut = url.indexOf('?', marker)
    if (cut < 0) {
      cut = url.indexOf('#', marker)
    }
    if (cut < 0) {
      cut = url.length
    }
    return urlDecode(url.substring(marker, cut))
  }
  const amp = lastIndexOfCharFrom(template, '&', marker)
  let valueStart = qIndex
  if (amp >= 0 && amp > valueStart) {
    valueStart = amp
  }
  const paramStart = valueStart + 1
  if (paramStart >= marker) {
    return null
  }
  const paramKey = template.substring(paramStart, marker)
  let value = rawParamValue(url, paramKey, 0)
  if (value === null) {
    if (lastIndexOfFrom(template, '.baidu.com', tplSlash) > 0) {
      value = rawParamValue(url, 'wd=', 0)
    }
  }
  if (value === null) {
    return null
  }
  if (marker === template.length || marker === template.length - 2) {
    return urlDecode(value)
  }
  const pattern = rawParamValue(template, paramKey, valueStart)
  if (pattern === null || value.length < pattern.length - 2) {
    return null
  }
  if (pattern.length === 2) {
    return urlDecode(value)
  }
  let pm = pattern.indexOf('%s')
  if (pm < 0) {
    pm = pattern.indexOf('%S')
  }
  if (pm < 0) {
    pm = pattern.indexOf('%@')
  }
  let end2 = -1
  if (pm >= 0) {
    end2 = value.indexOf(pattern.substring(pm + 2))
  }
  if (end2 < 0) {
    return null
  }
  return urlDecode(value.substring(pm, end2))
}
