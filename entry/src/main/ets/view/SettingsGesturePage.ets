import { AppSettings } from '../common/Settings'
import { SettingCheckRow } from '../components/SettingRows'
import { SettingsHeader } from '../components/SettingsHeader'

@ComponentV2
export struct SettingsGesturePage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '操作设定',
          onBack: () => {
            this.navPathStack.pop()
          }
        })
        Scroll() {
          Column() {
            SettingCheckRow({ rowLabel: '音量键翻页', rowDesc: '使用音量键上下翻动网页', isChecked: this.settings.volumePageFlip, onCheckRow: (isOn: boolean) => {
              this.settings.setVolumePageFlip(isOn)
            } })
            SettingCheckRow({ rowLabel: '滑动切换标签', rowDesc: '在网页上左右滑动切换标签页', isChecked: this.settings.swipeSwitchTab, onCheckRow: (isOn: boolean) => {
              this.settings.setSwipeSwitchTab(isOn)
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
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }
}

@Builder
export function SettingsGesturePageBuilder() {
  SettingsGesturePage()
}
