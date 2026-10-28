import { SiteSetting } from '../common/Types'
import { AppSettings } from '../common/Settings'
import { SettingCheckRow } from '../components/SettingRows'
import { SettingsHeader } from '../components/SettingsHeader'
import { AppIcon } from '../components/AppIcon'
import { BusinessError } from '@kit.BasicServicesKit'

// 网站设定的四个子页面：所有网站 / 字体大小 / 权限例外 / 广告拦截例外

@ComponentV2
export struct SiteAllPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '所有网站',
          onBack: () => {
            this.navPathStack.pop()
          }
        })
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

@ComponentV2
export struct FontSizePage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local exceptionDialogId: number = -1
  @Local hostInput: string = ''

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '字体大小',
          onBack: () => {
            this.navPathStack.pop()
          }
        })
        Scroll() {
          Column() {
            Row() {
              Text('字体大小')
                .fontSize(15)
                .fontColor($r('app.color.fg'))
              Text(`${this.settings.textZoom}%`)
                .fontSize(13)
                .fontColor($r('app.color.fg_secondary'))
                .margin({ left: 8 })
                .layoutWeight(1)
              Slider({ value: this.settings.textZoom, min: 50, max: 200, step: 5, style: SliderStyle.OutSet })
                .width(180)
                .selectedColor($r('app.color.accent'))
                .trackColor($r('app.color.divider'))
                .onChange((value: number) => {
                  this.settings.setTextZoom(Math.round(value))
                })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 14, bottom: 14 })

            Column() {
              Text('莫忧世事兼身事，须著人间比梦间。')
                .fontSize(16 * this.settings.textZoom / 100)
                .fontColor($r('app.color.fg'))
            }
            .width('100%')
            .padding(20)
            .margin({ left: 16, right: 16 })
            .borderRadius(12)
            .backgroundColor($r('app.color.surface'))

            SettingCheckRow({
              rowLabel: '强制缩放',
              isChecked: this.settings.forceZoom,
              onCheckRow: (isOn: boolean) => {
                this.settings.setForceZoom(isOn)
              }
            })
            this.AddExceptionRow('font')
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
    })
  }

  @Builder
  AddExceptionRow(kind: string) {
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
      this.openAddException(kind)
    })
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

  @Local pendingKind: string = 'font'

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
        SettingsHeader({
          headerTitle: this.pageTitle,
          onBack: () => {
            this.navPathStack.pop()
          }
        })
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

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '广告拦截',
          onBack: () => {
            this.navPathStack.pop()
          }
        })
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
