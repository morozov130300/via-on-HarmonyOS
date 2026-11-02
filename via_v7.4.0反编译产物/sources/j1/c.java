package j1;

import d1.p;
import d1.t;
import e1.k;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import k1.m0;
import m1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c implements e {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f7522f = Logger.getLogger(t.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final m0 f7523a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f7524b;

    /* renamed from: c, reason: collision with root package name */
    public final e1.d f7525c;

    /* renamed from: d, reason: collision with root package name */
    public final l1.d f7526d;

    /* renamed from: e, reason: collision with root package name */
    public final m1.a f7527e;

    public c(Executor executor, e1.d dVar, m0 m0Var, l1.d dVar2, m1.a aVar) {
        this.f7524b = executor;
        this.f7525c = dVar;
        this.f7523a = m0Var;
        this.f7526d = dVar2;
        this.f7527e = aVar;
    }

    public static /* synthetic */ Object b(c cVar, p pVar, d1.i iVar) {
        cVar.f7526d.S(pVar, iVar);
        cVar.f7523a.b(pVar, 1);
        return null;
    }

    public static /* synthetic */ void c(final c cVar, final p pVar, a1.g gVar, d1.i iVar) {
        cVar.getClass();
        try {
            k kVar = cVar.f7525c.get(pVar.b());
            if (kVar == null) {
                String str = String.format("Transport backend '%s' is not registered", pVar.b());
                f7522f.warning(str);
                gVar.a(new IllegalArgumentException(str));
            } else {
                final d1.i iVarB = kVar.b(iVar);
                cVar.f7527e.a(new a.InterfaceC0097a() { // from class: j1.b
                    @Override // m1.a.InterfaceC0097a
                    public final Object f() {
                        return c.b(this.f7519a, pVar, iVarB);
                    }
                });
                gVar.a(null);
            }
        } catch (Exception e10) {
            f7522f.warning("Error scheduling event " + e10.getMessage());
            gVar.a(e10);
        }
    }

    @Override // j1.e
    public void a(final p pVar, final d1.i iVar, final a1.g gVar) {
        this.f7524b.execute(new Runnable() { // from class: j1.a
            @Override // java.lang.Runnable
            public final void run() {
                c.c(this.f7515e, pVar, gVar, iVar);
            }
        });
    }
}
