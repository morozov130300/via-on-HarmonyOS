package hc;

import kc.v;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class p extends mc.a {

    /* renamed from: a, reason: collision with root package name */
    public final kc.s f6956a = new kc.s();

    /* renamed from: b, reason: collision with root package name */
    public int f6957b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6958c;

    public p(int i10) {
        this.f6957b = i10;
    }

    @Override // mc.a, mc.d
    public boolean a() {
        return true;
    }

    @Override // mc.d
    public kc.a e() {
        return this.f6956a;
    }

    @Override // mc.a, mc.d
    public boolean f(kc.a aVar) {
        if (!this.f6958c) {
            return true;
        }
        kc.a aVarF = this.f6956a.f();
        if (!(aVarF instanceof kc.r)) {
            return true;
        }
        ((kc.r) aVarF).o(false);
        return true;
    }

    @Override // mc.d
    public mc.c g(mc.h hVar) {
        if (!hVar.a()) {
            return hVar.b() >= this.f6957b ? mc.c.a(hVar.e() + this.f6957b) : mc.c.d();
        }
        if (this.f6956a.c() == null) {
            return mc.c.d();
        }
        kc.a aVarE = hVar.d().e();
        this.f6958c = (aVarE instanceof v) || (aVarE instanceof kc.s);
        return mc.c.b(hVar.c());
    }
}
