package u9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class p extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12933b;

    public p(int i10) {
        super(i10);
    }

    public boolean A() {
        return b(65536);
    }

    public boolean B() {
        return b(16384);
    }

    public boolean C() {
        return !b(268435456);
    }

    public boolean D() {
        return b(1073741824);
    }

    public boolean E() {
        return b(536870912);
    }

    public boolean F() {
        return b(4096);
    }

    public boolean G() {
        if (r() && x()) {
            return true;
        }
        return !r() && q();
    }

    public void H(boolean z10) {
        c(1, z10);
    }

    public void I(boolean z10) {
        c(32768, z10);
    }

    public void J(boolean z10) {
        c(8388608, z10);
    }

    public void K(int i10) {
        if (i10 == 0 || i10 == 1 || i10 == 2) {
            c(131072, i10 == 2);
            c(262144, false);
        } else {
            if (i10 != 3) {
                return;
            }
            c(131072, false);
            c(262144, true);
        }
    }

    public void L(boolean z10) {
        c(8192, z10);
    }

    public void M(boolean z10) {
        c(134217728, !z10);
    }

    public void N(boolean z10) {
        c(2048, z10);
    }

    public void O(boolean z10) {
        c(128, z10);
    }

    public void P(boolean z10) {
        c(524288, z10);
    }

    public void Q(boolean z10) {
        c(1024, z10);
    }

    public void R(boolean z10) {
        c(512, z10);
    }

    public void S(boolean z10) {
        c(16, z10);
    }

    public void T(boolean z10) {
        c(32, z10);
    }

    public void U(boolean z10) {
        c(64, z10);
    }

    public void V(boolean z10) {
        c(8, z10);
    }

    public void W(boolean z10) {
        c(2, z10);
    }

    public void X(boolean z10) {
        c(16777216, z10);
    }

    public void Y(boolean z10) {
        c(4194304, z10);
    }

    public void Z(boolean z10) {
        this.f12933b = z10;
    }

    public void a0(int i10) {
        if (i10 == 0 || i10 == 1 || i10 == 2) {
            c(33554432, i10 == 2);
            c(67108864, false);
        } else {
            if (i10 != 3) {
                return;
            }
            c(33554432, false);
            c(67108864, true);
        }
    }

    public void b0(boolean z10) {
        c(1048576, z10);
    }

    public void c0(boolean z10) {
        c(2097152, z10);
    }

    public void d0(boolean z10) {
        c(256, z10);
    }

    public int e() {
        if (b(262144)) {
            return 3;
        }
        return b(131072) ? 2 : 1;
    }

    public void e0(boolean z10) {
        c(65536, z10);
    }

    public int f() {
        if (b(67108864)) {
            return 3;
        }
        return b(33554432) ? 2 : 1;
    }

    public void f0(boolean z10) {
        c(16384, z10);
    }

    public boolean g() {
        return b(1);
    }

    public void g0(boolean z10) {
        c(268435456, !z10);
    }

    public boolean h() {
        return b(32768);
    }

    public void h0(boolean z10) {
        c(1073741824, z10);
    }

    public boolean i() {
        return b(8388608);
    }

    public void i0(boolean z10) {
        c(536870912, z10);
    }

    public boolean j() {
        return b(8192);
    }

    public void j0(boolean z10) {
        c(4096, z10);
    }

    public boolean k() {
        return !b(134217728);
    }

    public boolean l() {
        return b(2048);
    }

    public boolean m() {
        return b(128);
    }

    public boolean n() {
        return b(524288);
    }

    public boolean o() {
        return b(1024);
    }

    public boolean p() {
        return b(512);
    }

    public boolean q() {
        return b(16);
    }

    public boolean r() {
        return b(32);
    }

    public boolean s() {
        return b(64);
    }

    public boolean t() {
        return b(8);
    }

    public boolean u() {
        return b(2);
    }

    public boolean v() {
        return b(16777216);
    }

    public boolean w() {
        return b(4194304);
    }

    public boolean x() {
        return this.f12933b;
    }

    public boolean y() {
        return b(2097152);
    }

    public boolean z() {
        return b(256);
    }
}
