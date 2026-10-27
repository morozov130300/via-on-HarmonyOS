import { AppSettings } from './Settings'
import { hostOf } from './SearchEngines'

const BUILTIN_BLOCK: string[] = [
  'doubleclick.net', 'googleadservices.com', 'googlesyndication.com', 'googletagservices.com',
  'google-analytics.com', 'googletagmanager.com', 'adsystem.com', 'adservice.google.com',
  'analytics.google.com', 'admeld.com', 'admob.com', 'ads.yahoo.com', 'adtechus.com', 'adtech.de',
  'adnxs.com', 'adroll.com', 'adsafeprotected.com', 'criteo.com', 'criteo.net', 'casalemedia.com',
  'chartbeat.com', 'chartbeat.net', 'comscore.com', 'scorecardresearch.com', 'quantserve.com',
  'quantcount.com', 'pubmatic.com', 'rubiconproject.com', 'openx.net', 'adsrvr.org', 'indexww.com',
  '33across.com', 'sharethrough.com', 'sonobi.com', 'smartadserver.com', 'adform.net', 'yieldmo.com',
  'media.net', 'mediavine.com', 'outbrain.com', 'taboola.com', 'revcontent.com', 'mgid.com',
  'zedo.com', 'bidswitch.net', 'moatads.com', 'doubleverify.com', 'mopub.com', 'chartboost.com',
  'vungle.com', 'unityads.unity3d.com', 'applovin.com', 'ironsrc.com', 'adcolony.com', 'inmobi.com',
  'inmobi.cn', 'an.facebook.com', 'facebook.net', 'static.ads-twitter.com', 'analytics.twitter.com',
  'ads.tiktok.com', 'analytics.tiktok.com', 'sc-static.net', 'ct.pinterest.com', 'px.ads.linkedin.com',
  'mc.yandex.ru', 'adfox.ru', 'adriver.ru',
  'pos.baidu.com', 'cpro.baidu.com', 'mobads.baidu.com', 'ad.baidu.com', 'hm.baidu.com',
  'union-click.baidu.com', 'union.baidu.com', 'tongji.baidu.com', 'tanx.com', 'alimama.com',
  'atpanel.com', 'beacon.qq.com', 'pgv.qq.com', 'win.gdt.qq.com', 't.gdt.qq.com', 'gdt.qq.com',
  'adsmind.ugdtimg.com', 'tencentads.com', 'ad.toutiao.com', 'dsp.toutiao.com', 'ad.oceanengine.com',
  'applog.snssdk.com', 'log.snssdk.com', 'huichuan.sm.cn', 'sinaads.com', 'adview.cn', 'adsmogo.cn',
  'youmi.net', 'domob.cn', 'madhouse.cn', 'adsage.com', 'baifendian.com', 'adsame.com', 'admaster.com',
  'miaozhen.com', 'ipinyou.com', 'mediav.com', 'growingio.com', 'sensorsdata.cn', 'talkingdata.com',
  'adv.sec.miui.com', 'ad.xiaomi.com', 'tracking.miui.com',
  'umeng.com', 'umeng.co', 'umengcloud.com', 'umtrack.com', 'mmstat.com', 'cnzz.com', '51.la',
  'mixpanel.com', 'hotjar.com', 'amplitude.com', 'heapanalytics.com', 'kissmetrics.io',
  'mouseflow.com', 'luckyorange.com', 'fullstory.com', 'clicktale.com', 'inspectlet.com',
  'crazyegg.com', 'clarity.ms', 'js-agent.newrelic.com', 'segment.io', 'imrworldwide.com'
]

export class AdBlocker {
  private static instance: AdBlocker | null = null
  private settings: AppSettings | null = null
  private builtinSet: Set<string> = new Set<string>()
  private customBlockSet: Set<string> = new Set<string>()
  private customAllowSet: Set<string> = new Set<string>()
  private subBlockSet: Set<string> = new Set<string>()
  private subAllowSet: Set<string> = new Set<string>()

  private constructor() {
    for (let i = 0; i < BUILTIN_BLOCK.length; i++) {
      this.builtinSet.add(BUILTIN_BLOCK[i])
    }
  }

  static getInstance(): AdBlocker {
    if (AdBlocker.instance === null) {
      AdBlocker.instance = new AdBlocker()
    }
    return AdBlocker.instance
  }

  init(settings: AppSettings): void {
    this.settings = settings
    this.rebuildCustomRules()
  }

  rebuildCustomRules(): void {
    this.customBlockSet.clear()
    this.customAllowSet.clear()
    if (this.settings === null) {
      return
    }
    const rules = this.settings.customRules
    for (let i = 0; i < rules.length; i++) {
      const domain = rules[i].domain.trim().toLowerCase()
      if (domain === '') {
        continue
      }
      if (rules[i].isAllow) {
        this.customAllowSet.add(domain)
      } else {
        this.customBlockSet.add(domain)
      }
    }
  }

  setSubscriptionRules(blocks: Set<string>, allows: Set<string>): void {
    this.subBlockSet = blocks
    this.subAllowSet = allows
  }

  private matches(host: string, ruleSet: Set<string>): boolean {
    let current = host
    while (true) {
      if (ruleSet.has(current)) {
        return true
      }
      const dotIndex = current.indexOf('.')
      if (dotIndex < 0) {
        return false
      }
      current = current.substring(dotIndex + 1)
    }
  }

  shouldBlock(requestUrl: string, pageHost: string): boolean {
    if (this.settings === null || !this.settings.adBlockOn) {
      return false
    }
    const pageSetting = this.settings.getSiteSetting(pageHost)
    if (pageSetting !== null && pageSetting.allowAds) {
      return false
    }
    const host = hostOf(requestUrl)
    if (host === '') {
      return false
    }
    if (this.matches(host, this.customAllowSet)) {
      return false
    }
    if (this.matches(host, this.subAllowSet)) {
      return false
    }
    if (this.matches(host, this.customBlockSet)) {
      return true
    }
    if (this.matches(host, this.subBlockSet)) {
      return true
    }
    if (this.settings.adBlockBuiltin && this.matches(host, this.builtinSet)) {
      return true
    }
    return false
  }
}
