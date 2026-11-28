package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import r6.i;
import r6.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class MaybeObserveOn extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f6452e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class ObserveOnMaybeObserver<T> extends AtomicReference<s6.b> implements r6.h, s6.b, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final r6.h downstream;
        Throwable error;
        final p scheduler;
        T value;

        public ObserveOnMaybeObserver(r6.h hVar, p pVar) {
            this.downstream = hVar;
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

        @Override // r6.h
        public void onComplete() {
            DisposableHelper.replace(this, this.scheduler.d(this));
        }

        @Override // r6.h
        public void onError(Throwable th) {
            this.error = th;
            DisposableHelper.replace(this, this.scheduler.d(this));
        }

        @Override // r6.h
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // r6.h
        public void onSuccess(T t10) {
            this.value = t10;
            DisposableHelper.replace(this, this.scheduler.d(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.error = null;
                this.downstream.onError(th);
                return;
            }
            T t10 = this.value;
            if (t10 == null) {
                this.downstream.onComplete();
            } else {
                this.value = null;
                this.downstream.onSuccess(t10);
            }
        }
    }

    public MaybeObserveOn(i iVar, p pVar) {
        super(iVar);
        this.f6452e = pVar;
    }

    @Override // r6.f
    public void m(r6.h hVar) {
        this.f6456c.c(new ObserveOnMaybeObserver(hVar, this.f6452e));
    }
}
