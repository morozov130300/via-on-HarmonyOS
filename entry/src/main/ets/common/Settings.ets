import { preferences } from '@kit.ArkData'
import { SiteSetting, RuleEntry, UserScriptRec } from './Types'

export const UA_MODE_DEFAULT: number = 0
export const UA_MODE_PC: number = 1
export const UA_MODE_MOBILE: number = 2
export const UA_MODE_CUSTOM: number = 3

export const PC_UA: string = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36'
export const MOBILE_UA: string = 'Mozilla/5.0 (Linux; Android 13) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36'

export class SavedTab {
  url: string
  incognito: boolean

  constructor(url: string, incognito: boolean) {
    this.url = url
    this.incognito = incognito
  }
}

@ObservedV2
export class AppSettings {
  private static instance: AppSettings | null = null
  private store: preferences.Preferences | null = null

  @Trace engineKey: string = 'baidu'
  @Trace customEngineTemplate: string = ''
  @Trace adBlockOn: boolean = true
  @Trace adBlockTotal: number = 0
  @Trace textZoom: number = 100
  @Trace nightMode: boolean = false
  @Trace uaMode: number = UA_MODE_DEFAULT
  @Trace customUa: string = ''
  @Trace noImage: boolean = false
  @Trace restoreTabs: boolean = true
  @Trace homepageMode: number = 0
  @Trace homeUrl: string = ''
  @Trace searchHistory: string[] = []
  @Trace siteSettings: SiteSetting[] = []
  @Trace customRules: RuleEntry[] = []
  @Trace userScripts: UserScriptRec[] = []
  @Trace scriptNextId: number = 1

  static getInstance(): AppSettings {
    if (AppSettings.instance === null) {
      AppSettings.instance = new AppSettings()
    }
    return AppSettings.instance
  }

  async init(context: Context): Promise<void> {
    if (this.store !== null) {
      return
    }
    try {
      this.store = await preferences.getPreferences(context, 'via_settings')
      this.engineKey = this.store.getString('engineKey', 'baidu')
      this.customEngineTemplate = this.store.getString('customEngineTemplate', '')
      this.adBlockOn = this.store.getBoolean('adBlockOn', true)
      this.adBlockTotal = this.store.getNumber('adBlockTotal', 0)
      this.textZoom = this.store.getNumber('textZoom', 100)
      this.nightMode = this.store.getBoolean('nightMode', false)
      this.uaMode = this.store.getNumber('uaMode', UA_MODE_DEFAULT)
      this.customUa = this.store.getString('customUa', '')
      this.noImage = this.store.getBoolean('noImage', false)
      this.restoreTabs = this.store.getBoolean('restoreTabs', true)
      this.homepageMode = this.store.getNumber('homepageMode', 0)
      this.homeUrl = this.store.getString('homeUrl', '')
      this.searchHistory = this.readStringArray('searchHistory')
      this.siteSettings = this.readSiteSettings()
      this.customRules = this.readRules()
      this.userScripts = this.readScripts()
      this.scriptNextId = this.store.getNumber('scriptNextId', 1)
    } catch (error) {
      const err = error as BusinessError
      console.error(`settings init failed: ${err.code} ${err.message}`)
    }
  }

  private flushKey(key: string, value: preferences.ValueType): void {
    if (this.store === null) {
      return
    }
    this.store.put(key, value).catch((error: BusinessError) => {
      console.error(`settings put ${key} failed: ${error.message}`)
    })
    this.store.flush().catch((error: BusinessError) => {
      console.error(`settings flush failed: ${error.message}`)
    })
  }

  setEngineKey(key: string): void {
    this.engineKey = key
    this.flushKey('engineKey', key)
  }

  setCustomEngineTemplate(template: string): void {
    this.customEngineTemplate = template
    this.flushKey('customEngineTemplate', template)
  }

  setAdBlockOn(on: boolean): void {
    this.adBlockOn = on
    this.flushKey('adBlockOn', on)
  }

  addAdBlocked(count: number): void {
    this.adBlockTotal = this.adBlockTotal + count
    if (this.store !== null) {
      this.store.put('adBlockTotal', this.adBlockTotal).catch((error: BusinessError) => {
        console.error(`settings put adBlockTotal failed: ${error.message}`)
      })
    }
  }

  persistAdBlockTotal(): void {
    if (this.store !== null) {
      this.store.flush().catch((error: BusinessError) => {
        console.error(`settings flush failed: ${error.message}`)
      })
    }
  }

  setTextZoom(zoom: number): void {
    this.textZoom = zoom
    this.flushKey('textZoom', zoom)
  }

  setNightMode(on: boolean): void {
    this.nightMode = on
    this.flushKey('nightMode', on)
  }

  setUaMode(mode: number): void {
    this.uaMode = mode
    this.flushKey('uaMode', mode)
  }

  setCustomUa(ua: string): void {
    this.customUa = ua
    this.flushKey('customUa', ua)
  }

  setNoImage(on: boolean): void {
    this.noImage = on
    this.flushKey('noImage', on)
  }

  setRestoreTabs(on: boolean): void {
    this.restoreTabs = on
    this.flushKey('restoreTabs', on)
  }

  setHomepageMode(mode: number): void {
    this.homepageMode = mode
    this.flushKey('homepageMode', mode)
  }

  setHomeUrl(url: string): void {
    this.homeUrl = url
    this.flushKey('homeUrl', url)
  }

  uaForHost(host: string): string | null {
    const site = this.getSiteSetting(host)
    if (site !== null && site.pcMode) {
      return PC_UA
    }
    if (this.uaMode === UA_MODE_PC) {
      return PC_UA
    }
    if (this.uaMode === UA_MODE_MOBILE) {
      return MOBILE_UA
    }
    if (this.uaMode === UA_MODE_CUSTOM && this.customUa !== '') {
      return this.customUa
    }
    return null
  }

  addSearchHistory(query: string): void {
    const text = query.trim()
    if (text === '') {
      return
    }
    const next: string[] = [text]
    for (let i = 0; i < this.searchHistory.length; i++) {
      if (this.searchHistory[i] !== text && next.length < 20) {
        next.push(this.searchHistory[i])
      }
    }
    this.searchHistory = next
    this.flushKey('searchHistory', JSON.stringify(this.searchHistory))
  }

  clearSearchHistory(): void {
    this.searchHistory = []
    this.flushKey('searchHistory', JSON.stringify(this.searchHistory))
  }

  removeSearchHistory(index: number): void {
    if (index < 0 || index >= this.searchHistory.length) {
      return
    }
    const next: string[] = []
    for (let i = 0; i < this.searchHistory.length; i++) {
      if (i !== index) {
        next.push(this.searchHistory[i])
      }
    }
    this.searchHistory = next
    this.flushKey('searchHistory', JSON.stringify(this.searchHistory))
  }

  getSiteSetting(host: string): SiteSetting | null {
    const found = this.siteSettings.find((item: SiteSetting): boolean => item.host === host)
    if (found !== undefined) {
      return found
    }
    return null
  }

  upsertSiteSetting(setting: SiteSetting): void {
    const next: SiteSetting[] = []
    let replaced = false
    for (let i = 0; i < this.siteSettings.length; i++) {
      if (this.siteSettings[i].host === setting.host) {
        next.push(setting)
        replaced = true
      } else {
        next.push(this.siteSettings[i])
      }
    }
    if (!replaced) {
      next.push(setting)
    }
    this.siteSettings = next
    this.persistSiteSettings()
  }

  private persistSiteSettings(): void {
    const payload: Record<string, Object>[] = []
    for (let i = 0; i < this.siteSettings.length; i++) {
      const item = this.siteSettings[i]
      const entry: Record<string, Object> = {}
      entry['host'] = item.host
      entry['pcMode'] = item.pcMode
      entry['noImage'] = item.noImage
      entry['allowAds'] = item.allowAds
      entry['forceDark'] = item.forceDark
      payload.push(entry)
    }
    this.flushKey('siteSettings', JSON.stringify(payload))
  }

  private readSiteSettings(): SiteSetting[] {
    if (this.store === null) {
      return []
    }
    const raw = this.store.getString('siteSettings', '[]')
    const result: SiteSetting[] = []
    try {
      const parsed = JSON.parse(raw) as Object[]
      for (let i = 0; i < parsed.length; i++) {
        const element = parsed[i] as Record<string, Object>
        const item = SiteSetting.fromJson(element)
        if (item !== null) {
          result.push(item)
        }
      }
    } catch (error) {
      console.error('parse siteSettings failed')
    }
    return result
  }

  addRule(domain: string, isAllow: boolean): void {
    const text = domain.trim().toLowerCase()
    if (text === '') {
      return
    }
    const next: RuleEntry[] = []
    let replaced = false
    for (let i = 0; i < this.customRules.length; i++) {
      if (this.customRules[i].domain === text) {
        next.push(new RuleEntry(text, isAllow))
        replaced = true
      } else {
        next.push(this.customRules[i])
      }
    }
    if (!replaced) {
      next.push(new RuleEntry(text, isAllow))
    }
    this.customRules = next
    this.persistRules()
  }

  removeRule(domain: string): void {
    const next: RuleEntry[] = []
    for (let i = 0; i < this.customRules.length; i++) {
      if (this.customRules[i].domain !== domain) {
        next.push(this.customRules[i])
      }
    }
    this.customRules = next
    this.persistRules()
  }

  private persistRules(): void {
    const payload: Record<string, Object>[] = []
    for (let i = 0; i < this.customRules.length; i++) {
      const item = this.customRules[i]
      const entry: Record<string, Object> = {}
      entry['domain'] = item.domain
      entry['isAllow'] = item.isAllow
      payload.push(entry)
    }
    this.flushKey('customRules', JSON.stringify(payload))
  }

  private readRules(): RuleEntry[] {
    if (this.store === null) {
      return []
    }
    const raw = this.store.getString('customRules', '[]')
    const result: RuleEntry[] = []
    try {
      const parsed = JSON.parse(raw) as Object[]
      for (let i = 0; i < parsed.length; i++) {
        const element = parsed[i] as Record<string, Object>
        const item = RuleEntry.fromJson(element)
        if (item !== null) {
          result.push(item)
        }
      }
    } catch (error) {
      console.error('parse customRules failed')
    }
    return result
  }

  saveScript(script: UserScriptRec): void {
    const next: UserScriptRec[] = []
    let replaced = false
    for (let i = 0; i < this.userScripts.length; i++) {
      if (this.userScripts[i].id === script.id) {
        next.push(script)
        replaced = true
      } else {
        next.push(this.userScripts[i])
      }
    }
    if (!replaced) {
      next.push(script)
    }
    this.userScripts = next
    this.persistScripts()
  }

  removeScript(id: number): void {
    const next: UserScriptRec[] = []
    for (let i = 0; i < this.userScripts.length; i++) {
      if (this.userScripts[i].id !== id) {
        next.push(this.userScripts[i])
      }
    }
    this.userScripts = next
    this.persistScripts()
  }

  private persistScripts(): void {
    const payload: Record<string, Object>[] = []
    for (let i = 0; i < this.userScripts.length; i++) {
      const item = this.userScripts[i]
      const entry: Record<string, Object> = {}
      entry['id'] = item.id
      entry['name'] = item.name
      entry['code'] = item.code
      entry['matchHost'] = item.matchHost
      entry['enabled'] = item.enabled
      payload.push(entry)
    }
    this.flushKey('userScripts', JSON.stringify(payload))
    this.flushKey('scriptNextId', this.scriptNextId)
  }

  private readScripts(): UserScriptRec[] {
    if (this.store === null) {
      return []
    }
    const raw = this.store.getString('userScripts', '[]')
    const result: UserScriptRec[] = []
    try {
      const parsed = JSON.parse(raw) as Object[]
      for (let i = 0; i < parsed.length; i++) {
        const element = parsed[i] as Record<string, Object>
        const item = UserScriptRec.fromJson(element)
        if (item !== null) {
          result.push(item)
        }
      }
    } catch (error) {
      console.error('parse userScripts failed')
    }
    return result
  }

  private readStringArray(key: string): string[] {
    if (this.store === null) {
      return []
    }
    const raw = this.store.getString(key, '[]')
    const result: string[] = []
    try {
      const parsed = JSON.parse(raw) as Object[]
      for (let i = 0; i < parsed.length; i++) {
        const element = parsed[i]
        if (typeof element === 'string') {
          result.push(element)
        }
      }
    } catch (error) {
      console.error(`parse ${key} failed`)
    }
    return result
  }

  saveTabsSnapshot(tabs: SavedTab[], activeIndex: number): void {
    const payload: Record<string, Object>[] = []
    for (let i = 0; i < tabs.length; i++) {
      const entry: Record<string, Object> = {}
      entry['url'] = tabs[i].url
      entry['incognito'] = tabs[i].incognito
      payload.push(entry)
    }
    this.flushKey('tabsSnapshot', JSON.stringify(payload))
    this.flushKey('tabsSnapshotIndex', activeIndex)
  }

  readTabsSnapshot(): SavedTab[] {
    if (this.store === null) {
      return []
    }
    const raw = this.store.getString('tabsSnapshot', '[]')
    const result: SavedTab[] = []
    try {
      const parsed = JSON.parse(raw) as Object[]
      for (let i = 0; i < parsed.length; i++) {
        const element = parsed[i] as Record<string, Object>
        const url = element['url']
        const incognito = element['incognito']
        if (typeof url === 'string' && typeof incognito === 'boolean') {
          result.push(new SavedTab(url, incognito))
        }
      }
    } catch (error) {
      console.error('parse tabsSnapshot failed')
    }
    return result
  }

  readTabsSnapshotIndex(): number {
    if (this.store === null) {
      return 0
    }
    return this.store.getNumber('tabsSnapshotIndex', 0)
  }
}
