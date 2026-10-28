import { pasteboard } from '@kit.BasicServicesKit'
import { common } from '@kit.AbilityKit'
import { webview, WebNetErrorList } from '@kit.ArkWeb'
import { http } from '@kit.NetworkKit'
import { systemShare } from '@kit.ShareKit'
import { uniformTypeDescriptor as utd } from '@kit.ArkData'
import { TabItem } from '../common/Types'
import { AppSettings } from '../common/Settings'
import { AdBlocker } from '../common/AdBlock'
import { BrowserDb } from '../common/Database'
import { TabStore } from '../common/TabStore'
import { hostOf } from '../common/SearchEngines'
import { Reader } from '../common/Reader'
import { DownloadCoordinator } from '../common/Downloads'
import { AppIcon } from './AppIcon'

@ComponentV2
export struct TabWeb {
  @Param @Require tab: TabItem
  @Event onAutoReader: (text: string) => void = (text: string) => {}
  private settings: AppSettings = AppSettings.getInstance()
  private adBlocker: AdBlocker = AdBlocker.getInstance()
  private db: BrowserDb = BrowserDb.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  @Local privacyScripts: Array<ScriptItem> = []
  private schemeHandler: webview.WebSchemeHandler = new webview.WebSchemeHandler()

  aboutToAppear(): void {
    this.refreshPrivacyScripts()
    try {
      webview.WebviewController.setWebDebuggingAccess(this.settings.allowDebugWeb)
    } catch (error) {
      console.error('setWebDebuggingAccess failed')
    }
  }

  build() {
    Stack() {
      Web({ src: 'about:blank', controller: this.tab.controller, incognitoMode: this.tab.incognito })
        .javaScriptAccess(true)
        .domStorageAccess(true)
        .databaseAccess(true)
        .fileAccess(true)
        .zoomAccess(true)
        .multiWindowAccess(false)
        .imageAccess(!this.settings.noImage && !this.siteNoImage())
        .mixedMode(MixedMode.Compatible)
        .textZoomRatio(this.settings.textZoom)
        .darkMode(this.settings.nightMode ? WebDarkMode.On : WebDarkMode.Off)
        .forceDarkAccess(this.settings.nightMode && this.settings.nightForceDark)
        .runJavaScriptOnDocumentStart(this.privacyScripts)
        .onControllerAttached(() => {
          this.setupSchemeHandler()
          this.applyAdvancedSettings()
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
          this.injectScripts(event.url)
          this.injectCustomCss()
          this.autoOpenReader()
          this.expandFullText()
          this.settings.persistAdBlockTotal()
        })
        .onProgressChange((event: OnProgressChangeEvent) => {
          this.tab.progress = event.newProgress
        })
        .onTitleReceive((event: OnTitleReceiveEvent) => {
          this.tab.title = event.title
        })
        .onErrorReceive((event: OnErrorReceiveEvent) => {
          if (event.request.isMainFrame()) {
            this.tab.isError = true
            this.tab.errorDesc = event.error.getErrorInfo()
            this.tab.loading = false
          }
        })
        .onPermissionRequest((event: OnPermissionRequestEvent) => {
          event.request.deny()
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
        .onContextMenuShow((event?: OnContextMenuShowEvent) => {
          return this.handleContextMenu(event)
        })
        .onInterceptRequest((event: OnInterceptRequestEvent) => {
          if (!event.request.isMainFrame()) {
            const requestUrl = event.request.getRequestUrl()
            this.sniffMedia(requestUrl)
            const pageHost = hostOf(this.tab.url)
            if (this.adBlocker.shouldBlock(requestUrl, pageHost)) {
              this.tab.adCount = this.tab.adCount + 1
              this.settings.addAdBlocked(1)
              const response: WebResourceResponse = new WebResourceResponse()
              response.setResponseCode(204)
              response.setReasonMessage('No Content')
              response.setResponseMimeType('text/plain')
              response.setResponseHeader([{ headerKey: 'Cache-Control', headerValue: 'no-store' }])
              return response
            }
          }
          return null
        })
      if (this.tab.isError) {
        this.ErrorView()
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
        if (!this.settings.swipeSwitchTab) {
          return
        }
        if (Math.abs(event.offsetX) < 80 || Math.abs(event.offsetX) < Math.abs(event.offsetY)) {
          return
        }
        this.tabStore.stepTab(event.offsetX > 0 ? -1 : 1)
      }))
  }

  private siteNoImage(): boolean {
    const setting = this.settings.getSiteSetting(hostOf(this.tab.url))
    if (setting !== null) {
      return setting.noImage
    }
    return false
  }

  private sniffMedia(url: string): void {
    if (!this.settings.autoSniffButton) {
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

  private applyUa(url: string): void {
    const ua = this.settings.uaForHost(hostOf(url))
    if (ua !== null) {
      try {
        this.tab.controller.setCustomUserAgent(ua)
      } catch (error) {
        console.error('setCustomUserAgent failed')
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

  private handleContextMenu(event?: OnContextMenuShowEvent): boolean {
    if (event === undefined) {
      return false
    }
    const link = event.param.getLinkUrl()
    if (link === '') {
      return false
    }
    this.showLinkMenu(link)
    return true
  }

  private showLinkMenu(link: string): void {
    const hidden = this.settings.longPressHidden
    const sheets: SheetInfo[] = []
    if (hidden.indexOf('open') < 0) {
      sheets.push({
        title: '打开',
        action: (): void => {
          this.tabStore.navigate(link)
        }
      })
    }
    if (hidden.indexOf('open_new_tab') < 0) {
      sheets.push({
        title: '新标签页打开',
        action: (): void => {
          this.tabStore.newTabAt(link, false)
        }
      })
    }
    if (hidden.indexOf('open_background') < 0) {
      sheets.push({
        title: '后台打开',
        action: (): void => {
          this.tabStore.newTabAt(link, true)
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
    if (hidden.indexOf('download') < 0) {
      sheets.push({
        title: '下载链接',
        action: (): void => {
          this.downloadLink(link)
        }
      })
    }
    if (hidden.indexOf('share') < 0) {
      sheets.push({
        title: '分享链接',
        action: (): void => {
          this.shareLink(link)
        }
      })
    }
    if (sheets.length === 0) {
      return
    }
    ActionSheet.show({
      title: hostOf(link),
      message: link,
      sheets: sheets
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
    const context = getContext(this) as Context
    DownloadCoordinator.getInstance().startUrlDownload(context, link).then(() => {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.download_started'), duration: 1500 })
    }).catch(() => {
      console.error('download link failed')
    })
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

  private injectCustomCss(): void {
    if (this.settings.customCss === '') {
      return
    }
    const js = `(function(){var s=document.createElement("style");s.textContent=${JSON.stringify(this.settings.customCss)};document.head.appendChild(s);})();`
    this.tab.controller.runJavaScript(js).catch(() => {
      console.error('inject custom css failed')
    })
  }

  private autoOpenReader(): void {
    if (!this.settings.readerAuto || this.tab.incognito) {
      return
    }
    Reader.extractText(this.tab).then((text: string) => {
      if (text.trim().length > 200) {
        this.onAutoReader(text.trim())
      }
    }).catch(() => {
      console.error('auto reader extract failed')
    })
  }

  private expandFullText(): void {
    if (!this.settings.autoExpandFullText || this.tab.incognito || this.tab.isHomePage()) {
      return
    }
    const js = '(function(){var k=/(展开全文|阅读全文|查看全文|显示全文|展开剩余|show more|read more|view more)/i;if(k.test(document.body?document.body.innerText:"")){var els=document.querySelectorAll("button,a,div,span,p");for(var i=0;i<els.length;i++){var t=(els[i].innerText||"").trim();if(t&&t.length<=10&&k.test(t)){els[i].click();break}}}})()'
    this.tab.controller.runJavaScript(js).catch(() => {
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
    return js
  }

  private refreshPrivacyScripts(): void {
    const script = this.buildPrivacyScript()
    if (script === '') {
      this.privacyScripts = []
      return
    }
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

  private injectScripts(url: string): void {    const host = hostOf(url)
    const scripts = this.settings.userScripts
    for (let i = 0; i < scripts.length; i++) {
      const script = scripts[i]
      if (!script.enabled) {
        continue
      }
      if (script.matchHost !== '' && host !== script.matchHost && !host.endsWith('.' + script.matchHost)) {
        continue
      }
      this.tab.controller.runJavaScript(script.code).catch((error: BusinessError) => {
        console.error(`run script failed: ${error.message}`)
      })
    }
  }
}
