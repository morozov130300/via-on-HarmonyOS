import { curves } from '@kit.ArkUI'

// 原版 Via 7.4.0 窗口动画复刻（r/a/*.xml + styles.xml + integers.xml）
// - 弹窗 anim/a、anim/b（style k，用于 style n 弹窗主题）：240ms（integer/a=240），
//   alpha 线性淡入淡出 + translateY 10% + 底部中心缩放 0.9↔1，translate/scale 用 bounce 插值
// - 菜单（i8/k.T1，dimAmount 0.2）：底部 gravity=80 用 style r（anim/k 进：alpha 线性 0→1 +
//   translateY -120px→0 accelerate；anim/n 出：alpha 线性 1→0 + translateY 0→-120px accelerate），
//   顶部 gravity=48 用 style q（anim/m 进：+120px→0；anim/l 出：0→+120px），均 160ms（integer/d）

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

// AOSP AccelerateInterpolator（factor=1.0）逐帧复刻（anim/k、l、m、n 的插值器）
function accelerateValue(t: number): number {
  return t * t
}

const BOUNCE_CURVE: ICurve = curves.customCurve((t: number): number => bounceValue(t))
const ACCELERATE_CURVE: ICurve = curves.customCurve((t: number): number => accelerateValue(t))

// 原版 anim/k、l、m、n 的 fromYDelta/toYDelta = ±120px（px 单位，运行时按屏幕密度换算 vp）
function menuSlideVp(): number {
  try {
    return px2vp(120)
  } catch (error) {
    return 40
  }
}

// 原版弹窗窗口动画（anim/a 进场 = anim/b 退场反向）
export function dialogTransition(): TransitionEffect {
  return TransitionEffect.OPACITY.animation({ duration: 240 })
    .combine(TransitionEffect.translate({ y: '10%' }).animation({ duration: 240, curve: BOUNCE_CURVE }))
    .combine(TransitionEffect.scale({ x: 0.9, y: 0.9, centerX: '50%', centerY: '100%' })
      .animation({ duration: 240, curve: BOUNCE_CURVE }))
}

// 原版底部菜单窗口动画（i8/k.T1 gravity=80 → style r）：
// anim/k 进场（alpha 线性 0→1 + translateY -120px→0，translate accelerate）160ms，
// anim/n 退场（alpha 线性 1→0 + translateY 0→-120px，translate accelerate）160ms
export function menuTransition(): TransitionEffect {
  const slide = menuSlideVp()
  const enter = TransitionEffect.OPACITY.animation({ duration: 160 })
    .combine(TransitionEffect.translate({ y: -slide })
      .animation({ duration: 160, curve: ACCELERATE_CURVE }))
  const exit = TransitionEffect.OPACITY.animation({ duration: 160 })
    .combine(TransitionEffect.translate({ y: -slide })
      .animation({ duration: 160, curve: ACCELERATE_CURVE }))
  return TransitionEffect.asymmetric(enter, exit)
}

// 原版顶部菜单窗口动画（i8/k.T1 gravity=48 → style q）：
// anim/m 进场（alpha 线性 0→1 + translateY +120px→0，translate accelerate）160ms，
// anim/l 退场（alpha 线性 1→0 + translateY 0→+120px，translate accelerate）160ms
export function menuTransitionTop(): TransitionEffect {
  const slide = menuSlideVp()
  const enter = TransitionEffect.OPACITY.animation({ duration: 160 })
    .combine(TransitionEffect.translate({ y: slide })
      .animation({ duration: 160, curve: ACCELERATE_CURVE }))
  const exit = TransitionEffect.OPACITY.animation({ duration: 160 })
    .combine(TransitionEffect.translate({ y: slide })
      .animation({ duration: 160, curve: ACCELERATE_CURVE }))
  return TransitionEffect.asymmetric(enter, exit)
}

// 弹窗/菜单蒙层淡入淡出（原版 backgroundDim 随窗口动画时长渐变）
export function dimTransition(duration: number): TransitionEffect {
  return TransitionEffect.OPACITY.animation({ duration })
}
