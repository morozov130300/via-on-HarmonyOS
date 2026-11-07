import { common } from '@kit.AbilityKit'
import { picker } from '@kit.CoreFileKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { AppSettings } from '../common/Settings'
import { FontEntry, FontStore } from '../common/FontStore'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { SettingRadioRow } from '../components/SettingRows'
import { computeDialogWidthVp } from '../components/ViaDialogCard'

// 原版 hb/j2.java：「字体」页
// 列表 = s9.d 字体库（首项默认 fd「默认」，其余文件名字母排序），单击选中（B3 → w9.l.o 写 uifont）；
// 长按非默认项 → 菜单 [编辑 a3（A3 重命名弹窗，输入默认为去扩展名文件名）/删除 x]；
// appbar 右侧 + 按钮（drawable ay / via_ic_add）→ 文件选择器（font/ttf,otf,woff,woff2，≤50MB），
// 失败 toast a08「添加字体失败，错误码：%1$d」
@ComponentV2
export struct FontPage {
  private settings: AppSettings = AppSettings.getInstance()
  private store: FontStore = FontStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local entries: FontEntry[] = []
  @Local renaming: FontEntry | null = null

  private getContextCtx(): common.Context {
    return getContext(this) as common.Context
  }

  private reload(): void {
    this.entries = this.store.list(this.getContextCtx())
  }

  private bindAppBar(): void {
    AppBar.show({
      title: '字体',
      rightIcon: $r('app.media.via_ic_add'),
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight: () => {
        this.pickFont()
      }
    }, this)
  }

  // 原版 j2.t3：文件选择器（font/ttf, font/otf, font/woff, font/woff2）
  private pickFont(): void {
    try {
      const docPicker = new picker.DocumentViewPicker(this.getContextCtx())
      const options = new picker.DocumentSelectOptions()
      options.maxSelectNumber = 1
      options.fileSuffixFilters = ['.ttf', '.otf', '.woff', '.woff2']
      docPicker.select(options).then((uris: Array<string>) => {
        if (uris.length > 0) {
          this.importFont(uris[0])
        }
      }).catch((error: BusinessError) => {
        console.error(`pick font failed: ${error.message}`)
      })
    } catch (error) {
      console.error('pick font failed')
    }
  }

  // 原版 j2.x3 → i3：导入，失败 toast a08（j3 → g6.n.s）
  private importFont(uri: string): void {
    const code = this.store.importFromFile(this.getContextCtx(), uri)
    if (code !== 0) {
      this.toast(`添加字体失败，错误码：${code}`)
      return
    }
    this.reload()
  }

  // 原版 j2.B3：选中（与当前相同则忽略）
  private selectFont(entry: FontEntry): void {
    if (entry.name === this.settings.uiFont) {
      return
    }
    this.settings.setUiFont(entry.name)
  }

  // 原版 j2.g3：长按菜单（默认项不弹）[编辑/删除]
  private showFontMenu(entry: FontEntry): void {
    if (entry.name === '') {
      return
    }
    ActionSheet.show({
      title: entry.name,
      message: '',
      sheets: [
        {
          title: '编辑',
          action: (): void => {
            this.renaming = entry
          }
        },
        {
          title: '删除',
          action: (): void => {
            this.deleteFont(entry)
          }
        }
      ]
    })
  }

  // 原版 j2.v3：删除（若删除的是当前字体则回退默认），无确认弹窗
  private deleteFont(entry: FontEntry): void {
    if (entry.name === '') {
      return
    }
    if (this.settings.uiFont === entry.name) {
      this.settings.setUiFont('')
    }
    this.store.remove(this.getContextCtx(), entry.name)
    this.reload()
  }

  aboutToAppear(): void {
    this.reload()
  }

  private toast(message: string): void {
    this.getUIContext().getPromptAction().showToast({ message: message, duration: 1500 })
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        List() {
          ForEach(this.entries, (entry: FontEntry) => {
            ListItem() {
              SettingRadioRow({
                rowLabel: entry.name === '' ? '默认' : entry.name,
                isSelected: this.settings.uiFont === entry.name,
                onTapRow: () => {
                  this.selectFont(entry)
                },
                onLongPressRow: () => {
                  this.showFontMenu(entry)
                }
              })
            }
          }, (entry: FontEntry) => `${entry.name}_${this.settings.uiFont}`)
        }
        .width('100%')
        .layoutWeight(1)
        .divider({ strokeWidth: 0.5, color: $r('app.color.appbar_divider'), startMargin: 16, endMargin: 16 })
      }
      .width('100%')
      .height('100%')
      if (this.renaming !== null) {
        FontRenameOverlay({
          entry: this.renaming,
          onClose: () => {
            this.renaming = null
          },
          onRenamed: () => {
            this.renaming = null
            this.reload()
          }
        })
      }
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
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
}

// 原版 j2.A3：重命名弹窗（标题 rk「重命名」，输入默认 = 文件名去扩展名，确定 R.string.ok / 取消）
// 确认 j2.k3：空输入或与原名相同则忽略；重命名后若原为当前字体重选新字体（d.i + B3）
@ComponentV2
struct FontRenameOverlay {
  @Param entry: FontEntry = new FontEntry('', '')
  @Event onClose: () => void = () => {}
  @Event onRenamed: () => void = () => {}
  @Local text: string = ''
  private store: FontStore = FontStore.getInstance()

  aboutToAppear(): void {
    const dot = this.entry.name.lastIndexOf('.')
    this.text = dot > 0 ? this.entry.name.substring(0, dot) : this.entry.name
  }

  build() {
    Column() {
      Column({ space: 16 }) {
        Text('重命名')
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
        TextInput({ text: this.text })
          .height(40)
          .fontSize(14)
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .caretColor($r('app.color.accent'))
          .onChange((value: string) => {
            this.text = value
          })
        Row({ space: 12 }) {
          Button($r('app.string.cancel'))
            .fontSize(14)
            .height(36)
            .layoutWeight(1)
            .backgroundColor($r('app.color.surface'))
            .fontColor($r('app.color.fg'))
            .onClick(() => {
              this.onClose()
            })
          Button($r('app.string.done'))
            .fontSize(14)
            .height(36)
            .layoutWeight(1)
            .backgroundColor($r('app.color.accent'))
            .fontColor(Color.White)
            .onClick(() => {
              this.confirm()
            })
        }
        .width('100%')
      }
      .width('100%')
      .padding(20)
      .backgroundColor($r('app.color.page_bg'))
      .borderRadius(16)
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .backgroundColor('rgba(0,0,0,0.5)')
    .onClick(() => {
      this.onClose()
    })
  }

  private confirm(): void {
    const name = this.text.trim()
    if (name === '' || name === this.entry.name) {
      this.onClose()
      return
    }
    const context = getContext(this) as common.Context
    const dot = this.entry.name.lastIndexOf('.')
    const base = dot > 0 ? this.entry.name.substring(0, dot) : this.entry.name
    if (name === base) {
      this.onClose()
      return
    }
    this.store.rename(context, this.entry.name, name)
    this.onRenamed()
  }
}

@Builder
export function FontPageBuilder() {
  FontPage()
}
