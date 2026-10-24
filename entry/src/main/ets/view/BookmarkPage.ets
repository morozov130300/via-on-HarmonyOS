import { BookmarkRec } from '../common/Types'
import { BrowserDb } from '../common/Database'
import { TabStore } from '../common/TabStore'
import { AppIcon } from '../components/AppIcon'

@ComponentV2
export struct BookmarkPage {
  private db: BrowserDb = BrowserDb.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local items: BookmarkRec[] = []

  aboutToAppear(): void {
    this.reload()
  }

  build() {
    NavDestination() {
      if (this.items.length === 0) {
        Column() {
          Text($r('app.string.empty_bookmarks'))
            .fontSize(14)
            .fontColor($r('app.color.fg_secondary'))
        }
        .width('100%')
        .height('100%')
        .justifyContent(FlexAlign.Center)
      } else {
        List({ space: 1 }) {
          ForEach(this.items, (item: BookmarkRec) => {
            ListItem() {
              Row({ space: 12 }) {
                AppIcon({ icon: $r('sys.symbol.bookmark'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
                Column({ space: 2 }) {
                  Text(item.title)
                    .fontSize(15)
                    .fontColor($r('app.color.fg'))
                    .maxLines(1)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                  Text(item.url)
                    .fontSize(12)
                    .fontColor($r('app.color.fg_secondary'))
                    .maxLines(1)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                }
                .layoutWeight(1)
                .alignItems(HorizontalAlign.Start)
                AppIcon({ icon: $r('sys.symbol.trash'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
                  .onClick(() => {
                    this.db.deleteBookmark(item.id).then(() => {
                      this.reload()
                    }).catch((error: BusinessError) => {
                      console.error(`delete bookmark failed: ${error.message}`)
                    })
                  })
              }
              .width('100%')
              .height(56)
              .padding({ left: 16, right: 16 })
              .onClick(() => {
                this.tabStore.navigate(item.url)
                this.navPathStack.pop()
              })
            }
          }, (item: BookmarkRec) => item.id.toString())
        }
        .width('100%')
        .height('100%')
        .divider({ strokeWidth: 0.5, color: $r('app.color.divider') })
      }
    }
    .title($r('app.string.bookmarks'))
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }

  private reload(): void {
    this.db.listBookmarks().then((items: BookmarkRec[]) => {
      this.items = items
    }).catch((error: BusinessError) => {
      console.error(`list bookmarks failed: ${error.message}`)
    })
  }
}

@Builder
export function BookmarkPageBuilder() {
  BookmarkPage()
}
