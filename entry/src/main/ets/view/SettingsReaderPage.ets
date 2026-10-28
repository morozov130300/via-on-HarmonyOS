import { AppSettings } from '../common/Settings'
import { SettingCheckRow, SettingNavRow } from '../components/SettingRows'
import { SettingsHeader } from '../components/SettingsHeader'

class ReaderThemeDef {
  bg: string
  fg: string

  constructor(bg: string, fg: string) {
    this.bg = bg
    this.fg = fg
  }
}

const READER_THEMES: ReaderThemeDef[] = [
  new ReaderThemeDef('#121212', '#BEBEBE'),
  new ReaderThemeDef('#7C766B', '#1C1C1C'),
  new ReaderThemeDef('#4C5F50', '#E4E9E4'),
  new ReaderThemeDef('#2E2E30', '#C9C9C9'),
  new ReaderThemeDef('#050505', '#9C9C9C')
]

@ComponentV2
export struct SettingsReaderPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  build() {
    NavDestination() {
      Column() {
        SettingsHeader({
          headerTitle: '阅读模式',
          onBack: () => {
            this.navPathStack.pop()
          }
        })
        Scroll() {
          Column() {
            SettingCheckRow({
              rowLabel: $r('app.string.reader_confirm'),
              rowDesc: this.settings.readerConfirm
                ? $r('app.string.reader_confirm_desc_on')
                : $r('app.string.reader_confirm_desc_off'),
              isChecked: this.settings.readerConfirm,
              onCheckRow: (isOn: boolean) => {
                this.settings.setReaderConfirm(isOn)
              }
            })

            Text($r('app.string.appearance'))
              .fontSize(13)
              .fontColor($r('app.color.accent'))
              .width('100%')
              .padding({ left: 16, right: 16, top: 18, bottom: 8 })
            Row({ space: 14 }) {
              ForEach(READER_THEMES, (theme: ReaderThemeDef, index: number) => {
                Column()
                  .width(52)
                  .height(30)
                  .backgroundColor(theme.bg)
                  .borderRadius(15)
                  .border({
                    width: this.settings.readerTheme === index ? 2 : 0.5,
                    color: this.settings.readerTheme === index ? $r('app.color.accent') : $r('app.color.fg_tertiary')
                  })
                  .animation({ duration: 150 })
                  .onClick(() => {
                    this.settings.setReaderTheme(index)
                  })
              }, (theme: ReaderThemeDef) => theme.bg)
            }
            .width('100%')
            .padding({ left: 16, right: 16 })

            Text($r('app.string.font_size'))
              .fontSize(15)
              .fontColor($r('app.color.fg'))
              .width('100%')
              .padding({ left: 16, right: 16, top: 20 })
            Row() {
              Text(`${this.settings.readerFontSize}px`)
                .fontSize(13)
                .fontColor($r('app.color.fg'))
                .width(44)
              Slider({
                value: this.settings.readerFontSize,
                min: 9,
                max: 30,
                step: 1,
                style: SliderStyle.OutSet
              })
                .layoutWeight(1)
                .selectedColor($r('app.color.accent'))
                .trackColor($r('app.color.divider'))
                .blockColor($r('app.color.accent'))
                .onChange((value: number, mode: SliderChangeMode) => {
                  if (mode === SliderChangeMode.End || mode === SliderChangeMode.Click) {
                    this.settings.setReaderFontSize(Math.round(value))
                  }
                })
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 4 })

            Row() {
              Text($r('app.string.reader_sample_text'))
                .fontSize(this.settings.readerFontSize)
                .fontColor(READER_THEMES[this.settings.readerTheme].fg)
                .animation({ duration: 120 })
            }
            .width('100%')
            .padding(16)
            .margin({ left: 0, right: 0, top: 10 })
            .backgroundColor(READER_THEMES[this.settings.readerTheme].bg)
            .borderRadius(10)
            .animation({ duration: 150 })

            SettingNavRow({
              rowLabel: $r('app.string.custom_reader_css'),
              onTapRow: () => {
                this.navPathStack.pushPathByName('readerCss', '', true)
              }
            })
            .margin({ top: 14 })
          }
          .width('100%')
        }
        .width('100%')
        .layoutWeight(1)
        .align(Alignment.Top)
      }
      .width('100%')
      .height('100%')
    }
    .backgroundColor($r('app.color.page_bg'))
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
    })
  }
}

@Builder
export function SettingsReaderPageBuilder() {
  SettingsReaderPage()
}
