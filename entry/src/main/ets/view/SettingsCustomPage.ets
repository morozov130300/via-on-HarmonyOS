import { HomePage } from '../components/HomePage'
import { AppSettings } from '../common/Settings'
import {
  HOME_ADV_AREAS,
  HOME_ADV_EFFECTS,
  HOME_BG_COLORS,
  HOME_FAV_CORNERS,
  HOME_FAV_ICON_COLORS,
  HOME_FAV_ICON_STYLES,
  HOME_FAV_SIZES,
  HOME_LOGO_FONT_LABELS,
  HOME_LOGO_STYLES,
  HOME_PILL_CORNERS,
  HOME_PILL_OPACITY,
  HOME_PILL_STROKE_LABELS,
  HOME_PILL_STYLES
} from '../common/HomeStyle'

@ComponentV2
export struct SettingsCustomPage {
  private settings: AppSettings = AppSettings.getInstance()
  @Local logoDraft: string = ''
  private logoDialogId: number = -1

  build() {
    NavDestination() {
      Column() {
        Column() {
          HomePage({ onSearchTap: () => {
          } })
        }
        .width('100%')
        .layoutWeight(1)

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
      this.PanelItem($r('app.media.via_ic_c_logo_text'), 'Logo', this.settings.homeLogoText, () => {
        this.editLogoText()
      })
      this.PanelItem($r('app.media.via_ic_c_font_size'), '字体大小', HOME_LOGO_FONT_LABELS[this.settings.homeLogoSize], () => {
        this.settings.setHomeLogoSize((this.settings.homeLogoSize + 1) % HOME_LOGO_FONT_LABELS.length)
      })
      this.PanelItem($r('app.media.via_ic_c_font_style'), '字体风格', HOME_LOGO_STYLES[this.settings.homeLogoStyle], () => {
        this.settings.setHomeLogoStyle((this.settings.homeLogoStyle + 1) % HOME_LOGO_STYLES.length)
      })
    }
    .width('100%')
    .height(86)
    .justifyContent(FlexAlign.Center)
  }

  @Builder
  SearchPanel() {
    Row() {
      this.PanelItem($r('app.media.via_ic_c_corner'), '圆角值', HOME_PILL_CORNERS[this.settings.homePillCorner], () => {
        this.settings.setHomePillCorner((this.settings.homePillCorner + 1) % HOME_PILL_CORNERS.length)
      })
      this.PanelItem($r('app.media.via_ic_c_opacity'), '不透明度', HOME_PILL_OPACITY[this.settings.homePillOpacity], () => {
        this.settings.setHomePillOpacity((this.settings.homePillOpacity + 1) % HOME_PILL_OPACITY.length)
      })
      this.PanelItem($r('app.media.via_ic_c_stroke_width'), '描边粗细', HOME_PILL_STROKE_LABELS[this.settings.homePillStrokeWidth], () => {
        this.settings.setHomePillStrokeWidth((this.settings.homePillStrokeWidth + 1) % HOME_PILL_STROKE_LABELS.length)
      })
      this.PanelItem($r('app.media.via_ic_c_stroke_opacity'), '描边不透明度', HOME_PILL_OPACITY[this.settings.homePillStrokeOpacity], () => {
        this.settings.setHomePillStrokeOpacity((this.settings.homePillStrokeOpacity + 1) % HOME_PILL_OPACITY.length)
      })
      this.PanelItem($r('app.media.via_ic_c_search_style'), '搜索框样式', HOME_PILL_STYLES[this.settings.homePillStyle], () => {
        this.settings.setHomePillStyle((this.settings.homePillStyle + 1) % HOME_PILL_STYLES.length)
      })
    }
    .width('100%')
    .height(86)
    .justifyContent(FlexAlign.Center)
  }

  @Builder
  BgPanel() {
    Row({ space: 12 }) {
      ForEach(HOME_BG_COLORS, (colorHex: string) => {
        Circle()
          .fill(colorHex)
          .stroke(this.settings.homeBgColor === colorHex ? '#FAFAFA' : Color.Transparent)
          .strokeWidth(this.settings.homeBgColor === colorHex ? 2 : 0)
          .width(this.settings.homeBgColor === colorHex ? 38 : 28)
          .height(this.settings.homeBgColor === colorHex ? 38 : 28)
          .onClick(() => {
            this.settings.setHomeBgColor(colorHex)
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
      this.PanelItem($r('app.media.via_ic_c_fav_width'), '宽度', HOME_FAV_SIZES[this.settings.homeFavSize], () => {
        this.settings.setHomeFavSize((this.settings.homeFavSize + 1) % HOME_FAV_SIZES.length)
      })
      this.PanelItem($r('app.media.via_ic_c_fav_height'), '高度', HOME_FAV_SIZES[this.settings.homeFavSize], () => {
        this.settings.setHomeFavSize((this.settings.homeFavSize + 1) % HOME_FAV_SIZES.length)
      })
      this.PanelItem($r('app.media.via_ic_c_fav_corner'), '圆角值', HOME_FAV_CORNERS[this.settings.homeFavCorner], () => {
        this.settings.setHomeFavCorner((this.settings.homeFavCorner + 1) % HOME_FAV_CORNERS.length)
      })
      this.PanelItem($r('app.media.via_ic_c_fav_icon_style'), '图标样式', HOME_FAV_ICON_STYLES[this.settings.homeFavIconStyle], () => {
        this.settings.setHomeFavIconStyle((this.settings.homeFavIconStyle + 1) % HOME_FAV_ICON_STYLES.length)
      })
      this.PanelItem($r('app.media.via_ic_c_fav_icon_color'), '图标色彩', HOME_FAV_ICON_COLORS[this.settings.homeFavColor], () => {
        this.settings.setHomeFavColor((this.settings.homeFavColor + 1) % HOME_FAV_ICON_COLORS.length)
      })
    }
    .width('100%')
    .height(86)
    .justifyContent(FlexAlign.Center)
  }

  @Builder
  AdvPanel() {
    Row() {
      this.PanelItem($r('app.media.via_ic_c_adv_effect'), '搜索框效果', HOME_ADV_EFFECTS[this.settings.homeAdvEffect], () => {
        this.settings.setHomeAdvEffect((this.settings.homeAdvEffect + 1) % HOME_ADV_EFFECTS.length)
      })
      this.PanelItem($r('app.media.via_ic_c_adv_area'), '搜索区域', HOME_ADV_AREAS[this.settings.homeAdvArea], () => {
        this.settings.setHomeAdvArea((this.settings.homeAdvArea + 1) % HOME_ADV_AREAS.length)
      })
      this.PanelItem($r('app.media.via_ic_c_adv_css'), '自定义 CSS', '', () => {
        this.notImplemented()
      })
      this.PanelItem($r('app.media.via_ic_c_clear_icon'), '清除图标', '', () => {
        this.notImplemented()
      })
      this.PanelItem($r('app.media.via_ic_c_reset'), '重置', '', () => {
        this.settings.resetHomeStyle()
        this.getUIContext().getPromptAction().showToast({ message: $r('app.string.reset_done'), duration: 1500 })
      })
    }
    .width('100%')
    .height(86)
    .justifyContent(FlexAlign.Center)
  }

  private editLogoText(): void {
    this.logoDraft = this.settings.homeLogoText
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: () => {
        this.LogoInputDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center
    }).then((dialogId: number) => {
      this.logoDialogId = dialogId
    }).catch(() => {
      console.error('open logo dialog failed')
    })
  }

  private closeLogoDialog(): void {
    if (this.logoDialogId >= 0) {
      try {
        this.getUIContext().getPromptAction().closeCustomDialog(this.logoDialogId)
      } catch (error) {
        console.error('close logo dialog failed')
      }
    }
  }

  @Builder
  LogoInputDialog() {
    Column({ space: 16 }) {
      Text('Logo 文字')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
      TextInput({ text: this.logoDraft, placeholder: '输入 Logo 文字' })
        .fontSize(15)
        .height(44)
        .onChange((value: string) => {
          this.logoDraft = value
        })
      Row({ space: 12 }) {
        Button('取消')
          .fontSize(15)
          .layoutWeight(1)
          .backgroundColor($r('app.color.page_bg'))
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            this.closeLogoDialog()
          })
        Button('确定')
          .fontSize(15)
          .layoutWeight(1)
          .onClick(() => {
            this.settings.setHomeLogoText(this.logoDraft)
            this.closeLogoDialog()
          })
      }
      .width('100%')
    }
    .width('100%')
    .padding(20)
    .backgroundColor($r('app.color.page_bg'))
    .borderRadius(16)
  }

  private notImplemented(): void {
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.feature_wip'), duration: 1500 })
  }
}

@Builder
export function SettingsCustomPageBuilder() {
  SettingsCustomPage()
}
