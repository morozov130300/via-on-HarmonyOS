package d8;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    public static f f4596c;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f4597a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f4598b = new HashMap();

    public static f c() {
        if (f4596c == null) {
            f4596c = new f();
        }
        return f4596c;
    }

    public final String a(String str, int i10) {
        return str + ':' + i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int b(SslError sslError) {
        if (sslError == null) {
            return 0;
        }
        boolean zHasError = sslError.hasError(3);
        boolean z10 = zHasError;
        if (sslError.hasError(4)) {
            z10 = (zHasError ? 1 : 0) | 2;
        }
        boolean z11 = z10;
        if (sslError.hasError(1)) {
            z11 = (z10 ? 1 : 0) | 4;
        }
        boolean z12 = z11;
        if (sslError.hasError(2)) {
            z12 = (z11 ? 1 : 0) | '\b';
        }
        ?? r12 = z12;
        if (sslError.hasError(0)) {
            r12 = (z12 ? 1 : 0) | 16;
        }
        return sslError.hasError(5) ? r12 | 32 : r12;
    }

    public int d(String str) {
        Integer num;
        if (str == null || str.isEmpty() || (num = (Integer) this.f4597a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public void e(String str, int i10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f4597a.put(str, Integer.valueOf(i10));
    }

    public List f(String str, SslError sslError) {
        return (List) this.f4598b.remove(a(str, b(sslError)));
    }

    public boolean g(String str, SslError sslError, SslErrorHandler sslErrorHandler) {
        String strA = a(str, b(sslError));
        List list = (List) this.f4598b.get(strA);
        if (list != null) {
            list.add(sslErrorHandler);
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(sslErrorHandler);
        this.f4598b.put(strA, arrayList);
        return false;
    }
}
