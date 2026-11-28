package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ObservableDoFinally extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u6.a f6502e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements r6.o {
        private static final long serialVersionUID = 4109457741734051389L;
        final r6.o downstream;
        final u6.a onFinally;
        x6.a qd;
        boolean syncFused;
        s6.b upstream;

        public DoFinallyObserver(r6.o oVar, u6.a aVar) {
            this.downstream = oVar;
            this.onFinally = aVar;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.e
        public void clear() {
            this.qd.clear();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, s6.b
        public void dispose() {
            this.upstream.dispose();
            runFinally();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, s6.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.e
        public boolean isEmpty() {
            return this.qd.isEmpty();
        }

        @Override // r6.o
        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // r6.o
        public void onError(Throwable th) {
            this.downstream.onError(th);
            runFinally();
        }

        @Override // r6.o
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // r6.o
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof x6.a) {
                    this.qd = (x6.a) bVar;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.e
        public T poll() {
            T t10 = (T) this.qd.poll();
            if (t10 == null && this.syncFused) {
                runFinally();
            }
            return t10;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.b
        public int requestFusion(int i10) {
            x6.a aVar = this.qd;
            if (aVar == null || (i10 & 4) != 0) {
                return 0;
            }
            int iRequestFusion = aVar.requestFusion(i10);
            if (iRequestFusion != 0) {
                this.syncFused = iRequestFusion == 1;
            }
            return iRequestFusion;
        }

        public void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    t6.a.b(th);
                    z6.a.o(th);
                }
            }
        }
    }

    public ObservableDoFinally(r6.n nVar, u6.a aVar) {
        super(nVar);
        this.f6502e = aVar;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        this.f6528c.c(new DoFinallyObserver(oVar, this.f6502e));
    }
}
