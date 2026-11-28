package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b6 extends a6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4670b;

    public b6(h5 h5Var) {
        super(h5Var);
        this.f4646a.i();
    }

    public abstract boolean j();

    public final void k() {
        if (!n()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void l() {
        if (this.f4670b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (j()) {
            return;
        }
        this.f4646a.g();
        this.f4670b = true;
    }

    public final void m() {
        if (this.f4670b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        i();
        this.f4646a.g();
        this.f4670b = true;
    }

    public final boolean n() {
        return this.f4670b;
    }

    public void i() {
    }
}
