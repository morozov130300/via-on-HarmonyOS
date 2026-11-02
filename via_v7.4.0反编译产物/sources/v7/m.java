package v7;

import k7.v;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class m extends l {
    public static /* synthetic */ int A(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = q(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return y(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int B(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = q(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return z(charSequence, str, i10, z10);
    }

    public static final int C(CharSequence charSequence, char[] chars, int i10, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(k7.i.n(chars), i10);
        }
        for (int iB = t7.e.b(i10, q(charSequence)); -1 < iB; iB--) {
            char cCharAt = charSequence.charAt(iB);
            for (char c10 : chars) {
                if (b.d(c10, cCharAt, z10)) {
                    return iB;
                }
            }
        }
        return -1;
    }

    public static final CharSequence D(CharSequence charSequence, int i10, char c10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException("Desired length " + i10 + " is less than zero.");
        }
        if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(i10);
        v vVarH = new t7.c(1, i10 - charSequence.length()).iterator();
        while (vVarH.hasNext()) {
            vVarH.nextInt();
            sb2.append(c10);
        }
        sb2.append(charSequence);
        return sb2;
    }

    public static String E(String str, int i10, char c10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        return D(str, i10, c10).toString();
    }

    public static final boolean F(CharSequence charSequence, int i10, CharSequence other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(other, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > other.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!b.d(charSequence.charAt(i10 + i13), other.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static final String G(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(missingDelimiterValue, "missingDelimiterValue");
        int iA = A(str, c10, 0, false, 6, null);
        if (iA == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iA + 1, str.length());
        kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String H(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return G(str, c10, str2);
    }

    public static CharSequence I(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zC = a.c(charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static final boolean o(CharSequence charSequence, CharSequence other, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(other, "other");
        return other instanceof String ? w(charSequence, (String) other, 0, z10, 2, null) >= 0 : u(charSequence, other, 0, charSequence.length(), z10, false, 16, null) >= 0;
    }

    public static /* synthetic */ boolean p(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return o(charSequence, charSequence2, z10);
    }

    public static final int q(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int r(CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? x(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).indexOf(c10, i10);
    }

    public static final int s(CharSequence charSequence, String string, int i10, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(string, "string");
        return (z10 || !(charSequence instanceof String)) ? u(charSequence, string, i10, charSequence.length(), z10, false, 16, null) : ((String) charSequence).indexOf(string, i10);
    }

    public static final int t(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        t7.a cVar = !z11 ? new t7.c(t7.e.a(i10, 0), t7.e.b(i11, charSequence.length())) : t7.e.c(t7.e.b(i10, q(charSequence)), t7.e.a(i11, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iC = cVar.c();
            int iF = cVar.f();
            int iG = cVar.g();
            if ((iG <= 0 || iC > iF) && (iG >= 0 || iF > iC)) {
                return -1;
            }
            int i12 = iC;
            while (true) {
                boolean z12 = z10;
                if (l.h((String) charSequence2, 0, (String) charSequence, i12, charSequence2.length(), z12)) {
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
                if (F(charSequence4, 0, charSequence3, i13, charSequence2.length(), z14)) {
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

    public static /* synthetic */ int u(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        return t(charSequence, charSequence2, i10, i11, z10, (i12 & 16) != 0 ? false : z11);
    }

    public static /* synthetic */ int v(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return r(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int w(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return s(charSequence, str, i10, z10);
    }

    public static final int x(CharSequence charSequence, char[] chars, int i10, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(k7.i.n(chars), i10);
        }
        v vVarH = new t7.c(t7.e.a(i10, 0), q(charSequence)).iterator();
        while (vVarH.hasNext()) {
            int iNextInt = vVarH.nextInt();
            char cCharAt = charSequence.charAt(iNextInt);
            for (char c10 : chars) {
                if (b.d(c10, cCharAt, z10)) {
                    return iNextInt;
                }
            }
        }
        return -1;
    }

    public static final int y(CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? C(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).lastIndexOf(c10, i10);
    }

    public static final int z(CharSequence charSequence, String string, int i10, boolean z10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(string, "string");
        return (z10 || !(charSequence instanceof String)) ? t(charSequence, string, i10, 0, z10, true) : ((String) charSequence).lastIndexOf(string, i10);
    }
}
