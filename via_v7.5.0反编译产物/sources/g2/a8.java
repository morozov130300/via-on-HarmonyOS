package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f4652c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d8 f4653e;

    public a8(d8 d8Var, long j10) {
        this.f4653e = d8Var;
        this.f4652c = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4653e.f4646a.y().n(this.f4652c);
        this.f4653e.f4705e = null;
    }
}
