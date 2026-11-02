export class UaDef {
  readonly key: string
  readonly label: string
  readonly ua: string

  constructor(key: string, label: string, ua: string) {
    this.key = key
    this.label = label
    this.ua = ua
  }
}

export class CustomUaEntry {
  title: string
  ua: string

  constructor(title: string, ua: string) {
    this.title = title
    this.ua = ua
  }

  static fromJson(obj: Record<string, Object>): CustomUaEntry | null {
    const title = obj['title']
    const ua = obj['ua']
    if (typeof title === 'string' && typeof ua === 'string' && title !== '' && ua !== '') {
      return new CustomUaEntry(title, ua)
    }
    return null
  }
}

// 原版内置 UA 清单（z8/b4.java:28-35，1:1）；'default' 为空 UA = 系统 WebView 默认
export const UA_TABLE: UaDef[] = [
  new UaDef('default', '默认', ''),
  new UaDef('android_phone', 'Android (手机)',
    'Mozilla/5.0 (Linux; Android 13; Pixel 7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Mobile Safari/537.36'),
  new UaDef('android_tablet', 'Android (平板)',
    'Mozilla/5.0 (Linux; Android 8.1.0; SM-T837A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36'),
  new UaDef('win_chrome', 'Chrome (PC)',
    'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36'),
  new UaDef('win_ie11', 'IE11 (PC)',
    'Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko'),
  new UaDef('mac', 'macOS',
    'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36'),
  new UaDef('iphone', 'iPhone',
    'Mozilla/5.0 (iPhone; CPU iPhone OS 18_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.5 Mobile/15E148 Safari/604.1'),
  new UaDef('ipad', 'iPad',
    'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.5 Safari/605.1.15'),
  new UaDef('symbian', '塞班 (Symbian)',
    'Mozilla/5.0 (Symbian/3; Series60/5.2 NokiaN8-00/012.002; Profile/MIDP-2.1 Configuration/CLDC-1.1 ) AppleWebKit/533.4 (KHTML, like Gecko) NokiaBrowser/7.3.0 Mobile Safari/533.4 3gpp-gba')
]

export function uaByKey(key: string): UaDef | null {
  for (let i = 0; i < UA_TABLE.length; i++) {
    if (UA_TABLE[i].key === key) {
      return UA_TABLE[i]
    }
  }
  return null
}

// z8/b4.h()：1:1 移植——"Android" 后接 ") AppleWebKit" 时替换为 " 10; K"，
// Chrome 版本号截断到首点后补 ".0.0"
export function simplifyUaString(ua: string): string {
  if (ua === null || ua.length < 8) {
    return ua
  }
  const androidIdx = ua.indexOf('Android')
  if (androidIdx < 0) {
    return ua
  }
  const webkitIdx = ua.indexOf(') AppleWebKit', androidIdx)
  if (webkitIdx < 0) {
    return ua
  }
  let result = ua.substring(0, androidIdx + 7) + ' 10; K'
  const chromeIdx = ua.indexOf('Chrome/', webkitIdx)
  if (chromeIdx < 0) {
    result += ua.substring(webkitIdx)
  } else {
    const dotIdx = ua.indexOf('.', chromeIdx + 7)
    result += ua.substring(webkitIdx, dotIdx + 1) + '0.0.0'
    const spaceIdx = ua.indexOf(' ', dotIdx)
    if (spaceIdx > 0) {
      result += ua.substring(spaceIdx)
    }
  }
  return result
}

// z8/b4.g()：[\t\n\r]+ → 空格 + trim
export function cleanUaInput(ua: string): string {
  return ua.replace(/[\t\n\r]+/g, ' ').trim()
}

// z8/b4.i()：去 "; wv" 与 " Version/x.y"
export function uaCleanWv(ua: string): string {
  if (ua === null || ua === '') {
    return ua
  }
  const wvIdx = ua.indexOf('; wv')
  if (wvIdx < 0) {
    return ua
  }
  let result = ua.substring(0, wvIdx) + ua.substring(wvIdx + 4)
  const versionIdx = result.indexOf(' Version/')
  if (versionIdx >= 0) {
    let endIdx = result.indexOf(' ', versionIdx + 1)
    if (endIdx < 0) {
      endIdx = result.length
    }
    if (endIdx > versionIdx) {
      result = result.substring(0, versionIdx) + result.substring(endIdx)
    }
  }
  return result
}
