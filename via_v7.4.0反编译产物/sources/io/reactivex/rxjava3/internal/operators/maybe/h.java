package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import x6.i;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h extends io.reactivex.rxjava3.internal.operators.maybe.a {

    /* renamed from: j, reason: collision with root package name */
    public final a7.e f7249j;

    /* renamed from: k, reason: collision with root package name */
    public final a7.e f7250k;

    /* renamed from: l, reason: collision with root package name */
    public final a7.e f7251l;

    /* renamed from: m, reason: collision with root package name */
    public final a7.a f7252m;

    /* renamed from: n, reason: collision with root package name */
    public final a7.a f7253n;

    /* renamed from: o, reason: collision with root package name */
    public final a7.a f7254o;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements x6.h, y6.b {

        /* renamed from: e, reason: collision with root package name */
        public final x6.h f7255e;

        /* renamed from: j, reason: collision with root package name */
        public final h f7256j;

        /* renamed from: k, reason: collision with root package name */
        public y6.b f7257k;

        public a(x6.h hVar, h hVar2) {
            this.f7255e = hVar;
            this.f7256j = hVar2;
        }

        public void a() {
            try {
                this.f7256j.f7253n.run();
            } catch (Throwable th) {
                z6.a.b(th);
                f7.a.o(th);
            }
        }

        public void b(Throwable th) {
            try {
                this.f7256j.f7251l.accept(th);
            } catch (Throwable th2) {
                z6.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f7257k = DisposableHelper.DISPOSED;
            this.f7255e.onError(th);
            a();
        }

        @Override // y6.b
        public void dispose() {
            try {
                this.f7256j.f7254o.run();
            } catch (Throwable th) {
                z6.a.b(th);
                f7.a.o(th);
            }
            this.f7257k.dispose();
            this.f7257k = DisposableHelper.DISPOSED;
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7257k.isDisposed();
        }

        @Override // x6.h
        public void onComplete() {
            y6.b bVar = this.f7257k;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper) {
                return;
            }
            try {
                this.f7256j.f7252m.run();
                this.f7257k = disposableHelper;
                this.f7255e.onComplete();
                a();
            } catch (Throwable th) {
                z6.a.b(th);
                b(th);
            }
        }

        @Override // x6.h
        public void onError(Throwable th) {
            if (this.f7257k == DisposableHelper.DISPOSED) {
                f7.a.o(th);
            } else {
                b(th);
            }
        }

        @Override // x6.h
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.validate(this.f7257k, bVar)) {
                try {
                    this.f7256j.f7249j.accept(bVar);
                    this.f7257k = bVar;
                    this.f7255e.onSubscribe(this);
                } catch (Throwable th) {
                    z6.a.b(th);
                    bVar.dispose();
                    this.f7257k = DisposableHelper.DISPOSED;
                    EmptyDisposable.error(th, this.f7255e);
                }
            }
        }

        @Override // x6.h
        public void onSuccess(Object obj) {
            y6.b bVar = this.f7257k;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper) {
                return;
            }
            try {
                this.f7256j.f7250k.accept(obj);
                this.f7257k = disposableHelper;
                this.f7255e.onSuccess(obj);
                a();
            } catch (Throwable th) {
                z6.a.b(th);
                b(th);
            }
        }
    }

    public h(i iVar, a7.e eVar, a7.e eVar2, a7.e eVar3, a7.a aVar, a7.a aVar2, a7.a aVar3) {
        super(iVar);
        this.f7249j = eVar;
        this.f7250k = eVar2;
        this.f7251l = eVar3;
        this.f7252m = aVar;
        this.f7253n = aVar2;
        this.f7254o = aVar3;
    }

    @Override // x6.f
    public void m(x6.h hVar) {
        this.f7225e.c(new a(hVar, this));
    }
}
