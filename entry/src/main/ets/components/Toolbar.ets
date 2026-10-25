import { TabItem } from '../common/Types'
import { TabStore } from '../common/TabStore'
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
  private swipeOffset: number = 0

  build() {
    Row() {
      this.ToolButton($r('app.media.via_ic_back'), this.tab.canBack, () => {
        this.onBack()
      })
      this.ToolButton($r('app.media.via_ic_forward'), this.tab.canForward, () => {
        this.onForward()
      })
      this.ToolButton($r('app.media.via_ic_home'), true, () => {
        this.onHome()
      })
      Column() {
        Text(String(this.tabStore.tabs.length))
          .fontSize(16)
          .fontColor($r('app.color.icon'))
          .maxLines(1)
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
    .backgroundColor($r('app.color.home_bg'))
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
