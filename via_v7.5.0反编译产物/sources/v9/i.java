package v9;

import x8.a0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u9.l f13449a;

    public i(u9.l lVar) {
        this.f13449a = lVar;
    }

    @Override // v9.g
    public void a() {
        u9.a aVarV = this.f13449a.v();
        aVarV.J((a0.f() || x8.f.h()) && !a0.i());
        this.f13449a.Z(aVarV);
        int iX1 = this.f13449a.X1();
        if ((iX1 & 8) != 0) {
            this.f13449a.g(iX1 | 32);
        }
    }

    @Override // v9.g
    public int b() {
        return 12;
    }
}
