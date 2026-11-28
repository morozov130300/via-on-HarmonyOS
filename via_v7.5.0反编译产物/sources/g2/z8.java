package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class z8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l3 f5493c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c9 f5494e;

    public z8(c9 c9Var, l3 l3Var) {
        this.f5494e = c9Var;
        this.f5493c = l3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f5494e) {
            try {
                this.f5494e.f4689a = false;
                if (!this.f5494e.f4691c.z()) {
                    this.f5494e.f4691c.f4646a.d().q().a("Connected to remote service");
                    this.f5494e.f4691c.x(this.f5493c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
