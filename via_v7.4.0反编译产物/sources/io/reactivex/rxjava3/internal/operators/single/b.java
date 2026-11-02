package io.reactivex.rxjava3.internal.operators.single;

import java.util.Objects;
import java.util.concurrent.Callable;
import x6.o;
import x6.q;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends o {

    /* renamed from: a, reason: collision with root package name */
    public final Callable f7367a;

    public b(Callable callable) {
        this.f7367a = callable;
    }

    @Override // x6.o
    public void k(q qVar) {
        y6.b bVarB = io.reactivex.rxjava3.disposables.a.b();
        qVar.onSubscribe(bVarB);
        if (bVarB.isDisposed()) {
            return;
        }
        try {
            Object objCall = this.f7367a.call();
            Objects.requireNonNull(objCall, "The callable returned a null value");
            if (bVarB.isDisposed()) {
                return;
            }
            qVar.onSuccess(objCall);
        } catch (Throwable th) {
            z6.a.b(th);
            if (bVarB.isDisposed()) {
                f7.a.o(th);
            } else {
                qVar.onError(th);
            }
        }
    }
}
