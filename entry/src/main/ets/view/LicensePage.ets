class LicenseEntry {
  name: string
  license: string

  constructor(name: string, license: string) {
    this.name = name
    this.license = license
  }
}

const LICENSES: LicenseEntry[] = [
  new LicenseEntry('Dagger', 'Apache License 2.0'),
  new LicenseEntry('OkHttp', 'Apache License 2.0'),
  new LicenseEntry('Markwon', 'Apache License 2.0'),
  new LicenseEntry('RxJava', 'Apache License 2.0'),
  new LicenseEntry('VasDolly', 'Apache License 2.0'),
  new LicenseEntry('AutoDispose', 'Apache License 2.0'),
  new LicenseEntry('AndroidX', 'Apache License 2.0'),
  new LicenseEntry('TinyPinyin', 'Apache License 2.0'),
  new LicenseEntry('translate.js', 'Apache License 2.0')
]

@ComponentV2
export struct LicensePage {
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
          }, (entry: LicenseEntry) => entry.name)
        }
        .width('100%')
      }
      .width('100%')
      .height('100%')
      .align(Alignment.Top)
    }
    .backgroundColor($r('app.color.page_bg'))
    .title('开源许可协议')
  }
}

@Builder
export function LicensePageBuilder() {
  LicensePage()
}
