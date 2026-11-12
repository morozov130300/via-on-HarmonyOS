import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'
import { RecordBackController } from './RecordTypes'
import { BookmarkPage } from './BookmarkPage'
import { HistoryPage } from './HistoryPage'
import { OfflinePage } from './OfflinePage'
import { UiInsets } from '../common/Immersive'
import { BusinessError } from '@kit.BasicServicesKit'

// 原版 bb\i.java（RecordContainerFragment）1:1 移植——记录容器页：
// 所有「打开记录」入口（主页 logo cmd257→ja(true)→aa(null)、工具栏7/8、菜单书签/历史/
// 离线 case13、v://bookmarks、v://history）都进这一页，仅默认标签不同
// （n3(draggable,page)：1=书签 2=历史 3=离线页面，bb/i.java:157-161）。
//
// 结构（o8\h.java C1 + bb\i.java）：
//   LinearLayout(vertical)
//   ├ z 顶栏（返回键 + TabLayout + 右上「导出」动作 a3:264-269 → l0().L().c1()）
//   └ ViewPager2（三 Fragment：cb.e0 书签 / db.n 历史 / eb.s 离线页面）
// TabLayout（com.tuyafeng.support.widget.TabLayout）：
//   · setIndicatorColor(0)（bb/i.f3:141）→ 指示器透明（f4285s=0 → onDraw 不画）
//   · 文字色 = textColorPrimary 三态 statelist：selected/pressed 全不透明、
//     default α150 半透明（TabLayout 构造 316-318 m()）
//   · 字号 14sp（A=14）、sans-serif-medium、非加粗（J=0，291 行 SDK≥21）、
//     allCaps=false（bb/i.f3:144）、tab 左右 padding 12dp（f4292z=12）
//   · 宽自适应不均分（E=false → LayoutParams(-2,-1)）
//   · 底部 padding = max(indicatorHeight=2, underlineHeight=0) = 2px（r():569）
//   · 指示器关闭后视觉上只剩「选中全色/未选中半透明」的文字差异
// 顶栏 z（com.tuyafeng.support.widget.z）：
//   · 返回键 = drawable r（x7.o.f13759r=0x7f080022=b2）+ contentDescription「向上导航」
//     （x7.u.C8=0x7f100225=o1，values-zh-rCN:545），点击 = activity.onBackPressed（z.java:47-58）
//   · 右上动作：图标 b2 + 文案 Sd（contentDescription），点击 → fragmentManager 弹出（c1()）
//   · 底部 2px 分割线（z.java:262-267 onDraw）
// 标签名称 m3()（bb/i.java:310-321）：1→u.f14026j=书签 / 2→u.H=历史 / 3→u.f13929c0=离线页面
// 返回拦截（o8\h.V2 + bb\i.k3）：当前子页 W()=true（多选退出/清搜索/回上级文件夹）则不弹，
// 否则弹出容器。子页经 RecordBackController 注入。
// 本端路由：'bookmarks'/'history'/'offlinePage' 三个路由名都落到本页（router_map），
// 默认标签由路由名决定 —— 等价原版三个 n3(true,page) 调用点。

class RecordTabSpec {
  // 原版 f2116t0 的 page 值（1=书签 2=历史 3=离线页面）
  page: number
  label: ResourceStr

  constructor(page: number, label: ResourceStr) {
    this.page = page
    this.label = label
  }
}

// bb.i.m3() 的三个标签名（x7.u.f14026j/H/f13929c0 → values-zh-rCN j/a7/as）
const RECORD_TABS: RecordTabSpec[] = [
  new RecordTabSpec(1, $r('app.string.bookmarks')),
  new RecordTabSpec(2, $r('app.string.history')),
  new RecordTabSpec(3, $r('app.string.offline_page'))
]

// 路由名 → 原版 page 值（k6.java 各入口 n3(true,page) 的落点）
function defaultPageOfRoute(route: string): number {
  if (route === 'history') {
    return 2
  }
  if (route === 'offlinePage') {
    return 3
  }
  return 1
}

@ComponentV2
export struct RecordContainerPage {
  private navPathStack: NavPathStack = new NavPathStack()
  private insets: UiInsets = UiInsets.getInstance()
  private backController: RecordBackController = new RecordBackController()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  // 路由名（onReady 读出），决定默认标签 = 原版 n3(true,page) 的 page
  @Local routeName: string = 'bookmarks'
  // 原版 v://bookmarks 深链的文件夹定位参数（cb.e0.T3 预置）
  private pendingFolderId: number = 0
  private pendingFolderName: string = ''
  // TabLayout 当前选中索引（原版 TabLayout.f4281o）
  @Local currentIndex: number = 0

  // 原版 z.java 返回键：contentDescription「向上导航」，点击 = 容器返回
  private handleBack(): void {
    if (this.backController.handle()) {
      return
    }
    this.navPathStack.pop()
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        // ===== 顶栏 z + TabLayout（bb/i.a3 1:1）=====
        Column() {
          Row() {
            Stack({ alignContent: Alignment.Center }) {
              // 原版返回键 drawable b2（x7.o.f13759r），沿用工程同语义返回图标
              AppIcon({ icon: $r('app.media.uia_ic_back'), iconSize: 22, iconColor: $r('app.color.appbar_icon') })
            }
              .width(48)
              .height(52)
              .padding({ left: 13, right: 13 })
              .margin({ top: 1, bottom: 1 })
              .onClick(() => {
                this.handleBack()
              })
            Blank()
              .layoutWeight(1)
          }
          .width('100%')
          .height(54)
          Divider()
            .vertical(false)
            .strokeWidth(1)
            .color($r('app.color.appbar_divider'))

          // ===== TabLayout（指示器透明 bb/i.f3:141；文字三态 TabLayout.m()）=====
          Row() {
            ForEach(RECORD_TABS, (tab: RecordTabSpec, idx: number) => {
              Text(tab.label)
                .fontSize(14)
                // selected 全不透明 / 未选中 α150 半透明（textColorPrimary 同色）
                .fontColor(idx === this.currentIndex ? $r('app.color.fg') : $r('app.color.fg_tab'))
                // sans-serif-medium（非加粗，TabLayout 构造 291-292）
                .fontWeight(FontWeight.Medium)
                .maxLines(1)
                // tab 左右 padding 12dp（f4292z=12）；宽自适应（E=false）
                .padding({ left: 12, right: 12, top: 10, bottom: 10 })
                .onClick(() => {
                  // 原版 TabLayout.b onClick：setCurrentItem(target)（159-171）
                  this.currentIndex = idx
                })
            }, (tab: RecordTabSpec) => `tab${tab.page}`)
          }
          .width('100%')
          .height(44)
          .padding({ bottom: 2 })
          Divider()
            .vertical(false)
            .strokeWidth(1)
            .color($r('app.color.appbar_divider'))
        }
        .width('100%')
        .backgroundColor($r('app.color.page_bg'))

        // ===== ViewPager2（bb/i.d FragmentStateAdapter，可横滑）=====
        Tabs({ index: this.pageToIndex(this.defaultPageOfRoute(this.routeName)), controller: this.tabsController }) {
          TabContent() {
            BookmarkPage({
              backController: this.backController,
              onRequestPop: (): void => {
                this.navPathStack.pop()
              }
            })
          }
          TabContent() {
            HistoryPage({
              backController: this.backController,
              onRequestPop: (): void => {
                this.navPathStack.pop()
              }
            })
          }
          TabContent() {
            OfflinePage({
              backController: this.backController,
              onRequestPop: (): void => {
                this.navPathStack.pop()
              }
            })
          }
        }
        .scrollable(true)
        .animationDuration(0)
        .barHeight(0)
        .onChange((index: number) => {
          // 原版 TabLayout.d.c()：ViewPager 落定页 → 文字选中态
          this.currentIndex = index
        })
        .layoutWeight(1)
        .width('100%')
      }
      .width('100%')
      .height('100%')
      .backgroundColor($r('app.color.page_bg'))
    }
    .hideTitleBar(true)
    .backgroundColor($r('app.color.page_bg'))
    .translate({ x: this.slideOffset })
    .customTransition((operation: NavigationOperation, isEnter: boolean):
      Array<NavDestinationTransition> | undefined => {
      return buildNavSlide(operation, isEnter, (value: string): void => {
        this.slideOffset = value
      })
    })
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.routeName = ctx.name
      this.pendingFolderId = 0
      this.pendingFolderName = ''
    })
    .onShown(() => {
      // deep link 参数（v://bookmarks?folder=）：BookmarkPage 挂载后透传（cb.e0.T3）
      if (this.pendingFolderId > 0) {
        this.bookmarkPage?.applyFolderParam(this.pendingFolderId, this.pendingFolderName)
        this.pendingFolderId = 0
      }
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
    .onBackPressed(() => {
      // o8\h.V2 + bb\i.k3：当前子页已消费返回（多选/搜索/文件夹层级）则不弹容器
      return !this.backController.handle()
    })
  }

  private pageToIndex(page: number): number {
    if (page === 2) {
      return 1
    }
    if (page === 3) {
      return 2
    }
    return 0
  }

  private defaultPageOfRoute(route: string): number {
    return defaultPageOfRoute(route)
  }
}

// 三路由共用（router_map name → 默认标签由 onReady 的 ctx.name 决定）
@Builder
export function BookmarkPageBuilder() {
  RecordContainerPage()
}

@Builder
export function HistoryPageBuilder() {
  RecordContainerPage()
}

@Builder
export function OfflinePageBuilder() {
  RecordContainerPage()
}
