package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c6 f5077c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ n f5078e;

    public m(n nVar, c6 c6Var) {
        this.f5078e = nVar;
        this.f5077c = c6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5077c.b();
        if (c.a()) {
            this.f5077c.f().z(this);
            return;
        }
        boolean zE = this.f5078e.e();
        this.f5078e.f5132c = 0L;
        if (zE) {
            this.f5078e.c();
        }
    }
}
