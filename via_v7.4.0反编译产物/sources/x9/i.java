package x9;

import z8.c0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i implements g {

    /* renamed from: a, reason: collision with root package name */
    public final w9.l f14309a;

    public i(w9.l lVar) {
        this.f14309a = lVar;
    }

    @Override // x9.g
    public void a() {
        w9.a aVarV = this.f14309a.v();
        aVarV.K((c0.f() || z8.f.h()) && !c0.j());
        this.f14309a.q0(aVarV);
        int iX1 = this.f14309a.X1();
        if ((iX1 & 8) != 0) {
            this.f14309a.f(iX1 | 32);
        }
    }

    @Override // x9.g
    public int b() {
        return 12;
    }
}
