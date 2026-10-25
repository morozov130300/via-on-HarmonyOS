import { AppSettings } from '../common/Settings'
import { UserScriptRec } from '../common/Types'
import { SettingToggleRow, SettingNavRow } from '../components/SettingRows'

@ComponentV2
export struct SettingsScriptPage {
  private settings: AppSettings = AppSettings.getInstance()

  build() {
    NavDestination() {
      Scroll() {
        Column() {
          SettingToggleRow({ rowLabel: '启用脚本', isToggleOn: this.settings.scriptEnabled, onToggleRow: (isOn: boolean) => {
            this.settings.setScriptEnabled(isOn)
          } })
          SettingNavRow({ rowLabel: '自动更新', rowValue: '每天', onTapRow: () => {
            this.notImplemented()
          } })
          if (this.settings.userScripts.length > 0) {
            Text('脚本')
              .fontSize(13)
              .fontColor($r('app.color.fg_secondary'))
              .width('100%')
              .padding({ left: 16, top: 10, bottom: 6 })
            ForEach(this.settings.userScripts, (script: UserScriptRec) => {
              Column() {
                Text(script.name)
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                Text(script.enabled ? '已启用' : '已禁用')
                  .fontSize(12)
                  .fontColor($r('app.color.fg_secondary'))
                  .margin({ top: 2 })
              }
              .width('100%')
              .padding({ left: 16, right: 16, top: 11, bottom: 11 })
              .alignItems(HorizontalAlign.Start)
            }, (script: UserScriptRec) => script.id.toString())
          }
        }
        .width('100%')
      }
      .width('100%')
      .height('100%')
      .align(Alignment.Top)
    }
    .backgroundColor($r('app.color.page_bg'))
    .title('脚本')
    .menus([
      {
        value: '更新',
        icon: $r('sys.symbol.arrow_clockwise'),
        action: () => {
          this.notImplemented()
        }
      }
    ])
  }

  private notImplemented(): void {
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.feature_wip'), duration: 1500 })
  }
}

@Builder
export function SettingsScriptPageBuilder() {
  SettingsScriptPage()
}
