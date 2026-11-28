package u9;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.GeolocationPermissions;
import c6.r1;
import com.tuyafeng.wormhole.UserAgentPreset;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import la.s;
import org.json.JSONException;
import org.json.JSONObject;
import x8.a0;
import x8.b1;
import x8.c1;
import x8.c4;
import x8.q2;
import x8.s1;
import x8.v0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f12913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f12914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r1 f12915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public x9.c f12916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p f12917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o f12918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public u9.a f12919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f12920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public s5.a f12921i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12922j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f12923k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f12924l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12927o;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12925m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f12926n = "g" + this.f12925m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12928p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12929q = false;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends v9.j {
        public a(int i10) {
            super(i10);
        }

        @Override // v9.g
        public void a() {
            GeolocationPermissions.getInstance().clearAll();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends v9.j {
        public b(int i10) {
            super(i10);
        }

        @Override // v9.g
        public void a() {
            n.e().n(true);
        }
    }

    public k(m mVar, h hVar) {
        this.f12913a = mVar;
        this.f12914b = hVar;
        x3();
        n3();
        p3(g1());
        m3(e3());
        o3(M0());
        q3();
    }

    public static /* synthetic */ int b3(v9.g gVar, v9.g gVar2) {
        return gVar.b() - gVar2.b();
    }

    @Override // u9.l
    public long A(String str) {
        return h3("updater_" + str, 0L);
    }

    @Override // u9.l
    public String A0() {
        return v0.a(j3("readercustomcss", null));
    }

    @Override // u9.l
    public void A1(String str) {
        v3("language", str);
        o3(str);
    }

    @Override // u9.l
    public int A2() {
        return g3("fabdownaction", 1);
    }

    @Override // u9.l
    public boolean B() {
        return d3("login", false);
    }

    @Override // u9.l
    public void B0(String str) {
        v3("taghome", str == null ? null : v0.b(str.trim()));
    }

    @Override // u9.l
    public String B1() {
        String strJ3 = j3("sk", "");
        if (!strJ3.isEmpty()) {
            return strJ3;
        }
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        v3("sk", strReplace);
        return strReplace;
    }

    @Override // u9.l
    public boolean B2() {
        return v().i();
    }

    @Override // u9.l
    public int C() {
        String strP = p();
        String[] strArr = {"about:home", "about:blank", "about:bookmarks", "about:links"};
        for (int i10 = 0; i10 < 4; i10++) {
            if (strP.equals(strArr[i10])) {
                if (i10 == 3) {
                    return 0;
                }
                return i10;
            }
        }
        return 3;
    }

    @Override // u9.l
    public void C0(int i10) {
        t3("restoreclosedtabs", i10);
    }

    @Override // u9.l
    public boolean C1() {
        return V2() && !l3().h();
    }

    @Override // u9.l
    public long C2() {
        return h3("savedata", 0L);
    }

    @Override // u9.l
    public String D() {
        return j3("searchtoolbardisabled", a0.f() ? "-1,-10" : null);
    }

    @Override // u9.l
    public void D0(int i10) {
        t3("keymenu", i10);
    }

    @Override // u9.l
    public long D1() {
        return h3("lastcleantime", System.currentTimeMillis());
    }

    @Override // u9.l
    public void D2(String str) {
        this.f12923k = str;
        this.f12924l = null;
    }

    @Override // u9.l
    public void E(String str, long j10) {
        u3("updater_" + str, j10);
    }

    @Override // u9.l
    public void E0(int i10) {
        t3("urlbox", i10);
    }

    @Override // u9.l
    public int[] E1() {
        String strJ3 = j3("hiddenctxmenus", null);
        if (strJ3 == null) {
            return a0.h() ? new int[]{6, 29} : new int[]{6, 29, 39};
        }
        return strJ3.isEmpty() ? new int[0] : com.tuyafeng.support.utils.p.p(strJ3, ',');
    }

    @Override // u9.l
    public void E2(int i10) {
        t3("disabledvideogestures", i10);
    }

    @Override // u9.l
    public int F() {
        return g3("keyhome", 4);
    }

    @Override // u9.l
    public boolean F0() {
        return v().h();
    }

    @Override // u9.l
    public void F1(p pVar) {
        this.f12917e = pVar;
        t3("webflag", pVar.a());
        this.f12924l = null;
    }

    @Override // u9.l
    public void F2(int i10) {
        t3("duachoice", i10);
        this.f12924l = null;
    }

    @Override // u9.l
    public boolean G() {
        return v().f();
    }

    @Override // u9.l
    public void G0(String str) {
        v3("dlmanager", str);
    }

    @Override // u9.l
    public boolean G1() {
        return v().u();
    }

    @Override // u9.l
    public void G2(g9.c cVar) {
        t3("favinfo", cVar.a());
    }

    @Override // u9.l
    public int H() {
        return g3("adblockedtimes", 0);
    }

    @Override // u9.l
    public int H0() {
        int iG3 = g3("textsize", 100);
        if (iG3 > 5) {
            return iG3;
        }
        int i10 = new int[]{130, 115, 100, 85, 70}[c3(iG3, 5, 1, 3) - 1];
        K(i10);
        return i10;
    }

    @Override // u9.l
    public void H1(String str) {
        v3("bghome", str == null ? null : v0.b(str.trim()));
    }

    @Override // u9.l
    public void H2(int i10) {
        u3("savedata", C2() + ((long) i10));
    }

    @Override // u9.l
    public int I() {
        return g3("changelogcode", 0);
    }

    @Override // u9.l
    public void I0(int i10) {
        t3("keytab", i10);
    }

    @Override // u9.l
    public String I1() {
        return j3("searchtoolbarorder", "");
    }

    @Override // u9.l
    public int[] I2() {
        String strJ3 = j3("hiddenmenus", null);
        return (strJ3 == null || strJ3.isEmpty()) ? new int[0] : com.tuyafeng.support.utils.p.p(strJ3, ',');
    }

    @Override // u9.l
    public void J(int i10) {
        t3("uachoice", i10);
        this.f12924l = null;
    }

    @Override // u9.l
    public void J0(String str) {
        v3("aibackend", str);
    }

    @Override // u9.l
    public void J1(int i10) {
        t3("changelogcode", i10);
    }

    @Override // u9.l
    public void J2(o oVar) {
        this.f12918f = oVar;
        t3("webflag2", oVar.a());
        this.f12924l = null;
    }

    @Override // u9.l
    public void K(int i10) {
        if (i10 <= 5) {
            i10 = new int[]{130, 115, 100, 85, 70}[c3(i10, 5, 1, 3) - 1];
        }
        t3("textsize", i10);
    }

    @Override // u9.l
    public void K0(int i10) {
        t3("cleardata2", i10);
    }

    @Override // u9.l
    public void K1(String str) {
        v3("videoplayer", str);
    }

    @Override // u9.l
    public int K2() {
        return g3("ignoredsslwarning", 0);
    }

    @Override // u9.l
    public String L(String str) {
        return j3("uastring", str);
    }

    @Override // u9.l
    public void L0(int i10) {
        t3("gesturetoolbarright", i10);
    }

    @Override // u9.l
    public String L1() {
        String str = this.f12924l;
        if (str != null) {
            if (str.isEmpty()) {
                return null;
            }
            return this.f12924l;
        }
        String strC = c4.c(o0(), L(Z1()), Z1(), n2().l(), V(), i2(), j1().e());
        this.f12924l = strC;
        if (strC == null) {
            this.f12924l = "";
        }
        if (this.f12924l.isEmpty()) {
            return null;
        }
        return this.f12924l;
    }

    @Override // u9.l
    public void L2(int[] iArr) {
        v3("hiddenmenus", iArr == null ? null : com.tuyafeng.support.utils.p.h(',', iArr));
    }

    @Override // u9.l
    public void M(String str) {
        v3("skin", str);
    }

    @Override // u9.l
    public String M0() {
        return j3("language", null);
    }

    @Override // u9.l
    public int M1() {
        return g3("search2", q2.a());
    }

    @Override // u9.l
    public int M2() {
        return g3("agreement2", 0);
    }

    @Override // u9.l
    public void N(boolean z10) {
        v().M(z10);
        Z(v());
    }

    @Override // u9.l
    public void N0(String str) {
        v3("username", str);
    }

    @Override // u9.l
    public Typeface N1() {
        if (this.f12921i == null) {
            this.f12921i = s5.a.f(s.g().g(c1()));
        }
        return (Typeface) this.f12921i.c();
    }

    @Override // u9.l
    public void N2(int i10) {
        t3("adblockedtimes", H() + i10);
    }

    @Override // u9.l
    public String O() {
        return j3("searchurl", "https://www.google.com/search?q=");
    }

    @Override // u9.l
    public void O0(boolean z10) {
        v().N(z10);
        Z(v());
    }

    @Override // u9.l
    public boolean O1() {
        return v().l();
    }

    @Override // u9.l
    public String O2() {
        return j3("dlmanager", null);
    }

    @Override // u9.l
    public float P() {
        return Math.max(0.25f, Math.min(5.0f, g3("readaloudspeed", 100) / 100.0f));
    }

    @Override // u9.l
    public void P0(g9.e eVar) {
        t3("searchinfo", eVar.b());
    }

    @Override // u9.l
    public void P1(int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < iArr.length; i10++) {
            if (i10 > 0) {
                sb2.append(',');
            }
            sb2.append(iArr[i10]);
        }
        v3("disabledaddons", sb2.toString());
    }

    @Override // u9.l
    public JSONObject P2(boolean z10) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : i.a()) {
            if (this.f12913a.contains(str)) {
                jSONObject.put(str, this.f12913a.getBoolean(str, false));
            }
        }
        for (String str2 : i.d()) {
            if (this.f12913a.contains(str2)) {
                String string = this.f12913a.getString(str2, "");
                if (!z10 || string.length() <= 4096) {
                    jSONObject.put(str2, string);
                }
            }
        }
        for (String str3 : i.b()) {
            if (this.f12913a.contains(str3)) {
                jSONObject.put(str3, this.f12913a.getInt(str3, 0));
            }
        }
        for (String str4 : i.c()) {
            if (this.f12913a.contains(str4)) {
                jSONObject.put(str4, this.f12913a.getLong(str4, 0L));
            }
        }
        return jSONObject;
    }

    @Override // u9.l
    public String Q(Context context) {
        String strY = y();
        return b1.o(strY) ? b1.m(context, Uri.parse(strY)) : c1.q(y());
    }

    @Override // u9.l
    public void Q0(int i10) {
        t3("data_version", i10);
    }

    @Override // u9.l
    public int Q1() {
        return g3("monkey_version", 0);
    }

    @Override // u9.l
    public g9.a Q2() {
        return new g9.a(g3("bginfo", 0));
    }

    @Override // u9.l
    public void R(boolean z10) {
        s3("nightcss", z10);
    }

    @Override // u9.l
    public boolean R0() {
        return l3().g();
    }

    @Override // u9.l
    public void R1(int i10) {
        t3("keyback", i10);
    }

    @Override // u9.l
    public void R2(int i10) {
        t3("cleardataonexit2", i10);
    }

    @Override // u9.l
    public String S() {
        return j3("username", "");
    }

    @Override // u9.l
    public void S0(String str) {
        v3("searchtoolbardisabled", str);
    }

    @Override // u9.l
    public int S1() {
        return g3("logochioce", 0);
    }

    @Override // u9.l
    public void S2(int[] iArr) {
        v3("displayedmenus", iArr == null ? null : com.tuyafeng.support.utils.p.h(',', iArr));
    }

    @Override // u9.l
    public int T() {
        return g3("fab", 80);
    }

    @Override // u9.l
    public void T0(int i10) {
        t3("screenOrientation", i10);
    }

    @Override // u9.l
    public void T1(boolean z10) {
        v().y(z10);
        Z(v());
    }

    @Override // u9.l
    public String T2() {
        return this.f12915c.a();
    }

    @Override // u9.l
    public void U(boolean z10) {
        this.f12929q = z10;
    }

    @Override // u9.l
    public String U0() {
        return this.f12926n;
    }

    @Override // u9.l
    public String U1() {
        return j3("skin", "");
    }

    @Override // u9.l
    public int U2() {
        return g3("bookmarksviewmode", 0);
    }

    @Override // u9.l
    public int V() {
        return g3("duachoice", 0);
    }

    @Override // u9.l
    public void V0(boolean z10, boolean z11) {
        if (z10 == z11) {
            this.f12927o = z11 ? 3 : 2;
        } else {
            this.f12927o = z10 ? 1 : 0;
        }
        t3("nightmode2", this.f12927o);
    }

    @Override // u9.l
    public void V1(int[] iArr) {
        v3("hiddenctxmenus", iArr == null ? null : com.tuyafeng.support.utils.p.h(',', iArr));
    }

    @Override // u9.l
    public boolean V2() {
        return d3("nightcss", l3().h());
    }

    @Override // u9.l
    public int W() {
        return g3("cleardata2", 7);
    }

    @Override // u9.l
    public String W0() {
        return j3("aimodel", null);
    }

    @Override // u9.l
    public String W1() {
        return j3("userpsw", "");
    }

    @Override // u9.l
    public boolean W2(String str) {
        boolean zA = this.f12913a.a("psk", str);
        if (zA) {
            this.f12914b.putString("psk", str);
        }
        return zA;
    }

    @Override // u9.l
    public void X(d dVar) {
        this.f12920h = dVar;
        t3("labflag", dVar.a());
    }

    @Override // u9.l
    public int X0() {
        return g3("bookmarksorder", 0);
    }

    @Override // u9.l
    public int X1() {
        return g3("searchsuggestion", 31);
    }

    @Override // u9.l
    public int X2() {
        return g3("hwshorcut", 0);
    }

    @Override // u9.l
    public int Y() {
        int i10 = this.f12928p;
        if (i10 >= 0) {
            return i10;
        }
        int iF = q2.f(M1(), (x8.f.h() || "zh-CN".equals(s1.g())) ? 2 : 1);
        this.f12928p = iF;
        return iF;
    }

    @Override // u9.l
    public void Y0(g9.d dVar) {
        t3("logoinfo2", dVar.a());
    }

    @Override // u9.l
    public void Y1(int i10) {
        t3("monkey_version", i10);
    }

    @Override // u9.l
    public g9.e Y2() {
        return new g9.e(g3("searchinfo", 2490468));
    }

    @Override // u9.l
    public void Z(u9.a aVar) {
        this.f12919g = aVar;
        t3("appflag", aVar.a());
    }

    @Override // u9.l
    public void Z0(boolean z10) {
        v().A(z10);
        Z(v());
    }

    @Override // u9.l
    public String Z1() {
        return this.f12923k;
    }

    @Override // u9.l
    public void Z2(int i10) {
        t3("readertextsize", i10);
    }

    @Override // u9.l
    public boolean a() {
        return this.f12929q;
    }

    @Override // u9.l
    public g9.b a0() {
        return new g9.b(g3("custominfo", 0));
    }

    @Override // u9.l
    public void a1(int i10) {
        t3("nightfilter", i10);
    }

    @Override // u9.l
    public int a2() {
        return g3("readertextsize", 17);
    }

    @Override // u9.l
    public g9.c a3() {
        return new g9.c(g3("favinfo", 1638446));
    }

    @Override // u9.l
    public void b(int i10) {
        t3("ignoredsslwarning", i10);
    }

    @Override // u9.l
    public void b0() {
        u3("lastcleantime", System.currentTimeMillis());
    }

    @Override // u9.l
    public String b1() {
        return this.f12915c.e(n2().l());
    }

    @Override // u9.l
    public void b2(String str) {
        v3("csstheme", str == null ? null : v0.b(str.trim()));
    }

    @Override // u9.l
    public void c(boolean z10) {
        v().D(z10);
        Z(v());
    }

    @Override // u9.l
    public boolean c0() {
        return V2() && l3().h();
    }

    @Override // u9.l
    public String c1() {
        return j3("uifont", "");
    }

    @Override // u9.l
    public int c2() {
        return g3("readerthemecolor", 0);
    }

    public final int c3(int i10, int i11, int i12, int i13) {
        return (i10 < i12 || i10 > i11) ? i13 : i10;
    }

    @Override // u9.l
    public String d() {
        String strJ3 = j3("bghome", null);
        if (strJ3 == null) {
            return null;
        }
        return v0.a(strJ3);
    }

    @Override // u9.l
    public String d0() {
        String strJ3 = j3("taghome", null);
        if (strJ3 == null) {
            return null;
        }
        return v0.a(strJ3);
    }

    @Override // u9.l
    public void d1() {
        r3(M1());
    }

    @Override // u9.l
    public int d2() {
        return g3("keyforward", 3);
    }

    public final boolean d3(String str, boolean z10) {
        if (this.f12914b.contains(str)) {
            return this.f12914b.getBoolean(str, z10);
        }
        boolean z11 = this.f12913a.getBoolean(str, z10);
        this.f12914b.putBoolean(str, z11);
        return z11;
    }

    @Override // u9.l
    public boolean e() {
        int i10 = this.f12927o;
        return i10 == 1 || i10 == 3;
    }

    @Override // u9.l
    public void e0(int i10) {
        if (i10 >= 0) {
            i10 = -1;
        }
        t3("urlbarcolor", i10);
    }

    @Override // u9.l
    public int e1() {
        return g3("fabrightaction", 13);
    }

    @Override // u9.l
    public void e2(int i10) {
        t3("fabupaction", i10);
    }

    public int e3() {
        int iG3 = g3("cloudtag", -1);
        if (iG3 >= 1 && iG3 <= 10000) {
            return iG3;
        }
        int iNextInt = new Random().nextInt(10000) + 1;
        t3("cloudtag", iNextInt);
        return iNextInt;
    }

    @Override // u9.l
    public void f(String str) {
        v3("aimodel", str);
    }

    @Override // u9.l
    public int f0() {
        int iG3 = g3("urlbarcolor", -1);
        if (iG3 < 0) {
            return iG3;
        }
        e0(-1);
        return -1;
    }

    @Override // u9.l
    public void f1(int i10) {
        t3("hwshorcut", i10);
    }

    @Override // u9.l
    public void f2(String str) {
        v3("searchtoolbarorder", str);
    }

    public final String f3(String str) {
        String str2 = Environment.DIRECTORY_DOWNLOADS;
        if (str != null && !str2.equals(str)) {
            if (str.startsWith("content://")) {
                return str;
            }
            String strN = c1.n(str);
            if (strN != null && !strN.isEmpty()) {
                char cCharAt = strN.charAt(0);
                char c10 = File.separatorChar;
                if (cCharAt == c10) {
                    strN = strN.substring(1);
                }
                if (Build.VERSION.SDK_INT < 21 || strN.startsWith(str2) || strN.length() <= str2.length() || strN.charAt(str2.length()) == c10) {
                    return strN;
                }
                return str2 + c10 + strN;
            }
        }
        return str2;
    }

    @Override // u9.l
    public void g(int i10) {
        t3("searchsuggestion", i10);
    }

    @Override // u9.l
    public String g0() {
        String strJ3 = j3("csstheme", null);
        if (strJ3 == null) {
            return null;
        }
        return v0.a(strJ3);
    }

    @Override // u9.l
    public int g1() {
        return g3("cloudserver", x8.f.h() ? 1 : 0);
    }

    @Override // u9.l
    public void g2(String str) {
        if (str == null) {
            str = "";
        }
        v3("uastring", str.replaceAll("[\t\r\n]", " "));
        this.f12924l = null;
    }

    public final int g3(String str, int i10) {
        if (this.f12914b.contains(str)) {
            return this.f12914b.getInt(str, i10);
        }
        int i11 = this.f12913a.getInt(str, i10);
        this.f12914b.putInt(str, i11);
        return i11;
    }

    @Override // u9.l
    public boolean h() {
        return this.f12922j;
    }

    @Override // u9.l
    public String h0() {
        String strJ3 = j3("iv", "");
        if (!strJ3.isEmpty()) {
            return strJ3;
        }
        String strSubstring = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
        v3("iv", strSubstring);
        return strSubstring;
    }

    @Override // u9.l
    public String h1() {
        return j3("searchshortcuts", "");
    }

    @Override // u9.l
    public int h2() {
        return g3("gesturetoolbarleft", 10);
    }

    public final long h3(String str, long j10) {
        if (this.f12914b.contains(str)) {
            return this.f12914b.getLong(str, j10);
        }
        long j11 = this.f12913a.getLong(str, j10);
        this.f12914b.putLong(str, j11);
        return j11;
    }

    @Override // u9.l
    public void i(int i10) {
        t3("bookmarksviewmode", i10);
    }

    @Override // u9.l
    public void i0(int i10) {
        t3("gesturetoolbarleft", i10);
    }

    @Override // u9.l
    public int i1() {
        return g3("urlbox", 0);
    }

    @Override // u9.l
    public String i2() {
        return j3("duastring", null);
    }

    public int i3() {
        return g3("version", 0);
    }

    @Override // u9.l
    public void j(int i10) {
        t3("syncingchoice", i10);
    }

    @Override // u9.l
    public int j0() {
        return g3("disabledvideogestures", 0);
    }

    @Override // u9.l
    public o j1() {
        o oVar = this.f12918f;
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = new o(g3("webflag2", 0));
        this.f12918f = oVar2;
        return oVar2;
    }

    @Override // u9.l
    public int j2() {
        return g3("fabupaction", 23);
    }

    public final String j3(String str, String str2) {
        if (this.f12914b.contains(str)) {
            return this.f12914b.getString(str, str2);
        }
        String string = this.f12913a.getString(str, str2);
        this.f12914b.putString(str, string);
        return string;
    }

    @Override // u9.l
    public void k(int i10) {
        t3("appui2", i10);
    }

    @Override // u9.l
    public int k0() {
        return g3("keytab", 5);
    }

    @Override // u9.l
    public boolean k1(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        for (String str : i.a()) {
            if (!jSONObject.isNull(str)) {
                s3(str, jSONObject.optBoolean(str));
            }
        }
        for (String str2 : i.d()) {
            if (!jSONObject.isNull(str2)) {
                v3(str2, jSONObject.optString(str2));
            }
        }
        for (String str3 : i.b()) {
            if (!jSONObject.isNull(str3)) {
                t3(str3, jSONObject.optInt(str3));
            }
        }
        for (String str4 : i.c()) {
            if (!jSONObject.isNull(str4)) {
                u3(str4, jSONObject.optLong(str4));
            }
        }
        this.f12914b.a();
        this.f12924l = null;
        this.f12917e = null;
        this.f12919g = null;
        this.f12918f = null;
        d1();
        x3();
        return true;
    }

    @Override // u9.l
    public long k2(String str) {
        return h3("updated_" + str, 0L);
    }

    public int k3() {
        return g3("datachecker2", 0);
    }

    @Override // u9.l
    public void l(int i10) {
        t3("logochioce", i10);
    }

    @Override // u9.l
    public int l0() {
        return g3("screenOrientation", 1);
    }

    @Override // u9.l
    public int l1() {
        return g3("syncingchoice", 0);
    }

    @Override // u9.l
    public void l2(String str) {
        v3("readercustomcss", v0.b(str));
    }

    public final r l3() {
        return s.o();
    }

    @Override // u9.l
    public void m(g9.b bVar) {
        t3("custominfo", bVar.b());
    }

    @Override // u9.l
    public void m0(boolean z10) {
        v().z(z10);
        Z(v());
    }

    @Override // u9.l
    public void m1(String str) {
        v3("searchshortcuts", str);
    }

    @Override // u9.l
    public void m2(int i10) {
        t3("keyhome", i10);
    }

    @Override // u9.l
    public int n() {
        return g3("cleardataonexit2", 0);
    }

    @Override // u9.l
    public int n0() {
        return g3("keyback", 2);
    }

    @Override // u9.l
    public int n1() {
        return g3("gesturetoolbarright", 11);
    }

    @Override // u9.l
    public p n2() {
        p pVar = this.f12917e;
        if (pVar != null) {
            return pVar;
        }
        try {
            p pVar2 = new p(g3("webflag", 96495257));
            this.f12917e = pVar2;
            return pVar2;
        } catch (Exception e10) {
            tc.a.j(e10);
            int iH3 = (int) h3("webflag", 96495257L);
            t3("webflag", iH3);
            p pVar3 = new p(iH3);
            this.f12917e = pVar3;
            return pVar3;
        }
    }

    public final void n3() {
        n.e().d(k3());
        tc.a.a("set flags to updating flags, flags: 0b%s", Integer.toBinaryString(k3()));
    }

    @Override // u9.l
    public void o(int i10) {
        t3("videoorientation", i10);
    }

    @Override // u9.l
    public int o0() {
        return g3("uachoice", UserAgentPreset.DEFAULT.getPresetId());
    }

    @Override // u9.l
    public void o1(int i10) {
        t3("bookmarksorder", i10);
    }

    @Override // u9.l
    public int o2() {
        int iG3 = g3("nightfilter", 77);
        if (iG3 < 0) {
            iG3 = 0;
        }
        if (iG3 > 255) {
            return 255;
        }
        return iG3;
    }

    public final void o3(String str) {
        this.f12922j = (str == null || str.isEmpty()) ? false : true;
    }

    @Override // u9.l
    public String p() {
        return j3("home", "about:home");
    }

    @Override // u9.l
    public boolean p0(boolean z10) {
        int i10 = this.f12927o;
        if (i10 != 0 && i10 != 1) {
            if (z10 != (i10 == 3)) {
                int i11 = z10 ? 3 : 2;
                this.f12927o = i11;
                t3("nightmode2", i11);
                n.e().n(true);
                return true;
            }
        }
        return false;
    }

    @Override // u9.l
    public void p1(String str) {
        v3("searchurl", str);
    }

    @Override // u9.l
    public void p2(int i10) {
        t3("fab", i10);
    }

    public final void p3(int i10) {
        if (i10 == 1) {
            this.f12916d = new x9.a();
        } else {
            this.f12916d = new x9.b();
        }
    }

    @Override // u9.l
    public void q(String str) {
        this.f12921i = null;
        v3("uifont", com.tuyafeng.support.utils.p.m(str));
    }

    @Override // u9.l
    public String q0() {
        return j3("aibackend", null);
    }

    @Override // u9.l
    public void q1(int i10) {
        t3("readerthemecolor", i10);
    }

    @Override // u9.l
    public void q2(boolean z10) {
        v().x(z10);
        Z(v());
    }

    public final void q3() {
        this.f12927o = g3("nightmode2", 2);
    }

    @Override // u9.l
    public void r(String str) {
        v3("downloaddir", f3(str));
    }

    @Override // u9.l
    public int r0() {
        return g3("videoorientation", 0);
    }

    @Override // u9.l
    public int[] r1() {
        String strJ3 = j3("disabledaddons", "");
        int i10 = 0;
        if (strJ3 == null || strJ3.isEmpty()) {
            return new int[0];
        }
        List<String> listO = com.tuyafeng.support.utils.p.o(strJ3, ',');
        int[] iArr = new int[listO.size()];
        for (String str : listO) {
            if (TextUtils.isDigitsOnly(str)) {
                iArr[i10] = Integer.parseInt(str);
                i10++;
            }
        }
        return Arrays.copyOf(iArr, i10);
    }

    @Override // u9.l
    public void r2(int i10) {
        t3("datachecker2", i10);
        tc.a.a("flush updating flags to: 0b%s", Integer.toBinaryString(i10));
    }

    public final void r3(int i10) {
        this.f12915c = q2.c(i10, O());
        this.f12928p = -1;
    }

    @Override // u9.l
    public void s(int i10) {
        r3(i10);
        t3("search2", i10);
    }

    @Override // u9.l
    public void s0(String str, long j10) {
        u3("updated_" + str, j10);
    }

    @Override // u9.l
    public void s1(int i10) {
        t3("agreement2", i10);
    }

    @Override // u9.l
    public int s2() {
        return g3("fullscreenmode", 0);
    }

    public final void s3(String str, boolean z10) {
        this.f12914b.putBoolean(str, z10);
        this.f12913a.putBoolean(str, z10);
    }

    @Override // u9.l
    public d t() {
        if (this.f12920h == null) {
            this.f12920h = new d(g3("labflag", 0));
        }
        return this.f12920h;
    }

    @Override // u9.l
    public g9.d t0() {
        return new g9.d(g3("logoinfo2", 193766400));
    }

    @Override // u9.l
    public int t1() {
        return g3("data_version", 0);
    }

    @Override // u9.l
    public String t2() {
        return j3("psk", null);
    }

    public final void t3(String str, int i10) {
        this.f12914b.putInt(str, i10);
        this.f12913a.putInt(str, i10);
    }

    @Override // u9.l
    public void u(int i10) {
        t3("keyforward", i10);
    }

    @Override // u9.l
    public void u0(int i10) {
        t3("fableftaction", i10);
    }

    @Override // u9.l
    public void u1(int i10) {
        t3("cloudserver", i10);
        p3(i10);
    }

    @Override // u9.l
    public void u2(int i10) {
        t3("fabdownaction", i10);
    }

    public final void u3(String str, long j10) {
        this.f12914b.putLong(str, j10);
        this.f12913a.putLong(str, j10);
    }

    @Override // u9.l
    public u9.a v() {
        if (this.f12919g == null) {
            this.f12919g = new u9.a(g3("appflag", u9.a.f12907b));
        }
        return this.f12919g;
    }

    @Override // u9.l
    public int[] v0() {
        String strJ3 = j3("displayedmenus", null);
        if (strJ3 != null) {
            return strJ3.isEmpty() ? new int[0] : com.tuyafeng.support.utils.p.p(strJ3, ',');
        }
        int[] iArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 25, 34, 33, 39, 30, 28, 23, 29, 31, 35};
        if (a0.f()) {
            iArr[28] = 41;
        }
        return iArr;
    }

    @Override // u9.l
    public int v1() {
        return g3("restoreclosedtabs", 0);
    }

    @Override // u9.l
    public void v2(int i10) {
        t3("fullscreenmode", i10);
    }

    public final void v3(String str, String str2) {
        this.f12914b.putString(str, str2);
        this.f12913a.putString(str, str2);
    }

    @Override // u9.l
    public void w(boolean z10) {
        s3("login", z10);
    }

    @Override // u9.l
    public void w0(float f10) {
        t3("readaloudspeed", (int) (Math.max(0.25f, Math.min(5.0f, f10)) * 100.0f));
    }

    @Override // u9.l
    public void w1(int i10) {
        t3("fabrightaction", i10);
    }

    @Override // u9.l
    public void w2(String str) {
        v3("userpsw", v0.g(str));
    }

    public void w3(int i10) {
        t3("version", i10);
    }

    @Override // u9.l
    public void x(g9.a aVar) {
        t3("bginfo", aVar.a());
    }

    @Override // u9.l
    public int x0() {
        return g3("fableftaction", 12);
    }

    @Override // u9.l
    public int x1() {
        return g3("keymenu", 1);
    }

    @Override // u9.l
    public boolean x2() {
        return v().g();
    }

    public final void x3() {
        int iI3 = i3();
        tc.a.a("check preferences, current version: %d", Integer.valueOf(iI3));
        ArrayList<v9.g> arrayList = new ArrayList();
        arrayList.add(new v9.c(this.f12913a, this));
        arrayList.add(new v9.d(this));
        arrayList.add(new v9.e());
        arrayList.add(new v9.k(this.f12913a, this));
        arrayList.add(new v9.m(this.f12913a, this));
        arrayList.add(new v9.h(this.f12913a, this));
        arrayList.add(new v9.f(this));
        arrayList.add(new v9.a(this.f12913a, this));
        arrayList.add(new v9.l(this));
        arrayList.add(new v9.i(this));
        arrayList.add(new v9.b(this));
        arrayList.add(new a(12));
        arrayList.add(new b(14));
        Collections.sort(arrayList, new Comparator() { // from class: u9.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return k.b3((v9.g) obj, (v9.g) obj2);
            }
        });
        int iB = iI3;
        for (v9.g gVar : arrayList) {
            if (iI3 < gVar.b()) {
                iB = gVar.b();
                if (iI3 != 0) {
                    gVar.a();
                    tc.a.a("update preferences version to %d", Integer.valueOf(iB));
                }
            }
        }
        if (iB > iI3) {
            w3(iB);
        }
    }

    @Override // u9.l
    public String y() {
        String strJ3 = j3("downloaddir", Environment.DIRECTORY_DOWNLOADS);
        String strF3 = f3(strJ3);
        if (!strF3.equals(strJ3)) {
            v3("downloaddir", strF3);
        }
        return strF3;
    }

    @Override // u9.l
    public String y0() {
        return j3("videoplayer", null);
    }

    @Override // u9.l
    public void y1(String str) {
        v3("home", str);
    }

    @Override // u9.l
    public void y2() {
        this.f12925m++;
        this.f12926n = "g" + this.f12925m;
    }

    @Override // u9.l
    public x9.c z() {
        return this.f12916d;
    }

    @Override // u9.l
    public int z0() {
        return g3("appui2", -1);
    }

    @Override // u9.l
    public String z1() {
        String strJ3 = j3("pst", "");
        if (!strJ3.isEmpty()) {
            return strJ3;
        }
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        v3("pst", strReplace);
        return strReplace;
    }

    @Override // u9.l
    public boolean z2() {
        return v().v();
    }

    public final void m3(int i10) {
    }
}
