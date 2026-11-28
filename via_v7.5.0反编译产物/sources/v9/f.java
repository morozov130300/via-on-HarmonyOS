package v9;

import u9.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u9.l f13446a;

    public f(u9.l lVar) {
        this.f13446a = lVar;
    }

    @Override // v9.g
    public void a() {
        p pVarN2 = this.f13446a.n2();
        pVarN2.a0(3);
        this.f13446a.F1(pVarN2);
        tc.a.a("upgrade web settings flag done, result: %s", Long.toBinaryString(pVarN2.a()));
    }

    @Override // v9.g
    public int b() {
        return 8;
    }
}
