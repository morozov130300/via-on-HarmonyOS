// 统一日志封装：所有模块经此输出 hilog，并按实验页开关写入沙箱日志文件。
// 写盘 sink 由 Index.bootstrap 注入 LogFileService.append，Logger 本身不依赖文件服务，
// 避免 common 内部形成循环依赖。
import { hilog } from '@kit.PerformanceAnalysisKit'
type FileLogSink = (level: string, tag: string, message: string) => void
  // 详细日志等级判断：由 Index 注入（读 LogFileService 详细开关），Logger 不依赖设置存储。
type VerboseGate = () => boolean

class Logger {
  private domain: number = 0x0000
  // 未注入/未开启日志时保持 undefined，error 走零开销分支
  private fileSink: FileLogSink | undefined = undefined
  // 详细日志判定（注入），DEBUG/INFO 仅在它返回 true 时调用 sink
  private verboseGate: VerboseGate | undefined = undefined

  // 注册写盘 sink；传 undefined 可注销。WARN/ERROR 总会调用它，DEBUG/INFO 由详细开关决定。
  public setFileSink(sink: FileLogSink | undefined): void {
    this.fileSink = sink
  }

  // 注册详细日志判定；传 undefined 可注销。未注册时 DEBUG/INFO 不写盘。
  public setVerboseGate(gate: VerboseGate | undefined): void {
    this.verboseGate = gate
  }

  private buildFormat(args: Object[]): string {
    let format: string = ''
    for (let i = 0; i < args.length; i++) {
      format += '%{public}s '
    }
    return format.trim()
  }

  // 把 hilog 的格式化参数还原成单行文本，供日志文件使用。
  // 调用点几乎全为字符串/模板字符串；对象兜底用 JSON.stringify，循环引用退化为 String()。
  private formatArgs(args: Object[]): string {
    const parts: string[] = []
    for (let i = 0; i < args.length; i++) {
      const arg: Object = args[i]
      let text: string = String(arg)
      if (text === '[object Object]') {
        try {
          const json: string | undefined = JSON.stringify(arg)
          if (typeof json === 'string' && json.length > 0) {
            text = json
          }
        } catch (e) {
          text = String(arg)
        }
      }
      parts.push(text)
    }
    return parts.join(' ')
  }

  private emitFileSink(level: string, tag: string, args: Object[]): void {
    const sink: FileLogSink | undefined = this.fileSink
    if (sink === undefined) {
      return
    }
    try {
      sink(level, tag, this.formatArgs(args))
    } catch (e) {
      // 直接用 hilog，避免走 Logger.error 造成递归
      hilog.error(this.domain, 'Logger', 'file log sink failed: %{public}s', String(e))
    }
  }

  public debug(tag: string, ...args: Object[]): void {
    hilog.debug(this.domain, tag, this.buildFormat(args), args)
    if (this.verboseGate !== undefined && this.verboseGate()) {
      this.emitFileSink('DEBUG', tag, args)
    }
  }

  public info(tag: string, ...args: Object[]): void {
    hilog.info(this.domain, tag, this.buildFormat(args), args)
    if (this.verboseGate !== undefined && this.verboseGate()) {
      this.emitFileSink('INFO', tag, args)
    }
  }

  public warn(tag: string, ...args: Object[]): void {
    hilog.warn(this.domain, tag, this.buildFormat(args), args)
    this.emitFileSink('WARN', tag, args)
  }

  public error(tag: string, ...args: Object[]): void {
    hilog.error(this.domain, tag, this.buildFormat(args), args)
    this.emitFileSink('ERROR', tag, args)
  }
}

export default new Logger()
