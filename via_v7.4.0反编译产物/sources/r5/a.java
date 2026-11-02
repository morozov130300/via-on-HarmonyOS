package r5;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final String f11541c = "a";

    /* renamed from: a, reason: collision with root package name */
    public final c f11542a;

    /* renamed from: b, reason: collision with root package name */
    public final b f11543b;

    public a(c cVar, b bVar) {
        if (cVar == null) {
            throw new NullPointerException("Script meta can not be null");
        }
        if (bVar == null) {
            throw new NullPointerException("Script content can not be null");
        }
        this.f11542a = cVar;
        this.f11543b = bVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int b(String str) {
        if (str != null && !str.isEmpty()) {
            switch (str.hashCode()) {
                case -2139978370:
                    if (str.equals("GM.deleteValue")) {
                        return 1048576;
                    }
                    break;
                case -2137539383:
                    if (str.equals("GM_addStyle")) {
                        return 64;
                    }
                    break;
                case -2133519533:
                    if (str.equals("GM.getResourceUrl")) {
                        return 67108864;
                    }
                    break;
                case -2119561308:
                    if (str.equals("GM_notification")) {
                        return 262144;
                    }
                    break;
                case -2033228435:
                    if (str.equals("GM_addValueChangeListener")) {
                        return 8192;
                    }
                    break;
                case -1319624471:
                    if (str.equals("GM_xmlhttpRequest")) {
                        return 256;
                    }
                    break;
                case -1283958948:
                    if (str.equals("GM.setClipboard")) {
                        return 1073741824;
                    }
                    break;
                case -1277925948:
                    if (str.equals("GM_getResourceURL")) {
                        return 16;
                    }
                    break;
                case -1193887625:
                    if (str.equals("GM_unregisterMenuCommand")) {
                        return 131072;
                    }
                    break;
                case -1113006537:
                    if (str.equals("GM.setValue")) {
                        return 8388608;
                    }
                    break;
                case -968599532:
                    if (str.equals("GM_addElement")) {
                        return 128;
                    }
                    break;
                case -961008776:
                    if (str.equals("GM_getResourceText")) {
                        return 32;
                    }
                    break;
                case -780817319:
                    if (str.equals("GM_listValues")) {
                        return 4;
                    }
                    break;
                case -627715853:
                    if (str.equals("GM.notification")) {
                        return 134217728;
                    }
                    break;
                case -551894077:
                    if (str.equals("GM.getValue")) {
                        return 2097152;
                    }
                    break;
                case -507350440:
                    if (str.equals("GM.xmlHttpRequest")) {
                        return Integer.MIN_VALUE;
                    }
                    break;
                case -314454035:
                    if (str.equals("GM_openInTab")) {
                        return 32768;
                    }
                    break;
                case -109892435:
                    if (str.equals("GM_deleteValue")) {
                        return 8;
                    }
                    break;
                case 3387192:
                    str.equals("none");
                    break;
                case 110595393:
                    if (str.equals("GM.registerMenuCommand")) {
                        return 536870912;
                    }
                    break;
                case 516037992:
                    if (str.equals("GM_setValue")) {
                        return 1;
                    }
                    break;
                case 528383384:
                    if (str.equals("GM.addStyle")) {
                        return 16777216;
                    }
                    break;
                case 537170881:
                    if (str.equals("GM_download")) {
                        return 2048;
                    }
                    break;
                case 724773118:
                    if (str.equals("GM.openInTab")) {
                        return 268435456;
                    }
                    break;
                case 838415542:
                    if (str.equals("GM.info")) {
                        return 524288;
                    }
                    break;
                case 883668071:
                    if (str.equals("GM_info")) {
                        return 4096;
                    }
                    break;
                case 1077150452:
                    if (str.equals("GM_getValue")) {
                        return 2;
                    }
                    break;
                case 1180650806:
                    str.equals("unsafeWindow");
                    return 0;
                case 1182553880:
                    if (str.equals("GM_removeValueChangeListener")) {
                        return 16384;
                    }
                    break;
                case 1182671139:
                    if (str.equals("GM.addElement")) {
                        return 33554432;
                    }
                    break;
                case 1370453352:
                    if (str.equals("GM.listValues")) {
                        return 4194304;
                    }
                    break;
                case 1519162893:
                    if (str.equals("GM_setClipboard")) {
                        return 1024;
                    }
                    break;
                case 1553044848:
                    if (str.equals("GM_registerMenuCommand")) {
                        return 65536;
                    }
                    break;
                case 2106718315:
                    if (str.equals("GM_log")) {
                        return 512;
                    }
                    break;
            }
        }
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a f(String str, String str2) {
        String strSubstring;
        String strReplace;
        HashSet hashSet;
        String str3;
        Pattern pattern;
        HashSet hashSet2;
        Pattern pattern2;
        HashSet hashSet3;
        if (str == null || str.isEmpty()) {
            return null;
        }
        c cVar = new c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        cVar.s(jCurrentTimeMillis);
        cVar.l(jCurrentTimeMillis);
        cVar.n(true);
        b bVar = new b();
        bVar.q(cVar.j());
        bVar.p(str);
        if (str2 == null || str2.isEmpty()) {
            strSubstring = null;
            strReplace = null;
        } else {
            int iLastIndexOf = str2.lastIndexOf("/") + 1;
            if (iLastIndexOf == 0 || iLastIndexOf == str2.length()) {
                strReplace = null;
            } else {
                strReplace = str2.substring(iLastIndexOf).replace(".user.js", "");
                try {
                    strReplace = URLDecoder.decode(strReplace, "UTF-8");
                } catch (Exception e10) {
                    s5.d.h(f11541c, e10);
                }
            }
            int iIndexOf = str2.indexOf("://");
            if (iIndexOf != -1) {
                int i10 = iIndexOf + 3;
                int iIndexOf2 = str2.indexOf("/", i10);
                if (iIndexOf2 == -1) {
                    iIndexOf2 = str2.length();
                }
                strSubstring = str2.substring(i10, iIndexOf2);
            } else {
                strSubstring = null;
            }
            cVar.m(str2);
        }
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        HashSet hashSet6 = new HashSet();
        HashSet hashSet7 = new HashSet();
        Scanner scanner = new Scanner(str);
        Pattern patternCompile = Pattern.compile("//[\\s\\p{Zs}\\u200B]*@([^\\s\\p{Zs}\\u200B]+)(?:[\\s\\p{Zs}\\u200B]+(.*))?");
        Pattern patternCompile2 = Pattern.compile("(\\S+)\\s+(.*)");
        String str4 = "name:" + Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        boolean z10 = false;
        while (scanner.hasNextLine()) {
            Scanner scanner2 = scanner;
            String strTrim = scanner.nextLine().trim();
            if (z10) {
                hashSet = hashSet4;
                if (strTrim.startsWith("// ==/UserScript==")) {
                    if (strReplace == null || strSubstring == null) {
                        return null;
                    }
                    if (cVar.g() == null) {
                        cVar.t(strReplace);
                    }
                    bVar.B(s5.c.a(strSubstring + strReplace));
                    bVar.x(s5.e.f(hashSet6));
                    bVar.r(s5.e.f(hashSet7));
                    bVar.w(s5.e.f(hashSet5));
                    bVar.s(s5.e.f(hashSet));
                    bVar.y(s5.e.d(arrayList));
                    bVar.z(s5.e.e(map));
                    return new a(cVar, bVar);
                }
                Matcher matcher = patternCompile.matcher(strTrim);
                if (matcher.matches()) {
                    str3 = strSubstring;
                    String strGroup = matcher.group(1);
                    if (strGroup == null || strGroup.isEmpty()) {
                        pattern = patternCompile;
                        hashSet2 = hashSet;
                        hashSet4 = hashSet2;
                        scanner = scanner2;
                        patternCompile = pattern;
                        strSubstring = str3;
                    } else if ("unwrap".equals(strGroup)) {
                        bVar.t(bVar.e() | 1);
                    } else {
                        String strGroup2 = matcher.group(2);
                        if (strGroup2 != null) {
                            String strTrim2 = strGroup2.trim();
                            if (!strTrim2.isEmpty()) {
                                switch (strGroup) {
                                    case "exclude":
                                        pattern2 = patternCompile;
                                        hashSet3 = hashSet;
                                        hashSet3.add(strTrim2);
                                        strTrim2 = str3;
                                        break;
                                    case "downloadURL":
                                        pattern2 = patternCompile;
                                        cVar.m(strTrim2);
                                        hashSet3 = hashSet;
                                        strTrim2 = str3;
                                        break;
                                    case "run-at":
                                        pattern2 = patternCompile;
                                        if ("document-start".equals(strTrim2)) {
                                            bVar.A(1);
                                        } else if ("document-end".equals(strTrim2) || "document-body".equals(strTrim2)) {
                                            bVar.A(2);
                                        } else if ("context-menu".equals(strTrim2)) {
                                            bVar.A(8);
                                        } else {
                                            bVar.A(4);
                                        }
                                        hashSet3 = hashSet;
                                        strTrim2 = str3;
                                        break;
                                    case "supportURL":
                                        pattern2 = patternCompile;
                                        cVar.u(strTrim2);
                                        hashSet3 = hashSet;
                                        strTrim2 = str3;
                                        break;
                                    case "exclude-match":
                                        pattern2 = patternCompile;
                                        hashSet7.add(strTrim2);
                                        hashSet3 = hashSet;
                                        strTrim2 = str3;
                                        break;
                                    case "resource":
                                        pattern2 = patternCompile;
                                        Matcher matcher2 = patternCompile2.matcher(strTrim2);
                                        if (matcher2.matches()) {
                                            map.put(matcher2.group(1), s5.b.k(matcher2.group(2), str2));
                                        }
                                        hashSet3 = hashSet;
                                        strTrim2 = str3;
                                        break;
                                    case "icon":
                                        pattern2 = patternCompile;
                                        cVar.p(strTrim2);
                                        hashSet3 = hashSet;
                                        strTrim2 = str3;
                                        break;
                                    case "name":
                                        pattern2 = patternCompile;
                                        strReplace = strTrim2;
                                        hashSet3 = hashSet;
                                        strTrim2 = str3;
                                        break;
                                    case "grant":
                                        pattern2 = patternCompile;
                                        bVar.a(b(strTrim2));
                                        hashSet3 = hashSet;
                                        strTrim2 = str3;
                                        break;
                                    case "match":
                                        pattern2 = patternCompile;
                                        hashSet6.add(strTrim2);
                                        hashSet3 = hashSet;
                                        strTrim2 = str3;
                                        break;
                                    case "version":
                                        pattern2 = patternCompile;
                                        cVar.v(strTrim2);
                                        hashSet3 = hashSet;
                                        strTrim2 = str3;
                                        break;
                                    case "require":
                                        pattern2 = patternCompile;
                                        String strK = s5.b.k(strTrim2, str2);
                                        if (strK != null) {
                                            arrayList.add(strK);
                                        }
                                        hashSet3 = hashSet;
                                        strTrim2 = str3;
                                        break;
                                    case "namespace":
                                        pattern2 = patternCompile;
                                        hashSet3 = hashSet;
                                        break;
                                    case "homepageURL":
                                        pattern2 = patternCompile;
                                        cVar.o(strTrim2);
                                        hashSet3 = hashSet;
                                        strTrim2 = str3;
                                        break;
                                    case "include":
                                        pattern2 = patternCompile;
                                        hashSet5.add(strTrim2);
                                        hashSet3 = hashSet;
                                        strTrim2 = str3;
                                        break;
                                    default:
                                        if (strGroup.startsWith(str4)) {
                                            if (cVar.g() != null) {
                                                pattern2 = patternCompile;
                                                if (strGroup.length() == str4.length() || strGroup.endsWith(country)) {
                                                    cVar.t(strTrim2);
                                                }
                                            } else {
                                                pattern2 = patternCompile;
                                            }
                                            cVar.t(strTrim2);
                                        } else {
                                            pattern2 = patternCompile;
                                        }
                                        hashSet3 = hashSet;
                                        strTrim2 = str3;
                                        break;
                                }
                                hashSet4 = hashSet3;
                                strSubstring = strTrim2;
                                scanner = scanner2;
                                patternCompile = pattern2;
                            }
                        }
                    }
                } else {
                    str3 = strSubstring;
                }
            } else {
                hashSet = hashSet4;
                if (strTrim.startsWith("// ==UserScript==")) {
                    hashSet4 = hashSet;
                    scanner = scanner2;
                    z10 = true;
                } else {
                    str3 = strSubstring;
                }
            }
            pattern = patternCompile;
            hashSet2 = hashSet;
            hashSet4 = hashSet2;
            scanner = scanner2;
            patternCompile = pattern;
            strSubstring = str3;
        }
        return null;
    }

    public b a() {
        return this.f11543b;
    }

    public int c() {
        return this.f11543b.g();
    }

    public c d() {
        return this.f11542a;
    }

    public String e() {
        return this.f11543b.m();
    }

    public void g(boolean z10) {
        this.f11542a.n(z10);
        this.f11543b.q(z10);
    }

    public void h(int i10) {
        this.f11542a.q(i10);
        this.f11543b.v(i10);
    }

    public String toString() {
        return "Script{meta=" + this.f11542a + ", content=" + this.f11543b + '}';
    }
}
