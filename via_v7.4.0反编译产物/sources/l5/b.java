package l5;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URLDecoder;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f8399a = "b";

    public static String a(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public static String b(String str, String str2, String str3) {
        String strSubstring;
        char c10;
        String strB;
        int iLastIndexOf;
        d5.a.a("DownloadUtils", "guess file name: " + str + ", content disposition: " + str2 + ", mime type: " + str3);
        String strSubstring2 = null;
        if (str2 != null) {
            strSubstring = e(str2);
            c10 = 1;
        } else {
            strSubstring = null;
            c10 = 0;
        }
        if (strSubstring == null) {
            c10 = 2;
            if (str != null) {
                int iIndexOf = str.indexOf(63);
                if (iIndexOf > 0) {
                    str = str.substring(0, iIndexOf);
                }
                if (!str.endsWith("/") && (iLastIndexOf = str.lastIndexOf(47) + 1) > 0) {
                    strSubstring = str.substring(iLastIndexOf);
                }
            }
        }
        if (strSubstring != null) {
            if (strSubstring.contains("%")) {
                strSubstring = a(strSubstring);
            }
            strSubstring = strSubstring.replace(File.separatorChar, '_');
        }
        if (strSubstring == null) {
            c10 = 3;
            strSubstring = "downloadfile";
        }
        int iLastIndexOf2 = strSubstring.lastIndexOf(46);
        if (iLastIndexOf2 < 0) {
            if (str3 != null) {
                strSubstring2 = c.b(str3);
                if (strSubstring2 != null) {
                    strSubstring2 = "." + strSubstring2;
                } else if (str3.startsWith("image/")) {
                    strSubstring2 = ".png";
                }
            }
            if (strSubstring2 == null || ".bin".equalsIgnoreCase(strSubstring2)) {
                strSubstring2 = "";
            }
        } else {
            strSubstring2 = strSubstring.substring(iLastIndexOf2);
            strSubstring = strSubstring.substring(0, iLastIndexOf2);
            if (c10 != 1 && !c.g(strSubstring2.substring(1)) && str3 != null && (strB = c.b(str3)) != null && !"bin".equalsIgnoreCase(strB) && !strB.equalsIgnoreCase(strSubstring2.substring(1))) {
                strSubstring2 = "." + strB;
            }
        }
        return strSubstring + strSubstring2;
    }

    public static void c(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            try {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(i5.c.a());
            } catch (Exception e10) {
                d5.a.c(f8399a, e10.getMessage(), e10);
            }
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new i5.a());
        }
    }

    public static boolean d(String str, String str2) {
        return "text/html".equals(str) || "html".equals(str2) || "htm".equals(str2);
    }

    public static String e(String str) {
        int iIndexOf;
        if (str == null || str.isEmpty() || ((iIndexOf = str.indexOf("filename*=")) < 0 && (iIndexOf = str.indexOf("filename")) < 0)) {
            return null;
        }
        String strSubstring = str.substring(iIndexOf);
        while (true) {
            int iLastIndexOf = strSubstring.lastIndexOf(59);
            if (iLastIndexOf <= 0) {
                break;
            }
            strSubstring = strSubstring.substring(0, iLastIndexOf).trim();
        }
        int iIndexOf2 = strSubstring.indexOf(61);
        if (iIndexOf2 > 0) {
            strSubstring = strSubstring.substring(iIndexOf2 + 1).trim();
            int iIndexOf3 = strSubstring.indexOf("''");
            if (iIndexOf3 > 0) {
                strSubstring = strSubstring.substring(iIndexOf3 + 2).trim();
            }
            int iIndexOf4 = strSubstring.indexOf("' '");
            if (iIndexOf4 > 0) {
                strSubstring = strSubstring.substring(iIndexOf4 + 3).trim();
            }
        }
        if (strSubstring.isEmpty()) {
            return null;
        }
        if (strSubstring.charAt(0) == '\"' || strSubstring.charAt(0) == '\'') {
            strSubstring = strSubstring.substring(1);
        }
        int length = strSubstring.length() - 1;
        while (length >= 0 && (strSubstring.charAt(length) == '\"' || strSubstring.charAt(length) == '\'')) {
            length--;
        }
        String strSubstring2 = strSubstring.substring(0, length + 1);
        if (strSubstring2.isEmpty()) {
            return null;
        }
        return strSubstring2.indexOf(37) > 0 ? a(strSubstring2) : strSubstring2;
    }

    public static long f(String str) {
        if (str != null && !str.isEmpty()) {
            String strSubstring = str.substring(6);
            int iIndexOf = strSubstring.indexOf(47);
            int iIndexOf2 = strSubstring.indexOf(45);
            if (iIndexOf > 0) {
                String strSubstring2 = strSubstring.substring(iIndexOf + 1);
                if (!"*".equals(strSubstring2)) {
                    return g(strSubstring2);
                }
            }
            if (!"*".startsWith(strSubstring) && iIndexOf2 > 0) {
                String strSubstring3 = strSubstring.substring(0, iIndexOf2);
                long jG = (g(iIndexOf > 0 ? strSubstring.substring(iIndexOf2 + 1, iIndexOf) : strSubstring.substring(iIndexOf2 + 1)) - g(strSubstring3)) + 1;
                if (jG < 0) {
                    return -1L;
                }
                return jG;
            }
        }
        return -1L;
    }

    public static long g(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }
}
