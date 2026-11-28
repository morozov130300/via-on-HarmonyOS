package xb;

import java.net.ProtocolException;
import okhttp3.s;
import okhttp3.w;
import okhttp3.y;
import okio.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14666a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a extends okio.f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f14667e;

        public a(p pVar) {
            super(pVar);
        }

        @Override // okio.f, okio.p
        public void L(okio.c cVar, long j10) {
            super.L(cVar, j10);
            this.f14667e += j10;
        }
    }

    public b(boolean z10) {
        this.f14666a = z10;
    }

    @Override // okhttp3.s
    public y a(s.a aVar) throws ProtocolException {
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
                gVar.h().l(gVar.f(), aVar2.f14667e);
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
        int iC = yVarC.c();
        if (iC == 100) {
            yVarC = cVarI.d(false).p(wVarE).h(fVarK.d().k()).q(jCurrentTimeMillis).o(System.currentTimeMillis()).c();
            iC = yVarC.c();
        }
        gVar.h().r(gVar.f(), yVarC);
        y yVarC2 = (this.f14666a && iC == 101) ? yVarC.l().b(ub.c.f12947c).c() : yVarC.l().b(cVarI.c(yVarC)).c();
        if ("close".equalsIgnoreCase(yVarC2.o().c("Connection")) || "close".equalsIgnoreCase(yVarC2.f("Connection"))) {
            fVarK.j();
        }
        if ((iC != 204 && iC != 205) || yVarC2.a().c() <= 0) {
            return yVarC2;
        }
        throw new ProtocolException("HTTP " + iC + " had non-zero Content-Length: " + yVarC2.a().c());
    }
}
