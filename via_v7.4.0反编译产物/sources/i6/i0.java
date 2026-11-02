package i6;

import i6.h0;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public static final i0 f7006a = new i0();

    public final String a(String str, String str2) {
        i iVar = i.f7005a;
        if (str == null) {
            str = "";
        }
        String strA = iVar.a(str);
        if (str2 == null || str2.length() == 0) {
            str2 = "Untitled";
        }
        String str3 = "<head><title>" + iVar.a(str2) + "</title><meta charset=\"utf-8\" name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no, minimal-ui\"><style>body{font-family:-apple-system;text-align:center;margin-top:120px;color:black}@media(prefers-color-scheme:dark){body{color:white}}</style></head><body>" + strA + "</body>";
        String strD = iVar.d(str3);
        if (strD != null) {
            str3 = strD;
        }
        return "data:text/html," + str3;
    }

    public final String b(String str) {
        int iA;
        int iA2;
        String strF = f(str);
        if (strF.length() == 0) {
            return "";
        }
        if (o(strF) || (iA = v7.m.A(strF, '.', 0, false, 6, null)) < 0 || (iA2 = v7.m.A(strF, '.', iA - 1, false, 4, null)) < 0) {
            return strF;
        }
        String strSubstring = strF.substring(iA + 1);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        Locale locale = Locale.ROOT;
        String lowerCase = strSubstring.toLowerCase(locale);
        kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
        int i10 = iA2 + 1;
        String strSubstring2 = strF.substring(i10, iA);
        kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
        String lowerCase2 = strSubstring2.toLowerCase(locale);
        kotlin.jvm.internal.h.e(lowerCase2, "toLowerCase(...)");
        if (v7.l.g("io", lowerCase, true) && v7.l.g("github", lowerCase2, true)) {
            int iA3 = v7.m.A(strF, '.', iA2 - 1, false, 4, null);
            if (iA3 >= 0) {
                String strSubstring3 = strF.substring(iA3 + 1);
                kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
                return strSubstring3;
            }
        } else {
            String[] strArr = {"com", "net", "org", "gov", "co", "edu"};
            for (int i11 = 0; i11 < 6; i11++) {
                if (v7.l.g(strArr[i11], lowerCase, true)) {
                    String strSubstring4 = strF.substring(i10);
                    kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
                    return strSubstring4;
                }
            }
            int iA4 = v7.m.A(strF, '.', iA2 - 1, false, 4, null);
            if (iA4 >= 0) {
                String strSubstring5 = strF.substring(iA4 + 1);
                kotlin.jvm.internal.h.e(strSubstring5, "substring(...)");
                return strSubstring5;
            }
        }
        return strF;
    }

    public final String c(String str) {
        int[] iArrD = d(str);
        if (iArrD != null && iArrD.length == 2 && str != null) {
            String strSubstring = str.substring(iArrD[0], iArrD[1]);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (strSubstring != null) {
                String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
                return lowerCase;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0052, code lost:
    
        if (r4 == (-1)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0054, code lost:
    
        if (r4 < r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005b, code lost:
    
        return new int[]{r4, r1};
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int[] d(String str) {
        if (str != null && str.length() != 0) {
            int length = str.length();
            int length2 = str.length() - 1;
            int i10 = -1;
            while (true) {
                if (-1 >= length2) {
                    break;
                }
                char cCharAt = str.charAt(length2);
                if (cCharAt == '#' || cCharAt == '?') {
                    length = length2;
                } else if (cCharAt != '.') {
                    if (cCharAt == '/') {
                        if (i10 == -1 || i10 > length || (length2 >= 2 && str.charAt(length2 - 1) == '/' && str.charAt(length2 - 2) == ':')) {
                            return null;
                        }
                    }
                } else if (i10 == -1 || i10 > length) {
                    i10 = length2 + 1;
                }
                length2--;
            }
        }
        return null;
    }

    public final String e(String str) {
        int iW;
        if (str == null || (iW = v7.m.w(str, "://", 0, false, 6, null)) == -1) {
            return "";
        }
        int i10 = iW + 3;
        int iV = v7.m.v(str, '/', i10, false, 4, null);
        if (iV == -1) {
            iV = str.length();
        }
        String strSubstring = str.substring(i10, iV);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String f(String str) {
        int iW;
        if (str == null || (iW = v7.m.w(str, "://", 0, false, 6, null)) == -1) {
            return "";
        }
        int i10 = iW + 3;
        int iV = v7.m.v(str, '/', i10, false, 4, null);
        if (iV == -1) {
            iV = str.length();
        }
        String strSubstring = str.substring(i10, iV);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        int iV2 = v7.m.v(strSubstring, ':', 0, false, 6, null);
        if (iV2 == -1) {
            return strSubstring;
        }
        String strSubstring2 = strSubstring.substring(0, iV2);
        kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
        return strSubstring2;
    }

    public final String g(String str, String str2, boolean z10) {
        return h(str, str2, 0, z10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        r4 = r9 + r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String h(String str, String str2, int i10, boolean z10) {
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
            int iW = v7.m.w(str3, str4, i11, false, 4, null);
            if (iW >= 0) {
                if (iW > 0 && ((cCharAt = str3.charAt(iW - 1)) == '&' || cCharAt == '?')) {
                    break;
                }
                i11 = iW + length;
                if (i11 < 0) {
                    break;
                }
                str = str3;
                str2 = str4;
            } else {
                return null;
            }
        }
        int iV = v7.m.v(str3, '&', i11, false, 4, null);
        int iV2 = v7.m.v(str3, '#', i11, false, 4, null);
        if (iV2 > 0 && (iV2 < iV || iV < 0)) {
            iV = iV2;
        }
        if (iV < 0) {
            iV = str3.length();
        }
        if (!z10) {
            String strSubstring = str3.substring(i11, iV);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        i iVar = i.f7005a;
        String strSubstring2 = str3.substring(i11, iV);
        kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
        return iVar.c(strSubstring2);
    }

    public final boolean i(String str) {
        if (str != null && str.length() > 6) {
            String strSubstring = str.substring(0, 6);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (v7.l.g(strSubstring, "about:", true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(String str) {
        if (str == null || str.length() < 2 || str.length() > 4) {
            return false;
        }
        d0 d0Var = d0.f6987a;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
        switch (d0Var.b(lowerCase)) {
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

    public final boolean k(String str) {
        if (str != null && str.length() > 4) {
            String strSubstring = str.substring(0, 5);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (v7.l.g(strSubstring, "data:", true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean l(String str) {
        if (str != null && str.length() > 6) {
            String strSubstring = str.substring(0, 7);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (v7.l.g(strSubstring, "file://", true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean m(String str) {
        if (str != null && str.length() > 6) {
            String strSubstring = str.substring(0, 7);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (v7.l.g(strSubstring, "http://", true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean n(String str) {
        if (str != null && str.length() > 7) {
            String strSubstring = str.substring(0, 8);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (v7.l.g(strSubstring, "https://", true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean o(String str) {
        if (v7.l.n(str, "[", false, 2, null) || v7.m.p(str, ":", false, 2, null)) {
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

    public final boolean p(String str) {
        if (str != null && str.length() > 10) {
            String strSubstring = str.substring(0, 11);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (v7.l.g(strSubstring, "javascript:", true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean q(String str) {
        if (o(str)) {
            return true;
        }
        int length = v7.o.K(str) == '.' ? str.length() - 1 : str.length();
        int iA = v7.m.A(str, '.', length - 1, false, 4, null);
        int i10 = iA + 1;
        if (i10 == 0) {
            return true;
        }
        d0 d0Var = d0.f6987a;
        String strSubstring = str.substring(i10, length);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        Locale locale = Locale.ROOT;
        String lowerCase = strSubstring.toLowerCase(locale);
        kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
        switch (d0Var.b(lowerCase)) {
            case 186586613:
                String strSubstring2 = str.substring(v7.m.A(str, '.', iA - 1, false, 4, null) + 1, iA);
                kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
                String lowerCase2 = strSubstring2.toLowerCase(locale);
                kotlin.jvm.internal.h.e(lowerCase2, "toLowerCase(...)");
                if (d0Var.b(lowerCase2) == 233246255) {
                }
                break;
            case 233246255:
            case 689013009:
            case 884420632:
            case 1578185509:
                break;
        }
        return true;
    }

    public final boolean r(String str) {
        if (str == null || str.length() < 2 || str.length() > 5) {
            return false;
        }
        d0 d0Var = d0.f6987a;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
        switch (d0Var.b(lowerCase)) {
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

    public final boolean s(String str) {
        if (str == null || str.length() <= 6) {
            return false;
        }
        return m(str) || n(str);
    }

    public final boolean t(String str) {
        return h0.f6995j.b(str).s();
    }

    public final boolean u(String str) {
        if (str != null && str.length() > 12) {
            String strSubstring = str.substring(0, 12);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            if (v7.l.g(strSubstring, "view-source:", true)) {
                return true;
            }
        }
        return false;
    }

    public final String v(String str, String str2) {
        h0.a aVar = h0.f6995j;
        h0 h0VarB = aVar.b(str);
        if (str == null || str.length() == 0 || !h0VarB.s()) {
            return g0.f6993a.h(str2, str);
        }
        String string = v7.m.I(str).toString();
        StringBuilder sb2 = new StringBuilder();
        int[] iArrD = h0VarB.d();
        if (!h0VarB.n()) {
            if (iArrD != null) {
                String strC = h0VarB.c();
                if (strC == null) {
                    strC = string.substring(iArrD[0], iArrD[1]);
                    kotlin.jvm.internal.h.e(strC, "substring(...)");
                }
                sb2.append(q(aVar.a(strC)) ? "http://" : "https://");
            } else {
                sb2.append("http://");
            }
        }
        if (iArrD != null) {
            String strSubstring = string.substring(0, iArrD[0]);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            sb2.append(strSubstring);
            if (s(string)) {
                String strSubstring2 = string.substring(iArrD[0], iArrD[1]);
                kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
                sb2.append(v.f7049a.e(aVar.a(strSubstring2)));
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
            j7.f fVar = j7.f.f7594a;
        } else if (p(string)) {
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
