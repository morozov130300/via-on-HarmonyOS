import { TabItem, RuleSubEntry } from '../common/Types'
import { AppSettings, applyOrientationSetting } from '../common/Settings'
import { AdBlocker } from '../common/AdBlock'
import { RuleSubManager } from '../common/RuleSubscriptions'
import { BrowserDb } from '../common/Database'
import { TabStore, OPEN_BOOKMARKS_EVENT_ID } from '../common/TabStore'
import { DownloadCoordinator, DOWNLOAD_CONFIRM_EVENT_ID } from '../common/Downloads'
import { TabWeb } from '../components/TabWeb'
import { HomePage } from '../components/HomePage'
import { AddressBar } from '../components/AddressBar'
import { Toolbar } from '../components/Toolbar'
import { SearchOverlay } from '../components/SearchOverlay'
import { SearchToolbar } from '../components/SearchToolbar'
import { TabPanel } from '../components/TabPanel'
import { AppBarHeader } from '../components/AppBar'
import { MenuSheet, TRANSLATE_INJECT_JS } from '../components/MenuSheet'
import { FindBar } from '../components/FindBar'
import { Reader, READER_THEME_COLORS } from '../common/Reader'
import { TtsManager } from '../common/Tts'
import { AiPanel } from '../components/AiPanel'
import { MediaListPage } from '../components/MediaListPage'
import { LinkInterstitial } from '../components/LinkInterstitial'
import { systemShare } from '@kit.ShareKit'
import { uniformTypeDescriptor as utd } from '@kit.ArkData'
import { common } from '@kit.AbilityKit'
import { webview } from '@kit.ArkWeb'
import { window, mediaquery } from '@kit.ArkUI'
import { fileIo } from '@kit.CoreFileKit'
import { BusinessError, emitter, pasteboard } from '@kit.BasicServicesKit'
import { inputConsumer, KeyEvent, KeyCode } from '@kit.InputKit'
import { hostOf } from '../common/SearchEngines'
import { UiInsets, applyStatusBarVisible } from '../common/Immersive'

const EXIT_INTERVAL: number = 1500
// 原版进度条渐变（x8/h.x）：#59C2E5 → #A687E0
const PROGRESS_GRADIENT: LinearGradient = {
  angle: 90,
  colors: [['#59C2E5', 0], ['#A687E0', 1]]
}
const SHORTCUT_URL_EVENT_ID = 10001
const EXTERNAL_LINK_EVENT_ID = 10002

// 原版应用布局（Ya()）：0=传统 1=工具栏在上 2=工具栏在下 3=双行
const LAYOUT_TRADITIONAL: number = 0
const LAYOUT_TOOLBAR_TOP: number = 1
const LAYOUT_TOOLBAR_BOTTOM: number = 2
const LAYOUT_DOUBLE: number = 3

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
  @Local searchInitialText: string = ''
  @Local showTabPanel: boolean = false
  @Local showMenu: boolean = false
  @Local showFindBar: boolean = false

  @Local showAi: boolean = false
  @Local showMediaList: boolean = false
  @Local mediaList: string[] = []
  @Local exitHintTime: number = 0
  // 游戏模式双击返回退出计时
  @Local gameModeBackTime: number = 0
  @Local showLinkConfirm: boolean = false
  @Local linkConfirmUrl: string = ''
  // 下载确认弹层（原版 mark/via/download/m.java）
  @Local downloadConfirm: PendingDownloadUi | null = null
  private tts: TtsManager = TtsManager.getInstance()
  private insets: UiInsets = UiInsets.getInstance()
  @Local isLandscape: boolean = false
  private landscapeListener: mediaquery.MediaQueryListener | null = null
  // 音量键翻页（原版操作设定）：开启时消费音量上/下键滚动网页
  private volumeKeyConsumed: boolean = false
  private volumeUpFunc: (event: KeyEvent) => void = () => {
  }
  private volumeDownFunc: (event: KeyEvent) => void = () => {
  }

  @Monitor('settings.volumePageFlip')
  onVolumePageFlipChange(): void {
    this.syncVolumeKeyConsumers()
  }

  private syncVolumeKeyConsumers(): void {
    if (this.settings.volumePageFlip && !this.volumeKeyConsumed) {
      try {
        const up: inputConsumer.KeyPressedConfig = {
          key: KeyCode.KEYCODE_VOLUME_UP,
          action: 1,
          isRepeat: false
        }
        const down: inputConsumer.KeyPressedConfig = {
          key: KeyCode.KEYCODE_VOLUME_DOWN,
          action: 1,
          isRepeat: false
        }
        this.volumeUpFunc = (_event: KeyEvent) => {
          this.scrollCurrentPage(-1)
        }
        this.volumeDownFunc = (_event: KeyEvent) => {
          this.scrollCurrentPage(1)
        }
        inputConsumer.on('keyPressed', up, this.volumeUpFunc)
        inputConsumer.on('keyPressed', down, this.volumeDownFunc)
        this.volumeKeyConsumed = true
      } catch (error) {
        console.error('subscribe volume key failed')
      }
    } else if (!this.settings.volumePageFlip && this.volumeKeyConsumed) {
      try {
        inputConsumer.off('keyPressed', this.volumeUpFunc)
        inputConsumer.off('keyPressed', this.volumeDownFunc)
      } catch (error) {
        console.error('unsubscribe volume key failed')
      }
      this.volumeKeyConsumed = false
    }
  }

  // 原版音量键翻页：按一屏高度滚动当前网页
  private scrollCurrentPage(direction: number): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      return
    }
    try {
      tab.controller.runJavaScript(`window.scrollBy(0, ${direction} * window.innerHeight * 0.8)`)
    } catch (error) {
      console.error('volume page flip failed')
    }
  }

  aboutToAppear(): void {
    this.bootstrap()
    // 原版 Ya()：横屏时布局 0→1、3→2
    this.landscapeListener = this.getUIContext().getMediaQuery()
      .matchMediaSync('(orientation: landscape)')
    this.landscapeListener.on('change', (result: mediaquery.MediaQueryResult) => {
      this.isLandscape = result.matches
    })
    this.isLandscape = this.landscapeListener.matches
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
    emitter.on({ eventId: DOWNLOAD_CONFIRM_EVENT_ID }, (event: emitter.EventData) => {
      const data = event.data as Record<string, Object>
      const kind = data['kind']
      const guid = data['guid']
      const url = data['url']
      const fileName = data['fileName']
      const size = data['size']
      if (typeof url !== 'string' || typeof fileName !== 'string') {
        return
      }
      this.downloadConfirm = new PendingDownloadUi(
        kind === 'url' ? 'url' : 'web',
        typeof guid === 'string' ? guid : '',
        url,
        fileName,
        typeof size === 'number' ? size : 0
      )
    })
    // 主页模式=书签：新标签打开书签页（原版 via://bookmark）
    emitter.on({ eventId: OPEN_BOOKMARKS_EVENT_ID }, () => {
      this.openPage('bookmarks')
    })
  }

  aboutToDisappear(): void {
    if (this.landscapeListener !== null) {
      this.landscapeListener.off('change')
      this.landscapeListener = null
    }
    this.tts.shutdown()
    this.syncVolumeKeyConsumers()
    this.tabStore.snapshot(this.settings)
    this.settings.persistAdBlockTotal()
  }

  // 原版 z8/b0.Q()：v://（via://）内部命令分发（tabs/bookmarks/history 等）
  private handleInternalCmd(): void {
    const cmd = AppStorage.get<string>('via_internal_cmd') ?? ''
    if (cmd === '') {
      return
    }
    AppStorage.setOrCreate('via_internal_cmd', '')
    if (cmd === 'tabs') {
      this.showTabPanel = true
    } else if (cmd === 'bookmarks') {
      this.openPage('bookmarks')
    } else if (cmd === 'history') {
      this.openPage('history')
    }
  }

  // 原版 restoreclosedtabs=2：启动时优先询问是否恢复未关闭标签
  private askPendingRestore(): void {
    const pending = AppStorage.get<string>('via_pending_restore_tabs') ?? ''
    if (pending === '') {
      return
    }
    AppStorage.setOrCreate('via_pending_restore_tabs', '')
    this.getUIContext().showAlertDialog({
      message: $r('app.string.restore_session_ask'),
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: $r('app.string.restore_btn'),
        action: () => {
          this.tabStore.restoreFromSnapshot(this.settings)
        }
      },
      cancel: () => {
      },
      autoCancel: false
    })
  }

  private async bootstrap(): Promise<void> {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      console.error('host context unavailable')
      return
    }
    await this.settings.init(context)
    this.syncVolumeKeyConsumers()
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
    this.handleInternalCmd()
    this.askPendingRestore()
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
    applyStatusBarVisible(win, this.settings.showStatusBar && !this.settings.fullScreen)
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
    // 原版游戏模式：1500ms 内双击退出，首次提示 R5「再按一次返回键退出游戏模式」，第二次 bb(false) 关闭
    if (this.settings.gameMode) {
      const now = Date.now()
      if (now - this.gameModeBackTime < 1500) {
        this.gameModeBackTime = 0
        this.settings.setGameMode(false)
        this.getUIContext().getPromptAction().showToast({ message: $r('app.string.game_mode_toast_off'), duration: 1500 })
      } else {
        this.gameModeBackTime = now
        this.getUIContext().getPromptAction().showToast({ message: $r('app.string.press_back_again_exit_game_mode'), duration: 1500 })
      }
      return true
    }
    const tab = this.tabStore.current()
    // 原版隐身会话（f2583n1）：可后退则后退，多标签开标签面板，否则结束会话
    if (this.tabStore.sessionIncognito && tab.incognito) {
      if (tab.canBack) {
        try {
          tab.controller.backward()
        } catch (error) {
          console.error('backward failed')
        }
        return true
      }
      if (this.tabStore.tabs.length > 1) {
        this.showTabPanel = true
        return true
      }
      this.tabStore.exitIncognitoSession(false)
      return true
    }
    if (!tab.isHomePage()) {
      // 原版 U8：可后退则后退；不可后退且非主页 → 关闭当前标签（f2580m0.B0()）
      if (tab.canBack) {
        try {
          tab.controller.backward()
        } catch (error) {
          console.error('backward failed')
        }
        return true
      }
      this.tabStore.closeTab(this.tabStore.currentIndex)
      return true
    }
    const now = Date.now()
    if (now - this.exitHintTime < EXIT_INTERVAL) {
      return false
    }
    this.exitHintTime = now
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.press_back_again_exit'), duration: 1500 })
    return true
  }

  // 原版 k6.h 粘贴项：剪贴板文本经 AppStorage 传递后带入搜索输入框
  private addressTapInitialText(): string {
    const paste = AppStorage.get<string>('via_paste_url') ?? ''
    if (paste !== '') {
      AppStorage.setOrCreate('via_paste_url', '')
      return paste
    }
    const tab = this.tabStore.current()
    return tab.isHomePage() ? '' : tab.url
  }

  private bottomBg(): ResourceColor {
    if (this.tabStore.current().isHomePage() && this.settings.homeBgColor !== '') {
      // 原版夜间联动：自设背景色经黑滤镜后用于工具栏
      return this.settings.nightBlend(this.settings.homeBgColor)
    }
    return $r('app.color.home_bg')
  }

  // 原版 Ya()：横屏时布局 0→1、3→2
  private effectiveLayout(): number {
    const layout = this.settings.appLayout
    if (!this.isLandscape) {
      return layout
    }
    if (layout === LAYOUT_TRADITIONAL) {
      return LAYOUT_TOOLBAR_TOP
    }
    if (layout === LAYOUT_DOUBLE) {
      return LAYOUT_TOOLBAR_BOTTOM
    }
    return layout
  }

  @Builder
  TopBarArea() {
    if (this.effectiveLayout() === LAYOUT_TRADITIONAL) {
      Column() {
        AddressBar({
          tab: this.tabStore.current(),
          style: 'plain',
          onAddressTap: () => {
            // 原版主页地址栏保留，点击进搜索且不带文本
            this.searchInitialText = this.addressTapInitialText()
            this.showSearch = true
          },
          onOpenMedia: (urls: string[]) => {
            this.mediaList = urls
            this.showMediaList = true
          },
          onSiteInfo: () => {
            this.openPage('siteSettings')
          },
          onScan: () => {
            this.searchInitialText = ''
            this.showSearch = true
          }
        })
        // 原版 k6.Rb：搜索工具栏挂在网页容器之后（传统布局即地址栏下）
        SearchToolbar({
          tab: this.tabStore.current(),
          onOpenSettings: () => {
            this.openPage('settingsSearch')
          }
        })
      }
      .padding({ top: this.insets.top })
      .backgroundColor(this.bottomBg())
    } else if (this.effectiveLayout() === LAYOUT_TOOLBAR_TOP) {
      Column() {
        this.ChromeToolbar(true)
        // 原版：工具栏上布局时搜索工具栏同样在顶栏区之下（m.n 命中才显示）
        SearchToolbar({
          tab: this.tabStore.current(),
          onOpenSettings: () => {
            this.openPage('settingsSearch')
          }
        })
      }
      .padding({ top: this.insets.top })
    }
  }

  @Builder
  BottomBarArea() {
    if (this.effectiveLayout() === LAYOUT_TOOLBAR_TOP) {
      Column()
        .height(6 + this.insets.bottom)
    } else if (this.effectiveLayout() === LAYOUT_TOOLBAR_BOTTOM) {
      Column() {
        this.ChromeToolbar(true)
      }
      .padding({ bottom: this.insets.bottom })
    } else if (this.effectiveLayout() === LAYOUT_DOUBLE) {
      Column() {
        // 原版主页地址栏保留（uiautomator home.xml 实证），点击进搜索不带文本
        AddressBar({
          tab: this.tabStore.current(),
          style: 'pill',
          onAddressTap: () => {
            this.searchInitialText = this.addressTapInitialText()
            this.showSearch = true
          },
          onOpenMedia: (urls: string[]) => {
            this.mediaList = urls
            this.showMediaList = true
          },
          onSiteInfo: () => {
            this.openPage('siteSettings')
          },
          onScan: () => {
            this.searchInitialText = ''
            this.showSearch = true
          }
        })
        this.ChromeToolbar(false)
      }
      .padding({ bottom: this.insets.bottom })
    } else {
      Column() {
        this.ChromeToolbar(false)
      }
      .padding({ bottom: this.insets.bottom })
    }
  }

  @Builder
  ChromeToolbar(embedAddress: boolean) {
    Toolbar({
      tab: this.tabStore.current(),
      embedAddress: embedAddress,
      onOpenSearch: () => {
        this.searchInitialText = this.tabStore.current().isHomePage() ? '' : this.tabStore.current().url
        this.showSearch = true
      },
      onOpenBookmarks: () => {
        this.openPage('bookmarks')
      },
      onOpenHistory: () => {
        this.openPage('history')
      },
      onSiteInfoLong: () => {
        this.openPage('siteSettings')
      },
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
      onHome: () => {
        if (!this.tabStore.current().isHomePage()) {
          this.tabStore.gotoHome()
        }
      },
      onTabs: () => {
        this.showTabPanel = true
      },
      onMenu: () => {
        this.showMenu = true
      },
      onAddressTap: () => {
        this.searchInitialText = this.tabStore.current().isHomePage() ? '' : this.tabStore.current().url
        this.showSearch = true
      },
      onOpenMedia: (urls: string[]) => {
        this.mediaList = urls
        this.showMediaList = true
      },
      // 原版 v4.b 动作中需要页面级能力的项
      onCommand: (cmd: string) => {
        this.handleToolbarCommand(cmd)
      }
    })
  }

  private handleToolbarCommand(cmd: string): void {
    const tab = this.tabStore.current()
    switch (cmd) {
      case 'addBookmark':
        if (!tab.isHomePage() && tab.url !== '') {
          this.db.addBookmark(tab.title, tab.url).then(() => {
            this.getUIContext().getPromptAction().showToast({ message: $r('app.string.bookmark_added') })
          })
        }
        break
      case 'find':
        this.showFindBar = true
        break
      case 'translate':
        try {
          tab.controller.runJavaScript(TRANSLATE_INJECT_JS)
        } catch (error) {
          console.error('inject translator failed')
        }
        break
      case 'savePage':
        this.saveCurrentPageAsPdf()
        break
      case 'viewSource':
        try {
          tab.controller.runJavaScript('document.documentElement.outerHTML',
            (error: BusinessError, result: string) => {
              if (error) {
                console.error(`get source failed: ${error.code}`)
                return
              }
              const context = this.getUIContext().getHostContext()
              if (context === undefined) {
                return
              }
              try {
                const path = `${context.cacheDir}/via_view_source.html`
                const file = fileIo.openSync(path,
                  fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE | fileIo.OpenMode.TRUNC)
                fileIo.writeSync(file.fd, result)
                fileIo.closeSync(file)
                this.tabStore.newTabAt(`file://${path}`, false)
              } catch (ioError) {
                console.error('write view source failed')
              }
            })
        } catch (error) {
          console.error('runJavaScript view source failed')
        }
        break
      case 'tts': {
        // 原版朗读：提取当前页正文（阅读模式中取 via-reader-body 文本）
        const ttsTab = this.tabStore.current()
        Reader.extractText(ttsTab).then((text: string) => {
          if (text.trim() === '') {
            this.getUIContext().getPromptAction().showToast({
              message: $r('app.string.page_failed_load'), duration: 1500
            })
            return
          }
          this.tts.speak(text)
        })
        break
      }
      case 'reader':
        this.toggleReader()
        // 原版 n0.v(true)：阅读模式触发地址栏左图标脉冲
        emitter.emit({ eventId: 30001 })
        break
      case 'settings':
        this.openPage('settingsGeneral')
        break
      case 'downloads':
        this.openPage('downloads')
        break
      case 'ai':
        this.showAi = true
        break
      default:
        break
    }
  }

  build() {
    Stack() {
      Navigation(this.mainNavStack) {
        Column() {
          if (this.ready) {
          if (!this.settings.gameMode) {
            this.TopBarArea()
          }
          Tabs({ index: this.tabStore.currentIndex }) {
            ForEach(this.tabStore.tabs, (tab: TabItem) => {
              TabContent() {
                Stack() {
                  TabWeb({ tab: tab })
                  if (tab.isHomePage()) {
                    HomePage({
                      searchOpen: this.showSearch,
                      onSearchTap: () => {
                        this.searchInitialText = ''
                        this.showSearch = true
                      },
                      onScanResult: (text: string) => {
                        this.searchInitialText = text
                        this.showSearch = true
                      },
                      onLogoTap: () => {
                        // 原版 logo 点击 via.cmd(257)→ja(true)→aa(null)：打开书签管理页（RecordContainerFragment 标签 1）
                        this.openPage('bookmarks')
                      }
                    })
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

          if (!this.settings.gameMode) {
            this.BottomBarArea()
          }
          }
        }
      }
      .width('100%')
      .height('100%')
      .backgroundColor($r('app.color.page_bg'))
      .hideTitleBar(true)
      .mode(NavigationMode.Stack)

      // 全局唯一标题栏：由各 NavDestination 页面在 onReady/onWillAppear 时改写其内容
      AppBarHeader()
        .position({ x: 0, y: 0 })

      if (this.tabStore.current().loading) {
        // 原版进度条：#59C2E5 → #A687E0 渐变，高 2dp（x8/h.x）
        Progress({ value: this.tabStore.current().progress, total: 100, type: ProgressType.Linear })
          .width('100%')
          .height(2)
          .transition(TransitionEffect.OPACITY.animation({ duration: 160 }))
          .color(PROGRESS_GRADIENT)
          .backgroundColor(Color.Transparent)
          .position({ x: 0, y: this.insets.top })
      }

      if (this.showSearch) {
        // 原版 bb/i：搜索建议为地址栏下吸附的浮动卡片（非全屏黑面板），页面仅压暗
        Column()
          .width('100%')
          .height('100%')
          // 原版压暗层 0x70808080（y7.java）
          .backgroundColor('#70808080')
          .transition(TransitionEffect.OPACITY.animation({ duration: 160 }))
          .onClick(() => {
            this.showSearch = false
          })
        // 卡片贴在顶栏（地址栏 48）之下，左右 8 边距（原版 .opSug_wpr 宽度收窄）
        Row() {
          SearchOverlay({
            initialText: this.searchInitialText,
            onClose: () => {
              this.showSearch = false
            }
          })
        }
        .width('100%')
        .padding({ left: 8, right: 8, top: this.insets.top + 48 })
        .transition(TransitionEffect.OPACITY.animation({ duration: 160 }))
        .onClick(() => {
          this.showSearch = false
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
            this.saveCurrentPageAsPdf()
          },
          onOpenAi: () => {
            this.showAi = true
          },
          onOpenReader: () => {
            this.toggleReader()
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
      if (this.downloadConfirm !== null) {
        DownloadConfirmOverlay({
          info: this.downloadConfirm,
          onDone: () => {
            this.downloadConfirm = null
          }
        })
      }

      // 原版 k6 Hb()：整窗黑色滤镜，夜间生效时 alpha=max(128, 主页背景不透明度/100*255)
      if (this.settings.isNightActive()) {
        Column()
          .width('100%')
          .height('100%')
          .backgroundColor(`#${this.windowFilterAlphaHex()}000000`)
          .hitTestBehavior(HitTestMode.None)
          // 原版 k6.Ib：夜间切换 alpha 0.2→1、300ms Accelerate（近似 EaseIn）
          .transition(TransitionEffect.OPACITY.animation({ duration: 300, curve: Curve.EaseIn }))
      }
    }
    .width('100%')
    .height('100%')
  }

  private windowFilterAlphaHex(): string {
    // 原版 k6.Hb：alpha = max(背景亮度>=192 ? 128 : 64, 不透明度%*255)
    const dim = Math.round(this.settings.homeBgOpacity / 100 * 255)
    const bgColor = this.settings.homeBgColor
    let floorAlpha = 128
    if (this.tabStore.current().isHomePage() && bgColor !== '' && bgColor.length >= 7) {
      const r = parseInt(bgColor.substring(1, 3), 16)
      const g = parseInt(bgColor.substring(3, 5), 16)
      const b = parseInt(bgColor.substring(5, 7), 16)
      floorAlpha = (r * 0.299 + g * 0.587 + b * 0.114) >= 192 ? 128 : 64
    }
    const alpha = Math.max(floorAlpha, dim)
    const h = alpha.toString(16)
    return h.length === 1 ? `0${h}` : h
  }

  // 原版阅读模式开关（c0.j 进入 / c0.i 退出）：注入到当前标签的 Web 组件内
  private toggleReader(): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.page_failed_load'), duration: 1500
      })
      return
    }
    Reader.isInReader(tab).then((inReader: boolean) => {
      if (inReader) {
        return Reader.exitReader(tab)
      }
      return Reader.injectReaderScripts(tab).then(() => {
        return Reader.enterReader(tab, READER_THEME_COLORS[this.settings.readerTheme],
          this.settings.readerFontSize, this.settings.readerCustomCss)
      }).then((ok: boolean) => {
        if (!ok) {
          this.getUIContext().getPromptAction().showToast({
            message: $r('app.string.page_failed_load'), duration: 1500
          })
        }
      })
    }).catch(() => {
      console.error('toggle reader failed')
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

// 下载确认弹层数据（原版 k6.mb → mark/via/download/m.java）
class PendingDownloadUi {
  kind: string = 'web'
  guid: string = ''
  url: string = ''
  fileName: string = ''
  size: number = 0

  constructor(kind: string, guid: string, url: string, fileName: string, size: number) {
    this.kind = kind
    this.guid = guid
    this.url = url
    this.fileName = fileName
    this.size = size
  }
}

// 原版下载确认弹层（m.java）：标题 + 可编辑文件名 + 文件大小 + 复制链接（>64198568 字节）+ 取消/下载
@ComponentV2
struct DownloadConfirmOverlay {
  @Param info: PendingDownloadUi = new PendingDownloadUi('web', '', '', '', 0)
  @Event onDone: () => void = () => {}
  @Local fileName: string = ''
  private coordinator: DownloadCoordinator = DownloadCoordinator.getInstance()

  aboutToAppear(): void {
    this.fileName = this.info.fileName
  }

  // 原版 k6.mb：文件大于 64198568 字节时显示复制链接按钮
  private static readonly COPY_LINK_THRESHOLD: number = 64198568

  build() {
    Column() {
      Column({ space: 16 }) {
        Text($r('app.string.download_confirm_title'))
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
        TextInput({ text: this.fileName })
          .height(40)
          .fontSize(14)
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .caretColor($r('app.color.accent'))
          .onChange((value: string) => {
            this.fileName = value
          })
        if (this.info.size > 0) {
          Text($r('app.string.file_size_label', this.sizeText(this.info.size)))
            .fontSize(13)
            .fontColor($r('app.color.fg_secondary'))
        }
        if (this.info.size > DownloadConfirmOverlay.COPY_LINK_THRESHOLD) {
          Text($r('app.string.copy_link'))
            .fontSize(13)
            .fontColor($r('app.color.accent'))
            .onClick(() => {
              this.copyUrl()
            })
        }
        Row({ space: 12 }) {
          Button($r('app.string.cancel'))
            .fontSize(14)
            .height(36)
            .layoutWeight(1)
            .backgroundColor($r('app.color.surface'))
            .fontColor($r('app.color.fg'))
            .onClick(() => {
              this.cancel()
            })
          Button($r('app.string.download_btn'))
            .fontSize(14)
            .height(36)
            .layoutWeight(1)
            .backgroundColor($r('app.color.accent'))
            .fontColor(Color.White)
            .onClick(() => {
              this.confirm()
            })
        }
        .width('100%')
      }
      .width('80%')
      .padding(20)
      .borderRadius(16)
      .backgroundColor($r('app.color.page_bg'))
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .backgroundColor('rgba(0,0,0,0.5)')
    .onClick(() => {
      this.cancel()
    })
  }

  private sizeText(size: number): string {
    if (size < 1024) {
      return `${size} B`
    }
    if (size < 1024 * 1024) {
      return `${(size / 1024).toFixed(1)} KB`
    }
    return `${(size / 1024 / 1024).toFixed(1)} MB`
  }

  private copyUrl(): void {
    const data = pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, this.info.url)
    pasteboard.getSystemPasteboard().setData(data).then(() => {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.copied_link'), duration: 1500 })
    }).catch(() => {
      console.error('copy download url failed')
    })
  }

  private cancel(): void {
    if (this.info.kind === 'web') {
      this.coordinator.cancelPendingDownload(this.info.guid)
    } else {
      this.coordinator.cancelPendingUrlDownload()
    }
    this.onDone()
  }

  private confirm(): void {
    if (this.info.kind === 'web') {
      this.coordinator.confirmWebDownload(this.info.guid, this.fileName)
    } else {
      this.coordinator.confirmUrlDownload(this.fileName)
    }
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.download_started'), duration: 1500 })
    this.onDone()
  }
}
