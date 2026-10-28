import { AppSettings } from '../common/Settings'
import { UA_TABLE, UaDef, uaByKey, CustomUaEntry } from '../common/UaTable'
import { SettingNavRow, SettingRadioRow, SettingCheckRow } from '../components/SettingRows'
import { SettingsHeader } from '../components/SettingsHeader'

@ComponentV2
export struct UaPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '浏览器标识',
          rightIcon: $r('sys.symbol.plus'),
          onBack: () => {
            this.navPathStack.pop()
          },
          onRight: () => {
            this.navPathStack.pushPathByName('uaEditPage', 'new', true)
          }
        })
        Scroll() {
          Column() {
            ForEach(UA_TABLE, (def: UaDef) => {
              SettingRadioRow({
                rowLabel: def.label,
                isSelected: this.settings.uaKey === def.key,
                onTapRow: () => {
                  this.settings.setUaKey(def.key)
                }
              })
            }, (def: UaDef) => def.key)

            ForEach(this.settings.customUaList, (entry: CustomUaEntry) => {
              SettingRadioRow({
                rowLabel: entry.title,
                isSelected: this.isCustomSelected(entry),
                onTapRow: () => {
                  this.settings.setCustomUa(entry.ua)
                  this.settings.setUaKey('custom')
                }
              })
            }, (entry: CustomUaEntry) => entry.title)

            Text('高级')
              .fontSize(13)
              .fontColor($r('app.color.fg_secondary'))
              .width('100%')
              .padding({ left: 16, top: 16, bottom: 6 })

            SettingNavRow({ rowLabel: '电脑模式下的浏览器标识', rowValue: this.desktopUaLabel(), onTapRow: () => {
              this.pickDesktopUa()
            } })
            SettingCheckRow({
              rowLabel: '简化浏览器标识',
              rowDesc: '从浏览器标识中移除设备信息及次要版本信息',
              isChecked: this.settings.simplifyUa,
              onCheckRow: (isOn: boolean) => {
                this.settings.setSimplifyUa(isOn)
              }
            })

            if (this.settings.customUaList.length > 0) {
              Text('自定义')
                .fontSize(13)
                .fontColor($r('app.color.fg_secondary'))
                .width('100%')
                .padding({ left: 16, top: 16, bottom: 6 })
              ForEach(this.settings.customUaList, (entry: CustomUaEntry) => {
                Row() {
                  Column() {
                    Text(entry.title)
                      .fontSize(15)
                      .fontColor($r('app.color.fg'))
                      .maxLines(1)
                    Text(entry.ua)
                      .fontSize(12)
                      .fontColor($r('app.color.fg_secondary'))
                      .maxLines(1)
                      .margin({ top: 2 })
                  }
                  .alignItems(HorizontalAlign.Start)
                  .layoutWeight(1)
                  Text('编辑')
                    .fontSize(14)
                    .fontColor($r('app.color.fg_secondary'))
                    .padding({ left: 10, right: 10 })
                    .onClick(() => {
                      this.navPathStack.pushPathByName('uaEditPage', entry.title, true)
                    })
                  Text('删除')
                    .fontSize(14)
                    .fontColor($r('app.color.fg_secondary'))
                    .padding({ left: 10, right: 6 })
                    .onClick(() => {
                      this.removeCustom(entry)
                    })
                }
                .width('100%')
                .padding({ left: 16, right: 16, top: 11, bottom: 11 })
                .alignItems(VerticalAlign.Center)
              }, (entry: CustomUaEntry) => `manage_${entry.title}`)
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

  private isCustomSelected(entry: CustomUaEntry): boolean {
    return this.settings.uaKey === 'custom' && this.settings.customUa === entry.ua
  }

  private desktopUaLabel(): string {
    const def = uaByKey(this.settings.desktopUaKey)
    if (def !== null) {
      return def.label
    }
    return UA_TABLE[3].label
  }

  private pickDesktopUa(): void {
    const sheets: SheetInfo[] = []
    for (let i = 0; i < UA_TABLE.length; i++) {
      const def = UA_TABLE[i]
      sheets.push({
        title: def.label,
        action: (): void => {
          this.settings.setDesktopUaKey(def.key)
        }
      })
    }
    ActionSheet.show({
      title: '电脑模式下的浏览器标识',
      message: '开启电脑模式后使用的浏览器标识',
      sheets: sheets
    })
  }

  private removeCustom(entry: CustomUaEntry): void {
    this.settings.removeCustomUaEntry(entry.title)
    if (this.settings.uaKey === 'custom' && this.settings.customUa === entry.ua) {
      this.settings.setCustomUa('')
      this.settings.setUaKey('default')
    }
  }
}

@Builder
export function UaPageBuilder() {
  UaPage()
}
