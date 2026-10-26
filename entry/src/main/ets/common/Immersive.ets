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
 * 系统栏内容（时间、电量、手势条）固定白色，与深色界面一致。
 */
export function applyImmersiveWindow(win: window.Window, showStatusBar: boolean): void {
  try {
    win.setWindowLayoutFullScreen(true)
  } catch (error) {
    console.error('setWindowLayoutFullScreen failed')
  }
  try {
    win.setWindowSystemBarProperties({
      statusBarColor: '#00000000',
      navigationBarColor: '#00000000',
      statusBarContentColor: '#FFFFFF',
      navigationBarContentColor: '#FFFFFF'
    })
  } catch (error) {
    console.error('setWindowSystemBarProperties failed')
  }
  applyStatusBarVisible(win, showStatusBar)
}

export function applyStatusBarVisible(win: window.Window, visible: boolean): void {
  try {
    win.setSpecificSystemBarEnabled('status', visible)
  } catch (error) {
    console.error('setSpecificSystemBarEnabled failed')
  }
}
