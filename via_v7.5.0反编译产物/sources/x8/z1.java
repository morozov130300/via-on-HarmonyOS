package x8;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class z1 {
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
            String strF = a1.c.f(str.charAt(i10));
            Locale locale = Locale.ROOT;
            int iCompareTo = strF.toUpperCase(locale).compareTo(a1.c.f(str2.charAt(i11)).toUpperCase(locale));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            i10++;
        }
        return length - length2;
    }
}
