// 主页自定义 CSS 编辑页（视频 119-124s：标题 自定义 CSS + 右上角 保存 + 全屏编辑区）
import { AppSettings } from '../common/Settings'
import { SettingsHeader } from '../components/SettingsHeader'

@ComponentV2
export struct HomeCssPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local cssText: string = ''

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '自定义 CSS',
          rightText: '保存',
          onBack: () => {
            this.navPathStack.pop()
          },
          onRight: () => {
            this.settings.setCustomCss(this.cssText)
            this.getUIContext().getPromptAction().showToast({ message: $r('app.string.save'), duration: 1500 })
          }
        })
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
    })
  }
}

@Builder
export function HomeCssPageBuilder() {
  HomeCssPage()
}
