package androidx.recyclerview.widget;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k.g f1517a = new k.g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k.d f1518b = new k.d();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static x.e f1519d = new x.f(20);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.l.c f1521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public RecyclerView.l.c f1522c;

        public static void a() {
            while (f1519d.b() != null) {
            }
        }

        public static a b() {
            a aVar = (a) f1519d.b();
            return aVar == null ? new a() : aVar;
        }

        public static void c(a aVar) {
            aVar.f1520a = 0;
            aVar.f1521b = null;
            aVar.f1522c = null;
            f1519d.a(aVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a(RecyclerView.d0 d0Var);

        void b(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    public void a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVarB = (a) this.f1517a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f1517a.put(d0Var, aVarB);
        }
        aVarB.f1520a |= 2;
        aVarB.f1521b = cVar;
    }

    public void b(RecyclerView.d0 d0Var) {
        a aVarB = (a) this.f1517a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f1517a.put(d0Var, aVarB);
        }
        aVarB.f1520a |= 1;
    }

    public void c(long j10, RecyclerView.d0 d0Var) {
        this.f1518b.n(j10, d0Var);
    }

    public void d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVarB = (a) this.f1517a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f1517a.put(d0Var, aVarB);
        }
        aVarB.f1522c = cVar;
        aVarB.f1520a |= 8;
    }

    public void e(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVarB = (a) this.f1517a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f1517a.put(d0Var, aVarB);
        }
        aVarB.f1521b = cVar;
        aVarB.f1520a |= 4;
    }

    public void f() {
        this.f1517a.clear();
        this.f1518b.a();
    }

    public RecyclerView.d0 g(long j10) {
        return (RecyclerView.d0) this.f1518b.i(j10);
    }

    public boolean h(RecyclerView.d0 d0Var) {
        a aVar = (a) this.f1517a.get(d0Var);
        return (aVar == null || (aVar.f1520a & 1) == 0) ? false : true;
    }

    public boolean i(RecyclerView.d0 d0Var) {
        a aVar = (a) this.f1517a.get(d0Var);
        return (aVar == null || (aVar.f1520a & 4) == 0) ? false : true;
    }

    public void j() {
        a.a();
    }

    public void k(RecyclerView.d0 d0Var) {
        p(d0Var);
    }

    public final RecyclerView.l.c l(RecyclerView.d0 d0Var, int i10) {
        a aVar;
        RecyclerView.l.c cVar;
        int iF = this.f1517a.f(d0Var);
        if (iF >= 0 && (aVar = (a) this.f1517a.l(iF)) != null) {
            int i11 = aVar.f1520a;
            if ((i11 & i10) != 0) {
                int i12 = (i10 ^ (-1)) & i11;
                aVar.f1520a = i12;
                if (i10 == 4) {
                    cVar = aVar.f1521b;
                } else {
                    if (i10 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = aVar.f1522c;
                }
                if ((i12 & 12) == 0) {
                    this.f1517a.j(iF);
                    a.c(aVar);
                }
                return cVar;
            }
        }
        return null;
    }

    public RecyclerView.l.c m(RecyclerView.d0 d0Var) {
        return l(d0Var, 8);
    }

    public RecyclerView.l.c n(RecyclerView.d0 d0Var) {
        return l(d0Var, 4);
    }

    public void o(b bVar) {
        for (int size = this.f1517a.size() - 1; size >= 0; size--) {
            RecyclerView.d0 d0Var = (RecyclerView.d0) this.f1517a.i(size);
            a aVar = (a) this.f1517a.j(size);
            int i10 = aVar.f1520a;
            if ((i10 & 3) == 3) {
                bVar.a(d0Var);
            } else if ((i10 & 1) != 0) {
                RecyclerView.l.c cVar = aVar.f1521b;
                if (cVar == null) {
                    bVar.a(d0Var);
                } else {
                    bVar.c(d0Var, cVar, aVar.f1522c);
                }
            } else if ((i10 & 14) == 14) {
                bVar.b(d0Var, aVar.f1521b, aVar.f1522c);
            } else if ((i10 & 12) == 12) {
                bVar.d(d0Var, aVar.f1521b, aVar.f1522c);
            } else if ((i10 & 4) != 0) {
                bVar.c(d0Var, aVar.f1521b, null);
            } else if ((i10 & 8) != 0) {
                bVar.b(d0Var, aVar.f1521b, aVar.f1522c);
            }
            a.c(aVar);
        }
    }

    public void p(RecyclerView.d0 d0Var) {
        a aVar = (a) this.f1517a.get(d0Var);
        if (aVar == null) {
            return;
        }
        aVar.f1520a &= -2;
    }

    public void q(RecyclerView.d0 d0Var) {
        for (int iQ = this.f1518b.q() - 1; iQ >= 0; iQ--) {
            if (d0Var == this.f1518b.r(iQ)) {
                this.f1518b.p(iQ);
                break;
            }
        }
        a aVar = (a) this.f1517a.remove(d0Var);
        if (aVar != null) {
            a.c(aVar);
        }
    }
}
