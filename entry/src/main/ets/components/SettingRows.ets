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
export struct SettingToggleRow {
  @Param @Require rowLabel: ResourceStr = ''
  @Param rowDesc: ResourceStr = ''
  @Param @Require isToggleOn: boolean = false
  @Event onToggleRow: (isOn: boolean) => void = (isOn: boolean) => {}

  build() {
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

      Toggle({ type: ToggleType.Switch, isOn: this.isToggleOn })
        .selectedColor($r('app.color.accent'))
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
