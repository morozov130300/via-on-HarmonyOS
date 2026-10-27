import { AppSettings } from '../common/Settings'
import { SettingToggleRow, SettingNavRow } from '../components/SettingRows'
import { SettingsHeader } from '../components/SettingsHeader'
import { ViaIcon } from '../components/ViaIcon'

const LAYOUT_TRADITIONAL: number = 0
const LAYOUT_TOOLBAR_TOP: number = 1
const LAYOUT_TOOLBAR_BOTTOM: number = 2
const LAYOUT_DOUBLE: number = 3

const AUTO_HIDE_ALWAYS: number = 0
const AUTO_HIDE_SWIPE: number = 1
const AUTO_HIDE_TAP: number = 2

const CARD_H: number = 112
const PAD: number = 8
const ROW_H: number = 26
const TAB_H: number = 22
const ICONS_W: number = 120

class OptionItem {
  label: string
  value: number

  constructor(label: string, value: number) {
    this.label = label
    this.value = value
  }
}

const LAYOUT_OPTIONS: OptionItem[] = [
  new OptionItem('layout_traditional', LAYOUT_TRADITIONAL),
  new OptionItem('layout_toolbar_top', LAYOUT_TOOLBAR_TOP),
  new OptionItem('layout_toolbar_bottom', LAYOUT_TOOLBAR_BOTTOM),
  new OptionItem('layout_double_toolbar', LAYOUT_DOUBLE)
]

const AUTO_HIDE_OPTIONS: OptionItem[] = [
  new OptionItem('auto_hide_always', AUTO_HIDE_ALWAYS),
  new OptionItem('auto_hide_swipe', AUTO_HIDE_SWIPE),
  new OptionItem('auto_hide_tap', AUTO_HIDE_TAP)
]

const ADDRESS_CONTENT_OPTIONS: OptionItem[] = [
  new OptionItem('content_title', 0),
  new OptionItem('content_address', 1),
  new OptionItem('content_domain', 2)
]

@ComponentV2
export struct SettingsToolbarPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local cardW: number = 300
  @Local layoutDialogId: number = -1
  @Local autoHideDialogId: number = -1
  @Local addressContentDialogId: number = -1
  @Local tabBarPickDialogId: number = -1

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '工具栏设置',
          onBack: () => {
            this.navPathStack.pop()
          }
        })
        Scroll() {
          Column() {
            this.PreviewCard()

            SettingNavRow({
              rowLabel: $r('app.string.app_layout'),
              rowValue: this.layoutLabel(),
              onTapRow: () => {
                this.openLayoutDialog()
              }
            })
            SettingNavRow({
              rowLabel: $r('app.string.auto_hide_toolbar'),
              rowValue: this.autoHideLabel(),
              onTapRow: () => {
                this.openAutoHideDialog()
              }
            })
            SettingToggleRow({
              rowLabel: $r('app.string.enable_tab_bar'),
              isToggleOn: this.settings.tabBarEnabled,
              onToggleRow: (isOn: boolean) => {
                this.toggleTabBar(isOn)
              }
            })
            SettingNavRow({
              rowLabel: $r('app.string.address_content'),
              rowValue: this.addressContentLabel(),
              onTapRow: () => {
                this.openAddressContentDialog()
              }
            })
            SettingToggleRow({
              rowLabel: $r('app.string.color_mode'),
              rowDesc: $r('app.string.color_mode_desc'),
              isToggleOn: this.settings.toolbarColorAdapt,
              onToggleRow: (isOn: boolean) => {
                this.settings.setToolbarColorAdapt(isOn)
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

  @Builder
  PreviewCard() {
    Stack({ alignContent: Alignment.Start }) {
      // 地址栏
      Row() {
        Row({ space: 6 }) {
          Text('网页')
            .fontSize(11)
            .fontColor($r('app.color.fg_secondary'))
            .maxLines(1)
          Blank()
          Circle({ width: 10, height: 10 })
            .fill(Color.Transparent)
            .stroke($r('app.color.fg_secondary'))
            .strokeWidth(1.2)
        }
        .padding({ left: 8, right: 8 })
        .height(ROW_H)
        .width(this.pillWidth())
        .backgroundColor(this.settings.toolbarColorAdapt ? '#333B4E' : '#1C1B1D')
        .borderRadius(ROW_H / 2)
        .animation({ duration: 260, curve: Curve.EaseInOut })
      }
      .height(ROW_H)
      .position({ x: PAD, y: this.addressY() })
      .animation({ duration: 260, curve: Curve.EaseInOut })

      // 工具栏按钮
      Row() {
        ViaIcon({ icon: $r('app.media.via_ic_back'), iconSize: 13, iconColor: $r('app.color.icon') })
          .width(24)
        ViaIcon({ icon: $r('app.media.via_ic_forward'), iconSize: 13, iconColor: $r('app.color.icon') })
          .width(24)
        ViaIcon({ icon: $r('app.media.via_ic_home'), iconSize: 13, iconColor: $r('app.color.icon') })
          .width(24)
        Text('1')
          .fontSize(11)
          .fontColor($r('app.color.icon'))
          .width(24)
          .textAlign(TextAlign.Center)
        ViaIcon({ icon: $r('app.media.via_ic_menu'), iconSize: 13, iconColor: $r('app.color.icon') })
          .width(24)
      }
      .height(ROW_H)
      .justifyContent(FlexAlign.SpaceBetween)
      .position({ x: this.iconsX(), y: this.iconsY() })
      .animation({ duration: 260, curve: Curve.EaseInOut })

      // 标签栏
      if (this.settings.tabBarEnabled && this.tabBarVisible()) {
        Row({ space: 6 }) {
          Circle({ width: 9, height: 9 })
            .fill(Color.Transparent)
            .stroke($r('app.color.fg_secondary'))
            .strokeWidth(1.2)
          Text('网页')
            .fontSize(10)
            .fontColor($r('app.color.fg_secondary'))
            .maxLines(1)
          Blank()
          Text('×')
            .fontSize(11)
            .fontColor($r('app.color.fg_tertiary'))
          Text('+')
            .fontSize(12)
            .fontColor($r('app.color.fg_secondary'))
            .margin({ left: 8 })
        }
        .padding({ left: 8, right: 8 })
        .height(TAB_H)
        .width(this.pillWidth())
        .backgroundColor('#161618')
        .borderRadius(6)
        .position({ x: PAD, y: this.tabY() })
        .transition(TransitionEffect.OPACITY.animation({ duration: 200 }))
      }
    }
    .width('100%')
    .height(CARD_H)
    .margin({ left: 16, right: 16, top: 12 })
    .backgroundColor('#0C0C0E')
    .borderRadius(12)
    .clip(true)
    .onAreaChange((_old: Area, newArea: Area) => {
      this.cardW = Number(newArea.width)
    })
  }

  private pillWidth(): number {
    const compact = this.settings.appLayout === LAYOUT_TOOLBAR_TOP || this.settings.appLayout === LAYOUT_TOOLBAR_BOTTOM
    return compact ? this.cardW - PAD * 2 - ICONS_W - 6 : this.cardW - PAD * 2
  }

  private addressY(): number {
    const layout = this.settings.appLayout
    if (layout === LAYOUT_TOOLBAR_TOP) {
      return PAD
    }
    if (layout === LAYOUT_TOOLBAR_BOTTOM) {
      return CARD_H - PAD - ROW_H
    }
    if (layout === LAYOUT_DOUBLE) {
      return CARD_H - PAD - ROW_H * 2 - 4
    }
    return PAD
  }

  private iconsY(): number {
    const layout = this.settings.appLayout
    if (layout === LAYOUT_TOOLBAR_TOP) {
      return PAD
    }
    return CARD_H - PAD - ROW_H
  }

  private iconsX(): number {
    const layout = this.settings.appLayout
    if (layout === LAYOUT_TOOLBAR_TOP || layout === LAYOUT_TOOLBAR_BOTTOM) {
      return PAD + this.pillWidth() + 6
    }
    return (this.cardW - ICONS_W) / 2
  }

  private tabBarVisible(): boolean {
    return this.settings.appLayout === LAYOUT_TOOLBAR_TOP || this.settings.appLayout === LAYOUT_TOOLBAR_BOTTOM
  }

  private tabY(): number {
    if (this.settings.appLayout === LAYOUT_TOOLBAR_TOP) {
      return PAD + ROW_H + 4
    }
    return CARD_H - PAD - ROW_H - TAB_H - 4
  }

  private layoutLabel(): string {
    const labels: string[] = ['传统', '工具栏在上', '工具栏在下', '双行工具栏']
    return labels[this.settings.appLayout]
  }

  private autoHideLabel(): string {
    const labels: string[] = ['总是显示', '滑动来显示/隐藏', '点击来显示/隐藏']
    return labels[this.settings.toolbarAutoHide]
  }

  private addressContentLabel(): string {
    const labels: string[] = ['标题', '地址', '域名']
    return labels[this.settings.addressBarContent]
  }

  private toggleTabBar(isOn: boolean): void {
    if (!isOn) {
      this.settings.setTabBarEnabled(false)
      return
    }
    if (this.settings.appLayout === LAYOUT_TRADITIONAL || this.settings.appLayout === LAYOUT_DOUBLE) {
      this.openTabBarPickDialog()
      return
    }
    this.settings.setTabBarEnabled(true)
  }

  private openDialog(dialogKind: number): void {
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.OptionDialog(dialogKind)
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.5)'
    }).then((dialogId: number) => {
      this.assignDialogId(dialogKind, dialogId)
    }).catch(() => {
      console.error('open toolbar dialog failed')
    })
  }

  private assignDialogId(dialogKind: number, dialogId: number): void {
    if (dialogKind === 0) {
      this.layoutDialogId = dialogId
    } else if (dialogKind === 1) {
      this.autoHideDialogId = dialogId
    } else if (dialogKind === 2) {
      this.addressContentDialogId = dialogId
    } else {
      this.tabBarPickDialogId = dialogId
    }
  }

  private openLayoutDialog(): void {
    this.openDialog(0)
  }

  private openAutoHideDialog(): void {
    this.openDialog(1)
  }

  private openAddressContentDialog(): void {
    this.openDialog(2)
  }

  private openTabBarPickDialog(): void {
    this.openDialog(3)
  }

  private closeDialog(dialogKind: number): void {
    let id = -1
    if (dialogKind === 0) {
      id = this.layoutDialogId
    } else if (dialogKind === 1) {
      id = this.autoHideDialogId
    } else if (dialogKind === 2) {
      id = this.addressContentDialogId
    } else {
      id = this.tabBarPickDialogId
    }
    if (id < 0) {
      return
    }
    try {
      this.getUIContext().getPromptAction().closeCustomDialog(id)
    } catch (error) {
      console.error('close toolbar dialog failed')
    }
    this.assignDialogId(dialogKind, -1)
  }

  private dialogTitle(kind: number): string {
    if (kind === 1) {
      return '自动隐藏操作栏'
    }
    return '应用布局'
  }

  private dialogOptions(kind: number): OptionItem[] {
    if (kind === 1) {
      return AUTO_HIDE_OPTIONS
    }
    if (kind === 2) {
      return ADDRESS_CONTENT_OPTIONS
    }
    if (kind === 3) {
      return [
        new OptionItem('layout_toolbar_top', LAYOUT_TOOLBAR_TOP),
        new OptionItem('layout_toolbar_bottom', LAYOUT_TOOLBAR_BOTTOM)
      ]
    }
    return LAYOUT_OPTIONS
  }

  private dialogCurrentValue(kind: number): number {
    if (kind === 1) {
      return this.settings.toolbarAutoHide
    }
    if (kind === 2) {
      return this.settings.addressBarContent
    }
    return this.settings.appLayout
  }

  private applyOption(kind: number, value: number): void {
    if (kind === 1) {
      this.settings.setToolbarAutoHide(value)
    } else if (kind === 2) {
      this.settings.setAddressBarContent(value)
    } else if (kind === 3) {
      this.settings.setAppLayout(value)
      this.settings.setTabBarEnabled(true)
      this.closeDialog(3)
    } else {
      this.settings.setAppLayout(value)
    }
  }

  @Builder
  OptionDialog(kind: number) {
    Column({ space: 8 }) {
      if (kind === 3) {
        Text('应用布局')
          .fontSize(17)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
          .width('100%')
        Text($r('app.string.tab_bar_need_layout'))
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .width('100%')
      } else if (kind !== 1) {
        Text('应用布局')
          .fontSize(17)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
          .width('100%')
      } else {
        Text($r('app.string.auto_hide_toolbar'))
          .fontSize(17)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
          .width('100%')
      }

      if (kind === 1) {
        Row({ space: 14 }) {
          ForEach(AUTO_HIDE_OPTIONS, (option: OptionItem) => {
            this.AutoHideMock(option)
          }, (option: OptionItem) => `${option.value}`)
        }
        .width('100%')
        .justifyContent(FlexAlign.Center)
        .margin({ top: 10 })
      } else {
        ForEach(this.dialogOptions(kind), (option: OptionItem) => {
          Row({ space: 14 }) {
            Circle({ width: 20, height: 20 })
              .fill(this.dialogCurrentValue(kind) === option.value ? $r('app.color.accent') : Color.Transparent)
              .stroke(this.dialogCurrentValue(kind) === option.value ? $r('app.color.accent') : $r('app.color.fg_secondary'))
              .strokeWidth(1.5)
            Text(this.optionText(option))
              .fontSize(15)
              .fontColor($r('app.color.fg'))
          }
          .width('100%')
          .height(42)
          .onClick(() => {
            this.applyOption(kind, option.value)
          })
        }, (option: OptionItem) => `${kind}-${option.value}`)
      }
    }
    .width('72%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
  }

  private optionText(option: OptionItem): string {
    const labels: Record<string, string> = {
      'layout_traditional': '传统',
      'layout_toolbar_top': '工具栏在上',
      'layout_toolbar_bottom': '工具栏在下',
      'layout_double_toolbar': '双行工具栏',
      'content_title': '标题',
      'content_address': '地址',
      'content_domain': '域名'
    }
    const label = labels[option.label]
    return label !== undefined ? label : option.label
  }

  @Builder
  AutoHideMock(option: OptionItem) {
    Column({ space: 8 }) {
      Column() {
        if (option.value === AUTO_HIDE_ALWAYS) {
          Rect({ width: 40, height: 4 })
            .fill(Color.Transparent)
            .stroke($r('app.color.fg_secondary'))
            .strokeWidth(1)
            .margin({ top: 4 })
          Blank()
          Rect({ width: 40, height: 4 })
            .fill(Color.Transparent)
            .stroke($r('app.color.fg_secondary'))
            .strokeWidth(1)
            .margin({ bottom: 4 })
        } else if (option.value === AUTO_HIDE_SWIPE) {
          Rect({ width: 40, height: 4 })
            .fill(Color.Transparent)
            .stroke($r('app.color.fg_secondary'))
            .strokeWidth(1)
            .margin({ top: 4 })
          Blank()
        } else {
          Blank()
          Circle({ width: 8, height: 8 })
            .fill(Color.Transparent)
            .stroke($r('app.color.fg_secondary'))
            .strokeWidth(1)
            .margin({ bottom: 8 })
        }
      }
      .width(52)
      .height(92)
      .borderRadius(10)
      .border({
        width: this.settings.toolbarAutoHide === option.value ? 2 : 1.2,
        color: this.settings.toolbarAutoHide === option.value ? $r('app.color.accent') : $r('app.color.fg_tertiary')
      })
      .animation({ duration: 150 })

      Text(this.autoHideOptionLabel(option.value))
        .fontSize(12)
        .fontColor(this.settings.toolbarAutoHide === option.value ? $r('app.color.accent') : $r('app.color.fg_secondary'))
    }
    .onClick(() => {
      this.settings.setToolbarAutoHide(option.value)
    })
  }

  private autoHideOptionLabel(value: number): string {
    if (value === AUTO_HIDE_SWIPE) {
      return '滑动来显示…'
    }
    if (value === AUTO_HIDE_TAP) {
      return '点击来显示…'
    }
    return '总是显示'
  }
}

@Builder
export function SettingsToolbarPageBuilder() {
  SettingsToolbarPage()
}
