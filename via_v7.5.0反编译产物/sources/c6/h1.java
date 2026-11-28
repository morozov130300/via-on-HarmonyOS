package c6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f2014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f2020g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2021h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f2022i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f2023j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f2024k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f2025l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f2026m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Set f2027n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Set f2028o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Set f2029p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Set f2030q;

    public h1(Map values) {
        Integer numA;
        kotlin.jvm.internal.h.f(values, "values");
        this.f2014a = values;
        String str = (String) values.get("ds_u");
        this.f2015b = str == null ? "gg" : str;
        String str2 = (String) values.get("ds_g");
        this.f2016c = str2 == null ? "bd" : str2;
        this.f2017d = (String) values.get("bd");
        this.f2018e = (String) values.get("sg");
        this.f2019f = (String) values.get("sm");
        this.f2020g = (String) values.get("tt");
        this.f2021h = (String) values.get("hs");
        this.f2022i = (String) values.get("bn");
        this.f2023j = (String) values.get("gg");
        this.f2024k = (String) values.get("yh");
        String str3 = (String) values.get("mt");
        this.f2025l = str3 == null ? "s=nyzav&referrer_s=nyzav" : str3;
        String str4 = (String) values.get("fl1");
        this.f2026m = (str4 == null || (numA = a(str4)) == null) ? 0 : numA.intValue();
        this.f2027n = b("wlb", "youku.com,iqiyi.com,mgtv.com,qq.com");
        this.f2028o = b("wlr", "v.qq.com,youku.com,iqiyi.com,mgtv.com,bilibili.com,ximalaya.com,film.qq.com");
        this.f2029p = b("wls", "v.qq.com,film.qq.com");
        this.f2030q = c(this, "wld", null, 2, null);
    }

    public static /* synthetic */ Set c(h1 h1Var, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        return h1Var.b(str, str2);
    }

    public final Integer a(String str) {
        String strSubstring;
        int i10;
        int i11;
        if (kotlin.text.z.p0(str, '-', false, 2, null) || kotlin.text.z.p0(str, '+', false, 2, null)) {
            strSubstring = str.substring(1);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        } else {
            strSubstring = str;
        }
        if (kotlin.text.x.B(strSubstring, "0x", true)) {
            i10 = 2;
        } else {
            i10 = (kotlin.text.z.p0(strSubstring, '#', false, 2, null) || (strSubstring.length() > 1 && kotlin.text.z.p0(strSubstring, '0', false, 2, null))) ? 1 : 0;
        }
        if (i10 == 0) {
            i11 = 10;
        } else {
            i11 = (i10 == 1 && strSubstring.charAt(0) == '0') ? 8 : 16;
        }
        String strSubstring2 = strSubstring.substring(i10);
        kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
        if (kotlin.text.z.p0(strSubstring2, '-', false, 2, null) || kotlin.text.z.p0(strSubstring2, '+', false, 2, null)) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(kotlin.text.z.p0(str, '-', false, 2, null) ? "-" : "");
        sb2.append(strSubstring2);
        return kotlin.text.w.l(sb2.toString(), i11);
    }

    public final Set b(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(',');
        String str3 = (String) this.f2014a.get(str);
        if (str3 == null) {
            str3 = "";
        }
        sb2.append(str3);
        List listN0 = kotlin.text.z.n0(sb2.toString(), new char[]{','}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(e7.p.o(listN0, 10));
        Iterator it = listN0.iterator();
        while (it.hasNext()) {
            String lowerCase = kotlin.text.z.v0((String) it.next()).toString().toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
            arrayList.add(lowerCase);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        return e7.w.P(arrayList2);
    }

    public final String d() {
        return this.f2017d;
    }

    public final String e() {
        return this.f2022i;
    }

    public final String f() {
        return this.f2015b;
    }

    public final String g() {
        return this.f2016c;
    }

    public final String h() {
        return this.f2023j;
    }

    public final String i() {
        return this.f2021h;
    }

    public final String j() {
        return this.f2025l;
    }

    public final String k() {
        return this.f2019f;
    }

    public final String l() {
        return this.f2018e;
    }

    public final String m() {
        return this.f2020g;
    }

    public final String n() {
        return this.f2024k;
    }

    public final boolean o() {
        return (this.f2026m & 1) == 0;
    }

    public final boolean p(String str) {
        return t(this.f2027n, str);
    }

    public final boolean q(String str) {
        return t(this.f2030q, str);
    }

    public final boolean r(String str) {
        return t(this.f2029p, str);
    }

    public final boolean s(String str) {
        return t(this.f2028o, str);
    }

    public final boolean t(Set set, String str) {
        String strC;
        if (set.isEmpty() || str == null || str.length() == 0 || (strC = new z1(str).c()) == null) {
            return false;
        }
        String str2 = '.' + strC + '.';
        if (set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (kotlin.text.z.I(str2, '.' + ((String) it.next()) + '.', false, 2, null)) {
                return true;
            }
        }
        return false;
    }
}
