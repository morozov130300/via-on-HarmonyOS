package v9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u9.m f13440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u9.l f13441b;

    public a(u9.m mVar, u9.l lVar) {
        this.f13440a = mVar;
        this.f13441b = lVar;
    }

    @Override // v9.g
    public void a() {
        u9.a aVar = new u9.a(u9.a.f12907b);
        aVar.D(this.f13440a.getBoolean("hidestatus", aVar.f()));
        aVar.A(this.f13440a.getBoolean("colormode", aVar.i()));
        aVar.x(this.f13440a.getBoolean("autovideobtn", aVar.f()));
        aVar.N(this.f13440a.getBoolean("volume", aVar.v()));
        aVar.F(this.f13440a.getBoolean("pulltorefresh", aVar.n()));
        aVar.y(this.f13440a.getBoolean("backforwardgesture", aVar.g()));
        aVar.z(this.f13440a.getBoolean("builtin", aVar.h()));
        this.f13441b.Z(aVar);
    }

    @Override // v9.g
    public int b() {
        return 9;
    }
}
