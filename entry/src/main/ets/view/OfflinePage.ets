@ComponentV2
export struct OfflinePage {
  private navPathStack: NavPathStack = new NavPathStack()

  build() {
    NavDestination() {
      Column() {
        Text($r('app.string.empty_page_placeholder'))
          .fontSize(14)
          .fontColor($r('app.color.fg_secondary'))
      }
      .width('100%')
      .layoutWeight(1)
      .justifyContent(FlexAlign.Center)
    }
    .backgroundColor($r('app.color.page_bg'))
    .title($r('app.string.offline_page'))
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }
}

@Builder
export function OfflinePageBuilder() {
  OfflinePage()
}
