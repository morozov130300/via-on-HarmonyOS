package hc;

import kc.u;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o extends mc.a {

    /* renamed from: a, reason: collision with root package name */
    public final kc.r f6949a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6950b;

    /* renamed from: c, reason: collision with root package name */
    public int f6951c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a extends mc.b {
        @Override // mc.e
        public mc.f a(mc.h hVar, mc.g gVar) {
            mc.d dVarA = gVar.a();
            if (hVar.b() >= jc.d.f7963a) {
                return mc.f.c();
            }
            b bVarN = o.n(hVar.getLine(), hVar.c(), hVar.e() + hVar.b(), gVar.b() != null);
            if (bVarN == null) {
                return mc.f.c();
            }
            int i10 = bVarN.f6953b;
            p pVar = new p(i10 - hVar.e());
            if ((dVarA instanceof o) && o.m((kc.r) dVarA.e(), bVarN.f6952a)) {
                return mc.f.d(pVar).a(i10);
            }
            o oVar = new o(bVarN.f6952a);
            bVarN.f6952a.o(true);
            return mc.f.d(oVar, pVar).a(i10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final kc.r f6952a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6953b;

        public b(kc.r rVar, int i10) {
            this.f6952a = rVar;
            this.f6953b = i10;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final kc.r f6954a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6955b;

        public c(kc.r rVar, int i10) {
            this.f6954a = rVar;
            this.f6955b = i10;
        }
    }

    public o(kc.r rVar) {
        this.f6949a = rVar;
    }

    public static boolean k(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static boolean l(CharSequence charSequence, int i10) {
        char cCharAt;
        return i10 >= charSequence.length() || (cCharAt = charSequence.charAt(i10)) == '\t' || cCharAt == ' ';
    }

    public static boolean m(kc.r rVar, kc.r rVar2) {
        if ((rVar instanceof kc.c) && (rVar2 instanceof kc.c)) {
            return k(Character.valueOf(((kc.c) rVar).p()), Character.valueOf(((kc.c) rVar2).p()));
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
        kc.r rVar = cVarO.f6954a;
        int i12 = cVarO.f6955b;
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
                iA += jc.d.a(iA);
            }
            i12++;
        }
        if (z10 && (((rVar instanceof u) && ((u) rVar).q() != 1) || !z11)) {
            return null;
        }
        if (!z11 || iA - i13 > jc.d.f7963a) {
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
        kc.c cVar = new kc.c();
        cVar.q(cCharAt);
        return new c(cVar, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0009  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c p(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        for (int i12 = i10; i12 < length; i12++) {
            char cCharAt = charSequence.charAt(i12);
            if (cCharAt == ')' || cCharAt == '.') {
                if (i11 >= 1) {
                    int i13 = i12 + 1;
                    if (l(charSequence, i13)) {
                        String string = charSequence.subSequence(i10, i12).toString();
                        u uVar = new u();
                        uVar.s(Integer.parseInt(string));
                        uVar.r(cCharAt);
                        return new c(uVar, i13);
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
                    i11++;
                    if (i11 > 9) {
                        return null;
                    }
                default:
                    return null;
            }
            while (i12 < length) {
            }
        }
        return null;
    }

    @Override // mc.a, mc.d
    public boolean a() {
        return true;
    }

    @Override // mc.d
    public kc.a e() {
        return this.f6949a;
    }

    @Override // mc.a, mc.d
    public boolean f(kc.a aVar) {
        if (!(aVar instanceof kc.s)) {
            return false;
        }
        if (this.f6950b && this.f6951c == 1) {
            this.f6949a.o(false);
            this.f6950b = false;
        }
        return true;
    }

    @Override // mc.d
    public mc.c g(mc.h hVar) {
        if (hVar.a()) {
            this.f6950b = true;
            this.f6951c = 0;
        } else if (this.f6950b) {
            this.f6951c++;
        }
        return mc.c.b(hVar.getIndex());
    }
}
