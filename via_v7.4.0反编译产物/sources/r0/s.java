package r0;

import android.webkit.CookieManager;
import android.webkit.WebSettings;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewCookieManagerBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public final WebkitToCompatConverterBoundaryInterface f11519a;

    public s(WebkitToCompatConverterBoundaryInterface webkitToCompatConverterBoundaryInterface) {
        this.f11519a = webkitToCompatConverterBoundaryInterface;
    }

    public i a(CookieManager cookieManager) {
        return new i((WebViewCookieManagerBoundaryInterface) dc.a.a(WebViewCookieManagerBoundaryInterface.class, this.f11519a.convertCookieManager(cookieManager)));
    }

    public n b(WebSettings webSettings) {
        return new n((WebSettingsBoundaryInterface) dc.a.a(WebSettingsBoundaryInterface.class, this.f11519a.convertSettings(webSettings)));
    }
}
