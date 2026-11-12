import { TabItem } from '../common/Types'
import { AppIcon } from './AppIcon'
import { AppSettings } from '../common/Settings'
import { curves } from '@kit.ArkUI'

// 原版 f8/h（查找条）继承 f8/c，f8/c.A1(...) 覆写 Fragment 转场动画：
//   ObjectAnimator alpha 0→1（进场）/ 1→0（退场）
//   + ObjectAnimator translationY：z11 = (f5968o0 & 80) == 80
//       进场 fromY = z11 ? 120 : -120 → 0；退场 0 → z11 ? 120 : -120
//   AnimatorSet.play(alpha).with(translationY).setDuration(160L).setInterpolator(new AccelerateInterpolator())
// 注意插值器设在整个 AnimatorSet 上，alpha 段也是 Accelerate。
// 打开方 k6.ob（c8/k6.java:7887）：gravity = ((W0 == 1 || W0 == 4) ? 48 : 80) | 8388613
//   → 安卓布局 1/4 时贴顶（gravity 48，从 -120 落下）；其余贴底（gravity 80，从 +120 升起）。
// 本端 Index.ets 把 FindBar 恒定位在 insets.top 贴顶（.position({x:0,y:insets.top})），
//   无贴底分支，故 enter/exit 统一取 -120（贴顶落下/收回），与"贴哪边从哪边来"一致。
//   ⚠️ 与原版 W0/gravity 判据不同源，属布局层差异；动画时长/曲线/幅度（160ms Accelerate、±120）1:1。
// 查找条渲染在 insets.top 贴顶（Index.ets），对应含 48 分支。
const FIND_ACCELERATE_CURVE: ICurve = curves.customCurve((t: number): number => t * t)

@ComponentV2
export struct FindBar {
  @Param @Require tab: TabItem
  @Event onClose: () => void = () => {}
  @Local query: string = ''
  private settings: AppSettings = AppSettings.getInstance()
  private inputController: TextInputController = new TextInputController()

  aboutToAppear(): void {
    // 原版 f8/h.e3()：从 FIND_CACHE 恢复上次查找词（TTL 180 天）
    this.settings.readFindCache().then((text: string) => {
      if (text !== '') {
        this.query = text
        this.search(text)
      }
    })
  }

  aboutToDisappear(): void {
    // 原版 f8/h.f3()：销毁时缓存当前查找词
    this.settings.saveFindCache(this.query)
  }

  build() {
    Row({ space: 8 }) {
      TextInput({ placeholder: $r('app.string.find_in_page'), text: this.query, controller: this.inputController })
        .layoutWeight(1)
        .height(36)
        .fontSize(14)
        .backgroundColor($r('app.color.surface'))
        .fontColor($r('app.color.fg'))
        .placeholderColor($r('app.color.fg_secondary'))
        .caretColor($r('app.color.accent'))
        .enterKeyType(EnterKeyType.Search)
        .defaultFocus(true)
        .onChange((value: string) => {
          this.query = value
          this.search(value)
        })
        .onSubmit(() => {
          this.jump(true)
        })
      if (this.query.length > 0 && this.tab.matchOrdinal !== -1) {
        // 原版 f8/h.h3：i11>0 时 i10++ 再展示 "i10/i11"，否则 "i10/0"
        Text(`${this.tab.matchCount > 0 ? this.tab.matchOrdinal + 1 : this.tab.matchOrdinal}/${this.tab.matchCount}`)
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .maxLines(1)
      }
      AppIcon({ icon: $r('sys.symbol.chevron_up'), iconSize: 20 })
        .onClick(() => {
          this.jump(false)
        })
      AppIcon({ icon: $r('sys.symbol.chevron_down'), iconSize: 20 })
        .onClick(() => {
          this.jump(true)
        })
      AppIcon({ icon: $r('sys.symbol.xmark'), iconSize: 20, iconColor: $r('app.color.fg_secondary') })
        .onClick(() => {
          this.clear()
          this.onClose()
        })
    }
    .width('100%')
    .height(48)
    .padding({ left: 12, right: 12 })
    .backgroundColor($r('app.color.page_bg'))
    // 原版 f8/c.A1：160ms Accelerate 的 alpha + translationY(-120→0) 组合转场。
    // alpha 与 translate 共用 AccelerateInterpolator（插值器在 AnimatorSet 上）。
    .transition(TransitionEffect.asymmetric(
      TransitionEffect.OPACITY.animation({ duration: 160, curve: FIND_ACCELERATE_CURVE })
        .combine(TransitionEffect.translate({ y: -120 })
          .animation({ duration: 160, curve: FIND_ACCELERATE_CURVE })),
      TransitionEffect.OPACITY.animation({ duration: 160, curve: FIND_ACCELERATE_CURVE })
        .combine(TransitionEffect.translate({ y: -120 })
          .animation({ duration: 160, curve: FIND_ACCELERATE_CURVE }))))
  }

  private search(text: string): void {
    try {
      if (text === '') {
        this.tab.controller.clearMatches()
        this.tab.matchCount = 0
        this.tab.matchOrdinal = 0
        return
      }
      this.tab.controller.searchAllAsync(text)
    } catch (error) {
      console.error('searchAllAsync failed')
    }
  }

  private jump(forward: boolean): void {
    try {
      this.tab.controller.searchNext(forward)
    } catch (error) {
      console.error('searchNext failed')
    }
  }

  private clear(): void {
    try {
      this.tab.controller.clearMatches()
      this.tab.matchCount = 0
      this.tab.matchOrdinal = 0
      this.query = ''
    } catch (error) {
      console.error('clearMatches failed')
    }
  }
}
