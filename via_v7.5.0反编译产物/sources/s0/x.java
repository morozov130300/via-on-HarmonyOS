package s0;

import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebViewProviderBoundaryInterface f12206a;

    public x(WebViewProviderBoundaryInterface webViewProviderBoundaryInterface) {
        this.f12206a = webViewProviderBoundaryInterface;
    }

    public n a(String str, String[] strArr) {
        return n.a(this.f12206a.addDocumentStartJavaScript(str, strArr));
    }

    public n b(String str, int i10, String[] strArr, String str2) {
        return n.a(this.f12206a.addJavaScriptOnEvent(str, strArr, i10, str2));
    }

    public void c(String str, String[] strArr, String str2, r0.k.a aVar) {
        this.f12206a.addWebMessageListener(str, strArr, hc.b.c(new r(aVar)), str2);
    }

    public void d(String str, String[] strArr, r0.k.a aVar) {
        this.f12206a.addWebMessageListener(str, strArr, hc.b.c(new r(aVar)));
    }

    public int e(String str) {
        return this.f12206a.getJavaScriptWorld(str);
    }

    public void f(String str) {
        this.f12206a.removeWebMessageListener(str);
    }

    public void g(String str, String str2) {
        this.f12206a.removeWebMessageListener(str, str2);
    }
}
