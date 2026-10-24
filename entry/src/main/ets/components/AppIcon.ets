@ComponentV2
export struct AppIcon {
  @Param @Require icon: Resource
  @Param iconSize: number = 24
  @Param iconColor: ResourceColor = $r('app.color.fg')

  build() {
    SymbolGlyph(this.icon)
      .fontSize(this.iconSize)
      .fontColor([this.iconColor])
  }
}
