import { HomePage } from '../components/HomePage'
import { AppSettings } from '../common/Settings'
import { SettingsHeader } from '../components/SettingsHeader'
import { AppIcon } from '../components/AppIcon'
import { picker } from '@kit.CoreFileKit'
import { BusinessError } from '@kit.BasicServicesKit'
import {
  HOME_ADV_AREAS,
  HOME_ADV_EFFECTS,
  HOME_BG_COLORS,
  HOME_FAV_CORNERS,
  HOME_FAV_DIMENSIONS,
  HOME_FAV_ICON_COLORS,
  HOME_FAV_ICON_STYLES,
  HOME_LOGO_CORNERS,
  HOME_LOGO_DIMENSIONS,
  HOME_LOGO_TYPES,
  HOME_PILL_CORNERS,
  HOME_PILL_OPACITY,
  HOME_PILL_STROKE_LABELS,
  HOME_PILL_STROKE_OPACITY,
  HOME_PILL_STYLES
} from '../common/HomeStyle'

@ComponentV2
export struct SettingsCustomPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local logoDraft: string = ''
  private logoDialogId: number = -1
  @Local cssDraft: string = ''
  private cssDialogId: number = -1

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '定制',
          onBack: () => {
            this.navPathStack.pop()
          }
        })
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
        .vertical(false)
        .scrollable(false)
        .width('100%')
        .height(150)
        .backgroundColor($r('app.color.surface'))
        .borderRadius({ topLeft: 16, topRight: 16 })
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }

  // 每个面板的快捷设置项：图标 + 标签(可两行) + 值，等宽弹性分布，窄屏自动收窄
  @Builder
  PanelItem(iconRes: Resource, itemLabel: string, itemValue: string, onTapItem: () => void) {
    Column({ space: 4 }) {
      Image(iconRes)
        .height(24)
        .width(28)
        .objectFit(ImageFit.Contain)
      Text(itemLabel)
        .fontSize(12)
        .fontColor($r('app.color.fg'))
        .maxLines(2)
        .textAlign(TextAlign.Center)
        .constraintSize({ maxWidth: '92%' })
      if (itemValue !== '') {
        Text(itemValue)
          .fontSize(11)
          .fontColor($r('app.color.fg_secondary'))
          .maxLines(1)
          .textAlign(TextAlign.Center)
          .constraintSize({ maxWidth: '92%' })
      }
    }
    .layoutWeight(1)
    .padding({ top: 12, bottom: 8, left: 4, right: 4 })
    .alignItems(HorizontalAlign.Center)
    .onClick(() => {
      onTapItem()
    })
  }

  @Builder
  LogoPanel() {
    Row() {
      this.PanelItem($r('app.media.via_ic_c_logo_text'), 'Logo', HOME_LOGO_TYPES[this.settings.homeLogoType] === '文字' ? '文字' : '默认', () => {
        this.settings.setHomeLogoType((this.settings.homeLogoType + 1) % HOME_LOGO_TYPES.length)
      })
      this.PanelItem($r('app.media.via_ic_c_fav_width'), '宽度', HOME_LOGO_DIMENSIONS[this.settings.homeLogoWidth], () => {
        this.settings.setHomeLogoWidth((this.settings.homeLogoWidth + 1) % HOME_LOGO_DIMENSIONS.length)
      })
      this.PanelItem($r('app.media.via_ic_c_fav_height'), '高度', HOME_LOGO_DIMENSIONS[this.settings.homeLogoHeight], () => {
        this.settings.setHomeLogoHeight((this.settings.homeLogoHeight + 1) % HOME_LOGO_DIMENSIONS.length)
      })
      this.PanelItem($r('app.media.via_ic_c_fav_corner'), '圆角值', HOME_LOGO_CORNERS[this.settings.homeLogoCorner], () => {
        this.settings.setHomeLogoCorner((this.settings.homeLogoCorner + 1) % HOME_LOGO_CORNERS.length)
      })
    }
    .width('100%')
    .height(104)
    .justifyContent(FlexAlign.SpaceAround)
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
      this.PanelItem($r('app.media.via_ic_c_stroke_opacity'), '描边不透明度', HOME_PILL_STROKE_OPACITY[this.settings.homePillStrokeOpacity], () => {
        this.settings.setHomePillStrokeOpacity((this.settings.homePillStrokeOpacity + 1) % HOME_PILL_STROKE_OPACITY.length)
      })
      this.PanelItem($r('app.media.via_ic_c_search_style'), '搜索框样式', HOME_PILL_STYLES[this.settings.homePillStyle], () => {
        this.settings.setHomePillStyle((this.settings.homePillStyle + 1) % HOME_PILL_STYLES.length)
      })
    }
    .width('100%')
    .height(104)
    .justifyContent(FlexAlign.SpaceAround)
  }

  @Builder
  BgColorCircle(colorHex: string) {
    Stack() {
      if (this.settings.homeBgImage === '' && this.settings.homeBgColor === colorHex) {
        Circle({ width: 44, height: 44 })
          .fill(Color.Transparent)
          .stroke($r('app.color.fg'))
          .strokeWidth(2)
      }
      Circle({ width: 34, height: 34 })
        .fill(colorHex)
    }
    .width(46)
    .height(46)
    .onClick(() => {
      this.settings.setHomeBgColor(colorHex)
      this.settings.setHomeBgImage('')
    })
  }

  @Builder
  BgPanel() {
    Scroll() {
      Row({ space: 12 }) {
        Stack() {
          Circle({ width: 40, height: 40 })
            .fill(Color.Transparent)
            .stroke(this.settings.homeBgColor === '' && this.settings.homeBgImage === '' ? $r('app.color.fg') : $r('app.color.fg_secondary'))
            .strokeWidth(this.settings.homeBgColor === '' && this.settings.homeBgImage === '' ? 2 : 1)
          Circle({ width: 32, height: 32 })
            .fill($r('app.color.page_bg'))
        }
        .width(44)
        .height(44)
        .onClick(() => {
          this.settings.setHomeBgColor('')
          this.settings.setHomeBgImage('')
        })
        Stack() {
          Circle({ width: 40, height: 40 })
            .fill(Color.Transparent)
            .stroke(this.settings.homeBgImage !== '' ? $r('app.color.fg') : $r('app.color.fg_secondary'))
            .strokeWidth(this.settings.homeBgImage !== '' ? 2 : 1)
          AppIcon({ icon: $r('sys.symbol.picture'), iconSize: 18, iconColor: $r('app.color.fg') })
        }
        .width(44)
        .height(44)
        .onClick(() => {
          this.pickBgImage()
        })
        ForEach(HOME_BG_COLORS, (colorHex: string) => {
          this.BgColorCircle(colorHex)
        }, (colorHex: string) => colorHex)
      }
      .padding({ left: 12, right: 16 })
    }
    .scrollable(ScrollDirection.Horizontal)
    .width('100%')
    .height(104)
    .align(Alignment.Center)
  }

  @Builder
  FavPanel() {
    Row() {
      this.PanelItem($r('app.media.via_ic_c_fav_width'), '宽度', HOME_FAV_DIMENSIONS[this.settings.homeFavWidth], () => {
        this.settings.setHomeFavWidth((this.settings.homeFavWidth + 1) % HOME_FAV_DIMENSIONS.length)
      })
      this.PanelItem($r('app.media.via_ic_c_fav_height'), '高度', HOME_FAV_DIMENSIONS[this.settings.homeFavHeight], () => {
        this.settings.setHomeFavHeight((this.settings.homeFavHeight + 1) % HOME_FAV_DIMENSIONS.length)
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
    .height(104)
    .justifyContent(FlexAlign.SpaceAround)
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
        this.editCustomCss()
      })
      this.PanelItem($r('app.media.via_ic_c_clear_icon'), '清除图标', '', () => {
        this.clearIcons()
      })
      this.PanelItem($r('app.media.via_ic_c_reset'), '重置', '', () => {
        this.settings.resetHomeStyle()
        this.getUIContext().getPromptAction().showToast({ message: $r('app.string.reset_done'), duration: 1500 })
      })
    }
    .width('100%')
    .height(104)
    .justifyContent(FlexAlign.SpaceAround)
  }

  private pickBgImage(): void {
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
          this.settings.setHomeBgColor('')
          this.settings.setHomeBgImage(result.photoUris[0])
        }
      }).catch((error: BusinessError) => {
        console.error(`pick bg image failed: ${error.message}`)
      })
    } catch (error) {
      console.error('open photo picker failed')
    }
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
    .width('86%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
  }

  private editCustomCss(): void {
    this.cssDraft = this.settings.customCss
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: () => {
        this.CustomCssDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center
    }).then((dialogId: number) => {
      this.cssDialogId = dialogId
    }).catch(() => {
      console.error('open css dialog failed')
    })
  }

  private closeCssDialog(): void {
    if (this.cssDialogId >= 0) {
      try {
        this.getUIContext().getPromptAction().closeCustomDialog(this.cssDialogId)
      } catch (error) {
        console.error('close css dialog failed')
      }
    }
  }

  private clearIcons(): void {
    this.settings.setHomeFavIconStyle(1)
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.cleared'), duration: 1500 })
  }

  @Builder
  CustomCssDialog() {
    Column({ space: 16 }) {
      Text('自定义 CSS')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
      TextArea({ text: this.cssDraft, placeholder: '输入 CSS 样式' })
        .fontSize(14)
        .height(120)
        .onChange((value: string) => {
          this.cssDraft = value
        })
      Row({ space: 12 }) {
        Button('取消')
          .fontSize(15)
          .layoutWeight(1)
          .backgroundColor($r('app.color.page_bg'))
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            this.closeCssDialog()
          })
        Button('清空')
          .fontSize(15)
          .layoutWeight(1)
          .backgroundColor($r('app.color.page_bg'))
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            this.settings.setCustomCss('')
            this.closeCssDialog()
          })
        Button('确定')
          .fontSize(15)
          .layoutWeight(1)
          .onClick(() => {
            this.settings.setCustomCss(this.cssDraft)
            this.closeCssDialog()
          })
      }
      .width('100%')
    }
    .width('86%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
  }
}

@Builder
export function SettingsCustomPageBuilder() {
  SettingsCustomPage()
}
