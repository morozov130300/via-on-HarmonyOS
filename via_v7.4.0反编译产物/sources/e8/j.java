package e8;

import android.graphics.Bitmap;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j extends p4.a {

    /* renamed from: a, reason: collision with root package name */
    public final d8.d f4831a;

    /* renamed from: b, reason: collision with root package name */
    public final a f4832b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void B(boolean z10);

        WebResourceResponse X(WebResourceRequest webResourceRequest, String str, String str2);
    }

    public j(d8.d dVar, a aVar) {
        this.f4831a = dVar;
        this.f4832b = aVar;
    }

    @Override // p4.a
    public void D(t4.b bVar, int i10) {
        if (bVar == null) {
            return;
        }
        boolean z10 = (i10 & 1) == 1;
        this.f4831a.h(bVar.getTabId(), bVar.getId());
        if (z10) {
            this.f4832b.B(this.f4831a.g(bVar.getTabId()));
        }
    }

    @Override // p4.a
    public WebResourceResponse F(t4.b bVar, WebResourceRequest webResourceRequest, String str, String str2) {
        String str3;
        WebResourceResponse webResourceResponseX = this.f4832b.X(webResourceRequest, str, str2);
        if (!u9.d.m(bVar.getContext(), str) && !str.endsWith("via_inject_blocker.css")) {
            boolean zA = this.f4831a.a(bVar.getTabId(), bVar.getId(), str, webResourceResponseX != null, Build.VERSION.SDK_INT >= 21 && webResourceRequest.getRequestHeaders() != null && (str3 = (String) webResourceRequest.getRequestHeaders().get("Range")) != null && str3.startsWith("bytes=0-"));
            if (bVar.isShown()) {
                this.f4832b.B(zA);
            }
        }
        return webResourceResponseX;
    }

    @Override // p4.a
    public void o(t4.b bVar, String str, Bitmap bitmap) {
        this.f4831a.i(bVar.getTabId(), bVar.getId(), str);
    }
}
