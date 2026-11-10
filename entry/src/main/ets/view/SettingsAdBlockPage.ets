import { AppSettings } from '../common/Settings'
import { RemoteConfig } from '../common/RemoteConfig'
import { SettingNavRow, SettingCheckRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'

@ComponentV2
export struct SettingsAdBlockPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.ad_block'),
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
            SettingCheckRow({
              rowLabel: $r('app.string.ad_block'),
              // 原版 z7/d.java:45：关→「未启用」(g_)；开→「已拦截 %1$d 个广告，共节省 %2$s」(b6)
              rowDesc: this.settings.adBlockOn
                ? `已拦截 ${this.settings.adBlockTotal} 个广告，共节省 ${this.formatBytes(this.settings.adBlockSavedBytes)}`
                : $r('app.string.script_disabled'),
              isChecked: this.settings.adBlockOn,
              onCheckRow: (isOn: boolean) => {
                this.settings.setAdBlockOn(isOn)
              }
            })
            SettingCheckRow({
              rowLabel: $r('app.string.orig_hj'),
              rowDesc: $r('app.string.orig_hk'),
              isChecked: this.settings.adBlockBuiltin,
              onCheckRow: (isOn: boolean) => {
                this.settings.setAdBlockBuiltin(isOn)
              }
            })
            SettingNavRow({
              rowLabel: $r('app.string.custom_rules'),
              rowDesc: $r('app.string.orig_ew'),
              onTapRow: () => {
                this.navPathStack.pushPathByName('rules', '', true)
              }
            })
            SettingNavRow({
              rowLabel: $r('app.string.orig_jf'),
              rowDesc: $r('app.string.orig_jg'),
              onTapRow: () => {
                this.navPathStack.pushPathByName('ruleSub', '', true)
              }
            })
            // 原版 z7/d.java:49-55：r9 fl1 位开关（h.e() = !(第1位)，默认可见）控制第 5 项显隐
            if (RemoteConfig.getInstance().autoExpandSwitchVisible) {
              SettingCheckRow({
                rowLabel: $r('app.string.orig_ia'),
                rowDesc: $r('app.string.orig_ib'),
                isChecked: this.settings.autoExpandFullText,
                onCheckRow: (isOn: boolean) => {
                  this.settings.setAutoExpandFullText(isOn)
                }
              })
            }
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

  private formatBytes(bytes: number): string {
    if (bytes < 1024) {
      return `${bytes.toFixed(1)} B`
    }
    if (bytes < 1024 * 1024) {
      return `${(bytes / 1024).toFixed(1)} KB`
    }
    if (bytes < 1024 * 1024 * 1024) {
      return `${(bytes / 1024 / 1024).toFixed(1)} MB`
    }
    return `${(bytes / 1024 / 1024 / 1024).toFixed(1)} GB`
  }
}

@Builder
export function SettingsAdBlockPageBuilder() {
  SettingsAdBlockPage()
}
