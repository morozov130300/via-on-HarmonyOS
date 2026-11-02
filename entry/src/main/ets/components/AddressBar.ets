import { TabItem } from '../common/Types'
import { pasteboard, emitter } from '@kit.BasicServicesKit'
import { AppSettings } from '../common/Settings'
import { TabStore } from '../common/TabStore'
import { ViaIcon } from './ViaIcon'
import { hostOf, getBuiltinEngines } from '../common/SearchEngines'
import { ConfigurationConstant, common } from '@kit.AbilityKit'
import { curves } from '@kit.ArkUI'
import { i18n } from '@kit.LocalizationKit'

const BAR_HEIGHT: number = 48
const ICON_SIZE: number = 24
// 原版 n0.j()：按钮左右 margin 13dp（dimens bh=13dp）
const ICON_MARGIN: number = 13

// 原版标题长按菜单项（k6.h.onLongClick：复制/粘贴/粘贴并前往）
class TitleMenuItem {
  label: ResourceStr = ''
  action: () => void = () => {}

  constructor(label: ResourceStr, action: () => void) {
    this.label = label
    this.action = action
  }
}

// 原版左图标长按搜索引擎对话框条目（k6.h：z8/v2.e 引擎表 + sp=搜索引擎 单选）
class EngineItem {
  key: string = ''
  name: string = ''

  constructor(key: string, name: string) {
    this.key = key
    this.name = name
  }
}

@ComponentV2
export struct AddressBar {
  @Param @Require tab: TabItem
  // 原版 Tb()：布局 0/1/2 透明底，布局 3 圆角胶囊底
  @Param style: string = 'plain'
  @Event onAddressTap: () => void = () => {}
  @Event onOpenMedia: (urls: string[]) => void = (urls: string[]) => {
  }
  @Event onSiteInfo: () => void = () => {}
  @Event onScan: () => void = () => {}
  // 原版 k6.f：阅读图标显示期点击左图标 → B8() 进阅读
  @Event onReader: () => void = () => {}
  private settings: AppSettings = AppSettings.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  @Local showTitleMenu: boolean = false
  @Local showEngineMenu: boolean = false
  @Local pulseScale: number = 1
  // 原版 n0.v(true)：阅读图标 3s 显示窗口（postDelayed 3000 → v(false) 复位）
  @Local readerHint: boolean = false
  private readerHintTimer: number = -1
  // 原版共用插值器 x8/h.b()：cubic-bezier(0.2,0.2,0.8,0.8)
  private pulseCurve = curves.cubicBezier(0.2, 0.2, 0.8, 0.8)
  private pulseEventId: number = 30001

  aboutToAppear(): void {
    // 原版 n0.v(true)/q()：阅读模式触发左图标 1↔1.15↔1 缩放脉冲 1200ms + 阅读图标 3s
    emitter.on({ eventId: this.pulseEventId }, () => {
      this.getUIContext().animateTo({ duration: 600, curve: this.pulseCurve }, () => {
        this.pulseScale = 1.15
      })
      setTimeout(() => {
        this.getUIContext().animateTo({ duration: 600, curve: this.pulseCurve }, () => {
          this.pulseScale = 1
        })
      }, 600)
      if (this.readerHintTimer >= 0) {
        clearTimeout(this.readerHintTimer)
      }
      this.readerHint = true
      this.readerHintTimer = setTimeout(() => {
        this.readerHint = false
        this.readerHintTimer = -1
      }, 3000)
    })
  }

  aboutToDisappear(): void {
    emitter.off(this.pulseEventId)
    if (this.readerHintTimer >= 0) {
      clearTimeout(this.readerHintTimer)
      this.readerHintTimer = -1
    }
  }

  // 原版 x8.h.s()：标题字号基数 16sp（dimens a8）跟随「字体大小」设置
  private titleFontSize(): number {
    return 16 * this.settings.textZoom / 100
  }

  // 原版 k6.F()：mode 1 网址仅截断 8192；网络 URL 去 scheme 且仅当尾字符为 '/' 去掉尾斜杠
  private formattedUrl(): string {
    let str = this.tab.url.length > 8192 ? this.tab.url.substring(0, 8192) : this.tab.url
    if (str.startsWith('http://') || str.startsWith('https://')) {
      const schemeIndex = str.indexOf('://')
      str = str.substring(schemeIndex + 3)
      if (str.length > 0 && str.charAt(str.length - 1) === '/') {
        str = str.substring(0, str.length - 1)
      }
    }
    return str
  }

  private titleText(): ResourceStr {
    // 原版 k6.t()：主页时无条件显示页面标题「主页」，不受地址栏内容设置影响
    if (this.tab.isHomePage()) {
      return $r('app.string.home_page')
    }
    const mode = this.settings.addressBarContent
    if (mode === 1) {
      // 原版 F() mode 1：显示格式化网址
      return this.formattedUrl()
    }
    if (mode === 2) {
      // 原版 F() mode 2：显示域名（i0.f，不做 scheme 剥离）
      return hostOf(this.tab.url)
    }
    if (this.tab.title !== '') {
      return this.tab.title
    }
    // 原版 P7()：标题为空回退「无标题」（k6.Z0(x7.u.bh)）
    return $r('app.string.no_title')
  }

  // 原版 n0.setSecureCnnection()：隐身+https 用隐身锁，https 用锁，非 https 左图标 f12905j1（desc 网站信息）
  private siteIcon(): Resource {
    if (this.tab.incognito && this.tab.url.startsWith('https://')) {
      return $r('app.media.via_ic_incognito_lock')
    }
    if (this.tab.url.startsWith('https://')) {
      return $r('app.media.via_ic_lock')
    }
    return $r('app.media.via_ic_site_info')
  }

  // 原版 n0.v()/t(Lc)：阅读提示期左图标换成阅读图标（V0=d2），desc tx=打开阅读模式
  private leftIcon(): Resource {
    if (this.readerHint) {
      return $r('app.media.via_ic_reader')
    }
    return this.siteIcon()
  }

  // 原版 n0.s()：加载中→停止，主页→扫码，其余→刷新
  private actionIcon(): Resource {
    if (this.tab.loading) {
      return $r('app.media.via_ic_stop')
    }
    if (this.tab.isHomePage()) {
      return $r('app.media.via_ic_addr_scan')
    }
    return $r('app.media.via_ic_refresh')
  }

  private onAction(): void {
    if (this.tab.loading) {
      try {
        this.tab.controller.stop()
      } catch (error) {
        console.error('stop loading failed')
      }
      return
    }
    if (this.tab.isHomePage()) {
      this.onScan()
      return
    }
    try {
      this.tab.controller.refresh()
    } catch (error) {
      console.error('refresh failed')
    }
  }

  // 原版胶囊底色：暗色态 0x22FFFFFF，亮色态 0x10000000（ToolbarsViewDelegate）
  private pillBackground(): ResourceColor {
    if (this.style !== 'pill') {
      return Color.Transparent
    }
    if (this.isDarkMode()) {
      return '#22FFFFFF'
    }
    return '#10000000'
  }

  private isDarkMode(): boolean {
    try {
      const ctx = this.getUIContext().getHostContext() as common.UIAbilityContext
      return ctx.config.colorMode === ConfigurationConstant.ColorMode.COLOR_MODE_DARK
    } catch (error) {
      return false
    }
  }

  // 原版左图标长按对话框条目（k6.h：z8/v2.e(Context) 引擎名数组，含自定义引擎）
  private engineItems(): EngineItem[] {
    let lang = 'zh'
    try {
      lang = i18n.System.getSystemLanguage()
    } catch (error) {
      lang = 'zh'
    }
    const isZh = lang.startsWith('zh')
    const isRu = lang.startsWith('ru')
    const items: EngineItem[] = []
    const builtins = getBuiltinEngines(isZh, isRu)
    for (const engine of builtins) {
      items.push(new EngineItem(engine.key, engine.name))
    }
    for (let i = 0; i < this.settings.customEngines.length; i++) {
      const rec = this.settings.customEngines[i]
      items.push(new EngineItem(`custom:${rec.id}`, rec.name))
    }
    return items
  }

  // 原版标题长按菜单：复制（仅 URL 非内部页）/ 粘贴 / 粘贴并前往
  private titleMenuItems(): TitleMenuItem[] {
    const items: TitleMenuItem[] = []
    if (this.tab.url !== '' && !this.tab.isHomePage()) {
      items.push(new TitleMenuItem($r('app.string.copy_link'), (): void => {
        const data = pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, this.tab.url)
        pasteboard.getSystemPasteboard().setData(data).then(() => {
          // 原版 g6.n.a(context, url, x7.u.pg)：复制后弹「已复制链接」
          this.getUIContext().getPromptAction().showToast({ message: $r('app.string.copied_link') })
        }).catch(() => {})
      }))
    }
    // 原版 h.a → oa(粘贴文本)：把剪贴板文本放入地址输入框
    items.push(new TitleMenuItem($r('app.string.paste'), (): void => {
      pasteboard.getSystemPasteboard().getData().then((data: pasteboard.PasteData) => {
        const text = data.getPrimaryText().trim()
        if (text !== '') {
          AppStorage.setOrCreate('via_paste_url', text)
          this.onAddressTap()
        }
      }).catch(() => {})
    }))
    items.push(new TitleMenuItem($r('app.string.paste_and_go'), (): void => {
      pasteboard.getSystemPasteboard().getData().then((data: pasteboard.PasteData) => {
        const text = data.getPrimaryText().trim()
        if (text !== '') {
          this.tabStore.navigate(text)
        }
      }).catch(() => {})
    }))
    return items
  }

  build() {
    Row() {
      Stack() {
        ViaIcon({ icon: this.leftIcon(), iconSize: ICON_SIZE, iconColor: $r('app.color.icon') })
          .scale({ x: this.pulseScale, y: this.pulseScale })
          .accessibilityText(this.readerHint
            ? $r('app.string.open_reader_mode') : $r('app.string.site_info'))
      }
      .height('100%')
      .alignContent(Alignment.Center)
      .margin({ left: ICON_MARGIN })
      .onClick(() => {
        // 原版 k6.f：!v()（非阅读提示期）或主页 → Bb() 网站信息；否则 B8() 进阅读
        if (!this.readerHint || this.tab.isHomePage()) {
          this.onSiteInfo()
        } else {
          this.onReader()
        }
      })
      // 原版 k6.h：左图标长按 → 搜索引擎单选对话框（sp=搜索引擎，选中写 searchengine）
      .bindPopup(this.showEngineMenu, {
        builder: this.EngineMenu(),
        placement: Placement.Bottom,
        onStateChange: (_e: object) => {
        }
      })
      .gesture(LongPressGesture({ repeat: false, duration: 500 }).onAction(() => {
        this.showEngineMenu = true
      }))

      Text(this.titleText())
        .fontSize(this.titleFontSize())
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .textAlign(TextAlign.Center)
        .layoutWeight(1)
        .bindPopup(this.showTitleMenu, {
          builder: this.TitleMenu(),
          placement: Placement.Bottom,
          onStateChange: (_e: object) => {
          }
        })
        // 原版标题长按 → 复制/粘贴/粘贴并前往（k6.h.onLongClick）
        .gesture(LongPressGesture({ repeat: false, duration: 500 }).onAction(() => {
          this.showTitleMenu = true
        }))

      // 原版 n0.m()：资源嗅探图标 f9707j 位于标题与右图标之间；t() 渐隐渐显（rz=资源嗅探）
      if (this.tab.sniffedMedia.length > 0) {
        Stack() {
          ViaIcon({ icon: $r('app.media.via_ic_resource'), iconSize: ICON_SIZE, iconColor: $r('app.color.icon') })
        }
        .height('100%')
        .alignContent(Alignment.Center)
        .accessibilityText($r('app.string.res_sniffer'))
        .transition(TransitionEffect.OPACITY.animation({ duration: 200, curve: this.pulseCurve }))
        .onClick(() => {
          // 原版 k6.f：f9703w 点击 → u1() 打开资源嗅探面板
          this.onOpenMedia(this.tab.sniffedMedia)
        })
      }

      Stack() {
        ViaIcon({ icon: this.actionIcon(), iconSize: ICON_SIZE, iconColor: $r('app.color.icon') })
      }
      .height('100%')
      .alignContent(Alignment.Center)
      .margin({ right: ICON_MARGIN })
      .onClick(() => {
        this.onAction()
      })
    }
    .width('100%')
    .height(BAR_HEIGHT)
    .backgroundColor(this.pillBackground())
    .borderRadius(this.style === 'pill' ? BAR_HEIGHT / 2 : 0)
    .margin(this.style === 'pill' ? { left: 16, right: 16 } : { left: 0, right: 0 })
    .onClick(() => {
      this.onAddressTap()
    })
  }

  @Builder
  TitleMenu() {
    Column() {
      ForEach(this.titleMenuItems(), (item: TitleMenuItem) => {
        Text(item.label)
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .padding({ left: 20, right: 20, top: 10, bottom: 10 })
          .width('100%')
          .onClick(() => {
            this.showTitleMenu = false
            item.action()
          })
      }, (item: TitleMenuItem, index: number) => `${index}`)
    }
    .width(120)
  }

  // 原版 k6.h 左图标长按：w5.k.l(I()).d0(sp=搜索引擎) 单选列表
  @Builder
  EngineMenu() {
    Column() {
      Text($r('app.string.search_engine'))
        .fontSize(14)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .padding({ left: 16, right: 16, top: 10, bottom: 6 })
      ForEach(this.engineItems(), (item: EngineItem) => {
        Text(item.name)
          .fontSize(14)
          .fontColor(this.settings.engineKey === item.key ? $r('app.color.accent') : $r('app.color.fg'))
          .fontWeight(this.settings.engineKey === item.key ? FontWeight.Bold : FontWeight.Normal)
          .padding({ left: 16, right: 16, top: 8, bottom: 8 })
          .width('100%')
          .onClick(() => {
            // 原版选中 → q3("searchengine", 引擎)
            this.settings.setEngineKey(item.key)
            this.showEngineMenu = false
          })
      }, (item: EngineItem) => item.key)
    }
    .width(140)
  }
}
