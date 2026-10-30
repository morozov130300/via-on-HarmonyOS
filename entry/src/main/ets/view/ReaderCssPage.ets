import { AppSettings } from '../common/Settings'
import { AppBar, AppBarSpacer } from '../components/AppBar'

@ComponentV2
export struct ReaderCssPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local cssText: string = ''

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.custom_reader_css'),
      rightText: $r('app.string.save'),
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight: () => {
        this.settings.setReaderCustomCss(this.cssText)
        this.getUIContext().getPromptAction().showToast({ message: $r('app.string.save'), duration: 1500 })
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()

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
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }
}

@Builder
export function ReaderCssPageBuilder() {
  ReaderCssPage()
}
