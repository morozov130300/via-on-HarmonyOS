import { i18n } from '@kit.LocalizationKit'
import { engineIdFromKey } from './SearchEngines'

// 原版翻译注入链路 1:1 复刻（i6/f0.java + i6/e0.java + na.a2/b2）：
//   · 页内翻译（谷歌）  na.a2 → f0.f(webView, url, t1.g()) → e0.a(langs, fallback)
//   · 页内翻译（微软）  na.b2 → f0.g(webView, url, t1.g()) → e0.b(lang, fallback)
//   · 百度翻译网页      f0.a(url, lang)
//   · 谷歌翻译网页      f0.c(url, lang)
// 两段注入脚本末尾都挂 securitypolicyviolation 监听：一旦页面 CSP 拦掉翻译脚本，
// 立刻执行 fallback（向宿主 postMessage action=108），由宿主回落到「翻译」菜单
// （原版 k6.java postMessage case 108 → break → Db(false)，即不含微软/谷歌页内两项的菜单）。

// 原版 z8/t1.i()：语言的方言/历史代码归一（仅这五项有映射，其余原样返回）
function legacyLanguageCode(language: string): string {
  switch (language) {
    case 'in':
      return 'id'
    case 'iw':
      return 'he'
    case 'ji':
      return 'yi'
    case 'jw':
      return 'jv'
    case 'tl':
      return 'fil'
    default:
      return language
  }
}

// 原版 z8/t1.n(Locale)：language[-COUNTRY]。系统语言可能是 zh-Hans-CN 三段，
// 原版 Locale.getCountry() 只取地区，故这里丢弃 4 字符脚本子标签，仅保留 2 字母地区。
function translateLangTag(lang: string): string {
  if (lang === '') {
    return ''
  }
  const parts = lang.split('-')
  const language = legacyLanguageCode(parts[0].toLowerCase())
  let region = ''
  for (let i = 1; i < parts.length; i++) {
    if (parts[i].length === 2) {
      region = parts[i].toUpperCase()
    }
  }
  return region === '' ? language : `${language}-${region}`
}

// 原版 z8/t1.g()
export function translateTargetLang(): string {
  let raw = 'zh-CN'
  try {
    raw = i18n.System.getSystemLanguage()
  } catch (error) {
    raw = 'zh-CN'
  }
  const tag = translateLangTag(raw)
  return tag === '' ? 'zh-CN' : tag
}

// 原版 i6/f0.e()：'-' 前的短语言码
export function translateShortLang(lang: string): string {
  const dash = lang.indexOf('-')
  return dash > 0 ? lang.substring(0, dash) : lang
}

// 原版 i6/f0.f() 的 includedLanguages 表：中文环境仅列 12 种，其余列全表。
// 注意原表逐字保留（含 id/in、js 两个历史项），不可擅自去重。
const TR_GOOGLE_LANGS_ZH: string[] = [
  'en', 'ar', 'ja', 'ko', 'ru', 'fr', 'de', 'es', 'it', 'pt', 'zh-CN', 'zh-TW'
]
const TR_GOOGLE_LANGS_ALL: string[] = [
  'en', 'ar', 'az', 'be', 'bn', 'cs', 'da', 'de', 'es', 'fa', 'fil', 'fr', 'hi', 'hr', 'hu', 'id',
  'in', 'it', 'js', 'ko', 'lt', 'ne', 'pl', 'pt', 'pt-BR', 'ro', 'ru', 'sk', 'sl', 'ta', 'th', 'tr',
  'uk', 'uz', 'vi', 'zh-CN', 'zh-TW'
]

// 原版 i6/f0.f()：目标语言从表里移除后插到首位，再以 ',' 连接
function googleIncludedLanguages(lang: string): string {
  const list: string[] = []
  const source = lang.startsWith('zh-') ? TR_GOOGLE_LANGS_ZH : TR_GOOGLE_LANGS_ALL
  for (let i = 0; i < source.length; i++) {
    if (source[i] !== lang) {
      list.push(source[i])
    }
  }
  list.unshift(lang)
  return list.join(',')
}

// 原版 i6/f0.b()：CSP 回落脚本（经 window.via 桥回传宿主，action=108）。
// 本端桥名统一为 uia，且宿主桥不校验 secret，故只需回传 JSON。
function cspFallbackJs(): string {
  return `window.uia.postMessage(JSON.stringify({action:108}))`
}

// 原版 i6/e0.a()：谷歌页内翻译（Google element.js + showBanner）
export function buildGooglePageTranslateJs(): string {
  const lang = translateTargetLang()
  const langs = googleIncludedLanguages(lang)
  const fallback = cspFallbackJs()
  return '(function(){'
    + 'if(window.__via_translator__)window.__via_translator__.showBanner(!0);'
    + 'else{'
    + 'window.googleTranslateElementInit=function(){'
    + 'window.__via_translator__||(window.__via_translator__=new google.translate.TranslateElement({'
    + `autoDisplay:!1,floatPosition:0,multilanguagePage:!0,includedLanguages:"${langs}",pageLanguage:"auto"}));`
    + 'window.__via_translator__.showBanner(!0)};'
    + 'var e=document.createElement("script");'
    + 'e.src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit";'
    + 'document.getElementsByTagName("head")[0].appendChild(e)}'
    + 'document.addEventListener("securitypolicyviolation",function e(n){'
    + `${fallback};document.removeEventListener("securitypolicyviolation",e)})`
    + '})();'
}

// 原版 i6/e0.b()：微软页内翻译（xnx3/translate.js，client.edge）
export function buildEdgePageTranslateJs(): string {
  const lang = translateTargetLang()
  const fallback = cspFallbackJs()
  return '(function(){'
    + 'var e="via-translate-bridge",t=document.getElementById(e);'
    + 'if(t)if("undefined"!=typeof translate)'
    + `"${lang}"!=translate.to&&translate.changeLanguage("${lang}");`
    + 'else{var n=document.createElement("script");n.id=e;n.src=t.src;n.onload=t.onload;'
    + 't.parentNode.replaceChild(n,t)}'
    + 'else{(t=document.createElement("script")).id=e;'
    + 't.src="https://fastly.jsdelivr.net/gh/xnx3/translate@v3.14.0/translate.js/translate.min.js";'
    + 't.onload=function(){translate.selectLanguageTag.show=!1;'
    + `translate.service.use("client.edge");translate.changeLanguage("${lang}")};`
    + 'document.head.appendChild(t)}'
    + 'document.addEventListener("securitypolicyviolation",function e(t){'
    + `${fallback};document.removeEventListener("securitypolicyviolation",e)})`
    + '})();'
}

// 原版 i6/f0.a()：百度翻译网页（to 用短语言码，query 用 percent-encoding）
export function buildBaiduPageTranslateUrl(url: string): string {
  const encoded = encodeURIComponent(url)
  const short = translateShortLang(translateTargetLang())
  return `https://fanyi.baidu.com/transpage?query=${encoded}&source=url&ie=utf8&from=auto&to=${short}&render=1`
}

// 原版 i6/f0.c()：谷歌翻译网页（tl 用完整语言码）
export function buildGooglePageTranslateUrl(url: string): string {
  const encoded = encodeURIComponent(url)
  return `https://translate.google.com/translate?sl=auto&tl=${translateTargetLang()}&u=${encoded}`
}

// 原版 na.Z1()（k6.ra case15 → f2580m0.Z1()）：
//   引擎 search2 != -1（非谷歌）→ b2() 微软 client.edge；== -1（谷歌）→ a2() 谷歌 element.js。
export function buildAutoPageTranslateJs(engineKey: string): string {
  const id = engineIdFromKey(engineKey)
  return id === -1 ? buildGooglePageTranslateJs() : buildEdgePageTranslateJs()
}
