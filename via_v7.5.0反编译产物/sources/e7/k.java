package e7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class k extends j {
    public static final List c(Object[] objArr) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        List listA = m.a(objArr);
        kotlin.jvm.internal.h.e(listA, "asList(...)");
        return listA;
    }

    public static Object[] d(Object[] objArr, Object[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        kotlin.jvm.internal.h.f(destination, "destination");
        System.arraycopy(objArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static /* synthetic */ Object[] e(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return d(objArr, objArr2, i10, i11, i12);
    }

    public static Object[] f(Object[] objArr, int i10, int i11) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        i.b(i11, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i10, i11);
        kotlin.jvm.internal.h.e(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static final void g(Object[] objArr, Object obj, int i10, int i11) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        Arrays.fill(objArr, i10, i11, obj);
    }

    public static void h(int[] iArr) {
        kotlin.jvm.internal.h.f(iArr, "<this>");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    public static final void i(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        kotlin.jvm.internal.h.f(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }
}
