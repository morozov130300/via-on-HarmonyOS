import { TOAST_SHORT } from '../common/ToastDuration'
import { BookmarkRec, BookmarkFolderRec, HomeFavRec } from '../common/Types'
import { computeDialogWidthVp } from '../components/UiaDialogCard'
import { UiaDialogButton } from '../components/UiaDialogButton'
import { dialogTransition, dimTransition } from '../common/Transitions'
import { buildNavSlide } from './PageTransitions'
import { BrowserDb } from '../common/Database'
import { TabStore } from '../common/TabStore'
import { BackupManager } from '../common/Backup'
import { parseBookmarksHtml } from '../common/BookmarkHtml'
import { UiaIcon } from '../components/UiaIcon'
import { AppIcon } from '../components/AppIcon'
import { UiInsets } from '../common/Immersive'
import { BusinessError, pasteboard } from '@kit.BasicServicesKit'
import { common } from '@kit.AbilityKit'
import { util } from '@kit.ArkTS'
import { fileIo, picker } from '@kit.CoreFileKit'
import { systemShare } from '@kit.ShareKit'
import { uniformTypeDescriptor as utd } from '@kit.ArkData'
import { preferences } from '@kit.ArkData'

// 原版 cb/e0.java 1:1 移植（书签页）：
// - 底栏 a0（com.tuyafeng/support/widget/a0.java）：普通态 [更多(nu)|编辑(a3)]，
//   多选态 [全选(ta)/取消全选(d_)、移动(nw)、删除(x)/删除(N)(fj)、打开(ox)|完成(gm)]，
//   k()=隐藏 / j()=禁用 / i()=强调色文本（a0.java:242-243）
// - 更多弹层 c4（e0.c4）：添加书签(c)/新建文件夹(o6)/排序方式(uk)/显示细节(tw)|隐藏细节(ka)/
//   [根目录]导入书签(l0)/备份书签(ie)
// - 排序 d4：[最旧的优先(uj)/最新的优先(ui)/名称顺序(uh)]（cb/b.java 比较器 0=ordering 正序
//   1=ordering 倒序 2=标题）
// - 长按菜单：文件夹 Y3 = [后台打开(af)/新标签打开(ag)/编辑(a3)/添加到主页收藏(e)/删除(x)]，
//   书签 Z3 = 前 5 项 + 复制链接(s)/分享(at)（e0.Z3/Y3）
// - 视图 h0.r：0=紧凑 / 1=细节（第二行显示主机名/文件夹内条目数，h0.w）
// - HTML 导入 K3 → 计数提示 d4「%1$d 个书签已导入」/「无法导入」；导出 I3 →
//   「Uia_书签_yyyyMMdd.html」→ g8 提示「书签备份到：%1$s」，0 书签提示「没有书签~」（e0.a4/b4）

const UI_PREF_NAME: string = 'uia_bookmark_ui'
const KEY_SORT_MODE: string = 'bookmarkSortMode'
const KEY_DETAIL_MODE: string = 'bookmarkDetailMode'

// 文件夹层级导航状态（原版 fp「%1$s 文件夹」/ tb 选择文件夹）
class FolderStackEntry {
  id: number
  title: string

  constructor(id: number, title: string) {
    this.id = id
    this.title = title
  }
}

@ComponentV2
export struct BookmarkPage {
  private db: BrowserDb = BrowserDb.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  private insets: UiInsets = UiInsets.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local items: BookmarkRec[] = []
  @Local folders: BookmarkFolderRec[] = []
  @Local allBookmarks: BookmarkRec[] = []
  @Local allFolders: BookmarkFolderRec[] = []
  @Local query: string = ''
  @Local editing: BookmarkRec | null = null
  @Local creatingFolder: boolean = false
  @Local renamingFolder: BookmarkFolderRec | null = null
  // 0=根目录；非 0 表示当前浏览的文件夹
  @Local currentFolderId: number = 0
  @Local folderStack: FolderStackEntry[] = []
  // 多选（原版 b6.a 选择器 + N0「编辑」进入）
  @Local selecting: boolean = false
  @Local selectedKeys: string[] = []
  // 视图模式（h0.r：0=紧凑 1=细节）
  @Local detailMode: boolean = false
  // 排序（cb.b：0=最旧的优先 1=最新的优先 2=名称顺序）
  @Local sortMode: number = 0
  // 弹层开关（原版 w5.k 锚定弹卡等价 bindPopup）：0=关 1=更多弹层(c4) 2=排序子弹层(d4)
  @Local menuLevel: number = 0
  @Local menuRowKey: string = ''
  // 导入/导出加载态（原版 e4「稍等片刻…」Nh 非取消进度框）
  @Local loading: boolean = false
  // 移动至文件夹弹层（Q3 → a8.b2）
  @Local showFolderPicker: boolean = false
  // favicon 加载失败回退（TabPanel 同款管线）
  @Local faviconFailed: Record<string, boolean> = {}
  private uiStore: preferences.Preferences | null = null

  aboutToAppear(): void {
    this.reload()
    this.loadUiPrefs()
  }

  build() {
    NavDestination() {
      Stack() {
        Column() {
          this.HeaderBar()
          this.SearchField()
          List({ space: 0 }) {
            ForEach(this.visibleFolders(), (folder: BookmarkFolderRec) => {
              ListItem() {
                this.FolderRow(folder)
              }
            }, (folder: BookmarkFolderRec) => `f${folder.id}_${folder.title}`)
            ForEach(this.visibleBookmarks(), (item: BookmarkRec) => {
              ListItem() {
                this.BookmarkRowView(item)
              }
            }, (item: BookmarkRec) => `b${item.id}_${item.title}`)
          }
          .width('100%')
          .layoutWeight(1)
          .divider({ strokeWidth: 0.5, color: $r('app.color.divider') })
          .onItemDragStart((event: ItemDragInfo, index: number) => {
            return this.dragItemBuilder(this.dragTitle(index))
          })
          .onItemDrop((event: ItemDragInfo, itemIndex: number, insertIndex: number, isSuccess: boolean) => {
            if (!isSuccess || insertIndex < 0 || itemIndex === insertIndex) {
              return
            }
            this.moveItem(itemIndex, insertIndex)
          })

          this.BottomBar()
        }
        .width('100%')
        .height('100%')
        .backgroundColor($r('app.color.page_bg'))

        if (this.editing !== null) {
          BookmarkEditOverlay({
            bookmark: this.editing,
            folderId: this.currentFolderId,
            onClose: () => {
              this.editing = null
            },
            onSaved: () => {
              this.editing = null
              this.reload()
            }
          })
        }
        if (this.creatingFolder) {
          NewFolderOverlay({
            renameTarget: null,
            onClose: () => {
              this.creatingFolder = false
            },
            onSaved: () => {
              this.creatingFolder = false
              this.reload()
            }
          })
        }
        if (this.renamingFolder !== null) {
          NewFolderOverlay({
            renameTarget: this.renamingFolder,
            onClose: () => {
              this.renamingFolder = null
            },
            onSaved: () => {
              this.renamingFolder = null
              this.reload()
            }
          })
        }
        if (this.showFolderPicker) {
          FolderPickerOverlay({
            onClose: () => {
              this.showFolderPicker = false
            },
            onPicked: (folderId: number) => {
              this.showFolderPicker = false
              this.moveSelectedTo(folderId)
            }
          })
        }
        if (this.loading) {
          this.LoadingOverlay()
        }
      }
      .width('100%')
      .height('100%')
    }
    .hideTitleBar(true)
    .padding({ top: this.insets.top })
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
      this.applyFolderParam(ctx)
    })
  }

  // ===== 行渲染 =====

  @Builder
  FolderRow(folder: BookmarkFolderRec) {
    Row({ space: 12 }) {
      if (this.selecting) {
        this.SelectCircle(`f${folder.id}`)
      }
      AppIcon({ icon: $r('sys.symbol.folder'), iconSize: 22, iconColor: $r('app.color.fg') })
      Column({ space: 2 }) {
        Text(folder.title)
          .fontSize(15)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
        if (this.detailMode) {
          Text($r('app.plural.items_count', this.folderChildCount(folder.id)))
            .fontSize(12)
            .fontColor($r('app.color.fg_secondary'))
            .maxLines(1)
            .textOverflow({ overflow: TextOverflow.Ellipsis })
        }
      }
      .layoutWeight(1)
      .alignItems(HorizontalAlign.Start)
    }
    .width('100%')
    .height(this.detailMode ? 58 : 43)
    .padding({ left: 14, right: 14 })
    .opacity(this.isSelected(`f${folder.id}`) || !this.selecting ? 1 : 0.5)
    .onClick(() => {
      if (this.selecting) {
        this.toggleSelect(`f${folder.id}`)
        return
      }
      this.enterFolder(folder)
    })
    .bindPopup(this.menuRowKey === `f${folder.id}`, {
      builder: (): void => {
        this.FolderMenu(folder)
      },
      placement: Placement.Top,
      popupColor: Color.Transparent,
      enableArrow: false,
      autoCancel: true,
      onStateChange: (e: PopupStateChangeParam) => {
        if (!e.isVisible) {
          this.menuRowKey = ''
        }
      }
    })
    .gesture(LongPressGesture({ repeat: false, duration: 500 })
      .onAction(() => {
        this.menuRowKey = `f${folder.id}`
      }))
  }

  @Builder
  BookmarkRowView(item: BookmarkRec) {
    Row({ space: 12 }) {
      if (this.selecting) {
        this.SelectCircle(`b${item.id}`)
      }
      Column() {
        if (this.faviconFailed[`b${item.id}`] === true) {
          UiaIcon({ icon: $r('app.media.uia_ic_webpage'), iconSize: 22, iconColor: $r('app.color.fg') })
        } else {
          Image(this.faviconUrl(item.url))
            .width(22)
            .height(22)
            .objectFit(ImageFit.Contain)
            .onError(() => {
              this.faviconFailed[`b${item.id}`] = true
            })
        }
      }
      .justifyContent(FlexAlign.Center)
      Column({ space: 2 }) {
        Text(item.title !== '' ? item.title : item.url)
          .fontSize(15)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
        if (this.detailMode) {
          Text(this.hostOf(item.url))
            .fontSize(12)
            .fontColor($r('app.color.fg_secondary'))
            .maxLines(1)
            .textOverflow({ overflow: TextOverflow.Ellipsis })
        }
      }
      .layoutWeight(1)
      .alignItems(HorizontalAlign.Start)
    }
    .width('100%')
    .height(this.detailMode ? 58 : 43)
    .padding({ left: 14, right: 14 })
    .opacity(this.isSelected(`b${item.id}`) || !this.selecting ? 1 : 0.5)
    .onClick(() => {
      if (this.selecting) {
        this.toggleSelect(`b${item.id}`)
        return
      }
      // 原版点击书签记录热度（ea/b click_times）
      this.db.clickBookmark(item.id)
      this.tabStore.navigate(item.url)
      this.navPathStack.pop()
    })
    .bindPopup(this.menuRowKey === `b${item.id}`, {
      builder: (): void => {
        this.BookmarkMenu(item)
      },
      placement: Placement.Top,
      popupColor: Color.Transparent,
      enableArrow: false,
      autoCancel: true,
      onStateChange: (e: PopupStateChangeParam) => {
        if (!e.isVisible) {
          this.menuRowKey = ''
        }
      }
    })
    .gesture(LongPressGesture({ repeat: false, duration: 500 })
      .onAction(() => {
        this.menuRowKey = `b${item.id}`
      }))
  }

  @Builder
  SelectCircle(key: string) {
    Stack({ alignContent: Alignment.Center }) {
      Circle()
        .width(20)
        .height(20)
        .fill(this.isSelected(key) ? $r('app.color.accent') : Color.Transparent)
        .stroke(this.isSelected(key) ? $r('app.color.accent') : $r('app.color.fg_secondary'))
        .strokeWidth(1.5)
      if (this.isSelected(key)) {
        AppIcon({ icon: $r('sys.symbol.checkmark'), iconSize: 13, iconColor: Color.White })
      }
    }
    .width(24)
    .height(24)
  }

  @Builder
  LoadingOverlay() {
    // 原版 e4：w5.k「稍等片刻…」非取消进度框（Nh）
    Column() {
      Column({ space: 14 }) {
        LoadingProgress()
          .width(36)
          .height(36)
          .color($r('app.color.accent'))
        Text($r('app.string.read_aloud_wait'))
          .fontSize(14)
          .fontColor($r('app.color.fg'))
      }
      .padding(24)
      .borderRadius(18)
      .border({ width: 1, color: $r('app.color.dialog_border') })
      .backgroundColor($r('app.color.dialog_bg'))
      .transition(dialogTransition())
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .backgroundColor('rgba(0,0,0,0.4)')
    .transition(dimTransition(240))
  }

  // ===== 底栏（a0 1:1）=====

  @Builder
  BottomBar() {
    Column() {
      Divider()
        .strokeWidth(2)
        .color($r('app.color.divider'))
      Row() {
        if (this.selecting) {
          this.BarButton(this.allSelected() ? '取消全选' : '全选', false, (): void => {
            this.toggleSelectAll()
          }, false)
          this.BarButton('移动', this.selectedKeys.length <= 0, (): void => {
            this.showFolderPicker = true
          }, false)
          this.BarButton(this.selectedKeys.length > 0 ? `删除(${this.selectedKeys.length})` : '删除',
            this.selectedKeys.length <= 0, (): void => {
              this.confirmDeleteSelected()
            }, true)
          this.BarButton('打开', this.selectedKeys.length <= 0, (): void => {
            this.openSelected()
          }, false)
          Blank()
          this.BarButton('完成', false, (): void => {
            this.exitSelection()
          }, false)
        } else {
          this.BarButton('更多', false, (): void => {
            this.menuLevel = this.menuLevel === 1 ? 0 : 1
          }, false)
          Blank()
          this.BarButton('编辑', false, (): void => {
            this.enterSelection()
          }, false)
        }
      }
      .width('100%')
      .height(44)
      // 更多/排序子弹层锚定底栏（原版 c4/d4 先后锚定 P0 按钮；同一锚点单弹层互斥切换）
      .bindPopup(this.menuLevel > 0, {
        builder: (): void => {
          if (this.menuLevel === 2) {
            this.SortMenu()
          } else {
            this.MoreMenu()
          }
        },
        placement: Placement.Top,
        popupColor: Color.Transparent,
        enableArrow: false,
        autoCancel: true,
        onStateChange: (e: PopupStateChangeParam) => {
          if (!e.isVisible) {
            this.menuLevel = 0
          }
        }
      })
    }
    .width('100%')
    .backgroundColor($r('app.color.surface'))
  }

  @Builder
  BarButton(label: string, disabled: boolean, action: () => void, accent: boolean) {
    Text(label)
      .fontSize(15)
      .fontColor(disabled ? $r('app.color.fg_secondary') : (accent ? $r('app.color.accent') : $r('app.color.fg')))
      .opacity(disabled ? 0.5 : 1)
      .padding({ left: 16, right: 16, top: 10, bottom: 10 })
      .maxLines(1)
      .textAlign(TextAlign.Center)
      .onClick(() => {
        if (disabled) {
          return
        }
        action()
      })
  }

  // ===== 更多弹层（e0.c4 1:1）=====

  @Builder
  MoreMenu() {
    Column() {
      this.MenuItem('添加书签', false, (): void => {
        this.menuLevel = 0
        const rec = new BookmarkRec()
        rec.folderId = this.currentFolderId
        this.editing = rec
      })
      this.MenuItem('新建文件夹', false, (): void => {
        this.menuLevel = 0
        this.creatingFolder = true
      })
      this.MenuItem('排序方式', false, (): void => {
        this.menuLevel = 2
      })
      this.MenuItem(this.detailMode ? '隐藏细节' : '显示细节', false, (): void => {
        this.menuLevel = 0
        this.detailMode = !this.detailMode
        this.persistUiPrefs()
      })
      if (this.currentFolderId === 0) {
        this.MenuItem('导入书签', false, (): void => {
          this.menuLevel = 0
          this.importBookmarksHtml()
        })
        this.MenuItem('备份书签', false, (): void => {
          this.menuLevel = 0
          this.exportBookmarksHtml()
        })
      }
    }
    .width(200)
    .padding({ top: 8, bottom: 8 })
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
  }

  // 排序子弹层（e0.d4：[最旧的优先 uj / 最新的优先 ui / 名称顺序 uh]，勾选当前项）
  @Builder
  SortMenu() {
    Column() {
      this.MenuItem('最旧的优先', this.sortMode === 0, (): void => {
        this.applySortMode(0)
      })
      this.MenuItem('最新的优先', this.sortMode === 1, (): void => {
        this.applySortMode(1)
      })
      this.MenuItem('名称顺序', this.sortMode === 2, (): void => {
        this.applySortMode(2)
      })
    }
    .width(200)
    .padding({ top: 8, bottom: 8 })
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
  }

  // q0：写回排序并刷新（原版 k1.q0：n1 持久化 + k0 重载）
  private applySortMode(mode: number): void {
    this.menuLevel = 0
    if (this.sortMode !== mode) {
      this.sortMode = mode
      this.persistUiPrefs()
    }
  }

  @Builder
  MenuItem(label: string, checked: boolean, action: () => void) {
    Row({ space: 8 }) {
      Text(label)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .layoutWeight(1)
      if (checked) {
        AppIcon({ icon: $r('sys.symbol.checkmark'), iconSize: 14, iconColor: $r('app.color.accent') })
      }
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 12, bottom: 12 })
    .onClick(() => {
      action()
    })
  }

  // ===== 长按菜单 =====

  // 文件夹菜单（e0.Y3：[后台打开 af/新标签打开 ag/编辑 a3/添加到主页收藏 e/删除 x]）
  @Builder
  FolderMenu(folder: BookmarkFolderRec) {
    Column() {
      this.RowMenuItem('后台打开', (): void => {
        this.openFolderTabs(folder, true)
      })
      this.RowMenuItem('新标签打开', (): void => {
        this.openFolderTabs(folder, false)
      })
      this.RowMenuItem('编辑', (): void => {
        this.renamingFolder = folder
      })
      this.RowMenuItem('添加到主页收藏', (): void => {
        this.addFolderToHome(folder)
      })
      this.RowMenuItem('删除', (): void => {
        this.confirmDeleteFolder(folder)
      })
    }
    .width(200)
    .padding({ top: 8, bottom: 8 })
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
  }

  // 书签菜单（e0.Z3：前 5 项同文件夹 + 复制链接 s/分享 at）
  @Builder
  BookmarkMenu(item: BookmarkRec) {
    Column() {
      this.RowMenuItem('后台打开', (): void => {
        // 原版 l8.a mode 2：新后台标签 + toast pc 已在后台打开
        this.tabStore.newTabAt(item.url, true)
        this.toastMsg('已在后台打开')
      })
      this.RowMenuItem('新标签打开', (): void => {
        this.tabStore.newTabAt(item.url, false)
        this.navPathStack.pop()
      })
      this.RowMenuItem('编辑', (): void => {
        this.editing = item
      })
      this.RowMenuItem('添加到主页收藏', (): void => {
        this.addBookmarkToHome(item)
      })
      this.RowMenuItem('删除', (): void => {
        this.confirmDeleteBookmark(item)
      })
      this.RowMenuItem('复制链接', (): void => {
        this.copyLink(item.url)
      })
      this.RowMenuItem('分享', (): void => {
        this.shareUrl(item.url)
      })
    }
    .width(200)
    .padding({ top: 8, bottom: 8 })
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
  }

  @Builder
  RowMenuItem(label: string, action: () => void) {
    Text(label)
      .fontSize(14)
      .fontColor($r('app.color.fg'))
      .width('100%')
      .padding({ left: 16, right: 16, top: 12, bottom: 12 })
      .maxLines(1)
      .textOverflow({ overflow: TextOverflow.Ellipsis })
      .textAlign(TextAlign.Start)
      .onClick(() => {
        this.menuRowKey = ''
        action()
      })
  }

  // ===== 行为（e0 1:1）=====

  // 文件夹长按打开（e0.q3 pos0/1 → a0(folder) 子书签列表 → I(list)：
  // 后台=全部 mode 2；新标签=首个 mode 1（前台并关页），其余 mode 3 后台）
  private openFolderTabs(folder: BookmarkFolderRec, background: boolean): void {
    this.db.listAllBookmarks().then((all: BookmarkRec[]) => {
      const urls: string[] = []
      for (let i = 0; i < all.length; i++) {
        if (all[i].folderId === folder.id) {
          urls.push(all[i].url)
        }
      }
      if (urls.length === 0) {
        return
      }
      if (background) {
        for (let i = 0; i < urls.length; i++) {
          this.tabStore.newTabAt(urls[i], true)
        }
        this.toastMsg('已在后台打开')
        return
      }
      for (let i = 0; i < urls.length; i++) {
        this.tabStore.newTabAt(urls[i], i > 0)
      }
      this.navPathStack.pop()
    }).catch((error: BusinessError) => {
      console.error(`list folder bookmarks failed: ${error.message}`)
    })
  }

  // 添加到主页收藏（原版 bb.v.x → w9.n s：成功 toast be「已添加到主页收藏」）
  private addBookmarkToHome(item: BookmarkRec): void {
    this.addHomeFav(item.title !== '' ? item.title : item.url, item.url)
  }

  // 文件夹收藏为 folder:// 链接（原版 n9.b(w2.e(folderId, name), name)）
  private addFolderToHome(folder: BookmarkFolderRec): void {
    this.addHomeFav(folder.title, `folder://${folder.id}`)
  }

  private addHomeFav(title: string, url: string): void {
    this.db.listHomeFavs().then((favs: HomeFavRec[]) => {
      for (let i = 0; i < favs.length; i++) {
        if (favs[i].url === url) {
          return
        }
      }
      this.db.addHomeFav(title, url, '', favs.length).then(() => {
        this.toastMsg('已添加到主页收藏')
      }).catch((error: BusinessError) => {
        console.error(`add home fav failed: ${error.message}`)
      })
    }).catch((error: BusinessError) => {
      console.error(`list home favs failed: ${error.message}`)
    })
  }

  private copyLink(url: string): void {
    try {
      pasteboard.getSystemPasteboard().setData(pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, url))
      this.toastMsg('已复制链接')
    } catch (error) {
      console.error('copy link failed')
    }
  }

  // 分享（原版 z8.f1.k：系统分享面板）
  private shareUrl(url: string): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    const shareData: systemShare.SharedData = new systemShare.SharedData({
      utd: utd.UniformDataType.PLAIN_TEXT,
      content: url
    })
    const controller: systemShare.ShareController = new systemShare.ShareController(shareData)
    controller.show(context as common.UIAbilityContext, {
      selectionMode: systemShare.SelectionMode.SINGLE,
      previewMode: systemShare.SharePreviewMode.DETAIL
    }).catch(() => {
      console.error('share bookmark url failed')
    })
  }

  // 删除确认（原版 d3 case4：标题「删除」+「你确定删除 %1$s 吗？」）
  private confirmDeleteBookmark(item: BookmarkRec): void {
    const shown = item.title !== '' ? item.title : item.url
    AlertDialog.show({
      title: $r('app.string.delete'),
      message: `你确定删除 ${shown} 吗？`,
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: $r('app.string.confirm'),
        action: () => {
          this.db.deleteBookmark(item.id).then(() => {
            this.reload()
          }).catch((error: BusinessError) => {
            console.error(`delete bookmark failed: ${error.message}`)
          })
        }
      }
    })
  }

  // 原版 nz「你想要删除此文件夹吗？」：递归删除子文件夹与内含书签
  private confirmDeleteFolder(folder: BookmarkFolderRec): void {
    AlertDialog.show({
      title: folder.title,
      message: $r('app.string.delete_folder_confirm'),
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: $r('app.string.confirm'),
        action: () => {
          this.db.deleteBookmarkFolder(folder.id).then(() => {
            this.reload()
          }).catch((error: BusinessError) => {
            console.error(`delete folder failed: ${error.message}`)
          })
        }
      }
    })
  }

  // ===== 多选（b6.a 1:1）=====

  private enterSelection(): void {
    this.selecting = true
    this.selectedKeys = []
  }

  private exitSelection(): void {
    this.selecting = false
    this.selectedKeys = []
  }

  private isSelected(key: string): boolean {
    return this.selectedKeys.indexOf(key) >= 0
  }

  private toggleSelect(key: string): void {
    const next: string[] = []
    for (let i = 0; i < this.selectedKeys.length; i++) {
      if (this.selectedKeys[i] !== key) {
        next.push(this.selectedKeys[i])
      }
    }
    if (!this.isSelected(key)) {
      next.push(key)
    }
    this.selectedKeys = next
  }

  private allSelected(): boolean {
    return this.selectedKeys.length > 0 &&
      this.selectedKeys.length === this.visibleFolders().length + this.visibleBookmarks().length
  }

  private toggleSelectAll(): void {
    if (this.allSelected()) {
      this.selectedKeys = []
      return
    }
    const keys: string[] = []
    const folders = this.visibleFolders()
    for (let i = 0; i < folders.length; i++) {
      keys.push(`f${folders[i].id}`)
    }
    const bookmarks = this.visibleBookmarks()
    for (let i = 0; i < bookmarks.length; i++) {
      keys.push(`b${bookmarks[i].id}`)
    }
    this.selectedKeys = keys
  }

  // 多选删除（e0.t3 M0：确认框「删除」+「你确定继续吗？」→ P(选中)）
  private confirmDeleteSelected(): void {
    if (this.selectedKeys.length === 0) {
      return
    }
    AlertDialog.show({
      title: $r('app.string.delete'),
      message: $r('app.string.reset_default_msg'),
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: $r('app.string.confirm'),
        action: () => {
          this.deleteSelected()
        }
      }
    })
  }

  private deleteSelected(): void {
    const keys = this.selectedKeys
    const folders = this.visibleFolders()
    const bookmarks = this.visibleBookmarks()
    let pending = 0
    for (let i = 0; i < keys.length; i++) {
      const key = keys[i]
      if (key.startsWith('f')) {
        const folderId = Number(key.substring(1))
        for (let j = 0; j < folders.length; j++) {
          if (folders[j].id === folderId) {
            pending++
            this.db.deleteBookmarkFolder(folderId).catch((error: BusinessError) => {
              console.error(`delete selected folder failed: ${error.message}`)
            })
          }
        }
      } else {
        const bookmarkId = Number(key.substring(1))
        for (let j = 0; j < bookmarks.length; j++) {
          if (bookmarks[j].id === bookmarkId) {
            pending++
            this.db.deleteBookmark(bookmarkId).catch((error: BusinessError) => {
              console.error(`delete selected bookmark failed: ${error.message}`)
            })
          }
        }
      }
    }
    this.exitSelection()
    if (pending > 0) {
      setTimeout(() => {
        this.reload()
      }, 150)
    } else {
      this.reload()
    }
  }

  // 多选打开（e0.t3 R0 → k1.Y/t：选中文件夹的子书签 + 选中书签，首个前台、其余后台，随后关页）
  private openSelected(): void {
    const bookmarks = this.visibleBookmarks()
    const urls: string[] = []
    for (let i = 0; i < this.selectedKeys.length; i++) {
      const key = this.selectedKeys[i]
      if (key.startsWith('f')) {
        const folderId = Number(key.substring(1))
        for (let j = 0; j < this.allBookmarks.length; j++) {
          if (this.allBookmarks[j].folderId === folderId) {
            urls.push(this.allBookmarks[j].url)
          }
        }
        continue
      }
      const id = Number(key.substring(1))
      for (let j = 0; j < bookmarks.length; j++) {
        if (bookmarks[j].id === id) {
          urls.push(bookmarks[j].url)
          break
        }
      }
    }
    if (urls.length === 0) {
      return
    }
    for (let i = 0; i < urls.length; i++) {
      this.tabStore.newTabAt(urls[i], i > 0)
    }
    this.exitSelection()
    this.navPathStack.pop()
  }

  // 目标目录是否位于 folderId 内部（含自身）——移入自身/子孙会成环，跳过
  // （原版 k1.H：目标祖先链上的文件夹从移动列表剔除，等价效果）
  private isFolderInsideOf(folderId: number, targetId: number): boolean {
    let current = folderId
    let guard = 0
    while (current !== 0 && guard < 64) {
      guard++
      if (current === targetId) {
        return true
      }
      let found = false
      for (let i = 0; i < this.allFolders.length; i++) {
        if (this.allFolders[i].id === current) {
          current = this.allFolders[i].parentId
          found = true
          break
        }
      }
      if (!found) {
        break
      }
    }
    return false
  }

  // 多选移动（e0.t3 Q0 → b2 选目录 → k1.j0：书签/文件夹均移入目标目录）
  private moveSelectedTo(targetFolderId: number): void {
    const keys = this.selectedKeys
    if (keys.length === 0) {
      return
    }
    const folders = this.visibleFolders()
    const bookmarks = this.visibleBookmarks()
    this.db.listAllBookmarks().then((all: BookmarkRec[]) => {
      let nextOrdering = 1
      for (let i = 0; i < all.length; i++) {
        if (all[i].folderId === targetFolderId && all[i].ordering >= nextOrdering) {
          nextOrdering = all[i].ordering + 1
        }
      }
      let pending = 0
      for (let i = 0; i < keys.length; i++) {
        const key = keys[i]
        if (key.startsWith('b')) {
          const id = Number(key.substring(1))
          for (let j = 0; j < bookmarks.length; j++) {
            if (bookmarks[j].id === id) {
              const rec = bookmarks[j]
              rec.folderId = targetFolderId
              rec.ordering = nextOrdering
              nextOrdering++
              pending++
              this.db.replaceBookmarkByUrl(rec).catch((error: BusinessError) => {
                console.error(`move bookmark failed: ${error.message}`)
              })
              break
            }
          }
        } else {
          const folderId = Number(key.substring(1))
          // 目标在所选文件夹内部（或就是它）时跳过，避免目录成环（原版 k1.H 等价）
          if (this.isFolderInsideOf(targetFolderId, folderId)) {
            continue
          }
          for (let j = 0; j < folders.length; j++) {
            if (folders[j].id === folderId && folderId !== targetFolderId) {
              const rec = folders[j]
              rec.parentId = targetFolderId
              rec.ordering = nextOrdering
              nextOrdering++
              pending++
              this.db.replaceBookmarkFolderById(rec).catch((error: BusinessError) => {
                console.error(`move folder failed: ${error.message}`)
              })
              break
            }
          }
        }
      }
      this.exitSelection()
      if (pending > 0) {
        setTimeout(() => {
          this.reload()
        }, 150)
      } else {
        this.reload()
      }
    }).catch((error: BusinessError) => {
      console.error(`move selected failed: ${error.message}`)
    })
  }

  // ===== HTML 导入/导出（e0.K3/I3 → k1.B/Q 1:1）=====

  // K3：选择 text/html → 解析合并 → b4：>0 toast「%1$d 个书签已导入」，否则「无法导入」
  private importBookmarksHtml(): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    const docPicker = new picker.DocumentViewPicker(context as common.UIAbilityContext)
    const options = new picker.DocumentSelectOptions()
    options.maxSelectNumber = 1
    docPicker.select(options).then((uris: string[]) => {
      if (uris === undefined || uris === null || uris.length === 0) {
        return
      }
      this.loading = true
      try {
        const file = fileIo.openSync(uris[0], fileIo.OpenMode.READ_ONLY)
        let html = ''
        try {
          const stat = fileIo.statSync(file.fd)
          const buf = new ArrayBuffer(stat.size)
          fileIo.readSync(file.fd, buf)
          html = util.TextDecoder.create('utf-8').decodeToString(new Uint8Array(buf))
        } finally {
          fileIo.closeSync(file)
        }
        const tree = parseBookmarksHtml(html)
        const count = tree.bookmarks.length
        BackupManager.getInstance().importBookmarksHtml(html).then(() => {
          this.loading = false
          this.reload()
          if (count > 0) {
            this.toastMsg(`${count} 个书签已导入`)
          } else {
            this.toastMsg('无法导入')
          }
        }).catch((error: BusinessError) => {
          this.loading = false
          console.error(`import bookmarks failed: ${error.message}`)
          this.toastMsg('无法导入')
        })
      } catch (error) {
        this.loading = false
        const err = error as BusinessError
        console.error(`read bookmark html failed: ${err.code} ${err.message}`)
        this.toastMsg('无法导入')
      }
    }).catch((error: BusinessError) => {
      console.error(`pick bookmark html failed: ${error.message}`)
    })
  }

  // I3：建「Uia_书签_yyyyMMdd.html」→ 写 HTML → a4：0 书签 toast「没有书签~」，
  // 否则弹「提示 / 书签备份到：%1$s」
  private exportBookmarksHtml(): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    const docPicker = new picker.DocumentViewPicker(context as common.UIAbilityContext)
    const options = new picker.DocumentSaveOptions()
    options.newFileNames = [`Uia_书签_${formatDateStamp(new Date())}.html`]
    options.fileSuffixChoices = ['.html']
    docPicker.save(options).then((uris: string[]) => {
      if (uris === undefined || uris === null || uris.length === 0) {
        return
      }
      this.loading = true
      BackupManager.getInstance().listBookmarksForExport().then((html: string) => {
        const bookmarkCount = parseBookmarksHtml(html).bookmarks.length
        try {
          const target = fileIo.openSync(uris[0], fileIo.OpenMode.WRITE_ONLY | fileIo.OpenMode.TRUNC)
          try {
            fileIo.writeSync(target.fd, html)
          } finally {
            fileIo.closeSync(target)
          }
          this.loading = false
          if (bookmarkCount === 0) {
            this.toastMsg('没有书签~')
            return
          }
          AlertDialog.show({
            title: $r('app.string.ai_unsaved_title'),
            message: `书签备份到：${uris[0]}`,
            primaryButton: {
              value: $r('app.string.confirm'),
              action: () => {
              }
            }
          })
        } catch (error) {
          this.loading = false
          const err = error as BusinessError
          console.error(`write bookmark html failed: ${err.code} ${err.message}`)
        }
      }).catch((error: BusinessError) => {
        this.loading = false
        console.error(`build bookmark html failed: ${error.message}`)
      })
    }).catch((error: BusinessError) => {
      console.error(`save bookmark html failed: ${error.message}`)
    })
  }

  // ===== 视图/排序/拖拽 =====

  // 拖拽重排（e0.e ItemTouchHelper：排序=名称顺序或搜索时禁用；仅书签行参与）
  private dragTitle(index: number): string {
    const folders = this.visibleFolders()
    if (index < folders.length) {
      return folders[index].title
    }
    const item = this.visibleBookmarks()[index - folders.length]
    return item === undefined ? '' : item.title
  }

  private moveItem(from: number, to: number): void {
    if (this.sortMode === 2 || this.query.trim() !== '') {
      // 原版 e.y：名称顺序排序与搜索态禁用拖拽
      this.reload()
      return
    }
    const folders = this.visibleFolders()
    if (from < folders.length || to < folders.length) {
      return
    }
    const fromIdx = from - folders.length
    const toIdx = to - folders.length
    const bookmarks = this.visibleBookmarks()
    if (fromIdx < 0 || toIdx < 0 || fromIdx >= bookmarks.length || toIdx >= bookmarks.length || fromIdx === toIdx) {
      return
    }
    const next: BookmarkRec[] = []
    for (let i = 0; i < bookmarks.length; i++) {
      next.push(bookmarks[i])
    }
    const moved = next[fromIdx]
    next.splice(fromIdx, 1)
    next.splice(toIdx, 0, moved)
    const ids: number[] = []
    for (let i = 0; i < next.length; i++) {
      ids.push(next[i].id)
    }
    this.db.reorderBookmarks(ids).then(() => {
      this.reload()
    }).catch((error: BusinessError) => {
      console.error(`reorder bookmarks failed: ${error.message}`)
    })
  }

  // ===== 数据 =====

  private visibleFolders(): BookmarkFolderRec[] {
    const list = this.sortedFolders()
    return list
  }

  private visibleBookmarks(): BookmarkRec[] {
    return this.filteredSortedItems()
  }

  private sortedFolders(): BookmarkFolderRec[] {
    const result: BookmarkFolderRec[] = []
    for (let i = 0; i < this.folders.length; i++) {
      result.push(this.folders[i])
    }
    if (this.sortMode === 1) {
      result.sort((a: BookmarkFolderRec, b: BookmarkFolderRec): number => b.ordering - a.ordering)
    } else if (this.sortMode === 2) {
      result.sort((a: BookmarkFolderRec, b: BookmarkFolderRec): number => a.title.localeCompare(b.title, 'zh'))
    } else {
      result.sort((a: BookmarkFolderRec, b: BookmarkFolderRec): number => a.ordering - b.ordering)
    }
    return result
  }

  // cb.b 比较器：0=ordering 正序（最旧的优先）1=ordering 倒序（最新的优先）2=标题（名称顺序）
  private filteredSortedItems(): BookmarkRec[] {
    const keyword = this.query.trim().toLowerCase()
    let list: BookmarkRec[] = []
    if (keyword === '') {
      for (let i = 0; i < this.items.length; i++) {
        list.push(this.items[i])
      }
    } else {
      for (let i = 0; i < this.items.length; i++) {
        const item = this.items[i]
        if (item.title.toLowerCase().includes(keyword) || item.url.toLowerCase().includes(keyword)) {
          list.push(item)
        }
      }
    }
    if (this.sortMode === 1) {
      list = list.sort((a: BookmarkRec, b: BookmarkRec): number => b.ordering - a.ordering)
    } else if (this.sortMode === 2) {
      list = list.sort((a: BookmarkRec, b: BookmarkRec): number => a.title.localeCompare(b.title, 'zh'))
    } else {
      list = list.sort((a: BookmarkRec, b: BookmarkRec): number => a.ordering - b.ordering)
    }
    return list
  }

  private folderChildCount(folderId: number): number {
    let count = 0
    for (let i = 0; i < this.allBookmarks.length; i++) {
      if (this.allBookmarks[i].folderId === folderId) {
        count++
      }
    }
    return count
  }

  private hostOf(url: string): string {
    const withoutScheme = url.replace(/^https?:\/\//, '')
    const slash = withoutScheme.indexOf('/')
    return slash < 0 ? withoutScheme : withoutScheme.substring(0, slash)
  }

  private faviconUrl(url: string): string {
    const host = this.hostOf(url)
    if (host === '') {
      return ''
    }
    return `https://${host}/favicon.ico`
  }

  private toastMsg(message: string): void {
    this.getUIContext().getPromptAction().showToast({ message: message, duration: TOAST_SHORT })
  }

  // 视图/排序持久化（原版 w9.l h(viewMode)/n1(sortMode) 设置位）
  private async loadUiPrefs(): Promise<void> {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    try {
      this.uiStore = await preferences.getPreferences(context, UI_PREF_NAME)
      const sort = await this.uiStore.get(KEY_SORT_MODE, 0)
      const detail = await this.uiStore.get(KEY_DETAIL_MODE, false)
      if (typeof sort === 'number') {
        this.sortMode = sort
      }
      if (typeof detail === 'boolean') {
        this.detailMode = detail
      }
    } catch (error) {
      const err = error as BusinessError
      console.error(`load bookmark ui prefs failed: ${err.message}`)
    }
  }

  private persistUiPrefs(): void {
    if (this.uiStore === null) {
      return
    }
    this.uiStore.put(KEY_SORT_MODE, this.sortMode).catch((error: BusinessError) => {
      console.error(`put sort mode failed: ${error.message}`)
    })
    this.uiStore.put(KEY_DETAIL_MODE, this.detailMode).catch((error: BusinessError) => {
      console.error(`put detail mode failed: ${error.message}`)
    })
    this.uiStore.flush().catch((error: BusinessError) => {
      console.error(`flush bookmark ui prefs failed: ${error.message}`)
    })
  }

  // 深链参数（Index.openBookmarksAtFolder）：folder=数字文件夹 id、folderName=名称。
  // 对应原版 k6.u 8657（v://bookmarks/?folder=&folderName=）与 8567（folder://X）
  private applyFolderParam(ctx: NavDestinationContext): void {
    try {
      const rawParams: string | undefined = JSON.stringify(ctx.pathStack.getParamByName('bookmarks'))
      const params: string[] = rawParams !== undefined && rawParams !== 'undefined' && rawParams !== '[]'
        ? JSON.parse(rawParams) as string[] : []
      if (params.length === 0) {
        return
      }
      const param: string = params[params.length - 1]
      if (typeof param !== 'string' || param === '') {
        return
      }
      const obj = JSON.parse(param) as Record<string, string>
      const folderRaw = obj['folder'] ?? ''
      if (folderRaw === '' || Number.isNaN(Number(folderRaw))) {
        return
      }
      const folderId = Number(folderRaw)
      if (folderId === this.currentFolderId) {
        return
      }
      this.currentFolderId = folderId
      this.folderStack = [new FolderStackEntry(folderId, obj['folderName'] ?? '')]
      this.reload()
    } catch (error) {
      console.error('read bookmark folder param failed')
    }
  }

  @Builder
  HeaderBar() {
    Row() {
      Stack({ alignContent: Alignment.Center }) {
        UiaIcon({ icon: $r('app.media.uia_ic_back'), iconSize: 22, iconColor: $r('app.color.fg') })
      }
        .width(44)
        .height(43)
        .onClick(() => {
          this.navigateBack()
        })

      Row() {
        Text(this.currentFolderId === 0 ? $r('app.string.bookmarks') : this.currentFolderTitle())
          .fontSize(15)
          .fontColor($r('app.color.fg'))
          .padding({ left: 10, right: 10, top: 10, bottom: 10 })
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
          .onClick(() => {
          })
        if (this.currentFolderId === 0) {
          Text($r('app.string.history'))
            .fontSize(15)
            .fontColor($r('app.color.fg_secondary'))
            .padding({ left: 10, right: 10, top: 10, bottom: 10 })
            .onClick(() => {
              this.navPathStack.replacePathByName('history', '', true)
            })
          Text($r('app.string.offline_page'))
            .fontSize(15)
            .fontColor($r('app.color.fg_secondary'))
            .padding({ left: 10, right: 10, top: 10, bottom: 10 })
            .onClick(() => {
              this.navPathStack.pushPathByName('offlinePage', '', true)
            })
        }
      }
      .layoutWeight(1)
      .justifyContent(FlexAlign.Center)
    }
    .width('100%')
    .height(43)
  }

  @Builder
  SearchField() {
    TextInput({ placeholder: $r('app.string.search') })
      .height(33)
      .fontSize(14)
      .placeholderFont({ size: 14 })
      .placeholderColor($r('app.color.fg_secondary'))
      .fontColor($r('app.color.fg'))
      .caretColor($r('app.color.accent'))
      .backgroundColor($r('app.color.surface'))
      .borderRadius(17)
      .margin({ left: 12, right: 12, top: 5, bottom: 5 })
      .onChange((value: string) => {
        this.query = value
      })
  }

  @Builder
  dragItemBuilder(title: string) {
    Column() {
      Text(title)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
    }
    .width(200)
    .height(40)
    .padding({ left: 12, right: 12 })
    .justifyContent(FlexAlign.Center)
    .borderRadius(8)
    .backgroundColor($r('app.color.surface'))
  }

  private currentFolderTitle(): string {
    if (this.folderStack.length === 0) {
      return ''
    }
    return this.folderStack[this.folderStack.length - 1].title
  }

  // 原版文件夹层级：进入子文件夹（fp %1$s 文件夹），返回上级或退出页面
  private enterFolder(folder: BookmarkFolderRec): void {
    this.folderStack.push(new FolderStackEntry(folder.id, folder.title))
    this.currentFolderId = folder.id
    this.query = ''
    this.reload()
  }

  private navigateBack(): void {
    if (this.folderStack.length > 0) {
      this.folderStack.pop()
      const parent = this.folderStack.length > 0 ? this.folderStack[this.folderStack.length - 1] : null
      this.currentFolderId = parent !== null ? parent.id : 0
      this.reload()
      return
    }
    this.navPathStack.pop()
  }

  private reload(): void {
    this.db.listBookmarks(this.currentFolderId).then((items: BookmarkRec[]) => {
      this.items = items
    }).catch((error: BusinessError) => {
      console.error(`list bookmarks failed: ${error.message}`)
    })
    this.db.listBookmarkFolders(this.currentFolderId).then((folders: BookmarkFolderRec[]) => {
      this.folders = folders
    }).catch((error: BusinessError) => {
      console.error(`list folders failed: ${error.message}`)
    })
    this.db.listAllBookmarks().then((all: BookmarkRec[]) => {
      this.allBookmarks = all
    }).catch((error: BusinessError) => {
      console.error(`list all bookmarks failed: ${error.message}`)
    })
    this.db.listAllBookmarkFolders().then((all: BookmarkFolderRec[]) => {
      this.allFolders = all
    }).catch((error: BusinessError) => {
      console.error(`list all folders failed: ${error.message}`)
    })
  }
}

// 原版 z8.t1.d（yyyyMMdd）
function formatDateStamp(date: Date): string {
  const y = date.getFullYear().toString()
  const m = date.getMonth() + 1
  const d = date.getDate()
  const mm = m < 10 ? `0${m}` : m.toString()
  const dd = d < 10 ? `0${d}` : d.toString()
  return `${y}${mm}${dd}`
}

// 书签编辑/新建弹层（新建：bookmark.id === -1 时入库到 folderId）
@ComponentV2
struct BookmarkEditOverlay {
  @Param bookmark: BookmarkRec | null = null
  @Param folderId: number = 0
  @Event onClose: () => void = () => {}
  @Event onSaved: () => void = () => {}
  @Local name: string = ''
  @Local address: string = ''
  private db: BrowserDb = BrowserDb.getInstance()

  aboutToAppear(): void {
    if (this.bookmark !== null) {
      this.name = this.bookmark.title
      this.address = this.bookmark.url
    }
  }

  build() {
    Column() {
      Column({ space: 16 }) {
        Text(this.bookmark !== null && this.bookmark.id === -1
          ? $r('app.string.new_bookmark') : $r('app.string.edit_bookmark'))
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
        Column({ space: 8 }) {
          Text($r('app.string.name_label'))
            .fontSize(12)
            .fontColor($r('app.color.fg_secondary'))
          TextInput({ text: this.name })
            .height(40)
            .fontSize(14)
            .backgroundColor($r('app.color.surface'))
            .fontColor($r('app.color.fg'))
            .caretColor($r('app.color.accent'))
            .onChange((value: string) => {
              this.name = value
            })
          Text($r('app.string.address_label'))
            .fontSize(12)
            .fontColor($r('app.color.fg_secondary'))
          TextInput({ text: this.address })
            .height(40)
            .fontSize(14)
            .backgroundColor($r('app.color.surface'))
            .fontColor($r('app.color.fg'))
            .caretColor($r('app.color.accent'))
            .onChange((value: string) => {
              this.address = value
            })
        }
        .alignItems(HorizontalAlign.Start)
        Row() {
          Blank().layoutWeight(1)
          UiaDialogButton({ label: $r('app.string.cancel'), onAction: () => {
            this.onClose()
          } })
          UiaDialogButton({ label: $r('app.string.save'), onAction: () => {
            this.save()
          } })
        }
        .width('100%')
      }
      .width('100%')
      .padding(20)
      .borderRadius(18)
      .border({ width: 1, color: $r('app.color.dialog_border') })
      .backgroundColor($r('app.color.dialog_bg'))
      .transition(dialogTransition())
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .backgroundColor('rgba(0,0,0,0.4)')
    .transition(dimTransition(240))
    .onClick(() => {
      this.onClose()
    })
  }

  private save(): void {
    const name = this.name.trim()
    const address = this.address.trim()
    if (name === '' || address === '') {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.invalid_input'), duration: TOAST_SHORT })
      return
    }
    const url = /^https?:\/\//i.test(address) ? address : `https://${address}`
    if (this.bookmark !== null && this.bookmark.id === -1) {
      this.db.addBookmark(name, url, this.folderId).then(() => {
        this.onSaved()
      }).catch((error: BusinessError) => {
        console.error(`add bookmark failed: ${error.message}`)
      })
      return
    }
    if (this.bookmark !== null) {
      this.db.updateBookmark(this.bookmark.id, name, url).then(() => {
        this.onSaved()
      }).catch((error: BusinessError) => {
        console.error(`update bookmark failed: ${error.message}`)
      })
    }
  }
}

// 原版 o6「新建文件夹」弹层 / a8.d0 重命名弹层（renameTarget 非空时改名）
@ComponentV2
struct NewFolderOverlay {
  @Param renameTarget: BookmarkFolderRec | null = null
  @Event onClose: () => void = () => {}
  @Event onSaved: () => void = () => {}
  @Local name: string = ''
  private db: BrowserDb = BrowserDb.getInstance()

  aboutToAppear(): void {
    if (this.renameTarget !== null) {
      this.name = this.renameTarget.title
    }
  }

  build() {
    Column() {
      Column({ space: 16 }) {
        Text(this.renameTarget !== null ? $r('app.string.edit') : $r('app.string.new_folder'))
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
        TextInput({ placeholder: $r('app.string.name_label'), text: this.name })
          .height(40)
          .fontSize(14)
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .caretColor($r('app.color.accent'))
          .onChange((value: string) => {
            this.name = value
          })
        Row() {
          Blank().layoutWeight(1)
          UiaDialogButton({ label: $r('app.string.cancel'), onAction: () => {
            this.onClose()
          } })
          UiaDialogButton({ label: $r('app.string.save'), onAction: () => {
            this.save()
          } })
        }
        .width('100%')
      }
      .width('100%')
      .padding(20)
      .borderRadius(18)
      .border({ width: 1, color: $r('app.color.dialog_border') })
      .backgroundColor($r('app.color.dialog_bg'))
      .transition(dialogTransition())
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .backgroundColor('rgba(0,0,0,0.4)')
    .transition(dimTransition(240))
    .onClick(() => {
      this.onClose()
    })
  }

  private save(): void {
    const name = this.name.trim()
    if (name === '') {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.invalid_input'), duration: TOAST_SHORT })
      return
    }
    if (this.renameTarget !== null) {
      this.db.renameBookmarkFolder(this.renameTarget.id, name).then(() => {
        this.onSaved()
      }).catch((error: BusinessError) => {
        console.error(`rename folder failed: ${error.message}`)
      })
      return
    }
    this.db.addBookmarkFolder(name, 0).then(() => {
      this.onSaved()
    }).catch((error: BusinessError) => {
      console.error(`add folder failed: ${error.message}`)
    })
  }
}

// 移动至文件夹选择弹层（e0.Q3 → a8.b2 目录树等价：平铺 + 缩进）
@ComponentV2
struct FolderPickerOverlay {
  @Event onClose: () => void = () => {}
  @Event onPicked: (folderId: number) => void = (folderId: number) => {}
  @Local folders: BookmarkFolderRec[] = []
  private db: BrowserDb = BrowserDb.getInstance()

  aboutToAppear(): void {
    this.db.listAllBookmarkFolders().then((folders: BookmarkFolderRec[]) => {
      this.folders = folders
    }).catch((error: BusinessError) => {
      console.error(`list all folders failed: ${error.message}`)
    })
  }

  // 目录深度（缩进用）：沿 parentId 上溯
  private depthOf(folder: BookmarkFolderRec): number {
    let depth = 0
    let currentId = folder.parentId
    let guard = 0
    while (currentId !== 0 && guard < 32) {
      guard++
      let found = false
      for (let i = 0; i < this.folders.length; i++) {
        if (this.folders[i].id === currentId) {
          currentId = this.folders[i].parentId
          found = true
          break
        }
      }
      if (!found) {
        break
      }
      depth++
    }
    return depth
  }

  build() {
    Column() {
      Column({ space: 12 }) {
        Text('移动至…')
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
        List() {
          ListItem() {
            Text($r('app.string.bookmarks'))
              .fontSize(14)
              .fontColor($r('app.color.fg'))
              .width('100%')
              .height(40)
              .padding({ left: 12, right: 12 })
              .maxLines(1)
              .onClick(() => {
                this.onPicked(0)
              })
          }
          ForEach(this.folders, (folder: BookmarkFolderRec) => {
            ListItem() {
              Row({ space: 8 }) {
                AppIcon({ icon: $r('sys.symbol.folder'), iconSize: 18, iconColor: $r('app.color.fg') })
                Text(folder.title)
                  .fontSize(14)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
              }
              .width('100%')
              .height(40)
              .padding({ left: 12 + this.depthOf(folder) * 18, right: 12 })
              .onClick(() => {
                this.onPicked(folder.id)
              })
            }
          }, (folder: BookmarkFolderRec) => `fp${folder.id}`)
        }
        .width('100%')
        .height(260)
        .borderRadius(8)
        .backgroundColor($r('app.color.surface'))
        Row() {
          Blank().layoutWeight(1)
          UiaDialogButton({ label: $r('app.string.cancel'), onAction: () => {
            this.onClose()
          } })
        }
        .width('100%')
      }
      .width('100%')
      .padding(20)
      .borderRadius(18)
      .border({ width: 1, color: $r('app.color.dialog_border') })
      .backgroundColor($r('app.color.dialog_bg'))
      .transition(dialogTransition())
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .backgroundColor('rgba(0,0,0,0.4)')
    .transition(dimTransition(240))
    .onClick(() => {
      this.onClose()
    })
  }
}

@Builder
export function BookmarkPageBuilder() {
  BookmarkPage()
}
