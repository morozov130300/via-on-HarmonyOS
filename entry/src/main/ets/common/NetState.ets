import { connection } from '@kit.NetworkKit'
import { BusinessError } from '@kit.BasicServicesKit'

/**
 * 网络状态监听：原版 w9/p 的 x()「当前是否在 Wi-Fi」，
 * 供「仅 Wi-Fi 有图」图片模式判断（H() = (r&&x) || (!r&&q)）。
 */
@ObservedV2
export class NetMonitor {
  private static instance: NetMonitor | null = null
  @Trace onWifi: boolean = false
  private started: boolean = false

  static getInstance(): NetMonitor {
    if (NetMonitor.instance === null) {
      NetMonitor.instance = new NetMonitor()
    }
    return NetMonitor.instance
  }

  start(): void {
    if (this.started) {
      return
    }
    this.started = true
    this.updateWifi()
    try {
      const conn = connection.createNetConnection()
      conn.on('netCapabilitiesChange', (info: connection.NetCapabilityInfo) => {
        this.checkHandle(info.netHandle)
      })
      conn.register(() => {
      })
    } catch (error) {
      console.error('register net connection failed')
    }
  }

  private updateWifi(): void {
    connection.getDefaultNet().then((netHandle: connection.NetHandle) => {
      this.checkHandle(netHandle)
    }).catch((error: BusinessError) => {
      console.error(`getDefaultNet failed: ${error.code}`)
    })
  }

  private checkHandle(netHandle: connection.NetHandle): void {
    connection.getNetCapabilities(netHandle).then((caps: connection.NetCapabilities) => {
      this.onWifi = caps.bearerTypes.indexOf(connection.NetBearType.BEARER_WIFI) >= 0
    }).catch((error: BusinessError) => {
      console.error(`getNetCapabilities failed: ${error.code}`)
    })
  }
}
