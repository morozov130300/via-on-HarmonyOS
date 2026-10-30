// 定制菜单页：视频同款宫格定制（Via 7.4 原版「定制菜单」）
// - 上层「当前菜单」宫格：按住拖拽即可重新排列条目；
// - 下层「可添加条目」宫格：按住并拖动或点击来添加（反向拖回即可移除）；
// - 右上角「重置」恢复默认；
// 实现走单个可滚动 Grid（多个 Grid 间拖拽互抢手势，官方 FAQ faqs-arkui-1401），
// 分隔提示行用 GridLayoutOptions.irregularIndexes 占一整行（API 参考示例3），
// 整体拖拽排序用 API 26 的 ForEach.onMove（支持跨不规则节点的宫格拖拽）。
import { AppSettings } from '../common/Settings'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { ViaIcon } from '../components/ViaIcon'
import { MENU_DEFAULT_ORDER, isMenuId, menuIcon, menuLabel } from '../common/MenuItems'

const KIND_ACTIVE: string = 'active'
const KIND_SEPARATOR: string = 'sep'
const KIND_POOL: string = 'pool'

const CELL_HEIGHT: number = 72
const SEPARATOR_HEIGHT: number = 34

class FlatMenuItem {
  kind: string
  id: string

  constructor(kind: string, id: string) {
    this.kind = kind
    this.id = id
  }
}

@ComponentV2
export struct SettingsMenuPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // 单一扁平数组承载两个区：KIND_SEPARATOR 之前是当前菜单，之后是可添加条目。
  // 落序/跨区拖拽都是同一条数组的 splice，语义与框架 onMove 完全一致
  @Local items: FlatMenuItem[] = []
  // 全宽分隔提示行依赖 irregularIndexes；activeCount 变化时分隔行索引要跟着刷新
  @Local layoutOptions: GridLayoutOptions = {
    regularSize: [1, 1],
    irregularIndexes: [0]
  }
  // 拖拽过程中 onMove 会连续落位（跨多格触发多次），持久化做防抖
  private persistTimer: number = -1

  aboutToAppear(): void {
    this.loadFromSettings()
  }

  aboutToDisappear(): void {
    if (this.persistTimer >= 0) {
      clearTimeout(this.persistTimer)
      this.persistTimer = -1
      this.persistNow()
    }
  }

  private loadFromSettings(): void {
    // 以设置里的 menuOrder 为主序，缺漏的条目按默认顺序补齐（防止旧数据/新增条目丢失）
    const activeOrder: string[] = []
    for (let i = 0; i < this.settings.menuOrder.length; i++) {
      const id = this.settings.menuOrder[i]
      if (isMenuId(id) && activeOrder.indexOf(id) < 0) {
        activeOrder.push(id)
      }
    }
    for (let i = 0; i < MENU_DEFAULT_ORDER.length; i++) {
      const id = MENU_DEFAULT_ORDER[i]
      if (activeOrder.indexOf(id) < 0 && this.settings.menuHidden.indexOf(id) < 0) {
        activeOrder.push(id)
      }
    }
    // 可添加区：menuHidden 里的条目保持用户排过的序，再补齐其余缺漏
    const pool: string[] = []
    for (let i = 0; i < this.settings.menuHidden.length; i++) {
      const id = this.settings.menuHidden[i]
      if (isMenuId(id) && activeOrder.indexOf(id) < 0 && pool.indexOf(id) < 0) {
        pool.push(id)
      }
    }
    for (let i = 0; i < MENU_DEFAULT_ORDER.length; i++) {
      const id = MENU_DEFAULT_ORDER[i]
      if (activeOrder.indexOf(id) < 0 && pool.indexOf(id) < 0) {
        pool.push(id)
      }
    }
    const flat: FlatMenuItem[] = []
    for (let i = 0; i < activeOrder.length; i++) {
      flat.push(new FlatMenuItem(KIND_ACTIVE, activeOrder[i]))
    }
    flat.push(new FlatMenuItem(KIND_SEPARATOR, ''))
    for (let i = 0; i < pool.length; i++) {
      flat.push(new FlatMenuItem(KIND_POOL, pool[i]))
    }
    this.items = flat
    this.refreshSeparatorIndex()
  }

  private separatorIndex(): number {
    for (let i = 0; i < this.items.length; i++) {
      if (this.items[i].kind === KIND_SEPARATOR) {
        return i
      }
    }
    return 0
  }

  private refreshSeparatorIndex(): void {
    // Grid 的 constructor 参数在状态整体替换时重新生效（官方示例整对象替换模式）
    this.layoutOptions = {
      regularSize: [1, 1],
      irregularIndexes: [this.separatorIndex()]
    }
  }

  // 拖拽落位：纯数组 splice，与 onMove 的 from/to 语义一致（先移除再插入）。
  // 落在分隔行提示上或跨过分隔行时同样成立：此前（菜单区）= 上移归位，此后（池区）= 移出/加入，
  // 条目归属完全由「相对分隔行的位置」决定，无需额外判断
  private onFlatMove(from: number, to: number): void {
    if (from === to || from < 0 || to < 0 || from >= this.items.length) {
      return
    }
    if (this.items[from].kind === KIND_SEPARATOR) {
      return
    }
    const item = this.items[from]
    this.items.splice(from, 1)
    this.items.splice(to, 0, item)
    this.refreshSeparatorIndex()
    this.schedulePersist()
  }

  // 点击可添加区条目 = 加入当前菜单末尾（文案「按住并拖动或点击来添加条目」）
  private onPoolCellClick(item: FlatMenuItem): void {
    const index = this.indexOfItem(item)
    if (index < 0) {
      return
    }
    const sepIndex = this.separatorIndex()
    this.getUIContext()?.animateTo({ duration: 220, curve: Curve.EaseOut }, () => {
      const tmp = this.items.splice(index, 1)[0]
      this.items.splice(sepIndex, 0, tmp)
    })
    this.refreshSeparatorIndex()
    this.persistNow()
  }

  private indexOfItem(item: FlatMenuItem): number {
    for (let i = 0; i < this.items.length; i++) {
      if (this.items[i].id === item.id && this.items[i].kind === item.kind) {
        return i
      }
    }
    return -1
  }

  private schedulePersist(): void {
    if (this.persistTimer >= 0) {
      clearTimeout(this.persistTimer)
    }
    this.persistTimer = setTimeout(() => {
      this.persistTimer = -1
      this.persistNow()
    }, 300)
  }

  private persistNow(): void {
    const order: string[] = []
    const hidden: string[] = []
    for (let i = 0; i < this.items.length; i++) {
      const item = this.items[i]
      if (item.kind === KIND_ACTIVE) {
        order.push(item.id)
      } else if (item.kind === KIND_POOL) {
        hidden.push(item.id)
      }
    }
    this.settings.setMenuOrder(order)
    this.settings.setMenuHidden(hidden)
  }

  private resetToDefault(): void {
    this.settings.setMenuOrder(MENU_DEFAULT_ORDER.slice())
    this.settings.setMenuHidden([])
    this.loadFromSettings()
  }

  private bindAppBar(): void {
    AppBar.show({
      title: '定制菜单',
      rightText: '重置',
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight: () => {
        this.resetToDefault()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Text('按住并拖动即可重新排列条目')
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .width('100%')
          .textAlign(TextAlign.Center)
          .padding({ top: 6, bottom: 10 })
        Grid(undefined, this.layoutOptions) {
          ForEach(this.items, (item: FlatMenuItem) => {
            GridItem() {
              if (item.kind === KIND_SEPARATOR) {
                Text('按住并拖动或点击来添加条目')
                  .fontSize(13)
                  .fontColor($r('app.color.fg_secondary'))
                  .width('100%')
                  .textAlign(TextAlign.Center)
                  .height('100%')
              } else {
                Column({ space: 6 }) {
                  ViaIcon({ icon: menuIcon(item.id), iconSize: 24, iconColor: $r('app.color.fg'), imageDraggable: false })
                  Text(menuLabel(item.id))
                    .fontSize(11)
                    .fontColor($r('app.color.fg_secondary'))
                    .maxLines(1)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                }
                .width('100%')
                .height('100%')
                .justifyContent(FlexAlign.Center)
                .alignItems(HorizontalAlign.Center)
                .onClick(() => {
                  if (item.kind === KIND_POOL) {
                    this.onPoolCellClick(item)
                  }
                })
              }
            }
            .height(item.kind === KIND_SEPARATOR ? SEPARATOR_HEIGHT : CELL_HEIGHT)
          }, (item: FlatMenuItem) => `${item.kind}_${item.id}`)
            // 拖拽排序走 ForEach.onMove（API 26）：支持跨不规则分隔行的宫格拖拽与边缘自动滚动；
            // 落位回调逐次触发，统一进 onFlatMove 做纯数组 splice
            .onMove((from: number, to: number) => {
              this.onFlatMove(from, to)
            })
        }
        .columnsTemplate('1fr 1fr 1fr 1fr 1fr')
        .columnsGap(6)
        .rowsGap(10)
        .scrollBar(BarState.Off)
        .layoutWeight(1)
        .padding({ left: 12, right: 12 })
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
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }
}

@Builder
export function SettingsMenuPageBuilder() {
  SettingsMenuPage()
}
