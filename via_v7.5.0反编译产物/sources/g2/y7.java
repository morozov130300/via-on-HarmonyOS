package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class y7 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v7 f5467c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ v7 f5468e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f5469m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f5470n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ d8 f5471o;

    public y7(d8 d8Var, v7 v7Var, v7 v7Var2, long j10, boolean z10) {
        this.f5471o = d8Var;
        this.f5467c = v7Var;
        this.f5468e = v7Var2;
        this.f5469m = j10;
        this.f5470n = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5471o.o(this.f5467c, this.f5468e, this.f5469m, this.f5470n, null);
    }
}
