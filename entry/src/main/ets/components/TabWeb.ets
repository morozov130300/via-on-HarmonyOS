import { pasteboard } from '@kit.BasicServicesKit'
import { common } from '@kit.AbilityKit'
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
        .forceDarkAccess(this.settings.nightMode)
        .onControllerAttached(() => {
          if (this.tab.initialUrl !== '') {
            try {
              this.tab.controller.loadUrl(this.tab.initialUrl)
            } catch (error) {
              console.error('restore tab loadUrl failed')
            }
          }
        })
        .onPageBegin((event: OnPageBeginEvent) => {
          this.tab.url = event.url
          this.tab.loading = true
          this.tab.isError = false
          this.applyUa(event.url)
          this.updateNavState()
        })
        .onPageEnd((event: OnPageEndEvent) => {
          this.tab.url = event.url
          this.tab.loading = false
          this.tab.progress = 100
          this.updateNavState()
          this.saveHistory(event.url)
          this.injectScripts(event.url)
          this.injectCustomCss()
          this.autoOpenReader()
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
          event.handler.handleCancel()
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
  }

  private siteNoImage(): boolean {
    const setting = this.settings.getSiteSetting(hostOf(this.tab.url))
    if (setting !== null) {
      return setting.noImage
    }
    return false
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

  private updateNavState(): void {
    try {
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

  private injectScripts(url: string): void {
    const host = hostOf(url)
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
