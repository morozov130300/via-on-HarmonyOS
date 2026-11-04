// 原版桌面搜索小部件（普通）：resources/r/xml h.xml（appwidget-provider）→ 布局 r/f/a5.xml
// （FrameLayout 48dp 高搜索条，圆角 18dp，底色 color ag（日/夜 #ffffff/#1c1b1d），
// 搜索图标 drawable de 24dp、左 16dp、tint style a_ → color a1 #de000000）；
// 整条点击（RemoteViews.setOnClickPendingIntent(id bf)）→ mark.via.SEARCH 进搜索。
// 鸿蒙落地：静态卡片，FormLink(router) → EntryAbility，parameters viaCmd = via://search
// （原版 SEARCH 语义等价命令，走 DeepLink.parseViaDeepLink → Index ViaCmdKind.SEARCH）
@Entry
@ComponentV2
struct SearchWidgetCard {
  build() {
    Column() {
      FormLink({
        action: 'router',
        abilityName: 'EntryAbility',
        params: { 'viaCmd': 'via://search' }
      }) {
        Row() {
          Image($r('app.media.via_widget_search'))
            .width(24)
            .height(24)
            .margin({ left: 16, right: 16 })
            .fillColor($r('app.color.widget_icon_tint'))
        }
        .width('100%')
        .height(48)
        .borderRadius(18)
        .backgroundColor($r('app.color.widget_bar_bg'))
        .alignItems(VerticalAlign.Center)
      }
      .width('100%')
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
  }
}
