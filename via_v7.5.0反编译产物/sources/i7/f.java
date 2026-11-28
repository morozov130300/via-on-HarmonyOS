package i7;

import java.lang.reflect.Method;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f6297a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f6298b = new a(null, null, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f6299c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f6300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f6301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f6302c;

        public a(Method method, Method method2, Method method3) {
            this.f6300a = method;
            this.f6301b = method2;
            this.f6302c = method3;
        }
    }

    public final a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            f6299c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f6298b;
            f6299c = aVar2;
            return aVar2;
        }
    }

    public final String b(BaseContinuationImpl continuation) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        h.f(continuation, "continuation");
        a aVarA = f6299c;
        if (aVarA == null) {
            aVarA = a(continuation);
        }
        if (aVarA != f6298b && (method = aVarA.f6300a) != null && (objInvoke = method.invoke(continuation.getClass(), null)) != null && (method2 = aVarA.f6301b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = aVarA.f6302c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                return (String) objInvoke3;
            }
        }
        return null;
    }
}
