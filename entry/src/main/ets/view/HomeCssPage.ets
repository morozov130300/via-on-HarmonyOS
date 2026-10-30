// 主页自定义 CSS 编辑页（视频 119-124s：标题 自定义 CSS + 右上角 保存 + 全屏编辑区）
import { AppSettings } from '../common/Settings'
import { AppBar, AppBarSpacer } from '../components/AppBar'

@ComponentV2
export struct HomeCssPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local cssText: string = ''

  private bindAppBar(): void {
    AppBar.show({
      title: '自定义 CSS',
      rightText: '保存',
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight: () => {
        this.settings.setCustomCss(this.cssText)
        this.getUIContext().getPromptAction().showToast({ message: $r('app.string.save'), duration: 1500 })
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Text('自定义 CSS')
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .width('100%')
          .padding({ left: 16, top: 12, bottom: 4 })
        TextArea({ text: this.cssText })
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
      this.cssText = this.settings.customCss
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
export function HomeCssPageBuilder() {
  HomeCssPage()
}
