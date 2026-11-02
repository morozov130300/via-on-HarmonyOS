package s5;

import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f11851a = "a";

    public static String a(String str) {
        if (str == null || str.length() < 2) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        if (str.charAt(1) != '^') {
            sb2.append(".*");
        }
        sb2.append(str.substring(1, str.length() - 1));
        if (str.charAt(str.length() - 2) != '$') {
            sb2.append(".*");
        }
        return sb2.toString();
    }

    public static boolean b(String str) {
        return str.length() >= 2 && str.charAt(0) == '/' && str.charAt(str.length() - 1) == '/';
    }

    public static boolean c(String str, String str2) {
        if (str.length() == 0) {
            return true;
        }
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        String lowerCase2 = str2.toLowerCase(locale);
        if (!b(lowerCase)) {
            return d(lowerCase, lowerCase2) || d(e(lowerCase), lowerCase2);
        }
        try {
            String strA = a(lowerCase);
            if (strA != null) {
                if (lowerCase2.matches(strA)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            d.f(f11851a, e10.getMessage());
            return false;
        }
    }

    public static boolean d(String str, String str2) {
        if (str == null) {
            return false;
        }
        int i10 = 0;
        int i11 = 0;
        int i12 = -1;
        int i13 = -1;
        while (i10 < str2.length()) {
            if (i11 < str.length() && str.charAt(i11) == str2.charAt(i10)) {
                i10++;
                i11++;
            } else if (i11 < str.length() && str.charAt(i11) == '*') {
                i12 = i11;
                i11++;
                i13 = i10;
            } else {
                if (i12 == -1) {
                    return false;
                }
                i11 = i12 + 1;
                i13++;
                i10 = i13;
            }
        }
        while (i11 < str.length() && str.charAt(i11) == '*') {
            i11++;
        }
        return i11 == str.length();
    }

    public static String e(String str) {
        int iIndexOf = str.indexOf("://*.");
        if (iIndexOf <= 0 || iIndexOf > 9) {
            return null;
        }
        return str.substring(0, iIndexOf) + "://" + str.substring(iIndexOf + 5);
    }
}
