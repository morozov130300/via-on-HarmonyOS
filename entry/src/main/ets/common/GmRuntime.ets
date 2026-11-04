// GM_* 用户脚本运行时 1:1 移植（原版 i6/j0.js 生成器、o5/a.java 分派桥、o5/b+c.java
// GM_xmlhttpRequest、n5/a.java 注入入口、p5 变量存储语义）
import { util } from '@kit.ArkTS'
import { http } from '@kit.NetworkKit'
import { preferences } from '@kit.ArkData'
import { BusinessError } from '@kit.BasicServicesKit'
import { common } from '@kit.AbilityKit'
import { fileIo } from '@kit.CoreFileKit'
import { hilog } from '@kit.PerformanceAnalysisKit'
import { AppSettings } from './Settings'
import { UserScriptRec } from './Types'
import { startScriptsAutoUpdate } from './ScriptUpdater'

const TAG = 'GmRuntime'
const DOMAIN = 0x0000

// 原版 n5/a.f10198c：进程级 secret（UUID），桥校验用
const GM_SECRET: string = util.generateRandomUUID(false)

export function gmSecret(): string {
  return GM_SECRET
}

// ===================== i6/j0.java JS 生成器（1:1） =====================

// j0.k()：标识符清洗（仅字母数字下划线）
export function gmSanitizeIdent(str: string): string {
  let result = ''
  for (let i = 0; i < str.length; i++) {
    const c = str.charAt(i)
    if (('A' <= c && c < '[') || ('a' <= c && c < '{') || ('0' <= c && c < ':') || c === '_') {
      result += c
    }
  }
  return result
}

// j0.a()：5 参调用 JS（含 identifier）
function gmCall5(secret: string, fn: string, identifier: string, name: string, argsJson: string | null): string {
  const args = argsJson === null ? '{}' : argsJson
  return `window.${fn}(JSON.stringify({secret:'${secret}', identifier:'${identifier}', name:'${name}', ` +
    `'arguments':${args}}), '${secret}')`
}

// j0.b()：4 参调用 JS（无 identifier，假 Tampermonkey 专用）
function gmCall4(secret: string, fn: string, name: string, argsJson: string | null): string {
  const args = argsJson === null ? '{}' : argsJson
  return `window.${fn}(JSON.stringify({secret:'${secret}', name:'${name}', 'arguments':${args}}), '${secret}')`
}

// j0.h()：window.<fn> 绑定到 via_gm.call（缺失时回退 window.prompt）
function gmBindNativeJs(fn: string): string {
  return `if(!window.${fn}) {const nativePrompt = window.via_gm && window.via_gm.call ? ` +
    `window.via_gm.call.bind(window.via_gm) : window.prompt;` +
    `Object.defineProperty(window, '${fn}', {value: nativePrompt,writable: false,configurable: false,enumerable: true});}`
}

// j0.e()：GM_<api> 别名
function gmAliasJs(fn: string, api: string): string {
  return `var GM_${api} = ${fn};\n`
}

// j0.f()：GM.<api> 绑定（promiseWrap 时包 Promise）
function gmDotJs(fn: string, api: string, params: string, promiseWrap: boolean): string {
  if (!promiseWrap) {
    return `GM.${api} = ${fn};\n`
  }
  return `GM.${api} = function(${params}) { return new Promise(function(resolve, reject) { ` +
    `resolve(${fn}(${params}));});};\n`
}

// j0.g()：函数生成
function gmFnJs(name: string, params: string | null, body: string | null): string {
  if (name === null || name.length === 0) {
    return ''
  }
  const p = params === null ? '' : params
  const b = body === null ? '' : body
  return `var ${name} = function(${p}) { ${b} };\n`
}

// j0.d()：假 Tampermonkey（greasyfork 等脚本站注入）
export function gmFakeTampermonkeyJs(secret: string): string {
  const fn = gmSanitizeIdent('NP_' + secret)
  return `(function () {let key = 'via-fake-tampermonkey';if (window[key]) {return;};` +
    `${gmBindNativeJs(fn)}` +
    `try {window[key] = true;window.external.Tampermonkey = {` +
    `getVersion: function(e) {e({version:'4.5.1', id: 'Via'});},` +
    `openOptions: function(e, t) {${gmCall4(secret, fn, 'openOptions', '{name: e, namespace: t}')};},` +
    `isInstalled: function(e, t, n) {var v = ${gmCall4(secret, fn, 'isInstalled', '{name: e, namespace: t}')};` +
    `if(v === 'undefined') { return; };try {v = JSON.parse(v);} catch(e) {};n(v);}}} catch (err) {}})();`
}

// j0.i()：回调包装 JS（responseType 解码后调 unsafeWindow.<callback>(obj)）
export function gmCallbackJs(callbacks: string[] | null, quotedJson: string | null): string | null {
  if (callbacks === null || callbacks.length === 0) {
    return null
  }
  let calls = ''
  for (let i = 0; i < callbacks.length; i++) {
    const cb = callbacks[i]
    if (cb !== null && cb.length !== 0) {
      calls += `unsafeWindow.${cb}(obj);`
    }
  }
  if (calls.length === 0) {
    return null
  }
  const obj = (quotedJson === null || quotedJson.length === 0) ? 'undefined' : `JSON.parse(${quotedJson})`
  return `javascript: (function() { var obj = ${obj};` +
    `if (obj && obj.responseType) {var type = obj.responseType;` +
    `if (type == 'undefined') { obj.responseType = undefined; obj.response = obj.responseText; }` +
    `else if (type == 'json') { try { obj.response = JSON.parse(obj.responseText); }catch(e){} }` +
    `else if (type == 'document') { try { obj.response = new DOMParser().parseFromString(obj.responseText, 'text/html'); }catch(e){} }` +
    `else if (type == 'blob' || type == 'arraybuffer' || type == 'stream') {if (obj.responseDataUrl) {` +
    `const [metadata, data] = obj.responseDataUrl.split(',');const mime = metadata.match(/data:([^;]+)/)[1];` +
    `const decodedData = atob(data);delete obj.responseDataUrl;obj.responseText = decodedData;` +
    `const bytes = new Uint8Array(decodedData.length);for (let i = 0; i < decodedData.length; i++) {bytes[i] = decodedData.charCodeAt(i);}` +
    `if ('blob' == type) { obj.response = new Blob([bytes], { type: mime }); }` +
    `else if ('stream' == type) { obj.response = new ReadableStream({start(controller) {controller.enqueue(bytes);}, pull(controller) {controller.close();}, cancel() {}}); }` +
    `else { obj.response = bytes.buffer; }}}else { obj.response = obj.responseText; }}${calls}})();`
}

// j0.j()：枚举 window[secret]['gm_menus']（返回 {scriptId: [names]} JSON）
export function gmMenusJs(secret: string): string {
  return `javascript:var es = window['${secret}']['gm_menus'];result = {};` +
    `for (var k in es) {var items = es[k];var list = [];for (var i in items) {list.push(i);}result[k] = list;}` +
    `JSON.stringify(result);`
}

// 原版 n5/c.b（sa/i1.b）：菜单命令调用 JS
export function gmMenuInvokeJs(secret: string, scriptId: string, name: string): string {
  return `javascript:window[${JSON.stringify(secret)}]['gm_menus'][${JSON.stringify(scriptId)}][` +
    `${JSON.stringify(name)}]();`
}

// j0.c()：GM 沙盒 JS（按 grant 位生成 API 集）
export function gmSandboxJs(scriptId: string, secret: string, grant: number): string {
  const p = gmSanitizeIdent('GM_' + secret + '_')
  const np = gmSanitizeIdent('NP_' + secret)
  let s = `const GM = {};\n${gmBindNativeJs(np)}` +
    `const ${p}info = function() {let cached; const obj = {}; ` +
    `Object.defineProperty(obj, 'VALUE', {get: function() {if (cached == undefined) ` +
    `{cached = JSON.parse(${gmCall5(secret, np, scriptId, 'info', null)});} return cached;}, ` +
    `configurable: false, enumerable: true}); return obj;}();\n` +
    `const GM_info = ${p}info.VALUE;\n` +
    `GM.info = ${p}info.VALUE;\n`
  if (grant === 0) {
    return s
  }
  let stringify = 'JSON.stringify'
  let parse = 'JSON.parse'
  if ((10485763 & grant) !== 0) {
    const sfn = p + 'JSONStringify'
    const pfn = p + 'JSONParse'
    s = s + gmFnJs(sfn, 'v',
      `return JSON.stringify(v,function(k,v){if(typeof v==='bigint'){return undefined}` +
      `if(v instanceof Number){return '{}';}if(v!==v){return 'NaN'}if(v===Infinity){return 'Infinity'}` +
      `if(v===-Infinity){return '-Infinity'}return v});`) +
      gmFnJs(pfn, 'v',
        `return JSON.parse(v,function(k,v){if(v==='{}'){return {}}if(v==='NaN'){return NaN}` +
        `if(v==='Infinity'){return Infinity}if(v==='-Infinity'){return -Infinity}return v});`)
    stringify = sfn
    parse = pfn
  }
  // setValue（掩码 8388609）
  if ((8388609 & grant) !== 0) {
    const fn = p + 'setValue'
    let seg = s + gmFnJs(fn, 'name, value',
      `v = value; try {v = ${stringify}(v);} catch(e) {};` +
      `${gmCall5(secret, np, scriptId, 'setValue', '{name: name, value: v}')};`)
    if ((grant & 1) === 1) {
      seg = seg + gmAliasJs(fn, 'setValue') +
        `var GM_setValues=function(a){if(a)for(var b in a)GM_setValue(b,a[b])};\n`
    }
    s = seg
    if ((grant & 8388608) === 8388608) {
      s = s + gmDotJs(fn, 'setValue', 'name, value', true) +
        `GM.setValues=function(a){return new Promise(function(c,d){if(a){for(var b in a)` +
        `${fn}(b,a[b]);c()}else d("No data")})};\n`
    }
  }
  // getValue（掩码 2097154）
  if ((2097154 & grant) !== 0) {
    const fn = p + 'getValue'
    let seg = s + gmFnJs(fn, 'name, defaultValue',
      `var dv = defaultValue;try {dv = ${stringify}(defaultValue);} catch(e) {};` +
      `var v = ${gmCall5(secret, np, scriptId, 'getValue', '{name: name, value: dv}')};` +
      `if(v == 'undefined') { return undefined; };try {v = ${parse}(v);} catch(e) {};return v;`)
    if ((grant & 2) === 2) {
      seg = seg + gmAliasJs(fn, 'getValue') +
        `var GM_getValues=function(b){var c={};if(!b)return c;if(Array.isArray(b))` +
        `for(var a in b)c[a]=GM_getValue(a);else for(a in b)c[a]=GM_getValue(a,b[a]);return c};\n`
    }
    s = seg
    if ((grant & 2097152) === 2097152) {
      s = s + gmDotJs(fn, 'getValue', 'name, defaultValue', true) +
        `GM.getValues=function(a){return new Promise(function(d,c){if(a){c={};if(!a)return d({});` +
        `if(Array.isArray(a))for(var b in a)c[b]=${fn}(b);else for(b in a)c[b]=${fn}(b,a[b]);d(c)}` +
        `else c("No data")})};\n`
    }
  }
  // deleteValue（掩码 1048584）
  if ((1048584 & grant) !== 0) {
    const fn = p + 'deleteValue'
    let seg = s + gmFnJs(fn, 'name', `${gmCall5(secret, np, scriptId, 'deleteValue', '{name: name}')};`)
    if ((grant & 8) === 8) {
      seg = seg + gmAliasJs(fn, 'deleteValue') +
        `var GM_deleteValues=function(a){if(a&&"number"===typeof a.length)` +
        `for(var b=0,c=a.length;b<c;b++)try{GM_deleteValue(a[b])}catch(d){}};\n`
    }
    s = seg
    if ((grant & 1048576) === 1048576) {
      s = s + gmDotJs(fn, 'deleteValue', 'name', true) +
        `GM.deleteValues=function(b){return new Promise(function(c,a){if(b&&"number"===typeof b.length)` +
        `{a=0;for(var d=b.length;a<d;a++)try{${fn}(b[a])}catch(e){}c()}else a("No array")})};\n`
    }
  }
  // listValues（掩码 4194308）
  if ((4194308 & grant) !== 0) {
    const fn = p + 'listValues'
    let seg = s + gmFnJs(fn, '',
      `var s = ${gmCall5(secret, np, scriptId, 'listValues', null)};return s.split(",");`)
    if ((grant & 4) === 4) {
      seg = seg + gmAliasJs(fn, 'listValues')
    }
    s = seg
    if ((grant & 4194304) === 4194304) {
      s = s + gmDotJs(fn, 'listValues', '', true)
    }
  }
  // addElement（掩码 33554560）
  if ((33554560 & grant) !== 0) {
    const fn = p + 'addElement'
    let seg = s + gmFnJs(fn, 'parent, tag, attrs, callback',
      `if (typeof parent === 'string') { return GM_addElement(undefined, parent, tag || {}, attrs); }` +
      `var e = document.createElement(tag);if (attrs) {for (var k in attrs) { ` +
      `if (k == 'textContent') { e.textContent = attrs[k]; continue; }; ` +
      `try{e.setAttribute(k, attrs[k]);}catch(e){} };};` +
      `if (parent == undefined && document) { parent = document.head; }` +
      `if (parent) { parent.appendChild(e); };if (callback) { callback() }return e;`)
    if ((grant & 128) === 128) {
      seg = seg + gmAliasJs(fn, 'addElement')
    }
    s = seg
    if ((grant & 33554432) === 33554432) {
      s = s + gmDotJs(fn, 'addElement', 'parent, tag, attrs, callback', true)
    }
  }
  // addStyle（掩码 16777280）
  if ((16777280 & grant) !== 0) {
    const fn = p + 'addStyle'
    let seg = s + gmFnJs(fn, 'css, callback',
      `if (!css) { return; };var h = document.getElementsByTagName('head')[0];if (!h) { return; };` +
      `var e = document.createElement('style');e.type = 'text/css';e.textContent = css;` +
      `h.appendChild(e);if (callback) { callback() }return e;`)
    if ((grant & 64) === 64) {
      seg = seg + gmAliasJs(fn, 'addStyle')
    }
    s = seg
    if ((grant & 16777216) === 16777216) {
      s = s + gmDotJs(fn, 'addStyle', 'css, callback', true)
    }
  }
  // log（位 512）
  if ((grant & 512) === 512) {
    s = s + `var GM_log = function(message) {` +
      `${gmCall5(secret, np, scriptId, 'log', '{message: message}')}};\n`
  }
  // getResourceURL（掩码 67108880）
  if ((67108880 & grant) !== 0) {
    const fn = p + 'getResourceURL'
    let seg = s + gmFnJs(fn, 'resourceName',
      `var r = ${gmCall5(secret, np, scriptId, 'getResourceURL', '{resource: resourceName}')};` +
      `if (r === 'undefined') {return null} return r;`)
    if ((grant & 16) === 16) {
      seg = seg + gmAliasJs(fn, 'getResourceURL')
    }
    s = seg
    if ((grant & 67108864) === 67108864) {
      s = s + gmDotJs(fn, 'getResourceUrl', 'resourceName', true)
    }
  }
  // getResourceText（位 32）
  if ((grant & 32) !== 0) {
    const fn = p + 'getResourceText'
    s = s + gmFnJs(fn, 'resourceName',
      `var r = ${gmCall5(secret, np, scriptId, 'getResourceText', '{resource: resourceName}')};` +
      `if (r === 'undefined') {return null} return r;`)
    if ((grant & 32) === 32) {
      s = s + gmAliasJs(fn, 'getResourceText')
    }
  }
  // setClipboard（掩码 1073742848）
  if ((1073742848 & grant) !== 0) {
    const fn = p + 'setClipboard'
    let seg = s + gmFnJs(fn, 'data, type',
      `${gmCall5(secret, np, scriptId, 'setClipboard', '{data: data, type: type}')};`)
    if ((grant & 1024) === 1024) {
      seg = seg + gmAliasJs(fn, 'setClipboard')
    }
    s = seg
    if ((grant & 1073741824) === 1073741824) {
      s = s + gmDotJs(fn, 'setClipboard', 'data, type', false)
    }
  }
  // download（位 2048）
  if ((grant & 2048) === 2048) {
    s = s + `var GM_download = function(url, name) {if ((typeof url) == 'object') ` +
      `{name = url.name;url = url.url;};if (!name) { name = ''; };` +
      `${gmCall5(secret, np, scriptId, 'download', '{url: url, name: name}')};};\n`
  }
  // xmlhttpRequest（掩码 -2147483392）
  if ((-2147483392 & grant) !== 0) {
    s = s + `unsafeWindow = (function() { if(window){return window;} try {var el = ` +
      `document.createElement('p'); el.setAttribute('onclick', 'return window;'); ` +
      `return el.onclick();}catch(e){return window;} }()); window.wrappedJSObject = unsafeWindow;\n` +
      `var generateRandomString=function(c){for(var a="",b=0;b<c;b++)` +
      `a+="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(Math.floor(62*Math.random()));` +
      `return a};\n`
    const fn = p + 'xmlhttpRequest'
    const v = gmSanitizeIdent('V_' + scriptId + util.generateRandomUUID(false) + '_')
    let seg = s + gmFnJs(fn, 'details',
      `var identifier = generateRandomString(8);` +
      `if (details.onabort) { unsafeWindow[identifier+'${v}GM_onAbortCallback'] = details.onabort;` +
      `details.onabort = identifier+'${v}GM_onAbortCallback'; }` +
      `if (details.onerror) { unsafeWindow[identifier+'${v}GM_onErrorCallback'] = details.onerror;` +
      `details.onerror = identifier+'${v}GM_onErrorCallback'; }` +
      `if (details.onload) { unsafeWindow[identifier+'${v}GM_onLoadCallback'] = details.onload;` +
      `details.onload = identifier+'${v}GM_onLoadCallback'; }` +
      `if (details.onloadstart) { unsafeWindow[identifier+'${v}GM_onLoadStartCallback'] = details.onloadstart;` +
      `details.onloadstart = identifier+'${v}GM_onLoadStartCallback'; }` +
      `if (details.onprogress) { unsafeWindow[identifier+'${v}GM_onProgressCallback'] = details.onprogress;` +
      `details.onprogress = identifier+'${v}GM_onProgressCallback'; }` +
      `if (details.onreadystatechange) { unsafeWindow[identifier+'${v}GM_onReadyStateChange'] = details.onreadystatechange;` +
      `details.onreadystatechange = identifier+'${v}GM_onReadyStateChange'; }` +
      `if (details.ontimeout) { unsafeWindow[identifier+'${v}GM_onTimeoutCallback'] = details.ontimeout;` +
      `details.ontimeout = identifier+'${v}GM_onTimeoutCallback'; }` +
      `if (details.upload) {if (details.upload.onprogress) { ` +
      `unsafeWindow[identifier+'${v}GM_uploadOnProgressCallback'] = details.upload.onprogress;` +
      `details.upload.onprogress = identifier+'${v}GM_uploadOnProgressCallback'; }}` +
      `if (details.data instanceof FormData) { details.data = new URLSearchParams(details.data).toString(); }` +
      `if (details.data instanceof Array) { details.data = details.data.join(','); }` +
      `if (details.data instanceof URLSearchParams) { details.data = details.data.toString(); }` +
      `details.v_ua = navigator.userAgent;` +
      `${gmCall5(secret, np, scriptId, 'xmlhttpRequest', '{details: JSON.stringify(details)}')};`)
    seg = seg +
      `${fn}.UNSENT=0;${fn}.OPENED=1;${fn}.HEADERS_RECEIVED=2;${fn}.LOADING=3;${fn}.DONE=4;\n` +
      `${fn}.RESPONSE_TYPE_ARRAYBUFFER='arraybuffer';${fn}.RESPONSE_TYPE_BLOB='blob';` +
      `${fn}.RESPONSE_TYPE_DOCUMENT='document';${fn}.RESPONSE_TYPE_JSON='json';` +
      `${fn}.RESPONSE_TYPE_STREAM='stream';${fn}.RESPONSE_TYPE_TEXT='text';\n`
    if ((grant & 256) === 256) {
      seg = seg + gmAliasJs(fn, 'xmlhttpRequest')
    }
    s = seg
    if ((grant & -2147483648) === -2147483648) {
      s = s + gmDotJs(fn, 'xmlHttpRequest', 'details', false)
    }
  }
  // addValueChangeListener（位 8192）
  if ((grant & 8192) === 8192) {
    s = s + `var GM_addValueChangeListener = function(name, callback) {};\n`
  }
  // removeValueChangeListener（位 16384）
  if ((grant & 16384) === 16384) {
    s = s + `var GM_removeValueChangeListener = function(listenerId) {};\n`
  }
  // openInTab（掩码 268468224）
  if ((268468224 & grant) !== 0) {
    const fn = p + 'openInTab'
    let seg = s + gmFnJs(fn, 'url, options',
      `if ((typeof options) != 'object') { options = { active: (!options ? false : true) }}; ` +
      `${gmCall5(secret, np, scriptId, 'openInTab', '{url: url, options: JSON.stringify(options)}')};`)
    if ((grant & 32768) === 32768) {
      seg = seg + gmAliasJs(fn, 'openInTab')
    }
    s = seg
    if ((grant & 268435456) === 268435456) {
      s = s + gmDotJs(fn, 'openInTab', 'url, options', false)
    }
  }
  // registerMenuCommand（掩码 536936448）
  if ((536936448 & grant) !== 0) {
    const fn = p + 'registerMenuCommand'
    let seg = s + gmFnJs(fn, 'name, func, key',
      `if (!func) { return; };if (!window['${secret}']) window['${secret}'] = {};` +
      `if (!window['${secret}']['gm_menus']) window['${secret}']['gm_menus'] = {};` +
      `if (!window['${secret}']['gm_menus']['${scriptId}']) window['${secret}']['gm_menus']['${scriptId}'] = {};` +
      `window['${secret}']['gm_menus']['${scriptId}'][name] = func;return name;`)
    if ((grant & 65536) === 65536) {
      seg = seg + gmAliasJs(fn, 'registerMenuCommand')
    }
    if ((grant & 536870912) === 536870912) {
      s = seg + gmDotJs(fn, 'registerMenuCommand', 'name, func, key', false)
    } else {
      s = seg
    }
  }
  // unregisterMenuCommand（掩码 537001984）
  if ((537001984 & grant) !== 0) {
    const fn = p + 'unregisterMenuCommand'
    s = s + gmFnJs(fn, 'name',
      `if (!name) { return; };if (!window['${secret}']) { return; }` +
      `if (!window['${secret}']['gm_menus']) { return; }` +
      `if (!window['${secret}']['gm_menus']['${scriptId}']) { return; }` +
      `delete window['${secret}']['gm_menus']['${scriptId}'][name];`) +
      gmAliasJs(fn, 'unregisterMenuCommand')
    if ((grant & 536870912) === 536870912) {
      s = s + gmDotJs(fn, 'unregisterMenuCommand', 'name', false)
    }
  }
  // notification（掩码 134479872）
  if ((134479872 & grant) !== 0) {
    if ((grant & 262144) === 262144) {
      s = s + `var GM_notification = function() {};\n`
    }
    if ((grant & 134217728) === 134217728) {
      s = s + `GM.notification = function() {};\n`
    }
  }
  return s
}

// ===================== p5 变量存储（SQLite → preferences） =====================

export class GmValueStore {
  private static instance: GmValueStore | null = null
  private static readonly STORE_NAME = 'gm_store'
  private static readonly KEY = 'values'
  private static readonly SEP = '\u0001'
  private prefs: preferences.Preferences | null = null

  static getInstance(): GmValueStore {
    if (GmValueStore.instance === null) {
      GmValueStore.instance = new GmValueStore()
    }
    return GmValueStore.instance
  }

  init(context: common.Context): Promise<void> {
    if (this.prefs !== null) {
      return Promise.resolve()
    }
    return preferences.getPreferences(context, GmValueStore.STORE_NAME).then((p: preferences.Preferences): void => {
      GmValueStore.getInstance().prefs = p
    })
  }

  private loadMap(): Record<string, string> {
    if (this.prefs === null) {
      return {} as Record<string, string>
    }
    const raw = this.prefs.getSync(GmValueStore.KEY, '{}') as string
    try {
      return JSON.parse(raw) as Record<string, string>
    } catch (error) {
      return {} as Record<string, string>
    }
  }

  private saveMap(map: Record<string, string>): void {
    if (this.prefs === null) {
      return
    }
    this.prefs.putSync(GmValueStore.KEY, JSON.stringify(map))
    this.prefs.flush()
  }

  get(scriptId: string, name: string): string | null {
    const value = this.loadMap()[scriptId + GmValueStore.SEP + name]
    return value === undefined ? null : value
  }

  set(scriptId: string, name: string, value: string): void {
    const map = this.loadMap()
    map[scriptId + GmValueStore.SEP + name] = value
    this.saveMap(map)
  }

  remove(scriptId: string, name: string): void {
    const old = this.loadMap()
    const fresh: Record<string, string> = {}
    const target = scriptId + GmValueStore.SEP + name
    const keys = Object.keys(old)
    for (let i = 0; i < keys.length; i++) {
      if (keys[i] !== target) {
        fresh[keys[i]] = old[keys[i]]
      }
    }
    this.saveMap(fresh)
  }

  names(scriptId: string): string[] {
    const map = this.loadMap()
    const prefix = scriptId + GmValueStore.SEP
    const result: string[] = []
    const keys = Object.keys(map)
    for (let i = 0; i < keys.length; i++) {
      if (keys[i].startsWith(prefix)) {
        result.push(keys[i].substring(prefix.length))
      }
    }
    return result
  }
}

// ===================== @require 依赖缓存（filesDir/gm_requires） =====================

// 稳定散列文件名（内部命名，等价原版 md5(s5/c.a) 的文件键作用）
function requireFileName(url: string): string {
  let h1 = 0x811c9dc5
  let h2 = 0x01000193
  for (let i = 0; i < url.length; i++) {
    const c = url.charCodeAt(i)
    h1 = (Math.imul(h1 ^ c, 0x01000193)) >>> 0
    h2 = (Math.imul(h2 + c, 0x85ebca6b)) >>> 0
  }
  return h1.toString(16) + h2.toString(16) + '.js'
}

export class GmRequireStore {
  private static instance: GmRequireStore | null = null
  private dir: string = ''

  static getInstance(): GmRequireStore {
    if (GmRequireStore.instance === null) {
      GmRequireStore.instance = new GmRequireStore()
    }
    return GmRequireStore.instance
  }

  init(context: common.Context): void {
    if (this.dir !== '') {
      return
    }
    this.dir = context.filesDir + '/gm_requires'
    try {
      if (!fileIo.accessSync(this.dir)) {
        fileIo.mkdirSync(this.dir)
      }
    } catch (error) {
      hilog.error(DOMAIN, TAG, 'init gm_requires dir failed')
    }
  }

  private pathOf(url: string): string {
    return this.dir + '/' + requireFileName(url)
  }

  // p5/a.H()：读取 require 内容（未缓存返回空串，不追加 "null"）
  readCached(url: string): string {
    if (this.dir === '' || url === '') {
      return ''
    }
    try {
      return fileIo.readTextSync(this.pathOf(url))
    } catch (error) {
      return ''
    }
  }

  hasCached(url: string): boolean {
    if (this.dir === '' || url === '') {
      return false
    }
    try {
      return fileIo.accessSync(this.pathOf(url))
    } catch (error) {
      return false
    }
  }

  // p5/a.t()：安装/保存时预取全部 @require（fire-and-forget）
  fetchAll(urls: string[]): void {
    for (let i = 0; i < urls.length; i++) {
      this.fetchOne(urls[i])
    }
  }

  private fetchOne(url: string): void {
    if (this.dir === '' || url === '' || !url.startsWith('http') || this.hasCached(url)) {
      return
    }
    const session = http.createHttp()
    session.request(url, {
      method: http.RequestMethod.GET,
      connectTimeout: 15000,
      readTimeout: 30000,
      usingCache: false
    }).then((response: http.HttpResponse) => {
      const body = response.result
      if (typeof body === 'string' && body.trim() !== '') {
        try {
          const file = fileIo.openSync(this.pathOf(url), fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE |
            fileIo.OpenMode.TRUNC)
          fileIo.writeSync(file.fd, body)
          fileIo.closeSync(file)
        } catch (error) {
          hilog.error(DOMAIN, TAG, 'save require failed: %{public}s', url)
        }
      }
    }).catch((error: BusinessError) => {
      hilog.error(DOMAIN, TAG, 'fetch require failed: %{public}s %{public}s', url, error.message)
    }).finally(() => {
      session.destroy()
    })
  }
}

// 安装/保存脚本后预取 @require（sa/d1 安装路径 p5.t() 等价）
export function fetchScriptRequires(rec: UserScriptRec): void {
  try {
    const requires = JSON.parse(rec.requires) as string[]
    if (requires instanceof Array) {
      GmRequireStore.getInstance().fetchAll(requires)
    }
  } catch (error) {
  }
}

// EntryAbility.onCreate 初始化入口
export function initGmRuntime(context: common.Context): void {
  GmValueStore.getInstance().init(context).catch((error: BusinessError) => {
    hilog.error(DOMAIN, TAG, 'init gm store failed: %{public}s', error.message)
  })
  GmRequireStore.getInstance().init(context)
  // 原版启动链 k6.i9() → c8/na.q0() → sb/q：脚本自动更新（fire-and-forget）
  startScriptsAutoUpdate(context)
}

// ===================== o5/c.java 响应状态 =====================

class GmResponseState {
  contextJson: string = ''
  readyState: number = 0
  responseHeaders: string = ''
  responseType: string = ''
  responseText: string = ''
  responseDataUrl: string = ''
  status: number = 0
  statusText: string = ''
  finalUrl: string = ''
  isProgress: boolean = false
  loaded: number = 0
  lengthComputable: boolean = false
  total: number = 0
  isUpload: boolean = false

  // o5/c.n + o：生成 JSON 文本并整体加引号（供 j0.i JSON.parse）
  quotedJson(): string {
    let json = ''
    if (!this.isUpload) {
      json = `{"finalUrl":${JSON.stringify(this.finalUrl)},"readyState":${this.readyState},` +
        `"status":${this.status},"statusText":${JSON.stringify(this.statusText)},` +
        `"responseHeaders":${JSON.stringify(this.responseHeaders)}`
      if (!this.isProgress) {
        json += `,"responseType":${JSON.stringify(this.responseType === '' ? 'undefined' : this.responseType)}`
        if (this.responseDataUrl !== '') {
          json += `,"responseDataUrl":${JSON.stringify(this.responseDataUrl)}`
        }
        if (this.responseText !== '') {
          json += `,"responseText":${JSON.stringify(this.responseText)}`
        }
        if (this.contextJson !== '') {
          json += `,"context":${this.contextJson}`
        }
        json += '}'
        return JSON.stringify(json)
      }
      json += `,"lengthComputable":${this.lengthComputable},"loaded":${this.loaded},"total":${this.total}}`
      return JSON.stringify(json)
    }
    return JSON.stringify(`{"lengthComputable":${this.lengthComputable},"loaded":${this.loaded},` +
      `"total":${this.total}}`)
  }
}

// ===================== o5/b.java GM_xmlhttpRequest =====================

interface GmRequestCallbacks {
  onerror: string
  onload: string
  onloadstart: string
  onprogress: string
  onreadystatechange: string
  ontimeout: string
  uploadOnprogress: string
}

export class GmHttpRequest {
  private static readonly MAX_SIZE = 8388608
  private static readonly PROGRESS_STEP = 32768
  private method: string = 'GET'
  private url: string = ''
  private data: string = ''
  private contextJson: string = ''
  private headers: Record<string, string> = {} as Record<string, string>
  private responseType: string = ''
  private overrideMimeType: string = ''
  private timeout: number = 0
  private user: string = ''
  private password: string = ''
  private cookie: string = ''
  private anonymous: boolean = false
  private hasHeaders: boolean = false
  private cb: GmRequestCallbacks = {
    onerror: '', onload: '', onloadstart: '', onprogress: '', onreadystatechange: '', ontimeout: '',
    uploadOnprogress: ''
  }
  private evaluateJs: (js: string) => void = (js: string): void => {
  }
  private defaultUserAgent: string = ''

  constructor(detailsJson: string, evaluateJs: (js: string) => void, defaultUserAgent: string) {
    this.evaluateJs = evaluateJs
    this.defaultUserAgent = defaultUserAgent
    try {
      const raw = JSON.parse(detailsJson) as Record<string, Object>
      const method = raw['method']
      if (typeof method === 'string' && method !== '') {
        this.method = method.toUpperCase()
      }
      const url = raw['url']
      if (typeof url === 'string') {
        this.url = url
      }
      const data = raw['data']
      if (typeof data === 'string') {
        this.data = data
      }
      const responseType = raw['responseType']
      if (typeof responseType === 'string') {
        this.responseType = responseType
      }
      const overrideMimeType = raw['overrideMimeType']
      if (typeof overrideMimeType === 'string') {
        this.overrideMimeType = overrideMimeType
      }
      const user = raw['user']
      if (typeof user === 'string') {
        this.user = user
      }
      const password = raw['password']
      if (typeof password === 'string') {
        this.password = password
      }
      const cookie = raw['cookie']
      if (typeof cookie === 'string') {
        this.cookie = cookie
      }
      const context = raw['context']
      if (context instanceof Object && !(context instanceof Array)) {
        this.contextJson = JSON.stringify(context)
      }
      const headers = raw['headers']
      if (headers instanceof Object && !(headers instanceof Array)) {
        const keys = Object.keys(headers as Record<string, Object>)
        for (let i = 0; i < keys.length; i++) {
          const value = (headers as Record<string, Object>)[keys[i]]
          if (typeof value === 'string') {
            this.headers[keys[i]] = value
          }
        }
        this.hasHeaders = true
      }
      const upload = raw['upload']
      if (upload instanceof Object && !(upload instanceof Array)) {
        const onprogress = (upload as Record<string, Object>)['onprogress']
        if (typeof onprogress === 'string') {
          this.cb.uploadOnprogress = onprogress
        }
      }
      const onerror = raw['onerror']
      if (typeof onerror === 'string') {
        this.cb.onerror = onerror
      }
      const onload = raw['onload']
      if (typeof onload === 'string') {
        this.cb.onload = onload
      }
      const onloadstart = raw['onloadstart']
      if (typeof onloadstart === 'string') {
        this.cb.onloadstart = onloadstart
      }
      const onprogress = raw['onprogress']
      if (typeof onprogress === 'string') {
        this.cb.onprogress = onprogress
      }
      const onreadystatechange = raw['onreadystatechange']
      if (typeof onreadystatechange === 'string') {
        this.cb.onreadystatechange = onreadystatechange
      }
      const ontimeout = raw['ontimeout']
      if (typeof ontimeout === 'string') {
        this.cb.ontimeout = ontimeout
      }
      const timeout = raw['timeout']
      if (typeof timeout === 'number') {
        this.timeout = timeout
      }
      const anonymous = raw['anonymous']
      if (typeof anonymous === 'boolean') {
        this.anonymous = anonymous
      }
    } catch (error) {
      hilog.error(DOMAIN, TAG, 'parse details failed')
    }
  }

  // o5/b.c()：触发回调（withReadyStateChange 时前置 onreadystatechange）
  private fire(callbackName: string, state: GmResponseState | null, withReadyStateChange: boolean): void {
    const callbacks: string[] = withReadyStateChange ?
      (callbackName === this.cb.onreadystatechange ? [this.cb.onreadystatechange] :
        [this.cb.onreadystatechange, callbackName]) : [callbackName]
    let count = 0
    for (let i = 0; i < callbacks.length; i++) {
      if (callbacks[i] !== '') {
        count++
      }
    }
    if (count === 0) {
      return
    }
    if (state !== null) {
      state.isProgress = this.cb.onprogress !== '' && this.cb.onprogress === callbackName
    }
    const js = gmCallbackJs(callbacks, state === null ? null : state.quotedJson())
    if (js !== null) {
      this.evaluateJs(js)
    }
  }

  private fireError(state: GmResponseState): void {
    this.fire(this.cb.onerror, state, true)
  }

  private fireLoad(state: GmResponseState): void {
    this.fire(this.cb.onload, state, true)
  }

  private fireProgress(state: GmResponseState): void {
    this.fire(this.cb.onprogress, state, false)
  }

  private fireReadyStateChange(state: GmResponseState): void {
    this.fire(this.cb.onreadystatechange, state, false)
  }

  private fireTimeout(): void {
    this.fire(this.cb.ontimeout, null, false)
  }

  private fireUploadProgress(state: GmResponseState): void {
    this.fire(this.cb.uploadOnprogress, state, false)
  }

  // o5/b.e()：执行请求（ArkWeb 侧 @ohos.net.http requestInStream 实现）
  start(): void {
    if (this.url === '') {
      const state = new GmResponseState()
      this.fireError(state)
      return
    }
    const state = new GmResponseState()
    state.finalUrl = this.url
    state.contextJson = this.contextJson
    state.responseType = this.responseType
    state.readyState = 1
    const session = http.createHttp()
    let aborted = false
    let lastProgress = 0
    const isBinary = this.responseType === 'blob' || this.responseType === 'stream' ||
      this.responseType === 'arraybuffer'
    const chunks: ArrayBuffer[] = []
    let loaded = 0
    const header: Record<string, string> = {} as Record<string, string>
    // 请求头组装（o5/b.e：headers + basic auth + cookie + UA）
    let headerCookie = ''
    let headerUserAgent = ''
    if (this.hasHeaders) {
      const keys = Object.keys(this.headers)
      for (let i = 0; i < keys.length; i++) {
        const key = keys[i]
        const value = this.headers[key]
        if (key.toLowerCase() === 'cookie') {
          headerCookie = value
        } else if (key.toLowerCase() === 'user-agent') {
          headerUserAgent = value
        } else {
          header[key] = value
        }
      }
    }
    if (headerUserAgent !== '' || this.defaultUserAgent !== '') {
      header['User-Agent'] = headerUserAgent !== '' ? headerUserAgent : this.defaultUserAgent
    }
    if (!this.anonymous) {
      let cookieHeader = ''
      if (headerCookie !== '') {
        cookieHeader = headerCookie
      }
      if (this.cookie !== '') {
        cookieHeader = cookieHeader === '' ? this.cookie : cookieHeader + ';' + this.cookie
      }
      if (cookieHeader !== '') {
        header['Cookie'] = cookieHeader
      }
    }
    if (this.data !== '') {
      header['Content-Type'] = this.data.indexOf('=') > 0 ?
        'application/x-www-form-urlencoded;charset=UTF-8' : 'text/plain;charset=UTF-8'
    }
    if (this.overrideMimeType !== '') {
      header['Content-Type'] = this.overrideMimeType
    }
    // basic auth（放在 Content-Type 之后避免被覆盖顺序无关）
    if (this.user !== '' && this.password !== '') {
      try {
        const authText = this.user + ':' + this.password
        const authBytes = new Uint8Array(authText.length)
        for (let i = 0; i < authText.length; i++) {
          authBytes[i] = authText.charCodeAt(i) & 0xFF
        }
        header['Authorization'] = 'Basic ' + new util.Base64Helper().encodeToStringSync(authBytes)
      } catch (error) {
        hilog.error(DOMAIN, TAG, 'basic auth encode failed')
      }
    }
    const options: http.HttpRequestOptions = {
      method: this.toHttpMethod(),
      header: header,
      usingCache: false,
      expectDataType: http.HttpDataType.ARRAY_BUFFER,
      connectTimeout: this.timeout > 0 ? this.timeout : 60000,
      readTimeout: this.timeout > 0 ? this.timeout : 60000
    }
    if (this.data !== '') {
      options.extraData = this.data
    }
    // 上传进度（o5/b.l：body 写完后触发 upload.onprogress）
    const fireUploadAfterStart = (): void => {
      if (this.data !== '' && this.cb.uploadOnprogress !== '') {
        state.lengthComputable = true
        state.total = this.data.length
        state.loaded = this.data.length
        state.isUpload = true
        this.fireUploadProgress(state)
        state.isUpload = false
      }
    }
    session.on('headersReceive', (respHeader: Object) => {
      if (aborted) {
        return
      }
      const headerMap = respHeader as Record<string, string>
      let responseHeaders = ''
      const keys = Object.keys(headerMap)
      for (let i = 0; i < keys.length; i++) {
        responseHeaders += keys[i].toLowerCase() + ': ' + headerMap[keys[i]] + '\r\n'
      }
      state.responseHeaders = responseHeaders
      let contentLength = -1
      const lenValue = headerMap['content-length'] ?? headerMap['Content-Length']
      if (typeof lenValue === 'string' && lenValue !== '') {
        const parsed = Number(lenValue.split(',')[0].trim())
        if (!Number.isNaN(parsed)) {
          contentLength = parsed
        }
      }
      state.lengthComputable = contentLength > 0
      state.total = contentLength > 0 ? contentLength : -1
      state.readyState = 2
      this.fireReadyStateChange(state)
      state.readyState = 3
      this.fireReadyStateChange(state)
    })
    session.on('dataReceive', (chunk: ArrayBuffer) => {
      if (aborted) {
        return
      }
      if (loaded >= GmHttpRequest.MAX_SIZE) {
        return
      }
      if (loaded + chunk.byteLength > GmHttpRequest.MAX_SIZE) {
        aborted = true
        hilog.error(DOMAIN, TAG, 'Response is too large')
        try {
          session.destroy()
        } catch (error) {
        }
        this.fireError(state)
        return
      }
      chunks.push(chunk)
      loaded += chunk.byteLength
      state.loaded = loaded
      if (loaded - lastProgress > GmHttpRequest.PROGRESS_STEP) {
        this.fireProgress(state)
        lastProgress = loaded
      }
    })
    session.on('dataEnd', () => {
      if (aborted) {
        return
      }
    })
    session.requestInStream(this.url, options).then((responseCode: number) => {
      if (aborted) {
        return
      }
      aborted = true
      state.status = responseCode
      if (responseCode < 200 || responseCode >= 300) {
        hilog.error(DOMAIN, TAG, 'HTTP error from url: %{public}s, HTTP Response %{public}d', this.url, responseCode)
        this.fireError(state)
        return
      }
      if (this.method !== 'HEAD') {
        if (isBinary) {
          state.responseDataUrl = this.buildDataUrl(chunks, state)
        } else {
          state.responseText = this.decodeText(chunks, state)
        }
      }
      state.readyState = 4
      this.fireLoad(state)
    }).catch((error: BusinessError) => {
      if (aborted) {
        return
      }
      aborted = true
      if (error.code === 2300028) {
        hilog.error(DOMAIN, TAG, 'Timeout issuing GM_xmlhttpRequest for: %{public}s', this.url)
        this.fireTimeout()
        return
      }
      hilog.error(DOMAIN, TAG, 'Exception issuing GM_xmlhttpRequest for: %{public}s: %{public}s', this.url,
        error.message)
      state.readyState = 4
      this.fireError(state)
    }).finally(() => {
      try {
        session.destroy()
      } catch (error) {
      }
    })
    fireUploadAfterStart()
  }

  private toHttpMethod(): http.RequestMethod {
    if (this.method === 'POST') {
      return http.RequestMethod.POST
    }
    if (this.method === 'PUT') {
      return http.RequestMethod.PUT
    }
    if (this.method === 'DELETE') {
      return http.RequestMethod.DELETE
    }
    if (this.method === 'HEAD') {
      return http.RequestMethod.HEAD
    }
    if (this.method === 'OPTIONS') {
      return http.RequestMethod.OPTIONS
    }
    return http.RequestMethod.GET
  }

  // 二进制响应 → data:<mime>;base64,<...>（o5/b.e blob 分支）
  private buildDataUrl(chunks: ArrayBuffer[], state: GmResponseState): string {
    const contentType = this.headerValueOf(state.responseHeaders, 'content-type')
    let mime = contentType === '' ? 'text/plain' : contentType
    const semi = mime.indexOf(';')
    if (semi > 0) {
      mime = mime.substring(0, semi)
    }
    let total = 0
    for (let i = 0; i < chunks.length; i++) {
      total += chunks[i].byteLength
    }
    const merged = new Uint8Array(total)
    let offset = 0
    for (let i = 0; i < chunks.length; i++) {
      merged.set(new Uint8Array(chunks[i]), offset)
      offset += chunks[i].byteLength
    }
    try {
      return 'data:' + mime + ';base64,' + new util.Base64Helper().encodeToStringSync(merged)
    } catch (error) {
      return ''
    }
  }

  // 文本响应 → 按 Content-Type charset 解码（o5/b.e 文本分支）
  private decodeText(chunks: ArrayBuffer[], state: GmResponseState): string {
    const contentType = this.headerValueOf(state.responseHeaders, 'content-type')
    let charset = 'utf-8'
    const upper = contentType.toUpperCase()
    const idx = upper.indexOf('CHARSET=')
    if (idx >= 0) {
      const start = idx + 8
      let end = upper.indexOf(';', start)
      if (end < 0) {
        end = upper.length
      }
      charset = contentType.substring(start, end).trim()
    }
    let total = 0
    for (let i = 0; i < chunks.length; i++) {
      total += chunks[i].byteLength
    }
    const merged = new Uint8Array(total)
    let offset = 0
    for (let i = 0; i < chunks.length; i++) {
      merged.set(new Uint8Array(chunks[i]), offset)
      offset += chunks[i].byteLength
    }
    try {
      return util.TextDecoder.create(charset).decodeToString(merged)
    } catch (error) {
      try {
        return util.TextDecoder.create('utf-8').decodeToString(merged)
      } catch (innerError) {
        return ''
      }
    }
  }

  private headerValueOf(responseHeaders: string, name: string): string {
    const lines = responseHeaders.split('\r\n')
    for (let i = 0; i < lines.length; i++) {
      const colon = lines[i].indexOf(':')
      if (colon > 0 && lines[i].substring(0, colon).trim() === name) {
        return lines[i].substring(colon + 1).trim()
      }
    }
    return ''
  }
}

// ===================== o5/a.java 分派桥（window.via_gm.call） =====================

export class GmBridge {
  private store: GmValueStore = GmValueStore.getInstance()
  private settings: AppSettings = AppSettings.getInstance()
  private secret: string = gmSecret()
  // k6.s（InterfaceC0102a）宿主回调
  onSetClipboard: (data: string, type: string) => void = (data: string, type: string): void => {
  }
  onDownload: (url: string, name: string) => void = (url: string, name: string): void => {
  }
  onOpenInTab: (url: string, active: boolean, insert: number) => void =
    (url: string, active: boolean, insert: number): void => {
    }
  evaluateJs: (js: string) => void = (js: string): void => {
  }
  userAgent: () => string = (): string => ''

  // @JavascriptInterface call(str, secret)（o5/a.call）
  call(str: string, secret: string): string {
    const result = this.dispatch(str, secret)
    return result === null ? '' : result
  }

  // o5/a.j()：secret 校验
  private secretInvalid(s: string): boolean {
    return s === '' || s !== this.secret
  }

  // o5/a.i()：grant 掩码校验（!A）
  private grantDenied(identifier: string, mask: number): boolean {
    const rec = this.findScript(identifier)
    return rec === null || (rec.grantBits & mask) === 0
  }

  private findScript(identifier: string): UserScriptRec | null {
    const id = Number(identifier)
    if (Number.isNaN(id)) {
      return null
    }
    const scripts = this.settings.userScripts
    for (let i = 0; i < scripts.length; i++) {
      if (scripts[i].id === id) {
        return scripts[i]
      }
    }
    return null
  }

  // o5/a.f()：按 name 分派
  private dispatch(str: string, secret: string): string | null {
    if (str === null || str === '') {
      return null
    }
    if (this.secretInvalid(secret)) {
      return null
    }
    try {
      const raw = JSON.parse(str) as Record<string, Object>
      const name = raw['name']
      const identifier = raw['identifier']
      if (typeof name !== 'string' || name === '' || typeof identifier !== 'string' || identifier === '') {
        return null
      }
      const args = raw['arguments']
      const argsMap: Record<string, Object> = (args instanceof Object && !(args instanceof Array)) ?
        args as Record<string, Object> : {} as Record<string, Object>
      switch (name) {
        case 'info':
          return this.buildInfo(identifier)
        case 'log': {
          if (this.grantDenied(identifier, 512)) {
            return null
          }
          const message = argsMap['message']
          hilog.info(DOMAIN, TAG, '%{public}s', typeof message === 'string' ? `${identifier}: ${message}` : identifier)
          return null
        }
        case 'setValue': {
          if (this.grantDenied(identifier, 8388609)) {
            return null
          }
          const valueName = argsMap['name']
          const value = argsMap['value']
          this.store.set(identifier, typeof valueName === 'string' ? valueName : '',
            typeof value === 'string' ? value : 'undefined')
          return null
        }
        case 'getValue': {
          if (this.grantDenied(identifier, 2097154)) {
            return 'undefined'
          }
          const valueName = argsMap['name']
          const fallback = argsMap['value']
          const stored = this.store.get(identifier, typeof valueName === 'string' ? valueName : '')
          return stored === null ? (typeof fallback === 'string' ? fallback : 'undefined') : stored
        }
        case 'deleteValue': {
          if (this.grantDenied(identifier, 1048584)) {
            return null
          }
          const valueName = argsMap['name']
          this.store.remove(identifier, typeof valueName === 'string' ? valueName : '')
          return null
        }
        case 'listValues': {
          if (this.grantDenied(identifier, 4194308)) {
            return null
          }
          return this.store.names(identifier).join(',')
        }
        case 'download': {
          if (this.grantDenied(identifier, 2048)) {
            return null
          }
          const url = argsMap['url']
          const fileName = argsMap['name']
          this.onDownload(typeof url === 'string' ? url : '', typeof fileName === 'string' ? fileName : '')
          return null
        }
        case 'openInTab': {
          if (this.grantDenied(identifier, 268468224)) {
            return null
          }
          const url = argsMap['url']
          const options = argsMap['options']
          let active = false
          let insert = -1
          if (typeof options === 'string' && options !== '') {
            try {
              const opt = JSON.parse(options) as Record<string, Object>
              const activeValue = opt['active']
              if (typeof activeValue === 'boolean') {
                active = activeValue
              }
              const insertValue = opt['insert']
              if (typeof insertValue === 'number') {
                insert = insertValue
              }
            } catch (error) {
            }
          }
          this.onOpenInTab(typeof url === 'string' ? url : '', active, insert)
          return null
        }
        case 'setClipboard': {
          if (this.grantDenied(identifier, 1073742848)) {
            return null
          }
          const data = argsMap['data']
          const type = argsMap['type']
          let typeStr = typeof type === 'string' ? type : ''
          if (typeStr === '' || typeStr === 'undefined' || typeStr === 'null') {
            typeStr = 'text/plain'
          }
          this.onSetClipboard(typeof data === 'string' ? data : '', typeStr)
          return null
        }
        case 'xmlhttpRequest': {
          if (this.grantDenied(identifier, -2147483392)) {
            return ''
          }
          const details = argsMap['details']
          const request = new GmHttpRequest(typeof details === 'string' ? details : '{}',
            this.evaluateJs, this.userAgent())
          request.start()
          return null
        }
        case 'getResourceText': {
          if (this.grantDenied(identifier, 32)) {
            return null
          }
          // 本端未实现 @resource 文件库（原版 p5 文件表），无资源时与原版一致返回 undefined
          return 'undefined'
        }
        case 'getResourceURL': {
          if (this.grantDenied(identifier, 67108880)) {
            return null
          }
          return 'undefined'
        }
        default:
          return null
      }
    } catch (error) {
      hilog.error(DOMAIN, TAG, 'dispatch failed')
      return null
    }
  }

  // o5/a.g()：GM_info JSON
  private buildInfo(identifier: string): string | null {
    if (this.secretInvalid(this.secret) || identifier === '') {
      return null
    }
    const rec = this.findScript(identifier)
    let scriptJson = '{}'
    if (rec !== null) {
      scriptJson = `{"version":${JSON.stringify(rec.version)},"downloadURL":${JSON.stringify(rec.downloadUrl)},` +
        `"homepage":${JSON.stringify(rec.homepageUrl)},"name":${JSON.stringify(rec.name)}}`
    }
    return `{"scriptHandler":"Via","version":"2.0.0","scriptWillUpdate":false,"script":${scriptJson}}`
  }
}
