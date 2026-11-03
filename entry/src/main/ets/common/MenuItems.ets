// 菜单条目共享定义：定制菜单编辑页与播放端 MenuSheet 两侧共用同一套 id/图标/文案。
// 默认顺序按原版 Via 7.4.0 反编译结果对齐（w9/k.java t0() 默认数组，z8.c0.f() 在本包恒为 true）：
// 默认 30 项（1..20 + 25,34,33,39,30,28,23,29,41,35，其中下标 28 由 31→41 替换）=
// 夜间模式/书签/历史/下载/隐身 + 分享/添加书签/电脑模式/工具箱/设置 +
// 页内查找/保存/离线网页/翻译/源码 + 全屏/有图模式/资源嗅探/浏览器标识/网络日志 +
// 扫描二维码/添加到桌面/朗读网页/AI/屏幕方向 + 广告拦截/标记广告/字体大小/举报网站/定制菜单，
// 其余为默认不在菜单、仅可在定制菜单添加的条目（清除数据/刷新网页/网站设定/脚本/打印PDF/
// 阅读模式/其它应用打开/游戏模式/添加主页收藏）。
export const MENU_DEFAULT_ORDER: string[] = [
  'night_mode', 'bookmarks', 'history', 'downloads', 'incognito',
  'share', 'add_bookmark', 'pc_mode', 'toolbox', 'settings',
  'find', 'save', 'offline', 'translate', 'view_source',
  'fullscreen', 'image_mode', 'res_sniffer', 'ua', 'netlog',
  'scan_qr', 'add_to_desktop', 'read_aloud', 'ai', 'screen_orientation',
  'adblock', 'mark_ad', 'font_size', 'report_site', 'customize_menu',
  'clear_data', 'refresh_page', 'site_settings', 'script', 'print',
  'reading_mode', 'open_with', 'game_mode', 'add_home_fav'
]

export function isMenuId(id: string): boolean {
  return MENU_DEFAULT_ORDER.indexOf(id) >= 0
}

// 原版 i8/l.a：菜单条目皮肤图标名（lb.b.a 第二参字符串值，皮肤目录下 <name>.png 覆盖）
// 菜单数字 id → 皮肤名（i8/l.java case 表，已逐项按字符串资源值核对）
export function menuSkinIconName(id: string): string {
  switch (id) {
    case 'night_mode':
      return 'ic_menu_night'
    case 'bookmarks':
      return 'ic_menu_bookmark'
    case 'history':
      return 'ic_menu_history'
    case 'downloads':
      return 'ic_menu_downloads'
    case 'incognito':
      return 'ic_menu_incognito_mode'
    case 'share':
      return 'ic_menu_share'
    case 'add_bookmark':
      return 'ic_menu_add_bookmark'
    case 'pc_mode':
      return 'ic_menu_desktop_mode'
    case 'toolbox':
      return 'ic_menu_tools'
    case 'settings':
      return 'ic_menu_settings'
    case 'find':
      return 'ic_menu_find'
    case 'save':
      return 'ic_menu_save'
    case 'offline':
      return 'ic_menu_offline'
    case 'translate':
      return 'ic_menu_translate'
    case 'view_source':
      return 'ic_menu_view_source'
    case 'fullscreen':
      return 'ic_menu_fullscreen'
    case 'image_mode':
      return 'ic_menu_image_mode'
    case 'res_sniffer':
      return 'ic_menu_resource'
    case 'ua':
      return 'ic_menu_useragent'
    case 'netlog':
      return 'ic_menu_network_log'
    case 'scan_qr':
      return 'ic_menu_scan'
    case 'add_to_desktop':
      return 'ic_menu_add_to_home_screen'
    case 'read_aloud':
      return 'ic_menu_read_aloud'
    case 'ai':
      return 'ic_menu_ai'
    case 'screen_orientation':
      return 'ic_menu_rotation'
    case 'adblock':
      return 'ic_menu_adblock'
    case 'mark_ad':
      return 'ic_menu_mark'
    case 'font_size':
      return 'ic_menu_font_size'
    case 'report_site':
      return 'ic_menu_report_abuse'
    case 'customize_menu':
      return 'ic_menu_customize_menu'
    case 'clear_data':
      return 'ic_menu_delete'
    case 'refresh_page':
      return 'ic_menu_reload'
    case 'site_settings':
      return 'ic_menu_site_conf'
    case 'script':
      return 'ic_menu_scripts'
    case 'print':
      return 'ic_menu_print'
    case 'reading_mode':
      return 'ic_menu_reader'
    case 'open_with':
      return 'ic_menu_open_with'
    case 'game_mode':
      return 'ic_menu_game_mode'
    case 'add_home_fav':
      return 'ic_menu_add_favorite'
    default:
      return ''
  }
}

// 图标为原版 Via 7.4.0 APK 反解资源（resources.arsc drawable → r/j/<name>.png，
// 原样拷贝至 media/via_menu_<id>.png，未做任何压缩/裁剪/转码）
export function menuIcon(id: string): Resource {
  switch (id) {
    case 'night_mode':
      return $r('app.media.via_menu_night_mode')
    case 'bookmarks':
      return $r('app.media.via_menu_bookmarks')
    case 'history':
      return $r('app.media.via_menu_history')
    case 'downloads':
      return $r('app.media.via_menu_downloads')
    case 'incognito':
      return $r('app.media.via_menu_incognito')
    case 'share':
      return $r('app.media.via_menu_share')
    case 'add_bookmark':
      return $r('app.media.via_menu_add_bookmark')
    case 'pc_mode':
      return $r('app.media.via_menu_pc_mode')
    case 'save':
      return $r('app.media.via_menu_save')
    case 'toolbox':
      return $r('app.media.via_menu_toolbox')
    case 'settings':
      return $r('app.media.via_menu_settings')
    case 'find':
      return $r('app.media.via_menu_find')
    case 'offline':
      return $r('app.media.via_menu_offline')
    case 'translate':
      return $r('app.media.via_menu_translate')
    case 'view_source':
      return $r('app.media.via_menu_view_source')
    case 'fullscreen':
      return $r('app.media.via_menu_fullscreen')
    case 'image_mode':
      return $r('app.media.via_menu_image_mode')
    case 'res_sniffer':
      return $r('app.media.via_menu_res_sniffer')
    case 'ua':
      return $r('app.media.via_menu_ua')
    case 'netlog':
      return $r('app.media.via_menu_netlog')
    case 'scan_qr':
      return $r('app.media.via_menu_scan_qr')
    case 'add_to_desktop':
      return $r('app.media.via_menu_add_to_desktop')
    case 'read_aloud':
      return $r('app.media.via_menu_read_aloud')
    case 'ai':
      return $r('app.media.via_menu_ai')
    case 'screen_orientation':
      return $r('app.media.via_menu_screen_orientation')
    case 'adblock':
      return $r('app.media.via_menu_adblock')
    case 'mark_ad':
      return $r('app.media.via_menu_mark_ad')
    case 'font_size':
      return $r('app.media.via_menu_font_size')
    case 'report_site':
      return $r('app.media.via_menu_report_site')
    case 'customize_menu':
      return $r('app.media.via_menu_customize_menu')
    case 'refresh_page':
      return $r('app.media.via_menu_refresh_page')
    case 'site_settings':
      return $r('app.media.via_menu_site_settings')
    case 'script':
      return $r('app.media.via_menu_script')
    case 'clear_data':
      return $r('app.media.via_menu_clear_data')
    case 'print':
      return $r('app.media.via_menu_print')
    case 'reading_mode':
      return $r('app.media.via_menu_reading_mode')
    case 'open_with':
      return $r('app.media.via_menu_open_with')
    case 'game_mode':
      return $r('app.media.via_menu_game_mode')
    case 'add_home_fav':
      return $r('app.media.via_menu_add_home_fav')
    default:
      return $r('app.media.via_menu_settings')
  }
}

export function menuLabel(id: string): Resource {
  switch (id) {
    case 'night_mode':
      return $r('app.string.night_mode')
    case 'bookmarks':
      return $r('app.string.bookmarks')
    case 'history':
      return $r('app.string.history')
    case 'downloads':
      return $r('app.string.downloads')
    case 'incognito':
      return $r('app.string.incognito')
    case 'share':
      return $r('app.string.share')
    case 'add_bookmark':
      return $r('app.string.add_bookmark')
    case 'pc_mode':
      return $r('app.string.pc_mode')
    case 'save':
      return $r('app.string.save')
    case 'toolbox':
      return $r('app.string.toolbox')
    case 'settings':
      return $r('app.string.settings')
    case 'find':
      return $r('app.string.find_in_page')
    case 'offline':
      return $r('app.string.offline_page')
    case 'translate':
      return $r('app.string.translate')
    case 'view_source':
      return $r('app.string.view_source')
    case 'res_sniffer':
      return $r('app.string.res_sniffer')
    case 'add_to_desktop':
      return $r('app.string.add_to_desktop')
    case 'script':
      return $r('app.string.scripts')
    case 'adblock':
      return $r('app.string.ad_block')
    case 'ai':
      return $r('app.string.ai')
    case 'print':
      return $r('app.string.print_pdf')
    case 'ua':
      return $r('app.string.browser_ua')
    case 'netlog':
      return $r('app.string.net_log')
    case 'screen_orientation':
      return $r('app.string.screen_orientation')
    case 'clear_data':
      return $r('app.string.clear_data')
    case 'mark_ad':
      return $r('app.string.mark_ad')
    case 'scan_qr':
      return $r('app.string.scan_qr')
    case 'customize_menu':
      return $r('app.string.customize_menu')
    case 'refresh_page':
      return $r('app.string.refresh_page')
    case 'read_aloud':
      return $r('app.string.read_aloud_menu')
    case 'font_size':
      return $r('app.string.font_size')
    case 'report_site':
      return $r('app.string.report_site')
    case 'fullscreen':
      return $r('app.string.fullscreen')
    case 'image_mode':
      return $r('app.string.image_mode')
    case 'site_settings':
      return $r('app.string.site_settings')
    case 'reading_mode':
      return $r('app.string.reader_mode')
    case 'open_with':
      return $r('app.string.open_with')
    case 'game_mode':
      return $r('app.string.game_mode')
    case 'add_home_fav':
      return $r('app.string.add_home_fav')
    default:
      return $r('app.string.settings')
  }
}
