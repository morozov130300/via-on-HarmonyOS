import { webview } from '@kit.ArkWeb'
import { fileIo } from '@kit.CoreFileKit'
import { emitter, BusinessError } from '@kit.BasicServicesKit'
import { BrowserDb } from './Database'
import { DownloadRec } from './Types'
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
  // 确认前的暂存（原版 m.java 弹层期间不启动下载）
  private pendingWeb: Map<string, PendingWebDownload> = new Map<string, PendingWebDownload>()
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
    // 网页内下载统一接管：onBeforeDownload 只取信息转交自研分块引擎，不调用 start()
    const delegate: webview.WebDownloadDelegate = new webview.WebDownloadDelegate()
    delegate.onBeforeDownload((downloadItem: webview.WebDownloadItem) => {
      this.handleBefore(downloadItem)
    })
    delegate.onDownloadUpdated((downloadItem: webview.WebDownloadItem) => {
      console.info(`web download updated: ${downloadItem.getGuid()} (handled by DownloadEngine)`)
    })
    delegate.onDownloadFinish((downloadItem: webview.WebDownloadItem) => {
      console.info(`web download finish: ${downloadItem.getGuid()} (handled by DownloadEngine)`)
    })
    delegate.onDownloadFailed((downloadItem: webview.WebDownloadItem) => {
      console.info(`web download failed: ${downloadItem.getGuid()} (handled by DownloadEngine)`)
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

  // 确认层「下载」：不调用 item.start()，取 URL/文件名/Cookie 转交自研分块引擎（与下载链接同链路）
  confirmWebDownload(guid: string, fileName: string, referer: string = '', ua: string = ''): void {
    const pending = this.pendingWeb.get(guid)
    if (pending === undefined) {
      return
    }
    this.pendingWeb.delete(guid)
    const safeName = fileName.trim() !== '' ? fileName.trim() : pending.fileName
    // 注入 Web Cookie 保证登录态下载（WebCookieManager.fetchCookieSync，API 11+）
    let cookie = ''
    try {
      cookie = webview.WebCookieManager.fetchCookieSync(pending.url)
    } catch (error) {
      console.error('fetch cookie for download failed')
    }
    // 已由引擎接管，释放 ArkWeb 侧下载项
    try {
      pending.item.cancel()
    } catch (error) {
      console.error('cancel web download item failed')
    }
    DownloadEngine.getInstance().createTask(pending.url, safeName, referer, ua, 1, cookie)
      .catch((error: BusinessError) => {
        console.error(`create download task failed: ${error.message}`)
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
  // 网页内下载与下载链接统一走自研引擎（state>0）；state=0 旧记录无运行态

  pauseDownload(rec: DownloadRec): void {
    if (rec.state > 0) {
      DownloadEngine.getInstance().pauseById(rec.id).catch(() => {
      })
    }
  }

  resumeDownload(rec: DownloadRec): void {
    if (rec.state > 0) {
      DownloadEngine.getInstance().resumeById(rec.id).catch(() => {
      })
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
}

interface PendingUrlDownload {
  url: string
  referer: string
  ua: string
  fileName: string
}
