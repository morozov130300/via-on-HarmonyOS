import { AppSettings } from '../common/Settings'
import { dialogTransition } from '../common/Transitions'
import { AdBlocker, isValidRuleLine } from '../common/AdBlock'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'
import { BusinessError } from '@kit.BasicServicesKit'
import { common } from '@kit.AbilityKit'
import { computeDialogWidthVp } from '../components/UiaDialogCard'

@ComponentV2
export struct RulesPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local rulesDraft: string = ''
  @Local dirty: boolean = false
  @Local invalidLinesText: string = ''
  private helpDialogId: number = -1
  private unsavedDialogId: number = -1
  private invalidDialogId: number = -1

  aboutToAppear(): void {
    this.rulesDraft = this.settings.customRulesText
  }

  private bindAppBar(): void {
    AppBar.show({
      title: '自定义规则',
      rightText2: '帮助',
      rightText: '保存',
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight: () => {
        // 原版 z7.v.x3：未改动直接退出；有改动走校验保存退出
        if (!this.dirty) {
          this.navPathStack.pop()
          return
        }
        this.validateSaveExit()
      },
      onRight2: () => {
        this.showHelp()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        // 原版 z7.v.n3：hint = ot「一个过滤规则一行。」，等宽字体，顶部对齐
        TextArea({ text: this.rulesDraft, placeholder: '一个过滤规则一行。' })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .fontFamily('monospace')
          .backgroundColor(Color.Transparent)
          .placeholderColor($r('app.color.fg_secondary'))
          .constraintSize({ minHeight: 200 })
          .width('100%')
          .layoutWeight(1)
          .padding({ left: 16, right: 16, top: 12 })
          .onChange((value: string) => {
            this.rulesDraft = value
            this.dirty = value !== this.settings.customRulesText
            this.bindAppBar()
          })
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
    .onBackPressed(() => {
      // 原版 z7.v.l()：未改动放行；有改动弹未保存确认
      if (!this.dirty) {
        return false
      }
      this.showUnsaved()
      return true
    })
  }

  // 原版 z7.v.e3（q0.i() 保存）+ q3/i3（非法行收集与警告）
  private validateSaveExit(): void {
    this.doSave()
    const invalid: string[] = []
    const lines = this.rulesDraft.split('\n')
    for (let i = 0; i < lines.length; i++) {
      const line = lines[i]
      if (line !== '' && line.charAt(0) !== '!' && !isValidRuleLine(line)) {
        invalid.push(line)
      }
    }
    if (invalid.length > 0) {
      // 原版 q3：列表头部插入 jm「下列规则格式不正确：」
      invalid.unshift('下列规则格式不正确：')
      this.invalidLinesText = invalid.join('\n')
      this.showInvalid()
      return
    }
    this.navPathStack.pop()
  }

  private doSave(): void {
    // 原版保存无 toast（q0.i() 写盘 + 重载）
    this.settings.setCustomRulesText(this.rulesDraft)
    AdBlocker.getInstance().rebuildCustomRules()
    this.dirty = false
    this.bindAppBar()
  }

  private showHelp(): void {
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.HelpDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.5)'
    }).then((dialogId: number) => {
      this.helpDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open help dialog failed: ${error.message}`)
    })
  }

  private closeHelp(): void {
    if (this.helpDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.helpDialogId)
    this.helpDialogId = -1
  }

  private openHelpDoc(): void {
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext | undefined
    this.closeHelp()
    if (context === undefined) {
      return
    }
    try {
      context.openLink('https://help.eyeo.com/en/adblockplus/how-to-write-filters')
    } catch (error) {
      console.error('open help doc failed')
    }
  }

  // 原版 z7.v.v3：未保存退出确认弹窗
  private showUnsaved(): void {
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.UnsavedDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: false,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.5)'
    }).then((dialogId: number) => {
      this.unsavedDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open unsaved dialog failed: ${error.message}`)
    })
  }

  private closeUnsaved(): void {
    if (this.unsavedDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.unsavedDialogId)
    this.unsavedDialogId = -1
  }

  // 原版 z7.v.i3：非法行警告弹窗（确定后退出）
  private showInvalid(): void {
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.InvalidDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: false,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.5)'
    }).then((dialogId: number) => {
      this.invalidDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open invalid dialog failed: ${error.message}`)
    })
  }

  private closeInvalid(): void {
    if (this.invalidDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.invalidDialogId)
    this.invalidDialogId = -1
  }

  @Builder
  UnsavedDialog() {
    Column({ space: 14 }) {
      Text('提示')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      Text('修改的内容未保存，是否保存？')
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .width('100%')
      Row() {
        Text('保存并退出')
          .fontSize(14)
          .fontColor($r('app.color.accent'))
          .layoutWeight(1)
          .textAlign(TextAlign.Center)
          .onClick(() => {
            this.closeUnsaved()
            // 原版 sa → w3：保存 + 非法行校验 + 退出
            this.validateSaveExit()
          })
        Text('退出')
          .fontSize(14)
          .fontColor($r('app.color.accent'))
          .layoutWeight(1)
          .textAlign(TextAlign.Center)
          .onClick(() => {
            this.closeUnsaved()
            // 原版 i9 → runnable：不保存直接退出
            this.navPathStack.pop()
          })
      }
      .width('100%')
      .margin({ top: 4 })
    }
    .width('100%')
    .padding(24)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
    .transition(dialogTransition())
  }

  @Builder
  InvalidDialog() {
    Column({ space: 14 }) {
      Text('警告')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      Text(this.invalidLinesText)
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
            this.closeInvalid()
            this.navPathStack.pop()
          })
      }
      .width('100%')
      .margin({ top: 4 })
    }
    .width('100%')
    .padding(24)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
    .transition(dialogTransition())
  }

  @Builder
  HelpDialog() {
    Column({ space: 14 }) {
      Text('帮助')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      Column({ space: 12 }) {
        Text('Uia 几乎支持所有的 Adblock Plus 规则。\n你可以这样拦截 example.com 的所有请求：\n||example.com^（或 example.com）')
          .fontSize(13)
          .fontColor($r('app.color.fg'))
        Text('通配符也是支持的，比如：\n||example.com/js/ads_*.js')
          .fontSize(13)
          .fontColor($r('app.color.fg'))
        Text('你也可以允许指定的请求，例如：\n@@||example.com^')
          .fontSize(13)
          .fontColor($r('app.color.fg'))
        Text('对于网页的元素，规则类似：\nexample.com###ad')
          .fontSize(13)
          .fontColor($r('app.color.fg'))
      }
      .width('100%')
      .alignItems(HorizontalAlign.Start)
      Row() {
        Text('了解更多')
          .fontSize(14)
          .fontColor($r('app.color.accent'))
          .layoutWeight(1)
          .onClick(() => {
            this.openHelpDoc()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.accent'))
          .onClick(() => {
            this.closeHelp()
          })
      }
      .width('100%')
      .margin({ top: 4 })
    }
    .width('100%')
    .padding(24)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
    .transition(dialogTransition())
  }
}

@Builder
export function RulesPageBuilder() {
  RulesPage()
}
