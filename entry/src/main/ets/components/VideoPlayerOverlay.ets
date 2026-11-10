import { webview } from '@kit.ArkWeb'
import { window, display } from '@kit.ArkUI'
import { audio } from '@kit.AudioKit'
import { settings as ohosSettings } from '@kit.BasicServicesKit'
import { AppSettings, applyOrientationSetting } from '../common/Settings'
import { TabItem } from '../common/Types'
import { applyStatusBarVisible } from '../common/Immersive'

// 原版 c8/nc.java：findVideoElement 探测函数（排除 /game/i 元素，fullscreenElement → document → iframe）
const FIND_VIDEO_FN: string =
  'function findVideoElement(){var a=null,b=document.fullscreenElement||document.mozFullScreenElement||document.webkitFullscreenElement||document.msFullscreenElement;' +
  'b&&(a="VIDEO"===b.tagName?b:firstVideoElement(b));a||(a=firstVideoElement(document));' +
  'if(!a){b=document.getElementsByTagName("iframe");for(var c=0,d=b.length;c<d&&!(a=b[c].contentDocument||b[c].contentWindow.document,a=firstVideoElement(a));c++);}' +
  'return a?/game/i.test(a.className+" "+a.id)?null:a:null}\n' +
  'function firstVideoElement(a){if(!a)return null;a=a.getElementsByTagName("video");return 0>=a.length?null:a[0]};'

// nc.a：探测 "duration,playbackRate,videoWidth,videoHeight"
function probeJs(): string {
  return 'javascript:(function(){' + FIND_VIDEO_FN +
    'var a=findVideoElement();return a?"VIDEO"!=a.tagName?"0,1,16,9":a.duration+","+a.playbackRate+","+a.videoWidth+","+a.videoHeight:""})();'
}

// nc.c：按增量秒 seek（clamp 0..duration）
function seekJs(deltaSeconds: number): string {
  return 'javascript:(function(){' + FIND_VIDEO_FN +
    'var b=findVideoElement();if(b)try{var a=' + deltaSeconds + '+b.currentTime,c=b.duration;0>a?a=0:a>c&&(a=c);b.currentTime=a}catch(d){}})();'
}

// nc.e：设置播放速度
function speedJs(rate: number): string {
  return 'javascript:(function(){' + FIND_VIDEO_FN +
    'var a=findVideoElement();if(a)try{a.playbackRate=' + rate + '}catch(b){}})();'
}

// 原版 v.V 速度档位
const VIDEO_SPEEDS: number[] = [5.0, 3.0, 2.0, 1.5, 1.25, 1.0, 0.75, 0.5]

// Java String.valueOf(float) 格式：5.0 → "5.0"、1.25 → "1.25"
function formatSpeed(v: number): string {
  if (Number.isInteger(v)) {
    return `${v}.0`
  }
  return `${v}`
}

function pad2(n: number): string {
  return n < 10 ? `0${n}` : `${n}`
}

// 原版 z8/b0.R/S：youku/youtube/v.qq/film.qq/mgtv/iqiyi/douyin 禁速度/进度手势
function blacklistRS(url: string): boolean {
  if (url === '') {
    return false
  }
  return url.includes('youku.com') || url.includes('youtube.com') || url.includes('v.qq.com') ||
    url.includes('film.qq.com') || url.includes('mgtv.com') || url.includes('iqiyi.com') ||
    url.includes('douyin.com')
}

// 原版 z8/b0.Y：youku/youtube/douyin/gaze.run 禁亮度/音量手势
function blacklistY(url: string): boolean {
  if (url === '') {
    return false
  }
  return url.includes('youku.com') || url.includes('youtube.com') ||
    url.includes('douyin.com') || url.includes('gaze.run')
}

// 原版 z8/b0.X：仅 youtube.com 隐藏工具栏
function blacklistX(url: string): boolean {
  return url !== '' && url.includes('youtube.com')
}

// 手势状态（v.f4362q）：0=未定 1=边缘透传 2=亮度 3=音量 4=进度
const TOUCH_NONE: number = 0
const TOUCH_PASS: number = 1
const TOUCH_BRIGHTNESS: number = 2
const TOUCH_VOLUME: number = 3
const TOUCH_SEEK: number = 4

// 中央指示图标（v.G）
const CENTER_ICON_NONE: number = 0
const CENTER_ICON_BRIGHTNESS: number = 1
const CENTER_ICON_VOLUME: number = 2

/**
 * 全屏视频播放器覆盖层状态（原版 com.tuyafeng.support.widget.v + c8/ib + c8/k6.z/A5/V）。
 * 视频仍渲染在 Web 内，本层只承载控件、手势与方向/亮度/音量控制。
 */
@ObservedV2
export class VideoOverlayState {
  private static instance: VideoOverlayState | null = null

  static getInstance(): VideoOverlayState {
    if (VideoOverlayState.instance === null) {
      VideoOverlayState.instance = new VideoOverlayState()
    }
    return VideoOverlayState.instance
  }

  // ---- 渲染状态（a4.xml 控件显隐）----
  @Trace active: boolean = false
  // fk 标题（v.setTitle：空标题隐藏）
  @Trace showTitle: boolean = false
  @Trace title: string = ''
  // f5 中央手势指示
  @Trace centerVisible: boolean = false
  @Trace centerText: string = ''
  @Trace centerIcon: number = CENTER_ICON_NONE
  // bk 速度 chip（ff 文本）
  @Trace showChip: boolean = false
  @Trace chipText: string = '1.0X'
  // c_ 锁定按钮
  @Trace showLock: boolean = false
  @Trace locked: boolean = false
  // ch 旋转按钮
  @Trace showRotate: boolean = false

  // ---- 配置（ib.a 解析结果）----
  speedAdjustable: boolean = false // v.F
  progressEnabled: boolean = false // v.G
  brightnessEnabled: boolean = false // v.I
  volumeEnabled: boolean = false // v.H
  toolbarEnabled: boolean = false // v.P
  orientationSupported: boolean = false // v.C（n3.a：仅手机形态）
  videoLandscape: boolean = false // v.K（E：videoWidth > videoHeight）
  duration: number = 0 // v.f4369x
  rate: number = 1.0 // v.f4371z

  // ---- 手势（v.dispatchTouchEvent）----
  touchState: number = TOUCH_NONE
  downX: number = 0 // v.Q
  downY: number = 0 // v.R
  lastX: number = 0 // v.S
  lastY: number = 0 // v.T
  seekSeconds: number = 0 // v.f4370y
  volumeBase: number = 0 // v.f4365t（应用音量 0..100）
  volumeBaseReady: boolean = false
  brightnessBase: number = -1.0 // v.f4366u
  widthVp: number = 0
  heightVp: number = 0
  density: number = 1.0

  private hideTimerId: number = -1
  private controller: webview.WebviewController | null = null
  private exitHandler: FullScreenExitHandler | null = null
  private appContext: Context | null = null
  settings: AppSettings = AppSettings.getInstance()

  private mainWindow(): window.Window | null {
    const win = AppStorage.get<window.Window>('mainWindow')
    return win === undefined ? null : win
  }

  // ---- 进入全屏（k6.z + A5）----
  begin(tab: TabItem, handler: FullScreenExitHandler, context: Context | undefined): void {
    if (this.active) {
      return
    }
    this.appContext = context === undefined ? null : context
    this.exitHandler = handler
    this.controller = tab.controller
    this.active = true
    this.locked = false
    this.touchState = TOUCH_NONE
    this.seekSeconds = 0
    this.brightnessBase = -1.0
    this.volumeBaseReady = false
    this.duration = 0
    this.rate = 1.0
    this.speedAdjustable = false
    this.progressEnabled = false
    this.brightnessEnabled = false
    this.volumeEnabled = false
    this.centerVisible = false
    this.centerIcon = CENTER_ICON_NONE
    // 原版 setTitle(Q8())：空标题隐藏
    this.title = tab.title
    this.showTitle = false
    this.showChip = false
    this.showLock = false
    this.showRotate = false
    this.measureDisplay()
    // 原版 n3.a：smallestScreenWidthDp < 600 才支持方向切换
    this.orientationSupported = Math.min(this.widthVp, this.heightVp) < 600
    const win = this.mainWindow()
    if (win !== null) {
      // view.setKeepScreenOn(true)
      try {
        win.setWindowKeepScreenOn(true).catch(() => {
        })
      } catch (error) {
        console.error('setWindowKeepScreenOn failed')
      }
      // ab(true) 沉浸：全屏期间隐藏状态栏
      applyStatusBarVisible(win, false)
    }
    // 原版 k6.z postDelayed(150ms) → A5：ib.d 探测配置
    setTimeout(() => {
      this.configure(tab)
    }, 150)
  }

  private measureDisplay(): void {
    try {
      const d = display.getDefaultDisplaySync()
      this.density = d.densityPixels > 0 ? d.densityPixels : 1.0
      this.widthVp = d.width / this.density
      this.heightVp = d.height / this.density
    } catch (error) {
      console.error('getDefaultDisplaySync failed')
    }
  }

  // ---- A5 + ib.d：探测视频并应用配置 ----
  private configure(tab: TabItem): void {
    if (!this.active || this.controller === null) {
      return
    }
    const controller = this.controller
    const url = tab.url
    const gameMode = this.settings.gameMode
    const gestureOn = this.settings.videoGesture && !gameMode
    controller.runJavaScript(probeJs()).then((result: string) => {
      if (!this.active) {
        return
      }
      this.applyProbe(result, url, gestureOn, gameMode)
    }).catch(() => {
    })
  }

  // ---- ib.a：解析 "duration,playbackRate,videoWidth,videoHeight" 并配置 ----
  private applyProbe(result: string, url: string, gestureOn: boolean, gameMode: boolean): void {
    let raw = result
    if (raw.length > 1 && raw.charAt(0) === raw.charAt(raw.length - 1) && raw.charAt(0) === '"') {
      raw = raw.substring(1, raw.length - 1)
    }
    const parts = raw.split(',')
    if (parts.length <= 2) {
      this.setVideoSize(16, 9)
      return
    }
    let dur: number = 0
    let parsedRate: number = 1.0
    let w: number = 16
    let h: number = 9
    if (parts[0] === 'Infinity') {
      dur = -1
    } else {
      const pd = Number.parseFloat(parts[0])
      dur = Number.isFinite(pd) ? pd : 0
      const pr = Number.parseFloat(parts[1])
      if (Number.isFinite(pr) && pr > 0) {
        parsedRate = pr
      }
      const pw = Number.parseInt(parts[2], 10)
      const ph = Number.parseInt(parts[3], 10)
      if (!Number.isNaN(pw) && !Number.isNaN(ph)) {
        w = pw
        h = ph
      }
    }
    if (dur > 0) {
      this.duration = dur
      this.rate = parsedRate
      this.chipText = `${formatSpeed(parsedRate)}X`
      this.speedAdjustable = !blacklistRS(url)
      this.progressEnabled = gestureOn && !blacklistRS(url)
    }
    this.volumeEnabled = gestureOn && !blacklistY(url)
    this.brightnessEnabled = gestureOn && !blacklistY(url)
    this.toolbarEnabled = !gameMode && !blacklistX(url)
    this.setVideoSize(w, h)
  }

  // ---- v.E：记录视频横竖 + H() 应用方向 ----
  setVideoSize(videoWidth: number, videoHeight: number): void {
    this.videoLandscape = videoWidth > videoHeight
    this.applyOrientation()
  }

  // ---- v.H：按 videoorientation 设置与锁定态应用方向 ----
  applyOrientation(): void {
    if (!this.orientationSupported || !this.active) {
      return
    }
    const win = this.mainWindow()
    if (win === null) {
      return
    }
    const o0 = this.settings.videoOrientation
    try {
      if (o0 === 3) {
        // N（跟随系统）：n3.i(D) 恢复进入前方向 = 应用方向设置接管
        if (this.appContext !== null) {
          applyOrientationSetting(this.appContext)
        }
        return
      }
      const isLandscapeMode = o0 === 1 || o0 === 2
      const forceLandscape = o0 === 1
      const targetLandscape = isLandscapeMode ? forceLandscape : this.videoLandscape
      let orientation: window.Orientation
      if (this.locked) {
        orientation = targetLandscape ? window.Orientation.LANDSCAPE : window.Orientation.PORTRAIT
      } else {
        // Android SENSOR_LANDSCAPE(6)/SENSOR_PORTRAIT(7) → RESTRICTED 变体（受系统旋转开关控制）
        orientation = targetLandscape
          ? window.Orientation.AUTO_ROTATION_LANDSCAPE_RESTRICTED
          : window.Orientation.AUTO_ROTATION_PORTRAIT_RESTRICTED
      }
      win.setPreferredOrientation(orientation).catch(() => {
      })
    } catch (error) {
      console.error('applyOrientation failed')
    }
  }

  // ---- v.A：锁定按钮（锁定方向 + 仅显示锁定按钮 + 禁手势）----
  toggleLock(): void {
    this.cancelHideTimer()
    this.locked = !this.locked
    this.showControlsAutoHide()
    this.applyOrientation()
  }

  // ---- v.F：显示控件并 3s 自动隐藏 ----
  showControlsAutoHide(): void {
    if (!this.active) {
      return
    }
    this.cancelHideTimer()
    this.hideTimerId = setTimeout(() => {
      if (this.active) {
        this.hideAllControls()
      }
    }, 3000)
    this.showControls()
  }

  // ---- v.v：按锁定态与各开关显示控件 ----
  showControls(): void {
    this.showLock = true
    if (this.locked) {
      this.showTitle = false
      this.showChip = false
      this.showRotate = false
      return
    }
    if (this.title !== '') {
      this.showTitle = true
    }
    if (this.speedAdjustable) {
      this.showChip = true
    }
    if (this.orientationSupported) {
      this.showRotate = true
    }
  }

  // ---- v.x：隐藏全部控件 ----
  hideAllControls(): void {
    this.showTitle = false
    this.showChip = false
    this.showLock = false
    this.showRotate = false
  }

  cancelHideTimer(): void {
    if (this.hideTimerId >= 0) {
      clearTimeout(this.hideTimerId)
      this.hideTimerId = -1
    }
  }

  // ---- 手势（v.dispatchTouchEvent 1:1）----
  handleTouch(event: TouchEvent): void {
    const touch = event.touches[0]
    const width = this.widthVp
    const height = this.heightVp
    if (width <= 0 || height <= 0) {
      return
    }
    if (event.type === TouchType.Down) {
      this.downX = touch.x
      this.downY = touch.y
      // 边缘忽略：y<48dp、y>H-72dp、x<24dp、x>W-48dp（g6.y.h 换算）
      if (this.downY < 48 || this.downY > height - 72 || this.downX < 24 || this.downX > width - 48) {
        this.touchState = TOUCH_PASS
      } else {
        this.lastX = this.downX
        this.lastY = this.downY
        this.touchState = TOUCH_NONE
      }
    } else if (event.type === TouchType.Move) {
      if (this.touchState === TOUCH_PASS) {
        return
      }
      const dx = touch.x - this.lastX
      const dy = touch.y - this.lastY
      this.lastX = touch.x
      this.lastY = touch.y
      // 原版阈值 f4367v = 12 原始像素
      const threshold = 12 / this.density
      if (!this.locked && this.touchState === TOUCH_NONE &&
        (Math.abs(dx) > threshold || Math.abs(dy) > threshold)) {
        const ady = Math.abs(dy)
        const adx = Math.abs(dx)
        if (ady > adx * 1.4) {
          if ((this.downX < width / 3 && this.brightnessEnabled) ||
            (this.downX > (width * 2) / 3 && this.volumeEnabled)) {
            const isBrightness = this.downX < width / 3
            if (isBrightness) {
              if (this.brightnessBase === -1.0) {
                this.brightnessBase = this.systemBrightness()
              }
              this.touchState = TOUCH_BRIGHTNESS
              this.showCenter(CENTER_ICON_BRIGHTNESS)
            } else {
              this.volumeBaseReady = false
              this.readVolumeBase()
              this.touchState = TOUCH_VOLUME
              this.showCenter(CENTER_ICON_VOLUME)
            }
          }
        } else if (Math.abs(dx) <= ady * 3) {
          this.touchState = TOUCH_PASS
        } else if (this.progressEnabled) {
          this.touchState = TOUCH_SEEK
          this.showCenter(CENTER_ICON_NONE)
        }
      }
      if (this.touchState === TOUCH_BRIGHTNESS || this.touchState === TOUCH_VOLUME ||
        this.touchState === TOUCH_SEEK) {
        if (this.touchState === TOUCH_SEEK) {
          this.updateSeek((touch.x - this.downX) / width)
        } else {
          // delta = (downY - curY) * 2 / H（上滑增大）
          const delta = ((this.downY - touch.y) * 2) / height
          if (this.touchState === TOUCH_BRIGHTNESS) {
            this.applyBrightness(delta)
          } else {
            this.applyVolume(delta)
          }
        }
      }
    } else if (event.type === TouchType.Up) {
      const state = this.touchState
      if (state === TOUCH_BRIGHTNESS || state === TOUCH_VOLUME || state === TOUCH_SEEK) {
        this.centerVisible = false
        if (state === TOUCH_SEEK) {
          this.commitSeek()
        }
      } else if (state === TOUCH_NONE) {
        if (this.showLock) {
          this.cancelHideTimer()
          this.hideAllControls()
        } else if (this.toolbarEnabled) {
          this.showControlsAutoHide()
        }
      }
      this.touchState = TOUCH_NONE
    }
  }

  // ---- v.G：设置中央指示图标并显示 ----
  private showCenter(icon: number): void {
    this.centerIcon = icon
    this.centerText = ''
    this.centerVisible = true
  }

  // ---- v.B：亮度 = base + delta，clamp 0.01..1，窗口亮度 ----
  private applyBrightness(delta: number): void {
    let value = this.brightnessBase + delta
    if (value > 1.0) {
      value = 1.0
    }
    if (value < 0.01) {
      value = 0.01
    }
    const win = this.mainWindow()
    if (win !== null) {
      try {
        win.setWindowBrightness(value).catch(() => {
        })
      } catch (error) {
        console.error('setWindowBrightness failed')
      }
    }
    this.centerText = `${Math.floor(value * 100)}%`
  }

  // n3.d：系统亮度归一化（settings.display.SCREEN_BRIGHTNESS_STATUS 0..255）
  private systemBrightness(): number {
    try {
      if (this.appContext === null) {
        return 0.5
      }
      const raw = ohosSettings.getValueSync(this.appContext,
        ohosSettings.display.SCREEN_BRIGHTNESS_STATUS, '128')
      const level = Number.parseInt(raw, 10)
      if (Number.isNaN(level) || level <= 0) {
        return 0.01
      }
      return Math.min(level / 255, 1.0)
    } catch (error) {
      return 0.5
    }
  }

  // ---- v.D：音量 = base/100 + delta，clamp 0..1，应用音量 0..100 ----
  private readVolumeBase(): void {
    try {
      const manager = audio.getAudioManager().getVolumeManager()
      manager.getAppVolumePercentage().then((value: number) => {
        this.volumeBase = value
        this.volumeBaseReady = true
      }).catch(() => {
        this.volumeBase = 0
        this.volumeBaseReady = true
      })
    } catch (error) {
      this.volumeBase = 0
      this.volumeBaseReady = true
    }
  }

  private applyVolume(delta: number): void {
    if (!this.volumeBaseReady) {
      return
    }
    let value = this.volumeBase / 100 + delta
    if (value < 0) {
      value = 0
    }
    if (value > 1) {
      value = 1
    }
    const percent = Math.floor(value * 100)
    this.centerText = `${percent}%`
    try {
      audio.getAudioManager().getVolumeManager().setAppVolumePercentage(percent).catch(() => {
      })
    } catch (error) {
      console.error('setAppVolumePercentage failed')
    }
  }

  // ---- v.C：seek 预览 ±MM:SS（秒 = fraction * min(duration, 300)）----
  private updateSeek(fraction: number): void {
    const seconds = Math.trunc(fraction * Math.min(this.duration, 300))
    this.seekSeconds = seconds
    const sign = seconds >= 0 ? '+' : '-'
    const abs = Math.abs(seconds)
    this.centerText = `${sign}${pad2(Math.floor(abs / 60))}:${pad2(abs % 60)}`
  }

  // ---- v.s：UP 提交 seek ----
  private commitSeek(): void {
    if (this.controller !== null) {
      try {
        this.controller.runJavaScript(seekJs(this.seekSeconds)).catch(() => {
        })
      } catch (error) {
        console.error('seek failed')
      }
    }
    this.seekSeconds = 0
  }

  // ---- 速度菜单选择（v.l 回调）----
  setSpeed(speed: number): void {
    this.rate = speed
    this.chipText = `${formatSpeed(speed)}X`
    if (this.controller !== null) {
      try {
        this.controller.runJavaScript(speedJs(speed)).catch(() => {
        })
      } catch (error) {
        console.error('set speed failed')
      }
    }
    this.showControlsAutoHide()
  }

  // ---- 返回键退出（k6.V() 入口）----
  requestExit(): void {
    try {
      this.exitHandler?.exitFullScreen()
    } catch (error) {
      this.end()
    }
  }

  // ---- 退出全屏（k6.V）----
  end(): void {
    if (!this.active) {
      return
    }
    // n3.i(L1)：恢复进入前方向 = 应用方向设置接管
    if (this.appContext !== null) {
      applyOrientationSetting(this.appContext)
    }
    const win = this.mainWindow()
    if (win !== null) {
      // setKeepScreenOn(false)
      try {
        win.setWindowKeepScreenOn(false).catch(() => {
        })
      } catch (error) {
        console.error('setWindowKeepScreenOn(false) failed')
      }
      // ab(gameMode || O1())：恢复状态栏显隐
      applyStatusBarVisible(win, this.settings.showStatusBar && !this.settings.fullScreen)
      // onDetachedFromWindow：n3.j(-1) 恢复系统亮度
      try {
        win.setWindowBrightness(-1).catch(() => {
        })
      } catch (error) {
        console.error('reset brightness failed')
      }
    }
    this.brightnessBase = -1.0
    this.cancelHideTimer()
    this.active = false
    this.centerVisible = false
    this.hideAllControls()
    this.locked = false
    this.touchState = TOUCH_NONE
    try {
      this.exitHandler?.exitFullScreen()
    } catch (error) {
      // 已退出时忽略
    }
    this.exitHandler = null
    this.controller = null
  }
}

/**
 * 全屏视频覆盖层（原版 r/f/a4.xml + com.tuyafeng.support.widget.v）。
 * 视频渲染在下方 Web 内，本层透明覆盖窗口：透明根节点接收手势并透传给 Web。
 */
@ComponentV2
export struct VideoPlayerOverlay {
  private state: VideoOverlayState = VideoOverlayState.getInstance()

  build() {
    if (this.state.active) {
      Stack() {
        // 顶部渐变 spacer（fo，32dp，#90000000 → 透明）+ 标题（fk，14sp 白）
        Column() {
          if (this.state.showTitle) {
            Column()
              .width('100%')
              .height(32)
              .linearGradient({
                direction: GradientDirection.Bottom,
                colors: [['#90000000', 0], ['#00000000', 1]]
              })
            Text(this.state.title)
              .fontSize(14)
              .fontColor('#FFFFFF')
              .maxLines(1)
              .textOverflow({ overflow: TextOverflow.Ellipsis })
              .padding(16)
              .margin({ right: 56 })
              .width('100%')
          }
        }
        .width('100%')
        .alignItems(HorizontalAlign.Start)
        .position({ x: 0, y: 0 })
        .hitTestBehavior(HitTestMode.None)

        // 中央手势指示（f5，18dp bold 白 + 24dp 图标）
        if (this.state.centerVisible) {
          Row({ space: 8 }) {
            if (this.state.centerIcon === CENTER_ICON_BRIGHTNESS) {
              Image($r('app.media.uia_ic_video_brightness'))
                .width(24)
                .height(24)
                .fillColor('#FFFFFF')
            } else if (this.state.centerIcon === CENTER_ICON_VOLUME) {
              Image($r('app.media.uia_ic_video_volume'))
                .width(24)
                .height(24)
                .fillColor('#FFFFFF')
            }
            Text(this.state.centerText)
              .fontSize(18)
              .fontWeight(FontWeight.Bold)
              .fontColor('#FFFFFF')
              .maxLines(1)
          }
          .padding(16)
          .alignItems(VerticalAlign.Center)
          .hitTestBehavior(HitTestMode.None)
        }

        // 右侧按钮列（df：bk 速度 chip、c_ 锁定、ch 旋转；40dp 圆形 #33000000 底，图标 20dp）
        Row() {
          Column({ space: 8 }) {
            if (this.state.showChip) {
              Row() {
                Text(this.state.chipText)
                  .fontSize(11)
                  .fontWeight(FontWeight.Bold)
                  .fontColor('#FFFFFF')
              }
              .width(40)
              .height(40)
              .borderRadius(20)
              .backgroundColor($r('app.color.hc_33000000'))
              .justifyContent(FlexAlign.Center)
              .alignItems(VerticalAlign.Center)
              .onClick(() => {
                this.showSpeedMenu()
              })
            }
            if (this.state.showLock) {
              Row() {
                Image(this.state.locked
                  ? $r('app.media.uia_ic_video_lock')
                  : $r('app.media.uia_ic_video_unlock'))
                  .width(20)
                  .height(20)
                  .fillColor('#FFFFFF')
              }
              .width(40)
              .height(40)
              .borderRadius(20)
              .backgroundColor($r('app.color.hc_33000000'))
              .justifyContent(FlexAlign.Center)
              .alignItems(VerticalAlign.Center)
              .accessibilityText(this.state.locked ? $r('app.string.orig_a0b') : $r('app.string.orig_ml'))
              .onClick(() => {
                this.state.toggleLock()
              })
            }
            if (this.state.showRotate) {
              Row() {
                Image($r('app.media.uia_ic_video_rotate'))
                  .width(20)
                  .height(20)
                  .fillColor('#FFFFFF')
              }
              .width(40)
              .height(40)
              .borderRadius(20)
              .backgroundColor($r('app.color.hc_33000000'))
              .justifyContent(FlexAlign.Center)
              .alignItems(VerticalAlign.Center)
              .accessibilityText($r('app.string.screen_orientation'))
              .onClick(() => {
                this.showOrientationMenu()
              })
            }
          }
          .alignItems(HorizontalAlign.Center)
          .height('100%')
          .justifyContent(FlexAlign.Center)
          .margin({ right: 16 })
        }
        .width('100%')
        .height('100%')
        .justifyContent(FlexAlign.End)
        .alignItems(VerticalAlign.Center)
        .hitTestBehavior(HitTestMode.None)
      }
      .width('100%')
      .height('100%')
      .hitTestBehavior(HitTestMode.Transparent)
      .onTouch((event: TouchEvent) => {
        this.state.handleTouch(event)
      })
    }
  }

  // 原版 v.l：速度菜单（78dp 宽列表，档位 5.0..0.5）
  private showSpeedMenu(): void {
    this.state.cancelHideTimer()
    const sheets: Array<SheetInfo> = VIDEO_SPEEDS.map((speed: number): SheetInfo => {
      return {
        title: formatSpeed(speed),
        action: (): void => {
          this.state.setSpeed(speed)
        }
      }
    })
    ActionSheet.show({
      title: '',
      message: '',
      sheets: sheets
    })
  }

  // 原版 arrays.xml array/h（jk/py/q0/pz）：跟随系统 | 自动 | 竖屏 | 横屏
  // 菜单索引必须与 videoorientation 的 0..3 同序（w9/k.m(int)）
  private showOrientationMenu(): void {
    this.state.cancelHideTimer()
    const items: string[] = ['跟随系统', '自动', '竖屏', '横屏']
    const sheets: Array<SheetInfo> = items.map((item: string, index: number): SheetInfo => {
      return {
        title: item,
        action: (): void => {
          this.state.settings.setVideoOrientation(index)
          this.state.applyOrientation()
        }
      }
    })
    ActionSheet.show({
      title: '',
      message: '',
      sheets: sheets
    })
  }
}
