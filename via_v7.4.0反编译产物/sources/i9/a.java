package i9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f7101a;

    public a(int i10) {
        this.f7101a = i10;
    }

    public int a() {
        return this.f7101a;
    }

    public int b() {
        return this.f7101a & 127;
    }

    public boolean c() {
        return ((this.f7101a >> 7) & 1) == 1;
    }

    public boolean d() {
        return ((this.f7101a >> 8) & 1) == 1;
    }

    public void e(boolean z10) {
        if (z10) {
            this.f7101a |= 128;
        } else {
            this.f7101a &= -129;
        }
    }

    public void f(int i10) {
        this.f7101a = i10;
    }

    public void g(boolean z10) {
        if (z10) {
            this.f7101a |= 256;
        } else {
            this.f7101a &= -257;
        }
    }

    public void h(int i10) {
        if (i10 > 127) {
            throw new IllegalArgumentException("value can not greater than 0x7f");
        }
        this.f7101a = i10 | (this.f7101a & (-128));
    }

    public String toString() {
        return "BackgroundDesignInfo{flag=" + Integer.toHexString(this.f7101a) + '}';
    }
}
