@ComponentV2
export struct ViaIcon {
  @Param @Require icon: Resource
  @Param iconSize: number = 24
  @Param iconColor: ResourceColor = $r('app.color.fg')

  build() {
    Image(this.icon)
      .width(this.iconSize)
      .height(this.iconSize)
      .objectFit(ImageFit.Contain)
      .fillColor(this.iconColor)
  }
}
