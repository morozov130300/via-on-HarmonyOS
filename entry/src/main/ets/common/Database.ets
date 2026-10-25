import { relationalStore } from '@kit.ArkData'
import { BookmarkRec, HistoryRec, DownloadRec, DownloadStatus } from './Types'

const SQL_CREATE_BOOKMARKS: string = 'CREATE TABLE IF NOT EXISTS bookmarks ' +
  '(id INTEGER PRIMARY KEY, title TEXT, url TEXT, folder TEXT, created INTEGER)'
const SQL_CREATE_HISTORY: string = 'CREATE TABLE IF NOT EXISTS history ' +
  '(id INTEGER PRIMARY KEY, title TEXT, url TEXT, visited INTEGER)'
const SQL_CREATE_DOWNLOADS: string = 'CREATE TABLE IF NOT EXISTS downloads ' +
  '(id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT NOT NULL, path TEXT NOT NULL, ' +
  'mime TEXT DEFAULT \'\', size INTEGER DEFAULT 0, received INTEGER DEFAULT 0, ' +
  'status INTEGER DEFAULT 0, created INTEGER)'
const SQL_CREATE_SETTINGS: string = 'CREATE TABLE IF NOT EXISTS settings ' +
  '(id INTEGER PRIMARY KEY, data TEXT)'

const SYNC_TABLES: string[] = ['bookmarks', 'history', 'settings']
const SETTINGS_SNAPSHOT_ID: number = 1

export class BrowserDb {
  private static instance: BrowserDb | null = null
  private rdb: relationalStore.RdbStore | null = null
  private idSeq: number = 0
  private dataChangeListeners: (() => void)[] = []

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
    await this.migrateLegacyTables()
    await this.rdb.executeSql(SQL_CREATE_BOOKMARKS)
    await this.rdb.executeSql(SQL_CREATE_HISTORY)
    await this.rdb.executeSql(SQL_CREATE_DOWNLOADS)
    await this.rdb.executeSql(SQL_CREATE_SETTINGS)
    try {
      const distributedConfig: relationalStore.DistributedConfig = {
        autoSync: true
      }
      await this.rdb.setDistributedTables(SYNC_TABLES,
        relationalStore.DistributedType.DISTRIBUTED_CLOUD, distributedConfig)
      this.rdb.on('dataChange', relationalStore.SubscribeType.SUBSCRIBE_TYPE_REMOTE,
        (devices: Array<string>) => {
          this.notifyDataChange()
        })
    } catch (error) {
      console.error(`register cloud sync failed: ${JSON.stringify(error)}`)
    }
  }

  private genId(): number {
    this.idSeq = (this.idSeq + 1) % 1000
    return Date.now() * 1000 + this.idSeq
  }

  private async migrateLegacyTables(): Promise<void> {
    if (this.rdb === null) {
      return
    }
    await this.migrateLegacyTable('bookmarks', 'title, url, folder, created')
    await this.migrateLegacyTable('history', 'title, url, visited')
  }

  private async migrateLegacyTable(table: string, columns: string): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const resultSet = await this.rdb.querySql(
      `SELECT sql FROM sqlite_master WHERE type='table' AND name='${table}'`)
    let ddl = ''
    while (resultSet.goToNextRow()) {
      ddl = resultSet.getString(resultSet.getColumnIndex('sql'))
    }
    resultSet.close()
    if (ddl === '' || ddl.indexOf('AUTOINCREMENT') < 0) {
      return
    }
    console.info(`migrating legacy table ${table}`)
    await this.rdb.executeSql(`ALTER TABLE ${table} RENAME TO ${table}_legacy`)
    if (table === 'bookmarks') {
      await this.rdb.executeSql(SQL_CREATE_BOOKMARKS)
    } else {
      await this.rdb.executeSql(SQL_CREATE_HISTORY)
    }
    const rows = await this.rdb.querySql(`SELECT ${columns} FROM ${table}_legacy`)
    const values: string[][] = []
    while (rows.goToNextRow()) {
      const row: string[] = []
      for (let i = 0; i < rows.columnCount; i++) {
        row.push(`${rows.getValue(i)}`)
      }
      values.push(row)
    }
    rows.close()
    for (let i = 0; i < values.length; i++) {
      const bucket: relationalStore.ValuesBucket = {}
      bucket['id'] = this.genId()
      const cols = columns.split(', ')
      for (let c = 0; c < cols.length; c++) {
        bucket[cols[c]] = values[i][c]
      }
      await this.rdb.insert(table, bucket)
    }
    await this.rdb.executeSql(`DROP TABLE ${table}_legacy`)
  }

  addDataChangeListener(listener: () => void): void {
    this.dataChangeListeners.push(listener)
  }

  private notifyDataChange(): void {
    for (let i = 0; i < this.dataChangeListeners.length; i++) {
      this.dataChangeListeners[i]()
    }
  }

  cloudSyncNow(): Promise<void> {
    return new Promise<void>((resolve, reject) => {
      if (this.rdb === null) {
        reject(new Error('db not ready'))
        return
      }
      try {
        this.rdb.cloudSync(relationalStore.SyncMode.SYNC_MODE_TIME_FIRST, SYNC_TABLES,
          (progress: relationalStore.ProgressDetails) => {
            console.info(`cloud sync progress: ${JSON.stringify(progress)}`)
          }, (error: BusinessError, result: void) => {
            if (error) {
              console.error(`cloud sync failed: ${error.code} ${error.message}`)
              reject(error)
              return
            }
            resolve()
          })
      } catch (error) {
        reject(error as BusinessError)
      }
    })
  }

  async saveSettingsSnapshot(json: string): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('settings')
    predicates.equalTo('id', SETTINGS_SNAPSHOT_ID)
    const bucket: relationalStore.ValuesBucket = {
      'id': SETTINGS_SNAPSHOT_ID,
      'data': json
    }
    const updated = await this.rdb.update(bucket, predicates)
    if (updated <= 0) {
      await this.rdb.insert('settings', bucket)
    }
  }

  async loadSettingsSnapshot(): Promise<string> {
    if (this.rdb === null) {
      return ''
    }
    const predicates = new relationalStore.RdbPredicates('settings')
    predicates.equalTo('id', SETTINGS_SNAPSHOT_ID)
    const resultSet = await this.rdb.query(predicates)
    let data = ''
    while (resultSet.goToNextRow()) {
      data = resultSet.getString(resultSet.getColumnIndex('data'))
    }
    resultSet.close()
    return data
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
      'id': this.genId(),
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
      'id': this.genId(),
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
