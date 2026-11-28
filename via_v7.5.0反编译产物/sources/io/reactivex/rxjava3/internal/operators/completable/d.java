package io.reactivex.rxjava3.internal.operators.completable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d extends r6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u6.a f6449a;

    public d(u6.a aVar) {
        this.f6449a = aVar;
    }

    @Override // r6.a
    public void g(r6.b bVar) {
        s6.b bVarB = io.reactivex.rxjava3.disposables.a.b();
        bVar.onSubscribe(bVarB);
        if (bVarB.isDisposed()) {
            return;
        }
        try {
            this.f6449a.run();
            if (bVarB.isDisposed()) {
                return;
            }
            bVar.onComplete();
        } catch (Throwable th) {
            t6.a.b(th);
            if (bVarB.isDisposed()) {
                z6.a.o(th);
            } else {
                bVar.onError(th);
            }
        }
    }
}
