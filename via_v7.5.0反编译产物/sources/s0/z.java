package s0;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class z implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebViewProviderFactoryBoundaryInterface f12207a;

    public z(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.f12207a = webViewProviderFactoryBoundaryInterface;
    }

    @Override // s0.y
    public String[] a() {
        return this.f12207a.getSupportedFeatures();
    }

    @Override // s0.y
    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        return (WebViewProviderBoundaryInterface) hc.b.a(WebViewProviderBoundaryInterface.class, this.f12207a.createWebView(webView));
    }

    @Override // s0.y
    public DropDataContentProviderBoundaryInterface getDropDataProvider() {
        return (DropDataContentProviderBoundaryInterface) hc.b.a(DropDataContentProviderBoundaryInterface.class, this.f12207a.getDropDataProvider());
    }

    @Override // s0.y
    public ProxyControllerBoundaryInterface getProxyController() {
        return (ProxyControllerBoundaryInterface) hc.b.a(ProxyControllerBoundaryInterface.class, this.f12207a.getProxyController());
    }

    @Override // s0.y
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) hc.b.a(StaticsBoundaryInterface.class, this.f12207a.getStatics());
    }

    @Override // s0.y
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) hc.b.a(WebkitToCompatConverterBoundaryInterface.class, this.f12207a.getWebkitToCompatConverter());
    }
}
