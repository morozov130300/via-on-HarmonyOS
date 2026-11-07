import { CopilotStore, AiSuggestion } from '../common/CopilotStore'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'

// 原版 a9/z：AI 提示词列表页
// q3()：分组「系统提示词」(type1)/「消息模板」(type2)，组非空才显示组头
// 新建：AppBar 加号 → [系统提示词/消息模板] 选择 → 编辑页
// 长按行 → [编辑/删除] 对话框；点击行 → 编辑页
@ComponentV2
export struct SettingsAiPromptsPage {
  private store: CopilotStore = CopilotStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local systemPrompts: AiSuggestion[] = []
  @Local templatePrompts: AiSuggestion[] = []
  @Local isEmpty: boolean = false

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.ai_prompts'),
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

  // 原版 t3()/q3()：加载并按 type 分组
  private async reload(): Promise<void> {
    const all = await this.store.suggestions()
    const system: AiSuggestion[] = []
    const template: AiSuggestion[] = []
    for (let i = 0; i < all.length; i++) {
      if (all[i].type === 1) {
        system.push(all[i])
      } else if (all[i].type === 2) {
        template.push(all[i])
      }
    }
    this.systemPrompts = system
    this.templatePrompts = template
    this.isEmpty = system.length === 0 && template.length === 0
  }

  // 原版 a9/z.s3(view, null)：新建时弹「系统提示词/消息模板」选择
  private pickNewType(): void {
    const sheets: SheetInfo[] = [
      {
        title: $r('app.string.ai_system_prompts'),
        action: (): void => {
          this.navPathStack.pushPathByName('aiPromptEdit', JSON.stringify({ type: 1 }), true)
        }
      },
      {
        title: $r('app.string.ai_msg_templates'),
        action: (): void => {
          this.navPathStack.pushPathByName('aiPromptEdit', JSON.stringify({ type: 2 }), true)
        }
      }
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
              this.GroupHeader($r('app.string.ai_system_prompts'))
              ForEach(this.systemPrompts, (item: AiSuggestion) => {
                this.PromptRow(item)
              }, (item: AiSuggestion) => `sys_${item.id}_${item.name}`)
            }
            if (this.templatePrompts.length > 0) {
              this.GroupHeader($r('app.string.ai_msg_templates'))
              ForEach(this.templatePrompts, (item: AiSuggestion) => {
                this.PromptRow(item)
              }, (item: AiSuggestion) => `tpl_${item.id}_${item.name}`)
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
      this.reload()
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
  GroupHeader(label: ResourceStr) {
    Text(label)
      .fontSize(13)
      .fontColor($r('app.color.fg_secondary'))
      .width('100%')
      .padding({ left: 16, right: 16, top: 14, bottom: 6 })
  }

  @Builder
  PromptRow(item: AiSuggestion) {
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
    .gesture(LongPressGesture()
      .onAction(() => {
        this.itemMenu(item)
      }))
  }

  // 原版 a9/z.p3：长按弹「编辑/删除」列表对话框（w5.k.F 无标题两项）
  private itemMenu(item: AiSuggestion): void {
    ActionSheet.show({
      title: '',
      message: '',
      sheets: [
        {
          title: $r('app.string.ai_edit'),
          action: (): void => {
            this.navPathStack.pushPathByName('aiPromptEdit', JSON.stringify({ id: item.id }), true)
          }
        },
        {
          title: $r('app.string.ai_delete'),
          action: (): void => {
            this.store.deleteSuggestion(item.id).then(() => {
              this.reload()
            })
          }
        }
      ]
    })
  }
}

@Builder
export function SettingsAiPromptsPageBuilder() {
  SettingsAiPromptsPage()
}
