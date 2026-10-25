import { AppSettings } from '../common/Settings'

class MenuEntry {
  id: string
  label: string

  constructor(id: string, label: string) {
    this.id = id
    this.label = label
  }
}

const MAIN_MENU_ENTRIES: MenuEntry[] = [
  new MenuEntry('bookmarks', '书签'),
  new MenuEntry('history', '历史'),
  new MenuEntry('downloads', '下载'),
  new MenuEntry('incognito', '隐身模式'),
  new MenuEntry('share', '分享'),
  new MenuEntry('add_bookmark', '加入书签'),
  new MenuEntry('pc_mode', '电脑模式'),
  new MenuEntry('save', '保存'),
  new MenuEntry('toolbox', '工具箱'),
  new MenuEntry('settings', '设置')
]

const TOOLBOX_ENTRIES: MenuEntry[] = [
  new MenuEntry('find', '页内查找'),
  new MenuEntry('offline', '离线页面'),
  new MenuEntry('translate', '翻译'),
  new MenuEntry('add_to_desktop', '添加到桌面'),
  new MenuEntry('script', '脚本'),
  new MenuEntry('adblock', '广告拦截'),
  new MenuEntry('ai', 'AI'),
  new MenuEntry('print', '打印'),
  new MenuEntry('ua', '浏览器标识'),
  new MenuEntry('netlog', '网络日志')
]

@ComponentV2
export struct SettingsMenuPage {
  private settings: AppSettings = AppSettings.getInstance()

  build() {
    NavDestination() {
      Scroll() {
        Column() {
          Text('主菜单')
            .fontSize(13)
            .fontColor($r('app.color.fg_secondary'))
            .width('100%')
            .padding({ left: 16, top: 10, bottom: 6 })
          ForEach(MAIN_MENU_ENTRIES, (entry: MenuEntry) => {
            this.MenuToggle(entry)
          }, (entry: MenuEntry) => entry.id)
          Text('工具箱')
            .fontSize(13)
            .fontColor($r('app.color.fg_secondary'))
            .width('100%')
            .padding({ left: 16, top: 16, bottom: 6 })
          ForEach(TOOLBOX_ENTRIES, (entry: MenuEntry) => {
            this.MenuToggle(entry)
          }, (entry: MenuEntry) => entry.id)
        }
        .width('100%')
      }
      .width('100%')
      .height('100%')
      .align(Alignment.Top)
    }
    .backgroundColor($r('app.color.page_bg'))
    .title('定制菜单')
  }

  @Builder
  MenuToggle(entry: MenuEntry) {
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
  }

  private isHidden(id: string): boolean {
    return this.settings.menuHidden.indexOf(id) >= 0
  }

  private setHidden(id: string, hidden: boolean): void {
    const next: string[] = []
    for (let i = 0; i < this.settings.menuHidden.length; i++) {
      if (this.settings.menuHidden[i] !== id) {
        next.push(this.settings.menuHidden[i])
      }
    }
    if (hidden) {
      next.push(id)
    }
    this.settings.setMenuHidden(next)
  }
}

@Builder
export function SettingsMenuPageBuilder() {
  SettingsMenuPage()
}
