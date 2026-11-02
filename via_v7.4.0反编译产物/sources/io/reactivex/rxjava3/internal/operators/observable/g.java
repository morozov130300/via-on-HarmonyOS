package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g extends x6.j implements a7.i {

    /* renamed from: e, reason: collision with root package name */
    public final Callable f7322e;

    public g(Callable callable) {
        this.f7322e = callable;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(mVar);
        mVar.onSubscribe(deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            deferredScalarDisposable.complete(ExceptionHelper.c(this.f7322e.call(), "Callable returned a null value."));
        } catch (Throwable th) {
            z6.a.b(th);
            if (deferredScalarDisposable.isDisposed()) {
                f7.a.o(th);
            } else {
                mVar.onError(th);
            }
        }
    }

    @Override // a7.i
    public Object get() {
        return ExceptionHelper.c(this.f7322e.call(), "The Callable returned a null value.");
    }
}
