package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v7 f4673c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f4674e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d8 f4675m;

    public b8(d8 d8Var, v7 v7Var, long j10) {
        this.f4675m = d8Var;
        this.f4673c = v7Var;
        this.f4674e = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4675m.p(this.f4673c, false, this.f4674e);
        d8 d8Var = this.f4675m;
        d8Var.f4705e = null;
        d8Var.f4646a.L().u(null);
    }
}
