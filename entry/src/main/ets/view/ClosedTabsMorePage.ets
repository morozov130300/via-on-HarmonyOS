import { AppSettings } from '../common/Settings'
import { ViaIcon } from '../components/ViaIcon'
import { AppIcon } from '../components/AppIcon'
import { SettingNavRow, SettingCheckRow } from '../components/SettingRows'
import { UiInsets } from '../common/Immersive'
import { buildNavSlide } from './PageTransitions'

// 原版 hb/e7.java 1:1 移植（关闭的标签页 →「更多」nu →「标签页设置」Pd vs）：
// - 行 1（a6.q）「启动时恢复未关闭标签」(s3 nb)：值 = 当前模式（w9.l u1），点击弹三选一
//   [禁用恢复(gd)/总是恢复(c_)/优先询问(ch)]，选中写 restoreclosedtabs；
//   选非 0 时 toast s5「开启"隐身模式"时不会恢复未关闭标签。」
// - 行 2（a6.n switch）「显示撤销关闭标签的提示」(tz Dc)，副标题 u0（隐身时不提示），
//   开关写 undoCloseToast（w9.a.L + q0）

@ComponentV2
export struct ClosedTabsMorePage {
  private settings: AppSettings = AppSettings.getInstance()
  private insets: UiInsets = UiInsets.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  // 弹层（原版 w5.k 三选一锚定行 1）
  @Local modeMenuOpen: boolean = false

  build() {
    NavDestination() {
      Column() {
        this.HeaderBar()
        Column() {
          Stack() {
            Column() {
              SettingNavRow({
                rowLabel: '启动时恢复未关闭标签',
                rowValue: this.restoreModeLabel(),
                onTapRow: (): void => {
                  this.modeMenuOpen = !this.modeMenuOpen
                }
              })
              Divider()
                .strokeWidth(0.5)
                .color($r('app.color.divider'))
                .margin({ left: 16, right: 16 })
              SettingCheckRow({
                rowLabel: '显示撤销关闭标签的提示',
                rowDesc: '如果开启了隐身模式，则不会显示提示',
                isChecked: this.settings.undoCloseToast,
                onCheckRow: (isOn: boolean): void => {
                  this.settings.setUndoCloseToast(isOn)
                }
              })
            }
            .width('92%')
            .borderRadius(14)
            .backgroundColor($r('app.color.surface'))
            // 三选一弹层锚定行 1（原版 e7.k3 → d0(nb).Z(array g, u1())）
            .bindPopup(this.modeMenuOpen, {
              builder: (): void => {
                this.ModeMenu()
              },
              placement: Placement.Bottom,
              popupColor: Color.Transparent,
              enableArrow: false,
              autoCancel: true,
              onStateChange: (e: PopupStateChangeParam) => {
                if (!e.isVisible) {
                  this.modeMenuOpen = false
                }
              }
            })
          }
          .width('100%')
        }
        .width('100%')
        .padding({ top: 12 })
        .layoutWeight(1)
        .alignItems(HorizontalAlign.Start)
      }
      .width('100%')
      .height('100%')
      .backgroundColor($r('app.color.page_bg'))
    }
    .hideTitleBar(true)
    .padding({ top: this.insets.top })
    .backgroundColor($r('app.color.page_bg'))
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
    })
  }

  @Builder
  HeaderBar() {
    Row() {
      Stack({ alignContent: Alignment.Center }) {
        ViaIcon({ icon: $r('app.media.via_ic_back'), iconSize: 22, iconColor: $r('app.color.fg') })
      }
        .width(44)
        .height(43)
        .onClick(() => {
          this.navPathStack.pop()
        })
      Text('标签页设置')
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .layoutWeight(1)
        .padding({ left: 10, right: 10, top: 10, bottom: 10 })
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
    }
    .width('100%')
    .height(43)
  }

  // 三选一（w9.l u1()：0 禁用恢复 / 1 总是恢复 / 2 优先询问）
  @Builder
  ModeMenu() {
    Column() {
      this.ModeItem('禁用恢复', 0)
      this.ModeItem('总是恢复', 1)
      this.ModeItem('优先询问', 2)
    }
    .width(200)
    .padding({ top: 8, bottom: 8 })
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
  }

  @Builder
  ModeItem(label: string, mode: number) {
    Row({ space: 8 }) {
      Text(label)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .layoutWeight(1)
      if (this.settings.restoreTabsMode === mode) {
        AppIcon({ icon: $r('sys.symbol.checkmark'), iconSize: 14, iconColor: $r('app.color.accent') })
      }
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 12, bottom: 12 })
    .onClick(() => {
      this.modeMenuOpen = false
      this.settings.setRestoreTabsMode(mode)
      if (mode !== 0) {
        // 原版 e7.g3：选非 0 toast s5
        this.getUIContext().getPromptAction().showToast({
          message: '开启"隐身模式"时不会恢复未关闭标签。', duration: 1500
        })
      }
    })
  }

  private restoreModeLabel(): string {
    if (this.settings.restoreTabsMode === 1) {
      return '总是恢复'
    }
    if (this.settings.restoreTabsMode === 2) {
      return '优先询问'
    }
    return '禁用恢复'
  }
}

@Builder
export function ClosedTabsMorePageBuilder() {
  ClosedTabsMorePage()
}
