import { AppSettings } from './Settings'
import { hostOf } from './SearchEngines'

// ===== 原版 Uia 7.4.0 广告拦截引擎完整端口 =====
// w4/d.java 网络规则（类型位掩码/第三方/域名数组/异常位）→ Filter
// v4/c.java 匹配引擎（hostSet + 5 字符子串 Map + 域名域 Map）→ FilterEngine
// w4/a.java + v4/b.java 元素隐藏规则与存储 → CosmeticFilter / CosmeticStore
// b5/c.java 工具（m host、p 折叠、s 第三方、u/w 通配、a/g/h 子串扫描）
// x4/a.java 组合装载（custom + 内建 + 订阅）→ AdBlocker

// ---- b5/c.java 工具 ----

// b5/c.m：取 URL host（去 scheme、路径、端口）
function hostOfUrl(url: string): string {
  if (url === '') {
    return ''
  }
  let str = url
  const schemeIndex = str.indexOf('://')
  if (schemeIndex >= 0) {
    str = str.substring(schemeIndex + 3)
  }
  const slashIndex = str.indexOf('/')
  if (slashIndex > 0) {
    str = str.substring(0, slashIndex)
  }
  const colonIndex = str.lastIndexOf(':')
  return colonIndex > 0 ? str.substring(0, colonIndex) : str
}

// b5/c.p：域名折叠到主域（处理 com/net/org/gov/co 双级后缀）
function foldHost(host: string): string {
  if (host === '') {
    return host
  }
  const lastDot = host.lastIndexOf('.')
  if (lastDot < 0) {
    return host
  }
  const secondDot = host.lastIndexOf('.', lastDot - 1)
  if (secondDot < 0) {
    return host
  }
  let cut = secondDot
  if ('|com|net|org|gov|co|'.includes(`|${host.substring(secondDot + 1, lastDot)}|`)) {
    cut = host.lastIndexOf('.', secondDot - 1)
  }
  return host.substring(cut + 1)
}

// b5/c.s：第三方判定（host 与 pageHost 不同域）
function isThirdParty(host: string, pageHost: string): boolean {
  if (host === '' || pageHost === '' || host === pageHost || host.includes(foldHost(pageHost))) {
    return false
  }
  return true
}

// b5/c.a：URL 主体是否含 ≥5 连续普通字符（复杂规则判定用）
function hasFivePlainChars(url: string): boolean {
  if (url.length < 5) {
    return false
  }
  const schemeIndex = url.indexOf('://')
  let start = schemeIndex < 0 ? 0 : schemeIndex + 3
  const dollarIndex = url.indexOf('$', start)
  const end = dollarIndex < 0 ? url.length : dollarIndex
  let run = 0
  while (start < end) {
    const c = url.charAt(start)
    if (c === '@' || c === '|' || c === '*' || c === '^') {
      run = 0
    } else {
      run++
      if (run >= 5) {
        return true
      }
    }
    start++
  }
  return false
}

// b5/c.g：从 URL 中找第一个不在集合里的 5 字符子串（规则索引键）
function firstFreeSubstring(url: string, taken: Set<string>): string | null {
  if (url.length < 5) {
    return null
  }
  const schemeIndex = url.indexOf('://')
  let start = schemeIndex < 0 ? 0 : schemeIndex + 3
  const dollarIndex = url.indexOf('$', start)
  const end = dollarIndex < 0 ? url.length : dollarIndex
  const limit = end - 5
  while (start <= limit) {
    let broken = false
    for (let i = 0; i < 5; i++) {
      const c = url.charAt(start + i)
      if (c === '@' || c === '|' || c === '*' || c === '^') {
        start += i + 1
        broken = true
        break
      }
    }
    if (broken) {
      continue
    }
    const sub = url.substring(start, start + 5)
    if (!taken.has(sub)) {
      return sub
    }
    start++
  }
  return null
}

// b5/c.h：URL 主体全部 5 字符子串（域名域规则索引键）
function allSubstrings(url: string): string[] | null {
  if (url.length < 5) {
    return null
  }
  const schemeIndex = url.indexOf('://')
  let start = schemeIndex < 0 ? 0 : schemeIndex + 3
  const dollarIndex = url.indexOf('$')
  const end = dollarIndex === -1 ? url.length : dollarIndex
  if (end - start < 5) {
    return null
  }
  const result: string[] = []
  const limit = end - 5
  while (start <= limit) {
    let broken = false
    for (let i = 0; i < 5; i++) {
      const c = url.charAt(start + i)
      if (c === '@' || c === '|' || c === '*' || c === '^') {
        start += i + 1
        broken = true
        break
      }
    }
    if (broken) {
      continue
    }
    result.push(url.substring(start, start + 5))
    start++
  }
  return result.length === 0 ? null : result
}

// b5/c.f：按分隔符切分（跳过空段）
function splitSkipEmpty(text: string, sep: string): string[] {
  if (text.length === 0) {
    return []
  }
  const result: string[] = []
  let current = ''
  for (let i = 0; i < text.length; i++) {
    if (text.charAt(i) === sep) {
      if (current !== '') {
        result.push(current)
        current = ''
      }
    } else {
      current += text.charAt(i)
    }
  }
  if (current !== '') {
    result.push(current)
  }
  return result
}

// b5/c.r：^ 通配可匹配的非 URL 字符
function isSeparatorChar(c: string): boolean {
  return c === '/' || c === '.'
}

// b5/c.r（同名重载语义）：^ 可匹配字符判定
function isWildcardStopChar(c: string): boolean {
  if (c >= '0' && c <= '9') {
    return false
  }
  if (c >= 'A' && c <= 'Z') {
    return false
  }
  if ((c >= 'a' && c <= 'z') || c === '_' || c === '-' || c === '.' || c === '%') {
    return false
  }
  return true
}

// b5/c.w：规则首尾补 *
function padWithStars(pattern: string): string {
  let str = pattern
  if (str.charAt(0) !== '*') {
    str = `*${str}`
  }
  if (str.charAt(str.length - 1) !== '*') {
    str = `${str}*`
  }
  return str
}

// b5/c.u：ABP 通配匹配（^ 分隔符、| 斜杠点、* 任意）
function abpWildcardMatch(pattern: string, url: string): boolean {
  let p = 0
  let u = 0
  let starP = -1
  let starU = -1
  while (u < url.length) {
    if (p < pattern.length && ((pattern.charAt(p) === '^' && isWildcardStopChar(url.charAt(u)))
      || (pattern.charAt(p) === '|' && isSeparatorChar(url.charAt(u)))
      || pattern.charAt(p) === url.charAt(u))) {
      u++
      p++
    } else if (p < pattern.length && pattern.charAt(p) === '*') {
      starP = p
      p++
      starU = u
    } else {
      if (starP === -1) {
        return false
      }
      p = starP + 1
      starU++
      u = starU
    }
  }
  while (p < pattern.length && pattern.charAt(p) === '*') {
    p++
  }
  return p === pattern.length
}

// ---- w4/d.java 网络规则 ----

// 类型位（w4/d.i 位映射）
const TYPE_SCRIPT = 32
const TYPE_OTHER = 16
const TYPE_IMAGE = 64
const TYPE_STYLESHEET = 128
const TYPE_SUBDOCUMENT = 256
export const TYPE_DOCUMENT = 512
const TYPE_MEDIA = 1024
const TYPE_FONT = 2048
const TYPE_POPUP = 4096
const TYPE_WEBSOCKET = 8192
const TYPE_XHR = 16384
const TYPE_DTD = 16
export const TYPE_ALL_MASK = 32752

export class NetFilter {
  content: string | null = null
  domains: string[] | null = null
  flags: number = 0

  // w4/d.i：解析一行网络规则；不合法返回 null
  static parse(line: string): NetFilter | null {
    const text = line.trim()
    if (text.length < 5 || text.charAt(0) === '!' || text.indexOf('\\') >= 0) {
      return null
    }
    const filter = new NetFilter()
    const spaceIndex = text.indexOf(' ')
    if (spaceIndex > 0) {
      // 127.0.0.1 hosts 形式 → |host^
      if (!text.startsWith('127.0.0.1')) {
        return null
      }
      filter.content = `|${text.substring(spaceIndex + 1).trim()}^`
      return filter
    }
    let start = 0
    let extra = 0
    if (text.charAt(0) === '@' && text.charAt(1) === '@') {
      start = 2
      extra = 1
    }
    const dollarIndex = text.indexOf('$', start)
    let end = dollarIndex < 0 ? text.length : dollarIndex
    if (end - start > 1) {
      if (text.charAt(start) === '|') {
        start = (text.charAt(start + 1) === '|' && text.charAt(start + 2) === '*') ? start + 3 : start + 1
      } else if (text.charAt(start) === '*') {
        start++
      }
      if (text.charAt(end - 1) === '*') {
        end--
      }
    }
    filter.content = start === end ? '' : text.substring(start, end)
    if (dollarIndex >= 0) {
      let i = dollarIndex + 1
      let hasUnknown = false
      let typeBits = 0
      while (i < text.length) {
        let commaIndex = text.indexOf(',', i)
        if (commaIndex < 0) {
          commaIndex = text.length
        }
        const negated = text.charAt(i) === '~'
        if (negated) {
          i++
        }
        const option = text.substring(i, commaIndex)
        let bit = 0
        let known = true
        switch (option) {
          case 'background':
          case 'image':
            bit = TYPE_IMAGE
            break
          case 'xmlhttprequest':
            bit = TYPE_XHR
            break
          case 'object':
          case 'webrtc':
          case 'genericblock':
          case 'elemhide':
          case 'csp':
          case 'ping':
          case 'object-subrequest':
          case 'generichide':
            // 原版不支持：置 z10（未知）不计类型位
            known = false
            hasUnknown = true
            break
          case 'third-party':
            extra |= negated ? 4 : 2
            break
          case 'script':
            bit = TYPE_SCRIPT
            break
          case 'websocket':
            bit = TYPE_WEBSOCKET
            break
          case 'dtd':
          case 'xbl':
            bit = TYPE_DTD
            break
          case 'font':
            bit = TYPE_FONT
            break
          case 'media':
            bit = TYPE_MEDIA
            break
          case 'popup':
            bit = TYPE_POPUP
            break
          case 'stylesheet':
            bit = TYPE_STYLESHEET
            break
          case 'document':
            bit = TYPE_DOCUMENT
            break
          case 'subdocument':
            bit = TYPE_SUBDOCUMENT
            break
          case 'other':
            bit = TYPE_OTHER
            break
          default:
            if (text.startsWith('domain=', i)) {
              filter.domains = splitSkipEmpty(text.substring(i + 7, commaIndex), '|')
            } else {
              if (text.indexOf('=', i) > 0) {
                // 带值未知选项（rewrite= 等）→ 丢弃整条
                return filter.content === '' ? null : filter
              }
              hasUnknown = true
            }
            known = false
            break
        }
        if (known && bit > 0) {
          if (negated) {
            if ((typeBits & TYPE_ALL_MASK) === 0) {
              typeBits = TYPE_ALL_MASK
            }
            typeBits &= ~bit
          } else {
            typeBits |= bit
          }
        }
        i = commaIndex + 1
      }
      if (hasUnknown && typeBits === 0) {
        // 未知选项且无类型位 → 丢弃（w4/d:387-389）
        return null
      }
      filter.flags = typeBits | extra
    } else {
      filter.flags = extra
    }
    return filter
  }

  // w4/d.e()：类型位
  typeBits(): number {
    return this.flags & TYPE_ALL_MASK
  }

  // w4/d.f()：第三方位（2=第三方 4=第一方）
  partyBits(): number {
    return this.flags & 6
  }

  // w4/d.g()：异常规则（@@）
  isException(): boolean {
    return (this.flags & 1) !== 0
  }

  // w4/d.h()：URL 匹配（含类型/第三方/域名限定）
  matches(url: string, pageHost: string, requestBits: number, thirdParty: boolean): boolean {
    if (this.typeBits() !== 0 && (requestBits & this.typeBits()) === 0) {
      return false
    }
    if (this.partyBits() !== 0) {
      if (((this.partyBits() & 2) === 0) === thirdParty) {
        return false
      }
    }
    if (this.domains !== null && this.domains.length > 0) {
      if (pageHost !== '') {
        let matched = false
        for (let i = 0; i < this.domains.length; i++) {
          const domain = this.domains[i]
          if (domain !== '') {
            if (domain.charAt(0) !== '~') {
              if (pageHost.includes(domain)) {
                matched = true
                break
              }
            } else {
              if (pageHost.includes(domain.substring(1))) {
                return false
              }
              matched = true
            }
          }
        }
        if (!matched) {
          return false
        }
      } else if (this.domains[0].charAt(0) !== '~') {
        return false
      }
    }
    const content = this.content
    if (content === null || content === '') {
      return true
    }
    for (let i = 0; i < content.length; i++) {
      const c = content.charAt(i)
      if (c === '*' || c === '^' || c === '|') {
        return abpWildcardMatch(padWithStars(content), url)
      }
    }
    return url.includes(content)
  }

  // w4/d.m()：还原规则文本（拦截页展示用）
  toRuleString(): string {
    let sb = ''
    if (this.isException()) {
      sb += '@@'
    }
    const content = this.content
    if (content !== null) {
      if (content.startsWith('|') || content.startsWith('http://') || content.startsWith('https://')) {
        sb += `|${content}`
      } else {
        sb += content
      }
    }
    const typeBits = this.typeBits()
    if ((this.flags & ~1) !== 0 || (this.domains !== null && this.domains.length > 0)) {
      sb += '$'
    }
    if (typeBits !== 0) {
      const bits: number[] = [TYPE_SCRIPT, TYPE_OTHER, TYPE_IMAGE, TYPE_STYLESHEET, TYPE_SUBDOCUMENT,
        TYPE_DOCUMENT, TYPE_MEDIA, TYPE_FONT, TYPE_POPUP, TYPE_WEBSOCKET, TYPE_XHR]
      const names: string[] = ['script', 'other', 'image', 'stylesheet', 'subdocument', 'document',
        'media', 'font', 'popup', 'websocket', 'xmlhttprequest']
      for (let i = 0; i < 11; i++) {
        if ((typeBits & bits[i]) === bits[i]) {
          sb += `${names[i]},`
        }
      }
    }
    if ((this.flags & 2) === 2) {
      sb += 'third-party,'
    }
    if ((this.flags & 4) === 4) {
      sb += '~third-party,'
    }
    if (this.domains !== null) {
      sb += 'domain='
      for (let i = 0; i < this.domains.length; i++) {
        if (i !== 0) {
          sb += '|'
        }
        sb += this.domains[i]
      }
    }
    return sb
  }

  equalsFilter(other: NetFilter): boolean {
    return this.flags === other.flags && this.content === other.content && this.domainsEquals(other)
  }

  private domainsEquals(other: NetFilter): boolean {
    const a = this.domains
    const b = other.domains
    if (a === null && b === null) {
      return true
    }
    if (a === null || b === null || a.length !== b.length) {
      return false
    }
    for (let i = 0; i < a.length; i++) {
      if (a[i] !== b[i]) {
        return false
      }
    }
    return true
  }
}

// ---- w4/a.java + v4/b.java 元素隐藏 ----

export class CosmeticFilter {
  content: string = ''
  domains: string[] | null = null
  flag: number = 0

  // w4/a.e()：选择器合法性校验
  static validateSelector(selector: string): string | null {
    if (selector === '') {
      return null
    }
    let quote = ''
    let brackets = 0
    let parens = 0
    let seen = false
    let i = 0
    while (i < selector.length) {
      const c = selector.charAt(i)
      if (c === '\\') {
        i += 2
        if (i > selector.length) {
          return null
        }
        seen = true
        continue
      }
      if (quote !== '') {
        if (c === quote) {
          quote = ''
        }
      } else if (c === '"' || c === '\'') {
        quote = c
      } else {
        if (c === '{' || c === '}' || c === ';' || c === '!' || c === '&' || c === '?') {
          return null
        }
        if (c === '[') {
          brackets++
        } else if (c === ']') {
          if (brackets === 0) {
            return null
          }
          brackets--
        } else if (c === '(') {
          parens++
        } else if (c === ')') {
          if (parens === 0) {
            return null
          }
          parens--
        } else {
          if (c === '=' && brackets === 0) {
            return null
          }
          if (c === ',' && brackets === 0 && parens === 0) {
            if (!seen) {
              return null
            }
            seen = false
          }
        }
        if (c !== ' ' && c !== '\t' && c !== '\n' && c !== '\r' && c !== '\f' && c !== '\v') {
          seen = true
        }
      }
      i++
    }
    if (quote === '' && brackets === 0 && parens === 0 && seen) {
      return selector
    }
    return null
  }

  // w4/a.d()：解析一行元素隐藏规则
  static parse(line: string): CosmeticFilter | null {
    const text = line.trim()
    if (text === '') {
      return null
    }
    if (text.charAt(0) === '!' || text.includes('->m:') || text.includes('#?#')) {
      return null
    }
    let hashIndex = text.indexOf('##')
    const isExceptionHash = hashIndex < 0 && (hashIndex = text.indexOf('#@#')) >= 0
    if (hashIndex < 0) {
      return null
    }
    let domains: string[] | null = null
    if (hashIndex !== 0) {
      domains = splitSkipEmpty(text.substring(0, hashIndex), ',')
      if (isExceptionHash) {
        for (let i = 0; i < domains.length; i++) {
          if (domains[i].charAt(0) !== '~') {
            domains[i] = `~${domains[i]}`
          }
        }
      }
    } else {
      if (isExceptionHash) {
        return null
      }
      domains = null
    }
    const selStart = hashIndex + (isExceptionHash ? 3 : 2)
    if (selStart === text.length || text.charAt(selStart) === '^' || text.indexOf('js(', selStart) >= 0) {
      return null
    }
    let flag = 0
    const colonIndex = text.indexOf(':', selStart)
    if (colonIndex > 0) {
      const parenIndex = text.indexOf('(', colonIndex)
      if (parenIndex > colonIndex) {
        const pseudo = text.substring(colonIndex, parenIndex + 1)
        if (':has-text(...), :matches-attr(...), :matches-css(...), :matches-css-before(...), :matches-css-after(...), :matches-media(...), :matches-path(...), :min-text-length(n), :NOT(...), :others(...), :upward(...), :watch-attr(...), :xpath(...).:remove(), :style(arg), :remove-attr(arg), :remove-class(arg)'.includes(pseudo)) {
          return null
        }
        if (':has(...)'.includes(pseudo)) {
          flag = 1
        }
      }
    }
    const selector = CosmeticFilter.validateSelector(text.substring(selStart))
    if (selector === null) {
      return null
    }
    const result = new CosmeticFilter()
    result.content = selector
    result.domains = domains
    result.flag = flag
    return result
  }
}

// v4/b.java：domain → 选择器集合
class CosmeticStore {
  // key '' = 通用；'~domain' = 异常；domain = 域名限定
  private map: Map<string, string[]> = new Map()

  clear(): void {
    this.map.clear()
  }

  // v4/b.c()
  add(filter: CosmeticFilter): void {
    if (filter.domains === null || filter.domains.length === 0) {
      this.addInternal(filter.content, '')
      return
    }
    for (let i = 0; i < filter.domains.length; i++) {
      const domain = filter.domains[i]
      if (domain !== null && domain.length > 2) {
        this.addInternal(filter.content, domain)
      }
    }
  }

  // v4/b.d()
  remove(filter: CosmeticFilter): void {
    if (filter.domains === null || filter.domains.length === 0) {
      this.removeInternal(filter.content, '')
      return
    }
    for (let i = 0; i < filter.domains.length; i++) {
      const domain = filter.domains[i]
      if (domain === null || domain.length <= 2) {
        return
      }
      this.removeInternal(filter.content, domain)
    }
  }

  private addInternal(selector: string, key: string): void {
    if (selector === '') {
      return
    }
    let list = this.map.get(key)
    if (list === undefined) {
      list = []
      this.map.set(key, list)
    }
    if (list.indexOf(selector) < 0) {
      list.push(selector)
    }
  }

  private removeInternal(selector: string, key: string): void {
    const list = this.map.get(key)
    if (list === undefined) {
      return
    }
    const index = list.indexOf(selector)
    if (index >= 0) {
      list.splice(index, 1)
    }
    if (list.length === 0) {
      this.map.delete(key)
    }
  }

  private getOf(key: string): string[] | null {
    const list = this.map.get(key)
    if (list === undefined || list.length === 0) {
      return null
    }
    return list
  }

  // v4/b.e()：按 host 生成元素隐藏 CSS（每 100 条一组 {display:none!important}）
  cssForHost(host: string): string {
    const selectors = this.selectorsFor(host)
    if (selectors === null) {
      return ''
    }
    let css = ''
    for (let i = 0; i < selectors.length; i++) {
      css += selectors[i]
      if ((i + 1) % 100 === 0 || i + 1 === selectors.length) {
        css += '{display:none!important}\n'
      } else {
        css += ','
      }
    }
    return css
  }

  // v4/b.h()：域名限定 ∪ 通用 - 异常
  private selectorsFor(host: string): string[] | null {
    const hostSelectors = this.getOf(host)
    const folded = foldHost(host)
    const foldedSelectors = host !== folded ? this.getOf(folded) : null
    const generic = this.getOf('')
    if ((hostSelectors === null) && (foldedSelectors === null) && (generic === null)) {
      return null
    }
    const hostExceptions = this.getOf(`~${host}`)
    const foldedExceptions = host === folded ? null : this.getOf(`~${folded}`)
    const result: string[] = []
    const push = (list: string[] | null): void => {
      if (list === null) {
        return
      }
      for (let i = 0; i < list.length; i++) {
        if (result.indexOf(list[i]) < 0) {
          result.push(list[i])
        }
      }
    }
    const drop = (list: string[] | null): void => {
      if (list === null) {
        return
      }
      for (let i = 0; i < list.length; i++) {
        const index = result.indexOf(list[i])
        if (index >= 0) {
          result.splice(index, 1)
        }
      }
    }
    push(hostSelectors)
    push(foldedSelectors)
    push(generic)
    drop(hostExceptions)
    drop(foldedExceptions)
    return result.length === 0 ? null : result
  }
}

// ---- v4/c.java 匹配引擎 ----

class FilterEngine {
  // 5 字符子串 → 规则（例外/拦截）
  private allowSubstr: Map<string, NetFilter> = new Map()
  private blockSubstr: Map<string, NetFilter> = new Map()
  // 域名限定规则（domain= 单域名展开后）
  private domainAllow: Map<string, NetFilter> = new Map()
  private domainBlock: Map<string, NetFilter> = new Map()
  // ||host^ 简单域名规则
  private hostSet: Set<string> = new Set()
  // 批量装载暂存（v4/c.f13033f）
  private pending: Set<NetFilter> | null = null

  clear(): void {
    this.allowSubstr.clear()
    this.blockSubstr.clear()
    this.domainAllow.clear()
    this.domainBlock.clear()
    this.hostSet.clear()
    this.pending = null
  }

  // v4/c.a()：开始批量装载
  beginBatch(): void {
    if (this.pending !== null) {
      return
    }
    this.pending = new Set()
    for (const filter of this.allowSubstr.values()) {
      this.pending.add(filter)
    }
    this.allowSubstr.clear()
    for (const filter of this.blockSubstr.values()) {
      this.pending.add(filter)
    }
    this.blockSubstr.clear()
    for (const filter of this.domainAllow.values()) {
      this.pending.add(filter)
    }
    this.domainAllow.clear()
    for (const filter of this.domainBlock.values()) {
      this.pending.add(filter)
    }
    this.domainBlock.clear()
  }

  // v4/c.b()：结束批量装载
  endBatch(): void {
    if (this.pending === null) {
      return
    }
    for (const filter of this.pending) {
      this.addToIndex(filter)
    }
    this.pending = null
  }

  // v4/c.d()/e()
  add(filter: NetFilter): void {
    const host = this.simpleHostOf(filter)
    if (host !== null) {
      this.hostSet.add(host)
      return
    }
    if (this.pending !== null) {
      this.pending.add(filter)
      return
    }
    this.addToIndex(filter)
  }

  private addToIndex(filter: NetFilter): void {
    const subs = filter.content === null ? null : allSubstrings(filter.content)
    if (subs === null || subs.length === 0) {
      this.addToDomainIndex(filter)
      return
    }
    for (let i = 0; i < subs.length; i++) {
      const existing = (filter.isException() ? this.allowSubstr : this.blockSubstr).get(subs[i])
      if (existing !== undefined && existing.equalsFilter(filter)) {
        return
      }
    }
    for (let i = 0; i < subs.length; i++) {
      const target = filter.isException() ? this.allowSubstr : this.blockSubstr
      if (!target.has(subs[i])) {
        target.set(subs[i], filter)
        return
      }
    }
  }

  // v4/c.f()/h()：domain= 限定规则按域名建索引
  private addToDomainIndex(filter: NetFilter): void {
    if (filter.domains === null || filter.domains.length === 0 || hasFivePlainChars(filter.content ?? '')) {
      return
    }
    if (filter.domains.length !== 1) {
      for (let i = 0; i < filter.domains.length; i++) {
        const split = new NetFilter()
        split.content = filter.content
        split.domains = [filter.domains[i]]
        split.flags = filter.flags
        this.addToDomainIndex(split)
      }
      return
    }
    const subs = filter.content === null ? null : allSubstrings(filter.domains[0])
    if (subs === null || subs.length === 0) {
      return
    }
    for (let i = 0; i < subs.length; i++) {
      const target = filter.isException() ? this.domainAllow : this.domainBlock
      const existing = target.get(subs[i])
      if (existing !== undefined && existing.equalsFilter(filter)) {
        return
      }
    }
    for (let i = 0; i < subs.length; i++) {
      const target = filter.isException() ? this.domainAllow : this.domainBlock
      if (!target.has(subs[i])) {
        target.set(subs[i], filter)
        return
      }
    }
  }

  // v4/c.g()：||host^ 简单域名规则 → host；否则 null
  private simpleHostOf(filter: NetFilter): string | null {
    if (filter.flags !== 0 || filter.content === null || filter.content.length < 3) {
      return null
    }
    const content = filter.content
    const end = content.length - 1
    if (content.charAt(0) !== '|') {
      return null
    }
    if (content.charAt(end) !== '^' || content.charAt(1) === '.' || content.charAt(end - 1) === '.') {
      return null
    }
    let lastDot = -1
    for (let i = 1; i < end; i++) {
      const c = content.charAt(i)
      if (c === '.') {
        if (lastDot === i - 1) {
          return null
        }
        lastDot = i
      } else if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < '0' || c > '9') && c !== '-') {
        return null
      }
    }
    if (lastDot < 0) {
      return null
    }
    return content.substring(1, end)
  }

  // v4/c.c()：URL 匹配（返回命中的规则）
  match(url: string, requestBits: number, pageUrl: string): NetFilter | null {
    const host = hostOfUrl(url)
    let hostHit: NetFilter | null = null
    if (this.hostSet.has(host)) {
      hostHit = new NetFilter()
      hostHit.content = `|${host}^`
    }
    if (hostHit === null && host !== '') {
      const folded = foldHost(host)
      if (folded !== host && this.hostSet.has(folded)) {
        hostHit = new NetFilter()
        hostHit.content = `|${folded}^`
      }
    }
    if (this.allowSubstr.size === 0 && this.domainAllow.size === 0) {
      return hostHit
    }
    const pageHost = hostOfUrl(pageUrl)
    const thirdParty = isThirdParty(host, pageHost)
    // URL 5 字符窗口扫描（从 "://" 后开始，最多 32 次拦截候选）
    const schemeIndex = url.indexOf('://')
    let windowEnd = schemeIndex < 0 ? -1 : schemeIndex + 2
    const limit = url.length - 5
    let blockTries = 0
    while (true) {
      const start = windowEnd + 1
      if (start > limit || blockTries >= 32) {
        break
      }
      const sub = url.substring(start, windowEnd + 6)
      const exception = this.allowSubstr.get(sub)
      if (exception !== undefined && exception.matches(url, pageHost, requestBits, thirdParty)) {
        return exception
      }
      if (hostHit === null) {
        const block = this.blockSubstr.get(sub)
        if (block !== undefined) {
          hostHit = block
          blockTries++
          if (!block.matches(url, pageHost, requestBits, thirdParty)) {
            hostHit = null
          } else if (this.allowSubstr.size === 0) {
            break
          }
        }
      }
      windowEnd = start
    }
    // 域名域规则：page host 的 5 字符窗口扫描（v4/c 截断部分）
    let result: NetFilter | null = hostHit
    if (pageHost !== '') {
      let i = -1
      const pageLimit = pageHost.length - 5
      while (i < pageLimit) {
        let broken = false
        const sub = pageHost.substring(i + 1, i + 6)
        for (let j = 0; j < 5; j++) {
          const c = sub.charAt(j)
          if (c === '@' || c === '|' || c === '*' || c === '^') {
            broken = true
            break
          }
        }
        if (broken) {
          i++
          continue
        }
        const exception = this.domainAllow.get(sub)
        if (exception !== undefined && exception.matches(url, pageHost, requestBits, thirdParty)) {
          return exception
        }
        if (result === null) {
          const block = this.domainBlock.get(sub)
          if (block !== undefined && block.matches(url, pageHost, requestBits, thirdParty)) {
            result = block
          }
        }
        i++
      }
    }
    return result
  }
}

// ---- b5/c.v() 行分类 ----

type ParsedLine = NetFilter | CosmeticFilter | null

function parseRuleLine(line: string): ParsedLine {
  if (line === '' || line.charAt(0) === '!') {
    return null
  }
  if (line.includes('##') || line.includes('#@#')) {
    return CosmeticFilter.parse(line)
  }
  return NetFilter.parse(line)
}

// b5.c.v()：规则行可解析判定（规则编辑器 z7.v.q3 非法行校验用；空行/! 注释视为有效跳过）
export function isValidRuleLine(line: string): boolean {
  try {
    return parseRuleLine(line) !== null
  } catch (error) {
    return false
  }
}

// ---- 拦截页 HTML（u9/a.a + uz/v0/ef 文案）----

export function buildBlockedPageHtml(pageUrl: string, rule: string, blockedText: string, reasonText: string,
  continueText: string): string {
  const dark = AppSettings.getInstance().isNightActive()
  const bg = dark ? '#000' : '#fff'
  const codeBg = dark ? '#303030' : '#e0e0e6'
  const fg = dark ? '#fff' : '#000'
  const host = hostOfUrl(pageUrl)
  const jump = `v://blocker/jump?url=${encodeURIComponent(pageUrl)}`
  return `<html><head><meta name="color-scheme" content="light dark"><meta charset="utf-8">` +
    `<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=true, minimal-ui">` +
    `<title>${host}</title><style>body{background:${bg};color:${fg};text-align:center;margin:auto;` +
    `padding:40px;box-sizing:border-box}.icon{width:100px;height:100px;text-align:center;margin:auto;` +
    `fill:#dd4747}.btn{background-color:#5a5a5a;color:#fff;padding:8px 12px;border:none;border-radius:8px;` +
    `stroke:none;size:15px;text-decoration:none;margin-top:36px;max-width:120px;font-size:15px}` +
    `.text{font-size:15px;margin:16px 0 8px}.code{background-color:${codeBg};font-family:monospace;` +
    `font-size:13px;white-space:normal;word-break:break-all;padding:4px;margin:0 0 16px;line-height:1.5}` +
    `.op{margin-top:32px}</style></head><body><div class="icon"><svg viewBox="0 0 1794 1664">` +
    `<path d="m 1025.0139,1375 0,-190 q 0,-14 -9.5,-23.5 -9.5,-9.5 -22.5,-9.5 l -192,0 q -13,0 -22.5,9.5 ` +
    `-9.5,9.5 -9.5,23.5 l 0,190 q 0,14 9.5,23.5 9.5,9.5 22.5,9.5 l 192,0 q 13,0 22.5,-9.5 9.5,-9.5 ` +
    `9.5,-23.5 z m -2,-374 18,-459 q 0,-12 -10,-19 -13,-11 -24,-11 l -220,0 q -11,0 -24,11 -10,7 -10,21 ` +
    `l 17,457 q 0,10 10,16.5 10,6.5 24,6.5 l 185,0 q 14,0 23.5,-6.5 9.5,-6.5 10.5,-16.5 z m -14,-934 ` +
    `768,1408 q 35,63 -2,126 -17,29 -46.5,46 -29.5,17 -63.5,17 l -1536,0 q -34,0 -63.5,-17 -29.5,-17 ` +
    `-46.5,-46 -37,-63 -2,-126 L 785.01389,67 q 17,-31 47,-49 30,-18 65,-18 35,0 65,18 30,18 47,49 z">` +
    `</path></svg></div><p class="text">${blockedText}</p><p class="code">${pageUrl}</p>` +
    `<p class="text">${reasonText}</p><p class="code">${rule}</p>` +
    `<div class="op"><a class="btn" href="${jump}">${continueText}</a></div></body></html>`
}

// ---- x4/a.java 组合门面 ----

export class AdBlocker {
  private static instance: AdBlocker | null = null
  private settings: AppSettings | null = null
  private engine: FilterEngine = new FilterEngine()
  private cosmetic: CosmeticStore = new CosmeticStore()
  // 会话级放行 host（原版 na.f2716q，点「继续加载」后加入）
  private bypassHosts: Set<string> = new Set()
  // 规则来源缓存
  private builtinLines: string[] = []
  private subLines: string[] = []
  private loaded: boolean = false

  private constructor() {
  }

  static getInstance(): AdBlocker {
    if (AdBlocker.instance === null) {
      AdBlocker.instance = new AdBlocker()
    }
    return AdBlocker.instance
  }

  init(settings: AppSettings): void {
    this.settings = settings
  }

  // 内建规则（a5/a.java：rawfile simple.txt 逐行）
  setBuiltinRules(lines: string[]): void {
    this.builtinLines = lines
    this.rebuild()
  }

  // 订阅规则行（z4 装载）
  setSubscriptionRules(lines: string[]): void {
    this.subLines = lines
    this.rebuild()
  }

  // 自定义规则文本变化后重编（y4）
  rebuildCustomRules(): void {
    this.rebuild()
  }

  // x4/a.o()：全量重装载（custom + 内建 + 订阅）
  private rebuild(): void {
    this.engine.clear()
    this.cosmetic.clear()
    if (this.settings === null) {
      return
    }
    this.engine.beginBatch()
    const addLines = (lines: string[]): void => {
      for (let i = 0; i < lines.length; i++) {
        const parsed = parseRuleLine(lines[i])
        if (parsed instanceof NetFilter) {
          this.engine.add(parsed)
        } else if (parsed instanceof NetFilter === false && parsed !== null) {
          this.cosmetic.add(parsed as CosmeticFilter)
        }
      }
    }
    // 自定义规则（u4/a.java:41-46）
    const text = this.settings.customRulesText
    if (text !== '') {
      addLines(text.split('\n'))
    }
    // 旧版结构化规则兼容 → ||host^ / @@||host^
    for (let i = 0; i < this.settings.customRules.length; i++) {
      const domain = this.settings.customRules[i].domain.trim().toLowerCase()
      if (domain === '') {
        continue
      }
      addLines([this.settings.customRules[i].isAllow ? `@@||${domain}^` : `||${domain}^`])
    }
    // 内建 simple.txt（w9 开关启用时）
    if (this.settings.adBlockBuiltin) {
      addLines(this.builtinLines)
    }
    // 订阅
    addLines(this.subLines)
    this.engine.endBatch()
    this.loaded = true
  }

  // na.n0()：「继续加载」加入会话级放行
  addBypassHost(host: string): void {
    if (host !== '') {
      this.bypassHosts.add(host)
    }
  }

  hasBypassHost(host: string): boolean {
    return this.bypassHosts.has(host)
  }

  // 匹配入口：返回命中的拦截/例外规则（供占位与拦截页区分）
  matchFilter(url: string, requestBits: number, pageUrl: string): NetFilter | null {
    if (this.settings === null || !this.settings.adBlockOn || !this.loaded) {
      return null
    }
    const pageSetting = this.settings.getSiteSetting(hostOf(pageUrl))
    if (pageSetting !== null && pageSetting.allowAds) {
      return null
    }
    return this.engine.match(url, requestBits, pageUrl)
  }

  // U1：是否拦截（例外规则命中返回 null）
  shouldBlock(url: string, requestBits: number, pageUrl: string): NetFilter | null {
    const filter = this.matchFilter(url, requestBits, pageUrl)
    if (filter === null || filter.isException()) {
      return null
    }
    return filter
  }

  // x4/a.h()：元素隐藏 CSS（na.E0 的 uia_inject_blocker.css 等价）
  cssForPage(pageUrl: string): string {
    if (this.settings === null || !this.settings.adBlockOn) {
      return ''
    }
    const pageSetting = this.settings.getSiteSetting(hostOf(pageUrl))
    if (pageSetting !== null && pageSetting.allowAds) {
      return ''
    }
    return this.cosmetic.cssForHost(hostOf(pageUrl))
  }

  // na.E0()：元素隐藏 CSS 注入脚本
  cssInjectScript(pageUrl: string): string {
    const css = this.cssForPage(pageUrl)
    if (css === '') {
      return ''
    }
    const escaped = css.replace(/\\/g, '\\\\').replace(/`/g, '\\`').replace(/\$/g, '\\$')
    return `(function(){var s=document.getElementById('uia_inject_blocker');` +
      `if(!s){s=document.createElement('style');s.id='uia_inject_blocker';document.head.appendChild(s);}` +
      `s.textContent=\`${escaped}\`;})();`
  }
}
