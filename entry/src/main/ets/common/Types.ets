import { webview } from '@kit.ArkWeb'

export enum DownloadStatus {
  Running = 0,
  Completed = 1,
  Failed = 2,
  Canceled = 3,
  Paused = 4
}

@ObservedV2
export class TabItem {
  readonly id: number
  @Trace incognito: boolean
  @Trace title: string
  @Trace url: string
  @Trace progress: number
  @Trace adCount: number
  @Trace canBack: boolean
  @Trace canForward: boolean
  @Trace loading: boolean
  @Trace isError: boolean
  @Trace errorDesc: string
  @Trace initialUrl: string
  @Trace matchOrdinal: number
  @Trace matchCount: number
  controller: webview.WebviewController

  constructor(id: number, incognito: boolean) {
    this.id = id
    this.incognito = incognito
    this.title = ''
    this.url = ''
    this.progress = 0
    this.adCount = 0
    this.canBack = false
    this.canForward = false
    this.loading = false
    this.isError = false
    this.errorDesc = ''
    this.initialUrl = ''
    this.matchOrdinal = 0
    this.matchCount = 0
    this.controller = new webview.WebviewController()
  }

  isHomePage(): boolean {
    return this.url === '' || this.url === 'about:blank'
  }

  displayTitle(fallback: string): string {
    if (this.isHomePage()) {
      return fallback
    }
    if (this.title !== '') {
      return this.title
    }
    return this.url
  }
}

export class BookmarkRec {
  id: number
  title: string
  url: string
  folder: string
  created: number

  constructor() {
    this.id = -1
    this.title = ''
    this.url = ''
    this.folder = ''
    this.created = 0
  }

  static fromJson(obj: Record<string, Object>): BookmarkRec | null {
    const rec = new BookmarkRec()
    const id = obj['id']
    const title = obj['title']
    const url = obj['url']
    const folder = obj['folder']
    const created = obj['created']
    if (typeof id === 'number' && typeof title === 'string' && typeof url === 'string') {
      rec.id = id
      rec.title = title
      rec.url = url
      if (typeof folder === 'string') {
        rec.folder = folder
      }
      if (typeof created === 'number') {
        rec.created = created
      }
      return rec
    }
    return null
  }
}

export class HistoryRec {
  id: number
  title: string
  url: string
  visited: number

  constructor() {
    this.id = -1
    this.title = ''
    this.url = ''
    this.visited = 0
  }

  static fromJson(obj: Record<string, Object>): HistoryRec | null {
    const rec = new HistoryRec()
    const id = obj['id']
    const title = obj['title']
    const url = obj['url']
    const visited = obj['visited']
    if (typeof id === 'number' && typeof title === 'string' && typeof url === 'string') {
      rec.id = id
      rec.title = title
      rec.url = url
      if (typeof visited === 'number') {
        rec.visited = visited
      }
      return rec
    }
    return null
  }
}

export class DownloadRec {
  id: number
  url: string
  path: string
  mime: string
  size: number
  received: number
  status: DownloadStatus
  created: number

  constructor() {
    this.id = -1
    this.url = ''
    this.path = ''
    this.mime = ''
    this.size = 0
    this.received = 0
    this.status = DownloadStatus.Running
    this.created = 0
  }

  static fromJson(obj: Record<string, Object>): DownloadRec | null {
    const rec = new DownloadRec()
    const id = obj['id']
    const url = obj['url']
    const path = obj['path']
    const mime = obj['mime']
    const size = obj['size']
    const received = obj['received']
    const status = obj['status']
    const created = obj['created']
    if (typeof id === 'number' && typeof url === 'string' && typeof path === 'string') {
      rec.id = id
      rec.url = url
      rec.path = path
      if (typeof mime === 'string') {
        rec.mime = mime
      }
      if (typeof size === 'number') {
        rec.size = size
      }
      if (typeof received === 'number') {
        rec.received = received
      }
      if (typeof status === 'number') {
        rec.status = status
      }
      if (typeof created === 'number') {
        rec.created = created
      }
      return rec
    }
    return null
  }
}

export class SiteSetting {
  host: string
  pcMode: boolean
  noImage: boolean
  allowAds: boolean
  forceDark: boolean

  constructor(host: string) {
    this.host = host
    this.pcMode = false
    this.noImage = false
    this.allowAds = false
    this.forceDark = false
  }

  static fromJson(obj: Record<string, Object>): SiteSetting | null {
    const host = obj['host']
    if (typeof host !== 'string' || host === '') {
      return null
    }
    const setting = new SiteSetting(host)
    const pcMode = obj['pcMode']
    const noImage = obj['noImage']
    const allowAds = obj['allowAds']
    const forceDark = obj['forceDark']
    if (typeof pcMode === 'boolean') {
      setting.pcMode = pcMode
    }
    if (typeof noImage === 'boolean') {
      setting.noImage = noImage
    }
    if (typeof allowAds === 'boolean') {
      setting.allowAds = allowAds
    }
    if (typeof forceDark === 'boolean') {
      setting.forceDark = forceDark
    }
    return setting
  }
}

export class UserScriptRec {
  id: number
  name: string
  code: string
  matchHost: string
  enabled: boolean
  sourceUrl: string

  constructor() {
    this.id = -1
    this.name = ''
    this.code = ''
    this.matchHost = ''
    this.enabled = true
    this.sourceUrl = ''
  }

  static fromJson(obj: Record<string, Object>): UserScriptRec | null {
    const rec = new UserScriptRec()
    const id = obj['id']
    const name = obj['name']
    const code = obj['code']
    const matchHost = obj['matchHost']
    const enabled = obj['enabled']
    const sourceUrl = obj['sourceUrl']
    if (typeof id === 'number' && typeof name === 'string' && typeof code === 'string') {
      rec.id = id
      rec.name = name
      rec.code = code
      if (typeof matchHost === 'string') {
        rec.matchHost = matchHost
      }
      if (typeof enabled === 'boolean') {
        rec.enabled = enabled
      }
      if (typeof sourceUrl === 'string') {
        rec.sourceUrl = sourceUrl
      }
      return rec
    }
    return null
  }
}

export class RuleEntry {
  domain: string
  isAllow: boolean

  constructor(domain: string, isAllow: boolean) {
    this.domain = domain
    this.isAllow = isAllow
  }

  static fromJson(obj: Record<string, Object>): RuleEntry | null {
    const domain = obj['domain']
    const isAllow = obj['isAllow']
    if (typeof domain === 'string' && typeof isAllow === 'boolean') {
      return new RuleEntry(domain, isAllow)
    }
    return null
  }
}
