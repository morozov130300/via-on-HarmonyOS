import { display, curves } from '@kit.ArkUI'
import { TabItem } from '../common/Types'
import { TabStore } from '../common/TabStore'
import { AppSettings } from '../common/Settings'
import { ClosedTabsStore, ClosedSingleResult, ClosedBatchResult, OPEN_CLOSED_TABS_EVENT_ID } from '../common/ClosedTabsStore'
import { AppIcon } from './AppIcon'
import { ViaIcon } from './ViaIcon'
import { BusinessError, pasteboard, emitter } from '@kit.BasicServicesKit'
import { UiInsets } from '../common/Immersive'
import { dimTransition, dialogTransition } from '../common/Transitions'

const PANEL_FG: ResourceColor = '#E6E6E6'

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
  @Local longPressIndex: number = -1
  @Local panelMaxHeight: number = 120
  // 原版 f8/y.java：行首图标按下触发 ItemTouchHelper 拖拽（l0.b3：列表 <2 不启动）
  @Local dragFromIndex: number = -1
  @Local dragToIndex: number = -1
  // 原版 f8/y.java：favicon 加载失败回退 e9 默认图标（tint k.f13662h）
  @Local faviconFailed: Record<number, boolean> = {}
  // 原版共用插值器 x8/h.b()：cubic-bezier(0.2,0.2,0.8,0.8)
  private panelCurve = curves.cubicBezier(0.2, 0.2, 0.8, 0.8)

  aboutToAppear(): void {
    // 关闭标签入恢复库依赖 ClosedTabsStore（EntryAbility 已注入 AppContextHolder）
    ClosedTabsStore.getInstance().ensureInit().catch((error: BusinessError) => {
      console.error(`closed tabs init failed: ${error.message}`)
    })
    // 原版 f8/l0.p3：面板高度 ValueAnimator 350ms bezier 展开
    this.getUIContext().animateTo({ duration: 350, curve: this.panelCurve }, () => {
      this.panelMaxHeight = Math.min(this.tabStore.tabs.length * 48, Math.max(0, this.maxPanelHeight() - 64))
    })
  }

  build() {
    Stack({ alignContent: Alignment.Bottom }) {
      Column()
        .width('100%')
        .height('100%')
        // 原版 style n：backgroundDimAmount 0.4
        .backgroundColor('rgba(0,0,0,0.4)')
        .transition(dimTransition(240))
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
                    ViaIcon({ icon: $r('app.media.via_ic_globe'), iconSize: 22, iconColor: PANEL_FG })
                  } else if (tab.icon !== null) {
                    // 原版 p4/c.java:110 onReceivedIcon：优先显示捕获的站点图标
                    Image(tab.icon)
                      .width(22)
                      .height(22)
                      .objectFit(ImageFit.Contain)
                  } else if (this.faviconFailed[tab.id] === true) {
                    // 原版 e9（L1）默认网页图标
                    ViaIcon({ icon: $r('app.media.via_ic_webpage'), iconSize: 22, iconColor: PANEL_FG })
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
                    // 原版 na.M/f0：单关入恢复库 + snackbar「已关闭 %1$s」（标题）
                    const info = this.tabStore.closeTab(index)
                    if (info !== null) {
                      this.showUndoSingle(info)
                    }
                  })
              }
              .width('100%')
              .height(48)
              .padding({ left: 16, right: 16 })
              .translate({ x: this.swipeOffsets[index] ?? 0 })
              .onClick(() => {
                this.tabStore.switchTo(index)
                this.onClose()
              })
              // 原版：左右滑动标签行移除该标签
              .gesture(PanGesture({ fingers: 1, direction: PanDirection.Horizontal, distance: 12 })
                .onActionUpdate((event: GestureEvent) => {
                  this.swipeOffsets[index] = event.offsetX
                })
                .onActionEnd((event: GestureEvent) => {
                  const offset = this.swipeOffsets[index] ?? 0
                  this.swipeOffsets[index] = 0
                  if (Math.abs(offset) > 80) {
                    this.removeTab(index)
                  }
                }))
              // 原版 f8.l0.t3：长按弹行操作菜单（w5.k.h0(view) 锚定该行弹出）
              .bindPopup(this.longPressIndex === index, {
                builder: (): void => {
                  this.TabMenu(index)
                },
                placement: Placement.Top,
                popupColor: Color.Transparent,
                enableArrow: false,
                autoCancel: true,
                onStateChange: (e: PopupStateChangeParam) => {
                  if (!e.isVisible) {
                    this.longPressIndex = -1
                  }
                }
              })
              .gesture(LongPressGesture({ repeat: false, duration: 500 })
                .onAction(() => {
                  this.longPressIndex = index
                }))
            }, (tab: TabItem) => tab.id.toString())
          }
          .width('100%')
        }
        .width('100%')
        .align(Alignment.Bottom)
        .scrollBar(BarState.Off)

        Row() {
          // 原版 + 按钮 = drawable ay（Rd ic_add）：点击新建标签，长按打开「关闭的标签页」
          // （f8/l0.c3：contentDescription ad「新建标签」，longClick → b.f() → k6.ia()）
          ViaIcon({ icon: $r('app.media.via_ic_add'), iconSize: 24, iconColor: PANEL_FG })
            .padding(12)
            .accessibilityText('新建标签')
            .onClick(() => {
              // 原版隐身会话中新建标签同为隐身（k6.cb/l8 会话模型）
              this.tabStore.newTab(this.tabStore.sessionIncognito)
              this.onClose()
            })
            .gesture(LongPressGesture({ repeat: false, duration: 500 })
              .onAction(() => {
                this.openClosedTabs()
              }))
        }
        .width('100%')
        .justifyContent(FlexAlign.Center)
      }
      .width('100%')
      // 原版 f8/l0.n3()：min(48dp*条数, max_height-48dp-2*8dp)，max_height=窗口高-16dp（k6:3748）
      .constraintSize({ maxHeight: this.panelMaxHeight })
      .padding({ top: 8, bottom: this.insets.bottom })
      // 原版面板悬于底部工具栏之上，工具栏保持可见
      .margin({ bottom: 48 })
      .backgroundColor($r('app.color.menu_bg'))
      .borderRadius({ topLeft: 16, topRight: 16 })
      // 原版 f8.l0 用 style n 弹窗主题 → windowAnimationStyle=style/k → anim/a 进、anim/b 出（240ms bounce）
      .transition(dialogTransition())
    }
    .width('100%')
    .height('100%')
  }

  // 原版 k6:3748：max_height = 窗口高度 - 16dp
  private maxPanelHeight(): number {
    try {
      const d = display.getDefaultDisplaySync()
      return d.height / d.densityPixels
    } catch (error) {
      return 800
    }
  }

  private removeTab(index: number): void {
    const info = this.tabStore.closeTab(index)
    if (info !== null) {
      this.showUndoSingle(info)
    }
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
        })
      }
      // 原版 t3：该行既非首也非尾才同时给「关闭上方/下方」（f8/l0.java:459）
      if (index > 0 && index < this.tabStore.tabs.length - 1) {
        this.MenuItem($r('app.string.close_tabs_above'), (): void => {
          const result = this.tabStore.closeAbove(index)
          this.showUndoBatch(result)
        })
        this.MenuItem($r('app.string.close_tabs_below'), (): void => {
          const result = this.tabStore.closeBelow(index)
          this.showUndoBatch(result)
        })
      }
      if (this.isHttpTab(index)) {
        this.MenuItem($r('app.string.duplicate_tab'), (): void => {
          this.tabStore.duplicateTab(index)
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
      builder: (): void => {
        this.UndoDialog()
      },
      isModal: false,
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
