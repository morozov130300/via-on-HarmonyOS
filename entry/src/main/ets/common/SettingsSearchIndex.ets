// 设置内搜索：全部设置条目的集中索引
// 条目 = { label: 展示文案（资源引用或字面量）, desc: 副标题（可选）, route: 点击结果跳转的路由名, params: 路由参数（可选） }
// 点击结果跳 nav 条目的目标页；开关/弹窗类条目跳其所在设置页
export class SettingsIndexEntry {
  label: ResourceStr
  desc?: ResourceStr
  route: string
  // 路由参数（JSON 字符串，与 SiteSettingsPage.openPermission 的传递方式一致）
  params?: string

  constructor(label: ResourceStr, route: string, desc?: ResourceStr, params?: string) {
    this.label = label
    this.desc = desc
    this.route = route
    this.params = params
  }
}

// 设置首页分类行（原版 hb/o6）
function rootEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.general'), 'settingsGeneral'),
    new SettingsIndexEntry($r('app.string.customize'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.privacy'), 'settingsPrivacy'),
    new SettingsIndexEntry($r('app.string.advanced'), 'settingsAdvanced'),
    new SettingsIndexEntry($r('app.string.scripts'), 'userScripts'),
    new SettingsIndexEntry($r('app.string.orig_ic'), 'settingsExperimental'),
    new SettingsIndexEntry($r('app.string.about'), 'settingsAbout')
  ]
}

// 通用（SettingsGeneralPage）
function generalEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.sync'), 'syncPage'),
    new SettingsIndexEntry($r('app.string.browser_ua'), 'uaPage'),
    new SettingsIndexEntry($r('app.string.clear_data'), 'settingsGeneral'),
    new SettingsIndexEntry($r('app.string.ad_block'), 'settingsAdBlock'),
    new SettingsIndexEntry($r('app.string.site_settings'), 'siteSettings'),
    new SettingsIndexEntry($r('app.string.password_manager'), 'settingsGeneral'),
    new SettingsIndexEntry($r('app.string.night_mode'), 'settingsNight'),
    new SettingsIndexEntry($r('app.string.reader_mode'), 'settingsReader'),
    new SettingsIndexEntry($r('app.string.toolbar_settings'), 'toolbarCustom'),
    new SettingsIndexEntry($r('app.string.customize_menu'), 'menuCustom'),
    new SettingsIndexEntry($r('app.string.customize_long_press_menu'), 'longPressCustom'),
    new SettingsIndexEntry($r('app.string.language'), 'settingsGeneral'),
    new SettingsIndexEntry($r('app.string.home_page'), 'settingsGeneral'),
    new SettingsIndexEntry($r('app.string.search_settings'), 'settingsSearch'),
    new SettingsIndexEntry($r('app.string.ai_settings'), 'aiSettings'),
    new SettingsIndexEntry($r('app.string.screen_orientation'), 'settingsGeneral'),
    new SettingsIndexEntry($r('app.string.orig_go'), 'settingsGeneral'),
    new SettingsIndexEntry($r('app.string.orig_bf'), 'settingsGeneral'),
    new SettingsIndexEntry($r('app.string.orig_in'), 'settingsGeneral'),
    new SettingsIndexEntry($r('app.string.orig_dr'), 'settingsGeneral'),
    new SettingsIndexEntry($r('app.string.orig_jn'), 'fontPage'),
    new SettingsIndexEntry($r('app.string.orig_to'), 'settingsGesture', $r('app.string.orig_pi')),
    new SettingsIndexEntry($r('app.string.orig_l6'), 'settingsGeneral'),
    new SettingsIndexEntry($r('app.string.orig_l1'), 'settingsGeneral'),
    new SettingsIndexEntry($r('app.string.orig_f7'), 'settingsGeneral', $r('app.string.orig_ih')),
    new SettingsIndexEntry($r('app.string.orig_s3'), 'settingsGeneral'),
    new SettingsIndexEntry($r('app.string.orig_tz'), 'settingsGeneral', $r('app.string.orig_u0')),
    new SettingsIndexEntry($r('app.string.orig_ti'), 'settingsGeneral')
  ]
}

// 主页定制（SettingsCustomPage）
function customEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.orig_ud'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_a1v'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_k8'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_en'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_ua'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_jo'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_ow'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_v3'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_v2'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_st'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_ub'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_yc'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_j4'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_j1'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_sq'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_t1'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_et'), 'homeCss'),
    new SettingsIndexEntry($r('app.string.orig_j0'), 'settingsCustom'),
    new SettingsIndexEntry($r('app.string.orig_ez'), 'settingsCustom')
  ]
}

// 隐私（SettingsPrivacyPage）
function privacyEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.do_not_track'), 'settingsPrivacy'),
    new SettingsIndexEntry($r('app.string.disable_webrtc'), 'settingsPrivacy'),
    new SettingsIndexEntry($r('app.string.do_not_sell'), 'settingsPrivacy', $r('app.string.do_not_sell_desc'))
  ]
}

// 高级（SettingsAdvancedPage）
function advancedEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.data_saver'), 'settingsAdvanced', $r('app.string.data_saver_desc')),
    new SettingsIndexEntry($r('app.string.auto_sniff_button'), 'settingsAdvanced'),
    new SettingsIndexEntry($r('app.string.allow_web_debug'), 'settingsAdvanced'),
    new SettingsIndexEntry($r('app.string.disable_safe_browsing'), 'settingsAdvanced', $r('app.string.orig_yo')),
    new SettingsIndexEntry($r('app.string.ignore_ssl_warning'), 'sslWhitelist', $r('app.string.orig_yx'))
  ]
}

// 脚本（SettingsScriptPage）
function scriptEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.enable_script'), 'settingsScript')
  ]
}

// 代理（SettingsProxyPage，条目为硬编码文案）
function proxyEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry('Enable proxy', 'settingsProxy'),
    new SettingsIndexEntry('Proxy url', 'settingsProxy'),
    new SettingsIndexEntry('Reverse bypass rules', 'settingsProxy'),
    new SettingsIndexEntry('Add proxy rule', 'settingsProxy'),
    new SettingsIndexEntry('Add bypass rule', 'settingsProxy')
  ]
}

// 实验（SettingsExperimentalPage）
function experimentalEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.orig_uf'), 'skinPage'),
    new SettingsIndexEntry($r('app.string.orig_cy'), 'settingsExperimental', $r('app.string.orig_cz')),
    new SettingsIndexEntry($r('app.string.orig_tu'), 'settingsExperimental'),
    new SettingsIndexEntry($r('app.string.log_file_title'), 'settingsExperimental', $r('app.string.log_file_desc')),
    new SettingsIndexEntry($r('app.string.log_verbose_title'), 'settingsExperimental', $r('app.string.log_verbose_desc')),
    new SettingsIndexEntry($r('app.string.log_export_title'), 'settingsExperimental', $r('app.string.log_export_desc'))
  ]
}

// 搜索设置（SettingsSearchPage + SettingsSearchToolbarPage）
function searchEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.search_engine'), 'settingsSearch'),
    new SettingsIndexEntry($r('app.string.search_suggestion'), 'settingsSearch'),
    new SettingsIndexEntry($r('app.string.orig_t9'), 'settingsSearchToolbar'),
    new SettingsIndexEntry($r('app.string.orig_hn'), 'settingsSearchToolbar')
  ]
}

// 工具栏（SettingsToolbarPage）
function toolbarEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.app_layout'), 'toolbarCustom'),
    new SettingsIndexEntry($r('app.string.auto_hide_toolbar'), 'toolbarCustom'),
    new SettingsIndexEntry($r('app.string.enable_tab_bar'), 'toolbarCustom'),
    new SettingsIndexEntry($r('app.string.address_content'), 'toolbarCustom'),
    new SettingsIndexEntry($r('app.string.color_mode'), 'toolbarCustom', $r('app.string.color_mode_desc'))
  ]
}

// 广告拦截（SettingsAdBlockPage）
function adBlockEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.ad_block'), 'settingsAdBlock'),
    new SettingsIndexEntry($r('app.string.orig_hj'), 'settingsAdBlock', $r('app.string.orig_hk')),
    new SettingsIndexEntry($r('app.string.custom_rules'), 'rules', $r('app.string.orig_ew')),
    new SettingsIndexEntry($r('app.string.orig_jf'), 'ruleSub', $r('app.string.orig_jg')),
    new SettingsIndexEntry($r('app.string.orig_ia'), 'settingsAdBlock', $r('app.string.orig_ib'))
  ]
}

// 手势（SettingsGesturePage）
function gestureEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.orig_cm'), 'settingsGesture'),
    new SettingsIndexEntry($r('app.string.orig_a1l'), 'settingsGesture'),
    new SettingsIndexEntry($r('app.string.orig_hq'), 'settingsGesture', $r('app.string.orig_hr')),
    new SettingsIndexEntry($r('app.string.orig_m5'), 'keyboardShortcuts')
  ]
}

// 夜间模式（SettingsNightPage）
function nightEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.night_filter_opacity'), 'settingsNight'),
    new SettingsIndexEntry($r('app.string.night_force_dark'), 'settingsNight', $r('app.string.night_force_dark_desc'))
  ]
}

// 阅读模式（SettingsReaderPage）
function readerEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.reader_confirm'), 'settingsReader'),
    new SettingsIndexEntry($r('app.string.font_size'), 'settingsReader'),
    new SettingsIndexEntry($r('app.string.custom_reader_css'), 'readerCss')
  ]
}

// AI（SettingsAiPage + SettingsAiProvidersPage）
function aiEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.ai_provider'), 'aiProviders'),
    new SettingsIndexEntry($r('app.string.ai_prompts'), 'aiPrompts'),
    new SettingsIndexEntry($r('app.string.ai_none_label'), 'aiProviders')
  ]
}

// 网站设定（SiteSettingsPage）
function siteEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.all_sites'), 'siteAll'),
    new SettingsIndexEntry($r('app.string.text_size'), 'fontSettings'),
    new SettingsIndexEntry($r('app.string.browser_ua'), 'uaException'),
    new SettingsIndexEntry($r('app.string.pc_mode'), 'desktopMode'),
    new SettingsIndexEntry($r('app.string.orig_kt'), 'imageSetting'),
    new SettingsIndexEntry('JavaScript', 'jsSetting'),
    new SettingsIndexEntry('Cookies', 'cookiesSetting'),
    new SettingsIndexEntry($r('app.string.orig_qw'), 'popupSetting'),
    new SettingsIndexEntry($r('app.string.ad_block'), 'adBlockException'),
    new SettingsIndexEntry($r('app.string.orig_dx'), 'permissionPage', undefined, '{"kind":"clipboard"}'),
    new SettingsIndexEntry($r('app.string.orig_oz'), 'permissionPage', undefined, '{"kind":"openapp"}'),
    new SettingsIndexEntry($r('app.string.orig_mh'), 'permissionPage', undefined, '{"kind":"geo"}'),
    new SettingsIndexEntry($r('app.string.perm_camera_label'), 'permissionPage', undefined, '{"kind":"camera"}'),
    new SettingsIndexEntry($r('app.string.perm_mic_label'), 'permissionPage', undefined, '{"kind":"mic"}'),
    new SettingsIndexEntry($r('app.string.orig_q5'), 'permissionPage', undefined, '{"kind":"redirect"}'),
    new SettingsIndexEntry($r('app.string.orig_a1f'), 'permissionPage', undefined, '{"kind":"vibrate"}'),
    new SettingsIndexEntry($r('app.string.orig_r4'), 'permissionPage', undefined, '{"kind":"backreload"}')
  ]
}

// 字体（fontSettings 页，SiteSubPages.ets FontSizePage）
function fontEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.orig_jr'), 'fontSettings'),
    new SettingsIndexEntry($r('app.string.orig_bc'), 'fontSettings')
  ]
}

// 权限子页（permissionPage，SiteSubPages.ets PermissionPage，文案硬编码）
function permissionEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry('剪贴板', 'permissionPage', undefined, '{"kind":"clipboard"}'),
    new SettingsIndexEntry('打开应用', 'permissionPage', undefined, '{"kind":"openapp"}'),
    new SettingsIndexEntry('位置信息', 'permissionPage', undefined, '{"kind":"geo"}'),
    new SettingsIndexEntry('摄像头', 'permissionPage', undefined, '{"kind":"camera"}'),
    new SettingsIndexEntry('麦克风', 'permissionPage', undefined, '{"kind":"mic"}'),
    new SettingsIndexEntry('页面重定向', 'permissionPage', undefined, '{"kind":"redirect"}'),
    new SettingsIndexEntry('返回不重载', 'permissionPage', undefined, '{"kind":"backreload"}'),
    new SettingsIndexEntry('振动', 'permissionPage', undefined, '{"kind":"vibrate"}'),
    new SettingsIndexEntry($r('app.string.orig_bc'), 'permissionPage')
  ]
}

// Cookies 子页（cookiesSetting 页，文案硬编码）
function cookiesEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry('Cookies', 'cookiesSetting'),
    new SettingsIndexEntry('拦截第三方 Cookies', 'cookiesSetting')
  ]
}

// 弹窗子页（popupSetting 页）
function popupEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.orig_qw'), 'popupSetting')
  ]
}

// 广告拦截例外（adBlockException 页）
function adBlockExceptionEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry($r('app.string.ad_block'), 'adBlockException'),
    new SettingsIndexEntry($r('app.string.orig_bc'), 'adBlockException')
  ]
}

// 关于（SettingsAboutPage，文案硬编码）
function aboutEntries(): SettingsIndexEntry[] {
  return [
    new SettingsIndexEntry('检查更新', 'settingsAbout'),
    new SettingsIndexEntry('QQ 群组', 'settingsAbout'),
    new SettingsIndexEntry('通过邮件联系我', 'settingsAbout'),
    new SettingsIndexEntry('隐私政策', 'settingsAbout'),
    new SettingsIndexEntry('开源许可协议', 'licensePage'),
    new SettingsIndexEntry('备案号', 'settingsAbout')
  ]
}

// 全量索引：按页面分组静态构建（文案随系统语言，通过资源引用运行时解析）
export function buildSettingsIndex(): SettingsIndexEntry[] {
  const all: SettingsIndexEntry[] = []
  const groups: SettingsIndexEntry[][] = [
    rootEntries(), generalEntries(), customEntries(), privacyEntries(), advancedEntries(),
    scriptEntries(), proxyEntries(), experimentalEntries(), searchEntries(), toolbarEntries(),
    adBlockEntries(), gestureEntries(), nightEntries(), readerEntries(), aiEntries(),
    siteEntries(), fontEntries(), permissionEntries(), cookiesEntries(), popupEntries(),
    adBlockExceptionEntries(), aboutEntries()
  ]
  for (let i = 0; i < groups.length; i++) {
    for (let j = 0; j < groups[i].length; j++) {
      all.push(groups[i][j])
    }
  }
  return all
}

// ResourceStr → 当前语言文案
function resolveText(context: Context, text: ResourceStr): string {
  if (typeof text === 'string') {
    return text
  }
  return context.resourceManager.getStringSync(text as Resource)
}

// 设置内搜索：大小写不敏感的包含匹配（label 与 desc 均参与）
export function searchSettingsEntries(context: Context, keyword: string): SettingsIndexEntry[] {
  const query = keyword.trim().toLowerCase()
  if (query === '') {
    return []
  }
  const results: SettingsIndexEntry[] = []
  const all = buildSettingsIndex()
  for (let i = 0; i < all.length; i++) {
    const entry = all[i]
    const label = resolveText(context, entry.label).toLowerCase()
    if (label.includes(query)) {
      results.push(entry)
      continue
    }
    if (entry.desc !== undefined) {
      const desc = resolveText(context, entry.desc).toLowerCase()
      if (desc.includes(query)) {
        results.push(entry)
      }
    }
  }
  return results
}
