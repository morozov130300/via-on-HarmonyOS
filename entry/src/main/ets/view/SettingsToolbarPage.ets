import { AppSettings } from '../common/Settings'
import { dialogTransition } from '../common/Transitions'
import { SettingCheckRow, SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { ViaIcon } from '../components/ViaIcon'
import { ConfigurationConstant, common } from '@kit.AbilityKit'

const LAYOUT_TRADITIONAL: number = 0
const LAYOUT_TOOLBAR_TOP: number = 1
const LAYOUT_TOOLBAR_BOTTOM: number = 2
const LAYOUT_DOUBLE: number = 3

const ROW_H: number = 48

class OptionItem {
  label: string
  value: number

  constructor(label: string, value: number) {
    this.label = label
    this.value = value
  }
}

// 应用布局数组 = 原版 arrays array i（a07/a06/a05/a03）
const LAYOUT_OPTIONS: OptionItem[] = [
  new OptionItem('layout_traditional', LAYOUT_TRADITIONAL),
  new OptionItem('layout_toolbar_top', LAYOUT_TOOLBAR_TOP),
  new OptionItem('layout_toolbar_bottom', LAYOUT_TOOLBAR_BOTTOM),
  new OptionItem('layout_double_toolbar', LAYOUT_DOUBLE)
]

// 自动隐藏数组 = 原版 arrays array d（jt/ju/jv）
const AUTO_HIDE_OPTIONS: OptionItem[] = [
  new OptionItem('auto_hide_always', 0),
  new OptionItem('auto_hide_swipe', 1),
  new OptionItem('auto_hide_tap', 2)
]

// 地址栏内容数组 = 原版 arrays array k（kg/kh/a0y）
const ADDRESS_CONTENT_OPTIONS: OptionItem[] = [
  new OptionItem('content_title', 0),
  new OptionItem('content_address', 1),
  new OptionItem('content_domain', 2)
]

@ComponentV2
export struct SettingsToolbarPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local layoutDialogId: number = -1
  @Local autoHideDialogId: number = -1
  @Local addressContentDialogId: number = -1
  @Local tabBarPickDialogId: number = -1

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.toolbar_settings'),
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
            // 原版 p3() 第一项 ib.b0：真实工具栏布局预览（ToolbarsViewDelegate）
            this.PreviewItem()

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
            SettingCheckRow({
              rowLabel: $r('app.string.enable_tab_bar'),
              isChecked: this.settings.tabBarEnabled,
              onCheckRow: (isOn: boolean) => {
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
            SettingCheckRow({
              rowLabel: $r('app.string.color_mode'),
              rowDesc: $r('app.string.color_mode_desc'),
              isChecked: this.settings.toolbarColorAdapt,
              onCheckRow: (isOn: boolean) => {
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

  // 原版 ToolbarsViewDelegate.d()/B()/A()：预览容器圆角 18dp + 2dp #30808080 描边；
  // 布局 0 = 透明底 + 左右 12dp；布局 1/2 = 胶囊底（亮 0x10000000/暗 0x22FFFFFF）+ 4dp；
  // 布局 3 = 同胶囊底 + 16dp
  @Builder
  PreviewItem() {
    Column() {
      // 标签栏预览行（原版 f10006i：globe 图标 + 「网页」文本，仅布局 1/2 且启用时显示）
      if (this.settings.tabBarEnabled && this.tabBarVisible()) {
        Row({ space: 10 }) {
          ViaIcon({ icon: $r('app.media.via_ic_globe'), iconSize: 20, iconColor: $r('app.color.icon') })
          Text($r('app.string.webpage'))
            .fontSize(14)
            .fontColor($r('app.color.fg_secondary'))
            .maxLines(1)
            .textOverflow({ overflow: TextOverflow.Ellipsis })
            .layoutWeight(1)
        }
        .width('100%')
        .height(36)
        .padding({ left: 12, right: 12 })
      }

      // 地址栏预览（原版 n0：左钮 + 标题 + 右刷新钮；标题按地址栏内容三态）
      Row() {
        ViaIcon({ icon: $r('app.media.via_ic_site_info'), iconSize: 22, iconColor: $r('app.color.appbar_icon') })
          .margin({ left: 13 })
        Text(this.previewTitle())
          .fontSize(16)
          .fontColor($r('app.color.appbar_text'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
          .layoutWeight(1)
          .textAlign(TextAlign.Center)
        ViaIcon({ icon: $r('app.media.via_ic_refresh'), iconSize: 22, iconColor: $r('app.color.appbar_icon') })
          .margin({ right: 13 })
      }
      .width('100%')
      .height(ROW_H)

      // 工具栏预览（原版 g0：返回/前进/主页/标签/菜单，accent 着色）
      Row() {
        ViaIcon({ icon: $r('app.media.via_ic_back'), iconSize: 24, iconColor: $r('app.color.accent') })
          .layoutWeight(1)
        ViaIcon({ icon: $r('app.media.via_ic_forward'), iconSize: 24, iconColor: $r('app.color.accent') })
          .layoutWeight(1)
        ViaIcon({ icon: $r('app.media.via_ic_home'), iconSize: 24, iconColor: $r('app.color.accent') })
          .layoutWeight(1)
        Text('1')
          .fontSize(11)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.accent'))
          .layoutWeight(1)
          .textAlign(TextAlign.Center)
        ViaIcon({ icon: $r('app.media.via_ic_menu'), iconSize: 24, iconColor: $r('app.color.accent') })
          .layoutWeight(1)
      }
      .width('100%')
      .height(ROW_H)
    }
    .width('100%')
    .constraintSize({ maxHeight: 300 })
    .margin({ left: 16, right: 16, top: 12, bottom: 8 })
    .borderRadius(18)
    .border({
      width: 2,
      color: $r('app.color.appbar_divider')
    })
    .backgroundColor(this.previewBackground())
    .padding(this.previewPadding())
    .alignItems(HorizontalAlign.Start)
  }

  // 原版 A()：地址栏预览标题三态（f14069m0=「网页」/完整地址/域名）
  private previewTitle(): string {
    const mode = this.settings.addressBarContent
    if (mode === 1) {
      return 'https://example.com/'
    }
    if (mode === 2) {
      return 'example.com'
    }
    return '网页'
  }

  // 原版 B()：按布局设置预览容器底色与 padding
  private previewBackground(): ResourceColor {
    const layout = this.settings.appLayout
    if (layout === LAYOUT_TRADITIONAL) {
      return Color.Transparent
    }
    return this.isDarkMode() ? '#22FFFFFF' : '#10000000'
  }

  private previewPadding(): Padding {
    const layout = this.settings.appLayout
    if (layout === LAYOUT_TRADITIONAL) {
      return { left: 12, right: 12 }
    }
    if (layout === LAYOUT_DOUBLE) {
      return { left: 16, right: 16 }
    }
    return { left: 4, right: 4 }
  }

  private isDarkMode(): boolean {
    try {
      const ctx = this.getUIContext().getHostContext() as common.UIAbilityContext
      return ctx.config.colorMode === ConfigurationConstant.ColorMode.COLOR_MODE_DARK
    } catch (error) {
      return false
    }
  }

  private tabBarVisible(): boolean {
    return this.settings.appLayout === LAYOUT_TOOLBAR_TOP || this.settings.appLayout === LAYOUT_TOOLBAR_BOTTOM
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
      maskColor: 'rgba(0,0,0,0.2)'
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

  private dialogTitle(kind: number): ResourceStr {
    if (kind === 1) {
      return $r('app.string.auto_hide_toolbar')
    }
    return $r('app.string.app_layout')
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
      this.closeDialog(1)
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

  // 原版 r3()：图形选择器对话框（com.tuyafeng.support.widget.c）
  // 标题 P5=自动隐藏操作栏；三个手机示意图 a8/a9/a_（50×90dp，圆角 6dp，1dp 描边）
  // 文案 jt/ju/jv；选中高亮 accent，未选中 icon 色；点击保存并关闭（m3）
  @Builder
  AutoHidePicker() {
    Column() {
      Text($r('app.string.auto_hide_toolbar'))
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
        .margin({ bottom: 8 })

      Row() {
        ForEach(AUTO_HIDE_OPTIONS, (option: OptionItem) => {
          Column() {
            this.PhoneSchematic(option.value)
            Text(this.autoHideOptionText(option.value))
              .fontSize(16)
              .fontColor(this.settings.toolbarAutoHide === option.value ?
                $r('app.color.accent') : $r('app.color.fg'))
              .fontWeight(this.settings.toolbarAutoHide === option.value ?
                FontWeight.Bold : FontWeight.Normal)
              .maxLines(1)
              .textOverflow({ overflow: TextOverflow.Ellipsis })
              .margin({ top: 6 })
          }
          .layoutWeight(1)
          .margin(4)
          .onClick(() => {
            this.applyOption(1, option.value)
          })
        }, (option: OptionItem) => `picker-${option.value}`)
      }
      .width('100%')
    }
    .width('72%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
    .transition(dialogTransition())
  }

  // 原版 drawable a8/a9/a_：layer-list 手机轮廓（50×90，圆角 6，1dp 描边）
  // 0=a8 内嵌全高操作条（上下 inset 10）；1=a9 中段操作条（上下 inset 6）；2=a_ 底部圆点（10dp，距底 10）
  @Builder
  PhoneSchematic(mode: number) {
    Stack() {
      Column()
        .width(50)
        .height(90)
        .borderRadius(6)
        .border({
          width: 1,
          color: this.schematicStroke(mode)
        })

      if (mode === 0 || mode === 1) {
        Column()
          .width(50)
          .height(mode === 0 ? 70 : 78)
          .border({
            width: 1,
            color: this.schematicStroke(mode)
          })
      }

      if (mode === 2) {
        Column()
          .width(10)
          .height(10)
          .borderRadius(5)
          .border({
            width: 1,
            color: this.schematicStroke(mode)
          })
          .position({ x: 20, y: 70 })
      }
    }
    .width(50)
    .height(90)
  }

  // 原版 f()：选中 = accent（SRC_ATOP 着色），未选中 = itemDrawableTint（icon 色）
  private schematicStroke(mode: number): ResourceColor {
    return this.settings.toolbarAutoHide === mode ? $r('app.color.accent') : $r('app.color.icon')
  }

  private autoHideOptionText(value: number): string {
    const labels: string[] = ['总是显示', '滑动来显示/隐藏', '点击来显示/隐藏']
    return labels[value]
  }

  // 原版 w5.k 单选对话框：标题 + 选项列表，无任何预览缩略图
  @Builder
  OptionDialog(kind: number) {
    if (kind === 1) {
      this.AutoHidePicker()
    } else {
      Column({ space: 8 }) {
        Text(this.dialogTitle(kind))
          .fontSize(17)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
          .width('100%')

        if (kind === 3) {
          Text($r('app.string.tab_bar_need_layout'))
            .fontSize(13)
            .fontColor($r('app.color.fg_secondary'))
            .width('100%')
        }

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
      .width('72%')
      .padding(20)
      .backgroundColor($r('app.color.menu_bg'))
      .borderRadius(16)
      .transition(dialogTransition())
    }
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
}

@Builder
export function SettingsToolbarPageBuilder() {
  SettingsToolbarPage()
}
