package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i0.a f940c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        z a(Class cls);

        z b(Class cls, i0.a aVar);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c implements b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static c f947b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f946a = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i0.a.b f948c = a.C0015a.f949a;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static final class a {

            /* JADX INFO: renamed from: androidx.lifecycle.a0$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
            public static final class C0015a implements i0.a.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0015a f949a = new C0015a();
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final c a() {
                if (c.f947b == null) {
                    c.f947b = new c();
                }
                c cVar = c.f947b;
                kotlin.jvm.internal.h.c(cVar);
                return cVar;
            }

            public a() {
            }
        }

        @Override // androidx.lifecycle.a0.b
        public z a(Class modelClass) throws InvocationTargetException {
            kotlin.jvm.internal.h.f(modelClass, "modelClass");
            try {
                Object objNewInstance = modelClass.getDeclaredConstructor(null).newInstance(null);
                kotlin.jvm.internal.h.e(objNewInstance, "{\n                modelC…wInstance()\n            }");
                return (z) objNewInstance;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e11);
            } catch (NoSuchMethodException e12) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e12);
            }
        }

        @Override // androidx.lifecycle.a0.b
        public /* synthetic */ z b(Class cls, i0.a aVar) {
            return b0.b(this, cls, aVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class d {
        public abstract void c(z zVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a0(d0 store, b factory) {
        this(store, factory, null, 4, null);
        kotlin.jvm.internal.h.f(store, "store");
        kotlin.jvm.internal.h.f(factory, "factory");
    }

    public z a(Class modelClass) {
        kotlin.jvm.internal.h.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
    }

    public z b(String key, Class modelClass) {
        z zVarA;
        kotlin.jvm.internal.h.f(key, "key");
        kotlin.jvm.internal.h.f(modelClass, "modelClass");
        z zVarB = this.f938a.b(key);
        if (!modelClass.isInstance(zVarB)) {
            i0.d dVar = new i0.d(this.f940c);
            dVar.c(c.f948c, key);
            try {
                zVarA = this.f939b.b(modelClass, dVar);
            } catch (AbstractMethodError unused) {
                zVarA = this.f939b.a(modelClass);
            }
            this.f938a.d(key, zVarA);
            return zVarA;
        }
        Object obj = this.f939b;
        d dVar2 = obj instanceof d ? (d) obj : null;
        if (dVar2 != null) {
            kotlin.jvm.internal.h.c(zVarB);
            dVar2.c(zVarB);
        }
        kotlin.jvm.internal.h.d(zVarB, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return zVarB;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a extends c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static a f942f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Application f944d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final C0013a f941e = new C0013a(null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final i0.a.b f943g = C0013a.C0014a.f945a;

        /* JADX INFO: renamed from: androidx.lifecycle.a0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static final class C0013a {

            /* JADX INFO: renamed from: androidx.lifecycle.a0$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
            public static final class C0014a implements i0.a.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0014a f945a = new C0014a();
            }

            public /* synthetic */ C0013a(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final b a(e0 owner) {
                kotlin.jvm.internal.h.f(owner, "owner");
                return owner instanceof f ? ((f) owner).v() : c.f946a.a();
            }

            public final a b(Application application) {
                kotlin.jvm.internal.h.f(application, "application");
                if (a.f942f == null) {
                    a.f942f = new a(application);
                }
                a aVar = a.f942f;
                kotlin.jvm.internal.h.c(aVar);
                return aVar;
            }

            public C0013a() {
            }
        }

        public a(Application application, int i10) {
            this.f944d = application;
        }

        @Override // androidx.lifecycle.a0.c, androidx.lifecycle.a0.b
        public z a(Class modelClass) {
            kotlin.jvm.internal.h.f(modelClass, "modelClass");
            Application application = this.f944d;
            if (application != null) {
                return g(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.a0.c, androidx.lifecycle.a0.b
        public z b(Class modelClass, i0.a extras) {
            kotlin.jvm.internal.h.f(modelClass, "modelClass");
            kotlin.jvm.internal.h.f(extras, "extras");
            if (this.f944d != null) {
                return a(modelClass);
            }
            Application application = (Application) extras.a(f943g);
            if (application != null) {
                return g(modelClass, application);
            }
            if (androidx.lifecycle.a.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return super.a(modelClass);
        }

        public final z g(Class cls, Application application) {
            if (!androidx.lifecycle.a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                z zVar = (z) cls.getConstructor(Application.class).newInstance(application);
                kotlin.jvm.internal.h.e(zVar, "{\n                try {\n…          }\n            }");
                return zVar;
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

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            kotlin.jvm.internal.h.f(application, "application");
        }
    }

    public a0(d0 store, b factory, i0.a defaultCreationExtras) {
        kotlin.jvm.internal.h.f(store, "store");
        kotlin.jvm.internal.h.f(factory, "factory");
        kotlin.jvm.internal.h.f(defaultCreationExtras, "defaultCreationExtras");
        this.f938a = store;
        this.f939b = factory;
        this.f940c = defaultCreationExtras;
    }

    public /* synthetic */ a0(d0 d0Var, b bVar, i0.a aVar, int i10, kotlin.jvm.internal.f fVar) {
        this(d0Var, bVar, (i10 & 4) != 0 ? i0.a.C0074a.f6187b : aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a0(e0 owner) {
        this(owner.B(), a.f941e.a(owner), c0.a(owner));
        kotlin.jvm.internal.h.f(owner, "owner");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a0(e0 owner, b factory) {
        this(owner.B(), factory, c0.a(owner));
        kotlin.jvm.internal.h.f(owner, "owner");
        kotlin.jvm.internal.h.f(factory, "factory");
    }
}
