import { AppSettings } from '../common/Settings'
import { ViaIcon } from '../components/ViaIcon'

@ComponentV2
export struct ReaderCssPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local cssText: string = ''

  build() {
    NavDestination() {
      Column() {
        Row() {
          ViaIcon({ icon: $r('app.media.via_ic_back'), iconSize: 22, iconColor: $r('app.color.fg') })
            .onClick(() => {
              this.navPathStack.pop()
            })
          Text($r('app.string.custom_reader_css'))
            .fontSize(17)
            .fontWeight(FontWeight.Bold)
            .fontColor($r('app.color.fg'))
            .layoutWeight(1)
            .margin({ left: 4 })
          Text($r('app.string.save'))
            .fontSize(15)
            .fontColor($r('app.color.accent'))
            .padding({ left: 10, right: 4, top: 8, bottom: 8 })
            .onClick(() => {
              this.settings.setReaderCustomCss(this.cssText)
              this.getUIContext().getPromptAction().showToast({ message: $r('app.string.save'), duration: 1500 })
            })
        }
        .width('100%')
        .height(52)
        .padding({ left: 12, right: 12 })

        TextArea({ text: this.cssText, placeholder: 'body { font-family: serif; }' })
          .width('100%')
          .layoutWeight(1)
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .backgroundColor(Color.Transparent)
          .padding(16)
          .onChange((value: string) => {
            this.cssText = value
          })
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.cssText = this.settings.readerCustomCss
    })
  }
}

@Builder
export function ReaderCssPageBuilder() {
  ReaderCssPage()
}
