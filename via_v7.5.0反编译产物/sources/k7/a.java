package k7;

import e7.l;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.h;
import kotlin.random.Random;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: k7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0088a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0088a f7214a = new C0088a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f7215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Method f7216c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            h.c(methods);
            int length = methods.length;
            int i10 = 0;
            while (true) {
                method = null;
                if (i10 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i10];
                if (h.a(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    h.e(parameterTypes, "getParameterTypes(...)");
                    if (h.a(l.s(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i10++;
            }
            f7215b = method2;
            for (Method method3 : methods) {
                if (h.a(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
            }
            f7216c = method;
        }
    }

    public void a(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        h.f(cause, "cause");
        h.f(exception, "exception");
        Method method = C0088a.f7215b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public Random b() {
        return new q7.b();
    }
}
