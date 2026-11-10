import { AppSettings } from '../common/Settings'
import { uaByKey } from '../common/UaTable'
import { SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'

// 原版 jb/y4（网站设定根页，r8-map-id 751751c2）：
// j3() 行清单 + o3() 每行导航到独立子页（case 1 w6 / 2 n1 / 3 v5 / 4 e0 / 5 j2 / 6 t / 7 u2 /
// 8 y1 / 9 i0 / 10 u3 / 11 f3 / 12 i / 13 q3 / 14 k5 / 15 z5 / 16 c1 / 17 r0）；
// 副标题逐行动态读取全局态（webflag 位默认 96495261）
@ComponentV2
export struct SiteSettingsPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.site_settings'),
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
            // q(1, c0 所有网站) → hb/w6
            SettingNavRow({
              rowLabel: $r('app.string.all_sites'),
              onTapRow: () => {
                this.navPathStack.pushPathByName('siteAll', '', true)
              }
            })
            // l(R1 内容)
            Text($r('app.string.ai_content_label'))
              .fontSize(13)
              .fontColor($r('app.color.accent'))
              .width('100%')
              .padding({ left: 16, top: 14, bottom: 4 })
            // q(14, ua 字体大小, "%d%%") → jb/k5
            SettingNavRow({
              rowLabel: $r('app.string.text_size'),
              rowValue: `${this.settings.textZoom}%`,
              onTapRow: () => {
                this.navPathStack.pushPathByName('fontSettings', '', true)
              }
            })
            // q(3, bh 浏览器标识, 全局 UA 名) → jb/v5
            SettingNavRow({
              rowLabel: $r('app.string.browser_ua'),
              rowValue: this.uaLabel(),
              onTapRow: () => {
                this.navPathStack.pushPathByName('uaException', '', true)
              }
            })
            // q(17, aj 电脑模式, l() ? os 打开 : oo 关闭) → jb/r0
            SettingNavRow({
              rowLabel: $r('app.string.pc_mode'),
              rowValue: this.settings.desktopAllSites === 1 ? $r('app.string.open_action') : $r('app.string.close_btn'),
              onTapRow: () => {
                this.navPathStack.pushPathByName('desktopMode', '', true)
              }
            })
            // q(2, kt 图像, l3(q()) / r() → ky) → jb/n1
            SettingNavRow({
              rowLabel: $r('app.string.orig_kt'),
              rowValue: this.imageValue(),
              onTapRow: () => {
                this.navPathStack.pushPathByName('imageSetting', '', true)
              }
            })
            // q(8, lx JavaScript, l3(t())) → jb/y1
            SettingNavRow({
              rowLabel: 'JavaScript',
              rowValue: this.settings.jsEnabled ? $r('app.string.perm_allow') : $r('app.string.orig_cx'),
              onTapRow: () => {
                this.navPathStack.pushPathByName('jsSetting', '', true)
              }
            })
            // q(9, eg Cookies, (!j() || C()) ? l3(j()) : ei) → jb/i0
            SettingNavRow({
              rowLabel: 'Cookies',
              rowValue: this.cookiesValue(),
              onTapRow: () => {
                this.navPathStack.pushPathByName('cookiesSetting', '', true)
              }
            })
            // q(10, qw 弹出式窗口, h() ? ch 优先询问 : c8 允许) → jb/u3
            SettingNavRow({
              rowLabel: $r('app.string.orig_qw'),
              rowValue: this.settings.popupAskFirst ? $r('app.string.orig_ch') : $r('app.string.perm_allow'),
              onTapRow: () => {
                this.navPathStack.pushPathByName('popupSetting', '', true)
              }
            })
            // l(Q1 基本)
            Text($r('app.string.orig_dg'))
              .fontSize(13)
              .fontColor($r('app.color.accent'))
              .width('100%')
              .padding({ left: 16, top: 14, bottom: 4 })
            // q(12, ct 广告拦截, g() ? os : oo) → jb/i
            SettingNavRow({
              rowLabel: $r('app.string.ad_block'),
              rowValue: this.settings.adBlockOn ? $r('app.string.open_action') : $r('app.string.close_btn'),
              onTapRow: () => {
                this.navPathStack.pushPathByName('adBlockException', '', true)
              }
            })
            // l(S1 权限)
            Text($r('app.string.orig_di'))
              .fontSize(13)
              .fontColor($r('app.color.accent'))
              .width('100%')
              .padding({ left: 16, top: 14, bottom: 4 })
            // q(4, dx 剪贴板, m3(e())) → jb/e0
            SettingNavRow({
              rowLabel: $r('app.string.orig_dx'),
              rowValue: this.triStateValue(this.settings.clipboardState),
              onTapRow: () => {
                this.openPermission('clipboard')
              }
            })
            // q(11, oz 打开应用, m3(f())) → jb/f3
            SettingNavRow({
              rowLabel: $r('app.string.orig_oz'),
              rowValue: this.triStateValue(this.settings.openAppState),
              onTapRow: () => {
                this.openPermission('openapp')
              }
            })
            // q(5, mh 位置信息, k3(u())) → jb/j2
            SettingNavRow({
              rowLabel: $r('app.string.orig_mh'),
              rowValue: this.settings.geoAskFirst ? $r('app.string.orig_ch') : $r('app.string.orig_cx'),
              onTapRow: () => {
                this.openPermission('geo')
              }
            })
            // q(6, d6 摄像头, k3(i())) → jb/t
            SettingNavRow({
              rowLabel: $r('app.string.perm_camera_label'),
              rowValue: this.settings.cameraAskFirst ? $r('app.string.orig_ch') : $r('app.string.orig_cx'),
              onTapRow: () => {
                this.openPermission('camera')
              }
            })
            // q(7, nn 麦克风, k3(v())) → jb/u2
            SettingNavRow({
              rowLabel: $r('app.string.perm_mic_label'),
              rowValue: this.settings.micAskFirst ? $r('app.string.orig_ch') : $r('app.string.orig_cx'),
              onTapRow: () => {
                this.openPermission('mic')
              }
            })
            // q(13, q5 页面重定向, k() ? l3(true) : q_) → jb/q3
            SettingNavRow({
              rowLabel: $r('app.string.orig_q5'),
              rowValue: this.settings.redirectAskFirst ? $r('app.string.orig_q_') : $r('app.string.perm_allow'),
              onTapRow: () => {
                this.openPermission('redirect')
              }
            })
            // q(15, a1f 振动, l3(E())) → jb/z5
            SettingNavRow({
              rowLabel: $r('app.string.orig_a1f'),
              rowValue: this.settings.vibrateEnabled ? $r('app.string.perm_allow') : $r('app.string.orig_cx'),
              onTapRow: () => {
                this.openPermission('vibrate')
              }
            })
            // l(tl 高级)
            Text($r('app.string.advanced'))
              .fontSize(13)
              .fontColor($r('app.color.accent'))
              .width('100%')
              .padding({ left: 16, top: 14, bottom: 4 })
            // q(16, r4 返回不重载, p() ? os : oo) → jb/c1
            SettingNavRow({
              rowLabel: $r('app.string.orig_r4'),
              rowValue: this.settings.backReloadEnabled ? $r('app.string.open_action') : $r('app.string.close_btn'),
              onTapRow: () => {
                this.openPermission('backreload')
              }
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
    .translate({ x: this.slideOffset })
    // 原版 g6/i.java:67 = setCustomAnimations(anim/f, anim/g, anim/h, anim/i)，
    // 时长 integer/b=220、accelerate_decelerate —— 改用鸿蒙原生 NavDestination 转场接口
    .customTransition((operation: NavigationOperation, isEnter: boolean):
      Array<NavDestinationTransition> | undefined => {
      return buildNavSlide(operation, isEnter, (value: string): void => {
        this.slideOffset = value
      })
    })
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

  private uaLabel(): string {
    if (this.settings.uaKey === 'custom') {
      return '自定义'
    }
    const def = uaByKey(this.settings.uaKey)
    return def !== null ? def.label : '默认'
  }

  // y4.j3：图像副标题 l3(q())；r() → D6 ky「仅在 Wi-Fi 连接时允许」
  private imageValue(): string {
    if (this.settings.wifiOnlyImages) {
      return '仅在 Wi-Fi 连接时允许'
    }
    return this.settings.noImage ? '已禁止' : '允许'
  }

  // y4.j3：Cookies 副标题 (!j() || C()) ? l3(j()) : B2 ei
  // （C() 置位 = 允许第三方；清位 = 拦截第三方 → ei「允许（第三方除外）」）
  private cookiesValue(): string {
    if (!this.settings.cookiesEnabled) {
      return '已禁止'
    }
    return this.settings.cookiesBlockThirdParty ? '允许' : '允许（第三方除外）'
  }

  // y4.m3(i)：1 → c8 允许 / 2 → cx 已禁止 / 3 → ch 优先询问
  private triStateValue(state: number): string {
    if (state === 3) {
      return '优先询问'
    }
    return state === 2 ? '已禁止' : '允许'
  }

  private openPermission(kind: string): void {
    const payload: Record<string, string> = { 'kind': kind } as Record<string, string>
    this.navPathStack.pushPathByName('permissionPage', JSON.stringify(payload), true)
  }
}

@Builder
export function SiteSettingsPageBuilder() {
  SiteSettingsPage()
}
