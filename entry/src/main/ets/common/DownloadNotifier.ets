import { notificationManager } from '@kit.NotificationKit'
import { wantAgent, WantAgent, common } from '@kit.AbilityKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { DownloadRec } from './Types'

// ===== 原版 mark/via/download/d.java 通知栏 1:1 移植 =====
// 状态码判定（g5.b，避免与 DownloadEngine 循环依赖，此处按原版复制）
export const DL_STATE_PAUSED: number = 80
export const DL_STATE_WAIT_NET: number = 95

function stateIsCompleted(state: number): boolean {
  return state >= 100 && state < 200
}

function stateIsFailed(state: number): boolean {
  return state >= 200 && state < 300
}

function stateIsPaused(state: number): boolean {
  return state === DL_STATE_PAUSED
}

function stateIsWaiting(state: number): boolean {
  return state === DL_STATE_WAIT_NET
}

function stateIsActive(state: number): boolean {
  return state > 0 && state < 100 && !stateIsPaused(state)
}

// 通知按钮公共事件（原版 DownloadReceiver PAUSE/RESUME）
export const DL_ACTION_PAUSE: string = 'via.download.action.pause'
export const DL_ACTION_RESUME: string = 'via.download.action.resume'

// z8.b0.w()：字节数格式化（B/KB/MB/GB，%.1f）
export function dlSizeText(bytes: number): string {
  let value = bytes
  let unit = 'B'
  if (value >= 858993459.2) {
    value = value / 1024 / 1024 / 1024
    unit = 'GB'
  } else if (value >= 838860.8) {
    value = value / 1024 / 1024
    unit = 'MB'
  } else if (value >= 819.2) {
    value = value / 1024
    unit = 'KB'
  }
  return `${value.toFixed(1)} ${unit}`
}

// DownloadTaskViewDelegate.r()：剩余时间（秒→分→时，超界 "-"）
export function dlRemainingText(rec: DownloadRec): ResourceStr {
  if (rec.size <= 0 || rec.speed <= 0) {
    return '-'
  }
  const secs = Math.trunc((rec.size - rec.received) / rec.speed)
  if (secs <= 60) {
    return $r('app.string.time_secs_left', secs)
  }
  const mins = Math.trunc(secs / 60)
  if (mins <= 120) {
    return $r('app.string.time_mins_left', mins)
  }
  const hours = Math.trunc(mins / 60)
  if (hours <= 12) {
    return $r('app.string.time_hours_left', hours)
  }
  return '-'
}

// DownloadTaskViewDelegate.B()：条目标题（文件名为空回退 URL）
export function dlTitleOf(rec: DownloadRec): string {
  const name = baseNameOf(rec.path)
  return name !== '' ? name : rec.url
}

export function baseNameOf(path: string): string {
  const index = path.lastIndexOf('/')
  if (index >= 0 && index < path.length - 1) {
    return path.substring(index + 1)
  }
  return path
}

// DownloadTaskViewDelegate.A()：条目状态行 1:1
export function dlStatusText(rec: DownloadRec): ResourceStr {
  const state = rec.state
  if (!stateIsActive(state) && !stateIsPaused(state)) {
    if (stateIsCompleted(state)) {
      return dlSizeText(Math.max(rec.received, rec.size))
    }
    if (stateIsFailed(state)) {
      return rec.errorMessage !== '' ?
        $r('app.string.download_failed_detail', rec.errorMessage) : $r('app.string.download_failed')
    }
    return ''
  }
  const base = rec.size <= 0 ?
    $r('app.string.size_only', dlSizeText(rec.received)) :
    $r('app.string.size_progress', dlSizeText(rec.received), dlSizeText(rec.size))
  if (stateIsPaused(state)) {
    return $r('app.string.pair_text', base, $r('app.string.download_paused'))
  }
  if (stateIsWaiting(state)) {
    return $r('app.string.pair_text', base, $r('app.string.waiting_for_network'))
  }
  const speed = rec.speed < 0 ? $r('app.string.na_text') : `${dlSizeText(rec.speed)}/s`
  if (rec.size > 0) {
    return $r('app.string.triple_text', base, speed, dlRemainingText(rec))
  }
  return $r('app.string.pair_text', base, speed)
}

// d.f()：节流分类（1 完成 / 2 失败 / 3 等待网络 / 4 下载中 / 5 已暂停 / 0 其它）
export function dlCategoryOfState(state: number): number {
  if (stateIsCompleted(state)) {
    return 1
  }
  if (stateIsFailed(state)) {
    return 2
  }
  if (stateIsWaiting(state)) {
    return 3
  }
  if (stateIsActive(state)) {
    return 4
  }
  return stateIsPaused(state) ? 5 : 0
}

interface NotifyThrottle {
  category: number
  time: number
}

export class DownloadNotifier {
  private static instance: DownloadNotifier | null = null
  private throttle: Map<number, NotifyThrottle> = new Map<number, NotifyThrottle>()
  private appContext: common.Context | null = null
  private templateSupported: boolean = false
  private enabled: boolean = false

  static getInstance(): DownloadNotifier {
    if (DownloadNotifier.instance === null) {
      DownloadNotifier.instance = new DownloadNotifier()
    }
    return DownloadNotifier.instance
  }

  // 原版 d.g()：启动时创建通知渠道；鸿蒙等效为申请通知授权 + 查询模板支持
  init(context: common.Context): void {
    if (this.appContext !== null) {
      return
    }
    this.appContext = context
    notificationManager.isNotificationEnabled().then((enabled: boolean) => {
      if (enabled) {
        this.enabled = true
        this.checkTemplate()
        return
      }
      notificationManager.requestEnableNotification(context as common.UIAbilityContext).then(() => {
        this.enabled = true
        this.checkTemplate()
      }).catch((error: BusinessError) => {
        console.error(`request notification enable failed: ${error.message}`)
      })
    }).catch((error: BusinessError) => {
      console.error(`isNotificationEnabled failed: ${error.message}`)
    })
  }

  private checkTemplate(): void {
    notificationManager.isSupportTemplate('downloadTemplate').then((supported: boolean) => {
      this.templateSupported = supported
    }).catch(() => {
      this.templateSupported = false
    })
  }

  // d.b(j10)：取消通知
  cancel(id: number): void {
    notificationManager.cancel(id).catch((error: BusinessError) => {
      console.error(`cancel download notification failed: ${error.message}`)
    })
    this.throttle.delete(id)
  }

  // d.h(cVar)：发布/刷新下载通知（1s 节流，分类变化立即刷新）
  notify(rec: DownloadRec): void {
    if (this.appContext === null || !this.enabled) {
      return
    }
    const category = dlCategoryOfState(rec.state)
    const now = Date.now()
    const last = this.throttle.get(rec.id)
    if (last !== undefined && last.category === category && now - last.time < 1000) {
      return
    }
    this.throttle.set(rec.id, { category: category, time: now })
    this.publish(rec).catch((error: BusinessError) => {
      console.error(`publish download notification failed: ${error.message}`)
    })
  }

  // 通知文本只接受 string：ResourceStr → 运行时解析
  private rs(res: ResourceStr): string {
    const context = this.appContext
    if (typeof res === 'string' || context === null) {
      return res as string
    }
    return context.resourceManager.getStringSync(res)
  }

  private async publish(rec: DownloadRec): Promise<void> {
    const context = this.appContext
    if (context === null) {
      return
    }
    const completed = stateIsCompleted(rec.state)
    const failed = stateIsFailed(rec.state)
    const waiting = stateIsWaiting(rec.state)
    const paused = stateIsPaused(rec.state)
    const active = stateIsActive(rec.state)
    const title = dlTitleOf(rec)
    // d：文本组装
    let text: ResourceStr
    if (completed) {
      // mark/via/download/d.java:223 P3：完成通知文本仅「下载完成」（文件名在标题）
      text = $r('app.string.download_finished')
    } else if (failed) {
      text = rec.errorMessage !== '' ?
        $r('app.string.download_failed_detail', rec.errorMessage) : $r('app.string.download_failed')
    } else {
      // 未知大小（无 content-length）：文本进度「已下载 xx」+「大小未知」
      const base = rec.size <= 0 ?
        $r('app.string.pair_text', $r('app.string.downloaded_size', dlSizeText(rec.received)),
          $r('app.string.download_size_unknown')) :
        $r('app.string.size_progress', dlSizeText(rec.received), dlSizeText(rec.size))
      if (paused) {
        text = $r('app.string.pair_text', base, $r('app.string.download_paused'))
      } else if (waiting) {
        text = $r('app.string.pair_text', base, $r('app.string.waiting_for_network'))
      } else {
        const speed = rec.speed <= 0 ? $r('app.string.na_text') : `${dlSizeText(rec.speed)}/s`
        if (rec.size > 0) {
          text = $r('app.string.triple_text', base, speed, dlRemainingText(rec))
        } else {
          text = $r('app.string.pair_text', base, speed)
        }
      }
    }
    // 点击通知体：完成态 → 拉起应用带 viaOpenFile 路径参数（EntryAbility 校验后
    // 新标签 file:// 打开，不可预览类型回退下载页）；进行中/失败 → 回下载页（现状）
    const tapParams: Record<string, Object> = completed
      ? { 'viaOpenPage': 'downloads', 'viaOpenFile': rec.path }
      : { 'viaOpenPage': 'downloads' }
    const tapInfo: wantAgent.WantAgentInfo = {
      wants: [{
        deviceId: '',
        bundleName: context.applicationInfo.name,
        abilityName: 'EntryAbility',
        action: '',
        entities: [],
        uri: '',
        parameters: tapParams
      }],
      actionType: wantAgent.OperationType.START_ABILITY,
      requestCode: 0,
      actionFlags: [wantAgent.WantAgentFlags.CONSTANT_FLAG]
    }
    const tapAgent: WantAgent = await wantAgent.getWantAgent(tapInfo)
    const request: notificationManager.NotificationRequest = {
      id: rec.id,
      content: {
        notificationContentType: notificationManager.ContentType.NOTIFICATION_CONTENT_BASIC_TEXT,
        normal: {
          title: this.rs(title),
          text: this.rs(text),
          additionalText: ''
        }
      },
      wantAgent: tapAgent
    }
    // 进度模板（进行中且支持模板）：已知总大小→真实百分比；未知总大小→模拟不确定进度
    // （value<max 动态上调形成走不到头的视觉，对齐原版 d.java:283-287 l(100,50,true)；文案保留「大小未知」）
    if ((active || paused || waiting) && this.templateSupported) {
      if (rec.size > 0) {
        const progress = Math.floor(rec.received * 100 / rec.size)
        request.template = {
          name: 'downloadTemplate',
          data: { 'progressValue': progress, 'progressMax': 100 }
        }
      } else if (active) {
        const sim = Math.max(1, Math.floor(rec.received / 1024))
        request.template = {
          name: 'downloadTemplate',
          data: { 'progressValue': sim, 'progressMax': sim * 2 }
        }
      }
    }
    // 暂停/恢复按钮（进行中→暂停；等待网络/已暂停→恢复）
    if (active || paused || waiting) {
      const pauseBtn = active
      const action = pauseBtn ? DL_ACTION_PAUSE : DL_ACTION_RESUME
      const btnInfo: wantAgent.WantAgentInfo = {
        wants: [{
          action: action,
          parameters: {
            'taskId': rec.id
          }
        }],
        actionType: wantAgent.OperationType.SEND_COMMON_EVENT,
        requestCode: 0,
        actionFlags: [wantAgent.WantAgentFlags.CONSTANT_FLAG]
      }
      const btnAgent: WantAgent = await wantAgent.getWantAgent(btnInfo)
      request.actionButtons = [{
        title: this.rs(pauseBtn ? $r('app.string.pause_download') : $r('app.string.resume_download')),
        wantAgent: btnAgent
      }]
    }
    await notificationManager.publish(request)
  }
}
