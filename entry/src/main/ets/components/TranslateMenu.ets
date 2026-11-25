import { TabStore } from '../common/TabStore'
import { TranslateState } from './TranslatePanel'
import { dialogTransition, dimTransition } from '../common/Transitions'
import {
  buildBaiduPageTranslateUrl,
  buildEdgePageTranslateJs,
  buildGooglePageTranslateJs,
  buildGooglePageTranslateUrl
} from '../common/TranslateInject'

// 原版 k6.Db(boolean)（c8/k6.java:4070-4096）：翻译菜单弹窗。
//   · URL 非 http(s) → toast x7.u.M1「仅支持 http/https 开头的网址」，不弹窗
//   · z11 = z8.c0.f() || z8.f.h() 恒真（该判据在 7.4.0 里是编译期常量 true）
//   · 微软翻译（z10）、百度翻译、谷歌页内翻译（z10）、谷歌翻译、谷歌文本翻译
//   · z10 = 长按入口（true）/ CSP 回落（false）——回落时只留 3 项
// 原版 na.Z1()（c8/na.java:47524）：「页内翻译」按当前搜索引擎分流——
//   search2（引擎 id）!= -1（非谷歌）→ b2() 微软；== -1（谷歌）→ a2() 谷歌。
@ObservedV2
export class TranslateMenuState {
  private static instance: TranslateMenuState | null = null

  static getInstance(): TranslateMenuState {
    if (TranslateMenuState.instance === null) {
      TranslateMenuState.instance = new TranslateMenuState()
    }
    return TranslateMenuState.instance
  }

  @Trace visible: boolean = false
  // 原版 Db(z10)：长按=true（5 项）/ CSP 回落=false（3 项）
  @Trace full: boolean = false

  open(full: boolean): void {
    this.full = full
    this.visible = true
  }

  close(): void {
    this.visible = false
  }
}

@ComponentV2
export struct TranslateMenuDialog {
  private state: TranslateMenuState = TranslateMenuState.getInstance()
  private tabStore: TabStore = TabStore.getInstance()

  // 原版 k6.Db 首段：非 http(s) 页 toast dc，返回 false
  private httpGuard(): boolean {
    const tab = this.tabStore.current()
    if (!tab.url.startsWith('http://') && !tab.url.startsWith('https://')) {
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.mark_ad_http_only'),
        duration: 1500
      })
      return false
    }
    return true
  }

  private toastWait(): void {
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.translate_wait'), duration: 1500 })
  }

  // 原版 na.a2()：谷歌页内翻译（element.js + showBanner）
  private googleInPage(): void {
    if (!this.httpGuard()) {
      return
    }
    try {
      this.tabStore.current().controller.runJavaScript(buildGooglePageTranslateJs())
      this.toastWait()
    } catch (error) {
      console.error('inject google translate failed')
    }
    this.state.close()
  }

  // 原版 na.b2()：微软页内翻译（translate.js client.edge）
  private edgeInPage(): void {
    if (!this.httpGuard()) {
      return
    }
    try {
      this.tabStore.current().controller.runJavaScript(buildEdgePageTranslateJs())
      this.toastWait()
    } catch (error) {
      console.error('inject edge translate failed')
    }
    this.state.close()
  }

  // 原版 y3 case1 → i1(f0.a)：百度翻译网页（新标签，to 用短语言码）
  private baiduPage(): void {
    if (!this.httpGuard()) {
      return
    }
    this.tabStore.newTabAt(buildBaiduPageTranslateUrl(this.tabStore.current().url), false)
    this.state.close()
  }

  // 原版 y3 case3 → i1(f0.c)：谷歌翻译网页（新标签，tl 用完整语言码）
  private googlePage(): void {
    if (!this.httpGuard()) {
      return
    }
    this.tabStore.newTabAt(buildGooglePageTranslateUrl(this.tabStore.current().url), false)
    this.state.close()
  }

  // 原版 y3 case5 → Eb(null)：f8.w0 文本翻译面板
  private textPanel(): void {
    this.state.close()
    TranslateState.getInstance().open('')
  }

  build() {
    Stack({ alignContent: Alignment.Center }) {
      if (this.state.visible) {
        Column()
          .width('100%')
          .height('100%')
          .backgroundColor('rgba(0,0,0,0.2)')
          .transition(dimTransition(240))
          .onClick(() => {
            this.state.close()
          })
        Column() {
          Text($r('app.string.translate'))
            .fontSize(17)
            .fontWeight(FontWeight.Medium)
            .fontColor($r('app.color.fg'))
            .width('100%')
            .padding({ left: 20, top: 18, bottom: 8 })
          Column() {
            // 原版数组顺序：微软、百度、谷歌页内、谷歌、谷歌文本
            if (this.state.full) {
              this.MenuRow($r('app.string.orig_a01'), (): void => {
                this.edgeInPage()
              })
            }
            this.MenuRow($r('app.string.orig_zx'), (): void => {
              this.baiduPage()
            })
            if (this.state.full) {
              this.MenuRow($r('app.string.orig_zz'), (): void => {
                this.googleInPage()
              })
            }
            this.MenuRow($r('app.string.orig_zy'), (): void => {
              this.googlePage()
            })
            this.MenuRow($r('app.string.orig_a00'), (): void => {
              this.textPanel()
            })
          }
          .width('100%')
          .padding({ bottom: 12 })
        }
        .width('100%')
        .constraintSize({ maxHeight: '70%' })
        .borderRadius(20)
        .backgroundColor($r('app.color.menu_bg'))
        .shadow({ radius: 24, color: 'rgba(0,0,0,0.5)', offsetY: 4 })
        .transition(dialogTransition())
      }
    }
    .width('100%')
    .height('100%')
    // 弹层自身不拦截空白区之外的点击（外圈 dim 层已处理关闭）
    .hitTestBehavior(HitTestMode.Transparent)
  }

  @Builder
  MenuRow(label: Resource, action: () => void) {
    Text(label)
      .fontSize(15)
      .fontColor($r('app.color.fg'))
      .width('100%')
      .height(44)
      .padding({ left: 20, right: 20 })
      .onClick(() => {
        action()
      })
  }
}

// 供非组件上下文（TabWeb 的 JS 桥回调 / Index 的长按动作）打开菜单：
// full=true 为长按入口（5 项），false 为 CSP 回落入口（3 项）
export function openTranslateMenu(full: boolean): void {
  TranslateMenuState.getInstance().open(full)
}
