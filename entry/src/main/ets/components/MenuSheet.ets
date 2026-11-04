import { i18n } from '@kit.LocalizationKit'
﻿import { common, Want } from '@kit.AbilityKit'
import { print, BusinessError } from '@kit.BasicServicesKit'
import { productViewManager } from '@kit.AppGalleryKit'
import { fileIo } from '@kit.CoreFileKit'
import { webview } from '@kit.ArkWeb'
import { scanBarcode } from '@kit.ScanKit'
import { http } from '@kit.NetworkKit'
import { window } from '@kit.ArkUI'
import { AppSettings, applyOrientationSetting, UA_MODE_DEFAULT } from '../common/Settings'
import { TabStore } from '../common/TabStore'
import { BrowserDb } from '../common/Database'
import { hostOf, buildSearchUrl, isUrlLike, normalizeUrl } from '../common/SearchEngines'
import { SiteSetting } from '../common/Types'
import { RemoteConfig } from '../common/RemoteConfig'
import { scriptPatternMatches } from '../common/ScriptMatch'
import { isMenuId, MENU_DEFAULT_ORDER, menuIcon, menuLabel, menuSkinIconName } from '../common/MenuItems'
import { CustomUaEntry } from '../common/UaTable'
import { ViaIcon } from './ViaIcon'
import { ZoomSlider } from './ZoomSlider'
import { computeDialogWidthVp } from './ViaDialogCard'
import { UiInsets, applyStatusBarVisible } from '../common/Immersive'
import { dialogTransition, menuTransition, dimTransition } from '../common/Transitions'

export const TRANSLATE_INJECT_JS: string = `(function(){if(window.__via_translator__){window.__via_translator__.showBanner(true);return;}`
  + `window.googleTranslateElementInit=function(){if(!window.__via_translator__){window.__via_translator__=new google.translate.TranslateElement({autoDisplay:false,floatPosition:0,multilanguagePage:true,includedLanguages:"af,sq,am,ar,hy,az,eu,be,bn,bs,bg,ca,ceb,ny,zh-CN,zh-TW,co,hr,cs,da,nl,en,eo,et,tl,fi,fr,fy,gl,ka,de,el,gu,ht,ha,haw,he,hi,hmn,hu,is,id,ga,it,ja,jv,kn,kk,km,ky,ko,ku,lo,la,lv,lt,lb,mk,mg,ms,ml,mt,mi,mr,mn,my,ne,no,ps,fa,pl,pt,pa,ro,ru,sr,st,sd,si,sk,sl,so,sm,es,su,sw,sv,tg,ta,te,th,tr,uk,ur,uz,vi,cy,xh,yi,yo,zu",pageLanguage:"auto"});}`
  + `window.__via_translator__.showBanner(true);};`
  + `var s=document.createElement("script");s.src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit";document.getElementsByTagName("head")[0].appendChild(s);`
  + `document.addEventListener("securitypolicyviolation",function onCsp(e){document.removeEventListener("securitypolicyviolation",onCsp);`
  + `var id="via-translate-bridge";var t=document.getElementById(id);`
  + `if(t){if(typeof translate!=="undefined"){if("zh-CN"!==translate.to){translate.changeLanguage("zh-CN");}}else{var n=document.createElement("script");n.id=id;n.src=t.src;n.onload=t.onload;t.parentNode.replaceChild(n,t);}}`
  + `else{t=document.createElement("script");t.id=id;t.src="https://fastly.jsdelivr.net/gh/xnx3/translate@v3.14.0/translate.js/translate.min.js";`
  + `t.onload=function(){translate.selectLanguageTag.show=false;translate.service.use("client.edge");translate.changeLanguage("zh-CN");};document.head.appendChild(t);}});})();`

// 「浏览器标识」弹窗选项：文案与原版录屏逐字一致
class UaChoice {
  key: string
  label: string

  constructor(key: string, label: string) {
    this.key = key
    this.label = label
  }
}

const UA_CHOICES: UaChoice[] = [
  new UaChoice('default', '默认'),
  new UaChoice('android_phone', 'Android (手机)'),
  new UaChoice('android_tablet', 'Android (平板)'),
  new UaChoice('win_chrome', 'Windows (Chrome)'),
  new UaChoice('win_ie11', 'Windows (IE 11)'),
  new UaChoice('mac', 'macOS'),
  new UaChoice('iphone', 'iPhone'),
  new UaChoice('ipad', 'iPad'),
  new UaChoice('symbian', '塞班 (Symbian)')
]

// 原版 z8/h0.e + cleardata2：清除数据 7 项（显示顺序与 array c 一致）
const CLEAR_DATA_ITEMS: string[] = [
  '缓存',
  '表单数据',
  '历史',
  '关闭的标签页',
  '网页存储',
  'Cookies (登录状态)',
  '应用缓存'
]
// 各项对应 cleardata2 位：缓存1|表单2|历史4|关闭的标签页64|网页存储8|Cookies16|应用缓存32
const CLEAR_DATA_BITS: number[] = [1, 2, 4, 64, 8, 16, 32]

// 原版 h2.java：举报网站上报接口与鉴权（Bearer Token 与 7.4.0 抓包一致）
const REPORT_ENDPOINT: string = 'https://ra.viayoo.com/report_abuse'
const REPORT_TOKEN: string = 'Bearer tk_o4s4ghe1tqu60mj0ljy5im762ebrr'

// 原版 C9「标记广告」：注入元素选择器，点击广告元素后经 console 通道
// （TabWeb.onConsole）回传资源域名，加入自定义拦截规则并刷新
const MARK_AD_INJECT_JS: string = `(function(){if(window.__via_mark_ad__){return;}`
  + `window.__via_mark_ad__=true;var prev=null;`
  + `function host(u){try{var h=new URL(u,location.href).hostname;return h&&h!==location.hostname?h:'';}catch(e){return '';}}`
  + `function findUrl(el){var c=[el.getAttribute('src'),el.getAttribute('data-src'),el.getAttribute('href')];`
  + `var bg=getComputedStyle(el).backgroundImage;if(bg&&bg.indexOf('url(')>=0){c.push(bg.replace(/^.*url\\(["']?/,'').replace(/["']?\\).*$/,''));}`
  + `var img=el.querySelector('img[src],img[data-src]');if(img){c.push(img.getAttribute('src'));c.push(img.getAttribute('data-src'));}`
  + `for(var i=0;i<c.length;i++){if(c[i]){var h=host(c[i]);if(h){return h;}}}return '';}`
  + `document.addEventListener('click',function(e){e.preventDefault();e.stopPropagation();`
  + `if(prev){prev.style.outline='';}prev=e.target;prev.style.outline='2px solid #f00';`
  + `var h=findUrl(prev);if(h){console.log('via_mark_ad:'+h);}},true);})();`

@ComponentV2
export struct MenuSheet {
  @Event onClose: () => void = () => {}
  @Event onOpenPage: (page: string) => void = (page: string) => {}
  @Event onFindInPage: () => void = () => {}
  @Event onShare: () => void = () => {}
  @Event onSavePage: () => void = () => {}
  @Event onOpenAi: () => void = () => {}
  @Event onOpenReader: () => void = () => {}

  @Event onReadAloud: () => void = () => {}
  private settings: AppSettings = AppSettings.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  @Local pageIndex: number = 0
  @Local showUaDialog: boolean = false
  @Local showClearDataDialog: boolean = false
  // 默认 cleardata2=7（缓存|表单数据|历史），aboutToAppear 按 settings.clearData2 重算
  @Local clearDataSelection: boolean[] = [true, true, true, false, false, false, false]
  @Local showImageModeDialog: boolean = false
  @Local showReportDialog: boolean = false
  @Local showOrientationDialog: boolean = false
  @Local showAddHomeFavDialog: boolean = false
  @Local reportFlag1: boolean = false
  @Local reportFlag2: boolean = false
  @Local reportFlag3: boolean = false
  @Local reportRemarks: string = ''
  @Local addHomeFavTitle: string = ''
  @Local addHomeFavUrl: string = ''
  @Local orientationIndex: number = 0
  // 原版 i8/k:363-368：已收藏时「添加书签」条目文案变「已添加」
  @Local bookmarkUrls: string[] = []
  // 原版 i8/k x3 id40：已收藏时「添加主页收藏」文案变「已添加」
  @Local homeFavUrls: string[] = []
  // 统一翻页式菜单（工具箱即往后翻一页），由 SwiperController 驱动点击翻页
  private swiperController: SwiperController = new SwiperController()
  private insets: UiInsets = UiInsets.getInstance()

  aboutToAppear(): void {
    BrowserDb.getInstance().listBookmarks().then((items) => {
      const urls: string[] = []
      for (const item of items) {
        urls.push(item.url)
      }
      this.bookmarkUrls = urls
    })
    BrowserDb.getInstance().listHomeFavs().then((items) => {
      const urls: string[] = []
      for (const item of items) {
        urls.push(item.url)
      }
      this.homeFavUrls = urls
    })
    // 原版 cleardata2（w9/k e2）持久化上次清除数据勾选
    const selection: boolean[] = []
    for (let i = 0; i < CLEAR_DATA_BITS.length; i++) {
      selection.push((this.settings.clearData2 & CLEAR_DATA_BITS[i]) !== 0)
    }
    this.clearDataSelection = selection
  }

  build() {
    Stack({ alignContent: Alignment.Bottom }) {
      Column()
        .width('100%')
        .height('100%')
        .backgroundColor('rgba(0,0,0,0.2)')
        .transition(dimTransition(160))
        .onClick(() => {
          this.onClose()
        })

      Column() {
        this.MainPager()
        this.DotsBar()
        this.BottomRow()
      }
      .width('100%')
      .margin({
        left: 12,
        right: 12,
        bottom: this.insets.bottom > 0 ? this.insets.bottom + 8 : 16
      })
      .borderRadius(24)
      .clip(true)
      .padding({ top: 8, bottom: 6 })
      .backgroundColor($r('app.color.menu_bg'))
      .shadow({ radius: 24, color: 'rgba(0,0,0,0.4)', offsetY: 4 })
      .transition(menuTransition())

      if (this.showUaDialog) {
        this.UaDialog()
      }
      if (this.showFontDialog) {
        this.FontSizeDialog()
      }
      if (this.showClearDataDialog) {
        this.ClearDataDialog()
      }
      if (this.showImageModeDialog) {
        this.ImageModeDialog()
      }
      if (this.showReportDialog) {
        this.ReportDialog()
      }
      if (this.showOrientationDialog) {
        this.OrientationDialog()
      }
      if (this.showAddHomeFavDialog) {
        this.AddHomeFavDialog()
      }
    }
    .width('100%')
    .height('100%')
  }

  // 「浏览器标识」居中弹窗：视频同款标题 + 单选列表
  @Builder
  UaDialog() {
    Stack({ alignContent: Alignment.Center }) {
      Column() {
        Text($r('app.string.browser_ua'))
          .fontSize(17)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.fg'))
          .width('100%')
          .padding({ left: 20, top: 18, bottom: 8 })
        Scroll() {
          Column() {
            ForEach(UA_CHOICES, (choice: UaChoice) => {
              Row({ space: 14 }) {
                Circle({ width: 18, height: 18 })
                  .fill(this.settings.uaKey === choice.key ? '#4C6FFF' : Color.Transparent)
                  .stroke(this.settings.uaKey === choice.key ? '#4C6FFF' : '#8A8A8E')
                  .strokeWidth(1.5)
                Text(choice.label)
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
              }
              .width('100%')
              .height(44)
              .padding({ left: 20, right: 20 })
              .onClick(() => {
                this.applyUaChoice(choice.key)
              })
            }, (choice: UaChoice) => choice.key)
            // 原版 z8.b4.e：固定 9 项后追加用户自定义 UA 列表（z8/b4.java:94-98）
            ForEach(this.settings.customUaList, (entry: CustomUaEntry) => {
              Row({ space: 14 }) {
                Circle({ width: 18, height: 18 })
                  .fill(this.settings.uaKey === 'custom' && this.settings.customUa === entry.ua
                    ? '#4C6FFF' : Color.Transparent)
                  .stroke(this.settings.uaKey === 'custom' && this.settings.customUa === entry.ua
                    ? '#4C6FFF' : '#8A8A8E')
                  .strokeWidth(1.5)
                Text(entry.title)
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
              }
              .width('100%')
              .height(44)
              .padding({ left: 20, right: 20 })
              .onClick(() => {
                this.settings.setCustomUa(entry.ua)
                this.applyUaChoice('custom')
              })
            }, (entry: CustomUaEntry) => entry.title + entry.ua)
          }
          .width('100%')
        }
        .width('100%')
        .padding({ bottom: 12 })
      }
      .width('82%')
      .constraintSize({ maxHeight: '70%' })
      .borderRadius(20)
      .backgroundColor($r('app.color.menu_bg'))
      .shadow({ radius: 24, color: 'rgba(0,0,0,0.5)', offsetY: 4 })
      .transition(dialogTransition())
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.2)')
    .transition(dimTransition(240))
    .onClick(() => {
      this.showUaDialog = false
    })
  }

  // 菜单条目顺序：定制菜单页写入的 settings.menuOrder 为主序，
  // 旧数据/新增条目按 MENU_DEFAULT_ORDER 补齐；隐藏条目（menuHidden）不渲染
  private mainItemIds(): string[] {
    const ids: string[] = []
    for (const id of this.settings.menuOrder) {
      if (isMenuId(id) && !this.hidden(id) && ids.indexOf(id) < 0) {
        ids.push(id)
      }
    }
    for (const id of MENU_DEFAULT_ORDER) {
      if (ids.indexOf(id) < 0 && !this.hidden(id)) {
        ids.push(id)
      }
    }
    return ids
  }

  @Builder
  MainPager() {
    Swiper(this.swiperController) {
      ForEach(this.chunk(this.mainItemIds(), 10), (page: string[]) => {
        Grid() {
          ForEach(page, (id: string) => {
            GridItem() {
              this.MainCell(id)
            }
          }, (id: string) => id)
        }
        .columnsTemplate('1fr 1fr 1fr 1fr 1fr')
        .rowsTemplate(this.mainItemIds().length > 5 ? '1fr 1fr' : '1fr')
        .rowsGap(6)
        .width('100%')
        .height(174)
      }, (page: string[], index: number) => `page_${index}_${page.length}`)
    }
    .loop(false)
    .indicator(false)
    .onChange((index: number) => {
      this.pageIndex = index
    })
  }

  // 视频同款：每页 5 列 × 2 行（10 个条目），工具箱页即下一页
  private chunk(list: string[], size: number): string[][] {
    const pages: string[][] = []
    for (let i = 0; i < list.length; i += size) {
      pages.push(list.slice(i, i + size))
    }
    return pages
  }

  @Builder
  MainCell(id: string) {
    // 图标与文案统一走 MenuItems 映射；.save 需在家页禁用走区分分支
    if (id === 'save') {
      // 原版 i8/k:380-383：file:// 页禁用保存
      this.GridCellBody($r('app.media.via_menu_save'), $r('app.string.save'), this.saveEnabled(), () => {
        this.onClose()
        this.onSavePage()
      }, () => {
      }, $r('app.color.menu_icon'), null, null, '', 'ic_menu_save')
    } else if (id === 'night_mode') {
      // 点击切换夜间模式，长按进夜间模式设置页（原版 O9 case1 / P9 case1）。
      // 原版 h8/c 绑定：可见文字用 d()（纯标题「夜间模式」），「已开启/已关闭」只进 contentDescription；
      // 激活时（f()）图标与文字染强调色（x8/h.j → colorPrimary #6f8de1/#617ac1）
      this.GridCellBody(menuIcon(id), menuLabel(id), true, () => {
        this.menuAction(id)
      }, () => {
        this.onClose()
        this.onOpenPage('settingsNight')
      }, this.settings.isNightActive() ? $r('app.color.accent') : $r('app.color.menu_icon'),
      null, this.settings.isNightActive() ? $r('app.color.accent') : null,
      this.nightAccessibilityText(), menuSkinIconName(id))
    } else if (id === 'image_mode') {
      // 原版 id=17：点击循环切换三态，标签随状态切换（i8/k.java:398-404）；
      // 无图/仅 Wi-Fi 态染强调色（x3 aVarV310.j(z13)）
      this.GridCellBody(menuIcon(id), this.imageModeLabel(), true, () => {
        this.cycleImageMode()
      }, () => {
      }, this.settings.noImage || this.settings.wifiOnlyImages ? $r('app.color.accent') : $r('app.color.menu_icon'),
      null, null, '', menuSkinIconName(id))
    } else if (id === 'add_bookmark' && this.bookmarkUrls.indexOf(this.tabStore.current().url) >= 0) {
      // 原版 i8/k:363-368：已收藏时条目文案变「已添加」（x7.u.A1）并染强调色
      this.GridCellBody(menuIcon(id), $r('app.string.bookmark_added_state'), true, () => {
      }, () => {
      }, $r('app.color.accent'), null, null, '', menuSkinIconName(id))
    } else if (id === 'add_home_fav' && this.homeFavUrls.indexOf(this.tabStore.current().url) >= 0) {
      // 原版 i8/k x3 id40：已收藏时文案变「已添加」（x7.u.f14060l5）并染强调色
      this.GridCellBody(menuIcon(id), $r('app.string.bookmark_added_state'), true, () => {
      }, () => {
      }, $r('app.color.accent'), null, null, '', menuSkinIconName(id))
    } else if (id === 'script') {
      // 原版 i8/k x3 id27（i8/k:419-423）：文案随勾选态变「脚本 已开启/已关闭」
      // （a1(lr/lq, uc)）并染强调色；勾选 = i0.s(url) && m2().D() && !wls(url) && p5.C(url)
      this.GridCellBody(menuIcon(id), menuLabel(id), true, () => {
        this.scriptMenuAction()
      }, () => {
        this.menuLongPress(id)
      }, this.scriptMenuChecked() ? $r('app.color.accent') : $r('app.color.menu_icon'),
      this.scriptMenuChecked() ? '脚本 已开启' : '脚本 已关闭', null, '', menuSkinIconName(id))
    } else {
      // 原版 i8/k x3：开启态条目染强调色（电脑模式/全屏/浏览器标识/字体大小/广告拦截/游戏模式/隐身）
      this.GridCellBody(menuIcon(id), menuLabel(id), true, () => {
        this.menuAction(id)
      }, () => {
        this.menuLongPress(id)
      }, this.menuItemColor(id), null, null, '', menuSkinIconName(id))
    }
  }

  // 原版 x8/h.j：条目激活态染 colorPrimary（#6f8de1/#617ac1）
  private menuItemColor(id: string): ResourceColor {
    const tab = this.tabStore.current()
    let active = false
    switch (id) {
      case 'incognito':
        active = this.tabStore.sessionIncognito
        break
      case 'pc_mode':
        active = (this.settings.getSiteSetting(hostOf(tab.url)) ?? new SiteSetting('')).pcMode
        break
      case 'fullscreen':
        active = this.settings.fullScreen
        break
      case 'ua':
        active = this.settings.uaMode !== UA_MODE_DEFAULT || this.settings.uaKey !== 'default'
        break
      case 'font_size':
        active = this.settings.textZoom !== 100
        break
      case 'adblock':
        active = this.settings.adBlockOn
        break
      case 'game_mode':
        active = this.settings.gameMode
        break
      default:
        active = false
        break
    }
    return active ? $r('app.color.accent') : $r('app.color.menu_icon')
  }

  // 原版 k6.P9：长按直达对应设置页（O9/P9 由 X5 按 flags 分发）
  private menuLongPress(id: string): void {
    switch (id) {
      case 'settings':
        this.onClose()
        this.onOpenPage('menuCustom')
        break
      case 'ua':
        this.onClose()
        this.onOpenPage('uaPage')
        break
      case 'adblock':
        this.onClose()
        this.onOpenPage('settingsAdBlock')
        break
      case 'font_size':
        this.onClose()
        this.onOpenPage('fontSettings')
        break
      case 'site_settings':
        this.onClose()
        this.onOpenPage('siteSettings')
        break
      case 'reading_mode':
        this.onClose()
        this.onOpenPage('settingsReader')
        break
      case 'ai':
        this.onClose()
        this.onOpenPage('aiSettings')
        break
      // 原版 k6.P9 case7 → Wa() → Xa：长按「添加书签」= 添加到桌面
      case 'add_bookmark':
        this.addToDesktop()
        break
      default:
        break
    }
  }

  // ===== 原版 k6 O9 case27「脚本」（k6:5259-5281），ua.y「网页脚本」页由 view/WebScriptsPage 承载 =====

  // k6:5261-5264 z = i0.s(url) && !r9.g.a().e(url)（wls 豁免）&& lc.c().d().C(url)
  private scriptWouldRun(): boolean {
    const url = this.tabStore.current().url
    if (!(url.startsWith('http://') || url.startsWith('https://'))) {
      return false
    }
    if (RemoteConfig.getInstance().isInWls(url)) {
      return false
    }
    return scriptPatternMatches(url, this.settings.userScripts)
  }

  // i8/k:421 勾选态 = z && m2().D()（w9/p.D() = !bit268435456，脚本已启用）
  private scriptMenuChecked(): boolean {
    return this.settings.scriptEnabled && this.scriptWouldRun()
  }

  private scriptMenuAction(): void {
    const wouldRun = this.scriptWouldRun()
    if (!this.settings.scriptEnabled) {
      // k6:5265-5273：i0(true) 开启脚本并持久化（g0），z 时 wa() 重载当前页并收起菜单；toast Jb「脚本已启用」
      this.settings.setScriptEnabled(true)
      if (wouldRun) {
        this.onClose()
        try {
          this.tabStore.current().controller.refresh()
        } catch (error) {
          console.error('refresh after script enable failed')
        }
      }
      this.getUIContext().getPromptAction().showToast({ message: '脚本已启用', duration: 1500 })
      return
    }
    if (!wouldRun) {
      // k6:5274-5276：g6.i.g(sa.d1) → 脚本管理页
      this.onOpenPage('userScripts')
      return
    }
    // k6:5277-5280：d9() 收起菜单 + yb(url) → ua.y「网页脚本」页（该网址匹配脚本 + GM 菜单命令）
    this.onOpenPage('webScripts')
  }

  // 原版 i8/k:380-383：file:// 页禁用保存
  private saveEnabled(): boolean {
    const tab = this.tabStore.current()
    return !tab.isHomePage() && !tab.url.startsWith('file://')
  }

  // 原版三态标签：有图模式/无图模式/仅 Wi-Fi 有图
  private imageModeLabel(): Resource {
    const index = this.imageModeIndex()
    if (index === 1) {
      return $r('app.string.no_image_mode')
    }
    if (index === 2) {
      return $r('app.string.image_mode_wifi')
    }
    return $r('app.string.image_mode')
  }

  // 原版点击循环：有图→无图→仅Wi-Fi→有图
  private cycleImageMode(): void {
    const next = (this.imageModeIndex() + 1) % 3
    if (next === 2) {
      this.settings.setWifiOnlyImages(true)
      this.settings.setNoImage(false)
    } else if (next === 1) {
      this.settings.setWifiOnlyImages(false)
      this.settings.setNoImage(true)
    } else {
      this.settings.setWifiOnlyImages(false)
      this.settings.setNoImage(false)
    }
  }

  // 原版 k6.qb(false, 0)：菜单「字体大小」点击快捷弹窗。
  // 无标题无按钮，仅外点取消（X3：z10=false 时无操作）。
  // 内容 = 预览 "%d%%"（p5：16sp、居中、fg、上下 margin 16）+
  // w0 滑条（g5：max 30、progress=(当前-50)/5、highlight：站点模式取全局否则 100、
  // 步进 5、padH16、marginBottom16）+ 站点模式下提示「仅对当前网站生效」
  // （f6：12sp、居中、fg_secondary、margin 上 2 下 8）
  @Local showFontDialog: boolean = false
  private fontSiteMode: boolean = false
  private fontHost: string = ''
  @Local fontDialogZoom: number = 100
  private fontHighlight: number = 100

  private openFontDialog(): void {
    const tab = this.tabStore.current()
    const host = tab.url.startsWith('http') ? hostOf(tab.url) : ''
    const siteZoom = host !== '' ? this.settings.getSiteFontZoom(host) : 0
    const siteMode = siteZoom > 0
    this.fontSiteMode = siteMode
    this.fontHost = host
    this.fontDialogZoom = siteMode ? siteZoom : this.settings.textZoom
    this.fontHighlight = siteMode ? this.settings.textZoom : 100
    this.showFontDialog = true
  }

  // 原版 k6.g.onProgressChanged：仅当当前页为网页时实时 setTextZoom
  private applyFontPreview(zoom: number): void {
    const tab = this.tabStore.current()
    if (tab.url.startsWith('http')) {
      tab.liveZoom = zoom
    }
  }

  // 原版 k6.g.onStopTrackingTouch：站点模式 Q1(host) 否则 J() 全局
  private commitFontZoom(zoom: number): void {
    if (this.fontSiteMode && this.fontHost !== '') {
      this.settings.setSiteFontZoom(this.fontHost, zoom)
    } else {
      this.settings.setTextZoom(zoom)
    }
    this.tabStore.current().liveZoom = 0
  }

  @Builder
  FontSizeDialog() {
    Stack({ alignContent: Alignment.Center }) {
      Column() {
        Text(`${this.fontDialogZoom}%`)
          .fontSize(16)
          .fontColor($r('app.color.fg'))
          .width('100%')
          .textAlign(TextAlign.Center)
          .margin({ top: 16, bottom: 16 })
        ZoomSlider({
          zoom: this.fontDialogZoom,
          highlightZoom: this.fontHighlight,
          onZoomChange: (zoom: number): void => {
            this.fontDialogZoom = zoom
            this.applyFontPreview(zoom)
          },
          onZoomEnd: (zoom: number): void => {
            this.commitFontZoom(zoom)
          }
        })
          .margin({ left: 16, right: 16, bottom: 16 })
        if (this.fontSiteMode) {
          Text('仅对当前网站生效')
            .fontSize(12)
            .fontColor($r('app.color.fg_secondary'))
            .width('100%')
            .textAlign(TextAlign.Center)
            .margin({ top: 2, bottom: 8 })
        }
      }
      .width(computeDialogWidthVp())
      .padding({ top: 12, bottom: 12 })
      .backgroundColor($r('app.color.dialog_bg'))
      .borderRadius(18)
      .border({ width: 1, color: $r('app.color.dialog_border') })
      .transition(dialogTransition())
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.4)')
    .transition(dimTransition(240))
    .onClick(() => {
      this.showFontDialog = false
    })
  }

  // 清除数据弹窗：条目与设置-通用-清除数据完全一致
  @Builder
  ClearDataDialog() {
    Stack({ alignContent: Alignment.Center }) {
      Column({ space: 10 }) {
        Text($r('app.string.clear_data'))
          .fontSize(17)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
          .width('100%')
        ForEach(CLEAR_DATA_ITEMS, (label: string, index: number) => {
          Row({ space: 14 }) {
            Circle({ width: 20, height: 20 })
              .fill(this.clearDataSelection[index] ? $r('app.color.accent') : Color.Transparent)
              .stroke(this.clearDataSelection[index] ? $r('app.color.accent') : $r('app.color.fg_secondary'))
              .strokeWidth(1.5)
            Text(label)
              .fontSize(15)
              .fontColor($r('app.color.fg'))
          }
          .width('100%')
          .height(42)
          .onClick(() => {
            this.clearDataSelection[index] = !this.clearDataSelection[index]
          })
        }, (label: string) => label)
        Row({ space: 24 }) {
          Blank()
          Text($r('app.string.cancel'))
            .fontSize(15)
            .fontColor($r('app.color.fg_secondary'))
            .padding({ left: 8, right: 8, top: 10, bottom: 10 })
            .onClick(() => {
              this.showClearDataDialog = false
            })
          Text($r('app.string.confirm'))
            .fontSize(15)
            .fontWeight(FontWeight.Medium)
            .fontColor($r('app.color.accent'))
            .padding({ left: 8, right: 8, top: 10, bottom: 10 })
            .onClick(() => {
              this.applyClearData()
              this.showClearDataDialog = false
            })
        }
        .width('100%')
        .margin({ top: 6 })
      }
      .width('80%')
      .padding(24)
      .borderRadius(20)
      .backgroundColor($r('app.color.menu_bg'))
      .shadow({ radius: 24, color: 'rgba(0,0,0,0.5)', offsetY: 4 })
      .transition(dialogTransition())
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.2)')
    .transition(dimTransition(240))
    .onClick(() => {
      this.showClearDataDialog = false
    })
  }

  // 原版图片模式三选一：初始 r()?2:q()?0:1（wifiOnly→2，无图→1，有图→0）
  private imageModeIndex(): number {
    if (this.settings.wifiOnlyImages) {
      return 2
    }
    if (this.settings.noImage) {
      return 1
    }
    return 0
  }

  @Builder
  ImageModeDialog() {
    Stack({ alignContent: Alignment.Center }) {
      Column() {
        Text($r('app.string.image_mode'))
          .fontSize(17)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.fg'))
          .width('100%')
          .padding({ left: 20, top: 18, bottom: 8 })
        Column() {
          this.ImageModeRow(0, $r('app.string.image_mode'))
          this.ImageModeRow(1, $r('app.string.image_mode_block'))
          this.ImageModeRow(2, $r('app.string.image_mode_wifi'))
        }
        .width('100%')
        .padding({ bottom: 12 })
      }
      .width('82%')
      .constraintSize({ maxHeight: '70%' })
      .borderRadius(20)
      .backgroundColor($r('app.color.menu_bg'))
      .shadow({ radius: 24, color: 'rgba(0,0,0,0.5)', offsetY: 4 })
      .transition(dialogTransition())
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.2)')
    .transition(dimTransition(240))
    .onClick(() => {
      this.showImageModeDialog = false
    })
  }

  @Builder
  ImageModeRow(index: number, label: Resource) {
    Row({ space: 14 }) {
      Circle({ width: 18, height: 18 })
        .fill(this.imageModeIndex() === index ? '#4C6FFF' : Color.Transparent)
        .stroke(this.imageModeIndex() === index ? '#4C6FFF' : '#8A8A8E')
        .strokeWidth(1.5)
      Text(label)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
    }
    .width('100%')
    .height(44)
    .padding({ left: 20, right: 20 })
    .onClick(() => {
      this.applyImageMode(index)
    })
  }

  // 原版举报网站弹窗：三复选（位 1/2/4）+ 备注，确认后 POST 上报
  @Builder
  ReportDialog() {
    Stack({ alignContent: Alignment.Center }) {
      Column({ space: 10 }) {
        Text($r('app.string.report_site'))
          .fontSize(17)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
          .width('100%')
        this.ReportCheckRow($r('app.string.report_reason_distracting'), this.reportFlag1, (checked: boolean) => {
          this.reportFlag1 = checked
        })
        this.ReportCheckRow($r('app.string.report_reason_dangerous'), this.reportFlag2, (checked: boolean) => {
          this.reportFlag2 = checked
        })
        this.ReportCheckRow($r('app.string.report_reason_broken'), this.reportFlag3, (checked: boolean) => {
          this.reportFlag3 = checked
        })
        TextInput({ text: this.reportRemarks, placeholder: $r('app.string.report_remarks_hint') })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.fg_secondary'))
          .backgroundColor($r('app.color.surface'))
          .width('100%')
          .onChange((value: string) => {
            this.reportRemarks = value
          })
        Row({ space: 24 }) {
          Blank()
          Text($r('app.string.cancel'))
            .fontSize(15)
            .fontColor($r('app.color.fg_secondary'))
            .padding({ left: 8, right: 8, top: 10, bottom: 10 })
            .onClick(() => {
              this.showReportDialog = false
            })
          Text($r('app.string.confirm'))
            .fontSize(15)
            .fontWeight(FontWeight.Medium)
            .fontColor($r('app.color.accent'))
            .padding({ left: 8, right: 8, top: 10, bottom: 10 })
            .onClick(() => {
              this.submitReport()
            })
        }
        .width('100%')
        .margin({ top: 6 })
      }
      .width('80%')
      .padding(24)
      .borderRadius(20)
      .backgroundColor($r('app.color.menu_bg'))
      .shadow({ radius: 24, color: 'rgba(0,0,0,0.5)', offsetY: 4 })
      .transition(dialogTransition())
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.2)')
    .transition(dimTransition(240))
    .onClick(() => {
      this.showReportDialog = false
    })
  }

  @Builder
  ReportCheckRow(label: Resource, checked: boolean, onToggle: (checked: boolean) => void) {
    Row({ space: 14 }) {
      Circle({ width: 20, height: 20 })
        .fill(checked ? $r('app.color.accent') : Color.Transparent)
        .stroke(checked ? $r('app.color.accent') : $r('app.color.fg_secondary'))
        .strokeWidth(1.5)
      Text(label)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
    }
    .width('100%')
    .height(42)
    .onClick(() => {
      onToggle(!checked)
    })
  }

  // 原版屏幕方向四选一：跟随系统/自动/竖屏/横屏
  @Builder
  OrientationDialog() {
    Stack({ alignContent: Alignment.Center }) {
      Column() {
        Text($r('app.string.screen_orientation'))
          .fontSize(17)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.fg'))
          .width('100%')
          .padding({ left: 20, top: 18, bottom: 8 })
        Column() {
          this.OrientationRow(0, $r('app.string.orientation_system'))
          this.OrientationRow(1, $r('app.string.orientation_auto'))
          this.OrientationRow(2, $r('app.string.orientation_portrait'))
          this.OrientationRow(3, $r('app.string.orientation_landscape'))
        }
        .width('100%')
        .padding({ bottom: 12 })
      }
      .width('82%')
      .constraintSize({ maxHeight: '70%' })
      .borderRadius(20)
      .backgroundColor($r('app.color.menu_bg'))
      .shadow({ radius: 24, color: 'rgba(0,0,0,0.5)', offsetY: 4 })
      .transition(dialogTransition())
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.2)')
    .transition(dimTransition(240))
    .onClick(() => {
      this.showOrientationDialog = false
    })
  }

  @Builder
  OrientationRow(index: number, label: Resource) {
    Row({ space: 14 }) {
      Circle({ width: 18, height: 18 })
        .fill(this.orientationIndex === index ? '#4C6FFF' : Color.Transparent)
        .stroke(this.orientationIndex === index ? '#4C6FFF' : '#8A8A8E')
        .strokeWidth(1.5)
      Text(label)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
    }
    .width('100%')
    .height(44)
    .padding({ left: 20, right: 20 })
    .onClick(() => {
      this.applyOrientationChoice(index)
    })
  }

  // 原版 x8 添加主页收藏：标题/网址可编辑，确认后写入书签
  @Builder
  AddHomeFavDialog() {
    Stack({ alignContent: Alignment.Center }) {
      Column({ space: 12 }) {
        Text($r('app.string.add_home_fav'))
          .fontSize(17)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
          .width('100%')
        Text('标题')
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .width('100%')
        TextInput({ text: this.addHomeFavTitle })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .backgroundColor($r('app.color.surface'))
          .width('100%')
          .onChange((value: string) => {
            this.addHomeFavTitle = value
          })
        Text('网址')
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .width('100%')
        TextInput({ text: this.addHomeFavUrl })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .backgroundColor($r('app.color.surface'))
          .width('100%')
          .onChange((value: string) => {
            this.addHomeFavUrl = value
          })
        Row({ space: 24 }) {
          Blank()
          Text($r('app.string.cancel'))
            .fontSize(15)
            .fontColor($r('app.color.fg_secondary'))
            .padding({ left: 8, right: 8, top: 10, bottom: 10 })
            .onClick(() => {
              this.showAddHomeFavDialog = false
            })
          Text($r('app.string.confirm'))
            .fontSize(15)
            .fontWeight(FontWeight.Medium)
            .fontColor($r('app.color.accent'))
            .padding({ left: 8, right: 8, top: 10, bottom: 10 })
            .onClick(() => {
              this.submitAddHomeFav()
            })
        }
        .width('100%')
        .margin({ top: 6 })
      }
      .width('80%')
      .padding(24)
      .borderRadius(20)
      .backgroundColor($r('app.color.menu_bg'))
      .shadow({ radius: 24, color: 'rgba(0,0,0,0.5)', offsetY: 4 })
      .transition(dialogTransition())
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.2)')
    .transition(dimTransition(240))
    .onClick(() => {
      this.showAddHomeFavDialog = false
    })
  }

  // 原版同款：扫码结果按网址/搜索词分流
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
      this.onClose()
    }).catch((error: BusinessError) => {
      console.error(`scan failed: ${error.code}`)
    })
  }

  private applyClearData(): void {
    const selected = this.clearDataSelection
    // 缓存
    if (selected[0]) {
      try {
        webview.WebviewController.removeAllCache(true)
      } catch (error) {
        console.error('clear web cache failed')
      }
    }
    // 表单数据：ArkWeb 暂无表单自动填充数据清理 API（WebDataBase 仅 HTTP 认证凭据），
    // 该项仅保留原版 UI 与位掩码语义
    // 历史
    if (selected[2]) {
      BrowserDb.getInstance().clearHistory().catch((error: BusinessError) => {
        console.error(`clear history failed: ${error.message}`)
      })
      this.settings.clearSearchHistory()
    }
    // 关闭的标签页
    if (selected[3]) {
      AppStorage.setOrCreate('via_undo_close_url', '')
    }
    // 网页存储
    if (selected[4]) {
      try {
        webview.WebStorage.deleteAllData()
      } catch (error) {
        console.error('clear web storage failed')
      }
    }
    // Cookies (登录状态)
    if (selected[5]) {
      webview.WebCookieManager.clearAllCookies().catch((error: BusinessError) => {
        console.error(`clear cookies failed: ${error.message}`)
      })
    }
    // 应用缓存
    if (selected[6]) {
      this.clearAppCache()
    }
    // 原版 l.I0(i10)：确认后持久化本次勾选（cleardata2）
    let flags = 0
    for (let i = 0; i < CLEAR_DATA_BITS.length; i++) {
      if (selected[i]) {
        flags |= CLEAR_DATA_BITS[i]
      }
    }
    this.settings.setClearData2(flags)
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.cleared'), duration: 1500 })
  }

  private clearAppCache(): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    try {
      const cacheDir = context.cacheDir
      const names = fileIo.listFileSync(cacheDir)
      for (let i = 0; i < names.length; i++) {
        const path = `${cacheDir}/${names[i]}`
        try {
          fileIo.rmdirSync(path)
        } catch (error) {
          try {
            fileIo.unlinkSync(path)
          } catch (innerError) {
            console.error(`clear app cache entry failed: ${names[i]}`)
          }
        }
      }
    } catch (error) {
      console.error('clear app cache failed')
    }
  }

  private menuAction(id: string): void {
    switch (id) {
      case 'bookmarks':
        this.onOpenPage('bookmarks')
        break
      case 'history':
        this.onOpenPage('history')
        break
      case 'downloads':
        this.onOpenPage('downloads')
        break
      case 'incognito':
        this.openIncognito()
        break
      case 'share':
        this.onClose()
        this.onShare()
        break
      case 'add_bookmark':
        this.addBookmark()
        break
      // 原版行为：电脑模式切换当前站点桌面版标识（O9 case 8），toast「电脑模式 已开启/已关闭」
      case 'pc_mode':
        this.togglePcMode()
        break
      // 工具箱即往后翻一页（与原版一致：菜单整体翻页，不存在独立的二级面板）
      case 'toolbox':
        this.swiperController.showNext()
        break
      case 'settings':
        this.onOpenPage('settings')
        break
      // 原版 O9 case 1：点击直接切换夜间模式；长按 P9 → 夜间模式设置页
      case 'night_mode':
        this.toggleNightMode()
        break
      case 'customize_menu':
        this.onClose()
        this.onOpenPage('menuCustom')
        break
      case 'refresh_page':
        this.refreshCurrent()
        break
      case 'res_sniffer':
        this.sniffResources()
        break
      case 'find':
        this.onClose()
        this.onFindInPage()
        break
      case 'offline':
        this.onOpenPage('offlinePage')
        break
      case 'translate':
        this.translatePage()
        break
      case 'add_to_desktop':
        this.addToDesktop()
        break
      case 'script':
        this.scriptMenuAction()
        break
      case 'adblock':
        this.onOpenPage('rules')
        break
      case 'ai':
        this.onClose()
        this.onOpenAi()
        break
      case 'print':
        this.printPage()
        break
      case 'netlog':
        this.onOpenPage('netLog')
        break
      case 'ua':
        this.showUaDialog = true
        break
      // 原版行为：菜单内直达当前站点/全局网站设定页
      case 'site_settings':
        this.onOpenPage('siteSettings')
        break
      // 原版行为：抽取正文进入阅读模式
      case 'reading_mode':
        this.onClose()
        this.onOpenReader()
        break
      // 原版行为：直接拉起扫码，结果按网址/搜索词处理
      case 'scan_qr':
        this.startScan()
        break
      // 原版 i8/k z3() flags&1 → k6.O9 case29 → qb(false,0) 快捷滑条弹窗
      case 'font_size':
        this.openFontDialog()
        break
      // 原版行为：弹出与设置页一致的清除数据多选框
      case 'clear_data':
        this.showClearDataDialog = true
        break
      // 原版 na.i2：新标签查看网页源码（SDK<21 同款 outerHTML 方案落盘 file:// 打开）
      case 'view_source':
        this.viewSource()
        break
      // 原版 i3/k6:2806：切换全屏（沉浸系统栏），toast「全屏 已开启/已关闭」
      case 'fullscreen':
        this.toggleFullScreen()
        break
      // 原版 e8/i.java:354：图片三态（有图/无图/仅 Wi-Fi 有图）
      case 'image_mode':
        this.showImageModeDialog = true
        break
      // 原版 C9/k6:3671：注入元素选择器标记广告
      case 'mark_ad':
        this.markAd()
        break
      // 原版 Q7→s3：举报网站（POST ra.viayoo.com）
      case 'report_site':
        this.openReportDialog()
        break
      // 原版 ya/k6:8291：隐式 Want 交由其它应用打开链接
      case 'open_with':
        this.openWith()
        break
      // 原版 bb/k6:6074：游戏模式（隐藏工具栏，双击返回退出）
      case 'game_mode':
        this.toggleGameMode()
        break
      // 原版读取正文朗读
      case 'read_aloud':
        this.readAloud()
        break
      // 原版 f4/k6:2672：屏幕方向四选一，toast「已设置 屏幕方向 为 X」
      case 'screen_orientation':
        this.orientationIndex = Math.max(0, Math.min(3, this.settings.orientation - 1))
        this.showOrientationDialog = true
        break
      // 原版 Q7→x8：添加主页收藏（弹标题/网址编辑框，确认入书签）
      case 'add_home_fav':
        this.openAddHomeFavDialog()
        break
      default:
        // 死分支：39 个菜单 id 均已有 case（save 在 MainCell 单独处理），仅为穷尽兜底
        if (this.tabStore.current().isHomePage()) {
          this.homePageGuard()
        } else {
          this.getUIContext().getPromptAction().showToast({ message: $r('app.string.feature_wip'), duration: 1500 })
        }
        break
    }
  }

  @Builder
  DotsBar() {
    // 原版 m1.java：半径 2dp、间距 4dp、仅一页时不渲染；
    // 选中色 = 主题 accent（attr ab），未选中 = #40808080（color a8）
    if (this.chunk(this.mainItemIds(), 10).length > 1) {
      Row({ space: 4 }) {
        ForEach(this.chunk(this.mainItemIds(), 10), (_: string[], index: number) => {
          Circle({ width: 4, height: 4 })
            .fill(index === this.pageIndex ? $r('app.color.accent') : '#40808080')
        }, (_: string[], index: number) => `dot_${index}`)
      }
      .width('100%')
      .justifyContent(FlexAlign.Center)
      .height(16)
    }
  }

  @Builder
  GridCellBody(icon: Resource, label: Resource, enabled: boolean, action: () => void, longPress: () => void = () => {},
    iconColor: ResourceColor = $r('app.color.menu_icon'), labelOverride: ResourceStr | null = null,
    labelColor: ResourceColor | null = null, accessibilityText: string = '', iconName: string = '') {
    Column({ space: 4 }) {
      ViaIcon({ icon: icon, iconSize: 24, iconColor: iconColor, iconName: iconName })
      Text(labelOverride === null ? label : labelOverride)
        .fontSize(11 * this.settings.textZoom / 100)
        .fontColor(labelColor === null ? $r('app.color.menu_text') : labelColor)
        .maxLines(2)
        .accessibilityText(accessibilityText)
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .alignItems(HorizontalAlign.Center)
    .opacity(enabled ? 1 : 0.35)
    .onClick(() => {
      if (enabled) {
        action()
      }
    })
    .gesture(LongPressGesture().onAction(() => {
      longPress()
    }))  }

  @Builder
  BottomRow() {
    Row() {
      // 原版底部行：Space(weight3) + 退出(weight1) + 关闭(weight1)（i8/k.java:185-200）
      Blank()
        .layoutWeight(3)
      Column() {
        ViaIcon({ icon: $r('app.media.via_ic_exit'), iconSize: 22, iconColor: $r('app.color.menu_icon') })
      }
      .layoutWeight(1)
      .height(38)
      .justifyContent(FlexAlign.Center)
      .alignItems(HorizontalAlign.Center)
      .onClick(() => {
        this.exitApp()
      })

      Column() {
        ViaIcon({ icon: $r('app.media.via_ic_cancel'), iconSize: 22, iconColor: $r('app.color.menu_icon') })
      }
      .layoutWeight(1)
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

  // 选中浏览器标识：与 UaPage 一致仅持久化 uaKey 并刷新页面
  private applyUaChoice(key: string): void {
    this.settings.setUaKey(key)
    this.showUaDialog = false
    try {
      this.tabStore.current().controller.refresh()
    } catch (error) {
      console.error('refresh after ua change failed')
    }
    this.onClose()
  }

  private refreshCurrent(): void {
    if (this.tabStore.current().isHomePage()) {
      this.homePageGuard()
      return
    }
    try {
      this.tabStore.current().controller.refresh()
      this.onClose()
    } catch (error) {
      console.error('refresh failed')
    }
  }

  // 资源嗅探：视频同款空结果提示（页面无资源时的 Snackbar 文案逐字一致）
  private sniffResources(): void {
    if (this.tabStore.current().isHomePage()) {
      this.homePageGuard()
      return
    }
    this.onClose()
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.res_sniffer_empty'), duration: 2500 })
  }

  // 电脑模式：切换当前站点的桌面版标识并刷新（原版 toast「电脑模式 已开启/已关闭」）
  private togglePcMode(): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      this.homePageGuard()
      return
    }
    const host = hostOf(tab.url)
    if (host === '') {
      return
    }
    const site = this.settings.getSiteSetting(host) ?? new SiteSetting(host)
    site.pcMode = !site.pcMode
    this.settings.upsertSiteSetting(site)
    this.getUIContext().getPromptAction().showToast({
      message: `${this.getUIContext().getHostContext()!.resourceManager.getStringSync($r('app.string.pc_mode').id)} ${site.pcMode ? '已开启' : '已关闭'}`,
      duration: 1500
    })
    try {
      tab.controller.refresh()
    } catch (error) {
      console.error('refresh after pc mode toggle failed')
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

  // 原版 k6.cb()：!隐身→A8() 进入；已隐身且标签>1→确认框（关闭/保留）；否则 l8(true) 退出
  private openIncognito(): void {
    this.onClose()
    if (!this.tabStore.sessionIncognito) {
      this.tabStore.sessionIncognito = true
      this.tabStore.newTab(true)
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.entered_incognito'), duration: 1500 })
      return
    }
    const incognitoCount = this.tabStore.incognitoTabCount()
    if (incognitoCount > 1) {
      this.getUIContext().showAlertDialog({
        title: $r('app.string.close_all_tabs_title'),
        message: $r('app.string.exit_incognito_confirm_msg'),
        primaryButton: {
          value: $r('app.string.close_btn'),
          action: () => {
            this.exitIncognito(true)
          }
        },
        secondaryButton: {
          value: $r('app.string.keep_tabs'),
          action: () => {
            this.exitIncognito(false)
          }
        },
        cancel: () => {
        }
      })
      return
    }
    this.exitIncognito(false)
  }

  // 原版 l8(close)：close=关闭全部隐身标签后退出；否则保留标签仅退出会话；toast la「退出隐身浏览」
  private exitIncognito(close: boolean): void {
    this.tabStore.exitIncognitoSession(close)
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.exit_incognito'), duration: 1500 })
  }

  private exitApp(): void {
    this.tabStore.snapshot(this.settings)
    this.settings.persistAdBlockTotal()
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    context.terminateSelf()
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

  // 原版 h8/c 绑定：contentDescription =「夜间模式 已开启/已关闭」（i8/k x3 → a1(lr/lq, ae)）
  private nightAccessibilityText(): string {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return ''
    }
    const id = this.settings.isNightActive() ? $r('app.string.night_label_on').id : $r('app.string.night_label_off').id
    return context.resourceManager.getStringSync(id)
  }

  // 夜间模式：点击切换（原版 O9 case1 → T0/Ib），进入跟随态时 toast「跟随系统暗模式已启用」
  private toggleNightMode(): void {
    this.onClose()
    const follow = this.settings.toggleNightMode()
    if (follow) {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.night_follow_toast'), duration: 1500 })
    }
  }

  // 查看源码：outerHTML 落盘 cache 后新标签 file:// 打开（原版 SDK<21 同款方案）
  private viewSource(): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      this.homePageGuard()
      return
    }
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
            this.onClose()
          } catch (ioError) {
            console.error('write view source failed')
          }
        })
    } catch (error) {
      console.error('runJavaScript view source failed')
    }
  }

  // 全屏：切换沉浸（隐藏状态栏），toast「全屏 已开启/已关闭」
  private toggleFullScreen(): void {
    const next = !this.settings.fullScreen
    this.settings.setFullScreen(next)
    const win = AppStorage.get<window.Window>('mainWindow')
    if (win !== undefined) {
      applyStatusBarVisible(win, !next)
      setTimeout(() => {
        UiInsets.getInstance().refresh(win)
      }, 200)
    }
    this.getUIContext().getPromptAction().showToast({
      message: next ? $r('app.string.fullscreen_toast_on') : $r('app.string.fullscreen_toast_off'),
      duration: 1500
    })
    this.onClose()
  }

  private applyImageMode(index: number): void {
    this.settings.setWifiOnlyImages(index === 2)
    this.settings.setNoImage(index === 1)
    this.showImageModeDialog = false
    try {
      this.tabStore.current().controller.refresh()
    } catch (error) {
      console.error('refresh after image mode change failed')
    }
    this.onClose()
  }

  // 标记广告：非 http(s) 提示（dc），随后注入选择器
  private markAd(): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      this.homePageGuard()
      return
    }
    if (!tab.url.startsWith('http')) {
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.mark_ad_http_only'),
        duration: 1500
      })
      return
    }
    try {
      tab.controller.runJavaScript(MARK_AD_INJECT_JS)
      this.onClose()
    } catch (error) {
      console.error('inject mark ad failed')
    }
  }

  private openReportDialog(): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      this.homePageGuard()
      return
    }
    this.reportFlag1 = false
    this.reportFlag2 = false
    this.reportFlag3 = false
    this.reportRemarks = ''
    this.showReportDialog = true
  }

  // 原版 s3：POST {url, reason(位1/2/4), title?, note?, locale}
  private submitReport(): void {
    const tab = this.tabStore.current()
    let reason = 0
    if (this.reportFlag1) {
      reason = reason | 1
    }
    if (this.reportFlag2) {
      reason = reason | 2
    }
    if (this.reportFlag3) {
      reason = reason | 4
    }
    const body: Record<string, Object> = {
      'url': tab.url,
      'reason': reason,
      'locale': i18n.System.getSystemLanguage()
    }
    if (tab.title !== '') {
      body['title'] = tab.title
    }
    const note = this.reportRemarks.trim()
    if (note !== '') {
      body['note'] = note
    }
    const client = http.createHttp()
    client.request(REPORT_ENDPOINT, {
      method: http.RequestMethod.POST,
      header: {
        'Authorization': REPORT_TOKEN,
        'Content-Type': 'application/json'
      },
      extraData: JSON.stringify(body)
    }).then(() => {
      client.destroy()
      this.showReportDialog = false
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.report_success'), duration: 1500 })
      this.onClose()
    }).catch((error: BusinessError) => {
      client.destroy()
      console.error(`report failed: ${error.code}`)
    })
  }

  // 其它应用打开：隐式 Want，失败 toast p5
  private openWith(): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      this.homePageGuard()
      return
    }
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    const want: Want = {
      action: 'ohos.want.action.viewData',
      uri: tab.url,
      type: 'text/html'
    }
    context.startAbility(want).then(() => {
      this.onClose()
    }).catch((error: BusinessError) => {
      console.error(`open with failed: ${error.code}`)
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.open_with_failed'),
        duration: 1500
      })
    })
  }

  private toggleGameMode(): void {
    const next = !this.settings.gameMode
    this.settings.setGameMode(next)
    this.getUIContext().getPromptAction().showToast({
      message: next ? $r('app.string.game_mode_toast_on') : $r('app.string.game_mode_toast_off'),
      duration: 2000
    })
    this.onClose()
  }

  // 朗读网页：交由主页处理（原版 va()：抽取正文 → j8 朗读管线）
  private readAloud(): void {
    this.onReadAloud()
    this.onClose()
  }

  private applyOrientationChoice(index: number): void {
    this.settings.setOrientation(index + 1)
    const context = this.getUIContext().getHostContext()
    if (context !== undefined) {
      applyOrientationSetting(context)
    }
    this.showOrientationDialog = false
    const labels: Resource[] = [
      $r('app.string.orientation_system'),
      $r('app.string.orientation_auto'),
      $r('app.string.orientation_portrait'),
      $r('app.string.orientation_landscape')
    ]
    const resourceContext = this.getUIContext().getHostContext()
    if (resourceContext !== undefined) {
      const template = resourceContext.resourceManager.getStringSync($r('app.string.orientation_toast').id)
      const label = resourceContext.resourceManager.getStringSync(labels[index].id)
      this.getUIContext().getPromptAction().showToast({ message: template.replace('%s', label), duration: 1500 })
    }
    this.onClose()
  }

  private openAddHomeFavDialog(): void {
    const tab = this.tabStore.current()
    if (tab.isHomePage()) {
      this.homePageGuard()
      return
    }
    this.addHomeFavTitle = tab.title !== '' ? tab.title : hostOf(tab.url)
    this.addHomeFavUrl = tab.url
    this.showAddHomeFavDialog = true
  }

  private submitAddHomeFav(): void {
    const title = this.addHomeFavTitle.trim()
    const url = this.addHomeFavUrl.trim()
    if (title === '' || url === '') {
      return
    }
    const db = BrowserDb.getInstance()
    db.listHomeFavs().then((items) => {
      // 主页收藏为独立表（与书签分开）
      db.addHomeFav(title, url, '', items.length).then(() => {
        this.showAddHomeFavDialog = false
        this.onClose()
        this.getUIContext().getPromptAction().showToast({ message: $r('app.string.home_fav_added'), duration: 1500 })
      })
    }).catch((error: BusinessError) => {
      console.error(`add home fav failed: ${error.message}`)
    })
  }
}
