package g2;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e6 {
    public long A;
    public long B;
    public long C;
    public long D;
    public String E;
    public boolean F;
    public long G;
    public long H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h5 f4737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f4745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f4746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f4747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f4748l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f4749m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f4750n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4751o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4752p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f4753q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Boolean f4754r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f4755s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List f4756t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f4757u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f4758v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f4759w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f4760x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f4761y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f4762z;

    public e6(h5 h5Var, String str) {
        u1.f.h(h5Var);
        u1.f.d(str);
        this.f4737a = h5Var;
        this.f4738b = str;
        h5Var.f().h();
    }

    public final long A() {
        this.f4737a.f().h();
        return 0L;
    }

    public final void B(String str) {
        this.f4737a.f().h();
        this.F |= !d5.a(this.E, str);
        this.E = str;
    }

    public final void C(long j10) {
        this.f4737a.f().h();
        this.F |= this.f4745i != j10;
        this.f4745i = j10;
    }

    public final void D(long j10) {
        u1.f.a(j10 >= 0);
        this.f4737a.f().h();
        this.F |= this.f4743g != j10;
        this.f4743g = j10;
    }

    public final void E(long j10) {
        this.f4737a.f().h();
        this.F |= this.f4744h != j10;
        this.f4744h = j10;
    }

    public final void F(boolean z10) {
        this.f4737a.f().h();
        this.F |= this.f4751o != z10;
        this.f4751o = z10;
    }

    public final void G(Boolean bool) {
        this.f4737a.f().h();
        this.F |= !d5.a(this.f4754r, bool);
        this.f4754r = bool;
    }

    public final void H(String str) {
        this.f4737a.f().h();
        this.F |= !d5.a(this.f4741e, str);
        this.f4741e = str;
    }

    public final void I(List list) {
        this.f4737a.f().h();
        if (d5.a(this.f4756t, list)) {
            return;
        }
        this.F = true;
        this.f4756t = list != null ? new ArrayList(list) : null;
    }

    public final void J(String str) {
        this.f4737a.f().h();
        this.F |= !d5.a(this.f4757u, str);
        this.f4757u = str;
    }

    public final void K(long j10) {
        this.f4737a.f().h();
        this.F |= this.f4760x != j10;
        this.f4760x = j10;
    }

    public final void L(boolean z10) {
        this.f4737a.f().h();
        this.F |= this.f4758v != z10;
        this.f4758v = z10;
    }

    public final void M(long j10) {
        this.f4737a.f().h();
        this.F |= this.f4759w != j10;
        this.f4759w = j10;
    }

    public final boolean N() {
        this.f4737a.f().h();
        return this.f4752p;
    }

    public final boolean O() {
        this.f4737a.f().h();
        return this.f4751o;
    }

    public final boolean P() {
        this.f4737a.f().h();
        return this.F;
    }

    public final boolean Q() {
        this.f4737a.f().h();
        return this.f4758v;
    }

    public final long R() {
        this.f4737a.f().h();
        return this.f4747k;
    }

    public final long S() {
        this.f4737a.f().h();
        return this.G;
    }

    public final long T() {
        this.f4737a.f().h();
        return this.B;
    }

    public final long U() {
        this.f4737a.f().h();
        return this.C;
    }

    public final long V() {
        this.f4737a.f().h();
        return this.A;
    }

    public final long W() {
        this.f4737a.f().h();
        return this.f4762z;
    }

    public final long X() {
        this.f4737a.f().h();
        return this.D;
    }

    public final long Y() {
        this.f4737a.f().h();
        return this.f4761y;
    }

    public final long Z() {
        this.f4737a.f().h();
        return this.f4750n;
    }

    public final String a() {
        this.f4737a.f().h();
        return this.f4740d;
    }

    public final long a0() {
        this.f4737a.f().h();
        return this.f4755s;
    }

    public final String b() {
        this.f4737a.f().h();
        return this.E;
    }

    public final long b0() {
        this.f4737a.f().h();
        return this.H;
    }

    public final String c() {
        this.f4737a.f().h();
        return this.f4741e;
    }

    public final long c0() {
        this.f4737a.f().h();
        return this.f4749m;
    }

    public final String d() {
        this.f4737a.f().h();
        return this.f4757u;
    }

    public final long d0() {
        this.f4737a.f().h();
        return this.f4745i;
    }

    public final List e() {
        this.f4737a.f().h();
        return this.f4756t;
    }

    public final long e0() {
        this.f4737a.f().h();
        return this.f4743g;
    }

    public final void f() {
        this.f4737a.f().h();
        this.F = false;
    }

    public final long f0() {
        this.f4737a.f().h();
        return this.f4744h;
    }

    public final void g() {
        this.f4737a.f().h();
        long j10 = this.f4743g + 1;
        if (j10 > 2147483647L) {
            this.f4737a.d().w().b("Bundle index overflow. appId", v3.z(this.f4738b));
            j10 = 0;
        }
        this.F = true;
        this.f4743g = j10;
    }

    public final long g0() {
        this.f4737a.f().h();
        return this.f4760x;
    }

    public final void h(String str) {
        this.f4737a.f().h();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.F |= true ^ d5.a(this.f4753q, str);
        this.f4753q = str;
    }

    public final long h0() {
        this.f4737a.f().h();
        return this.f4759w;
    }

    public final void i(boolean z10) {
        this.f4737a.f().h();
        this.F |= this.f4752p != z10;
        this.f4752p = z10;
    }

    public final Boolean i0() {
        this.f4737a.f().h();
        return this.f4754r;
    }

    public final void j(String str) {
        this.f4737a.f().h();
        this.F |= !d5.a(this.f4739c, str);
        this.f4739c = str;
    }

    public final String j0() {
        this.f4737a.f().h();
        return this.f4753q;
    }

    public final void k(String str) {
        this.f4737a.f().h();
        this.F |= !d5.a(this.f4748l, str);
        this.f4748l = str;
    }

    public final String k0() {
        this.f4737a.f().h();
        String str = this.E;
        B(null);
        return str;
    }

    public final void l(String str) {
        this.f4737a.f().h();
        this.F |= !d5.a(this.f4746j, str);
        this.f4746j = str;
    }

    public final String l0() {
        this.f4737a.f().h();
        return this.f4738b;
    }

    public final void m(long j10) {
        this.f4737a.f().h();
        this.F |= this.f4747k != j10;
        this.f4747k = j10;
    }

    public final String m0() {
        this.f4737a.f().h();
        return this.f4739c;
    }

    public final void n(long j10) {
        this.f4737a.f().h();
        this.F |= this.G != j10;
        this.G = j10;
    }

    public final String n0() {
        this.f4737a.f().h();
        return this.f4748l;
    }

    public final void o(long j10) {
        this.f4737a.f().h();
        this.F |= this.B != j10;
        this.B = j10;
    }

    public final String o0() {
        this.f4737a.f().h();
        return this.f4746j;
    }

    public final void p(long j10) {
        this.f4737a.f().h();
        this.F |= this.C != j10;
        this.C = j10;
    }

    public final String p0() {
        this.f4737a.f().h();
        return this.f4742f;
    }

    public final void q(long j10) {
        this.f4737a.f().h();
        this.F |= this.A != j10;
        this.A = j10;
    }

    public final void r(long j10) {
        this.f4737a.f().h();
        this.F |= this.f4762z != j10;
        this.f4762z = j10;
    }

    public final void s(long j10) {
        this.f4737a.f().h();
        this.F |= this.D != j10;
        this.D = j10;
    }

    public final void t(long j10) {
        this.f4737a.f().h();
        this.F |= this.f4761y != j10;
        this.f4761y = j10;
    }

    public final void u(long j10) {
        this.f4737a.f().h();
        this.F |= this.f4750n != j10;
        this.f4750n = j10;
    }

    public final void v(long j10) {
        this.f4737a.f().h();
        this.F |= this.f4755s != j10;
        this.f4755s = j10;
    }

    public final void w(long j10) {
        this.f4737a.f().h();
        this.F |= this.H != j10;
        this.H = j10;
    }

    public final void x(String str) {
        this.f4737a.f().h();
        this.F |= !d5.a(this.f4742f, str);
        this.f4742f = str;
    }

    public final void y(String str) {
        this.f4737a.f().h();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.F |= true ^ d5.a(this.f4740d, str);
        this.f4740d = str;
    }

    public final void z(long j10) {
        this.f4737a.f().h();
        this.F |= this.f4749m != j10;
        this.f4749m = j10;
    }
}
