package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u6.i f6580e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements r6.o, s6.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r6.o f6581c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final u6.i f6582e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public s6.b f6583m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f6584n;

        public a(r6.o oVar, u6.i iVar) {
            this.f6581c = oVar;
            this.f6582e = iVar;
        }

        @Override // s6.b
        public void dispose() {
            this.f6583m.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6583m.isDisposed();
        }

        @Override // r6.o
        public void onComplete() {
            if (this.f6584n) {
                return;
            }
            this.f6584n = true;
            this.f6581c.onComplete();
        }

        @Override // r6.o
        public void onError(Throwable th) {
            if (this.f6584n) {
                z6.a.o(th);
            } else {
                this.f6584n = true;
                this.f6581c.onError(th);
            }
        }

        @Override // r6.o
        public void onNext(Object obj) {
            if (this.f6584n) {
                return;
            }
            this.f6581c.onNext(obj);
            try {
                if (this.f6582e.test(obj)) {
                    this.f6584n = true;
                    this.f6583m.dispose();
                    this.f6581c.onComplete();
                }
            } catch (Throwable th) {
                t6.a.b(th);
                this.f6583m.dispose();
                onError(th);
            }
        }

        @Override // r6.o
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.f6583m, bVar)) {
                this.f6583m = bVar;
                this.f6581c.onSubscribe(this);
            }
        }
    }

    public o(r6.n nVar, u6.i iVar) {
        super(nVar);
        this.f6580e = iVar;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        this.f6528c.c(new a(oVar, this.f6580e));
    }
}
