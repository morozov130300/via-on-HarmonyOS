package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j9 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ pa f5006c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Runnable f5007e;

    public j9(l9 l9Var, pa paVar, Runnable runnable) {
        this.f5006c = paVar;
        this.f5007e = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5006c.e();
        this.f5006c.l0(this.f5007e);
        this.f5006c.C();
    }
}
