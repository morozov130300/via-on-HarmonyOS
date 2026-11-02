package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements x6.m, y6.b {

        /* renamed from: e, reason: collision with root package name */
        public final x6.m f7330e;

        /* renamed from: j, reason: collision with root package name */
        public y6.b f7331j;

        public a(x6.m mVar) {
            this.f7330e = mVar;
        }

        @Override // y6.b
        public void dispose() {
            this.f7331j.dispose();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7331j.isDisposed();
        }

        @Override // x6.m
        public void onComplete() {
            this.f7330e.onComplete();
        }

        @Override // x6.m
        public void onError(Throwable th) {
            this.f7330e.onError(th);
        }

        @Override // x6.m
        public void onNext(Object obj) {
            this.f7330e.onNext(obj);
        }

        @Override // x6.m
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.validate(this.f7331j, bVar)) {
                this.f7331j = bVar;
                this.f7330e.onSubscribe(this);
            }
        }
    }

    public i(x6.l lVar) {
        super(lVar);
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        this.f7295e.b(new a(mVar));
    }
}
