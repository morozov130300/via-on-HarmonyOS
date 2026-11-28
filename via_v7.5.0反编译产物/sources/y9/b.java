package y9;

import x8.c4;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u9.b f15046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u9.b f15047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15048e;

    public b() {
        this(-1000, null, 0, 0);
    }

    public boolean A() {
        return t(32);
    }

    public boolean B(boolean z10) {
        return u(2, z10);
    }

    public boolean C() {
        return t(2);
    }

    public void D() {
        H(16);
    }

    public void E() {
        this.f15044a = -1000;
        this.f15045b = null;
        this.f15048e = 0;
        this.f15046c.d(0);
        this.f15047d.d(0);
    }

    public void F() {
        H(1024);
    }

    public void G() {
        H(8);
    }

    public final void H(int i10) {
        U(i10, false, false);
    }

    public void I() {
        H(131072);
    }

    public void J() {
        H(4);
    }

    public void K() {
        H(32);
    }

    public void L() {
        H(2);
    }

    public void M(boolean z10) {
        U(16, true, z10);
    }

    public void N(int i10) {
        if (i10 == 0) {
            H(24576);
            return;
        }
        if (i10 == 1 || i10 == 2) {
            U(16384, false, false);
            U(8192, true, i10 == 2);
        } else {
            if (i10 != 3) {
                return;
            }
            U(16384, true, true);
            U(8192, false, false);
        }
    }

    public void O(int i10) {
        if (i10 == 0) {
            H(192);
            return;
        }
        if (i10 == 1 || i10 == 2) {
            U(128, false, false);
            U(64, true, i10 == 2);
        } else {
            if (i10 != 3) {
                return;
            }
            U(128, true, true);
            U(64, false, false);
        }
    }

    public void P(boolean z10) {
        U(1024, true, !z10);
    }

    public void Q(String str) {
        if (str == null || str.isEmpty()) {
            this.f15045b = null;
        } else {
            this.f15045b = c4.h(str);
        }
    }

    public void R(boolean z10) {
        U(8, true, z10);
    }

    public void S(boolean z10) {
        U(1, true, z10);
    }

    public void T(int i10) {
        this.f15046c.d(i10);
    }

    public final void U(int i10, boolean z10, boolean z11) {
        this.f15046c.c(i10, z10);
        this.f15047d.c(i10, z11);
    }

    public void V(int i10) {
        this.f15047d.d(i10);
    }

    public void W(boolean z10) {
        U(131072, true, z10);
    }

    public void X(boolean z10) {
        U(4, true, z10);
    }

    public void Y(boolean z10) {
        U(32, true, z10);
    }

    public void Z(boolean z10) {
        U(2, true, z10);
    }

    public int a() {
        if (u(16384, false)) {
            return 3;
        }
        if (u(8192, false)) {
            return 2;
        }
        return !u(8192, true) ? 1 : 0;
    }

    public void a0(int i10) {
        if (i10 == 0) {
            H(98304);
            return;
        }
        if (i10 == 1 || i10 == 2) {
            U(32768, false, false);
            U(65536, true, i10 == 2);
        } else {
            if (i10 != 3) {
                return;
            }
            U(32768, true, true);
            U(65536, false, false);
        }
    }

    public int b() {
        if (u(128, false)) {
            return 3;
        }
        if (u(64, false)) {
            return 2;
        }
        return !u(64, true) ? 1 : 0;
    }

    public void b0(int i10) {
        if (i10 == 0) {
            H(6144);
            return;
        }
        if (i10 == 1 || i10 == 2) {
            U(4096, false, false);
            U(2048, true, i10 == 2);
        } else {
            if (i10 != 3) {
                return;
            }
            U(4096, true, true);
            U(2048, false, false);
        }
    }

    public String c(String str) {
        String str2 = this.f15045b;
        return (str2 == null || str2.isEmpty()) ? str : this.f15045b;
    }

    public void c0(int i10) {
        if (i10 == 0) {
            H(768);
            return;
        }
        if (i10 == 1 || i10 == 2) {
            U(512, false, false);
            U(256, true, i10 == 2);
        } else {
            if (i10 != 3) {
                return;
            }
            U(512, true, true);
            U(256, false, false);
        }
    }

    public int d() {
        return this.f15046c.a();
    }

    public void d0(int i10) {
        this.f15048e = i10;
    }

    public int e() {
        return this.f15047d.a();
    }

    public void e0(int i10) {
        this.f15044a = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f15044a == bVar.f15044a && t1.a(this.f15045b, bVar.f15045b) && this.f15046c.equals(bVar.f15046c) && this.f15047d.equals(bVar.f15047d) && this.f15048e == bVar.f15048e) {
                return true;
            }
        }
        return false;
    }

    public int f() {
        if (u(32768, false)) {
            return 3;
        }
        if (u(65536, false)) {
            return 2;
        }
        return !u(65536, true) ? 1 : 0;
    }

    public int g() {
        if (u(4096, false)) {
            return 3;
        }
        if (u(2048, false)) {
            return 2;
        }
        return !u(2048, true) ? 1 : 0;
    }

    public int h() {
        if (u(512, false)) {
            return 3;
        }
        if (u(256, false)) {
            return 2;
        }
        return !u(256, true) ? 1 : 0;
    }

    public int hashCode() {
        return t1.b(Integer.valueOf(this.f15044a), this.f15045b, this.f15046c, this.f15047d);
    }

    public int i(int i10) {
        int i11 = this.f15048e;
        return i11 <= 0 ? i10 : i11;
    }

    public int j() {
        return this.f15044a;
    }

    public boolean k() {
        if (this.f15044a != -1000) {
            return true;
        }
        String str = this.f15045b;
        return !(str == null || str.isEmpty()) || q();
    }

    public boolean l(boolean z10) {
        return u(16, z10);
    }

    public boolean m() {
        return t(16);
    }

    public boolean n(boolean z10) {
        return !u(1024, !z10);
    }

    public boolean o() {
        return t(1024);
    }

    public boolean p(boolean z10) {
        return u(8, z10);
    }

    public boolean q() {
        return t(8);
    }

    public boolean r() {
        String str = this.f15045b;
        return (str == null || str.isEmpty()) && this.f15044a == -1000 && (this.f15046c.a() >> 1) == 0 && (this.f15047d.a() >> 1) == 0 && this.f15048e == 0;
    }

    public boolean s() {
        return u(1, false);
    }

    public final boolean t(int i10) {
        return this.f15046c.b(i10);
    }

    public String toString() {
        return "SiteConf{userAgentChoice=" + this.f15044a + ", customUserAgent='" + this.f15045b + "', enabledFlags=" + Integer.toHexString(this.f15046c.a()) + ", flags=" + Integer.toHexString(this.f15047d.a()) + '}';
    }

    public final boolean u(int i10, boolean z10) {
        return this.f15046c.b(i10) ? this.f15047d.b(i10) : z10;
    }

    public boolean v(boolean z10) {
        return u(131072, z10);
    }

    public boolean w() {
        return t(131072);
    }

    public boolean x(boolean z10) {
        return u(4, z10);
    }

    public boolean y() {
        return t(4);
    }

    public boolean z(boolean z10) {
        return u(32, z10);
    }

    public b(int i10, String str, int i11, int i12) {
        this.f15044a = i10;
        this.f15045b = str;
        this.f15046c = new u9.b(i11);
        this.f15047d = new u9.b(i12);
    }
}
