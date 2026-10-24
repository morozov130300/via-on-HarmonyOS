import { webview } from '@kit.ArkWeb'
import { fileIo } from '@kit.CoreFileKit'
import { BrowserDb } from './Database'
import { DownloadRec, DownloadStatus } from './Types'

export class DownloadCoordinator {
  private static instance: DownloadCoordinator | null = null
  private db: BrowserDb = BrowserDb.getInstance()
  private saveDir: string = ''
  private activeIds: Map<string, number> = new Map<string, number>()
  private lastWrittenPercent: Map<string, number> = new Map<string, number>()

  static getInstance(): DownloadCoordinator {
    if (DownloadCoordinator.instance === null) {
      DownloadCoordinator.instance = new DownloadCoordinator()
    }
    return DownloadCoordinator.instance
  }

  register(context: Context): void {
    if (this.saveDir !== '') {
      return
    }
    this.saveDir = `${context.filesDir}/Download`
    try {
      if (!fileIo.accessSync(this.saveDir)) {
        fileIo.mkdirSync(this.saveDir)
      }
    } catch (error) {
      console.error('create download dir failed')
    }
    const delegate: webview.WebDownloadDelegate = new webview.WebDownloadDelegate()
    delegate.onBeforeDownload((downloadItem: webview.WebDownloadItem) => {
      this.handleBefore(downloadItem)
    })
    delegate.onDownloadUpdated((downloadItem: webview.WebDownloadItem) => {
      this.handleUpdated(downloadItem)
    })
    delegate.onDownloadFinish((downloadItem: webview.WebDownloadItem) => {
      this.handleFinish(downloadItem)
    })
    delegate.onDownloadFailed((downloadItem: webview.WebDownloadItem) => {
      this.handleFailed(downloadItem)
    })
    webview.WebDownloadManager.setDownloadDelegate(delegate)
  }

  private fileNameFor(item: webview.WebDownloadItem): string {
    const name = item.getSuggestedFileName()
    if (name !== '') {
      return name
    }
    return `download_${Date.now()}`
  }

  private handleBefore(item: webview.WebDownloadItem): void {
    if (this.saveDir === '') {
      return
    }
    const path = `${this.saveDir}/${this.fileNameFor(item)}`
    item.start(path)
    const rec = new DownloadRec()
    rec.url = item.getUrl()
    rec.path = path
    rec.mime = item.getMimeType()
    rec.size = item.getTotalBytes()
    rec.received = 0
    rec.status = DownloadStatus.Running
    rec.created = Date.now()
    this.db.insertDownload(rec).then((id: number) => {
      this.activeIds.set(item.getGuid(), id)
    }).catch((error: BusinessError) => {
      console.error(`insert download failed: ${error.message}`)
    })
  }

  private handleUpdated(item: webview.WebDownloadItem): void {
    const id = this.activeIds.get(item.getGuid())
    if (id === undefined) {
      return
    }
    const percent = item.getPercentComplete()
    const last = this.lastWrittenPercent.get(item.getGuid())
    if (last !== undefined && percent - last < 10 && percent < 100) {
      return
    }
    this.lastWrittenPercent.set(item.getGuid(), percent)
    this.db.updateDownload(id, item.getReceivedBytes(), DownloadStatus.Running).catch((error: BusinessError) => {
      console.error(`update download failed: ${error.message}`)
    })
  }

  private handleFinish(item: webview.WebDownloadItem): void {
    const id = this.activeIds.get(item.getGuid())
    if (id === undefined) {
      return
    }
    this.activeIds.delete(item.getGuid())
    this.lastWrittenPercent.delete(item.getGuid())
    this.db.updateDownload(id, item.getReceivedBytes(), DownloadStatus.Completed).catch((error: BusinessError) => {
      console.error(`finish download failed: ${error.message}`)
    })
  }

  private handleFailed(item: webview.WebDownloadItem): void {
    const id = this.activeIds.get(item.getGuid())
    if (id === undefined) {
      return
    }
    this.activeIds.delete(item.getGuid())
    this.lastWrittenPercent.delete(item.getGuid())
    this.db.updateDownload(id, item.getReceivedBytes(), DownloadStatus.Failed).catch((error: BusinessError) => {
      console.error(`fail download failed: ${error.message}`)
    })
  }
}
