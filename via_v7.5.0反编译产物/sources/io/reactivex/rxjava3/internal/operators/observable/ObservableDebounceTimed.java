package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ObservableDebounceTimed extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6491e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TimeUnit f6492m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final r6.p f6493n;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class DebounceEmitter<T> extends AtomicReference<s6.b> implements Runnable, s6.b {
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

        @Override // s6.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // s6.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.a(this.idx, this.value, this);
            }
        }

        public void setResource(s6.b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements r6.o, s6.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r6.o f6494c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f6495e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final TimeUnit f6496m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final r6.p.c f6497n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public s6.b f6498o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public s6.b f6499p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public volatile long f6500q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f6501r;

        public a(r6.o oVar, long j10, TimeUnit timeUnit, r6.p.c cVar) {
            this.f6494c = oVar;
            this.f6495e = j10;
            this.f6496m = timeUnit;
            this.f6497n = cVar;
        }

        public void a(long j10, Object obj, DebounceEmitter debounceEmitter) {
            if (j10 == this.f6500q) {
                this.f6494c.onNext(obj);
                debounceEmitter.dispose();
            }
        }

        @Override // s6.b
        public void dispose() {
            this.f6498o.dispose();
            this.f6497n.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6497n.isDisposed();
        }

        @Override // r6.o
        public void onComplete() {
            if (this.f6501r) {
                return;
            }
            this.f6501r = true;
            s6.b bVar = this.f6499p;
            if (bVar != null) {
                bVar.dispose();
            }
            DebounceEmitter debounceEmitter = (DebounceEmitter) bVar;
            if (debounceEmitter != null) {
                debounceEmitter.run();
            }
            this.f6494c.onComplete();
            this.f6497n.dispose();
        }

        @Override // r6.o
        public void onError(Throwable th) {
            if (this.f6501r) {
                z6.a.o(th);
                return;
            }
            s6.b bVar = this.f6499p;
            if (bVar != null) {
                bVar.dispose();
            }
            this.f6501r = true;
            this.f6494c.onError(th);
            this.f6497n.dispose();
        }

        @Override // r6.o
        public void onNext(Object obj) {
            if (this.f6501r) {
                return;
            }
            long j10 = this.f6500q + 1;
            this.f6500q = j10;
            s6.b bVar = this.f6499p;
            if (bVar != null) {
                bVar.dispose();
            }
            DebounceEmitter debounceEmitter = new DebounceEmitter(obj, j10, this);
            this.f6499p = debounceEmitter;
            debounceEmitter.setResource(this.f6497n.c(debounceEmitter, this.f6495e, this.f6496m));
        }

        @Override // r6.o
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.f6498o, bVar)) {
                this.f6498o = bVar;
                this.f6494c.onSubscribe(this);
            }
        }
    }

    public ObservableDebounceTimed(r6.n nVar, long j10, TimeUnit timeUnit, r6.p pVar) {
        super(nVar);
        this.f6491e = j10;
        this.f6492m = timeUnit;
        this.f6493n = pVar;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        this.f6528c.c(new a(new y6.b(oVar), this.f6491e, this.f6492m, this.f6493n.c()));
    }
}
