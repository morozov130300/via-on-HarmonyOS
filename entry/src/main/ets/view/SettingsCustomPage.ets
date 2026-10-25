const CUSTOM_BG_COLORS: string[] = ['#F8A246', '#FEC849', '#B4BE74', '#6AC4C4', '#616FBA', '#9B66AA', '#CB9E67', '#9B9FAB', '#694D35']
const LOGO_FONT_SIZES: string[] = ['63px', '48px', '36px']
const LOGO_FONT_SIZE_VP: number[] = [25, 19, 14]
const LOGO_STYLES: string[] = ['常规', '粗体', '斜体', '粗体 斜体']
const PILL_CORNERS: string[] = ['100%', '50%', '0%']
const PILL_CORNER_VP: number[] = [17, 8, 0]
const PILL_OPACITY: string[] = ['25%', '50%', '100%']
const PILL_OPACITY_VP: number[] = [0.25, 0.5, 1]
const PILL_STROKE_WIDTHS: string[] = ['7px', '3px', '0px']
const PILL_STROKE_VP: number[] = [2.8, 1.2, 0]
const PILL_STYLES: string[] = ['矩形', '胶囊']
const FAV_SIZES: string[] = ['50px', '40px', '60px']
const FAV_SIZE_VP: number[] = [20, 16, 24]
const FAV_CORNERS: string[] = ['100%', '50%', '0%']
const FAV_CORNER_VP: number[] = [10, 5, 0]
const FAV_ICON_STYLES: string[] = ['图标优先', '文字优先']
const FAV_ICON_COLORS: string[] = ['多彩', '单色']
const ADV_EFFECTS: string[] = ['透明', '不透明']
const ADV_AREAS: string[] = ['展示', '隐藏']

@ComponentV2
export struct SettingsCustomPage {
  @Local bgIndex: number = 4
  @Local logoSizeIndex: number = 0
  @Local logoStyleIndex: number = 3
  @Local pillCornerIndex: number = 0
  @Local pillOpacityIndex: number = 0
  @Local pillStrokeIndex: number = 0
  @Local pillStyleIndex: number = 0
  @Local favSizeIndex: number = 0
  @Local favCornerIndex: number = 0
  @Local favIconStyleIndex: number = 0
  @Local favIconColorIndex: number = 0
  @Local advEffectIndex: number = 0
  @Local advAreaIndex: number = 0

  build() {
    NavDestination() {
      Column() {
        this.PreviewCard()

        Tabs({ barPosition: BarPosition.End }) {
          TabContent() {
            this.LogoPanel()
          }
          .tabBar('Logo')

          TabContent() {
            this.SearchPanel()
          }
          .tabBar('搜索框')

          TabContent() {
            this.BgPanel()
          }
          .tabBar('背景')

          TabContent() {
            this.FavPanel()
          }
          .tabBar('收藏')

          TabContent() {
            this.AdvPanel()
          }
          .tabBar('高级')
        }
        .barHeight(46)
        .vertical(false)
        .scrollable(false)
        .width('100%')
        .height(132)
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .title('定制')
  }

  @Builder
  PreviewCard() {
    Column() {
      Blank()

      Column({ space: 8 }) {
        Text('VIA')
          .fontSize(LOGO_FONT_SIZE_VP[this.logoSizeIndex])
          .fontColor('#FAFAFA')
          .fontWeight(this.logoStyleIndex === 1 || this.logoStyleIndex === 3 ? FontWeight.Bold : FontWeight.Normal)
          .fontStyle(this.logoStyleIndex === 2 || this.logoStyleIndex === 3 ? FontStyle.Italic : FontStyle.Normal)

        Row() {
          Text($r('app.string.search'))
            .fontSize(14)
            .fontColor('#FAFAFA')
            .opacity(0.8)
        }
        .height(34)
        .padding({ left: 48, right: 48 })
        .justifyContent(FlexAlign.Center)
        .backgroundColor('#646986')
        .opacity(ADV_EFFECTS[this.advEffectIndex] === '透明' ? PILL_OPACITY_VP[this.pillOpacityIndex] : 1)
        .borderRadius(PILL_STYLES[this.pillStyleIndex] === '胶囊' ? 17 : PILL_CORNER_VP[this.pillCornerIndex])
        .border({
          width: PILL_STROKE_VP[this.pillStrokeIndex],
          color: $r('app.color.search_pill_border')
        })
      }

      if (ADV_AREAS[this.advAreaIndex] === '展示') {
        Column({ space: 6 }) {
          Text('华')
            .fontSize(FAV_SIZE_VP[this.favSizeIndex] * 0.6)
            .fontColor(Color.White)
            .width(FAV_SIZE_VP[this.favSizeIndex])
            .height(FAV_SIZE_VP[this.favSizeIndex])
            .textAlign(TextAlign.Center)
            .backgroundColor(this.favCircleColor())
            .borderRadius(FAV_CORNERS[this.favCornerIndex] === '100%'
              ? FAV_SIZE_VP[this.favSizeIndex] / 2 : FAV_CORNER_VP[this.favCornerIndex])
          Text('华为开发者')
            .fontSize(11)
            .fontColor('#FAFAFA')
            .opacity(0.7)
        }
        .margin({ top: 28 })
      }

      Blank()
    }
    .width('100%')
    .layoutWeight(1)
    .margin(12)
    .borderRadius(12)
    .backgroundColor(CUSTOM_BG_COLORS[this.bgIndex])
  }

  private favCircleColor(): ResourceColor {
    return FAV_ICON_COLORS[this.favIconColorIndex] === '多彩' ? '#5B8DEF' : '#9F9F9F'
  }

  @Builder
  PanelItem(iconRes: Resource, itemLabel: string, itemValue: string, onTapItem: () => void) {
    Column({ space: 4 }) {
      Image(iconRes)
        .height(20)
        .width(26)
        .objectFit(ImageFit.Contain)
      Text(itemLabel)
        .fontSize(12)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
      Text(itemValue)
        .fontSize(11)
        .fontColor($r('app.color.fg_secondary'))
        .maxLines(1)
    }
    .width('20%')
    .padding({ top: 10, bottom: 8 })
    .alignItems(HorizontalAlign.Center)
    .onClick(() => {
      onTapItem()
    })
  }

  @Builder
  LogoPanel() {
    Row() {
      this.PanelItem($r('app.media.via_ic_c_logo_text'), 'Logo', '文字', () => {
        this.notImplemented()
      })
      this.PanelItem($r('app.media.via_ic_c_font_size'), '字体大小', LOGO_FONT_SIZES[this.logoSizeIndex], () => {
        this.logoSizeIndex = (this.logoSizeIndex + 1) % LOGO_FONT_SIZES.length
      })
      this.PanelItem($r('app.media.via_ic_c_font_style'), '字体风格', LOGO_STYLES[this.logoStyleIndex], () => {
        this.logoStyleIndex = (this.logoStyleIndex + 1) % LOGO_STYLES.length
      })
    }
    .width('100%')
    .height(86)
    .justifyContent(FlexAlign.Center)
  }

  @Builder
  SearchPanel() {
    Row() {
      this.PanelItem($r('app.media.via_ic_c_corner'), '圆角值', PILL_CORNERS[this.pillCornerIndex], () => {
        this.pillCornerIndex = (this.pillCornerIndex + 1) % PILL_CORNERS.length
      })
      this.PanelItem($r('app.media.via_ic_c_opacity'), '不透明度', PILL_OPACITY[this.pillOpacityIndex], () => {
        this.pillOpacityIndex = (this.pillOpacityIndex + 1) % PILL_OPACITY.length
      })
      this.PanelItem($r('app.media.via_ic_c_stroke_width'), '描边粗细', PILL_STROKE_WIDTHS[this.pillStrokeIndex], () => {
        this.pillStrokeIndex = (this.pillStrokeIndex + 1) % PILL_STROKE_WIDTHS.length
      })
      this.PanelItem($r('app.media.via_ic_c_stroke_opacity'), '描边不透明度', PILL_OPACITY[this.pillOpacityIndex], () => {
        this.pillOpacityIndex = (this.pillOpacityIndex + 1) % PILL_OPACITY.length
      })
      this.PanelItem($r('app.media.via_ic_c_search_style'), '搜索框样式', PILL_STYLES[this.pillStyleIndex], () => {
        this.pillStyleIndex = (this.pillStyleIndex + 1) % PILL_STYLES.length
      })
    }
    .width('100%')
    .height(86)
    .justifyContent(FlexAlign.Center)
  }

  @Builder
  BgPanel() {
    Row({ space: 12 }) {
      ForEach(CUSTOM_BG_COLORS, (colorHex: string, index: number) => {
        Circle()
          .fill(colorHex)
          .stroke(index === this.bgIndex ? '#FAFAFA' : Color.Transparent)
          .strokeWidth(index === this.bgIndex ? 2 : 0)
          .width(index === this.bgIndex ? 38 : 28)
          .height(index === this.bgIndex ? 38 : 28)
          .onClick(() => {
            this.bgIndex = index
          })
      }, (colorHex: string) => colorHex)
    }
    .width('100%')
    .height(86)
    .justifyContent(FlexAlign.Center)
  }

  @Builder
  FavPanel() {
    Row() {
      this.PanelItem($r('app.media.via_ic_c_fav_width'), '宽度', FAV_SIZES[this.favSizeIndex], () => {
        this.favSizeIndex = (this.favSizeIndex + 1) % FAV_SIZES.length
      })
      this.PanelItem($r('app.media.via_ic_c_fav_height'), '高度', FAV_SIZES[this.favSizeIndex], () => {
        this.favSizeIndex = (this.favSizeIndex + 1) % FAV_SIZES.length
      })
      this.PanelItem($r('app.media.via_ic_c_fav_corner'), '圆角值', FAV_CORNERS[this.favCornerIndex], () => {
        this.favCornerIndex = (this.favCornerIndex + 1) % FAV_CORNERS.length
      })
      this.PanelItem($r('app.media.via_ic_c_fav_icon_style'), '图标样式', FAV_ICON_STYLES[this.favIconStyleIndex], () => {
        this.favIconStyleIndex = (this.favIconStyleIndex + 1) % FAV_ICON_STYLES.length
      })
      this.PanelItem($r('app.media.via_ic_c_fav_icon_color'), '图标色彩', FAV_ICON_COLORS[this.favIconColorIndex], () => {
        this.favIconColorIndex = (this.favIconColorIndex + 1) % FAV_ICON_COLORS.length
      })
    }
    .width('100%')
    .height(86)
    .justifyContent(FlexAlign.Center)
  }

  @Builder
  AdvPanel() {
    Row() {
      this.PanelItem($r('app.media.via_ic_c_adv_effect'), '搜索框效果', ADV_EFFECTS[this.advEffectIndex], () => {
        this.advEffectIndex = (this.advEffectIndex + 1) % ADV_EFFECTS.length
      })
      this.PanelItem($r('app.media.via_ic_c_adv_area'), '搜索区域', ADV_AREAS[this.advAreaIndex], () => {
        this.advAreaIndex = (this.advAreaIndex + 1) % ADV_AREAS.length
      })
      this.PanelItem($r('app.media.via_ic_c_adv_css'), '自定义 CSS', '', () => {
        this.notImplemented()
      })
      this.PanelItem($r('app.media.via_ic_c_clear_icon'), '清除图标', '', () => {
        this.notImplemented()
      })
      this.PanelItem($r('app.media.via_ic_c_reset'), '重置', '', () => {
        this.notImplemented()
      })
    }
    .width('100%')
    .height(86)
    .justifyContent(FlexAlign.Center)
  }

  private notImplemented(): void {
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.feature_wip'), duration: 1500 })
  }
}

@Builder
export function SettingsCustomPageBuilder() {
  SettingsCustomPage()
}
