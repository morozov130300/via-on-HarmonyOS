package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f950c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f951a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f952b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f953a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f954b;

        public a(Map map) {
            this.f954b = map;
            for (Map.Entry entry : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) entry.getValue();
                List arrayList = (List) this.f953a.get(event);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f953a.put(event, arrayList);
                }
                arrayList.add((C0016b) entry.getKey());
            }
        }

        public static void b(List list, j jVar, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((C0016b) list.get(size)).a(jVar, event, obj);
                }
            }
        }

        public void a(j jVar, Lifecycle.Event event, Object obj) {
            b((List) this.f953a.get(event), jVar, event, obj);
            b((List) this.f953a.get(Lifecycle.Event.ON_ANY), jVar, event, obj);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0016b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f956b;

        public C0016b(int i10, Method method) {
            this.f955a = i10;
            this.f956b = method;
            method.setAccessible(true);
        }

        public void a(j jVar, Lifecycle.Event event, Object obj) {
            try {
                int i10 = this.f955a;
                if (i10 == 0) {
                    this.f956b.invoke(obj, null);
                } else if (i10 == 1) {
                    this.f956b.invoke(obj, jVar);
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    this.f956b.invoke(obj, jVar, event);
                }
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Failed to call observer method", e11.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0016b)) {
                return false;
            }
            C0016b c0016b = (C0016b) obj;
            return this.f955a == c0016b.f955a && this.f956b.getName().equals(c0016b.f956b.getName());
        }

        public int hashCode() {
            return (this.f955a * 31) + this.f956b.getName().hashCode();
        }
    }

    public final a a(Class cls, Method[] methodArr) {
        int i10;
        a aVarC;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f954b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f954b.entrySet()) {
                e(map, (C0016b) entry.getKey(), (Lifecycle.Event) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            p pVar = (p) method.getAnnotation(p.class);
            if (pVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i10 = 0;
                } else {
                    if (!j.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i10 = 1;
                }
                Lifecycle.Event eventValue = pVar.value();
                if (parameterTypes.length > 1) {
                    if (!Lifecycle.Event.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (eventValue != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i10 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new C0016b(i10, method), eventValue, cls);
                z10 = true;
            }
        }
        a aVar = new a(map);
        this.f951a.put(cls, aVar);
        this.f952b.put(cls, Boolean.valueOf(z10));
        return aVar;
    }

    public final Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e10) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
        }
    }

    public a c(Class cls) {
        a aVar = (a) this.f951a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public boolean d(Class cls) {
        Boolean bool = (Boolean) this.f952b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((p) method.getAnnotation(p.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f952b.put(cls, Boolean.FALSE);
        return false;
    }

    public final void e(Map map, C0016b c0016b, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = (Lifecycle.Event) map.get(c0016b);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(c0016b, event);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0016b.f956b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }
}
