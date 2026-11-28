package z6;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.exceptions.UndeliverableException;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Objects;
import r6.h;
import r6.o;
import r6.p;
import r6.q;
import r6.s;
import u6.b;
import u6.f;
import u6.g;
import u6.j;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f f15194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile g f15195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile g f15196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile g f15197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile g f15198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile g f15199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile g f15200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile g f15201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile g f15202i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile g f15203j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile g f15204k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile g f15205l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile g f15206m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile b f15207n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile b f15208o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile b f15209p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile b f15210q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile boolean f15211r;

    public static Object a(b bVar, Object obj, Object obj2) {
        try {
            return bVar.apply(obj, obj2);
        } catch (Throwable th) {
            throw ExceptionHelper.f(th);
        }
    }

    public static Object b(g gVar, Object obj) {
        try {
            return gVar.apply(obj);
        } catch (Throwable th) {
            throw ExceptionHelper.f(th);
        }
    }

    public static p c(g gVar, j jVar) {
        Object objB = b(gVar, jVar);
        Objects.requireNonNull(objB, "Scheduler Supplier result can't be null");
        return (p) objB;
    }

    public static p d(j jVar) {
        try {
            Object obj = jVar.get();
            Objects.requireNonNull(obj, "Scheduler Supplier result can't be null");
            return (p) obj;
        } catch (Throwable th) {
            throw ExceptionHelper.f(th);
        }
    }

    public static p e(j jVar) {
        Objects.requireNonNull(jVar, "Scheduler Supplier can't be null");
        g gVar = f15196c;
        return gVar == null ? d(jVar) : c(gVar, jVar);
    }

    public static p f(j jVar) {
        Objects.requireNonNull(jVar, "Scheduler Supplier can't be null");
        g gVar = f15198e;
        return gVar == null ? d(jVar) : c(gVar, jVar);
    }

    public static p g(j jVar) {
        Objects.requireNonNull(jVar, "Scheduler Supplier can't be null");
        g gVar = f15199f;
        return gVar == null ? d(jVar) : c(gVar, jVar);
    }

    public static p h(j jVar) {
        Objects.requireNonNull(jVar, "Scheduler Supplier can't be null");
        g gVar = f15197d;
        return gVar == null ? d(jVar) : c(gVar, jVar);
    }

    public static boolean i(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    public static r6.a j(r6.a aVar) {
        g gVar = f15206m;
        return gVar != null ? (r6.a) b(gVar, aVar) : aVar;
    }

    public static r6.f k(r6.f fVar) {
        g gVar = f15204k;
        return gVar != null ? (r6.f) b(gVar, fVar) : fVar;
    }

    public static r6.j l(r6.j jVar) {
        g gVar = f15203j;
        return gVar != null ? (r6.j) b(gVar, jVar) : jVar;
    }

    public static q m(q qVar) {
        g gVar = f15205l;
        return gVar != null ? (q) b(gVar, qVar) : qVar;
    }

    public static p n(p pVar) {
        g gVar = f15200g;
        return gVar == null ? pVar : (p) b(gVar, pVar);
    }

    public static void o(Throwable th) {
        f fVar = f15194a;
        if (th == null) {
            th = ExceptionHelper.b("onError called with a null Throwable.");
        } else if (!i(th)) {
            th = new UndeliverableException(th);
        }
        if (fVar != null) {
            try {
                fVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                x(th2);
            }
        }
        th.printStackTrace();
        x(th);
    }

    public static p p(p pVar) {
        g gVar = f15202i;
        return gVar == null ? pVar : (p) b(gVar, pVar);
    }

    public static Runnable q(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        g gVar = f15195b;
        return gVar == null ? runnable : (Runnable) b(gVar, runnable);
    }

    public static p r(p pVar) {
        g gVar = f15201h;
        return gVar == null ? pVar : (p) b(gVar, pVar);
    }

    public static r6.b s(r6.a aVar, r6.b bVar) {
        b bVar2 = f15210q;
        return bVar2 != null ? (r6.b) a(bVar2, aVar, bVar) : bVar;
    }

    public static h t(r6.f fVar, h hVar) {
        b bVar = f15207n;
        return bVar != null ? (h) a(bVar, fVar, hVar) : hVar;
    }

    public static o u(r6.j jVar, o oVar) {
        b bVar = f15208o;
        return bVar != null ? (o) a(bVar, jVar, oVar) : oVar;
    }

    public static s v(q qVar, s sVar) {
        b bVar = f15209p;
        return bVar != null ? (s) a(bVar, qVar, sVar) : sVar;
    }

    public static void w(f fVar) {
        if (f15211r) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f15194a = fVar;
    }

    public static void x(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
