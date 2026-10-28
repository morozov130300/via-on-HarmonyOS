import { http } from '@kit.NetworkKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { UserScriptRec } from '../common/Types'
import { AppSettings } from '../common/Settings'
import { AppIcon } from '../components/AppIcon'
import { SettingsHeader } from '../components/SettingsHeader'

@ComponentV2
export struct UserScriptsPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local editing: UserScriptRec | null = null
  @Local adding: boolean = false
  @Local updating: boolean = false

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '脚本',
          rightIcon2: $r('sys.symbol.plus'),
          rightText: '更新',
          onBack: () => {
            this.navPathStack.pop()
          },
          onRight2: () => {
            this.adding = true
          },
          onRight: () => {
            this.updateScripts()
          }
        })
        if (this.settings.userScripts.length === 0) {
          Column() {
            Text('¯\\_(ツ)_/¯')
              .fontSize(26)
              .fontColor($r('app.color.fg_secondary'))
          }
          .width('100%')
          .layoutWeight(1)
          .justifyContent(FlexAlign.Center)
        } else {
          List({ space: 1 }) {
            ForEach(this.settings.userScripts, (script: UserScriptRec) => {
              ListItem() {
                Row({ space: 12 }) {
                  Column({ space: 2 }) {
                    Text(script.name)
                      .fontSize(15)
                      .fontColor($r('app.color.fg'))
                      .maxLines(1)
                      .textOverflow({ overflow: TextOverflow.Ellipsis })
                    Text(script.matchHost === '' ? $r('app.string.all_sites') : script.matchHost)
                      .fontSize(12)
                      .fontColor($r('app.color.fg_secondary'))
                      .maxLines(1)
                      .textOverflow({ overflow: TextOverflow.Ellipsis })
                  }
                  .layoutWeight(1)
                  .alignItems(HorizontalAlign.Start)
                  Toggle({ type: ToggleType.Switch, isOn: script.enabled })
                    .onChange((value: boolean) => {
                      script.enabled = value
                      this.settings.saveScript(script)
                    })
                  AppIcon({ icon: $r('sys.symbol.pencil_line'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
                    .onClick(() => {
                      this.editing = script
                    })
                  AppIcon({ icon: $r('sys.symbol.trash'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
                    .onClick(() => {
                      this.settings.removeScript(script.id)
                    })
                }
                .width('100%')
                .height(56)
                .padding({ left: 16, right: 16 })
              }
            }, (script: UserScriptRec) => script.id.toString())
          }
          .width('100%')
          .layoutWeight(1)
          .divider({ strokeWidth: 0.5, color: $r('app.color.divider') })
        }
      }
      .width('100%')
      .height('100%')
      if (this.editing !== null || this.adding) {
        ScriptEditOverlay({
          script: this.editing,
          onClose: () => {
            this.editing = null
            this.adding = false
          },
          onSaved: () => {
            this.editing = null
            this.adding = false
          }
        })
      }
    }
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }

  @Builder
  AddMenu() {
    AppIcon({ icon: $r('sys.symbol.plus'), iconSize: 22 })
      .onClick(() => {
        this.adding = true
      })
  }

  // 「更新」：重新拉取所有带源地址的脚本代码（与原版一致，无源地址脚本直接跳过）
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

@ComponentV2
struct ScriptEditOverlay {
  @Param script: UserScriptRec | null = null
  @Event onClose: () => void = () => {}
  @Event onSaved: () => void = () => {}
  @Local name: string = ''
  @Local matchHost: string = ''
  @Local code: string = ''
  @Local sourceUrl: string = ''
  private settings: AppSettings = AppSettings.getInstance()

  aboutToAppear(): void {
    if (this.script !== null) {
      this.name = this.script.name
      this.matchHost = this.script.matchHost
      this.code = this.script.code
      this.sourceUrl = this.script.sourceUrl
    }
  }

  build() {
    Column() {
      Scroll() {
        Column({ space: 16 }) {
          Text(this.script === null ? $r('app.string.add_script') : $r('app.string.edit_script'))
            .fontSize(16)
            .fontWeight(FontWeight.Bold)
            .fontColor($r('app.color.fg'))
          Column({ space: 8 }) {
            Text($r('app.string.name_label'))
              .fontSize(12)
              .fontColor($r('app.color.fg_secondary'))
            TextInput({ text: this.name })
              .height(40)
              .fontSize(14)
              .backgroundColor($r('app.color.surface'))
              .fontColor($r('app.color.fg'))
              .caretColor($r('app.color.accent'))
              .onChange((value: string) => {
                this.name = value
              })
            Text($r('app.string.match_host'))
              .fontSize(12)
              .fontColor($r('app.color.fg_secondary'))
            TextInput({ text: this.matchHost, placeholder: $r('app.string.all_sites') })
              .height(40)
              .fontSize(14)
              .backgroundColor($r('app.color.surface'))
              .fontColor($r('app.color.fg'))
              .placeholderColor($r('app.color.fg_secondary'))
              .caretColor($r('app.color.accent'))
              .onChange((value: string) => {
                this.matchHost = value
              })
            Text('源地址')
              .fontSize(12)
              .fontColor($r('app.color.fg_secondary'))
            TextInput({ text: this.sourceUrl, placeholder: 'https:// （可选，供「更新」拉取）' })
              .height(40)
              .fontSize(14)
              .backgroundColor($r('app.color.surface'))
              .fontColor($r('app.color.fg'))
              .placeholderColor($r('app.color.fg_secondary'))
              .caretColor($r('app.color.accent'))
              .onChange((value: string) => {
                this.sourceUrl = value
              })
            Text($r('app.string.script_code'))
              .fontSize(12)
              .fontColor($r('app.color.fg_secondary'))
            TextArea({ text: this.code })
              .height(140)
              .fontSize(13)
              .backgroundColor($r('app.color.surface'))
              .fontColor($r('app.color.fg'))
              .caretColor($r('app.color.accent'))
              .onChange((value: string) => {
                this.code = value
              })
          }
          .alignItems(HorizontalAlign.Start)
          Row({ space: 12 }) {
            Button($r('app.string.cancel'))
              .fontSize(14)
              .height(36)
              .layoutWeight(1)
              .backgroundColor($r('app.color.surface'))
              .fontColor($r('app.color.fg'))
              .onClick(() => {
                this.onClose()
              })
            Button($r('app.string.save'))
              .fontSize(14)
              .height(36)
              .layoutWeight(1)
              .backgroundColor($r('app.color.accent'))
              .fontColor(Color.White)
              .onClick(() => {
                this.save()
              })
          }
          .width('100%')
        }
        .width('90%')
        .padding(20)
      }
      .layoutWeight(1)
      .align(Alignment.Top)
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.5)')
    .onClick(() => {
      this.onClose()
    })
  }

  private save(): void {
    const name = this.name.trim()
    if (name === '' || this.code.trim() === '') {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.invalid_input'), duration: 1500 })
      return
    }
    const rec = new UserScriptRec()
    if (this.script !== null) {
      rec.id = this.script.id
    } else {
      rec.id = Date.now()
    }
    rec.name = name
    rec.matchHost = this.matchHost.trim().toLowerCase()
    rec.code = this.code
    rec.sourceUrl = this.sourceUrl.trim()
    rec.enabled = this.script !== null ? this.script.enabled : true
    this.settings.saveScript(rec)
    this.onSaved()
  }
}

@Builder
export function UserScriptsPageBuilder() {
  UserScriptsPage()
}
