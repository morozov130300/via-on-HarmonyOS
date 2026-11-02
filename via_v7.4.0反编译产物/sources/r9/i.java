package r9;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i implements a {

    /* renamed from: a, reason: collision with root package name */
    public final List f11595a;

    public i(List list) {
        this.f11595a = list;
    }

    public final c a(String str) {
        List list;
        int iB = b(str);
        if (iB < 0 || (list = this.f11595a) == null) {
            return null;
        }
        return (c) list.get(iB);
    }

    public final int b(String str) {
        List list;
        if (str != null && !str.isEmpty() && (list = this.f11595a) != null && !list.isEmpty()) {
            int size = this.f11595a.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (str.equalsIgnoreCase(((c) this.f11595a.get(i10)).a())) {
                    return i10;
                }
            }
        }
        return -1;
    }

    @Override // r9.a
    public int getInt(String str, int i10) {
        String string = getString(str, null);
        if (string != null && !string.isEmpty()) {
            try {
                return Integer.decode(string).intValue();
            } catch (NumberFormatException e10) {
                pc.a.i(e10);
            }
        }
        return i10;
    }

    @Override // r9.a
    public String getString(String str, String str2) {
        c cVarA;
        List list = this.f11595a;
        if (list != null && !list.isEmpty() && (cVarA = a(str)) != null && cVarA.d()) {
            if (cVarA.b() != null && !cVarA.b().isEmpty()) {
                return cVarA.b();
            }
            if (cVarA.c() != null && !cVarA.c().isEmpty()) {
                return cVarA.c();
            }
        }
        return str2;
    }
}
