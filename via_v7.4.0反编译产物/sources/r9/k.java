package r9;

import android.util.Base64;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k implements e {

    /* renamed from: q, reason: collision with root package name */
    public static volatile k f11601q;

    /* renamed from: a, reason: collision with root package name */
    public String f11602a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f11603b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f11604c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f11605d = null;

    /* renamed from: e, reason: collision with root package name */
    public String f11606e = null;

    /* renamed from: f, reason: collision with root package name */
    public String f11607f = null;

    /* renamed from: g, reason: collision with root package name */
    public String f11608g = null;

    /* renamed from: h, reason: collision with root package name */
    public String f11609h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f11610i = null;

    /* renamed from: j, reason: collision with root package name */
    public String f11611j = null;

    /* renamed from: k, reason: collision with root package name */
    public String f11612k = null;

    /* renamed from: l, reason: collision with root package name */
    public String[] f11613l = null;

    /* renamed from: m, reason: collision with root package name */
    public String[] f11614m = null;

    /* renamed from: n, reason: collision with root package name */
    public String[] f11615n = null;

    /* renamed from: o, reason: collision with root package name */
    public String[] f11616o = null;

    /* renamed from: p, reason: collision with root package name */
    public final h f11617p = new h(0);

    public k() {
        t(null);
    }

    public static k q() {
        if (f11601q == null) {
            synchronized (k.class) {
                try {
                    if (f11601q == null) {
                        f11601q = new k();
                    }
                } finally {
                }
            }
        }
        return f11601q;
    }

    @Override // r9.e
    public boolean a(String str) {
        return s(this.f11614m, r(str));
    }

    @Override // r9.e
    public String b() {
        return this.f11603b;
    }

    @Override // r9.e
    public boolean c(String str) {
        return s(this.f11616o, r(str));
    }

    @Override // r9.e
    public String d() {
        return this.f11608g;
    }

    @Override // r9.e
    public boolean e(String str) {
        return s(this.f11615n, r(str));
    }

    @Override // r9.e
    public String f() {
        return this.f11611j;
    }

    @Override // r9.e
    public String g() {
        return this.f11606e;
    }

    @Override // r9.e
    public String h() {
        return this.f11612k;
    }

    @Override // r9.e
    public String i() {
        return this.f11604c;
    }

    @Override // r9.e
    public String j() {
        return this.f11609h;
    }

    @Override // r9.e
    public String k() {
        return this.f11607f;
    }

    @Override // r9.e
    public h l() {
        return this.f11617p;
    }

    @Override // r9.e
    public String m() {
        return this.f11605d;
    }

    @Override // r9.e
    public boolean n(String str) {
        return s(this.f11613l, r(str));
    }

    @Override // r9.e
    public String o() {
        return this.f11602a;
    }

    @Override // r9.e
    public String p() {
        return this.f11610i;
    }

    public final String r(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.indexOf(47) < 0) {
            return str;
        }
        int iIndexOf = str.indexOf("://");
        if (iIndexOf < 0) {
            return null;
        }
        String strSubstring = str.substring(iIndexOf + 3);
        int iIndexOf2 = strSubstring.indexOf(47);
        if (iIndexOf2 >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf2);
        }
        String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
        if (lowerCase.isEmpty()) {
            return null;
        }
        return lowerCase;
    }

    public final boolean s(String[] strArr, String str) {
        if (strArr != null && strArr.length != 0 && str != null && !str.isEmpty()) {
            for (String str2 : strArr) {
                int iIndexOf = str.indexOf(str2);
                if (iIndexOf >= 0 && ((iIndexOf <= 0 || str.charAt(iIndexOf - 1) == '.') && (str2.length() + iIndexOf >= str.length() || str.charAt(iIndexOf + str2.length()) == '.'))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void t(a aVar) {
        if (aVar == null) {
            aVar = new b();
        }
        this.f11604c = aVar.getString("bd", "1022282z");
        this.f11605d = aVar.getString("sg", null);
        this.f11607f = aVar.getString("tt", null);
        this.f11606e = aVar.getString("sm", null);
        this.f11608g = aVar.getString("hs", null);
        this.f11609h = aVar.getString("bn", null);
        this.f11610i = aVar.getString("gg", null);
        this.f11611j = aVar.getString("yh", null);
        this.f11612k = aVar.getString("mt", "s=nyzav&referrer_s=nyzav");
        this.f11602a = aVar.getString("ds_u", "gg");
        this.f11603b = aVar.getString("ds_g", "bd");
        u(aVar);
        this.f11617p.d(aVar.getInt("fl1", 0));
    }

    public final void u(a aVar) {
        String str;
        String str2;
        String str3;
        String string = aVar.getString("wlb", "");
        if (string == null || string.isEmpty()) {
            str = "";
        } else {
            str = string + ",";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        Charset charset = m8.a.f8676a;
        sb2.append(new String(Base64.decode("eW91a3UuY29tLGlxaXlpLmNvbSxtZ3R2LmNvbSxxcS5jb20=".getBytes(charset), 0)));
        this.f11613l = v(sb2.toString(), ',');
        String string2 = aVar.getString("wlr", "");
        if (string2 == null || string2.isEmpty()) {
            str2 = "";
        } else {
            str2 = string2 + ",";
        }
        this.f11614m = v(str2 + new String(Base64.decode("di5xcS5jb20seW91a3UuY29tLGlxaXlpLmNvbSxtZ3R2LmNvbSxiaWxpYmlsaS5jb20seGltYWxheWEuY29tLGZpbG0ucXEuY29t".getBytes(charset), 0)), ',');
        String string3 = aVar.getString("wls", "");
        if (string3 == null || string3.isEmpty()) {
            str3 = "";
        } else {
            str3 = string3 + ",";
        }
        this.f11615n = v(str3 + new String(Base64.decode("di5xcS5jb20sZmlsbS5xcS5jb20=".getBytes(charset), 0)), ',');
        this.f11616o = v(aVar.getString("wld", ""), ',');
    }

    public final String[] v(String str, char c10) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int iIndexOf = str.indexOf(c10, i10);
            if (iIndexOf < 0) {
                iIndexOf = length;
            }
            hashSet.add(str.substring(i10, iIndexOf).trim().toLowerCase(Locale.ROOT));
            i10 = iIndexOf + 1;
        }
        return (String[]) hashSet.toArray(new String[0]);
    }
}
