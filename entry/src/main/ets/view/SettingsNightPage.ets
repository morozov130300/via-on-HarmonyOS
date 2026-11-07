import { i18n } from '@kit.LocalizationKit'
import { AppSettings } from '../common/Settings'
import { SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { dialogTransition } from '../common/Transitions'
import { computeDialogWidthVp } from '../components/ViaDialogCard'

// 原版夜间模式设置页（hb/p4）：
// 行1「网页蒙版滤镜」→ 弹窗（预览文案 + 0~154 滑杆，抬起时保存）
// 行2「强制网页暗色」开关（开启且未启用 JavaScript 时 toast「这将仅在启用 JavaScript 时生效。」）
@ComponentV2
export struct SettingsNightPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local filterDraft: number = 0
  private filterDialogId: number = -1

  private bindAppBar(): void {
    AppBar.show({
      // 原版 p4.a3：标题 u.P = 夜间模式
      title: '夜间模式',
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
      builder: (): void => {
        this.FilterDialog()
      },
      isModal: true,
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
      this.getUIContext().getPromptAction().showToast({ message: '这将仅在启用 JavaScript 时生效。', duration: 1500 })
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
            Row() {
              Column() {
                Text($r('app.string.night_force_dark'))
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                Text($r('app.string.night_force_dark_desc'))
                  .fontSize(12)
                  .fontColor($r('app.color.fg_secondary'))
                  .maxLines(2)
                  .margin({ top: 2 })
              }
              .alignItems(HorizontalAlign.Start)
              .layoutWeight(1)

              Toggle({ type: ToggleType.Switch, isOn: this.settings.nightCss })
                .onChange((isOn: boolean) => {
                  this.toggleForceDark(isOn)
                })
            }
            .width('100%')
            .alignItems(VerticalAlign.Center)
            .padding({ left: 16, right: 16, top: 13, bottom: 13 })
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

  // 原版 p4.m3()：预览文本 + 黑色蒙版（alpha = 滑杆值）+ 滑杆（max 154，抬起保存）
  @Builder
  FilterDialog() {
    Column({ space: 12 }) {
      Stack() {
        Text(this.previewText())
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .textAlign(TextAlign.Center)
          .padding({ top: 22, bottom: 22, left: 16, right: 16 })
        Column()
          .backgroundColor(`rgba(0,0,0,${(this.filterDraft / 255).toFixed(3)})`)
          .width('100%')
          .height('100%')
      }
      .width('100%')

      Slider({ value: this.filterDraft, min: 0, max: 154, step: 1, style: SliderStyle.OutSet })
        .blockColor($r('app.color.accent'))
        .selectedColor($r('app.color.accent'))
        .trackColor($r('app.color.surface'))
        .onChange((value: number, mode: SliderChangeMode) => {
          this.filterDraft = Math.round(value)
          if (mode === SliderChangeMode.End) {
            this.settings.setNightFilter(this.filterDraft)
          }
        })
    }
    .width(computeDialogWidthVp())
    .constraintSize({ maxHeight: 320 })
    .padding({ left: 24, right: 24, top: 16, bottom: 16 })
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(12)
    .shadow({ radius: 24, color: 'rgba(0,0,0,0.35)', offsetY: 4 })
    .transition(dialogTransition())
  }
}

@Builder
export function SettingsNightPageBuilder() {
  SettingsNightPage()
}
