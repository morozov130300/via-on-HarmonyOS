package c6;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2 f1958a = new a2();

    public final String a(String str, String str2) {
        b0 b0Var = b0.f1960a;
        if (str == null) {
            str = "";
        }
        String strD = b0Var.d(str);
        if (str2 == null || str2.length() == 0) {
            str2 = "Untitled";
        }
        String str3 = "<head><title>" + b0Var.d(str2) + "</title><meta charset=\"utf-8\" name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no, minimal-ui\"><style>body{font-family:-apple-system;text-align:center;margin-top:120px;color:black}@media(prefers-color-scheme:dark){body{color:white}}</style></head><body>" + strD + "</body>";
        String strG = b0Var.g(str3);
        if (strG != null) {
            str3 = strG;
        }
        return "data:text/html," + str3;
    }

    public final String b(String str) {
        int iS;
        if (str != null && str.length() != 0 && !kotlin.text.x.D(str, "https://fastly.jsdelivr.net/", false, 2, null)) {
            if (str.length() > 25 && kotlin.text.x.D(str, "https://cdn.jsdelivr.net/", false, 2, null)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("https://fastly.jsdelivr.net/");
                String strSubstring = str.substring(25);
                kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                sb2.append(strSubstring);
                return sb2.toString();
            }
            if (str.length() > 34 && kotlin.text.x.D(str, "https://raw.githubusercontent.com/", false, 2, null)) {
                int iS2 = kotlin.text.z.S(str, '/', 34, false, 4, null);
                if (iS2 < 0 || (iS = kotlin.text.z.S(str, '/', iS2 + 1, false, 4, null)) <= 0) {
                    return null;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("https://fastly.jsdelivr.net/gh/");
                String strSubstring2 = str.substring(34, iS);
                kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
                sb3.append(strSubstring2);
                sb3.append('@');
                String strSubstring3 = str.substring(iS + 1);
                kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
                sb3.append(strSubstring3);
                return sb3.toString();
            }
            if (str.length() > 19 && kotlin.text.x.D(str, "https://github.com/", false, 2, null)) {
                int iT = kotlin.text.z.T(str, "/blob/", 19, false, 4, null);
                if (iT == -1 || iT >= str.length() - 6) {
                    return null;
                }
                StringBuilder sb4 = new StringBuilder();
                String strSubstring4 = str.substring(19, iT);
                kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
                sb4.append(strSubstring4);
                sb4.append('@');
                String strSubstring5 = str.substring(iT + 6);
                kotlin.jvm.internal.h.e(strSubstring5, "substring(...)");
                sb4.append(strSubstring5);
                return "https://fastly.jsdelivr.net/gh/" + sb4.toString();
            }
            if (str.length() > 18 && kotlin.text.x.D(str, "https://unpkg.com/", false, 2, null)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("https://fastly.jsdelivr.net/npm/");
                String strSubstring6 = str.substring(18);
                kotlin.jvm.internal.h.e(strSubstring6, "substring(...)");
                sb5.append(strSubstring6);
                return sb5.toString();
            }
        }
        return null;
    }

    public final String c(String str) {
        int iY;
        int iY2;
        String strG = g(str);
        if (strG.length() == 0) {
            return "";
        }
        if (p(strG) || (iY = kotlin.text.z.Y(strG, '.', 0, false, 6, null)) < 0 || (iY2 = kotlin.text.z.Y(strG, '.', iY - 1, false, 4, null)) < 0) {
            return strG;
        }
        String strSubstring = strG.substring(iY + 1);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        Locale locale = Locale.ROOT;
        String lowerCase = strSubstring.toLowerCase(locale);
        kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
        int i10 = iY2 + 1;
        String strSubstring2 = strG.substring(i10, iY);
        kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
        String lowerCase2 = strSubstring2.toLowerCase(locale);
        kotlin.jvm.internal.h.e(lowerCase2, "toLowerCase(...)");
        if (kotlin.text.x.s("io", lowerCase, true) && kotlin.text.x.s("github", lowerCase2, true)) {
            int iY3 = kotlin.text.z.Y(strG, '.', iY2 - 1, false, 4, null);
            if (iY3 >= 0) {
                String strSubstring3 = strG.substring(iY3 + 1);
                kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
                return strSubstring3;
            }
        } else {
            String[] strArr = {"com", "net", "org", "gov", "co", "edu"};
            for (int i11 = 0; i11 < 6; i11++) {
                if (kotlin.text.x.s(strArr[i11], lowerCase, true)) {
                    String strSubstring4 = strG.substring(i10);
                    kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
                    return strSubstring4;
                }
            }
            int iY4 = kotlin.text.z.Y(strG, '.', iY2 - 1, false, 4, null);
            if (iY4 >= 0) {
                String strSubstring5 = strG.substring(iY4 + 1);
                kotlin.jvm.internal.h.e(strSubstring5, "substring(...)");
                return strSubstring5;
            }
        }
        return strG;
    }

    public final String d(String str) {
        int[] iArrE = e(str);
        if (iArrE != null && iArrE.length == 2 && str != null) {
            String strSubstring = str.substring(iArrE[0], iArrE[1]);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (strSubstring != null) {
                String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
                return lowerCase;
            }
        }
        return null;
    }

    public final int[] e(String str) {
        if (str != null && str.length() != 0) {
            int length = str.length();
            int i10 = -1;
            for (int length2 = str.length() - 1; -1 < length2; length2--) {
                char cCharAt = str.charAt(length2);
                if (cCharAt == '#' || cCharAt == '?') {
                    length = length2;
                } else if (cCharAt != '.') {
                    if (cCharAt == '/') {
                        if (i10 != -1 && i10 <= length && (length2 < 2 || str.charAt(length2 - 1) != '/' || str.charAt(length2 - 2) != ':')) {
                            break;
                            break;
                            break;
                        }
                        return null;
                    }
                } else if (i10 == -1 || i10 > length) {
                    i10 = length2 + 1;
                }
            }
            if (i10 != -1 && i10 < length) {
                return new int[]{i10, length};
            }
        }
        return null;
    }

    public final String f(String str) {
        int iT;
        if (str == null || (iT = kotlin.text.z.T(str, "://", 0, false, 6, null)) == -1) {
            return "";
        }
        int i10 = iT + 3;
        int iS = kotlin.text.z.S(str, '/', i10, false, 4, null);
        if (iS == -1) {
            iS = str.length();
        }
        String strSubstring = str.substring(i10, iS);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String g(String str) {
        int iT;
        if (str == null || (iT = kotlin.text.z.T(str, "://", 0, false, 6, null)) == -1) {
            return "";
        }
        int i10 = iT + 3;
        int iS = kotlin.text.z.S(str, '/', i10, false, 4, null);
        if (iS == -1) {
            iS = str.length();
        }
        String strSubstring = str.substring(i10, iS);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        int iS2 = kotlin.text.z.S(strSubstring, ':', 0, false, 6, null);
        if (iS2 == -1) {
            return strSubstring;
        }
        String strSubstring2 = strSubstring.substring(0, iS2);
        kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
        return strSubstring2;
    }

    public final String h(String str, String str2, boolean z10) {
        int iS;
        String str3;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || (iS = kotlin.text.z.S(str, '?', 0, false, 6, null)) < 0) {
            return null;
        }
        int iS2 = kotlin.text.z.S(str, '#', 0, false, 6, null);
        if (iS2 < 0) {
            iS2 = str.length();
        }
        int i10 = iS2;
        int i11 = iS + 1;
        while (i11 < i10) {
            int iS3 = kotlin.text.z.S(str, '&', i11, false, 4, null);
            int iMin = iS3 < 0 ? i10 : Math.min(iS3, i10);
            int i12 = iMin - i11;
            if (i12 == str2.length() - 1 && kotlin.text.z.L(str2, '=', false, 2, null)) {
                int i13 = i11;
                String str4 = str2;
                boolean zT = kotlin.text.x.t(str, i13, str4, 0, i12, (16 & 16) != 0 ? false : false);
                i11 = i13;
                str3 = str4;
                if (zT) {
                    return "";
                }
            } else {
                str3 = str2;
            }
            if (str3.length() + i11 <= iMin && kotlin.text.x.C(str, str3, i11, false, 4, null)) {
                String strSubstring = str.substring(i11 + str3.length(), iMin);
                kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                return z10 ? b0.f1960a.f(strSubstring) : strSubstring;
            }
            i11 = iMin + 1;
            str2 = str3;
        }
        return null;
    }

    public final String i(String str, String str2, int i10, boolean z10) {
        String str3;
        char cCharAt;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str2.length() + i10 >= str.length()) {
            return null;
        }
        int length = str2.length();
        int i11 = i10;
        while (true) {
            str3 = str;
            String str4 = str2;
            int iT = kotlin.text.z.T(str3, str4, i11, false, 4, null);
            if (iT >= 0) {
                if (iT > 0 && ((cCharAt = str3.charAt(iT - 1)) == '&' || cCharAt == '?')) {
                    i11 = iT + length;
                    break;
                }
                i11 = iT + length;
                if (i11 < 0) {
                    break;
                }
                str = str3;
                str2 = str4;
            } else {
                return null;
            }
        }
        int iS = kotlin.text.z.S(str3, '&', i11, false, 4, null);
        int iS2 = kotlin.text.z.S(str3, '#', i11, false, 4, null);
        if (iS2 > 0 && (iS2 < iS || iS < 0)) {
            iS = iS2;
        }
        if (iS < 0) {
            iS = str3.length();
        }
        if (!z10) {
            String strSubstring = str3.substring(i11, iS);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        b0 b0Var = b0.f1960a;
        String strSubstring2 = str3.substring(i11, iS);
        kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
        return b0Var.f(strSubstring2);
    }

    public final boolean j(String str) {
        if (str != null && str.length() > 6) {
            String strSubstring = str.substring(0, 6);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (kotlin.text.x.s(strSubstring, "about:", true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean k(String str) {
        if (str == null || str.length() < 2 || str.length() > 4) {
            return false;
        }
        v1 v1Var = v1.f2123a;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
        switch (v1Var.b(lowerCase)) {
            case 28452687:
            case 64265976:
            case 81264632:
            case 126179678:
            case 165189410:
            case 332272014:
            case 349563905:
            case 386741379:
            case 389695411:
            case 401942050:
            case 549370325:
            case 689844662:
            case 763428773:
            case 796594828:
            case 800031551:
            case 819479319:
            case 932348892:
            case 985168431:
            case 994678331:
            case 1007696517:
            case 1115827628:
            case 1172229415:
            case 1173231464:
            case 1307856461:
            case 1454795260:
            case 1558932844:
            case 1592227892:
            case 1625637477:
            case 1693611228:
            case 1739555145:
            case 1760659091:
            case 1775475377:
            case 1999275047:
            case 2013460932:
            case 2015764437:
            case 2061805411:
            case 2093577775:
                return true;
            default:
                return false;
        }
    }

    public final boolean l(String str) {
        if (str != null && str.length() > 4) {
            String strSubstring = str.substring(0, 5);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (kotlin.text.x.s(strSubstring, "data:", true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean m(String str) {
        if (str != null && str.length() > 6) {
            String strSubstring = str.substring(0, 7);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (kotlin.text.x.s(strSubstring, "file://", true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean n(String str) {
        if (str != null && str.length() > 6) {
            String strSubstring = str.substring(0, 7);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (kotlin.text.x.s(strSubstring, "http://", true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean o(String str) {
        if (str != null && str.length() > 7) {
            String strSubstring = str.substring(0, 8);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (kotlin.text.x.s(strSubstring, "https://", true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean p(String str) {
        if (kotlin.text.x.D(str, "[", false, 2, null) || kotlin.text.z.I(str, ":", false, 2, null)) {
            return true;
        }
        int length = str.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '.') {
                i10++;
            } else if (kotlin.jvm.internal.h.h(cCharAt, 48) < 0 || kotlin.jvm.internal.h.h(cCharAt, 57) > 0) {
                return false;
            }
        }
        return i10 == 3;
    }

    public final boolean q(String str) {
        if (str != null && str.length() > 10) {
            String strSubstring = str.substring(0, 11);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (kotlin.text.x.s(strSubstring, "javascript:", true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean r(String str) {
        if (p(str)) {
            return true;
        }
        int length = kotlin.text.b0.A0(str) == '.' ? str.length() - 1 : str.length();
        int iY = kotlin.text.z.Y(str, '.', length - 1, false, 4, null);
        int i10 = iY + 1;
        if (i10 == 0) {
            return true;
        }
        v1 v1Var = v1.f2123a;
        String strSubstring = str.substring(i10, length);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        Locale locale = Locale.ROOT;
        String lowerCase = strSubstring.toLowerCase(locale);
        kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
        switch (v1Var.b(lowerCase)) {
            case 186586613:
                String strSubstring2 = str.substring(kotlin.text.z.Y(str, '.', iY - 1, false, 4, null) + 1, iY);
                kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
                String lowerCase2 = strSubstring2.toLowerCase(locale);
                kotlin.jvm.internal.h.e(lowerCase2, "toLowerCase(...)");
                return v1Var.b(lowerCase2) == 233246255;
            case 233246255:
            case 689013009:
            case 884420632:
            case 1578185509:
                return true;
            default:
                return false;
        }
    }

    public final boolean s(String str) {
        if (str == null || str.length() < 2 || str.length() > 5) {
            return false;
        }
        v1 v1Var = v1.f2123a;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
        switch (v1Var.b(lowerCase)) {
            case 3847354:
            case 9568862:
            case 81264632:
            case 81930561:
            case 107123353:
            case 126179678:
            case 140994747:
            case 172819050:
            case 190100404:
            case 313906034:
            case 324664358:
            case 349563905:
            case 394057630:
            case 401942050:
            case 414455207:
            case 415430052:
            case 428139183:
            case 479113676:
            case 512218191:
            case 521295666:
            case 560628411:
            case 608526472:
            case 622106444:
            case 687482999:
            case 718140131:
            case 733429268:
            case 807282548:
            case 831243175:
            case 838714884:
            case 843086363:
            case 846958475:
            case 851561760:
            case 855761738:
            case 912646323:
            case 917017690:
            case 930611925:
            case 937672157:
            case 957034884:
            case 985168431:
            case 994678331:
            case 1000779705:
            case 1014739318:
            case 1103121146:
            case 1108586424:
            case 1123614135:
            case 1155674324:
            case 1161994020:
            case 1215239210:
            case 1234200878:
            case 1319876930:
            case 1321096783:
            case 1387028997:
            case 1413036331:
            case 1458270773:
            case 1558932844:
            case 1583569252:
            case 1625637477:
            case 1734170793:
            case 1739555145:
            case 1740189627:
            case 1768878331:
            case 1778226052:
            case 1792002250:
            case 1809528708:
            case 1810343100:
            case 1876522621:
            case 1944662444:
            case 1990761014:
            case 1999275047:
            case 2015764437:
            case 2022745637:
            case 2061805411:
            case 2072937858:
            case 2075848807:
            case 2093577775:
                return true;
            default:
                return false;
        }
    }

    public final boolean t(String str) {
        if (str == null || str.length() <= 6) {
            return false;
        }
        return n(str) || o(str);
    }

    public final boolean u(String str) {
        return z1.f2142j.b(str).s();
    }

    public final boolean v(String str) {
        if (str != null && str.length() > 12) {
            String strSubstring = str.substring(0, 12);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (kotlin.text.x.s(strSubstring, "view-source:", true)) {
                return true;
            }
        }
        return false;
    }

    public final String w(String str, String str2) {
        z1.a aVar = z1.f2142j;
        z1 z1VarB = aVar.b(str);
        if (str == null || str.length() == 0 || !z1VarB.s()) {
            return y1.f2139a.h(str2, str);
        }
        String string = kotlin.text.z.v0(str).toString();
        StringBuilder sb2 = new StringBuilder();
        int[] iArrD = z1VarB.d();
        if (!z1VarB.n()) {
            if (iArrD != null) {
                String strC = z1VarB.c();
                if (strC == null) {
                    strC = string.substring(iArrD[0], iArrD[1]);
                    kotlin.jvm.internal.h.e(strC, "substring(...)");
                }
                sb2.append(r(aVar.a(strC)) ? "http://" : "https://");
            } else {
                sb2.append("http://");
            }
        }
        if (iArrD != null) {
            String strSubstring = string.substring(0, iArrD[0]);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            sb2.append(strSubstring);
            if (t(string)) {
                String strSubstring2 = string.substring(iArrD[0], iArrD[1]);
                kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
                sb2.append(z0.f2141a.e(aVar.a(strSubstring2)));
            } else {
                String strSubstring3 = string.substring(iArrD[0], iArrD[1]);
                kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
                sb2.append(strSubstring3);
            }
            if (iArrD[1] < string.length()) {
                String strSubstring4 = string.substring(iArrD[1]);
                kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
                sb2.append(strSubstring4);
            }
            d7.h hVar = d7.h.f3935a;
        } else if (q(string)) {
            sb2.append("javascript:");
            String strSubstring5 = string.substring(11);
            kotlin.jvm.internal.h.e(strSubstring5, "substring(...)");
            sb2.append(strSubstring5);
        } else {
            sb2.append(string);
        }
        return sb2.toString();
    }
}
