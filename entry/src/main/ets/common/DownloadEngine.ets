import { http, connection } from '@kit.NetworkKit'
import { fileIo } from '@kit.CoreFileKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { common } from '@kit.AbilityKit'
import { BrowserDb } from './Database'
import { DownloadRec, DownloadStatus } from './Types'
import { AppSettings } from './Settings'
import { DownloadNotifier } from './DownloadNotifier'

// ===== 原版下载引擎状态机（m5/g5）1:1 移植 =====
// 状态码（g5.c.q()）：90=排队 91=探测 92=下载中 95=等待网络 80=已暂停 100=完成 200=失败
export const ENGINE_STATE_QUEUED: number = 90
export const ENGINE_STATE_PROBING: number = 91
export const ENGINE_STATE_DOWNLOADING: number = 92
export const ENGINE_STATE_WAIT_RETRY: number = 95
export const ENGINE_STATE_PAUSED: number = 80
export const ENGINE_STATE_COMPLETED: number = 100
export const ENGINE_STATE_FAILED: number = 200

// g5.b：状态判定
export function engineStateIsCompleted(state: number): boolean {
  return state >= 100 && state < 200
}

export function engineStateIsFailed(state: number): boolean {
  return state >= 200 && state < 300
}

export function engineStateIsPaused(state: number): boolean {
  return state === ENGINE_STATE_PAUSED
}

export function engineStateIsActive(state: number): boolean {
  return state > 0 && state < 100 && state !== ENGINE_STATE_PAUSED
}

// 状态→旧 downloads.status 列映射（页面兼容显示）
function statusOfState(state: number): DownloadStatus {
  if (engineStateIsCompleted(state)) {
    return DownloadStatus.Completed
  }
  if (engineStateIsFailed(state)) {
    return DownloadStatus.Failed
  }
  if (engineStateIsPaused(state)) {
    return DownloadStatus.Paused
  }
  return DownloadStatus.Running
}

// ===== m5.h：下载错误（code + message） =====
export class DownloadErr {
  readonly code: number
  readonly message: string

  constructor(code: number, message: string) {
    this.code = code
    this.message = message
  }

  // m5.h.b()：错误码文案
  static textOf(code: number): string {
    switch (code) {
      case 1:
        return 'User Cancel'
      case 2:
        return 'Unsupported Protocol'
      case 11:
        return 'Can Not Create File'
      case 12:
        return 'Can Not Write File'
      case 20:
        return 'Http Data Error'
      case 21:
        return 'Http Bad Request'
      case 22:
        return 'Certificate Error'
      case 23:
        return 'Network Timeout'
      case 24:
        return 'Non Resumable'
      case 25:
        return 'Too Many Redirects'
      case 30:
        return 'Task Submit Failed'
      case 31:
        return 'Chunk Verify Failed'
      case 32:
        return 'No Network Connection'
      case 40:
        return 'Decode Error'
      default:
        return ''
    }
  }

  static make(code: number, message: string = ''): DownloadErr {
    const text = message !== '' ? message : DownloadErr.textOf(code)
    return new DownloadErr(code, text)
  }

  static httpError(code: number, message: string): DownloadErr {
    return new DownloadErr(code, `HTTP Error: ${code} ${message}`)
  }

  // m5.h.e()：可重试错误（500/503/20/31）
  isRetryable(): boolean {
    return this.code === 503 || this.code === 500 || this.code === 20 || this.code === 31
  }
}

// ===== l5.c：MIME/扩展名表 1:1 =====
const MIME_EXT_PAIRS: string[] = [
  'aac', 'audio/aac', 'abw', 'application/x-abiword', 'apk', 'application/vnd.android.package-archive',
  'xapk', 'application/xapk-package-archive', 'arc', 'application/x-freearc', 'asf', 'video/x-ms-asf',
  'avi', 'video/x-msvideo', 'azw', 'application/vnd.amazon.ebook', 'bin', 'application/octet-stream',
  'bmp', 'image/bmp', 'bz', 'application/x-bzip', 'bz2', 'application/x-bzip2', 'bzip2', 'application/x-bzip2',
  'csh', 'application/x-csh', 'css', 'text/css', 'csv', 'text/csv', 'doc', 'application/msword',
  'docx', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document',
  'eot', 'application/vnd.ms-fontobject', 'epub', 'application/epub+zip', 'exe', 'application/octet-stream',
  'gif', 'image/gif', 'gtar', 'application/x-gtar', 'gz', 'application/x-gzip', 'htm', 'text/html',
  'html', 'text/html', 'mht', 'multipart/related', 'ico', 'image/vnd.microsoft.icon', 'ics', 'text/calendar',
  'jar', 'application/java-archive', 'jpeg', 'image/jpeg', 'jpg', 'image/jpeg', 'js', 'text/javascript',
  'json', 'application/json', 'jsonld', 'application/ld+json', 'mid', 'audio/midi', 'midi', 'audio/x-midi',
  'mjs', 'text/javascript', 'mov', 'video/quicktime', 'mpc', 'application/vnd.mpohun.certificate',
  'mpe', 'video/mpeg', 'mpeg', 'video/mpeg', 'mpg', 'video/mpeg', 'mpga', 'audio/mpeg',
  'mp4', 'video/mp4', 'mpkg', 'application/vnd.apple.installer+xml', 'mp2', 'audio/x-mpeg',
  'mp3', 'audio/mpeg', 'm3u', 'audio/x-mpegurl', 'm4a', 'audio/mp4a-latm', 'm4b', 'audio/mp4a-latm',
  'm4p', 'audio/mp4a-latm', 'm4u', 'video/vnd.mpegurl', 'm4v', 'video/x-m4v',
  'odp', 'application/vnd.oasis.opendocument.presentation',
  'ods', 'application/vnd.oasis.opendocument.spreadsheet',
  'odt', 'application/vnd.oasis.opendocument.text',
  'oga', 'audio/ogg', 'ogg', 'audio/ogg', 'ogv', 'video/ogg', 'ogx', 'application/ogg',
  'otf', 'font/otf', 'png', 'image/png', 'pdf', 'application/pdf', 'pps', 'application/vnd.ms-powerpoint',
  'ppt', 'application/vnd.ms-powerpoint',
  'pptx', 'application/vnd.openxmlformats-officedocument.presentationml.presentation',
  'rar', 'application/x-rar-compressed', 'rmvb', 'audio/x-pn-realaudio', 'rtf', 'application/rtf',
  'sh', 'application/x-sh', 'svg', 'image/svg+xml', 'swf', 'application/x-shockwave-flash',
  'tar', 'application/x-tar', 'tgz', 'application/x-compressed', 'tif', 'image/tiff', 'tiff', 'image/tiff',
  'torrent', 'application/x-bittorrent', 'ttf', 'font/ttf', 'txt', 'text/plain', 'vsd', 'application/vnd.visio',
  'wav', 'audio/wav', 'weba', 'audio/webm', 'webm', 'video/webm', 'webp', 'image/webp',
  'wma', 'audio/x-ms-wma', 'wmv', 'audio/x-ms-wmv', 'woff', 'font/woff', 'woff2', 'font/woff2',
  'wps', 'application/vnd.ms-works', 'xhtml', 'application/xhtml+xml', 'xls', 'application/vnd.ms-excel',
  'xlsx', 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet', 'xml', 'text/xml',
  'xul', 'application/vnd.mozilla.xul+xml', 'z', 'application/x-compress', 'zip', 'application/zip',
  '3gp', 'video/3gpp', '3g2', 'video/3gpp2', '7z', 'application/x-7z-compressed'
]

// l5.c.e()：扩展名→表下标
function mimeIndexOfExt(ext: string): number {
  if (ext === '') {
    return -1
  }
  const lower = ext.toLowerCase()
  for (let i = 0; i < MIME_EXT_PAIRS.length; i += 2) {
    if (MIME_EXT_PAIRS[i] === lower) {
      return i
    }
  }
  return -1
}

// l5.c.f()：MIME→表下标
function extIndexOfMime(mime: string): number {
  if (mime === '') {
    return -1
  }
  const lower = mime.toLowerCase()
  for (let i = 1; i < MIME_EXT_PAIRS.length; i += 2) {
    if (MIME_EXT_PAIRS[i] === lower) {
      return i
    }
  }
  return -1
}

// l5.c.b()：MIME→扩展名
export function extOfMime(mime: string): string | null {
  if (mime !== '') {
    const index = extIndexOfMime(mime)
    if (index > 0) {
      return MIME_EXT_PAIRS[index - 1]
    }
  }
  return null
}

// l5.c.c()：扩展名→MIME（找不到回退 fallback）
export function mimeOfExt(ext: string, fallback: string): string {
  if (ext === '') {
    return fallback
  }
  const index = mimeIndexOfExt(ext)
  if (index > 0) {
    return MIME_EXT_PAIRS[index + 1]
  }
  return fallback
}

// l5.c.g()
export function isKnownExt(ext: string): boolean {
  return mimeIndexOfExt(ext) >= 0
}

// l5.b.d()
function looksLikeHtml(mime: string, ext: string): boolean {
  return mime === 'text/html' || ext === 'html' || ext === 'htm'
}

// l5.b.e()：Content-Disposition 文件名解析
function fileNameFromDisposition(disposition: string): string | null {
  let index = disposition.indexOf('filename*=')
  if (index < 0) {
    index = disposition.indexOf('filename')
  }
  if (disposition === '' || index < 0) {
    return null
  }
  let name = disposition.substring(index)
  while (true) {
    const semi = name.lastIndexOf(';')
    if (semi <= 0) {
      break
    }
    name = name.substring(0, semi).trim()
  }
  const eq = name.indexOf('=')
  if (eq > 0) {
    name = name.substring(eq + 1).trim()
    const charset = name.indexOf('\'\'')
    if (charset > 0) {
      name = name.substring(charset + 2).trim()
    }
    const lang = name.indexOf('\' \'')
    if (lang > 0) {
      name = name.substring(lang + 3).trim()
    }
  }
  if (name === '') {
    return null
  }
  if (name.charAt(0) === '"' || name.charAt(0) === '\'') {
    name = name.substring(1)
  }
  let end = name.length - 1
  while (end >= 0 && (name.charAt(end) === '"' || name.charAt(end) === '\'')) {
    end--
  }
  const result = name.substring(0, end + 1)
  if (result === '') {
    return null
  }
  return result.indexOf('%') > 0 ? decodeURIComponent(result) : result
}

// l5.b.b()：URL/Disposition/MIME 综合猜文件名
export function guessFileName(url: string, disposition: string, mime: string): string {
  let base: string | null = null
  if (disposition !== '') {
    base = fileNameFromDisposition(disposition)
  }
  if (base === null) {
    let u = url
    const query = u.indexOf('?')
    if (query > 0) {
      u = u.substring(0, query)
    }
    if (!u.endsWith('/')) {
      const slash = u.lastIndexOf('/') + 1
      if (slash > 0) {
        base = u.substring(slash)
      }
    }
  }
  if (base !== null && base.indexOf('%') >= 0) {
    try {
      base = decodeURIComponent(base)
    } catch (error) {
    }
  }
  if (base === null) {
    base = 'downloadfile'
  }
  const dot = base.lastIndexOf('.')
  if (dot < 0) {
    let ext: string | null = null
    if (mime !== '') {
      ext = extOfMime(mime)
      if (ext === null && mime.startsWith('image/')) {
        ext = 'png'
      }
    }
    if (ext === null || ext === 'bin') {
      ext = ''
    }
    return ext === '' ? base : `${base}.${ext}`
  }
  return base
}

// l5.b.f()：Content-Range 总长解析
function totalFromContentRange(range: string): number {
  if (range === '') {
    return -1
  }
  const body = range.substring(6)
  const slash = body.indexOf('/')
  const dash = body.indexOf('-')
  const parseLong = (text: string): number => {
    const value = Number(text)
    return Number.isFinite(value) && value >= 0 ? value : -1
  }
  if (slash > 0) {
    const after = body.substring(slash + 1)
    if (after !== '*') {
      return parseLong(after)
    }
  }
  if (!body.startsWith('*') && dash > 0) {
    const before = body.substring(0, dash)
    const endText = slash > 0 ? body.substring(dash + 1, slash) : body.substring(dash + 1)
    const total = parseLong(endText) - parseLong(before) + 1
    return total < 0 ? -1 : total
  }
  return -1
}

// ===== g5.a：分块 =====
class EngineChunk {
  id: number
  taskId: number
  start: number
  length: number
  downloaded: number
  speed: number

  constructor(id: number, taskId: number, start: number, length: number, downloaded: number) {
    this.id = id
    this.taskId = taskId
    this.start = start
    this.length = length
    this.downloaded = downloaded
    this.speed = 0
  }
}

// ===== g5.c：任务（镜像 downloads 行） =====
class EngineTask {
  rec: DownloadRec
  chunks: EngineChunk[] = []
  // flags 位：1=支持断点续传(v) 2=已探测(u) 4=允许按类型改名(T)
  flags: number
  threads: number
  headers: Record<string, string> = {}

  constructor(rec: DownloadRec) {
    this.rec = rec
    this.flags = rec.flags
    this.threads = rec.chunks > 0 ? rec.chunks : 1
    if (rec.header !== '') {
      try {
        const parsed: object = JSON.parse(rec.header)
        const record = parsed as Record<string, string>
        const keys = Object.keys(record)
        for (let i = 0; i < keys.length; i++) {
          this.headers[keys[i]] = record[keys[i]]
        }
      } catch (error) {
      }
    }
  }

  isResumable(): boolean {
    return (this.flags & 1) === 1
  }

  setResumable(value: boolean): void {
    if (value) {
      this.flags |= 1
    } else {
      this.flags &= ~1
    }
  }

  isProbed(): boolean {
    return (this.flags & 2) === 2
  }

  setProbed(value: boolean): void {
    if (value) {
      this.flags |= 2
    } else {
      this.flags &= ~2
    }
  }

  canRename(): boolean {
    return (this.flags & 4) === 4
  }

  setRename(value: boolean): void {
    if (value) {
      this.flags |= 4
    } else {
      this.flags &= ~4
    }
  }

  headerOf(key: string): string {
    const keys = Object.keys(this.headers)
    for (let i = 0; i < keys.length; i++) {
      if (keys[i].toLowerCase() === key.toLowerCase()) {
        return this.headers[keys[i]]
      }
    }
    return ''
  }

  setHeader(key: string, value: string): void {
    const keys = Object.keys(this.headers)
    for (let i = 0; i < keys.length; i++) {
      if (keys[i].toLowerCase() === key.toLowerCase()) {
        this.headers[keys[i]] = value
        return
      }
    }
    this.headers[key] = value
  }

  // ArkTS 禁用 delete，按 key 移除请求头
  removeHeader(key: string): void {
    const keys = Object.keys(this.headers)
    const next: Record<string, string> = {}
    for (let i = 0; i < keys.length; i++) {
      if (keys[i].toLowerCase() !== key.toLowerCase()) {
        next[keys[i]] = this.headers[keys[i]]
      }
    }
    this.headers = next
  }

  downloadedSize(): number {
    let sum = 0
    for (let i = 0; i < this.chunks.length; i++) {
      sum += this.chunks[i].downloaded
    }
    return sum
  }

  headerJson(): string {
    return JSON.stringify(this.headers)
  }
}

// 响应头取值（headersReceive 回调对象大小写不敏感）
function headerValue(headers: Record<string, string>, key: string): string {
  const keys = Object.keys(headers)
  for (let i = 0; i < keys.length; i++) {
    if (keys[i].toLowerCase() === key.toLowerCase()) {
      return headers[keys[i]]
    }
  }
  return ''
}

function parseLong(value: string): number {
  const num = Number(value)
  return Number.isFinite(num) && num >= 0 ? num : -1
}

// m5.e：相对 Location 解析为绝对地址（协议相对 //、根相对 /、目录相对）
function resolveLocation(base: string, location: string): string {
  const trimmed = location.trim()
  if (trimmed === '') {
    return ''
  }
  if (trimmed.startsWith('http://') || trimmed.startsWith('https://')) {
    return trimmed
  }
  const schemeIndex = base.indexOf('://')
  if (schemeIndex < 0) {
    return ''
  }
  const scheme = base.substring(0, schemeIndex)
  if (trimmed.startsWith('//')) {
    return `${scheme}:${trimmed}`
  }
  const authorityEnd = base.indexOf('/', schemeIndex + 3)
  const origin = authorityEnd < 0 ? base : base.substring(0, authorityEnd)
  if (trimmed.startsWith('/')) {
    return `${origin}${trimmed}`
  }
  const noQuery = base.split('#')[0].split('?')[0]
  const dirEnd = noQuery.lastIndexOf('/')
  if (dirEnd < 0) {
    return `${origin}/${trimmed}`
  }
  return `${noQuery.substring(0, dirEnd + 1)}${trimmed}`
}

function sleep(ms: number): Promise<void> {
  return new Promise<void>((resolve: () => void) => {
    setTimeout(resolve, ms)
  })
}

// ===== m5.d：分块下载器 =====
class ChunkDownloader {
  private task: EngineTask
  private chunk: EngineChunk
  private runner: TaskRunner
  private cancelled: boolean = false
  private speedLastTime: number = 0
  private speedLastBytes: number = 0
  private persistLastTime: number = 0
  private persistLastBytes: number = 0

  constructor(task: EngineTask, chunk: EngineChunk, runner: TaskRunner) {
    this.task = task
    this.chunk = chunk
    this.runner = runner
  }

  cancel(): void {
    this.cancelled = true
  }

  async run(): Promise<DownloadErr | null> {
    // m5.d.f()：分块已完成直接成功
    if (this.chunk.length > 0 && this.chunk.downloaded === this.chunk.length) {
      return null
    }
    if (!this.task.isResumable()) {
      this.chunk.downloaded = 0
    }
    this.speedLastTime = Date.now()
    this.speedLastBytes = this.chunk.downloaded
    this.persistLastTime = Date.now()
    this.persistLastBytes = this.chunk.downloaded
    return this.doRequest()
  }

  // m5.d.g()+j()：发起带 Range 的流式请求并落盘
  private async doRequest(): Promise<DownloadErr | null> {
    if (!connection.hasDefaultNet()) {
      return DownloadErr.make(32)
    }
    const resuming = this.chunk.downloaded > 0
    const session = http.createHttp()
    this.runner.addSession(session)
    const headers: Record<string, string> = {}
    const taskHeaders = Object.keys(this.task.headers)
    for (let i = 0; i < taskHeaders.length; i++) {
      headers[taskHeaders[i]] = this.task.headers[taskHeaders[i]]
    }
    headers['Accept-Encoding'] = 'identity'
    if (this.chunk.length > 0) {
      headers['Range'] = `bytes=${this.chunk.start + this.chunk.downloaded}-${this.chunk.start + this.chunk.length - 1}`
      const etag = this.task.headerOf('ETag')
      if (resuming && etag !== '') {
        headers['If-Match'] = etag
      }
    }
    const finished: Promise<DownloadErr | null> = new Promise<DownloadErr | null>((resolve: (v: DownloadErr | null) => void) => {
      let responseHeaders: Record<string, string> = {}
      let resolved = false
      const finish = (err: DownloadErr | null): void => {
        if (!resolved) {
          resolved = true
          resolve(err)
        }
      }
      session.on('headersReceive', (header: Object) => {
        responseHeaders = header as Record<string, string>
      })
      session.on('dataReceive', (data: ArrayBuffer) => {
        if (this.cancelled || this.runner.isCancelled()) {
          session.destroy()
          return
        }
        const err = this.writeData(data, responseHeaders)
        if (err !== null) {
          session.destroy()
          finish(err)
        }
      })
      session.on('dataEnd', () => {
        const err = this.verifyDone(responseHeaders)
        finish(err)
      })
      const options: http.HttpRequestOptions = {
        method: http.RequestMethod.GET,
        header: headers,
        expectDataType: http.HttpDataType.ARRAY_BUFFER,
        readTimeout: 60000,
        connectTimeout: 60000
      }
      session.requestInStream(this.task.rec.url, options).then((code: number) => {
        if (resolved) {
          return
        }
        // m5.d.a.c()：206=续传成功；200=仅允许非续传场景，否则 24 不可续传
        if (code !== 200 && code !== 206) {
          finish(DownloadErr.httpError(code, ''))
          return
        }
        if (code === 200 && resuming) {
          finish(DownloadErr.make(24))
          return
        }
        if (code === 200 && this.chunk.length > 0 && !this.task.isResumable() && this.chunk.start > 0) {
          finish(DownloadErr.make(24))
          return
        }
      }).catch((error: BusinessError) => {
        if (this.cancelled || this.runner.isCancelled()) {
          finish(DownloadErr.make(1))
          return
        }
        finish(this.mapHttpError(error))
      })
    })
    const err = await finished
    this.runner.removeSession(session)
    session.destroy()
    if (err !== null) {
      return err
    }
    if (this.cancelled || this.runner.isCancelled()) {
      return DownloadErr.make(1)
    }
    return null
  }

  // m5.d.j()：Content-Length 校验（可续传且起始为 0 时学习总长）
  private verifyLength(responseHeaders: Record<string, string>): DownloadErr | null {
    const contentLength = parseLong(headerValue(responseHeaders, 'Content-Length'))
    const mayLearn = this.chunk.length <= 0 && this.chunk.start === 0 &&
      headerValue(responseHeaders, 'Transfer-Encoding') === ''
    if (contentLength < 0 && mayLearn) {
      return DownloadErr.make(24)
    }
    if (this.chunk.length > 0 && contentLength > this.chunk.length - this.chunk.downloaded) {
      return DownloadErr.make(24)
    }
    if (mayLearn && contentLength > 0) {
      this.chunk.length = contentLength
    } else if (mayLearn) {
      return DownloadErr.make(24)
    }
    return null
  }

  private writeData(data: ArrayBuffer, responseHeaders: Record<string, string>): DownloadErr | null {
    if (this.chunk.length <= 0 && this.chunk.start === 0) {
      // 首块响应若能从 Content-Range 解析出总大小，回填切回真实进度条
      const rangeTotal = totalFromContentRange(headerValue(responseHeaders, 'Content-Range'))
      if (rangeTotal > 0) {
        this.chunk.length = rangeTotal
        this.task.rec.size = rangeTotal
      } else {
        const learnErr = this.verifyLength(responseHeaders)
        if (learnErr !== null) {
          return learnErr
        }
      }
    }
    const err = this.runner.writeChunk(this.chunk, data)
    if (err !== null) {
      return err
    }
    this.chunk.downloaded += data.byteLength
    this.trackProgress(false)
    return null
  }

  private verifyDone(responseHeaders: Record<string, string>): DownloadErr | null {
    this.trackProgress(true)
    if (this.chunk.length <= 0 || Math.abs(this.chunk.downloaded - this.chunk.length) <= 1) {
      return null
    }
    return DownloadErr.make(31)
  }

  // m5.d.k()：速度平滑 + 周期持久化/上报
  private trackProgress(final: boolean): void {
    const now = Date.now()
    const bytes = this.chunk.downloaded
    const sinceSpeed = now - this.speedLastTime
    if (sinceSpeed > 500) {
      let speed = Math.floor((bytes - this.speedLastBytes) * 1000 / sinceSpeed)
      if (this.chunk.speed !== 0) {
        speed = Math.floor((this.chunk.speed * 3 + speed) / 4)
      }
      this.chunk.speed = speed
      this.speedLastTime = now
      this.speedLastBytes = bytes
    }
    if (now - this.persistLastTime <= 1000 && !final) {
      return
    }
    this.persistLastBytes = bytes
    this.persistLastTime = now
    this.runner.onChunkProgress(this.chunk, final)
  }

  // m5.d 回调错误映射
  private mapHttpError(error: BusinessError): DownloadErr {
    if (error.code === 2300028) {
      return DownloadErr.make(23)
    }
    return DownloadErr.make(20, error.message)
  }
}

// ===== m5.e：任务执行器（探测→分块→聚合） =====
class TaskRunner {
  private task: EngineTask
  private engine: DownloadEngine
  private cancelled: boolean = false
  private sessions: http.HttpRequest[] = []
  private file: fileIo.File | null = null

  constructor(task: EngineTask, engine: DownloadEngine) {
    this.task = task
    this.engine = engine
  }

  isCancelled(): boolean {
    return this.cancelled
  }

  cancel(): void {
    this.cancelled = true
    for (let i = 0; i < this.sessions.length; i++) {
      this.sessions[i].destroy()
    }
  }

  addSession(session: http.HttpRequest): void {
    this.sessions.push(session)
  }

  removeSession(session: http.HttpRequest): void {
    const index = this.sessions.indexOf(session)
    if (index >= 0) {
      this.sessions.splice(index, 1)
    }
  }

  // k5.c 写入：定位写分块数据
  writeChunk(chunk: EngineChunk, data: ArrayBuffer): DownloadErr | null {
    try {
      if (this.file === null) {
        return DownloadErr.make(12)
      }
      fileIo.writeSync(this.file.fd, data, { offset: Math.floor(chunk.start + chunk.downloaded) })
      return null
    } catch (error) {
      return DownloadErr.make(12)
    }
  }

  // m5.d.k() 持久化回调
  onChunkProgress(chunk: EngineChunk, final: boolean): void {
    this.task.rec.received = this.task.downloadedSize()
    let speed = 0
    for (let i = 0; i < this.task.chunks.length; i++) {
      speed += this.task.chunks[i].speed
    }
    this.task.rec.speed = speed
    this.task.rec.updatedAt = Date.now()
    this.engine.persistChunk(chunk)
    this.engine.persistTask(this.task)
    this.engine.notifyTaskChanged(this.task)
    if (final) {
      this.engine.persistChunk(chunk)
    }
  }

  // m5.e.call()：主流程
  async run(): Promise<void> {
    const task = this.task
    let err: DownloadErr | null = null
    if (engineStateIsCompleted(task.rec.state) || engineStateIsFailed(task.rec.state)) {
      this.engine.onTaskFinished(task, null)
      return
    }
    if (!task.isProbed()) {
      this.engine.setTaskState(task, ENGINE_STATE_PROBING)
      // m5.e：先解析重定向拿最终地址，再探测
      err = await this.resolveRedirects()
      if (err === null) {
        err = await this.probe()
      }
    }
    if (err === null) {
      this.engine.setTaskState(task, ENGINE_STATE_DOWNLOADING)
      this.openFile()
      err = await this.execute()
      if (err !== null) {
        // m5.e.call()：24/416 时降为单线程重试；4xx 时单线程重试
        if ((err.code === 24 || err.code === 416) && !(task.isResumable() && task.threads === 1)) {
          task.setResumable(false)
          task.threads = 1
        } else if (err.code >= 400 && err.code < 500 && task.threads !== 1) {
          task.threads = 1
        } else {
          this.closeFile()
          this.engine.onTaskFinished(task, err)
          return
        }
        await this.engine.clearChunks(task)
        this.openFile()
        err = await this.execute()
      }
      this.closeFile()
    }
    if (err === null) {
      this.engine.setTaskState(task, ENGINE_STATE_COMPLETED)
      this.engine.onTaskCompleted(task)
      return
    }
    if (err.code === 1) {
      this.engine.setTaskState(task, ENGINE_STATE_PAUSED)
    } else if (err.code === 32) {
      this.engine.setTaskState(task, ENGINE_STATE_WAIT_RETRY)
    } else {
      task.rec.errorMessage = err.message
      this.engine.setTaskState(task, ENGINE_STATE_FAILED)
    }
    this.engine.onTaskFinished(task, err)
  }

  private openFile(): void {
    try {
      if (!fileIo.accessSync(this.task.rec.path)) {
        this.file = fileIo.openSync(this.task.rec.path,
          fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE | fileIo.OpenMode.TRUNC)
      } else {
        this.file = fileIo.openSync(this.task.rec.path, fileIo.OpenMode.READ_WRITE)
      }
    } catch (error) {
      this.file = null
    }
  }

  private closeFile(): void {
    if (this.file !== null) {
      try {
        fileIo.closeSync(this.file)
      } catch (error) {
      }
      this.file = null
    }
  }

  // m5.e：重定向解析——maxRedirects=0（API 23+）关闭自动跟随，3xx 读 Location 逐跳手动跟随（上限 20 跳）
  // 低于 API 23 的设备忽略 maxRedirects 字段自动跟随，headersReceive 收到最终响应头无 Location，首跳即退出（降级为原路径）
  private async resolveRedirects(): Promise<DownloadErr | null> {
    if (!connection.hasDefaultNet()) {
      return DownloadErr.make(32)
    }
    const task = this.task
    let current = task.rec.url
    for (let hop = 0; hop < 20; hop++) {
      if (this.cancelled) {
        return DownloadErr.make(1)
      }
      const session = http.createHttp()
      this.addSession(session)
      const headers: Record<string, string> = {}
      const taskHeaders = Object.keys(task.headers)
      for (let i = 0; i < taskHeaders.length; i++) {
        headers[taskHeaders[i]] = task.headers[taskHeaders[i]]
      }
      headers['Accept-Encoding'] = 'identity'
      let location = ''
      let gotHeaders = false
      const gotHeaderPromise: Promise<void> = new Promise<void>((resolve: () => void) => {
        session.on('headersReceive', (header: Object) => {
          location = headerValue(header as Record<string, string>, 'Location')
          gotHeaders = true
          resolve()
        })
      })
      const options: http.HttpRequestOptions = {
        method: http.RequestMethod.GET,
        header: headers,
        expectDataType: http.HttpDataType.ARRAY_BUFFER,
        readTimeout: 30000,
        connectTimeout: 30000,
        maxRedirects: 0
      }
      const done: Promise<void> = session.requestInStream(current, options)
        .then((): void => {
        }, (): void => {
        })
      await Promise.race([gotHeaderPromise, done])
      session.destroy()
      this.removeSession(session)
      if (this.cancelled) {
        return DownloadErr.make(1)
      }
      if (!gotHeaders || location === '') {
        break
      }
      if (hop === 19) {
        return DownloadErr.make(25)
      }
      const next = resolveLocation(current, location)
      if (next === '') {
        return DownloadErr.make(2)
      }
      current = next
    }
    if (current !== task.rec.url) {
      task.rec.url = current
    }
    return null
  }

  // m5.e.j()+q()：HEAD 探测（Range: bytes=0-0），修正文件名/MIME/总长/ETag/线程数
  private async probe(): Promise<DownloadErr | null> {
    if (!connection.hasDefaultNet()) {
      return DownloadErr.make(32)
    }
    const session = http.createHttp()
    this.addSession(session)
    const headers: Record<string, string> = {}
    const taskHeaders = Object.keys(this.task.headers)
    for (let i = 0; i < taskHeaders.length; i++) {
      headers[taskHeaders[i]] = this.task.headers[taskHeaders[i]]
    }
    headers['Range'] = 'bytes=0-0'
    let responseHeaders: Record<string, string> = {}
    const gotHeaders: Promise<boolean> = new Promise<boolean>((resolve: (v: boolean) => void) => {
      session.on('headersReceive', (header: Object) => {
        responseHeaders = header as Record<string, string>
        resolve(true)
      })
    })
    const options: http.HttpRequestOptions = {
      method: http.RequestMethod.GET,
      header: headers,
      expectDataType: http.HttpDataType.ARRAY_BUFFER,
      readTimeout: 30000,
      connectTimeout: 30000
    }
    const result: Promise<number> = session.requestInStream(this.task.rec.url, options)
    result.then((): void => {
    }, (): void => {
    })
    // 头到达或请求结束（失败）都放行，避免挂起
    await Promise.race([gotHeaders, result.then((): boolean => true).catch((): boolean => true)])
    // 206 → 支持 Range；200 → 服务器忽略 Range，立即中断避免拉全量
    const supportsRange = headerValue(responseHeaders, 'Content-Range') !== ''
    if (!supportsRange) {
      session.destroy()
      this.removeSession(session)
      return this.applyProbeResult(200, responseHeaders)
    }
    let code = 0
    try {
      code = await result
    } catch (error) {
      this.removeSession(session)
      session.destroy()
      if (this.cancelled) {
        return DownloadErr.make(1)
      }
      const be = error as BusinessError
      return DownloadErr.make(20, be.message)
    }
    this.removeSession(session)
    session.destroy()
    if (code !== 206 && code !== 200) {
      return DownloadErr.httpError(code, '')
    }
    return this.applyProbeResult(code, responseHeaders)
  }

  // m5.e.q()：应用探测结果
  private applyProbeResult(code: number, responseHeaders: Record<string, string>): DownloadErr | null {
    const task = this.task
    if (code !== 200 && code !== 206) {
      return DownloadErr.httpError(code, '')
    }
    let contentType = headerValue(responseHeaders, 'Content-Type')
    const semi = contentType.indexOf(';')
    if (semi > 0) {
      contentType = contentType.substring(0, semi).trim().toLowerCase()
    }
    let ext = extOfMime(contentType)
    if (contentType === '' || contentType === 'application/octet-stream') {
      const disposition = headerValue(responseHeaders, 'Content-Disposition')
      const guessed = guessFileName(task.rec.url, disposition, '')
      const dot = guessed.lastIndexOf('.')
      if (dot >= 0) {
        ext = guessed.substring(dot + 1)
        contentType = mimeOfExt(ext, contentType)
      }
    }
    const html = looksLikeHtml(contentType, ext === null ? '' : ext)
    if (html !== (task.rec.mime === 'text/html')) {
      // 修正文件名扩展（m5.e.q() T() 分支）
      if (task.canRename() && contentType !== '' && contentType !== task.rec.mime) {
        let name = this.baseName()
        if (ext !== null && ext !== '' && ext !== 'bin') {
          const dot = name.lastIndexOf('.')
          if (dot >= 0) {
            name = `${name.substring(0, dot + 1)}${ext}`
          } else {
            name = `${name}.${ext}`
          }
        }
        task.rec.path = `${this.engine.saveDirOf()}/${name}`
      }
      let total = parseLong(headerValue(responseHeaders, 'Content-Length'))
      if (headerValue(responseHeaders, 'Transfer-Encoding') !== '') {
        total = -1
      }
      if (total === -1) {
        total = totalFromContentRange(headerValue(responseHeaders, 'Content-Range'))
      }
      const acceptRanges = headerValue(responseHeaders, 'Accept-Ranges').toLowerCase() === 'bytes' ||
        headerValue(responseHeaders, 'Content-Range') !== ''
      task.setResumable(acceptRanges)
      if (html) {
        total = -1
        task.setResumable(false)
      }
      task.rec.size = total
      const etag = headerValue(responseHeaders, 'ETag')
      if (etag !== '') {
        task.setHeader('ETag', etag)
      }
      task.setProbed(true)
      if (task.rec.size <= 0 || !task.isResumable()) {
        task.threads = 1
        task.setResumable(false)
      } else {
        task.threads = Math.min(Math.max(1, task.threads),
          Math.max(1, Math.ceil(task.rec.size / 1048576)))
      }
    }
    return null
  }

  private baseName(): string {
    const path = this.task.rec.path
    const slash = path.lastIndexOf('/')
    return slash >= 0 ? path.substring(slash + 1) : path
  }

  // m5.e.i()+n()+r()
  private async execute(): Promise<DownloadErr | null> {
    if (this.cancelled) {
      return DownloadErr.make(1)
    }
    const task = this.task
    // n()：优先读库中分块，否则生成
    let chunks = await this.engine.loadChunks(task)
    if (chunks === null || chunks.length === 0) {
      const generated = this.generateChunks()
      await this.engine.saveChunks(task, generated)
      chunks = generated
    }
    task.chunks = chunks
    task.rec.received = task.downloadedSize()
    // r()：文件长度校验，不一致清零重下
    try {
      if (fileIo.accessSync(task.rec.path)) {
        const stat = fileIo.statSync(task.rec.path)
        const expected = task.isResumable() ? task.rec.size : 0
        if (stat.size !== expected) {
          if (stat.size <= 0) {
            await this.engine.resetChunks(task)
            for (let i = 0; i < task.chunks.length; i++) {
              task.chunks[i].downloaded = 0
            }
          }
        }
      }
    } catch (error) {
      return DownloadErr.make(12)
    }
    return this.runChunks(task.chunks.slice())
  }

  // m5.e.m()：生成分块
  private generateChunks(): EngineChunk[] {
    const task = this.task
    const list: EngineChunk[] = []
    if (task.rec.size <= 0 || !task.isResumable()) {
      list.push(new EngineChunk(0, task.rec.id, 0, 0, 0))
      return list
    }
    const per = Math.floor(task.rec.size / task.threads)
    for (let i = 0; i < task.threads; i++) {
      const start = i * per
      const length = i === task.threads - 1 ? task.rec.size - start : per
      list.push(new EngineChunk(0, task.rec.id, start, length, 0))
    }
    return list
  }

  // m5.e.h()：并发执行分块（重试预算=分块数*2，轮间 300ms）
  private async runChunks(pending: EngineChunk[]): Promise<DownloadErr | null> {
    const task = this.task
    let retries = pending.length * 2
    // 原版 h()：每失败一次并发减一，最低 1
    let maxConnections = pending.length
    let queue = pending
    while (queue.length > 0 && retries > 0) {
      if (this.cancelled) {
        return DownloadErr.make(1)
      }
      const batch = queue.slice(0, Math.min(maxConnections, queue.length))
      const rest = queue.slice(batch.length)
      if (batch.length === 0) {
        return DownloadErr.make(30)
      }
      const downloaders: ChunkDownloader[] = []
      for (let i = 0; i < batch.length; i++) {
        downloaders.push(new ChunkDownloader(task, batch[i], this))
      }
      const results: (DownloadErr | null)[] = await Promise.all(downloaders.map(
        (downloader: ChunkDownloader): Promise<DownloadErr | null> => downloader.run()))
      queue = rest
      let failErr: DownloadErr | null = null
      const retryQueue: EngineChunk[] = []
      for (let i = 0; i < batch.length; i++) {
        const err = results[i]
        if (err !== null) {
          retries--
          if (maxConnections > 1) {
            maxConnections--
          }
          failErr = err
          if (err.isRetryable() && !this.cancelled) {
            retryQueue.push(batch[i])
          } else {
            // 不可重试错误：取消其余分块并终止
            for (let d = 0; d < downloaders.length; d++) {
              downloaders[d].cancel()
            }
            return err
          }
        }
      }
      queue = retryQueue.concat(queue)
      if (queue.length > 0 && retries > 0) {
        await sleep(300)
      }
      if (failErr !== null && queue.length === 0) {
        return failErr
      }
    }
    if (queue.length > 0 && retries <= 0) {
      return DownloadErr.make(30)
    }
    return null
  }
}

// ===== m5.i + f5：调度器与引擎 =====
export class DownloadEngine {
  private static instance: DownloadEngine | null = null
  private db: BrowserDb = BrowserDb.getInstance()
  private runners: Map<number, TaskRunner> = new Map<number, TaskRunner>()
  private appContext: common.Context | null = null
  private saveDir: string = ''
  private started: boolean = false
  private taskChangeListeners: (() => void)[] = []

  static getInstance(): DownloadEngine {
    if (DownloadEngine.instance === null) {
      DownloadEngine.instance = new DownloadEngine()
    }
    return DownloadEngine.instance
  }

  init(context: common.Context): void {
    if (this.started) {
      return
    }
    this.started = true
    this.appContext = context
    this.saveDir = `${context.filesDir}/Download`
    try {
      if (!fileIo.accessSync(this.saveDir)) {
        fileIo.mkdirSync(this.saveDir)
      }
    } catch (error) {
      console.error('create engine download dir failed')
    }
    // 网络恢复时重排 95（等待网络）任务
    try {
      const conn = connection.createNetConnection()
      conn.on('netAvailable', () => {
        this.schedule()
      })
      conn.on('netUnavailable', () => {
        this.pauseWaitingTasks()
      })
      conn.register(() => {
      })
    } catch (error) {
      console.error('register engine net connection failed')
    }
  }

  saveDirOf(): string {
    return this.saveDir
  }

  addTaskChangeListener(listener: () => void): void {
    this.taskChangeListeners.push(listener)
  }

  notifyTaskChanged(task: EngineTask): void {
    for (let i = 0; i < this.taskChangeListeners.length; i++) {
      this.taskChangeListeners[i]()
    }
  }

  // m5.i.f()：新建任务入库并入队（threads：新建下载弹窗走原版 B3 的 8 线程，默认单线程）
  // cookie：网页内下载接管时注入 Web Cookie，保证登录态下载
  async createTask(url: string, fileName: string, referer: string, ua: string,
    threads: number = 1, cookie: string = ''): Promise<number> {
    const rec = new DownloadRec()
    rec.url = url
    rec.path = `${this.saveDir}/${fileName}`
    rec.mime = ''
    rec.size = 0
    rec.received = 0
    rec.status = DownloadStatus.Running
    rec.created = Date.now()
    rec.state = ENGINE_STATE_QUEUED
    rec.chunks = threads
    rec.flags = 4
    rec.updatedAt = Date.now()
    const headers: Record<string, string> = {}
    if (referer !== '') {
      headers['Referer'] = referer
    }
    if (ua !== '') {
      headers['User-Agent'] = ua
    }
    if (cookie !== '') {
      headers['Cookie'] = cookie
    }
    rec.header = JSON.stringify(headers)
    const id = await this.db.insertDownload(rec)
    rec.id = id
    this.schedule()
    return id
  }

  // m5.i.m()：入队/继续（90/95 之外的暂停、失败、完成均可重新入队）
  async resumeTask(rec: DownloadRec): Promise<void> {
    if (this.runners.has(rec.id)) {
      return
    }
    const task = new EngineTask(rec)
    if (rec.state !== ENGINE_STATE_QUEUED && rec.state !== ENGINE_STATE_WAIT_RETRY) {
      task.rec.state = ENGINE_STATE_QUEUED
      await this.db.updateEngineTask(task.rec)
    }
    this.schedule()
  }

  // 重新下载（原版 an）：清 ETag/探测标记，8 线程重下
  async restartTask(rec: DownloadRec): Promise<void> {
    const task = new EngineTask(rec)
    task.removeHeader('ETag')
    task.setProbed(false)
    task.threads = 8
    task.rec.state = ENGINE_STATE_QUEUED
    task.rec.received = 0
    task.rec.errorMessage = ''
    task.rec.header = task.headerJson()
    task.rec.chunks = task.threads
    await this.db.deleteChunks(rec.id)
    await this.db.updateEngineTask(task.rec)
    this.schedule()
  }

  // m5.i.j()：暂停
  async pauseTask(rec: DownloadRec): Promise<void> {
    const runner = this.runners.get(rec.id)
    if (runner !== undefined) {
      runner.cancel()
      return
    }
    if (rec.state > 0 && !engineStateIsCompleted(rec.state) && !engineStateIsPaused(rec.state)) {
      const task = new EngineTask(rec)
      task.rec.state = ENGINE_STATE_PAUSED
      await this.db.updateEngineTask(task.rec)
    }
  }

  // m5.i.k()：暂停全部
  async pauseAll(): Promise<void> {
    const states = [ENGINE_STATE_QUEUED, ENGINE_STATE_PROBING, ENGINE_STATE_DOWNLOADING, ENGINE_STATE_WAIT_RETRY]
    const tasks = await this.db.listDownloadsByState(states)
    for (let i = 0; i < tasks.length; i++) {
      const runner = this.runners.get(tasks[i].id)
      if (runner !== undefined) {
        runner.cancel()
      } else {
        tasks[i].state = ENGINE_STATE_PAUSED
        tasks[i].status = statusOfState(ENGINE_STATE_PAUSED)
        await this.db.updateEngineTask(tasks[i])
      }
    }
  }

  // ===== 按 id 操作（通知栏按钮 / 下载页）=====
  async getDownloadById(id: number): Promise<DownloadRec | null> {
    return await this.db.getDownloadById(id)
  }

  async pauseById(id: number): Promise<void> {
    const rec = await this.db.getDownloadById(id)
    if (rec !== null) {
      await this.pauseTask(rec)
    }
  }

  async resumeById(id: number): Promise<void> {
    const rec = await this.db.getDownloadById(id)
    if (rec !== null) {
      await this.resumeTask(rec)
    }
  }

  async restartById(id: number): Promise<void> {
    const rec = await this.db.getDownloadById(id)
    if (rec !== null) {
      await this.restartTask(rec)
    }
  }

  private async pauseWaitingTasks(): Promise<void> {
    // 网络断开时正在跑的任务会自行落 95/失败，这里仅触发调度
    this.schedule()
  }

  // m5.i.o()：调度（并发上限 3；90 先于 95；组内按 created 降序）
  async schedule(): Promise<void> {
    if (this.appContext === null || this.runners.size >= 3) {
      return
    }
    const states = [ENGINE_STATE_WAIT_RETRY, ENGINE_STATE_QUEUED]
    const tasks = await this.db.listDownloadsByState(states)
    // 比较器 b：state 升序（90 优先），created 降序
    tasks.sort((a: DownloadRec, b: DownloadRec): number => {
      if (a.state !== b.state) {
        return a.state < b.state ? -1 : 1
      }
      if (a.created !== b.created) {
        return a.created < b.created ? 1 : -1
      }
      return 0
    })
    for (let i = 0; i < tasks.length && this.runners.size < 3; i++) {
      if (this.runners.has(tasks[i].id)) {
        continue
      }
      const task = new EngineTask(tasks[i])
      const runner = new TaskRunner(task, this)
      this.runners.set(tasks[i].id, runner)
      runner.run().then(() => {
        this.runners.delete(tasks[i].id)
        this.schedule()
      }).catch(() => {
        this.runners.delete(tasks[i].id)
        this.schedule()
      })
    }
  }

  hasActiveTask(id: number): boolean {
    return this.runners.has(id)
  }

  // 状态流转（m5.e.p()）：持久化 + 通知
  setTaskState(task: EngineTask, state: number): void {
    if (task.rec.state === state) {
      return
    }
    task.rec.state = state
    task.rec.status = statusOfState(state)
    task.rec.updatedAt = Date.now()
    this.persistTask(task)
    this.notifyTaskChanged(task)
    DownloadNotifier.getInstance().notify(task.rec)
  }

  persistTask(task: EngineTask): void {
    task.rec.chunks = task.threads
    task.rec.flags = task.flags
    task.rec.header = task.headerJson()
    task.rec.status = statusOfState(task.rec.state)
    this.db.updateEngineTask(task.rec).catch(() => {
    })
  }

  persistChunk(chunk: EngineChunk): void {
    if (chunk.id > 0) {
      this.db.updateChunkDownloaded(chunk.id, chunk.downloaded).catch(() => {
      })
    }
  }

  async loadChunks(task: EngineTask): Promise<EngineChunk[] | null> {
    const rows = await this.db.listChunks(task.rec.id)
    if (rows.length === 0) {
      return null
    }
    const list: EngineChunk[] = []
    for (let i = 0; i < rows.length; i++) {
      list.push(new EngineChunk(rows[i][0], task.rec.id, rows[i][1], rows[i][2], rows[i][3]))
    }
    return list
  }

  async saveChunks(task: EngineTask, chunks: EngineChunk[]): Promise<void> {
    const plain: number[][] = []
    for (let i = 0; i < chunks.length; i++) {
      plain.push([chunks[i].start, chunks[i].length])
    }
    await this.db.insertChunks(task.rec.id, plain)
    const reloaded = await this.loadChunks(task)
    if (reloaded !== null) {
      for (let i = 0; i < reloaded.length && i < chunks.length; i++) {
        chunks[i].id = reloaded[i].id
      }
    }
  }

  async clearChunks(task: EngineTask): Promise<void> {
    await this.db.deleteChunks(task.rec.id)
    task.chunks = []
  }

  async resetChunks(task: EngineTask): Promise<void> {
    await this.db.resetChunks(task.rec.id)
  }

  // 任务结束回调（通知栏等）
  onTaskFinished(task: EngineTask, err: DownloadErr | null): void {
    this.persistTask(task)
    this.notifyTaskChanged(task)
    DownloadNotifier.getInstance().notify(task.rec)
  }

  // 完成：拷贝到用户下载目录（原版 k5.c.close 后由系统通知/文件管理接管）
  onTaskCompleted(task: EngineTask): void {
    this.copyToUserDir(task.rec.path)
    this.persistTask(task)
    this.notifyTaskChanged(task)
    DownloadNotifier.getInstance().notify(task.rec)
  }

  private copyToUserDir(sandboxPath: string): void {
    const dir = AppSettings.getInstance().downloadDir
    if (dir === '' || sandboxPath === '') {
      return
    }
    try {
      const slash = sandboxPath.lastIndexOf('/')
      const name = slash >= 0 ? sandboxPath.substring(slash + 1) : ''
      if (name === '') {
        return
      }
      const destUri = dir.endsWith('/') ? `${dir}${name}` : `${dir}/${name}`
      const src = fileIo.openSync(sandboxPath, fileIo.OpenMode.READ_ONLY)
      const dst = fileIo.openSync(destUri, fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE | fileIo.OpenMode.TRUNC)
      fileIo.copyFileSync(src.fd, dst.fd)
      fileIo.closeSync(src)
      fileIo.closeSync(dst)
    } catch (error) {
      console.error('copy engine download to user dir failed')
    }
  }
}
