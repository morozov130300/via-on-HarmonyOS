import { preferences } from '@kit.ArkData'
import { BusinessError } from '@kit.BasicServicesKit'

// 原版 hb/g4（忽略 SSL 证书警告页）+ w9/k.G2()/a(int)：
// 键名 ignoredsslwarning（int 位掩码，默认 0），d3/q3 读写。
// 位表（g4.i3：bit = 1 << i10，行序 = X1 里的添加顺序）：
//   bit0 fd=ur 证书不受信任（SslError.SSL_UNTRUSTED=3）
//   bit1 ad=um 证书日期无效（SSL_INVALID=2? 原版 e8/h0.I 映射见下）
//   bit2 cd=uo 证书已过期（SSL_EXPIRED=1）
//   bit3 bd=un 证书域名与网站域名不匹配（SSL_IDMISMATCH=2）
//   bit4 ed=uq 证书尚未生效（SSL_NOTYETVALID=0）
//   bit5 dd=up 证书无效（SSL_INVALID=2）
// 原版消费点 e8/h0.v()：错误位集合 I；(mask & I) == I 时 sslErrorHandler.proceed()。
// 本工程 Web 层接入点：TabWeb.onSslErrorEventReceive（由主控接线，见任务报告）。
export const SSL_BIT_UNTRUSTED: number = 1
export const SSL_BIT_DATE_INVALID: number = 2
export const SSL_BIT_EXPIRED: number = 4
export const SSL_BIT_ID_MISMATCH: number = 8
export const SSL_BIT_NOT_YET_VALID: number = 16
export const SSL_BIT_INVALID: number = 32

const SSL_MASK_KEY: string = 'ignoredsslwarning'

@ObservedV2
export class SslWhitelistStore {
  private static instance: SslWhitelistStore | null = null
  private store: preferences.Preferences | null = null
  // 原版 w9/l.G2()：ignoredsslwarning 位掩码
  @Trace mask: number = 0

  private constructor() {
  }

  static getInstance(): SslWhitelistStore {
    if (SslWhitelistStore.instance === null) {
      SslWhitelistStore.instance = new SslWhitelistStore()
    }
    return SslWhitelistStore.instance
  }

  // 复用全局 uia_settings 偏好文件（与 AppSettings 同库，保证备份快照覆盖一致性）
  async init(context: Context): Promise<void> {
    if (this.store !== null) {
      return
    }
    try {
      this.store = await preferences.getPreferences(context, 'uia_settings')
      const value = await this.store.get(SSL_MASK_KEY, 0)
      if (typeof value === 'number') {
        this.mask = value
      }
    } catch (error) {
      const err = error as BusinessError
      console.error(`ssl whitelist init failed: ${err.code} ${err.message}`)
    }
  }

  // 原版 w9/k.a(int) → q3("ignoredsslwarning", i10)
  setMask(mask: number): void {
    this.mask = mask
    if (this.store === null) {
      return
    }
    this.store.put(SSL_MASK_KEY, mask).catch((error: BusinessError) => {
      console.error(`ssl whitelist persist failed: ${error.message}`)
    })
  }

  // 原版 g4.j3(bit)：切换一位（已置位则清除，否则置位）
  toggleBit(bit: number): void {
    let next = this.mask
    if ((next & bit) === bit) {
      next = (~bit) & next
    } else {
      next = bit | next
    }
    this.setMask(next)
  }
}
