package autodispose2.androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i;
import androidx.lifecycle.p;
import r6.j;
import r6.o;
import u0.d;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class LifecycleEventsObservable extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lifecycle f1636c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b7.a f1637e = b7.a.R();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class AutoDisposeLifecycleObserver extends d implements i {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Lifecycle f1638e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final o f1639m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final b7.a f1640n;

        public AutoDisposeLifecycleObserver(Lifecycle lifecycle, o oVar, b7.a aVar) {
            this.f1638e = lifecycle;
            this.f1639m = oVar;
            this.f1640n = aVar;
        }

        @Override // u0.d
        public void a() {
            this.f1638e.c(this);
        }

        @p(Lifecycle.Event.ON_ANY)
        public void onStateChange(androidx.lifecycle.j jVar, Lifecycle.Event event) {
            if (isDisposed()) {
                return;
            }
            if (event != Lifecycle.Event.ON_CREATE || this.f1640n.T() != event) {
                this.f1640n.onNext(event);
            }
            this.f1639m.onNext(event);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1641a;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            f1641a = iArr;
            try {
                iArr[Lifecycle.State.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1641a[Lifecycle.State.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1641a[Lifecycle.State.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1641a[Lifecycle.State.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1641a[Lifecycle.State.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public LifecycleEventsObservable(Lifecycle lifecycle) {
        this.f1636c = lifecycle;
    }

    @Override // r6.j
    public void F(o oVar) {
        AutoDisposeLifecycleObserver autoDisposeLifecycleObserver = new AutoDisposeLifecycleObserver(this.f1636c, oVar, this.f1637e);
        oVar.onSubscribe(autoDisposeLifecycleObserver);
        if (!u0.b.b()) {
            oVar.onError(new IllegalStateException("Lifecycles can only be bound to on the main thread!"));
            return;
        }
        this.f1636c.a(autoDisposeLifecycleObserver);
        if (autoDisposeLifecycleObserver.isDisposed()) {
            this.f1636c.c(autoDisposeLifecycleObserver);
        }
    }

    public void Q() {
        Lifecycle.Event event;
        int i10 = a.f1641a[this.f1636c.b().ordinal()];
        if (i10 == 1) {
            event = Lifecycle.Event.ON_CREATE;
        } else if (i10 != 2) {
            event = (i10 == 3 || i10 == 4) ? Lifecycle.Event.ON_RESUME : Lifecycle.Event.ON_DESTROY;
        } else {
            event = Lifecycle.Event.ON_START;
        }
        this.f1637e.onNext(event);
    }

    public Lifecycle.Event R() {
        return (Lifecycle.Event) this.f1637e.T();
    }
}
