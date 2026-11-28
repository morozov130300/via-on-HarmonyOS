package m5;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f implements n {
    @Override // m5.n
    public m a(g5.c cVar) {
        e5.c cVarF = e5.c.f();
        if (cVar.t() != null && cVar.t().startsWith("file:")) {
            return new l(cVar, cVarF.a(), cVarF.b(), cVarF.c());
        }
        if (l5.a.f(cVar.t())) {
            return new e(cVarF.e(), cVar, cVarF.a(), cVarF.b(), cVarF.d(), cVarF.c());
        }
        return l5.a.e(cVar.t()) ? new b(cVar, cVarF.b(), cVarF.c()) : new k();
    }

    @Override // m5.n
    public m b(g5.c cVar) {
        e5.c cVarF = e5.c.f();
        if (cVar.t() != null && cVar.t().startsWith("file:")) {
            return new l(cVar, null, cVarF.b(), new h5.b());
        }
        if (l5.a.f(cVar.t())) {
            return new e(cVarF.e(), cVar, null, cVarF.b(), cVarF.d(), new h5.b(), true);
        }
        return l5.a.e(cVar.t()) ? new b(cVar, cVarF.b(), new h5.b()) : new k();
    }
}
