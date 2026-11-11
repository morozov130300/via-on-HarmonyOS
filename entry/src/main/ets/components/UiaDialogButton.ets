// 原版弹窗动作按钮（严格 1:1 复刻，禁止改成实心 Button）
//
// 逆向依据：
//  - D:\Uia\via_v7.4.0反编译产物\sources\w5\k.java  m() 第 986-1003 行：
//    弹窗底部动作是三个 TextView（id a1/b1/c1，对应布局 ep/eo/eq），不是 Button。
//  - resources\res\values\styles.xml  style x（144-150）/ style y（151-155）：
//    textSize @dimen/a_ = 14sp、textColor @color/p = #6F8DE1、gravity center、
//    background @drawable/o、minWidth 56dp、padding 16dp、ellipsize end、lines 1。
//  - resources\r\d\o.xml：selector，仅 state_pressed 生效，shape corners @dimen/ae = 18dp、
//    solid @color/l = #30808080；默认（未按下）完全透明。
//  - resources\r\f\u.xml 第 82-109 行：按钮行 LinearLayout gravity=end，
//    Space(weight=1) 把按钮整体推到右侧，按钮间无额外 margin。
//
// 因此：透明底 + 蓝字 + 右对齐 + 按下才出现 18dp 圆角灰底。
@ComponentV2
export struct UiaDialogButton {
  @Param @Require label: ResourceStr = ''
  @Param actionEnabled: boolean = true
  @Event onAction: () => void = () => {}

  build() {
    Text(this.label)
      .fontSize(14)
      .fontColor($r('app.color.dialog_action'))
      .maxLines(1)
      .textOverflow({ overflow: TextOverflow.Ellipsis })
      .textAlign(TextAlign.Center)
      .constraintSize({ minWidth: 56 })
      .padding({ left: 16, right: 16, top: 16, bottom: 16 })
      .borderRadius(18)
      .opacity(this.actionEnabled ? 1 : 0.4)
      .stateStyles({
        pressed: { .backgroundColor($r('app.color.dialog_btn_pressed')) },
        normal: { .backgroundColor(Color.Transparent) }
      })
      .onClick(() => {
        if (this.actionEnabled) {
          this.onAction()
        }
      })
  }
}
