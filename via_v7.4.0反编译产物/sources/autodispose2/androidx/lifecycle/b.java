package autodispose2.androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.h;
import autodispose2.lifecycle.LifecycleEndedException;
import u0.f;
import x6.c;
import x6.j;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b implements u0.b {

    /* renamed from: c, reason: collision with root package name */
    public static final u0.a f1744c = new u0.a() { // from class: autodispose2.androidx.lifecycle.a
        @Override // u0.a, a7.f
        public final Object apply(Object obj) {
            return b.e((Lifecycle.Event) obj);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final u0.a f1745a;

    /* renamed from: b, reason: collision with root package name */
    public final LifecycleEventsObservable f1746b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1747a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f1747a = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1747a[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1747a[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1747a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1747a[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1747a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: autodispose2.androidx.lifecycle.b$b, reason: collision with other inner class name */
    public static class C0028b implements u0.a {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle.Event f1748a;

        public C0028b(Lifecycle.Event event) {
            this.f1748a = event;
        }

        @Override // u0.a, a7.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Lifecycle.Event apply(Lifecycle.Event event) {
            return this.f1748a;
        }
    }

    public b(Lifecycle lifecycle, u0.a aVar) {
        this.f1746b = new LifecycleEventsObservable(lifecycle);
        this.f1745a = aVar;
    }

    public static /* synthetic */ Lifecycle.Event e(Lifecycle.Event event) {
        int i10 = a.f1747a[event.ordinal()];
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
        return h(lifecycle, f1744c);
    }

    public static b g(Lifecycle lifecycle, Lifecycle.Event event) {
        return h(lifecycle, new C0028b(event));
    }

    public static b h(Lifecycle lifecycle, u0.a aVar) {
        return new b(lifecycle, aVar);
    }

    public static b i(h hVar) {
        return f(hVar.k0());
    }

    public static b j(h hVar, Lifecycle.Event event) {
        return g(hVar.k0(), event);
    }

    @Override // u0.b
    public j b() {
        return this.f1746b;
    }

    @Override // u0.b
    public u0.a c() {
        return this.f1745a;
    }

    @Override // autodispose2.o
    public c d() {
        return f.c(this);
    }

    @Override // u0.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Lifecycle.Event a() {
        this.f1746b.N();
        return this.f1746b.O();
    }
}
