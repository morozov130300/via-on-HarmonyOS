package io.reactivex.rxjava3.internal.operators.completable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d extends x6.a {

    /* renamed from: a, reason: collision with root package name */
    public final a7.a f7218a;

    public d(a7.a aVar) {
        this.f7218a = aVar;
    }

    @Override // x6.a
    public void g(x6.b bVar) {
        y6.b bVarB = io.reactivex.rxjava3.disposables.a.b();
        bVar.onSubscribe(bVarB);
        if (bVarB.isDisposed()) {
            return;
        }
        try {
            this.f7218a.run();
            if (bVarB.isDisposed()) {
                return;
            }
            bVar.onComplete();
        } catch (Throwable th) {
            z6.a.b(th);
            if (bVarB.isDisposed()) {
                f7.a.o(th);
            } else {
                bVar.onError(th);
            }
        }
    }
}
