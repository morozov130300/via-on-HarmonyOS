package v0;

import autodispose2.g;
import autodispose2.lifecycle.LifecycleEndedException;
import autodispose2.lifecycle.LifecycleNotStartedException;
import java.util.Comparator;
import r6.j;
import u6.i;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator f12987a = new Comparator() { // from class: v0.e
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    };

    public static /* synthetic */ boolean b(Comparator comparator, Object obj, Object obj2) {
        return comparator.compare(obj2, obj) >= 0;
    }

    public static r6.c c(j jVar, Object obj) {
        return d(jVar, obj, obj instanceof Comparable ? f12987a : null);
    }

    public static r6.c d(j jVar, final Object obj, final Comparator comparator) {
        return jVar.E(1L).K(comparator != null ? new i() { // from class: v0.c
            @Override // u6.i
            public final boolean test(Object obj2) {
                return f.b(comparator, obj, obj2);
            }
        } : new i() { // from class: v0.d
            @Override // u6.i
            public final boolean test(Object obj2) {
                return obj2.equals(obj);
            }
        }).y();
    }

    public static r6.c e(b bVar) {
        return f(bVar, true);
    }

    public static r6.c f(b bVar, boolean z10) throws Exception {
        Object objA = bVar.a();
        a aVarC = bVar.c();
        if (objA == null) {
            throw new LifecycleNotStartedException();
        }
        try {
            return c(bVar.b(), aVarC.apply(objA));
        } catch (Exception e10) {
            if (!z10 || !(e10 instanceof LifecycleEndedException)) {
                return r6.a.d(e10);
            }
            u6.f fVarA = g.a();
            if (fVarA == null) {
                throw e10;
            }
            try {
                fVarA.accept((LifecycleEndedException) e10);
                return r6.a.b();
            } catch (Throwable th) {
                return r6.a.d(th);
            }
        }
    }
}
