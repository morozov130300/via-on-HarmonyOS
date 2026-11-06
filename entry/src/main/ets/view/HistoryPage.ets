import { HistoryRec } from '../common/Types'
import { BrowserDb } from '../common/Database'
import { TabStore } from '../common/TabStore'
import { AppIcon } from '../components/AppIcon'
import { ViaIcon } from '../components/ViaIcon'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { BusinessError, pasteboard } from '@kit.BasicServicesKit'
import { common } from '@kit.AbilityKit'
import { systemShare } from '@kit.ShareKit'
import { uniformTypeDescriptor as utd } from '@kit.ArkData'

// 原版 db/n.java 1:1 移植（历史页）：
// - 日期分组头（v8.b + v8.a）：今天(zo)/昨天(a1z)/同年「MM月dd日 EEE」/跨年「yyyy年MM月dd日 EEE」
// - 底栏 a0：普通态 [标签页(vt)|编辑(a3)、清空(y)]，多选态 [全选(ta)/取消全选(d_)、
//   删除(x)/删除(N)(fj)|完成(gm)]（n.C1/w3）
// - 清空 K0 → p3：无搜索词时弹分组清除菜单（Y2：过去一小时(m7)/今天(zo)/今天和昨天(zp)/
//   过去 7 天(m8)/所有时间(c1)，标题 fk 清除浏览历史，跳过 0 计数并倒序）；有搜索词时
//   确认删除全部所示（q3）
// - 长按菜单 b3 = [后台打开(af)/新标签打开(ag)/删除(x)/复制链接(s)/分享(at)]
// - 多选 + 拖选（n8.b 左缘拖选等价：选中态下纵向拖动扩展选择范围）+ 批量删除确认（fl/fm）

// 行模型（v8.b 分组：头/条目二态）
class HistoryRow {
  isHeader: boolean
  header: string
  item: HistoryRec | null

  constructor(isHeader: boolean, header: string, item: HistoryRec | null) {
    this.isHeader = isHeader
    this.header = header
    this.item = item
  }
}

// 分组清除项（bb.v.t：w.d(boundary, count) + 名称）
class ClearGroup {
  name: string
  boundary: number
  count: number

  constructor(name: string, boundary: number, count: number) {
    this.name = name
    this.boundary = boundary
    this.count = count
  }
}

@ComponentV2
export struct HistoryPage {
  private db: BrowserDb = BrowserDb.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local items: HistoryRec[] = []
  // 原版历史页搜索框（sz 搜索历史同款交互）
  @Local query: string = ''
  // 多选（原版 b6.a + N0「编辑」）
  @Local selecting: boolean = false
  @Local selectedIds: number[] = []
  // 长按行锚定（n.b3）
  @Local menuRowId: number = -1
  // 分组清除菜单（n.Y2）
  @Local clearMenuOpen: boolean = false
  // favicon 加载失败回退
  @Local faviconFailed: Record<number, boolean> = {}

  aboutToAppear(): void {
    this.reload()
  }

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.history'),
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
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
          })
        if (this.visibleItems().length === 0) {
          Column() {
            Text($r('app.string.empty_history'))
              .fontSize(14)
              .fontColor($r('app.color.fg_secondary'))
          }
          .width('100%')
          .layoutWeight(1)
          .justifyContent(FlexAlign.Center)
        } else {
          List({ space: 1 }) {
            ForEach(this.buildRows(), (row: HistoryRow) => {
              if (row.isHeader) {
                ListItem() {
                  Text(row.header)
                    .fontSize(12)
                    .fontColor($r('app.color.fg_secondary'))
                    .width('100%')
                    .height(32)
                    .padding({ left: 16, right: 16 })
                    .textAlign(TextAlign.Start)
                }
              } else if (row.item !== null) {
                ListItem() {
                  this.ItemRow(row.item)
                }
              }
            }, (row: HistoryRow) => row.isHeader ? `h${row.header}` : `r${row.item === null ? 0 : row.item.id}`)
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
    }
    .hideTitleBar(true)
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

  @Builder
  ItemRow(item: HistoryRec) {
    Row({ space: 12 }) {
      if (this.selecting) {
        this.SelectCircle(item.id)
      }
      Column() {
        if (this.faviconFailed[item.id] === true) {
          ViaIcon({ icon: $r('app.media.via_ic_webpage'), iconSize: 22, iconColor: $r('app.color.fg') })
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
        Text(item.url)
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
    .opacity(this.isSelected(item.id) || !this.selecting ? 1 : 0.5)
    .onClick(() => {
      if (this.selecting) {
        this.toggleSelect(item.id)
        return
      }
      this.tabStore.navigate(item.url)
      this.navPathStack.pop()
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
          this.menuRowId = -1
        }
      }
    })
    .gesture(LongPressGesture({ repeat: false, duration: 500 })
      .onAction(() => {
        this.menuRowId = item.id
      }))
    // 拖选（n8.b 左缘拖选等价）：选中态下纵向拖动按行扩展选择区间
    .gesture(PanGesture({ fingers: 1, direction: PanDirection.Vertical, distance: 14 })
      .onActionStart(() => {
        if (this.selecting) {
          this.dragAnchorIndex = this.rowIndexOf(item.id)
          this.dragAnchorSelected = this.isSelected(item.id)
        }
      })
      .onActionUpdate((event: GestureEvent) => {
        if (!this.selecting || this.dragAnchorIndex < 0) {
          return
        }
        const steps = Math.round(px2vp(event.offsetY) / 56)
        this.applyDragRange(this.dragAnchorIndex + steps)
      })
      .onActionEnd(() => {
        this.dragAnchorIndex = -1
      }), GestureMask.IgnoreInternal)
  }

  @Builder
  SelectCircle(id: number) {
    Stack({ alignContent: Alignment.Center }) {
      Circle()
        .width(20)
        .height(20)
        .fill(this.isSelected(id) ? $r('app.color.accent') : Color.Transparent)
        .stroke(this.isSelected(id) ? $r('app.color.accent') : $r('app.color.fg_secondary'))
        .strokeWidth(1.5)
      if (this.isSelected(id)) {
        AppIcon({ icon: $r('sys.symbol.checkmark'), iconSize: 13, iconColor: Color.White })
      }
    }
    .width(24)
    .height(24)
  }

  // 长按菜单（n.b3：[后台打开 af/新标签打开 ag/删除 x/复制链接 s/分享 at]）
  @Builder
  RowMenu(item: HistoryRec) {
    Column() {
      this.MenuItem('后台打开', (): void => {
        this.tabStore.newTabAt(item.url, true)
        this.toastMsg('已在后台打开')
      })
      this.MenuItem('新标签打开', (): void => {
        this.tabStore.newTabAt(item.url, false)
        this.navPathStack.pop()
      })
      this.MenuItem('删除', (): void => {
        // 原版 u3：菜单单删无确认
        this.db.deleteHistory(item.id).then(() => {
          this.reload()
        }).catch((error: BusinessError) => {
          console.error(`delete history failed: ${error.message}`)
        })
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
        this.menuRowId = -1
        action()
      })
  }

  // ===== 底栏（n.C1/w3 1:1）=====

  @Builder
  BottomBar() {
    Column() {
      Divider()
        .strokeWidth(2)
        .color($r('app.color.divider'))
      Row() {
        if (this.selecting) {
          this.BarButton(this.allSelected() ? '取消全选' : '全选', false, (): void => {
            this.toggleSelectAll()
          }, false)
          this.BarButton(this.selectedIds.length > 0 ? `删除(${this.selectedIds.length})` : '删除',
            this.selectedIds.length <= 0, (): void => {
              this.confirmDeleteSelected()
            }, true)
          Blank()
          this.BarButton('完成', false, (): void => {
            this.exitSelection()
          }, false)
        } else {
          this.BarButton('标签页', false, (): void => {
            // 原版 T0 → bb.v.N → bb.i.b3 → ic 关闭的标签页页
            this.openClosedTabs()
          }, false)
          Blank()
          this.BarButton('编辑', this.items.length === 0, (): void => {
            this.enterSelection()
          }, false)
          this.BarButton('清空', this.items.length === 0, (): void => {
            this.clearMenuOpen = !this.clearMenuOpen
          }, false)
        }
      }
      .width('100%')
      .height(44)
      // 分组清除菜单锚定「清空」按钮（原版 Y2 锚定 K0）
      .bindPopup(this.clearMenuOpen, {
        builder: (): void => {
          this.ClearGroupsMenu()
        },
        placement: Placement.Top,
        popupColor: Color.Transparent,
        enableArrow: false,
        autoCancel: true,
        onStateChange: (e: PopupStateChangeParam) => {
          if (!e.isVisible) {
            this.clearMenuOpen = false
          }
        }
      })
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

  // 分组清除菜单（n.Y2：[所有时间/过去 7 天/今天和昨天/今天/过去一小时] 倒序，0 计数跳过）
  @Builder
  ClearGroupsMenu() {
    Column() {
      ForEach(this.clearGroups(), (group: ClearGroup) => {
        Text(`${group.name} (${group.count})`)
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .width('100%')
          .padding({ left: 16, right: 16, top: 12, bottom: 12 })
          .maxLines(1)
          .textAlign(TextAlign.Start)
          .onClick(() => {
            this.clearMenuOpen = false
            this.confirmClearGroup(group)
          })
      }, (group: ClearGroup) => `${group.name}_${group.boundary}`)
      if (this.clearGroups().length === 0) {
        Text('没有可清除的记录')
          .fontSize(14)
          .fontColor($r('app.color.fg_secondary'))
          .padding({ left: 16, right: 16, top: 12, bottom: 12 })
      }
    }
    .width(200)
    .padding({ top: 8, bottom: 8 })
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
  }

  // ===== 行为（n 1:1）=====

  private openClosedTabs(): void {
    try {
      // 路由名 'closedTabs' 需在 router_map.json 登记（主控接线项）
      this.navPathStack.pushPathByName('closedTabs', '', true)
    } catch (error) {
      console.error('open closed tabs page failed')
    }
  }

  private enterSelection(): void {
    this.selecting = true
    this.selectedIds = []
  }

  private exitSelection(): void {
    this.selecting = false
    this.selectedIds = []
    this.dragAnchorIndex = -1
  }

  private isSelected(id: number): boolean {
    return this.selectedIds.indexOf(id) >= 0
  }

  private toggleSelect(id: number): void {
    const next: number[] = []
    for (let i = 0; i < this.selectedIds.length; i++) {
      if (this.selectedIds[i] !== id) {
        next.push(this.selectedIds[i])
      }
    }
    if (!this.isSelected(id)) {
      next.push(id)
    }
    this.selectedIds = next
  }

  private allSelected(): boolean {
    return this.selectedIds.length > 0 && this.selectedIds.length === this.visibleItems().length
  }

  private toggleSelectAll(): void {
    if (this.allSelected()) {
      this.selectedIds = []
      return
    }
    const ids: number[] = []
    const items = this.visibleItems()
    for (let i = 0; i < items.length; i++) {
      ids.push(items[i].id)
    }
    this.selectedIds = ids
  }

  // 拖选（n8.b）：锚点行 + 拖动步数决定区间，按锚点初值统一选中/取消
  private dragAnchorIndex: number = -1
  private dragAnchorSelected: boolean = false

  private rowIndexOf(id: number): number {
    const items = this.visibleItems()
    for (let i = 0; i < items.length; i++) {
      if (items[i].id === id) {
        return i
      }
    }
    return -1
  }

  private applyDragRange(target: number): void {
    const items = this.visibleItems()
    const from = Math.min(Math.max(this.dragAnchorIndex, 0), items.length - 1)
    const to = Math.min(Math.max(target, 0), items.length - 1)
    const lo = Math.min(from, to)
    const hi = Math.max(from, to)
    const next: number[] = []
    for (let i = 0; i < this.selectedIds.length; i++) {
      const id = this.selectedIds[i]
      const idx = this.rowIndexOf(id)
      if (idx < lo || idx > hi) {
        next.push(id)
      }
    }
    for (let i = lo; i <= hi; i++) {
      if (this.dragAnchorSelected) {
        next.push(items[i].id)
      }
    }
    this.selectedIds = next
  }

  // 批量删除确认（n.q3：1 条 →「你确定删除 %1$s 吗？」(fl)，多条 →「你确定删除 %1$d 个条目吗?」(fm)）
  private confirmDeleteSelected(): void {
    if (this.selectedIds.length === 0) {
      return
    }
    let message = ''
    if (this.selectedIds.length === 1) {
      const item = this.itemById(this.selectedIds[0])
      message = `你确定删除 ${item === null ? '' : (item.title !== '' ? item.title : item.url)} 吗？`
    } else {
      message = `你确定删除 ${this.selectedIds.length} 个条目吗?`
    }
    AlertDialog.show({
      title: '删除',
      message: message,
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: $r('app.string.confirm'),
        action: () => {
          this.deleteByIds(this.selectedIds)
          this.exitSelection()
        }
      }
    })
  }

  private deleteByIds(ids: number[]): void {
    let pending = ids.length
    for (let i = 0; i < ids.length; i++) {
      this.db.deleteHistory(ids[i]).then(() => {
        pending--
        if (pending <= 0) {
          this.reload()
        }
      }).catch((error: BusinessError) => {
        pending--
        console.error(`delete history failed: ${error.message}`)
        if (pending <= 0) {
          this.reload()
        }
      })
    }
  }

  private itemById(id: number): HistoryRec | null {
    for (let i = 0; i < this.items.length; i++) {
      if (this.items[i].id === id) {
        return this.items[i]
      }
    }
    return null
  }

  // 分组清除（bb.v.A：删除 visited >= boundary 的条目）
  private confirmClearGroup(group: ClearGroup): void {
    AlertDialog.show({
      title: '清除浏览历史',
      message: `${group.name} (${group.count})`,
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: $r('app.string.confirm'),
        action: () => {
          const ids: number[] = []
          for (let i = 0; i < this.items.length; i++) {
            if (this.items[i].visited * 1000 >= group.boundary) {
              ids.push(this.items[i].id)
            }
          }
          this.deleteByIds(ids)
        }
      }
    })
  }

  // ===== 分组与过滤 =====

  private visibleItems(): HistoryRec[] {
    const keyword = this.query.trim().toLowerCase()
    if (keyword === '') {
      return this.items
    }
    const result: HistoryRec[] = []
    for (let i = 0; i < this.items.length; i++) {
      const item = this.items[i]
      if (item.title.toLowerCase().includes(keyword) || item.url.toLowerCase().includes(keyword)) {
        result.push(item)
      }
    }
    return result
  }

  // 日期分组行（v8.b/v8.a：按自然日分组；今天/昨天/同年「MM月dd日 EEE」/跨年「yyyy年MM月dd日 EEE」）
  private buildRows(): HistoryRow[] {
    const items = this.visibleItems()
    const rows: HistoryRow[] = []
    let lastDayStart = -1
    const now = new Date()
    const todayStart = new Date(now.getFullYear(), now.getMonth(), now.getDate()).getTime()
    for (let i = 0; i < items.length; i++) {
      const item = items[i]
      const dayStart = this.dayStartOf(item.visited * 1000)
      if (dayStart !== lastDayStart) {
        lastDayStart = dayStart
        rows.push(new HistoryRow(true, this.headerText(dayStart, todayStart), null))
      }
      rows.push(new HistoryRow(false, '', item))
    }
    return rows
  }

  private dayStartOf(timeMs: number): number {
    const d = new Date(timeMs)
    return new Date(d.getFullYear(), d.getMonth(), d.getDate()).getTime()
  }

  private headerText(dayStart: number, todayStart: number): string {
    if (dayStart === todayStart) {
      return '今天'
    }
    if (dayStart === todayStart - 86400000) {
      return '昨天'
    }
    const d = new Date(dayStart)
    const now = new Date()
    const weekday = new Intl.DateTimeFormat('zh-CN', { weekday: 'short' }).format(d)
    if (d.getFullYear() === now.getFullYear()) {
      return `${d.getMonth() + 1}月${d.getDate()}日 ${weekday}`
    }
    return `${d.getFullYear()}年${d.getMonth() + 1}月${d.getDate()}日 ${weekday}`
  }

  // 分组清除数据（bb.v.t：5 个边界 [过去一小时/今天/今天和昨天/过去 7 天/所有时间]，倒序展示）
  private clearGroups(): ClearGroup[] {
    const now = Date.now()
    const nd = new Date(now)
    const todayStart = new Date(nd.getFullYear(), nd.getMonth(), nd.getDate()).getTime()
    const boundaries: ClearGroup[] = [
      new ClearGroup('过去一小时', now - 3600000, 0),
      new ClearGroup('今天', todayStart, 0),
      new ClearGroup('今天和昨天', todayStart - 86400000, 0),
      new ClearGroup('过去 7 天', todayStart - 6 * 86400000, 0),
      new ClearGroup('所有时间', 0, 0)
    ]
    for (let i = 0; i < this.items.length; i++) {
      const visited = this.items[i].visited * 1000
      for (let j = 0; j < boundaries.length; j++) {
        if (visited >= boundaries[j].boundary) {
          boundaries[j].count++
        }
      }
    }
    const result: ClearGroup[] = []
    for (let j = boundaries.length - 1; j >= 0; j--) {
      if (boundaries[j].count > 0) {
        result.push(boundaries[j])
      }
    }
    return result
  }

  private faviconUrl(url: string): string {
    const withoutScheme = url.replace(/^https?:\/\//, '')
    const slash = withoutScheme.indexOf('/')
    const host = slash < 0 ? withoutScheme : withoutScheme.substring(0, slash)
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
      console.error('share history url failed')
    })
  }

  private toastMsg(message: string): void {
    this.getUIContext().getPromptAction().showToast({ message: message, duration: 1500 })
  }

  private reload(): void {
    this.db.listHistory().then((items: HistoryRec[]) => {
      this.items = items
    }).catch((error: BusinessError) => {
      console.error(`list history failed: ${error.message}`)
    })
  }
}

@Builder
export function HistoryPageBuilder() {
  HistoryPage()
}
