import { RuleEntry } from '../common/Types'
import { AppSettings } from '../common/Settings'
import { AdBlocker } from '../common/AdBlock'
import { AppIcon } from '../components/AppIcon'

@ComponentV2
export struct RulesPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local domainInput: string = ''

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
}

@Builder
export function RulesPageBuilder() {
  RulesPage()
}
