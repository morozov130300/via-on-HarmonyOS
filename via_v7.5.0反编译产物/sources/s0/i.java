package s0;

import java.util.List;
import org.chromium.support_lib_boundary.WebViewCookieManagerBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebViewCookieManagerBoundaryInterface f12136a;

    public i(WebViewCookieManagerBoundaryInterface webViewCookieManagerBoundaryInterface) {
        this.f12136a = webViewCookieManagerBoundaryInterface;
    }

    public List a(String str) {
        return this.f12136a.getCookieInfo(str);
    }
}
