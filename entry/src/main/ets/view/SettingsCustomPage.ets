// 定制页：与原版录屏逐帧对齐——
// 上方实时预览（HomePage），底部「分类标签行」与「参数条目行」；
// 点数值型条目在条目上方展开主题色导轨滑杆实时调节预览；
// 点选项型条目弹单选弹窗（Logo）或循环切换（样式/风格）；
// 背景色/主题色条目展开调色板；清除图标/重置弹确认框；自定义 CSS 跳独立编辑页。
import { HomePage } from '../components/HomePage'
import { AppSettings } from '../common/Settings'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { AppIcon } from '../components/AppIcon'
import { UiInsets } from '../common/Immersive'
import { picker } from '@kit.CoreFileKit'
import { BusinessError } from '@kit.BasicServicesKit'
import {
  HOME_ADV_AREAS,
  HOME_ADV_EFFECTS,
  HOME_BG_COLORS,
  HOME_CLEAR_ICON_DESC,
  HOME_CLEAR_ICON_TITLE,
  HOME_DIM_MAX,
  HOME_DIM_MIN,
  HOME_FAV_ICON_STYLES,
  HOME_FAV_SHADOWS,
  HOME_LOGO_FONT_MAX,
  HOME_LOGO_FONT_MIN,
  HOME_LOGO_STYLES,
  HOME_LOGO_TYPES,
  HOME_PCT_MAX,
  HOME_PCT_MIN,
  HOME_PILL_STYLES,
  HOME_RESET_DESC,
  HOME_RESET_TITLE,
  HOME_STROKE_MAX,
  HOME_THEME_COLORS
} from '../common/HomeStyle'

const KIND_SLIDER: string = 'slider'
const KIND_ACTION: string = 'action'

class CustomParam {
  id: string
  icon: Resource
  label: string
  kind: string
  min: number = 0
  max: number = 100
  unit: string = ''
  zeroLabel: string = ''

  constructor(id: string, icon: Resource, label: string, kind: string) {
    this.id = id
    this.icon = icon
    this.label = label
    this.kind = kind
  }
}

@ComponentV2
export struct SettingsCustomPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  private insets: UiInsets = UiInsets.getInstance()
  @Local activeTab: number = 0
  @Local activeSlider: string = ''
  @Local sliderPos: number = 0
  @Local paletteKey: string = ''
  @Local logoDialogShow: boolean = false
  @Local confirmKind: string = ''
  @Local textDraft: string = ''
  private textKind: string = ''

  private tabs: string[] = ['Logo', '搜索框', '背景', '收藏', '高级']

  private bindAppBar(): void {
    AppBar.show({
      title: '定制',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Column() {
          HomePage({ onSearchTap: () => {
          } })
        }
        .width('100%')
        .layoutWeight(1)

        this.SliderRail()
        if (this.paletteKey !== '') {
          this.PaletteRow()
        } else {
          this.ParamStrip()
        }
        this.TabBar()
      }
      .width('100%')
      .height('100%')

      if (this.logoDialogShow) {
        this.LogoTypeDialog()
      }
      if (this.confirmKind !== '') {
        this.ConfirmDialog()
      }
      if (this.textKind !== '') {
        this.TextInputDialog()
      }
    }
    .backgroundColor($r('app.color.page_bg'))
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  // ---------- 分类条目 ----------

  private logoParams(): CustomParam[] {
    const params: CustomParam[] = []
    const logoType = new CustomParam('logo_type', $r('app.media.via_ic_c_logo_text'), 'Logo', KIND_ACTION)
    params.push(logoType)
    params.push(this.dimParam('logo_width', $r('app.media.via_ic_c_fav_width'), '宽度', this.settings.homeLogoWidth))
    params.push(this.dimParam('logo_height', $r('app.media.via_ic_c_fav_height'), '高度', this.settings.homeLogoHeight))
    params.push(this.pctParam('logo_corner', $r('app.media.via_ic_c_fav_corner'), '圆角值', this.settings.homeLogoCorner))
    if (HOME_LOGO_TYPES[this.settings.homeLogoType] === '文字') {
      const font = new CustomParam('logo_font', $r('app.media.via_ic_c_font_size'), '字体大小', KIND_SLIDER)
      font.min = HOME_LOGO_FONT_MIN
      font.max = HOME_LOGO_FONT_MAX
      font.unit = 'px'
      params.push(font)
      params.push(new CustomParam('logo_style', $r('app.media.via_ic_c_font_style'), '字体风格', KIND_ACTION))
    }
    return params
  }

  private dimParam(id: string, icon: Resource, label: string, _value: number): CustomParam {
    const param = new CustomParam(id, icon, label, KIND_SLIDER)
    param.min = HOME_DIM_MIN
    param.max = HOME_DIM_MAX
    param.unit = 'px'
    param.zeroLabel = '自适应'
    return param
  }

  private pctParam(id: string, icon: Resource, label: string, _value: number): CustomParam {
    const param = new CustomParam(id, icon, label, KIND_SLIDER)
    param.min = HOME_PCT_MIN
    param.max = HOME_PCT_MAX
    param.unit = '%'
    return param
  }

  private searchParams(): CustomParam[] {
    const params: CustomParam[] = []
    params.push(this.pctParam('pill_corner', $r('app.media.via_ic_c_corner'), '圆角值', this.settings.homePillCorner))
    params.push(this.pctParam('pill_opacity', $r('app.media.via_ic_c_opacity'), '不透明度', this.settings.homePillOpacity))
    const stroke = new CustomParam('pill_stroke_w', $r('app.media.via_ic_c_stroke_width'), '描边粗细', KIND_SLIDER)
    stroke.min = 0
    stroke.max = HOME_STROKE_MAX
    stroke.unit = 'px'
    params.push(stroke)
    params.push(this.pctParam('pill_stroke_o', $r('app.media.via_ic_c_stroke_opacity'), '描边不透明度', this.settings.homePillStrokeOpacity))
    params.push(new CustomParam('pill_style', $r('app.media.via_ic_c_search_style'), '搜索框样式', KIND_ACTION))
    return params
  }

  private bgParams(): CustomParam[] {
    const params: CustomParam[] = []
    params.push(new CustomParam('bg_color', $r('app.media.via_ic_c_opacity'), '背景色', KIND_ACTION))
    params.push(new CustomParam('bg_image', $r('app.media.via_ic_c_adv_area'), '背景图片', KIND_ACTION))
    params.push(new CustomParam('theme_color', $r('app.media.via_ic_c_fav_icon_color'), '主题色', KIND_ACTION))
    params.push(this.pctParam('bg_opacity', $r('app.media.via_ic_c_opacity'), '不透明度', this.settings.homeBgOpacity))
    return params
  }

  private favParams(): CustomParam[] {
    const params: CustomParam[] = []
    params.push(this.dimParam('fav_width', $r('app.media.via_ic_c_fav_width'), '宽度', this.settings.homeFavWidth))
    params.push(this.dimParam('fav_height', $r('app.media.via_ic_c_fav_height'), '高度', this.settings.homeFavHeight))
    params.push(this.pctParam('fav_corner', $r('app.media.via_ic_c_fav_corner'), '圆角值', this.settings.homeFavCorner))
    params.push(new CustomParam('fav_icon_style', $r('app.media.via_ic_c_fav_icon_style'), '图标样式', KIND_ACTION))
    params.push(new CustomParam('fav_shadow', $r('app.media.via_ic_c_fav_icon_color'), '图标阴影', KIND_ACTION))
    return params
  }

  private advParams(): CustomParam[] {
    const params: CustomParam[] = []
    params.push(new CustomParam('adv_effect', $r('app.media.via_ic_c_adv_effect'), '搜索框效果', KIND_ACTION))
    params.push(new CustomParam('adv_area', $r('app.media.via_ic_c_adv_area'), '搜索区域', KIND_ACTION))
    params.push(new CustomParam('adv_css', $r('app.media.via_ic_c_adv_css'), '自定义 CSS', KIND_ACTION))
    params.push(new CustomParam('adv_clear', $r('app.media.via_ic_c_clear_icon'), '清除图标', KIND_ACTION))
    params.push(new CustomParam('adv_reset', $r('app.media.via_ic_c_reset'), '重置', KIND_ACTION))
    return params
  }

  private currentParams(): CustomParam[] {
    if (this.activeTab === 0) {
      return this.logoParams()
    }
    if (this.activeTab === 1) {
      return this.searchParams()
    }
    if (this.activeTab === 2) {
      return this.bgParams()
    }
    if (this.activeTab === 3) {
      return this.favParams()
    }
    return this.advParams()
  }

  private paramValue(param: CustomParam): string {
    switch (param.id) {
      case 'logo_type':
        return HOME_LOGO_TYPES[this.settings.homeLogoType]
      case 'logo_width':
        return this.settings.homeLogoWidth === 0 ? '自适应' : `${this.settings.homeLogoWidth}px`
      case 'logo_height':
        return this.settings.homeLogoHeight === 0 ? '自适应' : `${this.settings.homeLogoHeight}px`
      case 'logo_corner':
        return `${this.settings.homeLogoCorner}%`
      case 'logo_font':
        return `${this.settings.homeLogoSize}px`
      case 'logo_style':
        return HOME_LOGO_STYLES[this.settings.homeLogoStyle]
      case 'pill_corner':
        return `${this.settings.homePillCorner}%`
      case 'pill_opacity':
        return `${this.settings.homePillOpacity}%`
      case 'pill_stroke_w':
        return `${this.settings.homePillStrokeWidth}px`
      case 'pill_stroke_o':
        return `${this.settings.homePillStrokeOpacity}%`
      case 'pill_style':
        return HOME_PILL_STYLES[this.settings.homePillStyle]
      case 'bg_color':
        return this.settings.homeBgColor === '' && this.settings.homeBgImage === '' ? '默认' : '自定义'
      case 'bg_image':
        return this.settings.homeBgImage === '' ? '颜色' : '图片'
      case 'theme_color':
        return this.settings.homeThemeColor === '' ? '哑色' : '自定义'
      case 'bg_opacity':
        return `${this.settings.homeBgOpacity}%`
      case 'fav_width':
        return this.settings.homeFavWidth === 0 ? '自适应' : `${this.settings.homeFavWidth}px`
      case 'fav_height':
        return this.settings.homeFavHeight === 0 ? '自适应' : `${this.settings.homeFavHeight}px`
      case 'fav_corner':
        return `${this.settings.homeFavCorner}%`
      case 'fav_icon_style':
        return HOME_FAV_ICON_STYLES[this.settings.homeFavIconStyle]
      case 'fav_shadow':
        return HOME_FAV_SHADOWS[this.settings.homeFavShadow]
      case 'adv_effect':
        return HOME_ADV_EFFECTS[this.settings.homeAdvEffect]
      case 'adv_area':
        return HOME_ADV_AREAS[this.settings.homeAdvArea]
      default:
        return ''
    }
  }

  private sliderValueOf(param: CustomParam): number {
    switch (param.id) {
      case 'logo_width':
        return this.settings.homeLogoWidth === 0 ? 72 : this.settings.homeLogoWidth
      case 'logo_height':
        return this.settings.homeLogoHeight === 0 ? 72 : this.settings.homeLogoHeight
      case 'logo_corner':
        return this.settings.homeLogoCorner
      case 'logo_font':
        return this.settings.homeLogoSize
      case 'pill_corner':
        return this.settings.homePillCorner
      case 'pill_opacity':
        return this.settings.homePillOpacity
      case 'pill_stroke_w':
        return this.settings.homePillStrokeWidth
      case 'pill_stroke_o':
        return this.settings.homePillStrokeOpacity
      case 'bg_opacity':
        return this.settings.homeBgOpacity
      case 'fav_width':
        return this.settings.homeFavWidth === 0 ? 49 : this.settings.homeFavWidth
      case 'fav_height':
        return this.settings.homeFavHeight === 0 ? 59 : this.settings.homeFavHeight
      case 'fav_corner':
        return this.settings.homeFavCorner
      default:
        return 0
    }
  }

  private applySlider(id: string, value: number): void {
    const v = Math.round(value)
    switch (id) {
      case 'logo_width':
        this.settings.setHomeLogoWidth(v)
        break
      case 'logo_height':
        this.settings.setHomeLogoHeight(v)
        break
      case 'logo_corner':
        this.settings.setHomeLogoCorner(v)
        break
      case 'logo_font':
        this.settings.setHomeLogoSize(v)
        break
      case 'pill_corner':
        this.settings.setHomePillCorner(v)
        break
      case 'pill_opacity':
        this.settings.setHomePillOpacity(v)
        break
      case 'pill_stroke_w':
        this.settings.setHomePillStrokeWidth(v)
        break
      case 'pill_stroke_o':
        this.settings.setHomePillStrokeOpacity(v)
        break
      case 'bg_opacity':
        this.settings.setHomeBgOpacity(v)
        break
      case 'fav_width':
        this.settings.setHomeFavWidth(v)
        break
      case 'fav_height':
        this.settings.setHomeFavHeight(v)
        break
      case 'fav_corner':
        this.settings.setHomeFavCorner(v)
        break
      default:
        break
    }
  }

  private onParamTap(param: CustomParam): void {
    this.paletteKey = ''
    if (param.kind === KIND_SLIDER) {
      if (this.activeSlider === param.id) {
        this.activeSlider = ''
        return
      }
      this.activeSlider = param.id
      this.sliderPos = this.sliderValueOf(param)
      return
    }
    this.activeSlider = ''
    switch (param.id) {
      case 'logo_type':
        this.logoDialogShow = true
        break
      case 'logo_style':
        this.settings.setHomeLogoStyle((this.settings.homeLogoStyle + 1) % HOME_LOGO_STYLES.length)
        break
      case 'pill_style':
        this.settings.setHomePillStyle((this.settings.homePillStyle + 1) % HOME_PILL_STYLES.length)
        break
      case 'bg_color':
        this.paletteKey = this.paletteKey === 'bg' ? '' : 'bg'
        break
      case 'theme_color':
        this.paletteKey = this.paletteKey === 'theme' ? '' : 'theme'
        break
      case 'bg_image':
        this.pickImage(false)
        break
      case 'fav_icon_style':
        this.settings.setHomeFavIconStyle((this.settings.homeFavIconStyle + 1) % HOME_FAV_ICON_STYLES.length)
        break
      case 'fav_shadow':
        this.settings.setHomeFavShadow((this.settings.homeFavShadow + 1) % HOME_FAV_SHADOWS.length)
        break
      case 'adv_effect':
        this.settings.setHomeAdvEffect((this.settings.homeAdvEffect + 1) % HOME_ADV_EFFECTS.length)
        break
      case 'adv_area':
        this.settings.setHomeAdvArea((this.settings.homeAdvArea + 1) % HOME_ADV_AREAS.length)
        break
      case 'adv_css':
        this.navPathStack.pushPathByName('homeCss', '', true)
        break
      case 'adv_clear':
        this.confirmKind = 'clear'
        break
      case 'adv_reset':
        this.confirmKind = 'reset'
        break
      default:
        break
    }
  }

  // ---------- 视图 ----------

  // 主题色导轨：选中数值条目后在条目上方展开，拖动实时更新预览。
  // Slider 值走本地双向镜像 sliderPos（构造参数非响应式），展开/切换时从设置同步
  @Builder
  SliderRail() {
    if (this.activeSlider !== '') {
      Column() {
        ForEach(this.currentParams(), (param: CustomParam) => {
          if (param.id === this.activeSlider) {
            Slider({ value: this.sliderPos, min: param.min, max: param.max, step: 1, style: SliderStyle.OutSet })
              .width('96%')
              .trackColor('#4A4E5C')
              .selectedColor($r('app.color.accent'))
              .blockColor($r('app.color.accent'))
              .trackThickness(2)
              .blockSize({ width: 14, height: 14 })
              .onChange((value: number) => {
                this.sliderPos = value
                this.applySlider(param.id, value)
              })
          }
        }, (param: CustomParam) => param.id)
      }
      .width('100%')
      .padding({ top: 8, bottom: 2 })
    }
  }

  @Builder
  ParamStrip() {
    Row({ space: 4 }) {
      ForEach(this.currentParams(), (param: CustomParam) => {
        Column({ space: 5 }) {
          Image(param.icon)
            .height(22)
            .width(26)
            .objectFit(ImageFit.Contain)
            .fillColor($r('app.color.fg'))
          Text(param.label)
            .fontSize(11)
            .fontColor(this.activeSlider === param.id ? $r('app.color.accent') : $r('app.color.fg'))
            .maxLines(1)
          Text(this.paramValue(param))
            .fontSize(10)
            .fontColor(this.activeSlider === param.id ? $r('app.color.accent') : $r('app.color.fg_secondary'))
            .maxLines(1)
        }
        .layoutWeight(1)
        .padding({ top: 4, bottom: 4 })
        .alignItems(HorizontalAlign.Center)
        .onClick(() => {
          this.onParamTap(param)
        })
      }, (param: CustomParam) => `${param.id}_${this.paramValue(param)}`)
    }
    .width('100%')
    .padding({ left: 6, right: 6 })
  }

  // 背景色/主题色调色板（视频 71-80s）
  @Builder
  PaletteRow() {
    Scroll() {
      Row({ space: 14 }) {
        if (this.paletteKey === 'theme') {
          this.PaletteDot('', '哑色')
        }
        ForEach(this.paletteKey === 'bg' ? HOME_BG_COLORS : HOME_THEME_COLORS, (colorHex: string) => {
          this.PaletteDot(colorHex, colorHex)
        }, (colorHex: string) => colorHex)
      }
      .padding({ left: 16, right: 16 })
    }
    .scrollable(ScrollDirection.Horizontal)
    .width('100%')
    .height(64)
    .align(Alignment.Center)
  }

  @Builder
  PaletteDot(colorHex: string, key: string) {
    Stack() {
      if (this.paletteDotSelected(colorHex, key)) {
        Circle({ width: 40, height: 40 })
          .fill(Color.Transparent)
          .stroke($r('app.color.fg'))
          .strokeWidth(1.5)
      }
      if (colorHex === '') {
        Circle({ width: 30, height: 30 })
          .fill(Color.Transparent)
          .stroke($r('app.color.fg_secondary'))
          .strokeWidth(1)
      } else {
        Circle({ width: 30, height: 30 })
          .fill(colorHex)
      }
    }
    .width(44)
    .height(44)
    .onClick(() => {
      if (this.paletteKey === 'bg') {
        this.settings.setHomeBgColor(colorHex)
        this.settings.setHomeBgImage('')
      } else {
        this.settings.setHomeThemeColor(colorHex)
      }
    })
  }

  private paletteDotSelected(colorHex: string, key: string): boolean {
    if (this.paletteKey === 'bg') {
      return this.settings.homeBgImage === '' && this.settings.homeBgColor === colorHex
    }
    return this.settings.homeThemeColor === colorHex
  }

  @Builder
  TabBar() {
    Row() {
      ForEach(this.tabs, (tab: string, index: number) => {
        Text(tab)
          .fontSize(13)
          .fontColor(this.activeTab === index ? $r('app.color.accent') : $r('app.color.fg_secondary'))
          .layoutWeight(1)
          .textAlign(TextAlign.Center)
          .height(40)
          .onClick(() => {
            this.activeTab = index
            this.activeSlider = ''
            this.paletteKey = ''
          })
      }, (tab: string) => tab)
    }
    .width('100%')
    .height(44)
    .padding({ bottom: this.insets.bottom > 0 ? 0 : 4 })
  }

  // ---------- 弹窗 ----------

  // Logo 单选弹窗（视频 3s：默认/图片/文字/HTML 代码/无，左侧单选圆点）
  @Builder
  LogoTypeDialog() {
    Stack({ alignContent: Alignment.Center }) {
      Column() {
        Text('Logo')
          .fontSize(15)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.fg'))
          .width('100%')
          .padding({ left: 18, top: 16, bottom: 6 })
        ForEach(HOME_LOGO_TYPES, (label: string, index: number) => {
          Row({ space: 12 }) {
            Circle({ width: 16, height: 16 })
              .fill(this.settings.homeLogoType === index ? $r('app.color.accent') : Color.Transparent)
              .stroke(this.settings.homeLogoType === index ? $r('app.color.accent') : $r('app.color.fg_secondary'))
              .strokeWidth(1.5)
            Text(label)
              .fontSize(14)
              .fontColor($r('app.color.fg'))
          }
          .width('100%')
          .height(38)
          .padding({ left: 18, right: 18 })
          .onClick(() => {
            this.settings.setHomeLogoType(index)
            this.logoDialogShow = false
            if (label === '图片') {
              this.pickImage(true)
            } else if (label === '文字') {
              this.openTextInput('text')
            } else if (label === 'HTML 代码') {
              this.openTextInput('html')
            }
          })
        }, (label: string) => label)
      }
      .width('46%')
      .constraintSize({ minWidth: 220 })
      .borderRadius(14)
      .backgroundColor($r('app.color.menu_bg'))
      .padding({ top: 4, bottom: 8 })
      .shadow({ radius: 24, color: 'rgba(0,0,0,0.5)', offsetY: 4 })
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.35)')
    .onClick(() => {
      this.logoDialogShow = false
    })
  }

  // 文字 / HTML 代码输入弹窗（视频 8-10s）
  @Builder
  TextInputDialog() {
    Stack({ alignContent: Alignment.Center }) {
      Column({ space: 12 }) {
        Text(this.textKind === 'html' ? 'HTML 代码' : '文字')
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .width('100%')
        TextArea({ text: this.textDraft })
          .fontSize(14)
          .height(this.textKind === 'html' ? 110 : 70)
          .backgroundColor(Color.Transparent)
          .fontColor($r('app.color.fg'))
          .caretColor($r('app.color.accent'))
          .padding(0)
          .onChange((value: string) => {
            this.textDraft = value
          })
        Row({ space: 24 }) {
          Blank()
          Text('取消')
            .fontSize(14)
            .fontColor($r('app.color.accent'))
            .onClick(() => {
              this.textKind = ''
            })
          Text('确定')
            .fontSize(14)
            .fontColor($r('app.color.accent'))
            .onClick(() => {
              if (this.textKind === 'html') {
                this.settings.setHomeLogoHtml(this.textDraft)
                this.settings.setHomeLogoType(3)
              } else {
                this.settings.setHomeLogoText(this.textDraft)
                this.settings.setHomeLogoType(2)
              }
              this.textKind = ''
            })
        }
        .width('100%')
      }
      .width('60%')
      .constraintSize({ minWidth: 280 })
      .padding(16)
      .borderRadius(14)
      .backgroundColor($r('app.color.menu_bg'))
      .shadow({ radius: 24, color: 'rgba(0,0,0,0.5)', offsetY: 4 })
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.35)')
    .onClick(() => {
      this.textKind = ''
    })
  }

  // 确认弹窗：清除网站图标缓存 / 重置为默认设置（视频 116s / 125s）
  @Builder
  ConfirmDialog() {
    Stack({ alignContent: Alignment.Center }) {
      Column({ space: 12 }) {
        Text(this.confirmKind === 'clear' ? HOME_CLEAR_ICON_TITLE : HOME_RESET_TITLE)
          .fontSize(15)
          .fontColor($r('app.color.fg'))
          .width('100%')
        Text(this.confirmKind === 'clear' ? HOME_CLEAR_ICON_DESC : HOME_RESET_DESC)
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .width('100%')
        Row({ space: 24 }) {
          Blank()
          Text('取消')
            .fontSize(14)
            .fontColor($r('app.color.accent'))
            .onClick(() => {
              this.confirmKind = ''
            })
          Text('确定')
            .fontSize(14)
            .fontColor($r('app.color.accent'))
            .onClick(() => {
              if (this.confirmKind === 'clear') {
                this.settings.bumpIconEpoch()
                this.getUIContext().getPromptAction().showToast({ message: $r('app.string.cleared'), duration: 1500 })
              } else {
                this.settings.resetHomeStyle()
              }
              this.confirmKind = ''
              this.activeSlider = ''
              this.paletteKey = ''
            })
        }
        .width('100%')
      }
      .width('52%')
      .constraintSize({ minWidth: 260 })
      .padding(16)
      .borderRadius(14)
      .backgroundColor($r('app.color.menu_bg'))
      .shadow({ radius: 24, color: 'rgba(0,0,0,0.5)', offsetY: 4 })
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.35)')
    .onClick(() => {
      this.confirmKind = ''
    })
  }

  private openTextInput(kind: string): void {
    this.textDraft = kind === 'html' ? this.settings.homeLogoHtml : this.settings.homeLogoText
    this.textKind = kind
  }

  private pickImage(isLogo: boolean): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    try {
      const photoPicker = new picker.PhotoViewPicker(context)
      photoPicker.select({
        MIMEType: picker.PhotoViewMIMETypes.IMAGE_TYPE,
        maxSelectNumber: 1
      }).then((result: picker.PhotoSelectResult) => {
        if (result.photoUris.length > 0) {
          if (isLogo) {
            this.settings.setHomeLogoImage(result.photoUris[0])
          } else {
            this.settings.setHomeBgColor('')
            this.settings.setHomeBgImage(result.photoUris[0])
          }
        }
      }).catch((error: BusinessError) => {
        console.error(`pick image failed: ${error.message}`)
      })
    } catch (error) {
      console.error('open photo picker failed')
    }
  }
}

@Builder
export function SettingsCustomPageBuilder() {
  SettingsCustomPage()
}
