package i6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f7049a = new v();

    public final int a(int i10, int i11, boolean z10) {
        int i12 = z10 ? i10 / 700 : i10 / 2;
        int i13 = i12 + (i12 / i11);
        int i14 = 0;
        while (i13 > 455) {
            i13 /= 35;
            i14 += 36;
        }
        return i14 + ((i13 * 36) / (i13 + 38));
    }

    public final String b(String str) {
        if (str == null || str.length() == 0 || !v7.l.n(str, "xn--", false, 2, null)) {
            return str;
        }
        String strJ = v7.o.J(str, 4);
        ArrayList arrayList = new ArrayList();
        int iA = v7.m.A(strJ, '-', 0, false, 6, null);
        if (iA > -1) {
            String strSubstring = strJ.substring(0, iA);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            arrayList.addAll(v7.o.N(strSubstring));
        }
        int length = iA + 1;
        if (length >= strJ.length()) {
            length = strJ.length();
        }
        int size = 128;
        int iA2 = 72;
        int i10 = 0;
        while (length < strJ.length()) {
            int i11 = 36;
            int i12 = i10;
            int i13 = 1;
            while (length < strJ.length()) {
                int i14 = length + 1;
                Integer numF = f(strJ.charAt(length));
                if (numF == null) {
                    return null;
                }
                int iIntValue = numF.intValue();
                i12 += iIntValue * i13;
                int i15 = i11 <= iA2 ? 1 : i11 >= iA2 + 26 ? 26 : i11 - iA2;
                if (iIntValue >= i15) {
                    i13 *= 36 - i15;
                    i11 += 36;
                    length = i14;
                } else {
                    iA2 = a(i12 - i10, arrayList.size() + 1, i10 == 0);
                    size += i12 / (arrayList.size() + 1);
                    int size2 = i12 % (arrayList.size() + 1);
                    arrayList.add(size2, Character.valueOf((char) size));
                    i10 = size2 + 1;
                    length = i14;
                }
            }
            return null;
        }
        return k7.t.t(arrayList, "", null, null, 0, null, null, 62, null);
    }

    public final String c(String str) {
        int i10;
        if (str == null || str.length() == 0) {
            return str;
        }
        int iW = v7.m.w(str, "xn--", 0, false, 6, null);
        if (iW < 0) {
            return str;
        }
        int iV = v7.m.v(str, '/', iW, false, 4, null);
        if (iV < 0) {
            iV = str.length();
        }
        StringBuilder sb2 = new StringBuilder();
        if (iW > 0) {
            String strSubstring = str.substring(0, iW);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            sb2.append(strSubstring);
        }
        while (true) {
            int i11 = iW + 4;
            int iMin = Math.min(v7.m.v(str, '.', i11, false, 4, null), iV);
            if (iMin < 0) {
                iMin = Math.min(v7.m.v(str, ':', i11, false, 4, null), iV);
            }
            i10 = iMin < 0 ? iV : iMin;
            String strSubstring2 = str.substring(iW, i10);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            sb2.append(b(strSubstring2));
            iW = v7.m.w(str, "xn--", i11, false, 4, null);
            if (iW < 0 || iW >= iV) {
                break;
            }
            String strSubstring3 = str.substring(i10, iW);
            kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
            sb2.append(strSubstring3);
        }
        String strSubstring4 = str.substring(i10);
        kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
        sb2.append(strSubstring4);
        return sb2.toString();
    }

    public final String d(String str) throws IOException {
        int i10;
        if (str == null || str.length() == 0) {
            return str;
        }
        String strJ = v7.l.j(str, "\u200b", "", false, 4, null);
        StringBuilder sb2 = new StringBuilder();
        int length = strJ.length();
        int i11 = 0;
        while (true) {
            i10 = 128;
            if (i11 >= length) {
                break;
            }
            char cCharAt = strJ.charAt(i11);
            if (cCharAt < '\u0080') {
                sb2.append(cCharAt);
            }
            i11++;
        }
        String string = sb2.toString();
        int length2 = string.length();
        if (length2 == strJ.length()) {
            return strJ;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(string);
        if (length2 > 0) {
            sb3.append('-');
        }
        ArrayList arrayList = new ArrayList(strJ.length());
        for (int i12 = 0; i12 < strJ.length(); i12++) {
            arrayList.add(Integer.valueOf(strJ.charAt(i12)));
        }
        int iA = 72;
        int i13 = length2;
        int i14 = 0;
        while (i13 < arrayList.size()) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((Number) obj).intValue() >= i10) {
                    arrayList2.add(obj);
                }
            }
            Integer num = (Integer) k7.t.v(arrayList2);
            if (num == null) {
                return null;
            }
            int iIntValue = num.intValue();
            int i15 = i14 + ((iIntValue - i10) * (i13 + 1));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Number) it.next()).intValue();
                if (iIntValue2 < iIntValue) {
                    i15++;
                } else if (iIntValue2 == iIntValue) {
                    int i16 = 36;
                    int i17 = i15;
                    while (true) {
                        int i18 = i16 <= iA ? 1 : i16 >= iA + 26 ? 26 : i16 - iA;
                        if (i17 >= i18) {
                            int i19 = i17 - i18;
                            int i20 = 36 - i18;
                            Character chG = g(i18 + (i19 % i20));
                            if (chG == null) {
                                return null;
                            }
                            sb3.append(chG.charValue());
                            i17 = i19 / i20;
                            i16 += 36;
                        } else {
                            Character chG2 = g(i17);
                            if (chG2 == null) {
                                return null;
                            }
                            sb3.append(chG2.charValue());
                            int i21 = i13 + 1;
                            boolean z10 = i13 == length2;
                            i13 = i21;
                            iA = a(i15, i21, z10);
                            i15 = 0;
                        }
                    }
                } else {
                    continue;
                }
            }
            i14 = i15 + 1;
            i10 = iIntValue + 1;
        }
        return "xn--" + ((Object) sb3);
    }

    public final String e(String str) {
        int i10;
        if (str == null || str.length() == 0) {
            return str;
        }
        int iW = v7.m.w(str, "://", 0, false, 6, null);
        int i11 = iW < 0 ? 0 : iW + 3;
        int iV = v7.m.v(str, '/', i11, false, 4, null);
        if (iV < 0) {
            iV = v7.m.v(str, ':', i11, false, 4, null);
        }
        if (iV < 0) {
            iV = str.length();
        }
        StringBuilder sb2 = new StringBuilder();
        if (i11 > 0) {
            String strSubstring = str.substring(0, i11);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            sb2.append(strSubstring);
        }
        while (true) {
            int iMin = Math.min(v7.m.v(str, '.', i11, false, 4, null), iV);
            if (iMin < 0) {
                iMin = Math.min(v7.m.v(str, ':', i11, false, 4, null), iV);
            }
            i10 = iMin < 0 ? iV : iMin;
            String strSubstring2 = str.substring(i11, i10);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            sb2.append(d(strSubstring2));
            int iV2 = v7.m.v(str, '.', i11, false, 4, null);
            if (iV2 < 0 || iV2 >= iV) {
                break;
            }
            i11 = iV2 + 1;
            String strSubstring3 = str.substring(i10, i11);
            kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
            sb2.append(strSubstring3);
        }
        String strSubstring4 = str.substring(i10);
        kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
        sb2.append(strSubstring4);
        return sb2.toString();
    }

    public final Integer f(char c10) {
        if ('a' <= c10 && c10 < '{') {
            return Integer.valueOf(c10 - 'a');
        }
        if ('A' <= c10 && c10 < '[') {
            return Integer.valueOf(c10 - 'A');
        }
        if ('0' > c10 || c10 >= ':') {
            return null;
        }
        return Integer.valueOf(c10 - 22);
    }

    public final Character g(int i10) {
        if (i10 >= 0 && i10 < 26) {
            return Character.valueOf((char) (i10 + 97));
        }
        if (26 > i10 || i10 >= 36) {
            return null;
        }
        return Character.valueOf((char) (i10 + 22));
    }
}
