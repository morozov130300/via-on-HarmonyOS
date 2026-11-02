package io.reactivex.rxjava3.internal.operators.completable;

import a7.i;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends x6.a {

    /* renamed from: a, reason: collision with root package name */
    public final i f7215a;

    public a(i iVar) {
        this.f7215a = iVar;
    }

    @Override // x6.a
    public void g(x6.b bVar) {
        try {
            Object obj = this.f7215a.get();
            Objects.requireNonNull(obj, "The completableSupplier returned a null CompletableSource");
            ((x6.c) obj).a(bVar);
        } catch (Throwable th) {
            z6.a.b(th);
            EmptyDisposable.error(th, bVar);
        }
    }
}
