package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import r6.p;
import r6.q;
import r6.s;
import r6.t;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class SingleSubscribeOn extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f6594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f6595b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class SubscribeOnObserver<T> extends AtomicReference<s6.b> implements s, s6.b, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final s downstream;
        final t source;
        final SequentialDisposable task = new SequentialDisposable();

        public SubscribeOnObserver(s sVar, t tVar) {
            this.downstream = sVar;
            this.source = tVar;
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

        @Override // r6.s
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // r6.s
        public void onSubscribe(s6.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // r6.s
        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.c(this);
        }
    }

    public SingleSubscribeOn(t tVar, p pVar) {
        this.f6594a = tVar;
        this.f6595b = pVar;
    }

    @Override // r6.q
    public void j(s sVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(sVar, this.f6594a);
        sVar.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.task.replace(this.f6595b.d(subscribeOnObserver));
    }
}
