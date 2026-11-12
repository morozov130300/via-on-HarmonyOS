import { ViaIcon } from './ViaIcon'
import { UiInsets } from '../common/Immersive'

// 全局唯一标题栏：页面不再各自叠加头部，只在 onReady/onWillAppear 时改写
// 单例 AppBar 的标题与右侧动作；标题栏实体由 Index 根 Stack 渲染一次。
export interface AppBarSlots {
  title: ResourceStr
  rightText?: ResourceStr
  rightIcon?: Resource | null
  rightText2?: ResourceStr
  rightIcon2?: Resource | null
  onBack?: () => void
  onRight?: () => void
  onRight2?: () => void
  onTitle?: () => void
}

@ObservedV2
export class AppBar {
  private static instance: AppBar | null = null
  @Trace visible: boolean = false
  @Trace title: ResourceStr = ''
  @Trace rightText: ResourceStr = ''
  @Trace rightIcon: Resource | null = null
  @Trace rightText2: ResourceStr = ''
  @Trace rightIcon2: Resource | null = null
  private owner: object | null = null
  private backAction: (() => void) | null = null
  private rightAction: (() => void) | null = null
  private rightAction2: (() => void) | null = null
  private titleAction: (() => void) | null = null

  private constructor() {
  }

  static getInstance(): AppBar {
    if (AppBar.instance === null) {
      AppBar.instance = new AppBar()
    }
    return AppBar.instance
  }

  // 页面在 onReady / onWillAppear 时调用：改写当前显示的标题栏内容（静态网关）
  static show(slots: AppBarSlots, owner: object): void {
    AppBar.getInstance().apply(slots, owner)
  }

  // 页面在 onWillDisappear 时调用：只有自己仍是当前标题栏持有者时才收起
  static maybeHide(owner: object): void {
    AppBar.getInstance().clear(owner)
  }

  private apply(slots: AppBarSlots, owner: object): void {
    this.owner = owner
    this.title = slots.title
    this.rightText = slots.rightText ?? ''
    this.rightIcon = slots.rightIcon ?? null
    this.rightText2 = slots.rightText2 ?? ''
    this.rightIcon2 = slots.rightIcon2 ?? null
    this.backAction = slots.onBack ?? null
    this.rightAction = slots.onRight ?? null
    this.rightAction2 = slots.onRight2 ?? null
    this.titleAction = slots.onTitle ?? null
    this.visible = true
  }

  private clear(owner: object): void {
    if (this.owner !== owner) {
      return
    }
    this.owner = null
    this.backAction = null
    this.rightAction = null
    this.rightAction2 = null
    this.visible = false
  }

  fireBack(): void {
    if (this.backAction !== null) {
      this.backAction()
    }
  }

  fireRight(): void {
    if (this.rightAction !== null) {
      this.rightAction()
    }
  }

  fireRight2(): void {
    if (this.rightAction2 !== null) {
      this.rightAction2()
    }
  }

  fireTitle(): void {
    if (this.titleAction !== null) {
      this.titleAction()
    }
  }
}

// 页面内容顶部占位，高度与 AppBarHeader 一致，保证内容不被全局标题栏遮挡
@ComponentV2
export struct AppBarSpacer {
  private insets: UiInsets = UiInsets.getInstance()

  build() {
    Column()
      .width('100%')
      .height(54 + this.insets.top)
      .padding({ top: this.insets.top })
  }
}

// 标题栏实体，由 Index 在根 Stack 中渲染一次
// 完整复刻原版 com.tuyafeng.support.widget.z：
// 高 54dp，底边 2px 分割线 #30808080；返回按钮宽 48dp（左右 padding 13dp），
// 标题 16sp 粗体左对齐（weight 24），Spacer weight 1，右侧动作依次排列：
// 图标动作宽 48dp，文字动作 14sp 全大写（左右 padding 13dp），四周 margin 1dp。
@ComponentV2
export struct AppBarHeader {
  private bar: AppBar = AppBar.getInstance()
  private insets: UiInsets = UiInsets.getInstance()
  @Local dividerHeight: number = 1

  aboutToAppear(): void {
    this.dividerHeight = this.getUIContext().px2vp(2)
  }

  build() {
    if (this.bar.visible) {
      Column() {
        Row() {
          Stack({ alignContent: Alignment.Center }) {
            ViaIcon({ icon: $r('app.media.uia_ic_back'), iconSize: 22, iconColor: $r('app.color.appbar_icon') })
          }
            .width(48)
            .height(52)
            .padding({ left: 13, right: 13 })
            .margin({ top: 1, bottom: 1 })
            .onClick(() => {
              this.bar.fireBack()
            })
          Text(this.bar.title)
            .fontSize(16)
            .fontWeight(FontWeight.Bold)
            .fontColor($r('app.color.appbar_text'))
            .maxLines(1)
            .textOverflow({ overflow: TextOverflow.Ellipsis })
            .layoutWeight(24)
            .onClick(() => {
              this.bar.fireTitle()
            })
          Blank()
            .layoutWeight(1)
          if (this.bar.rightIcon2 !== null) {
            Stack({ alignContent: Alignment.Center }) {
              ViaIcon({ icon: this.bar.rightIcon2, iconSize: 22, iconColor: $r('app.color.appbar_icon') })
            }
              .width(48)
              .height(52)
              .padding({ left: 13, right: 13 })
              .margin({ top: 1, bottom: 1 })
              .onClick(() => {
                this.bar.fireRight2()
              })
          } else if (this.bar.rightText2 !== '') {
            Text(this.bar.rightText2)
              .fontSize(14)
              .fontColor($r('app.color.appbar_text'))
              .maxLines(1)
              .textCase(TextCase.UpperCase)
              .height(52)
              .padding({ left: 13, right: 13 })
              .margin({ top: 1, bottom: 1 })
              .alignSelf(ItemAlign.Center)
              .onClick(() => {
                this.bar.fireRight2()
              })
          }
          if (this.bar.rightIcon !== null) {
            Stack({ alignContent: Alignment.Center }) {
              ViaIcon({ icon: this.bar.rightIcon, iconSize: 22, iconColor: $r('app.color.appbar_icon') })
            }
              .width(48)
              .height(52)
              .padding({ left: 13, right: 13 })
              .margin({ top: 1, bottom: 1 })
              .onClick(() => {
                this.bar.fireRight()
              })
          } else if (this.bar.rightText !== '') {
            Text(this.bar.rightText)
              .fontSize(14)
              .fontColor($r('app.color.appbar_text'))
              .maxLines(1)
              .textCase(TextCase.UpperCase)
              .height(52)
              .padding({ left: 13, right: 13 })
              .margin({ top: 1, bottom: 1 })
              .alignSelf(ItemAlign.Center)
              .onClick(() => {
                this.bar.fireRight()
              })
          }
        }
        .width('100%')
        .height(54)
        Divider()
          .vertical(false)
          .strokeWidth(this.dividerHeight)
          .color($r('app.color.appbar_divider'))
      }
      .width('100%')
      .padding({ top: this.insets.top })
      .backgroundColor($r('app.color.page_bg'))
    }
  }
}
