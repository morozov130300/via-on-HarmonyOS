import { TOAST_SHORT } from '../common/ToastDuration'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'
import { computeDialogWidthVp } from '../components/UiaDialogCard'
import { AppIcon } from '../components/AppIcon'
import { TabStore } from '../common/TabStore'
import { ZipStoreWriter } from '../common/ZipWriter'
import { common } from '@kit.AbilityKit'
import { fileIo, picker } from '@kit.CoreFileKit'
import { filePreview } from '@kit.PreviewKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { systemShare } from '@kit.ShareKit'
import { uniformTypeDescriptor as utd } from '@kit.ArkData'

// 原版 eb.s 搜索防抖 200ms（B3：u8.c.a(editText).f(200L)）
const SEARCH_DEBOUNCE_MS: number = 200

// 原版 n9.d：离线条目（d()名称 / e()大小 / b()时间 / g()isPdf / f()路径）
class OfflineEntry {
  name: string = ''
  path: string = ''
  size: number = 0
  mtime: number = 0
  isPdf: boolean = false
}

// 原版 z8.b0.w（b0.java:753）：≥819.2→KB、≥838860.8→MB、≥858993459.2→GB，%.1f 单位
function formatSize(size: number): string {
  let v = size
  let unit = 'B'
  if (v >= 858993459.2) {
    v = v / 1024 / 1024 / 1024
    unit = 'GB'
  } else if (v >= 838860.8) {
    v = v / 1024 / 1024
    unit = 'MB'
  } else if (v >= 819.2) {
    v = v / 1024
    unit = 'KB'
  }
  return `${v.toFixed(1)} ${unit}`
}

// 原版 z8.t1.d（t1.java:63）：yyyyMMdd
function formatDateStamp(date: Date): string {
  const y = date.getFullYear().toString()
  const m = date.getMonth() + 1
  const d = date.getDate()
  const mm = m < 10 ? `0${m}` : m.toString()
  const dd = d < 10 ? `0${d}` : d.toString()
  return `${y}${mm}${dd}`
}

@ComponentV2
export struct OfflinePage {
  private tabStore: TabStore = TabStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local items: OfflineEntry[] = []
  @Local searchText: string = ''
  @Local editMode: boolean = false
  @Local selected: string[] = []
  // 删除确认弹窗（原版 eb.s s3/t3：fl/fm）
  @Local showDelete: boolean = false
  @Local deleteCount: number = 0
  @Local deleteName: string = ''
  // 原版 eb.Y2/e3：导出成功弹「导出数据到：%s」对话框（提示 g6），路径为空才 toast「导出成功」(il)
  @Local showExportDialog: boolean = false
  @Local exportPath: string = ''
  private pendingDelete: OfflineEntry[] = []
  private searchTimer: number = -1
  private searchPending: string = ''

  private offlineDir(): string {
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    return `${context.filesDir}/offline`
  }

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.offline_page'),
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  aboutToAppear(): void {
    this.reload()
  }

  aboutToDisappear(): void {
    if (this.searchTimer >= 0) {
      clearTimeout(this.searchTimer)
      this.searchTimer = -1
    }
  }

  // 原版 ha.e：扫描 offline 目录（仅 mht/pdf，鸿蒙端另含 html），按 lastModified 降序
  private reload(): void {
    const dir = this.offlineDir()
    if (!fileIo.accessSync(dir)) {
      this.items = []
      this.pruneSelection()
      return
    }
    fileIo.listFile(dir).then((names: string[]) => {
      const result: OfflineEntry[] = []
      for (let i = 0; i < names.length; i++) {
        const path = `${dir}/${names[i]}`
        const lower = names[i].toLowerCase()
        if (!lower.endsWith('.pdf') && !lower.endsWith('.mht') && !lower.endsWith('.html')) {
          continue
        }
        try {
          const stat = fileIo.statSync(path)
          const entry = new OfflineEntry()
          entry.path = path
          entry.size = stat.size
          entry.mtime = stat.mtime
          entry.isPdf = lower.endsWith('.pdf')
          entry.name = names[i].substring(0, names[i].lastIndexOf('.'))
          result.push(entry)
        } catch (error) {
          console.error('stat offline file failed')
        }
      }
      result.sort((a: OfflineEntry, b: OfflineEntry): number => {
        if (a.mtime === b.mtime) {
          return 0
        }
        return a.mtime > b.mtime ? -1 : 1
      })
      this.items = result
      this.pruneSelection()
    }).catch(() => {
      console.error('scan offline dir failed')
    })
  }

  // 删除后同步勾选状态
  private pruneSelection(): void {
    const kept: string[] = []
    for (let i = 0; i < this.selected.length; i++) {
      if (this.items.some((e: OfflineEntry): boolean => e.path === this.selected[i])) {
        kept.push(this.selected[i])
      }
    }
    if (kept.length !== this.selected.length) {
      this.selected = kept
    }
  }

  // 原版 eb.b3：搜索 200ms 防抖
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

  private visibleItems(): OfflineEntry[] {
    if (this.searchText === '') {
      return this.items
    }
    const kw = this.searchText.toLowerCase()
    return this.items.filter((e: OfflineEntry): boolean => e.name.toLowerCase().includes(kw))
  }

  // ===== 选择 =====

  private toggleSelect(path: string): void {
    const index = this.selected.indexOf(path)
    if (index >= 0) {
      this.selected.splice(index, 1)
    } else {
      this.selected.push(path)
    }
  }

  private isSelected(path: string): boolean {
    return this.selected.indexOf(path) >= 0
  }

  // 原版 eb.Z2 S0 分支：全选 ↔ 取消全选
  private toggleSelectAll(): void {
    const visible = this.visibleItems()
    const allSelected = this.selected.length > 0 && this.selected.length === visible.length
    if (allSelected) {
      this.selected = []
    } else {
      const paths: string[] = []
      for (let i = 0; i < visible.length; i++) {
        paths.push(visible[i].path)
      }
      this.selected = paths
    }
  }

  // ===== 打开（原版 eb.C3：0=当前标签 1=新标签 2=后台）=====

  private openEntry(entry: OfflineEntry, mode: number): void {
    // 原版 eb.C3：pdf 一律走内置查看器（za.g 等价 = pdfViewer 路由），不分标签模式
    if (entry.isPdf) {
      this.navPathStack.pushPathByName('pdfViewer', entry.path)
      return
    }
    const url = `file://${entry.path}`
    if (mode === 1) {
      this.tabStore.newTabAt(url, false)
      this.navPathStack.pop()
    } else if (mode === 2) {
      this.tabStore.newTabAt(url, true)
    } else {
      this.tabStore.navigate(url)
      this.navPathStack.pop()
    }
  }

  // ===== 长按菜单（原版 eb.H3/d3）=====

  private showItemMenu(entry: OfflineEntry): void {
    if (this.editMode) {
      this.toggleSelect(entry.path)
      return
    }
    const sheets: SheetInfo[] = []
    if (entry.isPdf) {
      sheets.push({
        title: $r('app.string.preview'),
        action: (): void => {
          this.openEntry(entry, 0)
        }
      })
      sheets.push({
        title: $r('app.string.open_with'),
        action: (): void => {
          this.openExternal(entry)
        }
      })
    } else {
      sheets.push({
        title: $r('app.string.open_in_background'),
        action: (): void => {
          this.openEntry(entry, 2)
        }
      })
      sheets.push({
        title: $r('app.string.open_new_tab_short'),
        action: (): void => {
          this.openEntry(entry, 1)
        }
      })
    }
    sheets.push({
      title: $r('app.string.share'),
      action: (): void => {
        this.shareEntry(entry)
      }
    })
    sheets.push({
      title: $r('app.string.export_action'),
      action: (): void => {
        this.exportEntries([entry])
      }
    })
    sheets.push({
      title: $r('app.string.delete'),
      action: (): void => {
        this.confirmDelete([entry])
      }
    })
    ActionSheet.show({
      title: entry.name,
      message: '',
      sheets: sheets
    })
  }

  // 原版 eb.d3 case 2（pdf）：系统选择器打开
  private openExternal(entry: OfflineEntry): void {
    if (!fileIo.accessSync(entry.path)) {
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.file_not_exist'), duration: TOAST_SHORT
      })
      return
    }
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    const info: filePreview.PreviewInfo = {
      title: entry.name,
      uri: `file://${entry.path}`,
      mimeType: 'application/pdf'
    }
    filePreview.openPreview(context, info).catch((error: BusinessError) => {
      console.error(`open preview failed: ${error.code} ${error.message}`)
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.no_app_to_open'), duration: TOAST_SHORT
      })
    })
  }

  // 原版 eb.d3 case 7：分享文件
  private shareEntry(entry: OfflineEntry): void {
    if (!fileIo.accessSync(entry.path)) {
      this.getUIContext().getPromptAction().showToast({
        message: $r('app.string.file_not_exist'), duration: TOAST_SHORT
      })
      return
    }
    const shareData: systemShare.SharedData = new systemShare.SharedData({
      utd: utd.UniformDataType.FILE,
      uri: `file://${entry.path}`,
      title: entry.name
    })
    const controller: systemShare.ShareController = new systemShare.ShareController(shareData)
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    controller.show(context, {
      selectionMode: systemShare.SelectionMode.SINGLE,
      previewMode: systemShare.SharePreviewMode.DETAIL
    }).catch(() => {
      console.error('share offline file failed')
    })
  }

  // ===== 删除（原版 eb.s3/t3/g3/j3）=====

  private confirmDelete(entries: OfflineEntry[]): void {
    if (entries.length === 0) {
      return
    }
    this.pendingDelete = entries
    this.deleteCount = entries.length
    this.deleteName = entries[0].name
    this.showDelete = true
  }

  private applyDelete(): void {
    this.showDelete = false
    for (let i = 0; i < this.pendingDelete.length; i++) {
      try {
        fileIo.unlinkSync(this.pendingDelete[i].path)
      } catch (error) {
        console.error('delete offline file failed')
      }
    }
    this.pendingDelete = []
    // 原版 eb.j3：批量删除后退出选择模式
    if (this.deleteCount > 1) {
      this.editMode = false
      this.selected = []
    }
    this.deleteCount = 0
    this.reload()
  }

  // ===== 导出（原版 eb.x3/w3/v3/i3/Y2/e3）=====

  private readAllBytes(path: string): Uint8Array | null {
    try {
      const stat = fileIo.statSync(path)
      const file = fileIo.openSync(path, fileIo.OpenMode.READ_ONLY)
      try {
        const buffer = new ArrayBuffer(stat.size)
        fileIo.readSync(file.fd, buffer)
        return new Uint8Array(buffer)
      } finally {
        fileIo.closeSync(file)
      }
    } catch (error) {
      console.error('read offline file failed')
      return null
    }
  }

  private entryExt(entry: OfflineEntry): string {
    const lower = entry.path.toLowerCase()
    if (lower.endsWith('.pdf')) {
      return 'pdf'
    }
    if (lower.endsWith('.mht')) {
      return 'mht'
    }
    return 'html'
  }

  // 原版 eb.x3：单个 → 原文件导出；多个 → 离线页面_yyyyMMdd.zip
  private async exportEntries(entries: OfflineEntry[]): Promise<void> {
    if (entries.length === 0) {
      return
    }
    try {
      const docPicker = new picker.DocumentViewPicker(this.getUIContext().getHostContext() as common.UIAbilityContext)
      const options = new picker.DocumentSaveOptions()
      let payload: Uint8Array | null = null
      let saveName = ''
      if (entries.length === 1) {
        const ext = this.entryExt(entries[0])
        saveName = `${entries[0].name}.${ext}`
        options.newFileNames = [saveName]
        options.fileSuffixChoices = [`.${ext}`]
        payload = this.readAllBytes(entries[0].path)
      } else {
        const ctx = this.getUIContext().getHostContext() as common.UIAbilityContext
        saveName = `${ctx.resourceManager.getStringSync($r('app.string.offline_page').id)}_` +
          `${formatDateStamp(new Date())}.zip`
        const writer = new ZipStoreWriter()
        for (let i = 0; i < entries.length; i++) {
          const bytes = this.readAllBytes(entries[i].path)
          if (bytes !== null) {
            writer.addBytes(`${entries[i].name}.${this.entryExt(entries[i])}`, bytes)
          }
        }
        payload = writer.toBytes()
        options.newFileNames = [saveName]
        options.fileSuffixChoices = ['.zip']
      }
      if (payload === null) {
        this.getUIContext().getPromptAction().showToast({
          message: $r('app.string.file_not_exist'), duration: TOAST_SHORT
        })
        return
      }
      const uris = await docPicker.save(options)
      if (uris === undefined || uris === null || uris.length === 0) {
        return
      }
      const target = fileIo.openSync(uris[0], fileIo.OpenMode.WRITE_ONLY | fileIo.OpenMode.TRUNC)
      try {
        fileIo.writeSync(target.fd, payload.buffer)
      } finally {
        fileIo.closeSync(target)
      }
      // 原版 eb.e3/Y2：导出成功弹「导出数据到：%s」对话框（标题 g6 提示）；路径为空才 toast il 导出成功
      if (uris[0] !== '') {
        this.exportPath = uris[0]
        this.showExportDialog = true
      } else {
        this.getUIContext().getPromptAction().showToast({
          message: '导出成功', duration: TOAST_SHORT
        })
      }
    } catch (error) {
      console.error('export offline files failed')
    }
  }

  @Builder
  DeleteDialog() {
    Column({ space: 14 }) {
      Text($r('app.string.delete'))
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      // 原版 eb.t3：1 条 → fl；多条 → fm
      Text(this.deleteCount === 1 ?
        $r('app.string.offline_delete_name_confirm', this.deleteName) :
        $r('app.string.delete_items_confirm', this.deleteCount))
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .width('100%')
      Row({ space: 10 }) {
        Button($r('app.string.cancel'))
          .fontSize(14)
          .height(38)
          .layoutWeight(1)
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            this.showDelete = false
          })
        Button($r('app.string.confirm'))
          .fontSize(14)
          .height(38)
          .layoutWeight(1)
          .backgroundColor($r('app.color.accent'))
          .fontColor($r('app.color.on_accent'))
          .onClick(() => {
            this.applyDelete()
          })
      }
      .width('100%')
    }
    .width('100%')
    .padding(20)
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(16)
  }

  // 原版 eb.Y2/e3：导出成功对话框（g6 提示 + ii 导出数据到：%s + 确定单键）
  @Builder
  ExportDialog() {
    Column({ space: 14 }) {
      Text('提示')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      Text($r('app.string.ai_exported_to', this.exportPath))
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .width('100%')
      Button($r('app.string.confirm'))
        .fontSize(14)
        .height(38)
        .width('100%')
        .backgroundColor($r('app.color.accent'))
        .fontColor($r('app.color.on_accent'))
        .onClick(() => {
          this.showExportDialog = false
        })
    }
    .width('100%')
    .padding(20)
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(16)
  }

  // 原版 eb.l：条目图标 = ae/ag（48dp 圆形 accent 底 + 32dp c_/de 字形）
  @Builder
  EntryIcon(entry: OfflineEntry) {
    Stack() {
      Circle()
        .width(48)
        .height(48)
        .fill($r('app.color.accent'))
      Image(entry.isPdf ? $r('app.media.uia_offline_glyph_pdf') : $r('app.media.uia_offline_glyph_web'))
        .width(32)
        .height(32)
        .objectFit(ImageFit.Contain)
    }
  }

  @Builder
  ItemRow(entry: OfflineEntry) {
    Row({ space: 12 }) {
      if (this.editMode) {
        Checkbox()
          .select(this.isSelected(entry.path))
          .onChange((value: boolean) => {
            if (value === this.isSelected(entry.path)) {
              return
            }
            this.toggleSelect(entry.path)
          })
      }
      this.EntryIcon(entry)
      Column({ space: 3 }) {
        Text(entry.name)
          .fontSize(15)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
        Text(formatSize(entry.size))
          .fontSize(12)
          .fontColor($r('app.color.fg_secondary'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
      }
      .layoutWeight(1)
      .alignItems(HorizontalAlign.Start)
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 10, bottom: 10 })
    .alignItems(VerticalAlign.Center)
    .onClick(() => {
      // 原版 eb.c3：选择模式切换勾选，否则打开（0=当前标签）
      if (this.editMode) {
        this.toggleSelect(entry.path)
      } else {
        this.openEntry(entry, 0)
      }
    })
    .gesture(LongPressGesture()
      .onAction(() => {
        this.showItemMenu(entry)
      }))
  }

  // 原版 eb.C1/Z2：普通模式仅「编辑」；选择模式「全选/取消全选」「删除(N)」「导出」「完成」
  @Builder
  BottomBar() {
    Row() {
      if (!this.editMode) {
        Blank()
        Text($r('app.string.edit'))
          .fontSize(14)
          .fontColor($r('app.color.accent'))
          .enabled(this.items.length > 0)
          .padding({ left: 16, right: 16 })
          .height(48)
          .onClick(() => {
            this.editMode = true
            this.selected = []
          })
      } else {
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
          .fontColor($r('app.color.accent'))
          .enabled(this.selected.length > 0)
          .padding({ left: 16, right: 16 })
          .height(48)
          .onClick(() => {
            this.confirmDelete(this.selectedEntries())
          })
        Text($r('app.string.export_action'))
          .fontSize(14)
          .fontColor($r('app.color.accent'))
          .enabled(this.selected.length > 0)
          .padding({ left: 16, right: 16 })
          .height(48)
          .onClick(() => {
            this.exportEntries(this.selectedEntries())
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

  private selectedEntries(): OfflineEntry[] {
    const result: OfflineEntry[] = []
    for (let i = 0; i < this.items.length; i++) {
      if (this.isSelected(this.items[i].path)) {
        result.push(this.items[i])
      }
    }
    return result
  }

  build() {
    NavDestination() {
      Stack() {
        Column() {
          AppBarSpacer()
          // 搜索框（原版 eb.B3：顶部 EditText，hint 搜索）
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
          if (this.items.length === 0) {
            // 原版 eb.V2：空视图（hg + or）
            Column({ space: 8 }) {
              Text($r('app.string.empty_page_placeholder'))
                .fontSize(14)
                .fontColor($r('app.color.fg_secondary'))
              Text($r('app.string.offline_empty_hint'))
                .fontSize(13)
                .fontColor($r('app.color.fg_secondary'))
            }
            .width('100%')
            .layoutWeight(1)
            .justifyContent(FlexAlign.Center)
            .padding({ left: 32, right: 32 })
          } else {
            List({ space: 1 }) {
              ForEach(this.visibleItems(), (entry: OfflineEntry) => {
                ListItem() {
                  this.ItemRow(entry)
                }
              }, (entry: OfflineEntry) => entry.path)
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
        if (this.showDelete) {
          Column() {
            this.DeleteDialog()
          }
          .width('100%')
          .height('100%')
          .justifyContent(FlexAlign.Center)
          .backgroundColor('rgba(0,0,0,0.5)')
          .onClick(() => {
            this.showDelete = false
          })
        }
        if (this.showExportDialog) {
          Column() {
            this.ExportDialog()
          }
          .width('100%')
          .height('100%')
          .justifyContent(FlexAlign.Center)
          .backgroundColor('rgba(0,0,0,0.5)')
          .onClick(() => {
            this.showExportDialog = false
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
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
    .onBackPressed(() => {
      // 原版 eb.W：选择模式返回先退出选择，其次清空搜索
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
export function OfflinePageBuilder() {
  OfflinePage()
}
