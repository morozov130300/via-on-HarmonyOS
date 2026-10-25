import { TabItem } from '../common/Types'
import { AppSettings } from '../common/Settings'
import { AdBlocker } from '../common/AdBlock'
import { BrowserDb } from '../common/Database'
import { TabStore } from '../common/TabStore'
import { DownloadCoordinator } from '../common/Downloads'
import { TabWeb } from '../components/TabWeb'
import { HomePage } from '../components/HomePage'
import { AddressBar } from '../components/AddressBar'
import { Toolbar } from '../components/Toolbar'
import { SearchOverlay } from '../components/SearchOverlay'
import { TabPanel } from '../components/TabPanel'
import { MenuSheet } from '../components/MenuSheet'
import { FindBar } from '../components/FindBar'
import { Reader } from '../common/Reader'
import { TtsManager } from '../common/Tts'
import { ReaderView } from '../components/ReaderView'
import { QrDialog } from '../components/QrDialog'
import { systemShare } from '@kit.ShareKit'
import { uniformTypeDescriptor as utd } from '@kit.ArkData'
import { common } from '@kit.AbilityKit'

const EXIT_INTERVAL: number = 2000

@Entry
@ComponentV2
struct Index {
  private settings: AppSettings = AppSettings.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  private db: BrowserDb = BrowserDb.getInstance()
  private downloads: DownloadCoordinator = DownloadCoordinator.getInstance()
  private mainNavStack: NavPathStack = new NavPathStack()
  @Local ready: boolean = false
  @Local showSearch: boolean = false
  @Local showTabPanel: boolean = false
  @Local showMenu: boolean = false
  @Local showFindBar: boolean = false
  @Local showReader: boolean = false
  @Local readerText: string = ''
  @Local showQr: boolean = false
  @Local exitHintTime: number = 0
  private tts: TtsManager = TtsManager.getInstance()

  aboutToAppear(): void {
    this.bootstrap()
  }

  aboutToDisappear(): void {
    this.tts.shutdown()
    this.tabStore.snapshot(this.settings)
    this.settings.persistAdBlockTotal()
  }

  private async bootstrap(): Promise<void> {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      console.error('host context unavailable')
      return
    }
    await this.settings.init(context)
    await this.db.init(context)
    this.downloads.register(context)
    AdBlocker.getInstance().init(this.settings)
    await this.tabStore.init(this.settings)
    this.ready = true
  }

  onBackPress(): boolean {
    if (this.showSearch) {
      this.showSearch = false
      return true
    }
    if (this.showQr) {
      this.showQr = false
      return true
    }
    if (this.showReader) {
      this.tts.stop()
      this.showReader = false
      return true
    }
    if (this.showMenu) {
      this.showMenu = false
      return true
    }
    if (this.showTabPanel) {
      this.showTabPanel = false
      return true
    }
    if (this.showFindBar) {
      this.showFindBar = false
      try {
        this.tabStore.current().controller.clearMatches()
      } catch (error) {
        console.error('clearMatches failed')
      }
      return true
    }
    const tab = this.tabStore.current()
    if (!tab.isHomePage()) {
      if (tab.canBack) {
        try {
          tab.controller.backward()
        } catch (error) {
          console.error('backward failed')
        }
        return true
      }
      this.tabStore.gotoHome()
      return true
    }
    const now = Date.now()
    if (now - this.exitHintTime < EXIT_INTERVAL) {
      return false
    }
    this.exitHintTime = now
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.press_back_again_exit'), duration: 2000 })
    return true
  }

  build() {
    Stack() {
      Navigation(this.mainNavStack) {
        Column() {
          if (this.ready) {
          Tabs({ index: this.tabStore.currentIndex }) {
            ForEach(this.tabStore.tabs, (tab: TabItem) => {
              TabContent() {
                Stack() {
                  TabWeb({ tab: tab })
                  if (tab.isHomePage()) {
                    HomePage({ onSearchTap: () => {
                      this.showSearch = true
                    } })
                  }
                }
              }
            }, (tab: TabItem) => tab.id.toString())
          }
          .scrollable(false)
          .barHeight(0)
          .animationDuration(150)
          .layoutWeight(1)
          .onChange((index: number) => {
            this.tabStore.switchTo(index)
          })

          Column() {
            if (!this.tabStore.current().isHomePage()) {
              AddressBar({ tab: this.tabStore.current(), onAddressTap: () => {
                this.showSearch = true
              } })
            }
            Toolbar({
              tab: this.tabStore.current(),
              onBack: () => {
                const tab = this.tabStore.current()
                if (tab.canBack) {
                  try {
                    tab.controller.backward()
                  } catch (error) {
                    console.error('backward failed')
                  }
                }
              },
              onForward: () => {
                const tab = this.tabStore.current()
                if (tab.canForward) {
                  try {
                    tab.controller.forward()
                  } catch (error) {
                    console.error('forward failed')
                  }
                }
              },
              onTabs: () => {
                this.showTabPanel = true
              },
              onMenu: () => {
                this.showMenu = true
              }
            })
          }
          .width('100%')
        }
      }
      .width('100%')
      .height('100%')
      .backgroundColor($r('app.color.page_bg'))
      }
      .hideTitleBar(true)
      .mode(NavigationMode.Stack)

      if (this.tabStore.current().loading) {
        Progress({ value: this.tabStore.current().progress, total: 100, type: ProgressType.Linear })
          .width('100%')
          .height(2)
          .color($r('app.color.accent'))
          .backgroundColor(Color.Transparent)
          .position({ x: 0, y: 0 })
      }

      if (this.showSearch) {
        SearchOverlay({
          initialText: this.tabStore.current().isHomePage() ? '' : this.tabStore.current().url,
          onClose: () => {
            this.showSearch = false
          }
        })
      }
      if (this.showTabPanel) {
        TabPanel({
          onClose: () => {
            this.showTabPanel = false
          }
        })
      }
      if (this.showMenu) {
        MenuSheet({
          onClose: () => {
            this.showMenu = false
          },
          onOpenPage: (page: string) => {
            this.showMenu = false
            this.openPage(page)
          },
          onFindInPage: () => {
            this.showFindBar = true
          },
          onShare: () => {
            this.shareCurrentPage()
          },
          onSavePage: () => {
            this.getUIContext().getPromptAction().showToast({ message: $r('app.string.feature_wip'), duration: 1500 })
          }
        })
      }
      if (this.showFindBar) {
        FindBar({
          tab: this.tabStore.current(),
          onClose: () => {
            this.showFindBar = false
          }
        })
          .position({ x: 0, y: 0 })
      }
      if (this.showReader) {
        ReaderView({
          content: this.readerText,
          onClose: () => {
            this.showReader = false
          },
          onSpeak: () => {
            this.tts.speak(this.readerText)
          },
          onStopSpeak: () => {
            this.tts.stop()
          }
        })
      }
      if (this.showQr) {
        QrDialog({
          url: this.tabStore.current().url,
          onClose: () => {
            this.showQr = false
          }
        })
      }
    }
    .width('100%')
    .height('100%')
  }

  private openReader(): void {
    Reader.extractText(this.tabStore.current()).then((text: string) => {
      if (text.trim() === '') {
        this.getUIContext().getPromptAction().showToast({ message: $r('app.string.page_failed_load'), duration: 1500 })
        return
      }
      this.readerText = text
      this.showReader = true
    })
  }

  private openPage(page: string): void {
    this.mainNavStack.pushPathByName(page, '', true)
  }

  private shareCurrentPage(): void {
    const tab = this.tabStore.current()
    const title = tab.title.trim() !== '' ? tab.title : tab.url
    const shareData: systemShare.SharedData = new systemShare.SharedData({
      utd: utd.UniformDataType.HYPERLINK,
      content: tab.url,
      title: title,
      description: tab.url
    })
    const controller: systemShare.ShareController = new systemShare.ShareController(shareData)
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    controller.show(context, {
      selectionMode: systemShare.SelectionMode.SINGLE,
      previewMode: systemShare.SharePreviewMode.DETAIL
    }).catch((error: BusinessError) => {
      console.error(`share failed: ${error.code} ${error.message}`)
    })
  }
}
