package io.reactivex.rxjava3.internal.observers;

import x6.m;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    static final int DISPOSED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int TERMINATED = 2;
    private static final long serialVersionUID = -5502432239815349361L;
    protected final m downstream;
    protected T value;

    public DeferredScalarDisposable(m mVar) {
        this.downstream = mVar;
    }

    @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, d7.e
    public final void clear() {
        lazySet(FUSED_CONSUMED);
        this.value = null;
    }

    public final void complete() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.downstream.onComplete();
    }

    public final void complete(T t10) {
        int i10 = get();
        if ((i10 & 54) != 0) {
            return;
        }
        m mVar = this.downstream;
        if (i10 == FUSED_EMPTY) {
            this.value = t10;
            lazySet(FUSED_READY);
            mVar.onNext(null);
        } else {
            lazySet(2);
            mVar.onNext(t10);
        }
        if (get() != DISPOSED) {
            mVar.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, y6.b
    public void dispose() {
        set(DISPOSED);
        this.value = null;
    }

    public final void error(Throwable th) {
        if ((get() & 54) != 0) {
            f7.a.o(th);
        } else {
            lazySet(2);
            this.downstream.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, y6.b
    public final boolean isDisposed() {
        return get() == DISPOSED;
    }

    @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, d7.e
    public final boolean isEmpty() {
        return get() != FUSED_READY;
    }

    @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, d7.e
    public final T poll() {
        if (get() != FUSED_READY) {
            return null;
        }
        T t10 = this.value;
        this.value = null;
        lazySet(FUSED_CONSUMED);
        return t10;
    }

    @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, d7.b
    public final int requestFusion(int i10) {
        if ((i10 & 2) == 0) {
            return 0;
        }
        lazySet(FUSED_EMPTY);
        return 2;
    }

    public final boolean tryDispose() {
        return getAndSet(DISPOSED) != DISPOSED;
    }
}
