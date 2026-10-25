import { TabStore } from '../common/TabStore'
import { BrowserDb } from '../common/Database'
import { BookmarkRec } from '../common/Types'
import { hostOf } from '../common/SearchEngines'
import { AppSettings } from '../common/Settings'
import {
  HOME_ADV_AREAS,
  HOME_ADV_EFFECTS,
  HOME_FAV_CORNERS,
  HOME_FAV_ICON_COLORS,
  HOME_FAV_ICON_STYLES,
  HOME_FAV_PALETTE,
  HOME_FAV_SINGLE_COLOR,
  HOME_FAV_SIZE_VP,
  HOME_LOGO_COLOR,
  HOME_LOGO_FONT_VP,
  HOME_LOGO_STYLES,
  HOME_LOGO_TYPES,
  HOME_PILL_CORNER_VP,
  HOME_PILL_OPACITY_VP,
  HOME_PILL_STROKE_VP,
  HOME_PILL_STYLES
} from '../common/HomeStyle'

const HOME_BOOKMARK_LIMIT: number = 8
const HOME_PILL_HEIGHT: number = 38

@ComponentV2
export struct HomePage {
  private tabStore: TabStore = TabStore.getInstance()
  private db: BrowserDb = BrowserDb.getInstance()
  private settings: AppSettings = AppSettings.getInstance()
  @Event onSearchTap: () => void = () => {}
  @Local bookmarks: BookmarkRec[] = []

  aboutToAppear(): void {
    this.db.listBookmarks().then((items: BookmarkRec[]) => {
      this.bookmarks = items
    }).catch((error: BusinessError) => {
      console.error(`list bookmarks failed: ${error.message}`)
    })
  }

  build() {
    Column() {
      Row() {
        Text($r('app.string.home_page'))
          .fontSize(16)
          .fontColor($r('app.color.home_title'))
          .maxLines(1)
      }
      .width('100%')
      .height(38)
      .justifyContent(FlexAlign.Center)
      .alignItems(VerticalAlign.Center)

      Blank()

      if (HOME_ADV_AREAS[this.settings.homeAdvArea] === '展示') {
        Column({ space: 10 }) {
          if (HOME_LOGO_TYPES[this.settings.homeLogoType] === '文字') {
            Text(this.settings.homeLogoText)
              .fontSize(HOME_LOGO_FONT_VP[this.settings.homeLogoSize])
              .fontColor(HOME_LOGO_COLOR)
              .fontWeight(this.logoBold())
              .fontStyle(this.logoItalic())
              .maxLines(1)
          } else {
            Image($rawfile('logo.svg'))
              .width(56)
              .height(56)
          }
          Text($r('app.string.logo_slogan'))
            .fontSize(12)
            .fontColor($r('app.color.fg_secondary'))
        }

        Row() {
          Text($r('app.string.search'))
            .fontSize(15)
            .fontColor($r('app.color.search_pill_border'))
            .maxLines(1)
        }
        .height(HOME_PILL_HEIGHT)
        .padding({ left: 40, right: 40 })
        .backgroundColor($r('app.color.search_pill_bg'))
        .borderRadius(this.pillRadius())
        .opacity(this.pillOpacity())
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
                      .fontSize(HOME_FAV_SIZE_VP[this.settings.homeFavSize] * 0.43)
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
                  .width(HOME_FAV_SIZE_VP[this.settings.homeFavSize])
                  .height(HOME_FAV_SIZE_VP[this.settings.homeFavSize])
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
    .backgroundColor(this.homeBackground())
  }

  private homeBackground(): ResourceColor {
    if (this.settings.homeBgColor !== '') {
      return this.settings.homeBgColor
    }
    return $r('app.color.home_bg')
  }

  private logoBold(): FontWeight {
    const style = HOME_LOGO_STYLES[this.settings.homeLogoStyle]
    return style === '粗体' || style === '粗体 斜体' ? FontWeight.Bold : FontWeight.Normal
  }

  private logoItalic(): FontStyle {
    const style = HOME_LOGO_STYLES[this.settings.homeLogoStyle]
    return style === '斜体' || style === '粗体 斜体' ? FontStyle.Italic : FontStyle.Normal
  }

  private pillRadius(): number {
    if (HOME_PILL_STYLES[this.settings.homePillStyle] === '胶囊') {
      return HOME_PILL_HEIGHT / 2
    }
    return HOME_PILL_CORNER_VP[this.settings.homePillCorner]
  }

  private pillOpacity(): number {
    if (HOME_ADV_EFFECTS[this.settings.homeAdvEffect] === '不透明') {
      return 1
    }
    return HOME_PILL_OPACITY_VP[this.settings.homePillOpacity]
  }

  private pillBorder(): BorderOptions {
    return {
      width: HOME_PILL_STROKE_VP[this.settings.homePillStrokeWidth],
      color: this.strokeColor()
    }
  }

  private strokeColor(): string {
    const alpha = Math.round(HOME_PILL_OPACITY_VP[this.settings.homePillStrokeOpacity] * 255)
    let hex = alpha.toString(16)
    if (hex.length === 1) {
      hex = `0${hex}`
    }
    return `#${hex}84899C`
  }

  private favRadius(): number {
    const size = HOME_FAV_SIZE_VP[this.settings.homeFavSize]
    const corner = HOME_FAV_CORNERS[this.settings.homeFavCorner]
    if (corner === '100%') {
      return size / 2
    }
    if (corner === '50%') {
      return size / 4
    }
    return 0
  }

  private favColor(item: BookmarkRec): string {
    if (HOME_FAV_ICON_COLORS[this.settings.homeFavColor] === '单色') {
      return HOME_FAV_SINGLE_COLOR
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
    return `https://${host}/favicon.ico`
  }

  private shortLabel(title: string, url: string): string {
    const source = title.trim() !== '' ? title : hostOf(url)
    if (source === '') {
      return '书'
    }
    return source.substring(0, 1)
  }
}
