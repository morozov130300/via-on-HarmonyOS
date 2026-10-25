import { BusinessError } from '@kit.BasicServicesKit'
import { AppSettings } from '../common/Settings'
import { SettingNavRow } from '../components/SettingRows'
import { SettingsHeader } from '../components/SettingsHeader'

const AI_PROVIDER_LABELS: Record<string, string> = {
  'deepseek': 'DeepSeek',
  'openai': 'OpenAI',
  'siliconflow': 'SiliconFlow'
}

@ComponentV2
export struct SettingsAiPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local keyDraft: string = ''
  @Local modelDraft: string = ''
  private keyDialogId: number = -1
  private modelDialogId: number = -1

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: 'AI 设置',
          onBack: () => {
            this.navPathStack.pop()
          }
        })
        Scroll() {
        Column() {
          SettingNavRow({ rowLabel: '服务商', rowValue: this.providerLabel(), onTapRow: () => {
            this.pickProvider()
          } })
          SettingNavRow({ rowLabel: 'API Key', rowValue: this.maskedKey(), onTapRow: () => {
            this.editApiKey()
          } })
          SettingNavRow({ rowLabel: '模型', rowValue: this.settings.aiModel, onTapRow: () => {
            this.editModel()
          } })
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
    })
  }

  private providerLabel(): string {
    const label = AI_PROVIDER_LABELS[this.settings.aiProvider]
    return label === undefined ? this.settings.aiProvider : label
  }

  private maskedKey(): string {
    const key = this.settings.aiApiKey
    if (key === '') {
      return '未设置'
    }
    if (key.length <= 8) {
      return '已设置'
    }
    return `${key.substring(0, 4)}****${key.substring(key.length - 4)}`
  }

  private pickProvider(): void {
    const sheets: SheetInfo[] = [
      { title: 'DeepSeek', action: (): void => {
        this.settings.setAiProvider('deepseek')
        this.settings.setAiModel('deepseek-chat')
      } },
      { title: 'OpenAI', action: (): void => {
        this.settings.setAiProvider('openai')
        this.settings.setAiModel('gpt-4o-mini')
      } },
      { title: 'SiliconFlow', action: (): void => {
        this.settings.setAiProvider('siliconflow')
        this.settings.setAiModel('deepseek-ai/DeepSeek-V3')
      } }
    ]
    ActionSheet.show({
      title: '服务商',
      message: '选择 AI 服务商',
      sheets: sheets
    })
  }

  private editApiKey(): void {
    this.keyDraft = this.settings.aiApiKey
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.ApiKeyDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center
    }).then((dialogId: number) => {
      this.keyDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open api key dialog failed: ${error.message}`)
    })
  }

  private closeKeyDialog(): void {
    if (this.keyDialogId >= 0) {
      this.getUIContext().getPromptAction().closeCustomDialog(this.keyDialogId)
      this.keyDialogId = -1
    }
  }

  @Builder
  ApiKeyDialog() {
    Column({ space: 16 }) {
      Text('API Key')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
      TextInput({ text: this.keyDraft, placeholder: '输入 API Key' })
        .fontSize(14)
        .height(44)
        .onChange((value: string) => {
          this.keyDraft = value
        })
      Row({ space: 12 }) {
        Button('取消')
          .fontSize(15)
          .layoutWeight(1)
          .backgroundColor($r('app.color.page_bg'))
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            this.closeKeyDialog()
          })
        Button('确定')
          .fontSize(15)
          .layoutWeight(1)
          .onClick(() => {
            this.settings.setAiApiKey(this.keyDraft.trim())
            this.closeKeyDialog()
          })
      }
      .width('100%')
    }
    .width('100%')
    .padding(20)
    .backgroundColor($r('app.color.page_bg'))
    .borderRadius(16)
  }

  private editModel(): void {
    this.modelDraft = this.settings.aiModel
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.ModelDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center
    }).then((dialogId: number) => {
      this.modelDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open model dialog failed: ${error.message}`)
    })
  }

  private closeModelDialog(): void {
    if (this.modelDialogId >= 0) {
      this.getUIContext().getPromptAction().closeCustomDialog(this.modelDialogId)
      this.modelDialogId = -1
    }
  }

  @Builder
  ModelDialog() {
    Column({ space: 16 }) {
      Text('模型')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
      TextInput({ text: this.modelDraft, placeholder: '输入模型名称' })
        .fontSize(14)
        .height(44)
        .onChange((value: string) => {
          this.modelDraft = value
        })
      Row({ space: 12 }) {
        Button('取消')
          .fontSize(15)
          .layoutWeight(1)
          .backgroundColor($r('app.color.page_bg'))
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            this.closeModelDialog()
          })
        Button('确定')
          .fontSize(15)
          .layoutWeight(1)
          .onClick(() => {
            this.settings.setAiModel(this.modelDraft.trim())
            this.closeModelDialog()
          })
      }
      .width('100%')
    }
    .width('100%')
    .padding(20)
    .backgroundColor($r('app.color.page_bg'))
    .borderRadius(16)
  }
}

@Builder
export function SettingsAiPageBuilder() {
  SettingsAiPage()
}
