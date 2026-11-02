package i6;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final g0 f6993a = new g0();

    public final int a(String str, char c10, int i10) {
        if (str != null && i10 < str.length()) {
            int iV = v7.m.v("''\"\"{}()[]<>\u300c\u300d\u300e\u300f\u3010\u3011\u3014\u3015\u3016\u3017\u3018\u3019\u301a\u301b\uff08\uff09\uff3b\uff3d\uff5b\uff5d\uff1c\uff1e\u3008\u3009\u300a\u300b\u2018\u2019\u201c\u201d", c10, 0, false, 6, null);
            char cCharAt = (iV < 0 || iV % 2 != 0) ? ' ' : "''\"\"{}()[]<>\u300c\u300d\u300e\u300f\u3010\u3011\u3014\u3015\u3016\u3017\u3018\u3019\u301a\u301b\uff08\uff09\uff3b\uff3d\uff5b\uff5d\uff1c\uff1e\u3008\u3009\u300a\u300b\u2018\u2019\u201c\u201d".charAt(iV + 1);
            int length = str.length();
            while (i10 < length) {
                char cCharAt2 = str.charAt(i10);
                if (cCharAt2 == cCharAt || f.f6990a.e(cCharAt2)) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    public final String b(String str) {
        String strF = i0.f7006a.f(str);
        if (strF.length() >= 2) {
            int iV = v7.m.v(strF, '.', 0, false, 6, null);
            if (iV == 1 && strF.charAt(0) == 'm' && v7.m.v(strF, '.', iV + 1, false, 4, null) != -1) {
                String strSubstring = strF.substring(2);
                kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                return strSubstring;
            }
            if (iV == 3 && v7.l.n(strF, "www", false, 2, null) && v7.m.v(strF, '.', iV + 1, false, 4, null) != -1) {
                String strSubstring2 = strF.substring(4);
                kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
                return strSubstring2;
            }
        }
        return strF;
    }

    public final String c(String str, String str2, String fallback, int i10) {
        kotlin.jvm.internal.h.f(fallback, "fallback");
        return (str == null || str.length() == 0) ? (str2 == null || str2.length() == 0) ? fallback : v7.o.L(b(str2), i10) : v7.o.L(str, i10);
    }

    public final String d(String str) {
        String str2;
        if (str == null || str.length() == 0) {
            return "";
        }
        int length = str.length();
        if (i0.f7006a.s(str)) {
            str2 = str;
            int iW = v7.m.w(str2, "://", 0, false, 6, null) + 3;
            length -= v7.m.v(str2, '/', iW, false, 4, null) == length + (-1) ? 1 : 0;
            i = iW;
        } else {
            str2 = str;
        }
        String strSubstring = str2.substring(i, Math.min(i + 256, length));
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List e(String str) {
        int iW;
        int i10;
        if (str == null || str.length() < 8) {
            return k7.l.d();
        }
        String string = v7.m.I(str).toString();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < string.length() && (iW = v7.m.w(string, "://", i11, false, 4, null)) >= 0) {
            if (iW >= 5) {
                String strSubstring = string.substring(iW - 5, iW);
                kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                if (v7.l.g(strSubstring, "https", true)) {
                    i10 = -5;
                } else {
                    if (iW >= 4) {
                        String strSubstring2 = string.substring(iW - 4, iW);
                        kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
                        if (v7.l.g(strSubstring2, "http", true)) {
                            i10 = -4;
                        }
                    }
                    i11 = iW + 3;
                }
                int i12 = i10 + iW;
                int i13 = iW + 3;
                int iA = a(string, i12 > 0 ? string.charAt(i12 - 1) : ' ', i13);
                if (iA < 0) {
                    if (i12 == 0) {
                        return k7.l.d();
                    }
                    iA = string.length();
                }
                if (iA > i13) {
                    String strSubstring3 = string.substring(i12, iA);
                    kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
                    if (i0.f7006a.t(strSubstring3)) {
                        arrayList.add(strSubstring3);
                    }
                }
                i11 = iA + 1;
            }
        }
        return arrayList;
    }

    public final String f(String str) {
        if (str == null || str.length() < 8) {
            return str;
        }
        int iW = v7.m.w(str, "://", 0, false, 6, null);
        if (iW < 4) {
            return str;
        }
        if (iW >= 5) {
            String strSubstring = str.substring(iW - 5, iW);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (!v7.l.g("https", strSubstring, true)) {
                String strSubstring2 = str.substring(iW - 4, iW);
                kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
                if (!v7.l.g("http", strSubstring2, true)) {
                    return str;
                }
            }
        }
        int i10 = iW + 3;
        int iV = v7.m.v(str, '/', i10, false, 4, null);
        int iW2 = v7.m.w(str, "xn--", i10, false, 4, null);
        int i11 = (iW2 <= 0 || iW2 < iV) ? iW2 : -1;
        if (iV < 0) {
            if (i11 < 0) {
                return str;
            }
            StringBuilder sb2 = new StringBuilder();
            String strSubstring3 = str.substring(0, i10);
            kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
            sb2.append(strSubstring3);
            v vVar = v.f7049a;
            String strSubstring4 = str.substring(i10);
            kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
            sb2.append(vVar.c(strSubstring4));
            return sb2.toString();
        }
        int iV2 = v7.m.v(str, '%', iV + 1, false, 4, null);
        if (i11 < 0 && iV2 < 0) {
            return str;
        }
        StringBuilder sb3 = new StringBuilder();
        if (i11 > 0) {
            String strSubstring5 = str.substring(0, i10);
            kotlin.jvm.internal.h.e(strSubstring5, "substring(...)");
            sb3.append(strSubstring5);
            v vVar2 = v.f7049a;
            String strSubstring6 = str.substring(i10, iV);
            kotlin.jvm.internal.h.e(strSubstring6, "substring(...)");
            sb3.append(vVar2.c(strSubstring6));
        } else {
            String strSubstring7 = str.substring(0, iV);
            kotlin.jvm.internal.h.e(strSubstring7, "substring(...)");
            sb3.append(strSubstring7);
        }
        if (iV2 > 0) {
            String strSubstring8 = str.substring(iV, iV2);
            kotlin.jvm.internal.h.e(strSubstring8, "substring(...)");
            sb3.append(strSubstring8);
            i iVar = i.f7005a;
            String strSubstring9 = str.substring(iV2);
            kotlin.jvm.internal.h.e(strSubstring9, "substring(...)");
            sb3.append(iVar.c(strSubstring9));
        } else {
            String strSubstring10 = str.substring(iV);
            kotlin.jvm.internal.h.e(strSubstring10, "substring(...)");
            sb3.append(strSubstring10);
        }
        return sb3.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String g(String str, String str2) {
        String str3;
        int i10;
        String str4;
        i0 i0Var;
        String str5;
        int i11;
        int i12;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return null;
        }
        int iV = v7.m.v(str2, '/', 8, false, 4, null);
        String str6 = str2;
        int iW = -1;
        if (iV > 0) {
            int iV2 = v7.m.v(str, '/', 8, false, 4, null);
            String str7 = str;
            if (iV2 < 0) {
                return null;
            }
            if (iV2 == iV) {
                String strSubstring = str6.substring(0, iV - 1);
                kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                if (v7.l.n(str7, strSubstring, false, 2, null)) {
                    i10 = iV;
                    i11 = iV2;
                } else {
                    String[] strArr = {".baidu.com", ".bing.com", "/www.google.com", ".sogou.com"};
                    int i13 = 0;
                    while (true) {
                        if (i13 >= 4) {
                            i10 = iV;
                            i11 = iV2;
                            i12 = -1;
                            break;
                        }
                        String str8 = strArr[i13];
                        int i14 = iV;
                        int i15 = i13;
                        int iB = v7.m.B(str6, str8, i14, false, 4, null);
                        i10 = i14;
                        if (iB > 0) {
                            i11 = iV2;
                            if (v7.m.B(str7, str8, i11, false, 4, null) > 0) {
                                i12 = i15;
                                break;
                            }
                        } else {
                            i11 = iV2;
                        }
                        i13 = i15 + 1;
                        str7 = str;
                        iV2 = i11;
                        iV = i10;
                        str6 = str2;
                    }
                    if (i12 < 0) {
                        return null;
                    }
                }
                int i16 = i11;
                if (v7.m.B(str, ".baidu.com", i11, false, 4, null) <= 0 || v7.m.w(str2, "/s?", i10, false, 4, null) <= 0) {
                    str3 = str;
                } else {
                    str3 = str;
                    if (v7.m.w(str, "/s?", i16, false, 4, null) < 0) {
                        return null;
                    }
                }
            }
        } else {
            str3 = str;
            i10 = iV;
        }
        int iW2 = v7.m.w(str2, "%s", 0, false, 6, null);
        if (iW2 < 0) {
            iW2 = v7.m.w(str2, "%S", 0, false, 6, null);
        }
        if (iW2 < 0) {
            iW2 = v7.m.w(str2, "%@", 0, false, 6, null);
        }
        if (iW2 < 0) {
            iW2 = str2.length();
        }
        int i17 = iW2;
        if (i17 == 0 && str2.length() == 2) {
            return str3;
        }
        int iV3 = v7.m.v(str2, '?', 0, false, 6, null);
        if (i10 < 0) {
            String strSubstring2 = str2.substring(0, (iV3 <= 0 || i17 <= iV3) ? i17 : iV3);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            if (!v7.l.n(str3, strSubstring2, false, 2, null)) {
                return null;
            }
        }
        if (iV3 < 0 || i17 < iV3) {
            String strSubstring3 = str2.substring(0, i17);
            kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
            if (!v7.l.n(str3, strSubstring3, false, 2, null)) {
                return null;
            }
            if (i17 != str2.length() && i17 != str2.length() - 2) {
                String strSubstring4 = str2.substring(i17 + 2);
                kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
                String str9 = str3;
                int iW3 = v7.m.w(str9, strSubstring4, i17, false, 4, null);
                if (iW3 < 0) {
                    return null;
                }
                i iVar = i.f7005a;
                String strSubstring5 = str9.substring(i17, iW3);
                kotlin.jvm.internal.h.e(strSubstring5, "substring(...)");
                return iVar.c(strSubstring5);
            }
            int iV4 = v7.m.v(str3, '?', i17, false, 4, null);
            if (iV4 < 0) {
                str4 = str;
                iV4 = v7.m.v(str4, '#', i17, false, 4, null);
            } else {
                str4 = str;
            }
            if (iV4 < 0) {
                iV4 = str4.length();
            }
            i iVar2 = i.f7005a;
            String strSubstring6 = str4.substring(i17, iV4);
            kotlin.jvm.internal.h.e(strSubstring6, "substring(...)");
            return iVar2.c(strSubstring6);
        }
        int iA = v7.m.A(str2, '&', i17, false, 4, null);
        if (iA >= 0) {
            iV3 = Math.max(iV3, iA);
        }
        int i18 = iV3 + 1;
        if (i18 >= i17) {
            return null;
        }
        String strSubstring7 = str2.substring(i18, i17);
        kotlin.jvm.internal.h.e(strSubstring7, "substring(...)");
        i0 i0Var2 = i0.f7006a;
        String strH = i0Var2.h(str3, strSubstring7, 0, false);
        if (strH == null) {
            int i19 = i10;
            i0Var = i0Var2;
            if (v7.m.B(str2, ".baidu.com", i19, false, 4, null) > 0) {
                strSubstring7 = "wd=";
                strH = i0Var.h(str3, "wd=", 0, false);
            }
        } else {
            i0Var = i0Var2;
        }
        String str10 = strH;
        if (str10 == null || i17 == str2.length() || i17 == str2.length() - 2) {
            if (str10 == null) {
                return null;
            }
            return i.f7005a.c(str10);
        }
        String strH2 = i0Var.h(str2, strSubstring7, iV3, false);
        if (strH2 == null || str10.length() < strH2.length() - 2) {
            return null;
        }
        if (strH2.length() == 2) {
            return i.f7005a.c(str10);
        }
        int iW4 = v7.m.w(strH2, "%s", 0, false, 6, null);
        if (iW4 < 0) {
            iW4 = v7.m.w(strH2, "%S", 0, false, 6, null);
        }
        if (iW4 < 0) {
            iW4 = v7.m.w(strH2, "%@", 0, false, 6, null);
        }
        int i20 = iW4;
        if (i20 < 0) {
            str5 = str10;
        } else {
            String strSubstring8 = strH2.substring(i20 + 2);
            kotlin.jvm.internal.h.e(strSubstring8, "substring(...)");
            str5 = str10;
            iW = v7.m.w(str5, strSubstring8, 0, false, 6, null);
        }
        if (iW < 0) {
            return null;
        }
        i iVar3 = i.f7005a;
        String strSubstring9 = str5.substring(i20, iW);
        kotlin.jvm.internal.h.e(strSubstring9, "substring(...)");
        return iVar3.c(strSubstring9);
    }

    public final String h(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return str2;
        }
        String strD = i.f7005a.d(v7.m.I(str2).toString());
        if (strD == null) {
            strD = "";
        }
        StringBuilder sb2 = new StringBuilder();
        int iW = v7.m.w(str, "%@", 0, false, 6, null);
        if (iW < 0) {
            iW = v7.m.w(str, "%s", 0, false, 6, null);
        }
        if (iW < 0) {
            iW = v7.m.w(str, "%S", 0, false, 6, null);
        }
        if (iW == 0 && str.length() == 2) {
            return str2;
        }
        if (iW >= 0) {
            String strSubstring = str.substring(0, iW);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            sb2.append(strSubstring);
            sb2.append(strD);
            String strSubstring2 = str.substring(iW + 2);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            sb2.append(strSubstring2);
        } else {
            sb2.append(str);
            sb2.append(strD);
        }
        return sb2.toString();
    }
}
