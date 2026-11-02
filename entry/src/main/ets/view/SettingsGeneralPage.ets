import { BusinessError } from '@kit.BasicServicesKit'
import { fileIo, picker } from '@kit.CoreFileKit'
import { webview } from '@kit.ArkWeb'
import { AppSettings, applyOrientationSetting } from '../common/Settings'
import { dialogTransition } from '../common/Transitions'
import { UiInsets, applyStatusBarVisible } from '../common/Immersive'
import { window } from '@kit.ArkUI'
import { common, Want } from '@kit.AbilityKit'
import { BrowserDb } from '../common/Database'
import { BackupManager } from '../common/Backup'
import { uaByKey } from '../common/UaTable'
import { SettingNavRow, SettingCheckRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'

@ComponentV2
export struct SettingsGeneralPage {
  private settings: AppSettings = AppSettings.getInstance()
  private db: BrowserDb = BrowserDb.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  private bindAppBar(): void {
    AppBar.show({
      title: '通用',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
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
            SettingNavRow({ rowLabel: '广告拦截', onTapRow: () => {
              this.navPathStack.pushPathByName('settingsAdBlock', '', true)
            } })
            SettingNavRow({ rowLabel: '网站设定', onTapRow: () => {
              this.navPathStack.pushPathByName('siteSettings', '', true)
            } })
            SettingNavRow({ rowLabel: '密码管理器', onTapRow: () => {
              this.showPasswordVaultGuide()
            } })
            SettingNavRow({ rowLabel: '夜间模式', onTapRow: () => {
              this.navPathStack.pushPathByName('settingsNight', '', true)
            } })
            SettingNavRow({ rowLabel: '阅读模式', onTapRow: () => {
              this.navPathStack.pushPathByName('settingsReader', '', true)
            } })
            SettingCheckRow({ rowLabel: '显示状态栏', rowDesc: '关闭后页面内容铺满整个屏幕', isChecked: this.settings.showStatusBar, onCheckRow: (isOn: boolean) => {
              this.settings.setShowStatusBar(isOn)
              this.applyStatusBar(isOn)
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
            // 原版 hb/c4 id31：搜索设置行无行值，跳 hb/b6 搜索设置页
            SettingNavRow({ rowLabel: '搜索设置', onTapRow: () => {
              this.navPathStack.pushPathByName('settingsSearch', '', true)
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
            // 原版 hb/c4 id15：下载管理 = 下载器选择（dlmanager）
            SettingNavRow({ rowLabel: '下载管理', rowValue: this.dlManagerLabel(), onTapRow: () => {
              this.pickDlManager()
            } })
            // 原版 hb/c4 id27：外置视频播放器（videoplayer），HarmonyOS 无法枚举第三方播放器，仅 关闭/系统分享
            SettingNavRow({ rowLabel: '外置视频播放器', rowValue: this.videoPlayerLabel(), onTapRow: () => {
              this.pickVideoPlayer()
            } })
            SettingNavRow({ rowLabel: '退出时清除数据', onTapRow: () => {
              this.pickClearOnExit()
            } })
            SettingNavRow({ rowLabel: '字体', rowValue: `${this.settings.textZoom}%`, onTapRow: () => {
              this.pickFontScale()
            } })
            SettingNavRow({ rowLabel: '操作设定', onTapRow: () => {
              this.navPathStack.pushPathByName('settingsGesture', '', true)
            } })
            SettingNavRow({ rowLabel: '导入/备份书签', onTapRow: () => {
              this.pickBookmarkIO()
            } })
            SettingNavRow({ rowLabel: '导入数据', onTapRow: () => {
              this.importData()
            } })
            SettingNavRow({ rowLabel: '导出数据', onTapRow: () => {
              this.exportData()
            } })
            SettingNavRow({ rowLabel: '启动时恢复未关闭标签', onTapRow: () => {
              // 原版三选一（arrays.xml array g：禁用恢复/总是恢复/优先询问）
              this.pickRestoreMode()
            } })
            SettingCheckRow({ rowLabel: '显示撤销关闭标签的提示', isChecked: this.settings.undoCloseToast, onCheckRow: (isOn: boolean) => {
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

  // 原版 1..4 语义：1=跟随系统 2=自动 3=竖屏 4=横屏
  private orientationLabel(): string {
    if (this.settings.orientation === 2) {
      return this.getStringById('orientation_auto')
    }
    if (this.settings.orientation === 3) {
      return this.getStringById('orientation_portrait')
    }
    if (this.settings.orientation === 4) {
      return this.getStringById('orientation_landscape')
    }
    return this.getStringById('orientation_system')
  }

  private getStringById(name: string): string {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return ''
    }
    return context.resourceManager.getStringByNameSync(name)
  }

  private downloadDirLabel(): string {
    if (this.settings.downloadDir === '') {
      return '应用下载目录'
    }
    const dir = this.settings.downloadDir
    const slash = dir.lastIndexOf('/')
    return slash >= 0 && slash < dir.length - 1 ? dir.substring(slash + 1) : dir
  }

  private pickOrientation(): void {
    const sheets: SheetInfo[] = [
      { title: '跟随系统', action: (): void => {
        this.applyOrientation(1)
      } },
      { title: '自动', action: (): void => {
        this.applyOrientation(2)
      } },
      { title: '竖屏', action: (): void => {
        this.applyOrientation(3)
      } },
      { title: '横屏', action: (): void => {
        this.applyOrientation(4)
      } }
    ]
    ActionSheet.show({
      title: '屏幕方向',
      message: '选择应用屏幕方向',
      sheets: sheets
    })
  }

  private applyStatusBar(visible: boolean): void {
    const win = AppStorage.get<window.Window>('mainWindow')
    if (win === undefined) {
      return
    }
    applyStatusBarVisible(win, visible)
    setTimeout(() => {
      UiInsets.getInstance().refresh(win)
    }, 200)
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
    const options: number[] = [130, 115, 100, 85, 70]
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

  // 原版 z8/h0.f + arrays c：退出时清除数据七项多选，位表 [1,2,4,64,8,16,32]
  @Local clearOnExitChecks: boolean[] = [false, false, false, false, false, false, false]
  private clearOnExitDialogId: number = -1

  private pickClearOnExit(): void {
    const mask = this.settings.clearOnExit
    for (let i = 0; i < CLEAR_ON_EXIT_ITEMS.length; i++) {
      this.clearOnExitChecks[i] = (mask & CLEAR_ON_EXIT_BITS[i]) !== 0
    }
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
    // 原版 w5.k 弹窗紧凑卡（视频 0:48 同款）：窄卡、加粗标题、右对齐取消/确定文字按钮
    Column({ space: 6 }) {
      Text('退出时清除数据')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
      ForEach(CLEAR_ON_EXIT_ITEMS, (label: string, index: number) => {
        Row() {
          Text(label)
            .fontSize(15)
            .fontColor($r('app.color.fg'))
            .layoutWeight(1)
          Checkbox()
            .select(this.clearOnExitChecks[index])
            .onChange((value: boolean) => {
              this.clearOnExitChecks[index] = value
            })
        }
        .width('100%')
        .height(42)
        .onClick(() => {
          this.clearOnExitChecks[index] = !this.clearOnExitChecks[index]
        })
      }, (label: string) => label)
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(15)
          .fontColor($r('app.color.fg_secondary'))
          .padding({ left: 12, right: 12, top: 6, bottom: 6 })
          .onClick(() => {
            this.closeClearOnExitDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(15)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.accent'))
          .padding({ left: 12, right: 12, top: 6, bottom: 6 })
          .onClick(() => {
            this.saveClearOnExit()
            this.closeClearOnExitDialog()
          })
      }
      .width('100%')
      .margin({ top: 6 })
    }
    .width('70%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(12)
    .transition(dialogTransition())
  }

  private saveClearOnExit(): void {
    let mask = 0
    for (let i = 0; i < CLEAR_ON_EXIT_ITEMS.length; i++) {
      if (this.clearOnExitChecks[i]) {
        mask |= CLEAR_ON_EXIT_BITS[i]
      }
    }
    this.settings.setClearOnExit(mask)
  }

  private closeClearOnExitDialog(): void {
    if (this.clearOnExitDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.clearOnExitDialogId)
    this.clearOnExitDialogId = -1
  }

  private pickBookmarkIO(): void {
    // 原版 hb/c4 case20：[备份书签(T4), 导入书签(F6)]
    const sheets: SheetInfo[] = [
      { title: '备份书签', action: (): void => {
        this.exportBookmarks()
      } },
      { title: '导入书签', action: (): void => {
        this.importBookmarks()
      } }
    ]
    ActionSheet.show({
      title: '导入/备份书签',
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
          BackupManager.getInstance().importBookmarksHtml(html).then(() => {
            this.getUIContext().getPromptAction().showToast({ message: $r('app.string.import_done'), duration: 1500 })
          }).catch((error: BusinessError) => {
            console.error(`import bookmarks failed: ${error.message}`)
          })
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
      // 原版 hb/c4.q4：MIME 为 text/plain + application/zip，安卓导出为 .zip
      documentPicker.select({ fileSuffixFilters: ['.zip', '.json'] }).then((uris: Array<string>) => {
        if (uris.length === 0) {
          return
        }
        const uri = uris[0]
        // 原版按文件名 .zip 判定；文档 URI 不含可靠文件名时以 ZIP 魔数 PK 判定
        let isZip = false
        try {
          const file = fileIo.openSync(uri, fileIo.OpenMode.READ_ONLY)
          try {
            const head = new ArrayBuffer(4)
            fileIo.readSync(file.fd, head)
            const bytes = new Uint8Array(head)
            isZip = bytes.length >= 4 && bytes[0] === 0x50 && bytes[1] === 0x4B
          } finally {
            fileIo.closeSync(file)
          }
        } catch (error) {
          const idx = uri.toLowerCase().lastIndexOf('.zip')
          isZip = idx >= 0 && idx + 4 === uri.length
        }
        if (isZip) {
          // 原版 s3：.zip 走 ZipBackupManager 还原
          const context = this.getUIContext().getHostContext()
          if (context === undefined) {
            return
          }
          BackupManager.getInstance().restoreFromZipBackup(uri, context).then(() => {
            this.getUIContext().getPromptAction().showToast({ message: $r('app.string.import_done'), duration: 1500 })
          }).catch((error: BusinessError) => {
            console.error(`import zip backup failed: ${error.message}`)
            this.getUIContext().getPromptAction().showToast({ message: $r('app.string.import_failed'), duration: 1500 })
          })
          return
        }
        this.readTextFile(uri).then((raw: string) => {
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

  // 原版 hb/c4.f4：导出数据六项多选，默认勾选前五项（k3 位表 0→2 1→4 2→8 3→16 4→1 5→32）
  private static readonly EXPORT_ITEMS: string[] =
    ['书签', '主页收藏', '历史', '关闭的标签页', '设置', '保存的密码']
  private static readonly EXPORT_BITS: number[] = [2, 4, 8, 16, 1, 32]

  private exportSelection: boolean[] = [true, true, true, true, true, false]
  private exportDialogId: number = -1
  // 导出密码弹窗（hb/c4.F4）
  private pendingExportFlags: number = 0
  private passwordInput: string = ''
  private passwordDialogId: number = -1

  private exportData(): void {
    // 原版 c4 case22：先弹导出范围多选弹窗，确定后按位打包 ZIP
    this.exportSelection = [true, true, true, true, true, false]
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.ExportDataDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.2)'
    }).then((dialogId: number) => {
      this.exportDialogId = dialogId
    }).catch(() => {
      console.error('open export dialog failed')
    })
  }

  private closeExportDialog(): void {
    if (this.exportDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.exportDialogId)
    this.exportDialogId = -1
  }

  private confirmExport(): void {
    this.closeExportDialog()
    let flags = 0
    for (let i = 0; i < this.exportSelection.length; i++) {
      if (this.exportSelection[i]) {
        flags += SettingsGeneralPage.EXPORT_BITS[i]
      }
    }
    if (flags === 0) {
      return
    }
    if ((flags & 32) !== 0) {
      // 原版 hb/c4.F4：bit32 → 生物识别通过后弹密码输入框（w5.k.l().d0(B4).I(C4).i("",ke,1)）；
      // 本端无生物识别子系统，直接弹输入框（用户拍板）
      this.pendingExportFlags = flags
      this.passwordInput = ''
      this.getUIContext().getPromptAction().openCustomDialog({
        builder: (): void => {
          this.PasswordDialog()
        },
        isModal: true,
        autoCancel: true,
        alignment: DialogAlignment.Center,
        maskColor: 'rgba(0,0,0,0.2)'
      }).then((dialogId: number) => {
        this.passwordDialogId = dialogId
      }).catch(() => {
        console.error('open password dialog failed')
      })
      return
    }
    this.doExport(flags, null)
  }

  private closePasswordDialog(): void {
    if (this.passwordDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.passwordDialogId)
    this.passwordDialogId = -1
  }

  // 原版 c4.G0：输入为空时使用默认密码 "3_=cZHGxZ#FZgZA@"
  private confirmExportPassword(): void {
    const password = this.passwordInput === '' ? '3_=cZHGxZ#FZgZA@' : this.passwordInput
    const flags = this.pendingExportFlags
    this.closePasswordDialog()
    this.doExport(flags, password)
  }

  private doExport(flags: number, password: string | null): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    const now = new Date()
    const ymd = `${now.getFullYear()}${this.pad2(now.getMonth() + 1)}${this.pad2(now.getDate())}`
    const fileName = `Via_导出数据_${ymd}.zip`
    try {
      const documentPicker = new picker.DocumentViewPicker(context)
      documentPicker.save({ newFileNames: [fileName] }).then((uris: Array<string>) => {
        if (uris.length === 0) {
          return
        }
        BackupManager.getInstance().buildZipBackup(flags, context, password).then((zipPath: string) => {
          try {
            const src = fileIo.openSync(zipPath, fileIo.OpenMode.READ_ONLY)
            try {
              const dst = fileIo.openSync(uris[0], fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.TRUNC)
              try {
                fileIo.copyFileSync(src.fd, dst.fd)
              } finally {
                fileIo.closeSync(dst)
              }
            } finally {
              fileIo.closeSync(src)
            }
            fileIo.unlinkSync(zipPath)
            this.getUIContext().getPromptAction().showToast({ message: $r('app.string.export_done'), duration: 1500 })
          } catch (error) {
            console.error('copy export zip failed')
            this.getUIContext().getPromptAction().showToast({ message: $r('app.string.import_failed'), duration: 1500 })
          }
        }).catch((error: BusinessError) => {
          console.error(`build zip backup failed: ${error.message}`)
          this.getUIContext().getPromptAction().showToast({ message: $r('app.string.import_failed'), duration: 1500 })
        })
      }).catch((error: BusinessError) => {
        console.error(`save export file failed: ${error.message}`)
      })
    } catch (error) {
      console.error('open save picker failed')
    }
  }

  private pad2(n: number): string {
    return n < 10 ? `0${n}` : `${n}`
  }

  @Builder
  ExportDataItem(label: string, index: number) {
    Row({ space: 14 }) {
      Circle({ width: 20, height: 20 })
        .fill(this.exportSelection[index] ? $r('app.color.accent') : Color.Transparent)
        .stroke(this.exportSelection[index] ? $r('app.color.accent') : $r('app.color.fg_secondary'))
        .strokeWidth(1.5)
      Text(label)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
    }
    .width('100%')
    .height(42)
    .onClick(() => {
      this.exportSelection[index] = !this.exportSelection[index]
    })
  }

  // 原版 hb/c4.f4 弹窗：标题「导出数据」+ 六项多选 + 取消/确定
  @Builder
  ExportDataDialog() {
    // 原版 w5.k 弹窗紧凑卡（视频 0:59 同款）：窄卡、加粗标题、右对齐取消/确定文字按钮
    Column({ space: 6 }) {
      Text('导出数据')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
      ForEach(SettingsGeneralPage.EXPORT_ITEMS, (label: string, index: number) => {
        this.ExportDataItem(label, index)
      }, (label: string) => label)
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(15)
          .fontColor($r('app.color.fg_secondary'))
          .padding({ left: 12, right: 12, top: 6, bottom: 6 })
          .onClick(() => {
            this.closeExportDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(15)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.accent'))
          .padding({ left: 12, right: 12, top: 6, bottom: 6 })
          .onClick(() => {
            this.confirmExport()
          })
      }
      .width('100%')
      .margin({ top: 6 })
    }
    .width('70%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(12)
    .transition(dialogTransition())
  }

  // 原版 hb/c4.F4 密码弹窗：标题「输入密码」(ht)、正文 hu、占位「密码」(ke)、取消/确定
  @Builder
  PasswordDialog() {
    Column({ space: 6 }) {
      Text('输入密码')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
      Text('你正在导出隐私数据，请输入密码以加密数据。请牢记密码，如果密码丢失，你将无法导入其中加密的数据。')
        .fontSize(13)
        .fontColor($r('app.color.fg_secondary'))
        .lineHeight(19)
        .margin({ top: 4, bottom: 6 })
      TextInput({ text: this.passwordInput, placeholder: '密码' })
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .placeholderColor($r('app.color.fg_secondary'))
        .placeholderFont({ size: 15 })
        .backgroundColor($r('app.color.page_bg'))
        .height(40)
        .borderRadius(8)
        .padding({ left: 12, right: 12 })
        .onChange((value: string) => {
          this.passwordInput = value
        })
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(15)
          .fontColor($r('app.color.fg_secondary'))
          .padding({ left: 12, right: 12, top: 6, bottom: 6 })
          .onClick(() => {
            this.closePasswordDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(15)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.accent'))
          .padding({ left: 12, right: 12, top: 6, bottom: 6 })
          .onClick(() => {
            this.confirmExportPassword()
          })
      }
      .width('100%')
      .margin({ top: 6 })
    }
    .width('70%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(12)
    .transition(dialogTransition())
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

  // 原版 hb/c4.n4 + arrays e：主页四选（默认 about:home / 空白页 about:blank / 书签 about:bookmarks / 网页自定义 URL）
  private homeLabel(): string {
    if (this.settings.homepageMode === 1 && this.settings.homeUrl !== '') {
      return this.settings.homeUrl
    }
    if (this.settings.homepageMode === 2) {
      return '空白页'
    }
    if (this.settings.homepageMode === 3) {
      return '书签'
    }
    return '默认'
  }

  private pickHome(): void {
    const sheets: SheetInfo[] = [
      { title: '默认', action: (): void => {
        this.settings.setHomepageMode(0)
      } },
      { title: '空白页', action: (): void => {
        this.settings.setHomepageMode(2)
      } },
      { title: '书签', action: (): void => {
        this.settings.setHomepageMode(3)
      } },
      { title: '网页', action: (): void => {
        this.inputHomeUrl()
      } }
    ]
    ActionSheet.show({
      title: '主页',
      message: '选择主页',
      sheets: sheets
    })
  }

  private pickLanguage(): void {
    const sheets: SheetInfo[] = [
      { title: '跟随系统', action: (): void => {
        this.settings.setAppLanguage(0)
        this.confirmRestart()
      } },
      { title: '简体中文', action: (): void => {
        this.settings.setAppLanguage(1)
        this.confirmRestart()
      } },
      { title: 'English', action: (): void => {
        this.settings.setAppLanguage(2)
        this.confirmRestart()
      } }
    ]
    ActionSheet.show({
      title: '语言',
      message: '选择应用语言',
      sheets: sheets
    })
  }

  // 原版 hb/c4.W3→G4：语言切换后确认重启（语言/这将在下次启动应用时生效…/重启应用/取消）
  private confirmRestart(): void {
    AlertDialog.show({
      title: '语言',
      message: '这将在下次启动应用时生效，你希望立即重启应用以生效吗？',
      primaryButton: {
        value: '重启应用',
        action: () => {
          this.restartApp()
        }
      },
      secondaryButton: {
        value: '取消',
        action: () => {
        }
      }
    })
  }

  private restartApp(): void {
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    if (context === undefined || context.abilityInfo === undefined) {
      return
    }
    const want: Want = {
      bundleName: context.abilityInfo.bundleName,
      abilityName: context.abilityInfo.name
    }
    context.startAbility(want).then(() => {
      context.terminateSelf()
    }).catch((error: BusinessError) => {
      console.error(`restart app failed: ${error.message}`)
    })
  }

  // 原版 hb/c4.m4：网页主页输入弹窗（自定义主页），确定时 URL 需含 ://（c4.E3）
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
    Column({ space: 14 }) {
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
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(15)
          .fontColor($r('app.color.fg_secondary'))
          .padding({ left: 12, right: 12, top: 6, bottom: 6 })
          .onClick(() => {
            this.closeHomeUrlDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(15)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.accent'))
          .padding({ left: 12, right: 12, top: 6, bottom: 6 })
          .onClick(() => {
            const url = this.homeUrlInput.trim()
            // 原版 c4.E3：需含 :// 才保存
            if (url.includes('://')) {
              this.settings.setHomeUrl(url)
              this.settings.setHomepageMode(1)
            }
            this.closeHomeUrlDialog()
          })
      }
      .width('100%')
    }
    .width('70%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(12)
    .transition(dialogTransition())
  }

  private closeHomeUrlDialog(): void {
    if (this.homeUrlDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.homeUrlDialogId)
    this.homeUrlDialogId = -1
  }

  // 原版 hb/c4 case27（hb.D4）：''=系统分享；HarmonyOS 无第三方播放器枚举，选项仅 关闭/系统分享
  private videoPlayerLabel(): string {
    return this.settings.videoPlayer === 'share' ? '系统分享' : '关闭'
  }

  private pickVideoPlayer(): void {
    const sheets: SheetInfo[] = [
      { title: '关闭', action: (): void => {
        this.settings.setVideoPlayer('')
      } },
      { title: '系统分享', action: (): void => {
        this.settings.setVideoPlayer('share')
      } }
    ]
    ActionSheet.show({
      title: '外置视频播放器',
      message: '选择网页视频的打开方式',
      sheets: sheets
    })
  }

  // 原版 hb/c4 case15（下载管理，dlmanager）：''/内建下载器；HarmonyOS 无第三方下载器枚举
  private dlManagerLabel(): string {
    return this.settings.dlManager === 'builtin' ? '内建下载器' : ''
  }

  private pickDlManager(): void {
    const sheets: SheetInfo[] = [
      { title: '内建下载器', action: (): void => {
        this.settings.setDlManager('builtin')
      } }
    ]
    ActionSheet.show({
      title: '下载管理',
      message: '选择下载器',
      sheets: sheets
    })
  }

  private confirmClear(): void {
    this.clearDataSelection = [true, true, true, false, false, false, false]
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.ClearDataDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.5)'
    }).then((dialogId: number) => {
      this.clearDataDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open clear data dialog failed: ${error.message}`)
    })
  }

  @Local clearDataSelection: boolean[] = [true, true, true, false, false, false, false]
  private clearDataDialogId: number = -1

  @Builder
  ClearDataItem(label: string, index: number) {
    Row({ space: 14 }) {
      Circle({ width: 20, height: 20 })
        .fill(this.clearDataSelection[index] ? $r('app.color.accent') : Color.Transparent)
        .stroke(this.clearDataSelection[index] ? $r('app.color.accent') : $r('app.color.fg_secondary'))
        .strokeWidth(1.5)
      Text(label)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
    }
    .width('100%')
    .height(42)
    .onClick(() => {
      if (!this.clearDataSelection[index]) {
        this.clearDataSelection[index] = true
      } else {
        this.clearDataSelection[index] = false
      }
    })
  }

  @Builder
  ClearDataDialog() {
    // 原版 w5.k 弹窗紧凑卡（视频 0:48 同款）：窄卡、加粗标题、右对齐取消/确定文字按钮
    Column({ space: 6 }) {
      Text('清除数据')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
      ForEach(CLEAR_DATA_ITEMS, (label: string, index: number) => {
        this.ClearDataItem(label, index)
      }, (label: string) => label)
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(15)
          .fontColor($r('app.color.fg_secondary'))
          .padding({ left: 12, right: 12, top: 6, bottom: 6 })
          .onClick(() => {
            this.closeClearDataDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(15)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.accent'))
          .padding({ left: 12, right: 12, top: 6, bottom: 6 })
          .onClick(() => {
            this.applyClearData()
            this.closeClearDataDialog()
          })
      }
      .width('100%')
      .margin({ top: 6 })
    }
    .width('70%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(12)
    .transition(dialogTransition())
  }

  private closeClearDataDialog(): void {
    if (this.clearDataDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.clearDataDialogId)
    this.clearDataDialogId = -1
  }

  private pickRestoreMode(): void {
    const labels: string[] = ['禁用恢复', '总是恢复', '优先询问']
    const sheets: SheetInfo[] = []
    for (let i = 0; i < labels.length; i++) {
      const mode = i
      const label = labels[i]
      sheets.push({
        title: this.settings.restoreTabsMode === mode ? `${label} ✓` : label,
        action: (): void => {
          this.settings.setRestoreTabsMode(mode)
          if (mode !== 0) {
            // 原版 toast s5：开启“隐身模式”时不会恢复未关闭标签。
            this.getUIContext().getPromptAction().showToast({ message: '开启“隐身模式”时不会恢复未关闭标签。', duration: 2000 })
          }
        }
      })
    }
    ActionSheet.show({
      title: '启动时恢复未关闭标签',
      message: '选择启动时未关闭标签页的恢复方式',
      sheets: sheets
    })
  }

  private applyClearData(): void {
    const selected = this.clearDataSelection
    if (selected[0]) {
      try {
        webview.WebviewController.removeAllCache(true)
      } catch (error) {
        console.error('clear web cache failed')
      }
    }
    if (selected[1]) {
      // 原版表单数据=清除表单自动填充；ArkWeb 无独立 API，用 WebStorage 数据清除
      try {
        webview.WebStorage.deleteAllData()
      } catch (error) {
        console.error('clear form data failed')
      }
    }
    if (selected[2]) {
      this.db.clearHistory().catch((error: BusinessError) => {
        console.error(`clear history failed: ${error.message}`)
      })
      this.settings.clearSearchHistory()
    }
    if (selected[3]) {
      AppStorage.setOrCreate('via_undo_close_url', '')
    }
    if (selected[4]) {
      try {
        webview.WebStorage.deleteAllData()
      } catch (error) {
        console.error('clear web storage failed')
      }
    }
    if (selected[5]) {
      webview.WebCookieManager.clearAllCookies().catch((error: BusinessError) => {
        console.error(`clear cookies failed: ${error.message}`)
      })
    }
    if (selected[6]) {
      this.clearAppCache()
    }
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.cleared'), duration: 1500 })
  }

  private clearAppCache(): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    try {
      const cacheDir = context.cacheDir
      const names = fileIo.listFileSync(cacheDir)
      for (let i = 0; i < names.length; i++) {
        const path = `${cacheDir}/${names[i]}`
        try {
          fileIo.rmdirSync(path)
        } catch (error) {
          try {
            fileIo.unlinkSync(path)
          } catch (innerError) {
            console.error(`clear app cache entry failed: ${names[i]}`)
          }
        }
      }
    } catch (error) {
      console.error('clear app cache failed')
    }
  }
}

// 原版 7 项与顺序（arrays.xml array c：缓存/表单数据/历史/关闭的标签页/网页存储/Cookies/应用缓存）
const CLEAR_DATA_ITEMS: string[] = [
  '缓存',
  '表单数据',
  '历史',
  '关闭的标签页',
  '网页存储',
  'Cookies (登录状态)',
  '应用缓存'
]

// 原版 z8/h0.f：退出时清除数据同表（arrays c），位表 [1,2,4,64,8,16,32]
const CLEAR_ON_EXIT_ITEMS: string[] = [
  '缓存',
  '表单数据',
  '历史',
  '关闭的标签页',
  '网页存储',
  'Cookies (登录状态)',
  '应用缓存'
]

const CLEAR_ON_EXIT_BITS: number[] = [1, 2, 4, 64, 8, 16, 32]

@Builder
export function SettingsGeneralPageBuilder() {
  SettingsGeneralPage()
}
