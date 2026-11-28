package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4629c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f4630e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ a2 f4631m;

    public a(a2 a2Var, String str, long j10) {
        this.f4631m = a2Var;
        this.f4629c = str;
        this.f4630e = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a2.i(this.f4631m, this.f4629c, this.f4630e);
    }
}
