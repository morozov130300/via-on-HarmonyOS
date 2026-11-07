// 主页自定义 CSS 编辑页（视频 119-124s：标题 自定义 CSS + 右上角 保存 + 全屏编辑区）
import { AppSettings } from '../common/Settings'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'

@ComponentV2
export struct HomeCssPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
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
        Text($r('app.string.home_css_hint'))
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
    .translate({ x: this.slideOffset })
    // 原版 g6/i.java:67 = setCustomAnimations(anim/f, anim/g, anim/h, anim/i)，
    // 时长 integer/b=220、accelerate_decelerate —— 改用鸿蒙原生 NavDestination 转场接口
    .customTransition((operation: NavigationOperation, isEnter: boolean):
      Array<NavDestinationTransition> | undefined => {
      return buildNavSlide(operation, isEnter, (value: string): void => {
        this.slideOffset = value
      })
    })
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.cssText = this.settings.customCss
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
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
