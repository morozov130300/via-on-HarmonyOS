import { relationalStore } from '@kit.ArkData'
import { BookmarkRec, BookmarkFolderRec, HistoryRec, DownloadRec, DownloadStatus, HomeFavRec } from './Types'

const SQL_CREATE_BOOKMARKS: string = 'CREATE TABLE IF NOT EXISTS bookmarks ' +
  '(id INTEGER PRIMARY KEY, title TEXT, url TEXT, folder TEXT, created INTEGER)'
// 原版 bookmark_folders 表（o9/g.java:29-30）
const SQL_CREATE_BOOKMARK_FOLDERS: string = 'CREATE TABLE IF NOT EXISTS bookmark_folders ' +
  '(id INTEGER PRIMARY KEY, title TEXT, parent_id INTEGER DEFAULT 0, ordering INTEGER DEFAULT 0, created INTEGER, updated_at INTEGER DEFAULT 0)'
const SQL_CREATE_HISTORY: string = 'CREATE TABLE IF NOT EXISTS history ' +
  '(id INTEGER PRIMARY KEY, title TEXT, url TEXT, visited INTEGER)'
const SQL_CREATE_DOWNLOADS: string = 'CREATE TABLE IF NOT EXISTS downloads ' +
  '(id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT NOT NULL, path TEXT NOT NULL, ' +
  'mime TEXT DEFAULT \'\', size INTEGER DEFAULT 0, received INTEGER DEFAULT 0, ' +
  'status INTEGER DEFAULT 0, created INTEGER)'
const SQL_CREATE_SETTINGS: string = 'CREATE TABLE IF NOT EXISTS settings ' +
  '(id INTEGER PRIMARY KEY, data TEXT)'
// 原版 downloader chunks 表 1:1（f5/d.java:256）
const SQL_CREATE_DOWNLOAD_CHUNKS: string = 'CREATE TABLE IF NOT EXISTS download_chunks ' +
  '(id INTEGER PRIMARY KEY AUTOINCREMENT, task_id INTEGER, start INTEGER, ' +
  'length INTEGER, downloaded INTEGER, flags INTEGER)'
// 原版主页收藏为独立存储（与书签分开），icon 存本地图标文件路径
const SQL_CREATE_HOME_FAVS: string = 'CREATE TABLE IF NOT EXISTS home_favs ' +
  '(id INTEGER PRIMARY KEY, title TEXT, url TEXT, icon TEXT DEFAULT \'\', position INTEGER)'

const SYNC_TABLES: string[] = ['bookmarks', 'bookmark_folders', 'history', 'settings']
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
      name: 'uia.db',
      securityLevel: relationalStore.SecurityLevel.S1
    }
    this.rdb = await relationalStore.getRdbStore(context, config)
    // 新安装必须先建基础表，再检查旧结构与补列；否则空库 ALTER TABLE 会中断启动。
    await this.rdb.executeSql(SQL_CREATE_BOOKMARKS)
    await this.rdb.executeSql(SQL_CREATE_BOOKMARK_FOLDERS)
    await this.rdb.executeSql(SQL_CREATE_HISTORY)
    await this.rdb.executeSql(SQL_CREATE_DOWNLOADS)
    await this.rdb.executeSql(SQL_CREATE_SETTINGS)
    await this.rdb.executeSql(SQL_CREATE_HOME_FAVS)
    await this.migrateLegacyTables()
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
    // 原版 bookmarks 含 click_times（点击热度，ea/b.java:26）
    await this.addColumnIfMissing('bookmarks', 'click_times', 'INTEGER DEFAULT 0')
    // 原版 bookmark_items.folder_id（o9/g.java:28）：0=根目录
    await this.addColumnIfMissing('bookmarks', 'folder_id', 'INTEGER DEFAULT 0')
    // 原版 bookmark_items.last_updated_at（o9/g.java:28）
    await this.addColumnIfMissing('bookmarks', 'updated_at', 'INTEGER DEFAULT 0')
await this.addColumnIfMissing('bookmark_folders', 'updated_at', 'INTEGER DEFAULT 0')
    // 原版 bookmark_items.ordering（o9/g.java:28）：文件夹内排序；老数据按 created 排名回填
    const addedOrdering = await this.addColumnIfMissing('bookmarks', 'ordering', 'INTEGER DEFAULT 0')
    if (addedOrdering) {
      await this.rdb.executeSql('UPDATE bookmarks SET ordering = (SELECT COUNT(*) FROM bookmarks b2 ' +
        'WHERE b2.folder_id = bookmarks.folder_id AND (b2.created < bookmarks.created ' +
        'OR (b2.created = bookmarks.created AND b2.id < bookmarks.id)))')
    }
    // 原版 downloads 错误信息（gu 下载失败：%1$s）
    await this.addColumnIfMissing('downloads', 'error_message', "TEXT DEFAULT ''")
    // 原版 downloader tasks 表引擎列（f5/d.java:255）
    await this.addColumnIfMissing('downloads', 'state', 'INTEGER DEFAULT 0')
    await this.addColumnIfMissing('downloads', 'speed', 'REAL DEFAULT 0')
    await this.addColumnIfMissing('downloads', 'chunks', 'INTEGER DEFAULT 1')
    await this.addColumnIfMissing('downloads', 'flags', 'INTEGER DEFAULT 0')
    await this.addColumnIfMissing('downloads', 'priority', 'INTEGER DEFAULT 0')
    await this.addColumnIfMissing('downloads', 'header', "TEXT DEFAULT ''")
    await this.addColumnIfMissing('downloads', 'updated_at', 'INTEGER DEFAULT 0')
    await this.rdb.executeSql(SQL_CREATE_DOWNLOAD_CHUNKS)
  }

  private async addColumnIfMissing(table: string, column: string, ddl: string): Promise<boolean> {
    if (this.rdb === null) {
      return false
    }
    const resultSet = await this.rdb.querySql(`PRAGMA table_info(${table})`)
    let exists = false
    while (resultSet.goToNextRow()) {
      if (resultSet.getString(resultSet.getColumnIndex('name')) === column) {
        exists = true
      }
    }
    resultSet.close()
    if (!exists) {
      await this.rdb.executeSql(`ALTER TABLE ${table} ADD COLUMN ${column} ${ddl}`)
      return true
    }
    return false
  }

  async clickBookmark(id: number): Promise<void> {
    if (this.rdb === null) {
      return
    }
    await this.rdb.executeSql(`UPDATE bookmarks SET click_times = click_times + 1 WHERE id = ${id}`)
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

  // 原版 ga/b.java:169：查询书签（ordering 排序，o9/g.java:28）
  async listBookmarks(folderId: number = 0): Promise<BookmarkRec[]> {
    const result: BookmarkRec[] = []
    if (this.rdb === null) {
      return result
    }
    const predicates = new relationalStore.RdbPredicates('bookmarks')
    predicates.equalTo('folder_id', folderId)
    predicates.orderByAsc('ordering')
    const resultSet = await this.rdb.query(predicates)
    while (resultSet.goToNextRow()) {
      const rec = new BookmarkRec()
      rec.id = resultSet.getDouble(resultSet.getColumnIndex('id'))
      rec.title = resultSet.getString(resultSet.getColumnIndex('title'))
      rec.url = resultSet.getString(resultSet.getColumnIndex('url'))
      rec.folder = resultSet.getString(resultSet.getColumnIndex('folder'))
      rec.folderId = resultSet.getDouble(resultSet.getColumnIndex('folder_id'))
      rec.ordering = resultSet.getDouble(resultSet.getColumnIndex('ordering'))
      rec.created = resultSet.getDouble(resultSet.getColumnIndex('created'))
      rec.updatedAt = resultSet.getDouble(resultSet.getColumnIndex('updated_at'))
      result.push(rec)
    }
    resultSet.close()
    return result
  }

  // 备份导出用：全量书签（o9/g.java k() + u() 全表查询）
  async listAllBookmarks(): Promise<BookmarkRec[]> {
    const result: BookmarkRec[] = []
    if (this.rdb === null) {
      return result
    }
    const predicates = new relationalStore.RdbPredicates('bookmarks')
    predicates.orderByAsc('folder_id')
    predicates.orderByAsc('ordering')
    const resultSet = await this.rdb.query(predicates)
    while (resultSet.goToNextRow()) {
      const rec = new BookmarkRec()
      rec.id = resultSet.getDouble(resultSet.getColumnIndex('id'))
      rec.title = resultSet.getString(resultSet.getColumnIndex('title'))
      rec.url = resultSet.getString(resultSet.getColumnIndex('url'))
      rec.folder = resultSet.getString(resultSet.getColumnIndex('folder'))
      rec.folderId = resultSet.getDouble(resultSet.getColumnIndex('folder_id'))
      rec.ordering = resultSet.getDouble(resultSet.getColumnIndex('ordering'))
      rec.created = resultSet.getDouble(resultSet.getColumnIndex('created'))
      rec.updatedAt = resultSet.getDouble(resultSet.getColumnIndex('updated_at'))
      result.push(rec)
    }
    resultSet.close()
    return result
  }

  // 备份导出用：全量文件夹（o9/g.java:439 k() 查询 bookmark_folders 全表）
  async listAllBookmarkFolders(): Promise<BookmarkFolderRec[]> {
    const result: BookmarkFolderRec[] = []
    if (this.rdb === null) {
      return result
    }
    const predicates = new relationalStore.RdbPredicates('bookmark_folders')
    predicates.orderByAsc('parent_id')
    predicates.orderByAsc('ordering')
    const resultSet = await this.rdb.query(predicates)
    while (resultSet.goToNextRow()) {
      const rec = new BookmarkFolderRec()
      rec.id = resultSet.getDouble(resultSet.getColumnIndex('id'))
      rec.title = resultSet.getString(resultSet.getColumnIndex('title'))
      rec.parentId = resultSet.getDouble(resultSet.getColumnIndex('parent_id'))
      rec.ordering = resultSet.getDouble(resultSet.getColumnIndex('ordering'))
      rec.created = resultSet.getDouble(resultSet.getColumnIndex('created'))
      result.push(rec)
    }
    resultSet.close()
    return result
  }

  private async nextBookmarkOrdering(folderId: number): Promise<number> {
    if (this.rdb === null) {
      return 0
    }
    const resultSet = await this.rdb.querySql(
      `SELECT COALESCE(MAX(ordering), -1) + 1 AS next FROM bookmarks WHERE folder_id = ${folderId}`)
    let next = 0
    while (resultSet.goToNextRow()) {
      next = resultSet.getDouble(resultSet.getColumnIndex('next'))
    }
    resultSet.close()
    return next
  }

  async addBookmark(title: string, url: string, folderId: number = 0): Promise<number> {
    if (this.rdb === null) {
      return -1
    }
    const now = Date.now()
    const bucket: relationalStore.ValuesBucket = {
      'id': this.genId(),
      'title': title,
      'url': url,
      'folder': '',
      'folder_id': folderId,
      'ordering': await this.nextBookmarkOrdering(folderId),
      'created': now,
      'updated_at': now
    }
    return await this.rdb.insert('bookmarks', bucket)
  }

  async updateBookmark(id: number, title: string, url: string): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const bucket: relationalStore.ValuesBucket = {
      'title': title,
      'url': url,
      'updated_at': Date.now()
    }
    const predicates = new relationalStore.RdbPredicates('bookmarks')
    predicates.equalTo('id', id)
    await this.rdb.update(bucket, predicates)
  }

  // ===== 原版 bookmark_folders（o9/g.java:29-30）=====

  async listBookmarkFolders(parentId: number): Promise<BookmarkFolderRec[]> {
    const result: BookmarkFolderRec[] = []
    if (this.rdb === null) {
      return result
    }
    const predicates = new relationalStore.RdbPredicates('bookmark_folders')
    predicates.equalTo('parent_id', parentId)
    predicates.orderByAsc('created')
    const resultSet = await this.rdb.query(predicates)
    while (resultSet.goToNextRow()) {
      const rec = new BookmarkFolderRec()
      rec.id = resultSet.getDouble(resultSet.getColumnIndex('id'))
      rec.title = resultSet.getString(resultSet.getColumnIndex('title'))
      rec.parentId = resultSet.getDouble(resultSet.getColumnIndex('parent_id'))
      rec.ordering = resultSet.getDouble(resultSet.getColumnIndex('ordering'))
      rec.created = resultSet.getDouble(resultSet.getColumnIndex('created'))
      rec.updatedAt = resultSet.getDouble(resultSet.getColumnIndex('updated_at'))
      result.push(rec)
    }
    resultSet.close()
    return result
  }

  async addBookmarkFolder(title: string, parentId: number): Promise<number> {
    if (this.rdb === null) {
      return -1
    }
    const bucket: relationalStore.ValuesBucket = {
      'id': this.genId(),
      'title': title,
      'parent_id': parentId,
      'ordering': 0,
      'created': Date.now(),
      'updated_at': Date.now()
    }
    return await this.rdb.insert('bookmark_folders', bucket)
  }

  async renameBookmarkFolder(id: number, title: string): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const bucket: relationalStore.ValuesBucket = {
      'title': title,
      'updated_at': Date.now()
    }
    const predicates = new relationalStore.RdbPredicates('bookmark_folders')
    predicates.equalTo('id', id)
    await this.rdb.update(bucket, predicates)
  }

  async getBookmarkFolder(id: number): Promise<BookmarkFolderRec | null> {
    if (this.rdb === null) {
      return null
    }
    const predicates = new relationalStore.RdbPredicates('bookmark_folders')
    predicates.equalTo('id', id)
    const resultSet = await this.rdb.query(predicates)
    let rec: BookmarkFolderRec | null = null
    while (resultSet.goToNextRow()) {
      rec = new BookmarkFolderRec()
      rec.id = resultSet.getDouble(resultSet.getColumnIndex('id'))
      rec.title = resultSet.getString(resultSet.getColumnIndex('title'))
      rec.parentId = resultSet.getDouble(resultSet.getColumnIndex('parent_id'))
      rec.ordering = resultSet.getDouble(resultSet.getColumnIndex('ordering'))
      rec.created = resultSet.getDouble(resultSet.getColumnIndex('created'))
    }
    resultSet.close()
    return rec
  }

  // 原版删除文件夹递归删除子文件夹及内含书签（fi：同时删除文件夹内的书签）
  async deleteBookmarkFolder(id: number): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const children = await this.listBookmarkFolders(id)
    for (let i = 0; i < children.length; i++) {
      await this.deleteBookmarkFolder(children[i].id)
    }
    const bookmarkPredicates = new relationalStore.RdbPredicates('bookmarks')
    bookmarkPredicates.equalTo('folder_id', id)
    await this.rdb.delete(bookmarkPredicates)
    const predicates = new relationalStore.RdbPredicates('bookmark_folders')
    predicates.equalTo('id', id)
    await this.rdb.delete(predicates)
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
    for (let i = 0; i < ids.length; i++) {
      const bucket: relationalStore.ValuesBucket = {
        'ordering': i
      }
      const predicates = new relationalStore.RdbPredicates('bookmarks')
      predicates.equalTo('id', ids[i])
      await this.rdb.update(bucket, predicates)
    }
  }

  // o9/g.java x() 文件夹替换：按 _id delete + insert（保留原 id/ordering/created）
  async replaceBookmarkFolderById(rec: BookmarkFolderRec): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('bookmark_folders')
    predicates.equalTo('id', rec.id)
    await this.rdb.delete(predicates)
    const bucket: relationalStore.ValuesBucket = {
      'id': rec.id,
      'title': rec.title,
      'parent_id': rec.parentId,
      'ordering': rec.ordering,
      'created': rec.created
    }
    await this.rdb.insert('bookmark_folders', bucket)
  }

  // o9/g.java x() 书签替换：按 url delete + insert 全字段（保留 ordering/created/updated_at）
  async replaceBookmarkByUrl(rec: BookmarkRec): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('bookmarks')
    predicates.equalTo('url', rec.url)
    await this.rdb.delete(predicates)
    const bucket: relationalStore.ValuesBucket = {
      'id': rec.id >= 0 ? rec.id : this.genId(),
      'title': rec.title,
      'url': rec.url,
      'folder': rec.folder,
      'folder_id': rec.folderId,
      'ordering': rec.ordering,
      'created': rec.created,
      'updated_at': rec.updatedAt
    }
    await this.rdb.insert('bookmarks', bucket)
  }

  // 原版 ga/b.java:169：全量查询历史，无条数上限
  async listHistory(): Promise<HistoryRec[]> {
    const result: HistoryRec[] = []
    if (this.rdb === null) {
      return result
    }
    const predicates = new relationalStore.RdbPredicates('history')
    predicates.orderByDesc('visited')
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

  // 原版 ga/b.java:141,196：历史时间戳为秒级
  async addHistory(title: string, url: string): Promise<void> {
    await this.addHistoryWithTime(title, url, Math.floor(Date.now() / 1000))
  }

  // ga/b.java:212 x(List)：按 url delete + insert，保留记录内 updated_at（秒）
  async addHistoryWithTime(title: string, url: string, visited: number): Promise<void> {
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
      'visited': visited
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
      'created': rec.created,
      'error_message': rec.errorMessage,
      'state': rec.state,
      'speed': rec.speed,
      'chunks': rec.chunks,
      'flags': rec.flags,
      'priority': rec.priority,
      'header': rec.header,
      'updated_at': rec.updatedAt
    }
    return await this.rdb.insert('downloads', bucket)
  }

  async getDownloadById(id: number): Promise<DownloadRec | null> {
    if (this.rdb === null) {
      return null
    }
    const predicates = new relationalStore.RdbPredicates('downloads')
    predicates.equalTo('id', id)
    const resultSet = await this.rdb.query(predicates)
    let rec: DownloadRec | null = null
    if (resultSet.goToNextRow()) {
      rec = new DownloadRec()
      rec.id = resultSet.getDouble(resultSet.getColumnIndex('id'))
      rec.url = resultSet.getString(resultSet.getColumnIndex('url'))
      rec.path = resultSet.getString(resultSet.getColumnIndex('path'))
      rec.mime = resultSet.getString(resultSet.getColumnIndex('mime'))
      rec.size = resultSet.getDouble(resultSet.getColumnIndex('size'))
      rec.received = resultSet.getDouble(resultSet.getColumnIndex('received'))
      rec.status = resultSet.getDouble(resultSet.getColumnIndex('status'))
      rec.created = resultSet.getDouble(resultSet.getColumnIndex('created'))
      rec.errorMessage = resultSet.getString(resultSet.getColumnIndex('error_message'))
      rec.state = resultSet.getDouble(resultSet.getColumnIndex('state'))
      rec.speed = resultSet.getDouble(resultSet.getColumnIndex('speed'))
      rec.chunks = resultSet.getDouble(resultSet.getColumnIndex('chunks'))
      rec.flags = resultSet.getDouble(resultSet.getColumnIndex('flags'))
      rec.priority = resultSet.getDouble(resultSet.getColumnIndex('priority'))
      rec.header = resultSet.getString(resultSet.getColumnIndex('header'))
      rec.updatedAt = resultSet.getDouble(resultSet.getColumnIndex('updated_at'))
    }
    resultSet.close()
    return rec
  }

  async updateDownload(id: number, received: number, status: DownloadStatus,
    errorMessage: string = ''): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const bucket: relationalStore.ValuesBucket = {
      'received': received,
      'status': status,
      'error_message': errorMessage
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
      rec.errorMessage = resultSet.getString(resultSet.getColumnIndex('error_message'))
      rec.state = resultSet.getDouble(resultSet.getColumnIndex('state'))
      rec.speed = resultSet.getDouble(resultSet.getColumnIndex('speed'))
      rec.chunks = resultSet.getDouble(resultSet.getColumnIndex('chunks'))
      rec.flags = resultSet.getDouble(resultSet.getColumnIndex('flags'))
      rec.priority = resultSet.getDouble(resultSet.getColumnIndex('priority'))
      rec.header = resultSet.getString(resultSet.getColumnIndex('header'))
      rec.updatedAt = resultSet.getDouble(resultSet.getColumnIndex('updated_at'))
      result.push(rec)
    }
    resultSet.close()
    return result
  }

  // ===== 下载引擎持久化（原版 f5/d.java tasks/chunks CRUD 1:1） =====

  // f5/d.t()：任务字段全量更新
  async updateEngineTask(rec: DownloadRec): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const bucket: relationalStore.ValuesBucket = {
      'path': rec.path,
      'mime': rec.mime,
      'size': rec.size,
      'received': rec.received,
      'status': rec.status,
      'error_message': rec.errorMessage,
      'state': rec.state,
      'speed': rec.speed,
      'chunks': rec.chunks,
      'flags': rec.flags,
      'priority': rec.priority,
      'header': rec.header,
      'updated_at': rec.updatedAt
    }
    const predicates = new relationalStore.RdbPredicates('downloads')
    predicates.equalTo('id', rec.id)
    await this.rdb.update(bucket, predicates)
  }

  // f5/d.f()：按状态查任务（state IN (...)，created ASC）
  async listDownloadsByState(states: number[]): Promise<DownloadRec[]> {
    const result: DownloadRec[] = []
    if (this.rdb === null || states.length === 0) {
      return result
    }
    const inList = states.join(',')
    const resultSet = await this.rdb.querySql(
      `SELECT * FROM downloads WHERE state IN (${inList}) ORDER BY created ASC`)
    while (resultSet.goToNextRow()) {
      const rec = new DownloadRec()
      rec.id = resultSet.getDouble(resultSet.getColumnIndex('id'))
      rec.url = resultSet.getString(resultSet.getColumnIndex('url'))
      rec.path = resultSet.getString(resultSet.getColumnIndex('path'))
      rec.mime = resultSet.getString(resultSet.getColumnIndex('mime'))
      rec.size = resultSet.getDouble(resultSet.getColumnIndex('size'))
      rec.received = resultSet.getDouble(resultSet.getColumnIndex('received'))
      rec.status = resultSet.getDouble(resultSet.getColumnIndex('status'))
      rec.created = resultSet.getDouble(resultSet.getColumnIndex('created'))
      rec.errorMessage = resultSet.getString(resultSet.getColumnIndex('error_message'))
      rec.state = resultSet.getDouble(resultSet.getColumnIndex('state'))
      rec.speed = resultSet.getDouble(resultSet.getColumnIndex('speed'))
      rec.chunks = resultSet.getDouble(resultSet.getColumnIndex('chunks'))
      rec.flags = resultSet.getDouble(resultSet.getColumnIndex('flags'))
      rec.priority = resultSet.getDouble(resultSet.getColumnIndex('priority'))
      rec.header = resultSet.getString(resultSet.getColumnIndex('header'))
      rec.updatedAt = resultSet.getDouble(resultSet.getColumnIndex('updated_at'))
      result.push(rec)
    }
    resultSet.close()
    return result
  }

  // f5/d.k()/s()：批量插入分块
  async insertChunks(taskId: number, chunks: number[][]): Promise<void> {
    if (this.rdb === null) {
      return
    }
    for (let i = 0; i < chunks.length; i++) {
      const bucket: relationalStore.ValuesBucket = {
        'task_id': taskId,
        'start': chunks[i][0],
        'length': chunks[i][1],
        'downloaded': 0,
        'flags': 0
      }
      await this.rdb.insert('download_chunks', bucket)
    }
  }

  // f5/d.i()/r()：读取任务分块
  async listChunks(taskId: number): Promise<number[][]> {
    const result: number[][] = []
    if (this.rdb === null) {
      return result
    }
    const resultSet = await this.rdb.querySql(
      `SELECT id, start, length, downloaded FROM download_chunks WHERE task_id = ${taskId}`)
    while (resultSet.goToNextRow()) {
      result.push([resultSet.getDouble(resultSet.getColumnIndex('id')),
        resultSet.getDouble(resultSet.getColumnIndex('start')),
        resultSet.getDouble(resultSet.getColumnIndex('length')),
        resultSet.getDouble(resultSet.getColumnIndex('downloaded'))])
    }
    resultSet.close()
    return result
  }

  // 引擎运行期高频分块进度更新（原版经内存+周期落盘，此处直写）
  async updateChunkDownloaded(chunkId: number, downloaded: number): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('download_chunks')
    predicates.equalTo('id', chunkId)
    const bucket: relationalStore.ValuesBucket = {
      'downloaded': downloaded
    }
    await this.rdb.update(bucket, predicates)
  }

  // f5/d.o()：清零任务全部分块进度
  async resetChunks(taskId: number): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('download_chunks')
    predicates.equalTo('task_id', taskId)
    const bucket: relationalStore.ValuesBucket = {
      'downloaded': 0
    }
    await this.rdb.update(bucket, predicates)
  }

  // f5/d.m()：删除任务分块
  async deleteChunks(taskId: number): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('download_chunks')
    predicates.equalTo('task_id', taskId)
    await this.rdb.delete(predicates)
  }

  // f5/d.j()：是否存在指定状态任务
  async hasDownloadInState(states: number[]): Promise<boolean> {
    if (this.rdb === null || states.length === 0) {
      return false
    }
    const inList = states.join(',')
    const resultSet = await this.rdb.querySql(
      `SELECT id FROM downloads WHERE state IN (${inList}) LIMIT 1`)
    const has = resultSet.goToNextRow()
    resultSet.close()
    return has
  }

  async deleteDownload(id: number): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('downloads')
    predicates.equalTo('id', id)
    await this.rdb.delete(predicates)
    await this.deleteChunks(id)
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
    await this.rdb.delete(new relationalStore.RdbPredicates('bookmark_folders'))
  }

  // ===== 主页收藏（原版独立于书签的主页宫格数据） =====
  async listHomeFavs(): Promise<HomeFavRec[]> {
    const result: HomeFavRec[] = []
    if (this.rdb === null) {
      return result
    }
    const predicates = new relationalStore.RdbPredicates('home_favs')
    predicates.orderByAsc('position')
    const resultSet = await this.rdb.query(predicates)
    while (resultSet.goToNextRow()) {
      const rec = new HomeFavRec()
      rec.id = resultSet.getDouble(resultSet.getColumnIndex('id'))
      rec.title = resultSet.getString(resultSet.getColumnIndex('title'))
      rec.url = resultSet.getString(resultSet.getColumnIndex('url'))
      rec.icon = resultSet.getString(resultSet.getColumnIndex('icon'))
      rec.position = resultSet.getDouble(resultSet.getColumnIndex('position'))
      result.push(rec)
    }
    resultSet.close()
    return result
  }

  async addHomeFav(title: string, url: string, icon: string, position: number): Promise<number> {
    if (this.rdb === null) {
      return -1
    }
    const bucket: relationalStore.ValuesBucket = {
      'id': this.genId(),
      'title': title,
      'url': url,
      'icon': icon,
      'position': position
    }
    return await this.rdb.insert('home_favs', bucket)
  }

  async updateHomeFav(id: number, title: string, url: string, icon: string): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const bucket: relationalStore.ValuesBucket = {
      'title': title,
      'url': url,
      'icon': icon
    }
    const predicates = new relationalStore.RdbPredicates('home_favs')
    predicates.equalTo('id', id)
    await this.rdb.update(bucket, predicates)
  }

  async deleteHomeFav(id: number): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const predicates = new relationalStore.RdbPredicates('home_favs')
    predicates.equalTo('id', id)
    await this.rdb.delete(predicates)
  }

  async reorderHomeFavs(ids: number[]): Promise<void> {
    if (this.rdb === null) {
      return
    }
    for (let i = 0; i < ids.length; i++) {
      const bucket: relationalStore.ValuesBucket = {
        'position': i
      }
      const predicates = new relationalStore.RdbPredicates('home_favs')
      predicates.equalTo('id', ids[i])
      await this.rdb.update(bucket, predicates)
    }
  }

  async clearHomeFavIcons(): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const bucket: relationalStore.ValuesBucket = {
      'icon': ''
    }
    await this.rdb.update(bucket, new relationalStore.RdbPredicates('home_favs'))
  }

  // icons.zip 导入后：仅当派生路径图标文件存在时回写 icon 列
  // （对齐原版渲染期按文件存在性探测图标的语义）
  async setHomeFavIconByUrl(url: string, icon: string): Promise<void> {
    if (this.rdb === null) {
      return
    }
    const bucket: relationalStore.ValuesBucket = {
      'icon': icon
    }
    const predicates = new relationalStore.RdbPredicates('home_favs')
    predicates.equalTo('url', url)
    await this.rdb.update(bucket, predicates)
  }

  // fa/b.java j(List) favorites 导入 mode 0：按 url delete + insert 合并（保留已有 icon）
  async replaceHomeFavByUrl(title: string, url: string, position: number): Promise<void> {
    if (this.rdb === null) {
      return
    }
    let icon = ''
    const queryPredicates = new relationalStore.RdbPredicates('home_favs')
    queryPredicates.equalTo('url', url)
    const resultSet = await this.rdb.query(queryPredicates)
    while (resultSet.goToNextRow()) {
      icon = resultSet.getString(resultSet.getColumnIndex('icon'))
    }
    resultSet.close()
    await this.rdb.delete(queryPredicates)
    const bucket: relationalStore.ValuesBucket = {
      'id': this.genId(),
      'title': title,
      'url': url,
      'icon': icon,
      'position': position
    }
    await this.rdb.insert('home_favs', bucket)
  }
}
