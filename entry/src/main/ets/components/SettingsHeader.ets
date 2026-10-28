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

  build() {
    Row() {
      ViaIcon({ icon: $r('app.media.via_ic_back'), iconSize: 22, iconColor: $r('app.color.fg') })
        .width(44)
        .height(43)
        .onClick(() => {
          this.onBack()
        })

      Text(this.headerTitle)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .layoutWeight(1)
        .textAlign(TextAlign.Center)

      if (this.rightIcon2 !== null) {
        ViaIcon({ icon: this.rightIcon2, iconSize: 22, iconColor: $r('app.color.fg') })
          .width(44)
          .height(43)
          .onClick(() => {
            this.onRight2()
          })
      } else if (this.rightText2 !== '') {
        Text(this.rightText2)
          .fontSize(15)
          .fontColor($r('app.color.fg'))
          .padding({ left: 12, right: 12 })
          .onClick(() => {
            this.onRight2()
          })
      }
      if (this.rightIcon !== null) {
        ViaIcon({ icon: this.rightIcon, iconSize: 22, iconColor: $r('app.color.fg') })
          .width(44)
          .height(43)
          .onClick(() => {
            this.onRight()
          })
      } else if (this.rightText !== '') {
        Text(this.rightText)
          .fontSize(15)
          .fontColor($r('app.color.fg'))
          .padding({ left: 12, right: 16 })
          .onClick(() => {
            this.onRight()
          })
      } else {
        Blank()
          .width(44)
      }
    }
    .width('100%')
    .height(43 + this.insets.top)
    .padding({ top: this.insets.top })
  }
}
