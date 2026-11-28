package io.noties.markwon.core;

import e6.q;
import e6.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oc.p;
import oc.r;
import oc.t;
import oc.u;
import oc.v;
import oc.w;
import oc.x;
import oc.y;
import oc.z;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends e6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f6429a = new ArrayList(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6430b;

    /* JADX INFO: renamed from: io.noties.markwon.core.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0079a implements e6.l.c {
        @Override // e6.l.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e6.l lVar, z zVar) {
            lVar.C(zVar);
            int length = lVar.length();
            lVar.builder().append((char) 160);
            lVar.z(zVar, length);
            lVar.u(zVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements e6.l.c {
        @Override // e6.l.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e6.l lVar, oc.k kVar) {
            lVar.C(kVar);
            int length = lVar.length();
            lVar.B(kVar);
            CoreProps.f6424d.d(lVar.E(), Integer.valueOf(kVar.n()));
            lVar.z(kVar, length);
            lVar.u(kVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements e6.l.c {
        @Override // e6.l.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e6.l lVar, w wVar) {
            lVar.builder().append(' ');
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements e6.l.c {
        @Override // e6.l.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e6.l lVar, oc.j jVar) {
            lVar.v();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e implements e6.l.c {
        @Override // e6.l.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e6.l lVar, v vVar) {
            boolean zX = a.x(vVar);
            if (!zX) {
                lVar.C(vVar);
            }
            int length = lVar.length();
            lVar.B(vVar);
            CoreProps.f6426f.d(lVar.E(), Boolean.valueOf(zX));
            lVar.z(vVar, length);
            if (zX) {
                return;
            }
            lVar.u(vVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class f implements e6.l.c {
        @Override // e6.l.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e6.l lVar, p pVar) {
            int length = lVar.length();
            lVar.B(pVar);
            CoreProps.f6425e.d(lVar.E(), pVar.m());
            lVar.z(pVar, length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class g implements e6.l.c {
        public g() {
        }

        @Override // e6.l.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e6.l lVar, y yVar) {
            String strM = yVar.m();
            lVar.builder().d(strM);
            if (a.this.f6429a.isEmpty()) {
                return;
            }
            lVar.length();
            strM.length();
            Iterator it = a.this.f6429a.iterator();
            if (it.hasNext()) {
                n.g.a(it.next());
                throw null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class h implements e6.l.c {
        @Override // e6.l.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e6.l lVar, x xVar) {
            int length = lVar.length();
            lVar.B(xVar);
            lVar.z(xVar, length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class i implements e6.l.c {
        @Override // e6.l.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e6.l lVar, oc.h hVar) {
            int length = lVar.length();
            lVar.B(hVar);
            lVar.z(hVar, length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class j implements e6.l.c {
        @Override // e6.l.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e6.l lVar, oc.b bVar) {
            lVar.C(bVar);
            int length = lVar.length();
            lVar.B(bVar);
            lVar.z(bVar, length);
            lVar.u(bVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class k implements e6.l.c {
        @Override // e6.l.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e6.l lVar, oc.d dVar) {
            int length = lVar.length();
            lVar.builder().append((char) 160).d(dVar.m()).append((char) 160);
            lVar.z(dVar, length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class l implements e6.l.c {
        @Override // e6.l.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e6.l lVar, oc.i iVar) {
            a.H(lVar, iVar.q(), iVar.r(), iVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class m implements e6.l.c {
        @Override // e6.l.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e6.l lVar, oc.o oVar) {
            a.H(lVar, null, oVar.n(), oVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class n implements e6.l.c {
        @Override // e6.l.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e6.l lVar, oc.n nVar) {
            s sVarA = lVar.m().c().a(oc.n.class);
            if (sVarA == null) {
                lVar.B(nVar);
                return;
            }
            int length = lVar.length();
            lVar.B(nVar);
            if (length == lVar.length()) {
                lVar.builder().append((char) 65532);
            }
            e6.g gVarM = lVar.m();
            boolean z10 = nVar.f() instanceof p;
            String strB = gVarM.a().b(nVar.m());
            q qVarE = lVar.E();
            j6.d.f6731a.d(qVarE, strB);
            j6.d.f6732b.d(qVarE, Boolean.valueOf(z10));
            j6.d.f6733c.d(qVarE, null);
            lVar.c(length, sVarA.a(gVarM, qVarE));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class o implements e6.l.c {
        @Override // e6.l.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e6.l lVar, oc.s sVar) {
            int length = lVar.length();
            lVar.B(sVar);
            oc.a aVarF = sVar.f();
            if (aVarF instanceof u) {
                u uVar = (u) aVarF;
                int iQ = uVar.q();
                CoreProps.f6421a.d(lVar.E(), CoreProps.ListItemType.ORDERED);
                CoreProps.f6423c.d(lVar.E(), Integer.valueOf(iQ));
                uVar.s(uVar.q() + 1);
            } else {
                CoreProps.f6421a.d(lVar.E(), CoreProps.ListItemType.BULLET);
                CoreProps.f6422b.d(lVar.E(), Integer.valueOf(a.A(sVar)));
            }
            lVar.z(sVar, length);
            if (lVar.p(sVar)) {
                lVar.v();
            }
        }
    }

    public static int A(t tVar) {
        int i10 = 0;
        for (t tVarF = tVar.f(); tVarF != null; tVarF = tVarF.f()) {
            if (tVarF instanceof oc.s) {
                i10++;
            }
        }
        return i10;
    }

    public static void B(e6.l.b bVar) {
        bVar.a(u.class, new f6.b());
    }

    public static void C(e6.l.b bVar) {
        bVar.a(v.class, new e());
    }

    public static void D(e6.l.b bVar) {
        bVar.a(w.class, new c());
    }

    public static void E(e6.l.b bVar) {
        bVar.a(x.class, new h());
    }

    public static void G(e6.l.b bVar) {
        bVar.a(z.class, new C0079a());
    }

    public static void H(e6.l lVar, String str, String str2, t tVar) {
        lVar.C(tVar);
        int length = lVar.length();
        lVar.builder().append((char) 160).append('\n').append(lVar.m().d().a(str, str2));
        lVar.v();
        lVar.builder().append((char) 160);
        CoreProps.f6427g.d(lVar.E(), str);
        lVar.z(tVar, length);
        lVar.u(tVar);
    }

    public static void m(e6.l.b bVar) {
        bVar.a(oc.b.class, new j());
    }

    public static void n(e6.l.b bVar) {
        bVar.a(oc.c.class, new f6.b());
    }

    public static void o(e6.l.b bVar) {
        bVar.a(oc.d.class, new k());
    }

    public static a p() {
        return new a();
    }

    public static void q(e6.l.b bVar) {
        bVar.a(oc.h.class, new i());
    }

    public static void r(e6.l.b bVar) {
        bVar.a(oc.i.class, new l());
    }

    public static void s(e6.l.b bVar) {
        bVar.a(oc.j.class, new d());
    }

    public static void u(e6.l.b bVar) {
        bVar.a(oc.k.class, new b());
    }

    public static void v(e6.l.b bVar) {
        bVar.a(oc.n.class, new n());
    }

    public static void w(e6.l.b bVar) {
        bVar.a(oc.o.class, new m());
    }

    public static boolean x(v vVar) {
        oc.a aVarF = vVar.f();
        if (aVarF == null) {
            return false;
        }
        t tVarF = aVarF.f();
        if (tVarF instanceof r) {
            return ((r) tVarF).n();
        }
        return false;
    }

    public static void y(e6.l.b bVar) {
        bVar.a(p.class, new f());
    }

    public static void z(e6.l.b bVar) {
        bVar.a(oc.s.class, new o());
    }

    public final void F(e6.l.b bVar) {
        bVar.a(y.class, new g());
    }

    @Override // e6.a, e6.i
    public void e(e6.j.a aVar) {
        g6.b bVar = new g6.b();
        aVar.a(x.class, new g6.h()).a(oc.h.class, new g6.d()).a(oc.b.class, new g6.a()).a(oc.d.class, new g6.c()).a(oc.i.class, bVar).a(oc.o.class, bVar).a(oc.s.class, new g6.g()).a(oc.k.class, new g6.e()).a(p.class, new g6.f()).a(z.class, new g6.i());
    }

    @Override // e6.a, e6.i
    public void g(e6.l.b bVar) {
        F(bVar);
        E(bVar);
        q(bVar);
        m(bVar);
        o(bVar);
        r(bVar);
        w(bVar);
        v(bVar);
        n(bVar);
        B(bVar);
        z(bVar);
        G(bVar);
        u(bVar);
        D(bVar);
        s(bVar);
        C(bVar);
        y(bVar);
    }

    public a t(boolean z10) {
        this.f6430b = z10;
        return this;
    }
}
