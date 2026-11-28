package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class m extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6571e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements r6.o, s6.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r6.o f6572c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f6573e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public s6.b f6574m;

        public a(r6.o oVar, long j10) {
            this.f6572c = oVar;
            this.f6573e = j10;
        }

        @Override // s6.b
        public void dispose() {
            this.f6574m.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6574m.isDisposed();
        }

        @Override // r6.o
        public void onComplete() {
            this.f6572c.onComplete();
        }

        @Override // r6.o
        public void onError(Throwable th) {
            this.f6572c.onError(th);
        }

        @Override // r6.o
        public void onNext(Object obj) {
            long j10 = this.f6573e;
            if (j10 != 0) {
                this.f6573e = j10 - 1;
            } else {
                this.f6572c.onNext(obj);
            }
        }

        @Override // r6.o
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.f6574m, bVar)) {
                this.f6574m = bVar;
                this.f6572c.onSubscribe(this);
            }
        }
    }

    public m(r6.n nVar, long j10) {
        super(nVar);
        this.f6571e = j10;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        this.f6528c.c(new a(oVar, this.f6571e));
    }
}
