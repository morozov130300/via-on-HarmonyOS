package sb;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class q implements j {

    /* renamed from: a, reason: collision with root package name */
    public final w9.l f11991a;

    /* renamed from: b, reason: collision with root package name */
    public final p5.c f11992b;

    public q(w9.l lVar, p5.c cVar) {
        this.f11991a = lVar;
        this.f11992b = cVar;
    }

    public static /* synthetic */ boolean b(long j10, r5.c cVar) {
        return cVar.j() && cVar.b() != null && !cVar.b().isEmpty() && cVar.f() < j10;
    }

    public static /* synthetic */ Iterable c(List list) {
        return list;
    }

    public static /* synthetic */ r e(q qVar, r5.c cVar) {
        qVar.getClass();
        int iE = cVar.e();
        r5.a aVarF = r5.a.f(s5.b.d(cVar.b()), cVar.b());
        if (aVarF == null || !qVar.f11992b.p(iE, aVarF)) {
            return r.a("Unknown error, script: " + cVar.g());
        }
        qVar.f11992b.J(aVarF.e());
        return r.b("Update " + cVar.g() + " done");
    }

    @Override // sb.j
    public x6.j a() {
        long jZ = this.f11991a.z("scripts");
        long jJ2 = this.f11991a.j2("scripts");
        final long jCurrentTimeMillis = System.currentTimeMillis() - jZ;
        if (jZ < 3600000 || jJ2 >= jCurrentTimeMillis) {
            return x6.j.l();
        }
        final p5.c cVar = this.f11992b;
        Objects.requireNonNull(cVar);
        return x6.o.g(new Callable() { // from class: sb.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return cVar.o();
            }
        }).f(new a7.f() { // from class: sb.l
            @Override // a7.f
            public final Object apply(Object obj) {
                return q.c((List) obj);
            }
        }).m(new a7.h() { // from class: sb.m
            @Override // a7.h
            public final boolean test(Object obj) {
                return q.b(jCurrentTimeMillis, (r5.c) obj);
            }
        }).n(new a7.f() { // from class: sb.n
            @Override // a7.f
            public final Object apply(Object obj) {
                return this.f11987a.g((r5.c) obj);
            }
        }).j(new a7.a() { // from class: sb.o
            @Override // a7.a
            public final void run() {
                this.f11988a.f11991a.p0("scripts", System.currentTimeMillis());
            }
        });
    }

    public final x6.j g(final r5.c cVar) {
        return x6.j.s(new Callable() { // from class: sb.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return q.e(this.f11989e, cVar);
            }
        }).D(g7.a.c());
    }
}
