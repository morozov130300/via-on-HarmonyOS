import { TabItem } from './Types'

const EXTRACT_SCRIPT: string = "(function(){var sels=['article','main','#content','.content','.article']," +
  "i,e;for(i=0;i<sels.length;i++){e=document.querySelector(sels[i]);" +
  "if(e&&e.innerText&&e.innerText.length>200){return e.innerText}}" +
  "return document.body?document.body.innerText:''})()"

export class Reader {
  static async extractText(tab: TabItem): Promise<string> {
    if (tab.isHomePage()) {
      return ''
    }
    try {
      const result = await tab.controller.runJavaScript(EXTRACT_SCRIPT)
      const text = JSON.parse(result) as string
      return text
    } catch (error) {
      console.error('extract page text failed')
      return ''
    }
  }
}
