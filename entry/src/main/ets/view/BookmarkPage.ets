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
  @Local editing: BookmarkRec | null = null
  @Local adding: boolean = false

  aboutToAppear(): void {
    this.reload()
  }

  build() {
    NavDestination() {
      if (this.items.length === 0 && !this.adding) {
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
      if (this.editing !== null || this.adding) {
        BookmarkEditOverlay({
          bookmark: this.editing,
          onClose: () => {
            this.editing = null
            this.adding = false
          },
          onSaved: () => {
            this.editing = null
            this.adding = false
            this.reload()
          }
        })
      }
    }
    .title($r('app.string.bookmarks'))
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
    .menus(() => {
      this.AddMenu()
    })
  }

  @Builder
  AddMenu() {
    AppIcon({ icon: $r('sys.symbol.plus'), iconSize: 22 })
      .onClick(() => {
        this.adding = true
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
        Text(this.bookmark === null ? $r('app.string.add_bookmark') : $r('app.string.edit_bookmark'))
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
    if (this.bookmark === null) {
      this.db.addBookmark(name, url).then(() => {
        this.onSaved()
      }).catch((error: BusinessError) => {
        console.error(`add bookmark failed: ${error.message}`)
      })
    } else {
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
