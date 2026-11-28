package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f969a = new l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f970b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f971c = new HashMap();

    public static final String c(String className) {
        kotlin.jvm.internal.h.f(className, "className");
        return kotlin.text.x.z(className, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    public static final h f(Object object) {
        kotlin.jvm.internal.h.f(object, "object");
        boolean z10 = object instanceof h;
        boolean z11 = object instanceof d;
        if (z10 && z11) {
            return new DefaultLifecycleObserverAdapter((d) object, (h) object);
        }
        if (z11) {
            return new DefaultLifecycleObserverAdapter((d) object, null);
        }
        if (z10) {
            return (h) object;
        }
        Class<?> cls = object.getClass();
        l lVar = f969a;
        if (lVar.d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(object);
        }
        Object obj = f971c.get(cls);
        kotlin.jvm.internal.h.c(obj);
        List list = (List) obj;
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(lVar.a((Constructor) list.get(0), object));
        }
        int size = list.size();
        e[] eVarArr = new e[size];
        for (int i10 = 0; i10 < size; i10++) {
            eVarArr[i10] = f969a.a((Constructor) list.get(i10), object);
        }
        return new CompositeGeneratedAdaptersObserver(eVarArr);
    }

    public final e a(Constructor constructor, Object obj) {
        try {
            Object objNewInstance = constructor.newInstance(obj);
            kotlin.jvm.internal.h.e(objNewInstance, "{\n            constructo…tance(`object`)\n        }");
            return (e) objNewInstance;
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Constructor b(Class cls) {
        try {
            Package r10 = cls.getPackage();
            String name = cls.getCanonicalName();
            String fullPackage = r10 != null ? r10.getName() : "";
            kotlin.jvm.internal.h.e(fullPackage, "fullPackage");
            if (fullPackage.length() != 0) {
                kotlin.jvm.internal.h.e(name, "name");
                name = name.substring(fullPackage.length() + 1);
                kotlin.jvm.internal.h.e(name, "this as java.lang.String).substring(startIndex)");
            }
            kotlin.jvm.internal.h.e(name, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String strC = c(name);
            if (fullPackage.length() != 0) {
                strC = fullPackage + '.' + strC;
            }
            Class<?> cls2 = Class.forName(strC);
            kotlin.jvm.internal.h.d(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final int d(Class cls) {
        Map map = f970b;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        map.put(cls, Integer.valueOf(iG));
        return iG;
    }

    public final boolean e(Class cls) {
        return cls != null && i.class.isAssignableFrom(cls);
    }

    public final int g(Class cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructorB = b(cls);
        if (constructorB != null) {
            f971c.put(cls, e7.n.e(constructorB));
            return 2;
        }
        if (b.f950c.d(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (e(superclass)) {
            kotlin.jvm.internal.h.e(superclass, "superclass");
            if (d(superclass) == 1) {
                return 1;
            }
            Object obj = f971c.get(superclass);
            kotlin.jvm.internal.h.c(obj);
            arrayList = new ArrayList((Collection) obj);
        } else {
            arrayList = null;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        kotlin.jvm.internal.h.e(interfaces, "klass.interfaces");
        for (Class<?> intrface : interfaces) {
            if (e(intrface)) {
                kotlin.jvm.internal.h.e(intrface, "intrface");
                if (d(intrface) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Object obj2 = f971c.get(intrface);
                kotlin.jvm.internal.h.c(obj2);
                arrayList.addAll((Collection) obj2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f971c.put(cls, arrayList);
        return 2;
    }
}
