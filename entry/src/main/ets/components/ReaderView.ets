import { TtsManager } from '../common/Tts'
import { AppIcon } from './AppIcon'

@ComponentV2
export struct ReaderView {
  @Param @Require content: string
  @Event onClose: () => void = () => {}
  @Event onSpeak: () => void = () => {}
  @Event onStopSpeak: () => void = () => {}
  private tts: TtsManager = TtsManager.getInstance()
  @Local fontSize: number = 18

  build() {
    Column() {
      Row({ space: 16 }) {
        AppIcon({ icon: $r('sys.symbol.xmark'), iconSize: 22 })
          .onClick(() => {
            this.onStopSpeak()
            this.onClose()
          })
        Text($r('app.string.reader_mode'))
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
          .layoutWeight(1)
        AppIcon({ icon: this.tts.speaking ? $r('sys.symbol.speaker_slash') : $r('sys.symbol.speaker_wave_3'), iconSize: 20 })
          .onClick(() => {
            if (this.tts.speaking) {
              this.onStopSpeak()
            } else {
              this.onSpeak()
            }
          })
        Text('A-')
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .onClick(() => {
            if (this.fontSize > 12) {
              this.fontSize = this.fontSize - 2
            }
          })
        Text('A+')
          .fontSize(17)
          .fontColor($r('app.color.fg_secondary'))
          .onClick(() => {
            if (this.fontSize < 32) {
              this.fontSize = this.fontSize + 2
            }
          })
      }
      .width('100%')
      .height(48)
      .padding({ left: 14, right: 14 })

      Scroll() {
        Text(this.content)
          .fontSize(this.fontSize)
          .fontColor($r('app.color.fg'))
          .lineHeight(this.fontSize * 1.7)
          .padding(16)
          .width('100%')
          .textAlign(TextAlign.Start)
      }
      .layoutWeight(1)
      .align(Alignment.Top)
      .edgeEffect(EdgeEffect.Spring)
    }
    .width('100%')
    .height('100%')
    .backgroundColor($r('app.color.page_bg'))
  }
}
