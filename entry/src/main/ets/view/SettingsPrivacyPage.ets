import { AppSettings } from '../common/Settings'
import { SettingCheckRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'

@ComponentV2
export struct SettingsPrivacyPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.privacy'),
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
            SettingCheckRow({ rowLabel: $r('app.string.do_not_track'), isChecked: this.settings.doNotTrack, onCheckRow: (isOn: boolean) => {
              this.settings.setDoNotTrack(isOn)
            } })
            SettingCheckRow({ rowLabel: $r('app.string.disable_webrtc'), isChecked: this.settings.disableWebRtc, onCheckRow: (isOn: boolean) => {
              this.settings.setDisableWebRtc(isOn)
            } })
            SettingCheckRow({
              rowLabel: $r('app.string.do_not_sell'),
              rowDesc: $r('app.string.do_not_sell_desc'),
              isChecked: this.settings.doNotSell,
              onCheckRow: (isOn: boolean) => {
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
export function SettingsPrivacyPageBuilder() {
  SettingsPrivacyPage()
}
