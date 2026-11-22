import { curves, display, window } from '@kit.ArkUI'
import { TabItem } from '../common/Types'
import { TabStore } from '../common/TabStore'
import { AppSettings } from '../common/Settings'
import { ClosedTabsStore, ClosedSingleResult, ClosedBatchResult, OPEN_CLOSED_TABS_EVENT_ID } from '../common/ClosedTabsStore'
import { AppIcon } from './AppIcon'
import { ViaIcon } from './ViaIcon'
import { BusinessError, pasteboard, emitter } from '@kit.BasicServicesKit'
import { UiInsets } from '../common/Immersive'
import { ACCELERATE_CURVE, BEZIER_0202_CURVE, dimTransition, dialogTransition } from '../common/Transitions'
import { computeDialogWidthVp } from './ViaDialogCard'

const PANEL_FG: ResourceColor = '#E6E6E6'

// 原版 f8/l0.java:400-404 面板高度动画：
//   ValueAnimator.ofInt(旧高, 旧高, 新高) —— 三值关键帧（0 / 0.5 / 1）
//   setInterpolator(x8.h.b() = PathInterpolator(0.2,0.2,0.8,0.8))、setDuration(350L)
// ValueAnimator 三值语义：归一化进度 t 先经插值器得 f，再把 f 线性映射到三个关键值——
//   f ∈ [0,0.5] → 停在旧高（不动）；f ∈ [0.5,1] → 旧高 → 新高，且只走完 bezier 的后半段。
// 鸿蒙对应做法：一条 350ms 的 animateTo，曲线直接复合出这条映射关系
//   c(t) = 0                         (bezier(t) <= 0.5)
//        = (bezier(t)-0.5)/0.5       (bezier(t) >  0.5)
// 这样才会「先静置一半时长、再用 bezier 后半段伸缩」；若拆成两段各 175ms 的
// keyframeAnimateTo，第二段会各自跑一遍完整 bezier，曲线形状与原版不同。
const PANEL_HEIGHT_CURVE: ICurve = curves.customCurve((t: number): number => {
  const eased: number = BEZIER_0202_CURVE.interpolate(t)
  if (eased <= 0.5) {
    return 0
  }
  return (eased - 0.5) / 0.5
})

@ComponentV2
export struct TabPanel {
  @Event onClose: () => void = () => {}
  private tabStore: TabStore = TabStore.getInstance()
  private settings: AppSettings = AppSettings.getInstance()
  private insets: UiInsets = UiInsets.getInstance()
  @Local undoDialogId: number = -1
  @Local undoMessage: string = ''
  // 撤销数据（原版 na.f0/R：单关 e4「已关闭 %1$s」，批闭复数 plurals g「已关闭 %d 个标签页」）
  @Local pendingSingle: ClosedSingleResult | null = null
  @Local pendingBatch: ClosedBatchResult | null = null
  @Local swipeOffsets: Record<number, number> = {}
  private rowTouchStartX: number = 0
  private rowTouchStartY: number = 0
  private rowTouchStartTime: number = 0
  private rowSwiping: boolean = false
  private rowLongPressTimer: number = -1
  private rowTapSuppressed: boolean = false
  @Local longPressIndex: number = -1
  @Local panelMaxHeight: number = 0
  @Local rootHeightVp: number = 0
  // 面板实测宽（vp）：滑动删除阈值与面板宽度定位用（onAreaChange 回写）
  @Local panelWidth: number = 0
  // 原版 f8/y.java：行首图标按下触发 ItemTouchHelper 拖拽（l0.b3：列表 <2 不启动）
  @Local dragFromIndex: number = -1
  @Local dragToIndex: number = -1
  // 原版 f8/y.java：favicon 加载失败回退 e9 默认图标（tint k.f13662h）
  @Local faviconFailed: Record<number, boolean> = {}

  aboutToAppear(): void {
    // 关闭标签入恢复库依赖 ClosedTabsStore（EntryAbility 已注入 AppContextHolder）
    ClosedTabsStore.getInstance().ensureInit().catch((error: BusinessError) => {
      console.error(`closed tabs init failed: ${error.message}`)
    })
    // 原版面板初始化不产生高度动画：f8/l0.java:295 建视图时就把 RecyclerView 高度设为 n3()，
    // 随后 p3(true) 走 ValueAnimator.ofInt(h, h, n3())，因 h 与目标相等，位移恒为 0。
    // 故这里直接落终值（不调用 animateTo），避免凭空多出一段「从 120 长到目标」的假动画。
    this.rootHeightVp = this.maxPanelHeight()
    this.panelMaxHeight = this.targetPanelHeight()
    AppStorage.setOrCreate('uia_menu_root_height_vp', this.rootHeightVp)
  }

  // 原版 f8/l0.java:379-381 o3() → p3(true)：标签增删后重算高度并做 350ms 三值动画。
  // 由本文件内所有会改变标签条数的操作（关闭单条/滑删/批量关闭）在改完数据后调用。
  private refreshPanelHeight(): void {
    const target: number = this.targetPanelHeight()
    if (target === this.panelMaxHeight) {
      return
    }
    // 三值 ValueAnimator 语义见文件头 PANEL_HEIGHT_CURVE：前一半时长静置、后一半才伸缩。
    this.getUIContext().animateTo({
      duration: 350,
      curve: PANEL_HEIGHT_CURVE
    }, () => {
      this.panelMaxHeight = target
    })
  }

  // 原版 f8/l0.java:373-377 n3(): RecyclerView 高度 = min(48dp * 标签数, max(0, max_height - 48dp - 2*10dp))。
  // Cb() 传入 max_height = 应用根视图高度 - 16dp；本值仅约束列表，底部新建 ImageView 独立 WRAP_CONTENT。
  // 原版 k6.Cb()：gravity 纵向分量 = W0==1（工具栏在上布局）? TOP : BOTTOM——由 Index 经
  // AppStorage 'uia_menu_layout' 提供，与 MenuSheet 同一接线。
  private menuLayoutTop(): boolean {
    return (AppStorage.get<number>('uia_menu_layout') ?? 0) === 1
  }

  // 原版 f8/c.java:79：面板内容 FrameLayout.LayoutParams(width=N8(), height=WRAP, gravity)。
  // N8() 与菜单同源（k6.Cb:4027 j(N8())）——由 Index 经 AppStorage 'uia_menu_size_vp' 提供。
  private panelWidthVp(): number {
    const size: number = AppStorage.get<number>('uia_menu_size_vp') ?? 0
    return size > 0 ? size : 0
  }

  private targetPanelHeight(): number {
    const listMaxHeight: number = Math.max(0, this.maxPanelHeight() - 48 - 20)
    return Math.min(this.tabStore.tabs.length * 48, listMaxHeight)
  }

  build() {
    // 原版 k6.Cb()（k6.java:4027）：标签面板 f8.l0 gravity = (W0==1?48:80)|8388613（END）、
    // 宽 = N8() —— 与菜单同款：纵向贴底（布局1贴顶）、横向**贴右缘**。手机竖屏 N8()=短边
    // = 全宽无差异；横屏（宽>>面板宽）时必须贴右，居中是移植偏差。
    Stack({ alignContent: this.menuLayoutTop() ? Alignment.TopEnd : Alignment.BottomEnd }) {
      Column()
        .width('100%')
        .height('100%')
        // dim 由 Index 上同一 Fragment 对话框转场同步驱动，点击空白关闭。
        .backgroundColor('rgba(0,0,0,0.4)')
        .onClick(() => {
          this.onClose()
        })

      Column() {
        Scroll() {
          Column() {
            ForEach(this.tabStore.tabs, (tab: TabItem, index: number) => {
              Row({ space: 16 }) {
                // 原版 f8/y.b()：行首图标 = 标签 icon ?: favicon ?: e9 默认（无隐身月亮）；
                // onTouch ACTION_DOWN → startDrag（f8/l0.b3）
                Column() {
                  if (tab.isHomePage()) {
                    // 原版主页标签 favicon 为地球图标 22dp（f8/y.java iD=22dp）
                    ViaIcon({ icon: $r('app.media.uia_ic_globe'), iconSize: 22, iconColor: PANEL_FG })
                  } else if (tab.icon !== null) {
                    // 原版 p4/c.java:110 onReceivedIcon：优先显示捕获的站点图标
                    Image(tab.icon)
                      .width(22)
                      .height(22)
                      .objectFit(ImageFit.Contain)
                  } else if (this.faviconFailed[tab.id] === true) {
                    // 原版 e9（L1）默认网页图标
                    ViaIcon({ icon: $r('app.media.uia_ic_webpage'), iconSize: 22, iconColor: PANEL_FG })
                  } else {
                    Image(this.faviconUrl(tab.url))
                      .width(22)
                      .height(22)
                      .objectFit(ImageFit.Contain)
                      .onError(() => {
                        this.faviconFailed[tab.id] = true
                      })
                  }
                }
                .justifyContent(FlexAlign.Center)
                // 原版 y.java:108 行首图标 ACTION_DOWN → l0.b3（<2 不启动）→ ItemTouchHelper.H 拖拽重排
                .gesture(PanGesture({ fingers: 1, direction: PanDirection.Vertical, distance: 8 })
                  .onActionStart(() => {
                    if (this.tabStore.tabs.length < 2) {
                      return
                    }
                    this.dragFromIndex = index
                    this.dragToIndex = index
                  })
                  .onActionUpdate((event: GestureEvent) => {
                    if (this.dragFromIndex < 0) {
                      return
                    }
                    const steps = Math.round(px2vp(event.offsetY) / 48)
                    const total = this.tabStore.tabs.length
                    let target = this.dragFromIndex + steps
                    if (target < 0) {
                      target = 0
                    }
                    if (target > total - 1) {
                      target = total - 1
                    }
                    if (target !== this.dragToIndex) {
                      // 原版 j.i(3,48) 垂直拖拽 + y() onMoved
                      this.tabStore.moveTab(this.dragToIndex, target)
                      this.dragToIndex = target
                    }
                  })
                  .onActionEnd(() => {
                    this.dragFromIndex = -1
                    this.dragToIndex = -1
                  }))
                Text(tab.isHomePage() ? $r('app.string.home_page') : this.rowTitle(tab))
                  .fontSize(16)
                  .fontWeight(index === this.tabStore.currentIndex ? FontWeight.Bold : FontWeight.Normal)
                  .fontColor(index === this.tabStore.currentIndex ? $r('app.color.accent') : PANEL_FG)
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
                  .layoutWeight(1)
                AppIcon({ icon: $r('sys.symbol.xmark'), iconSize: 20, iconColor: PANEL_FG })
                  .accessibilityText(tab.isHomePage() ? '关闭主页标签' : `关闭 ${this.rowTitle(tab)} 标签`)
                  .onClick(() => {
                    this.rowTapSuppressed = true
                    // 原版 na.M/f0：单关入恢复库 + snackbar「已关闭 %1$s」（标题）
                    const info = this.tabStore.closeTab(index)
                    if (info !== null) {
                      this.showUndoSingle(info)
                    }
                    // 原版 closeTab → o3()：条数变化后做 350ms 三值高度动画
                    this.refreshPanelHeight()
                  })
              }
              .width('100%')
              .height(48)
              .padding({ left: 16, right: 16 })
              .translate({ x: this.swipeOffsets[tab.id] ?? 0 })
              .priorityGesture(GestureGroup(GestureMode.Exclusive,
                TapGesture({ fingers: 1 }).onAction(() => {
                  if (this.rowTapSuppressed) {
                    this.rowTapSuppressed = false
                    return
                  }
                  this.tabStore.switchTo(index)
                  this.onClose()
                }),
                LongPressGesture({ repeat: false, duration: 500 }).onAction(() => {
                  this.longPressIndex = index
                }),
                PanGesture({ fingers: 1, direction: PanDirection.Horizontal, distance: 5 })
                  .onActionUpdate((event: GestureEvent) => {
                    const nextOffsets: Record<number, number> = {}
                    const keys: string[] = Object.keys(this.swipeOffsets)
                    for (let i = 0; i < keys.length; i++) {
                      const key: number = Number(keys[i])
                      nextOffsets[key] = this.swipeOffsets[key]
                    }
                    nextOffsets[tab.id] = event.offsetX
                    this.swipeOffsets = nextOffsets
                  })
                  .onActionEnd((event: GestureEvent) => {
                    const offsetVp: number = event.offsetX
                    const resetOffsets: Record<number, number> = {}
                    const keys: string[] = Object.keys(this.swipeOffsets)
                    for (let i = 0; i < keys.length; i++) {
                      const key: number = Number(keys[i])
                      resetOffsets[key] = this.swipeOffsets[key]
                    }
                    resetOffsets[tab.id] = 0
                    this.swipeOffsets = resetOffsets
                    const thresholdVp: number = this.panelWidth > 0 ? this.panelWidth * 0.5 : 80
                    const vx: number = event.velocityX
                    const vy: number = event.velocityY
                    const velocityDirectionMatches: boolean =
                      offsetVp > 0 ? vx > 0 : vx < 0
                    const fastSwipe: boolean =
                      Math.abs(vx) > 120 && Math.abs(vx) > Math.abs(vy) && velocityDirectionMatches
                    if (fastSwipe || Math.abs(offsetVp) > thresholdVp) {
                      this.removeTab(index)
                    }
                  })
                  .onActionCancel(() => {
                    const resetOffsets: Record<number, number> = {}
                    const keys: string[] = Object.keys(this.swipeOffsets)
                    for (let i = 0; i < keys.length; i++) {
                      const key: number = Number(keys[i])
                      resetOffsets[key] = this.swipeOffsets[key]
                    }
                    resetOffsets[tab.id] = 0
                    this.swipeOffsets = resetOffsets
                  })
              ), GestureMask.Normal)
              // 原版 f8.l0.t3：长按弹行操作菜单（w5.k.h0(view) 锚定该行弹出）
              // 弹窗动画依据：w5/k.java:871 m() → new Dialog(context, v.f14256c)，
              //   x7.v.f14256c = 0x7f11000f = style "n" → windowAnimationStyle=@style/k →
              //   @anim/a 进 / @anim/b 出（240ms，alpha 线性 + translateY10%/scale bounce）。
              .bindPopup(this.longPressIndex === index, {
                builder: (): void => {
                  this.TabMenu(index)
                },
                placement: Placement.Top,
                popupColor: Color.Transparent,
                enableArrow: false,
                autoCancel: true,
                transition: dialogTransition(),
                onStateChange: (e: PopupStateChangeParam) => {
                  if (!e.isVisible) {
                    this.longPressIndex = -1
                  }
                }
              })
            }, (tab: TabItem) => tab.id.toString())
          }
          .width('100%')
        }
        .width('100%')
        .height(this.panelMaxHeight)
        .align(Alignment.Bottom)
        .scrollBar(BarState.Off)

        // 原版新建 ImageView 宽 = MATCH_PARENT、高 = 32dp，整行都是点击/长按热区。
        Row() {
          ViaIcon({ icon: $r('app.media.uia_ic_add'), iconSize: 24, iconColor: PANEL_FG })
            .width(26)
            .height(32)
        }
        .width('100%')
        .height(32)
        .accessibilityText('新建标签')
        .justifyContent(FlexAlign.Center)
        .onClick(() => {
          // 原版隐身会话中新建标签同为隐身（k6.cb/l8 会话模型）
          this.tabStore.newTab(this.tabStore.sessionIncognito)
          this.onClose()
        })
        .gesture(LongPressGesture({ repeat: false, duration: 500 })
          .onAction(() => {
            this.openClosedTabs()
          }))
        .padding({ top: 10, bottom: 10 })
      }
      // 原版 f8/c.java:79：面板内容 FrameLayout.LayoutParams(width=N8(), height=WRAP, gravity)。
      // 竖屏 N8()=窗口短边=全宽；横屏时宽受限且贴右缘（alignContent BottomEnd 已保证）。
      // 原版面板悬于底部工具栏之上，工具栏保持可见。
      // 原版圆角：贴底时只圆上侧两角；布局1贴顶时圆下侧两角（镜像）。
      .width(this.panelWidthVp() > 0 ? this.panelWidthVp() : '100%')
      .onAreaChange((_old: Area, newArea: Area) => {
        this.panelWidth = Number(newArea.width)
      })
      .constraintSize({ maxHeight: this.maxPanelHeight() })
      .padding({ top: 10, bottom: 10 })
      .margin(this.menuLayoutTop() ? { top: 48 } : { bottom: 80 })
      .backgroundColor($r('app.color.menu_bg'))
      .borderRadius(this.menuLayoutTop()
        ? { bottomLeft: 16, bottomRight: 16 }
        : { topLeft: 16, topRight: 16 })
          // 面板进出转场绑定在 Index 的条件挂载边界，内部列不承担进出动画。
    }
    .width('100%')
    .height('100%')
  }

  // 原版 Cb() 传入 max_height = 应用根容器实测高度 - 16px（转换为vp）。
  private maxPanelHeight(): number {
    const rootHeight: number = AppStorage.get<number>('uia_menu_root_height_vp') ?? 0
    if (rootHeight > 0) {
      return Math.max(0, rootHeight - px2vp(16))
    }
    try {
      const d = display.getDefaultDisplaySync()
      return Math.max(0, d.height / d.densityPixels - px2vp(16))
    } catch (error) {
      return 784
    }
  }

  private removeTab(index: number): void {
    const info = this.tabStore.closeTab(index)
    if (info !== null) {
      this.showUndoSingle(info)
    }
    // 原版 closeTab → o3() → p3(true)：条数变化后重算面板高度（350ms 三值动画）
    this.refreshPanelHeight()
  }

  // 行标题渲染层回退（不改 Types）：空标题且无 URL→「无标题」（bh）
  private rowTitle(tab: TabItem): string {
    if (tab.title !== '') {
      return tab.title
    }
    if (tab.url !== '') {
      return tab.url
    }
    return '无标题'
  }

  // TabPanel 无 NavPathStack：经 emitter 由 Index openPage（原版 k6.ia）——需主控接线监听
  private openClosedTabs(): void {
    emitter.emit({ eventId: OPEN_CLOSED_TABS_EVENT_ID, priority: emitter.EventPriority.HIGH })
    this.onClose()
  }

  // 原版 f8.l0.t3 长按菜单项与顺序（w5.k 弹出卡片：宽 min(240dp, 屏宽*4/7)，
  // item = layout w：pad 16/12、14sp fg（style a6）左对齐）
  @Builder
  TabMenu(index: number) {
    Column() {
      if (this.tabStore.tabs.length > 1) {
        this.MenuItem($r('app.string.close_all_tabs'), (): void => {
          // 原版 j8 i11==4 → i8：批量关闭入恢复库 + 撤销 snackbar（na.R）
          const result = this.tabStore.closeAll()
          this.showUndoBatch(result)
          this.onClose()
        })
        this.MenuItem($r('app.string.close_other_tabs'), (): void => {
          const result = this.tabStore.closeOthers(index)
          this.showUndoBatch(result)
          this.refreshPanelHeight()
        })
      }
      // 原版 t3：该行既非首也非尾才同时给「关闭上方/下方」（f8/l0.java:459）
      if (index > 0 && index < this.tabStore.tabs.length - 1) {
        this.MenuItem($r('app.string.close_tabs_above'), (): void => {
          const result = this.tabStore.closeAbove(index)
          this.showUndoBatch(result)
          this.refreshPanelHeight()
        })
        this.MenuItem($r('app.string.close_tabs_below'), (): void => {
          const result = this.tabStore.closeBelow(index)
          this.showUndoBatch(result)
          this.refreshPanelHeight()
        })
      }
      if (this.isHttpTab(index)) {
        this.MenuItem($r('app.string.duplicate_tab'), (): void => {
          this.tabStore.duplicateTab(index)
          // 原版 f8/l0.H(int)（r4.f 回调）→ o3()：条数变化后重算面板高度
          this.refreshPanelHeight()
        })
      }
      if (this.isCopyableTab(index)) {
        this.MenuItem($r('app.string.copy_link'), (): void => {
          this.copyLink(this.tabStore.tabs[index].url)
        })
      }
    }
    // 原版 w5.k.g0：宽 = min(240dp, 屏宽/7*4)
    .width(Math.min(240, this.screenWidthVp() / 7 * 4))
    .padding({ top: 8, bottom: 8 })
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
  }

  private screenWidthVp(): number {
    try {
      const d = display.getDefaultDisplaySync()
      return d.width / d.densityPixels
    } catch (error) {
      return 360
    }
  }

  @Builder
  MenuItem(label: ResourceStr, action: () => void) {
    Text(label)
      .fontSize(14)
      .fontColor($r('app.color.fg'))
      .width('100%')
      .padding({ left: 16, right: 16, top: 12, bottom: 12 })
      .maxLines(1)
      .textOverflow({ overflow: TextOverflow.Ellipsis })
      .textAlign(TextAlign.Start)
      .onClick(() => {
        action()
        this.longPressIndex = -1
      })
  }

  // 原版：复制标签页条件 URL 为 http(s)（i0.s）
  private isHttpTab(index: number): boolean {
    const url = this.tabStore.tabs[index].url
    return url.startsWith('http://') || url.startsWith('https://')
  }

  // 原版：复制链接条件非 file://（i0.l）
  private isCopyableTab(index: number): boolean {
    const url = this.tabStore.tabs[index].url
    return !url.startsWith('file://') && url !== ''
  }

  private copyLink(url: string): void {
    try {
      pasteboard.getSystemPasteboard().setData(pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, url))
      // 原版 case5：g6.n.a 弹「已复制链接」（f8/l0.java:131）
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.copied_link') })
    } catch (error) {
      console.error('copy link failed')
    }
  }

  private faviconUrl(url: string): string {
    const host = url.replace(/^https?:\/\//, '').split('/')[0]
    if (host === '') {
      return ''
    }
    return `https://${host}/favicon.ico`
  }

  // 单关撤销 snackbar（原版 na.f0：undoCloseToast 关闭位 gate；文案 e4「已关闭 %1$s」标题）
  private showUndoSingle(info: ClosedSingleResult): void {
    if (!this.settings.undoCloseToast) {
      return
    }
    this.pendingSingle = info
    this.pendingBatch = null
    this.openUndoDialog(`已关闭 ${info.title}`)
  }

  // 批量关闭撤销 snackbar（原版 na.R：单条且有标题 → e4，否则复数 plurals g）
  private showUndoBatch(result: ClosedBatchResult | null): void {
    if (result === null || result.count() === 0) {
      return
    }
    if (!this.settings.undoCloseToast) {
      return
    }
    this.pendingSingle = null
    this.pendingBatch = result
    if (result.count() === 1) {
      this.openUndoDialog(`已关闭 ${result.titles[0]}`)
      return
    }
    this.openUndoDialog(`已关闭 ${result.count()} 个标签页`)
  }

  private openUndoDialog(message: string): void {
    this.undoMessage = message
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.UndoDialog()
      },
      isModal: false,
      backgroundColor: Color.Transparent,
      autoCancel: false,
      alignment: DialogAlignment.Bottom
    }).then((dialogId: number) => {
      this.undoDialogId = dialogId
      setTimeout(() => {
        this.closeUndoToast(dialogId)
      }, 3000)
    }).catch((error: BusinessError) => {
      console.error(`open undo toast failed: ${error.message}`)
    })
  }

  private closeUndoToast(dialogId: number): void {
    if (this.undoDialogId !== dialogId) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(dialogId)
    this.undoDialogId = -1
  }

  @Builder
  UndoDialog() {
    Row() {
      Text(this.undoMessage)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .layoutWeight(1)
      Text($r('app.string.undo'))
        .fontSize(14)
        .fontColor($r('app.color.accent'))
        .padding({ left: 12, right: 12, top: 8, bottom: 8 })
        .onClick(() => {
          const single = this.pendingSingle
          const batch = this.pendingBatch
          this.closeUndoToast(this.undoDialogId)
          if (single !== null) {
            // 原版 F1：撤销恢复后从恢复库移除条目（K1）
            this.tabStore.newTabAt(single.url, false)
            ClosedTabsStore.getInstance().removeByIds([single.entryId])
            return
          }
          if (batch !== null) {
            this.tabStore.restoreClosedBatch(batch)
          }
        })
    }
    .width('92%')
    .padding({ left: 16, right: 8, top: 12, bottom: 12 })
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(12)
  }
}
