import { AppSettings } from '../common/Settings'
import { SettingCheckRow, SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'
@ComponentV2
export struct SettingsGesturePage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'

  private bindAppBar(): void {
    AppBar.show({
      title: '操作设定',
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
            // 原版 hb/u4.X1 列表顺序：滑动屏幕前进后退 / 使用音量键翻页 /
            // 启用视频播放器手势（带描述 hr）/ 键盘快捷键（入口 ra.i）
            SettingCheckRow({ rowLabel: '滑动屏幕前进后退', isChecked: this.settings.swipeSwitchTab, onCheckRow: (isOn: boolean) => {
              this.settings.setSwipeSwitchTab(isOn)
            } })
            SettingCheckRow({ rowLabel: '使用音量键翻页', isChecked: this.settings.volumePageFlip, onCheckRow: (isOn: boolean) => {
              this.settings.setVolumePageFlip(isOn)
            } })
            SettingCheckRow({
              rowLabel: '启用视频播放器手势',
              rowDesc: '如果可能，在全屏播放视频时允许滑动屏幕以调整视频进度、屏幕亮度、设备音量',
              isChecked: this.settings.videoGesture,
              onCheckRow: (isOn: boolean) => {
                this.settings.setVideoGesture(isOn)
              }
            })
            SettingNavRow({ rowLabel: '键盘快捷键', onTapRow: () => {
              this.navPathStack.pushPathByName('keyboardShortcuts', '', true)
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
export function SettingsGesturePageBuilder() {
  SettingsGesturePage()
}
