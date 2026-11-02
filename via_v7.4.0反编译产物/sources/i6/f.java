package i6;

import java.util.Arrays;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f6990a = new f();

    public static /* synthetic */ boolean g(f fVar, int i10, int i11, int[] iArr, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            iArr = null;
        }
        return fVar.f(i10, i11, iArr);
    }

    public static /* synthetic */ boolean i(f fVar, String str, int i10, int[] iArr, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            iArr = null;
        }
        return fVar.h(str, i10, iArr);
    }

    public final boolean a(String str, int i10, int[] iArr) {
        if (str != null && str.length() != 0 && (i10 != 0 || (iArr != null && iArr.length != 0))) {
            int[] iArrC = c(i10, iArr);
            int i11 = 0;
            while (i11 < str.length()) {
                char cCharAt = str.charAt(i11);
                int i12 = i10;
                if (g(this, cCharAt, i12, null, 4, null)) {
                    return true;
                }
                if (iArrC != null && k7.i.g(iArrC, cCharAt)) {
                    return true;
                }
                i11++;
                i10 = i12;
            }
        }
        return false;
    }

    public final boolean b(String str, int[] iArr) {
        return a(str, 0, iArr);
    }

    public final int[] c(int i10, int[] iArr) {
        if (iArr == null || iArr.length == 0 || i10 == 0) {
            return iArr;
        }
        int[] iArr2 = new int[iArr.length];
        int length = iArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = iArr[i11];
            int i14 = i10;
            if (!g(this, i13, i14, null, 4, null)) {
                iArr2[i12] = i13;
                i12++;
            }
            i11++;
            i10 = i14;
        }
        if (i12 <= 0) {
            return null;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr2, i12);
        kotlin.jvm.internal.h.e(iArrCopyOf, "copyOf(...)");
        if (i12 > 1) {
            k7.h.f(iArrCopyOf);
        }
        return iArrCopyOf;
    }

    public final int d(String str, int i10) {
        if (str != null && str.length() > i10) {
            int length = str.length();
            while (i10 < length) {
                if (e(str.charAt(i10))) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    public final boolean e(char c10) {
        return c10 == ' ' || c10 == '\n' || c10 == '\t' || c10 == '\u00a0' || v7.a.c(c10);
    }

    public final boolean f(int i10, int i11, int[] iArr) {
        if (i11 != 0) {
            if ((i11 & 1) != 0 && i10 >= 65 && i10 <= 90) {
                return true;
            }
            if ((i11 & 2) != 0 && i10 >= 97 && i10 <= 122) {
                return true;
            }
            if ((i11 & 4) != 0 && i10 >= 48 && i10 <= 57) {
                return true;
            }
            if ((i11 & 8) != 0 && ((i10 >= 48 && i10 <= 57) || ((i10 >= 97 && i10 <= 102) || (i10 >= 65 && i10 <= 70)))) {
                return true;
            }
        }
        if (iArr != null) {
            if (!(iArr.length == 0) && k7.i.g(iArr, i10)) {
                return true;
            }
        }
        return false;
    }

    public final boolean h(String str, int i10, int[] iArr) {
        if (str == null || str.length() <= 0 || (i10 == 0 && (iArr == null || iArr.length == 0))) {
            return false;
        }
        int[] iArrC = c(i10, iArr);
        int i11 = 0;
        while (i11 < str.length()) {
            char cCharAt = str.charAt(i11);
            int i12 = i10;
            if (!g(this, cCharAt, i12, null, 4, null) && (iArrC == null || !k7.i.g(iArrC, cCharAt))) {
                return false;
            }
            i11++;
            i10 = i12;
        }
        return true;
    }
}
