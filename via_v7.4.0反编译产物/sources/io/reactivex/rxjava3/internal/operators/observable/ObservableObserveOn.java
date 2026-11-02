package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import x6.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ObservableObserveOn extends a {

    /* renamed from: j, reason: collision with root package name */
    public final x6.n f7274j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f7275k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7276l;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements x6.m, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final x6.m downstream;
        Throwable error;
        boolean outputFused;
        d7.e queue;
        int sourceMode;
        y6.b upstream;
        final n.b worker;

        public ObserveOnObserver(x6.m mVar, n.b bVar, boolean z10, int i10) {
            this.downstream = mVar;
            this.worker = bVar;
            this.delayError = z10;
            this.bufferSize = i10;
        }

        public boolean checkTerminated(boolean z10, boolean z11, x6.m mVar) {
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
                    mVar.onError(th);
                } else {
                    mVar.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            if (th != null) {
                this.disposed = true;
                this.queue.clear();
                mVar.onError(th);
                this.worker.dispose();
                return true;
            }
            if (!z11) {
                return false;
            }
            this.disposed = true;
            mVar.onComplete();
            this.worker.dispose();
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, d7.e
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, y6.b
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

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        
            r3 = addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        
            if (r3 != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drainNormal() {
            d7.e eVar = this.queue;
            x6.m mVar = this.downstream;
            int iAddAndGet = 1;
            while (!checkTerminated(this.done, eVar.isEmpty(), mVar)) {
                while (true) {
                    boolean z10 = this.done;
                    try {
                        Object objPoll = eVar.poll();
                        boolean z11 = objPoll == null;
                        if (checkTerminated(z10, z11, mVar)) {
                            return;
                        }
                        if (z11) {
                            break;
                        } else {
                            mVar.onNext(objPoll);
                        }
                    } catch (Throwable th) {
                        z6.a.b(th);
                        this.disposed = true;
                        this.upstream.dispose();
                        eVar.clear();
                        mVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, y6.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, d7.e
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // x6.m
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // x6.m
        public void onError(Throwable th) {
            if (this.done) {
                f7.a.o(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // x6.m
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t10);
            }
            schedule();
        }

        @Override // x6.m
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof d7.a) {
                    d7.a aVar = (d7.a) bVar;
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

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, d7.e
        public T poll() {
            return (T) this.queue.poll();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, d7.b
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

    public ObservableObserveOn(x6.l lVar, x6.n nVar, boolean z10, int i10) {
        super(lVar);
        this.f7274j = nVar;
        this.f7275k = z10;
        this.f7276l = i10;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        x6.n nVar = this.f7274j;
        if (nVar instanceof io.reactivex.rxjava3.internal.schedulers.h) {
            this.f7295e.b(mVar);
        } else {
            this.f7295e.b(new ObserveOnObserver(mVar, nVar.c(), this.f7275k, this.f7276l));
        }
    }
}
