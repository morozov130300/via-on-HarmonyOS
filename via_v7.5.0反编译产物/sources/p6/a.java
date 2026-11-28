package p6;

import java.util.concurrent.Callable;
import r6.p;
import u6.g;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile g f11589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile g f11590b;

    public static Object a(g gVar, Object obj) {
        try {
            return gVar.apply(obj);
        } catch (Throwable th) {
            throw t6.a.a(th);
        }
    }

    public static p b(g gVar, Callable callable) {
        p pVar = (p) a(gVar, callable);
        if (pVar != null) {
            return pVar;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    public static p c(Callable callable) {
        try {
            p pVar = (p) callable.call();
            if (pVar != null) {
                return pVar;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw t6.a.a(th);
        }
    }

    public static p d(Callable callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        g gVar = f11589a;
        return gVar == null ? c(callable) : b(gVar, callable);
    }

    public static p e(p pVar) {
        if (pVar == null) {
            throw new NullPointerException("scheduler == null");
        }
        g gVar = f11590b;
        return gVar == null ? pVar : (p) a(gVar, pVar);
    }
}
