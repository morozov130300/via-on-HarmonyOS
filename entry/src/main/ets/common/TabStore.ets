import { TabItem } from './Types'
import { AppSettings, SavedTab } from './Settings'
import { emitter } from '@kit.BasicServicesKit'

const BLANK_URL: string = 'about:blank'
// 主页模式=书签：新标签打开书签页（原版 via://bookmark）
export const OPEN_BOOKMARKS_EVENT_ID: number = 10004

@ObservedV2
export class TabStore {
  private static instance: TabStore | null = null
  @Trace tabs: TabItem[] = []
  @Trace currentIndex: number = 0
  // 原版隐身为全局会话模型（k6.cb()/n0.m2().s()）：true 时菜单显示「退出隐身浏览」
  @Trace sessionIncognito: boolean = false
  private nextTabId: number = 1

  private constructor() {
    this.tabs.push(new TabItem(this.nextTabId, false))
    this.nextTabId = this.nextTabId + 1
    this.currentIndex = 0
  }

  static getInstance(): TabStore {
    if (TabStore.instance === null) {
      TabStore.instance = new TabStore()
    }
    return TabStore.instance
  }

  async init(settings: AppSettings): Promise<void> {
    // 原版三态：0 禁用 / 1 总是恢复 / 2 优先询问（restoreclosedtabs，默认 0）
    if (settings.restoreTabsMode === 2) {
      const saved = await settings.readTabsSnapshot()
      if (saved.length > 0) {
        AppStorage.setOrCreate('via_pending_restore_tabs', JSON.stringify(saved))
        AppStorage.setOrCreate('via_pending_restore_index', await settings.readTabsSnapshotIndex())
      }
      return
    }
    if (settings.restoreTabsMode !== 1) {
      return
    }
    const saved = await settings.readTabsSnapshot()
    if (saved.length === 0) {
      return
    }
    this.restoreSaved(saved, await settings.readTabsSnapshotIndex())
  }

  // 原版 k6.ia()：restore_tabs 数组重建标签列表并选中 selected 项（快照已含 title）
  restoreSaved(saved: SavedTab[], savedIndex: number): void {    const tabs: TabItem[] = []
    for (let i = 0; i < saved.length; i++) {
      const entry = saved[i]
      const tab = new TabItem(this.nextTabId, false)
      this.nextTabId = this.nextTabId + 1
      if (entry.url !== '') {
        tab.initialUrl = entry.url
        tab.url = entry.url
      }
      tab.title = entry.title
      tabs.push(tab)
    }
    if (tabs.length === 0) {
      return
    }
    this.tabs = tabs
    let index = savedIndex
    if (index < 0 || index >= tabs.length) {
      index = 0
    }
    this.currentIndex = index
  }

  async restoreFromSnapshot(settings: AppSettings): Promise<void> {
    const saved = await settings.readTabsSnapshot()
    if (saved.length === 0) {
      return
    }
    this.restoreSaved(saved, await settings.readTabsSnapshotIndex())
  }

  // 备份导入（m9/l tabs.txt）：追加导入标签，按 url 与现有标签去重，不切换当前页
  restoreBackupTabs(saved: SavedTab[]): void {
    for (let i = 0; i < saved.length; i++) {
      const entry = saved[i]
      if (entry.url === '') {
        continue
      }
      let dup = false
      for (let j = 0; j < this.tabs.length; j++) {
        if (this.tabs[j].url === entry.url) {
          dup = true
          break
        }
      }
      if (dup) {
        continue
      }
      const tab = new TabItem(this.nextTabId, false)
      this.nextTabId = this.nextTabId + 1
      tab.initialUrl = entry.url
      tab.url = entry.url
      tab.title = entry.title
      this.tabs.push(tab)
    }
    this.snapshot(AppSettings.getInstance())
  }

  // 原版 c8/na.F1（k6.u 8682：v://tabs/restore?ids=&selected=）：按 id 恢复标签并选中
  // selected 指定项；仅恢复存在的 id，找不到的忽略。
  // 本工程标签数字 id 仅存在于内存存活标签（快照 SavedTab 无 id 字段），
  // 故语义为：命中现有标签则选中，全部缺失时不动作
  restoreByIds(ids: string[], selected: string): void {
    if (ids.length === 0) {
      return
    }
    const matched: TabItem[] = []
    for (let i = 0; i < this.tabs.length; i++) {
      if (ids.indexOf(String(this.tabs[i].id)) >= 0) {
        matched.push(this.tabs[i])
      }
    }
    if (matched.length === 0) {
      return
    }
    // 原版 F1：selected 匹配不到时选末位
    let selectIdx = matched.length - 1
    if (selected !== '') {
      for (let i = 0; i < matched.length; i++) {
        if (String(matched[i].id) === selected) {
          selectIdx = i
          break
        }
      }
    }
    const target = matched[selectIdx]
    for (let i = 0; i < this.tabs.length; i++) {
      if (this.tabs[i].id === target.id) {
        this.currentIndex = i
        break
      }
    }
    this.snapshot(AppSettings.getInstance())
  }

  current(): TabItem {
    return this.tabs[this.currentIndex]
  }

  newTab(incognito: boolean): boolean {
    const tab = new TabItem(this.nextTabId, incognito)
    this.nextTabId = this.nextTabId + 1
    const settings = AppSettings.getInstance()
    if (!incognito) {
      // 原版 hb/c4 主页四选：0=主页 1=自定义 2=空白页 3=书签
      if (settings.homepageMode === 1 && settings.homeUrl !== '') {
        tab.initialUrl = settings.homeUrl
        tab.url = settings.homeUrl
      } else if (settings.homepageMode === 2) {
        tab.initialUrl = 'about:blank'
        tab.url = 'about:blank'
      } else if (settings.homepageMode === 3) {
        emitter.emit({ eventId: OPEN_BOOKMARKS_EVENT_ID, priority: emitter.EventPriority.HIGH })
      }
    }
    this.tabs.push(tab)
    this.currentIndex = this.tabs.length - 1
    return true
  }

  newTabAt(url: string, background: boolean): boolean {
    const tab = new TabItem(this.nextTabId, false)
    this.nextTabId = this.nextTabId + 1
    tab.initialUrl = url
    tab.url = url
    this.tabs.push(tab)
    if (!background) {
      this.currentIndex = this.tabs.length - 1
    }
    return true
  }

  // 原版 o4/c.b(i10)：关闭当前标签时先选前一个（i11>0 ? i11-1 : 有后继则后继），再删除
  closeTab(index: number): string {
    if (index < 0 || index >= this.tabs.length) {
      return ''
    }
    const closed = this.tabs[index]
    const closedUrl = !closed.incognito && !closed.isHomePage() ? closed.url : ''
    const wasCurrent = index === this.currentIndex
    this.tabs.splice(index, 1)
    if (this.tabs.length === 0) {
      const tab = new TabItem(this.nextTabId, false)
      this.nextTabId = this.nextTabId + 1
      this.tabs.push(tab)
      this.currentIndex = 0
      this.snapshot(AppSettings.getInstance())
      return closedUrl
    }
    if (wasCurrent) {
      // 原版 j(i11>0 ? i11-1 : (i11<size-1 ? i11+1 : -1))：选中前一个，首个则选中后继
      this.currentIndex = index > 0 ? index - 1 : 0
    } else if (index < this.currentIndex) {
      this.currentIndex = this.currentIndex - 1
    }
    this.snapshot(AppSettings.getInstance())
    return closedUrl
  }

  closeOthers(index: number): void {
    if (index < 0 || index >= this.tabs.length) {
      return
    }
    const kept = this.tabs[index]
    const next: TabItem[] = [kept]
    this.tabs = next
    this.currentIndex = 0
  }

  // 原版 k6.j8：关闭所有标签页删除全部，随后留空白新页
  closeAll(): void {
    this.tabs = []
    const tab = new TabItem(this.nextTabId, false)
    this.nextTabId = this.nextTabId + 1
    this.tabs.push(tab)
    this.currentIndex = 0
  }

  closeAbove(index: number): void {
    if (index <= 0 || index >= this.tabs.length) {
      return
    }
    this.tabs = this.tabs.slice(index)
    this.currentIndex = this.currentIndex >= index ? this.currentIndex - index : 0
  }

  closeBelow(index: number): void {
    if (index < 0 || index >= this.tabs.length - 1) {
      return
    }
    this.tabs = this.tabs.slice(0, index + 1)
    if (this.currentIndex > index) {
      this.currentIndex = index
    }
  }

  duplicateTab(index: number): void {
    if (index < 0 || index >= this.tabs.length) {
      return
    }
    const src = this.tabs[index]
    const copy = new TabItem(this.nextTabId, src.incognito)
    this.nextTabId = this.nextTabId + 1
    copy.url = src.url
    copy.title = src.title
    this.tabs.splice(index + 1, 0, copy)
  }

  switchTo(index: number): void {
    if (index < 0 || index >= this.tabs.length) {
      return
    }
    if (this.currentIndex === index) {
      return
    }
    this.currentIndex = index
    this.snapshot(AppSettings.getInstance())
  }

  stepTab(delta: number): void {
    const target = this.currentIndex + delta
    if (target < 0 || target >= this.tabs.length) {
      return
    }
    this.currentIndex = target
  }

  // 原版 k6.d9()+ia()：新建后台标签，不切换当前页
  newTabBackground(incognito: boolean): void {
    const tab = new TabItem(this.nextTabId, incognito)
    this.nextTabId = this.nextTabId + 1
    this.tabs.push(tab)
  }

  // 原版 o4/c.p(from,to)：拖拽重排；仅被拖的是当前标签时 current 才跟随到 to
  moveTab(from: number, to: number): void {
    if (from < 0 || from >= this.tabs.length || to < 0 || to >= this.tabs.length || from === to) {
      return
    }
    const currentId = this.tabs[this.currentIndex].id
    const moved = this.tabs.splice(from, 1)[0]
    this.tabs.splice(to, 0, moved)
    for (let i = 0; i < this.tabs.length; i++) {
      if (this.tabs[i].id === currentId) {
        this.currentIndex = i
        break
      }
    }
    this.snapshot(AppSettings.getInstance())
  }

  gotoHome(): void {
    const settings = AppSettings.getInstance()
    if (settings.homepageMode === 1 && settings.homeUrl !== '') {
      this.navigate(settings.homeUrl)
      return
    }
    const tab = this.current()
    tab.isError = false
    tab.errorDesc = ''
    tab.initialUrl = ''
    try {
      tab.controller.loadUrl(BLANK_URL)
    } catch (error) {
      const err = error as BusinessError
      console.error(`gotoHome loadUrl failed: ${err.code} ${err.message}`)
    }
  }

  navigate(url: string): void {
    const tab = this.current()
    tab.isError = false
    tab.errorDesc = ''
    tab.initialUrl = ''
    try {
      const settings = AppSettings.getInstance()
      if (settings.dataSaver) {
        tab.controller.loadUrl(url, [{ headerKey: 'Save-Data', headerValue: 'on' }])
      } else {
        tab.controller.loadUrl(url)
      }
    } catch (error) {
      const err = error as BusinessError
      console.error(`navigate loadUrl failed: ${err.code} ${err.message}`)
    }
  }

  // 原版快照含 url/title/selected（ic.java D1()），隐身标签不入快照
  snapshot(settings: AppSettings): void {
    const saved: SavedTab[] = []
    let activeIndex = 0
    const current = this.tabs[this.currentIndex]
    for (let i = 0; i < this.tabs.length; i++) {
      const tab = this.tabs[i]
      if (tab.incognito) {
        continue
      }
      if (i === this.currentIndex) {
        activeIndex = saved.length
      }
      if (tab.isHomePage()) {
        saved.push(new SavedTab('', false, ''))
      } else {
        saved.push(new SavedTab(tab.url, false, tab.title))
      }
    }
    // 原版隐身会话不入快照：当前为隐身标签时选中位置记为首个普通标签后的位置，恢复时收敛
    if (current !== undefined && current.incognito) {
      activeIndex = saved.length
    }
    settings.saveTabsSnapshot(saved, activeIndex)
  }

  // 原版 p4/c.java:55 onCreateWindow：新窗口即新标签，返回待绑定的 TabItem
  openWindowTab(): TabItem {
    const current = this.tabs[this.currentIndex]
    const tab = new TabItem(this.nextTabId, current !== undefined ? current.incognito : false)
    this.nextTabId = this.nextTabId + 1
    this.tabs.push(tab)
    this.currentIndex = this.tabs.length - 1
    return tab
  }

  incognitoTabCount(): number {
    let count = 0
    for (let i = 0; i < this.tabs.length; i++) {
      if (this.tabs[i].incognito) {
        count = count + 1
      }
    }
    return count
  }

  // 原版 k6.l8(false)：关闭全部隐身标签，无普通标签时补空白页，退出隐身会话
  exitIncognitoSession(closeAll: boolean): void {
    if (closeAll) {
      const kept: TabItem[] = []
      for (let i = 0; i < this.tabs.length; i++) {
        if (!this.tabs[i].incognito) {
          kept.push(this.tabs[i])
        }
      }
      if (kept.length === 0) {
        kept.push(new TabItem(this.nextTabId, false))
        this.nextTabId = this.nextTabId + 1
      }
      this.tabs = kept
      if (this.currentIndex >= kept.length) {
        this.currentIndex = kept.length - 1
      }
    }
    this.sessionIncognito = false
    this.snapshot(AppSettings.getInstance())
  }
}
