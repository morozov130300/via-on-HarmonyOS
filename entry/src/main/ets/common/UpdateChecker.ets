import { http } from '@kit.NetworkKit'
import { bundleManager } from '@kit.AbilityKit'

// 原版 y8/h.k()：play flavor 更新配置地址（c0.i() 为 play 时取 latest_play.json）
const UPDATE_CONFIG_URL: string = 'https://res.uiayoo.com/v1/latest_play.json'
// 原版 y8/h.a.i()：version > 20260920 才视为有效下发
const MIN_EFFECTIVE_VERSION: number = 20260920

export interface UpdateConfig {
  taskId: number
  version: number
  changelog: string
  url: string
  md5: string
}

export class UpdateChecker {
  // 原版 y8/h.k()：GET 请求（Accept: */*、Charset: UTF-8、Connection: Keep-Alive），
  // 任何异常静默返回 null（原版返回未填充的默认 a 实例）
  static async fetchLatestConfig(): Promise<UpdateConfig | null> {
    const request = http.createHttp()
    try {
      const response = await request.request(UPDATE_CONFIG_URL, {
        method: http.RequestMethod.GET,
        connectTimeout: 10000,
        readTimeout: 30000,
        usingCache: false,
        header: { 'Accept': '*/*', 'Charset': 'UTF-8', 'Connection': 'Keep-Alive' }
      })
      if (response.responseCode !== 200) {
        return null
      }
      const body = response.result
      if (typeof body !== 'string') {
        return null
      }
      return UpdateChecker.parseConfig(body)
    } catch (error) {
      return null
    } finally {
      request.destroy()
    }
  }

  // 原版 y8/h.a.l() 逐字段读取 + a.i() 有效性判定：
  // version > 20260920 且 changelog/url/md5 均非空
  private static parseConfig(text: string): UpdateConfig | null {
    try {
      const root: Record<string, Object> = JSON.parse(text) as Record<string, Object>
      const taskIdRaw: Object | undefined = root['task_id']
      const versionRaw: Object | undefined = root['version']
      const changelogRaw: Object | undefined = root['changelog']
      const urlRaw: Object | undefined = root['url']
      const md5Raw: Object | undefined = root['md5']
      const config: UpdateConfig = {
        taskId: typeof taskIdRaw === 'number' ? taskIdRaw : -1,
        version: typeof versionRaw === 'number' ? versionRaw : 0,
        changelog: typeof changelogRaw === 'string' ? changelogRaw : '',
        url: typeof urlRaw === 'string' ? urlRaw : '',
        md5: typeof md5Raw === 'string' ? md5Raw : ''
      }
      return UpdateChecker.isEffective(config) ? config : null
    } catch (error) {
      return null
    }
  }

  static isEffective(config: UpdateConfig): boolean {
    return config.version > MIN_EFFECTIVE_VERSION && config.changelog !== '' && config.url !== '' && config.md5 !== ''
  }

  static getLocalVersionCode(): number {
    try {
      const info = bundleManager.getBundleInfoForSelfSync(bundleManager.BundleFlag.GET_BUNDLE_INFO_DEFAULT)
      return info.versionCode
    } catch (error) {
      return 0
    }
  }

  static isUpdateAvailable(config: UpdateConfig | null): boolean {
    if (config === null || !UpdateChecker.isEffective(config)) {
      return false
    }
    return config.version > UpdateChecker.getLocalVersionCode()
  }
}
