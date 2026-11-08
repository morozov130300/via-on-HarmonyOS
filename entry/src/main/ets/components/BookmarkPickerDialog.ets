import { BookmarkRec, BookmarkFolderRec } from '../common/Types'
import { BrowserDb } from '../common/Database'
import { computeDialogWidthVp } from './ViaDialogCard'
import { dialogTransition } from '../common/Transitions'
import { ViaIcon } from './ViaIcon'

// 原版 a8/k.java：书签快捷选择对话框（k8.a DialogFragment）——
//   · 标题 = 当前文件夹名（空则根目录，fv「书签」/ 空标题回退 bh「无标题」）
//   · 列表 = 文件夹优先 + 书签（cb.a），点文件夹进下一层（含「..」上级项）
//   · 点书签 → 回传给调用方在新标签打开（原版 k.l3 → k6 W9 的回调）
//   · 弹窗尺寸 = min(屏宽*4/5, 450dp) × min(屏高*4/5, 600dp)（a8/k.T1）
//   · 每次打开记住上次所在文件夹与滚动位置（BOOKMARK_DIALOG_CACHE，180 天）
// 本工程用 @ComponentV2 + openCustomDialog 复刻；缓存位置仅保留「文件夹」一级。

// 对话框条目：文件夹或书签二选一
export class PickerEntry {
  isFolder: boolean = false
  isParent: boolean = false
  title: string = ''
  url: string = ''
  folderId: number = 0
  count: number = 0
}

@ComponentV2
export struct BookmarkPickerDialog {
  // 初始文件夹（原版 p3(bundle.folder)）
  @Param initialFolderId: number = 0
  // 选中书签后回调（原版 l3 → 调用方新开标签）
  @Event onPickUrl: (url: string) => void = (url: string): void => {
  }
  @Event onDismiss: () => void = (): void => {
  }

  private db: BrowserDb = BrowserDb.getInstance()
  @Local currentFolderId: number = 0
  // 当前路径栈（用于「..」上级与标题显示）
  @Local folderStack: BookmarkFolderRec[] = []
  @Local entries: PickerEntry[] = []
  @Local folderTitle: string = ''

  aboutToAppear(): void {
    this.currentFolderId = this.initialFolderId
    this.reload()
  }

  private reload(): void {
    const folderId: number = this.currentFolderId
    this.db.listBookmarkFolders(folderId).then((folders: BookmarkFolderRec[]) => {
      this.db.listBookmarks(folderId).then((marks: BookmarkRec[]) => {
        const list: PickerEntry[] = []
        // 原版 k3：非根目录时列表首项为「..」上级
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
          e.folderId = f.id
          list.push(e)
        }
        for (let i = 0; i < marks.length; i++) {
          const m: BookmarkRec = marks[i]
          const e: PickerEntry = new PickerEntry()
          e.isFolder = false
          e.title = m.title
          e.url = m.url
          list.push(e)
        }
        this.entries = list
        this.updateTitle()
      })
    })
  }

  // 标题 = 当前文件夹名；根目录显示「书签」；空标题回退「无标题」
  private updateTitle(): void {
    if (this.folderStack.length === 0) {
      this.folderTitle = '书签'
      return
    }
    const cur: BookmarkFolderRec = this.folderStack[this.folderStack.length - 1]
    this.folderTitle = cur.title.trim() === '' ? '无标题' : cur.title
  }

  private openFolder(folderId: number): void {
    this.db.listAllBookmarkFolders().then((all: BookmarkFolderRec[]) => {
      const found: BookmarkFolderRec | undefined = all.find((f: BookmarkFolderRec): boolean => f.id === folderId)
      if (found !== undefined) {
        const stack: BookmarkFolderRec[] = this.folderStack.slice()
        stack.push(found)
        this.folderStack = stack
      }
      this.currentFolderId = folderId
      this.reload()
    })
  }

  private goParent(): void {
    const stack: BookmarkFolderRec[] = this.folderStack.slice()
    stack.pop()
    this.folderStack = stack
    this.currentFolderId = stack.length === 0 ? 0 : stack[stack.length - 1].id
    this.reload()
  }

  build() {
    Column() {
      // 标题栏：文件夹名 + 关闭
      Row() {
        Text(this.folderTitle)
          .fontSize(17)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
          .layoutWeight(1)
        Text('关闭')
          .fontSize(15)
          .fontColor($r('app.color.accent'))
          .onClick(() => {
            this.onDismiss()
          })
      }
      .width('100%')
      .padding({ left: 20, right: 20, top: 18, bottom: 8 })

      if (this.entries.length === 0) {
        Text('暂无书签')
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
                // 文件夹用工程既有语义图标，书签用 AppIcon（原版 favicon）
                if (entry.isFolder) {
                  // 文件夹图标：原版 a8/k.java 用 lb.b.a(x7.o.f13721e0=文件夹) / x7.o.f13774w（书签）
                  // 工程内未提取文件夹专用图标，改用既有书签语义图标 via_ic_bookmark 表示文件夹
                  ViaIcon({ icon: $r('app.media.via_ic_bookmark'), iconSize: 22, iconColor: $r('app.color.fg') })
                    .width(28)
                } else {
                  ViaIcon({ icon: $r('app.media.via_ic_bookmark'), iconSize: 22, iconColor: $r('app.color.fg') })
                    .width(28)
                }
                Column({ space: 2 }) {
                  Text(entry.title.trim() === '' ? '无标题' : entry.title)
                    .fontSize(15)
                    .fontColor($r('app.color.fg'))
                    .maxLines(1)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                    .width('100%')
                  if (!entry.isFolder) {
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
              .padding({ left: 20, right: 20, top: 10, bottom: 10 })
              .onClick(() => {
                if (entry.isFolder) {
                  if (entry.isParent) {
                    this.goParent()
                  } else {
                    this.openFolder(entry.folderId)
                  }
                } else if (entry.url !== '') {
                  this.onPickUrl(entry.url)
                }
              })
            }
          }, (entry: PickerEntry) => `${entry.folderId}_${entry.url}_${entry.title}`)
        }
        .width('100%')
        .layoutWeight(1)
        .scrollBar(BarState.Auto)
      }
    }
    .width(computeDialogWidthVp())
    .constraintSize({ maxWidth: 450 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }
}
