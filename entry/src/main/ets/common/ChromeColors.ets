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
