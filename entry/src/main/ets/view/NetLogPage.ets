import { SettingsHeader } from '../components/SettingsHeader'

@ComponentV2
export struct NetLogPage {
  private navPathStack: NavPathStack = new NavPathStack()

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: $r('app.string.net_log'),
          onBack: () => {
            this.navPathStack.pop()
          }
        })
        Column() {
          Text($r('app.string.empty_page_placeholder'))
            .fontSize(14)
            .fontColor($r('app.color.fg_secondary'))
        }
        .width('100%')
        .layoutWeight(1)
        .justifyContent(FlexAlign.Center)
      }
      .width('100%')
      .height('100%')
    }
    .hideTitleBar(true)
    .backgroundColor($r('app.color.page_bg'))
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }
}

@Builder
export function NetLogPageBuilder() {
  NetLogPage()
}
