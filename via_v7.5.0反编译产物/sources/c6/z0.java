package c6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z0 f2141a = new z0();

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
        int i10;
        if (str == null || str.length() == 0 || !kotlin.text.x.D(str, "xn--", false, 2, null)) {
            return str;
        }
        String strX0 = kotlin.text.b0.x0(str, 4);
        ArrayList arrayList = new ArrayList();
        int iY = kotlin.text.z.Y(strX0, '-', 0, false, 6, null);
        if (iY > -1) {
            String strSubstring = strX0.substring(0, iY);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            arrayList.addAll(kotlin.text.b0.E0(strSubstring));
        }
        int length = iY + 1;
        if (length >= strX0.length()) {
            length = strX0.length();
        }
        int size = 128;
        int iA = 72;
        int i11 = 0;
        while (length < strX0.length()) {
            int i12 = 36;
            int i13 = i11;
            int i14 = 1;
            while (length < strX0.length()) {
                int i15 = length + 1;
                Integer numF = f(strX0.charAt(length));
                if (numF == null) {
                    return null;
                }
                int iIntValue = numF.intValue();
                i13 += iIntValue * i14;
                if (i12 <= iA) {
                    i10 = 1;
                } else {
                    i10 = i12 >= iA + 26 ? 26 : i12 - iA;
                }
                if (iIntValue >= i10) {
                    i14 *= 36 - i10;
                    i12 += 36;
                    length = i15;
                } else {
                    iA = a(i13 - i11, arrayList.size() + 1, i11 == 0);
                    size += i13 / (arrayList.size() + 1);
                    int size2 = i13 % (arrayList.size() + 1);
                    arrayList.add(size2, Character.valueOf((char) size));
                    i11 = size2 + 1;
                    length = i15;
                }
            }
            return null;
        }
        return e7.w.E(arrayList, "", null, null, 0, null, null, 62, null);
    }

    public final String c(String str) {
        int i10;
        if (str == null || str.length() == 0) {
            return str;
        }
        int iT = kotlin.text.z.T(str, "xn--", 0, false, 6, null);
        if (iT < 0) {
            return str;
        }
        int iS = kotlin.text.z.S(str, '/', iT, false, 4, null);
        if (iS < 0) {
            iS = str.length();
        }
        StringBuilder sb2 = new StringBuilder();
        if (iT > 0) {
            String strSubstring = str.substring(0, iT);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            sb2.append(strSubstring);
        }
        while (true) {
            int i11 = iT + 4;
            int iMin = Math.min(kotlin.text.z.S(str, '.', i11, false, 4, null), iS);
            if (iMin < 0) {
                iMin = Math.min(kotlin.text.z.S(str, ':', i11, false, 4, null), iS);
            }
            i10 = iMin < 0 ? iS : iMin;
            String strSubstring2 = str.substring(iT, i10);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            sb2.append(b(strSubstring2));
            iT = kotlin.text.z.T(str, "xn--", i11, false, 4, null);
            if (iT < 0 || iT >= iS) {
                break;
            }
            String strSubstring3 = str.substring(i10, iT);
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
        String strZ = kotlin.text.x.z(str, "\u200b", "", false, 4, null);
        StringBuilder sb2 = new StringBuilder();
        int length = strZ.length();
        int i11 = 0;
        while (true) {
            i10 = 128;
            if (i11 >= length) {
                break;
            }
            char cCharAt = strZ.charAt(i11);
            if (cCharAt < 128) {
                sb2.append(cCharAt);
            }
            i11++;
        }
        String string = sb2.toString();
        int length2 = string.length();
        if (length2 == strZ.length()) {
            return strZ;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(string);
        if (length2 > 0) {
            sb3.append('-');
        }
        ArrayList arrayList = new ArrayList(strZ.length());
        for (int i12 = 0; i12 < strZ.length(); i12++) {
            arrayList.add(Integer.valueOf(strZ.charAt(i12)));
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
            Integer num = (Integer) e7.w.G(arrayList2);
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
                        if (i17 < i18) {
                            Character chG = g(i17);
                            if (chG == null) {
                                return null;
                            }
                            sb3.append(chG.charValue());
                            int i19 = i13 + 1;
                            boolean z10 = i13 == length2;
                            i13 = i19;
                            iA = a(i15, i19, z10);
                            i15 = 0;
                            break;
                        }
                        int i20 = i17 - i18;
                        int i21 = 36 - i18;
                        Character chG2 = g(i18 + (i20 % i21));
                        if (chG2 == null) {
                            return null;
                        }
                        sb3.append(chG2.charValue());
                        i17 = i20 / i21;
                        i16 += 36;
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
        int iT = kotlin.text.z.T(str, "://", 0, false, 6, null);
        int i11 = iT < 0 ? 0 : iT + 3;
        int iS = kotlin.text.z.S(str, '/', i11, false, 4, null);
        if (iS < 0) {
            iS = kotlin.text.z.S(str, ':', i11, false, 4, null);
        }
        if (iS < 0) {
            iS = str.length();
        }
        StringBuilder sb2 = new StringBuilder();
        if (i11 > 0) {
            String strSubstring = str.substring(0, i11);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            sb2.append(strSubstring);
        }
        while (true) {
            int iMin = Math.min(kotlin.text.z.S(str, '.', i11, false, 4, null), iS);
            if (iMin < 0) {
                iMin = Math.min(kotlin.text.z.S(str, ':', i11, false, 4, null), iS);
            }
            i10 = iMin < 0 ? iS : iMin;
            String strSubstring2 = str.substring(i11, i10);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            sb2.append(d(strSubstring2));
            int iS2 = kotlin.text.z.S(str, '.', i11, false, 4, null);
            if (iS2 < 0 || iS2 >= iS) {
                break;
            }
            i11 = iS2 + 1;
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
