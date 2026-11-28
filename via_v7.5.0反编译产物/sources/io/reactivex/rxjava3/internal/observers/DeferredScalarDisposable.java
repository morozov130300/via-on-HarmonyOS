package io.reactivex.rxjava3.internal.observers;

import r6.o;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    static final int DISPOSED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int TERMINATED = 2;
    private static final long serialVersionUID = -5502432239815349361L;
    protected final o downstream;
    protected T value;

    public DeferredScalarDisposable(o oVar) {
        this.downstream = oVar;
    }

    @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.e
    public final void clear() {
        lazySet(FUSED_CONSUMED);
        this.value = null;
    }

    public final void complete(T t10) {
        int i10 = get();
        if ((i10 & 54) != 0) {
            return;
        }
        o oVar = this.downstream;
        if (i10 == FUSED_EMPTY) {
            this.value = t10;
            lazySet(FUSED_READY);
            oVar.onNext(null);
        } else {
            lazySet(2);
            oVar.onNext(t10);
        }
        if (get() != 4) {
            oVar.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, s6.b
    public void dispose() {
        set(4);
        this.value = null;
    }

    public final void error(Throwable th) {
        if ((get() & 54) != 0) {
            z6.a.o(th);
        } else {
            lazySet(2);
            this.downstream.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, s6.b
    public final boolean isDisposed() {
        return get() == 4;
    }

    @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.e
    public final boolean isEmpty() {
        return get() != FUSED_READY;
    }

    @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.e
    public final T poll() {
        if (get() != FUSED_READY) {
            return null;
        }
        T t10 = this.value;
        this.value = null;
        lazySet(FUSED_CONSUMED);
        return t10;
    }

    @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.b
    public final int requestFusion(int i10) {
        if ((i10 & 2) == 0) {
            return 0;
        }
        lazySet(FUSED_EMPTY);
        return 2;
    }

    public final boolean tryDispose() {
        return getAndSet(4) != 4;
    }

    public final void complete() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.downstream.onComplete();
    }
}
