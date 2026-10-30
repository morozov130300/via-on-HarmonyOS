import { AppSettings } from '../common/Settings'
import { AdBlocker } from '../common/AdBlock'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { BusinessError } from '@kit.BasicServicesKit'
import { common } from '@kit.AbilityKit'

@ComponentV2
export struct RulesPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local rulesDraft: string = ''
  @Local dirty: boolean = false
  private helpDialogId: number = -1

  aboutToAppear(): void {
    this.rulesDraft = this.settings.customRulesText
  }

  private bindAppBar(): void {
    AppBar.show({
      title: '自定义规则',
      rightText2: '帮助',
      rightText: this.dirty ? '保存' : '',
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight: () => {
        this.saveRules()
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
        Text('一个过滤规则一行。')
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .width('100%')
          .padding({ left: 16, right: 16, top: 10, bottom: 6 })
        TextArea({ text: this.rulesDraft, placeholder: '||example.com^\n@@||example.com^' })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .backgroundColor(Color.Transparent)
          .placeholderColor($r('app.color.fg_secondary'))
          .constraintSize({ minHeight: 200 })
          .width('100%')
          .layoutWeight(1)
          .padding({ left: 16, right: 16 })
          .onChange((value: string) => {
            this.rulesDraft = value
            this.dirty = value !== this.settings.customRulesText
            this.bindAppBar()
          })
          .onBlur(() => {
            this.saveRules()
          })
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  private saveRules(): void {
    if (this.rulesDraft === this.settings.customRulesText) {
      return
    }
    this.settings.setCustomRulesText(this.rulesDraft)
    AdBlocker.getInstance().rebuildCustomRules()
    this.dirty = false
    this.bindAppBar()
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.reset_done'), duration: 1500 })
  }

  private showHelp(): void {
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.HelpDialog()
      },
      isModal: true,
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

  @Builder
  HelpDialog() {
    Column({ space: 14 }) {
      Text('帮助')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      Column({ space: 12 }) {
        Text('Via 几乎支持所有的 Adblock Plus 规则。\n你可以这样拦截 example.com 的所有请求：\n||example.com^（或 example.com）')
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
    .width('80%')
    .padding(24)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
  }
}

@Builder
export function RulesPageBuilder() {
  RulesPage()
}
