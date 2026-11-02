package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f1054a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f1055b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Map f1056c = new HashMap();

    public static final String c(String className) {
        kotlin.jvm.internal.h.f(className, "className");
        return v7.l.j(className, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    public static final f f(Object object) {
        kotlin.jvm.internal.h.f(object, "object");
        if (object instanceof f) {
            return (f) object;
        }
        Class<?> cls = object.getClass();
        j jVar = f1054a;
        if (jVar.d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(object);
        }
        Object obj = f1056c.get(cls);
        kotlin.jvm.internal.h.c(obj);
        List list = (List) obj;
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(jVar.a((Constructor) list.get(0), object));
        }
        int size = list.size();
        c[] cVarArr = new c[size];
        for (int i10 = 0; i10 < size; i10++) {
            cVarArr[i10] = f1054a.a((Constructor) list.get(i10), object);
        }
        return new CompositeGeneratedAdaptersObserver(cVarArr);
    }

    public final c a(Constructor constructor, Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objNewInstance = constructor.newInstance(obj);
            kotlin.jvm.internal.h.e(objNewInstance, "{\n            constructo\u2026tance(`object`)\n        }");
            return (c) objNewInstance;
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Constructor b(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            Package r02 = cls.getPackage();
            String name = cls.getCanonicalName();
            String fullPackage = r02 != null ? r02.getName() : "";
            kotlin.jvm.internal.h.e(fullPackage, "fullPackage");
            if (fullPackage.length() != 0) {
                kotlin.jvm.internal.h.e(name, "name");
                name = name.substring(fullPackage.length() + 1);
                kotlin.jvm.internal.h.e(name, "this as java.lang.String).substring(startIndex)");
            }
            kotlin.jvm.internal.h.e(name, "if (fullPackage.isEmpty(\u2026g(fullPackage.length + 1)");
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

    public final int d(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Map map = f1055b;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        map.put(cls, Integer.valueOf(iG));
        return iG;
    }

    public final boolean e(Class cls) {
        return cls != null && g.class.isAssignableFrom(cls);
    }

    public final int g(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructorB = b(cls);
        if (constructorB != null) {
            f1056c.put(cls, k7.k.b(constructorB));
            return 2;
        }
        if (b.f1035c.d(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (e(superclass)) {
            kotlin.jvm.internal.h.e(superclass, "superclass");
            if (d(superclass) == 1) {
                return 1;
            }
            Object obj = f1056c.get(superclass);
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
                Object obj2 = f1056c.get(intrface);
                kotlin.jvm.internal.h.c(obj2);
                arrayList.addAll((Collection) obj2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f1056c.put(cls, arrayList);
        return 2;
    }
}
