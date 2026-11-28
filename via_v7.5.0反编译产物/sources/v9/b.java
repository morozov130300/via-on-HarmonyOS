package v9;

import x8.a0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u9.l f13442a;

    public b(u9.l lVar) {
        this.f13442a = lVar;
    }

    @Override // v9.g
    public void a() {
        u9.a aVarV = this.f13442a.v();
        aVarV.w(a0.f() || x8.f.h());
        this.f13442a.Z(aVarV);
    }

    @Override // v9.g
    public int b() {
        return 11;
    }
}
