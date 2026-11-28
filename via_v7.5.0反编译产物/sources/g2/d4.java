package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d4 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f4699c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ e4 f4700e;

    public d4(e4 e4Var, boolean z10) {
        this.f4700e = e4Var;
        this.f4699c = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4700e.f4724a.o(this.f4699c);
    }
}
