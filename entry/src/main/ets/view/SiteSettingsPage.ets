import { SiteSetting } from '../common/Types'
import { AppSettings } from '../common/Settings'
import { AppIcon } from '../components/AppIcon'
import { SettingsHeader } from '../components/SettingsHeader'

@ComponentV2
export struct SiteSettingsPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '网站设定',
          onBack: () => {
            this.navPathStack.pop()
          }
        })
        if (this.settings.siteSettings.length === 0) {
        Column() {
          Text($r('app.string.no_site_settings'))
            .fontSize(14)
            .fontColor($r('app.color.fg_secondary'))
        }
        .width('100%')
        .height('100%')
        .justifyContent(FlexAlign.Center)
      } else {
        Scroll() {
          Column() {
            ForEach(this.settings.siteSettings, (site: SiteSetting) => {
              Column() {
                Row({ space: 12 }) {
                  AppIcon({ icon: $r('sys.symbol.link'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
                  Text(site.host)
                    .fontSize(15)
                    .fontColor($r('app.color.fg'))
                    .layoutWeight(1)
                    .maxLines(1)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                  AppIcon({ icon: $r('sys.symbol.trash'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
                    .onClick(() => {
                      this.removeSite(site)
                    })
                }
                .width('100%')
                this.SiteToggleRow($r('app.string.pc_mode'), site.pcMode, (isOn: boolean) => {
                  site.pcMode = isOn
                  this.settings.upsertSiteSetting(site)
                })
                this.SiteToggleRow($r('app.string.no_image_mode'), site.noImage, (isOn: boolean) => {
                  site.noImage = isOn
                  this.settings.upsertSiteSetting(site)
                })
                this.SiteToggleRow($r('app.string.allowlist'), site.allowAds, (isOn: boolean) => {
                  site.allowAds = isOn
                  this.settings.upsertSiteSetting(site)
                })
                this.SiteToggleRow($r('app.string.night_mode'), site.forceDark, (isOn: boolean) => {
                  site.forceDark = isOn
                  this.settings.upsertSiteSetting(site)
                })
              }
              .width('100%')
              .padding({ left: 16, right: 16, top: 12, bottom: 12 })
              .margin({ bottom: 8 })
              .borderRadius(12)
              .backgroundColor($r('app.color.surface'))
            }, (site: SiteSetting) => site.host)
          }
          .width('100%')
          .padding(12)
        }
          .width('100%')
          .layoutWeight(1)
          .align(Alignment.Top)
        }
      }
      .width('100%')
      .height('100%')
    }
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }

  @Builder
  SiteToggleRow(label: Resource, isOn: boolean, change: (isOn: boolean) => void) {
    Row({ space: 12 }) {
      Text(label)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .layoutWeight(1)
      Toggle({ type: ToggleType.Switch, isOn: isOn })
        .onChange((value: boolean) => {
          change(value)
        })
    }
    .width('100%')
    .height(40)
  }

  private removeSite(site: SiteSetting): void {
    this.settings.removeSiteSetting(site.host)
  }
}

@Builder
export function SiteSettingsPageBuilder() {
  SiteSettingsPage()
}
