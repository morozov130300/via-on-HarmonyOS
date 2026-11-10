// AiPanel.ets —— 原版 b9 包 AI 面板 1:1 移植
//
// 对应原版：
// - b9/g.java  → 面板容器（ViewPager2 两页：0=主题列表、1=聊天）
// - b9/r2.java → 页0：主题列表（多选、删除、设置入口、新建）
// - b9/a2.java → 页1：聊天（气泡、chips、输入区、溢出菜单、导出）
// - b9/q0.java → 消息预览覆盖层（Markdown/纯文本切换）
// - b9/e0.java → ViewModel（全部逻辑 1:1）
// - c9/y.java  → 主题行（图标+标题+时间+预览）
// - c9/g0/l.java → 用户/助手气泡
// - c9/s.java  → 提示词 chip；c9/e.java → 网页附件 chip
//
// 视觉规格（已按反编译资源逐项核对）：
// - 气泡圆角 18dp（dimen ae）；用户气泡 accent、文字 14sp 白色；
//   助手气泡 #15808080、文字 14sp；ASSISTANT 标签 11sp 加粗大写 #8a000000
// - chip：圆角 18dp、描边 1dp #30808080、选中描边/文字 accent、文字 12sp、maxWidth 96dp
// - 输入容器：圆角 18dp、描边 2dp #30808080；输入 14sp、maxLines 5、hint「消息」
// - 发送按钮：圆形 accent + uia_ai_send；busy：圆形 #d64146 + uia_ic_stop
// - 主题行：uia_ai_thread 图标、标题 14sp 加粗 #8a000000、时间 11sp、预览 12sp（单行省略）
// - 空态：「¯\_(ツ)_/¯」22sp；选中行背景 #30808080

import { pasteboard } from '@kit.BasicServicesKit'
import { fileIo as fs, picker } from '@kit.CoreFileKit'
import { util } from '@kit.ArkTS'
import { AppSettings } from '../common/Settings'
import { AiEngine, AiChatResult, ChatMsgIn } from '../common/AiEngine'
import { CopilotStore, AiThread, AiMsg, AiBackend, AiAttachment, AiSuggestion,
  userMsg, assistantMsg, systemMsg, ROLE_SYSTEM, ROLE_USER,
  defaultSystemPrompt, webpageSystemPrompt } from '../common/CopilotStore'
import { UiaIcon } from './UiaIcon'
import { computeDialogWidthVp } from './UiaDialogCard'

// ----- 展示模型 -----

class MsgDisplay {
  id: string = ''
  isUser: boolean = false
  text: string = ''
}

class ChipDisplay {
  id: string = ''
  label: string = ''
  selected: boolean = false
}

class ThreadDisplay {
  thread: AiThread = new AiThread()
  title: string = ''
  time: string = ''
  preview: string = ''
  selected: boolean = false
}

// g6.p.j()：截断
function truncate(text: string | null, max: number): string {
  if (text === null) {
    return ''
  }
  return text.length > max ? text.substring(0, max) : text
}

// z8/u3.a()：相对时间（zh：刚刚 / N 分钟前 / N 小时前 / 昨天 / N 天前 / M月d日 / yyyy年M月d日）
function formatRelativeTime(ts: number, justNow: string): string {
  const now = Date.now()
  const diff = now - ts
  if (diff < 60000) {
    return justNow
  }
  const minutes = Math.floor(diff / 60000)
  if (minutes < 60) {
    return `${minutes} 分钟前`
  }
  const hours = Math.floor(minutes / 60)
  if (hours < 24) {
    return `${hours} 小时前`
  }
  const date = new Date(ts)
  const nowDate = new Date(now)
  const days = Math.floor(hours / 24)
  if (days === 1) {
    return '昨天'
  }
  if (days < 7) {
    return `${days} 天前`
  }
  const sameYear = date.getFullYear() === nowDate.getFullYear()
  if (sameYear) {
    return `${date.getMonth() + 1}月${date.getDate()}日`
  }
  return `${date.getFullYear()}年${date.getMonth() + 1}月${date.getDate()}日`
}

function two(n: number): string {
  return n < 10 ? `0${n}` : `${n}`
}

// p9/e0.o0() 的 {{time}}：yyyy-MM-dd HH:mm:ss EEEE (ZZZZ)
function formatVarTime(): string {
  const d = new Date()
  const weekdays = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六']
  const offset = -d.getTimezoneOffset()
  const sign = offset >= 0 ? '+' : '-'
  const oh = Math.floor(Math.abs(offset) / 60)
  const om = Math.abs(offset) % 60
  return `${d.getFullYear()}-${two(d.getMonth() + 1)}-${two(d.getDate())} ` +
    `${two(d.getHours())}:${two(d.getMinutes())}:${two(d.getSeconds())} ` +
    `${weekdays[d.getDay()]} (${sign}${two(oh)}:${two(om)})`
}

// z8/t1.d()：导出文件名日期 yyyy-MM-dd
function formatFileDate(): string {
  const d = new Date()
  return `${d.getFullYear()}-${two(d.getMonth() + 1)}-${two(d.getDate())}`
}

@ComponentV2
export struct AiPanel {
  @Event onClose: () => void = () => {}
  @Event onOpenSettings: () => void = () => {}
  @Event registerBack: (handler: () => boolean) => void = () => {}
  // 入口参数（k6.ba()：网页附件 + 已绑定线程）
  @Param initAttachment: AiAttachment | null = null
  @Param initThreadId: string = ''

  private store: CopilotStore = CopilotStore.getInstance()
  private settings: AppSettings = AppSettings.getInstance()
  private engine: AiEngine = new AiEngine()
  private scroller: Scroller = new Scroller()

  // ----- UI 状态（LiveData 对应）-----
  @Local page: number = 0
  @Local swipeEnabled: boolean = true
  @Local busy: boolean = false
  @Local titleText: string = ''
  @Local input: string = ''
  @Local msgs: MsgDisplay[] = []
  @Local chips: ChipDisplay[] = []
  @Local threadRows: ThreadDisplay[] = []
  @Local multiSelect: boolean = false
  @Local previewVisible: boolean = false
  @Local previewText: string = ''
  @Local previewMarkdown: boolean = false
  @Local inputFocused: boolean = false
  @Local sendVisible: boolean = false
  @Local modelSheetVisible: boolean = false

  // ----- ViewModel 私有状态（e0 字段）-----
  private gen: number = 0
  private thread: AiThread | null = null
  private sysPrompt: string = ''
  private ctx: ChatMsgIn[] = []
  private ctxIds: string[] = []
  private backend: AiBackend | null = null
  private attachment: AiAttachment | null = null
  private lastPersist: number = 0
  private selectedIds: Set<string> = new Set()
  private chipSugs: AiSuggestion[] = []
  private selectedChipId: string = 'default'
  private models: string[] = []
  private inputController: TextInputController = new TextInputController()

  aboutToAppear(): void {
    this.registerBack((): boolean => this.panelBack())
    this.attachment = this.initAttachment
    if (this.initAttachment !== null || this.initThreadId !== '') {
      this.page = 1
    }
    this.s0()
    this.w0()
    this.v0()
    if (this.initThreadId !== '') {
      this.t0(this.initThreadId)
    }
  }

  // ----- e0.s0()：加载当前服务商 -----
  private async s0(): Promise<void> {
    this.backend = await this.store.backend(this.settings.aiBackend)
    this.models = this.backend === null ? [] : this.backend.models
  }

  // ----- e0.w0()：刷新主题列表 -----
  private async w0(): Promise<void> {
    const list = await this.store.threads()
    const rows: ThreadDisplay[] = []
    const justNow = this.str('ai_just_now')
    for (let i = 0; i < list.length; i++) {
      const t = list[i]
      const row = new ThreadDisplay()
      row.thread = t
      row.title = t.name === '' ? this.str('ai_no_title') : t.name
      row.time = formatRelativeTime(t.updatedAt, justNow)
      row.preview = t.preview === '' ? this.str('ai_no_messages') : t.preview
      row.selected = this.selectedIds.has(t.id)
      rows.push(row)
    }
    this.threadRows = rows
  }

  // ----- e0.v0()/D()：构建 chips -----
  private async v0(): Promise<void> {
    const noThread = this.thread === null
    const hasAtt = noThread && this.attachment !== null
    const sugs = await this.store.suggestionsByType(noThread ? 1 : 2)
    const picked: AiSuggestion[] = []
    for (let i = 0; i < sugs.length; i++) {
      const s = sugs[i]
      const webVar = (s.flags & 1) === 1
      if (hasAtt !== (!webVar)) {
        continue
      }
      picked.push(s)
    }
    const chips: ChipDisplay[] = []
    const chipSugs: AiSuggestion[] = []
    if (picked.length > 0) {
      const def = new AiSuggestion()
      def.id = 'default'
      def.content = 'Casual chat'
      def.type = noThread ? 1 : 2
      chips.push(this.chipDisplay(def))
      chipSugs.push(def)
    }
    for (let i = 0; i < picked.length; i++) {
      chips.push(this.chipDisplay(picked[i]))
      chipSugs.push(picked[i])
    }
    this.chips = chips
    this.chipSugs = chipSugs
  }

  private chipDisplay(s: AiSuggestion): ChipDisplay {
    const c = new ChipDisplay()
    c.id = s.id
    c.label = s.id === 'default' ? this.str('ai_casual') : s.name
    c.selected = s.id === this.selectedChipId
    return c
  }

  // e0.e0()：当前选中提示词
  private selectedSug(): AiSuggestion | null {
    for (let i = 0; i < this.chipSugs.length; i++) {
      if (this.chipSugs[i].id === this.selectedChipId) {
        return this.chipSugs[i]
      }
    }
    return null
  }

  // e0.C0()：切换选中 chip
  private selectChip(id: string): void {
    if (this.selectedChipId === id) {
      return
    }
    this.selectedChipId = id
    const next: ChipDisplay[] = []
    for (let i = 0; i < this.chips.length; i++) {
      next.push(this.chips[i])
    }
    for (let i = 0; i < next.length; i++) {
      next[i].selected = next[i].id === id
    }
    this.chips = next
  }

  // ----- e0.Y()：消息模板套用 -----
  private applyTemplate(input: string): string {
    const sug = this.selectedSug()
    if (sug === null || sug.id === 'default') {
      return input
    }
    if (sug.required.length === 0) {
      return `${sug.content}\n${input}`
    }
    let out = sug.content
    for (let i = 0; i < sug.required.length; i++) {
      out = out.split(sug.required[i]).join(this.resolveVar(sug.required[i], null, input) ?? '')
    }
    return out
  }

  // ----- e0.g0()：系统提示词 -----
  private buildSystemPrompt(att: AiAttachment | null): string {
    const sug = this.selectedSug()
    if (sug === null || sug.id === 'default') {
      return att !== null ? webpageSystemPrompt(att) : defaultSystemPrompt()
    }
    if (sug.required.length === 0) {
      return sug.content
    }
    let out = sug.content
    for (let i = 0; i < sug.required.length; i++) {
      out = out.split(sug.required[i]).join(this.resolveVar(sug.required[i], att, null) ?? '')
    }
    return out
  }

  // e0.o0()：占位符解析
  private resolveVar(name: string, att: AiAttachment | null, input: string | null): string | null {
    if (name === '{{webpage_url}}') {
      return att !== null ? att.url : null
    }
    if (name === '{{webpage_title}}') {
      return att !== null ? att.title : null
    }
    if (name === '{{webpage_content}}') {
      return att !== null ? att.content : null
    }
    if (name === '{{time}}') {
      return formatVarTime()
    }
    if (name === '{{input}}') {
      return input
    }
    return null
  }

  // ----- e0.X()：消息展示文本 -----
  private displayText(m: AiMsg): string {
    if (m.reasoning === '') {
      return m.content
    }
    const prefix = `>${m.reasoning.split('\n').join('\n>')}`
    if (m.content !== '') {
      return `${prefix}\n\n${m.content}`
    }
    return prefix
  }

  // ----- e0.H()：上下文缓存（cap 18）-----
  private pushCtx(m: AiMsg): void {
    if ((m.flags & 1) === 1 || m.content === '') {
      return
    }
    if (this.ctx.length > 18) {
      this.ctx.shift()
      this.ctxIds.shift()
    }
    this.ctx.push(new ChatMsgIn(m.role, m.content))
    this.ctxIds.push(m.id)
  }

  // ----- e0.U()：当前模型 -----
  private currentModel(): string {
    if (this.backend === null || this.backend.models.length === 0) {
      return this.settings.aiModel
    }
    const want = this.settings.aiModel
    return this.backend.models.indexOf(want) >= 0 ? want : this.backend.models[0]
  }

  // e0.S()：模型列表
  private modelList(): string[] {
    return this.models
  }

  // ----- e0.z0()：发送 -----
  private async send(): Promise<void> {
    const raw = this.input
    if (raw === '') {
      return
    }
    this.gen++
    this.busy = true
    let t = this.thread
    let text = raw
    if (t === null) {
      t = this.createThread(raw)
      this.v0()
    } else {
      text = this.applyTemplate(raw)
    }
    const reqs: ChatMsgIn[] = []
    if (this.sysPrompt !== '') {
      reqs.push(new ChatMsgIn(ROLE_SYSTEM, this.sysPrompt))
    }
    const um = userMsg(text, t.id)
    await this.store.insertMessage(um)
    this.pushCtx(um)
    for (let i = 0; i < this.ctx.length; i++) {
      reqs.push(this.ctx[i])
    }
    const am = assistantMsg('', t.id)
    await this.store.insertMessage(am)
    const du = new MsgDisplay()
    du.id = um.id
    du.isUser = true
    du.text = um.content
    const da = new MsgDisplay()
    da.id = am.id
    da.isUser = false
    da.text = ''
    const next: MsgDisplay[] = []
    for (let i = 0; i < this.msgs.length; i++) {
      next.push(this.msgs[i])
    }
    next.push(du)
    next.push(da)
    this.msgs = next
    this.scrollToBottom()
    this.input = ''
    this.inputController.caretPosition(0)
    this.streamChat(t, am, reqs)
  }

  // p9/v.A()：取服务商并流式请求
  private async streamChat(t: AiThread, am: AiMsg, reqs: ChatMsgIn[]): Promise<void> {
    if (reqs.length === 0) {
      this.onStreamResult(t, am, AiChatResult.failed(this.str('ai_no_messages')))
      return
    }
    if (this.backend === null) {
      this.onStreamResult(t, am, AiChatResult.failed(this.str('ai_no_provider')))
      return
    }
    const backend = this.backend
    const model = this.currentModel()
    await this.engine.stream(backend, model, reqs, (r: AiChatResult) => {
      this.onStreamResult(t, am, r)
    })
  }

  // e0.p()：流回调
  private onStreamResult(t: AiThread, am: AiMsg, r: AiChatResult): void {
    if (r.status === 0 || r.status === 1) {
      am.content = r.content
      am.reasoning = r.reasoning
      am.updatedAt = Date.now()
    }
    const done = r.status === 1 || r.status === 100
    const hasContent = !(r.status === 1 && am.content === '' && am.reasoning === '')
    if (done && !hasContent) {
      am.flags |= 1
      am.content = `❗${this.errorText(r)}`
    }
    this.updateMsgDisplay(am)
    const now = Date.now()
    if (done || now - this.lastPersist > 2000) {
      this.store.updateMessage(am.id, am)
      this.lastPersist = now
    }
    if (done) {
      t.updatedAt = Date.now()
      t.preview = truncate(this.displayText(am), 200) || ' '
      this.w0()
      if (hasContent) {
        this.pushCtx(am)
      }
      this.store.updateThread(t.id, t)
      this.busy = false
      if (this.thread !== null && this.thread.id === t.id) {
        this.titleText = t.name
      }
    }
    this.scrollToBottom()
  }

  // p9/s.e()：错误文案
  private errorText(r: AiChatResult): string {
    const rm = this.context().resourceManager
    if (r.httpCode > 0) {
      return rm.getStringByNameSync('ai_http_error', r.httpCode, r.httpBody)
    }
    if (r.error === 'Invalid backend') {
      return rm.getStringByNameSync('ai_provider_misconfigured')
    }
    if (r.error === 'Stopped') {
      return rm.getStringByNameSync('ai_unknown_error', 'Unknow error')
    }
    return rm.getStringByNameSync('ai_unknown_error', r.error)
  }

  private updateMsgDisplay(am: AiMsg): void {
    const next: MsgDisplay[] = []
    for (let i = 0; i < this.msgs.length; i++) {
      next.push(this.msgs[i])
    }
    for (let i = 0; i < next.length; i++) {
      if (next[i].id === am.id) {
        next[i].text = this.displayText(am)
        break
      }
    }
    this.msgs = next
  }

  private scrollToBottom(): void {
    this.scroller.scrollToIndex(this.msgs.length - 1, false, ScrollAlign.END)
  }

  // ----- e0.x0()：新建主题 -----
  private createThread(input: string): AiThread {
    const t = new AiThread()
    t.id = util.generateRandomUUID(false)
    t.createdAt = Date.now()
    t.updatedAt = t.createdAt
    t.name = ''
    t.preview = truncate(input, 200) || ' '
    this.thread = t
    this.titleText = this.str('ai_new_topic')
    this.sysPrompt = this.buildSystemPrompt(this.attachment)
    this.store.insertThread(t)
    this.store.insertMessage(systemMsg(this.sysPrompt, t.id))
    this.genTitle(input)
    if (this.attachment !== null) {
      this.store.bindUrl(t.id, this.attachment.url)
    }
    this.w0()
    return t
  }

  // e0.p0()/l()：标题摘要
  private async genTitle(input: string): Promise<void> {
    const t = this.thread
    if (t === null) {
      return
    }
    const myGen = this.gen
    const reqs: ChatMsgIn[] = [new ChatMsgIn(ROLE_SYSTEM,
      'Act as an Expert Title Summarizer. Generate a concise summary title (max 10 words, one sentence) ' +
      'in the same language as the input text. If the input contains proper terms (e.g., \'Java/Python\'), ' +
      'prioritize the user\'s language context over term language. Avoid markdown formatting.')]
    if (this.attachment !== null) {
      reqs.push(new ChatMsgIn(ROLE_USER, this.attachment.title))
    }
    reqs.push(new ChatMsgIn(ROLE_USER, input))
    let name = truncate(input, 20)
    if (this.backend !== null) {
      const r = await this.engine.complete(this.backend, this.currentModel(), reqs)
      if (r.status === 1 && r.content !== '') {
        name = r.content.trim()
      }
    }
    if (this.gen !== myGen || this.thread === null || this.thread.id !== t.id) {
      return
    }
    t.name = name
    this.titleText = name
    this.store.updateThread(t.id, t)
    this.w0()
  }

  // ----- e0.u0()/q()：打开/重置会话 -----
  private async t0(id: string): Promise<void> {
    const cur = this.thread
    if (id === '') {
      if (cur === null) {
        return
      }
    } else if (cur !== null && id === cur.id) {
      return
    }
    this.gen++
    this.engine.stop()
    if (id !== '') {
      const t = await this.store.thread(id)
      const list = await this.store.messages(id)
      this.thread = t
      this.ctx = []
      this.ctxIds = []
      this.sysPrompt = ''
      let sysIdx = -1
      for (let i = 0; i < list.length; i++) {
        if (this.sysPrompt === '' && list[i].role === ROLE_SYSTEM) {
          this.sysPrompt = list[i].content
          sysIdx = i
          break
        }
      }
      const start = sysIdx + 1
      const cap = Math.max(start, list.length - 18)
      const msgs: MsgDisplay[] = []
      for (let i = start; i < list.length; i++) {
        const m = list[i]
        const d = new MsgDisplay()
        d.id = m.id
        d.isUser = m.role === ROLE_USER
        d.text = m.role === ROLE_USER ? m.content : this.displayText(m)
        msgs.push(d)
        if (i >= cap && (m.flags & 1) === 0 && m.content !== '') {
          this.ctx.push(new ChatMsgIn(m.role, m.content))
          this.ctxIds.push(m.id)
        }
      }
      this.msgs = msgs
      this.busy = false
      this.titleText = t !== null ? (t.name === '' ? this.str('ai_new_topic') : t.name) : this.str('ai_new_topic')
    } else {
      this.sysPrompt = ''
      this.ctx = []
      this.ctxIds = []
      this.thread = null
      const empty: MsgDisplay[] = []
      this.msgs = empty
      this.busy = false
      this.titleText = this.str('ai_new_topic')
    }
    this.v0()
  }

  // ----- e0.M()：清空消息 -----
  private async clearMessages(): Promise<void> {
    const t = this.thread
    if (t === null) {
      return
    }
    await this.store.clearMessages(t.id)
    t.preview = ''
    t.updatedAt = Date.now()
    await this.store.updateThread(t.id, t)
    this.t0(t.id)
    this.w0()
  }

  // ----- e0.N()：删除单条消息 -----
  private async deleteMessage(id: string): Promise<void> {
    await this.store.deleteMessage(id)
    const idx = this.ctxIds.indexOf(id)
    if (idx >= 0) {
      this.ctxIds.splice(idx, 1)
      this.ctx.splice(idx, 1)
    }
    const next: MsgDisplay[] = []
    let removedLast = false
    for (let i = 0; i < this.msgs.length; i++) {
      if (this.msgs[i].id === id) {
        removedLast = i === this.msgs.length - 1
        continue
      }
      next.push(this.msgs[i])
    }
    this.msgs = next
    if (removedLast) {
      const t = this.thread
      if (t !== null) {
        if (next.length === 0) {
          t.preview = ''
        } else {
          t.preview = truncate(next[next.length - 1].text, 200) || ' '
        }
        await this.store.updateThread(t.id, t)
        this.w0()
      }
    }
  }

  // ----- e0.O()/w()：批量删除主题 -----
  private async deleteThreads(ids: string[]): Promise<void> {
    await this.store.deleteThreads(ids)
    const cur = this.thread
    let hitCurrent = false
    for (let i = 0; i < ids.length; i++) {
      if (cur !== null && ids[i] === cur.id) {
        hitCurrent = true
        break
      }
    }
    this.w0()
    if (hitCurrent) {
      this.t0('')
    }
  }

  // ----- e0.n()：导出文本 -----
  private async exportText(): Promise<string> {
    const t = this.thread
    if (t === null) {
      return ''
    }
    const list = await this.store.messages(t.id)
    let sb = ''
    let skippingSystem = true
    for (let i = 0; i < list.length; i++) {
      const m = list[i]
      if (skippingSystem) {
        if (m.role !== ROLE_SYSTEM) {
          skippingSystem = false
        }
      }
      if (m.role === ROLE_USER) {
        sb += `## ${m.content}\n\n`
      } else {
        if (m.reasoning !== '') {
          sb += `> ${m.reasoning}`
        }
        sb += `${m.content}\n\n`
      }
    }
    return sb
  }

  // a2.J3()/K3()/l3()：导出聊天
  private async exportChat(): Promise<void> {
    const t = this.thread
    if (t === null) {
      return
    }
    const content = await this.exportText()
    if (content === '') {
      return
    }
    const name = `${(this.titleText === this.str('ai_new_topic') ? this.str('ai_no_title') : this.titleText)}_${formatFileDate()}.txt`
    try {
      const docPicker = new picker.DocumentViewPicker(this.context())
      const options = new picker.DocumentSaveOptions()
      options.newFileNames = [name]
      options.fileSuffixChoices = ['.txt']
      const uris = await docPicker.save(options)
      if (uris === undefined || uris === null || uris.length === 0) {
        this.toast(this.str('ai_export_ok'))
        return
      }
      const file = fs.openSync(uris[0], fs.OpenMode.WRITE_ONLY | fs.OpenMode.TRUNC)
      fs.writeSync(file.fd, content)
      fs.closeSync(file)
      this.toast(this.context().resourceManager.getStringByNameSync('ai_exported_to', uris[0]))
    } catch (error) {
      this.toast(this.str('ai_export_ok'))
    }
  }

  // a2.H3()：复制全文
  private async copyFull(id: string): Promise<void> {
    const m = await this.store.message(id)
    if (m === null || m.content === '') {
      return
    }
    const data = pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, this.displayText(m))
    pasteboard.getSystemPasteboard().setData(data)
    this.toast(this.str('ai_copied'))
  }

  // a2.M3()：预览
  private async openPreview(id: string): Promise<void> {
    const m = await this.store.message(id)
    if (m === null || m.content === '') {
      return
    }
    let text = ''
    if (m.reasoning === '') {
      text = m.content.trim()
    } else {
      text = `> ${m.reasoning.trim().split('\n').join('\n> ')}\n\n${m.content.trim()}`
    }
    this.previewText = text
    this.previewMarkdown = true
    this.previewVisible = true
    this.swipeEnabled = false
  }

  private closePreview(): void {
    this.previewVisible = false
    this.swipeEnabled = true
  }

  // a2.O3()/x3()：选择模型
  private openModelSelect(): void {
    const list = this.modelList()
    if (list === null || list.length === 0) {
      this.onOpenSettings()
      return
    }
    if (list.length === 1) {
      return
    }
    this.modelSheetVisible = true
  }

  private pickModel(model: string): void {
    this.modelSheetVisible = false
    this.settings.setAiModel(model)
    this.toast(model)
  }

  // ----- r2：多选 -----
  private enterMultiSelect(id: string): void {
    this.multiSelect = true
    this.selectedIds = new Set<string>()
    this.selectedIds.add(id)
    this.w0()
  }

  private exitMultiSelect(): void {
    this.multiSelect = false
    this.selectedIds = new Set<string>()
    this.w0()
  }

  private toggleSelected(id: string): void {
    if (this.selectedIds.has(id)) {
      this.selectedIds.delete(id)
    } else {
      this.selectedIds.add(id)
    }
    if (this.selectedIds.size === 0) {
      this.multiSelect = false
    }
    this.w0()
  }

  private rowClick(t: AiThread): void {
    if (!this.multiSelect) {
      this.t0(t.id)
      this.page = 1
      return
    }
    this.toggleSelected(t.id)
  }

  // r2.s3()：删除确认
  private confirmDeleteSelected(): void {
    const ids: string[] = []
    this.selectedIds.forEach((id: string) => {
      ids.push(id)
    })
    if (ids.length === 0) {
      return
    }
    const rm = this.context().resourceManager
    const message = ids.length === 1
      ? rm.getStringByNameSync('ai_confirm_delete_item', this.selectedName(ids[0]))
      : rm.getStringByNameSync('ai_confirm_delete_items', ids.length)
    AlertDialog.show({
      title: this.str('ai_delete'),
      message: message,
      primaryButton: {
        value: this.str('ai_cancel'),
        action: (): void => {}
      },
      secondaryButton: {
        value: this.str('ai_ok'),
        action: (): void => {
          this.deleteThreads(ids)
          this.multiSelect = false
          this.selectedIds = new Set<string>()
        }
      }
    })
  }

  private selectedName(id: string): string {
    for (let i = 0; i < this.threadRows.length; i++) {
      if (this.threadRows[i].thread.id === id) {
        return this.threadRows[i].thread.name
      }
    }
    return ''
  }

  // a2.G3()：清空消息确认
  private confirmClear(): void {
    AlertDialog.show({
      title: this.str('ai_clear_messages'),
      message: this.str('ai_confirm_clear'),
      primaryButton: {
        value: this.str('ai_cancel'),
        action: (): void => {}
      },
      secondaryButton: {
        value: this.str('ai_ok'),
        action: (): void => {
          this.clearMessages()
        }
      }
    })
  }

  // a2.I3()：删除单条确认
  private confirmDeleteMsg(id: string, preview: string): void {
    const rm = this.context().resourceManager
    AlertDialog.show({
      title: this.str('ai_delete'),
      message: rm.getStringByNameSync('ai_confirm_delete_item', truncate(preview, 50).split('\n').join(' ')),
      primaryButton: {
        value: this.str('ai_cancel'),
        action: (): void => {}
      },
      secondaryButton: {
        value: this.str('ai_ok'),
        action: (): void => {
          this.deleteMessage(id)
        }
      }
    })
  }

  // ----- 返回路由（g.onBackPressed → C0.J(page)）-----
  private panelBack(): boolean {
    if (this.page === 1) {
      if (this.previewVisible) {
        this.closePreview()
        return true
      }
      this.onClose()
      return true
    }
    if (this.page === 0) {
      if (this.multiSelect) {
        this.exitMultiSelect()
        return true
      }
      this.onClose()
      return true
    }
    return false
  }

  private str(name: string): string {
    return this.context().resourceManager.getStringByNameSync(name)
  }

  private context(): Context {
    return this.getUIContext().getHostContext() as Context
  }

  private toast(msg: string): void {
    this.getUIContext().getPromptAction().showToast({ message: msg, duration: 2000 })
  }

  // ================= UI =================

  @Builder
  pageThreads() {
    Column() {
      // 工具栏（r2.C1 linearLayout2）
      Row() {
        if (this.multiSelect) {
          Row() {
            UiaIcon({ icon: $r('app.media.uia_ic_cancel'), iconSize: 24, iconColor: $r('app.color.fg') })
              .onClick(() => {
                this.exitMultiSelect()
              })
          }
          .width(40)
          .height(40)
          .justifyContent(FlexAlign.Center)
        }
        Text(this.multiSelect ? `${this.selectedIds.size}` : this.str('ai_all_topics'))
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
          .layoutWeight(1)
        if (!this.multiSelect) {
          Row() {
            UiaIcon({ icon: $r('app.media.uia_ai_settings'), iconSize: 24, iconColor: $r('app.color.fg') })
              .onClick(() => {
                this.onOpenSettings()
              })
          }
          .width(40)
          .height(40)
          .justifyContent(FlexAlign.Center)
          .margin({ left: 3 })
        }
        Row() {
          if (this.multiSelect) {
            UiaIcon({ icon: $r('app.media.uia_ai_delete'), iconSize: 24, iconColor: $r('app.color.fg') })
              .onClick(() => {
                this.confirmDeleteSelected()
              })
          } else {
            UiaIcon({ icon: $r('app.media.uia_ic_add'), iconSize: 24, iconColor: $r('app.color.fg') })
              .onClick(() => {
                this.t0('')
                this.page = 1
              })
          }
        }
        .width(40)
        .height(40)
        .justifyContent(FlexAlign.Center)
        .margin({ left: 3 })
      }
      .width('100%')
      .padding({ left: 7, right: 7, top: 7, bottom: 7 })
      .alignItems(VerticalAlign.Center)

      // 主题列表（c9.y 行）
      if (this.threadRows.length > 0) {
        List() {
          ForEach(this.threadRows, (row: ThreadDisplay) => {
            ListItem() {
              Row() {
                UiaIcon({ icon: $r('app.media.uia_ai_thread'), iconSize: 20, iconColor: $r('app.color.fg') })
                  .margin({ left: 3, right: 13 })
                Column() {
                  Row() {
                    Text(row.title)
                      .fontSize(14)
                      .fontWeight(FontWeight.Bold)
                      .fontColor($r('app.color.dialog_hint'))
                      .maxLines(1)
                      .textOverflow({ overflow: TextOverflow.Ellipsis })
                      .layoutWeight(1)
                    Text(row.time)
                      .fontSize(11)
                      .fontColor($r('app.color.dialog_hint'))
                      .margin({ left: 8 })
                  }
                  .width('100%')
                  Text(row.preview)
                    .fontSize(12)
                    .fontColor($r('app.color.dialog_hint'))
                    .maxLines(1)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                    .margin({ top: 2 })
                }
                .layoutWeight(1)
                .alignItems(HorizontalAlign.Start)
              }
              .width('100%')
              .padding({ left: 12, right: 16, top: 10, bottom: 10 })
              .alignItems(VerticalAlign.Center)
              .backgroundColor(row.selected ? $r('app.color.divider') : Color.Transparent)
              .onClick(() => {
                this.rowClick(row.thread)
              })
              .gesture(LongPressGesture().onAction(() => {
                if (!this.multiSelect) {
                  this.enterMultiSelect(row.thread.id)
                }
              }))
            }
          }, (row: ThreadDisplay) => `${row.thread.id}_${row.selected}_${row.time}`)
        }
        .width('100%')
        .layoutWeight(1)
        .scrollBar(BarState.Off)
      } else {
        // r3.b()/r3.e()：空态
        Column() {
          Text('¯\\_(ツ)_/¯')
            .fontSize(22)
            .fontColor($r('app.color.dialog_hint'))
        }
        .width('100%')
        .layoutWeight(1)
        .justifyContent(FlexAlign.Center)
      }
    }
    .width('100%')
    .height('100%')
  }

  @Builder
  pageChat() {
    Column() {
      // 工具栏（a2.C1 linearLayout）
      Row() {
        Row() {
          UiaIcon({ icon: $r('app.media.uia_ic_back'), iconSize: 24, iconColor: $r('app.color.fg') })
            .onClick(() => {
              this.page = 0
            })
        }
        .width(40)
        .height(40)
        .justifyContent(FlexAlign.Center)
        Text(this.titleText === '' ? this.str('ai_new_topic') : this.titleText)
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
          .layoutWeight(1)
          .margin({ left: 3, right: 16 })
        Row() {
          UiaIcon({ icon: $r('app.media.uia_ai_overflow'), iconSize: 24, iconColor: $r('app.color.fg') })
            .bindMenu(this.overflowMenu)
        }
        .width(40)
        .height(40)
        .justifyContent(FlexAlign.Center)
        .margin({ left: 3 })
      }
      .width('100%')
      .padding({ left: 7, right: 7, top: 7, bottom: 7 })
      .alignItems(VerticalAlign.Center)

      // 消息列表（a2.f1927n0）
      if (this.msgs.length > 0) {
        List({ scroller: this.scroller }) {
          ForEach(this.msgs, (m: MsgDisplay) => {
            ListItem() {
              if (m.isUser) {
                // c9.g0：用户气泡
                Column() {
                  Text(m.text)
                    .fontSize(14)
                    .fontColor(Color.White)
                    .padding(8)
                    .backgroundColor($r('app.color.accent'))
                    .borderRadius(18)
                    .constraintSize({ maxWidth: '82%' })
                }
                .width('100%')
                .padding({ left: 16, right: 16, top: 8, bottom: 8 })
                .alignItems(HorizontalAlign.End)
              } else {
                // c9.l：助手气泡
                Column() {
                  Text(this.str('ai_assistant').toUpperCase())
                    .fontSize(11)
                    .fontWeight(FontWeight.Bold)
                    .fontColor($r('app.color.dialog_hint'))
                    .margin({ bottom: 4 })
                  Text(m.text)
                    .fontSize(14)
                    .fontColor($r('app.color.fg'))
                    .padding(8)
                    .backgroundColor('#15808080')
                    .borderRadius(18)
                    .constraintSize({ maxWidth: '82%' })
                }
                .width('100%')
                .padding({ left: 16, right: 16, top: 8, bottom: 8 })
                .alignItems(HorizontalAlign.Start)
                .bindContextMenu(this.msgMenu(m), ResponseType.LongPress)
              }
            }
          }, (m: MsgDisplay) => `${m.id}_${m.text.length}`)
        }
        .width('100%')
        .layoutWeight(1)
        .scrollBar(BarState.Off)
        .padding({ bottom: 4 })
      } else {
        // a2.f1934u0 + r3.e()：空态
        Column() {
          Text('¯\\_(ツ)_/¯')
            .fontSize(22)
            .fontColor($r('app.color.dialog_hint'))
        }
        .width('100%')
        .layoutWeight(1)
        .justifyContent(FlexAlign.Center)
      }

      // chips 行（a2.f1929p0）
      if (this.chips.length > 0) {
        Scroll() {
          Row({ space: 4 }) {
            ForEach(this.chips, (c: ChipDisplay) => {
              Text(c.label)
                .fontSize(12)
                .fontColor(c.selected ? $r('app.color.accent') : $r('app.color.fg'))
                .maxLines(1)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
                .constraintSize({ maxWidth: 96 })
                .padding({ left: 12, right: 12, top: 6, bottom: 6 })
                .borderRadius(18)
                .border({ width: 1, color: c.selected ? $r('app.color.accent') : $r('app.color.divider') })
                .onClick(() => {
                  if (!c.selected) {
                    this.selectChip(c.id)
                  }
                })
            }, (c: ChipDisplay) => `${c.id}_${c.selected}`)
          }
          .padding({ left: 12, right: 12, top: 8, bottom: 8 })
        }
        .scrollable(ScrollDirection.Horizontal)
        .scrollBar(BarState.Off)
        .width('100%')
      }

      // 附件 chip（c9.e）
      if (this.attachment !== null) {
        Scroll() {
          Row() {
            Row({ space: 4 }) {
              UiaIcon({ icon: $r('app.media.uia_ic_webpage'), iconSize: 16, iconColor: $r('app.color.fg') })
              Text(this.attachment.title === '' ? this.attachment.url : this.attachment.title)
                .fontSize(12)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
                .constraintSize({ minWidth: 0, maxWidth: 120 })
              UiaIcon({ icon: $r('app.media.uia_ic_cancel'), iconSize: 16, iconColor: $r('app.color.fg') })
                .onClick(() => {
                  this.attachment = null
                  this.v0()
                })
            }
            .padding({ left: 8, right: 8, top: 6, bottom: 6 })
            .borderRadius(18)
            .border({ width: 1, color: $r('app.color.divider') })
          }
          .padding({ left: 12, right: 12 })
        }
        .scrollable(ScrollDirection.Horizontal)
        .scrollBar(BarState.Off)
        .width('100%')
      }

      // 输入行（a2.f1931r0/f1932s0）
      Row() {
        TextArea({ text: this.input, placeholder: this.str('ai_messages'), controller: this.inputController })
          .layoutWeight(1)
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.dialog_hint'))
          .placeholderFont({ size: 14 })
          .maxLines(5)
          .padding({ left: 12, right: 12, top: 9, bottom: 9 })
          .backgroundColor(Color.Transparent)
          .border({ width: 0 })
          .onChange((value: string) => {
            this.input = value
            this.sendVisible = value !== '' || this.busy
          })
          .onFocus(() => {
            this.inputFocused = true
            this.sendVisible = true
          })
          .onBlur(() => {
            this.inputFocused = false
            if (!this.busy && this.input === '') {
              this.sendVisible = false
            }
          })
        if (this.sendVisible || this.busy) {
          if (this.busy) {
            // S3(true)：停止
            Row() {
              UiaIcon({ icon: $r('app.media.uia_ic_stop'), iconSize: 20, iconColor: Color.White })
            }
            .width(32)
            .height(32)
            .borderRadius(16)
            .backgroundColor($r('app.color.danger'))
            .justifyContent(FlexAlign.Center)
            .margin({ left: 6, right: 6, top: 4, bottom: 4 })
            .onClick(() => {
              this.engine.stop()
            })
          } else {
            // S3(false)：发送
            Row() {
              UiaIcon({ icon: $r('app.media.uia_ai_send'), iconSize: 20, iconColor: Color.White })
            }
            .width(32)
            .height(32)
            .borderRadius(16)
            .backgroundColor(this.input === '' ? $r('app.color.divider') : $r('app.color.accent'))
            .justifyContent(FlexAlign.Center)
            .margin({ left: 6, right: 6, top: 4, bottom: 4 })
            .onClick(() => {
              this.send()
            })
          }
        }
      }
      .width('100%')
      .padding({ left: 8, right: 8 })
      .margin({ bottom: 16 })
      .borderRadius(18)
      .border({ width: 2, color: $r('app.color.divider') })
      .alignItems(VerticalAlign.Center)
    }
    .width('100%')
    .height('100%')
  }

  // a2.N3()：溢出菜单
  @Builder
  overflowMenu() {
    Menu() {
      if (this.msgs.length > 0) {
        MenuItem({
          content: this.msgs.length > 0 ? this.currentModel() : this.str('ai_select_model')
        })
          .contentFont({ size: 14 })
          .onClick(() => {
            this.openModelSelect()
          })
        MenuItem({ content: this.str('ai_export_chat') })
          .contentFont({ size: 14 })
          .onClick(() => {
            this.exportChat()
          })
        MenuItem({ content: this.str('ai_clear_messages') })
          .contentFont({ size: 14 })
          .onClick(() => {
            this.confirmClear()
          })
      } else {
        MenuItem({ content: this.str('ai_select_model') })
          .contentFont({ size: 14 })
          .onClick(() => {
            this.openModelSelect()
          })
      }
    }
  }

  // a2.P3()：消息长按菜单
  @Builder
  msgMenu(m: MsgDisplay) {
    Menu() {
      MenuItem({ content: this.str('ai_copy_full') })
        .contentFont({ size: 14 })
        .onClick(() => {
          this.copyFull(m.id)
        })
      MenuItem({ content: this.str('ai_preview') })
        .contentFont({ size: 14 })
        .onClick(() => {
          this.openPreview(m.id)
        })
      MenuItem({ content: this.str('ai_delete') })
        .contentFont({ size: 14 })
        .onClick(() => {
          this.confirmDeleteMsg(m.id, m.text)
        })
    }
  }

  // q0：消息预览覆盖层
  @Builder
  previewLayer() {
    Column() {
      Row() {
        Row() {
          UiaIcon({ icon: $r('app.media.uia_ic_back'), iconSize: 24, iconColor: $r('app.color.fg') })
            .onClick(() => {
              this.closePreview()
            })
        }
        .width(40)
        .height(40)
        .justifyContent(FlexAlign.Center)
        Text(this.str('ai_messages'))
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
          .layoutWeight(1)
          .margin({ left: 3 })
        Row() {
          if (this.previewMarkdown) {
            Text(this.str('ai_plain_text'))
              .fontSize(14)
              .fontColor($r('app.color.fg'))
              .onClick(() => {
                this.previewMarkdown = false
              })
          } else {
            Text(this.str('ai_markdown'))
              .fontSize(14)
              .fontColor($r('app.color.fg'))
              .onClick(() => {
                this.previewMarkdown = true
              })
          }
        }
        .height(40)
        .justifyContent(FlexAlign.Center)
        .padding({ left: 8, right: 8 })
      }
      .width('100%')
      .padding({ left: 7, right: 7, top: 7, bottom: 7 })
      .alignItems(VerticalAlign.Center)
      Scroll() {
        Text(this.previewText)
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .textSelectable(TextSelectableMode.SELECTABLE_FOCUSABLE)
          .width('100%')
          .padding(16)
      }
      .align(Alignment.Top)
      .layoutWeight(1)
      .scrollBar(BarState.Off)
    }
    .width('100%')
    .height('100%')
    .backgroundColor($r('app.color.page_bg'))
  }

  build() {
    Stack() {
      // b9.g：ViewPager2 两页
      Swiper() {
        this.pageThreads()
        this.pageChat()
      }
      .index($$this.page)
      .indicator(false)
      .loop(false)
      .disableSwipe(!this.swipeEnabled)
      .width('100%')
      .height('100%')

      // q0 预览覆盖层
      if (this.previewVisible) {
        this.previewLayer()
      }

      // a2.O3()：选择模型（单选列表对话框）
      if (this.modelSheetVisible) {
        Column() {
          // 遮罩
          Column()
            .width('100%')
            .height('100%')
            .backgroundColor('#66000000')
            .onClick(() => {
              this.modelSheetVisible = false
            })
        }
        .width('100%')
        .height('100%')
        .position({ x: 0, y: 0 })

        Column() {
          Text(this.str('ai_select_model'))
            .fontSize(16)
            .fontWeight(FontWeight.Bold)
            .fontColor($r('app.color.fg'))
            .margin({ bottom: 8 })
          ForEach(this.modelList(), (model: string) => {
            Row() {
              Text(model)
                .fontSize(14)
                .fontColor($r('app.color.fg'))
                .layoutWeight(1)
              if (model === this.settings.aiModel) {
                UiaIcon({ icon: $r('app.media.uia_ai_settings'), iconSize: 0, iconColor: Color.Transparent })
                Radio({ value: model, group: 'ai_model' })
                  .checked(model === this.settings.aiModel)
                  .radioStyle({ checkedBackgroundColor: $r('app.color.accent') })
              } else {
                Radio({ value: model, group: 'ai_model' })
                  .checked(false)
                  .radioStyle({ checkedBackgroundColor: $r('app.color.accent') })
              }
            }
            .width('100%')
            .padding({ top: 10, bottom: 10 })
            .onClick(() => {
              this.pickModel(model)
            })
          }, (model: string) => model)
        }
        .width('100%')
        .padding(16)
        .borderRadius(18)
        .backgroundColor($r('app.color.dialog_bg'))
        .alignItems(HorizontalAlign.Center)
      }
    }
    .width('100%')
    .height('100%')
    .backgroundColor($r('app.color.page_bg'))
  }
}
