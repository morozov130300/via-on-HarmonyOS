import { common } from '@kit.AbilityKit'
import { SslWhitelistStore, SSL_BIT_UNTRUSTED, SSL_BIT_DATE_INVALID, SSL_BIT_EXPIRED, SSL_BIT_ID_MISMATCH,
  SSL_BIT_NOT_YET_VALID, SSL_BIT_INVALID } from '../common/SslWhitelist'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { BusinessError } from '@kit.BasicServicesKit'
import { computeDialogWidthVp } from '../components/ViaDialogCard'
import { dialogTransition } from '../common/Transitions'

// 原版 hb/g4：忽略 SSL 证书警告页（1:1）
// 6 个 a6.g 复选行（g4.i3：bit = 1 << i10，行序 = X1 添加顺序）：
//   ur 证书不受信任(bit1) / um 证书日期无效(bit2) / uo 证书已过期(bit4) /
//   un 证书域名与网站域名不匹配(bit8) / uq 证书尚未生效(bit16) / up 证书无效(bit32)
// 切换即时生效（g4.j3 → w9/k.a → ignoredsslwarning）。
// 工具栏右侧 k9 帮助 → 弹窗（标题 yv、正文 n_、确定）。
// Web 层消费点：TabWeb.onSslErrorEventReceive 按 e8/h0.v() 语义 (mask & I) == I 放行（主控接线）。

// 原版 n_（values-zh-rCN strings.xml）：SSL 证书说明正文
const SSL_HELP_MESSAGE: string = 'SSL 证书用于验证网站身份和加密连接。这就像是把信放在信封中再寄出，只有你和网站可以拆开这封信。\n\n' +
  '一旦你忽略 SSL 警告，则与网站的连接可能不安全，这意味着与网站传输的数据可能被人窃取。这就像把信放在一个破损的信封上然后寄出它，伪造证书的人可以拆开它。'

// g4.X1 行序与位表（1 << i10）
export class SslRow {
  readonly bit: number
  readonly label: string

  constructor(bit: number, label: string) {
    this.bit = bit
    this.label = label
  }

  static rows(): SslRow[] {
    return [
      new SslRow(SSL_BIT_UNTRUSTED, '证书不受信任'),
      new SslRow(SSL_BIT_DATE_INVALID, '证书日期无效'),
      new SslRow(SSL_BIT_EXPIRED, '证书已过期'),
      new SslRow(SSL_BIT_ID_MISMATCH, '证书域名与网站域名不匹配'),
      new SslRow(SSL_BIT_NOT_YET_VALID, '证书尚未生效'),
      new SslRow(SSL_BIT_INVALID, '证书无效')
    ]
  }
}

@ComponentV2
export struct SslWhitelistPage {
  private navPathStack: NavPathStack = new NavPathStack()
  private store: SslWhitelistStore = SslWhitelistStore.getInstance()
  // 帮助弹窗（w5.k.d0(yv).I(n_).V(ok).f0()）
  @Local helpDialogId: number = -1

  aboutToAppear(): void {
    const context = getContext(this) as common.Context
    this.store.init(context)
  }

  private bindAppBar(): void {
    AppBar.show({
      title: '忽略 SSL 证书警告',
      rightText: '帮助',
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight: () => {
        this.openHelpDialog()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            ForEach(SslRow.rows(), (row: SslRow) => {
              Row({ space: 12 }) {
                Column() {
                  Text(row.label)
                    .fontSize(15)
                    .fontColor($r('app.color.fg'))
                    .maxLines(2)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                }
                .alignItems(HorizontalAlign.Start)
                .layoutWeight(1)
                Circle({ width: 20, height: 20 })
                  .fill((this.store.mask & row.bit) === row.bit ? $r('app.color.accent') : Color.Transparent)
                  .stroke((this.store.mask & row.bit) === row.bit ? $r('app.color.accent') : $r('app.color.fg_secondary'))
                  .strokeWidth(1.5)
              }
              .width('100%')
              .padding({ left: 16, right: 16, top: 20, bottom: 20 })
              .alignItems(VerticalAlign.Center)
              .onClick(() => {
                // g4.j3：已置位则清除，否则置位
                this.store.toggleBit(row.bit)
              })
            }, (row: SslRow) => `${row.bit}`)
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

  // a3()：工具栏 k9 帮助 → d0(yv).I(n_).V(ok).f0()
  private openHelpDialog(): void {
    this.getUIContext().getPromptAction().openCustomDialog({
      width: computeDialogWidthVp(),
      builder: (): void => {
        this.HelpDialog()
      },
      isModal: true,
      backgroundColor: Color.Transparent,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.helpDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open ssl help dialog failed: ${error.message}`)
    })
  }

  @Builder
  HelpDialog() {
    Column() {
      Text('忽略 SSL 证书警告')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Scroll() {
        Text(SSL_HELP_MESSAGE)
          .fontSize(14)
          .fontColor($r('app.color.fg_secondary'))
          .width('100%')
      }
      .constraintSize({ maxHeight: 360 })
      .margin({ left: 16, right: 16 })
      Row() {
        Blank()
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeHelpDialog()
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

  private closeHelpDialog(): void {
    if (this.helpDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.helpDialogId)
    this.helpDialogId = -1
  }
}

@Builder
export function SslWhitelistPageBuilder() {
  SslWhitelistPage()
}
