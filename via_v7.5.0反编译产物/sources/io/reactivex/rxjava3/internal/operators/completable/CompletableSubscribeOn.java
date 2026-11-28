package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import r6.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class CompletableSubscribeOn extends r6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r6.c f6444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f6445b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class SubscribeOnObserver extends AtomicReference<s6.b> implements r6.b, s6.b, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final r6.b downstream;
        final r6.c source;
        final SequentialDisposable task = new SequentialDisposable();

        public SubscribeOnObserver(r6.b bVar, r6.c cVar) {
            this.downstream = bVar;
            this.source = cVar;
        }

        @Override // s6.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // r6.b
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // r6.b
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // r6.b
        public void onSubscribe(s6.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.a(this);
        }
    }

    public CompletableSubscribeOn(r6.c cVar, p pVar) {
        this.f6444a = cVar;
        this.f6445b = pVar;
    }

    @Override // r6.a
    public void g(r6.b bVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(bVar, this.f6444a);
        bVar.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.task.replace(this.f6445b.d(subscribeOnObserver));
    }
}
