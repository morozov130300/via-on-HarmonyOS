@ComponentV2
export struct SettingsAboutPage {
  build() {
    NavDestination() {
      Scroll() {
        Column() {
          Column({ space: 6 }) {
            Text('Via')
              .fontSize(24)
              .fontColor($r('app.color.fg'))
            Text('7.3.3')
              .fontSize(14)
              .fontColor($r('app.color.fg_secondary'))
          }
          .width('100%')
          .margin({ top: 60, bottom: 40 })

          this.AboutRow('检查更新', () => {
            this.notImplemented()
          })
          this.AboutRow('加入 QQ 群组', () => {
            this.notImplemented()
          })
          this.AboutRow('通过邮件联系我', () => {
            this.notImplemented()
          })
          this.AboutRow('微信公众号', () => {
            this.notImplemented()
          })
          this.AboutRow('协助翻译', () => {
            this.notImplemented()
          })
          this.AboutRow('使用协议', () => {
            this.notImplemented()
          })
          this.AboutRow('隐私政策', () => {
            this.notImplemented()
          })
          this.AboutRow('开源许可协议', () => {
            this.notImplemented()
          })
          Column() {
            Text('备案号')
              .fontSize(15)
              .fontColor($r('app.color.fg'))
              .maxLines(1)
            Text('沪ICP备2022019616号-3A')
              .fontSize(13)
              .fontColor($r('app.color.fg_secondary'))
              .margin({ top: 2 })
          }
          .width('100%')
          .padding({ left: 16, right: 16, top: 13, bottom: 13 })
          .alignItems(HorizontalAlign.Start)
        }
        .width('100%')
      }
      .width('100%')
      .height('100%')
      .align(Alignment.Top)
    }
    .backgroundColor($r('app.color.page_bg'))
    .title('关于')
  }

  @Builder
  AboutRow(label: string, action: () => void) {
    Text(label)
      .fontSize(15)
      .fontColor($r('app.color.fg'))
      .maxLines(1)
      .width('100%')
      .padding({ left: 16, right: 16, top: 13, bottom: 13 })
      .onClick(() => {
        action()
      })
  }

  private notImplemented(): void {
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.feature_wip'), duration: 1500 })
  }
}

@Builder
export function SettingsAboutPageBuilder() {
  SettingsAboutPage()
}
