package androidx.lifecycle;

import android.app.Application;
import h0.a;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f1078a;

    /* renamed from: b, reason: collision with root package name */
    public final b f1079b;

    /* renamed from: c, reason: collision with root package name */
    public final h0.a f1080c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a extends c {

        /* renamed from: f, reason: collision with root package name */
        public static a f1082f;

        /* renamed from: d, reason: collision with root package name */
        public final Application f1084d;

        /* renamed from: e, reason: collision with root package name */
        public static final C0015a f1081e = new C0015a(null);

        /* renamed from: g, reason: collision with root package name */
        public static final a.b f1083g = C0015a.C0016a.f1085a;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: androidx.lifecycle.y$a$a, reason: collision with other inner class name */
        public static final class C0015a {

            /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
            /* renamed from: androidx.lifecycle.y$a$a$a, reason: collision with other inner class name */
            public static final class C0016a implements a.b {

                /* renamed from: a, reason: collision with root package name */
                public static final C0016a f1085a = new C0016a();
            }

            public C0015a() {
            }

            public /* synthetic */ C0015a(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final b a(c0 owner) {
                kotlin.jvm.internal.h.f(owner, "owner");
                return owner instanceof androidx.lifecycle.d ? ((androidx.lifecycle.d) owner).w() : c.f1086a.a();
            }

            public final a b(Application application) {
                kotlin.jvm.internal.h.f(application, "application");
                if (a.f1082f == null) {
                    a.f1082f = new a(application);
                }
                a aVar = a.f1082f;
                kotlin.jvm.internal.h.c(aVar);
                return aVar;
            }
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            kotlin.jvm.internal.h.f(application, "application");
        }

        public a(Application application, int i10) {
            this.f1084d = application;
        }

        @Override // androidx.lifecycle.y.c, androidx.lifecycle.y.b
        public x a(Class modelClass) {
            kotlin.jvm.internal.h.f(modelClass, "modelClass");
            Application application = this.f1084d;
            if (application != null) {
                return g(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.y.c, androidx.lifecycle.y.b
        public x b(Class modelClass, h0.a extras) {
            kotlin.jvm.internal.h.f(modelClass, "modelClass");
            kotlin.jvm.internal.h.f(extras, "extras");
            if (this.f1084d != null) {
                return a(modelClass);
            }
            Application application = (Application) extras.a(f1083g);
            if (application != null) {
                return g(modelClass, application);
            }
            if (androidx.lifecycle.a.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return super.a(modelClass);
        }

        public final x g(Class cls, Application application) {
            if (!androidx.lifecycle.a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                x xVar = (x) cls.getConstructor(Application.class).newInstance(application);
                kotlin.jvm.internal.h.e(xVar, "{\n                try {\n\u2026          }\n            }");
                return xVar;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (NoSuchMethodException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException("Cannot create an instance of " + cls, e13);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        x a(Class cls);

        x b(Class cls, h0.a aVar);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c implements b {

        /* renamed from: b, reason: collision with root package name */
        public static c f1087b;

        /* renamed from: a, reason: collision with root package name */
        public static final a f1086a = new a(null);

        /* renamed from: c, reason: collision with root package name */
        public static final a.b f1088c = a.C0017a.f1089a;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public static final class a {

            /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
            /* renamed from: androidx.lifecycle.y$c$a$a, reason: collision with other inner class name */
            public static final class C0017a implements a.b {

                /* renamed from: a, reason: collision with root package name */
                public static final C0017a f1089a = new C0017a();
            }

            public a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final c a() {
                if (c.f1087b == null) {
                    c.f1087b = new c();
                }
                c cVar = c.f1087b;
                kotlin.jvm.internal.h.c(cVar);
                return cVar;
            }
        }

        @Override // androidx.lifecycle.y.b
        public x a(Class modelClass) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            kotlin.jvm.internal.h.f(modelClass, "modelClass");
            try {
                Object objNewInstance = modelClass.getDeclaredConstructor(null).newInstance(null);
                kotlin.jvm.internal.h.e(objNewInstance, "{\n                modelC\u2026wInstance()\n            }");
                return (x) objNewInstance;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e11);
            } catch (NoSuchMethodException e12) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e12);
            }
        }

        @Override // androidx.lifecycle.y.b
        public /* synthetic */ x b(Class cls, h0.a aVar) {
            return z.b(this, cls, aVar);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class d {
        public abstract void c(x xVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y(b0 store, b factory) {
        this(store, factory, null, 4, null);
        kotlin.jvm.internal.h.f(store, "store");
        kotlin.jvm.internal.h.f(factory, "factory");
    }

    public y(b0 store, b factory, h0.a defaultCreationExtras) {
        kotlin.jvm.internal.h.f(store, "store");
        kotlin.jvm.internal.h.f(factory, "factory");
        kotlin.jvm.internal.h.f(defaultCreationExtras, "defaultCreationExtras");
        this.f1078a = store;
        this.f1079b = factory;
        this.f1080c = defaultCreationExtras;
    }

    public /* synthetic */ y(b0 b0Var, b bVar, h0.a aVar, int i10, kotlin.jvm.internal.f fVar) {
        this(b0Var, bVar, (i10 & 4) != 0 ? a.C0074a.f6318b : aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y(c0 owner) {
        this(owner.D(), a.f1081e.a(owner), a0.a(owner));
        kotlin.jvm.internal.h.f(owner, "owner");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y(c0 owner, b factory) {
        this(owner.D(), factory, a0.a(owner));
        kotlin.jvm.internal.h.f(owner, "owner");
        kotlin.jvm.internal.h.f(factory, "factory");
    }

    public x a(Class modelClass) {
        kotlin.jvm.internal.h.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
    }

    public x b(String key, Class modelClass) {
        x xVarA;
        kotlin.jvm.internal.h.f(key, "key");
        kotlin.jvm.internal.h.f(modelClass, "modelClass");
        x xVarB = this.f1078a.b(key);
        if (!modelClass.isInstance(xVarB)) {
            h0.d dVar = new h0.d(this.f1080c);
            dVar.c(c.f1088c, key);
            try {
                xVarA = this.f1079b.b(modelClass, dVar);
            } catch (AbstractMethodError unused) {
                xVarA = this.f1079b.a(modelClass);
            }
            this.f1078a.d(key, xVarA);
            return xVarA;
        }
        Object obj = this.f1079b;
        d dVar2 = obj instanceof d ? (d) obj : null;
        if (dVar2 != null) {
            kotlin.jvm.internal.h.c(xVarB);
            dVar2.c(xVarB);
        }
        kotlin.jvm.internal.h.d(xVarB, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return xVarB;
    }
}
