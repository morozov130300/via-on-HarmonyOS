import { common } from '@kit.AbilityKit'
import { AppSettings } from '../common/Settings'
import { TabStore } from '../common/TabStore'
import { BrowserDb } from '../common/Database'
import { SiteSetting } from '../common/Types'
import { hostOf } from '../common/SearchEngines'
import { ViaIcon } from './ViaIcon'

@ComponentV2
export struct MenuSheet {
  @Event onClose: () => void = () => {}
  @Event onOpenPage: (page: string) => void = (page: string) => {}
  @Event onFindInPage: () => void = () => {}
  @Event onShare: () => void = () => {}
  @Event onSavePage: () => void = () => {}
  private settings: AppSettings = AppSettings.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  @Local showToolbox: boolean = false

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
        if (this.showToolbox) {
          this.ToolboxPanel()
        } else {
          this.MainGrid()
          this.HandleBar()
          this.BottomRow()
        }
      }
      .width('100%')
      .backgroundColor($r('app.color.menu_bg'))
    }
    .width('100%')
    .height('100%')
  }

  @Builder
  MainGrid() {
    Grid() {
      GridItem() {
        this.GridCell($r('app.media.via_ic_bookmark'), $r('app.string.bookmarks'), () => {
          this.onOpenPage('bookmarks')
        })
      }
      GridItem() {
        this.GridCell($r('app.media.via_ic_history'), $r('app.string.history'), () => {
          this.onOpenPage('history')
        })
      }
      GridItem() {
        this.GridCell($r('app.media.via_ic_download'), $r('app.string.downloads'), () => {
          this.onOpenPage('downloads')
        })
      }
      GridItem() {
        this.GridCell($r('app.media.via_ic_incognito'), $r('app.string.incognito'), () => {
          this.openIncognito()
        })
      }
      GridItem() {
        this.GridCell($r('app.media.via_ic_share'), $r('app.string.share'), () => {
          this.onClose()
          this.onShare()
        })
      }
      GridItem() {
        this.GridCell($r('app.media.via_ic_add_bookmark'), $r('app.string.add_bookmark'), () => {
          this.addBookmark()
        })
      }
      GridItem() {
        this.GridCell($r('app.media.via_ic_pc_mode'), $r('app.string.pc_mode'), () => {
          this.toggleSitePcMode()
        })
      }
      GridItem() {
        this.GridCellBody($r('app.media.via_ic_save'), $r('app.string.save'), !this.tabStore.current().isHomePage(), () => {
          this.onClose()
          this.onSavePage()
        })
      }
      GridItem() {
        this.GridCell($r('app.media.via_ic_toolbox'), $r('app.string.toolbox'), () => {
          this.showToolbox = true
        })
      }
      GridItem() {
        this.GridCell($r('app.media.via_ic_settings'), $r('app.string.settings'), () => {
          this.onOpenPage('settings')
        })
      }
    }
    .columnsTemplate('1fr 1fr 1fr 1fr 1fr')
    .rowsTemplate('1fr 1fr')
    .width('100%')
    .height(130)
  }

  @Builder
  ToolboxPanel() {
    Column() {
      Grid() {
        GridItem() {
          this.GridCell($r('app.media.via_ic_find'), $r('app.string.find_in_page'), () => {
            this.onClose()
            this.onFindInPage()
          })
        }
        GridItem() {
          this.GridCell($r('app.media.via_ic_offline'), $r('app.string.offline_page'), () => {
            this.notImplemented()
          })
        }
        GridItem() {
          this.GridCell($r('app.media.via_ic_translate'), $r('app.string.translate'), () => {
            this.notImplemented()
          })
        }
        GridItem() {
          this.GridCell($r('app.media.via_ic_add_to_desktop'), $r('app.string.add_to_desktop'), () => {
            this.notImplemented()
          })
        }
        GridItem() {
          this.GridCell($r('app.media.via_ic_script'), $r('app.string.scripts'), () => {
            this.onOpenPage('userScripts')
          })
        }
        GridItem() {
          this.GridCell($r('app.media.via_ic_adblock'), $r('app.string.ad_block'), () => {
            this.onOpenPage('rules')
          })
        }
        GridItem() {
          this.GridCell($r('app.media.via_ic_ai'), $r('app.string.ai'), () => {
            this.notImplemented()
          })
        }
        GridItem() {
          this.GridCell($r('app.media.via_ic_print'), $r('app.string.print_pdf'), () => {
            this.notImplemented()
          })
        }
        GridItem() {
          this.GridCell($r('app.media.via_ic_ua'), $r('app.string.browser_ua'), () => {
            this.notImplemented()
          })
        }
        GridItem() {
          this.GridCell($r('app.media.via_ic_netlog'), $r('app.string.net_log'), () => {
            this.notImplemented()
          })
        }
      }
      .columnsTemplate('1fr 1fr 1fr 1fr 1fr')
      .rowsTemplate('1fr 1fr')
      .width('100%')
      .height(130)

      this.HandleBar()
    }
    .width('100%')
  }

  @Builder
  GridCell(icon: Resource, label: Resource, action: () => void) {
    this.GridCellBody(icon, label, true, action)
  }

  @Builder
  GridCellBody(icon: Resource, label: Resource, enabled: boolean, action: () => void) {
    Column({ space: 4 }) {
      ViaIcon({ icon: icon, iconSize: 24, iconColor: $r('app.color.menu_icon') })
      Text(label)
        .fontSize(11)
        .fontColor($r('app.color.menu_text'))
        .maxLines(1)
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .alignItems(HorizontalAlign.Center)
    .opacity(enabled ? 1 : 0.3)
    .onClick(() => {
      if (enabled) {
        action()
      }
    })
  }

  @Builder
  HandleBar() {
    Column() {
      Divider()
        .strokeWidth(3)
        .color('#4A494B')
        .width(28)
        .borderRadius(2)
    }
    .width('100%')
    .height(14)
    .alignItems(HorizontalAlign.Center)
    .margin({ top: 2 })
  }

  @Builder
  BottomRow() {
    Row() {
      Blank()
      Column() {
        ViaIcon({ icon: $r('app.media.via_ic_exit'), iconSize: 22, iconColor: $r('app.color.menu_icon') })
      }
      .width(72)
      .height(38)
      .justifyContent(FlexAlign.Center)
      .alignItems(HorizontalAlign.Center)
      .onClick(() => {
        this.exitApp()
      })

      Column() {
        ViaIcon({ icon: $r('app.media.via_ic_cancel'), iconSize: 22, iconColor: $r('app.color.menu_icon') })
      }
      .width(72)
      .height(38)
      .justifyContent(FlexAlign.Center)
      .alignItems(HorizontalAlign.Center)
      .onClick(() => {
        this.onClose()
      })
    }
    .width('100%')
    .height(38)
    .alignItems(VerticalAlign.Center)
  }

  private notImplemented(): void {
    this.onClose()
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.feature_wip'), duration: 1500 })
  }

  private openIncognito(): void {
    this.onClose()
    this.tabStore.newTab(true)
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.entered_incognito'), duration: 1500 })
  }

  private exitApp(): void {
    this.tabStore.snapshot(this.settings)
    this.settings.persistAdBlockTotal()
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    context.terminateSelf()
  }

  private toggleSitePcMode(): void {
    const host = hostOf(this.tabStore.current().url)
    if (host === '') {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.feature_wip'), duration: 1500 })
      return
    }
    const existing = this.settings.getSiteSetting(host)
    const setting: SiteSetting = existing !== null ? existing : new SiteSetting(host)
    setting.pcMode = !setting.pcMode
    this.settings.upsertSiteSetting(setting)
    try {
      this.tabStore.current().controller.refresh()
    } catch (error) {
      console.error('refresh after pc mode failed')
    }
    this.onClose()
  }

  private addBookmark(): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      return
    }
    const title = tab.title !== '' ? tab.title : hostOf(tab.url)
    BrowserDb.getInstance().addBookmark(title, tab.url).then(() => {
      this.onClose()
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.bookmark_added'), duration: 1500 })
    }).catch((error: BusinessError) => {
      console.error(`add bookmark failed: ${error.message}`)
    })
  }
}
