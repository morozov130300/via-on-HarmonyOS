// 落盘缓存递归清理（对齐原版 z8/o0.java c(File) + b0.o(context)）
// 原版 o0.c：先递归删全部子项，再 file.delete()，非空目录也能删干净。
// 原版 b0.o：额外删除 app_webview 下的 ServiceWorker/CacheStorage、ScriptCache、
//   GPUCache、BrowserMetrics 四个内核缓存目录。
// 鸿蒙侧 ArkWeb 缓存位于 context.cacheDir/web（实测含 13 个子目录），
//   持久化数据在 context.filesDir/__arkweb（Cookie/IndexedDB/LocalStorage，禁止整体删除）；
//   故 clearCacheDir 递归清 cacheDir 全树即等价原版「清临时缓存」，不触碰 __arkweb。
import { fileIo } from '@kit.CoreFileKit'
import { hilog } from '@kit.PerformanceAnalysisKit'
import { BusinessError } from '@kit.BasicServicesKit'

const DOMAIN: number = 0x0000
const TAG: string = 'DiskCleaner'

// 原版 o0.c(File)：递归删子项 → 删自身；返回 true 表示已删除或不存在。
export function removeDirRecursive(path: string): boolean {
  try {
    if (!fileIo.accessSync(path)) {
      return true
    }
  } catch (error) {
    return true
  }
  let stat: fileIo.Stat
  try {
    stat = fileIo.statSync(path)
  } catch (error) {
    return true
  }
  if (stat.isDirectory()) {
    let names: string[] = []
    try {
      names = fileIo.listFileSync(path)
    } catch (error) {
      return false
    }
    for (let i = 0; i < names.length; i++) {
      removeDirRecursive(`${path}/${names[i]}`)
    }
    try {
      fileIo.rmdirSync(path)
      return true
    } catch (error) {
      hilog.error(DOMAIN, TAG, 'rmdir failed: %{public}s', path)
      return false
    }
  }
  try {
    fileIo.unlinkSync(path)
    return true
  } catch (error) {
    hilog.error(DOMAIN, TAG, 'unlink failed: %{public}s', path)
    return false
  }
}

// 原版 b0.i(context) → o0.a(context) + b0.o(context)：
// 清空应用 cacheDir（含 ArkWeb cache/web、preload_caches、blobShader、ddkShader、rawheap），
// 保留 filesDir/__arkweb 中的 Cookie/IndexedDB（对应原版「不删 Default 目录」语义）。
// 注意：调用方应确保 WebviewController.removeAllCache(true) 已先执行（清 ArkWeb 内存+磁盘缓存）。
export function clearAllCache(context: Context): void {
  try {
    removeDirRecursive(context.cacheDir)
    // 重建空 cacheDir，避免系统组件后续写入失败
    if (!fileIo.accessSync(context.cacheDir)) {
      fileIo.mkdirSync(context.cacheDir)
    }
  } catch (error) {
    hilog.error(DOMAIN, TAG, 'clear cacheDir failed: %{public}s', `${(error as BusinessError).code}`)
  }
}
