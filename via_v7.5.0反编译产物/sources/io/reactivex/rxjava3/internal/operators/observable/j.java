package io.reactivex.rxjava3.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j extends r6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r6.n f6565a;

    public j(r6.n nVar) {
        this.f6565a = nVar;
    }

    @Override // r6.a
    public void g(r6.b bVar) {
        this.f6565a.c(new a(bVar));
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements r6.o, s6.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r6.b f6566c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public s6.b f6567e;

        public a(r6.b bVar) {
            this.f6566c = bVar;
        }

        @Override // s6.b
        public void dispose() {
            this.f6567e.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6567e.isDisposed();
        }

        @Override // r6.o
        public void onComplete() {
            this.f6566c.onComplete();
        }

        @Override // r6.o
        public void onError(Throwable th) {
            this.f6566c.onError(th);
        }

        @Override // r6.o
        public void onSubscribe(s6.b bVar) {
            this.f6567e = bVar;
            this.f6566c.onSubscribe(this);
        }

        @Override // r6.o
        public void onNext(Object obj) {
        }
    }
}
