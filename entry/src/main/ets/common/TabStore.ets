import { TabItem } from './Types'
import { AppSettings, SavedTab } from './Settings'

const MAX_TABS: number = 24
const BLANK_URL: string = 'about:blank'

@ObservedV2
export class TabStore {
  private static instance: TabStore | null = null
  @Trace tabs: TabItem[] = []
  @Trace currentIndex: number = 0
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
    if (!settings.restoreTabs) {
      return
    }
    const saved = await settings.readTabsSnapshot()
    if (saved.length === 0) {
      return
    }
    const restored: TabItem[] = []
    for (let i = 0; i < saved.length; i++) {
      const tab = new TabItem(this.nextTabId, saved[i].incognito)
      this.nextTabId = this.nextTabId + 1
      tab.initialUrl = saved[i].url
      tab.url = saved[i].url
      restored.push(tab)
    }
    this.tabs = restored
    const savedIndex = await settings.readTabsSnapshotIndex()
    if (savedIndex >= 0 && savedIndex < restored.length) {
      this.currentIndex = savedIndex
    } else {
      this.currentIndex = 0
    }
  }

  current(): TabItem {
    return this.tabs[this.currentIndex]
  }

  newTab(incognito: boolean): boolean {
    if (this.tabs.length >= MAX_TABS) {
      return false
    }
    const tab = new TabItem(this.nextTabId, incognito)
    this.nextTabId = this.nextTabId + 1
    this.tabs.push(tab)
    this.currentIndex = this.tabs.length - 1
    return true
  }

  closeTab(index: number): void {
    if (index < 0 || index >= this.tabs.length) {
      return
    }
    this.tabs.splice(index, 1)
    if (this.tabs.length === 0) {
      const tab = new TabItem(this.nextTabId, false)
      this.nextTabId = this.nextTabId + 1
      this.tabs.push(tab)
      this.currentIndex = 0
      return
    }
    if (index < this.currentIndex) {
      this.currentIndex = this.currentIndex - 1
    } else if (index === this.currentIndex) {
      if (this.currentIndex >= this.tabs.length) {
        this.currentIndex = this.tabs.length - 1
      }
    }
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

  switchTo(index: number): void {
    if (index < 0 || index >= this.tabs.length) {
      return
    }
    this.currentIndex = index
  }

  stepTab(delta: number): void {
    const target = this.currentIndex + delta
    if (target < 0 || target >= this.tabs.length) {
      return
    }
    this.currentIndex = target
  }

  gotoHome(): void {
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
      tab.controller.loadUrl(url)
    } catch (error) {
      const err = error as BusinessError
      console.error(`navigate loadUrl failed: ${err.code} ${err.message}`)
    }
  }

  snapshot(settings: AppSettings): void {
    const saved: SavedTab[] = []
    let activeIndex = 0
    for (let i = 0; i < this.tabs.length; i++) {
      const tab = this.tabs[i]
      if (tab.incognito) {
        continue
      }
      if (i === this.currentIndex) {
        activeIndex = saved.length
      }
      if (tab.isHomePage()) {
        saved.push(new SavedTab('', false))
      } else {
        saved.push(new SavedTab(tab.url, false))
      }
    }
    settings.saveTabsSnapshot(saved, activeIndex)
  }
}
