import { TabStore } from '../common/TabStore'
import { BrowserDb } from '../common/Database'
import { BookmarkRec } from '../common/Types'
import { hostOf } from '../common/SearchEngines'

const HOME_BOOKMARK_LIMIT: number = 8

@ComponentV2
export struct HomePage {
  private tabStore: TabStore = TabStore.getInstance()
  private db: BrowserDb = BrowserDb.getInstance()
  @Event onSearchTap: () => void = () => {}
  @Local bookmarks: BookmarkRec[] = []

  aboutToAppear(): void {
    this.db.listBookmarks().then((items: BookmarkRec[]) => {
      this.bookmarks = items
    }).catch((error: BusinessError) => {
      console.error(`list bookmarks failed: ${error.message}`)
    })
  }

  build() {
    Column() {
      Row() {
        Text($r('app.string.home_page'))
          .fontSize(16)
          .fontColor($r('app.color.home_title'))
          .maxLines(1)
      }
      .width('100%')
      .height(38)
      .justifyContent(FlexAlign.Center)
      .alignItems(VerticalAlign.Center)

      Blank()

      Column({ space: 10 }) {
        Image($rawfile('logo.svg'))
          .width(56)
          .height(56)
        Text($r('app.string.logo_slogan'))
          .fontSize(12)
          .fontColor($r('app.color.fg_secondary'))
      }

      Row() {
        Text($r('app.string.search'))
          .fontSize(15)
          .fontColor($r('app.color.search_pill_border'))
          .maxLines(1)
      }
      .height(38)
      .padding({ left: 40, right: 40 })
      .backgroundColor($r('app.color.search_pill_bg'))
      .borderRadius(19)
      .margin({ top: 24 })
      .justifyContent(FlexAlign.Center)
      .onClick(() => {
        this.onSearchTap()
      })

      if (this.bookmarks.length > 0) {
        Grid() {
          ForEach(this.bookmarks, (item: BookmarkRec) => {
            if (this.bookmarks.indexOf(item) < HOME_BOOKMARK_LIMIT) {
              GridItem() {
                Column({ space: 6 }) {
                  Text(this.shortLabel(item.title, item.url))
                    .fontSize(18)
                    .fontColor(Color.White)
                    .width(42)
                    .height(42)
                    .textAlign(TextAlign.Center)
                    .borderRadius(21)
                    .backgroundColor('#646986')
                  Text(item.title !== '' ? item.title : hostOf(item.url))
                    .fontSize(11)
                    .fontColor($r('app.color.fg_secondary'))
                    .maxLines(1)
                    .constraintSize({ maxWidth: 76 })
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                }
                .padding({ top: 4, bottom: 4 })
              }
              .onClick(() => {
                this.tabStore.navigate(item.url)
              })
            }
          }, (item: BookmarkRec) => `${item.id}_${item.title}`)
        }
        .columnsTemplate('1fr 1fr 1fr 1fr')
        .columnsGap(8)
        .rowsGap(10)
        .width('88%')
        .margin({ top: 28 })
        .height(this.bookmarks.length > 4 ? 130 : 68)
      }

      Blank()
    }
    .width('100%')
    .height('100%')
    .backgroundColor($r('app.color.home_bg'))
  }

  private shortLabel(title: string, url: string): string {
    const source = title.trim() !== '' ? title : hostOf(url)
    if (source === '') {
      return '书'
    }
    return source.substring(0, 1)
  }
}
