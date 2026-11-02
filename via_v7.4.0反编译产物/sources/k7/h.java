package k7;

import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class h extends g {
    public static final List b(Object[] objArr) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        List listA = j.a(objArr);
        kotlin.jvm.internal.h.e(listA, "asList(this)");
        return listA;
    }

    public static final Object[] c(Object[] objArr, Object[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        kotlin.jvm.internal.h.f(destination, "destination");
        System.arraycopy(objArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static /* synthetic */ Object[] d(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return c(objArr, objArr2, i10, i11, i12);
    }

    public static final void e(Object[] objArr, Object obj, int i10, int i11) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        Arrays.fill(objArr, i10, i11, obj);
    }

    public static void f(int[] iArr) {
        kotlin.jvm.internal.h.f(iArr, "<this>");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }
}
