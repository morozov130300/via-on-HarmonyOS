package autodispose2;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
enum AutoDisposableHelper implements y6.b {
    DISPOSED;

    public static boolean dispose(AtomicReference<y6.b> atomicReference) {
        y6.b andSet;
        y6.b bVar = atomicReference.get();
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

    @Override // y6.b
    public void dispose() {
    }

    @Override // y6.b
    public boolean isDisposed() {
        return true;
    }
}
