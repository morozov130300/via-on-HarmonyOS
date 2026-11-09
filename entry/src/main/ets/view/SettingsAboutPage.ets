import { pasteboard } from '@kit.BasicServicesKit'
import { common, Want } from '@kit.AbilityKit'
import { i18n } from '@kit.LocalizationKit'
import { TabStore } from '../common/TabStore'
import { UpdateChecker, UpdateConfig } from '../common/UpdateChecker'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'

const CONTACT_QQ_GROUP_URL: string = 'http://viayoo.com/contact/qqgroup/'
const CONTACT_WECHAT_URL: string = 'http://viayoo.com/contact/wechat/'
// 原版 hb/d.j3 case 5：z8.c0.i()=false → telegram-zh（c0.e()=true 恒显示该行）
const CONTACT_TELEGRAM_URL: string = 'http://viayoo.com/contact/telegram-zh/'
const TERMS_OF_USE_URL: string = 'https://viayoo.com/zh-cn/docs/terms-of-use.html'
const PRIVACY_POLICY_URL: string = 'https://viayoo.com/zh-cn/docs/privacy-policy.html'
const CONTACT_EMAIL: string = 'yafengtu@gmail.com'
// 原版 hb/d.java j3 case 4（q(4, x7.u.f13963e6 = string k_「协助翻译」）→ k3("https://github.com/tuyafeng/Via")
const HELP_TRANSLATE_URL: string = 'https://github.com/tuyafeng/Via'

@ComponentV2
export struct SettingsAboutPage {
  private tabStore: TabStore = TabStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'

  private bindAppBar(): void {
    AppBar.show({
      title: '关于',
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
          // 原版 ib/e.d() + hb/d.X1：头部 = 应用图标(60dp, drawable cy) + Via(16sp 加粗,
          // dimen a8, attr ac 色) + 版本号(14sp, dimen a_, attr ac 色, condensed)；
          // 版本点击 → g6.n.m 弹窗(标题=版本号, 内容=slogan, 确定按钮)；
          // 图标点击 → 检查更新(n0)，图标长按 → SHOW_DEV_UI(安卓专属, 不移植)
          Column({ space: 0 }) {
            Stack() {
              Image($r('app.media.background'))
                .width(60)
                .height(60)
                .objectFit(ImageFit.Cover)
              Image($r('app.media.foreground'))
                .width(60)
                .height(60)
                .objectFit(ImageFit.Cover)
            }
            .width(60)
            .height(60)
            .margin({ bottom: 12 })
            .onClick(() => {
              this.checkUpdate()
            })
            Text('Uia')
              .fontSize(16)
              .fontWeight(FontWeight.Bold)
              .fontColor($r('app.color.fg'))
              .maxLines(1)
            Text('7.4.0.b13.edf6737e')
              .fontSize(14)
              .fontColor($r('app.color.fg'))
              .margin({ top: 2 })
              .onClick(() => {
                this.getUIContext().showAlertDialog({
                  title: '7.4.0.b13.edf6737e',
                  message: this.sloganText(),
                  confirm: {
                    value: $r('app.string.confirm'),
                    action: () => {
                    }
                  }
                })
              })
          }
          .width('100%')
          .alignItems(HorizontalAlign.Center)
          .padding({ top: 24, bottom: 24 })

          this.AboutRow('检查更新', () => {
            this.checkUpdate()
          })
          this.AboutRow('加入 Telegram 群组', () => {
            this.openLink(CONTACT_TELEGRAM_URL)
          })
          this.AboutRow('加入 QQ 群组', () => {
            this.openLink(CONTACT_QQ_GROUP_URL)
          })
          this.AboutRow('通过邮件联系我', () => {
            this.copyEmail()
          })
          this.AboutRow('微信公众号', () => {
            this.openLink(CONTACT_WECHAT_URL)
          })
          this.AboutRow('协助翻译', () => {
            this.openLink(HELP_TRANSLATE_URL)
          })
          this.AboutRow('使用协议', () => {
            this.openLink(TERMS_OF_USE_URL)
          })
          this.AboutRow('隐私政策', () => {
            this.openLink(PRIVACY_POLICY_URL)
          })
          this.AboutRow('开源许可协议', () => {
            this.navPathStack.pushPathByName('licensePage', '', true)
          })
          Column() {
            Text('备案号')
              .fontSize(15)
              .fontColor($r('app.color.fg'))
              .maxLines(1)
            Text('沪ICP备2022019616号-3A')
              .fontSize(13)
              .fontColor($r('app.color.fg_secondary'))
              .margin({ top: 2 })
          }
          .width('100%')
          .padding({ left: 16, right: 16, top: 13, bottom: 13 })
          .alignItems(HorizontalAlign.Start)
        }
        .width('100%')
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

  // 原版 z8/f.c()：CN 地区（Locale country）显示中文 slogan，否则 Less is more.
  private sloganText(): string {
    if (i18n.System.getSystemRegion().toUpperCase() === 'CN') {
      return '莫忧世事兼身事，须著人间比梦间。'
    }
    return 'Less is more.'
  }

  @Builder
  AboutRow(label: string, action: () => void) {
    Text(label)
      .fontSize(15)
      .fontColor($r('app.color.fg'))
      .maxLines(1)
      .width('100%')
      .padding({ left: 16, right: 16, top: 13, bottom: 13 })
      .onClick(() => {
        action()
      })
  }

  private openLink(url: string): void {
    this.tabStore.navigate(url)
    this.navPathStack.pop()
  }

  // 原版 hb/d case 13（z8/f1.g）：通过邮件联系我 → 拉起邮件应用写信；
  // 鸿蒙无邮件应用时回退为复制邮箱并提示
  private copyEmail(): void {
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    const want: Want = {
      action: 'ohos.want.action.sendData',
      uri: `mailto:${CONTACT_EMAIL}`,
      type: 'text/plain'
    }
    context.startAbility(want).catch(() => {
      const data = pasteboard.createData('text/plain', CONTACT_EMAIL)
      pasteboard.getSystemPasteboard().setData(data).then(() => {
        this.getUIContext().getPromptAction().showToast({ message: $r('app.string.email_copied'), duration: 1500 })
      }).catch(() => {
        console.error('copy email failed')
      })
    })
  }

  // 原版关于页「检查更新」：y8/h.k() 拉取配置 → y8/h.h() 流程；
  // config 无效或已是最新 → toast m9「已是最新版本」；
  // 有更新 → 弹窗（o8「新版本可用」+ changelog）。
  // APK 下载/MD5/安装为豁免项不移植，「更新」按钮改为跳转华为应用市场本应用详情页
  private checkUpdate(): void {
    UpdateChecker.fetchLatestConfig().then((config: UpdateConfig | null) => {
      if (config === null || !UpdateChecker.isUpdateAvailable(config)) {
        this.getUIContext().getPromptAction().showToast({ message: $r('app.string.latest_version'), duration: 1500 })
        return
      }
      this.getUIContext().showAlertDialog({
        title: $r('app.string.new_version_available'),
        message: config.changelog,
        primaryButton: {
          value: $r('app.string.cancel'),
          action: () => {
          }
        },
        secondaryButton: {
          value: $r('app.string.update_btn'),
          action: () => {
            this.openAppGalleryDetail()
          }
        }
      })
    })
  }

  // Deep Linking 拉起应用市场本应用详情页（ohos.want.action.appdetail +
  // store://appgallery.huawei.com/app/detail?id=<bundleName>，见 AppGallery Kit 文档）
  private openAppGalleryDetail(): void {
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    const want: Want = {
      action: 'ohos.want.action.appdetail',
      uri: `store://appgallery.huawei.com/app/detail?id=${context.abilityInfo.bundleName}`
    }
    context.startAbility(want).catch(() => {
      console.error('open appgallery detail failed')
    })
  }
}

@Builder
export function SettingsAboutPageBuilder() {
  SettingsAboutPage()
}
