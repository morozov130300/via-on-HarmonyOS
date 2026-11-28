package c6;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.CharCategory;
import kotlin.text.Regex;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k1 f2063a = new k1();

    public final String a(String str) {
        Integer numE;
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '%') {
                if (cCharAt != '+') {
                    sb2.append(cCharAt);
                } else {
                    sb2.append(' ');
                }
                i10++;
            } else {
                ArrayList arrayList = new ArrayList();
                while (i10 < str.length() && str.charAt(i10) == '%') {
                    int i11 = i10 + 2;
                    if (i11 < str.length() && (numE = kotlin.text.b.e(str.charAt(i10 + 1), 16)) != null) {
                        int iIntValue = numE.intValue();
                        Integer numE2 = kotlin.text.b.e(str.charAt(i11), 16);
                        if (numE2 != null) {
                            arrayList.add(Byte.valueOf((byte) (numE2.intValue() | (iIntValue << 4))));
                            i10 += 3;
                        }
                    }
                    return str;
                }
                sb2.append(kotlin.text.x.o(e7.w.K(arrayList)));
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.h.e(string, "toString(...)");
        return string;
    }

    public final int b(String str) {
        switch (str.hashCode()) {
            case -2139978370:
                return !str.equals("GM.deleteValue") ? 0 : 1048576;
            case -2137539383:
                return !str.equals("GM_addStyle") ? 0 : 64;
            case -2133519533:
                return !str.equals("GM.getResourceUrl") ? 0 : 67108864;
            case -2119561308:
                return !str.equals("GM_notification") ? 0 : 262144;
            case -2033228435:
                return !str.equals("GM_addValueChangeListener") ? 0 : 8192;
            case -1319624471:
                return !str.equals("GM_xmlhttpRequest") ? 0 : 256;
            case -1283958948:
                return !str.equals("GM.setClipboard") ? 0 : 1073741824;
            case -1277925948:
                return !str.equals("GM_getResourceURL") ? 0 : 16;
            case -1193887625:
                return !str.equals("GM_unregisterMenuCommand") ? 0 : 131072;
            case -1113006537:
                return !str.equals("GM.setValue") ? 0 : 8388608;
            case -968599532:
                return !str.equals("GM_addElement") ? 0 : 128;
            case -961008776:
                return !str.equals("GM_getResourceText") ? 0 : 32;
            case -780817319:
                return !str.equals("GM_listValues") ? 0 : 4;
            case -627715853:
                return !str.equals("GM.notification") ? 0 : 134217728;
            case -551894077:
                return !str.equals("GM.getValue") ? 0 : 2097152;
            case -507350440:
                return !str.equals("GM.xmlHttpRequest") ? 0 : Integer.MIN_VALUE;
            case -314454035:
                return !str.equals("GM_openInTab") ? 0 : 32768;
            case -109892435:
                return !str.equals("GM_deleteValue") ? 0 : 8;
            case 110595393:
                return !str.equals("GM.registerMenuCommand") ? 0 : 536870912;
            case 516037992:
                return !str.equals("GM_setValue") ? 0 : 1;
            case 528383384:
                return !str.equals("GM.addStyle") ? 0 : 16777216;
            case 537170881:
                return !str.equals("GM_download") ? 0 : 2048;
            case 724773118:
                return !str.equals("GM.openInTab") ? 0 : 268435456;
            case 838415542:
                return !str.equals("GM.info") ? 0 : 524288;
            case 883668071:
                return !str.equals("GM_info") ? 0 : 4096;
            case 1077150452:
                return !str.equals("GM_getValue") ? 0 : 2;
            case 1182553880:
                return !str.equals("GM_removeValueChangeListener") ? 0 : 16384;
            case 1182671139:
                return !str.equals("GM.addElement") ? 0 : 33554432;
            case 1370453352:
                return !str.equals("GM.listValues") ? 0 : 4194304;
            case 1519162893:
                return !str.equals("GM_setClipboard") ? 0 : 1024;
            case 1553044848:
                return !str.equals("GM_registerMenuCommand") ? 0 : 65536;
            case 2106718315:
                return !str.equals("GM_log") ? 0 : 512;
            default:
                return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:163:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:164:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:172:0x0319  */
    /* JADX WARN: Code duplicated, block: B:174:0x0333 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:203:0x0363 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x01a6  */
    /* JADX WARN: Failed to find 'out' block for switch in B:81:0x01a3. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Instruction removed from duplicated block: B:172:0x0319, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [int] */
    /* JADX WARN: Type inference failed for: r5v72 */
    /* JADX WARN: Type inference failed for: r5v73 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    public final j1 c(String str, String str2, String language, String country) {
        String str3;
        String strU0;
        String strA;
        Iterator<String> it;
        String strSubstring;
        String strSubstring2;
        int i10;
        String strB;
        String str4;
        kotlin.jvm.internal.h.f(language, "language");
        kotlin.jvm.internal.h.f(country, "country");
        j1 j1Var = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        j1 j1Var2 = new j1();
        int i11 = 2;
        if (str2 == null || str2.length() == 0) {
            str3 = str2;
            strU0 = null;
            strA = null;
        } else {
            str3 = str2;
            int iY = kotlin.text.z.Y(str3, '/', 0, false, 6, null) + 1;
            if (iY == 0 || iY == str3.length()) {
                strA = null;
            } else {
                String strSubstring3 = str3.substring(iY);
                kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
                strA = a(kotlin.text.x.z(strSubstring3, ".user.js", "", false, 4, null));
            }
            int iT = kotlin.text.z.T(str3, "://", 0, false, 6, null);
            if (iT != -1) {
                String strSubstring4 = str3.substring(iT + 3);
                kotlin.jvm.internal.h.e(strSubstring4, "substring(...)");
                strU0 = kotlin.text.z.u0(strSubstring4, '/', null, 2, null);
            } else {
                strU0 = null;
            }
            j1Var2.s(str3);
        }
        boolean z10 = false;
        Iterator<String> it2 = new Regex("\r\n|[\n\r\u0085\u2028\u2029]").split(str, 0).iterator();
        String str5 = null;
        boolean z11 = false;
        while (it2.hasNext()) {
            String strE = e(it2.next());
            if (z11) {
                if (kotlin.text.x.D(strE, "// ==/UserScript==", z10, i11, j1Var)) {
                    if (strA != null && strU0 != null) {
                        j1Var2.r(strA);
                        if (str5 != null) {
                            strA = str5;
                        }
                        j1Var2.x(strA);
                        j1Var2.y(strU0);
                        return j1Var2;
                    }
                    return j1Var;
                }
                if (kotlin.text.x.D(strE, "//", z10, i11, j1Var)) {
                    ?? Substring = strE.substring(i11);
                    kotlin.jvm.internal.h.e(Substring, "substring(...)");
                    int length = Substring.length();
                    ?? r10 = z10;
                    while (true) {
                        if (r10 >= length) {
                            strSubstring = "";
                        } else if (d(Substring.charAt(r10))) {
                            r10++;
                        } else {
                            strSubstring = Substring.substring(r10);
                            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                        }
                    }
                    if (kotlin.text.z.p0(strSubstring, '@', false, i11, null)) {
                        String strSubstring5 = strSubstring.substring(1);
                        kotlin.jvm.internal.h.e(strSubstring5, "substring(...)");
                        int length2 = strSubstring5.length();
                        int i12 = 0;
                        while (true) {
                            if (i12 < length2) {
                                it = it2;
                                if (f2063a.d(strSubstring5.charAt(i12))) {
                                    strSubstring5 = strSubstring5.substring(0, i12);
                                    kotlin.jvm.internal.h.e(strSubstring5, "substring(...)");
                                } else {
                                    i12++;
                                    it2 = it;
                                }
                            } else {
                                it = it2;
                            }
                        }
                        if (kotlin.jvm.internal.h.a(strSubstring5, "unwrap")) {
                            j1Var2.t(j1Var2.e() | 1);
                        } else if (!kotlin.jvm.internal.h.a(strSubstring5, "noframes")) {
                            String strSubstring6 = strSubstring.substring(strSubstring5.length() + 1);
                            kotlin.jvm.internal.h.e(strSubstring6, "substring(...)");
                            int length3 = strSubstring6.length();
                            int i13 = 0;
                            while (true) {
                                if (i13 >= length3) {
                                    strSubstring2 = "";
                                } else if (d(strSubstring6.charAt(i13))) {
                                    i13++;
                                } else {
                                    strSubstring2 = strSubstring6.substring(i13);
                                    kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
                                }
                            }
                            String strE2 = e(strSubstring2);
                            if (strE2.length() != 0) {
                                switch (strSubstring5.hashCode()) {
                                    case -1321148966:
                                        if (!strSubstring5.equals("exclude")) {
                                            str4 = "name:" + language;
                                            if (kotlin.text.x.D(strSubstring5, str4, false, 2, null) || (str5 != null && strSubstring5.length() != str4.length() && !kotlin.text.x.r(strSubstring5, country, false, 2, null))) {
                                            }
                                            str5 = strE2;
                                            z10 = false;
                                            j1Var = null;
                                            i11 = 2;
                                            it2 = it;
                                        } else if (!j1Var2.d().contains(strE2)) {
                                            j1Var2.d().add(strE2);
                                        }
                                        it2 = it;
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        break;
                                    case -1211149369:
                                        if (strSubstring5.equals("downloadURL")) {
                                            j1Var2.s(strE2);
                                            break;
                                        } else {
                                            str4 = "name:" + language;
                                            if (kotlin.text.x.D(strSubstring5, str4, false, 2, null)) {
                                            }
                                        }
                                        it2 = it;
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        break;
                                    case -919868747:
                                        if (strSubstring5.equals("run-at")) {
                                            switch (strE2) {
                                                case "document-end":
                                                    i10 = 2;
                                                    break;
                                                case "document-start":
                                                    i10 = 1;
                                                    break;
                                                case "context-menu":
                                                    i10 = 8;
                                                    break;
                                                case "document-body":
                                                    i10 = 2;
                                                    break;
                                                default:
                                                    i10 = 4;
                                                    break;
                                            }
                                            j1Var2.z(i10);
                                            break;
                                        } else {
                                            str4 = "name:" + language;
                                            if (kotlin.text.x.D(strSubstring5, str4, false, 2, null)) {
                                            }
                                        }
                                        it2 = it;
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        break;
                                    case -613907680:
                                        if (strSubstring5.equals("supportURL")) {
                                            j1Var2.A(strE2);
                                            break;
                                        } else {
                                            str4 = "name:" + language;
                                            if (kotlin.text.x.D(strSubstring5, str4, false, 2, null)) {
                                            }
                                        }
                                        it2 = it;
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        break;
                                    case -512917486:
                                        if (strSubstring5.equals("exclude-match")) {
                                            if (!j1Var2.c().contains(strE2)) {
                                                j1Var2.c().add(strE2);
                                            }
                                            break;
                                        } else {
                                            str4 = "name:" + language;
                                            if (kotlin.text.x.D(strSubstring5, str4, false, 2, null)) {
                                            }
                                        }
                                        it2 = it;
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        break;
                                    case -341064690:
                                        if (strSubstring5.equals("resource")) {
                                            kotlin.text.i iVarMatchEntire = new Regex("(\\S+)\\s+(.*)").matchEntire(strE2);
                                            if (iVarMatchEntire != null && (strB = y0.b((String) iVarMatchEntire.a().get(2), str3)) != null) {
                                                j1Var2.n().put(iVarMatchEntire.a().get(1), strB);
                                            }
                                        }
                                        str4 = "name:" + language;
                                        if (kotlin.text.x.D(strSubstring5, str4, false, 2, null)) {
                                        }
                                        it2 = it;
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        break;
                                    case 3226745:
                                        if (strSubstring5.equals("icon")) {
                                            j1Var2.w(strE2);
                                        }
                                        str4 = "name:" + language;
                                        if (kotlin.text.x.D(strSubstring5, str4, false, 2, null)) {
                                        }
                                        it2 = it;
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        break;
                                    case 3373707:
                                        if (!strSubstring5.equals("name")) {
                                            str4 = "name:" + language;
                                            if (kotlin.text.x.D(strSubstring5, str4, false, 2, null)) {
                                            }
                                            it2 = it;
                                            z10 = false;
                                            j1Var = null;
                                            i11 = 2;
                                        } else {
                                            strA = strE2;
                                        }
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        it2 = it;
                                        break;
                                    case 98615580:
                                        if (strSubstring5.equals("grant")) {
                                            j1Var2.u(b(strE2) | j1Var2.f());
                                        }
                                        str4 = "name:" + language;
                                        if (kotlin.text.x.D(strSubstring5, str4, false, 2, null)) {
                                        }
                                        it2 = it;
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        break;
                                    case 103668165:
                                        if (strSubstring5.equals("match")) {
                                            if (!j1Var2.j().contains(strE2)) {
                                                j1Var2.j().add(strE2);
                                            }
                                        }
                                        str4 = "name:" + language;
                                        if (kotlin.text.x.D(strSubstring5, str4, false, 2, null)) {
                                        }
                                        it2 = it;
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        break;
                                    case 351608024:
                                        if (strSubstring5.equals("version")) {
                                            j1Var2.B(strE2);
                                        }
                                        str4 = "name:" + language;
                                        if (kotlin.text.x.D(strSubstring5, str4, false, 2, null)) {
                                        }
                                        it2 = it;
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        break;
                                    case 1095696741:
                                        if (strSubstring5.equals("require")) {
                                            String strB2 = y0.b(strE2, str3);
                                            if (strB2 != null) {
                                                j1Var2.m().add(strB2);
                                            }
                                        }
                                        str4 = "name:" + language;
                                        if (kotlin.text.x.D(strSubstring5, str4, false, 2, null)) {
                                        }
                                        it2 = it;
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        break;
                                    case 1252218203:
                                        if (!strSubstring5.equals("namespace")) {
                                            str4 = "name:" + language;
                                            if (kotlin.text.x.D(strSubstring5, str4, false, 2, null)) {
                                            }
                                            it2 = it;
                                            z10 = false;
                                            j1Var = null;
                                            i11 = 2;
                                        } else {
                                            strU0 = strE2;
                                        }
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        it2 = it;
                                        break;
                                    case 1440041633:
                                        if (strSubstring5.equals("homepageURL")) {
                                            j1Var2.v(strE2);
                                        }
                                        str4 = "name:" + language;
                                        if (kotlin.text.x.D(strSubstring5, str4, false, 2, null)) {
                                        }
                                        it2 = it;
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        break;
                                    case 1942574248:
                                        if (strSubstring5.equals("include")) {
                                            if (!j1Var2.i().contains(strE2)) {
                                                j1Var2.i().add(strE2);
                                            }
                                        }
                                        str4 = "name:" + language;
                                        if (kotlin.text.x.D(strSubstring5, str4, false, 2, null)) {
                                        }
                                        it2 = it;
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        break;
                                    default:
                                        str4 = "name:" + language;
                                        if (kotlin.text.x.D(strSubstring5, str4, false, 2, null)) {
                                        }
                                        it2 = it;
                                        z10 = false;
                                        j1Var = null;
                                        i11 = 2;
                                        break;
                                }
                            }
                        } else {
                            j1Var2.t(j1Var2.e() | 2);
                        }
                        it2 = it;
                        z10 = false;
                        j1Var = null;
                        i11 = 2;
                    }
                }
                it = it2;
                it2 = it;
                z10 = false;
                j1Var = null;
                i11 = 2;
            } else if (kotlin.text.x.D(strE, "// ==UserScript==", z10, i11, j1Var)) {
                z11 = true;
            }
        }
        return j1Var;
    }

    public final boolean d(char c10) {
        return kotlin.text.z.H(" \t\n\u000b\f\r\u200b", c10, false, 2, null) || kotlin.text.a.c(c10) == CharCategory.SPACE_SEPARATOR;
    }

    public final String e(String str) {
        int length = str.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean z11 = kotlin.jvm.internal.h.h(str.charAt(!z10 ? i10 : length), 32) <= 0;
            if (z10) {
                if (!z11) {
                    break;
                }
                length--;
            } else if (z11) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return str.subSequence(i10, length + 1).toString();
    }
}
