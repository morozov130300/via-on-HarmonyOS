package xb;

import java.util.List;
import okhttp3.q;
import okhttp3.r;
import okhttp3.y;
import okio.ByteString;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f14325a = ByteString.encodeUtf8("\"\\");

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f14326b = ByteString.encodeUtf8("\t ,=");

    public static long a(q qVar) {
        return h(qVar.c("Content-Length"));
    }

    public static long b(y yVar) {
        return a(yVar.i());
    }

    public static boolean c(y yVar) {
        if (yVar.o().f().equals("HEAD")) {
            return false;
        }
        int iD = yVar.d();
        return (((iD >= 100 && iD < 200) || iD == 204 || iD == 304) && b(yVar) == -1 && !"chunked".equalsIgnoreCase(yVar.g("Transfer-Encoding"))) ? false : true;
    }

    public static int d(String str, int i10) throws NumberFormatException {
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
        if (kVar == okhttp3.k.f10680a) {
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
