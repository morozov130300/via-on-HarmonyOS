import { TabItem } from '../common/Types'
import { TabStore } from '../common/TabStore'
import { AppSettings } from '../common/Settings'
import {
  SearchEngineDef, getBuiltinEngines, applyTemplate, matchSearchWord, isUrlLike
} from '../common/SearchEngines'
import { pasteboard } from '@kit.BasicServicesKit'
import { i18n } from '@kit.LocalizationKit'
import { ACCELERATE_DECELERATE_CURVE } from '../common/Transitions'

// 原版 mark/via/common/widget/m（k6.n9 构建传入 n9、k4 主题着色、k6.b 点击回调）：
// 地址栏下方搜索工具栏，高 40dp 的横向列表；chips 与尾部「+」钮同列表滚动（m.h 把 footer
// append 进 RecyclerView 列表）。ItemDecoration x(6dp,4dp)：所有 item 上下 6dp、左右 4dp，
// List 水平 padding 12dp（clipToPadding=false）→ 首内容距边 16dp、间隔 8dp。
// chip（m.a/l）：高 28dp、圆角 18dp（dimen ae）、描边 1dp（默认 #30808080、选中 accent、
// 按压透明+填充 #30808080）、文字 12sp（dimen aa）、单行省略 maxWidth 96dp、水平 padding 12dp、
// 无字重强调；文字色亮 #232323/color t、夜 #9F9F9F/color u（k4 传 m.l），选中 accent。
// footer（m.b/h）：48dp 宽、图标 di（24dp、tint 亮 #DE000000/a1 夜 #BEFFFFFF/a2）、
// 背景 ripple r/m/o.xml（mask 圆角 18dp、#30808080、300ms 淡出）、内容描述「搜索设置」(t4)，
// 点击打开搜索设置页 hb.b6。
// 选中态（m.n/j）：在可见引擎列表上用 g0.g(url, 模板) 取首个非空词命中者，切换 URL 时滚动到选中项。
// 点击（m.c + k6.b.a）：已选中不响应；用 m.i 取当前页搜索词，g0.h(目标模板, 词) 重建 URL；
// i0.t 校验失败弹「无效链接」(ln) 对话框（内容为新 URL，复制/取消）；合法则加载。
// 显隐（k6.Rb + m.n + u9.d.m）：设置开启 && 非无痕 && 非主页等内部页 && 有命中引擎。
// 跳过项（工程无对应子系统）：k6.b.a 的回退栈复用（d().A()/r()）、t8.f 统计、m0 输入历史、
// d1 桌面模式分支（一律移动模板）。
@ComponentV2
export struct SearchToolbar {
  @Param tab: TabItem = new TabItem(0, false)
  @Event onOpenSettings: () => void = () => {}
  // chip 按压态（StateListDrawable pressed 项：填充 #30808080、描边透明，覆盖选中描边）
  @Local pressedKey: string = ''
  // footer 按压态（ripple：按压 #30808080，松手 300ms 淡出）
  @Local footerPressed: boolean = false

  private settings: AppSettings = AppSettings.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  private scroller: Scroller = new Scroller()

  private allEngines(): SearchEngineDef[] {
    const locale = i18n.System.getSystemLanguage()
    const engines = getBuiltinEngines(locale.startsWith('zh'), locale.startsWith('ru'))
    const all: SearchEngineDef[] = []
    for (let i = 0; i < engines.length; i++) {
      all.push(engines[i])
    }
    for (let i = 0; i < this.settings.customEngines.length; i++) {
      const entry = this.settings.customEngines[i]
      all.push(new SearchEngineDef(`custom:${entry.id}`, entry.name, entry.template, entry.id))
    }
    return all
  }

  // 原版 ib.q：searchToolbarOrder（int id 逗号串）登记过的按登记序，未登记的按原相对序排后
  private enginesInOrder(): SearchEngineDef[] {
    const all = this.allEngines()
    const order = this.settings.searchToolbarOrder
    const rank = (engine: SearchEngineDef): number => {
      const idx = order.indexOf(String(engine.id))
      return idx >= 0 ? idx : Number.MAX_SAFE_INTEGER
    }
    all.sort((a: SearchEngineDef, b: SearchEngineDef): number => rank(a) - rank(b))
    return all
  }

  // 原版 k6.J3：禁用表(searchToolbarDisabled，int id 逗号串)内引擎不显示，但当前搜索引擎(M1)始终保留
  @Computed
  get visibleEngines(): SearchEngineDef[] {
    const disabled = this.settings.searchToolbarDisabled.split(',')
    const defKey = this.settings.engineKey
    const result: SearchEngineDef[] = []
    const ordered = this.enginesInOrder()
    for (let i = 0; i < ordered.length; i++) {
      const engine = ordered[i]
      if (engine.key === defKey || disabled.indexOf(String(engine.id)) < 0) {
        result.push(engine)
      }
    }
    return result
  }

  // 原版 m.j：遍历可见引擎 g0.g(url, 模板)，取首个非空词命中的下标；无命中返回 -1
  @Computed
  get matchIdx(): number {
    const url = this.tab.url
    if (url === '' || url === 'about:blank') {
      return -1
    }
    const engines = this.visibleEngines
    for (let i = 0; i < engines.length; i++) {
      const word = matchSearchWord(url, engines[i].template)
      if (word !== null && word !== '') {
        return i
      }
    }
    return -1
  }

  // 原版 m.i / k6.b.a：当前页命中的引擎搜索词（用于在其他引擎上重建搜索）
  @Computed
  get matchWord(): string {
    const url = this.tab.url
    if (url === '' || url === 'about:blank') {
      return ''
    }
    const engines = this.visibleEngines
    for (let i = 0; i < engines.length; i++) {
      const word = matchSearchWord(url, engines[i].template)
      if (word !== null && word !== '') {
        return word
      }
    }
    return ''
  }

  // 原版 k6.Rb + m.n + u9.d.m：设置开启 && 非无痕 && 非主页 && 有命中引擎
  @Computed
  get visibleToolbar(): boolean {
    return this.settings.searchToolbarEnabled && !this.tab.incognito &&
      !this.tab.isHomePage() && this.matchIdx >= 0
  }

  // URL 变化时滚动到选中引擎（原版 m.n 中 x1(selected)）
  @Monitor('tab.url')
  onTabUrlChange(): void {
    this.scrollToSelected()
  }

  aboutToAppear(): void {
    this.scrollToSelected()
  }

  private scrollToSelected(): void {
    if (this.matchIdx >= 0) {
      this.scroller.scrollToIndex(this.matchIdx, false, ScrollAlign.CENTER)
    }
  }

  build() {
    if (this.visibleToolbar) {
      List({ scroller: this.scroller }) {
        ForEach(this.visibleEngines, (engine: SearchEngineDef, index: number) => {
          ListItem() {
            Text(engine.name)
              .fontSize(12)
              .fontColor(index === this.matchIdx ? $r('app.color.accent') : $r('app.color.search_toolbar_text'))
              .maxLines(1)
              .textOverflow({ overflow: TextOverflow.Ellipsis })
              .constraintSize({ maxWidth: 96 })
              .textAlign(TextAlign.Center)
              .height(28)
              .padding({ left: 12, right: 12 })
              .borderRadius(18)
              .border({
                width: 1,
                color: this.pressedKey === engine.key ? Color.Transparent :
                  (index === this.matchIdx ? $r('app.color.accent') : '#30808080')
              })
              .backgroundColor(this.pressedKey === engine.key ? '#30808080' : Color.Transparent)
              .margin({ left: 4, right: 4, top: 6, bottom: 6 })
              .onClick(() => {
                this.selectEngine(index)
              })
              .onTouch((event: TouchEvent) => {
                if (event.type === TouchType.Down) {
                  this.pressedKey = engine.key
                } else if (event.type === TouchType.Up || event.type === TouchType.Cancel) {
                  this.pressedKey = ''
                }
              })
          }
        }, (engine: SearchEngineDef) => engine.key)

        // 原版 m.h + k6.b.b：尾部「+」钮（图标 di、48dp 宽、按压 #30808080 圆角 18dp 300ms 淡出）
        ListItem() {
          Row() {
            Image($r('app.media.uia_search_toolbar_add'))
              .width(24)
              .height(24)
              .fillColor($r('app.color.search_toolbar_icon_tint'))
          }
          .width(48)
          .height(28)
          .justifyContent(FlexAlign.Center)
          .borderRadius(18)
          .backgroundColor(this.footerPressed ? '#30808080' : Color.Transparent)
          .margin({ left: 4, right: 4, top: 6, bottom: 6 })
          .onClick(() => {
            this.onOpenSettings()
          })
          .onTouch((event: TouchEvent) => {
            if (event.type === TouchType.Down) {
              this.footerPressed = true
            } else if (event.type === TouchType.Up || event.type === TouchType.Cancel) {
              // 原版 ripple r/m/o.xml：exitFadeDuration=300ms。
              // framework RippleForeground 的退出淡出用 ObjectAnimator 未 setInterpolator
              // → 默认 AccelerateDecelerateInterpolator，故显式补 curve。
              this.getUIContext().animateTo({ duration: 300, curve: ACCELERATE_DECELERATE_CURVE }, (): void => {
                this.footerPressed = false
              })
            }
          })
        }
      }
      .listDirection(Axis.Horizontal)
      .scrollBar(BarState.Off)
      .edgeEffect(EdgeEffect.None)
      .width('100%')
      .height(40)
      .padding({ left: 12, right: 12 })
    }
  }

  // 原版 m.c + k6.b.a：已选中引擎不响应；用当前页搜索词在目标引擎上重建 URL 加载；
  // g0.h 结果为空或 i0.t 校验失败不加载，校验失败弹「无效链接」对话框
  private selectEngine(index: number): void {
    if (index === this.matchIdx) {
      return
    }
    const word = this.matchWord
    if (word === '') {
      return
    }
    const target = applyTemplate(this.visibleEngines[index].template, word)
    if (target === '') {
      return
    }
    if (!isUrlLike(target)) {
      this.showInvalidUrl(target)
      return
    }
    this.tabStore.navigate(target)
  }

  // 原版 k6.b.a L459-467：标题「无效链接」(ln)、内容新 URL、复制(R.string.copy)/取消
  private showInvalidUrl(url: string): void {
    this.getUIContext().showAlertDialog({
      title: $r('app.string.invalid_url'),
      message: url,
      primaryButton: {
        value: $r('app.string.cancel'),
        action: (): void => {}
      },
      secondaryButton: {
        value: $r('app.string.copy'),
        action: (): void => {
          const data = pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, url)
          pasteboard.getSystemPasteboard().setData(data).catch(() => {})
        }
      }
    })
  }
}
