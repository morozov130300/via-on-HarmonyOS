import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'

// 原版 ra/i.java：键盘快捷键静态列表页（14 项，无交互）
// 行布局 r/f/a3.xml：横向居中、padH 16dp、padV 12dp、ripple 背景；
// 按键列加粗 14sp accent，说明列 14sp accent 右对齐
class ShortcutItem {
  key: string
  desc: string

  constructor(key: string, desc: string) {
    this.key = key
    this.desc = desc
  }
}

@ComponentV2
export struct KeyboardShortcutsPage {
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  // 原版 ra/i.X1 列表顺序与文案（x7.u.O/F9/E9/A9/B9/z9/p3/j/H/F/D9/M9/e0/c）
  private items: ShortcutItem[] = [
    new ShortcutItem('Ctrl + t', '新建标签'),
    new ShortcutItem('Ctrl + Tab', '下一个标签'),
    new ShortcutItem('Ctrl + Shift + Tab', '上一个标签'),
    new ShortcutItem('Alt + ←', '网页后退'),
    new ShortcutItem('Alt + →', '网页前进'),
    new ShortcutItem('Ctrl + w', '关闭标签'),
    new ShortcutItem('Alt + f', '菜单'),
    new ShortcutItem('Ctrl + Shift + b', '书签'),
    new ShortcutItem('Ctrl + h', '历史'),
    new ShortcutItem('Ctrl + f', '页内查找'),
    new ShortcutItem('Ctrl + l', '输入网址'),
    new ShortcutItem('F5 / Ctrl + r', '刷新网页'),
    new ShortcutItem('Ctrl + u', '源码'),
    new ShortcutItem('Ctrl + d', '添加书签')
  ]

  private bindAppBar(): void {
    AppBar.show({
      title: '键盘快捷键',
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
            ForEach(this.items, (item: ShortcutItem) => {
              Row() {
                Text(item.key)
                  .fontSize(14)
                  .fontWeight(FontWeight.Bold)
                  .fontColor($r('app.color.accent'))
                  .maxLines(1)
                Text(item.desc)
                  .fontSize(14)
                  .fontColor($r('app.color.accent'))
                  .maxLines(1)
                  .layoutWeight(1)
                  .textAlign(TextAlign.End)
              }
              .width('100%')
              .alignItems(VerticalAlign.Center)
              .padding({ left: 16, right: 16, top: 12, bottom: 12 })
            }, (item: ShortcutItem) => item.key)
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
}

@Builder
export function KeyboardShortcutsPageBuilder() {
  KeyboardShortcutsPage()
}
