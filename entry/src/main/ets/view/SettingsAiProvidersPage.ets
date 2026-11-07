import { CopilotStore, AiBackend, presetBackend, AI_PRESET_ORDER_ZH } from '../common/CopilotStore'
import { AppSettings } from '../common/Settings'
import { SettingRadioRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'

// 原版 a9/k：AI 服务商列表页
// q3()：顶部「无」行 + 各服务商单选行（选中 = aibackend）
// s3(null)：右上「新建」→ 预设服务商选择（自定义 + 预设清单）→ 编辑页
// k3()：长按非「无」行 → [编辑, 删除]
@ComponentV2
export struct SettingsAiProvidersPage {
  private settings: AppSettings = AppSettings.getInstance()
  private store: CopilotStore = CopilotStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local rows: AiBackend[] = []
  @Local noneSelected: boolean = false

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.ai_provider'),
      rightIcon: $r('app.media.via_ic_add'),
      onRight: () => {
        this.pickNew()
      },
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  // k.t3()/n3()：加载服务商列表
  private async reload(): Promise<void> {
    const list = await this.store.backends()
    const current = this.settings.aiBackend
    let none = true
    const rows: AiBackend[] = []
    for (let i = 0; i < list.length; i++) {
      if (list[i].id === current) {
        none = false
      }
      rows.push(list[i])
    }
    this.rows = rows
    this.noneSelected = none
  }

  // k.s3(null)：新建 → 预设选择（p9.s.d() 中文序；presetBackend 空则「自定义」）
  private pickNew(): void {
    const keys = AI_PRESET_ORDER_ZH
    if (keys.length === 0) {
      this.navPathStack.pushPathByName('aiProviderEdit', '', true)
      return
    }
    const sheets: SheetInfo[] = []
    for (let i = 0; i < keys.length; i++) {
      const preset = presetBackend(keys[i])
      const label = preset === null ? $r('app.string.ai_custom_label') : preset.name
      const key = keys[i]
      sheets.push({
        title: label,
        action: (): void => {
          // k.h3()：g6.i.g(r0, G3(strArrD[i10]))
          this.navPathStack.pushPathByName('aiProviderEdit', JSON.stringify({ preset: key }), true)
        }
      })
    }
    ActionSheet.show({
      title: $r('app.string.ai_new_label'),
      message: '',
      sheets: sheets
    })
  }

  // k.u3()：选择服务商（相同则忽略；「无」= 置空）
  private async pick(id: string): Promise<void> {
    const current = this.settings.aiBackend
    const same = id === '' ? current === '' : id === current
    if (same) {
      return
    }
    this.settings.setAiBackend(id)
    this.reload()
  }

  // k.r3()：删除服务商（删除当前项 → u3(null) 置空，否则刷新）
  private async remove(id: string): Promise<void> {
    await this.store.deleteBackend(id)
    if (id === this.settings.aiBackend) {
      this.pick('')
    } else {
      this.reload()
    }
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // q3()：首行「无」
            SettingRadioRow({
              rowLabel: $r('app.string.ai_none_label'),
              isSelected: this.noneSelected,
              onTapRow: () => {
                this.pick('')
              }
            })
            ForEach(this.rows, (backend: AiBackend) => {
              SettingRadioRow({
                rowLabel: backend.name,
                isSelected: backend.id === this.settings.aiBackend,
                onTapRow: () => {
                  this.pick(backend.id)
                },
                onLongPressRow: () => {
                  this.itemMenu(backend)
                }
              })
            }, (backend: AiBackend) => `${backend.id}_${backend.name}_${backend.id === this.settings.aiBackend}`)
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
    })
    .onShown(() => {
      this.bindAppBar()
      this.reload()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  // k.k3()/j3()：长按菜单 [编辑, 删除]（原版 w5.k.F 无标题两项列表）
  private itemMenu(backend: AiBackend): void {
    ActionSheet.show({
      title: '',
      message: '',
      sheets: [
        {
          title: $r('app.string.ai_edit'),
          action: (): void => {
            this.navPathStack.pushPathByName('aiProviderEdit', JSON.stringify({ id: backend.id }), true)
          }
        },
        {
          title: $r('app.string.ai_delete'),
          action: (): void => {
            this.remove(backend.id)
          }
        }
      ]
    })
  }
}

@Builder
export function SettingsAiProvidersPageBuilder() {
  SettingsAiProvidersPage()
}
