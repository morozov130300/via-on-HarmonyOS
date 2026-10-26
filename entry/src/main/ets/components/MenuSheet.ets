import { common, Want } from '@kit.AbilityKit'
import { print } from '@kit.BasicServicesKit'
import { productViewManager } from '@kit.AppGalleryKit'
import { fileIo } from '@kit.CoreFileKit'
import { AppSettings, UA_MODE_DEFAULT, UA_MODE_PC, UA_MODE_MOBILE } from '../common/Settings'
import { TabStore } from '../common/TabStore'
import { BrowserDb } from '../common/Database'
import { SiteSetting } from '../common/Types'
import { hostOf } from '../common/SearchEngines'
import { ViaIcon } from './ViaIcon'
import { UiInsets } from '../common/Immersive'

const TRANSLATE_INJECT_JS: string = `(function(){if(window.__via_translator__){window.__via_translator__.showBanner(true);return;}`
  + `window.googleTranslateElementInit=function(){if(!window.__via_translator__){window.__via_translator__=new google.translate.TranslateElement({autoDisplay:false,floatPosition:0,multilanguagePage:true,includedLanguages:"af,sq,am,ar,hy,az,eu,be,bn,bs,bg,ca,ceb,ny,zh-CN,zh-TW,co,hr,cs,da,nl,en,eo,et,tl,fi,fr,fy,gl,ka,de,el,gu,ht,ha,haw,he,hi,hmn,hu,is,id,ga,it,ja,jv,kn,kk,km,ky,ko,ku,lo,la,lv,lt,lb,mk,mg,ms,ml,mt,mi,mr,mn,my,ne,no,ps,fa,pl,pt,pa,ro,ru,sr,st,sd,si,sk,sl,so,sm,es,su,sw,sv,tg,ta,te,th,tr,uk,ur,uz,vi,cy,xh,yi,yo,zu",pageLanguage:"auto"});}`
  + `window.__via_translator__.showBanner(true);};`
  + `var s=document.createElement("script");s.src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit";document.getElementsByTagName("head")[0].appendChild(s);`
  + `document.addEventListener("securitypolicyviolation",function onCsp(e){document.removeEventListener("securitypolicyviolation",onCsp);`
  + `var id="via-translate-bridge";var t=document.getElementById(id);`
  + `if(t){if(typeof translate!=="undefined"){if("zh-CN"!==translate.to){translate.changeLanguage("zh-CN");}}else{var n=document.createElement("script");n.id=id;n.src=t.src;n.onload=t.onload;t.parentNode.replaceChild(n,t);}}`
  + `else{t=document.createElement("script");t.id=id;t.src="https://fastly.jsdelivr.net/gh/xnx3/translate@v3.14.0/translate.js/translate.min.js";`
  + `t.onload=function(){translate.selectLanguageTag.show=false;translate.service.use("client.edge");translate.changeLanguage("zh-CN");};document.head.appendChild(t);}});})();`

@ComponentV2
export struct MenuSheet {
  @Event onClose: () => void = () => {}
  @Event onOpenPage: (page: string) => void = (page: string) => {}
  @Event onFindInPage: () => void = () => {}
  @Event onShare: () => void = () => {}
  @Event onSavePage: () => void = () => {}
  @Event onOpenAi: () => void = () => {}
  private settings: AppSettings = AppSettings.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  @Local showToolbox: boolean = false
  private insets: UiInsets = UiInsets.getInstance()

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
      .padding({ bottom: this.insets.bottom })
      .backgroundColor($r('app.color.menu_bg'))
    }
    .width('100%')
    .height('100%')
  }

  @Builder
  MainGrid() {
    Grid() {
      if (!this.hidden('bookmarks')) {
        GridItem() {
          this.GridCell($r('app.media.via_ic_bookmark'), $r('app.string.bookmarks'), () => {
            this.onOpenPage('bookmarks')
          })
        }
      }
      if (!this.hidden('history')) {
        GridItem() {
          this.GridCell($r('app.media.via_ic_history'), $r('app.string.history'), () => {
            this.onOpenPage('history')
          })
        }
      }
      if (!this.hidden('downloads')) {
        GridItem() {
          this.GridCell($r('app.media.via_ic_download'), $r('app.string.downloads'), () => {
            this.onOpenPage('downloads')
          })
        }
      }
      if (!this.hidden('incognito')) {
        GridItem() {
          this.GridCell($r('app.media.via_ic_incognito'), $r('app.string.incognito'), () => {
            this.openIncognito()
          })
        }
      }
      if (!this.hidden('share')) {
        GridItem() {
          this.GridCell($r('app.media.via_ic_share'), $r('app.string.share'), () => {
            this.onClose()
            this.onShare()
          })
        }
      }
      if (!this.hidden('add_bookmark')) {
        GridItem() {
          this.GridCell($r('app.media.via_ic_add_bookmark'), $r('app.string.add_bookmark'), () => {
            this.addBookmark()
          })
        }
      }
      if (!this.hidden('pc_mode')) {
        GridItem() {
          this.GridCell($r('app.media.via_ic_pc_mode'), $r('app.string.pc_mode'), () => {
            this.toggleSitePcMode()
          })
        }
      }
      if (!this.hidden('save')) {
        GridItem() {
          this.GridCellBody($r('app.media.via_ic_save'), $r('app.string.save'), !this.tabStore.current().isHomePage(), () => {
            this.onClose()
            this.onSavePage()
          })
        }
      }
      if (!this.hidden('toolbox')) {
        GridItem() {
          this.GridCell($r('app.media.via_ic_toolbox'), $r('app.string.toolbox'), () => {
            this.showToolbox = true
          })
        }
      }
      if (!this.hidden('settings')) {
        GridItem() {
          this.GridCell($r('app.media.via_ic_settings'), $r('app.string.settings'), () => {
            this.onOpenPage('settings')
          })
        }
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
        if (!this.hidden('find')) {
          GridItem() {
            this.GridCell($r('app.media.via_ic_find'), $r('app.string.find_in_page'), () => {
              this.onClose()
              this.onFindInPage()
            })
          }
        }
        if (!this.hidden('offline')) {
          GridItem() {
            this.GridCell($r('app.media.via_ic_offline'), $r('app.string.offline_page'), () => {
              this.onOpenPage('offlinePage')
            })
          }
        }
        if (!this.hidden('translate')) {
          GridItem() {
            this.GridCell($r('app.media.via_ic_translate'), $r('app.string.translate'), () => {
              this.translatePage()
            })
          }
        }
        if (!this.hidden('add_to_desktop')) {
          GridItem() {
            this.GridCell($r('app.media.via_ic_add_to_desktop'), $r('app.string.add_to_desktop'), () => {
              this.addToDesktop()
            })
          }
        }
        if (!this.hidden('script')) {
          GridItem() {
            this.GridCell($r('app.media.via_ic_script'), $r('app.string.scripts'), () => {
              this.onOpenPage('settingsScript')
            })
          }
        }
        if (!this.hidden('adblock')) {
          GridItem() {
            this.GridCell($r('app.media.via_ic_adblock'), $r('app.string.ad_block'), () => {
              this.onOpenPage('rules')
            })
          }
        }
        if (!this.hidden('ai')) {
          GridItem() {
            this.GridCell($r('app.media.via_ic_ai'), $r('app.string.ai'), () => {
              this.onClose()
              this.onOpenAi()
            })
          }
        }
        if (!this.hidden('print')) {
          GridItem() {
            this.GridCell($r('app.media.via_ic_print'), $r('app.string.print_pdf'), () => {
              this.printPage()
            })
          }
        }
        if (!this.hidden('ua')) {
          GridItem() {
            this.GridCell($r('app.media.via_ic_ua'), $r('app.string.browser_ua'), () => {
              this.pickUa()
            })
          }
        }
        if (!this.hidden('netlog')) {
          GridItem() {
            this.GridCell($r('app.media.via_ic_netlog'), $r('app.string.net_log'), () => {
              this.onOpenPage('netLog')
            })
          }
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

  private shortcutTid: string = ''

  private addToDesktop(): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      this.homePageGuard()
      return
    }
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    this.prepareShortcutIcon(context).then(() => {
      const want: Want = {
        bundleName: context.abilityInfo.bundleName,
        moduleName: 'entry',
        abilityName: 'EntryAbility',
        parameters: { 'viaUrl': tab.url }
      }
      const label = tab.title.trim() !== '' ? tab.title.trim() : hostOf(tab.url)
      const iconPath = `${context.filesDir}/via_shortcut_icon.png`
      return productViewManager.checkPinShortcutPermitted(context, `via_${Date.now()}`, want, label, iconPath, '')
    }).then((result: productViewManager.CheckShortcutResult) => {
      this.shortcutTid = result.tid ?? ''
      if (this.shortcutTid === '') {
        return Promise.reject(new Error('empty tid'))
      }
      return productViewManager.requestNewPinShortcut(context, this.shortcutTid)
    }).then(() => {
      this.onClose()
    }).catch((error: BusinessError) => {
      console.error(`add shortcut failed: ${error.message}`)
    })
  }

  private prepareShortcutIcon(context: common.UIAbilityContext): Promise<void> {
    const iconPath = `${context.filesDir}/via_shortcut_icon.png`
    return context.resourceManager.getMediaContent($r('app.media.foreground').id).then((content: Uint8Array) => {
      const file = fileIo.openSync(iconPath,
        fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE | fileIo.OpenMode.TRUNC)
      return fileIo.write(file.fd, content.buffer).finally(() => {
        fileIo.closeSync(file)
      })
    }).then(() => {
      return Promise.resolve()
    })
  }

  private translatePage(): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      this.homePageGuard()
      return
    }
    try {
      tab.controller.runJavaScript(TRANSLATE_INJECT_JS)
      this.onClose()
    } catch (error) {
      console.error('inject translator failed')
    }
  }

  private printPage(): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      this.homePageGuard()
      return
    }
    try {
      const adapter = tab.controller.createWebPrintDocumentAdapter(`${hostOf(tab.url)}.pdf`)
      const context = this.getUIContext().getHostContext() as common.UIAbilityContext
      print.print('via_print_job', adapter, null, context)
      this.onClose()
    } catch (error) {
      console.error('launch print failed')
    }
  }

  private pickUa(): void {
    const sheets: SheetInfo[] = [
      { title: 'iPhone', action: (): void => {
        this.applyUaMode(UA_MODE_DEFAULT)
      } },
      { title: '电脑版', action: (): void => {
        this.applyUaMode(UA_MODE_PC)
      } },
      { title: '手机版', action: (): void => {
        this.applyUaMode(UA_MODE_MOBILE)
      } }
    ]
    ActionSheet.show({
      title: '浏览器标识',
      message: '选择网页浏览器标识',
      sheets: sheets
    })
  }

  private applyUaMode(mode: number): void {
    this.settings.setUaMode(mode)
    try {
      this.tabStore.current().controller.refresh()
    } catch (error) {
      console.error('refresh after ua change failed')
    }
    this.onClose()
  }

  private hidden(id: string): boolean {
    return this.settings.menuHidden.indexOf(id) >= 0
  }

  private homePageGuard(): void {
    this.onClose()
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.no_page_open'), duration: 1500 })
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
