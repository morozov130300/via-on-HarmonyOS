package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import x6.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class CompletableSubscribeOn extends x6.a {

    /* renamed from: a, reason: collision with root package name */
    public final x6.c f7213a;

    /* renamed from: b, reason: collision with root package name */
    public final n f7214b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class SubscribeOnObserver extends AtomicReference<y6.b> implements x6.b, y6.b, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final x6.b downstream;
        final x6.c source;
        final SequentialDisposable task = new SequentialDisposable();

        public SubscribeOnObserver(x6.b bVar, x6.c cVar) {
            this.downstream = bVar;
            this.source = cVar;
        }

        @Override // y6.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // x6.b
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // x6.b
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // x6.b
        public void onSubscribe(y6.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.a(this);
        }
    }

    public CompletableSubscribeOn(x6.c cVar, n nVar) {
        this.f7213a = cVar;
        this.f7214b = nVar;
    }

    @Override // x6.a
    public void g(x6.b bVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(bVar, this.f7213a);
        bVar.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.task.replace(this.f7214b.d(subscribeOnObserver));
    }
}
