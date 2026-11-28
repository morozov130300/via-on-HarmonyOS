package n9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class v implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f10807a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f10809c = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f10808b = new m();

    public v(p pVar) {
        this.f10807a = pVar;
    }

    @Override // n9.o
    public void A(List list, l lVar, String str, final h hVar) {
        if (hVar == null) {
            return;
        }
        if (list == null || list.isEmpty()) {
            hVar.a(g.a(101, null));
        } else if (lVar == null) {
            hVar.a(g.a(102, null));
        } else {
            this.f10808b.f(lVar, str, list, null, new h() { // from class: n9.t
                @Override // n9.h
                public final void a(g gVar) {
                    hVar.a(gVar);
                }
            });
        }
    }

    @Override // n9.o
    public g B(List list, String str, String str2) {
        l lVarH;
        if (list == null || list.isEmpty()) {
            return g.a(101, null);
        }
        if (str == null || (lVarH = h(str)) == null) {
            return g.a(102, null);
        }
        try {
            c cVarD = this.f10808b.d(lVarH, str2, list);
            if (cVarD != null && !cVarD.c().isEmpty()) {
                return g.k(((a) cVarD.c().get(0)).c(), ((a) cVarD.c().get(0)).b());
            }
            return g.a(103, null);
        } catch (Exception e10) {
            return g.b(e10);
        }
    }

    @Override // n9.o
    public boolean C() {
        return this.f10808b.c();
    }

    @Override // n9.o
    public void D(List list, String str, String str2, final h hVar) {
        l lVarH;
        if (hVar == null) {
            return;
        }
        if (list == null || list.isEmpty()) {
            hVar.a(g.a(101, null));
        } else if (str == null || (lVarH = h(str)) == null) {
            hVar.a(g.a(102, null));
        } else {
            this.f10808b.f(lVarH, str2, list, null, new h() { // from class: n9.u
                @Override // n9.h
                public final void a(g gVar) {
                    hVar.a(gVar);
                }
            });
        }
    }

    @Override // n9.o
    public boolean a(n nVar) {
        return this.f10807a.a(nVar);
    }

    @Override // n9.o
    public boolean b(String str, l lVar) {
        return this.f10807a.b(str, lVar);
    }

    @Override // n9.o
    public boolean c(q qVar) {
        return this.f10807a.c(qVar);
    }

    @Override // n9.o
    public boolean e(l lVar) {
        return this.f10807a.e(lVar);
    }

    @Override // n9.o
    public boolean f(String str) {
        return this.f10807a.f(str);
    }

    @Override // n9.o
    public boolean g(String str, n nVar) {
        return this.f10807a.g(str, nVar);
    }

    @Override // n9.o
    public l h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.f10807a.h(str);
    }

    @Override // n9.o
    public boolean j(r rVar) {
        return this.f10807a.j(rVar);
    }

    @Override // n9.o
    public List k(int i10) {
        return this.f10807a.k(i10);
    }

    @Override // n9.o
    public boolean l(String[] strArr) {
        return this.f10807a.l(strArr);
    }

    @Override // n9.o
    public boolean m(String str) {
        return this.f10807a.m(str);
    }

    @Override // n9.o
    public boolean n(String str) {
        return this.f10807a.n(str);
    }

    @Override // n9.o
    public boolean o(String str, r rVar) {
        return this.f10807a.o(str, rVar);
    }

    @Override // n9.o
    public List p() {
        return this.f10807a.p();
    }

    @Override // n9.o
    public n q(String str) {
        return this.f10807a.q(str);
    }

    @Override // n9.o
    public boolean r(String str, q qVar) {
        return this.f10807a.r(str, qVar);
    }

    @Override // n9.o
    public r s(String str) {
        return this.f10807a.s(str);
    }

    @Override // n9.o
    public List t() {
        return this.f10807a.t();
    }

    @Override // n9.o
    public List u() {
        return this.f10807a.u();
    }

    @Override // n9.o
    public boolean v(String str) {
        return this.f10807a.v(str);
    }

    @Override // n9.o
    public q w(String str) {
        return this.f10807a.w(str);
    }

    @Override // n9.o
    public List x(String str) {
        return this.f10807a.x(str);
    }

    @Override // n9.o
    public void y(String str, String str2) {
        if (str == null || str2 == null || str.isEmpty() || str2.isEmpty()) {
            return;
        }
        this.f10809c.put(str2, str);
    }

    @Override // n9.o
    public String z(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return (String) this.f10809c.get(str);
    }
}
