package lc;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i extends qc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oc.i f7690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public StringBuilder f7692c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a extends qc.b {
        @Override // qc.e
        public qc.f a(qc.h hVar, qc.g gVar) {
            int iB = hVar.b();
            if (iB >= nc.d.f10854a) {
                return qc.f.c();
            }
            int iC = hVar.c();
            i iVarK = i.k(hVar.getLine(), iC, iB);
            return iVarK != null ? qc.f.d(iVarK).b(iC + iVarK.f7690a.p()) : qc.f.c();
        }
    }

    public i(char c10, int i10, int i11) {
        oc.i iVar = new oc.i();
        this.f7690a = iVar;
        this.f7692c = new StringBuilder();
        iVar.s(c10);
        iVar.u(i10);
        iVar.t(i11);
    }

    public static i k(CharSequence charSequence, int i10, int i11) {
        int length = charSequence.length();
        int i12 = 0;
        int i13 = 0;
        for (int i14 = i10; i14 < length; i14++) {
            char cCharAt = charSequence.charAt(i14);
            if (cCharAt == '`') {
                i12++;
            } else {
                if (cCharAt != '~') {
                    break;
                }
                i13++;
            }
        }
        if (i12 >= 3 && i13 == 0) {
            if (nc.d.b('`', charSequence, i10 + i12) != -1) {
                return null;
            }
            return new i('`', i12, i11);
        }
        if (i13 < 3 || i12 != 0) {
            return null;
        }
        return new i('~', i13, i11);
    }

    @Override // qc.a, qc.d
    public void c() {
        this.f7690a.v(nc.a.e(this.f7691b.trim()));
        this.f7690a.w(this.f7692c.toString());
    }

    @Override // qc.d
    public oc.a f() {
        return this.f7690a;
    }

    @Override // qc.d
    public qc.c g(qc.h hVar) {
        int iC = hVar.c();
        int index = hVar.getIndex();
        CharSequence line = hVar.getLine();
        if (hVar.b() < nc.d.f10854a && l(line, iC)) {
            return qc.c.c();
        }
        int length = line.length();
        for (int iO = this.f7690a.o(); iO > 0 && index < length && line.charAt(index) == ' '; iO--) {
            index++;
        }
        return qc.c.b(index);
    }

    @Override // qc.a, qc.d
    public void h(CharSequence charSequence) {
        if (this.f7691b == null) {
            this.f7691b = charSequence.toString();
        } else {
            this.f7692c.append(charSequence);
            this.f7692c.append('\n');
        }
    }

    public final boolean l(CharSequence charSequence, int i10) {
        char cN = this.f7690a.n();
        int iP = this.f7690a.p();
        int iK = nc.d.k(cN, charSequence, i10, charSequence.length()) - i10;
        return iK >= iP && nc.d.m(charSequence, i10 + iK, charSequence.length()) == charSequence.length();
    }
}
