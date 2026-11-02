package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c extends x6.a {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f7217a;

    public c(Throwable th) {
        this.f7217a = th;
    }

    @Override // x6.a
    public void g(x6.b bVar) {
        EmptyDisposable.error(this.f7217a, bVar);
    }
}
