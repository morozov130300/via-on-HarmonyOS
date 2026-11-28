package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g5 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m6 f4820c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h5 f4821e;

    public g5(h5 h5Var, m6 m6Var) {
        this.f4821e = h5Var;
        this.f4820c = m6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h5.e(this.f4821e, this.f4820c);
        this.f4821e.m(this.f4820c.f5110g);
    }
}
