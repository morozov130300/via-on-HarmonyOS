import { AppSettings } from '../common/Settings'
import { UA_TABLE, UaDef, uaByKey, CustomUaEntry } from '../common/UaTable'
import { SettingNavRow, SettingRadioRow, SettingCheckRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'

// 原版 hb/y7.java：浏览器标识页
// 列表 = 内置 UA（b4.b）+ 自定义 UA 追加；点击单选；长按自定义 → 编辑/删除（m3）
// 高级分区：电脑模式下的浏览器标识（a12，单选 {默认, Chrome(PC), IE11(PC), macOS} + 自定义，r3）
//           简化浏览器标识（a13，描述 a14）
@ComponentV2
export struct UaPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  private bindAppBar(): void {
    AppBar.show({
      title: '浏览器标识',
      rightIcon: $r('sys.symbol.plus'),
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight: () => {
        this.navPathStack.pushPathByName('uaEditPage', 'new', true)
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
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
                },
                onLongPressRow: () => {
                  this.showCustomMenu(entry)
                }
              })
            }, (entry: CustomUaEntry) => entry.title)

            Text('高级')
              .fontSize(13)
              .fontColor($r('app.color.fg_secondary'))
              .width('100%')
              .padding({ left: 16, top: 16, bottom: 6 })

            SettingNavRow({
              rowLabel: '电脑模式下的浏览器标识',
              rowValue: this.desktopUaLabel(),
              onTapRow: () => {
                this.pickDesktopUa()
              }
            })
            SettingCheckRow({
              rowLabel: '简化浏览器标识',
              rowDesc: '从浏览器标识中移除设备信息及次要版本信息',
              isChecked: this.settings.simplifyUa,
              onCheckRow: (isOn: boolean) => {
                this.settings.setSimplifyUa(isOn)
              }
            })
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
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  private isCustomSelected(entry: CustomUaEntry): boolean {
    return this.settings.uaKey === 'custom' && this.settings.customUa === entry.ua
  }

  // 原版 r3：候选 = 默认/Chrome(PC)/IE11(PC)/macOS + 全部自定义
  private desktopCandidates(): Array<UaDef | CustomUaEntry> {
    const subsetKeys: string[] = ['default', 'win_chrome', 'win_ie11', 'mac']
    const list: Array<UaDef | CustomUaEntry> = []
    for (let i = 0; i < UA_TABLE.length; i++) {
      if (subsetKeys.indexOf(UA_TABLE[i].key) >= 0) {
        list.push(UA_TABLE[i])
      }
    }
    for (let i = 0; i < this.settings.customUaList.length; i++) {
      list.push(this.settings.customUaList[i])
    }
    return list
  }

  private desktopUaLabel(): string {
    if (this.settings.desktopUaKey === 'custom') {
      const found = this.settings.customUaList.find((e: CustomUaEntry): boolean => e.ua === this.settings.desktopCustomUa)
      if (found !== undefined) {
        return found.title
      }
      return ''
    }
    const def = uaByKey(this.settings.desktopUaKey)
    if (def !== null) {
      return def.label
    }
    return UA_TABLE[3].label
  }

  private pickDesktopUa(): void {
    const candidates = this.desktopCandidates()
    const sheets: SheetInfo[] = []
    for (let i = 0; i < candidates.length; i++) {
      const item = candidates[i]
      sheets.push({
        title: item instanceof CustomUaEntry ? item.title : (item as UaDef).label,
        action: (): void => {
          if (item instanceof CustomUaEntry) {
            this.settings.setDesktopUaKey('custom')
            this.settings.setDesktopCustomUa(item.ua)
          } else {
            this.settings.setDesktopUaKey((item as UaDef).key)
          }
        }
      })
    }
    ActionSheet.show({
      title: '电脑模式下的浏览器标识',
      message: '',
      sheets: sheets
    })
  }

  // 原版 m3：长按自定义 UA → [编辑, 删除]
  private showCustomMenu(entry: CustomUaEntry): void {
    ActionSheet.show({
      title: '选择操作',
      message: '',
      sheets: [
        {
          title: '编辑',
          action: (): void => {
            this.navPathStack.pushPathByName('uaEditPage', entry.title, true)
          }
        },
        {
          title: '删除',
          action: (): void => {
            this.removeCustom(entry)
          }
        }
      ]
    })
  }

  // 原版 k3：删除自定义；若为当前选中项则回退到列表首项（默认）
  private removeCustom(entry: CustomUaEntry): void {
    const wasSelected = this.isCustomSelected(entry)
    this.settings.removeCustomUaEntry(entry.title)
    if (wasSelected) {
      this.settings.setCustomUa('')
      this.settings.setUaKey('default')
    }
  }
}

@Builder
export function UaPageBuilder() {
  UaPage()
}
