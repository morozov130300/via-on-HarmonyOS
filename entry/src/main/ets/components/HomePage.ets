import { curves, display } from '@kit.ArkUI'
import { TabStore } from '../common/TabStore'
import { BrowserDb } from '../common/Database'
import { HomeFavRec } from '../common/Types'
import { AppSettings } from '../common/Settings'
import { UiInsets } from '../common/Immersive'
import {
  HOME_ADV_AREAS,
  HOME_FAV_ICON_STYLES,
  HOME_FAV_SHADOWS,
  HOME_LOGO_STYLES,
  HOME_LOGO_TYPES,
  HOME_PILL_HEIGHT,
  HOME_PILL_STYLES,
  homeFavColor
} from '../common/HomeStyle'
import { HomeFavEditor } from './HomeFavEditor'

// 原版主页注入的 CSS（i6/o.java:374）：
//   writer.a("#content { top: 25%; transition: 0.14s; }")
// `transition: 0.14s` 是简写，等价 `transition: all 0.14s ease 0s` —— 即 **所有**可动画属性
// （transform、opacity、top）的变化都被 140ms、CSS 默认 ease（cubic-bezier(.25,.1,.25,1)）过渡。
// 这对两条脚本路径都成立（脚本里 `el.style.x = ...` 同样触发 CSS transition）：
//   ① initGesture 的 touchmove 每帧写 transform/opacity → 被 140ms ease 平滑（跟手带滞后）；
//   ② triggerSearchBar 的 transform/opacity 下沉与回位 → 同一条 140ms ease。
// 该 transition 仅在此分支（搜索区「展示」）注入；搜索区「隐藏」时 o.java:372 只写
//   "#content { top: 18px; } .search_part { display: none; }" —— 不含 transition，
// 即隐藏态下变化是瞬时跳变，必须区别对待。
const CSS_EASE_CURVE: ICurve = curves.cubicBezierCurve(0.25, 0.1, 0.25, 1.0)
const HOME_TRANSITION_MS: number = 140

@ComponentV2
export struct HomePage {
  private tabStore: TabStore = TabStore.getInstance()
  private db: BrowserDb = BrowserDb.getInstance()
  private settings: AppSettings = AppSettings.getInstance()
  @Event onSearchTap: () => void = () => {}
  @Event onScanResult: (text: string) => void = (text: string) => {}
  @Event onLogoTap: () => void = () => {}
  // 原版原生搜索面板打开时下拉手势禁用（k6 window.via.cmd(515)==0）
  @Param searchOpen: boolean = false
  // 原版主页是同一 WebView 内部页，触摸事件同样喂竖滑隐藏状态机
  // （e8/i.java:124 OnTouchListener 挂 WebView 本体，主页不过滤）
  @Param onAutoHideTouch: (action: number, x: number, y: number) => void =
    (_action: number, _x: number, _y: number): void => {}
  @Local favs: HomeFavRec[] = []
  @Local favColors: Record<string, string> = {}
  @Local searchShift: number = 0
  // 原版 #content 唯一的不透明度载体（两条脚本路径轮流写，见 build 内注释）
  @Local contentFade: number = 1
  @Local pullShift: number = 0
  @Local atTop: boolean = true
  @Local scrollY: number = 0
  @Local showEditor: boolean = false
  private insets: UiInsets = UiInsets.getInstance()
  // 屏幕宽高（vp），用于原版按屏宽/屏高的媒体查询分档（i6/o.java、qa/e1.java）
  private screenW: number = 360
  private screenH: number = 780
  // 主页实际视口宽高（vp）：原版媒体查询 min-width/min-height 匹配的是 WebView 视口，
  // 即「屏幕 - 状态栏 - 地址栏 - 操作栏」，不等于物理屏幕高（i6/o.java:357-379）
  @Local vpW: number = 0
  @Local vpH: number = 0
  // 原版 #content 的 transition 只在搜索区「展示」分支注入（i6/o.java:374），
  // 隐藏分支（o.java:372）无 transition → 用这条 public 标志决定 animateTo 是否带参数。
  private contentTransitionEnabled(): boolean {
    return HOME_ADV_AREAS[this.settings.homeAdvArea] === '展示'
  }

  // 原版 #content 的 CSS transition 作用于 transform / opacity 变化（0.14s ease）。
  // 鸿蒙侧凡改动 searchShift / contentFade / pullShift 的赋值都要经这里包一层，
  // 才等价于原版 CSS transition；搜索区「隐藏」时原版无 transition，直接落值。
  private contentAnimate(duration: number, curve: ICurve, event: () => void): void {
    if (!this.contentTransitionEnabled()) {
      event()
      return
    }
    this.getUIContext().animateTo({ duration: duration, curve: curve }, event)
  }

  aboutToAppear(): void {
    try {
      const d = display.getDefaultDisplaySync()
      this.screenW = d.width / d.densityPixels
      this.screenH = d.height / d.densityPixels
    } catch (error) {
      console.error('get display failed')
    }
    this.reload()
  }

  private reload(): void {
    this.db.listHomeFavs().then((items: HomeFavRec[]) => {
      this.favs = items
      this.loadFavColors(items)
    }).catch((error: BusinessError) => {
      console.error(`list home favs failed: ${error.message}`)
    })
  }

  // 原版多彩底色 = 网址 MD5 派生（见 HomeStyle.homeFavColor），异步预计算
  private async loadFavColors(items: HomeFavRec[]): Promise<void> {
    for (const item of items) {
      if (this.favColors[item.url] === undefined) {
        try {
          this.favColors[item.url] = await homeFavColor(item.url)
        } catch (error) {
          this.favColors[item.url] = ''
        }
      }
    }
  }

  build() {
    Stack() {
      if (this.settings.homeBgImage !== '') {
        Image(this.settings.homeBgImage)
          .width('100%')
          .height('100%')
          .objectFit(ImageFit.Cover)
        Column()
          .width('100%')
          .height('100%')
          .backgroundColor(`#${this.bgOverlayAlpha()}000000`)
      }
      Scroll() {
      Column() {
      // 原版 #content top 按屏高分档（i6/o.java:374-379）：62/87/135/195/255px，低于 250px 用 25%
      Column()
        .height(this.contentTopOffset())

      if (HOME_ADV_AREAS[this.settings.homeAdvArea] === '展示') {
        // 原版 i6/o.java:23-36,294-298：#content（max-width:600 居中）内
        //   .search_part { display:table; width:90%; max-width:600px; margin:0 auto 20px }
        //     ├ <a class="logo">（inline，body text-align:center 继承居中）
        //     └ .search_bar_wrapper { width:100%; margin:15px auto 0 }
        //         └ .search_bar { width:100%; margin:0; height:46px }
        // logo 与搜索栏同属此 90% 容器：搜索栏 width:100% 相对的是 .search_part，
        // 绝非相对 #content 全屏宽。故二者必须包进同一个 90% Column，
        // 否则搜索栏 .width('100%') 会撑满整屏（原版为 90% 居中窄栏）。
        Column() {
          // .search_part（父 Column 默认 HorizontalAlign.Center → margin:0 auto）
          Column() {
            if (HOME_LOGO_TYPES[this.settings.homeLogoType] === '文字') {
              Text(this.settings.homeLogoText)
                .fontSize(this.settings.homeLogoSize)
                .fontColor($r('app.color.home_text'))
                .fontWeight(this.logoBold())
                .fontStyle(this.logoItalic())
                // 原版 .logo 为 white-space:normal + overflow:auto，无行数限制
                .textAlign(TextAlign.Center)
            } else if (HOME_LOGO_TYPES[this.settings.homeLogoType] === '图片'
              && this.settings.homeLogoImage !== '') {
              Image(this.settings.homeLogoImage)
                .width(this.logoWidth())
                .height(this.logoHeight())
                .borderRadius(this.logoRadius())
                // 原版 i6/o.java:277-284：所有 logo 图（含自定义图）都走 img.smaller，object-fit:cover
                .objectFit(ImageFit.Cover)
            } else if (HOME_LOGO_TYPES[this.settings.homeLogoType] === 'HTML 代码'
              && this.settings.homeLogoHtml !== '') {
              RichText(this.settings.homeLogoHtml)
                .width(this.logoWidth())
                .height(this.logoHeight())
            } else if (HOME_LOGO_TYPES[this.settings.homeLogoType] === '默认') {
              Image($rawfile('logo.png'))
                .width(this.logoWidth())
                .height(this.logoHeight())
                .borderRadius(this.logoRadius())
                // 原版 i6/o.java:277 img.smaller 为 object-fit: cover
                .objectFit(ImageFit.Cover)
            }
          }
          .width('100%')
          // 原版 i6/o.java:24：logo 是 <a onclick="window.via.cmd(257)">；
          // c8/k6.java:1409 → ja(true) → aa(null) → g6.i.i(..., bb.i.n3(true,1))，
          // 即打开书签管理页（RecordContainerFragment 标签 1），并非进入主页定制设置。
          .onClick(() => {
            this.onLogoTap()
          })

          // 原版 i6/o.java:304-316：矩形(p()=false) = "border-bottom: <s>px solid <str20>"，仅底边。
          // ArkUI 的 .border 单边宽度与 borderRadius 不兼容（边框沿圆角路径渲染，单边设置被
          // 忽略、退化成四边均匀描边，真机表现为整圈描边）。故矩形样式的底边线不走 .border，
          // 用 Stack 底部对齐的独立线条元素 1:1 复刻 CSS border-bottom；线条样式(p()=true)
          // = "border" 四边，uniform 边框无此问题，保留 .border。
          Stack({ alignContent: Alignment.Bottom }) {
            if (HOME_PILL_STYLES[this.settings.homePillStyle] !== '线条') {
              Row()
                .height(this.settings.homePillStrokeWidth)
                .width('100%')
                .backgroundColor(this.strokeColor())
            }
          }
          .height(HOME_PILL_HEIGHT)
          .width('100%')
          .backgroundColor(this.pillBackground())
          // 原版 i6/o.java:229-235,315：`.search_bar { background: rgba(...,α); <str6> }`。
          // str6 方向经 jadx fallback 指令级代码坐实（L1a8）：config.t()(usingBlur)==true 才写
          // "backdrop-filter: blur(10px);"；Java 反编译产物把 if 方向印反了。
          // 即毛玻璃只做「背后内容模糊」，底色一律由 rgba 的 α 决定。
          // 不能用 backgroundBlurStyle(BlurStyle.*)：该材质自带背板色/蒙层，与 backgroundColor 的 α 无关，
          // 表现为「不透明度 0 仍有一层蒙版」。改用 backdropBlur 对应原版 backdrop-filter。
          .backdropBlur(this.settings.homeAdvEffect === 1 ? 10 : 0)
          // 官方 ts-universal-attributes-border / faqs-arkui-1376：border 配置须在 borderRadius
          // **之前**；否则 border 缺省 radius=0 覆盖圆角。矩形样式底边线已在 Stack 内独立绘制，
          // pillBorder() 此时仅在线条样式返回四边 uniform 边框（矩形返回零宽边框）。
          .border(this.pillBorder())
          .borderRadius(this.pillRadius())
          // 原版 .search_bar 无任何按压态样式（全 CSS 只有 .opSug_wpr tr:hover 与
          // #search_bar_trigger:focus-visible），故不加 stateStyles
          // 原版 .search_bar_wrapper margin:15px auto 0（仅 top 15）；bottom 20 归 .search_part
          .margin({ top: 15 })
          .onClick(() => {
            // 原版 triggerSearchBar：内容上滑 72px 渐隐后唤起搜索
            this.animateToSearch()
          })
        }
        // 原版 .search_part：width:90%; max-width:600px; margin:0 auto 20px
        .width('90%')
        .constraintSize({ maxWidth: 600 })
        .margin({ bottom: 20 })
      }

      if (this.favs.length > 0) {
        Grid() {
          ForEach(this.favs, (item: HomeFavRec) => {
            GridItem() {
                // 原版 .url { margin: 2px 0 0 } —— 间距只有 2，不能再叠 Column space
                Column() {
                  Stack() {
                    // 原版 .title（i6/o.java:344-355）：宽=图标宽、行高=高=图标高、字号 15
                  Text(this.iconText(item))
                      .fontSize(15)
                      // 原版 i6/o.java:347：.title color = !config.d() ? str17 : "#ffffff"
                      // d()=多彩底色被禁用（本工程「透明」）→ 恒白字；多彩时用标题灰
                      .fontColor(this.favColor(item) === '' ? Color.White : this.favTextColor())
                      .textAlign(TextAlign.Center)
                      .width('100%')
                      .height('100%')
                      // 原版 line-height = height = 图标高 → 文字垂直居中
                      .align(Alignment.Center)
                      // 原版 i6/o.java:290-291/412-413：.title 恒叠加 brightness(75%)
                      .brightness(this.logoDim())
                    if (this.showFavicon() && item.icon !== '') {
                      Image(item.icon)
                        .width('100%')
                        .height('100%')
                        .borderRadius(this.favRadius())
                        .objectFit(ImageFit.Cover)
                        // 原版同一条规则作用于 .overlay
                        .brightness(this.logoDim())
                    }
                  }
                  .width(this.favSize())
                  .height(this.favHeight())
                  .borderRadius(this.favRadius())
                  .backgroundColor(this.favColor(item) === '' ? Color.Transparent : this.favColor(item))
                  // 原版 .url（i6/o.java:356）：宽=图标宽、margin-top 2px、height/line-height 20px、
                  // font-size 10px、overflow:hidden + text-overflow:clip（原版仅两行：图标字 + 名称）
                  Text(item.title)
                    .fontSize(10)
                    .fontColor(this.favTextColor())
                    .width(this.favSize())
                    .height(20)
                    .margin({ top: 2 })
                    .maxLines(1)
                    // 原版 line-height 20 = height 20 → 单行垂直居中
                    .align(Alignment.Center)
                    .textOverflow({ overflow: TextOverflow.Clip })
                }
                .padding({ top: 4, bottom: 4 })
              }
              .onClick(() => {
                this.tabStore.navigate(item.url)
              })
              // 原版长按收藏 → 打开「主页收藏」管理弹层（k6.da/ea）
              .gesture(LongPressGesture({ repeat: false, duration: 500 }).onAction(() => {
                this.showEditor = true
              }))
          }, (item: HomeFavRec) => `${item.id}_${item.title}`)
        }
        // 原版 i6/o.java:357-370：列数按屏宽动态，上限 540/(item+18)
        .columnsTemplate(this.favColumnsTemplate())
        .columnsGap(18)
        // 原版 .box { margin: 4px 9px 4px } 自带上下 4px 间距，行间无额外 gap
        .rowsGap(0)
        // 原版 #box_container 宽 = (.box 宽 + 左右 margin 18) × 列数，首尾各含 9px 外边距
        .width(this.favColumns() * (this.favSize() + 18))
        .padding({ left: 9, right: 9 })
        // 原版 .box margin-top 4（与搜索框的 margin-bottom 20 累加 = 24）
        .margin({ top: 4 })
        // 每行高 = .box 上下 margin 8 + .title 高 f + .url margin-top 2 + .url 高 20
        .height(Math.ceil(this.favs.length / this.favColumns()) * (this.favHeight() + 30))
      }

      }
      .translate({ y: this.searchShift + this.pullShift })
      // 原版 #content 的 style.opacity 由两条脚本路径写入，二者互斥（同一时刻只有一个在写）：
      //   ① initGesture touchmove：max(.1, 1 - 位移/98)
      //   ② triggerSearchBar：0.1（下沉）→ 恢复原值（回位）
      // 故这里只读一个状态 contentFade，由两条路径各自维护，不做叠加。
      .opacity(this.contentFade)
      .width('100%')
      // 原版 #content 是 absolute 定位、高度随内容自适应；此处用 minHeight 撑满视口，
      // 内容超出时随 Scroll 滚动（固定 height:100% 会压缩收藏行、且无法滚到超出部分）
      .constraintSize({ minHeight: '100%' })
      // 原版 i6/o.java:244-246：body/#content/#gesture-indicator 均 max-width:600px（margin auto 居中）
      // 顶部不额外加 insets.top：本组件已位于地址栏之下（Index 的 TopBarArea 已消费状态栏）
      .padding({
        left: this.contentSidePad(),
        right: this.contentSidePad()
      })
      }
      .scrollBar(BarState.Off)
      .width('100%')
      .height('100%')
      .onScrollEdge((side: Edge) => {
        if (side === Edge.Top) {
          this.scrollY = 0
          this.atTop = true
        }
      })
      .onDidScroll((offsetX: number, offsetY: number) => {
        this.scrollY += offsetY
        if (this.scrollY < 0) {
          this.scrollY = 0
        }
        this.atTop = this.scrollY <= 0
      })
    }
    .width('100%')
    .height('100%')
    // 原版媒体查询按 WebView 视口（= 本组件实际宽高）分档，不用物理屏幕尺寸
    .onAreaChange((_old: Area, area: Area) => {
      this.vpW = Number(area.width)
      this.vpH = Number(area.height)
    })
    .backgroundColor(this.homeBackground())
    // 原版 qa.e1：主页收藏管理底部弹层
    .bindSheet($$this.showEditor, this.HomeFavSheet(), {
      // 原版 qa.e1.d3：clamp(默认 导航栏+屏高/2, 下限 导航栏+168, 上限 导航栏+60%屏高)
      height: this.editorSheetHeight(),
      showClose: true,
      dragBar: true,
      onDisappear: () => {
        this.reload()
      }
    })
    // 原版 initGesture（i6/o.java:45）+ isGestureDisabled：
    //   禁用条件 = 焦点在搜索框 || !via.cmd(515) || 页面已滚动。
    //   via.cmd(515) = k6.java:1426-1427 返回 (f2589q1 || f2597u1)，
    //   即「工具栏显示或 FAB 可见」=1。⇒ 工具栏隐藏时主页下拉搜索被禁用，
    //   此时下滑只走原生竖滑状态机恢复工具栏；工具栏显示时下拉搜索照常。
    //   本端以 toolbarShown 标志等价 cmd(515)：隐藏态下不再累积下拉位移、
    //   不触发搜索，仅喂状态机。
    .parallelGesture(PanGesture({ fingers: 1, direction: PanDirection.All, distance: 5 })
      .onActionStart((event: GestureEvent) => {
        this.onAutoHideTouch(0, event.offsetX, event.offsetY)
        if (!this.atTop || this.searchOpen || !this.toolbarShownForGesture()) {
          return
        }
        this.applyPull(event.offsetY)
      })
      .onActionUpdate((event: GestureEvent) => {
        this.onAutoHideTouch(2, event.offsetX, event.offsetY)
        if (!this.atTop || this.searchOpen || !this.toolbarShownForGesture()) {
          return
        }
        this.applyPull(event.offsetY)
      })
      .onActionEnd(() => {
        this.onAutoHideTouch(1, 0, 0)
        const shift = this.pullShift
        // 原版 i6/o.java:45 initGesture 的 touchend 分支：
        //   if(0!==a){ if(88.2<a) callNativeSearch();
        //              c.style.transform="translateY(0px)"; fadeIn(c) }
        // 即①唤起门限 88.2px；②transform 写回 0、opacity 交给 fadeIn(c) 恢复。
        // 两者都受 #content 的 "transition: 0.14s"（CSS 默认 ease）作用 ——
        // fadeIn 每 6ms 写一次 style.opacity，每次写入都重新触发一次 140ms ease，
        // 净效果是「指数逼近 + 每步都被 140ms ease 平滑」，比纯 150ms/EaseOut 更缓。
        // 本端以同一条 CSS ease 曲线承载这段回位，时长为 fadeIn 的总步进时长。
        const fromFade: number = this.contentFade
        // 原版 fadeIn：b 每 6ms ×1.1 直至 >=1，步数 = ln(1/b)/ln(1.1)
        const ticks: number = Math.max(1, Math.log(1 / Math.max(0.05, fromFade)) / Math.log(1.1))
        const restoreMs: number = Math.max(HOME_TRANSITION_MS, Math.round(ticks * 6))
        this.contentAnimate(restoreMs, CSS_EASE_CURVE, () => {
          this.pullShift = 0
          this.contentFade = 1
        })
        if (shift > 88.2) {
          this.onSearchTap()
        }
      })
      .onActionCancel(() => {
        this.onAutoHideTouch(3, 0, 0)
      }))
  }

  // 原版 i6/o.java initGesture 的 isGestureDisabled → via.cmd(515)
  // （k6.java:1426-1427：return (f2589q1 || f2597u1) ? 1 : 0）。
  // 工具栏隐藏时=0 → 主页下拉搜索禁用，下滑只恢复工具栏。
  // Index 通过 onGestureEnabledQuery 回调查询当前显隐态。
  private toolbarShownForGesture(): boolean {
    return this.gestureEnabledQuery()
  }

  @Event gestureEnabledQuery: () => boolean = (): boolean => true

  // 原版 i6/o.java:45 initGesture 的 touchmove 分支：
  //   g=b; b=e.touches[0].screenY-h; a=Math.min(98,Math.max(0,a+b-g));
  //   c.style.transform="translateY("+a+"px)"; c.style.opacity=Math.max(.1,1-a/98)
  // 位移与不透明度都是逐帧写 style，且 #content 带 "transition: 0.14s"，故每次写入
  // 都被 140ms ease 平滑（跟手会带一点滞后），这里用同一条 ease 包一层等价。
  private applyPull(offsetY: number): void {
    this.contentAnimate(HOME_TRANSITION_MS, CSS_EASE_CURVE, () => {
      this.pullShift = Math.max(0, Math.min(98, offsetY))
      this.contentFade = Math.max(0.1, 1 - this.pullShift / 98)
    })
  }

  @Builder
  HomeFavSheet() {
    HomeFavEditor({
      onClose: () => {
        this.showEditor = false
      }
    })
  }

  // 原版 i6/o.java:45 triggerSearchBar()：
  //   var t=c.style.transform,o=c.style.opacity;
  //   requestAnimationFrame(function(){
  //     c.style.transform="translateY(72px)"; c.style.opacity="0.1";
  //     setTimeout(function(){
  //       callNativeSearch();
  //       c.style.transform=t; c.style.opacity=o;      // ← 同一次 CSS transition 动画回位
  //       setTimeout(function(){ a.removeAttribute("aria-disabled") },160)
  //     },120) } )
  // 关键点：下沉/回位都是改 style，走 #content 的 "transition: 0.14s"（CSS 默认 ease）；
  // 120ms 只是「调起原生搜索」的延时（此时回位会打断 140ms 的进场，属原版行为），
  // 160ms 只是 aria-disabled 复位延时，与动画无关。
  // 旧实现的 120ms/EaseOut + 瞬时回位（无 animateTo）两处都与原版不符。
  private animateToSearch(): void {
    // 原版 var o=c.style.opacity 记下的是「当前实际不透明度」，回位时写回该值
    const savedFade: number = this.contentFade
    this.contentAnimate(HOME_TRANSITION_MS, CSS_EASE_CURVE, () => {
      this.searchShift = 72
      this.contentFade = 0.1
    })
    setTimeout(() => {
      this.onSearchTap()
      // 原版此处同样是一只 CSS transition（0.14s ease），不是瞬跳
      this.contentAnimate(HOME_TRANSITION_MS, CSS_EASE_CURVE, () => {
        this.searchShift = 0
        this.contentFade = savedFade
      })
    }, 120)
  }

  private homeBackground(): ResourceColor {
    if (this.settings.homeBgImage !== '') {
      return Color.Transparent
    }
    if (this.settings.homeBgColor !== '') {
      // 原版夜间联动：自设背景色经黑滤镜（k6.Hb window filter）
      return this.settings.nightBlend(this.settings.homeBgColor)
    }
    return $r('app.color.home_bg')
  }

  // 背景图片遮罩不透明度（0-100 → 00-FF 黑色遮罩 alpha）
  private bgOverlayAlpha(): string {
    const alpha = Math.round(this.settings.homeBgOpacity * 2.55)
    let hex = alpha.toString(16)
    if (hex.length === 1) {
      hex = `0${hex}`
    }
    return hex
  }

  private logoBold(): FontWeight {
    const style = HOME_LOGO_STYLES[this.settings.homeLogoStyle]
    return style === '粗体' || style === '粗体 斜体' ? FontWeight.Bold : FontWeight.Normal
  }

  private logoItalic(): FontStyle {
    const style = HOME_LOGO_STYLES[this.settings.homeLogoStyle]
    return style === '斜体' || style === '粗体 斜体' ? FontStyle.Italic : FontStyle.Normal
  }

  // 原版 r8/d.java:127-133（i9.d LogoDesignInfo）：宽高都为 0 时只把**高**置 72，宽保持 0；
  // i6/o.java:255-278 的 img.smaller 规则在宽或高为 0 时省略该维度 → 由 124:90 内在比例决定另一维
  private logoWidth(): number {
    if (this.settings.homeLogoWidth !== 0) {
      return this.settings.homeLogoWidth
    }
    return Math.round(this.logoHeight() * 124 / 90)
  }

  private logoHeight(): number {
    if (this.settings.homeLogoHeight !== 0) {
      return this.settings.homeLogoHeight
    }
    // 宽高双 0：高 72（r8/d.java:130-132），宽自动 = 72*124/90 ≈ 99
    if (this.settings.homeLogoWidth === 0) {
      return 72
    }
    return Math.round(this.settings.homeLogoWidth * 90 / 124)
  }

  // 原版 i6/o.java:290-291（z12=夜间，顶层）与 412-413（!z12，落在
  // @media (prefers-color-scheme: light) 块内）两处互补分支各写一次同一条规则，
  // 即任何主题下都会命中：img.smaller/.overlay/.title 恒为 brightness(75%)
  private logoDim(): number {
    return 0.75
  }

  // 原版 r8/d.java:133：圆角按**设置里的声明值** max(宽, 高) 计算（宽为 0 时按 0 参与，
  // 不能用渲染时补出的比例宽，否则默认 99×72 会算成 49.5 而非原版 36）
  private logoDeclHeight(): number {
    if (this.settings.homeLogoHeight !== 0) {
      return this.settings.homeLogoHeight
    }
    return this.settings.homeLogoWidth === 0 ? 72 : 0
  }

  private logoRadius(): number {
    const size = Math.max(this.settings.homeLogoWidth, this.logoDeclHeight())
    return size / 2 * (this.settings.homeLogoCorner / 100)
  }

  // 原版 r8/d.java:113-123：width=d()、height=b()；height==0 → height=(width==0?54:width)；
  // width==0 → width=height。favinfo 默认 1638446 → width=46、height=0 → 46×46
  private favSize(): number {
    if (this.settings.homeFavWidth !== 0) {
      return this.settings.homeFavWidth
    }
    return this.settings.homeFavHeight !== 0 ? this.settings.homeFavHeight : 54
  }

  private favHeight(): number {
    if (this.settings.homeFavHeight !== 0) {
      return this.settings.homeFavHeight
    }
    return this.settings.homeFavWidth !== 0 ? this.settings.homeFavWidth : 54
  }

  private pillRadius(): number {
    if (HOME_PILL_STYLES[this.settings.homePillStyle] === '线条') {
      return 0
    }
    // 原版 r8/d：searchBarRadius = corner% * (strokeWidth + 23)。
    // 原版渲染端是 CSS border-radius，浏览器自动钳制到盒尺寸一半（.search_bar 高 46px → 23px），
    // 描边粗细拉大时圆角值(24~30)全部被钳回 23 —— 这才是原版的实际观感。
    // ArkUI borderRadius 不钳制，超限（默认 corner=100%、stroke=1 → 24 > 23）时
    // 描边跟随畸变圆角错位渲染。补齐钳制语义（HOME_PILL_HEIGHT=46 → 23）。
    return Math.min(
      (this.settings.homePillCorner / 100) * (this.settings.homePillStrokeWidth + 23),
      HOME_PILL_HEIGHT / 2
    )
  }

  // 原版 r8/d.java:109 mVar.P(lVarJ.d())：isNight = 应用夜间模式（w9/k.java:863 d()：nightmode2 1/3）
  private isNight(): boolean {
    return this.settings.isNightActive()
  }

  // 原版 r8/d.java:147 mVar.I(bginfo.c() ? bginfo.d() : y.C(accentColor))：isLight。
  // bginfo=i9.a：bit7(c())=手动明暗覆盖开、bit8(d())=亮。定制页背景图片模式下「主题色」
  // 行（e9.i case3）写 bit7=1 + bit8=zH（暗色→亮/亮色→亮），无覆盖时按 y.C(urlbarcolor)：
  // g6/y.java:290-299，R*.299+G*.587+B*.114 >= 192 → 亮。urlbarcolor 默认 -1 → 恒亮。
  private homeIsLight(): boolean {
    if (this.settings.homeBgImage !== '' && this.settings.homeThemeColor !== '') {
      // 手动明暗覆盖：暗色(dark)=非亮、亮色(light)=亮 —— 原版 bit8 存"亮"布尔
      return this.settings.homeThemeColor === 'light'
    }
    const argb = this.settings.urlbarcolor
    const r = (argb >> 16) & 255
    const g = (argb >> 8) & 255
    const b = argb & 255
    return r * 0.299 + g * 0.587 + b * 0.114 >= 192
  }

  // 搜索框背景（原版 i6/o.java:147-157,213 + r8/d.java:139）：
  // str21 = !isNight ? (isLight ? 黑 : 白) : 白；α = config.n()（searchBarAlpha）
  // 线条样式时 r8/d.java:139 把 config.n() 置 0 → rgba(...,0) 自然透明，非 CSS 特判
  private pillBackground(): ResourceColor {
    if (HOME_PILL_STYLES[this.settings.homePillStyle] === '线条') {
      return Color.Transparent
    }
    const alpha = this.settings.homePillOpacity / 100
    if (this.isNight()) {
      return `rgba(255, 255, 255, ${alpha})`
    }
    return this.homeIsLight()
      ? `rgba(0, 0, 0, ${alpha})`
      : `rgba(255, 255, 255, ${alpha})`
  }

  // 原版 i6/o.java:357-370：#box_container 列数由 min-width 媒体查询逐级覆盖，
  // 命中列数 = floor(视口宽/(item+18)) - (搜索区隐藏 ? 1 : 0)，上限 540/(item+18)
  private favColumns(): number {
    const unit = this.favSize() + 18
    const cap = Math.floor(540 / unit)
    const w = this.vpW > 0 ? this.vpW : this.screenW
    const hidden = HOME_ADV_AREAS[this.settings.homeAdvArea] === '展示' ? 0 : 1
    const fit = Math.floor(w / unit) - hidden
    return Math.max(1, Math.min(fit, cap))
  }

  private favColumnsTemplate(): string {
    let tpl = ''
    for (let i = 0; i < this.favColumns(); i++) {
      tpl += '1fr '
    }
    return tpl.trim()
  }

  // 原版 i6/o.java:244-246：body/#content/#gesture-indicator max-width:600px 居中（margin:auto）
  private contentSidePad(): number {
    const w = this.vpW > 0 ? this.vpW : this.screenW
    return Math.max(0, (w - 600) / 2)
  }

  // 原版 i6/o.java:371-379：#content top —— 搜索区隐藏时固定 18px，否则按屏高分档
  // 分档依据是 WebView 视口高（min-height 媒体查询），非物理屏幕高
  private contentTopOffset(): Length {
    if (HOME_ADV_AREAS[this.settings.homeAdvArea] === '隐藏') {
      return 18
    }
    const h = this.vpH > 0 ? this.vpH : this.screenH
    if (h >= 850) {
      return 255
    }
    if (h >= 650) {
      return 195
    }
    if (h >= 450) {
      return 135
    }
    if (h >= 350) {
      return 87
    }
    if (h >= 250) {
      return 62
    }
    return '25%'
  }

  // 原版 qa/e1.java:178-198：弹层高度 clamp(导航栏+屏高/2, 导航栏+168, 导航栏+60%屏高)
  private editorSheetHeight(): number {
    const nav = this.insets.bottom
    const def = nav + this.screenH / 2
    const lo = nav + 168
    const hi = nav + this.screenH * 3 / 5
    return Math.round(Math.min(Math.max(def, lo), hi))
  }

  private pillBorder(): BorderOptions {
    // 原版 i6/o.java:304-316,400-409,502-509,581-590 四处 CSS 拼接一致：
    //   sb.append(!config.p() ? "border-bottom" : "border").append(": <s>px solid <str20>; ...")
    // config.p() = usingLine（i6/m.java:324 p()、i9/e bit24、r8/d.java:138）。
    // 矩形(p()=false) 的 border-bottom 由 build() 里 Stack 底部独立线条复刻
    // （ArkUI .border 单边宽度与 borderRadius 不兼容，会退化成四边描边），此处返回零宽。
    // 线条(p()=true) = "border" 四边 uniform，r8/d.java:139,142 同时 alpha=0、radius=0 → 方角线框。
    if (HOME_PILL_STYLES[this.settings.homePillStyle] !== '线条') {
      return {
        width: 0,
        color: Color.Transparent
      }
    }
    return {
      width: this.settings.homePillStrokeWidth,
      color: this.strokeColor()
    }
  }

  private strokeColor(): string {
    // 原版 i6/o.java:138-145,209：str20 = !isNight ? str13 : string4
    // str13 = rgba(233, 233, 233, r)；string4 = isLight ? rgba(0,0,0,r) : rgba(255,255,255,r)
    // α = config.r()（searchBarStrokeAlpha，r8/d.java:140 ↔ homePillStrokeOpacity）
    // accentColor/config.a() 不参与描边（o.java 全文无 config.a()），主题色绝不用于描边
    const alpha = this.settings.homePillStrokeOpacity / 100
    if (!this.isNight()) {
      return `rgba(233, 233, 233, ${alpha})`
    }
    return this.homeIsLight()
      ? `rgba(0, 0, 0, ${alpha})`
      : `rgba(255, 255, 255, ${alpha})`
  }

  private favRadius(): number {
    // 原版 r8/d:124：收藏圆角按 min(宽,高)
    const size = Math.min(this.favSize(), this.favHeight())
    return size / 2 * (this.settings.homeFavCorner / 100)
  }

  private favColor(item: HomeFavRec): string {
    // 原版：透明=无底色（标题转灰），多彩=网址 MD5 派生色
    if (HOME_FAV_SHADOWS[this.settings.homeFavShadow] === '透明') {
      return ''
    }
    return this.favColors[item.url] ?? ''
  }

  // 原版 .title/.url 文字色 = str17：浅色 #afafaf、深色 #fafafa（与 .logo 同色，即 home_text）
  private favTextColor(): ResourceColor {
    return $r('app.color.home_text')
  }

  private showFavicon(): boolean {
    return HOME_FAV_ICON_STYLES[this.settings.homeFavIconStyle] === '图标优先'
  }

  // 原版 g6/p.a + r8/d.java:82：iconText = 标题首个码点，标题为空即空串（无回退、无占位字）
  private iconText(item: HomeFavRec): string {
    const title = item.title
    if (title === '') {
      return ''
    }
    const cp: number = title.codePointAt(0) ?? 0
    return cp > 0xFFFF ? title.substring(0, 2) : title.substring(0, 1)
  }
}
