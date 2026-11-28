package sb;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u9.l f12303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u4.a f12304b;

    public g(u9.l lVar, u4.a aVar) {
        this.f12303a = lVar;
        this.f12304b = aVar;
    }

    public static /* synthetic */ void b(g gVar) {
        if (gVar.f12304b.n()) {
            gVar.f12303a.s0("filter_subscriptions", System.currentTimeMillis());
        }
    }

    public static /* synthetic */ boolean c(long j10, w4.c cVar) {
        return cVar.h() && cVar.g() != null && cVar.c() < j10;
    }

    public static /* synthetic */ r f(w4.c cVar) {
        if (!b5.c.d(cVar.g(), cVar.a())) {
            return r.a("Unknown error, subscription: " + cVar.g());
        }
        return r.b("Update " + cVar.g() + " done");
    }

    @Override // sb.j
    public r6.j a() {
        long jA = this.f12303a.A("filter_subscriptions");
        long jK2 = this.f12303a.k2("filter_subscriptions");
        final long jCurrentTimeMillis = System.currentTimeMillis() - jA;
        if (jA < 3600000 || jK2 >= jCurrentTimeMillis) {
            return r6.j.o();
        }
        final u4.a aVar = this.f12304b;
        Objects.requireNonNull(aVar);
        return r6.q.f(new Callable() { // from class: sb.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.f();
            }
        }).e(new u6.g() { // from class: sb.b
            @Override // u6.g
            public final Object apply(Object obj) {
                return g.d((List) obj);
            }
        }).p(new u6.i() { // from class: sb.c
            @Override // u6.i
            public final boolean test(Object obj) {
                return g.c(jCurrentTimeMillis, (w4.c) obj);
            }
        }).q(new u6.g() { // from class: sb.d
            @Override // u6.g
            public final Object apply(Object obj) {
                return this.f12300a.g((w4.c) obj);
            }
        }).l(new u6.a() { // from class: sb.e
            @Override // u6.a
            public final void run() {
                g.b(this.f12301a);
            }
        });
    }

    public final r6.j g(final w4.c cVar) {
        return r6.j.v(new Callable() { // from class: sb.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return g.f(cVar);
            }
        }).G(a7.a.c());
    }

    public static /* synthetic */ Iterable d(List list) {
        return list;
    }
}
