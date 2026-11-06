import { pasteboard } from '@kit.BasicServicesKit'
import { common } from '@kit.AbilityKit'
import { webview, WebNetErrorList } from '@kit.ArkWeb'
import { http } from '@kit.NetworkKit'
import { systemShare } from '@kit.ShareKit'
import { uniformTypeDescriptor as utd } from '@kit.ArkData'
import { detectBarcode, scanBarcode } from '@kit.ScanKit'
import { fileIo } from '@kit.CoreFileKit'
import { TabItem, globMatches, parseJsonArray } from '../common/Types'
import { AppSettings } from '../common/Settings'
import { AdBlocker, buildBlockedPageHtml, TYPE_ALL_MASK, TYPE_DOCUMENT } from '../common/AdBlock'
import { BrowserDb } from '../common/Database'
import { TabStore } from '../common/TabStore'
import { hostOf, buildSearchUrl, isUrlLike, normalizeUrl } from '../common/SearchEngines'
import { Reader, READER_THEME_COLORS } from '../common/Reader'
import { DownloadCoordinator } from '../common/Downloads'
import { GmBridge, gmSecret, gmFakeTampermonkeyJs, gmSandboxJs, GmRequireStore } from '../common/GmRuntime'
import { FontStore } from '../common/FontStore'
import { NetMonitor } from '../common/NetState'
import { RemoteConfig } from '../common/RemoteConfig'
import { VideoOverlayState } from './VideoPlayerOverlay'
import { TranslateState } from './TranslatePanel'
import { MARK_AD_INJECT_JS } from './MenuSheet'
import { AppIcon } from './AppIcon'
import { PdfViewerView } from '../view/PdfViewerPage'

// 1x1 GIF 占位（原版 u4/a.f12819d base64 1:1 解码）
const GIF_PLACEHOLDER: Uint8Array = new Uint8Array([
  0x47, 0x49, 0x46, 0x38, 0x39, 0x61, 0x01, 0x00, 0x01, 0x00, 0x80, 0xFF,
  0x00, 0xC0, 0xC0, 0xC0, 0x00, 0x00, 0x00, 0x21, 0xF9, 0x04, 0x01, 0x00,
  0x00, 0x00, 0x00, 0x2C, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x01, 0x00,
  0x00, 0x02, 0x02, 0x44, 0x01, 0x00, 0x3B
])

// 原版 i6/r.java 用户脚本桥 1:1：runAt 1=文档开始/2=DOMContentLoaded/4=load，
// 经 window.via.postMessage({action:101,runAt,from}) 回传主线程分发
const USER_SCRIPT_BRIDGE_JS: string = '(function(){' +
  'var e=function(r){try{window.via.postMessage(JSON.stringify({action:101,runAt:r,from:location.href}))}catch(x){}};' +
  'new MutationObserver(function(){e(1);this.disconnect()}).observe(document.documentElement,{childList:true,subtree:true});' +
  'if(document.readyState==="loading"){document.addEventListener("DOMContentLoaded",function(){e(2)})}else{e(2)}' +
  'if(document.readyState==="complete"){e(4)}else{window.addEventListener("load",function(){e(4)})}' +
  '})()'

// 原版 c8/ta.a 1:1：@font-face ViaCustomFont + body 字体族 CSS（排除图标），__PATH__ 运行时替换
const CUSTOM_FONT_JS: string = '(function(){var i=\'via_custom_font\';var f=\'@font-face{font-family:ViaCustomFont;font-display:swap;src:url("__PATH__")}body,body :not(.bi):not(.bx):not(.bxr):not(.docon):not(.fa):not(.fab):not(.fad):not(.fal):not(.far):not(.fas):not(.glyphicon):not(.icon):not(.la):not(.las):not(.material-icons):not(.material-icons-outlined):not(.material-icons-round):not(.material-icons-sharp):not(.material-icons-two-tone):not(.material-symbols-outlined):not(.material-symbols-rounded):not(.material-symbols-sharp):not(.md):not(.typcn):not(.uni-btn-icon):not(.uni-icons):not(ion-icon):not(mat-icon):not(maticon):not(mdui-icon):not(i[data-feather]):not(span[data-feather]):not(i[class^="ri-"]):not(span[class^="ri-"]):not([class*="fa-"]):not([class*="mce-i-"]):not([class*=FONT]):not([class*=Font]):not([class*=ICON]):not([class*=Icon]):not([class*=arrow]):not([class*=font]):not([class*=icon]):not([class*=player]){font-family:ViaCustomFont,system-ui,-apple-system,"Segoe UI",Roboto,"Helvetica Neue",Arial,"Noto Sans","Liberation Sans",sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji"!important}\';var s=document.getElementById(i);if(s){s.innerHTML=f}else{s=document.createElement(\'style\');s.id=i;s.type=\'text/css\';s.innerHTML=f;document.head.appendChild(s)}})();'

interface ScriptRunMsg {
  action: number
  runAt: number
  from: string
}

// 划词菜单自定义项 id（过滤系统 TRANSLATE 项后追加）：
// 搜索=划词搜索（k6.C → Ua(str,false,true)）、查找=页内查找（k6.C → ob）、翻译=划词翻译面板
const EDIT_MENU_ID_VIA_SEARCH: string = 'via_search'
const EDIT_MENU_ID_VIA_FIND: string = 'via_find'
const EDIT_MENU_ID_VIA_TRANSLATE: string = 'via_translate'

// 原版 k6.Qa（k6.java:5651）以图搜图引擎表：12 引擎名称与 URL 模板 1:1（k6.k6 分发）
class ImageSearchEngine {
  name: string
  template: string

  constructor(name: string, template: string) {
    this.name = name
    this.template = template
  }
}

const IMAGE_SEARCH_ENGINES: ImageSearchEngine[] = [
  new ImageSearchEngine('谷歌', 'https://www.google.com/searchbyimage?safe=off&sbisrc=tg&image_url='),
  new ImageSearchEngine('谷歌 Lens', 'https://lens.google.com/uploadbyurl?url='),
  new ImageSearchEngine('必应',
    'https://www.bing.com/images/search?view=detailv2&iss=sbi&form=SBIVSP&sbisrc=UrlPaste&q=imgurl:'),
  new ImageSearchEngine('TinEye', 'https://tineye.com/search/?url='),
  new ImageSearchEngine('Yandex', 'https://yandex.com/images/touch/search?family=yes&rpt=imageview&url='),
  new ImageSearchEngine('百度',
    'https://graph.baidu.com/details?isfromtusoupc=1&tn=pc&carousel=0&promotion_name=pc_image_shituindex&extUiData%5bisLogoShow%5d=1&image='),
  new ImageSearchEngine('360 搜索', 'https://st.so.com/r?img_url='),
  new ImageSearchEngine('SauceNAO', 'https://saucenao.com/search.php?db=999&url='),
  new ImageSearchEngine('IQDB', 'https://iqdb.org/?url='),
  new ImageSearchEngine('3D IQDB', 'https://3d.iqdb.org/?url='),
  new ImageSearchEngine('WhatAnime', 'https://trace.moe/?url='),
  new ImageSearchEngine('Ascii2D', 'https://ascii2d.net/search/url/')
]

// 原版 c8/db.a「看图模式」脚本 1:1：收集页面 >99px 图片以 Viewer.js 画廊打开
// （window.open 经 onWindowNew 落为新标签）；无图片时 alert od「无图片」
const PICTURE_MODE_JS: string =
  '(function(){var b=document.getElementsByTagName("img"),f=b.length,d=0,e=new Set,a=[];' +
  'a.push(\'<html><head><meta charset="utf-8"><meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=1,minimal-ui"><title>Images</title>\');' +
  'a.push(\'<link href="https://fastly.jsdelivr.net/npm/viewerjs@1.11.7/dist/viewer.min.css" rel="stylesheet">\');' +
  'a.push(\'<script src="https://fastly.jsdelivr.net/npm/viewerjs@1.11.7/dist/viewer.min.js">\\x3c/script>\');' +
  'a.push(\'<style type="text/css">*{padding:0;margin:0}body{background-color:#fff}p{color:#000}@media (prefers-color-scheme:dark){body{background-color:#000}p{color:#fff}}#images img{display:block;margin:auto;text-align:center;max-width:100%}.viewer-backdrop{background-color:rgba(0,0,0,.9)}.viewer-toolbar>ul>li{width:32px;height:32px;padding:4px;box-sizing:border-box}.viewer-download{content:"Download";background-color:transparent;background-image:url(\\\'data:image/svg+xml,%3Csvg xmlns="http://www.w3.org/2000/svg" viewBox="-494 -494 1500 1500"%3E%3Cpath fill="%23fff" d="M288 32c0-17.7-14.3-32-32-32s-32 14.3-32 32l0 242.7-73.4-73.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3l128 128c12.5 12.5 32.8 12.5 45.3 0l128-128c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L288 274.7 288 32zM64 352c-35.3 0-64 28.7-64 64l0 32c0 35.3 28.7 64 64 64l384 0c35.3 0 64-28.7 64-64l0-32c0-35.3-28.7-64-64-64l-101.5 0-45.3 45.3c-25 25-65.5 25-90.5 0L165.5 352 64 352zm368 56a24 24 0 1 1 0 48 24 24 0 1 1 0-48z"/%3E%3C/svg%3E\\\');background-repeat:no-repeat;background-size:32px;color:transparent;display:block;font-size:0;line-height:0}</style>\');' +
  'a.push("</head><body>");a.push(\'<div><ul id="images">\');' +
  'for(var c=0;c<f;c++)e.has(b[c].src)||(e.add(b[c].src),b[c].src&&99<b[c].height&&99<b[c].width&&(a.push(\'<li><img src="\'+b[c].src+\'"/></li>\'),d++));' +
  'a.push("</ul></div>");' +
  '0==d?alert("无图片"):(a.push(\'<script>var viewer = new Viewer(document.getElementById("images"), {toolbar: {zoomIn: true, zoomOut: true, oneToOne: true, reset: true, prev: true, next: true, rotateLeft: true\'),a.push("},});\\x3c/script>"),a.push("</body></html>"),b=window.open(""),' +
  'b.document.write(a.join("")),b.focus())})();'

// window.via 桥对象（k6:1487 postMessage 通道）
class ViaBridge {
  handler: (msg: string) => void = (): void => {
  }

  postMessage(msg: string): void {
    this.handler(msg)
  }
}

@ComponentV2
export struct TabWeb {
  @Param @Require tab: TabItem
  private settings: AppSettings = AppSettings.getInstance()
  private adBlocker: AdBlocker = AdBlocker.getInstance()
  private db: BrowserDb = BrowserDb.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  @Local privacyScripts: Array<ScriptItem> = []
  private schemeHandler: webview.WebSchemeHandler = new webview.WebSchemeHandler()
  private viaBridge: ViaBridge = new ViaBridge()
  // 原版 o5/a：window.via_gm GM_* 分派桥（每 tab 一实例，宿主回调 1:1 k6.s）
  private gmBridge: GmBridge = new GmBridge()
  // 原版 Shell.dispatchKeyEvent → k6.n8：Web 获焦时按键先经宿主分发再进网页（onInterceptKeyEvent 等价层）
  @Param onPcKey: (event: KeyEvent) => boolean = (_event: KeyEvent): boolean => false
  // 原版 k6.java:8592-8596：file:// 且 .pdf → za.g 查看器（本端为内嵌全屏 PdfViewerView）
  @Local pdfPreviewPath: string = ''
  @Local pdfPreviewName: string = ''
  // —— 原版 GestureTouchEvent 横滑前进/后退（mark/via/common/widget/GestureTouchEvent.java 对齐）——
  // 位移按 0.8 增益累计并限幅 ±80% 宽度；提交阈值 80% 宽度、300ms 动画
  @Local swipeNavOffset: number = 0
  @Local swipeNavAlpha: number = 1
  private swipeNavActive: boolean = false
  private swipeNavLocked: boolean = false
  private swipeNavWidth: number = 0

  aboutToAppear(): void {
    this.viaBridge.handler = (msg: string): void => {
      this.onViaMessage(msg)
    }
    // k6.s 宿主回调接线
    this.gmBridge.onSetClipboard = (data: string, type: string): void => {
      if (type !== 'text/plain' && type !== 'text' && type !== 'text/unicode') {
        return
      }
      pasteboard.getSystemPasteboard()
          .setData(pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, data)).catch(() => {
      })
    }
    this.gmBridge.onDownload = (url: string, name: string): void => {
      let pageUa = ''
      try {
        pageUa = this.tab.controller.getUserAgent()
      } catch (error) {
      }
      DownloadCoordinator.getInstance().requestUrlDownload(url, this.tab.url, pageUa, name)
    }
    this.gmBridge.onOpenInTab = (url: string, active: boolean, insert: number): void => {
      // 原版 g1(url, active, insert)；本端 insert 忽略
      this.tabStore.newTabAt(url, !active)
    }
    this.gmBridge.evaluateJs = (js: string): void => {
      this.tab.controller.runJavaScript(js).catch((error: BusinessError) => {
        console.error(`gm evaluate failed: ${error.message}`)
      })
    }
    this.gmBridge.userAgent = (): string => {
      try {
        return this.tab.controller.getUserAgent()
      } catch (error) {
        return ''
      }
    }
    this.refreshPrivacyScripts()
    // 原版 w9/p.x()：监听 Wi-Fi 状态，供「仅 Wi-Fi 有图」判断
    NetMonitor.getInstance().start()
    try {
      webview.WebviewController.setWebDebuggingAccess(this.settings.allowDebugWeb)
    } catch (error) {
      console.error('setWebDebuggingAccess failed')
    }
  }

  // 原版 w9/p.H()：(r&&x) || (!r&&q)；q=noImage 取反、r=wifiOnlyImages、x=onWifi
  private imageAllowedNow(): boolean {
    if (this.siteNoImage()) {
      return false
    }
    if (this.settings.wifiOnlyImages) {
      return NetMonitor.getInstance().onWifi
    }
    return !this.settings.noImage
  }

  // 划词菜单：过滤系统翻译项，追加自定义「搜索/查找/翻译」。
  // 原版 e8/i.C(t4.b)（e8/i.java:135-153）划词 ActionMode 自定义项 1:1：
  // 搜索(sy)→k6.C Ua(str,false,true) 划词搜索新标签；查找(jh)→ob(str) 页内查找；
  // 翻译项为已拍板划词翻译功能（k6.Eb → f8.w0 面板），保留
  private buildEditMenu(menuItems: Array<TextMenuItem>): Array<TextMenuItem> {
    const result: Array<TextMenuItem> = []
    for (let i = 0; i < menuItems.length; i++) {
      const item: TextMenuItem = menuItems[i]
      if (item.id.equals(TextMenuItemId.TRANSLATE)) {
        continue
      }
      result.push(item)
    }
    result.push({
      content: $r('app.string.search'),
      id: TextMenuItemId.of(EDIT_MENU_ID_VIA_SEARCH)
    })
    result.push({
      content: '查找',
      id: TextMenuItemId.of(EDIT_MENU_ID_VIA_FIND)
    })
    result.push({
      content: $r('app.string.translate'),
      id: TextMenuItemId.of(EDIT_MENU_ID_VIA_TRANSLATE)
    })
    return result
  }

  // 取当前选中文本（window.getSelection）
  private fetchSelection(onText: (text: string) => void): void {
    const js: string = 'JSON.stringify(window.getSelection().toString())'
    this.tab.controller.runJavaScript(js).then((result: string) => {
      let text: string = ''
      try {
        text = JSON.parse(result) as string
      } catch (error) {
        text = result
      }
      onText(text)
    }).catch(() => {
    })
  }

  // 原版 k6.C(n4.a) id=f4823f → Ua(str, false, true)（k6.java:5994）：
  // 划词为网址直接打开，否则按当前引擎搜索，均新标签打开（z11=true → i1）
  private searchSelection(text: string): void {
    const trimmed = text.trim()
    if (trimmed === '') {
      return
    }
    let target: string
    if (isUrlLike(trimmed)) {
      target = normalizeUrl(trimmed)
    } else {
      target = buildSearchUrl(this.settings.engineKey, this.settings.activeEngineTemplate(), trimmed)
    }
    this.tabStore.newTabAt(target, false)
  }

  private onEditMenuItemClick(menuItem: TextMenuItem, range: TextRange): boolean {
    if (menuItem.id.equals(TextMenuItemId.of(EDIT_MENU_ID_VIA_SEARCH))) {
      this.fetchSelection((text: string): void => {
        this.searchSelection(text)
      })
      return true
    }
    if (menuItem.id.equals(TextMenuItemId.of(EDIT_MENU_ID_VIA_FIND))) {
      // 原版 k6.C id=f4824g → ob(str)：页内查找（预填划词）。
      // ArkTS FindBar 无法从本组件拉起，直接以同一 searchAllAsync 管线执行查找
      this.fetchSelection((text: string): void => {
        try {
          this.tab.controller.searchAllAsync(text)
        } catch (error) {
          console.error('find selection failed')
        }
      })
      return true
    }
    if (menuItem.id.equals(TextMenuItemId.of(EDIT_MENU_ID_VIA_TRANSLATE))) {
      this.fetchSelection((text: string): void => {
        TranslateState.getInstance().open(text)
      })
      return true
    }
    return false
  }

  build() {
    Stack() {
      Web({ src: 'about:blank', controller: this.tab.controller, incognitoMode: this.tab.incognito })
        // 原版 jb/y4.java:167 全局 JS 开关（与脚本启用 scriptEnabled 为两个独立设置）
        .javaScriptAccess(this.settings.jsEnabled)
        .domStorageAccess(true)
        .databaseAccess(true)
        .fileAccess(true)
        .zoomAccess(true)
        .multiWindowAccess(true)
        .imageAccess(this.imageAllowedNow())
        .mixedMode(MixedMode.Compatible)
        .textZoomRatio(this.textZoomForTab(this.tab.url))
        // 原版 nightcss「强制网页暗色」：引擎级强制暗色（旧内核路径由 CSS 注入承担，ArkWeb 用 forceDark 等价实现）
        .darkMode(this.settings.nightCss ? WebDarkMode.On : WebDarkMode.Off)
        .forceDarkAccess(this.settings.nightCss)
        .runJavaScriptOnDocumentStart(this.privacyScripts)
        // 原版 k6:1487 registerJavaScriptProxy：window.via 桥
        .javaScriptProxy({
          object: this.viaBridge,
          name: 'via',
          methodList: ['postMessage'],
          controller: this.tab.controller
        })
        // 划词菜单（k6.Eb 链路）：默认项 + 自定义「翻译」开翻译面板
        .editMenuOptions({
          onCreateMenu: (menuItems: Array<TextMenuItem>): Array<TextMenuItem> => this.buildEditMenu(menuItems),
          onMenuItemClick: (menuItem: TextMenuItem, range: TextRange): boolean =>
            this.onEditMenuItemClick(menuItem, range)
        })
        // 原版 k6:8598：v://blocker/jump 解码后加会话放行并重新加载
        .onLoadIntercept((event: OnLoadInterceptEvent) => {
          const url = event.data.getRequestUrl()
          // 原版 k6.java:8592-8596：file:// 且后缀 pdf → 打开 PDF 查看器（za.g，参数 pdfPath）
          if (url.startsWith('file://') && this.urlPdfExtension(url)) {
            this.openPdfPreview(url)
            return true
          }
          const prefix = 'v://blocker/jump?url='
          if (!url.startsWith(prefix)) {
            return false
          }
          let target = ''
          try {
            target = decodeURIComponent(url.substring(prefix.length))
          } catch (error) {
          }
          if (target.startsWith('http')) {
            this.adBlocker.addBypassHost(hostOf(target))
            try {
              this.tab.controller.loadUrl(target)
            } catch (error) {
              console.error('blocker jump load failed')
            }
          }
          return true
        })
        .onControllerAttached(() => {
          this.setupSchemeHandler()
          this.applyAdvancedSettings()
          // 原版 k6:1487 registerJavaScriptProxy 之外的第二个桥：window.via_gm（o5/a.call）
          // ArkWeb 属性式 javaScriptProxy 仅支持注册一个对象，via_gm 走 controller 注册
          try {
            this.tab.controller.registerJavaScriptProxy(this.gmBridge, 'via_gm', ['call'])
            this.tab.controller.refresh()
          } catch (error) {
            console.error('register via_gm proxy failed')
          }
          if (this.tab.initialUrl !== '') {
            try {
              if (this.settings.dataSaver) {
                this.tab.controller.loadUrl(this.tab.initialUrl, [{ headerKey: 'Save-Data', headerValue: 'on' }])
              } else {
                this.tab.controller.loadUrl(this.tab.initialUrl)
              }
            } catch (error) {
              console.error('restore tab loadUrl failed')
            }
          }
        })
        .onPageBegin((event: OnPageBeginEvent) => {
          this.tab.url = event.url
          this.tab.loading = true
          this.tab.isError = false
          this.tab.sniffedMedia = []
          // 原版 e8/i.M() 页面开始重新应用正式缩放，qb 预览值失效
          this.tab.liveZoom = 0
          this.refreshPrivacyScripts()
          this.applyAdvancedSettings()
          this.applyUa(event.url)
          this.updateNavState()
        })
        .onPageEnd((event: OnPageEndEvent) => {
          this.tab.url = event.url
          this.tab.loading = false
          this.tab.progress = 100
          this.updateNavState()
          this.saveHistory(event.url)
          this.injectPrivacy(event.url)
          this.injectBlockerCss(event.url)
          this.injectCustomCss()
          this.injectCustomFont()
          this.prepareReader()
          this.expandFullText()
          this.settings.persistAdBlockTotal()
          this.syncThemeColor()
        })
        .onProgressChange((event: OnProgressChangeEvent) => {
          this.tab.progress = event.newProgress
        })
        .onTitleReceive((event: OnTitleReceiveEvent) => {
          this.tab.title = event.title
        })
        // 原版 C9「标记广告」回传通道：注入的选择器经 console 回传广告域名，
        // 命中后加入自定义拦截规则并刷新页面
        .onConsole((event: OnConsoleEvent) => {
          const prefix = 'via_mark_ad:'
          const msg: string = event.message.getMessage()
          if (msg.indexOf(prefix) === 0) {
            const domain = msg.substring(prefix.length).trim().toLowerCase()
            if (domain !== '') {
              this.settings.addRule(domain, false)
              this.adBlocker.rebuildCustomRules()
              try {
                this.tab.controller.refresh()
              } catch (error) {
                console.error('refresh after mark ad failed')
              }
            }
          }
          return false
        })
        .onErrorReceive((event: OnErrorReceiveEvent) => {
          if (event.request.isMainFrame()) {
            this.tab.isError = true
            this.tab.errorDesc = event.error.getErrorInfo()
            this.tab.loading = false
          }
        })
        .onPermissionRequest((event: OnPermissionRequestEvent) => {
          // 原版走权限询问弹窗流程（p4/a.java:86-88 → k6 询问用户）
          const granted: string[] = event.request.getAccessibleResource()
          this.getUIContext().showAlertDialog({
            title: $r('app.string.permission_request'),
            message: granted.join(', '),
            primaryButton: {
              value: $r('app.string.cancel'),
              action: () => {
                event.request.deny()
              }
            },
            secondaryButton: {
              value: $r('app.string.done'),
              action: () => {
                event.request.grant(granted)
              }
            },
            cancel: () => {
              event.request.deny()
            }
          })
        })
        .onSslErrorEventReceive((event: OnSslErrorEventReceiveEvent) => {
          if (this.settings.ignoreSslWarning) {
            event.handler.handleConfirm()
          } else {
            event.handler.handleCancel()
          }
        })
        .onSearchResultReceive((event: OnSearchResultReceiveEvent) => {
          if (event.isDoneCounting) {
            this.tab.matchOrdinal = event.activeMatchOrdinal
            this.tab.matchCount = event.numberOfMatches
          }
        })
        // 原版 p4/c.java:55 onCreateWindow：新窗口 = 新标签，controller 绑定到新标签
        .onWindowNew((event: OnWindowNewEvent) => {
          const newTab = this.tabStore.openWindowTab()
          try {
            event.handler.setWebController(newTab.controller)
          } catch (error) {
            console.error('setWebController for new window failed')
          }
        })
        // 原版 p4/c.java:110 onReceivedIcon：捕获站点图标供标签列表使用
        .onFaviconReceived((event: OnFaviconReceivedEvent) => {
          this.tab.icon = event.favicon
        })
        .onContextMenuShow((event?: OnContextMenuShowEvent) => {
          return this.handleContextMenu(event)
        })
        // 原版 Shell.dispatchKeyEvent：按键先于网页处理（返回 true 消费，1:1 k6.n8）
        .onInterceptKeyEvent((event: KeyEvent) => {
          return this.onPcKey(event)
        })
        .onInterceptRequest((event: OnInterceptRequestEvent) => {
          const request = event.request
          const requestUrl = request.getRequestUrl()
          // 原版 na.E0 首段：字体请求（后缀 = URL 编码字体名）优先于一切拦截
          const fontResponse = this.interceptFont(requestUrl)
          if (fontResponse !== null) {
            return fontResponse
          }
          // 原版 na.U1：内部页/非 http 放行
          if (!requestUrl.startsWith('http') || !this.tab.url.startsWith('http')) {
            return null
          }
          if (request.isMainFrame()) {
            // 主文档（na.E0 主文档分支）：先匹配计数（U1），会话放行后再放行页面
            const filter = this.adBlocker.matchFilter(requestUrl, TYPE_DOCUMENT, requestUrl)
            if (filter === null || filter.isException()) {
              return null
            }
            this.tab.adCount = this.tab.adCount + 1
            this.settings.addAdBlocked(1)
            if (this.adBlocker.hasBypassHost(hostOf(requestUrl))) {
              return null
            }
            const html = buildBlockedPageHtml(requestUrl, filter.toRuleString(),
              this.blockPageText('block_page_blocked'), this.blockPageText('block_page_reason'),
              this.blockPageText('block_page_continue'))
            const response: WebResourceResponse = new WebResourceResponse()
            response.setResponseCode(200)
            response.setReasonMessage('OK')
            response.setResponseMimeType('text/html')
            response.setResponseEncoding('utf-8')
            response.setResponseData(html)
            response.setResponseHeader([
              { headerKey: 'Cache-Control', headerValue: 'no-cache' },
              { headerKey: 'Access-Control-Allow-Origin', headerValue: '*' },
              { headerKey: 'Content-Type', headerValue: 'text/css' }
            ])
            return response
          }
          // 子请求：类型位不可得，按全类型位匹配（w4/d 类型限定规则仍生效）
          this.sniffMedia(requestUrl)
          const pageUrl = this.tab.url
          const filter = this.adBlocker.shouldBlock(requestUrl, TYPE_ALL_MASK & ~TYPE_DOCUMENT, pageUrl)
          if (filter === null) {
            return null
          }
          this.tab.adCount = this.tab.adCount + 1
          this.settings.addAdBlocked(1)
          // 原版 na.E0:717-718（z8.b0.F）：扩展名 html|htm|css|js → 空 text/plain，否则 GIF
          const queryIndex = requestUrl.indexOf('?')
          const path = queryIndex >= 0 ? requestUrl.substring(0, queryIndex) : requestUrl
          const dotIndex = path.lastIndexOf('.')
          let ext = ''
          if (dotIndex > path.lastIndexOf('/')) {
            ext = path.substring(dotIndex + 1).toLowerCase()
          }
          const response: WebResourceResponse = new WebResourceResponse()
          if (ext === 'html' || ext === 'htm' || ext === 'css' || ext === 'js') {
            response.setResponseCode(200)
            response.setReasonMessage('OK')
            response.setResponseMimeType('text/plain')
            response.setResponseData('')
          } else {
            response.setResponseCode(200)
            response.setReasonMessage('OK')
            response.setResponseMimeType('image/gif')
            response.setResponseData(GIF_PLACEHOLDER.buffer)
          }
          response.setResponseHeader([{ headerKey: 'Cache-Control', headerValue: 'no-store' }])
          return response
        })
        // 原版 k6.z（onShowCustomView → ib 视频探测）：进入全屏唤起视频播放器覆盖层
        .onFullScreenEnter((event: FullScreenEnterEvent) => {
          const state = VideoOverlayState.getInstance()
          state.begin(this.tab, event.handler, this.getUIContext().getHostContext())
          if (event.videoWidth !== undefined && event.videoWidth > 0) {
            const vw = event.videoWidth
            const vh = event.videoHeight === undefined ? 0 : event.videoHeight
            state.setVideoSize(vw, vh)
          }
        })
        // 原版 k6.V（onHideCustomView）：退出全屏，恢复状态栏/方向/亮度
        .onFullScreenExit(() => {
          VideoOverlayState.getInstance().end()
        })
        // 原版「滑动屏幕前进后退」（cm 开关=swipeSwitchTab）：GestureTouchEvent 状态机横滑，
        // 0.8 增益位移、80% 宽度提交、300ms 动画
        .translate({ x: this.swipeNavOffset })
        .opacity(this.swipeNavAlpha)
        .onAreaChange((_old: Area, newArea: Area) => {
          this.swipeNavWidth = Number(newArea.width)
        })
        .gesture(PanGesture({ fingers: 1, direction: PanDirection.Horizontal, distance: 4 })
          .onActionStart(() => {
            this.swipeNavReset()
          })
          .onActionUpdate((event: GestureEvent) => {
            this.swipeNavUpdate(event)
          })
          .onActionEnd(() => {
            this.swipeNavFinish()
          })
          .onActionCancel(() => {
            this.swipeNavReset()
          }))
      // 原版 k6 f2570c1：网页容器前景黑色蒙版，夜间生效时 alpha=nightfilter（默认 77）
      if (this.settings.isNightActive()) {
        Column()
          .width('100%')
          .height('100%')
          .backgroundColor(`#${this.maskAlphaHex()}000000`)
          .hitTestBehavior(HitTestMode.None)
      }
      if (this.tab.isError) {
        this.ErrorView()
      }
      // 原版 g6.i.h(za.g.class, pdfPath)：file:// pdf 导航被拦截后全屏打开查看器
      if (this.pdfPreviewPath !== '') {
        PdfViewerView({
          pdfPath: this.pdfPreviewPath,
          pdfTitle: this.pdfPreviewName,
          inOverlay: true,
          onClose: () => {
            this.closePdfPreview()
          }
        })
      }
    }
  }

  @Builder
  ErrorView() {
    Column({ space: 16 }) {
      AppIcon({ icon: $r('sys.symbol.cloud'), iconSize: 48, iconColor: $r('app.color.fg_secondary') })
      Text($r('app.string.page_failed_load'))
        .fontSize(16)
        .fontColor($r('app.color.fg'))
      if (this.tab.errorDesc !== '') {
        Text(this.tab.errorDesc)
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .maxLines(2)
          .textAlign(TextAlign.Center)
      }
      Row({ space: 12 }) {
        Button($r('app.string.page_error_retry'))
          .fontSize(14)
          .height(36)
          .backgroundColor($r('app.color.accent'))
          .onClick(() => {
            this.tab.isError = false
            try {
              this.tab.controller.refresh()
            } catch (error) {
              console.error('refresh failed')
            }
          })
        Button($r('app.string.home_page'))
          .fontSize(14)
          .height(36)
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            TabStore.getInstance().gotoHome()
          })
      }
    }
    .width('100%')
    .height('100%')
    .backgroundColor($r('app.color.page_bg'))
    .justifyContent(FlexAlign.Center)
    .gesture(PanGesture({ fingers: 1, direction: PanDirection.Horizontal })
      .onActionEnd((event: GestureEvent) => {
        // 原版「滑动屏幕前进后退」（cm，默认开启）：右滑后退、左滑前进（k6.java:6892）
        if (!this.settings.swipeSwitchTab) {
          return
        }
        if (Math.abs(event.offsetX) < 80 || Math.abs(event.offsetX) < Math.abs(event.offsetY)) {
          return
        }
        const tab = this.tabStore.current()
        try {
          if (event.offsetX > 0 && tab.canBack) {
            tab.controller.backward()
          } else if (event.offsetX < 0 && tab.canForward) {
            tab.controller.forward()
          }
        } catch (error) {
          console.error('swipe nav failed')
        }
      }))
  }

  // 检测段（GestureTouchEvent.c）：4dp 检测阈值、横向优势、速度 0.5px/ms；
  // 方向闸 k6.a.f→V7/W7：右滑后退需 canBack、左滑前进需 canForward；
  // 拖动段（o()）：0.8 增益、±80% 宽度限幅
  private swipeNavUpdate(event: GestureEvent): void {
    if (!this.settings.swipeSwitchTab || this.swipeNavLocked) {
      return
    }
    const dx = event.offsetX
    const dy = event.offsetY
    if (!this.swipeNavActive) {
      if (Math.abs(dx) < 4 || Math.abs(dx) <= Math.abs(dy)) {
        return
      }
      // 0.5px/ms ≈ 500px/s；GestureEvent.velocityX 单位为 vp/s
      if (Math.abs(event.velocityX) < px2vp(500)) {
        return
      }
      if ((dx > 0 && !this.tab.canBack) || (dx < 0 && !this.tab.canForward)) {
        this.swipeNavLocked = true
        return
      }
      this.swipeNavActive = true
    }
    const max = this.swipeNavWidth * 0.8
    this.swipeNavOffset = Math.max(-max, Math.min(max, dx * 0.8))
  }

  private swipeNavReset(): void {
    this.swipeNavActive = false
    this.swipeNavLocked = false
    this.swipeNavOffset = 0
    this.swipeNavAlpha = 1
  }

  // 松手（GestureTouchEvent.h/e）：过 80% 宽度 → 300ms 淡出并触发导航
  // （右滑后退/左滑前进），否则 300ms 比例时长回弹
  private swipeNavFinish(): void {
    if (!this.swipeNavActive) {
      this.swipeNavReset()
      return
    }
    const max = this.swipeNavWidth * 0.8
    const passed = max > 0 && Math.abs(this.swipeNavOffset) >= max
    if (passed) {
      const goBack = this.swipeNavOffset > 0
      this.getUIContext().animateTo({ duration: 300, curve: Curve.Linear }, () => {
        this.swipeNavAlpha = 0
      })
      setTimeout(() => {
        try {
          const tab = this.tabStore.current()
          if (goBack) {
            tab.controller.backward()
          } else {
            tab.controller.forward()
          }
        } catch (error) {
          console.error('swipe navigate failed')
        }
        this.swipeNavReset()
      }, 300)
    } else {
      const ratio = max > 0 ? Math.abs(this.swipeNavOffset) / max : 0
      const duration = Math.max(1, Math.round(ratio * 300))
      this.getUIContext().animateTo({ duration: duration, curve: Curve.Linear }, () => {
        this.swipeNavOffset = 0
      })
    }
  }

  // 原版 i6/i0.c(str)：取 URL 路径扩展名（忽略查询串），判断是否 pdf
  private urlPdfExtension(url: string): boolean {
    const queryIndex = url.indexOf('?')
    const path = queryIndex >= 0 ? url.substring(0, queryIndex) : url
    const dotIndex = path.lastIndexOf('.')
    if (dotIndex < 0 || dotIndex < path.lastIndexOf('/')) {
      return false
    }
    return path.substring(dotIndex + 1).toLowerCase() === 'pdf'
  }

  // 原版 k6.java:8595：g6.i.h(za.g.class, pdfPath) —— file:// uri 解析为沙箱路径后进查看器
  private openPdfPreview(url: string): void {
    let path = url.substring('file://'.length)
    try {
      path = decodeURIComponent(path)
    } catch (error) {
    }
    if (path === '') {
      return
    }
    this.pdfPreviewPath = path
    this.pdfPreviewName = this.pdfBaseName(path)
  }

  private closePdfPreview(): void {
    this.pdfPreviewPath = ''
    this.pdfPreviewName = ''
  }

  private pdfBaseName(path: string): string {
    const index = path.lastIndexOf('/')
    if (index >= 0 && index < path.length - 1) {
      return path.substring(index + 1)
    }
    return path
  }

  private maskAlphaHex(): string {
    const alpha = Math.max(0, Math.min(255, Math.round(this.settings.nightFilter)))
    const h = alpha.toString(16)
    return h.length === 1 ? `0${h}` : h
  }

  private siteNoImage(): boolean {
    const setting = this.settings.getSiteSetting(hostOf(this.tab.url))
    if (setting !== null) {
      return setting.noImage
    }
    return false
  }

  // 原版 e8/i.M()：内部页 100；有站点缩放（ba.b.i(F0)）用站点值否则全局 F0()；
  // liveZoom>0 时为 qb 弹窗拖动实时预览（k6.g.onProgressChanged setTextZoom）
  private textZoomForTab(url: string): number {
    if (this.tab.liveZoom > 0) {
      return this.tab.liveZoom
    }
    if (!url.startsWith('http')) {
      return 100
    }
    const host = hostOf(url)
    const siteZoom = this.settings.getSiteFontZoom(host)
    if (siteZoom > 0) {
      return siteZoom
    }
    return this.settings.textZoom
  }

  private sniffMedia(url: string): void {
    if (!this.settings.autoSniffButton) {
      return
    }
    // 原版 e8/j.o → d8.d.i：页开始按 wlr 白名单（v.qq/youku/iqiyi/mgtv/bilibili/ximalaya/film.qq）
    // 标记本页；d8/c.a：wlr 页跳过媒体类资源记录（cVar.e() && f4593e → return）
    if (RemoteConfig.getInstance().isInWlr(this.tab.url)) {
      return
    }
    const lower = url.toLowerCase()
    const queryIndex = lower.indexOf('?')
    const path = queryIndex >= 0 ? lower.substring(0, queryIndex) : lower
    const exts: string[] = ['.mp4', '.m3u8', '.mp3', '.m4a', '.webm', '.flv', '.mov', '.aac', '.ogg', '.mpd']
    let matched = false
    for (let i = 0; i < exts.length; i++) {
      if (path.endsWith(exts[i])) {
        matched = true
        break
      }
    }
    if (!matched) {
      return
    }
    if (this.tab.sniffedMedia.indexOf(url) >= 0) {
      return
    }
    const next: string[] = this.tab.sniffedMedia.slice()
    next.push(url)
    if (next.length > 20) {
      next.splice(0, next.length - 20)
    }
    this.tab.sniffedMedia = next
  }

  private applyAdvancedSettings(): void {
    try {
      webview.WebviewController.setWebDebuggingAccess(this.settings.allowDebugWeb)
    } catch (error) {
      console.error('setWebDebuggingAccess failed')
    }
    try {
      this.tab.controller.enableSafeBrowsing(!this.settings.disableSafeBrowsing)
    } catch (error) {
      console.error('enableSafeBrowsing failed')
    }
  }

  private lastAppliedUa: string = ''

  private applyUa(url: string): void {
    const ua = this.settings.uaForHost(hostOf(url))
    if (ua !== null) {
      try {
        this.tab.controller.setCustomUserAgent(ua)
        this.lastAppliedUa = ua
      } catch (error) {
        console.error('setCustomUserAgent failed')
      }
    } else if (this.lastAppliedUa !== '') {
      // 原版默认 UA 为系统 WebView 默认：切回默认时恢复
      try {
        this.tab.controller.setCustomUserAgent('')
        this.lastAppliedUa = ''
      } catch (error) {
        console.error('reset user agent failed')
      }
    }
  }

  private updateNavState(): void {    try {
      this.tab.canBack = this.tab.controller.accessBackward()
      this.tab.canForward = this.tab.controller.accessForward()
    } catch (error) {
      console.error('access nav state failed')
    }
  }

  private saveHistory(url: string): void {
    if (this.tab.incognito || !url.startsWith('http')) {
      return
    }
    const title = this.tab.title !== '' ? this.tab.title : url
    this.db.addHistory(title, url).catch((error: BusinessError) => {
      console.error(`add history failed: ${error.message}`)
    })
    TabStore.getInstance().snapshot(this.settings)
  }

  // 原版 k6.A9（k6.java:3623）统一上下文菜单：str=链接、str2=图片、str3=锚文本。
  // 普通网页（iD==-1）分支：图片 src 非空走图片菜单（10 项），否则链接非空走链接菜单
  private handleContextMenu(event?: OnContextMenuShowEvent): boolean {
    if (event === undefined) {
      return false
    }
    const link = event.param.getLinkUrl()
    const src = event.param.getSourceUrl()
    if (src !== '') {
      this.showImageMenu(event, link, src)
      return true
    }
    if (link === '') {
      return false
    }
    this.showLinkMenu(link)
    return true
  }

  // 原版 A9 链接分支（普通网页 iD==-1）：后台打开(0)/新标签打开(1)/复制链接(3)/分享(31)。
  // 原版无「打开」「下载链接」项；无标题无正文（w5.k 仅条目列表）。
  // 保留工程 longPressHidden 定制管线过滤条目
  private showLinkMenu(link: string): void {
    const hidden = this.settings.longPressHidden
    const sheets: SheetInfo[] = []
    if (hidden.indexOf('open_background') < 0) {
      sheets.push({
        title: '后台打开',
        action: (): void => {
          this.tabStore.newTabAt(link, true)
        }
      })
    }
    if (hidden.indexOf('open_new_tab') < 0) {
      sheets.push({
        title: '新标签打开',
        action: (): void => {
          this.tabStore.newTabAt(link, false)
        }
      })
    }
    if (hidden.indexOf('copy_link') < 0) {
      sheets.push({
        title: '复制链接',
        action: (): void => {
          this.copyLink(link)
        }
      })
    }
    if (hidden.indexOf('share') < 0) {
      sheets.push({
        title: '分享',
        action: (): void => {
          this.shareLink(link)
        }
      })
    }
    if (sheets.length === 0) {
      return
    }
    ActionSheet.show({
      // ArkUI ActionSheetOptions 的 title/message 为必填（API 18 起），原版菜单无标题正文
      title: '',
      message: '',
      sheets: sheets
    })
  }

  // 原版 A9 普通网页图片分支（str2 非空）10 项 + 链接 2 项，
  // 项集/顺序/条件/文案 1:1（条件 z11=s||k||l，点击分发见 k6.Q3 k6.java:1984）
  private showImageMenu(event: OnContextMenuShowEvent, link: string, src: string): void {
    const pageUrl = this.tab.url
    const pageHttp = pageUrl.startsWith('http://') || pageUrl.startsWith('https://')
    // A9 z11 = s(http)||k(data:)||l(file://)（按图片 src 判定）
    const shareable = src.startsWith('http://') || src.startsWith('https://') ||
      src.startsWith('data:') || src.startsWith('file://')
    const selection = event.param.getSelectionText()
    const sheets: SheetInfo[] = []
    // (2, b0) 查看图片：Q3 case2 → na.k1 图片地址新标签打开
    sheets.push({
      title: '查看图片',
      action: (): void => {
        this.tabStore.newTabAt(src, false)
      }
    })
    // (38, a1) 下载图片：Q3 case38 → q8 下载管线（mime image/*）
    sheets.push({
      title: '下载图片',
      action: (): void => {
        this.downloadLink(src)
      }
    })
    // (6, aq) 保存图片：Q3 case6 → La → Ea(str,4) 下载管线存图。
    // 工程下载管线无存图分类，接最近似：同走下载管线
    sheets.push({
      title: '保存图片',
      action: (): void => {
        this.downloadLink(src)
      }
    })
    if (shareable) {
      // (33, ts) 分享图片：Q3 case33 → hb → Ea(str,1) 系统分享
      sheets.push({
        title: '分享图片',
        action: (): void => {
          this.shareLink(src)
        }
      })
    }
    if (src.startsWith('http')) {
      // (7, sw) 以图搜图：Q3 case7 → Qa 12 引擎选择弹窗
      sheets.push({
        title: '以图搜图',
        action: (): void => {
          this.showImageSearchMenu(src)
        }
      })
    }
    if (pageHttp && this.imageAllowedNow()) {
      // (8, ak) 看图模式：Q3 case8 → z8 → y9(db.a)（条件 e1=当前有图）
      sheets.push({
        title: '看图模式',
        action: (): void => {
          this.openPictureMode()
        }
      })
    }
    // (22, ah) 页面信息：Q3 case22 标题/页面链接/选中链接
    sheets.push({
      title: '页面信息',
      action: (): void => {
        this.showPageInfo(link)
      }
    })
    if (pageHttp && this.settings.adBlockOn) {
      // (23, aa) 标记广告：Q3 case23 → C9() 注入元素选择器（条件 b1=广告拦截开启）
      sheets.push({
        title: '标记广告',
        action: (): void => {
          try {
            this.tab.controller.runJavaScript(MARK_AD_INJECT_JS)
          } catch (error) {
            console.error('inject mark ad failed')
          }
        }
      })
    }
    if (selection !== '') {
      // (29, u) 复制链接文本：Q3 case29（原版取 requestFocusNodeHref 锚文本，
      // ArkWeb 无锚文本源，以当前选中文本近似）
      sheets.push({
        title: '复制链接文本',
        action: (): void => {
          this.copyText(selection)
        }
      })
    }
    if (shareable) {
      // (34, si) 扫描二维码：Q3 case34 → Pa → Ea(str,2) 下载后识码
      sheets.push({
        title: '扫描二维码',
        action: (): void => {
          this.scanQrFromImage(src)
        }
      })
    }
    if (link !== '') {
      // (3, s) 复制链接 / (31, at) 分享
      sheets.push({
        title: '复制链接',
        action: (): void => {
          this.copyLink(link)
        }
      })
      sheets.push({
        title: '分享',
        action: (): void => {
          this.shareLink(link)
        }
      })
    }
    ActionSheet.show({
      // ArkUI ActionSheetOptions 的 title/message 为必填（API 18 起），原版菜单无标题正文
      title: '',
      message: '',
      sheets: sheets
    })
  }

  // 原版 k6.Qa（k6.java:5651）：以图搜图 12 引擎选择（标题 sw），k6.k6 拼 URL 新标签打开
  private showImageSearchMenu(src: string): void {
    let encoded = src
    try {
      encoded = encodeURIComponent(src)
    } catch (error) {
      encoded = src
    }
    const sheets: SheetInfo[] = []
    for (let i = 0; i < IMAGE_SEARCH_ENGINES.length; i++) {
      const engine = IMAGE_SEARCH_ENGINES[i]
      const template = engine.template
      sheets.push({
        title: engine.name,
        action: (): void => {
          this.tabStore.newTabAt(template + encoded, false)
        }
      })
    }
    ActionSheet.show({
      title: '以图搜图',
      message: '',
      sheets: sheets
    })
  }

  // 原版 c8/db.a：看图模式注入（无图片 alert od「无图片」）
  private openPictureMode(): void {
    try {
      this.tab.controller.runJavaScript(PICTURE_MODE_JS)
    } catch (error) {
      console.error('open picture mode failed')
    }
  }

  // 原版 Q3 case22：AlertDialog 标题 ah「页面信息」，正文 标题：/页面链接：/选中链接：
  private showPageInfo(link: string): void {
    this.getUIContext().showAlertDialog({
      title: '页面信息',
      message: `标题：${this.tab.title}\n\n页面链接：${this.tab.url}\n\n选中链接：${link}`,
      primaryButton: {
        value: $r('app.string.confirm'),
        action: () => {
        }
      },
      cancel: () => {
      }
    })
  }

  private copyText(text: string): void {
    const data = pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, text)
    pasteboard.getSystemPasteboard().setData(data).then(() => {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.copied'), duration: 1500 })
    }).catch(() => {
      console.error('copy text failed')
    })
  }

  // 原版 Q3 case34 → Pa → Ea(str,2)：下载图片后识码（k6 t1 911 结果弹窗：确定=当前页打开、复制）。
  // ArkTS：http 拉图落盘 cache → detectBarcode.decode 识码 → 结果弹窗，用后即删临时文件
  private scanQrFromImage(src: string): void {
    if (!src.startsWith('http')) {
      return
    }
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    const client = http.createHttp()
    client.request(src, {
      method: http.RequestMethod.GET,
      expectDataType: http.HttpDataType.ARRAY_BUFFER
    }).then((resp: http.HttpResponse) => {
      client.destroy()
      const data = resp.result instanceof ArrayBuffer ? resp.result : new ArrayBuffer(0)
      const path = `${context.cacheDir}/via_qr_image`
      const file = fileIo.openSync(path,
        fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE | fileIo.OpenMode.TRUNC)
      fileIo.writeSync(file.fd, data)
      fileIo.closeSync(file)
      const input: detectBarcode.InputImage = { uri: `file://${path}` }
      detectBarcode.decode(input).then((results: Array<scanBarcode.ScanResult>) => {
        try {
          fileIo.unlinkSync(path)
        } catch (error) {
          console.error('remove qr temp image failed')
        }
        if (results.length === 0 || results[0].originalValue === '') {
          return
        }
        const value = results[0].originalValue
        this.getUIContext().showAlertDialog({
          title: '提示',
          message: value,
          primaryButton: {
            value: $r('app.string.confirm'),
            action: () => {
              this.tabStore.navigate(value)
            }
          },
          secondaryButton: {
            value: $r('app.string.copy'),
            action: () => {
              this.copyText(value)
            }
          },
          cancel: () => {
          }
        })
      }).catch(() => {
        console.error('decode qr image failed')
      })
    }).catch(() => {
      client.destroy()
      console.error('fetch qr image failed')
    })
  }

  private copyLink(link: string): void {
    const data = pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, link)
    pasteboard.getSystemPasteboard().setData(data).then(() => {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.link_copied'), duration: 1500 })
    }).catch(() => {
      console.error('copy link failed')
    })
  }

  private downloadLink(link: string): void {
    // 原版下载链接与网页下载同走确认弹层（mark/via/download/m.java）
    const pageUa = this.settings.uaForHost(hostOf(this.tab.url)) ?? ''
    DownloadCoordinator.getInstance().requestUrlDownload(link, this.tab.url, pageUa)
  }

  private shareLink(link: string): void {
    const shareData: systemShare.SharedData = new systemShare.SharedData({
      utd: utd.UniformDataType.HYPERLINK,
      content: link,
      title: link,
      description: link
    })
    const controller: systemShare.ShareController = new systemShare.ShareController(shareData)
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    controller.show(context, {
      selectionMode: systemShare.SelectionMode.SINGLE,
      previewMode: systemShare.SharePreviewMode.DETAIL
    }).catch(() => {
      console.error('share link failed')
    })
  }

  // 原版 na.E0()：元素隐藏 CSS（via_inject_blocker.css）
  // 原版 k6.Ja(i10=1):4573：b1(url) 命中 wlb 白名单（youku/iqiyi/mgtv/qq）时
  // 跳过 m8.b.b（via_inject_blocker.css 注入豁免），视频站不被元素隐藏 CSS 干扰
  private injectBlockerCss(pageUrl: string): void {
    if (RemoteConfig.getInstance().isInWlb(pageUrl)) {
      return
    }
    const script = this.adBlocker.cssInjectScript(pageUrl)
    if (script === '') {
      return
    }
    try {
      this.tab.controller.runJavaScript(script)
    } catch (error) {
      console.error('inject blocker css failed')
    }
  }

  // 原版 k6:4612-4614（onPageFinished 脚本注入段）：uifont 非空注入 ta.a，路径 "/"+字体名
  private injectCustomFont(): void {
    if (this.settings.uiFont === '') {
      return
    }
    const js = CUSTOM_FONT_JS.replace('__PATH__', `/${this.settings.uiFont}`)
    this.tab.controller.runJavaScript(js).catch(() => {
      console.error('inject custom font failed')
    })
  }

  // 原版 na.E0:707-711 + s9/d.f：请求 URL 以 URL 编码后的字体名结尾（i6.u.b）→ 回源 fonts 目录，
  // 头 Cache-Control immutable / ACAO * / Content-Type（mime 按扩展名，默认 font/ttf）
  private interceptFont(requestUrl: string): WebResourceResponse | null {
    const fontName = this.settings.uiFont
    if (fontName === '') {
      return null
    }
    let encoded = ''
    try {
      encoded = encodeURIComponent(fontName)
    } catch (error) {
      encoded = fontName
    }
    if (!requestUrl.endsWith(encoded)) {
      return null
    }
    const context = getContext(this) as common.Context
    const bytes = FontStore.getInstance().readBytes(context, fontName)
    if (bytes === null) {
      return null
    }
    const mime = FontStore.getInstance().mimeOf(fontName)
    const response = new WebResourceResponse()
    response.setResponseCode(200)
    response.setReasonMessage('OK')
    response.setResponseMimeType(mime)
    response.setResponseEncoding('UTF-8')
    response.setResponseData(bytes)
    response.setResponseHeader([
      { headerKey: 'Cache-Control', headerValue: 'immutable' },
      { headerKey: 'Access-Control-Allow-Origin', headerValue: '*' },
      { headerKey: 'Content-Type', headerValue: mime }
    ])
    return response
  }

  private injectCustomCss(): void {    if (this.settings.customCss === '') {
      return
    }
    const js = `(function(){var s=document.createElement("style");s.textContent=${JSON.stringify(this.settings.customCss)};document.head.appendChild(s);})();`
    this.tab.controller.runJavaScript(js).catch(() => {
      console.error('inject custom css failed')
    })
  }

  // 原版 c0.q + 自动阅读（c0.g/w.i state 5 时自动进入）：
  // 页面加载完成后注入 Readability + isProbablyReaderable，自动开启场景下检查状态
  private prepareReader(): void {
    if (this.tab.incognito || this.tab.isHomePage() || !this.tab.url.startsWith('http')) {
      return
    }
    if (!Reader.isScriptableUrl(this.tab.url)) {
      return
    }
    Reader.injectReaderScripts(this.tab).then(() => {
      if (!this.settings.readerAuto) {
        return
      }
      // 原版 w.i state 5：用户已确认自动进入（localStorage.__via_reader_enabled__）
      return Reader.checkState(this.tab).then((state: number) => {
        if (state === 5) {
          // 原版 Q4 state 5 → B8()：wld 命中 → g6.n.q(O1)「不支持该网站」，不进入阅读
          if (RemoteConfig.getInstance().isInWld(this.tab.url)) {
            this.getUIContext().getPromptAction().showToast({
              message: $r('app.string.site_not_supported'),
              duration: 1500
            })
            return false
          }
          return Reader.enterReader(this.tab, READER_THEME_COLORS[this.settings.readerTheme],
            this.settings.readerFontSize, this.settings.readerCustomCss)
        }
        return false
      })
    }).catch(() => {
      console.error('auto reader failed')
    })
  }

  private expandFullText(): void {
    // 原版 k6:5262/7538：!r9.g.a().e(url)——wls 白名单（v.qq.com/film.qq.com）豁免，不自动展开
    if (!this.settings.autoExpandFullText || this.tab.incognito || this.tab.isHomePage() ||
      RemoteConfig.getInstance().isInWls(this.tab.url)) {
      return
    }
    const js = '(function(){var k=/(展开全文|阅读全文|查看全文|显示全文|展开剩余|show more|read more|view more)/i;if(k.test(document.body?document.body.innerText:"")){var els=document.querySelectorAll("button,a,div,span,p");for(var i=0;i<els.length;i++){var t=(els[i].innerText||"").trim();if(t&&t.length<=10&&k.test(t)){els[i].click();break}}}})()'
    this.tab.controller.runJavaScript(js).catch(() => {
    })
  }

  // 原版 k6.Nb()：网页 meta theme-color 决定工具栏/地址栏配色（颜色模式开关控制）
  private syncThemeColor(): void {
    if (this.tab.isHomePage()) {
      this.tab.themeColor = ''
      return
    }
    const js = '(function(){var m=document.querySelector("meta[name=theme-color]");' +
      'return (m&&m.content)?m.content:"";})()'
    this.tab.controller.runJavaScript(js).then((result: string) => {
      this.tab.themeColor = typeof result === 'string' ? result.trim() : ''
    }).catch(() => {
      this.tab.themeColor = ''
    })
  }

  // 隐私设置注入脚本：defineProperty 只读属性，页面脚本无法读取真实值或提前缓存。
  // documentStart（API 15+）在文档根元素创建后、页面任何脚本执行前注入；
  // onPageEnd 兜底再执行一次，覆盖设置变更后已打开页面的补生效场景
  private buildPrivacyScript(): string {
    let js = ''
    if (this.settings.doNotTrack) {
      js += 'try{Object.defineProperty(navigator,"doNotTrack",{get:function(){return "1";},configurable:true});}catch(e){}'
    }
    if (this.settings.doNotSell) {
      js += 'try{Object.defineProperty(navigator,"globalPrivacyControl",{get:function(){return true;},configurable:true});}catch(e){}'
    }
    if (this.settings.disableWebRtc) {
      js += 'try{window.RTCPeerConnection=undefined;window.webkitRTCPeerConnection=undefined;'
        + 'if(navigator.mediaDevices){navigator.mediaDevices.getUserMedia=function(){return Promise.reject(new Error("disabled"))}}}catch(e){}'
    }
    // 原版 c8/kc.b（k6.Ja runAt=1：w9.p bit 524288 forceZoom 时注入）
    if (this.settings.forceZoom) {
      js += '(function(){var b=document.querySelector("meta[name=viewport]");if(b){for(var d=b.getAttribute("content").split(","),e=[],c=0;c<d.length;c++){var a=d[c].trim();(a.startsWith("width")||a.startsWith("initial-scale")||a.startsWith("minimum-scale"))&&e.push(a)}b.setAttribute("content",e.join(",").trim())}})();'
    }
    return js
  }

  private refreshPrivacyScripts(): void {
    // 桥 JS（i6/s M()）始终在文档开始注入，隐私脚本按需拼接
    const script = this.buildPrivacyScript() + USER_SCRIPT_BRIDGE_JS
    this.privacyScripts = [{ script: script, scriptRules: ['*'] }]
  }

  // 隐私设置注入：JS 层暴露 DNT/GPC 并屏蔽 WebRTC（引擎级开关 ArkWeb 未提供），
  // 请求级的 DNT/Sec-GPC 头需 WebSchemeHandler 全量代理，涉及网络栈接管另行决策
  private injectPrivacy(url: string): void {
    if (url.startsWith('http') === false) {
      return
    }
    const js = this.buildPrivacyScript()
    if (js !== '') {
      this.tab.controller.runJavaScript(js).catch(() => {
      })
    }
  }

  // 请求头代理（实验性，settings.privacyProxy 开关默认关闭）：
  // 拦截 http/https 请求由应用侧转发并附加 DNT/Sec-GPC 头，服务器可感知。
  // 代价：全量流量走应用网络栈，Cookie 与内核不互通（登录态可能受影响）、POST 体不透传、
  // Range/流式场景降级，性能开销大。注册一次、回调内按开关动态放行，无需重建 Web
  private setupSchemeHandler(): void {
    try {
      this.schemeHandler.onRequestStart((request: webview.WebSchemeHandlerRequest,
        resourceHandler: webview.WebResourceHandler): boolean => {
        if (!this.settings.privacyProxy || (!this.settings.doNotTrack && !this.settings.doNotSell)) {
          return false
        }
        this.proxyRequest(request, resourceHandler)
        return true
      })
      this.tab.controller.setWebSchemeHandler('http', this.schemeHandler)
      this.tab.controller.setWebSchemeHandler('https', this.schemeHandler)
    } catch (error) {
      console.error('setup scheme handler failed')
    }
  }

  private proxyRequest(request: webview.WebSchemeHandlerRequest,
    resourceHandler: webview.WebResourceHandler): void {
    const httpRequest = http.createHttp()
    const header: Record<string, string> = {}
    if (this.settings.doNotTrack) {
      header['DNT'] = '1'
    }
    if (this.settings.doNotSell) {
      header['Sec-GPC'] = '1'
    }
    const originHeaders = request.getHeader()
    for (let i = 0; i < originHeaders.length; i++) {
      const key = originHeaders[i].headerKey
      if (key !== 'DNT' && key !== 'Sec-GPC') {
        header[key] = originHeaders[i].headerValue
      }
    }
    const options: http.HttpRequestOptions = {
      method: this.toHttpMethod(request.getRequestMethod()),
      header: header,
      expectDataType: http.HttpDataType.ARRAY_BUFFER,
      usingCache: false
    }
    httpRequest.request(request.getRequestUrl(), options).then((resp: http.HttpResponse) => {
      this.deliverProxyResponse(resp, resourceHandler)
    }).catch(() => {
      try {
        resourceHandler.didFail(WebNetErrorList.ERR_FAILED)
      } catch (error) {
        console.error('didFail failed')
      }
    }).finally(() => {
      httpRequest.destroy()
    })
  }

  private toHttpMethod(method: string): http.RequestMethod {
    if (method === 'POST') {
      return http.RequestMethod.POST
    }
    if (method === 'PUT') {
      return http.RequestMethod.PUT
    }
    if (method === 'DELETE') {
      return http.RequestMethod.DELETE
    }
    if (method === 'HEAD') {
      return http.RequestMethod.HEAD
    }
    return http.RequestMethod.GET
  }

  private deliverProxyResponse(resp: http.HttpResponse, resourceHandler: webview.WebResourceHandler): void {
    const response = new webview.WebSchemeHandlerResponse()
    response.setStatus(resp.responseCode)
    response.setStatusText('OK')
    response.setNetErrorCode(WebNetErrorList.NET_OK)
    response.setMimeType(this.responseMime(resp.header))
    const headers = resp.header as Record<string, string>
    for (const key of Object.keys(headers)) {
      if (key.toLowerCase() !== 'content-length' && key.toLowerCase() !== 'transfer-encoding'
        && key.toLowerCase() !== 'content-encoding') {
        response.setHeaderByName(key, headers[key], true)
      }
    }
    const body = resp.result instanceof ArrayBuffer ? resp.result : new ArrayBuffer(0)
    try {
      resourceHandler.didReceiveResponse(response)
      resourceHandler.didReceiveResponseBody(body)
      resourceHandler.didFinish()
    } catch (error) {
      console.error('deliver proxy response failed')
    }
  }

  private responseMime(header: Object): string {
    const headers = header as Record<string, string>
    const contentType = headers['content-type'] ?? headers['Content-Type'] ?? ''
    const mime = contentType.split(';')[0].trim()
    return mime !== '' ? mime : 'text/html'
  }

  // k6:1487-1512：window.via.postMessage action 101 → 主线程分发注入
  private onViaMessage(msg: string): void {
    try {
      const parsed = JSON.parse(msg) as ScriptRunMsg
      if (parsed.action === 101) {
        this.runUserScripts(parsed.runAt, parsed.from)
      }
    } catch (error) {
    }
  }

  // n5/a.b() 1:1：非空非 file:// 才执行；runAt 1/2 时脚本站 host 注入假 Tampermonkey；
  // 每脚本 wrap = (b() & 1) == 0 即 !script.unwrap，code 非空门，
  // 拼接顺序 = [wrap头] + 沙盒(脚本id, secret, grant) + 各 require 内容 + '\n\n' + code + [wrap尾]
  private runUserScripts(runAt: number, from: string): void {
    if (from === '' || from.startsWith('file://')) {
      return
    }
    if (runAt === 1 || runAt === 2) {
      const scriptSiteHost = this.urlAuthority(from)
      if (scriptSiteHost.indexOf('greasyfork.org') >= 0 || scriptSiteHost.indexOf('userscript.zone') >= 0 ||
        scriptSiteHost.indexOf('openuserjs.org') >= 0 || scriptSiteHost.indexOf('sleazyfork.org') >= 0) {
        this.tab.controller.runJavaScript(gmFakeTampermonkeyJs(gmSecret())).catch(() => {
        })
      }
    }
    const scripts = this.settings.userScripts
    for (let i = 0; i < scripts.length; i++) {
      const script = scripts[i]
      if (!script.enabled || (script.runAt & runAt) === 0) {
        continue
      }
      let matched = false
      const includes = parseJsonArray(script.includes)
      for (let j = 0; j < includes.length; j++) {
        if (globMatches(includes[j], from)) {
          matched = true
          break
        }
      }
      if (!matched) {
        continue
      }
      const excludes = parseJsonArray(script.excludes)
      let excluded = false
      for (let j = 0; j < excludes.length; j++) {
        if (globMatches(excludes[j], from)) {
          excluded = true
          break
        }
      }
      if (excluded) {
        continue
      }
      if (script.code === '') {
        continue
      }
      const wrap = !script.unwrap
      let code = wrap ? '(function(){\n' : ''
      code += gmSandboxJs(String(script.id), gmSecret(), script.grantBits)
      const requires = parseJsonArray(script.requires)
      for (let j = 0; j < requires.length; j++) {
        code += GmRequireStore.getInstance().readCached(requires[j])
        code += '\n\n'
      }
      code += script.code
      if (wrap) {
        code += '\n})();'
      }
      this.tab.controller.runJavaScript(code).catch((error: BusinessError) => {
        console.error(`run user script failed: ${error.message}`)
      })
    }
  }

  // n5/a.e()：取 URL 的 host:port（小写），非网络 URL 返回空串
  private urlAuthority(url: string): string {
    const schemeIndex = url.indexOf('://')
    if (schemeIndex < 0) {
      return ''
    }
    const start = schemeIndex + 3
    let end = url.indexOf('/', start)
    if (end < 0) {
      end = url.length
    }
    return url.substring(start, end).toLowerCase()
  }

  private blockPageText(key: string): string {
    try {
      const context = this.getUIContext().getHostContext() as common.UIAbilityContext
      const id = context.resourceManager.getStringByNameSync(key)
      return id
    } catch (error) {
      return key
    }
  }
}
