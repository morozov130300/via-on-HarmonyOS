import { AppSettings } from '../common/Settings'
import { SettingToggleRow } from '../components/SettingRows'

@ComponentV2
export struct SettingsAdvancedPage {
  private settings: AppSettings = AppSettings.getInstance()

  build() {
    NavDestination() {
      Scroll() {
        Column() {
          SettingToggleRow({
            rowLabel: '流量节省',
            rowDesc: '请求网站节省流量',
            isToggleOn: this.settings.dataSaver,
            onToggleRow: (isOn: boolean) => {
              this.settings.setDataSaver(isOn)
            }
          })
          SettingToggleRow({
            rowLabel: '自动展示嗅探按钮',
            isToggleOn: this.settings.autoSniffButton,
            onToggleRow: (isOn: boolean) => {
              this.settings.setAutoSniffButton(isOn)
            }
          })
          SettingToggleRow({
            rowLabel: '允许调试网页',
            isToggleOn: this.settings.allowDebugWeb,
            onToggleRow: (isOn: boolean) => {
              this.settings.setAllowDebugWeb(isOn)
            }
          })
          SettingToggleRow({
            rowLabel: '禁用 Custom Tabs',
            rowDesc: '跳过第三方应用通过 Custom Tabs 打开链接时的中转页',
            isToggleOn: this.settings.disableCustomTabs,
            onToggleRow: (isOn: boolean) => {
              this.settings.setDisableCustomTabs(isOn)
            }
          })
          SettingToggleRow({
            rowLabel: '禁用安全浏览',
            rowDesc: '安全浏览允许 WebView 通过验证链接来防止恶意软件和网络钓鱼攻击',
            isToggleOn: this.settings.disableSafeBrowsing,
            onToggleRow: (isOn: boolean) => {
              this.settings.setDisableSafeBrowsing(isOn)
            }
          })
          SettingToggleRow({
            rowLabel: '忽略 SSL 证书警告',
            rowDesc: '请小心，忽略 SSL 证书警告可能会使网站的连接不安全',
            isToggleOn: this.settings.ignoreSslWarning,
            onToggleRow: (isOn: boolean) => {
              this.settings.setIgnoreSslWarning(isOn)
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
    .title('高级')
  }
}

@Builder
export function SettingsAdvancedPageBuilder() {
  SettingsAdvancedPage()
}
