import { display } from '@kit.ArkUI'
import { dialogTransition } from '../common/Transitions'

// 原版 w5.k.f0()：弹窗宽 = min(屏宽,屏高) − 72dp；
// 大屏（g6.y.E）或横屏时上限 300dp
export function computeDialogWidthVp(): number {
  try {
    const d = display.getDefaultDisplaySync()
    const density = d.densityPixels
    if (density <= 0) {
      return 288
    }
    const wVp = d.width / density
    const hVp = d.height / density
    let width = Math.min(wVp, hVp) - 72
    const isLargeScreen = wVp >= 600
    if ((isLargeScreen || wVp > hVp) && width > 300) {
      width = 300
    }
    return width
  } catch (error) {
    return 288
  }
}

// 原版 w5.k 弹窗卡片（layout u.xml + drawable t/u + theme n）：
// 圆角 18dp、纯白/深色底、1dp 描边 #30808080、上下 12dp 留白
@Component
export struct ViaDialogCard {
  @BuilderParam content: () => void
  private cardWidth: number = 0

  aboutToAppear(): void {
    this.cardWidth = computeDialogWidthVp()
  }

  build() {
    Column() {
      this.content()
    }
    .width(this.cardWidth)
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }
}
