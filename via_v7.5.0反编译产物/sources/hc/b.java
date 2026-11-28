package hc;

import android.os.Build;
import android.util.LruCache;
import android.util.Pair;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LruCache f6181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Consumer f6182b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f6183a;

        public a(Object obj) {
            this.f6183a = obj;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            return obj instanceof a ? this.f6183a.equals(((a) obj).f6183a) : this.f6183a.equals(obj);
        }

        public int hashCode() {
            return this.f6183a.hashCode();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                return b.d(method, this.f6183a.getClass().getClassLoader()).invoke(this.f6183a, objArr);
            } catch (InvocationTargetException e10) {
                throw e10.getTargetException();
            } catch (ReflectiveOperationException e11) {
                throw new RuntimeException("Reflection failed for method " + method, e11);
            }
        }
    }

    public static Object a(Class cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(b.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static boolean b(Collection collection, String str) {
        if (collection.contains(str)) {
            return true;
        }
        if (!e()) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(":dev");
        return collection.contains(sb2.toString());
    }

    public static InvocationHandler c(Object obj) {
        if (obj == null) {
            return null;
        }
        return new a(obj);
    }

    public static Method d(Method method, ClassLoader classLoader) throws NoSuchMethodException {
        LruCache lruCache = f6181a;
        if (lruCache != null) {
            Method method2 = (Method) lruCache.get(new Pair(method, classLoader));
            Consumer consumer = f6182b;
            if (consumer != null) {
                consumer.accept(Boolean.valueOf(method2 != null));
            }
            if (method2 != null) {
                return method2;
            }
        }
        Method declaredMethod = Class.forName(method.getDeclaringClass().getName(), true, classLoader).getDeclaredMethod(method.getName(), method.getParameterTypes());
        LruCache lruCache2 = f6181a;
        if (lruCache2 != null) {
            lruCache2.put(new Pair(method, classLoader), declaredMethod);
        }
        return declaredMethod;
    }

    public static boolean e() {
        String str = Build.TYPE;
        return "eng".equals(str) || "userdebug".equals(str);
    }
}
