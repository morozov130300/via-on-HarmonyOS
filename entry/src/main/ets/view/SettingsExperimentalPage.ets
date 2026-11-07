import { AppSettings } from '../common/Settings'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { SettingNavRow } from '../components/SettingRows'
import { buildNavSlide } from './PageTransitions'

// 原版实验页（hb/y1，标题 u.R4 = 实验），行序 i3()：
// 1. 皮肤行（a6.q，标题 u.Tc「皮肤」）→ k3：g6.i.g(lb.k) 进皮肤页
// 2. 「模糊效果」开关（a6.n，SDK>=31；u.cy/u.cz，w9.d 位2）
// 3. 「在设置中显示背景」开关（a6.n，z8.l3.f14720a=SDK>=29 恒真；u.tu，w9.d 位4），
//    切换 j3 → toast u.tv「将在下次打开设置时生效」
@ComponentV2
export struct SettingsExperimentalPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'

  private bindAppBar(): void {
    AppBar.show({
      title: '实验',
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
            // 原版 y1.k3：皮肤行 → lb.k 皮肤页
            SettingNavRow({
              rowLabel: '皮肤',
              onTapRow: () => {
                this.navPathStack.pushPathByName('skinPage', '', true)
              }
            })
            // 原版 y1.j3 case1：模糊效果（w9.d.h 位2）
            Row() {
              Column() {
                Text('模糊效果')
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                Text('为应用启用模糊效果，部分设备可能不支持')
                  .fontSize(12)
                  .fontColor($r('app.color.fg_secondary'))
                  .maxLines(2)
                  .margin({ top: 2 })
              }
              .alignItems(HorizontalAlign.Start)
              .layoutWeight(1)

              Toggle({ type: ToggleType.Switch, isOn: this.settings.isBlurEffect() })
                .onChange((isOn: boolean) => {
                  this.settings.setBlurEffect(isOn)
                })
            }
            .width('100%')
            .alignItems(VerticalAlign.Center)
            .padding({ left: 16, right: 16, top: 13, bottom: 13 })
            // 原版 y1.j3 case3：在设置中显示背景（w9.d.j 位4）+ toast u.tv
            Row() {
              Text('在设置中显示背景')
                .fontSize(15)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
                .layoutWeight(1)

              Toggle({ type: ToggleType.Switch, isOn: this.settings.isShowSettingsBackground() })
                .onChange((isOn: boolean) => {
                  this.settings.setShowSettingsBackground(isOn)
                  this.getUIContext().getPromptAction()
                    .showToast({ message: '将在下次打开设置时生效', duration: 1500 })
                })
            }
            .width('100%')
            .alignItems(VerticalAlign.Center)
            .padding({ left: 16, right: 16, top: 13, bottom: 13 })
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
export function SettingsExperimentalPageBuilder() {
  SettingsExperimentalPage()
}
