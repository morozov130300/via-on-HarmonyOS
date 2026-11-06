import { AppSettings } from '../common/Settings'
import { SiteSetting, SITE_MODE_DEFAULT, SITE_MODE_ON, SITE_MODE_OFF, SITE_PERM_ASK } from '../common/Types'
import { dialogTransition } from '../common/Transitions'
import { SettingCheckRow, SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { ViaIcon } from '../components/ViaIcon'
import { BusinessError } from '@kit.BasicServicesKit'
import { ZoomSlider } from '../components/ZoomSlider'
import { computeDialogWidthVp } from '../components/ViaDialogCard'
import { hostOf } from '../common/SearchEngines'

// 原版 z8/f.c() zh：字体缩放预览诗
const FONT_ZOOM_PREVIEW: string = '莫忧世事兼身事，须著人间比梦间。'

// 网站设定子页（原版 jb 包 1:1）：
// SiteAllPage = hb/w6 所有网站；FontSizePage = jb/k5 字体大小；
// PermissionPage = jb/e0(f3/j2/t/u2/q3/z5/c1) 权限类八种；
// CookiesSettingPage = jb/i0；PopupSettingPage = jb/u3；AdBlockExceptionPage = jb/i

// 原版 w6.n3/m3、q3.k3 输入归一化：含 "://" 时截取 host（i6/i0.e），再 ba/c.f（trim + 小写）
function normalizeHostInput(input: string): string {
  let text = input.trim()
  if (text.indexOf('://') >= 0) {
    text = hostOf(text)
  }
  return text.trim().toLowerCase()
}

@ComponentV2
export struct SiteAllPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // w6.n3：新建输入弹窗
  @Local addDialogId: number = -1
  @Local addHostInput: string = ''
  // w6.q3：重命名弹窗
  @Local renameDialogId: number = -1
  @Local renameFrom: string = ''
  @Local renameInput: string = ''

  private bindAppBar(): void {
    AppBar.show({
      title: '所有网站',
      rightText: '新建',
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight: () => {
        this.openAddDialog()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        if (this.settings.siteSettings.length === 0) {
          Column() {
            Text('¯\\_(ツ)_/¯')
              .fontSize(20)
              .fontColor($r('app.color.fg_secondary'))
          }
          .width('100%')
          .layoutWeight(1)
          .justifyContent(FlexAlign.Center)
        } else {
          Scroll() {
            Column() {
              // w6.r3：k8.p 域名序纯域名列表，点击进 jb/u4，长按 [编辑, 删除]
              ForEach(this.settings.sortedSiteHosts(), (host: string) => {
                Text(host)
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
                  .width('100%')
                  .padding({ left: 16, right: 16, top: 14, bottom: 14 })
                  .onClick(() => {
                    this.openSite(host)
                  })
                  .gesture(LongPressGesture()
                    .onAction(() => {
                      this.showSiteMenu(host)
                    }))
              }, (host: string) => host)
            }
            .width('100%')
          }
          .width('100%')
          .layoutWeight(1)
          .align(Alignment.Top)
        }
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  // w6.s3：带 result 监听跳转 jb/u4（domain）
  private openSite(host: string): void {
    this.navPathStack.pushPathByName('siteDetail', host, true)
  }

  // w6.t3：长按菜单 [D 编辑, x 删除]
  private showSiteMenu(host: string): void {
    ActionSheet.show({
      title: host,
      message: '',
      sheets: [
        {
          title: '编辑',
          action: (): void => {
            this.openRenameDialog(host)
          }
        },
        {
          title: '删除',
          action: (): void => {
            this.settings.removeSiteSetting(host)
          }
        }
      ]
    })
  }

  // w6.n3：w5.k.l().d0(ac 新建).u(false).i('', 'www.example.com', 1).V(ok).N(cancel)
  private openAddDialog(): void {
    this.addHostInput = ''
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.AddHostDialog('新建')
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.addDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open add site dialog failed: ${error.message}`)
    })
  }

  // w6.q3：w5.k.l().d0(D 编辑).u(false).i(现值, 'www.example.com', 1).V(k3).N(cancel)
  private openRenameDialog(host: string): void {
    this.renameFrom = host
    this.renameInput = host
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.RenameHostDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.renameDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open rename site dialog failed: ${error.message}`)
    })
  }

  @Builder
  HostInputRow(placeholder: string, input: string, onChange: (value: string) => void) {
    // w5.k.g type1 单行输入：margin start16/top8/bottom12，底边线
    Row() {
      TextInput({ placeholder: placeholder, text: input })
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .placeholderColor($r('app.color.dialog_hint'))
        .placeholderFont({ size: 14 })
        .backgroundColor(Color.Transparent)
        .padding({ left: 0, right: 0 })
        .height(40)
        .layoutWeight(1)
        .onChange((value: string) => {
          onChange(value)
        })
    }
    .width('100%')
    .margin({ left: 16, right: 12, top: 8, bottom: 12 })
    .border({ width: { bottom: 1 }, color: $r('app.color.dialog_border') })
  }

  @Builder
  DialogActions(onCancel: () => void, onOk: () => void) {
    Row() {
      Blank()
      Text($r('app.string.cancel'))
        .fontSize(14)
        .fontColor($r('app.color.dialog_action'))
        .textAlign(TextAlign.Center)
        .constraintSize({ minWidth: 56 })
        .padding(16)
        .onClick(() => {
          onCancel()
        })
      Text($r('app.string.confirm'))
        .fontSize(14)
        .fontColor($r('app.color.dialog_action'))
        .textAlign(TextAlign.Center)
        .constraintSize({ minWidth: 56 })
        .padding(16)
        .onClick(() => {
          onOk()
        })
    }
    .width('100%')
    .margin({ left: 16, right: 16 })
  }

  @Builder
  AddHostDialog(title: string) {
    Column() {
      Text(title)
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      this.HostInputRow('www.example.com', this.addHostInput, (value: string) => {
        this.addHostInput = value
      })
      this.DialogActions(() => {
        this.closeAddDialog()
      }, () => {
        // w6.m3：归一化后直接进 jb/u4（空输入不动作）
        const host = normalizeHostInput(this.addHostInput)
        if (host === '') {
          return
        }
        this.closeAddDialog()
        this.openSite(host)
      })
    }
    .width(computeDialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeAddDialog(): void {
    if (this.addDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.addDialogId)
    this.addDialogId = -1
  }

  @Builder
  RenameHostDialog() {
    Column() {
      Text('编辑')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      this.HostInputRow('www.example.com', this.renameInput, (value: string) => {
        this.renameInput = value
      })
      this.DialogActions(() => {
        this.closeRenameDialog()
      }, () => {
        // w6.k3：空/同名不动作；重名 toast Kc「%1$s 的网站设定已存在。」
        const host = normalizeHostInput(this.renameInput)
        if (host === '' || host === this.renameFrom) {
          return
        }
        const renamed = this.settings.renameSiteSetting(this.renameFrom, host)
        this.closeRenameDialog()
        if (!renamed) {
          this.getUIContext().getPromptAction().showToast({
            message: `${host} 的网站设定已存在。`,
            duration: 1500
          })
        }
      })
    }
    .width(computeDialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeRenameDialog(): void {
    if (this.renameDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.renameDialogId)
    this.renameDialogId = -1
  }
}

// 原版 jb/k5：字体大小页（网站设定 → 所有网站行进入）
// 列表（k5.s3）：ib.x 全局滑条行 + a6.n 强制缩放 + a6.e 添加例外网站 +
// 有例外时 a6.l「例外」表头 + a6.q 站点行（k8.p 域名序）
@ComponentV2
export struct FontSizePage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // ib.x 拖动实时值（z.a 实时改 % 值与预览字号），抬手提交（z.a onStopTrackingTouch → l5.s）
  @Local pageZoom: number = 100
  // r3() 添加例外输入弹窗
  @Local addDialogId: number = -1
  @Local addHostInput: string = ''
  // v3() 站点缩放滑条弹窗
  @Local siteDialogId: number = -1
  @Local siteDialogHost: string = ''
  @Local siteDialogZoom: number = 100
  @Local siteDialogEditing: boolean = false

  aboutToAppear(): void {
    this.pageZoom = this.settings.textZoom
  }

  private bindAppBar(): void {
    AppBar.show({
      title: '字体大小',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // ib.a0 滑条行：pad 16/20，标题+值同行（14sp，值 fg_secondary minWidth32 居中），
            // 全宽滑条（max 30、步进 5），预览诗（14sp×zoom/100、minHeight 36、maxLines 3）
            Column() {
              Row() {
                Text('字体大小')
                  .fontSize(14)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
                  .layoutWeight(1)
                Text(`${this.pageZoom}%`)
                  .fontSize(14)
                  .fontColor($r('app.color.fg_secondary'))
                  .textAlign(TextAlign.Center)
                  .constraintSize({ minWidth: 32 })
              }
              .width('100%')
              ZoomSlider({
                zoom: this.pageZoom,
                highlightZoom: -1,
                onZoomChange: (zoom: number): void => {
                  this.pageZoom = zoom
                },
                onZoomEnd: (zoom: number): void => {
                  this.pageZoom = zoom
                  this.settings.setTextZoom(zoom)
                }
              })
                .width('100%')
                .margin({ top: 4, bottom: 4 })
              Text(FONT_ZOOM_PREVIEW)
                .fontSize(14 * this.pageZoom / 100)
                .fontColor($r('app.color.fg'))
                .maxLines(3)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
                .constraintSize({ minHeight: 36 })
                .width('100%')
                .padding({ left: 16, right: 16 })
                .margin({ top: 12 })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 20, bottom: 20 })

            // a6.n 强制缩放（a6.o：pad 16/20，右侧圆形复选框）
            SettingCheckRow({
              rowLabel: '强制缩放',
              isChecked: this.settings.forceZoom,
              onCheckRow: (isOn: boolean) => {
                this.settings.setForceZoom(isOn)
              }
            })

            // a6.e 添加例外网站（a6.f：18dp 图标 + drawablePadding 18 + 14sp 文字，pad 16/20）
            Row({ space: 18 }) {
              ViaIcon({ icon: $r('app.media.via_ic_add'), iconSize: 18, iconColor: $r('app.color.fg') })
              Text('添加例外网站')
                .fontSize(14)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 20, bottom: 20 })
            .onClick(() => {
              this.openAddHostDialog()
            })

            // a6.l 例外表头（a6.m：12sp 粗体 accent，padH16 T12 B4）+ a6.q 站点行（a6.r）
            if (this.settings.siteFontZoomHosts().length > 0) {
              Text('例外')
                .fontSize(12)
                .fontWeight(FontWeight.Bold)
                .fontColor($r('app.color.accent'))
                .width('100%')
                .padding({ left: 16, right: 16, top: 12, bottom: 4 })
              ForEach(this.settings.siteFontZoomHosts(), (host: string) => {
                Column() {
                  Text(host)
                    .fontSize(14)
                    .fontColor($r('app.color.fg'))
                    .maxLines(1)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                    .width('100%')
                  Text(`${this.settings.getSiteFontZoom(host)}%`)
                    .fontSize(12)
                    .fontColor($r('app.color.fg_secondary'))
                    .maxLines(3)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                    .width('100%')
                }
                .width('100%')
                .padding({ left: 16, right: 16, top: 20, bottom: 20 })
                .alignItems(HorizontalAlign.Start)
                .onClick(() => {
                  this.openSiteZoomDialog(host, true)
                })
              }, (host: string) => host)
            }
          }
          .width('100%')
          .padding({ bottom: 20 })
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  // 原版 k5.r3()：w5.k.l().e0(bc 添加例外网站).i("", "www.example.com", 1)
  // .V(ok, p3).N(cancel, null).f0()
  private openAddHostDialog(): void {
    this.addHostInput = ''
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.AddHostDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.addDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open add host dialog failed: ${error.message}`)
    })
  }

  @Builder
  AddHostDialog() {
    Column() {
      Text('添加例外网站')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      // w5.k.g type1 单行输入：margin start16/top8/bottom12，底边线
      Row() {
        TextInput({ placeholder: 'www.example.com', text: this.addHostInput })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.dialog_hint'))
          .placeholderFont({ size: 14 })
          .backgroundColor(Color.Transparent)
          .padding({ left: 0, right: 0 })
          .height(40)
          .layoutWeight(1)
          .onChange((value: string) => {
            this.addHostInput = value
          })
      }
      .width('100%')
      .margin({ left: 16, right: 12, top: 8, bottom: 12 })
      .border({ width: { bottom: 1 }, color: $r('app.color.dialog_border') })
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeAddHostDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            // 原版 p3：输入为空不动作（g6.e.e 校验失败）
            const host = normalizeHostInput(this.addHostInput)
            if (host === '') {
              return
            }
            const zoom = this.settings.textZoom
            this.closeAddHostDialog()
            // 原版 v3(ba.c.f(input), m() 全局缩放, false)
            this.openSiteZoomDialog(host, false, zoom)
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width(computeDialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeAddHostDialog(): void {
    if (this.addDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.addDialogId)
    this.addDialogId = -1
  }

  // 原版 k5.v3(host, zoom, editing)：预览诗（k3）+ w0 滑条（h3）+ 确定/取消 +（editing）删除
  private openSiteZoomDialog(host: string, editing: boolean, zoom?: number): void {
    this.siteDialogHost = host
    this.siteDialogEditing = editing
    const initial = zoom !== undefined ? zoom : this.settings.getSiteFontZoom(host)
    this.siteDialogZoom = initial > 0 ? initial : this.settings.textZoom
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.SiteZoomDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.siteDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open site zoom dialog failed: ${error.message}`)
    })
  }

  @Builder
  SiteZoomDialog() {
    Column() {
      // k5.k3 + class a：预览诗，固定高 76dp，14sp×zoom/100，居中
      Text(FONT_ZOOM_PREVIEW)
        .fontSize(14 * this.siteDialogZoom / 100)
        .fontColor($r('app.color.fg'))
        .width('100%')
        .height(76)
        .textAlign(TextAlign.Center)
        .margin({ left: 12, right: 12, top: 16 })
      // k5.h3：max 30、progress=(zoom-50)/5、highlight=(全局-50)/5、步进 5
      ZoomSlider({
        zoom: this.siteDialogZoom,
        highlightZoom: this.settings.textZoom,
        onZoomChange: (value: number): void => {
          this.siteDialogZoom = value
        },
        onZoomEnd: (value: number): void => {
          this.siteDialogZoom = value
        }
      })
        .width('100%')
        .margin({ left: 16, right: 16, bottom: 16 })
      Row() {
        if (this.siteDialogEditing) {
          // w5.k.R(x 删除) → l5.r(host)
          Text('删除')
            .fontSize(14)
            .fontColor($r('app.color.dialog_action'))
            .textAlign(TextAlign.Center)
            .constraintSize({ minWidth: 56 })
            .padding(16)
            .onClick(() => {
              this.settings.removeSiteFontZoom(this.siteDialogHost)
              this.closeSiteZoomDialog()
            })
        }
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeSiteZoomDialog()
          })
        // w5.k.V(ok) → o3：l5.l(host, progress*5+50)
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.settings.setSiteFontZoom(this.siteDialogHost, this.siteDialogZoom)
            this.closeSiteZoomDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width(computeDialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeSiteZoomDialog(): void {
    if (this.siteDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.siteDialogId)
    this.siteDialogId = -1
  }
}

// 权限类子页形状（jb/e0 同构族）
// 0 = tri：全局三态行（剪贴板 e0 / 打开应用 f3）
// 1 = ask：全局复选行 已禁止↔优先询问（位置信息 j2 / 摄像头 t / 麦克风 u2）
// 2 = toggle+分组（页面重定向 q3 / 返回不重载 c1）
// 3 = 单开关（振动 z5）
const PERM_SHAPE_TRI: number = 0
const PERM_SHAPE_ASK: number = 1
const PERM_SHAPE_TOGGLE: number = 2
const PERM_SHAPE_SINGLE: number = 3

@ComponentV2
export struct PermissionPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local pageKind: string = 'clipboard'
  // e0.o3/f3.o3/j2.o3/t.o3/u2.o3/q3.o3/c1.o3：添加例外弹窗
  @Local addDialogId: number = -1
  @Local addHostInput: string = ''
  @Local addAskCheck: boolean = false
  // e0.q3 站点三态弹窗宿主（e0.u3 全局弹窗与站点弹窗共用通用单选弹窗）
  @Local siteDialogHost: string = ''

  private bindAppBar(): void {
    AppBar.show({
      title: this.permTitle(this.pageKind),
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            if (this.permShape(this.pageKind) === PERM_SHAPE_TRI) {
              // e0.p3 / f3.p3：q(1, 名称, 状态整句) 全局三态行
              SettingNavRow({
                rowLabel: this.permTitle(this.pageKind),
                rowValue: this.globalValueText(),
                onTapRow: () => {
                  this.openGlobalTriState()
                }
              })
            } else if (this.permShape(this.pageKind) === PERM_SHAPE_ASK) {
              // j2.p3 / t.p3 / u2.p3：a6.g 复选行（选中 = 优先询问，否则已禁用/已禁止）
              SettingCheckRow({
                rowLabel: this.permTitle(this.pageKind),
                rowDesc: this.globalValueText(),
                isChecked: this.globalAskOn(),
                onCheckRow: (isOn: boolean) => {
                  this.setGlobalAsk(isOn)
                }
              })
            } else if (this.permShape(this.pageKind) === PERM_SHAPE_TOGGLE) {
              // q3.p3 / c1.p3：a6.n 开关行（含动态值）
              this.ToggleValueRow(this.permTitle(this.pageKind), this.globalValueText(),
                this.globalToggleOn(), (isOn: boolean) => {
                  this.setGlobalToggle(isOn)
                })
            } else {
              // z5：单开关行（无例外分组）
              this.ToggleValueRow('振动', this.globalValueText(),
                this.settings.vibrateEnabled, (isOn: boolean) => {
                  this.settings.setVibrateEnabled(isOn)
                })
            }
            if (this.permShape(this.pageKind) !== PERM_SHAPE_SINGLE) {
              // a6.e 添加例外网站（lb.b + Rd 加号图标）
              Row({ space: 18 }) {
                ViaIcon({ icon: $r('app.media.via_ic_add'), iconSize: 18, iconColor: $r('app.color.fg') })
                Text('添加例外网站')
                  .fontSize(14)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
              }
              .width('100%')
              .padding({ left: 16, right: 16, top: 20, bottom: 20 })
              .onClick(() => {
                this.openAddDialog()
              })
              this.ExceptionGroups()
            }
          }
          .width('100%')
          .padding({ bottom: 20 })
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.readParams(ctx)
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  private readParams(ctx: NavDestinationContext): void {
    try {
      const rawParams: string | undefined = JSON.stringify(ctx.pathStack.getParamByName('permissionPage'))
      const params: string[] = rawParams !== undefined && rawParams !== 'undefined' && rawParams !== '[]' ? JSON.parse(rawParams) as string[] : []
      if (params.length > 0) {
        const param: string = params[params.length - 1]
        if (typeof param === 'string' && param !== '') {
          const obj = JSON.parse(param) as Record<string, string>
          this.pageKind = obj['kind'] ?? 'clipboard'
        }
      }
    } catch (error) {
      console.error('read permission params failed')
    }
  }

  // ---- jb/e0 同构族的每 kind 常量（文案来源见 values-zh-rCN strings.xml 资源名注释）----

  private permShape(kind: string): number {
    if (kind === 'clipboard' || kind === 'openapp') {
      return PERM_SHAPE_TRI
    }
    if (kind === 'geo' || kind === 'camera' || kind === 'mic') {
      return PERM_SHAPE_ASK
    }
    if (kind === 'redirect' || kind === 'backreload') {
      return PERM_SHAPE_TOGGLE
    }
    return PERM_SHAPE_SINGLE
  }

  private permTitle(kind: string): string {
    if (kind === 'clipboard') {
      return '剪贴板'
    }
    if (kind === 'openapp') {
      return '打开应用'
    }
    if (kind === 'geo') {
      return '位置信息'
    }
    if (kind === 'camera') {
      return '摄像头'
    }
    if (kind === 'mic') {
      return '麦克风'
    }
    if (kind === 'redirect') {
      return '页面重定向'
    }
    if (kind === 'vibrate') {
      return '振动'
    }
    return '返回不重载'
  }

  // 全局态整句值：e0 e0/e1/e2、f3 p2/p3/p4、j2 mk、t d9、u2 nq、q3 q8/q9、z5 a1g/gf、c1 无
  private globalValueText(): string {
    const kind = this.pageKind
    if (kind === 'clipboard') {
      if (this.settings.clipboardState === 3) {
        return '网站需先询问并得到许可才能使用剪贴板'
      }
      return this.settings.clipboardState === 2 ? '禁止网站使用剪贴板' : '允许网站使用剪贴板'
    }
    if (kind === 'openapp') {
      if (this.settings.openAppState === 3) {
        return '网站需先询问并得到许可才能打开应用'
      }
      return this.settings.openAppState === 2 ? '禁止网站打开应用' : '允许网站打开应用'
    }
    if (kind === 'geo') {
      return this.settings.geoAskFirst ? '网站需先询问并得到许可才能获取你的位置信息' : '已禁止'
    }
    if (kind === 'camera') {
      return this.settings.cameraAskFirst ? '网站需先询问并得到许可才能使用摄像头' : '已禁用'
    }
    if (kind === 'mic') {
      return this.settings.micAskFirst ? '网站需先询问并得到许可才能使用麦克风' : '已禁止'
    }
    if (kind === 'redirect') {
      return this.settings.redirectAskFirst ? '当页面重定向到非同源页面前先询问' : '允许页面重定向到任何页面'
    }
    if (kind === 'vibrate') {
      return this.settings.vibrateEnabled ? '允许网页振动' : '已禁用'
    }
    return this.settings.backReloadEnabled ? '打开' : '关闭'
  }

  private globalAskOn(): boolean {
    if (this.pageKind === 'geo') {
      return this.settings.geoAskFirst
    }
    if (this.pageKind === 'camera') {
      return this.settings.cameraAskFirst
    }
    return this.settings.micAskFirst
  }

  private setGlobalAsk(on: boolean): void {
    // j2/t/u2：t(i ? 2 : 3)——选中 = 优先询问，取消 = 已禁用
    if (this.pageKind === 'geo') {
      this.settings.setGeoAskFirst(on)
    } else if (this.pageKind === 'camera') {
      this.settings.setCameraAskFirst(on)
    } else {
      this.settings.setMicAskFirst(on)
    }
  }

  private globalToggleOn(): boolean {
    if (this.pageKind === 'redirect') {
      // q3：p() = m2().k() = 允许
      return !this.settings.redirectAskFirst
    }
    return this.settings.backReloadEnabled
  }

  private setGlobalToggle(on: boolean): void {
    if (this.pageKind === 'redirect') {
      // q3：t(z) → N(z) = c(134217728, !z)
      this.settings.setRedirectAskFirst(!on)
    } else {
      this.settings.setBackReloadEnabled(on)
    }
  }

  // ---- 站点字段读写（对应 SiteConf 各权限位）----

  private sitePermMode(site: SiteSetting | null): number {
    if (site === null) {
      return SITE_MODE_DEFAULT
    }
    if (this.pageKind === 'clipboard') {
      return site.clipboardMode
    }
    if (this.pageKind === 'openapp') {
      return site.openAppMode
    }
    if (this.pageKind === 'geo') {
      return site.geoMode
    }
    if (this.pageKind === 'camera') {
      return site.cameraMode
    }
    if (this.pageKind === 'mic') {
      return site.micMode
    }
    if (this.pageKind === 'redirect') {
      return site.redirectMode
    }
    if (this.pageKind === 'backreload') {
      return site.backReloadMode
    }
    return 0
  }

  // u4 H3/I3/a4/T3 首项（fc %1$s（默认））用的全局短标签：c8 允许 / cx 已禁止 / ch 优先询问 /
  // os 打开 / oo 关闭 / q_ 重定向到非同源页面前先询问
  private globalShortValue(): string {
    const kind = this.pageKind
    if (kind === 'clipboard') {
      if (this.settings.clipboardState === 3) {
        return '优先询问'
      }
      return this.settings.clipboardState === 2 ? '已禁止' : '允许'
    }
    if (kind === 'openapp') {
      if (this.settings.openAppState === 3) {
        return '优先询问'
      }
      return this.settings.openAppState === 2 ? '已禁止' : '允许'
    }
    if (kind === 'geo') {
      return this.settings.geoAskFirst ? '优先询问' : '已禁止'
    }
    if (kind === 'camera') {
      return this.settings.cameraAskFirst ? '优先询问' : '已禁止'
    }
    if (kind === 'mic') {
      return this.settings.micAskFirst ? '优先询问' : '已禁止'
    }
    if (kind === 'redirect') {
      return this.settings.redirectAskFirst ? '重定向到非同源页面前先询问' : '允许'
    }
    return this.settings.backReloadEnabled ? '打开' : '关闭'
  }

  private setSitePermMode(host: string, mode: number): void {
    // 原版写入路径统一为 S(true) + 对应位；mode 0 = 清除覆盖，空站点条目随删（f0.s 等）
    const site = this.settings.obtainSiteSetting(host)
    if (this.pageKind === 'clipboard') {
      site.clipboardMode = mode
    } else if (this.pageKind === 'openapp') {
      site.openAppMode = mode
    } else if (this.pageKind === 'geo') {
      site.geoMode = mode
    } else if (this.pageKind === 'camera') {
      site.cameraMode = mode
    } else if (this.pageKind === 'mic') {
      site.micMode = mode
    } else if (this.pageKind === 'redirect') {
      site.redirectMode = mode
    } else if (this.pageKind === 'backreload') {
      site.backReloadMode = mode
    }
    if (mode === SITE_MODE_DEFAULT) {
      if (site.isEmptyConf()) {
        this.settings.removeSiteSetting(host)
      } else {
        this.settings.applySiteConf(site)
      }
    } else {
      this.settings.applySiteConf(site)
    }
  }

  // ---- 分组列表（kb.d / kb.a 语义）----

  private groupDeniedHosts(): string[] {
    const result: string[] = []
    for (let i = 0; i < this.settings.siteSettings.length; i++) {
      const site = this.settings.siteSettings[i]
      if (site.enabled && this.sitePermMode(site) === 2) {
        result.push(site.host)
      }
    }
    result.sort((a: string, b: string): number => {
      if (a === b) {
        return 0
      }
      return a < b ? -1 : 1
    })
    return result
  }

  private groupAllowedHosts(): string[] {
    const result: string[] = []
    for (let i = 0; i < this.settings.siteSettings.length; i++) {
      const site = this.settings.siteSettings[i]
      const mode = this.sitePermMode(site)
      if (site.enabled && (mode === 1 || mode === SITE_PERM_ASK)) {
        result.push(site.host)
      }
    }
    result.sort((a: string, b: string): number => {
      if (a === b) {
        return 0
      }
      return a < b ? -1 : 1
    })
    return result
  }

  // 第二组表头：全局 != 禁止 → c8 允许，否则 i4 例外（e0.p3/f3.p3/j2.p3/t.p3/u2.p3）；
  // q3/c1 两态页为 允许|打开 : 例外
  private groupAllowedHeader(): string {
    if (this.pageKind === 'redirect') {
      return this.globalToggleOn() ? '允许' : '例外'
    }
    if (this.pageKind === 'backreload') {
      return this.settings.backReloadEnabled ? '打开' : '例外'
    }
    if (this.pageKind === 'clipboard') {
      return this.settings.clipboardState !== 2 ? '允许' : '例外'
    }
    if (this.pageKind === 'openapp') {
      return this.settings.openAppState !== 2 ? '允许' : '例外'
    }
    if (this.pageKind === 'geo') {
      return this.settings.geoAskFirst ? '例外' : '允许'
    }
    if (this.pageKind === 'camera') {
      return this.settings.cameraAskFirst ? '例外' : '允许'
    }
    return this.settings.micAskFirst ? '例外' : '允许'
  }

  @Builder
  GroupHeader(label: string) {
    // a6.m：12sp 粗体 accent，padH16 T12 B4
    Text(label)
      .fontSize(12)
      .fontWeight(FontWeight.Bold)
      .fontColor($r('app.color.accent'))
      .width('100%')
      .padding({ left: 16, right: 16, top: 12, bottom: 4 })
  }

  @Builder
  SiteRow(host: string, subLabel: string) {
    Column() {
      Text(host)
        .fontSize(14)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .width('100%')
      if (subLabel !== '') {
        Text(subLabel)
          .fontSize(12)
          .fontColor($r('app.color.fg_secondary'))
          .maxLines(1)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
          .width('100%')
      }
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 20, bottom: 20 })
    .alignItems(HorizontalAlign.Start)
    .onClick(() => {
      this.openSiteDialog(host)
    })
  }

  @Builder
  ExceptionGroups() {
    // 第一组：cx 已禁止（state2）
    if (this.groupDeniedHosts().length > 0) {
      this.GroupHeader('已禁止')
      ForEach(this.groupDeniedHosts(), (host: string) => {
        this.SiteRow(host, '')
      }, (host: string) => `d-${host}`)
    }
    // 第二组：允许|例外（state3 + state1），state3 行带 优先询问 副标签
    if (this.groupAllowedHosts().length > 0) {
      this.GroupHeader(this.groupAllowedHeader())
      ForEach(this.groupAllowedHosts(), (host: string) => {
        this.SiteRow(host, this.sitePermMode(this.settings.getSiteSetting(host)) === SITE_PERM_ASK ? '优先询问' : '')
      }, (host: string) => `a-${host}`)
    }
  }

  @Builder
  ToggleValueRow(label: string, value: string, isOn: boolean, change: (isOn: boolean) => void) {
    Row({ space: 12 }) {
      Column() {
        Text(label)
          .fontSize(15)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
        if (value !== '') {
          Text(value)
            .fontSize(13)
            .fontColor($r('app.color.fg_secondary'))
            .maxLines(2)
            .textOverflow({ overflow: TextOverflow.Ellipsis })
            .margin({ top: 2 })
        }
      }
      .alignItems(HorizontalAlign.Start)
      .layoutWeight(1)
      Toggle({ type: ToggleType.Switch, isOn: isOn })
        .selectedColor($r('app.color.accent'))
        .onChange((state: boolean) => {
          change(state)
        })
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 13, bottom: 13 })
    .alignItems(VerticalAlign.Center)
  }

  // ---- 弹窗（w5.k 复刻）----

  // e0.u3：全局三态弹窗 d0(名称).b0([允许, 禁止, 优先询问]).f0()（无按钮，点击即生效并关闭）
  private openGlobalTriState(): void {
    const state = this.pageKind === 'clipboard' ? this.settings.clipboardState : this.settings.openAppState
    const checked = state === 2 ? 1 : (state === 3 ? 2 : 0)
    this.openPickDialog(this.permTitle(this.pageKind), ['允许', '禁止', '优先询问'], checked, false, '',
      (index: number): void => {
        // e0.s3：idx2→3 优先询问、idx1→2 禁止、idx0→1 允许
        const mode = index === 2 ? 3 : (index === 1 ? 2 : 1)
        if (this.pageKind === 'clipboard') {
          this.settings.setClipboardState(mode)
        } else {
          this.settings.setOpenAppState(mode)
        }
      }, (_host: string): void => {
      })
  }

  // e0.q3 / f3.q3 / j2.q3 / t.q3 / u2.q3 / q3.q3 / c1.q3：
  // 站点弹窗 e0(host).b0([fc 全局值（默认）, 允许, 禁止, (优先询问)]).V(ok).R(删除)
  // 首项 = 跟随全局（mode 0），点击即改选项、确认提交
  private openSiteDialog(host: string): void {
    const mode = this.sitePermMode(this.settings.getSiteSetting(host))
    const isToggleShape = this.permShape(this.pageKind) === PERM_SHAPE_TOGGLE
    let options: string[] = []
    if (this.pageKind === 'redirect') {
      // q3.b4：[f4 全局（默认）, 允许, q_]
      options = [`${this.globalShortValue()}（默认）`, '允许', '重定向到非同源页面前先询问']
    } else if (isToggleShape) {
      // c1.O3：[f4 全局（默认）, 打开, 关闭]
      options = [`${this.globalShortValue()}（默认）`, '打开', '关闭']
    } else {
      // e0.I3 等：[f4 全局（默认）, c2 允许, cr 禁止, ch 优先询问]
      options = [`${this.globalShortValue()}（默认）`, '允许', '禁止', '优先询问']
    }
    this.siteDialogHost = host
    this.openPickDialog(host, options, mode, true, '删除',
      (index: number): void => {
        let mode2: number
        if (isToggleShape || this.pageKind === 'redirect') {
          mode2 = index <= 0 ? SITE_MODE_DEFAULT : (index === 1 ? 1 : 2)
        } else {
          // u3/t3/C3/p3/r3：0→0（跟随）、3→3（优先询问）、1→1、2→2
          mode2 = index <= 0 ? SITE_MODE_DEFAULT : index
        }
        this.setSitePermMode(this.siteDialogHost, mode2)
      }, (_host: string): void => {
        // R(x 删除) → f0.s：清覆盖，空站点条目随删
        this.setSitePermMode(this.siteDialogHost, SITE_MODE_DEFAULT)
      })
  }

  // e0.o3：添加弹窗 e0(bc 添加例外网站).J(随全局态的 message).i(...).V(ok).N(cancel)
  // 全局为禁止时追加 w(ch 优先询问) 复选框
  private openAddDialog(): void {
    this.addHostInput = ''
    this.addAskCheck = false
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.AddExceptionDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.addDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open add exception dialog failed: ${error.message}`)
    })
  }

  // e0.i3：l(host, 复选 ? 3 : (全局==2 ? 1 : 2))；j2.m3：l(host, 复选 ? 3 : (m()==2 ? 1 : 2))；
  // q3.j3 / c1：l(host, !zP)
  private addException(): void {
    const host = normalizeHostInput(this.addHostInput)
    if (host === '') {
      return
    }
    const shape = this.permShape(this.pageKind)
    let mode: number
    if (shape === PERM_SHAPE_TOGGLE) {
      mode = this.globalToggleOn() ? 2 : 1
    } else if (shape === PERM_SHAPE_ASK) {
      // 全局已禁止 → 例外=允许(1)；全局优先询问 → 例外=禁止(2)
      mode = this.globalAskOn() ? 2 : 1
    } else if (this.addAskCheck) {
      mode = SITE_PERM_ASK
    } else {
      const global = this.pageKind === 'clipboard' ? this.settings.clipboardState : this.settings.openAppState
      mode = global === 2 ? 1 : 2
    }
    this.setSitePermMode(host, mode)
  }

  // e0.o3：message 随全局态取反义文案（各 kind 对应资源名见注释）
  private addDialogMessage(): string {
    const kind = this.pageKind
    if (kind === 'clipboard') {
      // dz / dy
      return this.settings.clipboardState !== 2 ? '禁止特定网站使用剪贴板。' : '允许特定网站使用剪贴板。'
    }
    if (kind === 'openapp') {
      // p1 / p0
      return this.settings.openAppState !== 2 ? '禁止特定网站打开应用。' : '允许特定网站打开应用。'
    }
    if (kind === 'geo') {
      // mj / mi
      return this.settings.geoAskFirst ? '允许特定网站使用位置信息。' : '禁止特定网站使用位置信息。'
    }
    if (kind === 'camera') {
      // d8 / d7
      return this.settings.cameraAskFirst ? '允许特定网站使用摄像头。' : '禁止特定网站使用摄像头。'
    }
    if (kind === 'mic') {
      // np / no
      return this.settings.micAskFirst ? '允许特定网站使用麦克风。' : '禁止特定网站使用麦克风。'
    }
    if (kind === 'redirect') {
      // q7 / q6
      return this.settings.redirectAskFirst ? '允许特定网站重定向到任何页面。' : '在特定网站重定向到非同源页面前先询问。'
    }
    // c1：r5 / r6
    return this.settings.backReloadEnabled ? '为特定网站关闭返回不重载。' : '为特定网站打开返回不重载。'
  }

  private addDialogShowAskCheck(): boolean {
    // e0.o3：仅全局为禁止（==2）时显示 优先询问 复选框
    if (this.pageKind === 'clipboard') {
      return this.settings.clipboardState === 2
    }
    if (this.pageKind === 'openapp') {
      return this.settings.openAppState === 2
    }
    return false
  }

  @Builder
  AddExceptionDialog() {
    Column() {
      Text('添加例外网站')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      // w5.k.J(message)
      Text(this.addDialogMessage())
        .fontSize(14)
        .fontColor($r('app.color.fg_secondary'))
        .width('100%')
        .margin({ left: 16, right: 16, bottom: 4 })
      Row() {
        TextInput({ placeholder: 'www.example.com', text: this.addHostInput })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.dialog_hint'))
          .placeholderFont({ size: 14 })
          .backgroundColor(Color.Transparent)
          .padding({ left: 0, right: 0 })
          .height(40)
          .layoutWeight(1)
          .onChange((value: string) => {
            this.addHostInput = value
          })
      }
      .width('100%')
      .margin({ left: 16, right: 12, top: 8, bottom: 12 })
      .border({ width: { bottom: 1 }, color: $r('app.color.dialog_border') })
      if (this.addDialogShowAskCheck()) {
        // w5.k.w(ch 优先询问)：16dp 圆形复选框 + drawablePadding 24
        Row({ space: 24 }) {
          Circle({ width: 16, height: 16 })
            .fill(this.addAskCheck ? $r('app.color.accent') : Color.Transparent)
            .stroke(this.addAskCheck ? Color.Transparent : $r('app.color.dialog_border'))
            .strokeWidth(2)
          Text('优先询问')
            .fontSize(14)
            .fontColor($r('app.color.fg'))
            .maxLines(1)
        }
        .width('100%')
        .padding({ left: 16, right: 16, top: 12, bottom: 12 })
        .onClick(() => {
          this.addAskCheck = !this.addAskCheck
        })
      }
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeAddDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.addException()
            this.closeAddDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width(computeDialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeAddDialog(): void {
    if (this.addDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.addDialogId)
    this.addDialogId = -1
  }

  // w5.k.b0 单选列表弹窗（layout u.xml 卡片 + v.xml 单选项；showOk = 有 V(ok)/R(负按钮)）
  @Local pickDialogTitle: string = ''
  @Local pickDialogOptions: string[] = []
  @Local pickDialogChecked: number = -1
  @Local pickDialogShowOk: boolean = false
  @Local pickDialogNegative: string = ''
  @Local pickDialogOnPick: (index: number) => void = (_index: number): void => {
  }
  private pickDialogId: number = -1
  @Local pickDialogOnNegative: (host: string) => void = (_host: string): void => {
  }

  private openPickDialog(title: string, options: string[], checked: number, showOk: boolean, negative: string,
    onPick: (index: number) => void, onNegative: (host: string) => void): void {
    this.pickDialogTitle = title
    this.pickDialogOptions = options
    this.pickDialogChecked = checked
    this.pickDialogShowOk = showOk
    this.pickDialogNegative = negative
    this.pickDialogOnPick = onPick
    this.pickDialogOnNegative = onNegative
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.PickDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.pickDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open pick dialog failed: ${error.message}`)
    })
  }

  @Builder
  PickDialog() {
    Column() {
      Text(this.pickDialogTitle)
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      ForEach(this.pickDialogOptions, (label: string, index: number) => {
        // 原版 layout v.xml + w5.d：16dp 圆形复选框在左，drawablePadding 24，padV 12 padH 16
        Row({ space: 24 }) {
          Circle({ width: 16, height: 16 })
            .fill(this.pickDialogChecked === index ? $r('app.color.accent') : Color.Transparent)
            .stroke(this.pickDialogChecked === index ? Color.Transparent : $r('app.color.dialog_border'))
            .strokeWidth(2)
          Text(label)
            .fontSize(14)
            .fontColor($r('app.color.fg'))
            .maxLines(2)
            .textOverflow({ overflow: TextOverflow.Ellipsis })
            .layoutWeight(1)
        }
        .width('100%')
        .padding({ left: 16, right: 16, top: 12, bottom: 12 })
        .onClick(() => {
          if (this.pickDialogShowOk) {
            // 有确认键的单选：原地改选，确认时提交
            this.pickDialogChecked = index
          } else {
            const pick = this.pickDialogOnPick
            this.closePickDialog()
            pick(index)
          }
        })
      }, (label: string) => label)
      if (this.pickDialogShowOk) {
        Row() {
          if (this.pickDialogNegative !== '') {
            Text(this.pickDialogNegative)
              .fontSize(14)
              .fontColor($r('app.color.dialog_action'))
              .textAlign(TextAlign.Center)
              .constraintSize({ minWidth: 56 })
              .padding(16)
              .onClick(() => {
                const negative = this.pickDialogOnNegative
                this.closePickDialog()
                negative(this.siteDialogHost)
              })
          }
          Blank()
          Text($r('app.string.cancel'))
            .fontSize(14)
            .fontColor($r('app.color.dialog_action'))
            .textAlign(TextAlign.Center)
            .constraintSize({ minWidth: 56 })
            .padding(16)
            .onClick(() => {
              this.closePickDialog()
            })
          Text($r('app.string.confirm'))
            .fontSize(14)
            .fontColor($r('app.color.dialog_action'))
            .textAlign(TextAlign.Center)
            .constraintSize({ minWidth: 56 })
            .padding(16)
            .onClick(() => {
              const pick = this.pickDialogOnPick
              this.closePickDialog()
              pick(this.pickDialogChecked)
            })
        }
        .width('100%')
        .margin({ left: 16, right: 16 })
      }
    }
    .width(computeDialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closePickDialog(): void {
    if (this.pickDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.pickDialogId)
    this.pickDialogId = -1
  }
}

// 原版 jb/i0：Cookies 页（两开关行）
@ComponentV2
export struct CookiesSettingPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  private bindAppBar(): void {
    AppBar.show({
      title: 'Cookies',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // n(1, eg Cookies, h3(zI3)=eh 允许网站保存和读取 Cookie 数据 / cx, zI3)
            this.ToggleValueRow('Cookies', this.settings.cookiesEnabled ? '允许网站保存和读取 Cookie 数据' : '已禁止',
              this.settings.cookiesEnabled, (isOn: boolean) => {
                this.settings.setCookiesEnabled(isOn)
              }, false)
            // n(2, cs 拦截第三方 Cookies, checked=j3()=!C()，!zI3 时禁用)
            this.ToggleValueRow('拦截第三方 Cookies', '',
              this.settings.cookiesBlockThirdParty, (isOn: boolean) => {
                this.settings.setCookiesBlockThirdParty(isOn)
              }, !this.settings.cookiesEnabled)
          }
          .width('100%')
          .padding({ bottom: 20 })
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  @Builder
  ToggleValueRow(label: string, value: string, isOn: boolean, change: (isOn: boolean) => void, disabled: boolean) {
    Row({ space: 12 }) {
      Column() {
        Text(label)
          .fontSize(15)
          .fontColor(disabled === true ? $r('app.color.fg_secondary') : $r('app.color.fg'))
          .maxLines(1)
        if (value !== '') {
          Text(value)
            .fontSize(13)
            .fontColor($r('app.color.fg_secondary'))
            .maxLines(2)
            .textOverflow({ overflow: TextOverflow.Ellipsis })
            .margin({ top: 2 })
        }
      }
      .alignItems(HorizontalAlign.Start)
      .layoutWeight(1)
      Toggle({ type: ToggleType.Switch, isOn: isOn })
        .selectedColor($r('app.color.accent'))
        .opacity(disabled === true ? 0.4 : 1)
        .onChange((state: boolean) => {
          if (disabled === true) {
            return
          }
          change(state)
        })
    }
    .width('100%')
    .padding({ left: 16, right: 16, top: 13, bottom: 13 })
    .alignItems(VerticalAlign.Center)
  }
}

// 原版 jb/u3：弹出式窗口页（单开关行，值 = c8 允许 / qx 网站需先询问…）
@ComponentV2
export struct PopupSettingPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  private bindAppBar(): void {
    AppBar.show({
      title: '弹出式窗口',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // n(1, qw 弹出式窗口, h3=z10 ? c8 允许 : qx，z10 = !h())
            Row({ space: 12 }) {
              Column() {
                Text('弹出式窗口')
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                Text(this.settings.popupAskFirst ? '网站需先询问并得到许可才能显示弹出式窗口' : '允许')
                  .fontSize(13)
                  .fontColor($r('app.color.fg_secondary'))
                  .maxLines(2)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
                  .margin({ top: 2 })
              }
              .alignItems(HorizontalAlign.Start)
              .layoutWeight(1)
              Toggle({ type: ToggleType.Switch, isOn: !this.settings.popupAskFirst })
                .selectedColor($r('app.color.accent'))
                .onChange((state: boolean) => {
                  // u3.j3：J(!z) → bit32768（关 = 优先询问）
                  this.settings.setPopupAskFirst(!state)
                })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 13, bottom: 13 })
            .alignItems(VerticalAlign.Center)
          }
          .width('100%')
          .padding({ bottom: 20 })
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }
}

// 原版 jb/i：广告拦截例外页
// n(1, ct 广告拦截, 全局开关) + a6.e 添加例外网站（message b4/b5 随全局态）+
// 分组 [Y8 关闭] / [z10 ? os 打开 : i4 例外]，站点弹窗 [打开, 关闭] + R(删除)
@ComponentV2
export struct AdBlockExceptionPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local addDialogId: number = -1
  @Local addHostInput: string = ''
  @Local siteDialogId: number = -1
  @Local siteDialogHost: string = ''
  @Local pickDialogChecked: number = -1

  private bindAppBar(): void {
    AppBar.show({
      title: '广告拦截',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // n(1, ct, z10 = 全局广告拦截)
            Row({ space: 12 }) {
              Text('广告拦截')
                .fontSize(15)
                .fontColor($r('app.color.fg'))
                .layoutWeight(1)
                .maxLines(1)
              Toggle({ type: ToggleType.Switch, isOn: this.settings.adBlockOn })
                .selectedColor($r('app.color.accent'))
                .onChange((state: boolean) => {
                  // i：t(!n.i) → 全局开关
                  this.settings.setAdBlockOn(state)
                })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 13, bottom: 13 })
            .alignItems(VerticalAlign.Center)
            // a6.e 添加例外网站
            Row({ space: 18 }) {
              ViaIcon({ icon: $r('app.media.via_ic_add'), iconSize: 18, iconColor: $r('app.color.fg') })
              Text('添加例外网站')
                .fontSize(14)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 20, bottom: 20 })
            .onClick(() => {
              this.openAddDialog()
            })
            // 第一组：Y8 关闭（站点不拦截）
            if (this.groupOffHosts().length > 0) {
              Text('关闭')
                .fontSize(12)
                .fontWeight(FontWeight.Bold)
                .fontColor($r('app.color.accent'))
                .width('100%')
                .padding({ left: 16, right: 16, top: 12, bottom: 4 })
              ForEach(this.groupOffHosts(), (host: string) => {
                Text(host)
                  .fontSize(14)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
                  .width('100%')
                  .padding({ left: 16, right: 16, top: 20, bottom: 20 })
                  .onClick(() => {
                    this.openSiteDialog(host)
                  })
              }, (host: string) => `off-${host}`)
            }
            // 第二组：z10 ? os 打开 : i4 例外
            if (this.groupOnHosts().length > 0) {
              Text(this.settings.adBlockOn ? '打开' : '例外')
                .fontSize(12)
                .fontWeight(FontWeight.Bold)
                .fontColor($r('app.color.accent'))
                .width('100%')
                .padding({ left: 16, right: 16, top: 12, bottom: 4 })
              ForEach(this.groupOnHosts(), (host: string) => {
                Text(host)
                  .fontSize(14)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
                  .width('100%')
                  .padding({ left: 16, right: 16, top: 20, bottom: 20 })
                  .onClick(() => {
                    this.openSiteDialog(host)
                  })
              }, (host: string) => `on-${host}`)
            }
          }
          .width('100%')
          .padding({ bottom: 20 })
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }

  // kb.a 分组：组0 = M(true) 站点拦截广告，组1 = M(false) 站点放行
  private groupOnHosts(): string[] {
    const result: string[] = []
    for (let i = 0; i < this.settings.siteSettings.length; i++) {
      const site = this.settings.siteSettings[i]
      if (site.enabled && site.adBlockMode === SITE_MODE_ON) {
        result.push(site.host)
      }
    }
    result.sort((a: string, b: string): number => {
      if (a === b) {
        return 0
      }
      return a < b ? -1 : 1
    })
    return result
  }

  private groupOffHosts(): string[] {
    const result: string[] = []
    for (let i = 0; i < this.settings.siteSettings.length; i++) {
      const site = this.settings.siteSettings[i]
      if (site.enabled && site.adBlockMode === SITE_MODE_OFF) {
        result.push(site.host)
      }
    }
    result.sort((a: string, b: string): number => {
      if (a === b) {
        return 0
      }
      return a < b ? -1 : 1
    })
    return result
  }

  // i.q3：站点弹窗 e0(host).b0([f4 全局（默认）, 打开, 关闭], m()?…:0).V(ok).R(删除)
  // 首项 = 跟随全局（mode 0）
  private openSiteDialog(host: string): void {
    const site = this.settings.getSiteSetting(host)
    const mode = site !== null ? site.adBlockMode : SITE_MODE_DEFAULT
    this.siteDialogHost = host
    this.pickDialogChecked = mode
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.SiteDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.siteDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open adblock site dialog failed: ${error.message}`)
    })
  }

  // i.q3 listener / j.l(str, z)：M(z) → bit16；mode 0 = 跟随全局（清覆盖，空条目随删）
  private setSiteAdblockMode(host: string, mode: number): void {
    const site = this.settings.obtainSiteSetting(host)
    site.adBlockMode = mode
    if (mode === SITE_MODE_DEFAULT && site.isEmptyConf()) {
      this.settings.removeSiteSetting(host)
    } else {
      this.settings.applySiteConf(site)
    }
  }

  @Builder
  SiteDialog() {
    Column() {
      Text(this.siteDialogHost)
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      // 首项：f4 全局值（默认）→ mode 0（跟随全局）
      Row({ space: 24 }) {
        Circle({ width: 16, height: 16 })
          .fill(this.pickDialogChecked === 0 ? $r('app.color.accent') : Color.Transparent)
          .stroke(this.pickDialogChecked === 0 ? Color.Transparent : $r('app.color.dialog_border'))
          .strokeWidth(2)
        Text(`${this.settings.adBlockOn ? '打开' : '关闭'}（默认）`)
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .layoutWeight(1)
      }
      .width('100%')
      .padding({ left: 16, right: 16, top: 12, bottom: 12 })
      .onClick(() => {
        this.pickDialogChecked = 0
      })
      Row({ space: 24 }) {
        Circle({ width: 16, height: 16 })
          .fill(this.pickDialogChecked === 1 ? $r('app.color.accent') : Color.Transparent)
          .stroke(this.pickDialogChecked === 1 ? Color.Transparent : $r('app.color.dialog_border'))
          .strokeWidth(2)
        Text('打开')
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .layoutWeight(1)
      }
      .width('100%')
      .padding({ left: 16, right: 16, top: 12, bottom: 12 })
      .onClick(() => {
        this.pickDialogChecked = 1
      })
      Row({ space: 24 }) {
        Circle({ width: 16, height: 16 })
          .fill(this.pickDialogChecked === 2 ? $r('app.color.accent') : Color.Transparent)
          .stroke(this.pickDialogChecked === 2 ? Color.Transparent : $r('app.color.dialog_border'))
          .strokeWidth(2)
        Text('关闭')
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .maxLines(1)
          .layoutWeight(1)
      }
      .width('100%')
      .padding({ left: 16, right: 16, top: 12, bottom: 12 })
      .onClick(() => {
        this.pickDialogChecked = 2
      })
      Row() {
        Text('删除')
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            // R(x 删除) → j.s：D() 清覆盖（mode 0），空站点条目随删
            this.setSiteAdblockMode(this.siteDialogHost, SITE_MODE_DEFAULT)
            this.closeSiteDialog()
          })
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeSiteDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            // A3：0→D() 跟随、1→W(true) 打开、2→W(false) 关闭
            this.setSiteAdblockMode(this.siteDialogHost, this.pickDialogChecked)
            this.closeSiteDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width(computeDialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeSiteDialog(): void {
    if (this.siteDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.siteDialogId)
    this.siteDialogId = -1
  }

  // i.o3：d0(bc).J(zP ? o0 b4 : p0 b5).i(...).V(j3: l(host, !zP)).N(cancel)
  private openAddDialog(): void {
    this.addHostInput = ''
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.AddExceptionDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.4)'
    }).then((dialogId: number) => {
      this.addDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open adblock add dialog failed: ${error.message}`)
    })
  }

  @Builder
  AddExceptionDialog() {
    Column() {
      Text('添加例外网站')
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })
      // b4 为特定网站关闭广告拦截。/ b5 为特定网站打开广告拦截。
      Text(this.settings.adBlockOn ? '为特定网站关闭广告拦截。' : '为特定网站打开广告拦截。')
        .fontSize(14)
        .fontColor($r('app.color.fg_secondary'))
        .width('100%')
        .margin({ left: 16, right: 16, bottom: 4 })
      Row() {
        TextInput({ placeholder: 'www.example.com', text: this.addHostInput })
          .fontSize(14)
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.dialog_hint'))
          .placeholderFont({ size: 14 })
          .backgroundColor(Color.Transparent)
          .padding({ left: 0, right: 0 })
          .height(40)
          .layoutWeight(1)
          .onChange((value: string) => {
            this.addHostInput = value
          })
      }
      .width('100%')
      .margin({ left: 16, right: 12, top: 8, bottom: 12 })
      .border({ width: { bottom: 1 }, color: $r('app.color.dialog_border') })
      Row() {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            this.closeAddDialog()
          })
        Text($r('app.string.confirm'))
          .fontSize(14)
          .fontColor($r('app.color.dialog_action'))
          .textAlign(TextAlign.Center)
          .constraintSize({ minWidth: 56 })
          .padding(16)
          .onClick(() => {
            // j3：l(host, !zP)——全局开 → 站点放行(2)；全局关 → 站点拦截(1)
            const host = normalizeHostInput(this.addHostInput)
            if (host !== '') {
              const site = this.settings.obtainSiteSetting(host)
              site.adBlockMode = this.settings.adBlockOn ? SITE_MODE_OFF : SITE_MODE_ON
              this.settings.applySiteConf(site)
            }
            this.closeAddDialog()
          })
      }
      .width('100%')
      .margin({ left: 16, right: 16 })
    }
    .width(computeDialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }

  private closeAddDialog(): void {
    if (this.addDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.addDialogId)
    this.addDialogId = -1
  }
}

@Builder
export function SiteAllPageBuilder() {
  SiteAllPage()
}

@Builder
export function FontSizePageBuilder() {
  FontSizePage()
}

@Builder
export function PermissionPageBuilder() {
  PermissionPage()
}

@Builder
export function CookiesSettingPageBuilder() {
  CookiesSettingPage()
}

@Builder
export function PopupSettingPageBuilder() {
  PopupSettingPage()
}

@Builder
export function AdBlockExceptionPageBuilder() {
  AdBlockExceptionPage()
}
