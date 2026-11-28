package r8;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.simpleframework.xml.strategy.Name;
import x8.a0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile f f12063b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f12064a = new a();

    public static f a() {
        if (f12063b == null) {
            synchronized (f.class) {
                try {
                    if (f12063b == null) {
                        f12063b = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12063b;
    }

    public void b(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("channel_");
        if (z10) {
            sb2.append("new_");
        }
        sb2.append(a0.a());
        d(sb2.toString());
    }

    public void c(String str, String str2, Throwable th) {
        if (str == null || str2 == null || th == null) {
            return;
        }
        this.f12064a.b(str, str2, th);
    }

    public final void d(String str) {
        this.f12064a.a(str, null);
    }

    public final void e(String str, Map map) {
        this.f12064a.a(str, map);
    }

    public void f(int i10) {
        HashMap map = new HashMap();
        map.put(Name.MARK, String.valueOf(i10));
        e("app_menu", map);
    }

    public void g(boolean z10) {
        HashMap map = new HashMap();
        map.put("s", z10 ? "1" : "0");
        e("fetch_conf", map);
    }

    public void h(String str) {
        d("search_" + str);
    }

    public void i(Context context) {
        Iterator it = this.f12064a.c().iterator();
        while (it.hasNext()) {
            if (((d) it.next()) instanceof b) {
                return;
            }
        }
        b bVar = new b(context);
        bVar.setEnabled(true);
        this.f12064a.d(bVar);
    }
}
