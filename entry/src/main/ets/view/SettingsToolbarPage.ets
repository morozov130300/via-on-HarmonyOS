import { AppSettings } from '../common/Settings'
import { dialogTransition } from '../common/Transitions'
import { SettingCheckRow, SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { ViaIcon } from '../components/ViaIcon'

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

// 原版 hb/v4.b()：动作编号 → 文案（逐条对应 x7.u 资源）
const ACTION_NAMES: Record<number, string> = {
  0: '无操作',
  1: '刷新网页',
  2: '返回顶部',
  3: '滑到底部',
  4: '输入网址',
  5: '新建标签',
  6: '添加书签',
  7: '打开书签',
  8: '打开历史',
  9: '关闭标签',
  10: '上一个标签',
  11: '下一个标签',
  12: '网页后退',
  13: '网页前进',
  14: '页内查找',
  15: '翻译',
  16: '关闭所有标签页',
  17: '向上翻页',
  18: '向下翻页',
  19: '保存网页',
  20: '源码',
  23: '显示标签面板',
  24: '朗读网页',
  25: '阅读模式',
  26: '打开设置',
  27: '复制标签页',
  28: '打开下载',
  29: '打开 AI 面板',
  30: '打开书签对话框'
}

class ActionGroup {
  title: string
  items: number[]

  constructor(title: string, items: number[]) {
    this.title = title
    this.items = items
  }
}

// 原版 hb/l6.i3()：分组顺序与归属
const ACTION_GROUPS: ActionGroup[] = [
  new ActionGroup('标签页行为', [5, 10, 11, 12, 13, 9, 16, 27]),
  new ActionGroup('特性行为', [7, 30, 8, 23, 28, 26, 14, 15, 24, 25, 29]),
  new ActionGroup('地址栏行为', [4]),
  new ActionGroup('网页行为', [19, 1, 20, 6, 18, 17, 2, 3])
]

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
  @Local pickerDialogId: number = -1
  @Local pickerTarget: string = ''
  @Local pickerValue: number = 0

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

  // 原版 ib/m.d()：预览 = 说明文字 + 一条真实工具栏（g0）
  // 提示文案 x7.u.zu：「点击下列按钮来设置它的长按事件，长按查看它的事件。你也可以滑动工具栏来设置滑动事件。」
  // 文字 padding 16/10（h6.a.H(1,16,10,16,10)），工具栏高 48dp（dimen b），无圆角/描边/卡片容器
  @Builder
  PreviewItem() {
    Column() {
      Text('点击下列按钮来设置它的长按事件，长按查看它的事件。你也可以滑动工具栏来设置滑动事件。')
        .fontSize(14)
        .fontColor($r('app.color.fg_secondary'))
        .width('100%')
        .padding({ left: 16, right: 16, top: 10, bottom: 10 })

      // 原版 g0.i()：地址槽未填充时宽度 0，五个图标槽各 weight 1
      Row() {
        this.PreviewSlot('back', $r('app.media.via_ic_back'), 0)
        this.PreviewSlot('forward', $r('app.media.via_ic_back'), 180)
        this.PreviewSlot('home', $r('app.media.via_ic_home'), 0)
        this.PreviewTabsSlot()
        this.PreviewSlot('menu', $r('app.media.via_ic_menu'), 0)
      }
      .width('100%')
      .height(ROW_H)
      // 原版 ib/m.n()：拖动距离 |f10| >= 0.8（84dp 拖距）时按方向打开滑动动作设置
      .gesture(PanGesture({ fingers: 1, direction: PanDirection.Horizontal, distance: 1 })
        .onActionEnd((event: GestureEvent) => {
          const fraction = px2vp(event.offsetX) / 84
          if (Math.abs(fraction) < 0.8) {
            return
          }
          this.openActionPicker(fraction > 0 ? 'swipe0' : 'swipe1')
        }))
    }
    .width('100%')
  }

  // 原版 g0.g()：图标 22dp（48 - 13*2 内容区），accent 着色；点击/长按设置该按钮长按动作
  @Builder
  PreviewSlot(target: string, icon: Resource, rotate: number) {
    Column() {
      ViaIcon({
        icon: icon,
        iconSize: 22,
        iconColor: $r('app.color.accent'),
        rotateDeg: rotate
      })
    }
    .layoutWeight(1)
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .alignItems(HorizontalAlign.Center)
    .onClick(() => {
      this.openActionPicker(target)
    })
    .gesture(LongPressGesture({ repeat: false, duration: 400 }).onAction(() => {
      this.openActionPicker(target)
    }))
  }

  // 原版 g0.h()：标签槽 = 方框图标 + 居中加粗数字
  @Builder
  PreviewTabsSlot() {
    Stack() {
      ViaIcon({ icon: $r('app.media.via_ic_tabs'), iconSize: 22, iconColor: $r('app.color.accent') })
      Text('1')
        .fontSize(11)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.accent'))
        .maxLines(1)
    }
    .layoutWeight(1)
    .height('100%')
    .alignContent(Alignment.Center)
    .onClick(() => {
      this.openActionPicker('tab')
    })
    .gesture(LongPressGesture({ repeat: false, duration: 400 }).onAction(() => {
      this.openActionPicker('tab')
    }))
  }

  // 原版 hb/l6.i3()：动作选择列表（无操作 + 四分组，顺序与分组归属逐项照搬）
  private openActionPicker(target: string): void {
    this.pickerTarget = target
    this.pickerValue = this.actionValueOf(target)
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.ActionPicker()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.2)'
    }).then((dialogId: number) => {
      this.pickerDialogId = dialogId
    }).catch(() => {
      console.error('open action picker failed')
    })
  }

  private actionValueOf(target: string): number {
    if (target === 'back') {
      return this.settings.keyback
    }
    if (target === 'forward') {
      return this.settings.keyforward
    }
    if (target === 'home') {
      return this.settings.keyhome
    }
    if (target === 'tab') {
      return this.settings.keytab
    }
    if (target === 'menu') {
      return this.settings.keymenu
    }
    if (target === 'swipe0') {
      return this.settings.gesturetoolbarleft
    }
    return this.settings.gesturetoolbarright
  }

  // 原版 l6.l3()：点「保存」才写入
  private saveActionPicker(): void {
    if (this.pickerTarget === 'swipe0' || this.pickerTarget === 'swipe1') {
      this.settings.setGestureToolbar(this.pickerTarget === 'swipe0' ? 0 : 1, this.pickerValue)
    } else {
      this.settings.setToolbarKey(this.pickerTarget, this.pickerValue)
    }
    this.closeActionPicker()
  }

  private closeActionPicker(): void {
    if (this.pickerDialogId < 0) {
      return
    }
    try {
      this.getUIContext().getPromptAction().closeCustomDialog(this.pickerDialogId)
    } catch (error) {
      console.error('close action picker failed')
    }
    this.pickerDialogId = -1
  }

  @Builder
  ActionPicker() {
    Column() {
      Text(this.pickerTitle())
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')

      Scroll() {
        Column() {
          this.ActionRow(0)
          ForEach(ACTION_GROUPS, (group: ActionGroup) => {
            Text(group.title)
              .fontSize(13)
              .fontColor($r('app.color.fg_secondary'))
              .width('100%')
              .height(34)
              .textAlign(TextAlign.Start)
            ForEach(group.items, (action: number) => {
              this.ActionRow(action)
            }, (action: number) => `act-${action}`)
          }, (group: ActionGroup) => `grp-${group.title}`)
        }
        .width('100%')
      }
      .width('100%')
      .constraintSize({ maxHeight: 400 })
      .scrollBar(BarState.Auto)

      Row() {
        Blank()
        Text('取消')
          .fontSize(15)
          .fontColor($r('app.color.fg_secondary'))
          .padding({ left: 16, right: 16, top: 10, bottom: 10 })
          .onClick(() => {
            this.closeActionPicker()
          })
        Text('保存')
          .fontSize(15)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.accent'))
          .padding({ left: 16, right: 16, top: 10, bottom: 10 })
          .onClick(() => {
            this.saveActionPicker()
          })
      }
      .width('100%')
      .margin({ top: 8 })
    }
    .width('78%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
    .transition(dialogTransition())
  }

  @Builder
  ActionRow(action: number) {
    Row() {
      Text(ACTION_NAMES[action])
        .fontSize(15)
        .fontColor(this.pickerValue === action ? $r('app.color.accent') : $r('app.color.fg'))
        .fontWeight(this.pickerValue === action ? FontWeight.Medium : FontWeight.Normal)
        .layoutWeight(1)
    }
    .width('100%')
    .height(42)
    .onClick(() => {
      this.pickerValue = action
    })
  }

  private pickerTitle(): string {
    const titles: Record<string, string> = {
      'back': '返回',
      'forward': '前进',
      'home': '主页',
      'tab': '标签',
      'menu': '菜单',
      'swipe0': '向左滑动',
      'swipe1': '向右滑动'
    }
    const title = titles[this.pickerTarget]
    return title !== undefined ? title : ''
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
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.OptionDialog(dialogKind)
      },
      isModal: true,
      backgroundColor: Color.Transparent,
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
