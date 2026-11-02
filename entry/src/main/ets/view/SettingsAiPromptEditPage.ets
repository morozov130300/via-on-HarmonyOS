import pasteboard from '@ohos.pasteboard'
import { AppSettings, AiPromptRec } from '../common/Settings'
import { AppBar, AppBarSpacer } from '../components/AppBar'

class PromptVariable {
  name: string
  desc: string

  constructor(name: string, desc: string) {
    this.name = name
    this.desc = desc
  }
}

// 原版 a9/f1：AI 提示词编辑页（标题/内容输入 + 可用变量区，AppBar 右上「保存」）
@ComponentV2
export struct SettingsAiPromptEditPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local isNew: boolean = true
  @Local promptId: number = -1
  @Local promptType: number = 1
  @Local titleDraft: string = ''
  @Local contentDraft: string = ''
  private initialTitle: string = ''
  private initialContent: string = ''

  private bindAppBar(): void {
    AppBar.show({
      // 原版 f1.b3/f1.a3：编辑已有提示词标题「编辑」，新建标题「新建」
      title: this.isNew ? '新建' : '编辑',
      rightText: '保存',
      onRight: () => {
        this.save()
      },
      onBack: () => {
        this.handleBack()
      }
    }, this)
  }

  private readParams(ctx: NavDestinationContext): void {
    const param: Object | undefined = ctx.pathInfo.param === undefined ? undefined : ctx.pathInfo.param as Object
    if (typeof param === 'string' && param !== '') {
      try {
        const obj = JSON.parse(param) as Record<string, Object>
        const id = obj['id']
        const type = obj['type']
        if (typeof id === 'number') {
          const found = this.settings.aiPrompts.find((item: AiPromptRec): boolean => item.id === id)
          if (found !== undefined) {
            this.isNew = false
            this.promptId = found.id
            this.promptType = found.type
            this.titleDraft = found.name
            this.contentDraft = found.content
            this.initialTitle = found.name
            this.initialContent = found.content
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
  }

  // 原版 f1.o3()：标题/内容与进入时一致视为未修改
  private isUnchanged(): boolean {
    return this.titleDraft.trim() === this.initialTitle.trim()
      && this.contentDraft === this.initialContent
  }

  // 原版 f1.r3(z)：返回时未保存弹「提示」对话框（保存并退出/退出）
  private handleBack(): void {
    if (this.isUnchanged()) {
      this.navPathStack.pop()
      return
    }
    this.getUIContext().showAlertDialog({
      title: '提示',
      message: '修改的内容未保存，是否保存？',
      primaryButton: {
        value: '保存并退出',
        action: () => {
          this.save()
        }
      },
      secondaryButton: {
        value: '退出',
        action: () => {
          this.navPathStack.pop()
        }
      },
      cancel: () => {
      }
    })
  }

  // 原版 f1.r3(false)：保存（标题/内容为空时抖动聚焦提示，不保存不退出）
  private save(): void {
    const title = this.titleDraft.trim()
    // 原版 g6.y.X + g6.n.i：空值时抖动并聚焦，无文字提示
    if (title === '') {
      return
    }
    if (this.contentDraft === '') {
      return
    }
    if (this.isNew) {
      this.settings.saveAiPrompt(new AiPromptRec(this.settings.aiPromptNextId, title, this.contentDraft, this.promptType))
    } else {
      this.settings.saveAiPrompt(new AiPromptRec(this.promptId, title, this.contentDraft, this.promptType))
    }
    this.navPathStack.pop()
  }

  // 原版 f1.s3(type)：可用变量列表（type1 含 webpage_* 三项，type2 仅 input，均含 time）
  private variables(): PromptVariable[] {
    const list: PromptVariable[] = []
    if (this.promptType === 1) {
      list.push(new PromptVariable('{{webpage_url}}', '当前网页的链接。'))
      list.push(new PromptVariable('{{webpage_title}}', '当前网页的标题。'))
      list.push(new PromptVariable('{{webpage_content}}', '当前网页的纯文本内容。'))
    } else {
      list.push(new PromptVariable('{{input}}', '输入框内容。'))
    }
    list.push(new PromptVariable('{{time}}', '当前时间 yyyy-MM-dd HH:mm:ss EEEE (ZZZZ)。'))
    return list
  }

  // 原版 f1.j3：点击变量 → 复制到剪贴板 + toast「已复制文本」
  private copyVariable(name: string): void {
    const data = pasteboard.createData('text/plain', name)
    pasteboard.getSystemPasteboard().setData(data)
    this.getUIContext().getPromptAction().showToast({ message: '已复制文本', duration: 1500 })
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // 原版 f1.k3：标题输入框（hint「标题」）
            TextInput({ text: this.titleDraft, placeholder: '标题' })
              .fontSize(15)
              .fontColor($r('app.color.fg'))
              .placeholderColor($r('app.color.fg_secondary'))
              .backgroundColor($r('app.color.surface'))
              .width('100%')
              .height(46)
              .onChange((value: string) => {
                this.titleDraft = value
              })
            // 原版 f1.g3：内容输入框（hint「内容」，多行）
            TextArea({ text: this.contentDraft, placeholder: '内容' })
              .fontSize(15)
              .fontColor($r('app.color.fg'))
              .placeholderColor($r('app.color.fg_secondary'))
              .backgroundColor($r('app.color.surface'))
              .width('100%')
              .constraintSize({ minHeight: 160 })
              .alignSelf(ItemAlign.Stretch)
              .onChange((value: string) => {
                this.contentDraft = value
              })
            // 原版 f1.s3：「可用变量」区
            Text('可用变量')
              .fontSize(13)
              .fontColor($r('app.color.fg_secondary'))
              .width('100%')
              .padding({ left: 2, top: 16, bottom: 4 })
              .alignSelf(ItemAlign.Start)
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
          .padding({ left: 16, right: 16 })
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
      this.readParams(ctx)
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
}

@Builder
export function SettingsAiPromptEditPageBuilder() {
  SettingsAiPromptEditPage()
}
