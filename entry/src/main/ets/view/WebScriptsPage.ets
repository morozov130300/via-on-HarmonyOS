import { UserScriptRec } from '../common/Types'
import { AppSettings } from '../common/Settings'
import { TabStore } from '../common/TabStore'
import { hostOf } from '../common/SearchEngines'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { ScriptEditOverlay } from './UserScriptsPage'
import { buildNavSlide } from './PageTransitions'
import { scriptMatchesUrl } from '../common/ScriptMatch'
import { gmSecret, gmMenusJs, gmMenuInvokeJs } from '../common/GmRuntime'

// 原版 ua/y.java「网页脚本」页（k6.yb(url) 进入）：标题 z4「作用于 %s 的脚本」/uc「脚本」；
// 列表 = c0.C(url)（p5.G）匹配当前网址的脚本 + 启用开关（ua.t，c0.B → p5.l）；
// 行点击 → ua.i 该脚本的 GM 菜单命令（sa.i1.b → k6.j5 window[uuid]['gm_menus'][id][cmd]()）；
// 右上 + → sa.o 为该网址新建脚本编辑器
@ComponentV2
export struct WebScriptsPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local adding: boolean = false
  @Local refreshTick: number = 0

  private pageUrl(): string {
    return TabStore.getInstance().current().url
  }

  // ua.t:202-203：标题 = i0.f(url) 非空 ? z4「作用于 %1$s 的脚本」 : uc「脚本」
  // 走资源 + getStringSync 保证英文切换生效（原版 R.string 占位符语义）
  private pageTitle(): string {
    const host = hostOf(this.pageUrl())
    try {
      const ctx = this.getUIContext().getHostContext()
      if (ctx !== undefined) {
        if (host === '') {
          return ctx.resourceManager.getStringSync($r('app.string.scripts').id)
        }
        const tpl = ctx.resourceManager.getStringSync($r('app.string.scripts_for_host').id)
        return tpl.replace('%1$s', host).replace('%s', host)
      }
    } catch (error) {
      // 资源不可用时回退：优先用已有 scripts 键，仍失败则返回 host 本身，避免中文硬编码
    }
    return host !== '' ? host : ''
  }

  // ua.y c0.C(url)（p5.G）：匹配当前网址的脚本列表（id>=0，不筛启用位）
  private matchedScripts(): UserScriptRec[] {
    const url = this.pageUrl()
    const matched: UserScriptRec[] = []
    const scripts = this.settings.userScripts
    for (let i = 0; i < scripts.length; i++) {
      const script = scripts[i]
      if (script.id >= 0 && scriptMatchesUrl(script, url)) {
        matched.push(script)
      }
    }
    return matched
  }

  private bindAppBar(): void {
    AppBar.show({
      title: this.pageTitle(),
      rightIcon2: $r('sys.symbol.plus'),
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight2: () => {
        this.adding = true
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            ForEach(this.matchedScripts(), (script: UserScriptRec) => {
              Row() {
                Text(script.name)
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
                  .layoutWeight(1)
                  .onClick(() => {
                    this.showGmCommands(script)
                  })
                Toggle({ type: ToggleType.Switch, isOn: script.enabled })
                  .onChange((value: boolean) => {
                    script.enabled = value
                    this.settings.saveScript(script)
                    this.refreshTick++
                  })
              }
              .width('100%')
              .height(48)
              .padding({ left: 16, right: 16 })
            }, (script: UserScriptRec) => `${script.id}_${script.enabled}_${script.name}_${this.refreshTick}`)
          }
          .width('100%')
        }
        .layoutWeight(1)
        .align(Alignment.Top)
        .width('100%')
      }
      .width('100%')
      .height('100%')
      if (this.adding) {
        ScriptEditOverlay({
          script: null,
          initUrl: this.pageUrl(),
          onClose: () => {
            this.adding = false
          },
          onSaved: () => {
            this.adding = false
            this.refreshTick++
          }
        })
      }
    }
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

  // ua.i：该脚本 GM_registerMenuCommand 注册的命令列表（sa.i1.b），点击执行（k6.j5）
  private showGmCommands(script: UserScriptRec): void {
    const scriptId = String(script.id)
    const controller = TabStore.getInstance().current().controller
    controller.runJavaScript(gmMenusJs(gmSecret())).then((raw: string) => {
      const commands = this.parseGmMenusResult(raw, scriptId)
      if (commands.length === 0) {
        return
      }
      const sheets: SheetInfo[] = []
      for (let i = 0; i < commands.length; i++) {
        const command = commands[i]
        sheets.push({
          title: command,
          action: (): void => {
            TabStore.getInstance().current().controller
              .runJavaScript(gmMenuInvokeJs(gmSecret(), scriptId, command)).catch(() => {
              })
          }
        })
      }
      ActionSheet.show({
        title: script.name,
        message: '',
        sheets: sheets
      })
    }).catch(() => {
    })
  }

  // runJavaScript 结果可能是 JSON 编码字符串（带引号），两层容错解析后取命令名列表
  private parseGmMenusResult(raw: string, scriptId: string): string[] {
    let json: string = raw
    try {
      const first = JSON.parse(raw) as Object
      if (typeof first === 'string') {
        json = first
      }
    } catch (error) {
    }
    try {
      const menus = JSON.parse(json) as Record<string, Object>
      const list = menus[scriptId]
      if (list instanceof Array) {
        const names: string[] = []
        for (let i = 0; i < list.length; i++) {
          if (typeof list[i] === 'string') {
            names.push(list[i] as string)
          }
        }
        return names
      }
    } catch (error) {
    }
    return []
  }
}

@Builder
export function WebScriptsPageBuilder() {
  WebScriptsPage()
}
