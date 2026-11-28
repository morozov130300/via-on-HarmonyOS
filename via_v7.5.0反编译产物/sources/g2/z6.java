package g2;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class z6 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5490c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o7 f5491e;

    public z6(o7 o7Var, AtomicReference atomicReference) {
        this.f5491e = o7Var;
        this.f5490c = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f5490c) {
            try {
                try {
                    this.f5490c.set(Boolean.valueOf(this.f5491e.f4646a.z().B(this.f5491e.f4646a.B().s(), i3.M)));
                    this.f5490c.notify();
                } catch (Throwable th) {
                    this.f5490c.notify();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
