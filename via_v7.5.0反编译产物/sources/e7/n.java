package e7;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.collections.builders.ListBuilder;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {
    public static List a(List builder) {
        kotlin.jvm.internal.h.f(builder, "builder");
        return ((ListBuilder) builder).build();
    }

    public static final Object[] b(Object[] objArr, boolean z10) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        if (z10 && kotlin.jvm.internal.h.a(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        kotlin.jvm.internal.h.e(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    public static List c() {
        return new ListBuilder(0, 1, null);
    }

    public static List d(int i10) {
        return new ListBuilder(i10);
    }

    public static List e(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        kotlin.jvm.internal.h.e(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static Object[] f(int i10, Object[] array) {
        kotlin.jvm.internal.h.f(array, "array");
        if (i10 < array.length) {
            array[i10] = null;
        }
        return array;
    }
}
