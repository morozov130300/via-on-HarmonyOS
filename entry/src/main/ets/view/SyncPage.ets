import { BusinessError } from '@kit.BasicServicesKit'
import { common } from '@kit.AbilityKit'
import { BrowserDb } from '../common/Database'
import { AppSettings } from '../common/Settings'
import { SettingNavRow } from '../components/SettingRows'

const CLOUD_SPACE_LINK: string = 'hicloud://cloudDrive/getInfo?path=MainActivity'

@ComponentV2
export struct SyncPage {
  private db: BrowserDb = BrowserDb.getInstance()
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local syncing: boolean = false

  build() {
    NavDestination() {
      Scroll() {
        Column() {
          Text('书签、历史与设置将通过华为云空间在登录同一华为账号的设备间自动同步。')
            .fontSize(13)
            .fontColor($r('app.color.fg_secondary'))
            .width('100%')
            .padding({ left: 16, right: 16, top: 12, bottom: 12 })

          SettingNavRow({ rowLabel: '云空间同步开关', rowValue: '前往系统设置开启', onTapRow: () => {
            this.openCloudSpace()
          } })
          SettingNavRow({ rowLabel: '立即同步', rowValue: this.syncing ? '正在同步…' : '手动同步书签、历史与设置', onTapRow: () => {
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
      .width('100%')
      .height('100%')
      .align(Alignment.Top)
    }
    .backgroundColor($r('app.color.page_bg'))
    .title('同步')
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
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
}

@Builder
export function SyncPageBuilder() {
  SyncPage()
}
