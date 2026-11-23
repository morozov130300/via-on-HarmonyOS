import { AppBar, AppBarSpacer } from '../components/AppBar'
import { NetworkLogEntry, TabItem } from '../common/Types'
import { TabStore } from '../common/TabStore'
import { buildNavSlide } from './PageTransitions'

class NetLogSelectOption {
  value: string

  constructor(value: string) {
    this.value = value
  }
}

class NetLogFilterOption {
  label: string
  value: string

  constructor(label: string, value: string) {
    this.label = label
    this.value = value
  }
}

const NET_LOG_SELECT_OPTIONS: NetLogSelectOption[] = [
  new NetLogSelectOption('All'),
  new NetLogSelectOption('JS'),
  new NetLogSelectOption('CSS'),
  new NetLogSelectOption('Image'),
  new NetLogSelectOption('Blocked'),
  new NetLogSelectOption('Other')
]

const NET_LOG_FILTERS: NetLogFilterOption[] = [
  new NetLogFilterOption('All', ''),
  new NetLogFilterOption('JS', 'js'),
  new NetLogFilterOption('CSS', 'css'),
  new NetLogFilterOption('Image', 'ico|png|jpg|gif|jpeg|webp|svg|avif'),
  new NetLogFilterOption('Blocked', 'block'),
  new NetLogFilterOption('Other', '~js|css|ico|png|jpg|gif|jpeg|webp|svg|avif|block')
]

@ComponentV2
export struct NetLogPage {
  private navPathStack: NavPathStack = new NavPathStack()
  private tabStore: TabStore = TabStore.getInstance()
  @Local tab: TabItem = this.tabStore.current()
  @Local filterIndex: number = 0
  @Local slideOffset: string = '0'

  private bindAppBar(): void {
    AppBar.show({
      title: $r('app.string.net_log'),
      onBack: () => {
        this.navPathStack.pop()
      }
    }, this)
  }

  private isVisible(entry: NetworkLogEntry): boolean {
    const selected = NET_LOG_FILTERS[this.filterIndex]
    if (selected.value === '') {
      return true
    }
    const inverted = selected.value.startsWith('~')
    const expression = inverted ? selected.value.substring(1) : selected.value
    const rules = expression.split('|')
    let matched = false
    const itemTitle = `${entry.blocked ? 'block' : 'load'}${entry.resourceType}`
    for (let i = 0; i < rules.length; i++) {
      if (itemTitle.indexOf(rules[i]) >= 0) {
        matched = true
        break
      }
    }
    return inverted !== matched
  }

  private formatTime(timestamp: number): string {
    const date = new Date(timestamp)
    const hours = String(date.getHours()).padStart(2, '0')
    const minutes = String(date.getMinutes()).padStart(2, '0')
    const seconds = String(date.getSeconds()).padStart(2, '0')
    return `${hours}:${minutes}:${seconds}`
  }

  build() {
    NavDestination() {
      Column() {
        AppBarSpacer()
        if (this.tab.networkLogs.length > 0) {
          Select(NET_LOG_SELECT_OPTIONS)
            .selected(this.filterIndex)
            .fontColor($r('app.color.fg'))
            .backgroundColor($r('app.color.page_bg'))
            .width('100%')
            .padding({ left: 10, right: 10, top: 6, bottom: 6 })
            .onSelect((index: number, value?: string) => {
              this.filterIndex = index
            })
          Divider().strokeWidth(0.5).color($r('app.color.divider'))
        }
        if (this.tab.networkLogs.length === 0) {
          Column() {
            Text($r('app.string.empty_page_placeholder'))
              .fontSize(14)
              .fontColor($r('app.color.fg_secondary'))
          }
          .width('100%')
          .layoutWeight(1)
          .justifyContent(FlexAlign.Center)
        } else {
          List({ space: 0 }) {
            ForEach(this.tab.networkLogs.slice(Math.max(0, this.tab.networkLogs.length - 64)).reverse(), (entry: NetworkLogEntry) => {
              if (this.isVisible(entry)) {
                ListItem() {
                  Column({ space: 5 }) {
                    Row({ space: 8 }) {
                      Text(entry.blocked ? 'block' : 'load')
                        .fontSize(12)
                        .fontColor(Color.White)
                        .backgroundColor(entry.blocked ? '#CD8282' : '#5C91CB')
                        .padding({ left: 6, right: 6, top: 1, bottom: 1 })
                      if (entry.resourceType !== '') {
                        Text(entry.resourceType)
                          .fontSize(12)
                          .fontColor(Color.White)
                          .backgroundColor('#5C91CB')
                          .padding({ left: 6, right: 6, top: 1, bottom: 1 })
                      }
                      Blank()
                      Text(this.formatTime(entry.timestamp))
                        .fontSize(11)
                        .fontColor($r('app.color.fg_tertiary'))
                    }
                    .width('100%')
                    Text(entry.url)
                      .fontSize(13)
                      .fontColor($r('app.color.fg'))
                      .maxLines(3)
                      .textOverflow({ overflow: TextOverflow.Ellipsis })
                      .width('100%')
                  }
                  .width('100%')
                  .padding({ left: 10, right: 10, top: 10, bottom: 10 })
                  .opacity(entry.blocked ? 0.5 : 1)
                  .onClick(() => {
                    this.navPathStack.pop()
                    this.tabStore.navigate(entry.url)
                  })
                }
              }
            }, (entry: NetworkLogEntry) => `${entry.id}-${entry.url}`)
          }
          .width('100%')
          .layoutWeight(1)
          .divider({ strokeWidth: 0.5, color: $r('app.color.divider') })
        }
      }
      .width('100%')
      .height('100%')
    }
    .hideTitleBar(true)
    .backgroundColor($r('app.color.page_bg'))
    .translate({ x: this.slideOffset })
    .customTransition((operation: NavigationOperation, isEnter: boolean):
      Array<NavDestinationTransition> | undefined => {
      return buildNavSlide(operation, isEnter, (value: string): void => {
        this.slideOffset = value
      })
    })
    .onReady((ctx: NavDestinationContext) => {
      this.navPathStack = ctx.pathStack
      this.tab = this.tabStore.current()
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
export function NetLogPageBuilder() {
  NetLogPage()
}
