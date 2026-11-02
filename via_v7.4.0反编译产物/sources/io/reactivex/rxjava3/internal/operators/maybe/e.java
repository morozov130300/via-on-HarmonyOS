package io.reactivex.rxjava3.internal.operators.maybe;

import a7.i;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e extends x6.f implements i {

    /* renamed from: e, reason: collision with root package name */
    public final Callable f7243e;

    public e(Callable callable) {
        this.f7243e = callable;
    }

    @Override // a7.i
    public Object get() {
        return this.f7243e.call();
    }

    @Override // x6.f
    public void m(x6.h hVar) {
        y6.b bVarB = io.reactivex.rxjava3.disposables.a.b();
        hVar.onSubscribe(bVarB);
        if (bVarB.isDisposed()) {
            return;
        }
        try {
            Object objCall = this.f7243e.call();
            if (bVarB.isDisposed()) {
                return;
            }
            if (objCall == null) {
                hVar.onComplete();
            } else {
                hVar.onSuccess(objCall);
            }
        } catch (Throwable th) {
            z6.a.b(th);
            if (bVarB.isDisposed()) {
                f7.a.o(th);
            } else {
                hVar.onError(th);
            }
        }
    }
}
