import { BookmarkRec, BookmarkFolderRec } from './Types'

// 原版 bookmarks.html 引擎 1:1 移植（全部亲自核实）：
// - z8/p.java：q() 解析 / r()+k()+m()+n() 导出 / p() 合并重映射 / d() 旧版展平 / f/g/h/i/j 实体转义
// - z8/e1.java：HTML tokenizer（0=首调 1=EOF 2=开标签 3=闭标签 4=文本）
// - o9/a.java、o9/b.java：文件夹/书签模型（标题 setter 套 g6.p.l 空白规整）
// - o9/g.java x()：合并落库（文件夹按 _id 删+插、书签按 url 删+插）
// - g6/p.java l()：标题空白规整（NBSP→空格、\r 丢弃、其余空白→单空格）
// - l9/b.java a()：data-for-older-versions 展平行键序 title,url,folder,order,updated_at,created_at
// 时间制：原版秒、本工程毫秒——导出 floor/1000，解析结果为秒（落库时 *1000）

// Java String.replace（全局替换）
function replaceAllStr(s: string, from: string, to: string): string {
  return s.split(from).join(to)
}

// Character.isWhitespace 近似（e1/g 与 g6/p.l 依赖）
function isJavaWhitespace(code: number): boolean {
  if (code === 0x09 || code === 0x0A || code === 0x0B || code === 0x0C || code === 0x0D) {
    return true
  }
  if (code >= 0x1C && code <= 0x1F) {
    return true
  }
  if (code === 0x20 || code === 0x85) {
    return true
  }
  if (code === 0x1680) {
    return true
  }
  if (code >= 0x2000 && code <= 0x200A) {
    return true
  }
  if (code === 0x2028 || code === 0x2029 || code === 0x205F || code === 0x3000) {
    return true
  }
  return false
}

// e1.g：两端去 Java 空白
function trimJavaWhitespace(s: string): string {
  let start = 0
  let end = s.length
  while (start < end && isJavaWhitespace(s.charCodeAt(start))) {
    start++
  }
  while (end > start && isJavaWhitespace(s.charCodeAt(end - 1))) {
    end--
  }
  return s.substring(start, end)
}

// g6/p.l：标题空白规整（非空白复制且 NBSP→空格；空白中 \r 丢弃、其余→单空格）
export function normalizeTitle(str: string): string {
  if (str === null || str.length === 0) {
    return str
  }
  let out = ''
  for (let i = 0; i < str.length; i++) {
    const code = str.charCodeAt(i)
    if (!isJavaWhitespace(code)) {
      if (code === 0xA0) {
        out += ' '
      } else {
        out += String.fromCharCode(code)
      }
    } else if (code !== 0x0D) {
      out += ' '
    }
  }
  return out
}

// z8/p.f：数字字符引用 &#\d+; → char 截 16 位
export function decodeNumericRefs(str: string): string {
  if (str === null || str.length === 0 || str.indexOf('&#') < 0) {
    return str
  }
  return str.replace(/&#(\d+);/g, (all: string, num: string) => {
    return String.fromCharCode(parseInt(num, 10) & 0xFFFF)
  })
}

// z8/p.g：命名实体（apos/quot/gt/lt/amp 顺序链式）
export function decodeNamedRefs(str: string): string {
  if (str === null || str.length < 4 || str.indexOf('&') < 0) {
    return str
  }
  let s = replaceAllStr(str, '&apos;', "'")
  s = replaceAllStr(s, '&quot;', '"')
  s = replaceAllStr(s, '&gt;', '>')
  s = replaceAllStr(s, '&lt;', '<')
  s = replaceAllStr(s, '&amp;', '&')
  return s
}

// z8/p.h：href 值解码（仅 &quot;）
export function decodeHrefValue(str: string): string {
  if (str === null || str.length < 4 || str.indexOf('&') < 0) {
    return str
  }
  return replaceAllStr(str, '&quot;', '"')
}

// z8/p.i：文本转义（& 先）
export function escapeText(str: string): string {
  if (str === null || str.length < 2) {
    return str
  }
  let s = replaceAllStr(str, '&', '&amp;')
  s = replaceAllStr(s, '<', '&lt;')
  s = replaceAllStr(s, '>', '&gt;')
  s = replaceAllStr(s, '"', '&quot;')
  s = replaceAllStr(s, "'", '&apos;')
  return s
}

// z8/p.j：href 转义（仅 "）
export function escapeHref(str: string): string {
  if (str === null || str.length < 2) {
    return str
  }
  return replaceAllStr(str, '"', '&quot;')
}

// z8/p.o：null/空/超 1MB 视为无效 url
function isInvalidUrl(url: string | null): boolean {
  return url === null || url.length === 0 || url.length > 1048576
}

// Long.parseLong（仅整数格式；溢出/格式错返回 null，对齐原版 catch 后不赋值）
function parseLongSafe(s: string): number | null {
  if (!/^[+-]?\d+$/.test(s)) {
    return null
  }
  const v = Number(s)
  return Number.isSafeInteger(v) ? v : null
}

// ===== e1 tokenizer =====

function isTagNameChar(c: string): boolean {
  return c === ':' || c === '!' || c === '-' || c === '/' ||
    (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')
}

// e1：token 流（0=首调 1=EOF 2=开 3=闭 4=文本）
class BookmarkHtmlTokenizer {
  private text: string
  private pos: number = 0
  private buf: string = ''
  private tokenStr: string = ''
  private lastType: number = -1

  constructor(text: string) {
    this.text = text
  }

  current(): string {
    return this.tokenStr
  }

  // e1.c：开/闭/文本分类
  private classifyToken(t: string): number {
    if (t.charAt(0) === '<' && t.charAt(t.length - 1) === '>') {
      return t.charAt(1) === '/' ? 3 : 2
    }
    return 4
  }

  // e1.e：缓冲区收尾校验（标签名字符集、引号奇偶、\ 转义）
  private tryFinishToken(): boolean {
    this.buf = trimJavaWhitespace(this.buf)
    const len = this.buf.length
    if (len === 0) {
      return false
    }
    if (this.buf.charAt(0) === '<') {
      let i = 1
      let c = '<'
      while (true) {
        if (i >= len) {
          break
        }
        const ch = this.buf.charAt(i)
        c = ch
        if (!isTagNameChar(ch)) {
          break
        }
        i++
      }
      if (c === ' ') {
        c = this.buf.charAt(len - 1)
      }
      if (c !== '>') {
        return false
      }
      // 引号配对校验（\ 跳过下一字符）
      let quoteCount = 0
      let expected = '-'
      let j = i
      while (j < len - 1) {
        const q = this.buf.charAt(j)
        if (q === '\\') {
          j++
        } else if (q === '"' || q === "'") {
          if (quoteCount % 2 === 0) {
            expected = q
          }
          if (q === expected) {
            quoteCount++
          }
        }
        j++
      }
      if (quoteCount % 2 !== 0) {
        return false
      }
    }
    this.tokenStr = this.buf
    this.buf = ''
    this.lastType = this.classifyToken(this.tokenStr)
    return true
  }

  // e1.d
  next(): number {
    if (this.lastType === -1) {
      this.lastType = 0
      return 0
    }
    while (this.pos < this.text.length) {
      const c = this.text.charAt(this.pos)
      this.pos++
      if (c === '<' && this.tryFinishToken()) {
        this.buf += c
        return this.lastType
      }
      this.buf += c
      if (c === '>' && this.tryFinishToken()) {
        return this.lastType
      }
    }
    return 1
  }

  // e1.b：属性值提取（大写/小写两查；值止于 `" ` 或 `">`；\" → "）
  attr(name: string): string | null {
    if (name === null || name.length === 0) {
      return null
    }
    const t = this.tokenStr
    if (t.length < name.length || t.charAt(0) !== '<') {
      return null
    }
    let idx = t.indexOf(' ' + name.toUpperCase() + '="')
    if (idx < 0) {
      idx = t.indexOf(' ' + name.toLowerCase() + '="')
    }
    if (idx > 0 && t.length > idx + 1) {
      const start = idx + name.length + 3
      let end = t.indexOf('" ', start)
      if (end < 0) {
        end = t.indexOf('">', start)
      }
      if (end > start) {
        return replaceAllStr(t.substring(start, end), '\\"', '"')
      }
    }
    return null
  }
}

// ===== 解析模型 =====

export class ParsedBookmarkFolder {
  id: string
  title: string = ''
  parent: string
  ordering: number
  created: number
  updatedAt: number

  constructor(id: string, parent: string, ordering: number, created: number, updatedAt: number) {
    this.id = id
    this.parent = parent
    this.ordering = ordering
    this.created = created
    this.updatedAt = updatedAt
  }
}

export class ParsedBookmarkItem {
  id: string
  title: string = ''
  url: string = ''
  parent: string
  ordering: number
  created: number
  updatedAt: number

  constructor(id: string, parent: string, ordering: number, created: number, updatedAt: number) {
    this.id = id
    this.parent = parent
    this.ordering = ordering
    this.created = created
    this.updatedAt = updatedAt
  }
}

export class ParsedBookmarkTree {
  folders: ParsedBookmarkFolder[] = []
  bookmarks: ParsedBookmarkItem[] = []
}

// ===== z8/p.q：解析 =====
// id 采用 'f'+序号 / 'b'+序号（本工程文件夹 id 为数字，'f'/'b' 前缀避免与既有 id 冲突；
// 落库时 Number(id.slice(1)) 还原序号）。时间为秒（与原版一致，落库时 *1000）。
export function parseBookmarksHtml(html: string): ParsedBookmarkTree {
  const tree = new ParsedBookmarkTree()
  const tok = new BookmarkHtmlTokenizer(html)
  const stack: ParsedBookmarkFolder[] = []
  let folderSeq = 0
  let bookmarkSeq = 0
  let curBookmark: ParsedBookmarkItem | null = null
  let textToken: string | null = null
  let done = false
  while (!done) {
    // 外层每轮重置书签序号（原版 </DL> break 后 i11 归零）
    let bookmarkOrder = 0
    let breakInner = false
    while (!breakInner) {
      const t = tok.next()
      if (t === 1) {
        done = true
        break
      }
      if (t === 2) {
        const token = tok.current()
        if (token.toLowerCase() === '<dl>') {
          // 忽略
        } else if (token.startsWith('<A ') || token.startsWith('<a ')) {
          bookmarkSeq++
          const bm = new ParsedBookmarkItem('b' + bookmarkSeq, '', bookmarkOrder, 0, 0)
          const rawHref = tok.attr('href')
          let url: string | null = rawHref === null ? null : decodeHrefValue(rawHref)
          if (url !== null && url.length > 0) {
            url = url.trim()
          }
          bm.url = url ?? ''
          if (isInvalidUrl(url)) {
            curBookmark = null
          } else {
            bm.parent = stack.length === 0 ? '' : stack[stack.length - 1].id
            const addDate = tok.attr('add_date')
            if (addDate !== null) {
              const v = parseLongSafe(addDate)
              if (v !== null) {
                bm.created = v
              }
            }
            const lastModified = tok.attr('last_modified')
            if (lastModified !== null) {
              const v2 = parseLongSafe(lastModified)
              if (v2 !== null) {
                bm.updatedAt = v2
              }
            }
            if (bm.created === 0) {
              bm.created = Math.floor(Date.now() / 1000)
            }
            if (bm.updatedAt === 0) {
              bm.updatedAt = bm.created
            }
            bookmarkOrder++
            bm.ordering = bookmarkOrder
            curBookmark = bm
          }
        } else if (token.startsWith('<H3') || token.startsWith('<h3')) {
          folderSeq++
          const folder = new ParsedBookmarkFolder('f' + folderSeq, '', folderSeq, 0, 0)
          const addDate = tok.attr('add_date')
          if (addDate !== null) {
            const v = parseLongSafe(addDate)
            if (v !== null) {
              folder.created = v
            }
          }
          const lastModified = tok.attr('last_modified')
          if (lastModified !== null) {
            const v2 = parseLongSafe(lastModified)
            if (v2 !== null) {
              folder.updatedAt = v2
            }
          }
          if (folder.created === 0) {
            folder.created = Math.floor(Date.now() / 1000)
          }
          if (folder.updatedAt === 0) {
            folder.updatedAt = folder.created
          }
          if (stack.length > 0) {
            folder.parent = stack[stack.length - 1].id
          }
          stack.push(folder)
        }
      } else if (t === 3) {
        const token = tok.current()
        const lower = token.toLowerCase()
        if (lower === '</dl>') {
          breakInner = true
        } else if (lower === '</a>') {
          if (curBookmark !== null) {
            curBookmark.title = normalizeTitle(decodeNumericRefs(textToken ?? ''))
            tree.bookmarks.push(curBookmark)
            curBookmark = null
          }
        } else if (lower === '</h3>' && stack.length > 0) {
          const folder = stack[stack.length - 1]
          folder.title = normalizeTitle(decodeNumericRefs(textToken ?? ''))
          tree.folders.push(folder)
        }
      } else if (t === 4) {
        if (curBookmark !== null || stack.length > 0) {
          textToken = decodeNamedRefs(tok.current())
        }
      }
    }
  }
  return tree
}

// ===== z8/p.r + k + m + n：导出 =====

function indentStr(level: number): string {
  let s = ''
  for (let i = 0; i < level; i++) {
    s += '  '
  }
  return s
}

// z8/p.n：书签行（LAST_MODIFIED 秒级不等才写）
function bookmarkLine(b: BookmarkRec): string {
  const createdSec = Math.floor(b.created / 1000)
  const updatedSec = Math.floor(b.updatedAt / 1000)
  let s = '<DT><A HREF="' + escapeHref(b.url) + '" ADD_DATE="' + createdSec + '"'
  if (updatedSec !== createdSec) {
    s += ' LAST_MODIFIED="' + updatedSec + '"'
  }
  s += '>' + escapeText(b.title) + '</A>'
  return s
}

// z8/p.k：递归层级输出（先子文件夹后书签）
function writeFolderLevel(folders: BookmarkFolderRec[], bookmarks: BookmarkRec[], parentId: number, indent: number): string {
  let out = ''
  const pad = indentStr(indent)
  for (let i = 0; i < folders.length; i++) {
    const f = folders[i]
    if (f.parentId === parentId) {
      // z8/p.m（214-228）：文件夹行 ADD_DATE + updated 有效且不等时追加 LAST_MODIFIED（秒级）
      const createdSec = Math.floor(f.created / 1000)
      const updatedSec = Math.floor(f.updatedAt / 1000)
      let folderLine = pad + '<DT><H3 ADD_DATE="' + createdSec + '"'
      if (f.updatedAt > 0 && updatedSec !== createdSec) {
        folderLine += ' LAST_MODIFIED="' + updatedSec + '"'
      }
      folderLine += '>' + escapeText(f.title) + '</H3>\n'
      out += folderLine
      out += pad + '<DL><p>\n'
      out += writeFolderLevel(folders, bookmarks, f.id, indent + 1)
      out += pad + '</DL><p>\n'
    }
  }
  for (let i = 0; i < bookmarks.length; i++) {
    const b = bookmarks[i]
    if (b.folderId === parentId) {
      out += pad + bookmarkLine(b) + '\n'
    }
  }
  return out
}

// z8/p.r：完整 HTML（原版 r>0 即含 bookmarks.html 条目；书签数为 0 时不产出该条目）
export function buildBookmarksHtml(folders: BookmarkFolderRec[], bookmarks: BookmarkRec[]): string {
  let out = '<!DOCTYPE NETSCAPE-Bookmark-file-1>\n<!-- This is an automatically generated file.\n' +
    '     It will be read and overwritten.\n     DO NOT EDIT! -->\n' +
    '<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">\n' +
    '<TITLE>Bookmarks</TITLE>\n<H1>Bookmarks</H1>\n<DL><p>\n'
  // z8/p.r（453-465）：folders 按 o9.a.c()（ordering）、bookmarks 按 o9.b.d()（ordering）升序
  const sortedFolders = folders.slice().sort((a: BookmarkFolderRec, b: BookmarkFolderRec) => a.ordering - b.ordering)
  const sortedBookmarks = bookmarks.slice().sort((a: BookmarkRec, b: BookmarkRec) => a.ordering - b.ordering)
  out += writeFolderLevel(sortedFolders, sortedBookmarks, 0, 1)
  out += '</DL><p>\n'
  return out
}

// ===== z8/p.p：合并重映射（导入时按 标题+父目录 匹配既有目录）=====

// existingFolderId=0 表示根；parsedParentId='' 表示解析树的根子节点
function remapLevel(tree: ParsedBookmarkTree, existing: BookmarkFolderRec[],
  existingFolderId: number, parsedParentId: string): void {
  // 既有目录中 parent==当前目录 的 标题→id
  const titleToId = new Map<string, number>()
  for (let i = 0; i < existing.length; i++) {
    const ef = existing[i]
    if (ef.parentId === existingFolderId) {
      titleToId.set(ef.title, ef.id)
    }
  }
  if (titleToId.size === 0) {
    return
  }
  // 解析树中同父目录且标题命中的 解析id→既有id
  const parsedToExisting = new Map<string, number>()
  for (let i = 0; i < tree.folders.length; i++) {
    const pf = tree.folders[i]
    if (pf.parent === parsedParentId) {
      const ex = titleToId.get(pf.title)
      if (ex !== undefined) {
        parsedToExisting.set(pf.id, ex)
      }
    }
  }
  if (parsedToExisting.size === 0) {
    return
  }
  // 书签父目录重映射
  for (let i = 0; i < tree.bookmarks.length; i++) {
    const bm = tree.bookmarks[i]
    const ex = parsedToExisting.get(bm.parent)
    if (ex !== undefined) {
      bm.parent = String(ex)
    }
  }
  // 命中目录本体 id/父目录重映射，随后递归
  const matched: ParsedBookmarkFolder[] = []
  for (let i = 0; i < tree.folders.length; i++) {
    const pf = tree.folders[i]
    const idEx = parsedToExisting.get(pf.id)
    const parentEx = parsedToExisting.get(pf.parent)
    if (idEx !== undefined || parentEx !== undefined) {
      if (idEx !== undefined) {
        pf.id = String(idEx)
      }
      if (parentEx !== undefined) {
        pf.parent = String(parentEx)
      }
      matched.push(pf)
    }
  }
  for (let i = 0; i < matched.length; i++) {
    const pf = matched[i]
    const exId = Number(pf.id)
    if (Number.isFinite(exId)) {
      remapLevel(tree, existing, exId, pf.id)
    }
  }
}

export function remapForMerge(tree: ParsedBookmarkTree, existingFolders: BookmarkFolderRec[]): void {
  remapLevel(tree, existingFolders, 0, '')
}

// ===== z8/p.d + l9/b.a：data-for-older-versions 展平行 =====
// 键序 title,url,folder,order,updated_at,created_at（org.json 保插入序）；
// folder 缺失时省略键（原版 put null 移除键）；时间 ms→s。
export function flattenForLegacyExport(folders: BookmarkFolderRec[], bookmarks: BookmarkRec[]): string {
  if (bookmarks.length === 0) {
    return ''
  }
  // o9/b 比较器：folderId 忽略大小写字符串序，再 ordering
  const sorted = bookmarks.slice().sort((a: BookmarkRec, b: BookmarkRec) => {
    const fa = String(a.folderId).toLowerCase()
    const fb = String(b.folderId).toLowerCase()
    if (fa < fb) {
      return -1
    }
    if (fa > fb) {
      return 1
    }
    return a.ordering - b.ordering
  })
  // BFS 路径构建（p.d：子目录插入父节点之后、剩余列表倒序扫描、'/'→'\/'）
  const pathById = new Map<number, string>()
  const remaining = folders.slice()
  const queueIds: Array<number | null> = [null]
  const queuePaths: Array<string | null> = [null]
  let qi = 0
  while (qi < queueIds.length) {
    const parentId = queueIds[qi]
    const parentPath = queuePaths[qi]
    const base = parentPath === null ? '' : parentPath + '/'
    qi++
    for (let fi = remaining.length - 1; fi >= 0; fi--) {
      const f = remaining[fi]
      const isChild = parentId === null ? f.parentId === 0 : f.parentId === parentId
      if (isChild) {
        const path = base + replaceAllStr(f.title, '/', '\\/')
        queueIds.splice(qi, 0, f.id)
        queuePaths.splice(qi, 0, path)
        pathById.set(f.id, path)
        remaining.splice(fi, 1)
      }
    }
  }
  let sb = ''
  for (let i = 0; i < sorted.length; i++) {
    const b = sorted[i]
    const folderPath = pathById.get(b.folderId)
    let line = '{"title":' + JSON.stringify(b.title)
    line += ',"url":' + JSON.stringify(b.url)
    if (folderPath !== undefined) {
      line += ',"folder":' + JSON.stringify(folderPath)
    }
    line += ',"order":' + b.ordering
    line += ',"updated_at":' + Math.floor(b.updatedAt / 1000)
    line += ',"created_at":' + Math.floor(b.created / 1000)
    line += '}'
    sb += line + '\n'
  }
  return sb.trim()
}
