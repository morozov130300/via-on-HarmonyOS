package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import r6.i;
import r6.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class MaybeSubscribeOn extends io.reactivex.rxjava3.internal.operators.maybe.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f6453e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class SubscribeOnMaybeObserver<T> extends AtomicReference<s6.b> implements r6.h, s6.b {
        private static final long serialVersionUID = 8571289934935992137L;
        final r6.h downstream;
        final SequentialDisposable task = new SequentialDisposable();

        public SubscribeOnMaybeObserver(r6.h hVar) {
            this.downstream = hVar;
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

        @Override // r6.h
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // r6.h
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // r6.h
        public void onSubscribe(s6.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // r6.h
        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r6.h f6454c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final i f6455e;

        public a(r6.h hVar, i iVar) {
            this.f6454c = hVar;
            this.f6455e = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6455e.c(this.f6454c);
        }
    }

    public MaybeSubscribeOn(i iVar, p pVar) {
        super(iVar);
        this.f6453e = pVar;
    }

    @Override // r6.f
    public void m(r6.h hVar) {
        SubscribeOnMaybeObserver subscribeOnMaybeObserver = new SubscribeOnMaybeObserver(hVar);
        hVar.onSubscribe(subscribeOnMaybeObserver);
        subscribeOnMaybeObserver.task.replace(this.f6453e.d(new a(subscribeOnMaybeObserver, this.f6456c)));
    }
}
