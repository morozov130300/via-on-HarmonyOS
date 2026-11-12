import { AbilityConstant, ConfigurationConstant, UIAbility, Want, bundleManager } from '@kit.AbilityKit';
import { tag } from '@kit.ConnectivityKit';
import { Configuration } from '@ohos.app.ability.Configuration';
import { hilog } from '@kit.PerformanceAnalysisKit';
import { window } from '@kit.ArkUI';
import { emitter } from '@kit.BasicServicesKit';
import { commonEventManager } from '@kit.BasicServicesKit';
import { BusinessError } from '@kit.BasicServicesKit';
import { systemShare } from '@kit.ShareKit';
import { preferences } from '@kit.ArkData';
import { AppSettings } from '../common/Settings';
import { UIA_CMD_EVENT_ID } from '../common/DeepLink';
import { BrowserDb } from '../common/Database';
import { applyImmersiveWindow } from '../common/Immersive';
import { initReaderContext } from '../common/Reader';
import { initGmRuntime } from '../common/GmRuntime';
import { RemoteConfig } from '../common/RemoteConfig';
import { ProxyManager } from '../common/ProxyConfig';
import { DownloadEngine } from '../common/DownloadEngine';
import { DownloadNotifier, DL_ACTION_PAUSE, DL_ACTION_RESUME } from '../common/DownloadNotifier';
import { TabStore } from '../common/TabStore';
import { ClosedTabsStore } from '../common/ClosedTabsStore';
import { SslWhitelistStore } from '../common/SslWhitelist';
import { webview } from '@kit.ArkWeb';
import { fileIo } from '@kit.CoreFileKit';

const DOMAIN = 0x0000;
const EXTERNAL_LINK_EVENT_ID = 10002;
const OPEN_DOWNLOADS_EVENT_ID = 10003;
// 原版 k6.i9() 双击返回显式退出 → na.r0()（z8/h0.c 退出清除）：
// 退出清除仅在显式退出路径触发，onBackground（切后台/回桌面）不执行
const EXIT_CLEAR_EVENT_ID = 10005;

interface EntryUrl {
  url: string;
  external: boolean;
}

// 原版 AndroidManifest Shell NDEF_DISCOVERED intent-filter（scheme http/https/uia）
const NFC_TAG_FOUND_ACTION = 'ohos.nfc.tag.action.TAG_FOUND';

// NFC Forum TS NDEF 1.0 URI 记录前缀码表（URI Record Type Definition 章节）
const NDEF_URI_PREFIXES: string[] = [
  '', 'http://www.', 'https://www.', 'http://', 'https://', 'tel:', 'mailto:',
  'ftp://anonymous:anonymous@', 'ftp://ftp.', 'ftps://', 'sftp://', 'smb://',
  'nfs://', 'ftp://', 'dav://', 'news:', 'telnet://', 'imap:', 'rtsp://',
  'urn:', 'pop:', 'sip:', 'sips:', 'tftp:', 'btspp://', 'btl2cap://',
  'btgoep://', 'tcpobex://', 'irdaobex://', 'file://', 'urn:epc:id:',
  'urn:epc:tag:', 'urn:epc:pat:', 'urn:epc:raw:', 'urn:epc:', 'urn:nfc:'
];

function ndefBytesToString(bytes: number[]): string {
  let text = '';
  for (let i = 0; i < bytes.length; i++) {
    text += String.fromCharCode(bytes[i]);
  }
  return text;
}

// 仅接受原版 intent-filter 声明的 scheme：http/https/uia（via:// 兼容归一）
function isNfcHandledUri(uri: string): boolean {
  return uri.startsWith('http://') || uri.startsWith('https://') || uri.startsWith('uia://') || uri.startsWith('via://');
}

// 解析 NDEF 消息中的 URI 记录（TNF well-known=1 + RTD 'U'=0x55，payload[0] 为前缀码）
function parseNdefUriRecords(records: tag.NdefRecord[]): string {
  for (let i = 0; i < records.length; i++) {
    const record = records[i];
    if (record.tnf !== 1) {
      continue;
    }
    const rtdType = record.rtdType;
    if (rtdType === undefined || rtdType.length !== 1 || rtdType[0] !== 0x55) {
      continue;
    }
    const payload = record.payload;
    if (payload === undefined || payload.length === 0) {
      continue;
    }
    const code = payload[0];
    const prefix = code >= 0 && code < NDEF_URI_PREFIXES.length ? NDEF_URI_PREFIXES[code] : '';
    const uri = prefix + ndefBytesToString(payload.slice(1));
    if (isNfcHandledUri(uri)) {
      return uri;
    }
  }
  return '';
}

// Uia 可在新标签 file:// 打开的下载文件类型（文本/图片/音视频/PDF/HTML；
// ArkWeb(Chromium) 原生渲染，pdf 由 TabWeb 拦截进内嵌查看器）
const DOWNLOAD_PREVIEWABLE_EXT: string[] = [
  'html', 'htm', 'xhtml', 'txt', 'text', 'log', 'json', 'xml', 'css', 'js', 'md', 'csv',
  'png', 'jpg', 'jpeg', 'gif', 'webp', 'bmp', 'svg', 'ico', 'avif',
  'mp3', 'm4a', 'aac', 'wav', 'ogg', 'oga', 'flac', 'opus',
  'mp4', 'm4v', 'webm', '3gp', '3g2', 'ogv', 'mov',
  'pdf'
];

function isPreviewableDownloadFile(path: string): boolean {
  const dot = path.lastIndexOf('.')
  if (dot < 0 || dot === path.length - 1) {
    return false
  }
  const ext = path.substring(dot + 1).toLowerCase()
  return DOWNLOAD_PREVIEWABLE_EXT.indexOf(ext) >= 0
}

// 原版 Trampoline → Shell 深链解析：b0.A() 的 VIEW 分支（uri 直传）+ uia:// 内部命令（z8/b0.Q）
function extractEntryUrl(want: Want): EntryUrl {
  const params = want.parameters
  if (params !== undefined) {
    const uiaUrl = params['uiaUrl']
    if (typeof uiaUrl === 'string' && uiaUrl !== '') {
      return { url: uiaUrl, external: false }
    }
    // 原版 Trampoline action（mark.uia.SEARCH/HISTORY/BOOKMARK/SCAN → k6.u()）：
    // 鸿蒙侧由服务卡片（FormLink router）与静态快捷方式（shortcuts_config wants parameters）
    // 以 uiaCmd = uia:// 命令字符串触发，走既有 uia:// 内部命令通道
    const uiaCmd = params['uiaCmd']
    if (typeof uiaCmd === 'string' && uiaCmd !== '') {
      AppStorage.setOrCreate('uia_internal_cmd', uiaCmd)
      return { url: '', external: false }
    }
  }
  const uri = want.uri
  if (typeof uri === 'string' && uri !== '') {
    // 原版 k6.u()：uia://→v:// 内部命令协议（z8/w2 + z8/b0.Q 全量命令表），不是网页 URL。
    // 原版 via:// 深链（清单仍声明 scheme via）同样按内部命令处理，归一到 uia:// 通道。
    if (uri.startsWith('uia://') || uri.startsWith('via://')) {
      AppStorage.setOrCreate('uia_internal_cmd', uri.startsWith('via://') ? 'uia://' + uri.substring(6) : uri)
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
    // 自研下载引擎：恢复 90/95 状态任务并调度（原版 mark/uia/Shell d() DownloadManagerImpl）
    DownloadEngine.getInstance().init(this.context);
    // 原版 mark/uia/download/d.g()：通知渠道（鸿蒙：通知授权 + downloadTemplate 支持查询）
    DownloadNotifier.getInstance().init(this.context);
    // 原版 DownloadReceiver：通知栏暂停/恢复按钮 → 引擎
    this.subscribeDownloadActions();
    // 原版 mark/uia/Shell.h0()→d0()：启动时抓取 r9 远程配置（60s 节流 + 文件缓存），
    // 应用到 RemoteConfig 单例（Shell.java:156 k.q().t(new i(list))）；失败静默降级默认值
    RemoteConfig.getInstance().load(this.context).catch(() => {
    });
    // 原版 mark/uia/Shell 启动时机：读 proxy config → enabled 则启动应用级代理
    ProxyManager.getInstance().applyOnStartup(this.context);
    // 原版 w9/k 构造 n3()（107-116）启动即预载 ignoredsslwarning：冷启动即生效，
    // 不依赖用户进设置页（TabWeb 消费掩码 e8/h0.v()）
    SslWhitelistStore.getInstance().init(this.context).catch(() => {
    });
    // NFC 前台分发注册所需 ElementName（原版无前台分发，仅 NDEF_DISCOVERED 后台匹配；
    // 鸿蒙侧按 NFC 标签读写开发指南在 onForeground/onBackground 注册/注销）
    if (canIUse('SystemCapability.Communication.NFC.Tag')) {
      this.nfcElementName = {
        bundleName: this.context.abilityInfo.bundleName,
        abilityName: this.context.abilityInfo.name,
        moduleName: this.context.abilityInfo.moduleName
      };
    }
    // 原版 Shell NDEF_DISCOVERED：NFC 碰一碰打开网址（want.uri 或解析 NDEF URI 记录）
    if (!this.handleNfcWant(want, true)) {
      const entry = extractEntryUrl(want)
      if (entry.url !== '') {
        AppStorage.setOrCreate('uia_launch_url', entry.url)
        AppStorage.setOrCreate('uia_launch_external', entry.external)
        AppStorage.setOrCreate('uia_shared_text', false)
      }
    }
    // 原版 Trampoline filter#3：ACTION_SEND text/plain 分享接收（b0.A ACTION_SEND → i0.v）
    this.handleSharedText(want, true)
    // 原版 k6.i9()（7374-7385）→ na.r0()（na.java:1719-1721）→ z8/h0.c（h0.java:81-110）：
    // 【逆向实证】k6.i9() 全仓库唯一调用点是 k6.java:6261，位于 public void X1(View,Bundle)
    // （BrowserFragment.onViewCreated）——即「页面创建/每次启动」时执行，不是退出时。
    // 故本端在 onWindowStageCreate → setupWindow 之后执行（见下方 onWindowStageCreate）；
    // 这里保留 Index 双击返回的 emit 作为超集（原版菜单退出不额外清除，此处多清一次无副作用：
    // applyClearOnExit 内缓存位带 lastcleantime 5 天兜底，重复调用不会重复清历史/存储）。
    emitter.on({ eventId: EXIT_CLEAR_EVENT_ID }, () => {
      this.applyClearOnExit();
    });
    if (!this.openDownloadedFileFromWant(want)) {
      if (want.parameters?.['uiaOpenPage'] === 'downloads') {
        // 冷启动时 Index 尚未订阅 emitter，用 AppStorage 标志兜底
        AppStorage.setOrCreate('uia_open_downloads', true)
        emitter.emit({ eventId: OPEN_DOWNLOADS_EVENT_ID }, { data: {} })
      }
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

  // UIAbility 单例已启动（launchType=singleton）再次被拉起 → 系统回调 onNewWant
  // （原版 Shell.onNewIntent → k6.c0 → na.q1）。此前误写为不存在的 onNewEntry，
  // 导致设为默认浏览器后外部点链接全部丢失。
  onNewWant(want: Want, launchParam: AbilityConstant.LaunchParam): void {
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onNewWant');
    if (!this.handleNfcWant(want, false)) {
      const entry = extractEntryUrl(want)
      if (entry.url !== '') {
        emitter.emit(
          { eventId: EXTERNAL_LINK_EVENT_ID },
          { data: { 'linkUrl': entry.url, 'external': entry.external, 'sharedText': false } }
        )
      }
    }
    // 热启动 uia:// 内部命令：通知 Index 立即消费 AppStorage 'uia_internal_cmd'
    const pendingCmd = AppStorage.get<string>('uia_internal_cmd') ?? ''
    if (pendingCmd !== '') {
      emitter.emit({ eventId: UIA_CMD_EVENT_ID }, { data: {} })
    }
    // 原版 Shell onNewIntent → k6.c0 → b0.H：SEND 分享文本接收
    this.handleSharedText(want, false)
    if (!this.openDownloadedFileFromWant(want)) {
      if (want.parameters?.['uiaOpenPage'] === 'downloads') {
        emitter.emit({ eventId: OPEN_DOWNLOADS_EVENT_ID }, { data: {} })
      }
    }
  }

  // 下载完成通知点击（uiaOpenFile 参数）：校验路径位于下载目录内（防路径篡改越权）、
  // 文件存在且为可预览类型 → 新标签 file:// 打开（OfflinePage/查看源码同款 newTabAt 管线）；
  // 校验不通过返回 false，由调用方回退下载页
  private openDownloadedFileFromWant(want: Want): boolean {
    const params = want.parameters
    if (params === undefined) {
      return false
    }
    const rawPath = params['uiaOpenFile']
    if (typeof rawPath !== 'string' || rawPath === '') {
      return false
    }
    const path = rawPath as string
    const saveDir = `${this.context.filesDir}/Download`
    if (!path.startsWith(`${saveDir}/`) || path.indexOf('../') >= 0) {
      return false
    }
    let exists = false
    try {
      exists = fileIo.accessSync(path)
    } catch (err) {
      exists = false
    }
    if (!exists || !isPreviewableDownloadFile(path)) {
      return false
    }
    TabStore.getInstance().newTabAt(`file://${path}`, false)
    return true
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
        AppStorage.setOrCreate('uia_launch_url', trimmed)
        AppStorage.setOrCreate('uia_launch_external', false)
        AppStorage.setOrCreate('uia_shared_text', true)
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

  // NFC 前台分发注册状态（tag.registerForegroundDispatch / unregisterForegroundDispatch）
  private nfcElementName: bundleManager.ElementName | null = null;
  private nfcForegroundRegistered: boolean = false;

  // TAG_FOUND want 处理：系统已解析 URI（NDEF 首记录为 URI 时以 want.uri 传递）直接用，
  // 否则按 TagInfo 解析 NDEF URI 记录；返回是否为 NFC 启动（是则跳过普通深链管线）
  private handleNfcWant(want: Want, cold: boolean): boolean {
    if (want.action !== NFC_TAG_FOUND_ACTION) {
      return false;
    }
    const uri = want.uri;
    if (typeof uri === 'string' && isNfcHandledUri(uri)) {
      this.dispatchNfcUri(uri, cold);
      return true;
    }
    if (!canIUse('SystemCapability.Communication.NFC.Tag')) {
      return true;
    }
    try {
      const tagInfo = tag.getTagInfo(want);
      this.consumeNdefTagInfo(tagInfo, cold);
    } catch (err) {
      hilog.error(DOMAIN, 'testTag', 'getTagInfo failed. Cause: %{public}s', JSON.stringify(err));
    }
    return true;
  }

  // NDEF 技术标签：优先取发现时缓存的 NDEF 消息，无缓存再异步 readNdef
  private consumeNdefTagInfo(tagInfo: tag.TagInfo, cold: boolean): void {
    if (tagInfo === null || tagInfo === undefined) {
      return;
    }
    const techs = tagInfo.technology;
    if (techs === undefined || techs === null) {
      return;
    }
    let hasNdef = false;
    for (let i = 0; i < techs.length; i++) {
      if (techs[i] === tag.NDEF) {
        hasNdef = true;
        break;
      }
    }
    if (!hasNdef) {
      return;
    }
    const ndefTag = tag.getNdef(tagInfo);
    let message: tag.NdefMessage | null = null;
    try {
      message = ndefTag.getNdefMessage();
    } catch (err) {
      message = null;
    }
    if (message !== null && message !== undefined) {
      this.dispatchNfcUri(parseNdefUriRecords(message.getNdefRecords()), cold);
      return;
    }
    ndefTag.readNdef().then((msg: tag.NdefMessage) => {
      this.dispatchNfcUri(parseNdefUriRecords(msg.getNdefRecords()), cold);
    }).catch((error: BusinessError) => {
      hilog.error(DOMAIN, 'testTag', 'readNdef failed. Cause: %{public}s', JSON.stringify(error));
    });
  }

  // 原版 b0.A() VIEW 分支同款出口：网页 URL 走深链管线，uia:// 走内部命令通道
  private dispatchNfcUri(uri: string, cold: boolean): void {
    if (uri === '') {
      return;
    }
    if (uri.startsWith('uia://') || uri.startsWith('via://')) {
      AppStorage.setOrCreate('uia_internal_cmd', uri.startsWith('via://') ? 'uia://' + uri.substring(6) : uri);
      if (!cold) {
        emitter.emit({ eventId: UIA_CMD_EVENT_ID }, { data: {} });
      }
      return;
    }
    if (cold) {
      AppStorage.setOrCreate('uia_launch_url', uri);
      AppStorage.setOrCreate('uia_launch_external', true);
      AppStorage.setOrCreate('uia_shared_text', false);
    } else {
      emitter.emit(
        { eventId: EXTERNAL_LINK_EVENT_ID },
        { data: { 'linkUrl': uri, 'external': true, 'sharedText': false } }
      );
    }
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
      // 原版 k6.i9()（k6.java:6261，X1/onViewCreated，即每次启动）→ na.r0() → z8/h0.c：
      // 退出时清除数据在「启动时」执行。放在 loadContent 成功后，确保 Web 缓存/Cookie
      // 子系统已就绪（removeAllCache 需要 Web 内核已初始化）。
      this.applyClearOnExit();
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
      // 原版 k6.i9():7384 启动即按设置复位系统栏（l3.n(...,false)）。
      // 此处读 AppSettings 的 showStatusBar，避免 showStatusBar=false 时启动瞬态闪烁。
      applyImmersiveWindow(win, AppSettings.getInstance().showStatusBar);
    } catch (err) {
      hilog.error(DOMAIN, 'testTag', 'Failed to setup immersive window. Cause: %{public}s', JSON.stringify(err));
    }
  }

  onWindowStageDestroy(): void {
    // Main window is destroyed, release UI related resources
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onWindowStageDestroy');
    // 原版 na.e（正常退出标记）：本次正常销毁写 clean 标记，下次启动读到缺失即判崩溃恢复。
    // onBackground/onWindowStageDestroy 双保险（进程被杀时 onBackground 是最后回调）。
    ClosedTabsStore.getInstance().markCleanQuit();
  }

  onForeground(): void {
    // Ability has brought to foreground
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onForeground');
    // NFC 前台优先分发：应用前台时碰一碰 NDEF 标签直接交由本应用处理
    if (this.nfcElementName !== null && !this.nfcForegroundRegistered) {
      try {
        tag.registerForegroundDispatch(this.nfcElementName, [tag.NDEF],
          (error: BusinessError, tagInfo: tag.TagInfo) => {
            if (!error) {
              this.consumeNdefTagInfo(tagInfo, false);
            }
          });
        this.nfcForegroundRegistered = true;
      } catch (err) {
        hilog.error(DOMAIN, 'testTag', 'registerForegroundDispatch failed. Cause: %{public}s', JSON.stringify(err));
      }
    }
  }

  onBackground(): void {
    // Ability has back to background
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onBackground');
    if (this.nfcForegroundRegistered) {
      this.nfcForegroundRegistered = false;
      try {
        if (this.nfcElementName !== null) {
          tag.unregisterForegroundDispatch(this.nfcElementName);
        }
      } catch (err) {
        hilog.error(DOMAIN, 'testTag', 'unregisterForegroundDispatch failed. Cause: %{public}s', JSON.stringify(err));
      }
    }
  }

  // 原版 BrowserApp::onConfigurationChanged → shouldNightMode2Change：
  // nightmode2 处于跟随态(2/3)时随系统深浅切换并重设主题（w9/k m0）
  onConfigurationUpdate(newConfig: Configuration): void {
    AppSettings.getInstance().onSystemConfigChange(
      newConfig != null && newConfig.colorMode === ConfigurationConstant.ColorMode.COLOR_MODE_DARK);
  }

  // 原版 na.r0() → z8/h0.c（clearonexit 位掩码 cleardataonexit2）：
  // [1 缓存,2 表单数据,4 历史,64 关闭的标签页,8 网页存储,16 Cookies,32 应用缓存]；
  // 缓存位 1 勾选、或距 lastcleantime ≥432000000ms（h0.c:83 兜底）时清缓存并更新 lastcleantime
  // （w9/k.C1()/Y()，键 lastcleantime，默认当前时间）
  private applyClearOnExit(): void {
    preferences.getPreferences(this.context, 'uia_settings').then((store: preferences.Preferences): void => {
      try {
        const settings = AppSettings.getInstance();
        const mask = settings.clearOnExit;
        const now = Date.now();
        let lastCleanTime = now;
        try {
          const stored = store.getSync('lastcleantime', now);
          if (typeof stored === 'number') {
            lastCleanTime = stored;
          }
        } catch (err) {
          lastCleanTime = now;
        }
        if ((mask & 1) !== 0 || now - lastCleanTime >= 432000000) {
          try {
            webview.WebviewController.removeAllCache(true);
          } catch (err) {
            hilog.error(DOMAIN, 'testTag', 'Failed to clear web cache. Cause: %{public}s', JSON.stringify(err));
          }
          store.putSync('lastcleantime', now);
          store.flush();
        }
        const db = BrowserDb.getInstance();
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
    }).catch((error: BusinessError) => {
      hilog.error(DOMAIN, 'testTag', 'Failed to open preferences on exit. Cause: %{public}s', JSON.stringify(error.code));
    });
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