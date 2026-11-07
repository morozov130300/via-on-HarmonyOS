// 无底黑字：透明底 + 纯黑放大镜 #000000 + 纯黑描边 2dp，48dp 圆角 18dp，点击 → via://search。
// 颜色字面量硬编码，固定不跟随日夜；背板透明需 form_config transparencyEnabled: true。
// de.png 为黑色 alpha 蒙版 PNG；官方 Image 文档：fillColor 仅对 SVG 生效，
// PNG 必须 colorFilter 4x5 纯色替换矩阵（归一化 0~1，卡片能力 API 9）。
@Entry
@ComponentV2
struct DarkTransparentSearchWidgetCard {
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
            .colorFilter([
              0, 0, 0, 0, 0,
              0, 0, 0, 0, 0,
              0, 0, 0, 0, 0,
              0, 0, 0, 1, 0
            ])
        }
        .width('100%')
        .height(48)
        .borderRadius(18)
        .border({ width: 2, color: '#000000' })
        .backgroundColor(Color.Transparent)
        .alignItems(VerticalAlign.Center)
      }
      .width('100%')
    }
    .width('100%')
    .height('100%')
    .backgroundColor(Color.Transparent)
    .justifyContent(FlexAlign.Center)
  }
}
