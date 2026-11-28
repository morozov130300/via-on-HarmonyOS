package b8;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static f f1782c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1783a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f1784b = new HashMap();

    public static f c() {
        if (f1782c == null) {
            f1782c = new f();
        }
        return f1782c;
    }

    public final String a(String str, int i10) {
        return str + ':' + i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    public final int b(SslError sslError) {
        if (sslError == null) {
            return 0;
        }
        boolean zHasError = sslError.hasError(3);
        ?? r10 = zHasError;
        if (sslError.hasError(4)) {
            r10 = (zHasError ? 1 : 0) | 2;
        }
        ?? r11 = r10;
        if (sslError.hasError(1)) {
            r11 = (r10 == true ? 1 : 0) | 4;
        }
        ?? r12 = r11;
        if (sslError.hasError(2)) {
            r12 = (r11 == true ? 1 : 0) | 8;
        }
        ?? r13 = r12;
        if (sslError.hasError(0)) {
            r13 = (r12 == true ? 1 : 0) | 16;
        }
        return sslError.hasError(5) ? r13 | 32 : r13;
    }

    public int d(String str) {
        Integer num;
        if (str == null || str.isEmpty() || (num = (Integer) this.f1783a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public void e(String str, int i10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f1783a.put(str, Integer.valueOf(i10));
    }

    public List f(String str, SslError sslError) {
        return (List) this.f1784b.remove(a(str, b(sslError)));
    }

    public boolean g(String str, SslError sslError, SslErrorHandler sslErrorHandler) {
        String strA = a(str, b(sslError));
        List list = (List) this.f1784b.get(strA);
        if (list != null) {
            list.add(sslErrorHandler);
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(sslErrorHandler);
        this.f1784b.put(strA, arrayList);
        return false;
    }
}
