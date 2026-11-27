import { common } from '@kit.AbilityKit'
import { fileIo } from '@kit.CoreFileKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { TabItem } from './Types'
import { TabStore } from './TabStore'

// 原版 na.i2()（c8/na.java:1843-1860）：
//   URL 为空 → toast「仅支持 "http" 或 "https" 开头的网址」（M1）；
//   SDK < 21 → 取 document.documentElement.outerHTML，以纯文本写进新窗口 body.innerText，
//              页面骨架/meta/标题/正文样式（padding 5px 10px、word-break、#666、line-height 1.4）；
//   SDK >= 21 → 新标签加载 "view-source:" + 原 URL。
//
// ArkWeb 未实现 view-source 协议渲染，故以 outerHTML 快照落盘并在新标签中显示。
// 序列化 DOM 通常是一行；按标签边界格式化后仍作为纯文本展示，不执行页面源码。
const SOURCE_PAGE_HEAD: string =
  '<html><head><meta charset="utf-8">' +
  '<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no, minimal-ui">' +
  '<title>Source</title>' +
  '<style type="text/css">* {padding: 0; margin: 0}' +
  ' body{padding: 5px 10px;word-break:break-all;color: #666;line-height: 1.4;}</style>' +
  '</head><body></body></html>'

function formatSource(source: string): string {
  return source.replace(/>\\s*</g, '>\\n<')
}

// HTML 转义：原版走 body.innerText 赋值（浏览器自动转义），本端直接拼 HTML 需自行转义
function escapeHtml(text: string): string {
  return text.replace(/&/g, '&amp;')
    .replace(/</g, '&lt;')
    .replace(/>/g, '&gt;')
    .replace(/"/g, '&quot;')
}

export class ViewSource {
  // 返回 true = 已新开标签；false = URL 为空（调用方负责 toast M1）
  static open(context: common.UIAbilityContext, tab: TabItem, tabStore: TabStore): boolean {
    const url: string = tab.url
    if (url === '' || url === 'about:blank') {
      return false
    }
    try {
      tab.controller.runJavaScript('document.documentElement.outerHTML',
        (error: BusinessError, result: string) => {
          if (error) {
            console.error(`get source failed: ${error.code}`)
            return
          }
          const source: string = typeof result === 'string' ? result : ''
          if (source === '') {
            return
          }
          const path: string = `${context.cacheDir}/via_source_${tab.id}.html`
          try {
            const file = fileIo.openSync(path,
              fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE | fileIo.OpenMode.TRUNC)
            fileIo.writeSync(file.fd, `${SOURCE_PAGE_HEAD}<body><pre>${escapeHtml(formatSource(source))}</pre></body></html>`)
            fileIo.closeSync(file)
            // 原版 g1(url, true, L0() + 1)：新标签插在当前标签之后并选中
            tabStore.newTabAtAfterCurrent(`file://${path}`)
          } catch (ioError) {
            console.error('write view source failed')
          }
        })
    } catch (error) {
      console.error('runJavaScript view source failed')
      return false
    }
    return true
  }
}
