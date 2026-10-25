import { BookmarkRec } from '../common/Types'
import { BrowserDb } from '../common/Database'
import { TabStore } from '../common/TabStore'
import { ViaIcon } from '../components/ViaIcon'
import { AppIcon } from '../components/AppIcon'

@ComponentV2
export struct BookmarkPage {
  private db: BrowserDb = BrowserDb.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local items: BookmarkRec[] = []
  @Local query: string = ''
  @Local editing: BookmarkRec | null = null
  @Local editMode: boolean = false

  aboutToAppear(): void {
    this.reload()
  }

  build() {
    NavDestination() {
      Column() {
        this.HeaderBar()
        this.SearchField()
        List({ space: 0 }) {
          ForEach(this.filteredItems(), (item: BookmarkRec) => {
            ListItem() {
              Row({ space: 12 }) {
                Text(this.shortLabel(item.title, item.url))
                  .fontSize(16)
                  .fontColor(Color.White)
                  .width(38)
                  .height(38)
                  .textAlign(TextAlign.Center)
                  .borderRadius(19)
                  .backgroundColor('#646986')
                Text(item.title !== '' ? item.title : item.url)
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
                  .layoutWeight(1)
                if (this.editMode) {
                  AppIcon({ icon: $r('sys.symbol.pencil_line'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
                    .onClick(() => {
                      this.editing = item
                    })
                  AppIcon({ icon: $r('sys.symbol.trash'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
                    .onClick(() => {
                      this.db.deleteBookmark(item.id).then(() => {
                        this.reload()
                      }).catch((error: BusinessError) => {
                        console.error(`delete bookmark failed: ${error.message}`)
                      })
                    })
                }
              }
              .width('100%')
              .height(43)
              .padding({ left: 14, right: 14 })
              .onClick(() => {
                if (this.editMode) {
                  this.editing = item
                } else {
                  this.tabStore.navigate(item.url)
                  this.navPathStack.pop()
                }
              })
            }
          }, (item: BookmarkRec) => `${item.id}_${item.title}`)
        }
        .width('100%')
        .layoutWeight(1)
        .divider({ strokeWidth: 0.5, color: $r('app.color.divider') })
        .onItemDragStart((event: ItemDragInfo, index: number) => {
          return this.dragItemBuilder(this.filteredItems()[index])
        })
        .onItemDrop((event: ItemDragInfo, itemIndex: number, insertIndex: number, isSuccess: boolean) => {
          if (!isSuccess || insertIndex < 0 || itemIndex === insertIndex) {
            return
          }
          this.moveItem(itemIndex, insertIndex)
        })

        this.BottomBar()
      }
      .width('100%')
      .height('100%')
      .backgroundColor($r('app.color.page_bg'))

      if (this.editing !== null) {
        BookmarkEditOverlay({
          bookmark: this.editing,
          onClose: () => {
            this.editing = null
          },
          onSaved: () => {
            this.editing = null
            this.reload()
          }
        })
      }
    }
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }

  @Builder
  HeaderBar() {
    Row() {
      ViaIcon({ icon: $r('app.media.via_ic_back'), iconSize: 22, iconColor: $r('app.color.fg') })
        .width(44)
        .height(43)
        .onClick(() => {
          this.navPathStack.pop()
        })

      Row() {
        Text($r('app.string.bookmarks'))
          .fontSize(15)
          .fontColor($r('app.color.fg'))
          .padding({ left: 10, right: 10, top: 10, bottom: 10 })
          .onClick(() => {
          })
        Text($r('app.string.history'))
          .fontSize(15)
          .fontColor($r('app.color.fg_secondary'))
          .padding({ left: 10, right: 10, top: 10, bottom: 10 })
          .onClick(() => {
            this.navPathStack.replacePathByName('history', '', true)
          })
        Text($r('app.string.offline_page'))
          .fontSize(15)
          .fontColor($r('app.color.fg_secondary'))
          .padding({ left: 10, right: 10, top: 10, bottom: 10 })
          .onClick(() => {
            this.navPathStack.pushPathByName('offlinePage', '', true)
          })
      }
      .layoutWeight(1)
      .justifyContent(FlexAlign.Center)
    }
    .width('100%')
    .height(43)
  }

  @Builder
  SearchField() {
    TextInput({ placeholder: $r('app.string.search') })
      .height(33)
      .fontSize(14)
      .placeholderFont({ size: 14 })
      .placeholderColor($r('app.color.fg_secondary'))
      .fontColor($r('app.color.fg'))
      .caretColor($r('app.color.accent'))
      .backgroundColor($r('app.color.surface'))
      .borderRadius(17)
      .margin({ left: 12, right: 12, top: 5, bottom: 5 })
      .onChange((value: string) => {
        this.query = value
      })
  }

  @Builder
  BottomBar() {
    Row() {
      Text($r('app.string.more'))
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .padding({ left: 14, right: 14, top: 8, bottom: 8 })
        .onClick(() => {
          this.getUIContext().getPromptAction().showToast({ message: $r('app.string.feature_wip'), duration: 1500 })
        })
      Blank()
      Text(this.editMode ? $r('app.string.done') : $r('app.string.edit'))
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .padding({ left: 14, right: 14, top: 8, bottom: 8 })
        .onClick(() => {
          this.editMode = !this.editMode
        })
    }
    .width('100%')
    .height(38)
    .backgroundColor($r('app.color.surface'))
  }

  @Builder
  dragItemBuilder(item: BookmarkRec) {
    Column() {
      Text(item.title)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
    }
    .width(200)
    .height(40)
    .padding({ left: 12, right: 12 })
    .justifyContent(FlexAlign.Center)
    .borderRadius(8)
    .backgroundColor($r('app.color.surface'))
  }

  private filteredItems(): BookmarkRec[] {
    const keyword = this.query.trim().toLowerCase()
    if (keyword === '') {
      return this.items
    }
    const result: BookmarkRec[] = []
    for (let i = 0; i < this.items.length; i++) {
      const item = this.items[i]
      if (item.title.toLowerCase().includes(keyword) || item.url.toLowerCase().includes(keyword)) {
        result.push(item)
      }
    }
    return result
  }

  private shortLabel(title: string, url: string): string {
    const source = title.trim() !== '' ? title : url
    if (source === '') {
      return '书'
    }
    return source.substring(0, 1)
  }

  private moveItem(from: number, to: number): void {
    const next: BookmarkRec[] = []
    for (let i = 0; i < this.items.length; i++) {
      next.push(this.items[i])
    }
    const moved = next[from]
    next.splice(from, 1)
    next.splice(to, 0, moved)
    this.items = next
    const ids: number[] = []
    for (let i = 0; i < next.length; i++) {
      ids.push(next[i].id)
    }
    this.db.reorderBookmarks(ids).catch((error: BusinessError) => {
      console.error(`reorder bookmarks failed: ${error.message}`)
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

@ComponentV2
struct BookmarkEditOverlay {
  @Param bookmark: BookmarkRec | null = null
  @Event onClose: () => void = () => {}
  @Event onSaved: () => void = () => {}
  @Local name: string = ''
  @Local address: string = ''
  private db: BrowserDb = BrowserDb.getInstance()

  aboutToAppear(): void {
    if (this.bookmark !== null) {
      this.name = this.bookmark.title
      this.address = this.bookmark.url
    }
  }

  build() {
    Column() {
      Column({ space: 16 }) {
        Text($r('app.string.edit_bookmark'))
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
        Column({ space: 8 }) {
          Text($r('app.string.name_label'))
            .fontSize(12)
            .fontColor($r('app.color.fg_secondary'))
          TextInput({ text: this.name })
            .height(40)
            .fontSize(14)
            .backgroundColor($r('app.color.surface'))
            .fontColor($r('app.color.fg'))
            .caretColor($r('app.color.accent'))
            .onChange((value: string) => {
              this.name = value
            })
          Text($r('app.string.address_label'))
            .fontSize(12)
            .fontColor($r('app.color.fg_secondary'))
          TextInput({ text: this.address })
            .height(40)
            .fontSize(14)
            .backgroundColor($r('app.color.surface'))
            .fontColor($r('app.color.fg'))
            .caretColor($r('app.color.accent'))
            .onChange((value: string) => {
              this.address = value
            })
        }
        .alignItems(HorizontalAlign.Start)
        Row({ space: 12 }) {
          Button($r('app.string.cancel'))
            .fontSize(14)
            .height(36)
            .layoutWeight(1)
            .backgroundColor($r('app.color.surface'))
            .fontColor($r('app.color.fg'))
            .onClick(() => {
              this.onClose()
            })
          Button($r('app.string.save'))
            .fontSize(14)
            .height(36)
            .layoutWeight(1)
            .backgroundColor($r('app.color.accent'))
            .fontColor(Color.White)
            .onClick(() => {
              this.save()
            })
        }
        .width('100%')
      }
      .width('80%')
      .padding(20)
      .borderRadius(16)
      .backgroundColor($r('app.color.page_bg'))
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .backgroundColor('rgba(0,0,0,0.5)')
    .onClick(() => {
      this.onClose()
    })
  }

  private save(): void {
    const name = this.name.trim()
    const address = this.address.trim()
    if (name === '' || address === '') {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.invalid_input'), duration: 1500 })
      return
    }
    const url = /^https?:\/\//i.test(address) ? address : `https://${address}`
    if (this.bookmark !== null) {
      this.db.updateBookmark(this.bookmark.id, name, url).then(() => {
        this.onSaved()
      }).catch((error: BusinessError) => {
        console.error(`update bookmark failed: ${error.message}`)
      })
    }
  }
}

@Builder
export function BookmarkPageBuilder() {
  BookmarkPage()
}
