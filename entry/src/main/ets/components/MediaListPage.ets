import { hostOf } from '../common/SearchEngines'
import { DownloadCoordinator } from '../common/Downloads'
import { AppSettings } from '../common/Settings'
import { common, Want } from '@kit.AbilityKit'
import { SettingsHeader } from './SettingsHeader'
import { ViaIcon } from './ViaIcon'

@ComponentV2
export struct MediaListPage {
  @Param mediaUrls: string[] = []
  @Event onClose: () => void = () => {
  }
  @Local playingUrl: string = ''
  private settings: AppSettings = AppSettings.getInstance()
  private videoController: VideoController = new VideoController()

  build() {
    Column() {
      SettingsHeader({
        headerTitle: '媒体资源',
        rightText: this.mediaUrls.length > 0 ? `${this.mediaUrls.length} 个` : '',
        onBack: () => {
          this.close()
        }
      })

      if (this.playingUrl !== '') {
        Video({ src: this.playingUrl, controller: this.videoController })
          .autoPlay(true)
          .controls(true)
          .width('100%')
          .height(220)
          .objectFit(ImageFit.Contain)
          .backgroundColor(Color.Black)
      }

      if (this.mediaUrls.length === 0) {
        Column({ space: 10 }) {
          ViaIcon({ icon: $r('app.media.via_ic_download'), iconSize: 40, iconColor: $r('app.color.fg_tertiary') })
          Text('当前页面没有嗅探到媒体资源')
            .fontSize(14)
            .fontColor($r('app.color.fg_secondary'))
        }
        .width('100%')
        .layoutWeight(1)
        .justifyContent(FlexAlign.Center)
      } else {
        List({ space: 1 }) {
          ForEach(this.mediaUrls, (url: string) => {
            ListItem() {
              Row({ space: 12 }) {
                Text(this.mediaType(url))
                  .fontSize(11)
                  .fontColor($r('app.color.accent'))
                  .padding({ left: 8, right: 8, top: 3, bottom: 3 })
                  .backgroundColor($r('app.color.chip_bg'))
                  .borderRadius(6)
                Column({ space: 3 }) {
                  Text(this.mediaName(url))
                    .fontSize(14)
                    .fontColor(this.playingUrl === url ? $r('app.color.accent') : $r('app.color.fg'))
                    .maxLines(1)
                    .textOverflow({ overflow: TextOverflow.Ellipsis })
                  Text(hostOf(url))
                    .fontSize(11)
                    .fontColor($r('app.color.fg_secondary'))
                    .maxLines(1)
                }
                .alignItems(HorizontalAlign.Start)
                .layoutWeight(1)

                ViaIcon({ icon: $r('app.media.via_ic_download'), iconSize: 20, iconColor: $r('app.color.icon') })
                  .width(36)
                  .height(36)
                  .onClick(() => {
                    this.download(url)
                  })
              }
              .width('100%')
              .padding({ left: 16, right: 12, top: 10, bottom: 10 })
              .alignItems(VerticalAlign.Center)
              .onClick(() => {
                this.play(url)
              })
            }
          }, (url: string) => url)
        }
        .width('100%')
        .layoutWeight(1)
      }
    }
    .width('100%')
    .height('100%')
    .backgroundColor($r('app.color.page_bg'))
  }

  private play(url: string): void {
    if (this.settings.externalPlayer) {
      this.playExternal(url)
      return
    }
    if (this.playingUrl === url) {
      return
    }
    try {
      this.videoController.stop()
    } catch (error) {
      console.error('stop previous media failed')
    }
    this.playingUrl = url
  }

  private playExternal(url: string): void {
    const context = this.getUIContext().getHostContext() as common.UIAbilityContext
    const mime = this.mediaType(url) === '音频' ? 'audio/*' : 'video/*'
    const want: Want = {
      action: 'ohos.want.action.viewData',
      uri: url,
      type: mime
    }
    context.startAbility(want).catch(() => {
      this.getUIContext().getPromptAction().showToast({ message: '没有可用的外置播放器', duration: 1500 })
    })
  }

  private close(): void {
    try {
      this.videoController.stop()
    } catch (error) {
      console.error('stop media failed')
    }
    this.playingUrl = ''
    this.onClose()
  }

  private download(url: string): void {
    const context = getContext(this) as Context
    DownloadCoordinator.getInstance().startUrlDownload(context, url).then(() => {
      this.getUIContext().getPromptAction().showToast({ message: $r('app.string.download_started'), duration: 1500 })
    }).catch(() => {
      console.error('media download failed')
    })
  }

  private mediaName(url: string): string {
    const queryIndex = url.indexOf('?')
    const clean = queryIndex >= 0 ? url.substring(0, queryIndex) : url
    const slashIndex = clean.lastIndexOf('/')
    const name = slashIndex >= 0 ? clean.substring(slashIndex + 1) : clean
    return name !== '' ? name : hostOf(url)
  }

  private mediaType(url: string): string {
    const queryIndex = url.indexOf('?')
    const path = (queryIndex >= 0 ? url.substring(0, queryIndex) : url).toLowerCase()
    if (path.endsWith('.m3u8') || path.endsWith('.mpd')) {
      return '直播'
    }
    if (path.endsWith('.mp3') || path.endsWith('.m4a') || path.endsWith('.aac') || path.endsWith('.ogg')) {
      return '音频'
    }
    return '视频'
  }
}
