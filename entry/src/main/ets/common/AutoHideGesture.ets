/**
 * 竖滑隐藏/显示操作栏手势状态机 —— 1:1 移植原版
 * mark/via/common/widget/GestureTouchEvent.java（Via 7.4.0 反编译）。
 *
 * 原版机制（k6.java:4104 GestureTouchEvent(f2584o0.f2940p, f8())，
 * 触点挂在 WebView onTouch → k6.E(view, motionEvent) → GestureTouchEvent.g()）：
 *  - 状态机 IGNORED → DETECTING → VERTICAL_PENDING → VERTICAL_DRAGGING：
 *    · 检测阈值 f9548c = ViewConfiguration.getScaledTouchSlop()；
 *      水平预留 f9549d = 4dp（g6.y.h(ctx,4f)）。
 *    · k() 闸（k6.a.k:415-418）：r2()==1（滑动隐藏）或 (r2()==2 且进度<1)，
 *      且 X0==1（工具栏不在传统位置）、非全屏视频、非游戏模式、
 *      非 PDF 全屏时才允许竖滑。
 *    · 竖滑判定要求 |dy|>|dx|（b() 判向，横向让位给横滑前进/后退）。
 *    · 拖动增益（d()）：进度变化量 = -dy / max(顶栏高, 底栏高)（l() 回调），
 *      即滑一整条工具栏高度 = 隐藏/显示一次。
 *    · 拖动中进度 ∈ [0,1]，db(f) 平滑驱动顶栏/底栏位移。
 *    · 松手（h():314-323）：j(show)，show = f10>=1 || (f10>0 && 当前进度<0.5)，
 *      其中 f10=f9561p=拖动起始进度（1=显示 0=隐藏）；S7 动画 180ms 内插。
 *    · 越界提交（d():223-233）：拖动中进度触到 0/1 时 e(show) 立即结算并转
 *      VERTICAL_PENDING 等待反向；show=false（已隐藏）且非滑动隐藏模式时结束手势。
 *    · CANCEL（i():325-331）：已进入拖动则按起始隐藏态回吸（f9560o 快照）。
 *  - 进度含义：1 = 工具栏显示，0 = 工具栏隐藏（db() 只在布局 1/2 时生效）。
 *  - 宿主布尔参数统一为 show（= 原版 z10 语义，true=显示工具栏）。
 */
export interface AutoHideHost {
  /** a()：当前是否处于隐藏态（f2589q1，true=已隐藏） */
  isHidden(): boolean
  /** b()：拖动开始（ta()：取消动画、恢复 VISIBLE、按当前进度重铺位移） */
  onDragStart(): void
  /** i(f)：进度变化（db） */
  onProgress(f: number): void
  /** j(show)：松手结算（S7(show)） */
  onSettle(show: boolean): void
  /** e(show)：拖动中越界立即结算（G8(show)） */
  onCommitImmediate(show: boolean): void
  /** k()：竖滑总闸（r2/X0/全屏/游戏模式等） */
  canGesture(): boolean
  /** l()：拖动增益分母 = max(顶栏高, 底栏高) px */
  barExtentPx(): number
  /** m()：当前进度 f2591r1 */
  progress(): number
  /** g()：仅滑动隐藏模式可反向拖（r2()==1） */
  swipeModeOnly(): boolean
}

export class AutoHideGesture {
  private static readonly ST_IGNORED: number = 0
  private static readonly ST_DETECTING: number = 1
  private static readonly ST_VERTICAL_PENDING: number = 4
  private static readonly ST_VERTICAL_DRAGGING: number = 5

  private state: number = AutoHideGesture.ST_IGNORED
  private readonly slopPx: number
  private downX: number = 0
  private downY: number = 0
  /** 竖滑拖动锚点 f9557l */
  private anchorY: number = 0
  /** VERTICAL_PENDING 反向锚点 f9558m/f9559n */
  private pendingAnchorX: number = 0
  private pendingAnchorY: number = 0
  /** 拖动起始快照 f9560o/f9561p/f9562q */
  private startHidden: boolean = false
  private startProgress: number = 0
  private startSnap: boolean = false
  private host: AutoHideHost | null = null

  constructor(touchSlopPx: number) {
    this.slopPx = touchSlopPx
  }

  bind(host: AutoHideHost): void {
    this.host = host
  }

  /** 原版 g(view, event)：动作分发。action 0=down 1=up 2=move 3=cancel */
  onTouch(action: number, x: number, y: number): void {
    if (action === 0) {
      this.onDown(x, y)
    } else if (action === 1) {
      this.onUp()
    } else if (action === 2) {
      this.onMove(x, y)
    } else if (action === 3) {
      this.onCancel()
    }
  }

  /** 原版 a()：复位 */
  reset(): void {
    this.state = AutoHideGesture.ST_IGNORED
    this.startSnap = false
  }

  /** 原版 l(view, event)：DOWN —— 状态 = k(view) ? DETECTING : IGNORED */
  private onDown(x: number, y: number): void {
    this.downX = x
    this.downY = y
    this.anchorY = y
    this.pendingAnchorX = x
    this.pendingAnchorY = y
    this.startSnap = false
    this.state = this.canGesture() ? AutoHideGesture.ST_DETECTING : AutoHideGesture.ST_IGNORED
  }

  /** 原版 f(view, event)：MOVE */
  private onMove(x: number, y: number): void {
    if (this.state === AutoHideGesture.ST_IGNORED) {
      return
    }
    if (this.state === AutoHideGesture.ST_DETECTING) {
      this.detect(x, y)
    } else if (this.state === AutoHideGesture.ST_VERTICAL_PENDING) {
      if (this.checkReverse(x, y)) {
        this.beginDrag(y)
        this.drag(x, y)
      } else {
        // 原版 p(rawX, rawY)（421-431）：仅当朝可解锁方向移动时推进锚点——
        // 进度>=1 时只跟下滑（f11<f9559n 才更新）、进度<1 时只跟上滑
        const p = this.progress()
        if (p >= 1 ? y < this.pendingAnchorY : y > this.pendingAnchorY) {
          this.pendingAnchorX = x
          this.pendingAnchorY = y
        }
      }
    } else if (this.state === AutoHideGesture.ST_VERTICAL_DRAGGING) {
      this.drag(x, y)
    }
  }

  /** 原版 b(view, event, rawX, rawY)：DETECTING 判向（|dx|>=|dy| 让位横滑） */
  private detect(x: number, y: number): void {
    const dx = x - this.downX
    const dy = y - this.downY
    if (Math.abs(dx) >= Math.abs(dy)) {
      return
    }
    if (Math.abs(dx) > this.slopPx || Math.abs(dy) > this.slopPx) {
      if (!this.canGesture()) {
        this.reset()
        return
      }
      // 方向闸：上滑(dy>=0，要隐藏)需进度>0；下滑(dy<0，要显示)需进度<1
      const p = this.progress()
      if (dy >= 0 ? p > 0 : p < 1) {
        this.beginDrag(y)
        this.drag(x, y)
      } else {
        this.state = AutoHideGesture.ST_VERTICAL_PENDING
        this.pendingAnchorX = x
        this.pendingAnchorY = y
      }
    }
  }

  /** 原版 k(rawX, rawY)：VERTICAL_PENDING 下确认反向拖动 */
  private checkReverse(x: number, y: number): boolean {
    const dy = y - this.pendingAnchorY
    const dx = x - this.pendingAnchorX
    const p = this.progress()
    if (p >= 1) {
      if (dy <= 0) {
        return false
      }
    } else if (dy >= 0) {
      return false
    }
    return Math.abs(dy) > this.slopPx && Math.abs(dy) > Math.abs(dx)
  }

  /** 原版 n(rawY)：进入拖动 —— 快照一次 + 锚点预退 slop + 回调 b() */
  private beginDrag(y: number): void {
    this.state = AutoHideGesture.ST_VERTICAL_DRAGGING
    if (!this.startSnap) {
      this.startHidden = this.isHidden()
      this.startProgress = this.progress()
      this.startSnap = true
    }
    // f9557l = f9559n + copySign(slop, rawY - f9559n)
    const dir = y >= this.pendingAnchorY ? 1 : -1
    this.anchorY = this.pendingAnchorY + dir * this.slopPx
    this.onDragStart()
  }

  /** 原版 d(rawX, rawY)：拖动帧 —— 进度 = 当前进度 - dy/extent，越界立即结算 */
  private drag(x: number, y: number): void {
    const extent = this.host !== null ? this.host.barExtentPx() : 0
    const dy = y - this.anchorY
    if (extent > 0) {
      this.onProgress(this.progress() - dy / extent)
      if (dy !== 0 && (dy >= 0 ? this.progress() <= 0 : this.progress() >= 1)) {
        // 触到 0=已隐藏 → show=false；触到 1=已显示 → show=true
        const show = this.progress() > 0
        this.onCommitImmediate(show)
        if (!show && !this.canSwipeOnly()) {
          // 拖到隐藏且非滑动隐藏模式：手势结束（原版直接 return，不更新锚点）
          this.reset()
          return
        }
        this.state = AutoHideGesture.ST_VERTICAL_PENDING
        this.pendingAnchorX = x
        this.pendingAnchorY = y
      }
    }
    this.anchorY = y
  }

  /** 原版 h()：UP —— f10=f9561p（起始进度），show = f10>=1 || (f10>0 && 当前进度<0.5) */
  private onUp(): void {
    if (this.state === AutoHideGesture.ST_VERTICAL_DRAGGING) {
      const show = this.startProgress >= 1.0 || (this.startProgress > 0 && this.progress() < 0.5)
      this.settle(show)
    }
    this.reset()
  }

  /** 原版 i()：CANCEL —— 已进入拖动则按起始隐藏态回吸（show = !f9560o） */
  private onCancel(): void {
    if (this.startSnap) {
      this.settle(!this.startHidden)
    }
    this.reset()
  }

  private settle(show: boolean): void {
    if (this.host !== null) {
      this.host.onSettle(show)
    }
  }

  private canSwipeOnly(): boolean {
    return this.host !== null && this.host.swipeModeOnly()
  }

  private isHidden(): boolean {
    return this.host !== null && this.host.isHidden()
  }

  private progress(): number {
    return this.host !== null ? this.host.progress() : 0
  }

  private canGesture(): boolean {
    return this.host !== null && this.host.canGesture()
  }

  private onDragStart(): void {
    if (this.host !== null) {
      this.host.onDragStart()
    }
  }

  private onProgress(f: number): void {
    if (this.host !== null) {
      this.host.onProgress(f)
    }
  }

  private onCommitImmediate(show: boolean): void {
    if (this.host !== null) {
      this.host.onCommitImmediate(show)
    }
  }
}
