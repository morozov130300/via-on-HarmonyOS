import { AppSettings, UA_MODE_DEFAULT, UA_MODE_PC, UA_MODE_MOBILE } from '../common/Settings'
import { BrowserDb } from '../common/Database'
import { findEngine } from '../common/SearchEngines'
import { AppIcon } from '../components/AppIcon'

@ComponentV2
export struct SettingsPage {
  private settings: AppSettings = AppSettings.getInstance()
  private db: BrowserDb = BrowserDb.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local zoomValue: number = 100

  aboutToAppear(): void {
    this.zoomValue = this.settings.textZoom
  }

  build() {
    NavDestination() {
      Scroll() {
        Column() {
          this.SettingRow($r('sys.symbol.magnifyingglass'), $r('app.string.search_engine'),
            findEngine(this.settings.engineKey).name, () => {
              this.pickEngine()
            })
          this.SettingToggleRow($r('sys.symbol.checkmark_shield'), $r('app.string.ad_block'),
            this.settings.adBlockOn, (isOn: boolean) => {
              this.settings.setAdBlockOn(isOn)
            })
          this.SettingToggleRow($r('sys.symbol.moon'), $r('app.string.night_mode'),
            this.settings.nightMode, (isOn: boolean) => {
              this.settings.setNightMode(isOn)
            })
          this.SettingToggleRow($r('sys.symbol.eye_slash'), $r('app.string.no_image_mode'),
            this.settings.noImage, (isOn: boolean) => {
              this.settings.setNoImage(isOn)
            })
          this.SettingToggleRow($r('sys.symbol.clock_fill'), $r('app.string.restore_tabs'),
            this.settings.restoreTabs, (isOn: boolean) => {
              this.settings.setRestoreTabs(isOn)
            })
          this.SettingRow($r('sys.symbol.person'), $r('app.string.version'),
            this.uaLabel(), () => {
              this.pickUa()
            })
          Row({ space: 14 }) {
            AppIcon({ icon: $r('sys.symbol.textformat_size_square'), iconSize: 20 })
            Text($r('app.string.text_size'))
              .fontSize(15)
              .fontColor($r('app.color.fg'))
            Blank()
            Text(`${this.zoomValue}%`)
              .fontSize(14)
              .fontColor($r('app.color.fg_secondary'))
          }
          .width('100%')
          .height(40)
          .padding({ left: 20, right: 20 })
          Slider({ value: this.zoomValue, min: 50, max: 200, step: 5 })
            .width('88%')
            .onChange((value: number, mode: SliderChangeMode) => {
              this.zoomValue = value
              if (mode === SliderChangeMode.End) {
                this.settings.setTextZoom(value)
              }
            })
          this.SettingRow($r('sys.symbol.trash'), $r('app.string.clear_data'), '', () => {
            this.confirmClear()
          })
          this.SettingRow($r('sys.symbol.slider_horizontal_2'), $r('app.string.site_settings'), '', () => {
            this.navPathStack.pushPathByName('siteSettings', '', true)
          })
          this.SettingRow($r('sys.symbol.checkmark_shield'), $r('app.string.custom_rules'), '', () => {
            this.navPathStack.pushPathByName('rules', '', true)
          })
          this.SettingRow($r('sys.symbol.doc_plaintext_and_pencil'), $r('app.string.user_scripts'), '', () => {
            this.navPathStack.pushPathByName('userScripts', '', true)
          })
          this.SettingRow($r('sys.symbol.doc_text_fill'), $r('app.string.about'),
            'Via for HarmonyOS', () => {
            })
        }
        .width('100%')
      }
      .width('100%')
      .height('100%')
      .align(Alignment.Top)
    }
    .title($r('app.string.settings'))
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }

  @Builder
  SettingRow(icon: Resource, label: Resource, value: string, action: () => void) {
    Row({ space: 14 }) {
      AppIcon({ icon: icon, iconSize: 20 })
      Text(label)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .layoutWeight(1)
      if (value !== '') {
        Text(value)
          .fontSize(13)
          .fontColor($r('app.color.fg_secondary'))
          .maxLines(1)
      }
      AppIcon({ icon: $r('sys.symbol.chevron_right'), iconSize: 14, iconColor: $r('app.color.fg_secondary') })
    }
    .width('100%')
    .height(48)
    .padding({ left: 20, right: 20 })
    .onClick(() => {
      action()
    })
  }

  @Builder
  SettingToggleRow(icon: Resource, label: Resource, isOn: boolean, change: (isOn: boolean) => void) {
    Row({ space: 14 }) {
      AppIcon({ icon: icon, iconSize: 20 })
      Text(label)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .layoutWeight(1)
      Toggle({ type: ToggleType.Switch, isOn: isOn })
        .onChange((value: boolean) => {
          change(value)
        })
    }
    .width('100%')
    .height(48)
    .padding({ left: 20, right: 20 })
  }

  private uaLabel(): string {
    if (this.settings.uaMode === UA_MODE_PC) {
      return '电脑版'
    }
    if (this.settings.uaMode === UA_MODE_MOBILE) {
      return '手机版'
    }
    return '默认'
  }

  private pickEngine(): void {
    const sheets: SheetInfo[] = [
      { title: '百度', action: (): void => {
        this.settings.setEngineKey('baidu')
      } },
      { title: '必应', action: (): void => {
        this.settings.setEngineKey('bing')
      } },
      { title: '搜狗', action: (): void => {
        this.settings.setEngineKey('sogou')
      } },
      { title: '360搜索', action: (): void => {
        this.settings.setEngineKey('so360')
      } },
      { title: '神马', action: (): void => {
        this.settings.setEngineKey('shenma')
      } },
      { title: '夸克', action: (): void => {
        this.settings.setEngineKey('quark')
      } },
      { title: 'Google', action: (): void => {
        this.settings.setEngineKey('google')
      } }
    ]
    ActionSheet.show({
      title: $r('app.string.search_engine'),
      message: '选择默认搜索引擎',
      sheets: sheets
    })
  }

  private pickUa(): void {
    const sheets: SheetInfo[] = [
      { title: '默认', action: (): void => {
        this.settings.setUaMode(UA_MODE_DEFAULT)
      } },
      { title: '电脑版', action: (): void => {
        this.settings.setUaMode(UA_MODE_PC)
      } },
      { title: '手机版', action: (): void => {
        this.settings.setUaMode(UA_MODE_MOBILE)
      } }
    ]
    ActionSheet.show({
      title: $r('app.string.version'),
      message: '选择网页浏览器标识',
      sheets: sheets
    })
  }

  private confirmClear(): void {
    AlertDialog.show({
      title: $r('app.string.clear_data'),
      message: '将清除历史记录、下载记录与搜索历史',
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: $r('app.string.confirm'),
        action: () => {
          this.db.clearHistory().catch((error: BusinessError) => {
            console.error(`clear history failed: ${error.message}`)
          })
          this.db.clearDownloads().catch((error: BusinessError) => {
            console.error(`clear downloads failed: ${error.message}`)
          })
          this.settings.clearSearchHistory()
          this.getUIContext().getPromptAction().showToast({ message: $r('app.string.cleared'), duration: 1500 })
        }
      }
    })
  }
}

@Builder
export function SettingsPageBuilder() {
  SettingsPage()
}
