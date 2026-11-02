package r0;

import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class r implements q {

    /* renamed from: a, reason: collision with root package name */
    public final WebViewProviderFactoryBoundaryInterface f11518a;

    public r(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.f11518a = webViewProviderFactoryBoundaryInterface;
    }

    @Override // r0.q
    public String[] a() {
        return this.f11518a.getSupportedFeatures();
    }

    @Override // r0.q
    public DropDataContentProviderBoundaryInterface getDropDataProvider() {
        return (DropDataContentProviderBoundaryInterface) dc.a.a(DropDataContentProviderBoundaryInterface.class, this.f11518a.getDropDataProvider());
    }

    @Override // r0.q
    public ProxyControllerBoundaryInterface getProxyController() {
        return (ProxyControllerBoundaryInterface) dc.a.a(ProxyControllerBoundaryInterface.class, this.f11518a.getProxyController());
    }

    @Override // r0.q
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) dc.a.a(StaticsBoundaryInterface.class, this.f11518a.getStatics());
    }

    @Override // r0.q
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) dc.a.a(WebkitToCompatConverterBoundaryInterface.class, this.f11518a.getWebkitToCompatConverter());
    }
}
