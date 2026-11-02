package io.reactivex.rxjava3.internal.observers;

import a7.e;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import x6.q;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ConsumerSingleObserver<T> extends AtomicReference<y6.b> implements q, y6.b {
    private static final long serialVersionUID = -7012088219455310787L;
    final e onError;
    final e onSuccess;

    public ConsumerSingleObserver(e eVar, e eVar2) {
        this.onSuccess = eVar;
        this.onError = eVar2;
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
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // x6.q
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            z6.a.b(th2);
            f7.a.o(new CompositeException(th, th2));
        }
    }

    @Override // x6.q
    public void onSubscribe(y6.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // x6.q
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
