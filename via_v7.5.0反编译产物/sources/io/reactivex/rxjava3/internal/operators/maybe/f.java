package io.reactivex.rxjava3.internal.operators.maybe;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f extends r6.f implements x6.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6475c;

    public f(Object obj) {
        this.f6475c = obj;
    }

    @Override // x6.c, u6.j
    public Object get() {
        return this.f6475c;
    }

    @Override // r6.f
    public void m(r6.h hVar) {
        hVar.onSubscribe(io.reactivex.rxjava3.disposables.a.a());
        hVar.onSuccess(this.f6475c);
    }
}
