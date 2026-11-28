package c6;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y1 f2139a = new y1();

    public final int a(String str, char c10, int i10) {
        if (str != null && i10 < str.length()) {
            int iS = kotlin.text.z.S("''\"\"{}()[]<>「」『』【】〔〕〖〗〘〙〚〛（）［］｛｝＜＞〈〉《》‘’“”", c10, 0, false, 6, null);
            char cCharAt = (iS < 0 || iS % 2 != 0) ? ' ' : "''\"\"{}()[]<>「」『』【】〔〕〖〗〘〙〚〛（）［］｛｝＜＞〈〉《》‘’“”".charAt(iS + 1);
            int length = str.length();
            while (i10 < length) {
                char cCharAt2 = str.charAt(i10);
                if (cCharAt2 == cCharAt || w.f2124a.e(cCharAt2)) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    public final String b(String str) {
        String strG = a2.f1958a.g(str);
        if (strG.length() >= 2) {
            int iS = kotlin.text.z.S(strG, '.', 0, false, 6, null);
            if (iS == 1 && strG.charAt(0) == 'm' && kotlin.text.z.S(strG, '.', iS + 1, false, 4, null) != -1) {
                String strSubstring = strG.substring(2);
                kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                return strSubstring;
            }
            if (iS == 3 && kotlin.text.x.D(strG, "www", false, 2, null) && kotlin.text.z.S(strG, '.', iS + 1, false, 4, null) != -1) {
                String strSubstring2 = strG.substring(4);
                kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
                return strSubstring2;
            }
        }
        return strG;
    }

    public final String c(String str, String str2, String fallback, int i10) {
        kotlin.jvm.internal.h.f(fallback, "fallback");
        if (str == null || str.length() == 0) {
            return (str2 == null || str2.length() == 0) ? fallback : kotlin.text.b0.C0(b(str2), i10);
        }
        return kotlin.text.b0.C0(str, i10);
    }

    public final String d(String str) {
        String str2;
        if (str == null || str.length() == 0) {
            return "";
        }
        int length = str.length();
        int i10 = 0;
        if (a2.f1958a.t(str)) {
            str2 = str;
            int iT = kotlin.text.z.T(str2, "://", 0, false, 6, null) + 3;
            length -= kotlin.text.z.S(str2, '/', iT, false, 4, null) == length + (-1) ? 1 : 0;
            i10 = iT;
        } else {
            str2 = str;
        }
        String strSubstring = str2.substring(i10, Math.min(i10 + 256, length));
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    /* JADX WARN: Code duplicated, block: B:18:0x0048  */
    /* JADX WARN: Code duplicated, block: B:23:0x005d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0064  */
    /* JADX WARN: Code duplicated, block: B:27:0x006e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0075  */
    /* JADX WARN: Code duplicated, block: B:32:0x007b  */
    /* JADX WARN: Code duplicated, block: B:34:0x008a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0070 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0059 A[SYNTHETIC] */
    public final List e(String str) {
        int iT;
        String strSubstring;
        int i10;
        int i11;
        char cCharAt;
        int i12;
        int iA;
        String strSubstring2;
        if (str == null || str.length() < 8) {
            return e7.o.h();
        }
        String string = kotlin.text.z.v0(str).toString();
        ArrayList arrayList = new ArrayList();
        int i13 = 0;
        while (i13 < string.length() && (iT = kotlin.text.z.T(string, "://", i13, false, 4, null)) >= 0) {
            if (iT >= 5) {
                String strSubstring3 = string.substring(iT - 5, iT);
                kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
                if (kotlin.text.x.s(strSubstring3, "https", true)) {
                    i10 = -5;
                } else {
                    if (iT >= 4) {
                        strSubstring = string.substring(iT - 4, iT);
                        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                        if (kotlin.text.x.s(strSubstring, "http", true)) {
                            i10 = -4;
                        }
                    }
                    i13 = iT + 3;
                }
                i11 = i10 + iT;
                if (i11 > 0) {
                    cCharAt = string.charAt(i11 - 1);
                } else {
                    cCharAt = ' ';
                }
                i12 = iT + 3;
                iA = a(string, cCharAt, i12);
                if (iA < 0) {
                    if (i11 == 0) {
                        return e7.o.h();
                    }
                    iA = string.length();
                }
                if (iA > i12) {
                    strSubstring2 = string.substring(i11, iA);
                    kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
                    if (a2.f1958a.u(strSubstring2)) {
                        arrayList.add(strSubstring2);
                    }
                }
                i13 = iA + 1;
            } else {
                if (iT >= 4) {
                    strSubstring = string.substring(iT - 4, iT);
                    kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                    if (kotlin.text.x.s(strSubstring, "http", true)) {
                        i10 = -4;
                        i11 = i10 + iT;
                        if (i11 > 0) {
                            cCharAt = string.charAt(i11 - 1);
                        } else {
                            cCharAt = ' ';
                        }
                        i12 = iT + 3;
                        iA = a(string, cCharAt, i12);
                        if (iA < 0) {
                            if (i11 == 0) {
                                return e7.o.h();
                            }
                            iA = string.length();
                        }
                        if (iA > i12) {
                            strSubstring2 = string.substring(i11, iA);
                            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
                            if (a2.f1958a.u(strSubstring2)) {
                                arrayList.add(strSubstring2);
                            }
                        }
                        i13 = iA + 1;
                    }
                }
                i13 = iT + 3;
            }
        }
        return arrayList;
    }

    public final String f(String str) {
        if (str == null || str.length() < 8) {
            return str;
        }
        int iT = kotlin.text.z.T(str, "://", 0, false, 6, null);
        if (iT < 4) {
            return str;
        }
        if (iT >= 5) {
            String strSubstring = str.substring(iT - 5, iT);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (!kotlin.text.x.s("https", strSubstring, true)) {
                String strSubstring2 = str.substring(iT - 4, iT);
                kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
                if (!kotlin.text.x.s("http", strSubstring2, true)) {
                    return str;
                }
            }
        }
        int i10 = iT + 3;
        int iS = kotlin.text.z.S(str, '/', i10, false, 4, null);
        int iT2 = kotlin.text.z.T(str, "xn--", i10, false, 4, null);
        int i11 = (iT2 <= 0 || iT2 < iS) ? iT2 : -1;
        if (iS < 0) {
            if (i11 < 0) {
                return str;
            }
            StringBuilder sb2 = new StringBuilder();
            String strSubstring3 = str.substring(0, i10);
            kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
            sb2.append(strSubstring3);
            z0 z0Var = z0.f2141a;
            String strSubstring4 = str.substring(i10);
            kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
            sb2.append(z0Var.c(strSubstring4));
            return sb2.toString();
        }
        int iS2 = kotlin.text.z.S(str, '%', iS + 1, false, 4, null);
        if (i11 < 0 && iS2 < 0) {
            return str;
        }
        StringBuilder sb3 = new StringBuilder();
        if (i11 > 0) {
            String strSubstring5 = str.substring(0, i10);
            kotlin.jvm.internal.h.e(strSubstring5, "substring(...)");
            sb3.append(strSubstring5);
            z0 z0Var2 = z0.f2141a;
            String strSubstring6 = str.substring(i10, iS);
            kotlin.jvm.internal.h.e(strSubstring6, "substring(...)");
            sb3.append(z0Var2.c(strSubstring6));
        } else {
            String strSubstring7 = str.substring(0, iS);
            kotlin.jvm.internal.h.e(strSubstring7, "substring(...)");
            sb3.append(strSubstring7);
        }
        if (iS2 > 0) {
            String strSubstring8 = str.substring(iS, iS2);
            kotlin.jvm.internal.h.e(strSubstring8, "substring(...)");
            sb3.append(strSubstring8);
            b0 b0Var = b0.f1960a;
            String strSubstring9 = str.substring(iS2);
            kotlin.jvm.internal.h.e(strSubstring9, "substring(...)");
            sb3.append(b0Var.f(strSubstring9));
        } else {
            String strSubstring10 = str.substring(iS);
            kotlin.jvm.internal.h.e(strSubstring10, "substring(...)");
            sb3.append(strSubstring10);
        }
        return sb3.toString();
    }

    /* JADX WARN: Code duplicated, block: B:136:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x007a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x007d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0050  */
    /* JADX WARN: Code duplicated, block: B:24:0x0060  */
    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:29:0x007c  */
    /* JADX WARN: Code duplicated, block: B:33:0x008b A[RETURN] */
    public final String g(String str, String str2) {
        String str3;
        int i10;
        String str4;
        a2 a2Var;
        String str5;
        String[] strArr;
        int i11;
        int i12;
        int i13;
        String str6;
        int i14;
        int iZ;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return null;
        }
        int iS = kotlin.text.z.S(str2, '/', 8, false, 4, null);
        String str7 = str2;
        int iT = -1;
        if (iS > 0) {
            int iS2 = kotlin.text.z.S(str, '/', 8, false, 4, null);
            String str8 = str;
            if (iS2 < 0) {
                return null;
            }
            if (iS2 == iS) {
                String strSubstring = str7.substring(0, iS - 1);
                kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                if (kotlin.text.x.D(str8, strSubstring, false, 2, null)) {
                    i10 = iS;
                    i12 = iS2;
                } else {
                    strArr = new String[]{".baidu.com", ".bing.com", "/www.google.com", ".sogou.com"};
                    i11 = 0;
                    while (true) {
                        if (i11 < 4) {
                            i10 = iS;
                            i12 = iS2;
                            i13 = -1;
                            break;
                        }
                        str6 = strArr[i11];
                        int i15 = iS;
                        i14 = i11;
                        iZ = kotlin.text.z.Z(str7, str6, i15, false, 4, null);
                        i10 = i15;
                        if (iZ > 0) {
                            i12 = iS2;
                            if (kotlin.text.z.Z(str8, str6, i12, false, 4, null) > 0) {
                                i13 = i14;
                                break;
                            }
                        } else {
                            i12 = iS2;
                        }
                        i11 = i14 + 1;
                        str8 = str;
                        iS2 = i12;
                        iS = i10;
                        str7 = str2;
                    }
                    if (i13 < 0) {
                        return null;
                    }
                }
            } else {
                strArr = new String[]{".baidu.com", ".bing.com", "/www.google.com", ".sogou.com"};
                i11 = 0;
                while (true) {
                    if (i11 < 4) {
                        i10 = iS;
                        i12 = iS2;
                        i13 = -1;
                        break;
                    }
                    str6 = strArr[i11];
                    int i16 = iS;
                    i14 = i11;
                    iZ = kotlin.text.z.Z(str7, str6, i16, false, 4, null);
                    i10 = i16;
                    if (iZ > 0) {
                        i12 = iS2;
                        if (kotlin.text.z.Z(str8, str6, i12, false, 4, null) > 0) {
                            i13 = i14;
                            break;
                        }
                    } else {
                        i12 = iS2;
                    }
                    i11 = i14 + 1;
                    str8 = str;
                    iS2 = i12;
                    iS = i10;
                    str7 = str2;
                }
                if (i13 < 0) {
                    return null;
                }
            }
            int i17 = i12;
            if (kotlin.text.z.Z(str, ".baidu.com", i12, false, 4, null) <= 0 || kotlin.text.z.T(str2, "/s?", i10, false, 4, null) <= 0) {
                str3 = str;
            } else {
                str3 = str;
                if (kotlin.text.z.T(str, "/s?", i17, false, 4, null) < 0) {
                    return null;
                }
            }
        } else {
            str3 = str;
            i10 = iS;
        }
        int iT2 = kotlin.text.z.T(str2, "%s", 0, false, 6, null);
        if (iT2 < 0) {
            iT2 = kotlin.text.z.T(str2, "%S", 0, false, 6, null);
        }
        if (iT2 < 0) {
            iT2 = kotlin.text.z.T(str2, "%@", 0, false, 6, null);
        }
        if (iT2 < 0) {
            iT2 = str2.length();
        }
        int i18 = iT2;
        if (i18 == 0 && str2.length() == 2) {
            return str3;
        }
        int iS3 = kotlin.text.z.S(str2, '?', 0, false, 6, null);
        if (i10 < 0) {
            String strSubstring2 = str2.substring(0, (iS3 <= 0 || i18 <= iS3) ? i18 : iS3);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            if (!kotlin.text.x.D(str3, strSubstring2, false, 2, null)) {
                return null;
            }
        }
        if (iS3 < 0 || i18 < iS3) {
            String strSubstring3 = str2.substring(0, i18);
            kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
            if (!kotlin.text.x.D(str3, strSubstring3, false, 2, null)) {
                return null;
            }
            if (i18 != str2.length() && i18 != str2.length() - 2) {
                String strSubstring4 = str2.substring(i18 + 2);
                kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
                String str9 = str3;
                int iT3 = kotlin.text.z.T(str9, strSubstring4, i18, false, 4, null);
                if (iT3 < 0) {
                    return null;
                }
                b0 b0Var = b0.f1960a;
                String strSubstring5 = str9.substring(i18, iT3);
                kotlin.jvm.internal.h.e(strSubstring5, "substring(...)");
                return b0Var.f(strSubstring5);
            }
            int iS4 = kotlin.text.z.S(str3, '?', i18, false, 4, null);
            if (iS4 < 0) {
                str4 = str;
                iS4 = kotlin.text.z.S(str4, '#', i18, false, 4, null);
            } else {
                str4 = str;
            }
            if (iS4 < 0) {
                iS4 = str4.length();
            }
            b0 b0Var2 = b0.f1960a;
            String strSubstring6 = str4.substring(i18, iS4);
            kotlin.jvm.internal.h.e(strSubstring6, "substring(...)");
            return b0Var2.f(strSubstring6);
        }
        int iY = kotlin.text.z.Y(str2, '&', i18, false, 4, null);
        if (iY >= 0) {
            iS3 = Math.max(iS3, iY);
        }
        int i19 = iS3 + 1;
        if (i19 >= i18) {
            return null;
        }
        String strSubstring7 = str2.substring(i19, i18);
        kotlin.jvm.internal.h.e(strSubstring7, "substring(...)");
        a2 a2Var2 = a2.f1958a;
        String strI = a2Var2.i(str3, strSubstring7, 0, false);
        if (strI == null) {
            int i20 = i10;
            a2Var = a2Var2;
            if (kotlin.text.z.Z(str2, ".baidu.com", i20, false, 4, null) > 0) {
                strSubstring7 = "wd=";
                strI = a2Var.i(str3, "wd=", 0, false);
            }
        } else {
            a2Var = a2Var2;
        }
        String str10 = strI;
        if (str10 == null || i18 == str2.length() || i18 == str2.length() - 2) {
            if (str10 == null) {
                return null;
            }
            return b0.f1960a.f(str10);
        }
        String strI2 = a2Var.i(str2, strSubstring7, iS3, false);
        if (strI2 == null || str10.length() < strI2.length() - 2) {
            return null;
        }
        if (strI2.length() == 2) {
            return b0.f1960a.f(str10);
        }
        int iT4 = kotlin.text.z.T(strI2, "%s", 0, false, 6, null);
        if (iT4 < 0) {
            iT4 = kotlin.text.z.T(strI2, "%S", 0, false, 6, null);
        }
        if (iT4 < 0) {
            iT4 = kotlin.text.z.T(strI2, "%@", 0, false, 6, null);
        }
        int i21 = iT4;
        if (i21 < 0) {
            str5 = str10;
        } else {
            String strSubstring8 = strI2.substring(i21 + 2);
            kotlin.jvm.internal.h.e(strSubstring8, "substring(...)");
            str5 = str10;
            iT = kotlin.text.z.T(str5, strSubstring8, 0, false, 6, null);
        }
        if (iT < 0) {
            return null;
        }
        b0 b0Var3 = b0.f1960a;
        String strSubstring9 = str5.substring(i21, iT);
        kotlin.jvm.internal.h.e(strSubstring9, "substring(...)");
        return b0Var3.f(strSubstring9);
    }

    public final String h(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return str2;
        }
        String strG = b0.f1960a.g(kotlin.text.z.v0(str2).toString());
        if (strG == null) {
            strG = "";
        }
        StringBuilder sb2 = new StringBuilder();
        int iT = kotlin.text.z.T(str, "%@", 0, false, 6, null);
        if (iT < 0) {
            iT = kotlin.text.z.T(str, "%s", 0, false, 6, null);
        }
        if (iT < 0) {
            iT = kotlin.text.z.T(str, "%S", 0, false, 6, null);
        }
        if (iT == 0 && str.length() == 2) {
            return str2;
        }
        if (iT >= 0) {
            String strSubstring = str.substring(0, iT);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            sb2.append(strSubstring);
            sb2.append(strG);
            String strSubstring2 = str.substring(iT + 2);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            sb2.append(strSubstring2);
        } else {
            sb2.append(str);
            sb2.append(strG);
        }
        return sb2.toString();
    }
}
