import { AppSettings } from '../common/Settings'
import { SettingCheckRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'

// 原版 sa/d1.java：脚本设置页（脚本列表页由 UserScriptsPage 承载，本页仅保留入口行）
@ComponentV2
export struct SettingsScriptPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  private bindAppBar(): void {
    AppBar.show({
      title: '脚本',
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
            SettingCheckRow({ rowLabel: '启用脚本', isChecked: this.settings.scriptEnabled, onCheckRow: (isOn: boolean) => {
              this.settings.setScriptEnabled(isOn)
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
}

@Builder
export function SettingsScriptPageBuilder() {
  SettingsScriptPage()
}
