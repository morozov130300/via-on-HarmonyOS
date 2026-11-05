import { i18n } from '@kit.LocalizationKit'
import { AppSettings } from '../common/Settings'
import { SEARCH_ENGINES, SearchEngineDef, getBuiltinEngines } from '../common/SearchEngines'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { SettingCheckRow } from '../components/SettingRows'

interface EngineRow {
  // 原版引擎 int id（内置负数、自定义记录主键 ≥1）
  id: number
  key: string
  name: string
  subtitle: string
  enabled: boolean
}

// 原版 hb/i6：搜索工具栏设置页
// 行1 = 启用搜索工具栏开关（w9.a bit32768，默认启用）；
// 「搜索引擎」分节 = 内置+自定义引擎行：副标题「默认」仅默认引擎，
// 勾选 = 从禁用表(searchToolbarDisabled)增删（默认引擎不可禁用），
// 长按拖拽重排写 searchToolbarOrder；未出现在顺序表的引擎排在最后（ib.q）
@ComponentV2
export struct SettingsSearchToolbarPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local rows: EngineRow[] = []

  private bindAppBar(): void {
    AppBar.show({
      title: '搜索工具栏',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  aboutToAppear(): void {
    this.reload()
  }

  private allEngines(): SearchEngineDef[] {
    const locale = i18n.System.getSystemLanguage()
    const engines = getBuiltinEngines(locale.startsWith('zh'), locale.startsWith('ru'))
    const all: SearchEngineDef[] = []
    for (let i = 0; i < engines.length; i++) {
      all.push(engines[i])
    }
    for (let i = 0; i < this.settings.customEngines.length; i++) {
      const entry = this.settings.customEngines[i]
      all.push(new SearchEngineDef(`custom:${entry.id}`, entry.name, entry.template, entry.id))
    }
    // 原版 ib.q：按 searchToolbarOrder（int id 逗号串）中的位置排序，未登记的排最后（保持原相对序）
    const order = this.settings.searchToolbarOrder
    const rank = (engine: SearchEngineDef): number => {
      const idx = order.indexOf(String(engine.id))
      return idx >= 0 ? idx : Number.MAX_SAFE_INTEGER
    }
    all.sort((a: SearchEngineDef, b: SearchEngineDef): number => rank(a) - rank(b))
    return all
  }

  private reload(): void {
    const disabled = this.settings.searchToolbarDisabled.split(',')
    const defKey = this.settings.engineKey
    const rows: EngineRow[] = []
    const engines = this.allEngines()
    for (let i = 0; i < engines.length; i++) {
      const engine = engines[i]
      rows.push({
        id: engine.id,
        key: engine.key,
        name: engine.name,
        subtitle: engine.key === defKey ? '默认' : '',
        enabled: engine.key === defKey || disabled.indexOf(String(engine.id)) < 0
      })
    }
    this.rows = rows
  }

  // 原版存储格式：引擎 int id 逗号串
  private persistDisabled(): void {
    const disabled: string[] = []
    for (let i = 0; i < this.rows.length; i++) {
      if (!this.rows[i].enabled) {
        disabled.push(String(this.rows[i].id))
      }
    }
    this.settings.setSearchToolbarDisabled(disabled.join(','))
  }

  private persistOrder(): void {
    const ids: string[] = []
    for (let i = 0; i < this.rows.length; i++) {
      ids.push(String(this.rows[i].id))
    }
    this.settings.setSearchToolbarOrder(ids.join(','))
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        // 原版 hb/i6.X1：单一 RecyclerView，[0]=开关行 [1]=「搜索引擎」分组头 [2..]=引擎行；
        // ItemTouchHelper 长按拖拽仅对 index≥2 生效，落下后 v3() 把顺序写入 e2 键（searchToolbarOrder）
        List() {
          ListItem() {
            SettingCheckRow({
              rowLabel: '启用搜索工具栏',
              isChecked: this.settings.searchToolbarEnabled,
              onCheckRow: (isOn: boolean) => {
                this.settings.setSearchToolbarEnabled(isOn)
              }
            })
          }
          ListItem() {
            Row() {
              Text('搜索引擎')
                .fontSize(13)
                .fontColor($r('app.color.fg_secondary'))
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 14, bottom: 6 })
          }
          ForEach(this.rows, (row: EngineRow, index: number) => {
            ListItem() {
              Row({ space: 12 }) {
                Column({ space: 2 }) {
                  Text(row.name)
                    .fontSize(15)
                    .fontColor(this.settings.searchToolbarEnabled ? $r('app.color.fg') : $r('app.color.fg_secondary'))
                  if (row.subtitle !== '') {
                    Text(row.subtitle)
                      .fontSize(12)
                      .fontColor($r('app.color.fg_secondary'))
                  }
                }
                .alignItems(HorizontalAlign.Start)
                .layoutWeight(1)
                Checkbox()
                  .select(row.enabled)
                  .enabled(this.settings.searchToolbarEnabled && row.subtitle === '')
                  .onChange((value: boolean) => {
                    // 原版 i6.k3：副标题非空（默认引擎）不可切换
                    if (row.subtitle !== '') {
                      return
                    }
                    this.rows[index].enabled = value
                    this.persistDisabled()
                  })
              }
              .width('100%')
              .height(52)
              .padding({ left: 16, right: 16 })
              .opacity(this.settings.searchToolbarEnabled ? 1 : 0.5)
              .onClick(() => {
                if (!this.settings.searchToolbarEnabled || row.subtitle !== '') {
                  return
                }
                this.rows[index].enabled = !this.rows[index].enabled
                this.persistDisabled()
                this.reload()
              })
            }
          }, (row: EngineRow) => `${row.key}_${row.enabled}_${row.subtitle}`)
        }
        .width('100%')
        .layoutWeight(1)
        .edgeEffect(EdgeEffect.Spring)
        .onItemDragStart((event: ItemDragInfo, index: number) => {
          // 原版 c.y()/c.r()：index<2（开关/分组头）不可拖拽
          if (index < 2) {
            return
          }
          return this.DragPreview(this.rows[index - 2])
        })
        .onItemDrop((event: ItemDragInfo, itemIndex: number, insertIndex: number, isSuccess: boolean) => {
          if (!isSuccess || itemIndex < 2 || insertIndex < 2 || itemIndex === insertIndex) {
            return
          }
          const from = itemIndex - 2
          const to = insertIndex - 2
          const moved = this.rows.splice(from, 1)[0]
          this.rows.splice(to, 0, moved)
          // 原版 v3()：拖拽落下后顺序写入 searchToolbarOrder
          this.persistOrder()
        })
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

  @Builder
  DragPreview(row: EngineRow) {
    Column() {
      Text(row.name)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
    }
    .alignItems(HorizontalAlign.Start)
    .padding({ left: 16, right: 16 })
    .constraintSize({ minWidth: '100%' })
    .height(52)
    .justifyContent(FlexAlign.Center)
    .backgroundColor($r('app.color.surface'))
  }
}

@Builder
export function SettingsSearchToolbarPageBuilder() {
  SettingsSearchToolbarPage()
}
