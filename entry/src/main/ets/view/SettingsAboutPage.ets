import { pasteboard } from '@kit.BasicServicesKit'
import { common, Want } from '@kit.AbilityKit'
import { TabStore } from '../common/TabStore'
import { UpdateChecker, UpdateConfig } from '../common/UpdateChecker'
import { AppBar, AppBarSpacer } from '../components/AppBar'

const CONTACT_QQ_GROUP_URL: string = 'http://viayoo.com/contact/qqgroup/'
const CONTACT_WECHAT_URL: string = 'http://viayoo.com/contact/wechat/'
const TERMS_OF_USE_URL: string = 'https://viayoo.com/zh-cn/docs/terms-of-use.html'
const PRIVACY_POLICY_URL: string = 'https://viayoo.com/zh-cn/docs/privacy-policy.html'
const CONTACT_EMAIL: string = 'yafengtu@gmail.com'

@ComponentV2
export struct SettingsAboutPage {
  private tabStore: TabStore = TabStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

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
          Column({ space: 6 }) {
            Text('Via')
              .fontSize(24)
              .fontColor($r('app.color.fg'))
            Text('7.4.0.b13.edf6737e')
              .fontSize(14)
              .fontColor($r('app.color.fg_secondary'))
          }
          .width('100%')
          .margin({ top: 60, bottom: 40 })

          this.AboutRow('检查更新', () => {
            this.checkUpdate()
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
            this.notImplemented()
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

  private notImplemented(): void {
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.feature_wip'), duration: 1500 })
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
