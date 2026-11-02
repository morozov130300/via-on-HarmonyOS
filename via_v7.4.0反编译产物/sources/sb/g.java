package sb;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g implements j {

    /* renamed from: a, reason: collision with root package name */
    public final w9.l f11982a;

    /* renamed from: b, reason: collision with root package name */
    public final u4.a f11983b;

    public g(w9.l lVar, u4.a aVar) {
        this.f11982a = lVar;
        this.f11983b = aVar;
    }

    public static /* synthetic */ void b(g gVar) {
        List listF = gVar.f11983b.f();
        if (listF == null || listF.isEmpty()) {
            return;
        }
        gVar.f11983b.o(listF);
        gVar.f11982a.p0("filter_subscriptions", System.currentTimeMillis());
    }

    public static /* synthetic */ boolean c(long j10, w4.c cVar) {
        return cVar.f() && cVar.e() != null && cVar.b() < j10;
    }

    public static /* synthetic */ Iterable d(List list) {
        return list;
    }

    public static /* synthetic */ r f(w4.c cVar) throws Throwable {
        if (!b5.c.d(cVar.e(), cVar.a())) {
            return r.a("Unknown error, subscription: " + cVar.e());
        }
        b5.c.c(cVar);
        return r.b("Update " + cVar.e() + " done");
    }

    @Override // sb.j
    public x6.j a() {
        long jZ = this.f11982a.z("filter_subscriptions");
        long jJ2 = this.f11982a.j2("filter_subscriptions");
        final long jCurrentTimeMillis = System.currentTimeMillis() - jZ;
        if (jZ < 3600000 || jJ2 >= jCurrentTimeMillis) {
            return x6.j.l();
        }
        final u4.a aVar = this.f11983b;
        Objects.requireNonNull(aVar);
        return x6.o.g(new Callable() { // from class: sb.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.f();
            }
        }).f(new a7.f() { // from class: sb.b
            @Override // a7.f
            public final Object apply(Object obj) {
                return g.d((List) obj);
            }
        }).m(new a7.h() { // from class: sb.c
            @Override // a7.h
            public final boolean test(Object obj) {
                return g.c(jCurrentTimeMillis, (w4.c) obj);
            }
        }).n(new a7.f() { // from class: sb.d
            @Override // a7.f
            public final Object apply(Object obj) {
                return this.f11979a.g((w4.c) obj);
            }
        }).j(new a7.a() { // from class: sb.e
            @Override // a7.a
            public final void run() {
                g.b(this.f11980a);
            }
        });
    }

    public final x6.j g(final w4.c cVar) {
        return x6.j.s(new Callable() { // from class: sb.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return g.f(cVar);
            }
        }).D(g7.a.c());
    }
}
