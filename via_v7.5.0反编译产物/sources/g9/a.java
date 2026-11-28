package g9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5588a;

    public a(int i10) {
        this.f5588a = i10;
    }

    public int a() {
        return this.f5588a;
    }

    public int b() {
        return this.f5588a & 127;
    }

    public boolean c() {
        return ((this.f5588a >> 7) & 1) == 1;
    }

    public boolean d() {
        return ((this.f5588a >> 8) & 1) == 1;
    }

    public void e(boolean z10) {
        if (z10) {
            this.f5588a |= 128;
        } else {
            this.f5588a &= -129;
        }
    }

    public void f(int i10) {
        this.f5588a = i10;
    }

    public void g(boolean z10) {
        if (z10) {
            this.f5588a |= 256;
        } else {
            this.f5588a &= -257;
        }
    }

    public void h(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f5588a = i10 | (this.f5588a & (-128));
    }

    public String toString() {
        return "BackgroundDesignInfo{flag=" + Integer.toHexString(this.f5588a) + '}';
    }
}
