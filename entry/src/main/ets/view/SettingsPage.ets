import { SettingNavRow } from '../components/SettingRows'

@ComponentV2
export struct SettingsPage {
  private navPathStack: NavPathStack = new NavPathStack()

  build() {
    NavDestination() {
      Scroll() {
        Column() {
          SettingNavRow({ rowLabel: '通用', onTapRow: () => {
            this.navPathStack.pushPathByName('settingsGeneral', '', true)
          } })
          SettingNavRow({ rowLabel: '定制', onTapRow: () => {
            this.navPathStack.pushPathByName('settingsCustom', '', true)
          } })
          SettingNavRow({ rowLabel: '隐私', onTapRow: () => {
            this.navPathStack.pushPathByName('settingsPrivacy', '', true)
          } })
          SettingNavRow({ rowLabel: '高级', onTapRow: () => {
            this.navPathStack.pushPathByName('settingsAdvanced', '', true)
          } })
          SettingNavRow({ rowLabel: '脚本', onTapRow: () => {
            this.navPathStack.pushPathByName('settingsScript', '', true)
          } })
          SettingNavRow({ rowLabel: '关于', onTapRow: () => {
            this.navPathStack.pushPathByName('settingsAbout', '', true)
          } })
        }
        .width('100%')
      }
      .width('100%')
      .height('100%')
      .align(Alignment.Top)
    }
    .backgroundColor($r('app.color.page_bg'))
    .title('设置')
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }
}

@Builder
export function SettingsPageBuilder() {
  SettingsPage()
}
