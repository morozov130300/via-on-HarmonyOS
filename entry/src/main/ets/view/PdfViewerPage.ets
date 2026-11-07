import { pdfService, pdfViewManager, PdfView } from '@kit.PDFKit'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { ACCELERATE_DECELERATE_CURVE } from '../common/Transitions'
import { buildNavSlide } from './PageTransitions'

// 原版 za/g + mark/via/common/widget/PdfViewer 的鸿蒙等价实现：
// PDF Kit PdfView 组件承担 PdfRenderer 自绘渲染（分页/缩放/翻页），
// 页码指示器 1:1 复刻 za/g.Z2：12sp 文本、圆角背景、左上 12dp 边距、
// 触发显示 120ms 渐入、2000ms 无操作后 220ms 渐隐（g3/h3/i3）
@ComponentV2
export struct PdfViewerView {
  @Param @Require pdfPath: string
  @Param pdfTitle: string = ''
  // TabWeb 内嵌全屏场景：无 NavDestination，由本组件绑定全局 AppBar 提供标题/返回
  @Param inOverlay: boolean = false
  @Event onClose: () => void = (): void => {
  }
  private controller: pdfViewManager.PdfController = new pdfViewManager.PdfController()
  @Local pageCount: number = 0
  @Local pageIndex: number = 0
  @Local indicatorOpacity: number = 0
  @Local loadFailed: boolean = false
  private hideTimer: number = -1

  aboutToAppear(): void {
    if (this.inOverlay) {
      this.bindAppBar()
    }
    // 该监听方法只能在文档加载前调用一次（官方约束）
    this.controller.registerPageCountChangedListener((count: number) => {
      this.pageCount = count
    })
    this.controller.registerPageChangedListener((index: number) => {
      this.onPageChanged(index)
    })
    this.controller.loadDocument(this.pdfPath).then((result: pdfService.ParseResult) => {
      if (result !== pdfService.ParseResult.PARSE_SUCCESS) {
        this.loadFailed = true
      }
    }).catch(() => {
      this.loadFailed = true
    })
  }

  aboutToDisappear(): void {
    this.cancelHideTimer()
    if (this.inOverlay) {
      AppBar.maybeHide(this)
    }
    try {
      this.controller.releaseDocument()
    } catch (error) {
      const err = error as BusinessError
      console.error(`release pdf document failed: ${err.message}`)
    }
  }

  private bindAppBar(): void {
    AppBar.show({
      title: this.pdfTitle !== '' ? this.pdfTitle : $r('app.string.preview'),
      onBack: () => {
        this.onClose()
      }
    }, this)
  }

  // 原版 za/g.i3()/g3()：页码变化刷新「n / total」并渐入，2000ms 后渐隐
  //  - za/g.java:286  this.f14804r0.animate().alpha(1.0f).setDuration(120L).start()
  //  - za/g.java:258  this.f14804r0.animate().alpha(0.0f).setDuration(220L)...start()
  //  两处均未 setInterpolator → ViewPropertyAnimator 沿用 ValueAnimator 默认
  //  = AccelerateDecelerateInterpolator（AOSP ValueAnimator.sDefaultInterpolator），
  //  必须显式给曲线，不能省（ArkUI .animation()/animateTo 默认是 Curve.EaseInOut）。
  private onPageChanged(index: number): void {
    this.pageIndex = index
    this.cancelHideTimer()
    this.getUIContext().animateTo({
      duration: 120, curve: ACCELERATE_DECELERATE_CURVE
    }, (): void => {
      this.indicatorOpacity = 1
    })
    this.hideTimer = setTimeout((): void => {
      this.getUIContext().animateTo({
        duration: 220, curve: ACCELERATE_DECELERATE_CURVE
      }, (): void => {
        this.indicatorOpacity = 0
      })
      this.hideTimer = -1
    }, 2000)
  }

  private cancelHideTimer(): void {
    if (this.hideTimer >= 0) {
      clearTimeout(this.hideTimer)
      this.hideTimer = -1
    }
  }

  build() {
    Column() {
      if (this.inOverlay) {
        AppBarSpacer()
      }
      Stack({ alignContent: Alignment.TopStart }) {
        if (this.loadFailed) {
          Column({ space: 16 }) {
            Text($r('app.string.page_failed_load'))
              .fontSize(16)
              .fontColor($r('app.color.fg'))
          }
          .width('100%')
          .height('100%')
          .backgroundColor($r('app.color.page_bg'))
          .justifyContent(FlexAlign.Center)
        } else {
          PdfView({
            controller: this.controller,
            pageFit: pdfService.PageFit.FIT_WIDTH,
            isContinuous: true,
            showScroll: true
          })
            .id('via_pdf_view')
            .width('100%')
            .height('100%')
        }
        // 页码指示器（za/g f14804r0）：(页+1) / 总页数
        Text(`${this.pageIndex + 1} / ${this.pageCount}`)
          .fontSize(12)
          .fontColor($r('app.color.fg_secondary'))
          .backgroundColor($r('app.color.surface'))
          .borderRadius(16)
          .padding({ left: 8, right: 8, top: 4, bottom: 4 })
          .margin(12)
          .opacity(this.indicatorOpacity)
          .visibility(this.indicatorOpacity > 0 ? Visibility.Visible : Visibility.Hidden)
          .hitTestBehavior(HitTestMode.None)
      }
      .width('100%')
      .layoutWeight(1)
    }
    .width('100%')
    .height('100%')
    .backgroundColor($r('app.color.page_bg'))
  }
}

function pdfBaseName(path: string): string {
  const index = path.lastIndexOf('/')
  if (index >= 0 && index < path.length - 1) {
    return path.substring(index + 1)
  }
  return path
}

// 原版 za/g 查看页：pdfPath 参数打开，标题 = pdfName（k6.java:8592-8596 入口）
@ComponentV2
export struct PdfViewerPage {
  private navPathStack: NavPathStack = new NavPathStack()
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'
  @Local pdfPath: string = ''
  @Local pdfTitle: string = ''

  private bindAppBar(): void {
    AppBar.show({
      title: this.pdfTitle !== '' ? this.pdfTitle : $r('app.string.preview'),
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        if (this.pdfPath !== '') {
          PdfViewerView({ pdfPath: this.pdfPath, pdfTitle: this.pdfTitle })
        }
      }
      .width('100%')
      .height('100%')
    }
    .hideTitleBar(true)
    .backgroundColor($r('app.color.page_bg'))
    .translate({ x: this.slideOffset })
    // 原版 g6/i.java:67 = setCustomAnimations(anim/f, anim/g, anim/h, anim/i)，
    // 时长 integer/b=220、accelerate_decelerate —— PDF 页同样经 g6.i.h(this, za.g.class, ...) 打开
    .customTransition((operation: NavigationOperation, isEnter: boolean):
      Array<NavDestinationTransition> | undefined => {
      return buildNavSlide(operation, isEnter, (value: string): void => {
        this.slideOffset = value
      })
    })
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      const param: Object | undefined = ctx.pathInfo.param === undefined ? undefined : ctx.pathInfo.param as Object
      if (typeof param === 'string') {
        this.pdfPath = param
        this.pdfTitle = pdfBaseName(param)
      }
      this.bindAppBar()
    })
    .onWillAppear(() => {
      this.bindAppBar()
    })
    .onShown(() => {
      this.bindAppBar()
    })
    .onWillDisappear(() => {
      AppBar.maybeHide(this)
    })
  }
}

@Builder
export function PdfViewerPageBuilder() {
  PdfViewerPage()
}
