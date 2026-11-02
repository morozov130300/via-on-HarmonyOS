package autodispose2.androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.n;
import t0.d;
import x6.j;
import x6.m;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class LifecycleEventsObservable extends j {

    /* renamed from: e, reason: collision with root package name */
    public final Lifecycle f1737e;

    /* renamed from: j, reason: collision with root package name */
    public final h7.a f1738j = h7.a.O();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class AutoDisposeLifecycleObserver extends d implements g {

        /* renamed from: j, reason: collision with root package name */
        public final Lifecycle f1739j;

        /* renamed from: k, reason: collision with root package name */
        public final m f1740k;

        /* renamed from: l, reason: collision with root package name */
        public final h7.a f1741l;

        public AutoDisposeLifecycleObserver(Lifecycle lifecycle, m mVar, h7.a aVar) {
            this.f1739j = lifecycle;
            this.f1740k = mVar;
            this.f1741l = aVar;
        }

        @Override // t0.d
        public void b() {
            this.f1739j.c(this);
        }

        @n(Lifecycle.Event.ON_ANY)
        public void onStateChange(h hVar, Lifecycle.Event event) {
            if (isDisposed()) {
                return;
            }
            if (event != Lifecycle.Event.ON_CREATE || this.f1741l.Q() != event) {
                this.f1741l.onNext(event);
            }
            this.f1740k.onNext(event);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1742a;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            f1742a = iArr;
            try {
                iArr[Lifecycle.State.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1742a[Lifecycle.State.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1742a[Lifecycle.State.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1742a[Lifecycle.State.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1742a[Lifecycle.State.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public LifecycleEventsObservable(Lifecycle lifecycle) {
        this.f1737e = lifecycle;
    }

    @Override // x6.j
    public void C(m mVar) {
        AutoDisposeLifecycleObserver autoDisposeLifecycleObserver = new AutoDisposeLifecycleObserver(this.f1737e, mVar, this.f1738j);
        mVar.onSubscribe(autoDisposeLifecycleObserver);
        if (!t0.b.b()) {
            mVar.onError(new IllegalStateException("Lifecycles can only be bound to on the main thread!"));
            return;
        }
        this.f1737e.a(autoDisposeLifecycleObserver);
        if (autoDisposeLifecycleObserver.isDisposed()) {
            this.f1737e.c(autoDisposeLifecycleObserver);
        }
    }

    public void N() {
        int i10 = a.f1742a[this.f1737e.b().ordinal()];
        this.f1738j.onNext(i10 != 1 ? i10 != 2 ? (i10 == 3 || i10 == 4) ? Lifecycle.Event.ON_RESUME : Lifecycle.Event.ON_DESTROY : Lifecycle.Event.ON_START : Lifecycle.Event.ON_CREATE);
    }

    public Lifecycle.Event O() {
        return (Lifecycle.Event) this.f1738j.Q();
    }
}
