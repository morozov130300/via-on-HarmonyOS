import { TabItem, RuleSubEntry } from '../common/Types'
import { AppSettings, applyOrientationSetting } from '../common/Settings'
import { AdBlocker } from '../common/AdBlock'
import { RuleSubManager } from '../common/RuleSubscriptions'
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
import { AiPanel } from '../components/AiPanel'
import { MediaListPage } from '../components/MediaListPage'
import { LinkInterstitial } from '../components/LinkInterstitial'
import { systemShare } from '@kit.ShareKit'
import { uniformTypeDescriptor as utd } from '@kit.ArkData'
import { common } from '@kit.AbilityKit'
import { webview } from '@kit.ArkWeb'
import { window } from '@kit.ArkUI'
import { fileIo } from '@kit.CoreFileKit'
import { BusinessError, emitter } from '@kit.BasicServicesKit'
import { hostOf } from '../common/SearchEngines'
import { UiInsets, applyStatusBarVisible } from '../common/Immersive'

const EXIT_INTERVAL: number = 2000
const SHORTCUT_URL_EVENT_ID = 10001
const EXTERNAL_LINK_EVENT_ID = 10002

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

  @Local showAi: boolean = false
  @Local showReader: boolean = false
  @Local showMediaList: boolean = false
  @Local mediaList: string[] = []
  @Local readerText: string = ''
  @Local exitHintTime: number = 0
  @Local showLinkConfirm: boolean = false
  @Local linkConfirmUrl: string = ''
  private tts: TtsManager = TtsManager.getInstance()
  private insets: UiInsets = UiInsets.getInstance()

  aboutToAppear(): void {
    this.bootstrap()
    emitter.on({ eventId: SHORTCUT_URL_EVENT_ID }, (event: emitter.EventData) => {
      const data = event.data as Record<string, Object>
      const viaUrl = data['viaUrl']
      if (typeof viaUrl === 'string' && viaUrl !== '') {
        this.tabStore.navigate(viaUrl)
      }
    })
    emitter.on({ eventId: EXTERNAL_LINK_EVENT_ID }, (event: emitter.EventData) => {
      const data = event.data as Record<string, Object>
      const linkUrl = data['linkUrl']
      const external = data['external']
      if (typeof linkUrl === 'string' && linkUrl !== '') {
        this.openExternalLink(linkUrl, external !== false)
      }
    })
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
    this.setupImmersiveWindow()
    applyOrientationSetting(context)
    await this.db.init(context)
    this.downloads.register(context)
    AdBlocker.getInstance().init(this.settings)
    RuleSubManager.getInstance().loadEnabledInto(context, this.settings.ruleSubscriptions, AdBlocker.getInstance()).then(() => {
      RuleSubManager.getInstance().maybeAutoUpdate(context, this.settings.ruleSubscriptions, this.settings.ruleAutoUpdate).then((updated: RuleSubEntry[] | null) => {
        if (updated !== null) {
          for (let i = 0; i < updated.length; i++) {
            this.settings.updateRuleSubEntry(updated[i].key, updated[i].ruleCount, updated[i].lastUpdate)
          }
          RuleSubManager.getInstance().loadEnabledInto(context, this.settings.ruleSubscriptions, AdBlocker.getInstance())
        }
      })
    })
    await this.tabStore.init(this.settings)
    this.ready = true
    const launchUrl = AppStorage.get<string>('via_launch_url') ?? ''
    if (launchUrl !== '') {
      AppStorage.setOrCreate('via_launch_url', '')
      const launchExternal = AppStorage.get<boolean>('via_launch_external') ?? false
      AppStorage.setOrCreate('via_launch_external', false)
      this.openExternalLink(launchUrl, launchExternal)
    }
  }

  private openExternalLink(url: string, external: boolean): void {
    if (!external || this.settings.disableCustomTabs) {
      this.tabStore.navigate(url)
      return
    }
    this.linkConfirmUrl = url
    this.showLinkConfirm = true
  }

  private setupImmersiveWindow(): void {
    const win = AppStorage.get<window.Window>('mainWindow')
    if (win === undefined) {
      return
    }
    applyStatusBarVisible(win, this.settings.showStatusBar)
    this.insets.refresh(win)
    try {
      win.on('avoidAreaChange', () => {
        this.insets.refresh(win)
      })
    } catch (error) {
      console.error('watch avoidAreaChange failed')
    }
  }

  onBackPress(): boolean {
    if (this.showLinkConfirm) {
      this.showLinkConfirm = false
      this.linkConfirmUrl = ''
      return true
    }
    if (this.showMediaList) {
      this.showMediaList = false
      return true
    }
    if (this.showSearch) {
      this.showSearch = false
      return true
    }
    if (this.showAi) {
      this.showAi = false
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
                  TabWeb({ tab: tab, onAutoReader: (text: string) => {
                    this.readerText = text
                    this.showReader = true
                  } })
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
              }, onOpenMedia: (urls: string[]) => {
                this.mediaList = urls
                this.showMediaList = true
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
          .padding({ bottom: 6 + this.insets.bottom })
          .backgroundColor($r('app.color.home_bg'))
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
          .position({ x: 0, y: this.insets.top })
      }

      if (this.showSearch) {
        Column() {
          SearchOverlay({
            initialText: this.tabStore.current().isHomePage() ? '' : this.tabStore.current().url,
            onClose: () => {
              this.showSearch = false
            }
          })
        }
        .width('100%')
        .height('100%')
        .padding({ top: this.insets.top })
        .backgroundColor($r('app.color.page_bg'))
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
            this.saveCurrentPageAsPdf()
          },
          onOpenAi: () => {
            this.showAi = true
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
          .position({ x: 0, y: this.insets.top })
      }
      if (this.showReader) {
        Column() {
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
        .width('100%')
        .height('100%')
        .padding({ top: this.insets.top })
        .backgroundColor($r('app.color.page_bg'))
      }
      if (this.showAi) {
        Column() {
          AiPanel({
            onClose: () => {
              this.showAi = false
            }
          })
        }
        .width('100%')
        .height('100%')
        .padding({ top: this.insets.top })
        .backgroundColor($r('app.color.page_bg'))
      }
      if (this.showMediaList) {
        MediaListPage({
          mediaUrls: this.mediaList,
          onClose: () => {
            this.showMediaList = false
          }
        })
      }
      if (this.showLinkConfirm) {
        LinkInterstitial({
          linkUrl: this.linkConfirmUrl,
          onConfirm: () => {
            const url = this.linkConfirmUrl
            this.showLinkConfirm = false
            this.linkConfirmUrl = ''
            this.tabStore.navigate(url)
          },
          onClose: () => {
            this.showLinkConfirm = false
            this.linkConfirmUrl = ''
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

  private saveCurrentPageAsPdf(): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      return
    }
    const pdfConfig: webview.PdfConfiguration = {
      width: 8.27,
      height: 11.69,
      marginTop: 0,
      marginBottom: 0,
      marginRight: 0,
      marginLeft: 0,
      shouldPrintBackground: true
    }
    tab.controller.createPdf(pdfConfig).then((result: webview.PdfData) => {
      try {
        const context = this.getUIContext().getHostContext() as common.UIAbilityContext
        const filePath = `${context.filesDir}/${hostOf(tab.url)}.pdf`
        const file = fileIo.openSync(filePath, fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE)
        fileIo.write(file.fd, result.pdfArrayBuffer().buffer).then((writeLen: number) => {
          this.getUIContext().getPromptAction().showToast({ message: $r('app.string.page_saved'), duration: 1500 })
        }).catch((error: BusinessError) => {
          console.error(`write pdf failed: ${error.message}`)
        }).finally(() => {
          fileIo.closeSync(file)
        })
      } catch (error) {
        console.error('save pdf failed')
      }
    }).catch((error: BusinessError) => {
      console.error(`create pdf failed: ${error.message}`)
    })
  }
}
