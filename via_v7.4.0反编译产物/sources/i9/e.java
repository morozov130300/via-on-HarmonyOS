package i9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f7105a;

    public e(int i10) {
        this.f7105a = i10;
    }

    public int a() {
        return (this.f7105a >> 7) & 127;
    }

    public int b() {
        return this.f7105a;
    }

    public int c() {
        return this.f7105a & 127;
    }

    public int d() {
        return (this.f7105a >> 14) & 127;
    }

    public int e() {
        return (this.f7105a >> 21) & 7;
    }

    public void f(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f7105a = (i10 << 7) | (this.f7105a & (-16257));
    }

    public void g(int i10) {
        this.f7105a = i10;
    }

    public void h(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f7105a = i10 | (this.f7105a & (-128));
    }

    public void i(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f7105a = (i10 << 14) | (this.f7105a & (-2080769));
    }

    public void j(int i10) {
        if (i10 > 7) {
            throw new IllegalArgumentException("value can not greater than 0x7");
        }
        this.f7105a = (i10 << 21) | (this.f7105a & (-14680065));
    }

    public void k(boolean z10) {
        if (z10) {
            this.f7105a |= 16777216;
        } else {
            this.f7105a &= -16777217;
        }
    }

    public boolean l() {
        return ((this.f7105a >> 24) & 1) == 1;
    }

    public String toString() {
        return "LogoDesignInfo{opacity=" + a() + ", radius=" + c() + ", strokeOpacity=" + d() + ", strokeWidth=" + e() + ", usingLine=" + l() + ", flag=0x" + Integer.toHexString(this.f7105a) + '}';
    }
}
