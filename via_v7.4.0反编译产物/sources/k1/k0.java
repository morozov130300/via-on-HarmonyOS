package k1;

import java.util.Iterator;
import java.util.concurrent.Executor;
import m1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f8085a;

    /* renamed from: b, reason: collision with root package name */
    public final l1.d f8086b;

    /* renamed from: c, reason: collision with root package name */
    public final m0 f8087c;

    /* renamed from: d, reason: collision with root package name */
    public final m1.a f8088d;

    public k0(Executor executor, l1.d dVar, m0 m0Var, m1.a aVar) {
        this.f8085a = executor;
        this.f8086b = dVar;
        this.f8087c = m0Var;
        this.f8088d = aVar;
    }

    public static /* synthetic */ Object a(k0 k0Var) {
        Iterator it = k0Var.f8086b.D().iterator();
        while (it.hasNext()) {
            k0Var.f8087c.b((d1.p) it.next(), 1);
        }
        return null;
    }

    public void c() {
        this.f8085a.execute(new Runnable() { // from class: k1.i0
            @Override // java.lang.Runnable
            public final void run() {
                k0 k0Var = this.f8083e;
                k0Var.f8088d.a(new a.InterfaceC0097a() { // from class: k1.j0
                    @Override // m1.a.InterfaceC0097a
                    public final Object f() {
                        return k0.a(k0Var);
                    }
                });
            }
        });
    }
}
