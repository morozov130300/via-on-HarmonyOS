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
  @Trace ruleSubUrl: string = ''
  @Trace scriptEnabled: boolean = true
  @Trace doNotTrack: boolean = false
  @Trace disableWebRtc: boolean = false
  @Trace doNotSell: boolean = false
  @Trace dataSaver: boolean = false
  @Trace autoSniffButton: boolean = false
  @Trace allowDebugWeb: boolean = false
  @Trace disableCustomTabs: boolean = false
  @Trace disableSafeBrowsing: boolean = false
  @Trace ignoreSslWarning: boolean = false
  @Trace homeBgColor: string = ''
  @Trace homeLogoText: string = 'VIA'
  @Trace homeLogoSize: number = 0
  @Trace homeLogoStyle: number = 3
  @Trace homePillCorner: number = 0
  @Trace homePillOpacity: number = 2
  @Trace homePillStrokeWidth: number = 2
  @Trace homePillStrokeOpacity: number = 2
  @Trace homePillStyle: number = 1
  @Trace homeFavSize: number = 0
  @Trace homeFavCorner: number = 0
  @Trace homeFavColor: number = 1
  @Trace homeFavIconStyle: number = 1
  @Trace homeAdvEffect: number = 1
  @Trace homeAdvArea: number = 0

  static getInstance(): AppSettings {
    if (AppSettings.instance === null) {
      AppSettings.instance = new AppSettings()
    }
    return AppSettings.instance
  }

  private async readString(key: string, defaultValue: string): Promise<string> {
    if (this.store === null) {
      return defaultValue
    }
    const value = await this.store.get(key, defaultValue)
    if (typeof value === 'string') {
      return value
    }
    return defaultValue
  }

  private async readNumber(key: string, defaultValue: number): Promise<number> {
    if (this.store === null) {
      return defaultValue
    }
    const value = await this.store.get(key, defaultValue)
    if (typeof value === 'number') {
      return value
    }
    return defaultValue
  }

  private async readBoolean(key: string, defaultValue: boolean): Promise<boolean> {
    if (this.store === null) {
      return defaultValue
    }
    const value = await this.store.get(key, defaultValue)
    if (typeof value === 'boolean') {
      return value
    }
    return defaultValue
  }

  async init(context: Context): Promise<void> {
    if (this.store !== null) {
      return
    }
    try {
      this.store = await preferences.getPreferences(context, 'via_settings')
      this.engineKey = await this.readString('engineKey', 'baidu')
      this.customEngineTemplate = await this.readString('customEngineTemplate', '')
      this.adBlockOn = await this.readBoolean('adBlockOn', true)
      this.adBlockTotal = await this.readNumber('adBlockTotal', 0)
      this.textZoom = await this.readNumber('textZoom', 100)
      this.nightMode = await this.readBoolean('nightMode', false)
      this.uaMode = await this.readNumber('uaMode', UA_MODE_DEFAULT)
      this.customUa = await this.readString('customUa', '')
      this.noImage = await this.readBoolean('noImage', false)
      this.restoreTabs = await this.readBoolean('restoreTabs', true)
      this.homepageMode = await this.readNumber('homepageMode', 0)
      this.homeUrl = await this.readString('homeUrl', '')
      this.searchHistory = await this.readStringArray('searchHistory')
      this.siteSettings = await this.readSiteSettings()
      this.customRules = await this.readRules()
      this.userScripts = await this.readScripts()
      this.scriptNextId = await this.readNumber('scriptNextId', 1)
      this.ruleSubUrl = await this.readString('ruleSubUrl', '')
      this.scriptEnabled = await this.readBoolean('scriptEnabled', true)
      this.doNotTrack = await this.readBoolean('doNotTrack', false)
      this.disableWebRtc = await this.readBoolean('disableWebRtc', false)
      this.doNotSell = await this.readBoolean('doNotSell', false)
      this.dataSaver = await this.readBoolean('dataSaver', false)
      this.autoSniffButton = await this.readBoolean('autoSniffButton', false)
      this.allowDebugWeb = await this.readBoolean('allowDebugWeb', false)
      this.disableCustomTabs = await this.readBoolean('disableCustomTabs', false)
      this.disableSafeBrowsing = await this.readBoolean('disableSafeBrowsing', false)
      this.ignoreSslWarning = await this.readBoolean('ignoreSslWarning', false)
      this.homeBgColor = await this.readString('homeBgColor', '')
      this.homeLogoText = await this.readString('homeLogoText', 'VIA')
      this.homeLogoSize = await this.readNumber('homeLogoSize', 0)
      this.homeLogoStyle = await this.readNumber('homeLogoStyle', 3)
      this.homePillCorner = await this.readNumber('homePillCorner', 0)
      this.homePillOpacity = await this.readNumber('homePillOpacity', 2)
      this.homePillStrokeWidth = await this.readNumber('homePillStrokeWidth', 2)
      this.homePillStrokeOpacity = await this.readNumber('homePillStrokeOpacity', 2)
      this.homePillStyle = await this.readNumber('homePillStyle', 1)
      this.homeFavSize = await this.readNumber('homeFavSize', 0)
      this.homeFavCorner = await this.readNumber('homeFavCorner', 0)
      this.homeFavColor = await this.readNumber('homeFavColor', 1)
      this.homeFavIconStyle = await this.readNumber('homeFavIconStyle', 1)
      this.homeAdvEffect = await this.readNumber('homeAdvEffect', 1)
      this.homeAdvArea = await this.readNumber('homeAdvArea', 0)
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

  setRuleSubUrl(url: string): void {
    this.ruleSubUrl = url
    this.flushKey('ruleSubUrl', url)
  }

  setScriptEnabled(on: boolean): void {
    this.scriptEnabled = on
    this.flushKey('scriptEnabled', on)
  }

  setDoNotTrack(on: boolean): void {
    this.doNotTrack = on
    this.flushKey('doNotTrack', on)
  }

  setDisableWebRtc(on: boolean): void {
    this.disableWebRtc = on
    this.flushKey('disableWebRtc', on)
  }

  setDoNotSell(on: boolean): void {
    this.doNotSell = on
    this.flushKey('doNotSell', on)
  }

  setDataSaver(on: boolean): void {
    this.dataSaver = on
    this.flushKey('dataSaver', on)
  }

  setAutoSniffButton(on: boolean): void {
    this.autoSniffButton = on
    this.flushKey('autoSniffButton', on)
  }

  setAllowDebugWeb(on: boolean): void {
    this.allowDebugWeb = on
    this.flushKey('allowDebugWeb', on)
  }

  setDisableCustomTabs(on: boolean): void {
    this.disableCustomTabs = on
    this.flushKey('disableCustomTabs', on)
  }

  setDisableSafeBrowsing(on: boolean): void {
    this.disableSafeBrowsing = on
    this.flushKey('disableSafeBrowsing', on)
  }

  setIgnoreSslWarning(on: boolean): void {
    this.ignoreSslWarning = on
    this.flushKey('ignoreSslWarning', on)
  }

  setHomeBgColor(color: string): void {
    this.homeBgColor = color
    this.flushKey('homeBgColor', color)
  }

  setHomeLogoText(text: string): void {
    const value = text.trim() !== '' ? text : 'VIA'
    this.homeLogoText = value
    this.flushKey('homeLogoText', value)
  }

  setHomeLogoSize(index: number): void {
    this.homeLogoSize = index
    this.flushKey('homeLogoSize', index)
  }

  setHomeLogoStyle(index: number): void {
    this.homeLogoStyle = index
    this.flushKey('homeLogoStyle', index)
  }

  setHomePillCorner(index: number): void {
    this.homePillCorner = index
    this.flushKey('homePillCorner', index)
  }

  setHomePillOpacity(index: number): void {
    this.homePillOpacity = index
    this.flushKey('homePillOpacity', index)
  }

  setHomePillStrokeWidth(index: number): void {
    this.homePillStrokeWidth = index
    this.flushKey('homePillStrokeWidth', index)
  }

  setHomePillStrokeOpacity(index: number): void {
    this.homePillStrokeOpacity = index
    this.flushKey('homePillStrokeOpacity', index)
  }

  setHomePillStyle(index: number): void {
    this.homePillStyle = index
    this.flushKey('homePillStyle', index)
  }

  setHomeFavSize(index: number): void {
    this.homeFavSize = index
    this.flushKey('homeFavSize', index)
  }

  setHomeFavCorner(index: number): void {
    this.homeFavCorner = index
    this.flushKey('homeFavCorner', index)
  }

  setHomeFavColor(index: number): void {
    this.homeFavColor = index
    this.flushKey('homeFavColor', index)
  }

  setHomeFavIconStyle(index: number): void {
    this.homeFavIconStyle = index
    this.flushKey('homeFavIconStyle', index)
  }

  setHomeAdvEffect(index: number): void {
    this.homeAdvEffect = index
    this.flushKey('homeAdvEffect', index)
  }

  setHomeAdvArea(index: number): void {
    this.homeAdvArea = index
    this.flushKey('homeAdvArea', index)
  }

  resetHomeStyle(): void {
    this.setHomeBgColor('')
    this.setHomeLogoText('VIA')
    this.setHomeLogoSize(0)
    this.setHomeLogoStyle(3)
    this.setHomePillCorner(0)
    this.setHomePillOpacity(2)
    this.setHomePillStrokeWidth(2)
    this.setHomePillStrokeOpacity(2)
    this.setHomePillStyle(1)
    this.setHomeFavSize(0)
    this.setHomeFavCorner(0)
    this.setHomeFavColor(1)
    this.setHomeFavIconStyle(1)
    this.setHomeAdvEffect(1)
    this.setHomeAdvArea(0)
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

  removeSiteSetting(host: string): void {
    const next: SiteSetting[] = []
    for (let i = 0; i < this.siteSettings.length; i++) {
      if (this.siteSettings[i].host !== host) {
        next.push(this.siteSettings[i])
      }
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

  private async readSiteSettings(): Promise<SiteSetting[]> {
    const raw = await this.readString('siteSettings', '[]')
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

  private async readRules(): Promise<RuleEntry[]> {
    const raw = await this.readString('customRules', '[]')
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

  private async readScripts(): Promise<UserScriptRec[]> {
    const raw = await this.readString('userScripts', '[]')
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

  private async readStringArray(key: string): Promise<string[]> {
    const raw = await this.readString(key, '[]')
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

  async readTabsSnapshot(): Promise<SavedTab[]> {
    const raw = await this.readString('tabsSnapshot', '[]')
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

  async readTabsSnapshotIndex(): Promise<number> {
    return await this.readNumber('tabsSnapshotIndex', 0)
  }
}
