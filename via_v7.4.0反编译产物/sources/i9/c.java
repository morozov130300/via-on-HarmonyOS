package i9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f7103a;

    public c(int i10) {
        this.f7103a = i10;
    }

    public int a() {
        return this.f7103a;
    }

    public int b() {
        return (this.f7103a >> 7) & 127;
    }

    public int c() {
        return (this.f7103a >> 14) & 127;
    }

    public int d() {
        return this.f7103a & 127;
    }

    public boolean e() {
        return ((this.f7103a >> 22) & 1) == 1;
    }

    public boolean f() {
        return ((this.f7103a >> 21) & 1) == 1;
    }

    public void g(int i10) {
        this.f7103a = i10;
    }

    public void h(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f7103a = (i10 << 7) | (this.f7103a & (-16257));
    }

    public void i(boolean z10) {
        if (z10) {
            this.f7103a |= 4194304;
        } else {
            this.f7103a &= -4194305;
        }
    }

    public void j(boolean z10) {
        if (z10) {
            this.f7103a |= 2097152;
        } else {
            this.f7103a &= -2097153;
        }
    }

    public void k(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f7103a = (i10 << 14) | (this.f7103a & (-2080769));
    }

    public void l(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f7103a = i10 | (this.f7103a & (-128));
    }

    public String toString() {
        return "FavoritesDesignInfo{width=" + d() + ", height=" + b() + ", radius=" + c() + ", isIconDisabled=" + f() + ", flag=0x" + Integer.toHexString(this.f7103a) + '}';
    }
}
