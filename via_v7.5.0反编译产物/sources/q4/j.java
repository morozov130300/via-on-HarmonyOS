package q4;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class j extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f11735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11737c;

    public j(a aVar) {
        this.f11735a = aVar;
    }

    public abstract boolean a(t4.b bVar, k kVar);

    public final void b(String str) {
        this.f11736b = str;
    }

    public final void c(WebView webView, String str) {
        if (this.f11737c) {
            return;
        }
        this.f11737c = true;
        if (webView instanceof t4.b) {
            b(((t4.b) webView).getReferer());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        this.f11735a.f((t4.b) webView, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.f11735a.o((t4.b) webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f11737c = true;
        b(str);
        this.f11735a.p((t4.b) webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (Build.VERSION.SDK_INT < 23 || webResourceRequest == null || !webResourceRequest.isForMainFrame() || webResourceRequest.getUrl() == null) {
            return;
        }
        this.f11735a.w((t4.b) webView, webResourceError.getErrorCode(), webResourceError.getDescription() == null ? null : webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.f11735a.u((t4.b) webView, httpAuthHandler, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.f11735a.x((t4.b) webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.shouldInterceptRequest(webView, str);
        }
        c(webView, str);
        return this.f11735a.H((t4.b) webView, null, str, this.f11736b);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return a((t4.b) webView, new k(str, 1, null, webView != null && (webView.getHitTestResult() == null || webView.getHitTestResult().getType() == 0)));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = false;
        if (i10 < 24 || webResourceRequest == null ? !(webView == null || (webView.getHitTestResult() != null && webView.getHitTestResult().getType() != 0)) : !(!webResourceRequest.isRedirect() && webResourceRequest.hasGesture())) {
            z10 = true;
        }
        return a((t4.b) webView, new k((i10 < 21 || webResourceRequest == null) ? null : webResourceRequest.getUrl().toString(), 1, webResourceRequest, z10));
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String string = (Build.VERSION.SDK_INT < 21 || webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        c(webView, string);
        return this.f11735a.H((t4.b) webView, webResourceRequest, string, this.f11736b);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        if (Build.VERSION.SDK_INT < 23) {
            this.f11735a.w((t4.b) webView, i10, str, str2);
        }
    }
}
