import { AppSettings } from '../common/Settings'
import { computeDialogWidthVp } from '../components/UiaDialogCard'
import { dialogTransition } from '../common/Transitions'
import { SettingCheckRow, SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { UiaIcon } from '../components/UiaIcon'
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

// 原版 hb/v4.b()：动作编号 → 文案，值一律为 string.json 资源名（中英双语各一份），
// 取值经 resourceText()/getStringByNameSync，禁止硬编码中文否则英文环境失效。
// 语义逐条对应原版 x7.u：G9=无操作、M9=刷新、O9=回顶、y9=到底、D9=输入网址…
const ACTION_NAME_KEYS: Record<number, string> = {
  0: 'orig_pm',
  1: 'refresh',
  2: 'orig_pu',
  3: 'orig_pe',
  4: 'search_or_type_url',
  5: 'orig_ad',
  6: 'add_bookmark',
  7: 'orig_po',
  8: 'orig_pq',
  9: 'orig_pf',
  10: 'orig_pk',
  11: 'orig_pl',
  12: 'orig_pg',
  13: 'orig_ph',
  14: 'find_in_page',
  15: 'translate',
  16: 'close_all_tabs',
  17: 'orig_qa',
  18: 'orig_q1',
  19: 'save',
  20: 'view_source',
  23: 'orig_pt',
  24: 'read_aloud_menu',
  25: 'reader_mode',
  26: 'orig_pr',
  27: 'duplicate_tab',
  28: 'orig_pp',
  29: 'orig_pd',
  30: 'orig_pn'
}

class ActionGroup {
  // titleKey = string.json 资源名（中英各一份），渲染时按当前语言取。
  titleKey: string
  items: number[]

  constructor(titleKey: string, items: number[]) {
    this.titleKey = titleKey
    this.items = items
  }
}

// 原版 hb/l6.i3()：分组顺序与归属（标题资源 x7.u.f14169t5/Nd/B0/Qh）
const ACTION_GROUPS: ActionGroup[] = [
  new ActionGroup('orig_vp', [5, 10, 11, 12, 13, 9, 16, 27]),
  new ActionGroup('orig_j7', [7, 30, 8, 23, 28, 26, 14, 15, 24, 25, 29]),
  new ActionGroup('orig_bg', [4]),
  new ActionGroup('orig_a1r', [19, 1, 20, 6, 18, 17, 2, 3])
]

// 动作编号 → 资源名（原版 hb/v4.b()），导出供「操作设定」页（hb/u4 预览 Snackbar）复用
export const TOOLBAR_ACTION_NAMES: Record<number, string> = ACTION_NAME_KEYS

// 资源名 → 当前语言文案；取不到时回退为键名，绝不回退中文硬编码。
export function toolbarActionText(context: UIContext | undefined, action: number): string {
  const key = ACTION_NAME_KEYS[action]
  if (key === undefined) {
    return ''
  }
  if (context === undefined) {
    return key
  }
  try {
    return context.getHostContext()!.resourceManager.getStringByNameSync(key)
  } catch (error) {
    return key
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
    .backgroundColor(AppSettings.getInstance().isShowSettingsBackground()
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

  // 原版 ib/m.d()：预览 = 说明文字 + 一条真实工具栏（g0）
  // 提示文案 x7.u.zu：「点击下列按钮来设置它的长按事件，长按查看它的事件。你也可以滑动工具栏来设置滑动事件。」
  // 文字 padding 16/10（h6.a.H(1,16,10,16,10)），工具栏高 48dp（dimen b），无圆角/描边/卡片容器
  @Builder
  PreviewItem() {
    Column() {
      Text($r('app.string.orig_zu'))
        .fontSize(14)
        .fontColor($r('app.color.fg_secondary'))
        .width('100%')
        .padding({ left: 16, right: 16, top: 10, bottom: 10 })

      // 原版 g0.i()：地址槽未填充时宽度 0，五个图标槽各 weight 1
      Row() {
        this.PreviewSlot('back', $r('app.media.uia_ic_back'), 0)
        this.PreviewSlot('forward', $r('app.media.uia_ic_back'), 180)
        this.PreviewSlot('home', $r('app.media.uia_ic_home'), 0)
        this.PreviewTabsSlot()
        this.PreviewSlot('menu', $r('app.media.uia_ic_menu'), 0)
      }
      .width('100%')
      .height(ROW_H)
      // 原版 ToolbarsViewDelegate.java:229：Math.abs(f10) <= 0.8f 直接 return，
      // 即门槛是**严格大于** 0.8（正好 0.8 不触发）。这里必须同为 <=，不能写成 <。
      .gesture(PanGesture({ fingers: 1, direction: PanDirection.Horizontal, distance: 1 })
        .onActionEnd((event: GestureEvent) => {
          const fraction = px2vp(event.offsetX) / 84
          if (Math.abs(fraction) <= 0.8) {
            return
          }
          this.openActionPicker(fraction > 0 ? 'swipe0' : 'swipe1')
        }))

      // 原版 ToolbarsViewDelegate.d()：FAB 演示悬浮球（mark.via.settings.helper.a），
      // 铺在预览工具栏下方 FrameLayout 右下角（x=80|RIGHT|BOTTOM，margin 12dp）；
      // 图标 fab ic（L1/Bf tint 强调色），padding 10dp，背景椭圆 shadow。
      // 点击 K(FAB) → toast it 提示；拖出四向（30dp 阈值，0.75 增益、40% 距离提交）
      // → Snackbar 显示当前动作 + 「修改」→ 选择器。
      Stack() {
        Column() {
          // 原版 helper/a e(dir)→u0.a：拖动方向换动作图标（back/forward/up/down），
          // 静止态 = fab 本体图标；预览里固定用菜单图标（与 Index FAB 静止态一致）
          UiaIcon({
            icon: $r('app.media.uia_ic_menu'),
            iconSize: 22,
            iconColor: $r('app.color.dialog_bg')
          })
        }
        .width(42)
        .height(42)
        .justifyContent(FlexAlign.Center)
        .alignItems(HorizontalAlign.Center)
        .borderRadius(21)
        .backgroundColor($r('app.color.accent'))
        .opacity(0.9)
        .shadow({ radius: 8, color: 'rgba(0,0,0,0.3)', offsetX: 0, offsetY: 2 })
        .onClick(() => {
          // 原版 helper/a 构造：setOnClickListener → K(FAB) → n7.K → toast f14018i5(it)
          this.getUIContext().getPromptAction().showToast({
            message: $r('app.string.orig_it'), duration: 2000
          })
        })
        .gesture(PanGesture({ fingers: 1, direction: PanDirection.All, distance: 5 })
          .onActionEnd((event: GestureEvent) => {
            const dir = this.fabDragDir(px2vp(event.offsetX), px2vp(event.offsetY))
            if (dir < 0) {
              return
            }
            // 原版 helper/a.b(dir)：回弹后 K(FAB_LEFT/RIGHT/UP/DOWN)
            // → n7.K → Snackbar zr「%1$s：%2$s」（iq/ir/is/ip 方向名 + v4.b 动作名）+ 修改
            const targets: string[] = ['fab0', 'fab1', 'fab2', 'fab3']
            const dirNames: string[] = ['向左拖动', '向右拖动', '向上拖动', '向下拖动']
            this.showActionSnackbar(dirNames[dir], this.actionValueOf(targets[dir]), targets[dir])
          }))
      }
      .width('100%')
      .height(80)
      .alignContent(Alignment.BottomEnd)
    }
    .width('100%')
  }

  // 原版 helper/a.onTouchEvent：方向位 f9782l = 位移超 touchSlop 的主轴方向
  //（1=左 2=右 4=上 8=下，helper/a.f()）；预览里简化为四向索引，未超阈值返回 -1（视为点击）
  private fabDragDir(offsetX: number, offsetY: number): number {
    if (Math.abs(offsetX) > 30) {
      return offsetX <= 0 ? 0 : 1
    }
    if (Math.abs(offsetY) > 30) {
      return offsetY <= 0 ? 2 : 3
    }
    return -1
  }

  // 原版 g6/n.t()：Snackbar（消息 + 动作按钮，2750ms 自动消失）。
  // 本页无 Index 级 Snackbar 容器，用 showToast 承载消息，动作「修改」改为
  // 直接由拖拽事件触发选择器打开（Snackbar 只展示信息）。
  // 原版 K() 分派：BACK/FORWARD/HOME/TABS/MENU → zq「%1$s按钮 · 长按：%2$s」；
  // SWIPE_BACK/FORWARD、FAB_* → zr「%1$s：%2$s」。
  private showActionSnackbar(label: string, action: number, target: string): void {
    const actionName = this.resourceText(ACTION_NAME_KEYS[action], ACTION_NAME_KEYS[action])
    const message = `${label}：${actionName}`
    this.getUIContext().getPromptAction().showToast({ message: message, duration: 2000 })
    this.openActionPicker(target)
  }

  // 原版 g0.g()：图标 22dp（48 - 13*2 内容区），accent 着色；点击/长按设置该按钮长按动作
  @Builder
  PreviewSlot(target: string, icon: Resource, rotate: number) {
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
      this.openActionPicker(target)
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
      maskColor: 'rgba(0,0,0,0.4)'
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
    if (target === 'swipe1') {
      return this.settings.gesturetoolbarright
    }
    // 原版 n7.s3()：悬浮球四向动作键（fableft/right/up/downaction）
    if (target === 'fab0') {
      return this.settings.fableftaction
    }
    if (target === 'fab1') {
      return this.settings.fabrightaction
    }
    if (target === 'fab2') {
      return this.settings.fabupaction
    }
    return this.settings.fabdownaction
  }

  // 原版 l6.l3()：点「保存」才写入
  private saveActionPicker(): void {
    if (this.pickerTarget === 'swipe0' || this.pickerTarget === 'swipe1') {
      this.settings.setGestureToolbar(this.pickerTarget === 'swipe0' ? 0 : 1, this.pickerValue)
    } else if (this.pickerTarget === 'fab0' || this.pickerTarget === 'fab1' ||
      this.pickerTarget === 'fab2' || this.pickerTarget === 'fab3') {
      // 原版 n7.w3() case6-9：s0/v1/d2/t2 写入悬浮球四向动作键
      this.settings.setFabAction(Number(this.pickerTarget.substring(3)), this.pickerValue)
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
            Text(this.resourceText(group.titleKey, group.titleKey))
              .fontSize(14)
              .fontWeight(FontWeight.Bold)
              .fontColor($r('app.color.dialog_action'))
              .width('100%')
              .padding({ left: 16, right: 16, top: 12, bottom: 4 })
            ForEach(group.items, (action: number) => {
              this.ActionRow(action)
            }, (action: number) => `act-${action}`)
          }, (group: ActionGroup) => `grp-${group.titleKey}`)
        }
        .width('100%')
      }
      .width('100%')
      .constraintSize({ maxHeight: 400 })
      .scrollBar(BarState.Auto)

      // 底部按钮行：确认写入 + 取消。
      // 原版 hb/l6.java:83-88 的动作选择器只有一个确认按钮（点它才 l3()→k3() 写入并返回），
      // 文案即「保存」，绝不是「重置」——重置语义会把用户已选动作直接丢弃。
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
        Text($r('app.string.save'))
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
      Text(this.resourceText(ACTION_NAME_KEYS[action], ACTION_NAME_KEYS[action]))
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

  // 资源键统一走 string.json（en_US 已同步），禁止硬编码中文，否则英文环境失效。
  private resourceText(name: string, fallback: string): string {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return fallback
    }
    try {
      return context.resourceManager.getStringByNameSync(name)
    } catch (error) {
      return fallback
    }
  }

  private layoutLabel(): string {
    const keys: string[] = ['layout_traditional', 'layout_toolbar_top', 'layout_toolbar_bottom',
      'layout_double_toolbar']
    const index = Math.max(0, Math.min(keys.length - 1, this.settings.appLayout))
    return this.resourceText(keys[index], keys[index])
  }

  private autoHideLabel(): string {
    const keys: string[] = ['auto_hide_always', 'auto_hide_swipe', 'auto_hide_tap']
    const index = Math.max(0, Math.min(keys.length - 1, this.settings.toolbarAutoHide))
    return this.resourceText(keys[index], keys[index])
  }

  private addressContentLabel(): string {
    const keys: string[] = ['content_title', 'content_address', 'content_domain']
    const index = Math.max(0, Math.min(keys.length - 1, this.settings.addressBarContent))
    return this.resourceText(keys[index], keys[index])
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
      maskColor: 'rgba(0,0,0,0.4)'
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
    const keys: string[] = ['auto_hide_always', 'auto_hide_swipe', 'auto_hide_tap']
    const index = Math.max(0, Math.min(keys.length - 1, value))
    return this.resourceText(keys[index], keys[index])
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
    // option.label 本身即 string.json 的资源名（layout_* / content_*），直接按名取。
    return this.resourceText(option.label, option.label)
  }
}

@Builder
export function SettingsToolbarPageBuilder() {
  SettingsToolbarPage()
}
