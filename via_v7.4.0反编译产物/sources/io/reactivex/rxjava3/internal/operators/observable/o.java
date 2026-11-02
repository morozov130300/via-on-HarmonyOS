package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* renamed from: j, reason: collision with root package name */
    public final a7.h f7347j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements x6.m, y6.b {

        /* renamed from: e, reason: collision with root package name */
        public final x6.m f7348e;

        /* renamed from: j, reason: collision with root package name */
        public final a7.h f7349j;

        /* renamed from: k, reason: collision with root package name */
        public y6.b f7350k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f7351l;

        public a(x6.m mVar, a7.h hVar) {
            this.f7348e = mVar;
            this.f7349j = hVar;
        }

        @Override // y6.b
        public void dispose() {
            this.f7350k.dispose();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7350k.isDisposed();
        }

        @Override // x6.m
        public void onComplete() {
            if (this.f7351l) {
                return;
            }
            this.f7351l = true;
            this.f7348e.onComplete();
        }

        @Override // x6.m
        public void onError(Throwable th) {
            if (this.f7351l) {
                f7.a.o(th);
            } else {
                this.f7351l = true;
                this.f7348e.onError(th);
            }
        }

        @Override // x6.m
        public void onNext(Object obj) {
            if (this.f7351l) {
                return;
            }
            this.f7348e.onNext(obj);
            try {
                if (this.f7349j.test(obj)) {
                    this.f7351l = true;
                    this.f7350k.dispose();
                    this.f7348e.onComplete();
                }
            } catch (Throwable th) {
                z6.a.b(th);
                this.f7350k.dispose();
                onError(th);
            }
        }

        @Override // x6.m
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.validate(this.f7350k, bVar)) {
                this.f7350k = bVar;
                this.f7348e.onSubscribe(this);
            }
        }
    }

    public o(x6.l lVar, a7.h hVar) {
        super(lVar);
        this.f7347j = hVar;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        this.f7295e.b(new a(mVar, this.f7347j));
    }
}
