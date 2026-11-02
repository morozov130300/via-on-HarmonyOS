import { AppSettings, AiPromptRec } from '../common/Settings'
import { AppBar, AppBarSpacer } from '../components/AppBar'

// 原版 a9/z：AI 提示词列表页（分组「系统提示词」/「消息模板」，AppBar 右上加号新建）
@ComponentV2
export struct SettingsAiPromptsPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local systemPrompts: AiPromptRec[] = []
  @Local templatePrompts: AiPromptRec[] = []
  @Local isEmpty: boolean = false

  private bindAppBar(): void {
    AppBar.show({
      title: 'AI 提示词',
      // 原版 z.b(1,1,ic_add,「新建」)：右上角加号 → 弹类型选择（系统提示词/消息模板）
      rightIcon: $r('app.media.via_ic_add'),
      onRight: () => {
        this.pickNewType()
      },
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  private reload(): void {
    const system: AiPromptRec[] = []
    const template: AiPromptRec[] = []
    for (let i = 0; i < this.settings.aiPrompts.length; i++) {
      const item = this.settings.aiPrompts[i]
      if (item.type === 1) {
        system.push(item)
      } else if (item.type === 2) {
        template.push(item)
      }
    }
    this.systemPrompts = system
    this.templatePrompts = template
    this.isEmpty = system.length === 0 && template.length === 0
  }

  // 原版 a9/z.s3(view, null)：新建时弹「系统提示词/消息模板」选择
  private pickNewType(): void {
    const sheets: SheetInfo[] = [
      { title: '系统提示词', action: (): void => {
        this.navPathStack.pushPathByName('aiPromptEdit', JSON.stringify({ type: 1 }), true)
      } },
      { title: '消息模板', action: (): void => {
        this.navPathStack.pushPathByName('aiPromptEdit', JSON.stringify({ type: 2 }), true)
      } }
    ]
    ActionSheet.show({
      title: '',
      message: '',
      sheets: sheets
    })
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // 原版 z8/r3.b：空列表占位视图
            if (this.isEmpty) {
              Text('¯\\_(ツ)_/¯')
                .fontSize(18)
                .fontColor($r('app.color.fg_secondary'))
                .margin({ top: 64 })
            }
            if (this.systemPrompts.length > 0) {
              this.GroupHeader('系统提示词')
              ForEach(this.systemPrompts, (item: AiPromptRec) => {
                this.PromptRow(item)
              }, (item: AiPromptRec) => `sys_${item.id}_${item.name}`)
            }
            if (this.templatePrompts.length > 0) {
              this.GroupHeader('消息模板')
              ForEach(this.templatePrompts, (item: AiPromptRec) => {
                this.PromptRow(item)
              }, (item: AiPromptRec) => `tpl_${item.id}_${item.name}`)
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
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
      this.reload()
    })
    .onShown(() => {
      this.bindAppBar()
      this.reload()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  @Builder
  GroupHeader(label: string) {
    Text(label)
      .fontSize(13)
      .fontColor($r('app.color.fg_secondary'))
      .width('100%')
      .padding({ left: 16, right: 16, top: 14, bottom: 6 })
  }

  @Builder
  PromptRow(item: AiPromptRec) {
    Column() {
      Text(item.name)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
    }
    .width('100%')
    .alignItems(HorizontalAlign.Start)
    .padding({ left: 16, right: 16, top: 13, bottom: 13 })
    .onClick(() => {
      // 原版 a9/z.s3(view, id)：点击进入编辑页
      this.navPathStack.pushPathByName('aiPromptEdit', JSON.stringify({ id: item.id }), true)
    })
    .bindContextMenuByResponseType(this.itemMenu(item), ResponseType.LongPress)
  }

  // 原版 a9/z.p3：长按弹「编辑/删除」菜单
  private itemMenu(item: AiPromptRec): MenuElement[] {
    const menu: MenuElement[] = [
      { value: '编辑', action: (): void => {
        this.navPathStack.pushPathByName('aiPromptEdit', JSON.stringify({ id: item.id }), true)
      } },
      { value: '删除', action: (): void => {
        this.settings.removeAiPrompt(item.id)
        this.reload()
      } }
    ]
    return menu
  }
}

@Builder
export function SettingsAiPromptsPageBuilder() {
  SettingsAiPromptsPage()
}
