package x9;

import w9.p;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f implements g {

    /* renamed from: a, reason: collision with root package name */
    public final w9.l f14306a;

    public f(w9.l lVar) {
        this.f14306a = lVar;
    }

    @Override // x9.g
    public void a() {
        p pVarM2 = this.f14306a.m2();
        pVarM2.b0(3);
        this.f14306a.g0(pVarM2);
        pc.a.a("upgrade web settings flag done, result: %s", Long.toBinaryString(pVarM2.a()));
    }

    @Override // x9.g
    public int b() {
        return 8;
    }
}
