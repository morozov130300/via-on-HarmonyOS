import { AppSettings } from '../common/Settings'
import { RemoteConfig } from '../common/RemoteConfig'
import { SettingNavRow, SettingCheckRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'

@ComponentV2
export struct SettingsAdBlockPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  private bindAppBar(): void {
    AppBar.show({
      title: '广告拦截',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            SettingCheckRow({
              rowLabel: '广告拦截',
              // 原版 z7/d.java:45：关→「未启用」(g_)；开→「已拦截 %1$d 个广告，共节省 %2$s」(b6)
              rowDesc: this.settings.adBlockOn
                ? `已拦截 ${this.settings.adBlockTotal} 个广告，共节省 ${this.formatBytes(this.settings.adBlockSavedBytes)}`
                : '未启用',
              isChecked: this.settings.adBlockOn,
              onCheckRow: (isOn: boolean) => {
                this.settings.setAdBlockOn(isOn)
              }
            })
            SettingCheckRow({
              rowLabel: '启用内建规则',
              rowDesc: '内建规则仅拦截常见广告',
              isChecked: this.settings.adBlockBuiltin,
              onCheckRow: (isOn: boolean) => {
                this.settings.setAdBlockBuiltin(isOn)
              }
            })
            SettingNavRow({
              rowLabel: '自定义规则',
              rowDesc: '包括拦截的规则、标记的广告',
              onTapRow: () => {
                this.navPathStack.pushPathByName('rules', '', true)
              }
            })
            SettingNavRow({
              rowLabel: '规则订阅',
              rowDesc: '订阅 Adblock Plus 规则列表',
              onTapRow: () => {
                this.navPathStack.pushPathByName('ruleSub', '', true)
              }
            })
            // 原版 z7/d.java:49-55：r9 fl1 位开关（h.e() = !(第1位)，默认可见）控制第 5 项显隐
            if (RemoteConfig.getInstance().autoExpandSwitchVisible) {
              SettingCheckRow({
                rowLabel: '自动展开网页全文',
                rowDesc: '打开网页时自动展开网页中折叠的内容',
                isChecked: this.settings.autoExpandFullText,
                onCheckRow: (isOn: boolean) => {
                  this.settings.setAutoExpandFullText(isOn)
                }
              })
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
    .hideTitleBar(true)
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

  private formatBytes(bytes: number): string {
    if (bytes < 1024) {
      return `${bytes.toFixed(1)} B`
    }
    if (bytes < 1024 * 1024) {
      return `${(bytes / 1024).toFixed(1)} KB`
    }
    if (bytes < 1024 * 1024 * 1024) {
      return `${(bytes / 1024 / 1024).toFixed(1)} MB`
    }
    return `${(bytes / 1024 / 1024 / 1024).toFixed(1)} GB`
  }
}

@Builder
export function SettingsAdBlockPageBuilder() {
  SettingsAdBlockPage()
}
