import { TabItem } from '../common/Types'
import { AppIcon } from './AppIcon'

@ComponentV2
export struct FindBar {
  @Param @Require tab: TabItem
  @Event onClose: () => void = () => {}
  @Local query: string = ''
  private inputController: TextInputController = new TextInputController()

  build() {
    Row({ space: 8 }) {
      TextInput({ placeholder: $r('app.string.find_in_page'), text: this.query, controller: this.inputController })
        .layoutWeight(1)
        .height(36)
        .fontSize(14)
        .backgroundColor($r('app.color.surface'))
        .fontColor($r('app.color.fg'))
        .placeholderColor($r('app.color.fg_secondary'))
        .caretColor($r('app.color.accent'))
        .enterKeyType(EnterKeyType.Search)
        .defaultFocus(true)
        .onChange((value: string) => {
          this.query = value
          this.search(value)
        })
        .onSubmit(() => {
          this.jump(true)
        })
      if (this.tab.matchCount > 0) {
        Text(`${this.tab.matchOrdinal + 1}/${this.tab.matchCount}`)
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .maxLines(1)
      }
      AppIcon({ icon: $r('sys.symbol.chevron_up'), iconSize: 20 })
        .onClick(() => {
          this.jump(false)
        })
      AppIcon({ icon: $r('sys.symbol.chevron_down'), iconSize: 20 })
        .onClick(() => {
          this.jump(true)
        })
      AppIcon({ icon: $r('sys.symbol.xmark'), iconSize: 20, iconColor: $r('app.color.fg_secondary') })
        .onClick(() => {
          this.clear()
          this.onClose()
        })
    }
    .width('100%')
    .height(48)
    .padding({ left: 12, right: 12 })
    .backgroundColor($r('app.color.page_bg'))
  }

  private search(text: string): void {
    try {
      if (text === '') {
        this.tab.controller.clearMatches()
        this.tab.matchCount = 0
        this.tab.matchOrdinal = 0
        return
      }
      this.tab.controller.searchAllAsync(text)
    } catch (error) {
      console.error('searchAllAsync failed')
    }
  }

  private jump(forward: boolean): void {
    try {
      this.tab.controller.searchNext(forward)
    } catch (error) {
      console.error('searchNext failed')
    }
  }

  private clear(): void {
    try {
      this.tab.controller.clearMatches()
      this.tab.matchCount = 0
      this.tab.matchOrdinal = 0
      this.query = ''
    } catch (error) {
      console.error('clearMatches failed')
    }
  }
}
