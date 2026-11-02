package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import x6.i;
import x6.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class MaybeSubscribeOn extends io.reactivex.rxjava3.internal.operators.maybe.a {

    /* renamed from: j, reason: collision with root package name */
    public final n f7222j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class SubscribeOnMaybeObserver<T> extends AtomicReference<y6.b> implements x6.h, y6.b {
        private static final long serialVersionUID = 8571289934935992137L;
        final x6.h downstream;
        final SequentialDisposable task = new SequentialDisposable();

        public SubscribeOnMaybeObserver(x6.h hVar) {
            this.downstream = hVar;
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

        @Override // x6.h
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // x6.h
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // x6.h
        public void onSubscribe(y6.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // x6.h
        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final x6.h f7223e;

        /* renamed from: j, reason: collision with root package name */
        public final i f7224j;

        public a(x6.h hVar, i iVar) {
            this.f7223e = hVar;
            this.f7224j = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7224j.c(this.f7223e);
        }
    }

    public MaybeSubscribeOn(i iVar, n nVar) {
        super(iVar);
        this.f7222j = nVar;
    }

    @Override // x6.f
    public void m(x6.h hVar) {
        SubscribeOnMaybeObserver subscribeOnMaybeObserver = new SubscribeOnMaybeObserver(hVar);
        hVar.onSubscribe(subscribeOnMaybeObserver);
        subscribeOnMaybeObserver.task.replace(this.f7222j.d(new a(subscribeOnMaybeObserver, this.f7225e)));
    }
}
