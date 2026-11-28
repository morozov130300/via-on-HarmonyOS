package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;
import u6.j;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends r6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f6446a;

    public a(j jVar) {
        this.f6446a = jVar;
    }

    @Override // r6.a
    public void g(r6.b bVar) {
        try {
            Object obj = this.f6446a.get();
            Objects.requireNonNull(obj, "The completableSupplier returned a null CompletableSource");
            ((r6.c) obj).a(bVar);
        } catch (Throwable th) {
            t6.a.b(th);
            EmptyDisposable.error(th, bVar);
        }
    }
}
