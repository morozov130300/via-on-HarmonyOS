import camera from '@ohos.multimedia.camera'
import image from '@ohos.multimedia.image'
import {
  BarcodeFormat,
  BinaryBitmap,
  DecodeHintType,
  GlobalHistogramBinarizer,
  HybridBinarizer,
  InvertedLuminanceSource,
  MultiFormatReader,
  RGBLuminanceSource
} from '@ohos/zxing'
import { abilityAccessCtrl, common, Permissions } from '@kit.AbilityKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { taskpool } from '@kit.ArkTS'

// 扫码专用轻量解码（taskpool 后台执行）：
// - TRY_HARDER 单次解码即覆盖 4 个旋转方向，不像库级联把旋转放在最后逐向白跑
// - 宽幅帧取中心方裁剪（码在取景中心），≥720 宽再 2× 降采样，二值化开销最低
// - Global 先行（快），Hybrid 兜底（光照不均时 Global 整帧失败靠它救）
// - 反色码极罕见：仅按帧序每 3 帧试一次反色，砍掉多数无码帧的第二遍全图解码
@Concurrent
function decodeQrFast(y: Uint8ClampedArray, width: number, height: number, stride: number,
  tryInverted: boolean): string {
  let src = y
  let w = width
  let h = height
  let st = stride
  if (w >= 720) {
    const dw = w >> 1
    const dh = h >> 1
    const out = new Uint8ClampedArray(dw * dh)
    for (let dy = 0; dy < dh; dy++) {
      const r0 = dy * 2 * st
      const r1 = r0 + st
      const dst = dy * dw
      for (let dx = 0; dx < dw; dx++) {
        const c0 = dx * 2
        const c1 = c0 + 1
        out[dst + dx] = (src[r0 + c0] + src[r0 + c1] + src[r1 + c0] + src[r1 + c1]) >> 2
      }
    }
    src = out
    w = dw
    h = dh
    st = dw
  }
  const lum = new RGBLuminanceSource(src, w, h, st, h)
  const reader = new MultiFormatReader()
  const hints: Map<DecodeHintType, Object> = new Map()
  hints.set(DecodeHintType.POSSIBLE_FORMATS, [BarcodeFormat.QR_CODE])
  hints.set(DecodeHintType.TRY_HARDER, [])
  reader.setHints(hints)
  try {
    return reader.decodeWithState(new BinaryBitmap(new GlobalHistogramBinarizer(lum))).getText()
  } catch (_error) {
    try {
      return reader.decodeWithState(new BinaryBitmap(new HybridBinarizer(lum))).getText()
    } catch (_error2) {
      if (!tryInverted) {
        return ''
      }
      const inv = new InvertedLuminanceSource(lum)
      try {
        return reader.decodeWithState(new BinaryBitmap(new GlobalHistogramBinarizer(inv))).getText()
      } catch (_error3) {
        return reader.decodeWithState(new BinaryBitmap(new HybridBinarizer(inv))).getText()
      }
    }
  }
}

// OpenHarmony 设备专用扫码器：预览流经 ImageReceiver 直取 Y 平面，taskpool 后台解码
@ComponentV2
export struct OpenHarmonyQrScanner {
  @Param @Require context: common.UIAbilityContext
  @Event onResult: (value: string) => void = (_value: string): void => {}
  @Event onClose: () => void = (): void => {}

  @Local private surfaceId: string = ''
  @Local private status: string = '正在准备相机'
  @Local private zoomRatio: number = 1
  private xController: XComponentController = new XComponentController()
  private imageReceiver: image.ImageReceiver | undefined = undefined
  private cameraInput: camera.CameraInput | undefined = undefined
  private previewOutput: camera.PreviewOutput | undefined = undefined
  private frameOutput: camera.PreviewOutput | undefined = undefined
  private session: camera.CaptureSession | undefined = undefined
  private stopped: boolean = false
  private cameraStarting: boolean = false
  private reading: boolean = false
  private lastDecodeAt: number = 0
  private frameSeq: number = 0
  private permissionGranted: boolean = false
  private zoomRange: number[] = [1, 1]
  private systemZoom: boolean = false
  private gestureBaseZoom: number = 1

  aboutToAppear(): void {
    this.requestCameraPermission()
  }

  aboutToDisappear(): void {
    this.stopCamera()
  }

  private async requestCameraPermission(): Promise<void> {
    try {
      const manager = abilityAccessCtrl.createAtManager()
      const result = await manager.requestPermissionsFromUser(this.context, ['ohos.permission.CAMERA' as Permissions])
      if (result.authResults.length === 0 || result.authResults[0] !== 0) {
        this.status = '未获得相机权限'
        return
      }
      this.permissionGranted = true
      this.status = '将二维码放入取景范围'
      if (this.surfaceId !== '') {
        await this.startCamera()
      }
    } catch (error) {
      const businessError = error as BusinessError
      this.status = `相机权限失败 (${businessError.code})`
    }
  }

  private async startCamera(): Promise<void> {
    if (this.stopped || this.cameraStarting || !this.permissionGranted || this.surfaceId === '') {
      return
    }
    this.cameraStarting = true
    let stage: string = '获取相机服务'
    try {
      const manager = camera.getCameraManager(this.context)
      stage = '枚举摄像头'
      const cameras = manager.getSupportedCameras()
      console.info(`OpenHarmony camera devices: ${cameras.length}`)
      if (cameras.length === 0) {
        this.status = '设备没有可用摄像头'
        return
      }
      let selected = cameras[0]
      for (let i = 0; i < cameras.length; i++) {
        if (cameras[i].cameraPosition === camera.CameraPosition.CAMERA_POSITION_BACK) {
          selected = cameras[i]
          break
        }
      }
      stage = '查询相机输出能力'
      const capabilities = manager.getSupportedOutputCapability(selected)
      if (capabilities.previewProfiles.length === 0) {
        this.status = '摄像头不支持扫码预览'
        return
      }
      const preview = this.pickPreviewProfile(capabilities.previewProfiles)
      stage = '创建取帧接收器'
      // 接收器尺寸与预览档位一致（2000=JPEG 组件槽位，底层透传预览原始缓冲）
      this.imageReceiver = image.createImageReceiver(preview.size.width, preview.size.height, 2000, 8)
      this.imageReceiver.on('imageArrival', (): void => {
        this.onFrameArrival()
      })
      stage = '创建摄像头输入'
      this.cameraInput = manager.createCameraInput(selected)
      stage = '创建预览输出'
      this.previewOutput = manager.createPreviewOutput(preview, this.surfaceId)
      this.xController.setXComponentSurfaceSize({
        surfaceWidth: preview.size.width,
        surfaceHeight: preview.size.height
      })
      stage = '创建取帧输出'
      const receiverSurfaceId = await this.imageReceiver.getReceivingSurfaceId()
      this.frameOutput = manager.createPreviewOutput(preview, receiverSurfaceId)
      stage = '打开摄像头'
      await this.cameraInput.open()
      stage = '创建相机会话'
      this.session = manager.createCaptureSession()
      stage = '配置相机会话'
      this.session.beginConfig()
      this.session.addInput(this.cameraInput)
      this.session.addOutput(this.previewOutput)
      this.session.addOutput(this.frameOutput)
      stage = '提交相机配置'
      await this.session.commitConfig()
      stage = '启动相机预览'
      await this.session.start()
      // 连续自动对焦：对焦拉胯会让识别整段拖慢，支持就开
      try {
        this.session.setFocusMode(camera.FocusMode.FOCUS_MODE_CONTINUOUS_AUTO)
      } catch (_error) {
      }
      // 变焦范围（会话级）：硬件支持则走相机变焦，否则解码/显示层软件变焦兜底
      try {
        this.zoomRange = this.session.getZoomRatioRange()
        this.session.setZoomRatio(1)
      } catch (_error) {
        this.zoomRange = [1, 1]
      }
      this.systemZoom = this.zoomRange.length >= 2 && this.zoomRange[1] > this.zoomRange[0]
      this.cameraStarting = false
    } catch (error) {
      const businessError = error as BusinessError
      this.status = `${stage}失败 (${businessError.code})`
      console.error(`OpenHarmony camera stage ${stage} failed: ${businessError.code}`)
      await this.releaseCamera()
      this.cameraStarting = false
    }
  }

  // 预览档位选择：最接近 1280×720（16:9）的一档，取景满幅、解码量适中
  private pickPreviewProfile(profiles: camera.Profile[]): camera.Profile {
    let best = profiles[0]
    let bestGap = Number.MAX_VALUE
    for (let i = 0; i < profiles.length; i++) {
      const w = profiles[i].size.width
      const h = profiles[i].size.height
      const gap = Math.abs(w * 9 - h * 16) + Math.abs(w - 1280)
      if (gap < bestGap) {
        bestGap = gap
        best = profiles[i]
      }
    }
    return best
  }

  // 双指捏合缩放：硬件变焦优先；不支持时软件变焦（视觉放大 + 解码中心裁剪）
  private applyZoom(scale: number): void {
    const max = this.systemZoom ? this.zoomRange[1] : 5
    const ratio = Math.min(max, Math.max(1, this.gestureBaseZoom * scale))
    if (this.systemZoom && this.session !== undefined) {
      try {
        this.session.setZoomRatio(ratio)
      } catch (_error) {
      }
    }
    this.zoomRatio = Math.round(ratio * 10) / 10
  }

  // 软件变焦：从 Y 平面裁出中心 1/ratio 区域（含行跨度处理）
  private cropYPlane(yuv: Uint8ClampedArray, width: number, height: number, stride: number): Uint8ClampedArray {
    const cw = Math.floor(width / this.zoomRatio)
    const ch = Math.floor(height / this.zoomRatio)
    const x0 = Math.floor((width - cw) / 2)
    const y0 = Math.floor((height - ch) / 2)
    const out = new Uint8ClampedArray(cw * ch)
    for (let y = 0; y < ch; y++) {
      const src = (y0 + y) * stride + x0
      out.set(yuv.subarray(src, src + cw), y * cw)
    }
    return out
  }

  // 排空最新帧：节流/解码占用时不读帧会让接收队列积满、预览流帧率崩塌
  private async drainFrame(): Promise<void> {
    try {
      const img = await this.imageReceiver?.readLatestImage()
      try {
        await img?.release()
      } catch (_error) {
      }
    } catch (_error) {
    }
  }

  // 帧到达即读最新帧投递后台解码；reading 防重入，节流控制解码频率
  private async onFrameArrival(): Promise<void> {
    if (this.stopped || this.imageReceiver === undefined) {
      return
    }
    if (this.reading) {
      await this.drainFrame()
      return
    }
    this.reading = true
    let captured: image.Image | undefined = undefined
    try {
      const now = Date.now()
      if (now - this.lastDecodeAt < 50) {
        await this.drainFrame()
        return
      }
      this.lastDecodeAt = now
      captured = await this.imageReceiver.readLatestImage()
      if (this.stopped || captured === undefined) {
        return
      }
      const component = await captured.getComponent(image.ComponentType.JPEG)
      const width = captured.size.width
      const height = captured.size.height
      const stride = component.rowStride > 0 ? component.rowStride : width
      const yuv = new Uint8ClampedArray(component.byteBuffer)
      await captured.release()
      captured = undefined
      const plane = !this.systemZoom && this.zoomRatio > 1
        ? this.cropYPlane(yuv, width, height, stride) : yuv
      const planeWidth = plane === yuv ? width : Math.floor(width / this.zoomRatio)
      const planeHeight = plane === yuv ? height : Math.floor(height / this.zoomRatio)
      const task = new taskpool.Task(decodeQrFast, plane, planeWidth, planeHeight,
        plane === yuv ? stride : planeWidth, this.frameSeq % 3 === 0)
      this.frameSeq++
      task.setTransferList([plane.buffer])
      const decodeStart = Date.now()
      const text = await taskpool.execute(task) as string
      console.info(`OH scan decode ${Date.now() - decodeStart}ms plane=${planeWidth}x${planeHeight} hit=${text !== ''}`)
      if (!this.stopped && text !== '') {
        this.stopCamera()
        this.onResult(text)
      }
    } catch (_error) {
      // 无码帧属正常轮询；相机异常已在 startCamera 上报
    } finally {
      if (captured !== undefined) {
        try {
          await captured.release()
        } catch (_error) {
        }
      }
      this.reading = false
    }
  }

  private async releaseCamera(): Promise<void> {
    try {
      await this.session?.stop()
    } catch (_error) {
    }
    try {
      await this.session?.release()
    } catch (_error) {
    }
    try {
      await this.frameOutput?.release()
    } catch (_error) {
    }
    try {
      await this.previewOutput?.release()
    } catch (_error) {
    }
    try {
      await this.cameraInput?.close()
    } catch (_error) {
    }
    try {
      await this.imageReceiver?.release()
    } catch (_error) {
    }
    this.session = undefined
    this.frameOutput = undefined
    this.previewOutput = undefined
    this.cameraInput = undefined
    this.imageReceiver = undefined
  }

  private async stopCamera(): Promise<void> {
    if (this.stopped) {
      return
    }
    this.stopped = true
    this.permissionGranted = false
    await this.releaseCamera()
  }

  build() {
    Stack() {
      XComponent({ id: 'uia_oh_qr_camera', type: XComponentType.SURFACE, controller: this.xController })
        .width('100%')
        .height('100%')
        .onLoad((): void => {
          this.surfaceId = this.xController.getXComponentSurfaceId()
          this.xController.setXComponentSurfaceSize({
            surfaceWidth: 1280,
            surfaceHeight: 720
          })
          if (this.permissionGranted) {
            this.startCamera()
          }
        })
        // 软件变焦的视觉放大：硬件不支持时直接放大取景画面（中心锚点）
        .scale({
          x: this.systemZoom ? 1 : this.zoomRatio,
          y: this.systemZoom ? 1 : this.zoomRatio,
          centerX: '50%',
          centerY: '50%'
        })
      Column({ space: 16 }) {
        Text('扫描二维码')
          .fontSize(20)
          .fontWeight(FontWeight.Medium)
          .fontColor(Color.White)
        Text(this.zoomRatio > 1 ? `${this.status} ×${this.zoomRatio}` : this.status)
          .fontSize(14)
          .fontColor(Color.White)
        Button('取消')
          .onClick((): void => this.onClose())
      }
      .width('100%')
      .height('100%')
      .justifyContent(FlexAlign.SpaceBetween)
      .padding({ top: 48, bottom: 48 })
      .backgroundColor(Color.Transparent)
    }
    .width('100%')
    .height('100%')
    // 双指捏合缩放绑在整个弹层容器上：全屏任意位置可捏合，按钮点击不受影响
    .gesture(PinchGesture({ fingers: 2 })
      .onActionStart((event: GestureEvent): void => {
        this.gestureBaseZoom = this.zoomRatio
      })
      .onActionUpdate((event: GestureEvent): void => {
        this.applyZoom(event.scale)
      }))
  }
}
