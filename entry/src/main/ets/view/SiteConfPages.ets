import { AppSettings } from '../common/Settings'
import { SiteSetting, SITE_MODE_DEFAULT, SITE_MODE_ON, SITE_MODE_OFF, SITE_PERM_ASK } from '../common/Types'
import { dialogTransition } from '../common/Transitions'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { ViaIcon } from '../components/ViaIcon'
import { BusinessError } from '@kit.BasicServicesKit'
import { ZoomSlider } from '../components/ZoomSlider'
import { computeDialogWidthVp } from '../components/ViaDialogCard'
import { UA_TABLE, uaByKey } from '../common/UaTable'
import { hostOf } from '../common/SearchEngines'

// 原版 jb 包站点级页面 1:1：
// SiteConfDetailPage = jb/u4 单站点页；DesktopModePage = jb/r0 电脑模式；
// UaExceptionPage = jb/v5 浏览器标识例外；ImageSettingPage = jb/n1 图像；
// JavaScriptSettingPage = jb/y1 JavaScript。
// 所有站点级例外统一写入 siteSettings（原版 ca/d SiteConf DB），空站点条目随删（ba/b.r）。

// 原版 z8/f.c() zh：字体缩放预览诗
const FONT_ZOOM_PREVIEW: string = '莫忧世事兼身事，须著人间比梦间。'

// 原版 w6.m3/v5.l3 输入归一化：含 "://" 截 host（i6/i0.e），再 ba/c.f（trim + 小写）
function normalizeHostInput(input: string): string {
  let text = input.trim()
  if (text.indexOf('://') >= 0) {
    text = hostOf(text)
  }
  return text.trim().toLowerCase()
}

// 原版 u4.f4/L3/N3：fc「%1$s（默认）」后缀
function withDefaultSuffix(label: string): string {
  return `${label}（默认）`
}

// 原版 k8.p：域名升序
function sortHosts(hosts: string[]): void {
  hosts.sort((a: string, b: string): number => {
    if (a === b) {
      return 0
    }
    return a < b ? -1 : 1
  })
}

// jb/u4：单站点页。首页行开关 ho「启用 "%1$s" 的网站设定」+ 内容/基本/权限/高级四大区 +
// 每项三态选择弹窗（首项 fc 全局值（默认）= 跟随全局）+ 工具栏 ao 重置 + 确认 nh
@ComponentV2
export struct SiteConfDetailPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local host: string = ''
  // 本地编辑副本（原版 ba.a w0），写穿到 siteSettings；空配置随删（u4.X3 → ba/b.r）
  @Local confEnabled: boolean = false
  @Local fontZoom: number = 0
  @Local uaMode: string = ''
  @Local customUa: string = ''
  @Local desktopMode: number = SITE_MODE_DEFAULT
  @Local imageMode: number = SITE_MODE_DEFAULT
  @Local jsMode: number = SITE_MODE_DEFAULT
  @Local adBlockMode: number = SITE_MODE_DEFAULT
  @Local incognitoMode: number = SITE_MODE_DEFAULT
  @Local backReloadMode: number = SITE_MODE_DEFAULT
  @Local redirectMode: number = SITE_MODE_DEFAULT
  @Local clipboardMode: number = SITE_MODE_DEFAULT
  @Local openAppMode: number = SITE_MODE_DEFAULT
  @Local geoMode: number = SITE_MODE_DEFAULT
  @Local cameraMode: number = SITE_MODE_DEFAULT
  @Local micMode: number = SITE_MODE_DEFAULT
  // d4() 字体缩放弹窗
  @Local zoomDialogId: number = -1
  @Local zoomValue: number = 100
  // e4() 浏览器标识弹窗 / J3() 自定义 UA 输入
  @Local pickDialogId: number = -1
  @Local pickTitle: string = ''
  @Local pickOptions: string[] = []
  @Local pickChecked: number = -1
  @Local pickShowOk: boolean = false
  @Local pickNegative: string = ''
  @Local pickOnPick: (index: number) => void = (_index: number): void => {
  }
  @Local pickOnNegative: (host: string) => void = (_host: string): void => {
  }
  @Local inputDialogId: number = -1
  @Local inputTitle: string = ''
  @Local inputValue: string = ''
  @Local inputOnOk: (value: string) => void = (_value: string): void => {
  }
  // a3() 重置确认弹窗
  @Local resetDialogId: number = -1

  private bindAppBar(): void {
    AppBar.show({
      title: '网站设定',
      rightText: '重置',
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight: () => {
        this.openResetDialog()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // a6.n(1, ho 启用 "%1$s" 的网站设定, s())
            Row({ space: 12 }) {
              Text(`启用 "${this.host}" 的网站设定`)
                .fontSize(15)
                .fontColor($r('app.color.fg'))
                .layoutWeight(1)
                .maxLines(2)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
              Toggle({ type: ToggleType.Switch, isOn: this.confEnabled })
                .selectedColor($r('app.color.accent'))
                .onChange((state: boolean) => {
                  // u4.Y3：S(true ^ n.i())
                  this.confEnabled = state
                  this.persist()
                })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 13, bottom: 13 })
            .alignItems(VerticalAlign.Center)

            this.SectionHeader('内容')
            // q(14, ua 字体大小, i(F0)/i(0) + fc)
            this.ValueRow('字体大小', this.fontZoom > 0 ? `${this.fontZoom}%` : withDefaultSuffix(`${this.settings.textZoom}%`), () => {
              this.openZoomDialog()
            })
            // q(2, bh 浏览器标识, e4 选择)
            this.ValueRow('浏览器标识', this.uaValue(), () => {
              this.openUaDialog()
            })
            // q(3, aj 电脑模式, K3 三态)
            this.ValueRow('电脑模式', this.triValueOf(this.desktopMode, '打开', '关闭', this.settings.desktopAllSites === 1 ? '打开' : '关闭'), () => {
              this.openTriDialog('电脑模式', this.settings.desktopAllSites === 1 ? '打开' : '关闭',
                ['打开', '关闭'], this.desktopMode, (mode: number): void => {
                  this.desktopMode = mode
                  this.persist()
                })
            })
            // q(4, kt 图像, P3 三态)
            this.ValueRow('图像', this.triValueOf(this.imageMode, '允许', '已禁止', this.globalImageLabel()), () => {
              this.openTriDialog('图像', this.globalImageLabel(), ['允许', '禁止'], this.imageMode, (mode: number): void => {
                this.imageMode = mode
                this.persist()
              })
            })
            // q(6, lx JavaScript, R3 三态)
            this.ValueRow('JavaScript', this.triValueOf(this.jsMode, '允许', '已禁止', this.settings.jsEnabled ? '允许' : '已禁止'), () => {
              this.openTriDialog('JavaScript', this.settings.jsEnabled ? '允许' : '已禁止',
                ['允许', '禁止'], this.jsMode, (mode: number): void => {
                  this.jsMode = mode
                  this.persist()
                })
            })
            this.SectionHeader('基本')
            // q(5, ct 广告拦截, F3 三态)
            this.ValueRow('广告拦截', this.triValueOf(this.adBlockMode, '打开', '关闭', this.settings.adBlockOn ? '打开' : '关闭'), () => {
              this.openTriDialog('广告拦截', this.settings.adBlockOn ? '打开' : '关闭',
                ['打开', '关闭'], this.adBlockMode, (mode: number): void => {
                  this.adBlockMode = mode
                  this.persist()
                })
            })
            // q(8, a8 隐身, Q3 三态)
            this.ValueRow('隐身', this.triValueOf(this.incognitoMode, '打开', '关闭', '关闭'), () => {
              // 原版全局隐身位 s() 默认关（webflag bit64 未置位）
              this.openTriDialog('隐身', '关闭', ['打开', '关闭'], this.incognitoMode, (mode: number): void => {
                this.incognitoMode = mode
                this.persist()
              })
            })
            this.SectionHeader('权限')
            // q(11, nn 麦克风, U3 四态)
            this.ValueRow('麦克风', this.permValueOf(this.micMode, this.settings.micAskFirst ? '优先询问' : '已禁止'), () => {
              this.openPermDialog('麦克风', this.settings.micAskFirst ? '优先询问' : '已禁止', this.micMode, (mode: number): void => {
                this.micMode = mode
                this.persist()
              })
            })
            // q(12, d6 摄像头, H3 四态)
            this.ValueRow('摄像头', this.permValueOf(this.cameraMode, this.settings.cameraAskFirst ? '优先询问' : '已禁止'), () => {
              this.openPermDialog('摄像头', this.settings.cameraAskFirst ? '优先询问' : '已禁止', this.cameraMode, (mode: number): void => {
                this.cameraMode = mode
                this.persist()
              })
            })
            // q(7, dx 剪贴板, I3 四态)
            this.ValueRow('剪贴板', this.permValueOf(this.clipboardMode, this.globalClipboardLabel()), () => {
              this.openPermDialog('剪贴板', this.globalClipboardLabel(), this.clipboardMode, (mode: number): void => {
                this.clipboardMode = mode
                this.persist()
              })
            })
            // q(9, oz 打开应用, a4 四态)
            this.ValueRow('打开应用', this.permValueOf(this.openAppMode, this.globalOpenAppLabel()), () => {
              this.openPermDialog('打开应用', this.globalOpenAppLabel(), this.openAppMode, (mode: number): void => {
                this.openAppMode = mode
                this.persist()
              })
            })
            // q(10, q5 页面重定向, b4 三态)
            this.ValueRow('页面重定向', this.triValueOf(this.redirectMode, '允许', '重定向到非同源页面前先询问',
              this.settings.redirectAskFirst ? '重定向到非同源页面前先询问' : '允许'), () => {
              this.openTriDialog('页面重定向', this.settings.redirectAskFirst ? '重定向到非同源页面前先询问' : '允许',
                ['允许', '重定向到非同源页面前先询问'], this.redirectMode, (mode: number): void => {
                  this.redirectMode = mode
                  this.persist()
                })
            })
            // q(13, mh 位置信息, T3 四态)
            this.ValueRow('位置信息', this.permValueOf(this.geoMode, this.settings.geoAskFirst ? '优先询问' : '已禁止'), () => {
              this.openPermDialog('位置信息', this.settings.geoAskFirst ? '优先询问' : '已禁止', this.geoMode, (mode: number): void => {
                this.geoMode = mode
                this.persist()
              })
            })
            this.SectionHeader('高级')
            // q(15, r4 返回不重载, O3 三态)
            this.ValueRow('返回不重载', this.triValueOf(this.backReloadMode, '打开', '关闭',
              this.settings.backReloadEnabled ? '打开' : '关闭'), () => {
              this.openTriDialog('返回不重载', this.settings.backReloadEnabled ? '打开' : '关闭',
                ['打开', '关闭'], this.backReloadMode, (mode: number): void => {
                  this.backReloadMode = mode
                  this.persist()
                })
            })
          }
          .width('100%')
          .padding({ bottom: 20 })
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.readParams(ctx)
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  private readParams(ctx: NavDestinationContext): void {
    let host = ''
    try {
      const rawParams: string | undefined = JSON.stringify(ctx.pathStack.getParamByName('siteDetail'))
      const params: string[] = rawParams !== undefined && rawParams !== 'undefined' && rawParams !== '[]' ? JSON.parse(rawParams) as string[] : []
      if (params.length > 0) {
        const param: string = params[params.length - 1]
        if (typeof param === 'string') {
          host = param
        }
      }
    } catch (error) {
      console.error('read site detail params failed')
    }
    this.host = host
    const site = this.settings.getSiteSetting(host)
    if (site !== null) {
      this.confEnabled = site.enabled
      this.fontZoom = site.fontZoom
      this.uaMode = site.uaMode
      this.customUa = site.customUa
      this.desktopMode = site.desktopMode
      this.imageMode = site.imageMode
      this.jsMode = site.javaScriptMode
      this.adBlockMode = site.adBlockMode
      this.incognitoMode = site.incognitoMode
      this.backReloadMode = site.backReloadMode
      this.redirectMode = site.redirectMode
      this.clipboardMode = site.clipboardMode
      this.openAppMode = site.openAppMode
      this.geoMode = site.geoMode
      this.cameraMode = site.cameraMode
      this.micMode = site.micMode
    }
  }

  // u4.X3：空配置（ba/b.r，启用位不计）不落盘/随删；否则写穿（同步旧布尔字段）
  private persist(): void {
    const site = new SiteSetting(this.host)
    site.enabled = this.confEnabled
    site.fontZoom = this.fontZoom
    site.uaMode = this.uaMode
    site.customUa = this.customUa
    site.desktopMode = this.desktopMode
    site.imageMode = this.imageMode
    site.javaScriptMode = this.jsMode
    site.adBlockMode = this.adBlockMode
    site.incognitoMode = this.incognitoMode
    site.backReloadMode = this.backReloadMode
    site.redirectMode = this.redirectMode
    site.clipboardMode = this.clipboardMode
    site.openAppMode = this.openAppMode
    site.geoMode = this.geoMode
    site.cameraMode = this.cameraMode
    site.micMode = this.micMode
    if (site.isEmptyConf()) {
      this.settings.removeSiteSetting(this.host)
    } else {
      this.settings.applySiteConf(site)
    }
  }

  // ---- 行构件 ----

  @Builder
  SectionHeader(label: string) {
    // a6.m：12sp 粗体 accent，padH16 T12 B4
    Text(label)
      .fontSize(12)
      .fontWeight(FontWeight.Bold)
      .fontColor($r('app.color.accent'))
      .width('100%')
      .padding({ left: 16, right: 16, top: 12, bottom: 4 })
  }

  // a6.q 值行（G3 全部 !zS 禁用态：未启用网站设定时置灰且不可点）
  @Builder
  ValueRow(label: string, value: string, onTap: () => void) {
    Column() {
      Text(label)
        .fontSize(15)
        .fontColor(this.confEnabled ? $r('app.color.fg') : $r('app.color.fg_secondary'))
        .maxLines(1)
      Text(value)
        .fontSize(13)
        .fontColor($r('app.color.fg_secondary'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .margin({ top: 2 })
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 13, bottom: 13 })
    .alignItems(HorizontalAlign.Start)
    .opacity(this.confEnabled ? 1 : 0.5)
    .onClick(() => {
      if (!this.confEnabled) {
        return
      }
      onTap()
    })
  }

  // u4.N3/M3/L3 值文案：0 → f4(全局值)；1 → 阳性；2 → 阴性
  private triValueOf(mode: number, positive: string, negative: string, globalLabel: string): string {
    if (mode === SITE_MODE_ON) {
      return positive
    }
    if (mode === SITE_MODE_OFF) {
      return negative
    }
    return withDefaultSuffix(globalLabel)
  }

  // u4.M3 权限值文案（G3：1 → c8 允许 / 2 → cx 已禁止 / 3 → ch 优先询问 / 0 → f4 全局）
  private permValueOf(mode: number, globalLabel: string): string {
    if (mode === SITE_MODE_ON) {
      return '允许'
    }
    if (mode === 2) {
      return '已禁止'
    }
    if (mode === SITE_PERM_ASK) {
      return '优先询问'
    }
    return withDefaultSuffix(globalLabel)
  }

  private globalImageLabel(): string {
    if (this.settings.wifiOnlyImages) {
      return '仅在 Wi-Fi 连接时允许'
    }
    return this.settings.noImage ? '已禁止' : '允许'
  }

  private globalClipboardLabel(): string {
    if (this.settings.clipboardState === 3) {
      return '优先询问'
    }
    return this.settings.clipboardState === 2 ? '已禁止' : '允许'
  }

  private globalOpenAppLabel(): string {
    if (this.settings.openAppState === 3) {
      return '优先询问'
    }
    return this.settings.openAppState === 2 ? '已禁止' : '允许'
  }

  // e4 值文案：'' → f4(全局 UA 名)；custom(-999 行) → bm 自定义；其余 → 表内名
  private uaValue(): string {
    if (this.uaMode === 'custom') {
      return '自定义'
    }
    if (this.uaMode === '') {
      return withDefaultSuffix(this.globalUaLabel())
    }
    const def = uaByKey(this.uaMode)
    return def !== null ? def.label : this.uaMode
  }

  private globalUaLabel(): string {
    if (this.settings.uaKey === 'custom') {
      return '自定义'
    }
    const def = uaByKey(this.settings.uaKey)
    return def !== null ? def.label : '默认'
  }

  // ---- 弹窗 ----

  // u4.d4：字体缩放弹窗（预览诗 + w0 滑条 + 确定/取消 + 有覆盖时 R(ao 重置)）
  private openZoomDialog(): void {
    this.zoomValue = this.fontZoom > 0 ? this.fontZoom : this.settings.textZoom
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.ZoomDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.zoomDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open zoom dialog failed: ${error.message}`)
    })
  }

  @Builder
  ZoomDialog() {
    Column() {
      // k5.k3：预览诗固定高 76dp
      Text(FONT_ZOOM_PREVIEW)
        .fontSize(14 * this.zoomValue / 100)
        .fontColor($r('app.color.fg'))
        .width('100%')
        .height(76)
        .textAlign(TextAlign.Center)
        .margin({ left: 12, right: 12, top: 16 })
      ZoomSlider({
        zoom: this.zoomValue,
        highlightZoom: this.settings.textZoom,
        onZoomChange: (value: number): void => {
          this.zoomValue = value
        },
        onZoomEnd: (value: number): void => {
          this.zoomValue = value
        }
      })
        .width('100%')
        .margin({ left: 16, right: 16, bottom: 16 })
      Row() {
        if (this.fontZoom > 0) {
          // w5.k.R(ao 重置) → B3：d0(0)
          Text('重置')
            .fontSize(14)
            .fontColor($r('app.color.dialog_action'))
            .textAlign(TextAlign.Center)
            .constraintSize({ minWidth: 56 })
            .padding(16)
            .onClick(() => {
              this.fontZoom = 0
              this.persist()
              this.closeZoomDialog()
            })
        }
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeZoomDialog()
          })
        // w5.k.V(ok) → w3：d0(progress*5+50)
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.fontZoom = this.zoomValue
            this.persist()
            this.closeZoomDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeZoomDialog(): void {
    if (this.zoomDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.zoomDialogId)
    this.zoomDialogId = -1
  }

  // 三态弹窗（K3/P3/R3/F3/Q3/O3/b4）：[f4 全局（默认）= 跟随, 阳性, 阴性]
  private openTriDialog(title: string, globalLabel: string, pair: string[], mode: number, onPick: (mode: number) => void): void {
    const options: string[] = [withDefaultSuffix(globalLabel), pair[0], pair[1]]
    this.openPickDialog(title, options, mode, false, '', (index: number): void => {
      onPick(index)
    }, (_host: string): void => {
    })
  }

  // 四态弹窗（U3/H3/I3/a4/T3）：[f4 全局（默认）, c2 允许, cr 禁止, ch 优先询问]
  private openPermDialog(title: string, globalLabel: string, mode: number, onPick: (mode: number) => void): void {
    const options: string[] = [withDefaultSuffix(globalLabel), '允许', '禁止', '优先询问']
    this.openPickDialog(title, options, mode, false, '', (index: number): void => {
      onPick(index)
    }, (_host: string): void => {
    })
  }

  // u4.e4：浏览器标识弹窗 [-1000 f4(全局 UA 名), ...内置+自定义 UA, -999 bm 自定义]
  private openUaDialog(): void {
    const options: string[] = [withDefaultSuffix(this.globalUaLabel())]
    for (let i = 0; i < UA_TABLE.length; i++) {
      options.push(UA_TABLE[i].label)
    }
    for (let i = 0; i < this.settings.customUaList.length; i++) {
      options.push(this.settings.customUaList[i].title)
    }
    options.push('自定义')
    // 选中索引：0=跟随；1..9=内置；随后自定义 UA；最后 = 自定义输入
    let checked = 0
    if (this.uaMode === 'custom') {
      checked = options.length - 1
    } else if (this.uaMode !== '') {
      for (let i = 0; i < UA_TABLE.length; i++) {
        if (UA_TABLE[i].key === this.uaMode) {
          checked = 1 + i
          break
        }
      }
      if (checked === 0) {
        for (let i = 0; i < this.settings.customUaList.length; i++) {
          if (this.customUa !== '' && this.settings.customUaList[i].ua === this.customUa) {
            checked = 1 + UA_TABLE.length + i
            break
          }
        }
      }
    }
    this.openPickDialog('浏览器标识', options, checked, false, '', (index: number): void => {
      if (index <= 0) {
        // -1000 → e0(-1000) 跟随全局
        this.uaMode = ''
        this.customUa = ''
        this.persist()
        return
      }
      const uaIndex = index - 1
      if (uaIndex < UA_TABLE.length) {
        // 内置 UA → e0(id)
        this.uaMode = UA_TABLE[uaIndex].key
        this.customUa = ''
        this.persist()
        return
      }
      const customIndex = uaIndex - UA_TABLE.length
      if (customIndex < this.settings.customUaList.length) {
        // 自定义 UA 记录 → e0(id) + Q(ua)
        this.uaMode = 'custom'
        this.customUa = this.settings.customUaList[customIndex].ua
        this.persist()
        return
      }
      // -999 → J3 自定义 UA 输入弹窗
      this.openCustomUaInput()
    }, (_host: string): void => {
    })
  }

  // u4.J3：w5.k.l().d0(bm 自定义).u(false).i(现值, bh 浏览器标识, 3).V(g3: Q(input)+e0(-999))
  private openCustomUaInput(): void {
    this.openInputDialog('自定义', this.customUa, (value: string): void => {
      const ua = value.trim()
      if (ua === '') {
        return
      }
      this.uaMode = 'custom'
      this.customUa = ua
      this.persist()
    })
  }

  // u4.a3：工具栏 ao 重置 → w5.k.d0(fg 重置网站设定).J(nh 确认).V(E() 重置).N(cancel)
  private openResetDialog(): void {
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.ResetDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.resetDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open reset dialog failed: ${error.message}`)
    })
  }

  @Builder
  ResetDialog() {
    Column() {
      Text('重置网站设定')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Text(`你确定重置 ${this.host} 的网站设定吗？`)
        .fontSize(14)
        .fontColor($r('app.color.fg_secondary'))
        .width('100%')
        .margin({ left: 16, right: 16 })
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeResetDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            // u4.j3：w0.E() 全部重置；X3 时空配置随删
            this.confEnabled = false
            this.fontZoom = 0
            this.uaMode = ''
            this.customUa = ''
            this.desktopMode = SITE_MODE_DEFAULT
            this.imageMode = SITE_MODE_DEFAULT
            this.jsMode = SITE_MODE_DEFAULT
            this.adBlockMode = SITE_MODE_DEFAULT
            this.incognitoMode = SITE_MODE_DEFAULT
            this.backReloadMode = SITE_MODE_DEFAULT
            this.redirectMode = SITE_MODE_DEFAULT
            this.clipboardMode = SITE_MODE_DEFAULT
            this.openAppMode = SITE_MODE_DEFAULT
            this.geoMode = SITE_MODE_DEFAULT
            this.cameraMode = SITE_MODE_DEFAULT
            this.micMode = SITE_MODE_DEFAULT
            this.settings.removeSiteSetting(this.host)
            this.closeResetDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16, top: 12 })
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeResetDialog(): void {
    if (this.resetDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.resetDialogId)
    this.resetDialogId = -1
  }

  // 通用单选弹窗（w5.k.b0；showOk = 带 V(ok)/R 负按钮）
  private openPickDialog(title: string, options: string[], checked: number, showOk: boolean, negative: string,
    onPick: (index: number) => void, onNegative: (host: string) => void): void {
    this.pickTitle = title
    this.pickOptions = options
    this.pickChecked = checked
    this.pickShowOk = showOk
    this.pickNegative = negative
    this.pickOnPick = onPick
    this.pickOnNegative = onNegative
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.PickDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.pickDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open pick dialog failed: ${error.message}`)
    })
  }

  @Builder
  PickDialog() {
    Column() {
      Text(this.pickTitle)
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      ForEach(this.pickOptions, (label: string, index: number) => {
        Row({ space: 24 }) {
          Circle({ width: 16, height: 16 })
            .fill(this.pickChecked === index ? $r('app.color.accent') : Color.Transparent)
            .stroke(this.pickChecked === index ? Color.Transparent : $r('app.color.dialog_border'))
            .strokeWidth(2)
          Text(label)
            .fontSize(14)
            .fontColor($r('app.color.fg'))
            .maxLines(2)
            .textOverflow({ overflow: TextOverflow.Ellipsis })
            .layoutWeight(1)
        }
        .width('100%')
        .padding({ left: 16, right: 16, top: 12, bottom: 12 })
        .onClick(() => {
          if (this.pickShowOk) {
            this.pickChecked = index
          } else {
            const pick = this.pickOnPick
            this.closePickDialog()
            pick(index)
          }
        })
      }, (label: string) => label)
      if (this.pickShowOk) {
        Row() {
          if (this.pickNegative !== '') {
            Text(this.pickNegative)
              .fontSize(14)
              .fontColor($r('app.color.dialog_action'))
              .textAlign(TextAlign.Center)
              .constraintSize({ minWidth: 56 })
              .padding(16)
              .onClick(() => {
                const negative = this.pickOnNegative
                this.closePickDialog()
                negative(this.host)
              })
          }
          Blank()
          Text($r('app.string.cancel'))
            .fontSize(14)
            .fontColor($r('app.color.dialog_action'))
            .textAlign(TextAlign.Center)
            .constraintSize({ minWidth: 56 })
            .padding(16)
            .onClick(() => {
              this.closePickDialog()
            })
          Text($r('app.string.confirm'))
            .fontSize(14)
            .fontColor($r('app.color.dialog_action'))
            .textAlign(TextAlign.Center)
            .constraintSize({ minWidth: 56 })
            .padding(16)
            .onClick(() => {
              const pick = this.pickOnPick
              this.closePickDialog()
              pick(this.pickChecked)
            })
        }
        .width('100%')
        .margin({ left: 16, right: 16 })
      }
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closePickDialog(): void {
    if (this.pickDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.pickDialogId)
    this.pickDialogId = -1
  }

  // w5.k.i 单行输入弹窗（type3 多行/单行通用样式）
  private openInputDialog(title: string, initial: string, onOk: (value: string) => void): void {
    this.inputTitle = title
    this.inputValue = initial
    this.inputOnOk = onOk
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.InputDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.inputDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open input dialog failed: ${error.message}`)
    })
  }

  @Builder
  InputDialog() {
    Column() {
      Text(this.inputTitle)
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Row() {
        TextInput({ placeholder: '浏览器标识', text: this.inputValue })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .backgroundColor(Color.Transparent)
          .padding({ left: 0, right: 0 })
          .height(40)
          .layoutWeight(1)
          .onChange((value: string) => {
            this.inputValue = value
          })
      }
      .width('100%')
      .margin({ left: 16, right: 12, top: 8, bottom: 12 })
      .border({ width: { bottom: 1 }, color: $r('app.color.dialog_border') })
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeInputDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            const onOk = this.inputOnOk
            this.closeInputDialog()
            onOk(this.inputValue)
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeInputDialog(): void {
    if (this.inputDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.inputDialogId)
    this.inputDialogId = -1
  }
}

// jb/r0：电脑模式页（n 全局开关 + bc 添加例外 + [关闭]/[打开|例外] 分组 + 站点弹窗 [打开,关闭] + 删除）
@ComponentV2
export struct DesktopModePage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local addDialogId: number = -1
  @Local addHostInput: string = ''
  @Local siteDialogId: number = -1
  @Local siteDialogHost: string = ''
  @Local pickChecked: number = -1

  private bindAppBar(): void {
    AppBar.show({
      title: '电脑模式',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // n(1, aj 电脑模式, m())
            Row({ space: 12 }) {
              Text('电脑模式')
                .fontSize(15)
                .fontColor($r('app.color.fg'))
                .layoutWeight(1)
                .maxLines(1)
              Toggle({ type: ToggleType.Switch, isOn: this.settings.desktopAllSites === 1 })
                .selectedColor($r('app.color.accent'))
                .onChange((state: boolean) => {
                  // r0：t(!n.i) → O(z)
                  this.settings.setDesktopAllSites(state ? 1 : 0)
                })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 13, bottom: 13 })
            .alignItems(VerticalAlign.Center)
            // a6.e 添加例外网站
            Row({ space: 18 }) {
              ViaIcon({ icon: $r('app.media.via_ic_add'), iconSize: 18, iconColor: $r('app.color.fg') })
              Text('添加例外网站')
                .fontSize(14)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 20, bottom: 20 })
            .onClick(() => {
              this.openAddDialog()
            })
            this.GroupHosts()
          }
          .width('100%')
          .padding({ bottom: 20 })
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  private globalOn(): boolean {
    return this.settings.desktopAllSites === 1
  }

  private siteMode(site: SiteSetting | null): number {
    return site !== null ? site.desktopMode : SITE_MODE_DEFAULT
  }

  @Builder
  GroupHosts() {
    // 第一组：Y8 关闭（desktopMode=2）
    if (this.hostsOf(SITE_MODE_OFF).length > 0) {
      Text('关闭')
        .fontSize(12)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.accent'))
        .width('100%')
        .padding({ left: 16, right: 16, top: 12, bottom: 4 })
      ForEach(this.hostsOf(SITE_MODE_OFF), (host: string) => {
        Text(host)
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
          .width('100%')
          .padding({ left: 16, right: 16, top: 20, bottom: 20 })
          .onClick(() => {
            this.openSiteDialog(host)
          })
      }, (host: string) => `off-${host}`)
    }
    // 第二组：z10 ? os 打开 : i4 例外（desktopMode=1）
    if (this.hostsOf(SITE_MODE_ON).length > 0) {
      Text(this.globalOn() ? '打开' : '例外')
        .fontSize(12)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.accent'))
        .width('100%')
        .padding({ left: 16, right: 16, top: 12, bottom: 4 })
      ForEach(this.hostsOf(SITE_MODE_ON), (host: string) => {
        Text(host)
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
          .width('100%')
          .padding({ left: 16, right: 16, top: 20, bottom: 20 })
          .onClick(() => {
            this.openSiteDialog(host)
          })
      }, (host: string) => `on-${host}`)
    }
  }

  private hostsOf(mode: number): string[] {
    const result: string[] = []
    for (let i = 0; i < this.settings.siteSettings.length; i++) {
      const site = this.settings.siteSettings[i]
      if (site.enabled && site.desktopMode === mode) {
        result.push(site.host)
      }
    }
    sortHosts(result)
    return result
  }

  // s0.l(str, z)：R(z) → bit8；mode 0 跟随（空条目随删）
  private setSiteMode(host: string, mode: number): void {
    const site = this.settings.obtainSiteSetting(host)
    site.desktopMode = mode
    if (mode === SITE_MODE_DEFAULT && site.isEmptyConf()) {
      this.settings.removeSiteSetting(host)
    } else {
      this.settings.applySiteConf(site)
    }
  }

  // r0.o3：d0(bc).J(zM ? g1 : g2).i(...).V(m3: l(host, !zM)).N(cancel)
  private openAddDialog(): void {
    this.addHostInput = ''
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.AddDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.addDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open desktop add dialog failed: ${error.message}`)
    })
  }

  @Builder
  AddDialog() {
    Column() {
      Text('添加例外网站')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      // g1 为特定网站关闭电脑模式。/ g2 为特定网站打开电脑模式。
      Text(this.globalOn() ? '为特定网站关闭电脑模式。' : '为特定网站打开电脑模式。')
        .fontSize(14)
        .fontColor($r('app.color.fg_secondary'))
        .width('100%')
        .margin({ left: 16, right: 16, bottom: 4 })
      Row() {
        TextInput({ placeholder: 'www.example.com', text: this.addHostInput })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.dialog_hint'))
          .placeholderFont({ size: 14 })
          .backgroundColor(Color.Transparent)
          .padding({ left: 0, right: 0 })
          .height(40)
          .layoutWeight(1)
          .onChange((value: string) => {
            this.addHostInput = value
          })
      }
      .width('100%')
      .margin({ left: 16, right: 12, top: 8, bottom: 12 })
      .border({ width: { bottom: 1 }, color: $r('app.color.dialog_border') })
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeAddDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            // m3：l(host, !zM)——全局开 → 站点关(2)；全局关 → 站点开(1)
            const host = normalizeHostInput(this.addHostInput)
            if (host !== '') {
              this.setSiteMode(host, this.globalOn() ? SITE_MODE_OFF : SITE_MODE_ON)
            }
            this.closeAddDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeAddDialog(): void {
    if (this.addDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.addDialogId)
    this.addDialogId = -1
  }

  // r0.q3：站点弹窗 e0(host).b0([打开, 关闭]).V(ok).R(删除)
  private openSiteDialog(host: string): void {
    this.siteDialogHost = host
    this.pickChecked = this.siteMode(this.settings.getSiteSetting(host)) === SITE_MODE_ON ? 0 : 1
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.SiteDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.siteDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open desktop site dialog failed: ${error.message}`)
    })
  }

  @Builder
  SiteDialog() {
    Column() {
      Text(this.siteDialogHost)
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Row({ space: 24 }) {
        Circle({ width: 16, height: 16 })
          .fill(this.pickChecked === 0 ? $r('app.color.accent') : Color.Transparent)
          .stroke(this.pickChecked === 0 ? Color.Transparent : $r('app.color.dialog_border'))
          .strokeWidth(2)
        Text('打开')
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .layoutWeight(1)
      }
      .width('100%')
      .padding({ left: 16, right: 16, top: 12, bottom: 12 })
      .onClick(() => {
        this.pickChecked = 0
      })
      Row({ space: 24 }) {
        Circle({ width: 16, height: 16 })
          .fill(this.pickChecked === 1 ? $r('app.color.accent') : Color.Transparent)
          .stroke(this.pickChecked === 1 ? Color.Transparent : $r('app.color.dialog_border'))
          .strokeWidth(2)
        Text('关闭')
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .layoutWeight(1)
      }
      .width('100%')
      .padding({ left: 16, right: 16, top: 12, bottom: 12 })
      .onClick(() => {
        this.pickChecked = 1
      })
      Row() {
        Text('删除')
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            // R(x 删除) → s0.s：G() 清覆盖
            this.setSiteMode(this.siteDialogHost, SITE_MODE_DEFAULT)
            this.closeSiteDialog()
          })
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeSiteDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            // v3：0→G() 跟随、1→R(true) 打开、2→R(false) 关闭
            this.setSiteMode(this.siteDialogHost, this.pickChecked === 0 ? SITE_MODE_ON : SITE_MODE_OFF)
            this.closeSiteDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeSiteDialog(): void {
    if (this.siteDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.siteDialogId)
    this.siteDialogId = -1
  }
}

// jb/v5：站点级浏览器标识例外页
// q(1, bh 浏览器标识, 全局 UA 名)（→ y7 浏览器标识页）+ bc 添加例外（message bi）+
// [i4 例外] 列表（host + UA 副标签）+ 站点弹窗（内置+自定义+bm 自定义输入）+ 删除
@ComponentV2
export struct UaExceptionPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local addDialogId: number = -1
  @Local addHostInput: string = ''
  @Local pickDialogId: number = -1
  @Local pickHost: string = ''
  @Local pickOptions: string[] = []
  @Local pickChecked: number = -1
  @Local inputDialogId: number = -1
  @Local inputValue: string = ''

  private bindAppBar(): void {
    AppBar.show({
      title: '浏览器标识',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // q(1, bh 浏览器标识, 全局 UA 名) → jb/v5.u3：g6.i.g(y7)
            Column() {
              Text('浏览器标识')
                .fontSize(15)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
              Text(this.globalUaLabel())
                .fontSize(13)
                .fontColor($r('app.color.fg_secondary'))
                .maxLines(1)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
                .margin({ top: 2 })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 13, bottom: 13 })
            .alignItems(HorizontalAlign.Start)
            .onClick(() => {
              this.navPathStack.pushPathByName('uaPage', '', true)
            })
            // a6.e 添加例外网站（message bi）
            Row({ space: 18 }) {
              ViaIcon({ icon: $r('app.media.via_ic_add'), iconSize: 18, iconColor: $r('app.color.fg') })
              Text('添加例外网站')
                .fontSize(14)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 20, bottom: 20 })
            .onClick(() => {
              this.openAddDialog()
            })
            // l(i4 例外) + 站点行（host + UA 副标签）
            if (this.exceptionHosts().length > 0) {
              Text('例外')
                .fontSize(12)
                .fontWeight(FontWeight.Bold)
                .fontColor($r('app.color.accent'))
                .width('100%')
                .padding({ left: 16, right: 16, top: 12, bottom: 4 })
              ForEach(this.exceptionHosts(), (host: string) => {
                Column() {
                  Text(host)
                    .fontSize(14)
                    .fontColor($r('app.color.fg'))
                    .maxLines(1)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                    .width('100%')
                  Text(this.siteUaLabel(host))
                    .fontSize(12)
                    .fontColor($r('app.color.fg_secondary'))
                    .maxLines(2)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                    .width('100%')
                }
                .width('100%')
                .padding({ left: 16, right: 16, top: 20, bottom: 20 })
                .alignItems(HorizontalAlign.Start)
                .onClick(() => {
                  this.openSiteUaDialog(host)
                })
              }, (host: string) => host)
            }
          }
          .width('100%')
          .padding({ bottom: 20 })
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  private globalUaLabel(): string {
    if (this.settings.uaKey === 'custom') {
      return '自定义'
    }
    const def = uaByKey(this.settings.uaKey)
    return def !== null ? def.label : '默认'
  }

  // w5.t：站点 uaChoice != -1000 的条目
  private exceptionHosts(): string[] {
    const result: string[] = []
    for (let i = 0; i < this.settings.siteSettings.length; i++) {
      const site = this.settings.siteSettings[i]
      if (site.enabled && site.uaMode !== '') {
        result.push(site.host)
      }
    }
    sortHosts(result)
    return result
  }

  // kb.b.d()：内置 → UA 名；custom → 自定义 UA 串
  private siteUaLabel(host: string): string {
    const site = this.settings.getSiteSetting(host)
    if (site === null) {
      return ''
    }
    if (site.uaMode === 'custom') {
      return site.customUa
    }
    const def = uaByKey(site.uaMode)
    return def !== null ? def.label : site.uaMode
  }

  // w5.l(str, cVar)：e0(uaMode) + Q(customUa)
  private setSiteUa(host: string, key: string, ua: string): void {
    const site = this.settings.obtainSiteSetting(host)
    site.uaMode = key
    site.customUa = ua
    if (key === '' && site.isEmptyConf()) {
      this.settings.removeSiteSetting(host)
    } else {
      this.settings.applySiteConf(site)
    }
  }

  // v5.o3：d0(bc).I(D0 bi 为特定网站设置浏览器标识。).i(...).V(l3: r3(host)).N(cancel)
  private openAddDialog(): void {
    this.addHostInput = ''
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.AddDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.addDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open ua add dialog failed: ${error.message}`)
    })
  }

  @Builder
  AddDialog() {
    Column() {
      Text('添加例外网站')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Text('为特定网站设置浏览器标识。')
        .fontSize(14)
        .fontColor($r('app.color.fg_secondary'))
        .width('100%')
        .margin({ left: 16, right: 16, bottom: 4 })
      Row() {
        TextInput({ placeholder: 'www.example.com', text: this.addHostInput })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.dialog_hint'))
          .placeholderFont({ size: 14 })
          .backgroundColor(Color.Transparent)
          .padding({ left: 0, right: 0 })
          .height(40)
          .layoutWeight(1)
          .onChange((value: string) => {
            this.addHostInput = value
          })
      }
      .width('100%')
      .margin({ left: 16, right: 12, top: 8, bottom: 12 })
      .border({ width: { bottom: 1 }, color: $r('app.color.dialog_border') })
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeAddDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            // l3 → r3(normalize)：确认后直接打开该站点的 UA 选择弹窗
            const host = normalizeHostInput(this.addHostInput)
            if (host !== '') {
              this.closeAddDialog()
              this.openSiteUaDialog(host)
            }
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeAddDialog(): void {
    if (this.addDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.addDialogId)
    this.addDialogId = -1
  }

  // v5.r3：e0(host).b0([内置 UA..., 自定义 UA..., bm 自定义]).V(ok).R(删除)
  private openSiteUaDialog(host: string): void {
    const options: string[] = []
    for (let i = 0; i < UA_TABLE.length; i++) {
      options.push(UA_TABLE[i].label)
    }
    for (let i = 0; i < this.settings.customUaList.length; i++) {
      options.push(this.settings.customUaList[i].title)
    }
    options.push('自定义')
    const site = this.settings.getSiteSetting(host)
    let checked = -1
    if (site !== null && site.uaMode !== '') {
      if (site.uaMode === 'custom') {
        checked = options.length - 1
      } else {
        for (let i = 0; i < UA_TABLE.length; i++) {
          if (UA_TABLE[i].key === site.uaMode) {
            checked = i
            break
          }
        }
        if (checked < 0 && site.customUa !== '') {
          for (let i = 0; i < this.settings.customUaList.length; i++) {
            if (this.settings.customUaList[i].ua === site.customUa) {
              checked = UA_TABLE.length + i
              break
            }
          }
        }
      }
    }
    this.pickHost = host
    this.pickOptions = options
    this.pickChecked = checked
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.SiteUaDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.pickDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open ua site dialog failed: ${error.message}`)
    })
  }

  @Builder
  SiteUaDialog() {
    Column() {
      Text(this.pickHost)
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      ForEach(this.pickOptions, (label: string, index: number) => {
        Row({ space: 24 }) {
          Circle({ width: 16, height: 16 })
            .fill(this.pickChecked === index ? $r('app.color.accent') : Color.Transparent)
            .stroke(this.pickChecked === index ? Color.Transparent : $r('app.color.dialog_border'))
            .strokeWidth(2)
          Text(label)
            .fontSize(14)
            .fontColor($r('app.color.fg'))
            .maxLines(2)
            .textOverflow({ overflow: TextOverflow.Ellipsis })
            .layoutWeight(1)
        }
        .width('100%')
        .padding({ left: 16, right: 16, top: 12, bottom: 12 })
        .onClick(() => {
          this.pickChecked = index
        })
      }, (label: string) => label)
      Row() {
        Text('删除')
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            // R(x 删除) → w5.u：e0(-1000) 清覆盖
            this.setSiteUa(this.pickHost, '', '')
            this.closeSiteUaDialog()
          })
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeSiteUaDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            const index = this.pickChecked
            if (index >= 0) {
              if (index === this.pickOptions.length - 1) {
                // -999 → q3 自定义输入弹窗
                this.closeSiteUaDialog()
                this.openCustomInput()
              } else if (index < UA_TABLE.length) {
                this.setSiteUa(this.pickHost, UA_TABLE[index].key, '')
                this.closeSiteUaDialog()
              } else {
                const entry = this.settings.customUaList[index - UA_TABLE.length]
                this.setSiteUa(this.pickHost, 'custom', entry.ua)
                this.closeSiteUaDialog()
              }
            } else {
              this.closeSiteUaDialog()
            }
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeSiteUaDialog(): void {
    if (this.pickDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.pickDialogId)
    this.pickDialogId = -1
  }

  // v5.q3：d0(bm 自定义).u(false).i(现值, bh, 3).V(g3: l(str, ja.c.l(-999, input)))
  private openCustomInput(): void {
    const site = this.settings.getSiteSetting(this.pickHost)
    this.inputValue = site !== null && site.uaMode === 'custom' ? site.customUa : ''
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.CustomInputDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.inputDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open ua custom input dialog failed: ${error.message}`)
    })
  }

  @Builder
  CustomInputDialog() {
    Column() {
      Text('自定义')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Row() {
        TextInput({ placeholder: '浏览器标识', text: this.inputValue })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .backgroundColor(Color.Transparent)
          .padding({ left: 0, right: 0 })
          .height(40)
          .layoutWeight(1)
          .onChange((value: string) => {
            this.inputValue = value
          })
      }
      .width('100%')
      .margin({ left: 16, right: 12, top: 8, bottom: 12 })
      .border({ width: { bottom: 1 }, color: $r('app.color.dialog_border') })
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeCustomInput()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            // g3：l(str, ja.c.l(-999, str2, str2))——空输入不动作
            const ua = this.inputValue.trim()
            if (ua !== '') {
              this.setSiteUa(this.pickHost, 'custom', ua)
            }
            this.closeCustomInput()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeCustomInput(): void {
    if (this.inputDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.inputDialogId)
    this.inputDialogId = -1
  }
}

// jb/n1：图像子页（三态行 kr/kq/kp + bc 添加例外 + [已禁止]/[允许|例外] 分组 + 站点弹窗 + 删除）
@ComponentV2
export struct ImageSettingPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local addDialogId: number = -1
  @Local addHostInput: string = ''
  @Local siteDialogId: number = -1
  @Local siteDialogHost: string = ''
  @Local pickChecked: number = -1
  // 全局三态弹窗（n1.t3：e0(kt).b0([kr,kq,kp]).f0()）
  @Local globalDialogId: number = -1
  @Local globalChecked: number = 1

  private bindAppBar(): void {
    AppBar.show({
      title: '图像',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // q(1, kt 图像, r3(q(), r()))
            Column() {
              Text('图像')
                .fontSize(15)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
              Text(this.globalValue())
                .fontSize(13)
                .fontColor($r('app.color.fg_secondary'))
                .maxLines(1)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
                .margin({ top: 2 })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 13, bottom: 13 })
            .alignItems(HorizontalAlign.Start)
            .onClick(() => {
              this.openGlobalDialog()
            })
            // a6.e 添加例外网站
            Row({ space: 18 }) {
              ViaIcon({ icon: $r('app.media.via_ic_add'), iconSize: 18, iconColor: $r('app.color.fg') })
              Text('添加例外网站')
                .fontSize(14)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 20, bottom: 20 })
            .onClick(() => {
              this.openAddDialog()
            })
            // 第一组：cx 已禁止（imageMode=2）
            if (this.hostsOfMode(SITE_MODE_OFF).length > 0) {
              Text('已禁止')
                .fontSize(12)
                .fontWeight(FontWeight.Bold)
                .fontColor($r('app.color.accent'))
                .width('100%')
                .padding({ left: 16, right: 16, top: 12, bottom: 4 })
              ForEach(this.hostsOfMode(SITE_MODE_OFF), (host: string) => {
                Text(host)
                  .fontSize(14)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
                  .width('100%')
                  .padding({ left: 16, right: 16, top: 20, bottom: 20 })
                  .onClick(() => {
                    this.openSiteDialog(host)
                  })
              }, (host: string) => `d-${host}`)
            }
            // 第二组：z10 ? c8 允许 : i4 例外（imageMode=1）
            if (this.hostsOfMode(SITE_MODE_ON).length > 0) {
              Text(this.globalShown() ? '允许' : '例外')
                .fontSize(12)
                .fontWeight(FontWeight.Bold)
                .fontColor($r('app.color.accent'))
                .width('100%')
                .padding({ left: 16, right: 16, top: 12, bottom: 4 })
              ForEach(this.hostsOfMode(SITE_MODE_ON), (host: string) => {
                Text(host)
                  .fontSize(14)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
                  .width('100%')
                  .padding({ left: 16, right: 16, top: 20, bottom: 20 })
                  .onClick(() => {
                    this.openSiteDialog(host)
                  })
              }, (host: string) => `a-${host}`)
            }
          }
          .width('100%')
          .padding({ bottom: 20 })
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  // n1.r3(q, r)：r → kx 仅在 Wi-Fi 连接时允许网页显示图像；q → kw 允许网站显示图像；否则 cx
  private globalValue(): string {
    if (this.settings.wifiOnlyImages) {
      return '仅在 Wi-Fi 连接时允许网页显示图像'
    }
    return this.settings.noImage ? '已禁止' : '允许网站显示图像'
  }

  private globalShown(): boolean {
    return !this.settings.noImage || this.settings.wifiOnlyImages
  }

  private hostsOfMode(mode: number): string[] {
    const result: string[] = []
    for (let i = 0; i < this.settings.siteSettings.length; i++) {
      const site = this.settings.siteSettings[i]
      if (site.enabled && site.imageMode === mode) {
        result.push(site.host)
      }
    }
    sortHosts(result)
    return result
  }

  private setSiteMode(host: string, mode: number): void {
    const site = this.settings.obtainSiteSetting(host)
    site.imageMode = mode
    if (mode === SITE_MODE_DEFAULT && site.isEmptyConf()) {
      this.settings.removeSiteSetting(host)
    } else {
      this.settings.applySiteConf(site)
    }
  }

  // n1.t3：三态弹窗 [kr 有图模式, kq 无图模式, kp 仅 Wi-Fi 有图]
  private openGlobalDialog(): void {
    this.globalChecked = this.settings.wifiOnlyImages ? 2 : (this.settings.noImage ? 1 : 0)
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.GlobalDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.globalDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open image global dialog failed: ${error.message}`)
    })
  }

  @Builder
  GlobalDialog() {
    Column() {
      Text('图像')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      ForEach(['有图模式', '无图模式', '仅 Wi-Fi 有图'], (label: string, index: number) => {
        Row({ space: 24 }) {
          Circle({ width: 16, height: 16 })
            .fill(this.globalChecked === index ? $r('app.color.accent') : Color.Transparent)
            .stroke(this.globalChecked === index ? Color.Transparent : $r('app.color.dialog_border'))
            .strokeWidth(2)
          Text(label)
            .fontSize(14)
            .fontColor($r('app.color.fg'))
            .maxLines(1)
            .layoutWeight(1)
        }
        .width('100%')
        .padding({ left: 16, right: 16, top: 12, bottom: 12 })
        .onClick(() => {
          // n1.g3：u(i11 == 2, i11 != 1)——有图(0)/无图(1)/仅 Wi-Fi(2)
          this.settings.setNoImage(index === 1)
          this.settings.setWifiOnlyImages(index === 2)
          this.closeGlobalDialog()
        })
      }, (label: string) => label)
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeGlobalDialog(): void {
    if (this.globalDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.globalDialogId)
    this.globalDialogId = -1
  }

  // n1.o3：d0(bc).J(q ? kv : ku).i(...).V(n3: l(host, !q)).N(cancel)
  private openAddDialog(): void {
    this.addHostInput = ''
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.AddDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.addDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open image add dialog failed: ${error.message}`)
    })
  }

  @Builder
  AddDialog() {
    Column() {
      Text('添加例外网站')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      // kv 禁止特定网站加载图像。/ ku 允许特定网站显示图像。
      Text(this.globalShown() ? '禁止特定网站加载图像。' : '允许特定网站显示图像。')
        .fontSize(14)
        .fontColor($r('app.color.fg_secondary'))
        .width('100%')
        .margin({ left: 16, right: 16, bottom: 4 })
      Row() {
        TextInput({ placeholder: 'www.example.com', text: this.addHostInput })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.dialog_hint'))
          .placeholderFont({ size: 14 })
          .backgroundColor(Color.Transparent)
          .padding({ left: 0, right: 0 })
          .height(40)
          .layoutWeight(1)
          .onChange((value: string) => {
            this.addHostInput = value
          })
      }
      .width('100%')
      .margin({ left: 16, right: 12, top: 8, bottom: 12 })
      .border({ width: { bottom: 1 }, color: $r('app.color.dialog_border') })
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeAddDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            // n3：l(host, !q)——有图 → 站点禁止(2)；无图/仅WiFi → 站点允许(1)
            const host = normalizeHostInput(this.addHostInput)
            if (host !== '') {
              this.setSiteMode(host, this.globalShown() ? SITE_MODE_OFF : SITE_MODE_ON)
            }
            this.closeAddDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeAddDialog(): void {
    if (this.addDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.addDialogId)
    this.addDialogId = -1
  }

  // n1.q3：e0(host).b0([允许, 禁止]).V(ok).R(删除)
  private openSiteDialog(host: string): void {
    this.siteDialogHost = host
    this.pickChecked = this.settings.getSiteSetting(host)?.imageMode === SITE_MODE_ON ? 0 : 1
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.SiteDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.siteDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open image site dialog failed: ${error.message}`)
    })
  }

  @Builder
  SiteDialog() {
    Column() {
      Text(this.siteDialogHost)
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Row({ space: 24 }) {
        Circle({ width: 16, height: 16 })
          .fill(this.pickChecked === 0 ? $r('app.color.accent') : Color.Transparent)
          .stroke(this.pickChecked === 0 ? Color.Transparent : $r('app.color.dialog_border'))
          .strokeWidth(2)
        Text('允许')
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .layoutWeight(1)
      }
      .width('100%')
      .padding({ left: 16, right: 16, top: 12, bottom: 12 })
      .onClick(() => {
        this.pickChecked = 0
      })
      Row({ space: 24 }) {
        Circle({ width: 16, height: 16 })
          .fill(this.pickChecked === 1 ? $r('app.color.accent') : Color.Transparent)
          .stroke(this.pickChecked === 1 ? Color.Transparent : $r('app.color.dialog_border'))
          .strokeWidth(2)
        Text('禁止')
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .layoutWeight(1)
      }
      .width('100%')
      .padding({ left: 16, right: 16, top: 12, bottom: 12 })
      .onClick(() => {
        this.pickChecked = 1
      })
      Row() {
        Text('删除')
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.setSiteMode(this.siteDialogHost, SITE_MODE_DEFAULT)
            this.closeSiteDialog()
          })
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeSiteDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            // h3：0→J() 跟随、1→X(true) 允许、2→X(false) 禁止
            this.setSiteMode(this.siteDialogHost, this.pickChecked === 0 ? SITE_MODE_ON : SITE_MODE_OFF)
            this.closeSiteDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeSiteDialog(): void {
    if (this.siteDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.siteDialogId)
    this.siteDialogId = -1
  }
}

// jb/y1：JavaScript 子页（n 开关行 + bc 添加例外 + [已禁止]/[允许|例外] 分组 + 站点弹窗 + 删除）
@ComponentV2
export struct JavaScriptSettingPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local addDialogId: number = -1
  @Local addHostInput: string = ''
  @Local siteDialogId: number = -1
  @Local siteDialogHost: string = ''
  @Local pickChecked: number = -1

  private bindAppBar(): void {
    AppBar.show({
      title: 'JavaScript',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // n(1, lx JavaScript, z10 ? m0 允许网页运行 JavaScript : cx, z10)
            Row({ space: 12 }) {
              Column() {
                Text('JavaScript')
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                Text(this.settings.jsEnabled ? '允许网页运行 JavaScript' : '已禁止')
                  .fontSize(13)
                  .fontColor($r('app.color.fg_secondary'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
                  .margin({ top: 2 })
              }
              .alignItems(HorizontalAlign.Start)
              .layoutWeight(1)
              Toggle({ type: ToggleType.Switch, isOn: this.settings.jsEnabled })
                .selectedColor($r('app.color.accent'))
                .onChange((state: boolean) => {
                  this.settings.setJsEnabled(state)
                })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 13, bottom: 13 })
            .alignItems(VerticalAlign.Center)
            // a6.e 添加例外网站
            Row({ space: 18 }) {
              ViaIcon({ icon: $r('app.media.via_ic_add'), iconSize: 18, iconColor: $r('app.color.fg') })
              Text('添加例外网站')
                .fontSize(14)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 20, bottom: 20 })
            .onClick(() => {
              this.openAddDialog()
            })
            // 第一组：cx 已禁止（javaScriptMode=2）
            if (this.hostsOfMode(SITE_MODE_OFF).length > 0) {
              Text('已禁止')
                .fontSize(12)
                .fontWeight(FontWeight.Bold)
                .fontColor($r('app.color.accent'))
                .width('100%')
                .padding({ left: 16, right: 16, top: 12, bottom: 4 })
              ForEach(this.hostsOfMode(SITE_MODE_OFF), (host: string) => {
                Text(host)
                  .fontSize(14)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
                  .width('100%')
                  .padding({ left: 16, right: 16, top: 20, bottom: 20 })
                  .onClick(() => {
                    this.openSiteDialog(host)
                  })
              }, (host: string) => `d-${host}`)
            }
            // 第二组：z10 ? c8 允许 : i4 例外（javaScriptMode=1）
            if (this.hostsOfMode(SITE_MODE_ON).length > 0) {
              Text(this.settings.jsEnabled ? '允许' : '例外')
                .fontSize(12)
                .fontWeight(FontWeight.Bold)
                .fontColor($r('app.color.accent'))
                .width('100%')
                .padding({ left: 16, right: 16, top: 12, bottom: 4 })
              ForEach(this.hostsOfMode(SITE_MODE_ON), (host: string) => {
                Text(host)
                  .fontSize(14)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
                  .width('100%')
                  .padding({ left: 16, right: 16, top: 20, bottom: 20 })
                  .onClick(() => {
                    this.openSiteDialog(host)
                  })
              }, (host: string) => `a-${host}`)
            }
          }
          .width('100%')
          .padding({ bottom: 20 })
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  private hostsOfMode(mode: number): string[] {
    const result: string[] = []
    for (let i = 0; i < this.settings.siteSettings.length; i++) {
      const site = this.settings.siteSettings[i]
      if (site.enabled && site.javaScriptMode === mode) {
        result.push(site.host)
      }
    }
    sortHosts(result)
    return result
  }

  private setSiteMode(host: string, mode: number): void {
    const site = this.settings.obtainSiteSetting(host)
    site.javaScriptMode = mode
    if (mode === SITE_MODE_DEFAULT && site.isEmptyConf()) {
      this.settings.removeSiteSetting(host)
    } else {
      this.settings.applySiteConf(site)
    }
  }

  // y1.o3：d0(bc).J(zP ? lz : ly).i(...).V(k3: l(host, !zP)).N(cancel)
  private openAddDialog(): void {
    this.addHostInput = ''
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.AddDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.addDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open js add dialog failed: ${error.message}`)
    })
  }

  @Builder
  AddDialog() {
    Column() {
      Text('添加例外网站')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      // lz 禁止特定网站运行 JavaScript。/ ly 允许特定网站运行 JavaScript。
      Text(this.settings.jsEnabled ? '禁止特定网站运行 JavaScript。' : '允许特定网站运行 JavaScript。')
        .fontSize(14)
        .fontColor($r('app.color.fg_secondary'))
        .width('100%')
        .margin({ left: 16, right: 16, bottom: 4 })
      Row() {
        TextInput({ placeholder: 'www.example.com', text: this.addHostInput })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.dialog_hint'))
          .placeholderFont({ size: 14 })
          .backgroundColor(Color.Transparent)
          .padding({ left: 0, right: 0 })
          .height(40)
          .layoutWeight(1)
          .onChange((value: string) => {
            this.addHostInput = value
          })
      }
      .width('100%')
      .margin({ left: 16, right: 12, top: 8, bottom: 12 })
      .border({ width: { bottom: 1 }, color: $r('app.color.dialog_border') })
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeAddDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            // k3：l(host, !zP)——全局允许 → 站点禁止(2)；全局禁止 → 站点允许(1)
            const host = normalizeHostInput(this.addHostInput)
            if (host !== '') {
              this.setSiteMode(host, this.settings.jsEnabled ? SITE_MODE_OFF : SITE_MODE_ON)
            }
            this.closeAddDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeAddDialog(): void {
    if (this.addDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.addDialogId)
    this.addDialogId = -1
  }

  // y1.q3：e0(host).b0([允许, 禁止]).V(ok).R(删除)
  private openSiteDialog(host: string): void {
    this.siteDialogHost = host
    this.pickChecked = this.settings.getSiteSetting(host)?.javaScriptMode === SITE_MODE_ON ? 0 : 1
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.SiteDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.siteDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open js site dialog failed: ${error.message}`)
    })
  }

  @Builder
  SiteDialog() {
    Column() {
      Text(this.siteDialogHost)
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Row({ space: 24 }) {
        Circle({ width: 16, height: 16 })
          .fill(this.pickChecked === 0 ? $r('app.color.accent') : Color.Transparent)
          .stroke(this.pickChecked === 0 ? Color.Transparent : $r('app.color.dialog_border'))
          .strokeWidth(2)
        Text('允许')
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .layoutWeight(1)
      }
      .width('100%')
      .padding({ left: 16, right: 16, top: 12, bottom: 12 })
      .onClick(() => {
        this.pickChecked = 0
      })
      Row({ space: 24 }) {
        Circle({ width: 16, height: 16 })
          .fill(this.pickChecked === 1 ? $r('app.color.accent') : Color.Transparent)
          .stroke(this.pickChecked === 1 ? Color.Transparent : $r('app.color.dialog_border'))
          .strokeWidth(2)
        Text('禁止')
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .layoutWeight(1)
      }
      .width('100%')
      .padding({ left: 16, right: 16, top: 12, bottom: 12 })
      .onClick(() => {
        this.pickChecked = 1
      })
      Row() {
        Text('删除')
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.setSiteMode(this.siteDialogHost, SITE_MODE_DEFAULT)
            this.closeSiteDialog()
          })
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeSiteDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            // E3：0→跟随、1→Z(true) 允许、2→Z(false) 禁止
            this.setSiteMode(this.siteDialogHost, this.pickChecked === 0 ? SITE_MODE_ON : SITE_MODE_OFF)
            this.closeSiteDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width('100%')
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeSiteDialog(): void {
    if (this.siteDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.siteDialogId)
    this.siteDialogId = -1
  }
}

@Builder
export function SiteConfDetailPageBuilder() {
  SiteConfDetailPage()
}

@Builder
export function DesktopModePageBuilder() {
  DesktopModePage()
}

@Builder
export function UaExceptionPageBuilder() {
  UaExceptionPage()
}

@Builder
export function ImageSettingPageBuilder() {
  ImageSettingPage()
}

@Builder
export function JavaScriptSettingPageBuilder() {
  JavaScriptSettingPage()
}
