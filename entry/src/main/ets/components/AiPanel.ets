import { http } from '@kit.NetworkKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { AppSettings } from '../common/Settings'
import { ViaIcon } from './ViaIcon'

const AI_BASE_URLS: Record<string, string> = {
  'deepseek': 'https://api.deepseek.com',
  'openai': 'https://api.openai.com',
  'siliconflow': 'https://api.siliconflow.cn'
}

class AiMessage {
  role: string
  content: string

  constructor(role: string, content: string) {
    this.role = role
    this.content = content
  }
}

@ComponentV2
export struct AiPanel {
  @Event onClose: () => void = () => {}
  private settings: AppSettings = AppSettings.getInstance()
  @Local messages: AiMessage[] = []
  @Local input: string = ''
  @Local busy: boolean = false
  private scroller: Scroller = new Scroller()

  build() {
    Column() {
      Row() {
        Text('AI')
          .fontSize(17)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
        Blank()
        ViaIcon({ icon: $r('app.media.via_ic_cancel'), iconSize: 22, iconColor: $r('app.color.menu_icon') })
          .onClick(() => {
            this.onClose()
          })
      }
      .width('100%')
      .height(46)
      .padding({ left: 16, right: 16 })
      .alignItems(VerticalAlign.Center)

      Divider()
        .color($r('app.color.search_pill_border'))
        .strokeWidth(0.5)

      List({ scroller: this.scroller }) {
        if (this.messages.length === 0) {
          ListItem() {
            Column() {
              Text('向 AI 提问，回答基于您配置的服务商 API')
                .fontSize(13)
                .fontColor($r('app.color.fg_secondary'))
                .textAlign(TextAlign.Center)
            }
            .width('100%')
            .padding({ top: 80 })
          }
        }
        ForEach(this.messages, (message: AiMessage, index: number) => {
          ListItem() {
            Column({ space: 4 }) {
              Text(message.role === 'user' ? '我' : 'AI')
                .fontSize(12)
                .fontColor($r('app.color.fg_secondary'))
              Text(message.content)
                .fontSize(14)
                .fontColor($r('app.color.fg'))
                .width('100%')
                .padding(10)
                .borderRadius(10)
                .backgroundColor(message.role === 'user' ? $r('app.color.surface') : $r('app.color.page_bg'))
            }
            .width('100%')
            .alignItems(message.role === 'user' ? HorizontalAlign.End : HorizontalAlign.Start)
            .margin({ top: 8, bottom: 8 })
          }
        }, (message: AiMessage, index: number) => `${index}_${message.role}`)
      }
      .layoutWeight(1)
      .width('100%')
      .padding({ left: 12, right: 12 })

      if (this.busy) {
        LoadingProgress()
          .width(22)
          .height(22)
          .margin({ bottom: 6 })
      }

      Row({ space: 8 }) {
        TextInput({ placeholder: '输入问题', text: this.input })
          .layoutWeight(1)
          .height(40)
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.fg_secondary'))
          .backgroundColor($r('app.color.surface'))
          .borderRadius(20)
          .onChange((value: string) => {
            this.input = value
          })
        Button('发送')
          .fontSize(14)
          .height(40)
          .padding({ left: 16, right: 16 })
          .backgroundColor($r('app.color.accent'))
          .onClick(() => {
            this.send()
          })
      }
      .width('100%')
      .padding({ left: 12, right: 12, top: 6, bottom: 10 })
    }
    .width('100%')
    .height('100%')
    .backgroundColor($r('app.color.menu_bg'))
  }

  private send(): void {
    const text = this.input.trim()
    if (text === '' || this.busy) {
      return
    }
    if (this.settings.aiApiKey === '') {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.ai_need_key'), duration: 2000 })
      return
    }
    this.messages.push(new AiMessage('user', text))
    this.input = ''
    this.busy = true
    const next: AiMessage[] = []
    for (let i = 0; i < this.messages.length; i++) {
      next.push(this.messages[i])
    }
    this.messages = next
    this.requestCompletion(text)
  }

  private requestCompletion(question: string): void {
    const baseUrl = AI_BASE_URLS[this.settings.aiProvider]
    if (baseUrl === undefined) {
      this.busy = false
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.ai_need_key'), duration: 2000 })
      return
    }
    const url = `${baseUrl}/v1/chat/completions`
    const payloadMessages: Record<string, Object>[] = []
    for (let i = 0; i < this.messages.length; i++) {
      const message = this.messages[i]
      const entry: Record<string, Object> = {}
      entry['role'] = message.role
      entry['content'] = message.content
      payloadMessages.push(entry)
    }
    const payload: Record<string, Object> = {}
    payload['model'] = this.settings.aiModel
    payload['messages'] = payloadMessages
    const request = http.createHttp()
    request.request(url, {
      method: http.RequestMethod.POST,
      header: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.settings.aiApiKey}`
      },
      extraData: JSON.stringify(payload),
      connectTimeout: 15000,
      readTimeout: 60000,
      usingCache: false
    }).then((response: http.HttpResponse) => {
      const body = response.result
      if (typeof body !== 'string') {
        throw new Error('empty response')
      }
      const parsed = JSON.parse(body) as Record<string, Object>
      const choices = parsed['choices']
      if (!Array.isArray(choices) || choices.length === 0) {
        throw new Error('no choices')
      }
      const first = choices[0] as Record<string, Object>
      const message = first['message'] as Record<string, Object>
      const content = message['content']
      if (typeof content !== 'string' || content === '') {
        throw new Error('empty content')
      }
      this.appendAssistant(content)
    }).catch((error: BusinessError) => {
      console.error(`ai request failed: ${error.message}`)
      this.appendAssistant('请求失败，请检查网络或 API 配置')
    }).finally(() => {
      request.destroy()
    })
  }

  private appendAssistant(content: string): void {
    const next: AiMessage[] = []
    for (let i = 0; i < this.messages.length; i++) {
      next.push(this.messages[i])
    }
    next.push(new AiMessage('assistant', content))
    this.messages = next
    this.busy = false
  }
}
