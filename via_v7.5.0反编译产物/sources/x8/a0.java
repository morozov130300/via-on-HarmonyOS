package x8;

import android.content.Context;
import java.util.Locale;
import mark.via.BrowserApp;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a0 {
    public static String a() {
        return BrowserApp.f();
    }

    public static String b() {
        return c(a());
    }

    public static String c(String str) {
        int i10 = 0;
        if (str != null) {
            int i11 = 0;
            while (i10 < str.length()) {
                char cCharAt = str.charAt(i10);
                i10++;
                i11 += cCharAt * i10;
            }
            i10 = i11;
        }
        return Integer.toHexString(i10 % 256).toUpperCase(Locale.ROOT);
    }

    public static String d(Context context) {
        String strB = i4.a.b(context.getApplicationContext());
        return strB == null ? "unknown" : strB;
    }

    public static boolean e() {
        return false;
    }

    public static boolean f() {
        return true;
    }

    public static boolean g() {
        return "coolapk".equals(a());
    }

    public static boolean h() {
        return false;
    }

    public static boolean i() {
        return "huawei".equals(a());
    }
}
