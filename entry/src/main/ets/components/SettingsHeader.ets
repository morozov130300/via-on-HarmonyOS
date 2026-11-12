import { ViaIcon } from './ViaIcon'
import { UiInsets } from '../common/Immersive'

@ComponentV2
export struct SettingsHeader {
  @Param @Require headerTitle: ResourceStr = ''
  @Param rightText: ResourceStr = ''
  @Param rightIcon: Resource | null = null
  @Param rightText2: ResourceStr = ''
  @Param rightIcon2: Resource | null = null
  @Event onBack: () => void = () => {
  }
  @Event onRight: () => void = () => {
  }
  @Event onRight2: () => void = () => {
  }
  private insets: UiInsets = UiInsets.getInstance()
  @Local dividerHeight: number = 1

  aboutToAppear(): void {
    this.dividerHeight = this.getUIContext().px2vp(2)
  }

  build() {
    Column() {
      Row() {
        Stack({ alignContent: Alignment.Center }) {
          ViaIcon({ icon: $r('app.media.uia_ic_back'), iconSize: 22, iconColor: $r('app.color.appbar_icon') })
        }
          .width(48)
          .height(52)
          .padding({ left: 13, right: 13 })
          .margin({ top: 1, bottom: 1 })
          .onClick(() => {
            this.onBack()
          })

        Text(this.headerTitle)
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.appbar_text'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
          .height('100%')
          .alignSelf(ItemAlign.Center)
          .layoutWeight(24)

        Blank()
          .layoutWeight(1)

        if (this.rightIcon2 !== null) {
          Stack({ alignContent: Alignment.Center }) {
            ViaIcon({ icon: this.rightIcon2, iconSize: 22, iconColor: $r('app.color.appbar_icon') })
          }
            .width(48)
            .height(52)
            .padding({ left: 13, right: 13 })
            .margin({ top: 1, bottom: 1 })
            .onClick(() => {
              this.onRight2()
            })
        } else if (this.rightText2 !== '') {
          Text(this.rightText2)
            .fontSize(14)
            .fontColor($r('app.color.appbar_text'))
            .maxLines(1)
            .textCase(TextCase.UpperCase)
            .height(52)
            .padding({ left: 13, right: 13 })
            .margin({ top: 1, bottom: 1 })
            .alignSelf(ItemAlign.Center)
            .onClick(() => {
              this.onRight2()
            })
        }
        if (this.rightIcon !== null) {
          Stack({ alignContent: Alignment.Center }) {
            ViaIcon({ icon: this.rightIcon, iconSize: 22, iconColor: $r('app.color.appbar_icon') })
          }
            .width(48)
            .height(52)
            .padding({ left: 13, right: 13 })
            .margin({ top: 1, bottom: 1 })
            .onClick(() => {
              this.onRight()
            })
        } else if (this.rightText !== '') {
          Text(this.rightText)
            .fontSize(14)
            .fontColor($r('app.color.appbar_text'))
            .maxLines(1)
            .textCase(TextCase.UpperCase)
            .height(52)
            .padding({ left: 13, right: 13 })
            .margin({ top: 1, bottom: 1 })
            .alignSelf(ItemAlign.Center)
            .onClick(() => {
              this.onRight()
            })
        }
      }
      .width('100%')
      .height(54)
      Divider()
        .vertical(false)
        .strokeWidth(this.dividerHeight)
        .color($r('app.color.appbar_divider'))
    }
    .width('100%')
    .padding({ top: this.insets.top })
  }
}
