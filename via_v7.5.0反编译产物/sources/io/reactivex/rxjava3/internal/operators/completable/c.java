package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c extends r6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f6448a;

    public c(Throwable th) {
        this.f6448a = th;
    }

    @Override // r6.a
    public void g(r6.b bVar) {
        EmptyDisposable.error(this.f6448a, bVar);
    }
}
