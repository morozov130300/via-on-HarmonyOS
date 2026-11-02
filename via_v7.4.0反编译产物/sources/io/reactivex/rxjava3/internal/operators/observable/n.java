package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* renamed from: j, reason: collision with root package name */
    public final x6.l f7342j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements x6.m {

        /* renamed from: e, reason: collision with root package name */
        public final x6.m f7343e;

        /* renamed from: j, reason: collision with root package name */
        public final x6.l f7344j;

        /* renamed from: l, reason: collision with root package name */
        public boolean f7346l = true;

        /* renamed from: k, reason: collision with root package name */
        public final SequentialDisposable f7345k = new SequentialDisposable();

        public a(x6.m mVar, x6.l lVar) {
            this.f7343e = mVar;
            this.f7344j = lVar;
        }

        @Override // x6.m
        public void onComplete() {
            if (!this.f7346l) {
                this.f7343e.onComplete();
            } else {
                this.f7346l = false;
                this.f7344j.b(this);
            }
        }

        @Override // x6.m
        public void onError(Throwable th) {
            this.f7343e.onError(th);
        }

        @Override // x6.m
        public void onNext(Object obj) {
            if (this.f7346l) {
                this.f7346l = false;
            }
            this.f7343e.onNext(obj);
        }

        @Override // x6.m
        public void onSubscribe(y6.b bVar) {
            this.f7345k.update(bVar);
        }
    }

    public n(x6.l lVar, x6.l lVar2) {
        super(lVar);
        this.f7342j = lVar2;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        a aVar = new a(mVar, this.f7342j);
        mVar.onSubscribe(aVar.f7345k);
        this.f7295e.b(aVar);
    }
}
