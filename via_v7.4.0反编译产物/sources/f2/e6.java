package f2;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e6 {
    public long A;
    public long B;
    public long C;
    public long D;
    public String E;
    public boolean F;
    public long G;
    public long H;

    /* renamed from: a, reason: collision with root package name */
    public final h5 f5121a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5122b;

    /* renamed from: c, reason: collision with root package name */
    public String f5123c;

    /* renamed from: d, reason: collision with root package name */
    public String f5124d;

    /* renamed from: e, reason: collision with root package name */
    public String f5125e;

    /* renamed from: f, reason: collision with root package name */
    public String f5126f;

    /* renamed from: g, reason: collision with root package name */
    public long f5127g;

    /* renamed from: h, reason: collision with root package name */
    public long f5128h;

    /* renamed from: i, reason: collision with root package name */
    public long f5129i;

    /* renamed from: j, reason: collision with root package name */
    public String f5130j;

    /* renamed from: k, reason: collision with root package name */
    public long f5131k;

    /* renamed from: l, reason: collision with root package name */
    public String f5132l;

    /* renamed from: m, reason: collision with root package name */
    public long f5133m;

    /* renamed from: n, reason: collision with root package name */
    public long f5134n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5135o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f5136p;

    /* renamed from: q, reason: collision with root package name */
    public String f5137q;

    /* renamed from: r, reason: collision with root package name */
    public Boolean f5138r;

    /* renamed from: s, reason: collision with root package name */
    public long f5139s;

    /* renamed from: t, reason: collision with root package name */
    public List f5140t;

    /* renamed from: u, reason: collision with root package name */
    public String f5141u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f5142v;

    /* renamed from: w, reason: collision with root package name */
    public long f5143w;

    /* renamed from: x, reason: collision with root package name */
    public long f5144x;

    /* renamed from: y, reason: collision with root package name */
    public long f5145y;

    /* renamed from: z, reason: collision with root package name */
    public long f5146z;

    public e6(h5 h5Var, String str) {
        t1.f.h(h5Var);
        t1.f.d(str);
        this.f5121a = h5Var;
        this.f5122b = str;
        h5Var.f().h();
    }

    public final long A() {
        this.f5121a.f().h();
        return 0L;
    }

    public final void B(String str) {
        this.f5121a.f().h();
        this.F |= !d5.a(this.E, str);
        this.E = str;
    }

    public final void C(long j10) {
        this.f5121a.f().h();
        this.F |= this.f5129i != j10;
        this.f5129i = j10;
    }

    public final void D(long j10) {
        t1.f.a(j10 >= 0);
        this.f5121a.f().h();
        this.F |= this.f5127g != j10;
        this.f5127g = j10;
    }

    public final void E(long j10) {
        this.f5121a.f().h();
        this.F |= this.f5128h != j10;
        this.f5128h = j10;
    }

    public final void F(boolean z10) {
        this.f5121a.f().h();
        this.F |= this.f5135o != z10;
        this.f5135o = z10;
    }

    public final void G(Boolean bool) {
        this.f5121a.f().h();
        this.F |= !d5.a(this.f5138r, bool);
        this.f5138r = bool;
    }

    public final void H(String str) {
        this.f5121a.f().h();
        this.F |= !d5.a(this.f5125e, str);
        this.f5125e = str;
    }

    public final void I(List list) {
        this.f5121a.f().h();
        if (d5.a(this.f5140t, list)) {
            return;
        }
        this.F = true;
        this.f5140t = list != null ? new ArrayList(list) : null;
    }

    public final void J(String str) {
        this.f5121a.f().h();
        this.F |= !d5.a(this.f5141u, str);
        this.f5141u = str;
    }

    public final void K(long j10) {
        this.f5121a.f().h();
        this.F |= this.f5144x != j10;
        this.f5144x = j10;
    }

    public final void L(boolean z10) {
        this.f5121a.f().h();
        this.F |= this.f5142v != z10;
        this.f5142v = z10;
    }

    public final void M(long j10) {
        this.f5121a.f().h();
        this.F |= this.f5143w != j10;
        this.f5143w = j10;
    }

    public final boolean N() {
        this.f5121a.f().h();
        return this.f5136p;
    }

    public final boolean O() {
        this.f5121a.f().h();
        return this.f5135o;
    }

    public final boolean P() {
        this.f5121a.f().h();
        return this.F;
    }

    public final boolean Q() {
        this.f5121a.f().h();
        return this.f5142v;
    }

    public final long R() {
        this.f5121a.f().h();
        return this.f5131k;
    }

    public final long S() {
        this.f5121a.f().h();
        return this.G;
    }

    public final long T() {
        this.f5121a.f().h();
        return this.B;
    }

    public final long U() {
        this.f5121a.f().h();
        return this.C;
    }

    public final long V() {
        this.f5121a.f().h();
        return this.A;
    }

    public final long W() {
        this.f5121a.f().h();
        return this.f5146z;
    }

    public final long X() {
        this.f5121a.f().h();
        return this.D;
    }

    public final long Y() {
        this.f5121a.f().h();
        return this.f5145y;
    }

    public final long Z() {
        this.f5121a.f().h();
        return this.f5134n;
    }

    public final String a() {
        this.f5121a.f().h();
        return this.f5124d;
    }

    public final long a0() {
        this.f5121a.f().h();
        return this.f5139s;
    }

    public final String b() {
        this.f5121a.f().h();
        return this.E;
    }

    public final long b0() {
        this.f5121a.f().h();
        return this.H;
    }

    public final String c() {
        this.f5121a.f().h();
        return this.f5125e;
    }

    public final long c0() {
        this.f5121a.f().h();
        return this.f5133m;
    }

    public final String d() {
        this.f5121a.f().h();
        return this.f5141u;
    }

    public final long d0() {
        this.f5121a.f().h();
        return this.f5129i;
    }

    public final List e() {
        this.f5121a.f().h();
        return this.f5140t;
    }

    public final long e0() {
        this.f5121a.f().h();
        return this.f5127g;
    }

    public final void f() {
        this.f5121a.f().h();
        this.F = false;
    }

    public final long f0() {
        this.f5121a.f().h();
        return this.f5128h;
    }

    public final void g() {
        this.f5121a.f().h();
        long j10 = this.f5127g + 1;
        if (j10 > 2147483647L) {
            this.f5121a.d().w().b("Bundle index overflow. appId", v3.z(this.f5122b));
            j10 = 0;
        }
        this.F = true;
        this.f5127g = j10;
    }

    public final long g0() {
        this.f5121a.f().h();
        return this.f5144x;
    }

    public final void h(String str) {
        this.f5121a.f().h();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.F |= true ^ d5.a(this.f5137q, str);
        this.f5137q = str;
    }

    public final long h0() {
        this.f5121a.f().h();
        return this.f5143w;
    }

    public final void i(boolean z10) {
        this.f5121a.f().h();
        this.F |= this.f5136p != z10;
        this.f5136p = z10;
    }

    public final Boolean i0() {
        this.f5121a.f().h();
        return this.f5138r;
    }

    public final void j(String str) {
        this.f5121a.f().h();
        this.F |= !d5.a(this.f5123c, str);
        this.f5123c = str;
    }

    public final String j0() {
        this.f5121a.f().h();
        return this.f5137q;
    }

    public final void k(String str) {
        this.f5121a.f().h();
        this.F |= !d5.a(this.f5132l, str);
        this.f5132l = str;
    }

    public final String k0() {
        this.f5121a.f().h();
        String str = this.E;
        B(null);
        return str;
    }

    public final void l(String str) {
        this.f5121a.f().h();
        this.F |= !d5.a(this.f5130j, str);
        this.f5130j = str;
    }

    public final String l0() {
        this.f5121a.f().h();
        return this.f5122b;
    }

    public final void m(long j10) {
        this.f5121a.f().h();
        this.F |= this.f5131k != j10;
        this.f5131k = j10;
    }

    public final String m0() {
        this.f5121a.f().h();
        return this.f5123c;
    }

    public final void n(long j10) {
        this.f5121a.f().h();
        this.F |= this.G != j10;
        this.G = j10;
    }

    public final String n0() {
        this.f5121a.f().h();
        return this.f5132l;
    }

    public final void o(long j10) {
        this.f5121a.f().h();
        this.F |= this.B != j10;
        this.B = j10;
    }

    public final String o0() {
        this.f5121a.f().h();
        return this.f5130j;
    }

    public final void p(long j10) {
        this.f5121a.f().h();
        this.F |= this.C != j10;
        this.C = j10;
    }

    public final String p0() {
        this.f5121a.f().h();
        return this.f5126f;
    }

    public final void q(long j10) {
        this.f5121a.f().h();
        this.F |= this.A != j10;
        this.A = j10;
    }

    public final void r(long j10) {
        this.f5121a.f().h();
        this.F |= this.f5146z != j10;
        this.f5146z = j10;
    }

    public final void s(long j10) {
        this.f5121a.f().h();
        this.F |= this.D != j10;
        this.D = j10;
    }

    public final void t(long j10) {
        this.f5121a.f().h();
        this.F |= this.f5145y != j10;
        this.f5145y = j10;
    }

    public final void u(long j10) {
        this.f5121a.f().h();
        this.F |= this.f5134n != j10;
        this.f5134n = j10;
    }

    public final void v(long j10) {
        this.f5121a.f().h();
        this.F |= this.f5139s != j10;
        this.f5139s = j10;
    }

    public final void w(long j10) {
        this.f5121a.f().h();
        this.F |= this.H != j10;
        this.H = j10;
    }

    public final void x(String str) {
        this.f5121a.f().h();
        this.F |= !d5.a(this.f5126f, str);
        this.f5126f = str;
    }

    public final void y(String str) {
        this.f5121a.f().h();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.F |= true ^ d5.a(this.f5124d, str);
        this.f5124d = str;
    }

    public final void z(long j10) {
        this.f5121a.f().h();
        this.F |= this.f5133m != j10;
        this.f5133m = j10;
    }
}
