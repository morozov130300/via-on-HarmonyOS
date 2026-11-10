import { curves } from '@kit.ArkUI'

// 原版 Uia 7.4.0 窗口/控件动画逐项复刻
// 依据：Uia 工程内的原版反编译产物（resources/ 解码资源）
//  - 窗口动画资源：r/a/a.xml ~ r/a/n.xml（即 APK 的 res/anim/a..n）
//  - 样式映射：resources/res/values/styles.xml —— style k(a/b)、q(m/l)、r(k/n)
//  - 时长整数：resources/res/values/integers.xml —— integer/a=240、integer/d=160
//  - 插值器：a/b 用 bounce_interpolator(0x010a000a)，k/l/m/n 用 accelerate_interpolator(0x010a0005)，
//            f/g/h/i 用 accelerate_decelerate_interpolator(0x010a0004)，e.xml 为 decelerate_interpolator
//  - 代码内动效统一曲线 x8.h.b() = PathInterpolator(0.2,0.2,0.8,0.8)（z.b.a(a,b,c,d)）

// ── AOSP 插值器逐帧复刻 ────────────────────────────────────────────────
// BounceInterpolator：s = input * 1.1226，分段二次反弹
function bounceValue(t: number): number {
  const x = t * 1.1226
  if (x < 0.3535) {
    return x * x * 8.0
  }
  if (x < 0.7408) {
    const d = x - 0.54719
    return d * d * 8.0 + 0.7
  }
  if (x < 0.9644) {
    const d = x - 0.8526
    return d * d * 8.0 + 0.9
  }
  const d = x - 1.0435
  return d * d * 8.0 + 0.95
}

// AccelerateInterpolator(factor=1.0)：t^2
function accelerateValue(t: number): number {
  return t * t
}

// AccelerateDecelerateInterpolator：cos((t+1)*π)/2 + 0.5
function accelerateDecelerateValue(t: number): number {
  return Math.cos((t + 1) * Math.PI) / 2.0 + 0.5
}

export const BOUNCE_CURVE: ICurve = curves.customCurve((t: number): number => bounceValue(t))
export const ACCELERATE_CURVE: ICurve = curves.customCurve((t: number): number => accelerateValue(t))
export const ACCELERATE_DECELERATE_CURVE: ICurve =
  curves.customCurve((t: number): number => accelerateDecelerateValue(t))

// 原版代码统一曲线 x8.h.b()：PathInterpolator(0.2, 0.2, 0.8, 0.8)
// 注意：@ohos.curves 里 cubicBezier() 返回 string，cubicBezierCurve() 才返回 ICurve，
// 这里要当 ICurve 复用，必须用 cubicBezierCurve。
// 数学性质：两个控制点 (0.2,0.2) 与 (0.8,0.8) 均落在 y=x 对角线上，
// 故 x(s)≡y(s)，该 PathInterpolator 的 getInterpolation(t) 恒等于 t（**线性插值**）。
// 这解释了为何原版把 280ms 三关键帧拆成 2×140ms 各自跑完整 bezier 仍等价，
// 也解释了 TabPanel 复合曲线里 BEZIER_0202_CURVE.interpolate(t) 可直接视作 t。
export const BEZIER_0202_CURVE: ICurve = curves.cubicBezierCurve(0.2, 0.2, 0.8, 0.8)

// 原版窗口动画里 translate 的 ±120px（px 单位，运行时换算 vp）
function animPxToVp(px: number): number {
  try {
    return px2vp(px)
  } catch (error) {
    return px * 0.5
  }
}

// 原版弹窗窗口动画 anim/a（进场）/ anim/b（退场反向），style k，时长 integer/a=240：
//   set: alpha 0→1（xml 无 interpolator 属性 → 线性）；translate fromYDelta=+10%→0（bounce）；
//        scale 0.9→1（bounce），pivotX=50%、pivotY=100%（底部中心）
// 注意：ArkUI 的 .animation() 默认曲线是 Curve.EaseInOut，不等于"无插值器"的线性，
// 故 alpha 段必须显式传 Curve.Linear。
export function dialogTransition(): TransitionEffect {
  return TransitionEffect.OPACITY.animation({ duration: 240, curve: Curve.Linear })
    .combine(TransitionEffect.translate({ y: '10%' }).animation({ duration: 240, curve: BOUNCE_CURVE }))
    .combine(TransitionEffect.scale({ x: 0.9, y: 0.9, centerX: '50%', centerY: '100%' })
      .animation({ duration: 240, curve: BOUNCE_CURVE }))
}

// 底部菜单（i8.k.T1：gravity 含 80 → style r）：
//   anim/k 进场：alpha 0→1（线性）+ translateY -120px→0（accelerate），integer/d=160
//   anim/n 退场：alpha 1→0（线性）+ translateY 0→-120px（accelerate），integer/d=160
export function menuTransition(): TransitionEffect {
  const slide = animPxToVp(120)
  const enter = TransitionEffect.OPACITY.animation({ duration: 160, curve: Curve.Linear })
    .combine(TransitionEffect.translate({ y: -slide })
      .animation({ duration: 160, curve: ACCELERATE_CURVE }))
  const exit = TransitionEffect.OPACITY.animation({ duration: 160, curve: Curve.Linear })
    .combine(TransitionEffect.translate({ y: -slide })
      .animation({ duration: 160, curve: ACCELERATE_CURVE }))
  return TransitionEffect.asymmetric(enter, exit)
}

// 顶部菜单（gravity 含 48 → style q）：
//   anim/m 进场：alpha 0→1（线性）+ translateY +120px→0（accelerate），integer/d=160
//   anim/l 退场：alpha 1→0（线性）+ translateY 0→+120px（accelerate），integer/d=160
export function menuTransitionTop(): TransitionEffect {
  const slide = animPxToVp(120)
  const enter = TransitionEffect.OPACITY.animation({ duration: 160, curve: Curve.Linear })
    .combine(TransitionEffect.translate({ y: slide })
      .animation({ duration: 160, curve: ACCELERATE_CURVE }))
  const exit = TransitionEffect.OPACITY.animation({ duration: 160, curve: Curve.Linear })
    .combine(TransitionEffect.translate({ y: slide })
      .animation({ duration: 160, curve: ACCELERATE_CURVE }))
  return TransitionEffect.asymmetric(enter, exit)
}

// 蒙层淡入淡出（原版 backgroundDimAmount 随窗口 animation 同步：style n = 0.4，菜单 = 0.2）
// 原版 dim 由窗口 alpha 变化驱动，同窗口动画一样是线性，故显式 Curve.Linear。
export function dimTransition(duration: number): TransitionEffect {
  return TransitionEffect.OPACITY.animation({ duration, curve: Curve.Linear })
}

// 原版 anim/f、g、h、i：页面左右平移，时长 integer/b=220，插值器 accelerate_decelerate。
// 资源值（r/a/f..i.xml 解码）：fraction/a=100%、fraction/c=-30%、integer/b=220
//   f: translate fromXDelta=+100% → 0   （从右侧推入）
//   g: translate fromXDelta=0 → -30%    （旧页向左让位 30%）
//   h: translate fromXDelta=-30% → 0    （返回时旧页从 -30% 回到 0）
//   i: translate fromXDelta=0 → +100%   （退出页向右移出）
// 调用点 g6/i.java:67 = .v(f13638c, f13639d, f13640e, f13641f)
//   = .v(anim/f, anim/g, anim/h, anim/i) —— enter, exit, popEnter, popExit
// 落地方式：页面推入转场由 view/PageTransitions.ets 的 buildNavSlide() 通过
//   NavDestination.customTransition 驱动（58 个子页已全部接入），此处不再提供
//   TransitionEffect 版本的 slidePage* —— 旧实现无调用点，已删除以免误用。

// anim/c 淡入 / anim/d 淡出：均为 integer/a=240，xml 无 interpolator → 线性 alpha
export function fadeInTransition(): TransitionEffect {
  return TransitionEffect.OPACITY.animation({ duration: 240, curve: Curve.Linear })
}

// anim/d（alpha 1→0，240ms 线性）：供需要显式淡出的调用方使用
export function fadeOutTransition(): TransitionEffect {
  return TransitionEffect.OPACITY.animation({ duration: 240, curve: Curve.Linear })
}

// AOSP DecelerateInterpolator：1 - (1-t)^2
function decelerateValue(t: number): number {
  const v = 1.0 - t
  return 1.0 - v * v
}

export const DECELERATE_CURVE: ICurve = curves.customCurve((t: number): number => decelerateValue(t))

