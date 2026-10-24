import { AppSettings } from '../common/Settings'
import { TabStore } from '../common/TabStore'
import { hostOf } from '../common/SearchEngines'
import { AppIcon } from './AppIcon'

class QuickSite {
  name: string
  url: string
  color: string
  initial: string

  constructor(name: string, url: string, color: string, initial: string) {
    this.name = name
    this.url = url
    this.color = color
    this.initial = initial
  }
}

const QUICK_SITES: QuickSite[] = [
  new QuickSite('百度', 'https://www.baidu.com', '#2932E1', '百'),
  new QuickSite('知乎', 'https://www.zhihu.com', '#0084FF', '知'),
  new QuickSite('微博', 'https://weibo.com', '#E6162D', '微'),
  new QuickSite('哔哩哔哩', 'https://www.bilibili.com', '#FB7299', 'B'),
  new QuickSite('淘宝', 'https://www.taobao.com', '#FF5000', '淘'),
  new QuickSite('京东', 'https://www.jd.com', '#E1251B', '京'),
  new QuickSite('网易', 'https://www.163.com', '#DD1A21', '网'),
  new QuickSite('腾讯', 'https://www.qq.com', '#12B7F5', '腾')
]

@ComponentV2
export struct HomePage {
  private settings: AppSettings = AppSettings.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  @Event onSearchTap: () => void = () => {}

  build() {
    Column({ space: 28 }) {
      Blank()
      Column({ space: 12 }) {
        Image($rawfile('logo.svg'))
          .width(64)
          .height(64)
        Text($r('app.string.logo_slogan'))
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
      }
      Row() {
        Row({ space: 8 }) {
          AppIcon({ icon: $r('sys.symbol.magnifyingglass'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
          Text($r('app.string.search_or_type_url'))
            .fontSize(15)
            .fontColor($r('app.color.fg_secondary'))
        }
        .height(44)
        .padding({ left: 16, right: 16 })
        .backgroundColor($r('app.color.surface'))
        .borderRadius(22)
        .constraintSize({ minWidth: '60%' })
        .onClick(() => {
          this.onSearchTap()
        })
      }
      .width('100%')
      .justifyContent(FlexAlign.Center)

      Flex({ wrap: FlexWrap.Wrap, justifyContent: FlexAlign.Center }) {
        ForEach(QUICK_SITES, (site: QuickSite) => {
          Column({ space: 6 }) {
            Text(site.initial)
              .fontSize(20)
              .fontColor(Color.White)
              .width(48)
              .height(48)
              .textAlign(TextAlign.Center)
              .borderRadius(24)
              .backgroundColor(site.color)
            Text(site.name)
              .fontSize(12)
              .fontColor($r('app.color.fg_secondary'))
              .maxLines(1)
          }
          .width('25%')
          .padding({ top: 8, bottom: 8 })
          .onClick(() => {
            this.tabStore.navigate(site.url)
          })
        }, (site: QuickSite) => site.url)
      }
      .width('90%')

      Blank()
      Text($r('app.string.blocked_ads_count', this.settings.adBlockTotal))
        .fontSize(12)
        .fontColor($r('app.color.fg_secondary'))
        .padding({ bottom: 8 })
    }
    .width('100%')
    .height('100%')
    .backgroundColor($r('app.color.page_bg'))
  }
}
