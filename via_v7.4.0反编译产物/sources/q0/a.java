package q0;

import android.webkit.CookieManager;
import java.util.List;
import r0.i;
import r0.o;
import r0.p;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {
    public static i a(CookieManager cookieManager) {
        return p.c().a(cookieManager);
    }

    public static List b(CookieManager cookieManager, String str) {
        if (o.Z.d()) {
            return a(cookieManager).a(str);
        }
        throw o.a();
    }
}
