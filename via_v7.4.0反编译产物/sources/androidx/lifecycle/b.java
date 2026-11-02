package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static b f1035c = new b();

    /* renamed from: a, reason: collision with root package name */
    public final Map f1036a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map f1037b = new HashMap();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Map f1038a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final Map f1039b;

        public a(Map map) {
            this.f1039b = map;
            for (Map.Entry entry : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) entry.getValue();
                List arrayList = (List) this.f1038a.get(event);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f1038a.put(event, arrayList);
                }
                arrayList.add((C0014b) entry.getKey());
            }
        }

        public static void b(List list, h hVar, Lifecycle.Event event, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((C0014b) list.get(size)).a(hVar, event, obj);
                }
            }
        }

        public void a(h hVar, Lifecycle.Event event, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            b((List) this.f1038a.get(event), hVar, event, obj);
            b((List) this.f1038a.get(Lifecycle.Event.ON_ANY), hVar, event, obj);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    public static final class C0014b {

        /* renamed from: a, reason: collision with root package name */
        public final int f1040a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f1041b;

        public C0014b(int i10, Method method) {
            this.f1040a = i10;
            this.f1041b = method;
            method.setAccessible(true);
        }

        public void a(h hVar, Lifecycle.Event event, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                int i10 = this.f1040a;
                if (i10 == 0) {
                    this.f1041b.invoke(obj, null);
                } else if (i10 == 1) {
                    this.f1041b.invoke(obj, hVar);
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    this.f1041b.invoke(obj, hVar, event);
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
            if (!(obj instanceof C0014b)) {
                return false;
            }
            C0014b c0014b = (C0014b) obj;
            return this.f1040a == c0014b.f1040a && this.f1041b.getName().equals(c0014b.f1041b.getName());
        }

        public int hashCode() {
            return (this.f1040a * 31) + this.f1041b.getName().hashCode();
        }
    }

    public final a a(Class cls, Method[] methodArr) {
        int i10;
        a aVarC;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f1039b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f1039b.entrySet()) {
                e(map, (C0014b) entry.getKey(), (Lifecycle.Event) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            n nVar = (n) method.getAnnotation(n.class);
            if (nVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i10 = 0;
                } else {
                    if (!h.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i10 = 1;
                }
                Lifecycle.Event eventValue = nVar.value();
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
                e(map, new C0014b(i10, method), eventValue, cls);
                z10 = true;
            }
        }
        a aVar = new a(map);
        this.f1036a.put(cls, aVar);
        this.f1037b.put(cls, Boolean.valueOf(z10));
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
        a aVar = (a) this.f1036a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public boolean d(Class cls) {
        Boolean bool = (Boolean) this.f1037b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((n) method.getAnnotation(n.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f1037b.put(cls, Boolean.FALSE);
        return false;
    }

    public final void e(Map map, C0014b c0014b, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = (Lifecycle.Event) map.get(c0014b);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(c0014b, event);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0014b.f1041b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }
}
