package autodispose2.androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.j;
import autodispose2.lifecycle.LifecycleEndedException;
import r6.c;
import v0.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b implements v0.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v0.a f1643c = new v0.a() { // from class: autodispose2.androidx.lifecycle.a
        @Override // v0.a, u6.g
        public final Object apply(Object obj) {
            return b.e((Lifecycle.Event) obj);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0.a f1644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleEventsObservable f1645b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1646a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f1646a = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1646a[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1646a[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1646a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1646a[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1646a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: renamed from: autodispose2.androidx.lifecycle.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class C0027b implements v0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle.Event f1647a;

        public C0027b(Lifecycle.Event event) {
            this.f1647a = event;
        }

        @Override // v0.a, u6.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Lifecycle.Event apply(Lifecycle.Event event) {
            return this.f1647a;
        }
    }

    public b(Lifecycle lifecycle, v0.a aVar) {
        this.f1645b = new LifecycleEventsObservable(lifecycle);
        this.f1644a = aVar;
    }

    public static /* synthetic */ Lifecycle.Event e(Lifecycle.Event event) {
        int i10 = a.f1646a[event.ordinal()];
        if (i10 == 1) {
            return Lifecycle.Event.ON_DESTROY;
        }
        if (i10 == 2) {
            return Lifecycle.Event.ON_STOP;
        }
        if (i10 == 3) {
            return Lifecycle.Event.ON_PAUSE;
        }
        if (i10 == 4) {
            return Lifecycle.Event.ON_STOP;
        }
        throw new LifecycleEndedException("Lifecycle has ended! Last event was " + event);
    }

    public static b f(Lifecycle lifecycle) {
        return h(lifecycle, f1643c);
    }

    public static b g(Lifecycle lifecycle, Lifecycle.Event event) {
        return h(lifecycle, new C0027b(event));
    }

    public static b h(Lifecycle lifecycle, v0.a aVar) {
        return new b(lifecycle, aVar);
    }

    public static b i(j jVar) {
        return f(jVar.h0());
    }

    public static b j(j jVar, Lifecycle.Event event) {
        return g(jVar.h0(), event);
    }

    @Override // v0.b
    public r6.j b() {
        return this.f1645b;
    }

    @Override // v0.b
    public v0.a c() {
        return this.f1644a;
    }

    @Override // autodispose2.o
    public c d() {
        return f.e(this);
    }

    @Override // v0.b
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Lifecycle.Event a() {
        this.f1645b.Q();
        return this.f1645b.R();
    }
}
