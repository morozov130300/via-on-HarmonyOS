package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ea implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ qa f4774c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ pa f4775e;

    public ea(pa paVar, qa qaVar) {
        this.f4775e = paVar;
        this.f4774c = qaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        pa.k0(this.f4775e, this.f4774c);
        this.f4775e.x();
    }
}
