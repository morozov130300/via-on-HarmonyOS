import { HistoryRec } from '../common/Types'
import { BrowserDb } from '../common/Database'
import { TabStore } from '../common/TabStore'
import { AppIcon } from '../components/AppIcon'
import { AppBar, AppBarSpacer } from '../components/AppBar'

@ComponentV2
export struct HistoryPage {
  private db: BrowserDb = BrowserDb.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local items: HistoryRec[] = []
  // 原版历史页搜索框（sz 搜索历史同款交互）
  @Local query: string = ''

  aboutToAppear(): void {
    this.reload()
  }

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.history'),
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
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
        if (this.items.length === 0) {
          Column() {
            Text($r('app.string.empty_history'))
              .fontSize(14)
              .fontColor($r('app.color.fg_secondary'))
          }
          .width('100%')
          .layoutWeight(1)
          .justifyContent(FlexAlign.Center)
        } else {
          List({ space: 1 }) {
            ForEach(this.filteredItems(), (item: HistoryRec) => {
              ListItem() {
                Row({ space: 12 }) {
                  AppIcon({ icon: $r('sys.symbol.clock'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
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
                      this.db.deleteHistory(item.id).then(() => {
                        this.reload()
                      }).catch((error: BusinessError) => {
                        console.error(`delete history failed: ${error.message}`)
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
            }, (item: HistoryRec) => `${item.id}_${item.title}`)
          }
          .width('100%')
          .layoutWeight(1)
          .divider({ strokeWidth: 0.5, color: $r('app.color.divider') })

          Button($r('app.string.clear_data'))
            .fontSize(14)
            .height(36)
            .width('92%')
            .margin({ top: 8, bottom: 12 })
            .backgroundColor($r('app.color.surface'))
            .fontColor($r('app.color.danger'))
            .onClick(() => {
              this.confirmClearHistory()
            })
        }
      }
      .width('100%')
      .height('100%')
    }
    .hideTitleBar(true)
    .backgroundColor($r('app.color.page_bg'))
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

  private filteredItems(): HistoryRec[] {
    const keyword = this.query.trim().toLowerCase()
    if (keyword === '') {
      return this.items
    }
    const result: HistoryRec[] = []
    for (let i = 0; i < this.items.length; i++) {
      const item = this.items[i]
      if (item.title.toLowerCase().includes(keyword) || item.url.toLowerCase().includes(keyword)) {
        result.push(item)
      }
    }
    return result
  }

  // 原版清除历史确认框：标题 fk「清除浏览历史」+ fm「你确定删除 %1$d 个条目吗?」
  private confirmClearHistory(): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    const message = context.resourceManager.getStringSync($r('app.string.delete_items_confirm').id, this.items.length)
    AlertDialog.show({
      title: $r('app.string.clear_history_title'),
      message: message,
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: $r('app.string.confirm'),
        action: () => {
          this.db.clearHistory().then(() => {
            this.reload()
          }).catch((error: BusinessError) => {
            console.error(`clear history failed: ${error.message}`)
          })
        }
      }
    })
  }

  private reload(): void {
    this.db.listHistory().then((items: HistoryRec[]) => {
      this.items = items
    }).catch((error: BusinessError) => {
      console.error(`list history failed: ${error.message}`)
    })
  }
}

@Builder
export function HistoryPageBuilder() {
  HistoryPage()
}
