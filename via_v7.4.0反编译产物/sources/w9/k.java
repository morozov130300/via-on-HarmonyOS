package w9;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.GeolocationPermissions;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import z8.b1;
import z8.b4;
import z8.c0;
import z8.c1;
import z8.t1;
import z8.v0;
import z8.v2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k implements l {

    /* renamed from: a, reason: collision with root package name */
    public final m f13361a;

    /* renamed from: b, reason: collision with root package name */
    public final h f13362b;

    /* renamed from: c, reason: collision with root package name */
    public z9.h f13363c;

    /* renamed from: d, reason: collision with root package name */
    public aa.c f13364d;

    /* renamed from: e, reason: collision with root package name */
    public p f13365e;

    /* renamed from: f, reason: collision with root package name */
    public o f13366f;

    /* renamed from: g, reason: collision with root package name */
    public w9.a f13367g;

    /* renamed from: h, reason: collision with root package name */
    public d f13368h;

    /* renamed from: i, reason: collision with root package name */
    public x5.a f13369i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13370j;

    /* renamed from: k, reason: collision with root package name */
    public String f13371k;

    /* renamed from: l, reason: collision with root package name */
    public String f13372l;

    /* renamed from: o, reason: collision with root package name */
    public int f13375o;

    /* renamed from: m, reason: collision with root package name */
    public int f13373m = 0;

    /* renamed from: n, reason: collision with root package name */
    public String f13374n = "g" + this.f13373m;

    /* renamed from: p, reason: collision with root package name */
    public int f13376p = -1;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13377q = false;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends x9.j {
        public a(int i10) {
            super(i10);
        }

        @Override // x9.g
        public void a() {
            GeolocationPermissions.getInstance().clearAll();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends x9.j {
        public b(int i10) {
            super(i10);
        }

        @Override // x9.g
        public void a() {
            n.e().p(true);
        }
    }

    public k(m mVar, h hVar) {
        this.f13361a = mVar;
        this.f13362b = hVar;
        u3();
        k3();
        m3(e1());
        j3(b3());
        l3(K0());
        n3();
    }

    public static /* synthetic */ int Y2(x9.g gVar, x9.g gVar2) {
        return gVar.b() - gVar2.b();
    }

    @Override // w9.l
    public boolean A() {
        return a3("login", false);
    }

    @Override // w9.l
    public void A0(int i10) {
        q3("restoreclosedtabs", i10);
    }

    @Override // w9.l
    public String A1() {
        String strG3 = g3("sk", "");
        if (!strG3.isEmpty()) {
            return strG3;
        }
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        s3("sk", strReplace);
        return strReplace;
    }

    @Override // w9.l
    public boolean A2() {
        return v().i();
    }

    @Override // w9.l
    public int B() {
        String strN = n();
        String[] strArr = {"about:home", "about:blank", "about:bookmarks", "about:links"};
        for (int i10 = 0; i10 < 4; i10++) {
            if (strN.equals(strArr[i10])) {
                if (i10 == 3) {
                    return 0;
                }
                return i10;
            }
        }
        return 3;
    }

    @Override // w9.l
    public void B0(int i10) {
        q3("keymenu", i10);
    }

    @Override // w9.l
    public boolean B1() {
        return S2() && !i3().h();
    }

    @Override // w9.l
    public long B2() {
        return e3("savedata", 0L);
    }

    @Override // w9.l
    public String C() {
        return g3("searchtoolbardisabled", c0.f() ? "-1,-10" : null);
    }

    @Override // w9.l
    public void C0(int i10) {
        q3("urlbox", i10);
    }

    @Override // w9.l
    public long C1() {
        return e3("lastcleantime", System.currentTimeMillis());
    }

    @Override // w9.l
    public void C2(String str) {
        this.f13371k = str;
        this.f13372l = null;
    }

    @Override // w9.l
    public void D(String str, long j10) {
        r3("updater_" + str, j10);
    }

    @Override // w9.l
    public boolean D0() {
        return v().h();
    }

    @Override // w9.l
    public int[] D1() {
        String strG3 = g3("hiddenctxmenus", null);
        return strG3 == null ? new int[]{6} : strG3.isEmpty() ? new int[0] : g6.p.p(strG3, ',');
    }

    @Override // w9.l
    public void D2(int i10) {
        q3("duachoice", i10);
        this.f13372l = null;
    }

    @Override // w9.l
    public int E() {
        return d3("keyhome", 4);
    }

    @Override // w9.l
    public void E0(String str) {
        s3("dlmanager", str);
    }

    @Override // w9.l
    public boolean E1() {
        return v().u();
    }

    @Override // w9.l
    public void E2(int i10) {
        r3("savedata", B2() + i10);
    }

    @Override // w9.l
    public boolean F() {
        return v().f();
    }

    @Override // w9.l
    public int F0() {
        int iD3 = d3("textsize", 100);
        if (iD3 > 5) {
            return iD3;
        }
        int i10 = new int[]{130, 115, 100, 85, 70}[Z2(iD3, 5, 1, 3) - 1];
        J(i10);
        return i10;
    }

    @Override // w9.l
    public void F1(String str) {
        s3("bghome", str == null ? null : v0.b(str.trim()));
    }

    @Override // w9.l
    public int[] F2() {
        String strG3 = g3("hiddenmenus", null);
        return (strG3 == null || strG3.isEmpty()) ? new int[0] : g6.p.p(strG3, ',');
    }

    @Override // w9.l
    public int G() {
        return d3("adblockedtimes", 0);
    }

    @Override // w9.l
    public void G0(int i10) {
        q3("keytab", i10);
    }

    @Override // w9.l
    public void G1(i9.a aVar) {
        q3("bginfo", aVar.a());
    }

    @Override // w9.l
    public int G2() {
        return d3("ignoredsslwarning", 0);
    }

    @Override // w9.l
    public int H() {
        return d3("changelogcode", 0);
    }

    @Override // w9.l
    public void H0(String str) {
        s3("aibackend", str);
    }

    @Override // w9.l
    public void H1(o oVar) {
        this.f13366f = oVar;
        q3("webflag2", oVar.a());
        this.f13372l = null;
    }

    @Override // w9.l
    public void H2(int[] iArr) {
        s3("hiddenmenus", iArr == null ? null : g6.p.h(',', iArr));
    }

    @Override // w9.l
    public void I(int i10) {
        q3("uachoice", i10);
        this.f13372l = null;
    }

    @Override // w9.l
    public void I0(int i10) {
        q3("cleardata2", i10);
    }

    @Override // w9.l
    public String I1() {
        return g3("searchtoolbarorder", "");
    }

    @Override // w9.l
    public int I2() {
        return d3("agreement2", 0);
    }

    @Override // w9.l
    public void J(int i10) {
        if (i10 <= 5) {
            i10 = new int[]{130, 115, 100, 85, 70}[Z2(i10, 5, 1, 3) - 1];
        }
        q3("textsize", i10);
    }

    @Override // w9.l
    public void J0(int i10) {
        q3("gesturetoolbarright", i10);
    }

    @Override // w9.l
    public void J1(int i10) {
        q3("changelogcode", i10);
    }

    @Override // w9.l
    public void J2(int i10) {
        q3("adblockedtimes", G() + i10);
    }

    @Override // w9.l
    public String K(String str) {
        return g3("uastring", str);
    }

    @Override // w9.l
    public String K0() {
        return g3("language", null);
    }

    @Override // w9.l
    public void K1(String str) {
        s3("videoplayer", str);
    }

    @Override // w9.l
    public String K2() {
        return g3("dlmanager", null);
    }

    @Override // w9.l
    public void L(String str) {
        s3("skin", str);
    }

    @Override // w9.l
    public void L0(String str) {
        s3("username", str);
    }

    @Override // w9.l
    public String L1() {
        String str = this.f13372l;
        if (str != null) {
            if (str.isEmpty()) {
                return null;
            }
            return this.f13372l;
        }
        String strC = b4.c(l0(), K(Y1()), Y1(), m2().l(), U(), h2(), i1().e());
        this.f13372l = strC;
        if (strC == null) {
            this.f13372l = "";
        }
        if (this.f13372l.isEmpty()) {
            return null;
        }
        return this.f13372l;
    }

    @Override // w9.l
    public JSONObject L2(boolean z10) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : i.a()) {
            if (this.f13361a.contains(str)) {
                jSONObject.put(str, this.f13361a.getBoolean(str, false));
            }
        }
        for (String str2 : i.d()) {
            if (this.f13361a.contains(str2)) {
                String string = this.f13361a.getString(str2, "");
                if (!z10 || string.length() <= 4096) {
                    jSONObject.put(str2, string);
                }
            }
        }
        for (String str3 : i.b()) {
            if (this.f13361a.contains(str3)) {
                jSONObject.put(str3, this.f13361a.getInt(str3, 0));
            }
        }
        for (String str4 : i.c()) {
            if (this.f13361a.contains(str4)) {
                jSONObject.put(str4, this.f13361a.getLong(str4, 0L));
            }
        }
        return jSONObject;
    }

    @Override // w9.l
    public void M(boolean z10) {
        v().N(z10);
        q0(v());
    }

    @Override // w9.l
    public void M0(boolean z10) {
        v().O(z10);
        q0(v());
    }

    @Override // w9.l
    public int M1() {
        return d3("search2", v2.a());
    }

    @Override // w9.l
    public i9.a M2() {
        return new i9.a(d3("bginfo", 0));
    }

    @Override // w9.l
    public String N() {
        return g3("searchurl", "https://www.google.com/search?q=");
    }

    @Override // w9.l
    public void N0(int i10) {
        q3("data_version", i10);
    }

    @Override // w9.l
    public Typeface N1() {
        if (this.f13369i == null) {
            this.f13369i = x5.a.f(pa.r.g().g(a1()));
        }
        return (Typeface) this.f13369i.c();
    }

    @Override // w9.l
    public void N2(int i10) {
        q3("cleardataonexit2", i10);
    }

    @Override // w9.l
    public float O() {
        return Math.max(0.25f, Math.min(5.0f, d3("readaloudspeed", 100) / 100.0f));
    }

    @Override // w9.l
    public boolean O0() {
        return i3().g();
    }

    @Override // w9.l
    public boolean O1() {
        return v().l();
    }

    @Override // w9.l
    public void O2(int[] iArr) {
        s3("displayedmenus", iArr == null ? null : g6.p.h(',', iArr));
    }

    @Override // w9.l
    public String P(Context context) {
        String strX = x();
        return b1.o(strX) ? b1.m(context, Uri.parse(strX)) : c1.p(x());
    }

    @Override // w9.l
    public void P0(String str) {
        s3("searchtoolbardisabled", str);
    }

    @Override // w9.l
    public void P1(int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < iArr.length; i10++) {
            if (i10 > 0) {
                sb2.append(',');
            }
            sb2.append(iArr[i10]);
        }
        s3("disabledaddons", sb2.toString());
    }

    @Override // w9.l
    public void P2(String str) {
        s3("duastring", str);
        this.f13372l = null;
    }

    @Override // w9.l
    public void Q(boolean z10) {
        p3("nightcss", z10);
    }

    @Override // w9.l
    public void Q0(int i10) {
        q3("screenOrientation", i10);
    }

    @Override // w9.l
    public void Q1(int i10) {
        q3("keyback", i10);
    }

    @Override // w9.l
    public String Q2() {
        return this.f13363c.b();
    }

    @Override // w9.l
    public String R() {
        return g3("username", "");
    }

    @Override // w9.l
    public String R0() {
        return this.f13374n;
    }

    @Override // w9.l
    public int R1() {
        return d3("logochioce", 0);
    }

    @Override // w9.l
    public int R2() {
        return d3("bookmarksviewmode", 0);
    }

    @Override // w9.l
    public int S() {
        return d3("fab", 80);
    }

    @Override // w9.l
    public boolean S0() {
        return this.f13377q;
    }

    @Override // w9.l
    public void S1(boolean z10) {
        v().y(z10);
        q0(v());
    }

    @Override // w9.l
    public boolean S2() {
        return a3("nightcss", i3().h());
    }

    @Override // w9.l
    public void T(boolean z10) {
        this.f13377q = z10;
    }

    @Override // w9.l
    public void T0(boolean z10, boolean z11) {
        if (z10 == z11) {
            this.f13375o = z11 ? 3 : 2;
        } else {
            this.f13375o = z10 ? 1 : 0;
        }
        q3("nightmode2", this.f13375o);
    }

    @Override // w9.l
    public String T1() {
        return g3("skin", "");
    }

    @Override // w9.l
    public void T2(String str) {
        s3("psk", str);
    }

    @Override // w9.l
    public int U() {
        return d3("duachoice", 0);
    }

    @Override // w9.l
    public String U0() {
        return g3("aimodel", null);
    }

    @Override // w9.l
    public void U1(int[] iArr) {
        s3("hiddenctxmenus", iArr == null ? null : g6.p.h(',', iArr));
    }

    @Override // w9.l
    public int U2() {
        return d3("hwshorcut", 0);
    }

    @Override // w9.l
    public int V() {
        return d3("cleardata2", 7);
    }

    @Override // w9.l
    public int V0() {
        return d3("bookmarksorder", 0);
    }

    @Override // w9.l
    public String V1() {
        return g3("userpsw", "");
    }

    @Override // w9.l
    public i9.e V2() {
        return new i9.e(d3("searchinfo", 2490468));
    }

    @Override // w9.l
    public int W() {
        int i10 = this.f13376p;
        if (i10 >= 0) {
            return i10;
        }
        int iM1 = M1();
        int i11 = 2;
        if (iM1 != -2) {
            if (iM1 == -3) {
                i11 = 3;
            } else if (iM1 == -5) {
                i11 = 4;
            } else if (iM1 == -1 || (!z8.f.h() && !"zh-CN".equals(t1.g()))) {
                i11 = 1;
            }
        }
        this.f13376p = i11;
        return i11;
    }

    @Override // w9.l
    public void W0(i9.e eVar) {
        q3("searchinfo", eVar.b());
    }

    @Override // w9.l
    public void W1(i9.d dVar) {
        q3("logoinfo2", dVar.a());
    }

    @Override // w9.l
    public void W2(int i10) {
        q3("readertextsize", i10);
    }

    @Override // w9.l
    public i9.b X() {
        return new i9.b(d3("custominfo", 0));
    }

    @Override // w9.l
    public void X0(boolean z10) {
        v().A(z10);
        q0(v());
    }

    @Override // w9.l
    public int X1() {
        return d3("searchsuggestion", 31);
    }

    @Override // w9.l
    public i9.c X2() {
        return new i9.c(d3("favinfo", 1638446));
    }

    @Override // w9.l
    public void Y() {
        r3("lastcleantime", System.currentTimeMillis());
    }

    @Override // w9.l
    public void Y0(int i10) {
        q3("nightfilter", i10);
    }

    @Override // w9.l
    public String Y1() {
        return this.f13371k;
    }

    @Override // w9.l
    public boolean Z() {
        return S2() && i3().h();
    }

    @Override // w9.l
    public String Z0() {
        return m2().l() ? this.f13363c.a() : this.f13363c.getUrl();
    }

    @Override // w9.l
    public int Z1() {
        return d3("readertextsize", 17);
    }

    public final int Z2(int i10, int i11, int i12, int i13) {
        return (i10 < i12 || i10 > i11) ? i13 : i10;
    }

    @Override // w9.l
    public void a(int i10) {
        q3("ignoredsslwarning", i10);
    }

    @Override // w9.l
    public String a0() {
        String strG3 = g3("taghome", null);
        if (strG3 == null) {
            return null;
        }
        return v0.a(strG3);
    }

    @Override // w9.l
    public String a1() {
        return g3("uifont", "");
    }

    @Override // w9.l
    public void a2(String str) {
        s3("csstheme", str == null ? null : v0.b(str.trim()));
    }

    public final boolean a3(String str, boolean z10) {
        if (this.f13362b.contains(str)) {
            return this.f13362b.getBoolean(str, z10);
        }
        boolean z11 = this.f13361a.getBoolean(str, z10);
        this.f13362b.putBoolean(str, z11);
        return z11;
    }

    @Override // w9.l
    public void b(boolean z10) {
        v().E(z10);
        q0(v());
    }

    @Override // w9.l
    public void b0(int i10) {
        if (i10 >= 0) {
            i10 = -1;
        }
        q3("urlbarcolor", i10);
    }

    @Override // w9.l
    public void b1() {
        o3(M1());
    }

    @Override // w9.l
    public int b2() {
        return d3("readerthemecolor", 0);
    }

    public int b3() {
        int iD3 = d3("cloudtag", -1);
        if (iD3 >= 1 && iD3 <= 10000) {
            return iD3;
        }
        int iNextInt = new Random().nextInt(10000) + 1;
        q3("cloudtag", iNextInt);
        return iNextInt;
    }

    @Override // w9.l
    public String c() {
        String strG3 = g3("bghome", null);
        if (strG3 == null) {
            return null;
        }
        return v0.a(strG3);
    }

    @Override // w9.l
    public int c0() {
        int iD3 = d3("urlbarcolor", -1);
        if (iD3 < 0) {
            return iD3;
        }
        b0(-1);
        return -1;
    }

    @Override // w9.l
    public int c1() {
        return d3("fabrightaction", 13);
    }

    @Override // w9.l
    public int c2() {
        return d3("keyforward", 3);
    }

    public final String c3(String str) {
        String str2 = Environment.DIRECTORY_DOWNLOADS;
        if (str != null && !str2.equals(str)) {
            if (str.startsWith("content://")) {
                return str;
            }
            String strM = c1.m(str);
            if (strM != null && !strM.isEmpty()) {
                char cCharAt = strM.charAt(0);
                char c10 = File.separatorChar;
                if (cCharAt == c10) {
                    strM = strM.substring(1);
                }
                if (Build.VERSION.SDK_INT < 21 || strM.startsWith(str2) || strM.length() <= str2.length() || strM.charAt(str2.length()) == c10) {
                    return strM;
                }
                return str2 + c10 + strM;
            }
        }
        return str2;
    }

    @Override // w9.l
    public boolean d() {
        int i10 = this.f13375o;
        return i10 == 1 || i10 == 3;
    }

    @Override // w9.l
    public String d0() {
        String strG3 = g3("csstheme", null);
        if (strG3 == null) {
            return null;
        }
        return v0.a(strG3);
    }

    @Override // w9.l
    public void d1(int i10) {
        q3("hwshorcut", i10);
    }

    @Override // w9.l
    public void d2(int i10) {
        q3("fabupaction", i10);
    }

    public final int d3(String str, int i10) {
        if (this.f13362b.contains(str)) {
            return this.f13362b.getInt(str, i10);
        }
        int i11 = this.f13361a.getInt(str, i10);
        this.f13362b.putInt(str, i11);
        return i11;
    }

    @Override // w9.l
    public void e(String str) {
        s3("aimodel", str);
    }

    @Override // w9.l
    public String e0() {
        String strG3 = g3("iv", "");
        if (!strG3.isEmpty()) {
            return strG3;
        }
        String strSubstring = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
        s3("iv", strSubstring);
        return strSubstring;
    }

    @Override // w9.l
    public int e1() {
        return d3("cloudserver", z8.f.h() ? 1 : 0);
    }

    @Override // w9.l
    public void e2(String str) {
        s3("searchtoolbarorder", str);
    }

    public final long e3(String str, long j10) {
        if (this.f13362b.contains(str)) {
            return this.f13362b.getLong(str, j10);
        }
        long j11 = this.f13361a.getLong(str, j10);
        this.f13362b.putLong(str, j11);
        return j11;
    }

    @Override // w9.l
    public void f(int i10) {
        q3("searchsuggestion", i10);
    }

    @Override // w9.l
    public void f0(int i10) {
        q3("gesturetoolbarleft", i10);
    }

    @Override // w9.l
    public String f1() {
        return g3("searchshortcuts", "");
    }

    @Override // w9.l
    public void f2(String str) {
        if (str == null) {
            str = "";
        }
        s3("uastring", str.replaceAll("[\t\r\n]", " "));
        this.f13372l = null;
    }

    public int f3() {
        return d3("version", 0);
    }

    @Override // w9.l
    public boolean g() {
        return this.f13370j;
    }

    @Override // w9.l
    public void g0(p pVar) {
        this.f13365e = pVar;
        q3("webflag", pVar.a());
        this.f13372l = null;
    }

    @Override // w9.l
    public int g1() {
        return d3("urlbox", 0);
    }

    @Override // w9.l
    public int g2() {
        return d3("gesturetoolbarleft", 10);
    }

    public final String g3(String str, String str2) {
        if (this.f13362b.contains(str)) {
            return this.f13362b.getString(str, str2);
        }
        String string = this.f13361a.getString(str, str2);
        this.f13362b.putString(str, string);
        return string;
    }

    @Override // w9.l
    public void h(int i10) {
        q3("bookmarksviewmode", i10);
    }

    @Override // w9.l
    public int h0() {
        return d3("keytab", 5);
    }

    @Override // w9.l
    public void h1(i9.b bVar) {
        q3("custominfo", bVar.b());
    }

    @Override // w9.l
    public String h2() {
        return g3("duastring", null);
    }

    public int h3() {
        return d3("datachecker2", 0);
    }

    @Override // w9.l
    public void i(int i10) {
        q3("syncingchoice", i10);
    }

    @Override // w9.l
    public int i0() {
        return d3("screenOrientation", 1);
    }

    @Override // w9.l
    public o i1() {
        o oVar = this.f13366f;
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = new o(d3("webflag2", 0));
        this.f13366f = oVar2;
        return oVar2;
    }

    @Override // w9.l
    public int i2() {
        return d3("fabupaction", 23);
    }

    public final r i3() {
        return pa.r.o();
    }

    @Override // w9.l
    public void j(int i10) {
        q3("appui2", i10);
    }

    @Override // w9.l
    public void j0(boolean z10) {
        v().z(z10);
        q0(v());
    }

    @Override // w9.l
    public boolean j1(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        for (String str : i.a()) {
            if (!jSONObject.isNull(str)) {
                p3(str, jSONObject.optBoolean(str));
            }
        }
        for (String str2 : i.d()) {
            if (!jSONObject.isNull(str2)) {
                s3(str2, jSONObject.optString(str2));
            }
        }
        for (String str3 : i.b()) {
            if (!jSONObject.isNull(str3)) {
                q3(str3, jSONObject.optInt(str3));
            }
        }
        for (String str4 : i.c()) {
            if (!jSONObject.isNull(str4)) {
                r3(str4, jSONObject.optLong(str4));
            }
        }
        this.f13362b.a();
        this.f13372l = null;
        this.f13365e = null;
        this.f13367g = null;
        this.f13366f = null;
        b1();
        u3();
        return true;
    }

    @Override // w9.l
    public long j2(String str) {
        return e3("updated_" + str, 0L);
    }

    public final void j3(int i10) {
    }

    @Override // w9.l
    public void k(int i10) {
        q3("logochioce", i10);
    }

    @Override // w9.l
    public int k0() {
        return d3("keyback", 2);
    }

    @Override // w9.l
    public int k1() {
        return d3("syncingchoice", 0);
    }

    @Override // w9.l
    public void k2(String str) {
        s3("readercustomcss", v0.b(str));
    }

    public final void k3() {
        n.e().d(h3());
        pc.a.a("set flags to updating flags, flags: 0b%s", Integer.toBinaryString(h3()));
    }

    @Override // w9.l
    public int l() {
        return d3("cleardataonexit2", 0);
    }

    @Override // w9.l
    public int l0() {
        return d3("uachoice", 0);
    }

    @Override // w9.l
    public void l1(String str) {
        s3("searchshortcuts", str);
    }

    @Override // w9.l
    public void l2(int i10) {
        q3("keyhome", i10);
    }

    public final void l3(String str) {
        this.f13370j = (str == null || str.isEmpty()) ? false : true;
    }

    @Override // w9.l
    public void m(int i10) {
        q3("videoorientation", i10);
    }

    @Override // w9.l
    public boolean m0(boolean z10) {
        int i10 = this.f13375o;
        if (i10 != 0 && i10 != 1) {
            if (z10 != (i10 == 3)) {
                int i11 = z10 ? 3 : 2;
                this.f13375o = i11;
                q3("nightmode2", i11);
                n.e().p(true);
                return true;
            }
        }
        return false;
    }

    @Override // w9.l
    public int m1() {
        return d3("gesturetoolbarright", 11);
    }

    @Override // w9.l
    public p m2() {
        p pVar = this.f13365e;
        if (pVar != null) {
            return pVar;
        }
        try {
            p pVar2 = new p(d3("webflag", 96495261));
            this.f13365e = pVar2;
            return pVar2;
        } catch (Exception e10) {
            pc.a.i(e10);
            int iE3 = (int) e3("webflag", 96495261L);
            q3("webflag", iE3);
            p pVar3 = new p(iE3);
            this.f13365e = pVar3;
            return pVar3;
        }
    }

    public final void m3(int i10) {
        if (i10 == 1) {
            this.f13364d = new aa.a();
        } else {
            this.f13364d = new aa.b();
        }
    }

    @Override // w9.l
    public String n() {
        return g3("home", "about:home");
    }

    @Override // w9.l
    public String n0() {
        return g3("aibackend", null);
    }

    @Override // w9.l
    public void n1(int i10) {
        q3("bookmarksorder", i10);
    }

    @Override // w9.l
    public int n2() {
        int iD3 = d3("nightfilter", 77);
        if (iD3 < 0) {
            iD3 = 0;
        }
        if (iD3 > 255) {
            return 255;
        }
        return iD3;
    }

    public final void n3() {
        this.f13375o = d3("nightmode2", 2);
    }

    @Override // w9.l
    public void o(String str) {
        this.f13369i = null;
        s3("uifont", g6.p.m(str));
    }

    @Override // w9.l
    public int o0() {
        return d3("videoorientation", 0);
    }

    @Override // w9.l
    public void o1(String str) {
        s3("searchurl", str);
    }

    @Override // w9.l
    public void o2(int i10) {
        q3("fab", i10);
    }

    public final void o3(int i10) {
        this.f13363c = v2.c(i10, N());
        this.f13376p = -1;
    }

    @Override // w9.l
    public void p(String str) {
        s3("downloaddir", c3(str));
    }

    @Override // w9.l
    public void p0(String str, long j10) {
        r3("updated_" + str, j10);
    }

    @Override // w9.l
    public void p1(int i10) {
        q3("readerthemecolor", i10);
    }

    @Override // w9.l
    public void p2(boolean z10) {
        v().x(z10);
        q0(v());
    }

    public final void p3(String str, boolean z10) {
        this.f13362b.putBoolean(str, z10);
        this.f13361a.putBoolean(str, z10);
    }

    @Override // w9.l
    public void q(int i10) {
        o3(i10);
        q3("search2", i10);
    }

    @Override // w9.l
    public void q0(w9.a aVar) {
        this.f13367g = aVar;
        q3("appflag", aVar.a());
    }

    @Override // w9.l
    public int[] q1() {
        String strG3 = g3("disabledaddons", "");
        int i10 = 0;
        if (strG3 == null || strG3.isEmpty()) {
            return new int[0];
        }
        List<String> listO = g6.p.o(strG3, ',');
        int[] iArr = new int[listO.size()];
        for (String str : listO) {
            if (TextUtils.isDigitsOnly(str)) {
                iArr[i10] = Integer.parseInt(str);
                i10++;
            }
        }
        return Arrays.copyOf(iArr, i10);
    }

    @Override // w9.l
    public void q2(int i10) {
        q3("datachecker2", i10);
        pc.a.a("flush updating flags to: 0b%s", Integer.toBinaryString(i10));
    }

    public final void q3(String str, int i10) {
        this.f13362b.putInt(str, i10);
        this.f13361a.putInt(str, i10);
    }

    @Override // w9.l
    public void r(i9.c cVar) {
        q3("favinfo", cVar.a());
    }

    @Override // w9.l
    public i9.d r0() {
        return new i9.d(d3("logoinfo2", 193766400));
    }

    @Override // w9.l
    public void r1(int i10) {
        q3("agreement2", i10);
    }

    @Override // w9.l
    public int r2() {
        return d3("fullscreenmode", 0);
    }

    public final void r3(String str, long j10) {
        this.f13362b.putLong(str, j10);
        this.f13361a.putLong(str, j10);
    }

    @Override // w9.l
    public d s() {
        if (this.f13368h == null) {
            this.f13368h = new d(d3("labflag", 0));
        }
        return this.f13368h;
    }

    @Override // w9.l
    public void s0(int i10) {
        q3("fableftaction", i10);
    }

    @Override // w9.l
    public int s1() {
        return d3("data_version", 0);
    }

    @Override // w9.l
    public String s2() {
        return g3("psk", null);
    }

    public final void s3(String str, String str2) {
        this.f13362b.putString(str, str2);
        this.f13361a.putString(str, str2);
    }

    @Override // w9.l
    public void t(int i10) {
        q3("keyforward", i10);
    }

    @Override // w9.l
    public int[] t0() {
        String strG3 = g3("displayedmenus", null);
        if (strG3 != null) {
            return strG3.isEmpty() ? new int[0] : g6.p.p(strG3, ',');
        }
        int[] iArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 25, 34, 33, 39, 30, 28, 23, 29, 31, 35};
        if (c0.f()) {
            iArr[28] = 41;
        }
        return iArr;
    }

    @Override // w9.l
    public void t1(int i10) {
        q3("cloudserver", i10);
        m3(i10);
    }

    @Override // w9.l
    public void t2(int i10) {
        q3("fabdownaction", i10);
    }

    public void t3(int i10) {
        q3("version", i10);
    }

    @Override // w9.l
    public void u(d dVar) {
        this.f13368h = dVar;
        q3("labflag", dVar.a());
    }

    @Override // w9.l
    public void u0(float f10) {
        q3("readaloudspeed", (int) (Math.max(0.25f, Math.min(5.0f, f10)) * 100.0f));
    }

    @Override // w9.l
    public int u1() {
        return d3("restoreclosedtabs", 0);
    }

    @Override // w9.l
    public void u2(int i10) {
        q3("fullscreenmode", i10);
    }

    public final void u3() {
        int iF3 = f3();
        pc.a.a("check preferences, current version: %d", Integer.valueOf(iF3));
        ArrayList<x9.g> arrayList = new ArrayList();
        arrayList.add(new x9.c(this.f13361a, this));
        arrayList.add(new x9.d(this));
        arrayList.add(new x9.e());
        arrayList.add(new x9.k(this.f13361a, this));
        arrayList.add(new x9.m(this.f13361a, this));
        arrayList.add(new x9.h(this.f13361a, this));
        arrayList.add(new x9.f(this));
        arrayList.add(new x9.a(this.f13361a, this));
        arrayList.add(new x9.l(this));
        arrayList.add(new x9.i(this));
        arrayList.add(new x9.b(this));
        arrayList.add(new a(12));
        arrayList.add(new b(14));
        Collections.sort(arrayList, new Comparator() { // from class: w9.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return k.Y2((x9.g) obj, (x9.g) obj2);
            }
        });
        int iB = iF3;
        for (x9.g gVar : arrayList) {
            if (iF3 < gVar.b()) {
                iB = gVar.b();
                if (iF3 != 0) {
                    gVar.a();
                    pc.a.a("update preferences version to %d", Integer.valueOf(iB));
                }
            }
        }
        if (iB > iF3) {
            t3(iB);
        }
    }

    @Override // w9.l
    public w9.a v() {
        if (this.f13367g == null) {
            this.f13367g = new w9.a(d3("appflag", w9.a.f13355b));
        }
        return this.f13367g;
    }

    @Override // w9.l
    public int v0() {
        return d3("fableftaction", 12);
    }

    @Override // w9.l
    public void v1(int i10) {
        q3("fabrightaction", i10);
    }

    @Override // w9.l
    public void v2(String str) {
        s3("userpsw", v0.g(str));
    }

    @Override // w9.l
    public void w(boolean z10) {
        p3("login", z10);
    }

    @Override // w9.l
    public String w0() {
        return g3("videoplayer", null);
    }

    @Override // w9.l
    public int w1() {
        return d3("keymenu", 1);
    }

    @Override // w9.l
    public boolean w2() {
        return v().g();
    }

    @Override // w9.l
    public String x() {
        String strG3 = g3("downloaddir", Environment.DIRECTORY_DOWNLOADS);
        String strC3 = c3(strG3);
        if (!strC3.equals(strG3)) {
            s3("downloaddir", strC3);
        }
        return strC3;
    }

    @Override // w9.l
    public int x0() {
        return d3("appui2", -1);
    }

    @Override // w9.l
    public void x1(String str) {
        s3("home", str);
    }

    @Override // w9.l
    public void x2() {
        this.f13373m++;
        this.f13374n = "g" + this.f13373m;
    }

    @Override // w9.l
    public aa.c y() {
        return this.f13364d;
    }

    @Override // w9.l
    public String y0() {
        return v0.a(g3("readercustomcss", null));
    }

    @Override // w9.l
    public String y1() {
        String strG3 = g3("pst", "");
        if (!strG3.isEmpty()) {
            return strG3;
        }
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        s3("pst", strReplace);
        return strReplace;
    }

    @Override // w9.l
    public boolean y2() {
        return v().v();
    }

    @Override // w9.l
    public long z(String str) {
        return e3("updater_" + str, 0L);
    }

    @Override // w9.l
    public void z0(String str) {
        s3("taghome", str == null ? null : v0.b(str.trim()));
    }

    @Override // w9.l
    public void z1(String str) {
        s3("language", str);
        l3(str);
    }

    @Override // w9.l
    public int z2() {
        return d3("fabdownaction", 1);
    }
}
