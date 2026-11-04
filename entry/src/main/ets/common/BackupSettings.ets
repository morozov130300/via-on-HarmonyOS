import { fileIo } from '@kit.CoreFileKit'
import { AppSettings, CustomEngineRec } from './Settings'
import { SiteSetting, UserScriptRec, RuleSubEntry } from './Types'
import { CustomUaEntry } from './UaTable'
import { engineIdFromKey, builtinKeyById } from './SearchEngines'
import { BackupCrypto } from './BackupCrypto'
import { MENU_DEFAULT_ORDER, menuKeysToIdCsv, menuIdCsvToKeys } from './MenuItems'

// 导出时搜索引擎/UA 状态（m9/l.c 与 l9/f 共用 w9.l.L2 数据源）
export interface SettingsExportState {
  search2: number
  selectedEngine: CustomEngineRec | null
  uastring: string
  uachoice: number
  skipUaRecordIdx: number
}

// 原版 m9/l.a：settings.txt 导出（1:1）
// 行序：meta → settings → settingsData → siteConf → script → filters
// 每行格式 {"<type>":{...}}\n（m9/l.q）
//
// 已亲自核实的原版依据：
// - m9/l.java a/e/c/g/h/f/d/q（行序与各生成器）
// - w9/k.java L2(405)/j1(1056)（settings 白名单导出/导入）
// - w9/i.java（白名单：boolean[nightcss]；String 15 键；int 41 键；long 2 键）
// - ja/c.java w()/n()（settingsData 序列化：id/title/content/note/flag/type/
//   lastUpdatedAt/createdAt，putOpt 跳过 null）
// - m9/l.g：type1 且 uachoice==id 的当前 UA 记录跳过；type2 且 search2==id 的
//   当前引擎记录加 "selected":true
// - ba/c.java l()（siteConf 序列化：uastring?/uachoice?/enabled?/textsize?/flags）
// - ba/b.java（S(1) 启用、Z(2) JS、X(4) 图像、M(16) 广告拦截、U/H 位集写法）
// - z8/b4.java b()（预设 UA id：0 默认 / -1..-8）
// - z8/c0.java f() 恒 true → searchtoolbardisabled 默认 "-1,-10"、appflag 默认含 1024
// - w9/p.java（webflag 位布局，默认 96495261）、w9/a.java（appflag 默认 1250）、
//   w9/o.java（webflag2 仅 bit1 = 自定义 UA 兼容规整，k.java:393 → b4.c 第 7 参）
// - m9/l.d（:249-286）：filters 行遍历全部订阅（url 恒写、title?/enabled? 仅非空/true，
//   规则文件存在时 path/size/lastUpdated 并打包文件；path = "filters-" + m9/l.i(title)
//   + z8/v0.g(url) 小写 md5hex + ".txt"）；custom 仅打包 filters-custom.txt 文件不写行
// - l9/*（data-for-older-versions 七键）与 w4/c.o()（:172-190 订阅行：
//   title/url/homepage/license/filePath/enabled?/size?）
export class BackupSettings {
  // 原版 z8/b4.b：预设 UA id 表（键为本工程 uaKey）
  private static readonly UA_PRESET_CHOICE: Record<string, number> = {
    'default': 0,
    'android_phone': -1,
    'android_tablet': -2,
    'win_chrome': -3,
    'win_ie11': -4,
    'mac': -5,
    'iphone': -6,
    'ipad': -7,
    'symbian': -8
  }

  // 原版 w9/k.l0 默认 uachoice=0；桌面 UA：z8/b4.c duachoice 0=默认（Win Chrome）
  private static readonly DESKTOP_UA_CHOICE: Record<string, number> = {
    'win_chrome': 0,
    'win_ie11': -4,
    'mac': -5
  }

  private static bit(value: number, mask: number, on: boolean): number {
    return on ? (value | mask) : (value & ~mask)
  }

  // m9/l.q：单行序列化（obj 为空跳过）
  private static line(type: string, obj: Record<string, Object>): string {
    if (obj === null) {
      return ''
    }
    const wrapper: Record<string, Object> = {}
    wrapper[type] = obj
    return JSON.stringify(wrapper) + '\n'
  }

  // m9/l.i：文件名清洗（trim → 非法字符与空白替换为 '-' → 连续 '-' 合并 →
  // 小写 → 截断 128 → 追加 '-'；空返回 ''）
  private static namePrefix(name: string | null): string {
    if (name === null || name === '') {
      return ''
    }
    let cleaned = name.trim().replace(/[\\/:*?"<>|\s]/g, '-').replace(/-{2,}/g, '-').toLowerCase()
    if (cleaned.length > 128) {
      cleaned = cleaned.substring(0, 128)
    }
    if (cleaned === '') {
      return ''
    }
    return cleaned + '-'
  }

  // 搜索引擎 + UA 导出状态（m9/l.c 前置计算，l9 复用）
  static collectExportState(s: AppSettings): SettingsExportState {
    let search2 = engineIdFromKey(s.engineKey)
    let selectedEngine: CustomEngineRec | null = null
    if (search2 === null) {
      const rec = s.resolveCustomEngineKey(s.engineKey)
      selectedEngine = rec
      search2 = rec !== null ? rec.id : -2
    } else if (search2 >= 1) {
      selectedEngine = s.resolveCustomEngineKey(s.engineKey)
    }
    let uachoice = 0
    const preset = BackupSettings.UA_PRESET_CHOICE[s.uaKey]
    if (preset !== undefined) {
      uachoice = preset
    }
    let uastring = ''
    let skipUaRecordIdx = -1
    if (s.uaKey === 'custom') {
      uastring = s.customUa.replace(/[\t\r\n]/g, ' ')
      for (let i = 0; i < s.customUaList.length; i++) {
        if (s.customUaList[i].ua === s.customUa) {
          skipUaRecordIdx = i
          uachoice = i + 1
          break
        }
      }
      if (skipUaRecordIdx < 0) {
        uachoice = 1
      }
    }
    const state: SettingsExportState = {
      search2: search2,
      selectedEngine: selectedEngine,
      uastring: uastring,
      uachoice: uachoice,
      skipUaRecordIdx: skipUaRecordIdx
    }
    return state
  }

  // w9/k.L2(false)：settings 行对象（m9/l.c 与 l9/f 同源复用）
  static buildSettingsRecord(s: AppSettings, state: SettingsExportState): Record<string, Object> {
    // webflag（w9/p 默认 96495261）：
    // bit0 菜单快捷开关 / bit8 JavaScript / bit16 显示图像 / bit128 不跟踪 /
    // bit256 流量节省 / bit2048 电脑模式 / bit4096 允许调试网页 / bit65536 不出售 /
    // bit268435456 广告拦截总开关（置反，w9/p.i0/k） / bit536870912 禁用 WebRTC
    let webflag = 96495261
    webflag = BackupSettings.bit(webflag, 1, s.adBlockOn)
    webflag = BackupSettings.bit(webflag, 268435456, !s.adBlockOn)
    webflag = BackupSettings.bit(webflag, 8, s.jsEnabled)
    webflag = BackupSettings.bit(webflag, 16, !s.noImage)
    webflag = BackupSettings.bit(webflag, 32, false)
    webflag = BackupSettings.bit(webflag, 128, s.doNotTrack)
    webflag = BackupSettings.bit(webflag, 256, s.dataSaver)
    webflag = BackupSettings.bit(webflag, 2048, s.desktopAllSites !== 0)
    webflag = BackupSettings.bit(webflag, 4096, s.allowDebugWeb)
    webflag = BackupSettings.bit(webflag, 65536, s.doNotSell)
    webflag = BackupSettings.bit(webflag, 536870912, s.disableWebRtc)

    // appflag（w9/a 默认 1250，z8/c0.f() 恒 true）：
    // bit5(32) 滑动前进后退 / bit3(8) 音量键翻页（w9/a.v/M0）
    let appflag = 1250
    appflag = BackupSettings.bit(appflag, 32, s.swipeSwitchTab)
    appflag = BackupSettings.bit(appflag, 8, s.volumePageFlip)

    const st: Record<string, Object> = {}
    // boolean 白名单（w9/i.a = [nightcss]）
    st['nightcss'] = s.nightCss
    // String 白名单（w9/i.d，仅导出有对应值的键）
    if (s.homepageMode === 1 && s.homeUrl !== '') {
      st['home'] = s.homeUrl
    } else if (s.homepageMode === 2) {
      st['home'] = 'about:blank'
    } else if (s.homepageMode === 3) {
      st['home'] = 'about:bookmarks'
    }
    if (state.selectedEngine !== null) {
      // 原版 searchurl：自定义搜索引擎模板（w9/k.N 默认 google，自定义时被
      // z8/v2.c 用作记录缺失的回退模板）
      st['searchurl'] = state.selectedEngine.template
    }
    if (state.uastring !== '') {
      st['uastring'] = state.uastring
    }
    if (s.desktopUaKey === 'custom' && s.desktopCustomUa !== '') {
      st['duastring'] = s.desktopCustomUa.replace(/[\t\r\n]/g, ' ')
    }
    if (s.appLanguage === 1) {
      st['language'] = 'zh-CN'
    } else if (s.appLanguage === 2) {
      st['language'] = 'en-US'
    }
    if (s.searchToolbarOrder !== '') {
      st['searchtoolbarorder'] = s.searchToolbarOrder
    }
    if (s.searchToolbarDisabled !== '') {
      st['searchtoolbardisabled'] = s.searchToolbarDisabled
    }
    // 原版 searchshortcuts（w9/k.java:943 f1）：搜索快捷词 JSON 串
    // （{"<引擎id>":"<快捷词>"}）；仅 pref 存在才导（L2 contains），本工程未实施值为空不导
    if (s.searchshortcuts !== '') {
      st['searchshortcuts'] = s.searchshortcuts
    }
    // 原版 taghome（w9/k.java:751 a0 / 1571 z0）：主页 logo 内容，pref 存 Base64(trim(内容))，
    // 仅 pref 存在才导；按当前 homeLogoType（=原版 logochioce 0默认/1图片/2文字/3HTML/4无）取内容：
    // 图片=e9/u.b3 "<img class=\"smaller\" src=\"...\" />"、无=d3 case4 "<br>"
    let taghomeContent = ''
    if (s.homeLogoType === 1 && s.homeLogoImage !== '') {
      taghomeContent = `<img class="smaller" src="${s.homeLogoImage}" />`
    } else if (s.homeLogoType === 2 && s.homeLogoText !== '') {
      taghomeContent = s.homeLogoText
    } else if (s.homeLogoType === 3 && s.homeLogoHtml !== '') {
      taghomeContent = s.homeLogoHtml
    } else if (s.homeLogoType === 4) {
      taghomeContent = '<br>'
    }
    if (taghomeContent !== '') {
      st['taghome'] = BackupCrypto.base64Wrap76(BackupCrypto.utf8Encode(taghomeContent.trim()))
    }
    // 原版 csstheme（w9/k.java:765 s3("csstheme", v0.b(str.trim()))）：
    // 存 Base64(trim 后 CSS)，导出即 pref 原值（Base64）
    if (s.customCss !== '') {
      st['csstheme'] = BackupCrypto.base64Wrap76(BackupCrypto.utf8Encode(s.customCss.trim()))
    }
    // 原版 readercustomcss（w9/k.java:1115 s3("readercustomcss", v0.b(str))）：Base64 原值
    if (s.readerCustomCss !== '') {
      st['readercustomcss'] = BackupCrypto.base64Wrap76(BackupCrypto.utf8Encode(s.readerCustomCss))
    }
    // 原版 videoplayer（w9/k.java:366）：仅 prefs 含键才导出，空值（内置播放）不导
    if (s.videoPlayer !== '') {
      st['videoplayer'] = s.videoPlayer
    }
    // 原版 dlmanager（w9/k.java:228）：默认值时不导
    if (s.dlManager !== '' && s.dlManager !== 'builtin') {
      st['dlmanager'] = s.dlManager
    }
    // 原版 displayedmenus/hiddenmenus（w9/k.java:495/307）：逗号数字串；
    // 与默认顺序一致时不导（原版 pref 仅定制后存在）
    const orderCsv = menuKeysToIdCsv(s.menuOrder)
    const defaultCsv = menuKeysToIdCsv(MENU_DEFAULT_ORDER)
    if (orderCsv !== '' && orderCsv !== defaultCsv) {
      st['displayedmenus'] = orderCsv
    }
    if (s.menuHidden.length > 0) {
      st['hiddenmenus'] = menuKeysToIdCsv(s.menuHidden)
    }
    // int 白名单（w9/i.b，仅导出有对应值的键）
    st['search2'] = state.search2
    st['textsize'] = s.textZoom
    st['uachoice'] = state.uachoice
    st['duachoice'] = BackupSettings.DESKTOP_UA_CHOICE[s.desktopUaKey] !== undefined
      ? BackupSettings.DESKTOP_UA_CHOICE[s.desktopUaKey] : (s.desktopUaKey === 'custom' ? 1 : 0)
    st['keyback'] = s.keyback
    st['keyforward'] = s.keyforward
    st['keyhome'] = s.keyhome
    st['keytab'] = s.keytab
    st['keymenu'] = s.keymenu
    st['gesturetoolbarleft'] = s.gesturetoolbarleft
    st['gesturetoolbarright'] = s.gesturetoolbarright
    st['searchsuggestion'] = s.searchSuggestion
    st['restoreclosedtabs'] = s.restoreTabsMode
    st['cleardataonexit2'] = s.clearOnExit
    st['nightfilter'] = s.nightFilter
    st['readertextsize'] = s.readerFontSize
    st['readerthemecolor'] = s.readerTheme
    // 原版 fullscreenmode（w9/k.java:1428 q3，默认 0）：int 0/1；本工程 fullScreen bool，
    // 默认（false=0）不导，与原版「pref 未设置即默认」一致
    if (s.fullScreen) {
      st['fullscreenmode'] = 1
    }
    // 原版 screenOrientation（w9/k.java:534，默认 1=跟随系统）：1..4 直传
    if (s.orientation !== 1) {
      st['screenOrientation'] = s.orientation
    }
    // 原版 videoorientation（w9/k.java:1149，默认 0=自动）：默认不导
    if (s.videoOrientation !== 0) {
      st['videoorientation'] = s.videoOrientation
    }
    // 原版 cleardata2（w9/k.java:318，默认 7）：默认不导
    if (s.clearData2 !== 7) {
      st['cleardata2'] = s.clearData2
    }
    // 原版 labflag（w9/k.java:1413，默认 0）：默认不导
    if (s.labFlag !== 0) {
      st['labflag'] = s.labFlag
    }
    // 原版 bookmarksviewmode/bookmarksorder（w9/k.java:564/640，默认 0）：仅 pref 存在才导；
    // 本工程书签页功能未实施，默认值不导
    if (s.bookmarksviewmode !== 0) {
      st['bookmarksviewmode'] = s.bookmarksviewmode
    }
    if (s.bookmarksorder !== 0) {
      st['bookmarksorder'] = s.bookmarksorder
    }
    // 原版 favinfo（w9/k.java:690 X2 → i9.c，默认 1638446）：主页收藏设计打包 int——
    // 宽 bits0-6 / 高 bits7-13 / 圆角 bits14-20 / 隐藏图标 bit21 / 无彩色 bit22（i9/c.java）；
    // 原版 x9/c.java:21 迁移（版本 2）首启即写四键 → pref 恒存在 → 恒导出；
    // 鸿蒙 homeFavIconStyle 1=文字（隐藏图标→bit21）、homeFavShadow 1=透明（无彩色→bit22）
    st['favinfo'] = (s.homeFavWidth & 127)
      | ((s.homeFavHeight & 127) << 7)
      | ((s.homeFavCorner & 127) << 14)
      | (s.homeFavIconStyle === 1 ? 2097152 : 0)
      | (s.homeFavShadow === 1 ? 4194304 : 0)
    // 原版 logoinfo2（w9/k.java r0/W1 → i9.d，默认 193766400）：主页 Logo 设计打包 int——
    // 宽 bits0-6 / 高 bits7-13 / 圆角 bits14-20 / 字号 bits21-26(6b) / 粗体 bit27 / 斜体 bit28
    // （i9/d.java）；鸿蒙 homeLogoStyle 0常规/1粗体/2斜体/3粗斜体 → 粗体/斜体位
    st['logoinfo2'] = (s.homeLogoWidth & 127)
      | ((s.homeLogoHeight & 127) << 7)
      | ((s.homeLogoCorner & 127) << 14)
      | ((s.homeLogoSize & 63) << 21)
      | ((s.homeLogoStyle === 1 || s.homeLogoStyle === 3) ? 134217728 : 0)
      | ((s.homeLogoStyle === 2 || s.homeLogoStyle === 3) ? 268435456 : 0)
    // 原版 searchinfo（w9/k.java V2/W0 → i9.e，默认 2490468）：搜索框设计打包 int——
    // 圆角 bits0-6 / 不透明度 bits7-13 / 描边不透明度 bits14-20 / 描边宽 bits21-23(3b) /
    // 线条样式 bit24（i9/e.java）；鸿蒙 homePillStyle 0矩形/1线条 → bit24
    st['searchinfo'] = (s.homePillCorner & 127)
      | ((s.homePillOpacity & 127) << 7)
      | ((s.homePillStrokeOpacity & 127) << 14)
      | ((s.homePillStrokeWidth & 7) << 21)
      | (s.homePillStyle === 1 ? 16777216 : 0)
    // 原版 custominfo（w9/k.java X()/h1 → i9.b，默认 0）：主页高级设计打包 int——
    // 模糊 bit0 / 隐藏搜索区 bit1 / 背景不透明度 bits2-8（i9/b.java）；
    // 鸿蒙 homeAdvEffect 0透明/1模糊 → bit0、homeAdvArea 0展示/1隐藏 → bit1；
    // bits2-8 原版恒 0（i9.b.a() 无消费方），对齐写 0
    st['custominfo'] = (s.homeAdvEffect === 1 ? 1 : 0)
      | (s.homeAdvArea === 1 ? 2 : 0)
    // 原版 appui2（w9/k.java:1524/1046，默认 -1 自动）：界面布局 0传统/1工具栏在上/
    // 2工具栏在下/3双行（hb/n7.java 单选写 0-3）；-1 自动与 4 平板强制鸿蒙无对应，
    // 非默认不导（鸿蒙 appLayout 0-3 同序，默认 0=传统）
    if (s.appLayout !== 0) {
      st['appui2'] = s.appLayout
    }
    // 原版 urlbox（w9/k.java:973/185，默认 0）：地址栏内容 0标题/1地址/2域名（hb/n7.java 单选）；
    // 鸿蒙 addressBarContent 0-2 同序，默认不导
    if (s.addressBarContent !== 0) {
      st['urlbox'] = s.addressBarContent
    }
    // 原版 logochioce（w9/k.java:559/1100，默认 0）：主页 Logo 类型 0默认/1图片/2文字/
    // 3HTML/4无；鸿蒙 homeLogoType 0-4 同序，默认不导
    if (s.homeLogoType !== 0) {
      st['logochioce'] = s.homeLogoType
    }
    // 原版 fab 族 / urlbarcolor：默认值（80/12/13/23/1/-1）不导，与原版
    // 「pref 未定制不持久化 → L2 contains 不导」一致
    if (s.fab !== 80) {
      st['fab'] = s.fab
    }
    if (s.fableftaction !== 12) {
      st['fableftaction'] = s.fableftaction
    }
    if (s.fabrightaction !== 13) {
      st['fabrightaction'] = s.fabrightaction
    }
    if (s.fabupaction !== 23) {
      st['fabupaction'] = s.fabupaction
    }
    if (s.fabdownaction !== 1) {
      st['fabdownaction'] = s.fabdownaction
    }
    if (s.urlbarcolor !== -1) {
      st['urlbarcolor'] = s.urlbarcolor
    }
    // 原版 version（w9/k.java:956 f3 / 1406 t3）：偏好迁移版本 int（非应用版本号），
    // u3() 迁移链最高版本 = 14（x9.i=12、w9/k 内 a(12)/b(14)），安卓端导出恒为 14，
    // 对齐写 14；导入忽略（本工程无偏好迁移系统）
    st['version'] = 14
    st['webflag'] = webflag
    st['webflag2'] = s.simplifyUa ? 1 : 0
    st['appflag'] = appflag
    // 原版 long 白名单（w9/i.c）：updater_filter_subscriptions = 最近一次订阅规则更新时间戳；
    // 本工程取各订阅 lastUpdate 最大值。updater_scripts 本工程无脚本更新时间持久化，不导
    let lastFilterUpdate = 0
    for (let i = 0; i < s.ruleSubscriptions.length; i++) {
      if (s.ruleSubscriptions[i].lastUpdate > lastFilterUpdate) {
        lastFilterUpdate = s.ruleSubscriptions[i].lastUpdate
      }
    }
    if (lastFilterUpdate > 0) {
      st['updater_filter_subscriptions'] = lastFilterUpdate
    }
    return st
  }

  // settingsData 记录（ja/c.w：putOpt 跳过 null；时间戳 = Date.now()）
  // mode 0 = settings.txt（m9/l.g：跳过当前 UA 记录、当前引擎 selected）
  // mode 1 = data-for-older-versions kvdata（l9/i:41-47：type1 id==uachoice 跳过、
  // type2 id==uachoice 加 selected，基准同为 w9/k.l0()=uachoice）
  static settingsDataRecords(s: AppSettings, state: SettingsExportState, mode: number): Record<string, Object>[] {
    const records: Record<string, Object>[] = []
    const now = Date.now()
    for (let i = 0; i < s.customUaList.length; i++) {
      const skip = mode === 0 ? i === state.skipUaRecordIdx : (i + 1) === state.uachoice
      if (skip) {
        continue
      }
      const entry: CustomUaEntry = s.customUaList[i]
      const rec: Record<string, Object> = {}
      rec['id'] = i + 1
      rec['title'] = entry.title
      rec['content'] = entry.ua
      rec['flag'] = 0
      rec['type'] = 1
      rec['lastUpdatedAt'] = now
      rec['createdAt'] = now
      records.push(rec)
    }
    for (let i = 0; i < s.customEngines.length; i++) {
      const rec = s.customEngines[i]
      const item: Record<string, Object> = {}
      item['id'] = rec.id
      item['title'] = rec.name
      item['content'] = rec.template
      item['flag'] = 0
      item['type'] = 2
      item['lastUpdatedAt'] = now
      item['createdAt'] = now
      if (mode === 0) {
        if (rec.id === state.search2) {
          item['selected'] = true
        }
      } else if (rec.id === state.uachoice) {
        item['selected'] = true
      }
      records.push(item)
    }
    return records
  }

  // 单个 siteConf 序列化（ba/c.l：enabled 非零才写、flags 恒写）
  static siteConfRecord(site: SiteSetting): Record<string, Object> {
    // ba/b 位集：f2102c=enabled、f2103d=flags；U(bit,on,val) 同步写两个位集
    let enabled = 0
    let flags = 0
    // S(1)：启用总开关
    enabled = BackupSettings.bit(enabled, 1, true)
    flags = BackupSettings.bit(flags, 1, true)
    // Z(2)：JavaScript（ba/b.Z；禁用走 H(2) 清两个位集）
    enabled = BackupSettings.bit(enabled, 2, site.javaScript)
    flags = BackupSettings.bit(flags, 2, site.javaScript)
    // X(4)：图像（本工程 noImage 取反；禁用走 H(4)）
    enabled = BackupSettings.bit(enabled, 4, !site.noImage)
    flags = BackupSettings.bit(flags, 4, !site.noImage)
    // M(16)：广告拦截（allowAds=true 表示站点放行 → H(16) 清位）
    const blockAds = !site.allowAds
    enabled = BackupSettings.bit(enabled, 16, blockAds)
    flags = BackupSettings.bit(flags, 16, blockAds)
    const conf: Record<string, Object> = {}
    if (enabled !== 0) {
      conf['enabled'] = enabled
    }
    conf['flags'] = flags
    return conf
  }

  // l9/j：全站 siteConf map（host → ba/c.l）
  static siteConfMap(s: AppSettings): Record<string, Object> {
    const map: Record<string, Object> = {}
    for (let i = 0; i < s.siteSettings.length; i++) {
      const site: SiteSetting = s.siteSettings[i]
      if (site.host === '') {
        continue
      }
      map[site.host] = BackupSettings.siteConfRecord(site)
    }
    return map
  }

  // 订阅规则文件内容（rulesubs/<key>.block + .allow 合并行）
  private static readRuleFile(context: Context, key: string): string {
    const lines: string[] = []
    const paths = [`${context.filesDir}/rulesubs/${key}.block`, `${context.filesDir}/rulesubs/${key}.allow`]
    for (let i = 0; i < paths.length; i++) {
      try {
        if (fileIo.accessSync(paths[i])) {
          const content = fileIo.readTextSync(paths[i])
          if (content !== '') {
            const parts = content.split('\n')
            for (let j = 0; j < parts.length; j++) {
              if (parts[j] !== '') {
                lines.push(parts[j])
              }
            }
          }
        }
      } catch (error) {
      }
    }
    return lines.join('\n')
  }

  // 导入侧写订阅规则文件
  private static writeRuleFile(context: Context, key: string, content: string): void {
    try {
      const dir = `${context.filesDir}/rulesubs`
      try {
        fileIo.accessSync(dir)
      } catch (error) {
        fileIo.mkdirSync(dir)
      }
      const path = `${dir}/${key}.block`
      const file = fileIo.openSync(path, fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE | fileIo.OpenMode.TRUNC)
      try {
        fileIo.writeSync(file.fd, content)
      } finally {
        fileIo.closeSync(file)
      }
    } catch (error) {
      console.error(`write rule file failed: ${(error as Error).message}`)
    }
  }

  // 导出 settings.txt 全部内容；writeText 用于落盘附带文件
  // （script-*.txt 脚本代码、filters-*.txt 订阅规则、filters-custom.txt 自定义规则，
  // 与 settings.txt 平铺同目录）
  static async buildSettingsTxt(s: AppSettings, context: Context,
    writeText: (name: string, content: string) => void): Promise<string> {
    let out = ''

    // ---- meta（m9/l.e）----
    const meta: Record<string, Object> = {}
    meta['dataVersion'] = 1
    meta['appVersion'] = 20260920
    out += BackupSettings.line('meta', meta)

    // ---- settings（m9/l.c → w9/k.L2(false)）----
    const state = BackupSettings.collectExportState(s)
    const st = BackupSettings.buildSettingsRecord(s, state)
    out += BackupSettings.line('settings', st)

    // ---- settingsData（m9/l.g）----
    const records = BackupSettings.settingsDataRecords(s, state, 0)
    for (let i = 0; i < records.length; i++) {
      out += BackupSettings.line('settingsData', records[i])
    }

    // ---- siteConf（m9/l.h）----
    for (let i = 0; i < s.siteSettings.length; i++) {
      const site: SiteSetting = s.siteSettings[i]
      if (site.host === '') {
        continue
      }
      // m9/l.h：{"siteConf": {"<host>": {...}}}，host 为内层键
      const hostMap: Record<string, Object> = {}
      hostMap[site.host] = BackupSettings.siteConfRecord(site)
      out += BackupSettings.line('siteConf', hostMap)
    }

    // ---- script（m9/l.f：Collections.reverse 后倒序输出）----
    for (let i = s.userScripts.length - 1; i >= 0; i--) {
      const script: UserScriptRec = s.userScripts[i]
      const fileName = `script-${BackupSettings.namePrefix(script.name)}${script.id}.txt`
      writeText(fileName, script.code)
      const rec: Record<string, Object> = {}
      rec['scriptId'] = String(script.id)
      if (script.downloadUrl !== '') {
        rec['url'] = script.downloadUrl
      }
      if (script.name !== '') {
        rec['name'] = script.name
      }
      if (script.enabled) {
        rec['enabled'] = true
      }
      rec['path'] = fileName
      rec['lastUpdated'] = Date.now()
      out += BackupSettings.line('script', rec)
    }

    // ---- filters（m9/l.d:249-286）----
    for (let i = 0; i < s.ruleSubscriptions.length; i++) {
      const sub = s.ruleSubscriptions[i]
      if (sub.url === '') {
        continue
      }
      // 原版 f() 为已添加订阅列表：启用中或已有规则文件的订阅视为已添加
      const ruleContent = BackupSettings.readRuleFile(context, sub.key)
      if (!sub.enabled && ruleContent === '') {
        continue
      }
      const rec: Record<string, Object> = {}
      rec['url'] = sub.url
      if (sub.name !== '') {
        rec['title'] = sub.name
      }
      if (sub.enabled) {
        rec['enabled'] = true
      }
      if (ruleContent !== '') {
        const path = `filters-${BackupSettings.namePrefix(sub.name)}` +
          `${await BackupCrypto.md5Hex(sub.url)}.txt`
        rec['path'] = path
        writeText(path, ruleContent)
        rec['size'] = BackupCrypto.utf8Encode(ruleContent).length
        rec['lastUpdated'] = sub.lastUpdate
      }
      out += BackupSettings.line('filters', rec)
    }
    if (s.customRulesText !== '') {
      writeText('filters-custom.txt', s.customRulesText)
    }
    return out
  }

  // ---------------------------------------------------------------------
  // 导入（m9/l.b 1:1）：settings 行即时语义；EOF 后按
  // settingsData → siteConf → script → filters 顺序恢复
  // ---------------------------------------------------------------------

  private static getBool(obj: Record<string, Object> | null, key: string, def: boolean): boolean {
    if (obj === null) {
      return def
    }
    const v = obj[key]
    return typeof v === 'boolean' ? v : def
  }

  private static getNumber(obj: Record<string, Object> | null, key: string, def: number): number {
    if (obj === null) {
      return def
    }
    const v = obj[key]
    return typeof v === 'number' ? v : def
  }

  private static getString(obj: Record<string, Object> | null, key: string, def: string): string {
    if (obj === null) {
      return def
    }
    const v = obj[key]
    return typeof v === 'string' ? v : def
  }

  // m9/j.b：逗号串逐 token 重映射（负 id 原样；正 id 查 map 未命中丢弃；去重保序）
  private static remapIdList(raw: string, map: Record<string, number>): string {
    if (raw === '') {
      return raw
    }
    const tokens = raw.split(',')
    const seen: string[] = []
    let result = ''
    for (let i = 0; i < tokens.length; i++) {
      const token = tokens[i].trim()
      if (token === '') {
        continue
      }
      const n = Number(token)
      let mapped = token
      if (!Number.isNaN(n) && n > 0) {
        const target = map[token]
        if (target === undefined) {
          continue
        }
        mapped = String(target)
      }
      if (seen.indexOf(mapped) < 0) {
        seen.push(mapped)
        result += (result === '' ? '' : ',') + mapped
      }
    }
    return result
  }

  // m9/j.c：搜索快捷词 JSON 串引擎 id 键重映射（负 id 原样；0/正 id 查 map 未命中丢弃；
  // 去重；解析失败原样返回）
  private static remapShortcutJson(raw: string, map: Record<string, number>): string {
    if (raw === '') {
      return raw
    }
    try {
      const parsed = JSON.parse(raw) as Record<string, Object>
      const out: Record<string, Object> = {}
      const keys = Object.keys(parsed)
      for (let i = 0; i < keys.length; i++) {
        const n = Number(keys[i])
        if (Number.isNaN(n) || n === 0) {
          continue
        }
        let mapped = n
        if (n > 0) {
          const target = map[keys[i]]
          if (target === undefined) {
            continue
          }
          mapped = target
        }
        const mappedKey = String(mapped)
        if (out[mappedKey] === undefined) {
          out[mappedKey] = parsed[keys[i]]
        }
      }
      return JSON.stringify(out)
    } catch (error) {
      return raw
    }
  }

  // ba/b.u：enabledFlags(bit) 置位时读 flags(bit)，否则取默认
  private static siteBit(enabled: number, flags: number, bit: number, def: boolean): boolean {
    return (enabled & bit) !== 0 ? (flags & bit) !== 0 : def
  }

  // 导入 settings.txt；readFile 读取 ZIP 内附属文件（script-*.txt / filters-*.txt /
  // filters-custom.txt）
  static async applySettingsTxt(txt: string, readFile: (name: string) => string | null,
    s: AppSettings, context: Context): Promise<void> {
    const settingsLines: Record<string, Object>[] = []
    const settingsData: Record<string, Object>[] = []
    const siteConfLines: Record<string, Object>[] = []
    const scriptLines: Record<string, Object>[] = []
    const filterLines: Record<string, Object>[] = []
    const lines = txt.split('\n')
    for (let i = 0; i < lines.length; i++) {
      const lineText = lines[i].trim()
      if (lineText === '') {
        continue
      }
      try {
        const parsed = JSON.parse(lineText) as Record<string, Object>
        const keys = Object.keys(parsed)
        if (keys.length === 0) {
          continue
        }
        const type = keys[0]
        const inner = parsed[type]
        if (typeof inner !== 'object' || inner === null) {
          continue
        }
        const obj = inner as Record<string, Object>
        if (type === 'settings') {
          settingsLines.push(obj)
        } else if (type === 'settingsData') {
          settingsData.push(obj)
        } else if (type === 'siteConf') {
          siteConfLines.push(obj)
        } else if (type === 'script') {
          scriptLines.push(obj)
        } else if (type === 'filters') {
          filterLines.push(obj)
        }
      } catch (error) {
        console.error(`settings.txt line parse failed: ${(error as Error).message}`)
      }
    }
    if (settingsLines.length === 0 && settingsData.length === 0 && siteConfLines.length === 0
      && scriptLines.length === 0 && filterLines.length === 0) {
      return
    }

    // 最终写入通道：内部键名 kv → applyBackupKv（等价 w9/k.j1 四组白名单回写）
    const kv: Record<string, Object> = {}
    const st = settingsLines.length > 0 ? settingsLines[0] : null

    // ---- settings 行（m9/l.l → w9/k.j1）----
    if (st !== null) {
      if (typeof st['nightcss'] === 'boolean') {
        kv['nightCss'] = st['nightcss']
      }
      const home = BackupSettings.getString(st, 'home', '')
      if (home !== '') {
        if (home === 'about:blank') {
          kv['homepageMode'] = 2
        } else if (home === 'about:bookmarks') {
          kv['homepageMode'] = 3
        } else if (home !== 'about:home') {
          kv['homepageMode'] = 1
          kv['homeUrl'] = home
        }
      }
      const language = BackupSettings.getString(st, 'language', '')
      if (language === 'zh-CN') {
        kv['appLanguage'] = 1
      } else if (language === 'en-US') {
        kv['appLanguage'] = 2
      }
      if (typeof st['textsize'] === 'number') {
        kv['textZoom'] = st['textsize'] as number
      }
      if (typeof st['searchsuggestion'] === 'number') {
        kv['searchsuggestion'] = st['searchsuggestion'] as number
      }
      const intKeys: Record<string, string> = {
        'keyback': 'keyback',
        'keyforward': 'keyforward',
        'keyhome': 'keyhome',
        'keytab': 'keytab',
        'keymenu': 'keymenu',
        'gesturetoolbarleft': 'gesturetoolbarleft',
        'gesturetoolbarright': 'gesturetoolbarright',
        'restoreclosedtabs': 'restoreclosedtabs',
        'cleardataonexit2': 'clearOnExit',
        'nightfilter': 'nightFilter',
        'readertextsize': 'readerFontSize',
        'readerthemecolor': 'readerTheme'
      }
      const intKeyNames = Object.keys(intKeys)
      for (let i = 0; i < intKeyNames.length; i++) {
        const androidKey = intKeyNames[i]
        const v = st[androidKey]
        if (typeof v === 'number') {
          kv[intKeys[androidKey]] = v
        }
      }
      // ---- 原版 int 白名单中本工程有等价设置、需类型/语义转换的键 ----
      // fullscreenmode（w9/k.java:1341 d3 默认 0）：int 0/1 → 本工程 fullScreen bool
      if (typeof st['fullscreenmode'] === 'number') {
        kv['fullScreen'] = (st['fullscreenmode'] as number) !== 0
      }
      // screenOrientation（w9/k.java:1021 d3 默认 1）：1..4 直传（本工程 orientation 同语义）；
      // 同时写 orientationV2 标记跳过旧枚举迁移
      if (typeof st['screenOrientation'] === 'number') {
        kv['orientation'] = st['screenOrientation'] as number
        kv['orientationV2'] = 1
      }
      // favinfo（i9/c 位布局）：宽 bits0-6 / 高 bits7-13 / 圆角 bits14-20 /
      // 隐藏图标 bit21 / 无彩色 bit22 → 鸿蒙分散键
      if (typeof st['favinfo'] === 'number') {
        const favinfo = st['favinfo'] as number
        kv['homeFavWidth'] = favinfo & 127
        kv['homeFavHeight'] = (favinfo >> 7) & 127
        kv['homeFavCorner'] = (favinfo >> 14) & 127
        kv['homeFavIconStyle'] = (favinfo & 2097152) !== 0 ? 1 : 0
        kv['homeFavShadow'] = (favinfo & 4194304) !== 0 ? 1 : 0
      }
      // logoinfo2（i9/d 位布局）：宽 bits0-6 / 高 bits7-13 / 圆角 bits14-20 /
      // 字号 bits21-26(6b) / 粗体 bit27 / 斜体 bit28 → 鸿蒙分散键（style 0常规/1粗体/2斜体/3粗斜体）
      if (typeof st['logoinfo2'] === 'number') {
        const logoinfo2 = st['logoinfo2'] as number
        kv['homeLogoWidth'] = logoinfo2 & 127
        kv['homeLogoHeight'] = (logoinfo2 >> 7) & 127
        kv['homeLogoCorner'] = (logoinfo2 >> 14) & 127
        kv['homeLogoSize'] = (logoinfo2 >> 21) & 63
        const bold = (logoinfo2 & 134217728) !== 0
        const italic = (logoinfo2 & 268435456) !== 0
        kv['homeLogoStyle'] = (bold ? 1 : 0) + (italic ? 2 : 0)
      }
      // searchinfo（i9/e 位布局）：圆角 bits0-6 / 不透明度 bits7-13 / 描边不透明度 bits14-20 /
      // 描边宽 bits21-23(3b) / 线条样式 bit24 → 鸿蒙分散键
      if (typeof st['searchinfo'] === 'number') {
        const searchinfo = st['searchinfo'] as number
        kv['homePillCorner'] = searchinfo & 127
        kv['homePillOpacity'] = (searchinfo >> 7) & 127
        kv['homePillStrokeOpacity'] = (searchinfo >> 14) & 127
        kv['homePillStrokeWidth'] = (searchinfo >> 21) & 7
        kv['homePillStyle'] = (searchinfo & 16777216) !== 0 ? 1 : 0
      }
      // custominfo（i9/b 位布局）：模糊 bit0 / 隐藏搜索区 bit1 /
      // 背景不透明度 bits2-8（原版无消费方，忽略）→ 鸿蒙分散键
      if (typeof st['custominfo'] === 'number') {
        const custominfo = st['custominfo'] as number
        kv['homeAdvEffect'] = (custominfo & 1) !== 0 ? 1 : 0
        kv['homeAdvArea'] = (custominfo & 2) !== 0 ? 1 : 0
      }
      // appui2（w9/k.java:1524，默认 -1）：0传统/1工具栏在上/2工具栏在下/3双行（hb/n7.java）；
      // 鸿蒙 appLayout 0-3 同序；-1 自动与 4 平板强制鸿蒙无对应，忽略
      if (typeof st['appui2'] === 'number') {
        const appui2 = st['appui2'] as number
        if (appui2 >= 0 && appui2 <= 3) {
          kv['appLayout'] = appui2
        }
      }
      // urlbox（w9/k.java:973，默认 0）：0标题/1地址/2域名；鸿蒙 addressBarContent 同序
      if (typeof st['urlbox'] === 'number') {
        const urlbox = st['urlbox'] as number
        if (urlbox >= 0 && urlbox <= 2) {
          kv['addressBarContent'] = urlbox
        }
      }
      // logochioce（w9/k.java:559，默认 0）：0默认/1图片/2文字/3HTML/4无；
      // 鸿蒙 homeLogoType 0-4 同序
      if (typeof st['logochioce'] === 'number') {
        const logochioce = st['logochioce'] as number
        if (logochioce >= 0 && logochioce <= 4) {
          kv['homeLogoType'] = logochioce
        }
      }
      // videoorientation / cleardata2 / labflag：键名与默认值（0/7/0）均与原版一致，直传
      // bookmarksviewmode / bookmarksorder：键名与默认值（0/0）与原版一致，直传（功能未实施仅存储）
      // fab 族 / urlbarcolor：键名与默认值（80/12/13/23/1/-1）与原版一致，直传（功能未实施仅存储）
      const intDirectKeys: string[] = ['videoorientation', 'cleardata2', 'labflag',
        'bookmarksviewmode', 'bookmarksorder',
        'fab', 'fableftaction', 'fabrightaction', 'fabupaction', 'fabdownaction', 'urlbarcolor']
      for (let dk = 0; dk < intDirectKeys.length; dk++) {
        const rawKey = intDirectKeys[dk]
        if (typeof st[rawKey] === 'number') {
          kv[rawKey] = st[rawKey] as number
        }
      }
      // csstheme（原版 pref 存 Base64；getter v0.a 解码+trim，w9/k.java:869-875）
      const csstheme = BackupSettings.getString(st, 'csstheme', '')
      if (csstheme !== '') {
        kv['customCss'] = BackupCrypto.utf8Decode(BackupCrypto.base64Decode(csstheme)).trim()
      }
      // readercustomcss（原版 pref 存 Base64；getter v0.a 解码，w9/k.java:1545）
      const readercustomcss = BackupSettings.getString(st, 'readercustomcss', '')
      if (readercustomcss !== '') {
        kv['readerCustomCss'] = BackupCrypto.utf8Decode(BackupCrypto.base64Decode(readercustomcss)).trim()
      }
      // videoplayer / dlmanager：字符串直传（本工程内部键 videoPlayer/dlManager）
      const videoplayer = BackupSettings.getString(st, 'videoplayer', '')
      if (videoplayer !== '') {
        kv['videoPlayer'] = videoplayer
      }
      const dlmanager = BackupSettings.getString(st, 'dlmanager', '')
      if (dlmanager !== '') {
        kv['dlManager'] = dlmanager
      }
      // displayedmenus / hiddenmenus（逗号数字串 → 本工程字符串 id 数组 JSON）
      const displayedmenus = BackupSettings.getString(st, 'displayedmenus', '')
      if (displayedmenus !== '') {
        const keys = menuIdCsvToKeys(displayedmenus)
        if (keys.length > 0) {
          kv['menuOrder'] = JSON.stringify(keys)
        }
      }
      const hiddenmenus = BackupSettings.getString(st, 'hiddenmenus', '')
      if (hiddenmenus !== '') {
        kv['menuHidden'] = JSON.stringify(menuIdCsvToKeys(hiddenmenus))
      }
      // updater_filter_subscriptions / updater_scripts（long 白名单）：
      // 本工程无单一时间戳存储（订阅时间为逐条 lastUpdate），导入忽略
      // webflag（w9/p）位分解
      if (typeof st['webflag'] === 'number') {
        const webflag = st['webflag'] as number
        kv['adBlockOn'] = (webflag & 268435456) === 0
        kv['jsEnabled'] = (webflag & 8) !== 0
        kv['noImage'] = (webflag & 16) === 0
        kv['doNotTrack'] = (webflag & 128) !== 0
        kv['dataSaver'] = (webflag & 256) !== 0
        kv['desktopAllSites'] = (webflag & 2048) !== 0 ? 1 : 0
        kv['allowDebugWeb'] = (webflag & 4096) !== 0
        kv['doNotSell'] = (webflag & 65536) !== 0
        kv['disableWebRtc'] = (webflag & 536870912) !== 0
      }
      // webflag2（w9/o）：bit1 = 自定义 UA 兼容规整
      if (typeof st['webflag2'] === 'number') {
        const webflag2 = st['webflag2'] as number
        kv['simplifyUa'] = (webflag2 & 1) !== 0
      }
      // appflag（w9/a）：bit5 滑动前进后退 / bit3 音量键翻页
      if (typeof st['appflag'] === 'number') {
        const appflag = st['appflag'] as number
        kv['swipeSwitchTab'] = (appflag & 32) !== 0
        kv['volumePageFlip'] = (appflag & 8) !== 0
      }
      // 桌面 UA（duachoice/duastring，z8/b4.c）
      const duachoice = BackupSettings.getNumber(st, 'duachoice', 0)
      if (duachoice === 0) {
        kv['desktopUaKey'] = 'win_chrome'
      } else if (duachoice === -4) {
        kv['desktopUaKey'] = 'win_ie11'
      } else if (duachoice === -5) {
        kv['desktopUaKey'] = 'mac'
      } else if (duachoice >= 1) {
        kv['desktopUaKey'] = 'custom'
        kv['desktopCustomUa'] = BackupSettings.getString(st, 'duastring', '')
      }
      const searchtoolbarorder = BackupSettings.getString(st, 'searchtoolbarorder', '')
      if (searchtoolbarorder !== '') {
        kv['searchToolbarOrder'] = searchtoolbarorder
      }
      const searchtoolbardisabled = BackupSettings.getString(st, 'searchtoolbardisabled', '')
      if (searchtoolbardisabled !== '') {
        kv['searchToolbarDisabled'] = searchtoolbardisabled
      }
      // searchshortcuts（w9/k.java:943 f1）：搜索快捷词 JSON 串，原样存储，
      // 引擎 id 键在 settingsData 合并后重映射（m9/l.k → m9/j.c）
      const searchshortcuts = BackupSettings.getString(st, 'searchshortcuts', '')
      if (searchshortcuts !== '') {
        kv['searchshortcuts'] = searchshortcuts
      }
      // taghome（w9/k.java:751/1571）：主页 logo 内容（Base64 编码，v0.b(trim))；
      // 原版形态由 logochioce 区分（不在本批映射），按解码内容推断归入本工程 logo 存储：
      // '<br>'→无、'<img'开头→图片(取 src)、含'<'→HTML、其余→文字
      const taghome = BackupSettings.getString(st, 'taghome', '')
      if (taghome !== '') {
        const logoContent = BackupCrypto.utf8Decode(BackupCrypto.base64Decode(taghome)).trim()
        if (logoContent === '<br>') {
          kv['homeLogoType'] = 4
        } else if (logoContent.startsWith('<img')) {
          const srcMatch = logoContent.match(/src="([^"]*)"/)
          if (srcMatch !== null && srcMatch.length > 1) {
            kv['homeLogoType'] = 1
            kv['homeLogoImage'] = srcMatch[1]
          } else {
            kv['homeLogoType'] = 3
            kv['homeLogoHtml'] = logoContent
          }
        } else if (logoContent.includes('<')) {
          kv['homeLogoType'] = 3
          kv['homeLogoHtml'] = logoContent
        } else {
          kv['homeLogoType'] = 2
          kv['homeLogoText'] = logoContent
        }
      }
      // version（w9/k.java:956）：偏好迁移版本，本工程无迁移系统，导入忽略
    }

    // ---- settingsData（m9/l.o → ja/c.n 恢复）----
    // type2 自定义引擎：按 title 合并现有记录，id 沿用现有或自增；建 旧id→新id 映射
    let engines: CustomEngineRec[] = []
    for (let i = 0; i < s.customEngines.length; i++) {
      engines.push(s.customEngines[i])
    }
    let maxEngineId = 0
    for (let i = 0; i < engines.length; i++) {
      if (engines[i].id > maxEngineId) {
        maxEngineId = engines[i].id
      }
    }
    const engineIdMap: Record<string, number> = {}
    let selectedEngineId = -1
    // type1 自定义 UA：按 title 合并现有列表；记录 id→条目（uachoice 指向）
    let uaList: CustomUaEntry[] = []
    for (let i = 0; i < s.customUaList.length; i++) {
      uaList.push(s.customUaList[i])
    }
    const uaById: Record<string, CustomUaEntry> = {}
    let uachoice = BackupSettings.getNumber(st, 'uachoice', 0)
    const uastring = BackupSettings.getString(st, 'uastring', '')
    for (let i = 0; i < settingsData.length; i++) {
      const rec = settingsData[i]
      const type = BackupSettings.getNumber(rec, 'type', 0)
      const id = BackupSettings.getNumber(rec, 'id', 0)
      const title = BackupSettings.getString(rec, 'title', '')
      const content = BackupSettings.getString(rec, 'content', '')
      if (type === 2 && title !== '' && content !== '') {
        let newId = -1
        for (let j = 0; j < engines.length; j++) {
          if (engines[j].name === title) {
            newId = engines[j].id
            break
          }
        }
        if (newId < 0) {
          maxEngineId++
          newId = maxEngineId
          engines.push(new CustomEngineRec(title, content, newId))
        }
        engineIdMap[String(id)] = newId
        if (BackupSettings.getBool(rec, 'selected', false)) {
          selectedEngineId = newId
        }
      } else if (type === 1 && title !== '' && content !== '') {
        let exists = false
        for (let j = 0; j < uaList.length; j++) {
          if (uaList[j].title === title) {
            uaById[String(id)] = uaList[j]
            exists = true
            break
          }
        }
        if (!exists) {
          const entry = new CustomUaEntry(title, content)
          uaList.push(entry)
          uaById[String(id)] = entry
        }
      }
    }
    if (engines.length > 0) {
      const payload: Record<string, Object>[] = []
      for (let i = 0; i < engines.length; i++) {
        const entry: Record<string, Object> = {}
        entry['name'] = engines[i].name
        entry['template'] = engines[i].template
        entry['id'] = engines[i].id
        payload.push(entry)
      }
      kv['customEngines'] = JSON.stringify(payload)
    }
    if (uaList.length > 0) {
      const payload: Record<string, Object>[] = []
      for (let i = 0; i < uaList.length; i++) {
        const entry: Record<string, Object> = {}
        entry['title'] = uaList[i].title
        entry['ua'] = uaList[i].ua
        payload.push(entry)
      }
      kv['customUaList'] = JSON.stringify(payload)
    }
    // 搜索引擎（m9/l.o selected → w9/l.q；k() id 重映射 order/disabled）
    // search2 缺省时不动 engineKey（原版 j1 仅在键存在时回写）
    const search2Present = st !== null && typeof st['search2'] === 'number'
    const search2 = search2Present ? st['search2'] as number : 0
    if (selectedEngineId >= 1) {
      kv['engineKey'] = `custom:${selectedEngineId}`
    } else if (search2Present && search2 < 0) {
      const builtin = builtinKeyById(search2)
      if (builtin !== null) {
        kv['engineKey'] = builtin
      }
    } else if (search2Present && search2 >= 1) {
      const mapped = engineIdMap[String(search2)]
      if (mapped !== undefined) {
        kv['engineKey'] = `custom:${mapped}`
      } else {
        // 记录缺失：回退 searchurl 模板（z8/v2.c 自定义分支）
        const searchurl = BackupSettings.getString(st, 'searchurl', '')
        if (searchurl !== '') {
          kv['engineKey'] = `custom:${search2}`
          kv['customEngineTemplate'] = searchurl
        }
      }
    }
    const orderRaw = typeof kv['searchToolbarOrder'] === 'string' ? kv['searchToolbarOrder'] as string : ''
    if (orderRaw !== '') {
      kv['searchToolbarOrder'] = BackupSettings.remapIdList(orderRaw, engineIdMap)
    }
    const disabledRaw = typeof kv['searchToolbarDisabled'] === 'string'
      ? kv['searchToolbarDisabled'] as string : ''
    if (disabledRaw !== '') {
      kv['searchToolbarDisabled'] = BackupSettings.remapIdList(disabledRaw, engineIdMap)
    }
    // searchshortcuts：引擎 id JSON 键重映射（m9/l.java:439 → m9/j.c）
    const shortcutsRaw = typeof kv['searchshortcuts'] === 'string'
      ? kv['searchshortcuts'] as string : ''
    if (shortcutsRaw !== '') {
      kv['searchshortcuts'] = BackupSettings.remapShortcutJson(shortcutsRaw, engineIdMap)
    }
    // 浏览器标识：uachoice>0 → type1 记录 content / uastring（z8/b4.c 默认分支）
    if (uachoice >= 1) {
      const entry = uaById[String(uachoice)]
      kv['uaKey'] = 'custom'
      kv['customUa'] = entry !== undefined ? entry.ua : uastring
    } else if (uachoice <= 0) {
      if (uachoice === 0) {
        kv['uaKey'] = 'default'
      } else {
        const presetKeys = ['default', 'android_phone', 'android_tablet', 'win_chrome', 'win_ie11',
          'mac', 'iphone', 'ipad', 'symbian']
        const idx = -uachoice
        if (idx >= 1 && idx < presetKeys.length) {
          kv['uaKey'] = presetKeys[idx]
        } else {
          kv['uaKey'] = 'default'
        }
      }
    }

    // ---- siteConf（m9/l.p → ba/c.j → ba/b.u 位分解）----
    if (siteConfLines.length > 0) {
      const sites: SiteSetting[] = []
      for (let i = 0; i < s.siteSettings.length; i++) {
        sites.push(s.siteSettings[i])
      }
      for (let i = 0; i < siteConfLines.length; i++) {
        const lineObj = siteConfLines[i]
        const hosts = Object.keys(lineObj)
        for (let j = 0; j < hosts.length; j++) {
          const host = hosts[j]
          if (host === '') {
            continue
          }
          const conf = lineObj[host]
          if (typeof conf !== 'object' || conf === null) {
            continue
          }
          const confObj = conf as Record<string, Object>
          const enabled = BackupSettings.getNumber(confObj, 'enabled', 0)
          const flags = BackupSettings.getNumber(confObj, 'flags', 0)
          const site = new SiteSetting(host)
          site.javaScript = BackupSettings.siteBit(enabled, flags, 2, true)
          site.noImage = !BackupSettings.siteBit(enabled, flags, 4, true)
          site.allowAds = !BackupSettings.siteBit(enabled, flags, 16, true)
          // uastring/uachoice/textsize：本工程 SiteSetting 无对应字段，跳过
          let replaced = false
          for (let k = 0; k < sites.length; k++) {
            if (sites[k].host === host) {
              sites[k] = site
              replaced = true
              break
            }
          }
          if (!replaced) {
            sites.push(site)
          }
        }
      }
      const payload: Record<string, Object>[] = []
      for (let i = 0; i < sites.length; i++) {
        const entry: Record<string, Object> = {}
        entry['host'] = sites[i].host
        entry['pcMode'] = sites[i].pcMode
        entry['noImage'] = sites[i].noImage
        entry['allowAds'] = sites[i].allowAds
        entry['forceDark'] = sites[i].forceDark
        entry['javaScript'] = sites[i].javaScript
        payload.push(entry)
      }
      kv['siteSettings'] = JSON.stringify(payload)
    }

    // ---- script（m9/l.n）----
    if (scriptLines.length > 0) {
      const scripts: UserScriptRec[] = []
      for (let i = 0; i < s.userScripts.length; i++) {
        scripts.push(s.userScripts[i])
      }
      let nextId = s.scriptNextId
      for (let i = 0; i < scriptLines.length; i++) {
        const lineObj = scriptLines[i]
        const name = BackupSettings.getString(lineObj, 'name', '')
        const path = BackupSettings.getString(lineObj, 'path', '')
        let code = ''
        if (path !== '') {
          const fileContent = readFile(path)
          if (fileContent !== null) {
            code = fileContent
          }
        }
        // inline "code" 为 d1.a GZIP+Base64 编码（非 ZIP 场景），ZIP 备份不出现，跳过
        if (code === '') {
          continue
        }
        const enabled = BackupSettings.getBool(lineObj, 'enabled', false)
        const url = BackupSettings.getString(lineObj, 'url', '')
        let target = -1
        for (let j = 0; j < scripts.length; j++) {
          if (scripts[j].name === name && (name !== '' || scripts[j].downloadUrl === url)) {
            target = j
            break
          }
        }
        if (target >= 0) {
          scripts[target].code = code
          scripts[target].enabled = enabled
          if (url !== '') {
            scripts[target].downloadUrl = url
          }
        } else {
          const rec = new UserScriptRec()
          rec.id = nextId
          nextId++
          rec.name = name
          rec.code = code
          rec.enabled = enabled
          rec.downloadUrl = url
          scripts.push(rec)
        }
      }
      const payload: Record<string, Object>[] = []
      for (let i = 0; i < scripts.length; i++) {
        const entry: Record<string, Object> = {}
        entry['id'] = scripts[i].id
        entry['name'] = scripts[i].name
        entry['code'] = scripts[i].code
        entry['enabled'] = scripts[i].enabled
        entry['includes'] = scripts[i].includes
        entry['excludes'] = scripts[i].excludes
        entry['runAt'] = scripts[i].runAt
        entry['grantBits'] = scripts[i].grantBits
        entry['unwrap'] = scripts[i].unwrap
        entry['downloadUrl'] = scripts[i].downloadUrl
        entry['homepageUrl'] = scripts[i].homepageUrl
        entry['version'] = scripts[i].version
        entry['requires'] = scripts[i].requires
        payload.push(entry)
      }
      kv['userScripts'] = JSON.stringify(payload)
      kv['scriptNextId'] = nextId
    }

    // ---- filters（m9/l.m → u4/a.h：订阅按 url 合并 + 规则文件落盘）----
    let subsChanged = false
    let firstUrl = ''
    let newKeySeq = 0
    for (let i = 0; i < filterLines.length; i++) {
      const lineObj = filterLines[i]
      const url = BackupSettings.getString(lineObj, 'url', '')
      if (url === '') {
        continue
      }
      if (firstUrl === '') {
        firstUrl = url
      }
      const title = BackupSettings.getString(lineObj, 'title', '')
      const enabled = BackupSettings.getBool(lineObj, 'enabled', false)
      const lastUpdated = BackupSettings.getNumber(lineObj, 'lastUpdated', 0)
      const path = BackupSettings.getString(lineObj, 'path', '')
      let ruleContent = ''
      if (path !== '') {
        const fileContent = readFile(path)
        if (fileContent !== null) {
          ruleContent = fileContent
        }
      }
      let targetIdx = -1
      for (let j = 0; j < s.ruleSubscriptions.length; j++) {
        if (s.ruleSubscriptions[j].url === url) {
          targetIdx = j
          break
        }
      }
      if (targetIdx >= 0) {
        const sub = s.ruleSubscriptions[targetIdx]
        if (ruleContent !== '') {
          BackupSettings.writeRuleFile(context, sub.key, ruleContent)
          sub.lastUpdate = lastUpdated
          subsChanged = true
        }
      } else {
        // 新订阅（u4/a.h b() → c.g(url) 添加）
        const key = `c${Date.now()}${newKeySeq}`
        newKeySeq++
        const entry = new RuleSubEntry(key, title !== '' ? title : url, url, enabled, 0, lastUpdated, false)
        s.ruleSubscriptions.push(entry)
        if (ruleContent !== '') {
          BackupSettings.writeRuleFile(context, key, ruleContent)
        }
        subsChanged = true
      }
    }
    if (subsChanged) {
      s.saveRuleSubs()
    }
    if (firstUrl !== '') {
      kv['ruleSubUrl'] = firstUrl
    }
    const customFilters = readFile('filters-custom.txt')
    if (customFilters !== null && customFilters !== '') {
      // 原版 m()：本地与备份自定义规则逐行并集去重
      const merged: string[] = []
      const sources: string[] = [s.customRulesText, customFilters]
      for (let sIdx = 0; sIdx < sources.length; sIdx++) {
        const parts = sources[sIdx].split('\n')
        for (let i = 0; i < parts.length; i++) {
          const ruleLine = parts[i].trim()
          if (ruleLine !== '' && merged.indexOf(ruleLine) < 0) {
            merged.push(ruleLine)
          }
        }
      }
      kv['customRulesText'] = merged.join('\n')
    }

    await s.applyBackupKv(kv)
  }
}
