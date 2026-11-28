import { TOAST_SHORT } from '../common/ToastDuration'
import { common } from '@kit.AbilityKit'
import { AppSettings } from '../common/Settings'
import { LogFileService } from '../common/LogFileService'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { SettingCheckRow, SettingNavRow } from '../components/SettingRows'
import { buildNavSlide } from './PageTransitions'

// 原版实验页（hb/y1，标题 u.R4 = 实验），行序 i3()：
// 1. 皮肤行（a6.q，标题 u.Tc「皮肤」）→ k3：g6.i.g(lb.k) 进皮肤页
// 2. 「模糊效果」开关（a6.n，SDK>=31；u.cy/u.cz，w9.d 位2）
// 3. 「在设置中显示背景」开关（a6.n，z8.l3.f14720a=SDK>=29 恒真；u.tu，w9.d 位4），
//    切换 j3 → toast u.tv「将在下次打开设置时生效」
@ComponentV2
export struct SettingsExperimentalPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // 导出中状态：防止重复触发导出
  @Local exportingLog: boolean = false
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'

  private toast(message: ResourceStr): void {
    this.getUIContext().getPromptAction().showToast({ message: message, duration: TOAST_SHORT })
  }

  // 导出日志：系统文件管理器选位置 → 复制沙箱日志到用户 URI；成功后删除本地文件，
  // 后续日志由 append 重建（取消/失败原文件不动）
  private exportLog(): void {
    if (this.exportingLog) {
      return
    }
    const service: LogFileService = LogFileService.getInstance()
    if (service.readAll() === '') {
      this.toast($r('app.string.log_export_none'))
      return
    }
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      this.toast($r('app.string.log_export_failed'))
      return
    }
    this.exportingLog = true
    service.exportToUser(context as common.UIAbilityContext, service.defaultExportFileName())
      .then((result: string): void => {
        this.exportingLog = false
        if (result === 'ok') {
          this.toast($r('app.string.log_export_done'))
        } else if (result === 'error') {
          this.toast($r('app.string.log_export_failed'))
        }
      })
  }

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.orig_ic'),
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
            // 原版 y1.k3：皮肤行 → lb.k 皮肤页
            SettingNavRow({
              rowLabel: $r('app.string.orig_uf'),
              onTapRow: () => {
                this.navPathStack.pushPathByName('skinPage', '', true)
              }
            })
            SettingCheckRow({
              rowLabel: $r('app.string.orig_cy'),
              rowDesc: $r('app.string.orig_cz'),
              isChecked: this.settings.isBlurEffect(),
              onCheckRow: (isOn: boolean): void => {
                this.settings.setBlurEffect(isOn)
              }
            })
            SettingCheckRow({
              rowLabel: $r('app.string.orig_tu'),
              isChecked: this.settings.isShowSettingsBackground(),
              onCheckRow: (isOn: boolean): void => {
                this.settings.setShowSettingsBackground(isOn)
                this.getUIContext().getPromptAction()
                  .showToast({ message: $r('app.string.orig_tv'), duration: TOAST_SHORT })
              }
            })
            // 日志开关：WARN/ERROR 级写盘；详细开关开启后 DEBUG/INFO 也写
            SettingCheckRow({
              rowLabel: $r('app.string.log_file_title'),
              rowDesc: $r('app.string.log_file_desc'),
              isChecked: this.settings.logFileEnabled,
              onCheckRow: (isOn: boolean): void => {
                LogFileService.getInstance().setEnabled(isOn)
              }
            })
            SettingCheckRow({
              rowLabel: $r('app.string.log_verbose_title'),
              rowDesc: $r('app.string.log_verbose_desc'),
              isChecked: this.settings.logFileEnabled && this.settings.logFileVerbose,
              disabled: !this.settings.logFileEnabled,
              onCheckRow: (isOn: boolean): void => {
                LogFileService.getInstance().setVerbose(isOn)
              }
            })
            // 导出日志行：与导航行同款卡片
            SettingNavRow({
              rowLabel: $r('app.string.log_export_title'),
              rowDesc: $r('app.string.log_export_desc'),
              onTapRow: (): void => {
                this.exportLog()
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
    .backgroundColor(this.settings.isShowSettingsBackground()
      ? Color.Transparent : $r('app.color.page_bg'))
    .hideTitleBar(true)
    .translate({ x: this.slideOffset })
    // 原版 g6/i.java:67 = setCustomAnimations(anim/f, anim/g, anim/h, anim/i)，
    // 时长 integer/b=220、accelerate_decelerate —— 改用鸿蒙原生 NavDestination 转场接口
    .customTransition((operation: NavigationOperation, isEnter: boolean):
      Array<NavDestinationTransition> | undefined => {
      return buildNavSlide(operation, isEnter, (value: string): void => {
        this.slideOffset = value
      })
    })
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
}

@Builder
export function SettingsExperimentalPageBuilder() {
  SettingsExperimentalPage()
}
