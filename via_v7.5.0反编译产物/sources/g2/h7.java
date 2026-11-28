package g2;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h7 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4892c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o7 f4893e;

    public h7(o7 o7Var, AtomicReference atomicReference) {
        this.f4893e = o7Var;
        this.f4892c = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4892c) {
            try {
                try {
                    this.f4892c.set(Double.valueOf(this.f4893e.f4646a.z().k(this.f4893e.f4646a.B().s(), i3.Q)));
                    this.f4892c.notify();
                } catch (Throwable th) {
                    this.f4892c.notify();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
