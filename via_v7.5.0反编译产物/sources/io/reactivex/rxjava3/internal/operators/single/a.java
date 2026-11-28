package io.reactivex.rxjava3.internal.operators.single;

import java.util.Objects;
import java.util.concurrent.Callable;
import r6.q;
import r6.s;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable f6596a;

    public a(Callable callable) {
        this.f6596a = callable;
    }

    @Override // r6.q
    public void j(s sVar) {
        s6.b bVarB = io.reactivex.rxjava3.disposables.a.b();
        sVar.onSubscribe(bVarB);
        if (bVarB.isDisposed()) {
            return;
        }
        try {
            Object objCall = this.f6596a.call();
            Objects.requireNonNull(objCall, "The callable returned a null value");
            if (bVarB.isDisposed()) {
                return;
            }
            sVar.onSuccess(objCall);
        } catch (Throwable th) {
            t6.a.b(th);
            if (bVarB.isDisposed()) {
                z6.a.o(th);
            } else {
                sVar.onError(th);
            }
        }
    }
}
