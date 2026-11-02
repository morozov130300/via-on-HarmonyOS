package wb;

import okhttp3.s;
import okhttp3.u;
import okhttp3.w;
import okhttp3.y;
import xb.g;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements s {

    /* renamed from: a, reason: collision with root package name */
    public final u f13407a;

    public a(u uVar) {
        this.f13407a = uVar;
    }

    @Override // okhttp3.s
    public y a(s.a aVar) {
        g gVar = (g) aVar;
        w wVarE = gVar.e();
        f fVarK = gVar.k();
        return gVar.j(wVarE, fVarK, fVarK.i(this.f13407a, aVar, !wVarE.f().equals("GET")), fVarK.d());
    }
}
