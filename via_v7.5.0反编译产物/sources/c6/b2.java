package c6;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b2 f1963a = new b2();

    public final String a(String scriptId, String secret, int i10, int i11, List dependencies, String source) {
        kotlin.jvm.internal.h.f(scriptId, "scriptId");
        kotlin.jvm.internal.h.f(secret, "secret");
        kotlin.jvm.internal.h.f(dependencies, "dependencies");
        kotlin.jvm.internal.h.f(source, "source");
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = (i11 & 1) == 0;
        if (z10) {
            sb2.append("(function(){\n");
        }
        sb2.append(f1963a.e(scriptId, secret, i10));
        Iterator it = dependencies.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
            sb2.append("\n\n");
        }
        sb2.append(source);
        if (z10) {
            sb2.append("\n})();");
        }
        return sb2.toString();
    }

    public final String b(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("window.");
        sb2.append(str2);
        sb2.append("(JSON.stringify({secret:'");
        sb2.append(str);
        sb2.append("', identifier:'");
        sb2.append(str3);
        sb2.append("', document:window.__viaDocument&&window.__viaDocument.id, name:'");
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

    public final String c(String str, String str2, String str3, String str4) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("window.");
        sb2.append(str2);
        sb2.append("(JSON.stringify({secret:'");
        sb2.append(str);
        sb2.append("', document:window.__viaDocument&&window.__viaDocument.id, name:'");
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

    public final String d(String sendStage) {
        kotlin.jvm.internal.h.f(sendStage, "sendStage");
        return kotlin.text.q.i("\n        (function(send){\n          var sent=0;\n          function stage(value){if(sent&value)return;sent|=value;send(value);}\n          stage(1);\n          if(document.readyState==='loading')document.addEventListener('DOMContentLoaded',function end(){document.removeEventListener('DOMContentLoaded',end);stage(2);});else stage(2);\n          if(document.readyState!=='complete')window.addEventListener('load',function idle(){window.removeEventListener('load',idle);stage(4);});else stage(4);\n        })(function(stage){" + sendStage + "});\n    ");
    }

    public final String e(String scriptId, String secret, int i10) {
        String str;
        String str2;
        b2 b2Var;
        String str3;
        String str4;
        String str5;
        String str6;
        kotlin.jvm.internal.h.f(scriptId, "scriptId");
        kotlin.jvm.internal.h.f(secret, "secret");
        String strN = n("GM_" + secret + '_');
        String strN2 = n("NP_" + secret);
        String str7 = ((("var unsafeWindow = window;\nconst GM = {};\n" + k(strN2)) + "const " + strN + "info = function() {let cached; const obj = {}; Object.defineProperty(obj, 'VALUE', {get: function() {if (cached == undefined) {cached = JSON.parse(" + b(secret, strN2, scriptId, "info", null) + ");} return cached;}, configurable: false, enumerable: true}); return obj;}();\n") + "const GM_info = " + strN + "info.VALUE;\n") + "GM.info = " + strN + "info.VALUE;\n";
        if (i10 == 0) {
            return str7;
        }
        if ((10485763 & i10) != 0) {
            str = strN + "JSONStringify";
            str2 = strN + "JSONParse";
            str7 = (str7 + i(str, "v", "return JSON.stringify(v,function(k,v){if(typeof v==='bigint'){return undefined}if(v instanceof Number){return '{}';}if(v!==v){return 'NaN'}if(v===Infinity){return 'Infinity'}if(v===-Infinity){return '-Infinity'}return v});")) + i(str2, "v", "return JSON.parse(v,function(k,v){if(v==='{}'){return {}}if(v==='NaN'){return NaN}if(v==='Infinity'){return Infinity}if(v==='-Infinity'){return -Infinity}return v});");
        } else {
            str = "JSON.stringify";
            str2 = "JSON.parse";
        }
        String string = str7;
        String str8 = str;
        String str9 = str2;
        if ((8388609 & i10) != 0) {
            String str10 = strN + "setValue";
            String str11 = string + i(str10, "name, value", "v = value; try {v = " + str8 + "(v);} catch(e) {};" + b(secret, strN2, scriptId, "setValue", "{name: name, value: v}") + ';');
            if ((i10 & 1) == 1) {
                str11 = (str11 + g(str10, "setValue")) + "var GM_setValues=function(a){if(a)for(var b in a)GM_setValue(b,a[b])};\n";
            }
            string = str11;
            if ((i10 & 8388608) == 8388608) {
                string = (string + h(str10, "setValue", "name, value", true)) + "GM.setValues=function(a){return new Promise(function(c,d){if(a){for(var b in a)" + str10 + "(b,a[b]);c()}else d(\"No data\")})};\n";
            }
        }
        if ((2097154 & i10) != 0) {
            String str12 = strN + "getValue";
            String str13 = string + i(str12, "name, defaultValue", "var dv = defaultValue;try {dv = " + str8 + "(defaultValue);} catch(e) {};var v = " + b(secret, strN2, scriptId, "getValue", "{name: name, value: dv}") + ";if(v == 'undefined') { return undefined; };try {v = " + str9 + "(v);} catch(e) {};return v;");
            if ((i10 & 2) == 2) {
                str13 = (str13 + g(str12, "getValue")) + "var GM_getValues=function(b){var c={};if(!b)return c;if(Array.isArray(b))for(var a in b)c[a]=GM_getValue(a);else for(a in b)c[a]=GM_getValue(a,b[a]);return c};\n";
            }
            string = str13;
            if ((i10 & 2097152) == 2097152) {
                string = (string + h(str12, "getValue", "name, defaultValue", true)) + "GM.getValues=function(a){return new Promise(function(d,c){if(a){c={};if(!a)return d({});if(Array.isArray(a))for(var b in a)c[b]=" + str12 + "(b);else for(b in a)c[b]=" + str12 + "(b,a[b]);d(c)}else c(\"No data\")})};\n";
            }
        }
        if ((1048584 & i10) != 0) {
            String str14 = strN + "deleteValue";
            String str15 = string + i(str14, "name", b(secret, strN2, scriptId, "deleteValue", "{name: name}") + ';');
            if ((i10 & 8) == 8) {
                str15 = (str15 + g(str14, "deleteValue")) + "var GM_deleteValues=function(a){if(a&&\"number\"===typeof a.length)for(var b=0,c=a.length;b<c;b++)try{GM_deleteValue(a[b])}catch(d){}};\n";
            }
            string = str15;
            if ((i10 & 1048576) == 1048576) {
                string = (string + h(str14, "deleteValue", "name", true)) + "GM.deleteValues=function(b){return new Promise(function(c,a){if(b&&\"number\"===typeof b.length){a=0;for(var d=b.length;a<d;a++)try{" + str14 + "(b[a])}catch(e){}c()}else a(\"No array\")})};\n";
            }
        }
        if ((4194308 & i10) != 0) {
            String str16 = strN + "listValues";
            String str17 = string + i(str16, "", "var s = " + b(secret, strN2, scriptId, "listValues", null) + ";return s.split(\",\");");
            if ((i10 & 4) == 4) {
                str17 = str17 + g(str16, "listValues");
            }
            string = str17;
            if ((i10 & 4194304) == 4194304) {
                string = string + h(str16, "listValues", "", true);
            }
        }
        if ((33554560 & i10) != 0) {
            String str18 = strN + "addElement";
            String str19 = string + i(str18, "parent, tag, attrs, callback", "if (typeof parent === 'string') { return " + str18 + "(undefined, parent, tag || {}, attrs); }var e = document.createElement(tag);if (attrs) {for (var k in attrs) { if (k == 'textContent') { e.textContent = attrs[k]; continue; }; try{e.setAttribute(k, attrs[k]);}catch(e){} };};if (parent == undefined) { parent = document.head || document.documentElement; }if (parent) { parent.appendChild(e); };if (callback) { callback() }return e;");
            if ((i10 & 128) == 128) {
                str19 = str19 + g(str18, "addElement");
            }
            if ((i10 & 33554432) == 33554432) {
                string = str19 + h(str18, "addElement", "parent, tag, attrs, callback", true);
            } else {
                string = str19;
            }
        }
        if ((16777280 & i10) != 0) {
            String str20 = strN + "addStyle";
            String str21 = string + i(str20, "css, callback", "if (!css) { return; };var h = document.head || document.documentElement;if (!h) { return; };var e = document.createElement('style');e.type = 'text/css';e.textContent = css;h.appendChild(e);if (callback) { callback() }return e;");
            if ((i10 & 64) == 64) {
                str21 = str21 + g(str20, "addStyle");
            }
            string = str21;
            if ((i10 & 16777216) == 16777216) {
                string = string + h(str20, "addStyle", "css, callback", true);
            }
        }
        if ((i10 & 512) == 512) {
            string = string + "var GM_log = function(message) {" + b(secret, strN2, scriptId, "log", "{message: message}") + "};\n";
        }
        if ((67108880 & i10) != 0) {
            String str22 = strN + "getResourceURL";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("var r = ");
            b2Var = this;
            sb2.append(b2Var.b(secret, strN2, scriptId, "getResourceURL", "{resource: resourceName}"));
            sb2.append(";if (r === 'undefined') {return null} return r;");
            String str23 = string + b2Var.i(str22, "resourceName", sb2.toString());
            if ((i10 & 16) == 16) {
                str23 = str23 + b2Var.g(str22, "getResourceURL");
            }
            string = str23;
            if ((67108864 & i10) == 67108864) {
                string = string + b2Var.h(str22, "getResourceUrl", "resourceName", true);
            }
        } else {
            b2Var = this;
        }
        int i11 = i10 & 32;
        if (i11 != 0) {
            String str24 = strN + "getResourceText";
            string = string + b2Var.i(str24, "resourceName", "var r = " + b2Var.b(secret, strN2, scriptId, "getResourceText", "{resource: resourceName}") + ";if (r === 'undefined') {return null} return r;");
            if (i11 == 32) {
                string = string + b2Var.g(str24, "getResourceText");
            }
        }
        if ((1073742848 & i10) != 0) {
            String str25 = strN + "setClipboard";
            String str26 = string + b2Var.i(str25, "data, type", b2Var.b(secret, strN2, scriptId, "setClipboard", "{data: data, type: type}") + ';');
            if ((i10 & 1024) == 1024) {
                str26 = str26 + b2Var.g(str25, "setClipboard");
            }
            string = str26;
            if ((1073741824 & i10) == 1073741824) {
                string = string + b2Var.h(str25, "setClipboard", "data, type", false);
            }
        }
        if ((i10 & 2048) == 2048) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(string);
            sb3.append("var GM_download = function(url, name) {if ((typeof url) == 'object') {name = url.name;url = url.url;};if (!name) { name = ''; };");
            str3 = scriptId;
            str4 = secret;
            sb3.append(b2Var.b(str4, strN2, str3, "download", "{url: url, name: name}"));
            sb3.append(";};\n");
            string = sb3.toString();
        } else {
            str3 = scriptId;
            str4 = secret;
        }
        if (((-2147483392) & i10) != 0) {
            String str27 = strN + "xmlhttpRequest";
            String strN3 = b2Var.n("V_" + str3 + y0.e() + '_');
            String str28 = (((string + "var generateRandomString=function(c){for(var a=\"\",b=0;b<c;b++)a+=\"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz\".charAt(Math.floor(62*Math.random()));return a};\n") + b2Var.i(str27, "details", "var identifier = generateRandomString(8);if (details.onabort) { window[identifier+'" + strN3 + "GM_onAbortCallback'] = details.onabort;details.onabort = identifier+'" + strN3 + "GM_onAbortCallback'; }if (details.onerror) { window[identifier+'" + strN3 + "GM_onErrorCallback'] = details.onerror;details.onerror = identifier+'" + strN3 + "GM_onErrorCallback'; }if (details.onload) { window[identifier+'" + strN3 + "GM_onLoadCallback'] = details.onload;details.onload = identifier+'" + strN3 + "GM_onLoadCallback'; }if (details.onloadstart) { window[identifier+'" + strN3 + "GM_onLoadStartCallback'] = details.onloadstart;details.onloadstart = identifier+'" + strN3 + "GM_onLoadStartCallback'; }if (details.onprogress) { window[identifier+'" + strN3 + "GM_onProgressCallback'] = details.onprogress;details.onprogress = identifier+'" + strN3 + "GM_onProgressCallback'; }if (details.onreadystatechange) { window[identifier+'" + strN3 + "GM_onReadyStateChange'] = details.onreadystatechange;details.onreadystatechange = identifier+'" + strN3 + "GM_onReadyStateChange'; }if (details.ontimeout) { window[identifier+'" + strN3 + "GM_onTimeoutCallback'] = details.ontimeout;details.ontimeout = identifier+'" + strN3 + "GM_onTimeoutCallback'; }if (details.upload) {if (details.upload.onprogress) { window[identifier+'" + strN3 + "GM_uploadOnProgressCallback'] = details.upload.onprogress;details.upload.onprogress = identifier+'" + strN3 + "GM_uploadOnProgressCallback'; }}if (details.data instanceof FormData) { details.data = new URLSearchParams(details.data).toString(); }if (details.data instanceof Array) { details.data = details.data.join(','); }if (details.data instanceof URLSearchParams) { details.data = details.data.toString(); }details.v_ua = navigator.userAgent;if(window.via2 && window.via2.postMessage){window.via2.postMessage(JSON.stringify({action:118,request:{secret:'" + str4 + "',identifier:'" + str3 + "',name:'xmlhttpRequest',arguments:{details:JSON.stringify(details)}}}));}else if(window.webkit&&window.webkit.messageHandlers.viaUserscript){window.webkit.messageHandlers.viaUserscript.postMessage({document:window.__viaDocument.id,url:location.href,request:{secret:'" + str4 + "',identifier:'" + str3 + "',name:'xmlhttpRequest',arguments:{details:JSON.stringify(details)}}});}else{" + b2Var.b(str4, strN2, str3, "xmlhttpRequest", "{details: JSON.stringify(details)}") + ";}")) + str27 + ".UNSENT=0;" + str27 + ".OPENED=1;" + str27 + ".HEADERS_RECEIVED=2;" + str27 + ".LOADING=3;" + str27 + ".DONE=4;\n") + str27 + ".RESPONSE_TYPE_ARRAYBUFFER='arraybuffer';" + str27 + ".RESPONSE_TYPE_BLOB='blob';" + str27 + ".RESPONSE_TYPE_DOCUMENT='document';" + str27 + ".RESPONSE_TYPE_JSON='json';" + str27 + ".RESPONSE_TYPE_STREAM='stream';" + str27 + ".RESPONSE_TYPE_TEXT='text';\n";
            if ((i10 & 256) == 256) {
                str28 = str28 + b2Var.g(str27, "xmlhttpRequest");
            }
            string = str28;
            if ((Integer.MIN_VALUE & i10) == Integer.MIN_VALUE) {
                string = string + b2Var.h(str27, "xmlHttpRequest", "details", false);
            }
        }
        if ((i10 & 8192) == 8192) {
            string = string + "var GM_addValueChangeListener = function(name, callback) {};\n";
        }
        if ((i10 & 16384) == 16384) {
            string = string + "var GM_removeValueChangeListener = function(listenerId) {};\n";
        }
        if ((268468224 & i10) != 0) {
            String str29 = strN + "openInTab";
            StringBuilder sb4 = new StringBuilder();
            sb4.append("if ((typeof options) != 'object') { options = { active: (!options ? false : true) }}; ");
            str5 = scriptId;
            str6 = secret;
            sb4.append(b2Var.b(str6, strN2, str5, "openInTab", "{url: url, options: JSON.stringify(options)}"));
            sb4.append(';');
            String str30 = string + b2Var.i(str29, "url, options", sb4.toString());
            if ((32768 & i10) == 32768) {
                str30 = str30 + b2Var.g(str29, "openInTab");
            }
            string = str30;
            if ((268435456 & i10) == 268435456) {
                string = string + b2Var.h(str29, "openInTab", "url, options", false);
            }
        } else {
            str5 = scriptId;
            str6 = secret;
        }
        if ((536936448 & i10) != 0) {
            String str31 = strN + "registerMenuCommand";
            String str32 = string + b2Var.i(str31, "name, func, key", "if (!func) { return; };if (!window['" + str6 + "']) window['" + str6 + "'] = {};if (!window['" + str6 + "']['gm_menus']) window['" + str6 + "']['gm_menus'] = {};if (!window['" + str6 + "']['gm_menus']['" + str5 + "']) window['" + str6 + "']['gm_menus']['" + str5 + "'] = {};window['" + str6 + "']['gm_menus']['" + str5 + "'][name] = func;return name;");
            if ((65536 & i10) == 65536) {
                str32 = str32 + b2Var.g(str31, "registerMenuCommand");
            }
            if ((i10 & 536870912) == 536870912) {
                string = str32 + b2Var.h(str31, "registerMenuCommand", "name, func, key", false);
            } else {
                string = str32;
            }
        }
        if ((537001984 & i10) != 0) {
            String str33 = strN + "unregisterMenuCommand";
            string = (string + b2Var.i(str33, "name", "if (!name) { return; };if (!window['" + str6 + "']) { return; }if (!window['" + str6 + "']['gm_menus']) { return; }if (!window['" + str6 + "']['gm_menus']['" + str5 + "']) { return; }delete window['" + str6 + "']['gm_menus']['" + str5 + "'][name];")) + b2Var.g(str33, "unregisterMenuCommand");
            if ((i10 & 536870912) == 536870912) {
                string = string + b2Var.h(str33, "unregisterMenuCommand", "name", false);
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

    public final String f(String secret) {
        kotlin.jvm.internal.h.f(secret, "secret");
        String strN = n("NP_" + secret);
        return "(function () {let key = 'via-fake-tampermonkey';if (window[key]) {return;};" + k(strN) + "try {window[key] = true;window.external.Tampermonkey = {getVersion: function(e) {e({version:'4.5.1', id: 'Via'});},openOptions: function(e, t) {" + c(secret, strN, "openOptions", "{name: e, namespace: t}") + ";},isInstalled: function(e, t, n) {var v = " + c(secret, strN, "isInstalled", "{name: e, namespace: t}") + ";if(v === 'undefined') { return; };try {v = JSON.parse(v);} catch(e) {};n(v);}}} catch (err) {}})();";
    }

    public final String g(String str, String str2) {
        return "var GM_" + str2 + " = " + str + ";\n";
    }

    public final String h(String str, String str2, String str3, boolean z10) {
        if (!z10) {
            return "GM." + str2 + " = " + str + ";\n";
        }
        return "GM." + str2 + " = function(" + str3 + ") { return new Promise(function(resolve, reject) { resolve(" + str + '(' + str3 + "));});};\n";
    }

    public final String i(String str, String str2, String str3) {
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

    public final String j(String secret, String scriptId, String menuName) {
        kotlin.jvm.internal.h.f(secret, "secret");
        kotlin.jvm.internal.h.f(scriptId, "scriptId");
        kotlin.jvm.internal.h.f(menuName, "menuName");
        return "javascript:window[" + o(secret) + "]['gm_menus'][" + o(scriptId) + "][" + o(menuName) + "]();";
    }

    public final String k(String str) {
        return "if(!window." + str + ") {const nativePrompt = window.via_gm && window.via_gm.call ? window.via_gm.call.bind(window.via_gm) : window.prompt;Object.defineProperty(window, '" + str + "', {value: nativePrompt,writable: false,configurable: false,enumerable: true});}";
    }

    public final String l(String[] strArr, String str) {
        String str2;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        Iterator itA = kotlin.jvm.internal.b.a(strArr);
        String str3 = "";
        while (itA.hasNext()) {
            String str4 = (String) itA.next();
            if (str4 != null && str4.length() != 0) {
                str3 = str3 + "window." + str4 + "(obj);";
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

    public final String m(String secret) {
        kotlin.jvm.internal.h.f(secret, "secret");
        return "javascript:var es = window['" + secret + "']['gm_menus'];result = {};for (var k in es) {var items = es[k];var list = [];for (var i in items) {list.push(i);}result[k] = list;}JSON.stringify(result);";
    }

    public final String n(String str) {
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

    public final String o(String value) {
        kotlin.jvm.internal.h.f(value, "value");
        StringBuilder sb2 = new StringBuilder();
        sb2.append('\"');
        int length = value.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = value.charAt(i10);
            if (cCharAt == '\"' || cCharAt == '\\') {
                sb2.append('\\');
                sb2.append(cCharAt);
            } else if (kotlin.jvm.internal.h.h(cCharAt, 32) < 0 || cCharAt == 8232 || cCharAt == 8233) {
                sb2.append("\\u");
                String string = Integer.toString(cCharAt, kotlin.text.a.a(16));
                kotlin.jvm.internal.h.e(string, "toString(...)");
                sb2.append(kotlin.text.z.e0(string, 4, '0'));
            } else {
                sb2.append(cCharAt);
            }
        }
        sb2.append('\"');
        return sb2.toString();
    }
}
