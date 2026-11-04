import { fileIo } from '@kit.CoreFileKit'
import { webview } from '@kit.ArkWeb'

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

}

// 原版 s8/b.java：代理启停管理（原版 q0/c → AndroidX WebView ProxyController，
// 鸿蒙对应 webview.ProxyController，对应用内所有 Web 组件生效）
export class ProxyManager {
  private static instance: ProxyManager | null = null
  private config: ProxyConfig | null = null
  private running: boolean = false
  // initializeWebEngine 全生命周期一次（docs：不需重复调用）
  private enginePrepared: boolean = false

  static getInstance(): ProxyManager {
    if (ProxyManager.instance === null) {
      ProxyManager.instance = new ProxyManager()
    }
    return ProxyManager.instance
  }

  // 原版 s8/b.c()：PROXY_OVERRIDE 特性判定；
  // webview.ProxyController API 15+（工程 API 26）→ 恒 true
  isSupported(): boolean {
    return true
  }

  // 原版 s8/b.d()：PROXY_OVERRIDE_REVERSE_BYPASS 特性判定；
  // webview.ProxyConfig.enableReverseBypass API 15+ 原生支持 → 恒 true
  isReverseBypassSupported(): boolean {
    return true
  }

  getConfig(context: Context): ProxyConfig {
    if (this.config === null) {
      this.config = new ProxyConfig(`${context.filesDir}/proxy/config.txt`)
      this.config.load()
    }
    return this.config
  }

  // applyProxyOverride 要求 Web 内核就绪：apply 前先 initializeWebEngine 预加载动态库
  //（docs：主线程调用、全局一次；本方法两条调用路径——启动 onCreate 与设置页——均在主线程）
  private prepareWebEngine(): void {
    if (this.enginePrepared) {
      return
    }
    try {
      webview.WebviewController.initializeWebEngine()
    } catch (error) {
    }
    this.enginePrepared = true
  }

  // 原版 s8/b.e()：enabled 且 proxyUrl 非空则对应用内所有 Web 组件应用代理。
  // 构建顺序 1:1 对应原版 b.a 链：d(proxyUrl) → g() → b() → j(reverse) → a(rule)*
  start(context: Context): boolean {
    if (this.running || !this.isSupported()) {
      return false
    }
    const config = this.getConfig(context)
    if (!config.hasProxyUrl()) {
      return false
    }
    const proxyConfig = new webview.ProxyConfig()
    try {
      // 原版 d(url)：代理地址原样直传，格式 [scheme://]host[:port]，
      // scheme http/https/socks（socks 默认端口 1080），原版 socks://host:port 原生可建隧道
      proxyConfig.insertProxyRule(config.proxyUrl)
      // 原版 g()：本地地址绕过
      proxyConfig.insertBypassRule('<local>')
      // 原版 b()：direct:// 兜底（未匹配规则 URL 直连），默认 MATCH_ALL_SCHEMES
      proxyConfig.insertDirectRule()
      // 原版 j(true)：仅 d() 且 h() 时反转 bypass 语义（列表内走代理、其余直连）
      if (this.isReverseBypassSupported() && config.reverseBypassRules) {
        proxyConfig.enableReverseBypass(true)
      }
      // 原版 a(rule)：bypass 列表逐条插入
      const rules = config.sortedRules()
      for (let i = 0; i < rules.length; i++) {
        proxyConfig.insertBypassRule(rules[i])
      }
    } catch (error) {
      return false
    }
    this.prepareWebEngine()
    try {
      // 原版 q0/c.c(config, executor, runnable)：应用代理；回调在 UI 线程（原版日志 webview proxy changed!）
      webview.ProxyController.applyProxyOverride(proxyConfig, () => {
        console.info('webview proxy changed!')
      })
    } catch (error) {
      return false
    }
    this.running = true
    return true
  }

  // 原版 s8/b.f()：移除代理配置，恢复默认网络连接
  stop(context: Context): boolean {
    if (!this.running || !this.isSupported()) {
      return false
    }
    this.prepareWebEngine()
    try {
      webview.ProxyController.removeProxyOverride(() => {
        console.info('webview proxy changed!')
      })
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
