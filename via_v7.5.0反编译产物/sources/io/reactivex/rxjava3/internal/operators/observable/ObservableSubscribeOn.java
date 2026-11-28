package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ObservableSubscribeOn extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r6.p f6512e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class SubscribeOnObserver<T> extends AtomicReference<s6.b> implements r6.o, s6.b {
        private static final long serialVersionUID = 8094547886072529208L;
        final r6.o downstream;
        final AtomicReference<s6.b> upstream = new AtomicReference<>();

        public SubscribeOnObserver(r6.o oVar) {
            this.downstream = oVar;
        }

        @Override // s6.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        @Override // s6.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // r6.o
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // r6.o
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // r6.o
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // r6.o
        public void onSubscribe(s6.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        public void setDisposable(s6.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SubscribeOnObserver f6513c;

        public a(SubscribeOnObserver subscribeOnObserver) {
            this.f6513c = subscribeOnObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableSubscribeOn.this.f6528c.c(this.f6513c);
        }
    }

    public ObservableSubscribeOn(r6.n nVar, r6.p pVar) {
        super(nVar);
        this.f6512e = pVar;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(oVar);
        oVar.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.setDisposable(this.f6512e.d(new a(subscribeOnObserver)));
    }
}
