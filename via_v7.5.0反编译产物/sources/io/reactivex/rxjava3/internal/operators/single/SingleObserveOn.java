package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import r6.p;
import r6.q;
import r6.s;
import r6.t;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class SingleObserveOn extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f6592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f6593b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class ObserveOnSingleObserver<T> extends AtomicReference<s6.b> implements s, s6.b, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        final s downstream;
        Throwable error;
        final p scheduler;
        T value;

        public ObserveOnSingleObserver(s sVar, p pVar) {
            this.downstream = sVar;
            this.scheduler = pVar;
        }

        @Override // s6.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // s6.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // r6.s
        public void onError(Throwable th) {
            this.error = th;
            DisposableHelper.replace(this, this.scheduler.d(this));
        }

        @Override // r6.s
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // r6.s
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

    public SingleObserveOn(t tVar, p pVar) {
        this.f6592a = tVar;
        this.f6593b = pVar;
    }

    @Override // r6.q
    public void j(s sVar) {
        this.f6592a.c(new ObserveOnSingleObserver(sVar, this.f6593b));
    }
}
