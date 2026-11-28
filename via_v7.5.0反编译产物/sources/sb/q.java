package sb;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class q implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u9.l f12312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qa.c f12313b;

    public q(u9.l lVar, qa.c cVar) {
        this.f12312a = lVar;
        this.f12313b = cVar;
    }

    public static /* synthetic */ r c(q qVar, ra.c cVar) {
        qVar.getClass();
        int iE = cVar.e();
        ra.a aVarE = ra.a.e(ua.a.c(cVar.b()), cVar.b());
        if (aVarE == null || !qVar.f12313b.p(iE, aVarE)) {
            return r.a("Unknown error, script: " + cVar.g());
        }
        qVar.f12313b.J(aVarE.d());
        return r.b("Update " + cVar.g() + " done");
    }

    public static /* synthetic */ boolean d(long j10, ra.c cVar) {
        return cVar.j() && cVar.b() != null && !cVar.b().isEmpty() && cVar.f() < j10;
    }

    @Override // sb.j
    public r6.j a() {
        long jA = this.f12312a.A("scripts");
        long jK2 = this.f12312a.k2("scripts");
        final long jCurrentTimeMillis = System.currentTimeMillis() - jA;
        if (jA < 3600000 || jK2 >= jCurrentTimeMillis) {
            return r6.j.o();
        }
        final qa.c cVar = this.f12313b;
        Objects.requireNonNull(cVar);
        return r6.q.f(new Callable() { // from class: sb.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return cVar.q();
            }
        }).e(new u6.g() { // from class: sb.l
            @Override // u6.g
            public final Object apply(Object obj) {
                return q.e((List) obj);
            }
        }).p(new u6.i() { // from class: sb.m
            @Override // u6.i
            public final boolean test(Object obj) {
                return q.d(jCurrentTimeMillis, (ra.c) obj);
            }
        }).q(new u6.g() { // from class: sb.n
            @Override // u6.g
            public final Object apply(Object obj) {
                return this.f12308a.g((ra.c) obj);
            }
        }).l(new u6.a() { // from class: sb.o
            @Override // u6.a
            public final void run() {
                this.f12309a.f12312a.s0("scripts", System.currentTimeMillis());
            }
        });
    }

    public final r6.j g(final ra.c cVar) {
        return r6.j.v(new Callable() { // from class: sb.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return q.c(this.f12310c, cVar);
            }
        }).G(a7.a.c());
    }

    public static /* synthetic */ Iterable e(List list) {
        return list;
    }
}
