import { AppSettings } from '../common/Settings'
import { UA_TABLE, UaDef, uaByKey, CustomUaEntry } from '../common/UaTable'
import { SettingNavRow, SettingRadioRow, SettingCheckRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { BusinessError } from '@kit.BasicServicesKit'
import { computeDialogWidthVp } from '../components/ViaDialogCard'
import { dialogTransition } from '../common/Transitions'

// 原版 hb/y7.java：浏览器标识页
// 列表 = 内置 UA（b4.b）+ 自定义 UA 追加；点击单选；长按自定义 → 编辑/删除（m3）
// 高级分区：电脑模式下的浏览器标识（a12，单选 {默认, Chrome(PC), IE11(PC), macOS} + 自定义，r3）
//           简化浏览器标识（a13，描述 a14）
@ComponentV2
export struct UaPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // y7.r3：电脑模式下的浏览器标识居中单选弹窗（b0 无按钮：点击即生效并关闭）
  @Local desktopDialogId: number = -1
  @Local desktopOptions: string[] = []
  @Local desktopChecked: number = -1

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

  // 原版 y7.r3()：w5.k.l().e0(a12 电脑模式下的浏览器标识).b0(候选, 选中).f0()
  // 候选 = d()>0（自定义）∪ {0 默认, -3 Chrome(PC), -4 IE11(PC), -5 macOS}；居中单选，点击即生效
  private pickDesktopUa(): void {
    const candidates = this.desktopCandidates()
    const options: string[] = []
    let checked = -1
    for (let i = 0; i < candidates.length; i++) {
      const item = candidates[i]
      if (item instanceof CustomUaEntry) {
        options.push(item.title)
      } else {
        options.push((item as UaDef).label)
      }
      if (item instanceof CustomUaEntry) {
        if (this.settings.desktopUaKey === 'custom' && this.settings.desktopCustomUa === item.ua) {
          checked = i
        }
      } else if (this.settings.desktopUaKey === (item as UaDef).key) {
        checked = i
      }
    }
    this.desktopOptions = options
    this.desktopChecked = checked
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.DesktopUaDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.desktopDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open desktop ua dialog failed: ${error.message}`)
    })
  }

  @Builder
  DesktopUaDialog() {
    Column() {
      Text('电脑模式下的浏览器标识')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      ForEach(this.desktopOptions, (label: string, index: number) => {
        // 原版 layout v.xml + w5.d：16dp 圆形复选框 + drawablePadding 24 + 14sp
        Row({ space: 24 }) {
          Circle({ width: 16, height: 16 })
            .fill(this.desktopChecked === index ? $r('app.color.accent') : Color.Transparent)
            .stroke(this.desktopChecked === index ? Color.Transparent : $r('app.color.dialog_border'))
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
          const candidates = this.desktopCandidates()
          if (index >= 0 && index < candidates.length) {
            const item = candidates[index]
            if (item instanceof CustomUaEntry) {
              this.settings.setDesktopUaKey('custom')
              this.settings.setDesktopCustomUa(item.ua)
            } else {
              this.settings.setDesktopUaKey((item as UaDef).key)
            }
          }
          this.closeDesktopUaDialog()
        })
      }, (label: string) => label)
    }
    .width(computeDialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeDesktopUaDialog(): void {
    if (this.desktopDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.desktopDialogId)
    this.desktopDialogId = -1
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
