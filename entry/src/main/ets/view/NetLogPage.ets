import { AppBar, AppBarSpacer } from '../components/AppBar'

@ComponentV2
export struct NetLogPage {
  private navPathStack: NavPathStack = new NavPathStack()

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.net_log'),
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
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
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }
}

@Builder
export function NetLogPageBuilder() {
  NetLogPage()
}
