import { RuleEntry } from '../common/Types'
import { AppSettings } from '../common/Settings'
import { AdBlocker } from '../common/AdBlock'
import { AppIcon } from '../components/AppIcon'
import { http } from '@kit.NetworkKit'

const SUBSCRIBE_MAX_LINES: number = 20000

@ComponentV2
export struct RulesPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local domainInput: string = ''
  @Local subInput: string = ''
  @Local subscribing: boolean = false

  aboutToAppear(): void {
    this.subInput = this.settings.ruleSubUrl
  }

  build() {
    NavDestination() {
      Column() {
        if (this.settings.customRules.length === 0) {
          Column() {
            Text($r('app.string.no_rules'))
              .fontSize(14)
              .fontColor($r('app.color.fg_secondary'))
          }
          .width('100%')
          .layoutWeight(1)
          .justifyContent(FlexAlign.Center)
        } else {
          List({ space: 1 }) {
            ForEach(this.settings.customRules, (rule: RuleEntry) => {
              ListItem() {
                Row({ space: 12 }) {
                  Text(rule.isAllow ? $r('app.string.allow') : $r('app.string.block'))
                    .fontSize(11)
                    .fontColor(rule.isAllow ? Color.White : $r('app.color.fg'))
                    .padding({ left: 8, right: 8, top: 2, bottom: 2 })
                    .borderRadius(8)
                    .backgroundColor(rule.isAllow ? $r('app.color.accent') : $r('app.color.divider'))
                  Text(rule.domain)
                    .fontSize(15)
                    .fontColor($r('app.color.fg'))
                    .layoutWeight(1)
                    .maxLines(1)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                  AppIcon({ icon: $r('sys.symbol.trash'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
                    .onClick(() => {
                      this.removeRule(rule)
                    })
                }
                .width('100%')
                .height(52)
                .padding({ left: 16, right: 16 })
              }
            }, (rule: RuleEntry) => `${rule.domain}-${rule.isAllow}`)
          }
          .width('100%')
          .layoutWeight(1)
          .divider({ strokeWidth: 0.5, color: $r('app.color.divider') })
        }
        Row({ space: 8 }) {
          TextInput({ placeholder: $r('app.string.subscription_url_hint'), text: this.subInput })
            .layoutWeight(1)
            .height(40)
            .fontSize(13)
            .backgroundColor($r('app.color.surface'))
            .fontColor($r('app.color.fg'))
            .placeholderColor($r('app.color.fg_secondary'))
            .caretColor($r('app.color.accent'))
            .onChange((value: string) => {
              this.subInput = value
            })
          Button(this.subscribing ? '...' : $r('app.string.update_subscription'))
            .fontSize(13)
            .height(36)
            .backgroundColor($r('app.color.surface'))
            .fontColor($r('app.color.fg'))
            .onClick(() => {
              this.subscribe()
            })
        }
        .width('100%')
        .padding(12)
        Row({ space: 8 }) {
          TextInput({ placeholder: $r('app.string.rule_hint'), text: this.domainInput })
            .layoutWeight(1)
            .height(40)
            .fontSize(14)
            .backgroundColor($r('app.color.surface'))
            .fontColor($r('app.color.fg'))
            .placeholderColor($r('app.color.fg_secondary'))
            .caretColor($r('app.color.accent'))
            .onChange((value: string) => {
              this.domainInput = value
            })
          Button($r('app.string.block'))
            .fontSize(13)
            .height(36)
            .backgroundColor($r('app.color.surface'))
            .fontColor($r('app.color.fg'))
            .onClick(() => {
              this.addRule(false)
            })
          Button($r('app.string.allow'))
            .fontSize(13)
            .height(36)
            .backgroundColor($r('app.color.accent'))
            .fontColor(Color.White)
            .onClick(() => {
              this.addRule(true)
            })
        }
        .width('100%')
        .padding(12)
      }
      .width('100%')
      .height('100%')
    }
    .title($r('app.string.custom_rules'))
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }

  private addRule(isAllow: boolean): void {
    const domain = this.domainInput.trim().toLowerCase()
    if (domain === '') {
      return
    }
    this.settings.addRule(domain, isAllow)
    AdBlocker.getInstance().rebuildCustomRules()
    this.domainInput = ''
  }

  private removeRule(rule: RuleEntry): void {
    this.settings.removeRule(rule.domain)
    AdBlocker.getInstance().rebuildCustomRules()
  }

  private async subscribe(): Promise<void> {
    if (this.subscribing) {
      return
    }
    const url = this.subInput.trim()
    if (url === '') {
      return
    }
    this.subscribing = true
    this.settings.setRuleSubUrl(url)
    const request = http.createHttp()
    try {
      const response = await request.request(url, {
        method: http.RequestMethod.GET,
        connectTimeout: 10000,
        readTimeout: 30000,
        usingCache: false
      })
      const body = response.result
      if (typeof body !== 'string') {
        this.getUIContext().getPromptAction().showToast({ message: $r('app.string.download_failed'), duration: 1500 })
        this.subscribing = false
        request.destroy()
        return
      }
      const lines = body.split('\n')
      let added = 0
      for (let i = 0; i < lines.length && i < SUBSCRIBE_MAX_LINES; i++) {
        const line = lines[i].trim()
        if (line === '' || line.startsWith('!') || line.startsWith('[')) {
          continue
        }
        const isAllow = line.startsWith('@@')
        const rest = isAllow ? line.substring(2) : line
        if (!rest.startsWith('||')) {
          continue
        }
        let host = rest.substring(2).toLowerCase()
        const cutChars = ['^', '/', '$', '|', '?', ',']
        for (let j = 0; j < cutChars.length; j++) {
          const pos = host.indexOf(cutChars[j])
          if (pos >= 0) {
            host = host.substring(0, pos)
          }
        }
        if (host !== '' && host.indexOf('*') < 0 && host.indexOf('.') > 0) {
          this.settings.addRule(host, isAllow)
          added = added + 1
        }
      }
      AdBlocker.getInstance().rebuildCustomRules()
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.rules_added', added), duration: 1500 })
    } catch (error) {
      const err = error as BusinessError
      console.error(`subscribe rules failed: ${err.message}`)
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.download_failed'), duration: 1500 })
    }
    this.subscribing = false
    request.destroy()
  }
}

@Builder
export function RulesPageBuilder() {
  RulesPage()
}
