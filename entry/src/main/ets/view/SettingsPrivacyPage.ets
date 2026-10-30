import { AppSettings } from '../common/Settings'
import { SettingCheckRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'

@ComponentV2
export struct SettingsPrivacyPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  private bindAppBar(): void {
    AppBar.show({
      title: '隐私',
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
            SettingCheckRow({ rowLabel: '不跟踪', isChecked: this.settings.doNotTrack, onCheckRow: (isOn: boolean) => {
              this.settings.setDoNotTrack(isOn)
            } })
            SettingCheckRow({ rowLabel: '禁用 WebRTC', isChecked: this.settings.disableWebRtc, onCheckRow: (isOn: boolean) => {
              this.settings.setDisableWebRtc(isOn)
            } })
            SettingCheckRow({
              rowLabel: '不出售或分享数据',
              rowDesc: '请求网站不出售或分享我的数据以保护隐私 (实验性)',
              isChecked: this.settings.doNotSell,
              onCheckRow: (isOn: boolean) => {
                this.settings.setDoNotSell(isOn)
              }
            })
            SettingCheckRow({
              rowLabel: '请求头代理',
              rowDesc: '拦截网页请求由应用转发以附加 DNT/GPC 请求头 (实验性，可能影响登录与视频播放)',
              isChecked: this.settings.privacyProxy,
              onCheckRow: (isOn: boolean) => {
                this.settings.setPrivacyProxy(isOn)
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
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }
}

@Builder
export function SettingsPrivacyPageBuilder() {
  SettingsPrivacyPage()
}
