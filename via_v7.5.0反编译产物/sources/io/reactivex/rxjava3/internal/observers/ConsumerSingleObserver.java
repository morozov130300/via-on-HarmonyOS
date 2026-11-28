package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import r6.s;
import u6.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ConsumerSingleObserver<T> extends AtomicReference<s6.b> implements s, s6.b {
    private static final long serialVersionUID = -7012088219455310787L;
    final f onError;
    final f onSuccess;

    public ConsumerSingleObserver(f fVar, f fVar2) {
        this.onSuccess = fVar;
        this.onError = fVar2;
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
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // r6.s
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            t6.a.b(th2);
            z6.a.o(new CompositeException(th, th2));
        }
    }

    @Override // r6.s
    public void onSubscribe(s6.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // r6.s
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
