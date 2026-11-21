// 主页自定义 CSS（原版 csstheme，w9/k.java d0/a2 → r8/d.java:149 追加进主页样式表末尾，
// i6/o.java:426-429 writer.a(strB)，仅作用于网页版主页）。
// 本工程主页是原生 ArkUI 覆盖层（非 WebView 内部页），CSS 无法由浏览器引擎执行；
// 本文件把用户 CSS 解析为「选择器 → 属性 → 值」，再经 attributeModifier 把
// **有原生等价物**的声明映射到主页对应节点；无等价物的声明（如 position、
// 伪类、@keyframes）按原版语义「追加到样式表末尾但元素不存在」一样被忽略。
// 支持的选择器与属性（与 i6/o.java 生成的类名一一对应）：
//   body/html/#content      background(-image url)/background-color/opacity → 主页根容器
//   .logo                   color/font-size/font-weight/font-style/opacity   → Logo 文字
//   .search_bar/#search_input background(-color)/border-radius/opacity        → 搜索框
//   .title                  color/font-size/opacity                          → 收藏首字
//   .url                    color/font-size/opacity                          → 收藏名称
//   .overlay/.box           border-radius                                    → 收藏图标底
//   .search_part            display:none → 隐藏搜索区（o.java:372 .search_part{display:none}）
//   #bookmark_part/#box_container display:none → 隐藏收藏区

// 值取 px 数值；非 px（%、em、calc 等）返回 -1 交由调用方忽略
function cssPx(value: string): number {
  const m = value.trim().match(/^(-?\d+(?:\.\d+)?)px$/i)
  if (m === null || m.length < 2) {
    return -1
  }
  return Number(m[1])
}

function stripImportant(value: string): string {
  return value.replace(/!important/i, '').trim()
}

export class HomeCssDecls {
  private rules: Map<string, Map<string, string>> = new Map()

  add(selector: string, prop: string, value: string): void {
    let decls = this.rules.get(selector)
    if (decls === undefined) {
      decls = new Map<string, string>()
      this.rules.set(selector, decls)
    }
    decls.set(prop, value)
  }

  // 取选择器的属性值；未声明返回 ''（调用方据此决定是否覆盖链式属性）
  decl(selector: string, prop: string): string {
    const rule = this.rules.get(selector)
    if (rule === undefined) {
      return ''
    }
    return rule.get(prop) ?? ''
  }

  // 多选择器组取第一个命中的值
  declAny(selectors: string[], prop: string): string {
    for (const sel of selectors) {
      const v = this.decl(sel, prop)
      if (v !== '') {
        return v
      }
    }
    return ''
  }

  displayNone(selector: string): boolean {
    return this.decl(selector, 'display').toLowerCase().replace(/\s+/g, '') === 'none'
  }

  // 从 background / background-image 提取 url(...)
  urlValue(selectors: string[]): string {
    for (const sel of selectors) {
      const bi = this.decl(sel, 'background-image')
      const raw = bi !== '' ? bi : this.decl(sel, 'background')
      if (raw === '') {
        continue
      }
      const m = raw.match(/url\(\s*['"]?([^'")]+?)['"]?\s*\)/i)
      if (m !== null && m.length > 1) {
        const u = m[1].trim()
        if (u !== '') {
          return u
        }
      }
    }
    return ''
  }
}

// 解析 CSS 文本。以 '}' 分段、每段用 lastIndexOf('{') 找规则头：
// @media (...) { .logo { color:red 之类嵌套残段会落到正确的 .logo 头上；
// 无 '{' 的残段（如 @media 头残余）自然跳过。后出现的同名声明覆盖先前的，
// 即原版「追加到样式表末尾」的层叠语义。
export function parseHomeCss(css: string): HomeCssDecls {
  const out = new HomeCssDecls()
  if (css === '') {
    return out
  }
  const stripped = css.replace(/\/\*[\s\S]*?\*\//g, '')
  const parts = stripped.split('}')
  for (const part of parts) {
    const brace = part.lastIndexOf('{')
    if (brace < 0) {
      continue
    }
    const body = part.substring(brace + 1)
    const heads = part.substring(0, brace).split(',')
    for (const head of heads) {
      const sel = head.trim().toLowerCase()
      if (sel === '') {
        continue
      }
      const decls = body.split(';')
      for (const d of decls) {
        const colon = d.indexOf(':')
        if (colon <= 0) {
          continue
        }
        const prop = d.substring(0, colon).trim().toLowerCase()
        const value = stripImportant(d.substring(colon + 1))
        if (prop !== '' && value !== '') {
          out.add(sel, prop, value)
        }
      }
    }
  }
  return out
}

// 通用声明应用逻辑（Text）：color/font-size/font-weight/font-style/opacity
export class HomeTextCssModifier implements AttributeModifier<TextAttribute> {
  private decls: HomeCssDecls
  private selectors: string[]

  constructor(decls: HomeCssDecls, selectors: string[]) {
    this.decls = decls
    this.selectors = selectors
  }

  applyNormalAttribute(instance: TextAttribute): void {
    const sel = this.selectors
    const color = this.decls.declAny(sel, 'color')
    if (color !== '') {
      instance.fontColor(color)
    }
    const fs = this.decls.declAny(sel, 'font-size')
    if (fs !== '') {
      const px = cssPx(fs)
      if (px > 0) {
        instance.fontSize(px)
      }
    }
    const fw = this.decls.declAny(sel, 'font-weight').toLowerCase()
    if (fw !== '') {
      if (fw === 'bold' || fw === 'bolder') {
        instance.fontWeight(FontWeight.Bold)
      } else if (fw === 'normal' || fw === 'lighter') {
        instance.fontWeight(FontWeight.Normal)
      } else {
        const n = Number(fw)
        if (!Number.isNaN(n) && n >= 100 && n <= 900) {
          instance.fontWeight(n >= 600 ? FontWeight.Bold
            : (n <= 400 ? FontWeight.Normal : FontWeight.Medium))
        }
      }
    }
    const fst = this.decls.declAny(sel, 'font-style').toLowerCase()
    if (fst === 'italic' || fst === 'oblique') {
      instance.fontStyle(FontStyle.Italic)
    } else if (fst === 'normal') {
      instance.fontStyle(FontStyle.Normal)
    }
    const op = this.decls.declAny(sel, 'opacity')
    if (op !== '') {
      const n = Number(op)
      if (!Number.isNaN(n)) {
        instance.opacity(Math.max(0, Math.min(1, n)))
      }
    }
  }
}

// 容器声明应用逻辑（Row）：background(-color)/border-radius/opacity
export class HomeRowCssModifier implements AttributeModifier<RowAttribute> {
  private decls: HomeCssDecls
  private selectors: string[]

  constructor(decls: HomeCssDecls, selectors: string[]) {
    this.decls = decls
    this.selectors = selectors
  }

  applyNormalAttribute(instance: RowAttribute): void {
    const bg = this.decls.declAny(this.selectors, 'background-color')
    const bg2 = bg !== '' ? bg : this.decls.declAny(this.selectors, 'background')
    if (bg2 !== '' && this.decls.declAny(this.selectors, 'background').indexOf('url(') < 0) {
      instance.backgroundColor(bg2)
    }
    const radius = this.decls.declAny(this.selectors, 'border-radius')
    if (radius !== '') {
      const px = cssPx(radius.split(/\s+/)[0])
      if (px >= 0) {
        instance.borderRadius(px)
      }
    }
    const op = this.decls.declAny(this.selectors, 'opacity')
    if (op !== '') {
      const n = Number(op)
      if (!Number.isNaN(n)) {
        instance.opacity(Math.max(0, Math.min(1, n)))
      }
    }
  }
}

// 容器声明应用逻辑（Stack）：background(-color)/border-radius/opacity
export class HomeStackCssModifier implements AttributeModifier<StackAttribute> {
  private decls: HomeCssDecls
  private selectors: string[]

  constructor(decls: HomeCssDecls, selectors: string[]) {
    this.decls = decls
    this.selectors = selectors
  }

  applyNormalAttribute(instance: StackAttribute): void {
    const bg = this.decls.declAny(this.selectors, 'background-color')
    const bgRaw = this.decls.declAny(this.selectors, 'background')
    const bg2 = bg !== '' ? bg : bgRaw
    if (bg2 !== '' && bgRaw.indexOf('url(') < 0) {
      instance.backgroundColor(bg2)
    }
    const radius = this.decls.declAny(this.selectors, 'border-radius')
    if (radius !== '') {
      const px = cssPx(radius.split(/\s+/)[0])
      if (px >= 0) {
        instance.borderRadius(px)
      }
    }
    const op = this.decls.declAny(this.selectors, 'opacity')
    if (op !== '') {
      const n = Number(op)
      if (!Number.isNaN(n)) {
        instance.opacity(Math.max(0, Math.min(1, n)))
      }
    }
  }
}
