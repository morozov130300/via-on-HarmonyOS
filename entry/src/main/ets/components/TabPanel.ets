import { TabItem } from '../common/Types'
import { TabStore } from '../common/TabStore'
import { AppSettings } from '../common/Settings'
import { AppIcon } from './AppIcon'
import { BusinessError } from '@kit.BasicServicesKit'
import { UiInsets } from '../common/Immersive'

const DEFAULT_TAB_TITLE: string = '新标签页'

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
        Row({ space: 14 }) {
          Text(`${this.tabStore.tabs.length} ${$r('app.string.tab_count_unit')}`)
            .fontSize(16)
            .fontColor($r('app.color.fg'))
            .layoutWeight(1)
          this.HeaderAction($r('sys.symbol.plus'), () => {
            this.tabStore.newTab(false)
          })
          this.HeaderAction($r('sys.symbol.plus_circle'), () => {
            this.tabStore.newTab(true)
          })
          this.HeaderAction($r('sys.symbol.xmark'), () => {
            this.onClose()
          })
        }
        .width('100%')
        .padding({ left: 16, right: 16, top: 14, bottom: 10 })

        Scroll() {
          Flex({ wrap: FlexWrap.Wrap }) {
            ForEach(this.tabStore.tabs, (tab: TabItem, index: number) => {
              Column() {
                Row() {
                  if (tab.incognito) {
                    AppIcon({ icon: $r('sys.symbol.moon_fill'), iconSize: 12, iconColor: $r('app.color.fg_secondary') })
                  }
                  Text(tab.displayTitle(DEFAULT_TAB_TITLE))
                    .fontSize(13)
                    .fontColor($r('app.color.fg'))
                    .maxLines(1)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                    .layoutWeight(1)
                  AppIcon({ icon: $r('sys.symbol.xmark_circle'), iconSize: 16, iconColor: $r('app.color.fg_secondary') })
                    .onClick(() => {
                      const closedUrl = this.tabStore.closeTab(index)
                      if (closedUrl !== '') {
                        this.showUndoToast(closedUrl)
                      }
                    })
                }
                .width('100%')
                .height(36)
                .padding({ left: 10, right: 10 })

                if (tab.isHomePage()) {
                  Column({ space: 6 }) {
                    AppIcon({ icon: $r('sys.symbol.house'), iconSize: 28, iconColor: $r('app.color.fg_secondary') })
                    Text(tab.incognito ? $r('app.string.incognito_hint') : $r('app.string.new_tab'))
                      .fontSize(11)
                      .fontColor($r('app.color.fg_secondary'))
                      .maxLines(1)
                  }
                  .width('100%')
                  .layoutWeight(1)
                  .justifyContent(FlexAlign.Center)
                } else {
                  Text(tab.displayTitle(DEFAULT_TAB_TITLE))
                    .fontSize(12)
                    .fontColor($r('app.color.fg_secondary'))
                    .maxLines(4)
                    .padding(8)
                    .width('100%')
                    .layoutWeight(1)
                    .alignSelf(ItemAlign.Start)
                }
              }
              .width('47%')
              .height(120)
              .margin(4)
              .backgroundColor($r('app.color.surface'))
              .borderRadius(10)
              .clip(true)
              .onClick(() => {
                this.tabStore.switchTo(index)
                this.onClose()
              })
            }, (tab: TabItem) => tab.id.toString())
          }
          .width('100%')
          .padding({ left: 8, right: 8, bottom: 12 })
        }
        .layoutWeight(1)
        .align(Alignment.Top)

        Button($r('app.string.close_all_tabs'))
          .fontSize(13)
          .height(34)
          .width('94%')
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .margin({ bottom: 12 })
          .onClick(() => {
            for (let i = this.tabStore.tabs.length - 1; i > 0; i--) {
              this.tabStore.closeTab(i)
            }
          })
      }
      .width('100%')
      .height('72%')
      .padding({ bottom: this.insets.bottom })
      .backgroundColor($r('app.color.page_bg'))
      .borderRadius({ topLeft: 16, topRight: 16 })
    }
    .width('100%')
    .height('100%')
  }

  @Builder
  HeaderAction(icon: Resource, action: () => void) {
    AppIcon({ icon: icon, iconSize: 22 })
      .onClick(() => {
        action()
      })
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
