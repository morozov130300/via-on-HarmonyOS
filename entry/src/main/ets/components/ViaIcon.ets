import { common } from '@kit.AbilityKit'
import { SkinStore } from '../common/SkinStore'

@ComponentV2
export struct ViaIcon {
  @Param @Require icon: Resource
  @Param iconSize: number = 24
  @Param iconColor: ResourceColor = $r('app.color.fg')
  // 原版 lb.b.a：皮肤图标名（如 ic_menu_night）。非空且当前皮肤目录存在 <name>.png
  // 时用皮肤位图替换默认资源（lb.a.b 96x96 BitmapDrawable），空串走默认资源
  @Param iconName: string = ''
  // Grid 拖拽场景（如定制菜单宫格）内置的 Image 拖拽会抢走宿主 GridItem 的拖拽事件，
  // 需要在宫格内禁用（ faqs-arkui-1188），因此暴露开关，默认保持原行为
  @Param imageDraggable: boolean = true

  // 等价原版 PorterDuff.SRC_IN 着色：out.rgb = color.rgb * src.alpha，out.a = src.a * color.a
  // 对纯黑/纯白 alpha 蒙版 PNG（via_menu_* / via_ic_*）均生效
  @Computed
  get tintMatrix(): number[] {
    const c: number = this.resolveColor();
    const a: number = ((c >>> 24) & 0xFF) / 255;
    const r: number = (c >>> 16) & 0xFF;
    const g: number = (c >>> 8) & 0xFF;
    const b: number = c & 0xFF;
    return [0, 0, 0, r, 0,
      0, 0, 0, g, 0,
      0, 0, 0, b, 0,
      0, 0, 0, a, 0];
  }

  // 原版 lb.a.a：当前皮肤下存在 <iconName>.png 则返回其路径（皮肤需重启生效，无需响应式）
  private skinPath(): string | null {
    if (this.iconName === '') {
      return null
    }
    const context = getContext(this) as common.Context
    return SkinStore.getInstance().skinIconPath(context, this.iconName)
  }

  private resolveColor(): number {
    const colorValue: ResourceColor = this.iconColor;
    if (typeof colorValue === 'number') {
      return colorValue as number;
    }
    if (typeof colorValue === 'string') {
      return ViaIcon.parseHexColor(colorValue as string);
    }
    try {
      const res: Resource = colorValue as Resource;
      return getContext(this).resourceManager.getColorSync(res);
    } catch (error) {
      return 0xFFFFFFFF;
    }
  }

  private static parseHexColor(hexStr: string): number {
    let hex: string = hexStr.startsWith('#') ? hexStr.substring(1) : hexStr;
    if (hex.length === 3) {
      const r3: number = parseInt(hex.substring(0, 1), 16) * 17;
      const g3: number = parseInt(hex.substring(1, 2), 16) * 17;
      const b3: number = parseInt(hex.substring(2, 3), 16) * 17;
      return (0xFF << 24) | (r3 << 16) | (g3 << 8) | b3;
    }
    if (hex.length === 6) {
      return (0xFF << 24) | parseInt(hex, 16);
    }
    if (hex.length === 8) {
      return parseInt(hex, 16);
    }
    return 0xFFFFFFFF;
  }

  build() {
    if (this.skinPath() !== null) {
      // 皮肤位图（lb.a.b）：按原样渲染，同菜单 ImageView 主题着色
      Image(`file://${this.skinPath()}`)
        .width(this.iconSize)
        .height(this.iconSize)
        .objectFit(ImageFit.Contain)
        .colorFilter(this.tintMatrix)
        .draggable(this.imageDraggable)
    } else {
      Image(this.icon)
        .width(this.iconSize)
        .height(this.iconSize)
        .objectFit(ImageFit.Contain)
        .colorFilter(this.tintMatrix)
        .draggable(this.imageDraggable)
    }
  }
}
