package kotlin.jvm.internal;

import p7.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static Object a(Object obj, int i10) {
        if (obj != null && !c(obj, i10)) {
            f(obj, "kotlin.jvm.functions.Function" + i10);
        }
        return obj;
    }

    public static int b(Object obj) {
        if (obj instanceof g) {
            return ((g) obj).getArity();
        }
        if (obj instanceof p7.a) {
            return 0;
        }
        if (obj instanceof p7.l) {
            return 1;
        }
        return obj instanceof p ? 2 : -1;
    }

    public static boolean c(Object obj, int i10) {
        return (obj instanceof d7.b) && b(obj) == i10;
    }

    public static Throwable d(Throwable th) {
        return h.k(th, l.class.getName());
    }

    public static ClassCastException e(ClassCastException classCastException) {
        throw ((ClassCastException) d(classCastException));
    }

    public static void f(Object obj, String str) {
        g((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void g(String str) {
        throw e(new ClassCastException(str));
    }
}
