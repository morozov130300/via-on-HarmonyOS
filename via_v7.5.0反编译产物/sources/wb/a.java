package wb;

import okhttp3.s;
import okhttp3.u;
import okhttp3.w;
import okhttp3.y;
import xb.g;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f14410a;

    public a(u uVar) {
        this.f14410a = uVar;
    }

    @Override // okhttp3.s
    public y a(s.a aVar) {
        g gVar = (g) aVar;
        w wVarE = gVar.e();
        f fVarK = gVar.k();
        return gVar.j(wVarE, fVarK, fVarK.i(this.f14410a, aVar, !wVarE.f().equals("GET")), fVarK.d());
    }
}
