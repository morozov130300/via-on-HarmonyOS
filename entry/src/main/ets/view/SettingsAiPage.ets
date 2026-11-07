import { CopilotStore } from '../common/CopilotStore'
import { AppSettings } from '../common/Settings'
import { SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'

// 原版 a9/o：AI 设置页（两行：AI 服务提供商 / AI 提示词）
// j3()：行1 = ai_provider + 当前服务商名（空则「无」）；行2 = ai_prompts（无值）
@ComponentV2
export struct SettingsAiPage {
  private settings: AppSettings = AppSettings.getInstance()
  private store: CopilotStore = CopilotStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local providerName: string = ''

  // k3()：刷新当前服务商名（l3(j3(backend))）
  private async reloadProvider(): Promise<void> {
    const backend = await this.store.backend(this.settings.aiBackend)
    // j3：lVar == null → Z0(U8)「无」
    this.providerName = backend === null ? '' : backend.name
  }

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.ai_settings'),
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
              rowLabel: $r('app.string.ai_provider'),
              rowValue: this.providerName === '' ? $r('app.string.ai_none_label') : this.providerName,
              onTapRow: () => {
                this.navPathStack.pushPathByName('aiProviders', '', true)
              }
            })
            SettingNavRow({
              rowLabel: $r('app.string.ai_prompts'),
              onTapRow: () => {
                this.navPathStack.pushPathByName('aiPrompts', '', true)
              }
            })
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
      this.reloadProvider()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
      this.reloadProvider()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }
}

@Builder
export function SettingsAiPageBuilder() {
  SettingsAiPage()
}
