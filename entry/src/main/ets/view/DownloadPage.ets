import { TOAST_SHORT } from '../common/ToastDuration'
import { DownloadRec, DownloadStatus } from '../common/Types'
import { BrowserDb } from '../common/Database'
import { DownloadCoordinator } from '../common/Downloads'
import { DownloadEngine } from '../common/DownloadEngine'
import {
  DownloadNotifier,
  dlStatusText,
  dlTitleOf,
  baseNameOf,
  DL_STATE_PAUSED,
  DL_STATE_WAIT_NET
} from '../common/DownloadNotifier'
import { AppIcon } from '../components/AppIcon'
import { computeDialogWidthVp } from '../components/UiaDialogCard'
import { UiaDialogButton } from '../components/UiaDialogButton'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'
import { filePreview } from '@kit.PreviewKit'
import { common } from '@kit.AbilityKit'
import { BusinessError, pasteboard } from '@kit.BasicServicesKit'
import { fileIo } from '@kit.CoreFileKit'
import { systemShare } from '@kit.ShareKit'
import { uniformTypeDescriptor as utd } from '@kit.ArkData'
import { detectBarcode, scanBarcode } from '@kit.ScanKit'

const DOWNLOAD_REFRESH_MS: number = 500
const SEARCH_DEBOUNCE_MS: number = 100

// 原版 b1.x3 tab 顺序：全部/文档/压缩包/安装包/图片/视频/音频/其它 → 分类 0/6/5/3/7/2/1/8
const TAB_CATS: number[] = [0, 6, 5, 3, 7, 2, 1, 8]
// 原版 b1.h4 扩展名表
const DOC_EXTS: string = ',mht,docx,doc,xml,xul,xls,xlsx,json,jsonld,epub,js,pdf,ppt,pptx,ts,azw,rtf,odp,ods,odt,sh,php,py,'
const ZIP_EXTS: string = ',zip,rar,gz,7z,tar,gtar,bz,bz2,xz,lzma,z,arj,cab,lzh,iso,jar,ace,tgz,'
const QR_MAX_BYTES: number = 204800

function stateIsCompleted(state: number): boolean {
  return state >= 100 && state < 200
}

function stateIsActive(state: number): boolean {
  return state > 0 && state < 100 && state !== DL_STATE_PAUSED
}

function stateIsFailed(state: number): boolean {
  return state >= 200 && state < 300
}

// 原版 b1.h4：按扩展名 + MIME 判定分类（1 音频 2 视频 3 安装包 5 压缩包 6 文档 7 图片 8 其它）
function categoryOf(item: DownloadRec): number {
  const name = baseNameOf(item.path).toLowerCase()
  const dot = name.lastIndexOf('.')
  const ext = dot > 0 ? name.substring(dot + 1) : ''
  const mime = item.mime
  if (ext === '' && mime === '') {
    return 8
  }
  if (mime.startsWith('audio/')) {
    return 1
  }
  if (mime.startsWith('video/')) {
    return 2
  }
  if (mime.startsWith('image/')) {
    return 7
  }
  if (ext === 'apk' || ext === 'xapk') {
    return 3
  }
  if (mime.startsWith('text/')) {
    return 6
  }
  if (ext !== '' && DOC_EXTS.includes(`,${ext},`)) {
    return 6
  }
  if (ext !== '' && ZIP_EXTS.includes(`,${ext},`)) {
    return 5
  }
  return 8
}

// 原版 DownloadTaskViewDelegate.v：分类 → 图标
function categoryIconOf(item: DownloadRec): Resource {
  const mime = item.mime
  if (mime.startsWith('audio/')) {
    return $r('app.media.uia_dl_audio')
  }
  if (mime.startsWith('video/')) {
    return $r('app.media.uia_dl_video')
  }
  if (mime.startsWith('image/')) {
    return $r('app.media.uia_dl_image')
  }
  if (mime === 'application/vnd.android.package-archive') {
    return $r('app.media.uia_dl_apk')
  }
  if (mime.startsWith('text/') || mime.includes('document') || mime === 'application/pdf') {
    return $r('app.media.uia_dl_doc')
  }
  if (mime.includes('zip') || mime.includes('compress')) {
    return $r('app.media.uia_dl_archive')
  }
  return $r('app.media.uia_dl_other')
}

function fileNameFromUrl(url: string): string {
  const queryStart = url.indexOf('?')
  const base = queryStart >= 0 ? url.substring(0, queryStart) : url
  const slash = base.lastIndexOf('/')
  let name = slash >= 0 ? base.substring(slash + 1) : ''
  name = name.replace(/[\\/:*?"<>|]/g, '_')
  if (name.length > 100) {
    name = name.substring(name.length - 100)
  }
  return name
}

@ComponentV2
export struct DownloadPage {
  private db: BrowserDb = BrowserDb.getInstance()
  private coordinator: DownloadCoordinator = DownloadCoordinator.getInstance()
  private engine: DownloadEngine = DownloadEngine.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local items: DownloadRec[] = []
  @Local tab: number = 0
  @Local searchText: string = ''
  @Local editMode: boolean = false
  @Local selected: number[] = []
  // 新建下载弹窗（原版 b1.s4）
  @Local showNew: boolean = false
  @Local newUrl: string = 'https://'
  @Local newName: string = ''
  // 重命名弹窗（原版 b1.o4）
  @Local showRename: boolean = false
  @Local renameText: string = ''
  private renameRec: DownloadRec | null = null
  // 删除确认弹窗（原版 b1.q4/p4）
  @Local showDelete: boolean = false
  @Local deleteBatch: boolean = false
  @Local deleteWithFile: boolean = false
  private deleteRec: DownloadRec | null = null
  // 二维码结果弹窗（原版 b1.y4）
  @Local showQr: boolean = false
  @Local qrText: string = ''
  private qrRec: DownloadRec | null = null
  // 二维码解码缓存（原版 b1.J0）
  private qrCache: Map<number, string> = new Map<number, string>()
  private refreshTimer: number = -1
  private searchTimer: number = -1
  private searchPending: string = ''
  private changeListener: () => void = (): void => {
    this.reload()
  }

  aboutToAppear(): void {
    this.reload()
    this.engine.addTaskChangeListener(this.changeListener)
  }

  aboutToDisappear(): void {
    this.stopAutoRefresh()
    this.clearSearchDebounce()
  }

  // 原版下载进度经通知/回调实时更新；页面以 500ms 轮询 + 引擎变更回调近似
  private startAutoRefresh(): void {
    if (this.refreshTimer >= 0) {
      return
    }
    this.refreshTimer = setInterval(() => {
      this.reload()
    }, DOWNLOAD_REFRESH_MS)
  }

  private stopAutoRefresh(): void {
    if (this.refreshTimer >= 0) {
      clearInterval(this.refreshTimer)
      this.refreshTimer = -1
    }
  }

  // 原版 b1.X1：搜索 100ms 防抖（u8.c.B(1).f(100ms)）
  private onSearchInput(text: string): void {
    this.searchPending = text
    if (this.searchTimer >= 0) {
      clearTimeout(this.searchTimer)
    }
    this.searchTimer = setTimeout(() => {
      this.searchTimer = -1
      this.searchText = this.searchPending.trim()
    }, SEARCH_DEBOUNCE_MS)
  }

  private clearSearchDebounce(): void {
    if (this.searchTimer >= 0) {
      clearTimeout(this.searchTimer)
      this.searchTimer = -1
    }
  }

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.downloads'),
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  // 原版 b1.y3/g4：tab + 搜索过滤
  private visibleItems(): DownloadRec[] {
    const result: DownloadRec[] = []
    for (let i = 0; i < this.items.length; i++) {
      const item = this.items[i]
      if (this.tab !== 0 && categoryOf(item) !== this.tab) {
        continue
      }
      if (this.searchText !== '' && !baseNameOf(item.path).toLowerCase()
        .includes(this.searchText.toLowerCase())) {
        continue
      }
      result.push(item)
    }
    return result
  }

  private reload(): void {
    this.db.listDownloads().then((items: DownloadRec[]) => {
      this.items = items
      for (let i = 0; i < items.length; i++) {
        this.decodeQr(items[i])
      }
    }).catch((error: BusinessError) => {
      console.error(`list downloads failed: ${error.message}`)
    })
  }

  // 原版 b1.t4：完成 + image/* + ≤204800B 的条目后台解码二维码缓存
  private decodeQr(item: DownloadRec): void {
    if (this.qrCache.has(item.id)) {
      return
    }
    if (!stateIsCompleted(item.state) || !item.mime.startsWith('image/') || item.received > QR_MAX_BYTES) {
      return
    }
    this.qrCache.set(item.id, '')
    // ScanKit detectBarcode.decode：uri 输入（file:// 沙箱路径）
    detectBarcode.decode({ uri: `file://${item.path}` })
      .then((results: Array<scanBarcode.ScanResult>) => {
      let text = ''
      if (results.length > 0) {
        text = results[0].originalValue
      }
      this.qrCache.set(item.id, text)
      return
    }).catch(() => {
      this.qrCache.delete(item.id)
    })
  }

  // ===== 条目交互 =====

  // 原版 b1.E3：点击条目（选择模式切换 / 完成后打开）
  private onItemTap(item: DownloadRec): void {
    if (this.editMode) {
      this.toggleSelect(item.id)
      return
    }
    if (stateIsCompleted(item.state)) {
      this.openFile(item)
    }
  }

  // 原版 b1.c3：暂停/恢复图标（活跃→暂停，其余→恢复）
  private onIconTap(item: DownloadRec): void {
    if (stateIsActive(item.state)) {
      this.engine.pauseById(item.id).catch(() => {
      })
    } else {
      this.engine.resumeById(item.id).catch(() => {
      })
    }
  }

  private toggleSelect(id: number): void {
    const index = this.selected.indexOf(id)
    if (index >= 0) {
      this.selected.splice(index, 1)
    } else {
      this.selected.push(id)
    }
  }

  private isSelected(id: number): boolean {
    return this.selected.indexOf(id) >= 0
  }

  // 原版 b1.z4：长按菜单
  private showItemMenu(item: DownloadRec): void {
    if (this.editMode) {
      this.toggleSelect(item.id)
      return
    }
    const qr = this.qrCache.get(item.id)
    const sheets: SheetInfo[] = []
    if (stateIsCompleted(item.state)) {
      sheets.push({
        title: $r('app.string.open_with'),
        action: (): void => {
          this.openFile(item)
        }
      })
      sheets.push({
        title: $r('app.string.rename_download'),
        action: (): void => {
          this.renameRec = item
          this.renameText = baseNameOf(item.path)
          this.showRename = true
        }
      })
    }
    if (!stateIsActive(item.state) && item.url !== '') {
      sheets.push({
        title: $r('app.string.retry_download'),
        action: (): void => {
          this.confirmRedownload(item)
        }
      })
    }
    if (item.url !== '') {
      sheets.push({
        title: $r('app.string.copy_download_link'),
        action: (): void => {
          this.copyText(item.url, $r('app.string.copied_link'))
        }
      })
    }
    if (qr !== undefined && qr !== '') {
      sheets.push({
        title: $r('app.string.scan_qr_code'),
        action: (): void => {
          this.qrRec = item
          this.qrText = qr
          this.showQr = true
        }
      })
    }
    sheets.push({
      title: $r('app.string.share'),
      action: (): void => {
        this.shareItem(item)
      }
    })
    sheets.push({
      title: $r('app.string.delete'),
      action: (): void => {
        this.confirmDelete(item)
      }
    })
    ActionSheet.show({
      title: dlTitleOf(item),
      message: '',
      sheets: sheets
    })
  }

  // 原版 b1.u4/H3：重新下载确认
  private confirmRedownload(item: DownloadRec): void {
    this.getUIContext().showAlertDialog({
      message: $r('app.string.redownload_confirm', baseNameOf(item.path)),
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: $r('app.string.confirm'),
        action: () => {
          this.engine.restartById(item.id).then(() => {
            this.reload()
          }).catch(() => {
          })
        }
      },
      cancel: () => {
      },
      autoCancel: true
    })
  }

  // 原版 b1.q4：删除确认（完成→W7+勾选；未完成→X7）
  private confirmDelete(item: DownloadRec): void {
    this.deleteRec = item
    this.deleteBatch = false
    this.deleteWithFile = false
    if (stateIsCompleted(item.state)) {
      this.showDelete = true
    } else {
      this.getUIContext().showAlertDialog({
        message: $r('app.string.delete_task_with_file_confirm'),
        primaryButton: {
          value: $r('app.string.cancel'),
          action: () => {
          }
        },
        secondaryButton: {
          value: $r('app.string.confirm'),
          action: () => {
            this.deleteItem(item, true)
          }
        },
        cancel: () => {
        },
        autoCancel: true
      })
    }
  }

  // 原版 b1.p4：批量删除确认
  private confirmBatchDelete(): void {
    if (this.selected.length === 0) {
      return
    }
    this.deleteBatch = true
    this.deleteWithFile = false
    this.showDelete = true
  }

  // 原版 b1.e4：删库 + 按条件删文件
  private deleteItem(item: DownloadRec, deleteFile: boolean): void {
    if (item.state > 0 && (stateIsActive(item.state) || item.state === DL_STATE_WAIT_NET)) {
      this.engine.pauseById(item.id).catch(() => {
      })
    }
    if (deleteFile && item.path !== '') {
      try {
        fileIo.unlinkSync(item.path)
      } catch (error) {
        console.error('delete download file failed')
      }
    }
    DownloadNotifier.getInstance().cancel(item.id)
    this.db.deleteDownload(item.id).then(() => {
      this.reload()
    }).catch((error: BusinessError) => {
      console.error(`delete download failed: ${error.message}`)
    })
  }

  private applyDeleteConfirm(): void {
    if (this.deleteBatch) {
      const ids: number[] = Array.from(this.selected)
      for (let i = 0; i < ids.length; i++) {
        const rec = this.findItem(ids[i])
        if (rec !== null) {
          const deleteFile = !stateIsCompleted(rec.state) || this.deleteWithFile
          this.deleteItem(rec, deleteFile)
        }
      }
      this.selected = []
      this.editMode = false
    } else {
      const rec = this.deleteRec
      if (rec !== null) {
        const deleteFile = !stateIsCompleted(rec.state) || this.deleteWithFile
        this.deleteItem(rec, deleteFile)
      }
    }
    this.showDelete = false
  }

  private findItem(id: number): DownloadRec | null {
    for (let i = 0; i < this.items.length; i++) {
      if (this.items[i].id === id) {
        return this.items[i]
      }
    }
    return null
  }

  // ===== 底部操作栏（原版 b1.h3/w4/s3）=====

  // 原版 b1.s4/B3：新建下载
  private showNewDialog(): void {
    this.newUrl = 'https://'
    this.newName = ''
    this.showNew = true
  }

  private applyNewDownload(): void {
    this.showNew = false
    const url = this.newUrl.trim()
    if (!url.startsWith('http://') && !url.startsWith('https://')) {
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.url_invalid_toast'), duration: TOAST_SHORT
      })
      return
    }
    let name = this.newName.trim()
    if (name === '') {
      name = fileNameFromUrl(url)
    }
    if (name === '') {
      name = `download_${Date.now()}`
    }
    // 原版 B3：state 90、8 线程入队
    this.engine.createTask(url, name, '', '', 8).then(() => {
      this.tab = 0
      this.reload()
    }).catch((error: BusinessError) => {
      console.error(`create download task failed: ${error.message}`)
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.download_failed'), duration: TOAST_SHORT
      })
    })
  }

  // 原版 b1.s3 全选分支：全选 ↔ 取消全选
  private toggleSelectAll(): void {
    const visible = this.visibleItems()
    if (this.selected.length > 0 && this.selected.length === visible.length) {
      this.selected = []
    } else {
      const ids: number[] = []
      for (let i = 0; i < visible.length; i++) {
        ids.push(visible[i].id)
      }
      this.selected = ids
    }
  }

  // ===== 工具操作 =====

  private copyText(text: string, toast: ResourceStr): void {
    const data = pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, text)
    pasteboard.getSystemPasteboard().setData(data).then(() => {
      this.getUIContext().getPromptAction().showToast({ message: toast, duration: TOAST_SHORT })
    }).catch(() => {
      console.error('copy text failed')
    })
  }

  // 原版 b1.n4：打开文件（完成态）
  private openFile(item: DownloadRec): void {
    if (!stateIsCompleted(item.state)) {
      return
    }
    if (item.path === '' || !fileIo.accessSync(item.path)) {
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.file_not_exist'), duration: TOAST_SHORT
      })
      return
    }
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    const info: filePreview.PreviewInfo = {
      title: baseNameOf(item.path),
      uri: `file://${item.path}`,
      mimeType: item.mime
    }
    filePreview.openPreview(context, info).catch((error: BusinessError) => {
      console.error(`open preview failed: ${error.code} ${error.message}`)
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.no_app_to_open'), duration: TOAST_SHORT
      })
    })
  }

  // 原版 b1.x4：分享（文件优先，回退 URL 文本）
  private shareItem(item: DownloadRec): void {
    if (!stateIsCompleted(item.state) || item.path === '' || !fileIo.accessSync(item.path)) {
      if (item.url !== '') {
        this.shareUrl(item.url)
      }
      return
    }
    const shareData: systemShare.SharedData = new systemShare.SharedData({
      utd: utd.UniformDataType.FILE,
      uri: `file://${item.path}`,
      title: baseNameOf(item.path)
    })
    const controller: systemShare.ShareController = new systemShare.ShareController(shareData)
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    controller.show(context, {
      selectionMode: systemShare.SelectionMode.SINGLE,
      previewMode: systemShare.SharePreviewMode.DETAIL
    }).catch(() => {
      if (item.url !== '') {
        this.shareUrl(item.url)
      }
    })
  }

  private shareUrl(url: string): void {
    const shareData: systemShare.SharedData = new systemShare.SharedData({
      utd: utd.UniformDataType.HYPERLINK,
      content: url,
      title: url,
      description: url
    })
    const controller: systemShare.ShareController = new systemShare.ShareController(shareData)
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    controller.show(context, {
      selectionMode: systemShare.SelectionMode.SINGLE,
      previewMode: systemShare.SharePreviewMode.DETAIL
    }).catch(() => {
      console.error('share failed')
    })
  }

  // 原版 b1.o3/j3：重命名（改名 + 扩展名变化时更新 MIME）
  private applyRename(): void {
    this.showRename = false
    const rec = this.renameRec
    if (rec === null) {
      return
    }
    const newName = this.renameText.trim()
    const oldName = baseNameOf(rec.path)
    if (newName === '' || newName === oldName) {
      return
    }
    const dir = rec.path.substring(0, rec.path.length - oldName.length)
    const newPath = `${dir}${newName}`
    try {
      fileIo.renameSync(rec.path, newPath)
    } catch (error) {
      console.error('rename download file failed')
      return
    }
    const oldDot = oldName.lastIndexOf('.')
    const newDot = newName.lastIndexOf('.')
    const oldExt = oldDot > 0 ? oldName.substring(oldDot + 1).toLowerCase() : ''
    const newExt = newDot > 0 ? newName.substring(newDot + 1).toLowerCase() : ''
    if (oldExt !== newExt) {
      rec.mime = newExt === 'pdf' ? 'application/pdf' : 'application/octet-stream'
    }
    rec.path = newPath
    this.db.updateEngineTask(rec).then(() => {
      this.reload()
    }).catch((error: BusinessError) => {
      console.error(`rename download failed: ${error.message}`)
    })
  }

  // ===== 弹窗 =====

  @Builder
  NewDialog() {
    Column({ space: 14 }) {
      Text($r('app.string.new_download'))
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      TextInput({ text: this.newUrl, placeholder: $r('app.string.download_url_hint') })
        .fontSize(14)
        .height(44)
        .onChange((text: string) => {
          this.newUrl = text
        })
      TextInput({ text: this.newName, placeholder: $r('app.string.download_file_name_hint') })
        .fontSize(14)
        .height(44)
        .onChange((text: string) => {
          this.newName = text
        })
      Row() {
        Blank().layoutWeight(1)
        UiaDialogButton({ label: $r('app.string.cancel'), onAction: () => {
          this.showNew = false
        } })
        UiaDialogButton({ label: $r('app.string.new_download_download'), onAction: () => {
          this.applyNewDownload()
        } })
      }
      .width('100%')
    }
    .width('100%')
    .padding(20)
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
  }

  @Builder
  RenameDialog() {
    Column({ space: 14 }) {
      Text($r('app.string.rename_download'))
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      TextInput({ text: this.renameText })
        .fontSize(14)
        .height(44)
        .onChange((text: string) => {
          this.renameText = text
        })
      Row() {
        Blank().layoutWeight(1)
        UiaDialogButton({ label: $r('app.string.cancel'), onAction: () => {
          this.showRename = false
        } })
        UiaDialogButton({ label: $r('app.string.confirm'), onAction: () => {
          this.applyRename()
        } })
      }
      .width('100%')
    }
    .width('100%')
    .padding(20)
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
  }

  @Builder
  DeleteDialog() {
    Column({ space: 14 }) {
      Text($r('app.string.delete'))
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      Text(this.deleteBatch ?
        $r('app.string.delete_tasks_confirm', this.selected.length) :
        $r('app.string.delete_task_confirm'))
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .width('100%')
      Row({ space: 8 }) {
        Checkbox()
          .select(this.deleteWithFile)
          .onChange((value: boolean) => {
            this.deleteWithFile = value
          })
        Text($r('app.string.delete_with_file_option'))
          .fontSize(14)
          .fontColor($r('app.color.fg'))
      }
      .width('100%')
      Row() {
        Blank().layoutWeight(1)
        UiaDialogButton({ label: $r('app.string.cancel'), onAction: () => {
          this.showDelete = false
        } })
        UiaDialogButton({ label: $r('app.string.confirm'), onAction: () => {
          this.applyDeleteConfirm()
        } })
      }
      .width('100%')
    }
    .width('100%')
    .padding(20)
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
  }

  // 原版 b1.y4：二维码结果（URL→打开，否则→复制文本）
  @Builder
  QrDialog() {
    Column({ space: 14 }) {
      Text(this.qrRec !== null ? dlTitleOf(this.qrRec) : '')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      Text(this.qrText)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .width('100%')
        .maxLines(6)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
      Row() {
        Blank().layoutWeight(1)
        UiaDialogButton({ label: $r('app.string.cancel'), onAction: () => {
          this.showQr = false
        } })
        UiaDialogButton({
          label: this.qrText.startsWith('http://') || this.qrText.startsWith('https://') ?
            $r('app.string.open_action') : $r('app.string.copy_text'),
          onAction: () => {
            if (this.qrText.startsWith('http://') || this.qrText.startsWith('https://')) {
              const context = this.getUIContext().getHostContext() as common.UIAbilityContext
              try {
                context.openLink(this.qrText)
              } catch (error) {
                console.error('open qr link failed')
              }
            } else {
              this.copyText(this.qrText, $r('app.string.copied'))
            }
            this.showQr = false
          }
        })
      }
      .width('100%')
    }
    .width('100%')
    .padding(20)
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
  }

  @Builder
  TabLabel(cat: number, label: ResourceStr) {
    Text(label)
      .fontSize(13)
      .fontColor(this.tab === cat ? $r('app.color.accent') : $r('app.color.fg_secondary'))
      .padding({ left: 10, right: 10, top: 8, bottom: 8 })
      .onClick(() => {
        if (this.tab !== cat) {
          this.tab = cat
        }
      })
  }

  @Builder
  ItemRow(item: DownloadRec) {
    Row({ space: 12 }) {
      if (this.editMode) {
        Checkbox()
          .select(this.isSelected(item.id))
          .onChange((value: boolean) => {
            if (value === this.isSelected(item.id)) {
              return
            }
            this.toggleSelect(item.id)
          })
      }
      Image(categoryIconOf(item))
        .width(24)
        .height(24)
        .objectFit(ImageFit.Contain)
      Column({ space: 3 }) {
        Text(dlTitleOf(item))
          .fontSize(15)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
        Text(dlStatusText(item))
          .fontSize(12)
          .fontColor(stateIsCompleted(item.state) || stateIsFailed(item.state) ?
            $r('app.color.fg_secondary') : $r('app.color.accent'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
        if (stateIsActive(item.state)) {
          // 原版 DownloadTaskViewDelegate.z：仅活跃态显示，千分进度
          Progress({
            value: item.size > 0 ? Math.floor(item.received * 1000 / item.size) : 1000,
            total: 1000,
            type: ProgressType.Linear
          })
            .width('100%')
            .height(3)
            .color($r('app.color.accent'))
            .backgroundColor($r('app.color.surface'))
        }
      }
      .layoutWeight(1)
      .alignItems(HorizontalAlign.Start)
      if (!this.editMode && !stateIsCompleted(item.state)) {
        Image(stateIsActive(item.state) ? $r('app.media.uia_dl_pause') : $r('app.media.uia_dl_resume'))
          .width(22)
          .height(22)
          .objectFit(ImageFit.Contain)
          .onClick(() => {
            this.onIconTap(item)
          })
      }
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 10, bottom: 10 })
    .alignItems(VerticalAlign.Center)
    .onClick(() => {
      this.onItemTap(item)
    })
    .gesture(LongPressGesture()
      .onAction(() => {
        this.showItemMenu(item)
      }))
  }

  @Builder
  BottomBar() {
    Row() {
      if (!this.editMode) {
        // 原版 w4：普通模式只显示「新建」（左）与「编辑」（右）
        Text($r('app.string.new_download'))
          .fontSize(14)
          .fontColor($r('app.color.accent'))
          .padding({ left: 16, right: 16 })
          .height(48)
          .onClick(() => {
            this.showNewDialog()
          })
        Blank()
        Text($r('app.string.edit'))
          .fontSize(14)
          .fontColor($r('app.color.accent'))
          .padding({ left: 16, right: 16 })
          .height(48)
          .onClick(() => {
            this.editMode = true
            this.selected = []
          })
      } else {
        // 原版 w4：编辑模式显示「全选/取消全选」「删除（N）」（左）与「完成」（右）
        Text(this.selected.length > 0 && this.selected.length === this.visibleItems().length ?
          $r('app.string.cancel_select_all') : $r('app.string.select_all'))
          .fontSize(14)
          .fontColor($r('app.color.accent'))
          .padding({ left: 16, right: 16 })
          .height(48)
          .onClick(() => {
            this.toggleSelectAll()
          })
        Text(this.selected.length === 0 ? $r('app.string.delete') :
          $r('app.string.delete_count', this.selected.length))
          .fontSize(14)
          .fontColor(this.selected.length > 0 ? $r('app.color.accent') : $r('app.color.fg_secondary'))
          .enabled(this.selected.length > 0)
          .padding({ left: 16, right: 16 })
          .height(48)
          .onClick(() => {
            this.confirmBatchDelete()
          })
        Blank()
        Text($r('app.string.done'))
          .fontSize(14)
          .fontColor($r('app.color.accent'))
          .padding({ left: 16, right: 16 })
          .height(48)
          .onClick(() => {
            this.editMode = false
            this.selected = []
          })
      }
    }
    .width('100%')
    .alignItems(VerticalAlign.Center)
  }

  build() {
    NavDestination() {
      Stack() {
        Column() {
          AppBarSpacer()
          // 搜索框（原版 b1.Z2 顶部 EditText，hint 搜索）
          Row({ space: 8 }) {
            AppIcon({ icon: $r('sys.symbol.magnifyingglass'), iconSize: 16,
              iconColor: $r('app.color.fg_secondary') })
            TextInput({ placeholder: $r('app.string.search') })
              .fontSize(14)
              .height(36)
              .layoutWeight(1)
              .backgroundColor($r('app.color.page_bg'))
              .padding({ left: 0, right: 0 })
              .onChange((text: string) => {
                this.onSearchInput(text)
              })
          }
          .width('100%')
          .padding({ left: 16, right: 16, top: 6, bottom: 6 })
          // tab 行（原版 b1.x3：全部/文档/压缩包/安装包/图片/视频/音频/其它）
          // 原版 b1.m4：数据集为空且当前 tab 为「全部」(0) 时隐藏 tab 行，显示居中空态；有数据恢复
          if (this.items.length > 0 || this.tab !== 0) {
            Scroll() {
              Row() {
                this.TabLabel(TAB_CATS[0], $r('app.string.dl_tab_all'))
                this.TabLabel(TAB_CATS[1], $r('app.string.dl_tab_docs'))
                this.TabLabel(TAB_CATS[2], $r('app.string.dl_tab_archives'))
                this.TabLabel(TAB_CATS[3], $r('app.string.dl_tab_apk'))
                this.TabLabel(TAB_CATS[4], $r('app.string.dl_tab_images'))
                this.TabLabel(TAB_CATS[5], $r('app.string.dl_tab_video'))
                this.TabLabel(TAB_CATS[6], $r('app.string.dl_tab_audio'))
                this.TabLabel(TAB_CATS[7], $r('app.string.dl_tab_others'))
              }
            }
            .scrollable(ScrollDirection.Horizontal)
            .scrollBar(BarState.Off)
            .width('100%')
          }
          if (this.visibleItems().length === 0) {
            // 原版 b1.m4：空列表视图
            Column() {
              Text($r('app.string.empty_downloads'))
                .fontSize(14)
                .fontColor($r('app.color.fg_secondary'))
            }
            .width('100%')
            .layoutWeight(1)
            .justifyContent(FlexAlign.Center)
          } else {
            List({ space: 1 }) {
              ForEach(this.visibleItems(), (item: DownloadRec) => {
                ListItem() {
                  this.ItemRow(item)
                }
              }, (item: DownloadRec) => `${item.id}_${item.state}_${item.received}_${item.speed}`)
            }
            .width('100%')
            .layoutWeight(1)
            .divider({ strokeWidth: 0.5, color: $r('app.color.divider') })
            .scrollBar(BarState.Off)
            .edgeEffect(EdgeEffect.Spring)
          }
          Divider()
            .strokeWidth(0.5)
            .color($r('app.color.divider'))
          this.BottomBar()
        }
        .width('100%')
        .height('100%')
        // 弹窗层
        if (this.showNew || this.showRename || this.showDelete || this.showQr) {
          Column() {
            if (this.showNew) {
              this.NewDialog()
            }
            if (this.showRename) {
              this.RenameDialog()
            }
            if (this.showDelete) {
              this.DeleteDialog()
            }
            if (this.showQr) {
              this.QrDialog()
            }
          }
          .width('100%')
          .height('100%')
          .justifyContent(FlexAlign.Center)
          .backgroundColor('rgba(0,0,0,0.4)')
          .onClick(() => {
            this.showNew = false
            this.showRename = false
            this.showDelete = false
            this.showQr = false
          })
        }
      }
      .width('100%')
      .height('100%')
    }
    .hideTitleBar(true)
    .backgroundColor($r('app.color.page_bg'))
    .translate({ x: this.slideOffset })
    // 原版 g6/i.java:67 = setCustomAnimations(anim/f, anim/g, anim/h, anim/i)，
    // 时长 integer/b=220、accelerate_decelerate —— 改用鸿蒙原生 NavDestination 转场接口
    .customTransition((operation: NavigationOperation, isEnter: boolean):
      Array<NavDestinationTransition> | undefined => {
      return buildNavSlide(operation, isEnter, (value: string): void => {
        this.slideOffset = value
      })
    })
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
      this.reload()
      this.startAutoRefresh()
    })
    .onHidden(() => {
      this.stopAutoRefresh()
    })
    .onWillDisappear(() => {
      this.stopAutoRefresh()
      AppBar.maybeHide(this)
    })
    .onBackPressed(() => {
      // 原版 b1.V2：选择模式返回键先退出选择
      if (this.editMode) {
        this.editMode = false
        this.selected = []
        return true
      }
      return false
    })
  }
}

@Builder
export function DownloadPageBuilder() {
  DownloadPage()
}
