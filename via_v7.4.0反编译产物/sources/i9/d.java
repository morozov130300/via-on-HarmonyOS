package i9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f7104a;

    public d(int i10) {
        this.f7104a = i10;
    }

    public int a() {
        return this.f7104a;
    }

    public int b() {
        return (this.f7104a >> 21) & 63;
    }

    public int c() {
        return (this.f7104a >> 7) & 127;
    }

    public int d() {
        return (this.f7104a >> 14) & 127;
    }

    public int e() {
        return this.f7104a & 127;
    }

    public boolean f() {
        return ((this.f7104a >> 27) & 1) == 1;
    }

    public boolean g() {
        return ((this.f7104a >> 28) & 1) == 1;
    }

    public void h(boolean z10) {
        if (z10) {
            this.f7104a |= 134217728;
        } else {
            this.f7104a &= -134217729;
        }
    }

    public void i(int i10) {
        this.f7104a = i10;
    }

    public void j(int i10) {
        if (i10 > 63) {
            throw new IllegalArgumentException("value can not greater than 0x3f");
        }
        this.f7104a = (i10 << 21) | (this.f7104a & (-132120577));
    }

    public void k(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f7104a = (i10 << 7) | (this.f7104a & (-16257));
    }

    public void l(boolean z10) {
        if (z10) {
            this.f7104a |= 268435456;
        } else {
            this.f7104a &= -268435457;
        }
    }

    public void m(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f7104a = (i10 << 14) | (this.f7104a & (-2080769));
    }

    public void n(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f7104a = i10 | (this.f7104a & (-128));
    }

    public String toString() {
        return "LogoDesignInfo{width=" + e() + ", height=" + c() + ", radius=" + d() + ", fontSize=" + b() + ", isBold=" + f() + ", isItalic=" + g() + ", flag=0x" + Integer.toHexString(this.f7104a) + '}';
    }
}
