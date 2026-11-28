package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class ba extends aa {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4677c;

    public ba(pa paVar) {
        super(paVar);
        this.f4655b.r();
    }

    public final void i() {
        if (!k()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void j() {
        if (this.f4677c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        l();
        this.f4655b.m();
        this.f4677c = true;
    }

    public final boolean k() {
        return this.f4677c;
    }

    public abstract boolean l();
}
