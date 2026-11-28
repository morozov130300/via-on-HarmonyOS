package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l3 f5435c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c9 f5436e;

    public x8(c9 c9Var, l3 l3Var) {
        this.f5436e = c9Var;
        this.f5435c = l3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f5436e) {
            try {
                this.f5436e.f4689a = false;
                if (!this.f5436e.f4691c.z()) {
                    this.f5436e.f4691c.f4646a.d().v().a("Connected to service");
                    this.f5436e.f4691c.x(this.f5435c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
