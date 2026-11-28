package c8;

import android.graphics.Bitmap;
import android.webkit.WebView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b1 extends q4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2168a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void K(WebView webView);

        void o(WebView webView);

        void q(String str);
    }

    public b1(a aVar) {
        this.f2168a = aVar;
    }

    @Override // q4.a
    public void o(t4.b bVar, String str) {
        if (s9.d.l(bVar.getContext(), str)) {
            this.f2168a.o(bVar);
        }
    }

    @Override // q4.a
    public void p(t4.b bVar, String str, Bitmap bitmap) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if ((str.startsWith("http://") || str.startsWith("https://")) && str.endsWith(".user.js")) {
            this.f2168a.q(str);
        }
        if (s9.d.l(bVar.getContext(), str)) {
            this.f2168a.o(bVar);
        } else {
            this.f2168a.K(bVar);
        }
    }
}
