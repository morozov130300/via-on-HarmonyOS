import { http } from '@kit.NetworkKit'
import { display, curves, window, AnimatorOptions, AnimatorResult } from '@kit.ArkUI'
import { pasteboard } from '@kit.BasicServicesKit'
import { i18n } from '@kit.LocalizationKit'
import { computeDialogWidthVp } from './ViaDialogCard'
import { UiInsets } from '../common/Immersive'
import { TabStore } from '../common/TabStore'
import { DECELERATE_CURVE } from '../common/Transitions'

// 原版 com.tuyafeng.support.widget.w 构造（w.java:113-121）：
//   ProgressBar 初始 max=100（y7/g.java:119 setMax(100)）→ w 内部 max = 100*10 = 1000，
//   并 setMax(1000)；80% 阈值 f4375c = (1000/10)*8 = 800
const PROG_MAX: number = 1000
const PROG_THRESHOLD: number = 800

// 原版 f8/c.A1（f8.w0 继承 f8.c）进出场：AnimatorSet 160ms + AccelerateInterpolator，
// alpha 0→1 与 translationY ±120 同步
const PROG_ACCELERATE_CURVE: ICurve = curves.customCurve((t: number): number => t * t)

// 原版 w.e() 四条分支对应的 UpdateListener 内部类
const PROG_KIND_RUSH: number = 0   // w$a（冲 80% 阈值 + 走到目标）
const PROG_KIND_QUAD: number = 1   // w$b（二次方冲到阈值）
const PROG_KIND_LINEAR: number = 2 // w$c（线性走到目标）
const PROG_KIND_FADE: number = 3   // w$d（到 max 且 alpha 渐隐，结束隐藏归零）

// 原版 f8.w0 划词翻译面板（1:1 移植，行号均指 f8/w0.java）：
// - 布局 res/layout/t.xml：EditText(az) 7/5/1 行 + 48dp 图标(cf) + 2dp 分割线 + 2dp ProgressBar(d5)
//   + 结果 TextView(fl) 1/5 行 + 48dp 复制图标(c0) + 48dp 语言行(fe | cn 48dp/padding14 | fj | cp 40dp)
// - 尺寸：文字 14sp（dimen a_）、语言 12sp（aa）、内边距 12dp、触发按钮 40dp + margin 4dp + padding 9dp
// - 主题（styles.xml a7/a9/a3/ac/i）：面板底 #EBFFFFFF/#CC000000、文字 #DE000000/#BEFFFFFF、
//   图标 #232323/#9F9F9F、分割线 #30EEEEEE/#30111111、触发按钮圆形底 #6F8DE1/#617AC1（按下 #5B73B5/#48598B）
// - 圆角 18dp（dimen ae）：f8/c.C1 → 贴顶时圆下侧、贴底时圆上侧，主页时四角全圆
// - k6.Eb：布局 1 → TOP|RIGHT，其余 → BOTTOM|RIGHT；宽 = N8()
// - 进度条 com.tuyafeng.support.widget.w：请求随机 10-44%（nextInt(35)+10，强制），完成 f(100) 渐隐归零
// - 翻译 oa.a.j：GET translate_a/single?dj=1…，UA Chrome/83.0.4103.116
// - 缓存 v5.b TRANSLATE_CACHE：关闭时存 QUERY/SOURCE/TARGET，180s 有效（w0.t3/u3）

interface TrLangEntry {
  code: string
  en: string
  zh: string
}

// oa.a.h()：自动 + 32 语言，顺序 1:1
const TR_LANGS: TrLangEntry[] = [
  { code: 'auto', en: 'Auto', zh: '检测语言' },
  { code: 'ar', en: 'Arabic', zh: '阿拉伯语' },
  { code: 'az', en: 'Azerbaijani', zh: '阿塞拜疆语' },
  { code: 'be', en: 'Belarusian', zh: '白俄罗斯语' },
  { code: 'bn', en: 'Bengali', zh: '孟加拉语' },
  { code: 'cs', en: 'Czech', zh: '捷克语' },
  { code: 'de', en: 'German', zh: '德语' },
  { code: 'en', en: 'English', zh: '英语' },
  { code: 'es', en: 'Spanish', zh: '西班牙语' },
  { code: 'fa', en: 'Persian', zh: '波斯语' },
  { code: 'tl', en: 'Filipino', zh: '菲律宾语' },
  { code: 'fr', en: 'French', zh: '法语' },
  { code: 'hi', en: 'Hindi', zh: '印地语' },
  { code: 'hr', en: 'Croatian', zh: '克罗地亚语' },
  { code: 'hu', en: 'Hungarian', zh: '匈牙利语' },
  { code: 'id', en: 'Indonesian', zh: '印尼语' },
  { code: 'it', en: 'Italian', zh: '意大利语' },
  { code: 'ja', en: 'Japanese', zh: '日语' },
  { code: 'ko', en: 'Korean', zh: '韩语' },
  { code: 'lt', en: 'Lithuanian', zh: '立陶宛语' },
  { code: 'ne', en: 'Nepali', zh: '尼泊尔语' },
  { code: 'pl', en: 'Polish', zh: '波兰语' },
  { code: 'pt', en: 'Portuguese', zh: '葡萄牙语' },
  { code: 'ro', en: 'Romanian', zh: '罗马尼亚语' },
  { code: 'ru', en: 'Russian', zh: '俄语' },
  { code: 'sl', en: 'Slovenian', zh: '斯洛文尼亚语' },
  { code: 'ta', en: 'Tamil', zh: '泰米尔语' },
  { code: 'tr', en: 'Turkish', zh: '土耳其语' },
  { code: 'uk', en: 'Ukrainian', zh: '乌克兰语' },
  { code: 'uz', en: 'Uzbek', zh: '乌兹别克语' },
  { code: 'vi', en: 'Vietnamese', zh: '越南语' },
  { code: 'zh', en: 'Chinese', zh: '中文' },
  { code: 'zh-TW', en: 'Chinese (Traditional)', zh: '繁体中文' }
]

// 应用语言是否为中文（oa.a.i() 里 zh-TW 走「繁體中文」的那一支）
function trIsZh(): boolean {
  try {
    return i18n.System.getAppPreferredLanguage().startsWith('zh')
  } catch (error) {
    return true
  }
}

// oa.a.i()：名称 = new Locale(code).getDisplayLanguage(设备 Locale)，与 code 相同则不覆盖。
// 这里直接用系统 i18n 取显示名，保证与系统语言一致（而非硬编码中英两套）。
function trLangName(entry: TrLangEntry): string {
  if (entry.code === 'auto') {
    // w0.X1：C0.c(Z0(x7.u.f14167t3))，g3 = Detect language
    try {
      return i18n.System.getDisplayLanguage('auto', i18n.System.getAppPreferredLanguage(), true)
    } catch (error) {
      return trIsZh() ? entry.zh : entry.en
    }
  }
  if (entry.code === 'zh-TW') {
    // oa.a.i()：zh-TW 特例——设备是中文显示「繁體中文」，否则英文全称
    return trIsZh() ? '繁體中文' : 'Chinese (Traditional)'
  }
  try {
    const name = i18n.System.getDisplayLanguage(entry.code, i18n.System.getAppPreferredLanguage(), true)
    // getDisplayLanguage 未收录时原样返回 code，与原版「不覆盖默认名」等价
    return name === '' || name === entry.code ? (trIsZh() ? entry.zh : entry.en) : name
  } catch (error) {
    return trIsZh() ? entry.zh : entry.en
  }
}

// oa.a.e()：按 code 查源语言表（含 auto），未命中回表首
function trSourceLang(code: string): TrLangEntry {
  for (let i = 0; i < TR_LANGS.length; i++) {
    if (TR_LANGS[i].code === code) {
      return TR_LANGS[i]
    }
  }
  return TR_LANGS[0]
}

// oa.a.a()：按 code 查目标语言表（不含 auto），未命中回表首
function trTargetLang(code: string): TrLangEntry {
  for (let i = 1; i < TR_LANGS.length; i++) {
    if (TR_LANGS[i].code === code) {
      return TR_LANGS[i]
    }
  }
  return TR_LANGS[1]
}

// w0.X1:213-216：默认目标 = B0.a(t1.m(t1.n(locale)))；
// 其中 t1.m 取 '-' 前主语言码，zh 且地区 TW 时改写成 zh_HANT（表里没有 → 回表首 ar = TR_LANGS[1]）
function trDefaultTargetCode(): string {
  let tag = ''
  try {
    tag = i18n.System.getSystemLanguage()
  } catch (error) {
    tag = ''
  }
  const parts = tag.split('-')
  const primary = parts.length > 0 ? parts[0].toLowerCase() : ''
  let region = ''
  for (let i = 1; i < parts.length; i++) {
    if (parts[i].length === 2) {
      region = parts[i].toUpperCase()
    }
  }
  if (primary === 'zh' && region === 'TW') {
    return TR_LANGS[1].code
  }
  return trTargetLang(primary).code
}

// com.tuyafeng.support.widget.w 动画回调：value 为 0-100 域进度，finished 表示「已完成」
export type TrProgressAnim = (value: number, finished: boolean) => void

@ObservedV2
export class TranslateState {
  private static instance: TranslateState | null = null

  static getInstance(): TranslateState {
    if (TranslateState.instance === null) {
      TranslateState.instance = new TranslateState()
    }
    return TranslateState.instance
  }

  // ---- 渲染状态（w0 字段映射）----
  // k6.Eb：面板是否已展示
  @Trace visible: boolean = false
  // f6037s0 输入框文本
  @Trace inputText: string = ''
  // f6038t0 结果文本（E0.d()）
  @Trace resultText: string = ''
  // E0 != null
  @Trace hasResult: boolean = false
  // A0：1 输入态 / 2 结果态（s3）
  @Trace mode: number = 1
  // f6044z0 进度（0-100 显示域，内部 0-1000）
  @Trace progressValue: number = 0
  @Trace progressVisible: boolean = false
  @Trace progressAlpha: number = 1.0
  // C0 / D0
  @Trace sourceCode: string = 'auto'
  @Trace targetCode: string = 'ar'

  // F0 请求序号（dispose 语义：y3 重入作废旧响应）
  private requestSeq: number = 0
  // oa/c.java 会话内翻译结果缓存：g() 按 query+target 命中，未命中走网络成功后 f() 入缓存
  private sessionCacheQuery: string[] = []
  private sessionCacheTarget: string[] = []
  private sessionCacheResult: string[] = []
  // E0.b()：上次请求的 sl 参数（g3 交换时解析 auto 源）
  private lastSl: string = 'auto'
  // w 动画回调（组件注册）
  progressAnimator: TrProgressAnim | null = null
  // 进入结果态回调（组件注册：s3(2) 隐藏输入法 + 结果获焦）
  enterResultListener: (() => void) | null = null
  // 关闭时取消进度动画（组件注册）
  cancelProgressListener: (() => void) | null = null
  // v5.b TRANSLATE_CACHE（180s TTL，u3 存 / t3 取）
  private cachedAt: number = -1
  private cachedQuery: string = ''
  private cachedSource: string = 'auto'
  private cachedTarget: string = ''

  // k6.Eb：面板已开 → setText + 点触发按钮；未开 → t3() 恢复缓存 + s3(1) + 文本自动翻译
  open(text: string): void {
    if (this.visible) {
      this.inputText = text
      this.translate()
      return
    }
    // w0.t3()：缓存 180s 内恢复 源/目标/输入
    if (this.cachedAt >= 0 && Date.now() - this.cachedAt < 180000 && this.cachedTarget !== '') {
      this.sourceCode = this.cachedSource
      this.targetCode = this.cachedTarget
      this.inputText = this.cachedQuery
    } else {
      this.sourceCode = 'auto'
      this.targetCode = trDefaultTargetCode()
      this.inputText = ''
    }
    this.hasResult = false
    this.resultText = ''
    this.mode = 1
    this.visible = true
    if (text !== '') {
      this.inputText = text
      this.translate()
    }
  }

  // w0.u3（F1 销毁时落缓存）+ 进度归零：原版 Fragment 连同进度动画一并销毁
  close(): void {
    this.cachedQuery = this.inputText
    this.cachedSource = this.sourceCode
    this.cachedTarget = this.targetCode
    this.cachedAt = Date.now()
    this.requestSeq++
    this.visible = false
    if (this.cancelProgressListener !== null) {
      this.cancelProgressListener()
    }
    this.progressVisible = false
    this.progressValue = 0
    this.progressAlpha = 1.0
  }

  // w0.s3：1=输入态（无结果 7 行 / 有结果 5 行 + 结果 1 行），2=结果态（输入 1 行、结果 5 行）
  setMode(mode: number): void {
    if (this.mode === mode) {
      return
    }
    this.mode = mode
    if (mode === 2 && this.enterResultListener !== null) {
      this.enterResultListener()
    }
  }

  // w0.y3：空 → f(100) + E0=null + s3(1)；非空 → 随机进度 + 请求
  translate(): void {
    this.requestSeq++
    const query = this.inputText.trim()
    if (query === '') {
      this.onProgress(100, true)
      this.hasResult = false
      this.setMode(1)
      return
    }
    // w0.y3：this.f6044z0.g(this.G0.nextInt(35) + 10, true)
    this.onProgress(Math.floor(Math.random() * 35) + 10, false)
    const sl = this.sourceCode === '' ? 'auto' : this.sourceCode
    this.lastSl = sl
    const seq = this.requestSeq
    // oa/c.g()：会话内缓存命中（query+target）直接返回，不走网络
    for (let i = 0; i < this.sessionCacheQuery.length; i++) {
      if (this.sessionCacheQuery[i] === query && this.sessionCacheTarget[i] === this.targetCode) {
        this.onProgress(100, true)
        this.resultText = this.sessionCacheResult[i]
        this.hasResult = true
        this.setMode(2)
        return
      }
    }
    TranslateState.fetch(query, sl, this.targetCode).then((trans: string | null) => {
      if (seq !== this.requestSeq) {
        return
      }
      // w0.i3：f(100)，失败 E0=null + s3(1)，成功 setE0 + 隐藏键盘 + s3(2)
      this.onProgress(100, true)
      if (trans === null) {
        this.hasResult = false
        this.setMode(1)
        return
      }
      // oa/c.f()：网络成功结果入会话缓存
      this.sessionCacheQuery.push(query)
      this.sessionCacheTarget.push(this.targetCode)
      this.sessionCacheResult.push(trans)
      this.resultText = trans
      this.hasResult = true
      this.setMode(2)
    })
  }

  // w0.g3：auto 源先解析为上次请求 sl（E0.b()），仍 auto 或与目标相同则 no-op，否则交换语言与文本
  swap(): void {
    let source = this.sourceCode
    if (source === 'auto' && this.hasResult) {
      source = this.lastSl
    }
    if (source === 'auto' || source === this.targetCode) {
      return
    }
    this.sourceCode = this.targetCode
    this.targetCode = source
    const input = this.inputText
    this.inputText = this.resultText
    this.resultText = input
  }

  // w0.b（清除/退出图标）：有文本清除 + s3(1)，无文本退出面板（l0().onBackPressed()）
  clearOrExit(): void {
    if (this.inputText.length > 0) {
      this.inputText = ''
      this.setMode(1)
    } else {
      this.close()
    }
  }

  // com.tuyafeng.support.widget.w：g(v) 显示并走动画，f(100) 到 100 渐隐归零
  private onProgress(value: number, finished: boolean): void {
    if (this.progressAnimator !== null) {
      this.progressAnimator(value, finished)
    }
  }

  // oa.a.j：GET translate_a/single，sentences[0].trans
  private static async fetch(query: string, sl: string, tl: string): Promise<string | null> {
    const request = http.createHttp()
    try {
      const url = `https://translate.google.com/translate_a/single?dj=1&sl=${sl}&tl=${tl}` +
        `&ie=UTF-8&oe=UTF-8&client=at&dt=t&otf=2&q=${encodeURIComponent(query)}`
      const response = await request.request(url, {
        method: http.RequestMethod.GET,
        connectTimeout: 10000,
        readTimeout: 30000,
        header: {
          'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36' +
            ' (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36'
        }
      })
      if (response.responseCode !== 200) {
        return null
      }
      if (typeof response.result !== 'string') {
        return null
      }
      const root: Record<string, Object> = JSON.parse(response.result) as Record<string, Object>
      const sentences: Object | undefined = root['sentences']
      if (sentences === undefined || !Array.isArray(sentences) || sentences.length === 0) {
        return null
      }
      const first: Record<string, Object> = sentences[0] as Record<string, Object>
      const trans: Object | undefined = first['trans']
      if (typeof trans !== 'string' || trans === '') {
        return null
      }
      return trans
    } catch (error) {
      return null
    } finally {
      request.destroy()
    }
  }
}

// k6.N8() 兜底：容器（窗口）短边；大屏且布局≠0 时 min(短边-96, 384)。
// 主路径由 Index.publishMenuMetrics() 发布 'uia_menu_size_vp'，此处仅首帧未发布时兜底。
function trPanelWidthFallback(): number {
  try {
    let wPx = 0
    let hPx = 0
    const win = AppStorage.get<window.Window>('mainWindow')
    if (win) {
      const rect = win.getWindowProperties().windowRect
      wPx = rect.width
      hPx = rect.height
    }
    const d = display.getDefaultDisplaySync()
    const density = d.densityPixels
    if (density <= 0) {
      return 360
    }
    if (wPx <= 0 || hPx <= 0) {
      wPx = d.width
      hPx = d.height
    }
    const shortVp = Math.min(wPx, hPx) / density
    const layout = AppStorage.get<number>('uia_menu_layout')
    const large = shortVp >= 600
    if (!large || layout === 0 || layout === undefined) {
      return shortVp
    }
    return Math.min(shortVp - 96, 384)
  } catch (error) {
    return 360
  }
}

@ComponentV2
export struct TranslatePanel {
  private state: TranslateState = TranslateState.getInstance()
  private insets: UiInsets = UiInsets.getInstance()
  private inputController: TextAreaController = new TextAreaController()
  // 语言选择弹窗（w5.k.l().e0(标题).b0(列表,已选,监听).f0()，行布局 res/layout/v.xml）
  @Local pickerTitle: ResourceStr = ''
  @Local pickerOptions: string[] = []
  @Local pickerCodes: string[] = []
  @Local pickerChecked: number = -1
  @Local pickerOnSelect: (code: string) => void = (code: string) => {
  }
  private pickerDialogId: number = -1

  aboutToAppear(): void {
    // w0.X1：f6044z0 = new com.tuyafeng.support.widget.w(progressBar)
    this.state.progressAnimator = (value: number, finished: boolean): void => {
      this.animateProgress(value, finished)
    }
    // s3(2)：请求结果获焦 + 收起输入法（z8.f.e(f6037s0)）
    this.state.enterResultListener = (): void => {
      try {
        this.inputController.stopEditing()
      } catch (error) {
        console.error('stop editing failed')
      }
    }
    this.state.cancelProgressListener = (): void => {
      if (this.progAnimator !== null) {
        this.progAnimator.cancel()
        this.progAnimator = null
      }
      this.progValue = 0
      this.progShown = 0
    }
  }

  aboutToDisappear(): void {
    this.state.progressAnimator = null
    this.state.enterResultListener = null
    this.state.cancelProgressListener = null
    if (this.progAnimator !== null) {
      this.progAnimator.cancel()
      this.progAnimator = null
    }
  }

  // k6.Eb 的 gravity：布局 1 → TOP|RIGHT，其余（0/2/3）→ BOTTOM|RIGHT
  private isTopAnchored(): boolean {
    const layout = AppStorage.get<number>('uia_menu_layout')
    return layout === 1
  }

  private panelWidthVp(): number {
    const published = AppStorage.get<number>('uia_menu_size_vp')
    if (published !== undefined && published > 0) {
      return published
    }
    return trPanelWidthFallback()
  }

  // ── 原版 com.tuyafeng.support.widget.w 的 g()/f()/e() 逐行复刻（w.java）────────────
  // 调用点（f8/w0.java）：
  //   w0:389 请求开始 → g(G0.nextInt(35) + 10, true)
  //   w0:410 空输入   → f(100) = g(100, false)
  //   w0:175 请求完成 → f(100) = g(100, false)
  // g(i10, z10)：i11 = i10*10（ProgressBar max 已被 w 构造改成 1000）
  //   if (f4377e == 0 && i11 < f4374b) { setAlpha(1); setVisibility(0); f4377e = 1; }
  //   if (f4377e != 0) e(i11, progressBar.getProgress(), z10)
  private animateProgress(value: number, finished: boolean): void {
    this.wG(value * 10, !finished)
  }

  // 当前进度（原版 progressBar.getProgress()，0..1000 域）
  private progValue: number = 0
  // 原版 w.f4377e：0 = 未显示，1 = 显示中
  private progShown: number = 0
  private progAnimator: AnimatorResult | null = null

  // 原版 w.g(int i10, boolean z10)
  private wG(progress: number, force: boolean): void {
    if (this.progShown === 0 && progress < PROG_MAX) {
      this.state.progressAlpha = 1.0
      this.state.progressVisible = true
      this.progShown = 1
    }
    if (this.progShown !== 0) {
      this.wE(progress, this.progValue, force)
    }
  }

  // 原版 w.e(int i10=目标, int i11=当前, boolean z10=强制)
  // 守卫：目标未到 max 且当前非 0 且间距 < max/8 → 不启动新动画
  private wE(target: number, current: number, force: boolean): void {
    if (target < PROG_MAX && current !== 0 && Math.abs(target - current) < PROG_MAX / 8) {
      return
    }
    // 先取消上一个动画并把 alpha 复位成 1
    if (this.progAnimator !== null) {
      this.progAnimator.cancel()
      this.progAnimator = null
    }
    this.state.progressAlpha = 1.0
    let duration = Math.abs(current - target)
    const threshold = PROG_THRESHOLD
    if (target < threshold) {
      if (force || current < target) {
        // 分支 a：时长 = |800-目标|*30 + |当前-目标|
        const rush = Math.abs(threshold - target) * 30 + duration
        const ratio = duration === 0 ? 0 : rush / duration
        this.startProgAnimator(target, current, rush, PROG_KIND_RUSH, threshold, ratio)
        return
      }
      // 分支 b：时长 = |800-当前|*30，二次方插值
      duration = Math.abs(threshold - current) * 30
      this.startProgAnimator(target, current, duration, PROG_KIND_QUAD, threshold, 0)
      return
    }
    if (target < PROG_MAX) {
      // 分支 c：时长 = |当前-目标|，线性插值
      this.startProgAnimator(target, current, duration, PROG_KIND_LINEAR, threshold, 0)
      return
    }
    // 分支 d：目标已到 max，时长减半，进度冲到 max 且 alpha 1→0，结束后隐藏归零
    this.startProgAnimator(target, current, duration / 2, PROG_KIND_FADE, threshold, 0)
  }

  // 原版 ValueAnimator.ofFloat(0,1) + DecelerateInterpolator + setDuration
  private startProgAnimator(target: number, current: number, duration: number, kind: number,
    threshold: number, ratio: number): void {
    if (duration <= 0) {
      this.applyProgFrame(target, current, 1, kind, threshold, ratio)
      this.finishProgFrame(kind)
      return
    }
    const options: AnimatorOptions = {
      duration: duration,
      // ArkUI 原生 animator 的 easing 是字符串曲线，无法直接传 ICurve。
      // 显式 'linear' 让 onFrame 的 progress 为 [begin,end] 线性原值，
      // 再在回调里手动叠加 DECELERATE_CURVE（1-(1-t)²），
      // 等价复刻 w.java:167 的 setInterpolator(new DecelerateInterpolator())。
      easing: 'linear',
      delay: 0,
      fill: 'forwards',
      direction: 'normal',
      iterations: 1,
      begin: 0,
      end: 1
    }
    const animator = this.getUIContext().createAnimator(options)
    this.progAnimator = animator
    animator.onFrame = (progress: number): void => {
      const t = DECELERATE_CURVE.interpolate(progress)
      this.applyProgFrame(target, current, t, kind, threshold, ratio)
    }
    animator.onFinish = (): void => {
      this.progAnimator = null
      this.finishProgFrame(kind)
    }
    animator.play()
  }

  // 各分支的 setProgress 公式（w.java 内部类 a/b/c/d 的 onAnimationUpdate 逐行复刻）
  // 注意原版构造实参顺序：a(i11=当前, ratio, i10=目标)、b(i11=当前)、c(i11=当前, i10=目标)、d(i11=当前)
  private applyProgFrame(target: number, current: number, f: number, kind: number,
    threshold: number, ratio: number): void {
    let next = 0
    if (kind === PROG_KIND_RUSH) {
      // a：current + min(ratio*f, 1)*(target-current) + f*|threshold-target|
      next = current + Math.min(ratio * f, 1.0) * (target - current) + f * Math.abs(threshold - target)
    } else if (kind === PROG_KIND_QUAD) {
      // b：current + f²*|threshold-current|
      next = current + f * f * Math.abs(threshold - current)
    } else if (kind === PROG_KIND_LINEAR) {
      // c：current + f*(target-current)
      next = current + f * (target - current)
    } else {
      // d：current + (max-current)*f，同时 setAlpha(1-f)
      next = current + (PROG_MAX - current) * f
      this.state.progressAlpha = 1.0 - f
    }
    const clamped = Math.max(0, Math.min(PROG_MAX, Math.round(next)))
    this.progValue = clamped
    // Progress 组件域是 0..100
    this.state.progressValue = clamped / 10
  }

  // e（AnimatorListenerAdapter）：onAnimationEnd → setVisibility(8) + setProgress(0) + f4377e = 0
  private finishProgFrame(kind: number): void {
    if (kind !== PROG_KIND_FADE) {
      return
    }
    this.state.progressVisible = false
    this.progValue = 0
    this.state.progressValue = 0
    this.progShown = 0
  }

  // w0.v3/w3/x3：语言单选列表（标题 16sp 加粗；行 = 复选框 + 文字，padding 左右 16 / 上下 8）
  private openLangPicker(title: ResourceStr, includeAuto: boolean, current: string,
    onSelect: (code: string) => void): void {
    const options: string[] = []
    const codes: string[] = []
    let checked = 0
    for (let i = 0; i < TR_LANGS.length; i++) {
      const entry = TR_LANGS[i]
      if (!includeAuto && entry.code === 'auto') {
        continue
      }
      if (entry.code === current) {
        checked = codes.length
      }
      options.push(trLangName(entry))
      codes.push(entry.code)
    }
    this.pickerTitle = title
    this.pickerOptions = options
    this.pickerCodes = codes
    this.pickerChecked = checked
    this.pickerOnSelect = onSelect
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.LangPickerDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.pickerDialogId = dialogId
    }).catch(() => {
    })
  }

  private closeLangPicker(): void {
    if (this.pickerDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.pickerDialogId)
    this.pickerDialogId = -1
  }

  // w0.b3：结果非空才复制，toast zc「Text copied successfully」（本端 copied＝已复制文本）
  private copyResult(): void {
    if (this.state.resultText.length === 0) {
      return
    }
    const data = pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, this.state.resultText)
    pasteboard.getSystemPasteboard().setData(data)
    this.getUIContext().getPromptAction().showToast({
      message: $r('app.string.copied'),
      duration: 1500
    })
  }

  @Styles
  normalBtn() {
    .backgroundColor($r('app.color.translate_btn_bg'))
  }

  @Styles
  pressedBtn() {
    .backgroundColor($r('app.color.translate_btn_pressed'))
  }

  // res/layout/v.xml：FrameLayout 左右 padding 16dp + CheckBox（左 padding 12dp、上下 8dp、
  // drawablePadding 24dp、单行、中间省略），文字 14sp（?attr/ac）
  @Builder
  LangPickerItem(label: string, index: number) {
    Row({ space: 24 }) {
      Stack() {
        if (this.pickerChecked === index) {
          Circle({ width: 16, height: 16 })
            .fill($r('app.color.accent'))
          Image($r('app.media.uia_ic_find'))
            .width(16)
            .height(16)
            .visibility(Visibility.None)
        } else {
          Circle({ width: 16, height: 16 })
            .fill(Color.Transparent)
            .stroke($r('app.color.dialog_border'))
            .strokeWidth(2)
        }
      }
      .width(16)
      .height(16)
      Text(label)
        .fontSize(14)
        .fontColor($r('app.color.translate_text'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .layoutWeight(1)
    }
    .width('100%')
    .padding({ left: 12, right: 0, top: 8, bottom: 8 })
    .margin({ left: 16, right: 16 })
    .onClick(() => {
      const select = this.pickerOnSelect
      const code = this.pickerCodes[index]
      this.pickerChecked = index
      this.closeLangPicker()
      select(code)
    })
  }

  @Builder
  LangPickerDialog() {
    Column() {
      Text(this.pickerTitle)
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Scroll() {
        Column() {
          ForEach(this.pickerOptions, (label: string, index: number) => {
            this.LangPickerItem(label, index)
          }, (label: string) => label)
        }
      }
      .constraintSize({ maxHeight: '60%' })
      .scrollBar(BarState.Off)
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
  }

  build() {
    if (this.state.visible) {
      // f8.c.A1：进出 alpha + translateY ±120，160ms Accelerate；贴底(+80) 从 +120 起、贴顶从 -120 起
      Stack({
        alignContent: this.isTopAnchored() ? Alignment.TopEnd : Alignment.BottomEnd
      }) {
        Column() {
          // 输入行：EditText(az) + 48dp 图标(cf)
          Row() {
            // 原版 EditText：14sp、?attr/ac、padding 12dp、hint y9「文字」、
            // inputType textNoSuggestions（单行语义：换行不进文本）
            TextArea({ text: this.state.inputText, placeholder: $r('app.string.translate_hint') })
              .fontSize(14)
              .fontColor($r('app.color.translate_text'))
              .placeholderColor($r('app.color.fg_secondary'))
              .placeholderFont({ size: 14 })
              .padding(12)
              .height(24 + this.inputLineCount() * 20)
              .maxLines(this.inputLineCount())
              .lineHeight(20)
              .backgroundColor(Color.Transparent)
              .caretColor($r('app.color.accent'))
              .layoutWeight(1)
              .constraintSize({ minHeight: 24 + this.inputLineCount() * 20 })
              .onChange((value: string) => {
                this.state.inputText = value.replace(/\n/g, '')
              })
              .onFocus(() => {
                // w0.a3：获焦 s3(1)
                this.state.setMode(1)
              })
              .onBlur(() => {
                // w0.a3：失焦且 E0 != null → s3(2)
                if (this.state.hasResult) {
                  this.state.setMode(2)
                }
              })
            // cf：TextWatcher（w0$a）切换图标——有文本 b8(ic_close) / 无文本 bk(ic_exit)
            Image(this.state.inputText.length > 0 ? $r('app.media.uia_ic_stop') : $r('app.media.uia_tr_exit'))
              .width(48)
              .height(48)
              .padding(12)
              .objectFit(ImageFit.Contain)
              .fillColor($r('app.color.translate_icon'))
              .accessibilityText(this.state.inputText.length > 0
                ? $r('app.string.translate_clear_text') : $r('app.string.translate_exit'))
              .onClick(() => {
                // w0$b：有文本 → setText("") + s3(1)；无文本 → onBackPressed
                this.state.clearOrExit()
              })
          }
          .width('100%')
          // 2dp 分割线(?attr/i) + 2dp 进度条(d5)，二者同层叠放
          Stack() {
            Row()
              .width('100%')
              .height(2)
              .backgroundColor($r('app.color.translate_divider'))
            Progress({ value: this.state.progressValue, total: 100, type: ProgressType.Linear })
              .width('100%')
              .height(2)
              .style({ strokeWidth: 2 })
              .color({
                angle: 90,
                colors: [['#FF59C2E5', 0], ['#FFA687E0', 1]]
              } as LinearGradient)
              .visibility(this.state.progressVisible ? Visibility.Visible : Visibility.Hidden)
              .opacity(this.state.progressAlpha)
          }
          .width('100%')
          // 结果行：fl（14sp、?attr/ac、padding 12、textIsSelectable、点击 s3(2)）+ c0 复制图标
          if (this.resultVisible()) {
            Row() {
              Text(this.state.resultText)
                .fontSize(14)
                .fontColor($r('app.color.translate_text'))
                .padding(12)
                .height(24 + this.resultLineCount() * 20)
                .maxLines(this.resultLineCount())
                .lineHeight(20)
                .copyOption(CopyOptions.LocalDevice)
                .layoutWeight(1)
                .onClick(() => {
                  this.state.setMode(2)
                })
              Image($r('app.media.uia_tr_copy'))
                .width(48)
                .height(48)
                .padding(12)
                .objectFit(ImageFit.Contain)
                .fillColor($r('app.color.translate_icon'))
                .accessibilityText($r('app.string.copy_text'))
                .onClick(() => {
                  this.copyResult()
                })
            }
            .width('100%')
          }
          // 语言行：fe 源 | cn 交换(48dp/padding 14) | fj 目标 | cp 触发(40dp + margin 4dp + padding 9dp)
          Row() {
            Text(trLangName(trSourceLang(this.state.sourceCode)))
              .fontSize(12)
              .fontColor($r('app.color.translate_text'))
              .textAlign(TextAlign.Center)
              .maxLines(1)
              .layoutWeight(1)
              .onClick(() => {
                // w0.w3：源语言列表（含「检测语言」）
                this.openLangPicker($r('app.string.translate_source_language'), true,
                  this.state.sourceCode, (code: string): void => {
                    if (code === this.state.sourceCode) {
                      return
                    }
                    this.state.sourceCode = code
                  })
              })
            Image($r('app.media.uia_tr_swap'))
              .width(48)
              .height(48)
              .padding(14)
              .objectFit(ImageFit.Contain)
              .fillColor($r('app.color.translate_icon'))
              .accessibilityText($r('app.string.translate_swap_language'))
              .onClick(() => {
                this.state.swap()
              })
            Text(trLangName(trTargetLang(this.state.targetCode)))
              .fontSize(12)
              .fontColor($r('app.color.translate_text'))
              .textAlign(TextAlign.Center)
              .maxLines(1)
              .layoutWeight(1)
              .onClick(() => {
                // w0.x3：目标语言列表（不含 auto）
                this.openLangPicker($r('app.string.translate_target_language'), false,
                  this.state.targetCode, (code: string): void => {
                    if (code === this.state.targetCode) {
                      return
                    }
                    this.state.targetCode = code
                  })
              })
            // cp 触发：圆形底 ?attr/a7（日 #6F8DE1 / 夜 #617AC1）+ 按下 ?attr/a8，白色 e3 图标
            Stack() {
              Image($r('app.media.uia_tr_translate'))
                .width(22)
                .height(22)
                .objectFit(ImageFit.Contain)
                .fillColor(Color.White)
            }
            .width(40)
            .height(40)
            .margin(4)
            .borderRadius(20)
            .stateStyles({
              normal: this.normalBtn,
              pressed: this.pressedBtn
            })
            .accessibilityText($r('app.string.translate'))
            .onClick(() => {
              this.state.translate()
            })
          }
          .width('100%')
          .height(48)
        }
        .width(this.panelWidthVp())
        .padding({ left: 0, right: 0, top: 0, bottom: 0 })
        .backgroundColor($r('app.color.translate_panel_bg'))
        // f8/c.C1：z11=主页 → 四角全圆；否则贴底圆上侧、贴顶圆下侧
        .borderRadius(this.panelRadius())
        .clip(true)
        // 原版 f8/c.A1（f8.w0 继承）：AnimatorSet.play(alpha).with(translationY)
        //   .setDuration(160).setInterpolator(new AccelerateInterpolator())
        // 插值器设在 AnimatorSet 上，对 alpha 与 translationY 两个子动画同时生效。
        .transition(TransitionEffect.asymmetric(
          TransitionEffect.OPACITY.animation({ duration: 160, curve: PROG_ACCELERATE_CURVE })
            .combine(TransitionEffect.translate({ y: this.isTopAnchored() ? -120 : 120 })
              .animation({ duration: 160, curve: PROG_ACCELERATE_CURVE })),
          TransitionEffect.OPACITY.animation({ duration: 160, curve: PROG_ACCELERATE_CURVE })
            .combine(TransitionEffect.translate({ y: this.isTopAnchored() ? -120 : 120 })
              .animation({ duration: 160, curve: PROG_ACCELERATE_CURVE }))))
      }
      .width('100%')
      .height('100%')
      // k6.Eb：gravity 只做贴边，原版不加任何栏高偏移；这里仅让开状态栏/导航条避免压住系统内容
      .padding({
        top: this.isTopAnchored() ? this.insets.top : 0,
        bottom: this.isTopAnchored() ? 0 : this.insets.bottom
      })
      .hitTestBehavior(HitTestMode.Transparent)
    }
  }

  // f8/c.C1：d((homepage || 贴底) ? ae : 0, (homepage || 贴顶) ? ae : 0)
  private panelRadius(): BorderRadiuses {
    const r = 18
    if (this.isHomePage()) {
      return { topLeft: r, topRight: r, bottomLeft: r, bottomRight: r }
    }
    if (this.isTopAnchored()) {
      return { topLeft: 0, topRight: 0, bottomLeft: r, bottomRight: r }
    }
    return { topLeft: r, topRight: r, bottomLeft: 0, bottomRight: 0 }
  }

  // 原版 k6.Eb 的 homepage 参数 = this.V0 && b9()；b9() 即「当前是主页」。
  // V0 在 7.4.0 里恒为真（主页背景生效标志），故等价于当前标签是主页。
  private isHomePage(): boolean {
    return TabStore.getInstance().current().isHomePage()
  }

  // w0.s3(1)：无结果 7 行、有结果 5 行；s3(2)：输入 1 行
  private inputLineCount(): number {
    if (this.state.mode === 2) {
      return 1
    }
    return this.state.hasResult ? 5 : 7
  }

  // w0.s3：结果态(mode2) 或 输入态有结果 时显示；行数 mode1=1 / mode2=5
  private resultVisible(): boolean {
    return this.state.mode === 2 || this.state.hasResult
  }

  private resultLineCount(): number {
    return this.state.mode === 2 ? 5 : 1
  }
}
