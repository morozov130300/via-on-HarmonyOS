package ib;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class x extends a6.q {

    /* renamed from: f, reason: collision with root package name */
    public String f7176f;

    /* renamed from: g, reason: collision with root package name */
    public int f7177g;

    /* renamed from: h, reason: collision with root package name */
    public int f7178h;

    /* renamed from: i, reason: collision with root package name */
    public int f7179i;

    /* renamed from: j, reason: collision with root package name */
    public int f7180j;

    /* renamed from: k, reason: collision with root package name */
    public int f7181k;

    public x(int i10, String str, String str2, String str3, int i11, int i12, int i13, int i14, int i15) {
        super(i10, str, str2);
        this.f7176f = str3;
        this.f7179i = i11;
        this.f7177g = i12;
        this.f7178h = i13;
        this.f7180j = i14;
        this.f7181k = i15;
    }

    public int i() {
        return this.f7181k;
    }

    public String j() {
        return d();
    }

    public int k() {
        return this.f7177g;
    }

    public String l() {
        return this.f7176f;
    }

    public int m() {
        return (this.f7178h - this.f7177g) / this.f7180j;
    }

    public int n() {
        return (this.f7179i - this.f7177g) / this.f7180j;
    }

    public int o() {
        return this.f7180j;
    }
}
