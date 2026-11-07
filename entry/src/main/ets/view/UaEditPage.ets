import { AppSettings } from '../common/Settings'
import { CustomUaEntry } from '../common/UaTable'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'

// 原版 hb/v1.java：自定义浏览器标识 新建/编辑页
// 标题=新建(N)/编辑(D)；菜单=保存(ap)；返回时未保存 → 提示(g6) 修改的内容未保存，是否保存？(nt) [保存并退出(sa)/退出(i9)]
// 校验：标题不能为空(yj)、浏览器标识不能为空(a11)
@ComponentV2
export struct UaEditPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local titleInput: string = ''
  @Local uaInput: string = ''
  @Local isNew: boolean = true

  private bindAppBar(): void {
    AppBar.show({
      title: this.isNew ? '新建' : '编辑',
      rightText: '保存',
      onBack: () => {
        this.confirmExit()
      },
      onRight: () => {
        this.save()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            TextInput({ placeholder: '标题', text: this.titleInput })
              .height(48)
              .fontSize(15)
              .fontColor($r('app.color.fg'))
              .placeholderColor($r('app.color.fg_secondary'))
              .backgroundColor($r('app.color.page_bg'))
              .borderRadius(0)
              .margin({ left: 16, right: 16 })
              .onChange((value: string) => {
                this.titleInput = value
              })
            TextArea({ placeholder: '浏览器标识', text: this.uaInput })
              .fontSize(14)
              .fontColor($r('app.color.fg'))
              .placeholderColor($r('app.color.fg_secondary'))
              .backgroundColor($r('app.color.page_bg'))
              .borderRadius(0)
              .margin({ left: 16, right: 16, top: 8 })
              .constraintSize({ minHeight: 120 })
              .onChange((value: string) => {
                this.uaInput = value
              })
          }
          .width('100%')
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .translate({ x: this.slideOffset })
    // 原版 g6/i.java:67 = setCustomAnimations(anim/f, anim/g, anim/h, anim/i)，
    // 时长 integer/b=220、accelerate_decelerate —— 改用鸿蒙原生 NavDestination 转场接口
    .customTransition((operation: NavigationOperation, isEnter: boolean):
      Array<NavDestinationTransition> | undefined => {
      return buildNavSlide(operation, isEnter, (value: string): void => {
        this.slideOffset = value
      })
    })
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      const param: Object | undefined = ctx.pathInfo.param === undefined ? undefined : ctx.pathInfo.param as Object
      if (typeof param === 'string' && param !== '' && param !== 'new') {
        const entry = this.findEntry(param)
        if (entry !== null) {
          this.titleInput = entry.title
          this.uaInput = entry.ua
          this.isNew = false
        }
      }
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  private findEntry(title: string): CustomUaEntry | null {
    const found = this.settings.customUaList.find((item: CustomUaEntry): boolean => item.title === title)
    if (found !== undefined) {
      return found
    }
    return null
  }

  // 原版 o3：内容未变化则直接退出，否则弹确认
  private confirmExit(): void {
    if (this.isNew) {
      if (this.titleInput.trim() === '' && this.uaInput.trim() === '') {
        this.navPathStack.pop()
        return
      }
    } else {
      const entry = this.findEntry(this.titleInput)
      if (entry !== null && entry.title === this.titleInput && entry.ua === this.uaInput) {
        this.navPathStack.pop()
        return
      }
    }
    this.getUIContext().showAlertDialog({
      title: '提示',
      message: '修改的内容未保存，是否保存？',
      primaryButton: {
        value: '保存并退出',
        action: (): void => {
          this.save()
        }
      },
      secondaryButton: {
        value: '退出',
        action: (): void => {
          this.navPathStack.pop()
        }
      }
    })
  }

  private save(): void {
    const title = this.titleInput.trim()
    const ua = this.uaInput.trim()
    if (title === '') {
      this.getUIContext().getPromptAction().showToast({ message: '标题不能为空', duration: 1500 })
      return
    }
    if (ua === '') {
      this.getUIContext().getPromptAction().showToast({ message: '浏览器标识不能为空', duration: 1500 })
      return
    }
    const oldTitle = this.isNew ? '' : this.titleInput
    if (!this.isNew && oldTitle !== title) {
      this.settings.removeCustomUaEntry(oldTitle)
    }
    this.settings.saveCustomUaEntry(new CustomUaEntry(title, ua))
    this.navPathStack.pop()
  }
}

@Builder
export function UaEditPageBuilder() {
  UaEditPage()
}
