import { AppSettings } from '../common/Settings'
import { SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'
import { SettingsIndexEntry, searchSettingsEntries } from '../common/SettingsSearchIndex'

// 设置根页。原版 hb/o6：标题五连点（500ms 内第 5 次）切换 labflag 位1，
// 控制「实验」入口（hb/y1）的显隐；入口位于「关于」之前
// 顶部搜索框：输入关键词过滤全部设置条目（common/SettingsSearchIndex.ets），点击结果跳对应设置页
@ComponentV2
export struct SettingsPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  private lastTitleTap: number = 0
  private titleTapCount: number = 0
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  // 设置内搜索
  @Local searchKeyword: string = ''
  @Local searchResults: SettingsIndexEntry[] = []

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.settings'),
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

  private onSearchChange(value: string): void {
    this.searchKeyword = value
    if (value.trim() === '') {
      this.searchResults = []
      return
    }
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      this.searchResults = []
      return
    }
    this.searchResults = searchSettingsEntries(context, value)
  }

  private openEntry(entry: SettingsIndexEntry): void {
    this.navPathStack.pushPathByName(entry.route, entry.params !== undefined ? entry.params : '', true)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        // 顶部搜索框（原版设置页搜索条目入口，文案取 search：搜索/Search）
        Row() {
          TextInput({ placeholder: $r('app.string.search'), text: this.searchKeyword })
            .width('100%')
            .height(40)
            .fontSize(14)
            .backgroundColor($r('app.color.surface'))
            .borderRadius(20)
            .onChange((value: string) => {
              this.onSearchChange(value)
            })
        }
        .width('100%')
        .padding({ left: 16, right: 16, top: 8, bottom: 8 })
        Scroll() {
          if (this.searchKeyword.trim() === '') {
            Column() {
              SettingNavRow({ rowLabel: $r('app.string.general'), onTapRow: () => {
                this.navPathStack.pushPathByName('settingsGeneral', '', true)
              } })
              SettingNavRow({ rowLabel: $r('app.string.customize'), onTapRow: () => {
                this.navPathStack.pushPathByName('settingsCustom', '', true)
              } })
              SettingNavRow({ rowLabel: $r('app.string.privacy'), onTapRow: () => {
                this.navPathStack.pushPathByName('settingsPrivacy', '', true)
              } })
              SettingNavRow({ rowLabel: $r('app.string.advanced'), onTapRow: () => {
                this.navPathStack.pushPathByName('settingsAdvanced', '', true)
              } })
              SettingNavRow({ rowLabel: $r('app.string.scripts'), onTapRow: () => {
                this.navPathStack.pushPathByName('userScripts', '', true)
              } })
              if (this.settings.isLabEntryVisible()) {
                SettingNavRow({ rowLabel: $r('app.string.orig_ic'), onTapRow: () => {
                  this.navPathStack.pushPathByName('settingsExperimental', '', true)
                } })
              }
              SettingNavRow({ rowLabel: $r('app.string.about'), onTapRow: () => {
                this.navPathStack.pushPathByName('settingsAbout', '', true)
              } })
            }
            .width('100%')
          } else if (this.searchResults.length === 0) {
            Column() {
              // 空态与原版列表空态一致（z8/r3）
              Text('¯\\_(ツ)_/¯')
                .fontSize(15)
                .fontColor($r('app.color.fg_secondary'))
                .margin({ top: 32 })
            }
            .width('100%')
            .alignItems(HorizontalAlign.Center)
          } else {
            Column() {
              ForEach(this.searchResults, (entry: SettingsIndexEntry, index: number) => {
                SettingNavRow({
                  rowLabel: entry.label,
                  rowValue: entry.desc,
                  onTapRow: () => {
                    this.openEntry(entry)
                  }
                })
              }, (entry: SettingsIndexEntry, index: number) => `${entry.route}_${index}`)
            }
            .width('100%')
          }
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
        .width('100%')
        .height('100%')
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor(this.settings.isShowSettingsBackground()
      ? Color.Transparent : $r('app.color.page_bg'))
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
export function SettingsPageBuilder() {
  SettingsPage()
}
