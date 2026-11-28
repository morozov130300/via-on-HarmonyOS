package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5441c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f5442e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ a2 f5443m;

    public y(a2 a2Var, String str, long j10) {
        this.f5443m = a2Var;
        this.f5441c = str;
        this.f5442e = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a2.j(this.f5443m, this.f5441c, this.f5442e);
    }
}
