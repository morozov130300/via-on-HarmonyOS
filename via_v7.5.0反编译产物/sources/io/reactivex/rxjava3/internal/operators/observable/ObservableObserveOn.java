package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ObservableObserveOn extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r6.p f6507e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f6508m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f6509n;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements r6.o, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final r6.o downstream;
        Throwable error;
        boolean outputFused;
        x6.e queue;
        int sourceMode;
        s6.b upstream;
        final r6.p.c worker;

        public ObserveOnObserver(r6.o oVar, r6.p.c cVar, boolean z10, int i10) {
            this.downstream = oVar;
            this.worker = cVar;
            this.delayError = z10;
            this.bufferSize = i10;
        }

        public boolean checkTerminated(boolean z10, boolean z11, r6.o oVar) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable th = this.error;
            if (this.delayError) {
                if (!z11) {
                    return false;
                }
                this.disposed = true;
                if (th != null) {
                    oVar.onError(th);
                } else {
                    oVar.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            if (th != null) {
                this.disposed = true;
                this.queue.clear();
                oVar.onError(th);
                this.worker.dispose();
                return true;
            }
            if (!z11) {
                return false;
            }
            this.disposed = true;
            oVar.onComplete();
            this.worker.dispose();
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.e
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, s6.b
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (this.outputFused || getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }

        public void drainFused() {
            int iAddAndGet = 1;
            while (!this.disposed) {
                boolean z10 = this.done;
                Throwable th = this.error;
                if (!this.delayError && z10 && th != null) {
                    this.disposed = true;
                    this.downstream.onError(this.error);
                    this.worker.dispose();
                    return;
                }
                this.downstream.onNext(null);
                if (z10) {
                    this.disposed = true;
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.downstream.onError(th2);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        public void drainNormal() {
            x6.e eVar = this.queue;
            r6.o oVar = this.downstream;
            int iAddAndGet = 1;
            while (!checkTerminated(this.done, eVar.isEmpty(), oVar)) {
                while (true) {
                    boolean z10 = this.done;
                    try {
                        Object objPoll = eVar.poll();
                        boolean z11 = objPoll == null;
                        if (checkTerminated(z10, z11, oVar)) {
                            return;
                        }
                        if (z11) {
                            break;
                        } else {
                            oVar.onNext(objPoll);
                        }
                    } catch (Throwable th) {
                        t6.a.b(th);
                        this.disposed = true;
                        this.upstream.dispose();
                        eVar.clear();
                        oVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, s6.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.e
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // r6.o
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // r6.o
        public void onError(Throwable th) {
            if (this.done) {
                z6.a.o(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // r6.o
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t10);
            }
            schedule();
        }

        @Override // r6.o
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof x6.a) {
                    x6.a aVar = (x6.a) bVar;
                    int iRequestFusion = aVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = aVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        schedule();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = aVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.rxjava3.internal.queue.a(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.e
        public T poll() {
            return (T) this.queue.poll();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.b
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        public void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.b(this);
            }
        }
    }

    public ObservableObserveOn(r6.n nVar, r6.p pVar, boolean z10, int i10) {
        super(nVar);
        this.f6507e = pVar;
        this.f6508m = z10;
        this.f6509n = i10;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        r6.p pVar = this.f6507e;
        if (pVar instanceof io.reactivex.rxjava3.internal.schedulers.i) {
            this.f6528c.c(oVar);
        } else {
            this.f6528c.c(new ObserveOnObserver(oVar, pVar.c(), this.f6508m, this.f6509n));
        }
    }
}
