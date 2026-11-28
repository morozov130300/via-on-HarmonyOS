package v9;

import u9.n;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u9.l f13445a;

    public d(u9.l lVar) {
        this.f13445a = lVar;
    }

    @Override // v9.g
    public void a() {
        g9.d dVarT0 = this.f13445a.t0();
        if (dVarT0.a() != 193766400) {
            dVarT0.m((int) ((dVarT0.d() / 127.0f) * 100.0f));
            this.f13445a.Y0(dVarT0);
        }
        g9.e eVarY2 = this.f13445a.Y2();
        if (eVarY2.b() != 2490468) {
            eVarY2.h((int) ((eVarY2.c() / 127.0f) * 100.0f));
            eVarY2.f((int) ((eVarY2.a() / 127.0f) * 100.0f));
            eVarY2.i((int) ((eVarY2.d() / 127.0f) * 100.0f));
            this.f13445a.P0(eVarY2);
        }
        g9.c cVarA3 = this.f13445a.a3();
        if (cVarA3.a() != 1638446) {
            cVarA3.k((int) ((cVarA3.c() / 127.0f) * 100.0f));
            this.f13445a.G2(cVarA3);
        }
        n.e().u(true).t(true);
    }

    @Override // v9.g
    public int b() {
        return 5;
    }
}
