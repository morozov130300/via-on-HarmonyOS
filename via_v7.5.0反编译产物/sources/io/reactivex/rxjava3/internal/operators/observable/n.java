package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class n extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r6.n f6575e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements r6.o {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r6.o f6576c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final r6.n f6577e;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f6579n = true;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final SequentialDisposable f6578m = new SequentialDisposable();

        public a(r6.o oVar, r6.n nVar) {
            this.f6576c = oVar;
            this.f6577e = nVar;
        }

        @Override // r6.o
        public void onComplete() {
            if (!this.f6579n) {
                this.f6576c.onComplete();
            } else {
                this.f6579n = false;
                this.f6577e.c(this);
            }
        }

        @Override // r6.o
        public void onError(Throwable th) {
            this.f6576c.onError(th);
        }

        @Override // r6.o
        public void onNext(Object obj) {
            if (this.f6579n) {
                this.f6579n = false;
            }
            this.f6576c.onNext(obj);
        }

        @Override // r6.o
        public void onSubscribe(s6.b bVar) {
            this.f6578m.update(bVar);
        }
    }

    public n(r6.n nVar, r6.n nVar2) {
        super(nVar);
        this.f6575e = nVar2;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        a aVar = new a(oVar, this.f6575e);
        oVar.onSubscribe(aVar.f6578m);
        this.f6528c.c(aVar);
    }
}
