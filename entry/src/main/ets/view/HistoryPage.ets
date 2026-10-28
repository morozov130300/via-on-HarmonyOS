import { HistoryRec } from '../common/Types'
import { BrowserDb } from '../common/Database'
import { TabStore } from '../common/TabStore'
import { AppIcon } from '../components/AppIcon'
import { SettingsHeader } from '../components/SettingsHeader'

@ComponentV2
export struct HistoryPage {
  private db: BrowserDb = BrowserDb.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local items: HistoryRec[] = []

  aboutToAppear(): void {
    this.reload()
  }

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: $r('app.string.history'),
          onBack: () => {
            this.navPathStack.pop()
          }
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
            ForEach(this.items, (item: HistoryRec) => {
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
            }, (item: HistoryRec) => item.id.toString())
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
              this.db.clearHistory().then(() => {
                this.reload()
              }).catch((error: BusinessError) => {
                console.error(`clear history failed: ${error.message}`)
              })
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
