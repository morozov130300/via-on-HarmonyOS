import { textToSpeech } from '@kit.CoreSpeechKit'

@ObservedV2
export class TtsManager {
  private static instance: TtsManager | null = null
  private engine: textToSpeech.TextToSpeechEngine | null = null
  private initing: boolean = false
  @Trace speaking: boolean = false

  static getInstance(): TtsManager {
    if (TtsManager.instance === null) {
      TtsManager.instance = new TtsManager()
    }
    return TtsManager.instance
  }

  async ensureEngine(): Promise<boolean> {
    if (this.engine !== null) {
      return true
    }
    if (this.initing) {
      return false
    }
    this.initing = true
    try {
      const params: textToSpeech.CreateEngineParams = {
        language: 'zh-CN',
        person: 13,
        online: 1
      }
      this.engine = await textToSpeech.createEngine(params)
      this.engine.setListener({
        onStart: (requestId: string, response: textToSpeech.StartResponse): void => {
        },
        onComplete: (requestId: string, response: textToSpeech.CompleteResponse): void => {
          this.speaking = false
        },
        onStop: (requestId: string, response: textToSpeech.StopResponse): void => {
          this.speaking = false
        },
        onData: (requestId: string, audio: ArrayBuffer, response: textToSpeech.SynthesisResponse): void => {
        },
        onError: (requestId: string, errorCode: number, errorMessage: string): void => {
          console.error(`tts error: ${errorCode} ${errorMessage}`)
          this.speaking = false
        }
      })
      this.initing = false
      return true
    } catch (error) {
      console.error('create tts engine failed')
      this.initing = false
      return false
    }
  }

  async speak(text: string): Promise<void> {
    const trimmed = text.trim()
    if (trimmed === '') {
      return
    }
    const ready = await this.ensureEngine()
    if (!ready || this.engine === null) {
      return
    }
    this.speaking = true
    const params: textToSpeech.SpeakParams = {
      requestId: Date.now().toString()
    }
    this.engine.speak(trimmed, params)
  }

  stop(): void {
    if (this.engine !== null) {
      this.engine.stop()
    }
    this.speaking = false
  }

  shutdown(): void {
    if (this.engine !== null) {
      this.engine.shutdown()
      this.engine = null
    }
    this.speaking = false
  }
}
