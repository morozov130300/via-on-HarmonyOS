package xb;

import java.util.List;
import okhttp3.q;
import okhttp3.r;
import okhttp3.y;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteString f14671a = ByteString.encodeUtf8("\"\\");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteString f14672b = ByteString.encodeUtf8("\t ,=");

    public static long a(q qVar) {
        return h(qVar.c("Content-Length"));
    }

    public static long b(y yVar) {
        return a(yVar.h());
    }

    public static boolean c(y yVar) {
        if (yVar.o().f().equals("HEAD")) {
            return false;
        }
        int iC = yVar.c();
        return (((iC >= 100 && iC < 200) || iC == 204 || iC == 304) && b(yVar) == -1 && !"chunked".equalsIgnoreCase(yVar.f("Transfer-Encoding"))) ? false : true;
    }

    public static int d(String str, int i10) {
        try {
            long j10 = Long.parseLong(str);
            if (j10 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j10 < 0) {
                return 0;
            }
            return (int) j10;
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    public static void e(okhttp3.k kVar, r rVar, q qVar) {
        if (kVar == okhttp3.k.f11295a) {
            return;
        }
        List listF = okhttp3.j.f(rVar, qVar);
        if (listF.isEmpty()) {
            return;
        }
        kVar.a(rVar, listF);
    }

    public static int f(String str, int i10, String str2) {
        while (i10 < str.length() && str2.indexOf(str.charAt(i10)) == -1) {
            i10++;
        }
        return i10;
    }

    public static int g(String str, int i10) {
        char cCharAt;
        while (i10 < str.length() && ((cCharAt = str.charAt(i10)) == ' ' || cCharAt == '\t')) {
            i10++;
        }
        return i10;
    }

    public static long h(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }
}
