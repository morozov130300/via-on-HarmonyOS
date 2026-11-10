import { BusinessError } from '@kit.BasicServicesKit'
import { display, window } from '@kit.ArkUI'
import { BookmarkRec, BookmarkFolderRec } from '../common/Types'
import { BrowserDb } from '../common/Database'
import { dialogTransition } from '../common/Transitions'
import { UiaIcon } from './UiaIcon'

// 原版 a8/k.T1()（a8/k.java:197-206）：
//   int iMin  = min(g6.y.p(I())*4/5, g6.y.h(I(), 450.0f));   // 宽
//   int iMin2 = min(g6.y.p(I())*4/5, g6.y.h(I(), 600.0f));   // 高
//   Z2().getWindow().setLayout(iMin, iMin2);
// g6.y.p = 屏宽 px、g6.y.h = dp→px；这里统一换算成 vp（与窗口 rect 一致，兼容分屏/悬浮窗）。
function a8kWindowSizeVp(): number[] {
  try {
    let wPx = 0
    let hPx = 0
    const win = AppStorage.get<window.Window>('mainWindow')
    if (win !== undefined) {
      const rect = win.getWindowProperties().windowRect
      wPx = rect.width
      hPx = rect.height
    }
    if (wPx <= 0 || hPx <= 0) {
      const d = display.getDefaultDisplaySync()
      wPx = d.width
      hPx = d.height
    }
    const density = display.getDefaultDisplaySync().densityPixels
    if (density <= 0 || wPx <= 0) {
      return [288, 480]
    }
    const wVp = wPx / density
    const hVp = hPx / density
    return [Math.min(wVp * 4 / 5, 450), Math.min(hVp * 4 / 5, 600)]
  } catch (error) {
    const err = error as BusinessError
    console.error(`resolve dialog size failed: ${err.code}`)
    return [288, 480]
  }
}

// 原版 a8/k.java（extends k8/a.java DialogFragment）：书签快捷选择对话框。
// 入口：k6.W9()（k6.java:6224-6227，P9 case2 长按「书签」）
//   与 k6.ra case30（k6.java:8357-8359，工具栏动作 30），
//   动作文案 hb/v4.java:127-128 = x7.u.H9 = pn「打开书签对话框」。
//
// 原版结构（a8/k.java）：
//   · X1()：F0 = 标题 TextView（x7.p.H1，Typeface.DEFAULT_BOLD）；E0 = 空态 TextView（r3.e 写入
//     "¯\\_(ツ)_/¯"）；D0 = RecyclerView 名单；R = 右上角 ImageView，点击 q3() 进书签管理
//   · k3(folderId)：非根目录先插「..」上级（标题字面量 ".."，跳 parentFolderId），
//     再文件夹（o9.a）、再书签（o9.b）；无搜索框
//   · j3()：标题 = 根目录 j「书签」，否则文件夹名，空标题回退 bh=a0i「无标题」
//   · l3()：点文件夹 → n3(该 id) 下钻；点书签 → l8.a(url,0) 并 X2() 关闭，
//     onDismiss 回传 result → k6.K3 → k6.Ra(url) → Ta/Ua 在当前标签打开
//   · T1()：窗口 = min(屏宽*4/5, 450dp) × min(屏高*4/5, 600dp)
//   · 排序 cb/b.c：先「..」再文件夹再书签

// 对话框条目：文件夹 / 「..」上级 / 书签
export class PickerEntry {
  isFolder: boolean = false
  isParent: boolean = false
  title: string = ''
  url: string = ''
  // 文件夹 id 或书签 id（用于稳定 key）
  id: number = 0
}

@ComponentV2
export struct BookmarkPickerDialog {
  // 初始文件夹（原版 p3(bundle.folder)；W9() 走 o3() 无参 → 根目录）
  @Param initialFolderId: number = 0
  // 选中书签后回调（原版 l3 → onDismiss result → k6.K3 → k6.Ra）
  @Event onPickUrl: (url: string) => void = (url: string): void => {
  }
  @Event onDismiss: () => void = (): void => {
  }

  private db: BrowserDb = BrowserDb.getInstance()
  @Local currentFolderId: number = 0
  // 从根到当前文件夹的路径（用于「..」上级与标题）
  @Local folderChain: BookmarkFolderRec[] = []
  @Local entries: PickerEntry[] = []
  // 原版 a8/k.T1()：窗口 = min(屏宽*4/5,450dp) × min(屏高*4/5,600dp)
  @Local dialogWidthVp: number = 288
  @Local dialogHeightVp: number = 480

  aboutToAppear(): void {
    const size: number[] = a8kWindowSizeVp()
    this.dialogWidthVp = size[0]
    this.dialogHeightVp = size[1]
    this.currentFolderId = this.initialFolderId
    this.openFolder(this.initialFolderId)
  }

  // 原版 n3(folderId)：切到指定文件夹并按 parentId 重建路径后重载条目
  private openFolder(folderId: number): void {
    this.currentFolderId = folderId
    this.buildChain(folderId).then((chain: BookmarkFolderRec[]) => {
      this.folderChain = chain
      this.reloadEntries()
    }).catch((error: BusinessError) => {
      console.error(`walk bookmark folders failed: ${error.message}`)
      this.folderChain = []
      this.reloadEntries()
    })
  }

  // 原版 o9.a.d()（parentFolderId）逐级上溯到根（根 id = 0）
  private async buildChain(folderId: number): Promise<BookmarkFolderRec[]> {
    const chain: BookmarkFolderRec[] = []
    let cursor: number = folderId
    let guard: number = 0
    while (cursor !== 0 && guard < 32) {
      const rec: BookmarkFolderRec | null = await this.db.getBookmarkFolder(cursor)
      if (rec === null) {
        break
      }
      chain.unshift(rec)
      cursor = rec.parentId
      guard = guard + 1
    }
    return chain
  }

  // 原版 k3：组装当前文件夹条目（「..」上级 + 文件夹 + 书签）
  private reloadEntries(): void {
    const folderId: number = this.currentFolderId
    this.db.listBookmarkFolders(folderId).then((folders: BookmarkFolderRec[]) => {
      this.db.listBookmarks(folderId).then((marks: BookmarkRec[]) => {
        const list: PickerEntry[] = []
        if (folderId !== 0) {
          const parent: PickerEntry = new PickerEntry()
          parent.isFolder = true
          parent.isParent = true
          parent.title = '..'
          list.push(parent)
        }
        for (let i = 0; i < folders.length; i++) {
          const f: BookmarkFolderRec = folders[i]
          const e: PickerEntry = new PickerEntry()
          e.isFolder = true
          e.title = f.title
          e.id = f.id
          list.push(e)
        }
        for (let i = 0; i < marks.length; i++) {
          const m: BookmarkRec = marks[i]
          const e: PickerEntry = new PickerEntry()
          e.isFolder = false
          e.title = m.title
          e.url = m.url
          e.id = m.id
          list.push(e)
        }
        this.entries = list
      }).catch((error: BusinessError) => {
        console.error(`load bookmarks failed: ${error.message}`)
        this.entries = []
      })
    }).catch((error: BusinessError) => {
      console.error(`load bookmark folders failed: ${error.message}`)
      this.entries = []
    })
  }

  // 原版 j3：根目录标题 = j「书签」；文件夹标题为空回退 a0i「无标题」
  private dialogTitle(): string {
    if (this.folderChain.length === 0) {
      return '书签'
    }
    const cur: BookmarkFolderRec = this.folderChain[this.folderChain.length - 1]
    return cur.title.trim() === '' ? '无标题' : cur.title
  }

  // 原版 l3：文件夹（含「..」）→ 下钻/回上级；书签 → 回调关闭
  private onEntryTap(entry: PickerEntry): void {
    if (entry.isFolder) {
      if (entry.isParent) {
        if (this.folderChain.length <= 1) {
          this.openFolder(0)
          return
        }
        this.openFolder(this.folderChain[this.folderChain.length - 2].id)
        return
      }
      this.openFolder(entry.id)
      return
    }
    if (entry.url !== '') {
      this.onPickUrl(entry.url)
    }
  }

  build() {
    Column() {
      // 标题（原版 F0 / x7.p.H1：16sp 加粗单行）
      Text(this.dialogTitle())
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .width('100%')
        .padding({ left: 16, right: 16, top: 12, bottom: 8 })

      if (this.entries.length === 0) {
        // 原版 r3.e：空态文案 "¯\\_(ツ)_/¯"
        Text('¯\\_(ツ)_/¯')
          .fontSize(14)
          .fontColor($r('app.color.fg_secondary'))
          .width('100%')
          .textAlign(TextAlign.Center)
          .padding({ top: 32, bottom: 32 })
      } else {
        List() {
          ForEach(this.entries, (entry: PickerEntry) => {
            ListItem() {
              Row({ space: 12 }) {
                // 原版 cb/a 行：文件夹用文件夹图标（x7.o.f13721e0），书签用站点 favicon
                if (entry.isFolder) {
                  UiaIcon({ icon: $r('app.media.uia_ic_bookmark'), iconSize: 22, iconColor: $r('app.color.fg') })
                } else {
                  UiaIcon({ icon: $r('app.media.uia_ic_webpage'), iconSize: 22, iconColor: $r('app.color.fg') })
                }
                Column({ space: 2 }) {
                  Text(entry.title.trim() === '' ? '无标题' : entry.title)
                    .fontSize(15)
                    .fontColor($r('app.color.fg'))
                    .maxLines(1)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                    .width('100%')
                    .textAlign(TextAlign.Start)
                  if (!entry.isFolder && entry.url !== '') {
                    Text(entry.url)
                      .fontSize(12)
                      .fontColor($r('app.color.fg_secondary'))
                      .maxLines(1)
                      .textOverflow({ overflow: TextOverflow.Ellipsis })
                      .width('100%')
                  }
                }
                .layoutWeight(1)
                .alignItems(HorizontalAlign.Start)
              }
              .width('100%')
              .padding({ left: 16, right: 16, top: 10, bottom: 10 })
              .onClick(() => {
                this.onEntryTap(entry)
              })
            }
          }, (entry: PickerEntry) => `${entry.isFolder ? 'f' : 'b'}${entry.id}_${entry.isParent ? 'up' : ''}`)
        }
        .width('100%')
        .layoutWeight(1)
        .scrollBar(BarState.Auto)
      }

      // 原版无按钮，靠外点/返回键取消；此处给出显式取消入口
      Row() {
        Blank()
        Text('关闭')
          .fontSize(15)
          .fontColor($r('app.color.accent'))
          .padding({ left: 16, right: 16, top: 10, bottom: 12 })
          .onClick(() => {
            this.onDismiss()
          })
      }
      .width('100%')
    }
    .width(this.dialogWidthVp)
    .height(this.dialogHeightVp)
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }
}
