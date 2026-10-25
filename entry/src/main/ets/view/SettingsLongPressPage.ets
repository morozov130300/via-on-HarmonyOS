import { AppSettings } from '../common/Settings'

class LongPressEntry {
  id: string
  label: string

  constructor(id: string, label: string) {
    this.id = id
    this.label = label
  }
}

const LONG_PRESS_ENTRIES: LongPressEntry[] = [
  new LongPressEntry('open', '打开'),
  new LongPressEntry('open_new_tab', '新标签页打开'),
  new LongPressEntry('open_background', '后台打开'),
  new LongPressEntry('copy_link', '复制链接'),
  new LongPressEntry('download', '下载链接'),
  new LongPressEntry('share', '分享链接')
]

@ComponentV2
export struct SettingsLongPressPage {
  private settings: AppSettings = AppSettings.getInstance()

  build() {
    NavDestination() {
      Scroll() {
        Column() {
          ForEach(LONG_PRESS_ENTRIES, (entry: LongPressEntry) => {
            Row() {
              Text(entry.label)
                .fontSize(15)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
                .layoutWeight(1)
              Toggle({ type: ToggleType.Switch, isOn: !this.isHidden(entry.id) })
                .onChange((value: boolean) => {
                  this.setHidden(entry.id, !value)
                })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 13, bottom: 13 })
            .alignItems(VerticalAlign.Center)
          }, (entry: LongPressEntry) => entry.id)
        }
        .width('100%')
      }
      .width('100%')
      .height('100%')
      .align(Alignment.Top)
    }
    .backgroundColor($r('app.color.page_bg'))
    .title('定制长按菜单')
  }

  private isHidden(id: string): boolean {
    return this.settings.longPressHidden.indexOf(id) >= 0
  }

  private setHidden(id: string, hidden: boolean): void {
    const next: string[] = []
    for (let i = 0; i < this.settings.longPressHidden.length; i++) {
      if (this.settings.longPressHidden[i] !== id) {
        next.push(this.settings.longPressHidden[i])
      }
    }
    if (hidden) {
      next.push(id)
    }
    this.settings.setLongPressHidden(next)
  }
}

@Builder
export function SettingsLongPressPageBuilder() {
  SettingsLongPressPage()
}
