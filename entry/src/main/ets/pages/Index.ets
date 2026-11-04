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
import { ReadAloudController, ReadAloudTask, ReadAloudListener, sentencesFromJson } from '../common/ReadAloud'
import { ReadAloudEngine } from '../common/Tts'
import { ReadAloudPanel } from '../components/ReadAloudPanel'
import { ReadAloudFloat } from '../components/ReadAloudFloat'
import { AiPanel } from '../components/AiPanel'
import { CopilotStore, AiAttachment } from '../common/CopilotStore'
import { MediaListPage } from '../components/MediaListPage'
import { LinkInterstitial } from '../components/LinkInterstitial'
import { VideoPlayerOverlay, VideoOverlayState } from '../components/VideoPlayerOverlay'
import { systemShare } from '@kit.ShareKit'
import { uniformTypeDescriptor as utd } from '@kit.ArkData'
import { common } from '@kit.AbilityKit'
import { webview } from '@kit.ArkWeb'
import { window, mediaquery, display } from '@kit.ArkUI'
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
const OPEN_DOWNLOADS_EVENT_ID = 10003
// 原版 i6/w.e()：抽取正文 innerText（阅读模式中取 via-reader-body）
const READ_ALOUD_EXTRACT_JS: string =
  '(function(){try{var e=document.getElementsByClassName("via-reader-body"),n=e.length>0?e[0].innerText:document.body.innerText;return JSON.stringify(n.split("\\n"))}catch(e){}})()'

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
  // b9/g 面板呈现参数（ba() 时计算）：附件、绑定线程、宽高
  @Local aiAttachment: AiAttachment | null = null
  @Local aiInitThreadId: string = ''
  @Local aiPanelHeightVp: number = 0
  @Local aiPanelWidthVp: number = 0
  // e0 面板返回键处理（registerBack 注册）
  private aiBackHandler: (() => boolean) | null = null
  @Local showMediaList: boolean = false
  @Local mediaList: string[] = []
  @Local exitHintTime: number = 0
  // 游戏模式双击返回退出计时
  @Local gameModeBackTime: number = 0
  @Local showLinkConfirm: boolean = false
  @Local linkConfirmUrl: string = ''
  // 下载确认弹层（原版 mark/via/download/m.java）
  @Local downloadConfirm: PendingDownloadUi | null = null
  // 朗读：悬浮控件/面板/Snackbar（原版 k6.xb/ha/p3）
  private readAloudController: ReadAloudController = ReadAloudController.getInstance()
  @Local showReadAloudPanel: boolean = false
  @Local readAloudFloatVisible: boolean = false
  @Local readAloudPlaying: boolean = false
  private readAloudTaskId: string | null = null
  private readAloudListener: ReadAloudListener = (task: ReadAloudTask) => {
    this.onReadAloudTaskChanged(task)
  }
  @Local snackbarText: string = ''
  @Local snackbarActionText: string = ''
  private snackbarCallback: (() => void) | null = null
  private snackbarTimer: number = -1
  // 全屏视频播放器（原版 k6.z/V + com.tuyafeng.support.widget.v）
  videoOverlay: VideoOverlayState = VideoOverlayState.getInstance()
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
    // 下载通知点击：打开下载页
    emitter.on({ eventId: OPEN_DOWNLOADS_EVENT_ID }, () => {
      this.openPage('downloads')
    })
    // 朗读任务监听（原版 k6.va：I1.b(d) → xb）
    this.readAloudController.addListener(this.readAloudListener)
  }

  aboutToDisappear(): void {
    if (this.landscapeListener !== null) {
      this.landscapeListener.off('change')
      this.landscapeListener = null
    }
    this.readAloudController.removeListener(this.readAloudListener)
    ReadAloudEngine.getInstance().shutdown()
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
    CopilotStore.getInstance().init(context)
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
    if (AppStorage.get<boolean>('via_open_downloads') === true) {
      AppStorage.setOrCreate('via_open_downloads', false)
      this.openPage('downloads')
    }
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
    // 原版 k6 返回键：全屏视频时 V() 退出全屏播放
    if (this.videoOverlay.active) {
      this.videoOverlay.requestExit()
      return true
    }
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
      // 原版 b9/g.onBackPressed：交由 e0 的返回键处理（panelBack）
      if (this.aiBackHandler !== null) {
        this.aiBackHandler()
      } else {
        this.showAi = false
      }
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
      case 'tts':
        this.startReadAloud()
        break
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
        this.openAi()
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
          if (!this.settings.gameMode && !this.videoOverlay.active) {
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

          if (!this.settings.gameMode && !this.videoOverlay.active) {
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
            this.openAi()
          },
          onOpenReader: () => {
            this.toggleReader()
          },
          onReadAloud: () => {
            this.startReadAloud()
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
        // 原版 b9/g Dialog：dimAmount 0.2，点击面板外关闭
        Column()
          .width('100%')
          .height('100%')
          .backgroundColor('#33000000')
          .transition(TransitionEffect.OPACITY.animation({ duration: 160 }))
          .onClick(() => {
            this.showAi = false
          })
        // 竖屏：底部面板，宽 MATCH 高 max/9*5；横屏：居中面板，宽 min(440dp, max/2) 高 MATCH
        Column() {
          AiPanel({
            initAttachment: this.aiAttachment,
            initThreadId: this.aiInitThreadId,
            onClose: () => {
              this.showAi = false
            },
            onOpenSettings: () => {
              this.showAi = false
              this.openPage('aiSettings')
            },
            registerBack: (handler: () => boolean) => {
              this.aiBackHandler = handler
            }
          })
            .width('100%')
            .height('100%')
            .backgroundColor($r('app.color.page_bg'))
            .padding(this.isLandscape ? { top: this.insets.top } : { bottom: this.insets.bottom })
        }
        .width(this.isLandscape ? this.aiPanelWidthVp : '100%')
        .height(this.isLandscape ? '100%' : this.aiPanelHeightVp)
        .justifyContent(this.isLandscape ? FlexAlign.Center : FlexAlign.End)
        .alignItems(this.isLandscape ? HorizontalAlign.Center : HorizontalAlign.Start)
        .transition(TransitionEffect.OPACITY.animation({ duration: 160 }))
        .onClick(() => {
          this.showAi = false
        })
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

      // 原版 k6.xb：朗读悬浮控件（贴左边缘、可纵向拖拽）
      if (this.readAloudFloatVisible) {
        ReadAloudFloat({
          playing: this.readAloudPlaying,
          onAction: (action: number) => {
            this.onReadAloudAction(action)
          }
        })
      }

      // 原版 k6.ha()/j8.p：朗读面板（min(4/5W,450)×min(4/5H,600) 弹窗）
      if (this.showReadAloudPanel) {
        ReadAloudPanel({
          onClose: () => {
            this.showReadAloudPanel = false
          },
          onSpeedChanged: (speed: number) => {
            this.readAloudController.getEngine().setSpeed(speed)
          }
        })
      }

      // 原版 g6.n.r：Snackbar（底部深色条 + 动作按钮）
      if (this.snackbarText !== '') {
        Column() {
          Row() {
            Text(this.snackbarText)
              .fontSize(14)
              .fontColor('#DEFFFFFF')
              .maxLines(2)
              .layoutWeight(1)
            if (this.snackbarActionText !== '') {
              Text(this.snackbarActionText)
                .fontSize(14)
                .fontWeight(FontWeight.Medium)
                .fontColor($r('app.color.accent'))
                .padding({ left: 12, right: 4, top: 6, bottom: 6 })
                .onClick(() => {
                  const cb = this.snackbarCallback
                  this.snackbarText = ''
                  this.snackbarActionText = ''
                  this.snackbarCallback = null
                  if (this.snackbarTimer >= 0) {
                    clearTimeout(this.snackbarTimer)
                    this.snackbarTimer = -1
                  }
                  if (cb !== null) {
                    cb()
                  }
                })
            }
          }
          .width('100%')
          .padding({ left: 16, right: 8, top: 12, bottom: 12 })
          .backgroundColor('#F0322F2F')
          .borderRadius(4)
          .margin({ left: 12, right: 12, bottom: 56 })
          .transition(TransitionEffect.OPACITY.animation({ duration: 150 }))
        }
        .width('100%')
        .height('100%')
        .justifyContent(FlexAlign.End)
        .alignItems(HorizontalAlign.Center)
        .hitTestBehavior(HitTestMode.Transparent)
      }

      // 原版 k6 自定义视图（全屏视频容器）：置于内容之上、整窗夜间滤镜之下
      VideoPlayerOverlay()

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

  // ===== 原版朗读（k6.va/G3/p3/E3/xb/ha）=====

  // 原版 k6.va()：朗读入口 —— JS 禁用提示 → 初始化控制器/引擎 → 稍等提示 → 抽取正文
  private startReadAloud(): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.read_aloud_cannot'), duration: 1500
      })
      return
    }
    if (!this.settings.jsEnabled) {
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.read_aloud_js_disabled'), duration: 1500
      })
      return
    }
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    if (context !== undefined) {
      this.readAloudController.initService(context)
    }
    // 原版 I1.g().g(settings.O())：引擎语速
    this.readAloudController.getEngine().setSpeed(this.settings.readAloudSpeed)
    const state = this.readAloudController.getEngine().getState()
    if (state !== 0 && state !== 1 && state !== 2) {
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.read_aloud_engine_failed'), duration: 1500
      })
      return
    }
    this.getUIContext().getPromptAction().showToast({
      message: $r('app.string.read_aloud_wait'), duration: 1500
    })
    const taskId = `ra${Date.now()}${Math.floor(Math.random() * 100000)}`
    const url = tab.url
    const title = tab.title
    try {
      tab.controller.runJavaScript(READ_ALOUD_EXTRACT_JS, (error: BusinessError, result: string) => {
        if (error) {
          console.error(`read aloud extract failed: ${error.code}`)
          this.getUIContext().getPromptAction().showToast({
            message: $r('app.string.read_aloud_cannot'), duration: 1500
          })
          return
        }
        this.submitReadAloud(taskId, url, title, result)
      })
    } catch (error) {
      console.error('runJavaScript read aloud failed')
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.read_aloud_cannot'), duration: 1500
      })
    }
  }

  // 原版 k6.G3 → p3：切分句子 → 提交任务 → 播放 → Snackbar「开始朗读/查看」→ 显示悬浮控件
  private submitReadAloud(taskId: string, url: string, title: string, json: string): void {
    const sentences = sentencesFromJson(json)
    if (sentences.length === 0) {
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.read_aloud_cannot'), duration: 1500
      })
      return
    }
    const task = new ReadAloudTask(taskId, url, title, sentences, 0)
    const submitted = this.readAloudController.submit(task)
    if (submitted === null) {
      return
    }
    this.readAloudTaskId = submitted
    this.readAloudController.commandPlay(submitted)
    this.readAloudFloatVisible = true
    this.readAloudPlaying = true
    const ctx = this.getUIContext().getHostContext()
    if (ctx !== undefined) {
      this.showSnackbar(
        ctx.resourceManager.getStringSync($r('app.string.read_aloud_started').id),
        ctx.resourceManager.getStringSync($r('app.string.read_aloud_view').id),
        () => {
          this.showReadAloudPanel = true
        }
      )
    }
  }

  // 原版 k6.xb：任务变化 → 悬浮控件 setPlaying(t.h())
  private onReadAloudTaskChanged(task: ReadAloudTask): void {
    this.readAloudFloatVisible = true
    this.readAloudPlaying = task.playing()
  }

  // 原版 k6.E3：悬浮控件回调 1=播放 2=暂停 3=停止 4=面板
  private onReadAloudAction(action: number): void {
    if (action === 1) {
      if (this.readAloudTaskId !== null) {
        this.readAloudController.commandPlay(this.readAloudTaskId)
      }
    } else if (action === 2) {
      if (this.readAloudTaskId !== null) {
        this.readAloudController.commandPause(this.readAloudTaskId)
      }
    } else if (action === 3) {
      this.readAloudController.commandStop()
      this.readAloudTaskId = null
      this.readAloudFloatVisible = false
    } else if (action === 4) {
      this.showReadAloudPanel = true
    }
  }

  // 原版 g6.n.r：Snackbar（消息 + 动作按钮，2750ms 自动消失）
  private showSnackbar(text: string, actionText: string, onAction: (() => void) | null): void {
    this.snackbarText = text
    this.snackbarActionText = actionText
    this.snackbarCallback = onAction
    if (this.snackbarTimer >= 0) {
      clearTimeout(this.snackbarTimer)
    }
    this.snackbarTimer = setTimeout(() => {
      this.snackbarText = ''
      this.snackbarActionText = ''
      this.snackbarCallback = null
      this.snackbarTimer = -1
    }, 2750)
  }

  // 原版 k6.ba()：AI 入口 —— aibackend 空 → push AI 设置页；
  // 否则当前标签为可脚本化网页时抽正文构造附件（带 urlThreadId 绑定）再开面板，否则无附件开面板
  private openAi(): void {
    if (this.settings.aiBackend === '') {
      this.openPage('aiSettings')
      return
    }
    const tab = this.tabStore.current()
    this.aiBackHandler = null
    this.aiAttachment = null
    this.aiInitThreadId = ''
    this.computeAiPanelSize()
    const scriptable = !tab.isHomePage() &&
      (tab.url.startsWith('http://') || tab.url.startsWith('https://'))
    if (!scriptable) {
      this.showAi = true
      return
    }
    const url = tab.url
    const title = tab.title
    const threadId = CopilotStore.getInstance().threadIdOfUrl(url)
    if (threadId !== null) {
      this.aiInitThreadId = threadId
    }
    Reader.extractText(tab).then((text: string) => {
      const att = new AiAttachment()
      att.url = url
      att.title = title
      att.content = text
      this.aiAttachment = att
      this.showAi = true
    }).catch(() => {
      this.showAi = true
    })
  }

  // 原版 b9/g 呈现规格：竖屏宽 MATCH 高 max(w,h)/9*5 底部；横屏宽 min(440dp, max/2) 高 MATCH 居中
  private computeAiPanelSize(): void {
    try {
      const d = display.getDefaultDisplaySync()
      const px2vpFn = this.getUIContext().px2vp
      const maxVp = Math.max(px2vpFn(d.width), px2vpFn(d.height))
      this.aiPanelHeightVp = maxVp / 9 * 5
      this.aiPanelWidthVp = Math.min(440, maxVp / 2)
    } catch (error) {
      this.aiPanelHeightVp = 400
      this.aiPanelWidthVp = 440
    }
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
