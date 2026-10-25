import { BusinessError } from '@kit.BasicServicesKit'
import { common } from '@kit.AbilityKit'
import { BrowserDb } from '../common/Database'
import { AppSettings } from '../common/Settings'
import { WebDavClient } from '../common/WebDav'
import { SettingNavRow } from '../components/SettingRows'
import { SettingsHeader } from '../components/SettingsHeader'

const CLOUD_SPACE_LINK: string = 'hicloud://cloudDrive/getInfo?path=MainActivity'

@ComponentV2
export struct SyncPage {
  private db: BrowserDb = BrowserDb.getInstance()
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local syncing: boolean = false
  @Local mode: string = 'cloud'
  @Local working: boolean = false

  aboutToAppear(): void {
    this.mode = this.settings.syncMode
  }

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '同步',
          rightText: this.mode === 'cloud' ? 'WebDAV' : '云同步',
          onBack: () => {
            this.navPathStack.pop()
          },
          onRight: () => {
            this.switchMode()
          }
        })
        Scroll() {
          Column() {
            if (this.mode === 'cloud') {
              this.CloudPanel()
            } else {
              this.WebDavPanel()
            }
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
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }

  @Builder
  CloudPanel() {
    Column() {
      Text('书签、历史与设置将通过华为云空间在登录同一华为账号的设备间自动同步。')
        .fontSize(13)
        .fontColor($r('app.color.fg_secondary'))
        .width('100%')
        .padding({ left: 16, right: 16, top: 12, bottom: 12 })

      SettingNavRow({ rowLabel: '跳转到华为云空间', rowValue: '在系统云空间中管理同步数据', onTapRow: () => {
        this.openCloudSpace()
      } })
      SettingNavRow({ rowLabel: '立即备份', rowValue: this.syncing ? '正在同步…' : '手动同步书签、历史与设置', onTapRow: () => {
        this.syncNow()
      } })

      Column() {
        Text('说明')
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .width('100%')
          .padding({ left: 16, top: 16, bottom: 6 })
        Text('· 需 HarmonyOS 6.1 及以上版本，并在"设置-云空间"中开启本应用的同步开关\n· 设置冲突时以较新的修改为准\n· 密码由系统密码保险箱保护，不参与同步')
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .width('100%')
          .padding({ left: 16, right: 16 })
          .lineHeight(22)
      }
      .width('100%')
    }
    .width('100%')
  }

  @Builder
  WebDavPanel() {
    Column() {
      SettingNavRow({ rowLabel: '服务器地址', rowValue: this.settings.webdavUrl === '' ? '未设置' : this.settings.webdavUrl, onTapRow: () => {
        this.editField('webdav_url')
      } })
      SettingNavRow({ rowLabel: '账号', rowValue: this.settings.webdavUser === '' ? '未设置' : this.settings.webdavUser, onTapRow: () => {
        this.editField('webdav_user')
      } })
      SettingNavRow({ rowLabel: '密码', rowValue: this.settings.webdavPwd === '' ? '未设置' : '已设置', onTapRow: () => {
        this.editField('webdav_pwd')
      } })
      SettingNavRow({ rowLabel: '立即备份', rowValue: this.working ? '正在备份…' : '上传书签、历史与设置到 WebDAV 服务器', onTapRow: () => {
        this.webdavBackup()
      } })
      SettingNavRow({ rowLabel: '恢复', rowValue: '从 WebDAV 服务器下载并恢复数据', onTapRow: () => {
        this.webdavRestore()
      } })
    }
    .width('100%')
  }

  private switchMode(): void {
    this.mode = this.mode === 'cloud' ? 'webdav' : 'cloud'
    this.settings.setSyncMode(this.mode)
  }

  private openCloudSpace(): void {
    try {
      const context = this.getUIContext().getHostContext() as common.UIAbilityContext
      context.openLink(CLOUD_SPACE_LINK, { appLinkingOnly: false })
        .catch((error: BusinessError) => {
          console.error(`open cloud space failed: ${error.message}`)
        })
    } catch (error) {
      console.error('open cloud space link failed')
    }
  }

  private syncNow(): void {
    if (this.syncing) {
      return
    }
    this.syncing = true
    this.db.cloudSyncNow().then(() => {
      this.syncing = false
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.sync_done'), duration: 1500 })
    }).catch(() => {
      this.syncing = false
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.sync_failed'), duration: 1500 })
    })
  }

  @Local fieldDraft: string = ''
  private fieldDialogId: number = -1

  private editField(fieldKey: string): void {
    if (fieldKey === 'webdav_url') {
      this.fieldDraft = this.settings.webdavUrl
    } else if (fieldKey === 'webdav_user') {
      this.fieldDraft = this.settings.webdavUser
    } else {
      this.fieldDraft = this.settings.webdavPwd
    }
    const promptAction = this.getUIContext().getPromptAction()
    promptAction.openCustomDialog({
      builder: (): void => {
        this.FieldDialog(fieldKey)
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center
    }).then((dialogId: number) => {
      this.fieldDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open webdav field dialog failed: ${error.message}`)
    })
  }

  @Builder
  FieldDialog(fieldKey: string) {
    Column({ space: 16 }) {
      Text(this.fieldTitle(fieldKey))
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
      TextInput({
        placeholder: fieldKey === 'webdav_url' ? 'https://example.com/dav' : '',
        text: this.fieldDraft
      })
        .width('100%')
        .height(44)
        .fontSize(14)
        .onChange((value: string) => {
          this.fieldDraft = value
        })
      Row({ space: 12 }) {
        Button($r('app.string.cancel'))
          .layoutWeight(1)
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            this.closeFieldDialog()
          })
        Button($r('app.string.confirm'))
          .layoutWeight(1)
          .backgroundColor($r('app.color.accent'))
          .onClick(() => {
            this.saveField(fieldKey)
            this.closeFieldDialog()
          })
      }
      .width('100%')
    }
    .width('86%')
    .padding(20)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
  }

  private fieldTitle(fieldKey: string): string {
    if (fieldKey === 'webdav_url') {
      return '服务器地址'
    }
    if (fieldKey === 'webdav_user') {
      return '账号'
    }
    return '密码'
  }

  private saveField(fieldKey: string): void {
    const value = this.fieldDraft.trim()
    if (fieldKey === 'webdav_url') {
      this.settings.setWebdavUrl(value)
    } else if (fieldKey === 'webdav_user') {
      this.settings.setWebdavUser(value)
    } else {
      this.settings.setWebdavPwd(this.fieldDraft)
    }
  }

  private closeFieldDialog(): void {
    if (this.fieldDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.fieldDialogId)
    this.fieldDialogId = -1
  }

  private webdavBackup(): void {
    if (this.working) {
      return
    }
    if (this.settings.webdavUrl.trim() === '') {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.webdav_not_configured'), duration: 1500 })
      return
    }
    this.working = true
    WebDavClient.getInstance().backup().then(() => {
      this.working = false
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.backup_done'), duration: 1500 })
    }).catch((error: BusinessError) => {
      this.working = false
      console.error(`webdav backup failed: ${error.message}`)
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.backup_failed'), duration: 1500 })
    })
  }

  private webdavRestore(): void {
    if (this.working) {
      return
    }
    if (this.settings.webdavUrl.trim() === '') {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.webdav_not_configured'), duration: 1500 })
      return
    }
    AlertDialog.show({
      title: '恢复',
      message: '将从 WebDAV 服务器下载数据并覆盖当前书签、历史与设置',
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: $r('app.string.confirm'),
        action: () => {
          this.working = true
          WebDavClient.getInstance().restore().then(() => {
            this.working = false
            this.getUIContext().getPromptAction().showToast({ message: $r('app.string.restore_done'), duration: 1500 })
          }).catch((error: BusinessError) => {
            this.working = false
            console.error(`webdav restore failed: ${error.message}`)
            this.getUIContext().getPromptAction().showToast({ message: $r('app.string.backup_failed'), duration: 1500 })
          })
        }
      }
    })
  }
}

@Builder
export function SyncPageBuilder() {
  SyncPage()
}
