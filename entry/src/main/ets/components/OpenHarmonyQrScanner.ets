import camera from '@ohos.multimedia.camera'
import image from '@ohos.multimedia.image'
import { BarcodeFormat, decodeFromYUV } from '@ohos/zxing'
import { abilityAccessCtrl, common, Permissions } from '@kit.AbilityKit'
import { BusinessError } from '@kit.BasicServicesKit'
import { taskpool } from '@kit.ArkTS'

// OpenHarmony 设备专用扫码器：预览流经 ImageReceiver 直取 Y 平面，taskpool 后台解码；
// 库内 decodeFromYUV 覆盖 Hybrid/Global 二值化 × 正/反色 × 旋转，无需自行管理读码器
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

  // 帧到达即读最新帧投递后台解码；reading 防重入，节流控制解码频率
  private async onFrameArrival(): Promise<void> {
    if (this.stopped || this.reading || this.imageReceiver === undefined) {
      return
    }
    this.reading = true
    let captured: image.Image | undefined = undefined
    try {
      const now = Date.now()
      if (now - this.lastDecodeAt < 100) {
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
      const task = new taskpool.Task(decodeFromYUV, plane, planeWidth, planeHeight,
        plane === yuv ? stride : planeWidth, [BarcodeFormat.QR_CODE])
      task.setTransferList([plane.buffer])
      const text = await taskpool.execute(task) as string
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
