package io.reactivex.rxjava3.internal.observers;

import a7.e;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class CallbackCompletableObserver extends AtomicReference<y6.b> implements x6.b, y6.b, e {
    private static final long serialVersionUID = -4361286194466301354L;
    final a7.a onComplete;
    final e onError;

    public CallbackCompletableObserver(a7.a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    public CallbackCompletableObserver(e eVar, a7.a aVar) {
        this.onError = eVar;
        this.onComplete = aVar;
    }

    @Override // a7.e
    public void accept(Throwable th) {
        f7.a.o(new OnErrorNotImplementedException(th));
    }

    @Override // y6.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != this;
    }

    @Override // y6.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // x6.b
    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            z6.a.b(th);
            f7.a.o(th);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // x6.b
    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            z6.a.b(th2);
            f7.a.o(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // x6.b
    public void onSubscribe(y6.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
