import { relationalStore } from '@kit.ArkData'
import { BookmarkRec, HistoryRec, DownloadRec, DownloadStatus } from './Types'

const SQL_CREATE_BOOKMARKS: string = 'CREATE TABLE IF NOT EXISTS bookmarks ' +
  '(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, url TEXT NOT NULL, ' +
  'folder TEXT DEFAULT \'\', created INTEGER)'
const SQL_CREATE_HISTORY: string = 'CREATE TABLE IF NOT EXISTS history ' +
  '(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, url TEXT NOT NULL, visited INTEGER)'
const SQL_CREATE_DOWNLOADS: string = 'CREATE TABLE IF NOT EXISTS downloads ' +
  '(id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT NOT NULL, path TEXT NOT NULL, ' +
  'mime TEXT DEFAULT \'\', size INTEGER DEFAULT 0, received INTEGER DEFAULT 0, ' +
  'status INTEGER DEFAULT 0, created INTEGER)'

export class BrowserDb {
  private static instance: BrowserDb | null = null
  private rdb: relationalStore.RdbStore | null = null

  static getInstance(): BrowserDb {
    if (BrowserDb.instance === null) {
      BrowserDb.instance = new BrowserDb()
    }
    return BrowserDb.instance
  }

  async init(context: Context): Promise<void> {
    if (this.rdb !== null) {
      return
    }
    const config: relationalStore.StoreConfig = {
      name: 'via.db',
      securityLevel: relationalStore.SecurityLevel.S1
    }
    this.rdb = await relationalStore.getRdbStore(context, config)
    await this.rdb.executeSql(SQL_CREATE_BOOKMARKS)
    await this.rdb.executeSql(SQL_CREATE_HISTORY)
    await this.rdb.executeSql(SQL_CREATE_DOWNLOADS)
  }

  async listBookmarks(): Promise<BookmarkRec[]> {
    const result: BookmarkRec[] = []
    if (this.rdb === null) {
      return result
    }
    const predicates = new relationalStore.RdbPredicates('bookmarks')
    predicates.orderByAsc('created')
    const resultSet = await this.rdb.query(predicates)
    while (resultSet.goToNextRow()) {
      const rec = new BookmarkRec()
      rec.id = resultSet.getDouble(resultSet.getColumnIndex('id'))
      rec.title = resultSet.getString(resultSet.getColumnIndex('title'))
      rec.url = resultSet.getString(resultSet.getColumnIndex('url'))
      rec.folder = resultSet.getString(resultSet.getColumnIndex('folder'))
      rec.created = resultSet.getDouble(resultSet.getColumnIndex('created'))
      result.push(rec)
    }
    resultSet.close()
    return result
  }

  async addBookmark(title: string, url: string): Promise<number> {
    if (this.rdb === null) {
      return -1
    }
    const bucket: relationalStore.ValuesBucket = {
      'title': title,
      'url': url,
      'folder': '',
      'created': Date.now()
    }
    return await this.rdb.insert('bookmarks', bucket)
  }

  async updateBookmark(id: number, title: string, url: string): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const bucket: relationalStore.ValuesBucket = {
      'title': title,
      'url': url
    }
    const predicates = new relationalStore.RdbPredicates('bookmarks')
    predicates.equalTo('id', id)
    await this.rdb.update(bucket, predicates)
  }

  async deleteBookmark(id: number): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('bookmarks')
    predicates.equalTo('id', id)
    await this.rdb.delete(predicates)
  }

  async reorderBookmarks(ids: number[]): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const base = Date.now()
    for (let i = 0; i < ids.length; i++) {
      const bucket: relationalStore.ValuesBucket = {
        'created': base + i
      }
      const predicates = new relationalStore.RdbPredicates('bookmarks')
      predicates.equalTo('id', ids[i])
      await this.rdb.update(bucket, predicates)
    }
  }

  async listHistory(): Promise<HistoryRec[]> {
    const result: HistoryRec[] = []
    if (this.rdb === null) {
      return result
    }
    const predicates = new relationalStore.RdbPredicates('history')
    predicates.orderByDesc('visited').limitAs(500)
    const resultSet = await this.rdb.query(predicates)
    while (resultSet.goToNextRow()) {
      const rec = new HistoryRec()
      rec.id = resultSet.getDouble(resultSet.getColumnIndex('id'))
      rec.title = resultSet.getString(resultSet.getColumnIndex('title'))
      rec.url = resultSet.getString(resultSet.getColumnIndex('url'))
      rec.visited = resultSet.getDouble(resultSet.getColumnIndex('visited'))
      result.push(rec)
    }
    resultSet.close()
    return result
  }

  async addHistory(title: string, url: string): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('history')
    predicates.equalTo('url', url)
    await this.rdb.delete(predicates)
    const bucket: relationalStore.ValuesBucket = {
      'title': title,
      'url': url,
      'visited': Date.now()
    }
    await this.rdb.insert('history', bucket)
  }

  async deleteHistory(id: number): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('history')
    predicates.equalTo('id', id)
    await this.rdb.delete(predicates)
  }

  async clearHistory(): Promise<void> {
    if (this.rdb === null) {
      return
    }
    await this.rdb.delete(new relationalStore.RdbPredicates('history'))
  }

  async insertDownload(rec: DownloadRec): Promise<number> {
    if (this.rdb === null) {
      return -1
    }
    const bucket: relationalStore.ValuesBucket = {
      'url': rec.url,
      'path': rec.path,
      'mime': rec.mime,
      'size': rec.size,
      'received': rec.received,
      'status': rec.status,
      'created': rec.created
    }
    return await this.rdb.insert('downloads', bucket)
  }

  async updateDownload(id: number, received: number, status: DownloadStatus): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const bucket: relationalStore.ValuesBucket = {
      'received': received,
      'status': status
    }
    const predicates = new relationalStore.RdbPredicates('downloads')
    predicates.equalTo('id', id)
    await this.rdb.update(bucket, predicates)
  }

  async listDownloads(): Promise<DownloadRec[]> {
    const result: DownloadRec[] = []
    if (this.rdb === null) {
      return result
    }
    const predicates = new relationalStore.RdbPredicates('downloads')
    predicates.orderByDesc('created')
    const resultSet = await this.rdb.query(predicates)
    while (resultSet.goToNextRow()) {
      const rec = new DownloadRec()
      rec.id = resultSet.getDouble(resultSet.getColumnIndex('id'))
      rec.url = resultSet.getString(resultSet.getColumnIndex('url'))
      rec.path = resultSet.getString(resultSet.getColumnIndex('path'))
      rec.mime = resultSet.getString(resultSet.getColumnIndex('mime'))
      rec.size = resultSet.getDouble(resultSet.getColumnIndex('size'))
      rec.received = resultSet.getDouble(resultSet.getColumnIndex('received'))
      const status = resultSet.getDouble(resultSet.getColumnIndex('status'))
      rec.status = status
      rec.created = resultSet.getDouble(resultSet.getColumnIndex('created'))
      result.push(rec)
    }
    resultSet.close()
    return result
  }

  async deleteDownload(id: number): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('downloads')
    predicates.equalTo('id', id)
    await this.rdb.delete(predicates)
  }

  async clearDownloads(): Promise<void> {
    if (this.rdb === null) {
      return
    }
    await this.rdb.delete(new relationalStore.RdbPredicates('downloads'))
  }

  async clearBookmarks(): Promise<void> {
    if (this.rdb === null) {
      return
    }
    await this.rdb.delete(new relationalStore.RdbPredicates('bookmarks'))
  }
}
