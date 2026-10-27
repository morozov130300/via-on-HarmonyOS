// 菜单条目共享定义：定制菜单编辑页与播放端 MenuSheet 两侧共用同一套 id/图标/文案，
// 默认顺序与 MenuSheet 原硬编码顺序保持一致（前10为主菜单，后10为工具箱页）。
export const MENU_DEFAULT_ORDER: string[] = [
  'share', 'add_bookmark', 'pc_mode', 'toolbox', 'settings',
  'bookmarks', 'history', 'downloads', 'incognito', 'save',
  'find', 'offline', 'translate', 'add_to_desktop', 'script',
  'adblock', 'ai', 'print', 'ua', 'netlog'
]

export function isMenuId(id: string): boolean {
  return MENU_DEFAULT_ORDER.indexOf(id) >= 0
}

export function menuIcon(id: string): Resource {
  switch (id) {
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
    default:
      return $r('app.media.via_ic_settings')
  }
}

export function menuLabel(id: string): Resource {
  switch (id) {
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
    default:
      return $r('app.string.settings')
  }
}
