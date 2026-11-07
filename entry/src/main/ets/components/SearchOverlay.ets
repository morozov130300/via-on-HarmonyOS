import { http } from '@kit.NetworkKit'
import { util } from '@kit.ArkTS'
import { i18n } from '@kit.LocalizationKit'
import { scanBarcode } from '@kit.ScanKit'
import { AppSettings, CustomEngineRec } from '../common/Settings'
import { TabStore } from '../common/TabStore'
import { BrowserDb } from '../common/Database'
import { UiInsets } from '../common/Immersive'
import {
  SearchEngineDef,
  getBuiltinEngines,
  buildSearchUrl,
  buildSuggestUrl,
  findSuggestSource,
  isUrlLike,
  normalizeUrl
} from '../common/SearchEngines'
import { ViaIcon } from './ViaIcon'
import { computeDialogWidthVp } from './ViaDialogCard'
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

@ComponentV2
export struct SearchOverlay {
  @Event onClose: () => void = () => {}
  @Param initialText: string = ''
  // 原版 C3 uiflags bit1（k6.oa z10）：布局0/1 输入条贴顶、2/3 贴底
  @Param barAtTop: boolean = true
  @Local inputText: string = ''
  @Local rows: SuggestRow[] = []
  @Local showExpandEditor: boolean = false
  @Local expandDraft: string = ''
  private settings: AppSettings = AppSettings.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  private db: BrowserDb = BrowserDb.getInstance()
  private textController: TextInputController = new TextInputController()
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

  aboutToAppear(): void {
    this.inputText = this.initialText
    if (this.inputText.trim() !== '') {
      this.fetchSuggestions(this.inputText)
    }
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
    .transition(dialogTransition())
  }

  // 原版 f12391x0（RecyclerView）：全宽 wrap 高、远离输入条一侧留 72dp、
  // 外侧两角 18dp 圆角、底色 ?attr/a2、滚动条 3dp/#80808080
  @Builder
  SuggestionList() {
    Scroll() {
      Column() {
        ForEach(this.rows, (row: SuggestRow, index: number) => {
          this.EntryRow(row, () => {
            this.commitRow(row)
          })
        }, (row: SuggestRow, index: number) => `${row.type}_${row.text}_${index}`)
        // 原版 la/b：空输入且 bit32 时用 type32 普通建议行展示搜索历史
        if (this.inputText.length === 0 && (this.settings.searchSuggestion & 32) !== 0) {
          ForEach(this.settings.searchHistory, (query: string, index: number) => {
            if (index < SUGGEST_LIMIT) {
              this.EntryRow(new SuggestRow(32, query), () => {
                this.commit(query)
              })
            }
          }, (query: string, index: number) => `hist_${query}_${index}`)
        }
      }
      .width('100%')
    }
    .width('100%')
    .scrollBar(BarState.On)
    .scrollBarColor($r('app.color.url_input_scrollbar'))
    .scrollBarWidth(3)
    .align(Alignment.Top)
    .backgroundColor($r('app.color.url_input_panel_bg'))
    .borderRadius({ bottomLeft: this.barAtTop ? URL_PANEL_RADIUS : 0,
      bottomRight: this.barAtTop ? URL_PANEL_RADIUS : 0,
      topLeft: this.barAtTop ? 0 : URL_PANEL_RADIUS,
      topRight: this.barAtTop ? 0 : URL_PANEL_RADIUS })
    .clip(true)
    .margin(this.barAtTop ? { bottom: URL_FAR_MARGIN } : { top: URL_FAR_MARGIN })
    .visibility(this.rows.length > 0 || (this.inputText.length === 0
      && (this.settings.searchSuggestion & 32) !== 0 && this.settings.searchHistory.length > 0)
      ? Visibility.Visible : Visibility.None)
  }

  // 原版 f12383p0（输入行 LinearLayout）：全宽 48dp，无行级 padding，
  // 子控件顺序 = 引擎(de) → 引擎名 chip → 输入框 → 清空(b8) → 展开(bl) → 前往(a3)
  @Builder
  InputBar() {
    Row() {
      // 1) 引擎选择（f12387t0）：drawable de / ic_search，点弹引擎单选
      this.IconSlot($r('app.media.via_ic_url_engine'), $r('app.string.search_engine'), () => {
        this.openEngineDialog()
      })
      // 2) 引擎名 chip（f12388u0）：仅非默认引擎显示，11sp + 1dp 描边 + 4dp 圆角
      if (this.engineName() !== this.builtinEngines()[0].name) {
        Text(this.engineName())
          .fontSize(11)
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
          this.fetchSuggestions(value)
        })
        .onSubmit((enterKey: EnterKeyType) => {
          this.commit(this.inputText)
        })
      // 4) 清空（f12385r0）：drawable b8 / ic_close，空文本 GONE
      if (this.inputText.length > 0) {
        this.IconSlot($r('app.media.via_ic_url_clear'), $r('app.string.url_input_clear_text'), () => {
          this.inputText = ''
          this.rows = []
          this.fetchSuggestions('')
        })
      }
      // 5) 展开文本（f12386s0）：drawable bl / ic_expand_text → tb/w0 全屏编辑器
      this.IconSlot($r('app.media.via_ic_url_expand'), $r('app.string.url_input_expand_text'), () => {
        this.expandDraft = this.inputText
        this.showExpandEditor = true
      })
      // 6) 前往（f12389v0）：drawable a3 / ic_go（b2 旋转 180°）
      this.IconSlot($r('app.media.via_ic_url_go'), $r('app.string.search'), () => {
        this.commit(this.inputText)
      })
    }
    .width('100%')
    .height(URL_BAR_HEIGHT)
    .backgroundColor($r('app.color.url_input_panel_bg'))
    .borderRadius({ topLeft: this.barAtTop ? 0 : URL_PANEL_RADIUS,
      topRight: this.barAtTop ? 0 : URL_PANEL_RADIUS,
      bottomLeft: this.barAtTop ? URL_PANEL_RADIUS : 0,
      bottomRight: this.barAtTop ? URL_PANEL_RADIUS : 0 })
    .clip(true)
  }

  // 原版 C1：ImageView 48×48dp、padding 13dp（实图 22dp）、drawable q 圆形按压、tint ?attr/a9
  @Builder
  IconSlot(icon: Resource, desc: Resource, action: () => void) {
    Stack() {
      ViaIcon({ icon: icon, iconSize: URL_ICON_SIZE, iconColor: $r('app.color.url_input_icon_tint') })
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

  private engineName(): string {
    if (this.settings.engineKey.startsWith('custom')) {
      const rec = this.settings.resolveCustomEngineKey(this.settings.engineKey)
      if (rec !== null) {
        return rec.name
      }
    }
    for (const engine of this.builtinEngines()) {
      if (engine.key === this.settings.engineKey) {
        return engine.name
      }
    }
    return this.builtinEngines()[0].name
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
        ViaIcon({ icon: this.suggestIcon(row.type), iconSize: URL_ICON_SIZE,
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
        ViaIcon({ icon: $r('app.media.via_ic_sug_fill'), iconSize: URL_ICON_SIZE,
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
    .gesture(LongPressGesture({ repeat: false, duration: 400 }).onAction(() => {
      if (row.type === 32) {
        this.confirmClearHistory()
      }
    }))
  }

  private suggestIcon(type: number): Resource {
    if (type === 1) {
      return $r('app.media.via_ic_sug_bt')
    }
    if (type === 2) {
      return $r('app.media.via_ic_sug_b5')
    }
    if (type === 4) {
      return $r('app.media.via_ic_sug_dw')
    }
    if (type === 8 || type === 32) {
      return $r('app.media.via_ic_sug_c_')
    }
    return $r('app.media.via_ic_sug_de')
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

  private commitRow(row: SuggestRow): void {
    if (row.type === 2) {
      // 计算器结果：直接作为输入，不跳转
      this.inputText = row.text
      return
    }
    if (row.type === 4) {
      // 切换到该标签页（原版 VIA-SWITCH-TAB）
      if (row.tabIndex >= 0 && row.tabIndex < this.tabStore.tabs.length) {
        this.tabStore.switchTo(row.tabIndex)
        this.onClose()
      }
      return
    }
    if (row.type === 3) {
      // 书签/历史直达
      this.tabStore.navigate(normalizeUrl(row.sub))
      this.onClose()
      return
    }
    this.commit(row.text)
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
      target = buildSearchUrl(this.settings.engineKey, this.settings.activeEngineTemplate(), input)
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
        this.IconSlot($r('app.media.via_ic_url_collapse'), $r('app.string.url_input_collapse_text'), () => {
          this.applyExpandDraft(false)
        })
        Blank()
        // 前往（w0.c3：drawable j0/ic_go）
        this.IconSlot($r('app.media.via_ic_url_go'), $r('app.string.search'), () => {
          this.applyExpandDraft(true)
        })
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
    // 原版 k0/q3：计算器命中 → 单行结果（type 2），取代其他建议
    const calc = Calculator.evaluate(query)
    if (calc !== null) {
      return [new SuggestRow(2, calc, query)]
    }
    const rows: SuggestRow[] = []
    const lower = query.toLowerCase()
    // 原版 ka/g.k()：URL 候选行
    if (isUrlLike(query)) {
      rows.push(new SuggestRow(1, query, normalizeUrl(query)))
    }
    // 原版 la/a.a：位表 收藏1/书签2/标签页4/历史8，行序 = 标签页(bit4)→收藏(bit1)→书签(bit2)→历史(bit8)，
    // 各源 limit 5，按 url 去重；bit16 搜索引擎走网络建议；bit32 搜索历史仅在空输入时展示
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
          pushCandidate(item.title, item.url, 3)
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
          pushCandidate(item.title, item.url, 3)
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
          pushCandidate(item.title, item.url, 3)
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
      rows.push(new SuggestRow(0, words[i]))
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
