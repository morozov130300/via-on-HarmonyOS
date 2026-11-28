package lc;

import oc.v;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class p extends qc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oc.s f7734a = new oc.s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7736c;

    public p(int i10) {
        this.f7735b = i10;
    }

    @Override // qc.a, qc.d
    public boolean a(oc.a aVar) {
        if (!this.f7736c) {
            return true;
        }
        oc.a aVarF = this.f7734a.f();
        if (!(aVarF instanceof oc.r)) {
            return true;
        }
        ((oc.r) aVarF).o(false);
        return true;
    }

    @Override // qc.a, qc.d
    public boolean b() {
        return true;
    }

    @Override // qc.d
    public oc.a f() {
        return this.f7734a;
    }

    @Override // qc.d
    public qc.c g(qc.h hVar) {
        if (!hVar.a()) {
            return hVar.b() >= this.f7735b ? qc.c.a(hVar.e() + this.f7735b) : qc.c.d();
        }
        if (this.f7734a.c() == null) {
            return qc.c.d();
        }
        oc.a aVarF = hVar.d().f();
        this.f7736c = (aVarF instanceof v) || (aVarF instanceof oc.s);
        return qc.c.b(hVar.c());
    }
}
