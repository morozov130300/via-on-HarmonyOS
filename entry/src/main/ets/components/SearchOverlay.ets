import { http } from '@kit.NetworkKit'
import { pasteboard } from '@kit.BasicServicesKit'
import { abilityAccessCtrl, Permissions } from '@kit.AbilityKit'
import { scanBarcode } from '@kit.ScanKit'
import { AppSettings } from '../common/Settings'
import { TabStore } from '../common/TabStore'
import { buildSearchUrl, isUrlLike, normalizeUrl } from '../common/SearchEngines'
import { AppIcon } from './AppIcon'
import { ViaIcon } from './ViaIcon'

const SUGGEST_URL_PREFIX: string = 'https://suggestion.baidu.com/su?action=opensearch&wd='
const HISTORY_LIMIT: number = 8

@ComponentV2
export struct SearchOverlay {
  @Event onClose: () => void = () => {}
  @Param initialText: string = ''
  @Local inputText: string = ''
  @Local suggestions: string[] = []
  @Local pasteText: string = ''
  private settings: AppSettings = AppSettings.getInstance()
  private tabStore: TabStore = TabStore.getInstance()
  private textController: TextInputController = new TextInputController()
  private timerId: number = -1
  private currentRequest: http.HttpRequest | null = null

  aboutToAppear(): void {
    this.inputText = this.initialText
    this.readClipboard()
  }

  private async readClipboard(): Promise<void> {
    try {
      const context = this.getUIContext().getHostContext()
      if (context === undefined) {
        return
      }
      const atManager = abilityAccessCtrl.createAtManager()
      const perms: Permissions[] = ['ohos.permission.READ_PASTEBOARD']
      const result = await atManager.requestPermissionsFromUser(context, perms)
      if (!result.authResults.includes(0)) {
        return
      }
      const data = await pasteboard.getSystemPasteboard().getData()
      if (data.getRecordCount() > 0) {
        const text = data.getPrimaryText()
        if (typeof text === 'string' && text.trim() !== '') {
          this.pasteText = text.trim().substring(0, 120)
        }
      }
    } catch (error) {
      console.error('read clipboard failed')
    }
  }

  aboutToDisappear(): void {
    this.cancelPending()
    if (this.currentRequest !== null) {
      this.currentRequest.destroy()
      this.currentRequest = null
    }
  }

  build() {
    Column() {
      Row({ space: 10 }) {
        AppIcon({ icon: $r('sys.symbol.chevron_left'), iconSize: 24 })
          .onClick(() => {
            this.onClose()
          })
        TextInput({ text: this.inputText, placeholder: $r('app.string.search_or_type_url'), controller: this.textController })
          .layoutWeight(1)
          .height(40)
          .fontSize(15)
          .backgroundColor($r('app.color.surface'))
          .fontColor($r('app.color.fg'))
          .placeholderColor($r('app.color.fg_secondary'))
          .caretColor($r('app.color.accent'))
          .enterKeyType(EnterKeyType.Search)
          .defaultFocus(true)
          .onChange((value: string) => {
            this.inputText = value
            this.fetchSuggestions(value)
          })
          .onSubmit((enterKey: EnterKeyType) => {
            this.commit(this.inputText)
          })
        ViaIcon({ icon: $r('app.media.via_ic_scan'), iconSize: 22, iconColor: $r('app.color.fg_secondary') })
          .onClick(() => {
            this.startScan()
          })
        Text($r('app.string.cancel'))
          .fontSize(15)
          .fontColor($r('app.color.fg'))
          .onClick(() => {
            this.onClose()
          })
      }
      .width('100%')
      .padding({ left: 14, right: 14, top: 10 })

      Scroll() {
        Column() {
          if (this.inputText.trim() !== '' && isUrlLike(this.inputText)) {
            this.EntryRow($r('sys.symbol.link'), this.inputText.trim(), () => {
              this.commit(this.inputText)
            })
          }
          ForEach(this.suggestions, (suggestion: string, index: number) => {
            this.EntryRow($r('sys.symbol.magnifyingglass'), suggestion, () => {
              this.commit(suggestion)
            })
          }, (suggestion: string, index: number) => `${suggestion}_${index}`)
          if (this.inputText.trim() === '' && this.pasteText !== '') {
            Row({ space: 12 }) {
              AppIcon({ icon: $r('sys.symbol.doc_plaintext'), iconSize: 18, iconColor: $r('app.color.fg_secondary') })
              Column({ space: 2 }) {
                Text($r('app.string.paste_and_go'))
                  .fontSize(13)
                  .fontColor($r('app.color.fg_secondary'))
                Text(this.pasteText)
                  .fontSize(15)
                  .fontColor($r('app.color.fg'))
                  .maxLines(1)
                  .textOverflow({ overflow: TextOverflow.Ellipsis })
              }
              .alignItems(HorizontalAlign.Start)
              .layoutWeight(1)
            }
            .width('100%')
            .height(52)
            .padding({ left: 16, right: 16 })
            .onClick(() => {
              this.commit(this.pasteText)
            })
          }
          if (this.suggestions.length === 0 && this.inputText.trim() === '') {
            Row() {
              Text($r('app.string.search_history'))
                .fontSize(13)
                .fontColor($r('app.color.fg_secondary'))
              Blank()
              if (this.settings.searchHistory.length > 0) {
                Text($r('app.string.clear_search_history'))
                  .fontSize(13)
                  .fontColor($r('app.color.fg_secondary'))
                  .onClick(() => {
                    this.settings.clearSearchHistory()
                  })
              }
            }
            .width('100%')
            .padding({ left: 16, right: 16, top: 14, bottom: 6 })

            ForEach(this.settings.searchHistory, (query: string, index: number) => {
              if (index < HISTORY_LIMIT) {
                this.EntryRow($r('sys.symbol.clock'), query, () => {
                  this.commit(query)
                })
              }
            }, (query: string, index: number) => `${query}_${index}`)
          }
        }
        .width('100%')
      }
      .layoutWeight(1)
      .align(Alignment.Top)
    }
    .width('100%')
    .height('100%')
    .backgroundColor($r('app.color.page_bg'))
  }

  @Builder
  EntryRow(icon: Resource, text: string, action: () => void) {
    Row({ space: 12 }) {
      AppIcon({ icon: icon, iconSize: 18, iconColor: $r('app.color.fg_secondary') })
      Text(text)
        .fontSize(15)
        .fontColor($r('app.color.fg'))
        .maxLines(1)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .layoutWeight(1)
    }
    .width('100%')
    .height(46)
    .padding({ left: 16, right: 16 })
    .onClick(() => {
      action()
    })
  }

  private commit(text: string): void {
    const input = text.trim()
    if (input === '') {
      return
    }
    let target: string
    if (isUrlLike(input)) {
      target = normalizeUrl(input)
    } else {
      this.settings.addSearchHistory(input)
      target = buildSearchUrl(this.settings.engineKey, this.settings.customEngineTemplate, input)
    }
    this.tabStore.navigate(target)
    this.onClose()
  }

  private startScan(): void {
    const context = this.getUIContext().getHostContext()
    if (context === undefined) {
      return
    }
    scanBarcode.startScanForResult(context).then((data: scanBarcode.ScanResult) => {
      const scanned = data.originalValue.trim()
      if (scanned !== '') {
        this.commit(scanned)
      }
    }).catch((error: BusinessError) => {
      console.error(`scan failed: ${error.code}`)
    })
  }

  private cancelPending(): void {
    if (this.timerId !== -1) {
      clearTimeout(this.timerId)
      this.timerId = -1
    }
  }

  private fetchSuggestions(query: string): void {
    this.cancelPending()
    const text = query.trim()
    if (text === '') {
      this.suggestions = []
      return
    }
    this.timerId = setTimeout(() => {
      this.requestSuggestions(text)
    }, 200)
  }

  private requestSuggestions(query: string): void {
    if (this.currentRequest !== null) {
      this.currentRequest.destroy()
      this.currentRequest = null
    }
    const request: http.HttpRequest = http.createHttp()
    this.currentRequest = request
    request.request(SUGGEST_URL_PREFIX + encodeURIComponent(query), {
      method: http.RequestMethod.GET,
      connectTimeout: 5000,
      readTimeout: 5000,
      usingCache: false
    }).then((response: http.HttpResponse) => {
      if (this.currentRequest !== request) {
        return
      }
      this.currentRequest = null
      this.parseSuggestions(response)
      request.destroy()
    }).catch((error: BusinessError) => {
      if (this.currentRequest === request) {
        this.currentRequest = null
        this.suggestions = []
      }
      request.destroy()
    })
  }

  private parseSuggestions(response: http.HttpResponse): void {
    this.suggestions = []
    const body = response.result
    if (typeof body !== 'string') {
      return
    }
    try {
      const parsed = JSON.parse(body) as Object[]
      if (parsed.length < 2) {
        return
      }
      const words = parsed[1]
      if (!Array.isArray(words)) {
        return
      }
      const wordsArray = words as Object[]
      const list: string[] = []
      for (let i = 0; i < wordsArray.length && list.length < 8; i++) {
        const word = wordsArray[i]
        if (typeof word === 'string') {
          list.push(word)
        }
      }
      this.suggestions = list
    } catch (error) {
      console.error('parse suggestions failed')
    }
  }
}
