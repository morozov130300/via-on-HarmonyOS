package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class n8 extends n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d9 f5147e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n8(d9 d9Var, c6 c6Var) {
        super(c6Var);
        this.f5147e = d9Var;
    }

    @Override // g2.n
    public final void c() {
        d9 d9Var = this.f5147e;
        d9Var.h();
        if (d9Var.z()) {
            d9Var.f4646a.d().v().a("Inactivity, disconnecting from the service");
            d9Var.Q();
        }
    }
}
