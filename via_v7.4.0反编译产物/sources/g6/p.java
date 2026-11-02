package g6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class p {
    public static String a(String str) {
        return (str == null || str.isEmpty()) ? "" : new String(Character.toChars(str.codePointAt(0)));
    }

    public static String b(int i10) {
        if (i10 <= 0) {
            return "";
        }
        Random random = new Random();
        StringBuilder sb2 = new StringBuilder(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(36)));
        }
        return sb2.toString();
    }

    public static CharSequence c(List list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            w.d dVar = (w.d) list.get(i10);
            if (i10 > 0) {
                sb2.append("<br />");
            }
            if (!f((String) dVar.f13207a)) {
                sb2.append("<b>");
                sb2.append((String) dVar.f13207a);
                sb2.append("</b><br />");
            }
            if (!f((String) dVar.f13208b)) {
                sb2.append((String) dVar.f13208b);
            }
        }
        return v.a.a(sb2.toString(), 0);
    }

    public static int d(String str, String str2) {
        if (str2.isEmpty() || str.isEmpty()) {
            return str.indexOf(str2);
        }
        for (int i10 = 0; i10 < str.length() && str2.length() + i10 <= str.length(); i10++) {
            int i11 = 0;
            for (int i12 = i10; i12 < str.length() && i11 < str2.length() && Character.toLowerCase(str.charAt(i12)) == Character.toLowerCase(str2.charAt(i11)); i12++) {
                i11++;
            }
            if (i11 == str2.length()) {
                return i10;
            }
        }
        return -1;
    }

    public static int e(String str) {
        if (str == null) {
            return -1;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (Character.isWhitespace(str.charAt(i10))) {
                return i10;
            }
        }
        return -1;
    }

    public static boolean f(String str) {
        return str == null || str.length() == 0;
    }

    public static String g(char c10, Iterable iterable) {
        if (iterable == null) {
            return null;
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(it.next());
        while (it.hasNext()) {
            sb2.append(c10);
            sb2.append(it.next());
        }
        return sb2.toString();
    }

    public static String h(char c10, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < iArr.length - 1; i10++) {
            sb2.append(iArr[i10]);
            sb2.append(c10);
        }
        sb2.append(iArr[iArr.length - 1]);
        return sb2.toString();
    }

    public static CharSequence i(CharSequence charSequence, int i10) {
        if (charSequence == null || charSequence.length() <= i10) {
            return charSequence;
        }
        return ((Object) charSequence.subSequence(0, i10)) + "...";
    }

    public static String j(String str, int i10) {
        if (str == null || str.length() <= i10) {
            return str;
        }
        return str.substring(0, i10) + "...";
    }

    public static String k(String str) {
        return str == null ? "" : str;
    }

    public static String l(String str) {
        if (f(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            if (!Character.isWhitespace(cCharAt)) {
                int i12 = i10 + 1;
                if (cCharAt == '\u00a0') {
                    cCharAt = ' ';
                }
                cArr[i10] = cCharAt;
                i10 = i12;
            } else if (cCharAt != '\r') {
                cArr[i10] = " ".charAt(0);
                i10++;
            }
        }
        return new String(cArr, 0, i10);
    }

    public static String m(String str) {
        return n(str, "");
    }

    public static String n(String str, String str2) {
        return (str == null || str.isEmpty()) ? str2 : str;
    }

    public static List o(String str, char c10) {
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            int length = str.length();
            int i10 = 0;
            while (i10 < length) {
                int iIndexOf = str.indexOf(c10, i10);
                if (iIndexOf < 0) {
                    iIndexOf = length;
                }
                arrayList.add(str.substring(i10, iIndexOf).trim());
                i10 = iIndexOf + 1;
            }
        }
        return arrayList;
    }

    public static int[] p(String str, char c10) {
        if (str == null || str.length() == 0) {
            return new int[0];
        }
        String[] strArrSplit = str.split(String.valueOf(c10));
        int[] iArr = new int[strArrSplit.length];
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            try {
                iArr[i10] = Integer.parseInt(strArrSplit[i10]);
            } catch (Exception unused) {
            }
        }
        return iArr;
    }

    public static String q(String str, int i10) {
        if (str == null || i10 < 5 || str.length() <= i10) {
            return str;
        }
        int length = str.length();
        int i11 = (i10 / 2) - 1;
        int i12 = (i10 - i11) - 3;
        return str.substring(0, i11) + "..." + str.substring(length - i12);
    }
}
