import { cryptoFramework } from '@kit.CryptoArchitectureKit'
import { util } from '@kit.ArkTS'
// 首页定制样式的唯一数据源：首页与定制页共用，保证两边永远一致。
// 数值型参数（px/百分比）与原版录屏一致，由定制页的主题色导轨滑杆连续调节。

// 背景色板（原版 APK dex 内 22 个具名颜色，顺序与原版一致）
export const HOME_BG_COLORS: string[] = [
  '#2B78C9', '#353E4D', '#8A6553', '#C07B40', '#E2B482', '#4C4C4C', '#C54748',
  '#F8A246', '#FEC849', '#B4BE74', '#6AC4C4', '#616FBA', '#9B66AA', '#CB9E67',
  '#9B9FAB', '#694D35', '#983933', '#D98E88', '#DFA14F', '#5B5A3B', '#BBA188', '#5C5066'
]
// 主题色板（背景图片模式下，与背景色板同源同序）
export const HOME_THEME_COLORS: string[] = [
  '#2B78C9', '#353E4D', '#8A6553', '#C07B40', '#E2B482', '#4C4C4C', '#C54748',
  '#F8A246', '#FEC849', '#B4BE74', '#6AC4C4', '#616FBA', '#9B66AA', '#CB9E67',
  '#9B9FAB', '#694D35', '#983933', '#D98E88', '#DFA14F', '#5B5A3B', '#BBA188', '#5C5066'
]

// Logo 类型：0 默认图标 1 图片 2 文字 3 HTML 代码 4 无（视频 3s 单选弹窗）
export const HOME_LOGO_TYPES: string[] = ['默认', '图片', '文字', 'HTML 代码', '无']
// 字体风格（视频 15-16s：粗体 斜体 循环切换）
export const HOME_LOGO_STYLES: string[] = ['常规', '粗体', '斜体', '粗体 斜体']

// Logo 文字色（原版 CSS .logo：浅色 #afafaf / 深色 #fafafa，走 app.color.home_text）
// Logo 尺寸滑杆范围（px），0 表示自适应
export const HOME_DIM_MIN: number = 10
export const HOME_DIM_MAX: number = 127
export const HOME_LOGO_FONT_MIN: number = 10
export const HOME_LOGO_FONT_MAX: number = 63

// 搜索框样式：0 矩形 1 线条（视频 54-58s）
export const HOME_PILL_STYLES: string[] = ['矩形', '线条']
export const HOME_PILL_HEIGHT: number = 46
// 描边粗细滑杆范围（px）
export const HOME_STROKE_MAX: number = 7
// 百分比滑杆范围
export const HOME_PCT_MIN: number = 0
export const HOME_PCT_MAX: number = 100

// 收藏图标：阴影风格（原版 i9.c：多彩=按网址派生底色，透明=无底色灰字）
export const HOME_FAV_ICON_STYLES: string[] = ['图标优先', '文字']
export const HOME_FAV_SHADOWS: string[] = ['多彩', '透明']


// 原版 r8.d.k()/m()：多彩底色由网址 MD5 派生，非色板——
// h = md5(url)，R=90+h[0:3]%128，G=90+h[len/2-3:len/2]%128，B=90+h[len-3:]%128
export async function homeFavColor(url: string): Promise<string> {
  const encoder = new util.TextEncoder()
  const bytes = encoder.encodeInto(url)
  const md = cryptoFramework.createMd('MD5')
  await md.update({ data: bytes })
  const digest = await md.digest()
  let h = ''
  for (const b of digest.data) {
    h += (b < 16 ? '0' : '') + b.toString(16)
  }
  const r = 90 + parseInt(h.substring(0, 3), 16) % 128
  const g = 90 + parseInt(h.substring(h.length / 2 - 3, h.length / 2), 16) % 128
  const b2 = 90 + parseInt(h.substring(h.length - 3), 16) % 128
  return `rgb(${r},${g},${b2})`
}

// 高级：搜索框效果（透明/模糊）、搜索区域（提示/隐藏）
export const HOME_ADV_EFFECTS: string[] = ['透明', '模糊']
export const HOME_ADV_AREAS: string[] = ['展示', '隐藏']

// 清除网站图标缓存确认弹窗文案（视频 116s）
export const HOME_CLEAR_ICON_TITLE: string = '清除网站图标缓存'
export const HOME_CLEAR_ICON_DESC: string = '请注意，这会清除所有主页收藏的图标。图标会在你下次访问该网站时下载。'
// 重置确认弹窗文案（视频 125s）
export const HOME_RESET_TITLE: string = '重置为默认设置'
export const HOME_RESET_DESC: string = '你确定继续吗？'
