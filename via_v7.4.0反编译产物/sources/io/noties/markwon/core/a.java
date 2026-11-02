package io.noties.markwon.core;

import io.noties.markwon.core.CoreProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k6.j;
import k6.l;
import k6.q;
import k6.s;
import kc.p;
import kc.r;
import kc.t;
import kc.u;
import kc.v;
import kc.w;
import kc.x;
import kc.y;
import kc.z;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a extends k6.a {

    /* renamed from: a, reason: collision with root package name */
    public final List f7198a = new ArrayList(0);

    /* renamed from: b, reason: collision with root package name */
    public boolean f7199b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: io.noties.markwon.core.a$a, reason: collision with other inner class name */
    public class C0083a implements l.c {
        @Override // k6.l.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k6.l lVar, z zVar) {
            lVar.r(zVar);
            int length = lVar.length();
            lVar.builder().append('\u00a0');
            lVar.B(zVar, length);
            lVar.j(zVar);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements l.c {
        @Override // k6.l.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k6.l lVar, kc.k kVar) {
            lVar.r(kVar);
            int length = lVar.length();
            lVar.e(kVar);
            CoreProps.f7193d.d(lVar.D(), Integer.valueOf(kVar.n()));
            lVar.B(kVar, length);
            lVar.j(kVar);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements l.c {
        @Override // k6.l.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k6.l lVar, w wVar) {
            lVar.builder().append(' ');
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements l.c {
        @Override // k6.l.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k6.l lVar, kc.j jVar) {
            lVar.v();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class e implements l.c {
        @Override // k6.l.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k6.l lVar, v vVar) {
            boolean zX = a.x(vVar);
            if (!zX) {
                lVar.r(vVar);
            }
            int length = lVar.length();
            lVar.e(vVar);
            CoreProps.f7195f.d(lVar.D(), Boolean.valueOf(zX));
            lVar.B(vVar, length);
            if (zX) {
                return;
            }
            lVar.j(vVar);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class f implements l.c {
        @Override // k6.l.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k6.l lVar, p pVar) {
            int length = lVar.length();
            lVar.e(pVar);
            CoreProps.f7194e.d(lVar.D(), pVar.m());
            lVar.B(pVar, length);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class g implements l.c {
        public g() {
        }

        @Override // k6.l.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k6.l lVar, y yVar) {
            String strM = yVar.m();
            lVar.builder().d(strM);
            if (a.this.f7198a.isEmpty()) {
                return;
            }
            lVar.length();
            strM.length();
            Iterator it = a.this.f7198a.iterator();
            if (it.hasNext()) {
                n.g.a(it.next());
                throw null;
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class h implements l.c {
        @Override // k6.l.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k6.l lVar, x xVar) {
            int length = lVar.length();
            lVar.e(xVar);
            lVar.B(xVar, length);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class i implements l.c {
        @Override // k6.l.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k6.l lVar, kc.h hVar) {
            int length = lVar.length();
            lVar.e(hVar);
            lVar.B(hVar, length);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class j implements l.c {
        @Override // k6.l.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k6.l lVar, kc.b bVar) {
            lVar.r(bVar);
            int length = lVar.length();
            lVar.e(bVar);
            lVar.B(bVar, length);
            lVar.j(bVar);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class k implements l.c {
        @Override // k6.l.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k6.l lVar, kc.d dVar) {
            int length = lVar.length();
            lVar.builder().append('\u00a0').d(dVar.m()).append('\u00a0');
            lVar.B(dVar, length);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class l implements l.c {
        @Override // k6.l.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k6.l lVar, kc.i iVar) {
            a.H(lVar, iVar.q(), iVar.r(), iVar);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class m implements l.c {
        @Override // k6.l.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k6.l lVar, kc.o oVar) {
            a.H(lVar, null, oVar.n(), oVar);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class n implements l.c {
        @Override // k6.l.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k6.l lVar, kc.n nVar) {
            s sVarA = lVar.p().c().a(kc.n.class);
            if (sVarA == null) {
                lVar.e(nVar);
                return;
            }
            int length = lVar.length();
            lVar.e(nVar);
            if (length == lVar.length()) {
                lVar.builder().append('\ufffc');
            }
            k6.g gVarP = lVar.p();
            boolean z10 = nVar.f() instanceof p;
            String strB = gVarP.a().b(nVar.m());
            q qVarD = lVar.D();
            p6.d.f10969a.d(qVarD, strB);
            p6.d.f10970b.d(qVarD, Boolean.valueOf(z10));
            p6.d.f10971c.d(qVarD, null);
            lVar.f(length, sVarA.a(gVarP, qVarD));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class o implements l.c {
        @Override // k6.l.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k6.l lVar, kc.s sVar) {
            int length = lVar.length();
            lVar.e(sVar);
            kc.a aVarF = sVar.f();
            if (aVarF instanceof u) {
                u uVar = (u) aVarF;
                int iQ = uVar.q();
                CoreProps.f7190a.d(lVar.D(), CoreProps.ListItemType.ORDERED);
                CoreProps.f7192c.d(lVar.D(), Integer.valueOf(iQ));
                uVar.s(uVar.q() + 1);
            } else {
                CoreProps.f7190a.d(lVar.D(), CoreProps.ListItemType.BULLET);
                CoreProps.f7191b.d(lVar.D(), Integer.valueOf(a.A(sVar)));
            }
            lVar.B(sVar, length);
            if (lVar.G(sVar)) {
                lVar.v();
            }
        }
    }

    public static int A(t tVar) {
        int i10 = 0;
        for (t tVarF = tVar.f(); tVarF != null; tVarF = tVarF.f()) {
            if (tVarF instanceof kc.s) {
                i10++;
            }
        }
        return i10;
    }

    public static void B(l.b bVar) {
        bVar.b(u.class, new l6.b());
    }

    public static void C(l.b bVar) {
        bVar.b(v.class, new e());
    }

    public static void D(l.b bVar) {
        bVar.b(w.class, new c());
    }

    public static void E(l.b bVar) {
        bVar.b(x.class, new h());
    }

    public static void G(l.b bVar) {
        bVar.b(z.class, new C0083a());
    }

    public static void H(k6.l lVar, String str, String str2, t tVar) {
        lVar.r(tVar);
        int length = lVar.length();
        lVar.builder().append('\u00a0').append('\n').append(lVar.p().d().a(str, str2));
        lVar.v();
        lVar.builder().append('\u00a0');
        CoreProps.f7196g.d(lVar.D(), str);
        lVar.B(tVar, length);
        lVar.j(tVar);
    }

    public static void m(l.b bVar) {
        bVar.b(kc.b.class, new j());
    }

    public static void n(l.b bVar) {
        bVar.b(kc.c.class, new l6.b());
    }

    public static void o(l.b bVar) {
        bVar.b(kc.d.class, new k());
    }

    public static a p() {
        return new a();
    }

    public static void q(l.b bVar) {
        bVar.b(kc.h.class, new i());
    }

    public static void r(l.b bVar) {
        bVar.b(kc.i.class, new l());
    }

    public static void s(l.b bVar) {
        bVar.b(kc.j.class, new d());
    }

    public static void u(l.b bVar) {
        bVar.b(kc.k.class, new b());
    }

    public static void v(l.b bVar) {
        bVar.b(kc.n.class, new n());
    }

    public static void w(l.b bVar) {
        bVar.b(kc.o.class, new m());
    }

    public static boolean x(v vVar) {
        kc.a aVarF = vVar.f();
        if (aVarF == null) {
            return false;
        }
        t tVarF = aVarF.f();
        if (tVarF instanceof r) {
            return ((r) tVarF).n();
        }
        return false;
    }

    public static void y(l.b bVar) {
        bVar.b(p.class, new f());
    }

    public static void z(l.b bVar) {
        bVar.b(kc.s.class, new o());
    }

    public final void F(l.b bVar) {
        bVar.b(y.class, new g());
    }

    @Override // k6.a, k6.i
    public void b(l.b bVar) {
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

    @Override // k6.a, k6.i
    public void f(j.a aVar) {
        m6.b bVar = new m6.b();
        aVar.a(x.class, new m6.h()).a(kc.h.class, new m6.d()).a(kc.b.class, new m6.a()).a(kc.d.class, new m6.c()).a(kc.i.class, bVar).a(kc.o.class, bVar).a(kc.s.class, new m6.g()).a(kc.k.class, new m6.e()).a(p.class, new m6.f()).a(z.class, new m6.i());
    }

    public a t(boolean z10) {
        this.f7199b = z10;
        return this;
    }
}
