import { SiteSetting } from '../common/Types'
import { dialogTransition } from '../common/Transitions'
import { AppSettings } from '../common/Settings'
import { SettingCheckRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { AppIcon } from '../components/AppIcon'
import { BusinessError } from '@kit.BasicServicesKit'
import { ZoomSlider } from '../components/ZoomSlider'
import { ViaIcon } from '../components/ViaIcon'
import { computeDialogWidthVp } from '../components/ViaDialogCard'

// 原版 z8/f.c() zh：字体缩放预览诗
const FONT_ZOOM_PREVIEW: string = '莫忧世事兼身事，须著人间比梦间。'

// 网站设定的四个子页面：所有网站 / 字体大小 / 权限例外 / 广告拦截例外

@ComponentV2
export struct SiteAllPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  private bindAppBar(): void {
    AppBar.show({
      title: '所有网站',
      onBack: () => {
        this.navPathStack.pop()
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
              ForEach(this.settings.siteSettings, (site: SiteSetting) => {
                Column() {
                  Row({ space: 12 }) {
                    Text(site.host)
                      .fontSize(15)
                      .fontColor($r('app.color.fg'))
                      .layoutWeight(1)
                      .maxLines(1)
                      .textOverflow({ overflow: TextOverflow.Ellipsis })
                    AppIcon({ icon: $r('sys.symbol.trash'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
                      .onClick(() => {
                        this.settings.removeSiteSetting(site.host)
                      })
                  }
                  .width('100%')
                  .height(44)
                  this.SiteToggleRow('电脑模式', site.pcMode, (isOn: boolean) => {
                    site.pcMode = isOn
                    this.settings.upsertSiteSetting(site)
                  })
                  this.SiteToggleRow('无图模式', site.noImage, (isOn: boolean) => {
                    site.noImage = isOn
                    this.settings.upsertSiteSetting(site)
                  })
                  this.SiteToggleRow('允许广告', site.allowAds, (isOn: boolean) => {
                    site.allowAds = isOn
                    this.settings.upsertSiteSetting(site)
                  })
                  this.SiteToggleRow('夜间模式', site.forceDark, (isOn: boolean) => {
                    site.forceDark = isOn
                    this.settings.upsertSiteSetting(site)
                  })
                }
                .width('100%')
                .padding({ left: 16, right: 16, top: 10, bottom: 10 })
              }, (site: SiteSetting) => site.host)
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

  @Builder
  SiteToggleRow(label: string, isOn: boolean, change: (isOn: boolean) => void) {
    Row({ space: 12 }) {
      Text(label)
        .fontSize(13)
        .fontColor($r('app.color.fg_secondary'))
        .layoutWeight(1)
      Toggle({ type: ToggleType.Switch, isOn: isOn })
        .selectedColor($r('app.color.accent'))
        .onChange((value: boolean) => {
          change(value)
        })
    }
    .width('100%')
    .height(36)
  }
}

// 原版 jb/k5：字体大小页（网站设定 → 长按菜单「字体大小」进入）
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
            const host = this.addHostInput.trim().toLowerCase()
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

@ComponentV2
export struct PermissionPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local pageTitle: string = ''
  @Local pageDesc: string = ''
  @Local pageKind: string = 'clipboard'
  @Local exceptionDialogId: number = -1
  @Local hostInput: string = ''
  @Local pendingKind: string = 'clipboard'

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            Text(this.pageTitle)
              .fontSize(15)
              .fontColor($r('app.color.fg'))
              .width('100%')
              .padding({ left: 16, right: 16, top: 14, bottom: 2 })
            Text(this.pageDesc)
              .fontSize(12)
              .fontColor($r('app.color.fg_secondary'))
              .width('100%')
              .padding({ left: 16, right: 16, bottom: 8 })
            this.ExceptionList()
            Row({ space: 12 }) {
              AppIcon({ icon: $r('sys.symbol.plus'), iconSize: 20, iconColor: $r('app.color.fg') })
              Text('添加例外网站')
                .fontSize(15)
                .fontColor($r('app.color.fg'))
            }
            .width('100%')
            .height(52)
            .padding({ left: 16, right: 16 })
            .onClick(() => {
              this.openAddException(this.pageKind)
            })
          }
          .width('100%')
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

  private bindAppBar(): void {
    AppBar.show({
      title: this.pageTitle,
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
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
          this.pageTitle = obj['title'] ?? ''
          this.pageDesc = obj['desc'] ?? ''
        }
      }
    } catch (error) {
      console.error('read permission params failed')
    }
  }

  @Builder
  ExceptionList() {
    List({ space: 1 }) {
      ForEach(this.settings.getExceptions(this.pageKind), (host: string) => {
        ListItem() {
          Row({ space: 12 }) {
            Text(host)
              .fontSize(15)
              .fontColor($r('app.color.fg'))
              .layoutWeight(1)
              .maxLines(1)
              .textOverflow({ overflow: TextOverflow.Ellipsis })
            AppIcon({ icon: $r('sys.symbol.trash'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
              .onClick(() => {
                this.settings.removeException(this.pageKind, host)
              })
          }
          .width('100%')
          .height(52)
          .padding({ left: 16, right: 16 })
        }
      }, (host: string) => host)
    }
    .width('100%')
  }

  private openAddException(kind: string): void {
    this.hostInput = ''
    this.pendingKind = kind
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.AddExceptionDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.5)'
    }).then((dialogId: number) => {
      this.exceptionDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open exception dialog failed: ${error.message}`)
    })
  }

  @Builder
  AddExceptionDialog() {
    Column({ space: 14 }) {
      Text('添加例外网站')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      TextInput({ placeholder: 'example.com', text: this.hostInput })
        .width('100%')
        .height(44)
        .fontSize(14)
        .onChange((value: string) => {
          this.hostInput = value
        })
      Row({ space: 24 }) {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(15)
          .fontColor($r('app.color.fg_secondary'))
          .padding({ left: 8, right: 8, top: 10, bottom: 10 })
          .onClick(() => {
            this.closeAddException()
          })
        Text($r('app.string.confirm'))
          .fontSize(15)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.accent'))
          .padding({ left: 8, right: 8, top: 10, bottom: 10 })
          .onClick(() => {
            const host = this.hostInput.trim().toLowerCase()
            if (host !== '') {
              this.settings.addException(this.pendingKind, host)
            }
            this.closeAddException()
          })
      }
      .width('100%')
    }
    .width('80%')
    .padding(24)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
    .transition(dialogTransition())
  }

  private closeAddException(): void {
    if (this.exceptionDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.exceptionDialogId)
    this.exceptionDialogId = -1
  }
}

@ComponentV2
export struct AdBlockExceptionPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local exceptionDialogId: number = -1
  @Local hostInput: string = ''

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
            this.SiteList()
            Row({ space: 12 }) {
              AppIcon({ icon: $r('sys.symbol.plus'), iconSize: 20, iconColor: $r('app.color.fg') })
              Text('添加例外网站')
                .fontSize(15)
                .fontColor($r('app.color.fg'))
            }
            .width('100%')
            .height(52)
            .padding({ left: 16, right: 16 })
            .onClick(() => {
              this.openAddException()
            })
          }
          .width('100%')
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
  SiteList() {
    List({ space: 1 }) {
      ForEach(this.settings.siteSettings, (site: SiteSetting) => {
        ListItem() {
          Row({ space: 12 }) {
            Text(site.host)
              .fontSize(15)
              .fontColor($r('app.color.fg'))
              .layoutWeight(1)
              .maxLines(1)
              .textOverflow({ overflow: TextOverflow.Ellipsis })
            Text(site.allowAds ? '不拦截' : '拦截')
              .fontSize(12)
              .fontColor($r('app.color.fg_secondary'))
            Toggle({ type: ToggleType.Switch, isOn: site.allowAds })
              .onChange((value: boolean) => {
                site.allowAds = value
                this.settings.upsertSiteSetting(site)
              })
          }
          .width('100%')
          .height(52)
          .padding({ left: 16, right: 16 })
        }
      }, (site: SiteSetting) => `${site.host}-${site.allowAds}`)
    }
    .width('100%')
  }

  private openAddException(): void {
    this.hostInput = ''
    this.getUIContext().getPromptAction().openCustomDialog({
      builder: (): void => {
        this.AddExceptionDialog()
      },
      isModal: true,
      autoCancel: true,
      alignment: DialogAlignment.Center,
      maskColor: 'rgba(0,0,0,0.5)'
    }).then((dialogId: number) => {
      this.exceptionDialogId = dialogId
    }).catch((error: BusinessError) => {
      console.error(`open exception dialog failed: ${error.message}`)
    })
  }

  @Builder
  AddExceptionDialog() {
    Column({ space: 14 }) {
      Text('添加例外网站')
        .fontSize(17)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .width('100%')
      TextInput({ placeholder: 'example.com', text: this.hostInput })
        .width('100%')
        .height(44)
        .fontSize(14)
        .onChange((value: string) => {
          this.hostInput = value
        })
      Row({ space: 24 }) {
        Blank()
        Text($r('app.string.cancel'))
          .fontSize(15)
          .fontColor($r('app.color.fg_secondary'))
          .padding({ left: 8, right: 8, top: 10, bottom: 10 })
          .onClick(() => {
            this.closeAddException()
          })
        Text($r('app.string.confirm'))
          .fontSize(15)
          .fontWeight(FontWeight.Medium)
          .fontColor($r('app.color.accent'))
          .padding({ left: 8, right: 8, top: 10, bottom: 10 })
          .onClick(() => {
            const host = this.hostInput.trim().toLowerCase()
            if (host !== '') {
              const existing = this.settings.getSiteSetting(host)
              if (existing !== null) {
                existing.allowAds = true
                this.settings.upsertSiteSetting(existing)
              } else {
                const site = new SiteSetting(host)
                site.allowAds = true
                this.settings.upsertSiteSetting(site)
              }
            }
            this.closeAddException()
          })
      }
      .width('100%')
    }
    .width('80%')
    .padding(24)
    .backgroundColor($r('app.color.menu_bg'))
    .borderRadius(16)
    .transition(dialogTransition())
  }

  private closeAddException(): void {
    if (this.exceptionDialogId < 0) {
      return
    }
    this.getUIContext().getPromptAction().closeCustomDialog(this.exceptionDialogId)
    this.exceptionDialogId = -1
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
export function AdBlockExceptionPageBuilder() {
  AdBlockExceptionPage()
}
