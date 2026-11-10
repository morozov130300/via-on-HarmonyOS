import { http } from '@kit.NetworkKit'
import { util } from '@kit.ArkTS'
import { i18n } from '@kit.LocalizationKit'
import { display } from '@kit.ArkUI'
import { AppSettings, CustomEngineRec } from '../common/Settings'
import { TabStore } from '../common/TabStore'
import { BrowserDb } from '../common/Database'
import {
  SearchEngineDef,
  getBuiltinEngines,
  applyTemplate,
  buildSearchUrl,
  buildSuggestUrl,
  findEngine,
  findSuggestSource,
  isUrlLike,
  normalizeUrl,
  engineKeyFromId
} from '../common/SearchEngines'
import { UiaIcon } from './UiaIcon'
import { computeDialogWidthVp } from './UiaDialogCard'
import { dialogTransition } from '../common/Transitions'

// 原版 tb/k0.C1：输入行高 = 图标槽 = 建议行图标 = dimen bi(48dp)
const URL_BAR_HEIGHT: number = 48
// 原版 dimen bh(13dp)：ImageView paddingRelative(13,13,13,13)，实图 48-2*13 = 22dp
const URL_ICON_PADDING: number = 13
const URL_ICON_SIZE: number = 22
// 原版 dimen ae(18dp)：输入条/建议列表外侧圆角
const URL_PANEL_RADIUS: number = 18
// 原版 k0.C1：RecyclerView 远离输入条一侧留 72dp（.r(1,0,zB?0:72,0,zB?72:0)）
const URL_FAR_MARGIN: number = 72
// 原版 a1.xml：paddingTop/Bottom 4dp + 图标 48dp = 56dp 恒定行高
const URL_ROW_HEIGHT: number = 56

// 原版固定 5 条（pa/c：ma.e.c(str,5,i10,i11)）
const SUGGEST_LIMIT: number = 5
// 原版 ka/i：connectTimeout 3000，UA 固定 Mozilla/5.0
const SUGGEST_TIMEOUT: number = 3000
const SUGGEST_UA: string = 'Mozilla/5.0'
// 原版 ka/g：建议 LRU 缓存 128 条，缓存键 "source:query"
const SUGGEST_CACHE_SIZE: number = 128
// 原版 ka/g.q()：网络建议仅当输入长度 ≤ 200
const SUGGEST_MAX_INPUT: number = 200

// 建议行类型（原版 ka/a d 字段：0 URL、1 标签页、2 书签、8 历史、16 网络、64 计算器）
class SuggestRow {
  type: number = 0
  text: string = ''
  sub: string = ''
  tabIndex: number = -1

  constructor(type: number, text: string, sub: string = '', tabIndex: number = -1) {
    this.type = type
    this.text = text
    this.sub = sub
    this.tabIndex = tabIndex
  }
}

// 原版 tb/b：计算器求值（BigDecimal 14 位 HALF_UP、% 后缀除 100、^ 右结合、
// 隐式乘法、pi/e、sin/cos/tan/log/ln/abs/sqrt、×÷、≤256 字符、结果 0 → "0"）
class Calculator {
  private src: string = ''
  private pos: number = 0
  // 原版 f12358c：必须出现过运算符才算计算器
  private hasOp: boolean = false

  static evaluate(input: string): string | null {
    const trimmed = input.trim()
    if (trimmed === '' || input.length > 256) {
      return null
    }
    try {
      const calc = new Calculator()
      calc.src = trimmed.toLowerCase()
      const value = calc.parseRoot()
      if (calc.hasOp && Number.isFinite(value)) {
        return Calculator.formatResult(value)
      }
    } catch (error) {
      // 原版吞掉 RuntimeException 返回 null
    }
    return null
  }

  // BigDecimal(double, MathContext(14, HALF_UP)).stripTrailingZeros().toPlainString()，0 → "0"
  private static formatResult(value: number): string {
    if (value === 0) {
      return '0'
    }
    const rounded = Number(value.toPrecision(14))
    let text = rounded.toString()
    if (text.indexOf('e') >= 0 || text.indexOf('E') >= 0) {
      // 展开科学计数法为纯小数（toPlainString 语义）
      const negative = text.startsWith('-')
      if (negative) {
        text = text.substring(1)
      }
      const eIndex = text.indexOf('e') >= 0 ? text.indexOf('e') : text.indexOf('E')
      const mantissa = text.substring(0, eIndex)
      const exponent = Number(text.substring(eIndex + 1))
      let digits = mantissa.replace('.', '')
      let point = mantissa.indexOf('.') >= 0 ? mantissa.indexOf('.') : mantissa.length
      point += exponent
      let plain = ''
      if (point <= 0) {
        plain = '0.' + '0'.repeat(-point) + digits
      } else if (point >= digits.length) {
        plain = digits + '0'.repeat(point - digits.length)
      } else {
        plain = digits.substring(0, point) + '.' + digits.substring(point)
      }
      text = (negative ? '-' : '') + plain
    }
    // stripTrailingZeros：去掉小数部分末尾 0
    if (text.indexOf('.') >= 0) {
      text = text.replace(/0+$/, '').replace(/\.$/, '')
    }
    if (text === '-0') {
      text = '0'
    }
    return text
  }

  private peek(): string {
    return this.src.charAt(this.pos)
  }

  private skipSpace(): void {
    while (this.pos < this.src.length && /\s/.test(this.src.charAt(this.pos))) {
      this.pos++
    }
  }

  private consume(ch: string): boolean {
    this.skipSpace()
    if (this.pos < this.src.length && this.src.charAt(this.pos) === ch) {
      this.pos++
      return true
    }
    return false
  }

  // 原版 a.e()：整串解析，结尾必须到达末尾
  private parseRoot(): number {
    const value = this.parseAddSub()
    this.skipSpace()
    if (this.pos !== this.src.length) {
      throw new Error('trailing')
    }
    return value
  }

  // 原版 a.b()：加减
  private parseAddSub(): number {
    let value = this.parseMulDiv()
    while (true) {
      if (this.consume('+')) {
        this.hasOp = true
        value += this.parseMulDiv()
      } else if (this.consume('-')) {
        this.hasOp = true
        value -= this.parseMulDiv()
      } else {
        return value
      }
    }
  }

  // 原版 a.l()：乘除/÷× 与隐式乘法（"2pi"、"2(3)"），"2 3" 抛异常
  private parseMulDiv(): number {
    let value = this.parseUnary()
    while (true) {
      if (this.consume('*') || this.consume('×')) {
        this.hasOp = true
        value *= this.parseUnary()
      } else if (this.consume('/') || this.consume('÷')) {
        this.hasOp = true
        const divisor = this.parseUnary()
        if (divisor === 0) {
          throw new Error('div0')
        }
        value /= divisor
      } else {
        if (!this.startsFactor()) {
          return value
        }
        if (this.startsNumber()) {
          // 隐式乘法右侧是纯数字（"2 3"）→ 非法
          throw new Error('implicit-number')
        }
        this.hasOp = true
        value *= this.parseUnary()
      }
    }
  }

  // 原版 a.m()：一元正负
  private parseUnary(): number {
    if (this.consume('+')) {
      return this.parseUnary()
    }
    if (this.consume('-')) {
      this.hasOp = true
      return -this.parseUnary()
    }
    return this.parsePower()
  }

  // 原版 a.f()：^ 右结合 + % 后缀（连续 % 连除 100）
  private parsePower(): number {
    let value = this.parseAtom()
    if (this.consume('^')) {
      this.hasOp = true
      value = Math.pow(value, this.parseUnary())
    }
    while (this.consume('%')) {
      this.hasOp = true
      value /= 100
    }
    return value
  }

  // 原版 a.j()：下一字符是否 ( . 数字 字母（隐式乘法判定）
  private startsFactor(): boolean {
    this.skipSpace()
    if (this.pos >= this.src.length) {
      return false
    }
    const ch = this.peek()
    return ch === '(' || ch === '.' || this.isDigit(ch) || this.isLetter(ch)
  }

  // 原版 a.i()：下一字符是否 . 或数字
  private startsNumber(): boolean {
    this.skipSpace()
    if (this.pos >= this.src.length) {
      return false
    }
    const ch = this.peek()
    return ch === '.' || this.isDigit(ch)
  }

  private isDigit(ch: string): boolean {
    return ch >= '0' && ch <= '9'
  }

  private isLetter(ch: string): boolean {
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
  }

  // 原版 a.g()：括号 / 数字 / pi / e / 函数
  private parseAtom(): number {
    this.skipSpace()
    if (this.consume('(')) {
      const value = this.parseAddSub()
      if (!this.consume(')')) {
        throw new Error('paren')
      }
      return value
    }
    if (this.pos < this.src.length && (this.isDigit(this.peek()) || this.peek() === '.')) {
      return this.parseNumber()
    }
    const name = this.parseName()
    if (name === 'pi') {
      return 3.141592653589793
    }
    if (name === 'e') {
      return 2.718281828459045
    }
    if (name === '' || !this.consume('(')) {
      throw new Error('name')
    }
    const value = this.parseAddSub()
    if (!this.consume(')')) {
      throw new Error('paren')
    }
    this.hasOp = true
    if (name === 'ln') {
      if (value <= 0) {
        throw new Error('domain')
      }
      return Math.log(value)
    }
    if (name === 'abs') {
      return Math.abs(value)
    }
    if (name === 'cos') {
      return Math.cos(value)
    }
    if (name === 'log') {
      if (value <= 0) {
        throw new Error('domain')
      }
      return Math.log10(value)
    }
    if (name === 'sin') {
      return Math.sin(value)
    }
    if (name === 'tan') {
      return Math.tan(value)
    }
    if (name === 'sqrt') {
      if (value < 0) {
        throw new Error('domain')
      }
      return Math.sqrt(value)
    }
    throw new Error('unknown-func')
  }

  // 原版 a.d()：数字
  private parseNumber(): number {
    this.skipSpace()
    const start = this.pos
    let seenDot = false
    while (this.pos < this.src.length) {
      const ch = this.peek()
      if (this.isDigit(ch)) {
        this.pos++
      } else if (ch === '.' && !seenDot) {
        this.pos++
        seenDot = true
      } else {
        break
      }
    }
    return Number.parseFloat(this.src.substring(start, this.pos))
  }

  // 原版 a.c()：连续字母（函数名/pi/e）
  private parseName(): string {
    this.skipSpace()
    const start = this.pos
    while (this.pos < this.src.length && this.isLetter(this.peek())) {
      this.pos++
    }
    return this.src.substring(start, this.pos)
  }
}

// 原版 ka/g：书签/历史轻量匹配项
class LinkItem {
  title: string = ''
  url: string = ''

  constructor(title: string, url: string) {
    this.title = title
    this.url = url
  }
}

// 原版 c.a()：默认引擎快捷词表条目（负 id 内置，≥1 自定义主键）
class ShortcutPair {
  id: number = 0
  word: string = ''

  constructor(id: number, word: string) {
    this.id = id
    this.word = word
  }
}

// borderRadius 四角对象（arkts 要求显式类型）
class PanelCorners {
  topLeft: number = 0
  topRight: number = 0
  bottomLeft: number = 0
  bottomRight: number = 0
}

@ComponentV2
export struct SearchOverlay {
  @Event onClose: () => void = () => {}
  @Param initialText: string = ''
  // 原版 C3 uiflags bit1（k6.oa z10）：布局0/1 输入条贴顶、2/3 贴底
  @Param barAtTop: boolean = true
  // 原版 k6.oa U0：工具栏当前背景色（theme-color 适配）；0/'' = 默认色。
  // 对应 C3 uiflags bit2（zB2 = U0!=0）：非默认时图标/文字按背景亮度反色，
  // 输入条底色直接用该背景色（I3:762-776）。
  @Param toolbarBg: string = ''
  @Local inputText: string = ''
  @Local rows: SuggestRow[] = []
  @Local showExpandEditor: boolean = false
  @Local expandDraft: string = ''
  // 原版 k0.K0：命中引擎快捷词的暂存引擎 id（0=无）；仅 K0≠0 时 chip 显示且 commit 走该引擎
  @Local qualifiedEngineId: number = 0
  private settings: AppSettings = AppSettings.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  private db: BrowserDb = BrowserDb.getInstance()
  private textController: TextInputController = new TextInputController()
  // 原版 tb/k0.U2()（207-213）清空按钮只 setText("")+D3()、不清 K0；
  // ArkTS 的 onChange 无法区分「清空按钮」与「回删到空」，用该一次性旗标标记清空动作来源：
  // 置位后第一个空值 onChange 视为清空按钮路径（不复位 K0），随后立即失效
  private clearButtonArmed: boolean = false
  private engineDialogId: number = -1
  private timerId: number = -1
  private currentRequest: http.HttpRequest | null = null
  // 原版 ka/g：LRU 建议缓存，键 "source:query"
  private cache: Map<string, string[]> = new Map()
  private bookmarks: LinkItem[] = []
  private histories: LinkItem[] = []
  // 原版 bit1 = 主页收藏（fa.a.o 搜索收藏表）
  private favorites: LinkItem[] = []
  private networkRows: SuggestRow[] = []
  private activeQuery: string = ''

  // 原版 g6.y.C（亮度 0.299R+0.587G+0.114B >= 192 判亮）
  private static isLightColor(hex: string): boolean {
    const value = hex.replace('#', '')
    if (value.length < 6) {
      return false
    }
    const r = Number.parseInt(value.substring(value.length - 6, value.length - 4), 16)
    const g = Number.parseInt(value.substring(value.length - 4, value.length - 2), 16)
    const b = Number.parseInt(value.substring(value.length - 2), 16)
    return (r * 0.299 + g * 0.587 + b * 0.114) >= 192.0
  }

  // 原版 I3:762-776：bit2 自定义背景色时的前景色 —— 背景亮用 color t(#232323)，否则白
  private fgOnCustomBg(): string {
    if (this.toolbarBg !== '' && SearchOverlay.isLightColor(this.toolbarBg)) {
      return '#232323'
    }
    return '#FFFFFF'
  }

  // 原版 x8.h.c(I())：正常面板底色 —— 亮白/暗黑（z8.l.d() 走 a2 实色，否则 a3 半透）。
  // bit2 自定义背景色时输入条底色直接用该背景色（I3:776）。
  private panelBg(): ResourceColor {
    if (this.toolbarBg !== '') {
      return this.toolbarBg
    }
    return $r('app.color.url_input_panel_bg')
  }

  // 原版 k0.C1 bit2（zB2）：uiflags 由 k6.oa z11 = (U0!=0 && !n0.d()) 计算；
  // bit4（z12 = z10 && !z11 && b9()）：圆角卡模式 —— 非自定义色且窗口背景开启时生效
  private hasCustomBg(): boolean {
    return this.toolbarBg !== ''
  }

  // 原版 S3()（bit4 圆角卡）：输入条底色 View 圆角 —— g6.g.e(左上,右上,右下,左下)；
  // 上侧圆角 = (贴顶 || 列表空) ? 18 : 0；下侧圆角 = (贴顶 && 列表非空) ? 0 : 18
  private barRadius(): PanelCorners {
    const radius = URL_PANEL_RADIUS
    const listEmpty = this.displayRows().length === 0
    const top = (this.barAtTop || listEmpty) ? radius : 0
    const bottom = (this.barAtTop && !listEmpty) ? 0 : radius
    const corners = new PanelCorners()
    corners.topLeft = top
    corners.topRight = top
    corners.bottomLeft = bottom
    corners.bottomRight = bottom
    return corners
  }

  // 原版 I3:781：建议列表圆角恒为远侧两角 18dp（贴顶圆下侧、贴底圆上侧）
  private listRadius(): PanelCorners {
    const radius = URL_PANEL_RADIUS
    const corners = new PanelCorners()
    if (this.barAtTop) {
      corners.topLeft = 0
      corners.topRight = 0
      corners.bottomLeft = radius
      corners.bottomRight = radius
    } else {
      corners.topLeft = radius
      corners.topRight = radius
      corners.bottomLeft = 0
      corners.bottomRight = 0
    }
    return corners
  }

  aboutToAppear(): void {
    // 原版每次打开面板 K0 复位 0、chip GONE（k0.E3）；初始文本同样走 z3 资格判定
    this.qualifiedEngineId = 0
    this.inputText = this.initialText
    this.applyShortcutQualification(this.inputText)
    this.db.listBookmarks().then((items) => {
      const list: LinkItem[] = []
      for (const item of items) {
        list.push(new LinkItem(item.title, item.url))
      }
      this.bookmarks = list
    })
    this.db.listHistory().then((items) => {
      const list: LinkItem[] = []
      for (const item of items) {
        list.push(new LinkItem(item.title, item.url))
      }
      this.histories = list
    })
    this.db.listHomeFavs().then((items) => {
      const list: LinkItem[] = []
      for (const item of items) {
        list.push(new LinkItem(item.title, item.url))
      }
      this.favorites = list
    })
  }

  aboutToDisappear(): void {
    this.cancelPending()
    if (this.currentRequest !== null) {
      this.currentRequest.destroy()
      this.currentRequest = null
    }
  }

  build() {
    // 原版 tb/k0.C1（UrlInputFragment）：整屏 RelativeLayout 压暗，三个独立兄弟视图——
    // f12390w0 输入条底色 / f12391x0 建议 RecyclerView / f12383p0 输入行，全宽 edge-to-edge，
    // 贴顶（布局0/1）或贴底（布局2/3），绝不是包在一起的居中浮卡。
    // 这里只渲染「输入行 + 建议列表」两个兄弟视图；压暗层与贴顶/底定位由 Index.ets 承载。
    // 原版 k0.J3 → tb/w0：展开编辑器占满整个面板
    if (this.showExpandEditor) {
      this.ExpandEditor()
    } else {
      this.InputPanel()
    }
  }

  @Builder
  InputPanel() {
    // 原版 k0.C1：贴顶（bit1=1）时输入条在上、建议列表 BELOW；
    // 贴底时输入条在下、建议列表 ABOVE。两个视图各自独立底色，绝不合并成一张卡。
    // 动画：tb/k0 内部**没有任何** alpha/translate/scale 动效（全文件仅 setRotation(-90)、
    // x.r.d0 窗口 insets），整个搜索面板的进出场由 k6.oa 的
    // .v(anim_c, anim_j, anim_j, anim_d) 承担 = 进场 anim/c（alpha 0→1，integer/a=240ms 线性），
    // 退场 anim/j（fromAlpha=toAlpha=1，即**无视觉变化**）。
    // 故此处不再挂 dialogTransition（原版无 translate/scale/bounce），
    // alpha 淡入由 Index.ets 外层容器的 fadeInTransition()（240ms Linear）实现。
    Column() {
      if (this.barAtTop) {
        this.InputBar()
        this.SuggestionList()
      } else {
        this.SuggestionList()
        this.InputBar()
      }
    }
    .width('100%')
  }

  // 原版 f12391x0（RecyclerView）：全宽 wrap 高、远离输入条一侧留 72dp、
  // 外侧两角 18dp 圆角、底色 ?attr/a2、滚动条 3dp/#80808080。
  // V2()：LinearLayoutManager reverseLayout/stackFromEnd = !zB —— 贴底时条目自下往上堆叠。
  @Builder
  SuggestionList() {
    Scroll() {
      Column() {
        ForEach(this.displayRows(), (row: SuggestRow, index: number) => {
          this.EntryRow(row, () => {
            this.commitRow(row)
          })
        }, (row: SuggestRow, index: number) => `${row.type}_${row.text}_${index}`)
      }
      .width('100%')
      .backgroundColor($r('app.color.url_input_panel_bg'))
      .borderRadius(this.listRadius())
      .clip(true)
    }
    .width('100%')
    // 原版 RecyclerView 为 wrap_content（-2）；上限取屏高扣除输入条与 72dp 留白
    .constraintSize({ maxHeight: this.maxListHeight() })
    .scrollBar(BarState.Auto)
    .scrollBarColor($r('app.color.url_input_scrollbar'))
    .scrollBarWidth(3)
    .align(this.barAtTop ? Alignment.Top : Alignment.Bottom)
    // 原版 .r(1,0,zB?0:72,0,zB?72:0)：远离输入条一侧 72dp 留白
    .margin(this.barAtTop ? { bottom: URL_FAR_MARGIN } : { top: URL_FAR_MARGIN })
    .visibility(this.displayRows().length > 0 ? Visibility.Visible : Visibility.None)
  }

  // 原版 RecyclerView 无固定高度（wrap_content），但必须不越出屏幕：
  // 上限 = 屏高 - 输入条 48dp - 远侧留白 72dp
  private maxListHeight(): number {
    try {
      const d = display.getDefaultDisplaySync()
      const screen = d.height / d.densityPixels
      return screen - URL_BAR_HEIGHT - URL_FAR_MARGIN
    } catch (error) {
      return 600
    }
  }

  // 原版 ka/g.j：候选行在前，搜索历史(type32) 在后；
  // 贴底布局 reverseLayout 时整体倒序，保证贴近输入条的是第一条候选
  private displayRows(): SuggestRow[] {
    const list: SuggestRow[] = []
    for (const row of this.rows) {
      list.push(row)
    }
    if (this.inputText.length === 0 && (this.settings.searchSuggestion & 32) !== 0) {
      const history = this.settings.searchHistory
      for (let i = 0; i < history.length && i < SUGGEST_LIMIT; i++) {
        list.push(new SuggestRow(32, history[i]))
      }
    }
    if (this.barAtTop) {
      return list
    }
    const reversed: SuggestRow[] = []
    for (let i = list.length - 1; i >= 0; i--) {
      reversed.push(list[i])
    }
    return reversed
  }

  // 原版 f12383p0（输入行 LinearLayout）：全宽 48dp，无行级 padding，
  // 子控件顺序 = 引擎(de) → 引擎名 chip → 输入框 → 清空(b8) → 展开(bl) → 前往(a3)
  @Builder
  InputBar() {
    Row() {
      // 1) 引擎选择（f12387t0）：drawable de / ic_search，点弹引擎单选
      this.IconSlot($r('app.media.uia_ic_url_engine'), $r('app.string.search_engine'), () => {
        this.openEngineDialog()
      })
      // 2) 引擎名 chip（f12388u0 / k0.u0）：仅命中引擎快捷词（K0≠0）时显示；
      // 原版 u0：16sp + 1dp 描边 + 4dp 圆角（k0.C1:575），空输入恒 GONE（k0.E3）
      if (this.qualifiedEngineId !== 0) {
        Text(this.engineNameById(this.qualifiedEngineId))
          .fontSize(16)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .padding({ left: 6, right: 6, top: 2, bottom: 2 })
          .margin({ left: 4, right: 4 })
          .border({ width: 1, color: $r('app.color.fg') })
          .borderRadius(4)
      }
      // 3) 输入框：16sp、正文与 hint 同色 ?attr/ac、透明底、IME Go
      TextInput({ text: this.inputText, placeholder: $r('app.string.search'), controller: this.textController })
        .layoutWeight(1)
        .height(URL_BAR_HEIGHT)
        .fontSize(16)
        .backgroundColor(Color.Transparent)
        .fontColor($r('app.color.fg'))
        .placeholderColor($r('app.color.fg'))
        .enterKeyType(EnterKeyType.Go)
        .maxLength(Number.MAX_SAFE_INTEGER)
        .defaultFocus(true)
        .selectAll(true)
        .id('search_overlay_input')
        .onAppear(() => {
          this.getUIContext().getFocusController().requestFocus('search_overlay_input')
        })
        .onChange((value: string) => {
          this.inputText = value
          // 原版 p3 → z3：每次变更先做快捷词资格判定（命中则剥离前缀并重取建议）
          this.applyShortcutQualification(value)
        })
        .onSubmit((enterKey: EnterKeyType) => {
          this.commit(this.inputText)
        })
      // 4) 清空（f12385r0）：drawable b8 / ic_close，空文本 GONE
      // 原版 tb/k0.java U2()（207-213）：清空按钮**只** setText("") + D3()（重取建议），
      // **不复位 K0**（引擎 chip 保持）。K0 只在「回删到空」(E3，:399-400) 或
      // 「切换引擎」(:527-530) 时复位。
      // 注意：不能走 applyShortcutQualification('')——那条路会清 K0。
      if (this.inputText.length > 0) {
        this.IconSlot($r('app.media.uia_ic_url_clear'), $r('app.string.url_input_clear_text'), () => {
          // 标记「本次置空来自清空按钮」，供 applyShortcutQualification 判定不清 K0。
          // 若 TextInput 的程序化置空不触发 onChange，旗标会在 300ms 后自动失效，
          // 不会污染之后的「回删到空」判定。
          this.clearButtonArmed = true
          this.inputText = ''
          this.rows = []
          this.fetchSuggestions('')
          setTimeout(() => {
            this.clearButtonArmed = false
          }, 300)
        })
      }
      // 5) 展开文本（f12386s0）：drawable bl / ic_expand_text → tb/w0 全屏编辑器
      this.IconSlot($r('app.media.uia_ic_url_expand'), $r('app.string.url_input_expand_text'), () => {
        this.expandDraft = this.inputText
        this.showExpandEditor = true
      })
      // 6) 前往（f12389v0）：原版 k0.t3 → drawable j0 = a3（b2 旋转 180°，箭头朝右），
      // 与工具栏前进按钮同一画法：uia_ic_back + rotateDeg 180（k6 前进分支同款）
      this.IconSlot($r('app.media.uia_ic_back'), $r('app.string.search'), (): void => {
        this.commit(this.inputText)
      }, 180)
    }
    .width('100%')
    .height(URL_BAR_HEIGHT)
    .backgroundColor(this.panelBg())
    .borderRadius(this.barRadius())
    .clip(true)
  }

  // 原版 C1：ImageView 48×48dp、padding 13dp（实图 22dp）、drawable q 圆形按压、tint ?attr/a9
  @Builder
  IconSlot(icon: Resource, desc: Resource, action: () => void, rotateDeg: number = 0) {
    Stack() {
      UiaIcon({ icon: icon, iconSize: URL_ICON_SIZE, iconColor: $r('app.color.url_input_icon_tint'),
        rotateDeg: rotateDeg })
    }
    .width(URL_BAR_HEIGHT)
    .height(URL_BAR_HEIGHT)
    .padding(URL_ICON_PADDING)
    .alignContent(Alignment.Center)
    .accessibilityText(desc)
    .borderRadius(URL_BAR_HEIGHT / 2)
    .stateStyles({
      pressed: { .backgroundColor($r('app.color.url_input_pressed')) },
      normal: { .backgroundColor(Color.Transparent) }
    })
    .onClick(() => {
      action()
    })
  }

  // 原版 k0.O3：w5.k.l().d0(搜索引擎).b0(引擎名数组, 当前项, 回调).f0()
  private openEngineDialog(): void {
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.EngineDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.engineDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open engine dialog failed: ${error.message}`)
    })
  }

  private closeEngineDialog(): void {
    if (this.engineDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.engineDialogId)
    this.engineDialogId = -1
  }

  // 原版 v2.b：内置引擎按 locale 排序 + 自定义引擎
  private builtinEngines(): SearchEngineDef[] {
    const locale = i18n.System.getSystemLanguage()
    const isZh = locale.startsWith('zh')
    const isRu = locale.startsWith('ru')
    return getBuiltinEngines(isZh, isRu)
  }

  // 原版 k0.O3：w5.k.l().d0(搜索引擎).b0(names, checked, cb).f0() 单选弹窗（layout v.xml）
  @Builder
  EngineDialog() {
    Column() {
      Text($r('app.string.search_engine'))
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Scroll() {
        Column() {
          ForEach(this.builtinEngines(), (engine: SearchEngineDef) => {
            this.EngineOption(engine.name, engine.key)
          }, (engine: SearchEngineDef) => engine.key)
          ForEach(this.settings.customEngines, (rec: CustomEngineRec, index: number) => {
            this.EngineOption(rec.name, `custom:${rec.id}`)
          }, (rec: CustomEngineRec, index: number) => `custom_${rec.id}_${index}`)
        }
        .width('100%')
      }
      .constraintSize({ maxHeight: 384 })
    }
    .width('80%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .transition(dialogTransition())
  }

  @Builder
  EngineOption(name: string, key: string) {
    Row({ space: 24 }) {
      Circle({ width: 16, height: 16 })
        .fill(this.settings.engineKey === key ? $r('app.color.accent') : Color.Transparent)
        .stroke(this.settings.engineKey === key ? Color.Transparent : $r('app.color.dialog_border'))
        .strokeWidth(2)
      Text(name)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .layoutWeight(1)
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 12, bottom: 12 })
    .onClick(() => {
      this.settings.setEngineKey(key)
      // 原版 w3：外部默认引擎变更 → K0≠0 时 E3()（复位 chip）
      this.qualifiedEngineId = 0
      this.closeEngineDialog()
      this.fetchSuggestions(this.inputText)
    })
  }

  // 原版 resources/r/f/a1.xml：水平行、48dp 图标槽(13dp padding)、双行 14sp/11sp、
  // 右侧 48dp 箭头按钮(c1/ic_fill_url) 点击填入输入框；行按压底 #30808080
  @Builder
  EntryRow(row: SuggestRow, action: () => void) {
    Row() {
      // 左图标：按 ka/a.d() 类型 —— 收藏1(bt)/书签2(b5)/标签页4(dw)/历史8,32(c_)/其它(de)
      Stack() {
        UiaIcon({ icon: this.suggestIcon(row.type), iconSize: URL_ICON_SIZE,
          iconColor: $r('app.color.url_input_icon_tint') })
      }
      .width(URL_BAR_HEIGHT)
      .height(URL_BAR_HEIGHT)
      .padding(URL_ICON_PADDING)
      .alignContent(Alignment.Center)
      .accessibilityText($r('app.string.url_input_suggestion'))
      Column() {
        Text(row.text)
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .width('100%')
        if (row.sub !== '') {
          Text(row.sub)
            .fontSize(11)
            .fontColor($r('app.color.url_input_sub_text'))
            .maxLines(1)
            .width('100%')
        }
      }
      .alignItems(HorizontalAlign.Start)
      .layoutWeight(1)
      // 右箭头：填入文本（a.q()），贴底布局时旋转 -90°
      Stack() {
        UiaIcon({ icon: $r('app.media.uia_ic_sug_fill'), iconSize: URL_ICON_SIZE,
          iconColor: $r('app.color.url_input_icon_tint') })
          .rotate({ angle: this.barAtTop ? 0 : -90 })
      }
      .width(URL_BAR_HEIGHT)
      .height(URL_BAR_HEIGHT)
      .padding(URL_ICON_PADDING)
      .alignContent(Alignment.Center)
      .accessibilityText($r('app.string.url_input_fill_text'))
      .borderRadius(URL_BAR_HEIGHT / 2)
      .stateStyles({
        pressed: { .backgroundColor($r('app.color.url_input_pressed')) },
        normal: { .backgroundColor(Color.Transparent) }
      })
      .onClick(() => {
        this.fillFromRow(row)
      })
    }
    .width('100%')
    .height(URL_ROW_HEIGHT)
    .padding({ top: 4, bottom: 4 })
    .stateStyles({
      pressed: { .backgroundColor($r('app.color.url_input_pressed')) },
      normal: { .backgroundColor(Color.Transparent) }
    })
    .onClick(() => {
      action()
    })
    // 原版 k0.e3：长按 type32 搜索历史行 → 清除搜索历史确认弹窗
    .gesture(LongPressGesture({ repeat: false, duration: 500 }).onAction(() => {
      if (row.type === 32) {
        this.confirmClearHistory()
      }
    }))
  }

  private suggestIcon(type: number): Resource {
    if (type === 1) {
      return $r('app.media.uia_ic_sug_bt')
    }
    if (type === 2) {
      return $r('app.media.uia_ic_sug_b5')
    }
    if (type === 4) {
      return $r('app.media.uia_ic_sug_dw')
    }
    if (type === 8 || type === 32) {
      return $r('app.media.uia_ic_sug_c_')
    }
    return $r('app.media.uia_ic_sug_de')
  }

  // 原版 a.q()：把建议文本填入 EditText 并把光标移到末尾
  private fillFromRow(row: SuggestRow): void {
    const text = row.type === 2 ? row.text : (row.sub !== '' ? row.sub : row.text)
    this.inputText = text
    this.textController.caretPosition(text.length)
    this.fetchSuggestions(text)
  }

  // 原版 k0.e3：w5.k 确认弹窗（dt/du）
  private confirmClearHistory(): void {
    AlertDialog.show({
      title: $r('app.string.clear_search_history'),
      message: $r('app.string.url_input_confirm_clear_history'),
      primaryButton: {
        value: $r('app.string.confirm'),
        action: () => {
          this.settings.clearSearchHistory()
          this.fetchSuggestions('')
        }
      },
      secondaryButton: {
        value: $r('app.string.cancel'),
        action: () => {}
      }
    })
  }

  // 原版 k0.s3（481-496）：type4 切标签、type64 只回填输入、其余 N3(a.b()) 前往；
  // a.b()（ka/a.java:45）优先取 url(sub)，为空则取标题(text)。
  private commitRow(row: SuggestRow): void {
    if (row.type === 64) {
      // 计算器结果：只填回输入框，不跳转
      this.fillFromRow(row)
      return
    }
    if (row.type === 4) {
      // 切换到该标签页（原版 UIA-SWITCH-TAB）
      if (row.tabIndex >= 0 && row.tabIndex < this.tabStore.tabs.length) {
        this.tabStore.switchTo(row.tabIndex)
        this.onClose()
      }
      return
    }
    this.commit(row.sub !== '' ? row.sub : row.text)
  }

  // 原版 c.a()：默认引擎快捷词表（id→词），locale 无关
  private static readonly DEFAULT_SHORTCUTS: ShortcutPair[] = [
    new ShortcutPair(-1, 'gg'), new ShortcutPair(-2, 'bd'), new ShortcutPair(-3, 'bn'),
    new ShortcutPair(-4, 'sm'), new ShortcutPair(-5, 'qh'), new ShortcutPair(-6, 'sg'),
    new ShortcutPair(-7, 'yd'), new ShortcutPair(-8, 'yh'), new ShortcutPair(-9, 'sp'),
    new ShortcutPair(-10, 'dd'), new ShortcutPair(-11, 'tt'), new ShortcutPair(-12, 'mt')
  ]

  // 原版 c.f()：默认表叠加用户 searchshortcuts JSON（{"<引擎id>":"<词>"}）
  private shortcutWordToEngine(): Map<string, number> {
    const map: Map<string, number> = new Map()
    for (const pair of SearchOverlay.DEFAULT_SHORTCUTS) {
      map.set(pair.word, pair.id)
    }
    const raw = this.settings.searchshortcuts
    if (raw !== '') {
      try {
        const obj = JSON.parse(raw) as Record<string, string>
        for (const key of Object.keys(obj)) {
          const id = Number(key)
          const word = String(obj[key]).trim().toLowerCase()
          if (!Number.isNaN(id) && word !== '') {
            map.set(word, id)
          }
        }
      } catch (error) {
      }
    }
    return map
  }

  // 原版 k0.y3：引擎名（g6.p.j(str,16) 截 16）
  private engineNameById(id: number): string {
    const key = engineKeyFromId(id)
    if (key === null) {
      return ''
    }
    let name: string
    if (id >= 1) {
      const rec = this.settings.resolveCustomEngineKey(key)
      name = rec !== null ? rec.name : ''
    } else {
      name = findEngine(key).name
    }
    return name.length > 16 ? name.substring(0, 16) : name
  }

  // 原版 k0.F3：K0≠0 且非空 → d.b(str,K0) 按命中引擎搜索
  private buildSearchUrlForEngine(id: number, query: string): string {
    const key = engineKeyFromId(id)
    if (key === null) {
      return buildSearchUrl(this.settings.engineKey, this.settings.activeEngineTemplate(), query)
    }
    if (id >= 1) {
      const rec = this.settings.resolveCustomEngineKey(key)
      if (rec !== null) {
        return applyTemplate(rec.template, query)
      }
      return buildSearchUrl(this.settings.engineKey, this.settings.activeEngineTemplate(), query)
    }
    return applyTemplate(findEngine(key).template, query)
  }

  // 原版 k0.z3/p3（beforeTextChanged）：首词命中快捷词表 → K0=id、chip 显示、
  // 剥离快捷词前缀（g6.p.e 首空格位之后 trim）并重取建议；已命中(K0≠0)不重复判定。
  // 空文本分支对应原版两条**互不相同**的路径：
  //   · 回删到空：l3()（tb/k0.java:397-402）KEYCODE_DEL 且 selectionStart/End==0 → E3()（清 K0）
  //   · 清空按钮：U2()（tb/k0.java:207-213）只 setText("") + D3()，**不调 E3()、不清 K0**
  // ArkTS 的 TextInput 无法在 onChange 里区分这两者（都得到 value===''），
  // 故用 clearButtonArmed 一次性旗标把「点清空按钮引起的这一次置空」排除在清 K0 之外；
  // 切换引擎另走 EngineOption 的 w3 等价分支（tb/k0.java:527-531）。
  private applyShortcutQualification(value: string): void {
    if (value === '') {
      // 清空按钮路径（U2）：保留 K0，仅 D3() 等价的重取建议；旗标只消费一次
      if (this.clearButtonArmed) {
        this.clearButtonArmed = false
        this.fetchSuggestions('')
        return
      }
      // 回删到空（l3 → E3）：复位 K0、chip 隐藏
      this.qualifiedEngineId = 0
      this.fetchSuggestions('')
      return
    }
    // 出现任何非空内容即撤销清空标记，避免旗标滞留影响之后的回删判定
    this.clearButtonArmed = false
    if (this.qualifiedEngineId !== 0) {
      this.fetchSuggestions(value)
      return
    }
    const iE = value.search(/\s/)
    if (iE <= 0) {
      this.fetchSuggestions(value)
      return
    }
    const token = value.substring(0, iE).trim().toLowerCase()
    const id = this.shortcutWordToEngine().get(token)
    if (id === undefined) {
      this.fetchSuggestions(value)
      return
    }
    const remaining = value.substring(iE).trim()
    this.qualifiedEngineId = id
    // 原版 q0.setText(strTrim)：数据绑定改写输入框（等价程序化 setText），K0 已置位 → 后续 z3 早退
    this.inputText = remaining
    this.textController.caretPosition(remaining.length)
    this.fetchSuggestions(remaining)
  }

  private commit(text: string): void {
    const input = text.trim()
    if (input === '') {
      return
    }
    let target: string
    if (isUrlLike(input)) {
      target = normalizeUrl(input)
    } else {
      this.settings.addSearchHistory(input)
      if (this.qualifiedEngineId !== 0) {
        target = this.buildSearchUrlForEngine(this.qualifiedEngineId, input)
      } else {
        target = buildSearchUrl(this.settings.engineKey, this.settings.activeEngineTemplate(), input)
      }
    }
    this.tabStore.navigate(target)
    this.onClose()
  }

  // 原版 tb/w0.J3：全屏「展开文本」编辑器（多行 EditText + 收起/前往两个按钮）
  @Builder
  ExpandEditor() {
    Column() {
      Scroll() {
        TextArea({ text: this.expandDraft, placeholder: $r('app.string.search') })
          .width('100%')
          .constraintSize({ minHeight: 160 })
          .backgroundColor(Color.Transparent)
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.fg'))
          .fontSize(16)
          .padding(16)
          .onChange((value: string) => {
            this.expandDraft = value
          })
      }
      .width('100%')
      .layoutWeight(1)
      Row() {
        // 收起（w0.d3：drawable A/ic_collapse_text）
        this.IconSlot($r('app.media.uia_ic_url_collapse'), $r('app.string.url_input_collapse_text'), () => {
          this.applyExpandDraft(false)
        })
        Blank()
        // 前往（w0.c3：drawable j0 = a3，b2 旋转 180°，箭头朝右；同工具栏前进画法）
        this.IconSlot($r('app.media.uia_ic_back'), $r('app.string.search'), (): void => {
          this.applyExpandDraft(true)
        }, 180)
      }
      .width('100%')
      .height(URL_BAR_HEIGHT)
      .backgroundColor($r('app.color.url_input_panel_bg'))
    }
    .width('100%')
    .height('100%')
    .backgroundColor($r('app.color.url_input_panel_bg'))
  }

  private applyExpandDraft(go: boolean): void {
    this.inputText = this.expandDraft
    this.textController.caretPosition(this.expandDraft.length)
    this.fetchSuggestions(this.expandDraft)
    this.showExpandEditor = false
    if (go) {
      this.commit(this.expandDraft)
    }
  }

  private cancelPending(): void {
    if (this.timerId !== -1) {
      clearTimeout(this.timerId)
      this.timerId = -1
    }
  }

  private cacheGet(key: string): string[] | null {
    const value = this.cache.get(key)
    if (value === undefined) {
      return null
    }
    // LRU 触达前置
    this.cache.delete(key)
    this.cache.set(key, value)
    return value
  }

  private cachePut(key: string, value: string[]): void {
    this.cache.set(key, value)
    if (this.cache.size > SUGGEST_CACHE_SIZE) {
      for (const oldest of this.cache.keys()) {
        this.cache.delete(oldest)
        break
      }
    }
  }

  private suggestSourceKey(): string {
    // 原版 v2.f：引擎 → 建议源（google/bing/so360/baidu），其余引擎无建议接口
    const key = this.settings.engineKey
    if (key.startsWith('custom')) {
      return ''
    }
    const source = findSuggestSource(key)
    return source !== null ? key : ''
  }

  // 原版 ka/g + k0/m3：候选（URL/标签页/书签/历史/计算器）先发，网络建议后发追加
  private fetchSuggestions(query: string): void {
    this.cancelPending()
    const text = query.trim()
    this.activeQuery = text
    this.networkRows = []
    if (text === '') {
      this.rows = []
      return
    }
    this.rows = this.buildLocalRows(text)
    this.maybeFetchNetwork(text)
  }

  private buildLocalRows(query: string): SuggestRow[] {
    // 原版 k0.q3：计算器命中 → 单行结果（type 64），取代其他建议
    const calc = Calculator.evaluate(query)
    if (calc !== null) {
      return [new SuggestRow(64, calc, query)]
    }
    const rows: SuggestRow[] = []
    const lower = query.toLowerCase()
    // 原版 ka/g.k()：URL 候选行（type 0 → 走网络建议/直接前往）
    if (isUrlLike(query)) {
      rows.push(new SuggestRow(0, query, normalizeUrl(query)))
    }
    // 原版 la/a.a：位表 收藏1/书签2/标签页4/历史8，行序 = 标签页(4)→收藏(1)→书签(2)→历史(8)，
    // 各源 limit 5，按 url 去重；bit16 走网络建议；bit32 搜索历史仅在空输入时展示
    const flags = this.settings.searchSuggestion
    const seen = new Set<string>()
    const pushCandidate = (title: string, url: string, type: number): void => {
      if (seen.has(url)) {
        return
      }
      seen.add(url)
      rows.push(new SuggestRow(type, title !== '' ? title : url, url))
    }
    let count = 0
    if ((flags & 4) !== 0) {
      for (let i = 0; i < this.tabStore.tabs.length && count < SUGGEST_LIMIT; i++) {
        const tab = this.tabStore.tabs[i]
        if (tab.url.toLowerCase().indexOf(lower) >= 0 || tab.title.toLowerCase().indexOf(lower) >= 0) {
          pushCandidate(tab.title !== '' ? tab.title : tab.url, tab.url, 4)
          count++
        }
      }
    }
    if ((flags & 1) !== 0) {
      for (const item of this.favorites) {
        if (count >= SUGGEST_LIMIT) {
          break
        }
        if (item.title.toLowerCase().indexOf(lower) >= 0 || item.url.toLowerCase().indexOf(lower) >= 0) {
          pushCandidate(item.title, item.url, 1)
          count++
        }
      }
    }
    if ((flags & 2) !== 0) {
      for (const item of this.bookmarks) {
        if (count >= SUGGEST_LIMIT) {
          break
        }
        if (item.title.toLowerCase().indexOf(lower) >= 0 || item.url.toLowerCase().indexOf(lower) >= 0) {
          pushCandidate(item.title, item.url, 2)
          count++
        }
      }
    }
    if ((flags & 8) !== 0) {
      for (const item of this.histories) {
        if (count >= SUGGEST_LIMIT) {
          break
        }
        if (item.title.toLowerCase().indexOf(lower) >= 0 || item.url.toLowerCase().indexOf(lower) >= 0) {
          pushCandidate(item.title, item.url, 8)
          count++
        }
      }
    }
    return rows
  }

  // 原版 ka/g.q()：(flags & 16) 且输入 ≤ 200 才请求网络建议
  private maybeFetchNetwork(query: string): void {
    if (!this.settings.isNetworkSuggestOn() || query.length > SUGGEST_MAX_INPUT) {
      return
    }
    const sourceKey = this.suggestSourceKey()
    if (sourceKey === '') {
      return
    }
    const cached = this.cacheGet(`${sourceKey}:${query}`)
    if (cached !== null) {
      this.applyNetworkRows(query, cached)
      return
    }
    this.timerId = setTimeout(() => {
      this.requestSuggestions(sourceKey, query)
    }, 200)
  }

  private applyNetworkRows(query: string, words: string[]): void {
    const rows: SuggestRow[] = []
    for (let i = 0; i < words.length && i < SUGGEST_LIMIT; i++) {
      rows.push(new SuggestRow(16, words[i]))
    }
    this.networkRows = rows
    // 原版 k0/m3：网络建议到达后追加到候选之后（第二次发射）
    if (this.activeQuery === query) {
      this.rows = this.buildLocalRows(query).concat(rows)
    }
  }

  private requestSuggestions(sourceKey: string, query: string): void {
    if (this.currentRequest !== null) {
      this.currentRequest.destroy()
      this.currentRequest = null
    }
    const locale = i18n.System.getSystemLanguage()
    const parts = locale.split('-')
    const language = parts.length > 0 ? parts[0] : 'zh'
    const region = parts.length > 1 ? parts[1] : ''
    const url = buildSuggestUrl(sourceKey, query, language, region)
    if (url === null) {
      return
    }
    const request: http.HttpRequest = http.createHttp()
    this.currentRequest = request
    request.request(url, {
      method: http.RequestMethod.GET,
      connectTimeout: SUGGEST_TIMEOUT,
      readTimeout: SUGGEST_TIMEOUT,
      usingCache: false,
      expectDataType: http.HttpDataType.ARRAY_BUFFER,
      header: { 'User-Agent': SUGGEST_UA }
    }).then((response: http.HttpResponse) => {
      if (this.currentRequest !== request) {
        return
      }
      this.currentRequest = null
      const words = this.parseSuggestions(sourceKey, response, query)
      this.cachePut(`${sourceKey}:${query}`, words)
      this.applyNetworkRows(query, words)
      request.destroy()
    }).catch((error: BusinessError) => {
      if (this.currentRequest === request) {
        this.currentRequest = null
      }
      request.destroy()
    })
  }

  private parseSuggestions(sourceKey: string, response: http.HttpResponse, query: string): string[] {
    if (sourceKey === 'baidu') {
      // 原版 ma/a：GB2312 + suggestion({...}) 前缀 + 实体反转义（仅百度）
      return this.parseBaidu(response)
    }
    if (sourceKey === 'bing') {
      // 原版 ma/b
      return this.parseBing(response)
    }
    if (sourceKey === 'so360') {
      // 原版 ma/d
      return this.parse360(response)
    }
    // 原版 ma/c：Google
    return this.parseGoogle(response)
  }

  // Google：XML <suggestion data="..."/>（ma/c）
  private parseGoogle(response: http.HttpResponse): string[] {
    const raw = response.result
    if (typeof raw !== 'string') {
      return []
    }
    const body: string = raw
    const list: string[] = []
    const regex = /<suggestion data="([^"]*)"/g
    let match = regex.exec(body)
    while (match !== null && list.length < SUGGEST_LIMIT) {
      // 原版 Html.fromHtml：反转义 HTML 实体
      list.push(unescapeEntities(match[1]))
      match = regex.exec(body)
    }
    return list
  }

  // 百度：GB2312 JSONP suggestion({"s":[...]})（ma/a）
  private parseBaidu(response: http.HttpResponse): string[] {
    const raw = response.result
    let body: string
    if (typeof raw === 'string') {
      body = raw
    } else if (raw instanceof ArrayBuffer) {
      try {
        const decoder = util.TextDecoder.create('gb2312')
        body = decoder.decodeToString(new Uint8Array(raw))
      } catch (error) {
        return []
      }
    } else {
      return []
    }
    // 原版 ma/a：startsWith("suggestion({")，substring(11, lastIndexOf(')'))，取 "s" 数组
    if (body.length < 15 || !body.startsWith('suggestion({')) {
      return []
    }
    const end = body.lastIndexOf(')')
    const jsonText = body.substring(11, end > 0 ? end : body.length)
    try {
      const json = JSON.parse(jsonText) as Record<string, Object>
      const words = json['s'] as Object[]
      const list: string[] = []
      if (words instanceof Array) {
        for (const word of words) {
          if (typeof word === 'string' && list.length < SUGGEST_LIMIT) {
            // 原版 ma/a.b()：实体反转义（仅百度做此处理）
            list.push(unescapeEntities(word as string))
          }
        }
      }
      return list
    } catch (error) {
      return []
    }
  }

  // 必应：JSON {"AS":{"Results":[{"Suggests":[{"Txt":"..."}]}]}}（ma/b：
  // indexOf(",\"Suggests\":[")+12 到 indexOf("]}]}}", start+13)+1）
  private parseBing(response: http.HttpResponse): string[] {
    const raw = response.result
    if (typeof raw !== 'string') {
      return []
    }
    const body: string = raw
    if (body.length < 20) {
      return []
    }
    const suggestsIndex = body.indexOf(',"Suggests":[')
    if (suggestsIndex < 0) {
      return []
    }
    const end = body.indexOf(']}]}}', suggestsIndex + 13)
    if (end <= suggestsIndex + 13) {
      return []
    }
    try {
      const json = JSON.parse(body.substring(suggestsIndex + 12, end + 1)) as Object[]
      const list: string[] = []
      for (const item of json) {
        const txt = (item as Record<string, Object>)['Txt']
        if (typeof txt === 'string' && txt !== '' && list.length < SUGGEST_LIMIT) {
          list.push(txt)
        }
      }
      return list
    } catch (error) {
      return []
    }
  }

  // 360：JSON {"result":[{"word":"..."}]}（ma/d）
  private parse360(response: http.HttpResponse): string[] {
    const raw = response.result
    if (typeof raw !== 'string') {
      return []
    }
    const body: string = raw
    if (body.length < 10) {
      return []
    }
    try {
      const json = JSON.parse(body) as Record<string, Object>
      const words = json['result'] as Object[]
      const list: string[] = []
      if (words instanceof Array) {
        for (const word of words) {
          if (list.length >= SUGGEST_LIMIT) {
            break
          }
          const text = (word as Record<string, Object>)['word']
          if (typeof text === 'string' && text !== '') {
            list.push(text)
          }
        }
      }
      return list
    } catch (error) {
      return []
    }
  }
}

// 原版 ma/a + Html.fromHtml：HTML 实体反转义（含数字实体）
function unescapeEntities(text: string): string {
  return text
    .replace(/&amp;/g, '&')
    .replace(/&lt;/g, '<')
    .replace(/&gt;/g, '>')
    .replace(/&quot;/g, '"')
    .replace(/&apos;/g, "'")
    .replace(/&#39;/g, "'")
    .replace(/&#(\d+);/g, (match: string, code: string): string => {
      return String.fromCharCode(Number(code))
    })
}
