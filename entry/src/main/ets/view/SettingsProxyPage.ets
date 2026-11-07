import { ProxyManager } from '../common/ProxyConfig'
import { dialogTransition } from '../common/Transitions'
import { SettingNavRow, SettingCheckRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { BusinessError } from '@kit.BasicServicesKit'
import { computeDialogWidthVp } from '../components/ViaDialogCard'

// 原版 hb/h5.java：Proxy 设置页（原版该页文案无中文翻译，英文 1:1 保留）
// Enable proxy 开关 / Proxy url 行（点击弹输入） / Reverse bypass rules 开关（d() 为 false 时禁用）
// Add proxy(bypass) rule 行 / 规则分组列表排序 / 点击规则编辑（带删除中立按钮）
// 离开页面（原版 F1）：config 有变化则保存；enabled 则 stop+start 重设，否则 stop
@ComponentV2
export struct SettingsProxyPage {
  private navPathStack: NavPathStack = new NavPathStack()
  private manager: ProxyManager = ProxyManager.getInstance()
  @Local proxyEnabled: boolean = false
  @Local reverse: boolean = false
  @Local proxyUrl: string = ''
  @Local rules: string[] = []
  @Local urlInput: string = ''
  @Local addInput: string = ''
  @Local editInput: string = ''
  @Local editRuleKey: string = ''
  private urlDialogId: number = -1
  private addDialogId: number = -1
  private editDialogId: number = -1

  private bindAppBar(): void {
    AppBar.show({
      title: 'Proxy',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  // 原版 h5.s3()：从 config 刷新界面
  private syncFromConfig(): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    const config = this.manager.getConfig(context)
    this.proxyEnabled = config.enabled
    this.reverse = config.reverseBypassRules
    this.proxyUrl = config.proxyUrl
    this.rules = config.sortedRules()
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // 原版 h5.p3：特性不支持时整页仅一行 Enable Proxy / Proxy is not supported.
            if (!this.manager.isSupported()) {
              Column() {
                Text('Enable Proxy')
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                Text('Proxy is not supported.')
                  .fontSize(12)
                  .fontColor($r('app.color.fg_secondary'))
                  .maxLines(2)
                  .margin({ top: 2 })
              }
              .width('100%')
              .padding({ left: 16, right: 16, top: 13, bottom: 13 })
              .alignItems(HorizontalAlign.Start)
            } else {
              SettingCheckRow({
                rowLabel: 'Enable proxy',
                isChecked: this.proxyEnabled,
                onCheckRow: (isOn: boolean) => {
                  this.toggleEnabled(isOn)
                }
              })
              SettingNavRow({
                rowLabel: 'Proxy url',
                rowValue: this.proxyUrl,
                onTapRow: () => {
                  this.openUrlDialog()
                }
              })
              // 原版 h5.p3：Reverse bypass rules 开关，!d() 时禁用
              Row() {
                Text('Reverse bypass rules')
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .layoutWeight(1)
                Circle({ width: 20, height: 20 })
                  .fill(this.reverse ? $r('app.color.accent') : Color.Transparent)
                  .stroke(this.reverse ? $r('app.color.accent') : $r('app.color.fg_secondary'))
                  .strokeWidth(1.5)
              }
              .width('100%')
              .alignItems(VerticalAlign.Center)
              .padding({ left: 16, right: 16, top: 20, bottom: 20 })
              .opacity(this.manager.isReverseBypassSupported() ? 1 : 0.4)
              .onClick(() => {
                if (this.manager.isReverseBypassSupported()) {
                  this.toggleReverse(!this.reverse)
                }
              })
              SettingNavRow({
                rowLabel: this.reverse ? 'Add proxy rule' : 'Add bypass rule',
                onTapRow: () => {
                  this.openAddDialog()
                }
              })
              if (this.rules.length > 0) {
                Text(this.reverse ? 'Proxy rules' : 'Bypass rules')
                  .fontSize(14)
                  .fontColor($r('app.color.accent'))
                  .width('100%')
                  .padding({ left: 16, right: 16, top: 12, bottom: 4 })
                ForEach(this.rules, (rule: string) => {
                  SettingNavRow({
                    rowLabel: rule,
                    onTapRow: () => {
                      this.openEditDialog(rule)
                    }
                  })
                }, (rule: string) => rule)
              }
            }
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
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.syncFromConfig()
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.syncFromConfig()
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      this.applyOnLeave()
      AppBar.maybeHide(this)
    })
  }

  // 原版 h5.t3()：Enable proxy 开关
  private toggleEnabled(isOn: boolean): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    this.manager.getConfig(context).enabled = isOn
    this.proxyEnabled = isOn
  }

  // 原版 h5.u3()：Reverse bypass rules 开关
  private toggleReverse(isOn: boolean): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    this.manager.getConfig(context).reverseBypassRules = isOn
    this.reverse = isOn
  }

  // 原版 h5.r3()：Proxy url 输入对话框（placeholder socks://127.0.0.1:1080）
  private openUrlDialog(): void {
    this.urlInput = this.proxyUrl
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.UrlDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.5)'
    }).then((dialogId: number) => {
      this.urlDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open proxy url dialog failed: ${error.message}`)
    })
  }

  private closeUrlDialog(): void {
    if (this.urlDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.urlDialogId)
    this.urlDialogId = -1
  }

  // 原版 h5.o3()：添加规则对话框（placeholder *example.com）
  private openAddDialog(): void {
    this.addInput = ''
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.AddRuleDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.5)'
    }).then((dialogId: number) => {
      this.addDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open add proxy rule dialog failed: ${error.message}`)
    })
  }

  private closeAddDialog(): void {
    if (this.addDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.addDialogId)
    this.addDialogId = -1
  }

  // 原版 h5.q3()：编辑规则对话框（OK 保存 / Cancel / 中立按钮删除）
  private openEditDialog(rule: string): void {
    this.editRuleKey = rule
    this.editInput = rule
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.EditRuleDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.5)'
    }).then((dialogId: number) => {
      this.editDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open edit proxy rule dialog failed: ${error.message}`)
    })
  }

  private closeEditDialog(): void {
    if (this.editDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.editDialogId)
    this.editDialogId = -1
  }

  // 原版 h5.F1()：离开页面，config 有变化则保存并即时重设代理
  private applyOnLeave(): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    const config = this.manager.getConfig(context)
    if (config.isChanged()) {
      config.save()
      if (config.enabled) {
        this.manager.stop(context)
        this.manager.start(context)
      } else {
        this.manager.stop(context)
      }
    }
  }

  @Builder
  UrlDialog() {
    Column({ space: 14 }) {
      Text('Proxy url')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      TextInput({ text: this.urlInput, placeholder: 'socks://127.0.0.1:1080' })
        .width('100%')
        .height(44)
        .fontSize(14)
        .placeholderColor($r('app.color.fg_secondary'))
        .onChange((value: string) => {
          this.urlInput = value
        })
      Row({ space: 24 }) {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(15)
          .fontColor($r('app.color.fg_secondary'))
          .padding({ left: 8, right: 8, top: 10, bottom: 10 })
          .onClick(() => {
            this.closeUrlDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(15)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.accent'))
          .padding({ left: 8, right: 8, top: 10, bottom: 10 })
          .onClick(() => {
            const context = this.getUIContext().getHostContext()
            if (context !== undefined) {
              this.manager.getConfig(context).proxyUrl = this.urlInput.trim()
            }
            this.syncFromConfig()
            this.closeUrlDialog()
          })
      }
      .width('100%')
    }
    .width('100%')
    .padding(24)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
    .transition(dialogTransition())
  }

  @Builder
  AddRuleDialog() {
    Column({ space: 14 }) {
      Text(this.reverse ? 'Add proxy rule' : 'Add bypass rule')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      TextInput({ text: this.addInput, placeholder: '*example.com' })
        .width('100%')
        .height(44)
        .fontSize(14)
        .placeholderColor($r('app.color.fg_secondary'))
        .onChange((value: string) => {
          this.addInput = value
        })
      Row({ space: 24 }) {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(15)
          .fontColor($r('app.color.fg_secondary'))
          .padding({ left: 8, right: 8, top: 10, bottom: 10 })
          .onClick(() => {
            this.closeAddDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(15)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.accent'))
          .padding({ left: 8, right: 8, top: 10, bottom: 10 })
          .onClick(() => {
            const context = this.getUIContext().getHostContext()
            if (context !== undefined) {
              this.manager.getConfig(context).addRule(this.addInput.trim())
            }
            this.syncFromConfig()
            this.closeAddDialog()
          })
      }
      .width('100%')
    }
    .width('100%')
    .padding(24)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
    .transition(dialogTransition())
  }

  @Builder
  EditRuleDialog() {
    Column({ space: 14 }) {
      Text(this.reverse ? 'Edit proxy rule' : 'Edit bypass rule')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      TextInput({ text: this.editInput, placeholder: '*example.com' })
        .width('100%')
        .height(44)
        .fontSize(14)
        .placeholderColor($r('app.color.fg_secondary'))
        .onChange((value: string) => {
          this.editInput = value
        })
      Row({ space: 24 }) {
        // 原版 h5.q3 中立按钮 x7.u.f14215x = Delete/删除
        Text($r('app.string.delete'))
          .fontSize(15)
          .fontColor($r('app.color.accent'))
          .padding({ left: 8, right: 8, top: 10, bottom: 10 })
          .onClick(() => {
            const context = this.getUIContext().getHostContext()
            if (context !== undefined) {
              this.manager.getConfig(context).removeRule(this.editRuleKey)
            }
            this.syncFromConfig()
            this.closeEditDialog()
          })
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(15)
          .fontColor($r('app.color.fg_secondary'))
          .padding({ left: 8, right: 8, top: 10, bottom: 10 })
          .onClick(() => {
            this.closeEditDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(15)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.accent'))
          .padding({ left: 8, right: 8, top: 10, bottom: 10 })
          .onClick(() => {
            const context = this.getUIContext().getHostContext()
            if (context !== undefined) {
              const config = this.manager.getConfig(context)
              config.removeRule(this.editRuleKey)
              config.addRule(this.editInput.trim())
            }
            this.syncFromConfig()
            this.closeEditDialog()
          })
      }
      .width('100%')
    }
    .width('100%')
    .padding(24)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
    .transition(dialogTransition())
  }
}

@Builder
export function SettingsProxyPageBuilder() {
  SettingsProxyPage()
}
