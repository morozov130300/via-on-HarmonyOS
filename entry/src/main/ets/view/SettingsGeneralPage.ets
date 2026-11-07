import { BusinessError } from '@kit.BasicServicesKit'
import { fileIo, picker } from '@kit.CoreFileKit'
import { webview } from '@kit.ArkWeb'
import { AppSettings, applyOrientationSetting } from '../common/Settings'
import { dialogTransition } from '../common/Transitions'
import { common, Want } from '@kit.AbilityKit'
import { BrowserDb } from '../common/Database'
import { BackupManager } from '../common/Backup'
import { uaByKey } from '../common/UaTable'
import { SettingNavRow, SettingCheckRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { ViaDialogCard, computeDialogWidthVp } from '../components/ViaDialogCard'

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
            SettingNavRow({ rowLabel: '退出时清除数据', onTapRow: () => {
              this.pickClearOnExit()
            } })
            // 原版 c4.u4() row35：字体（K5，value = w9.l.a1() 当前 uifont，默认空）→ case35 打开 hb.j2
            SettingNavRow({ rowLabel: '字体', rowValue: this.settings.uiFont, onTapRow: () => {
              this.navPathStack.pushPathByName('fontPage', '', true)
            } })
            // 原版 c4.u4() row19：操作设定（sc，value = C9「手势，快捷方式，功能键」）
            SettingNavRow({ rowLabel: '操作设定', rowValue: '手势，快捷方式，功能键', onTapRow: () => {
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

  // 原版 c4:206 `.d0(px 屏幕方向).Z(array h, i0()-1)`，回调 Q0(idx+1)
  private pickOrientation(): void {
    this.openListDialog('屏幕方向', ['跟随系统', '自动', '竖屏', '横屏'],
      Math.max(0, this.settings.orientation - 1), false, (index: number): void => {
        this.applyOrientation(index + 1)
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

  // ---- 原版 w5.k.b0/.Z/.F 列表弹窗（layout u.xml 卡片 + v.xml 单选项 / w.xml 纯列表项）----
  // 一次只显示一个，7 个选择器复用同一弹窗
  @Local listDialogTitle: string = ''
  @Local listDialogOptions: string[] = []
  @Local listDialogChecked: number = -1
  @Local listDialogPlain: boolean = false
  @Local listDialogOnSelect: (index: number) => void = (index: number) => {}
  private listDialogId: number = -1

  private openListDialog(title: string, options: string[], checked: number, plain: boolean,
    onSelect: (index: number) => void): void {
    this.listDialogTitle = title
    this.listDialogOptions = options
    this.listDialogChecked = checked
    this.listDialogPlain = plain
    this.listDialogOnSelect = onSelect
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.ListDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.listDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open list dialog failed: ${error.message}`)
    })
  }

  @Builder
  ListRadioItem(label: string, index: number) {
    // 原版 layout v.xml + w5.d：16dp 圆形复选框在左，drawablePadding 24（dimen a4），
    // 14sp 文字（style a6），padV 12（a3）、padH 16
    Row({ space: 24 }) {
      Circle({ width: 16, height: 16 })
        .fill(this.listDialogChecked === index ? $r('app.color.accent') : Color.Transparent)
        .stroke(this.listDialogChecked === index ? Color.Transparent : $r('app.color.dialog_border'))
        .strokeWidth(2)
      Text(label)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .layoutWeight(1)
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 12, bottom: 12 })
    .onClick(() => {
      const select = this.listDialogOnSelect
      this.closeListDialog()
      select(index)
    })
  }

  @Builder
  ListPlainItem(label: string, index: number) {
    // 原版 layout w.xml：居中 TextView，padH 16（a2）、padV 12（a3），14sp（style a6）
    Text(label)
      .fontSize(14)
      .fontColor($r('app.color.fg'))
      .maxLines(1)
      .textOverflow({ overflow: TextOverflow.Ellipsis })
      .width('100%')
      .textAlign(TextAlign.Center)
      .padding({ left: 16, right: 16, top: 12, bottom: 12 })
      .onClick(() => {
        const select = this.listDialogOnSelect
        this.closeListDialog()
        select(index)
      })
  }

  @Builder
  ListDialog() {
    Column() {
      Text(this.listDialogTitle)
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      ForEach(this.listDialogOptions, (label: string, index: number) => {
        if (this.listDialogPlain) {
          this.ListPlainItem(label, index)
        } else {
          this.ListRadioItem(label, index)
        }
      }, (label: string) => label)
    }
    .width(this.dialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeListDialog(): void {
    if (this.listDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.listDialogId)
    this.listDialogId = -1
  }

  // 原版 z8/h0.f + arrays c：退出时清除数据多选，位表 [1,4,64,8,16,32]（表单数据位2已移除）
  @Local clearOnExitChecks: boolean[] = [false, false, false, false, false, false]
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
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.clearOnExitDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open clear on exit dialog failed: ${error.message}`)
    })
  }

  @Builder
  ClearOnExitItem(label: string, index: number) {
    // 原版 layout v.xml + w5.d：16dp 圆形复选框在左（drawable s/r），
    // drawablePadding 24（dimen a4），14sp 文字（style a6），padV 12（a3）、padH 16
    Row({ space: 24 }) {
      Circle({ width: 16, height: 16 })
        .fill(this.clearOnExitChecks[index] ? $r('app.color.accent') : Color.Transparent)
        .stroke(this.clearOnExitChecks[index] ? Color.Transparent : $r('app.color.dialog_border'))
        .strokeWidth(2)
      Text(label)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .layoutWeight(1)
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 12, bottom: 12 })
    .onClick(() => {
      this.clearOnExitChecks[index] = !this.clearOnExitChecks[index]
    })
  }

  @Builder
  ClearOnExitDialog() {
    // 原版 z8.h0.f：w5.k.l().d0(dr 退出时清除数据).K(array c, 已选位).V(ok).N(cancel).f0()
    // 布局 = layout u.xml 同款卡片（详见 ExportDataDialog 注释）
    Column() {
      Text('退出时清除数据')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      ForEach(CLEAR_ON_EXIT_ITEMS, (label: string, index: number) => {
        this.ClearOnExitItem(label, index)
      }, (label: string) => label)
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeClearOnExitDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.saveClearOnExit()
            this.closeClearOnExitDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16, top: 12 })
    }
    .width(this.dialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private saveClearOnExit(): void {
    // 「表单数据」位2已从 UI 移除，保留原存储值以保证与安卓端备份互操作
    let mask = this.settings.clearOnExit & 2
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

  // 原版 c4:239 `.d0(l6 导入/备份书签).F([ie 备份书签, l0 导入书签])`（w.xml 纯列表），
  // 回调 O3：0→c4() 备份 1→o4() 导入
  private pickBookmarkIO(): void {
    this.openListDialog('导入/备份书签', ['备份书签', '导入书签'], -1, true, (index: number): void => {
      if (index === 0) {
        this.exportBookmarks()
      } else {
        this.importBookmarks()
      }
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

  // 原版 w5.k.f0()：弹窗宽 = min(窗口宽,窗口高) − 72dp；大屏或横屏时上限 300dp
  // （f13288c/f13289d=Activity content view 宽高=应用窗口，分屏时取窗口而非物理屏）
  private dialogWidthVp(): number {
    return computeDialogWidthVp()
  }

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
      maskColor: 'rgba(0,0,0,0.4)'
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
        maskColor: 'rgba(0,0,0,0.4)'
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
    // 原版 layout v.xml + w5.d：FrameLayout padH 16 + CheckBox(padV 12/dimen a3,
    // padLeft 12/dimen a2, drawablePadding 24/dimen a4, 14sp 文字 style a6)；
    // 复选框 drawable s/r：16dp 圆，未选中 2dp 描边 #30808080，选中实心 accent
    Row({ space: 24 }) {
      Circle({ width: 16, height: 16 })
        .fill(this.exportSelection[index] ? $r('app.color.accent') : Color.Transparent)
        .stroke(this.exportSelection[index] ? Color.Transparent : $r('app.color.dialog_border'))
        .strokeWidth(2)
      Text(label)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .layoutWeight(1)
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 12, bottom: 12 })
    .onClick(() => {
      this.exportSelection[index] = !this.exportSelection[index]
    })
  }

  // 原版 hb/c4.f4 弹窗：w5.k.e0(ig 导出数据) + .L(六项多选) + .V(ok)/.N(cancel)
  // 布局 = layout u.xml：Space12 + 标题(style a0=16sp bold/边距16/底距6) + 复选列表 +
  // Space12 + 按钮行(取消/确定，style y=14sp #6f8de1/pad16/minWidth56) + Space12；
  // 卡片 = drawable t/u：圆角 18dp、纯白/深色底、1dp 描边 #30808080；遮罩 0.4（theme n）
  @Builder
  ExportDataDialog() {
    Column() {
      Text('导出数据')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      ForEach(SettingsGeneralPage.EXPORT_ITEMS, (label: string, index: number) => {
        this.ExportDataItem(label, index)
      }, (label: string) => label)
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeExportDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.confirmExport()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16, top: 12 })
    }
    .width(this.dialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  // 原版 hb/c4.a.onSuccess：w5.k.l().d0(ht 输入密码).I(hu 正文).i("", ke 密码, 1)
  // .V(ok).N(cancel).f0()；输入框 = layout u.xml bh 槽 + w5.k.g(i11=1)：
  // 单行 EditText 14sp，容器 marginLeft16/right12/top8、底边线 1dp（drawable w）
  @Builder
  PasswordDialog() {
    Column() {
      Text('输入密码')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Text('你正在导出隐私数据，请输入密码以加密数据。请牢记密码，如果密码丢失，你将无法导入其中加密的数据。')
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .lineHeight(21)
        .width('100%')
        .padding({ left: 16, right: 16, top: 8, bottom: 8 })
      Row() {
        TextInput({ text: this.passwordInput, placeholder: '密码' })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.dialog_hint'))
          .placeholderFont({ size: 14 })
          .backgroundColor(Color.Transparent)
          .padding({ left: 0, right: 0 })
          .height(40)
          .layoutWeight(1)
          .onChange((value: string) => {
            this.passwordInput = value
          })
      }
      .width('100%')
      .margin({ left: 16, right: 12, top: 8 })
      .border({ width: { bottom: 1 }, color: $r('app.color.dialog_border') })
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closePasswordDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.confirmExportPassword()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16, top: 12 })
    }
    .width(this.dialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
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
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.DefaultBrowserGuideDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.defaultBrowserGuideDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open default browser guide dialog failed: ${error.message}`)
    })
  }

  private defaultBrowserGuideDialogId: number = -1

  // 原版 z8.b0.W：API≥24 直跳系统默认应用设置（无弹窗）；
  // HarmonyOS 无对应深链，保留引导卡片（w5.k 卡片样式）
  @Builder
  DefaultBrowserGuideDialog() {
    ViaDialogCard() {
      Text('设置默认浏览器')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Text('请在系统"设置-应用-默认应用-浏览器"中将 VIA 设为默认浏览器。')
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .lineHeight(21)
        .width('100%')
        .padding({ left: 16, right: 16, top: 8, bottom: 8 })
      Row() {
        Blank()
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeDefaultBrowserGuideDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16, top: 12 })
    }
  }

  private closeDefaultBrowserGuideDialog(): void {
    if (this.defaultBrowserGuideDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.defaultBrowserGuideDialogId)
    this.defaultBrowserGuideDialogId = -1
  }

  private showPasswordVaultGuide(): void {
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.PasswordVaultGuideDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.passwordVaultGuideDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open password vault guide dialog failed: ${error.message}`)
    })
  }

  private passwordVaultGuideDialogId: number = -1

  // 密码管理器引导（用户拍板：弹系统密码保险箱说明，不建原版五项子页）；
  // 弹窗样式 = 原版 w5.k 卡片
  @Builder
  PasswordVaultGuideDialog() {
    ViaDialogCard() {
      Text('密码管理器')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Text('密码由系统密码保险箱自动管理：网页登录时自动弹出保存与填充提示。可在系统"设置-隐私和安全-密码保险箱"中查看已保存的密码。')
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .lineHeight(21)
        .width('100%')
        .padding({ left: 16, right: 16, top: 8, bottom: 8 })
      Row() {
        Blank()
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closePasswordVaultGuideDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16, top: 12 })
    }
  }

  private closePasswordVaultGuideDialog(): void {
    if (this.passwordVaultGuideDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.passwordVaultGuideDialogId)
    this.passwordVaultGuideDialogId = -1
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

  // 原版 c4.n4 `.d0(km 主页).Z(array e, B())`，回调 T3：
  // 0/1/2 → about:home/blank/bookmarks，3 → m4 自定义主页输入弹窗
  private pickHome(): void {
    this.openListDialog('主页', ['默认', '空白页', '书签', '网页'], this.homeIndex(), false,
      (index: number): void => {
        if (index === 3) {
          this.inputHomeUrl()
        } else {
          this.settings.setHomepageMode([0, 2, 3][index])
        }
      })
  }

  // 原版 w9.l.B()：当前主页索引（0 默认 1 空白 2 书签 3 网页；本工程 mode 1=网页 URL）
  private homeIndex(): number {
    if (this.settings.homepageMode === 2) {
      return 1
    }
    if (this.settings.homepageMode === 3) {
      return 2
    }
    if (this.settings.homepageMode === 1) {
      return 3
    }
    return 0
  }

  // 原版 c4.t4 `.d0(m6 语言).b0(语言数组, 当前索引)`，回调 W3：
  // 选择相同语言直接 return；不同 → z1 保存 + G4 重启确认
  private pickLanguage(): void {
    this.openListDialog('语言', ['跟随系统', '简体中文', 'English'], this.settings.appLanguage, false,
      (index: number): void => {
        if (this.settings.appLanguage === index) {
          return
        }
        this.settings.setAppLanguage(index)
        this.confirmRestart()
      })
  }

  // 原版 hb/c4.W3→G4：语言切换后确认重启
  // w5.k.l().d0(m6 语言).I(s2 这将在下次启动应用时生效，你希望立即重启应用以生效吗？)
  // .V(er 重启应用, z8.f.k).N(cancel).f0()
  private confirmRestart(): void {
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.RestartConfirmDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.restartConfirmDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open restart confirm dialog failed: ${error.message}`)
    })
  }

  private restartConfirmDialogId: number = -1

  @Builder
  RestartConfirmDialog() {
    ViaDialogCard() {
      Text('语言')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Text('这将在下次启动应用时生效，你希望立即重启应用以生效吗？')
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .lineHeight(21)
        .width('100%')
        .padding({ left: 16, right: 16, top: 8, bottom: 8 })
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeRestartConfirmDialog()
          })
        Text('重启应用')
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeRestartConfirmDialog()
            this.restartApp()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16, top: 12 })
    }
  }

  private closeRestartConfirmDialog(): void {
    if (this.restartConfirmDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.restartConfirmDialogId)
    this.restartConfirmDialogId = -1
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
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.homeUrlDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open home url dialog failed: ${error.message}`)
    })
  }

  @Local homeUrlInput: string = ''
  private homeUrlDialogId: number = -1

  // 原版 hb/c4.m4：w5.k.l().d0(Rf 自定义主页).i(主页URL, Rf 占位, 3).V(ok).N(cancel).f0()
  // 输入类型 3（w5.k.g 多行分支）：EditText 直挂内容槽，底边线背景（drawable w），
  // padH 12、padTop 8（style a1），14sp 文字
  @Builder
  HomeUrlDialog() {
    Column() {
      Text('自定义主页')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      Row() {
        TextInput({ placeholder: '自定义主页', text: this.homeUrlInput })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.dialog_hint'))
          .placeholderFont({ size: 14 })
          .backgroundColor(Color.Transparent)
          .padding({ left: 0, right: 0 })
          .height(40)
          .layoutWeight(1)
          .onChange((value: string) => {
            this.homeUrlInput = value
          })
      }
      .width('100%')
      .padding({ left: 12, right: 12 })
      .margin({ top: 8 })
      .border({ width: { bottom: 1 }, color: $r('app.color.dialog_border') })
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeHomeUrlDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
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
      .margin({ left: 16, right: 16, top: 12 })
    }
    .width(this.dialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeHomeUrlDialog(): void {
    if (this.homeUrlDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.homeUrlDialogId)
    this.homeUrlDialogId = -1
  }

  // 原版 hb/c4 case15（下载管理，dlmanager）：A0=[""]、label=[d5 内建下载器]
  private dlManagerLabel(): string {
    return '内建下载器'
  }

  private pickDlManager(): void {
    this.openListDialog('下载管理', ['内建下载器'], 0, false, (index: number): void => {
      this.settings.setDlManager('builtin')
    })
  }

  // 原版 z8/h0.e：默认选中 = 已存掩码 cleardata2（w9.l.V()），位表 {1,4,64,8,16,32}（表单数据位2已移除）
  private static readonly CLEAR_DATA_BITS: number[] = [1, 4, 64, 8, 16, 32]

  private confirmClear(): void {
    const mask = this.settings.clearData2
    for (let i = 0; i < CLEAR_DATA_ITEMS.length; i++) {
      this.clearDataSelection[i] = (mask & SettingsGeneralPage.CLEAR_DATA_BITS[i]) !== 0
    }
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.ClearDataDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.clearDataDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open clear data dialog failed: ${error.message}`)
    })
  }

  @Local clearDataSelection: boolean[] = [true, true, false, false, false, false]
  private clearDataDialogId: number = -1

  @Builder
  ClearDataItem(label: string, index: number) {
    // 原版 layout v.xml + w5.d：16dp 圆形复选框在左（drawable s/r），
    // drawablePadding 24（dimen a4），14sp 文字（style a6），padV 12（a3）、padH 16
    Row({ space: 24 }) {
      Circle({ width: 16, height: 16 })
        .fill(this.clearDataSelection[index] ? $r('app.color.accent') : Color.Transparent)
        .stroke(this.clearDataSelection[index] ? Color.Transparent : $r('app.color.dialog_border'))
        .strokeWidth(2)
      Text(label)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .layoutWeight(1)
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 12, bottom: 12 })
    .onClick(() => {
      this.clearDataSelection[index] = !this.clearDataSelection[index]
    })
  }

  @Builder
  ClearDataDialog() {
    // 原版 z8.h0.e：w5.k.l().d0(dq 清除数据).K(array c, 已选位).V(ok).N(cancel).f0()
    // 布局 = layout u.xml 同款卡片（详见 ExportDataDialog 注释）
    Column() {
      Text('清除数据')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      ForEach(CLEAR_DATA_ITEMS, (label: string, index: number) => {
        this.ClearDataItem(label, index)
      }, (label: string) => label)
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeClearDataDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.applyClearData()
            this.closeClearDataDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16, top: 12 })
    }
    .width(this.dialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeClearDataDialog(): void {
    if (this.clearDataDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.clearDataDialogId)
    this.clearDataDialogId = -1
  }

  // 原版 c4:254 `.d0(s3 启动时恢复未关闭标签).Z(array g, u1())`，回调 V3：
  // A0(idx) 保存；idx≠0 时 toast pb（开启“隐身模式”时不会恢复未关闭标签。）
  private pickRestoreMode(): void {
    this.openListDialog('启动时恢复未关闭标签', ['禁用恢复', '总是恢复', '优先询问'],
      this.settings.restoreTabsMode, false, (index: number): void => {
        this.settings.setRestoreTabsMode(index)
        if (index !== 0) {
          this.getUIContext().getPromptAction()
            .showToast({ message: '开启“隐身模式”时不会恢复未关闭标签。', duration: 2000 })
        }
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
      this.db.clearHistory().catch((error: BusinessError) => {
        console.error(`clear history failed: ${error.message}`)
      })
      this.settings.clearSearchHistory()
    }
    if (selected[2]) {
      AppStorage.setOrCreate('via_undo_close_url', '')
    }
    if (selected[3]) {
      try {
        webview.WebStorage.deleteAllData()
      } catch (error) {
        console.error('clear web storage failed')
      }
    }
    if (selected[4]) {
      webview.WebCookieManager.clearAllCookies().catch((error: BusinessError) => {
        console.error(`clear cookies failed: ${error.message}`)
      })
    }
    if (selected[5]) {
      this.clearAppCache()
    }
    // 原版 z8.h0.a 末尾：确认后保存选中掩码（w9.l.I0），有清除项时 toast「数据已清除」(S2)
    // 「表单数据」位2已从 UI 移除，保留原存储值以保证与安卓端备份互操作
    let mask = this.settings.clearData2 & 2
    for (let i = 0; i < CLEAR_DATA_ITEMS.length; i++) {
      if (selected[i]) {
        mask |= SettingsGeneralPage.CLEAR_DATA_BITS[i]
      }
    }
    this.settings.setClearData2(mask)
    if (mask !== 0) {
      this.getUIContext().getPromptAction().showToast({ message: '数据已清除', duration: 1500 })
    }
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

// 原版项与顺序（arrays.xml array c：缓存/表单数据/历史/关闭的标签页/网页存储/Cookies/应用缓存）
// 鸿蒙端已移除「表单数据」（ArkWeb 无表单自动填充数据），位2仅保留存储语义
const CLEAR_DATA_ITEMS: string[] = [
  '缓存',
  '历史',
  '关闭的标签页',
  '网页存储',
  'Cookies (登录状态)',
  '应用缓存'
]

// 原版 z8/h0.f：退出时清除数据同表（arrays c），位表 [1,4,64,8,16,32]（表单数据位2已移除）
const CLEAR_ON_EXIT_ITEMS: string[] = [
  '缓存',
  '历史',
  '关闭的标签页',
  '网页存储',
  'Cookies (登录状态)',
  '应用缓存'
]

const CLEAR_ON_EXIT_BITS: number[] = [1, 4, 64, 8, 16, 32]

@Builder
export function SettingsGeneralPageBuilder() {
  SettingsGeneralPage()
}
