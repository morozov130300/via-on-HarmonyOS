package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import x6.n;
import x6.o;
import x6.q;
import x6.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class SingleObserveOn extends o {

    /* renamed from: a, reason: collision with root package name */
    public final r f7359a;

    /* renamed from: b, reason: collision with root package name */
    public final n f7360b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class ObserveOnSingleObserver<T> extends AtomicReference<y6.b> implements q, y6.b, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        final q downstream;
        Throwable error;
        final n scheduler;
        T value;

        public ObserveOnSingleObserver(q qVar, n nVar) {
            this.downstream = qVar;
            this.scheduler = nVar;
        }

        @Override // y6.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // y6.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // x6.q
        public void onError(Throwable th) {
            this.error = th;
            DisposableHelper.replace(this, this.scheduler.d(this));
        }

        @Override // x6.q
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // x6.q
        public void onSuccess(T t10) {
            this.value = t10;
            DisposableHelper.replace(this, this.scheduler.d(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.downstream.onError(th);
            } else {
                this.downstream.onSuccess(this.value);
            }
        }
    }

    public SingleObserveOn(r rVar, n nVar) {
        this.f7359a = rVar;
        this.f7360b = nVar;
    }

    @Override // x6.o
    public void k(q qVar) {
        this.f7359a.c(new ObserveOnSingleObserver(qVar, this.f7360b));
    }
}
