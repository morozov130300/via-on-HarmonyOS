package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class c4 extends b3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4682b;

    public c4(h5 h5Var) {
        super(h5Var);
        this.f4646a.i();
    }

    public final void i() {
        if (!m()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void j() {
        if (this.f4682b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (n()) {
            return;
        }
        this.f4646a.g();
        this.f4682b = true;
    }

    public final void k() {
        if (this.f4682b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        l();
        this.f4646a.g();
        this.f4682b = true;
    }

    public final boolean m() {
        return this.f4682b;
    }

    public abstract boolean n();

    public void l() {
    }
}
