import { http } from '@kit.NetworkKit'
import { util } from '@kit.ArkTS'
import { BusinessError } from '@kit.BasicServicesKit'
import { AppSettings } from './Settings'
import { BackupManager } from './Backup'

export class WebDavClient {
  private static instance: WebDavClient | null = null

  static getInstance(): WebDavClient {
    if (WebDavClient.instance === null) {
      WebDavClient.instance = new WebDavClient()
    }
    return WebDavClient.instance
  }

  private backupPath(): string {
    const settings = AppSettings.getInstance()
    let base = settings.webdavUrl.trim()
    if (base === '') {
      return ''
    }
    while (base.endsWith('/')) {
      base = base.substring(0, base.length - 1)
    }
    return `${base}/uia_backup.json`
  }

  private authHeader(): string {
    const settings = AppSettings.getInstance()
    const raw = `${settings.webdavUser}:${settings.webdavPwd}`
    const helper = new util.Base64Helper()
    const encoded = helper.encodeToStringSync(new util.TextEncoder().encodeInto(raw))
    return `Basic ${encoded}`
  }

  // 读取远端备份的 ts（毫秒）；远端不存在/解析失败返回 0
  private async fetchRemoteTs(): Promise<number> {
    const path = this.backupPath()
    if (path === '') {
      return 0
    }
    const client = http.createHttp()
    try {
      const response = await client.request(path, {
        method: http.RequestMethod.GET,
        header: { 'Authorization': this.authHeader() },
        connectTimeout: 15000,
        readTimeout: 30000
      })
      if (response.responseCode !== 200) {
        return 0
      }
      const body = response.result
      if (typeof body !== 'string' || body.trim() === '') {
        return 0
      }
      const root = JSON.parse(body) as Record<string, Object>
      const ts = root['ts']
      return typeof ts === 'number' ? ts : 0
    } catch (error) {
      return 0
    } finally {
      client.destroy()
    }
  }

  async backup(): Promise<void> {
    const path = this.backupPath()
    if (path === '') {
      throw new Error('webdav url empty')
    }
    const json = await BackupManager.getInstance().buildBackupJson()
    // 冲突保护：远端备份比本地快照新时拒绝覆盖（新者胜原则，由调用方提示）
    const localTs = (() => {
      try { return (JSON.parse(json) as Record<string, Object>)['ts'] as number } catch (e) { return 0 }
    })()
    const remoteTs = await this.fetchRemoteTs()
    if (remoteTs > localTs) {
      throw new Error('webdav remote newer')
    }
    const client = http.createHttp()
    try {
      const response = await client.request(path, {
        method: http.RequestMethod.PUT,
        header: {
          'Authorization': this.authHeader(),
          'Content-Type': 'application/json'
        },
        extraData: json,
        connectTimeout: 15000,
        readTimeout: 30000
      })
      if (response.responseCode < 200 || response.responseCode >= 300) {
        throw new Error(`webdav put failed: ${response.responseCode}`)
      }
    } finally {
      client.destroy()
    }
  }

  async restore(): Promise<void> {
    const path = this.backupPath()
    if (path === '') {
      throw new Error('webdav url empty')
    }
    const client = http.createHttp()
    try {
      const response = await client.request(path, {
        method: http.RequestMethod.GET,
        header: {
          'Authorization': this.authHeader()
        },
        connectTimeout: 15000,
        readTimeout: 30000
      })
      if (response.responseCode < 200 || response.responseCode >= 300) {
        throw new Error(`webdav get failed: ${response.responseCode}`)
      }
      const body = response.result
      if (typeof body !== 'string' || body.trim() === '') {
        throw new Error('webdav backup empty')
      }
      await BackupManager.getInstance().applyBackupJson(body)
    } finally {
      client.destroy()
    }
  }
}
