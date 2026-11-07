import { fileIo, picker } from '@kit.CoreFileKit'
import { BusinessError, pasteboard } from '@kit.BasicServicesKit'
import { preferences } from '@kit.ArkData'
import { UserScriptRec, parseUserScriptMeta } from '../common/Types'
import { fetchScriptRequires } from '../common/GmRuntime'
import { fetchScriptText } from '../common/ScriptUpdater'
import { META_STORE_NAME, metaStoreSaveScript, prefetchScriptResources, scriptIdOf } from '../common/ScriptResources'
import { AppSettings } from '../common/Settings'
import { TabStore } from '../common/TabStore'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { AppIcon } from '../components/AppIcon'
import { computeDialogWidthVp } from '../components/ViaDialogCard'
import { buildNavSlide } from './PageTransitions'

// 原版 x7/j 数组 j + strings o4/i2/i1/i3/i0（sa/d1.java:315）
const SCRIPT_UPDATE_DAYS: number[] = [0, 1, 3, 7, 15]
const SCRIPT_INTERVAL_LABELS: string[] = ['从不', '每天', '每 3 天', '每周', '每 15 天']

// sa/d1.U3：添加菜单 [添加脚本 ba / 下载脚本 l_ / 导入脚本 l9]
@ComponentV2
export struct UserScriptsPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
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
            // a6.n(1)：启用脚本（hm）
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
            // a6.q(2)：自动更新（仅有带源地址脚本时显示，a0l）
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
            // a6.l：脚本分区标题（tq）
            Text('脚本')
              .fontSize(13)
              .fontColor($r('app.color.fg_secondary'))
              .width('100%')
              .padding({ left: 16, top: 10, bottom: 6 })
            ForEach(this.settings.userScripts, (script: UserScriptRec) => {
              // a6.o + sa/h1.m：名称行 + 版本号行（f123j，空隐藏）+ 启用开关；
              // sa/h1:54：全局脚本停用或脚本不完整（无内容）时整行 alpha 0.5
              Column() {
                Row() {
                  Text(script.name)
                    .fontSize(15)
                    .fontColor($r('app.color.fg'))
                    .maxLines(1)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                    .layoutWeight(1)
                  Toggle({ type: ToggleType.Switch, isOn: script.enabled })
                    .onChange((value: boolean) => {
                      script.enabled = value
                      this.settings.saveScript(script)
                    })
                }
                .width('100%')
                .height(48)
                .padding({ left: 16, right: 16 })
                if (script.version !== '') {
                  Text(script.version)
                    .fontSize(12)
                    .fontColor($r('app.color.fg_secondary'))
                    .maxLines(3)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                    .width('100%')
                    .padding({ left: 16, right: 16, bottom: 8 })
                }
              }
              .width('100%')
              .opacity(!this.settings.scriptEnabled || script.code === '' ? 0.5 : 1)
              .onClick(() => {
                // sa/d1.D3：条目点击（开关自身消费点击，不触发）
                this.onScriptClick(script)
              })
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
            // sa/d1.q3：地址校验 i6.i0.s（http:// 或 https:// 前缀，a0z 链接无效。）
            if (!url.startsWith('http://') && !url.startsWith('https://')) {
              this.toast('链接无效。')
              return
            }
            this.downloadAndInstall(url, 0)
          }
        })
      }
    }
    .hideTitleBar(true)
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

  // P3/T3：长按菜单 [编辑 a3 / 更新 a0j / 主页 km / 复制链接 s / 删除 x]
  // （sa/d1.java:209-274——原版长按菜单无 GM registerMenuCommand 命令，
  //   GM 命令展示在「网页脚本」页 ua.i，见 WebScriptsPage）
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
          // sa/d1.u4 → l4：长按「更新」无预确认，直接下载（确认在解析后 t2.n 弹窗）
          this.downloadAndInstall(script.downloadUrl, script.id)
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
    ActionSheet.show({
      title: script.name,
      message: '',
      sheets: sheets
    })
  }

  // sa/d1.D3：点击条目——不完整脚本（无内容，p5/b.w）先询问下载完整脚本（ro），其余进入编辑
  private onScriptClick(script: UserScriptRec): void {
    if (script.code === '') {
      this.getUIContext().showAlertDialog({
        title: script.name,
        message: '该脚本不完整且无法运行，你想要下载完整脚本吗？',
        primaryButton: {
          value: $r('app.string.cancel'),
          action: () => {
          }
        },
        secondaryButton: {
          value: '确定',
          action: () => {
            // sa/d1.r3 → l4(下载地址, id)：下载并走解析确认流程
            this.downloadAndInstall(script.downloadUrl, script.id)
          }
        }
      })
      return
    }
    this.editing = script
  }

  private openHomepage(script: UserScriptRec): void {
    // z8.b0.P：在浏览器内打开脚本主页
    TabStore.getInstance().newTabAt(script.homepageUrl, false)
  }

  private copyLink(script: UserScriptRec): void {
    // T3:4：复制下载链接（pg 已复制链接）
    const data = pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, script.downloadUrl)
    pasteboard.getSystemPasteboard().setData(data).then(() => {
      this.getUIContext().getPromptAction().showToast({ message: '已复制链接', duration: 1500 })
    }).catch(() => {
    })
  }

  // Y3：删除确认 fl「你确定删除 %s 吗？」（R.string.ok / R.string.cancel）
  private confirmDelete(script: UserScriptRec): void {
    this.getUIContext().showAlertDialog({
      message: `你确定删除 ${script.name} 吗？`,
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: '确定',
        action: () => {
          this.settings.removeScript(script.id)
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

  // l4/k4：下载并安装脚本（zg 解析脚本中… → s4/t2.n 确认）；s5.b.d 下载含镜像回退
  private downloadAndInstall(url: string, id: number): void {
    this.toast('解析脚本中…')
    fetchScriptText(url).then((code: string | null) => {
      if (code === null || code.trim() === '') {
        // s4：解析结果为空 → tg 解析脚本失败！
        this.toast('解析脚本失败！')
        return
      }
      this.installFromCode(code, url, id)
    }).catch((error: BusinessError) => {
      console.error(`download script failed: ${error.message}`)
      this.toast('解析脚本失败！')
    })
  }

  // G3/H3（z8/t2.n）：解析后按「新脚本 / 已存在且版本相同 / 已存在且版本不同」三态确认：
  // yy+na 安装脚本 / z2+nf 重新安装脚本 / z9+nl 更新脚本（版本空回退旧版本，再回退 "0.1"，字符串等值比较）
  private installFromCode(code: string, sourceUrl: string, id: number): void {
    const parsed = parseUserScriptMeta(code, sourceUrl)
    if (parsed === null) {
      this.toast('解析脚本失败！')
      return
    }
    const existing = this.findExistingScript(parsed, id)
    const oldVersion = existing !== null ? existing.version : ''
    // t2.n:124-125：新版本为空回退旧版本，再回退 "0.1"
    let newVersion = parsed.version
    if (newVersion === '') {
      newVersion = oldVersion !== '' ? oldVersion : '0.1'
    }
    let title = ''
    let message = ''
    if (existing === null) {
      title = '安装脚本'
      message = `你确定安装 "${parsed.name}"(${newVersion}) 吗？`
    } else if (newVersion === oldVersion) {
      title = '重新安装脚本'
      message = `你确定重新安装 "${parsed.name}"(${newVersion}) 吗？`
    } else {
      title = '更新脚本'
      message = `你确定更新脚本 "${parsed.name}"(${oldVersion !== '' ? oldVersion : '0.1'} -> ${newVersion}) 吗？`
    }
    this.getUIContext().showAlertDialog({
      title: title,
      message: message,
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: '确定',
        action: () => {
          this.persistScript(parsed, existing, id)
        }
      }
    })
  }

  // p5/b.i：已装脚本查找——id > 0 按 id；否则 download_url 与 script_id（MD5(host+name)，
  // r5/a.f:289）双判据（script_id = ? OR download_url = ?）
  private findExistingScript(parsed: UserScriptRec, id: number): UserScriptRec | null {
    const scripts = this.settings.userScripts
    if (id > 0) {
      for (let i = 0; i < scripts.length; i++) {
        if (scripts[i].id === id) {
          return scripts[i]
        }
      }
      return null
    }
    if (parsed.downloadUrl !== '') {
      for (let i = 0; i < scripts.length; i++) {
        if (scripts[i].downloadUrl === parsed.downloadUrl) {
          return scripts[i]
        }
      }
    }
    if (parsed.scriptId !== '') {
      for (let i = 0; i < scripts.length; i++) {
        if (scriptIdOf(scripts[i]) === parsed.scriptId) {
          return scripts[i]
        }
      }
    }
    return null
  }

  // t2.f 确认分支：p5/b.p 持久化（更新/重装保留原启用位 t2.n:147 aVar.g(cVar.j())，
  // 新脚本默认启用）→ toast zj 安装成功
  private persistScript(parsed: UserScriptRec, existing: UserScriptRec | null, id: number): void {
    if (existing !== null) {
      parsed.id = existing.id
      parsed.enabled = existing.enabled
    } else if (id > 0) {
      parsed.id = id
      parsed.enabled = true
    } else {
      parsed.id = Date.now()
      parsed.enabled = true
    }
    this.settings.saveScript(parsed)
    this.persistScriptMeta(parsed)
    fetchScriptRequires(parsed)
    // p5.a.J：@resource 依赖预取（缺失/过期即下载）
    prefetchScriptResources(parsed)
    this.toast(`安装 "${parsed.name}" 成功！`)
  }

  // p5 scripts 表扩展列（icon_url/support_url/resources/script_id/last_updated_at）旁路持久化，
  // metaStoreSaveScript 同步刷新 last_updated_at（r5/a.f:231-232，避免下个自动更新周期立即重拉）
  private persistScriptMeta(script: UserScriptRec): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    preferences.getPreferences(context, META_STORE_NAME).then((store: preferences.Preferences) => {
      metaStoreSaveScript(store, script)
    }).catch((error: BusinessError) => {
      console.error(`save script meta failed: ${error.message}`)
    })
  }

  // q4/w4：更新全部（ch 更新 → a0q 开始更新… → a0r 脚本更新完成。）
  private updateAll(): void {
    if (this.updating) {
      return
    }
    const targets: UserScriptRec[] = []
    for (let i = 0; i < this.settings.userScripts.length; i++) {
      const script = this.settings.userScripts[i]
      // sa/d1.q4：enabled && i6.i0.s(downloadUrl)（http:// 或 https:// 前缀）
      if (script.enabled && (script.downloadUrl.startsWith('http://') ||
        script.downloadUrl.startsWith('https://'))) {
        targets.push(script)
      }
    }
    if (targets.length === 0) {
      return
    }
    this.getUIContext().showAlertDialog({
      title: '更新',
      message: targets.length === 1 ? `你确认更新 ${targets[0].name} 吗？`
        : targets.map((s: UserScriptRec): string => s.name).join('\n'),
      primaryButton: {
        value: $r('app.string.cancel'),
        action: () => {
        }
      },
      secondaryButton: {
        value: '确定',
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
      // sa/d1.v4 → s5.b.d：更新下载同样走镜像回退
      fetchScriptText(script.downloadUrl).then((code: string | null) => {
        if (code !== null && code.trim() !== '') {
          const parsed = parseUserScriptMeta(code, script.downloadUrl)
          if (parsed !== null) {
            parsed.id = script.id
            parsed.enabled = script.enabled
            this.settings.saveScript(parsed)
            this.persistScriptMeta(parsed)
            fetchScriptRequires(parsed)
            prefetchScriptResources(parsed)
          }
        }
        finish()
      }).catch((error: BusinessError) => {
        console.error(`update script ${script.name} failed: ${error.message}`)
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
          Button('确定')
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
      .width('100%')
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

// sa/o.java：脚本编辑器 1:1（标题 a3 编辑 / ba 添加脚本；工具动作 k9 帮助 + ap 保存；
// 正文 = 等宽代码编辑器（提示 sl「代码 (JavaScript)」）；新建脚本使用默认模板（X1:304，
// 作用网址替换 @match、namespace 追加 6 位随机后缀 g6.p.b(6)）；
// 保存解析失败 → yh/mz 询问添加默认 Metadata 块（e3：在正文开头插入）；未保存关闭 → g6/nt
// 确认（sa 保存并退出 / i9 退出）；帮助弹窗 u3 HTML + m_ 了解更多（Tampermonkey 文档）
const SCRIPT_TEMPLATE: string = '// ==UserScript==\n// @name         New Userscript\n' +
  '// @namespace    https://viayoo.com/\n// @version      0.1\n' +
  '// @description  try to take over the world!\n// @author       You\n' +
  '// @run-at       document-end\n// @match        https://*/*\n// @grant        none\n' +
  '// ==/UserScript==\n\n(function() {\n    \'use strict\';\n\n    // Your code here...\n})();'

// sa/o.e3：解析失败时插入正文开头的默认 Metadata 块（与原版逐字一致）
const META_BLOCK_TEMPLATE: string = '// ==UserScript==\n// @name         New Userscript\n' +
  '// @namespace    https://viayoo.com/\n// @version      0.1\n' +
  '// @description  try to take over the world!\n// @author       You\n' +
  '// @run-at       document-end\n// @match        https://*/*\n// @grant        none\n// ==/UserScript==\n\n'

// sa/o 帮助弹窗正文（x7.u.u3，Html.fromHtml 富文本）
const HELP_HTML: string = '<b>Metadata 块</b><br /> Metadata 必须使用如下格式:<br /> <tt> // ==UserScript==' +
  '<br /> // @key value<br /> // ==/UserScript== </tt> <br /><br /> <b><tt>@name</tt></b>：脚本名称。 ' +
  '<br /><br /> <b><tt>@namespace</tt></b>：<tt>@namespace</tt> 和 <tt>@name</tt> 是脚本的唯一 ID。 ' +
  '<br /><br /> <b><tt>@match/@exclude-match</tt></b>：定义了脚本的作用域。推荐使用 <tt>@match</tt> 而不是 ' +
  '<tt>@include</tt>。 <br /><br /> <b><tt>@include/@exclude</tt></b>：旧版本中定义作用域的方式。 ' +
  '<br /><br /> <b><tt>@version</tt></b>：脚本版本。 <br /><br /> <b><tt>@description</tt></b>：脚本描述。 ' +
  '<br /><br /> <b><tt>@author</tt></b>：脚本作者。 <br /><br /> <b><tt>@require</tt></b>：脚本的前置依赖，' +
  '例如： <br /><tt>// @require https://my.cdn.com/jquery.js</tt>。 <br /><br /> <b><tt>@run-at</tt></b>：' +
  '脚本的运行时机。 <tt>document-start</tt> 用于在页面 DOM 加载前注入脚本， <tt>document-end</tt> 用于在页面 ' +
  'DOM 加载完成后注入脚本， <tt>document-idle</tt> 用于在页面空闲后注入脚本。 <br /><br /> <b><tt>@grant</tt>' +
  '</b>：定义脚本所使用和应被授权的特殊 GM_* API。<br /> <br /><br /> <b><tt>@downloadURL</tt></b>：脚本的' +
  '下载地址。 <br /><br /> <b><tt>@supportURL</tt></b>：脚本的支持地址。 <br /><br /> <b><tt>@homepageURL' +
  '</tt></b>：脚本的主页。 <br /><br /> <b>GM_* API</b><br /> <tt>GM_*</tt> 是一组 Via 提供的特殊 API 集合。' +
  '当前支持的特殊 API 包括：<br/> <tt>GM_getValue/GM_setValue/GM_deleteValue/GM_listValues/' +
  'GM_getResourceText/GM_getResourceURL/GM_addElement/GM_addStyle/GM_setClipboard/GM_xmlhttpRequest/' +
  'GM_download/GM_registerMenuCommand/GM_unregisterMenuCommand</tt>. <br /><br /> <b>匹配</b><br /> ' +
  '<tt>@match</tt> 定义了脚本生效的作用域。 <tt>@exclude-match</tt> 定义了脚本不应生效的作用域，' +
  '类似 <tt>@exclude</tt>。 <br /><br /> 例如:<br /> <tt> // @match https://www.google.com/something ' +
  '<br /> // @match https://www.google.com/any/* <br /> // @exclude-match ' +
  'https://www.google.com/any/not_me </tt> <br /><br />'

// g6.p.b(6)：6 位随机小写字母数字（namespace 后缀）
function randomToken(length: number): string {
  const chars = 'abcdefghijklmnopqrstuvwxyz0123456789'
  let result = ''
  for (let i = 0; i < length; i++) {
    result += chars.charAt(Math.floor(Math.random() * chars.length))
  }
  return result
}

// sa/o.X1:304：新建脚本默认模板——作用网址 i6.i0.s 有效时替换 @match；namespace 追加 6 位随机后缀
function newScriptTemplate(url: string): string {
  const validUrl = url.startsWith('http://') || url.startsWith('https://')
  let template = validUrl ? SCRIPT_TEMPLATE.replace('https://*/*', url) : SCRIPT_TEMPLATE
  return template.replace('https://viayoo.com/', 'https://viayoo.com/' + randomToken(6))
}

@ComponentV2
export struct ScriptEditOverlay {
  @Param script: UserScriptRec | null = null
  @Param initUrl: string = ''
  @Event onClose: () => void = () => {}
  @Event onSaved: () => void = () => {}
  @Local code: string = ''
  @Local helpShow: boolean = false
  private initialCode: string = ''
  private settings: AppSettings = AppSettings.getInstance()

  aboutToAppear(): void {
    if (this.script !== null) {
      this.code = this.script.code
    } else {
      this.code = newScriptTemplate(this.initUrl)
    }
    this.initialCode = this.code
  }

  build() {
    Column() {
      Column({ space: 12 }) {
        // sa/o.a3 工具栏：标题（a3 编辑 / ba 添加脚本）+ k9 帮助 + ap 保存
        Row() {
          Text(this.script === null ? $r('app.string.add_script') : '编辑')
            .fontSize(16)
            .fontWeight(FontWeight.Bold)
            .fontColor($r('app.color.fg'))
            .layoutWeight(1)
          Text('帮助')
            .fontSize(14)
            .fontColor($r('app.color.accent'))
            .padding({ left: 12, right: 4 })
            .onClick(() => {
              this.helpShow = true
            })
          Text($r('app.string.save'))
            .fontSize(14)
            .fontColor($r('app.color.accent'))
            .padding({ left: 12, right: 4 })
            .onClick(() => {
              this.save()
            })
        }
        .width('100%')
        // sa/o.Z2：等宽代码编辑器（提示 sl 代码 (JavaScript)）
        TextArea({ text: this.code, placeholder: '代码 (JavaScript)' })
          .layoutWeight(1)
          .width('100%')
          .fontSize(13)
          .fontFamily('monospace')
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.fg_secondary'))
          .caretColor($r('app.color.accent'))
          .onChange((value: string) => {
            this.code = value
          })
      }
      .width('90%')
      .height('92%')
      .padding(20)
      .backgroundColor($r('app.color.page_bg'))
      .borderRadius(16)
      if (this.helpShow) {
        this.helpDialog()
      }
    }
    .width('100%')
    .height('100%')
    .backgroundColor('rgba(0,0,0,0.5)')
    .onClick(() => {
      this.requestClose()
    })
  }

  // sa/o.a：帮助弹窗（标题 k9 帮助，正文 u3 富文本，OK 关闭，m_ 了解更多打开 Tampermonkey 文档）
  @Builder
  helpDialog() {
    Column() {
      Column({ space: 12 }) {
        Text('帮助')
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
        Scroll() {
          RichText(HELP_HTML)
            .width('100%')
            .height(360)
        }
        .align(Alignment.Top)
        .scrollBar(BarState.Auto)
        Row({ space: 12 }) {
          Button('了解更多')
            .fontSize(14)
            .height(36)
            .layoutWeight(1)
            .backgroundColor($r('app.color.surface'))
            .fontColor($r('app.color.fg'))
            .onClick(() => {
              // z8.b0.P：浏览器内打开 Tampermonkey 文档
              TabStore.getInstance().newTabAt('https://www.tampermonkey.net/documentation.php', false)
            })
          Button('确定')
            .fontSize(14)
            .height(36)
            .layoutWeight(1)
            .backgroundColor($r('app.color.accent'))
            .fontColor(Color.White)
            .onClick(() => {
              this.helpShow = false
            })
        }
        .width('100%')
      }
      .width('100%')
      .padding(20)
      .backgroundColor($r('app.color.page_bg'))
      .borderRadius(16)
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .backgroundColor('rgba(0,0,0,0.5)')
    .onClick(() => {
      this.helpShow = false
    })
  }

  // sa/o.s3：未保存判定（空内容或与初始内容一致视为未改动）
  private unchanged(): boolean {
    return this.code === '' || this.code === this.initialCode
  }

  // sa/o.u3：关闭路径——未改动直接关闭，否则 g6/nt 确认（sa 保存并退出 / i9 退出）
  private requestClose(): void {
    if (this.unchanged()) {
      this.onClose()
      return
    }
    this.getUIContext().showAlertDialog({
      title: '提示',
      message: '修改的内容未保存，是否保存？',
      primaryButton: {
        value: '退出',
        action: () => {
          this.onClose()
        }
      },
      secondaryButton: {
        value: '保存并退出',
        action: () => {
          this.save()
        }
      }
    })
  }

  // sa/o.w3/v3：保存——未改动直接关闭；解析失败 → yh/mz 询问添加默认 Metadata 块；
  // 成功 → d3/b3 持久化后关闭
  private save(): void {
    if (this.unchanged()) {
      this.onClose()
      return
    }
    // sa/o.v3:245：基址取既有脚本的下载地址（新脚本为空）
    const baseUrl = this.script !== null ? this.script.downloadUrl : ''
    const parsed = parseUserScriptMeta(this.code, baseUrl)
    if (parsed === null) {
      this.getUIContext().showAlertDialog({
        title: '添加 Metadata 块',
        message: '此脚本没有 Metadata 块所以无法保存。您想要为其添加一个默认的 Metadata 块吗？',
        primaryButton: {
          value: $r('app.string.cancel'),
          action: () => {
          }
        },
        secondaryButton: {
          value: '确定',
          action: () => {
            // sa/o.e3：在正文开头插入默认 Metadata 块
            this.code = META_BLOCK_TEMPLATE + this.code
          }
        }
      })
      return
    }
    this.persistParsed(parsed)
  }

  // sa/o.d3/b3：更新保留原启用位（aVar.g(cVar.j())），新脚本默认启用；保存后关闭
  private persistParsed(parsed: UserScriptRec): void {
    if (this.script !== null) {
      parsed.id = this.script.id
      parsed.enabled = this.script.enabled
    } else {
      parsed.id = Date.now()
      parsed.enabled = true
    }
    this.settings.saveScript(parsed)
    this.persistScriptMeta(parsed)
    fetchScriptRequires(parsed)
    // p5.a.J：@resource 依赖预取
    prefetchScriptResources(parsed)
    this.onSaved()
  }

  // p5 scripts 表扩展列旁路持久化（metaStoreSaveScript 同步刷新 last_updated_at）
  private persistScriptMeta(script: UserScriptRec): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    preferences.getPreferences(context, META_STORE_NAME).then((store: preferences.Preferences) => {
      metaStoreSaveScript(store, script)
    }).catch((error: BusinessError) => {
      console.error(`save script meta failed: ${error.message}`)
    })
  }
}

@Builder
export function UserScriptsPageBuilder() {
  UserScriptsPage()
}
