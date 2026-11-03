import { fileIo } from '@kit.CoreFileKit'
import { connection } from '@kit.NetworkKit'

interface ParsedProxyTarget {
  host: string
  port: number
}

// 原版 s8/c.java：代理配置模型
// 配置文件 files/proxy/config.txt，行格式 key=value：
// enabled=1|0 / proxyUrl=<url> / reverseBypassRules=1|0 / bypassRule=<rule>（可多行，去重）
export class ProxyConfig {
  enabled: boolean = false
  reverseBypassRules: boolean = false
  proxyUrl: string = ''
  bypassRules: Set<string> = new Set<string>()
  private cachedSignature: string = ''
  private readonly configPath: string

  constructor(configPath: string) {
    this.configPath = configPath
  }

  // 原版 c.e()：proxyUrl 非空判定
  hasProxyUrl(): boolean {
    return this.proxyUrl !== ''
  }

  // 原版 c.a()：空规则不加入
  addRule(rule: string): void {
    if (rule === '') {
      return
    }
    this.bypassRules.add(rule)
  }

  // 原版 c.k()
  removeRule(rule: string): void {
    this.bypassRules.delete(rule)
  }

  // 原版 h5.p3：规则排序后逐行显示
  sortedRules(): string[] {
    const rules: string[] = []
    this.bypassRules.forEach((rule: string) => {
      rules.push(rule)
    })
    return rules.sort()
  }

  private signature(): string {
    return `${this.enabled}|${this.reverseBypassRules}|${this.proxyUrl}|${this.sortedRules().join('\n')}`
  }

  // 原版 c.g()：配置与缓存哈希不一致（有变化）
  isChanged(): boolean {
    return this.cachedSignature !== this.signature()
  }

  // 原版 c.i()：逐行读取 config.txt
  load(): void {
    if (this.configPath === '') {
      return
    }
    let content = ''
    try {
      if (!fileIo.accessSync(this.configPath)) {
        this.cachedSignature = this.signature()
        return
      }
      content = fileIo.readTextSync(this.configPath)
    } catch (error) {
      this.cachedSignature = this.signature()
      return
    }
    const lines = content.split('\n')
    for (let i = 0; i < lines.length; i++) {
      const line = lines[i].trim()
      if (line === '') {
        continue
      }
      // 原版 c.j()：按第一个 = 拆 key/value
      const eq = line.indexOf('=')
      const key = eq < 0 ? line : line.substring(0, eq)
      const value = eq < 0 ? '' : line.substring(eq + 1)
      if (key === 'enabled') {
        this.enabled = value === '1'
      } else if (key === 'proxyUrl') {
        this.proxyUrl = value
      } else if (key === 'reverseBypassRules') {
        this.reverseBypassRules = value === '1'
      } else if (key === 'bypassRule') {
        this.addRule(value)
      }
    }
    this.cachedSignature = this.signature()
  }

  // 原版 c.b()：哈希未变化不写盘
  save(): void {
    if (this.configPath === '') {
      return
    }
    const current = this.signature()
    if (this.cachedSignature === current) {
      return
    }
    const dir = this.configPath.substring(0, this.configPath.lastIndexOf('/'))
    try {
      fileIo.accessSync(dir)
    } catch (error) {
      try {
        fileIo.mkdirSync(dir)
      } catch (innerError) {
        return
      }
    }
    const lines: string[] = []
    lines.push(`enabled=${this.enabled ? '1' : '0'}`)
    if (this.proxyUrl !== '') {
      lines.push(`proxyUrl=${this.proxyUrl}`)
    }
    lines.push(`reverseBypassRules=${this.reverseBypassRules ? '1' : '0'}`)
    const rules = this.sortedRules()
    for (let i = 0; i < rules.length; i++) {
      lines.push(`bypassRule=${rules[i]}`)
    }
    try {
      const file = fileIo.openSync(this.configPath,
        fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.TRUNC | fileIo.OpenMode.CREATE)
      fileIo.writeSync(file.fd, `${lines.join('\n')}\n`)
      fileIo.closeSync(file)
      this.cachedSignature = current
    } catch (error) {
    }
  }

  // 鸿蒙 connection.HttpProxy 仅接受 host/port（HTTP 代理），原版 proxyUrl 为
  // URL 形式（如 socks://127.0.0.1:1080），此处解析拆分 host/port 传参
  static parseProxyTarget(url: string): ParsedProxyTarget | null {
    let rest = url
    let scheme = ''
    const schemeIndex = rest.indexOf('://')
    if (schemeIndex >= 0) {
      scheme = rest.substring(0, schemeIndex).toLowerCase()
      rest = rest.substring(schemeIndex + 3)
    }
    const slash = rest.indexOf('/')
    if (slash >= 0) {
      rest = rest.substring(0, slash)
    }
    const atSign = rest.lastIndexOf('@')
    if (atSign >= 0) {
      rest = rest.substring(atSign + 1)
    }
    const colon = rest.lastIndexOf(':')
    if (colon > 0) {
      const host = rest.substring(0, colon)
      const port = parseInt(rest.substring(colon + 1))
      if (host !== '' && !isNaN(port) && port > 0 && port <= 65535) {
        return { host: host, port: port }
      }
      return null
    }
    if (rest === '') {
      return null
    }
    if (scheme === 'http') {
      return { host: rest, port: 80 }
    }
    if (scheme === 'https') {
      return { host: rest, port: 443 }
    }
    if (scheme === 'socks' || scheme === 'socks5') {
      return { host: rest, port: 1080 }
    }
    return null
  }
}

// 原版 s8/b.java：代理启停管理
export class ProxyManager {
  private static instance: ProxyManager | null = null
  private config: ProxyConfig | null = null
  private running: boolean = false

  static getInstance(): ProxyManager {
    if (ProxyManager.instance === null) {
      ProxyManager.instance = new ProxyManager()
    }
    return ProxyManager.instance
  }

  // 原版 s8/b.c()：PROXY_OVERRIDE 特性判定；
  // 鸿蒙 connection.setAppHttpProxy 可用（作用于 Web 组件请求）→ 恒 true
  isSupported(): boolean {
    return true
  }

  // 原版 s8/b.d()：PROXY_OVERRIDE_REVERSE_BYPASS 特性判定；
  // 鸿蒙 HttpProxy 仅有 exclusionList（排除不走代理列表），无法表达
  // reverse 模式（仅指定域走代理）→ 恒 false
  isReverseBypassSupported(): boolean {
    return false
  }

  getConfig(context: Context): ProxyConfig {
    if (this.config === null) {
      this.config = new ProxyConfig(`${context.filesDir}/proxy/config.txt`)
      this.config.load()
    }
    return this.config
  }

  // 原版 s8/b.e()：enabled 且 proxyUrl 非空则设置应用级 HTTP 代理
  start(context: Context): boolean {
    if (this.running || !this.isSupported()) {
      return false
    }
    const config = this.getConfig(context)
    if (!config.hasProxyUrl()) {
      return false
    }
    const target = ProxyConfig.parseProxyTarget(config.proxyUrl)
    if (target === null) {
      return false
    }
    const exclusionList = config.sortedRules()
    try {
      connection.setAppHttpProxy({
        host: target.host,
        port: target.port,
        exclusionList: exclusionList
      } as connection.HttpProxy)
    } catch (error) {
      return false
    }
    this.running = true
    return true
  }

  // 原版 s8/b.f()：清除代理（host 置空、port 置 0、排除列表置空）
  stop(context: Context): boolean {
    if (!this.running || !this.isSupported()) {
      return false
    }
    try {
      connection.setAppHttpProxy({
        host: '',
        port: 0,
        exclusionList: []
      } as connection.HttpProxy)
    } catch (error) {
      return false
    }
    this.running = false
    return true
  }

  // 原版 mark/via/Shell 启动时机：应用启动读 config → enabled 则启动代理
  applyOnStartup(context: Context): void {
    const config = this.getConfig(context)
    if (config.enabled) {
      this.start(context)
    }
  }
}
