import { TOAST_SHORT } from '../common/ToastDuration'
import { ClosedTabEntry, ClosedTabsStore } from '../common/ClosedTabsStore'
import { computeDialogWidthVp } from '../components/UiaDialogCard'
import { UiaDialogButton } from '../components/UiaDialogButton'
import { TabStore } from '../common/TabStore'
import { UiaIcon } from '../components/UiaIcon'
import { AppIcon } from '../components/AppIcon'
import { UiInsets } from '../common/Immersive'
import { buildNavSlide } from './PageTransitions'
import { BusinessError, pasteboard } from '@kit.BasicServicesKit'
import { common } from '@kit.AbilityKit'
import { systemShare } from '@kit.ShareKit'
import { uniformTypeDescriptor as utd } from '@kit.ArkData'

// 原版 c8/ic.java 1:1 移植（关闭的标签页）：
// - 标题 rf「关闭的标签页」，搜索框（vx 图标），列表按关闭时间倒序（w3）
// - 行 = favicon + 标题（空标题回退 bh「无标题」）+ 主机名行（i6.g0.d）
// - 点击 f3：恢复该标签（前台）并返回；长按菜单 e3/l3 =
//   [后台打开(af)/新标签打开(ag)/删除(x)/复制链接(s)/分享(at)]；
//   后台打开 toast pc「已在后台打开」，单删无确认（c3）
// - 底栏 a0：左 [更多(nu)]，右 [清空(y) 强调色、空列表禁用]；
//   清空 → 确认框「清空」+「你确定继续吗？」(g8) → h() 清空（q3/h3）
// - 恢复后从恢复库移除条目（原版 K1：标签加载后移除）

@ComponentV2
export struct ClosedTabsPage {
  private tabStore: TabStore = TabStore.getInstance()
  private store: ClosedTabsStore = ClosedTabsStore.getInstance()
  private insets: UiInsets = UiInsets.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local items: ClosedTabEntry[] = []
  @Local query: string = ''
  @Local menuRowId: string = ''
  // 清空确认（q3：标题「清空」+ 正文「你确定继续吗？」）
  @Local showClearConfirm: boolean = false
  @Local faviconFailed: Record<string, boolean> = {}

  aboutToAppear(): void {
    this.store.ensureInit().then(() => {
      this.reload()
    }).catch((error: BusinessError) => {
      console.error(`closed tabs init failed: ${error.message}`)
    })
  }

  build() {
    NavDestination() {
      Stack() {
        Column() {
          this.HeaderBar()
          this.SearchField()
          if (this.items.length === 0) {
            // 原版 setEmpty：空态仅空视图（r3.b 无文案）
            Column()
              .width('100%')
              .layoutWeight(1)
          } else {
            List({ space: 0 }) {
              ForEach(this.items, (item: ClosedTabEntry) => {
                ListItem() {
                  this.ItemRow(item)
                }
              }, (item: ClosedTabEntry) => item.id)
            }
            .width('100%')
            .layoutWeight(1)
            .divider({ strokeWidth: 0.5, color: $r('app.color.divider') })
          }
          this.BottomBar()
        }
        .width('100%')
        .height('100%')
        .backgroundColor($r('app.color.page_bg'))

        if (this.showClearConfirm) {
          this.ClearConfirmOverlay()
        }
      }
      .width('100%')
      .height('100%')
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
        UiaIcon({ icon: $r('app.media.uia_ic_back'), iconSize: 22, iconColor: $r('app.color.fg') })
      }
        .width(44)
        .height(43)
        .onClick(() => {
          this.navPathStack.pop()
        })
      Text($r('app.string.orig_rf'))
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

  @Builder
  SearchField() {
    TextInput({ placeholder: $r('app.string.search') })
      .height(33)
      .fontSize(14)
      .placeholderFont({ size: 14 })
      .placeholderColor($r('app.color.fg_secondary'))
      .fontColor($r('app.color.fg'))
      .caretColor($r('app.color.accent'))
      .backgroundColor($r('app.color.surface'))
      .borderRadius(17)
      .margin({ left: 12, right: 12, top: 5, bottom: 5 })
      .onChange((value: string) => {
        this.query = value
        this.reload()
      })
  }

  @Builder
  ItemRow(item: ClosedTabEntry) {
    Row({ space: 12 }) {
      Column() {
        if (this.faviconFailed[item.id] === true) {
          UiaIcon({ icon: $r('app.media.uia_ic_webpage'), iconSize: 22, iconColor: $r('app.color.fg') })
        } else {
          Image(this.faviconUrl(item.url))
            .width(22)
            .height(22)
            .objectFit(ImageFit.Contain)
            .onError(() => {
              this.faviconFailed[item.id] = true
            })
        }
      }
      .justifyContent(FlexAlign.Center)
      Column({ space: 2 }) {
        Text(item.title !== '' ? item.title : item.url)
          .fontSize(15)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
        Text(this.hostOf(item.url))
          .fontSize(12)
          .fontColor($r('app.color.fg_secondary'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
      }
      .layoutWeight(1)
      .alignItems(HorizontalAlign.Start)
    }
    .width('100%')
    .height(56)
    .padding({ left: 16, right: 16 })
    // 点击 f3：恢复该标签（前台）并从恢复库移除
    .onClick(() => {
      this.restoreEntry(item, false)
    })
    .bindPopup(this.menuRowId === item.id, {
      builder: (): void => {
        this.RowMenu(item)
      },
      placement: Placement.Top,
      popupColor: Color.Transparent,
      enableArrow: false,
      autoCancel: true,
      onStateChange: (e: PopupStateChangeParam) => {
        if (!e.isVisible) {
          this.menuRowId = ''
        }
      }
    })
    .gesture(LongPressGesture({ repeat: false, duration: 500 })
      .onAction(() => {
        this.menuRowId = item.id
      }))
  }

  // 长按菜单（ic.e3：[后台打开 af/新标签打开 ag/删除 x/复制链接 s/分享 at]）
  @Builder
  RowMenu(item: ClosedTabEntry) {
    Column() {
      this.MenuItem('后台打开', (): void => {
        this.restoreEntry(item, true)
      })
      this.MenuItem('新标签打开', (): void => {
        this.restoreEntry(item, false)
      })
      this.MenuItem('删除', (): void => {
        this.store.removeByIds([item.id])
        this.reload()
      })
      this.MenuItem('复制链接', (): void => {
        try {
          pasteboard.getSystemPasteboard().setData(pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, item.url))
          this.toastMsg('已复制链接')
        } catch (error) {
          console.error('copy link failed')
        }
      })
      this.MenuItem('分享', (): void => {
        this.shareUrl(item.url)
      })
    }
    .width(200)
    .padding({ top: 8, bottom: 8 })
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
  }

  @Builder
  MenuItem(label: string, action: () => void) {
    Text(label)
      .fontSize(14)
      .fontColor($r('app.color.fg'))
      .width('100%')
      .padding({ left: 16, right: 16, top: 12, bottom: 12 })
      .maxLines(1)
      .textOverflow({ overflow: TextOverflow.Ellipsis })
      .textAlign(TextAlign.Start)
      .onClick(() => {
        this.menuRowId = ''
        action()
      })
  }

  // ===== 底栏（ic.Z2：左 [更多 nu]，右 [清空 y] 强调色、空态禁用）=====

  @Builder
  BottomBar() {
    Column() {
      Divider()
        .strokeWidth(2)
        .color($r('app.color.divider'))
      Row() {
        this.BarButton('更多', false, (): void => {
          // 原版 P0 → hb.e7「标签页设置」页（路由 'closedTabsMore' 需主控登记）
          this.navPathStack.pushPathByName('closedTabsMore', '', true)
        }, false)
        Blank()
        this.BarButton('清空', this.items.length === 0, (): void => {
          this.showClearConfirm = true
        }, true)
      }
      .width('100%')
      .height(44)
    }
    .width('100%')
    .backgroundColor($r('app.color.surface'))
  }

  @Builder
  BarButton(label: string, disabled: boolean, action: () => void, accent: boolean) {
    Text(label)
      .fontSize(15)
      .fontColor(disabled ? $r('app.color.fg_secondary') : (accent ? $r('app.color.accent') : $r('app.color.fg')))
      .opacity(disabled ? 0.5 : 1)
      .padding({ left: 16, right: 16, top: 10, bottom: 10 })
      .maxLines(1)
      .textAlign(TextAlign.Center)
      .onClick(() => {
        if (disabled) {
          return
        }
        action()
      })
  }

  // 清空确认（ic.q3：g6.n.e(清空, 你确定继续吗？)）
  @Builder
  ClearConfirmOverlay() {
    Column() {
      Column({ space: 16 }) {
        Text($r('app.string.orig_y'))
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
        Text($r('app.string.reset_default_msg'))
          .fontSize(14)
          .fontColor($r('app.color.fg_secondary'))
        Row() {
          Blank().layoutWeight(1)
          UiaDialogButton({ label: $r('app.string.cancel'), onAction: () => {
            this.showClearConfirm = false
          } })
          UiaDialogButton({ label: $r('app.string.confirm'), onAction: () => {
            this.showClearConfirm = false
            this.store.clear()
            this.reload()
          } })
        }
        .width('100%')
      }
      .width('100%')
      .padding(20)
      .borderRadius(18)
      .border({ width: 1, color: $r('app.color.dialog_border') })
      .backgroundColor($r('app.color.dialog_bg'))
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .backgroundColor('rgba(0,0,0,0.4)')
    .onClick(() => {
      this.showClearConfirm = false
    })
  }

  // 恢复条目（ic.l3 pos0/1：后台=toast pc 留在本页；前台=返回主界面）
  private restoreEntry(item: ClosedTabEntry, background: boolean): void {
    this.tabStore.newTabAt(item.url, background)
    this.store.removeByIds([item.id])
    if (background) {
      this.toastMsg('已在后台打开')
      this.reload()
      return
    }
    this.navPathStack.pop()
  }

  private hostOf(url: string): string {
    const withoutScheme = url.replace(/^https?:\/\//, '')
    const slash = withoutScheme.indexOf('/')
    return slash < 0 ? withoutScheme : withoutScheme.substring(0, slash)
  }

  private faviconUrl(url: string): string {
    const host = this.hostOf(url)
    if (host === '') {
      return ''
    }
    return `https://${host}/favicon.ico`
  }

  private shareUrl(url: string): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    const shareData: systemShare.SharedData = new systemShare.SharedData({
      utd: utd.UniformDataType.PLAIN_TEXT,
      content: url
    })
    const controller: systemShare.ShareController = new systemShare.ShareController(shareData)
    controller.show(context as common.UIAbilityContext, {
      selectionMode: systemShare.SelectionMode.SINGLE,
      previewMode: systemShare.SharePreviewMode.DETAIL
    }).catch(() => {
      console.error('share closed tab url failed')
    })
  }

  private toastMsg(message: string): void {
    this.getUIContext().getPromptAction().showToast({ message: message, duration: TOAST_SHORT })
  }

  // 时间倒序（ic.w3 Collections.sort desc）+ 搜索过滤（ic.v3：b(query, 1024)）
  private reload(): void {
    this.items = this.store.search(this.query, 1024)
  }
}

@Builder
export function ClosedTabsPageBuilder() {
  ClosedTabsPage()
}
