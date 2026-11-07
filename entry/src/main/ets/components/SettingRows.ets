function hasText(value: ResourceStr): boolean {
  return typeof value === 'string' && (value as string) !== ''
}

@ComponentV2
export struct SettingNavRow {
  @Param @Require rowLabel: ResourceStr = ''
  @Param rowValue: ResourceStr = ''
  @Param rowDesc: ResourceStr = ''
  @Event onTapRow: () => void = () => {}

  build() {
    // 原版 a6/o.java：padding 左右 16 / 上下 20dp；标题 14sp（dimen a_）单行；
    // value 12sp（dimen aa）单行省略；desc 12sp 最多 3 行（o.java b() setMaxLines(3)）
    Column() {
      Text(this.rowLabel)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
      if (hasText(this.rowValue)) {
        Text(this.rowValue)
          .fontSize(12)
          .fontColor($r('app.color.fg_secondary'))
          .maxLines(1)
          .margin({ top: 2 })
      }
      if (hasText(this.rowDesc)) {
        Text(this.rowDesc)
          .fontSize(12)
          .fontColor($r('app.color.fg_secondary'))
          .maxLines(3)
          .margin({ top: 2 })
      }
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 20, bottom: 20 })
    .alignItems(HorizontalAlign.Start)
    .onClick(() => {
      this.onTapRow()
    })
  }
}

@ComponentV2
export struct SettingRadioRow {
  @Param @Require rowLabel: ResourceStr = ''
  @Param @Require isSelected: boolean = false
  @Event onTapRow: () => void = () => {}
  @Event onLongPressRow: () => void = () => {}

  build() {
    // 原版 v.xml + w5.d：16dp 圆形复选框 + drawablePadding 24 + 文字 14sp（dimen a_）；
    // CheckBox padding 上下 12dp（a3）→ 行高自适应约 40dp，非固定高
    Row({ space: 24 }) {
      Circle({ width: 16, height: 16 })
        .fill(this.isSelected ? $r('app.color.accent') : Color.Transparent)
        .stroke(this.isSelected ? $r('app.color.accent') : $r('app.color.fg_secondary'))
        .strokeWidth(1.5)
      Text(this.rowLabel)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .layoutWeight(1)
        .maxLines(1)
    }
    .width('100%')
    .padding({ left: 28, right: 16, top: 12, bottom: 12 })
    .onClick(() => {
      this.onTapRow()
    })
    .gesture(LongPressGesture()
      .onAction(() => {
        this.onLongPressRow()
      }))
  }
}

// 隐私页视频同款行：右侧圆形单选点（选中填充带辉光）+ 按下整行高亮
// 注意：不得插入带 .position() 的大尺寸波纹圆——该子组件会参与 Stack 布局，
// 插入/移除时行高被撑大再缩回，导致整段列表「弹开」跳动（见 20261031 录屏问题）
@ComponentV2
export struct SettingCheckRow {
  @Param @Require rowLabel: ResourceStr = ''
  @Param rowDesc: ResourceStr = ''
  @Param @Require isChecked: boolean = false
  @Event onCheckRow: (isOn: boolean) => void = (isOn: boolean) => {}
  @Local pressed: boolean = false

  private setPressed(on: boolean): void {
    if (this.pressed === on) {
      return
    }
    this.getUIContext().animateTo({ duration: on ? 90 : 260, curve: on ? Curve.EaseOut : Curve.EaseIn }, () => {
      this.pressed = on
    })
  }

  build() {
    // 原版 a6/o.java：padding 左右 16 / 上下 20dp；标题 14sp；desc 12sp 最多 3 行；
    // CheckBox 20dp（o.java:110 y.h(context, 20.0f)）
    Row() {
      Column() {
        Text(this.rowLabel)
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
        if (hasText(this.rowDesc)) {
          Text(this.rowDesc)
            .fontSize(12)
            .fontColor($r('app.color.fg_secondary'))
            .maxLines(3)
            .margin({ top: 2 })
        }
      }
      .alignItems(HorizontalAlign.Start)
      .layoutWeight(1)

      Circle({ width: 20, height: 20 })
        .fill(this.isChecked ? $r('app.color.accent') : Color.Transparent)
        .stroke(this.isChecked ? $r('app.color.accent') : $r('app.color.fg_secondary'))
        .strokeWidth(1.5)
        .shadow(this.isChecked ? { radius: 10, color: 'rgba(76,111,255,0.45)', offsetY: 0 } : { radius: 0, color: Color.Transparent, offsetY: 0 })
        .animation({ duration: 200, curve: Curve.EaseOut })
    }
    .width('100%')
    .alignItems(VerticalAlign.Center)
    .padding({ left: 16, right: 16, top: 20, bottom: 20 })
    .backgroundColor(this.pressed ? 'rgba(255,255,255,0.10)' : Color.Transparent)
    .onTouch((event: TouchEvent) => {
      if (event.type === TouchType.Down) {
        this.setPressed(true)
      } else if (event.type === TouchType.Up || event.type === TouchType.Cancel) {
        this.setPressed(false)
      }
    })
    .onClick(() => {
      this.onCheckRow(!this.isChecked)
    })
  }
}
