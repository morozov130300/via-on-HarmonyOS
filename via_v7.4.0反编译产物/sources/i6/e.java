package i6;

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e implements k0 {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f6988a;

    public e(WebView webView) {
        kotlin.jvm.internal.h.f(webView, "webView");
        this.f6988a = new WeakReference(webView);
    }

    public static final void d(q7.p pVar, String str) {
        if (str != null && str.length() > 2 && str.charAt(0) == '\"') {
            String strSubstring = str.substring(1, str.length() - 1);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            str = v7.m.I(v7.l.j(v7.l.j(strSubstring, "\\\"", "\"", false, 4, null), "\\\\", "\\", false, 4, null)).toString();
        }
        pVar.a(str, null);
    }

    @Override // i6.k0
    public boolean a() {
        WebSettings settings;
        WebView webView = (WebView) this.f6988a.get();
        if (webView == null || (settings = webView.getSettings()) == null) {
            return true;
        }
        return settings.getJavaScriptEnabled();
    }

    @Override // i6.k0
    public void b(String str, final q7.p pVar) {
        WebView webView = (WebView) this.f6988a.get();
        if (webView == null) {
            if (pVar != null) {
                pVar.a(null, "WebView reference is null");
            }
        } else if (str == null || str.length() == 0) {
            if (pVar != null) {
                pVar.a(null, "Script is empty");
            }
        } else if (pVar == null) {
            webView.evaluateJavascript(str, null);
        } else {
            webView.evaluateJavascript(str, new ValueCallback() { // from class: i6.d
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    e.d(pVar, (String) obj);
                }
            });
        }
    }

    @Override // i6.k0
    public String getUrl() {
        WebView webView = (WebView) this.f6988a.get();
        if (webView != null) {
            return webView.getUrl();
        }
        return null;
    }
}
