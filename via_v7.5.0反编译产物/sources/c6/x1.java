package c6;

import java.util.List;
import java.util.Map;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x1 f2137a = new x1();

    public final String a(String str, String str2) {
        String strG;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || (strG = b0.f1960a.g(str)) == null) {
            return null;
        }
        return "https://fanyi.baidu.com/transpage?query=" + strG + "&source=url&ie=utf8&from=auto&to=" + i(str2) + "&render=1";
    }

    public final String b(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return "window.via.postMessage('" + str + "', JSON.stringify({action: 108}));";
    }

    public final String c(String str, String str2) {
        String strG;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || (strG = b0.f1960a.g(str)) == null) {
            return null;
        }
        return "https://translate.google.com/translate?sl=auto&tl=" + str2 + "&u=" + strG;
    }

    public final String d(String secret) {
        kotlin.jvm.internal.h.f(secret, "secret");
        return "(function(){try{var runtime=window[" + b2.f1963a.o(secret) + "],menus=runtime&&runtime.gm_menus,items=menus&&menus['434ac3d1c485c21999283f07f207746d'],selected=null;if(!items)return false;for(var name in items){if(!Object.prototype.hasOwnProperty.call(items,name)||typeof items[name]!=='function')continue;if(name.indexOf('Translate to ')===0){selected=name;break;}if(name==='Open settings')selected=name;}if(selected===null)return false;items[selected]();return true;}catch(e){return false;}})();";
    }

    public final Map e(String base64I18n) {
        kotlin.jvm.internal.h.f(base64I18n, "base64I18n");
        return e7.a0.d(d7.f.a("translatorI18n", "data:application/json;charset=utf-8;base64," + kotlin.text.x.z(base64I18n, "+", "%2B", false, 4, null)));
    }

    public final String f() {
        return v.f2111a.b();
    }

    public final String g() {
        return "// ==UserScript==\n// @name         Translate Web Pages\n// @namespace    https://github.com/xnx3/translate\n// @version      3.14.0.20261031.8\n// @description  Translate web pages with translate.js using userscript APIs for translation requests.\n// @author       Guan Leiming (original author)\n// @match        http://*/*\n// @match        https://*/*\n// @run-at       document-end\n// @grant        GM_xmlhttpRequest\n// @resource     translatorI18n data:application/json;charset=utf-8;base64,eyJwYW5lbFRpdGxlIjoi57+76K+R572R6aG1IiwidGFyZ2V0TGFuZ3VhZ2UiOiLnm67moIfor63oqIAiLCJwcm92aWRlciI6Iue/u+ivkea6kCIsImF1dG9UcmFuc2xhdGVTaXRlIjoi6Ieq5Yqo57+76K+R6K+l572R56uZIiwidHJhbnNsYXRlIjoi57+76K+RIiwiY2FuY2VsIjoi5Y+W5raIIiwicmVzdG9yZU9yaWdpbmFsIjoi5oGi5aSN5Y6f5paHIiwidHJhbnNsYXRpb25TdGFydEZhaWxlZCI6IuaXoOazleW8gOWni+e/u+ivke+8jOivt+mHjeivleOAgiIsInRyYW5zbGF0aW9uRmFpbGVkIjoi57+76K+R5aSx6LSl77yM6K+356iN5ZCO6YeN6K+V44CCIiwidHJhbnNsYXRpb25QYXVzZWQiOiLov57nu60gNSDmrKEgSFRUUCDor7fmsYLlpLHotKXvvIznv7vor5Hlt7LmmoLlgZzjgILku7vliqHlt7Lkv53nlZnvvIzngrnlh7vigJznv7vor5HigJ3nu6fnu63jgIIiLCJvcGVuVHJhbnNsYXRpb25TZXR0aW5ncyI6IuaJk+W8gOe/u+ivkeiuvue9riIsInNldHRpbmdzRHJhZ0hpbnQiOiLnv7vor5Horr7nva4iLCJwcm92aWRlclRlc3RJZGxlIjoi5rWL6K+V57+76K+R5rqQ6L+e6YCa5oCnIiwicHJvdmlkZXJUZXN0VGVzdGluZyI6Iuato+WcqOa1i+ivlee/u+ivkea6kOi/numAmuaApyIsInByb3ZpZGVyVGVzdFN1Y2Nlc3MiOiLnv7vor5HmupDlj6/nlKjvvIzngrnlh7vph43mlrDmtYvor5UiLCJwcm92aWRlclRlc3RFcnJvciI6Iue/u+ivkea6kOS4jeWPr+eUqO+8jOeCueWHu+mHjeaWsOa1i+ivlSIsInRyYW5zbGF0aW9uTG9hZGluZyI6Iuato+WcqOe/u+ivkeW9k+WJjeWGheWuuSIsInRyYW5zbGF0aW9uQ29tcGxldGUiOiLlvZPliY3lhoXlrrnnv7vor5HlrozmiJAiLCJkaXNwbGF5TW9kZSI6IuaYvuekuuaooeW8jyIsInRyYW5zbGF0aW9uT25seSI6IuS7heivkeaWhyIsImJpbGluZ3VhbCI6IuWPjOivrSJ9\n// @grant        GM_getResourceText\n// @grant        GM_getValue\n// @grant        GM_setValue\n// @grant        GM_unregisterMenuCommand\n// @grant        GM_registerMenuCommand\n// @connect      translate.googleapis.com\n// @connect      edge.microsoft.com\n// ==/UserScript==";
    }

    public final int h() {
        return 153267;
    }

    public final String i(String str) {
        int iS = kotlin.text.z.S(str, '-', 0, false, 6, null);
        if (iS < 0) {
            return str;
        }
        String strSubstring = str.substring(0, iS);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final boolean j(c2 c2Var, String str, String str2) {
        if (c2Var == null || str == null || str.length() == 0) {
            return false;
        }
        String str3 = kotlin.jvm.internal.h.a(str, "in") ? Name.MARK : str;
        List listL = kotlin.text.x.D(str, "zh-", false, 2, null) ? e7.o.l("en", "ar", "ja", "ko", "ru", "fr", "de", "es", "it", "pt", "zh-CN", "zh-TW") : e7.o.l("en", "ar", "az", "be", "bn", "cs", "da", "de", "es", "fa", "fil", "fr", "hi", "hr", "hu", Name.MARK, "it", "ja", "ko", "lt", "mr", "ne", "pl", "pt", "pt-BR", "ro", "ru", "sk", "sl", "ta", "th", "tr", "uk", "ur", "uz", "vi", "zh-CN", "zh-TW");
        listL.remove(str3);
        e7.s.p(listL);
        listL.add(0, str3);
        c2.a.a(c2Var, w1.f2130a.a(e7.w.E(listL, ",", null, null, 0, null, null, 62, null), b(str2)), null, 2, null);
        return true;
    }

    public final boolean k(c2 c2Var, String str, String str2) {
        String str3;
        if (c2Var == null) {
            return false;
        }
        if (str == null || str.length() == 0 || !kotlin.text.x.D(str, "zh-", false, 2, null)) {
            str3 = "english";
        } else {
            str3 = (kotlin.text.x.r(str, "TW", false, 2, null) || kotlin.text.x.r(str, "HK", false, 2, null)) ? "chinese_traditional" : "chinese_simplified";
        }
        c2.a.a(c2Var, w1.f2130a.b(str3, b(str2)), null, 2, null);
        return true;
    }
}
