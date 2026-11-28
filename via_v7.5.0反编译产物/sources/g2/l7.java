package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l7 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f5072c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o7 f5073e;

    public l7(o7 o7Var, boolean z10) {
        this.f5073e = o7Var;
        this.f5072c = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zO = this.f5073e.f4646a.o();
        boolean zN = this.f5073e.f4646a.n();
        this.f5073e.f4646a.k(this.f5072c);
        if (zN == this.f5072c) {
            this.f5073e.f4646a.d().v().b("Default data collection state already set to", Boolean.valueOf(this.f5072c));
        }
        if (this.f5073e.f4646a.o() == zO || this.f5073e.f4646a.o() != this.f5073e.f4646a.n()) {
            this.f5073e.f4646a.d().x().c("Default data collection is different than actual status", Boolean.valueOf(this.f5072c), Boolean.valueOf(zO));
        }
        this.f5073e.P();
    }
}
