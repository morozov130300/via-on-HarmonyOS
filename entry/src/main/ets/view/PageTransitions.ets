// 设置子页 / 记录页 的左右推入转场 —— 1:1 复刻原版 Via 7.4.0
//
// 原版依据（反编译产物 D:\via\via_v7.4.0反编译产物）：
//   g6/i.java:67  g6.i.f(...) 内：
//     fragmentManager.q().x(true).v(x7.i.f13638c, x7.i.f13639d, x7.i.f13640e, x7.i.f13641f)
//   即 FragmentTransaction.setCustomAnimations(enter, exit, popEnter, popExit)：
//     f13638c = 2130771973 = 0x7f010005 = res/anim/f
//     f13639d = 2130771974 = 0x7f010006 = res/anim/g
//     f13640e = 2130771975 = 0x7f010007 = res/anim/h
//     f13641f = 2130771976 = 0x7f010008 = res/anim/i
//
//   资源解码（resources_全量解码/resources/res/anim/）：
//     f.xml: translate fromXDelta=@fraction/a(+100%) → toXDelta=0%，duration=@integer/b
//     g.xml: translate fromXDelta=0% → toXDelta=@fraction/c(-30%)
//     h.xml: translate fromXDelta=@fraction/c(-30%) → toXDelta=0%
//     i.xml: translate fromXDelta=0% → toXDelta=@fraction/a(+100%)
//     四者 interpolator 均为 @android:anim/accelerate_decelerate_interpolator
//   数值（resources_全量解码/resources/res/values/）：
//     integers.xml: <integer name="b">220</integer>   → 时长 220ms
//     fractions.xml: <fraction name="a">100%</fraction>、<fraction name="c">-30%</fraction>
//
// 语义映射（FragmentTransaction 四参顺序 = enter, exit, popEnter, popExit）：
//   PUSH + 进入页  → anim/f：自身从 +100% 移到 0
//   PUSH + 旧栈顶  → anim/g：自身从 0 移到 -30%（露出右侧新页的视差）
//   POP  + 回归页  → anim/h：自身从 -30% 移到 0
//   POP  + 退出页  → anim/i：自身从 0 移到 +100%
//
// 同一 fragment 300ms 内不重复跳转的节流在 g6/i.java:60-66
// （SystemClock.elapsedRealtime() - last > 300）——那属于"跳转发起侧"，
// 本文件只负责转场视觉，跳转节流由各调用方按需处理。
// 分场景单列（原生侧无对应默认值，必须显式给曲线）：
//   · 窗口动画 XML（anim/a、k、m 的 alpha 段）无 interpolator → Animation 体系默认 LinearInterpolator
//     → ArkUI 用 Curve.Linear（已在 common/Transitions.ets 落地）
//   · x.r.c(view) 即 ViewPropertyAnimator 未显式 .e(...) → 默认 DecelerateInterpolator
//     → 对应 ArkUI 用 curves.customCurve 复刻 1-(1-t)^2，或 DECELERATE_CURVE
//   · ValueAnimator/ObjectAnimator.ofFloat 未 setInterpolator → 默认 AccelerateDecelerateInterpolator
//   · ArkUI 的 .animation()/animateTo 默认是 Curve.EaseInOut，与以上三者都不同 → 一律禁止省略 curve
import { ACCELERATE_DECELERATE_CURVE } from '../common/Transitions'

// 原版 anim/f..i 的平移幅度：入场 100%，旧页让位 -30%
const SLIDE_FULL: string = '100%'
const SLIDE_PARALLAX: string = '-30%'
const SLIDE_NONE: string = '0'
// integer/b = 220
const SLIDE_DURATION: number = 220

// 生成 NavDestination 自定义转场。
// setTranslate 用于把起始偏移写进页面状态（必须在 delegate 返回前写入，系统随后从该状态开始过渡）。
//
// 注意（API 限制，属精度损失，非"最接近即可"）：
//   NavDestinationTransition.curve 的声明类型是 Curve 枚举（nav_destination.d.ts:565 `curve?: Curve;`），
//   不接受 ICurve，故 ACCELERATE_DECELERATE_CURVE（curves.customCurve 复刻的 cos((t+1)π)/2+0.5）无法传入。
//   此处退而取 Curve.EaseInOut = cubic-bezier(0.42, 0, 0.58, 1)。
//   两者形态相近但**不相等**：AOSP AccelerateDecelerateInterpolator 是余弦曲线，
//   中段斜率峰值比 cubic-bezier(0.42,0,0.58,1) 更缓、端部更平。
//   即：本例存在可感知但轻微的曲线偏差，等 ArkUI 放开 ICurve 或提供 spring/curve 自定义能力后应回归精确值。
export function buildNavSlide(
  operation: NavigationOperation,
  isEnter: boolean,
  setTranslate: (value: string) => void
): Array<NavDestinationTransition> | undefined {
  let fromX: string = SLIDE_NONE
  let toX: string = SLIDE_NONE
  if (operation === NavigationOperation.PUSH) {
    if (isEnter) {
      // anim/f：新页自右侧 +100% 滑入
      fromX = SLIDE_FULL
      toX = SLIDE_NONE
    } else {
      // anim/g：旧页向左让位 30%
      fromX = SLIDE_NONE
      toX = SLIDE_PARALLAX
    }
  } else if (operation === NavigationOperation.POP) {
    if (isEnter) {
      // anim/h：回归页自 -30% 回到 0
      fromX = SLIDE_PARALLAX
      toX = SLIDE_NONE
    } else {
      // anim/i：退出页向右 +100% 移出
      fromX = SLIDE_NONE
      toX = SLIDE_FULL
    }
  } else {
    // REPLACE：原版无对应窗口动画，交回系统默认
    return undefined
  }
  // 起始偏移必须先落盘，event 内再驱动到终值（官方 customTransition 示例同此写法）
  setTranslate(fromX)
  const slide: NavDestinationTransition = {
    duration: SLIDE_DURATION,
    delay: 0,
    curve: Curve.EaseInOut,
    event: (): void => {
      setTranslate(toX)
    }
  }
  return [slide]
}

// 供"没有 AppBar 过渡需求"但需要精确曲线的调用方复用
export const NAV_SLIDE_CURVE: ICurve = ACCELERATE_DECELERATE_CURVE
