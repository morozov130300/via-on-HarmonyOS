package g7;

import java.util.Comparator;
import kotlin.jvm.internal.h;
import p7.l;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static Comparator b(final l... selectors) {
        h.f(selectors, "selectors");
        if (selectors.length > 0) {
            return new Comparator() { // from class: g7.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return b.c(selectors, obj, obj2);
                }
            };
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static final int c(l[] lVarArr, Object obj, Object obj2) {
        return e(obj, obj2, lVarArr);
    }

    public static final int d(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static final int e(Object obj, Object obj2, l[] lVarArr) {
        for (l lVar : lVarArr) {
            int iD = d((Comparable) lVar.invoke(obj), (Comparable) lVar.invoke(obj2));
            if (iD != 0) {
                return iD;
            }
        }
        return 0;
    }
}
