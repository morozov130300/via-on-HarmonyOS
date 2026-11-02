package io.reactivex.rxjava3.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements d7.a {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // d7.e
    public abstract /* synthetic */ void clear();

    @Override // y6.b
    public abstract /* synthetic */ void dispose();

    @Override // y6.b
    public abstract /* synthetic */ boolean isDisposed();

    @Override // d7.e
    public abstract /* synthetic */ boolean isEmpty();

    @Override // d7.e
    public final boolean offer(T t10) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T t10, T t11) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // d7.e
    public abstract /* synthetic */ Object poll();

    @Override // d7.b
    public abstract /* synthetic */ int requestFusion(int i10);
}
