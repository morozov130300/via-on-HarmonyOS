import { SearchEngineDef } from '../common/SearchEngines'
import { computeDialogWidthVp, dialogTransition } from './ViaDialogCard'

@ComponentV2
export struct SearchEngineDialog {
  @Param @Require title: ResourceStr
  @Param @Require items: SearchEngineDef[]
  @Param @Require selectedKey: string
  @Event onSelect: (key: string) => void = (_key: string): void => {}

  build() {
    Column() {
      Text(this.title)
        .fontSize(16)
        .fontWeight(FontWeight.Bold)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .width('100%')
        .padding({ top: 8, bottom: 8 })
        .margin({ left: 16, right: 16, bottom: 6 })

      Scroll() {
        Column() {
          ForEach(this.items, (item: SearchEngineDef) => {
            Row({ space: 24 }) {
              Circle({ width: 16, height: 16 })
                .fill(this.selectedKey === item.key ? $r('app.color.accent') : Color.Transparent)
                .stroke(this.selectedKey === item.key ? Color.Transparent : $r('app.color.dialog_border'))
                .strokeWidth(2)
              Text(item.name)
                .fontSize(14)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
                .layoutWeight(1)
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 12, bottom: 12 })
            .onClick(() => {
              this.onSelect(item.key)
            })
          }, (item: SearchEngineDef) => item.key)
        }
        .width('100%')
      }
      .constraintSize({ maxHeight: 384 })
    }
    .width(computeDialogWidthVp())
    .padding({ top: 12, bottom: 12 })
    .backgroundColor($r('app.color.dialog_bg'))
    .borderRadius(18)
    .border({ width: 1, color: $r('app.color.dialog_border') })
    .transition(dialogTransition())
  }
}
