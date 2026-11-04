import { webview } from '@kit.ArkWeb'
import { fileIo } from '@kit.CoreFileKit'
import { emitter, BusinessError } from '@kit.BasicServicesKit'
import { BrowserDb } from './Database'
import { AppSettings } from './Settings'
import { DownloadRec, DownloadStatus } from './Types'
import { DownloadEngine } from './DownloadEngine'
import { DownloadNotifier } from './DownloadNotifier'

// 原版 mark/via/download/m.java：下载前确认弹层（可编辑文件名 + 文件大小 + 取消/下载）
export const DOWNLOAD_CONFIRM_EVENT_ID: number = 10003

interface PendingWebDownload {
  item: webview.WebDownloadItem
  url: string
  fileName: string
  size: number
}

export class DownloadCoordinator {
  private static instance: DownloadCoordinator | null = null
  private db: BrowserDb = BrowserDb.getInstance()
  private saveDir: string = ''
  private activeIds: Map<string, number> = new Map<string, number>()
  private lastWrittenPercent: Map<string, number> = new Map<string, number>()
  // 确认前的暂存（原版 m.java 弹层期间不启动下载）
  private pendingWeb: Map<string, PendingWebDownload> = new Map<string, PendingWebDownload>()
  // 已启动的 Web 下载项，供暂停/继续/取消（原版 download/c 状态机）
  private runningItems: Map<string, webview.WebDownloadItem> = new Map<string, webview.WebDownloadItem>()
  private dbIdToGuid: Map<number, string> = new Map<number, string>()
  private pendingUrl: PendingUrlDownload | null = null
  private appContext: Context | null = null

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
    this.appContext = context
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

  private emitConfirm(data: Record<string, Object>): void {
    emitter.emit(
      { eventId: DOWNLOAD_CONFIRM_EVENT_ID },
      { data: data }
    )
  }

  // 原版 k6.mb（download/m.java）：暂存下载项并弹确认层，未确认不 start
  private handleBefore(item: webview.WebDownloadItem): void {
    if (this.saveDir === '') {
      return
    }
    const fileName = this.fileNameFor(item)
    this.pendingWeb.set(item.getGuid(), {
      item: item,
      url: item.getUrl(),
      fileName: fileName,
      size: item.getTotalBytes()
    })
    this.emitConfirm({
      'kind': 'web',
      'guid': item.getGuid(),
      'url': item.getUrl(),
      'fileName': fileName,
      'size': item.getTotalBytes()
    })
  }

  // 确认层「下载」：按（可能已编辑的）文件名启动下载并入库
  confirmWebDownload(guid: string, fileName: string): void {
    const pending = this.pendingWeb.get(guid)
    if (pending === undefined) {
      return
    }
    this.pendingWeb.delete(guid)
    const safeName = fileName.trim() !== '' ? fileName.trim() : pending.fileName
    const path = `${this.saveDir}/${safeName}`
    pending.item.start(path)
    this.runningItems.set(guid, pending.item)
    const rec = new DownloadRec()
    rec.url = pending.url
    rec.path = path
    rec.mime = pending.item.getMimeType()
    rec.size = pending.size
    rec.received = 0
    rec.status = DownloadStatus.Running
    rec.created = Date.now()
    this.db.insertDownload(rec).then((id: number) => {
      this.activeIds.set(guid, id)
      this.dbIdToGuid.set(id, guid)
    }).catch((error: BusinessError) => {
      console.error(`insert download failed: ${error.message}`)
    })
  }

  // 确认层「取消」：取消未启动的下载
  cancelPendingDownload(guid: string): void {
    const pending = this.pendingWeb.get(guid)
    if (pending === undefined) {
      return
    }
    this.pendingWeb.delete(guid)
    try {
      pending.item.cancel()
    } catch (error) {
      console.error('cancel pending download failed')
    }
  }

  // 原版上下文菜单「下载链接」同样走确认层；GM_download 透传脚本指定文件名（k6.s download）
  requestUrlDownload(url: string, referer: string, ua: string, name: string = ''): void {
    this.pendingUrl = {
      url: url,
      referer: referer,
      ua: ua,
      fileName: name.trim() !== '' ? name.trim() : this.fileNameFromUrl(url)
    }
    this.emitConfirm({
      'kind': 'url',
      'guid': '',
      'url': url,
      'fileName': this.pendingUrl.fileName,
      'size': 0
    })
  }

  cancelPendingUrlDownload(): void {
    this.pendingUrl = null
  }

  confirmUrlDownload(fileName: string): void {
    const pending = this.pendingUrl
    if (pending === null || this.appContext === null) {
      return
    }
    this.pendingUrl = null
    const safeName = fileName.trim() !== '' ? fileName.trim() : pending.fileName
    // 自研分块引擎（原版 m5.i.f()）
    DownloadEngine.getInstance().createTask(pending.url, safeName, pending.referer, pending.ua)
      .catch((error: BusinessError) => {
        console.error(`create download task failed: ${error.message}`)
      })
  }

  // ===== 原版下载状态机（mark/via/download/c）：暂停/继续/取消/重新下载 =====
  // state>0 为自研引擎托管任务；state=0 为 WebDownloadDelegate 旧任务

  pauseDownload(rec: DownloadRec): void {
    if (rec.state > 0) {
      DownloadEngine.getInstance().pauseById(rec.id).catch(() => {
      })
      return
    }
    const guid = this.dbIdToGuid.get(rec.id)
    if (guid !== undefined) {
      const item = this.runningItems.get(guid)
      if (item !== undefined) {
        try {
          item.pause()
          this.db.updateDownload(rec.id, rec.received, DownloadStatus.Paused).catch(() => {
          })
        } catch (error) {
          console.error('pause download failed')
        }
      }
      return
    }
  }

  resumeDownload(rec: DownloadRec): void {
    if (rec.state > 0) {
      DownloadEngine.getInstance().resumeById(rec.id).catch(() => {
      })
      return
    }
    const guid = this.dbIdToGuid.get(rec.id)
    if (guid !== undefined) {
      const item = this.runningItems.get(guid)
      if (item !== undefined) {
        try {
          item.resume()
          this.db.updateDownload(rec.id, rec.received, DownloadStatus.Running).catch(() => {
          })
        } catch (error) {
          console.error('resume download failed')
        }
      }
      return
    }
  }

  cancelDownload(rec: DownloadRec): void {
    if (rec.state > 0) {
      // 引擎任务：停跑 + 清库 + 清分块 + 撤通知
      DownloadEngine.getInstance().pauseById(rec.id).then(() => {
        return this.db.deleteDownload(rec.id)
      }).then(() => {
        DownloadNotifier.getInstance().cancel(rec.id)
      }).catch(() => {
      })
      return
    }
    const guid = this.dbIdToGuid.get(rec.id)
    if (guid !== undefined) {
      const item = this.runningItems.get(guid)
      if (item !== undefined) {
        try {
          item.cancel()
        } catch (error) {
          console.error('cancel download failed')
        }
      }
      this.runningItems.delete(guid)
      this.dbIdToGuid.delete(rec.id)
      this.db.updateDownload(rec.id, rec.received, DownloadStatus.Canceled).catch(() => {
      })
      return
    }
  }

  // 原版 an「重新下载」：清 ETag/探测标记，8 线程重下（m5.i.l()）
  retryDownload(rec: DownloadRec): void {
    if (rec.state > 0) {
      DownloadEngine.getInstance().restartById(rec.id).catch(() => {
      })
      return
    }
    if (this.appContext === null) {
      return
    }
    const name = this.fileNameFromUrl(rec.url)
    DownloadEngine.getInstance().createTask(rec.url, name, '', '')
      .catch((error: BusinessError) => {
        console.error(`restart download failed: ${error.message}`)
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

  private cleanupGuid(guid: string): void {
    this.activeIds.delete(guid)
    this.lastWrittenPercent.delete(guid)
    this.runningItems.delete(guid)
    for (const key of Array.from(this.dbIdToGuid.keys())) {
      if (this.dbIdToGuid.get(key) === guid) {
        this.dbIdToGuid.delete(key)
      }
    }
  }

  private handleFinish(item: webview.WebDownloadItem): void {
    const id = this.activeIds.get(item.getGuid())
    if (id === undefined) {
      return
    }
    this.copyToUserDir(`${this.saveDir}/${this.fileNameFor(item)}`)
    this.db.updateDownload(id, item.getReceivedBytes(), DownloadStatus.Completed).catch((error: BusinessError) => {
      console.error(`finish download failed: ${error.message}`)
    })
    this.cleanupGuid(item.getGuid())
  }

  private handleFailed(item: webview.WebDownloadItem): void {
    const id = this.activeIds.get(item.getGuid())
    if (id === undefined) {
      return
    }
    this.db.updateDownload(id, item.getReceivedBytes(), DownloadStatus.Failed).catch((error: BusinessError) => {
      console.error(`fail download failed: ${error.message}`)
    })
    this.cleanupGuid(item.getGuid())
  }
}

interface PendingUrlDownload {
  url: string
  referer: string
  ua: string
  fileName: string
}
