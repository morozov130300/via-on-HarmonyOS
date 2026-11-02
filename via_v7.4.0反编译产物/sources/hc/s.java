package hc;

import kc.z;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class s extends mc.a {

    /* renamed from: a, reason: collision with root package name */
    public final z f6964a = new z();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a extends mc.b {
        @Override // mc.e
        public mc.f a(mc.h hVar, mc.g gVar) {
            if (hVar.b() >= 4) {
                return mc.f.c();
            }
            int iC = hVar.c();
            CharSequence line = hVar.getLine();
            return s.j(line, iC) ? mc.f.d(new s()).b(line.length()) : mc.f.c();
        }
    }

    public static boolean j(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i10 < length) {
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt != '\t' && cCharAt != ' ') {
                if (cCharAt == '*') {
                    i13++;
                } else if (cCharAt == '-') {
                    i11++;
                } else {
                    if (cCharAt != '_') {
                        return false;
                    }
                    i12++;
                }
            }
            i10++;
        }
        if (i11 >= 3 && i12 == 0 && i13 == 0) {
            return true;
        }
        if (i12 >= 3 && i11 == 0 && i13 == 0) {
            return true;
        }
        return i13 >= 3 && i11 == 0 && i12 == 0;
    }

    @Override // mc.d
    public kc.a e() {
        return this.f6964a;
    }

    @Override // mc.d
    public mc.c g(mc.h hVar) {
        return mc.c.d();
    }
}
