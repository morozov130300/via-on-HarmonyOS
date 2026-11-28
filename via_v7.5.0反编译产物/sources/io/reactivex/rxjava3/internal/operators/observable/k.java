package io.reactivex.rxjava3.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k extends r6.j implements x6.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6568c;

    public k(Object obj) {
        this.f6568c = obj;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(oVar, this.f6568c);
        oVar.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }

    @Override // x6.c, u6.j
    public Object get() {
        return this.f6568c;
    }
}
