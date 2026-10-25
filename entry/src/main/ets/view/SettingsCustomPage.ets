@ComponentV2
export struct SettingsCustomPage {
  build() {
    NavDestination() {
      Tabs({ barPosition: BarPosition.End }) {
        TabContent() {
          this.CustomPlaceholder()
        }
        .tabBar('Logo')

        TabContent() {
          this.CustomPlaceholder()
        }
        .tabBar('搜索框')

        TabContent() {
          this.CustomPlaceholder()
        }
        .tabBar('背景')

        TabContent() {
          this.CustomPlaceholder()
        }
        .tabBar('收藏')

        TabContent() {
          this.CustomPlaceholder()
        }
        .tabBar('高级')
      }
      .barHeight(46)
      .vertical(false)
      .scrollable(false)
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .title('定制')
  }

  @Builder
  CustomPlaceholder() {
    Column() {
      Text($r('app.string.feature_wip'))
        .fontSize(14)
        .fontColor($r('app.color.fg_secondary'))
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
  }
}

@Builder
export function SettingsCustomPageBuilder() {
  SettingsCustomPage()
}
