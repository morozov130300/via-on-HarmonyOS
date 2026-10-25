import { pasteboard } from '@kit.BasicServicesKit'
import { TabStore } from '../common/TabStore'

const CONTACT_QQ_GROUP_URL: string = 'http://viayoo.com/contact/qqgroup/'
const CONTACT_WECHAT_URL: string = 'http://viayoo.com/contact/wechat/'
const TERMS_OF_USE_URL: string = 'https://viayoo.com/zh-cn/docs/terms-of-use.html'
const PRIVACY_POLICY_URL: string = 'https://viayoo.com/zh-cn/docs/privacy-policy.html'
const CONTACT_EMAIL: string = 'yafengtu@gmail.com'

@ComponentV2
export struct SettingsAboutPage {
  private tabStore: TabStore = TabStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  build() {
    NavDestination() {
      Scroll() {
        Column() {
          Column({ space: 6 }) {
            Text('Via')
              .fontSize(24)
              .fontColor($r('app.color.fg'))
            Text('7.3.3')
              .fontSize(14)
              .fontColor($r('app.color.fg_secondary'))
          }
          .width('100%')
          .margin({ top: 60, bottom: 40 })

          this.AboutRow('检查更新', () => {
            this.getUIContext().getPromptAction().showToast({ message: $r('app.string.latest_version'), duration: 1500 })
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
      .height('100%')
      .align(Alignment.Top)
    }
    .backgroundColor($r('app.color.page_bg'))
    .title('关于')
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
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

  private copyEmail(): void {
    const data = pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, CONTACT_EMAIL)
    pasteboard.getSystemPasteboard().setData(data).then(() => {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.email_copied'), duration: 1500 })
    }).catch(() => {
      console.error('copy email failed')
    })
  }

  private notImplemented(): void {
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.feature_wip'), duration: 1500 })
  }
}

@Builder
export function SettingsAboutPageBuilder() {
  SettingsAboutPage()
}
