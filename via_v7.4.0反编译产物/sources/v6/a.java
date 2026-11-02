package v6;

import a7.f;
import java.util.concurrent.Callable;
import x6.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile f f13042a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile f f13043b;

    public static Object a(f fVar, Object obj) {
        try {
            return fVar.apply(obj);
        } catch (Throwable th) {
            throw z6.a.a(th);
        }
    }

    public static n b(f fVar, Callable callable) {
        n nVar = (n) a(fVar, callable);
        if (nVar != null) {
            return nVar;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    public static n c(Callable callable) {
        try {
            n nVar = (n) callable.call();
            if (nVar != null) {
                return nVar;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw z6.a.a(th);
        }
    }

    public static n d(Callable callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        f fVar = f13042a;
        return fVar == null ? c(callable) : b(fVar, callable);
    }

    public static n e(n nVar) {
        if (nVar == null) {
            throw new NullPointerException("scheduler == null");
        }
        f fVar = f13043b;
        return fVar == null ? nVar : (n) a(fVar, nVar);
    }
}
