package h2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f5672c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ u f5673e;

    public t(u uVar, f fVar) {
        this.f5673e = uVar;
        this.f5672c = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f5673e.f5675b) {
            try {
                u uVar = this.f5673e;
                if (uVar.f5676c != null) {
                    uVar.f5676c.c((Exception) u1.f.h(this.f5672c.g()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
