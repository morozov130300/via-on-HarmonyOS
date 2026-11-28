package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class MaybeCallbackObserver<T> extends AtomicReference<s6.b> implements r6.h, s6.b {
    private static final long serialVersionUID = -6076952298809384986L;
    final u6.a onComplete;
    final u6.f onError;
    final u6.f onSuccess;

    public MaybeCallbackObserver(u6.f fVar, u6.f fVar2, u6.a aVar) {
        this.onSuccess = fVar;
        this.onError = fVar2;
        this.onComplete = aVar;
    }

    @Override // s6.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != w6.a.f13679f;
    }

    @Override // s6.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // r6.h
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            t6.a.b(th);
            z6.a.o(th);
        }
    }

    @Override // r6.h
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            t6.a.b(th2);
            z6.a.o(new CompositeException(th, th2));
        }
    }

    @Override // r6.h
    public void onSubscribe(s6.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // r6.h
    public void onSuccess(T t10) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t10);
        } catch (Throwable th) {
            t6.a.b(th);
            z6.a.o(th);
        }
    }
}
