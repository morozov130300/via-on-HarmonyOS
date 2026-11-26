import { TabItem } from '../common/Types'
import { TabStore } from '../common/TabStore'
import { AppSettings } from '../common/Settings'
import { AddressBar } from './AddressBar'
import { ViaIcon } from './ViaIcon'
import { common } from '@kit.AbilityKit'
import { emitter } from '@kit.BasicServicesKit'
import { normalizeThemeColor, toolbarBackgroundColor, resolveColorHex } from '../common/ChromeColors'
import { BEZIER_0202_CURVE } from '../common/Transitions'

// 原版 g0.j() 的触发事件：k6.A8()（进隐身）与 k6.b0()（标签事件且标签数>1）两处。
// 退出隐身 l8() 原版不调用，禁止在此路径触发。
export const TAB_BOUNCE_EVENT_ID: number = 30002

// re-export 保持 Index 等既有 import 路径不变
export { toolbarBackgroundColor } from '../common/ChromeColors'

const BAR_HEIGHT: number = 48
// 原版 dimens a=13dp 内边距 → 88px(@4x)=22dp 图标本体
const ICON_SIZE: number = 22

@ComponentV2
export struct Toolbar {
  @Param @Require tab: TabItem
  // 原版 g0.f()/k()：地址栏内嵌进工具栏首槽（应用布局 1/2），否则独立成行（布局 0/3）
  @Param embedAddress: boolean = false
  @Event onOpenSearch: () => void = () => {}
  @Event onOpenBookmarks: () => void = () => {}
  // 原版 W9()：打开书签快捷选择对话框（工具栏动作 30）
  @Event onBookmarkDialog: () => void = () => {}
  @Event onOpenHistory: () => void = () => {}
  @Event onSiteInfoLong: () => void = () => {}
  @Event onBack: () => void = () => {}
  @Event onForward: () => void = () => {}
  @Event onHome: () => void = () => {}
  @Event onTabs: () => void = () => {}
  @Event onMenu: () => void = () => {}
  @Event onAddressTap: () => void = () => {}
  @Event onOpenMedia: (urls: string[]) => void = (urls: string[]) => {
  }
  // 原版 v4.b 动作中需要页面级能力的项，由 Index 统一分发
  @Event onCommand: (cmd: string) => void = (cmd: string) => {
  }
  private tabStore: TabStore = TabStore.getInstance()
  private settings: AppSettings = AppSettings.getInstance()
  @Local swipeOffset: number = 0
  // 原版 k6.B1：横滑预览方向（0 无 / -1 上一标签 / +1 下一标签），预览时标签图标 alpha 0.15（g0.l）
  @Local swipePreviewCur: number = -1
  private swipeDir: number = 0
  // 原版 DragContainer：拖拽距离 84dp，比例 |f10| > 0.8 触发（k6.W4）
  private swipeDistance: number = 84
  @Local barWidth: number = 0
  // 原版 g0.j()：标签栈 translationY 回弹（0 → -0.3*height → 0，280ms，0.2/0.2/0.8/0.8）
  @Local tabBounceY: number = 0

  private toolbarBg(): ResourceColor {
    return toolbarBackgroundColor(this.tab, this.settings)
  }

  // 原版 k6.Z7（change color）三分支：工具栏图标/标签数着色
  //   夜间(zD) → color u = #9F9F9F
  //   非夜间且工具栏背景偏亮（y.C 亮度>=192）→ color t = #232323
  //   其余（非夜间暗背景）→ 白色
  // @Computed 保证图标 Text 同一次取值——普通方法在 build 中各元素独立求值，
  // colorMode 这类非状态量变化时 Text 不会重算（曾出现图标白/数字仍 #232323 的分裂）。
  @Computed
  get toolbarAccent(): ResourceColor {
    if (this.settings.isNightActive()) {
      return '#9F9F9F'
    }
    const bg = this.toolbarBg()
    let hex = ''
    if (typeof bg === 'string') {
      hex = bg
    } else if (typeof bg === 'object' && (bg as Resource).id !== undefined) {
      // Resource 色（home_bg）：按应用当前 colorMode 实际解析值判亮度。
      // 夜间分支只拦 isNightActive()（nightMode2 1/3）；「夜间关 + 系统深色」时
      // 应用 colorMode 仍跟随系统为深色，home_bg 解析为 #1C1B1D——
      // 若像旧实现硬编码 #FFFFFF 判亮，会算出 #232323 深图标叠深底 → 按钮全部隐形。
      hex = this.resolveResourceHex(bg as Resource)
    }
    hex = hex.replace('#', '')
    if (hex.length === 8) {
      hex = hex.substring(2)
    }
    if (hex.length === 6) {
      const r = parseInt(hex.substring(0, 2), 16)
      const g = parseInt(hex.substring(2, 4), 16)
      const b = parseInt(hex.substring(4, 6), 16)
      if (r * 0.299 + g * 0.587 + b * 0.114 >= 192) {
        return '#232323'
      }
    }
    return '#FFFFFF'
  }

  // 解析 Resource 颜色在**当前应用 colorMode** 下的实际 #RRGGBB（ChromeColors 同口径）
  private resolveResourceHex(res: Resource): string {
    try {
      const ctx = this.getUIContext().getHostContext() as common.UIAbilityContext
      // FAQ faqs-arkui-354：传完整 Resource 不按深浅色限定词解析，传 res.id 才会
      const argb = ctx.resourceManager.getColorSync(res.id)
      const r = (argb >> 16) & 0xFF
      const g = (argb >> 8) & 0xFF
      const b = argb & 0xFF
      const to2 = (v: number): string => v.toString(16).padStart(2, '0')
      return `#${to2(r)}${to2(g)}${to2(b)}`
    } catch (error) {
      return '#FFFFFF'
    }
  }

  // 原版 g0.m()：按宽度决定返回/前进是否显示及地址槽权重
  private wideBar(): boolean {
    if (!this.embedAddress) {
      return true
    }
    const w = this.barWidth
    if (w <= 0) {
      return false
    }
    const col = w < 420 ? w / 7 : w > 900 ? 72 : 60
    return w / (col <= 0 ? 6 : col) > 8
  }

  private addressWeight(): number {
    const w = this.barWidth
    if (w <= 0) {
      return 4
    }
    const col = w < 420 ? w / 7 : w > 900 ? 72 : 60
    const cols = w / (col <= 0 ? 6 : col)
    return Math.max(Math.round(cols - 3 - (cols > 8 ? 2 : 0)), 1)
  }

  private tabCountText(): string {
    const count = this.tabStore.tabs.length
    return count <= 99 ? String(count) : ':)'
  }

  // 原版 g0.java:203/249 的 contentDescription：普通态播报标签总数，
  // 横滑预览态播报「当前/总数」。原版用 getQuantityString 单复数，鸿蒙用「N 个标签页」。
  private tabAccessibilityText(): string {
    const total = this.tabStore.tabs.length
    let unit: string = ''
    try {
      unit = this.getUIContext().getHostContext()!.resourceManager
        .getStringSync($r('app.string.tab_count_unit').id)
    } catch (error) {
      unit = ''
    }
    if (this.swipePreviewCur >= 0) {
      return `${this.swipePreviewCur}/${total}`
    }
    if (total > 99) {
      return String(total)
    }
    return `${total} ${unit}`
  }

  // 原版 g0.j()：ObjectAnimator.ofFloat(f9648m, "translationY", 0, -0.3f*height, 0)
  //   .setDuration(280) + PathInterpolator(0.2,0.2,0.8,0.8)。
  // 关键帧 0 / 0.5 / 1 即两段 140ms。只动标签栈，不动整条工具栏。
  // 触发点仅两处（原版实测）：k6.A8() 进隐身、k6.b0() 标签事件且标签数>1。
  playTabBounce(): void {
    const amplitude: number = BAR_HEIGHT * 0.3
    const frames: KeyframeState[] = [
      {
        duration: 140,
        curve: BEZIER_0202_CURVE,
        event: (): void => {
          this.tabBounceY = -amplitude
        }
      },
      {
        duration: 140,
        curve: BEZIER_0202_CURVE,
        event: (): void => {
          this.tabBounceY = 0
        }
      }
    ]
    this.getUIContext().keyframeAnimateTo({ delay: 0, iterations: 1 }, frames)
  }

  aboutToAppear(): void {
    emitter.on({ eventId: TAB_BOUNCE_EVENT_ID }, () => {
      this.playTabBounce()
    })
  }

  aboutToDisappear(): void {
    emitter.off(TAB_BOUNCE_EVENT_ID)
  }

  // 原版 g0.l(cur, total)：cur>=0 时标签数显示 "%d/%d" 且标签图标 alpha 0.15；cur<0 恢复
  private swipePreviewText(): string {
    if (this.swipePreviewCur >= 0) {
      return `${this.swipePreviewCur}/${this.tabStore.tabs.length}`
    }
    return this.tabCountText()
  }

  // 原版 k6.W4 预览分支：|f10|>0.8 时按方向动作键映射 i10（10→-1，11→+1），
  // i11 = k()+1+i10（越下界取 total，越上界保持 1）
  private updateSwipePreview(fraction: number): void {
    let action: number = 0
    if (Math.abs(fraction) > 0.8) {
      action = fraction > 0 ? this.settings.gesturetoolbarleft : this.settings.gesturetoolbarright
    }
    if (action === this.swipeDir) {
      return
    }
    this.swipeDir = action
    if (action !== 10 && action !== 11) {
      this.swipePreviewCur = -1
      return
    }
    const total: number = this.tabStore.tabs.length
    const delta: number = action === 10 ? -1 : 1
    const target: number = this.tabStore.currentIndex + 1 + delta
    if (target <= 0) {
      this.swipePreviewCur = total
    } else if (target <= total) {
      this.swipePreviewCur = target
    } else {
      this.swipePreviewCur = 1
    }
  }

  // 原版 z8.b0.V（z8/b0.java:391-416）：平滑滚动，带缓动与自取消。
  //   i10: 0=顶 1=底 2=上翻 3=下翻；翻页步长 = 视口高 4/5；时长 100 + min(1,|Δ|/3000)*400ms，
  //   插值 AccelerateDecelerate。原版用 Animator 驱动 WebView.scrollY，网页侧等价实现为
  //   window.scrollTo({top, behavior:'smooth'})。
  private scrollPage(mode: number): void {
    const js = `(function(){try{`
      + `var vh=window.innerHeight||document.documentElement.clientHeight;`
      + `var maxY=Math.max(0,(document.documentElement.scrollHeight||document.body.scrollHeight)-vh);`
      + `var cur=window.pageYOffset||document.documentElement.scrollTop||0;`
      + `var target=${mode === 0 ? '0' : mode === 1 ? 'maxY'
    : mode === 2 ? 'Math.max(0,cur-vh*0.8)' : 'Math.min(maxY,cur+vh*0.8)'};`
      + `target=Math.max(0,Math.min(maxY,target));`
      + `var delta=Math.abs(target-cur);`
      + `if(delta<1){return;}`
      + `var dur=Math.round(100+Math.min(1,delta/3000)*400);`
      + `try{window.scrollTo({top:target,left:0,behavior:'smooth'});}`
      + `catch(e){window.scrollTo(0,target);}`
      + `}catch(e){}})();`
    try {
      this.tab.controller.runJavaScript(js).catch((error: Error) => {
        console.error(`smooth scroll failed: ${error.message}`)
      })
    } catch (error) {
      console.error('smooth scroll failed')
    }
  }

  // 原版 hb/v4.b()：长按动作全集（v4.java:65-130）
  // 0=无 1=刷新 2=回顶部 3=到底部 4=输入网址 5=新建标签 6=添加书签 7=书签 8=历史
  // 9=关闭标签 10=上一标签 11=下一标签 12=网页后退 13=网页前进 14=页内查找 15=翻译
  // 16=关闭所有 17=上翻页 18=下翻页 19=保存网页 20=源码 23=标签面板 24=朗读
  // 25=阅读模式 26=设置 27=复制标签页 28=下载 29=AI 30=书签对话框
  private longPressAction(key: number): void {
    switch (key) {
      case 1:
        try {
          this.tab.controller.refresh()
        } catch (error) {
          console.error('long press refresh failed')
        }
        break
      case 2:
        // 原版 k6.ra case2（k6.java:8265-8268）→ z8.b0.V(O8(), 0)：平滑滚动到顶部
        this.scrollPage(0)
        break
      case 3:
        // 原版 k6.ra case3 → z8.b0.V(O8(), 1)：平滑滚动到底部
        this.scrollPage(1)
        break
      case 4:
        // 原版 k6.ra case4（k6.java:8269-8272）= ub() + na()：先恢复被自动隐藏的工具栏，
        // 再打开网址输入。只调 onOpenSearch 会漏掉恢复分支（隐藏态下地址栏不回来）。
        this.onCommand('inputUrl')
        break
      case 5:
        this.tabStore.newTab(false)
        break
      case 6:
        this.onCommand('addBookmark')
        break
      case 7:
        // 原版 k6.ra case7（k6.java:8279-8281）→ ja(true) → aa(null)（k6.java:6731-6740）
        // → g6.i.i(this, bb.i, bb.i.n3(true,1))：打开 bb.i 记录容器（f2116t0={1,2,3}，1=e0）
        // = **书签管理页**（不是对话框）；case8 同分支 ja(false) → fa() = 历史页。
        // 动作文案 hb/v4.java:81-84：case7 = po「打开书签」、case8 = K9「历史」。
        this.onOpenBookmarks()
        break
      case 30:
        // 原版 k6.ra case30（k6.java:8357-8359）→ W9()（k6.java:6224-6227）
        // → open a8.k：书签**快捷选择对话框**（动作文案 hb/v4.java:127-128 = x7.u.H9 = pn
        // 「打开书签对话框」），点书签后在当前标签打开（a8/k.onDismiss → k6.K3 → k6.Ra）。
        // 不是跳书签管理页，也不是 case7 的「添加书签」（Wa()/a8.u1）。
        this.onBookmarkDialog()
        break
      case 8:
        this.onOpenHistory()
        break
      case 9:
        this.tabStore.closeTab(this.tabStore.currentIndex)
        break
      case 10:
        this.tabStore.stepTab(-1)
        break
      case 11:
        this.tabStore.stepTab(1)
        break
      case 12:
        this.onBack()
        break
      case 13:
        this.onForward()
        break
      case 14:
        this.onCommand('find')
        break
      case 15:
        this.onCommand('translate')
        break
      case 16:
        // 原版 k6.ra case16（k6.java:8316-8318）→ Da()（k6.java:4061-4068）：
        // 先弹确认框（w5.k 居中，标题 Pf、正文 T7、确认 f14054l、取消 J），
        // 确认才 o5() 逐个 i8([...]) 关闭全部。直接 closeAll() 会误触清空。
        this.onCommand('closeAllTabs')
        break
      case 17:
        // 原版 k6.ra case17 → z8.b0.V(O8(), 2)：向上翻约 80% 视口（带缓动）
        this.scrollPage(2)
        break
      case 18:
        // 原版 k6.ra case18 → z8.b0.V(O8(), 3)：向下翻约 80% 视口（带缓动）
        this.scrollPage(3)
        break
      case 19:
        this.onCommand('savePage')
        break
      case 20:
        this.onCommand('viewSource')
        break
      case 21:
        // 原版 k6.ra case21（k6.java:8329-8332）→ E8(true)：页内查找下一个
        this.onCommand('findNext')
        break
      case 22:
        // 原版 k6.ra case22 → E8(false)：页内查找上一个
        this.onCommand('findPrev')
        break
      case 23:
        this.onTabs()
        break
      case 24:
        this.onCommand('tts')
        break
      case 25:
        this.onCommand('reader')
        break
      case 26:
        this.onCommand('settings')
        break
      case 27:
        this.tabStore.duplicateTab(this.tabStore.currentIndex)
        break
      case 28:
        this.onCommand('downloads')
        break
      case 29:
        this.onCommand('ai')
        break
      default:
        break
    }
  }

  private keyOf(button: string): number {
    if (button === 'back') {
      return this.settings.keyback
    }
    if (button === 'forward') {
      return this.settings.keyforward
    }
    if (button === 'home') {
      return this.settings.keyhome
    }
    if (button === 'tabs') {
      return this.settings.keytab
    }
    return this.settings.keymenu
  }

  build() {
    Row() {
      if (this.embedAddress) {
        Row() {
          AddressBar({
            tab: this.tab,
            // 原版 k6.Tb()：布局 1/2 的嵌入式地址栏带 4dp 内缩的圆角底（非透明）
            style: 'card',
            onAddressTap: () => {
              this.onAddressTap()
            },
            onOpenMedia: (urls: string[]) => {
              this.onOpenMedia(urls)
            },
            onReader: () => {
              this.onCommand('reader')
            }
          })
        }
        .layoutWeight(this.addressWeight())
        .height('100%')
        // 原版 g0.i()：地址槽 P(1,12) 左 12dp / L(1,0) 右 0
        .padding({ left: 12, right: 0 })
      }
      if (this.showNavButtons('back')) {
        // 原版 g0.g()/k6.f.a()：图标不做禁用态灰化，可后退与否由点击分支
        // U8()（可退则退、不可退非主页则关标签）实时判断，故此处恒可点。
        this.ToolButton('back', $r('app.media.uia_ic_back'), true, () => {
          this.onBack()
        })
      }
      if (this.showNavButtons('forward')) {
        // 原版前进 = drawable/a3.xml：<rotate drawable=@drawable/b2 180°>
        // 原版 V8()：可前进则前进，否则重开最近关闭的标签（na.U0），同样恒可点。
        this.ToolButton('forward', $r('app.media.uia_ic_back'), true, () => {
          this.onForward()
        }, 180)
      }
      if (!this.hidden('home')) {
        this.ToolButton('home', $r('app.media.uia_ic_home'), true, () => {
          this.onHome()
        })
      }
      if (!this.hidden('tabs')) {
        // 原版 g0.h()：栈叠图标 + 加粗标签数叠加（>99 显示 :)）
        // g0.l(cur,total) 只由 k6.W4 横滑预览分支调用（k6.java:2471/2480），不涉隐身；
        // g0.j() 回弹的调用点只有 k6.A8()（进隐身）与 k6.b0()（标签事件且数>1）——
        // 退出隐身 l8()（k6.java:7551-7572）全文无 j()，不要往退出路径加动画。
        // 图标与数字色 = setAccentColor 三分支（k6.Z7）：夜间 #9F9F9F / 亮背景 #232323 / 其余白
        Stack() {
          ViaIcon({
            icon: $r('app.media.uia_ic_tabs'),
            iconSize: ICON_SIZE,
            iconColor: this.toolbarAccent,
            imageDraggable: false
          })
          Text(this.swipePreviewText())
            .fontSize(11)
            .fontWeight(FontWeight.Bold)
            .fontColor(this.toolbarAccent)
            .maxLines(1)
        }
        .layoutWeight(1)
        .height('100%')
        .alignContent(Alignment.Center)
        .opacity(this.swipePreviewCur >= 0 ? 0.15 : 1)
        .translate({ y: this.tabBounceY })
        // 原版 g0.java:203/249：标签栈 contentDescription 播报标签数/预览序号
        .accessibilityGroup(true)
        .accessibilityText(this.tabAccessibilityText())
        // 原版 mark/via/common/widget/g0.java:181-185 g0.j()：
        //   ObjectAnimator.ofFloat(标签栈 f9648m, "translationY", 0f, -0.3f*height, 0f)
        //   .setDuration(280L) + setInterpolator(x8.h.b()) 即 PathInterpolator(0.2,0.2,0.8,0.8)。
        // 单条 280ms 三关键帧动画（关键帧 0 / 0.5 / 1），作用对象只是标签栈本身，不是整条工具栏。
        // 鸿蒙用 keyframeAnimateTo 一条时间轴承载两段 140ms，替代分段 animateTo + setTimeout 拼接。
        .onClick(() => {
          this.onTabs()
        })
        .gesture(LongPressGesture({ repeat: false, duration: 400 }).onAction(() => {
          this.longPressAction(this.keyOf('tabs'))
        }))
      }
      if (!this.hidden('menu')) {
        this.ToolButton('menu', $r('app.media.uia_ic_menu'), true, () => {
          this.onMenu()
        })
      }
    }
    .width('100%')
    .height(BAR_HEIGHT)
    // 原版 Z7/c4：工具栏背景随配色动画渐变（ValueAnimator 逐帧 setBackgroundColor）。
    // 容器层（Index animatedOrComputedBg）与组件层同走 animateTo 隐式动画，此处保持
    // 直接计算值即可——外层 animateTo 闭包内本组件随状态重渲染，颜色同步补间。
    .backgroundColor(this.toolbarBg())
    .alignItems(VerticalAlign.Center)
    .onAreaChange((_old: Area, newArea: Area) => {
      this.barWidth = Number(newArea.width)
    })
    // 原版 DragContainer 使用系统 touch slop 开始跟手，动作仍由 84dp * 0.8 提交门槛控制。
    .gesture(PanGesture({ fingers: 1, direction: PanDirection.Horizontal, distance: 5 })
      .onActionUpdate((event: GestureEvent) => {
        this.swipeOffset = event.offsetX
        this.updateSwipePreview(px2vp(this.swipeOffset) / this.swipeDistance)
      })
      .onActionEnd(() => {
        const fraction: number = px2vp(this.swipeOffset) / this.swipeDistance
        if (Math.abs(fraction) > 0.8) {
          const action: number = fraction > 0
            ? this.settings.gesturetoolbarleft : this.settings.gesturetoolbarright
          this.longPressAction(action)
        }
        this.swipeOffset = 0
        this.updateSwipePreview(0)
      })
      .onActionCancel(() => {
        this.swipeOffset = 0
        this.updateSwipePreview(0)
      }))
  }

  // 原版 k()：地址栏未内嵌时返回/前进恒显；内嵌时仅宽屏显示
  private showNavButtons(id: string): boolean {
    if (this.hidden(id)) {
      return false
    }
    return !this.embedAddress || this.wideBar()
  }

  private hidden(id: string): boolean {
    return this.settings.toolbarHidden.indexOf(id) >= 0
  }

  @Builder
  ToolButton(id: string, icon: Resource, enabled: boolean, action: () => void, rotate: number = 0) {
    Column() {
      // 原版 g0.setAccentColor（k6.Z7 三分支）：工具栏图标着色随背景明暗
      ViaIcon({
        icon: icon,
        iconSize: ICON_SIZE,
        iconColor: this.toolbarAccent,
        rotateDeg: rotate
      })
    }
    .layoutWeight(1)
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .alignItems(HorizontalAlign.Center)
    // 原版 g0.g()：图标 ImageView 无禁用态灰化，不可后退时仍为 accent 原色（k6 点击分支自行判断）
    .gesture(LongPressGesture({ repeat: false, duration: 400 }).onAction(() => {
      this.longPressAction(this.keyOf(id))
    }))
    .onClick(() => {
      if (enabled) {
        action()
      }
    })
  }
}
