import { AppSettings } from '../common/Settings'
import { computeDialogWidthVp } from '../components/ViaDialogCard'
import { dialogTransition } from '../common/Transitions'
import { SettingNavRow, SettingCheckRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'

@ComponentV2
export struct SettingsAdvancedPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local sslAck: boolean = false
  private sslDialogId: number = -1

  private bindAppBar(): void {
    AppBar.show({
      title: '高级',
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
                this.toggleDebugWeb(isOn)
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
            // 原版 hb/z.k3：行摘要固定 yx「请小心，忽略 SSL 证书警告可能会使网站的连接不安全」；
            // 点击 → 白名单空时弹窗（yv 标题 + n_ 正文 + yw 复选框默认不勾 + ok/cancel），
            // 确定后进入 SSL 白名单页；本端白名单机制以全局开关落地（TabWeb 消费）
            SettingNavRow({
              rowLabel: '忽略 SSL 证书警告',
              rowValue: '请小心，忽略 SSL 证书警告可能会使网站的连接不安全',
              onTapRow: () => {
                this.showSslWarningDialog()
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

  // 原版 hb/z.java:107-114：开启「允许调试网页」后弹说明对话框（u.Oh + u.Ph）
  private toggleDebugWeb(isOn: boolean): void {
    this.settings.setAllowDebugWeb(isOn)
    if (isOn) {
      AlertDialog.show({
        title: '允许调试网页',
        message: '现在你可以将手机连上电脑，然后在 Chrome 电脑版上通过 "chrome://inspect" 来调试网页。别忘了先开启设置中开发者选项里的 USB 调试。',
        confirm: {
          value: '确定',
          action: () => {
          }
        }
      })
    }
  }

  // 原版 hb/z.k3：w5.k.l(I()).d0(yv 忽略 SSL 证书警告).I(n_ 正文)
  // .w(yw 我了解这可能导致连接不安全, false).M(true).V(ok).N(cancel).f0()
  private showSslWarningDialog(): void {
    this.sslAck = false
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.SslDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.sslDialogId = dialogId
    }).catch(() => {
      console.error('open ssl dialog failed')
    })
  }

  private closeSslDialog(): void {
    if (this.sslDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.sslDialogId)
    this.sslDialogId = -1
  }

  @Builder
  SslDialog() {
    Column() {
      Text('忽略 SSL 证书警告')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Text('SSL 证书用于验证网站身份和加密连接。这就像是把信放在信封中再寄出，只有你和网站可以拆开这封信。\n\n一旦你忽略 SSL 警告，则与网站的连接可能不安全，这意味着与网站传输的数据可能被人窃取。这就像把信放在一个破损的信封上然后寄出它，伪造证书的人可以拆开它。')
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .lineHeight(21)
        .width('100%')
        .padding({ left: 16, right: 16, top: 8, bottom: 8 })
      // 原版 w5.k.w(Zf, false)：复选框默认不勾，文字 yw
      Row({ space: 10 }) {
        Checkbox()
          .select(this.sslAck)
          .selectedColor($r('app.color.accent'))
          .onChange((value: boolean) => {
            this.sslAck = value
          })
        Text('我了解这可能导致连接不安全')
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .layoutWeight(1)
          .onClick(() => {
            this.sslAck = !this.sslAck
          })
      }
      .width('100%')
      .alignItems(VerticalAlign.Center)
      .padding({ left: 16, right: 16, top: 8, bottom: 8 })
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeSslDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.settings.setIgnoreSslWarning(true)
            this.closeSslDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16, top: 12 })
    }
    .width('100%')
    .constraintSize({ maxWidth: 300 })
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }
}

@Builder
export function SettingsAdvancedPageBuilder() {
  SettingsAdvancedPage()
}
