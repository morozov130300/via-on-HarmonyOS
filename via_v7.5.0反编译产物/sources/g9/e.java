package g9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5592a;

    public e(int i10) {
        this.f5592a = i10;
    }

    public int a() {
        return (this.f5592a >> 7) & 127;
    }

    public int b() {
        return this.f5592a;
    }

    public int c() {
        return this.f5592a & 127;
    }

    public int d() {
        return (this.f5592a >> 14) & 127;
    }

    public int e() {
        return (this.f5592a >> 21) & 7;
    }

    public void f(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f5592a = (i10 << 7) | (this.f5592a & (-16257));
    }

    public void g(int i10) {
        this.f5592a = i10;
    }

    public void h(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f5592a = i10 | (this.f5592a & (-128));
    }

    public void i(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f5592a = (i10 << 14) | (this.f5592a & (-2080769));
    }

    public void j(int i10) {
        if (i10 > 7) {
            throw new IllegalArgumentException("value can not greater than 0x7");
        }
        this.f5592a = (i10 << 21) | (this.f5592a & (-14680065));
    }

    public void k(boolean z10) {
        if (z10) {
            this.f5592a |= 16777216;
        } else {
            this.f5592a &= -16777217;
        }
    }

    public boolean l() {
        return ((this.f5592a >> 24) & 1) == 1;
    }

    public String toString() {
        return "LogoDesignInfo{opacity=" + a() + ", radius=" + c() + ", strokeOpacity=" + d() + ", strokeWidth=" + e() + ", usingLine=" + l() + ", flag=0x" + Integer.toHexString(this.f5592a) + '}';
    }
}
