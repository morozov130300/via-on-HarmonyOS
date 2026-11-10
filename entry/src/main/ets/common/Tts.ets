import { textToSpeech } from '@kit.CoreSpeechKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { i18n } from '@kit.LocalizationKit'

// 原版 z8/q3：TTS 引擎状态机
// 0=初始化中 1=就绪 2=播报中 3=错误 4=已关闭
export const TTS_STATE_INIT: number = 0
export const TTS_STATE_READY: number = 1
export const TTS_STATE_SPEAKING: number = 2
export const TTS_STATE_ERROR: number = 3
export const TTS_STATE_STOPPED: number = 4

// 鸿蒙引擎语速范围 [0.5, 2]（平台能力上限，仅引擎侧截断；
// UI 按原版 j8/p.java 的 14 档 0.25-3.5x 1:1 呈现，不在 UI 层收敛）
const HARMONY_SPEED_MIN: number = 0.5
const HARMONY_SPEED_MAX: number = 2.0

export class ReadAloudEngine {
  private static instance: ReadAloudEngine | null = null
  private engine: textToSpeech.TextToSpeechEngine | null = null
  private initing: boolean = false
  private initState: number = TTS_STATE_INIT
  // q3.f14745e：语速
  private speed: number = 1.0
  // q3.f14742b：当前播报完成回调
  private activeCallback: (() => void) | null = null
  // q3.f14743c：当前播报 requestId
  private activeRequestId: string = ''
  // q3.f14746f/f14747g：初始化期间暂存的文本与回调
  private pendingText: string | null = null
  private pendingCallback: (() => void) | null = null

  static getInstance(): ReadAloudEngine {
    if (ReadAloudEngine.instance === null) {
      ReadAloudEngine.instance = new ReadAloudEngine()
    }
    return ReadAloudEngine.instance
  }

  // q3.e()：引擎状态
  getState(): number {
    return this.initState
  }

  private ensureEngine(): void {
    if (this.engine !== null || this.initing) {
      return
    }
    this.initing = true
    this.initState = TTS_STATE_INIT
    // 原版 q3.f()：setLanguage(Locale.getDefault())——按系统语言初始化引擎，失败回退 zh-CN
    let engineLanguage = 'zh-CN'
    try {
      const sysLang = i18n.System.getSystemLanguage()
      if (sysLang !== '') {
        engineLanguage = sysLang
      }
    } catch (error) {
      engineLanguage = 'zh-CN'
    }
    const params: textToSpeech.CreateEngineParams = {
      language: engineLanguage,
      person: 0,
      online: 1,
      extraParams: { 'isBackStage': true } as Record<string, Object>
    }
    textToSpeech.createEngine(params).then((engine: textToSpeech.TextToSpeechEngine) => {
      this.engine = engine
      this.initing = false
      engine.setListener({
        onStart: (requestId: string, response: textToSpeech.StartResponse): void => {
        },
        onComplete: (requestId: string, response: textToSpeech.CompleteResponse): void => {
          // q3.a.onDone：状态回 1，命中当前请求则触发回调
          this.initState = TTS_STATE_READY
          if (this.activeCallback !== null && requestId === this.activeRequestId) {
            const cb = this.activeCallback
            this.activeCallback = null
            cb()
          }
        },
        onStop: (requestId: string, response: textToSpeech.StopResponse): void => {
        },
        onData: (requestId: string, audio: ArrayBuffer, response: textToSpeech.SynthesisResponse): void => {
        },
        onError: (requestId: string, errorCode: number, errorMessage: string): void => {
          // q3.a.onError：与 onDone 同等处理
          this.initState = TTS_STATE_READY
          if (this.activeCallback !== null && requestId === this.activeRequestId) {
            const cb = this.activeCallback
            this.activeCallback = null
            cb()
          }
        }
      })
      // q3.a：初始化成功 → 状态 1，补播暂存文本
      this.initState = TTS_STATE_READY
      const pending = this.pendingText
      const pendingCb = this.pendingCallback
      this.pendingText = null
      this.pendingCallback = null
      if (pending !== null) {
        this.speak(pending, pendingCb)
      }
    }).catch((error: BusinessError) => {
      console.error(`create tts engine failed: ${error.code} ${error.message}`)
      this.initing = false
      // q3.a：初始化失败 → 状态 3
      this.initState = TTS_STATE_ERROR
      const pendingCb = this.pendingCallback
      this.pendingText = null
      this.pendingCallback = null
      if (pendingCb !== null) {
        pendingCb()
      }
    })
  }

  // q3.g(float)：设置语速（引擎侧截断到鸿蒙范围）
  setSpeed(speed: number): void {
    this.speed = speed
  }

  // q3.h(str, runnable)：播报文本；返回是否受理
  speak(text: string | null, callback: (() => void) | null): boolean {
    if (text === null) {
      if (callback !== null) {
        callback()
      }
      return true
    }
    this.ensureEngine()
    const state = this.initState
    if (state === TTS_STATE_ERROR || state === TTS_STATE_STOPPED) {
      console.error(`cannot speak message, state: ${state}`)
      return false
    }
    if (state === TTS_STATE_INIT) {
      this.pendingText = text
      this.pendingCallback = callback
      return false
    }
    if (this.engine === null) {
      return false
    }
    this.initState = TTS_STATE_SPEAKING
    this.activeCallback = callback
    this.activeRequestId = `${Date.now()}${Math.floor(Math.random() * 100000)}`
    const clamped = Math.max(HARMONY_SPEED_MIN, Math.min(HARMONY_SPEED_MAX, this.speed))
    const speakParams: textToSpeech.SpeakParams = {
      requestId: this.activeRequestId,
      extraParams: { 'speed': clamped } as Record<string, Object>
    }
    this.engine.speak(text, speakParams)
    return true
  }

  // q3.i()：停止播报
  stop(): void {
    if (this.initState === TTS_STATE_SPEAKING) {
      this.initState = TTS_STATE_READY
    }
    this.activeCallback = null
    this.pendingText = null
    this.pendingCallback = null
    if (this.engine !== null) {
      this.engine.stop()
    }
  }

  // q3 无 shutdown（仅销毁场景使用，状态 4）
  shutdown(): void {
    this.stop()
    this.initState = TTS_STATE_STOPPED
    if (this.engine !== null) {
      this.engine.shutdown()
      this.engine = null
    }
  }
}
