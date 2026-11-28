package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class n9 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f5148c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ u9 f5149e;

    public n9(u9 u9Var, long j10) {
        this.f5149e = u9Var;
        this.f5148c = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u9.q(this.f5149e, this.f5148c);
    }
}
