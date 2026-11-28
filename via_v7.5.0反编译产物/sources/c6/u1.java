package c6;

import com.tuyafeng.wormhole.HttpTextEncoding;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.text.Regex;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u1 f2108a = new u1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f2109b = new Regex("<suggestion data=\"([^\"]*)\"/>");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Regex f2110c = new Regex("[,\\{]\\s*\"?s\"?\\s*:\\s*(\\[(?:\"(?:[^\"\\\\]++|\\\\.)*\"|[^\"\\[\\]]++)*\\])\\s*\\}\\s*\\)\\s*;?\\s*$");

    public static final String e(kotlin.text.i it) {
        kotlin.jvm.internal.h.f(it, "it");
        return b0.f1960a.c((String) it.a().get(1));
    }

    public static final boolean f(String it) {
        kotlin.jvm.internal.h.f(it, "it");
        return it.length() > 0;
    }

    public final String c(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : kotlin.text.x.p(str)) {
            int i10 = b10 & 255;
            char c10 = (char) i10;
            if (('a' > c10 || c10 >= '{') && (('A' > c10 || c10 >= '[') && (('0' > c10 || c10 >= ':') && !kotlin.text.z.H("-_.*", c10, false, 2, null)))) {
                sb2.append('%');
                sb2.append("0123456789ABCDEF".charAt(i10 >> 4));
                sb2.append("0123456789ABCDEF".charAt(b10 & 15));
            } else {
                sb2.append(c10);
            }
        }
        return sb2.toString();
    }

    public final List d(int i10, String str, String locale, int i11) {
        String strB;
        kotlin.jvm.internal.h.f(locale, "locale");
        if (str == null || str.length() == 0 || i11 <= 0) {
            return e7.o.h();
        }
        String strH = h(i10, str, locale);
        if (strH == null) {
            return e7.o.h();
        }
        k0 k0VarC = l0.a(new j0(strH, null, "Mozilla/5.0", 3000, null, null, i10 == 2 ? HttpTextEncoding.GB2312 : HttpTextEncoding.UTF8, 50, null)).c();
        if (k0VarC != null) {
            if (k0VarC.a() != 200) {
                k0VarC = null;
            }
            if (k0VarC != null && (strB = k0VarC.b()) != null) {
                return g(i10, strB, i11);
            }
        }
        return e7.o.h();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0155  */
    public final List g(int i10, String body, int i11) {
        List listA;
        String str;
        List list;
        String strZ;
        String strZ2;
        String strZ3;
        String strZ4;
        String strZ5;
        String strZ6;
        kotlin.jvm.internal.h.f(body, "body");
        if (i10 == 1) {
            return u7.m.k(u7.m.j(u7.m.h(u7.m.i(Regex.findAll$default(f2109b, body, 0, 2, null), new p7.l() { // from class: c6.s1
                @Override // p7.l
                public final Object invoke(Object obj) {
                    return u1.e((kotlin.text.i) obj);
                }
            }), new p7.l() { // from class: c6.t1
                @Override // p7.l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(u1.f((String) obj));
                }
            }), i11));
        }
        if (i10 == 2) {
            if (!kotlin.text.x.D(kotlin.text.z.w0(body).toString(), "suggestion({", false, 2, null)) {
                return e7.o.h();
            }
            kotlin.text.i iVarFind$default = Regex.find$default(f2110c, body, 0, 2, null);
            if (iVarFind$default == null || (listA = iVarFind$default.a()) == null || (str = (String) listA.get(1)) == null) {
                return e7.o.h();
            }
            Map mapD = k.d("{\"s\":" + str + '}');
            Object obj = mapD != null ? mapD.get("s") : null;
            if (obj instanceof List) {
                list = (List) obj;
            } else {
                list = null;
            }
        } else if (i10 == 3) {
            int iS = kotlin.text.z.S(body, '{', 0, false, 6, null);
            int iY = kotlin.text.z.Y(body, '}', 0, false, 6, null);
            if (iS < 0 || iY < iS) {
                return e7.o.h();
            }
            String strSubstring = body.substring(iS, iY + 1);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            Map mapD2 = k.d(strSubstring);
            Object obj2 = mapD2 != null ? mapD2.get("AS") : null;
            Map map = obj2 instanceof Map ? (Map) obj2 : null;
            Object obj3 = map != null ? map.get("Results") : null;
            List list2 = obj3 instanceof List ? (List) obj3 : null;
            Object objY = list2 != null ? e7.w.y(list2) : null;
            Map map2 = objY instanceof Map ? (Map) objY : null;
            Object obj4 = map2 != null ? map2.get("Suggests") : null;
            if (obj4 instanceof List) {
                list = (List) obj4;
            } else {
                list = null;
            }
        } else if (i10 == 4) {
            Map mapD3 = k.d(body);
            Object obj5 = mapD3 != null ? mapD3.get("result") : null;
            if (obj5 instanceof List) {
                list = (List) obj5;
            } else {
                list = null;
            }
        } else {
            list = null;
        }
        if (list == null) {
            return e7.o.h();
        }
        List listJ = e7.w.J(list, i11);
        ArrayList arrayList = new ArrayList();
        for (Object obj6 : listJ) {
            if (i10 == 2) {
                String str2 = obj6 instanceof String ? (String) obj6 : null;
                if (str2 == null || (strZ = kotlin.text.x.z(str2, "&amp;", "&", false, 4, null)) == null || (strZ2 = kotlin.text.x.z(strZ, "&lt;", "<", false, 4, null)) == null || (strZ3 = kotlin.text.x.z(strZ2, "&gt;", ">", false, 4, null)) == null || (strZ4 = kotlin.text.x.z(strZ3, "&quot;", "\"", false, 4, null)) == null || (strZ5 = kotlin.text.x.z(strZ4, "&apos;", "'", false, 4, null)) == null) {
                    strZ6 = null;
                } else {
                    strZ6 = kotlin.text.x.z(strZ5, "&#39;", "'", false, 4, null);
                }
            } else if (i10 != 3) {
                Map map3 = obj6 instanceof Map ? (Map) obj6 : null;
                Object obj7 = map3 != null ? map3.get("word") : null;
                if (obj7 instanceof String) {
                    strZ6 = (String) obj7;
                } else {
                    strZ6 = null;
                }
            } else {
                Map map4 = obj6 instanceof Map ? (Map) obj6 : null;
                Object obj8 = map4 != null ? map4.get("Txt") : null;
                if (obj8 instanceof String) {
                    strZ6 = (String) obj8;
                } else {
                    strZ6 = null;
                }
            }
            if (strZ6 == null || strZ6.length() <= 0) {
                strZ6 = null;
            }
            if (strZ6 != null) {
                arrayList.add(strZ6);
            }
        }
        return arrayList;
    }

    public final String h(int i10, String keyword, String locale) {
        kotlin.jvm.internal.h.f(keyword, "keyword");
        kotlin.jvm.internal.h.f(locale, "locale");
        String strC = c(keyword);
        if (i10 == 1) {
            String strY = kotlin.text.x.y(kotlin.text.z.u0(locale, '@', null, 2, null), '_', '-', false, 4, null);
            String strU0 = kotlin.text.z.u0(strY, '-', null, 2, null);
            if (kotlin.jvm.internal.h.a(strU0, "zh") && (kotlin.text.x.r(strY, "-TW", false, 2, null) || kotlin.text.x.r(strY, "-HK", false, 2, null))) {
                strU0 = "zh-hant";
            }
            return "https://clients1.google.com/complete/search?hl=" + c(strU0) + "&output=toolbar&q=" + strC;
        }
        if (i10 == 2) {
            return "https://suggestion.baidu.com/su?wd=" + strC + "&cb=suggestion";
        }
        if (i10 == 3) {
            return "https://api.bing.com/qsonhs.aspx?type=cb&cb=s&q=" + strC;
        }
        if (i10 != 4) {
            return null;
        }
        return "https://sug.so.360.cn/suggest?encodein=utf-8&encodeout=utf-8&format=json&word=" + strC;
    }
}
