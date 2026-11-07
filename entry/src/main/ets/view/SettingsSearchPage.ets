import { i18n } from '@kit.LocalizationKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { AppSettings } from '../common/Settings'
import { SEARCH_ENGINES, SearchEngineDef, getBuiltinEngines } from '../common/SearchEngines'
import { dialogTransition } from '../common/Transitions'
import { SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { computeDialogWidthVp } from '../components/ViaDialogCard'

class SuggestItem {
  label: string = ''
  bit: number = 0

  constructor(label: string, bit: number) {
    this.label = label
    this.bit = bit
  }
}

// 原版 hb/b6：搜索设置页（搜索引擎 / 搜索建议多选 / 搜索工具栏）
// 搜索工具栏已完整移植：SearchToolbar.ets + SettingsSearchToolbarPage.ets，路由 settingsSearchToolbar
@ComponentV2
export struct SettingsSearchPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  // 原版 hb/b6.n3：多选项按序 [收藏, 书签, 标签页, 历史, 搜索引擎, 搜索历史]，位 = 1<<下标
  // 搜索建议源位表（la/a.a + ka/g.l）：收藏1/书签2/标签页4/历史8/搜索引擎16/搜索历史32
  private static readonly SUGGEST_ITEMS: SuggestItem[] = [
    new SuggestItem('收藏', 1),
    new SuggestItem('书签', 2),
    new SuggestItem('标签页', 4),
    new SuggestItem('历史', 8),
    new SuggestItem('搜索引擎', 16),
    new SuggestItem('搜索历史', 32)
  ]

  private bindAppBar(): void {
    AppBar.show({
      title: '搜索设置',
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
            SettingNavRow({
              rowLabel: '搜索引擎',
              rowValue: this.engineLabel(),
              onTapRow: () => {
                this.pickEngine()
              }
            })
            SettingNavRow({
              rowLabel: '搜索建议',
              rowValue: this.suggestValue(),
              onTapRow: () => {
                this.openSuggestDialog()
              }
            })
            // 原版 hb/b6.k3 第三项（id3）：搜索工具栏，值 = 已启用/已禁用（w9.a.r）
            SettingNavRow({
              rowLabel: '搜索工具栏',
              rowValue: this.settings.searchToolbarEnabled ? '已启用' : '已禁用',
              onTapRow: () => {
                this.navPathStack.pushPathByName('settingsSearchToolbar', '', true)
              }
            })
          }
          .width('100%')
          .padding({ bottom: 20 })
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

  // 原版 b6.k3：已选建议项以 '/' 连接展示
  private suggestValue(): string {
    const labels: string[] = []
    const items = SettingsSearchPage.SUGGEST_ITEMS
    for (let i = 0; i < items.length; i++) {
      if ((this.settings.searchSuggestion & items[i].bit) !== 0) {
        labels.push(items[i].label)
      }
    }
    return labels.join('/')
  }

  private engineLabel(): string {
    const key = this.settings.engineKey
    if (key.startsWith('custom')) {
      const rec = this.settings.resolveCustomEngineKey(key)
      if (rec !== null) {
        return rec.name
      }
      if (key === 'custom' && this.settings.customEngineTemplate !== '') {
        return '自定义'
      }
    }
    const matched = SEARCH_ENGINES.find((engine: SearchEngineDef): boolean => engine.key === key)
    return matched !== undefined ? matched.name : '百度'
  }

  private pickEngine(): void {
    const sheets: SheetInfo[] = []
    // 原版 v2.b：内置引擎按 locale 排序展示
    const locale = i18n.System.getSystemLanguage()
    const engines = getBuiltinEngines(locale.startsWith('zh'), locale.startsWith('ru'))
    for (let i = 0; i < engines.length; i++) {
      const engine = engines[i]
      sheets.push({ title: engine.name, action: (): void => {
        this.settings.setEngineKey(engine.key)
      } })
    }
    for (let i = 0; i < this.settings.customEngines.length; i++) {
      const rec = this.settings.customEngines[i]
      sheets.push({ title: rec.name, action: (): void => {
        this.settings.setEngineKey(`custom:${rec.id}`)
      } })
    }
    sheets.push({ title: '添加自定义搜索引擎', action: (): void => {
      this.inputCustomEngine()
    } })
    ActionSheet.show({
      title: '搜索引擎',
      message: '选择默认搜索引擎',
      sheets: sheets
    })
  }

  // 原版 b6.n3：搜索建议多选弹窗（标题 搜索建议，说明 使用地址栏时，从下列内容获取建议，确定/取消）
  @Local suggestChecks: boolean[] = [false, false, false, false, false, false]
  private suggestDialogId: number = -1

  private openSuggestDialog(): void {
    const items = SettingsSearchPage.SUGGEST_ITEMS
    for (let i = 0; i < items.length; i++) {
      this.suggestChecks[i] = (this.settings.searchSuggestion & items[i].bit) !== 0
    }
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.SuggestDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center
    }).then((dialogId: number) => {
      this.suggestDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open suggest dialog failed: ${error.message}`)
    })
  }

  @Builder
  SuggestDialog() {
    Column({ space: 12 }) {
      Text('搜索建议')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
      Text('使用地址栏时，从下列内容获取建议')
        .fontSize(13)
        .fontColor($r('app.color.fg_secondary'))
      ForEach(SettingsSearchPage.SUGGEST_ITEMS, (item: SuggestItem, index: number) => {
        Row() {
          Text(item.label)
            .fontSize(15)
            .fontColor($r('app.color.fg'))
            .layoutWeight(1)
          Checkbox()
            .select(this.suggestChecks[index])
            .onChange((value: boolean) => {
              this.suggestChecks[index] = value
            })
        }
        .width('100%')
        .height(42)
        .onClick(() => {
          this.suggestChecks[index] = !this.suggestChecks[index]
        })
      }, (item: SuggestItem) => item.label)
      Row({ space: 12 }) {
        Button($r('app.string.cancel'))
          .layoutWeight(1)
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            this.closeSuggestDialog()
          })
        Button($r('app.string.confirm'))
          .layoutWeight(1)
          .backgroundColor($r('app.color.accent'))
          .onClick(() => {
            this.applySuggest()
            this.closeSuggestDialog()
          })
      }
      .width('100%')
      .margin({ top: 4 })
    }
    .width('100%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
    .transition(dialogTransition())
  }

  // 原版 b6.g3：勾选项求和为位掩码
  private applySuggest(): void {
    const items = SettingsSearchPage.SUGGEST_ITEMS
    let flags = 0
    for (let i = 0; i < items.length; i++) {
      if (this.suggestChecks[i]) {
        flags += items[i].bit
      }
    }
    this.settings.setSearchSuggestion(flags)
  }

  private closeSuggestDialog(): void {
    if (this.suggestDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.suggestDialogId)
    this.suggestDialogId = -1
  }

  @Local engineTemplateInput: string = ''
  @Local engineNameInput: string = ''
  private engineDialogId: number = -1

  private inputCustomEngine(): void {
    this.engineTemplateInput = ''
    this.engineNameInput = ''
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.CustomEngineDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center
    }).then((dialogId: number) => {
      this.engineDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open custom engine dialog failed: ${error.message}`)
    })
  }

  @Builder
  CustomEngineDialog() {
    Column({ space: 14 }) {
      Text('自定义搜索引擎')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
      Text('用 %s 代表搜索词，例如：https://example.com/search?q=%s')
        .fontSize(13)
        .fontColor($r('app.color.fg_secondary'))
      TextInput({ placeholder: '名称', text: this.engineNameInput })
        .width('100%')
        .height(44)
        .fontSize(14)
        .onChange((value: string) => {
          this.engineNameInput = value
        })
      TextInput({ placeholder: 'https://example.com/search?q=%s', text: this.engineTemplateInput })
        .width('100%')
        .height(44)
        .fontSize(14)
        .onChange((value: string) => {
          this.engineTemplateInput = value
        })
      Row({ space: 12 }) {
        Button($r('app.string.cancel'))
          .layoutWeight(1)
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            this.closeEngineDialog()
          })
        Button($r('app.string.confirm'))
          .layoutWeight(1)
          .backgroundColor($r('app.color.accent'))
          .enabled(this.engineTemplateInput.includes('%s'))
          .opacity(this.engineTemplateInput.includes('%s') ? 1 : 0.4)
          .onClick(() => {
            const template = this.engineTemplateInput.trim()
            if (!template.includes('%s')) {
              return
            }
            const name = this.engineNameInput.trim()
            const newId = this.settings.addCustomEngine(name !== '' ? name : '自定义', template)
            // 原版：新增后自动选中新引擎（列表末尾）
            this.settings.setEngineKey(`custom:${newId}`)
            this.closeEngineDialog()
          })
      }
      .width('100%')
    }
    .width('100%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
    .transition(dialogTransition())
  }

  private closeEngineDialog(): void {
    if (this.engineDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.engineDialogId)
    this.engineDialogId = -1
  }
}

@Builder
export function SettingsSearchPageBuilder() {
  SettingsSearchPage()
}
