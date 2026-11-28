package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import r6.o;
import u6.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class LambdaObserver<T> extends AtomicReference<s6.b> implements o, s6.b {
    private static final long serialVersionUID = -7251123623727029452L;
    final u6.a onComplete;
    final f onError;
    final f onNext;
    final f onSubscribe;

    public LambdaObserver(f fVar, f fVar2, u6.a aVar, f fVar3) {
        this.onNext = fVar;
        this.onError = fVar2;
        this.onComplete = aVar;
        this.onSubscribe = fVar3;
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

    @Override // r6.o
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            t6.a.b(th);
            z6.a.o(th);
        }
    }

    @Override // r6.o
    public void onError(Throwable th) {
        if (isDisposed()) {
            z6.a.o(th);
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            t6.a.b(th2);
            z6.a.o(new CompositeException(th, th2));
        }
    }

    @Override // r6.o
    public void onNext(T t10) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t10);
        } catch (Throwable th) {
            t6.a.b(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // r6.o
    public void onSubscribe(s6.b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                t6.a.b(th);
                bVar.dispose();
                onError(th);
            }
        }
    }
}
