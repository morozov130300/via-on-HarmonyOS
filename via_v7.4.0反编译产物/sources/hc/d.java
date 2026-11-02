package hc;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d extends mc.f {

    /* renamed from: a, reason: collision with root package name */
    public final mc.d[] f6874a;

    /* renamed from: b, reason: collision with root package name */
    public int f6875b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f6876c = -1;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6877d = false;

    public d(mc.d... dVarArr) {
        this.f6874a = dVarArr;
    }

    @Override // mc.f
    public mc.f a(int i10) {
        this.f6876c = i10;
        return this;
    }

    @Override // mc.f
    public mc.f b(int i10) {
        this.f6875b = i10;
        return this;
    }

    @Override // mc.f
    public mc.f e() {
        this.f6877d = true;
        return this;
    }

    public mc.d[] f() {
        return this.f6874a;
    }

    public int g() {
        return this.f6876c;
    }

    public int h() {
        return this.f6875b;
    }

    public boolean i() {
        return this.f6877d;
    }
}
