package e8;

import android.graphics.Bitmap;
import android.webkit.WebView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i0 extends p4.a {

    /* renamed from: a, reason: collision with root package name */
    public final a f4830a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void M(WebView webView);

        void o(WebView webView);

        void q(String str);
    }

    public i0(a aVar) {
        this.f4830a = aVar;
    }

    @Override // p4.a
    public void n(t4.b bVar, String str) {
        if (u9.d.m(bVar.getContext(), str)) {
            this.f4830a.o(bVar);
        }
    }

    @Override // p4.a
    public void o(t4.b bVar, String str, Bitmap bitmap) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if ((str.startsWith("http://") || str.startsWith("https://")) && str.endsWith(".user.js")) {
            this.f4830a.q(str);
        }
        if (u9.d.m(bVar.getContext(), str)) {
            this.f4830a.o(bVar);
        } else {
            this.f4830a.M(bVar);
        }
    }
}
