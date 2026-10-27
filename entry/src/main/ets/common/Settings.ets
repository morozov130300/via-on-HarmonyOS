import { preferences } from '@kit.ArkData'
import { window } from '@kit.ArkUI'
import { SiteSetting, RuleEntry, UserScriptRec, RuleSubEntry, RULE_SUB_PRESETS } from './Types'
import { BrowserDb } from './Database'
import { uaByKey, simplifyUaString, CustomUaEntry } from './UaTable'

export function applyOrientationSetting(context: Context): void {
  const settings = AppSettings.getInstance()
  window.getLastWindow(context).then((win: window.Window) => {
    if (settings.orientation === 1) {
      win.setPreferredOrientation(window.Orientation.PORTRAIT)
    } else if (settings.orientation === 2) {
      win.setPreferredOrientation(window.Orientation.LANDSCAPE)
    } else {
      win.setPreferredOrientation(window.Orientation.UNSPECIFIED)
    }
  }).catch(() => {
  })
}

export const UA_MODE_DEFAULT: number = 0
export const UA_MODE_PC: number = 1
export const UA_MODE_MOBILE: number = 2
export const UA_MODE_CUSTOM: number = 3

export const PC_UA: string = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36'
export const MOBILE_UA: string = 'Mozilla/5.0 (Linux; Android 13) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36'

const SNAPSHOT_TS_KEY: string = 'via_snapshot_ts'
const SYNC_KEYS: string[] = [
  'engineKey', 'customEngineTemplate', 'adBlockOn', 'textZoom', 'nightMode',
  'uaMode', 'customUa', 'noImage', 'homepageMode', 'homeUrl',
  'ruleSubUrl', 'scriptEnabled', 'doNotTrack', 'disableWebRtc', 'doNotSell',
  'dataSaver', 'autoSniffButton', 'allowDebugWeb', 'disableCustomTabs',
  'disableSafeBrowsing', 'ignoreSslWarning',
  'homeBgColor', 'homeLogoText', 'homeLogoType', 'homeLogoSize', 'homeLogoStyle',
  'homeLogoWidth', 'homeLogoHeight', 'homeLogoCorner', 'homeBgImage',
  'homePillCorner', 'homePillOpacity', 'homePillStrokeWidth', 'homePillStrokeOpacity',
  'homePillStyle', 'homeFavSize', 'homeFavCorner', 'homeFavColor', 'homeFavIconStyle',
  'homeFavWidth', 'homeFavHeight',
  'homeAdvEffect', 'homeAdvArea',
  'readerAuto', 'customCss', 'appLanguage', 'menuHidden', 'longPressHidden',
  'menuOrder', 'toolbarHidden', 'scriptAutoUpdate', 'aiProvider', 'aiModel',
  'nightForceDark', 'readerConfirm', 'readerTheme', 'readerFontSize', 'readerCustomCss',
  'appLayout', 'toolbarAutoHide', 'tabBarEnabled', 'addressBarContent', 'toolbarColorAdapt',
  'searchHistory', 'customRules', 'userScripts', 'siteSettings',
  'customRulesText', 'siteExceptions', 'desktopAllSites', 'forceZoom',
  'uaKey', 'customUaList', 'desktopUaKey', 'simplifyUa',
  'syncMode', 'orientation', 'externalPlayer', 'clearOnExit',
  'volumePageFlip', 'swipeSwitchTab', 'undoCloseToast', 'showStatusBar'
]
const SNAPSHOT_DEBOUNCE_MS: number = 1500
const AD_BLOCK_ESTIMATED_BYTES: number = 20 * 1024

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
  private snapshotTimer: number = -1
  private applyingSnapshot: boolean = false

  @Trace engineKey: string = 'baidu'
  @Trace customEngineTemplate: string = ''
  @Trace adBlockOn: boolean = true
  @Trace adBlockBuiltin: boolean = true
  @Trace adBlockTotal: number = 0
  @Trace adBlockSavedBytes: number = 0
  @Trace autoExpandFullText: boolean = true
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
  @Trace customRulesText: string = ''
  @Trace siteExceptions: string[] = []
  @Trace desktopAllSites: number = 0
  @Trace forceZoom: boolean = false
  @Trace userScripts: UserScriptRec[] = []
  @Trace scriptNextId: number = 1
  @Trace ruleSubUrl: string = ''
  @Trace ruleSubscriptions: RuleSubEntry[] = []
  @Trace ruleAutoUpdate: number = 0
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
  @Trace homeLogoType: number = 0
  @Trace homeLogoSize: number = 0
  @Trace homeLogoStyle: number = 3
  @Trace homePillCorner: number = 0
  @Trace homePillOpacity: number = 0
  @Trace homePillStrokeWidth: number = 1
  @Trace homePillStrokeOpacity: number = 1
  @Trace homePillStyle: number = 0
  @Trace homeLogoWidth: number = 0
  @Trace homeLogoHeight: number = 0
  @Trace homeLogoCorner: number = 1
  @Trace homeBgImage: string = ''
  @Trace homeFavSize: number = 0
  @Trace homeFavCorner: number = 0
  @Trace homeFavWidth: number = 1
  @Trace homeFavHeight: number = 0
  @Trace homeFavColor: number = 1
  @Trace homeFavIconStyle: number = 1
  @Trace homeAdvEffect: number = 1
  @Trace homeAdvArea: number = 0
  @Trace readerAuto: boolean = false
  @Trace customCss: string = ''
  @Trace nightForceDark: boolean = false
  @Trace readerConfirm: boolean = false
  @Trace readerTheme: number = 0
  @Trace readerFontSize: number = 17
  @Trace readerCustomCss: string = ''
  @Trace appLayout: number = 0
  @Trace toolbarAutoHide: number = 0
  @Trace tabBarEnabled: boolean = false
  @Trace addressBarContent: number = 0
  @Trace toolbarColorAdapt: boolean = true
  @Trace appLanguage: number = 1
  @Trace menuHidden: string[] = []
  // 菜单条目显示顺序（id 数组，仅含当前在菜单里的条目；
  // 空数组 = 从未定制过，使用 MenuItems.MENU_DEFAULT_ORDER 兜底）
  @Trace menuOrder: string[] = []
  @Trace longPressHidden: string[] = []
  @Trace toolbarHidden: string[] = []
  @Trace scriptAutoUpdate: boolean = false
  @Trace lastScriptUpdate: number = 0
  @Trace aiProvider: string = 'deepseek'
  @Trace aiApiKey: string = ''
  @Trace aiModel: string = 'deepseek-chat'
  @Trace uaKey: string = 'default'
  @Trace customUaList: CustomUaEntry[] = []
  @Trace desktopUaKey: string = 'win_chrome'
  @Trace simplifyUa: boolean = false
  @Trace syncMode: string = 'cloud'
  @Trace webdavUrl: string = ''
  @Trace webdavUser: string = ''
  @Trace webdavPwd: string = ''
  @Trace orientation: number = 0
  @Trace showStatusBar: boolean = true
  @Trace downloadDir: string = ''
  @Trace externalPlayer: boolean = false
  @Trace clearOnExit: string = ''
  @Trace volumePageFlip: boolean = false
  @Trace swipeSwitchTab: boolean = false
  @Trace undoCloseToast: boolean = false

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
      const db = BrowserDb.getInstance()
      const remote = await this.parseRemoteSnapshot()
      if (remote !== null) {
        await this.applySnapshot(remote)
      }
      await this.loadFields()
      db.addDataChangeListener(() => {
        this.onCloudDataChange()
      })
    } catch (error) {
      const err = error as BusinessError
      console.error(`settings init failed: ${err.code} ${err.message}`)
    }
  }

  private async loadFields(): Promise<void> {
    if (this.store === null) {
      return
    }
    try {
      this.engineKey = await this.readString('engineKey', 'baidu')
      this.customEngineTemplate = await this.readString('customEngineTemplate', '')
      this.adBlockOn = await this.readBoolean('adBlockOn', true)
      this.adBlockBuiltin = await this.readBoolean('adBlockBuiltin', true)
      this.adBlockTotal = await this.readNumber('adBlockTotal', 0)
      this.adBlockSavedBytes = await this.readNumber('adBlockSavedBytes', 0)
      this.autoExpandFullText = await this.readBoolean('autoExpandFullText', true)
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
      this.siteExceptions = await this.readStringArray('siteExceptions')
      this.desktopAllSites = await this.readNumber('desktopAllSites', 0)
      this.forceZoom = await this.readBoolean('forceZoom', false)
      this.customRules = await this.readRules()
      this.customRulesText = await this.readCustomRulesText()
      this.userScripts = await this.readScripts()
      this.scriptNextId = await this.readNumber('scriptNextId', 1)
      this.ruleSubUrl = await this.readString('ruleSubUrl', '')
      this.ruleAutoUpdate = await this.readNumber('ruleAutoUpdate', 0)
      this.ruleSubscriptions = await this.readRuleSubs()
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
      this.homeLogoType = await this.readNumber('homeLogoType', 0)
      this.homeLogoSize = await this.readNumber('homeLogoSize', 0)
      this.homeLogoStyle = await this.readNumber('homeLogoStyle', 3)
      this.homePillCorner = await this.readNumber('homePillCorner', 0)
      this.homePillOpacity = await this.readNumber('homePillOpacity', 0)
      this.homePillStrokeWidth = await this.readNumber('homePillStrokeWidth', 1)
      this.homePillStrokeOpacity = await this.readNumber('homePillStrokeOpacity', 1)
      this.homePillStyle = await this.readNumber('homePillStyle', 0)
      this.homeLogoWidth = await this.readNumber('homeLogoWidth', 0)
      this.homeLogoHeight = await this.readNumber('homeLogoHeight', 0)
      this.homeLogoCorner = await this.readNumber('homeLogoCorner', 1)
      this.homeBgImage = await this.readString('homeBgImage', '')
      this.homeFavSize = await this.readNumber('homeFavSize', 0)
      this.homeFavCorner = await this.readNumber('homeFavCorner', 0)
      this.homeFavWidth = await this.readNumber('homeFavWidth', 1)
      this.homeFavHeight = await this.readNumber('homeFavHeight', 0)
      this.homeFavColor = await this.readNumber('homeFavColor', 1)
      this.homeFavIconStyle = await this.readNumber('homeFavIconStyle', 1)
      this.homeAdvEffect = await this.readNumber('homeAdvEffect', 1)
      this.homeAdvArea = await this.readNumber('homeAdvArea', 0)
      this.readerAuto = await this.readBoolean('readerAuto', false)
      this.customCss = await this.readString('customCss', '')
      this.nightForceDark = await this.readBoolean('nightForceDark', false)
      this.readerConfirm = await this.readBoolean('readerConfirm', false)
      this.readerTheme = await this.readNumber('readerTheme', 0)
      this.readerFontSize = await this.readNumber('readerFontSize', 17)
      this.readerCustomCss = await this.readString('readerCustomCss', '')
      this.appLayout = await this.readNumber('appLayout', 0)
      this.toolbarAutoHide = await this.readNumber('toolbarAutoHide', 0)
      this.tabBarEnabled = await this.readBoolean('tabBarEnabled', false)
      this.addressBarContent = await this.readNumber('addressBarContent', 0)
      this.toolbarColorAdapt = await this.readBoolean('toolbarColorAdapt', true)
      this.appLanguage = await this.readNumber('appLanguage', 1)
      this.menuHidden = await this.readStringArray('menuHidden')
      this.menuOrder = await this.readStringArray('menuOrder')
      this.longPressHidden = await this.readStringArray('longPressHidden')
      this.toolbarHidden = await this.readStringArray('toolbarHidden')
      this.scriptAutoUpdate = await this.readBoolean('scriptAutoUpdate', false)
      this.lastScriptUpdate = await this.readNumber('lastScriptUpdate', 0)
      this.aiProvider = await this.readString('aiProvider', 'deepseek')
      this.aiApiKey = await this.readString('aiApiKey', '')
      this.aiModel = await this.readString('aiModel', 'deepseek-chat')
      this.customUaList = await this.readCustomUaList()
      this.uaKey = await this.readString('uaKey', '')
      if (this.uaKey === '') {
        if (this.uaMode === UA_MODE_PC) {
          this.uaKey = 'win_chrome'
        } else if (this.uaMode === UA_MODE_MOBILE) {
          this.uaKey = 'android_phone'
        } else if (this.uaMode === UA_MODE_CUSTOM) {
          this.uaKey = 'custom'
        } else {
          this.uaKey = 'default'
        }
        this.flushKey('uaKey', this.uaKey)
      }
      this.desktopUaKey = await this.readString('desktopUaKey', 'win_chrome')
      this.simplifyUa = await this.readBoolean('simplifyUa', false)
      this.syncMode = await this.readString('syncMode', 'cloud')
      this.webdavUrl = await this.readString('webdavUrl', '')
      this.webdavUser = await this.readString('webdavUser', '')
      this.webdavPwd = await this.readString('webdavPwd', '')
      this.orientation = await this.readNumber('orientation', 0)
      this.showStatusBar = await this.readBoolean('showStatusBar', true)
      this.downloadDir = await this.readString('downloadDir', '')
      this.externalPlayer = await this.readBoolean('externalPlayer', false)
      this.clearOnExit = await this.readString('clearOnExit', '')
      this.volumePageFlip = await this.readBoolean('volumePageFlip', false)
      this.swipeSwitchTab = await this.readBoolean('swipeSwitchTab', false)
      this.undoCloseToast = await this.readBoolean('undoCloseToast', false)
    } catch (error) {
      const err = error as BusinessError
      console.error(`settings load failed: ${err.code} ${err.message}`)
    }
  }

  private async parseRemoteSnapshot(): Promise<Record<string, Object> | null> {
    const db = BrowserDb.getInstance()
    const raw = await db.loadSettingsSnapshot()
    if (raw === '') {
      return null
    }
    try {
      const parsed = JSON.parse(raw) as Record<string, Object>
      const ts = parsed['ts']
      if (typeof ts !== 'number') {
        return null
      }
      const localTs = await this.readNumber(SNAPSHOT_TS_KEY, 0)
      if (ts <= localTs) {
        return null
      }
      return parsed
    } catch (error) {
      console.error('parse remote snapshot failed')
      return null
    }
  }

  private async applySnapshot(snapshot: Record<string, Object>): Promise<void> {
    if (this.store === null) {
      return
    }
    this.applyingSnapshot = true
    try {
      const kv = snapshot['kv']
      if (typeof kv === 'object' && kv !== null) {
        const pairs = kv as Record<string, Object>
        for (let i = 0; i < SYNC_KEYS.length; i++) {
          const key = SYNC_KEYS[i]
          const value = pairs[key]
          if (value !== undefined) {
            await this.store.put(key, value as preferences.ValueType)
          }
        }
        const ts = snapshot['ts']
        if (typeof ts === 'number') {
          await this.store.put(SNAPSHOT_TS_KEY, ts)
        }
        await this.store.flush()
      }
    } catch (error) {
      console.error('apply snapshot failed')
    } finally {
      this.applyingSnapshot = false
    }
  }

  private async onCloudDataChange(): Promise<void> {
    if (this.applyingSnapshot) {
      return
    }
    const remote = await this.parseRemoteSnapshot()
    if (remote !== null) {
      await this.applySnapshot(remote)
      await this.loadFields()
    }
  }

  async applyBackupKv(kv: Record<string, Object>): Promise<void> {
    const snapshot: Record<string, Object> = {}
    snapshot['ts'] = Date.now()
    snapshot['kv'] = kv
    await this.applySnapshot(snapshot)
    await this.loadFields()
  }

  private scheduleSnapshot(): void {
    if (this.snapshotTimer >= 0) {
      clearTimeout(this.snapshotTimer)
    }
    this.snapshotTimer = setTimeout(() => {
      this.snapshotTimer = -1
      this.writeSnapshot()
    }, SNAPSHOT_DEBOUNCE_MS)
  }

  private async writeSnapshot(): Promise<void> {
    if (this.store === null || this.applyingSnapshot) {
      return
    }
    try {
      const kv = await this.buildSyncKv()
      const ts = Date.now()
      kv[SNAPSHOT_TS_KEY] = ts
      await this.store.put(SNAPSHOT_TS_KEY, ts)
      await this.store.flush()
      const snapshot: Record<string, Object> = {}
      snapshot['ts'] = ts
      snapshot['kv'] = kv
      await BrowserDb.getInstance().saveSettingsSnapshot(JSON.stringify(snapshot))
    } catch (error) {
      console.error('write snapshot failed')
    }
  }

  async buildSyncKv(): Promise<Record<string, Object>> {
    const kv: Record<string, Object> = {}
    if (this.store === null) {
      return kv
    }
    for (let i = 0; i < SYNC_KEYS.length; i++) {
      const key = SYNC_KEYS[i]
      const value = await this.store.get(key, '')
      kv[key] = value as Object
    }
    return kv
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
    if (SYNC_KEYS.indexOf(key) >= 0) {
      this.scheduleSnapshot()
    }
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

  setAdBlockBuiltin(on: boolean): void {
    this.adBlockBuiltin = on
    this.flushKey('adBlockBuiltin', on)
  }

  setAutoExpandFullText(on: boolean): void {
    this.autoExpandFullText = on
    this.flushKey('autoExpandFullText', on)
  }

  addAdBlocked(count: number): void {
    this.adBlockTotal = this.adBlockTotal + count
    // ArkWeb 拦截请求拿不到响应体积，按单个广告请求平均约 20KB 估算节省流量
    this.adBlockSavedBytes = this.adBlockSavedBytes + count * AD_BLOCK_ESTIMATED_BYTES
    if (this.store !== null) {
      this.store.put('adBlockTotal', this.adBlockTotal).catch((error: BusinessError) => {
        console.error(`settings put adBlockTotal failed: ${error.message}`)
      })
      this.store.put('adBlockSavedBytes', this.adBlockSavedBytes).catch((error: BusinessError) => {
        console.error(`settings put adBlockSavedBytes failed: ${error.message}`)
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

  private async readRuleSubs(): Promise<RuleSubEntry[]> {
    const result: RuleSubEntry[] = []
    for (let i = 0; i < RULE_SUB_PRESETS.length; i++) {
      const p = RULE_SUB_PRESETS[i]
      result.push(new RuleSubEntry(p.key, p.name, p.url, p.enabled, p.ruleCount, p.lastUpdate, p.isPreset))
    }
    const raw = await this.readString('ruleSubscriptions', '')
    if (raw === '') {
      return result
    }
    try {
      const arr = JSON.parse(raw) as Object[]
      for (let i = 0; i < arr.length; i++) {
        const obj = arr[i] as Record<string, Object>
        const key = obj['key']
        if (typeof key !== 'string') {
          continue
        }
        const name = typeof obj['name'] === 'string' ? obj['name'] as string : ''
        const url = typeof obj['url'] === 'string' ? obj['url'] as string : ''
        const enabled = typeof obj['enabled'] === 'boolean' ? obj['enabled'] as boolean : false
        const ruleCount = typeof obj['ruleCount'] === 'number' ? obj['ruleCount'] as number : 0
        const lastUpdate = typeof obj['lastUpdate'] === 'number' ? obj['lastUpdate'] as number : 0
        const isPreset = typeof obj['isPreset'] === 'boolean' ? obj['isPreset'] as boolean : false
        const existing = result.find((s: RuleSubEntry): boolean => s.key === key)
        if (existing !== undefined) {
          existing.enabled = enabled
          existing.ruleCount = ruleCount
          existing.lastUpdate = lastUpdate
        } else {
          result.push(new RuleSubEntry(key, name, url, enabled, ruleCount, lastUpdate, isPreset))
        }
      }
    } catch (error) {
      console.error('parse ruleSubscriptions failed')
    }
    return result
  }

  private saveRuleSubs(): void {
    const payload = this.ruleSubscriptions.map((s: RuleSubEntry): Record<string, Object> => {
      return { 'key': s.key, 'name': s.name, 'url': s.url, 'enabled': s.enabled, 'ruleCount': s.ruleCount, 'lastUpdate': s.lastUpdate, 'isPreset': s.isPreset } as Record<string, Object>
    })
    this.flushKey('ruleSubscriptions', JSON.stringify(payload))
  }

  setRuleSubEnabled(key: string, enabled: boolean): void {
    const sub = this.ruleSubscriptions.find((s: RuleSubEntry): boolean => s.key === key)
    if (sub !== undefined) {
      sub.enabled = enabled
      this.saveRuleSubs()
    }
  }

  updateRuleSubEntry(key: string, ruleCount: number, lastUpdate: number): void {
    const sub = this.ruleSubscriptions.find((s: RuleSubEntry): boolean => s.key === key)
    if (sub !== undefined) {
      sub.ruleCount = ruleCount
      sub.lastUpdate = lastUpdate
      this.saveRuleSubs()
    }
  }

  addRuleSub(name: string, url: string): void {
    this.ruleSubscriptions.push(new RuleSubEntry(`c${Date.now()}`, name, url, false, 0, 0, false))
    this.saveRuleSubs()
  }

  removeRuleSub(key: string): void {
    const next: RuleSubEntry[] = []
    for (let i = 0; i < this.ruleSubscriptions.length; i++) {
      if (this.ruleSubscriptions[i].key !== key) {
        next.push(this.ruleSubscriptions[i])
      }
    }
    this.ruleSubscriptions = next
    this.saveRuleSubs()
  }

  setRuleAutoUpdate(days: number): void {
    this.ruleAutoUpdate = days
    this.flushKey('ruleAutoUpdate', days)
  }

  setTextZoom(zoom: number): void {
    this.textZoom = zoom
    this.flushKey('textZoom', zoom)
  }

  setNightMode(on: boolean): void {
    this.nightMode = on
    this.flushKey('nightMode', on)
  }

  setNightForceDark(on: boolean): void {
    this.nightForceDark = on
    this.flushKey('nightForceDark', on)
  }

  setReaderConfirm(on: boolean): void {
    this.readerConfirm = on
    this.flushKey('readerConfirm', on)
  }

  setReaderTheme(theme: number): void {
    this.readerTheme = theme
    this.flushKey('readerTheme', theme)
  }

  setReaderFontSize(size: number): void {
    this.readerFontSize = size
    this.flushKey('readerFontSize', size)
  }

  setReaderCustomCss(css: string): void {
    this.readerCustomCss = css
    this.flushKey('readerCustomCss', css)
  }

  setAppLayout(layout: number): void {
    this.appLayout = layout
    this.flushKey('appLayout', layout)
  }

  setToolbarAutoHide(mode: number): void {
    this.toolbarAutoHide = mode
    this.flushKey('toolbarAutoHide', mode)
  }

  setTabBarEnabled(on: boolean): void {
    this.tabBarEnabled = on
    this.flushKey('tabBarEnabled', on)
  }

  setAddressBarContent(mode: number): void {
    this.addressBarContent = mode
    this.flushKey('addressBarContent', mode)
  }

  setToolbarColorAdapt(on: boolean): void {
    this.toolbarColorAdapt = on
    this.flushKey('toolbarColorAdapt', on)
  }

  setUaMode(mode: number): void {
    this.uaMode = mode
    this.flushKey('uaMode', mode)
  }

  setCustomUa(ua: string): void {
    this.customUa = ua
    this.flushKey('customUa', ua)
  }

  setUaKey(key: string): void {
    this.uaKey = key
    this.flushKey('uaKey', key)
  }

  setDesktopUaKey(key: string): void {
    this.desktopUaKey = key
    this.flushKey('desktopUaKey', key)
  }

  setSimplifyUa(on: boolean): void {
    this.simplifyUa = on
    this.flushKey('simplifyUa', on)
  }

  saveCustomUaEntry(entry: CustomUaEntry): void {
    const next: CustomUaEntry[] = []
    let replaced = false
    for (let i = 0; i < this.customUaList.length; i++) {
      if (this.customUaList[i].title === entry.title) {
        next.push(entry)
        replaced = true
      } else {
        next.push(this.customUaList[i])
      }
    }
    if (!replaced) {
      next.push(entry)
    }
    this.customUaList = next
    this.persistCustomUaList()
  }

  removeCustomUaEntry(title: string): void {
    const next: CustomUaEntry[] = []
    for (let i = 0; i < this.customUaList.length; i++) {
      if (this.customUaList[i].title !== title) {
        next.push(this.customUaList[i])
      }
    }
    this.customUaList = next
    this.persistCustomUaList()
  }

  private persistCustomUaList(): void {
    const payload: Record<string, Object>[] = []
    for (let i = 0; i < this.customUaList.length; i++) {
      const entry: Record<string, Object> = {}
      entry['title'] = this.customUaList[i].title
      entry['ua'] = this.customUaList[i].ua
      payload.push(entry)
    }
    this.flushKey('customUaList', JSON.stringify(payload))
  }

  private async readCustomUaList(): Promise<CustomUaEntry[]> {
    const raw = await this.readString('customUaList', '[]')
    const result: CustomUaEntry[] = []
    try {
      const parsed = JSON.parse(raw) as Object[]
      for (let i = 0; i < parsed.length; i++) {
        const element = parsed[i] as Record<string, Object>
        const item = CustomUaEntry.fromJson(element)
        if (item !== null) {
          result.push(item)
        }
      }
    } catch (error) {
      console.error('parse customUaList failed')
    }
    return result
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

  setHomeBgImage(uri: string): void {
    this.homeBgImage = uri
    this.flushKey('homeBgImage', uri)
  }

  setHomeLogoWidth(index: number): void {
    this.homeLogoWidth = index
    this.flushKey('homeLogoWidth', index)
  }

  setHomeLogoHeight(index: number): void {
    this.homeLogoHeight = index
    this.flushKey('homeLogoHeight', index)
  }

  setHomeLogoCorner(index: number): void {
    this.homeLogoCorner = index
    this.flushKey('homeLogoCorner', index)
  }

  setHomeFavWidth(index: number): void {
    this.homeFavWidth = index
    this.flushKey('homeFavWidth', index)
  }

  setHomeFavHeight(index: number): void {
    this.homeFavHeight = index
    this.flushKey('homeFavHeight', index)
  }

  setHomeLogoText(text: string): void {
    const value = text.trim() !== '' ? text : 'VIA'
    this.homeLogoText = value
    this.flushKey('homeLogoText', value)
  }

  setHomeLogoType(index: number): void {
    this.homeLogoType = index
    this.flushKey('homeLogoType', index)
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

  setReaderAuto(on: boolean): void {
    this.readerAuto = on
    this.flushKey('readerAuto', on)
  }

  setCustomCss(css: string): void {
    this.customCss = css
    this.flushKey('customCss', css)
  }

  setAppLanguage(index: number): void {
    this.appLanguage = index
    this.flushKey('appLanguage', index)
  }

  setMenuHidden(list: string[]): void {
    this.menuHidden = list
    this.flushKey('menuHidden', JSON.stringify(list))
  }

  setMenuOrder(list: string[]): void {
    this.menuOrder = list
    this.flushKey('menuOrder', JSON.stringify(list))
  }

  setLongPressHidden(list: string[]): void {
    this.longPressHidden = list
    this.flushKey('longPressHidden', JSON.stringify(list))
  }

  setToolbarHidden(list: string[]): void {
    this.toolbarHidden = list
    this.flushKey('toolbarHidden', JSON.stringify(list))
  }

  setScriptAutoUpdate(on: boolean): void {
    this.scriptAutoUpdate = on
    this.flushKey('scriptAutoUpdate', on)
  }

  markScriptsUpdated(): void {
    this.lastScriptUpdate = Date.now()
    this.flushKey('lastScriptUpdate', this.lastScriptUpdate)
  }

  setAiProvider(provider: string): void {
    this.aiProvider = provider
    this.flushKey('aiProvider', provider)
  }

  setAiApiKey(key: string): void {
    this.aiApiKey = key
    this.flushKey('aiApiKey', key)
  }

  setAiModel(model: string): void {
    this.aiModel = model
    this.flushKey('aiModel', model)
  }

  setSyncMode(mode: string): void {
    this.syncMode = mode
    this.flushKey('syncMode', mode)
  }

  setWebdavUrl(url: string): void {
    this.webdavUrl = url
    this.flushKey('webdavUrl', url)
  }

  setWebdavUser(user: string): void {
    this.webdavUser = user
    this.flushKey('webdavUser', user)
  }

  setWebdavPwd(pwd: string): void {
    this.webdavPwd = pwd
    this.flushKey('webdavPwd', pwd)
  }

  setOrientation(value: number): void {
    this.orientation = value
    this.flushKey('orientation', value)
  }

  setShowStatusBar(on: boolean): void {
    this.showStatusBar = on
    this.flushKey('showStatusBar', on)
  }

  setDownloadDir(dir: string): void {
    this.downloadDir = dir
    this.flushKey('downloadDir', dir)
  }

  setExternalPlayer(on: boolean): void {
    this.externalPlayer = on
    this.flushKey('externalPlayer', on)
  }

  setClearOnExit(flags: string): void {
    this.clearOnExit = flags
    this.flushKey('clearOnExit', flags)
  }

  setVolumePageFlip(on: boolean): void {
    this.volumePageFlip = on
    this.flushKey('volumePageFlip', on)
  }

  setSwipeSwitchTab(on: boolean): void {
    this.swipeSwitchTab = on
    this.flushKey('swipeSwitchTab', on)
  }

  setUndoCloseToast(on: boolean): void {
    this.undoCloseToast = on
    this.flushKey('undoCloseToast', on)
  }

  resetHomeStyle(): void {
    this.setHomeBgColor('')
    this.setHomeBgImage('')
    this.setHomeLogoText('VIA')
    this.setHomeLogoType(0)
    this.setHomeLogoSize(0)
    this.setHomeLogoStyle(3)
    this.setHomeLogoWidth(0)
    this.setHomeLogoHeight(0)
    this.setHomeLogoCorner(1)
    this.setHomePillCorner(0)
    this.setHomePillOpacity(0)
    this.setHomePillStrokeWidth(1)
    this.setHomePillStrokeOpacity(1)
    this.setHomePillStyle(0)
    this.setHomeFavSize(0)
    this.setHomeFavCorner(0)
    this.setHomeFavWidth(1)
    this.setHomeFavHeight(0)
    this.setHomeFavColor(0)
    this.setHomeFavIconStyle(0)
    this.setHomeAdvEffect(1)
    this.setHomeAdvArea(0)
  }

  uaForHost(host: string): string | null {
    const site = this.getSiteSetting(host)
    if (this.desktopAllSites === 1) {
      const globalDef = uaByKey(this.desktopUaKey)
      return globalDef !== null ? globalDef.ua : null
    }
    let key = this.uaKey
    if (site !== null && site.pcMode) {
      key = this.desktopUaKey
    }
    let ua: string | null = null
    if (key === 'custom') {
      ua = this.customUa !== '' ? this.customUa : null
    } else {
      const def = uaByKey(key)
      ua = def !== null ? def.ua : null
    }
    if (ua === null) {
      return null
    }
    if (this.simplifyUa) {
      return simplifyUaString(ua)
    }
    return ua
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

  private async readCustomRulesText(): Promise<string> {
    const raw = await this.readString('customRulesText', '')
    if (raw !== '') {
      return raw
    }
    // 旧版本仅存结构化规则时，从规则数组合成文本
    const lines: string[] = []
    for (let i = 0; i < this.customRules.length; i++) {
      lines.push(this.customRules[i].isAllow ? `@@||${this.customRules[i].domain}^` : `||${this.customRules[i].domain}^`)
    }
    return lines.join('\n')
  }

  setCustomRulesText(text: string): void {
    this.customRulesText = text
    this.flushKey('customRulesText', text)
    const next: RuleEntry[] = []
    const lines = text.split('\n')
    for (let i = 0; i < lines.length; i++) {
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
        let duplicated = false
        for (let j = 0; j < next.length; j++) {
          if (next[j].domain === host && next[j].isAllow === isAllow) {
            duplicated = true
            break
          }
        }
        if (!duplicated) {
          next.push(new RuleEntry(host, isAllow))
        }
      }
    }
    this.customRules = next
    this.flushKey('customRules', JSON.stringify(next.map((r: RuleEntry): Record<string, Object> => {
      return { 'domain': r.domain, 'isAllow': r.isAllow } as Record<string, Object>
    })))
  }

  getExceptions(kind: string): string[] {
    const result: string[] = []
    for (let i = 0; i < this.siteExceptions.length; i++) {
      const item = this.siteExceptions[i]
      if (item.startsWith(kind + '|')) {
        result.push(item.substring(kind.length + 1))
      }
    }
    return result
  }

  addException(kind: string, host: string): void {
    const value = kind + '|' + host
    if (this.siteExceptions.indexOf(value) >= 0) {
      return
    }
    const next = this.siteExceptions.slice(0)
    next.push(value)
    this.siteExceptions = next
    this.flushKey('siteExceptions', JSON.stringify(next))
  }

  removeException(kind: string, host: string): void {
    const value = kind + '|' + host
    const next: string[] = []
    for (let i = 0; i < this.siteExceptions.length; i++) {
      if (this.siteExceptions[i] !== value) {
        next.push(this.siteExceptions[i])
      }
    }
    this.siteExceptions = next
    this.flushKey('siteExceptions', JSON.stringify(next))
  }

  setDesktopAllSites(value: number): void {
    this.desktopAllSites = value
    this.flushKey('desktopAllSites', value)
  }

  setForceZoom(on: boolean): void {
    this.forceZoom = on
    this.flushKey('forceZoom', on)
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
      entry['sourceUrl'] = item.sourceUrl
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
