package i6;

import i6.k0;
import java.util.List;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final f0 f6991a = new f0();

    public final String a(String str, String str2) {
        String strD;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || (strD = i.f7005a.d(str)) == null) {
            return null;
        }
        return "https://fanyi.baidu.com/transpage?query=" + strD + "&source=url&ie=utf8&from=auto&to=" + e(str2) + "&render=1";
    }

    public final String b(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return "window.via.postMessage('" + str + "', JSON.stringify({action: 108}));";
    }

    public final String c(String str, String str2) {
        String strD;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || (strD = i.f7005a.d(str)) == null) {
            return null;
        }
        return "https://translate.google.com/translate?sl=auto&tl=" + str2 + "&u=" + strD;
    }

    public final String d(String str, String str2) {
        String strD;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || (strD = i.f7005a.d(str)) == null) {
            return null;
        }
        return "http://webtrans.yodao.com/webTransPc/index.html#/?url=" + strD + "&from=auto&to=" + e(str2) + "&type=1";
    }

    public final String e(String str) {
        int iV = v7.m.v(str, '-', 0, false, 6, null);
        if (iV < 0) {
            return str;
        }
        String strSubstring = str.substring(0, iV);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final boolean f(k0 k0Var, String str, String str2) {
        if (k0Var == null || str == null || str.length() == 0) {
            return false;
        }
        List listG = v7.l.n(str, "zh-", false, 2, null) ? k7.l.g("en", "ar", "ja", "ko", "ru", "fr", "de", "es", "it", "pt", "zh-CN", "zh-TW") : k7.l.g("en", "ar", "az", "be", "bn", "cs", "da", "de", "es", "fa", "fil", "fr", "hi", "hr", "hu", Name.MARK, "in", "it", "js", "ko", "lt", "ne", "pl", "pt", "pt-BR", "ro", "ru", "sk", "sl", "ta", "th", "tr", "uk", "uz", "vi", "zh-CN", "zh-TW");
        int iIndexOf = listG.indexOf(str);
        if (iIndexOf >= 0) {
            listG.remove(iIndexOf);
        }
        k7.p.k(listG);
        listG.add(0, str);
        k0.a.a(k0Var, e0.f6989a.a(k7.t.t(listG, ",", null, null, 0, null, null, 62, null), b(str2)), null, 2, null);
        return true;
    }

    public final boolean g(k0 k0Var, String str, String str2) {
        if (k0Var == null) {
            return false;
        }
        k0.a.a(k0Var, e0.f6989a.b((str == null || str.length() == 0 || !v7.l.n(str, "zh-", false, 2, null)) ? "english" : (v7.l.f(str, "TW", false, 2, null) || v7.l.f(str, "HK", false, 2, null)) ? "chinese_traditional" : "chinese_simplified", b(str2)), null, 2, null);
        return true;
    }
}
