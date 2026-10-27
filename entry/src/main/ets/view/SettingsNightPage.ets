import { AppSettings } from '../common/Settings'
import { SettingToggleRow } from '../components/SettingRows'
import { SettingsHeader } from '../components/SettingsHeader'

@ComponentV2
export struct SettingsNightPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '夜间模式',
          onBack: () => {
            this.navPathStack.pop()
          }
        })
        Scroll() {
          Column() {
            Text($r('app.string.web_mask_filter'))
              .fontSize(13)
              .fontColor($r('app.color.fg_secondary'))
              .width('100%')
              .padding({ left: 16, right: 16, top: 16, bottom: 4 })
            SettingToggleRow({
              rowLabel: $r('app.string.night_force_dark'),
              rowDesc: $r('app.string.night_force_dark_desc'),
              isToggleOn: this.settings.nightForceDark,
              onToggleRow: (isOn: boolean) => {
                this.settings.setNightForceDark(isOn)
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
export function SettingsNightPageBuilder() {
  SettingsNightPage()
}
