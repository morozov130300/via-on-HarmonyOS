import { http } from '@kit.NetworkKit'
import { fileIo, picker } from '@kit.CoreFileKit'
import { BusinessError, pasteboard } from '@kit.BasicServicesKit'
import { UserScriptRec, parseUserScriptMeta, parseJsonArray } from '../common/Types'
import { fetchScriptRequires, gmSecret, gmMenusJs, gmMenuInvokeJs } from '../common/GmRuntime'
import { AppSettings } from '../common/Settings'
import { TabStore } from '../common/TabStore'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { AppIcon } from '../components/AppIcon'

// 原版 x7/j 数组 j + strings o4/i2/i1/i3/i0（sa/d1.java:315）
const SCRIPT_UPDATE_DAYS: number[] = [0, 1, 3, 7, 15]
const SCRIPT_INTERVAL_LABELS: string[] = ['从不', '每天', '每 3 天', '每周', '每 15 天']

@ComponentV2
export struct UserScriptsPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  @Local updating: boolean = false
  @Local editing: UserScriptRec | null = null
  @Local adding: boolean = false
  @Local downloadInputShow: boolean = false

  // X3：z10 = 存在带下载地址的脚本（决定「更新」入口与「自动更新」行）
  private anyScriptWithUrl(): boolean {
    for (let i = 0; i < this.settings.userScripts.length; i++) {
      if (this.settings.userScripts[i].downloadUrl !== '') {
        return true
      }
    }
    return false
  }

  private intervalLabel(): string {
    const days = this.settings.scriptAutoUpdate
    for (let i = SCRIPT_UPDATE_DAYS.length - 1; i >= 0; i--) {
      if (days >= SCRIPT_UPDATE_DAYS[i]) {
        return SCRIPT_INTERVAL_LABELS[i]
      }
    }
    return SCRIPT_INTERVAL_LABELS[0]
  }

  private bindAppBar(): void {
    AppBar.show({
      title: '脚本',
      rightIcon2: $r('sys.symbol.plus'),
      rightText: this.anyScriptWithUrl() ? '更新' : '',
      onBack: () => {
        this.navPathStack.pop()
      },
      onRight2: () => {
        this.showAddMenu()
      },
      onRight: () => {
        this.updateAll()
      }
    }, this)
  }

  // U3：添加菜单 [添加脚本/下载脚本/导入脚本]（sa/d1.java:533-540）
  private showAddMenu(): void {
    ActionSheet.show({
      title: '脚本',
      message: '',
      sheets: [
        { title: '添加脚本', action: (): void => { this.adding = true } },
        { title: '下载脚本', action: (): void => { this.downloadInputShow = true } },
        { title: '导入脚本', action: (): void => { this.importScript() } }
      ]
    })
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // a6.n(1)：启用脚本
            Row() {
              Text('启用脚本')
                .fontSize(15)
                .fontColor($r('app.color.fg'))
                .layoutWeight(1)
              Toggle({ type: ToggleType.Switch, isOn: this.settings.scriptEnabled })
                .onChange((value: boolean) => {
                  this.settings.setScriptEnabled(value)
                })
            }
            .width('100%')
            .height(48)
            .padding({ left: 16, right: 16 })
            // a6.q(2)：自动更新（仅有带源地址脚本时显示）
            if (this.anyScriptWithUrl()) {
              Row() {
                Text('自动更新')
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
                  .layoutWeight(1)
                Text(this.intervalLabel())
                  .fontSize(14)
                  .fontColor($r('app.color.fg_secondary'))
                AppIcon({ icon: $r('sys.symbol.chevron_right'), iconSize: 16, iconColor: $r('app.color.fg_secondary') })
              }
              .width('100%')
              .height(48)
              .padding({ left: 16, right: 16 })
              .onClick(() => {
                this.pickAutoUpdate()
              })
            }
            // a6.l：脚本分区标题
            Text('脚本')
              .fontSize(13)
              .fontColor($r('app.color.fg_secondary'))
              .width('100%')
              .padding({ left: 16, top: 10, bottom: 6 })
            ForEach(this.settings.userScripts, (script: UserScriptRec) => {
              Row() {
                Text(script.name)
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
                  .layoutWeight(1)
                  .onClick(() => {
                    this.editing = script
                  })
                Toggle({ type: ToggleType.Switch, isOn: script.enabled })
                  .onChange((value: boolean) => {
                    script.enabled = value
                    this.settings.saveScript(script)
                  })
              }
              .width('100%')
              .height(48)
              .padding({ left: 16, right: 16 })
              .gesture(LongPressGesture().onActionEnd(() => {
                this.showScriptMenu(script)
              }))
            }, (script: UserScriptRec) => `${script.id}_${script.enabled}_${script.name}_${script.code.length}`)
          }
          .width('100%')
        }
        .layoutWeight(1)
        .align(Alignment.Top)
        .width('100%')
      }
      .width('100%')
      .height('100%')
      if (this.editing !== null || this.adding) {
        ScriptEditOverlay({
          script: this.editing,
          onClose: () => {
            this.editing = null
            this.adding = false
          },
          onSaved: () => {
            this.editing = null
            this.adding = false
          }
        })
      }
      if (this.downloadInputShow) {
        ScriptDownloadOverlay({
          onClose: () => {
            this.downloadInputShow = false
          },
          onConfirm: (url: string) => {
            this.downloadInputShow = false
            this.downloadAndInstall(url, 0)
          }
        })
      }
    }
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

  // r4/x3：自动更新间隔 {0,1,3,7,15} 天
  private pickAutoUpdate(): void {
    const sheets: SheetInfo[] = []
    for (let i = 0; i < SCRIPT_UPDATE_DAYS.length; i++) {
      const value = SCRIPT_UPDATE_DAYS[i]
      const label = SCRIPT_INTERVAL_LABELS[i]
      sheets.push({
        title: this.settings.scriptAutoUpdate === value ? `${label} ✓` : label,
        action: (): void => {
          this.settings.setScriptAutoUpdate(value)
        }
      })
    }
    ActionSheet.show({
      title: '自动更新',
      message: '',
      sheets: sheets
    })
  }

  // P3/T3：长按菜单 [编辑/更新/主页/复制链接/删除]（sa/d1.java:209-274）+ GM 菜单命令（ua/i c0）
  private showScriptMenu(script: UserScriptRec): void {
    const sheets: SheetInfo[] = []
    sheets.push({
      title: '编辑',
      action: (): void => {
        this.editing = script
      }
    })
    if (script.downloadUrl !== '') {
      sheets.push({
        title: '更新',
        action: (): void => {
          this.confirmUpdateSingle(script)
        }
      })
    }
    if (script.homepageUrl !== '') {
      sheets.push({
        title: '主页',
        action: (): void => {
          this.openHomepage(script)
        }
      })
    }
    // P3:4：复制链接无条件显示
    sheets.push({
      title: '复制链接',
      action: (): void => {
        this.copyLink(script)
      }
    })
    sheets.push({
      title: '删除',
      action: (): void => {
        this.confirmDelete(script)
      }
    })
    // GM registerMenuCommand 注册的命令（当前页面 window[secret]['gm_menus']）追加到尾部
    this.appendGmMenuCommands(script, sheets, (): void => {
      ActionSheet.show({
        title: script.name,
        message: '',
        sheets: sheets
      })
    })
  }

  // 在当前标签页枚举该脚本的 GM 菜单命令，追加为 ActionSheet 尾部项
  private appendGmMenuCommands(script: UserScriptRec, sheets: SheetInfo[], done: () => void): void {
    const scriptId = String(script.id)
    const controller = TabStore.getInstance().current().controller
    controller.runJavaScript(gmMenusJs(gmSecret())).then((result: string) => {
      const commands = this.parseGmMenusResult(result, scriptId)
      for (let i = 0; i < commands.length; i++) {
        const command = commands[i]
        sheets.push({
          title: command,
          action: (): void => {
            TabStore.getInstance().current().controller
              .runJavaScript(gmMenuInvokeJs(gmSecret(), scriptId, command)).catch(() => {
              })
          }
        })
      }
      done()
    }).catch(() => {
      done()
    })
  }

  // runJavaScript 结果可能是 JSON 编码字符串（带引号），容错两层解析后取脚本命令名列表
  private parseGmMenusResult(raw: string, scriptId: string): string[] {
    let json: string = raw
    try {
      const first = JSON.parse(raw) as Object
      if (typeof first === 'string') {
        json = first
      }
    } catch (error) {
    }
    try {
      const menus = JSON.parse(json) as Record<string, Object>
      const list = menus[scriptId]
      if (list instanceof Array) {
        const names: string[] = []
        for (let i = 0; i < list.length; i++) {
          if (typeof list[i] === 'string') {
            names.push(list[i] as string)
          }
        }
        return names
      }
    } catch (error) {
    }
    return []
  }

  private openHomepage(script: UserScriptRec): void {
    // z8.b0.P：在浏览器内打开脚本主页
    TabStore.getInstance().newTabAt(script.homepageUrl, false)
  }

  private copyLink(script: UserScriptRec): void {
    // T3:4：复制下载链接（zd 已复制链接）
    const data = pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, script.downloadUrl)
    pasteboard.getSystemPasteboard().setData(data).then(() => {
      this.getUIContext().getPromptAction().showToast({ message: '已复制链接', duration: 1500 })
    }).catch(() => {
    })
  }

  // Y3：删除确认 fl「你确定删除 %s 吗？」
  private confirmDelete(script: UserScriptRec): void {
    this.getUIContext().showAlertDialog({
      message: `你确定删除 ${script.name} 吗？`,
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: $r('app.string.done'),
        action: () => {
          this.settings.removeScript(script.id)
        }
      }
    })
  }

  // C3/V3：单脚本更新确认 rn「你确认更新 %s 吗？」
  private confirmUpdateSingle(script: UserScriptRec): void {
    this.getUIContext().showAlertDialog({
      message: `你确认更新 ${script.name} 吗？`,
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: $r('app.string.done'),
        action: () => {
          this.downloadAndInstall(script.downloadUrl, script.id)
        }
      }
    })
  }

  // g4：导入脚本（文件选择 → j4 解析）
  private importScript(): void {
    try {
      const docPicker = new picker.DocumentViewPicker()
      docPicker.select({ fileSuffixFilters: ['.txt', '.js', '.user.js'] }).then((uris: Array<string>) => {
        if (uris.length === 0) {
          return
        }
        try {
          const content = fileIo.readTextSync(uris[0])
          this.installFromCode(content, '', 0)
        } catch (error) {
          this.toast('解析脚本失败！')
        }
      }).catch((error: BusinessError) => {
        console.error(`select script file failed: ${error.message}`)
      })
    } catch (error) {
      console.error('open file picker failed')
    }
  }

  // l4/k4：下载并安装脚本（yg 解析脚本中… → zh/zi/zj）
  private downloadAndInstall(url: string, id: number): void {
    if (!url.startsWith('http')) {
      this.toast('链接无效。')
      return
    }
    this.toast('解析脚本中…')
    const request = http.createHttp()
    request.request(url, {
      method: http.RequestMethod.GET,
      connectTimeout: 10000,
      readTimeout: 20000,
      usingCache: false
    }).then((response: http.HttpResponse) => {
      const body = response.result
      if (typeof body === 'string' && body.trim() !== '') {
        this.installFromCode(body, url, id)
      } else {
        this.toast('解析脚本失败！')
      }
    }).catch((error: BusinessError) => {
      console.error(`download script failed: ${error.message}`)
      this.toast('解析脚本失败！')
    }).finally(() => {
      request.destroy()
    })
  }

  // G3/H3：解析元数据并落库；失败 toast tg，成功 toast zi/zj
  private installFromCode(code: string, sourceUrl: string, id: number): void {
    const parsed = parseUserScriptMeta(code, sourceUrl)
    if (parsed === null) {
      this.toast('解析脚本失败！')
      return
    }
    const rec = parsed
    if (id > 0) {
      const existing = this.settings.userScripts.find((s: UserScriptRec): boolean => s.id === id)
      if (existing !== undefined) {
        rec.id = existing.id
        rec.enabled = existing.enabled
      } else {
        this.toast(`安装 "${rec.name}" 失败！`)
        return
      }
    } else {
      rec.id = Date.now()
      rec.enabled = true
    }
    this.settings.saveScript(rec)
    fetchScriptRequires(rec)
    this.toast(`安装 "${rec.name}" 成功！`)
  }

  // q4/w4：更新全部（ch 更新 → a0q 开始更新… → a0r 脚本更新完成。）
  private updateAll(): void {
    if (this.updating) {
      return
    }
    const targets: UserScriptRec[] = []
    for (let i = 0; i < this.settings.userScripts.length; i++) {
      const script = this.settings.userScripts[i]
      if (script.enabled && script.downloadUrl.startsWith('http')) {
        targets.push(script)
      }
    }
    if (targets.length === 0) {
      return
    }
    this.getUIContext().showAlertDialog({
      message: targets.length === 1 ? `你确认更新 ${targets[0].name} 吗？`
        : targets.map((s: UserScriptRec): string => s.name).join('\n'),
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: $r('app.string.done'),
        action: () => {
          this.runUpdateAll(targets)
        }
      }
    })
  }

  private runUpdateAll(targets: UserScriptRec[]): void {
    this.updating = true
    this.toast('开始更新…')
    let done = 0
    const finish = (): void => {
      done++
      if (done >= targets.length) {
        this.updating = false
        this.settings.markScriptsUpdated()
        this.toast('脚本更新完成。')
      }
    }
    for (let i = 0; i < targets.length; i++) {
      const script = targets[i]
      const request = http.createHttp()
      request.request(script.downloadUrl, {
        method: http.RequestMethod.GET,
        connectTimeout: 10000,
        readTimeout: 20000,
        usingCache: false
      }).then((response: http.HttpResponse) => {
        const body = response.result
        if (typeof body === 'string' && body.trim() !== '') {
          const parsed = parseUserScriptMeta(body, script.downloadUrl)
          if (parsed !== null) {
            parsed.id = script.id
            parsed.enabled = script.enabled
            this.settings.saveScript(parsed)
            fetchScriptRequires(parsed)
          }
        }
      }).catch((error: BusinessError) => {
        console.error(`update script ${script.name} failed: ${error.message}`)
      }).finally(() => {
        request.destroy()
        finish()
      })
    }
  }

  private toast(message: string): void {
    this.getUIContext().getPromptAction().showToast({ message: message, duration: 1500 })
  }
}

// h4：下载脚本输入对话框（P6 下载脚本，kh 地址）
@ComponentV2
struct ScriptDownloadOverlay {
  @Event onClose: () => void = () => {}
  @Event onConfirm: (url: string) => void = (url: string) => {}
  @Local url: string = ''

  build() {
    Column() {
      Column({ space: 16 }) {
        Text('下载脚本')
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
        TextInput({ text: this.url, placeholder: '地址' })
          .height(40)
          .fontSize(14)
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.fg_secondary'))
          .caretColor($r('app.color.accent'))
          .onChange((value: string) => {
            this.url = value
          })
        Row({ space: 12 }) {
          Button($r('app.string.cancel'))
            .fontSize(14)
            .height(36)
            .layoutWeight(1)
            .backgroundColor($r('app.color.surface'))
            .fontColor($r('app.color.fg'))
            .onClick(() => {
              this.onClose()
            })
          Button($r('app.string.done'))
            .fontSize(14)
            .height(36)
            .layoutWeight(1)
            .backgroundColor($r('app.color.accent'))
            .fontColor(Color.White)
            .onClick(() => {
              const url = this.url.trim()
              if (url === '') {
                this.onClose()
                return
              }
              this.onConfirm(url)
            })
        }
        .width('100%')
      }
      .width('90%')
      .padding(20)
      .backgroundColor($r('app.color.page_bg'))
      .borderRadius(16)
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .backgroundColor('rgba(0,0,0,0.5)')
    .onClick(() => {
      this.onClose()
    })
  }
}

// ta/u + sa/o：脚本编辑器（新增/编辑，保存时解析元数据；initUrl = 从「网页脚本」页 + 进入时预填作用网址 sa.o）
@ComponentV2
export struct ScriptEditOverlay {
  @Param script: UserScriptRec | null = null
  @Param initUrl: string = ''
  @Event onClose: () => void = () => {}
  @Event onSaved: () => void = () => {}
  @Local name: string = ''
  @Local downloadUrl: string = ''
  @Local code: string = ''
  @Local matchUrl: string = ''
  private settings: AppSettings = AppSettings.getInstance()

  aboutToAppear(): void {
    if (this.script !== null) {
      this.name = this.script.name
      this.downloadUrl = this.script.downloadUrl
      this.code = this.script.code
    }
    this.matchUrl = this.initUrl
  }

  build() {
    Column() {
      Scroll() {
        Column({ space: 16 }) {
          Text(this.script === null ? $r('app.string.add_script') : $r('app.string.edit_script'))
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
            Text('源地址')
              .fontSize(12)
              .fontColor($r('app.color.fg_secondary'))
            TextInput({ text: this.downloadUrl, placeholder: 'https:// （可选，供「更新」拉取）' })
              .height(40)
              .fontSize(14)
              .backgroundColor($r('app.color.surface'))
              .fontColor($r('app.color.fg'))
              .placeholderColor($r('app.color.fg_secondary'))
              .caretColor($r('app.color.accent'))
              .onChange((value: string) => {
                this.downloadUrl = value
              })
            // sa.o：从「网页脚本」页 + 进入时为该网址新建脚本，展示作用网址（@match 作用域）
            if (this.initUrl !== '' && this.script === null) {
              Text('网址')
                .fontSize(12)
                .fontColor($r('app.color.fg_secondary'))
              TextInput({ text: this.matchUrl })
                .height(40)
                .fontSize(14)
                .backgroundColor($r('app.color.surface'))
                .fontColor($r('app.color.fg'))
                .caretColor($r('app.color.accent'))
                .onChange((value: string) => {
                  this.matchUrl = value
                })
            }
            Text($r('app.string.script_code'))
              .fontSize(12)
              .fontColor($r('app.color.fg_secondary'))
            TextArea({ text: this.code })
              .height(140)
              .fontSize(13)
              .backgroundColor($r('app.color.surface'))
              .fontColor($r('app.color.fg'))
              .caretColor($r('app.color.accent'))
              .onChange((value: string) => {
                this.code = value
              })
          }
          .alignItems(HorizontalAlign.Start)
          Row({ space: 12 }) {
            Button($r('app.string.cancel'))
              .fontSize(14)
              .height(36)
              .layoutWeight(1)
              .backgroundColor($r('app.color.surface'))
              .fontColor($r('app.color.fg'))
              .onClick(() => {
                this.onClose()
              })
            Button($r('app.string.save'))
              .fontSize(14)
              .height(36)
              .layoutWeight(1)
              .backgroundColor($r('app.color.accent'))
              .fontColor(Color.White)
              .onClick(() => {
                this.save()
              })
          }
          .width('100%')
        }
        .width('90%')
        .padding(20)
      }
      .layoutWeight(1)
      .align(Alignment.Top)
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.5)')
    .onClick(() => {
      this.onClose()
    })
  }

  private save(): void {
    if (this.code.trim() === '') {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.invalid_input'), duration: 1500 })
      return
    }
    const parsed = parseUserScriptMeta(this.code, this.downloadUrl.trim())
    if (parsed === null) {
      this.getUIContext().getPromptAction().showToast({ message: '解析脚本失败！', duration: 1500 })
      return
    }
    const rec = parsed
    if (this.script !== null) {
      rec.id = this.script.id
      rec.enabled = this.script.enabled
    } else {
      rec.id = Date.now()
      rec.enabled = true
    }
    if (this.name.trim() !== '') {
      rec.name = this.name.trim()
    }
    // sa.o：无 Metadata 作用域时以「网址」字段作为 @match 作用域
    if (this.script === null && parseJsonArray(rec.includes).length === 0 && this.matchUrl.trim() !== '') {
      rec.includes = JSON.stringify([this.matchUrl.trim()])
    }
    this.settings.saveScript(rec)
    fetchScriptRequires(rec)
    this.onSaved()
  }
}

@Builder
export function UserScriptsPageBuilder() {
  UserScriptsPage()
}
