import { preferences } from '@kit.ArkData'
import { window } from '@kit.ArkUI'
import { ConfigurationConstant, common } from '@kit.AbilityKit'
import { resourceManager, i18n } from '@kit.LocalizationKit'
import { SiteSetting, RuleEntry, UserScriptRec, RuleSubEntry, RULE_SUB_PRESETS } from './Types'
import { builtinEngineId } from './SearchEngines'
import { BrowserDb } from './Database'
import { uaByKey, simplifyUaString, CustomUaEntry } from './UaTable'

// 原版 f4/Q0 语义：orientation 存 1..4（1=跟随系统 2=自动 3=竖屏 4=横屏）
export function applyOrientationSetting(context: Context): void {
  const settings = AppSettings.getInstance()
  window.getLastWindow(context).then((win: window.Window) => {
    if (settings.orientation === 3) {
      win.setPreferredOrientation(window.Orientation.PORTRAIT)
    } else if (settings.orientation === 4) {
      win.setPreferredOrientation(window.Orientation.LANDSCAPE)
    } else if (settings.orientation === 2) {
      win.setPreferredOrientation(window.Orientation.AUTO_ROTATION)
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
  'engineKey', 'customEngineTemplate', 'customEngines', 'searchsuggestion', 'adBlockOn', 'textZoom', 'nightMode2', 'nightFilter', 'nightCss',
  'uaMode', 'customUa', 'noImage', 'homepageMode', 'homeUrl',
  'ruleSubUrl', 'scriptEnabled', 'doNotTrack', 'disableWebRtc', 'doNotSell', 'privacyProxy',
  'dataSaver', 'autoSniffButton', 'allowDebugWeb', 'disableCustomTabs',
  'disableSafeBrowsing', 'ignoreSslWarning',
  'homeBgColor', 'homeLogoText', 'homeLogoType', 'homeLogoSize', 'homeLogoStyle',
  'homeLogoWidth', 'homeLogoHeight', 'homeLogoCorner', 'homeBgImage',
  'homeLogoImage', 'homeLogoHtml',
  'homePillCorner', 'homePillOpacity', 'homePillStrokeWidth', 'homePillStrokeOpacity',
  'homePillStyle', 'homeFavCorner', 'homeFavShadow', 'homeFavIconStyle',
  'homeFavWidth', 'homeFavHeight',
  'homeBgOpacity', 'homeThemeColor', 'homeIconEpoch',
  'homeAdvEffect', 'homeAdvArea',
  'readerAuto', 'customCss', 'appLanguage', 'menuHidden', 'longPressHidden',
  'menuOrder', 'toolbarHidden', 'scriptAutoUpdate', 'aibackend', 'aimodel',
  'readerConfirm', 'readerTheme', 'readerFontSize', 'readerCustomCss',
  'appLayout', 'toolbarAutoHide', 'tabBarEnabled', 'addressBarContent', 'toolbarColorAdapt',
  'searchHistory', 'customRules', 'userScripts', 'siteSettings',
  'customRulesText', 'siteExceptions', 'desktopAllSites', 'forceZoom', 'siteFontZooms',
  'uaKey', 'customUaList', 'desktopUaKey', 'desktopCustomUa', 'simplifyUa',
  'syncMode', 'orientation', 'videoPlayer', 'dlManager', 'clearOnExit',
  'volumePageFlip', 'swipeSwitchTab', 'videoGesture', 'videoorientation', 'uifont', 'undoCloseToast', 'showStatusBar',
  'skin',
  'fullScreen', 'gameMode', 'wifiOnlyImages', 'cleardata2', 'labflag',
  'jsEnabled',
  'searchToolbarEnabled', 'searchToolbarOrder', 'searchToolbarDisabled',
  'keyback', 'keyforward', 'keyhome', 'keytab', 'keymenu',
  'gesturetoolbarleft', 'gesturetoolbarright', 'restoreclosedtabs', 'scriptNextId',
  'readaloudspeed'
]
const SNAPSHOT_DEBOUNCE_MS: number = 1500
const AD_BLOCK_ESTIMATED_BYTES: number = 20 * 1024

export class SavedTab {
  url: string
  incognito: boolean
  // 原版 tabs 表 title（na/c.java:24）：恢复标签需回填标题
  title: string = ''

  constructor(url: string, incognito: boolean, title: string = '') {
    this.url = url
    this.incognito = incognito
    this.title = title
  }
}

// 自定义搜索引擎记录（原版 settings 表 type=2 行：title=名称、content=URL 模板；
// id=记录主键（原版 ja/c.d()，DB 自增 ≥1），用于 search2/searchtoolbarorder 等引擎 id 引用
export class CustomEngineRec {
  name: string
  template: string
  id: number

  constructor(name: string, template: string, id: number = 0) {
    this.name = name
    this.template = template
    this.id = id
  }
}

// 原版 z8/v2.a()：默认搜索引擎 = CN（中文）环境百度，否则谷歌
export function defaultEngineKeyForSystem(): string {
  try {
    const lang = i18n.System.getSystemLanguage()
    return lang.startsWith('zh') ? 'baidu' : 'google'
  } catch (error) {
    return 'baidu'
  }
}

@ObservedV2
export class AppSettings {
  private static instance: AppSettings | null = null
  private store: preferences.Preferences | null = null
  private appContext: common.ApplicationContext | null = null
  private lastAppliedColorMode: ConfigurationConstant.ColorMode = ConfigurationConstant.ColorMode.COLOR_MODE_NOT_SET
  // 原版 w9.k：工具栏按钮长按动作（keyback/keyforward/keyhome/keytab/keymenu）
  @Trace keyback: number = 2
  @Trace keyforward: number = 3
  @Trace keyhome: number = 4
  @Trace keytab: number = 5
  @Trace keymenu: number = 1
  // 原版 w9.k：工具栏横滑左右方向动作（gesturetoolbarleft=10 上一标签 / gesturetoolbarright=11 下一标签）
  @Trace gesturetoolbarleft: number = 10
  @Trace gesturetoolbarright: number = 11
  private abilityContext: common.UIAbilityContext | null = null
  private nightListeners: Array<() => void> = []
  private snapshotTimer: number = -1
  private applyingSnapshot: boolean = false

  @Trace engineKey: string = 'baidu'
  @Trace customEngineTemplate: string = ''
  // 原版 ja/c（settings 表 type=2）：多个自定义搜索引擎（名称 + URL 模板），id 为列表下标
  @Trace customEngines: CustomEngineRec[] = []
  // 原版 w9/k.X1()：searchsuggestion 位掩码，默认 31（1 标签页|2 书签|4 自定义|8 历史|16 网络建议）
  @Trace searchSuggestion: number = 31
  @Trace adBlockOn: boolean = false
  @Trace adBlockBuiltin: boolean = true
  @Trace adBlockTotal: number = 0
  @Trace adBlockSavedBytes: number = 0
  @Trace autoExpandFullText: boolean = false
  @Trace textZoom: number = 100
  // 原版 nightmode2（w9/k n3/d/m0/T0）：0=手动关 1=手动开 2=跟随系统(当前浅) 3=跟随系统(当前深)，默认 2
  @Trace nightMode2: number = 2
  // 原版 nightfilter（w9/k n2/Y0）：网页蒙版黑色滤镜不透明度，默认 77
  @Trace nightFilter: number = 77
  // 原版 nightcss「强制网页暗色」（w9/k S2），默认取 Webview forceDark 可用性（现代内核恒 true）
  @Trace nightCss: boolean = true
  @Trace uaMode: number = UA_MODE_DEFAULT
  @Trace customUa: string = ''
  @Trace noImage: boolean = false
  @Trace restoreTabsMode: number = 0
  @Trace homepageMode: number = 0
  @Trace homeUrl: string = ''
  @Trace searchHistory: string[] = []
  @Trace siteSettings: SiteSetting[] = []
  @Trace customRules: RuleEntry[] = []
  @Trace customRulesText: string = ''
  @Trace siteExceptions: string[] = []
  @Trace desktopAllSites: number = 0
  @Trace forceZoom: boolean = false
  // 原版 jb/l5.n()：每站字体缩放 map（站点 DB 行 s()+d0(zoom)），host → 缩放百分比
  @Trace siteFontZooms: Map<string, number> = new Map()
  @Trace userScripts: UserScriptRec[] = []
  @Trace scriptNextId: number = 1
  @Trace ruleSubUrl: string = ''
  @Trace ruleSubscriptions: RuleSubEntry[] = []
  @Trace ruleAutoUpdate: number = 0
  @Trace scriptEnabled: boolean = false
  // 原版 w9/k.t（网站设定 JavaScript 全局默认，jb/y4 id8），默认允许
  @Trace jsEnabled: boolean = true
  // 原版 w9/k.O()：朗读语速（readaloudspeed，存储 int(speed*100)），范围 0.25-5.0
  @Trace readAloudSpeed: number = 1.0
  @Trace doNotTrack: boolean = false
  @Trace disableWebRtc: boolean = false
  @Trace doNotSell: boolean = false
  @Trace privacyProxy: boolean = false
  @Trace dataSaver: boolean = false
  @Trace autoSniffButton: boolean = false
  @Trace allowDebugWeb: boolean = false
  @Trace disableCustomTabs: boolean = false
  @Trace disableSafeBrowsing: boolean = false
  @Trace ignoreSslWarning: boolean = false
  @Trace homeBgColor: string = ''
  @Trace homeLogoText: string = 'VIA'
  @Trace homeLogoType: number = 0
  @Trace homeLogoSize: number = 28
  @Trace homeLogoStyle: number = 1
  @Trace homePillCorner: number = 100
  @Trace homePillOpacity: number = 0
  @Trace homePillStrokeWidth: number = 1
  @Trace homePillStrokeOpacity: number = 24
  @Trace homePillStyle: number = 0
  @Trace homeLogoWidth: number = 0
  @Trace homeLogoHeight: number = 0
  @Trace homeLogoCorner: number = 50
  @Trace homeBgImage: string = ''
  @Trace homeLogoImage: string = ''
  @Trace homeLogoHtml: string = ''
  @Trace homeFavCorner: number = 100
  @Trace homeFavShadow: number = 0
  @Trace homeFavWidth: number = 0
  @Trace homeFavHeight: number = 0
  @Trace homeFavIconStyle: number = 0
  @Trace homeBgOpacity: number = 0
  @Trace homeThemeColor: string = ''
  @Trace homeIconEpoch: number = 0
  @Trace homeAdvEffect: number = 0
  @Trace homeAdvArea: number = 0
  @Trace readerAuto: boolean = false
  @Trace customCss: string = ''
  @Trace readerConfirm: boolean = false
  @Trace readerTheme: number = 0
  @Trace readerFontSize: number = 17
  @Trace readerCustomCss: string = ''
  @Trace appLayout: number = 0
  @Trace toolbarAutoHide: number = 0
  @Trace tabBarEnabled: boolean = false
  // 搜索工具栏（原版 w9.a bit32768 默认启用；searchtoolbarorder/searchtoolbardisabled
  // 为引擎 id 逗号串，默认禁用表 "-1,-10"）
  @Trace searchToolbarEnabled: boolean = true
  @Trace searchToolbarOrder: string = ''
  @Trace searchToolbarDisabled: string = '-1,-10'
  @Trace addressBarContent: number = 0
  @Trace toolbarColorAdapt: boolean = true
  @Trace appLanguage: number = 1
  @Trace menuHidden: string[] = []
  // 菜单条目显示顺序（id 数组，仅含当前在菜单里的条目；
  // 空数组 = 从未定制过，使用 MenuItems.MENU_DEFAULT_ORDER 兜底）
  @Trace menuOrder: string[] = []
  @Trace longPressHidden: string[] = []
  @Trace toolbarHidden: string[] = []
  @Trace scriptAutoUpdate: number = 0
  @Trace lastScriptUpdate: number = 0
  // 原版 w9/k.n0()/H0()（键名 aibackend）：当前 AI 服务商 id，空 = 未设置（默认 null）
  @Trace aiBackend: string = ''
  // 原版 w9/k.K0()（键名 aimodel）：当前模型 id，空 = 未设置（默认 null）
  @Trace aiModel: string = ''
  @Trace uaKey: string = 'default'
  @Trace customUaList: CustomUaEntry[] = []
  @Trace desktopUaKey: string = 'win_chrome'
  @Trace desktopCustomUa: string = ''
  @Trace simplifyUa: boolean = false
  @Trace syncMode: string = 'cloud'
  @Trace webdavUrl: string = ''
  @Trace webdavUser: string = ''
  @Trace webdavPwd: string = ''
  @Trace orientation: number = 0
  @Trace showStatusBar: boolean = true
  @Trace downloadDir: string = ''
  // 原版 w9/k.w0（videoplayer）：''=关闭（内置播放），'share'=系统分享；HarmonyOS 无法枚举第三方播放器
  @Trace videoPlayer: string = ''
  // 原版 w9/k.K2（dlmanager）：下载器选择，'builtin'=内建下载器
  @Trace dlManager: string = 'builtin'
  // 原版 w9/k.l（clearonexit 位掩码）：[1 缓存,2 表单数据,4 历史,64 关闭的标签页,8 网页存储,16 Cookies,32 应用缓存]
  @Trace clearOnExit: number = 0
  @Trace volumePageFlip: boolean = false
  @Trace swipeSwitchTab: boolean = true
  // 原版 w9.a.u()（appflag bit128）：启用视频播放器手势，默认开
  @Trace videoGesture: boolean = true
  // 原版 w9.k.o0()/m()（键名 videoorientation，同步键）：视频全屏方向 0=自动 1=横屏 2=竖屏 3=跟随系统
  @Trace videoOrientation: number = 0
  // 原版 w9.k.a1()/o()（键名 uifont）：网页自定义字体文件名，空 = 默认
  @Trace uiFont: string = ''
  // 原版 w9.l.L()/T1()（键名 skin）：当前皮肤目录名，空 = 默认
  @Trace skin: string = ''
  @Trace undoCloseToast: boolean = false
  // 原版 i3/k6:2806：全屏模式开关（菜单「全屏」）
  @Trace fullScreen: boolean = false
  // 原版 bb/k6:6074：游戏模式开关（菜单「游戏模式」，隐藏工具栏）
  @Trace gameMode: boolean = false
  // 原版 w9/p：位 r「仅 Wi-Fi 有图」；与 noImage（位 q 取反）共同构成图片三态
  @Trace wifiOnlyImages: boolean = false
  // 原版 cleardata2（w9/k e2）：清除数据多选位掩码，默认 7 = 缓存|表单数据|历史
  @Trace clearData2: number = 7
  // 原版 labflag（w9/d）：位1=设置根页「实验」入口（hb/o6 五连点切换）、位2=模糊效果（hb/y1）
  @Trace labFlag: number = 0

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
      this.appContext = context.getApplicationContext() as common.ApplicationContext
      this.abilityContext = context as common.UIAbilityContext
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
      this.engineKey = await this.readString('engineKey', defaultEngineKeyForSystem())
      this.customEngineTemplate = await this.readString('customEngineTemplate', '')
      this.customEngines = await this.readCustomEngines()
      // 迁移：旧版单个 customEngineTemplate → customEngines[0]
      if (this.customEngines.length === 0 && this.customEngineTemplate !== '') {
        this.customEngines = [new CustomEngineRec('自定义', this.customEngineTemplate)]
        this.persistCustomEngines()
      }
      this.searchSuggestion = await this.readNumber('searchsuggestion', 31)
      this.adBlockOn = await this.readBoolean('adBlockOn', false)
      this.adBlockBuiltin = await this.readBoolean('adBlockBuiltin', true)
      this.adBlockTotal = await this.readNumber('adBlockTotal', 0)
      this.adBlockSavedBytes = await this.readNumber('adBlockSavedBytes', 0)
      this.autoExpandFullText = await this.readBoolean('autoExpandFullText', false)
      this.textZoom = await this.readNumber('textZoom', 100)
      // 原版 nightmode2 迁移：旧布尔 nightMode → 手动开(1)/跟随系统(2)（w9/k n3 默认 2）
      const legacyNight = await this.readBoolean('nightMode', false)
      const rawNight = await this.readNumber('nightMode2', -1)
      this.nightMode2 = rawNight === -1 ? (legacyNight ? 1 : 2) : rawNight
      this.nightFilter = await this.readNumber('nightFilter', 77)
      this.nightCss = await this.readBoolean('nightCss', true)
      this.uaMode = await this.readNumber('uaMode', UA_MODE_DEFAULT)
      this.customUa = await this.readString('customUa', '')
      this.noImage = await this.readBoolean('noImage', false)
      this.restoreTabsMode = await this.readNumber('restoreclosedtabs', 0)
      this.homepageMode = await this.readNumber('homepageMode', 0)
      this.homeUrl = await this.readString('homeUrl', '')
      this.searchHistory = await this.readStringArray('searchHistory')
      this.siteSettings = await this.readSiteSettings()
      this.siteExceptions = await this.readStringArray('siteExceptions')
      this.desktopAllSites = await this.readNumber('desktopAllSites', 0)
      this.forceZoom = await this.readBoolean('forceZoom', false)
      this.siteFontZooms = await this.readSiteFontZooms()
      this.customRules = await this.readRules()
      this.customRulesText = await this.readCustomRulesText()
      this.userScripts = await this.readScripts()
      this.scriptNextId = await this.readNumber('scriptNextId', 1)
      this.ruleSubUrl = await this.readString('ruleSubUrl', '')
      this.ruleAutoUpdate = await this.readNumber('ruleAutoUpdate', 0)
      this.ruleSubscriptions = await this.readRuleSubs()
      this.scriptEnabled = await this.readBoolean('scriptEnabled', false)
      this.jsEnabled = await this.readBoolean('jsEnabled', true)
      // 原版 w9/k.O()：max(0.25, min(5.0, readNumber('readaloudspeed', 100)/100))
      this.readAloudSpeed = Math.max(0.25, Math.min(5.0, (await this.readNumber('readaloudspeed', 100)) / 100))
      this.doNotTrack = await this.readBoolean('doNotTrack', false)
      this.disableWebRtc = await this.readBoolean('disableWebRtc', false)
      this.doNotSell = await this.readBoolean('doNotSell', false)
      this.privacyProxy = await this.readBoolean('privacyProxy', false)
      this.dataSaver = await this.readBoolean('dataSaver', false)
      this.autoSniffButton = await this.readBoolean('autoSniffButton', false)
      this.allowDebugWeb = await this.readBoolean('allowDebugWeb', false)
      this.disableCustomTabs = await this.readBoolean('disableCustomTabs', false)
      this.disableSafeBrowsing = await this.readBoolean('disableSafeBrowsing', false)
      this.ignoreSslWarning = await this.readBoolean('ignoreSslWarning', false)
      this.homeBgColor = await this.readString('homeBgColor', '')
      this.homeLogoText = await this.readString('homeLogoText', 'VIA')
      this.homeLogoType = await this.readNumber('homeLogoType', 0)
      this.homeLogoSize = await this.readNumber('homeLogoSize', 28)
      this.homeLogoStyle = await this.readNumber('homeLogoStyle', 1)
      this.homePillCorner = await this.readNumber('homePillCorner', 100)
      this.homePillOpacity = await this.readNumber('homePillOpacity', 0)
      this.homePillStrokeWidth = await this.readNumber('homePillStrokeWidth', 1)
      this.homePillStrokeOpacity = await this.readNumber('homePillStrokeOpacity', 24)
      this.homePillStyle = await this.readNumber('homePillStyle', 0)
      this.homeLogoWidth = await this.readNumber('homeLogoWidth', 0)
      this.homeLogoHeight = await this.readNumber('homeLogoHeight', 0)
      this.homeLogoCorner = await this.readNumber('homeLogoCorner', 50)
      this.homeBgImage = await this.readString('homeBgImage', '')
      this.homeLogoImage = await this.readString('homeLogoImage', '')
      this.homeLogoHtml = await this.readString('homeLogoHtml', '')
      this.homeFavCorner = await this.readNumber('homeFavCorner', 100)
      this.homeFavShadow = await this.readNumber('homeFavShadow', 0)
      this.homeFavWidth = await this.readNumber('homeFavWidth', 0)
      this.homeFavHeight = await this.readNumber('homeFavHeight', 0)
      this.homeFavIconStyle = await this.readNumber('homeFavIconStyle', 0)
      this.homeBgOpacity = await this.readNumber('homeBgOpacity', 0)
      this.keyback = await this.readNumber('keyback', 2)
      this.keyforward = await this.readNumber('keyforward', 3)
      this.keyhome = await this.readNumber('keyhome', 4)
      this.keytab = await this.readNumber('keytab', 5)
      this.keymenu = await this.readNumber('keymenu', 1)
      this.gesturetoolbarleft = await this.readNumber('gesturetoolbarleft', 10)
      this.gesturetoolbarright = await this.readNumber('gesturetoolbarright', 11)
      this.homeThemeColor = await this.readString('homeThemeColor', '')
      this.homeIconEpoch = await this.readNumber('homeIconEpoch', 0)
      this.homeAdvEffect = await this.readNumber('homeAdvEffect', 0)
      this.homeAdvArea = await this.readNumber('homeAdvArea', 0)
      this.readerAuto = await this.readBoolean('readerAuto', false)
      this.customCss = await this.readString('customCss', '')
      this.readerConfirm = await this.readBoolean('readerConfirm', false)
      this.readerTheme = await this.readNumber('readerTheme', 0)
      this.readerFontSize = await this.readNumber('readerFontSize', 17)
      this.readerCustomCss = await this.readString('readerCustomCss', '')
      this.appLayout = await this.readNumber('appLayout', 0)
      this.toolbarAutoHide = await this.readNumber('toolbarAutoHide', 0)
      this.tabBarEnabled = await this.readBoolean('tabBarEnabled', false)
      this.searchToolbarEnabled = await this.readBoolean('searchToolbarEnabled', true)
      // 原版 searchtoolbarorder/searchtoolbardisabled：引擎 int id 逗号串（如 "-1,-10"）；
      // 旧版存引擎 key（'baidu'/'custom:0'）时迁移为 id 串（'custom:<下标>'→下标+1）
      this.searchToolbarOrder = await this.migrateEngineIdList(
        await this.readString('searchToolbarOrder', ''), 'searchToolbarOrder')
      this.searchToolbarDisabled = await this.migrateEngineIdList(
        await this.readString('searchToolbarDisabled', '-1,-10'), 'searchToolbarDisabled', '-1,-10')
      this.addressBarContent = await this.readNumber('addressBarContent', 0)
      this.toolbarColorAdapt = await this.readBoolean('toolbarColorAdapt', true)
      this.appLanguage = await this.readNumber('appLanguage', 1)
      this.menuHidden = await this.readStringArray('menuHidden')
      this.menuOrder = await this.readStringArray('menuOrder')
      // 原版 hiddenctxmenus 默认 {6}（保存图片隐藏），未写入过时用默认值
      this.longPressHidden = this.parseStringArray(await this.readString('longPressHidden', '["save_image"]'), 'longPressHidden')
      this.toolbarHidden = await this.readStringArray('toolbarHidden')
      this.scriptAutoUpdate = await this.readNumber('scriptautoupdate', 0)
      this.lastScriptUpdate = await this.readNumber('lastScriptUpdate', 0)
      this.aiBackend = await this.readString('aibackend', '')
      this.aiModel = await this.readString('aimodel', '')
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
      this.desktopCustomUa = await this.readString('desktopCustomUa', '')
      this.simplifyUa = await this.readBoolean('simplifyUa', false)
      this.syncMode = await this.readString('syncMode', 'cloud')
      this.webdavUrl = await this.readString('webdavUrl', '')
      this.webdavUser = await this.readString('webdavUser', '')
      this.webdavPwd = await this.readString('webdavPwd', '')
      // 旧数据迁移：0(跟随系统)→1、1(竖屏)→3、2(横屏)→4（原版 1..4 语义）
      const rawOrientation = await this.readNumber('orientation', 1)
      if (rawOrientation === 0) {
        this.orientation = 1
      } else if (rawOrientation === 1) {
        this.orientation = 3
      } else if (rawOrientation === 2) {
        this.orientation = 4
      } else {
        this.orientation = rawOrientation
      }
      this.showStatusBar = await this.readBoolean('showStatusBar', true)
      this.downloadDir = await this.readString('downloadDir', '')
      this.videoPlayer = await this.readString('videoPlayer', '')
      // 旧版布尔 externalPlayer 迁移：true → 系统分享
      if (await this.readBoolean('externalPlayer', false)) {
        this.videoPlayer = 'share'
      }
      this.dlManager = await this.readString('dlManager', 'builtin')
      this.clearOnExit = await this.readNumber('clearOnExit', 0)
      // 旧版字符串 clearOnExit（history/bookmarks/cookies）迁移为位掩码：历史=4、Cookies=16
      if (this.clearOnExit === 0) {
        const legacy = await this.readString('clearOnExit', '')
        if (legacy.includes('history') || legacy.includes('cookies')) {
          let mask = 0
          if (legacy.includes('history')) {
            mask |= 4
          }
          if (legacy.includes('cookies')) {
            mask |= 16
          }
          this.clearOnExit = mask
          this.flushKey('clearOnExit', mask)
        }
      }
      this.volumePageFlip = await this.readBoolean('volumePageFlip', false)
      this.swipeSwitchTab = await this.readBoolean('swipeSwitchTab', true)
      // 原版 w9.a bit128（appflag 默认 226 含 128）：启用视频播放器手势默认开
      this.videoGesture = await this.readBoolean('videoGesture', true)
      // 原版 w9.k.o0()：d3("videoorientation", 0)
      this.videoOrientation = await this.readNumber('videoorientation', 0)
      this.uiFont = await this.readString('uifont', '')
      this.skin = await this.readString('skin', '')
      this.undoCloseToast = await this.readBoolean('undoCloseToast', false)
      this.fullScreen = await this.readBoolean('fullScreen', false)
      this.gameMode = await this.readBoolean('gameMode', false)
      this.wifiOnlyImages = await this.readBoolean('wifiOnlyImages', false)
      this.clearData2 = await this.readNumber('cleardata2', 7)
      this.labFlag = await this.readNumber('labflag', 0)
      this.applyAppTheme()
    } catch (error) {
      const err = error as BusinessError
      console.error(`settings load failed: ${err.code} ${err.message}`)
    }
  }

  // 原版 g6/q.a()：系统当前是否深色
  getSystemDark(): boolean {
    try {
      if (this.appContext !== null) {
        return this.appContext.resourceManager.getConfigurationSync().colorMode
          === resourceManager.ColorMode.DARK
      }
    } catch (error) {
      return false
    }
    return false
  }

  // 原版 w9/k d()：nightmode2 为 1（手动开）或 3（跟随且系统深）时夜间生效
  isNightActive(): boolean {
    return this.nightMode2 === 1 || this.nightMode2 === 3
  }

  // 原版 w9/k m0(z)（BrowserApp::onConfigurationChanged → shouldNightMode2Change）：
  // 仅跟随系统态(2/3)时随系统深浅切换 2↔3，持久化并重设主题
  onSystemConfigChange(systemDark: boolean): void {
    if (this.nightMode2 !== 2 && this.nightMode2 !== 3) {
      return
    }
    if (systemDark !== (this.nightMode2 === 3)) {
      this.nightMode2 = systemDark ? 3 : 2
      this.flushKey('nightMode2', this.nightMode2)
      this.applyAppTheme()
    }
  }

  // 原版 k6 O9 case1：目标态与系统深浅一致时进入跟随模式（2/3），否则手动开/关（1/0）
  // 返回是否进入跟随模式（用于 toast「跟随系统暗模式已启用」）
  toggleNightMode(): boolean {
    const target = !this.isNightActive()
    const systemDark = this.getSystemDark()
    if (target === systemDark) {
      this.nightMode2 = systemDark ? 3 : 2
    } else {
      this.nightMode2 = target ? 1 : 0
    }
    this.flushKey('nightMode2', this.nightMode2)
    this.applyAppTheme()
    return target === systemDark
  }

  // 原版 k6.Hb()：夜间模式对主页自设背景色叠加黑色滤镜后用于工具栏/窗口背景
  // alpha = max(背景亮度>=192 ? 128 : 64, 遮罩强度% * 255)（g6.y.C 亮度判定）
  nightBlend(hexColor: string): string {
    if (!this.isNightActive()) {
      return hexColor
    }
    let hex = hexColor.replace('#', '')
    if (hex.length === 8) {
      hex = hex.substring(2)
    }
    if (hex.length !== 6) {
      return hexColor
    }
    const r = parseInt(hex.substring(0, 2), 16)
    const g = parseInt(hex.substring(2, 4), 16)
    const b = parseInt(hex.substring(4, 6), 16)
    const lum = r * 0.299 + g * 0.587 + b * 0.114
    const dimAlpha = Math.round(this.homeBgOpacity * 2.55)
    const alpha = Math.max(lum >= 192 ? 128 : 64, dimAlpha) / 255
    const mix = (c: number): number => Math.round(c * (1 - alpha))
    const to2 = (v: number): string => {
      const h = v.toString(16)
      return h.length === 1 ? `0${h}` : h
    }
    return `#${to2(mix(r))}${to2(mix(g))}${to2(mix(b))}`
  }

  applyAppTheme(): void {
    this.notifyNightChanged()
    if (this.appContext === null) {
      return
    }
    try {
      // 值未变化时不调用：setColorMode 即便同值也会触发全局 configuration change → 页面重建卡顿
      const target = this.isNightActive()
        ? ConfigurationConstant.ColorMode.COLOR_MODE_DARK
        : ConfigurationConstant.ColorMode.COLOR_MODE_NOT_SET
      if (this.lastAppliedColorMode === target) {
        return
      }
      this.lastAppliedColorMode = target
      this.appContext.setColorMode(target)
    } catch (error) {
      console.error('set color mode failed')
    }
  }

  addNightListener(cb: () => void): void {
    this.nightListeners.push(cb)
  }

  removeNightListener(cb: () => void): void {
    const i = this.nightListeners.indexOf(cb)
    if (i >= 0) {
      this.nightListeners.splice(i, 1)
    }
  }

  private notifyNightChanged(): void {
    for (const cb of this.nightListeners) {
      try {
        cb()
      } catch (error) {
        console.error('night listener failed')
      }
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

  // engineKey 解析：'custom:<id>'（id=记录主键，≥1）优先按 id 匹配；
  // 兼容旧版 'custom:<下标>'（下标入列表）与单引擎时代 'custom'
  resolveCustomEngineKey(key: string): CustomEngineRec | null {
    if (key === 'custom') {
      return this.customEngines.length > 0 ? this.customEngines[0] : null
    }
    if (key.startsWith('custom:')) {
      const n = Number(key.substring('custom:'.length))
      if (!Number.isNaN(n)) {
        const byId = this.customEngines.find((rec: CustomEngineRec): boolean => rec.id === n)
        if (byId !== undefined) {
          return byId
        }
        if (n >= 0 && n < this.customEngines.length) {
          return this.customEngines[n]
        }
      }
    }
    return null
  }

  // engineKey 为 'custom:<id>' / 旧版 'custom:<下标>' / 'custom' 时返回对应模板
  activeEngineTemplate(): string {
    const rec = this.resolveCustomEngineKey(this.engineKey)
    return rec !== null ? rec.template : ''
  }

  setCustomEngineTemplate(template: string): void {
    this.customEngineTemplate = template
    this.flushKey('customEngineTemplate', template)
  }

  // 原版 ka/g.q 网络建议开关：searchsuggestion 位 16
  isNetworkSuggestOn(): boolean {
    return (this.searchSuggestion & 16) !== 0
  }

  setSearchSuggestion(flags: number): void {
    this.searchSuggestion = flags
    this.flushKey('searchsuggestion', flags)
  }

  setNetworkSuggest(on: boolean): void {
    const flags = on ? this.searchSuggestion | 16 : this.searchSuggestion & ~16
    this.setSearchSuggestion(flags)
  }

  // 原版 ja/c 记录主键自增：新 id = 现有最大 id + 1；返回新记录 id
  addCustomEngine(name: string, template: string): number {
    let maxId = 0
    for (const rec of this.customEngines) {
      if (rec.id > maxId) {
        maxId = rec.id
      }
    }
    const id = maxId + 1
    const next = this.customEngines.slice(0)
    next.push(new CustomEngineRec(name, template, id))
    this.customEngines = next
    this.persistCustomEngines()
    return id
  }

  updateCustomEngine(index: number, name: string, template: string): void {
    if (index < 0 || index >= this.customEngines.length) {
      return
    }
    const next = this.customEngines.slice(0)
    next[index] = new CustomEngineRec(name, template)
    this.customEngines = next
    this.persistCustomEngines()
  }

  removeCustomEngine(index: number): void {
    if (index < 0 || index >= this.customEngines.length) {
      return
    }
    const next: CustomEngineRec[] = []
    for (let i = 0; i < this.customEngines.length; i++) {
      if (i !== index) {
        next.push(this.customEngines[i])
      }
    }
    this.customEngines = next
    this.persistCustomEngines()
  }

  private persistCustomEngines(): void {
    const payload: Record<string, Object>[] = []
    for (const item of this.customEngines) {
      const entry: Record<string, Object> = {}
      entry['id'] = item.id
      entry['name'] = item.name
      entry['template'] = item.template
      payload.push(entry)
    }
    this.flushKey('customEngines', JSON.stringify(payload))
  }

  // 读取自定义引擎；旧数据无 id 时按下标+1 补齐（一次性迁移并回写）
  private async readCustomEngines(): Promise<CustomEngineRec[]> {
    const raw = await this.readString('customEngines', '[]')
    const result: CustomEngineRec[] = []
    let migrated = false
    try {
      const parsed = JSON.parse(raw) as Object[]
      for (let i = 0; i < parsed.length; i++) {
        const rec = parsed[i] as Record<string, Object>
        const name = rec['name']
        const template = rec['template']
        if (typeof name === 'string' && typeof template === 'string') {
          const id = rec['id']
          if (typeof id === 'number' && id >= 1) {
            result.push(new CustomEngineRec(name, template, id))
          } else {
            result.push(new CustomEngineRec(name, template, i + 1))
            migrated = true
          }
        }
      }
    } catch (error) {
      console.error('parse customEngines failed')
    }
    if (migrated && result.length > 0) {
      const payload: Record<string, Object>[] = []
      for (const item of result) {
        payload.push({ 'id': item.id, 'name': item.name, 'template': item.template })
      }
      if (this.store !== null) {
        this.store.put('customEngines', JSON.stringify(payload)).catch(() => {})
        this.store.flush().catch(() => {})
      }
    }
    return result
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

  private isZhLocale(): boolean {
    // 系统语言判定（i18n.System.getSystemLanguage）
    return i18n.System.getSystemLanguage().startsWith('zh')
  }

  private async readRuleSubs(): Promise<RuleSubEntry[]> {
    const result: RuleSubEntry[] = []
    for (let i = 0; i < RULE_SUB_PRESETS.length; i++) {
      const p = RULE_SUB_PRESETS[i]
      result.push(new RuleSubEntry(p.key, p.name, p.url, p.enabled, p.ruleCount, p.lastUpdate, p.isPreset))
    }
    const raw = await this.readString('ruleSubscriptions', '')
    if (raw === '') {
      // 原版 b5/d.java b()：首次启动 Easylist 恒选，中文环境追加 easylistchina
      for (let i = 0; i < result.length; i++) {
        if (result[i].key === 'easylist') {
          result[i].enabled = true
        }
        if (result[i].key === 'easylistchina' && this.isZhLocale()) {
          result[i].enabled = true
        }
      }
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

  saveRuleSubs(): void {
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

  setNightFilter(value: number): void {
    this.nightFilter = value
    this.flushKey('nightFilter', value)
    this.notifyNightChanged()
  }

  setNightCss(on: boolean): void {
    this.nightCss = on
    this.flushKey('nightCss', on)
    this.notifyNightChanged()
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

  setSearchToolbarEnabled(on: boolean): void {
    this.searchToolbarEnabled = on
    this.flushKey('searchToolbarEnabled', on)
  }

  setSearchToolbarOrder(order: string): void {
    this.searchToolbarOrder = order
    this.flushKey('searchToolbarOrder', order)
  }

  // 旧版 order/disabled 存引擎 key（'baidu'、'custom:0'），原版/新版存 int id 逗号串；
  // 逐 token 迁移：内置 key→负 id、'custom:<下标>'→下标+1；纯数字 token 原样保留
  private async migrateEngineIdList(raw: string, key: string, defaultValue: string = ''): Promise<string> {
    if (raw === '' || raw === defaultValue) {
      return raw
    }
    const tokens = raw.split(',')
    const out: string[] = []
    let changed = false
    for (let i = 0; i < tokens.length; i++) {
      const token = tokens[i]
      if (/^-?\d+$/.test(token)) {
        out.push(token)
        continue
      }
      changed = true
      const id = builtinEngineId(token)
      if (id !== null) {
        out.push(String(id))
        continue
      }
      if (token.startsWith('custom:')) {
        const n = Number(token.substring('custom:'.length))
        if (!Number.isNaN(n) && n >= 0) {
          out.push(String(n + 1))
        }
      }
    }
    const result = out.join(',')
    if (changed && this.store !== null) {
      this.store.put(key, result).catch(() => {
      })
      this.store.flush().catch(() => {
      })
    }
    return result
  }

  setSearchToolbarDisabled(disabled: string): void {
    this.searchToolbarDisabled = disabled
    this.flushKey('searchToolbarDisabled', disabled)
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

  setDesktopCustomUa(ua: string): void {
    this.desktopCustomUa = ua
    this.flushKey('desktopCustomUa', ua)
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

  setRestoreTabsMode(mode: number): void {
    this.restoreTabsMode = mode
    this.flushKey('restoreclosedtabs', mode)
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

  // 原版 w9/k.t（网站设定 JavaScript 全局默认）
  setJsEnabled(on: boolean): void {
    this.jsEnabled = on
    this.flushKey('jsEnabled', on)
  }

  // 原版 w9/k.u0(float)：存储 int(clamp(speed,0.25,5)*100)
  setReadAloudSpeed(speed: number): void {
    const clamped = Math.max(0.25, Math.min(5.0, speed))
    this.readAloudSpeed = clamped
    this.flushKey('readaloudspeed', Math.round(clamped * 100))
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

  setPrivacyProxy(on: boolean): void {
    this.privacyProxy = on
    this.flushKey('privacyProxy', on)
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

  setHomeLogoImage(uri: string): void {
    this.homeLogoImage = uri
    this.flushKey('homeLogoImage', uri)
  }

  setHomeLogoHtml(html: string): void {
    this.homeLogoHtml = html
    this.flushKey('homeLogoHtml', html)
  }

  setHomeBgOpacity(pct: number): void {
    this.homeBgOpacity = pct
    this.flushKey('homeBgOpacity', pct)
  }

  setHomeThemeColor(color: string): void {
    this.homeThemeColor = color
    this.flushKey('homeThemeColor', color)
  }

  // 清除网站图标缓存：递增代数使主页收藏的 favicon URL 变化，强制重新下载
  bumpIconEpoch(): void {
    this.homeIconEpoch = this.homeIconEpoch + 1
    this.flushKey('homeIconEpoch', this.homeIconEpoch)
  }

  setHomeLogoWidth(value: number): void {
    this.homeLogoWidth = value
    this.flushKey('homeLogoWidth', value)
  }

  setHomeLogoHeight(value: number): void {
    this.homeLogoHeight = value
    this.flushKey('homeLogoHeight', value)
  }

  setHomeLogoCorner(pct: number): void {
    this.homeLogoCorner = pct
    this.flushKey('homeLogoCorner', pct)
  }

  setHomeFavWidth(value: number): void {
    this.homeFavWidth = value
    this.flushKey('homeFavWidth', value)
  }

  setHomeFavHeight(value: number): void {
    this.homeFavHeight = value
    this.flushKey('homeFavHeight', value)
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

  setHomeLogoSize(px: number): void {
    this.homeLogoSize = px
    this.flushKey('homeLogoSize', px)
  }

  setHomeLogoStyle(index: number): void {
    this.homeLogoStyle = index
    this.flushKey('homeLogoStyle', index)
  }

  setHomePillCorner(pct: number): void {
    this.homePillCorner = pct
    this.flushKey('homePillCorner', pct)
  }

  setHomePillOpacity(pct: number): void {
    this.homePillOpacity = pct
    this.flushKey('homePillOpacity', pct)
  }

  setHomePillStrokeWidth(px: number): void {
    this.homePillStrokeWidth = px
    this.flushKey('homePillStrokeWidth', px)
  }

  setHomePillStrokeOpacity(pct: number): void {
    this.homePillStrokeOpacity = pct
    this.flushKey('homePillStrokeOpacity', pct)
  }

  setHomePillStyle(index: number): void {
    this.homePillStyle = index
    this.flushKey('homePillStyle', index)
  }

  setHomeFavCorner(pct: number): void {
    this.homeFavCorner = pct
    this.flushKey('homeFavCorner', pct)
  }

  setHomeFavShadow(index: number): void {
    this.homeFavShadow = index
    this.flushKey('homeFavShadow', index)
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

  setScriptAutoUpdate(days: number): void {
    this.scriptAutoUpdate = days
    this.flushKey('scriptautoupdate', days)
  }

  markScriptsUpdated(): void {
    this.lastScriptUpdate = Date.now()
    this.flushKey('lastScriptUpdate', this.lastScriptUpdate)
  }

  // 原版 w9/k.H0()（键名 aibackend）
  setAiBackend(id: string): void {
    this.aiBackend = id
    this.flushKey('aibackend', id)
  }

  // 原版 w9/k（键名 aimodel）
  setAiModel(model: string): void {
    this.aiModel = model
    this.flushKey('aimodel', model)
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

  setVideoPlayer(value: string): void {
    this.videoPlayer = value
    this.flushKey('videoPlayer', value)
  }

  setDlManager(value: string): void {
    this.dlManager = value
    this.flushKey('dlManager', value)
  }

  setClearOnExit(mask: number): void {
    this.clearOnExit = mask
    this.flushKey('clearOnExit', mask)
  }

  setVolumePageFlip(on: boolean): void {
    this.volumePageFlip = on
    this.flushKey('volumePageFlip', on)
  }

  setSwipeSwitchTab(on: boolean): void {
    this.swipeSwitchTab = on
    this.flushKey('swipeSwitchTab', on)
  }

  // 原版 w9.a：c(128, on)（appflag bit128）
  setVideoGesture(on: boolean): void {
    this.videoGesture = on
    this.flushKey('videoGesture', on)
  }

  // 原版 w9.k.m(int)：q3("videoorientation", i)
  setVideoOrientation(value: number): void {
    this.videoOrientation = value
    this.flushKey('videoorientation', value)
  }

  // 原版 w9.k.o（键名 uifont）
  setUiFont(name: string): void {
    this.uiFont = name
    this.flushKey('uifont', name)
  }

  setUndoCloseToast(on: boolean): void {
    this.undoCloseToast = on
    this.flushKey('undoCloseToast', on)
  }

  setFullScreen(on: boolean): void {
    this.fullScreen = on
    this.flushKey('fullScreen', on)
  }

  setGameMode(on: boolean): void {
    this.gameMode = on
    this.flushKey('gameMode', on)
  }

  setWifiOnlyImages(on: boolean): void {
    this.wifiOnlyImages = on
    this.flushKey('wifiOnlyImages', on)
  }

  setClearData2(flags: number): void {
    this.clearData2 = flags
    this.flushKey('cleardata2', flags)
  }

  // 原版 w9/d：labflag 位1 = 设置根页「实验」入口（hb/o6 五连点切换 f()）
  isLabEntryVisible(): boolean {
    return (this.labFlag & 1) !== 0
  }

  // 原版 w9/d：labflag 位2 = 模糊效果（hb/y1「模糊效果」开关 e()）
  isBlurEffect(): boolean {
    return (this.labFlag & 2) !== 0
  }

  setLabFlag(flags: number): void {
    this.labFlag = flags
    this.flushKey('labflag', flags)
  }

  setBlurEffect(on: boolean): void {
    this.setLabFlag(on ? (this.labFlag | 2) : (this.labFlag & ~2))
  }

  // 原版 w9.d.g()/j()：labflag 位4 = 实验页「在设置中显示背景」开关
  isShowSettingsBackground(): boolean {
    return (this.labFlag & 4) !== 0
  }

  setShowSettingsBackground(on: boolean): void {
    this.setLabFlag(on ? (this.labFlag | 4) : (this.labFlag & ~4))
  }

  // 原版 w9.l.L()/T1()（键名 skin）
  setSkin(name: string): void {
    this.skin = name
    this.flushKey('skin', name)
  }

  resetHomeStyle(): void {
    this.setHomeBgColor('')
    this.setHomeBgImage('')
    this.setHomeLogoText('VIA')
    this.setHomeLogoType(0)
    this.setHomeLogoSize(28)
    this.setHomeLogoStyle(0)
    this.setHomeLogoWidth(0)
    this.setHomeLogoHeight(0)
    this.setHomeLogoCorner(50)
    this.setHomeLogoImage('')
    this.setHomeLogoHtml('')
    this.setHomePillCorner(100)
    this.setHomePillOpacity(0)
    this.setHomePillStrokeWidth(1)
    this.setHomePillStrokeOpacity(50)
    this.setHomePillStyle(0)
    this.setHomeFavCorner(100)
    this.setHomeFavShadow(0)
    this.setHomeFavWidth(0)
    this.setHomeFavHeight(0)
    this.setHomeFavIconStyle(0)
    this.setHomeBgOpacity(0)
    this.setHomeThemeColor('')
    this.setHomeAdvEffect(0)
    this.setHomeAdvArea(0)
  }

  uaForHost(host: string): string | null {
    const site = this.getSiteSetting(host)
    const desktop = this.desktopAllSites === 1 || (site !== null && site.pcMode)
    if (desktop) {
      // 原版 r3/v3：电脑模式 UA 可选内置 {默认, Chrome(PC), IE11(PC), macOS} 或自定义
      let ua: string | null = null
      if (this.desktopUaKey === 'custom') {
        ua = this.desktopCustomUa !== '' ? this.desktopCustomUa : null
      } else {
        const globalDef = uaByKey(this.desktopUaKey)
        ua = globalDef !== null && globalDef.ua !== '' ? globalDef.ua : null
      }
      if (ua === null) {
        return null
      }
      if (this.simplifyUa) {
        return simplifyUaString(ua)
      }
      return ua
    }
    let key = this.uaKey
    let ua: string | null = null
    if (key === 'custom') {
      ua = this.customUa !== '' ? this.customUa : null
    } else {
      const def = uaByKey(key)
      // 原版 uachoice=0 → 传 null 用系统 WebView 默认 UA（w9/k.java:1127）
      ua = def !== null && def.ua !== '' ? def.ua : null
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
      entry['javaScript'] = item.javaScript
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

  // ---- 每站字体缩放（原版 jb/l5：l() 设置 / r() 移除 / n() 读取 / m() 全局）----

  private persistSiteFontZooms(): void {
    const payload: Record<string, Object> = {}
    this.siteFontZooms.forEach((zoom: number, host: string) => {
      payload[host] = zoom
    })
    this.flushKey('siteFontZooms', JSON.stringify(payload))
  }

  private async readSiteFontZooms(): Promise<Map<string, number>> {
    const raw = await this.readString('siteFontZooms', '{}')
    const result = new Map<string, number>()
    try {
      const parsed = JSON.parse(raw) as Record<string, Object>
      const keys = Object.keys(parsed)
      for (let i = 0; i < keys.length; i++) {
        const host = keys[i]
        const value = parsed[host]
        if (typeof value === 'number' && value > 0) {
          result.set(host, value)
        }
      }
    } catch (error) {
      console.error('parse siteFontZooms failed')
    }
    return result
  }

  // 原版 f2580m0.T0(url)：站点缩放，无则 0
  getSiteFontZoom(host: string): number {
    const value = this.siteFontZooms.get(host)
    return value !== undefined ? value : 0
  }

  hasSiteFontZoom(host: string): boolean {
    return this.siteFontZooms.get(host) !== undefined
  }

  // 原版 jb/l5.l(host, zoom)：规范化域名后写入（kb/c.a：trim + 小写）
  setSiteFontZoom(host: string, zoom: number): void {
    const normalized = host.trim().toLowerCase()
    if (normalized === '' || zoom <= 0) {
      return
    }
    this.siteFontZooms.set(normalized, zoom)
    this.persistSiteFontZooms()
  }

  // 原版 jb/l5.r(host)：移除站点缩放
  removeSiteFontZoom(host: string): void {
    const normalized = host.trim().toLowerCase()
    if (this.siteFontZooms.get(normalized) === undefined) {
      return
    }
    this.siteFontZooms.delete(normalized)
    this.persistSiteFontZooms()
  }

  // 原版 jb/k5.s3：Collections.sort(hosts, new k8.p())——按域名标签从 TLD 往前逐段比较
  static compareDomainLabels(a: string, b: string): number {
    let length = a.length
    let length2 = b.length
    let i11 = length
    let i10 = length2
    while (length > 0 && length2 > 0) {
      const iLastIndexOf = a.lastIndexOf('.', length)
      const i12 = iLastIndexOf + 1
      const iLastIndexOf2 = b.lastIndexOf('.', length2)
      const i13 = iLastIndexOf2 + 1
      const i14 = length - i12
      const iMin = Math.min(i14, length2 - i13)
      for (let i15 = 0; i15 < iMin; i15++) {
        const diff = a.charAt(i12 + i15).charCodeAt(0) - b.charAt(i13 + i15).charCodeAt(0)
        if (diff !== 0) {
          return diff
        }
      }
      const i16 = (i14 - length2) + i13
      if (i16 !== 0) {
        return i16
      }
      length = iLastIndexOf - 1
      length2 = iLastIndexOf2 - 1
      i11 = i12
      i10 = i13
    }
    return i11 - i10
  }

  // 原版 jb/k5.s3：键排序后逐行展示
  siteFontZoomHosts(): string[] {
    const hosts: string[] = []
    this.siteFontZooms.forEach((zoom: number, host: string) => {
      hosts.push(host)
    })
    hosts.sort((a: string, b: string): number => AppSettings.compareDomainLabels(a, b))
    return hosts
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
      entry['enabled'] = item.enabled
      entry['includes'] = item.includes
      entry['excludes'] = item.excludes
      entry['runAt'] = item.runAt
      entry['grantBits'] = item.grantBits
      entry['unwrap'] = item.unwrap
      entry['downloadUrl'] = item.downloadUrl
      entry['homepageUrl'] = item.homepageUrl
      entry['version'] = item.version
      entry['requires'] = item.requires
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

  private parseStringArray(raw: string, key: string): string[] {
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

  private async readStringArray(key: string): Promise<string[]> {
    const raw = await this.readString(key, '[]')
    return this.parseStringArray(raw, key)
  }

  saveTabsSnapshot(tabs: SavedTab[], activeIndex: number): void {
    const payload: Record<string, Object>[] = []
    for (let i = 0; i < tabs.length; i++) {
      const entry: Record<string, Object> = {}
      entry['url'] = tabs[i].url
      entry['incognito'] = tabs[i].incognito
      entry['title'] = tabs[i].title
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
        const title = element['title']
        if (typeof url === 'string' && typeof incognito === 'boolean') {
          const tab = new SavedTab(url, incognito)
          if (typeof title === 'string') {
            tab.title = title
          }
          result.push(tab)
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

  // 原版 f8/h.f3()：FIND_CACHE 缓存页内查找词，TTL 180 天
  saveFindCache(text: string): void {
    this.flushKey('findCachedText', text)
    this.flushKey('findCachedTs', Date.now())
  }

  async readFindCache(): Promise<string> {
    const ts = await this.readNumber('findCachedTs', 0)
    if (ts === 0 || Date.now() - ts > 180 * 24 * 3600 * 1000) {
      return ''
    }
    return await this.readString('findCachedText', '')
  }
}
