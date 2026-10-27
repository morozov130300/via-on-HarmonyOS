@ComponentV2
export struct LinkInterstitial {
  @Param @Require linkUrl: string
  @Event onConfirm: () => void = () => {}
  @Event onClose: () => void = () => {}

  build() {
    Stack() {
      Column()
        .width('100%')
        .height('100%')
        .backgroundColor('#66000000')
        .onClick(() => {
          this.onClose()
        })
      Column({ space: 14 }) {
        Text($r('app.string.link_interstitial_title'))
          .fontSize(17)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
        Text(this.linkUrl)
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .maxLines(3)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
          .width('100%')
        Row({ space: 12 }) {
          Button($r('app.string.cancel'))
            .fontSize(15)
            .layoutWeight(1)
            .backgroundColor($r('app.color.surface'))
            .fontColor($r('app.color.fg'))
            .onClick(() => {
              this.onClose()
            })
          Button($r('app.string.link_interstitial_continue'))
            .fontSize(15)
            .layoutWeight(1)
            .backgroundColor($r('app.color.accent'))
            .fontColor(Color.White)
            .onClick(() => {
              this.onConfirm()
            })
        }
        .width('100%')
      }
      .padding(20)
      .backgroundColor($r('app.color.page_bg'))
      .borderRadius(16)
      .margin({ left: 32, right: 32 })
    }
    .width('100%')
    .height('100%')
  }
}
