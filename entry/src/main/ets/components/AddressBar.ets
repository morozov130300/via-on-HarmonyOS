import { TabItem } from '../common/Types'
import { AppIcon } from './AppIcon'
import { hostOf } from '../common/SearchEngines'

@ComponentV2
export struct AddressBar {
  @Param @Require tab: TabItem
  @Event onAddressTap: () => void = () => {}
  @Event onOpenMedia: (urls: string[]) => void = (urls: string[]) => {
  }

  build() {
    Row({ space: 6 }) {
      if (this.tab.url.startsWith('https://')) {
        AppIcon({ icon: $r('sys.symbol.lock'), iconSize: 14, iconColor: $r('app.color.fg_secondary') })
      } else {
        AppIcon({ icon: $r('sys.symbol.link'), iconSize: 14, iconColor: $r('app.color.fg_secondary') })
      }
      Text(hostOf(this.tab.url))
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .layoutWeight(1)
      if (this.tab.adCount > 0) {
        AppIcon({ icon: $r('sys.symbol.checkmark_shield'), iconSize: 14, iconColor: $r('app.color.accent') })
      }
      if (this.tab.sniffedMedia.length > 0) {
        AppIcon({ icon: $r('app.media.via_ic_download'), iconSize: 16, iconColor: $r('app.color.accent') })
          .onClick(() => {
            this.onOpenMedia(this.tab.sniffedMedia)
          })
      }
    }
    .height(40)
    .padding({ left: 14, right: 14 })
    .backgroundColor($r('app.color.surface'))
    .borderRadius(20)
    .margin({ left: 12, right: 12, top: 8 })
    .onClick(() => {
      this.onAddressTap()
    })
  }
}
