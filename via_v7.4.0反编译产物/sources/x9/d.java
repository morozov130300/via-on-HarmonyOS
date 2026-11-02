package x9;

import w9.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d implements g {

    /* renamed from: a, reason: collision with root package name */
    public final w9.l f14305a;

    public d(w9.l lVar) {
        this.f14305a = lVar;
    }

    @Override // x9.g
    public void a() {
        i9.d dVarR0 = this.f14305a.r0();
        if (dVarR0.a() != 193766400) {
            dVarR0.m((int) ((dVarR0.d() / 127.0f) * 100.0f));
            this.f14305a.W1(dVarR0);
        }
        i9.e eVarV2 = this.f14305a.V2();
        if (eVarV2.b() != 2490468) {
            eVarV2.h((int) ((eVarV2.c() / 127.0f) * 100.0f));
            eVarV2.f((int) ((eVarV2.a() / 127.0f) * 100.0f));
            eVarV2.i((int) ((eVarV2.d() / 127.0f) * 100.0f));
            this.f14305a.W0(eVarV2);
        }
        i9.c cVarX2 = this.f14305a.X2();
        if (cVarX2.a() != 1638446) {
            cVarX2.k((int) ((cVarX2.c() / 127.0f) * 100.0f));
            this.f14305a.r(cVarX2);
        }
        n.e().w(true).v(true);
    }

    @Override // x9.g
    public int b() {
        return 5;
    }
}
