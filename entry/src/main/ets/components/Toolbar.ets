import { TabItem } from '../common/Types'
import { TabStore } from '../common/TabStore'
import { AppSettings } from '../common/Settings'
import { ViaIcon } from './ViaIcon'

@ComponentV2
export struct Toolbar {
  @Param @Require tab: TabItem
  @Event onBack: () => void = () => {}
  @Event onForward: () => void = () => {}
  @Event onHome: () => void = () => {}
  @Event onTabs: () => void = () => {}
  @Event onMenu: () => void = () => {}
  private tabStore: TabStore = TabStore.getInstance()
  private settings: AppSettings = AppSettings.getInstance()
  private swipeOffset: number = 0

  private toolbarBg(): ResourceColor {
    if (this.tab.isHomePage() && this.settings.homeBgColor !== '') {
      return this.settings.homeBgColor
    }
    return $r('app.color.home_bg')
  }

  build() {
    Row() {
      if (!this.hidden('back')) {
        this.ToolButton($r('app.media.via_ic_back'), this.tab.canBack, () => {
          this.onBack()
        })
      }
      if (!this.hidden('forward')) {
        this.ToolButton($r('app.media.via_ic_forward'), this.tab.canForward, () => {
          this.onForward()
        })
      }
      if (!this.hidden('home')) {
        this.ToolButton($r('app.media.via_ic_home'), true, () => {
          this.onHome()
        })
      }
      // 视频同款：多标签按钮为圆角方框内嵌标签数
      Column() {
        Column() {
          Text(String(this.tabStore.tabs.length))
            .fontSize(12)
            .fontColor($r('app.color.icon'))
            .maxLines(1)
        }
        .width(22)
        .height(22)
        .borderRadius(6)
        .border({ width: 1.5, color: $r('app.color.icon') })
        .justifyContent(FlexAlign.Center)
        .alignItems(HorizontalAlign.Center)
      }
      .layoutWeight(1)
      .height('100%')
      .justifyContent(FlexAlign.Center)
      .alignItems(HorizontalAlign.Center)
      .onClick(() => {
        this.onTabs()
      })

      this.ToolButton($r('app.media.via_ic_menu'), true, () => {
        this.onMenu()
      })
    }
    .width('100%')
    .height(38)
    .backgroundColor(this.toolbarBg())
    .alignItems(VerticalAlign.Center)
    .gesture(PanGesture({ fingers: 1, direction: PanDirection.Horizontal, distance: 40 })
      .onActionUpdate((event: GestureEvent) => {
        this.swipeOffset = event.offsetX
      })
      .onActionEnd(() => {
        if (this.swipeOffset < -40) {
          this.tabStore.stepTab(1)
        } else if (this.swipeOffset > 40) {
          this.tabStore.stepTab(-1)
        }
        this.swipeOffset = 0
      }))
  }

  private hidden(id: string): boolean {
    return this.settings.toolbarHidden.indexOf(id) >= 0
  }

  @Builder
  ToolButton(icon: Resource, enabled: boolean, action: () => void) {
    Column() {
      ViaIcon({ icon: icon, iconSize: 22, iconColor: $r('app.color.icon') })
    }
    .layoutWeight(1)
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .alignItems(HorizontalAlign.Center)
    .opacity(enabled ? 1 : 0.3)
    .onClick(() => {
      if (enabled) {
        action()
      }
    })
  }
}
