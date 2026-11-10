import { preferences } from '@kit.ArkData'
import { BusinessError } from '@kit.BasicServicesKit'
import { AppContextHolder } from './Reader'

// 原版 na.f：关闭标签条目（c()=id / f()=url / e()=title / d()=时间毫秒）
export class ClosedTabEntry {
  id: string
  url: string
  title: string
  time: number

  constructor(id: string, url: string, title: string, time: number) {
    this.id = id
    this.url = url
    this.title = title
    this.time = time
  }

  static fromJson(obj: Record<string, Object>): ClosedTabEntry | null {
    const id = obj['id']
    const url = obj['url']
    if (typeof id === 'string' && id !== '' && typeof url === 'string') {
      const entry = new ClosedTabEntry(id, url, '', 0)
      const title = obj['title']
      const time = obj['time']
      if (typeof title === 'string') {
        entry.title = title
      }
      if (typeof time === 'number') {
        entry.time = time
      }
      return entry
    }
    return null
  }
}

// 批量关闭信息（原版 na i8/j8 → R：撤销 snackbar 数据源，w.d(urls, w.d(selected, title)) 等价）
export class ClosedBatchResult {
  urls: string[]
  titles: string[]
  // 撤销重建后选中的标签（批量中最后关闭的当前页，对齐 na.i8 选中回退）
  selectedIndex: number

  constructor(urls: string[], titles: string[], selectedIndex: number) {
    this.urls = urls
    this.titles = titles
    this.selectedIndex = selectedIndex
  }

  count(): number {
    return this.urls.length
  }
}

// 单个关闭信息（原版 na.M/f0：撤销 snackbar「已关闭 %1$s」+ F1 按 id 撤销）
export class ClosedSingleResult {
  url: string
  title: string
  entryId: string

  constructor(url: string, title: string, entryId: string) {
    this.url = url
    this.title = title
    this.entryId = entryId
  }
}

// TabPanel「+」长按打开「关闭的标签页」页（原版 f8.l0 + 按钮 longClick → b.f() → k6.ia()）。
// TabPanel 无 NavPathStack，经 emitter 由 Index 监听 openPage（需主控接线）。
// 10005 已被 EXIT_CLEAR_EVENT_ID 占用，取 10006
export const OPEN_CLOSED_TABS_EVENT_ID: number = 10006

const PREF_NAME: string = 'uia_closed_tabs'
const KEY_ENTRIES: string = 'entries'
// 异常退出标记（原版 na.e.d：RESTORED_TABS 崩溃快照存在检测的等价实现）。
// EntryAbility 退出时 markCleanQuit() 写 true；TabStore.init 读取后置回 false——
// 下次启动读到 false 即判定异常退出，强制恢复快照（不受 restoreTabsMode 约束）
const KEY_QUIT_FLAG_WRITTEN: string = 'quitFlagWritten'
const KEY_LAST_QUIT_CLEAN: string = 'lastQuitClean'

// 关闭标签持久库（原版 na.h/na.a + na.i DB 的鸿蒙等价：preferences 持久化 JSON 数组）。
// na.a.c 语义：同 URL 旧条目先移除再入新条目；g() 返回全量，ic 页按时间倒序展示
@ObservedV2
export class ClosedTabsStore {
  private static instance: ClosedTabsStore | null = null
  @Trace entries: ClosedTabEntry[] = []
  private store: preferences.Preferences | null = null
  private seq: number = 0

  private constructor() {
  }

  static getInstance(): ClosedTabsStore {
    if (ClosedTabsStore.instance === null) {
      ClosedTabsStore.instance = new ClosedTabsStore()
    }
    return ClosedTabsStore.instance
  }

  async init(context: Context): Promise<void> {
    if (this.store !== null) {
      return
    }
    try {
      this.store = await preferences.getPreferences(context, PREF_NAME)
      const raw = await this.store.get(KEY_ENTRIES, '[]')
      this.entries = this.parseEntries(typeof raw === 'string' ? raw : '[]')
    } catch (error) {
      const err = error as BusinessError
      console.error(`closed tabs init failed: ${err.code} ${err.message}`)
    }
  }

  // 无调用方上下文时自举（EntryAbility.onCreate 已 initReaderContext 注入）
  async ensureInit(): Promise<void> {
    if (this.store !== null) {
      return
    }
    const context = AppContextHolder.getContext()
    if (context !== null) {
      await this.init(context)
    }
  }

  private parseEntries(raw: string): ClosedTabEntry[] {
    const result: ClosedTabEntry[] = []
    try {
      const parsed = JSON.parse(raw) as Object[]
      for (let i = 0; i < parsed.length; i++) {
        const entry = ClosedTabEntry.fromJson(parsed[i] as Record<string, Object>)
        if (entry !== null) {
          result.push(entry)
        }
      }
    } catch (error) {
      console.error('parse closed tabs failed')
    }
    return result
  }

  private persist(): void {
    if (this.store === null) {
      return
    }
    const payload: Record<string, Object>[] = []
    for (let i = 0; i < this.entries.length; i++) {
      const entry: Record<string, Object> = {}
      entry['id'] = this.entries[i].id
      entry['url'] = this.entries[i].url
      entry['title'] = this.entries[i].title
      entry['time'] = this.entries[i].time
      payload.push(entry)
    }
    this.store.put(KEY_ENTRIES, JSON.stringify(payload)).catch((error: BusinessError) => {
      console.error(`closed tabs put failed: ${error.message}`)
    })
    this.store.flush().catch((error: BusinessError) => {
      console.error(`closed tabs flush failed: ${error.message}`)
    })
  }

  private nextId(): string {
    this.seq = this.seq + 1
    return `t${Date.now()}_${this.seq}`
  }

  // na.h.c(fVar)/d(list)：入库（同 URL 旧条目先移除）；批量由 TabStore 逐条调用；
  // 隐身/主页/空 URL 由调用方过滤
  add(url: string, title: string): ClosedTabEntry | null {
    if (url === '') {
      return null
    }
    for (let i = this.entries.length - 1; i >= 0; i--) {
      if (this.entries[i].url === url) {
        this.entries.splice(i, 1)
      }
    }
    const entry = new ClosedTabEntry(this.nextId(), url, title, Date.now())
    this.entries.push(entry)
    this.persist()
    return entry
  }

  // na.h.i(list)/a(str)：按 id 删除（撤销恢复、ic 页单删共用）
  removeByIds(ids: string[]): void {
    if (ids.length === 0) {
      return
    }
    let changed = false
    for (let i = this.entries.length - 1; i >= 0; i--) {
      if (ids.indexOf(this.entries[i].id) >= 0) {
        this.entries.splice(i, 1)
        changed = true
      }
    }
    if (changed) {
      this.persist()
    }
  }

  // na.h.h()：清空
  clear(): void {
    this.entries = []
    this.persist()
  }

  // na.h.b(str, limit)：url/title 模糊搜索（ic 页搜索框）
  search(query: string, limit: number): ClosedTabEntry[] {
    const keyword = query.trim().toLowerCase()
    const result: ClosedTabEntry[] = []
    if (keyword === '') {
      for (let i = this.entries.length - 1; i >= 0 && result.length < limit; i--) {
        result.push(this.entries[i])
      }
      return result
    }
    for (let i = this.entries.length - 1; i >= 0 && result.length < limit; i--) {
      const entry = this.entries[i]
      if (entry.url.toLowerCase().includes(keyword) || entry.title.toLowerCase().includes(keyword)) {
        result.push(entry)
      }
    }
    return result
  }

  // na.e.d(context)：崩溃标记读取；written=false 表示 EntryAbility 尚未接线（保持原行为）
  async readQuitFlags(): Promise<boolean[]> {
    if (this.store === null) {
      return [false, false]
    }
    try {
      const written = await this.store.get(KEY_QUIT_FLAG_WRITTEN, false)
      const clean = await this.store.get(KEY_LAST_QUIT_CLEAN, false)
      return [typeof written === 'boolean' && written, typeof clean === 'boolean' && clean]
    } catch (error) {
      const err = error as BusinessError
      console.error(`read quit flags failed: ${err.code} ${err.message}`)
      return [false, false]
    }
  }

  // 消费标记：读取后置回 false（本次会话视为未正常退出，直到下次 markCleanQuit）
  async consumeQuitFlags(): Promise<boolean[]> {
    const flags = await this.readQuitFlags()
    if (this.store !== null && flags[0]) {
      this.store.put(KEY_LAST_QUIT_CLEAN, false).catch((error: BusinessError) => {
        console.error(`reset quit flag failed: ${error.message}`)
      })
      this.store.flush().catch((error: BusinessError) => {
        console.error(`reset quit flag flush failed: ${error.message}`)
      })
    }
    return flags
  }

  // EntryAbility.onWindowStageDestroy 接线点：正常退出写 true（需主控接线）
  async markCleanQuit(): Promise<void> {
    await this.ensureInit()
    if (this.store === null) {
      return
    }
    try {
      await this.store.put(KEY_QUIT_FLAG_WRITTEN, true)
      await this.store.put(KEY_LAST_QUIT_CLEAN, true)
      await this.store.flush()
    } catch (error) {
      const err = error as BusinessError
      console.error(`mark clean quit failed: ${err.code} ${err.message}`)
    }
  }
}
