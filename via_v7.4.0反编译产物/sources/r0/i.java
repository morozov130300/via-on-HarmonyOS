package r0;

import java.util.List;
import org.chromium.support_lib_boundary.WebViewCookieManagerBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final WebViewCookieManagerBoundaryInterface f11473a;

    public i(WebViewCookieManagerBoundaryInterface webViewCookieManagerBoundaryInterface) {
        this.f11473a = webViewCookieManagerBoundaryInterface;
    }

    public List a(String str) {
        return this.f11473a.getCookieInfo(str);
    }
}
