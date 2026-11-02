package io.reactivex.rxjava3.internal.operators.observable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j extends x6.a {

    /* renamed from: a, reason: collision with root package name */
    public final x6.l f7332a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements x6.m, y6.b {

        /* renamed from: e, reason: collision with root package name */
        public final x6.b f7333e;

        /* renamed from: j, reason: collision with root package name */
        public y6.b f7334j;

        public a(x6.b bVar) {
            this.f7333e = bVar;
        }

        @Override // y6.b
        public void dispose() {
            this.f7334j.dispose();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7334j.isDisposed();
        }

        @Override // x6.m
        public void onComplete() {
            this.f7333e.onComplete();
        }

        @Override // x6.m
        public void onError(Throwable th) {
            this.f7333e.onError(th);
        }

        @Override // x6.m
        public void onNext(Object obj) {
        }

        @Override // x6.m
        public void onSubscribe(y6.b bVar) {
            this.f7334j = bVar;
            this.f7333e.onSubscribe(this);
        }
    }

    public j(x6.l lVar) {
        this.f7332a = lVar;
    }

    @Override // x6.a
    public void g(x6.b bVar) {
        this.f7332a.b(new a(bVar));
    }
}
