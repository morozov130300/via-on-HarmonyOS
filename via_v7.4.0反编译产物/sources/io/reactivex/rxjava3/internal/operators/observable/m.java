package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* renamed from: j, reason: collision with root package name */
    public final long f7338j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements x6.m, y6.b {

        /* renamed from: e, reason: collision with root package name */
        public final x6.m f7339e;

        /* renamed from: j, reason: collision with root package name */
        public long f7340j;

        /* renamed from: k, reason: collision with root package name */
        public y6.b f7341k;

        public a(x6.m mVar, long j10) {
            this.f7339e = mVar;
            this.f7340j = j10;
        }

        @Override // y6.b
        public void dispose() {
            this.f7341k.dispose();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7341k.isDisposed();
        }

        @Override // x6.m
        public void onComplete() {
            this.f7339e.onComplete();
        }

        @Override // x6.m
        public void onError(Throwable th) {
            this.f7339e.onError(th);
        }

        @Override // x6.m
        public void onNext(Object obj) {
            long j10 = this.f7340j;
            if (j10 != 0) {
                this.f7340j = j10 - 1;
            } else {
                this.f7339e.onNext(obj);
            }
        }

        @Override // x6.m
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.validate(this.f7341k, bVar)) {
                this.f7341k = bVar;
                this.f7339e.onSubscribe(this);
            }
        }
    }

    public m(x6.l lVar, long j10) {
        super(lVar);
        this.f7338j = j10;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        this.f7295e.b(new a(mVar, this.f7338j));
    }
}
