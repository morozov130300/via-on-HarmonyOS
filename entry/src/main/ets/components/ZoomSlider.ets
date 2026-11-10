// 原版 mark.uia.common.widget.w0（+ z8.r3.g + x8.h.n/w）1:1 复刻：
// - 2dp 圆角轨道：底色 #40808080（color a8），进度部分 accent（x8.h.j）
// - 12dp accent 圆形滑块（x8.h.w：color accent、圆角 6dp、尺寸 12dp）
// - setHighlightProgress 圆点：直径 = 滑块宽/3×2 = 8dp（w0.onDraw drawCircle 半径 thumb/3），
//   highlight ≤ progress 时 accent，否则轨道底色 #40808080
// - 拖动/点击即时换算：zoom = 50 + round(比例×150/5)×5（max=30、步进 5，范围 50–200）
@ComponentV2
export struct ZoomSlider {
  @Param @Require zoom: number = 100
  // 高亮圆点所在缩放值（w0.setHighlightProgress，缩放域）；<50 不显示
  @Param highlightZoom: number = -1
  @Event onZoomChange: (zoom: number) => void = (zoom: number) => {}
  @Event onZoomEnd: (zoom: number) => void = (zoom: number) => {}
  @Local trackWidth: number = 0
  @Local dragZoom: number = 100

  aboutToAppear(): void {
    this.dragZoom = this.zoom
  }

  // 外部值变化时同步拖动值（页面级提交/设置变更回写场景）
  @Monitor('zoom')
  onZoomParamChange(): void {
    this.dragZoom = this.zoom
  }

  private clampZoom(zoom: number): number {
    let value = Math.round(zoom / 5) * 5
    if (value < 50) {
      value = 50
    }
    if (value > 200) {
      value = 200
    }
    return value
  }

  private pct(zoom: number): string {
    return `${((zoom - 50) / 150 * 100).toFixed(2)}%`
  }

  private handleTouch(event: TouchEvent): void {
    if (this.trackWidth <= 0) {
      return
    }
    const touch = event.touches[0]
    const fraction = Math.min(1, Math.max(0, touch.x / this.trackWidth))
    const next = this.clampZoom(50 + fraction * 150)
    if (next !== this.dragZoom) {
      this.dragZoom = next
      this.onZoomChange(next)
    }
    if (event.type === TouchType.Up || event.type === TouchType.Cancel) {
      this.onZoomEnd(next)
    }
  }

  build() {
    Stack({ alignContent: Alignment.Start }) {
      // 轨道底（x8.h.n：高 2dp、圆角 5dp、色 a8 #40808080）
      Row()
        .width('100%')
        .height(2)
        .borderRadius(1)
        .backgroundColor($r('app.color.hc_40808080'))
      // 进度（accent）
      Column()
        .width(this.pct(this.dragZoom))
        .height(2)
        .borderRadius(1)
        .backgroundColor($r('app.color.accent'))
      // highlight 圆点（w0.onDraw）
      if (this.highlightZoom >= 50 && this.highlightZoom <= 200) {
        Circle({ width: 8, height: 8 })
          .fill(this.highlightZoom <= this.dragZoom ? $r('app.color.accent') : $r('app.color.hc_40808080'))
          .position({ x: this.pct(this.highlightZoom), y: '50%' })
          .markAnchor({ x: 4, y: 4 })
      }
      // 滑块（x8.h.w：12dp accent 圆）
      Circle({ width: 12, height: 12 })
        .fill($r('app.color.accent'))
        .position({ x: this.pct(this.dragZoom), y: '50%' })
        .markAnchor({ x: 6, y: 6 })
    }
    .width('100%')
    .height(24)
    .onAreaChange((_oldArea: Area, newArea: Area) => {
      this.trackWidth = newArea.width as number
    })
    .onTouch((event: TouchEvent) => {
      this.handleTouch(event)
    })
  }
}
