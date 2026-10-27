import { RuleSubEntry } from '../common/Types'
import { AppSettings } from '../common/Settings'
import { RuleSubManager } from '../common/RuleSubscriptions'
import { AdBlocker } from '../common/AdBlock'
import { SettingsHeader } from '../components/SettingsHeader'
import { BusinessError } from '@kit.BasicServicesKit'

@ComponentV2
export struct SettingsRuleSubPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local updating: boolean = false
  @Local addDialogVisible: boolean = false
  @Local newName: string = ''
  @Local newUrl: string = ''
  private addDialogId: number = -1

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '规则订阅',
          rightText: '更新',
          rightIcon: $r('sys.symbol.plus'),
          onBack: () => {
            this.navPathStack.pop()
          },
          onRight: () => {
            this.updateAll()
          },
          onRight2: () => {
            this.openAddDialog()
          }
        })
        Scroll() {
          Column() {
            Column() {
              Text('自动更新')
                .fontSize(15)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
              Text(this.autoUpdateLabel())
                .fontSize(12)
                .fontColor($r('app.color.fg_secondary'))
                .maxLines(1)
                .margin({ top: 2 })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 13, bottom: 13 })
            .alignItems(HorizontalAlign.Start)
            .onClick(() => {
              this.pickAutoUpdate()
            })

            Text('规则订阅')
              .fontSize(14)
              .fontColor($r('app.color.accent'))
              .width('100%')
              .padding({ left: 16, right: 16, top: 12, bottom: 4 })

            List({ space: 1 }) {
              ForEach(this.settings.ruleSubscriptions, (sub: RuleSubEntry) => {
                ListItem() {
                  Row({ space: 12 }) {
                    Column() {
                      Text(sub.name)
                        .fontSize(15)
                        .fontColor($r('app.color.fg'))
                        .maxLines(1)
                      Text(`${sub.ruleCount} 条规则，${this.lastUpdateLabel(sub.lastUpdate)}`)
                        .fontSize(12)
                        .fontColor($r('app.color.fg_secondary'))
                        .maxLines(1)
                        .margin({ top: 2 })
                    }
                    .alignItems(HorizontalAlign.Start)
                    .layoutWeight(1)
                    .onClick(() => {
                      this.toggleSub(sub)
                    })
                    if (!sub.isPreset) {
                      Text('删除')
                        .fontSize(13)
                        .fontColor($r('app.color.fg_secondary'))
                        .padding(6)
                        .onClick(() => {
                          this.removeSub(sub)
                        })
                    }
                    Circle({ width: 22, height: 22 })
                      .fill(sub.enabled ? $r('app.color.accent') : Color.Transparent)
                      .stroke(sub.enabled ? $r('app.color.accent') : $r('app.color.fg_secondary'))
                      .strokeWidth(1.5)
                      .onClick(() => {
                        this.toggleSub(sub)
                      })
                  }
                  .width('100%')
                  .height(60)
                  .padding({ left: 16, right: 16 })
                }
              }, (sub: RuleSubEntry) => `${sub.key}-${sub.enabled}-${sub.ruleCount}-${sub.lastUpdate}`)
            }
            .width('100%')
            .divider({ strokeWidth: 0.5, color: $r('app.color.divider') })
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
    })
  }

  private autoUpdateLabel(): string {
    if (this.settings.ruleAutoUpdate === 1) {
      return '每天'
    }
    if (this.settings.ruleAutoUpdate === 7) {
      return '每周'
    }
    return '从不'
  }

  private lastUpdateLabel(ts: number): string {
    if (ts === 0) {
      return '从未更新'
    }
    const d = new Date(ts)
    const pad = (n: number): string => n < 10 ? `0${n}` : `${n}`
    return `${d.getFullYear()}-${pad(d.getMonth() + 1)}-${pad(d.getDate())} 更新`
  }

  private pickAutoUpdate(): void {
    const sheets: SheetInfo[] = [
      { title: '从不', action: (): void => {
        this.settings.setRuleAutoUpdate(0)
      } },
      { title: '每天', action: (): void => {
        this.settings.setRuleAutoUpdate(1)
      } },
      { title: '每周', action: (): void => {
        this.settings.setRuleAutoUpdate(7)
      } }
    ]
    ActionSheet.show({
      title: '自动更新',
      message: '自动更新已启用的规则订阅',
      sheets: sheets
    })
  }

  private toggleSub(sub: RuleSubEntry): void {
    const enabled = !sub.enabled
    this.settings.setRuleSubEnabled(sub.key, enabled)
    this.reloadBlocker()
    if (enabled && sub.ruleCount === 0) {
      this.updateOne(sub)
    }
  }

  private removeSub(sub: RuleSubEntry): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    this.settings.removeRuleSub(sub.key)
    RuleSubManager.getInstance().removeSubFiles(context, sub.key)
    this.reloadBlocker()
  }

  private reloadBlocker(): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    RuleSubManager.getInstance().loadEnabledInto(context, this.settings.ruleSubscriptions, AdBlocker.getInstance())
  }

  private updateOne(sub: RuleSubEntry): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined || this.updating) {
      return
    }
    this.updating = true
    RuleSubManager.getInstance().updateSubscription(context, sub).then((count: number) => {
      this.settings.updateRuleSubEntry(sub.key, count, Date.now())
      this.reloadBlocker()
      this.getUIContext().getPromptAction().showToast({ message: `${sub.name} 已更新 ${count} 条规则`, duration: 1500 })
    }).catch((error: BusinessError) => {
      console.error(`update sub failed: ${error.message}`)
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.download_failed'), duration: 1500 })
    }).finally(() => {
      this.updating = false
    })
  }

  private updateAll(): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined || this.updating) {
      return
    }
    const targets: RuleSubEntry[] = []
    for (let i = 0; i < this.settings.ruleSubscriptions.length; i++) {
      if (this.settings.ruleSubscriptions[i].enabled) {
        targets.push(this.settings.ruleSubscriptions[i])
      }
    }
    if (targets.length === 0) {
      this.getUIContext().getPromptAction().showToast({ message: '没有已启用的订阅', duration: 1500 })
      return
    }
    this.updating = true
    const manager = RuleSubManager.getInstance()
    let done = 0
    for (let i = 0; i < targets.length; i++) {
      const sub = targets[i]
      manager.updateSubscription(context, sub).then((count: number) => {
        this.settings.updateRuleSubEntry(sub.key, count, Date.now())
      }).catch((error: BusinessError) => {
        console.error(`update sub failed: ${error.message}`)
      }).finally(() => {
        done = done + 1
        if (done === targets.length) {
          this.updating = false
          this.reloadBlocker()
          this.getUIContext().getPromptAction().showToast({ message: `已更新 ${done} 个订阅`, duration: 1500 })
        }
      })
    }
  }

  private openAddDialog(): void {
    this.newName = ''
    this.newUrl = ''
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.AddSubDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.5)'
    }).then((dialogId: number) => {
      this.addDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open add sub dialog failed: ${error.message}`)
    })
  }

  private closeAddDialog(): void {
    if (this.addDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.addDialogId)
    this.addDialogId = -1
  }

  @Builder
  AddSubDialog() {
    Column({ space: 14 }) {
      Text('添加订阅')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      TextInput({ placeholder: '名称', text: this.newName })
        .width('100%')
        .height(44)
        .fontSize(14)
        .onChange((value: string) => {
          this.newName = value
        })
      TextInput({ placeholder: '规则列表 URL（Adblock Plus 格式）', text: this.newUrl })
        .width('100%')
        .height(44)
        .fontSize(14)
        .onChange((value: string) => {
          this.newUrl = value
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
            const name = this.newName.trim()
            const url = this.newUrl.trim()
            if (url.startsWith('http')) {
              this.settings.addRuleSub(name === '' ? url : name, url)
            }
            this.closeAddDialog()
          })
      }
      .width('100%')
    }
    .width('80%')
    .padding(24)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
  }
}

@Builder
export function SettingsRuleSubPageBuilder() {
  SettingsRuleSubPage()
}
