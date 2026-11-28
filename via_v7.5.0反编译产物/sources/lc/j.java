package lc;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class j extends qc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oc.k f7693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7694b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a extends qc.b {
        @Override // qc.e
        public qc.f a(qc.h hVar, qc.g gVar) {
            CharSequence charSequenceB;
            if (hVar.b() >= nc.d.f10854a) {
                return qc.f.c();
            }
            CharSequence line = hVar.getLine();
            int iC = hVar.c();
            j jVarK = j.k(line, iC);
            if (jVarK != null) {
                return qc.f.d(jVarK).b(line.length());
            }
            int iL = j.l(line, iC);
            return (iL <= 0 || (charSequenceB = gVar.b()) == null) ? qc.f.c() : qc.f.d(new j(iL, charSequenceB.toString())).b(line.length()).e();
        }
    }

    public j(int i10, String str) {
        oc.k kVar = new oc.k();
        this.f7693a = kVar;
        kVar.o(i10);
        this.f7694b = str;
    }

    public static j k(CharSequence charSequence, int i10) {
        int iK = nc.d.k('#', charSequence, i10, charSequence.length()) - i10;
        if (iK == 0 || iK > 6) {
            return null;
        }
        int i11 = i10 + iK;
        if (i11 >= charSequence.length()) {
            return new j(iK, "");
        }
        char cCharAt = charSequence.charAt(i11);
        if (cCharAt != ' ' && cCharAt != '\t') {
            return null;
        }
        int iN = nc.d.n(charSequence, charSequence.length() - 1, i11);
        int iL = nc.d.l('#', charSequence, iN, i11);
        int iN2 = nc.d.n(charSequence, iL, i11);
        return iN2 != iL ? new j(iK, charSequence.subSequence(i11, iN2 + 1).toString()) : new j(iK, charSequence.subSequence(i11, iN + 1).toString());
    }

    public static int l(CharSequence charSequence, int i10) {
        char cCharAt = charSequence.charAt(i10);
        if (cCharAt != '-') {
            if (cCharAt != '=') {
                return 0;
            }
            if (m(charSequence, i10 + 1, '=')) {
                return 1;
            }
        }
        return m(charSequence, i10 + 1, '-') ? 2 : 0;
    }

    public static boolean m(CharSequence charSequence, int i10, char c10) {
        return nc.d.m(charSequence, nc.d.k(c10, charSequence, i10, charSequence.length()), charSequence.length()) >= charSequence.length();
    }

    @Override // qc.a, qc.d
    public void d(pc.a aVar) {
        aVar.a(this.f7694b, this.f7693a);
    }

    @Override // qc.d
    public oc.a f() {
        return this.f7693a;
    }

    @Override // qc.d
    public qc.c g(qc.h hVar) {
        return qc.c.d();
    }
}
