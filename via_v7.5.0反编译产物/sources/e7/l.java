package e7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class l extends k {
    public static boolean j(int[] iArr, int i10) {
        kotlin.jvm.internal.h.f(iArr, "<this>");
        return p(iArr, i10) >= 0;
    }

    public static final boolean k(Object[] objArr, Object obj) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        return q(objArr, obj) >= 0;
    }

    public static List l(Object[] objArr) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        return (List) m(objArr, new ArrayList());
    }

    public static final Collection m(Object[] objArr, Collection destination) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        kotlin.jvm.internal.h.f(destination, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static final int n(Object[] objArr) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        return objArr.length - 1;
    }

    public static Object o(Object[] objArr, int i10) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        if (i10 < 0 || i10 >= objArr.length) {
            return null;
        }
        return objArr[i10];
    }

    public static final int p(int[] iArr, int i10) {
        kotlin.jvm.internal.h.f(iArr, "<this>");
        int length = iArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i10 == iArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static final int q(Object[] objArr, Object obj) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        int i10 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i10 < length) {
                if (objArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i10 < length2) {
            if (kotlin.jvm.internal.h.a(obj, objArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static char r(char[] cArr) {
        kotlin.jvm.internal.h.f(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Object s(Object[] objArr) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static final Collection t(Object[] objArr, Collection destination) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        kotlin.jvm.internal.h.f(destination, "destination");
        for (Object obj : objArr) {
            destination.add(obj);
        }
        return destination;
    }

    public static List u(Object[] objArr) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? v(objArr) : n.e(objArr[0]);
        }
        return o.h();
    }

    public static final List v(Object[] objArr) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        return new ArrayList(o.g(objArr));
    }

    public static final Set w(Object[] objArr) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? (Set) t(objArr, new LinkedHashSet(a0.c(objArr.length))) : b0.c(objArr[0]);
        }
        return c0.d();
    }
}
