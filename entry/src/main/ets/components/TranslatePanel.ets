import { http } from '@kit.NetworkKit'
import { display, curves, AnimatorOptions, AnimatorResult } from '@kit.ArkUI'
import { pasteboard } from '@kit.BasicServicesKit'
import { i18n } from '@kit.LocalizationKit'
import { computeDialogWidthVp } from './UiaDialogCard'
import { UiInsets } from '../common/Immersive'
import { DECELERATE_CURVE } from '../common/Transitions'

// 原版 com.tuyafeng.support.widget.w 构造：
//   ProgressBar 初始 max=100（y7/g.java:119 setMax(100)）→ w 内部 max = 100*10 = 1000，
//   并 setMax(1000)，80% 阈值 f4375c = (1000/10)*8 = 800
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

// 原版 f8.w0 划词翻译面板（1:1 移植）：
// - 布局 r/f/t.xml：EditText 7/5/1 行 + 48dp 清除/退出图标 + 2dp 分割线/进度条
//   + 结果 TextView 1/5 行 + 48dp 复制图标 + 48dp 语言行（源 | 交换 | 目标 | 40dp 触发）
// - 尺寸：文字 14sp（dimen a_）、语言 12sp（dimen aa）、内边距 12dp、进度条 2dp、
//   触发按钮 40dp + margin 4dp + padding 9dp
// - 主题：面板底 ?attr/a3（日 #EBFFFFFF / 夜 #CC000000）、文字 ?attr/ac（日 #DE000000 / 夜 #BEFFFFFF）、
//   图标 ?attr/a9（日 #232323 / 夜 #9F9F9F）、分割线 ?attr/i（日 #30EEEEEE / 夜 #30111111），
//   圆角 18dp（dimen ae）竖屏圆下侧、横屏圆上侧（f8.c C1）
// - k6.Eb：竖屏 TOP|RIGHT、横屏 BOTTOM|RIGHT，宽 N8()，已有面板时 setText + 重译
// - 进度条 com.tuyafeng.support.widget.w：请求随机 10-44%，完成 f(100) 渐隐归零，
//   渐变 x8.h.x（#FF59C2E5→#FFA687E0）
// - Google 翻译 oa.a.j：GET translate_a/single?dj=1…，UA Chrome/83.0.4103.116
// - 缓存 v5.b TRANSLATE_CACHE：关闭时存 QUERY/SOURCE/TARGET，180s 有效（w0.t3/u3）

interface TrLangEntry {
  code: string
  en: string
  zh: string
}

// oa.a.h()：auto + 32 语言（顺序 1:1）
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

// oa.b.b()：本地化显示名（原版 getDisplayLanguage(deviceLocale)）
function trIsZh(): boolean {
  try {
    return i18n.System.getAppPreferredLanguage().startsWith('zh')
  } catch (error) {
    return true
  }
}

function trLangName(entry: TrLangEntry): string {
  return trIsZh() ? entry.zh : entry.en
}

function trFindLang(code: string): TrLangEntry {
  for (let i = 0; i < TR_LANGS.length; i++) {
    if (TR_LANGS[i].code === code) {
      return TR_LANGS[i]
    }
  }
  return TR_LANGS[0]
}

// w0.X1 默认目标：t1.m(t1.n(locale))（语言码），zh 且 country==TW → "zh_HANT"（w0:213-214），
// oa.a.a() 查表未命中回退表首（ar）；语言码列表 oa/a.java h(false) 首项为 ar
function trDefaultTargetCode(): string {
  let lang = ''
  try {
    lang = i18n.System.getAppPreferredLanguage()
  } catch (error) {
    lang = ''
  }
  const parts = lang.split('-')
  const m = parts.length > 0 ? parts[0] : ''
  const region = parts.length > 1 ? parts[parts.length - 1].toUpperCase() : ''
  // w0.X1:213-216：zh + TW → "zh_HANT" → oa.a.a() 未命中 → 表首 'ar'
  if (m === 'zh' && region === 'TW') {
    return 'ar'
  }
  if (m === '') {
    return 'ar'
  }
  for (let i = 1; i < TR_LANGS.length; i++) {
    if (TR_LANGS[i].code === m) {
      return m
    }
  }
  return 'ar'
}

// com.tuyafeng.support.widget.w 动画回调：value < 100 走 g()（随机段），100 走 f()（渐隐归零）
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
  // f6037s0 输入
  @Trace inputText: string = ''
  // f6038t0 结果文本（E0.d()）
  @Trace resultText: string = ''
  // E0 != null
  @Trace hasResult: boolean = false
  // A0：1 输入态 / 2 结果态（s3）
  @Trace mode: number = 1
  // f6044z0 进度（0-100）
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
  // v5.b TRANSLATE_CACHE（180s TTL，u3 存 / t3 取）
  private cachedAt: number = -1
  private cachedQuery: string = ''
  private cachedSource: string = 'auto'
  private cachedTarget: string = ''

  // k6.Eb：已有面板 = setText + performClick；未开 = 恢复缓存 + 可选 text 自动翻译
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

  // w0.F1/u3：关闭存缓存
  close(): void {
    this.cachedQuery = this.inputText
    this.cachedSource = this.sourceCode
    this.cachedTarget = this.targetCode
    this.cachedAt = Date.now()
    this.requestSeq++
    this.visible = false
  }

  // w0.s3：1=输入态（无结果 7 行/有结果 5 行，结果行隐藏/1 行），2=结果态（输入 1 行、结果 5 行）
  setMode(mode: number): void {
    if (this.mode === mode) {
      return
    }
    this.mode = mode
  }

  // w0.y3：空 → f(100)+E0=null+s3(1)；非空 → 随机进度 + 请求
  translate(): void {
    this.requestSeq++
    const query = this.inputText.trim()
    if (query === '') {
      this.onProgress(100, true)
      this.hasResult = false
      this.setMode(1)
      return
    }
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
      // w0.i3：f(100)，失败 E0=null+s3(1)，成功 setE0+隐藏键盘+s3(2)
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

  // w0.b（清除/退出图标）：有文本清除 + s3(1)，无文本关闭面板
  clearOrExit(): void {
    if (this.inputText.length > 0) {
      this.inputText = ''
      this.setMode(1)
    } else {
      this.close()
    }
  }

  // com.tuyafeng.support.widget.w：g(v)=显示并走动画，f(100)=到 100 渐隐归零（隐藏时 no-op）
  private onProgress(value: number, finished: boolean): void {
    if (finished && !this.progressVisible) {
      return
    }
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

// k6.N8()：min(屏宽,屏高)；大屏（g6.y.E）竖屏时 min(该值-96, 384)
function trPanelWidthVp(): number {
  try {
    const d = display.getDefaultDisplaySync()
    const density = d.densityPixels
    if (density <= 0) {
      return 360
    }
    const wVp = d.width / density
    const hVp = d.height / density
    const base = Math.min(wVp, hVp)
    const isLargeScreen = wVp >= 600
    const isPortrait = hVp >= wVp
    if (!isLargeScreen || !isPortrait) {
      return base
    }
    return Math.min(base - 96, 384)
  } catch (error) {
    return 360
  }
}

@ComponentV2
export struct TranslatePanel {
  private state: TranslateState = TranslateState.getInstance()
  private insets: UiInsets = UiInsets.getInstance()
  // 语言选择弹窗（w5.k.l().e0(标题).b0(列表,已选,监听).f0()，layout v.xml 单选行）
  @Local pickerTitle: ResourceStr = ''
  @Local pickerOptions: string[] = []
  @Local pickerCodes: string[] = []
  @Local pickerChecked: number = -1
  @Local pickerOnSelect: (code: string) => void = (code: string) => {
  }
  private pickerDialogId: number = -1

  aboutToAppear(): void {
    // w0.X1 绑定 com.tuyafeng.support.widget.w（进度动画）
    this.state.progressAnimator = (value: number, finished: boolean): void => {
      this.animateProgress(value, finished)
    }
  }

  aboutToDisappear(): void {
    this.state.progressAnimator = null
    // 原版 w 生命周期随 f8/w0 Fragment 销毁：取消动画、进度与显示态归零
    if (this.progAnimator !== null) {
      this.progAnimator.cancel()
      this.progAnimator = null
    }
    this.progValue = 0
    this.progShown = 0
    this.state.progressValue = 0
    this.state.progressVisible = false
    this.state.progressAlpha = 1.0
  }

  private isLandscape(): boolean {
    try {
      const d = display.getDefaultDisplaySync()
      return d.width > d.height
    } catch (error) {
      return false
    }
  }

  // ── 原版 com.tuyafeng.support.widget.w 的 g()/f()/e() 逐行复刻 ──────────────────────
  // 调用点（f8/w0.java）：
  //   w0.java:391  请求开始 → g(G0.nextInt(35) + 10, true)   强制推进
  //   w0.java:410  空输入   → f(100)  = g(100, false)
  //   w0.java:175  请求完成 → f(100)  = g(100, false)
  // 原版 g(int i10, boolean z10)：i11 = i10 * 10（ProgressBar max 已被 w 构造改成 1000）
  //   if (f4377e == 0 && i11 < f4374b) { setAlpha(1); setVisibility(0); f4377e = 1; }
  //   if (f4377e != 0) e(i11, progressBar.getProgress(), z10);
  // 即：e 的第一个参数是「目标」，第二个是「当前」。
  private animateProgress(value: number, finished: boolean): void {
    // 原版 f(100) 走 g(100, false)：force=false
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
  // w.java:141 守卫：只有满足其一才启动新动画（否则保持现状、什么都不做）
  private wE(target: number, current: number, force: boolean): void {
    if (target < PROG_MAX && current !== 0 && Math.abs(target - current) < PROG_MAX / 8) {
      return
    }
    // w.java:142-147：先取消上一个动画并把 alpha 复位成 1
    if (this.progAnimator !== null) {
      this.progAnimator.cancel()
      this.progAnimator = null
    }
    this.state.progressAlpha = 1.0
    // w.java:149 long jAbs = Math.abs(i11 - i10) → |当前 - 目标|
    let duration = Math.abs(current - target)
    const threshold = PROG_THRESHOLD
    // w.java:150 int i12 = f4375c(800)；按「目标」判定分支
    if (target < threshold) {
      if (force || current < target) {
        // 分支 a（w.java:153-155）：时长 = |800-目标|*30 + |当前-目标|
        const rush = Math.abs(threshold - target) * 30 + duration
        const ratio = duration === 0 ? 0 : rush / duration
        this.startProgAnimator(target, current, rush, PROG_KIND_RUSH, threshold, ratio)
        return
      }
      // 分支 b（w.java:157-158）：时长 = |800-当前|*30，二次方插值
      duration = Math.abs(threshold - current) * 30
      this.startProgAnimator(target, current, duration, PROG_KIND_QUAD, threshold, 0)
      return
    }
    if (target < PROG_MAX) {
      // 分支 c（w.java:160-161）：时长 = |当前-目标|，线性插值
      this.startProgAnimator(target, current, duration, PROG_KIND_LINEAR, threshold, 0)
      return
    }
    // 分支 d（w.java:162-165）：目标已到 max，时长减半，进度冲到 max 且 alpha 1→0
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
      // 这里显式设 'linear' 让 onFrame 的 progress 为 [begin,end] 的线性原始值，
      // 再在回调里手动叠加一次 DECELERATE_CURVE（1-(1-t)²），
      // 等价复刻原版 w.java:167 的 `setInterpolator(new DecelerateInterpolator())`。
      // 若此处省略手动插值或把 easing 设成 'ease'，都会与原版曲线不符。
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
      // 原版 ValueAnimator 的 DecelerateInterpolator 作用在 0→1 上：1-(1-t)²
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
      // a.java:49  current + min(ratio*f, 1)*(target-current) + f*|threshold-target|
      next = current + Math.min(ratio * f, 1.0) * (target - current) + f * Math.abs(threshold - target)
    } else if (kind === PROG_KIND_QUAD) {
      // b.java:71  current + f²*|threshold-current|
      next = current + f * f * Math.abs(threshold - current)
    } else if (kind === PROG_KIND_LINEAR) {
      // c.java:92  current + f*(target-current)
      next = current + f * (target - current)
    } else {
      // d.java:109-110  current + (max-current)*f，同时 setAlpha(1-f)
      next = current + (PROG_MAX - current) * f
      this.state.progressAlpha = 1.0 - f
    }
    const clamped = Math.max(0, Math.min(PROG_MAX, Math.round(next)))
    this.progValue = clamped
    // Progress 组件域是 0..100
    this.state.progressValue = clamped / 10
  }

  // e.java:121-123  onAnimationEnd → setVisibility(8) + setProgress(0) + progress = 0
  private finishProgFrame(kind: number): void {
    if (kind !== PROG_KIND_FADE) {
      return
    }
    this.state.progressVisible = false
    this.progValue = 0
    this.state.progressValue = 0
    this.progShown = 0
  }

  // w0.v3/w3/x3：语言选择（w5.d 单选列表，radio 左 + 文字 14sp，标题 16sp 加粗）
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

  // w0.b3：结果非空才复制，toast zc「已复制文本」
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

  @Builder
  LangPickerItem(label: string, index: number) {
    Row({ space: 24 }) {
      Circle({ width: 16, height: 16 })
        .fill(this.pickerChecked === index ? $r('app.color.accent') : Color.Transparent)
        .stroke(this.pickerChecked === index ? Color.Transparent : $r('app.color.dialog_border'))
        .strokeWidth(2)
      Text(label)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .layoutWeight(1)
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 12, bottom: 12 })
    .onClick(() => {
      const select = this.pickerOnSelect
      const code = this.pickerCodes[index]
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
      // f8.c A1：进出 alpha + translateY ±120，160ms Accelerate（近似 EaseIn）
      Stack({ alignContent: this.isLandscape() ? Alignment.BottomEnd : Alignment.TopEnd }) {
        Column() {
          // 输入行：EditText(az) + 48dp 清除/退出图标(u0)
          Row() {
            // 原版 EditText：14sp、?attr/ac、padding 12dp、hint y9「文字」、
            // inputType 0xa0001（text + noSuggestions，单行语义：换行截断）
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
                // 原版单行输入：换行不进文本
                this.state.inputText = value.replace(/\n/g, '')
              })
              .onFocus(() => {
                // w0.a3：获焦 s3(1)
                this.state.setMode(1)
              })
              .onBlur(() => {
                // w0.a3：失焦且有结果 s3(2)
                if (this.state.hasResult) {
                  this.state.setMode(2)
                }
              })
            // u0：有文本 = b8 清除（desc fq「清除文本」），无文本 = bk 退出（desc i9「退出」）
            Image(this.state.inputText.length > 0 ? $r('app.media.uia_ic_stop') : $r('app.media.uia_tr_exit'))
              .width(48)
              .height(48)
              .padding(12)
              .objectFit(ImageFit.Contain)
              .fillColor($r('app.color.translate_icon'))
              .accessibilityText(this.state.inputText.length > 0
                ? $r('app.string.translate_clear_text') : $r('app.string.translate_exit'))
              .onClick(() => {
                this.state.clearOrExit()
              })
          }
          .width('100%')
          // 分割线 View（?attr/i 2dp）+ 进度条 d5（2dp，渐变 #FF59C2E5→#FFA687E0）
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
                .textOverflow({ overflow: TextOverflow.Ellipsis })
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
                .onClick(() => {
                  this.copyResult()
                })
            }
            .width('100%')
          }
          // 语言行：fe 源 | cn 交换 | fj 目标 | cp 触发（48dp 高）
          Row() {
            Text(trLangName(trFindLang(this.state.sourceCode)))
              .fontSize(12)
              .fontColor($r('app.color.translate_text'))
              .textAlign(TextAlign.Center)
              .maxLines(1)
              .layoutWeight(1)
              .onClick(() => {
                this.openLangPicker($r('app.string.translate_source_language'), true,
                  this.state.sourceCode, (code: string): void => {
                    this.state.sourceCode = code
                  })
              })
            Image($r('app.media.uia_tr_swap'))
              .width(48)
              .height(48)
              .padding(9)
              .objectFit(ImageFit.Contain)
              .fillColor($r('app.color.translate_icon'))
              .onClick(() => {
                this.state.swap()
              })
            Text(trLangName(trFindLang(this.state.targetCode)))
              .fontSize(12)
              .fontColor($r('app.color.translate_text'))
              .textAlign(TextAlign.Center)
              .maxLines(1)
              .layoutWeight(1)
              .onClick(() => {
                this.openLangPicker($r('app.string.translate_target_language'), false,
                  this.state.targetCode, (code: string): void => {
                    this.state.targetCode = code
                  })
              })
            // cp 触发：40dp、margin 4dp、padding 9dp、accent tint
            Image($r('app.media.uia_tr_translate'))
              .width(40)
              .height(40)
              .margin(4)
              .padding(9)
              .objectFit(ImageFit.Contain)
              .fillColor($r('app.color.accent'))
              .onClick(() => {
                this.state.translate()
              })
          }
          .width('100%')
          .height(48)
        }
        .width(trPanelWidthVp())
        .padding({
          left: 0,
          right: 0,
          top: this.isLandscape() ? 12 : 0,
          bottom: this.isLandscape() ? 0 : 12
        })
        .backgroundColor($r('app.color.translate_panel_bg'))
        .borderRadius({
          topLeft: this.isLandscape() ? 18 : 0,
          topRight: this.isLandscape() ? 18 : 0,
          bottomLeft: this.isLandscape() ? 0 : 18,
          bottomRight: this.isLandscape() ? 0 : 18
        })
        .clip(true)
        // 原版 f8/c.A1（f8.w0 继承）：AnimatorSet.play(alpha).with(translationY)
        //   .setDuration(160).setInterpolator(new AccelerateInterpolator())
        // —— 插值器设在 AnimatorSet 上，对 alpha 和 translationY **两个子动画同时生效**，
        //    所以 alpha 段也是 Accelerate（不是 Linear、不是 EaseIn）。
        // 方向（f8/c.java:60,63 z11=(gravity&80)==80）：
        //   进场 translationY (z11 ? +120 : -120) → 0；退场 0 → (z11 ? +120 : -120)。
        //   即贴底(gravity 含 80)从 +120 升起，贴顶(gravity 含 48)从 -120 落下。
        // 原版 k6.Eb 的 gravity = (W0==1 ? 48 : 80) | 8388613，W0 是安卓布局号；
        // 本端无 W0 直接对应，沿用既有布局判定 isLandscape()（竖屏贴顶 TopEnd / 横屏贴底 BottomEnd，
        // 见本文件 L668），方向随之取竖屏 -120 / 横屏 +120，与"贴哪边就从哪边来"一致。
        // ⚠️ 判据与原版 W0/gravity 不完全同源，属已知的布局层差异，待按 effectiveLayout() 统一时一并校正；
        //    动画时长/曲线/幅度（160ms Accelerate、±120px）则与原版 1:1。
        .transition(TransitionEffect.asymmetric(
          TransitionEffect.OPACITY.animation({ duration: 160, curve: PROG_ACCELERATE_CURVE })
            .combine(TransitionEffect.translate({ y: this.isLandscape() ? 120 : -120 })
              .animation({ duration: 160, curve: PROG_ACCELERATE_CURVE })),
          TransitionEffect.OPACITY.animation({ duration: 160, curve: PROG_ACCELERATE_CURVE })
            .combine(TransitionEffect.translate({ y: this.isLandscape() ? 120 : -120 })
              .animation({ duration: 160, curve: PROG_ACCELERATE_CURVE }))))
      }
      .width('100%')
      .height('100%')
      // k6.Eb 竖屏 TOP|RIGHT / 横屏 BOTTOM|RIGHT：避开顶栏/底栏 + 安全区
      .padding({
        top: this.isLandscape() ? 0 : this.insets.top + 48,
        bottom: this.isLandscape() ? this.insets.bottom : 0
      })
      .hitTestBehavior(HitTestMode.Transparent)
    }
  }

  // w0.s3(1)：无结果输入 7 行、有结果输入 5 行；s3(2)：输入 1 行
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
