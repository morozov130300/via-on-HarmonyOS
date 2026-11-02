package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public final k.g f1616a = new k.g();

    /* renamed from: b, reason: collision with root package name */
    public final k.d f1617b = new k.d();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: d, reason: collision with root package name */
        public static w.e f1618d = new w.f(20);

        /* renamed from: a, reason: collision with root package name */
        public int f1619a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.l.c f1620b;

        /* renamed from: c, reason: collision with root package name */
        public RecyclerView.l.c f1621c;

        public static void a() {
            while (f1618d.b() != null) {
            }
        }

        public static a b() {
            a aVar = (a) f1618d.b();
            return aVar == null ? new a() : aVar;
        }

        public static void c(a aVar) {
            aVar.f1619a = 0;
            aVar.f1620b = null;
            aVar.f1621c = null;
            f1618d.a(aVar);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void a(RecyclerView.c0 c0Var);

        void b(RecyclerView.c0 c0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.c0 c0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.c0 c0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    public void a(RecyclerView.c0 c0Var, RecyclerView.l.c cVar) {
        a aVarB = (a) this.f1616a.get(c0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f1616a.put(c0Var, aVarB);
        }
        aVarB.f1619a |= 2;
        aVarB.f1620b = cVar;
    }

    public void b(RecyclerView.c0 c0Var) {
        a aVarB = (a) this.f1616a.get(c0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f1616a.put(c0Var, aVarB);
        }
        aVarB.f1619a |= 1;
    }

    public void c(long j10, RecyclerView.c0 c0Var) {
        this.f1617b.n(j10, c0Var);
    }

    public void d(RecyclerView.c0 c0Var, RecyclerView.l.c cVar) {
        a aVarB = (a) this.f1616a.get(c0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f1616a.put(c0Var, aVarB);
        }
        aVarB.f1621c = cVar;
        aVarB.f1619a |= 8;
    }

    public void e(RecyclerView.c0 c0Var, RecyclerView.l.c cVar) {
        a aVarB = (a) this.f1616a.get(c0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f1616a.put(c0Var, aVarB);
        }
        aVarB.f1620b = cVar;
        aVarB.f1619a |= 4;
    }

    public void f() {
        this.f1616a.clear();
        this.f1617b.a();
    }

    public RecyclerView.c0 g(long j10) {
        return (RecyclerView.c0) this.f1617b.e(j10);
    }

    public boolean h(RecyclerView.c0 c0Var) {
        a aVar = (a) this.f1616a.get(c0Var);
        return (aVar == null || (aVar.f1619a & 1) == 0) ? false : true;
    }

    public boolean i(RecyclerView.c0 c0Var) {
        a aVar = (a) this.f1616a.get(c0Var);
        return (aVar == null || (aVar.f1619a & 4) == 0) ? false : true;
    }

    public void j() {
        a.a();
    }

    public void k(RecyclerView.c0 c0Var) {
        p(c0Var);
    }

    public final RecyclerView.l.c l(RecyclerView.c0 c0Var, int i10) {
        a aVar;
        RecyclerView.l.c cVar;
        int iF = this.f1616a.f(c0Var);
        if (iF >= 0 && (aVar = (a) this.f1616a.l(iF)) != null) {
            int i11 = aVar.f1619a;
            if ((i11 & i10) != 0) {
                int i12 = (i10 ^ (-1)) & i11;
                aVar.f1619a = i12;
                if (i10 == 4) {
                    cVar = aVar.f1620b;
                } else {
                    if (i10 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = aVar.f1621c;
                }
                if ((i12 & 12) == 0) {
                    this.f1616a.j(iF);
                    a.c(aVar);
                }
                return cVar;
            }
        }
        return null;
    }

    public RecyclerView.l.c m(RecyclerView.c0 c0Var) {
        return l(c0Var, 8);
    }

    public RecyclerView.l.c n(RecyclerView.c0 c0Var) {
        return l(c0Var, 4);
    }

    public void o(b bVar) {
        for (int size = this.f1616a.size() - 1; size >= 0; size--) {
            RecyclerView.c0 c0Var = (RecyclerView.c0) this.f1616a.i(size);
            a aVar = (a) this.f1616a.j(size);
            int i10 = aVar.f1619a;
            if ((i10 & 3) == 3) {
                bVar.a(c0Var);
            } else if ((i10 & 1) != 0) {
                RecyclerView.l.c cVar = aVar.f1620b;
                if (cVar == null) {
                    bVar.a(c0Var);
                } else {
                    bVar.c(c0Var, cVar, aVar.f1621c);
                }
            } else if ((i10 & 14) == 14) {
                bVar.b(c0Var, aVar.f1620b, aVar.f1621c);
            } else if ((i10 & 12) == 12) {
                bVar.d(c0Var, aVar.f1620b, aVar.f1621c);
            } else if ((i10 & 4) != 0) {
                bVar.c(c0Var, aVar.f1620b, null);
            } else if ((i10 & 8) != 0) {
                bVar.b(c0Var, aVar.f1620b, aVar.f1621c);
            }
            a.c(aVar);
        }
    }

    public void p(RecyclerView.c0 c0Var) {
        a aVar = (a) this.f1616a.get(c0Var);
        if (aVar == null) {
            return;
        }
        aVar.f1619a &= -2;
    }

    public void q(RecyclerView.c0 c0Var) {
        int iQ = this.f1617b.q() - 1;
        while (true) {
            if (iQ < 0) {
                break;
            }
            if (c0Var == this.f1617b.r(iQ)) {
                this.f1617b.p(iQ);
                break;
            }
            iQ--;
        }
        a aVar = (a) this.f1616a.remove(c0Var);
        if (aVar != null) {
            a.c(aVar);
        }
    }
}
