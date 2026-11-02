import { AppSettings } from '../common/Settings'
import { AppBar, AppBarSpacer } from '../components/AppBar'

// 原版实验页（hb/y1，标题 u.R4 = 实验）：
// 「模糊效果」开关（u.cy/u.cz，labflag 位2）
// 皮肤行（u.Tc → lb.k）与「排序方式」开关（z8.l3.f14720a 搜狗皮肤支持）为 Android 平台特性，移植工程未实现
@ComponentV2
export struct SettingsExperimentalPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  private bindAppBar(): void {
    AppBar.show({
      title: '实验',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            Row() {
              Column() {
                Text('模糊效果')
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                Text('为应用启用模糊效果，部分设备可能不支持')
                  .fontSize(12)
                  .fontColor($r('app.color.fg_secondary'))
                  .maxLines(2)
                  .margin({ top: 2 })
              }
              .alignItems(HorizontalAlign.Start)
              .layoutWeight(1)

              Toggle({ type: ToggleType.Switch, isOn: this.settings.isBlurEffect() })
                .onChange((isOn: boolean) => {
                  this.settings.setBlurEffect(isOn)
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
}

@Builder
export function SettingsExperimentalPageBuilder() {
  SettingsExperimentalPage()
}
