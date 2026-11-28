package c8;

import android.graphics.Bitmap;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class j extends q4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b8.d f2225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f2226b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void A(boolean z10);

        WebResourceResponse T(WebResourceRequest webResourceRequest, String str, String str2);
    }

    public j(b8.d dVar, a aVar) {
        this.f2225a = dVar;
        this.f2226b = aVar;
    }

    @Override // q4.a
    public void G(t4.b bVar, int i10) {
        if (bVar == null) {
            return;
        }
        boolean z10 = (i10 & 1) == 1;
        this.f2225a.h(bVar.getTabId(), bVar.getId());
        if (z10) {
            this.f2226b.A(this.f2225a.g(bVar.getTabId()));
        }
    }

    @Override // q4.a
    public WebResourceResponse H(t4.b bVar, WebResourceRequest webResourceRequest, String str, String str2) {
        String str3;
        WebResourceResponse webResourceResponseT = this.f2226b.T(webResourceRequest, str, str2);
        if (!s9.d.l(bVar.getContext(), str) && !str.endsWith("via_inject_blocker.css")) {
            boolean zA = this.f2225a.a(bVar.getTabId(), bVar.getId(), str, webResourceResponseT != null, Build.VERSION.SDK_INT >= 21 && webResourceRequest.getRequestHeaders() != null && (str3 = (String) webResourceRequest.getRequestHeaders().get("Range")) != null && str3.startsWith("bytes=0-"));
            if (bVar.isShown()) {
                this.f2226b.A(zA);
            }
        }
        return webResourceResponseT;
    }

    @Override // q4.a
    public void p(t4.b bVar, String str, Bitmap bitmap) {
        this.f2225a.i(bVar.getTabId(), bVar.getId(), str);
    }
}
