// 原版 d8/g.java 1:1：网页工具栏配色缓存（key = URL host 段，value = #RRGGBB）。
// 写入：页面加载完成探得 theme-color（e8/k0.G → f()）；阅读模式进入（k6.T7 → f()）。
// 读取：页面开始时命中即上屏（k0.D/n → d()），重访页面配色秒变、不等加载完成。
// 清除：阅读模式退出（k6.c3 → e()）。
export class ThemeColorCache {
  private static instance: ThemeColorCache | null = null
  private cache: Map<string, string> = new Map()

  static getInstance(): ThemeColorCache {
    if (ThemeColorCache.instance === null) {
      ThemeColorCache.instance = new ThemeColorCache()
    }
    return ThemeColorCache.instance
  }

  // 原版 d8.g.b()：提取缓存 key——view-source: 前缀固定 "S"；file:// 取路径段
  //（到最后一个 ?）；其余取 :// 后到首个 / 或 ? 的 host 段（上限 128 字符）
  static keyOf(url: string): string {
    if (url === '' || url.length < 3) {
      return ''
    }
    const schemeEnd = url.indexOf('://')
    if (schemeEnd <= 0) {
      return ''
    }
    if (schemeEnd > 12 && url.substring(0, 12).toLowerCase() === 'view-source:') {
      return 'S'
    }
    if (schemeEnd === 4 && url.substring(0, 4).toLowerCase() === 'file') {
      const query = url.lastIndexOf('?')
      const end = query < 0 ? url.length : query
      return url.substring(schemeEnd + 3, end)
    }
    let pathStart = url.indexOf('/', schemeEnd + 3)
    if (pathStart < 0) {
      pathStart = url.indexOf('?', schemeEnd + 3)
    }
    if (pathStart < 0) {
      pathStart = url.length
    }
    const end = Math.min(pathStart, schemeEnd + 3 + 128)
    return url.substring(schemeEnd + 3, end)
  }

  has(url: string): boolean {
    const key = ThemeColorCache.keyOf(url)
    return key !== '' && this.cache.has(key)
  }

  get(url: string): string {
    const key = ThemeColorCache.keyOf(url)
    if (key === '') {
      return ''
    }
    const value = this.cache.get(key)
    return value === undefined ? '' : value
  }

  put(url: string, colorHex: string): void {
    const key = ThemeColorCache.keyOf(url)
    if (key === '' || colorHex === '') {
      return
    }
    this.cache.set(key, colorHex)
  }

  remove(url: string): void {
    const key = ThemeColorCache.keyOf(url)
    if (key === '') {
      return
    }
    this.cache.delete(key)
  }
}
