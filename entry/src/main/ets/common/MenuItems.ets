// 菜单条目共享定义：定制菜单编辑页与播放端 MenuSheet 两侧共用同一套 id/图标/文案。
// 默认顺序按原版 Via 7.4.0 录屏「定制菜单」页逐项对齐：
// 前 27 个为当前菜单（第一页 10 个：夜间模式/书签/历史/下载/隐身 + 分享/添加书签/电脑模式/工具箱/设置），
// 后 12 个为「可添加条目」池（朗读网页/字体大小/举报网站/全屏/有图模式/网站设定/脚本/打印PDF/阅读模式/其它应用打开/游戏模式/添加主页收藏）。
export const MENU_DEFAULT_ORDER: string[] = [
  'night_mode', 'bookmarks', 'history', 'downloads', 'incognito',
  'share', 'add_bookmark', 'pc_mode', 'toolbox', 'settings',
  'find', 'save', 'offline', 'translate', 'view_source',
  'res_sniffer', 'ua', 'netlog', 'add_to_desktop', 'ai',
  'screen_orientation', 'adblock', 'clear_data', 'mark_ad', 'scan_qr',
  'customize_menu', 'refresh_page',
  'read_aloud', 'font_size', 'report_site', 'fullscreen', 'image_mode',
  'site_settings', 'script', 'print', 'reading_mode', 'open_with',
  'game_mode', 'add_home_fav'
]

export function isMenuId(id: string): boolean {
  return MENU_DEFAULT_ORDER.indexOf(id) >= 0
}

export function menuIcon(id: string): Resource {
  switch (id) {
    case 'night_mode':
      return $r('app.media.via_ic_c_opacity')
    case 'bookmarks':
      return $r('app.media.via_ic_bookmark')
    case 'history':
      return $r('app.media.via_ic_history')
    case 'downloads':
      return $r('app.media.via_ic_download')
    case 'incognito':
      return $r('app.media.via_ic_incognito')
    case 'share':
      return $r('app.media.via_ic_share')
    case 'add_bookmark':
      return $r('app.media.via_ic_add_bookmark')
    case 'pc_mode':
      return $r('app.media.via_ic_pc_mode')
    case 'save':
      return $r('app.media.via_ic_save')
    case 'toolbox':
      return $r('app.media.via_ic_toolbox')
    case 'settings':
      return $r('app.media.via_ic_settings')
    case 'find':
      return $r('app.media.via_ic_find')
    case 'offline':
      return $r('app.media.via_ic_offline')
    case 'translate':
      return $r('app.media.via_ic_translate')
    case 'view_source':
      return $r('app.media.via_ic_script')
    case 'res_sniffer':
      return $r('app.media.via_ic_netlog')
    case 'add_to_desktop':
      return $r('app.media.via_ic_add_to_desktop')
    case 'script':
      return $r('app.media.via_ic_script')
    case 'adblock':
      return $r('app.media.via_ic_adblock')
    case 'ai':
      return $r('app.media.via_ic_ai')
    case 'print':
      return $r('app.media.via_ic_print')
    case 'ua':
      return $r('app.media.via_ic_ua')
    case 'netlog':
      return $r('app.media.via_ic_netlog')
    case 'screen_orientation':
      return $r('app.media.via_ic_pc_mode')
    case 'clear_data':
      return $r('app.media.via_ic_cancel')
    case 'mark_ad':
      return $r('app.media.via_ic_adblock')
    case 'scan_qr':
      return $r('app.media.via_ic_scan')
    case 'customize_menu':
      return $r('app.media.via_ic_menu')
    case 'refresh_page':
      return $r('app.media.via_ic_forward')
    case 'read_aloud':
      return $r('app.media.via_ic_translate')
    case 'font_size':
      return $r('app.media.via_ic_c_font_size')
    case 'report_site':
      return $r('app.media.via_ic_incognito')
    case 'fullscreen':
      return $r('app.media.via_ic_c_adv_area')
    case 'image_mode':
      return $r('app.media.via_ic_c_fav_icon_color')
    case 'site_settings':
      return $r('app.media.via_ic_settings')
    case 'reading_mode':
      return $r('app.media.via_ic_save')
    case 'open_with':
      return $r('app.media.via_ic_share')
    case 'game_mode':
      return $r('app.media.via_ic_ai')
    case 'add_home_fav':
      return $r('app.media.via_ic_add_bookmark')
    default:
      return $r('app.media.via_ic_settings')
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
