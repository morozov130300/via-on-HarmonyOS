package e7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class o extends n {
    public static final Collection g(Object[] objArr) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        return new g(objArr, false);
    }

    public static List h() {
        return EmptyList.INSTANCE;
    }

    public static s7.c i(Collection collection) {
        kotlin.jvm.internal.h.f(collection, "<this>");
        return new s7.c(0, collection.size() - 1);
    }

    public static int j(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        return list.size() - 1;
    }

    public static List k(Object... elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        return elements.length > 0 ? k.c(elements) : h();
    }

    public static List l(Object... elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new g(elements, true));
    }

    public static final List m(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : n.e(list.get(0));
        }
        return h();
    }

    public static void n() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
