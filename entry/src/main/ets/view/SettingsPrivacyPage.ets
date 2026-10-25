import { AppSettings } from '../common/Settings'
import { SettingToggleRow } from '../components/SettingRows'

@ComponentV2
export struct SettingsPrivacyPage {
  private settings: AppSettings = AppSettings.getInstance()

  build() {
    NavDestination() {
      Scroll() {
        Column() {
          SettingToggleRow({ rowLabel: '不跟踪', isToggleOn: this.settings.doNotTrack, onToggleRow: (isOn: boolean) => {
            this.settings.setDoNotTrack(isOn)
          } })
          SettingToggleRow({ rowLabel: '禁用 WebRTC', isToggleOn: this.settings.disableWebRtc, onToggleRow: (isOn: boolean) => {
            this.settings.setDisableWebRtc(isOn)
          } })
          SettingToggleRow({
            rowLabel: '不出售或分享数据',
            rowDesc: '请求网站不出售或分享我的数据以保护隐私 (实验性)',
            isToggleOn: this.settings.doNotSell,
            onToggleRow: (isOn: boolean) => {
              this.settings.setDoNotSell(isOn)
            }
          })
        }
        .width('100%')
      }
      .width('100%')
      .height('100%')
      .align(Alignment.Top)
    }
    .backgroundColor($r('app.color.page_bg'))
    .title('隐私')
  }
}

@Builder
export function SettingsPrivacyPageBuilder() {
  SettingsPrivacyPage()
}
