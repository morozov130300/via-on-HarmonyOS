import { TabItem } from '../common/Types'
import { TabStore } from '../common/TabStore'
import { AppSettings } from '../common/Settings'
import { AppIcon } from './AppIcon'
import { BusinessError } from '@kit.BasicServicesKit'
import { UiInsets } from '../common/Immersive'

const DEFAULT_TAB_TITLE: string = '新标签页'
const PANEL_FG: ResourceColor = '#E6E6E6'

@ComponentV2
export struct TabPanel {
  @Event onClose: () => void = () => {}
  private tabStore: TabStore = TabStore.getInstance()
  private settings: AppSettings = AppSettings.getInstance()
  private insets: UiInsets = UiInsets.getInstance()
  @Local undoDialogId: number = -1
  @Local undoUrl: string = ''

  build() {
    Stack({ alignContent: Alignment.Bottom }) {
      Column()
        .width('100%')
        .height('100%')
        .backgroundColor('rgba(0,0,0,0.35)')
        .onClick(() => {
          this.onClose()
        })

      Column() {
        Scroll() {
          Column() {
            ForEach(this.tabStore.tabs, (tab: TabItem, index: number) => {
              Row({ space: 16 }) {
                if (tab.incognito) {
                  AppIcon({ icon: $r('sys.symbol.moon_fill'), iconSize: 24, iconColor: PANEL_FG })
                } else if (tab.isHomePage()) {
                  AppIcon({ icon: $r('sys.symbol.house'), iconSize: 24, iconColor: PANEL_FG })
                } else {
                  Image(this.faviconUrl(tab.url))
                    .width(24)
                    .height(24)
                    .objectFit(ImageFit.Contain)
                }
                Text(tab.displayTitle(DEFAULT_TAB_TITLE))
                  .fontSize(16)
                  .fontColor(index === this.tabStore.currentIndex ? $r('app.color.accent') : PANEL_FG)
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
                  .layoutWeight(1)
                AppIcon({ icon: $r('sys.symbol.xmark'), iconSize: 20, iconColor: PANEL_FG })
                  .onClick(() => {
                    const closedUrl = this.tabStore.closeTab(index)
                    if (closedUrl !== '') {
                      this.showUndoToast(closedUrl)
                    }
                  })
              }
              .width('100%')
              .height(56)
              .padding({ left: 18, right: 18 })
              .onClick(() => {
                this.tabStore.switchTo(index)
                this.onClose()
              })
            }, (tab: TabItem) => tab.id.toString())
          }
          .width('100%')
        }
        .width('100%')
        .align(Alignment.Bottom)
        .scrollBar(BarState.Off)

        Row() {
          AppIcon({ icon: $r('sys.symbol.plus'), iconSize: 24, iconColor: PANEL_FG })
            .padding(12)
            .onClick(() => {
              this.tabStore.newTab(false)
              this.onClose()
            })
        }
        .width('100%')
        .justifyContent(FlexAlign.Center)
      }
      .width('100%')
      .constraintSize({ maxHeight: '68%' })
      .padding({ top: 8, bottom: this.insets.bottom })
      .backgroundColor($r('app.color.page_bg'))
      .borderRadius({ topLeft: 16, topRight: 16 })
    }
    .width('100%')
    .height('100%')
  }

  private faviconUrl(url: string): string {
    const host = url.replace(/^https?:\/\//, '').split('/')[0]
    if (host === '') {
      return ''
    }
    return `https://${host}/favicon.ico`
  }

  private showUndoToast(closedUrl: string): void {
    if (!this.settings.undoCloseToast) {
      return
    }
    this.undoUrl = closedUrl
    AppStorage.setOrCreate('via_undo_close_url', closedUrl)
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.UndoDialog()
      },
      isModal: false,
      autoCancel: false,
      alignment: DialogAlignment.Bottom
    }).then((dialogId: number) => {
      this.undoDialogId = dialogId
      setTimeout(() => {
        this.closeUndoToast(dialogId)
      }, 3000)
    }).catch((error: BusinessError) => {
      console.error(`open undo toast failed: ${error.message}`)
    })
  }

  private closeUndoToast(dialogId: number): void {
    if (this.undoDialogId !== dialogId) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(dialogId)
    this.undoDialogId = -1
  }

  @Builder
  UndoDialog() {
    Row() {
      Text($r('app.string.tab_closed'))
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .layoutWeight(1)
      Text($r('app.string.undo'))
        .fontSize(14)
        .fontColor($r('app.color.accent'))
        .padding({ left: 12, right: 12, top: 8, bottom: 8 })
        .onClick(() => {
          const url = AppStorage.get<string>('via_undo_close_url') ?? this.undoUrl
          this.closeUndoToast(this.undoDialogId)
          if (url !== '') {
            this.tabStore.newTabAt(url, false)
          }
        })
    }
    .width('92%')
    .padding({ left: 16, right: 8, top: 12, bottom: 12 })
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(12)
  }
}
