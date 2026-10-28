import { AppSettings } from '../common/Settings'
import { SettingNavRow, SettingCheckRow } from '../components/SettingRows'
import { SettingsHeader } from '../components/SettingsHeader'

@ComponentV2
export struct SettingsAdvancedPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local sslAck: boolean = false
  private sslDialogId: number = -1

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '高级',
          onBack: () => {
            this.navPathStack.pop()
          }
        })
        Scroll() {
          Column() {
            SettingCheckRow({
              rowLabel: '流量节省',
              rowDesc: '请求网站节省流量',
              isChecked: this.settings.dataSaver,
              onCheckRow: (isOn: boolean) => {
                this.settings.setDataSaver(isOn)
              }
            })
            SettingCheckRow({
              rowLabel: '自动展示嗅探按钮',
              isChecked: this.settings.autoSniffButton,
              onCheckRow: (isOn: boolean) => {
                this.settings.setAutoSniffButton(isOn)
              }
            })
            SettingCheckRow({
              rowLabel: '允许调试网页',
              isChecked: this.settings.allowDebugWeb,
              onCheckRow: (isOn: boolean) => {
                this.settings.setAllowDebugWeb(isOn)
              }
            })
            SettingCheckRow({
              rowLabel: '禁用 Custom Tabs',
              rowDesc: '跳过第三方应用通过 Custom Tabs 打开链接时的中转页',
              isChecked: this.settings.disableCustomTabs,
              onCheckRow: (isOn: boolean) => {
                this.settings.setDisableCustomTabs(isOn)
              }
            })
            SettingCheckRow({
              rowLabel: '禁用安全浏览',
              rowDesc: '安全浏览允许 WebView 通过验证链接来防止恶意软件和网络钓鱼攻击',
              isChecked: this.settings.disableSafeBrowsing,
              onCheckRow: (isOn: boolean) => {
                this.settings.setDisableSafeBrowsing(isOn)
              }
            })
            SettingNavRow({
              rowLabel: '忽略 SSL 证书警告',
              rowValue: this.settings.ignoreSslWarning
                ? '已忽略，点击可恢复默认'
                : '请小心，忽略 SSL 证书警告可能会使网站的连接不安全',
              onTapRow: () => {
                this.toggleSslWarning()
              }
            })
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
    })
  }

  private toggleSslWarning(): void {
    if (this.settings.ignoreSslWarning) {
      this.settings.setIgnoreSslWarning(false)
      this.getUIContext().getPromptAction().showToast({ message: '已恢复 SSL 证书警告', duration: 1500 })
      return
    }
    this.sslAck = false
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: () => {
        this.SslDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center
    }).then((dialogId: number) => {
      this.sslDialogId = dialogId
    }).catch(() => {
      console.error('open ssl dialog failed')
    })
  }

  private closeSslDialog(): void {
    if (this.sslDialogId >= 0) {
      try {
        this.getUIContext().getPromptAction().closeCustomDialog(this.sslDialogId)
      } catch (error) {
        console.error('close ssl dialog failed')
      }
    }
  }

  @Builder
  SslDialog() {
    Column({ space: 14 }) {
      Text('忽略 SSL 证书警告')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
      Text('SSL 证书用于验证网站身份和加密连接。这就像是把信放在信封中再寄出，只有你和网站可以拆开这封信。\n\n一旦你忽略 SSL 警告，则与网站的连接可能不安全，这意味着与网站传输的数据可能被人窃取。这就像把信放在一个破损的信封上然后寄出它，伪造证书的人可以拆开它。')
        .fontSize(13)
        .fontColor($r('app.color.fg_secondary'))
      Row({ space: 8 }) {
        Checkbox({ name: 'ssl_ack', group: 'ssl' })
          .select(this.sslAck)
          .selectedColor($r('app.color.accent'))
          .onChange((value: boolean) => {
            this.sslAck = value
          })
        Text('我了解这可能导致连接不安全')
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .layoutWeight(1)
      }
      .width('100%')
      .onClick(() => {
        this.sslAck = !this.sslAck
      })
      Row({ space: 12 }) {
        Button('取消')
          .fontSize(15)
          .layoutWeight(1)
          .backgroundColor($r('app.color.page_bg'))
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            this.closeSslDialog()
          })
        Button('确定')
          .fontSize(15)
          .layoutWeight(1)
          .enabled(this.sslAck)
          .opacity(this.sslAck ? 1 : 0.4)
          .onClick(() => {
            if (!this.sslAck) {
              return
            }
            this.settings.setIgnoreSslWarning(true)
            this.closeSslDialog()
          })
      }
      .width('100%')
    }
    .width('100%')
    .padding(20)
    .backgroundColor($r('app.color.page_bg'))
    .borderRadius(16)
  }
}

@Builder
export function SettingsAdvancedPageBuilder() {
  SettingsAdvancedPage()
}
