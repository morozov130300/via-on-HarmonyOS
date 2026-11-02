package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ObservableSubscribeOn extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* renamed from: j, reason: collision with root package name */
    public final x6.n f7279j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class SubscribeOnObserver<T> extends AtomicReference<y6.b> implements x6.m, y6.b {
        private static final long serialVersionUID = 8094547886072529208L;
        final x6.m downstream;
        final AtomicReference<y6.b> upstream = new AtomicReference<>();

        public SubscribeOnObserver(x6.m mVar) {
            this.downstream = mVar;
        }

        @Override // y6.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        @Override // y6.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // x6.m
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // x6.m
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // x6.m
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // x6.m
        public void onSubscribe(y6.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        public void setDisposable(y6.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final SubscribeOnObserver f7280e;

        public a(SubscribeOnObserver subscribeOnObserver) {
            this.f7280e = subscribeOnObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableSubscribeOn.this.f7295e.b(this.f7280e);
        }
    }

    public ObservableSubscribeOn(x6.l lVar, x6.n nVar) {
        super(lVar);
        this.f7279j = nVar;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(mVar);
        mVar.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.setDisposable(this.f7279j.d(new a(subscribeOnObserver)));
    }
}
