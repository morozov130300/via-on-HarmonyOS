package lc;

import oc.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o extends qc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oc.r f7727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7729c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a extends qc.b {
        @Override // qc.e
        public qc.f a(qc.h hVar, qc.g gVar) {
            qc.d dVarA = gVar.a();
            if (hVar.b() >= nc.d.f10854a) {
                return qc.f.c();
            }
            b bVarN = o.n(hVar.getLine(), hVar.c(), hVar.e() + hVar.b(), gVar.b() != null);
            if (bVarN == null) {
                return qc.f.c();
            }
            int i10 = bVarN.f7731b;
            p pVar = new p(i10 - hVar.e());
            if ((dVarA instanceof o) && o.m((oc.r) dVarA.f(), bVarN.f7730a)) {
                return qc.f.d(pVar).a(i10);
            }
            o oVar = new o(bVarN.f7730a);
            bVarN.f7730a.o(true);
            return qc.f.d(oVar, pVar).a(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final oc.r f7730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7731b;

        public b(oc.r rVar, int i10) {
            this.f7730a = rVar;
            this.f7731b = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final oc.r f7732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7733b;

        public c(oc.r rVar, int i10) {
            this.f7732a = rVar;
            this.f7733b = i10;
        }
    }

    public o(oc.r rVar) {
        this.f7727a = rVar;
    }

    public static boolean k(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean l(CharSequence charSequence, int i10) {
        char cCharAt;
        return i10 >= charSequence.length() || (cCharAt = charSequence.charAt(i10)) == '\t' || cCharAt == ' ';
    }

    public static boolean m(oc.r rVar, oc.r rVar2) {
        if ((rVar instanceof oc.c) && (rVar2 instanceof oc.c)) {
            return k(Character.valueOf(((oc.c) rVar).p()), Character.valueOf(((oc.c) rVar2).p()));
        }
        if ((rVar instanceof u) && (rVar2 instanceof u)) {
            return k(Character.valueOf(((u) rVar).p()), Character.valueOf(((u) rVar2).p()));
        }
        return false;
    }

    public static b n(CharSequence charSequence, int i10, int i11, boolean z10) {
        boolean z11;
        c cVarO = o(charSequence, i10);
        if (cVarO == null) {
            return null;
        }
        oc.r rVar = cVarO.f7732a;
        int i12 = cVarO.f7733b;
        int i13 = i11 + (i12 - i10);
        int length = charSequence.length();
        int iA = i13;
        while (true) {
            if (i12 >= length) {
                z11 = false;
                break;
            }
            char cCharAt = charSequence.charAt(i12);
            if (cCharAt != '\t') {
                if (cCharAt != ' ') {
                    z11 = true;
                    break;
                }
                iA++;
            } else {
                iA += nc.d.a(iA);
            }
            i12++;
        }
        if (z10 && (((rVar instanceof u) && ((u) rVar).q() != 1) || !z11)) {
            return null;
        }
        if (!z11 || iA - i13 > nc.d.f10854a) {
            iA = i13 + 1;
        }
        return new b(rVar, iA);
    }

    public static c o(CharSequence charSequence, int i10) {
        char cCharAt = charSequence.charAt(i10);
        if (cCharAt != '*' && cCharAt != '+' && cCharAt != '-') {
            return p(charSequence, i10);
        }
        int i11 = i10 + 1;
        if (!l(charSequence, i11)) {
            return null;
        }
        oc.c cVar = new oc.c();
        cVar.q(cCharAt);
        return new c(cVar, i11);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0026  */
    /* JADX WARN: Code duplicated, block: B:19:0x002e  */
    /* JADX WARN: Code duplicated, block: B:5:0x0009  */
    public static c p(CharSequence charSequence, int i10) {
        int i11;
        int length = charSequence.length();
        int i12 = 0;
        for (int i13 = i10; i13 < length; i13++) {
            char cCharAt = charSequence.charAt(i13);
            if (cCharAt != ')' || cCharAt == '.') {
                if (i12 >= 1) {
                    i11 = i13 + 1;
                    if (l(charSequence, i11)) {
                        String string = charSequence.subSequence(i10, i13).toString();
                        u uVar = new u();
                        uVar.s(Integer.parseInt(string));
                        uVar.r(cCharAt);
                        return new c(uVar, i11);
                    }
                }
                return null;
            }
            switch (cCharAt) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    i12++;
                    if (i12 > 9) {
                        return null;
                    }
                    break;
                    break;
                default:
                    return null;
            }
            while (i13 < length) {
                char cCharAt2 = charSequence.charAt(i13);
                if (cCharAt2 != ')') {
                }
                if (i12 >= 1) {
                    i11 = i13 + 1;
                    if (l(charSequence, i11)) {
                        String string2 = charSequence.subSequence(i10, i13).toString();
                        u uVar2 = new u();
                        uVar2.s(Integer.parseInt(string2));
                        uVar2.r(cCharAt2);
                        return new c(uVar2, i11);
                    }
                }
                return null;
            }
        }
        return null;
    }

    @Override // qc.a, qc.d
    public boolean a(oc.a aVar) {
        if (!(aVar instanceof oc.s)) {
            return false;
        }
        if (this.f7728b && this.f7729c == 1) {
            this.f7727a.o(false);
            this.f7728b = false;
        }
        return true;
    }

    @Override // qc.a, qc.d
    public boolean b() {
        return true;
    }

    @Override // qc.d
    public oc.a f() {
        return this.f7727a;
    }

    @Override // qc.d
    public qc.c g(qc.h hVar) {
        if (hVar.a()) {
            this.f7728b = true;
            this.f7729c = 0;
        } else if (this.f7728b) {
            this.f7729c++;
        }
        return qc.c.b(hVar.getIndex());
    }
}
