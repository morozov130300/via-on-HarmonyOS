package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class z extends x {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements u7.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f7366a;

        public a(CharSequence charSequence) {
            this.f7366a = charSequence;
        }

        @Override // u7.f
        public Iterator iterator() {
            return new f(this.f7366a);
        }
    }

    public static final boolean F(CharSequence charSequence, char c10, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        return S(charSequence, c10, 0, z10, 2, null) >= 0;
    }

    public static final boolean G(CharSequence charSequence, CharSequence other, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(other, "other");
        if (other instanceof String) {
            return T(charSequence, (String) other, 0, z10, 2, null) >= 0;
        }
        return R(charSequence, other, 0, charSequence.length(), z10, false, 16, null) >= 0;
    }

    public static /* synthetic */ boolean H(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return F(charSequence, c10, z10);
    }

    public static /* synthetic */ boolean I(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return G(charSequence, charSequence2, z10);
    }

    public static final boolean J(CharSequence charSequence, char c10, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        return charSequence.length() > 0 && b.f(charSequence.charAt(N(charSequence)), c10, z10);
    }

    public static final boolean K(CharSequence charSequence, CharSequence suffix, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(suffix, "suffix");
        return (!z10 && (charSequence instanceof String) && (suffix instanceof String)) ? x.r((String) charSequence, (String) suffix, false, 2, null) : i0(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z10);
    }

    public static /* synthetic */ boolean L(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return J(charSequence, c10, z10);
    }

    public static /* synthetic */ boolean M(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return K(charSequence, charSequence2, z10);
    }

    public static int N(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int O(CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? U(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).indexOf(c10, i10);
    }

    public static final int P(CharSequence charSequence, String string, int i10, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(string, "string");
        return (z10 || !(charSequence instanceof String)) ? R(charSequence, string, i10, charSequence.length(), z10, false, 16, null) : ((String) charSequence).indexOf(string, i10);
    }

    public static final int Q(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        s7.a cVar = !z11 ? new s7.c(s7.e.a(i10, 0), s7.e.b(i11, charSequence.length())) : s7.e.d(s7.e.b(i10, N(charSequence)), s7.e.a(i11, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iC = cVar.c();
            int iF = cVar.f();
            int iG = cVar.g();
            if ((iG <= 0 || iC > iF) && (iG >= 0 || iF > iC)) {
                return -1;
            }
            int i12 = iC;
            while (true) {
                String str = (String) charSequence2;
                boolean z12 = z10;
                if (x.t(str, 0, (String) charSequence, i12, str.length(), z12)) {
                    return i12;
                }
                if (i12 == iF) {
                    return -1;
                }
                i12 += iG;
                z10 = z12;
            }
        } else {
            boolean z13 = z10;
            int iC2 = cVar.c();
            int iF2 = cVar.f();
            int iG2 = cVar.g();
            if ((iG2 <= 0 || iC2 > iF2) && (iG2 >= 0 || iF2 > iC2)) {
                return -1;
            }
            int i13 = iC2;
            while (true) {
                boolean z14 = z13;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z13 = z14;
                if (i0(charSequence4, 0, charSequence3, i13, charSequence2.length(), z14)) {
                    return i13;
                }
                if (i13 == iF2) {
                    return -1;
                }
                i13 += iG2;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        }
    }

    public static /* synthetic */ int R(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        return Q(charSequence, charSequence2, i10, i11, z10, (i12 & 16) != 0 ? false : z11);
    }

    public static /* synthetic */ int S(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return O(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int T(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return P(charSequence, str, i10, z10);
    }

    public static final int U(CharSequence charSequence, char[] chars, int i10, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(e7.l.r(chars), i10);
        }
        int iA = s7.e.a(i10, 0);
        int iN = N(charSequence);
        if (iA > iN) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iA);
            for (char c10 : chars) {
                if (b.f(c10, cCharAt, z10)) {
                    return iA;
                }
            }
            if (iA == iN) {
                return -1;
            }
            iA++;
        }
    }

    public static final boolean V(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (!kotlin.text.a.d(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static final int W(CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? a0(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).lastIndexOf(c10, i10);
    }

    public static final int X(CharSequence charSequence, String string, int i10, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(string, "string");
        return (z10 || !(charSequence instanceof String)) ? Q(charSequence, string, i10, 0, z10, true) : ((String) charSequence).lastIndexOf(string, i10);
    }

    public static /* synthetic */ int Y(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = N(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return W(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int Z(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = N(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return X(charSequence, str, i10, z10);
    }

    public static final int a0(CharSequence charSequence, char[] chars, int i10, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(e7.l.r(chars), i10);
        }
        for (int iB = s7.e.b(i10, N(charSequence)); -1 < iB; iB--) {
            char cCharAt = charSequence.charAt(iB);
            for (char c10 : chars) {
                if (b.f(c10, cCharAt, z10)) {
                    return iB;
                }
            }
        }
        return -1;
    }

    public static final u7.f b0(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        return new a(charSequence);
    }

    public static final List c0(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        return u7.m.k(b0(charSequence));
    }

    public static final CharSequence d0(CharSequence charSequence, int i10, char c10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException("Desired length " + i10 + " is less than zero.");
        }
        if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(i10);
        int length = i10 - charSequence.length();
        int i11 = 1;
        if (1 <= length) {
            while (true) {
                sb2.append(c10);
                if (i11 == length) {
                    break;
                }
                i11++;
            }
        }
        sb2.append(charSequence);
        return sb2;
    }

    public static String e0(String str, int i10, char c10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        return d0(str, i10, c10).toString();
    }

    public static final u7.f f0(CharSequence charSequence, final char[] cArr, int i10, final boolean z10, int i11) {
        k0(i11);
        return new d(charSequence, i10, i11, new p7.p() { // from class: kotlin.text.y
            @Override // p7.p
            public final Object invoke(Object obj, Object obj2) {
                return z.h0(cArr, z10, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static /* synthetic */ u7.f g0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return f0(charSequence, cArr, i10, z10, i11);
    }

    public static final Pair h0(char[] cArr, boolean z10, CharSequence DelimitedRangesSequence, int i10) {
        kotlin.jvm.internal.h.f(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        int iU = U(DelimitedRangesSequence, cArr, i10, z10);
        if (iU < 0) {
            return null;
        }
        return d7.f.a(Integer.valueOf(iU), 1);
    }

    public static final boolean i0(CharSequence charSequence, int i10, CharSequence other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(other, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > other.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!b.f(charSequence.charAt(i10 + i13), other.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static CharSequence j0(CharSequence charSequence, int i10, int i11) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("End index (" + i11 + ") is less than start index (" + i10 + ").");
        }
        if (i11 == i10) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(charSequence.length() - (i11 - i10));
        sb2.append(charSequence, 0, i10);
        kotlin.jvm.internal.h.e(sb2, "append(...)");
        sb2.append(charSequence, i11, charSequence.length());
        kotlin.jvm.internal.h.e(sb2, "append(...)");
        return sb2;
    }

    public static final void k0(int i10) {
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i10).toString());
    }

    public static final List l0(CharSequence charSequence, char[] delimiters, boolean z10, int i10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return m0(charSequence, String.valueOf(delimiters[0]), z10, i10);
        }
        Iterable iterableG = u7.m.g(g0(charSequence, delimiters, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(e7.p.o(iterableG, 10));
        Iterator it = iterableG.iterator();
        while (it.hasNext()) {
            arrayList.add(q0(charSequence, (s7.c) it.next()));
        }
        return arrayList;
    }

    public static final List m0(CharSequence charSequence, String str, boolean z10, int i10) {
        k0(i10);
        int length = 0;
        int iP = P(charSequence, str, 0, z10);
        if (iP == -1 || i10 == 1) {
            return e7.n.e(charSequence.toString());
        }
        boolean z11 = i10 > 0;
        ArrayList arrayList = new ArrayList(z11 ? s7.e.b(i10, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iP).toString());
            length = str.length() + iP;
            if (z11 && arrayList.size() == i10 - 1) {
                break;
            }
            iP = P(charSequence, str, length, z10);
        } while (iP != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List n0(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return l0(charSequence, cArr, z10, i10);
    }

    public static final boolean o0(CharSequence charSequence, char c10, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        return charSequence.length() > 0 && b.f(charSequence.charAt(0), c10, z10);
    }

    public static /* synthetic */ boolean p0(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return o0(charSequence, c10, z10);
    }

    public static final String q0(CharSequence charSequence, s7.c range) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(range, "range");
        return charSequence.subSequence(range.o().intValue(), range.n().intValue() + 1).toString();
    }

    public static final String r0(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(missingDelimiterValue, "missingDelimiterValue");
        int iY = Y(str, c10, 0, false, 6, null);
        if (iY == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iY + 1, str.length());
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String s0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return r0(str, c10, str2);
    }

    public static final String t0(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(missingDelimiterValue, "missingDelimiterValue");
        int iS = S(str, c10, 0, false, 6, null);
        if (iS == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iS);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String u0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return t0(str, c10, str2);
    }

    public static CharSequence v0(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zD = kotlin.text.a.d(charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zD) {
                    break;
                }
                length--;
            } else if (zD) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static CharSequence w0(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!kotlin.text.a.d(charSequence.charAt(i10))) {
                return charSequence.subSequence(i10, charSequence.length());
            }
        }
        return "";
    }
}
