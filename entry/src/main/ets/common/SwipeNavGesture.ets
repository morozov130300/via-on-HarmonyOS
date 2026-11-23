/**
 * 横滑前进/后退手势状态机 —— 1:1 移植原版
 * mark/via/common/widget/GestureTouchEvent.java（Uia 7.4.0 反编译）横滑半区。
 *
 * 原版机制（k6.java:4104 GestureTouchEvent(f2584o0.f2940p, f8())，一个状态机同时
 * 承载竖滑与横滑；本工程竖滑在 common/AutoHideGesture.ets、横滑在本文件）：
 *  - down（l() 357-374）：记录起点 rawX/rawY、f9556k/f9557l/f9566u 速度窗口锚点，
 *    f9553h = b.f(view) 方向位（1=后退可用、2=前进可用，k6.a.f:371-383 实时查询，
 *    仅当页面横向不可滚时才置位）。
 *  - 检测（c() 191-215）：|dx| 或 |dy| 越过 4dp（f9549d）后判向；
 *    i10 = dx>0?1:2，(f9553h&i10)!=i10 → a() 结束手势（方向不可用不进 HORIZONTAL）；
 *    !b.d(view)（t4.b.l() = f12132o「本次触摸已横向 overscroll 到边」标志，
 *    onOverScrolled 置位，down 时按 getUrl()==null 重置）→ AWAITING_HORIZONTAL
 *    重记锚点；d(view)=true → 速度判定：|vx|≤|vy| 或 |vx|≤0.5px/ms 或
 *    |dx|≤|dy|+4dp → a()；否则 m() 进 HORIZONTAL。
 *  - HORIZONTAL 起手（m() 376-389）：f9563r = 72*4/5 限幅；
 *    f9565t = dx>0 ? -10px : 页面宽+72+10px（**translationX**，叠加在指示层
 *    marginStart -73dp 布局位上，c8/y7.java:136）；c(view,i10) 设图标；
 *    setTranslationX(f9565t) 后立刻 o(f9554i+f10) 铺首帧。
 *  - 拖动（o() 403-419）：i10 = ((x-f9556k)*8)/10 增量（0.8 增益），累加 f9564s
 *    限幅 ±f9563r，回穿 0 归零；setTranslationX(f9565t + f9564s)。
 *  - 松手（h() → e() 239-255）：|f9564s| ≥ f9563r → **同语句块先** h(f9564s<=0?2:1)
 *    发起导航（1=后退 2=前进），再 ALPHA 1→0 淡出 300ms；
 *    未过阈值 → TRANSLATION_X 回 f9565t（时长 = |位移|/阈值 * 300ms）。
 *  - down 与 cancel（l() 首行 j() / i() → j() 333-342）：取消动画、alpha=1、
 *    translationX=0（translationX=0 时 -73dp margin 使指示层仍在屏外，无损）。
 *
 * ★ ArkWeb 等价映射（b.d(view)）：
 *   方向位已含「页面横向不可滚」前提（k6.a.f），而横向不可滚的页面一拖即
 *   overscroll → f12132o 立即置 true。故本端把 d(view) 等价为恒 true ——
 *   跳过 AWAITING_HORIZONTAL，速度窗口直接用 down 锚点（f9566u = down 时刻），
 *   与原版「不可滚页面」的实际路径一致。
 * ★ canScrollHorizontally 位（k6.a.f:377 网页横向可滚时方向位=0）ArkWeb 无等价
 *   查询接口，由宿主 directionBits() 自理。
 */

/**
 * 宿主回调字段（k6 内部类 a 的横滑子集 + 指示层控制）。
 * ArkTS 不允许无类型对象字面量，宿主用 lambda 字段逐项绑定。
 */
const ST_IGNORED: number = 0
const ST_DETECTING: number = 1
const ST_AWAITING_HORIZONTAL: number = 2
const ST_HORIZONTAL: number = 3

export class SwipeNavGesture {
  /** h(i10)：导航动作，1=后退（U8/I9）、2=前进（V8） */
  onNavigate: ((action: number) => void) | null = null
  /** c(view, i10)：设置指示层图标方向（forward=true = 前进箭头 rotate180） */
  onSetIcon: ((forward: boolean) => void) | null = null
  /** 指示层宽度 vp（原版 max(getWidth, getMeasuredWidth) = 72dp） */
  indicatorWidth: (() => number) | null = null
  /** Web 视口宽度 vp（原版 view.getWidth()，f9565t 左滑分支用） */
  viewportWidth: (() => number) | null = null
  /** 屏外间隙 vp（原版字面量 ±10px，px2vp(10)） */
  edgeGapVp: (() => number) | null = null
  /** 指示层 alpha/位移/可见载体（原版 setAlpha / setTranslationX / setVisibility） */
  setIndicatorAlpha: ((alpha: number) => void) | null = null
  setIndicatorTranslationX: ((x: number) => void) | null = null
  setIndicatorVisible: ((visible: boolean) => void) | null = null
  /** 未过阈值的回弹（目标 translationX=baseT，时长=|shift|/limit*300ms） */
  animateIndicatorBack: ((targetX: number, durationMs: number) => void) | null = null
  /** down/cancel：取消当前指示动画并还原 alpha/translationX */
  resetIndicator: (() => void) | null = null
  /** 页面横向 overscroll 状态 d(view)：原版 t4.b.l()；ArkWeb 尚无等价回调 */
  horizontalEdgeReached: (() => boolean) | null = null

  private state: number = ST_IGNORED
  /** 4dp 检测阈值 f9549d（g6.y.h(ctx,4f)），vp */
  private readonly detectVp: number
  /** 速度阈值：0.5px/ms 转 vp/s（原版 MotionEvent 时间窗口） */
  private readonly speedVpPerSec: number
  /** f9553h：down 时算好的方向位 */
  private directionMask: number = 0
  /** down X/Y、检测时速度窗口锚点（AWAITING_HORIZONTAL 会重设） */
  private downX: number = 0
  private downY: number = 0
  private anchorX: number = 0
  private anchorY: number = 0
  /** f9566u：检测时速度窗口起点，时间单位 ms */
  private downTime: number = 0
  private anchorTime: number = 0
  /** f9563r 限幅 / f9564s 已滑位移 / f9565t 基准 translationX（vp） */
  private limit: number = 0
  private shift: number = 0
  private baseT: number = 0
  /** f9556k：o() 上次的 rawX 基准 */
  private lastMotionX: number = 0

  constructor(detectVp: number, speedVpPerSec: number) {
    this.detectVp = detectVp
    this.speedVpPerSec = speedVpPerSec
  }

  /** 原版 a()：复位软状态（不动指示层） */
  private reset(): void {
    this.state = ST_IGNORED
    this.directionMask = 0
  }

  /** 原版 l(view, event)：down。x/y 屏幕绝对坐标 vp，timeMs 事件时间，bits 方向位 */
  onDown(x: number, y: number, timeMs: number, bits: number): void {
    if (this.resetIndicator !== null) {
      this.resetIndicator()
    }
    this.downX = x
    this.downY = y
    this.anchorX = x
    this.anchorY = y
    this.downTime = timeMs
    this.anchorTime = timeMs
    this.directionMask = bits
    this.shift = 0
    this.state = bits !== 0 ? ST_DETECTING : ST_IGNORED
  }

  /** ArkUI PanGesture velocityX/Y 单位 vp/s，来源 HarmonyOS gesture.d.ts */
  onMove(x: number, y: number, velocityX: number, velocityY: number): void {
    if (this.state === ST_IGNORED) {
      return
    }
    if (this.state === ST_HORIZONTAL) {
      this.updateHorizontal(x)
      return
    }
    const dx: number = x - this.downX
    const dy: number = y - this.downY
    if (this.state === ST_DETECTING && Math.abs(dx) >= Math.abs(dy)) {
      this.detectHorizontal(x, y, velocityX, velocityY)
      return
    }
    if (this.state === ST_DETECTING && (Math.abs(dx) > this.detectVp || Math.abs(dy) > this.detectVp)) {
      return
    }
    if (this.state === ST_AWAITING_HORIZONTAL) {
      this.detectHorizontal(x, y, velocityX, velocityY)
    }
  }

  /** 原版 c()：方向闸、overscroll 等待和速度判定 */
  private detectHorizontal(x: number, y: number, velocityX: number, velocityY: number): void {
    const dx: number = x - this.downX
    const dy: number = y - this.downY
    if (this.state !== ST_DETECTING || Math.abs(dx) > this.detectVp || Math.abs(dy) > this.detectVp) {
      const dirBit: number = dx > 0 ? 1 : 2
      if ((this.directionMask & dirBit) !== dirBit) {
        this.reset()
        return
      }
      if (this.horizontalEdgeReached === null || !this.horizontalEdgeReached()) {
        this.state = ST_AWAITING_HORIZONTAL
        this.anchorX = x
        this.anchorY = y
        this.anchorTime = 0
        return
      }
      // 原版速度阈值 0.5px/ms = 500px/s，ArkUI velocity 单位 vp/s
      if (Math.abs(velocityX) <= Math.abs(velocityY) ||
        Math.abs(velocityX) <= this.speedVpPerSec ||
        Math.abs(dx) <= Math.abs(dy) + this.detectVp) {
        this.reset()
        return
      }
      this.startHorizontal(dirBit, dx)
    }
  }

  /** 原版 m(view, i10, f10)：HORIZONTAL 起手。dx = down 起累计横向位移（vp） */
  private startHorizontal(dirBit: number, dx: number): void {
    if (this.indicatorWidth === null || this.viewportWidth === null ||
      this.edgeGapVp === null || this.onSetIcon === null ||
      this.setIndicatorVisible === null || this.setIndicatorTranslationX === null ||
      this.setIndicatorAlpha === null) {
      this.reset()
      return
    }
    const width: number = this.indicatorWidth()
    if (width <= 0) {
      this.reset()
      return
    }
    this.state = ST_HORIZONTAL
    this.limit = width * 4 / 5
    // f9565t 为叠加在 marginStart -73dp 布局位上的 translationX（vp）
    this.baseT = dx > 0 ? -this.edgeGapVp() : this.viewportWidth() + width + this.edgeGapVp()
    this.shift = 0
    this.lastMotionX = this.downX
    this.setIndicatorAlpha(1)
    this.onSetIcon(dirBit === 2)
    this.setIndicatorVisible(true)
    this.setIndicatorTranslationX(this.baseT)
    this.updateHorizontal(this.downX + dx)
  }

  /** 原版 o(rawX)：每个 HORIZONTAL MOVE 只增量处理一次 */
  private updateHorizontal(rawX: number): void {
    if (this.setIndicatorTranslationX === null) {
      return
    }
    // Java 强转 int 向零截断后再乘 8 / 10（整数除法也向零截断）
    const deltaX: number = Math.trunc(rawX - this.lastMotionX)
    this.lastMotionX = rawX
    let step: number = Math.trunc(deltaX * 8 / 10)
    const prev: number = this.shift
    if (prev + step > this.limit && step > 0) {
      step = this.limit - prev
    } else if (prev + step < -this.limit && step < 0) {
      step = -this.limit - prev
    }
    if ((prev > 0 && prev + step <= 0) || (prev < 0 && prev + step >= 0)) {
      step = 0
    }
    this.shift = prev + step
    this.setIndicatorTranslationX(this.baseT + this.shift)
  }

  /** 原版 h() → e()：松手。返回 true 表示已发起导航（1=后退 2=前进，见 onNavigate） */
  onFinish(): boolean {
    if (this.state !== ST_HORIZONTAL) {
      this.reset()
      return false
    }
    const shift: number = this.shift
    const limit: number = this.limit
    this.reset()
    if (this.onNavigate === null || this.setIndicatorAlpha === null ||
      this.setIndicatorTranslationX === null) {
      return false
    }
    const passed: boolean = limit > 0 && Math.abs(shift) >= limit
    if (passed) {
      // 原版 e()：同语句块先发起导航，再 ALPHA 1→0 淡出（300ms，宿主自理动画）
      this.onNavigate(shift <= 0 ? 2 : 1)
      this.setIndicatorAlpha(0)
      return true
    }
    if (this.animateIndicatorBack !== null) {
      const duration: number = Math.round(Math.abs(shift) / limit * 300)
      this.animateIndicatorBack(this.baseT, Math.max(1, duration))
    } else {
      this.setIndicatorTranslationX(this.baseT)
    }
    return false
  }

  /** 原版 i() → j()：cancel，宿主取消动画并将指示层复位 */
  onCancel(): void {
    this.state = ST_IGNORED
    this.directionMask = 0
    this.shift = 0
    if (this.resetIndicator !== null) {
      this.resetIndicator()
    }
  }
}
