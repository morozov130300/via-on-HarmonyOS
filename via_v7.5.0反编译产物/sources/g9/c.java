package g9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5590a;

    public c(int i10) {
        this.f5590a = i10;
    }

    public int a() {
        return this.f5590a;
    }

    public int b() {
        return (this.f5590a >> 7) & 127;
    }

    public int c() {
        return (this.f5590a >> 14) & 127;
    }

    public int d() {
        return this.f5590a & 127;
    }

    public boolean e() {
        return ((this.f5590a >> 22) & 1) == 1;
    }

    public boolean f() {
        return ((this.f5590a >> 21) & 1) == 1;
    }

    public void g(int i10) {
        this.f5590a = i10;
    }

    public void h(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f5590a = (i10 << 7) | (this.f5590a & (-16257));
    }

    public void i(boolean z10) {
        if (z10) {
            this.f5590a |= 4194304;
        } else {
            this.f5590a &= -4194305;
        }
    }

    public void j(boolean z10) {
        if (z10) {
            this.f5590a |= 2097152;
        } else {
            this.f5590a &= -2097153;
        }
    }

    public void k(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f5590a = (i10 << 14) | (this.f5590a & (-2080769));
    }

    public void l(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f5590a = i10 | (this.f5590a & (-128));
    }

    public String toString() {
        return "FavoritesDesignInfo{width=" + d() + ", height=" + b() + ", radius=" + c() + ", isIconDisabled=" + f() + ", flag=0x" + Integer.toHexString(this.f5590a) + '}';
    }
}
