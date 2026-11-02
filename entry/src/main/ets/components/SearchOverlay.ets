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
import { AppIcon } from './AppIcon'
import { ViaIcon } from './ViaIcon'
import { dialogTransition } from '../common/Transitions'

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
  @Local inputText: string = ''
  @Local rows: SuggestRow[] = []
  private settings: AppSettings = AppSettings.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  private db: BrowserDb = BrowserDb.getInstance()
  private insets: UiInsets = UiInsets.getInstance()
  private textController: TextInputController = new TextInputController()
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
    // 原版 bb/i（RecordContainerFragment）：搜索为地址栏下方吸附的浮动圆角卡（非全屏黑面板），
    // 卡 = 输入行（引擎选择/输入/清空/扫码/提交）+ 建议列表，圆角 12、背景 menu_bg、宽度收窄
    Column() {
      Row({ space: 10 }) {
        // 原版顶栏第一个按钮：搜索引擎选择（弹引擎单选，O3）
        Text(this.engineName())
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .constraintSize({ maxWidth: 72 })
          .maxLines(1)
          .bindMenu((): void => {
            this.EngineMenu()
          })
        TextInput({ text: this.inputText, placeholder: $r('app.string.search'), controller: this.textController })
          .layoutWeight(1)
          .height(40)
          .fontSize(16)
          .backgroundColor(Color.Transparent)
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.fg_secondary'))
          .caretColor($r('app.color.accent'))
          .enterKeyType(EnterKeyType.Search)
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
        // 原版顶栏：清空（非空才显示）
        if (this.inputText.trim() !== '') {
          AppIcon({ icon: $r('sys.symbol.xmark'), iconSize: 20, iconColor: $r('app.color.fg_secondary') })
            .onClick(() => {
              this.inputText = ''
              this.rows = []
              this.fetchSuggestions('')
            })
        }
        // 原版顶栏：扫码（J3 打开扫码并回填）
        ViaIcon({ icon: $r('app.media.via_ic_addr_scan'), iconSize: 22, iconColor: $r('app.color.fg_secondary') })
          .onClick(() => {
            this.startScan()
          })
        // 原版顶栏：搜索提交
        AppIcon({ icon: $r('sys.symbol.magnifyingglass'), iconSize: 20, iconColor: $r('app.color.fg') })
          .onClick(() => {
            this.commit(this.inputText)
          })
      }
      .width('100%')
      .height(48)
      .padding({ left: 16, right: 16 })
      .alignItems(VerticalAlign.Center)

      Scroll() {
        Column() {
          ForEach(this.rows, (row: SuggestRow, index: number) => {
            this.EntryRow(row, () => {
              this.commitRow(row)
            })
          }, (row: SuggestRow, index: number) => `${row.type}_${row.text}_${index}`)
          // 原版 ka/g.l：搜索历史(bit32)仅在空输入且有历史时展示
          if (this.inputText.trim() === '' && (this.settings.searchSuggestion & 32) !== 0
            && this.settings.searchHistory.length > 0) {
            Row() {
              Text($r('app.string.search_history'))
                .fontSize(13)
                .fontColor($r('app.color.fg_secondary'))
              Blank()
              Text($r('app.string.clear_search_history'))
                .fontSize(13)
                .fontColor($r('app.color.fg_secondary'))
                .onClick(() => {
                  this.settings.clearSearchHistory()
                })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 14, bottom: 6 })

            ForEach(this.settings.searchHistory, (query: string, index: number) => {
              if (index < SUGGEST_LIMIT) {
                this.EntryRow(new SuggestRow(0, query), () => {
                  this.commit(query)
                })
              }
            }, (query: string, index: number) => `${query}_${index}`)
          }
        }
        .width('100%')
      }
      .constraintSize({ maxHeight: '55%' })
      .align(Alignment.Top)
    }
    .width('92%')
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(12)
    .clip(true)
    .shadow({ radius: 24, color: 'rgba(0,0,0,0.35)', offsetY: 4 })
    .transition(dialogTransition())
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

  // 原版 O3：引擎单选菜单
  @Builder
  EngineMenu() {
    Column() {
      ForEach(this.builtinEngines(), (engine: SearchEngineDef) => {
        Text(engine.name)
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .padding({ left: 16, right: 24, top: 10, bottom: 10 })
          .width('100%')
          .onClick(() => {
            this.settings.setEngineKey(engine.key)
            this.fetchSuggestions(this.inputText)
          })
      }, (engine: SearchEngineDef) => engine.key)
      ForEach(this.settings.customEngines, (rec: CustomEngineRec, index: number) => {
        Text(rec.name)
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .padding({ left: 16, right: 24, top: 10, bottom: 10 })
          .width('100%')
          .onClick(() => {
            this.settings.setEngineKey(`custom:${rec.id}`)
            this.fetchSuggestions(this.inputText)
          })
      }, (rec: CustomEngineRec, index: number) => `${rec.name}_${index}`)
    }
    .width(140)
  }

  @Builder
  EntryRow(row: SuggestRow, action: () => void) {
    Row({ space: 12 }) {
      if (row.type === 1) {
        AppIcon({ icon: $r('sys.symbol.link'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
      } else if (row.type === 2) {
        AppIcon({ icon: $r('sys.symbol.plus'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
      } else if (row.type === 3) {
        AppIcon({ icon: $r('sys.symbol.clock'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
      } else if (row.type === 4) {
        AppIcon({ icon: $r('sys.symbol.doc_plaintext'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
      } else {
        AppIcon({ icon: $r('sys.symbol.magnifyingglass'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
      }
      Column({ space: 2 }) {
        Text(row.text)
          .fontSize(15)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
        if (row.sub !== '') {
          Text(row.sub)
            .fontSize(12)
            .fontColor($r('app.color.fg_secondary'))
            .maxLines(1)
            .textOverflow({ overflow: TextOverflow.Ellipsis })
        }
      }
      .alignItems(HorizontalAlign.Start)
      .layoutWeight(1)
    }
    .width('100%')
    .height(row.sub !== '' ? 56 : 46)
    .padding({ left: 16, right: 16 })
    .onClick(() => {
      action()
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

  private startScan(): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    scanBarcode.startScanForResult(context).then((data: scanBarcode.ScanResult) => {
      const scanned = data.originalValue.trim()
      if (scanned !== '') {
        this.commit(scanned)
      }
    }).catch((error: BusinessError) => {
      console.error(`scan failed: ${error.code}`)
    })
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
