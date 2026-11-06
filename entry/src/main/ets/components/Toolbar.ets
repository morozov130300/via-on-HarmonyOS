import { TabItem } from '../common/Types'
import { TabStore } from '../common/TabStore'
import { AppSettings } from '../common/Settings'
import { AddressBar } from './AddressBar'
import { curves } from '@kit.ArkUI'
import { ViaIcon } from './ViaIcon'

const BAR_HEIGHT: number = 48
// 原版 dimens a=13dp 内边距 → 88px(@4x)=22dp 图标本体
const ICON_SIZE: number = 22

@ComponentV2
export struct Toolbar {
  @Param @Require tab: TabItem
  // 原版 g0.f()/k()：地址栏内嵌进工具栏首槽（应用布局 1/2），否则独立成行（布局 0/3）
  @Param embedAddress: boolean = false
  @Event onOpenSearch: () => void = () => {}
  @Event onOpenBookmarks: () => void = () => {}
  @Event onOpenHistory: () => void = () => {}
  @Event onSiteInfoLong: () => void = () => {}
  @Event onBack: () => void = () => {}
  @Event onForward: () => void = () => {}
  @Event onHome: () => void = () => {}
  @Event onTabs: () => void = () => {}
  @Event onMenu: () => void = () => {}
  @Event onAddressTap: () => void = () => {}
  @Event onOpenMedia: (urls: string[]) => void = (urls: string[]) => {
  }
  // 原版 v4.b 动作中需要页面级能力的项，由 Index 统一分发
  @Event onCommand: (cmd: string) => void = (cmd: string) => {
  }
  private tabStore: TabStore = TabStore.getInstance()
  private settings: AppSettings = AppSettings.getInstance()
  @Local swipeOffset: number = 0
  // 原版 k6.B1：横滑预览方向（0 无 / -1 上一标签 / +1 下一标签），预览时标签图标 alpha 0.15（g0.l）
  @Local swipePreviewCur: number = -1
  private swipeDir: number = 0
  // 原版 DragContainer：拖拽距离 84dp，比例 |f10| > 0.8 触发（k6.W4）
  private swipeDistance: number = 84
  @Local barWidth: number = 0
  @Local bounceY: number = 0
  // 原版共用插值器 x8/h.b()：cubic-bezier(0.2,0.2,0.8,0.8)
  private bounceCurve = curves.cubicBezier(0.2, 0.2, 0.8, 0.8)

  private toolbarBg(): ResourceColor {
    if (this.tab.isHomePage() && this.settings.homeBgColor !== '') {
      // 原版夜间联动：自设背景色经黑滤镜后用于工具栏
      return this.settings.nightBlend(this.settings.homeBgColor)
    }
    return $r('app.color.home_bg')
  }

  // 原版 g0.m()：按宽度决定返回/前进是否显示及地址槽权重
  private wideBar(): boolean {
    if (!this.embedAddress) {
      return true
    }
    const w = this.barWidth
    if (w <= 0) {
      return false
    }
    const col = w < 420 ? w / 7 : w > 900 ? 72 : 60
    return w / (col <= 0 ? 6 : col) > 8
  }

  private addressWeight(): number {
    const w = this.barWidth
    if (w <= 0) {
      return 4
    }
    const col = w < 420 ? w / 7 : w > 900 ? 72 : 60
    const cols = w / (col <= 0 ? 6 : col)
    return Math.max(Math.round(cols - 3 - (cols > 8 ? 2 : 0)), 1)
  }

  private tabCountText(): string {
    const count = this.tabStore.tabs.length
    return count <= 99 ? String(count) : ':)'
  }

  // 原版 g0.l(cur, total)：cur>=0 时标签数显示 "%d/%d" 且标签图标 alpha 0.15；cur<0 恢复
  private swipePreviewText(): string {
    if (this.swipePreviewCur >= 0) {
      return `${this.swipePreviewCur}/${this.tabStore.tabs.length}`
    }
    return this.tabCountText()
  }

  // 原版 k6.W4 预览分支：|f10|>0.8 时按方向动作键映射 i10（10→-1，11→+1），
  // i11 = k()+1+i10（越下界取 total，越上界保持 1）
  private updateSwipePreview(fraction: number): void {
    let dir = 0
    if (Math.abs(fraction) > 0.8) {
      const key = fraction > 0 ? this.settings.gesturetoolbarleft : this.settings.gesturetoolbarright
      if (key === 10) {
        dir = -1
      } else if (key === 11) {
        dir = 1
      }
    }
    if (dir === this.swipeDir) {
      return
    }
    this.swipeDir = dir
    if (dir === 0) {
      this.swipePreviewCur = -1
      return
    }
    const total = this.tabStore.tabs.length
    const target = this.tabStore.currentIndex + 1 + dir
    if (target <= 0) {
      this.swipePreviewCur = total
    } else if (target <= total) {
      this.swipePreviewCur = target
    } else {
      this.swipePreviewCur = 1
    }
  }

  // 原版 hb/v4.b()：长按动作全集（v4.java:65-130）
  // 0=无 1=刷新 2=回顶部 3=到底部 4=输入网址 5=新建标签 6=添加书签 7=书签 8=历史
  // 9=关闭标签 10=上一标签 11=下一标签 12=网页后退 13=网页前进 14=页内查找 15=翻译
  // 16=关闭所有 17=上翻页 18=下翻页 19=保存网页 20=源码 23=标签面板 24=朗读
  // 25=阅读模式 26=设置 27=复制标签页 28=下载 29=AI 30=书签对话框
  private longPressAction(key: number): void {
    switch (key) {
      case 1:
        try {
          this.tab.controller.refresh()
        } catch (error) {
          console.error('long press refresh failed')
        }
        break
      case 2:
      case 3:
        try {
          const pos = key === 2 ? '0' : 'document.body.scrollHeight'
          this.tab.controller.runJavaScript(`window.scrollTo(0, ${pos})`)
        } catch (error) {
          console.error('long press scroll failed')
        }
        break
      case 4:
        this.onOpenSearch()
        break
      case 5:
        this.tabStore.newTab(false)
        break
      case 6:
        this.onCommand('addBookmark')
        break
      case 7:
      case 30:
        // 原版 k6.ra case30（k6.java:8353-8355）→ W9()：书签快捷选择对话框（a8.k，
        // 动作文案 hb/v4 case30 = pn「打开书签对话框」）——接书签管理页
        this.onOpenBookmarks()
        break
      case 8:
        this.onOpenHistory()
        break
      case 9:
        this.tabStore.closeTab(this.tabStore.currentIndex)
        break
      case 10:
        this.tabStore.stepTab(-1)
        break
      case 11:
        this.tabStore.stepTab(1)
        break
      case 12:
        this.onBack()
        break
      case 13:
        this.onForward()
        break
      case 14:
        this.onCommand('find')
        break
      case 15:
        this.onCommand('translate')
        break
      case 16:
        this.tabStore.closeAll()
        break
      case 17:
      case 18:
        try {
          const dir = key === 17 ? '-' : ''
          this.tab.controller.runJavaScript(`window.scrollBy(0, ${dir}window.innerHeight)`)
        } catch (error) {
          console.error('long press page scroll failed')
        }
        break
      case 19:
        this.onCommand('savePage')
        break
      case 20:
        this.onCommand('viewSource')
        break
      case 23:
        this.onTabs()
        break
      case 24:
        this.onCommand('tts')
        break
      case 25:
        this.onCommand('reader')
        break
      case 26:
        this.onCommand('settings')
        break
      case 27:
        this.tabStore.duplicateTab(this.tabStore.currentIndex)
        break
      case 28:
        this.onCommand('downloads')
        break
      case 29:
        this.onCommand('ai')
        break
      default:
        break
    }
  }

  private keyOf(button: string): number {
    if (button === 'back') {
      return this.settings.keyback
    }
    if (button === 'forward') {
      return this.settings.keyforward
    }
    if (button === 'home') {
      return this.settings.keyhome
    }
    if (button === 'tabs') {
      return this.settings.keytab
    }
    return this.settings.keymenu
  }

  build() {
    Row() {
      if (this.embedAddress) {
        Row() {
          AddressBar({
            tab: this.tab,
            style: 'plain',
            onAddressTap: () => {
              this.onAddressTap()
            },
            onOpenMedia: (urls: string[]) => {
              this.onOpenMedia(urls)
            },
            onReader: () => {
              this.onCommand('reader')
            }
          })
        }
        .layoutWeight(this.addressWeight())
        .height('100%')
        // 原版 g0.i()：地址槽 P(1,12) 左 12dp / L(1,0) 右 0
        .padding({ left: 12, right: 0 })
      }
      if (this.showNavButtons('back')) {
        this.ToolButton('back', $r('app.media.via_ic_back'), this.tab.canBack, () => {
          this.onBack()
        })
      }
      if (this.showNavButtons('forward')) {
        // 原版前进 = drawable/a3.xml：<rotate drawable=@drawable/b2 180°>
        this.ToolButton('forward', $r('app.media.via_ic_back'), this.tab.canForward, () => {
          this.onForward()
        }, 180)
      }
      if (!this.hidden('home')) {
        this.ToolButton('home', $r('app.media.via_ic_home'), true, () => {
          this.onHome()
        })
      }
      if (!this.hidden('tabs')) {
        // 原版 g0.h()：栈叠图标 + 加粗标签数叠加（>99 显示 :)）；隐身时 g0.l 置 alpha 0.15
        Stack() {
          ViaIcon({ icon: $r('app.media.via_ic_tabs'), iconSize: ICON_SIZE, iconColor: $r('app.color.accent') })
          Text(this.swipePreviewText())
            .fontSize(11)
            .fontWeight(FontWeight.Bold)
            .fontColor($r('app.color.accent'))
            .maxLines(1)
        }
        .layoutWeight(1)
        .height('100%')
        .alignContent(Alignment.Center)
        .opacity(this.tab.incognito || this.swipePreviewCur >= 0 ? 0.15 : 1)
        .onClick(() => {
          // 原版 g0.j()：点击整体 translationY 0→-0.3h→0，280ms bezier（分两段各 140ms）
          this.getUIContext().animateTo({ duration: 140, curve: this.bounceCurve }, () => {
            this.bounceY = -BAR_HEIGHT * 0.3
          })
          setTimeout(() => {
            this.getUIContext().animateTo({ duration: 140, curve: this.bounceCurve }, () => {
              this.bounceY = 0
            })
          }, 140)
          this.onTabs()
        })
        .gesture(LongPressGesture({ repeat: false, duration: 400 }).onAction(() => {
          this.longPressAction(this.keyOf('tabs'))
        }))
      }
      if (!this.hidden('menu')) {
        this.ToolButton('menu', $r('app.media.via_ic_menu'), true, () => {
          this.onMenu()
        })
      }
    }
    .width('100%')
    .height(BAR_HEIGHT)
    .backgroundColor(this.toolbarBg())
    .alignItems(VerticalAlign.Center)
    .translate({ y: this.bounceY })
    .onAreaChange((_old: Area, newArea: Area) => {
      this.barWidth = Number(newArea.width)
    })
    .gesture(PanGesture({ fingers: 1, direction: PanDirection.Horizontal, distance: 1 })
      .onActionUpdate((event: GestureEvent) => {
        this.swipeOffset = event.offsetX
        // 原版 k6.W4：f10 = 拖拽位移 / 84dp
        this.updateSwipePreview(px2vp(this.swipeOffset) / this.swipeDistance)
      })
      .onActionEnd(() => {
        // 原版 k6.W4 释放分支：|f10|>0.8 → ra(g2()/m1()) 执行方向动作键
        const fraction = px2vp(this.swipeOffset) / this.swipeDistance
        if (Math.abs(fraction) > 0.8) {
          this.longPressAction(fraction > 0 ? this.settings.gesturetoolbarleft : this.settings.gesturetoolbarright)
        }
        this.swipeOffset = 0
        this.updateSwipePreview(0)
      }))
  }

  // 原版 k()：地址栏未内嵌时返回/前进恒显；内嵌时仅宽屏显示
  private showNavButtons(id: string): boolean {
    if (this.hidden(id)) {
      return false
    }
    return !this.embedAddress || this.wideBar()
  }

  private hidden(id: string): boolean {
    return this.settings.toolbarHidden.indexOf(id) >= 0
  }

  @Builder
  ToolButton(id: string, icon: Resource, enabled: boolean, action: () => void, rotate: number = 0) {
    Column() {
      // 原版 g0.setAccentColor：五个工具栏图标全部着 accent 色
      ViaIcon({
        icon: icon,
        iconSize: ICON_SIZE,
        iconColor: $r('app.color.accent'),
        rotateDeg: rotate
      })
    }
    .layoutWeight(1)
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .alignItems(HorizontalAlign.Center)
    // 原版 g0.g()：图标 ImageView 无禁用态灰化，不可后退时仍为 accent 原色（k6 点击分支自行判断）
    .gesture(LongPressGesture({ repeat: false, duration: 400 }).onAction(() => {
      this.longPressAction(this.keyOf(id))
    }))
    .onClick(() => {
      if (enabled) {
        action()
      }
    })
    // 原版按钮背景 drawable q.xml：oval ripple，颜色 @color/l = #30808080
    // （ArkUI 无 oval ripple，用同色整块按压近似）
    .stateStyles({
      pressed: {
        .backgroundColor('#30808080')
      }
    })
  }
}
