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
      // 原版 p4.m3()：预览 FrameLayout（margin 22/16/22/16）内 TextView（padding 32/0/32/0、
      // 字号 dimen ae=18、居中、色 fg=ac）+ 黑色蒙版（Color.argb(progress,0,0,0) 实时刷）；
      // SeekBar margin 16/0/16/16、padding 16/0/16/16、最小轨高 2dp、max 154（k3）。
      // SeekBar 自绘样式 z8.r3.g → x8.h.n/w：轨道 5dp 圆角 #40808080 + accent 进度、
      // 滑块 12dp 圆点 accent；抬起时 Y0 保存（onStopTrackingTouch）。
      Column({ space: 0 }) {
        // 原版蒙版是 FrameLayout foreground（Color.argb(progress,0,0,0) 实时刷），
        // 不参与布局；这里用 overlay 挂在文字上 —— 若放进 Stack 且 height('100%')，
        // 百分比会参考弹窗可用高度把 Stack 撑满全屏、滑杆被挤出屏外（真机已踩坑）
        Text(this.previewText())
          .fontSize(18)
          .fontColor($r('app.color.fg'))
          .textAlign(TextAlign.Center)
          .width('100%')
          .padding({ top: 32, bottom: 32, left: 0, right: 0 })
          .overlay(() => {
            Column()
              .backgroundColor(`rgba(0,0,0,${(this.filterDraft / 255).toFixed(3)})`)
              .width('100%')
              .height('100%')
          })

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
          .onChange((value: number, mode: SliderChangeMode) => {
            const v = Math.round(value)
            this.filterDraft = v
            if (mode === SliderChangeMode.End) {
              // 松手持久化（拖动中已实时写入内存值）
              this.settings.setNightFilter(v)
            } else {
              // 拖动中实时生效：各 TabWeb 的黑色蒙版 alpha 绑定 @Trace nightFilter，实时变化
              this.settings.nightFilter = v
            }
          })
      }
      .width('100%')
    }
  }
}

@Builder
export function SettingsNightPageBuilder() {
  SettingsNightPage()
}
