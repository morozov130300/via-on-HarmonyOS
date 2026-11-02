package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* renamed from: j, reason: collision with root package name */
    public final a7.e f7302j;

    /* renamed from: k, reason: collision with root package name */
    public final a7.e f7303k;

    /* renamed from: l, reason: collision with root package name */
    public final a7.a f7304l;

    /* renamed from: m, reason: collision with root package name */
    public final a7.a f7305m;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements x6.m, y6.b {

        /* renamed from: e, reason: collision with root package name */
        public final x6.m f7306e;

        /* renamed from: j, reason: collision with root package name */
        public final a7.e f7307j;

        /* renamed from: k, reason: collision with root package name */
        public final a7.e f7308k;

        /* renamed from: l, reason: collision with root package name */
        public final a7.a f7309l;

        /* renamed from: m, reason: collision with root package name */
        public final a7.a f7310m;

        /* renamed from: n, reason: collision with root package name */
        public y6.b f7311n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f7312o;

        public a(x6.m mVar, a7.e eVar, a7.e eVar2, a7.a aVar, a7.a aVar2) {
            this.f7306e = mVar;
            this.f7307j = eVar;
            this.f7308k = eVar2;
            this.f7309l = aVar;
            this.f7310m = aVar2;
        }

        @Override // y6.b
        public void dispose() {
            this.f7311n.dispose();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7311n.isDisposed();
        }

        @Override // x6.m
        public void onComplete() {
            if (this.f7312o) {
                return;
            }
            try {
                this.f7309l.run();
                this.f7312o = true;
                this.f7306e.onComplete();
                try {
                    this.f7310m.run();
                } catch (Throwable th) {
                    z6.a.b(th);
                    f7.a.o(th);
                }
            } catch (Throwable th2) {
                z6.a.b(th2);
                onError(th2);
            }
        }

        @Override // x6.m
        public void onError(Throwable th) {
            if (this.f7312o) {
                f7.a.o(th);
                return;
            }
            this.f7312o = true;
            try {
                this.f7308k.accept(th);
            } catch (Throwable th2) {
                z6.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f7306e.onError(th);
            try {
                this.f7310m.run();
            } catch (Throwable th3) {
                z6.a.b(th3);
                f7.a.o(th3);
            }
        }

        @Override // x6.m
        public void onNext(Object obj) {
            if (this.f7312o) {
                return;
            }
            try {
                this.f7307j.accept(obj);
                this.f7306e.onNext(obj);
            } catch (Throwable th) {
                z6.a.b(th);
                this.f7311n.dispose();
                onError(th);
            }
        }

        @Override // x6.m
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.validate(this.f7311n, bVar)) {
                this.f7311n = bVar;
                this.f7306e.onSubscribe(this);
            }
        }
    }

    public c(x6.l lVar, a7.e eVar, a7.e eVar2, a7.a aVar, a7.a aVar2) {
        super(lVar);
        this.f7302j = eVar;
        this.f7303k = eVar2;
        this.f7304l = aVar;
        this.f7305m = aVar2;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        this.f7295e.b(new a(mVar, this.f7302j, this.f7303k, this.f7304l, this.f7305m));
    }
}
