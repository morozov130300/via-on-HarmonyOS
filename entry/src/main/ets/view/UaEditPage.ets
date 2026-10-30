import { AppSettings } from '../common/Settings'
import { CustomUaEntry } from '../common/UaTable'
import { AppBar, AppBarSpacer } from '../components/AppBar'

@ComponentV2
export struct UaEditPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local titleInput: string = ''
  @Local uaInput: string = ''
  @Local isNew: boolean = true

  private bindAppBar(): void {
    AppBar.show({
      title: '自定义浏览器标识',
      rightText: '保存',
      onBack: () => {
        this.navPathStack.pop()
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
            Text('标题')
              .fontSize(13)
              .fontColor($r('app.color.fg_secondary'))
              .width('100%')
              .padding({ left: 16, top: 14, bottom: 6 })
            TextInput({ placeholder: '显示在列表中的名称', text: this.titleInput })
              .height(44)
              .fontSize(15)
              .fontColor($r('app.color.fg'))
              .placeholderColor($r('app.color.fg_secondary'))
              .backgroundColor($r('app.color.page_bg'))
              .borderRadius(0)
              .margin({ left: 16, right: 16 })
              .onChange((value: string) => {
                this.titleInput = value
              })
            Text('浏览器标识')
              .fontSize(13)
              .fontColor($r('app.color.fg_secondary'))
              .width('100%')
              .padding({ left: 16, top: 14, bottom: 6 })
            TextArea({ placeholder: 'Mozilla/5.0 ...', text: this.uaInput })
              .fontSize(14)
              .fontColor($r('app.color.fg'))
              .placeholderColor($r('app.color.fg_secondary'))
              .backgroundColor($r('app.color.page_bg'))
              .borderRadius(0)
              .margin({ left: 16, right: 16 })
              .constraintSize({ minHeight: 96 })
              .onChange((value: string) => {
                this.uaInput = value
              })
            if (!this.isNew) {
              Text('删除此标识')
                .fontSize(15)
                .fontColor($r('app.color.fg'))
                .width('100%')
                .padding({ left: 16, right: 16, top: 16, bottom: 13 })
                .onClick(() => {
                  this.removeEntry()
                })
            }
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

  private save(): void {
    const title = this.titleInput.trim()
    const ua = this.uaInput.trim()
    if (title === '' || ua === '') {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.ua_empty'), duration: 1500 })
      return
    }
    const oldTitle = this.isNew ? '' : this.titleInput
    if (!this.isNew && oldTitle !== title) {
      this.settings.removeCustomUaEntry(oldTitle)
    }
    this.settings.saveCustomUaEntry(new CustomUaEntry(title, ua))
    this.navPathStack.pop()
  }

  private removeEntry(): void {
    const title = this.titleInput.trim()
    if (title !== '') {
      this.settings.removeCustomUaEntry(title)
      if (this.settings.uaKey === 'custom' && this.settings.customUa === this.uaInput.trim()) {
        this.settings.setCustomUa('')
        this.settings.setUaKey('default')
      }
    }
    this.navPathStack.pop()
  }
}

@Builder
export function UaEditPageBuilder() {
  UaEditPage()
}
