package vb;

import okhttp3.Protocol;
import okhttp3.q;
import okhttp3.s;
import okhttp3.w;
import okhttp3.y;
import vb.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements s {
    public a(c cVar) {
    }

    public static q b(q qVar, q qVar2) {
        q.a aVar = new q.a();
        int iJ = qVar.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            String strE = qVar.e(i10);
            String strK = qVar.k(i10);
            if ((!"Warning".equalsIgnoreCase(strE) || !strK.startsWith("1")) && (c(strE) || !d(strE) || qVar2.c(strE) == null)) {
                ub.a.f12933a.b(aVar, strE, strK);
            }
        }
        int iJ2 = qVar2.j();
        for (int i11 = 0; i11 < iJ2; i11++) {
            String strE2 = qVar2.e(i11);
            if (!c(strE2) && d(strE2)) {
                ub.a.f12933a.b(aVar, strE2, qVar2.k(i11));
            }
        }
        return aVar.d();
    }

    public static boolean c(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    public static boolean d(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static y e(y yVar) {
        return (yVar == null || yVar.a() == null) ? yVar : yVar.l().b(null).c();
    }

    @Override // okhttp3.s
    public y a(s.a aVar) {
        b bVarC = new b.a(System.currentTimeMillis(), aVar.e(), null).c();
        w wVar = bVarC.f13193a;
        y yVar = bVarC.f13194b;
        if (wVar == null && yVar == null) {
            return new y.a().p(aVar.e()).n(Protocol.HTTP_1_1).g(504).k("Unsatisfiable Request (only-if-cached)").b(ub.c.f12937c).q(-1L).o(System.currentTimeMillis()).c();
        }
        if (wVar == null) {
            return yVar.l().d(e(yVar)).c();
        }
        y yVarC = aVar.c(wVar);
        if (yVar != null) {
            if (yVarC.d() == 304) {
                yVar.l().j(b(yVar.i(), yVarC.i())).q(yVarC.p()).o(yVarC.n()).d(e(yVar)).l(e(yVarC)).c();
                yVarC.a().close();
                throw null;
            }
            ub.c.g(yVar.a());
        }
        return yVarC.l().d(e(yVar)).l(e(yVarC)).c();
    }
}
