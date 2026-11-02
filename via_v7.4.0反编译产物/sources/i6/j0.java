package i6;

import java.util.Iterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static final j0 f7011a = new j0();

    public final String a(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("window.");
        sb2.append(str2);
        sb2.append("(JSON.stringify({secret:'");
        sb2.append(str);
        sb2.append("', identifier:'");
        sb2.append(str3);
        sb2.append("', name:'");
        sb2.append(str4);
        sb2.append("', 'arguments':");
        if (str5 == null) {
            str5 = "{}";
        }
        sb2.append(str5);
        sb2.append("}), '");
        sb2.append(str);
        sb2.append("')");
        return sb2.toString();
    }

    public final String b(String str, String str2, String str3, String str4) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("window.");
        sb2.append(str2);
        sb2.append("(JSON.stringify({secret:'");
        sb2.append(str);
        sb2.append("', name:'");
        sb2.append(str3);
        sb2.append("', 'arguments':");
        if (str4 == null) {
            str4 = "{}";
        }
        sb2.append(str4);
        sb2.append("}), '");
        sb2.append(str);
        sb2.append("')");
        return sb2.toString();
    }

    public final String c(String scriptId, String secret, int i10) {
        String str;
        String str2;
        j0 j0Var;
        String str3;
        String str4;
        String str5;
        kotlin.jvm.internal.h.f(scriptId, "scriptId");
        kotlin.jvm.internal.h.f(secret, "secret");
        String strK = k("GM_" + secret + '_');
        String strK2 = k("NP_" + secret);
        String str6 = ((("const GM = {};\n" + h(strK2)) + "const " + strK + "info = function() {let cached; const obj = {}; Object.defineProperty(obj, 'VALUE', {get: function() {if (cached == undefined) {cached = JSON.parse(" + a(secret, strK2, scriptId, "info", null) + ");} return cached;}, configurable: false, enumerable: true}); return obj;}();\n") + "const GM_info = " + strK + "info.VALUE;\n") + "GM.info = " + strK + "info.VALUE;\n";
        if (i10 == 0) {
            return str6;
        }
        if ((10485763 & i10) != 0) {
            str = strK + "JSONStringify";
            str2 = strK + "JSONParse";
            str6 = (str6 + g(str, "v", "return JSON.stringify(v,function(k,v){if(typeof v==='bigint'){return undefined}if(v instanceof Number){return '{}';}if(v!==v){return 'NaN'}if(v===Infinity){return 'Infinity'}if(v===-Infinity){return '-Infinity'}return v});")) + g(str2, "v", "return JSON.parse(v,function(k,v){if(v==='{}'){return {}}if(v==='NaN'){return NaN}if(v==='Infinity'){return Infinity}if(v==='-Infinity'){return -Infinity}return v});");
        } else {
            str = "JSON.stringify";
            str2 = "JSON.parse";
        }
        String string = str6;
        String str7 = str;
        String str8 = str2;
        if ((8388609 & i10) != 0) {
            String str9 = strK + "setValue";
            String str10 = string + g(str9, "name, value", "v = value; try {v = " + str7 + "(v);} catch(e) {};" + a(secret, strK2, scriptId, "setValue", "{name: name, value: v}") + ';');
            if ((i10 & 1) == 1) {
                str10 = (str10 + e(str9, "setValue")) + "var GM_setValues=function(a){if(a)for(var b in a)GM_setValue(b,a[b])};\n";
            }
            string = str10;
            if ((i10 & 8388608) == 8388608) {
                string = (string + f(str9, "setValue", "name, value", true)) + "GM.setValues=function(a){return new Promise(function(c,d){if(a){for(var b in a)" + str9 + "(b,a[b]);c()}else d(\"No data\")})};\n";
            }
        }
        if ((2097154 & i10) != 0) {
            String str11 = strK + "getValue";
            String str12 = string + g(str11, "name, defaultValue", "var dv = defaultValue;try {dv = " + str7 + "(defaultValue);} catch(e) {};var v = " + a(secret, strK2, scriptId, "getValue", "{name: name, value: dv}") + ";if(v == 'undefined') { return undefined; };try {v = " + str8 + "(v);} catch(e) {};return v;");
            if ((i10 & 2) == 2) {
                str12 = (str12 + e(str11, "getValue")) + "var GM_getValues=function(b){var c={};if(!b)return c;if(Array.isArray(b))for(var a in b)c[a]=GM_getValue(a);else for(a in b)c[a]=GM_getValue(a,b[a]);return c};\n";
            }
            string = str12;
            if ((i10 & 2097152) == 2097152) {
                string = (string + f(str11, "getValue", "name, defaultValue", true)) + "GM.getValues=function(a){return new Promise(function(d,c){if(a){c={};if(!a)return d({});if(Array.isArray(a))for(var b in a)c[b]=" + str11 + "(b);else for(b in a)c[b]=" + str11 + "(b,a[b]);d(c)}else c(\"No data\")})};\n";
            }
        }
        if ((1048584 & i10) != 0) {
            String str13 = strK + "deleteValue";
            String str14 = string + g(str13, "name", a(secret, strK2, scriptId, "deleteValue", "{name: name}") + ';');
            if ((i10 & 8) == 8) {
                str14 = (str14 + e(str13, "deleteValue")) + "var GM_deleteValues=function(a){if(a&&\"number\"===typeof a.length)for(var b=0,c=a.length;b<c;b++)try{GM_deleteValue(a[b])}catch(d){}};\n";
            }
            string = str14;
            if ((i10 & 1048576) == 1048576) {
                string = (string + f(str13, "deleteValue", "name", true)) + "GM.deleteValues=function(b){return new Promise(function(c,a){if(b&&\"number\"===typeof b.length){a=0;for(var d=b.length;a<d;a++)try{" + str13 + "(b[a])}catch(e){}c()}else a(\"No array\")})};\n";
            }
        }
        if ((4194308 & i10) != 0) {
            String str15 = strK + "listValues";
            String str16 = string + g(str15, "", "var s = " + a(secret, strK2, scriptId, "listValues", null) + ";return s.split(\",\");");
            if ((i10 & 4) == 4) {
                str16 = str16 + e(str15, "listValues");
            }
            string = str16;
            if ((i10 & 4194304) == 4194304) {
                string = string + f(str15, "listValues", "", true);
            }
        }
        if ((33554560 & i10) != 0) {
            String str17 = strK + "addElement";
            String str18 = string + g(str17, "parent, tag, attrs, callback", "if (typeof parent === 'string') { return GM_addElement(undefined, parent, tag || {}, attrs); }var e = document.createElement(tag);if (attrs) {for (var k in attrs) { if (k == 'textContent') { e.textContent = attrs[k]; continue; }; try{e.setAttribute(k, attrs[k]);}catch(e){} };};if (parent == undefined && document) { parent = document.head; }if (parent) { parent.appendChild(e); };if (callback) { callback() }return e;");
            if ((i10 & 128) == 128) {
                str18 = str18 + e(str17, "addElement");
            }
            string = str18;
            if ((i10 & 33554432) == 33554432) {
                string = string + f(str17, "addElement", "parent, tag, attrs, callback", true);
            }
        }
        if ((16777280 & i10) != 0) {
            String str19 = strK + "addStyle";
            String str20 = string + g(str19, "css, callback", "if (!css) { return; };var h = document.getElementsByTagName('head')[0];if (!h) { return; };var e = document.createElement('style');e.type = 'text/css';e.textContent = css;h.appendChild(e);if (callback) { callback() }return e;");
            if ((i10 & 64) == 64) {
                str20 = str20 + e(str19, "addStyle");
            }
            string = str20;
            if ((i10 & 16777216) == 16777216) {
                string = string + f(str19, "addStyle", "css, callback", true);
            }
        }
        if ((i10 & 512) == 512) {
            string = string + "var GM_log = function(message) {" + a(secret, strK2, scriptId, "log", "{message: message}") + "};\n";
        }
        if ((67108880 & i10) != 0) {
            String str21 = strK + "getResourceURL";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("var r = ");
            j0Var = this;
            sb2.append(j0Var.a(secret, strK2, scriptId, "getResourceURL", "{resource: resourceName}"));
            sb2.append(";if (r === 'undefined') {return null} return r;");
            String str22 = string + j0Var.g(str21, "resourceName", sb2.toString());
            if ((i10 & 16) == 16) {
                str22 = str22 + j0Var.e(str21, "getResourceURL");
            }
            string = str22;
            if ((67108864 & i10) == 67108864) {
                string = string + j0Var.f(str21, "getResourceUrl", "resourceName", true);
            }
        } else {
            j0Var = this;
        }
        int i11 = i10 & 32;
        if (i11 != 0) {
            String str23 = strK + "getResourceText";
            string = string + j0Var.g(str23, "resourceName", "var r = " + j0Var.a(secret, strK2, scriptId, "getResourceText", "{resource: resourceName}") + ";if (r === 'undefined') {return null} return r;");
            if (i11 == 32) {
                string = string + j0Var.e(str23, "getResourceText");
            }
        }
        if ((1073742848 & i10) != 0) {
            String str24 = strK + "setClipboard";
            String str25 = string + j0Var.g(str24, "data, type", j0Var.a(secret, strK2, scriptId, "setClipboard", "{data: data, type: type}") + ';');
            if ((i10 & 1024) == 1024) {
                str25 = str25 + j0Var.e(str24, "setClipboard");
            }
            string = str25;
            if ((1073741824 & i10) == 1073741824) {
                string = string + j0Var.f(str24, "setClipboard", "data, type", false);
            }
        }
        if ((i10 & 2048) == 2048) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(string);
            sb3.append("var GM_download = function(url, name) {if ((typeof url) == 'object') {name = url.name;url = url.url;};if (!name) { name = ''; };");
            str3 = scriptId;
            sb3.append(j0Var.a(secret, strK2, str3, "download", "{url: url, name: name}"));
            sb3.append(";};\n");
            string = sb3.toString();
        } else {
            str3 = scriptId;
        }
        if (((-2147483392) & i10) != 0) {
            String str26 = (string + "unsafeWindow = (function() { if(window){return window;} try {var el = document.createElement('p'); el.setAttribute('onclick', 'return window;'); return el.onclick();}catch(e){return window;} }()); window.wrappedJSObject = unsafeWindow;\n") + "var generateRandomString=function(c){for(var a=\"\",b=0;b<c;b++)a+=\"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz\".charAt(Math.floor(62*Math.random()));return a};\n";
            String str27 = strK + "xmlhttpRequest";
            String strK3 = j0Var.k("V_" + str3 + u.c() + '_');
            String str28 = ((str26 + j0Var.g(str27, "details", "var identifier = generateRandomString(8);if (details.onabort) { unsafeWindow[identifier+'" + strK3 + "GM_onAbortCallback'] = details.onabort;details.onabort = identifier+'" + strK3 + "GM_onAbortCallback'; }if (details.onerror) { unsafeWindow[identifier+'" + strK3 + "GM_onErrorCallback'] = details.onerror;details.onerror = identifier+'" + strK3 + "GM_onErrorCallback'; }if (details.onload) { unsafeWindow[identifier+'" + strK3 + "GM_onLoadCallback'] = details.onload;details.onload = identifier+'" + strK3 + "GM_onLoadCallback'; }if (details.onloadstart) { unsafeWindow[identifier+'" + strK3 + "GM_onLoadStartCallback'] = details.onloadstart;details.onloadstart = identifier+'" + strK3 + "GM_onLoadStartCallback'; }if (details.onprogress) { unsafeWindow[identifier+'" + strK3 + "GM_onProgressCallback'] = details.onprogress;details.onprogress = identifier+'" + strK3 + "GM_onProgressCallback'; }if (details.onreadystatechange) { unsafeWindow[identifier+'" + strK3 + "GM_onReadyStateChange'] = details.onreadystatechange;details.onreadystatechange = identifier+'" + strK3 + "GM_onReadyStateChange'; }if (details.ontimeout) { unsafeWindow[identifier+'" + strK3 + "GM_onTimeoutCallback'] = details.ontimeout;details.ontimeout = identifier+'" + strK3 + "GM_onTimeoutCallback'; }if (details.upload) {if (details.upload.onprogress) { unsafeWindow[identifier+'" + strK3 + "GM_uploadOnProgressCallback'] = details.upload.onprogress;details.upload.onprogress = identifier+'" + strK3 + "GM_uploadOnProgressCallback'; }}if (details.data instanceof FormData) { details.data = new URLSearchParams(details.data).toString(); }if (details.data instanceof Array) { details.data = details.data.join(','); }if (details.data instanceof URLSearchParams) { details.data = details.data.toString(); }details.v_ua = navigator.userAgent;" + j0Var.a(secret, strK2, str3, "xmlhttpRequest", "{details: JSON.stringify(details)}") + ';')) + str27 + ".UNSENT=0;" + str27 + ".OPENED=1;" + str27 + ".HEADERS_RECEIVED=2;" + str27 + ".LOADING=3;" + str27 + ".DONE=4;\n") + str27 + ".RESPONSE_TYPE_ARRAYBUFFER='arraybuffer';" + str27 + ".RESPONSE_TYPE_BLOB='blob';" + str27 + ".RESPONSE_TYPE_DOCUMENT='document';" + str27 + ".RESPONSE_TYPE_JSON='json';" + str27 + ".RESPONSE_TYPE_STREAM='stream';" + str27 + ".RESPONSE_TYPE_TEXT='text';\n";
            if ((i10 & 256) == 256) {
                str28 = str28 + j0Var.e(str27, "xmlhttpRequest");
            }
            string = str28;
            if ((Integer.MIN_VALUE & i10) == Integer.MIN_VALUE) {
                string = string + j0Var.f(str27, "xmlHttpRequest", "details", false);
            }
        }
        if ((i10 & 8192) == 8192) {
            string = string + "var GM_addValueChangeListener = function(name, callback) {};\n";
        }
        if ((i10 & 16384) == 16384) {
            string = string + "var GM_removeValueChangeListener = function(listenerId) {};\n";
        }
        if ((268468224 & i10) != 0) {
            String str29 = strK + "openInTab";
            StringBuilder sb4 = new StringBuilder();
            sb4.append("if ((typeof options) != 'object') { options = { active: (!options ? false : true) }}; ");
            str4 = scriptId;
            str5 = secret;
            sb4.append(j0Var.a(str5, strK2, str4, "openInTab", "{url: url, options: JSON.stringify(options)}"));
            sb4.append(';');
            String str30 = string + j0Var.g(str29, "url, options", sb4.toString());
            if ((32768 & i10) == 32768) {
                str30 = str30 + j0Var.e(str29, "openInTab");
            }
            string = str30;
            if ((268435456 & i10) == 268435456) {
                string = string + j0Var.f(str29, "openInTab", "url, options", false);
            }
        } else {
            str4 = scriptId;
            str5 = secret;
        }
        if ((536936448 & i10) != 0) {
            String str31 = strK + "registerMenuCommand";
            String str32 = string + j0Var.g(str31, "name, func, key", "if (!func) { return; };if (!window['" + str5 + "']) window['" + str5 + "'] = {};if (!window['" + str5 + "']['gm_menus']) window['" + str5 + "']['gm_menus'] = {};if (!window['" + str5 + "']['gm_menus']['" + str4 + "']) window['" + str5 + "']['gm_menus']['" + str4 + "'] = {};window['" + str5 + "']['gm_menus']['" + str4 + "'][name] = func;return name;");
            if ((65536 & i10) == 65536) {
                str32 = str32 + j0Var.e(str31, "registerMenuCommand");
            }
            if ((i10 & 536870912) == 536870912) {
                string = str32 + j0Var.f(str31, "registerMenuCommand", "name, func, key", false);
            } else {
                string = str32;
            }
        }
        if ((537001984 & i10) != 0) {
            String str33 = strK + "unregisterMenuCommand";
            string = (string + j0Var.g(str33, "name", "if (!name) { return; };if (!window['" + str5 + "']) { return; }if (!window['" + str5 + "']['gm_menus']) { return; }if (!window['" + str5 + "']['gm_menus']['" + str4 + "']) { return; }delete window['" + str5 + "']['gm_menus']['" + str4 + "'][name];")) + j0Var.e(str33, "unregisterMenuCommand");
            if ((i10 & 536870912) == 536870912) {
                string = string + j0Var.f(str33, "unregisterMenuCommand", "name", false);
            }
        }
        if ((134479872 & i10) != 0) {
            if ((262144 & i10) == 262144) {
                string = string + "var GM_notification = function() {};\n";
            }
            if ((134217728 & i10) == 134217728) {
                return string + "GM.notification = function() {};\n";
            }
        }
        return string;
    }

    public final String d(String secret) {
        kotlin.jvm.internal.h.f(secret, "secret");
        String strK = k("NP_" + secret);
        return "(function () {let key = 'via-fake-tampermonkey';if (window[key]) {return;};" + h(strK) + "try {window[key] = true;window.external.Tampermonkey = {getVersion: function(e) {e({version:'4.5.1', id: 'Via'});},openOptions: function(e, t) {" + b(secret, strK, "openOptions", "{name: e, namespace: t}") + ";},isInstalled: function(e, t, n) {var v = " + b(secret, strK, "isInstalled", "{name: e, namespace: t}") + ";if(v === 'undefined') { return; };try {v = JSON.parse(v);} catch(e) {};n(v);}}} catch (err) {}})();";
    }

    public final String e(String str, String str2) {
        return "var GM_" + str2 + " = " + str + ";\n";
    }

    public final String f(String str, String str2, String str3, boolean z10) {
        if (!z10) {
            return "GM." + str2 + " = " + str + ";\n";
        }
        return "GM." + str2 + " = function(" + str3 + ") { return new Promise(function(resolve, reject) { resolve(" + str + '(' + str3 + "));});};\n";
    }

    public final String g(String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        return "var " + str + " = function(" + str2 + ") { " + str3 + " };\n";
    }

    public final String h(String str) {
        return "if(!window." + str + ") {const nativePrompt = window.via_gm && window.via_gm.call ? window.via_gm.call.bind(window.via_gm) : window.prompt;Object.defineProperty(window, '" + str + "', {value: nativePrompt,writable: false,configurable: false,enumerable: true});}";
    }

    public final String i(String[] strArr, String str) {
        String str2;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        Iterator itA = kotlin.jvm.internal.b.a(strArr);
        String str3 = "";
        while (itA.hasNext()) {
            String str4 = (String) itA.next();
            if (str4 != null && str4.length() != 0) {
                str3 = str3 + "unsafeWindow." + str4 + "(obj);";
            }
        }
        if (str3.length() == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("javascript: (function() { var obj = ");
        if (str == null || str.length() == 0) {
            str2 = "undefined";
        } else {
            str2 = "JSON.parse(" + str + ')';
        }
        sb2.append(str2);
        sb2.append(";if (obj && obj.responseType) {var type = obj.responseType;if (type == 'undefined') { obj.responseType = undefined; obj.response = obj.responseText; }else if (type == 'json') { try { obj.response = JSON.parse(obj.responseText); }catch(e){} }else if (type == 'document') { try { obj.response = new DOMParser().parseFromString(obj.responseText, 'text/html'); }catch(e){} }else if (type == 'blob' || type == 'arraybuffer' || type == 'stream') {if (obj.responseDataUrl) {const [metadata, data] = obj.responseDataUrl.split(',');const mime = metadata.match(/data:([^;]+)/)[1];const decodedData = atob(data);delete obj.responseDataUrl;obj.responseText = decodedData;const bytes = new Uint8Array(decodedData.length);for (let i = 0; i < decodedData.length; i++) {bytes[i] = decodedData.charCodeAt(i);}if ('blob' == type) { obj.response = new Blob([bytes], { type: mime }); }else if ('stream' == type) { obj.response = new ReadableStream({start(controller) {controller.enqueue(bytes);}, pull(controller) {controller.close();}, cancel() {}}); }else { obj.response = bytes.buffer; }}}else { obj.response = obj.responseText; }}");
        sb2.append(str3);
        sb2.append("})();");
        return sb2.toString();
    }

    public final String j(String secret) {
        kotlin.jvm.internal.h.f(secret, "secret");
        return "javascript:var es = window['" + secret + "']['gm_menus'];result = {};for (var k in es) {var items = es[k];var list = [];for (var i in items) {list.push(i);}result[k] = list;}JSON.stringify(result);";
    }

    public final String k(String str) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (('A' <= cCharAt && cCharAt < '[') || (('a' <= cCharAt && cCharAt < '{') || (('0' <= cCharAt && cCharAt < ':') || cCharAt == '_'))) {
                sb2.append(cCharAt);
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.h.e(string, "toString(...)");
        return string;
    }
}
