import { common } from '@kit.AbilityKit'
import { wantAgent, WantAgent } from '@kit.AbilityKit'
import { BusinessError, commonEventManager } from '@kit.BasicServicesKit'
import { notificationManager } from '@kit.NotificationKit'
import { backgroundTaskManager } from '@kit.BackgroundTasksKit'
import { audio } from '@kit.AudioKit'
import { hostOf } from './SearchEngines'
import { ReadAloudEngine } from './Tts'

// ===== 原版 j8/t：朗读任务 =====
export class ReadAloudTask {
  readonly taskId: string
  readonly url: string
  readonly title: string
  readonly sentences: string[]
  currentIndex: number
  isPlaying: boolean

  constructor(taskId: string, url: string, title: string, sentences: string[], currentIndex: number) {
    this.taskId = taskId
    this.url = url
    this.title = title
    this.sentences = sentences
    this.currentIndex = currentIndex
    this.isPlaying = false
  }

  // t.a()
  getIndex(): number {
    return this.currentIndex
  }

  // t.b()
  getId(): string {
    return this.taskId
  }

  // t.c(int)：越界返回 null
  sentenceAt(index: number): string | null {
    if (index < 0 || index >= this.sentences.length) {
      return null
    }
    return this.sentences[index]
  }

  // t.d()
  getSentences(): string[] {
    return this.sentences
  }

  // t.e()
  getTitle(): string {
    return this.title
  }

  // t.f()
  getUrl(): string {
    return this.url
  }

  // t.g()：当前索引越界即已读完
  isFinished(): boolean {
    return this.currentIndex < 0 || this.currentIndex >= this.sentences.length
  }

  // t.h()
  playing(): boolean {
    return this.isPlaying
  }

  // t.i(int)
  setIndex(index: number): void {
    this.currentIndex = index
  }

  // t.j(boolean)
  setPlaying(playing: boolean): void {
    this.isPlaying = playing
  }
}

// ===== 原版 j8/d：监听器（任务变化回调）=====
export type ReadAloudListener = (task: ReadAloudTask) => void

// ===== 原版 j8/u：句子切分 =====
// u.c()：康熙部首（U+2F00-U+2FD5）→ 对应 CJK 部首字
const KANGXI_CJK: string = '\u4e00\u4e28\u4e36\u4e3f\u4e59\u4e85\u4e8c\u4ea0\u4eba\u513f\u5165\u516b\u5182\u5196\u51ab\u51e0\u51f5\u5200\u529b\u52f9\u5315\u531a\u5338\u5341\u535c\u5369\u5382\u53b6\u53c8\u53e3\u53e3\u571f\u58eb\u5902\u590a\u5915\u5927\u5973\u5b50\u5b80\u5bf8\u5c0f\u5c22\u5c38\u5c6e\u5c71\u5ddb\u5de5\u5df1\u5dfe\u5e72\u5e7a\u5e7f\u5ef4\u5efe\u5f0b\u5f13\u5f50\u5f61\u5f73\u5fc3\u6208\u6237\u624b\u652f\u6534\u6587\u6597\u65a4\u65b9\u65e0\u65e5\u66f0\u6708\u6728\u6b20\u6b62\u6b79\u6bb3\u6bcb\u6bd4\u6bdb\u6c0f\u6c14\u6c34\u706b\u722a\u7236\u723b\u723f\u7247\u7259\u725b\u72ac\u7384\u7389\u74dc\u74e6\u7518\u751f\u7528\u7530\u758b\u7592\u7676\u767d\u76ae\u76bf\u76ee\u77db\u77e2\u77f3\u793a\u79b8\u79be\u7a74\u7acb\u7af9\u7c73\u7cf8\u7f36\u7f51\u7f8a\u7fbd\u8001\u800c\u8012\u8033\u807f\u8089\u81e3\u81ea\u81f3\u81fc\u820c\u821b\u821f\u826e\u8272\u8278\u864d\u866b\u8840\u884c\u8863\u897e\u898b\u89d2\u8a00\u8c37\u8c46\u8c55\u8c78\u8c9d\u8d64\u8d70\u8db3\u8eab\u8eca\u8f9b\u8fb0\u8fb5\u9091\u9149\u91c7\u91cc\u91d1\u9577\u9580\u961c\u96b6\u96b9\u96e8\u9752\u975e\u9762\u9769\u97cb\u97ed\u97f3\u9801\u98a8\u98db\u98df\u9996\u9999\u99ac\u9aa8\u9ad8\u9adf\u9b25\u9b2f\u9b32\u9b3c\u9b5a\u9ce5\u9e75\u9e7f\u9ea5\u9ebb\u9ec3\u9ecd\u9ed1\u9ef9\u9efd\u9f0e\u9f13\u9f20\u9f3b\u9f4a\u9f52\u9f8d\u9f9c\u9fa0'

let kangxiMap: Map<number, number> | null = null

function getKangxiMap(): Map<number, number> {
  if (kangxiMap === null) {
    kangxiMap = new Map<number, number>()
    for (let i = 0; i < 214; i++) {
      kangxiMap.set(0x2f00 + i, KANGXI_CJK.charCodeAt(i))
    }
  }
  return kangxiMap
}

// u.c(str)
function normalizeKangxi(str: string): string {
  const map = getKangxiMap()
  let sb = ''
  let anchor = -1
  for (let i = 0; i < str.length; i++) {
    const mapped = map.get(str.charCodeAt(i))
    if (mapped !== undefined) {
      if (anchor < 0) {
        anchor = 0
        sb = ''
      }
      sb += str.substring(anchor, i)
      sb += String.fromCharCode(mapped)
      anchor = i + 1
    }
  }
  if (anchor > 0) {
    sb += str.substring(anchor)
    return sb
  }
  return str
}

// u.b(str)：长文本按首个命中的标点切分
function splitLongText(str: string): string[] {
  const out: string[] = []
  if (str === '') {
    return out
  }
  const delims: string[] =
    ['\u201d', '\u300d', '\u3002', '\uff0c', '\uff1b', '\uff1f', '\uff01', '. ', ', ', '; ', '? ', '! ', '} ', ' ', '.']
  let delim: string | null = null
  let delimLen = 0
  for (let i = 0; i < 15; i++) {
    if (str.includes(delims[i])) {
      delim = delims[i]
      delimLen = delims[i].length
      break
    }
  }
  const len = str.length
  let start = 0
  if (delim === null) {
    while (start < len) {
      const seg = str.substring(start, Math.min(start + 256, len))
      start += seg.length
      out.push(seg.trim())
    }
    return out
  }
  let anchor = 0
  while (start < len) {
    const idx = str.indexOf(delim, start)
    if (idx < 0) {
      while (start < len) {
        const seg = str.substring(anchor, Math.min(anchor + 256, len))
        anchor += seg.length
        out.push(seg.trim())
        start = anchor
      }
    } else {
      const rel = idx - anchor
      if (rel >= 256) {
        start = anchor + 256
        out.push(str.substring(anchor, start).trim())
      } else if (rel >= 64) {
        start = idx + delimLen
        out.push(str.substring(anchor, start).trim())
      } else {
        start = idx + delimLen
      }
      anchor = start
    }
  }
  return out
}

// u.a(str)：JSON 数组 → 句子列表
export function sentencesFromJson(json: string | null): string[] {
  if (json === null || json.length < 2 || json === '[]') {
    return []
  }
  try {
    const cleaned = normalizeKangxi(json.split('\u200b').join(''))
    const arr = JSON.parse(cleaned) as object as string[]
    const out: string[] = []
    for (let i = 0; i < arr.length; i++) {
      const trimmed = `${arr[i]}`.trim()
      if (trimmed !== '') {
        if (trimmed.length < 256) {
          out.push(trimmed)
        } else {
          const parts = splitLongText(trimmed)
          for (let j = 0; j < parts.length; j++) {
            out.push(parts[j])
          }
        }
      }
    }
    return out
  } catch (error) {
    return []
  }
}

// ===== 原版 i6/g0.b：通知文本 = host 去掉 m./www. 前缀 =====
export function hostWithoutPrefix(url: string): string {
  const host = hostOf(url)
  if (host.length >= 2) {
    const firstDot = host.indexOf('.')
    if (firstDot === 1 && host.charAt(0) === 'm' && host.indexOf('.', firstDot + 1) !== -1) {
      return host.substring(2)
    }
    if (firstDot === 3 && host.startsWith('www') && host.indexOf('.', firstDot + 1) !== -1) {
      return host.substring(4)
    }
  }
  return host
}

// ===== 原版 j8/s + ReadAloudService：通知、连续任务、公共事件 =====
const NOTIFICATION_ID: number = 2
const EVENT_PLAY: string = 'via.readaloud.PLAY'
const EVENT_PAUSE: string = 'via.readaloud.PAUSE'
const EVENT_STOP: string = 'via.readaloud.STOP'

export class ReadAloudService {
  private static instance: ReadAloudService | null = null
  private context: common.UIAbilityContext | null = null
  private subscriber: commonEventManager.CommonEventSubscriber | null = null
  private continuousTaskRunning: boolean = false
  private routingManager: audio.AudioRoutingManager | null = null
  private deviceChangeCallback: ((action: audio.DeviceChangeAction) => void) | null = null

  static getInstance(): ReadAloudService {
    if (ReadAloudService.instance === null) {
      ReadAloudService.instance = new ReadAloudService()
    }
    return ReadAloudService.instance
  }

  // 绑定上下文并订阅通知按钮公共事件（原版 ReadAloudReceiver）
  init(context: common.UIAbilityContext, onAction: (action: string, mark: string) => void): void {
    this.context = context
    if (this.subscriber !== null) {
      return
    }
    const info: commonEventManager.CommonEventSubscribeInfo = {
      events: [EVENT_PLAY, EVENT_PAUSE, EVENT_STOP]
    }
    commonEventManager.createSubscriber(info).then((subscriber: commonEventManager.CommonEventSubscriber) => {
      this.subscriber = subscriber
      commonEventManager.subscribe(subscriber, (err, data) => {
        if (err !== null) {
          return
        }
        if (data === undefined || data.event === undefined) {
          return
        }
        const params = data.parameters as Record<string, Object>
        let mark = ''
        if (params !== undefined && params !== null) {
          const m = params['mark']
          if (typeof m === 'string') {
            mark = m
          }
        }
        onAction(data.event, mark)
      })
    }).catch((error: BusinessError) => {
      console.error(`readaloud subscribe failed: ${error.code}`)
    })
  }

  // 音频输出设备拔出 → 自动暂停（原版 ReadAloudService.a）
  registerAudioDeviceCallback(onRemoved: () => void): void {
    if (this.routingManager !== null) {
      return
    }
    try {
      this.routingManager = audio.getAudioManager().getRoutingManager()
      this.deviceChangeCallback = (action: audio.DeviceChangeAction) => {
        if (action.type === audio.DeviceChangeType.DISCONNECT) {
          onRemoved()
        }
      }
      this.routingManager.on('deviceChange', audio.DeviceFlag.OUTPUT_DEVICES_FLAG, this.deviceChangeCallback)
    } catch (error) {
      console.error('readaloud register audio device callback failed')
    }
  }

  // 长时任务（原版 startForeground 服务的后台保活等价物）
  startContinuousTask(): void {
    const context = this.context
    if (context === null || this.continuousTaskRunning) {
      return
    }
    const wantAgentInfo: wantAgent.WantAgentInfo = {
      wants: [
        {
          bundleName: context.abilityInfo.bundleName,
          abilityName: 'EntryAbility'
        }
      ],
      actionType: wantAgent.OperationType.START_ABILITY,
      requestCode: 0
    }
    wantAgent.getWantAgent(wantAgentInfo).then((agent: WantAgent) => {
      backgroundTaskManager.startBackgroundRunning(context, backgroundTaskManager.BackgroundMode.AUDIO_PLAYBACK, agent)
        .then(() => {
          this.continuousTaskRunning = true
        }).catch((error: BusinessError) => {
          console.error(`readaloud start continuous task failed: ${error.code}`)
        })
    }).catch((error: BusinessError) => {
      console.error(`readaloud get wantagent failed: ${error.code}`)
    })
  }

  stopContinuousTask(): void {
    const context = this.context
    if (context === null || !this.continuousTaskRunning) {
      return
    }
    backgroundTaskManager.stopBackgroundRunning(context).then(() => {
      this.continuousTaskRunning = false
    }).catch((error: BusinessError) => {
      console.error(`readaloud stop continuous task failed: ${error.code}`)
    })
  }

  // 原版 j8/s.c(t)：更新朗读通知
  publishNotification(task: ReadAloudTask | null): void {
    const context = this.context
    if (context === null) {
      return
    }
    notificationManager.isNotificationEnabled().then((enabled: boolean) => {
      if (enabled) {
        this.doPublish(task)
        return
      }
      notificationManager.requestEnableNotification(context).then(() => {
        this.doPublish(task)
      }).catch(() => {
      })
    }).catch(() => {
    })
  }

  private doPublish(task: ReadAloudTask | null): void {
    const context = this.context
    if (context === null) {
      return
    }
    const playing = task !== null && task.playing()
    const title = task !== null ? task.getTitle() : ''
    const text = task !== null ? hostWithoutPrefix(task.getUrl()) : ''
    const wantAgentInfo: wantAgent.WantAgentInfo = {
      wants: [
        {
          bundleName: context.abilityInfo.bundleName,
          abilityName: 'EntryAbility'
        }
      ],
      actionType: wantAgent.OperationType.START_ABILITY,
      requestCode: 0
    }
    wantAgent.getWantAgent(wantAgentInfo).then((contentAgent: WantAgent) => {
      const eventName = playing ? EVENT_PAUSE : EVENT_PLAY
      const mark = task !== null ? task.getId() : ''
      const btnInfo: wantAgent.WantAgentInfo = {
        wants: [
          {
            action: eventName,
            parameters: { 'mark': mark } as Record<string, Object>
          }
        ],
        actionType: wantAgent.OperationType.SEND_COMMON_EVENT,
        requestCode: 0
      }
      wantAgent.getWantAgent(btnInfo).then((btnAgent: WantAgent) => {
        const request: notificationManager.NotificationRequest = {
          id: NOTIFICATION_ID,
          notificationSlotType: notificationManager.SlotType.SERVICE_INFORMATION,
          content: {
            notificationContentType: notificationManager.ContentType.NOTIFICATION_CONTENT_BASIC_TEXT,
            normal: {
              title: title,
              text: text
            }
          },
          wantAgent: contentAgent,
          actionButtons: [
            {
              title: playing ? '暂停' : '恢复',
              wantAgent: btnAgent
            } as notificationManager.NotificationActionButton
          ]
        }
        notificationManager.publish(request).catch((error: BusinessError) => {
          console.error(`readaloud publish notification failed: ${error.code}`)
        })
      })
    }).catch((error: BusinessError) => {
      console.error(`readaloud notification wantagent failed: ${error.code}`)
    })
  }

  // 原版 service 停止：取消通知
  cancelNotification(): void {
    notificationManager.cancel(NOTIFICATION_ID).catch(() => {
    })
  }
}

// ===== 原版 j8/c：朗读控制器 =====
export class ReadAloudController {
  private static instance: ReadAloudController | null = null
  private engine: ReadAloudEngine = ReadAloudEngine.getInstance()
  private service: ReadAloudService = ReadAloudService.getInstance()
  private tasks: ReadAloudTask[] = []
  private listeners: ReadAloudListener[] | null = null

  static getInstance(): ReadAloudController {
    if (ReadAloudController.instance === null) {
      ReadAloudController.instance = new ReadAloudController()
    }
    return ReadAloudController.instance
  }

  private constructor() {
  }

  // 初始化服务层（原版 va() 中的一次性 init）
  initService(context: common.UIAbilityContext): void {
    this.service.init(context, (action: string, mark: string) => {
      this.handleServiceAction(action, mark)
    })
    this.service.registerAudioDeviceCallback(() => {
      // 原版 ReadAloudService.a：音频设备拔出 → e.a(null) 暂停
      this.pause(null)
    })
  }

  private handleServiceAction(action: string, mark: string): void {
    if (action === EVENT_PLAY) {
      this.commandPlay(mark)
    } else if (action === EVENT_PAUSE) {
      this.commandPause(mark)
    } else if (action === EVENT_STOP) {
      this.commandStop()
    }
  }

  // c.a()：任务列表
  getTasks(): ReadAloudTask[] {
    return this.tasks.slice()
  }

  // c.b(d)
  addListener(listener: ReadAloudListener): void {
    if (this.listeners === null) {
      this.listeners = []
    }
    this.listeners.push(listener)
  }

  // c.d(d)
  removeListener(listener: ReadAloudListener): void {
    const list = this.listeners
    if (list === null) {
      return
    }
    const idx = list.indexOf(listener)
    if (idx >= 0) {
      list.splice(idx, 1)
    }
    if (list.length === 0) {
      this.listeners = null
    }
  }

  // c.c()：停止并清空全部任务
  clearAll(): boolean {
    if (this.tasks.length === 0) {
      return true
    }
    this.engine.stop()
    this.tasks = []
    this.service.cancelNotification()
    this.service.stopContinuousTask()
    return true
  }

  // c.e()
  firstTask(): ReadAloudTask | null {
    if (this.tasks.length === 0) {
      return null
    }
    return this.tasks[0]
  }

  // c.f(str)
  findTask(taskId: string): ReadAloudTask | null {
    const idx = this.indexOf(taskId)
    if (idx >= 0) {
      return this.tasks[idx]
    }
    return null
  }

  // c.g()
  getEngine(): ReadAloudEngine {
    return this.engine
  }

  // c.h(str)：暂停；返回是否有任务在播
  pause(taskId: string | null): boolean {
    if (taskId !== null) {
      const task = this.findTask(taskId)
      if (task !== null && !task.playing()) {
        return false
      }
    }
    this.engine.stop()
    let paused = false
    for (const task of this.tasks) {
      if (task.playing()) {
        task.setPlaying(false)
        if (!paused) {
          this.notifyListeners(task)
          paused = true
        }
      }
    }
    const current = this.firstTask()
    if (current !== null) {
      this.service.publishNotification(current)
    }
    if (paused) {
      // 原版 ReadAloudService PAUSE → h(mark) 暂停成功后 f(false)：
      // stopForeground(KEEP) + stopSelf（停长时任务，通知保留为非播放态）
      this.service.stopContinuousTask()
    }
    return paused
  }

  // c.i(t)：提交任务；返回任务 id
  submit(task: ReadAloudTask): string | null {
    if (task.getId() === '') {
      return null
    }
    const idx = this.indexOf(task.getId())
    if (idx > 0) {
      this.tasks[idx] = task
    } else {
      this.tasks = [task]
    }
    return task.getId()
  }

  // c.j(str)：播放指定任务
  play(taskId: string): boolean {
    const task = this.findTask(taskId)
    if (task === null || task.isFinished()) {
      this.pause(null)
      return false
    }
    for (const other of this.tasks) {
      other.setPlaying(false)
    }
    this.playCurrent(task)
    return true
  }

  // c.k/c.p：播当前句，完成回调 index+1 再播下一句；读完（c()=null）置非播放并通知，
  // 原版 ReadAloudService.g(t)：更新通知为非播放态，任务读完 → f(true) 停服务
  // （stopForeground 移除通知 + 停长时任务）
  private playCurrent(task: ReadAloudTask): void {
    const text = task.sentenceAt(task.getIndex())
    if (text === null) {
      // c.p：strC==null → setPlaying(false)，不触发完成回调（禁止递归）
      task.setPlaying(false)
      this.notifyListeners(task)
      // ReadAloudService.g → s.c(t) 通知更新为非播放态 → f(true)：移除通知 + 停长时任务
      this.service.publishNotification(task)
      this.service.cancelNotification()
      this.service.stopContinuousTask()
      return
    }
    task.setPlaying(this.engine.speak(text, () => {
      task.setIndex(task.getIndex() + 1)
      this.playCurrent(task)
    }))
    this.notifyListeners(task)
  }

  // c.m(t)：通知监听器
  private notifyListeners(task: ReadAloudTask): void {
    const list = this.listeners
    if (list === null) {
      return
    }
    for (const listener of list) {
      listener(task)
    }
  }

  // c.o(str)
  private indexOf(taskId: string): number {
    if (taskId !== '') {
      for (let i = 0; i < this.tasks.length; i++) {
        if (taskId === this.tasks[i].getId()) {
          return i
        }
      }
    }
    return -1
  }

  // ===== 原版 j8/e 命令（经 ReadAloudService 意图分发）=====

  // e.a(str)：暂停
  commandPause(taskId: string | null): void {
    this.pause(taskId)
  }

  // e.b(str)：播放
  commandPlay(taskId: string | null): void {
    if (taskId === null || taskId === '') {
      return
    }
    const task = this.findTask(taskId)
    if (task === null) {
      return
    }
    if (task.isFinished()) {
      task.setIndex(0)
    }
    if (!task.isFinished() && this.play(task.getId())) {
      this.service.publishNotification(task)
      this.service.startContinuousTask()
    }
  }

  // e.c(str, int)：从指定句播放
  commandPlayAtIndex(taskId: string, index: number): void {
    if (taskId === '') {
      return
    }
    const task = this.findTask(taskId)
    if (task === null) {
      return
    }
    task.setIndex(index)
    this.commandPlay(taskId)
  }

  // e.d()：停止全部
  commandStop(): void {
    this.clearAll()
  }

  stopAll(): void {
    this.clearAll()
  }
}
