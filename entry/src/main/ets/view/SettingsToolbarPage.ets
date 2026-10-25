import { AppSettings } from '../common/Settings'

class ToolbarEntry {
  id: string
  label: string

  constructor(id: string, label: string) {
    this.id = id
    this.label = label
  }
}

const TOOLBAR_ENTRIES: ToolbarEntry[] = [
  new ToolbarEntry('back', '后退'),
  new ToolbarEntry('forward', '前进'),
  new ToolbarEntry('home', '主页')
]

@ComponentV2
export struct SettingsToolbarPage {
  private settings: AppSettings = AppSettings.getInstance()

  build() {
    NavDestination() {
      Scroll() {
        Column() {
          ForEach(TOOLBAR_ENTRIES, (entry: ToolbarEntry) => {
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
          }, (entry: ToolbarEntry) => entry.id)
        }
        .width('100%')
      }
      .width('100%')
      .height('100%')
      .align(Alignment.Top)
    }
    .backgroundColor($r('app.color.page_bg'))
    .title('工具栏设置')
  }

  private isHidden(id: string): boolean {
    return this.settings.toolbarHidden.indexOf(id) >= 0
  }

  private setHidden(id: string, hidden: boolean): void {
    const next: string[] = []
    for (let i = 0; i < this.settings.toolbarHidden.length; i++) {
      if (this.settings.toolbarHidden[i] !== id) {
        next.push(this.settings.toolbarHidden[i])
      }
    }
    if (hidden) {
      next.push(id)
    }
    this.settings.setToolbarHidden(next)
  }
}

@Builder
export function SettingsToolbarPageBuilder() {
  SettingsToolbarPage()
}
