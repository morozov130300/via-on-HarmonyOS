package kotlin.text;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class x extends w {
    public static final boolean A(String str, String prefix, int i10, boolean z10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(prefix, "prefix");
        return !z10 ? str.startsWith(prefix, i10) : t(str, i10, prefix, 0, prefix.length(), z10);
    }

    public static boolean B(String str, String prefix, boolean z10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(prefix, "prefix");
        return !z10 ? str.startsWith(prefix) : t(str, 0, prefix, 0, prefix.length(), z10);
    }

    public static /* synthetic */ boolean C(String str, String str2, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return A(str, str2, i10, z10);
    }

    public static /* synthetic */ boolean D(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return B(str, str2, z10);
    }

    public static String o(byte[] bArr) {
        kotlin.jvm.internal.h.f(bArr, "<this>");
        return new String(bArr, c.f7329b);
    }

    public static byte[] p(String str) {
        kotlin.jvm.internal.h.f(str, "<this>");
        byte[] bytes = str.getBytes(c.f7329b);
        kotlin.jvm.internal.h.e(bytes, "getBytes(...)");
        return bytes;
    }

    public static final boolean q(String str, String suffix, boolean z10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(suffix, "suffix");
        return !z10 ? str.endsWith(suffix) : t(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean r(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return q(str, str2, z10);
    }

    public static boolean s(String str, String str2, boolean z10) {
        if (str == null) {
            return str2 == null;
        }
        return !z10 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static final boolean t(String str, int i10, String other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(other, "other");
        return !z10 ? str.regionMatches(i10, other, i11, i12) : str.regionMatches(z10, i10, other, i11, i12);
    }

    public static String v(CharSequence charSequence, int i10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i10 + '.').toString());
        }
        if (i10 == 0) {
            return "";
        }
        int i11 = 1;
        if (i10 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                cArr[i12] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb2 = new StringBuilder(charSequence.length() * i10);
        if (1 <= i10) {
            while (true) {
                sb2.append(charSequence);
                if (i11 == i10) {
                    break;
                }
                i11++;
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.h.c(string);
        return string;
    }

    public static final String w(String str, char c10, char c11, boolean z10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        if (!z10) {
            String strReplace = str.replace(c10, c11);
            kotlin.jvm.internal.h.e(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (b.f(cCharAt, c10, z10)) {
                cCharAt = c11;
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }

    public static final String x(String str, String oldValue, String newValue, boolean z10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(oldValue, "oldValue");
        kotlin.jvm.internal.h.f(newValue, "newValue");
        int i10 = 0;
        int iP = z.P(str, oldValue, 0, z10);
        if (iP < 0) {
            return str;
        }
        int length = oldValue.length();
        int iA = s7.e.a(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        do {
            sb2.append((CharSequence) str, i10, iP);
            sb2.append(newValue);
            i10 = iP + length;
            if (iP >= str.length()) {
                break;
            }
            iP = z.P(str, oldValue, iP + iA, z10);
        } while (iP > 0);
        sb2.append((CharSequence) str, i10, str.length());
        String string = sb2.toString();
        kotlin.jvm.internal.h.e(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String y(String str, char c10, char c11, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return w(str, c10, c11, z10);
    }

    public static /* synthetic */ String z(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return x(str, str2, str3, z10);
    }
}
