package c6;

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f implements c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f1975a;

    public f(WebView webView) {
        kotlin.jvm.internal.h.f(webView, "webView");
        this.f1975a = new WeakReference(webView);
    }

    public static final void c(p7.p pVar, String str) {
        if (str != null && str.length() > 2 && str.charAt(0) == '\"') {
            String strSubstring = str.substring(1, str.length() - 1);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            str = kotlin.text.z.v0(kotlin.text.x.z(kotlin.text.x.z(strSubstring, "\\\"", "\"", false, 4, null), "\\\\", "\\", false, 4, null)).toString();
        }
        pVar.invoke(str, null);
    }

    @Override // c6.c2
    public void a(String str, final p7.p pVar) {
        WebView webView = (WebView) this.f1975a.get();
        if (webView == null) {
            if (pVar != null) {
                pVar.invoke(null, "WebView reference is null");
            }
        } else if (str == null || str.length() == 0) {
            if (pVar != null) {
                pVar.invoke(null, "Script is empty");
            }
        } else if (pVar == null) {
            webView.evaluateJavascript(str, null);
        } else {
            webView.evaluateJavascript(str, new ValueCallback() { // from class: c6.e
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    f.c(pVar, (String) obj);
                }
            });
        }
    }

    @Override // c6.c2
    public String getUrl() {
        WebView webView = (WebView) this.f1975a.get();
        if (webView != null) {
            return webView.getUrl();
        }
        return null;
    }

    @Override // c6.c2
    public boolean isJavaScriptEnabled() {
        WebSettings settings;
        WebView webView = (WebView) this.f1975a.get();
        if (webView == null || (settings = webView.getSettings()) == null) {
            return true;
        }
        return settings.getJavaScriptEnabled();
    }
}
