@ComponentV2
export struct SettingNavRow {
  @Param @Require rowLabel: string = ''
  @Param rowValue: string = ''
  @Event onTapRow: () => void = () => {}

  build() {
    Column() {
      Text(this.rowLabel)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
      if (this.rowValue !== '') {
        Text(this.rowValue)
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .maxLines(1)
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
export struct SettingToggleRow {  @Param @Require rowLabel: string = ''
  @Param rowDesc: string = ''
  @Param @Require isToggleOn: boolean = false
  @Event onToggleRow: (isOn: boolean) => void = (isOn: boolean) => {}

  build() {
    Row() {
      Column() {
        Text(this.rowLabel)
          .fontSize(15)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
        if (this.rowDesc !== '') {
          Text(this.rowDesc)
            .fontSize(12)
            .fontColor($r('app.color.fg_secondary'))
            .maxLines(2)
            .margin({ top: 2 })
        }
      }
      .alignItems(HorizontalAlign.Start)
      .layoutWeight(1)

      Toggle({ type: ToggleType.Switch, isOn: this.isToggleOn })
        .onChange((value: boolean) => {
          this.onToggleRow(value)
        })
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 13, bottom: 13 })
    .alignItems(VerticalAlign.Center)
  }
}

@ComponentV2
export struct SettingRadioRow {
  @Param @Require rowLabel: string = ''
  @Param @Require isSelected: boolean = false
  @Event onTapRow: () => void = () => {}

  build() {
    Row() {
      Text(this.rowLabel)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .layoutWeight(1)
      if (this.isSelected) {
        Circle()
          .fill($r('app.color.accent'))
          .width(20)
          .height(20)
      } else {
        Circle()
          .fill(Color.Transparent)
          .stroke($r('app.color.fg_secondary'))
          .strokeWidth(1)
          .width(20)
          .height(20)
      }
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 13, bottom: 13 })
    .alignItems(VerticalAlign.Center)
    .onClick(() => {
      this.onTapRow()
    })
  }
}
