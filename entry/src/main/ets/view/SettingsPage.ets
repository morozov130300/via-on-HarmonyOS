import { AppSettings } from '../common/Settings'
import { SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'

// 设置根页。原版 hb/o6：标题五连点（500ms 内第 5 次）切换 labflag 位1，
// 控制「实验」入口（hb/y1）的显隐；入口位于「关于」之前
@ComponentV2
export struct SettingsPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  private lastTitleTap: number = 0
  private titleTapCount: number = 0

  private bindAppBar(): void {
    AppBar.show({
      title: '设置',
      onBack: () => {
        this.navPathStack.pop()
      },
      onTitle: () => {
        this.onTitleTap()
      }
    }, this)
  }

  // 原版 o6.h3：500ms 内连点 5 次标题切换 labflag 位1（实验入口）
  private onTitleTap(): void {
    const now = Date.now()
    if (now - this.lastTitleTap < 500) {
      this.titleTapCount++
    } else {
      this.titleTapCount = 1
    }
    this.lastTitleTap = now
    if (this.titleTapCount === 5) {
      const flags = this.settings.labFlag
      this.settings.setLabFlag((flags & 1) !== 0 ? (flags & ~1) : (flags | 1))
      this.titleTapCount = 0
    }
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
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
              this.navPathStack.pushPathByName('userScripts', '', true)
            } })
            if (this.settings.isLabEntryVisible()) {
              SettingNavRow({ rowLabel: '实验', onTapRow: () => {
                this.navPathStack.pushPathByName('settingsExperimental', '', true)
              } })
            }
            SettingNavRow({ rowLabel: '关于', onTapRow: () => {
              this.navPathStack.pushPathByName('settingsAbout', '', true)
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
export function SettingsPageBuilder() {
  SettingsPage()
}
