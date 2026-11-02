import { curves } from '@kit.ArkUI'

// 原版 Via 7.4.0 窗口动画复刻（r/a/*.xml + styles.xml + integers.xml）
// - 弹窗 anim/a、anim/b（style k，用于 style n 弹窗主题）：240ms（integer/a=240），
//   alpha 线性淡入淡出 + translateY 10% + 底部中心缩放 0.9↔1，translate/scale 用 bounce 插值
// - 菜单 anim/m（进）、anim/n（出）（style q，底部菜单窗口）：160ms（integer/d=160），
//   alpha 线性淡入淡出 + translateY ±120dp，translate 用 anticipate_overshoot 插值（0x010a0005）

// AOSP BounceInterpolator.getInterpolation 逐帧复刻
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

// AOSP AccelerateInterpolator（factor=1.0）逐帧复刻
function accelerateValue(t: number): number {
  return t * t
}

// AOSP AnticipateOvershootInterpolator（默认构造 tension = 2.0 * 1.5）逐帧复刻
// anim m/l/n 的 android:interpolator = @android:interpolator/anticipate_overshoot（0x010a0005）
function anticipateOvershootValue(t: number): number {
  const tension = 2.0 * 1.5
  const fn = (x: number): number => x * x * ((tension + 1) * x - tension)
  if (t < 0.5) {
    return 0.5 * fn(t * 2)
  }
  return 0.5 * (fn(t * 2 - 2) + 2)
}

const BOUNCE_CURVE: ICurve = curves.customCurve((t: number): number => bounceValue(t))
const ACCELERATE_CURVE: ICurve = curves.customCurve((t: number): number => accelerateValue(t))
const ANTICIPATE_OVERSHOOT_CURVE: ICurve = curves.customCurve((t: number): number => anticipateOvershootValue(t))

// 原版 anim/m 等的 fromYDelta/toYDelta = ±120dp
const MENU_SLIDE_DP: number = 120

// 原版弹窗窗口动画（anim/a 进场 = anim/b 退场反向）
export function dialogTransition(): TransitionEffect {
  return TransitionEffect.OPACITY.animation({ duration: 240 })
    .combine(TransitionEffect.translate({ y: '10%' }).animation({ duration: 240, curve: BOUNCE_CURVE }))
    .combine(TransitionEffect.scale({ x: 0.9, y: 0.9, centerX: '50%', centerY: '100%' })
      .animation({ duration: 240, curve: BOUNCE_CURVE }))
}

// 原版底部菜单窗口动画（style q）：anim/m 进场（alpha 0→1 + translateY 120dp→0）、
// anim/n 退场（alpha 1→0 + translateY 0→-120dp），160ms（integer/d），anticipate_overshoot；
// 顶部布局（style r）用 anim/k、anim/l（方向取反），由 gravity 决定
export function menuTransition(): TransitionEffect {
  const enter = TransitionEffect.OPACITY.animation({ duration: 160, curve: ANTICIPATE_OVERSHOOT_CURVE })
    .combine(TransitionEffect.translate({ y: MENU_SLIDE_DP })
      .animation({ duration: 160, curve: ANTICIPATE_OVERSHOOT_CURVE }))
  const exit = TransitionEffect.OPACITY.animation({ duration: 160, curve: ANTICIPATE_OVERSHOOT_CURVE })
    .combine(TransitionEffect.translate({ y: -MENU_SLIDE_DP })
      .animation({ duration: 160, curve: ANTICIPATE_OVERSHOOT_CURVE }))
  return TransitionEffect.asymmetric(enter, exit)
}

// 弹窗/菜单蒙层淡入淡出（原版 backgroundDim 随窗口动画时长渐变）
export function dimTransition(duration: number): TransitionEffect {
  return TransitionEffect.OPACITY.animation({ duration })
}
