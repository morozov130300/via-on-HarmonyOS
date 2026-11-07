import { AppSettings } from '../common/Settings'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { computeDialogWidthVp } from '../components/ViaDialogCard'
import { dialogTransition } from '../common/Transitions'
import { buildNavSlide } from './PageTransitions'

// 原版 hb/i1（由 hb/o5.l3 打开）：全屏 EditText 编辑页
// 标题 = N2「自定义阅读模式 CSS」，hint 同 N2，等宽字体 14sp，内容预填当前值；
// 工具栏唯一动作 Z=「保存」：内容有变则保存并退出，无变化直接退出；
// 返回时内容有变则弹确认（g6 提示 / nt 修改的内容未保存，是否保存？/
// sa 保存并退出 / i9 退出），无变化直接退出
@ComponentV2
export struct ReaderCssPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local cssText: string = ''
  @Local savedCss: string = ''
  private unsavedDialogId: number = -1

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.custom_reader_css'),
      rightText: $r('app.string.save'),
      onBack: () => {
        this.onExitRequested()
      },
      onRight: () => {
        this.saveAndExit()
      }
    }, this)
  }

  private isUnchanged(): boolean {
    return this.cssText === this.savedCss
  }

  // 原版 hb/i1.j3(false)：保存并退出（无变化时不写存储直接退出）
  private saveAndExit(): void {
    if (!this.isUnchanged()) {
      this.settings.setReaderCustomCss(this.cssText)
    }
    this.navPathStack.pop()
  }

  // 原版 hb/i1.V2→j3(true)：返回时内容有变则弹确认
  private onExitRequested(): void {
    if (this.isUnchanged()) {
      this.navPathStack.pop()
      return
    }
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.UnsavedDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.unsavedDialogId = dialogId
    }).catch(() => {
      console.error('open unsaved css dialog failed')
    })
  }

  private closeUnsavedDialog(): void {
    if (this.unsavedDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.unsavedDialogId)
    this.unsavedDialogId = -1
  }

  // 原版 hb/i1.j3(true) 弹窗：w5.k.l().d0(g6 提示).I(nt 修改的内容未保存，是否保存？)
  // .V(sa 保存并退出).N(i9 退出).f0()，样式 = w5.k 卡片（layout u.xml）
  @Builder
  UnsavedDialog() {
    Column() {
      Text($r('app.string.ai_unsaved_title'))
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Text($r('app.string.ai_unsaved_msg'))
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .lineHeight(21)
        .width('100%')
        .padding({ left: 16, right: 16, top: 8, bottom: 8 })
      Row() {
        Blank()
        Text($r('app.string.exit_app'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeUnsavedDialog()
            this.navPathStack.pop()
          })
        Text($r('app.string.ai_save_and_exit'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeUnsavedDialog()
            this.saveAndExit()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16, top: 12 })
    }
    .width('100%')
    .constraintSize({ maxWidth: 300 })
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()

        // 原版 hb/i1.e3/Z2：多行 EditText，gravity top，14sp（x8.h.r），
        // code=true → 等宽字体，pad 16，hint = N2 文案
        TextArea({ text: this.cssText, placeholder: $r('app.string.custom_reader_css') })
          .width('100%')
          .layoutWeight(1)
          .fontSize(14)
          .fontFamily('monospace')
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.dialog_hint'))
          .backgroundColor(Color.Transparent)
          .padding(16)
          .align(Alignment.Top)
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
      this.savedCss = this.settings.readerCustomCss
      this.cssText = this.savedCss
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onBackPressed(() => {
      this.onExitRequested()
      return true
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
