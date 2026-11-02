import { DownloadRec, DownloadStatus } from '../common/Types'
import { BrowserDb } from '../common/Database'
import { DownloadCoordinator } from '../common/Downloads'
import { AppIcon } from '../components/AppIcon'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { filePreview } from '@kit.PreviewKit'
import { common } from '@kit.AbilityKit'

const DOWNLOAD_REFRESH_MS: number = 500

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
  private coordinator: DownloadCoordinator = DownloadCoordinator.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local items: DownloadRec[] = []
  private refreshTimer: number = -1

  aboutToAppear(): void {
    this.reload()
    this.startAutoRefresh()
  }

  aboutToDisappear(): void {
    this.stopAutoRefresh()
  }

  // 原版下载进度经系统通知栏实时更新；应用内页面以 500ms 轮询近似（mark/via/download/c）
  private startAutoRefresh(): void {
    if (this.refreshTimer >= 0) {
      return
    }
    this.refreshTimer = setInterval(() => {
      this.reload()
    }, DOWNLOAD_REFRESH_MS)
  }

  private stopAutoRefresh(): void {
    if (this.refreshTimer >= 0) {
      clearInterval(this.refreshTimer)
      this.refreshTimer = -1
    }
  }

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.downloads'),
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
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
                    Text(`${downloadStatusText(item.status)} ${downloadSizeText(item.received > 0 ? item.received : item.size)}`)
                      .fontSize(12)
                      .fontColor(item.status === DownloadStatus.Completed ? $r('app.color.fg_secondary') : $r('app.color.accent'))
                      .maxLines(1)
                    if (this.progressVisible(item)) {
                      Progress({ value: item.size > 0 ? Math.floor(item.received / item.size * 100) : 0, total: 100,
                        type: ProgressType.Linear })
                        .width('100%')
                        .height(3)
                        .color($r('app.color.accent'))
                        .backgroundColor($r('app.color.surface'))
                    }
                  }
                  .layoutWeight(1)
                  .alignItems(HorizontalAlign.Start)
                  this.ActionIcons(item)
                }
                .width('100%')
                .padding({ left: 16, right: 16, top: 8, bottom: 8 })
                .onClick(() => {
                  // 原版点击已完成任务打开文件
                  if (item.status === DownloadStatus.Completed) {
                    this.openFile(item)
                  }
                })
              }
            }, (item: DownloadRec) => `${item.id}_${item.status}_${item.received}`)
          }
          .width('100%')
          .layoutWeight(1)
          .divider({ strokeWidth: 0.5, color: $r('app.color.divider') })
          .scrollBar(BarState.Off)

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
      this.startAutoRefresh()
    })
    .onHidden(() => {
      this.stopAutoRefresh()
    })
    .onWillDisappear(() => {
      this.stopAutoRefresh()
      AppBar.maybeHide(this)
    })
  }

  // 原版下载状态机（mark/via/download/c）：下载中→暂停/取消；已暂停→继续/取消；失败/取消→重新下载
  @Builder
  ActionIcons(item: DownloadRec) {
    Row({ space: 14 }) {
      if (item.status === DownloadStatus.Running) {
        Text($r('app.string.pause_download'))
          .fontSize(13)
          .fontColor($r('app.color.accent'))
          .onClick(() => {
            this.coordinator.pauseDownload(item)
          })
        Text($r('app.string.cancel'))
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .onClick(() => {
            this.coordinator.cancelDownload(item)
          })
      } else if (item.status === DownloadStatus.Paused) {
        Text($r('app.string.resume_download'))
          .fontSize(13)
          .fontColor($r('app.color.accent'))
          .onClick(() => {
            this.coordinator.resumeDownload(item)
          })
        Text($r('app.string.cancel'))
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .onClick(() => {
            this.coordinator.cancelDownload(item)
          })
      } else if (item.status === DownloadStatus.Failed || item.status === DownloadStatus.Canceled) {
        Text($r('app.string.retry_download'))
          .fontSize(13)
          .fontColor($r('app.color.accent'))
          .onClick(() => {
            this.coordinator.retryDownload(item)
          })
      }
      AppIcon({ icon: $r('sys.symbol.trash'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
        .onClick(() => {
          this.db.deleteDownload(item.id).then(() => {
            this.reload()
          }).catch((error: BusinessError) => {
            console.error(`delete download failed: ${error.message}`)
          })
        })
    }
  }

  private progressVisible(item: DownloadRec): boolean {
    return item.status === DownloadStatus.Running || item.status === DownloadStatus.Paused
  }

  private openFile(item: DownloadRec): void {
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    const info: filePreview.PreviewInfo = {
      title: this.baseName(item.path),
      uri: `file://${item.path}`,
      mimeType: item.mime
    }
    filePreview.openPreview(context, info).catch((error: BusinessError) => {
      console.error(`open preview failed: ${error.code} ${error.message}`)
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
