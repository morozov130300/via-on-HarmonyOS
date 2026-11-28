package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g extends r6.j implements u6.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable f6555c;

    public g(Callable callable) {
        this.f6555c = callable;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(oVar);
        oVar.onSubscribe(deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            deferredScalarDisposable.complete(ExceptionHelper.c(this.f6555c.call(), "Callable returned a null value."));
        } catch (Throwable th) {
            t6.a.b(th);
            if (deferredScalarDisposable.isDisposed()) {
                z6.a.o(th);
            } else {
                oVar.onError(th);
            }
        }
    }

    @Override // u6.j
    public Object get() {
        return ExceptionHelper.c(this.f6555c.call(), "The Callable returned a null value.");
    }
}
