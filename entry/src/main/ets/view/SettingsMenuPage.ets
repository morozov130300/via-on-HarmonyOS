// 定制菜单页：1:1 复刻原版 Via 7.4.0 i8/s（定制菜单 Fragment）
// 结构（原版 i8/s.X1）：单个 5 列 Grid，扁平列表 =
//   [提示行「按住并拖动即可重新排列条目」(i8/x)] + 当前菜单条目 + [提示行「按住并拖动或点击来添加条目」] + 可添加条目
// 拖拽（i8/s.b/ItemTouchHelper）：仅菜单条目(m)可拖；落位 x3()；点击（i8/s.g3）：菜单区点击=移到池区首位，
// 池区点击=加入菜单末尾（A3()：池区取走插到当前菜单尾部），设置(id10)双向均不可移出（p3/x3）。
// 保存（i8/s.z3→O2/H2）：displayedmenus / hiddenmenus 逗号数字串。
// 单元格（i8/o.d+l）：背景 drawable/o（圆角 18dp、按压 #30808080）、padding 15dp(上下) 5dp(左右)、
//   图标上文字下、图标 tint attr a9（日 #232323/夜 #9f9f9f）、文字 11sp（dimen ab）、图标-文字 2dp、双行省略。
// 提示行（i8/y.d）：上下 margin 16dp、左右 padding 16dp、14sp（dimen a_）、色 attr ad（日 #8a000000/夜 #99ffffff）。
// 页面底色：主题 windowBackground（日 #ffffff / 夜 #000000）。
// 重置确认弹窗（i8/s.a3 → w5/k）：标题「重置为默认设置」16sp 粗体、正文「你确定继续吗？」14sp、
//   左下「取消」右下「重置」14sp #6f8de1 minWidth 56dp padding 16dp，
//   弹窗背景圆角 18dp 描边 1dp #30808080 底色 #ffffff/#1c1b1d、dim 0.4。
import { AppSettings } from '../common/Settings'
import { computeDialogWidthVp } from '../components/ViaDialogCard'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { ViaIcon } from '../components/ViaIcon'
import { MENU_DEFAULT_ORDER, isMenuId, menuIcon, menuLabel, menuSkinIconName } from '../common/MenuItems'

const KIND_ACTIVE: string = 'active'
const KIND_SEPARATOR_TOP: string = 'sep_top'
const KIND_SEPARATOR_BOTTOM: string = 'sep_bottom'
const KIND_POOL: string = 'pool'

// 提示行高度：14sp 文字 + 上下 margin16/padding16 ≈ 16+16+22 ≈ 54vp
const SEP_HEIGHT: number = 54
// 单元格高度：15dp padding + 图标(24) + 2dp + 文字(2×15) + 15dp ≈ 76dp（i8/o.d 数值）
const CELL_HEIGHT: number = 76

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
  // 单一扁平数组：sep_top → active… → sep_bottom → pool…（与 i8/s.y3 同构）
  @Local items: FlatMenuItem[] = []
  // 两条全宽提示行都依赖 irregularIndexes
  @Local layoutOptions: GridLayoutOptions = {
    regularSize: [1, 1],
    irregularIndexes: [0]
  }
  // 拖拽过程中 onMove 连续落位，持久化做防抖（原版在 onPause/onSave 一次性 z3()）
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

  // 对应 i8/s.w3()：displayedmenus(t0) 顺序构建当前菜单区；hiddenmenus(F2) 构建池区；
  // c() 集合里未出现在两表中的 id（新版新增条目）按升序补进池区尾部。
  private loadFromSettings(): void {
    const active: string[] = []
    const pool: string[] = []
    const seen: Set<string> = new Set<string>()
    // t0(): menuOrder 中的 id 进当前菜单区
    for (let i = 0; i < this.settings.menuOrder.length; i++) {
      const id = this.settings.menuOrder[i]
      if (isMenuId(id) && !seen.has(id)) {
        seen.add(id)
        active.push(id)
      }
    }
    // F2(): menuHidden 中的 id 进池区（保持用户排序）
    for (let i = 0; i < this.settings.menuHidden.length; i++) {
      const id = this.settings.menuHidden[i]
      if (isMenuId(id) && !seen.has(id)) {
        seen.add(id)
        pool.push(id)
      }
    }
    // c() 集合剩余（从未写入 order/hidden 的新条目）：排序后补进池区（i8/s.w3 else 分支）
    for (let i = 0; i < MENU_DEFAULT_ORDER.length; i++) {
      const id = MENU_DEFAULT_ORDER[i]
      if (!seen.has(id)) {
        seen.add(id)
        pool.push(id)
      }
    }
    // i8/s.p3：设置(id10)必须留在当前菜单区
    if (active.indexOf('settings') < 0) {
      active.push('settings')
    }
    const flat: FlatMenuItem[] = [new FlatMenuItem(KIND_SEPARATOR_TOP, '')]
    for (let i = 0; i < active.length; i++) {
      flat.push(new FlatMenuItem(KIND_ACTIVE, active[i]))
    }
    flat.push(new FlatMenuItem(KIND_SEPARATOR_BOTTOM, ''))
    for (let i = 0; i < pool.length; i++) {
      flat.push(new FlatMenuItem(KIND_POOL, pool[i]))
    }
    this.items = flat
    this.refreshSeparatorIndex()
  }

  private separatorIndexes(): number[] {
    const out: number[] = []
    for (let i = 0; i < this.items.length; i++) {
      if (this.items[i].kind === KIND_SEPARATOR_TOP || this.items[i].kind === KIND_SEPARATOR_BOTTOM) {
        out.push(i)
      }
    }
    return out
  }

  private refreshSeparatorIndex(): void {
    this.layoutOptions = {
      regularSize: [1, 1],
      irregularIndexes: this.separatorIndexes()
    }
  }

  // 第一条提示行之后、第二条提示行之前 = 当前菜单区（u3/v3 语义）
  private activeCount(): number {
    let n = 0
    for (let i = 0; i < this.items.length; i++) {
      if (this.items[i].kind === KIND_ACTIVE) {
        n++
      }
    }
    return n
  }

  private poolCount(): number {
    let n = 0
    for (let i = 0; i < this.items.length; i++) {
      if (this.items[i].kind === KIND_POOL) {
        n++
      }
    }
    return n
  }

  private activeRange(): number[] {
    let start = -1
    let end = -1
    for (let i = 0; i < this.items.length; i++) {
      if (this.items[i].kind === KIND_SEPARATOR_TOP) {
        start = i
      } else if (this.items[i].kind === KIND_SEPARATOR_BOTTOM) {
        end = i
        break
      }
    }
    const range: number[] = [start, end]
    return range
  }

  // 对应 i8/s.A3()：菜单区条目点击 → d(false) 移到池区首位；池区条目点击 → d(true) 加到菜单区末尾。
  // 设置(id10)不可移出菜单区（g3 里 b()==10 直接 return）
  private onCellClick(item: FlatMenuItem): void {
    if (item.id === 'settings') {
      return
    }
    const index = this.indexOfItem(item)
    if (index < 0) {
      return
    }
    const range = this.activeRange()
    const end = range[1]
    if (item.kind === KIND_ACTIVE) {
      // 移除后插到 sep_bottom 之后 = 池区首位（i8/s.A3: f7087v0.add(0, m)）
      this.getUIContext()?.animateTo({ duration: 220, curve: Curve.EaseOut }, () => {
        const tmp = this.items.splice(index, 1)[0]
        this.items.splice(end, 0, tmp)
      })
    } else {
      // 移除后插到 sep_bottom 之前 = 菜单区末尾（i8/s.A3: f7086u0.add(m)）
      this.getUIContext()?.animateTo({ duration: 220, curve: Curve.EaseOut }, () => {
        const tmp = this.items.splice(index, 1)[0]
        this.items.splice(end, 0, tmp)
      })
    }
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

  // 对应 i8/s.x3()：拖拽落位。纯数组 splice，归属由相对两条提示行的位置决定。
  private onFlatMove(from: number, to: number): void {
    if (from === to || from < 0 || to < 0 || from >= this.items.length || to >= this.items.length) {
      return
    }
    const moving = this.items[from]
    if (moving.kind !== KIND_ACTIVE && moving.kind !== KIND_POOL) {
      return
    }
    const target = this.items[to]
    // 提示行不是合法落点：吸附到相邻区（原版 ItemTouchHelper 不会把条目落在 x 提示行上）
    if (target.kind !== KIND_ACTIVE && target.kind !== KIND_POOL) {
      return
    }
    // 设置(id10)：不可移出菜单区（x3 中 b()==10 && i10>=s3() → -1）
    if (moving.id === 'settings' && moving.kind === KIND_ACTIVE) {
      const range = this.activeRange()
      const start = range[0]
      const end = range[1]
      if (to > end) {
        return
      }
      if (start < 0 || end < 0) {
        return
      }
    }
    this.items.splice(from, 1)
    this.items.splice(to, 0, moving)
    this.refreshSeparatorIndex()
    this.schedulePersist()
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

  // 对应 i8/s.z3()：保存 displayedmenus / hiddenmenus（settings.p3 保证设置在菜单区）
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
    if (order.indexOf('settings') < 0) {
      order.push('settings')
    }
    this.settings.setMenuOrder(order)
    this.settings.setMenuHidden(hidden)
  }

  private resetToDefault(): void {
    this.settings.setMenuOrder(MENU_DEFAULT_ORDER.slice())
    this.settings.setMenuHidden([])
    this.loadFromSettings()
  }

  // i8/s.a3：右上「重置」→ w5/k 确认弹窗（标题 rw「重置为默认设置」/ 正文 g8「你确定继续吗？」/
  // 确认 ao「重置」/ 取消 R.string.cancel）。布局 u：标题16sp粗体、正文14sp、按钮14sp #6f8de1。
  // 弹窗背景 drawable t/u：圆角 18dp、描边 1dp #30808080、底色 日#ffffff/夜#1c1b1d、dim 0.4。
  private confirmReset(): void {
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.ResetConfirmDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.resetDialogId = dialogId
    }).catch(() => {
      console.error('open menu reset dialog failed')
    })
  }

  private resetDialogId: number = -1

  private closeResetDialog(): void {
    if (this.resetDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.resetDialogId)
    this.resetDialogId = -1
  }

  @Builder
  ResetConfirmDialog() {
    // w5/k.m + layout u：垂直排列，顶部 Space12 → 标题 → 正文 → 底部 Space12 → 按钮行（gravity end）
    Column() {
      // 顶部 Space 12dp
      Column()
        .height(12)
        .width('100%')
      // 标题 style a7→a0：16sp 粗体 attr ac，padding 上下8 左右16，margin 底 6
      Text($r('app.string.reset_default_title'))
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.dialog_text'))
        .maxLines(1)
        .textAlign(TextAlign.Start)
        .width('100%')
        .padding({ left: 16, right: 16, top: 8, bottom: 8 })
        .margin({ bottom: 6 })
      // 正文 style a6：14sp attr ac，行距 4dp，padding 上下8 左右16
      Text($r('app.string.reset_default_msg'))
        .fontSize(14)
        .fontColor($r('app.color.dialog_text'))
        .lineHeight(22)
        .width('100%')
        .padding({ left: 16, right: 16, top: 8, bottom: 8 })
      // 底部 Space 12dp
      Column()
        .height(12)
        .width('100%')
      // 按钮行：gravity end，取消在左，重置在右（style y：14sp @color/p、minWidth 56、padding16）
      Row() {
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeResetDialog()
          })
        Text($r('app.string.reset_action'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.resetToDefault()
            this.closeResetDialog()
          })
      }
      .width('100%')
      .justifyContent(FlexAlign.End)
    }
    .width('90%')
    .constraintSize({ maxWidth: 300 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
  }

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.customize_menu'),
      rightText: $r('app.string.reset'),
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight: () => {
        this.confirmReset()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        if (this.items.length > 0) {
          Grid(undefined, this.layoutOptions) {
          ForEach(this.items, (item: FlatMenuItem) => {
            GridItem() {
              if (item.kind === KIND_SEPARATOR_TOP) {
                // i8/y.d：上下 margin16、左右 padding16、14sp、色 attr ad
                // 活动区为空时不渲染顶提示行（GridItem 内容空 → 不占行高）
                if (this.activeCount() > 0) {
                  Text($r('app.string.drag_to_reorder_hint'))
                    .fontSize(14)
                    .fontColor($r('app.color.menu_hint'))
                    .width('100%')
                    .textAlign(TextAlign.Center)
                    .height('100%')
                    .padding({ left: 16, right: 16 })
                    .margin({ top: 16, bottom: 16 })
                }
              } else if (item.kind === KIND_SEPARATOR_BOTTOM) {
                // 池区为空时不渲染底提示行
                if (this.poolCount() > 0) {
                  Text($r('app.string.drag_to_add_hint'))
                    .fontSize(14)
                    .fontColor($r('app.color.menu_hint'))
                    .width('100%')
                    .textAlign(TextAlign.Center)
                    .height('100%')
                    .padding({ left: 16, right: 16 })
                    .margin({ top: 16, bottom: 16 })
                }
              } else {
                // i8/o.d + l：Column 上下 padding15 左右5、图标上文字下 2dp 间距、11sp 双行
                Column({ space: 2 }) {
                  ViaIcon({
                    icon: menuIcon(item.id),
                    iconSize: 24,
                    iconColor: $r('app.color.menu_icon'),
                    imageDraggable: false,
                    iconName: menuSkinIconName(item.id)
                  })
                  Text(menuLabel(item.id))
                    .fontSize(11)
                    .fontColor($r('app.color.fg'))
                    .maxLines(2)
                    .lineHeight(15)
                    .textAlign(TextAlign.Center)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                }
                .width('100%')
                .height('100%')
                .padding({ top: 15, bottom: 15, left: 5, right: 5 })
                .justifyContent(FlexAlign.Center)
                .alignItems(HorizontalAlign.Center)
                .borderRadius(18)
                .stateStyles({
                  pressed: {
                    .backgroundColor('rgba(128,128,128,0.19)')
                  },
                  normal: {
                    .backgroundColor(Color.Transparent)
                  }
                })
                .onClick(() => {
                  this.onCellClick(item)
                })
              }
            }
            .height(item.kind === KIND_ACTIVE || item.kind === KIND_POOL ? CELL_HEIGHT : SEP_HEIGHT)
          }, (item: FlatMenuItem) => `${item.kind}_${item.id}`)
            // 拖拽排序走 ForEach.onMove（API 26）：支持跨不规则提示行的宫格拖拽与边缘自动滚动；
            // 落位回调逐次触发，统一进 onFlatMove 做纯数组 splice（i8/s.x3 语义）
            .onMove((from: number, to: number) => {
              this.onFlatMove(from, to)
            })
        }
        .columnsTemplate('1fr 1fr 1fr 1fr 1fr')
          .columnsGap(0)
          .rowsGap(0)
          .scrollBar(BarState.Off)
          .layoutWeight(1)
          .padding({ left: 0, right: 0 })
        }
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
}

@ComponentV2
struct SettingsMenuPagePlaceholder {
  build() {
    Column()
  }
}

// 占位导出（原 AppBarSpacer 兼容），避免外部引用断裂
export { SettingsMenuPagePlaceholder as SettingsMenuPageLegacy }

@Builder
export function SettingsMenuPageBuilder() {
  SettingsMenuPage()
}
