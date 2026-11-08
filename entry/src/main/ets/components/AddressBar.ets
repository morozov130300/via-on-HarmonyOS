import { TabItem } from '../common/Types'
import { pasteboard, emitter } from '@kit.BasicServicesKit'
import { AppSettings } from '../common/Settings'
import { TabStore } from '../common/TabStore'
import { ViaIcon } from './ViaIcon'
import { hostOf, getBuiltinEngines, isUrlLike } from '../common/SearchEngines'
import { ConfigurationConstant, common } from '@kit.AbilityKit'
import { i18n } from '@kit.LocalizationKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { computeDialogWidthVp } from './ViaDialogCard'
import { BEZIER_0202_CURVE, dialogTransition } from '../common/Transitions'

const BAR_HEIGHT: number = 48
// 原版图标 PNG 为 88px(@4x) = 22dp
const ICON_SIZE: number = 22
// 原版 n0.j()：按钮左右 margin 13dp（dimens bh=13dp）
const ICON_MARGIN: number = 13
// 原版 n0.j()：图标视图宽 48dp（dimens bi=48dp）
const ICON_SLOT: number = 48

// 原版 i6/g0.a（i6/g0.java:13-27）定界符配对表：
// ''""{}()[]<>「」『』【】〔〕〖〗〘〙〚〛（）［］｛｝＜＞〈〉《》‘’“”
// 偶数位=起始定界符，其后一位=对应闭合符；非起始定界符（含未命中）按空格处理
const URL_DELIMITER_PAIRS: string =
  "''\"\"{}()[]<>「」『』【】〔〕〖〗〘〙〚〛（）［］｛｝＜＞〈〉《》‘’“”"

// 原版 i6/g0.a：按起始定界符取配对闭合符（非起始符/未命中 → 空格）
function urlCloserOf(openChar: string): string {
  const i = URL_DELIMITER_PAIRS.indexOf(openChar)
  if (i < 0 || i % 2 !== 0) {
    return ' '
  }
  return URL_DELIMITER_PAIRS.charAt(i + 1)
}

// 原版 i6/f.e（i6/f.java:92-94）：' '/换行/制表/不间断空格/Character.isWhitespace|isSpaceChar
function isUrlBlankChar(ch: string): boolean {
  return ch === ' ' || ch === '\n' || ch === '\t' || ch === '\u00a0' || /\s/.test(ch)
}

// 原版标题长按菜单项（k6.h.onLongClick：复制/粘贴/粘贴并前往）
class TitleMenuItem {
  label: ResourceStr = ''
  action: () => void = () => {}

  constructor(label: ResourceStr, action: () => void) {
    this.label = label
    this.action = action
  }
}

// 原版左图标长按搜索引擎对话框条目（k6.h：z8/v2.e 引擎表 + sp=搜索引擎 单选）
class EngineItem {
  key: string = ''
  name: string = ''

  constructor(key: string, name: string) {
    this.key = key
    this.name = name
  }
}

@ComponentV2
export struct AddressBar {
  @Param @Require tab: TabItem
  // 原版 Tb()：布局 0/1/2 透明底，布局 3 圆角胶囊底
  @Param style: string = 'plain'
  @Event onAddressTap: () => void = () => {}
  @Event onOpenMedia: (urls: string[]) => void = (urls: string[]) => {
  }
  @Event onSiteInfo: () => void = () => {}
  @Event onScan: () => void = () => {}
  // 原版 k6.f：阅读图标显示期点击左图标 → B8() 进阅读
  @Event onReader: () => void = () => {}
  // 原版 k6.d9()（6945-6953）：点击地址栏左图标前，若当前有面板/内部页面栈非空，
  // 先弹栈关面板（pb() + h9()）并**拦截**本次点击，不再执行网站信息/阅读模式。
  // 返回 true = 已消费（已关面板），调用方不再继续。
  // 由 Index 注入（Index 侧持有菜单/搜索/标签面板状态）；未注入时恒 false（行为回落旧逻辑）。
  @Event onTryClosePanels: () => boolean = (): boolean => false
  private settings: AppSettings = AppSettings.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  @Local showTitleMenu: boolean = false
  private readerHintVisible: boolean = false
  // 原版 k6.h 左图标长按：w5.k 单选弹窗（一次一个）
  private engineDialogId: number = -1
  @Local pulseScale: number = 1
  // 原版 n0.v(true)：阅读图标 3s 显示窗口（postDelayed 3000 → v(false) 复位）
  @Local readerHint: boolean = false
  private readerHintTimer: number = -1
  private pulseEventId: number = 30001

  aboutToAppear(): void {
    // 原版 mark/via/common/widget/n0.java:208-222 q()：
    //   ValueAnimator.ofFloat(1.0f, 1.15f, 1.0f)；setInterpolator(x8.h.b()) 即
    //   PathInterpolator(0.2,0.2,0.8,0.8)；setDuration(1200L)；作用属性 = 左图标 scaleX/scaleY；
    //   addListener 的 onAnimationCancel 把 scale 复位为 1.0。
    // 单条 1200ms 三关键帧动画（关键帧 0 / 0.5 / 1），鸿蒙用 keyframeAnimateTo 一条时间轴承载
    // 两段 600ms，替代原分段 animateTo + setTimeout 拼接（后者相位与曲线都会断）。
    emitter.on({ eventId: this.pulseEventId }, () => {
      const frames: KeyframeState[] = [
        {
          duration: 600,
          curve: BEZIER_0202_CURVE,
          event: (): void => {
            this.pulseScale = 1.15
          }
        },
        {
          duration: 600,
          curve: BEZIER_0202_CURVE,
          event: (): void => {
            this.pulseScale = 1
          }
        }
      ]
      this.getUIContext().keyframeAnimateTo({ delay: 0, iterations: 1 }, frames)
      if (this.readerHintTimer >= 0) {
        clearTimeout(this.readerHintTimer)
      }
      this.readerHint = true
      this.readerHintTimer = setTimeout(() => {
        this.readerHint = false
        this.readerHintTimer = -1
      }, 3000)
    })
  }

  aboutToDisappear(): void {
    emitter.off(this.pulseEventId)
    if (this.readerHintTimer >= 0) {
      clearTimeout(this.readerHintTimer)
      this.readerHintTimer = -1
    }
  }

  // 原版 x8.h.s()：标题字号基数 16sp（dimens a8）跟随「字体大小」设置
  private titleFontSize(): number {
    return 16 * this.settings.textZoom / 100
  }

  // 原版 k6.F()：mode 1 网址仅截断 8192；网络 URL 去 scheme 且仅当尾字符为 '/' 去掉尾斜杠
  private formattedUrl(): string {
    let str = this.tab.url.length > 8192 ? this.tab.url.substring(0, 8192) : this.tab.url
    if (str.startsWith('http://') || str.startsWith('https://')) {
      const schemeIndex = str.indexOf('://')
      str = str.substring(schemeIndex + 3)
      if (str.length > 0 && str.charAt(str.length - 1) === '/') {
        str = str.substring(0, str.length - 1)
      }
    }
    return str
  }

  private titleText(): ResourceStr {
    // 原版 k6.t()：主页时无条件显示页面标题「主页」，不受地址栏内容设置影响
    if (this.tab.isHomePage()) {
      return $r('app.string.home_page')
    }
    const mode = this.settings.addressBarContent
    if (mode === 1) {
      // 原版 F() mode 1：显示格式化网址
      return this.formattedUrl()
    }
    if (mode === 2) {
      // 原版 F() mode 2：显示域名（i0.f，不做 scheme 剥离）
      return hostOf(this.tab.url)
    }
    if (this.tab.title !== '') {
      return this.tab.title
    }
    // 原版 P7()：标题为空回退「无标题」（k6.Z0(x7.u.bh)）
    return $r('app.string.no_title')
  }

  // 原版 n0.setSecureCnnection()：隐身+https 用隐身锁，https 用锁，非 https 左图标 f12905j1（desc 网站信息）
  private siteIcon(): Resource {
    if (this.tab.incognito && this.tab.url.startsWith('https://')) {
      return $r('app.media.via_ic_incognito_lock')
    }
    if (this.tab.url.startsWith('https://')) {
      return $r('app.media.via_ic_lock')
    }
    return $r('app.media.via_ic_site_info')
  }

  // 原版 n0.v()/t(Lc)：阅读提示期左图标换成阅读图标（V0=d2），desc tx=打开阅读模式
  private leftIcon(): Resource {
    if (this.readerHint) {
      return $r('app.media.via_ic_reader')
    }
    return this.siteIcon()
  }

  // 原版 n0.s()：加载中→停止，主页→扫码，其余→刷新
  private actionIcon(): Resource {
    if (this.tab.loading) {
      return $r('app.media.via_ic_stop')
    }
    if (this.tab.isHomePage()) {
      return $r('app.media.via_ic_addr_scan')
    }
    return $r('app.media.via_ic_refresh')
  }

  private onAction(): void {
    if (this.tab.loading) {
      try {
        this.tab.controller.stop()
      } catch (error) {
        console.error('stop loading failed')
      }
      return
    }
    if (this.tab.isHomePage()) {
      this.onScan()
      return
    }
    try {
      this.tab.controller.refresh()
    } catch (error) {
      console.error('refresh failed')
    }
  }

  // 原版 k6.Tb(layout)：布局 0 透明；1/2/3 用 LayerDrawable
  // 夜间 0x22FFFFFF / 浅色 0x10000000，圆角 dimens ae = 18dp
  private pillBackground(): ResourceColor {
    if (this.style === 'plain') {
      return Color.Transparent
    }
    if (this.isDarkMode()) {
      return '#22FFFFFF'
    }
    return '#10000000'
  }

  // 原版 Tb()：非 0 布局 setLayerInset(0, 4dp, 4dp, 4dp, 4dp) → 视觉高 48-8=40dp
  private barHeight(): number {
    return this.style === 'plain' ? BAR_HEIGHT : BAR_HEIGHT - 8
  }

  // 原版布局 3 额外 paddingLeft/Right 16dp（背景与其同心）；1/2 仅 4dp 内缩
  private barMargin(): Margin {
    if (this.style === 'pill') {
      return { left: 16, right: 16, top: 4, bottom: 4 }
    }
    if (this.style === 'card') {
      return { left: 4, right: 4, top: 4, bottom: 4 }
    }
    return { left: 0, right: 0, top: 0, bottom: 0 }
  }

  private isDarkMode(): boolean {
    try {
      const ctx = this.getUIContext().getHostContext() as common.UIAbilityContext
      return ctx.config.colorMode === ConfigurationConstant.ColorMode.COLOR_MODE_DARK
    } catch (error) {
      return false
    }
  }

  // 原版左图标长按对话框条目（k6.h：z8/v2.e(Context) 引擎名数组，含自定义引擎）
  private engineItems(): EngineItem[] {
    let lang = 'zh'
    try {
      lang = i18n.System.getSystemLanguage()
    } catch (error) {
      lang = 'zh'
    }
    const isZh = lang.startsWith('zh')
    const isRu = lang.startsWith('ru')
    const items: EngineItem[] = []
    const builtins = getBuiltinEngines(isZh, isRu)
    for (const engine of builtins) {
      items.push(new EngineItem(engine.key, engine.name))
    }
    for (let i = 0; i < this.settings.customEngines.length; i++) {
      const rec = this.settings.customEngines[i]
      items.push(new EngineItem(`custom:${rec.id}`, rec.name))
    }
    return items
  }

  // 原版标题长按菜单（k6.h.onLongClick，k6.java:855-873）：首项「复制」（R.string.copy，
  // 仅 URL 非内部页）/「粘贴」（h.a → oa）/「粘贴并前往」（→ sa() 剪贴板多 URL 流程）
  private titleMenuItems(): TitleMenuItem[] {
    const items: TitleMenuItem[] = []
    if (this.tab.url !== '' && !this.tab.isHomePage()) {
      items.push(new TitleMenuItem($r('app.string.copy'), (): void => {
        const data = pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, this.tab.url)
        pasteboard.getSystemPasteboard().setData(data).then(() => {
          // 原版 g6.n.a(context, url, x7.u.pg)：复制后弹「已复制链接」
          this.getUIContext().getPromptAction().showToast({ message: $r('app.string.copied_link') })
        }).catch(() => {})
      }))
    }
    // 原版 h.a → oa(粘贴文本)：把剪贴板文本放入地址输入框
    items.push(new TitleMenuItem($r('app.string.paste'), (): void => {
      pasteboard.getSystemPasteboard().getData().then((data: pasteboard.PasteData) => {
        const text = data.getPrimaryText().trim()
        if (text !== '') {
          AppStorage.setOrCreate('via_paste_url', text)
          this.onAddressTap()
        }
      }).catch(() => {})
    }))
    // 原版粘贴并前往 → k6.sa()（k6.java:8423）：剪贴板含多个 URL 时弹选择弹窗
    items.push(new TitleMenuItem($r('app.string.paste_and_go'), (): void => {
      this.pasteAndGo()
    }))
    return items
  }

  // 原版 k6.sa（k6.java:8423）：剪贴板文本提取 URL（i6/g0.e）；
  // 多个 URL → 弹选择弹窗（标题 g6「提示」/正文=剪贴板文本/逐条列出），
  // 点击一条 = 新标签打开（na.i1(url,true)）、末项「打开全部」= 逐个新标签打开
  // （k6.T5：最后一个前台）；单个/无 URL → 当前往（Ra）
  private pasteAndGo(): void {
    pasteboard.getSystemPasteboard().getData().then((data: pasteboard.PasteData) => {
      const text = data.getPrimaryText().trim()
      if (text === '') {
        return
      }
      const urls = this.extractUrls(text)
      if (urls.length > 1) {
        this.showMultiUrlDialog(text, urls)
        return
      }
      this.tabStore.navigate(urls.length === 1 ? urls[0] : text)
    }).catch(() => {})
  }

  // 原版 i6/g0.e（i6/g0.java:75-120）1:1 移植：
  //   1) text 去首尾空白（v7.m.I）；长度 < 8 直接返回空
  //   2) 循环以 "://" 为锚点：向前取 5 字符窗口（"https"）或 4 字符窗口（"http"），
  //      命中即得起点 start = w - 窗口长；未命中则 i = w + 3 继续找下一个 "://"
  //   3) 段尾：从 w+3 起用 g0.a(str, 起点前一个字符, w+3) 扫描，遇「配对闭合符」或空白即止；
  //      无结果时：start==0 → 整段放弃；否则取到串尾
  //   4) 候选 substring(start, end) 经 i0.t（h0 解析器 s()：URL 合法性）校验后入表；
  //      i = end + 1 继续
  // 注：原版只认完整 "http"/"https" 窗口，剪贴板里脱离 scheme 的 "ttp://x" 不会被补全。
  private extractUrls(text: string): string[] {
    const urls: string[] = []
    if (text.length < 8) {
      return urls
    }
    const s = text.trim()
    let i = 0
    while (i < s.length) {
      const w = s.indexOf('://', i)
      if (w < 0) {
        break
      }
      // 原版 g0.e:85-99：先取 :// 前 5 字符窗口忽略大小写比 "https"，
      // 否则取前 4 字符窗口比 "http"；两者都不中则只把游标推到 iW+3 继续找下一个 "://"
      // （实测原版**不**识别裸 "ttp://"、"ttps://"，只有完整 http(s) 才成立）
      let start = -1
      if (w >= 5 && s.substring(w - 5, w).toLowerCase() === 'https') {
        start = w - 5
      } else if (w >= 4 && s.substring(w - 4, w).toLowerCase() === 'http') {
        start = w - 4
      } else {
        i = w + 3
        continue
      }
      // 原版 g0.a(str, 前一个字符, iW+3)：按起点前一个字符决定配对闭合符，
      // 遇配对闭合符或空白即止；找不到（-1）时 start==0 放弃整段，否则取到串尾
      const closer = urlCloserOf(start > 0 ? s.charAt(start - 1) : ' ')
      let end = w + 3
      while (end < s.length) {
        const ch = s.charAt(end)
        if (ch === closer || isUrlBlankChar(ch)) {
          break
        }
        end++
      }
      let stop = end
      if (stop >= s.length) {
        if (start === 0) {
          return urls
        }
        stop = s.length
      }
      // 原版 substring(start, end)，仅当 end > iW+3（段非空）且 i0.t 校验通过才收集
      if (stop > w + 3) {
        const url = s.substring(start, stop)
        if (isUrlLike(url) && urls.indexOf(url) < 0) {
          urls.push(url)
        }
      }
      i = stop + 1
    }
    return urls
  }

  private showMultiUrlDialog(text: string, urls: string[]): void {
    const sheets: SheetInfo[] = []
    for (let i = 0; i < urls.length; i++) {
      const url = urls[i]
      sheets.push({
        title: url,
        action: (): void => {
          // 原版 k6.sa()（8423-8446）：多 URL 弹窗点单条 → na.i1(url, true)
          // （c8/na.java:1538-1540，第 2 参 true = **后台**打开该标签，
          // 让用户继续在弹窗里挑下一个；早期实现误传 false 走前台。）
          this.tabStore.newTabAt(url, true)
        }
      })
    }
    // 原版确定钮 oy「打开全部」（k6.T5）：逐个新标签打开，最后一个前台
    sheets.push({
      title: '打开全部',
      action: (): void => {
        for (let i = 0; i < urls.length; i++) {
          this.tabStore.newTabAt(urls[i], i < urls.length - 1)
        }
      }
    })
    ActionSheet.show({
      title: '提示',
      message: text,
      sheets: sheets
    })
  }

  // 原版 k6.h：左图标长按 → w5.k.l(I()).d0(sp=搜索引擎).b0(引擎名数组, 当前项, 选中回调).f0()
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

  build() {
    Row() {
      Stack() {
        ViaIcon({ icon: this.leftIcon(), iconSize: ICON_SIZE, iconColor: $r('app.color.icon') })
          .scale({ x: this.pulseScale, y: this.pulseScale })
          .accessibilityText(this.readerHint
            ? $r('app.string.open_reader_mode') : $r('app.string.site_info'))
      }
      .width(ICON_SLOT)
      .height('100%')
      .alignContent(Alignment.Center)
      .margin({ left: ICON_MARGIN })
      .onClick(() => {
        // 原版 c8/k6.java f.a()（676-690）：id == n0.f9702v（左图标）时
        //   1) if (d9()) return;   —— 面板/Fragment 栈非空则弹栈关闭并**拦截**点击
        //      d9()（6945-6953）：z0().u0() > 0 → pb()（关面板）+ h9() + z0().e1()，返回 true
        //   2) 否则才走 f2602x0.o()/n0.v() 判定 → Bb()（网站信息）/ B8()（阅读模式）
        if (this.onTryClosePanels()) {
          return
        }
        if (!this.readerHint || this.tab.isHomePage()) {
          this.onSiteInfo()
        } else {
          this.onReader()
        }
      })
      // 原版 k6.h：左图标长按 → 搜索引擎单选对话框（sp=搜索引擎，选中写 searchengine）
      .gesture(LongPressGesture({ repeat: false, duration: 400 }).onAction(() => {
        this.openEngineDialog()
      }))

      Text(this.titleText())
        .fontSize(this.titleFontSize())
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        // 原版 n0.p()：setEllipsize(null) + setSingleLine(true) → 不显示省略号，超出裁切
        .textOverflow({ overflow: TextOverflow.Clip })
        // 原版 n0.d()：setGravity(16) 仅垂直居中，水平方向靠左
        .textAlign(TextAlign.Start)
        .layoutWeight(1)
        // 原版 z5.a 弹窗：k6.h 标题长按 → 复制/粘贴/粘贴并前往 横排 pill 弹窗
        // 动画依据：z5/a.java:142 b() → new Dialog(context, v.f14256c)，
        //   x7.v.f14256c = 0x7f11000f = style "n"，其 windowAnimationStyle=@style/k →
        //   enter=@anim/a、exit=@anim/b（240ms：alpha 线性、translateY +10% 与 scale
        //   0.9→1 用 bounce，pivot 50%/100%）。故转场必须用 dialogTransition()。
        .bindPopup(this.showTitleMenu, {
          builder: this.TitleMenu(),
          placement: Placement.Bottom,
          popupColor: Color.Transparent,
          enableArrow: false,
          autoCancel: true,
          transition: dialogTransition(),
          onStateChange: (e: PopupStateChangeParam) => {
            if (!e.isVisible) {
              this.showTitleMenu = false
            }
          }
        })
        // 原版标题长按 → 复制/粘贴/粘贴并前往（k6.h.onLongClick）
        .gesture(LongPressGesture({ repeat: false, duration: 400 }).onAction(() => {
          this.showTitleMenu = true
        }))

      // 原版 n0.m()：资源嗅探图标 f9707j 位于标题与右图标之间；t() 渐隐渐显
      // （mark/via/common/widget/n0.java:292-311 t(boolean,boolean)：
      //   隐藏 → translationX 0→图标宽、alpha 1→0、150ms、e(x8.h.b())；
      //   显示 → translationX 图标宽→0、alpha 0→1、150ms、e(x8.h.b())；
      //   图标宽 = LinearLayout.LayoutParams(g6.f.d(ctx, x7.n.E))，E=0x7f070052=dimen bi=48dp）
      if (this.tab.sniffedMedia.length > 0) {
        Stack() {
          ViaIcon({ icon: $r('app.media.via_ic_resource'), iconSize: ICON_SIZE, iconColor: $r('app.color.icon') })
        }
        .width(ICON_SLOT)
        .height('100%')
        .alignContent(Alignment.Center)
        .accessibilityText($r('app.string.res_sniffer'))
        .transition(TransitionEffect.OPACITY.animation({ duration: 150, curve: BEZIER_0202_CURVE })
          .combine(TransitionEffect.translate({ x: ICON_SLOT })
            .animation({ duration: 150, curve: BEZIER_0202_CURVE })))
        .onClick(() => {
          // 原版 k6.f：f9703w 点击 → u1() 打开资源嗅探面板
          this.onOpenMedia(this.tab.sniffedMedia)
        })
      }

      Stack() {
        ViaIcon({ icon: this.actionIcon(), iconSize: ICON_SIZE, iconColor: $r('app.color.icon') })
      }
      .width(ICON_SLOT)
      .height('100%')
      .alignContent(Alignment.Center)
      .margin({ right: ICON_MARGIN })
      .onClick(() => {
        this.onAction()
      })
    }
    .width('100%')
    .height(this.barHeight())
    .backgroundColor(this.pillBackground())
    .borderRadius(this.style === 'plain' ? 0 : 18)
    .margin(this.barMargin())
    .onClick(() => {
      this.onAddressTap()
    })
  }

  // 原版 z5.a 弹窗：横向 LinearLayout（orientation 0）+ 每项 48dp 高、padH16、
  // 14sp（style a6）、居中、容器 padH18（dimen ae）、底 menu_bg 圆角 18dp（drawable t）、遮罩 0.4
  @Builder
  TitleMenu() {
    Row() {
      ForEach(this.titleMenuItems(), (item: TitleMenuItem) => {
        Text(item.label)
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .height(48)
          .padding({ left: 16, right: 16 })
          .textAlign(TextAlign.Center)
          .maxLines(1)
          .onClick(() => {
            this.showTitleMenu = false
            item.action()
          })
      }, (item: TitleMenuItem, index: number) => `${index}`)
    }
    .padding({ left: 18, right: 18 })
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(18)
  }

  // 原版左图标长按：w5.k.l(I()).d0(搜索引擎) 单选列表弹窗（layout v.xml：16dp 圆形单选 + 24dp 间距）
  @Builder
  EngineDialog() {
    Column() {
      Text($r('app.string.search_engine'))
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Scroll() {
        Column() {
          ForEach(this.engineItems(), (item: EngineItem) => {
            Row({ space: 24 }) {
              Circle({ width: 16, height: 16 })
                .fill(this.settings.engineKey === item.key ? $r('app.color.accent') : Color.Transparent)
                .stroke(this.settings.engineKey === item.key ? Color.Transparent : $r('app.color.dialog_border'))
                .strokeWidth(2)
              Text(item.name)
                .fontSize(14)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
                .layoutWeight(1)
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 12, bottom: 12 })
            .onClick(() => {
              // 原版选中 → q3("searchengine", 引擎)
              this.settings.setEngineKey(item.key)
              this.closeEngineDialog()
            })
          }, (item: EngineItem) => item.key)
        }
        .width('100%')
      }
      .constraintSize({ maxHeight: 384 })
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }
}
