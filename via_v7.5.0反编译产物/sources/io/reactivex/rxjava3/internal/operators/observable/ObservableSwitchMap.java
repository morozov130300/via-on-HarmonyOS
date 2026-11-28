package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ObservableSwitchMap extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u6.g f6515e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f6516m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f6517n;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class SwitchMapInnerObserver<T, R> extends AtomicReference<s6.b> implements r6.o {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        final long index;
        final SwitchMapObserver<T, R> parent;
        volatile x6.e queue;

        public SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j10, int i10) {
            this.parent = switchMapObserver;
            this.index = j10;
            this.bufferSize = i10;
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // r6.o
        public void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // r6.o
        public void onError(Throwable th) {
            this.parent.innerError(this, th);
        }

        @Override // r6.o
        public void onNext(R r10) {
            if (this.index == this.parent.unique) {
                if (r10 != null) {
                    this.queue.offer(r10);
                }
                this.parent.drain();
            }
        }

        @Override // r6.o
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                if (bVar instanceof x6.a) {
                    x6.a aVar = (x6.a) bVar;
                    int iRequestFusion = aVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.queue = aVar;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (iRequestFusion == 2) {
                        this.queue = aVar;
                        return;
                    }
                }
                this.queue = new io.reactivex.rxjava3.internal.queue.a(this.bufferSize);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class SwitchMapObserver<T, R> extends AtomicInteger implements r6.o, s6.b {
        static final SwitchMapInnerObserver<Object, Object> CANCELLED;
        private static final long serialVersionUID = -3491074160481096299L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final r6.o downstream;
        final u6.g mapper;
        volatile long unique;
        s6.b upstream;
        final AtomicReference<SwitchMapInnerObserver<T, R>> active = new AtomicReference<>();
        final AtomicThrowable errors = new AtomicThrowable();

        static {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = new SwitchMapInnerObserver<>(null, -1L, 1);
            CANCELLED = switchMapInnerObserver;
            switchMapInnerObserver.cancel();
        }

        public SwitchMapObserver(r6.o oVar, u6.g gVar, int i10, boolean z10) {
            this.downstream = oVar;
            this.mapper = gVar;
            this.bufferSize = i10;
            this.delayErrors = z10;
        }

        @Override // s6.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
            this.errors.tryTerminateAndReport();
        }

        public void disposeInner() {
            SwitchMapInnerObserver<T, R> andSet = this.active.getAndSet((SwitchMapInnerObserver<T, R>) CANCELLED);
            if (andSet != null) {
                andSet.cancel();
            }
        }

        /* JADX WARN: Code duplicated, block: B:76:0x00bb A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:79:0x0010 A[SYNTHETIC] */
        public void drain() {
            x6.e eVar;
            Object objPoll;
            if (getAndIncrement() != 0) {
                return;
            }
            r6.o oVar = this.downstream;
            AtomicReference<SwitchMapInnerObserver<T, R>> atomicReference = this.active;
            boolean z10 = this.delayErrors;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.done) {
                    boolean z11 = atomicReference.get() == null;
                    if (z10) {
                        if (z11) {
                            Throwable th = this.errors.get();
                            if (th != null) {
                                oVar.onError(th);
                                return;
                            } else {
                                oVar.onComplete();
                                return;
                            }
                        }
                    } else if (this.errors.get() != null) {
                        this.errors.tryTerminateConsumer(oVar);
                        return;
                    } else if (z11) {
                        oVar.onComplete();
                        return;
                    }
                }
                SwitchMapInnerObserver<T, R> switchMapInnerObserver = atomicReference.get();
                if (switchMapInnerObserver != null && (eVar = switchMapInnerObserver.queue) != null) {
                    boolean z12 = false;
                    while (!this.cancelled) {
                        if (switchMapInnerObserver == atomicReference.get()) {
                            if (!z10 && this.errors.get() != null) {
                                this.errors.tryTerminateConsumer(oVar);
                                return;
                            }
                            boolean z13 = switchMapInnerObserver.done;
                            try {
                                objPoll = eVar.poll();
                            } catch (Throwable th2) {
                                t6.a.b(th2);
                                this.errors.tryAddThrowableOrReport(th2);
                                autodispose2.c.a(atomicReference, switchMapInnerObserver, null);
                                if (z10) {
                                    switchMapInnerObserver.cancel();
                                } else {
                                    disposeInner();
                                    this.upstream.dispose();
                                    this.done = true;
                                }
                                objPoll = null;
                                z12 = true;
                            }
                            boolean z14 = objPoll == null;
                            if (z13 && z14) {
                                autodispose2.c.a(atomicReference, switchMapInnerObserver, null);
                            } else if (!z14) {
                                oVar.onNext(objPoll);
                            }
                            if (z12) {
                                continue;
                            }
                        }
                        z12 = true;
                        if (z12) {
                            continue;
                        }
                    }
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        public void innerError(SwitchMapInnerObserver<T, R> switchMapInnerObserver, Throwable th) {
            if (switchMapInnerObserver.index != this.unique || !this.errors.tryAddThrowable(th)) {
                z6.a.o(th);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                this.done = true;
            }
            switchMapInnerObserver.done = true;
            drain();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // r6.o
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // r6.o
        public void onError(Throwable th) {
            if (this.done || !this.errors.tryAddThrowable(th)) {
                z6.a.o(th);
                return;
            }
            if (!this.delayErrors) {
                disposeInner();
            }
            this.done = true;
            drain();
        }

        @Override // r6.o
        public void onNext(T t10) {
            SwitchMapInnerObserver<T, R> switchMapInnerObserver;
            long j10 = this.unique + 1;
            this.unique = j10;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.active.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.cancel();
            }
            try {
                Object objApply = this.mapper.apply(t10);
                Objects.requireNonNull(objApply, "The ObservableSource returned is null");
                r6.n nVar = (r6.n) objApply;
                SwitchMapInnerObserver switchMapInnerObserver3 = new SwitchMapInnerObserver(this, j10, this.bufferSize);
                do {
                    switchMapInnerObserver = this.active.get();
                    if (switchMapInnerObserver == CANCELLED) {
                        return;
                    }
                } while (!autodispose2.c.a(this.active, switchMapInnerObserver, switchMapInnerObserver3));
                nVar.c(switchMapInnerObserver3);
            } catch (Throwable th) {
                t6.a.b(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // r6.o
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMap(r6.n nVar, u6.g gVar, int i10, boolean z10) {
        super(nVar);
        this.f6515e = gVar;
        this.f6516m = i10;
        this.f6517n = z10;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        if (ObservableScalarXMap.b(this.f6528c, oVar, this.f6515e)) {
            return;
        }
        this.f6528c.c(new SwitchMapObserver(oVar, this.f6515e, this.f6516m, this.f6517n));
    }
}
