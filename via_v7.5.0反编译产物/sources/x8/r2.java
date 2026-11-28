package x8;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class r2 {
    public static boolean a(String str, String str2) {
        if (z(str, str2)) {
            return str.length() <= str2.length() || str.charAt(str2.length()) == '?' || str.charAt(str2.length()) == '/';
        }
        return false;
    }

    public static String b(String str) {
        return !m(str) ? str : v0.i(str.substring(21));
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
        if (!p(str)) {
            return str;
        }
        int iIndexOf = str.indexOf(38, 19);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
        }
        return v0.i(str.substring(19, iIndexOf));
    }

    public static String g(String str) {
        c6.a2 a2Var = c6.a2.f1958a;
        if (!a2Var.t(str) && !a2Var.m(str) && !a2Var.l(str)) {
            return str;
        }
        return "v://error/jump?url=" + v0.j(str);
    }

    public static x.d h(String str) {
        String strI = i(str);
        return x.d.a(strI, (strI == null || strI.isEmpty()) ? null : c6.a2.f1958a.h(str, "folderName=", true));
    }

    public static String i(String str) {
        if (n(str)) {
            return c6.a2.f1958a.h(str, "folder=", true);
        }
        return null;
    }

    public static x.d j(String str) {
        int iIndexOf;
        if (!y(str) || (iIndexOf = str.indexOf("/restore?ids=")) < 0) {
            return null;
        }
        int iIndexOf2 = str.indexOf("&selected=");
        return iIndexOf2 < 0 ? x.d.a(str.substring(iIndexOf + 13).split(","), null) : x.d.a(str.substring(iIndexOf + 13, iIndexOf2).split(","), str.substring(iIndexOf2 + 10));
    }

    public static String k(String str) {
        if (v(str)) {
            return c6.a2.f1958a.h(str, "q=", true);
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

    public static boolean m(String str) {
        return z(str, "v://blocker/jump?url=");
    }

    public static boolean n(String str) {
        return a(str, "v://bookmarks");
    }

    public static boolean o(String str) {
        return a(str, "v://downloader");
    }

    public static boolean p(String str) {
        return z(str, "v://error/jump?url=");
    }

    public static boolean q(String str) {
        return a(str, "v://history");
    }

    public static boolean r(String str) {
        return z(str, "folder://");
    }

    public static boolean s(String str) {
        return z(str, "history://");
    }

    public static boolean t(String str) {
        return a(str, "v://readaloud");
    }

    public static boolean u(String str) {
        return a(str, "v://scanner");
    }

    public static boolean v(String str) {
        return a(str, "v://search");
    }

    public static boolean w(String str) {
        return a(str, "v://skins");
    }

    public static boolean x(String str) {
        return z(str, "v://");
    }

    public static boolean y(String str) {
        return z(str, "v://tabs");
    }

    public static boolean z(String str, String str2) {
        return str != null && str.length() >= str2.length() && str2.equalsIgnoreCase(str.substring(0, str2.length()));
    }
}
