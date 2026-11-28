package s0;

import android.webkit.CookieManager;
import android.webkit.WebSettings;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewCookieManagerBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebkitToCompatConverterBoundaryInterface f12135a;

    public a0(WebkitToCompatConverterBoundaryInterface webkitToCompatConverterBoundaryInterface) {
        this.f12135a = webkitToCompatConverterBoundaryInterface;
    }

    public i a(CookieManager cookieManager) {
        return new i((WebViewCookieManagerBoundaryInterface) hc.b.a(WebViewCookieManagerBoundaryInterface.class, this.f12135a.convertCookieManager(cookieManager)));
    }

    public t b(WebSettings webSettings) {
        return new t((WebSettingsBoundaryInterface) hc.b.a(WebSettingsBoundaryInterface.class, this.f12135a.convertSettings(webSettings)));
    }
}
