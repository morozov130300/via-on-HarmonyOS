import { TOAST_SHORT } from '../common/ToastDuration'
// 定制页：与原版录屏逐帧对齐——
// 上方实时预览（HomePage），底部「分类标签行」与「参数条目行」；
// 点数值型条目在条目上方展开主题色导轨滑杆实时调节预览；
// 点选项型条目弹单选弹窗（Logo）或循环切换（样式/风格）；
// 背景色/主题色条目展开调色板；清除图标/重置弹确认框；自定义 CSS 跳独立编辑页。
import { HomePage } from '../components/HomePage'
import { AppSettings } from '../common/Settings'
import { BrowserDb } from '../common/Database'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { AppIcon } from '../components/AppIcon'
import { UiaIcon } from '../components/UiaIcon'
import { UiaDialogButton } from '../components/UiaDialogButton'
import { UiInsets } from '../common/Immersive'
import { buildNavSlide } from './PageTransitions'
import { fileIo, picker } from '@kit.CoreFileKit'
import { curves, display } from '@kit.ArkUI'
import { BusinessError } from '@kit.BasicServicesKit'
import {
  HOME_ADV_AREAS,
  HOME_ADV_EFFECTS,
  HOME_BG_COLORS,
  HOME_DIM_MAX,
  HOME_DIM_MIN,
  HOME_FAV_DIM_MAX,
  HOME_FAV_DIM_MIN,
  HOME_FAV_ICON_STYLES,
  HOME_FAV_SHADOWS,
  HOME_LOGO_FONT_MAX,
  HOME_LOGO_FONT_MIN,
  HOME_LOGO_STYLES,
  HOME_PCT_MAX,
  HOME_PCT_MIN,
  HOME_PILL_STYLES,
  HOME_STROKE_MAX
} from '../common/HomeStyle'

const KIND_SLIDER: string = 'slider'
const KIND_ACTION: string = 'action'

// 原版 d9/q.java z3(-1)/z3(id) 收起/展开参数面板：x.r.c(...).d(200).e(x8.h.b())，
// b() = z.b.a(0.2f,0.2f,0.8f,0.8f)；收起位移 = 面板自身高度（滑到 TabBar 背后），
// 展开从下方滑回。对应鸿蒙 cubicBezier(0.2,0.2,0.8,0.8) + translate。
const PANEL_ANIM_MS: number = 200
const PANEL_CURVE: ICurve = curves.cubicBezierCurve(0.2, 0.2, 0.8, 0.8)
// 原版 q.xml 参数面板容器 bj 固定高 136dp（SeekBar 40 + RecyclerView 96）
const PANEL_BOX_HEIGHT: number = 136

// 原版选项文案资源（x7.u.* → values-zh-rCN/strings.xml），HomeStyle 的同名 string 数组
// 供 HomePage 做语义判断用，这里单独持有 Resource 版供定制页显示，避免破坏主页逻辑。
const LOGO_STYLES_R: ResourceStr[] = [
  '', $r('app.string.orig_d0'), $r('app.string.orig_lu'), $r('app.string.orig_bold_italic')
]
const LOGO_TYPES_R: Resource[] = [
  $r('app.string.orig_fd'), $r('app.string.orig_qr'), $r('app.string.orig_y9'),
  $r('app.string.orig_kn'), $r('app.string.orig_oj')
]
const PILL_STYLES_R: Resource[] = [$r('app.string.orig_sv'), $r('app.string.orig_su')]
const FAV_ICON_STYLES_R: Resource[] = [$r('app.string.orig_j5'), $r('app.string.orig_j6')]
const FAV_SHADOWS_R: Resource[] = [$r('app.string.orig_j2'), $r('app.string.orig_j3')]
const ADV_EFFECTS_R: Resource[] = [$r('app.string.orig_ss'), $r('app.string.orig_sr')]
const ADV_AREAS_R: Resource[] = [$r('app.string.orig_t3'), $r('app.string.orig_t2')]

class CustomParam {
  id: string
  icon: Resource
  label: Resource
  kind: string
  min: number = 0
  max: number = 100
  unit: string = ''
  zeroLabel: Resource = $r('app.string.orig_b3')
  // 原版 h9/b 的 zeroValue（e(min, 文案)）：滑杆停在该值即代表「自适应」，存 0。
  // -1 = 无该语义（如圆角值、描边粗细）。
  zeroValue: number = -1
  // 原版部分图标是 <rotate 90°> XML 包裹同一 PNG（a4/a1/a2），移植用旋转角度等价
  rotateDeg: number = 0

  constructor(id: string, icon: Resource, label: Resource, kind: string) {
    this.id = id
    this.icon = icon
    this.label = label
    this.kind = kind
  }
}

@ComponentV2
export struct SettingsCustomPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  private insets: UiInsets = UiInsets.getInstance()
  @Local activeTab: number = 0
  // 原版 d9/q.java RadioGroup checked 态：分类 accent 高亮在点击瞬间切换/清除
  // （clearCheck/check 同步），与面板内容态（activeTab，动画结束才落 -1）分离
  @Local tabHighlight: number = 0
  @Local activeSlider: string = ''
  @Local sliderPos: number = 0
  @Local paletteKey: string = ''
  @Local logoDialogShow: boolean = false
  @Local confirmKind: string = ''
  @Local textDraft: string = ''
  // 与同组弹窗状态一致必须是 @Local：V2 下普通 private 赋值不触发重渲染，
  // 否则选「文字」/「HTML 代码」后 TextInputDialog 永远不出现（点不动）。
  @Local textKind: string = ''
  // 参数面板（滑杆 + 条目行）收起/展开动画：-1 收起态；展开/收起期间保持上一次
  // 有效分类，动画结束才真正切 activeTab，避免内容在动画中途被清空跳变。
  @Local panelTab: number = 0
  @Local panelShift: number = 0
  @Local panelVisible: boolean = true
  // 拖动中的滑杆值镜像：原版 onProgressChanged 只更新 h9.b 条目对象并
  // notifyItemRangeChanged(position) 重绑那一条（数值文本逐帧刷新）；SeekBar 本体
  // 纯手势驱动不被代码回写。移植等价：value 用 sliderPos（滑杆自己的镜像，onChange
  // 不回写它以外的状态），条目数值文本用 dragValue。两者分离才能保证 Slider 组件
  // 不被逐帧重建、accent 进度条/滑块严格跟手（重建会打断手势）。
  @Local dragValue: number = -1

  private tabs: Resource[] = [
    $r('app.string.orig_ud'), $r('app.string.orig_ue'), $r('app.string.orig_ub'),
    $r('app.string.orig_a4'), $r('app.string.orig_tl')
  ]

  // 原版 w5/k.java:657：弹窗宽度 min(屏宽,屏高) - 72dp
  private dialogWidth(): number {
    try {
      const d = display.getDefaultDisplaySync()
      return Math.round(Math.min(d.width / d.densityPixels, d.height / d.densityPixels)) - 72
    } catch (error) {
      return 280
    }
  }

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.customize'),
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      // 全屏弹窗必须显式层叠在主内容之上。NavDestination 只声明「子组件个数：多个」，
      // 并非 Stack 层叠语义；主内容 Column 已 height('100%') 占满，内联的全屏弹窗会被
      // 排到视口之外 → 点「Logo」参数项状态已变但弹窗看不见、点不到（即「点不动」）。
      // 与 OfflinePage 一致：外层 Stack 包裹，后入栈的弹窗覆盖主内容并优先接收点击。
      Stack() {
        Column() {
          AppBarSpacer()
          Column() {
            // 原版预览为带边距圆角描边卡片（非全宽贴合）
            HomePage({ onSearchTap: () => {
            } })
          }
          // 原版 d9/q.java:412-427：scale 0.95 + 18dp 圆角裁切，无描边
          .width('95%')
          .layoutWeight(1)
          .borderRadius(18)
          .backgroundColor($r('app.color.page_bg'))
          .clip(true)

          // 参数面板容器：对应原版 q.xml 的固定 136dp 容器 bj（SeekBar + 条目 RecyclerView
          // 同属一块），z3() 只做 translationY 平移——收起滑到 136 处被带背景色的 TabBar
          // 盖住（无淡出），展开从 160 滑回 0。收起态保持挂载，动画才不跳变。
          Column() {
            this.SliderRail()
            if (this.paletteKey !== '') {
              this.PaletteRow()
            } else {
              this.ParamStrip()
            }
          }
          .width('100%')
          .translate({ y: this.panelShift })
          .visibility(this.panelVisible ? Visibility.Visible : Visibility.None)
          this.TabBar()
        }
        .width('100%')
        .height('100%')

        if (this.logoDialogShow) {
          this.LogoTypeDialog()
        }
        if (this.confirmKind !== '') {
          this.ConfirmDialog()
        }
        if (this.textKind !== '') {
          this.TextInputDialog()
        }
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .translate({ x: this.slideOffset })
    // 原版 g6/i.java:67 = setCustomAnimations(anim/f, anim/g, anim/h, anim/i)，
    // 时长 integer/b=220、accelerate_decelerate —— 改用鸿蒙原生 NavDestination 转场接口
    .customTransition((operation: NavigationOperation, isEnter: boolean):
      Array<NavDestinationTransition> | undefined => {
      return buildNavSlide(operation, isEnter, (value: string): void => {
        this.slideOffset = value
      })
    })
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  // ---------- 分类条目 ----------

  private logoParams(): CustomParam[] {
    const params: CustomParam[] = []
    const logoType = new CustomParam('logo_type', $r('app.media.uia_ic_c_logo_text'), $r('app.string.orig_ud'), KIND_ACTION)
    params.push(logoType)
    // 原版 e9/u.java V2：宽度图标 x7.o.M1=e_（双向箭头，横向 PNG 本体）、
    // 高度 x7.o.f13745m0=a4（同一 e_ 经 <rotate 90°> 包裹 → 竖向）
    params.push(this.dimParam('logo_width', $r('app.media.uia_ic_c_fav_width'), $r('app.string.orig_a1v'), HOME_DIM_MIN, HOME_DIM_MAX, 0))
    params.push(this.dimParam('logo_height', $r('app.media.uia_ic_c_fav_width'), $r('app.string.orig_k8'), HOME_DIM_MIN, HOME_DIM_MAX, 90))
    params.push(this.pctParam('logo_corner', $r('app.media.uia_ic_c_corner'), $r('app.string.orig_en')))
    if (this.settings.homeLogoType === 2) {
      const font = new CustomParam('logo_font', $r('app.media.uia_ic_c_font_size'), $r('app.string.orig_ua'), KIND_SLIDER)
      font.min = HOME_LOGO_FONT_MIN
      font.max = HOME_LOGO_FONT_MAX
      font.unit = 'px'
      params.push(font)
      params.push(new CustomParam('logo_style', $r('app.media.uia_ic_c_font_style'), $r('app.string.orig_jo'), KIND_ACTION))
    }
    return params
  }

  // 原版 h9/b：d(min,max) + e(zeroValue,零值文案)。
  // 滑杆最左 = min，而 min 就是「自适应」哨兵值——原版 W2 里 `j() != k() ? j() : 0`
  // 表示滑杆停在 zeroValue 时存 0（自适应），否则存实际值。
  // Logo 宽高 min=10（e9/u.java:145-146），收藏宽高 min=24（e9/l.java:17-18）。
  // rotateDeg：原版高度条目 = 宽度图标的 <rotate 90°> 包裹（a4.xml），PNG 本体同字节
  private dimParam(id: string, icon: Resource, label: Resource, min: number, max: number, rotateDeg: number = 0): CustomParam {
    const param = new CustomParam(id, icon, label, KIND_SLIDER)
    param.min = min
    param.max = max
    param.unit = 'px'
    param.zeroLabel = $r('app.string.orig_b3')
    param.zeroValue = min
    param.rotateDeg = rotateDeg
    return param
  }

  // 参数条目是纯描述对象（id/图标/标签/区间）：构造时不读 @Trace 设置值。
  // 原版 V2() 同样只构造 h9.a 描述（数值在 h9.b 上，拖动时由 onProgressChanged 逐帧
  // 更新条目对象而非重建列表）。条目数值一律经 displayValue/paramValue 按需读取，
  // 避免拖动某条滑杆时 currentParams() 因读取其它 @Trace 字段而整列重建 → Slider
  // 被销毁重建、accent 脱离手指。
  private pctParam(id: string, icon: Resource, label: Resource): CustomParam {
    const param = new CustomParam(id, icon, label, KIND_SLIDER)
    param.min = HOME_PCT_MIN
    param.max = HOME_PCT_MAX
    param.unit = '%'
    return param
  }

  private searchParams(): CustomParam[] {
    const params: CustomParam[] = []
    params.push(this.pctParam('pill_corner', $r('app.media.uia_ic_c_corner'), $r('app.string.orig_en')))
    // 原版 e9/v.java：不透明度图标 x7.o.f13768u=b3（实心圆角矩形，横向 PNG 本体）
    params.push(this.pctParam('pill_opacity', $r('app.media.uia_ic_c_rect_solid'), $r('app.string.orig_ow')))
    // 描边宽度 x7.o.f13779x1=du（三条渐粗横线）
    const stroke = new CustomParam('pill_stroke_w', $r('app.media.uia_ic_c_stroke_width'), $r('app.string.orig_v3'), KIND_SLIDER)
    stroke.min = 0
    stroke.max = HOME_STROKE_MAX
    stroke.unit = 'px'
    params.push(stroke)
    // 描边不透明度 x7.o.f13776w1=dt（空心圆角矩形，横向）
    params.push(this.pctParam('pill_stroke_o', $r('app.media.uia_ic_c_rect_outline'), $r('app.string.orig_v2')))
    // 搜索框样式 x7.o.f13771v=b4（空心圆角矩形，横向）
    params.push(new CustomParam('pill_style', $r('app.media.uia_ic_c_rect_outline'), $r('app.string.orig_st'), KIND_ACTION))
    return params
  }

  private bgParams(): CustomParam[] {
    const params: CustomParam[] = []
    // 原版 e9/i.java:144：条目名「背景」，点击展开色板；图标 x7.o.f13762s=a1
    // （=b4 空心圆角矩形经 <rotate 90°> → 竖向）
    const bgColor = new CustomParam('bg_color', $r('app.media.uia_ic_c_rect_outline'), $r('app.string.orig_ub'), KIND_ACTION)
    bgColor.rotateDeg = 90
    params.push(bgColor)
    // 原版 e9/i.java:145-147：仅图片背景时追加「主题色」（暗/亮二态）与「不透明度」(0-80)
    // 主题色图标 x7.o.A1=dy（铅笔）
    if (this.settings.homeBgImage !== '') {
      params.push(new CustomParam('theme_color', $r('app.media.uia_ic_c_theme_color'), $r('app.string.orig_yc'), KIND_ACTION))
      // 不透明度图标 x7.o.f13765t=a2（=b3 实心圆角矩形旋转 90° → 竖向）
      const bgOpacity = this.pctParam('bg_opacity', $r('app.media.uia_ic_c_rect_solid'), $r('app.string.orig_ow'))
      bgOpacity.max = 80
      bgOpacity.rotateDeg = 90
      params.push(bgOpacity)
    }
    return params
  }

  private favParams(): CustomParam[] {
    const params: CustomParam[] = []
    // 原版 e9/l.java：宽度 x7.o.M1=e_、高度 x7.o.f13745m0=a4（e_ 旋转 90°）
    params.push(this.dimParam('fav_width', $r('app.media.uia_ic_c_fav_width'), $r('app.string.orig_a1v'), HOME_FAV_DIM_MIN, HOME_FAV_DIM_MAX, 0))
    params.push(this.dimParam('fav_height', $r('app.media.uia_ic_c_fav_width'), $r('app.string.orig_k8'), HOME_FAV_DIM_MIN, HOME_FAV_DIM_MAX, 90))
    params.push(this.pctParam('fav_corner', $r('app.media.uia_ic_c_corner'), $r('app.string.orig_en')))
    params.push(new CustomParam('fav_icon_style', $r('app.media.uia_ic_c_fav_icon_style'), $r('app.string.orig_j4'), KIND_ACTION))
    params.push(new CustomParam('fav_shadow', $r('app.media.uia_ic_c_fav_icon_color'), $r('app.string.orig_j1'), KIND_ACTION))
    return params
  }

  private advParams(): CustomParam[] {
    const params: CustomParam[] = []
    // 原版 e9/y.java 图标：效果=b4（空心圆角矩形）、区域=br、CSS=ay(加号)、
    // 清除图标=bb（垃圾桶）、重置=d4（循环箭头）
    params.push(new CustomParam('adv_effect', $r('app.media.uia_ic_c_rect_outline'), $r('app.string.orig_sq'), KIND_ACTION))
    params.push(new CustomParam('adv_area', $r('app.media.uia_ic_c_adv_area'), $r('app.string.orig_t1'), KIND_ACTION))
    params.push(new CustomParam('adv_css', $r('app.media.uia_ic_c_adv_css'), $r('app.string.orig_et'), KIND_ACTION))
    params.push(new CustomParam('adv_clear', $r('app.media.uia_ic_c_clear_icon'), $r('app.string.orig_j0'), KIND_ACTION))
    params.push(new CustomParam('adv_reset', $r('app.media.uia_ic_c_reset'), $r('app.string.orig_ez'), KIND_ACTION))
    return params
  }

  // 原版 d9/q.java z3()：200ms、插值器 z.b.a(0.2,0.2,0.8,0.8)（x8.h.b()）。
  // 收起 = translationY → 面板高度（136dp 固定容器，滑进 TabBar 底下）；
  // 展开 = 从 160dp 处滑回 0（q.xml 初始 translationY=160dp）。
  // 切换分类时内容直接换、面板不重演入场（原版 z3(id) 同样只补位）。
  private animatePanel(target: number): void {
    const ctx = this.getUIContext()
    // 高亮即时切换：原版点击监听里 check()/clearCheck() 同步执行，不等待 200ms 动画
    this.tabHighlight = target
    if (target < 0) {
      // 收起：滑到面板高度处（TabBar 背景覆盖），结束后隐藏并落 activeTab=-1
      this.activeTab = this.panelTab
      ctx.animateTo({ duration: PANEL_ANIM_MS, curve: PANEL_CURVE }, () => {
        this.panelShift = PANEL_BOX_HEIGHT
      })
      setTimeout(() => {
        this.panelVisible = false
        this.activeTab = -1
      }, PANEL_ANIM_MS)
      return
    }
    this.activeTab = target
    this.panelTab = target
    if (!this.panelVisible) {
      // 展开：置于下方 160dp（q.xml 初始值）滑回 0
      this.panelVisible = true
      this.panelShift = 160
      ctx.animateTo({ duration: PANEL_ANIM_MS, curve: PANEL_CURVE }, () => {
        this.panelShift = 0
      })
      return
    }
    // 已展开时换分类：内容即时切换，无位移动画
    this.panelShift = 0
  }

  private currentParams(): CustomParam[] {
    // 面板收起动画期间/收起态：参数区不渲染内容（对应原版 e9.k.V2 不被调用）
    if (this.activeTab < 0 || this.panelShift !== 0) {
      return []
    }
    if (this.activeTab === 0) {
      return this.logoParams()
    }
    if (this.activeTab === 1) {
      return this.searchParams()
    }
    if (this.activeTab === 2) {
      return this.bgParams()
    }
    if (this.activeTab === 3) {
      return this.favParams()
    }
    return this.advParams()
  }

  // 数值文本：拖动中的条目读 dragValue（等价原版 h9.b.l() + notifyItemChanged 单条重绑），
  // 其余条目读设置值。拖动中 dragValue 只驱动这一条 Text 刷新，Slider 组件不受影响。
  private displayValue(param: CustomParam): ResourceStr {
    if (param.id === this.activeSlider && this.dragValue >= 0) {
      const zeroLabel = param.zeroValue >= 0 && this.dragValue === param.zeroValue
      const unit = param.unit
      return zeroLabel ? $r('app.string.orig_b3') : `${this.dragValue}${unit}`
    }
    return this.paramValue(param)
  }

  private paramValue(param: CustomParam): ResourceStr {
    switch (param.id) {
      case 'logo_type':
        return this.logoTypeResource(this.settings.homeLogoType)
      case 'logo_width':
        return this.settings.homeLogoWidth === 0 ? $r('app.string.orig_b3') : `${this.settings.homeLogoWidth}px`
      case 'logo_height':
        return this.settings.homeLogoHeight === 0 ? $r('app.string.orig_b3') : `${this.settings.homeLogoHeight}px`
      case 'logo_corner':
        return `${this.settings.homeLogoCorner}%`
      case 'logo_font':
        return `${this.settings.homeLogoSize}px`
      case 'logo_style':
        return LOGO_STYLES_R[this.settings.homeLogoStyle]
      case 'pill_corner':
        return `${this.settings.homePillCorner}%`
      case 'pill_opacity':
        return `${this.settings.homePillOpacity}%`
      case 'pill_stroke_w':
        return `${this.settings.homePillStrokeWidth}px`
      case 'pill_stroke_o':
        return `${this.settings.homePillStrokeOpacity}%`
      case 'pill_style':
        return PILL_STYLES_R[this.settings.homePillStyle]
      case 'bg_color':
        if (this.settings.homeBgImage !== '') {
          return $r('app.string.orig_qr')
        }
        return this.settings.homeBgColor === '' ? $r('app.string.orig_fd') : $r('app.string.orig_cn')
      case 'theme_color':
        return this.settings.homeThemeColor === 'dark' ? $r('app.string.orig_yd') : $r('app.string.orig_ye')
      case 'bg_opacity':
        return `${this.settings.homeBgOpacity}%`
      case 'fav_width':
        return this.settings.homeFavWidth === 0 ? $r('app.string.orig_b3') : `${this.settings.homeFavWidth}px`
      case 'fav_height':
        return this.settings.homeFavHeight === 0 ? $r('app.string.orig_b3') : `${this.settings.homeFavHeight}px`
      case 'fav_corner':
        return `${this.settings.homeFavCorner}%`
      case 'fav_icon_style':
        return FAV_ICON_STYLES_R[this.settings.homeFavIconStyle]
      case 'fav_shadow':
        return FAV_SHADOWS_R[this.settings.homeFavShadow]
      case 'adv_effect':
        return ADV_EFFECTS_R[this.settings.homeAdvEffect]
      case 'adv_area':
        return ADV_AREAS_R[this.settings.homeAdvArea]
      default:
        return ''
    }
  }

  private logoTypeResource(index: number): Resource {
    switch (index) {
      case 0: return $r('app.string.orig_fd')
      case 1: return $r('app.string.orig_qr')
      case 2: return $r('app.string.orig_y9')
      case 3: return $r('app.string.orig_kn')
      default: return $r('app.string.orig_oj')
    }
  }

  private sliderValueOf(param: CustomParam): number {
    switch (param.id) {
      // 原版 e9/u.java:145-146：`c(e() == 0 ? 10 : e())`——存 0 时滑杆停在 min（10），不是 72
      case 'logo_width':
        return this.settings.homeLogoWidth === 0 ? HOME_DIM_MIN : this.settings.homeLogoWidth
      case 'logo_height':
        return this.settings.homeLogoHeight === 0 ? HOME_DIM_MIN : this.settings.homeLogoHeight
      case 'logo_corner':
        return this.settings.homeLogoCorner
      case 'logo_font':
        return this.settings.homeLogoSize
      case 'pill_corner':
        return this.settings.homePillCorner
      case 'pill_opacity':
        return this.settings.homePillOpacity
      case 'pill_stroke_w':
        return this.settings.homePillStrokeWidth
      case 'pill_stroke_o':
        return this.settings.homePillStrokeOpacity
      case 'bg_opacity':
        return this.settings.homeBgOpacity
      case 'fav_width':
        return this.settings.homeFavWidth === 0 ? 24 : this.settings.homeFavWidth
      case 'fav_height':
        return this.settings.homeFavHeight === 0 ? 24 : this.settings.homeFavHeight
      case 'fav_corner':
        return this.settings.homeFavCorner
      default:
        return 0
    }
  }

  // 拖动中实时生效（用户要求所有设置项实时生效）：applySlider 更新 dragValue 数值文本镜像，
  // applyLive 直接写 @Trace 设置字段——HomePage 预览/条目数值随拖动逐帧刷新。
  // 这些字段均不被 SliderRail/ParamStrip 的 ForEach 数据源（currentParams）读取，
  // Slider 组件不会因此重建、accent 轨道严格跟手；End/Click 时 commitSlider 持久化。
  private applySlider(param: CustomParam, value: number): void {
    const raw = Math.round(value)
    // 原版 onProgressChanged 的 bVar.l(progress + i())：条目数值对象随拖动逐帧更新，
    // f9/b 重绑时据此刷新数值文本。dragValue 即该逐帧镜像（@Local，只被 ParamStrip
    // 的 displayValue 读取），与 sliderPos（Slider 自己的值）分离。
    this.dragValue = raw
  }

  // 拖动中的实时生效：只写内存 @Trace 字段（预览立即变化），不落盘——
  // 持久化统一延迟到松手（commitSlider），避免拖动全程每帧 preferences flush。
  private applyLive(param: CustomParam, value: number): void {
    const raw = Math.round(value)
    const v = (param.zeroValue >= 0 && raw === param.zeroValue) ? 0 : raw
    switch (param.id) {
      case 'logo_width':
        this.settings.homeLogoWidth = v
        break
      case 'logo_height':
        this.settings.homeLogoHeight = v
        break
      case 'logo_corner':
        this.settings.homeLogoCorner = v
        break
      case 'logo_font':
        this.settings.homeLogoSize = v
        break
      case 'pill_corner':
        this.settings.homePillCorner = v
        break
      case 'pill_opacity':
        this.settings.homePillOpacity = v
        break
      case 'pill_stroke_w':
        this.settings.homePillStrokeWidth = v
        break
      case 'pill_stroke_o':
        this.settings.homePillStrokeOpacity = v
        break
      case 'bg_opacity':
        this.settings.homeBgOpacity = v
        break
      case 'fav_width':
        this.settings.homeFavWidth = v
        break
      case 'fav_height':
        this.settings.homeFavHeight = v
        break
      case 'fav_corner':
        this.settings.homeFavCorner = v
        break
      default:
        break
    }
  }

  // 原版 W2（onStopTrackingTouch）：滑杆停到 zeroValue（=min）时写 0（「自适应」），
  // 其余写实际值；此处才持久化设置（拖动中内存值已由 applyLive 实时写入）。
  private commitSlider(param: CustomParam): void {
    if (this.dragValue < 0) {
      return
    }
    const raw = this.dragValue
    const v = (param.zeroValue >= 0 && raw === param.zeroValue) ? 0 : raw
    switch (param.id) {
      case 'logo_width':
        this.settings.setHomeLogoWidth(v)
        break
      case 'logo_height':
        this.settings.setHomeLogoHeight(v)
        break
      case 'logo_corner':
        this.settings.setHomeLogoCorner(v)
        break
      case 'logo_font':
        this.settings.setHomeLogoSize(v)
        break
      case 'pill_corner':
        this.settings.setHomePillCorner(v)
        break
      case 'pill_opacity':
        this.settings.setHomePillOpacity(v)
        break
      case 'pill_stroke_w':
        this.settings.setHomePillStrokeWidth(v)
        break
      case 'pill_stroke_o':
        this.settings.setHomePillStrokeOpacity(v)
        break
      case 'bg_opacity':
        this.settings.setHomeBgOpacity(v)
        break
      case 'fav_width':
        this.settings.setHomeFavWidth(v)
        break
      case 'fav_height':
        this.settings.setHomeFavHeight(v)
        break
      case 'fav_corner':
        this.settings.setHomeFavCorner(v)
        break
      default:
        break
    }
  }

  private onParamTap(param: CustomParam): void {
    this.paletteKey = ''
    if (param.kind === KIND_SLIDER) {
      if (this.activeSlider === param.id) {
        this.activeSlider = ''
        this.dragValue = -1
        return
      }
      this.activeSlider = param.id
      this.sliderPos = this.sliderValueOf(param)
      // displayValue 从设置值切换到 dragValue 镜像：先置 -1 走 paramValue，
      // 首次 onChange 才接管（避免展开瞬间显示未初始化值）
      this.dragValue = -1
      return
    }
    this.activeSlider = ''
    this.dragValue = -1
    switch (param.id) {
      case 'logo_type':
        this.logoDialogShow = true
        break
      case 'logo_style':
        this.settings.setHomeLogoStyle((this.settings.homeLogoStyle + 1) % HOME_LOGO_STYLES.length)
        break
      case 'pill_style':
        this.settings.setHomePillStyle((this.settings.homePillStyle + 1) % HOME_PILL_STYLES.length)
        break
      case 'bg_color':
        this.paletteKey = this.paletteKey === 'bg' ? '' : 'bg'
        break
      case 'theme_color':
        this.settings.setHomeThemeColor(this.settings.homeThemeColor === 'light' ? 'dark' : 'light')
        break
      case 'bg_image':
        this.pickImage(false)
        break
      case 'fav_icon_style':
        this.settings.setHomeFavIconStyle((this.settings.homeFavIconStyle + 1) % HOME_FAV_ICON_STYLES.length)
        break
      case 'fav_shadow':
        this.settings.setHomeFavShadow((this.settings.homeFavShadow + 1) % HOME_FAV_SHADOWS.length)
        break
      case 'adv_effect':
        this.settings.setHomeAdvEffect((this.settings.homeAdvEffect + 1) % HOME_ADV_EFFECTS.length)
        break
      case 'adv_area':
        this.settings.setHomeAdvArea((this.settings.homeAdvArea + 1) % HOME_ADV_AREAS.length)
        break
      case 'adv_css':
        this.navPathStack.pushPathByName('homeCss', '', true)
        break
      case 'adv_clear':
        this.confirmKind = 'clear'
        break
      case 'adv_reset':
        this.confirmKind = 'reset'
        break
      default:
        break
    }
  }

  // ---------- 视图 ----------

  // 主题色导轨：选中数值条目后在条目上方展开，拖动实时更新预览（实时生效）。
  // Slider 值走本地双向镜像 sliderPos（构造参数非响应式），展开/切换时从设置同步。
  // 拖动中 onChange 走 applySlider（dragValue 数值文本镜像）+ applyLive（写 @Trace
  // 设置字段驱动 HomePage 预览），但两者都不回写参与 SliderRail/ParamStrip 渲染
  // 数据源（currentParams 的条目构造不读设置值）→ Slider 组件不被逐帧重建，
  // accent 进度条/滑块严格跟手。End/Click 时 commitSlider 持久化。
  @Builder
  SliderRail() {
    if (this.activeSlider !== '') {
      Column() {
        ForEach(this.currentParams(), (param: CustomParam) => {
          if (param.id === this.activeSlider) {
            Slider({ value: this.sliderPos, min: param.min, max: param.max, step: 1, style: SliderStyle.OutSet })
              .width('96%')
              .trackColor('#4A4E5C')
              .selectedColor($r('app.color.accent'))
              .blockColor($r('app.color.accent'))
              .trackThickness(2)
              .blockSize({ width: 14, height: 14 })
              .onChange((value: number, mode: SliderChangeMode) => {
                if (mode === SliderChangeMode.End || mode === SliderChangeMode.Click) {
                  // 松手/点击：先落镜像再持久化（applyLive 已在拖动中实时写过内存值）
                  this.sliderPos = value
                  this.applySlider(param, value)
                  this.commitSlider(param)
                } else {
                  // 拖动中：数值文本镜像 + 实时写设置字段（预览即时变化，不落盘）
                  this.applySlider(param, value)
                  this.applyLive(param, value)
                }
              })
          }
        }, (param: CustomParam) => param.id)
      }
      .width('100%')
      .padding({ top: 8, bottom: 2 })
    }
  }

  @Builder
  ParamStrip() {
    Row({ space: 4 }) {
      ForEach(this.currentParams(), (param: CustomParam) => {
        Column({ space: 5 }) {
          // 原版 f9/b.java:45：imageView.setColorFilter(选中 ? accent : 常规文字色)。
          // 图标是带自身 RGB 的 PNG，Image.fillColor 只对 SVG 生效，PNG 会原样渲染成灰色，
          // 必须用 colorFilter（UiaIcon 的等价 SRC_IN 着色）才是原版的深色。
          // rotateDeg 等价原版 <rotate 90°> drawable 包裹（a1/a2/a4）
          UiaIcon({
            icon: param.icon,
            iconSize: 22,
            iconColor: this.activeSlider === param.id ? $r('app.color.accent') : $r('app.color.fg'),
            rotateDeg: param.rotateDeg
          })
          Text(param.label)
            .fontSize(11)
            .fontColor(this.activeSlider === param.id ? $r('app.color.accent') : $r('app.color.fg'))
            .maxLines(1)
          // 原版 f9/b.java:49-55：名称行与数值行同用一套 colorStateList（常规=文字色、选中=accent），
          // 数值行不是次要灰；选中条目图标同染 accent（f9/b.java:45）
          Text(this.displayValue(param))
            .fontSize(10)
            .fontColor(this.activeSlider === param.id ? $r('app.color.accent') : $r('app.color.fg'))
            .maxLines(1)
        }
        .layoutWeight(1)
        .padding({ top: 4, bottom: 4 })
        .alignItems(HorizontalAlign.Center)
        .onClick(() => {
          this.onParamTap(param)
        })
        // ForEach key 只取稳定 id：滑杆拖动时 paramValue 每帧变化，若拼进 key 会被判定整项替换、
        // 销毁重建 item（含 Image 图标）→ 图标闪烁。V2 下 Text(paramValue) 读 @Trace 字段自动局部刷新。
      }, (param: CustomParam) => param.id)
    }
    .width('100%')
    .padding({ left: 6, right: 6 })
  }

  // 背景色/主题色调色板（视频 71-80s）
  @Builder
  PaletteRow() {
    Scroll() {
      Row({ space: 14 }) {
        ForEach(HOME_BG_COLORS, (colorHex: string) => {
          this.PaletteDot(colorHex, colorHex)
        }, (colorHex: string) => colorHex)
        // 原版背景调色板尾部：选择图片色块（点按跳相册选图，与「背景图片」行同一入口）
        if (this.paletteKey === 'bg') {
          Stack() {
            Column()
              .width(30)
              .height(30)
              .borderRadius(6)
              .backgroundColor($r('app.color.surface'))
              .border({ width: 1, color: $r('app.color.fg_tertiary') })
            UiaIcon({ icon: $r('app.media.uia_ic_c_adv_area'), iconSize: 16, iconColor: $r('app.color.fg_secondary') })
            if (this.settings.homeBgImage !== '') {
              Circle({ width: 40, height: 40 })
                .fill(Color.Transparent)
                .stroke($r('app.color.fg'))
                .strokeWidth(1.5)
            }
          }
          .width(44)
          .height(44)
          .onClick(() => {
            this.pickImage(false)
          })
        }
      }
      .padding({ left: 16, right: 16 })
    }
    .scrollable(ScrollDirection.Horizontal)
    .width('100%')
    .height(64)
    .align(Alignment.Center)
  }

  @Builder
  PaletteDot(colorHex: string, key: string) {
    Stack() {
      if (this.paletteDotSelected(colorHex, key)) {
        Circle({ width: 40, height: 40 })
          .fill(Color.Transparent)
          .stroke($r('app.color.fg'))
          .strokeWidth(1.5)
      }
      if (colorHex === '') {
        Circle({ width: 30, height: 30 })
          .fill(Color.Transparent)
          .stroke($r('app.color.fg_secondary'))
          .strokeWidth(1)
      } else {
        Circle({ width: 30, height: 30 })
          .fill(colorHex)
      }
    }
    .width(44)
    .height(44)
    .onClick(() => {
      if (this.paletteKey === 'bg') {
        this.settings.setHomeBgColor(colorHex)
        this.settings.setHomeBgImage('')
      } else {
        this.settings.setHomeThemeColor(colorHex)
      }
    })
  }

  private paletteDotSelected(colorHex: string, key: string): boolean {
    if (this.paletteKey === 'bg') {
      return this.settings.homeBgImage === '' && this.settings.homeBgColor === colorHex
    }
    return this.settings.homeThemeColor === colorHex
  }

  @Builder
  TabBar() {
    Column() {
      Row() {
        ForEach(this.tabs, (tab: Resource, index: number) => {
          Text(tab)
            .fontSize(13)
            // 原版分类高亮 = RadioButton checked（drawable j/k selector：checked→accent，
            // 其余 fg），点击瞬时切换，不参与 200ms 面板动画
            .fontColor(this.tabHighlight === index ? $r('app.color.accent') : $r('app.color.fg'))
            .layoutWeight(1)
            .textAlign(TextAlign.Center)
            .height(40)
            .onClick(() => {
              // 原版 d9/q.java class a：点已选中的分类 = z3(-1) 面板下滑收起并 clearCheck；
              // 点其它分类 z3(id) 面板从下方滑回并切换内容。activeTab=-1 表示收起态。
              this.activeSlider = ''
              this.paletteKey = ''
              if (this.activeTab === index) {
                this.animatePanel(-1)
              } else {
                this.animatePanel(index)
              }
            })
        }, (_tab: Resource, index: number) => index.toString())
      }
      .width('100%')
      .height(44)
      .padding({ bottom: 4 })
    }
    .width('100%')
    // 底部组件避让导航条：容器 padding 把标签行推入安全区，容器自身底色铺满含导航条的
    // 整段（背景不避让），否则导航条那一段没有背景会「缺肉」。与 HistoryPage 底栏一致。
    .padding({ bottom: this.insets.bottom })
    .backgroundColor($r('app.color.page_bg'))
  }

  // ---------- 弹窗 ----------

  // Logo 单选弹窗（视频 3s：默认/图片/文字/HTML 代码/无，左侧单选圆点）
  @Builder
  LogoTypeDialog() {
    Stack({ alignContent: Alignment.Center }) {
      Column() {
        Text($r('app.string.orig_ud'))
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
          .width('100%')
          .padding({ left: 18, top: 16, bottom: 6 })
        ForEach(LOGO_TYPES_R, (_label: Resource, index: number) => {
          Row({ space: 12 }) {
            Circle({ width: 16, height: 16 })
              .fill(this.settings.homeLogoType === index ? $r('app.color.accent') : Color.Transparent)
              .stroke(this.settings.homeLogoType === index ? $r('app.color.accent') : $r('app.color.fg_secondary'))
              .strokeWidth(1.5)
            Text(LOGO_TYPES_R[index])
              .fontSize(14)
              .fontColor($r('app.color.fg'))
          }
          .width('100%')
          .height(38)
          .padding({ left: 18, right: 18 })
          .onClick(() => {
            this.settings.setHomeLogoType(index)
            this.logoDialogShow = false
            if (index === 1) {
              this.pickImage(true)
            } else if (index === 2) {
              this.openTextInput('text')
            } else if (index === 3) {
              this.openTextInput('html')
            }
          })
        }, (_label: Resource, index: number) => index.toString())
      }
      .width(this.dialogWidth())
      .borderRadius(18)
      .border({ width: 1, color: $r('app.color.dialog_border') })
      .backgroundColor($r('app.color.dialog_bg'))
      .padding({ top: 4, bottom: 8 })
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.4)')
    .onClick(() => {
      this.logoDialogShow = false
    })
  }

  // 文字 / HTML 代码输入弹窗（视频 8-10s）
  @Builder
  TextInputDialog() {
    Stack({ alignContent: Alignment.Center }) {
      Column({ space: 12 }) {
        Text(this.textKind === 'html' ? $r('app.string.orig_kn') : $r('app.string.orig_y9'))
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .width('100%')
        TextArea({ text: this.textDraft })
          .fontSize(14)
          .height(this.textKind === 'html' ? 110 : 70)
          .backgroundColor(Color.Transparent)
          .fontColor($r('app.color.fg'))
          .caretColor($r('app.color.accent'))
          .padding(0)
          .onChange((value: string) => {
            this.textDraft = value
          })
        Row() {
          Blank().layoutWeight(1)
          UiaDialogButton({ label: $r('app.string.cancel'), onAction: () => {
            this.textKind = ''
          } })
          UiaDialogButton({ label: $r('app.string.confirm'), onAction: () => {
            if (this.textKind === 'html') {
              this.settings.setHomeLogoHtml(this.textDraft)
              this.settings.setHomeLogoType(3)
            } else {
              this.settings.setHomeLogoText(this.textDraft)
              this.settings.setHomeLogoType(2)
            }
            this.textKind = ''
          } })
        }
        .width('100%')
      }
      .width(this.dialogWidth())
      .padding(16)
      .borderRadius(18)
      .border({ width: 1, color: $r('app.color.dialog_border') })
      .backgroundColor($r('app.color.dialog_bg'))
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.4)')
    .onClick(() => {
      this.textKind = ''
    })
  }

  // 确认弹窗：清除网站图标缓存 / 重置为默认设置
  @Builder
  ConfirmDialog() {
    Stack({ alignContent: Alignment.Center }) {
      Column({ space: 12 }) {
        Text(this.confirmKind === 'clear' ? $r('app.string.orig_dv') : $r('app.string.orig_rw'))
          .fontSize(15)
          .fontColor($r('app.color.fg'))
          .width('100%')
        Text(this.confirmKind === 'clear' ? $r('app.string.orig_dw') : $r('app.string.orig_g8'))
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .width('100%')
        Row() {
          Blank().layoutWeight(1)
          UiaDialogButton({ label: $r('app.string.cancel'), onAction: () => {
            this.confirmKind = ''
          } })
          UiaDialogButton({ label: $r('app.string.confirm'), onAction: () => {
            if (this.confirmKind === 'clear') {
              this.settings.bumpIconEpoch()
              BrowserDb.getInstance().clearHomeFavIcons()
              this.getUIContext().getPromptAction().showToast({ message: $r('app.string.cleared'), duration: TOAST_SHORT })
            } else {
              this.settings.resetHomeStyle()
            }
            this.confirmKind = ''
            this.activeSlider = ''
            this.paletteKey = ''
            // 重置后回到默认分类并确保面板展开（原版 d9.t.q() 末尾触发整页刷新，
            // 面板保持展开态、内容回到默认值）
            this.panelVisible = true
            this.panelShift = 0
            this.panelTab = 0
            this.tabHighlight = 0
            this.activeTab = 0
          } })
        }
        .width('100%')
      }
      .width(this.dialogWidth())
      .padding(16)
      .borderRadius(18)
      .border({ width: 1, color: $r('app.color.dialog_border') })
      .backgroundColor($r('app.color.dialog_bg'))
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.4)')
    .onClick(() => {
      this.confirmKind = ''
    })
  }

  private openTextInput(kind: string): void {
    this.textDraft = kind === 'html' ? this.settings.homeLogoHtml : this.settings.homeLogoText
    this.textKind = kind
  }

  private pickImage(isLogo: boolean): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    try {
      const photoPicker = new picker.PhotoViewPicker(context)
      photoPicker.select({
        MIMEType: picker.PhotoViewMIMETypes.IMAGE_TYPE,
        maxSelectNumber: 1
      }).then((result: picker.PhotoSelectResult) => {
        if (result.photoUris.length === 0) {
          return
        }
        // 原版 z8.b.c()：把 Picker Uri 拷贝为应用私有 png 再落盘，避免临时授权失效
        const dir = `${context.filesDir}/home`
        const dest = `${dir}/${isLogo ? 'logo' : 'bg'}.png`
        try {
          if (!fileIo.accessSync(dir)) {
            fileIo.mkdirSync(dir, true)
          }
          const src = fileIo.openSync(result.photoUris[0], fileIo.OpenMode.READ_ONLY)
          const dst = fileIo.openSync(dest, fileIo.OpenMode.WRITE_ONLY | fileIo.OpenMode.CREATE | fileIo.OpenMode.TRUNC)
          fileIo.copyFileSync(src.fd, dst.fd)
          fileIo.closeSync(dst)
          fileIo.closeSync(src)
        } catch (error) {
          console.error(`copy home image failed: ${(error as BusinessError).message}`)
          return
        }
        if (isLogo) {
          // 原版 e9/u.java:48-50 选图片后宽80/高80/圆角100
          this.settings.setHomeLogoImage(dest)
          this.settings.setHomeLogoWidth(80)
          this.settings.setHomeLogoHeight(80)
          this.settings.setHomeLogoCorner(100)
        } else {
          this.settings.setHomeBgColor('')
          this.settings.setHomeBgImage(dest)
        }
      }).catch((error: BusinessError) => {
        console.error(`pick image failed: ${error.message}`)
      })
    } catch (error) {
      console.error('open photo picker failed')
    }
  }
}

@Builder
export function SettingsCustomPageBuilder() {
  SettingsCustomPage()
}

//以下是预览器使用的，冗余代码，闲时可以删除
@Entry
@ComponentV2
struct SettingsCustomPreview {
  build() {
    Navigation() {
      SettingsCustomPage()
    }
    .hideTitleBar(true)
    .mode(NavigationMode.Stack)
  }
}