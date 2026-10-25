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

export const UA_TABLE: UaDef[] = [
  new UaDef('default', '默认',
    'Mozilla/5.0 (Linux; Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.91 Mobile Safari/537.36 Via/7.4.0.beta'),
  new UaDef('android_phone', '安卓手机',
    'Mozilla/5.0 (Linux; Android 10; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36'),
  new UaDef('android_tablet', '安卓平板',
    'Mozilla/5.0 (Linux; Android 8.1.0; SM-T837A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36'),
  new UaDef('win_chrome', 'Windows Chrome',
    'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36'),
  new UaDef('win_ie11', 'Windows IE11',
    'Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko'),
  new UaDef('mac', 'MAC OS',
    'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.5 Safari/605.1.15'),
  new UaDef('iphone', 'iPhone',
    'Mozilla/5.0 (iPhone; CPU iPhone OS 18_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.5 Mobile/15E148 Safari/604.1'),
  new UaDef('ipad', 'iPad',
    'Mozilla/5.0 (iPad; CPU iPadOS 18_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.5 Mobile/15E148 Safari/604.1'),
  new UaDef('symbian', '塞班',
    'Mozilla/5.0 (Symbian/3; Series60/5.2 NokiaN8-00/012.002; Profile/MIDP-2.1 Configuration/CLDC-1.1 ) AppleWebKit/533.4 (KHTML, like Gecko) NokiaBrowser/7.3.0 Mobile Safari/533.4 3gpp-gba'),
  new UaDef('spider', '蜘蛛',
    'Mozilla/5.0 AppleWebKit/537.36 (KHTML, like Gecko; compatible; Googlebot/2.1; +http://www.google.com/bot.html) Chrome/120.0.0.0 Safari/537.36'),
  new UaDef('edge', 'Edge',
    'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36 Edg/120.0.0.0')
]

export function uaByKey(key: string): UaDef | null {
  for (let i = 0; i < UA_TABLE.length; i++) {
    if (UA_TABLE[i].key === key) {
      return UA_TABLE[i]
    }
  }
  return null
}

export function simplifyUaString(ua: string): string {
  let result = ua
  const parenStart = result.indexOf('(')
  if (parenStart >= 0) {
    const parenEnd = result.indexOf(')', parenStart)
    if (parenEnd > parenStart) {
      result = result.substring(0, parenStart) + result.substring(parenEnd + 1)
    }
  }
  const buildIdx = result.indexOf('Build/')
  if (buildIdx >= 0) {
    const semiIdx = result.indexOf(';', buildIdx)
    if (semiIdx >= 0) {
      result = result.substring(0, buildIdx) + result.substring(semiIdx + 1)
    } else {
      result = result.substring(0, buildIdx)
    }
  }
  result = result.replace(/Chrome\/(\d+)(\.\d+)+/g, 'Chrome/$1')
  result = result.replace(/Safari\/(\d+)(\.\d+)+/g, 'Safari/$1')
  result = result.replace(/Edg\/(\d+)(\.\d+)+/g, 'Edg/$1')
  result = result.replace(/Version\/(\d+)(\.\d+)+/g, 'Version/$1')
  return result.replace(/\s+/g, ' ').trim()
}
