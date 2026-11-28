import { common } from '@kit.AbilityKit'
import { TabItem } from './Types'
import { AppSettings } from './Settings'
import { parseHomeCss } from './HomeCss'

// 原版 k6.Z7「change color」：工具栏/地址栏按背景亮度二分支，图标与文字各一套色。
//   g6.y.C(int) = (r*0.299 + g*0.587 + b*0.114) >= 192 → 亮背景
//   zD（夜间）    → 图标 #9f9f9f、文字 #beffffff
//   z12（亮背景） → 图标 #232323、文字 #de000000
//   其余（暗背景）→ 图标白、文字白
//
// 入参一律用已解析的 #RRGGBB 字符串，不传 Resource：
// Resource 在不同 colorMode 下解析结果不同，运行时取色会与页面实际底色错位（曾导致深底黑图标）。
export function parseHexColor(hex: string): number {
  let value: string = hex.trim()
  if (value.startsWith('#')) {
    value = value.substring(1)
  }
  if (value.length === 3) {
    value = `${value[0]}${value[0]}${value[1]}${value[1]}${value[2]}${value[2]}`
  }
  if (value.length === 8) {
    value = value.substring(2)
  }
  if (value.length !== 6) {
    return 0xFFFFFF
  }
  return parseInt(value, 16)
}

export function luminanceOf(hex: string): number {
  const color: number = parseHexColor(hex)
  const red: number = (color >>> 16) & 255
  const green: number = (color >>> 8) & 255
  const blue: number = color & 255
  return red * 0.299 + green * 0.587 + blue * 0.114
}

export function chromeIconColor(background: string, night: boolean): ResourceColor {
  if (night) {
    return '#9f9f9f'
  }
  return luminanceOf(background) >= 192 ? '#232323' : '#FFFFFF'
}

export function chromeTextColor(background: string, night: boolean): ResourceColor {
  if (night) {
    return '#beffffff'
  }
  return luminanceOf(background) >= 192 ? '#de000000' : '#FFFFFF'
}

// 把 ResourceColor（#RRGGBB 字符串 / 数字 / Resource 引用）按当前应用 colorMode 解析成 #RRGGBB。
// Resource 在不同 colorMode 下解析结果不同：夜间关 + 系统深色时 home_bg 解析为深色，
// 若当作浅色会算出深色图标叠深底（顶栏图标不可见）。与 Toolbar.resolveResourceHex 同口径。
export function resolveColorHex(color: ResourceColor, context: common.UIAbilityContext): string {
  if (typeof color === 'string') {
    return color
  }
  if (typeof color === 'number') {
    const to2 = (v: number): string => v.toString(16).padStart(2, '0')
    return `#${to2((color >>> 16) & 255)}${to2((color >>> 8) & 255)}${to2(color & 255)}`
  }
  try {
    // FAQ faqs-arkui-354：传完整 Resource 不按深浅色限定词解析，传 res.id 才会
    const argb: number = context.resourceManager.getColorSync((color as Resource).id)
    const to2 = (v: number): string => v.toString(16).padStart(2, '0')
    return `#${to2((argb >>> 16) & 255)}${to2((argb >>> 8) & 255)}${to2(argb & 255)}`
  } catch (error) {
    return '#FFFFFF'
  }
}

// 原版 k6.Z7 的 z13&&zB9 分支（k6.java:6626-6631）：主页设置了自定义背景图
// （bginfo bit7，i9/a.java:22）时，底栏容器 f2600w0 与搜索工具栏 B0 背景
// setBackgroundColor(0) 全透明，主页壁纸从工具栏底下透出；其余情况实色。
// 工程口径：homeBgImage 或自定义 CSS 的 body/html/#content 背景图（与 Index
// 壁纸渲染条件一致）。CSS 背景图属工程近似，原版仅背景图置 bit7。
export function homeWallpaperThrough(tab: TabItem, settings: AppSettings): boolean {
  // 原版 k6.b5 窗口待定标签（target=_blank）目标页落定前不按主页呈现，
  // 壁纸透出分支同样不放行，否则新开标签跳转前整屏闪主页壁纸。
  if (tab.pendingWindow) {
    return false
  }
  if (!tab.isHomePage()) {
    return false
  }
  if (settings.homeBgImage !== '') {
    return true
  }
  return parseHomeCss(settings.customCss).urlValue(['body', 'html', '#content']) !== ''
}

// 原版 k6.Nb()：网页 theme-color 规范化为 ArkUI 可用的 #RRGGBB，无法解析返回空串
export function normalizeThemeColor(raw: string): string {
  const s: string = raw.trim()
  if (s === '') {
    return ''
  }
  if (s.startsWith('#')) {
    if (s.length === 4) {
      return `#${s[1]}${s[1]}${s[2]}${s[2]}${s[3]}${s[3]}`
    }
    if (s.length === 7 || s.length === 9) {
      return s
    }
    return ''
  }
  const matched: RegExpMatchArray | null = s.match(/^rgba?\(([^)]+)\)$/i)
  if (matched === null) {
    return ''
  }
  const parts: string[] = matched[1].split(',')
  if (parts.length < 3) {
    return ''
  }
  const r: number = Math.round(Number(parts[0].trim()))
  const g: number = Math.round(Number(parts[1].trim()))
  const b: number = Math.round(Number(parts[2].trim()))
  if (isNaN(r) || isNaN(g) || isNaN(b)) {
    return ''
  }
  let hex: string = '#'
  hex += Math.min(255, Math.max(0, r)).toString(16).padStart(2, '0')
  hex += Math.min(255, Math.max(0, g)).toString(16).padStart(2, '0')
  hex += Math.min(255, Math.max(0, b)).toString(16).padStart(2, '0')
  return hex
}

// 原版 k6.Nb()/g0：工具栏底色（含网页 theme-color 自适应、主页自设背景色夜间联动）。
// 抽成公共函数供 Toolbar / 顶栏地址栏 / Index 底栏容器共用 —— 原版 Z7 一次算色统一分发。
export function toolbarBackgroundColor(tab: TabItem, settings: AppSettings): ResourceColor {
  if (settings.toolbarColorAdapt && !settings.isNightActive()) {
    const themed: string = normalizeThemeColor(tab.themeColor)
    if (themed !== '') {
      return themed
    }
  }
  // pendingWindow 标签（target=_blank）目标页落定前不按主页呈现自设背景色
  if (tab.isHomePage() && !tab.pendingWindow && settings.homeBgColor !== '') {
    return settings.nightBlend(settings.homeBgColor)
  }
  return $r('app.color.home_bg')
}

// 原版 k6.Z7 的 z12 判定（6560-6570）+ Nb 分发：系统栏内容明暗与工具栏图标同一来源——
// 夜间(zD) → 白色内容；否则对工具栏实际背景（theme-color 自适应/主页自设背景/默认
// home_bg）判亮度，>=192 → 深色内容（l3.p appearance 8），否则白色内容。
// 主页自设背景原版用 bginfo bit8（背景偏亮标志）判定；本端对 nightBlend 后的色值判
// 亮度等价——夜间已被 isNightActive 拦截，非夜间 nightBlend 原样返回原始色。
// tab undefined（tabStore 未初始化，启动极早期）按默认 home_bg 资源色判定，与窗口
// 底色（applyWindowBackgroundColor 同资源）保持一致。
export function systemBarDarkContent(tab: TabItem | undefined, settings: AppSettings,
  context: common.UIAbilityContext): boolean {
  if (settings.isNightActive()) {
    return false
  }
  const bg: ResourceColor = tab === undefined
    ? $r('app.color.home_bg')
    : toolbarBackgroundColor(tab, settings)
  // 主页无 theme-color 且自设背景为空时 toolbarBackgroundColor 也返回 home_bg 资源，
  // resolveColorHex 统一按当前 colorMode 解析（深色资源夜间态已在上方拦截）
  return luminanceOf(resolveColorHex(bg, context)) >= 192
}
