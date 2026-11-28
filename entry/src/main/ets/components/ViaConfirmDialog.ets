import { ComponentContent, UIContext } from '@kit.ArkUI'
import { BusinessError } from '@kit.BasicServicesKit'
import { computeDialogWidthVp, dialogTransition } from './ViaDialogCard'
import { UiaDialogButton } from './UiaDialogButton'

// 原版 w5.k 确认弹窗（layout u.xml + drawable t/u + theme n）：
// 标题 16sp 粗体、正文 14sp、动作 14sp 蓝字右对齐、18dp 圆角 + 1dp 描边、dim 0.4。
// 用于统一替换鸿蒙系统 AlertDialog（系统样式与原版卡片不一致）。
@ComponentV2
export struct ViaConfirmDialog {
  @Param title: ResourceStr = ''
  @Param @Require message: ResourceStr
  @Param leftLabel: ResourceStr = ''
  @Param rightLabel: ResourceStr = ''
  @Event onLeft: () => void = (): void => {}
  @Event onRight: () => void = (): void => {}

  build() {
    Column() {
      if (this.title !== '') {
        Text(this.title)
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.dialog_text'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
          .width('100%')
          .padding({ left: 16, right: 16, top: 8, bottom: 8 })
          .margin({ bottom: 6 })
      }
      Scroll() {
        Text(this.message)
          .fontSize(14)
          .fontColor($r('app.color.dialog_text'))
          .width('100%')
          .padding({ left: 16, right: 16, top: 8, bottom: 8 })
      }
      .constraintSize({ maxHeight: 320 })

      Row() {
        Blank()
        UiaDialogButton({
          label: this.leftLabel,
          actionEnabled: this.leftLabel !== '',
          onAction: (): void => {
            this.onLeft()
          }
        })
        UiaDialogButton({
          label: this.rightLabel,
          actionEnabled: this.rightLabel !== '',
          onAction: (): void => {
            this.onRight()
          }
        })
      }
      .width('100%')
      .height(48)
      .alignItems(VerticalAlign.Center)
    }
    .width(computeDialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }
}

export class ViaDialogButtonSpec {
  value: ResourceStr = ''
  action?: () => void
  // 原版允许单项自定义文字色（如删除项用强调色）
  fontColor?: ResourceColor
}

// 兼容 AlertDialog.show / showAlertDialog 的原参数形态，便于逐点替换。
export class ViaConfirmOptions {
  title?: ResourceStr
  message: ResourceStr = ''
  primaryButton?: ViaDialogButtonSpec
  secondaryButton?: ViaDialogButtonSpec
  confirm?: ViaDialogButtonSpec
  cancel?: () => void
  autoCancel?: boolean
}

// ComponentContent 为 @Builder 提供 ArkUI 组件构建上下文。
class ViaConfirmRuntime {
  title: ResourceStr = ''
  message: ResourceStr = ''
  leftLabel: ResourceStr = ''
  rightLabel: ResourceStr = ''
  onLeft: () => void = (): void => {}
  onRight: () => void = (): void => {}
}

@Builder
function viaConfirmContent(rt: ViaConfirmRuntime): void {
  ViaConfirmDialog({
    title: rt.title,
    message: rt.message,
    leftLabel: rt.leftLabel,
    rightLabel: rt.rightLabel,
    onLeft: rt.onLeft,
    onRight: rt.onRight
  })
}

// 以原版卡片样式打开确认框；按钮按原顺序左右排布。
export function showViaConfirm(ctx: UIContext, opts: ViaConfirmOptions): void {
  let content: ComponentContent<ViaConfirmRuntime> | null = null
  const closeThen = (action?: () => void): void => {
    const dialogContent = content
    if (dialogContent !== null) {
      content = null
      ctx.getPromptAction().closeCustomDialog(dialogContent).then((): void => {
        dialogContent.dispose()
      }).catch((error: BusinessError): void => {
        console.error(`close confirm dialog failed: ${error.message}`)
        dialogContent.dispose()
      })
    }
    if (action !== undefined) {
      action()
    }
  }

  let leftLabel: ResourceStr = ''
  let rightLabel: ResourceStr = ''
  let leftAction: () => void = (): void => closeThen(opts.cancel)
  let rightAction: () => void = (): void => closeThen(opts.cancel)

  const primary = opts.primaryButton
  const secondary = opts.secondaryButton
  const confirmBtn = opts.confirm
  if (secondary !== undefined) {
    leftLabel = primary !== undefined ? primary.value : ''
    leftAction = (): void => closeThen(primary !== undefined ? primary.action : opts.cancel)
    rightLabel = secondary.value
    rightAction = (): void => closeThen(secondary.action)
  } else if (confirmBtn !== undefined) {
    rightLabel = confirmBtn.value
    rightAction = (): void => closeThen(confirmBtn.action)
  } else if (primary !== undefined) {
    rightLabel = primary.value
    rightAction = (): void => closeThen(primary.action)
  }

  const runtime = new ViaConfirmRuntime()
  runtime.title = opts.title !== undefined ? opts.title : ''
  runtime.message = opts.message
  runtime.leftLabel = leftLabel
  runtime.rightLabel = rightLabel
  runtime.onLeft = leftAction
  runtime.onRight = rightAction
  const dialogContent = new ComponentContent<ViaConfirmRuntime>(
    ctx,
    wrapBuilder<[ViaConfirmRuntime]>(viaConfirmContent),
    runtime
  )
  content = dialogContent
  ctx.getPromptAction().openCustomDialog(dialogContent, {
    isModal: true,
    autoCancel: opts.autoCancel !== undefined ? opts.autoCancel : true,
    alignment: DialogAlignment.Center
  }).catch((error: BusinessError): void => {
    if (content === dialogContent) {
      content = null
    }
    dialogContent.dispose()
    console.error(`open confirm dialog failed: ${error.message}`)
  })
}
