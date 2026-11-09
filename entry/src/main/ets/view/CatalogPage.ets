import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'
import { TabStore } from '../common/TabStore'

// 原版 u9/c.f()（154-172）+ u9/c.e()（140-152）+ u9/d.b()（57-74）的站点目录页：
// v:// 未知命令 → z8/b0.Q()（c8/k6.java:8674）返回 id5 → u9/d.java:129 catalog.html。
//
// catalog.html 由 u9/c.f() 生成：
//   d.h(getString(u.f13958e1))                        → <head> 标题
//   d.j(d.g(context, 1))                              → 内联 CSS
//   <body><div class='frosted-glass' id='gesture-indicator'></div><div id="content">
//   逐条 d.b(bVar.g(), bVar.e(), "tag")               → 6 个入口
//   </div></body></html>
// u9/d.b（57-74）每条输出：
//   <div class="box"><div class="icon_handle"><div class="tag icon"></div></div>
//     <a href="v://xxx" title="名称"></a><p class="title">名称</p></div>
// 注意 "tag icon" 是**纯 CSS 绘制的同一个标签字形**（不是每项一个不同图标），
// 6 项只有名称与 href 不同 —— 见 u9/d.g(context,1) 的 .tag.icon 规则。
//
// 6 个入口的名称与命令（u9/c.e 的数组顺序固定，与 catalog.html 完全一致；
// 名称按资源解码链 sources/x7/u.java 十进制 → 0x 十六进制 → public.xml → strings.xml）：
//   f14026j  2131755017 → 0x7f100009 → string "j"  → values-zh-rCN/strings.xml:12  = 书签      → v://bookmarks
//   H        2131755041 → 0x7f100021 → string "a7" → values-zh-rCN/strings.xml:36  = 历史      → v://history
//   E8       2131755559 → 0x7f100227 → string "o3" → values-zh-rCN/strings.xml:547 = 网络日志  → v://log
//   f13929c0 2131755062 → 0x7f100036 → string "as" → values-zh-rCN/strings.xml:57  = 离线页面  → v://offline
//   f14144r6 2131755431 → 0x7f1001a7 → string "km" → values-zh-rCN/strings.xml:420 = 主页      → v://home
//   f14109oc 2131755762 → 0x7f1002f2 → string "tk" → values-zh-rCN/strings.xml:749 = 关于      → v://about
// 页面标题 = u.f13958e1 = 0x7f100072 → string "ce" → values-zh-rCN/strings.xml:116 = Via
class CatalogEntry {
  label: string
  cmd: string
  // 点击后落到的本端 NavDestination 路由名（空串表示「回主页」动作，不压栈）
  route: string

  constructor(label: string, cmd: string, route: string) {
    this.label = label
    this.cmd = cmd
    this.route = route
  }
}

const CATALOG_ENTRIES: CatalogEntry[] = [
  // k6.u 8657 v://bookmarks → 书签页（aa/X9/s1 分支的本端等价路由）
  new CatalogEntry('书签', 'v://bookmarks', 'bookmarks'),
  // k6.u 8641 v://history → 历史页（fa()）
  new CatalogEntry('历史', 'v://history', 'history'),
  // z8/b0.Q "log" → s1(6) → log.html（本端 netLog）
  new CatalogEntry('网络日志', 'v://log', 'netLog'),
  // z8/b0.Q "offline" → s1(7) → save.html（本端 offlinePage）
  new CatalogEntry('离线页面', 'v://offline', 'offlinePage'),
  // z8/b0.Q "home" → V0()：回主页（动作，不入路由栈）
  new CatalogEntry('主页', 'v://home', ''),
  // z8/b0.Q "about" → s1(4) → about.html（本端 settingsAbout）
  new CatalogEntry('关于', 'v://about', 'settingsAbout')
]

// u9/d.g(context,1) 的 .tag.icon 是 CSS 手绘的**标签字形**（7x7 方块 +
// ::before 旋转 45° 的折角），与具体条目无关 —— catalog.html 的 6 项共用同一个字形。
// 此处用 Path 复刻该标签轮廓：矩形 + 左侧尖角（标签挂孔朝向）。
const TAG_GLYPH: string = 'M4 1 L11 1 L11 11 L4 11 L1 6 Z'

@ComponentV2
export struct CatalogPage {
  private navPathStack: NavPathStack = new NavPathStack()
  private tabStore: TabStore = TabStore.getInstance()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'

  private bindAppBar(): void {
    AppBar.show({
      title: 'Uia',
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
            ForEach(CATALOG_ENTRIES, (entry: CatalogEntry) => {
              this.CatalogRow(entry)
            }, (entry: CatalogEntry) => entry.cmd)
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
    .hideTitleBar(true)
    .translate({ x: this.slideOffset })
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
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  // 原版 u9/d.b(名称, href, "tag")，样式取 u9/d.g(context, 1)（i10==1 分支）：
  //   #content { text-align: left }
  //   .box     { display:block; padding: 20px 14px; border-bottom: 0 }
  //   .title   { padding-left: 28px; font-size: 15px; color: str4;
  //              white-space: nowrap; overflow: hidden; text-overflow: ellipsis }
  //   .tag.icon{ color: str6; position:absolute; margin-left:3px; margin-top:5px;
  //              width:7px; height:7px; border-radius:1px 1px 1px 0;
  //              border-left:solid 1px; border-top:solid 1px }
  // str4 = 夜间 #fafafa / 白天 #1b1b1b（正文），str6 = 夜间 #e9e9e9 / 白天 #313131（图标）。
  @Builder
  CatalogRow(entry: CatalogEntry) {
    Row() {
      // 标签字形（.tag.icon）：margin-left 3dp、7x7dp 轮廓
      Path()
        .width(12)
        .height(12)
        .commands(TAG_GLYPH)
        .fill(Color.Transparent)
        .stroke($r('app.color.fg_tertiary'))
        .strokeWidth(1)
        .margin({ left: 3 })
      // .title：padding-left 28px 为绝对定位的图标让位
      Text(entry.label)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .layoutWeight(1)
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .margin({ left: 14 })
    }
    .width('100%')
    .padding({ left: 14, right: 14, top: 20, bottom: 20 })
    .onClick(() => {
      this.onEntryTap(entry)
    })
  }

  // 原版 catalog.html 的 <a href="v://xxx"> 点击 → WebView 再次进入 k6.u() 分发。
  // 本页已位于 NavDestination 栈顶，等价做法是把当前页**替换**成目标页（避免多压一层
  // 目录页）；"回主页" 是动作而非页面，直接 gotoHome 后 pop。
  private onEntryTap(entry: CatalogEntry): void {
    if (entry.route === '') {
      // z8/b0.Q "home" → k6.V0()：回主页
      this.tabStore.gotoHome()
      this.navPathStack.pop()
      return
    }
    this.navPathStack.replacePathByName(entry.route, '', true)
  }
}

@Builder
export function CatalogPageBuilder() {
  CatalogPage()
}
