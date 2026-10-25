import { webview } from '@kit.ArkWeb'
import { fileIo } from '@kit.CoreFileKit'
import { request } from '@kit.BasicServicesKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { BrowserDb } from './Database'
import { AppSettings } from './Settings'
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

  private fileNameFromUrl(url: string): string {
    const queryStart = url.indexOf('?')
    const base = queryStart >= 0 ? url.substring(0, queryStart) : url
    const slash = base.lastIndexOf('/')
    let name = slash >= 0 ? base.substring(slash + 1) : ''
    name = name.replace(/[\\/:*?"<>|]/g, '_')
    if (name.length > 100) {
      name = name.substring(name.length - 100)
    }
    if (name === '') {
      return `download_${Date.now()}`
    }
    return name
  }

  async startUrlDownload(context: Context, url: string): Promise<void> {
    if (this.saveDir === '') {
      return
    }
    const path = `${this.saveDir}/${this.fileNameFromUrl(url)}`
    const rec = new DownloadRec()
    rec.url = url
    rec.path = path
    rec.mime = ''
    rec.size = 0
    rec.received = 0
    rec.status = DownloadStatus.Running
    rec.created = Date.now()
    const id = await this.db.insertDownload(rec)
    request.downloadFile(context, { url: url, filePath: path })
      .then((task: request.DownloadTask) => {
        task.on('complete', () => {
          this.db.updateDownload(id, 0, DownloadStatus.Completed).catch(() => {
          })
          this.copyToUserDir(path)
        })
        task.on('fail', () => {
          this.db.updateDownload(id, 0, DownloadStatus.Failed).catch(() => {
          })
        })
      })
      .catch((error: BusinessError) => {
        console.error(`start url download failed: ${error.message}`)
        this.db.updateDownload(id, 0, DownloadStatus.Failed).catch(() => {
        })
      })
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

  private copyToUserDir(sandboxPath: string): void {
    const dir = AppSettings.getInstance().downloadDir
    if (dir === '' || sandboxPath === '') {
      return
    }
    try {
      const slash = sandboxPath.lastIndexOf('/')
      const name = slash >= 0 ? sandboxPath.substring(slash + 1) : ''
      if (name === '') {
        return
      }
      const destUri = dir.endsWith('/') ? `${dir}${name}` : `${dir}/${name}`
      const src = fileIo.openSync(sandboxPath, fileIo.OpenMode.READ_ONLY)
      const dst = fileIo.openSync(destUri, fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE | fileIo.OpenMode.TRUNC)
      fileIo.copyFileSync(src.fd, dst.fd)
      fileIo.closeSync(src)
      fileIo.closeSync(dst)
    } catch (error) {
      console.error('copy download to user dir failed')
    }
  }

  private handleFinish(item: webview.WebDownloadItem): void {
    const id = this.activeIds.get(item.getGuid())
    if (id === undefined) {
      return
    }
    this.activeIds.delete(item.getGuid())
    this.lastWrittenPercent.delete(item.getGuid())
    this.copyToUserDir(`${this.saveDir}/${this.fileNameFor(item)}`)
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
