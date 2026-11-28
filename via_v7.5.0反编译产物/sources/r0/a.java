package r0;

import android.webkit.CookieManager;
import java.util.List;
import s0.v;
import s0.w;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static s0.i a(CookieManager cookieManager) {
        return w.c().a(cookieManager);
    }

    public static List b(CookieManager cookieManager, String str) {
        if (v.f12152a0.d()) {
            return a(cookieManager).a(str);
        }
        throw v.a();
    }
}
