import { display } from '@kit.ArkUI'

// 原版 mark/via/common/widget/k1：朗读悬浮控件
// 贴左边缘 accent 圆角胶囊 [0,18,18,0]，三图标 36dp，
// 垂直拖拽范围 [88dp, 父高-控件高-88dp]，
// 播放中左图标 3000ms 线性旋转、右图标（停止）隐藏
let lastFloatY: number = -1

const DRAG_BOUND_VP: number = 88
const WIDGET_HEIGHT_VP: number = 48

@ComponentV2
export struct ReadAloudFloat {
  @Param playing: boolean = false
  @Event onAction: (action: number) => void = (_action: number) => {
  }
  @Local spinAngle: number = 0
  @Local posY: number = -1
  private screenH: number = 0
  private dragStartY: number = 0
  private rotateRunning: boolean = false

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
  }

  private clampY(y: number): number {
    const max = this.screenH - WIDGET_HEIGHT_VP - DRAG_BOUND_VP
    return Math.max(DRAG_BOUND_VP, Math.min(y, max))
  }

  // 原版 k1.setPlaying：播放中左图标 3000ms 线性无限旋转（暂停时角度回 0）
  private ensureSpin(): void {
    if (!this.rotateRunning) {
      this.rotateRunning = true
      this.getUIContext().animateTo({ duration: 3000, curve: Curve.Linear, iterations: -1 }, () => {
        this.spinAngle = this.spinAngle + 360
      })
    }
  }

  build() {
    Row() {
      // 原版 f9670e：面板入口（d1 图标，播放中 3000ms 线性旋转）
      Image($r('app.media.via_readaloud_spin'))
        .width(36)
        .height(36)
        .margin({ top: 6, bottom: 6 })
        .objectFit(ImageFit.Contain)
        .rotate({ angle: this.playing ? this.spinAngle : 0 })
        .onClick(() => {
          this.ensureSpin()
          this.onAction(4)
        })
      // 原版 f9671j：播放/暂停（setPlaying 切 cu/cw）
      Image(this.playing ? $r('app.media.via_readaloud_pause') : $r('app.media.via_readaloud_play'))
        .width(36)
        .height(36)
        .margin({ top: 7, bottom: 7 })
        .objectFit(ImageFit.Contain)
        .onClick(() => {
          this.ensureSpin()
          this.onAction(this.playing ? 2 : 1)
        })
      // 原版 f9672k：停止（播放中隐藏，desc od=停止朗读）
      if (!this.playing) {
        Image($r('app.media.via_readaloud_stop'))
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
    .transition(TransitionEffect.OPACITY.animation({ duration: 100 }))
  }
}
