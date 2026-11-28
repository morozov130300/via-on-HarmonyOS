package autodispose2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {
    public static /* synthetic */ r6.c a(o oVar) {
        try {
            return oVar.d();
        } catch (OutsideScopeException e10) {
            u6.f fVarA = g.a();
            if (fVarA == null) {
                return r6.a.d(e10);
            }
            fVarA.accept(e10);
            return r6.a.b();
        }
    }

    public static r6.a b(final o oVar) {
        return r6.a.c(new u6.j() { // from class: autodispose2.p
            @Override // u6.j
            public final Object get() {
                return q.a(oVar);
            }
        });
    }
}
