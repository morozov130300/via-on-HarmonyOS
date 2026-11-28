package s6;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f12215c = new AtomicReference();

    public boolean a(b bVar) {
        return DisposableHelper.set(this.f12215c, bVar);
    }

    @Override // s6.b
    public void dispose() {
        DisposableHelper.dispose(this.f12215c);
    }

    @Override // s6.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) this.f12215c.get());
    }
}
