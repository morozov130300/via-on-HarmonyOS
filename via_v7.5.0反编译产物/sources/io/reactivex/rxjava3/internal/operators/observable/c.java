package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u6.f f6535e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final u6.f f6536m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final u6.a f6537n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final u6.a f6538o;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements r6.o, s6.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r6.o f6539c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final u6.f f6540e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final u6.f f6541m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final u6.a f6542n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final u6.a f6543o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public s6.b f6544p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f6545q;

        public a(r6.o oVar, u6.f fVar, u6.f fVar2, u6.a aVar, u6.a aVar2) {
            this.f6539c = oVar;
            this.f6540e = fVar;
            this.f6541m = fVar2;
            this.f6542n = aVar;
            this.f6543o = aVar2;
        }

        @Override // s6.b
        public void dispose() {
            this.f6544p.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6544p.isDisposed();
        }

        @Override // r6.o
        public void onComplete() {
            if (this.f6545q) {
                return;
            }
            try {
                this.f6542n.run();
                this.f6545q = true;
                this.f6539c.onComplete();
                try {
                    this.f6543o.run();
                } catch (Throwable th) {
                    t6.a.b(th);
                    z6.a.o(th);
                }
            } catch (Throwable th2) {
                t6.a.b(th2);
                onError(th2);
            }
        }

        @Override // r6.o
        public void onError(Throwable th) {
            if (this.f6545q) {
                z6.a.o(th);
                return;
            }
            this.f6545q = true;
            try {
                this.f6541m.accept(th);
            } catch (Throwable th2) {
                t6.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f6539c.onError(th);
            try {
                this.f6543o.run();
            } catch (Throwable th3) {
                t6.a.b(th3);
                z6.a.o(th3);
            }
        }

        @Override // r6.o
        public void onNext(Object obj) {
            if (this.f6545q) {
                return;
            }
            try {
                this.f6540e.accept(obj);
                this.f6539c.onNext(obj);
            } catch (Throwable th) {
                t6.a.b(th);
                this.f6544p.dispose();
                onError(th);
            }
        }

        @Override // r6.o
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.f6544p, bVar)) {
                this.f6544p = bVar;
                this.f6539c.onSubscribe(this);
            }
        }
    }

    public c(r6.n nVar, u6.f fVar, u6.f fVar2, u6.a aVar, u6.a aVar2) {
        super(nVar);
        this.f6535e = fVar;
        this.f6536m = fVar2;
        this.f6537n = aVar;
        this.f6538o = aVar2;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        this.f6528c.c(new a(oVar, this.f6535e, this.f6536m, this.f6537n, this.f6538o));
    }
}
