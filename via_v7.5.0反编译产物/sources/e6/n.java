package e6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import oc.u;
import oc.v;
import oc.w;
import oc.x;
import oc.y;
import oc.z;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f4249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f4250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f4251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f4252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l.a f4253e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a implements l.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f4254a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public l.a f4255b;

        @Override // e6.l.b
        public l.b a(Class cls, l.c cVar) {
            if (cVar == null) {
                this.f4254a.remove(cls);
                return this;
            }
            this.f4254a.put(cls, cVar);
            return this;
        }

        @Override // e6.l.b
        public l b(g gVar, q qVar) {
            l.a bVar = this.f4255b;
            if (bVar == null) {
                bVar = new b();
            }
            return new n(gVar, qVar, new t(), Collections.unmodifiableMap(this.f4254a), bVar);
        }
    }

    public n(g gVar, q qVar, t tVar, Map map, l.a aVar) {
        this.f4249a = gVar;
        this.f4250b = qVar;
        this.f4251c = tVar;
        this.f4252d = map;
        this.f4253e = aVar;
    }

    @Override // oc.a0
    public void A(oc.d dVar) {
        I(dVar);
    }

    @Override // e6.l
    public void B(oc.t tVar) {
        oc.t tVarC = tVar.c();
        while (tVarC != null) {
            oc.t tVarE = tVarC.e();
            tVarC.a(this);
            tVarC = tVarE;
        }
    }

    @Override // e6.l
    public void C(oc.t tVar) {
        this.f4253e.b(this, tVar);
    }

    @Override // oc.a0
    public void D(oc.p pVar) {
        I(pVar);
    }

    @Override // e6.l
    public q E() {
        return this.f4250b;
    }

    @Override // oc.a0
    public void F(z zVar) {
        I(zVar);
    }

    @Override // oc.a0
    public void G(oc.f fVar) {
        I(fVar);
    }

    public void H(Class cls, int i10) {
        s sVarA = this.f4249a.c().a(cls);
        if (sVarA != null) {
            c(i10, sVarA.a(this.f4249a, this.f4250b));
        }
    }

    public final void I(oc.t tVar) {
        l.c cVar = (l.c) this.f4252d.get(tVar.getClass());
        if (cVar != null) {
            cVar.a(this, tVar);
        } else {
            B(tVar);
        }
    }

    @Override // oc.a0
    public void a(y yVar) {
        I(yVar);
    }

    @Override // oc.a0
    public void b(oc.g gVar) {
        I(gVar);
    }

    @Override // e6.l
    public t builder() {
        return this.f4251c;
    }

    @Override // e6.l
    public void c(int i10, Object obj) {
        t tVar = this.f4251c;
        t.k(tVar, obj, i10, tVar.length());
    }

    @Override // oc.a0
    public void d(oc.h hVar) {
        I(hVar);
    }

    @Override // oc.a0
    public void e(oc.i iVar) {
        I(iVar);
    }

    @Override // oc.a0
    public void f(w wVar) {
        I(wVar);
    }

    @Override // oc.a0
    public void g(x xVar) {
        I(xVar);
    }

    @Override // oc.a0
    public void h(oc.q qVar) {
        I(qVar);
    }

    @Override // oc.a0
    public void i(oc.o oVar) {
        I(oVar);
    }

    @Override // oc.a0
    public void j(oc.s sVar) {
        I(sVar);
    }

    @Override // oc.a0
    public void k(oc.n nVar) {
        I(nVar);
    }

    @Override // oc.a0
    public void l(oc.j jVar) {
        I(jVar);
    }

    @Override // e6.l
    public int length() {
        return this.f4251c.length();
    }

    @Override // e6.l
    public g m() {
        return this.f4249a;
    }

    @Override // e6.l
    public void n() {
        this.f4251c.append('\n');
    }

    @Override // oc.a0
    public void o(u uVar) {
        I(uVar);
    }

    @Override // e6.l
    public boolean p(oc.t tVar) {
        return tVar.e() != null;
    }

    @Override // oc.a0
    public void q(oc.b bVar) {
        I(bVar);
    }

    @Override // oc.a0
    public void r(v vVar) {
        I(vVar);
    }

    @Override // oc.a0
    public void s(oc.c cVar) {
        I(cVar);
    }

    @Override // oc.a0
    public void t(oc.e eVar) {
        I(eVar);
    }

    @Override // e6.l
    public void u(oc.t tVar) {
        this.f4253e.a(this, tVar);
    }

    @Override // e6.l
    public void v() {
        if (this.f4251c.length() <= 0 || '\n' == this.f4251c.h()) {
            return;
        }
        this.f4251c.append('\n');
    }

    @Override // oc.a0
    public void w(oc.m mVar) {
        I(mVar);
    }

    @Override // oc.a0
    public void x(oc.l lVar) {
        I(lVar);
    }

    @Override // oc.a0
    public void y(oc.k kVar) {
        I(kVar);
    }

    @Override // e6.l
    public void z(oc.t tVar, int i10) {
        H(tVar.getClass(), i10);
    }
}
