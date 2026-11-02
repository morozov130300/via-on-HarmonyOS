package t8;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.simpleframework.xml.strategy.Name;
import z8.c0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    public static volatile f f12288b;

    /* renamed from: a, reason: collision with root package name */
    public final e f12289a = new a();

    public static f a() {
        if (f12288b == null) {
            synchronized (f.class) {
                try {
                    if (f12288b == null) {
                        f12288b = new f();
                    }
                } finally {
                }
            }
        }
        return f12288b;
    }

    public void b(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("channel_");
        if (z10) {
            sb2.append("new_");
        }
        sb2.append(c0.a());
        c(sb2.toString());
    }

    public final void c(String str) {
        this.f12289a.a(str, null);
    }

    public final void d(String str, Map map) {
        this.f12289a.a(str, map);
    }

    public void e(int i10) {
        HashMap map = new HashMap();
        map.put(Name.MARK, String.valueOf(i10));
        d("app_menu", map);
    }

    public void f(boolean z10) {
        HashMap map = new HashMap();
        map.put("s", z10 ? "1" : "0");
        d("fetch_conf", map);
    }

    public void g(String str) {
        c("search_" + str);
    }

    public void h(Context context) {
        Iterator it = this.f12289a.b().iterator();
        while (it.hasNext()) {
            if (((d) it.next()) instanceof b) {
                return;
            }
        }
        b bVar = new b(context);
        bVar.setEnabled(true);
        this.f12289a.c(bVar);
    }
}
