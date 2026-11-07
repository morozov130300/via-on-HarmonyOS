import { AppSettings } from '../common/Settings'
import { computeDialogWidthVp } from '../components/ViaDialogCard'
import { dialogTransition } from '../common/Transitions'
import { SettingCheckRow, SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { ViaIcon } from '../components/ViaIcon'
import { buildNavSlide } from './PageTransitions'

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
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
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

  // 原版 hb/l6.i3()：动作选择列表（无操作 + 四分组，顺序与分组归属逐项照搬）。
  // 原版结构 = 全屏子页 hb/l6（o8.g），非弹窗：标题「选择行为」，右侧动作「保存」(u.ap)；
  // 点击行仅切换选中（l6.m3），「保存」写入并返回（l3→k3）；disposable=true 时无「保存」，
  // 点击行立即写入返回（u4.h3 / n7 通过 f6647t0 区分）。
  // 本页沿用原版的数据结构，但落地为原版 w5.k 中心弹窗样式（与 OptionDialog 同壳），
  // 避免为一个选择器新开 NavDestination 页面栈。
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
    // 原版 w5.k 弹窗卡（layout u + drawable t/u）：18dp 圆角 + 1dp 描边 + dialog_bg，
    // 标题 16sp 粗体（u.f13983fc 选择行为），分组标题 a6/m（14sp bold，attr a7 强调色），
    // 选项行 a6/i（14sp，attr ac，上下 20dp/左右 16dp padding，按压底 drawable p #30808080）
    Column() {
      Text($r('app.string.toolbar_action_title'))
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.dialog_text'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })

      Scroll() {
        Column() {
          this.ActionRow(0)
          ForEach(ACTION_GROUPS, (group: ActionGroup) => {
            // a6/m 分组标题：14sp bold attr a7，margin 左16 右16 上12 下4
            Text(group.title)
              .fontSize(14)
              .fontWeight(FontWeight.Bold)
              .fontColor($r('app.color.dialog_action'))
              .width('100%')
              .padding({ left: 16, right: 16, top: 12, bottom: 4 })
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

      // 底部按钮行：gravity end（保存）+ 左侧取消（w5/k layout u 顺序）
      Row() {
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeActionPicker()
          })
        Text($r('app.string.reset'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.saveActionPicker()
          })
      }
      .width('100%')
      .justifyContent(FlexAlign.End)
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  @Builder
  ActionRow(action: number) {
    // a6/i 行：上下 20dp / 左右 16dp，14sp attr ac；选中 accent，未选中 fg；
    // 按压底 drawable p（#30808080），无圆角（原版全宽行）
    Row() {
      Text(ACTION_NAMES[action])
        .fontSize(14)
        .fontColor(this.pickerValue === action ? $r('app.color.accent') : $r('app.color.dialog_text'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .layoutWeight(1)
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 13, bottom: 13 })
    .stateStyles({
      pressed: {
        .backgroundColor('rgba(128,128,128,0.19)')
      },
      normal: {
        .backgroundColor(Color.Transparent)
      }
    })
    .onClick(() => {
      this.pickerValue = action
    })
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
    // 原版 hb/n7.r3：图形选择器弹窗 = w5.k 中心弹窗卡（drawable t/u 壳）+
    // com.tuyafeng.support.widget.c：三个手机示意图 a8/a9/a_（50×90dp 圆角6dp 1dp描边），
    // 选中 accent、未选中 icon 色；点击立即保存关闭（n7.m3）
    Column() {
      Text($r('app.string.auto_hide_toolbar'))
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.dialog_text'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })

      Row() {
        ForEach(AUTO_HIDE_OPTIONS, (option: OptionItem) => {
          Column() {
            this.PhoneSchematic(option.value)
            Text(this.autoHideOptionText(option.value))
              .fontSize(14)
              .fontColor(this.settings.toolbarAutoHide === option.value ?
                $r('app.color.accent') : $r('app.color.dialog_text'))
              .maxLines(1)
              .textOverflow({ overflow: TextOverflow.Ellipsis })
              .margin({ top: 8 })
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
    .width('100%')
    .padding({ top: 12, bottom: 16 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
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

  // 原版 w5.k 单选对话框（layout u + w5.d 列表）：标题 16sp 粗体 + 选项行 14sp，
  // 16dp 圆形单选钮（drawable p checked=q #6f8de1 / unchecked=2dp 描边 #30808080）、
  // 行 padV 12 padH 16、图标-文字间距 24dp（dimen a4），点击选中关闭
  @Builder
  OptionDialog(kind: number) {
    if (kind === 1) {
      this.AutoHidePicker()
    } else {
      Column() {
        Text(this.dialogTitle(kind))
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.dialog_text'))
          .maxLines(1)
          .width('100%')
          .padding({ top: 8, bottom: 8 })
          .margin({ left: 16, right: 16, bottom: 6 })

        if (kind === 3) {
          Text($r('app.string.tab_bar_need_layout'))
            .fontSize(14)
            .fontColor($r('app.color.dialog_text'))
            .width('100%')
            .padding({ left: 16, right: 16, top: 4, bottom: 4 })
        }

        ForEach(this.dialogOptions(kind), (option: OptionItem) => {
          Row({ space: 24 }) {
            Circle({ width: 16, height: 16 })
              .fill(this.dialogCurrentValue(kind) === option.value ? $r('app.color.accent') : Color.Transparent)
              .stroke(this.dialogCurrentValue(kind) === option.value ? Color.Transparent : $r('app.color.dialog_border'))
              .strokeWidth(2)
            Text(this.optionText(option))
              .fontSize(14)
              .fontColor($r('app.color.dialog_text'))
              .maxLines(1)
              .textOverflow({ overflow: TextOverflow.Ellipsis })
              .layoutWeight(1)
          }
          .width('100%')
          .padding({ left: 16, right: 16, top: 12, bottom: 12 })
          .stateStyles({
            pressed: {
              .backgroundColor('rgba(128,128,128,0.19)')
            },
            normal: {
              .backgroundColor(Color.Transparent)
            }
          })
          .onClick(() => {
            this.applyOption(kind, option.value)
          })
        }, (option: OptionItem) => `${kind}-${option.value}`)
      }
      .width('100%')
      .padding({ top: 12, bottom: 12 })
      .backgroundColor($r('app.color.dialog_bg'))
      .borderRadius(18)
      .border({ width: 1, color: $r('app.color.dialog_border') })
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
