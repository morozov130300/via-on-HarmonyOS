package g2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class i {
    public static Object a(f fVar) throws InterruptedException {
        t1.f.f();
        t1.f.i(fVar, "Task must not be null");
        if (fVar.j()) {
            return h(fVar);
        }
        k kVar = new k(null);
        i(fVar, kVar);
        kVar.a();
        return h(fVar);
    }

    public static Object b(f fVar, long j10, TimeUnit timeUnit) throws TimeoutException {
        t1.f.f();
        t1.f.i(fVar, "Task must not be null");
        t1.f.i(timeUnit, "TimeUnit must not be null");
        if (fVar.j()) {
            return h(fVar);
        }
        k kVar = new k(null);
        i(fVar, kVar);
        if (kVar.d(j10, timeUnit)) {
            return h(fVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static f c(Executor executor, Callable callable) {
        t1.f.i(executor, "Executor must not be null");
        t1.f.i(callable, "Callback must not be null");
        d0 d0Var = new d0();
        executor.execute(new e0(d0Var, callable));
        return d0Var;
    }

    public static f d(Exception exc) {
        d0 d0Var = new d0();
        d0Var.n(exc);
        return d0Var;
    }

    public static f e(Object obj) {
        d0 d0Var = new d0();
        d0Var.o(obj);
        return d0Var;
    }

    public static f f(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return e(null);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((f) it.next()) == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        d0 d0Var = new d0();
        m mVar = new m(collection.size(), d0Var);
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            i((f) it2.next(), mVar);
        }
        return d0Var;
    }

    public static f g(f... fVarArr) {
        return (fVarArr == null || fVarArr.length == 0) ? e(null) : f(Arrays.asList(fVarArr));
    }

    public static Object h(f fVar) throws ExecutionException {
        if (fVar.k()) {
            return fVar.h();
        }
        if (fVar.i()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(fVar.g());
    }

    public static void i(f fVar, l lVar) {
        Executor executor = h.f6151b;
        fVar.c(executor, lVar);
        fVar.b(executor, lVar);
        fVar.a(executor, lVar);
    }
}
