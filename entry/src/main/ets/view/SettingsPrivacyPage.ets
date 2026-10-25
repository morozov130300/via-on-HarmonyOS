import { AppSettings } from '../common/Settings'
import { SettingToggleRow } from '../components/SettingRows'
import { SettingsHeader } from '../components/SettingsHeader'

@ComponentV2
export struct SettingsPrivacyPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '隐私',
          onBack: () => {
            this.navPathStack.pop()
          }
        })
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
}

@Builder
export function SettingsPrivacyPageBuilder() {
  SettingsPrivacyPage()
}
