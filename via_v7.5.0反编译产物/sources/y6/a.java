package y6;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements r6.b, s6.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f14853c = new AtomicReference();

    @Override // s6.b
    public final void dispose() {
        DisposableHelper.dispose(this.f14853c);
    }

    @Override // s6.b
    public final boolean isDisposed() {
        return this.f14853c.get() == DisposableHelper.DISPOSED;
    }

    @Override // r6.b
    public final void onSubscribe(s6.b bVar) {
        if (io.reactivex.rxjava3.internal.util.b.c(this.f14853c, bVar, getClass())) {
            a();
        }
    }

    public void a() {
    }
}
