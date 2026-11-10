import { http } from '@kit.NetworkKit'
import { preferences } from '@kit.ArkData'
import { util } from '@kit.ArkTS'
import { common } from '@kit.AbilityKit'
import { fileIo } from '@kit.CoreFileKit'

// 原版 r9 包（远程配置）1:1 移植：
//   a=ConfigSource 接口、b=空实现、c=FeatureToggle、d=解析、i=List 查询实现、
//   j=抓取器、k=单例（17 键）、f=URL 常量、g=入口、h=fl1 位开关
// 抓取编排在原版 mark/uia/Shell.java:54-57（R()）、应用在 Shell.java:156（k.q().t(new i(list))）

// r9/f.java + z8/c0.f()（本包恒 true，即中国区）→ 唯一生效 URL；海外分支 us-c 保留 1:1 定义
const FEATURE_API_URL_CN: string = 'https://c.uiayoo.com/api/frontend'
const FEATURE_API_URL_GLOBAL: string = 'https://us-c.uiayoo.com/api/frontend'
// Shell.java:56 Authorization token 原样
const FEATURE_API_TOKEN: string = 'default:production.5ae8018a613c7b4ef6297b23aaf7d5d18d16cac9a6636ae20d378aa2'
// r9/j.java:114 User-Agent 原样
const FEATURE_API_UA: string = 'Mozilla/5.0 (Linux; Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.91 Mobile Safari/537.36 Uia/7.4.0.beta'
// r9/j.java:56 距上次抓取超 60000ms 才重新 POST
const FETCH_INTERVAL_MS: number = 60000
// r9/j.java:53 缓存文件 <filesDir>/features；w9/e.java SharedPreferences "features"（uid/last_fetched）
const CACHE_FILE_NAME: string = 'features'
const FEATURE_PREF_NAME: string = 'features'
// r9/k.java u() 内置 base64 白名单默认值（原样保留 base64，运行时解码）
const WLB_B64: string = 'eW91a3UuY29tLGlxaXlpLmNvbSxtZ3R2LmNvbSxxcS5jb20='
const WLR_B64: string = 'di5xcS5jb20seW91a3UuY29tLGlxaXlpLmNvbSxtZ3R2LmNvbSxiaWxpYmlsaS5jb20seGltYWxheWEuY29tLGZpbG0ucXEuY29t'
const WLS_B64: string = 'di5xcS5jb20sZmlsbS5xcS5jb20='
// z8/c0.b()：渠道名校验和（sum(charCode*(i+1)) % 256 的 16 进制大写）；
// 渠道名 = BrowserApp.f() = c0.d(context)（渠道 meta-data，缺失 → "unknown"）；
// 鸿蒙端无渠道 meta-data，按 c0.d 回退语义取 "unknown"
const APP_CHANNEL: string = 'unknown'

// r9/c.java：FeatureToggle { name, enabled, variant, payload }
export class FeatureToggle {
  name: string
  enabled: boolean
  variant: string | null = null
  payload: string | null = null

  constructor(name: string, enabled: boolean = false) {
    this.name = name
    this.enabled = enabled
  }
}

// r9/a.java：配置源接口
export interface ConfigSource {
  getInt(key: string, defaultValue: number): number
  getString(key: string, defaultValue: string | null): string | null
}

// r9/b.java：空实现（全返回 def）
export class EmptyConfigSource implements ConfigSource {
  getInt(key: string, defaultValue: number): number {
    return defaultValue
  }

  getString(key: string, defaultValue: string | null): string | null {
    return defaultValue
  }
}

// r9/d.java：JSONObject → FeatureToggle 解析
function parseToggle(root: Record<string, Object>): FeatureToggle | null {
  const nameRaw: Object | undefined = root['name']
  if (typeof nameRaw !== 'string' || nameRaw === '') {
    return null
  }
  const toggle: FeatureToggle = new FeatureToggle(nameRaw)
  const enabledRaw: Object | undefined = root['enabled']
  toggle.enabled = typeof enabledRaw === 'boolean' ? enabledRaw : false
  const variantRaw: Object | undefined = root['variant']
  if (variantRaw !== undefined && typeof variantRaw === 'object' && variantRaw !== null) {
    const variant: Record<string, Object> = variantRaw as Record<string, Object>
    const payloadRaw: Object | undefined = variant['payload']
    if (payloadRaw !== undefined && typeof payloadRaw === 'object' && payloadRaw !== null) {
      const payload: Record<string, Object> = payloadRaw as Record<string, Object>
      const valueRaw: Object | undefined = payload['value']
      if (typeof valueRaw === 'string') {
        toggle.payload = valueRaw
      }
    }
    const variantNameRaw: Object | undefined = variant['name']
    const variantName: string = typeof variantNameRaw === 'string' ? variantNameRaw : ''
    const variantEnabledRaw: Object | undefined = variant['enabled']
    const variantEnabled: boolean = typeof variantEnabledRaw === 'boolean' ? variantEnabledRaw : !toggle.enabled
    if (variantName !== 'disabled' || variantEnabled !== !toggle.enabled) {
      toggle.variant = variantName
    }
  }
  return toggle
}

// r9/d.java b(String)：解析 {"toggles":[...]} → List<FeatureToggle>；任何失败返回空列表
export function parseToggles(text: string): FeatureToggle[] {
  const empty: FeatureToggle[] = []
  if (text === '') {
    return empty
  }
  let root: Object | null = null
  try {
    root = JSON.parse(text) as Object
  } catch (error) {
    return empty
  }
  if (root === null || typeof root !== 'object') {
    return empty
  }
  const rootRecord: Record<string, Object> = root as Record<string, Object>
  const togglesRaw: Object | undefined = rootRecord['toggles']
  if (togglesRaw === undefined || !Array.isArray(togglesRaw)) {
    return empty
  }
  const toggles: FeatureToggle[] = []
  const arr: Object[] = togglesRaw as Object[]
  for (let i = 0; i < arr.length; i++) {
    const item: Object = arr[i]
    if (typeof item === 'object' && item !== null) {
      const parsed: FeatureToggle | null = parseToggle(item as Record<string, Object>)
      if (parsed !== null) {
        toggles.push(parsed)
      }
    }
  }
  return toggles
}

// r9/i.java：List 型配置查询实现
export class ToggleConfigSource implements ConfigSource {
  private readonly toggles: FeatureToggle[]

  constructor(toggles: FeatureToggle[]) {
    this.toggles = toggles
  }

  private findIndex(key: string): number {
    if (key === '') {
      return -1
    }
    for (let i = 0; i < this.toggles.length; i++) {
      if (this.toggles[i].name.toLowerCase() === key.toLowerCase()) {
        return i
      }
    }
    return -1
  }

  getString(key: string, defaultValue: string | null): string | null {
    const index: number = this.findIndex(key)
    if (index < 0) {
      return defaultValue
    }
    const toggle: FeatureToggle = this.toggles[index]
    if (!toggle.enabled) {
      return defaultValue
    }
    if (toggle.payload !== null && toggle.payload !== '') {
      return toggle.payload
    }
    if (toggle.variant !== null && toggle.variant !== '') {
      return toggle.variant
    }
    return defaultValue
  }

  // Integer.decode 语义：可选符号 + 0x/0X/# 16 进制、前导 0 八进制、其余十进制；非法回退 def
  getInt(key: string, defaultValue: number): number {
    const raw: string | null = this.getString(key, null)
    if (raw === null || raw === '') {
      return defaultValue
    }
    let text: string = raw
    let negative: boolean = false
    if (text.startsWith('-')) {
      negative = true
      text = text.substring(1)
    } else if (text.startsWith('+')) {
      text = text.substring(1)
    }
    let radix: number = 10
    if (text.startsWith('0x') || text.startsWith('0X')) {
      radix = 16
      text = text.substring(2)
    } else if (text.startsWith('#')) {
      radix = 16
      text = text.substring(1)
    } else if (text.length > 1 && text.startsWith('0')) {
      radix = 8
      text = text.substring(1)
    }
    if (text === '') {
      return defaultValue
    }
    const parsed: number = parseInt(text, radix)
    if (Number.isNaN(parsed)) {
      return defaultValue
    }
    return negative ? -parsed : parsed
  }
}

// z8/c1.O / c1.Q：缓存文件文本读写（失败静默）
function readCacheFile(path: string): string | null {
  try {
    return fileIo.readTextSync(path)
  } catch (error) {
    return null
  }
}

function writeCacheFile(path: string, text: string): void {
  try {
    const file = fileIo.openSync(path, fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE | fileIo.OpenMode.TRUNC)
    fileIo.writeSync(file.fd, text)
    fileIo.closeSync(file)
  } catch (error) {
  }
}

// z8/c0.c(String)：渠道名校验和 = Integer.toHexString(sum(charCode*(i+1) % 256)).toUpperCase()
function channelChecksum(): string {
  let sum: number = 0
  for (let i = 0; i < APP_CHANNEL.length; i++) {
    sum += APP_CHANNEL.charCodeAt(i) * (i + 1)
  }
  return (sum % 256).toString(16).toUpperCase()
}

// r9/k.java：单例实现（17 个配置字段，t(a) 注入配置源）
@ObservedV2
export class RemoteConfig {
  private static instance: RemoteConfig | null = null
  // 引擎参数（k.t 顺序 1:1；默认值 1:1）
  private baiduFrom: string = '1022282z'
  private sogouParam: string | null = null
  private toutiaoParam: string | null = null
  private shenmaParam: string | null = null
  private so360Param: string | null = null
  private bingParam: string | null = null
  private googleParam: string | null = null
  private yahooParam: string | null = null
  private metasoParam: string = 's=nyzav&referrer_s=nyzav'
  private desktopSearchEngine: string = 'gg'
  private defaultSearchEngineName: string = 'bd'
  // 白名单（k.u：远程值 + 内置 base64 默认，逗号分割去重小写）
  private wlbHosts: string[] | null = null
  private wlrHosts: string[] | null = null
  private wlsHosts: string[] | null = null
  private wldHosts: string[] | null = null
  // r9/h + w9/b：fl1 位开关，e() = !(第 1 位)（默认 0 → 开启）
  private fl1Bits: number = 0
  // z7/d.java:49-50：「自动展开网页全文」开关行可见性 = (c0.f()||z8.f.h()) && h.e() → 本包即 h.e()
  @Trace autoExpandSwitchVisible: boolean = true

  private constructor() {
    // 原版 k() 构造：t(null) → 默认值
    this.apply(new EmptyConfigSource())
  }

  static getInstance(): RemoteConfig {
    if (RemoteConfig.instance === null) {
      RemoteConfig.instance = new RemoteConfig()
    }
    return RemoteConfig.instance
  }

  // r9/k.java t(a)：按配置源刷新全部 17 键
  apply(source: ConfigSource): void {
    this.baiduFrom = source.getString('bd', '1022282z') ?? '1022282z'
    this.sogouParam = source.getString('sg', null)
    this.toutiaoParam = source.getString('tt', null)
    this.shenmaParam = source.getString('sm', null)
    this.so360Param = source.getString('hs', null)
    this.bingParam = source.getString('bn', null)
    this.googleParam = source.getString('gg', null)
    this.yahooParam = source.getString('yh', null)
    this.metasoParam = source.getString('mt', 's=nyzav&referrer_s=nyzav') ?? 's=nyzav&referrer_s=nyzav'
    this.desktopSearchEngine = source.getString('ds_u', 'gg') ?? 'gg'
    this.defaultSearchEngineName = source.getString('ds_g', 'bd') ?? 'bd'
    this.buildWhitelists(source)
    this.fl1Bits = source.getInt('fl1', 0)
    this.autoExpandSwitchVisible = (this.fl1Bits & 1) === 0
  }

  // r9/k.java u()：白名单 = 远程值(可空) + "," + 内置 base64 默认；wld 无内置默认
  private buildWhitelists(source: ConfigSource): void {
    this.wlbHosts = splitWhitelist((source.getString('wlb', '') ?? '') + ',' + decodeBase64(WLB_B64))
    this.wlrHosts = splitWhitelist((source.getString('wlr', '') ?? '') + ',' + decodeBase64(WLR_B64))
    this.wlsHosts = splitWhitelist((source.getString('wls', '') ?? '') + ',' + decodeBase64(WLS_B64))
    this.wldHosts = splitWhitelist(source.getString('wld', '') ?? '')
  }

  // 引擎参数访问器（r9/e 接口方法 → k 字段）
  getBaiduFrom(): string {
    return this.baiduFrom
  }

  getSogouParam(): string | null {
    return this.sogouParam
  }

  getToutiaoParam(): string | null {
    return this.toutiaoParam
  }

  getShenmaParam(): string | null {
    return this.shenmaParam
  }

  getSo360Param(): string | null {
    return this.so360Param
  }

  getBingParam(): string | null {
    return this.bingParam
  }

  getGoogleParam(): string | null {
    return this.googleParam
  }

  getYahooParam(): string | null {
    return this.yahooParam
  }

  getMetasoParam(): string {
    return this.metasoParam
  }

  // k.o()：ds_u（本包 z8/v2.a 中 c0.i()=false，分支不生效）
  getDesktopSearchEngine(): string {
    return this.desktopSearchEngine
  }

  // k.b()：ds_g，默认搜索引擎名（原版 z8/v2.a 消费）
  getDefaultSearchEngineName(): string {
    return this.defaultSearchEngineName
  }

  // r9/k.java r(String)：取 host（无 '/' 原样返回；有 scheme 截到首 '/'；小写）
  private hostKeyOf(url: string): string | null {
    if (url === '') {
      return null
    }
    if (url.indexOf('/') < 0) {
      return url
    }
    const schemeIndex: number = url.indexOf('://')
    if (schemeIndex < 0) {
      return null
    }
    let rest: string = url.substring(schemeIndex + 3)
    const slashIndex: number = rest.indexOf('/')
    if (slashIndex >= 0) {
      rest = rest.substring(0, slashIndex)
    }
    const host: string = rest.toLowerCase()
    if (host === '') {
      return null
    }
    return host
  }

  // r9/k.java s(String[], String)：host 是否命中白名单项（前后须为 '.' 或边界）
  private matchesWhitelist(hosts: string[] | null, url: string): boolean {
    const host: string | null = this.hostKeyOf(url)
    if (hosts === null || hosts.length === 0 || host === null || host === '') {
      return false
    }
    for (let i = 0; i < hosts.length; i++) {
      const entry: string = hosts[i]
      const index: number = host.indexOf(entry)
      if (index >= 0 &&
        (index <= 0 || host.charAt(index - 1) === '.') &&
        (entry.length + index >= host.length || host.charAt(index + entry.length) === '.')) {
        return true
      }
    }
    return false
  }

  // k.n(url)：wlb（youku/iqiyi/mgtv/qq）
  isInWlb(url: string): boolean {
    return this.matchesWhitelist(this.wlbHosts, url)
  }

  // k.a(url)：wlr（v.qq/youku/iqiyi/mgtv/bilibili/ximalaya/film.qq）
  isInWlr(url: string): boolean {
    return this.matchesWhitelist(this.wlrHosts, url)
  }

  // k.e(url)：wls（v.qq/film.qq）——自动展开网页全文等功能的豁免名单
  isInWls(url: string): boolean {
    return this.matchesWhitelist(this.wlsHosts, url)
  }

  // k.c(url)：wld（默认空）
  isInWld(url: string): boolean {
    return this.matchesWhitelist(this.wldHosts, url)
  }

  // r9/h.java e()：!(fl1 第 1 位)，即「自动展开网页全文」可用
  isFl1AutoExpandEnabled(): boolean {
    return (this.fl1Bits & 1) === 0
  }

  // 原版 Shell.h0()→d0()：启动时抓取（r9/j.java a() 语义）并应用（Shell.java:156）
  // 网络失败静默降级默认值；缓存文件 + 60s 节流 + uid 持久化 1:1
  async load(context: common.Context): Promise<void> {
    const toggles: FeatureToggle[] = await fetchFeatureToggles(context)
    this.apply(new ToggleConfigSource(toggles))
  }
}

// r9/k.java v(String, char)：逗号分割，逐项 trim + 小写 + 去重（HashSet）；空输入返回 null
function splitWhitelist(text: string): string[] | null {
  if (text === '') {
    return null
  }
  const set: Set<string> = new Set<string>()
  let start: number = 0
  while (start < text.length) {
    let end: number = text.indexOf(',', start)
    if (end < 0) {
      end = text.length
    }
    set.add(text.substring(start, end).trim().toLowerCase())
    start = end + 1
  }
  const result: string[] = []
  for (const entry of set) {
    result.push(entry)
  }
  return result
}

function decodeBase64(text: string): string {
  const bytes: Uint8Array = new util.Base64Helper().decodeSync(text)
  let out: string = ''
  for (let i = 0; i < bytes.length; i++) {
    out += String.fromCharCode(bytes[i])
  }
  return out
}

// 原版 i6/i0.s（m||n）：http:// 或 https:// 前缀
function isHttpUrl(text: string): boolean {
  return text.startsWith('http://') || text.startsWith('https://')
}

// r9/j.java：抓取器
// a()：读缓存文件解析；空缓存或距 last_fetched 超 60000ms → POST（含 token/UA，
// body {"userId":...}）；200 → 解析 + 写缓存 + 记录时间；非 200 → 用缓存列表；
// 网络异常向上抛（原版 Rx 错误分支不应用配置，保持默认值）
async function fetchFeatureToggles(context: common.Context): Promise<FeatureToggle[]> {
  const store: preferences.Preferences = await preferences.getPreferences(context, FEATURE_PREF_NAME)
  const cachePath: string = `${context.filesDir}/${CACHE_FILE_NAME}`
  const cachedText: string | null = readCacheFile(cachePath)
  const cachedList: FeatureToggle[] = cachedText === null ? [] : parseToggles(cachedText)
  const lastFetched: number = (await store.get('last_fetched', 0)) as number
  let list: FeatureToggle[] = cachedList
  if (cachedList.length === 0 || Date.now() > lastFetched + FETCH_INTERVAL_MS) {
    const userId: string = await ensureUserId(store)
    const body: string = `{"userId":"${userId}"}`
    const response: FetchResponse | null = await postFeatures(body)
    if (response !== null && response.code === 200) {
      list = parseToggles(response.text)
      writeCacheFile(cachePath, response.text)
      await store.put('last_fetched', Date.now())
      await store.flush()
    } else {
      list = cachedList
    }
  }
  return list
}

// w/d：{code, body} 结果对
class FetchResponse {
  code: number = 0
  text: string = ''

  constructor(code: number, text: string) {
    this.code = code
    this.text = text
  }
}

// r9/j.java e(JSONObject)：POST，头部 Content-Type/Authorization/User-Agent 1:1
async function postFeatures(body: string): Promise<FetchResponse | null> {
  const request: http.HttpRequest = http.createHttp()
  try {
    const response: http.HttpResponse = await request.request(FEATURE_API_URL_CN, {
      method: http.RequestMethod.POST,
      header: {
        'Content-Type': 'application/json',
        'Authorization': FEATURE_API_TOKEN,
        'User-Agent': FEATURE_API_UA
      },
      extraData: body,
      connectTimeout: 15000,
      readTimeout: 30000,
      usingCache: false
    })
    const result: string = typeof response.result === 'string' ? response.result : ''
    return new FetchResponse(response.responseCode, result)
  } finally {
    request.destroy()
  }
}

// r9/j.java c()：uid = UUID 去横线大写 + c0.b()（渠道校验和），持久化于 "features" prefs
async function ensureUserId(store: preferences.Preferences): Promise<string> {
  const cached: string = (await store.get('uid', '')) as string
  if (cached !== '') {
    return cached
  }
  const uid: string = util.generateRandomUUID(false).replace(/-/g, '').toUpperCase() + channelChecksum()
  await store.put('uid', uid)
  await store.flush()
  return uid
}
