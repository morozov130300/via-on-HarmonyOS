// CopilotStore.ets —— 原版 p9 包数据层 1:1 移植
//
// 对应原版类：
// - p9/l.java  → AiBackend（服务商）
// - p9/r.java  → AiThread（会话）
// - p9/n.java  → AiMsg（消息，字段序 toString：id/threadId/content/reasoning/role/flags/createdAt/updatedAt）
// - p9/q.java  → AiSuggestion（提示词）
// - p9/w.java  → SQLiteOpenHelper（DB 名 copilot，版本 4，四表 SQL 逐字照抄）
// - p9/v.java  → 门面（DB CRUD + 内存 url→threadId Map y/z）
// - p9/s.java  → 预设服务商 c()、密钥链接 a()、系统提示词 b()/h()、占位符解析 i()/j()、flags g()
// - p9/n.a/j/s/u → 消息工厂
//
// 引擎（p9/m SSE）在 AiEngine.ets；DB 门面与引擎由上层组合（对应 v 持有 m）。

import { relationalStore, preferences } from '@kit.ArkData'
import { util } from '@kit.ArkTS'
import { AppSettings } from './Settings'

// ----- 角色（role 列为 TEXT，值与原版一致：system / user / assistant）-----

export const ROLE_SYSTEM = 'system'
export const ROLE_USER = 'user'
export const ROLE_ASSISTANT = 'assistant'

// ----- 模型 -----

// p9/l.java：AI 服务商
export class AiBackend {
  id: string = ''
  name: string = ''
  url: string = ''
  token: string = ''
  models: string[] = []
  flags: number = 0
  updatedAt: number = 0
  createdAt: number = 0
}

// p9/r.java：会话
export class AiThread {
  id: string = ''
  name: string = ''
  preview: string = ''
  flags: number = 0
  updatedAt: number = 0
  createdAt: number = 0
}

// p9/n.java：消息
export class AiMsg {
  id: string = ''
  threadId: string = ''
  content: string = ''
  reasoning: string = ''
  role: string = ROLE_USER
  flags: number = 0
  createdAt: number = 0
  updatedAt: number = 0
}

// p9/q.java：提示词（type：1=系统提示词、2=消息模板）
export class AiSuggestion {
  id: string = ''
  name: string = ''
  content: string = ''
  required: string[] = []
  type: number = 2
  flags: number = 0
  updatedAt: number = 0
  createdAt: number = 0
}

// c9/z.java：网页附件（title/url/content）
export class AiAttachment {
  title: string = ''
  url: string = ''
  content: string = ''
}

// ----- 占位符（p9/s.i/j 1:1）-----

// p9/s.j()：合法占位符判定（含空格直接 false）
function isValidVar(token: string, type: number): boolean {
  if (token.indexOf(' ') >= 0) {
    return false
  }
  if (type === 1) {
    return token === '{{webpage_title}}' || token === '{{webpage_url}}' || token === '{{webpage_content}}'
  }
  return token === '{{input}}'
}

// p9/s.i()：从 content 中解析占位符（处理嵌套 {{ ：取最后一个 {{ 到其后的 }}）
export function extractVars(content: string, type: number): string[] {
  const result: string[] = []
  if (content === '') {
    return result
  }
  const length = content.length
  let from = 0
  while (from < length) {
    const open = content.indexOf('{{', from)
    if (open < 0) {
      break
    }
    const close = content.indexOf('}}', open + 2)
    if (close < 0) {
      break
    }
    let start = open
    const lastOpen = content.lastIndexOf('{{', close)
    if (lastOpen > start) {
      start = lastOpen
    }
    if (start + 2 < close) {
      const token = content.substring(start, close + 2)
      if (isValidVar(token, type) && !result.includes(token)) {
        result.push(token)
      }
    }
    from = close + 2
  }
  return result
}

// p9/s.g()：required 中含网页变量 → 1，否则 0（提示词 flags）
export function webpageVarFlags(required: string[]): number {
  if (required === null || required.length === 0) {
    return 0
  }
  return (required.includes('{{webpage_url}}') || required.includes('{{webpage_title}}') ||
    required.includes('{{webpage_content}}')) ? 1 : 0
}

// ----- 预设服务商（p9/s.c，中文 locale 分支 z8.f.h()）-----

export const AI_PRESET_ORDER_ZH: string[] =
  ['', 'BYTEDANCE', 'ALIYUN', 'DEEPSEEK', 'SILICONFLOW', 'OPENROUTER', 'CHATGPT', 'GEMINI', 'CLAUDE']

// p9/s.c()：按 key 生成预设服务商；未知返回 null
export function presetBackend(key: string): AiBackend | null {
  const b = new AiBackend()
  const now = Date.now()
  b.id = util.generateRandomUUID(false)
  b.createdAt = now
  b.updatedAt = now
  switch (key) {
    case 'SILICONFLOW':
      b.name = '硅基流动'
      b.url = 'https://api.siliconflow.cn/v1'
      b.models = 'deepseek-ai/DeepSeek-V3,deepseek-ai/DeepSeek-R1,Qwen/Qwen3-8B'.split(',')
      return b
    case 'BYTEDANCE':
      b.name = '字节火山引擎'
      b.url = 'https://ark.cn-beijing.volces.com/api/v3'
      b.models = 'deepseek-v3-250324,deepseek-r1-250120'.split(',')
      return b
    case 'DEEPSEEK':
      b.name = 'DeepSeek'
      b.url = 'https://api.deepseek.com'
      b.models = 'deepseek-chat,deepseek-reasoner'.split(',')
      return b
    case 'CHATGPT':
      b.name = 'ChatGPT'
      b.url = 'https://api.openai.com/v1'
      b.models = 'gpt-4.1-mini,o4-mini,o3'.split(',')
      return b
    case 'OPENROUTER':
      b.name = 'OpenRouter'
      b.url = 'https://openrouter.ai/api/v1'
      b.models = 'deepseek/deepseek-chat-v3-0324:free,deepseek/deepseek-r1:free,google/gemini-2.0-flash-exp:free'.split(',')
      return b
    case 'ALIYUN':
      b.name = '阿里云百炼'
      b.url = 'https://dashscope.aliyuncs.com/compatible-mode/v1'
      b.models = 'deepseek-v3,deepseek-r1'.split(',')
      return b
    case 'CLAUDE':
      b.name = 'Claude'
      b.url = 'https://api.anthropic.com/v1/'
      b.models = 'claude-3-7-sonnet-20250219'.split(',')
      return b
    case 'GEMINI':
      b.name = 'Google Gemini'
      b.url = 'https://generativelanguage.googleapis.com/v1beta/openai/'
      b.models = 'gemini-2.0-flash,gemini-1.5-pro'.split(',')
      return b
    default:
      return null
  }
}

// p9/s.a()：服务商 URL → API 密钥管理页；未知 host 返回 null
// host 提取复刻 i0.f()（去 scheme、路径、端口）
export function getKeyLink(addr: string): string | null {
  if (addr === null || addr === '') {
    return null
  }
  let host = addr
  const schemeIndex = host.indexOf('://')
  if (schemeIndex >= 0) {
    host = host.substring(schemeIndex + 3)
  }
  const slashIndex = host.indexOf('/')
  if (slashIndex >= 0) {
    host = host.substring(0, slashIndex)
  }
  const colonIndex = host.indexOf(':')
  if (colonIndex >= 0) {
    host = host.substring(0, colonIndex)
  }
  if (host === '') {
    return null
  }
  if (host === 'api.openai.com') {
    return 'https://platform.openai.com/api-keys'
  }
  if (host === 'ark.cn-beijing.volces.com') {
    return 'https://console.volcengine.com/ark/region:ark+cn-beijing/apiKey?apikey=%7B%7D'
  }
  if (host === 'openrouter.ai') {
    return 'https://openrouter.ai/settings/provisioning-keys'
  }
  if (host === 'dashscope.aliyuncs.com') {
    return 'https://bailian.console.aliyun.com/?tab=model#/api-key'
  }
  if (host === 'api.deepseek.com') {
    return 'https://platform.deepseek.com/api_keys'
  }
  if (host === 'api.siliconflow.cn') {
    return 'https://cloud.siliconflow.cn/account/ak'
  }
  if (host === 'api.anthropic.com') {
    return 'https://console.anthropic.com/account/keys'
  }
  if (host === 'generativelanguage.googleapis.com') {
    return 'https://aistudio.google.com/app/apikey'
  }
  return null
}

// ----- 系统提示词（p9/s.b/h 原文）-----

// p9/s.b(z)：带网页上下文的系统提示词（{{user_language}} 由引擎替换）
export function webpageSystemPrompt(att: AiAttachment): string {
  let out = ''
  out += 'You\'re a proficient AI assistant skilled in concise, on-point responses. ' +
    'Please follow the following principles:\n' +
    '1. Ground answers in the provided webpage, allowing minor thematic tangents but avoiding irrelevance. ' +
    'If info is missing, note gaps clearly.\n' +
    '2. Match the user\'s language ({{user_language}}) and tone precisely.\n' +
    '3. Prioritize clarity: lead with direct answers, add context only if critical.'
  out += '\n\n'
  out += 'The webpage is as follows:\n'
  if (att.url !== '') {
    out += 'Link: '
    out += att.url
    out += '\n'
  }
  if (att.title !== '') {
    out += 'Title: '
    out += att.title
    out += '\n'
  }
  if (att.content !== '') {
    out += 'Content:\n'
    out += att.content
  }
  return out
}

// p9/s.h()：默认系统提示词（无工具分支原文）
export function defaultSystemPrompt(): string {
  return 'Act as an Expert Answerer. Follow these rules:\n\n' +
    '1. Concisely answer the core question within 3 sentences. Prioritize clarity.\n' +
    '2. Match the user\'s language (e.g., respond in Chinese if asked in Chinese).\n' +
    '3. Structure answers when answering professional content.\n' +
    '4. Omit polite filler, disclaimers, or redundant content.\n\n' +
    'Stay strictly on-task.'
}

// ----- 消息工厂（p9/n.j/a/s/u）-----

// p9/n.j()：通用工厂（id=UUID、updatedAt=createdAt=now）
export function makeMsg(content: string, role: string, threadId: string): AiMsg {
  const m = new AiMsg()
  m.id = util.generateRandomUUID(false)
  m.threadId = threadId
  m.content = content
  m.role = role
  m.createdAt = Date.now()
  m.updatedAt = m.createdAt
  return m
}

// p9/n.a()：assistant 消息
export function assistantMsg(content: string, threadId: string): AiMsg {
  return makeMsg(content, ROLE_ASSISTANT, threadId)
}

// p9/n.s()：system 消息
export function systemMsg(content: string, threadId: string): AiMsg {
  return makeMsg(content, ROLE_SYSTEM, threadId)
}

// p9/n.u()：user 消息
export function userMsg(content: string, threadId: string): AiMsg {
  return makeMsg(content, ROLE_USER, threadId)
}

// ----- 行转换（p9/w 各 mapValues）-----

function backendRow(b: AiBackend, withId: boolean): relationalStore.ValuesBucket {
  const row: relationalStore.ValuesBucket = {}
  if (withId) {
    row.id = b.id
  }
  row.name = b.name
  row.url = b.url
  row.token = b.token
  row.models = b.models.join(',')
  row.flags = b.flags
  row.updated_at = b.updatedAt
  row.created_at = b.createdAt
  return row
}

function threadRow(t: AiThread, withId: boolean): relationalStore.ValuesBucket {
  const row: relationalStore.ValuesBucket = {}
  if (withId) {
    row.id = t.id
  }
  row.name = t.name
  row.preview = t.preview
  row.flags = t.flags
  row.updated_at = t.updatedAt
  row.created_at = t.createdAt
  return row
}

function msgRow(m: AiMsg, withId: boolean): relationalStore.ValuesBucket {
  const row: relationalStore.ValuesBucket = {}
  if (withId) {
    row.id = m.id
  }
  row.thread_id = m.threadId
  row.content = m.content
  row.reasoning = m.reasoning
  row.role = m.role
  row.flags = m.flags
  row.updated_at = m.updatedAt
  return row
}

function suggestionRow(s: AiSuggestion, withId: boolean): relationalStore.ValuesBucket {
  const row: relationalStore.ValuesBucket = {}
  if (withId) {
    row.id = s.id
  }
  row.name = s.name
  row.content = s.content
  row.vendors = ''
  row.required = s.required.join(',')
  row.type = s.type
  row.flags = s.flags
  row.updated_at = s.updatedAt
  row.created_at = s.createdAt
  return row
}

function readBackend(rs: relationalStore.ResultSet): AiBackend {
  const b = new AiBackend()
  b.id = rs.getString(rs.getColumnIndex('id'))
  b.name = rs.getString(rs.getColumnIndex('name'))
  b.url = rs.getString(rs.getColumnIndex('url'))
  b.token = rs.getString(rs.getColumnIndex('token'))
  const models = rs.getString(rs.getColumnIndex('models'))
  b.models = models === null || models === '' ? [] : models.split(',')
  if (rs.isColumnNull(rs.getColumnIndex('flags'))) {
    b.flags = 0
  } else {
    b.flags = rs.getLong(rs.getColumnIndex('flags'))
  }
  b.updatedAt = rs.getLong(rs.getColumnIndex('updated_at'))
  b.createdAt = rs.getLong(rs.getColumnIndex('created_at'))
  return b
}

function readThread(rs: relationalStore.ResultSet): AiThread {
  const t = new AiThread()
  t.id = rs.getString(rs.getColumnIndex('id'))
  t.name = rs.getString(rs.getColumnIndex('name'))
  t.preview = rs.getString(rs.getColumnIndex('preview'))
  if (rs.isColumnNull(rs.getColumnIndex('flags'))) {
    t.flags = 0
  } else {
    t.flags = rs.getLong(rs.getColumnIndex('flags'))
  }
  t.updatedAt = rs.getLong(rs.getColumnIndex('updated_at'))
  t.createdAt = rs.getLong(rs.getColumnIndex('created_at'))
  return t
}

function readMsg(rs: relationalStore.ResultSet): AiMsg {
  const m = new AiMsg()
  m.id = rs.getString(rs.getColumnIndex('id'))
  m.threadId = rs.getString(rs.getColumnIndex('thread_id'))
  m.content = rs.getString(rs.getColumnIndex('content'))
  if (rs.isColumnNull(rs.getColumnIndex('reasoning'))) {
    m.reasoning = ''
  } else {
    m.reasoning = rs.getString(rs.getColumnIndex('reasoning'))
  }
  m.role = rs.getString(rs.getColumnIndex('role'))
  if (rs.isColumnNull(rs.getColumnIndex('flags'))) {
    m.flags = 0
  } else {
    m.flags = rs.getLong(rs.getColumnIndex('flags'))
  }
  m.updatedAt = rs.getLong(rs.getColumnIndex('updated_at'))
  return m
}

function readSuggestion(rs: relationalStore.ResultSet): AiSuggestion {
  const s = new AiSuggestion()
  s.id = rs.getString(rs.getColumnIndex('id'))
  s.name = rs.getString(rs.getColumnIndex('name'))
  s.content = rs.getString(rs.getColumnIndex('content'))
  const required = rs.getString(rs.getColumnIndex('required'))
  s.required = required === null || required === '' ? [] : required.split(',')
  if (rs.isColumnNull(rs.getColumnIndex('type'))) {
    s.type = 0
  } else {
    s.type = rs.getLong(rs.getColumnIndex('type'))
  }
  if (rs.isColumnNull(rs.getColumnIndex('flags'))) {
    s.flags = 0
  } else {
    s.flags = rs.getLong(rs.getColumnIndex('flags'))
  }
  s.updatedAt = rs.getLong(rs.getColumnIndex('updated_at'))
  s.createdAt = rs.getLong(rs.getColumnIndex('created_at'))
  return s
}

// ----- 提示词工厂（p9/q.j/k 构造 + p9/s.g flags）-----

export function newSuggestion(name: string, content: string, type: number): AiSuggestion {
  const s = new AiSuggestion()
  s.id = util.generateRandomUUID(false)
  s.name = name
  s.content = content
  s.required = extractVars(content, type)
  s.type = type
  s.flags = webpageVarFlags(s.required)
  const now = Date.now()
  s.createdAt = now
  s.updatedAt = now
  return s
}

// 旧版占位实现的 aiProvider → 服务商名/接口地址（迁移用，原版无此映射）
function legacyProviderName(provider: string): string {
  if (provider === 'deepseek') {
    return 'DeepSeek'
  }
  if (provider === 'openai') {
    return 'ChatGPT'
  }
  if (provider === 'siliconflow') {
    return 'SiliconFlow'
  }
  return provider === '' ? '自定义' : provider
}

function legacyProviderUrl(provider: string): string {
  if (provider === 'deepseek') {
    return 'https://api.deepseek.com'
  }
  if (provider === 'openai') {
    return 'https://api.openai.com/v1'
  }
  if (provider === 'siliconflow') {
    return 'https://api.siliconflow.cn/v1'
  }
  return ''
}

// ----- 存储门面（p9/w + p9/v）-----

export class CopilotStore {
  private static instance: CopilotStore | null = null

  static getInstance(): CopilotStore {
    if (CopilotStore.instance === null) {
      CopilotStore.instance = new CopilotStore()
    }
    return CopilotStore.instance
  }

  private rdb: relationalStore.RdbStore | null = null
  private initing: Promise<void> | null = null
  // p9/v.f11080c：内存 url→threadId 映射（y/z，进程内有效）
  private urlToThreadId: Map<string, string> = new Map()

  // 初始化（对应 w 构造 + onCreate；SQL 逐字照抄 p9/w.onCreate）
  async init(context: Context): Promise<void> {
    if (this.rdb !== null) {
      return
    }
    if (this.initing !== null) {
      await this.initing
      return
    }
    const doInit = async (): Promise<void> => {
      const config: relationalStore.StoreConfig = {
        name: 'copilot.db',
        securityLevel: relationalStore.SecurityLevel.S1
      }
      const rdb = await relationalStore.getRdbStore(context, config)
      const creates: string[] = [
        'CREATE TABLE IF NOT EXISTS backends (id TEXT PRIMARY KEY NOT NULL, name TEXT NOT NULL, ' +
        'url TEXT NOT NULL, token TEXT NOT NULL, models TEXT, flags INTEGER DEFAULT 0, ' +
        'updated_at INTEGER DEFAULT 0, created_at INTEGER DEFAULT 0)',
        'CREATE TABLE IF NOT EXISTS threads (id TEXT PRIMARY KEY NOT NULL, name TEXT, preview TEXT, ' +
        'flags INTEGER DEFAULT 0, updated_at INTEGER DEFAULT 0, created_at INTEGER DEFAULT 0)',
        'CREATE TABLE IF NOT EXISTS messages (id TEXT PRIMARY KEY NOT NULL, thread_id TEXT NOT NULL, ' +
        'content TEXT NOT NULL, reasoning TEXT, role TEXT NOT NULL, flags INTEGER DEFAULT 0, ' +
        'updated_at INTEGER DEFAULT 0)',
        'CREATE TABLE IF NOT EXISTS suggestions (id TEXT PRIMARY KEY NOT NULL, name TEXT, content TEXT, ' +
        'vendors TEXT, required TEXT, type INTEGER DEFAULT 0, flags INTEGER DEFAULT 0, ' +
        'updated_at INTEGER DEFAULT 0, created_at INTEGER DEFAULT 0)'
      ]
      for (let i = 0; i < creates.length; i++) {
        await rdb.executeSql(creates[i])
      }
      this.rdb = rdb
      await this.migrateLegacy(context)
    }
    this.initing = doInit()
    await this.initing
    this.initing = null
  }

  // 旧占位数据一次性迁移（原版无此逻辑）：
  // aiPrompts(JSON 数组)→suggestions 表；aiApiKey/aiProvider/aiModel→自定义服务商 + aibackend/aimodel
  // 库中已有数据则跳过对应部分，不删除任何旧偏好
  private async migrateLegacy(context: Context): Promise<void> {
    try {
      const prefs = await preferences.getPreferences(context, 'via_settings')
      const existingSuggestions = await this.suggestions()
      if (existingSuggestions.length === 0) {
        const raw = await prefs.get('aiPrompts', '[]')
        if (typeof raw === 'string' && raw !== '' && raw !== '[]') {
          const parsed = JSON.parse(raw) as Object[]
          const base = Date.now() - parsed.length
          for (let i = 0; i < parsed.length; i++) {
            const element = parsed[i] as Record<string, Object>
            const name = element['name']
            const content = element['content']
            const type = element['type']
            if (typeof name === 'string' && typeof content === 'string' && typeof type === 'number') {
              const s = newSuggestion(name, content, type)
              s.createdAt = base + i
              s.updatedAt = base + i
              await this.insertSuggestion(s)
            }
          }
        }
      }
      const existingBackends = await this.backends()
      if (existingBackends.length === 0) {
        const key = await prefs.get('aiApiKey', '')
        if (typeof key === 'string' && key !== '') {
          const provider = await prefs.get('aiProvider', '')
          const model = await prefs.get('aiModel', '')
          const providerStr = typeof provider === 'string' ? provider : ''
          const modelStr = typeof model === 'string' ? model : ''
          const b = new AiBackend()
          b.id = util.generateRandomUUID(false)
          b.name = legacyProviderName(providerStr)
          b.url = legacyProviderUrl(providerStr)
          b.token = key
          if (modelStr !== '') {
            b.models = [modelStr]
          }
          const now = Date.now()
          b.createdAt = now
          b.updatedAt = now
          await this.insertBackend(b)
          await prefs.put('aibackend', b.id)
          if (modelStr !== '') {
            await prefs.put('aimodel', modelStr)
          }
          await prefs.flush()
          const app = AppSettings.getInstance()
          app.aiBackend = b.id
          app.aiModel = modelStr
        }
      }
    } catch (error) {
      console.error('copilot legacy migration failed')
    }
  }

  // ----- url→threadId 映射（p9/v.y/z）-----

  // p9/v.y()：threadId 绑定 url
  bindUrl(threadId: string, url: string): void {
    if (threadId === '' || url === '') {
      return
    }
    this.urlToThreadId.set(url, threadId)
  }

  // p9/v.z()：url → threadId（无则 null）
  threadIdOfUrl(url: string): string | null {
    if (url === '') {
      return null
    }
    return this.urlToThreadId.get(url) ?? null
  }

  // ----- backends（p9/w：p/b/o/d/k）-----

  // p9/w.p()：全部服务商（created_at ASC）
  async backends(): Promise<AiBackend[]> {
    const out: AiBackend[] = []
    if (this.rdb === null) {
      return out
    }
    const predicates = new relationalStore.RdbPredicates('backends')
    predicates.orderByAsc('created_at')
    const rs = await this.rdb.query(predicates)
    while (rs.goToNextRow()) {
      out.push(readBackend(rs))
    }
    rs.close()
    return out
  }

  // p9/w.b()：单个服务商
  async backend(id: string): Promise<AiBackend | null> {
    if (this.rdb === null || id === '') {
      return null
    }
    const predicates = new relationalStore.RdbPredicates('backends')
    predicates.equalTo('id', id)
    const rs = await this.rdb.query(predicates)
    let result: AiBackend | null = null
    if (rs.goToNextRow()) {
      result = readBackend(rs)
    }
    rs.close()
    return result
  }

  // p9/w.o()：插入
  async insertBackend(backend: AiBackend): Promise<void> {
    if (this.rdb === null) {
      return
    }
    await this.rdb.insert('backends', backendRow(backend, true))
  }

  // p9/w.d()：更新
  async updateBackend(id: string, backend: AiBackend): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('backends')
    predicates.equalTo('id', id)
    await this.rdb.update(backendRow(backend, false), predicates)
  }

  // p9/w.k()：删除
  async deleteBackend(id: string): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('backends')
    predicates.equalTo('id', id)
    await this.rdb.delete(predicates)
  }

  // ----- threads（p9/w：l/n/w/q/h）-----

  // p9/w.l()：全部会话（updated_at DESC）
  async threads(): Promise<AiThread[]> {
    const out: AiThread[] = []
    if (this.rdb === null) {
      return out
    }
    const predicates = new relationalStore.RdbPredicates('threads')
    predicates.orderByDesc('updated_at')
    const rs = await this.rdb.query(predicates)
    while (rs.goToNextRow()) {
      out.push(readThread(rs))
    }
    rs.close()
    return out
  }

  // p9/w.n()：单个会话
  async thread(id: string): Promise<AiThread | null> {
    if (this.rdb === null || id === '') {
      return null
    }
    const predicates = new relationalStore.RdbPredicates('threads')
    predicates.equalTo('id', id)
    const rs = await this.rdb.query(predicates)
    let result: AiThread | null = null
    if (rs.goToNextRow()) {
      result = readThread(rs)
    }
    rs.close()
    return result
  }

  // p9/w.w()：插入
  async insertThread(thread: AiThread): Promise<void> {
    if (this.rdb === null) {
      return
    }
    await this.rdb.insert('threads', threadRow(thread, true))
  }

  // p9/w.q()：更新
  async updateThread(id: string, thread: AiThread): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('threads')
    predicates.equalTo('id', id)
    await this.rdb.update(threadRow(thread, false), predicates)
  }

  // p9/w.h()：级联删除会话 + 其消息
  async deleteThreads(ids: string[]): Promise<void> {
    if (this.rdb === null || ids.length === 0) {
      return
    }
    for (let i = 0; i < ids.length; i++) {
      const tp = new relationalStore.RdbPredicates('threads')
      tp.equalTo('id', ids[i])
      await this.rdb.delete(tp)
      const mp = new relationalStore.RdbPredicates('messages')
      mp.equalTo('thread_id', ids[i])
      await this.rdb.delete(mp)
    }
  }

  // ----- messages（p9/w：x/m/f/i/j/a）-----

  // p9/w.x()：会话消息（updated_at ASC）
  async messages(threadId: string): Promise<AiMsg[]> {
    const out: AiMsg[] = []
    if (this.rdb === null) {
      return out
    }
    const predicates = new relationalStore.RdbPredicates('messages')
    predicates.equalTo('thread_id', threadId)
    predicates.orderByAsc('updated_at')
    const rs = await this.rdb.query(predicates)
    while (rs.goToNextRow()) {
      out.push(readMsg(rs))
    }
    rs.close()
    return out
  }

  // p9/w.m()：单条消息
  async message(id: string): Promise<AiMsg | null> {
    if (this.rdb === null || id === '') {
      return null
    }
    const predicates = new relationalStore.RdbPredicates('messages')
    predicates.equalTo('id', id)
    const rs = await this.rdb.query(predicates)
    let result: AiMsg | null = null
    if (rs.goToNextRow()) {
      result = readMsg(rs)
    }
    rs.close()
    return result
  }

  // p9/w.f()：插入
  async insertMessage(msg: AiMsg): Promise<void> {
    if (this.rdb === null) {
      return
    }
    await this.rdb.insert('messages', msgRow(msg, true))
  }

  // p9/w.i()：更新
  async updateMessage(id: string, msg: AiMsg): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('messages')
    predicates.equalTo('id', id)
    await this.rdb.update(msgRow(msg, false), predicates)
  }

  // p9/w.j()：删除单条
  async deleteMessage(id: string): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('messages')
    predicates.equalTo('id', id)
    await this.rdb.delete(predicates)
  }

  // p9/w.a()：清空会话消息（保留 system）
  async clearMessages(threadId: string): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('messages')
    predicates.equalTo('thread_id', threadId)
    predicates.notEqualTo('role', ROLE_SYSTEM)
    await this.rdb.delete(predicates)
  }

  // ----- suggestions（p9/w：r/g/v/t/s/u）-----

  // p9/w.r()：全部提示词（created_at ASC）
  async suggestions(): Promise<AiSuggestion[]> {
    const out: AiSuggestion[] = []
    if (this.rdb === null) {
      return out
    }
    const predicates = new relationalStore.RdbPredicates('suggestions')
    predicates.orderByAsc('created_at')
    const rs = await this.rdb.query(predicates)
    while (rs.goToNextRow()) {
      out.push(readSuggestion(rs))
    }
    rs.close()
    return out
  }

  // p9/w.g()：按 type 过滤
  async suggestionsByType(type: number): Promise<AiSuggestion[]> {
    const out: AiSuggestion[] = []
    if (this.rdb === null) {
      return out
    }
    const predicates = new relationalStore.RdbPredicates('suggestions')
    predicates.equalTo('type', type)
    predicates.orderByAsc('created_at')
    const rs = await this.rdb.query(predicates)
    while (rs.goToNextRow()) {
      out.push(readSuggestion(rs))
    }
    rs.close()
    return out
  }

  // p9/w.v()：单条
  async suggestion(id: string): Promise<AiSuggestion | null> {
    if (this.rdb === null || id === '') {
      return null
    }
    const predicates = new relationalStore.RdbPredicates('suggestions')
    predicates.equalTo('id', id)
    const rs = await this.rdb.query(predicates)
    let result: AiSuggestion | null = null
    if (rs.goToNextRow()) {
      result = readSuggestion(rs)
    }
    rs.close()
    return result
  }

  // p9/w.t()：插入
  async insertSuggestion(s: AiSuggestion): Promise<void> {
    if (this.rdb === null) {
      return
    }
    await this.rdb.insert('suggestions', suggestionRow(s, true))
  }

  // p9/w.s()：更新
  async updateSuggestion(id: string, s: AiSuggestion): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('suggestions')
    predicates.equalTo('id', id)
    await this.rdb.update(suggestionRow(s, false), predicates)
  }

  // p9/w.u()：删除
  async deleteSuggestion(id: string): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('suggestions')
    predicates.equalTo('id', id)
    await this.rdb.delete(predicates)
  }
}
