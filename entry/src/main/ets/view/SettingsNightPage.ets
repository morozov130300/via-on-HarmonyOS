import { TOAST_SHORT } from '../common/ToastDuration'
import { i18n } from '@kit.LocalizationKit'
import { AppSettings } from '../common/Settings'
import { SettingNavRow, SettingCheckRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { dialogTransition } from '../common/Transitions'
import { UiaDialogCard, computeDialogWidthVp } from '../components/UiaDialogCard'
import { buildNavSlide } from './PageTransitions'

// 原版夜间模式设置页（hb/p4）：
// 行1「网页蒙版滤镜」→ 弹窗（预览文案 + 0~154 滑杆，抬起时保存）
// 行2「强制网页暗色」开关（开启且未启用 JavaScript 时 toast「这将仅在启用 JavaScript 时生效。」）
@ComponentV2
export struct SettingsNightPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local filterDraft: number = 0
  private filterDialogId: number = -1

  private bindAppBar(): void {
    AppBar.show({
      // 原版 p4.a3：标题 u.P = 夜间模式
      title: $r('app.string.night_mode'),
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  // 原版 z8.f.c()/h()：CN 地区显示中文文案，否则 Less is more.
  private previewText(): string {
    if (i18n.System.getSystemRegion().toUpperCase() === 'CN') {
      return '莫忧世事兼身事，须著人间比梦间。'
    }
    return 'Less is more.'
  }

  // 原版 p4.p3()：弹「网页蒙版滤镜」预览 + 滑杆
  private openFilterDialog(): void {
    this.filterDraft = this.settings.nightFilter
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.FilterDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center
    }).then((dialogId: number) => {
      this.filterDialogId = dialogId
    }).catch(() => {
      console.error('open night filter dialog failed')
    })
  }

  private closeFilterDialog(): void {
    if (this.filterDialogId >= 0) {
      try {
        this.getUIContext().getPromptAction().closeCustomDialog(this.filterDialogId)
      } catch (error) {
        console.error('close night filter dialog failed')
      }
    }
  }

  // 原版 p4.n3：开启强制网页暗色且未启用 JavaScript 时 toast（u.rs）
  private toggleForceDark(isOn: boolean): void {
    this.settings.setNightCss(isOn)
    if (isOn && !this.settings.jsEnabled) {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.orig_rs'), duration: TOAST_SHORT })
    }
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            SettingNavRow({
              // 原版 p4 行1：u.J8 = 网页蒙版滤镜
              rowLabel: $r('app.string.night_filter_opacity'),
              onTapRow: () => {
                this.openFilterDialog()
              }
            })
            // 原版 p4 行2：a6/n（u.M5 标题 + u.N5 desc）→ a6/o 行视图：
            // 标题 14sp、desc 12sp、右侧 16dp 圆勾选框，行 padding 16/20
            SettingCheckRow({
              rowLabel: $r('app.string.night_force_dark'),
              rowDesc: $r('app.string.night_force_dark_desc'),
              isChecked: this.settings.nightCss,
              onCheckRow: (isOn: boolean) => {
                this.toggleForceDark(isOn)
              }
            })
          }
          .width('100%')
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
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

  // 原版 p4.p3() = w5.k.l(I()).y(m3()).f0()：视图塞进 u.xml 卡片（12dp 上下 Space +
  // t/u 底），无标题无正文无按钮 → 只剩自定义视图 + 上下 12dp 留白
  @Builder
  FilterDialog() {
    UiaDialogCard() {
      // 原版 p4.m3()：预览 FrameLayout（margin 左右22/上下16，r(1,22,16,22,16) 展开）
      // 内 TextView（padding 左右0/上下32、字号 dimen ae=18、居中、色 fg=ac）+ 圆角蒙版
      // （g6.g().c(dimen ae=18dp).h(Color.argb(progress,0,0,0))：四角 18dp 圆角纯色层）；
      // SeekBar margin 左右16/下16/上0、padding 左右16、max 154（k3）。
      // 蒙版合成等价实现：原版 foreground 黑色层盖在预览上 = 每像素 RGB×(1−a)、alpha 不变。
      // 直译两种都翻不了——Stack+height('100%') 被弹窗不定高约束撑满全屏（滑杆挤出屏外），
      // overlay 百分比在该约束下解析为 0（蒙版不渲染，真机已踩坑）。故改背景涂抹：
      // 容器背景 = 蒙版色 + 18dp 圆角，文字 RGB 乘 (1−a) 叠加其上 —— 逐像素等价、无独立图层。
      Column({ space: 0 }) {
        Text(this.previewText())
          .fontSize(14)
          .fontColor(this.previewDimmedColor())
          .textAlign(TextAlign.Center)
          .width('100%')
          .padding({ top: 32, bottom: 32, left: 0, right: 0 })
          .backgroundColor(this.maskRgba())
          .borderRadius(18)
          .margin({ top: 16, bottom: 16, left: 22, right: 22 })

        Slider({
          value: this.filterDraft,
          min: 0,
          max: 154,
          step: 1,
          style: SliderStyle.OutSet
        })
          .blockColor($r('app.color.accent'))
          .trackColor($r('app.color.hc_40808080'))
          .selectedColor($r('app.color.accent'))
          .trackThickness(5)
          .trackBorderRadius(2.5)
          .blockSize({ width: 12, height: 12 })
          .width('100%')
          .padding({ left: 16, right: 16 })
          .margin({ bottom: 16 })
          .onChange((value: number, mode: SliderChangeMode) => {
            // 原版拖动中只刷弹窗内蒙版（onProgressChanged 改 foreground），
            // 抬起时 onStopTrackingTouch → Y0 才持久化并全局生效
            this.filterDraft = Math.round(value)
            if (mode === SliderChangeMode.End) {
              this.settings.setNightFilter(this.filterDraft)
            }
          })
      }
      .width('100%')
    }
  }

  // 预览底色 = 黑色蒙版（alpha = 滑杆值，0~154 对应 0~0.604）
  private maskRgba(): string {
    const a = Math.max(0, Math.min(255, this.filterDraft)) / 255
    return `rgba(0,0,0,${a.toFixed(3)})`
  }

  // 原版蒙版（foreground 黑色层）盖在文字上：合成 = 文字 premultiplied RGB×(1−a)，
  // 文字自身 alpha 通道不变（原版文字色 attr ac：亮 #DE000000 / 暗 #BEFFFFFF）。
  // ArkUI 文字色需要显式 alpha：结果 = #AA·RRGGBB′，AA 不动、RGB 乘 (1−a)。
  private previewDimmedColor(): string {
    const isNight = this.settings.isNightActive()
    const baseAlpha = isNight ? 0xbe : 0xde
    const baseRgb = isNight ? [0xef, 0xef, 0xef] : [0x00, 0x00, 0x00]
    const a = Math.max(0, Math.min(255, this.filterDraft)) / 255
    const to2 = (v: number): string => {
      const h = Math.round(v).toString(16)
      return h.length === 1 ? `0${h}` : h
    }
    return `#${to2(baseAlpha)}${to2(baseRgb[0] * (1 - a))}` +
      `${to2(baseRgb[1] * (1 - a))}${to2(baseRgb[2] * (1 - a))}`
  }
}

@Builder
export function SettingsNightPageBuilder() {
  SettingsNightPage()
}
