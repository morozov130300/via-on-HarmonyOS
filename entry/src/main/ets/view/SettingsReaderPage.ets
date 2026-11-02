import { AppSettings } from '../common/Settings'
import { SettingCheckRow, SettingNavRow } from '../components/SettingRows'
import { AppBar, AppBarSpacer } from '../components/AppBar'
import { i18n } from '@kit.LocalizationKit'
import { ConfigurationConstant, common } from '@kit.AbilityKit'

// 原版 g8/j.java:18 f6283d 主题底色（ARGB int）
// 0 表示默认主题（原版 GradientDrawable.setColor(0) 即透明圆点）
const READER_THEME_ARG_BS: number[] = [0, -462365, -4133433, -11908531, -15592942]

// 原版 g6/y.java G(i10, -16777216, 0.3f)：暗色下每个通道 = ch * 0.3（截断）
function blendDotColorToDark(argb: number): string {
  if (argb === 0) {
    return '#00000000'
  }
  const r = Math.floor(((argb >> 16) & 255) * 0.3)
  const g = Math.floor(((argb >> 8) & 255) * 0.3)
  const b = Math.floor((argb & 255) * 0.3)
  const toHex = (v: number): string => v.toString(16).padStart(2, '0')
  return `#${toHex(r)}${toHex(g)}${toHex(b)}`
}

function dotColorOf(argb: number, isDark: boolean): string {
  if (argb === 0) {
    return '#00000000'
  }
  return isDark ? blendDotColorToDark(argb) : `#${(argb & 0xFFFFFF).toString(16).padStart(6, '0')}`
}

@ComponentV2
export struct SettingsReaderPage {
  private settings: AppSettings = AppSettings.getInstance()
  private navPathStack: NavPathStack = new NavPathStack()

  private isDarkMode(): boolean {
    try {
      const ctx = this.getUIContext().getHostContext() as common.UIAbilityContext
      return ctx.config.colorMode === ConfigurationConstant.ColorMode.COLOR_MODE_DARK
    } catch (error) {
      return false
    }
  }

  // 原版 z8/f.c()：中文环境预览文案
  private fontPreviewText(): string {
    const lang = i18n.System.getSystemLanguage()
    return lang.startsWith('zh') ? '莫忆世事兼身事，须著人间比梦间。' : 'Less is more.'
  }

  private bindAppBar(): void {
    AppBar.show({
      title: '阅读模式',
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        Scroll() {
          Column() {
            // 原版 hb/o5：row1 = 二次确认开关（rp=开启阅读模式需要二次确认，
            // 副标题 rr/rq 随开合切换：开=先展示菜单、关=开启阅读模式）
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

            // 原版 hb/o5：外观（主题点阵 g8.j）+ 自定义阅读模式 CSS
            Text($r('app.string.appearance'))
              .fontSize(13)
              .fontColor($r('app.color.accent'))
              .width('100%')
              .padding({ left: 16, right: 16, top: 18, bottom: 8 })
            Row({ space: 14 }) {
              ForEach(READER_THEME_ARG_BS, (argb: number, index: number) => {
                Column()
                  .width(52)
                  .height(30)
                  .backgroundColor(dotColorOf(argb, this.isDarkMode()))
                  .borderRadius(15)
                  .border({
                    width: this.settings.readerTheme === index ? 2 : 0.5,
                    color: this.settings.readerTheme === index ? $r('app.color.accent') : $r('app.color.fg_tertiary')
                  })
                  .animation({ duration: 150 })
                  .onClick(() => {
                    this.settings.setReaderTheme(index)
                  })
              }, (argb: number) => argb.toString())
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
                min: 10,
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
            // 原版 ib.x + z8/f.c()：字体预览文案（中文=「莫忆世事兼身事，须著人间比梦间。」，否则 Less is more.）
            Column({ space: 2 }) {
              Text(this.fontPreviewText())
                .fontSize(this.settings.readerFontSize)
                .fontColor($r('app.color.fg'))
                .width('100%')
                .padding({ left: 16, right: 16 })
                .maxLines(2)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
            }
            .margin({ top: 4 })

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
export function SettingsReaderPageBuilder() {
  SettingsReaderPage()
}
