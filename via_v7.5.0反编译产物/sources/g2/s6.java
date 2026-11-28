package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class s6 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f5292c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o7 f5293e;

    public s6(o7 o7Var, long j10) {
        this.f5293e = o7Var;
        this.f5292c = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5293e.f4646a.F().f5053k.b(this.f5292c);
        this.f5293e.f4646a.d().q().b("Session timeout duration set", Long.valueOf(this.f5292c));
    }
}
