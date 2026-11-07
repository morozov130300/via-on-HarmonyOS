import { RuleSubEntry, RULE_SUB_PRESETS } from '../common/Types'
import { dialogTransition } from '../common/Transitions'
import { AppSettings } from '../common/Settings'
import { RuleSubManager } from '../common/RuleSubscriptions'
import { AdBlocker } from '../common/AdBlock'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { BusinessError, pasteboard } from '@kit.BasicServicesKit'
import { computeDialogWidthVp } from '../components/ViaDialogCard'

const AUTO_UPDATE_DAYS: number[] = [0, 1, 3, 7, 15]
const AUTO_UPDATE_LABELS: string[] = ['从不', '每天', '每 3 天', '每周', '每 15 天']

// z8/u3.a：相对时间（<1 分钟「刚刚」，DateUtils.getRelativeTimeSpanString zh 语义）
export function relativeUpdateTime(ts: number): string {
  const now = Date.now()
  if (ts <= 0 || ts > now) {
    return '从未更新'
  }
  const mins = Math.floor((now - ts) / 60000)
  if (mins < 1) {
    return '刚刚'
  }
  if (mins < 60) {
    return `${mins} 分钟前`
  }
  const hours = Math.floor(mins / 60)
  if (hours < 24) {
    return `${hours} 小时前`
  }
  const days = Math.floor(hours / 24)
  if (days === 1) {
    return '昨天'
  }
  if (days < 7) {
    return `${days} 天前`
  }
  const d = new Date(ts)
  return `${d.getMonth() + 1}月${d.getDate()}日`
}

// 原版 z7/q0.java：规则订阅页
// 列表行：名称 + 「%d 条规则，从未更新/已更新」(ib/g.java) + 启用圆点；点击切换、长按菜单 [预览/更新/编辑/复制链接/删除]（G3/t3）
// 工具栏：＋新建（预设单选 + 自定义，z3/u3/m3）、更新（ch→K3）
@ComponentV2
export struct SettingsRuleSubPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local updating: boolean = false
  @Local newUrl: string = 'https://'
  @Local editUrl: string = ''
  @Local editKey: string = ''
  private addDialogId: number = -1
  private editDialogId: number = -1

  private bindAppBar(): void {
    AppBar.show({
      title: '规则订阅',
      rightText: '更新',
      rightIcon: $r('sys.symbol.plus'),
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight: () => {
        this.updateAll()
      },
      onRight2: () => {
        this.pickToAdd()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
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

            ForEach(this.settings.ruleSubscriptions, (sub: RuleSubEntry) => {
              Row({ space: 12 }) {
                Column() {
                  // 原版 ib/g：名称 MIDDLE 省略
                  Text(sub.name)
                    .fontSize(15)
                    .fontColor($r('app.color.fg'))
                    .maxLines(1)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                    // 原版 ib/g：名称 MIDDLE 省略（ellipsisMode 需配合 Ellipsis 生效）
                    .ellipsisMode(EllipsisMode.CENTER)
                  // 原版 ib/g.java:28：「%1$d，%2$s」（规则数 + 相对更新时间 a0t/k7）
                  Text(`${sub.ruleCount}，${relativeUpdateTime(sub.lastUpdate)}`)
                    .fontSize(12)
                    .fontColor($r('app.color.fg_secondary'))
                    .maxLines(1)
                    .margin({ top: 2 })
                }
                .alignItems(HorizontalAlign.Start)
                .layoutWeight(1)
                // 原版 a6.o.f124k：CheckBox 启用控件
                Checkbox()
                  .select(sub.enabled)
                  .selectedColor($r('app.color.accent'))
                  .onChange((value: boolean) => {
                    if (value === sub.enabled) {
                      return
                    }
                    this.toggleSub(sub)
                  })
              }
              .width('100%')
              .padding({ left: 16, right: 16, top: 11, bottom: 11 })
              .alignItems(VerticalAlign.Center)
              .onClick(() => {
                this.toggleSub(sub)
              })
              .gesture(LongPressGesture()
                .onAction(() => {
                  this.showSubMenu(sub)
                }))
            }, (sub: RuleSubEntry) => `${sub.key}-${sub.enabled}-${sub.ruleCount}-${sub.lastUpdate}`)
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

  private autoUpdateLabel(): string {
    let index = 0
    for (let i = 0; i < AUTO_UPDATE_DAYS.length; i++) {
      if (this.settings.ruleAutoUpdate >= AUTO_UPDATE_DAYS[i]) {
        index = i
      }
    }
    return AUTO_UPDATE_LABELS[index]
  }

  private lastUpdateLabel(ts: number): string {
    return relativeUpdateTime(ts)
  }

  private pickAutoUpdate(): void {
    const sheets: SheetInfo[] = []
    for (let i = 0; i < AUTO_UPDATE_DAYS.length; i++) {
      const days = AUTO_UPDATE_DAYS[i]
      sheets.push({
        title: AUTO_UPDATE_LABELS[i],
        action: (): void => {
          this.settings.setRuleAutoUpdate(days)
        }
      })
    }
    ActionSheet.show({
      title: '自动更新',
      message: '',
      sheets: sheets
    })
  }

  // 原版 G3/t3：长按菜单 [预览(W)/更新(ch)/编辑(D)/复制链接(s)/删除(x)]
  private showSubMenu(sub: RuleSubEntry): void {
    ActionSheet.show({
      title: sub.name,
      message: '',
      sheets: [
        {
          title: '预览',
          action: (): void => {
            this.previewSub(sub)
          }
        },
        {
          title: '更新',
          action: (): void => {
            this.updateOne(sub)
          }
        },
        {
          title: '编辑',
          action: (): void => {
            this.openEditDialog(sub)
          }
        },
        {
          title: '复制链接',
          action: (): void => {
            this.copyLink(sub)
          }
        },
        {
          title: '删除',
          action: (): void => {
            this.confirmRemove(sub)
          }
        }
      ]
    })
  }

  // 原版 t3:0：预览 → 独立预览页（z7/v0，参数 path/title）
  private previewSub(sub: RuleSubEntry): void {
    this.navPathStack.pushPathByName('rulePreview', { 'key': sub.key, 'title': sub.name } as Record<string, string>)
  }

  // 原版 t3:1：更新单条（a0q 开始更新…）
  private updateOne(sub: RuleSubEntry): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined || this.updating) {
      return
    }
    this.getUIContext().getPromptAction().showToast({ message: '开始更新…', duration: 1500 })
    this.updating = true
    RuleSubManager.getInstance().updateSubscription(context, sub).then((count: number) => {
      this.settings.updateRuleSubEntry(sub.key, count, Date.now())
      this.reloadBlocker()
    }).catch((error: BusinessError) => {
      console.error(`update sub failed: ${error.message}`)
    }).finally(() => {
      this.updating = false
    })
  }

  // 原版 K3：更新全部已启用（h3 正在开始下载… → a0k 订阅规则更新完成。）
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
      return
    }
    this.updating = true
    this.getUIContext().getPromptAction().showToast({ message: '正在开始下载…', duration: 1500 })
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
          this.getUIContext().getPromptAction().showToast({ message: '订阅规则更新完成。', duration: 1500 })
        }
      })
    }
  }

  // 原版 z7/q0.F3：点击仅切换启用（无自动下载超集行为）
  private toggleSub(sub: RuleSubEntry): void {
    this.settings.setRuleSubEnabled(sub.key, !sub.enabled)
    this.reloadBlocker()
  }

  // 原版 l3：删除（fl 你确定删除 %s 吗？）
  private confirmRemove(sub: RuleSubEntry): void {
    this.getUIContext().showAlertDialog({
      message: `你确定删除 ${sub.name} 吗？`,
      primaryButton: {
        value: $r('app.string.cancel'),
        action: (): void => {
        }
      },
      secondaryButton: {
        value: $r('app.string.delete'),
        fontColor: $r('app.color.accent'),
        action: (): void => {
          this.removeSub(sub)
        }
      }
    })
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

  // 原版 t3:3：复制链接（zd 已复制链接）
  private copyLink(sub: RuleSubEntry): void {
    const data = pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, sub.url)
    pasteboard.getSystemPasteboard().setData(data).then(() => {
      this.getUIContext().getPromptAction().showToast({ message: '已复制链接', duration: 1500 })
    })
  }

  // 原版 z3/u3/m3：＋新建 → 未添加预设单选 + 自定义(ey)
  private pickToAdd(): void {
    const existing: string[] = []
    for (let i = 0; i < this.settings.ruleSubscriptions.length; i++) {
      existing.push(this.settings.ruleSubscriptions[i].url)
    }
    const candidates: RuleSubEntry[] = []
    for (let i = 0; i < RULE_SUB_PRESETS.length; i++) {
      if (existing.indexOf(RULE_SUB_PRESETS[i].url) < 0) {
        candidates.push(RULE_SUB_PRESETS[i])
      }
    }
    const sheets: SheetInfo[] = []
    for (let i = 0; i < candidates.length; i++) {
      const preset = candidates[i]
      sheets.push({
        title: preset.name,
        action: (): void => {
          this.settings.addRuleSub(preset.name, preset.url)
        }
      })
    }
    sheets.push({
      title: '自定义',
      action: (): void => {
        this.openAddDialog()
      }
    })
    ActionSheet.show({
      title: '添加规则订阅',
      message: '',
      sheets: sheets
    })
  }

  // 原版 B3(-1,null)：自定义添加对话框（b8 添加规则订阅，输入预填 https://，hint kh 地址）
  private openAddDialog(): void {
    this.newUrl = 'https://'
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

  // 原版 y3：校验 URL（a0z 链接无效。）+ 去重（jd 此规则订阅已存在。），名称取 host
  private applyUrl(newUrl: string): boolean {
    const url = newUrl.trim()
    if (!url.startsWith('http://') && !url.startsWith('https://')) {
      this.getUIContext().getPromptAction().showToast({ message: '链接无效。', duration: 1500 })
      return false
    }
    for (let i = 0; i < this.settings.ruleSubscriptions.length; i++) {
      if (this.settings.ruleSubscriptions[i].url === url) {
        this.getUIContext().getPromptAction().showToast({ message: '此规则订阅已存在。', duration: 1500 })
        return false
      }
    }
    return true
  }

  private hostOf(url: string): string {
    const rest = url.indexOf('://') >= 0 ? url.substring(url.indexOf('://') + 3) : url
    const cut = rest.indexOf('/')
    return cut > 0 ? rest.substring(0, cut) : rest
  }

  // 原版 B3(i10, cVar)：编辑对话框（hd 编辑规则订阅，输入预填当前 URL，hint kh 地址）
  private openEditDialog(sub: RuleSubEntry): void {
    this.editKey = sub.key
    this.editUrl = sub.url
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.EditSubDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.5)'
    }).then((dialogId: number) => {
      this.editDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open edit sub dialog failed: ${error.message}`)
    })
  }

  private closeEditDialog(): void {
    if (this.editDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.editDialogId)
    this.editDialogId = -1
  }

  @Builder
  AddSubDialog() {
    Column({ space: 14 }) {
      Text('添加规则订阅')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      TextInput({ text: this.newUrl })
        .width('100%')
        .height(44)
        .fontSize(14)
        .placeholderColor($r('app.color.fg_secondary'))
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
            const url = this.newUrl.trim()
            if (this.applyUrl(url)) {
              this.settings.addRuleSub(this.hostOf(url), url)
              this.closeAddDialog()
            }
          })
      }
      .width('100%')
    }
    .width(computeDialogWidthVp())
    .padding(24)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
    .transition(dialogTransition())
  }

  @Builder
  EditSubDialog() {
    Column({ space: 14 }) {
      Text('编辑规则订阅')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      TextInput({ text: this.editUrl })
        .width('100%')
        .height(44)
        .fontSize(14)
        .placeholderColor($r('app.color.fg_secondary'))
        .onChange((value: string) => {
          this.editUrl = value
        })
      Row({ space: 24 }) {
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
            const url = this.editUrl.trim()
            const sub = this.settings.ruleSubscriptions.find((s: RuleSubEntry): boolean => s.key === this.editKey)
            const others: RuleSubEntry[] = this.settings.ruleSubscriptions.filter((s: RuleSubEntry): boolean => s.key !== this.editKey)
            let dup = false
            for (let i = 0; i < others.length; i++) {
              if (others[i].url === url) {
                dup = true
              }
            }
            if (!url.startsWith('http://') && !url.startsWith('https://')) {
              this.getUIContext().getPromptAction().showToast({ message: '链接无效。', duration: 1500 })
              return
            }
            if (dup) {
              this.getUIContext().getPromptAction().showToast({ message: '此规则订阅已存在。', duration: 1500 })
              return
            }
            if (sub !== undefined) {
              sub.url = url
              this.settings.saveRuleSubs()
              this.reloadBlocker()
            }
            this.closeEditDialog()
          })
      }
      .width('100%')
    }
      .width(computeDialogWidthVp())
      .padding(24)
      .backgroundColor($r('app.color.menu_bg'))
      .borderRadius(16)
      .transition(dialogTransition())
  }
}

@Builder
export function SettingsRuleSubPageBuilder() {
  SettingsRuleSubPage()
}
