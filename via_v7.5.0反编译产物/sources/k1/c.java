package k1;

import e1.p;
import e1.t;
import f1.k;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import l1.m0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f7154f = Logger.getLogger(t.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f7155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f7156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f1.d f7157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m1.d f7158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n1.a f7159e;

    public c(Executor executor, f1.d dVar, m0 m0Var, m1.d dVar2, n1.a aVar) {
        this.f7156b = executor;
        this.f7157c = dVar;
        this.f7155a = m0Var;
        this.f7158d = dVar2;
        this.f7159e = aVar;
    }

    public static /* synthetic */ Object b(c cVar, p pVar, e1.i iVar) {
        cVar.f7158d.Q(pVar, iVar);
        cVar.f7155a.a(pVar, 1);
        return null;
    }

    public static /* synthetic */ void c(final c cVar, final p pVar, b1.g gVar, e1.i iVar) {
        cVar.getClass();
        try {
            k kVar = cVar.f7157c.get(pVar.b());
            if (kVar == null) {
                String str = String.format("Transport backend '%s' is not registered", pVar.b());
                f7154f.warning(str);
                gVar.a(new IllegalArgumentException(str));
            } else {
                final e1.i iVarB = kVar.b(iVar);
                cVar.f7159e.a(new n1.a.InterfaceC0101a() { // from class: k1.b
                    @Override // n1.a.InterfaceC0101a
                    public final Object c() {
                        return c.b(this.f7151a, pVar, iVarB);
                    }
                });
                gVar.a(null);
            }
        } catch (Exception e10) {
            f7154f.warning("Error scheduling event " + e10.getMessage());
            gVar.a(e10);
        }
    }

    @Override // k1.e
    public void a(final p pVar, final e1.i iVar, final b1.g gVar) {
        this.f7156b.execute(new Runnable() { // from class: k1.a
            @Override // java.lang.Runnable
            public final void run() {
                c.c(this.f7147c, pVar, gVar, iVar);
            }
        });
    }
}
