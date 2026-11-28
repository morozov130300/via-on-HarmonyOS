package c6;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f2140a = new z();

    public final String A(String str, String str2) {
        int iT;
        if (str2 == null || str2.length() == 0 || str == null || str.length() == 0 || (iT = kotlin.text.z.T(str, str2, 0, false, 6, null)) <= 0) {
            return null;
        }
        int length = str2.length();
        int i10 = iT - 1;
        char cCharAt = str.charAt(i10);
        if (cCharAt == '&') {
            int length2 = str.length();
            int i11 = iT + length;
            if (length2 < i11 + 1 || str.charAt(i11) == '&') {
                StringBuilder sb2 = new StringBuilder();
                String strSubstring = str.substring(0, i10);
                kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                sb2.append(strSubstring);
                String strSubstring2 = str.substring(i11);
                kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
                sb2.append(strSubstring2);
                return sb2.toString();
            }
        } else if (cCharAt == '?') {
            int i12 = length + iT;
            if (str.length() > i12 && str.charAt(i12) == '&') {
                StringBuilder sb3 = new StringBuilder();
                String strSubstring3 = str.substring(0, iT);
                kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
                sb3.append(strSubstring3);
                String strSubstring4 = str.substring(i12 + 1);
                kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
                sb3.append(strSubstring4);
                return sb3.toString();
            }
            if (str.length() == i12) {
                String strSubstring5 = str.substring(0, iT);
                kotlin.jvm.internal.h.e(strSubstring5, "substring(...)");
                return strSubstring5;
            }
        }
        return null;
    }

    public final String B(char c10, int i10) {
        if (i10 <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append(c10);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.h.e(string, "toString(...)");
        return string;
    }

    public final long a(String str) {
        int length = str.length();
        long j10 = 0;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            int length2 = str.length() - i11;
            double dS = kotlin.text.z.S("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", str.charAt(i10), 0, false, 6, null);
            double dPow = Math.pow(62.0d, length2);
            Double.isNaN(dS);
            j10 += (long) (dS * dPow);
            i10 = i11;
        }
        return j10;
    }

    public final String b(long j10) {
        if (j10 == 0) {
            return "0";
        }
        StringBuilder sb2 = new StringBuilder();
        while (j10 > 0) {
            long j11 = 62;
            int i10 = (int) (j10 % j11);
            j10 /= j11;
            sb2.insert(0, "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(i10));
        }
        String string = sb2.toString();
        kotlin.jvm.internal.h.e(string, "toString(...)");
        return string;
    }

    public final String c(String str) {
        int i10;
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        while (true) {
            if (length > 0) {
                int i11 = length - 7;
                String strSubstring = str.substring(Math.max(0, i11), length);
                kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                arrayList.add(0, strSubstring);
                length = i11;
            } else {
                try {
                    break;
                } catch (NumberFormatException unused) {
                }
            }
        }
        int size = arrayList.size();
        for (i10 = 0; i10 < size; i10++) {
            Object obj = arrayList.get(i10);
            kotlin.jvm.internal.h.e(obj, "get(...)");
            String strB = b(Long.parseLong((String) obj));
            if (i10 > 0 && strB.length() < 4) {
                sb2.append(B('0', 4 - strB.length()));
            }
            sb2.append(strB);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.h.e(string, "toString(...)");
        return string;
    }

    public final String d(String str) {
        int i10;
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        while (true) {
            if (length <= 0) {
                break;
            }
            int i11 = length - 4;
            String strSubstring = str.substring(Math.max(0, i11), length);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            arrayList.add(0, strSubstring);
            length = i11;
        }
        int size = arrayList.size();
        for (i10 = 0; i10 < size; i10++) {
            Object obj = arrayList.get(i10);
            kotlin.jvm.internal.h.e(obj, "get(...)");
            String strValueOf = String.valueOf(a((String) obj));
            if (i10 > 0 && strValueOf.length() < 7) {
                sb2.append(B('0', 7 - strValueOf.length()));
            }
            sb2.append(strValueOf);
        }
        return sb2.toString();
    }

    public final String e(String str) {
        String strH;
        int iT = kotlin.text.z.T(str, "://hanyu.baidu.com/hanyu-page/", 0, false, 6, null);
        if (iT <= 0 || (strH = a2.f1958a.h(str, "wd=", false)) == null) {
            return null;
        }
        int i10 = iT + 30;
        if (kotlin.text.x.C(str, "term/detail", i10, false, 4, null)) {
            return "https://hanyu.baidu.com/s?wd=" + strH + "&device=pc";
        }
        if (!kotlin.text.x.C(str, "zici/s", i10, false, 4, null)) {
            return null;
        }
        return "https://hanyu.baidu.com/zici/s?wd=" + strH;
    }

    public final String f(String str) {
        String strH;
        int iT = kotlin.text.z.T(str, "://hanyu.baidu.com/", 0, false, 6, null);
        if (iT <= 0) {
            return null;
        }
        int i10 = iT + 19;
        if (kotlin.text.x.C(str, "hanyu-page/", i10, false, 4, null) || (strH = a2.f1958a.h(str, "wd=", false)) == null) {
            return null;
        }
        if (kotlin.text.x.C(str, "s", i10, false, 4, null)) {
            return "https://hanyu.baidu.com/hanyu-page/term/detail?wd=" + strH;
        }
        if (!kotlin.text.x.C(str, "zici/s", i10, false, 4, null)) {
            return null;
        }
        return "https://hanyu.baidu.com/hanyu-page/zici/s?wd=" + strH;
    }

    public final String g(String str) {
        int iT = kotlin.text.z.T(str, "://pan.baidu.com/wap/home", 0, false, 6, null);
        if (iT <= 0) {
            return null;
        }
        int iT2 = kotlin.text.z.T(str, "/dir/", iT + 25, false, 4, null);
        if (iT2 <= 0) {
            return "https://pan.baidu.com/disk/main#/index?category=all";
        }
        int i10 = iT2 + 5;
        Integer numValueOf = Integer.valueOf(kotlin.text.z.S(str, '?', i10, false, 4, null));
        Integer num = numValueOf.intValue() >= 0 ? numValueOf : null;
        String strSubstring = str.substring(i10, num != null ? num.intValue() : str.length());
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        return "https://pan.baidu.com/disk/main#/index?category=all&path=" + strSubstring;
    }

    public final String h(String str) {
        int iT = kotlin.text.z.T(str, "://pan.baidu.com/disk/main", 0, false, 6, null);
        if (iT <= 0) {
            return null;
        }
        int iT2 = kotlin.text.z.T(str, "&path=", iT + 26, false, 4, null);
        if (iT2 <= 0) {
            return "https://pan.baidu.com/wap/home#/";
        }
        int i10 = iT2 + 6;
        Integer numValueOf = Integer.valueOf(kotlin.text.z.S(str, '&', i10, false, 4, null));
        Integer num = numValueOf.intValue() >= 0 ? numValueOf : null;
        String strSubstring = str.substring(i10, num != null ? num.intValue() : str.length());
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        return "https://pan.baidu.com/wap/home#/dir/" + strSubstring;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String i(String str) {
        int iT = kotlin.text.z.T(str, ".baidu.com/sf/vsearch?pd=", 0, false, 6, null);
        if (iT <= 0) {
            int iT2 = kotlin.text.z.T(str, "://m.baidu.com", 0, false, 6, null);
            if (iT2 <= 0) {
                return null;
            }
            String strSubstring = str.substring(iT2 + 14);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (!kotlin.text.z.I(strSubstring, "ie=", false, 2, null)) {
                strSubstring = kotlin.text.x.z(strSubstring, "/s?", "/s?ie=utf-8&", false, 4, null);
            }
            StringBuilder sb2 = new StringBuilder();
            String strSubstring2 = str.substring(0, iT2);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            sb2.append(strSubstring2);
            sb2.append("://www.baidu.com");
            sb2.append(strSubstring);
            return sb2.toString();
        }
        int i10 = iT + 25;
        int iS = kotlin.text.z.S(str, '&', i10, false, 4, null);
        if (iS < 0) {
            return null;
        }
        String strSubstring3 = str.substring(i10, iS);
        kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
        int iT3 = kotlin.text.z.T(str, "&word=", iS, false, 4, null);
        if (iT3 < 0) {
            return null;
        }
        int i11 = iT3 + 6;
        int iS2 = kotlin.text.z.S(str, '&', i11, false, 4, null);
        if (iS2 < 0) {
            iS2 = str.length();
        }
        String strSubstring4 = str.substring(i11, iS2);
        kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
        switch (strSubstring3) {
            case "tieba":
                return "https://tieba.baidu.com/f?ie=utf-8&kw=" + strSubstring4;
            case "wenku":
                return "https://wenku.baidu.com/search?word=" + strSubstring4;
            case "image_content":
                return "https://image.baidu.com/search/index?tn=baiduimage&ie=utf-8&word=" + strSubstring4;
            case "wenda_tab":
                return "https://zhidao.baidu.com/search?ie=utf-8&word=" + strSubstring4;
            default:
                if (strSubstring3.equals("tieba")) {
                    return "https://tieba.baidu.com/f?ie=utf-8&kw=" + strSubstring4;
                }
                return null;
        }
    }

    public final String j(String str) {
        int iT = kotlin.text.z.T(str, "://www.ccopyright.com.cn/mobile/", 0, false, 6, null);
        if (iT <= 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        String strSubstring = str.substring(0, iT);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        sb2.append(strSubstring);
        sb2.append("://www.ccopyright.com.cn/");
        String strSubstring2 = str.substring(iT + 32);
        kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
        sb2.append(strSubstring2);
        return sb2.toString();
    }

    public final String k(String str) {
        int iT = kotlin.text.z.T(str, "://www.ccopyright.com.cn/", 0, false, 6, null);
        if (iT <= 0) {
            return null;
        }
        int length = str.length();
        int i10 = iT + 25;
        int i11 = iT + 32;
        if (length >= i11) {
            String strSubstring = str.substring(i10, i11);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (kotlin.jvm.internal.h.a("mobile/", strSubstring)) {
                return null;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        String strSubstring2 = str.substring(0, i10);
        kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
        sb2.append(strSubstring2);
        sb2.append("mobile/");
        String strSubstring3 = str.substring(i10);
        kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
        sb2.append(strSubstring3);
        return sb2.toString();
    }

    public final String l(String str, boolean z10) {
        String[] strArr = {"://m.so.com", "://m.news.so.com", "://m.video.360kan.com", "://m.image.so.com", "://m.163.com", "://m.thepaper.cn", "://m.hao123.com", "://m.sohu.com/a/", "://m.huanqiu.com", "://m.guancha.cn", "://m.xs8.cn", "://m.autohome.com.cn", "://m.douban.com/movie/", "://m.douban.com/book/", "://m.douban.com/music/", "://m.douban.com/game/", "://m.douban.com/people/", "://m.hao123.com", "://m.guoxuedashi.net", "://h5.cloud.189.cn/main.html#/cloud/file/", "://new.m.taobao.com/detail.htm?", "://h5.m.taobao.com/awp/core/detail.htm?", "://main.m.taobao.com/security-h5-detail/home?", "://main.m.taobao.com/search/index.html?", "://main.m.taobao.com", "://item.m.jd.com/product/", "://pro.m.jd.com", "://m.jd.com", "://m.qidian.com", "://gf2-bbs.sunborngame.com/m/", "://m.cngwzj.com/", "://m.twitch.tv/", "://m.rumanhua.com/", "://m.zhtj.youth.cn/zhtj/", "://m.guancha.cn/", "://m.cctv.com/"};
        String[] strArr2 = {"://www.so.com", "://news.so.com", "://video.360kan.com", "://image.so.com", "://www.163.com", "://www.thepaper.cn", "://www.hao123.com", "://www.sohu.com/a/", "://www.huanqiu.com", "://www.guancha.cn", "://www.xs8.cn", "://www.autohome.com.cn", "://movie.douban.com/", "://book.douban.com/", "://music.douban.com/", "://game.douban.com/", "://www.douban.com/people/", "://www.hao123.com", "://www.guoxuedashi.net", "://cloud.189.cn/web/main/file/folder/", "://item.taobao.com/item.htm?", "://item.taobao.com/item.htm?", "://item.taobao.com/item.htm?", "://s.taobao.com/search?", "://www.taobao.com", "://item.jd.com/", "://pro.jd.com", "://www.jd.com", "://www.qidian.com", "://gf2-bbs.sunborngame.com/", "://www.cngwzj.com/", "://www.twitch.tv/", "://www.rumanhua.com/", "://zhtj.youth.cn/zhtj/", "://www.guancha.cn/", "://www.cctv.com/"};
        for (int i10 = 0; i10 < 36; i10++) {
            String str2 = z10 ? strArr[i10] : strArr2[i10];
            int iT = kotlin.text.z.T(str, str2, 0, false, 6, null);
            if (iT > 0) {
                String str3 = z10 ? strArr2[i10] : strArr[i10];
                StringBuilder sb2 = new StringBuilder();
                String strSubstring = str.substring(0, iT);
                kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                sb2.append(strSubstring);
                sb2.append(str3);
                String strSubstring2 = str.substring(iT + str2.length());
                kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
                sb2.append(strSubstring2);
                return sb2.toString();
            }
        }
        return null;
    }

    public final String m(String str, boolean z10) {
        return z10 ? n(str) : s(str);
    }

    public final String n(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String strI = i(str);
        if (strI == null) {
            strI = g(str);
        }
        if (strI == null) {
            strI = x(str);
        }
        if (strI == null) {
            strI = v(str);
        }
        if (strI == null) {
            strI = o(str);
        }
        if (strI == null) {
            strI = q(str);
        }
        if (strI == null) {
            strI = j(str);
        }
        if (strI == null) {
            strI = e(str);
        }
        if (strI == null) {
            strI = t(str);
        }
        return strI == null ? l(str, true) : strI;
    }

    public final String o(String str) {
        int iT = kotlin.text.z.T(str, "://m.hupu.com/bbs/", 0, false, 6, null);
        if (iT <= 0) {
            int iT2 = kotlin.text.z.T(str, "://m.hupu.com/", 0, false, 6, null);
            if (iT2 <= 0) {
                return null;
            }
            int i10 = iT2 + 14;
            if (i10 == str.length()) {
                StringBuilder sb2 = new StringBuilder();
                String strSubstring = str.substring(0, iT2);
                kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                sb2.append(strSubstring);
                sb2.append("://www.hupu.com/");
                return sb2.toString();
            }
            String strSubstring2 = str.substring(i10);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            String[] strArr = {"nba", "cba", "soccer", "gg"};
            for (int i11 = 0; i11 < 4; i11++) {
                String str2 = strArr[i11];
                if (kotlin.jvm.internal.h.a(str2, strSubstring2)) {
                    StringBuilder sb3 = new StringBuilder();
                    String strSubstring3 = str.substring(0, iT2);
                    kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
                    sb3.append(strSubstring3);
                    sb3.append("://");
                    sb3.append(str2);
                    sb3.append(".hupu.com/");
                    return sb3.toString();
                }
            }
            return null;
        }
        int i12 = iT + 18;
        int iT3 = kotlin.text.z.T(str, ".html", i12, false, 4, null);
        if (iT3 > 0) {
            StringBuilder sb4 = new StringBuilder();
            String strSubstring4 = str.substring(0, iT);
            kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
            sb4.append(strSubstring4);
            sb4.append("://bbs.hupu.com/");
            String strSubstring5 = str.substring(i12);
            kotlin.jvm.internal.h.e(strSubstring5, "substring(...)");
            sb4.append(strSubstring5);
            return sb4.toString();
        }
        if (iT3 < 0) {
            iT3 = kotlin.text.z.S(str, '?', i12, false, 4, null);
        }
        if (iT3 < 0) {
            if (kotlin.text.z.S(str, '/', i12, false, 4, null) > 0) {
                return str;
            }
            iT3 = str.length();
        }
        String strSubstring6 = str.substring(i12, iT3);
        kotlin.jvm.internal.h.e(strSubstring6, "substring(...)");
        StringBuilder sb5 = new StringBuilder();
        String strSubstring7 = str.substring(0, iT);
        kotlin.jvm.internal.h.e(strSubstring7, "substring(...)");
        sb5.append(strSubstring7);
        sb5.append("://bbs.hupu.com/");
        sb5.append(strSubstring6);
        sb5.append(".html");
        String strSubstring8 = str.substring(iT3);
        kotlin.jvm.internal.h.e(strSubstring8, "substring(...)");
        sb5.append(strSubstring8);
        return sb5.toString();
    }

    public final String p(String str) {
        int iT;
        String str2;
        int iT2 = kotlin.text.z.T(str, "://bbs.hupu.com/", 0, false, 6, null);
        if (iT2 > 0) {
            StringBuilder sb2 = new StringBuilder();
            String strSubstring = str.substring(0, iT2);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            sb2.append(strSubstring);
            sb2.append("://m.hupu.com/bbs/");
            String strSubstring2 = str.substring(iT2 + 16);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            sb2.append(strSubstring2);
            return sb2.toString();
        }
        int iT3 = kotlin.text.z.T(str, ".hupu.com/", 0, false, 6, null);
        if (iT3 <= 0 || iT3 + 10 != str.length() || (iT = kotlin.text.z.T(str, "://", 0, false, 6, null)) <= 0) {
            return null;
        }
        int i10 = iT + 3;
        String strSubstring3 = str.substring(i10, iT3);
        kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
        String[] strArr = {"nba", "cba", "soccer", "gg"};
        if (kotlin.jvm.internal.h.a("www", strSubstring3)) {
            StringBuilder sb3 = new StringBuilder();
            String strSubstring4 = str.substring(0, i10);
            kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
            sb3.append(strSubstring4);
            sb3.append("m.hupu.com/");
            return sb3.toString();
        }
        int i11 = 0;
        while (true) {
            if (i11 >= 4) {
                str2 = null;
                break;
            }
            str2 = strArr[i11];
            if (kotlin.jvm.internal.h.a(str2, strSubstring3)) {
                break;
            }
            i11++;
        }
        if (str2 != null) {
            StringBuilder sb4 = new StringBuilder();
            String strSubstring5 = str.substring(0, i10);
            kotlin.jvm.internal.h.e(strSubstring5, "substring(...)");
            sb4.append(strSubstring5);
            sb4.append("m.hupu.com/");
            sb4.append(str2);
            return sb4.toString();
        }
        return null;
    }

    public final String q(String str) {
        int i10;
        int iT;
        int iT2 = kotlin.text.z.T(str, "://m.ithome.com/html/", 0, false, 6, null);
        if (iT2 > 0 && (iT = kotlin.text.z.T(str, ".htm", (i10 = iT2 + 21), false, 4, null)) > 0 && (iT - iT2) - 21 == 6) {
            StringBuilder sb2 = new StringBuilder();
            String strSubstring = str.substring(0, iT2);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            sb2.append(strSubstring);
            sb2.append("://www.ithome.com/0/");
            String strSubstring2 = str.substring(i10, iT2 + 24);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            sb2.append(strSubstring2);
            sb2.append('/');
            String strSubstring3 = str.substring(iT - 3);
            kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
            sb2.append(strSubstring3);
            return sb2.toString();
        }
        int iT3 = kotlin.text.z.T(str, "://m.ithome.com/", 0, false, 6, null);
        if (iT3 <= 0) {
            return null;
        }
        int i11 = iT3 + 16;
        if (i11 != str.length() && (i11 >= str.length() || str.charAt(i11) != '#')) {
            return null;
        }
        StringBuilder sb3 = new StringBuilder();
        String strSubstring4 = str.substring(0, iT3);
        kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
        sb3.append(strSubstring4);
        sb3.append("://www.ithome.com/");
        return sb3.toString();
    }

    public final String r(String str) {
        int i10;
        int iT;
        int iT2 = kotlin.text.z.T(str, "://www.ithome.com/0/", 0, false, 6, null);
        if (iT2 > 0 && (iT = kotlin.text.z.T(str, ".htm", (i10 = iT2 + 20), false, 4, null)) > 0 && (iT - iT2) - 20 == 7) {
            StringBuilder sb2 = new StringBuilder();
            String strSubstring = str.substring(0, iT2);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            sb2.append(strSubstring);
            sb2.append("://m.ithome.com/html/");
            String strSubstring2 = str.substring(i10, iT2 + 23);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            sb2.append(strSubstring2);
            String strSubstring3 = str.substring(iT - 3);
            kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
            sb2.append(strSubstring3);
            return sb2.toString();
        }
        int iT3 = kotlin.text.z.T(str, "://www.ithome.com/", 0, false, 6, null);
        if (iT3 <= 0) {
            return null;
        }
        int i11 = iT3 + 18;
        if (i11 != str.length() && (i11 >= str.length() || str.charAt(i11) != '#')) {
            return null;
        }
        StringBuilder sb3 = new StringBuilder();
        String strSubstring4 = str.substring(0, iT3);
        kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
        sb3.append(strSubstring4);
        sb3.append("://m.ithome.com/");
        return sb3.toString();
    }

    public final String s(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String strH = h(str);
        if (strH == null) {
            strH = y(str);
        }
        if (strH == null) {
            strH = w(str);
        }
        if (strH == null) {
            strH = p(str);
        }
        if (strH == null) {
            strH = r(str);
        }
        if (strH == null) {
            strH = k(str);
        }
        if (strH == null) {
            strH = z(str);
        }
        if (strH == null) {
            strH = f(str);
        }
        if (strH == null) {
            strH = u(str);
        }
        return strH == null ? l(str, false) : strH;
    }

    public final String t(String str) {
        if (kotlin.text.z.T(str, "://wap.mail.qq.com/", 0, false, 6, null) <= 0) {
            return null;
        }
        return "https://mail.qq.com/";
    }

    public final String u(String str) {
        if (kotlin.text.z.T(str, "://mail.qq.com/", 0, false, 6, null) <= 0) {
            return null;
        }
        return "https://wap.mail.qq.com/";
    }

    public final String v(String str) {
        if (kotlin.text.z.T(str, "://so.toutiao.com/search?", 0, false, 6, null) <= 0 || kotlin.text.z.I(str, "dvpf=pc", false, 2, null)) {
            return null;
        }
        return str + "&dvpf=pc";
    }

    public final String w(String str) {
        if (kotlin.text.z.T(str, "://so.toutiao.com/search?", 0, false, 6, null) > 0) {
            return A(str, "dvpf=pc");
        }
        return null;
    }

    public final String x(String str) {
        int iT = kotlin.text.z.T(str, "://card.weibo.com/article/m/show/id/", 0, false, 6, null);
        if (iT > 0) {
            int i10 = iT + 36;
            int iS = kotlin.text.z.S(str, '?', i10, false, 4, null);
            if (iS < 0) {
                iS = str.length();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https://weibo.com/ttarticle/p/show?id=");
            String strSubstring = str.substring(i10, iS);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            sb2.append(strSubstring);
            return sb2.toString();
        }
        int iT2 = kotlin.text.z.T(str, "://m.weibo.cn/detail/", 0, false, 6, null);
        if (iT2 <= 0) {
            int iT3 = kotlin.text.z.T(str, "://m.weibo.cn", 0, false, 6, null);
            if (iT3 <= 0) {
                return null;
            }
            StringBuilder sb3 = new StringBuilder();
            String strSubstring2 = str.substring(0, iT3);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            sb3.append(strSubstring2);
            sb3.append("://weibo.com");
            String strSubstring3 = str.substring(iT3 + 13);
            kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
            sb3.append(strSubstring3);
            return sb3.toString();
        }
        int i11 = iT2 + 21;
        int iS2 = kotlin.text.z.S(str, '?', i11, false, 4, null);
        if (iS2 == -1) {
            iS2 = kotlin.text.z.S(str, '/', i11, false, 4, null);
        }
        if (iS2 == -1) {
            iS2 = str.length();
        }
        String strSubstring4 = str.substring(i11, iS2);
        kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
        StringBuilder sb4 = new StringBuilder();
        sb4.append("https://weibo.com/0/");
        sb4.append(c(strSubstring4));
        String strSubstring5 = str.substring(iS2);
        kotlin.jvm.internal.h.e(strSubstring5, "substring(...)");
        sb4.append(strSubstring5);
        return sb4.toString();
    }

    public final String y(String str) {
        int i10;
        int iS;
        int iT = kotlin.text.z.T(str, "://weibo.com/ttarticle/p/show?id=", 0, false, 6, null);
        if (iT > 0) {
            int i11 = iT + 33;
            int iS2 = kotlin.text.z.S(str, '&', i11, false, 4, null);
            if (iS2 < 0) {
                iS2 = str.length();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https://card.weibo.com/article/m/show/id/");
            String strSubstring = str.substring(i11, iS2);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            sb2.append(strSubstring);
            return sb2.toString();
        }
        if (kotlin.text.z.T(str, "://weibo.com/newlogin?", 0, false, 6, null) > 0) {
            return "https://m.weibo.cn/";
        }
        int iT2 = kotlin.text.z.T(str, "://weibo.com", 0, false, 6, null);
        if (iT2 <= 0) {
            return null;
        }
        int i12 = iT2 + 1;
        if (str.length() > i12 && str.charAt(i12) == '/' && (iS = kotlin.text.z.S(str, '/', (i10 = iT2 + 13), false, 4, null)) > 0) {
            w wVar = w.f2124a;
            String strSubstring2 = str.substring(i10, iS);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            if (wVar.h(strSubstring2, 4, null)) {
                int i13 = iS + 1;
                int iS3 = kotlin.text.z.S(str, '?', i13, false, 4, null);
                if (iS3 == -1) {
                    iS3 = kotlin.text.z.S(str, '/', i13, false, 4, null);
                }
                if (iS3 == -1) {
                    iS3 = str.length();
                }
                String strSubstring3 = str.substring(i13, iS3);
                kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("https://m.weibo.cn/detail/");
                sb3.append(d(strSubstring3));
                String strSubstring4 = str.substring(iS3);
                kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
                sb3.append(strSubstring4);
                return sb3.toString();
            }
        }
        StringBuilder sb4 = new StringBuilder();
        String strSubstring5 = str.substring(0, iT2);
        kotlin.jvm.internal.h.e(strSubstring5, "substring(...)");
        sb4.append(strSubstring5);
        sb4.append("://m.weibo.cn");
        String strSubstring6 = str.substring(iT2 + 12);
        kotlin.jvm.internal.h.e(strSubstring6, "substring(...)");
        sb4.append(strSubstring6);
        return sb4.toString();
    }

    public final String z(String str) {
        int iT = kotlin.text.z.T(str, "://www.youtube.com/", 0, false, 6, null);
        if (iT <= 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        String strSubstring = str.substring(0, iT);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        sb2.append(strSubstring);
        sb2.append("://m.youtube.com/");
        String strSubstring2 = str.substring(iT + 19);
        kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
        sb2.append(strSubstring2);
        return A(sb2.toString(), "app=desktop");
    }
}
