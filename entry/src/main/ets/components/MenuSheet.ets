import { promptAction } from '@kit.ArkUI'
import { AppSettings } from '../common/Settings'
import { TabStore } from '../common/TabStore'
import { BrowserDb } from '../common/Database'
import { SiteSetting } from '../common/Types'
import { hostOf } from '../common/SearchEngines'
import { AppIcon } from './AppIcon'

@ComponentV2
export struct MenuSheet {
  @Event onClose: () => void = () => {}
  @Event onOpenPage: (page: string) => void = (page: string) => {}
  private settings: AppSettings = AppSettings.getInstance()
  private tabStore: TabStore = TabStore.getInstance()

  build() {
    Stack({ alignContent: Alignment.Bottom }) {
      Column()
        .width('100%')
        .height('100%')
        .backgroundColor('rgba(0,0,0,0.35)')
        .onClick(() => {
          this.onClose()
        })

      Column() {
        Scroll() {
          Column() {
            this.MenuRow($r('sys.symbol.arrow_clockwise'), $r('app.string.refresh'), () => {
              try {
                this.tabStore.current().controller.refresh()
              } catch (error) {
                console.error('refresh failed')
              }
              this.onClose()
            })
            this.MenuRow($r('sys.symbol.house'), $r('app.string.home_page'), () => {
              this.tabStore.gotoHome()
              this.onClose()
            })
            this.MenuRow($r('sys.symbol.bookmark'), $r('app.string.add_bookmark'), () => {
              this.addBookmark()
              this.onClose()
            })
            this.MenuRow($r('sys.symbol.bookmark_fill'), $r('app.string.bookmarks'), () => {
              this.onOpenPage('bookmarks')
            })
            this.MenuRow($r('sys.symbol.clock'), $r('app.string.history'), () => {
              this.onOpenPage('history')
            })
            this.MenuRow($r('sys.symbol.download'), $r('app.string.downloads'), () => {
              this.onOpenPage('downloads')
            })
            this.ToggleRow($r('sys.symbol.moon'), $r('app.string.night_mode'), this.settings.nightMode, (isOn: boolean) => {
              this.settings.setNightMode(isOn)
            })
            this.ToggleRow($r('sys.symbol.eye_slash'), $r('app.string.no_image_mode'), this.settings.noImage, (isOn: boolean) => {
              this.settings.setNoImage(isOn)
            })
            this.ToggleRow($r('sys.symbol.display'), $r('app.string.pc_mode'), this.sitePcMode(), (isOn: boolean) => {
              this.toggleSitePcMode(isOn)
            })
            this.MenuRow($r('sys.symbol.gearshape'), $r('app.string.settings'), () => {
              this.onOpenPage('settings')
            })
          }
          .width('100%')
        }
        .layoutWeight(1)
        .align(Alignment.Top)

        Text($r('app.string.blocked_ads_count', this.settings.adBlockTotal))
          .fontSize(12)
          .fontColor($r('app.color.fg_secondary'))
          .padding({ top: 6, bottom: 10 })
      }
      .width('100%')
      .height('60%')
      .backgroundColor($r('app.color.page_bg'))
      .borderRadius({ topLeft: 16, topRight: 16 })
      .padding({ top: 6 })
    }
    .width('100%')
    .height('100%')
  }

  @Builder
  MenuRow(icon: Resource, label: Resource, action: () => void) {
    Row({ space: 14 }) {
      AppIcon({ icon: icon, iconSize: 20 })
      Text(label)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .layoutWeight(1)
    }
    .width('100%')
    .height(48)
    .padding({ left: 20, right: 20 })
    .onClick(() => {
      action()
    })
  }

  @Builder
  ToggleRow(icon: Resource, label: Resource, isOn: boolean, change: (isOn: boolean) => void) {
    Row({ space: 14 }) {
      AppIcon({ icon: icon, iconSize: 20 })
      Text(label)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .layoutWeight(1)
      Toggle({ type: ToggleType.Switch, isOn: isOn })
        .onChange((value: boolean) => {
          change(value)
        })
    }
    .width('100%')
    .height(48)
    .padding({ left: 20, right: 20 })
  }

  private sitePcMode(): boolean {
    const host = hostOf(this.tabStore.current().url)
    const setting = this.settings.getSiteSetting(host)
    if (setting !== null) {
      return setting.pcMode
    }
    return false
  }

  private toggleSitePcMode(isOn: boolean): void {
    const host = hostOf(this.tabStore.current().url)
    if (host === '') {
      return
    }
    const existing = this.settings.getSiteSetting(host)
    const setting: SiteSetting = existing !== null ? existing : new SiteSetting(host)
    setting.pcMode = isOn
    this.settings.upsertSiteSetting(setting)
    try {
      this.tabStore.current().controller.refresh()
    } catch (error) {
      console.error('refresh after pc mode failed')
    }
  }

  private addBookmark(): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      return
    }
    const title = tab.title !== '' ? tab.title : hostOf(tab.url)
    BrowserDb.getInstance().addBookmark(title, tab.url).then(() => {
      promptAction.showToast({ message: $r('app.string.bookmark_added'), duration: 1500 })
    }).catch((error: BusinessError) => {
      console.error(`add bookmark failed: ${error.message}`)
    })
  }
}
