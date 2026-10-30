import { http } from '@kit.NetworkKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { AppSettings } from '../common/Settings'
import { UserScriptRec } from '../common/Types'
import { SettingCheckRow, SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'

@ComponentV2
export struct SettingsScriptPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local updating: boolean = false

  private bindAppBar(): void {
    AppBar.show({
      title: '脚本',
      rightText: '更新',
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight: () => {
        this.updateScripts()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
        Column() {
          SettingCheckRow({ rowLabel: '启用脚本', isChecked: this.settings.scriptEnabled, onCheckRow: (isOn: boolean) => {
            this.settings.setScriptEnabled(isOn)
          } })
          SettingCheckRow({ rowLabel: '自动更新', isChecked: this.settings.scriptAutoUpdate, onCheckRow: (isOn: boolean) => {
            this.settings.setScriptAutoUpdate(isOn)
          } })
          if (this.settings.userScripts.length > 0) {
            Text('脚本')
              .fontSize(13)
              .fontColor($r('app.color.fg_secondary'))
              .width('100%')
              .padding({ left: 16, top: 10, bottom: 6 })
            ForEach(this.settings.userScripts, (script: UserScriptRec) => {
              Row() {
                Column() {
                  Text(script.name)
                    .fontSize(15)
                    .fontColor($r('app.color.fg'))
                    .maxLines(1)
                  Text(script.enabled ? '已启用' : '已禁用')
                    .fontSize(12)
                    .fontColor($r('app.color.fg_secondary'))
                    .margin({ top: 2 })
                }
                .alignItems(HorizontalAlign.Start)
                .layoutWeight(1)
                Toggle({ type: ToggleType.Switch, isOn: script.enabled })
                  .onChange((value: boolean) => {
                    script.enabled = value
                    this.settings.saveScript(script)
                  })
              }
              .width('100%')
              .padding({ left: 16, right: 16, top: 11, bottom: 11 })
              .alignItems(VerticalAlign.Center)
            }, (script: UserScriptRec) => `${script.id}_${script.enabled}`)
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
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  private updateScripts(): void {
    if (this.updating) {
      return
    }
    let pending = 0
    for (let i = 0; i < this.settings.userScripts.length; i++) {
      if (this.settings.userScripts[i].sourceUrl !== '') {
        pending++
      }
    }
    if (pending === 0) {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.script_updated'), duration: 1500 })
      return
    }
    this.updating = true
    let done = 0
    const finish = (): void => {
      done++
      if (done >= pending) {
        this.updating = false
        this.settings.markScriptsUpdated()
        this.getUIContext().getPromptAction().showToast({ message: $r('app.string.script_updated'), duration: 1500 })
      }
    }
    const scripts = this.settings.userScripts
    for (let i = 0; i < scripts.length; i++) {
      const script = scripts[i]
      if (script.sourceUrl === '') {
        continue
      }
      const request = http.createHttp()
      request.request(script.sourceUrl, {
        method: http.RequestMethod.GET,
        connectTimeout: 10000,
        readTimeout: 20000,
        usingCache: false
      }).then((response: http.HttpResponse) => {
        const body = response.result
        if (typeof body === 'string' && body.trim() !== '') {
          script.code = body
          this.settings.saveScript(script)
        }
      }).catch((error: BusinessError) => {
        console.error(`update script ${script.name} failed: ${error.message}`)
      }).finally(() => {
        request.destroy()
        finish()
      })
    }
  }
}

@Builder
export function SettingsScriptPageBuilder() {
  SettingsScriptPage()
}
