import { display } from '@kit.ArkUI'
import { pasteboard } from '@kit.BasicServicesKit'
import { common, Want } from '@kit.AbilityKit'
import { ReadAloudController, ReadAloudTask, ReadAloudListener } from '../common/ReadAloud'
import { ReadAloudEngine } from '../common/Tts'
import { AppSettings } from '../common/Settings'
import { dialogTransition } from '../common/Transitions'

// 原版 j8/p 朗读面板：
// 弹窗 min(4/5屏宽,450)×min(4/5屏高,600)；列表 + 底部 48dp 控制条
// 布局来源 r/f/k.xml（已解码）：空态 22sp、控制条 6 控件、语速滑条 max13
function panelWidthVp(): number {
  try {
    const d = display.getDefaultDisplaySync()
    const density = d.densityPixels
    if (density <= 0) {
      return 360
    }
    return Math.min((d.width / density) * 4 / 5, 450)
  } catch (error) {
    return 360
  }
}

function panelHeightVp(): number {
  try {
    const d = display.getDefaultDisplaySync()
    const density = d.densityPixels
    if (density <= 0) {
      return 480
    }
    return Math.min((d.height / density) * 4 / 5, 600)
  } catch (error) {
    return 480
  }
}

@Component
export struct ReadAloudPanel {
  private controller: ReadAloudController = ReadAloudController.getInstance()
  private settings: AppSettings = AppSettings.getInstance()
  private engine: ReadAloudEngine = ReadAloudEngine.getInstance()
  onClose: () => void = () => {
  }
  onSpeedChanged: (speed: number) => void = () => {
  }
  private listScroller: Scroller = new Scroller()
  // p.G0：当前任务 id
  @State taskId: string | null = null
  // p.E0：当前句索引
  @State current: number = -1
  // p.J0：倒退/快进暂挂索引
  private pendingIndex: number = -1
  // p.H0：自动滚动截止时间戳（-1 表示用户拖动后禁用）
  private autoScrollUntil: number = -1
  private stepTimer: number = -1
  @State sentences: string[] = []
  @State empty: boolean = true
  @State playing: boolean = false
  @State finished: boolean = true
  @State expanded: boolean = false
  @State sliderValue: number = 3
  @State speedText: string = '1.00x'
  private panelW: number = 360
  private panelH: number = 480
  private listener: ReadAloudListener = (task: ReadAloudTask) => {
    this.onTaskChanged(task)
  }

  aboutToAppear(): void {
    this.panelW = panelWidthVp()
    this.panelH = panelHeightVp()
    // 原版 X1：注册监听并初始化控制条
    this.controller.addListener(this.listener)
    // 朗读语速收敛 0.5x-2.0x：已存超界值显示 clamp 后的值
    const speed = Math.max(0.5, Math.min(2.0, this.settings.readAloudSpeed))
    this.sliderValue = Math.round((speed - 0.5) / 0.25)
    this.speedText = `${speed.toFixed(2)}x`
    this.refresh()
  }

  aboutToDisappear(): void {
    if (this.stepTimer >= 0) {
      clearTimeout(this.stepTimer)
      this.stepTimer = -1
    }
    this.controller.removeListener(this.listener)
  }

  // 原版 p.c（j8.d 监听器）
  private onTaskChanged(task: ReadAloudTask): void {
    if (this.taskId !== null && this.taskId === task.getId() && this.pendingIndex < 0) {
      this.moveToIndex(task.getIndex(), true)
    }
    this.playing = !task.isFinished() && task.playing()
    this.finished = task.isFinished()
  }

  // 原版 D3()：读取首个任务初始化面板
  private refresh(): void {
    const tasks = this.controller.getTasks()
    if (tasks.length === 0) {
      this.empty = true
      return
    }
    const task = tasks[0]
    this.playing = !task.isFinished() && task.playing()
    this.finished = task.isFinished()
    this.taskId = task.getId()
    this.sentences = task.getSentences().slice()
    this.current = task.getIndex()
    this.empty = this.sentences.length === 0
    if (!this.empty) {
      this.autoScrollUntil = Date.now() + 3000
    }
  }

  // 原版 L3(int, boolean)：更新当前句并按需滚动
  private moveToIndex(index: number, smooth: boolean): void {
    if (index === this.current) {
      return
    }
    this.current = index
    if (this.autoScrollUntil < 0 || Date.now() > this.autoScrollUntil) {
      return
    }
    if (index >= 0 && index < this.sentences.length) {
      this.listScroller.scrollToIndex(index, smooth)
    }
  }

  // 原版 G3(boolean)：播放/暂停（z10=true 来自设置入口，仅暂停）
  private togglePlay(pauseOnly: boolean): void {
    const id = this.taskId
    if (id === null) {
      return
    }
    const task = this.controller.findTask(id)
    if (task === null) {
      return
    }
    if (task.playing()) {
      this.controller.commandPause(id)
    } else {
      if (pauseOnly) {
        return
      }
      if (task.isFinished()) {
        task.setIndex(0)
      }
      this.controller.commandPlay(id)
    }
  }

  // 原版 K3(int)：跳到指定句播放
  private playAt(index: number): void {
    const id = this.taskId
    if (id === null || id === '') {
      return
    }
    this.controller.commandPlayAtIndex(id, index)
  }

  // 原版 J3()：倒退
  private rewind(): void {
    if (this.pendingIndex < 0) {
      this.pendingIndex = this.current
    }
    this.pendingIndex = Math.max(0, this.pendingIndex - 1)
    this.moveToIndex(this.pendingIndex, true)
    this.scheduleApplyPending()
  }

  // 原版 I3()：快进
  private forward(): void {
    if (this.pendingIndex < 0) {
      this.pendingIndex = this.current
    }
    this.pendingIndex = this.pendingIndex + 1
    this.moveToIndex(this.pendingIndex, true)
    this.scheduleApplyPending()
  }

  private scheduleApplyPending(): void {
    if (this.stepTimer >= 0) {
      clearTimeout(this.stepTimer)
    }
    this.stepTimer = setTimeout(() => {
      this.stepTimer = -1
      // 原版 H3()：应用暂挂索引
      if (this.pendingIndex < 0) {
        return
      }
      this.autoScrollUntil = 0
      const clamped = Math.max(0, Math.min(this.sentences.length - 1, this.pendingIndex))
      this.pendingIndex = -1
      this.playAt(clamped)
    }, 300)
  }

  // 原版 n3()：暂停朗读（G3(true)）+ f1.e() 构造 com.android.settings.TTS_SETTINGS intent 跳系统 TTS 设置，
  // 失败 Snackbar「操作失败」（string zl）。鸿蒙端无文档化的 TTS 设置页 Want（docs 已核实），
  // 对应跳转系统设置应用（com.huawei.hmos.settings/MainAbility），拉起失败设备弹「操作失败」
  private openTtsSettings(): void {
    this.togglePlay(true)
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    if (context === undefined) {
      this.showOperationFailedToast()
      return
    }
    const want: Want = {
      bundleName: 'com.huawei.hmos.settings',
      abilityName: 'com.huawei.hmos.settings.MainAbility'
    }
    context.startAbility(want).catch(() => {
      this.showOperationFailedToast()
    })
  }

  private showOperationFailedToast(): void {
    this.getUIContext().getPromptAction().showToast({
      message: $r('app.string.read_aloud_operation_failed'),
      duration: 1500
    })
  }

  // 原版 l3()：展开/收起语速滑条
  private toggleSpeedBar(): void {
    this.expanded = !this.expanded
  }

  private onSliderChange(value: number): void {
    const speed = 0.5 + value * 0.25
    this.speedText = `${speed.toFixed(2)}x`
  }

  // 原版 SeekBar.onStopTrackingTouch
  private onSliderDone(value: number): void {
    const speed = 0.5 + value * 0.25
    this.settings.setReadAloudSpeed(speed)
    this.engine.setSpeed(speed)
    this.onSpeedChanged(speed)
    const id = this.taskId
    if (id === null) {
      return
    }
    const task = this.controller.findTask(id)
    if (task === null || !task.playing()) {
      return
    }
    this.playAt(this.current)
  }

  private copySentence(sentence: string): void {
    const data = pasteboard.createData(pasteboard.MIMETYPE_TEXT_PLAIN, sentence)
    pasteboard.getSystemPasteboard().setData(data)
    this.getUIContext().getPromptAction().showToast({
      message: $r('app.string.read_aloud_copy_done'),
      duration: 1500
    })
  }

  build() {
    // 遮罩：点击面板外关闭（原版 k8.a 可取消弹窗）
    Column() {
      // 弹窗卡片（原版 p.T1：min(4/5W,450)×min(4/5H,600)，dialog 底色）
      Column() {
        if (this.empty) {
          // 原版布局 ey：空态 22sp 居中（ad #8a000000/#99ffffff）
          Text($r('app.string.read_aloud_empty'))
            .fontSize(22)
            .fontColor($r('app.color.dialog_hint'))
            .textAlign(TextAlign.Center)
            .width('100%')
            .layoutWeight(1)
        } else {
          // 原版布局 di(C0)：句子列表，上下 16dp padding（clipToPadding），底部 48dp 控制条
          List({ scroller: this.listScroller }) {
            ForEach(this.sentences, (sentence: string, index: number) => {
              ListItem() {
                Text(sentence)
                  .fontSize(16)
                  .lineHeight(24)
                  .fontColor(index === this.current ? $r('app.color.accent') : $r('app.color.fg'))
                  .fontWeight(index === this.current ? FontWeight.Bold : FontWeight.Normal)
                  .padding({ left: 16, right: 16, top: 8, bottom: 8 })
                  .width('100%')
                  .onClick(() => {
                    // 原版 y5.g：点击句子 → K3(i10)
                    this.playAt(index)
                  })
                  .gesture(
                    LongPressGesture()
                      .onAction(() => {
                        // 原版 p.p3：长按复制 + 提示「已复制文本」
                        this.copySentence(sentence)
                      })
                  )
              }
            }, (sentence: string, index: number) => `${index}-${sentence.length}`)
          }
          .width('100%')
          .layoutWeight(1)
          .padding({ top: 16, bottom: 16 })
          .clip(true)
          .scrollBar(BarState.Off)
          .edgeEffect(EdgeEffect.None)
          .onScrollStart(() => {
            // 原版 p.b：拖动 → H0=-1 禁用自动滚动
            this.autoScrollUntil = -1
          })
          .onScrollStop(() => {
            this.autoScrollUntil = Date.now() + 3000
          })
        }
        // 原版布局 cv(o0)：底部 48dp 控制条
        if (!this.empty) {
          Row() {
            if (!this.expanded) {
              // ck(f13802f0)：设置（di 图标，13dp padding，a9 tint）
              Image($r('app.media.uia_readaloud_settings'))
                .height(48)
                .layoutWeight(1)
                .padding(13)
                .objectFit(ImageFit.Contain)
                .fillColor($r('app.color.search_toolbar_text'))
                .onClick(() => {
                  this.openTtsSettings()
                })
              // cg(f13793c0)：倒退（cw 旋转 180°）
              Image($r('app.media.uia_readaloud_play'))
                .height(48)
                .layoutWeight(1)
                .padding(13)
                .objectFit(ImageFit.Contain)
                .fillColor($r('app.color.search_toolbar_text'))
                .rotate({ angle: 180 })
                .onClick(() => {
                  this.rewind()
                })
              // cd(Z)：播放/暂停
              Image(this.playing ? $r('app.media.uia_readaloud_pause') : $r('app.media.uia_readaloud_play'))
                .height(48)
                .layoutWeight(1)
                .padding(13)
                .objectFit(ImageFit.Contain)
                .fillColor($r('app.color.search_toolbar_text'))
                .onClick(() => {
                  this.togglePlay(false)
                })
              // c3(O)：快进
              Image($r('app.media.uia_readaloud_forward'))
                .height(48)
                .layoutWeight(1)
                .padding(13)
                .objectFit(ImageFit.Contain)
                .fillColor($r('app.color.search_toolbar_text'))
                .onClick(() => {
                  this.forward()
                })
            } else {
              // dk(E0)：语速滑条（0.5x-2.0x，步长 0.25，索引 0-6）
              Slider({ value: this.sliderValue, min: 0, max: 6, step: 1, style: SliderStyle.OutSet })
                .layoutWeight(4)
                .height(48)
                .onChange((value: number, mode: SliderChangeMode) => {
                  if (mode === SliderChangeMode.Moving || mode === SliderChangeMode.Click) {
                    this.sliderValue = value
                    this.onSliderChange(value)
                  }
                  if (mode === SliderChangeMode.End) {
                    this.sliderValue = value
                    this.onSliderDone(value)
                  }
                })
            }
            // ff(C1)：语速标签（展开时加粗 accent）
            Text(this.speedText)
              .fontSize(14)
              .textAlign(TextAlign.Center)
              .fontColor(this.expanded ? $r('app.color.accent') : $r('app.color.search_toolbar_icon_tint'))
              .fontWeight(this.expanded ? FontWeight.Bold : FontWeight.Normal)
              .layoutWeight(1)
              .height(48)
              .onClick(() => {
                this.toggleSpeedBar()
              })
          }
          .width('100%')
          .height(48)
        }
      }
      .width(this.panelW)
      .height(this.panelH)
      .backgroundColor($r('app.color.dialog_bg'))
      .borderRadius(18)
      .border({ width: 1, color: $r('app.color.dialog_border') })
      .clip(true)
      .transition(dialogTransition())
      .onClick(() => {
      })
    }
    .width('100%')
    .height('100%')
    .backgroundColor('#66000000')
    .onClick(() => {
      this.onClose()
    })
    .justifyContent(FlexAlign.Center)
    .alignItems(HorizontalAlign.Center)
  }
}
