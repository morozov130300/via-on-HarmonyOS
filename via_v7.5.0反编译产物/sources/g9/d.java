package g9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5591a;

    public d(int i10) {
        this.f5591a = i10;
    }

    public int a() {
        return this.f5591a;
    }

    public int b() {
        return (this.f5591a >> 21) & 63;
    }

    public int c() {
        return (this.f5591a >> 7) & 127;
    }

    public int d() {
        return (this.f5591a >> 14) & 127;
    }

    public int e() {
        return this.f5591a & 127;
    }

    public boolean f() {
        return ((this.f5591a >> 27) & 1) == 1;
    }

    public boolean g() {
        return ((this.f5591a >> 28) & 1) == 1;
    }

    public void h(boolean z10) {
        if (z10) {
            this.f5591a |= 134217728;
        } else {
            this.f5591a &= -134217729;
        }
    }

    public void i(int i10) {
        this.f5591a = i10;
    }

    public void j(int i10) {
        if (i10 > 63) {
            throw new IllegalArgumentException("value can not greater than 0x3f");
        }
        this.f5591a = (i10 << 21) | (this.f5591a & (-132120577));
    }

    public void k(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f5591a = (i10 << 7) | (this.f5591a & (-16257));
    }

    public void l(boolean z10) {
        if (z10) {
            this.f5591a |= 268435456;
        } else {
            this.f5591a &= -268435457;
        }
    }

    public void m(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f5591a = (i10 << 14) | (this.f5591a & (-2080769));
    }

    public void n(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f5591a = i10 | (this.f5591a & (-128));
    }

    public String toString() {
        return "LogoDesignInfo{width=" + e() + ", height=" + c() + ", radius=" + d() + ", fontSize=" + b() + ", isBold=" + f() + ", isItalic=" + g() + ", flag=0x" + Integer.toHexString(this.f5591a) + '}';
    }
}
