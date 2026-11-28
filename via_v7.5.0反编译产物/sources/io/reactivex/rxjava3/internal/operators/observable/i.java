package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements r6.o, s6.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r6.o f6563c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public s6.b f6564e;

        public a(r6.o oVar) {
            this.f6563c = oVar;
        }

        @Override // s6.b
        public void dispose() {
            this.f6564e.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6564e.isDisposed();
        }

        @Override // r6.o
        public void onComplete() {
            this.f6563c.onComplete();
        }

        @Override // r6.o
        public void onError(Throwable th) {
            this.f6563c.onError(th);
        }

        @Override // r6.o
        public void onNext(Object obj) {
            this.f6563c.onNext(obj);
        }

        @Override // r6.o
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.f6564e, bVar)) {
                this.f6564e = bVar;
                this.f6563c.onSubscribe(this);
            }
        }
    }

    public i(r6.n nVar) {
        super(nVar);
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        this.f6528c.c(new a(oVar));
    }
}
