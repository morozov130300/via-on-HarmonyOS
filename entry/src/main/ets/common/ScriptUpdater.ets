// 原版用户脚本自动更新 1:1 移植（sb/q.java）：
// - 触发链：浏览器启动 k6 onViewCreated → i9() → c8/na.q0() → sb/q 静默执行；
//   鸿蒙侧入口 = EntryAbility.onCreate → GmRuntime.initGmRuntime() → runScriptsAutoUpdate()
// - 节流（sb/q.a）：interval = 「自动更新」档位；interval < 1h（「从不」档为 0）直接跳过；
//   距上次自动更新（lastScriptUpdate）未满间隔直接跳过；单脚本按独立 last_updated_at 过滤
//   （p5 scripts.last_updated_at 列 → 元数据旁路存储 metaStoreLoadScript）
// - 更新（sb/q.e → p5/b.p）：下载→重新解析→整体替换；无版本比较、无 UI、无 toast，静默；
//   失败仅记录 "Unknown error, script: name"；enabled 用解析默认值 true（原版未回写原启用位）
// - 下载（s5/b.d）：GET 文本（readTimeout 5000），空/失败回退 s5/b.f 的 jsdelivr 镜像重试
// - 完成：settings.markScriptsUpdated()（对应 w9/k.p0("scripts", now)）
import { http } from '@kit.NetworkKit'
import { preferences } from '@kit.ArkData'
import { common } from '@kit.AbilityKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { UserScriptRec, parseUserScriptMeta } from './Types'
import { AppSettings } from './Settings'
import { META_STORE_NAME, metaStoreLoadScript, metaStoreSaveScript } from './ScriptResources'

const DAY_MS: number = 86400000
// sb/q.java:46：jZ < 3600000 视为关闭（「从不」档 interval=0）
const MIN_INTERVAL_MS: number = 3600000
const KEY_USER_SCRIPTS: string = 'userScripts'
const WAIT_SLICE_MS: number = 100
const WAIT_MAX_SLICES: number = 100

let autoUpdateRunning: boolean = false

// 启动触发入口（fire-and-forget，异常仅记录）
export function startScriptsAutoUpdate(context: common.Context): void {
  runScriptsAutoUpdate(context).catch((error: BusinessError) => {
    console.error(`scripts auto update failed: ${error.message}`)
  })
}

async function runScriptsAutoUpdate(context: common.Context): Promise<void> {
  if (autoUpdateRunning) {
    return
  }
  // AppSettings.init 在 Index.ets 加载后才执行，这里等待其完成（uia_settings 同一实例，
  // 原始 JSON 已空 ⇔ 已加载完成或本就无脚本，两者都可直接走 AppSettings 内存态）
  const settingsStore = await preferences.getPreferences(context, 'uia_settings')
  const ready = await waitSettingsLoaded(settingsStore)
  if (!ready) {
    return
  }
  const settings = AppSettings.getInstance()
  const intervalMs = settings.scriptAutoUpdate * DAY_MS
  if (intervalMs < MIN_INTERVAL_MS) {
    return
  }
  const now = Date.now()
  // sb/q.a:45-48：距上次自动更新未满间隔直接返回
  if (settings.lastScriptUpdate >= now - intervalMs) {
    return
  }
  autoUpdateRunning = true
  try {
    const metaStore = await preferences.getPreferences(context, META_STORE_NAME)
    // sb/q.b(long, r5.c)：enabled && downloadUrl 非空 && last_updated_at < now - interval
    const threshold = now - intervalMs
    for (let i = 0; i < settings.userScripts.length; i++) {
      const script = settings.userScripts[i]
      if (!script.enabled || script.downloadUrl === '') {
        continue
      }
      const meta = metaStoreLoadScript(metaStore, script.id)
      const lastUpdatedAt = meta !== null ? meta.lastUpdatedAt : 0
      if (lastUpdatedAt >= threshold) {
        continue
      }
      const code = await fetchScriptText(script.downloadUrl)
      if (code === null) {
        // sb/r.a()：失败静默，仅记录
        console.error(`Unknown error, script: ${script.name}`)
        continue
      }
      const parsed = parseUserScriptMeta(code, script.downloadUrl)
      if (parsed === null) {
        console.error(`Unknown error, script: ${script.name}`)
        continue
      }
      // sb/q.e → p5/b.p：整体替换，enabled 用解析默认值 true
      parsed.id = script.id
      parsed.enabled = true
      settings.saveScript(parsed)
      // p5/b.p：last_updated_at 刷新（r5/a.f:231-232 解析即当前时间）
      metaStoreSaveScript(metaStore, parsed)
    }
    await metaStore.flush()
    // sb/q.a 完成回调：w9/k.p0("scripts", now)
    settings.markScriptsUpdated()
  } finally {
    autoUpdateRunning = false
  }
}

// 等待 AppSettings.loadFields 完成：内存 userScripts 非空，或持久化 JSON 本就为空
async function waitSettingsLoaded(settingsStore: preferences.Preferences): Promise<boolean> {
  const settings = AppSettings.getInstance()
  for (let i = 0; i < WAIT_MAX_SLICES; i++) {
    const raw = (await settingsStore.get(KEY_USER_SCRIPTS, '[]')) as string
    if (settings.userScripts.length > 0 || isEmptyScriptsJson(raw)) {
      return true
    }
    await sleep(WAIT_SLICE_MS)
  }
  return false
}

function isEmptyScriptsJson(raw: string): boolean {
  try {
    const parsed = JSON.parse(raw) as Object[]
    return parsed.length === 0
  } catch (error) {
    return true
  }
}

function sleep(ms: number): Promise<void> {
  return new Promise<void>((resolve: (value: void) => void) => {
    setTimeout(resolve, ms)
  })
}

// s5/b.d(String)：抓取脚本文本；空/失败回退镜像地址重试（手动安装/更新共用）
export async function fetchScriptText(url: string): Promise<string | null> {
  const first = await httpGetText(url)
  if (first !== null && first !== '') {
    return first
  }
  const mirror = mirrorUrlOf(url)
  if (mirror !== null) {
    return await httpGetText(mirror)
  }
  return null
}

// s5/b.e(String)：GET 文本（readTimeout 5000、禁缓存），异常返回 null
async function httpGetText(url: string): Promise<string | null> {
  const request = http.createHttp()
  try {
    const response = await request.request(url, {
      method: http.RequestMethod.GET,
      connectTimeout: 10000,
      readTimeout: 5000,
      usingCache: false
    })
    return typeof response.result === 'string' ? response.result : null
  } catch (error) {
    const err = error as BusinessError
    console.error(`fetch script text failed: ${err.message}`)
    return null
  } finally {
    request.destroy()
  }
}

// s5/b.f(String)：CDN 镜像回退（fastly.jsdelivr.net / gh / npm）1:1
function mirrorUrlOf(url: string): string | null {
  if (url.startsWith('https://fastly.jsdelivr.net/')) {
    return null
  }
  if (url.startsWith('https://cdn.jsdelivr.net/') && url.length > 25) {
    return `https://fastly.jsdelivr.net/${url.substring(25)}`
  }
  if (url.startsWith('https://raw.githubusercontent.com/') && url.length > 34) {
    // s5/b.f:458-465：user/repo 与 branch/path 之间的斜杠替换为 '@'——
    // gh 镜像地址必须为 fastly.jsdelivr.net/gh/user/repo@branch/path
    let secondSlash = url.indexOf('/', 34)
    if (secondSlash >= 0) {
      secondSlash = url.indexOf('/', secondSlash + 1)
    }
    if (secondSlash <= 0) {
      return null
    }
    return `https://fastly.jsdelivr.net/gh/${url.substring(34, secondSlash)}@${url.substring(secondSlash + 1)}`
  }
  if (url.startsWith('https://github.com/') && url.length > 19) {
    const blobIdx = url.indexOf('/blob/', 19)
    if (blobIdx < 0 || blobIdx >= url.length - 6) {
      return null
    }
    return `https://fastly.jsdelivr.net/gh/${url.substring(19, blobIdx)}@${url.substring(blobIdx + 6)}`
  }
  if (url.startsWith('https://unpkg.com/') && url.length > 18) {
    return `https://fastly.jsdelivr.net/npm/${url.substring(18)}`
  }
  return null
}
