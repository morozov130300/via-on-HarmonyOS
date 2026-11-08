import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'
import { emitter } from '@kit.BasicServicesKit'
import { ViaIcon } from '../components/ViaIcon'
import { VIA_CMD_EVENT_ID } from '../common/DeepLink'

// 原版 u9/c.f()（154-172）+ u9/c.e()（140-152）+ u9/d.b()（57-74）的目录页：
// v:// 未知命令 → z8/b0.Q()（c8/k6.java:8674）返回 id5 → u9/d.java:129 catalog.html。
// catalog.html 由 u9/c.f() 生成：标题取 u.f13958e1，正文把 6 个入口逐条写成
//   <div class="box"><div class="icon_handle"><div class="tag icon"></div></div>
//   <a href="v://xxx" title="名称"></a><p class="title">名称</p></div>
// 样式取 u9/d.g(context, 1) 的 #content / .box / .title 规则。
//
// 6 个入口名称与命令（u9/c.e 的数组顺序固定，与 catalog.html 完全一致；
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
  icon: Resource

  constructor(label: string, cmd: string, icon: Resource) {
    this.label = label
    this.cmd = cmd
    this.icon = icon
  }
}

const CATALOG_ENTRIES: CatalogEntry[] = [
  new CatalogEntry('书签', 'v://bookmarks', $r('app.media.via_ic_bookmark')),
  new CatalogEntry('历史', 'v://history', $r('app.media.via_ic_history')),
  new CatalogEntry('网络日志', 'v://log', $r('app.media.via_ic_netlog')),
  new CatalogEntry('离线页面', 'v://offline', $r('app.media.via_ic_offline')),
  new CatalogEntry('主页', 'v://home', $r('app.media.via_ic_home')),
  new CatalogEntry('关于', 'v://about', $r('app.media.via_ic_settings'))
]

@ComponentV2
export struct CatalogPage {
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'

  private bindAppBar(): void {
    AppBar.show({
      title: 'Via',
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

  // 原版 u9/d.b(名称, href, "tag")：手工内联图标（icon_handle > tag icon）+ 标题文字，
  // 对应 u9/d.g i10==1 分支的 CSS：
  //   .box { padding: 20px 14px; display:block }
  //   .title { padding-left: 28px; font-size: 15px; white-space:nowrap; ellipsis }
  //   #content { text-align: left }
  @Builder
  CatalogRow(entry: CatalogEntry) {
    Row({ space: 8 }) {
      ViaIcon({ icon: entry.icon, iconSize: 20, iconColor: $r('app.color.fg') })
      Text(entry.label)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .layoutWeight(1)
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
    }
    .width('100%')
    .padding({ left: 14, right: 14, top: 20, bottom: 20 })
    .onClick(() => {
      this.onEntryTap(entry)
    })
  }

  // 原版 catalog.html 的 <a href="v://xxx"> 点击 → WebView 再次进入 k6.u() 分发。
  // 鸿蒙侧等价路径：写回 via_internal_cmd 并触发 VIA_CMD_EVENT_ID，
  // 由 Index.handleInternalCmd()（同一 k6.u 分发器）消费。
  private onEntryTap(entry: CatalogEntry): void {
    AppStorage.setOrCreate('via_internal_cmd', entry.cmd)
    emitter.emit({ eventId: VIA_CMD_EVENT_ID }, { data: {} })
    this.navPathStack.pop()
  }
}

@Builder
export function CatalogPageBuilder() {
  CatalogPage()
}
