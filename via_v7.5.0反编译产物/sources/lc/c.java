package lc;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c extends qc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oc.b f7651a = new oc.b();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a extends qc.b {
        @Override // qc.e
        public qc.f a(qc.h hVar, qc.g gVar) {
            int iC = hVar.c();
            if (!c.k(hVar, iC)) {
                return qc.f.c();
            }
            int iE = hVar.e() + hVar.b();
            int i10 = iE + 1;
            if (nc.d.i(hVar.getLine(), iC + 1)) {
                i10 = iE + 2;
            }
            return qc.f.d(new c()).a(i10);
        }
    }

    public static boolean k(qc.h hVar, int i10) {
        CharSequence line = hVar.getLine();
        return hVar.b() < nc.d.f10854a && i10 < line.length() && line.charAt(i10) == '>';
    }

    @Override // qc.a, qc.d
    public boolean a(oc.a aVar) {
        return true;
    }

    @Override // qc.a, qc.d
    public boolean b() {
        return true;
    }

    @Override // qc.d
    public qc.c g(qc.h hVar) {
        int iC = hVar.c();
        if (!k(hVar, iC)) {
            return qc.c.d();
        }
        int iE = hVar.e() + hVar.b();
        int i10 = iE + 1;
        if (nc.d.i(hVar.getLine(), iC + 1)) {
            i10 = iE + 2;
        }
        return qc.c.a(i10);
    }

    @Override // qc.d
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public oc.b f() {
        return this.f7651a;
    }
}
