import { AppSettings } from '../common/Settings'
import { uaByKey } from '../common/UaTable'
import { SettingNavRow } from '../components/SettingRows'
import { SettingsHeader } from '../components/SettingsHeader'

@ComponentV2
export struct SiteSettingsPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local desktopDialogId: number = -1
  @Local imageDialogId: number = -1
  @Local jsDialogId: number = -1

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '网站设定',
          onBack: () => {
            this.navPathStack.pop()
          }
        })
        Scroll() {
          Column() {
            SettingNavRow({
              rowLabel: '所有网站',
              onTapRow: () => {
                this.navPathStack.pushPathByName('siteAll', '', true)
              }
            })
            Text('内容')
              .fontSize(13)
              .fontColor($r('app.color.accent'))
              .width('100%')
              .padding({ left: 16, top: 14, bottom: 4 })
            SettingNavRow({
              rowLabel: '字体大小',
              rowValue: `${this.settings.textZoom}%`,
              onTapRow: () => {
                this.navPathStack.pushPathByName('fontSettings', '', true)
              }
            })
            SettingNavRow({
              rowLabel: '浏览器标识',
              rowValue: this.uaLabel(),
              onTapRow: () => {
                this.navPathStack.pushPathByName('uaPage', '', true)
              }
            })
            SettingNavRow({
              rowLabel: '电脑模式',
              rowValue: this.settings.desktopAllSites === 1 ? '打开' : '关闭',
              onTapRow: () => {
                this.pickDesktop()
              }
            })
            SettingNavRow({
              rowLabel: '图像',
              rowValue: this.settings.noImage ? '阻止' : '允许',
              onTapRow: () => {
                this.pickImage()
              }
            })
            SettingNavRow({
              rowLabel: 'JavaScript',
              rowValue: this.settings.scriptEnabled ? '允许' : '阻止',
              onTapRow: () => {
                this.pickJs()
              }
            })
            SettingNavRow({
              rowLabel: 'Cookies',
              rowValue: '允许',
              onTapRow: () => {
                this.openPermission('cookies', 'Cookies', '允许网站读写 Cookies')
              }
            })
            SettingNavRow({
              rowLabel: '弹出式窗口',
              rowValue: '允许',
              onTapRow: () => {
                this.openPermission('popups', '弹出式窗口', '允许网站打开弹出式窗口')
              }
            })
            Text('基本')
              .fontSize(13)
              .fontColor($r('app.color.accent'))
              .width('100%')
              .padding({ left: 16, top: 14, bottom: 4 })
            SettingNavRow({
              rowLabel: '广告拦截',
              rowValue: this.settings.adBlockOn ? '打开' : '关闭',
              onTapRow: () => {
                this.navPathStack.pushPathByName('adBlockException', '', true)
              }
            })
            Text('权限')
              .fontSize(13)
              .fontColor($r('app.color.accent'))
              .width('100%')
              .padding({ left: 16, top: 14, bottom: 4 })
            SettingNavRow({
              rowLabel: '剪贴板',
              rowValue: '允许',
              onTapRow: () => {
                this.openPermission('clipboard', '剪贴板', '允许网站使用剪贴板')
              }
            })
            SettingNavRow({
              rowLabel: '打开应用',
              rowValue: '优先询问',
              onTapRow: () => {
                this.openPermission('openapp', '打开应用', '网站需先确认站点的所属与将要跳转才能打开应用')
              }
            })
            SettingNavRow({
              rowLabel: '位置信息',
              rowValue: '已禁止',
              onTapRow: () => {
                this.openPermission('geo', '位置信息', '网站需先询问并得到许可才能使用位置信息')
              }
            })
            SettingNavRow({
              rowLabel: '摄像头',
              rowValue: '优先询问',
              onTapRow: () => {
                this.openPermission('camera', '摄像头', '网站需先询问并得到许可才能使用摄像头')
              }
            })
            SettingNavRow({
              rowLabel: '麦克风',
              rowValue: '优先询问',
              onTapRow: () => {
                this.openPermission('mic', '麦克风', '网站需先询问并得到许可才能使用麦克风')
              }
            })
            SettingNavRow({
              rowLabel: '页面重定向',
              rowValue: '允许',
              onTapRow: () => {
                this.openPermission('redirect', '页面重定向', '允许网站重定向当前页面')
              }
            })
            SettingNavRow({
              rowLabel: '振动',
              rowValue: '已禁止',
              onTapRow: () => {
                this.openPermission('vibrate', '振动', '允许网站触发设备振动')
              }
            })
            Text('高级')
              .fontSize(13)
              .fontColor($r('app.color.accent'))
              .width('100%')
              .padding({ left: 16, top: 14, bottom: 4 })
            SettingNavRow({
              rowLabel: '返回不重载',
              rowValue: '打开',
              onTapRow: () => {
                this.openPermission('backreload', '返回不重载', '返回上一页时使用缓存而不重新加载')
              }
            })
          }
          .width('100%')
          .padding({ bottom: 20 })
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
    })
  }

  private uaLabel(): string {
    if (this.settings.uaKey === 'custom') {
      return '自定义'
    }
    const def = uaByKey(this.settings.uaKey)
    return def !== null ? def.label : '默认'
  }

  private pickDesktop(): void {
    const sheets: SheetInfo[] = [
      { title: '关闭', action: (): void => {
        this.settings.setDesktopAllSites(0)
      } },
      { title: '允许所有网站', action: (): void => {
        this.settings.setDesktopAllSites(1)
      } }
    ]
    ActionSheet.show({
      title: '电脑模式',
      message: '所有网站均使用电脑模式浏览器标识',
      sheets: sheets
    })
  }

  private pickImage(): void {
    const sheets: SheetInfo[] = [
      { title: '允许', action: (): void => {
        this.settings.setNoImage(false)
      } },
      { title: '阻止', action: (): void => {
        this.settings.setNoImage(true)
      } }
    ]
    ActionSheet.show({
      title: '图像',
      message: '控制网站图片的加载',
      sheets: sheets
    })
  }

  private pickJs(): void {
    const sheets: SheetInfo[] = [
      { title: '允许', action: (): void => {
        this.settings.setScriptEnabled(true)
      } },
      { title: '阻止', action: (): void => {
        this.settings.setScriptEnabled(false)
      } }
    ]
    ActionSheet.show({
      title: 'JavaScript',
      message: '控制网站脚本的执行',
      sheets: sheets
    })
  }

  private openPermission(kind: string, title: string, desc: string): void {
    const payload: Record<string, string> = { 'kind': kind, 'title': title, 'desc': desc } as Record<string, string>
    this.navPathStack.pushPathByName('permissionPage', JSON.stringify(payload), true)
  }
}

@Builder
export function SiteSettingsPageBuilder() {
  SiteSettingsPage()
}
