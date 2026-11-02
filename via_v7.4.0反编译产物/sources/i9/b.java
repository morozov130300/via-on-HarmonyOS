package i9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f7102a;

    public b(int i10) {
        this.f7102a = i10;
    }

    public int a() {
        return (this.f7102a >> 2) & 127;
    }

    public int b() {
        return this.f7102a;
    }

    public boolean c() {
        return (this.f7102a & 1) == 1;
    }

    public boolean d() {
        return ((this.f7102a >> 1) & 1) == 1;
    }

    public void e(boolean z10) {
        if (z10) {
            this.f7102a |= 1;
        } else {
            this.f7102a &= -2;
        }
    }

    public void f(int i10) {
        this.f7102a = i10;
    }

    public void g(boolean z10) {
        if (z10) {
            this.f7102a |= 2;
        } else {
            this.f7102a &= -3;
        }
    }

    public String toString() {
        return "LogoDesignInfo{blur=" + c() + ", isSearchPartHidden=" + d() + ", backgroundOpacity=" + a() + ", flag=0x" + Integer.toHexString(this.f7102a) + '}';
    }
}
