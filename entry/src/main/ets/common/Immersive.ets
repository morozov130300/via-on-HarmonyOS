import { window } from '@kit.ArkUI'

/**
 * 全局沉浸式内边距（vp）。窗口全屏布局后，页面内容会铺到状态栏与导航条下方，
 * 需要避让的控件从这里取数值。
 */
@ObservedV2
export class UiInsets {
  private static instance: UiInsets | null = null
  @Trace top: number = 0
  @Trace bottom: number = 0

  static getInstance(): UiInsets {
    if (UiInsets.instance === null) {
      UiInsets.instance = new UiInsets()
    }
    return UiInsets.instance
  }

  refresh(win: window.Window): void {
    try {
      const sys = win.getWindowAvoidArea(window.AvoidAreaType.TYPE_SYSTEM)
      const indicator = win.getWindowAvoidArea(window.AvoidAreaType.TYPE_NAVIGATION_INDICATOR)
      this.top = px2vp(sys.topRect.height)
      const bottomPx = sys.bottomRect.height > indicator.bottomRect.height
        ? sys.bottomRect.height
        : indicator.bottomRect.height
      this.bottom = px2vp(bottomPx)
    } catch (error) {
      console.error('refresh insets failed')
    }
  }
}

/**
 * 让窗口进入全屏布局并保持系统栏透明，实现状态栏/导航条沉浸。
 * 系统栏内容（时间、电量、手势条）明暗跟随界面：原版 z8/l3.p()/o()（k6.Z7 6567-6608 调用）
 * ——亮背景用深色内容，否则白色。固定白色会让浅色模式下状态栏时间在白底上隐形。
 */
export function applyImmersiveWindow(win: window.Window, showStatusBar: boolean, darkContent: boolean): void {
  try {
    win.setWindowLayoutFullScreen(true).catch(() => {
      // PC/2in1 自由多窗模式下该接口禁用，忽略即可
    })
  } catch (error) {
    console.error('setWindowLayoutFullScreen failed')
  }
  applyWindowBackgroundColor(win)
  applySystemBarContentColor(win, darkContent)
  applyStatusBarVisible(win, showStatusBar)
}

/**
 * 窗口背景色同步页面底色（base #FFFFFF / dark #1C1B1D）。
 * 旋转时系统释放渲染缓存（RS DisableCacheForRotation），新尺寸首帧合成前露出窗口底色：
 * 默认白底叠深色页面即「旋转闪屏」。底色与页面一致后空帧不可见。
 * 夜间切换后由 applyImmersiveWindow 的调用方（EntryAbility/夜间监听）重跑本函数刷新。
 */
export function applyWindowBackgroundColor(win: window.Window): void {
  try {
    const ctx = win.getUIContext().getHostContext()
    if (ctx === undefined) {
      return
    }
    // 资源按当前 colorMode 解析：dark 目录在夜间态返回 #1C1B1D，浅色态返回 #FFFFFF
    const color = ctx.resourceManager.getColorSync($r('app.color.page_bg').id)
    const to2 = (v: number): string => v.toString(16).padStart(2, '0')
    const hex = `#${to2((color >>> 16) & 0xFF)}${to2((color >>> 8) & 0xFF)}${to2(color & 0xFF)}`
    try {
      win.setWindowBackgroundColor(hex)
    } catch (error) {
      // PC/2in1 自由多窗模式下该接口禁用，忽略即可
    }
  } catch (error) {
    console.error('applyWindowBackgroundColor failed')
  }
}

/** 原版 z8/l3.p()/o()：系统栏图标与文字明暗（darkContent=true 用深色内容） */
export function applySystemBarContentColor(win: window.Window, darkContent: boolean): void {
  try {
    win.setWindowSystemBarProperties({
      statusBarColor: '#00000000',
      navigationBarColor: '#00000000',
      statusBarContentColor: darkContent ? '#000000' : '#FFFFFF',
      navigationBarContentColor: darkContent ? '#000000' : '#FFFFFF'
    })
  } catch (error) {
    console.error('setWindowSystemBarProperties failed')
  }
}

// 原版 z8/l3.java:266 n(window, z10)：
//   z10=true  → insetsController.hide(WindowInsets.Type.systemBars())
//               （状态栏 + 导航栏 **一起**隐藏，setSystemBarsBehavior(2) 滑动唤出）
//   z10=false → show(systemBars())（i10>=31 用 behavior 1）
// 本端等价：setSpecificSystemBarEnabled('status') + ('navigation')，两者必须同时切换，
// 只隐藏状态栏会留下导航栏、且与原版「系统栏整体沉浸」不符。
export function applyStatusBarVisible(win: window.Window, visible: boolean): void {
  try {
    win.setSpecificSystemBarEnabled('status', visible).catch(() => {
      // PC/2in1 自由多窗模式下该接口禁用，忽略即可
    })
  } catch (error) {
    console.error('setSpecificSystemBarEnabled status failed')
  }
  try {
    win.setSpecificSystemBarEnabled('navigation', visible).catch(() => {
    })
  } catch (error) {
    console.error('setSpecificSystemBarEnabled navigation failed')
  }
}
