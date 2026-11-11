import { TOAST_SHORT } from '../common/ToastDuration'
import { TabItem, RuleSubEntry, BookmarkFolderRec } from '../common/Types'
import { AppSettings, applyOrientationSetting } from '../common/Settings'
import { AdBlocker } from '../common/AdBlock'
import { RuleSubManager } from '../common/RuleSubscriptions'
import { BrowserDb } from '../common/Database'
import { TabStore, OPEN_BOOKMARKS_EVENT_ID } from '../common/TabStore'
import { DownloadCoordinator, DOWNLOAD_CONFIRM_EVENT_ID } from '../common/Downloads'
import { TabWeb } from '../components/TabWeb'
import { HomePage } from '../components/HomePage'
import { AddressBar } from '../components/AddressBar'
import { Toolbar, toolbarBackgroundColor } from '../components/Toolbar'
import { SearchOverlay } from '../components/SearchOverlay'
import { SearchToolbar } from '../components/SearchToolbar'
import { TabPanel } from '../components/TabPanel'
import { AppBarHeader } from '../components/AppBar'
import { MenuSheet, TRANSLATE_INJECT_JS } from '../components/MenuSheet'
import { FindBar } from '../components/FindBar'
// 原版 a8/k.java：书签快捷选择对话框（W9()）
import { BookmarkPickerDialog } from '../components/BookmarkPickerDialog'
import { Reader, READER_THEME_COLORS } from '../common/Reader'
import { ReadAloudController, ReadAloudTask, ReadAloudListener, sentencesFromJson } from '../common/ReadAloud'
import { ReadAloudEngine } from '../common/Tts'
import { ReadAloudPanel } from '../components/ReadAloudPanel'
import { ReadAloudFloat } from '../components/ReadAloudFloat'
import { TranslatePanel, TranslateState } from '../components/TranslatePanel'
import { AiPanel } from '../components/AiPanel'
import { CopilotStore, AiAttachment } from '../common/CopilotStore'
import { MediaListPage } from '../components/MediaListPage'
import { VideoPlayerOverlay, VideoOverlayState } from '../components/VideoPlayerOverlay'
import { systemShare } from '@kit.ShareKit'
import { uniformTypeDescriptor as utd, preferences } from '@kit.ArkData'
import { common } from '@kit.AbilityKit'
import { webview } from '@kit.ArkWeb'
import { window, mediaquery, display } from '@kit.ArkUI'
import { fileIo } from '@kit.CoreFileKit'
import { BusinessError, emitter, pasteboard } from '@kit.BasicServicesKit'
import { inputConsumer, KeyEvent as InputKeyEvent, KeyCode } from '@kit.InputKit'
import { util } from '@kit.ArkTS'
import { scanBarcode } from '@kit.ScanKit'
import { hostOf, buildSearchUrl, isUrlLike, normalizeUrl } from '../common/SearchEngines'
import { parseUiaDeepLink, UiaCmdKind, UIA_CMD_EVENT_ID, isStrictHttp, isJavaScriptUrl } from '../common/DeepLink'
import { RemoteConfig } from '../common/RemoteConfig'
import { UiInsets, applyStatusBarVisible } from '../common/Immersive'
import { computeDialogWidthVp } from '../components/UiaDialogCard'
import { UiaDialogButton } from '../components/UiaDialogButton'
import { menuTransition, menuTransitionTop, dimTransition, fadeInTransition, DECELERATE_CURVE, ACCELERATE_CURVE, BEZIER_0202_CURVE } from '../common/Transitions'
import { AutoHideGesture, AutoHideHost } from '../common/AutoHideGesture'

const EXIT_INTERVAL: number = 1500
// 原版进度条渐变（x8/h.x）：#59C2E5 → #A687E0
const PROGRESS_GRADIENT: LinearGradient = {
  angle: 90,
  colors: [['#59C2E5', 0], ['#A687E0', 1]]
}
const SHORTCUT_URL_EVENT_ID = 10001
const EXTERNAL_LINK_EVENT_ID = 10002
const OPEN_DOWNLOADS_EVENT_ID = 10003
// 原版 k6.i9() 双击返回显式退出 → m0.r0()（z8/h0.c 退出清除）：退出清除仅在显式退出时执行
const EXIT_CLEAR_EVENT_ID = 10005
// 原版 i6/w.e()：抽取正文 innerText（阅读模式中取 uia-reader-body）
const READ_ALOUD_EXTRACT_JS: string =
  '(function(){try{var e=document.getElementsByClassName("uia-reader-body"),n=e.length>0?e[0].innerText:document.body.innerText;return JSON.stringify(n.split("\\n"))}catch(e){}})()'
// 保存网页降级序列化：canvas 转 img data URL（跨域污染 catch 跳过）+ outerHTML
const SAVE_PAGE_SERIALIZE_JS: string =
  '(function(){try{var cs=document.querySelectorAll("canvas");' +
  'for(var i=0;i<cs.length;i++){var c=cs[i];try{var d=c.toDataURL("image/png");' +
  'if(d&&d.length>0){var img=document.createElement("img");img.src=d;' +
  'img.width=c.width;img.height=c.height;img.style.cssText=c.style.cssText;' +
  'c.parentNode.replaceChild(img,c)}}catch(e){}}}catch(e){}' +
  'return document.documentElement.outerHTML})()'

// 原版 z8.c1.n：trim、[/\:*?"<>|]→'-'、UTF-8 ≤200 字节
function sanitizeFileName(raw: string): string {
  const trimmed = raw.trim()
  if (trimmed === '') {
    return ''
  }
  let cleaned = trimmed.replace(/[/\\:*?"<>|]/g, '-')
  const encoder = new util.TextEncoder()
  if (encoder.encodeInto(cleaned).length > 200) {
    let lo = 0
    let hi = cleaned.length
    while (lo < hi) {
      const mid = Math.ceil((lo + hi) / 2)
      if (encoder.encodeInto(cleaned.substring(0, mid)).length <= 200) {
        lo = mid
      } else {
        hi = mid - 1
      }
    }
    cleaned = cleaned.substring(0, lo)
  }
  return cleaned
}

// 原版应用布局（Ya()）：0=传统 1=工具栏在上 2=工具栏在下 3=双行
const LAYOUT_TRADITIONAL: number = 0
const LAYOUT_TOOLBAR_TOP: number = 1
const LAYOUT_TOOLBAR_BOTTOM: number = 2
const LAYOUT_DOUBLE: number = 3

@Entry
@ComponentV2
struct Index {
  private settings: AppSettings = AppSettings.getInstance()
  // 用户拍板（2026-11-08）：两栏收起时同步隐藏系统状态栏/导航栏，
  // 避免「网页在下、状态栏在上」的重叠。这是刻意偏离原版的移植决策，
  // 原版 c8/k6.db() 只位移四个视图、不碰 l3.n(window,true)（仅菜单「全屏」触发）。
  // 反映系统栏当前是否可见：@Local 让 effectiveInset* 与布局随联动自动刷新。
  @Local systemBarsVisible: boolean = true
  private systemBarsHiddenByToolbar: boolean = false
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
  // 下载确认弹层（原版 mark/uia/download/m.java）
  @Local downloadConfirm: PendingDownloadUi | null = null
  // 保存网页弹窗（原版 k6.m0：标题/输入/保存为 PDF 复选框）
  @Local showSavePage: boolean = false
  @Local savePageName: string = ''
  @Local saveAsPdf: boolean = false
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
  // 原版 k6.C1 = getConfiguration().orientation（设备物理方向），仅用于 Ya() 的布局映射：
  //   C1==2(横屏) 时布局 0→1、3→2。原版取系统方向，不取窗口宽高比；
  //   鸿蒙 PC/平板宽窗口的 mediaquery (orientation:landscape) 恒为真，会误把「传统」改成布局1。
  // 故单独用 display.Display.orientation 物理枚举判定（display.d.ts:929-966）。
  @Local physicalLandscape: boolean = false
  private displayChangeCallback: (id: number) => void = (id: number): void => {
    this.refreshPhysicalOrientation()
  }
  // ============ 自动隐藏操作栏（原版 fullscreenmode 三态 + GestureTouchEvent 竖滑） ============
  // 原版 k6.f2591r1：隐藏进度，0=显示 1=隐藏（初始 0.0，k6.java:284）；
  // db(p)（6969-6993）：顶栏 ty=-p*h、底栏 ty=+p*h、网页容器 ty=h*(1-p)（工具栏在上时）
  @Local toolbarHideProgress: number = 0
  // 原版 k6.f2589q1：显示态（初始 true，k6.java:281）
  private toolbarShown: boolean = true
  // 原版 k6.f2593s1：S7 动画期间防重入（X7 取消用）
  private toolbarAnimRunning: boolean = false
  // 原版 k6.f2596u0：点击隐藏（模式2）的 FAB（f2594t0，帧动画 160ms 淡入）
  @Local fabVisible: boolean = false
  @Local fabAlpha: number = 0
  @Local fabOffsetX: number = 0
  @Local fabOffsetY: number = 0
  @Local fabAlignLeft: boolean = false
  @Local fabAlignRight: boolean = true
  @Local fabAlignTop: boolean = false
  @Local fabAlignBottom: boolean = true
  // 原版 Ga()：既非 LEFT 也非 RIGHT → 水平居中；非 BOTTOM → 垂直居中
  @Local fabCenterH: boolean = false
  @Local fabCenterV: boolean = false
  @Local fabMargin: number = 36
  @Local fabSize: number = 42
  private fabShown: boolean = false
  private fabDragBaseX: number = 0
  private fabDragBaseY: number = 0
  @Local fabFreeDrag: boolean = false
  // 竖滑手势状态机（GestureTouchEvent 1:1，slop 用 8vp≈系统 touchSlop）
  private autoHideGesture: AutoHideGesture = new AutoHideGesture(vp2px(8))
  // 原版 db(f) 位移基准 = 实测栏高（f2604y0/f2600w0.getHeight()）；由 onAreaChange 回填
  @Local topBarHeightVp: number = 0
  @Local bottomBarHeightVp: number = 0
  // 宿主实现（对象字面量需显式类型，拆为独立类避免 arkts-no-untyped-obj-literals）
  private autoHideHost: IndexAutoHideHost = new IndexAutoHideHost(this)
  // 音量键翻页（原版操作设定）：开启时消费音量上/下键滚动网页
  private volumeKeyConsumed: boolean = false
  private volumeUpFunc: (event: InputKeyEvent) => void = () => {
  }
  private volumeDownFunc: (event: InputKeyEvent) => void = () => {
  }

  @Monitor('settings.volumePageFlip')
  onVolumePageFlipChange(): void {
    this.syncVolumeKeyConsumers()
  }

  // 设置变更（显示状态栏 / 全屏开关）时按当前两栏状态重算系统栏显隐
  @Monitor('settings.showStatusBar', 'settings.fullScreen')
  onSystemBarSettingChange(): void {
    const baseVisible = this.settings.showStatusBar && !this.settings.fullScreen
    this.applySystemBarsVisible(baseVisible && !this.systemBarsHiddenByToolbar)
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
        this.volumeUpFunc = (_event: InputKeyEvent) => {
          this.scrollCurrentPage(-1)
        }
        this.volumeDownFunc = (_event: InputKeyEvent) => {
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
    // 竖滑手势状态机绑定宿主（k6 构造 GestureTouchEvent(container, f8())）
    this.autoHideGesture.bind(this.autoHideHost)
    // 原版 Ya()：横屏时布局 0→1、3→2
    this.landscapeListener = this.getUIContext().getMediaQuery()
      .matchMediaSync('(orientation: landscape)')
    this.landscapeListener.on('change', (result: mediaquery.MediaQueryResult) => {
      this.isLandscape = result.matches
    })
    this.isLandscape = this.landscapeListener.matches
    // 原版 C1：设备物理方向初值 + 旋转订阅（display.on('change') 在方向变化时回调）
    this.refreshPhysicalOrientation()
    try {
      display.on('change', this.displayChangeCallback)
    } catch (error) {
      console.error(`display.on change failed: ${error}`)
    }
    emitter.on({ eventId: SHORTCUT_URL_EVENT_ID }, (event: emitter.EventData) => {
      const data = event.data as Record<string, Object>
      const uiaUrl = data['uiaUrl']
      if (typeof uiaUrl === 'string' && uiaUrl !== '') {
        this.tabStore.navigate(uiaUrl)
      }
    })
    emitter.on({ eventId: EXTERNAL_LINK_EVENT_ID }, (event: emitter.EventData) => {
      const data = event.data as Record<string, Object>
      const linkUrl = data['linkUrl']
      const external = data['external']
      if (typeof linkUrl === 'string' && linkUrl !== '') {
        // 原版 b0.A ACTION_SEND → i0.v：分享文本走 URL 判定/搜索，不走外链确认
        if (data['sharedText'] === true) {
          this.openReceivedText(linkUrl)
          return
        }
        this.openExternalLink(linkUrl, external !== false)
      }
    })
    // 热启动 uia:// 内部命令（EntryAbility.onNewEntry → AppStorage 'uia_internal_cmd'）
    emitter.on({ eventId: UIA_CMD_EVENT_ID }, () => {
      this.handleInternalCmd()
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
      // 网页内下载转自研引擎：带上触发页面 Referer 与 Web UA，保证登录态下载
      let referer = ''
      let pageUa = ''
      try {
        const currentTab = this.tabStore.current()
        referer = currentTab.url
        pageUa = currentTab.controller.getUserAgent()
      } catch (error) {
      }
      this.downloadConfirm = new PendingDownloadUi(
        kind === 'url' ? 'url' : 'web',
        typeof guid === 'string' ? guid : '',
        url,
        fileName,
        typeof size === 'number' ? size : 0,
        referer,
        pageUa
      )
    })
    // 主页模式=书签：新标签打开书签页（原版 uia://bookmark）
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
    try {
      display.off('change', this.displayChangeCallback)
    } catch (error) {
      console.error(`display.off change failed: ${error}`)
    }
    this.readAloudController.removeListener(this.readAloudListener)
    ReadAloudEngine.getInstance().shutdown()
    this.syncVolumeKeyConsumers()
    this.tabStore.snapshot(this.settings)
    this.settings.persistAdBlockTotal()
  }

  // 原版 k6.u() + z8/w2 + z8/b0.Q()：uia://(v://) 内部命令全量分发（深链/Trampoline 入口）
  // 原版 W9() → a8.k.o3()：打开书签快捷选择对话框（菜单长按书签 / 工具栏动作 30）。
  // 与「书签管理页」不同：这是从当前页快速挑一个书签在新标签打开的对话框。
  @Local showBookmarkPicker: boolean = false

  private openBookmarkDialog(): void {
    this.showBookmarkPicker = true
  }

  // 原版 k6.Ua()（k6.java:5994-6023）书签对话框选中后的落地：
  //   r4.a aVarD = this.L0.d();
  //   if (aVarD == null || z11) { this.f2580m0.i1(strV, true); }   // 无当前标签才新开
  //   else { aVarD.v(strV); aVarD.o(); }                             // 否则由当前标签加载
  // 书签对话框走 Ra(str) → Ta(str,false) → Ua(str,false,false)，即 z11=false，
  // 故**当前标签存在时用当前标签打开**，不是新标签。
  private navigateFromBookmarkPicker(url: string): void {
    if (url === '') {
      return
    }
    const current: TabItem = this.tabStore.current()
    if (current === null || current === undefined) {
      this.tabStore.newTabAt(url, false)
      return
    }
    this.tabStore.navigate(url)
  }

  // 原版 k6.d9()（6945-6953）：点击地址栏左图标前，若当前有面板/内部页面栈非空，
  // 先弹栈关面板（pb() + h9()）并 return true 拦截本次点击。
  // 调用点：k6.java:676-690（f.a() 里 id==n0.f9702v 分支先 `if (k6.this.d9()) return;`）。
  // 弹层优先级直接复用现有 onBackPress 的处理顺序。
  private closeTopPanelsForLeftIcon(): boolean {
    if (this.showMenu) {
      this.showMenu = false
      return true
    }
    if (this.showTabPanel) {
      this.showTabPanel = false
      return true
    }
    if (this.showSearch) {
      this.showSearch = false
      return true
    }
    if (this.showAi) {
      if (this.aiBackHandler !== null) {
        this.aiBackHandler()
      } else {
        this.showAi = false
      }
      return true
    }
    if (this.showMediaList) {
      this.showMediaList = false
      return true
    }
    if (this.showBookmarkPicker) {
      this.showBookmarkPicker = false
      return true
    }
    if (this.showFindBar) {
      this.showFindBar = false
      try {
        this.tabStore.current().controller.clearMatches()
      } catch (error) {
      }
      return true
    }
    return false
  }

  private handleInternalCmd(): void {
    const raw = AppStorage.get<string>('uia_internal_cmd') ?? ''
    if (raw === '') {
      return
    }
    AppStorage.setOrCreate('uia_internal_cmd', '')
    const cmd = parseUiaDeepLink(raw)
    if (cmd === null) {
      return
    }
    switch (cmd.kind) {
      // k6.u 8657：v://bookmarks[/?folder=&folderName=] → 书签页；folder 有值时进对应文件夹
      case UiaCmdKind.BOOKMARKS:
        if (cmd.folder !== '' && !Number.isNaN(Number(cmd.folder))) {
          this.openBookmarksAtFolder(Number(cmd.folder), cmd.folderName)
        } else {
          this.openPage('bookmarks')
        }
        break
      // k6.u 8641：v://history → fa() 历史页
      case UiaCmdKind.HISTORY:
        this.openPage('history')
        break
      // k6.u 8649：v://downloader → ca() 下载页
      case UiaCmdKind.DOWNLOADER:
        this.openPage('downloads')
        break
      // k6.u 8628：v://skins → lb.k 皮肤页
      case UiaCmdKind.SKINS:
        this.openPage('skinPage')
        break
      // z8/b0.Q "log" → s1(6)：log.html → netLog
      case UiaCmdKind.LOG:
        this.openPage('netLog')
        break
      // z8/b0.Q "offline" → s1(7)：save.html 离线页面
      case UiaCmdKind.OFFLINE:
        this.openPage('offlinePage')
        break
      // z8/b0.Q "about" → s1(4)：about.html → 关于
      case UiaCmdKind.ABOUT:
        this.openPage('settingsAbout')
        break
      // z8/b0.Q "home" → V0()：回主页
      case UiaCmdKind.HOME:
        if (!this.tabStore.current().isHomePage()) {
          this.tabStore.gotoHome()
        } else {
          // 原版 k6.ra case4（8269-8271）：回主页动作 → ub() 前段 → na()。
          // 主页已显示时同样恢复操作栏（ub: 8718-8725 非隐藏或进度>0 → S7(true)）
          this.showToolbarsForPage()
        }
        break
      // k6.u 8632：v://search 空 q → na() 打开搜索；带 q → Ta(q,true) 默认引擎搜索
      case UiaCmdKind.SEARCH:
        if (cmd.query === '') {
          this.searchInitialText = ''
          this.showSearch = true
        } else {
          this.tabStore.navigate(
            buildSearchUrl(this.settings.engineKey, this.settings.activeEngineTemplate(), cmd.query))
        }
        break
      // k6.u 8653：v://readaloud → ha() 朗读当前页
      case UiaCmdKind.READ_ALOUD:
        this.startReadAloud()
        break
      // k6.u 8577：history:// → s1(3) 历史页
      case UiaCmdKind.HISTORY_URI:
        this.openPage('history')
        break
      // k6.u 8567：folder://X → Z9(解码X) 按名称定位书签文件夹后进入（找不到落根目录）
      case UiaCmdKind.FOLDER: {
        let folderId = 0
        let folderTitle = ''
        try {
          folderTitle = decodeURIComponent(cmd.url)
        } catch (error) {
          folderTitle = cmd.url
        }
        if (folderTitle !== '') {
          BrowserDb.getInstance().listAllBookmarkFolders().then((folders: BookmarkFolderRec[]) => {
            for (let i = 0; i < folders.length; i++) {
              if (folders[i].title === folderTitle) {
                this.openBookmarksAtFolder(folders[i].id, folders[i].title)
                return
              }
            }
            this.openPage('bookmarks')
          }).catch(() => {
            this.openPage('bookmarks')
          })
        } else {
          this.openPage('bookmarks')
        }
        break
      }
      // k6.u 8598 / 8612：拦截页 / 错误页「继续」跳转。两条分支守卫不同：
      //  · blocker/jump（k6.java:8598-8609）：i6.i0.s(url) 为真才打开 ——
      //    严格 http:// 或 https:// 前缀（i6/i0.java:481-486 = m() 或 n()）。
      //  · error/jump（k6.java:8612-8622）：非空且 !i6.i0.p(url) 才打开 ——
      //    p()（i6/i0.java:347-356）判前 11 字符是否为 javascript:，**明确阻止**。
      // 早期实现无条件 navigate，既能被 javascript: 注入（error/jump），
      // 也与原版「非 http(s) 不跳」不符。
      case UiaCmdKind.BLOCKER_JUMP:
      case UiaCmdKind.ERROR_JUMP: {
        // DeepLink 解析层已按各自守卫过滤（isStrictHttp / isJavaScriptUrl），
        // 此处再兜一层，避免将来有人绕过 parseUiaDeepLink 直接构造 cmd
        const jumpUrl: string = cmd.url
        if (jumpUrl === '' || isJavaScriptUrl(jumpUrl)) {
          break
        }
        if (cmd.kind === UiaCmdKind.BLOCKER_JUMP && !isStrictHttp(jumpUrl)) {
          break
        }
        this.tabStore.navigate(jumpUrl)
        break
      }
      // k6.u 8624：v://scanner → ga() 扫码（与菜单「扫描二维码」同一管线）
      case UiaCmdKind.SCANNER:
        this.startScan()
        break
      // k6.u 8669：v://translator/translate?text= → Eb(text) 翻译文本弹窗（f8.w0）
      case UiaCmdKind.TRANSLATE_TEXT:
        TranslateState.getInstance().open(cmd.text)
        break
      // k6.u 8682：v://tabs/restore?ids=&selected= → F1(ids, selected) 按 id 恢复标签并选中
      case UiaCmdKind.TABS_RESTORE:
        this.tabStore.restoreByIds(cmd.ids, cmd.selected)
        break
      // z8/b0.Q() 默认 id5 → u9/d.java:129 catalog.html：站点目录页（6 入口）
      case UiaCmdKind.CATALOG:
        this.openPage('catalog')
        break
      // 原版 k6.u 8582-8588：thunder:// / qqdl:// / flashget:// → z8.b0.D 解出直链后
      //   mb(new e.b().j(直链).k(L1).c("attachment").d(-1).b()) 走下载管线
      case UiaCmdKind.SCHEME_DOWNLOAD: {
        const link: string = cmd.url
        if (link !== '') {
          let pageUa = ''
          try {
            pageUa = this.tabStore.current().controller.getUserAgent()
          } catch (error) {
            pageUa = ''
          }
          this.downloads.requestUrlDownload(link, this.tabStore.current().url, pageUa, '')
        }
        break
      }
      // 原版 k6.u 8589-8591：baidubox:// 系列 → 直接 return true（什么都不做）；
      // thunder/qqdl/flashget 解出空直链时同样已消费
      case UiaCmdKind.SCHEME_IGNORED:
        break
      // 原版 k6.u 8592-8596：file:// 且扩展名 pdf → g6.i.h(za.g.class, pdfPath)
      // PdfViewerPage 的 param 是沙箱文件路径（同 TabWeb.openPdfPreview 的
      // 「去 file:// 前缀 + decodeURIComponent」换算），不是 URI
      case UiaCmdKind.SCHEME_PDF: {
        let pdfPath: string = cmd.url.substring('file://'.length)
        try {
          pdfPath = decodeURIComponent(pdfPath)
        } catch (error) {
          pdfPath = cmd.url.substring('file://'.length)
        }
        if (pdfPath !== '') {
          this.mainNavStack.pushPathByName('pdfViewer', pdfPath, true)
        }
        break
      }
      default:
        break
    }
  }

  // 原版 restoreclosedtabs=2：启动时优先询问是否恢复未关闭标签
  private askPendingRestore(): void {
    const pending = AppStorage.get<string>('uia_pending_restore_tabs') ?? ''
    if (pending === '') {
      return
    }
    AppStorage.setOrCreate('uia_pending_restore_tabs', '')
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
    // 原版 k6.m9（7633-7643）：Y0 = r2()==2（点击隐藏模式）→ Jb/Ya 初始化工具栏
    this.initFabPosition()
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
    if (AppStorage.get<boolean>('uia_open_downloads') === true) {
      AppStorage.setOrCreate('uia_open_downloads', false)
      this.openPage('downloads')
    }
    this.ready = true
    const launchUrl = AppStorage.get<string>('uia_launch_url') ?? ''
    if (launchUrl !== '') {
      AppStorage.setOrCreate('uia_launch_url', '')
      const launchExternal = AppStorage.get<boolean>('uia_launch_external') ?? false
      AppStorage.setOrCreate('uia_launch_external', false)
      const launchSharedText = AppStorage.get<boolean>('uia_shared_text') ?? false
      AppStorage.setOrCreate('uia_shared_text', false)
      if (launchSharedText) {
        this.openReceivedText(launchUrl)
      } else {
        this.openExternalLink(launchUrl, launchExternal)
      }
    }
  }

  // 原版 z8/b0.A ACTION_SEND 分支 → i6.i0.v：文本为 URL 直接打开，否则默认引擎搜索
  private openReceivedText(text: string): void {
    const trimmed = text.trim()
    if (trimmed === '') {
      return
    }
    if (isUrlLike(trimmed)) {
      this.tabStore.navigate(trimmed)
      return
    }
    this.tabStore.navigate(
      buildSearchUrl(this.settings.engineKey, this.settings.activeEngineTemplate(), trimmed))
  }

  // 原版 z8/b0.A() VIEW 分支 → k6.c0 → k6.u()：外部链接先过内部命令分发器。
  // 原版 k6.u()（8562-8687）本身就是所有 URL 的入口：先判 v:// 内部命令，
  // 不匹配再走 8581-8597 的特殊 scheme（thunder/qqdl/flashget 下载、baidubox 忽略、
  // file://*.pdf 内置查看器），最后才 V9() 交给系统 Intent。
  // 因此外部入口必须先尝试 parseUiaDeepLink，命中即按命令处理，未命中才开标签。
  private openExternalLink(url: string, external: boolean): void {
    const cmd = parseUiaDeepLink(url)
    if (cmd === null) {
      // 非 v://、非特殊 scheme → 原版 V9()/普通网页：开标签
      this.tabStore.navigate(url)
      return
    }
    if (cmd.kind === UiaCmdKind.SCHEME_DOWNLOAD) {
      let pageUa = ''
      try {
        pageUa = this.tabStore.current().controller.getUserAgent()
      } catch (error) {
        pageUa = ''
      }
      this.downloads.requestUrlDownload(cmd.url, '', pageUa, '')
      return
    }
    if (cmd.kind === UiaCmdKind.SCHEME_IGNORED) {
      return
    }
    if (cmd.kind === UiaCmdKind.SCHEME_PDF) {
      this.openPdfViewer(cmd.url)
      return
    }
    // 其余 v:// 内部命令（含未知 → CATALOG、NONE → 无动作）统一交给同一分发器，
    // 绝不再把 v://xxx 当网页 URL 塞进标签（原版 k6.u 对这些分支一律 return true）
    AppStorage.setOrCreate('uia_internal_cmd', url)
    this.handleInternalCmd()
  }

  // 原版 k6.u 8592-8596：file:// 且扩展名 pdf → g6.i.h(za.g.class, "pdfPath", str)。
  // PdfViewerPage 的 param 是沙箱文件路径（与 TabWeb.openPdfPreview 同口径换算），不是 URI。
  private openPdfViewer(fileUri: string): void {
    let pdfPath: string = fileUri.substring('file://'.length)
    try {
      pdfPath = decodeURIComponent(pdfPath)
    } catch (error) {
      pdfPath = fileUri.substring('file://'.length)
    }
    if (pdfPath !== '') {
      this.mainNavStack.pushPathByName('pdfViewer', pdfPath, true)
    }
  }

  private setupImmersiveWindow(): void {
    const win = AppStorage.get<window.Window>('mainWindow')
    if (win === undefined) {
      return
    }
    // 基础值由设置决定；若此刻两栏已收起，则按拍板联动一并隐藏
    const baseVisible = this.settings.showStatusBar && !this.settings.fullScreen
    this.applySystemBarsVisible(baseVisible && !this.systemBarsHiddenByToolbar)
    this.insets.refresh(win)
    try {
      win.on('avoidAreaChange', () => {
        this.insets.refresh(win)
      })
    } catch (error) {
      console.error('watch avoidAreaChange failed')
    }
  }

  // 系统栏显隐统一入口（原版 z8/l3.n(window,true) 的 hide(systemBars()) 等价：
  // 状态栏+导航栏整体切换）。仅当期望值变化时才调用窗口接口。
  private applySystemBarsVisible(visible: boolean): void {
    if (visible === this.systemBarsVisible) {
      return
    }
    this.systemBarsVisible = visible
    const win = AppStorage.get<window.Window>('mainWindow')
    if (win === undefined) {
      return
    }
    applyStatusBarVisible(win, visible)
  }

  // 用户拍板联动：两栏收起（隐藏落定）→ 隐藏系统栏；两栏恢复显示 → 还原。
  // 还原时尊重设置：showStatusBar=false 或 fullScreen=true 时本就不显示。
  private syncSystemBarsForToolbar(hidden: boolean): void {
    this.systemBarsHiddenByToolbar = hidden
    const baseVisible = this.settings.showStatusBar && !this.settings.fullScreen
    this.applySystemBarsVisible(baseVisible && !hidden)
  }

  onBackPress(): boolean {
    // 原版 k6 返回键：全屏视频时 V() 退出全屏播放
    if (this.videoOverlay.active) {
      this.videoOverlay.requestExit()
      return true
    }
    // 原版返回键：Fragment 栈顶 f8.w0 翻译面板先出栈
    if (TranslateState.getInstance().visible) {
      TranslateState.getInstance().close()
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
        this.getUIContext().getPromptAction().showToast({ message: $r('app.string.game_mode_toast_off'), duration: TOAST_SHORT })
        // 原版 bb(false)（6822-6844）→ else 分支 → g9()：退出游戏模式隐藏操作栏（模式2）
        this.hideToolbarsForPage()
      } else {
        this.gameModeBackTime = now
        this.getUIContext().getPromptAction().showToast({ message: $r('app.string.press_back_again_exit_game_mode'), duration: TOAST_SHORT })
      }
      return true
    }
    const tab = this.tabStore.current()
    // 原版隐身会话（f2583n1，k6.java:4483-4494）：可后退则后退，多标签关当前标签，否则结束会话
    if (this.tabStore.sessionIncognito && tab.incognito) {
      if (this.tabStore.canGoBack(tab)) {
        this.tabStore.goBack(tab)
        return true
      }
      if (this.tabStore.tabs.length > 1) {
        this.tabStore.closeTab(this.tabStore.currentIndex)
        return true
      }
      this.tabStore.exitIncognitoSession(false)
      return true
    }
    // 原版 k6.I9（4460-4507）：非主页 → U8（可退则退，不可退关标签）；
    // 主页 → 多标签关标签，否则 1500ms 内双击退出
    if (!tab.isHomePage()) {
      this.tabStore.goBack(tab)
      return true
    }
    if (this.tabStore.tabs.length > 1) {
      this.tabStore.closeTab(this.tabStore.currentIndex)
      return true
    }
    const now = Date.now()
    if (now - this.exitHintTime < EXIT_INTERVAL) {
      // 原版 k6.i9()：双击返回显式退出 → na.r0()（z8/h0.c）执行退出清除
      emitter.emit({ eventId: EXIT_CLEAR_EVENT_ID }, { data: {} })
      return false
    }
    this.exitHintTime = now
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.press_back_again_exit'), duration: TOAST_SHORT })
    return true
  }

  // ===== 原版 PC 键盘快捷键（mark/uia/Shell.dispatchKeyEvent → c8/k6.n8 → L9/M9）=====

  // 原版 k6.n8：宿主按键分发入口（onInterceptKeyEvent / onKeyEvent 双通道共用）
  private handlePcKey(event: KeyEvent): boolean {
    if (event.type !== KeyType.Down) {
      return false
    }
    const ctrl = this.pcModifierDown(event, 'Ctrl')
    const alt = this.pcModifierDown(event, 'Alt')
    const shift = this.pcModifierDown(event, 'Shift')
    return this.dispatchPcKey(event.keyCode, ctrl, alt, shift)
  }

  // KeyEvent.getModifierKeyState（API 12）：查询 Ctrl/Alt/Shift 按下态
  private pcModifierDown(event: KeyEvent, modifier: string): boolean {
    try {
      if (event.getModifierKeyState !== undefined) {
        return event.getModifierKeyState([modifier])
      }
    } catch (error) {
      console.error('getModifierKeyState failed')
    }
    return false
  }

  // 原版 k6.w9()：Fragment 栈空（无弹层）才进入快捷键主流程
  private pcOverlayOpen(): boolean {
    return this.showMenu || this.showSearch || this.showTabPanel || this.showFindBar || this.showAi ||
      this.showMediaList || this.downloadConfirm !== null || this.showReadAloudPanel ||
      TranslateState.getInstance().visible
  }

  // 主场景：无弹层且未进入设置等二级页（原版设置页为独立 Activity，k6 不可见不处理）
  private pcMainScene(): boolean {
    return !this.pcOverlayOpen() && this.mainNavStack.size() === 0
  }

  // 原版 k6.n8 弹层分支：仅 ESC（keyCode 111 → d9/e1）关闭顶层弹层，其余按键放行
  private pcEscape(): void {
    if (this.pcOverlayOpen()) {
      this.pcCloseTopOverlay()
    }
    // 原版 L9 case 111：无弹层时消费、无动作
  }

  // 关闭顶层弹层（顺序与 onBackPress 一致）
  private pcCloseTopOverlay(): void {
    // f8.w0 翻译面板：Fragment 栈顶，最先关闭
    if (TranslateState.getInstance().visible) {
      TranslateState.getInstance().close()
      return
    }
    if (this.showMediaList) {
      this.showMediaList = false
      return
    }
    if (this.showSearch) {
      this.showSearch = false
      return
    }
    if (this.showAi) {
      if (this.aiBackHandler !== null) {
        this.aiBackHandler()
      } else {
        this.showAi = false
      }
      return
    }
    if (this.showMenu) {
      this.showMenu = false
      return
    }
    if (this.showTabPanel) {
      this.showTabPanel = false
      return
    }
    if (this.showFindBar) {
      this.showFindBar = false
      try {
        this.tabStore.current().controller.clearMatches()
      } catch (error) {
        console.error('clearMatches failed')
      }
      return
    }
    if (this.downloadConfirm !== null) {
      const info = this.downloadConfirm
      if (info.kind === 'web') {
        this.downloads.cancelPendingDownload(info.guid)
      } else {
        this.downloads.cancelPendingUrlDownload()
      }
      this.downloadConfirm = null
      return
    }
    if (this.showReadAloudPanel) {
      this.showReadAloudPanel = false
    }
  }

  // 原版 k6.L9：主场景 keyCode → 动作 1:1（Ctrl/Alt/F 系全量分支）
  private dispatchPcKey(keyCode: number, ctrl: boolean, alt: boolean, shift: boolean): boolean {
    if (keyCode === KeyCode.KEYCODE_ESCAPE) {
      this.pcEscape()
      return true
    }
    if (this.pcOverlayOpen() || this.mainNavStack.size() > 0) {
      return false
    }
    if (keyCode === KeyCode.KEYCODE_HOME) {
      // 原版 case 3：Alt+Home → na.V0() 回主页
      if (alt) {
        this.pcGotoHome()
        return true
      }
      return false
    }
    if (keyCode === KeyCode.KEYCODE_DPAD_LEFT) {
      // 原版 case 21：Alt+← → ra(12)=U8 网页后退
      if (alt) {
        this.pcBackward()
        return true
      }
      return false
    }
    if (keyCode === KeyCode.KEYCODE_DPAD_RIGHT) {
      // 原版 case 22：Alt+→ → ra(13)=V8 网页前进
      if (alt) {
        this.pcForward()
        return true
      }
      return false
    }
    if (keyCode === KeyCode.KEYCODE_TAB) {
      // 原版 case 61：Ctrl+Tab → ra(11) 下一个标签；Ctrl+Shift+Tab → ra(10) 上一个标签
      if (ctrl) {
        if (shift) {
          this.pcSwitchTab(-1)
        } else {
          this.pcSwitchTab(1)
        }
        return true
      }
      return false
    }
    if (keyCode === KeyCode.KEYCODE_MENU) {
      // 原版 case 82：菜单键 → tb() 打开菜单
      this.pcMenu()
      return true
    }
    if (keyCode === KeyCode.KEYCODE_SEARCH) {
      // 原版 case 84：搜索键 → ra(4) 聚焦地址栏
      this.pcFocusAddress()
      return true
    }
    if (keyCode === KeyCode.KEYCODE_F5) {
      // 原版 case 135：F5 → ra(1) 刷新
      this.pcRefresh()
      return true
    }
    if (keyCode === KeyCode.KEYCODE_PAGE_UP) {
      // 原版 case 92：上翻页 → z8.b0.V(wv, 2)
      this.pcPageUp()
      return true
    }
    if (keyCode === KeyCode.KEYCODE_PAGE_DOWN) {
      // 原版 case 93：下翻页 → z8.b0.V(wv, 3)
      this.pcPageDown()
      return true
    }
    if (ctrl) {
      if (keyCode === KeyCode.KEYCODE_T) {
        // 原版 case 48：Ctrl+T → ra(5) 新建标签 + na() 聚焦地址
        this.pcNewTab()
        return true
      }
      if (keyCode === KeyCode.KEYCODE_U) {
        // 原版 case 49：Ctrl+U → ra(20) 查看源码
        this.pcSource()
        return true
      }
      if (keyCode === KeyCode.KEYCODE_W) {
        // 原版 case 51：Ctrl+W → ra(9)=na.B0() 关闭标签
        this.pcCloseTab()
        return true
      }
      if (keyCode === KeyCode.KEYCODE_B) {
        // 原版 case 30：Ctrl+Shift+B → ra(7) 书签
        if (shift) {
          this.pcBookmarks()
          return true
        }
        return false
      }
      if (keyCode === KeyCode.KEYCODE_L) {
        // 原版 case 40：Ctrl+L → ra(4) 输入网址
        this.pcFocusAddress()
        return true
      }
      if (keyCode === KeyCode.KEYCODE_R) {
        // 原版 case 46：Ctrl+R → ra(1) 刷新
        this.pcRefresh()
        return true
      }
      if (keyCode === KeyCode.KEYCODE_D) {
        // 原版 case 32：Ctrl+D → ra(6)=P7() 添加书签
        this.pcAddBookmark()
        return true
      }
      if (keyCode === KeyCode.KEYCODE_F) {
        // 原版 case 34：Ctrl+F → ra(14) 页内查找
        this.pcFind()
        return true
      }
      if (keyCode === KeyCode.KEYCODE_G) {
        // 原版 case 35：Ctrl+G → ra(21)=E8(true) 查找下一个；+Shift → ra(22) 上一个
        if (shift) {
          this.pcFindPrev()
        } else {
          this.pcFindNext()
        }
        return true
      }
      if (keyCode === KeyCode.KEYCODE_H) {
        // 原版 case 36：Ctrl+H → ra(8) 历史
        this.pcHistory()
        return true
      }
      if (keyCode === KeyCode.KEYCODE_0) {
        // 原版 case 16：Ctrl+0 → 切换到最后一个标签
        this.pcTabDigit(0)
        return true
      }
      if (keyCode >= KeyCode.KEYCODE_1 && keyCode <= KeyCode.KEYCODE_9) {
        // 原版 case 8-15：Ctrl+1..9 → 切换到第 N 个标签
        this.pcTabDigit(keyCode - KeyCode.KEYCODE_1 + 1)
        return true
      }
      return false
    }
    if (alt && keyCode === KeyCode.KEYCODE_F) {
      // 原版 case 34 Alt 分支：Alt+F → tb() 菜单
      this.pcMenu()
      return true
    }
    return false
  }

  // 原版 ra(5)+na()：新建前台标签（隐身会话内为隐身标签）并打开地址输入
  private pcNewTab(): void {
    if (!this.pcMainScene()) {
      return
    }
    this.tabStore.newTab(this.tabStore.sessionIncognito)
    this.searchInitialText = ''
    this.showSearch = true
  }

  // 原版 ra(9)=na.B0()：关闭当前标签
  private pcCloseTab(): void {
    if (!this.pcMainScene()) {
      return
    }
    this.tabStore.closeTab(this.tabStore.currentIndex)
  }

  // 原版 ra(10/11)：上/下一个标签（越界回绕）
  private pcSwitchTab(delta: number): void {
    if (!this.pcMainScene()) {
      return
    }
    const count = this.tabStore.tabs.length
    if (count === 0) {
      return
    }
    let target = this.tabStore.currentIndex + delta
    if (target < 0) {
      target = count - 1
    } else if (target >= count) {
      target = 0
    }
    this.tabStore.switchTo(target)
  }

  // 原版 ra(12)=U8：网页后退
  private pcBackward(): void {
    if (!this.pcMainScene()) {
      return
    }
    this.tabStore.goBack(this.tabStore.current())
  }

  // 原版 ra(13)=V8：网页前进
  private pcForward(): void {
    if (!this.pcMainScene()) {
      return
    }
    this.tabStore.goForward(this.tabStore.current())
  }

  // 原版 tb()：打开菜单（k6.java:8547-8558 —— 先算 N8() 宽与 i10 贴边距）
  private pcMenu(): void {
    if (!this.pcMainScene()) {
      return
    }
    this.publishMenuMetrics()
    this.showMenu = true
  }

  // 原版 ra(7)=ja(true)：书签页
  private pcBookmarks(): void {
    if (!this.pcMainScene()) {
      return
    }
    this.openPage('bookmarks')
  }

  // 原版 ra(8)=ja(false)：历史页
  private pcHistory(): void {
    if (!this.pcMainScene()) {
      return
    }
    this.openPage('history')
  }

  // 原版 ra(14)：页内查找（弹层打开则先关闭再开查找，等价 d9 判断）
  private pcFind(): void {
    if (!this.pcMainScene()) {
      return
    }
    this.showFindBar = true
  }

  // 原版 ra(4)=ub()+na()：聚焦地址栏（带入当前网址/剪贴板语义同地址栏点击）
  private pcFocusAddress(): void {
    if (!this.pcMainScene()) {
      return
    }
    this.searchInitialText = this.addressTapInitialText()
    this.showSearch = true
  }

  // 原版 ra(1)=wa()：刷新当前网页
  private pcRefresh(): void {
    if (!this.pcMainScene()) {
      return
    }
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      return
    }
    try {
      tab.controller.refresh()
    } catch (error) {
      console.error('refresh failed')
    }
  }

  // 原版 ra(20)=na.i2()：查看源码（复用工具栏命令实现）
  private pcSource(): void {
    if (!this.pcMainScene()) {
      return
    }
    this.handleToolbarCommand('viewSource')
  }

  // 原版 ra(6)=P7()：添加书签（复用工具栏命令实现）
  private pcAddBookmark(): void {
    if (!this.pcMainScene()) {
      return
    }
    this.handleToolbarCommand('addBookmark')
  }

  // 原版 ra(21)=E8(true)：查找下一个
  private pcFindNext(): void {
    if (!this.pcMainScene()) {
      return
    }
    try {
      this.tabStore.current().controller.searchNext(true)
    } catch (error) {
      console.error('searchNext failed')
    }
  }

  // 原版 ra(22)=E8(false)：查找上一个
  private pcFindPrev(): void {
    if (!this.pcMainScene()) {
      return
    }
    try {
      this.tabStore.current().controller.searchNext(false)
    } catch (error) {
      console.error('searchNext failed')
    }
  }

  // 原版 na.V0()：回主页（已在主页则不动作）
  private pcGotoHome(): void {
    if (!this.pcMainScene()) {
      return
    }
    if (!this.tabStore.current().isHomePage()) {
      this.tabStore.gotoHome()
    }
  }

  // 原版 z8.b0.V(wv, 2)：上翻页（0.8 屏动画滚动）
  private pcPageUp(): void {
    if (!this.pcMainScene()) {
      return
    }
    this.scrollCurrentPage(-1)
  }

  // 原版 z8.b0.V(wv, 3)：下翻页
  private pcPageDown(): void {
    if (!this.pcMainScene()) {
      return
    }
    this.scrollCurrentPage(1)
  }

  // 原版 case 8-16：Ctrl+数字切换标签（0=最后一个）
  private pcTabDigit(digit: number): void {
    if (!this.pcMainScene()) {
      return
    }
    const count = this.tabStore.tabs.length
    if (count === 0) {
      return
    }
    const target = digit === 0 ? count - 1 : digit - 1
    if (target < count) {
      this.tabStore.switchTo(target)
    }
  }

  // 原版 k6.h 粘贴项：剪贴板文本经 AppStorage 传递后带入搜索输入框
  private addressTapInitialText(): string {
    const paste = AppStorage.get<string>('uia_paste_url') ?? ''
    if (paste !== '') {
      AppStorage.setOrCreate('uia_paste_url', '')
      return paste
    }
    const tab = this.tabStore.current()
    return tab.isHomePage() ? '' : tab.url
  }

  // ============ 原版菜单窗口尺寸（k6.tb / N8，供 MenuSheet 取用） ============
  // 原版 c8/k6.java:8557-8558：
  //   int i10 = this.W0 == 1 ? 48 : 80;                       // 贴边距
  //   i8.k.y3(S8(), Q8(), N8(), i10 | 8388613);              // 宽 = N8()，gravity=LEFT|TOP
  // 原版 N8()（5072-5078）：
  //   int iMin = min(f2606z0.getMeasuredWidth(), f2606z0.getMeasuredHeight());  // 容器短边
  //   if (iMin == 0) iMin = g6.y.p(I());                     // 短边 = min(屏宽,屏高)
  //   return (!this.Z0 || this.W0 == 0) ? iMin
  //        : Math.min(iMin - g6.y.h(I(), 96.0f), g6.y.h(I(), 384.0f));  // 大屏且非布局0
  // Z0 = g6.y.E(context)（k6.java:8398）：screenLayout 为 LARGE/XLARGE 且对角线 >= 7 英寸。
  // 鸿蒙侧等价判据：窗口短边 vp >= 600（UiaDialogCard 同口径的大屏分界）。
  private largeScreenByShortSide(): boolean {
    const shortVp: number = this.windowShortSideVp()
    return shortVp >= 600
  }

  // 应用窗口短边（vp）：分屏/悬浮窗时需要窗口尺寸而非物理屏，
  // 与 computeDialogWidthVp 同口径（AppStorage 的 mainWindow → windowRect，失败退物理屏）
  private windowShortSideVp(): number {
    try {
      let wPx: number = 0
      let hPx: number = 0
      const win = AppStorage.get<window.Window>('mainWindow')
      if (win) {
        const rect = win.getWindowProperties().windowRect
        wPx = rect.width
        hPx = rect.height
      }
      if (wPx <= 0 || hPx <= 0) {
        const d = display.getDefaultDisplaySync()
        wPx = d.width
        hPx = d.height
      }
      const density: number = display.getDefaultDisplaySync().densityPixels
      if (density <= 0 || wPx <= 0) {
        return 360
      }
      const wVp: number = wPx / density
      const hVp: number = hPx / density
      return Math.min(wVp, hVp)
    } catch (error) {
      return 360
    }
  }

  // 原版 N8()：菜单可用边长
  menuAvailableSizeVp(): number {
    const shortVp: number = this.windowShortSideVp()
    if (!this.largeScreenByShortSide() || this.effectiveLayout() === LAYOUT_TRADITIONAL) {
      return shortVp
    }
    return Math.min(shortVp - 96, 384)
  }

  // 原版 k6.java:8557：贴边距 = 布局1（工具栏在上）时 48，其余 80
  menuSideGapVp(): number {
    return this.effectiveLayout() === LAYOUT_TOOLBAR_TOP ? 48 : 80
  }

  // 打开菜单前把尺寸参数发布给 MenuSheet（MenuSheet 不在本域，取用端由主控接线）：
  //   AppStorage 'uia_menu_size_vp'     : number  菜单可用边长（原版 N8()）
  //   AppStorage 'uia_menu_side_gap_vp' : number  贴边距（原版 i10）
  //   AppStorage 'uia_menu_layout'      : number  Ya() 后的有效布局（0/1/2/3）
  private publishMenuMetrics(): void {
    AppStorage.setOrCreate('uia_menu_size_vp', this.menuAvailableSizeVp())
    AppStorage.setOrCreate('uia_menu_side_gap_vp', this.menuSideGapVp())
    AppStorage.setOrCreate('uia_menu_layout', this.effectiveLayout())
  }

  private bottomBg(): ResourceColor {
    if (this.tabStore.current().isHomePage() && this.settings.homeBgColor !== '') {
      // 原版夜间联动：自设背景色经黑滤镜后用于工具栏
      return this.settings.nightBlend(this.settings.homeBgColor)
    }
    return $r('app.color.home_bg')
  }

  // 原版 k6.oa U0（工具栏当前背景色）：仅 theme-color 适配生效（背景为 hex 自定义色）时
  // 返回该色，否则空串（对应 U0==0）。夜间强制默认色（z11 的 n0.d() 拦截，bit2=false）。
  private toolbarCustomBg(): string {
    if (this.settings.isNightActive()) {
      return ''
    }
    const bg = toolbarBackgroundColor(this.tabStore.current(), this.settings)
    return typeof bg === 'string' ? bg : ''
  }

  // 原版 k6.C1 = getConfiguration().orientation：设备物理方向。
  // display.Orientation: PORTRAIT=0 / LANDSCAPE=1 / PORTRAIT_INVERTED=2 / LANDSCAPE_INVERTED=3
  // 仅 LANDSCAPE(1) 与 LANDSCAPE_INVERTED(3) 为横屏；PC/平板未旋转时是 PORTRAIT，不触发映射。
  private refreshPhysicalOrientation(): void {
    try {
      const o = display.getDefaultDisplaySync().orientation
      this.physicalLandscape = o === display.Orientation.LANDSCAPE
        || o === display.Orientation.LANDSCAPE_INVERTED
    } catch (error) {
      this.physicalLandscape = false
    }
  }

  // 原版 Ya()：横屏时布局 0→1、3→2（k6.java:6414-6418，判据为设备物理方向 C1==2）
  private effectiveLayout(): number {
    const layout = this.settings.appLayout
    if (!this.physicalLandscape) {
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

  // ==================== 自动隐藏操作栏（原版 k6 全链路 1:1） ====================
  // 原版总开关：fullscreenmode（w9/k.java:1340 d3，默认 0）
  //   0=总是显示、1=滑动隐藏/显示、2=点击隐藏/显示（arrays d = jt/ju/jv）
  // X0（k6.Jb:4637-4659）：仅布局 1/2（工具栏上/下）支持自动隐藏；传统(0)/双行(3)恒显。
  // 原版语义（k6.java 逐行核对）：
  //   f2591r1 = 隐藏进度：0=显示 1=隐藏（初始 0.0）；db(p)：顶栏 ty=-p*h、底栏 ty=+p*h、
  //   网页容器 ty=h*(1-p)（工具栏在上时贴顶，4296-4310/G8）。
  //   f2589q1 = 显示态（初始 true）。G8(show)/S7(show)/j(show)/e(show) 的参数=显示。
  //   ub() = S7(true) 显示（FAB 点击/回主页/退出游戏模式）；g9() = S7(false) 隐藏（模式2）。

  // 原版 k6.a.k(view)（415-418）：r2==1 || (r2==2 && 进度<1)，且 X0==1（Jb 默认布局
  // 非0时 X0=1，传统/双行也成立——原版所有布局都能隐藏，db() 内部对非 X0==1 布局
  // 强制进度 0）、非全屏视频（f2590r0）、非游戏模式（f2578k1）、非自定义视图
  private canAutoHideGesture(): boolean {
    const mode = this.settings.toolbarAutoHide
    if (mode !== 1 && !(mode === 2 && this.toolbarHideProgress < 1)) {
      return false
    }
    if (this.settings.gameMode || this.videoOverlay.active) {
      return false
    }
    if (this.showSearch || this.showMenu || this.showTabPanel || this.showAi || this.showFindBar) {
      return false
    }
    return true
  }

  // 原版 GestureTouchEvent.n() → k6.ta()（8539-8545）：拖动开始
  //   X7()（取消 S7 动画）+ Y7()（清各栏 animator）+ 双栏 VISIBLE + db(当前进度)
  private onToolbarDragStart(): void {
    this.toolbarAnimRunning = false
  }

  // —— IndexAutoHideHost 桥接（类在文件底部，需要跨 struct 访问）——
  autoHideIsHidden(): boolean {
    // 原版 a() 返回 f2589q1 = 显示态；宿主接口 isHidden 语义 = !f2589q1
    return !this.toolbarShown
  }

  autoHideOnDragStart(): void {
    this.onToolbarDragStart()
  }

  autoHideOnProgress(f: number): void {
    this.applyToolbarProgress(f)
  }

  autoHideOnSettle(show: boolean): void {
    this.setToolbarsShownAnimated(show)
  }

  autoHideOnCommitImmediate(show: boolean): void {
    this.setToolbarsShownImmediate(show)
  }

  autoHideCanGesture(): boolean {
    return this.canAutoHideGesture()
  }

  autoHideExtentPx(): number {
    return vp2px(this.autoHideExtentVp())
  }

  autoHideProgress(): number {
    return this.toolbarHideProgress
  }

  autoHideSwipeModeOnly(): boolean {
    return this.settings.toolbarAutoHide === 1
  }

  // 原版 k6.db(f)（6969-6993）：隐藏进度钳制到 [0,1]（X0==1 时，Jb 对一切
  // 非传统特例布局都置 X0=1）；顶栏 ty=-p*h、底栏 ty=+p*h
  private applyToolbarProgress(f: number): void {
    this.toolbarHideProgress = Math.max(0, Math.min(1, f))
  }

  // 原版 k6.S7(show)（5759-5778）：ValueAnimator 当前进度→db(show?0:1) 目标，
  //   时长 = |目标-当前| * 180ms，插值器 x8.h.b() = PathInterpolator(0.2,0.2,0.8,0.8)，
  //   结束 G8(show) 落定可见性
  private setToolbarsShownAnimated(show: boolean): void {
    const target = show ? 0 : 1
    if (Math.abs(this.toolbarHideProgress - target) < 0.001) {
      this.finishToolbarsState(show)
      return
    }
    this.toolbarAnimRunning = true
    this.getUIContext().animateTo({
      duration: Math.max(1, Math.round(Math.abs(target - this.toolbarHideProgress) * 180)),
      curve: BEZIER_0202_CURVE,
      onFinish: (): void => {
        this.toolbarAnimRunning = false
        this.finishToolbarsState(show)
      }
    }, () => {
      this.toolbarHideProgress = target
    })
  }

  // 原版 k6.G8(show)（4293-4318）：db(show?0:1) 落定位移；显示恢复 VISIBLE，
  //   隐藏后置 GONE；f2589q1=show 状态落定。FAB 联动：显示→f9(true)，隐藏→pb()
  private finishToolbarsState(show: boolean): void {
    this.toolbarHideProgress = show ? 0 : 1
    this.toolbarShown = show
    // 用户拍板联动（刻意偏离原版）：两栏收起→隐藏系统栏，恢复→还原，
    // 避免网页铺满后与常显状态栏重叠。
    this.syncSystemBarsForToolbar(!show)
    if (show) {
      this.hideFab()
    } else {
      this.maybeShowFab()
    }
  }

  // 原版拖动中越界（GestureTouchEvent.d → b.e(show) → k6.G8）：立即落定，无动画
  private setToolbarsShownImmediate(show: boolean): void {
    this.toolbarAnimRunning = false
    this.finishToolbarsState(show)
  }

  // 原版 k6.ub()（8718-8725）：X0!=0 且（!f2589q1 或 进度>0）→ S7(true) 显示。
  //   调用点：FAB 点击（t0.j→c.d）、主页动作（ra case4）、退出游戏模式（bb(false)）
  showToolbarsForPage(): void {
    if (this.settings.toolbarAutoHide === 0) {
      return
    }
    if (!this.toolbarShown || this.toolbarHideProgress > 0) {
      this.setToolbarsShownAnimated(true)
    }
  }

  // 原版 k6.g9()（7200-7207）：X0!=0 且（f2589q1 或 进度<1）→ S7(false) 隐藏。
  //   调用点：游戏模式开启（bb(true)→g9）。原版页面加载/标题落定（d9）不触发
  //   隐藏——只做 pb() FAB 保活。
  hideToolbarsForPage(): void {
    if (this.settings.toolbarAutoHide === 0) {
      return
    }
    if (this.toolbarShown || this.toolbarHideProgress < 1) {
      this.setToolbarsShownAnimated(false)
    }
  }

  // 原版 k6.pb()（8051-8065）：G8(false) 隐藏落定后浮现 FAB——
  //   闸：f2578k1(游戏模式)/f2597u1(已显)/!Y0(非点击模式)/f2589q1(已显示) 直接返回；
  //   k9() 首次创建（尺寸 42dp=dimen v、内边距 10dp、背景 cr=N1 白圆），随后
  //   alpha 0→1 / translation 32dp→0，160ms（ViewPropertyAnimator 默认插值器）
  private maybeShowFab(): void {
    if (this.settings.toolbarAutoHide !== 2 || this.settings.gameMode
      || this.fabShown || this.toolbarShown) {
      return
    }
    this.fabShown = true
    this.fabVisible = true
    this.getUIContext().animateTo({ duration: 160, curve: DECELERATE_CURVE }, () => {
      this.fabAlpha = 1
      this.fabOffsetX = 0
      this.fabOffsetY = 0
    })
  }

  // 原版 k6.f9(show=true)（7091-7107）：显示工具栏时 FAB 淡出
  //   （alpha→0 位移-32dp 160ms 后 GONE；false 分支直接 GONE）
  private hideFab(): void {
    if (!this.fabShown) {
      return
    }
    this.fabShown = false
    this.getUIContext().animateTo({
      duration: 160,
      curve: DECELERATE_CURVE,
      onFinish: (): void => {
        this.fabVisible = false
      }
    }, () => {
      this.fabAlpha = 0
      this.fabOffsetX = -vp2px(32)
      this.fabOffsetY = -vp2px(32)
    })
  }

  // 原版 t0.j()（226-228）：FAB 点击（未拖动、<300ms）→ c.d() 回调 → k6.ub() 显示
  private onFabTap(): void {
    this.showToolbarsForPage()
  }

  // 原版 t0.i()（176-206）→ c.b(dir)（k6.a.b:584-603）：FAB 拖动松手按方向执行
  // 五方向动作键（fab 键：fableftaction=12 后退 / fabrightaction=13 前进 /
  // fabupaction=23 上翻页 / fabdownaction=1 刷新；1=左 2=右 4=上 8=下）
  private onFabFling(dir: number): void {
    let action = 0
    if (dir === 1) {
      action = this.settings.fableftaction
    } else if (dir === 2) {
      action = this.settings.fabrightaction
    } else if (dir === 4) {
      action = this.settings.fabupaction
    } else if (dir === 8) {
      action = this.settings.fabdownaction
    }
    if (action === 12) {
      // 原版 ra(12) → U8
      this.tabStore.goBack(this.tabStore.current())
    } else if (action === 13) {
      // 原版 ra(13) → V8
      this.tabStore.goForward(this.tabStore.current())
    } else if (action === 23) {
      try {
        this.tabStore.current().controller.runJavaScript('window.scrollBy(0, -window.innerHeight)')
      } catch (error) {
        console.error('fab page up failed')
      }
    } else if (action === 1) {
      try {
        this.tabStore.current().controller.refresh()
      } catch (error) {
        console.error('fab refresh failed')
      }
    }
  }

  // 原版 t0.h()：FAB 拖动方向判定（f9782l = 位移超 30dp 的方向位：1=左 2=右 4=上 8=下）
  private fabDragDir(offsetX: number, offsetY: number): number {
    if (Math.abs(offsetX) > 30) {
      return offsetX <= 0 ? 1 : 2
    }
    if (Math.abs(offsetY) > 30) {
      return offsetY <= 0 ? 4 : 8
    }
    return 0
  }

  // ============ FAB 触摸三段语义（t0.java 1:1） ============
  // DOWN：300ms 定时器把 f9774d=true（长按→自由拖动，alpha 0.5 + 震动）
  // MOVE：f9774d → 自由拖动 translation 跟手；否则单轴 0.75 增益限幅拖动，
  //       拖出方向超 30dp（f9783m）记 f9782l 位（1左/2右/4上/8下）并 c(dir) 换图标
  // UP：  f9774d → 吸附九宫 e()（fab(int) 持久化）回位；拖出方向 → b(dir) 动作键；
  //       <300ms 未动 → d() = ub() 显示工具栏
  private fabLongPressTimer: number = -1
  private fabTouchDownTime: number = 0
  private fabTouchStartX: number = 0
  private fabTouchStartY: number = 0
  // 自由拖动基准（绝对坐标，vp）：DOWN 时由锚定基准换算
  private fabAbsBaseX: number = 0
  private fabAbsBaseY: number = 0

  // 原版 t0.h()：非长按态的单轴限幅拖动。返回 translation [x, y]（相对锚点位）
  private fabClampedDrag(dx: number, dy: number): number[] {
    // 方向锁：首次超 6dp（f9772b）锁定横/竖（f9776f：3=横、12=竖）
    if (this.fabAxisLock === 0) {
      if (Math.abs(dx) > 6 || Math.abs(dy) > 6) {
        this.fabAxisLock = Math.abs(dx) > Math.abs(dy) ? 3 : 12
      } else {
        return [0, 0]
      }
    }
    if ((this.fabAxisLock & 3) !== 0) {
      // 原版单侧限位：贴左（i10&1==0）不允许负位移、贴右（i10&2==0）不允许正位移
      const allowLeft = !this.fabAlignLeft
      const allowRight = !this.fabAlignRight
      const scaled = dx * 0.75
      let tx = this.fabDragBaseX + scaled
      if (!allowLeft) {
        tx = Math.max(0, tx)
      }
      if (!allowRight) {
        tx = Math.min(0, tx)
      }
      return [tx, 0]
    }
    const allowUp = !this.fabAlignTop
    const allowDown = !this.fabAlignBottom
    const scaledY = dy * 0.75
    let ty = this.fabDragBaseY + scaledY
    if (!allowUp) {
      ty = Math.max(0, ty)
    }
    if (!allowDown) {
      ty = Math.min(0, ty)
    }
    return [0, ty]
  }

  private fabAxisLock: number = 0

  private handleFabTouch(action: number, x: number, y: number): void {
    // action 0=down 1=up 2=move 3=cancel；x/y 为窗口坐标（windowX/windowY，vp），
    // 不随 FAB 自身 translate 漂移，保证拖动增量稳定。
    if (action === 0) {
      this.fabTouchDownTime = Date.now()
      this.fabTouchStartX = x
      this.fabTouchStartY = y
      this.fabLastTouchX = x
      this.fabLastTouchY = y
      this.fabAxisLock = 0
      this.fabDragBaseX = 0
      this.fabDragBaseY = 0
      this.fabDirFlag = 0
      this.fabFreeDrag = false
      this.fabAlpha = 1
      // 原版 f9771a：300ms 后进入自由拖动
      this.fabLongPressTimer = setTimeout(() => {
        this.fabFreeDrag = true
        this.fabAlpha = 0.5
      }, 300)
      return
    }
    if (action === 2) {
      const dx = x - this.fabTouchStartX
      const dy = y - this.fabTouchStartY
      if (this.fabFreeDrag) {
        // 自由拖动：translation 跟手（无增益，原版 setTranslation 直接累加 raw 差值）
        this.fabOffsetX = this.fabOffsetX + (x - this.fabLastTouchX)
        this.fabOffsetY = this.fabOffsetY + (y - this.fabLastTouchY)
      } else {
        const t = this.fabClampedDrag(dx, dy)
        this.fabOffsetX = t[0]
        this.fabOffsetY = t[1]
        // f9782l：单轴位移超 30dp 记方向位
        if (Math.abs(this.fabOffsetX) > 30) {
          this.fabDirFlag = this.fabOffsetX <= 0 ? 1 : 2
        } else if (Math.abs(this.fabOffsetY) > 30) {
          this.fabDirFlag = this.fabOffsetY <= 0 ? 4 : 8
        } else {
          this.fabDirFlag = 0
        }
      }
      this.fabLastTouchX = x
      this.fabLastTouchY = y
      return
    }
    // UP / CANCEL
    if (this.fabLongPressTimer >= 0) {
      clearTimeout(this.fabLongPressTimer)
      this.fabLongPressTimer = -1
    }
    if (action === 3) {
      // CANCEL：原版 onTouch 不处理 action==3（半透明态残留至下次 DOWN 复位）
      this.fabFreeDrag = false
      this.fabAlpha = 1
      this.fabOffsetX = 0
      this.fabOffsetY = 0
      return
    }
    const elapsed = Date.now() - this.fabTouchDownTime
    if (this.fabFreeDrag) {
      // 长按自由拖动松手：吸附九宫 + fab(int) 持久化 + 回位
      this.fabFreeDrag = false
      this.fabAlpha = 1
      this.snapFabToGrid()
    } else if (this.fabDirFlag !== 0) {
      // 快速拖出方向：b(dir) 执行五方向动作键，图标复位 c(0)
      this.onFabFling(this.fabDirFlag)
      this.fabDirFlag = 0
      this.fabOffsetX = 0
      this.fabOffsetY = 0
    } else if (elapsed < 300) {
      // t0.j()：短按（<300ms、未拖动、未长按）→ d() → ub() 显示工具栏
      this.onFabTap()
      this.fabOffsetX = 0
      this.fabOffsetY = 0
    } else {
      // 长按未拖动：回位
      this.fabOffsetX = 0
      this.fabOffsetY = 0
    }
  }

  private fabLastTouchX: number = 0
  private fabLastTouchY: number = 0
  @Local fabDirFlag: number = 0

  // 原版 c.e()（k6.java:624-668）吸附：x 三分（左/中/右）、y 下 1/4 分界（上/中/下），
  // 结果写回设置 fab(int)（o2），位置由 Gravity 重排（Ga）
  private snapFabToGrid(): void {
    // 取 FAB 中心点（把当前 translation 加到锚定基准上，换算为屏幕三分判定）
    const parentW = this.fabParentW()
    const parentH = this.fabParentH()
    if (parentW <= 0 || parentH <= 0) {
      this.fabOffsetX = 0
      this.fabOffsetY = 0
      return
    }
    const size = this.fabSize
    const margin = this.fabMargin
    // 当前中心（锚定基准 + translation）
    const baseCenterX = this.fabAlignLeft ? margin + size / 2 : parentW - margin - size / 2
    const baseCenterY = this.fabAlignTop ? margin + size / 2 : parentH - margin - size / 2
    const cx = baseCenterX + this.fabOffsetX
    const cy = baseCenterY + this.fabOffsetY
    // 原版三分判定（e()）：x < w/3 → 左、x > 2w/3 → 右；y ≥ 3h/4-margin → 底、
    // y ≥ h/2 → 中、否则顶。命中后写 fab(int)，Ga() 按 Gravity 重排
    let gravityX = 0
    if (cx < parentW / 3) {
      gravityX = 3
    } else if (cx > parentW / 3 * 2) {
      gravityX = 5
    } else {
      gravityX = 1
    }
    let gravityY = 0
    if (cy >= parentH / 4 * 3 - margin) {
      gravityY = 80
    } else if (cy >= parentH / 2) {
      gravityY = 16
    } else {
      gravityY = 16
      // 原版顶部三分无独立重力（16=TOP），中带与顶带同落 TOP
    }
    const newGravity = gravityX | gravityY
    this.settings.setFab(newGravity)
    this.initFabPosition()
    this.fabOffsetX = 0
    this.fabOffsetY = 0
  }

  // 原版 Jb()：X0==0 时网页容器用 BELOW/ABOVE 规则夹在两栏之间。
  // 布局 2/3（工具栏在下/双行）原版 Ya 令顶栏 height=0，故顶侧不让位；
  // 游戏模式/全屏视频时双栏 GONE（P1），两值均归零。
  private webTopPadding(): number {
    if (this.settings.toolbarAutoHide !== 0
      || this.settings.gameMode || this.videoOverlay.active) {
      return 0
    }
    const layout = this.effectiveLayout()
    return (layout === LAYOUT_TRADITIONAL || layout === LAYOUT_TOOLBAR_TOP)
      ? this.topBarHeightVp : 0
  }

  private webBottomPadding(): number {
    if (this.settings.toolbarAutoHide !== 0
      || this.settings.gameMode || this.videoOverlay.active) {
      return 0
    }
    return this.bottomBarHeightVp
  }

  // 原版 db()：f2586p0.setTranslationY(height*(1-f2591r1))，仅 X0==1 生效。
  private webViewportTranslate(): number {
    if (this.settings.toolbarAutoHide === 0
      || this.settings.gameMode || this.videoOverlay.active) {
      return 0
    }
    return this.topBarHeightVp * (1 - this.toolbarHideProgress)
  }

  private fabParentW(): number {
    const ctx = this.getUIContext().getHostContext()
    if (ctx === undefined) {
      return 0
    }
    const d = display.getDefaultDisplaySync()
    return d.width / d.densityPixels
  }

  private fabParentH(): number {
    const ctx = this.getUIContext().getHostContext()
    if (ctx === undefined) {
      return 0
    }
    const d = display.getDefaultDisplaySync()
    return d.height / d.densityPixels
  }

  // 系统栏隐藏后 decor 不再为状态栏留白，顶栏自然贴屏幕顶端。
  // 两种隐藏来源：菜单「全屏」设置，或用户拍板的「两栏收起联动」。
  // 若系统栏已隐藏却仍按 insets 留白，就会出现顶部空白与网页重叠的观感。
  private effectiveInsetTop(): number {
    return (this.settings.fullScreen || !this.systemBarsVisible) ? 0 : this.insets.top
  }

  private effectiveInsetBottom(): number {
    return (this.settings.fullScreen || !this.systemBarsVisible) ? 0 : this.insets.bottom
  }

  // 原版 f2594t0 悬浮钮本体（42dp、内边距 10dp、白圆、图标 u0.a 五态）。
  // 摆放由外层全屏容器 align 决定（Ga gravity）；本体内只做两件事：
  //  默认态挂 36dp margin（f13688g），拖动态用 translate 跟手位移。
  @Builder
  FabButton() {
    Stack() {
      Image(this.fabDirFlag === 0 ? $r('app.media.uia_ic_menu') : $r('app.media.uia_fab_arrow_back'))
        .width(22)
        .height(22)
        .fillColor('#61000000')
        .rotate({
          angle: this.fabDirFlag === 2 ? 180 : (this.fabDirFlag === 4 ? 90 : (this.fabDirFlag === 8 ? -90 : 0))
        })
    }
    .width(this.fabSize)
    .height(this.fabSize)
    .padding(10)
    .borderRadius(this.fabSize / 2)
    .backgroundColor('#FFFFFF')
    .shadow({ radius: 12, color: 'rgba(0,0,0,0.26)', offsetY: 2 })
    .opacity(this.fabAlpha)
    .margin({
      left: this.fabFreeDrag ? 0 : (this.fabAlignLeft ? this.fabMargin : 0),
      right: this.fabFreeDrag ? 0 : (this.fabAlignRight ? this.fabMargin : 0),
      top: this.fabFreeDrag ? 0 : (this.fabAlignTop ? this.fabMargin : 0),
      bottom: this.fabFreeDrag ? 0 : (this.fabAlignBottom ? this.fabMargin : 0)
    })
    // 拖动位移：相对原 gravity 位置的增量（窗口坐标算出的 offset）
    .translate({ x: this.fabFreeDrag ? this.fabOffsetX : 0, y: this.fabFreeDrag ? this.fabOffsetY : 0 })
    .onTouch((event: TouchEvent) => {
      this.onFabTouchEvent(event)
    })
  }

  private onFabTouchEvent(event: TouchEvent): void {
    // 用窗口坐标（windowX/windowY，vp）：组件 translate/position 后局部 x/y
    // 会随组件漂移形成反馈误差，窗口坐标恒定。
    const t = event.touches[0]
    const px = t.windowX
    const py = t.windowY
    if (event.type === TouchType.Down) {
      // 由当前 gravity 摆放换算为绝对坐标（Ga 的 margin 36dp）
      const w = this.fabParentW()
      const h = this.fabParentH()
      const size = this.fabSize
      const m = this.fabMargin
      if (this.fabCenterH) {
        this.fabAbsBaseX = (w - size) / 2
      } else if (this.fabAlignLeft) {
        this.fabAbsBaseX = m
      } else {
        this.fabAbsBaseX = w - m - size
      }
      if (this.fabCenterV) {
        this.fabAbsBaseY = (h - size) / 2
      } else if (this.fabAlignTop) {
        this.fabAbsBaseY = m
      } else {
        this.fabAbsBaseY = h - m - size
      }
      this.handleFabTouch(0, px, py)
    } else if (event.type === TouchType.Move) {
      this.handleFabTouch(2, px, py)
    } else if (event.type === TouchType.Up) {
      this.handleFabTouch(1, px, py)
    } else if (event.type === TouchType.Cancel) {
      this.handleFabTouch(3, px, py)
    }
  }

  @Builder
  TopBarArea() {
    // 原版 db(f)：顶栏 translationY = -p * height（p=1 全隐藏）
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
          },
          // 原版 k6.d9()：面板打开时点左图标先关面板并拦截本次点击
          onTryClosePanels: (): boolean => this.closeTopPanelsForLeftIcon()
        })
      }
      .padding({ top: this.effectiveInsetTop() })
      .backgroundColor(this.bottomBg())
      .translate({ y: -this.topBarTranslate() })
      .onAreaChange((_old: Area, newArea: Area) => {
        this.topBarHeightVp = Number(newArea.height)
      })
    } else if (this.effectiveLayout() === LAYOUT_TOOLBAR_TOP) {
      Column() {
        this.ChromeToolbar(true)
      }
      .padding({ top: this.effectiveInsetTop() })
      // 背景延伸进状态栏避让区（只有组件需要避让，背景不需要）
      .backgroundColor(toolbarBackgroundColor(this.tabStore.current(), this.settings))
      // 原版 db(f)：f2604y0.setTranslationY(-p * height)
      .translate({ y: -this.topBarTranslate() })
      .onAreaChange((_old: Area, newArea: Area) => {
        this.topBarHeightVp = Number(newArea.height)
      })
    }
  }

  // 原版 db(f)：顶栏位移量 = 隐藏进度 × 顶栏实测高（ty=-p*h）
  private topBarTranslate(): number {
    if (this.toolbarHideProgress <= 0) {
      return 0
    }
    const h = this.topBarHeightVp > 0 ? this.topBarHeightVp : (48 + this.effectiveInsetTop())
    return h * this.toolbarHideProgress
  }

  // 原版 db(f)：底栏位移量 = 隐藏进度 × 底栏实测高（ty=+p*h）
  private bottomBarTranslate(): number {
    if (this.toolbarHideProgress <= 0) {
      return 0
    }
    const h = this.bottomBarHeightVp > 0 ? this.bottomBarHeightVp : 48
    return h * this.toolbarHideProgress
  }

  // 竖滑宿主 barExtentPx()：vp 转 px 供手势状态机使用
  private autoHideExtentVp(): number {
    return Math.max(
      this.topBarHeightVp > 0 ? this.topBarHeightVp : 48 + this.effectiveInsetTop(),
      this.bottomBarHeightVp > 0 ? this.bottomBarHeightVp : 48)
  }

  @Builder
  BottomBarArea() {
    // 原版 z8/l3.m + k6.r9：窗口全屏布局、系统导航栏透明，背景铺到导航条下，
    // 仅交互组件用 insets.bottom 避让。故底栏容器自身必须有底色，
    // 否则 padding 出来的导航条那一段没有背景（背景缺肉）。
    // 原版 k6.n9/Rb：搜索工具栏 B0 是 RelativeLayout 独立子视图，rule=ABOVE(底栏)，
    // 悬浮在网页之上、底栏正上方 —— 所有布局都在底部区域，不随顶栏收放。
    if (this.effectiveLayout() === LAYOUT_TOOLBAR_TOP) {
      Column() {
        // 原版布局1：底栏 f2600w0 高 0，B0 ABOVE(底栏) → 贴屏幕最底（工程在下方垫
        // 导航条避让条，B0 随之贴垫条顶）
        SearchToolbar({
          tab: this.tabStore.current(),
          onOpenSettings: () => {
            this.openPage('settingsSearch')
          }
        })
      }
      Column()
        .height(6 + this.effectiveInsetBottom())
        .backgroundColor(toolbarBackgroundColor(this.tabStore.current(), this.settings))
    } else if (this.effectiveLayout() === LAYOUT_TOOLBAR_BOTTOM) {
      Column() {
        SearchToolbar({
          tab: this.tabStore.current(),
          onOpenSettings: () => {
            this.openPage('settingsSearch')
          }
        })
        this.ChromeToolbar(true)
      }
      .padding({ bottom: this.effectiveInsetBottom() })
      .backgroundColor(toolbarBackgroundColor(this.tabStore.current(), this.settings))
      // 原版 db(f)：f2600w0.setTranslationY(+p * height)
      .translate({ y: this.bottomBarTranslate() })
      .onAreaChange((_old: Area, newArea: Area) => {
        this.bottomBarHeightVp = Number(newArea.height)
      })
    } else if (this.effectiveLayout() === LAYOUT_DOUBLE) {
      Column() {
        SearchToolbar({
          tab: this.tabStore.current(),
          onOpenSettings: () => {
            this.openPage('settingsSearch')
          }
        })
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
          },
          // 原版 k6.d9()：面板打开时点左图标先关面板并拦截本次点击
          onTryClosePanels: (): boolean => this.closeTopPanelsForLeftIcon()
        })
        this.ChromeToolbar(false)
      }
      .padding({ bottom: this.effectiveInsetBottom() })
      .backgroundColor(toolbarBackgroundColor(this.tabStore.current(), this.settings))
      // 原版 Ya 布局3：f2600w0 = 地址栏+工具栏整块，db(p) ty=+p*h
      .translate({ y: this.bottomBarTranslate() })
      .onAreaChange((_old: Area, newArea: Area) => {
        this.bottomBarHeightVp = Number(newArea.height)
      })
    } else {
      Column() {
        SearchToolbar({
          tab: this.tabStore.current(),
          onOpenSettings: () => {
            this.openPage('settingsSearch')
          }
        })
        this.ChromeToolbar(false)
      }
      .padding({ bottom: this.effectiveInsetBottom() })
      .backgroundColor(toolbarBackgroundColor(this.tabStore.current(), this.settings))
      // 原版 Ya 布局0（传统）：工具栏在底栏容器 f2600w0（高 = tabbar 36dp + 工具栏
      // 48dp，6477-6484），db(p) ty=+p*h —— 与顶栏地址栏同步收放
      .translate({ y: this.bottomBarTranslate() })
      .onAreaChange((_old: Area, newArea: Area) => {
        this.bottomBarHeightVp = Number(newArea.height)
      })
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
      // 原版 W9()（a8.k 书签快捷选择对话框）：工具栏动作 30 打开
      onBookmarkDialog: () => {
        this.openBookmarkDialog()
      },
      onOpenHistory: () => {
        this.openPage('history')
      },
      onSiteInfoLong: () => {
        this.openPage('siteSettings')
      },
      onBack: () => {
        // 原版 k6.U8()：可后退则后退（加载中先 stop），否则非主页 → 关当前标签。
        // 每次点击实时查询 accessBackward()，不读 onPageBegin/onPageEnd 更新的缓存值。
        this.tabStore.goBack(this.tabStore.current())
      },
      onForward: () => {
        // 原版 k6.V8()：可前进则前进，否则重开最近关闭的标签（na.U0）
        this.tabStore.goForward(this.tabStore.current())
      },
      onHome: () => {
        if (!this.tabStore.current().isHomePage()) {
          this.tabStore.gotoHome()
        } else {
          // 原版 ra case4：主页点击主页键 → ub() 恢复操作栏
          this.showToolbarsForPage()
        }
      },
      onTabs: () => {
        this.showTabPanel = true
      },
      onMenu: () => {
        // 原版 tb()：菜单打开前按 N8()/i10 计算可用宽高与贴边距
        this.publishMenuMetrics()
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

  // 原版 k6.Ga()（4332-4360）1:1：FAB 是 RelativeLayout 子节点，位置 **只** 由
  // gravity 规则 + 四边 margin 决定，从不使用绝对坐标。
  //   f13689h = dimen v = 42dp（FAB 尺寸）
  //   f13688g = dimen u = 36dp（四边 margin，不是 12dp）
  //   (iS&3)==3 → addRule(9)=LEFT；(iS&5)==5 → addRule(11)=RIGHT；
  //   否则 addRule(14)+addRule(12)（居中）+ 四边 margin
  //   (iS&80)==80 → addRule(12)=BOTTOM；否则 addRule(15)=CENTER_VERTICAL
  // 设置默认 fab=80 → RIGHT|BOTTOM（右下角）。
  private initFabPosition(): void {
    const gravity = this.settings.fab
    this.fabMargin = 36
    this.fabSize = 42
    const left = (gravity & 3) === 3
    const right = (gravity & 5) === 5
    const bottom = (gravity & 80) === 80
    // 原版：非 LEFT 且非 RIGHT 时是水平居中；非 BOTTOM 时垂直居中
    this.fabAlignLeft = left
    this.fabAlignRight = right
    this.fabAlignTop = !bottom
    this.fabAlignBottom = bottom
    this.fabCenterH = !left && !right
    this.fabCenterV = !bottom
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
        this.showSavePageDialog()
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
                const path = `${context.cacheDir}/uia_view_source.html`
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
    // 原版 c8/y7（Shell 根布局）：RelativeLayout 全屏容器，网页 f2586p0 铺满
    // （Jb:4645 RelativeLayout.LayoutParams(-1,-1)），顶栏 f2604y0 / 底栏 f2600w0
    // 悬浮其上，db(p) 用 translationY 收放 —— 网页不位移，隐藏时自然扩到全屏。
    Stack() {
      Navigation(this.mainNavStack) {
        Stack() {
          if (this.ready) {
          Tabs({ index: this.tabStore.currentIndex }) {
            ForEach(this.tabStore.tabs, (tab: TabItem) => {
              TabContent() {
                Stack() {
                  TabWeb({
                    tab: tab,
                    // 原版 Shell.dispatchKeyEvent：Web 获焦时按键先经宿主处理（k6.n8 1:1）
                    onPcKey: (event: KeyEvent): boolean => this.handlePcKey(event),
                    // 原版 k6.b0 → d9() → pb()：页面加载/标题落定时确保 FAB 在场
                    onPageSettle: (): void => this.maybeShowFab(),
                    // 原版 WebView OnTouchListener → k6.E → GestureTouchEvent.g()：
                    // 触摸事件全量喂竖滑状态机（action 0=down 1=up 2=move 3=cancel）
                    onAutoHideTouch: (action: number, x: number, y: number): void => {
                      this.autoHideGesture.onTouch(action, x, y)
                    }
                  })
                  // 主页是同一 WebView 的内部页（原版 u9.d.m 主页 = WebView 内 about:page），
                  // 手势触点同样在 WebView 上——HomePage 覆盖层把手势回调透传给状态机
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
                        // 原版 logo 点击 uia.cmd(257)→ja(true)→aa(null)：打开书签管理页（RecordContainerFragment 标签 1）
                        this.openPage('bookmarks')
                      },
                      onAutoHideTouch: (action: number, x: number, y: number): void => {
                        this.autoHideGesture.onTouch(action, x, y)
                      },
                      // 原版 isGestureDisabled → uia.cmd(515)：工具栏隐藏时禁用主页下拉搜索
                      gestureEnabledQuery: (): boolean => this.toolbarShown || this.fabVisible
                    })
                  }
                }
              }
            }, (tab: TabItem) => tab.id.toString())
          }
          .scrollable(false)
          .barHeight(0)
          // 原版标签切换是 Fragment 直接切换（f8/k 系列 show/hide），
          // 全仓库无 ViewPager2.setCurrentItem / PageTransformer 用法，无滑动补间，
          // 故将 Tabs 内置切换动画时长置 0，避免引入原版没有的过渡。
          .animationDuration(0)
          .width('100%')
          .height('100%')
          // 原版 k6.Jb()（4643-4657）+ Ya()（6469-6495）+ db()（6969-6974）：
          // 网页容器视口不能与顶栏重叠，否则网页内 position:fixed 的常驻头部会被
          // 浏览器地址栏盖住。
          //  · X0==0（未开自动隐藏）：f2586p0 用 addRule(3,顶栏)=BELOW、
          //    addRule(2,底栏)=ABOVE 夹在两栏之间 → padding 等价。
          //  · X0==1（开自动隐藏）：LayoutParams(-1,-1) 全屏，db(p) 令
          //    translationY=顶栏高×(1-p)：显示态让出顶栏、隐藏态铺满。
          // 游戏模式 / 全屏视频（原版 P1 隐藏双栏）时无栏可让位，内缩归零。
          .padding({ top: this.webTopPadding(), bottom: this.webBottomPadding() })
          .translate({ y: this.webViewportTranslate() })

          // 原版 y7：顶栏 f2604y0（RelativeLayout alignParentTop）与底栏 f2600w0
          // （alignParentBottom）是各自锚定边的兄弟视图——用全屏包裹容器分别贴顶/
          // 贴底（不能靠 Stack 全局 alignContent，传统布局两栏同现会叠到同一边）。
          // 包裹容器自身 HitTestMode.None：空白区不拦截触摸、不阻塞子节点，
          // 网页/主页照常收到手势与点击。
          if (!this.settings.gameMode && !this.videoOverlay.active) {
            Column() {
              this.TopBarArea()
            }
            .width('100%')
            .height('100%')
            .justifyContent(FlexAlign.Start)
            .hitTestBehavior(HitTestMode.None)
          }
          if (!this.settings.gameMode && !this.videoOverlay.active) {
            Column() {
              this.BottomBarArea()
            }
            .width('100%')
            .height('100%')
            .justifyContent(FlexAlign.End)
            .hitTestBehavior(HitTestMode.None)
          }
          }
        }
        .width('100%')
        .height('100%')
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
        // 进度条显隐由 com.tuyafeng.support.widget.w 控制：f4373a.setVisibility(0)/8 直接切换，
        // 无窗口动画、无淡入淡出（w.java 131、181、121 行），故此处不加 transition。
        // 原版 db(f)：进度条 translationY 同步 —— 顶栏隐藏时随顶栏上移出屏、
        // 底栏隐藏时 f12*p*height2（height2=-顶栏高或进度条高，见 6978-6983）
        Progress({ value: this.tabStore.current().progress, total: 100, type: ProgressType.Linear })
          .width('100%')
          .height(2)
          .color(PROGRESS_GRADIENT)
          .backgroundColor(Color.Transparent)
          .position({ x: 0, y: this.effectiveInsetTop() })
          .translate({ y: this.effectiveLayout() === LAYOUT_TOOLBAR_TOP ? -this.topBarTranslate() : 0 })
      }

      // 原版 k6.f2594t0：模式2（点击隐藏）隐藏后的悬浮钮——
      // 尺寸 42dp（dimen v）、内边距 10dp、白圆底（drawable N1=cr.xml）、阴影 12dp。
      // 触摸三段（t0 1:1）：短按<300ms=显示工具栏；快拖出方向=五方向动作键；
      // 长按 300ms（alpha 0.5）=自由拖动，松手吸附九宫并持久化 fab(int)。
      // 摆放（Ga 1:1）：默认态 **只用** align + 四边 margin 36dp，绝不用 position
      // （position 传 undefined 会被当 0 → 飞到左上角，这就是之前「点不到」的原因）；
      // 仅自由拖动态才切 position 绝对定位。
      // 图标（u0.a 五态）：默认 cm 菜单，拖出方向换 b2 箭头并旋转
      // （左 0° / 右 180° / 上 90° / 下 -90°）。
      if (this.fabVisible) {
        // 定位完全由这个包裹容器承担（原版 RelativeLayout + gravity/margin）：
        // 拖动态容器全屏 + position 绝对；默认态容器全屏 + align 四象限，
        // 内部 FAB 只挂 36dp margin（Ga 的 f13688g）。@Builder 返回 void
        // 无法链式挂属性，故属性一律写在容器上。
        Stack() {
          this.FabButton()
        }
        .width('100%')
        .height('100%')
        .align(this.fabCenterH
          ? (this.fabAlignBottom ? Alignment.Bottom : Alignment.Top)
          : (this.fabAlignRight
            ? (this.fabAlignBottom ? Alignment.BottomEnd : Alignment.TopEnd)
            : (this.fabAlignBottom ? Alignment.BottomStart : Alignment.TopStart)))
        .hitTestBehavior(this.fabFreeDrag ? HitTestMode.Default : HitTestMode.None)
      }

      if (this.showSearch) {
        // 原版 tb/k0（UrlInputFragment）：Fragment 根 RelativeLayout 本身就是压暗层
        // （color a8 = #40808080，I3:783 g6.g().h(...).i(0x70808080)），点击空白处关闭。
        // 输入行 f12383p0 用 ALIGN_PARENT_TOP/BOTTOM 贴顶/贴底（C3 uiflags bit1，k6.oa z10），
        // 全宽 edge-to-edge；建议列表 f12391x0 是独立兄弟视图（BELOW/ABOVE），不是合并的卡片。
        Column()
          .width('100%')
          .height('100%')
          // 原版压暗层正常态 color a8 = #40808080（0x70808080 仅为 focused 态）
          .backgroundColor($r('app.color.hc_40808080'))
          // 原版搜索面板 k6.oa（c8/k6.java 7874）与 tb/k0（tb/k0.java 801）：
          //   .v(f13636a, f13642g, f13642g, f13637b) = .v(anim/c, anim/j, anim/j, anim/d)
          //   enter=anim/c（alpha 0→1，240ms 线性）、exit=anim/j（alpha 1→1，240ms，即无过渡）、
          //   popEnter=anim/j（无过渡）、popExit=anim/d（alpha 1→0，240ms 线性）。
          // 即：进场淡入 240 线性、关闭时淡出 240 线性，底层内容全程不动（与原版 exit=anim/j 一致）。
          // ArkUI 的 .transition(effect) 未用 asymmetric 时，同一 effect 同时作用于出现/消失，
          // 且 fadeInTransition 的 OPACITY 在消失时自动反向为 1→0（等价于 anim/d），故无需另写 asymmetric。
          .transition(fadeInTransition())
          .onClick(() => {
            this.showSearch = false
          })
        Column() {
          SearchOverlay({
            initialText: this.searchInitialText,
            // 布局 2/3 输入条贴底（k6.oa：z10 = (W0==2||W0==3)?false:true）
            barAtTop: this.effectiveLayout() !== LAYOUT_TOOLBAR_BOTTOM
              && this.effectiveLayout() !== LAYOUT_DOUBLE,
            // 原版 k6.oa U0：工具栏当前背景色（theme-color 适配）；等于默认色时传空串
            // （bit2 zB2 = U0!=0 && 非夜间强制），面板据此反色并复用背景色
            toolbarBg: this.toolbarCustomBg(),
            onClose: () => {
              this.showSearch = false
            }
          })
        }
        .width('100%')
        .height('100%')
        .justifyContent(this.effectiveLayout() === LAYOUT_TOOLBAR_BOTTOM || this.effectiveLayout() === LAYOUT_DOUBLE
          ? FlexAlign.End : FlexAlign.Start)
        .padding(this.effectiveLayout() === LAYOUT_TOOLBAR_BOTTOM || this.effectiveLayout() === LAYOUT_DOUBLE
          ? { bottom: this.effectiveInsetBottom() } : { top: this.effectiveInsetTop() })
        // 空白区域点击穿透到下方压暗层（关闭）；面板自身 Default 拦截，避免点输入框时误关
        .hitTestBehavior(HitTestMode.None)
        // 同上：整块搜索面板随 FragmentTransaction 走 anim/c 进场（alpha 240ms 线性）
        .transition(fadeInTransition())
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
            this.showSavePageDialog()
          },
          onOpenAi: () => {
            this.openAi()
          },
          onOpenReader: () => {
            this.toggleReader()
          },
          onReadAloud: () => {
            this.startReadAloud()
          },
          // 原版 P9 case2 → W9()：菜单长按书签请求打开书签快捷选择对话框（承载在本页）
          onOpenBookmarkDialog: () => {
            this.openBookmarkDialog()
          },
          // 原版 W9()（a8.k 书签快捷选择对话框）选中书签 → 由**当前标签**打开。
          // 该回调已不使用（对话框承载统一收敛到 Index 的 showBookmarkPicker 块），
          // 保留仅为 MenuSheet 侧接口完整性；行为按原版语义实现以免误用。
          onOpenUrlInNewTab: (url: string) => {
            this.navigateFromBookmarkPicker(url)
          }
        })
      }
      // 原版 a8.k 书签快捷选择对话框（W9()）：工具栏动作 30 入口
      if (this.showBookmarkPicker) {
        Stack({ alignContent: Alignment.Center }) {
          BookmarkPickerDialog({
            onPickUrl: (url: string): void => {
              this.showBookmarkPicker = false
              this.navigateFromBookmarkPicker(url)
            },
            onDismiss: (): void => {
              this.showBookmarkPicker = false
            }
          })
        }
        .width('100%')
        .height('100%')
        .backgroundColor('rgba(0,0,0,0.4)')
        .transition(dimTransition(240))
        .onClick(() => {
          this.showBookmarkPicker = false
        })
      }
      if (this.showFindBar) {
        FindBar({
          tab: this.tabStore.current(),
          onClose: () => {
            this.showFindBar = false
          }
        })
          .position({ x: 0, y: this.effectiveInsetTop() })
      }
      if (this.showAi) {
        // 原版 b9/g Dialog：b9/g.java 232-233 行 —— attributes.dimAmount = 0.2f，
        // windowAnimations = (gravity & 48) == 48 ? style q(anim/m,l) : style r(anim/k,n)。
        // 竖屏贴底 → style r（anim/k 160ms accelerate 上滑）；横屏居中 → style q（anim/m 下落）。
        Column()
          .width('100%')
          .height('100%')
          .backgroundColor($r('app.color.hc_33000000'))
          .transition(dimTransition(160))
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
            .padding(this.isLandscape ? { top: this.effectiveInsetTop() } : { bottom: this.effectiveInsetBottom() })
        }
        .width(this.isLandscape ? this.aiPanelWidthVp : '100%')
        .height(this.isLandscape ? '100%' : this.aiPanelHeightVp)
        .justifyContent(this.isLandscape ? FlexAlign.Center : FlexAlign.End)
        .alignItems(this.isLandscape ? HorizontalAlign.Center : HorizontalAlign.Start)
        // 同 b9/g 窗口动画：竖屏底部 → style r(anim/k 进)；横屏居中 → style q(anim/m 进)
        .transition(this.isLandscape ? menuTransitionTop() : menuTransition())
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
      if (this.downloadConfirm !== null) {
        DownloadConfirmOverlay({
          info: this.downloadConfirm,
          onDone: () => {
            this.downloadConfirm = null
          }
        })
      }
      // 保存网页弹窗（原版 k6.m0：标题 ar、预填标题、hint kg、复选框 sb）
      if (this.showSavePage) {
        SavePageDialog({
          initialName: this.savePageName,
          asPdf: this.saveAsPdf,
          onCancel: () => {
            this.showSavePage = false
          },
          onConfirm: (name: string, asPdf: boolean) => {
            this.savePageName = name
            this.saveAsPdf = asPdf
            this.applySavePage()
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

      // 原版 k6.Eb/f8.w0：划词翻译浮层（竖屏 TOP|RIGHT / 横屏 BOTTOM|RIGHT，宽 N8()）
      TranslatePanel()

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
          // 原版 f6.i.c(view)：Snackbar 进场 alpha 0→1 与 translationY 20→0 同播，
          // setDuration(180L)、setInterpolator(new DecelerateInterpolator())（f6/i.java 123-131 行）
          .transition(TransitionEffect.OPACITY.animation({ duration: 180, curve: DECELERATE_CURVE })
            .combine(TransitionEffect.translate({ y: 20 })
              .animation({ duration: 180, curve: DECELERATE_CURVE })))
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
          // 原版 k6.Ib()（c8/k6.java 4516-4528）：ObjectAnimator.ofFloat(f2606z0, "alpha", 0.2f, 1.0f)
          // setDuration(300L)、setInterpolator(new AccelerateInterpolator())（=t²，非 EaseIn 的三次近似）。
          // 注意动画起点是 0.2f（不是 0），用 TransitionEffect.opacity(0.2) 精确复刻出场初值。
          .transition(TransitionEffect.opacity(0.2).animation({ duration: 300, curve: ACCELERATE_CURVE }))
      }
    }
    .width('100%')
    .height('100%')
    // 原版 Shell.dispatchKeyEvent：无获焦组件时按键经根节点分发（k6.n8 1:1）
    .onKeyEvent((event: KeyEvent): boolean => this.handlePcKey(event))
    // 原版快捷键组合键窗口级响应（Web 获焦/无获焦场景兜底，动作经 pc* 门控与 n8 一致）
    .keyboardShortcut('t', [ModifierKey.CTRL], (): void => this.pcNewTab())
    .keyboardShortcut('w', [ModifierKey.CTRL], (): void => this.pcCloseTab())
    .keyboardShortcut('l', [ModifierKey.CTRL], (): void => this.pcFocusAddress())
    .keyboardShortcut('h', [ModifierKey.CTRL], (): void => this.pcHistory())
    .keyboardShortcut('u', [ModifierKey.CTRL], (): void => this.pcSource())
    .keyboardShortcut('d', [ModifierKey.CTRL], (): void => this.pcAddBookmark())
    .keyboardShortcut('f', [ModifierKey.CTRL], (): void => this.pcFind())
    .keyboardShortcut('f', [ModifierKey.ALT], (): void => this.pcMenu())
    .keyboardShortcut('b', [ModifierKey.CTRL, ModifierKey.SHIFT], (): void => this.pcBookmarks())
    .keyboardShortcut('r', [ModifierKey.CTRL], (): void => this.pcRefresh())
    .keyboardShortcut('g', [ModifierKey.CTRL], (): void => this.pcFindNext())
    .keyboardShortcut('g', [ModifierKey.CTRL, ModifierKey.SHIFT], (): void => this.pcFindPrev())
    .keyboardShortcut(FunctionKey.F5, [], (): void => this.pcRefresh())
    .keyboardShortcut(FunctionKey.ESC, [], (): void => this.pcEscape())
    .keyboardShortcut('1', [ModifierKey.CTRL], (): void => this.pcTabDigit(1))
    .keyboardShortcut('2', [ModifierKey.CTRL], (): void => this.pcTabDigit(2))
    .keyboardShortcut('3', [ModifierKey.CTRL], (): void => this.pcTabDigit(3))
    .keyboardShortcut('4', [ModifierKey.CTRL], (): void => this.pcTabDigit(4))
    .keyboardShortcut('5', [ModifierKey.CTRL], (): void => this.pcTabDigit(5))
    .keyboardShortcut('6', [ModifierKey.CTRL], (): void => this.pcTabDigit(6))
    .keyboardShortcut('7', [ModifierKey.CTRL], (): void => this.pcTabDigit(7))
    .keyboardShortcut('8', [ModifierKey.CTRL], (): void => this.pcTabDigit(8))
    .keyboardShortcut('9', [ModifierKey.CTRL], (): void => this.pcTabDigit(9))
    .keyboardShortcut('0', [ModifierKey.CTRL], (): void => this.pcTabDigit(0))
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
        message: $r('app.string.page_failed_load'), duration: TOAST_SHORT
      })
      return
    }
    Reader.isInReader(tab).then((inReader: boolean) => {
      if (inReader) {
        return Reader.exitReader(tab)
      }
      // 原版 k6.B8：进入阅读前 wld 命中 → g6.n.q(O1)「不支持该网站」，不执行阅读检查
      if (RemoteConfig.getInstance().isInWld(tab.url)) {
        this.getUIContext().getPromptAction().showToast({
          message: $r('app.string.site_not_supported'),
          duration: TOAST_SHORT
        })
        return
      }
      return Reader.injectReaderScripts(tab).then(() => {
        return Reader.enterReader(tab, READER_THEME_COLORS[this.settings.readerTheme],
          this.settings.readerFontSize, this.settings.readerCustomCss)
      }).then((ok: boolean) => {
        if (!ok) {
          this.getUIContext().getPromptAction().showToast({
            message: $r('app.string.page_failed_load'), duration: TOAST_SHORT
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

  // 书签页带文件夹参数（原版 k6.u 8657/8567：?folder= 数字 id / folder://X 名称）：
  // param JSON 由 BookmarkPage onReady 读取
  private openBookmarksAtFolder(folderId: number, folderName: string): void {
    const param: Record<string, string> = new Object() as Record<string, string>
    param['folder'] = String(folderId)
    param['folderName'] = folderName
    this.mainNavStack.pushPathByName('bookmarks', JSON.stringify(param), true)
  }

  // 原版 k6.ga()：扫码结果按网址/搜索词分流（与 MenuSheet.startScan 同一管线）
  private startScan(): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    scanBarcode.startScanForResult(context).then((data: scanBarcode.ScanResult) => {
      const scanned = data.originalValue.trim()
      if (scanned === '') {
        return
      }
      const target = isUrlLike(scanned) ? normalizeUrl(scanned)
        : buildSearchUrl(this.settings.engineKey, this.settings.activeEngineTemplate(), scanned)
      this.tabStore.navigate(target)
    }).catch((error: BusinessError) => {
      console.error(`scan failed: ${error.code}`)
    })
  }

  // ===== 原版朗读（k6.va/G3/p3/E3/xb/ha）=====

  // 原版 k6.va()：朗读入口 —— JS 禁用提示 → 初始化控制器/引擎 → 稍等提示 → 抽取正文
  private startReadAloud(): void {
    const tab = this.tabStore.current()
    // 原版 na.e1(url)：全局 JS 开关（webflag 位8）被网站设定 JavaScript 覆盖（ca.d 按 host 查 ba.b.B(zT)）
    const siteSetting = this.settings.getSiteSetting(hostOf(tab.url))
    const jsEnabled = siteSetting !== null ? siteSetting.javaScript : this.settings.jsEnabled
    if (!jsEnabled) {
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.read_aloud_js_disabled'), duration: TOAST_SHORT
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
        message: $r('app.string.read_aloud_engine_failed'), duration: TOAST_SHORT
      })
      return
    }
    this.getUIContext().getPromptAction().showToast({
      message: $r('app.string.read_aloud_wait'), duration: TOAST_SHORT
    })
    const taskId = `ra${Date.now()}${Math.floor(Math.random() * 100000)}`
    const url = tab.url
    const title = tab.title
    try {
      tab.controller.runJavaScript(READ_ALOUD_EXTRACT_JS, (error: BusinessError, result: string) => {
        if (error) {
          console.error(`read aloud extract failed: ${error.code}`)
          this.getUIContext().getPromptAction().showToast({
            message: $r('app.string.read_aloud_cannot'), duration: TOAST_SHORT
          })
          return
        }
        this.submitReadAloud(taskId, url, title, result)
      })
    } catch (error) {
      console.error('runJavaScript read aloud failed')
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.read_aloud_cannot'), duration: TOAST_SHORT
      })
    }
  }

  // 原版 k6.G3 → p3：切分句子 → 提交任务 → 播放 → Snackbar「开始朗读/查看」→ 显示悬浮控件
  private submitReadAloud(taskId: string, url: string, title: string, json: string): void {
    const sentences = sentencesFromJson(json)
    if (sentences.length === 0) {
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.read_aloud_cannot'), duration: TOAST_SHORT
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

  // ===== 保存网页（原版 na.P1 → k6.m0/e5 → na.O1/X）=====

  // 原版 na.P1：内部页提示 dc，否则弹 m0（预填标题，空则 UUID 大写）
  private showSavePageDialog(): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage() || tab.url === '') {
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.mark_ad_http_only'), duration: TOAST_SHORT
      })
      return
    }
    const title = tab.title.trim()
    this.savePageName = title !== '' ? title : util.generateRandomUUID(true).toUpperCase()
    this.loadSaveAsPdfPref()
    this.showSavePage = true
  }

  // 原版 k6.m0：复选框初始态 = w9.a.p()
  private loadSaveAsPdfPref(): void {
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    preferences.getPreferences(context, 'uia_settings').then((store: preferences.Preferences) => {
      this.saveAsPdf = store.getSync('save_as_pdf', false) as boolean
    }).catch((error: BusinessError) => {
      console.error(`load save_as_pdf failed: ${error.message}`)
    })
  }

  // 原版 k6.e5：勾选态变化时持久化 w9.a.I
  private persistSaveAsPdf(value: boolean): void {
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    preferences.getPreferences(context, 'uia_settings').then((store: preferences.Preferences) => {
      store.put('save_as_pdf', value).then(() => {
        store.flush()
      }).catch((error: BusinessError) => {
        console.error(`persist save_as_pdf failed: ${error.message}`)
      })
    }).catch((error: BusinessError) => {
      console.error(`persist save_as_pdf failed: ${error.message}`)
    })
  }

  private applySavePage(): void {
    this.showSavePage = false
    this.persistSaveAsPdf(this.saveAsPdf)
    const tab = this.tabStore.current()
    let name = sanitizeFileName(this.savePageName)
    if (name === '') {
      name = sanitizeFileName(tab.title) !== '' ? sanitizeFileName(tab.title) : hostOf(tab.url)
    }
    if (this.saveAsPdf) {
      this.savePageAsPdf(name)
    } else {
      this.savePageAsMht(name)
    }
  }

  private ensureOfflineDir(): string {
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    const dir = `${context.filesDir}/offline`
    if (!fileIo.accessSync(dir)) {
      fileIo.mkdirSync(dir, true)
    }
    return dir
  }

  // 原版 z8.c1.L：name (n) 递增唯一化
  private uniqueOfflineName(dir: string, name: string, ext: string): string {
    let candidate = `${name}${ext}`
    let n = 0
    while (fileIo.accessSync(`${dir}/${candidate}`)) {
      n++
      candidate = `${name} (${n})${ext}`
    }
    return candidate
  }

  // 原版 na.X 非 PDF 分支：saveWebArchive 存 .mht 单文件网页存档；
  // ArkWeb 对应 WebviewController.storeWebArchive（autoName=false，baseName 为完整路径）
  private savePageAsMht(name: string): void {
    const tab = this.tabStore.current()
    const dir = this.ensureOfflineDir()
    const baseName = `${dir}/${this.uniqueOfflineName(dir, name, '.mht')}`
    tab.controller.storeWebArchive(baseName, false).then((archivePath: string) => {
      if (archivePath !== '' && fileIo.accessSync(archivePath)) {
        this.showSavedSnackbar()
      } else {
        this.savePageAsHtmlFallback(name)
      }
    }).catch((error: BusinessError) => {
      console.error(`store web archive failed: ${error.code}`)
      this.savePageAsHtmlFallback(name)
    })
  }

  // storeWebArchive 失败时降级：单文件 HTML（同步 JS 内联 canvas，跨域污染 catch 跳过；外部资源仍引用原 URL）
  private savePageAsHtmlFallback(name: string): void {
    const tab = this.tabStore.current()
    const dir = this.ensureOfflineDir()
    const path = `${dir}/${this.uniqueOfflineName(dir, name, '.html')}`
    try {
      tab.controller.runJavaScript(SAVE_PAGE_SERIALIZE_JS,
        (error: BusinessError, result: string) => {
          if (error) {
            console.error(`serialize page failed: ${error.code}`)
            return
          }
          try {
            const file = fileIo.openSync(path,
              fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE | fileIo.OpenMode.TRUNC)
            fileIo.writeSync(file.fd, result)
            fileIo.closeSync(file)
            this.showSavedSnackbar()
          } catch (ioError) {
            console.error('write offline html failed')
          }
        })
    } catch (error) {
      console.error('runJavaScript save page failed')
    }
  }

  // 原版 na.X PDF 分支：z8.v1.a 静默写 offline 目录（ISO_A4/无页边距）
  private savePageAsPdf(name: string): void {
    const tab = this.tabStore.current()
    const dir = this.ensureOfflineDir()
    const path = `${dir}/${this.uniqueOfflineName(dir, name, '.pdf')}`
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
        const file = fileIo.openSync(path, fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE | fileIo.OpenMode.TRUNC)
        fileIo.write(file.fd, result.pdfArrayBuffer().buffer).then(() => {
          this.showSavedSnackbar()
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

  // 原版 k6.u5：Snackbar「网页已保存至：书签 > 离线页面」+ 查看 → ka()
  private showSavedSnackbar(): void {
    const ctx = this.getUIContext().getHostContext()
    if (ctx === undefined) {
      return
    }
    this.showSnackbar(
      ctx.resourceManager.getStringSync($r('app.string.page_saved_to_offline').id),
      ctx.resourceManager.getStringSync($r('app.string.view_action').id),
      () => {
        this.openPage('offlinePage')
      }
    )
  }
}

// 下载确认弹层数据（原版 k6.mb → mark/uia/download/m.java）
class PendingDownloadUi {
  kind: string = 'web'
  guid: string = ''
  url: string = ''
  fileName: string = ''
  size: number = 0
  referer: string = ''
  ua: string = ''

  constructor(kind: string, guid: string, url: string, fileName: string, size: number,
    referer: string = '', ua: string = '') {
    this.kind = kind
    this.guid = guid
    this.url = url
    this.fileName = fileName
    this.size = size
    this.referer = referer
    this.ua = ua
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
        Row() {
          Blank().layoutWeight(1)
          UiaDialogButton({ label: $r('app.string.cancel'), onAction: () => {
            this.cancel()
          } })
          UiaDialogButton({ label: $r('app.string.download_btn'), onAction: () => {
            this.confirm()
          } })
        }
        .width('100%')
      }
      .width('100%')
      .padding(20)
      .borderRadius(18)
      .border({ width: 1, color: $r('app.color.dialog_border') })
      .backgroundColor($r('app.color.dialog_bg'))
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .backgroundColor('rgba(0,0,0,0.4)')
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
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.copied_link'), duration: TOAST_SHORT })
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
      this.coordinator.confirmWebDownload(this.info.guid, this.fileName, this.info.referer, this.info.ua)
    } else {
      this.coordinator.confirmUrlDownload(this.fileName)
    }
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.download_started'), duration: TOAST_SHORT })
    this.onDone()
  }
}

// 原版 k6.m0：标题 ar「保存网页」+ 预填输入 + hint kg「标题」+ 复选框 sb「保存为 PDF」+ 取消/确定
@ComponentV2
struct SavePageDialog {
  @Param initialName: string = ''
  @Param asPdf: boolean = false
  @Event onCancel: () => void = () => {}
  @Event onConfirm: (name: string, asPdf: boolean) => void = () => {}
  @Local name: string = ''
  @Local pdf: boolean = false

  aboutToAppear(): void {
    this.name = this.initialName
    this.pdf = this.asPdf
  }

  build() {
    Column() {
      Column({ space: 16 }) {
        Text($r('app.string.save_page_title'))
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
        TextInput({ text: this.name, placeholder: $r('app.string.save_page_name_hint') })
          .height(40)
          .fontSize(14)
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .caretColor($r('app.color.accent'))
          .onChange((value: string) => {
            this.name = value
          })
        Row({ space: 8 }) {
          Checkbox()
            .select(this.pdf)
            .onChange((value: boolean) => {
              this.pdf = value
            })
          Text($r('app.string.save_as_pdf'))
            .fontSize(14)
            .fontColor($r('app.color.fg'))
        }
        .width('100%')
        Row() {
          Blank().layoutWeight(1)
          UiaDialogButton({ label: $r('app.string.cancel'), onAction: () => {
            this.onCancel()
          } })
          UiaDialogButton({ label: $r('app.string.confirm'), onAction: () => {
            this.onConfirm(this.name, this.pdf)
          } })
        }
        .width('100%')
      }
      .width('100%')
      .padding(20)
      .borderRadius(18)
      .border({ width: 1, color: $r('app.color.dialog_border') })
      .backgroundColor($r('app.color.dialog_bg'))
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .backgroundColor('rgba(0,0,0,0.4)')
    .onClick(() => {
      this.onCancel()
    })
  }
}

// 原版 GestureTouchEvent.b 宿主（k6 内部类 a 的等价层）。
// 对象字面量实现接口在 ArkTS 中受限，拆为独立类持有 Index 引用。
class IndexAutoHideHost implements AutoHideHost {
  private owner: Index

  constructor(owner: Index) {
    this.owner = owner
  }

  isHidden(): boolean {
    return this.owner.autoHideIsHidden()
  }

  onDragStart(): void {
    this.owner.autoHideOnDragStart()
  }

  onProgress(f: number): void {
    this.owner.autoHideOnProgress(f)
  }

  onSettle(show: boolean): void {
    this.owner.autoHideOnSettle(show)
  }

  onCommitImmediate(show: boolean): void {
    this.owner.autoHideOnCommitImmediate(show)
  }

  canGesture(): boolean {
    return this.owner.autoHideCanGesture()
  }

  barExtentPx(): number {
    return this.owner.autoHideExtentPx()
  }

  progress(): number {
    return this.owner.autoHideProgress()
  }

  swipeModeOnly(): boolean {
    return this.owner.autoHideSwipeModeOnly()
  }
}
