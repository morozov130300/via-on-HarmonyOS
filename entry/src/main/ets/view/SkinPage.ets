import { common } from '@kit.AbilityKit'
import { picker } from '@kit.CoreFileKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { AppSettings } from '../common/Settings'
import { SkinEntry, SkinStore } from '../common/SkinStore'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'
import { SettingRadioRow } from '../components/SettingRows'

// 原版 lb/k.java：「皮肤」页
// 列表 = 首项默认（u.fd「默认」）+ mb.b 皮肤库（skins 目录，按修改时间降序）；
// 单击 i3 → t3：写 skin 键 + 弹「皮肤已变更」确认框（u.uc/u.mb/u.I2 重启应用/R.string.cancel）→ 确认 z8.f.k 冷重启；
// 长按非默认 k3 → 删除确认框（u.x「删除」/u.g3「你确定删除 %1$s 吗？」）→ g3：删目录，删中当前则 t3("")；
// appbar 右侧 + 按钮（drawable ay / via_ic_add）→ 文件选择器（application/zip），失败 toast u.E7「加载皮肤失败」
@ComponentV2
export struct SkinPage {
  private settings: AppSettings = AppSettings.getInstance()
  private store: SkinStore = SkinStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local entries: SkinEntry[] = []
  @Local current: string = ''

  private getContextCtx(): common.Context {
    return getContext(this) as common.Context
  }

  private reload(): void {
    this.entries = this.store.list(this.getContextCtx())
    this.current = this.settings.skin
  }

  private bindAppBar(): void {
    AppBar.show({
      title: '皮肤',
      rightIcon: $r('app.media.via_ic_add'),
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight: () => {
        this.pickSkin()
      }
    }, this)
  }

  // 原版 k.r3：文件选择器（application/zip）
  private pickSkin(): void {
    try {
      const docPicker = new picker.DocumentViewPicker(this.getContextCtx())
      const options = new picker.DocumentSelectOptions()
      options.maxSelectNumber = 1
      options.fileSuffixFilters = ['.zip']
      docPicker.select(options).then((uris: Array<string>) => {
        if (uris.length > 0) {
          this.importSkin(uris[0])
        }
      }).catch((error: BusinessError) => {
        console.error(`pick skin failed: ${error.message}`)
      })
    } catch (error) {
      console.error('pick skin failed')
    }
  }

  // 原版 k.p3 → h3 → n3：导入，失败 toast u.E7（g6.n.s）
  private importSkin(uri: string): void {
    this.store.importFromUri(this.getContextCtx(), uri).then((name: string | null) => {
      if (name === null) {
        this.toast('加载皮肤失败')
        return
      }
      this.reload()
    })
  }

  // 原版 k.t3：选中皮肤（写 skin 键）+ 弹确认框，确认冷重启
  private selectSkin(entry: SkinEntry): void {
    if (entry.name === this.current) {
      return
    }
    this.settings.setSkin(entry.name)
    this.current = entry.name
    this.showApplyDialog()
  }

  private showApplyDialog(): void {
    AlertDialog.show({
      title: '皮肤已变更',
      message: '这将在下次启动应用时生效，你希望立即重启应用以生效吗？',
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: '重启应用',
        action: () => {
          const context = this.getUIContext().getHostContext() as common.UIAbilityContext
          this.store.restartApp(context)
        }
      }
    })
  }

  // 原版 k.k3：长按删除确认（默认项不响应）
  private confirmDelete(entry: SkinEntry): void {
    if (entry.name === '') {
      return
    }
    AlertDialog.show({
      title: '删除',
      message: `你确定删除 ${entry.name} 吗？`,
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: $r('app.string.confirm'),
        action: () => {
          this.deleteSkin(entry)
        }
      }
    })
  }

  // 原版 k.g3：删除目录；若删中当前皮肤则 t3("")（重置默认并再次弹「皮肤已变更」）
  private deleteSkin(entry: SkinEntry): void {
    if (!this.store.remove(this.getContextCtx(), entry.name)) {
      return
    }
    if (this.current === entry.name) {
      this.settings.setSkin('')
      this.current = ''
      this.showApplyDialog()
    }
    this.reload()
  }

  aboutToAppear(): void {
    this.reload()
  }

  private toast(message: string): void {
    this.getUIContext().getPromptAction().showToast({ message: message, duration: 1500 })
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        List() {
          // 原版 s3：首项固定默认（mb.c("", u.fd「默认」, 0)）
          ListItem() {
            SettingRadioRow({
              rowLabel: '默认',
              isSelected: this.current === '',
              onTapRow: () => {
                this.selectSkin(new SkinEntry('', 0))
              }
            })
          }
          ForEach(this.entries, (entry: SkinEntry) => {
            ListItem() {
              SettingRadioRow({
                rowLabel: entry.name,
                isSelected: this.current === entry.name,
                onTapRow: () => {
                  this.selectSkin(entry)
                },
                onLongPressRow: () => {
                  this.confirmDelete(entry)
                }
              })
            }
          }, (entry: SkinEntry) => `${entry.name}_${entry.mtime}_${this.current}`)
        }
        .width('100%')
        .layoutWeight(1)
        .divider({ strokeWidth: 0.5, color: $r('app.color.appbar_divider'), startMargin: 16, endMargin: 16 })
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
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
export function SkinPageBuilder() {
  SkinPage()
}
