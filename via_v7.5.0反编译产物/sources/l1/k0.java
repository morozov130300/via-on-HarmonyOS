package l1;

import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f7432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m1.d f7433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m0 f7434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n1.a f7435d;

    public k0(Executor executor, m1.d dVar, m0 m0Var, n1.a aVar) {
        this.f7432a = executor;
        this.f7433b = dVar;
        this.f7434c = m0Var;
        this.f7435d = aVar;
    }

    public static /* synthetic */ Object a(k0 k0Var) {
        Iterator it = k0Var.f7433b.E().iterator();
        while (it.hasNext()) {
            k0Var.f7434c.a((e1.p) it.next(), 1);
        }
        return null;
    }

    public void c() {
        this.f7432a.execute(new Runnable() { // from class: l1.i0
            @Override // java.lang.Runnable
            public final void run() {
                k0 k0Var = this.f7430c;
                k0Var.f7435d.a(new n1.a.InterfaceC0101a() { // from class: l1.j0
                    @Override // n1.a.InterfaceC0101a
                    public final Object c() {
                        return k0.a(k0Var);
                    }
                });
            }
        });
    }
}
