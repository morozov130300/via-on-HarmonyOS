package autodispose2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
final class AutoDisposingObserverImpl<T> extends AtomicInteger implements r6.o, s6.b {
    private final r6.o delegate;
    private final r6.c scope;
    final AtomicReference<s6.b> mainDisposable = new AtomicReference<>();
    final AtomicReference<s6.b> scopeDisposable = new AtomicReference<>();
    private final AtomicThrowable error = new AtomicThrowable();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends y6.a {
        public a() {
        }

        @Override // r6.b
        public void onComplete() {
            AutoDisposingObserverImpl.this.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.dispose(AutoDisposingObserverImpl.this.mainDisposable);
        }

        @Override // r6.b
        public void onError(Throwable th) {
            AutoDisposingObserverImpl.this.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposingObserverImpl.this.onError(th);
        }
    }

    public AutoDisposingObserverImpl(r6.c cVar, r6.o oVar) {
        this.scope = cVar;
        this.delegate = oVar;
    }

    public r6.o delegateObserver() {
        return this.delegate;
    }

    @Override // s6.b
    public void dispose() {
        AutoDisposableHelper.dispose(this.scopeDisposable);
        AutoDisposableHelper.dispose(this.mainDisposable);
    }

    @Override // s6.b
    public boolean isDisposed() {
        return this.mainDisposable.get() == AutoDisposableHelper.DISPOSED;
    }

    @Override // r6.o
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        this.mainDisposable.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        l.a(this.delegate, this, this.error);
    }

    @Override // r6.o
    public void onError(Throwable th) {
        if (isDisposed()) {
            return;
        }
        this.mainDisposable.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        l.b(this.delegate, th, this, this.error);
    }

    @Override // r6.o
    public void onNext(T t10) {
        if (isDisposed() || !l.c(this.delegate, t10, this, this.error)) {
            return;
        }
        this.mainDisposable.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
    }

    @Override // r6.o
    public void onSubscribe(s6.b bVar) {
        a aVar = new a();
        if (d.c(this.scopeDisposable, aVar, AutoDisposingObserverImpl.class)) {
            this.delegate.onSubscribe(this);
            this.scope.a(aVar);
            d.c(this.mainDisposable, bVar, AutoDisposingObserverImpl.class);
        }
    }
}
