import { http } from '@kit.NetworkKit'
import { fileIo } from '@kit.CoreFileKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { RuleSubEntry } from './Types'
import { AdBlocker } from './AdBlock'

const SUB_MAX_LINES: number = 60000

export interface ParsedRules {
  blocks: string[]
  allows: string[]
  count: number
}

export function parseAbpRules(body: string): ParsedRules {
  const blocks: string[] = []
  const allows: string[] = []
  const lines = body.split('\n')
  for (let i = 0; i < lines.length && i < SUB_MAX_LINES; i++) {
    const line = lines[i].trim()
    if (line === '' || line.startsWith('!') || line.startsWith('[')) {
      continue
    }
    const isAllow = line.startsWith('@@')
    const rest = isAllow ? line.substring(2) : line
    if (!rest.startsWith('||')) {
      continue
    }
    let host = rest.substring(2).toLowerCase()
    const cutChars = ['^', '/', '$', '|', '?', ',']
    for (let j = 0; j < cutChars.length; j++) {
      const pos = host.indexOf(cutChars[j])
      if (pos >= 0) {
        host = host.substring(0, pos)
      }
    }
    if (host !== '' && host.indexOf('*') < 0 && host.indexOf('.') > 0) {
      if (isAllow) {
        allows.push(host)
      } else {
        blocks.push(host)
      }
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

  async updateSubscription(context: Context, sub: RuleSubEntry): Promise<number> {
    const request = http.createHttp()
    try {
      const response = await request.request(sub.url, {
        method: http.RequestMethod.GET,
        connectTimeout: 10000,
        readTimeout: 30000,
        usingCache: false
      })
      const body = response.result
      if (typeof body !== 'string') {
        throw new Error('non-text response')
      }
      const parsed = parseAbpRules(body)
      this.ensureDir(context)
      const blockPath = `${this.subsDir(context)}/${sub.key}.block`
      const allowPath = `${this.subsDir(context)}/${sub.key}.allow`
      fileIo.writeSync(fileIo.openSync(blockPath, fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.TRUNC).fd, parsed.blocks.join('\n'))
      fileIo.writeSync(fileIo.openSync(allowPath, fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.TRUNC).fd, parsed.allows.join('\n'))
      return parsed.count
    } finally {
      request.destroy()
    }
  }

  async removeSubFiles(context: Context, key: string): Promise<void> {
    const paths = [`${this.subsDir(context)}/${key}.block`, `${this.subsDir(context)}/${key}.allow`]
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
    const blocks: string[] = []
    const allows: string[] = []
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
            const lines = content.split('\n')
            for (let j = 0; j < lines.length; j++) {
              if (lines[j] !== '') {
                blocks.push(lines[j])
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
            const lines = content.split('\n')
            for (let j = 0; j < lines.length; j++) {
              if (lines[j] !== '') {
                allows.push(lines[j])
              }
            }
          }
        }
      } catch (error) {
      }
    }
    blocker.setSubscriptionRules(new Set<string>(blocks), new Set<string>(allows))
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
