import { util } from '@kit.ArkTS'
import { CopilotStore, AiBackend, presetBackend, getKeyLink } from '../common/CopilotStore'
import { AiEngine, AiChatResult, ChatMsgIn } from '../common/AiEngine'
import { TabStore } from '../common/TabStore'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { buildNavSlide } from './PageTransitions'
import { ViaIcon } from '../components/ViaIcon'

// 原版 a9/r0：AI 服务商编辑页
// 字段：名称(hint 标题)/地址/API 密钥 + 「打开 API 密钥生成和管理页面」链接 +
// 「模型 ID」标题行 + 模型输入(回车/加号添加) + 模型列表(点 × 删除)
// AppBar 菜单：[验证][保存]；返回 = 未保存确认（提示/修改的内容未保存…）
@ComponentV2
export struct SettingsAiProviderEditPage {
  private store: CopilotStore = CopilotStore.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local editing: AiBackend | null = null
  @Local nameDraft: string = ''
  @Local addrDraft: string = ''
  @Local keyDraft: string = ''
  @Local modelDraft: string = ''
  @Local models: string[] = []
  @Local isBusy: boolean = false
  private baseline: string = ''
  private modelsChanged: boolean = false

  private bindAppBar(): void {
    AppBar.show({
      // 原版 a3/o3：默认标题「新建」，加载到已存服务商（有 id）时改「编辑」
      title: this.editing !== null && this.editing.id !== '' ? $r('app.string.ai_edit') : $r('app.string.ai_new_label'),
      rightText: $r('app.string.ai_save'),
      onRight: () => {
        this.save(false)
      },
      rightText2: $r('app.string.ai_verify'),
      onRight2: () => {
        this.verify()
      },
      onBack: () => {
        this.handleBack()
      }
    }, this)
  }

  // 原版 E3()：与进入时一致视为未修改（含模型列表变动标记 B0）
  private fingerprint(): string {
    return [this.nameDraft.trim(), this.addrDraft.trim(), this.keyDraft.trim(), this.modelDraft.trim()].join('\n')
  }

  private isUnchanged(): boolean {
    const current = this.fingerprint()
    return ((this.baseline === '' && current === '\n\n\n') || current === this.baseline) && !this.modelsChanged
  }

  // 原版 m3()/o3()：按参数加载（preset → 预设；否则按 id 查库）
  private async load(param: string): Promise<void> {
    if (param !== '') {
      try {
        const obj = JSON.parse(param) as Record<string, Object>
        const preset = obj['preset']
        const id = obj['id']
        if (typeof preset === 'string' && preset !== '') {
          const p = presetBackend(preset)
          if (p !== null) {
            this.apply(p)
            return
          }
        }
        if (typeof id === 'string' && id !== '') {
          const b = await this.store.backend(id)
          if (b !== null) {
            this.apply(b)
            return
          }
        }
      } catch (error) {
        console.error('parse ai provider edit params failed')
      }
    }
    this.baseline = ''
  }

  private apply(b: AiBackend): void {
    this.editing = b
    this.nameDraft = b.name
    this.addrDraft = b.url
    this.keyDraft = b.token
    this.models = b.models.slice()
    // 原版 o3：A0 = v0.d(name, url, key, "")（模型输入恒为空）
    this.baseline = [b.name, b.url, b.token, ''].join('\n')
    this.modelsChanged = false
  }

  // 原版 H3()：打开 API 密钥生成和管理页面
  private openKeyPage(): void {
    const link = getKeyLink(this.addrDraft)
    if (link === null || link === '') {
      return
    }
    this.tabStore.navigate(link)
    this.navPathStack.clear()
  }

  // 原版 C3()：添加模型（去重；置 B0 标记）
  private addModel(): void {
    const name = this.modelDraft.trim()
    if (name === '') {
      return
    }
    this.modelDraft = ''
    if (this.models.includes(name)) {
      return
    }
    this.modelsChanged = true
    this.models.push(name)
  }

  private removeModel(name: string): void {
    this.modelsChanged = true
    this.models = this.models.filter((m: string): boolean => m !== name)
  }

  // 原版 V2()/I3(true)：返回 = 未保存确认（保存并退出 / 退出）
  private handleBack(): void {
    this.save(true)
  }

  // 原版 I3(z)：保存；true = 返回触发（未修改直接退出，有修改弹确认），false = 菜单/确认触发
  private save(fromBack: boolean): void {
    if (this.isBusy) {
      return
    }
    if (this.isUnchanged()) {
      this.navPathStack.pop()
      return
    }
    if (fromBack) {
      this.getUIContext().showAlertDialog({
        title: $r('app.string.ai_unsaved_title'),
        message: $r('app.string.ai_unsaved_msg'),
        primaryButton: {
          value: $r('app.string.exit_app'),
          action: () => {
            this.navPathStack.pop()
          }
        },
        secondaryButton: {
          value: $r('app.string.ai_save_and_exit'),
          action: () => {
            this.save(false)
          }
        }
      })
      return
    }
    // 原版空值校验：名称/地址/密钥逐个检查，空则抖动聚焦；模型输入与列表全空则聚焦模型输入
    const name = this.nameDraft.trim()
    const addr = this.addrDraft.trim()
    const key = this.keyDraft.trim()
    if (name === '' || addr === '' || key === '') {
      return
    }
    if (this.modelDraft.trim() === '' && this.models.length === 0) {
      return
    }
    this.isBusy = true
    // 原版 I3：新建 → UUID + created；编辑 → 保留 id/created；url 去掉结尾 /chat/completions
    let url = addr
    if (url.endsWith('/chat/completions')) {
      url = url.substring(0, url.length - 17)
    }
    const now = Date.now()
    let isNew = false
    if (this.editing === null || this.editing.id === '') {
      isNew = true
      this.editing = new AiBackend()
      this.editing.id = util.generateRandomUUID(false)
      this.editing.createdAt = now
    }
    this.editing.name = name
    this.editing.url = url
    this.editing.token = key
    if (!this.models.includes(this.modelDraft.trim()) && this.modelDraft.trim() !== '') {
      this.editing.models = this.models.concat([this.modelDraft.trim()])
    } else {
      this.editing.models = this.models.slice()
    }
    this.editing.updatedAt = now
    const target = this.editing
    if (isNew) {
      this.store.insertBackend(target).then(() => {
        this.navPathStack.pop()
      }).catch(() => {
        this.isBusy = false
      })
    } else {
      this.store.updateBackend(target.id, target).then(() => {
        this.navPathStack.pop()
      }).catch(() => {
        this.isBusy = false
      })
    }
  }

  // 原版 K3()：验证 —— 组临时服务商，toast「稍等片刻…」，complete("Say 'test'")
  private verify(): void {
    if (this.isBusy) {
      return
    }
    const name = this.nameDraft.trim()
    const addr = this.addrDraft.trim()
    const key = this.keyDraft.trim()
    if (name === '' || addr === '' || key === '') {
      return
    }
    if (this.models.length === 0) {
      return
    }
    const now = Date.now()
    const probe = new AiBackend()
    probe.id = util.generateRandomUUID(false)
    probe.name = name
    probe.url = addr
    probe.token = key
    probe.models = this.models.slice()
    probe.createdAt = now
    probe.updatedAt = now
    const model = this.models[0]
    this.getUIContext().getPromptAction().showToast({ message: $r('app.string.ai_wait'), duration: 1500 })
    const engine = new AiEngine()
    const messages: ChatMsgIn[] = [new ChatMsgIn('user', "Say 'test'")]
    engine.complete(probe, model, messages).then((result: AiChatResult) => {
      // 原版 J3：失败 → 标题「验证失败」+ p9.s.e；成功 → 标题「验证」+「验证成功」
      if (result.status === 100) {
        this.getUIContext().showAlertDialog({
          title: $r('app.string.ai_verify_fail'),
          message: this.verifyErrorText(result),
          primaryButton: {
            value: $r('app.string.confirm'),
            action: () => {
            }
          }
        })
      } else {
        this.getUIContext().showAlertDialog({
          title: $r('app.string.ai_verify'),
          message: $r('app.string.ai_verify_ok'),
          primaryButton: {
            value: $r('app.string.confirm'),
            action: () => {
            }
          }
        })
      }
    })
  }

  // 原版 p9/s.e()：验证失败文案（HTTP 错误带码与响应体；其余未知错误）
  private verifyErrorText(result: AiChatResult): string {
    if (result.httpCode !== 0) {
      return this.getUIContext().getHostContext()!.resourceManager.getStringSync($r('app.string.ai_http_error').id,
        result.httpCode, result.httpBody === '' ? 'Empty' : result.httpBody)
    }
    const err = result.error === '' ? 'Unknow error' : result.error
    return this.getUIContext().getHostContext()!.resourceManager.getStringSync($r('app.string.ai_unknown_error').id, err)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // 名称（原版 hint =「标题」）
            TextInput({ text: this.nameDraft, placeholder: $r('app.string.ai_title_label') })
              .fontSize(15)
              .fontColor($r('app.color.fg'))
              .placeholderColor($r('app.color.fg_secondary'))
              .backgroundColor($r('app.color.surface'))
              .width('100%')
              .height(46)
              .margin({ bottom: 12 })
              .onChange((value: string) => {
                this.nameDraft = value
              })
            // 地址
            TextInput({ text: this.addrDraft, placeholder: $r('app.string.ai_addr_label') })
              .fontSize(15)
              .fontColor($r('app.color.fg'))
              .placeholderColor($r('app.color.fg_secondary'))
              .backgroundColor($r('app.color.surface'))
              .width('100%')
              .height(46)
              .margin({ bottom: 12 })
              .onChange((value: string) => {
                this.addrDraft = value
              })
            // API 密钥（密码输入）
            TextInput({ text: this.keyDraft, placeholder: $r('app.string.ai_api_key_label') })
              .type(InputType.Password)
              .fontSize(15)
              .fontColor($r('app.color.fg'))
              .placeholderColor($r('app.color.fg_secondary'))
              .backgroundColor($r('app.color.surface'))
              .width('100%')
              .height(46)
              .margin({ bottom: 12 })
              .onChange((value: string) => {
                this.keyDraft = value
              })
            // 原版 l3()：密钥管理页链接（地址无已知 host 时隐藏）
            if (getKeyLink(this.addrDraft) !== null) {
              Text($r('app.string.ai_open_key_page'))
                .fontSize(13)
                .fontColor($r('app.color.accent'))
                .decoration({ type: TextDecorationType.Underline })
                .maxLines(1)
                .width('100%')
                .margin({ bottom: 12 })
                .onClick(() => {
                  this.openKeyPage()
                })
            }
            // 原版「模型 ID」标题行
            Text($r('app.string.ai_model_id'))
              .fontSize(14)
              .fontWeight(FontWeight.Bold)
              .fontColor($r('app.color.fg'))
              .width('100%')
              .padding({ top: 4, bottom: 4 })
            Row() {
              TextInput({ text: this.modelDraft, placeholder: $r('app.string.ai_model_id') })
                .fontSize(15)
                .fontColor($r('app.color.fg'))
                .placeholderColor($r('app.color.fg_secondary'))
                .backgroundColor($r('app.color.surface'))
                .height(46)
                .layoutWeight(1)
                .onChange((value: string) => {
                  this.modelDraft = value
                })
                .onSubmit(() => {
                  this.addModel()
                })
              // 原版 i3：加号按钮（48×40，icon 22）
              Stack({ alignContent: Alignment.Center }) {
                ViaIcon({ icon: $r('app.media.via_ic_add'), iconSize: 22, iconColor: $r('app.color.fg') })
              }
                .width(48)
                .height(40)
                .margin({ left: 6 })
                .onClick(() => {
                  this.addModel()
                })
            }
            .width('100%')
            .margin({ bottom: 6 })
            // 模型列表（原版 c9.n 行：名称 + × 删除）
            ForEach(this.models, (model: string) => {
              Row() {
                Text(model)
                  .fontSize(14)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .layoutWeight(1)
                Stack({ alignContent: Alignment.Center }) {
                  ViaIcon({ icon: $r('app.media.via_ic_cancel'), iconSize: 14, iconColor: $r('app.color.fg_secondary') })
                }
                  .width(40)
                  .height(40)
                  .onClick(() => {
                    this.removeModel(model)
                  })
              }
              .width('100%')
              .height(44)
              .padding({ left: 12, right: 6 })
              .backgroundColor($r('app.color.surface'))
              .borderRadius(6)
              .margin({ bottom: 6 })
            }, (model: string) => model)
          }
          .width('100%')
          .padding({ left: 16, right: 16, top: 12 })
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
      }
      .width('100%')
      .height('100%')
    }
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
      const param: Object | undefined = ctx.pathInfo.param === undefined ? undefined : ctx.pathInfo.param as Object
      this.load(typeof param === 'string' ? param : '').then(() => {
        this.bindAppBar()
      })
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

@Builder
export function SettingsAiProviderEditPageBuilder() {
  SettingsAiProviderEditPage()
}
