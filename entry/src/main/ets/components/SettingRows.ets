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
    Column() {
      Text(this.rowLabel)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
      if (hasText(this.rowValue)) {
        Text(this.rowValue)
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .maxLines(1)
          .margin({ top: 2 })
      }
      if (hasText(this.rowDesc)) {
        Text(this.rowDesc)
          .fontSize(12)
          .fontColor($r('app.color.fg_secondary'))
          .maxLines(2)
          .margin({ top: 2 })
      }
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 13, bottom: 13 })
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

  build() {
    Row({ space: 12 }) {
      Circle({ width: 18, height: 18 })
        .fill(this.isSelected ? $r('app.color.accent') : Color.Transparent)
        .stroke(this.isSelected ? $r('app.color.accent') : $r('app.color.fg_secondary'))
        .strokeWidth(1.5)
      Text(this.rowLabel)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .layoutWeight(1)
        .maxLines(1)
    }
    .width('100%')
    .height(52)
    .padding({ left: 16, right: 16 })
    .onClick(() => {
      this.onTapRow()
    })
  }
}

// 隐私页视频同款行：右侧圆形单选点（选中填充带辉光）+ 按下整行高亮 + 触点波纹扩散（自定义 Ripple）
@ComponentV2
export struct SettingCheckRow {
  @Param @Require rowLabel: ResourceStr = ''
  @Param rowDesc: ResourceStr = ''
  @Param @Require isChecked: boolean = false
  @Event onCheckRow: (isOn: boolean) => void = (isOn: boolean) => {}
  @Local pressed: boolean = false
  @Local rippleX: number = 0
  @Local rippleY: number = 0
  @Local rippleScale: number = 0
  @Local rippleOpacity: number = 0

  private setPressed(on: boolean): void {
    if (this.pressed === on) {
      return
    }
    this.getUIContext().animateTo({ duration: on ? 90 : 260, curve: on ? Curve.EaseOut : Curve.EaseIn }, () => {
      this.pressed = on
    })
  }

  // 触点波纹：按下从触点扩散圆形渐隐，逼近 Material Ripple（ArkUI 无内置波纹）
  private startRipple(x: number, y: number): void {
    this.rippleX = x
    this.rippleY = y
    this.getUIContext().animateTo({ duration: 0 }, () => {
      this.rippleScale = 0.2
      this.rippleOpacity = 0.25
    })
    this.getUIContext().animateTo({ duration: 350, curve: Curve.EaseOut }, () => {
      this.rippleScale = 1
      this.rippleOpacity = 0
    })
  }

  private fadeRipple(): void {
    this.getUIContext().animateTo({ duration: 200, curve: Curve.EaseOut }, () => {
      this.rippleOpacity = 0
    })
  }

  build() {
    Stack({ alignContent: Alignment.Start }) {
      Row() {
        Column() {
          Text(this.rowLabel)
            .fontSize(15)
            .fontColor($r('app.color.fg'))
            .maxLines(1)
          if (hasText(this.rowDesc)) {
            Text(this.rowDesc)
              .fontSize(12)
              .fontColor($r('app.color.fg_secondary'))
              .maxLines(2)
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

      if (this.rippleOpacity > 0) {
        Circle()
          .width(320)
          .height(320)
          .fill('#40FFFFFF')
          .opacity(this.rippleOpacity)
          .scale({ x: this.rippleScale, y: this.rippleScale })
          .position({ x: this.rippleX - 160, y: this.rippleY - 160 })
      }
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 20, bottom: 20 })
    .backgroundColor(this.pressed ? 'rgba(255,255,255,0.10)' : Color.Transparent)
    .clip(true)
    .onTouch((event: TouchEvent) => {
      if (event.type === TouchType.Down) {
        if (event.touches.length > 0) {
          this.startRipple(event.touches[0].x, event.touches[0].y)
        }
        this.setPressed(true)
      } else if (event.type === TouchType.Up || event.type === TouchType.Cancel) {
        this.fadeRipple()
        this.setPressed(false)
      }
    })
    .onClick(() => {
      this.onCheckRow(!this.isChecked)
    })
  }
}
