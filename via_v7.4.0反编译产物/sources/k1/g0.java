package k1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import m1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8065a;

    /* renamed from: b, reason: collision with root package name */
    public final e1.d f8066b;

    /* renamed from: c, reason: collision with root package name */
    public final l1.d f8067c;

    /* renamed from: d, reason: collision with root package name */
    public final m0 f8068d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f8069e;

    /* renamed from: f, reason: collision with root package name */
    public final m1.a f8070f;

    /* renamed from: g, reason: collision with root package name */
    public final n1.a f8071g;

    /* renamed from: h, reason: collision with root package name */
    public final n1.a f8072h;

    /* renamed from: i, reason: collision with root package name */
    public final l1.c f8073i;

    public g0(Context context, e1.d dVar, l1.d dVar2, m0 m0Var, Executor executor, m1.a aVar, n1.a aVar2, n1.a aVar3, l1.c cVar) {
        this.f8065a = context;
        this.f8066b = dVar;
        this.f8067c = dVar2;
        this.f8068d = m0Var;
        this.f8069e = executor;
        this.f8070f = aVar;
        this.f8071g = aVar2;
        this.f8072h = aVar3;
        this.f8073i = cVar;
    }

    public static /* synthetic */ Object b(g0 g0Var, Iterable iterable, d1.p pVar, long j10) {
        g0Var.f8067c.V(iterable);
        g0Var.f8067c.Q(pVar, g0Var.f8071g.a() + j10);
        return null;
    }

    public static /* synthetic */ Object c(g0 g0Var) {
        g0Var.f8073i.b();
        return null;
    }

    public static /* synthetic */ Object e(g0 g0Var, Iterable iterable) {
        g0Var.f8067c.z(iterable);
        return null;
    }

    public static /* synthetic */ Object f(g0 g0Var, d1.p pVar, int i10) {
        g0Var.f8068d.b(pVar, i10 + 1);
        return null;
    }

    public static /* synthetic */ Object g(g0 g0Var, d1.p pVar, long j10) {
        g0Var.f8067c.Q(pVar, g0Var.f8071g.a() + j10);
        return null;
    }

    public static /* synthetic */ Object h(g0 g0Var, Map map) {
        g0Var.getClass();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            g0Var.f8073i.f(((Integer) r0.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
        }
        return null;
    }

    public static /* synthetic */ void i(final g0 g0Var, final d1.p pVar, final int i10, Runnable runnable) {
        g0Var.getClass();
        try {
            try {
                m1.a aVar = g0Var.f8070f;
                final l1.d dVar = g0Var.f8067c;
                Objects.requireNonNull(dVar);
                aVar.a(new a.InterfaceC0097a() { // from class: k1.x
                    @Override // m1.a.InterfaceC0097a
                    public final Object f() {
                        return Integer.valueOf(dVar.y());
                    }
                });
                if (g0Var.k()) {
                    g0Var.l(pVar, i10);
                } else {
                    g0Var.f8070f.a(new a.InterfaceC0097a() { // from class: k1.y
                        @Override // m1.a.InterfaceC0097a
                        public final Object f() {
                            return g0.f(this.f8104a, pVar, i10);
                        }
                    });
                }
                runnable.run();
            } catch (SynchronizationException unused) {
                g0Var.f8068d.b(pVar, i10 + 1);
                runnable.run();
            }
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }

    public d1.i j(e1.k kVar) {
        m1.a aVar = this.f8070f;
        final l1.c cVar = this.f8073i;
        Objects.requireNonNull(cVar);
        return kVar.b(d1.i.a().i(this.f8071g.a()).k(this.f8072h.a()).j("GDT_CLIENT_METRICS").h(new d1.h(a1.b.b("proto"), ((g1.a) aVar.a(new a.InterfaceC0097a() { // from class: k1.w
            @Override // m1.a.InterfaceC0097a
            public final Object f() {
                return cVar.d();
            }
        })).f())).d());
    }

    public boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f8065a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public BackendResponse l(final d1.p pVar, int i10) {
        BackendResponse backendResponseA;
        e1.k kVar = this.f8066b.get(pVar.b());
        BackendResponse backendResponseE = BackendResponse.e(0L);
        final long j10 = 0;
        while (((Boolean) this.f8070f.a(new a.InterfaceC0097a() { // from class: k1.z
            @Override // m1.a.InterfaceC0097a
            public final Object f() {
                return Boolean.valueOf(this.f8107a.f8067c.M(pVar));
            }
        })).booleanValue()) {
            final Iterable iterable = (Iterable) this.f8070f.a(new a.InterfaceC0097a() { // from class: k1.a0
                @Override // m1.a.InterfaceC0097a
                public final Object f() {
                    return this.f8051a.f8067c.B(pVar);
                }
            });
            if (!iterable.iterator().hasNext()) {
                return backendResponseE;
            }
            if (kVar == null) {
                h1.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", pVar);
                backendResponseA = BackendResponse.a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((l1.k) it.next()).b());
                }
                if (pVar.e()) {
                    arrayList.add(j(kVar));
                }
                backendResponseA = kVar.a(e1.e.a().b(arrayList).c(pVar.c()).a());
            }
            backendResponseE = backendResponseA;
            if (backendResponseE.c() == BackendResponse.Status.TRANSIENT_ERROR) {
                final d1.p pVar2 = pVar;
                this.f8070f.a(new a.InterfaceC0097a() { // from class: k1.b0
                    @Override // m1.a.InterfaceC0097a
                    public final Object f() {
                        return g0.b(this.f8053a, iterable, pVar2, j10);
                    }
                });
                this.f8068d.a(pVar2, i10 + 1, true);
                return backendResponseE;
            }
            d1.p pVar3 = pVar;
            this.f8070f.a(new a.InterfaceC0097a() { // from class: k1.c0
                @Override // m1.a.InterfaceC0097a
                public final Object f() {
                    return g0.e(this.f8057a, iterable);
                }
            });
            if (backendResponseE.c() == BackendResponse.Status.OK) {
                long jMax = Math.max(j10, backendResponseE.b());
                if (pVar3.e()) {
                    this.f8070f.a(new a.InterfaceC0097a() { // from class: k1.d0
                        @Override // m1.a.InterfaceC0097a
                        public final Object f() {
                            return g0.c(this.f8059a);
                        }
                    });
                }
                j10 = jMax;
            } else if (backendResponseE.c() == BackendResponse.Status.INVALID_PAYLOAD) {
                final HashMap map = new HashMap();
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    String strJ = ((l1.k) it2.next()).b().j();
                    if (map.containsKey(strJ)) {
                        map.put(strJ, Integer.valueOf(((Integer) map.get(strJ)).intValue() + 1));
                    } else {
                        map.put(strJ, 1);
                    }
                }
                this.f8070f.a(new a.InterfaceC0097a() { // from class: k1.e0
                    @Override // m1.a.InterfaceC0097a
                    public final Object f() {
                        return g0.h(this.f8060a, map);
                    }
                });
            }
            pVar = pVar3;
        }
        final d1.p pVar4 = pVar;
        this.f8070f.a(new a.InterfaceC0097a() { // from class: k1.f0
            @Override // m1.a.InterfaceC0097a
            public final Object f() {
                return g0.g(this.f8062a, pVar4, j10);
            }
        });
        return backendResponseE;
    }

    public void m(final d1.p pVar, final int i10, final Runnable runnable) {
        this.f8069e.execute(new Runnable() { // from class: k1.v
            @Override // java.lang.Runnable
            public final void run() {
                g0.i(this.f8098e, pVar, i10, runnable);
            }
        });
    }
}
