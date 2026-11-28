package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class q extends n {
    public static final p7.l d(final String str) {
        return str.length() == 0 ? new p7.l() { // from class: kotlin.text.o
            @Override // p7.l
            public final Object invoke(Object obj) {
                return q.e((String) obj);
            }
        } : new p7.l() { // from class: kotlin.text.p
            @Override // p7.l
            public final Object invoke(Object obj) {
                return q.f(str, (String) obj);
            }
        };
    }

    public static final String e(String line) {
        kotlin.jvm.internal.h.f(line, "line");
        return line;
    }

    public static final String f(String str, String line) {
        kotlin.jvm.internal.h.f(line, "line");
        return str + line;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0019  */
    /* JADX WARN: Code duplicated, block: B:13:0x001e A[RETURN] */
    public static final int g(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            if (!a.d(str.charAt(i10))) {
                if (i10 == -1) {
                    return str.length();
                }
                return i10;
            }
            i10++;
        }
        i10 = -1;
        if (i10 == -1) {
            return str.length();
        }
        return i10;
    }

    public static final String h(String str, String newIndent) {
        String str2;
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(newIndent, "newIndent");
        List listC0 = z.c0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listC0) {
            if (!z.V((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(e7.p.o(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(g((String) it.next())));
        }
        Integer num = (Integer) e7.w.G(arrayList2);
        int i10 = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * listC0.size());
        p7.l lVarD = d(newIndent);
        int iJ = e7.o.j(listC0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listC0) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                e7.o.n();
            }
            String str3 = (String) obj2;
            if ((i10 == 0 || i10 == iJ) && z.V(str3)) {
                str3 = null;
            } else {
                String strX0 = b0.x0(str3, iIntValue);
                if (strX0 != null && (str2 = (String) lVarD.invoke(strX0)) != null) {
                    str3 = str2;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i10 = i11;
        }
        return ((StringBuilder) e7.w.B(arrayList3, new StringBuilder(length), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
    }

    public static String i(String str) {
        kotlin.jvm.internal.h.f(str, "<this>");
        return h(str, "");
    }
}
