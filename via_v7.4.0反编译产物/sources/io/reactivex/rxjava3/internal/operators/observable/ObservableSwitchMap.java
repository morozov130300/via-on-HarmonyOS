package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ObservableSwitchMap extends a {

    /* renamed from: j, reason: collision with root package name */
    public final a7.f f7282j;

    /* renamed from: k, reason: collision with root package name */
    public final int f7283k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f7284l;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class SwitchMapInnerObserver<T, R> extends AtomicReference<y6.b> implements x6.m {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        final long index;
        final SwitchMapObserver<T, R> parent;
        volatile d7.e queue;

        public SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j10, int i10) {
            this.parent = switchMapObserver;
            this.index = j10;
            this.bufferSize = i10;
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // x6.m
        public void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // x6.m
        public void onError(Throwable th) {
            this.parent.innerError(this, th);
        }

        @Override // x6.m
        public void onNext(R r10) {
            if (this.index == this.parent.unique) {
                if (r10 != null) {
                    this.queue.offer(r10);
                }
                this.parent.drain();
            }
        }

        @Override // x6.m
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                if (bVar instanceof d7.a) {
                    d7.a aVar = (d7.a) bVar;
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

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class SwitchMapObserver<T, R> extends AtomicInteger implements x6.m, y6.b {
        static final SwitchMapInnerObserver<Object, Object> CANCELLED;
        private static final long serialVersionUID = -3491074160481096299L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final x6.m downstream;
        final a7.f mapper;
        volatile long unique;
        y6.b upstream;
        final AtomicReference<SwitchMapInnerObserver<T, R>> active = new AtomicReference<>();
        final AtomicThrowable errors = new AtomicThrowable();

        static {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = new SwitchMapInnerObserver<>(null, -1L, 1);
            CANCELLED = switchMapInnerObserver;
            switchMapInnerObserver.cancel();
        }

        public SwitchMapObserver(x6.m mVar, a7.f fVar, int i10, boolean z10) {
            this.downstream = mVar;
            this.mapper = fVar;
            this.bufferSize = i10;
            this.delayErrors = z10;
        }

        @Override // y6.b
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
            SwitchMapInnerObserver switchMapInnerObserver = (SwitchMapInnerObserver) this.active.getAndSet(CANCELLED);
            if (switchMapInnerObserver != null) {
                switchMapInnerObserver.cancel();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:76:0x00bb A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0010 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            d7.e eVar;
            Object objPoll;
            if (getAndIncrement() != 0) {
                return;
            }
            x6.m mVar = this.downstream;
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
                                mVar.onError(th);
                                return;
                            } else {
                                mVar.onComplete();
                                return;
                            }
                        }
                    } else if (this.errors.get() != null) {
                        this.errors.tryTerminateConsumer(mVar);
                        return;
                    } else if (z11) {
                        mVar.onComplete();
                        return;
                    }
                }
                SwitchMapInnerObserver<T, R> switchMapInnerObserver = atomicReference.get();
                if (switchMapInnerObserver != null && (eVar = switchMapInnerObserver.queue) != null) {
                    boolean z12 = false;
                    while (!this.cancelled) {
                        if (switchMapInnerObserver == atomicReference.get()) {
                            if (!z10 && this.errors.get() != null) {
                                this.errors.tryTerminateConsumer(mVar);
                                return;
                            }
                            boolean z13 = switchMapInnerObserver.done;
                            try {
                                objPoll = eVar.poll();
                            } catch (Throwable th2) {
                                z6.a.b(th2);
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
                                mVar.onNext(objPoll);
                            } else if (!z12) {
                                continue;
                            }
                        }
                        z12 = true;
                        if (!z12) {
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
                f7.a.o(th);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                this.done = true;
            }
            switchMapInnerObserver.done = true;
            drain();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // x6.m
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // x6.m
        public void onError(Throwable th) {
            if (this.done || !this.errors.tryAddThrowable(th)) {
                f7.a.o(th);
                return;
            }
            if (!this.delayErrors) {
                disposeInner();
            }
            this.done = true;
            drain();
        }

        @Override // x6.m
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
                x6.l lVar = (x6.l) objApply;
                SwitchMapInnerObserver switchMapInnerObserver3 = new SwitchMapInnerObserver(this, j10, this.bufferSize);
                do {
                    switchMapInnerObserver = this.active.get();
                    if (switchMapInnerObserver == CANCELLED) {
                        return;
                    }
                } while (!autodispose2.c.a(this.active, switchMapInnerObserver, switchMapInnerObserver3));
                lVar.b(switchMapInnerObserver3);
            } catch (Throwable th) {
                z6.a.b(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // x6.m
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMap(x6.l lVar, a7.f fVar, int i10, boolean z10) {
        super(lVar);
        this.f7282j = fVar;
        this.f7283k = i10;
        this.f7284l = z10;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        if (ObservableScalarXMap.b(this.f7295e, mVar, this.f7282j)) {
            return;
        }
        this.f7295e.b(new SwitchMapObserver(mVar, this.f7282j, this.f7283k, this.f7284l));
    }
}
