package g9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5589a;

    public b(int i10) {
        this.f5589a = i10;
    }

    public int a() {
        return (this.f5589a >> 2) & 127;
    }

    public int b() {
        return this.f5589a;
    }

    public boolean c() {
        return (this.f5589a & 1) == 1;
    }

    public boolean d() {
        return (this.f5589a & 512) != 0;
    }

    public boolean e() {
        return ((this.f5589a >> 1) & 1) == 1;
    }

    public void f(boolean z10) {
        if (z10) {
            this.f5589a |= 1;
        } else {
            this.f5589a &= -2;
        }
    }

    public void g(int i10) {
        this.f5589a = i10;
    }

    public void h(boolean z10) {
        if (z10) {
            this.f5589a |= 512;
        } else {
            this.f5589a &= -513;
        }
    }

    public void i(boolean z10) {
        if (z10) {
            this.f5589a |= 2;
        } else {
            this.f5589a &= -3;
        }
    }

    public String toString() {
        return "LogoDesignInfo{blur=" + c() + ", isSearchPartHidden=" + e() + ", backgroundOpacity=" + a() + ", flag=0x" + Integer.toHexString(this.f5589a) + '}';
    }
}
