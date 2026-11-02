package d8;

import android.os.SystemClock;
import java.util.HashMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static a f4583b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f4584a = new HashMap();

    public static a a() {
        if (f4583b == null) {
            f4583b = new a();
        }
        return f4583b;
    }

    public int b(String str, boolean z10) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        b bVar = (b) this.f4584a.get(str);
        if (bVar == null) {
            bVar = new b();
        }
        int iA = bVar.a(z10);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jB = jElapsedRealtime - bVar.b(z10);
        if (jB >= 60000) {
            iA = 0;
        } else if (iA < 30) {
            iA = Math.min(30, jB <= 5000 ? iA + 15 : jB <= 10000 ? iA + 10 : jB <= 30000 ? iA + 2 : iA + 1);
        }
        bVar.c(z10, iA);
        if (iA <= 30) {
            bVar.d(z10, jElapsedRealtime);
        }
        this.f4584a.put(str, bVar);
        if (iA < 30) {
            return 0;
        }
        return iA > 30 ? 2 : 1;
    }

    public void c(String str, boolean z10, boolean z11) {
        if (str == null || str.isEmpty()) {
            return;
        }
        b bVar = (b) this.f4584a.get(str);
        if (bVar == null) {
            bVar = new b();
        }
        if (bVar.a(z10) > 30) {
            return;
        }
        if (z11) {
            bVar.c(z10, 31);
        }
        bVar.d(z10, SystemClock.elapsedRealtime());
        this.f4584a.put(str, bVar);
    }
}
