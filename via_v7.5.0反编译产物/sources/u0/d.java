package u0;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class d implements s6.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f12731c = new AtomicBoolean();

    public abstract void a();

    @Override // s6.b
    public final void dispose() {
        if (this.f12731c.compareAndSet(false, true)) {
            if (b.b()) {
                a();
            } else {
                q6.b.b().d(new Runnable() { // from class: u0.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12730c.a();
                    }
                });
            }
        }
    }

    @Override // s6.b
    public final boolean isDisposed() {
        return this.f12731c.get();
    }
}
