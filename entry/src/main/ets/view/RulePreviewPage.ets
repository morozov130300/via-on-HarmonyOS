import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'
import { RuleSubManager } from '../common/RuleSubscriptions'
import { common } from '@kit.AbilityKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { computeDialogWidthVp } from '../components/UiaDialogCard'

// 原版 z7/v0：规则订阅预览页——标题=订阅名（空回退 am「预览」），
// 规则行列表，点击行弹单行「预览」对话框（g6.n.l(W, line)）
@ComponentV2
export struct RulePreviewPage {
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local lines: string[] = []
  @Local title: string = ''
  @Local dialogLine: string = ''
  private lineDialogId: number = -1

  private bindAppBar(): void {
    AppBar.show({
      title: this.title,
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            if (this.lines.length === 0) {
              Text('暂无规则')
                .fontSize(14)
                .fontColor($r('app.color.fg_secondary'))
                .margin({ top: 20 })
                .width('100%')
                .textAlign(TextAlign.Center)
            }
            ForEach(this.lines, (line: string, index: number) => {
              // 原版 v0.a.l：单行文本，点击弹「预览」对话框
              Text(line)
                .fontSize(13)
                .fontColor($r('app.color.fg'))
                .width('100%')
                .maxLines(1)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
                .padding({ left: 16, right: 16, top: 9, bottom: 9 })
                .onClick(() => {
                  this.showLineDialog(line)
                })
            }, (line: string, index: number) => `${index}-${line}`)
          }
          .width('100%')
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
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
      const param: object | undefined = ctx.pathInfo.param === undefined ? undefined : ctx.pathInfo.param as object
      if (param !== undefined) {
        const record = param as Record<string, string>
        const key = record['key'] ?? ''
        this.title = record['title'] !== undefined && record['title'] !== '' ? record['title'] : '预览'
        const context = this.getUIContext().getHostContext() as common.UIAbilityContext
        if (key !== '') {
          this.lines = RuleSubManager.getInstance().readSubLines(context, key)
        }
      } else {
        this.title = '预览'
      }
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  // 原版 v0.a：点击行弹对话框（标题 W 预览 + 单键确定）
  private showLineDialog(line: string): void {
    this.dialogLine = line
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.LineDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.5)'
    }).then((dialogId: number) => {
      this.lineDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open line dialog failed: ${error.message}`)
    })
  }

  private closeLineDialog(): void {
    if (this.lineDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.lineDialogId)
    this.lineDialogId = -1
  }

  @Builder
  LineDialog() {
    Column({ space: 14 }) {
      Text($r('app.string.ai_preview'))
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      Text(this.dialogLine)
        .fontSize(13)
        .fontColor($r('app.color.fg'))
        .width('100%')
      Row() {
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.accent'))
          .layoutWeight(1)
          .textAlign(TextAlign.Center)
          .onClick(() => {
            this.closeLineDialog()
          })
      }
      .width('100%')
      .margin({ top: 4 })
    }
    .width('100%')
    .padding(24)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
  }
}

@Builder
export function RulePreviewPageBuilder() {
  RulePreviewPage()
}
