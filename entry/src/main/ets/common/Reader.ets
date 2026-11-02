import { TabItem } from './Types'
import { common } from '@kit.AbilityKit'
import { util } from '@kit.ArkTS'

// 原版 i6/c0 + i6/w：阅读模式注入引擎
// - w.f = rawfile readability.js（Readability 库）
// - w.g = rawfile readerable.js（isProbablyReaderable）
// - w.j = rawfile reader_enter.js（进入阅读模式，生成 .via-reader-body/.via-reader-header 覆盖层）
// - w.b = 退出清理脚本（w.b()）
// - w.i = rawfile reader_check.js（状态 0/1/3/5）
// - w.h = 快速检查（已在阅读模式返回 3，否则 0）
// - w.d = 静态 CSS 注入（__via_reader__）
// - w.c = 主题/字号/自定义 CSS 注入（__via_reader_custom__）
// - w.a = 正文提取（TTS 用）
// 静态 CSS（c0.j 内嵌，即 w.d 的 content）
const READER_STATIC_CSS: string = '@media print{body{overflow:auto!important}body>*{display:none!important}.via-reader-body{display:block!important;position:static!important}}.via-reader-body{position:fixed;left:0;right:0;top:0;bottom:0;overflow:auto;z-index:2147483647!important;color:#000}.via-reader-body *{background-color:transparent!important}.via-reader-header{text-align:start;margin:0 16px 32px}.via-reader-header>h1{font-size:1.4em;font-weight:700;line-height:1.8;width:100%;padding:32px 0 0;margin:0;text-indent:0!important}.via-reader-header>div{opacity:.8;font-size:.8em}.via-reader-header>div>a{color:#0269c8}.via-reader-content{font-size:1em;line-height:1.2;margin:10px 16px 0;overflow-wrap:break-word}.via-reader-content a,.via-reader-content a:active,.via-reader-content a:hover,.via-reader-content a:visited{color:#0269c8}.via-reader-content h1,.via-reader-content h2,.via-reader-content h3,.via-reader-content h4,.via-reader-content h5{margin-top:16px;margin-bottom:16px;font-weight:700;line-height:1.8}.via-reader-content h1{font-size:1.4em}.via-reader-content h2{font-size:1.2em}.via-reader-content h3{font-size:1.1em}.via-reader-content *{max-width:100%;height:auto}.via-reader-content p{font-size:1em;line-height:1.8;padding:0 0 20px}.via-reader-content .wp-caption,.via-reader-content figure{width:100%;margin:0 0 32px}.via-reader-content .wp-caption img,.via-reader-content figure img,.via-reader-content p>a:only-child>img:only-child,.via-reader-content p>img:only-child{margin-left:auto;margin-right:auto}.via-reader-content .caption,.via-reader-content .wp-caption-text,.via-reader-content figcaption{font-size:.9em;margin:0;padding-top:4px}.via-reader-content code,.via-reader-content pre{white-space:pre-wrap;margin-bottom:3px;font-family:monospace!important}.via-reader-content code{padding:2px 4px;font-size:.9em;background-color:#f9f2f4;border-radius:4px}.via-reader-content pre{padding:9px;font-size:.9em;border:1px solid #ccc;border-radius:4px}.via-reader-content blockquote{margin:0 0 20px;padding:0;padding-inline-start:16px;border:0;border-left:2px solid}.via-reader-content ol,.via-reader-content ul{margin:0 0 20px;padding:0;line-height:1.5}.via-reader-content ul{padding-inline-start:30px;list-style:disc!important}.via-reader-content ol{padding-inline-start:35px;list-style:decimal!important}.via-reader-content img.emoji,.via-reader-content img.wp-smiley{border-width:0;width:1em;margin:0 .07em;padding:0}.via-reader-content table{border-collapse:collapse;border:1px solid hsla(0,0%,50.2%,.5)}.via-reader-content td,.via-reader-content th{border:1px solid hsla(0,0%,50.2%,.5);padding:2px}'

// 原版 w.b()：退出阅读模式清理脚本
const READER_EXIT_SCRIPT: string = '(function(){var e=document.getElementsByClassName("via-reader-body");if(0!=e.length&&document.body){for(var t=0,r=e.length;t<r;t++)e[0].remove();var a="via-reader-data",o=document.body;if(o.hasAttribute(a)){o.style.overflow=o.getAttribute(a);o.removeAttribute(a)}var m=document.getElementById("__via_reader_custom__");m&&m.remove();var v=document.getElementById("__via_reader__");v&&v.remove();var i=document.getElementsByName("viewport")[0];if(i&&i.hasAttribute(a)){var d=i.getAttribute(a);if(d){i.setAttribute("content",d);i.removeAttribute(a)}}}})();'

// 原版 w.h()：快速检查（阅读模式中 → 3，否则 0）
const READER_QUICK_CHECK_SCRIPT: string = 'document.getElementsByClassName("via-reader-body").length>0?3:0;'

// 原版 w.a()：正文提取（TTS 用）
const READER_EXTRACT_TEXT_SCRIPT: string = '(function(){if(!document||!document.body)return"";var e=document.getElementsByClassName("via-reader-body");if(e.length>0)return e[0].innerText;var t=document.body.innerText;const n=document.getElementsByTagName("iframe");for(let e=0;e<n.length;e++)try{n[e].contentDocument&&n[e].contentDocument.body&&(t+="\\n"+n[e].contentDocument.body.innerText)}catch(e){}if(t.length<2e3)return t;if("undefined"!=typeof Readability){var o=document.cloneNode(!0),i=new Readability(o,{classesToPreserve:["caption","emoji","hidden","invisible","sr-only","visually-hidden","visuallyhidden","wp-caption","wp-caption-text","wp-smiley"],keepIds:!1}).parse();if(i&&i.textContent&&i.textContent.length>200)return i.textContent}return t})();'

// 原版阅读模式状态（c0.g/w.i 返回值）
export const READER_STATE_NONE: number = 0
export const READER_STATE_READABLE: number = 1
export const READER_STATE_IN_READER: number = 3
export const READER_STATE_AUTO_ENABLED: number = 5

// 原版 g8/j f6283d 主题色：0(默认白)/黄/绿/蓝灰/深灰，ARGB int
export const READER_THEME_COLORS: number[] = [0, -462365, -4133433, -11908531, -15592942]

export class Reader {
  private static readabilityScript: string | null = null
  private static readerableScript: string | null = null
  private static enterScript: string | null = null
  private static checkScript: string | null = null

  // 原版 c0.q：注入 Readability + isProbablyReaderable（可读页面准备）
  static async injectReaderScripts(tab: TabItem): Promise<void> {
    if (tab.isHomePage() || !Reader.isScriptableUrl(tab.url)) {
      return
    }
    const readability = await Reader.loadScript('readability.js', (v: string) => Reader.readabilityScript = v,
      (): string | null => Reader.readabilityScript)
    const readerable = await Reader.loadScript('readerable.js', (v: string) => Reader.readerableScript = v,
      (): string | null => Reader.readerableScript)
    try {
      await tab.controller.runJavaScript(readability)
      await tab.controller.runJavaScript(readerable)
    } catch (error) {
      console.error('inject reader scripts failed')
    }
  }

  // 原版 c0.g：检查阅读状态（0 不可读 / 1 可读 / 3 阅读模式中 / 5 自动开启已确认）
  static async checkState(tab: TabItem): Promise<number> {
    if (tab.isHomePage()) {
      return READER_STATE_NONE
    }
    try {
      const script = await Reader.loadScript('reader_check.js', (v: string) => Reader.checkScript = v,
        (): string | null => Reader.checkScript)
      const result = await tab.controller.runJavaScript(script)
      return Reader.parseState(result)
    } catch (error) {
      return READER_STATE_NONE
    }
  }

  // 原版 c0.j：进入阅读模式（注入静态 CSS + 生成 via-reader-body 覆盖层）
  static async enterReader(tab: TabItem, themeColor: number, fontSize: number, customCss: string): Promise<boolean> {
    if (tab.isHomePage() || !Reader.isScriptableUrl(tab.url)) {
      return false
    }
    const enter = await Reader.loadScript('reader_enter.js', (v: string) => Reader.enterScript = v,
      (): string | null => Reader.enterScript)
    try {
      // w.d：静态 CSS（__via_reader__）
      await tab.controller.runJavaScript(Reader.styleScript('__via_reader__', READER_STATIC_CSS))
      // w.j：进入
      await tab.controller.runJavaScript(enter)
      // c0.f：主题色/字号/自定义 CSS（__via_reader_custom__）
      await tab.controller.runJavaScript(Reader.styleScript('__via_reader_custom__',
        Reader.buildThemeCss(themeColor, Math.min(84, Math.max(8, fontSize)), customCss)))
      return await Reader.isInReader(tab)
    } catch (error) {
      console.error('enter reader failed')
      return false
    }
  }

  // 原版 c0.i：退出阅读模式
  static async exitReader(tab: TabItem): Promise<void> {
    try {
      await tab.controller.runJavaScript(READER_EXIT_SCRIPT)
    } catch (error) {
      console.error('exit reader failed')
    }
  }

  static async isInReader(tab: TabItem): Promise<boolean> {
    try {
      const result = await tab.controller.runJavaScript(READER_QUICK_CHECK_SCRIPT)
      return Reader.parseState(result) === READER_STATE_IN_READER
    } catch (error) {
      return false
    }
  }

  // 原版 c0.l/w.a：提取正文文本（TTS 用）
  static async extractText(tab: TabItem): Promise<string> {
    if (tab.isHomePage()) {
      return ''
    }
    try {
      const result = await tab.controller.runJavaScript(READER_EXTRACT_TEXT_SCRIPT)
      return JSON.parse(result) as string
    } catch (error) {
      console.error('extract page text failed')
      return ''
    }
  }

  // 原版 c0.n：主题 CSS（背景色/文字色/暗色变体/字号/自定义 CSS）
  static buildThemeCss(themeColor: number, fontSize: number, customCss: string): string {
    let color = themeColor
    if (color === 0) {
      // 原版 c0.f：0 → -1（白）
      color = -1
    }
    const textColor = Reader.isLightColor(color) ? -16777216 : -1
    const darkBg = Reader.darkenColor(color, -16777216, 0.3)
    const darkText = Reader.isLightColor(darkBg) ? -16777216 : -1
    const bg = Reader.hex6(color)
    const darkBgHex = Reader.hex6(darkBg)
    const text = Reader.hex6(textColor)
    const darkTextHex = Reader.hex6(darkText)
    let cssCustom = ''
    if (customCss !== '') {
      cssCustom = customCss.replace(/\n/g, '\\n')
    }
    return `.via-reader-body,.via-reader-body>div{background-color: #${bg} !important;}` +
      `.via-reader-body {color: #${text} !important;font-size: ${fontSize}px !important;}` +
      `@media (prefers-color-scheme: dark) {.via-reader-body,.via-reader-body>div{background-color: #${darkBgHex} !important;}` +
      `.via-reader-body {color: #${darkTextHex} !important;}}` + cssCustom
  }

  // 原版 w.c/w.d：创建或更新 <style id> 注入脚本
  static styleScript(elementId: string, content: string): string {
    return `(function(){var e="${content}",t=document.getElementById("${elementId}");` +
      `if(t)t.innerText=e;else{(t=document.createElement("style")).type="text/css";` +
      `t.charset="UTF-8";t.id="${elementId}";t.appendChild(document.createTextNode(e));` +
      `document.head.appendChild(t)}})();`
  }

  // 原版 c0.s：是否可注入阅读脚本
  // 排除：fileType 为 js 的地址、各搜索引擎结果页、tool.lu、.user.js
  static isScriptableUrl(url: string): boolean {
    if (url === '') {
      return true
    }
    const fileType = Reader.fileTypeOf(url)
    if (fileType === 'js') {
      return false
    }
    if (url.includes('.baidu.com/') && url.includes('/s?')) {
      return false
    }
    if (url.includes('.bing.com/') && url.includes('/search?')) {
      return false
    }
    if (url.includes('.sogou.com/') && url.includes('/sl?')) {
      return false
    }
    if (url.includes('.so.com/') && url.includes('/s?')) {
      return false
    }
    if (url.includes('.google.com/') && url.includes('/search?')) {
      return false
    }
    if (url.includes('.metaso.cn/') && url.includes('/search/')) {
      return false
    }
    if (url.includes('://tool.lu/')) {
      return false
    }
    if (url.endsWith('.user.js')) {
      return false
    }
    return true
  }

  // 原版 i0.c：按扩展名判定文件类型
  private static fileTypeOf(url: string): string {
    const queryIndex = url.indexOf('?')
    const hashIndex = url.indexOf('#')
    let end = url.length
    if (queryIndex >= 0) {
      end = queryIndex
    }
    if (hashIndex >= 0 && hashIndex < end) {
      end = hashIndex
    }
    const path = url.substring(0, end)
    const dotIndex = path.lastIndexOf('.')
    const slashIndex = path.lastIndexOf('/')
    if (dotIndex < 0 || dotIndex < slashIndex) {
      return ''
    }
    return path.substring(dotIndex + 1).toLowerCase()
  }

  private static parseState(result: string): number {
    if (result === '') {
      return READER_STATE_NONE
    }
    const value = Number(result)
    return Number.isNaN(value) ? READER_STATE_NONE : value
  }

  // 原版 g.a：颜色亮度判定（亮色 → 深色文字）
  private static isLightColor(argb: number): boolean {
    const r = (argb >> 16) & 0xFF
    const g = (argb >> 8) & 0xFF
    const b = argb & 0xFF
    return (r * 299 + g * 587 + b * 114) / 1000 >= 128
  }

  // 原版 g.b：向 target 混合 ratio 的暗色变体
  private static darkenColor(argb: number, target: number, ratio: number): number {
    const r = Math.round(((argb >> 16) & 0xFF) + (((target >> 16) & 0xFF) - ((argb >> 16) & 0xFF)) * ratio)
    const g = Math.round(((argb >> 8) & 0xFF) + (((target >> 8) & 0xFF) - ((argb >> 8) & 0xFF)) * ratio)
    const b = Math.round((argb & 0xFF) + ((target & 0xFF) - (argb & 0xFF)) * ratio)
    return 0xFF000000 | (r << 16) | (g << 8) | b
  }

  private static hex6(argb: number): string {
    const value = (argb & 0xFFFFFF).toString(16)
    return value.length >= 6 ? value : '0'.repeat(6 - value.length) + value
  }

  private static async loadScript(name: string,
    save: (v: string) => void, cached: () => string | null): Promise<string> {
    const hit = cached()
    if (hit !== null) {
      return hit
    }
    const content = await Reader.readRawFile(name)
    save(content)
    return content
  }

  private static rawFileCache: Map<string, string> = new Map()

  private static async readRawFile(name: string): Promise<string> {
    const hit = Reader.rawFileCache.get(name)
    if (hit !== undefined) {
      return hit
    }
    const context = AppContextHolder.getContext()
    if (context === null) {
      return ''
    }
    const data: Uint8Array = await context.resourceManager.getRawFileContent(name)
    const decoder = util.TextDecoder.create('utf-8')
    const text = decoder.decodeToString(data)
    Reader.rawFileCache.set(name, text)
    return text
  }
}

// 应用上下文持有（rawfile 读取需要）
export class AppContextHolder {
  private static context: common.Context | null = null

  static setContext(context: common.Context): void {
    AppContextHolder.context = context
  }

  static getContext(): common.Context | null {
    return AppContextHolder.context
  }
}

export function initReaderContext(context: common.Context): void {
  AppContextHolder.setContext(context)
}
