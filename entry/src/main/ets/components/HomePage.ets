import { display } from '@kit.ArkUI'
import { TabStore } from '../common/TabStore'
import { BrowserDb } from '../common/Database'
import { HomeFavRec } from '../common/Types'
import { hostOf } from '../common/SearchEngines'
import { AppSettings } from '../common/Settings'
import { UiInsets } from '../common/Immersive'
import { ConfigurationConstant, common } from '@kit.AbilityKit'
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
  @Local favs: HomeFavRec[] = []
  @Local favColors: Record<string, string> = {}
  @Local searchShift: number = 0
  @Local searchFade: number = 1
  @Local pullShift: number = 0
  @Local atTop: boolean = true
  @Local scrollY: number = 0
  @Local showEditor: boolean = false
  private insets: UiInsets = UiInsets.getInstance()
  // 屏幕宽高（vp），用于原版按屏宽/屏高的媒体查询分档（i6/o.java、qa/e1.java）
  private screenW: number = 360
  private screenH: number = 780

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
        Column({ space: 10 }) {
          if (HOME_LOGO_TYPES[this.settings.homeLogoType] === '文字') {
            Text(this.settings.homeLogoText)
              .fontSize(this.settings.homeLogoSize)
              .fontColor($r('app.color.home_text'))
              .fontWeight(this.logoBold())
              .fontStyle(this.logoItalic())
              .maxLines(1)
          } else if (HOME_LOGO_TYPES[this.settings.homeLogoType] === '图片'
            && this.settings.homeLogoImage !== '') {
            Image(this.settings.homeLogoImage)
              .width(this.logoWidth())
              .height(this.logoHeight())
              .borderRadius(this.logoRadius())
              .objectFit(ImageFit.Contain)
              .brightness(this.nightDim())
          } else if (HOME_LOGO_TYPES[this.settings.homeLogoType] === 'HTML 代码'
            && this.settings.homeLogoHtml !== '') {
            RichText(this.settings.homeLogoHtml)
              .width(this.logoWidth())
              .height(this.logoHeight())
          } else if (HOME_LOGO_TYPES[this.settings.homeLogoType] === '默认') {
            Image($rawfile('logo.svg'))
              .width(this.logoWidth())
              .height(this.logoHeight())
              .borderRadius(this.logoRadius())
              // 原版 i6/o.java:277 img.smaller 为 object-fit: cover
              .objectFit(ImageFit.Cover)
              .brightness(this.nightDim())
          }
        }
        // 原版 logo 是 <a onclick="window.via.cmd(257)">：点击进入主页定制设置
        .onClick(() => {
          this.onLogoTap()
        })

        // 原版 .search_bar 内 #search_submit 默认 display:none、#search_input value=""（i6/o.java:30-34,300）：
        // 静态主页搜索框是纯描边空 pill，不含图标与占位文字
        Row()
        .height(HOME_PILL_HEIGHT)
        .width('90%')
        .backgroundColor(this.pillBackground())
        .backgroundBlurStyle(this.settings.homeAdvEffect === 1 ? BlurStyle.NONE : BlurStyle.COMPONENT_THICK)
        .borderRadius(this.pillRadius())
        .border(this.pillBorder())
        .stateStyles({
          pressed: {
            .backgroundColor('#20FFFFFF')
            .border({
              width: this.settings.homePillStrokeWidth,
              color: '#20FFFFFF'
            })
          }
        })
        .margin({ top: 15 })
        .justifyContent(FlexAlign.Center)
        .onClick(() => {
          // 原版 triggerSearchBar：内容上滑 72px 渐隐后唤起搜索
          this.animateToSearch()
        })
      }

      if (this.favs.length > 0) {
        Grid() {
          ForEach(this.favs, (item: HomeFavRec) => {
            GridItem() {
                Column({ space: 6 }) {
                  Stack() {
                    // 原版 .title（i6/o.java:350-354）：固定 15px
                  Text(this.shortLabel(item.title, item.url))
                      .fontSize(15)
                      .fontColor(this.favColor(item) === '' ? this.favTextColor() : Color.White)
                      .textAlign(TextAlign.Center)
                      .width('100%')
                      .height('100%')
                      // 原版 i6/o.java:291：夜间 .title 叠加 brightness(75%)
                      .brightness(this.nightDim())
                    if (this.showFavicon() && item.icon !== '') {
                      Image(item.icon)
                        .width('100%')
                        .height('100%')
                        .borderRadius(this.favRadius())
                        .objectFit(ImageFit.Cover)
                        // 原版 i6/o.java:291：夜间 .overlay 叠加 brightness(75%)
                        .brightness(this.nightDim())
                    }
                  }
                  .width(this.favSize())
                  .height(this.favHeight())
                  .borderRadius(this.favRadius())
                  .backgroundColor(this.favColor(item) === '' ? Color.Transparent : this.favColor(item))
                  // 原版每个 box：title + url 两层文本（i6/o.c）
                  Text(item.title !== '' ? item.title : hostOf(item.url))
                    .fontSize(15)
                    .fontColor(this.favTextColor())
                    .maxLines(1)
                    .constraintSize({ maxWidth: 76 })
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                  // 原版 .url（i6/o.java:356）：margin-top 2px、height 20px、line-height 20px、font-size 10px
                  Text(hostOf(item.url))
                    .fontSize(10)
                    .fontColor($r('app.color.fg_secondary'))
                    .height(20)
                    .margin({ top: 2 })
                    .maxLines(1)
                    .constraintSize({ maxWidth: 76 })
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
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
        .rowsGap(8)
        .width(this.favColumns() * this.favSize() + (this.favColumns() - 1) * 18)
        .margin({ top: 28 })
        .height(Math.max(68, Math.ceil(this.favs.length / this.favColumns()) * (this.favHeight() + 60)))
      }

      Blank()
      }
      .translate({ y: this.searchShift + this.pullShift })
      .opacity(Math.min(this.searchFade, 1 - this.pullShift / 98 * 0.9))
      .width('100%')
      .height('100%')
      // 原版 i6/o.java:244-246：body/#content/#gesture-indicator 均 max-width:600px（margin auto 居中）
      .padding({
        top: this.insets.top,
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
    // 原版 initGesture：顶部下拉 0~98px 内容跟手位移+渐隐，松手 >88.2px 唤起搜索
    .parallelGesture(PanGesture({ fingers: 1, direction: PanDirection.Vertical, distance: 5 })
      .onActionStart((event: GestureEvent) => {
        if (!this.atTop || this.searchOpen) {
          return
        }
        this.pullShift = Math.max(0, Math.min(98, event.offsetY))
      })
      .onActionUpdate((event: GestureEvent) => {
        if (!this.atTop || this.searchOpen) {
          return
        }
        this.pullShift = Math.max(0, Math.min(98, event.offsetY))
      })
      .onActionEnd(() => {
        const shift = this.pullShift
        this.getUIContext().animateTo({ duration: 150, curve: Curve.EaseOut }, () => {
          this.pullShift = 0
        })
        if (shift > 88.2) {
          this.onSearchTap()
        }
      }))
  }

  @Builder
  HomeFavSheet() {
    HomeFavEditor({
      onClose: () => {
        this.showEditor = false
      }
    })
  }

  // 原版 triggerSearchBar：内容 translateY(72px) 渐隐 120ms 后唤起原生搜索
  private animateToSearch(): void {
    this.getUIContext().animateTo({ duration: 120, curve: Curve.EaseOut }, () => {
      this.searchShift = 72
      this.searchFade = 0.1
    })
    setTimeout(() => {
      this.onSearchTap()
      this.searchShift = 0
      this.searchFade = 1
    }, 160)
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

  // 原版 i6/o.java:290-291：夜间(img.smaller/.overlay/.title) 叠加 filter: brightness(75%)
  private nightDim(): number {
    return this.settings.isNightActive() ? 0.75 : 1
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

  private favSize(): number {
    // 原版 favinfo 默认解码宽 54（r8/d.java:116-121：宽高为 0 时回退 54）
    return this.settings.homeFavWidth === 0 ? 54 : this.settings.homeFavWidth
  }

  private favHeight(): number {
    return this.settings.homeFavHeight === 0 ? 54 : this.settings.homeFavHeight
  }

  private pillRadius(): number {
    if (HOME_PILL_STYLES[this.settings.homePillStyle] === '线条') {
      return 0
    }
    // 原版 r8.d：searchBarRadius = corner% * (strokeWidth + 23)
    return (this.settings.homePillCorner / 100) * (this.settings.homePillStrokeWidth + 23)
  }

  // 搜索框背景（原版 i6/o.java:146-157 + r8/d.java:139）：
  // 线条样式强制 searchBarAlpha=0；否则浅色 rgba(255,255,255,α)、深色 rgba(0,0,0,α)
  private pillBackground(): ResourceColor {
    if (HOME_PILL_STYLES[this.settings.homePillStyle] === '线条') {
      return Color.Transparent
    }
    const alpha = this.settings.homePillOpacity / 100
    if (this.isDarkHome()) {
      return `rgba(0,0,0,${alpha})`
    }
    return `rgba(255,255,255,${alpha})`
  }

  // 原版 .search_bar color（i6/o.java:158-161,318）：浅色 α>=0.5 → #1b1b1b 否则 #afafaf；深色 #fafafa
  private pillTextColor(): string {
    if (this.isDarkHome()) {
      return '#fafafa'
    }
    return this.settings.homePillOpacity >= 50 ? '#1b1b1b' : '#afafaf'
  }

  // 原版 i6/o.java:357-370：#box_container 列数按屏宽动态，上限 540/(item+18)
  private favColumns(): number {
    const unit = this.favSize() + 18
    const cap = Math.floor(540 / unit)
    const fit = Math.floor(this.screenW / unit)
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
    return Math.max(0, (this.screenW - 600) / 2)
  }

  // 原版 i6/o.java:374-379：#content top 按屏高分档
  private contentTopOffset(): Length {
    if (this.screenH >= 850) {
      return 255
    }
    if (this.screenH >= 650) {
      return 195
    }
    if (this.screenH >= 450) {
      return 135
    }
    if (this.screenH >= 350) {
      return 87
    }
    if (this.screenH >= 250) {
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
    // 原版 i6/o.java:304-316：线条(searchBarLineEnabled)→四边 border；矩形→仅 border-bottom
    if (HOME_PILL_STYLES[this.settings.homePillStyle] === '线条') {
      return {
        width: this.settings.homePillStrokeWidth,
        color: this.strokeColor()
      }
    }
    return {
      width: { bottom: this.settings.homePillStrokeWidth },
      color: this.strokeColor()
    }
  }

  private strokeColor(): string {
    // 原版 i6/o.java:145,309：浅色 rgba(233, 233, 233, α)；深色 rgba(255, 255, 255, α)；主题色自定义时用主题色
    const alpha = this.settings.homePillStrokeOpacity / 100
    const theme = this.settings.homeThemeColor
    if (theme.length >= 7) {
      const r = parseInt(theme.substring(theme.length - 6, theme.length - 4), 16)
      const g = parseInt(theme.substring(theme.length - 4, theme.length - 2), 16)
      const b = parseInt(theme.substring(theme.length - 2), 16)
      if (!Number.isNaN(r) && !Number.isNaN(g) && !Number.isNaN(b)) {
        return `rgba(${r}, ${g}, ${b}, ${alpha})`
      }
    }
    if (this.isDarkHome()) {
      return `rgba(255, 255, 255, ${alpha})`
    }
    return `rgba(233, 233, 233, ${alpha})`
  }

  private isDarkHome(): boolean {
    try {
      const ctx = this.getUIContext().getHostContext() as common.UIAbilityContext
      return ctx.config.colorMode === ConfigurationConstant.ColorMode.COLOR_MODE_DARK
    } catch (error) {
      return false
    }
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

  // 透明样式下标题转灰（原版 CSS 禁用彩色时 .box 标题走灰阶）
  private favTextColor(): ResourceColor {
    if (HOME_FAV_SHADOWS[this.settings.homeFavShadow] === '透明') {
      return $r('app.color.fg_secondary')
    }
    return $r('app.color.home_text')
  }

  private showFavicon(): boolean {
    return HOME_FAV_ICON_STYLES[this.settings.homeFavIconStyle] === '图标优先'
  }

  private shortLabel(title: string, url: string): string {
    const source = title.trim() !== '' ? title : hostOf(url)
    if (source === '') {
      return '书'
    }
    return source.substring(0, 1)
  }
}
