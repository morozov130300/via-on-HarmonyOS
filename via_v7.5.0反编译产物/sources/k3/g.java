package k3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h2.g f7183a;

    public g(h2.g gVar) {
        this.f7183a = gVar;
    }

    @Override // k3.i
    public boolean a(Exception exc) {
        return false;
    }

    @Override // k3.i
    public boolean b(com.google.firebase.installations.local.b bVar) {
        if (!bVar.l() && !bVar.k() && !bVar.i()) {
            return false;
        }
        this.f7183a.e(bVar.d());
        return true;
    }
}
