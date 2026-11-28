package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Collection;
import r6.q;
import r6.s;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r6.n f6585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u6.j f6586b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements r6.o, s6.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final s f6587c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Collection f6588e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public s6.b f6589m;

        public a(s sVar, Collection collection) {
            this.f6587c = sVar;
            this.f6588e = collection;
        }

        @Override // s6.b
        public void dispose() {
            this.f6589m.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6589m.isDisposed();
        }

        @Override // r6.o
        public void onComplete() {
            Collection collection = this.f6588e;
            this.f6588e = null;
            this.f6587c.onSuccess(collection);
        }

        @Override // r6.o
        public void onError(Throwable th) {
            this.f6588e = null;
            this.f6587c.onError(th);
        }

        @Override // r6.o
        public void onNext(Object obj) {
            this.f6588e.add(obj);
        }

        @Override // r6.o
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.f6589m, bVar)) {
                this.f6589m = bVar;
                this.f6587c.onSubscribe(this);
            }
        }
    }

    public p(r6.n nVar, int i10) {
        this.f6585a = nVar;
        this.f6586b = w6.a.a(i10);
    }

    @Override // r6.q
    public void j(s sVar) {
        try {
            this.f6585a.c(new a(sVar, (Collection) ExceptionHelper.c(this.f6586b.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            t6.a.b(th);
            EmptyDisposable.error(th, sVar);
        }
    }
}
