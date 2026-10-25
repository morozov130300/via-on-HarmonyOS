import { image } from '@kit.ImageKit'
import { generateBarcode, scanCore } from '@kit.ScanKit'
import { AppIcon } from './AppIcon'

@ComponentV2
export struct QrDialog {
  @Param @Require url: string
  @Event onClose: () => void = () => {}
  @Local qrImage: image.PixelMap | null = null
  @Local failed: boolean = false

  aboutToAppear(): void {
    this.generate()
  }

  build() {
    Column() {
      Column({ space: 16 }) {
        Text($r('app.string.qr_code'))
          .fontSize(16)
          .fontWeight(FontWeight.Bold)
          .fontColor($r('app.color.fg'))
        if (this.qrImage !== null) {
          Image(this.qrImage)
            .width(240)
            .height(240)
            .backgroundColor(Color.White)
            .borderRadius(8)
            .padding(8)
        } else if (this.failed) {
          Text($r('app.string.page_failed_load'))
            .fontSize(14)
            .fontColor($r('app.color.fg_secondary'))
        } else {
          LoadingProgress()
            .width(48)
            .height(48)
            .color($r('app.color.accent'))
        }
        Text(this.url)
          .fontSize(12)
          .fontColor($r('app.color.fg_secondary'))
          .maxLines(2)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
          .textAlign(TextAlign.Center)
        Button($r('app.string.cancel'))
          .fontSize(14)
          .height(36)
          .width(120)
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            this.onClose()
          })
      }
      .width('80%')
      .padding(20)
      .borderRadius(16)
      .backgroundColor($r('app.color.page_bg'))
    }
    .width('100%')
    .height('100%')
    .justifyContent(FlexAlign.Center)
    .backgroundColor('rgba(0,0,0,0.5)')
    .onClick(() => {
      this.onClose()
    })
  }

  private generate(): void {
    const options: generateBarcode.CreateOptions = {
      scanType: scanCore.ScanType.QR_CODE,
      height: 480,
      width: 480
    }
    generateBarcode.createBarcode(this.url, options)
      .then((pixelMap: image.PixelMap) => {
        this.qrImage = pixelMap
      })
      .catch((error: BusinessError) => {
        console.error(`create barcode failed: ${error.message}`)
        this.failed = true
      })
  }
}
