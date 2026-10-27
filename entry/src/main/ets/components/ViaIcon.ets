@ComponentV2
export struct ViaIcon {
  @Param @Require icon: Resource
  @Param iconSize: number = 24
  @Param iconColor: ResourceColor = $r('app.color.fg')
  // Grid 拖拽场景（如定制菜单宫格）内置的 Image 拖拽会抢走宿主 GridItem 的拖拽事件，
  // 需要在宫格内禁用（ faqs-arkui-1188），因此暴露开关，默认保持原行为
  @Param imageDraggable: boolean = true

  build() {
    Image(this.icon)
      .width(this.iconSize)
      .height(this.iconSize)
      .objectFit(ImageFit.Contain)
      .fillColor(this.iconColor)
      .draggable(this.imageDraggable)
  }
}
