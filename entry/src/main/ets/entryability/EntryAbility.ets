import { AbilityConstant, ConfigurationConstant, UIAbility, Want } from '@kit.AbilityKit';
import { Configuration } from '@ohos.app.ability.Configuration';
import { hilog } from '@kit.PerformanceAnalysisKit';
import { window } from '@kit.ArkUI';
import { emitter } from '@kit.BasicServicesKit';
import { AppSettings } from '../common/Settings';
import { BrowserDb } from '../common/Database';
import { applyImmersiveWindow } from '../common/Immersive';
import { initReaderContext } from '../common/Reader';
import { initGmRuntime } from '../common/GmRuntime';
import { webview } from '@kit.ArkWeb';
import { fileIo } from '@kit.CoreFileKit';

const DOMAIN = 0x0000;
const EXTERNAL_LINK_EVENT_ID = 10002;

interface EntryUrl {
  url: string;
  external: boolean;
}

function extractEntryUrl(want: Want): EntryUrl {
  const params = want.parameters
  if (params !== undefined) {
    const viaUrl = params['viaUrl']
    if (typeof viaUrl === 'string' && viaUrl !== '') {
      return { url: viaUrl, external: false }
    }
  }
  // SEND 分享文本（原版 Trampoline filter#3）：文本当作搜索/网址进入
  const sendParams = want.parameters
  if (sendParams !== undefined) {
    const text = sendParams['text']
    if (typeof text === 'string' && text.trim() !== '') {
      return { url: text.trim(), external: true }
    }
  }
  const uri = want.uri
  if (typeof uri === 'string' && uri !== '') {
    // 原版 k6.u()：via://→v:// 内部命令协议（z8/b0.Q 按 host 分发内部页），不是网页 URL
    if (uri.startsWith('via://')) {
      const cmd = uri.substring('via://'.length).split('/')[0].trim().toLowerCase()
      if (cmd !== '') {
        AppStorage.setOrCreate('via_internal_cmd', cmd)
      }
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
    const entry = extractEntryUrl(want)
    if (entry.url !== '') {
      AppStorage.setOrCreate('via_launch_url', entry.url)
      AppStorage.setOrCreate('via_launch_external', entry.external)
    }
  }

  onNewEntry(want: Want, launchParam: AbilityConstant.LaunchParam): void {
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onNewEntry');
    const entry = extractEntryUrl(want)
    if (entry.url !== '') {
      emitter.emit(
        { eventId: EXTERNAL_LINK_EVENT_ID },
        { data: { 'linkUrl': entry.url, 'external': entry.external } }
      )
    }
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