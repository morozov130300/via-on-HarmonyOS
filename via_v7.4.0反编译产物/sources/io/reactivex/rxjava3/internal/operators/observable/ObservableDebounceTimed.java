package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import x6.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ObservableDebounceTimed extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* renamed from: j, reason: collision with root package name */
    public final long f7259j;

    /* renamed from: k, reason: collision with root package name */
    public final TimeUnit f7260k;

    /* renamed from: l, reason: collision with root package name */
    public final x6.n f7261l;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class DebounceEmitter<T> extends AtomicReference<y6.b> implements Runnable, y6.b {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final a parent;
        final T value;

        public DebounceEmitter(T t10, long j10, a aVar) {
            this.value = t10;
            this.idx = j10;
            this.parent = aVar;
        }

        @Override // y6.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // y6.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.a(this.idx, this.value, this);
            }
        }

        public void setResource(y6.b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements x6.m, y6.b {

        /* renamed from: e, reason: collision with root package name */
        public final x6.m f7262e;

        /* renamed from: j, reason: collision with root package name */
        public final long f7263j;

        /* renamed from: k, reason: collision with root package name */
        public final TimeUnit f7264k;

        /* renamed from: l, reason: collision with root package name */
        public final n.b f7265l;

        /* renamed from: m, reason: collision with root package name */
        public y6.b f7266m;

        /* renamed from: n, reason: collision with root package name */
        public y6.b f7267n;

        /* renamed from: o, reason: collision with root package name */
        public volatile long f7268o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f7269p;

        public a(x6.m mVar, long j10, TimeUnit timeUnit, n.b bVar) {
            this.f7262e = mVar;
            this.f7263j = j10;
            this.f7264k = timeUnit;
            this.f7265l = bVar;
        }

        public void a(long j10, Object obj, DebounceEmitter debounceEmitter) {
            if (j10 == this.f7268o) {
                this.f7262e.onNext(obj);
                debounceEmitter.dispose();
            }
        }

        @Override // y6.b
        public void dispose() {
            this.f7266m.dispose();
            this.f7265l.dispose();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7265l.isDisposed();
        }

        @Override // x6.m
        public void onComplete() {
            if (this.f7269p) {
                return;
            }
            this.f7269p = true;
            y6.b bVar = this.f7267n;
            if (bVar != null) {
                bVar.dispose();
            }
            DebounceEmitter debounceEmitter = (DebounceEmitter) bVar;
            if (debounceEmitter != null) {
                debounceEmitter.run();
            }
            this.f7262e.onComplete();
            this.f7265l.dispose();
        }

        @Override // x6.m
        public void onError(Throwable th) {
            if (this.f7269p) {
                f7.a.o(th);
                return;
            }
            y6.b bVar = this.f7267n;
            if (bVar != null) {
                bVar.dispose();
            }
            this.f7269p = true;
            this.f7262e.onError(th);
            this.f7265l.dispose();
        }

        @Override // x6.m
        public void onNext(Object obj) {
            if (this.f7269p) {
                return;
            }
            long j10 = this.f7268o + 1;
            this.f7268o = j10;
            y6.b bVar = this.f7267n;
            if (bVar != null) {
                bVar.dispose();
            }
            DebounceEmitter debounceEmitter = new DebounceEmitter(obj, j10, this);
            this.f7267n = debounceEmitter;
            debounceEmitter.setResource(this.f7265l.c(debounceEmitter, this.f7263j, this.f7264k));
        }

        @Override // x6.m
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.validate(this.f7266m, bVar)) {
                this.f7266m = bVar;
                this.f7262e.onSubscribe(this);
            }
        }
    }

    public ObservableDebounceTimed(x6.l lVar, long j10, TimeUnit timeUnit, x6.n nVar) {
        super(lVar);
        this.f7259j = j10;
        this.f7260k = timeUnit;
        this.f7261l = nVar;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        this.f7295e.b(new a(new e7.b(mVar), this.f7259j, this.f7260k, this.f7261l.c()));
    }
}
