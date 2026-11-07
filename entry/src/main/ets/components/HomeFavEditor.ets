import { picker } from '@kit.CoreFileKit'
import { display } from '@kit.ArkUI'
import { HomeFavRec } from '../common/Types'
import { BrowserDb } from '../common/Database'
import { isUrlLike, normalizeUrl } from '../common/SearchEngines'
import { AppSettings } from '../common/Settings'
import { HOME_ADV_AREAS } from '../common/HomeStyle'
import { BEZIER_0202_CURVE } from '../common/Transitions'

// 原版 qa.e1 底部弹层：双页 ViewPager2「管理收藏 / 新建」，高度按屏高动态（qa/e1.java:178-198）
@ComponentV2
export struct HomeFavEditor {
  @Event onClose: () => void = () => {}
  @Local page: number = 0
  @Local favs: HomeFavRec[] = []
  // 删除撤销状态（原版 qa.v0.j3 删除 + Snackbar 撤销）
  @Local deletedIndex: number = -1
  @Local deletedTitle: string = ''
  private deletedItem: HomeFavRec | null = null
  // 新建表单状态
  @Local newName: string = ''
  @Local newUrl: string = ''
  @Local newIcon: string = ''
  @Local nameError: boolean = false
  @Local urlError: boolean = false
  // 原版 g6.y.X(view) 抖动：translationX 0→24dp→0，280ms，repeatCount=2、repeatMode=REVERSE、
  // 插值器 x8.h.b() = PathInterpolator(0.2,0.2,0.8,0.8)（g6/y.java 492-501 行）
  @Local nameShake: number = 0
  @Local urlShake: number = 0
  @Local editingId: number = -1
  private db: BrowserDb = BrowserDb.getInstance()
  private settings: AppSettings = AppSettings.getInstance()
  private screenW: number = 360

  aboutToAppear(): void {
    try {
      const d = display.getDefaultDisplaySync()
      this.screenW = d.width / d.densityPixels
    } catch (error) {
      console.error('get display failed')
    }
    this.reload()
  }

  private reload(): void {
    this.db.listHomeFavs().then((items: HomeFavRec[]) => {
      this.favs = items
    })
  }

  build() {
    Column() {
      // 顶部页签切换（原版 ViewPager2 + 双 tab 文案）
      Row() {
        Text($r('app.string.manage_home_favs'))
          .fontSize(15)
          .fontWeight(FontWeight.Medium)
          .fontColor(this.page === 0 ? $r('app.color.accent') : $r('app.color.fg_secondary'))
          .padding(12)
          .onClick(() => {
            this.page = 0
          })
        Text($r('app.string.new_home_fav'))
          .fontSize(15)
          .fontWeight(FontWeight.Medium)
          .fontColor(this.page === 1 ? $r('app.color.accent') : $r('app.color.fg_secondary'))
          .padding(12)
          .onClick(() => {
            this.page = 1
          })
      }
      .width('100%')
      .justifyContent(FlexAlign.Center)

      if (this.page === 0) {
        this.ManagePage()
      } else {
        this.FormPage()
      }

      // 原版 qa.v0.j3：删除后 Snackbar「“标题”已删除」+ 撤销
      if (this.deletedIndex >= 0) {
        Row({ space: 12 }) {
          Text($r('app.string.home_fav_deleted', this.deletedTitle))
            .fontSize(14)
            .fontColor(Color.White)
            .maxLines(1)
            .textOverflow({ overflow: TextOverflow.Ellipsis })
            .layoutWeight(1)
          Text($r('app.string.undo'))
            .fontSize(14)
            .fontColor($r('app.color.accent'))
            .padding({ left: 12, right: 12, top: 8, bottom: 8 })
            .onClick(() => {
              this.undoDelete()
            })
        }
        .width('100%')
        .padding({ left: 16, right: 8, top: 10, bottom: 10 })
        .backgroundColor('#323232')
      }
    }
    .width('100%')
    .height('100%')
    .backgroundColor($r('app.color.surface'))
    .borderRadius({ topLeft: 16, topRight: 16 })
  }

  // 原版 qa.v0：GridLayoutManager 拖拽排序（ForEach.onMove，API 26）
  @Builder
  ManagePage() {
    Scroll() {
      Grid() {
        ForEach(this.favs, (item: HomeFavRec, index: number) => {
          GridItem() {
            Column({ space: 4 }) {
              Stack() {
                if (item.icon !== '') {
                  Image(item.icon)
                    .width(44)
                    .height(44)
                    .borderRadius(10)
                    .objectFit(ImageFit.Cover)
                } else {
                  Text(item.title !== '' ? item.title.substring(0, 1) : '书')
                    .fontSize(18)
                    .fontColor(Color.White)
                    .textAlign(TextAlign.Center)
                    .width(44)
                    .height(44)
                    .borderRadius(10)
                    .backgroundColor('#99666666')
                }
              }
              Text(item.title)
                .fontSize(12)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
                .constraintSize({ maxWidth: 64 })
                .textOverflow({ overflow: TextOverflow.Ellipsis })
            }
            .onClick(() => {
              // 点击已存在项进入编辑
              this.page = 1
              this.editingId = item.id
              this.newName = item.title
              this.newUrl = item.url
              this.newIcon = item.icon
            })
            // 原版 qa.v0.j3：长按删除 + 撤销
            .gesture(LongPressGesture({ repeat: false, duration: 500 }).onAction(() => {
              this.deleteFav(index)
            }))
          }
        }, (item: HomeFavRec) => `${item.id}_${item.title}_${item.icon}`)
          .onMove((from: number, to: number) => {
            const moved = this.favs.splice(from, 1)[0]
            this.favs.splice(to, 0, moved)
            const ids: number[] = []
            for (const item of this.favs) {
              ids.push(item.id)
            }
            this.db.reorderHomeFavs(ids)
          })
      }
      // 原版 qa.v0.l3：列数按屏宽动态，上限 540/(item+18)
      .columnsTemplate(this.gridColumnsTemplate())
      .columnsGap(8)
      .rowsGap(10)
      .width('100%')
      .padding(16)
    }
    .layoutWeight(1)
  }

  // 原版 qa.o 新建表单：名称/网址/图标预览（单击选图、长按清图标）/完成
  @Builder
  FormPage() {
    Column({ space: 12 }) {
      Row({ space: 12 }) {
        Stack() {
          if (this.newIcon !== '') {
            Image(this.newIcon)
              .width(56)
              .height(56)
              .borderRadius(28)
              .objectFit(ImageFit.Cover)
          } else {
            Text(this.newName !== '' ? this.newName.substring(0, 1) : '书')
              .fontSize(24)
              .fontColor(Color.White)
              .textAlign(TextAlign.Center)
              .width(56)
              .height(56)
              .borderRadius(28)
              .backgroundColor('#99666666')
          }
        }
        .onClick(() => {
          this.pickIcon()
        })
        .gesture(LongPressGesture({ repeat: false, duration: 500 }).onAction(() => {
          // 原版 qa.o：长按图标预览清除图标
          this.newIcon = ''
        }))

        Column({ space: 8 }) {
          TextInput({ text: this.newName, placeholder: $r('app.string.home_fav_name') })
            .height(40)
            .fontSize(14)
            .border({
              width: 1,
              color: this.nameError ? $r('app.color.accent') : $r('app.color.divider')
            })
            .translate({ x: this.nameShake })
            .onChange((value: string) => {
              this.newName = value
              this.nameError = false
            })
          TextInput({ text: this.newUrl, placeholder: $r('app.string.home_fav_url') })
            .height(40)
            .fontSize(14)
            .border({
              width: 1,
              color: this.urlError ? $r('app.color.accent') : $r('app.color.divider')
            })
            .translate({ x: this.urlShake })
            .onChange((value: string) => {
              this.newUrl = value
              this.urlError = false
            })
        }
        .layoutWeight(1)
      }

      Blank()

      Button($r('app.string.done'))
        .width('100%')
        .height(40)
        .onClick(() => {
          // 原版 qa.o.o3：300ms 防抖 + 空值抖动校验
          if (this.donePending) {
            return
          }
          this.donePending = true
          setTimeout(() => {
            this.donePending = false
          }, 300)
          this.save()
        })
        .margin({ bottom: 16 })
    }
    .width('100%')
    .height('100%')
    .padding(16)
  }

  private donePending: boolean = false

  // 原版 qa.v0.l3：列数 = 满足屏宽的最大 n（上限 540/(item+18)，搜索区展示时再让 1 列）
  private gridColumns(): number {
    const unit = 44 + 18
    const cap = Math.floor(540 / unit)
    const zO = HOME_ADV_AREAS[this.settings.homeAdvArea] === '展示' ? 1 : 0
    let n = 0
    for (let i = cap; i >= 0; i--) {
      if (this.screenW >= (i + zO) * unit) {
        n = i
        break
      }
    }
    return Math.max(1, n)
  }

  private gridColumnsTemplate(): string {
    let tpl = ''
    for (let i = 0; i < this.gridColumns(); i++) {
      tpl += '1fr '
    }
    return tpl.trim()
  }

  // 原版 qa.v0.j3：长按删除列表项并弹出撤销提示
  private deleteFav(index: number): void {
    const item = this.favs[index]
    if (item === undefined) {
      return
    }
    this.favs.splice(index, 1)
    this.deletedItem = item
    this.deletedIndex = index
    this.deletedTitle = item.title !== '' ? item.title : item.url
    this.db.deleteHomeFav(item.id)
    setTimeout(() => {
      this.clearDeleted()
    }, 3000)
  }

  // 原版 qa.v0.V2：撤销恢复到原位置
  private undoDelete(): void {
    const item = this.deletedItem
    const index = this.deletedIndex
    if (item === null || index < 0) {
      return
    }
    this.clearDeleted()
    this.favs.splice(Math.min(index, this.favs.length), 0, item)
    this.db.addHomeFav(item.title, item.url, item.icon, index).then(() => {
      this.reload()
    })
  }

  private clearDeleted(): void {
    this.deletedItem = null
    this.deletedIndex = -1
    this.deletedTitle = ''
  }

  // 空值校验失败置 error + 抖动（原版 qa.o：g6.y.X(输入框) + g6.n.i(输入框)）
  private save(): void {
    const name = this.newName.trim()
    const url = this.newUrl.trim()
    if (name === '') {
      this.nameError = true
      this.shakeInput(true)
      return
    }
    if (!isUrlLike(url)) {
      this.urlError = true
      this.shakeInput(false)
      return
    }
    const target = normalizeUrl(url)
    if (this.editingId >= 0) {
      this.db.updateHomeFav(this.editingId, name, target, this.newIcon).then(() => {
        this.resetForm()
        this.reload()
        this.page = 0
      })
    } else {
      this.db.addHomeFav(name, target, this.newIcon, this.favs.length).then(() => {
        this.resetForm()
        this.reload()
        this.page = 0
      })
    }
  }

  private resetForm(): void {
    this.editingId = -1
    this.newName = ''
    this.newUrl = ''
    this.newIcon = ''
    this.nameError = false
    this.urlError = false
  }

  // 原版 g6.y.X(view)：ObjectAnimator.ofFloat(view, "translationX", 0f, 24dp, 0f)
  //   .setRepeatCount(2).setRepeatMode(1=REVERSE).setDuration(280L).setInterpolator(x8.h.b())
  // repeatCount=2 即共播放 3 次（初始 + 2 次重复），每次 280ms 内走 0→24→0 两个 140ms 关键帧；
  // 因 0→24→0 序列本身对称，REVERSE 反放后仍是 0→24→0，视觉上等价于「3 次完整的来回」，
  // 总时长 280×3 = 840ms。鸿蒙用 keyframeAnimateTo 的 iterations:3 直接承载，
  // 比手工展开 6 段更贴近原版 repeatCount 语义（也少写 4 个重复闭包）。
  private shakeInput(isName: boolean): void {
    const dx = 24
    const kf: KeyframeState[] = [
      {
        duration: 140,
        curve: BEZIER_0202_CURVE,
        event: (): void => {
          if (isName) {
            this.nameShake = dx
          } else {
            this.urlShake = dx
          }
        }
      },
      {
        duration: 140,
        curve: BEZIER_0202_CURVE,
        event: (): void => {
          if (isName) {
            this.nameShake = 0
          } else {
            this.urlShake = 0
          }
        }
      }
    ]
    this.getUIContext().keyframeAnimateTo({ delay: 0, iterations: 3 }, kf)
  }

  // 原版 x5.e：相册选图，URI 直接作为图标（与 SettingsCustomPage 同款）
  private pickIcon(): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    try {
      const photoPicker = new picker.PhotoViewPicker(context)
      photoPicker.select({
        MIMEType: picker.PhotoViewMIMETypes.IMAGE_TYPE,
        maxSelectNumber: 1
      }).then((result: picker.PhotoSelectResult) => {
        if (result.photoUris.length > 0) {
          this.newIcon = result.photoUris[0]
        }
      }).catch((error: BusinessError) => {
        console.error(`pick icon failed: ${error.message}`)
      })
    } catch (error) {
      console.error('open photo picker failed')
    }
  }
}
