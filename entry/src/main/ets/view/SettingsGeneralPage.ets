import { AppSettings, UA_MODE_DEFAULT, UA_MODE_PC, UA_MODE_MOBILE } from '../common/Settings'
import { BrowserDb } from '../common/Database'
import { SettingNavRow, SettingToggleRow } from '../components/SettingRows'

@ComponentV2
export struct SettingsGeneralPage {
  private settings: AppSettings = AppSettings.getInstance()
  private db: BrowserDb = BrowserDb.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  build() {
    NavDestination() {
      Scroll() {
        Column() {
          SettingNavRow({ rowLabel: '同步', onTapRow: () => {
            this.notImplemented()
          } })
          SettingNavRow({ rowLabel: '浏览器标识', rowValue: this.uaLabel(), onTapRow: () => {
            this.pickUa()
          } })
          SettingNavRow({ rowLabel: '清除数据', onTapRow: () => {
            this.confirmClear()
          } })
          SettingToggleRow({ rowLabel: '广告拦截', isToggleOn: this.settings.adBlockOn, onToggleRow: (isOn: boolean) => {
            this.settings.setAdBlockOn(isOn)
          } })
          SettingNavRow({ rowLabel: '网站设定', onTapRow: () => {
            this.navPathStack.pushPathByName('siteSettings', '', true)
          } })
          SettingNavRow({ rowLabel: '密码管理器', onTapRow: () => {
            this.notImplemented()
          } })
          SettingToggleRow({ rowLabel: '夜间模式', isToggleOn: this.settings.nightMode, onToggleRow: (isOn: boolean) => {
            this.settings.setNightMode(isOn)
          } })
          SettingNavRow({ rowLabel: '阅读模式', onTapRow: () => {
            this.notImplemented()
          } })
          SettingNavRow({ rowLabel: '工具栏设置', onTapRow: () => {
            this.notImplemented()
          } })
          SettingNavRow({ rowLabel: '定制菜单', onTapRow: () => {
            this.notImplemented()
          } })
          SettingNavRow({ rowLabel: '定制长按菜单', onTapRow: () => {
            this.notImplemented()
          } })
          SettingNavRow({ rowLabel: '语言', rowValue: '中文(简体)', onTapRow: () => {
            this.notImplemented()
          } })
          SettingNavRow({ rowLabel: '主页', rowValue: '默认', onTapRow: () => {
            this.notImplemented()
          } })
          SettingNavRow({ rowLabel: '搜索设置', onTapRow: () => {
            this.pickEngine()
          } })
          SettingNavRow({ rowLabel: 'AI 设置', onTapRow: () => {
            this.notImplemented()
          } })
        }
        .width('100%')
      }
      .width('100%')
      .height('100%')
      .align(Alignment.Top)
    }
    .backgroundColor($r('app.color.page_bg'))
    .title('通用')
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }

  private uaLabel(): string {
    if (this.settings.uaMode === UA_MODE_PC) {
      return '电脑版'
    }
    if (this.settings.uaMode === UA_MODE_MOBILE) {
      return '手机版'
    }
    return 'iPhone'
  }

  private notImplemented(): void {
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.feature_wip'), duration: 1500 })
  }

  private pickUa(): void {
    const sheets: SheetInfo[] = [
      { title: 'iPhone', action: (): void => {
        this.settings.setUaMode(UA_MODE_DEFAULT)
      } },
      { title: '电脑版', action: (): void => {
        this.settings.setUaMode(UA_MODE_PC)
      } },
      { title: '手机版', action: (): void => {
        this.settings.setUaMode(UA_MODE_MOBILE)
      } }
    ]
    ActionSheet.show({
      title: '浏览器标识',
      message: '选择网页浏览器标识',
      sheets: sheets
    })
  }

  private pickEngine(): void {
    const sheets: SheetInfo[] = [
      { title: '百度', action: (): void => {
        this.settings.setEngineKey('baidu')
      } },
      { title: '必应', action: (): void => {
        this.settings.setEngineKey('bing')
      } },
      { title: '搜狗', action: (): void => {
        this.settings.setEngineKey('sogou')
      } },
      { title: '360搜索', action: (): void => {
        this.settings.setEngineKey('so360')
      } },
      { title: '神马', action: (): void => {
        this.settings.setEngineKey('shenma')
      } },
      { title: '夸克', action: (): void => {
        this.settings.setEngineKey('quark')
      } },
      { title: 'Google', action: (): void => {
        this.settings.setEngineKey('google')
      } }
    ]
    ActionSheet.show({
      title: '搜索设置',
      message: '选择默认搜索引擎',
      sheets: sheets
    })
  }

  private confirmClear(): void {
    AlertDialog.show({
      title: '清除数据',
      message: '将清除历史记录、下载记录与搜索历史',
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: $r('app.string.confirm'),
        action: () => {
          this.db.clearHistory().catch((error: BusinessError) => {
            console.error(`clear history failed: ${error.message}`)
          })
          this.db.clearDownloads().catch((error: BusinessError) => {
            console.error(`clear downloads failed: ${error.message}`)
          })
          this.settings.clearSearchHistory()
          this.getUIContext().getPromptAction().showToast({ message: $r('app.string.cleared'), duration: 1500 })
        }
      }
    })
  }
}

@Builder
export function SettingsGeneralPageBuilder() {
  SettingsGeneralPage()
}
