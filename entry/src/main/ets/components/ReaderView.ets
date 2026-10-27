import { TtsManager } from '../common/Tts'
import { AppIcon } from './AppIcon'
import { AppSettings } from '../common/Settings'
import { webview } from '@kit.ArkWeb'

class ReaderThemeDef {
  bg: string
  fg: string

  constructor(bg: string, fg: string) {
    this.bg = bg
    this.fg = fg
  }
}

const READER_THEMES: ReaderThemeDef[] = [
  new ReaderThemeDef('#121212', '#BEBEBE'),
  new ReaderThemeDef('#7C766B', '#1C1C1C'),
  new ReaderThemeDef('#4C5F50', '#E4E9E4'),
  new ReaderThemeDef('#2E2E30', '#C9C9C9'),
  new ReaderThemeDef('#050505', '#9C9C9C')
]

@ComponentV2
export struct ReaderView {
  @Param @Require content: string
  @Event onClose: () => void = () => {}
  @Event onSpeak: () => void = () => {}
  @Event onStopSpeak: () => void = () => {}
  private tts: TtsManager = TtsManager.getInstance()
  private settings: AppSettings = AppSettings.getInstance()
  private controller: webview.WebviewController = new webview.WebviewController()
  @Local fontSize: number = 17

  aboutToAppear(): void {
    this.fontSize = this.settings.readerFontSize
    this.renderContent()
  }

  private theme(): ReaderThemeDef {
    const theme = READER_THEMES[this.settings.readerTheme]
    return theme !== undefined ? theme : READER_THEMES[0]
  }

  private escapeHtml(text: string): string {
    return text
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;')
  }

  private buildHtml(): string {
    const theme = this.theme()
    const body = this.escapeHtml(this.content).replace(/\n/g, '<br>')
    return '<!DOCTYPE html><html><head><meta name="viewport" content="width=device-width, initial-scale=1">' +
      '<style>body{margin:0;padding:16px;background:' + theme.bg + ';color:' + theme.fg +
      ';font-size:' + this.fontSize + 'px;line-height:1.7;word-break:break-word;}' +
      this.settings.readerCustomCss + '</style></head><body>' + body + '</body></html>'
  }

  private renderContent(): void {
    try {
      this.controller.loadData(this.buildHtml(), 'text/html', 'utf-8')
    } catch (error) {
      console.error('load reader content failed')
    }
  }

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
            if (this.fontSize > 9) {
              this.fontSize = this.fontSize - 1
              this.renderContent()
            }
          })
        Text('A+')
          .fontSize(17)
          .fontColor($r('app.color.fg_secondary'))
          .onClick(() => {
            if (this.fontSize < 30) {
              this.fontSize = this.fontSize + 1
              this.renderContent()
            }
          })
      }
      .width('100%')
      .height(48)
      .padding({ left: 14, right: 14 })

      Web({ src: 'about:blank', controller: this.controller })
        .width('100%')
        .layoutWeight(1)
        .backgroundColor(this.theme().bg)
    }
    .width('100%')
    .height('100%')
    .backgroundColor(this.theme().bg)
  }
}
