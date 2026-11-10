import { common, Want } from '@kit.AbilityKit'
import { buildNavSlide } from './PageTransitions'

interface LicenseEntry {
  name: string
  license: string
  url: string
}

// 原版 hb/j4.java:21-41 共 21 项：名称带作者后缀，VasDolly=BSD 3-Clause，
// Viewer.js / translate=MIT，其余 Apache License 2.0；每行点击 z8.b0.P 跳 GitHub URL。
const LICENSES: LicenseEntry[] = [
  { name: 'AndroidX - AndroidX', license: 'Apache License 2.0', url: 'https://github.com/androidx/androidx' },
  { name: 'Dagger - Google', license: 'Apache License 2.0', url: 'https://github.com/google/dagger' },
  { name: 'RxJava - ReactiveX', license: 'Apache License 2.0', url: 'https://github.com/ReactiveX/RxJava' },
  { name: 'RxAndroid - ReactiveX', license: 'Apache License 2.0', url: 'https://github.com/ReactiveX/RxAndroid' },
  { name: 'AutoDispose - Uber', license: 'Apache License 2.0', url: 'https://github.com/uber/AutoDispose' },
  { name: 'OkHttp - Square', license: 'Apache License 2.0', url: 'https://github.com/square/okhttp' },
  { name: 'LeakCanary - Square', license: 'Apache License 2.0', url: 'https://github.com/square/leakcanary/' },
  { name: 'AndResGuard - shwenzhang', license: 'Apache License 2.0', url: 'https://github.com/shwenzhang/AndResGuard' },
  { name: 'VasDolly - Tencent', license: 'BSD 3-Clause License', url: 'https://github.com/Tencent/VasDolly' },
  { name: 'Timber - Jake Wharton', license: 'Apache License 2.0', url: 'https://github.com/JakeWharton/timber' },
  { name: 'TinyPinyin - promeG', license: 'Apache License 2.0', url: 'https://github.com/promeG/TinyPinyin' },
  { name: 'ZXing - ZXing', license: 'Apache License 2.0', url: 'https://github.com/zxing/zxing' },
  { name: 'okhttp-digest - rburgst', license: 'Apache License 2.0', url: 'https://github.com/rburgst/okhttp-digest' },
  { name: 'sardine-android - The Grizzly Labs', license: 'Apache License 2.0', url: 'https://github.com/thegrizzlylabs/sardine-android' },
  { name: 'AutoUnfold - AirBashX', license: 'Apache License 2.0', url: 'https://github.com/AirBashX/UserScript' },
  { name: 'readability - mozilla', license: 'Apache License 2.0', url: 'https://github.com/mozilla/readability' },
  { name: 'drag-select-recyclerview - afollestad', license: 'Apache License 2.0', url: 'https://github.com/afollestad/drag-select-recyclerview' },
  { name: 'Viewer.js - Chen Fengyuan', license: 'MIT License', url: 'https://github.com/fengyuanchen/viewerjs' },
  { name: 'translate - xnx3', license: 'MIT License', url: 'https://github.com/xnx3/translate' },
  { name: 'okhttp-eventsource - LaunchDarkly', license: 'Apache License 2.0', url: 'https://github.com/launchdarkly/okhttp-eventsource' },
  { name: 'Markwon - Dimitry', license: 'Apache License 2.0', url: 'https://github.com/noties/Markwon' }
]

@ComponentV2
export struct LicensePage {
  // g6/i.java:67 的 anim/f..i 左右推入转场：本页横向偏移由转场 delegate 驱动
  @Local slideOffset: string = '0'

  build() {
    NavDestination() {
      Scroll() {
        Column() {
          ForEach(LICENSES, (entry: LicenseEntry) => {
            Row() {
              Text(entry.name)
                .fontSize(15)
                .fontColor($r('app.color.fg'))
                .maxLines(1)
                .layoutWeight(1)
              Text(entry.license)
                .fontSize(13)
                .fontColor($r('app.color.fg_secondary'))
                .maxLines(1)
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 13, bottom: 13 })
            .alignItems(VerticalAlign.Center)
            // 原版 z8/b0.P：点击每行打开对应开源项目 URL
            .onClick(() => {
              // 原版 z8/b0.P：点击每行打开对应开源项目 URL（工程内既有 Want 写法）
              const context = this.getUIContext().getHostContext() as common.UIAbilityContext
              const want: Want = {
                action: 'ohos.want.action.viewData',
                entities: ['entity.system.browsable'],
                uri: entry.url
              }
              context.startAbility(want).catch(() => {})
            })
          }, (entry: LicenseEntry) => entry.name)
        }
        .width('100%')
      }
      .width('100%')
      .height('100%')
      .align(Alignment.Top)
    }
    .backgroundColor($r('app.color.page_bg'))
    .hideTitleBar(true)
    .translate({ x: this.slideOffset })
    // 原版 g6/i.java:67 = setCustomAnimations(anim/f, anim/g, anim/h, anim/i)，
    // 时长 integer/b=220、accelerate_decelerate —— 改用鸿蒙原生 NavDestination 转场接口
    .customTransition((operation: NavigationOperation, isEnter: boolean):
      Array<NavDestinationTransition> | undefined => {
      return buildNavSlide(operation, isEnter, (value: string): void => {
        this.slideOffset = value
      })
    })
    .title('开源许可协议')
  }
}

@Builder
export function LicensePageBuilder() {
  LicensePage()
}
