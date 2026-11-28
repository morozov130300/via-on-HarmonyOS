package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class z0 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f5477c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a2 f5478e;

    public z0(a2 a2Var, long j10) {
        this.f5478e = a2Var;
        this.f5477c = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5478e.q(this.f5477c);
    }
}
