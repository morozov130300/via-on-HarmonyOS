package io.reactivex.rxjava3.internal.disposables;

import java.util.concurrent.atomic.AtomicReference;
import y6.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class SequentialDisposable extends AtomicReference<b> implements b {
    private static final long serialVersionUID = -754898800686245608L;

    public SequentialDisposable() {
    }

    public SequentialDisposable(b bVar) {
        lazySet(bVar);
    }

    @Override // y6.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // y6.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public boolean replace(b bVar) {
        return DisposableHelper.replace(this, bVar);
    }

    public boolean update(b bVar) {
        return DisposableHelper.set(this, bVar);
    }
}
