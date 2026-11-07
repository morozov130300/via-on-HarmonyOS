import { AppSettings } from '../common/Settings'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'

// 原版 i8/w.j3()：长按菜单 14 项（顺序与文案逐项对齐，
// id 沿用 TabWeb 已消费的 open_new_tab/open_background/copy_link/share，
// 其余为图片/链接长按动作，见原版 a6.n(id, label) 列表）
class LongPressEntry {
  id: string
  label: string

  constructor(id: string, label: string) {
    this.id = id
    this.label = label
  }
}

const LONG_PRESS_ENTRIES: LongPressEntry[] = [
  new LongPressEntry('open_background', '后台打开'),
  new LongPressEntry('open_new_tab', '新标签打开'),
  new LongPressEntry('view_image', '查看图片'),
  new LongPressEntry('save_image', '保存图片'),
  new LongPressEntry('download_image', '下载图片'),
  new LongPressEntry('share_image', '分享图片'),
  new LongPressEntry('search_by_image', '以图搜图'),
  new LongPressEntry('picture_mode', '看图模式'),
  new LongPressEntry('page_info', '页面信息'),
  new LongPressEntry('mark_ad', '标记广告'),
  new LongPressEntry('copy_link_text', '复制链接文本'),
  new LongPressEntry('scan_qr', '扫描二维码'),
  new LongPressEntry('copy_link', '复制链接'),
  new LongPressEntry('share', '分享')
]

@ComponentV2
export struct SettingsLongPressPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'

  private bindAppBar(): void {
    AppBar.show({
      title: '定制长按菜单',
      // 原版 i8/w.a3()：AppBar 右上「重置」，弹确认框后恢复默认（仅隐藏 保存图片）
      rightText: '重置',
      onRight: () => {
        this.confirmReset()
      },
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
          ForEach(LONG_PRESS_ENTRIES, (entry: LongPressEntry) => {
            Row() {
              Text(entry.label)
                .fontSize(15)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
                .layoutWeight(1)
              Toggle({ type: ToggleType.Switch, isOn: !this.isHidden(entry.id) })
                .onChange((value: boolean) => {
                  this.setHidden(entry.id, !value)
                })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 13, bottom: 13 })
            .alignItems(VerticalAlign.Center)
          }, (entry: LongPressEntry) => entry.id)
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

  private isHidden(id: string): boolean {
    return this.settings.longPressHidden.indexOf(id) >= 0
  }

  private setHidden(id: string, hidden: boolean): void {
    const next: string[] = []
    for (let i = 0; i < this.settings.longPressHidden.length; i++) {
      if (this.settings.longPressHidden[i] !== id) {
        next.push(this.settings.longPressHidden[i])
      }
    }
    if (hidden) {
      next.push(id)
    }
    this.settings.setLongPressHidden(next)
  }

  // 原版 i8/w.a3()：「重置为默认设置」/「你确定继续吗？」→ U1(null) 恢复默认（仅隐藏 保存图片）
  private confirmReset(): void {
    this.getUIContext().showAlertDialog({
      title: '重置为默认设置',
      message: '你确定继续吗？',
      primaryButton: {
        value: '重置',
        action: () => {
          this.settings.setLongPressHidden(['save_image'])
        }
      },
      secondaryButton: {
        value: '取消',
        action: () => {
        }
      },
      cancel: () => {
      }
    })
  }
}

@Builder
export function SettingsLongPressPageBuilder() {
  SettingsLongPressPage()
}
