import { BusinessError } from '@kit.BasicServicesKit'
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
            this.pickSync()
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
            this.showPasswordVaultGuide()
          } })
          SettingToggleRow({ rowLabel: '夜间模式', isToggleOn: this.settings.nightMode, onToggleRow: (isOn: boolean) => {
            this.settings.setNightMode(isOn)
          } })
          SettingToggleRow({ rowLabel: '阅读模式', isToggleOn: this.settings.readerAuto, onToggleRow: (isOn: boolean) => {
            this.settings.setReaderAuto(isOn)
          } })
          SettingNavRow({ rowLabel: '工具栏设置', onTapRow: () => {
            this.navPathStack.pushPathByName('toolbarCustom', '', true)
          } })
          SettingNavRow({ rowLabel: '定制菜单', onTapRow: () => {
            this.navPathStack.pushPathByName('menuCustom', '', true)
          } })
          SettingNavRow({ rowLabel: '定制长按菜单', onTapRow: () => {
            this.navPathStack.pushPathByName('longPressCustom', '', true)
          } })
          SettingNavRow({ rowLabel: '语言', rowValue: this.languageLabel(), onTapRow: () => {
            this.pickLanguage()
          } })
          SettingNavRow({ rowLabel: '主页', rowValue: this.homeLabel(), onTapRow: () => {
            this.pickHome()
          } })
          SettingNavRow({ rowLabel: '搜索设置', onTapRow: () => {
            this.pickEngine()
          } })
          SettingNavRow({ rowLabel: 'AI 设置', onTapRow: () => {
            this.navPathStack.pushPathByName('aiSettings', '', true)
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

  private pickSync(): void {
    const sheets: SheetInfo[] = [
      { title: '立即同步', action: (): void => {
        this.syncNow()
      } },
      { title: '同步设置', action: (): void => {
        this.navPathStack.pushPathByName('syncPage', '', true)
      } }
    ]
    ActionSheet.show({
      title: '同步',
      message: '书签、历史与设置通过华为云空间同步',
      sheets: sheets
    })
  }

  private syncNow(): void {
    this.db.cloudSyncNow().then(() => {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.sync_done'), duration: 1500 })
    }).catch(() => {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.sync_failed'), duration: 1500 })
    })
  }

  private showPasswordVaultGuide(): void {
    AlertDialog.show({
      title: '密码管理器',
      message: '密码由系统密码保险箱自动管理：网页登录时自动弹出保存与填充提示。可在系统"设置-隐私和安全-密码保险箱"中查看已保存的密码。',
      confirm: {
        value: $r('app.string.confirm'),
        action: () => {
        }
      }
    })
  }

  private languageLabel(): string {
    if (this.settings.appLanguage === 1) {
      return '简体中文'
    }
    if (this.settings.appLanguage === 2) {
      return 'English'
    }
    return '跟随系统'
  }

  private homeLabel(): string {
    if (this.settings.homepageMode === 1 && this.settings.homeUrl !== '') {
      return this.settings.homeUrl
    }
    return '默认'
  }

  private pickLanguage(): void {
    const sheets: SheetInfo[] = [
      { title: '跟随系统', action: (): void => {
        this.settings.setAppLanguage(0)
      } },
      { title: '简体中文', action: (): void => {
        this.settings.setAppLanguage(1)
      } },
      { title: 'English', action: (): void => {
        this.settings.setAppLanguage(2)
      } }
    ]
    ActionSheet.show({
      title: '语言',
      message: '选择应用语言',
      sheets: sheets
    })
  }

  private pickHome(): void {
    const sheets: SheetInfo[] = [
      { title: '默认', action: (): void => {
        this.settings.setHomepageMode(0)
      } },
      { title: '自定义', action: (): void => {
        this.inputHomeUrl()
      } }
    ]
    ActionSheet.show({
      title: '主页',
      message: '选择主页',
      sheets: sheets
    })
  }

  private inputHomeUrl(): void {
    this.homeUrlInput = this.settings.homeUrl
    const promptAction = this.getUIContext().getPromptAction()
    promptAction.openCustomDialog({
      builder: (): void => {
        this.HomeUrlDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center
    }).then((dialogId: number) => {
      this.homeUrlDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open home url dialog failed: ${error.message}`)
    })
  }

  @Local homeUrlInput: string = ''
  private homeUrlDialogId: number = -1

  @Builder
  HomeUrlDialog() {
    Column({ space: 16 }) {
      Text('自定义主页')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
      TextInput({ placeholder: 'https://', text: this.homeUrlInput })
        .width('100%')
        .height(44)
        .fontSize(14)
        .onChange((value: string) => {
          this.homeUrlInput = value
        })
      Row({ space: 12 }) {
        Button($r('app.string.cancel'))
          .layoutWeight(1)
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            this.closeHomeUrlDialog()
          })
        Button($r('app.string.confirm'))
          .layoutWeight(1)
          .backgroundColor($r('app.color.accent'))
          .onClick(() => {
            const url = this.homeUrlInput.trim()
            if (url !== '') {
              this.settings.setHomeUrl(url)
              this.settings.setHomepageMode(1)
            }
            this.closeHomeUrlDialog()
          })
      }
      .width('100%')
    }
    .width('86%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
  }

  private closeHomeUrlDialog(): void {
    if (this.homeUrlDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.homeUrlDialogId)
    this.homeUrlDialogId = -1
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
