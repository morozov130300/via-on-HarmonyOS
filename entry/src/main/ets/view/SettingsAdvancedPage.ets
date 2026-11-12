import { AppSettings } from '../common/Settings'
import { SslWhitelistStore } from '../common/SslWhitelist'
import { common } from '@kit.AbilityKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { computeDialogWidthVp } from '../components/UiaDialogCard'
import { dialogTransition } from '../common/Transitions'
import { SettingNavRow, SettingCheckRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'

@ComponentV2
export struct SettingsAdvancedPage {
  private settings: AppSettings = AppSettings.getInstance()
  private sslStore: SslWhitelistStore = SslWhitelistStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local sslAck: boolean = false
  // 确认钮未勾选时的水平抖动位移（原版 w5/k y.X：±24dp/280ms ×2 反转）
  @Local sslConfirmShake: number = 0
  private sslDialogId: number = -1

  aboutToAppear(): void {
    const context = getContext(this) as common.Context
    this.sslStore.init(context)
  }

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.advanced'),
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
              rowLabel: $r('app.string.data_saver'),
              rowDesc: $r('app.string.data_saver_desc'),
              isChecked: this.settings.dataSaver,
              onCheckRow: (isOn: boolean) => {
                this.settings.setDataSaver(isOn)
              }
            })
            SettingCheckRow({
              rowLabel: $r('app.string.auto_sniff_button'),
              isChecked: this.settings.autoSniffButton,
              onCheckRow: (isOn: boolean) => {
                this.settings.setAutoSniffButton(isOn)
              }
            })
            SettingCheckRow({
              rowLabel: $r('app.string.allow_web_debug'),
              isChecked: this.settings.allowDebugWeb,
              onCheckRow: (isOn: boolean) => {
                this.toggleDebugWeb(isOn)
              }
            })
            SettingCheckRow({
              rowLabel: $r('app.string.disable_safe_browsing'),
              rowDesc: $r('app.string.orig_yo'),
              isChecked: this.settings.disableSafeBrowsing,
              onCheckRow: (isOn: boolean) => {
                this.settings.setDisableSafeBrowsing(isOn)
              }
            })
            // 原版 hb/z.k3：行摘要固定 yx「请小心，忽略 SSL 证书警告可能会使网站的连接不安全」；
            // 点击 → 白名单空时弹窗（yv 标题 + n_ 正文 + yw 复选框默认不勾 + ok/cancel），
            // 确定后进入 SSL 白名单页；本端白名单机制以全局开关落地（TabWeb 消费）
            SettingNavRow({
              rowLabel: $r('app.string.ignore_ssl_warning'),
              rowValue: $r('app.string.orig_yx'),
              onTapRow: () => {
                this.onSslRowTap()
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

  // 原版 hb/z.java:107-114：开启「允许调试网页」后弹说明对话框（u.Oh + u.Ph）
  private toggleDebugWeb(isOn: boolean): void {
    this.settings.setAllowDebugWeb(isOn)
    if (isOn) {
      AlertDialog.show({
        title: $r('app.string.allow_web_debug'),
        message: $r('app.string.orig_a1o'),
        confirm: {
          value: $r('app.string.confirm'),
          action: () => {
          }
        }
      })
    }
  }

  // 原版 hb/z.java k3()（:133-144）：
  //   if (w9.l.G2() != 0) { g6.i.g(this, g4.class); }   ← 掩码非 0 直接进白名单页 hb/g4
  //   else { w5.k.l(I()).d0(Yf 忽略 SSL 证书警告).I(n_ 正文).w(Zf, false).M(true)
  //          .V(ok, z.g3).N(cancel, null).f0(); }
  // 掩码读工程已持久化的 ignoredsslwarning（SslWhitelistStore.mask，与 Settings.ets 同库 uia_settings）
  private onSslRowTap(): void {
    const context = getContext(this) as common.Context
    this.sslStore.init(context).then(() => {
      if (this.sslStore.mask !== 0) {
        this.openSslWhitelist()
      } else {
        this.showSslWarningDialog()
      }
    }).catch((error: BusinessError) => {
      console.error(`read ssl whitelist mask failed: ${error.message}`)
      this.showSslWarningDialog()
    })
  }

  private openSslWhitelist(): void {
    this.navPathStack.pushPathByName('sslWhitelist', '', true)
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

  // 原版 w5/k y.X（g6.y.X 同款）：±24dp、280ms、×2 反转的水平抖动
  private shakeSslConfirm(): void {
    this.getUIContext().keyframeAnimateTo({ iterations: 2 }, [
      { duration: 70, curve: Curve.Linear, event: () => { this.sslConfirmShake = -24 } },
      { duration: 70, curve: Curve.Linear, event: () => { this.sslConfirmShake = 24 } },
      { duration: 70, curve: Curve.Linear, event: () => { this.sslConfirmShake = -12 } },
      { duration: 70, curve: Curve.Linear, event: () => { this.sslConfirmShake = 0 } }
    ])
  }

  @Builder
  SslDialog() {
    Column() {
      Text($r('app.string.ignore_ssl_warning'))
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Text($r('app.string.orig_n_'))
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
        Text($r('app.string.orig_yw'))
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
          .translate({ x: this.sslConfirmShake })
          .onClick(() => {
            // 原版 w5/k.java:239 'if (!f13319h || f13338b)'：未勾选复选框时确认钮
            // 只执行 y.X 抖动（24dp/280ms ×2 反转），不回调跳页。
            if (!this.sslAck) {
              this.shakeSslConfirm()
              return
            }
            // 原版 z.g3（hb/z.java:34-37）→ g6.i.g(z, g4.class)：确认后跳 SSL 白名单页，
            // 不写任何设置值（掩码只由白名单页 g4.j3 → w9/k.a → ignoredsslwarning 写入）
            this.closeSslDialog()
            this.openSslWhitelist()
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
