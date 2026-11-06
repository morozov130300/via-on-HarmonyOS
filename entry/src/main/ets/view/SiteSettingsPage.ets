import { AppSettings } from '../common/Settings'
import { uaByKey } from '../common/UaTable'
import { SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'

// 原版 jb/y4（网站设定根页，r8-map-id 751751c2）：
// j3() 行清单 + o3() 每行导航到独立子页（case 1 w6 / 2 n1 / 3 v5 / 4 e0 / 5 j2 / 6 t / 7 u2 /
// 8 y1 / 9 i0 / 10 u3 / 11 f3 / 12 i / 13 q3 / 14 k5 / 15 z5 / 16 c1 / 17 r0）；
// 副标题逐行动态读取全局态（webflag 位默认 96495261）
@ComponentV2
export struct SiteSettingsPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  private bindAppBar(): void {
    AppBar.show({
      title: '网站设定',
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
              rowLabel: '所有网站',
              onTapRow: () => {
                this.navPathStack.pushPathByName('siteAll', '', true)
              }
            })
            // l(R1 内容)
            Text('内容')
              .fontSize(13)
              .fontColor($r('app.color.accent'))
              .width('100%')
              .padding({ left: 16, top: 14, bottom: 4 })
            // q(14, ua 字体大小, "%d%%") → jb/k5
            SettingNavRow({
              rowLabel: '字体大小',
              rowValue: `${this.settings.textZoom}%`,
              onTapRow: () => {
                this.navPathStack.pushPathByName('fontSettings', '', true)
              }
            })
            // q(3, bh 浏览器标识, 全局 UA 名) → jb/v5
            SettingNavRow({
              rowLabel: '浏览器标识',
              rowValue: this.uaLabel(),
              onTapRow: () => {
                this.navPathStack.pushPathByName('uaException', '', true)
              }
            })
            // q(17, aj 电脑模式, l() ? os 打开 : oo 关闭) → jb/r0
            SettingNavRow({
              rowLabel: '电脑模式',
              rowValue: this.settings.desktopAllSites === 1 ? '打开' : '关闭',
              onTapRow: () => {
                this.navPathStack.pushPathByName('desktopMode', '', true)
              }
            })
            // q(2, kt 图像, l3(q()) / r() → ky) → jb/n1
            SettingNavRow({
              rowLabel: '图像',
              rowValue: this.imageValue(),
              onTapRow: () => {
                this.navPathStack.pushPathByName('imageSetting', '', true)
              }
            })
            // q(8, lx JavaScript, l3(t())) → jb/y1
            SettingNavRow({
              rowLabel: 'JavaScript',
              rowValue: this.settings.jsEnabled ? '允许' : '已禁止',
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
              rowLabel: '弹出式窗口',
              rowValue: this.settings.popupAskFirst ? '优先询问' : '允许',
              onTapRow: () => {
                this.navPathStack.pushPathByName('popupSetting', '', true)
              }
            })
            // l(Q1 基本)
            Text('基本')
              .fontSize(13)
              .fontColor($r('app.color.accent'))
              .width('100%')
              .padding({ left: 16, top: 14, bottom: 4 })
            // q(12, ct 广告拦截, g() ? os : oo) → jb/i
            SettingNavRow({
              rowLabel: '广告拦截',
              rowValue: this.settings.adBlockOn ? '打开' : '关闭',
              onTapRow: () => {
                this.navPathStack.pushPathByName('adBlockException', '', true)
              }
            })
            // l(S1 权限)
            Text('权限')
              .fontSize(13)
              .fontColor($r('app.color.accent'))
              .width('100%')
              .padding({ left: 16, top: 14, bottom: 4 })
            // q(4, dx 剪贴板, m3(e())) → jb/e0
            SettingNavRow({
              rowLabel: '剪贴板',
              rowValue: this.triStateValue(this.settings.clipboardState),
              onTapRow: () => {
                this.openPermission('clipboard')
              }
            })
            // q(11, oz 打开应用, m3(f())) → jb/f3
            SettingNavRow({
              rowLabel: '打开应用',
              rowValue: this.triStateValue(this.settings.openAppState),
              onTapRow: () => {
                this.openPermission('openapp')
              }
            })
            // q(5, mh 位置信息, k3(u())) → jb/j2
            SettingNavRow({
              rowLabel: '位置信息',
              rowValue: this.settings.geoAskFirst ? '优先询问' : '已禁止',
              onTapRow: () => {
                this.openPermission('geo')
              }
            })
            // q(6, d6 摄像头, k3(i())) → jb/t
            SettingNavRow({
              rowLabel: '摄像头',
              rowValue: this.settings.cameraAskFirst ? '优先询问' : '已禁止',
              onTapRow: () => {
                this.openPermission('camera')
              }
            })
            // q(7, nn 麦克风, k3(v())) → jb/u2
            SettingNavRow({
              rowLabel: '麦克风',
              rowValue: this.settings.micAskFirst ? '优先询问' : '已禁止',
              onTapRow: () => {
                this.openPermission('mic')
              }
            })
            // q(13, q5 页面重定向, k() ? l3(true) : q_) → jb/q3
            SettingNavRow({
              rowLabel: '页面重定向',
              rowValue: this.settings.redirectAskFirst ? '重定向到非同源页面前先询问' : '允许',
              onTapRow: () => {
                this.openPermission('redirect')
              }
            })
            // q(15, a1f 振动, l3(E())) → jb/z5
            SettingNavRow({
              rowLabel: '振动',
              rowValue: this.settings.vibrateEnabled ? '允许' : '已禁止',
              onTapRow: () => {
                this.openPermission('vibrate')
              }
            })
            // l(tl 高级)
            Text('高级')
              .fontSize(13)
              .fontColor($r('app.color.accent'))
              .width('100%')
              .padding({ left: 16, top: 14, bottom: 4 })
            // q(16, r4 返回不重载, p() ? os : oo) → jb/c1
            SettingNavRow({
              rowLabel: '返回不重载',
              rowValue: this.settings.backReloadEnabled ? '打开' : '关闭',
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
