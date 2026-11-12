import { display, AnimatorOptions, AnimatorResult } from '@kit.ArkUI'
import { ACCELERATE_DECELERATE_CURVE } from '../common/Transitions'

// 原版 mark/via/common/widget/k1：朗读悬浮控件
// 贴左边缘 accent 圆角胶囊 [0,18,18,0]，三图标 36dp，
// 垂直拖拽范围 [88dp, 父高-控件高-88dp]，
// 播放中左图标 3000ms 线性旋转、右图标（停止）隐藏
let lastFloatY: number = -1

const DRAG_BOUND_VP: number = 88
const WIDGET_HEIGHT_VP: number = 48

// k1.setPlaying（k1.java:191-219）：
//   转为播放且 f9675n == null →
//     ObjectAnimator.ofFloat(iv, "rotation", iv.getRotation(), iv.getRotation() + 360.0f)
//     .setDuration(3000L) .setRepeatCount(-1) .setInterpolator(new LinearInterpolator()) .start()
//   转为停止 → 若 isStarted() 则 cancel()，并把 f9675n 置 null
// 即：线性、3000ms、无限循环、每次从当前角度再转 360°。
const SPIN_DURATION: number = 3000

@ComponentV2
export struct ReadAloudFloat {
  @Param playing: boolean = false
  @Event onAction: (action: number) => void = (_action: number) => {
  }
  @Local spinAngle: number = 0
  @Local posY: number = -1
  private screenH: number = 0
  private dragStartY: number = 0
  // 原版 k1.f9675n
  private spinAnimator: AnimatorResult | null = null

  aboutToAppear(): void {
    // 原版 xb：初次显示 translationY = 父高/2；记录值跨实例保留（v5.b "y"）
    try {
      const d = display.getDefaultDisplaySync()
      this.screenH = d.height / (d.densityPixels > 0 ? d.densityPixels : 1)
    } catch (error) {
      this.screenH = 640
    }
    if (lastFloatY >= 0) {
      this.posY = lastFloatY
    } else {
      this.posY = this.screenH / 2
    }
    this.syncSpin(this.playing)
  }

  aboutToDisappear(): void {
    // 原版控件销毁：动画随 View detach，这里显式取消
    this.stopSpin()
  }

  // 原版 k1.setPlaying(boolean)：状态变化时启停旋转动画
  @Monitor('playing')
  onPlayingChanged(): void {
    this.syncSpin(this.playing)
  }

  private syncSpin(playing: boolean): void {
    if (playing) {
      this.startSpin()
    } else {
      this.stopSpin()
    }
  }

  // 原版 setPlaying(true) 分支：f9675n == null 才新建
  private startSpin(): void {
    if (this.spinAnimator !== null) {
      return
    }
    const from = this.spinAngle
    const options: AnimatorOptions = {
      duration: SPIN_DURATION,
      easing: 'linear',
      delay: 0,
      fill: 'forwards',
      direction: 'normal',
      iterations: -1,
      begin: from,
      end: from + 360
    }
    const animator = this.getUIContext().createAnimator(options)
    this.spinAnimator = animator
    animator.onFrame = (progress: number): void => {
      this.spinAngle = progress
    }
    animator.play()
  }

  // 原版 setPlaying(false) 分支：isStarted() 则 cancel()，置 null
  private stopSpin(): void {
    if (this.spinAnimator === null) {
      return
    }
    this.spinAnimator.cancel()
    this.spinAnimator = null
  }

  private clampY(y: number): number {
    const max = this.screenH - WIDGET_HEIGHT_VP - DRAG_BOUND_VP
    return Math.max(DRAG_BOUND_VP, Math.min(y, max))
  }

  build() {
    Row() {
      // 原版 f9670e：面板入口（d1 图标，播放中 3000ms 线性旋转）
      Image($r('app.media.uia_readaloud_spin'))
        .width(36)
        .height(36)
        .margin({ top: 6, bottom: 6 })
        .objectFit(ImageFit.Contain)
        .rotate({ angle: this.playing ? this.spinAngle : 0 })
        .onClick(() => {
          this.onAction(4)
        })
      // 原版 f9671j：播放/暂停（setPlaying 切 cu/cw）
      Image(this.playing ? $r('app.media.uia_readaloud_pause') : $r('app.media.uia_readaloud_play'))
        .width(36)
        .height(36)
        .margin({ top: 7, bottom: 7 })
        .objectFit(ImageFit.Contain)
        .onClick(() => {
          this.onAction(this.playing ? 2 : 1)
        })
      // 原版 f9672k：停止（播放中隐藏，desc od=停止朗读）
      if (!this.playing) {
        Image($r('app.media.uia_readaloud_stop'))
          .width(36)
          .height(36)
          .margin({ top: 7, bottom: 7 })
          .objectFit(ImageFit.Contain)
          .onClick(() => {
            this.onAction(3)
          })
      }
    }
    .backgroundColor($r('app.color.accent'))
    .borderRadius({ topLeft: 0, topRight: 18, bottomRight: 18, bottomLeft: 0 })
    .position({ x: 0, y: this.clampY(this.posY) })
    .gesture(
      // 原版 onInterceptTouchEvent/onTouchEvent：仅纵向拖动
      PanGesture({ fingers: 1, direction: PanDirection.Vertical })
        .onActionStart(() => {
          this.dragStartY = this.posY
        })
        .onActionUpdate((event: GestureEvent) => {
          this.posY = this.clampY(this.dragStartY + event.offsetY)
          lastFloatY = this.posY
        })
    )
    // 原版 k6.xb（c8/k6.java:8900-8913）：
    //   setAlpha(0.0f) → addView → translateY(父高/2 或缓存值) → x.r.c(k1).a(1.0f).d(100L).f()
    //   x.r.c 未调 .e() → ViewPropertyAnimator 默认 AccelerateDecelerate，100ms
    .transition(TransitionEffect.OPACITY.animation({ duration: 100, curve: ACCELERATE_DECELERATE_CURVE }))
  }
}
