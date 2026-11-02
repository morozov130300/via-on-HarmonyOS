package io.reactivex.rxjava3.internal.observers;

import a7.e;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import x6.m;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class LambdaObserver<T> extends AtomicReference<y6.b> implements m, y6.b {
    private static final long serialVersionUID = -7251123623727029452L;
    final a7.a onComplete;
    final e onError;
    final e onNext;
    final e onSubscribe;

    public LambdaObserver(e eVar, e eVar2, a7.a aVar, e eVar3) {
        this.onNext = eVar;
        this.onError = eVar2;
        this.onComplete = aVar;
        this.onSubscribe = eVar3;
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

    @Override // x6.m
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            z6.a.b(th);
            f7.a.o(th);
        }
    }

    @Override // x6.m
    public void onError(Throwable th) {
        if (isDisposed()) {
            f7.a.o(th);
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            z6.a.b(th2);
            f7.a.o(new CompositeException(th, th2));
        }
    }

    @Override // x6.m
    public void onNext(T t10) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t10);
        } catch (Throwable th) {
            z6.a.b(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // x6.m
    public void onSubscribe(y6.b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                z6.a.b(th);
                bVar.dispose();
                onError(th);
            }
        }
    }
}
