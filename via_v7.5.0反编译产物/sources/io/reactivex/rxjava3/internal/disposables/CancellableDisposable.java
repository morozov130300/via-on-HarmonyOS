package io.reactivex.rxjava3.internal.disposables;

import java.util.concurrent.atomic.AtomicReference;
import s6.b;
import t6.a;
import u6.e;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class CancellableDisposable extends AtomicReference<e> implements b {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(e eVar) {
        super(eVar);
    }

    @Override // s6.b
    public void dispose() {
        e andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Throwable th) {
            a.b(th);
            z6.a.o(th);
        }
    }

    @Override // s6.b
    public boolean isDisposed() {
        return get() == null;
    }
}
