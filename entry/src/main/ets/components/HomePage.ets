import { TabStore } from '../common/TabStore'
import { AppIcon } from './AppIcon'
import { ViaIcon } from './ViaIcon'
import { BrowserDb } from '../common/Database'
import { BookmarkRec } from '../common/Types'
import { hostOf } from '../common/SearchEngines'
import { AppSettings } from '../common/Settings'
import { UiInsets } from '../common/Immersive'
import { scanBarcode } from '@kit.ScanKit'
import {
  HOME_ADV_AREAS,
  HOME_FAV_DIM_COLOR,
  HOME_FAV_ICON_STYLES,
  HOME_FAV_PALETTE,
  HOME_FAV_SHADOWS,
  HOME_LOGO_COLOR,
  HOME_LOGO_STYLES,
  HOME_LOGO_TYPES,
  HOME_PILL_HEIGHT,
  HOME_PILL_STYLES
} from '../common/HomeStyle'

const HOME_BOOKMARK_LIMIT: number = 8
@ComponentV2
export struct HomePage {
  private tabStore: TabStore = TabStore.getInstance()
  private db: BrowserDb = BrowserDb.getInstance()
  private settings: AppSettings = AppSettings.getInstance()
  @Event onSearchTap: () => void = () => {}
  @Event onScanResult: (text: string) => void = (text: string) => {}
  @Local bookmarks: BookmarkRec[] = []
  private insets: UiInsets = UiInsets.getInstance()

  aboutToAppear(): void {
    this.db.listBookmarks().then((items: BookmarkRec[]) => {
      this.bookmarks = items
    }).catch((error: BusinessError) => {
      console.error(`list bookmarks failed: ${error.message}`)
    })
  }

  // 调起系统扫码，识别结果回填地址栏
  private startScan(): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    scanBarcode.startScanForResult(context).then((data: scanBarcode.ScanResult) => {
      const scanned = data.originalValue.trim()
      if (scanned !== '') {
        this.onScanResult(scanned)
      }
    }).catch((error: BusinessError) => {
      console.error(`scan failed: ${error.code}`)
    })
  }

  build() {
    Stack() {
      if (this.settings.homeBgImage !== '') {
        Image(this.settings.homeBgImage)
          .width('100%')
          .height('100%')
          .objectFit(ImageFit.Cover)
        Column()
          .width('100%')
          .height('100%')
          .backgroundColor(`#${this.bgOverlayAlpha()}000000`)
      }
      Column() {
      Row({ space: 12 }) {
        AppIcon({ icon: $r('sys.symbol.magnifyingglass'), iconSize: 22, iconColor: $r('app.color.home_title') })
          .onClick(() => {
            this.onSearchTap()
          })
        Text($r('app.string.home_page'))
          .fontSize(16)
          .fontColor($r('app.color.home_title'))
          .maxLines(1)
        Blank()
        ViaIcon({ icon: $r('app.media.via_ic_scan'), iconSize: 22, iconColor: $r('app.color.home_title') })
          .onClick(() => {
            this.startScan()
          })
      }
      .width('100%')
      .height(48)
      .padding({ left: 16, right: 16 })
      .alignItems(VerticalAlign.Center)

      Blank()

      if (HOME_ADV_AREAS[this.settings.homeAdvArea] === '提示') {
        Column({ space: 10 }) {
          if (HOME_LOGO_TYPES[this.settings.homeLogoType] === '文字') {
            Text(this.settings.homeLogoText)
              .fontSize(this.settings.homeLogoSize)
              .fontColor(HOME_LOGO_COLOR)
              .fontWeight(this.logoBold())
              .fontStyle(this.logoItalic())
              .maxLines(1)
          } else if (HOME_LOGO_TYPES[this.settings.homeLogoType] === '图片'
            && this.settings.homeLogoImage !== '') {
            Image(this.settings.homeLogoImage)
              .width(this.logoWidth())
              .height(this.logoHeight())
              .borderRadius(this.logoRadius())
              .objectFit(ImageFit.Contain)
          } else if (HOME_LOGO_TYPES[this.settings.homeLogoType] === 'HTML 代码'
            && this.settings.homeLogoHtml !== '') {
            RichText(this.settings.homeLogoHtml)
              .width(this.logoWidth())
              .height(this.logoHeight())
          } else if (HOME_LOGO_TYPES[this.settings.homeLogoType] === '默认') {
            Image($rawfile('logo.svg'))
              .width(this.logoWidth())
              .height(this.logoHeight())
              .borderRadius(this.logoRadius())
              .objectFit(ImageFit.Contain)
          }
        }

        Row() {
          Text($r('app.string.search'))
            .fontSize(15)
            .fontColor($r('app.color.search_pill_border'))
            .maxLines(1)
        }
        .height(HOME_PILL_HEIGHT)
        .width('92%')
        .backgroundColor(this.pillBackground())
        .backgroundBlurStyle(this.settings.homeAdvEffect === 1 ? BlurStyle.COMPONENT_THICK : BlurStyle.NONE)
        .borderRadius(this.pillRadius())
        .border(this.pillBorder())
        .margin({ top: 24 })
        .justifyContent(FlexAlign.Center)
        .onClick(() => {
          this.onSearchTap()
        })
      }

      if (this.bookmarks.length > 0) {
        Grid() {
          ForEach(this.bookmarks, (item: BookmarkRec) => {
            if (this.bookmarks.indexOf(item) < HOME_BOOKMARK_LIMIT) {
              GridItem() {
                Column({ space: 6 }) {
                  Stack() {
                    Text(this.shortLabel(item.title, item.url))
                      .fontSize(this.favSize() * 0.43)
                      .fontColor(Color.White)
                      .textAlign(TextAlign.Center)
                      .width('100%')
                      .height('100%')
                    if (this.showFavicon() && this.faviconUrl(item.url) !== '') {
                      Image(this.faviconUrl(item.url))
                        .width('100%')
                        .height('100%')
                        .borderRadius(this.favRadius())
                        .objectFit(ImageFit.Contain)
                    }
                  }
                  .width(this.favSize())
                  .height(this.favHeight())
                  .borderRadius(this.favRadius())
                  .backgroundColor(this.favColor(item))
                  Text(item.title !== '' ? item.title : hostOf(item.url))
                    .fontSize(11)
                    .fontColor($r('app.color.fg_secondary'))
                    .maxLines(1)
                    .constraintSize({ maxWidth: 76 })
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                }
                .padding({ top: 4, bottom: 4 })
              }
              .onClick(() => {
                this.tabStore.navigate(item.url)
              })
            }
          }, (item: BookmarkRec) => `${item.id}_${item.title}`)
        }
        .columnsTemplate('1fr 1fr 1fr 1fr')
        .columnsGap(8)
        .rowsGap(10)
        .width('88%')
        .margin({ top: 28 })
        .height(this.bookmarks.length > 4 ? 130 : 68)
      }

      Blank()
      }
      .width('100%')
      .height('100%')
      .padding({ top: this.insets.top })
    }
    .width('100%')
    .height('100%')
    .backgroundColor(this.homeBackground())
  }

  private homeBackground(): ResourceColor {
    if (this.settings.homeBgImage !== '') {
      return Color.Transparent
    }
    if (this.settings.homeBgColor !== '') {
      return this.settings.homeBgColor
    }
    return $r('app.color.home_bg')
  }

  // 背景图片遮罩不透明度（0-100 → 00-FF 黑色遮罩 alpha）
  private bgOverlayAlpha(): string {
    const alpha = Math.round(this.settings.homeBgOpacity * 2.55)
    let hex = alpha.toString(16)
    if (hex.length === 1) {
      hex = `0${hex}`
    }
    return hex
  }

  private logoBold(): FontWeight {
    const style = HOME_LOGO_STYLES[this.settings.homeLogoStyle]
    return style === '粗体' || style === '粗体 斜体' ? FontWeight.Bold : FontWeight.Normal
  }

  private logoItalic(): FontStyle {
    const style = HOME_LOGO_STYLES[this.settings.homeLogoStyle]
    return style === '斜体' || style === '粗体 斜体' ? FontStyle.Italic : FontStyle.Normal
  }

  private logoWidth(): number {
    return this.settings.homeLogoWidth === 0 ? 56 : this.settings.homeLogoWidth
  }

  private logoHeight(): number {
    return this.settings.homeLogoHeight === 0 ? 56 : this.settings.homeLogoHeight
  }

  private logoRadius(): number {
    const size = Math.min(this.logoWidth(), this.logoHeight())
    return size / 2 * (this.settings.homeLogoCorner / 100)
  }

  private favSize(): number {
    return this.settings.homeFavWidth === 0 ? 46 : this.settings.homeFavWidth
  }

  private favHeight(): number {
    return this.settings.homeFavHeight === 0 ? this.favSize() : this.settings.homeFavHeight
  }

  private pillRadius(): number {
    if (HOME_PILL_STYLES[this.settings.homePillStyle] === '线条') {
      return 0
    }
    return HOME_PILL_HEIGHT / 2 * (this.settings.homePillCorner / 100)
  }

  // 不透明度滑杆：0% 用默认底色，>0% 向白色过渡（视频 40-41s）
  private pillBackground(): ResourceColor {
    const pct = this.settings.homePillOpacity
    if (pct > 0) {
      return `rgba(255,255,255,${pct / 100})`
    }
    return $r('app.color.search_pill_bg')
  }

  private pillBorder(): BorderOptions {
    if (HOME_PILL_STYLES[this.settings.homePillStyle] === '线条') {
      return {
        width: { bottom: this.settings.homePillStrokeWidth },
        color: this.strokeColor()
      }
    }
    return {
      width: this.settings.homePillStrokeWidth,
      color: this.strokeColor()
    }
  }

  private strokeColor(): string {
    const alpha = Math.round(this.settings.homePillStrokeOpacity * 2.55)
    let hex = alpha.toString(16)
    if (hex.length === 1) {
      hex = `0${hex}`
    }
    const base = this.settings.homeThemeColor !== '' ? this.settings.homeThemeColor : '#84899C'
    return `#${hex}${base}`
  }

  private favRadius(): number {
    const size = Math.max(this.favSize(), this.favHeight())
    return size / 2 * (this.settings.homeFavCorner / 100)
  }

  private favColor(item: BookmarkRec): string {
    if (HOME_FAV_SHADOWS[this.settings.homeFavShadow] === '凄暗') {
      return HOME_FAV_DIM_COLOR
    }
    const source = item.title !== '' ? item.title : item.url
    let sum = 0
    for (let i = 0; i < source.length; i++) {
      sum += source.charCodeAt(i)
    }
    return HOME_FAV_PALETTE[sum % HOME_FAV_PALETTE.length]
  }

  private showFavicon(): boolean {
    return HOME_FAV_ICON_STYLES[this.settings.homeFavIconStyle] === '图标优先'
  }

  private faviconUrl(url: string): string {
    const host = hostOf(url)
    if (host === '') {
      return ''
    }
    return `https://${host}/favicon.ico?v=${this.settings.homeIconEpoch}`
  }

  private shortLabel(title: string, url: string): string {
    const source = title.trim() !== '' ? title : hostOf(url)
    if (source === '') {
      return '书'
    }
    return source.substring(0, 1)
  }
}
