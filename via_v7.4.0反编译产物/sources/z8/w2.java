package z8;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class w2 {
    public static boolean A(String str) {
        return C(str, "v://tabs");
    }

    public static boolean B(String str) {
        return C(str, "v://translator/translate?text=");
    }

    public static boolean C(String str, String str2) {
        return str != null && str.length() >= str2.length() && str2.equalsIgnoreCase(str.substring(0, str2.length()));
    }

    public static boolean a(String str, String str2) {
        if (C(str, str2)) {
            return str.length() <= str2.length() || str.charAt(str2.length()) == '?' || str.charAt(str2.length()) == '/';
        }
        return false;
    }

    public static String b(String str) {
        return !o(str) ? str : v0.i(str.substring(21));
    }

    public static String c(String str) {
        return "v://blocker/jump?url=" + v0.j(str);
    }

    public static String d(String str) {
        if (str == null || str.isEmpty()) {
            return "v://bookmarks";
        }
        return "v://bookmarks/?folder=" + str;
    }

    public static String e(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return "v://bookmarks";
        }
        if (str2 == null || str2.isEmpty()) {
            return d(str);
        }
        return "v://bookmarks/?folder=" + str + "&folderName=" + v0.j(str2);
    }

    public static String f(String str) {
        if (!r(str)) {
            return str;
        }
        int iIndexOf = str.indexOf(38, 19);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
        }
        return v0.i(str.substring(19, iIndexOf));
    }

    public static String g(String str) {
        i6.i0 i0Var = i6.i0.f7006a;
        if (!i0Var.s(str) && !i0Var.l(str) && !i0Var.k(str)) {
            return str;
        }
        return "v://error/jump?url=" + v0.j(str);
    }

    public static w.d h(String str) {
        String strI = i(str);
        if (strI == null || strI.isEmpty()) {
            return w.d.a(null, null);
        }
        int iIndexOf = str.indexOf("&folderName=");
        if (iIndexOf < 0) {
            return w.d.a(strI, null);
        }
        int i10 = iIndexOf + 12;
        int iIndexOf2 = str.indexOf(38, i10);
        if (iIndexOf2 < 0) {
            iIndexOf2 = str.length();
        }
        return w.d.a(strI, v0.i(str.substring(i10, iIndexOf2)));
    }

    public static String i(String str) {
        int iIndexOf;
        if (!p(str) || (iIndexOf = str.indexOf("?folder=")) < 0) {
            return null;
        }
        int i10 = iIndexOf + 8;
        int iIndexOf2 = str.indexOf(38, i10);
        if (iIndexOf2 < 0) {
            iIndexOf2 = str.length();
        }
        return str.substring(i10, iIndexOf2);
    }

    public static w.d j(String str) {
        int iIndexOf;
        if (!A(str) || (iIndexOf = str.indexOf("/restore?ids=")) < 0) {
            return null;
        }
        int iIndexOf2 = str.indexOf("&selected=");
        return iIndexOf2 < 0 ? w.d.a(str.substring(iIndexOf + 13).split(","), null) : w.d.a(str.substring(iIndexOf + 13, iIndexOf2).split(","), str.substring(iIndexOf2 + 10));
    }

    public static String k(String str) {
        if (x(str)) {
            return i6.i0.f7006a.g(str, "q=", true);
        }
        return null;
    }

    public static String l(String[] strArr, String str) {
        if (strArr == null || strArr.length == 0) {
            return "v://tabs";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("v://tabs");
        sb2.append("/restore?ids=");
        boolean z10 = false;
        for (String str2 : strArr) {
            if (str2 != null && !str2.isEmpty()) {
                if (z10) {
                    sb2.append(',');
                }
                sb2.append(str2);
                z10 = true;
            }
        }
        if (!z10) {
            return "v://tabs";
        }
        if (str != null && !str.isEmpty()) {
            sb2.append("&selected=");
            sb2.append(str);
        }
        return sb2.toString();
    }

    public static String m(String str) {
        if (!B(str)) {
            return str;
        }
        int iIndexOf = str.indexOf(38, 30);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
        }
        return v0.i(str.substring(30, iIndexOf));
    }

    public static String n(String str) {
        return "v://translator/translate?text=" + v0.j(str);
    }

    public static boolean o(String str) {
        return C(str, "v://blocker/jump?url=");
    }

    public static boolean p(String str) {
        return a(str, "v://bookmarks");
    }

    public static boolean q(String str) {
        return a(str, "v://downloader");
    }

    public static boolean r(String str) {
        return C(str, "v://error/jump?url=");
    }

    public static boolean s(String str) {
        return a(str, "v://history");
    }

    public static boolean t(String str) {
        return C(str, "folder://");
    }

    public static boolean u(String str) {
        return C(str, "history://");
    }

    public static boolean v(String str) {
        return a(str, "v://readaloud");
    }

    public static boolean w(String str) {
        return a(str, "v://scanner");
    }

    public static boolean x(String str) {
        return a(str, "v://search");
    }

    public static boolean y(String str) {
        return a(str, "v://skins");
    }

    public static boolean z(String str) {
        return C(str, "v://");
    }
}
