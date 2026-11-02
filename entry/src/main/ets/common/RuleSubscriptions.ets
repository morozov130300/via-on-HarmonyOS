import { http } from '@kit.NetworkKit'
import { fileIo } from '@kit.CoreFileKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { RuleSubEntry } from './Types'
import { AdBlocker } from './AdBlock'

export interface ParsedRules {
  blocks: string[]
  allows: string[]
  count: number
}

// 原版逐行解析为网络规则/元素隐藏并保留全部语法（b5/c.java:600-605 v()）
export function parseAbpRules(body: string): ParsedRules {
  const blocks: string[] = []
  const allows: string[] = []
  const lines = body.split('\n')
  for (let i = 0; i < lines.length; i++) {
    const line = lines[i].trim()
    if (line === '' || line.startsWith('!') || line.startsWith('[')) {
      continue
    }
    if (line.indexOf('#@#') >= 0) {
      // 元素隐藏异常规则单独存 allow 侧
      allows.push(line)
      continue
    }
    if (line.indexOf('##') >= 0) {
      blocks.push(line)
      continue
    }
    // 网络规则整行保留（||host^、通配、$ 选项由引擎处理）
    if (line.startsWith('@@')) {
      allows.push(line)
    } else {
      blocks.push(line)
    }
  }
  return { blocks: blocks, allows: allows, count: blocks.length + allows.length }
}

export class RuleSubManager {
  private static instance: RuleSubManager | null = null
  private updating: boolean = false

  static getInstance(): RuleSubManager {
    if (RuleSubManager.instance === null) {
      RuleSubManager.instance = new RuleSubManager()
    }
    return RuleSubManager.instance
  }

  private subsDir(context: Context): string {
    return `${context.filesDir}/rulesubs`
  }

  private ensureDir(context: Context): void {
    try {
      fileIo.accessSync(this.subsDir(context))
    } catch (error) {
      try {
        fileIo.mkdirSync(this.subsDir(context))
      } catch (innerError) {
        console.error('mkdir rulesubs failed')
      }
    }
  }

  // 原版 b5/c.java:325-346 i()：github 源下载失败回退 jsdelivr 镜像
  private mirrorUrl(url: string): string | null {
    if (url.indexOf('raw.githubusercontent.com') >= 0) {
      return url.replace('raw.githubusercontent.com', 'fastly.jsdelivr.net/gh')
    }
    if (url.indexOf('github.com') >= 0 && url.indexOf('/blob/') >= 0) {
      return url.replace('github.com', 'fastly.jsdelivr.net/gh').replace('/blob/', '@')
    }
    return null
  }

  async updateSubscription(context: Context, sub: RuleSubEntry): Promise<number> {
    let body = await this.fetchText(sub.url)
    if (body === null) {
      const mirror = this.mirrorUrl(sub.url)
      if (mirror !== null) {
        body = await this.fetchText(mirror)
      }
    }
    if (body === null) {
      throw new Error('download failed')
    }
    const parsed = parseAbpRules(body)
    this.ensureDir(context)
    const blockPath = `${this.subsDir(context)}/${sub.key}.block`
    const allowPath = `${this.subsDir(context)}/${sub.key}.allow`
    fileIo.writeSync(fileIo.openSync(blockPath, fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.TRUNC).fd, parsed.blocks.join('\n'))
    fileIo.writeSync(fileIo.openSync(allowPath, fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.TRUNC).fd, parsed.allows.join('\n'))
    return parsed.count
  }

  // 原版 b5/c.java:164：响应码 200 且 Content-Type 为 text/plain 才落盘；UA Chrome/83（b5/c:155）
  private async fetchText(url: string): Promise<string | null> {
    const request = http.createHttp()
    try {
      const response = await request.request(url, {
        method: http.RequestMethod.GET,
        connectTimeout: 10000,
        readTimeout: 30000,
        usingCache: false,
        header: { 'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0 Safari/537.36' }
      })
      if (response.responseCode !== 200) {
        return null
      }
      const mime = `${response.header['content-type'] ?? ''}`.toLowerCase()
      if (mime !== '' && mime.indexOf('text/') < 0) {
        return null
      }
      const body = response.result
      return typeof body === 'string' ? body : null
    } catch (error) {
      return null
    } finally {
      request.destroy()
    }
  }

  // 原版 z7/v0.java 预览页：读取本地规则文件逐行展示
  readSubLines(context: Context, key: string): string[] {
    const lines: string[] = []
    const paths = [`${this.subsDir(context)}/${key}.block`, `${this.subsDir(context)}/${key}.allow`]
    for (let i = 0; i < paths.length; i++) {
      try {
        if (fileIo.accessSync(paths[i])) {
          const content = fileIo.readTextSync(paths[i])
          if (content !== '') {
            const fileLines = content.split('\n')
            for (let j = 0; j < fileLines.length; j++) {
              if (fileLines[j] !== '') {
                lines.push(fileLines[j])
              }
            }
          }
        }
      } catch (error) {
      }
    }
    return lines
  }

  async removeSubFiles(context: Context, key: string): Promise<void> {    const paths = [`${this.subsDir(context)}/${key}.block`, `${this.subsDir(context)}/${key}.allow`]
    for (let i = 0; i < paths.length; i++) {
      try {
        if (fileIo.accessSync(paths[i])) {
          fileIo.unlinkSync(paths[i])
        }
      } catch (error) {
      }
    }
  }

  async loadEnabledInto(context: Context, subs: RuleSubEntry[], blocker: AdBlocker): Promise<void> {
    const lines: string[] = []
    for (let i = 0; i < subs.length; i++) {
      const sub = subs[i]
      if (!sub.enabled) {
        continue
      }
      const blockPath = `${this.subsDir(context)}/${sub.key}.block`
      const allowPath = `${this.subsDir(context)}/${sub.key}.allow`
      try {
        if (fileIo.accessSync(blockPath)) {
          const content = fileIo.readTextSync(blockPath)
          if (content !== '') {
            const blockLines = content.split('\n')
            for (let j = 0; j < blockLines.length; j++) {
              if (blockLines[j] !== '') {
                lines.push(blockLines[j])
              }
            }
          }
        }
      } catch (error) {
      }
      try {
        if (fileIo.accessSync(allowPath)) {
          const content = fileIo.readTextSync(allowPath)
          if (content !== '') {
            const allowLines = content.split('\n')
            for (let j = 0; j < allowLines.length; j++) {
              if (allowLines[j] !== '') {
                lines.push(allowLines[j])
              }
            }
          }
        }
      } catch (error) {
      }
    }
    blocker.setSubscriptionRules(lines)
  }

  async maybeAutoUpdate(context: Context, subs: RuleSubEntry[], intervalDays: number): Promise<RuleSubEntry[] | null> {
    if (intervalDays <= 0 || this.updating) {
      return null
    }
    const spanMs = intervalDays * 24 * 60 * 60 * 1000
    const now = Date.now()
    const due: RuleSubEntry[] = []
    for (let i = 0; i < subs.length; i++) {
      if (subs[i].enabled && (subs[i].lastUpdate === 0 || now - subs[i].lastUpdate > spanMs)) {
        due.push(subs[i])
      }
    }
    if (due.length === 0) {
      return null
    }
    this.updating = true
    try {
      for (let i = 0; i < due.length; i++) {
        try {
          due[i].ruleCount = await this.updateSubscription(context, due[i])
          due[i].lastUpdate = Date.now()
        } catch (error) {
          const err = error as BusinessError
          console.error(`auto update sub failed: ${due[i].key}, ${err.message}`)
        }
      }
    } finally {
      this.updating = false
    }
    return due
  }
}
