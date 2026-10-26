import { BusinessError } from '@kit.BasicServicesKit'
import { fileIo, picker } from '@kit.CoreFileKit'
import { webview } from '@kit.ArkWeb'
import { AppSettings, applyOrientationSetting } from '../common/Settings'
import { BrowserDb } from '../common/Database'
import { BackupManager } from '../common/Backup'
import { uaByKey } from '../common/UaTable'
import { SEARCH_ENGINES, SearchEngineDef } from '../common/SearchEngines'
import { SettingNavRow, SettingToggleRow } from '../components/SettingRows'
import { SettingsHeader } from '../components/SettingsHeader'

@ComponentV2
export struct SettingsGeneralPage {
  private settings: AppSettings = AppSettings.getInstance()
  private db: BrowserDb = BrowserDb.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '通用',
          onBack: () => {
            this.navPathStack.pop()
          }
        })
        Scroll() {
          Column() {
            SettingNavRow({ rowLabel: '同步', rowValue: this.syncLabel(), onTapRow: () => {
              this.navPathStack.pushPathByName('syncPage', '', true)
            } })
            SettingNavRow({ rowLabel: '浏览器标识', rowValue: this.uaLabel(), onTapRow: () => {
              this.navPathStack.pushPathByName('uaPage', '', true)
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
            SettingNavRow({ rowLabel: '搜索设置', rowValue: this.engineLabel(), onTapRow: () => {
              this.pickEngine()
            } })
            SettingNavRow({ rowLabel: 'AI 设置', onTapRow: () => {
              this.navPathStack.pushPathByName('aiSettings', '', true)
            } })
            SettingNavRow({ rowLabel: '屏幕方向', rowValue: this.orientationLabel(), onTapRow: () => {
              this.pickOrientation()
            } })
            SettingNavRow({ rowLabel: '下载目录', rowValue: this.downloadDirLabel(), onTapRow: () => {
              this.pickDownloadDir()
            } })
            SettingNavRow({ rowLabel: '下载管理', onTapRow: () => {
              this.navPathStack.pushPathByName('downloads', '', true)
            } })
            SettingToggleRow({ rowLabel: '外置视频播放器', rowDesc: '调用外部播放器播放网页视频', isToggleOn: this.settings.externalPlayer, onToggleRow: (isOn: boolean) => {
              this.settings.setExternalPlayer(isOn)
            } })
            SettingNavRow({ rowLabel: '退出时清除数据', rowValue: this.clearOnExitLabel(), onTapRow: () => {
              this.pickClearOnExit()
            } })
            SettingNavRow({ rowLabel: '字体', rowValue: `${this.settings.textZoom}%`, onTapRow: () => {
              this.pickFontScale()
            } })
            SettingNavRow({ rowLabel: '操作设定', onTapRow: () => {
              this.navPathStack.pushPathByName('gestureSettings', '', true)
            } })
            SettingNavRow({ rowLabel: '导入或备份书签', onTapRow: () => {
              this.pickBookmarkIO()
            } })
            SettingNavRow({ rowLabel: '导入数据', onTapRow: () => {
              this.importData()
            } })
            SettingNavRow({ rowLabel: '导出数据', onTapRow: () => {
              this.exportData()
            } })
            SettingToggleRow({ rowLabel: '启动时恢复未关闭标签', isToggleOn: this.settings.restoreTabs, onToggleRow: (isOn: boolean) => {
              this.settings.setRestoreTabs(isOn)
            } })
            SettingToggleRow({ rowLabel: '显示撤销关闭标签的提示', isToggleOn: this.settings.undoCloseToast, onToggleRow: (isOn: boolean) => {
              this.settings.setUndoCloseToast(isOn)
            } })
            SettingNavRow({ rowLabel: '设置默认浏览器', onTapRow: () => {
              this.showDefaultBrowserGuide()
            } })
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
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }

  private syncLabel(): string {
    return this.settings.syncMode === 'webdav' ? 'WebDAV' : '华为云空间'
  }

  private uaLabel(): string {
    if (this.settings.uaKey === 'custom') {
      return '自定义'
    }
    const def = uaByKey(this.settings.uaKey)
    return def !== null ? def.label : '默认'
  }

  private engineLabel(): string {
    if (this.settings.engineKey === 'custom' && this.settings.customEngineTemplate !== '') {
      return '自定义'
    }
    const matched = SEARCH_ENGINES.find((engine: SearchEngineDef): boolean => engine.key === this.settings.engineKey)
    return matched !== undefined ? matched.name : '百度'
  }

  private orientationLabel(): string {
    if (this.settings.orientation === 1) {
      return '竖屏'
    }
    if (this.settings.orientation === 2) {
      return '横屏'
    }
    return '跟随系统'
  }

  private downloadDirLabel(): string {
    if (this.settings.downloadDir === '') {
      return '应用下载目录'
    }
    const dir = this.settings.downloadDir
    const slash = dir.lastIndexOf('/')
    return slash >= 0 && slash < dir.length - 1 ? dir.substring(slash + 1) : dir
  }

  private clearOnExitLabel(): string {
    const flags = this.settings.clearOnExit
    if (flags === '') {
      return '关闭'
    }
    const labels: string[] = []
    if (flags.includes('history')) {
      labels.push('历史记录')
    }
    if (flags.includes('bookmarks')) {
      labels.push('书签')
    }
    if (flags.includes('cookies')) {
      labels.push('Cookies')
    }
    return labels.length > 0 ? labels.join('、') : '关闭'
  }

  private pickOrientation(): void {
    const sheets: SheetInfo[] = [
      { title: '跟随系统', action: (): void => {
        this.applyOrientation(0)
      } },
      { title: '竖屏', action: (): void => {
        this.applyOrientation(1)
      } },
      { title: '横屏', action: (): void => {
        this.applyOrientation(2)
      } }
    ]
    ActionSheet.show({
      title: '屏幕方向',
      message: '选择应用屏幕方向',
      sheets: sheets
    })
  }

  private applyOrientation(value: number): void {
    this.settings.setOrientation(value)
    const context = this.getUIContext().getHostContext()
    if (context !== undefined) {
      applyOrientationSetting(context)
    }
  }

  private pickDownloadDir(): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    try {
      const documentPicker = new picker.DocumentViewPicker(context)
      documentPicker.select().then((uris: Array<string>) => {
        if (uris.length > 0) {
          this.settings.setDownloadDir(uris[0])
        }
      }).catch((error: BusinessError) => {
        console.error(`pick download dir failed: ${error.message}`)
      })
    } catch (error) {
      console.error('open dir picker failed')
    }
  }

  private pickFontScale(): void {
    const options: number[] = [80, 90, 100, 110, 120, 130]
    const sheets: SheetInfo[] = []
    for (let i = 0; i < options.length; i++) {
      const value = options[i]
      sheets.push({ title: `${value}%`, action: (): void => {
        this.settings.setTextZoom(value)
      } })
    }
    ActionSheet.show({
      title: '字体',
      message: '选择网页字体缩放',
      sheets: sheets
    })
  }

  @Local clearHistoryOnExit: boolean = false
  @Local clearBookmarksOnExit: boolean = false
  @Local clearCookiesOnExit: boolean = false
  private clearOnExitDialogId: number = -1

  private pickClearOnExit(): void {
    const flags = this.settings.clearOnExit
    this.clearHistoryOnExit = flags.includes('history')
    this.clearBookmarksOnExit = flags.includes('bookmarks')
    this.clearCookiesOnExit = flags.includes('cookies')
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.ClearOnExitDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center
    }).then((dialogId: number) => {
      this.clearOnExitDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open clear on exit dialog failed: ${error.message}`)
    })
  }

  @Builder
  ClearOnExitDialog() {
    Column({ space: 12 }) {
      Text('退出时清除数据')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
      Row() {
        Text('历史记录').fontSize(15).layoutWeight(1)
        Checkbox().select(this.clearHistoryOnExit).onChange((value: boolean) => {
          this.clearHistoryOnExit = value
        })
      }
      .width('100%')
      Row() {
        Text('书签').fontSize(15).layoutWeight(1)
        Checkbox().select(this.clearBookmarksOnExit).onChange((value: boolean) => {
          this.clearBookmarksOnExit = value
        })
      }
      .width('100%')
      Row() {
        Text('Cookies').fontSize(15).layoutWeight(1)
        Checkbox().select(this.clearCookiesOnExit).onChange((value: boolean) => {
          this.clearCookiesOnExit = value
        })
      }
      .width('100%')
      Row({ space: 12 }) {
        Button($r('app.string.cancel'))
          .layoutWeight(1)
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            this.closeClearOnExitDialog()
          })
        Button($r('app.string.confirm'))
          .layoutWeight(1)
          .backgroundColor($r('app.color.accent'))
          .onClick(() => {
            this.saveClearOnExit()
            this.closeClearOnExitDialog()
          })
      }
      .width('100%')
      .margin({ top: 4 })
    }
    .width('86%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
  }

  private saveClearOnExit(): void {
    const flags: string[] = []
    if (this.clearHistoryOnExit) {
      flags.push('history')
    }
    if (this.clearBookmarksOnExit) {
      flags.push('bookmarks')
    }
    if (this.clearCookiesOnExit) {
      flags.push('cookies')
    }
    this.settings.setClearOnExit(flags.join(','))
  }

  private closeClearOnExitDialog(): void {
    if (this.clearOnExitDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.clearOnExitDialogId)
    this.clearOnExitDialogId = -1
  }

  private pickBookmarkIO(): void {
    const sheets: SheetInfo[] = [
      { title: '导出书签', action: (): void => {
        this.exportBookmarks()
      } },
      { title: '导入书签', action: (): void => {
        this.importBookmarks()
      } }
    ]
    ActionSheet.show({
      title: '导入或备份书签',
      message: '以 HTML 书签文件与其它浏览器互通',
      sheets: sheets
    })
  }

  private exportBookmarks(): void {
    BackupManager.getInstance().listBookmarksForExport().then((html: string) => {
      this.saveTextFile('via_bookmarks.html', html)
    }).catch((error: BusinessError) => {
      console.error(`export bookmarks failed: ${error.message}`)
    })
  }

  private importBookmarks(): void {
    try {
      const documentPicker = new picker.DocumentViewPicker()
      documentPicker.select({ fileSuffixFilters: ['.html', '.htm'] }).then((uris: Array<string>) => {
        if (uris.length === 0) {
          return
        }
        this.readTextFile(uris[0]).then((html: string) => {
          const bookmarks = BackupManager.getInstance().parseBookmarksHtml(html)
          for (let i = 0; i < bookmarks.length; i++) {
            const rec = bookmarks[i]
            this.db.addBookmark(rec.title, rec.url).catch((error: BusinessError) => {
              console.error(`import bookmark failed: ${error.message}`)
            })
          }
          this.getUIContext().getPromptAction().showToast({ message: $r('app.string.import_done'), duration: 1500 })
        }).catch((error: BusinessError) => {
          console.error(`read bookmark file failed: ${error.message}`)
        })
      }).catch((error: BusinessError) => {
        console.error(`select bookmark file failed: ${error.message}`)
      })
    } catch (error) {
      console.error('open file picker failed')
    }
  }

  private importData(): void {
    try {
      const documentPicker = new picker.DocumentViewPicker()
      documentPicker.select({ fileSuffixFilters: ['.json'] }).then((uris: Array<string>) => {
        if (uris.length === 0) {
          return
        }
        this.readTextFile(uris[0]).then((raw: string) => {
          BackupManager.getInstance().applyBackupJson(raw).then(() => {
            this.getUIContext().getPromptAction().showToast({ message: $r('app.string.import_done'), duration: 1500 })
          }).catch((error: BusinessError) => {
            console.error(`import data failed: ${error.message}`)
            this.getUIContext().getPromptAction().showToast({ message: $r('app.string.import_failed'), duration: 1500 })
          })
        }).catch((error: BusinessError) => {
          console.error(`read backup file failed: ${error.message}`)
        })
      }).catch((error: BusinessError) => {
        console.error(`select backup file failed: ${error.message}`)
      })
    } catch (error) {
      console.error('open file picker failed')
    }
  }

  private exportData(): void {
    BackupManager.getInstance().buildBackupJson().then((json: string) => {
      this.saveTextFile('via_backup.json', json)
    }).catch((error: BusinessError) => {
      console.error(`export data failed: ${error.message}`)
    })
  }

  private saveTextFile(fileName: string, content: string): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    try {
      const documentPicker = new picker.DocumentViewPicker(context)
      documentPicker.save({ newFileNames: [fileName] }).then((uris: Array<string>) => {
        if (uris.length === 0) {
          return
        }
        try {
          const file = fileIo.openSync(uris[0], fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.TRUNC)
          fileIo.writeSync(file.fd, content)
          fileIo.closeSync(file)
          this.getUIContext().getPromptAction().showToast({ message: $r('app.string.export_done'), duration: 1500 })
        } catch (error) {
          console.error('write file failed')
          this.getUIContext().getPromptAction().showToast({ message: $r('app.string.import_failed'), duration: 1500 })
        }
      }).catch((error: BusinessError) => {
        console.error(`save file failed: ${error.message}`)
      })
    } catch (error) {
      console.error('open save picker failed')
    }
  }

  private readTextFile(uri: string): Promise<string> {
    return new Promise<string>((resolve, reject) => {
      try {
        const content = fileIo.readTextSync(uri)
        resolve(content)
      } catch (error) {
        reject(error)
      }
    })
  }

  private showDefaultBrowserGuide(): void {
    AlertDialog.show({
      title: '设置默认浏览器',
      message: '请在系统"设置-应用-默认应用-浏览器"中将 VIA 设为默认浏览器。',
      confirm: {
        value: $r('app.string.confirm'),
        action: () => {
        }
      }
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
    this.getUIContext().getPromptAction().openCustomDialog({
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

  private pickEngine(): void {
    const sheets: SheetInfo[] = []
    for (let i = 0; i < SEARCH_ENGINES.length; i++) {
      const engine = SEARCH_ENGINES[i]
      sheets.push({ title: engine.name, action: (): void => {
        this.settings.setEngineKey(engine.key)
      } })
    }
    if (this.settings.customEngineTemplate !== '') {
      sheets.push({ title: '自定义', action: (): void => {
        this.inputCustomEngine()
      } })
    } else {
      sheets.push({ title: '添加自定义搜索引擎', action: (): void => {
        this.inputCustomEngine()
      } })
    }
    ActionSheet.show({
      title: '搜索设置',
      message: '选择默认搜索引擎',
      sheets: sheets
    })
  }

  @Local engineTemplateInput: string = ''
  private engineDialogId: number = -1

  private inputCustomEngine(): void {
    this.engineTemplateInput = this.settings.customEngineTemplate
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.CustomEngineDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center
    }).then((dialogId: number) => {
      this.engineDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open custom engine dialog failed: ${error.message}`)
    })
  }

  @Builder
  CustomEngineDialog() {
    Column({ space: 14 }) {
      Text('自定义搜索引擎')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
      Text('用 %s 代表搜索词，例如：https://example.com/search?q=%s')
        .fontSize(13)
        .fontColor($r('app.color.fg_secondary'))
      TextInput({ placeholder: 'https://example.com/search?q=%s', text: this.engineTemplateInput })
        .width('100%')
        .height(44)
        .fontSize(14)
        .onChange((value: string) => {
          this.engineTemplateInput = value
        })
      Row({ space: 12 }) {
        Button($r('app.string.cancel'))
          .layoutWeight(1)
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            this.closeEngineDialog()
          })
        Button($r('app.string.confirm'))
          .layoutWeight(1)
          .backgroundColor($r('app.color.accent'))
          .enabled(this.engineTemplateInput.includes('%s'))
          .opacity(this.engineTemplateInput.includes('%s') ? 1 : 0.4)
          .onClick(() => {
            const template = this.engineTemplateInput.trim()
            if (!template.includes('%s')) {
              return
            }
            this.settings.setCustomEngineTemplate(template)
            this.settings.setEngineKey('custom')
            this.closeEngineDialog()
          })
      }
      .width('100%')
    }
    .width('86%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
  }

  private closeEngineDialog(): void {
    if (this.engineDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.engineDialogId)
    this.engineDialogId = -1
  }


  private confirmClear(): void {
    AlertDialog.show({
      title: '清除数据',
      message: '将清除历史记录、下载记录、搜索历史与 Cookies',
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
          webview.WebCookieManager.clearAllCookies().catch((error: BusinessError) => {
            console.error(`clear cookies failed: ${error.message}`)
          })
          try {
            webview.WebviewController.removeAllCache(true)
            webview.WebStorage.deleteAllData()
          } catch (error) {
            console.error('clear web cache failed')
          }
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
