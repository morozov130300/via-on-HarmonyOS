package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f893c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f894e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f895a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f895a = iArr;
        }
    }

    public DefaultLifecycleObserverAdapter(d defaultLifecycleObserver, h hVar) {
        kotlin.jvm.internal.h.f(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f893c = defaultLifecycleObserver;
        this.f894e = hVar;
    }

    @Override // androidx.lifecycle.h
    public void e(j source, Lifecycle.Event event) {
        kotlin.jvm.internal.h.f(source, "source");
        kotlin.jvm.internal.h.f(event, "event");
        switch (a.f895a[event.ordinal()]) {
            case 1:
                this.f893c.c(source);
                break;
            case 2:
                this.f893c.j(source);
                break;
            case 3:
                this.f893c.b(source);
                break;
            case 4:
                this.f893c.f(source);
                break;
            case 5:
                this.f893c.g(source);
                break;
            case 6:
                this.f893c.i(source);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        h hVar = this.f894e;
        if (hVar != null) {
            hVar.e(source, event);
        }
    }
}
