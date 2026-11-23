import { ViaIcon } from './ViaIcon'

/**
 * 横滑前进/后退指示层 —— 原版 y7.f2940p（c8/y7.java:136 + h6/a 链式参数逐项换算）
 * 的 ArkUI 复刻，供 TabWeb（网页）与 HomePage（主页）共用。
 *   72dp 宽 × 60dp 高、四边 20dp 内边距、drawable ai 背景（#E64E4E4E + 18dp 圆角
 *   + 1px #40808080 描边）、elevation 12dp（y7.f():70-77）。
 * 图标（k6.a.c:349-358）：后退 = drawable b2；前进 = a3 = b2 外包 <rotate 180°>。
 * 定位：marginStart -73dp 布局位由 position 基准 x 承载（y: 垂直居中由父容器给）。
 * 状态量由宿主（TabWeb/HomePage）持有并驱动，本组件纯展示。
 */
@ComponentV2
export struct SwipeNavIndicator {
  @Param visible: boolean = false
  @Param forward: boolean = false
  @Param shiftX: number = 0
  @Param alpha: number = 1
  // 垂直位置（vp）：指示层高 60，父容器高度一半减 30 = CENTER_VERTICAL
  @Param centerY: number = 0

  build() {
    if (this.visible) {
      Row() {
        ViaIcon({
          icon: $r('app.media.uia_ic_back'),
          iconSize: 24,
          iconColor: '#FFFFFF',
          rotateDeg: this.forward ? 180 : 0
        })
      }
      .width(72)
      .height(60)
      .padding(20)
      // 原版 background = drawable ai（x7.o.N1 → r/d/ai.xml）：
      // solid @color/a9=#E64E4E4E、corners @dimen/ae=18dp、stroke 1px @color/a8=#40808080
      .backgroundColor('#E64E4E4E')
      .borderRadius(18)
      .border({ width: 1, color: '#40808080' })
      .alignItems(VerticalAlign.Center)
      .justifyContent(FlexAlign.Center)
      // 原版 y7.f()：API21+ setElevation(12dp)
      .shadow({ radius: 12, color: 'rgba(0,0,0,0.2)', offsetY: 2 })
      // position 覆盖布局 margin：x 直接给「-73dp + translationX」的合成值
      .position({
        x: -73 + this.shiftX,
        y: this.centerY
      })
      .opacity(this.alpha)
      .hitTestBehavior(HitTestMode.None)
    }
  }
}
