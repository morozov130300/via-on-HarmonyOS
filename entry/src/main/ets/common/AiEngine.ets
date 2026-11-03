// AiEngine.ets —— 原版 p9/m.java（聊天引擎）1:1 移植
//
// 对应原版：
// - p9/m.g()：URL 拼接（不以 /chat/completions 结尾则追加，末尾 / 处理 1:1）
// - p9/m.i()：Invalid backend 判定（URL 空/空白、token 空或含控制字符/非 ASCII）
// - p9/m.e()/d()：非流式请求（POST → 200 解析 ChatResponse）
// - p9/m.f()/j()：流式 SSE 请求（launchdarkly eventsource → 鸿蒙 http.requestInStream）
// - p9/m.a（内部类）：SSE 解析（[DONE] 结束、delta.content/reasoning_content 累积、50ms 节流）
// - p9/m.c()：stop（连接中断开）
// - p9/f.java：请求体 {model, stream, temperature:0.5, messages:[{content, role}]}
// - p9/e.k()：消息序列化（content + role）
// - p9/g.java：结果状态（status 1=完成、0=中间、100=错误；v.A/D 门面另加 101/102/104）
//
// 鸿蒙映射：okhttp+launchdarkly → @ohos.net.http requestInStream（connect 30s / read 60s）。

import { http } from '@kit.NetworkKit'
import { util } from '@kit.ArkTS'
import { BusinessError } from '@kit.BasicServicesKit'
import { AiBackend } from './CopilotStore'

// 请求消息（p9/e 序列化形态：content + role）
export class ChatMsgIn {
  role: string = 'user'
  content: string = ''

  constructor(role: string, content: string) {
    this.role = role
    this.content = content
  }
}

// 流式结果（p9/g）
export class AiChatResult {
  // 1=完成（[DONE] / 非流式成功）、0=中间态、100=错误
  status: number = 0
  content: string = ''
  reasoning: string = ''
  role: string = ''
  finishReason: string | null = null
  // HTTP 状态码（hw 文案用），0 表示非 HTTP 错误
  httpCode: number = 0
  // HTTP 响应体（hw 文案用）
  httpBody: string = ''
  // 原始错误信息（hz 文案用）
  error: string = ''

  static done(content: string, reasoning: string, role: string, finishReason: string | null): AiChatResult {
    const r = new AiChatResult()
    r.status = 1
    r.content = content
    r.reasoning = reasoning
    r.role = role
    r.finishReason = finishReason
    return r
  }

  static partial(content: string, reasoning: string, role: string): AiChatResult {
    const r = new AiChatResult()
    r.status = 0
    r.content = content
    r.reasoning = reasoning
    r.role = role
    return r
  }

  static failed(error: string, httpCode: number = 0, httpBody: string = ''): AiChatResult {
    const r = new AiChatResult()
    r.status = 100
    r.error = error
    r.httpCode = httpCode
    r.httpBody = httpBody
    return r
  }
}

// p9/m.i()：服务商配置无效判定
export function invalidBackend(backend: AiBackend | null): boolean {
  if (backend === null) {
    return true
  }
  const url = backend.url
  if (url === '' || url.trim() === '') {
    return true
  }
  const token = backend.token
  if (token === null || token === '') {
    return true
  }
  for (let i = 0; i < token.length; i++) {
    const ch = token.charAt(i)
    const code = ch.charCodeAt(0)
    if ((code <= 31 && code !== 9) || code >= 0x7f) {
      return true
    }
  }
  return false
}

// p9/m.g() URL 拼接
export function chatUrl(backend: AiBackend): string {
  let u = backend.url
  if (!u.endsWith('/chat/completions')) {
    if (u.charAt(u.length - 1) === '/') {
      u = u + 'chat/completions'
    } else {
      u = u + '/chat/completions'
    }
  }
  return u
}

// p9/f + p9/e.k()：请求体（temperature 硬编码 0.5）
export function buildChatBody(model: string, messages: ChatMsgIn[], stream: boolean): string {
  const parts: string[] = []
  for (let i = 0; i < messages.length; i++) {
    // e.k()：{"content":..., "role:...}（content/role 依 k() 键序）
    parts.push(`{"content":${JSON.stringify(messages[i].content)},"role":${JSON.stringify(messages[i].role)}}`)
  }
  return `{"model":${JSON.stringify(model)},"stream":${stream},` +
    `"temperature":0.5,"messages":[${parts.join(',')}]}`
}

// SSE 行解析后的一个 chunk（d/b/e）
class DeltaChunk {
  role: string | null = null
  content: string | null = null
  reasoning: string | null = null
  finishReason: string | null = null
}

// p9/d.a + p9/b + p9/e.a：解析一行 data JSON
function parseDeltaChunk(raw: string): DeltaChunk | null {
  let obj: Record<string, Object> | null = null
  try {
    obj = JSON.parse(raw) as Record<string, Object>
  } catch (error) {
    return null
  }
  if (obj === null) {
    return null
  }
  const out = new DeltaChunk()
  const choices = obj['choices'] as Object[]
  if (choices !== null && choices !== undefined && choices.length > 0) {
    const choice = choices[0] as Record<string, Object>
    const finish = choice['finish_reason']
    if (typeof finish === 'string') {
      out.finishReason = finish
    }
    const delta = choice['delta'] as Record<string, Object>
    if (delta !== null && delta !== undefined) {
      const role = delta['role']
      if (typeof role === 'string') {
        out.role = role
      }
      const content = delta['content']
      if (typeof content === 'string') {
        out.content = content
      }
      const reasoning = delta['reasoning_content']
      if (typeof reasoning === 'string') {
        out.reasoning = reasoning
      }
    }
  }
  return out
}

// 非流式响应解析（p9/c.a + p9/a）
function parseFullResponse(raw: string): AiChatResult {
  let obj: Record<string, Object> | null = null
  try {
    obj = JSON.parse(raw) as Record<string, Object>
  } catch (error) {
    return AiChatResult.failed('Bad response')
  }
  if (obj === null) {
    return AiChatResult.failed('Bad response')
  }
  const choices = obj['choices'] as Object[]
  if (choices === null || choices === undefined || choices.length === 0) {
    return AiChatResult.failed('Empty choices')
  }
  const choice = choices[0] as Record<string, Object>
  const message = choice['message'] as Record<string, Object>
  if (message === null || message === undefined) {
    return AiChatResult.failed('Empty message')
  }
  let content = ''
  let reasoning = ''
  let role = ''
  const c = message['content']
  if (typeof c === 'string') {
    content = c
  }
  const r = message['reasoning_content']
  if (typeof r === 'string') {
    reasoning = r
  }
  const ro = message['role']
  if (typeof ro === 'string') {
    role = ro
  }
  let finish: string | null = null
  const f = choice['finish_reason']
  if (typeof f === 'string') {
    finish = f
  }
  return AiChatResult.done(content, reasoning, role, finish)
}

// ----- 引擎（p9/m）-----

export class AiEngine {
  private session: http.HttpRequest | null = null
  private streaming: boolean = false

  // p9/m.c()：停止；返回停止时是否正在连接/流式传输中
  stop(): boolean {
    const was = this.streaming
    this.streaming = false
    if (this.session !== null) {
      this.session.destroy()
      this.session = null
    }
    return was
  }

  // p9/m.e()：非流式完成（标题摘要等用）
  async complete(backend: AiBackend, model: string, messages: ChatMsgIn[]): Promise<AiChatResult> {
    if (invalidBackend(backend)) {
      return AiChatResult.failed('Invalid backend')
    }
    const session = http.createHttp()
    this.session = session
    try {
      const response = await session.request(chatUrl(backend), {
        method: http.RequestMethod.POST,
        header: {
          'Authorization': `Bearer ${backend.token}`,
          'Content-Type': 'application/json; charset=utf-8'
        },
        extraData: buildChatBody(model, messages, false),
        expectDataType: http.HttpDataType.STRING,
        connectTimeout: 30000,
        readTimeout: 60000
      })
      if (response.responseCode === 200 && response.result !== null && response.result !== undefined) {
        return parseFullResponse(`${response.result}`)
      }
      const body = response.result === null || response.result === undefined ? '' : `${response.result}`
      return AiChatResult.failed(`HTTP ${response.responseCode}`, response.responseCode, body)
    } catch (error) {
      const err = error as BusinessError
      return AiChatResult.failed(err.message ?? 'Request failed')
    } finally {
      session.destroy()
      if (this.session === session) {
        this.session = null
        this.streaming = false
      }
    }
  }

  // p9/m.f()/j()：流式 SSE
  async stream(backend: AiBackend, model: string, messages: ChatMsgIn[],
    onResult: (result: AiChatResult) => void): Promise<void> {
    if (invalidBackend(backend)) {
      // v.A/j 路径：104 = Invalid backend → hv 文案
      onResult(AiChatResult.failed('Invalid backend'))
      return
    }
    const session = http.createHttp()
    this.session = session
    this.streaming = true

    let content = ''
    let reasoning = ''
    let role = ''
    let finishReason: string | null = null
    let finished = false
    let lastEmit = 0
    let buffer = ''
    let httpCode = 0
    let httpBody = ''
    const decoder = util.TextDecoder.create('utf-8')

    const finishWith = (result: AiChatResult): void => {
      if (finished) {
        return
      }
      finished = true
      this.streaming = false
      if (this.session === session) {
        this.session = null
      }
      session.destroy()
      onResult(result)
    }

    session.on('headersReceive', (header: Object) => {
      const h = header as Record<string, Object>
      const code = h['responseCode']
      if (typeof code === 'number') {
        httpCode = code
      }
    })

    session.on('dataReceive', (data: ArrayBuffer) => {
      if (finished) {
        return
      }
      const text = decoder.decodeToString(new Uint8Array(data))
      if (httpCode !== 200 && httpCode !== 0) {
        // 非 200：累积错误响应体（UnsuccessfulResponseException 等价）
        httpBody += text
        return
      }
      buffer += text
      // SSE：按行切分，保留不完整尾行
      let newlineIndex = buffer.indexOf('\n')
      while (newlineIndex >= 0) {
        let line = buffer.substring(0, newlineIndex)
        buffer = buffer.substring(newlineIndex + 1)
        if (line.endsWith('\r')) {
          line = line.substring(0, line.length - 1)
        }
        processLine(line)
        if (finished) {
          return
        }
        newlineIndex = buffer.indexOf('\n')
      }
    })

    const processLine = (line: string): void => {
      if (!line.startsWith('data:')) {
        return
      }
      const data = line.substring(5)
      // p9/m.a.c()：[DONE] → 完成
      if (data === '[DONE]') {
        finishWith(AiChatResult.done(content, reasoning, role, finishReason))
        return
      }
      if (data === '') {
        return
      }
      const chunk = parseDeltaChunk(data)
      if (chunk === null) {
        // p9/m.a catch：解析异常 → status 100
        finishWith(AiChatResult.failed('Parse error', httpCode, httpBody))
        return
      }
      if (chunk.finishReason !== null && chunk.finishReason !== '') {
        finishReason = chunk.finishReason
      }
      if (chunk.role !== null) {
        role = chunk.role
      }
      if (chunk.content !== null) {
        content += chunk.content
      }
      if (chunk.reasoning !== null) {
        reasoning += chunk.reasoning
      }
      // p9/m.a：50ms 节流
      const now = Date.now()
      if (now - lastEmit > 50) {
        lastEmit = now
        onResult(AiChatResult.partial(content, reasoning, role))
      }
    }

    session.on('dataEnd', () => {
      if (finished) {
        return
      }
      if (httpCode !== 200 && httpCode !== 0) {
        finishWith(AiChatResult.failed(`HTTP ${httpCode}`, httpCode, httpBody))
        return
      }
      // 流正常结束但未收到 [DONE]（p9/m.a.d()：未完成 → 请求未完成）
      if (buffer.startsWith('data:')) {
        processLine(buffer)
      }
      if (!finished) {
        finishWith(AiChatResult.done(content, reasoning, role, finishReason))
      }
    })

    try {
      await session.requestInStream(chatUrl(backend), {
        method: http.RequestMethod.POST,
        header: {
          'Authorization': `Bearer ${backend.token}`,
          'Content-Type': 'application/json; charset=utf-8',
          'Accept': 'text/event-stream'
        },
        extraData: buildChatBody(model, messages, true),
        connectTimeout: 30000,
        readTimeout: 60000
      })
    } catch (error) {
      // onError（p9/m.a.onError）：错误或用户 stop
      const err = error as BusinessError
      if (!finished) {
        if (this.session !== session) {
          // 已被 stop() 置空 → 视为中断（hy 请求未完成）
          finishWith(AiChatResult.failed('Stopped'))
        } else {
          finishWith(AiChatResult.failed(err.message ?? 'Request failed'))
        }
      }
    }
  }
}
