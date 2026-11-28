package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import u6.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class CallbackCompletableObserver extends AtomicReference<s6.b> implements r6.b, s6.b, f {
    private static final long serialVersionUID = -4361286194466301354L;
    final u6.a onComplete;
    final f onError;

    public CallbackCompletableObserver(u6.a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    @Override // s6.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != this;
    }

    @Override // s6.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // r6.b
    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            t6.a.b(th);
            z6.a.o(th);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // r6.b
    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            t6.a.b(th2);
            z6.a.o(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // r6.b
    public void onSubscribe(s6.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // u6.f
    public void accept(Throwable th) {
        z6.a.o(new OnErrorNotImplementedException(th));
    }

    public CallbackCompletableObserver(f fVar, u6.a aVar) {
        this.onError = fVar;
        this.onComplete = aVar;
    }
}
