package l1;

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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f1.d f7413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m1.d f7414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m0 f7415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f7416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n1.a f7417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o1.a f7418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o1.a f7419h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m1.c f7420i;

    public g0(Context context, f1.d dVar, m1.d dVar2, m0 m0Var, Executor executor, n1.a aVar, o1.a aVar2, o1.a aVar3, m1.c cVar) {
        this.f7412a = context;
        this.f7413b = dVar;
        this.f7414c = dVar2;
        this.f7415d = m0Var;
        this.f7416e = executor;
        this.f7417f = aVar;
        this.f7418g = aVar2;
        this.f7419h = aVar3;
        this.f7420i = cVar;
    }

    public static /* synthetic */ Object b(g0 g0Var, Iterable iterable, e1.p pVar, long j10) {
        g0Var.f7414c.V(iterable);
        g0Var.f7414c.D(pVar, g0Var.f7418g.a() + j10);
        return null;
    }

    public static /* synthetic */ Object c(g0 g0Var) {
        g0Var.f7420i.b();
        return null;
    }

    public static /* synthetic */ Object e(g0 g0Var, Iterable iterable) {
        g0Var.f7414c.A(iterable);
        return null;
    }

    public static /* synthetic */ Object f(g0 g0Var, e1.p pVar, int i10) {
        g0Var.f7415d.a(pVar, i10 + 1);
        return null;
    }

    public static /* synthetic */ Object g(g0 g0Var, e1.p pVar, long j10) {
        g0Var.f7414c.D(pVar, g0Var.f7418g.a() + j10);
        return null;
    }

    public static /* synthetic */ Object h(g0 g0Var, Map map) {
        g0Var.getClass();
        for (Map.Entry entry : map.entrySet()) {
            g0Var.f7420i.e(((Integer) entry.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    public static /* synthetic */ void i(final g0 g0Var, final e1.p pVar, final int i10, Runnable runnable) {
        g0Var.getClass();
        try {
            n1.a aVar = g0Var.f7417f;
            final m1.d dVar = g0Var.f7414c;
            Objects.requireNonNull(dVar);
            aVar.a(new n1.a.InterfaceC0101a() { // from class: l1.x
                @Override // n1.a.InterfaceC0101a
                public final Object c() {
                    return Integer.valueOf(dVar.y());
                }
            });
            if (g0Var.k()) {
                g0Var.l(pVar, i10);
            } else {
                g0Var.f7417f.a(new n1.a.InterfaceC0101a() { // from class: l1.y
                    @Override // n1.a.InterfaceC0101a
                    public final Object c() {
                        return g0.f(this.f7451a, pVar, i10);
                    }
                });
            }
        } catch (SynchronizationException unused) {
            g0Var.f7415d.a(pVar, i10 + 1);
        } finally {
            runnable.run();
        }
    }

    public e1.i j(f1.k kVar) {
        n1.a aVar = this.f7417f;
        final m1.c cVar = this.f7420i;
        Objects.requireNonNull(cVar);
        return kVar.b(e1.i.a().i(this.f7418g.a()).k(this.f7419h.a()).j("GDT_CLIENT_METRICS").h(new e1.h(b1.b.b("proto"), ((h1.a) aVar.a(new n1.a.InterfaceC0101a() { // from class: l1.w
            @Override // n1.a.InterfaceC0101a
            public final Object c() {
                return cVar.c();
            }
        })).f())).d());
    }

    public boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f7412a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public BackendResponse l(final e1.p pVar, int i10) {
        BackendResponse backendResponseA;
        f1.k kVar = this.f7413b.get(pVar.b());
        BackendResponse backendResponseE = BackendResponse.e(0L);
        final long j10 = 0;
        while (((Boolean) this.f7417f.a(new n1.a.InterfaceC0101a() { // from class: l1.z
            @Override // n1.a.InterfaceC0101a
            public final Object c() {
                return Boolean.valueOf(this.f7454a.f7414c.P(pVar));
            }
        })).booleanValue()) {
            final Iterable iterable = (Iterable) this.f7417f.a(new n1.a.InterfaceC0101a() { // from class: l1.a0
                @Override // n1.a.InterfaceC0101a
                public final Object c() {
                    return this.f7398a.f7414c.G(pVar);
                }
            });
            if (!iterable.iterator().hasNext()) {
                return backendResponseE;
            }
            if (kVar == null) {
                i1.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", pVar);
                backendResponseA = BackendResponse.a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((m1.k) it.next()).b());
                }
                if (pVar.e()) {
                    arrayList.add(j(kVar));
                }
                backendResponseA = kVar.a(f1.e.a().b(arrayList).c(pVar.c()).a());
            }
            backendResponseE = backendResponseA;
            if (backendResponseE.c() == BackendResponse.Status.TRANSIENT_ERROR) {
                final e1.p pVar2 = pVar;
                this.f7417f.a(new n1.a.InterfaceC0101a() { // from class: l1.b0
                    @Override // n1.a.InterfaceC0101a
                    public final Object c() {
                        return g0.b(this.f7400a, iterable, pVar2, j10);
                    }
                });
                this.f7415d.b(pVar2, i10 + 1, true);
                return backendResponseE;
            }
            e1.p pVar3 = pVar;
            this.f7417f.a(new n1.a.InterfaceC0101a() { // from class: l1.c0
                @Override // n1.a.InterfaceC0101a
                public final Object c() {
                    return g0.e(this.f7404a, iterable);
                }
            });
            if (backendResponseE.c() == BackendResponse.Status.OK) {
                long jMax = Math.max(j10, backendResponseE.b());
                if (pVar3.e()) {
                    this.f7417f.a(new n1.a.InterfaceC0101a() { // from class: l1.d0
                        @Override // n1.a.InterfaceC0101a
                        public final Object c() {
                            return g0.c(this.f7406a);
                        }
                    });
                }
                j10 = jMax;
            } else if (backendResponseE.c() == BackendResponse.Status.INVALID_PAYLOAD) {
                final HashMap map = new HashMap();
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    String strJ = ((m1.k) it2.next()).b().j();
                    if (map.containsKey(strJ)) {
                        map.put(strJ, Integer.valueOf(((Integer) map.get(strJ)).intValue() + 1));
                    } else {
                        map.put(strJ, 1);
                    }
                }
                this.f7417f.a(new n1.a.InterfaceC0101a() { // from class: l1.e0
                    @Override // n1.a.InterfaceC0101a
                    public final Object c() {
                        return g0.h(this.f7407a, map);
                    }
                });
            }
            pVar = pVar3;
        }
        final e1.p pVar4 = pVar;
        this.f7417f.a(new n1.a.InterfaceC0101a() { // from class: l1.f0
            @Override // n1.a.InterfaceC0101a
            public final Object c() {
                return g0.g(this.f7409a, pVar4, j10);
            }
        });
        return backendResponseE;
    }

    public void m(final e1.p pVar, final int i10, final Runnable runnable) {
        this.f7416e.execute(new Runnable() { // from class: l1.v
            @Override // java.lang.Runnable
            public final void run() {
                g0.i(this.f7445c, pVar, i10, runnable);
            }
        });
    }
}
