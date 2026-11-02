package xb;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.s;
import okhttp3.w;
import okhttp3.y;
import okio.p;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b implements s {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f14320a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a extends okio.f {

        /* renamed from: j, reason: collision with root package name */
        public long f14321j;

        public a(p pVar) {
            super(pVar);
        }

        @Override // okio.f, okio.p
        public void I(okio.c cVar, long j10) {
            super.I(cVar, j10);
            this.f14321j += j10;
        }
    }

    public b(boolean z10) {
        this.f14320a = z10;
    }

    @Override // okhttp3.s
    public y a(s.a aVar) throws IOException {
        g gVar = (g) aVar;
        c cVarI = gVar.i();
        wb.f fVarK = gVar.k();
        wb.c cVar = (wb.c) gVar.g();
        w wVarE = gVar.e();
        long jCurrentTimeMillis = System.currentTimeMillis();
        gVar.h().o(gVar.f());
        cVarI.b(wVarE);
        gVar.h().n(gVar.f(), wVarE);
        y.a aVarD = null;
        if (f.a(wVarE.f()) && wVarE.a() != null) {
            if ("100-continue".equalsIgnoreCase(wVarE.c("Expect"))) {
                cVarI.e();
                gVar.h().s(gVar.f());
                aVarD = cVarI.d(true);
            }
            if (aVarD == null) {
                gVar.h().m(gVar.f());
                a aVar2 = new a(cVarI.f(wVarE, wVarE.a().a()));
                okio.d dVarA = okio.k.a(aVar2);
                wVarE.a().g(dVarA);
                dVarA.close();
                gVar.h().l(gVar.f(), aVar2.f14321j);
            } else if (!cVar.n()) {
                fVarK.j();
            }
        }
        cVarI.a();
        if (aVarD == null) {
            gVar.h().s(gVar.f());
            aVarD = cVarI.d(false);
        }
        y yVarC = aVarD.p(wVarE).h(fVarK.d().k()).q(jCurrentTimeMillis).o(System.currentTimeMillis()).c();
        int iD = yVarC.d();
        if (iD == 100) {
            yVarC = cVarI.d(false).p(wVarE).h(fVarK.d().k()).q(jCurrentTimeMillis).o(System.currentTimeMillis()).c();
            iD = yVarC.d();
        }
        gVar.h().r(gVar.f(), yVarC);
        y yVarC2 = (this.f14320a && iD == 101) ? yVarC.l().b(ub.c.f12937c).c() : yVarC.l().b(cVarI.c(yVarC)).c();
        if ("close".equalsIgnoreCase(yVarC2.o().c("Connection")) || "close".equalsIgnoreCase(yVarC2.g("Connection"))) {
            fVarK.j();
        }
        if ((iD != 204 && iD != 205) || yVarC2.a().d() <= 0) {
            return yVarC2;
        }
        throw new ProtocolException("HTTP " + iD + " had non-zero Content-Length: " + yVarC2.a().d());
    }
}
