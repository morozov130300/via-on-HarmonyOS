package autodispose2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class q {
    public static /* synthetic */ x6.c a(o oVar) {
        try {
            return oVar.d();
        } catch (OutsideScopeException e10) {
            a7.e eVarA = g.a();
            if (eVarA == null) {
                return x6.a.d(e10);
            }
            eVarA.accept(e10);
            return x6.a.b();
        }
    }

    public static x6.a b(final o oVar) {
        return x6.a.c(new a7.i() { // from class: autodispose2.p
            @Override // a7.i
            public final Object get() {
                return q.a(oVar);
            }
        });
    }
}
