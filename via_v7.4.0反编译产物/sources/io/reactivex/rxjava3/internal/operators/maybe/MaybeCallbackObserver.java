package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class MaybeCallbackObserver<T> extends AtomicReference<y6.b> implements x6.h, y6.b {
    private static final long serialVersionUID = -6076952298809384986L;
    final a7.a onComplete;
    final a7.e onError;
    final a7.e onSuccess;

    public MaybeCallbackObserver(a7.e eVar, a7.e eVar2, a7.a aVar) {
        this.onSuccess = eVar;
        this.onError = eVar2;
        this.onComplete = aVar;
    }

    @Override // y6.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != c7.a.f2313f;
    }

    @Override // y6.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // x6.h
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            z6.a.b(th);
            f7.a.o(th);
        }
    }

    @Override // x6.h
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            z6.a.b(th2);
            f7.a.o(new CompositeException(th, th2));
        }
    }

    @Override // x6.h
    public void onSubscribe(y6.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // x6.h
    public void onSuccess(T t10) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t10);
        } catch (Throwable th) {
            z6.a.b(th);
            f7.a.o(th);
        }
    }
}
