import { AbilityConstant, ConfigurationConstant, UIAbility, Want } from '@kit.AbilityKit';
import { hilog } from '@kit.PerformanceAnalysisKit';
import { window } from '@kit.ArkUI';
import { emitter } from '@kit.BasicServicesKit';
import { AppSettings } from '../common/Settings';
import { BrowserDb } from '../common/Database';
import { applyImmersiveWindow } from '../common/Immersive';
import { webview } from '@kit.ArkWeb';

const DOMAIN = 0x0000;
const SHORTCUT_URL_EVENT_ID = 10001;

function extractViaUrl(want: Want): string {
  const params = want.parameters
  if (params === undefined) {
    return ''
  }
  const viaUrl = params['viaUrl']
  return typeof viaUrl === 'string' ? viaUrl : ''
}

export default class EntryAbility extends UIAbility {
  onCreate(want: Want, launchParam: AbilityConstant.LaunchParam): void {
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onCreate');
    const viaUrl = extractViaUrl(want)
    if (viaUrl !== '') {
      AppStorage.setOrCreate('via_launch_url', viaUrl)
    }
  }

  onNewEntry(want: Want, launchParam: AbilityConstant.LaunchParam): void {
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onNewEntry');
    const viaUrl = extractViaUrl(want)
    if (viaUrl !== '') {
      emitter.emit(
        { eventId: SHORTCUT_URL_EVENT_ID },
        { data: { 'viaUrl': viaUrl } }
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

    try {
      this.context.getApplicationContext().setColorMode(ConfigurationConstant.ColorMode.COLOR_MODE_NOT_SET);
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

  private applyClearOnExit(): void {
    try {
      const settings = AppSettings.getInstance();
      const flags = settings.clearOnExit;
      if (flags === '') {
        return;
      }
      const db = BrowserDb.getInstance();
      if (flags.includes('history')) {
        db.clearHistory().catch(() => {
        });
      }
      if (flags.includes('bookmarks')) {
        db.clearBookmarks().catch(() => {
        });
      }
      if (flags.includes('cookies')) {
        try {
          webview.WebCookieManager.clearAllCookies();
        } catch (err) {
          hilog.error(DOMAIN, 'testTag', 'Failed to clear cookies. Cause: %{public}s', JSON.stringify(err));
        }
      }
    } catch (err) {
      hilog.error(DOMAIN, 'testTag', 'Failed to clear on exit. Cause: %{public}s', JSON.stringify(err));
    }
  }
}