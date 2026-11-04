// 原版桌面搜索小部件（透明）：resources/r/xml i.xml（appwidget-provider）→ 布局 r/f/a6.xml
// （48dp 高透明搜索条，圆角 18dp，2dp 描边 color ah（日/夜 #ffffff/#efefef），
// 搜索图标 drawable de 24dp、左 16dp、tint color ah）；整条点击 → mark.via.SEARCH。
// 鸿蒙落地：静态卡片，FormLink(router) → EntryAbility，parameters viaCmd = via://search；
// 真实透明背板需 form_config transparencyEnabled + AGC「背板透明卡片」开放能力申请（见任务报告）
@Entry
@ComponentV2
struct TransparentSearchWidgetCard {
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
            .fillColor($r('app.color.widget_bar_stroke'))
        }
        .width('100%')
        .height(48)
        .borderRadius(18)
        .border({ width: 2, color: $r('app.color.widget_bar_stroke') })
        .alignItems(VerticalAlign.Center)
      }
      .width('100%')
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
  }
}
