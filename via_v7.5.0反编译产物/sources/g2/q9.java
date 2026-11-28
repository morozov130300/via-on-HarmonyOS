package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p9 f5258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u9 f5259b;

    public q9(u9 u9Var) {
        this.f5259b = u9Var;
    }

    public final void a(long j10) {
        this.f5258a = new p9(this, this.f5259b.f4646a.a().a(), j10);
        this.f5259b.f5354c.postDelayed(this.f5258a, 2000L);
    }

    public final void b() {
        this.f5259b.h();
        p9 p9Var = this.f5258a;
        if (p9Var != null) {
            this.f5259b.f5354c.removeCallbacks(p9Var);
        }
        this.f5259b.f4646a.F().f5060r.a(false);
        this.f5259b.s(false);
    }
}
