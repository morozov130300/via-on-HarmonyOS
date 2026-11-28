package io.reactivex.rxjava3.internal.operators.maybe;

import java.util.concurrent.Callable;
import u6.j;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e extends r6.f implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable f6474c;

    public e(Callable callable) {
        this.f6474c = callable;
    }

    @Override // u6.j
    public Object get() {
        return this.f6474c.call();
    }

    @Override // r6.f
    public void m(r6.h hVar) {
        s6.b bVarB = io.reactivex.rxjava3.disposables.a.b();
        hVar.onSubscribe(bVarB);
        if (bVarB.isDisposed()) {
            return;
        }
        try {
            Object objCall = this.f6474c.call();
            if (bVarB.isDisposed()) {
                return;
            }
            if (objCall == null) {
                hVar.onComplete();
            } else {
                hVar.onSuccess(objCall);
            }
        } catch (Throwable th) {
            t6.a.b(th);
            if (bVarB.isDisposed()) {
                z6.a.o(th);
            } else {
                hVar.onError(th);
            }
        }
    }
}
