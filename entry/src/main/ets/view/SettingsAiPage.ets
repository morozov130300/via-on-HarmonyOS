import { AppSettings } from '../common/Settings'
import { SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'

const AI_PROVIDER_LABELS: Record<string, string> = {
  'deepseek': 'DeepSeek',
  'openai': 'OpenAI',
  'siliconflow': 'SiliconFlow'
}

@ComponentV2
export struct SettingsAiPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  private bindAppBar(): void {
    AppBar.show({
      title: 'AI 设置',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
        Column() {
          SettingNavRow({ rowLabel: 'AI 服务提供商', rowValue: this.providerLabel(), onTapRow: () => {
            this.pickProvider()
          } })
          // 原版 a9/o.j3()：第二行「AI 提示词」→ 提示词列表页（a9/z）；
          // API Key/模型不在本页（原版在服务商条目内编辑，a9/o 新建页）
          SettingNavRow({ rowLabel: 'AI 提示词', rowValue: '', onTapRow: () => {
            this.navPathStack.pushPathByName('aiPrompts', '', true)
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

  private providerLabel(): string {
    // 原版 a9/o.j3：提供商为空时显示「未设置」（x7.u.U8）
    if (this.settings.aiProvider === '') {
      return '未设置'
    }
    const label = AI_PROVIDER_LABELS[this.settings.aiProvider]
    return label === undefined ? this.settings.aiProvider : label
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
}

@Builder
export function SettingsAiPageBuilder() {
  SettingsAiPage()
}
