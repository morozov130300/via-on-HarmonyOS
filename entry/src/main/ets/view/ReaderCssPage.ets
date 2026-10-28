import { AppSettings } from '../common/Settings'
import { SettingsHeader } from '../components/SettingsHeader'

@ComponentV2
export struct ReaderCssPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local cssText: string = ''

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: $r('app.string.custom_reader_css'),
          rightText: $r('app.string.save'),
          onBack: () => {
            this.navPathStack.pop()
          },
          onRight: () => {
            this.settings.setReaderCustomCss(this.cssText)
            this.getUIContext().getPromptAction().showToast({ message: $r('app.string.save'), duration: 1500 })
          }
        })

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
