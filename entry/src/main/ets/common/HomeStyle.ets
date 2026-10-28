// 首页定制样式的唯一数据源：首页与定制页共用，保证两边永远一致。
// 数值型参数（px/百分比）与原版录屏一致，由定制页的主题色导轨滑杆连续调节。

// 背景色板（视频 71-80s 底部调色板）
export const HOME_BG_COLORS: string[] = [
  '#F5CBA8', '#3A3F4A', '#C0392B', '#E67E22', '#F1C40F', '#A3C962', '#4ECDC4',
  '#4A69BD', '#9B66AA', '#C8A27A', '#95A5A6', '#6D4C41', '#8E3B3B', '#E8A0A8', '#F5A623'
]
// 主题色板（背景图片模式下，视频 90s）
export const HOME_THEME_COLORS: string[] = [
  '#F5CBA8', '#3A3F4A', '#C0392B', '#E67E22', '#F1C40F', '#A3C962', '#4ECDC4',
  '#4A69BD', '#9B66AA', '#C8A27A', '#95A5A6', '#6D4C41', '#8E3B3B', '#E8A0A8', '#F5A623'
]

// Logo 类型：0 默认图标 1 图片 2 文字 3 HTML 代码 4 无（视频 3s 单选弹窗）
export const HOME_LOGO_TYPES: string[] = ['默认', '图片', '文字', 'HTML 代码', '无']
// 字体风格（视频 15-16s：粗体 斜体 循环切换）
export const HOME_LOGO_STYLES: string[] = ['常规', '粗体', '斜体', '粗体 斜体']

export const HOME_LOGO_COLOR: string = '#FAFAFA'
// Logo 尺寸滑杆范围（px），0 表示自适应
export const HOME_DIM_MIN: number = 40
export const HOME_DIM_MAX: number = 128
export const HOME_LOGO_FONT_MIN: number = 20
export const HOME_LOGO_FONT_MAX: number = 64

// 搜索框样式：0 矩形 1 线条（视频 54-58s）
export const HOME_PILL_STYLES: string[] = ['矩形', '线条']
export const HOME_PILL_HEIGHT: number = 38
// 描边粗细滑杆范围（px）
export const HOME_STROKE_MAX: number = 7
// 百分比滑杆范围
export const HOME_PCT_MIN: number = 0
export const HOME_PCT_MAX: number = 100

// 收藏图标：阴影风格（视频 100-108s：多彩/凄暗）
export const HOME_FAV_ICON_STYLES: string[] = ['图标优先', '文字']
export const HOME_FAV_SHADOWS: string[] = ['多彩', '凄暗']
export const HOME_FAV_PALETTE: string[] = ['#5B8DEF', '#F8A246', '#6AC4C4', '#9B66AA', '#B4BE74']
export const HOME_FAV_DIM_COLOR: string = '#4A4E5C'

// 高级：搜索框效果（透明/模糊）、搜索区域（提示/隐藏）
export const HOME_ADV_EFFECTS: string[] = ['透明', '模糊']
export const HOME_ADV_AREAS: string[] = ['提示', '隐藏']

// 清除网站图标缓存确认弹窗文案（视频 116s）
export const HOME_CLEAR_ICON_TITLE: string = '清除网站图标缓存'
export const HOME_CLEAR_ICON_DESC: string = '请注意，这会清除所有主页收藏的图标。图标将会在你下次访问该网站时下载。'
// 重置确认弹窗文案（视频 125s）
export const HOME_RESET_TITLE: string = '重置为默认设置'
export const HOME_RESET_DESC: string = '你确定继续吗?'
