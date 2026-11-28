package io.reactivex.rxjava3.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements x6.a {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // x6.e
    public abstract /* synthetic */ void clear();

    @Override // s6.b
    public abstract /* synthetic */ void dispose();

    @Override // s6.b
    public abstract /* synthetic */ boolean isDisposed();

    @Override // x6.e
    public abstract /* synthetic */ boolean isEmpty();

    @Override // x6.e
    public final boolean offer(T t10) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // x6.e
    public abstract /* synthetic */ Object poll();

    @Override // x6.b
    public abstract /* synthetic */ int requestFusion(int i10);

    public final boolean offer(T t10, T t11) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
