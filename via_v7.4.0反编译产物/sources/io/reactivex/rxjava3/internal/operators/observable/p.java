package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Collection;
import x6.q;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class p extends x6.o {

    /* renamed from: a, reason: collision with root package name */
    public final x6.l f7352a;

    /* renamed from: b, reason: collision with root package name */
    public final a7.i f7353b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements x6.m, y6.b {

        /* renamed from: e, reason: collision with root package name */
        public final q f7354e;

        /* renamed from: j, reason: collision with root package name */
        public Collection f7355j;

        /* renamed from: k, reason: collision with root package name */
        public y6.b f7356k;

        public a(q qVar, Collection collection) {
            this.f7354e = qVar;
            this.f7355j = collection;
        }

        @Override // y6.b
        public void dispose() {
            this.f7356k.dispose();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7356k.isDisposed();
        }

        @Override // x6.m
        public void onComplete() {
            Collection collection = this.f7355j;
            this.f7355j = null;
            this.f7354e.onSuccess(collection);
        }

        @Override // x6.m
        public void onError(Throwable th) {
            this.f7355j = null;
            this.f7354e.onError(th);
        }

        @Override // x6.m
        public void onNext(Object obj) {
            this.f7355j.add(obj);
        }

        @Override // x6.m
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.validate(this.f7356k, bVar)) {
                this.f7356k = bVar;
                this.f7354e.onSubscribe(this);
            }
        }
    }

    public p(x6.l lVar, int i10) {
        this.f7352a = lVar;
        this.f7353b = c7.a.a(i10);
    }

    @Override // x6.o
    public void k(q qVar) {
        try {
            this.f7352a.b(new a(qVar, (Collection) ExceptionHelper.c(this.f7353b.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            z6.a.b(th);
            EmptyDisposable.error(th, qVar);
        }
    }
}
