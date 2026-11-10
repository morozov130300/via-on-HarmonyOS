import { TOAST_SHORT } from '../common/ToastDuration'
import { util } from '@kit.ArkTS'
import { pasteboard } from '@kit.BasicServicesKit'
import { CopilotStore, AiSuggestion, extractVars, webpageVarFlags } from '../common/CopilotStore'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'

class PromptVariable {
  name: string
  desc: ResourceStr

  constructor(name: string, desc: ResourceStr) {
    this.name = name
    this.desc = desc
  }
}

// 原版 a9/f1：AI 提示词编辑页
// 标题输入(hint 标题) + 内容输入(hint 内容，7 行) + 「可用变量」区（点击复制 + toast「已复制文本」）
// AppBar 右上「保存」；标题「新建」/「编辑」；返回 = 未保存确认（保存并退出/退出）
@ComponentV2
export struct SettingsAiPromptEditPage {
  private store: CopilotStore = CopilotStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local editing: AiSuggestion | null = null
  @Local promptType: number = 1
  @Local titleDraft: string = ''
  @Local contentDraft: string = ''
  private baseline: string = ''

  private bindAppBar(): void {
    AppBar.show({
      // 原版 f1.b3/a3：编辑已有提示词标题「编辑」，新建标题「新建」
      title: this.editing !== null && this.editing.id !== '' ? $r('app.string.ai_edit') : $r('app.string.ai_new_label'),
      rightText: $r('app.string.ai_save'),
      onRight: () => {
        this.save(false)
      },
      onBack: () => {
        this.save(true)
      }
    }, this)
  }

  // 原版 X1：按参数加载（id → 查库；否则按 type 新建）
  private async load(param: string): Promise<void> {
    if (param !== '') {
      try {
        const obj = JSON.parse(param) as Record<string, Object>
        const id = obj['id']
        const type = obj['type']
        if (typeof id === 'string' && id !== '') {
          const found = await this.store.suggestion(id)
          if (found !== null) {
            this.apply(found)
            return
          }
        }
        if (typeof type === 'number') {
          this.promptType = type
        }
      } catch (error) {
        console.error('parse ai prompt edit params failed')
      }
    }
    this.baseline = ''
  }

  private apply(found: AiSuggestion): void {
    this.editing = found
    this.promptType = found.type
    this.titleDraft = found.name
    this.contentDraft = found.content
    // 原版 b3：f304s0 = v0.d(name, content)
    this.baseline = `${found.name}\n${found.content}`
  }

  // 原版 o3()：与进入时一致视为未修改
  private isUnchanged(): boolean {
    const current = `${this.titleDraft.trim()}\n${this.contentDraft}`
    return (this.baseline === '' && current === '\n') || current === this.baseline
  }

  // 原版 V2()/r3(z)：保存；true = 返回触发（未修改直接退出，有修改弹确认）
  private save(fromBack: boolean): void {
    if (this.isUnchanged()) {
      this.navPathStack.pop()
      return
    }
    if (fromBack) {
      this.getUIContext().showAlertDialog({
        title: $r('app.string.ai_unsaved_title'),
        message: $r('app.string.ai_unsaved_msg'),
        primaryButton: {
          value: $r('app.string.exit_app'),
          action: () => {
            this.navPathStack.pop()
          }
        },
        secondaryButton: {
          value: $r('app.string.ai_save_and_exit'),
          action: () => {
            this.save(false)
          }
        }
      })
      return
    }
    const title = this.titleDraft.trim()
    const content = this.contentDraft
    // 原版 g6.y.X + g6.n.i：空值抖动聚焦，无文字提示
    if (title === '') {
      return
    }
    if (content === '') {
      return
    }
    // 原版 d3：required = s.i(content, type)，flags = s.g(required)，时间戳刷新
    const now = Date.now()
    let isNew = false
    if (this.editing === null || this.editing.id === '') {
      isNew = true
      this.editing = new AiSuggestion()
      this.editing.id = util.generateRandomUUID(false)
      this.editing.createdAt = now
    }
    this.editing.name = title
    this.editing.content = content
    this.editing.type = this.promptType
    this.editing.required = extractVars(content, this.promptType)
    this.editing.flags = webpageVarFlags(this.editing.required)
    this.editing.updatedAt = now
    const target = this.editing
    if (isNew) {
      this.store.insertSuggestion(target).then(() => {
        this.navPathStack.pop()
      })
    } else {
      this.store.updateSuggestion(target.id, target).then(() => {
        this.navPathStack.pop()
      })
    }
  }

  // 原版 f1.s3(type)：可用变量列表（type1 含 webpage_* 三项，type2 仅 input，均含 time）
  private variables(): PromptVariable[] {
    const list: PromptVariable[] = []
    if (this.promptType === 1) {
      list.push(new PromptVariable('{{webpage_url}}', $r('app.string.ai_var_link')))
      list.push(new PromptVariable('{{webpage_title}}', $r('app.string.ai_var_title')))
      list.push(new PromptVariable('{{webpage_content}}', $r('app.string.ai_var_content')))
    } else {
      list.push(new PromptVariable('{{input}}', $r('app.string.ai_var_input')))
    }
    list.push(new PromptVariable('{{time}}', $r('app.string.ai_var_time')))
    return list
  }

  // 原版 f1.j3：点击变量 → 复制到剪贴板 + toast「已复制文本」
  private copyVariable(name: string): void {
    const data = pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, name)
    pasteboard.getSystemPasteboard().setData(data)
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.ai_copied'), duration: TOAST_SHORT })
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // 原版 f1.k3：标题输入框（hint「标题」）
            TextInput({ text: this.titleDraft, placeholder: $r('app.string.ai_title_label') })
              .fontSize(15)
              .fontColor($r('app.color.fg'))
              .placeholderColor($r('app.color.fg_secondary'))
              .backgroundColor($r('app.color.surface'))
              .width('100%')
              .height(46)
              .margin({ bottom: 12 })
              .onChange((value: string) => {
                this.titleDraft = value
              })
            // 原版 f1.g3：内容输入框（hint「内容」，多行）
            TextArea({ text: this.contentDraft, placeholder: $r('app.string.ai_content_label') })
              .fontSize(15)
              .fontColor($r('app.color.fg'))
              .placeholderColor($r('app.color.fg_secondary'))
              .backgroundColor($r('app.color.surface'))
              .width('100%')
              .constraintSize({ minHeight: 160 })
              .alignSelf(ItemAlign.Stretch)
              .margin({ bottom: 12 })
              .onChange((value: string) => {
                this.contentDraft = value
              })
            // 原版 f1.s3：「可用变量」区
            Text($r('app.string.ai_available_vars'))
              .fontSize(13)
              .fontWeight(FontWeight.Bold)
              .fontColor($r('app.color.fg'))
              .width('100%')
              .padding({ top: 4, bottom: 4 })
            ForEach(this.variables(), (variable: PromptVariable) => {
              Column() {
                Text(variable.name)
                  .fontSize(14)
                  .fontColor($r('app.color.accent'))
                  .maxLines(1)
                Text(variable.desc)
                  .fontSize(12)
                  .fontColor($r('app.color.fg_secondary'))
                  .maxLines(2)
                  .margin({ top: 1 })
              }
              .width('100%')
              .alignItems(HorizontalAlign.Start)
              .padding({ top: 8, bottom: 8 })
              .onClick(() => {
                this.copyVariable(variable.name)
              })
            }, (variable: PromptVariable) => variable.name)
          }
          .width('100%')
          .padding({ left: 16, right: 16, top: 12 })
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
      const param: Object | undefined = ctx.pathInfo.param === undefined ? undefined : ctx.pathInfo.param as Object
      this.load(typeof param === 'string' ? param : '').then(() => {
        this.bindAppBar()
      })
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
export function SettingsAiPromptEditPageBuilder() {
  SettingsAiPromptEditPage()
}
