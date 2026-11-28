package autodispose2;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
enum AutoDisposableHelper implements s6.b {
    DISPOSED;

    @Override // s6.b
    public void dispose() {
    }

    @Override // s6.b
    public boolean isDisposed() {
        return true;
    }

    public static boolean dispose(AtomicReference<s6.b> atomicReference) {
        s6.b andSet;
        s6.b bVar = atomicReference.get();
        AutoDisposableHelper autoDisposableHelper = DISPOSED;
        if (bVar == autoDisposableHelper || (andSet = atomicReference.getAndSet(autoDisposableHelper)) == autoDisposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }
}
