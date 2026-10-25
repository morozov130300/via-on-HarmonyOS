import { BrowserDb } from './Database'
import { AppSettings } from './Settings'
import { BookmarkRec, HistoryRec } from './Types'

export class BackupManager {
  private static instance: BackupManager | null = null

  static getInstance(): BackupManager {
    if (BackupManager.instance === null) {
      BackupManager.instance = new BackupManager()
    }
    return BackupManager.instance
  }

  async buildBackupJson(): Promise<string> {
    const db = BrowserDb.getInstance()
    const bookmarks = await db.listBookmarks()
    const history = await db.listHistory()
    const bookmarkPayload: Record<string, Object>[] = []
    for (let i = 0; i < bookmarks.length; i++) {
      const item = bookmarks[i]
      const entry: Record<string, Object> = {}
      entry['title'] = item.title
      entry['url'] = item.url
      entry['created'] = item.created
      bookmarkPayload.push(entry)
    }
    const historyPayload: Record<string, Object>[] = []
    for (let i = 0; i < history.length; i++) {
      const item = history[i]
      const entry: Record<string, Object> = {}
      entry['title'] = item.title
      entry['url'] = item.url
      entry['visited'] = item.visited
      historyPayload.push(entry)
    }
    const settings = AppSettings.getInstance()
    const kv: Record<string, Object> = await settings.buildSyncKv()
    const backup: Record<string, Object> = {}
    backup['version'] = 1
    backup['ts'] = Date.now()
    backup['bookmarks'] = bookmarkPayload
    backup['history'] = historyPayload
    backup['settings'] = kv
    return JSON.stringify(backup)
  }

  async applyBackupJson(raw: string): Promise<void> {
    const parsed = JSON.parse(raw) as Record<string, Object>
    const db = BrowserDb.getInstance()
    const bookmarkRaw = parsed['bookmarks']
    if (Array.isArray(bookmarkRaw)) {
      await db.clearBookmarks()
      const items = bookmarkRaw as Object[]
      for (let i = 0; i < items.length; i++) {
        const element = items[i] as Record<string, Object>
        const title = element['title']
        const url = element['url']
        if (typeof title === 'string' && typeof url === 'string' && url !== '') {
          await db.addBookmark(title, url)
        }
      }
    }
    const historyRaw = parsed['history']
    if (Array.isArray(historyRaw)) {
      await db.clearHistory()
      const items = historyRaw as Object[]
      for (let i = 0; i < items.length; i++) {
        const element = items[i] as Record<string, Object>
        const title = element['title']
        const url = element['url']
        if (typeof title === 'string' && typeof url === 'string' && url !== '') {
          await db.addHistory(title, url)
        }
      }
    }
    const kv = parsed['settings']
    if (typeof kv === 'object' && kv !== null) {
      await AppSettings.getInstance().applyBackupKv(kv as Record<string, Object>)
    }
  }

  async listBookmarksForExport(): Promise<string> {
    const bookmarks = await BrowserDb.getInstance().listBookmarks()
    return this.buildBookmarksHtml(bookmarks)
  }

  buildBookmarksHtml(bookmarks: BookmarkRec[]): string {
    let html = '<!DOCTYPE NETSCAPE-Bookmark-file-1>\n<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">\n<TITLE>Bookmarks</TITLE>\n<H1>Bookmarks</H1>\n<DL><p>\n'
    for (let i = 0; i < bookmarks.length; i++) {
      const item = bookmarks[i]
      const title = this.escapeHtml(item.title !== '' ? item.title : item.url)
      html += `    <DT><A HREF="${this.escapeHtml(item.url)}">${title}</A>\n`
    }
    html += '</DL><p>\n'
    return html
  }

  parseBookmarksHtml(html: string): BookmarkRec[] {
    const result: BookmarkRec[] = []
    const pattern = /<A[^>]*HREF="([^"]+)"[^>]*>([^<]*)<\/A>/gi
    const matches = html.match(pattern)
    if (matches === null) {
      return result
    }
    for (let i = 0; i < matches.length; i++) {
      const linkPattern = /HREF="([^"]+)"/i
      const href = matches[i].match(linkPattern)
      if (href === null || href.length < 2) {
        continue
      }
      const textPattern = />([^<]*)<\/A>/i
      const text = matches[i].match(textPattern)
      const rec = new BookmarkRec()
      rec.url = href[1]
      rec.title = text !== null && text.length >= 2 && text[1].trim() !== '' ? text[1].trim() : href[1]
      result.push(rec)
    }
    return result
  }

  private escapeHtml(text: string): string {
    return text.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;')
  }
}
