package hc;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j extends mc.a {

    /* renamed from: a, reason: collision with root package name */
    public final kc.k f6915a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6916b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a extends mc.b {
        @Override // mc.e
        public mc.f a(mc.h hVar, mc.g gVar) {
            CharSequence charSequenceB;
            if (hVar.b() >= jc.d.f7963a) {
                return mc.f.c();
            }
            CharSequence line = hVar.getLine();
            int iC = hVar.c();
            j jVarK = j.k(line, iC);
            if (jVarK != null) {
                return mc.f.d(jVarK).b(line.length());
            }
            int iL = j.l(line, iC);
            return (iL <= 0 || (charSequenceB = gVar.b()) == null) ? mc.f.c() : mc.f.d(new j(iL, charSequenceB.toString())).b(line.length()).e();
        }
    }

    public j(int i10, String str) {
        kc.k kVar = new kc.k();
        this.f6915a = kVar;
        kVar.o(i10);
        this.f6916b = str;
    }

    public static j k(CharSequence charSequence, int i10) {
        int iK = jc.d.k('#', charSequence, i10, charSequence.length()) - i10;
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
        int iN = jc.d.n(charSequence, charSequence.length() - 1, i11);
        int iL = jc.d.l('#', charSequence, iN, i11);
        int iN2 = jc.d.n(charSequence, iL, i11);
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
        return jc.d.m(charSequence, jc.d.k(c10, charSequence, i10, charSequence.length()), charSequence.length()) >= charSequence.length();
    }

    @Override // mc.a, mc.d
    public void d(lc.a aVar) {
        aVar.a(this.f6916b, this.f6915a);
    }

    @Override // mc.d
    public kc.a e() {
        return this.f6915a;
    }

    @Override // mc.d
    public mc.c g(mc.h hVar) {
        return mc.c.d();
    }
}
