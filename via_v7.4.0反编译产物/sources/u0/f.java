package u0;

import a7.h;
import autodispose2.g;
import autodispose2.lifecycle.LifecycleEndedException;
import autodispose2.lifecycle.LifecycleNotStartedException;
import java.util.Comparator;
import x6.j;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator f12448a = new Comparator() { // from class: u0.e
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    };

    public static /* synthetic */ boolean b(Comparator comparator, Object obj, Object obj2) {
        return comparator.compare(obj2, obj) >= 0;
    }

    public static x6.c c(b bVar) {
        return d(bVar, true);
    }

    public static x6.c d(b bVar, boolean z10) throws Exception {
        Object objA = bVar.a();
        a aVarC = bVar.c();
        if (objA == null) {
            throw new LifecycleNotStartedException();
        }
        try {
            return e(bVar.b(), aVarC.apply(objA));
        } catch (Exception e10) {
            if (!z10 || !(e10 instanceof LifecycleEndedException)) {
                return x6.a.d(e10);
            }
            a7.e eVarA = g.a();
            if (eVarA == null) {
                throw e10;
            }
            try {
                eVarA.accept((LifecycleEndedException) e10);
                return x6.a.b();
            } catch (Throwable th) {
                return x6.a.d(th);
            }
        }
    }

    public static x6.c e(j jVar, Object obj) {
        return f(jVar, obj, obj instanceof Comparable ? f12448a : null);
    }

    public static x6.c f(j jVar, final Object obj, final Comparator comparator) {
        return jVar.B(1L).H(comparator != null ? new h() { // from class: u0.c
            @Override // a7.h
            public final boolean test(Object obj2) {
                return f.b(comparator, obj, obj2);
            }
        } : new h() { // from class: u0.d
            @Override // a7.h
            public final boolean test(Object obj2) {
                return obj2.equals(obj);
            }
        }).v();
    }
}
