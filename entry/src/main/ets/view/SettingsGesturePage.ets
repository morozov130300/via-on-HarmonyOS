import { deviceInfo } from '@kit.BasicServicesKit'
import { AppSettings } from '../common/Settings'
import { SettingCheckRow, SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { UiaIcon } from '../components/UiaIcon'
import { computeDialogWidthVp } from '../components/UiaDialogCard'
import { dialogTransition } from '../common/Transitions'
import { buildNavSlide } from './PageTransitions'
import { TOOLBAR_ACTION_NAMES } from './SettingsToolbarPage'

const ROW_H: number = 48

// 原版 ib/m 的 5 个按钮槽 → 动作存储键 target（同 SettingsToolbarPage 语义）
type SlotTarget = 'back' | 'forward' | 'home' | 'tab' | 'menu'

@ComponentV2
export struct SettingsGesturePage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  // 动作选择弹窗状态（原版 hb/l6 disposable 模式：点行立即写入返回）
  @Local pickerDialogId: number = -1
  @Local pickerTarget: string = ''
  @Local pickerValue: number = 0
  // Snackbar 状态（原版 g6/n.t：底部深色条 + 「修改」动作按钮，2750ms 自动消失）
  @Local snackbarText: string = ''
  @Local snackbarActionText: string = ''
  private snackbarCallback: (() => void) | null = null
  private snackbarTimer: number = -1

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.orig_to'),
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
              rowLabel: $r('app.string.orig_cm'),
              isChecked: this.settings.swipeSwitchTab,
              onCheckRow: (isOn: boolean) => {
                this.settings.setSwipeSwitchTab(isOn)
              }
            })
            SettingCheckRow({
              rowLabel: $r('app.string.orig_a1l'),
              isChecked: this.settings.volumePageFlip,
              onCheckRow: (isOn: boolean) => {
                this.settings.setVolumePageFlip(isOn)
              }
            })
            SettingCheckRow({
              rowLabel: $r('app.string.orig_hq'),
              rowDesc: $r('app.string.orig_hr'),
              isChecked: this.settings.videoGesture,
              onCheckRow: (isOn: boolean) => {
                this.settings.setVideoGesture(isOn)
              }
            })
            SettingNavRow({ rowLabel: $r('app.string.orig_m5'), onTapRow: () => {
              this.navPathStack.pushPathByName('keyboardShortcuts', '', true)
            } })
            // 原版 u4.X1 尾部 add("")：String 行由 ib.m 渲染 = 工具栏动作分配预览
            this.ToolbarActionPreview()
          }
          .width('100%')
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
        .overlay(this.SnackbarHost(), { align: Alignment.Bottom })
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor(AppSettings.getInstance().isSettingsBackgroundVisible() && deviceInfo.sdkApiVersion >= 29
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

  // ============ 原版 ib/m：工具栏动作分配预览 ============
  // 说明文字（x7.u.Gg→zu）+ 一条 5 槽工具栏（g0.i：back/forward/home/tabs/menu）。
  // 点击槽位 → n3 → 直接开 hb/l6 动作选择器（disposable）；
  // 长按槽位 → m3 → Snackbar 显示当前动作 + 「修改」按钮 → 选择器；
  // 横滑整条（|比例| >= 0.8，拖距 84dp）→ n3(5/6) → 左/右滑动动作选择器。
  @Builder
  ToolbarActionPreview() {
    Column() {
      Text($r('app.string.orig_zu'))
        .fontSize(14)
        .fontColor($r('app.color.fg_secondary'))
        .width('100%')
        .padding({ left: 16, right: 16, top: 10, bottom: 10 })

      // 原版 g0.i()：五个图标槽各 weight 1（预览无地址槽）
      Row() {
        this.PreviewSlot('back', $r('app.media.uia_ic_back'), 0)
        this.PreviewSlot('forward', $r('app.media.uia_ic_back'), 180)
        this.PreviewSlot('home', $r('app.media.uia_ic_home'), 0)
        this.PreviewTabsSlot()
        this.PreviewSlot('menu', $r('app.media.uia_ic_menu'), 0)
      }
      .width('100%')
      .height(ROW_H)
      // 原版 ib/m.n()：拖动 |f10| >= 0.8（84dp 拖距）按方向打开滑动动作设置
      .gesture(PanGesture({ fingers: 1, direction: PanDirection.Horizontal, distance: 1 })
        .onActionEnd((event: GestureEvent) => {
          const fraction = px2vp(event.offsetX) / 84
          if (Math.abs(fraction) < 0.8) {
            return
          }
          // 原版 ib/m.m：f10>0 → b(5) 左滑动作；否则 b(6) 右滑动作
          this.openActionPicker(fraction > 0 ? 'swipe0' : 'swipe1')
        }))
    }
    .width('100%')
  }

  // 原版 g0.g()：图标 22dp accent 着色；点击 = b(i) 选择器，长按 = a(i) Snackbar
  @Builder
  PreviewSlot(target: SlotTarget, icon: Resource, rotate: number) {
    Column() {
      UiaIcon({
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
    .gesture(LongPressGesture({ repeat: false, duration: 500 }).onAction(() => {
      this.showActionSnackbar(this.actionValueOf(target), target)
    }))
  }

  // 原版 g0.h()：标签槽 = 方框图标 + 居中加粗数字
  @Builder
  PreviewTabsSlot() {
    Stack() {
      UiaIcon({ icon: $r('app.media.uia_ic_tabs'), iconSize: 22, iconColor: $r('app.color.accent') })
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
    .gesture(LongPressGesture({ repeat: false, duration: 500 }).onAction(() => {
      this.showActionSnackbar(this.actionValueOf('tab'), 'tab')
    }))
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

  private actionNameOf(action: number): string {
    const name = TOOLBAR_ACTION_NAMES[action]
    return name !== undefined ? name : '无操作'
  }

  // 原版 u4.m3(i10)：g6.n.t(当前动作名, Z0(u.M=ab 修改), click→n3)
  // Snackbar 文案 = v4.b(当前动作)（不带槽位前缀，与工具栏设置页 zq/zr 格式不同）
  private showActionSnackbar(action: number, target: string): void {
    this.showSnackbar(this.actionNameOf(action), this.modifyLabel(), (): void => {
      this.openActionPicker(target)
    })
  }

  // x7.u.M → ab「修改」（Snackbar 动作按钮文案；跟随系统语言取资源）
  private modifyLabel(): string {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return '修改'
    }
    try {
      return context.resourceManager.getStringByNameSync('orig_ab')
    } catch (error) {
      return '修改'
    }
  }

  // 原版 g6/n.t → u()：Snackbar（消息 + 动作按钮，2750ms 自动消失）
  private showSnackbar(text: string, actionText: string, onAction: () => void): void {
    this.snackbarText = text
    this.snackbarActionText = actionText
    this.snackbarCallback = onAction
    if (this.snackbarTimer >= 0) {
      clearTimeout(this.snackbarTimer)
    }
    this.snackbarTimer = setTimeout(() => {
      this.snackbarText = ''
      this.snackbarActionText = ''
      this.snackbarCallback = null
      this.snackbarTimer = -1
    }, 2750)
  }

  private dismissSnackbar(): void {
    if (this.snackbarTimer >= 0) {
      clearTimeout(this.snackbarTimer)
      this.snackbarTimer = -1
    }
    const cb = this.snackbarCallback
    this.snackbarText = ''
    this.snackbarActionText = ''
    this.snackbarCallback = null
    if (cb !== null) {
      cb()
    }
  }

  // 原版 Snackbar 视图（f6.i.c 进场：alpha 0→1 + translationY 20→0；y/f6.i 布局）：
  // 底部深色圆角条，消息白 14sp 左侧，动作按钮强调色加粗右侧，2750ms 自动消失
  @Builder
  SnackbarHost() {
    if (this.snackbarText !== '') {
      Row() {
        Text(this.snackbarText)
          .fontSize(14)
          .fontColor(Color.White)
          .maxLines(2)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
          .layoutWeight(1)
        if (this.snackbarActionText !== '') {
          Text(this.snackbarActionText)
            .fontSize(14)
            .fontWeight(FontWeight.Bold)
            .fontColor($r('app.color.accent'))
            .maxLines(1)
            .margin({ left: 16 })
            .onClick(() => {
              this.dismissSnackbar()
            })
        }
      }
      .width('100%')
      .padding({ left: 16, right: 16, top: 12, bottom: 12 })
      .backgroundColor('#323232')
      .borderRadius(8)
      .margin({ left: 16, right: 16, bottom: 16 })
      .transition(dialogTransition())
    }
  }

  // ============ 原版 hb/l6：动作选择器（disposable 模式） ============
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
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.pickerDialogId = dialogId
    }).catch(() => {
      console.error('open action picker failed')
    })
  }

  // 原版 u4.h3：disposable 选择器点击行立即写入（Q1/t/l2/G0/B0/f0/J0 按槽分派）
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

  // 原版 hb/l6.i3() 列表结构 = 无操作 + 四分组（与 SettingsToolbarPage 共用数据），
  // 此处仅弹窗壳（w5.k 卡片），不重复分组数据定义
  @Builder
  ActionPicker() {
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
          ForEach(ACTION_PICKER_GROUPS, (group: ActionPickerGroup) => {
            Text(group.title)
              .fontSize(14)
              .fontWeight(FontWeight.Bold)
              .fontColor($r('app.color.dialog_action'))
              .width('100%')
              .padding({ left: 16, right: 16, top: 12, bottom: 4 })
            ForEach(group.items, (action: number) => {
              this.ActionRow(action)
            }, (action: number) => `act-${action}`)
          }, (group: ActionPickerGroup) => `grp-${group.title}`)
        }
        .width('100%')
      }
      .width('100%')
      .constraintSize({ maxHeight: 400 })
      .scrollBar(BarState.Auto)
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  // a6/i 行：14sp，选中 accent；点击立即写入返回（l6 disposable）
  @Builder
  ActionRow(action: number) {
    Row() {
      Text(this.actionPickerLabel(action))
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
      this.saveActionPicker()
    })
  }

  // 原版 hb/v4.b()：动作编号 → 文案（复用 SettingsToolbarPage 的名称表）
  private actionPickerLabel(action: number): string {
    const name = TOOLBAR_ACTION_NAMES[action]
    return name !== undefined ? name : ''
  }
}

// 原版 hb/l6.i3()：无操作 + 四分组（顺序与归属逐项照搬）。
// 「操作设定」页与「工具栏设置」页共用同一份分组数据（l6 被两处调用）。
class ActionPickerGroup {
  title: string
  items: number[]

  constructor(title: string, items: number[]) {
    this.title = title
    this.items = items
  }
}

const ACTION_PICKER_GROUPS: ActionPickerGroup[] = [
  new ActionPickerGroup('标签页行为', [5, 10, 11, 12, 13, 9, 16, 27]),
  new ActionPickerGroup('特性行为', [7, 30, 8, 23, 28, 26, 14, 15, 24, 25, 29]),
  new ActionPickerGroup('地址栏行为', [4]),
  new ActionPickerGroup('网页行为', [19, 1, 20, 6, 18, 17, 2, 3])
]

@Builder
export function SettingsGesturePageBuilder() {
  SettingsGesturePage()
}
