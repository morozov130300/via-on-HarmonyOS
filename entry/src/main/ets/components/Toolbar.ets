import { TabItem } from '../common/Types'
import { TabStore } from '../common/TabStore'
import { AppIcon } from './AppIcon'

@ComponentV2
export struct Toolbar {
  @Param @Require tab: TabItem
  @Event onBack: () => void = () => {}
  @Event onForward: () => void = () => {}
  @Event onTabs: () => void = () => {}
  @Event onMenu: () => void = () => {}
  private tabStore: TabStore = TabStore.getInstance()
  private swipeOffset: number = 0

  build() {
    Row() {
      Blank()
      this.NavButton($r('sys.symbol.chevron_left'), this.tab.canBack, () => {
        this.onBack()
      })
      Blank()
      this.NavButton($r('sys.symbol.chevron_right'), this.tab.canForward, () => {
        this.onForward()
      })
      Blank()
      Stack({ alignContent: Alignment.TopEnd }) {
        AppIcon({ icon: $r('sys.symbol.square_on_square_fill'), iconSize: 22 })
        if (this.tabStore.tabs.length > 1) {
          Text(String(this.tabStore.tabs.length))
            .fontSize(9)
            .fontColor(Color.White)
            .backgroundColor($r('app.color.accent'))
            .borderRadius(8)
            .width(16)
            .height(16)
            .textAlign(TextAlign.Center)
        }
      }
      .onClick(() => {
        this.onTabs()
      })
      Blank()
      AppIcon({ icon: $r('sys.symbol.ellipsis_circle'), iconSize: 22 })
        .onClick(() => {
          this.onMenu()
        })
      Blank()
    }
    .width('100%')
    .height(48)
    .padding({ left: 8, right: 8 })
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
  NavButton(icon: Resource, enabled: boolean, action: () => void) {
    AppIcon({ icon: icon, iconSize: 22 })
      .opacity(enabled ? 1 : 0.3)
      .onClick(() => {
        if (enabled) {
          action()
        }
      })
  }
}
