import { AbilityConstant, ConfigurationConstant, UIAbility, Want } from '@kit.AbilityKit';
import { Configuration } from '@ohos.app.ability.Configuration';
import { hilog } from '@kit.PerformanceAnalysisKit';
import { window } from '@kit.ArkUI';
import { emitter } from '@kit.BasicServicesKit';
import { commonEventManager } from '@kit.BasicServicesKit';
import { BusinessError } from '@kit.BasicServicesKit';
import { systemShare } from '@kit.ShareKit';
import { AppSettings } from '../common/Settings';
import { VIA_CMD_EVENT_ID } from '../common/DeepLink';
import { BrowserDb } from '../common/Database';
import { applyImmersiveWindow } from '../common/Immersive';
import { initReaderContext } from '../common/Reader';
import { initGmRuntime } from '../common/GmRuntime';
import { RemoteConfig } from '../common/RemoteConfig';
import { ProxyManager } from '../common/ProxyConfig';
import { DownloadEngine } from '../common/DownloadEngine';
import { DownloadNotifier, DL_ACTION_PAUSE, DL_ACTION_RESUME } from '../common/DownloadNotifier';
import { webview } from '@kit.ArkWeb';
import { fileIo } from '@kit.CoreFileKit';

const DOMAIN = 0x0000;
const EXTERNAL_LINK_EVENT_ID = 10002;
const OPEN_DOWNLOADS_EVENT_ID = 10003;

interface EntryUrl {
  url: string;
  external: boolean;
}

// 原版 Trampoline → Shell 深链解析：b0.A() 的 VIEW 分支（uri 直传）+ via:// 内部命令（z8/b0.Q）
function extractEntryUrl(want: Want): EntryUrl {
  const params = want.parameters
  if (params !== undefined) {
    const viaUrl = params['viaUrl']
    if (typeof viaUrl === 'string' && viaUrl !== '') {
      return { url: viaUrl, external: false }
    }
    // 原版 Trampoline action（mark.via.SEARCH/HISTORY/BOOKMARK/SCAN → k6.u()）：
    // 鸿蒙侧由服务卡片（FormLink router）与静态快捷方式（shortcuts_config wants parameters）
    // 以 viaCmd = via:// 命令字符串触发，走既有 via:// 内部命令通道
    const viaCmd = params['viaCmd']
    if (typeof viaCmd === 'string' && viaCmd !== '') {
      AppStorage.setOrCreate('via_internal_cmd', viaCmd)
      return { url: '', external: false }
    }
  }
  const uri = want.uri
  if (typeof uri === 'string' && uri !== '') {
    // 原版 k6.u()：via://→v:// 内部命令协议（z8/w2 + z8/b0.Q 全量命令表），不是网页 URL
    if (uri.startsWith('via://')) {
      AppStorage.setOrCreate('via_internal_cmd', uri)
      return { url: '', external: false }
    }
    return { url: uri, external: true }
  }
  return { url: '', external: false }
}

export default class EntryAbility extends UIAbility {
  onCreate(want: Want, launchParam: AbilityConstant.LaunchParam): void {
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onCreate');
    initReaderContext(this.context);
    // GM_* 用户脚本运行时存储（o5 变量库 / p5 require 缓存目录）
    initGmRuntime(this.context);
    // 自研下载引擎：恢复 90/95 状态任务并调度（原版 mark/via/Shell d() DownloadManagerImpl）
    DownloadEngine.getInstance().init(this.context);
    // 原版 mark/via/download/d.g()：通知渠道（鸿蒙：通知授权 + downloadTemplate 支持查询）
    DownloadNotifier.getInstance().init(this.context);
    // 原版 DownloadReceiver：通知栏暂停/恢复按钮 → 引擎
    this.subscribeDownloadActions();
    // 原版 mark/via/Shell.h0()→d0()：启动时抓取 r9 远程配置（60s 节流 + 文件缓存），
    // 应用到 RemoteConfig 单例（Shell.java:156 k.q().t(new i(list))）；失败静默降级默认值
    RemoteConfig.getInstance().load(this.context).catch(() => {
    });
    // 原版 mark/via/Shell 启动时机：读 proxy config → enabled 则启动应用级代理
    ProxyManager.getInstance().applyOnStartup(this.context);
    const entry = extractEntryUrl(want)
    if (entry.url !== '') {
      AppStorage.setOrCreate('via_launch_url', entry.url)
      AppStorage.setOrCreate('via_launch_external', entry.external)
      AppStorage.setOrCreate('via_shared_text', false)
    }
    // 原版 Trampoline filter#3：ACTION_SEND text/plain 分享接收（b0.A ACTION_SEND → i0.v）
    this.handleSharedText(want, true)
    if (want.parameters?.['viaOpenPage'] === 'downloads') {
      // 冷启动时 Index 尚未订阅 emitter，用 AppStorage 标志兜底
      AppStorage.setOrCreate('via_open_downloads', true)
      emitter.emit({ eventId: OPEN_DOWNLOADS_EVENT_ID }, { data: {} })
    }
  }

  // 通知栏按钮公共事件（原版 DownloadReceiver ACTION_PAUSE/ACTION_RESUME）
  private subscribeDownloadActions(): void {
    const subscribe = (action: string, isPause: boolean): void => {
      const info: commonEventManager.CommonEventSubscribeInfo = {
        events: [action]
      }
      commonEventManager.createSubscriber(info, (err, subscriber) => {
        if (err) {
          hilog.error(DOMAIN, 'testTag', 'createSubscriber failed: %{public}s', JSON.stringify(err));
          return
        }
        commonEventManager.subscribe(subscriber, (error, data) => {
          if (error) {
            hilog.error(DOMAIN, 'testTag', 'subscribe failed: %{public}s', JSON.stringify(error));
            return
          }
          const dataParams = data.parameters as Record<string, Object>
          const rawTaskId: Object | undefined = dataParams['taskId']
          if (typeof rawTaskId === 'number') {
            const taskId: number = rawTaskId as number
            const engine = DownloadEngine.getInstance()
            if (isPause) {
              engine.pauseById(taskId)
            } else {
              engine.resumeById(taskId)
            }
          }
        })
      })
    }
    subscribe(DL_ACTION_PAUSE, true)
    subscribe(DL_ACTION_RESUME, false)
  }

  onNewEntry(want: Want, launchParam: AbilityConstant.LaunchParam): void {
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onNewEntry');
    const entry = extractEntryUrl(want)
    if (entry.url !== '') {
      emitter.emit(
        { eventId: EXTERNAL_LINK_EVENT_ID },
        { data: { 'linkUrl': entry.url, 'external': entry.external, 'sharedText': false } }
      )
    }
    // 热启动 via:// 内部命令：通知 Index 立即消费 AppStorage 'via_internal_cmd'
    const pendingCmd = AppStorage.get<string>('via_internal_cmd') ?? ''
    if (pendingCmd !== '') {
      emitter.emit({ eventId: VIA_CMD_EVENT_ID }, { data: {} })
    }
    // 原版 Shell onNewIntent → k6.c0 → b0.H：SEND 分享文本接收
    this.handleSharedText(want, false)
    if (want.parameters?.['viaOpenPage'] === 'downloads') {
      emitter.emit({ eventId: OPEN_DOWNLOADS_EVENT_ID }, { data: {} })
    }
  }

  // 原版 z8/b0.A() ACTION_SEND 分支：EXTRA_TEXT 文本 → i6.i0.v（URL 直开，否则默认引擎搜索）。
  // 鸿蒙侧用 Share Kit getSharedData 解析 want（参数字段由系统序列化，非公开稳定，禁直读）
  private handleSharedText(want: Want, cold: boolean): void {
    if (want.action !== 'ohos.want.action.sendData') {
      return
    }
    systemShare.getSharedData(want).then((data: systemShare.SharedData) => {
      const records: Array<systemShare.SharedRecord> = data.getRecords()
      let text: string = ''
      for (let i = 0; i < records.length; i++) {
        const record: systemShare.SharedRecord = records[i]
        const content: string = record.content ?? ''
        if (text === '' && content !== '') {
          text = content
        }
      }
      const trimmed = text.trim()
      if (trimmed === '') {
        return
      }
      if (cold) {
        AppStorage.setOrCreate('via_launch_url', trimmed)
        AppStorage.setOrCreate('via_launch_external', false)
        AppStorage.setOrCreate('via_shared_text', true)
      } else {
        emitter.emit(
          { eventId: EXTERNAL_LINK_EVENT_ID },
          { data: { 'linkUrl': trimmed, 'external': false, 'sharedText': true } }
        )
      }
    }).catch(() => {
    })
  }

  onDestroy(): void {
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onDestroy');
  }

  onWindowStageCreate(windowStage: window.WindowStage): void {
    // Main window is created, set main page for this ability
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onWindowStageCreate');

    windowStage.loadContent('pages/Index', (err) => {
      if (err.code) {
        hilog.error(DOMAIN, 'testTag', 'Failed to load the content. Cause: %{public}s', JSON.stringify(err));
        return;
      }
      hilog.info(DOMAIN, 'testTag', 'Succeeded in loading the content.');
      this.setupWindow(windowStage);
    });

    // 仅在当前 colorMode 与目标不一致时才调用 setColorMode：
    // 值相同时调用仍会触发全局 configuration change → 页面重建 → 启动黑屏
    try {
      const current = this.context.config.colorMode;
      if (current !== ConfigurationConstant.ColorMode.COLOR_MODE_NOT_SET) {
        this.context.getApplicationContext().setColorMode(ConfigurationConstant.ColorMode.COLOR_MODE_NOT_SET);
      }
    } catch (err) {
      hilog.error(DOMAIN, 'testTag', 'Failed to set colorMode. Cause: %{public}s', JSON.stringify(err));
    }
  }

  private setupWindow(windowStage: window.WindowStage): void {
    try {
      const win = windowStage.getMainWindowSync();
      AppStorage.setOrCreate('mainWindow', win);
      applyImmersiveWindow(win, true);
    } catch (err) {
      hilog.error(DOMAIN, 'testTag', 'Failed to setup immersive window. Cause: %{public}s', JSON.stringify(err));
    }
  }

  onWindowStageDestroy(): void {
    // Main window is destroyed, release UI related resources
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onWindowStageDestroy');
  }

  onForeground(): void {
    // Ability has brought to foreground
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onForeground');
  }

  onBackground(): void {
    // Ability has back to background
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onBackground');
    this.applyClearOnExit();
  }

  // 原版 BrowserApp::onConfigurationChanged → shouldNightMode2Change：
  // nightmode2 处于跟随态(2/3)时随系统深浅切换并重设主题（w9/k m0）
  onConfigurationUpdate(newConfig: Configuration): void {
    AppSettings.getInstance().onSystemConfigChange(
      newConfig != null && newConfig.colorMode === ConfigurationConstant.ColorMode.COLOR_MODE_DARK);
  }

  // 原版 z8/h0.c（clearonexit 位掩码）：[1 缓存,2 表单数据,4 历史,64 关闭的标签页,8 网页存储,16 Cookies,32 应用缓存]
  private applyClearOnExit(): void {
    try {
      const settings = AppSettings.getInstance();
      const mask = settings.clearOnExit;
      if (mask === 0) {
        return;
      }
      const db = BrowserDb.getInstance();
      if ((mask & 1) !== 0) {
        try {
          webview.WebviewController.removeAllCache(true);
        } catch (err) {
          hilog.error(DOMAIN, 'testTag', 'Failed to clear web cache. Cause: %{public}s', JSON.stringify(err));
        }
      }
      if ((mask & 4) !== 0) {
        db.clearHistory().catch(() => {
        });
      }
      if ((mask & 8) !== 0) {
        try {
          webview.WebStorage.deleteAllData();
        } catch (err) {
          hilog.error(DOMAIN, 'testTag', 'Failed to clear web storage. Cause: %{public}s', JSON.stringify(err));
        }
      }
      if ((mask & 16) !== 0) {
        try {
          webview.WebCookieManager.clearAllCookies();
        } catch (err) {
          hilog.error(DOMAIN, 'testTag', 'Failed to clear cookies. Cause: %{public}s', JSON.stringify(err));
        }
      }
      if ((mask & 32) !== 0) {
        this.clearAppCache();
      }
    } catch (err) {
      hilog.error(DOMAIN, 'testTag', 'Failed to clear on exit. Cause: %{public}s', JSON.stringify(err));
    }
  }

  private clearAppCache(): void {
    try {
      const cacheDir = this.context.cacheDir;
      const names = fileIo.listFileSync(cacheDir);
      for (let i = 0; i < names.length; i++) {
        const path = `${cacheDir}/${names[i]}`;
        try {
          fileIo.rmdirSync(path);
        } catch (err) {
          try {
            fileIo.unlinkSync(path);
          } catch (innerErr) {
            hilog.error(DOMAIN, 'testTag', 'Failed to clear cache entry. Cause: %{public}s', names[i]);
          }
        }
      }
    } catch (err) {
      hilog.error(DOMAIN, 'testTag', 'Failed to clear app cache. Cause: %{public}s', JSON.stringify(err));
    }
  }
}