package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import r6.i;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h extends io.reactivex.rxjava3.internal.operators.maybe.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u6.f f6480e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final u6.f f6481m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final u6.f f6482n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final u6.a f6483o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final u6.a f6484p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final u6.a f6485q;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements r6.h, s6.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r6.h f6486c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final h f6487e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public s6.b f6488m;

        public a(r6.h hVar, h hVar2) {
            this.f6486c = hVar;
            this.f6487e = hVar2;
        }

        public void a() {
            try {
                this.f6487e.f6484p.run();
            } catch (Throwable th) {
                t6.a.b(th);
                z6.a.o(th);
            }
        }

        public void b(Throwable th) {
            try {
                this.f6487e.f6482n.accept(th);
            } catch (Throwable th2) {
                t6.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f6488m = DisposableHelper.DISPOSED;
            this.f6486c.onError(th);
            a();
        }

        @Override // s6.b
        public void dispose() {
            try {
                this.f6487e.f6485q.run();
            } catch (Throwable th) {
                t6.a.b(th);
                z6.a.o(th);
            }
            this.f6488m.dispose();
            this.f6488m = DisposableHelper.DISPOSED;
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6488m.isDisposed();
        }

        @Override // r6.h
        public void onComplete() {
            s6.b bVar = this.f6488m;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper) {
                return;
            }
            try {
                this.f6487e.f6483o.run();
                this.f6488m = disposableHelper;
                this.f6486c.onComplete();
                a();
            } catch (Throwable th) {
                t6.a.b(th);
                b(th);
            }
        }

        @Override // r6.h
        public void onError(Throwable th) {
            if (this.f6488m == DisposableHelper.DISPOSED) {
                z6.a.o(th);
            } else {
                b(th);
            }
        }

        @Override // r6.h
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.f6488m, bVar)) {
                try {
                    this.f6487e.f6480e.accept(bVar);
                    this.f6488m = bVar;
                    this.f6486c.onSubscribe(this);
                } catch (Throwable th) {
                    t6.a.b(th);
                    bVar.dispose();
                    this.f6488m = DisposableHelper.DISPOSED;
                    EmptyDisposable.error(th, this.f6486c);
                }
            }
        }

        @Override // r6.h
        public void onSuccess(Object obj) {
            s6.b bVar = this.f6488m;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper) {
                return;
            }
            try {
                this.f6487e.f6481m.accept(obj);
                this.f6488m = disposableHelper;
                this.f6486c.onSuccess(obj);
                a();
            } catch (Throwable th) {
                t6.a.b(th);
                b(th);
            }
        }
    }

    public h(i iVar, u6.f fVar, u6.f fVar2, u6.f fVar3, u6.a aVar, u6.a aVar2, u6.a aVar3) {
        super(iVar);
        this.f6480e = fVar;
        this.f6481m = fVar2;
        this.f6482n = fVar3;
        this.f6483o = aVar;
        this.f6484p = aVar2;
        this.f6485q = aVar3;
    }

    @Override // r6.f
    public void m(r6.h hVar) {
        this.f6456c.c(new a(hVar, this));
    }
}
