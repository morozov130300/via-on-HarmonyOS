import { display, window } from '@kit.ArkUI'
import { dialogTransition } from '../common/Transitions'

// 原版 w5.k.f0()：弹窗宽 = min(窗口宽,窗口高) − 72dp；
// 大屏（g6.y.E）或横屏时上限 300dp
// f13288c/f13289d 取自 Activity content view 宽高 = 应用窗口尺寸，
// 分屏/悬浮窗时是窗口而非物理屏，故此处必须用 windowRect。
export function computeDialogWidthVp(): number {
  try {
    let wPx = 0
    let hPx = 0
    try {
      // EntryAbility.setupWindow 已把主窗口存入 AppStorage（分屏/悬浮窗时即当前应用窗口）
      const win = AppStorage.get<window.Window>('mainWindow')
      if (win) {
        const rect = win.getWindowProperties().windowRect
        wPx = rect.width
        hPx = rect.height
      }
    } catch (error) {
      // 取不到窗口时退回物理屏
    }
    if (wPx <= 0) {
      const d = display.getDefaultDisplaySync()
      wPx = d.width
      hPx = d.height
    }
    const density = display.getDefaultDisplaySync().densityPixels
    if (density <= 0 || wPx <= 0) {
      return 288
    }
    const wVp = wPx / density
    const hVp = hPx / density
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

export { dialogTransition }

// 原版 w5.k 弹窗卡片（layout u.xml + drawable t/u + theme n）：
// 圆角 18dp、纯白/深色底、1dp 描边 #30808080、上下 12dp 留白
@Component
export struct UiaDialogCard {
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
