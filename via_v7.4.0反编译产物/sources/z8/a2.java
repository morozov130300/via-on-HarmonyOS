package z8;

import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a2 {
    public static int a(String str, String str2) {
        int i10 = 0;
        if (str == null && str2 == null) {
            return 0;
        }
        if (str == null) {
            return 1;
        }
        if (str2 == null) {
            return -1;
        }
        int length = str.length();
        int length2 = str2.length();
        if (length == 0 || length2 == 0) {
            return length - length2;
        }
        for (int i11 = 0; i10 < length && i11 < length2; i11++) {
            String strD = z0.a.d(str.charAt(i10));
            Locale locale = Locale.ROOT;
            int iCompareTo = strD.toUpperCase(locale).compareTo(z0.a.d(str2.charAt(i11)).toUpperCase(locale));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            i10++;
        }
        return length - length2;
    }
}
