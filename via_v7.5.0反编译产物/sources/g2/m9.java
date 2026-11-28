package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class m9 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f5122c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ u9 f5123e;

    public m9(u9 u9Var, long j10) {
        this.f5123e = u9Var;
        this.f5122c = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u9.r(this.f5123e, this.f5122c);
    }
}
