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
    return `${base}/via_backup.json`
  }

  private authHeader(): string {
    const settings = AppSettings.getInstance()
    const raw = `${settings.webdavUser}:${settings.webdavPwd}`
    const helper = new util.Base64Helper()
    const encoded = helper.encodeToStringSync(new util.TextEncoder().encodeInto(raw))
    return `Basic ${encoded}`
  }

  async backup(): Promise<void> {
    const path = this.backupPath()
    if (path === '') {
      throw new Error('webdav url empty')
    }
    const json = await BackupManager.getInstance().buildBackupJson()
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
