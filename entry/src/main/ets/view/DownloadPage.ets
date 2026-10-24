import { DownloadRec, DownloadStatus } from '../common/Types'
import { BrowserDb } from '../common/Database'
import { AppIcon } from '../components/AppIcon'

function downloadStatusText(status: DownloadStatus): string {
  if (status === DownloadStatus.Completed) {
    return '下载完成'
  }
  if (status === DownloadStatus.Failed) {
    return '下载失败'
  }
  if (status === DownloadStatus.Paused) {
    return '已暂停'
  }
  if (status === DownloadStatus.Canceled) {
    return '已取消'
  }
  return '下载中'
}

function downloadSizeText(size: number): string {
  if (size <= 0) {
    return ''
  }
  if (size < 1024) {
    return `${size} B`
  }
  if (size < 1024 * 1024) {
    return `${(size / 1024).toFixed(1)} KB`
  }
  return `${(size / 1024 / 1024).toFixed(1)} MB`
}

@ComponentV2
export struct DownloadPage {
  private db: BrowserDb = BrowserDb.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local items: DownloadRec[] = []

  aboutToAppear(): void {
    this.reload()
  }

  build() {
    NavDestination() {
      Column() {
        if (this.items.length === 0) {
          Column() {
            Text($r('app.string.empty_downloads'))
              .fontSize(14)
              .fontColor($r('app.color.fg_secondary'))
          }
          .width('100%')
          .layoutWeight(1)
          .justifyContent(FlexAlign.Center)
        } else {
          List({ space: 1 }) {
            ForEach(this.items, (item: DownloadRec) => {
              ListItem() {
                Row({ space: 12 }) {
                  AppIcon({ icon: $r('sys.symbol.doc_text'), iconSize: 20, iconColor: $r('app.color.fg_secondary') })
                  Column({ space: 2 }) {
                    Text(this.baseName(item.path))
                      .fontSize(15)
                      .fontColor($r('app.color.fg'))
                      .maxLines(1)
                      .textOverflow({ overflow: TextOverflow.Ellipsis })
                    Text(`${downloadStatusText(item.status)} ${downloadSizeText(item.size)}`)
                      .fontSize(12)
                      .fontColor(item.status === DownloadStatus.Completed ? $r('app.color.fg_secondary') : $r('app.color.accent'))
                      .maxLines(1)
                  }
                  .layoutWeight(1)
                  .alignItems(HorizontalAlign.Start)
                  AppIcon({ icon: $r('sys.symbol.trash'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
                    .onClick(() => {
                      this.db.deleteDownload(item.id).then(() => {
                        this.reload()
                      }).catch((error: BusinessError) => {
                        console.error(`delete download failed: ${error.message}`)
                      })
                    })
                }
                .width('100%')
                .height(56)
                .padding({ left: 16, right: 16 })
              }
            }, (item: DownloadRec) => item.id.toString())
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
              this.db.clearDownloads().then(() => {
                this.reload()
              }).catch((error: BusinessError) => {
                console.error(`clear downloads failed: ${error.message}`)
              })
            })
        }
      }
      .width('100%')
      .height('100%')
    }
    .title($r('app.string.downloads'))
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }

  private baseName(path: string): string {
    const index = path.lastIndexOf('/')
    if (index >= 0 && index < path.length - 1) {
      return path.substring(index + 1)
    }
    return path
  }

  private reload(): void {
    this.db.listDownloads().then((items: DownloadRec[]) => {
      this.items = items
    }).catch((error: BusinessError) => {
      console.error(`list downloads failed: ${error.message}`)
    })
  }
}

@Builder
export function DownloadPageBuilder() {
  DownloadPage()
}
